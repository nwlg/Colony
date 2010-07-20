/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*******************************************************************************
**
** Advanced Distributed Learning Co-Laboratory (ADL Co-Lab) Hub grants you 
** ("Licensee") a non-exclusive, royalty free, license to use, modify and 
** redistribute this software in source and binary code form, provided that 
** i) this copyright notice and license appear on all copies of the software; 
** and ii) Licensee does not utilize the software in a manner which is 
** disparaging to ADL Co-Lab Hub.
**
** This software is provided "AS IS," without a warranty of any kind.  ALL 
** EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING 
** ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE 
** OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED.  ADL Co-Lab Hub AND ITS LICENSORS 
** SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF 
** USING, MODIFYING OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES.  IN NO 
** EVENT WILL ADL Co-Lab Hub OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, 
** PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
** INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE 
** THEORY OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE 
** SOFTWARE, EVEN IF ADL Co-Lab Hub HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH 
** DAMAGES.
**
*******************************************************************************/

package es.pode.adl.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Vector;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import java.util.logging.Logger;

import es.pode.adl.datamodels.DMErrorCodes;
import es.pode.adl.datamodels.DMInterface;
import es.pode.adl.datamodels.DMProcessingInfo;
import es.pode.adl.datamodels.SCODataManager;
import es.pode.adl.sequencer.ADLObjStatus;
import es.pode.adl.sequencer.ADLSequencer;
import es.pode.adl.sequencer.ADLValidRequests;
import es.pode.adl.sequencer.SeqActivity;
import es.pode.adl.sequencer.SeqActivityTree;
import es.pode.adl.sequencer.SeqObjective;
import es.pode.adl.util.RTEFileHandler;

/**
 * <strong>Filename:</strong> LMSCMIServletjava<br>
 * <br>
 * <strong>Description:</strong><br>
 * The LMSCMIServlet class handles the server side data model communication of
 * the Sample RTE.<br>
 * This servlet handles persistence of the SCORM Run-Time Environment Data Model
 * elements. Persistence is being handled via flat files and java object
 * serialization rather than through a database.<br>
 * <br>
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the SCORM Sample RTE 1.3. <br>
 * <br>
 * <strong>Implementation Issues:</strong><br>
 * This servlet works in conjunction with the <code>LMSRTEClient</code> applet
 * in the <code>org.adl.lms.client</code> package.<br>
 * <br>
 * <strong>Known Problems:</strong><br>
 * <br>
 * <strong>Side Effects:</strong><br>
 * <br>
 * <strong>References:</strong><br>
 * <ul>
 * <li>IMS SS Specification</li>
 * <li>SCORM 2004</li>
 * </ul>
 * 
 * @author ADL Technical Team
 */
public class LMSCMIServlet extends HttpServlet
{
   /**
    * This is the value used for the primary objective ID
    */
   private final String mPRIMARY_OBJ_ID = null;

   /**
    * This string contains the name of the SampleRTEFiles directory.
    */
   private String SRTEFILESDIR = null;

   /**
    * This method handles the 'POST' message sent to the servlet. This servlet
    * will handle <code>LMSServletRequest</code> objects and respond with a
    * <code>LMSServletResponse</code> object.
    * 
    * @param iRequest The request 'POST'ed to the servlet.
    * @param oResponse The response returned by the servlet.<br>
    *           <br>
    * @exception ServletException
    * @exception IOException <br>
    *               <br>
    * @see org.adl.samplerte.server#LMSServletRequest
    * @see org.adl.samplerte.server#LMSServletResponse
    * 
    * @throws ServletException
    */
   public void doPost(HttpServletRequest iRequest, HttpServletResponse oResponse) throws ServletException, IOException
   {
      Logger logger = Logger.getLogger("LMSCMIServlet");
      
      logger.info("entering: ---LMSCMIServlet.doPost()");
      logger.info("POST received by LMSCMIServlet");

      String scoFile = null;
      String userID = null;
      String userName = null;
      String courseID = null;
      String scoID = null;
      String numAttempt = null;
      String activityID = null;
      String sspServerLocation = null;
      
      LMSCMIServletRequest request = null;
      LMSCMIServletResponse response = null;
      
      SCODataManager mSCOData = null;
      
      try
      {
         logger.info("Requested session: " + iRequest.getRequestedSessionId());
         logger.info("query string: " + iRequest.getQueryString());
         logger.info("header string: " + iRequest.getContextPath());
         
        
         for( Enumeration e = iRequest.getHeaderNames(); e.hasMoreElements(); )
         {
            logger.info(e.nextElement().toString());
         }

         // Retrieve the current session ID
         HttpSession session = iRequest.getSession(false);
         //cambiamos la ruta!!
         SRTEFILESDIR = session.getAttribute("webPath") + File.separator + session.getAttribute("idSession")
         + File.separator + session.getAttribute("COURSEID");
         if( session == null )
         {
            logger.info("  ERROR - No session ID in LMSCMIServlet.");
         }
         else
         {
            logger.info("Session ID is: " + session.getId());
         }

         logger.info("Checking attributes");

         ObjectInputStream in = new ObjectInputStream(iRequest.getInputStream());

         logger.info("Created REQUEST object INPUT stream successfully");

         ObjectOutputStream out = new ObjectOutputStream(oResponse.getOutputStream());

         logger.info("Created RESPONSE object OUTPUT stream successfully");

         // Read the LMSCMIServletRequest object
         request = (LMSCMIServletRequest)in.readObject();

         // Set servlet state
         scoID = request.mStateID;
         activityID = request.mActivityID;
         courseID = request.mCourseID;
         userID = request.mStudentID;
         numAttempt = request.mNumAttempt;
         userName = request.mUserName;
         sspServerLocation = request.mSSPServerLocation;

         logger.info("ScoID: " + scoID);

         // Set the run-time data model path
         if( numAttempt != null )
         {
        	 //cambiamos de forma temporal!! C:\SCORM3EDSampleRTE102Files\admin\Course-4\scoidx__X        	 
//            scoFile = File.separator + SRTEFILESDIR + File.separator + userID + File.separator + courseID
//               + File.separator + scoID + "__" + numAttempt;        	
        	 scoFile = SRTEFILESDIR + File.separator + scoID + "__" + numAttempt;
         }
         else
         {
            logger.info("  ERROR: NULL # attempt");
            //este es el original lo cambiamos temp...
//            scoFile = File.separator + SRTEFILESDIR + File.separator + userID + File.separator + courseID
//               + File.separator + scoID;
            scoFile = SRTEFILESDIR + File.separator + scoID;
         }

         logger.info("Data model path:  " + scoFile);
         
         FileInputStream fi = null;
         ObjectInputStream fileIn = null;

         // Handle the request
         switch( request.mRequestType )
         {

            case LMSCMIServletRequest.TYPE_INIT:

               logger.info("CMI Servlet - doPost() - entering case INIT ");

               logger.info("Processing 'init' request");

               // create response object to return
               response = new LMSCMIServletResponse();

               // Serialize the users activity tree for the selected course

               SeqActivityTree mSeqActivityTree = new SeqActivityTree();
               //este es el original lo cambiamos temporalmente
//               String mTreePath = File.separator + SRTEFILESDIR + File.separator + userID + File.separator + courseID
//                  + File.separator + "serialize.obj";
               String mTreePath = SRTEFILESDIR + "/serialize.obj";
               
               FileInputStream mFileIn = new FileInputStream(mTreePath);
               ObjectInputStream mObjectIn = new ObjectInputStream(mFileIn);
               mSeqActivityTree = (SeqActivityTree)mObjectIn.readObject();
               mObjectIn.close();
               mFileIn.close();

               boolean newFile = true;
               RTEFileHandler fileHandler = new RTEFileHandler(SRTEFILESDIR);

               // Try to open the state file
               try
               {
                  fi = new FileInputStream(scoFile);
                  newFile = false;

               }
               catch( FileNotFoundException fnfe )
               {
                  logger.info("State file does not exist...");

                  // data model file does not exist so initialize values

                  logger.info("Created file handler");
                  logger.info("About to create file");

                  fileHandler.initializeStateFile(numAttempt, userID, userName, courseID, scoID, scoID,
                     sspServerLocation);

                  logger.info("after initialize state file");
                  logger.info("State File Created");

                  fi = new FileInputStream(scoFile);
               }

               logger.info("Created LMSSCODataFile File input stream " + "successfully");

               fileIn = new ObjectInputStream(fi);

               logger.info("Created OBJECT input stream successfully");

               // Initialize the new attempt
               mSCOData = (SCODataManager)fileIn.readObject();

               fileIn.close();
               fi.close();

               // Create the sequencer and set the tree
               ADLSequencer mSequencer = new ADLSequencer();
               ADLValidRequests mState = new ADLValidRequests();
               SeqActivity mSeqActivity = mSeqActivityTree.getActivity(scoID);
               mSequencer.setActivityTree(mSeqActivityTree);

               // get UIState
               mSequencer.getValidRequests(mState);
               response.mValidRequests = mState;
               logger.info("continue  " + response.mValidRequests.mContinue);
               logger.info("previous  " + response.mValidRequests.mPrevious);

               Vector mStatusVector = new Vector();

               mStatusVector = mSequencer.getObjStatusSet(scoID);

               ADLObjStatus mObjStatus = new ADLObjStatus();

               // Temporary variables for obj initialization
               int err = 0;
               String obj = new String();

               // Initialize Objectives based on global objectives
               if( mStatusVector != null )
               {
                  if( newFile )
                  {
                     for( int i = 0; i < mStatusVector.size(); i++ )
                     {
                        // initialize objective status from sequencer
                        mObjStatus = (ADLObjStatus)mStatusVector.get(i);

                        // Set the objectives id
                        obj = "cmi.objectives." + i + ".id";

                        err = DMInterface.processSetValue(obj, mObjStatus.mObjID, true, mSCOData);

                        // Set the objectives success status
                        obj = "cmi.objectives." + i + ".success_status";

                        if( mObjStatus.mStatus.equalsIgnoreCase("satisfied") )
                        {
                           err = DMInterface.processSetValue(obj, "passed", true, mSCOData);
                        }
                        else if( mObjStatus.mStatus.equalsIgnoreCase("notSatisfied") )
                        {
                           err = DMInterface.processSetValue(obj, "failed", true, mSCOData);
                        }

                        // Set the objectives scaled score
                        obj = "cmi.objectives." + i + ".score.scaled";

                        if( mObjStatus.mHasMeasure )
                        {
                           Double norm = new Double(mObjStatus.mMeasure);
                           err = DMInterface.processSetValue(obj, norm.toString(), true, mSCOData);
                        }
                     }
                  }
                  else
                  {
                     for( int i = 0; i < mStatusVector.size(); i++ )
                     {
                        int idx = -1;

                        // initialize objective status from sequencer
                        mObjStatus = (ADLObjStatus)mStatusVector.get(i);

                        // get the count of current objectives
                        DMProcessingInfo pi = new DMProcessingInfo();
                        int result = DMInterface.processGetValue("cmi.objectives._count", true, mSCOData, pi);

                        int objCount = ( new Integer(pi.mValue) ).intValue();

                        // Find the current index for this objective
                        for( int j = 0; j < objCount; j++ )
                        {
                           pi = new DMProcessingInfo();
                           obj = "cmi.objectives." + j + ".id";

                           result = DMInterface.processGetValue(obj, true, mSCOData, pi);

                           
                           if( pi.mValue.equals(mObjStatus.mObjID) )
                           {
                              
                              idx = j;
                              break;
                           }
                        }

                        if( idx != -1 )
                        {
                                            
                           // Set the objectives success status
                           obj = "cmi.objectives." + idx + ".success_status";

                           if( mObjStatus.mStatus.equalsIgnoreCase("satisfied") )
                           {
                              err = DMInterface.processSetValue(obj, "passed", true, mSCOData);
                           }
                           else if( mObjStatus.mStatus.equalsIgnoreCase("notSatisfied") )
                           {
                              err = DMInterface.processSetValue(obj, "failed", true, mSCOData);
                           }

                           // Set the objectives scaled score
                           obj = "cmi.objectives." + idx + ".score.scaled";

                           if( mObjStatus.mHasMeasure )
                           {
                              Double norm = new Double(mObjStatus.mMeasure);
                              err = DMInterface.processSetValue(obj, norm.toString(), true, mSCOData);
                           }
                        }
                        else
                        {
                           logger.info("  OBJ NOT FOUND --> " + mObjStatus.mObjID);
                        }

                     }
                  }
               }

               response.mActivityData = mSCOData;

               // Need to return time tracking information
               // -+- TODO -+-

               out.writeObject(response);
               logger.info("LMSCMIServlet processed init");

               break;

            case LMSCMIServletRequest.TYPE_GET:

               logger.info("Processing 'get' request");

               response = new LMSCMIServletResponse();

               // Try to open the state file
               try
               {
                  fi = new FileInputStream(scoFile);

                  logger.info("Created SCO data file input stream " + "successfully");

                  fileIn = new ObjectInputStream(fi);

                  logger.info("Created OBJECT input stream successfully");

                  response.mActivityData = (SCODataManager)fileIn.readObject();

               }
               catch( FileNotFoundException fnfe )
               {
                  logger.finer("ERROR == State data not created");

                  response.mError = "NO DATA";
               }

               fileIn.close();
               fi.close();

               out.writeObject(response);

               logger.info("LMSCMIServlet processed get for SCO Data\n");

               break;

            case LMSCMIServletRequest.TYPE_SET:

               logger.info("Processing 'set' request");

               response = handleData(request.mActivityData, userID, courseID,
                                       response, request, activityID, scoID, scoFile);

               out.writeObject(response);

               logger.info("LMSCMIServlet processed set.");

               break;

            case LMSCMIServletRequest.TYPE_TIMEOUT:

               logger.info("Processing 'timeout' request");

               // -+- TODO -+-

               logger.info("LMSCMIServlet processed 'timeout'");

               break;

            default:

               logger.info("ERROR:  Bad Request Type.");

               break;
         }

         // Close the input and output streams
         in.close();
         out.close();

      }
      catch( Exception e )
      {
         logger.severe(" :: doPost :: EXCEPTION");
         logger.severe(e.toString());
         //logger.severe(e);
      }
   }

   /**
    * This method handles processing of the core data being sent from the client
    * to the LMS. The data needs to be processed and made persistent.
    * 
    * @param iSCOData The run-time data to be processed.
    * @param iUserID The ID of the learner associated with the persisted run-time data.
    * @param iCourseID The ID of the course associated with the persisted run-time data.
    * @param iResponse The response of this servlet.
    * @param iRequest request issued by the LMS Client.
    * @param iActivityID The ID of the activity associated with the persisted run-time data.
    * @param iScoID The ID of the SCO associated with the persisted run-time data.
    * @param iScoFile The name of the target persisted run-time data model file.
    * @return An updated LMSCMIServletResponse response
    */
   private LMSCMIServletResponse handleData(SCODataManager iSCOData,
                           String iUserID,
                           String iCourseID,
                           LMSCMIServletResponse iResponse,
                           LMSCMIServletRequest iRequest,
                           String iActivityID,
                           String iScoID,
                           String iScoFile)
   {
      
      Logger logger = Logger.getLogger("org.adl.util.debug.samplerte");
      
      logger.info("LMSCMIServlet - Entering handleData()");
      iResponse = new LMSCMIServletResponse();

      String sampleRTERoot = "";
//      String userDir = sampleRTERoot + File.separator + iUserID + File.separator + iCourseID;
      String userDir = SRTEFILESDIR;
      boolean setPrimaryObjScore = false;

      boolean suspended = false;

      try
      {
         String completionStatus = null;
         String scoEntry = null;
         double normalScore = -1.0;
         String masteryStatus = null;
         String sessionTime = null;
         String score = null;

         SCODataManager scoData = iRequest.mActivityData;

         int err = 0;
         DMProcessingInfo dmInfo = new DMProcessingInfo();        
         
         // Get the current entry
         err = DMInterface.processGetValue("cmi.exit", true, true, scoData, dmInfo);
         scoEntry = dmInfo.mValue;         
         
         // call terminate on the sco data
         scoData.terminate();



         // Get the current completion_status
         err = DMInterface.processGetValue("cmi.completion_status", true, scoData, dmInfo);
         completionStatus = dmInfo.mValue;

         if( completionStatus.equals("not attempted") )
         {
            completionStatus = "incomplete";
         }

         // Get the current success_status
         err = DMInterface.processGetValue("cmi.success_status", true, scoData, dmInfo);
         masteryStatus = dmInfo.mValue;

         // Get the current entry
         err = DMInterface.processGetValue("cmi.entry", true, true, scoData, dmInfo);
         scoEntry = dmInfo.mValue;        

         // Get the current scaled score
         err = DMInterface.processGetValue("cmi.score.scaled", true, scoData, dmInfo);

         if( err == DMErrorCodes.NO_ERROR )
         {
            logger.info("Got score, with no error");
            score = dmInfo.mValue;
         }
         else
         {
            logger.info("Failed getting score, got err: " + err);
            score = "";
         }

         // Get the current session time
         err = DMInterface.processGetValue("cmi.session_time", true, scoData, dmInfo);
         if( err == DMErrorCodes.NO_ERROR )
         {
            sessionTime = dmInfo.mValue;
         }

         logger.info("Saving Data to the File ...  PRIOR TO SAVE");
         logger.info("The SCO Data Manager for the current SCO contains the " + "following:");

         // Open the Activity tree flat file associated with the
         // logged in user
         String theWebPath = getServletConfig().getServletContext().getRealPath("/");

         String actFile = userDir + File.separator + "serialize.obj";

         // Only perform data mapping on Terminate
         if( iRequest.mIsFinished )
         {
            logger.info("About to get and update activity tree");

            FileInputStream fi;
            try
            {
               fi = new FileInputStream(actFile);
            }
            catch( FileNotFoundException fnfe )
            {
               logger.finer("Can not open Activity tree file");

               fi = new FileInputStream(actFile);
            }

            logger.info("Created Activity FILE input stream successfully");

            ObjectInputStream fileIn = new ObjectInputStream(fi);

            logger.info("Created Activity Tree OBJECT input stream " + "successfully");

            SeqActivityTree theTree = (SeqActivityTree)fileIn.readObject();
            fileIn.close();
            fi.close();

            logger.info("(*********DUMPING ActivityTree***********)");
            if( theTree == null )
            {

               logger.info("The activity tree is NULL");
            }
            else
            {
               theTree.dumpState();
            }

            if( theTree != null )
            {
               // Create the sequencer and set the tree
               ADLSequencer theSequencer = new ADLSequencer();
               theSequencer.setActivityTree(theTree);

               SeqActivity act = theTree.getActivity(iActivityID);

               // Only modify the TM if the activity is tracked
               if( act.getIsTracked() )
               {

                  // Update the activity's status
                  logger.info(act.getID() + " is TRACKED -- ");
                  logger.info("Performing default mapping to TM");

                  String primaryObjID = null;
                  boolean foundPrimaryObj = false;
                  boolean setPrimaryObjSuccess = false;
                  boolean sesPrimaryObjScore = false;

                  // Find the primary objective ID
                  Vector objs = act.getObjectives();

                  if( objs != null )
                  {
                     for( int j = 0; j < objs.size(); j++ )
                     {
                        SeqObjective obj = (SeqObjective)objs.elementAt(j);
                        if( obj.mContributesToRollup )
                        {
                           if( obj.mObjID != null )
                           {
                              primaryObjID = obj.mObjID;
                           }
                           break;
                        }
                     }
                  }

                  // Get the activities objective list
                  // Map the DM to the TM
                  err = DMInterface.processGetValue("cmi.objectives._count", true, scoData, dmInfo);
                  Integer size = new Integer(dmInfo.mValue);
                  int numObjs = size.intValue();

                  // Loop through objectives updating TM
                  for( int i = 0; i < numObjs; i++ )
                  {
                     logger.info("CMISerlet - IN MAP OBJ LOOP");
                     String objID = new String("");
                     String objMS = new String("");
                     String objScore = new String("");
                     String obj = new String("");

                     // Get this objectives id
                     obj = "cmi.objectives." + i + ".id";
                     err = DMInterface.processGetValue(obj, true, scoData, dmInfo);

                     objID = dmInfo.mValue;

                     if( primaryObjID != null && objID.equals(primaryObjID) )
                     {
                        foundPrimaryObj = true;
                     }
                     else
                     {
                        foundPrimaryObj = false;
                     }

                     // Get this objectives mastery
                     obj = "cmi.objectives." + i + ".success_status";
                     err = DMInterface.processGetValue(obj, true, scoData, dmInfo);
                     objMS = dmInfo.mValue;

                     // Report the success status
                     if( objMS.equals("passed") )
                     {
                        theSequencer.setAttemptObjSatisfied(iActivityID, objID, "satisfied");
                        if( foundPrimaryObj )
                        {
                           setPrimaryObjSuccess = true;
                        }
                     }
                     else if( objMS.equals("failed") )
                     {
                        theSequencer.setAttemptObjSatisfied(iActivityID, objID, "notSatisfied");

                        if( foundPrimaryObj )
                        {
                           setPrimaryObjSuccess = true;
                        }
                     }
                     else
                     {
                        theSequencer.setAttemptObjSatisfied(iActivityID, objID, "unknown");
                     }

                     // Get this objectives measure
                     obj = "cmi.objectives." + i + ".score.scaled";
                     err = DMInterface.processGetValue(obj, true, scoData, dmInfo);
                     if( err == DMErrorCodes.NO_ERROR )
                     {
                        objScore = dmInfo.mValue;
                     }

                     // Report the measure
                     if( !objScore.equals("") && !objScore.equals("unknown") )
                     {
                        try
                        {
                           normalScore = ( new Double(objScore) ).doubleValue();
                           theSequencer.setAttemptObjMeasure(iActivityID, objID, normalScore);

                           if( foundPrimaryObj )
                           {
                              setPrimaryObjScore = true;
                           }
                        }
                        catch( Exception e )
                        {
                           logger.severe("  ::--> ERROR: Invalid score");
                           logger.severe("  ::  " + normalScore);

                           logger.severe(e.toString());
                           //logger.severe(e);
                        }
                     }
                     else
                     {
                        theSequencer.clearAttemptObjMeasure(iActivityID, objID);
                     }
                  }

                  // Report the completion status
                  theSequencer.setAttemptProgressStatus(iActivityID, completionStatus);

                  if( scoEntry.equals("resume") )
                  {
                     theSequencer.reportSuspension(iActivityID, true);
                  }
                  else
                  {

                     // Clean up session level SSP buckets
                     RTEFileHandler fileHandler = new RTEFileHandler(SRTEFILESDIR);
                     fileHandler.deleteAttemptSSPData(iUserID, iCourseID, iScoID);

                     theSequencer.reportSuspension(iActivityID, false);
                  }

                  // Report the success status
                  if( masteryStatus.equals("passed") )
                  {
                     theSequencer.setAttemptObjSatisfied(iActivityID, mPRIMARY_OBJ_ID, "satisfied");
                  }
                  else if( masteryStatus.equals("failed") )
                  {
                     theSequencer.setAttemptObjSatisfied(iActivityID, mPRIMARY_OBJ_ID, "notSatisfied");
                  }
                  else
                  {
                     if( !setPrimaryObjSuccess )
                     {
                        theSequencer.setAttemptObjSatisfied(iActivityID, mPRIMARY_OBJ_ID, "unknown");
                     }
                  }

                  // Report the measure
                  if( !score.equals("") && !score.equals("unknown") )
                  {
                     try
                     {
                        normalScore = ( new Double(score) ).doubleValue();
                        theSequencer.setAttemptObjMeasure(iActivityID, mPRIMARY_OBJ_ID, normalScore);
                     }
                     catch( Exception e )
                     {
                        logger.severe("  ::--> ERROR: Invalid score");
                        logger.severe("  ::  " + normalScore);

                        logger.severe(e.toString());
                        //logger.error(e);
                     }
                  }
                  else
                  {
                     if( !setPrimaryObjScore )
                     {
                        theSequencer.clearAttemptObjMeasure(iActivityID, mPRIMARY_OBJ_ID);
                     }
                  }
               }

               // May need to get the current valid requests
               iResponse.mValidRequests = new ADLValidRequests();
               theSequencer.getValidRequests(iResponse.mValidRequests);

               logger.info("Sequencer is initialized and statuses have been " + "set");
               logger.info("Now re-serialize the file");

               FileOutputStream fo = new FileOutputStream(actFile);

               ObjectOutputStream outFile = new ObjectOutputStream(fo);

               SeqActivityTree theTempTree = theSequencer.getActivityTree();

               theTempTree.clearSessionState();

               outFile.writeObject(theTempTree);
               outFile.close();
            }
         }

         // Persist the run-time data model
         FileOutputStream fo = new FileOutputStream(iScoFile);
         ObjectOutputStream outFile = new ObjectOutputStream(fo);
         outFile.writeObject(iRequest.mActivityData);
         outFile.close();
         fo.close();
      }
      catch( Exception e )
      {

         logger.severe(e.toString());
         

      }
      return iResponse;
   }

} // LMSCMIServlet
