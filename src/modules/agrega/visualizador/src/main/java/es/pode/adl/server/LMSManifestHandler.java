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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import es.pode.adl.debug.DebugIndicator;
import es.pode.adl.parsers.DOMTreeUtility;
import es.pode.adl.sequencer.ADLLaunch;
import es.pode.adl.sequencer.ADLSeqUtilities;
import es.pode.adl.sequencer.ADLSequencer;
import es.pode.adl.sequencer.SeqActivityTree;
import es.pode.adl.sequencer.SeqNavRequests;
import es.pode.adl.util.RTEFileHandler;
import es.pode.adl.validator.ADLValidatorOutcome;
import es.pode.adl.validator.contentpackage.CPValidator;
import es.pode.adl.validator.contentpackage.ManifestHandler;

/**
 * This class contains methods to parse an imsmanifest.xml file, process a 
 * content package,and simplify the access of data in a DOM tree that 
 * corresponds to the 
 * imsmanifest.xml file from a PIF.  <br><br>
 * 
 * <strong>Filename:</strong> LMSManifestHandler.java<br><br>
 * 
 * <strong>Description:</strong> <br><br>
 * This class contains methods used by the Sample Run-Time Environment to parse
 * the imsmanifest.xml file and process the content package using the ADL SCORM
 * Validator.  It also contains methods used by both the Sample Run-Time 
 * Environment and the ADL Sequencer to gain access to information in the 
 * imsmanifest.xml file.
 * <br><br>
 * 
 * <strong>Design Issues:</strong><br><br>
 * 
 * <strong>Implementation Issues:</strong><br><br>
 * 
 * <strong>Known Problems:</strong> <br><br>
 * 
 * <strong>Side Effects:</strong> <br><br>
 * 
 * <strong>References:</strong> SCORM <br><br>
 * 
 * @author ADL Technical Team
 */

public class LMSManifestHandler implements Serializable 
{
   /**
    * This is the DOM structure that will be returned with the 
    * ADLValidatorOutcome class.  It will contain all of the 
    * information contained in the imsmanifest file and will serve as a means
    * of accessing that information.
    */
   protected Document mDocument;

   /**
    * This is the title of the course.  It will be populated with the value of
    * the title attribute of an organization element.
    */
   protected String mCourseTitle;

   /**
    * This is the ID of the course.  It will be given the value of the
    * nextCourseID stored in the Application Data in the SampleRTE database.
    */
   protected String mCourseID;

   /**
    * This is the path that will be used when copying files.
    */
   protected String mWebPath;
  
   /**
    * This is a list of the &lt;organization&gt; elements in the manifest.
    */
   protected Vector mOrganizationList;

   /**
    * This vector will consist of LaunchData objects containing information
    * from the organization and resource elements which will be stored in the
    * SampleRTE database.
    */
   protected Vector mLaunchDataList;
   
   /**
    * Logger object used for debug logging.
    */
   private Logger mLogger = Logger.getLogger("org.adl.util.debug.samplerte");

   /**
    * The manifest element of the imsmanifest.xml file.
    */
   private Node mManifest;

   /**
    * The location of the schema xsd files.
    */
   private String mXSDLocation;

   /**
    * The result of the database update.
    */
   private boolean mDBUpdateResult = true;
   
   /**
    * The result of the file copy.
    */
   private boolean mFileCopyResult = true;
   
   /**
    * The result of the zip file extraction.
    */
   private boolean mZipExtractionResult = true;
   
   private String mIdSession;
   
   /**
    * Default constructor method which initializes member variables
    * 
    * @param iXSDLocation
    *           The location where the XSDs can be found for use 
    *           during validation.
    * 
    */ 
   public LMSManifestHandler( String iXSDLocation )
   {
      mDocument = null;
      mOrganizationList = new Vector();
      mLaunchDataList = new Vector();
      mCourseTitle = "";
      mCourseID = "";
      mManifest = null;
      mXSDLocation = iXSDLocation;
      mWebPath = "";
      mIdSession="";     
   }

   /**
    * Sets up the String of schema locations
    *
    * @param iExtendedSchemaLocations
    *               The schema locations extended by the vendor.
    *               <br><br>
    *
    *               <strong>Implementation Issues:</strong><br>
    *               The 80th column Java Coding Standard is not followed here
    *               due to the need to represent an exact string for schema
    *               locations.<br><br>
    *
    * @return String representing all of the schema locations needed.
    */
   private String getSRTESchemaLocations( String iExtendedSchemaLocations )
   {
      mLogger.entering("---LMSManifestHandler", "getSRTESchemaLocations()");
      String result = new String();
      
      String xsdLocation = mXSDLocation;
      xsdLocation = "file:///" + xsdLocation + File.separator + "xml" + 
                    File.separator + "xsd" + File.separator;

      
      xsdLocation = xsdLocation.replaceAll( " ", "%20");

      xsdLocation = xsdLocation.replace( '\\', '/');

      mLogger.info("+++++++++++xsdLocation IS: " + xsdLocation +
                        "+++++++++++++++++++");

      result = "http://www.imsglobal.org/xsd/imscp_v1p1 " +
                xsdLocation +"imscp_v1p1.xsd " +
               "http://www.w3.org/XML/1998/namespace " +
                "xml.xsd " +
               "http://www.adlnet.org/xsd/adlcp_v1p3 " +
                xsdLocation + "adlcp_v1p3.xsd " +
               "http://www.adlnet.org/xsd/adlseq_v1p3 " +
                xsdLocation + "adlseq_v1p3.xsd " +
               "http://www.adlnet.org/xsd/adlnav_v1p3 " +
                xsdLocation + "adlnav_v1p3.xsd " +
               "http://www.imsglobal.org/xsd/imsss " +
                xsdLocation + "imsss_v1p0.xsd " +
               "http://ltsc.ieee.org/xsd/LOM " +
               xsdLocation + "lomStrict.xsd";


      mLogger.info("+++++++++++RESULT IS: " + result + 
                         "+++++++++++++++++++");
      if ( ! iExtendedSchemaLocations.equals("") )
      {
         result = result + " " + iExtendedSchemaLocations;
      }

      return result;
   }


   /**
    * Uses the CPValidator and ADLValidatorOutcome classes of the 
    * <code>ADLValidator</code> to parse a manifest file and to create the 
    * corresponding DOM tree.  This tree is then traversed (with the use of 
    * additional <code>LMSManifestHandler</code> methods, appropriate 
    * database inserts are performed, a template activity tree is created
    * using the ADLSeqUtilities class, and serialized files are created for 
    * each organization element in the manfest.  
    * <br><br>
    * 
    * @param iFilePath - A string representing the path of the file to be 
    *                   validated.
    * @param iValidate - A boolean value representing whether or not validation
    *                    should be performed.
    * 
    * @return An ADLValidator object containing the DOM object as well as 
    * validation results.
    */
   public ADLValidatorOutcome processPackage( String iFilePath, 
                                              boolean iValidate )
   {
      String iExtendedSchemaLocations = "";
      
      
      mLogger.entering("---LMSManifestHandler", "processManifest()");

      String SRTE_EnvironmentVariable = mXSDLocation;
      CPValidator scormvalidator = new CPValidator( SRTE_EnvironmentVariable );
      scormvalidator.setSchemaLocation( getSRTESchemaLocations(
                                     iExtendedSchemaLocations ) );
      //Turn validation on or off
      scormvalidator.setPerformValidationToSchema( iValidate );

      scormvalidator.validate( iFilePath, "", "contentaggregation", false );
      
      mZipExtractionResult = scormvalidator.getZipExtractionResult();

      // retrieve object that stores the results of the validation activites
      ADLValidatorOutcome outcome = scormvalidator.getADLValidatorOutcome();

      try
      {
         mLogger.info( "Document parsing complete." ); 

         if ( (!iValidate && outcome.getDoesIMSManifestExist()  &&
               outcome.getIsWellformed() && outcome.getIsValidRoot()) || 
               (iValidate && 
               (outcome.getDoesIMSManifestExist() && 
                outcome.getIsValidRoot() && 
                outcome.getIsWellformed() && 
                outcome.getIsValidToSchema() &&
                outcome.getIsValidToApplicationProfile() && 
                outcome.getDoRequiredCPFilesExist() &&
                mZipExtractionResult )) )
         {
            outcome.rollupSubManifests( false );
            mDocument = outcome.getDocument();

            mLaunchDataList = scormvalidator.getLaunchData(
                        mDocument, false, false);

            this.mManifest = mDocument.getDocumentElement();

            // get information from manifest and update database
            mOrganizationList = this.getOrganizationList();
            //mDBUpdateResult = updateDB();
            updateSerializeOb();
           
         }
         else
         {           
            if (!(outcome.getIsWellformed())) 
            {
               mLogger.info("NOT WELL FORMED!!!");
            }
            if (!(outcome.getIsValidRoot()))
            {
               mLogger.info("INVALID ROOT!!!");
            }
            if (!(outcome.getIsValidToSchema()))
            {
               mLogger.info("NOT VALID TO SCHEMA!!!");
            }
            if (!(outcome.getIsValidToApplicationProfile())) 
            {
               mLogger.info("NOT VALID TO APP PROFILE!!!");
            }
            if (!(outcome.getDoRequiredCPFilesExist())) 
            {
               mLogger.info("REQUIRED FILES DO NOT EXIST!!!");
            }

            mLogger.info("-----NOT CONFORMANT!!!----");
         }
         
         if ( !mDBUpdateResult )
         {
//            DetailedLogMessageCollection.getInstance().addMessage(
//                  new LogMessage(MessageType.FAILED, 
//                        Messages.getString("Database Update Error Has Occurred")));           
         }
         if ( !mFileCopyResult )
         {
//            DetailedLogMessageCollection.getInstance().addMessage(
//                  new LogMessage(MessageType.FAILED, 
//                        Messages.getString("File Copy Error Has Occurred")));
         }
         if ( !mZipExtractionResult )
         {
//            DetailedLogMessageCollection.getInstance().addMessage(
//                  new LogMessage(MessageType.FAILED, 
//                        Messages.getString("Zip Extraction Error Has Occurred")));
         }

        
      }

      catch(Exception e)
      {
         e.printStackTrace();
      }

//      scormvalidator.cleanImportDirectory( mXSDLocation + File.separator  + "PackageImport" );
      //aqui ya tenemos esos valores inicializados desde updateSerializeOb()
      RTEFileHandler fileHandler = new RTEFileHandler(mWebPath + File.separator + mIdSession + File.separator + mCourseID);
      //fileHandler.deleteTempUloadFiles(); //no tenemos la carpeta tempUploads de la que borrar

      mLogger.exiting( "---LMSManifestHandler", "processManifest()" ); 
      //  Return boolean signifying whether or not the parsing was successful
      return outcome;   
   }


   /**
    * This method will copy a course from the specified directory where it
    * already exists, to a new specified directory where it is to be copied to.
    * 
    * @param iInFilePath - The path of the current file or directory that needs
    *                      to be copied.
    * @param iOutFilePath - The path of the directory that the file is to be
    *                       copied to.
    */
   private boolean copyCourse( String iInFilePath, String iOutFilePath ) 
   {
      boolean result = true;
      try
      {
         String inDirName = iInFilePath;
         inDirName.replace('/',java.io.File.separatorChar);

         File tempFile = new File(inDirName);
         File[] fileNames = tempFile.listFiles();

         String outDirName = iOutFilePath;

         outDirName = outDirName.replace('/',java.io.File.separatorChar);
         File tempDir = new File(outDirName);
         tempDir.mkdirs();
         
         FileInputStream fi = null;
         FileOutputStream fo = null;
         BufferedInputStream in = null;
         BufferedOutputStream out = null;
           
         for ( int i=0; i < fileNames.length; i++ )
         {
            String tempString = outDirName + java.io.File.separatorChar + 
                                                fileNames[i].getName();
            if ( fileNames[i].isDirectory() )
            {
               File dirToCreate = new File(tempString);
               dirToCreate.mkdirs();
               result = copyCourse( fileNames[i].getAbsolutePath(), tempString );
            }
            else
            {
               fi = new FileInputStream(fileNames[i]);
               fo = new FileOutputStream(tempString);
               in = new BufferedInputStream( fi );
               out = new BufferedOutputStream( fo );
               int c;
               while ((c = in.read()) != -1) 
               {
                  out.write(c);
               }

               in.close();
               fi.close();
               out.close();
               fo.close();
            }
         }
      }
      catch ( IOException ioe )
      {
         result = false;
         if ( DebugIndicator.ON )
         {
            ioe.printStackTrace(); 
         }
      }
      return result;
         
   }

   public Vector getLaunchDataList()
   {
	 return this.mLaunchDataList;   
   }
   
   /**
    *
    * This method will return the course ID.
    * 
    * @return A string containing the course ID.       
    */
   public String getCourseID()
   {
      return this.mCourseID;
   }

   public String getWebPath()
   {
	   return this.mWebPath;
   }
   
   //Añadido este método
   public void setCourseID(String mCourseID) {
	   this.mCourseID=mCourseID;
   }
   
   public void setIdSession(String mIdSession) {
	   this.mIdSession=mIdSession;
   }
   
   public String getIdSession() {
	   return this.mIdSession;
   }
   
   /**
    * This method gets a list of the &lt;organization&gt; elements in the manifest.
    * 
    * @return A vector containing the &ltorganization&gt nodes.
    */
   protected Vector getOrganizationList()
   {
      return ManifestHandler.getOrganizationNodes(mManifest, false);
   }

   /**
    * This method gets the sequencingCollection node from the DOM tree.
    * 
    * @return The sequencingCollection node from the DOM tree.
    */
   public Node getSeqCollection()
   {
      return DOMTreeUtility.getNode( mManifest, "sequencingCollection" );
   }

   /**
    * This method determines if a package processing error has occurred.
    * 
    * @return A boolean containing the status of package processing.
    */
   public boolean getPackageProcessingStatus()
   {      
      return mDBUpdateResult && mFileCopyResult && mZipExtractionResult;
   }
   
   /**
    * This method sets mCourseTitle to the value passed in with courseTitle.
    * 
    * @param iCourseTitle The title of the course.
    */
   public void setCourseName( String iCourseTitle )
   {
      this.mCourseTitle = iCourseTitle;
   }

   /**
    * This method sets the web path.
    * 
    * @param iWebPath The web path.
    */
   public void setWebPath( String iWebPath )
   {
      this.mWebPath = iWebPath;
      mLogger.info("***MWEBPATH IS " + mWebPath + "***");
   }
      
   ////////////////////////
protected void updateSerializeOb() {
	   
	   SeqActivityTree mySeqActivityTree;
	   try{
		   
		   for ( int j=0; j < mOrganizationList.size(); j++ ) 
	         {           
	            Node tempOrganization = (Node)mOrganizationList.elementAt(j);
		   
	            //Copy course files from the temp directory and serialize
//		           String copyInDirName = mWebPath + "PackageImport";
//		           String copyOutDirName = mWebPath + "CourseImports" + 
//		                                        java.io.File.separatorChar + mCourseID;
//		
//		           copyCourse( copyInDirName, copyOutDirName );
		           
		           //create a SeqActivityTree and serialize it
		           mySeqActivityTree = new SeqActivityTree();
		
		           String tempObjectivesGlobalToSystem = DOMTreeUtility.
		               getAttributeValue( tempOrganization,"objectivesGlobalToSystem" );
		
		           // include sequencing collection as a parameter as well as 
		           // the organization node.
		           mySeqActivityTree = ADLSeqUtilities.buildActivityTree(tempOrganization, 
		                                                                 getSeqCollection()); //dev. solo relleno el mRoot
		
		           if( tempObjectivesGlobalToSystem.equals("false") )
		           {
		              mySeqActivityTree.setScopeID(mCourseID);
		           }
		
		           mySeqActivityTree.setCourseID(mCourseID);
		           Vector theGobalObjectiveList = mySeqActivityTree.getGlobalObjectives();
		           HashMap datosObjs = new HashMap();
		           ADLSeqUtilities.createGlobalObjs("admin", "", theGobalObjectiveList, datosObjs);
		         
//		           String serializeFileName = mWebPath + "CourseImports" + File.separator + mCourseID 
//		                                                + File.separator + "serialize.obj";
		           String pathSerialize = mWebPath + File.separator + mIdSession + File.separator + mCourseID;
		           File filePathSerialize = new File(pathSerialize);
		           if (!filePathSerialize.exists()) {
		        	   filePathSerialize.mkdirs();
		           }
		           filePathSerialize=null;
		           String serializeFileName = pathSerialize + File.separator + "serialize.obj";
		           java.io.File serializeFile = new java.io.File(serializeFileName);
		           
		           FileOutputStream outFile = new FileOutputStream(serializeFile);
		           ObjectOutputStream s = new ObjectOutputStream(outFile);
		           s.writeObject(mySeqActivityTree);
		           s.flush(); 
		           s.close();
		           outFile.close();
		           		           
		           
		           /////////////////////////////////////////////////////////
		           ADLSequencer theSequencer = new ADLSequencer();
		           ADLLaunch launch = new ADLLaunch();
		
		           theSequencer.setActivityTree(mySeqActivityTree);
		
		          launch = theSequencer.navigate(SeqNavRequests.NAV_NONE);
	         }
	   
	   } catch (Exception e) {
		   mLogger.info("Se ha producido un error !!");
		   e.printStackTrace();
	}
	   
   }
   //////////////////////
   /**
    * This method takes the relevant information from the
    * populated parser structure and writes it to a related 
    * database.  This is done so that the JSP coding is 
    * more straight forward.
    */   
//   protected boolean updateDB() 
//   {         
//      mLogger.entering("---LMSManifestHandler", "updateDB()  *********");
//
//      boolean result = true;
//      SeqActivityTree mySeqActivityTree;
//    
//      try
//      {       
//         // Set up the database connection information.
//                 
//         Connection conn = LMSDatabaseHandler.getConnection();
//         // Prepare statements
//         PreparedStatement stmtSelectCID;
//         PreparedStatement stmtUpdateCID;
//         PreparedStatement stmtInsertCourse;
//         PreparedStatement stmtInsertItem;
//         PreparedStatement stmtUpdateCourse;
//
//         String sqlSelectCourseID
//         = "SELECT * FROM ApplicationData WHERE dataName = ?";
//
//         String sqlUpdateCourseID
//         = "UPDATE ApplicationData SET numberValue = ? WHERE dataName = ?";
//         
//         String sqlUpdateCourse
//         = "UPDATE CourseInfo SET Start = ?, TOC = ? WHERE CourseID = ?";
//                     
//         String sqlInsertCourse
//         = "INSERT INTO CourseInfo (CourseID, CourseTitle, Active, " + 
//            "ImportDateTime) VALUES(?, ?, ?, ?)";
//
//         String sqlInsertItem
//            = "INSERT INTO ItemInfo (CourseID, OrganizationIdentifier, " +
//              "ItemIdentifier, Type, Title, " + "Launch, ParameterString, " + 
//              "DataFromLMS, TimeLimitAction, " + 
//              "MinNormalizedMeasure, AttemptAbsoluteDurationLimit, " +
//              "CompletionThreshold, Next, Previous, Exit, ExitAll, Abandon, " +
//              "ResourceIdentifier, Suspend) " +
//              "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//         stmtSelectCID = conn.prepareStatement( sqlSelectCourseID );
//         stmtUpdateCID = conn.prepareStatement( sqlUpdateCourseID );
//         stmtInsertCourse = conn.prepareStatement( sqlInsertCourse );
//         stmtInsertItem = conn.prepareStatement( sqlInsertItem );
//         stmtUpdateCourse = conn.prepareStatement( sqlUpdateCourse );
//         
//         ResultSet selectCourseIDRS = null;
//
//         // loop through all organizations performing the database updates and
//         // sequencing actions for each one.      
//         for ( int j=0; j < mOrganizationList.size(); j++ ) 
//         {           
//            Node tempOrganization = (Node)mOrganizationList.elementAt(j);
//            String tempOrgIdentifier = DOMTreeUtility.getAttributeValue
//               (tempOrganization, "identifier" );
//            Node tempOrgTitleNode = DOMTreeUtility.getNode
//               ( tempOrganization, "title" );
//            String tempOrgTitle = DOMTreeUtility.getNodeValue
//               ( tempOrgTitleNode );
//
//            // Get the next course id from the application data table
//            synchronized( stmtSelectCID )
//            {
//               stmtSelectCID.setString(1, "nextCourseID" );
//               selectCourseIDRS = stmtSelectCID.executeQuery();  
//            }
//
//
//            if ( selectCourseIDRS.next() )
//            {
//               int idvalue = selectCourseIDRS.getInt( "numberValue" );
//               mCourseID = "Course-" + idvalue;
//
//               idvalue++;
//
//               // increase the course id by one
//               synchronized( stmtUpdateCID )
//               {
//                  stmtUpdateCID.setInt( 1, idvalue );
//                  stmtUpdateCID.setString( 2, "nextCourseID" );
//                  stmtUpdateCID.executeUpdate();
//               }
//               
//               SimpleDateFormat date = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");
//               
//               // Insert the course into the course Info table
//               synchronized( stmtInsertCourse )
//               {
//                  stmtInsertCourse.setString( 1, mCourseID );
//                  stmtInsertCourse.setString( 2, tempOrgTitle );
//                  stmtInsertCourse.setBoolean(3, true);
//                   
//                  // Encode the timestamp to allow foreign characters
//                  String temp = date.format(new Date());
//                  temp = new String(temp.getBytes("UTF-16"), "UTF-16");                  
//                  stmtInsertCourse.setString( 4, temp);
//                  
//                  stmtInsertCourse.executeUpdate();
//               }
//
//               // Create a temporary LaunchData object
//               LaunchData ld = new LaunchData();
//                
//               // Loop through each item in the course adding it to the database
//               for ( int i = 0; i < mLaunchDataList.size(); i++ )
//               {  
//                  ld = (LaunchData)mLaunchDataList.elementAt(i);
//
//                  // If the organization identifier of the current launch data
//                  // equals the identifier of the current entry of the
//                  // organization list, perform the database updates.
//                  if (ld.getOrganizationIdentifier().equals(tempOrgIdentifier))
//                  {           
//                     // Decode the URL before inserting into the database
//                	 decodeHandler decoder = new decodeHandler( ld.getLocation(), "UTF-8");
//                  	 decoder.decodeName();
//                  	 
//                     String alteredLocation = new String();
//                
//                     //If it's blank or it's external, don't concatenate to the 
//                     //local Web root.
//                     if ((ld.getLocation().equals(""))||
//                         (ld.getLocation().startsWith("http://"))||
//                         (ld.getLocation().startsWith("https://")))
//                     {
//                    	                    	
//                    	alteredLocation = decoder.getDecodedFileName(); 
//                        if ( !(ld.getParameters().equals("")) && 
//                              !(ld.getParameters() == null ) )
//                        {
//                           alteredLocation = addParameters(alteredLocation, 
//                                                        ld.getParameters());
//                        }
//                           
//                     }
//                     else
//                     {                    	                    	
//                        // Create the altered location (with decoded url)
//                        alteredLocation = "/adl/CourseImports/" + mCourseID +"/" 
//                                          + decoder.getDecodedFileName();
//                    	
//                        if ( !(ld.getParameters().equals("")) && 
//                              !(ld.getParameters() == null ) )
//                        {
//                           alteredLocation = addParameters(alteredLocation, 
//                                                        ld.getParameters());
//                        }
//
//                     }
//                     
//                     // Insert into the database
//                     synchronized( stmtInsertItem )
//                     {
//                        stmtInsertItem.setString(1, mCourseID);
//                        stmtInsertItem.setString(2, ld.
//                                                 getOrganizationIdentifier());
//                        stmtInsertItem.setString(3, ld.getItemIdentifier());
//                        
//                        stmtInsertItem.setString(4, ld.getSCORMType());
//                        stmtInsertItem.setString(5, ld.getItemTitle());
//                        stmtInsertItem.setString(6, alteredLocation);
//                        stmtInsertItem.setString(7, ld.getParameters());                        
//
//                        stmtInsertItem.setString(8, ld.getDataFromLMS());
//                        stmtInsertItem.setString(9, ld.getTimeLimitAction());
//                        stmtInsertItem.setString(10, 
//                                                 ld.getMinNormalizedMeasure());
//                        stmtInsertItem.setString(11, ld.
//                                             getAttemptAbsoluteDurationLimit());
//                        stmtInsertItem.setString(12, ld.getCompletionThreshold()
//                                                 );
//                        stmtInsertItem.setBoolean(13, ld.getContinue() );
//                        stmtInsertItem.setBoolean(14, ld.getPrevious() );
//                        stmtInsertItem.setBoolean(15, ld.getExit() );
//                        stmtInsertItem.setBoolean(16, ld.getExitAll() );
//                        stmtInsertItem.setBoolean(17, ld.getAbandon() );
//                        stmtInsertItem.setString(18, 
//                                                 ld.getResourceIdentifier() );
//                        stmtInsertItem.setBoolean(19, ld.getSuspendAll() );
//                        stmtInsertItem.executeUpdate();
//                     }    
//                  }
//               } 
//            }
//
//            //Copy course files from the temp directory and serialize
//            String copyInDirName = mWebPath + "PackageImport";
//            String copyOutDirName = mWebPath + "CourseImports" + 
//                                         java.io.File.separatorChar + mCourseID;
//
//            mFileCopyResult = copyCourse( copyInDirName, copyOutDirName );
//            
//            // If files failed to copy, delete the course from the database
//            if ( !mFileCopyResult )
//            {               
//               PreparedStatement stmtDeleteCourse1;
//               String sqlDeleteCourse1 = "DELETE FROM CourseInfo WHERE CourseID = ?";
//               PreparedStatement stmtDeleteCourse2;
//               String sqlDeleteCourse2 = "DELETE FROM ItemInfo WHERE CourseID = ?";
//               conn = LMSDatabaseHandler.getConnection();
//               stmtDeleteCourse1 = conn.prepareStatement(sqlDeleteCourse1);
//               stmtDeleteCourse2 = conn.prepareStatement(sqlDeleteCourse2);
//               synchronized (stmtDeleteCourse1)
//               {                  
//                  stmtDeleteCourse1.setString(1, mCourseID);
//                  stmtDeleteCourse1.executeUpdate();
//               }
//               stmtDeleteCourse1.close();
//               synchronized (stmtDeleteCourse2)
//               {                  
//                  stmtDeleteCourse2.setString(1, mCourseID);
//                  stmtDeleteCourse2.executeUpdate();
//               }
//               stmtDeleteCourse2.close();
//            }
//            
//            //create a SeqActivityTree and serialize it
//            mySeqActivityTree = new SeqActivityTree();
//
//            String tempObjectivesGlobalToSystem = DOMTreeUtility.
//                getAttributeValue( tempOrganization,"objectivesGlobalToSystem" );
//
//            // include sequencing collection as a parameter as well as 
//            // the organization node.
//            mySeqActivityTree = ADLSeqUtilities.buildActivityTree(tempOrganization, 
//                                                                  getSeqCollection());
//
//            if( tempObjectivesGlobalToSystem.equals("false") )
//            {
//               mySeqActivityTree.setScopeID(mCourseID);
//            }
//
//            mySeqActivityTree.setCourseID(mCourseID);
//            
//
//            String serializeFileName = mWebPath + "CourseImports" + File.separator + mCourseID 
//                                                 + File.separator + "serialize.obj";
//            java.io.File serializeFile = new java.io.File(serializeFileName);
//            
//            FileOutputStream outFile = new FileOutputStream(serializeFile);
//            ObjectOutputStream s = new ObjectOutputStream(outFile);
//            s.writeObject(mySeqActivityTree);
//            s.flush(); 
//            s.close();
//            outFile.close();
//            
//            /////////////////////////////////////////////////////////
//            ADLSequencer theSequencer = new ADLSequencer();
//            ADLLaunch launch = new ADLLaunch();
//
//            theSequencer.setActivityTree(mySeqActivityTree);
//
//           launch = theSequencer.navigate(SeqNavRequests.NAV_NONE);
//           
//            synchronized( stmtUpdateCourse )
//            {
//               stmtUpdateCourse.setBoolean(1, launch.mNavState.mStart);
//               stmtUpdateCourse.setBoolean(2, (launch.mNavState.mTOC != null));
//               stmtUpdateCourse.setString(3, mCourseID);
//               stmtUpdateCourse.executeUpdate();
//            }
//            
//            
//
//
//         }
//
//         // Close the statements
//         stmtSelectCID.close();
//         stmtUpdateCID.close();
//         stmtInsertCourse.close();
//         stmtInsertItem.close();
//         stmtUpdateCourse.close();
//
//         conn.close();
//        
//      }  
//      catch ( SQLException se )
//      {
//         result = false;
//         if ( DebugIndicator.ON )
//         {
//            System.out.println(se.getSQLState());
//            System.out.println("error code: " + se.getErrorCode());
//            se.printStackTrace();
//         }
//      }
//      catch ( Exception e )
//      {
//         result = false;
//         if ( DebugIndicator.ON )
//         {
//            e.printStackTrace(); 
//         }
//      }
//      
//      return result;
//   }


   /**
    * This method adds parameters to a URL using the following algorithm 
    * from the SCORM CAM Version 1.3:
    * While first char of parameters is in "?&"
    *    Clear first char of parameters
    * If first char of parameters is "#"
    *    If URL contains "#" or "?"
    *        Discard parameters
    *        Done processing URL
    * If URL contains "?"
    *    Append "&" to the URL
    * Else
    *    Append "?" to the URL
    * Append parameters to URL
    *
    * 
    * @param iURL  URL of content
    * 
    * @param iParameters  Parameters to be appended
    * 
    * @return URL with added parameters
    */                                                      
   public String addParameters(String iURL, String iParameters)
   {
       if ( (iURL.length() == 0) || (iParameters.length() == 0) )
       {
          return iURL;
       }
        while ( (iParameters.charAt(0) == '?') || 
                                    (iParameters.charAt(0) == '&') )
        {
           iParameters = iParameters.substring(1);
        }
        if ( iParameters.charAt(0) == '#' )
        {
             if ( (iURL.indexOf('#') != -1) || (iURL.indexOf('?') != -1) )
             {
                return iURL;
             }
        }
        if ( iURL.indexOf('?') != -1 )
        {   
           iURL = iURL + '&';
        }
        else
        {
           iURL = iURL + '?';
        }
        iURL = iURL + iParameters;

        return iURL;
   }


   /**
    * This method catches all bucket related info within the manifest and
    * stores to the SSP Database.<br>
    * 
    * @param iResources list of resources from the manifest
    */ 
//   private boolean updateSSPDB( Vector iResources )
//   {
//      boolean result = true;
//      String scoID = null;
//      String resourceID = null;
//      String courseID = null;
//      String bucketID = null;
//      String bucketType = null;
//      String persistence = "learner";
//      String min = null;
//      String requested = null;
//      String reducible = "false";
//      String temp = null;
//    
//      try
//      {
//         // Set up the database connection information.
//                 
//         Connection conn = SSP_DBHandler.getConnection();
//         // Prepare statements
//         PreparedStatement stmtInsertBucket;
//   
//         String sqlInsertBucket
//         = "INSERT INTO SSP_BucketTbl (ScoID, CourseID, BucketID, BucketType," +
//                                    "Persistence, Min, Requested, Reducible) " +
//                                     "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//
//         stmtInsertBucket = conn.prepareStatement(sqlInsertBucket);
//
//         // Looping over resource
//         for ( int i = 0; i < iResources.size(); i++)
//         {
//            Node tempResource = (Node)iResources.elementAt(i);
//            Vector children = DOMTreeUtility.getNodes(tempResource, "bucket");
//
//            // Looping over each child of this instance of resource
//            for (int j = 0; j < children.size(); j++)
//            {
//                Node tempBucket = (Node)children.elementAt(j);
//      
//                Node tempSize = DOMTreeUtility.getNode(tempBucket, "size");
//      
//                resourceID = DOMTreeUtility.getAttributeValue(tempResource, 
//                                                         "identifier" );
//                // Loop through to find the SCOID 
//                for (int k = 0; k < mOrganizationList.size(); k++)
//                {
//                   Node tempOrg = (Node)mOrganizationList.elementAt(k);
//                   Vector orgList = DOMTreeUtility.getNodes(tempOrg, "item");
//
//                   for (int n = 0; n < orgList.size(); n++)
//                   {
//                     Node tempItem = (Node)orgList.elementAt(n);
//                     String tempRef = DOMTreeUtility.getAttributeValue(tempItem, "identifierref");
//                     if (tempRef.equals(resourceID))
//                     {
//                        scoID = DOMTreeUtility.getAttributeValue(tempItem, "identifier");
//                        break;
//                     }
//                   }
//                   
//                }
//
//      
//                courseID = getCourseID();
//      
//                bucketID = DOMTreeUtility.getAttributeValue(tempBucket, "bucketID");
//      
//                bucketType = DOMTreeUtility.getAttributeValue(tempBucket, 
//                                                              "bucketType");
//      
//                temp = DOMTreeUtility.getAttributeValue(tempBucket, "persistence");
//     
//                persistence = (temp == null || temp.equals("")) ? "learner" : temp;
//                min = DOMTreeUtility.getAttributeValue(tempSize, "minimum");
//      
//                requested = DOMTreeUtility.getAttributeValue(tempSize, "requested");
//      
//                temp = DOMTreeUtility.getAttributeValue(tempSize, "reducible");
//                reducible = (temp == null || temp.equals("")) ? "false" : temp ;
//      
//      
//                synchronized( stmtInsertBucket )
//                {
//                   stmtInsertBucket.setString(1, scoID);
//                   stmtInsertBucket.setString(2, courseID);
//                   stmtInsertBucket.setString(3, bucketID);
//                   stmtInsertBucket.setString(4, bucketType);
//                   stmtInsertBucket.setString(5, persistence);
//                   stmtInsertBucket.setString(6, min);
//                   stmtInsertBucket.setString(7, requested);
//                   stmtInsertBucket.setString(8, reducible);
//                   stmtInsertBucket.executeUpdate();
//                }
//
//            }
//
//         }
//         
//
//         // Close the statements
//         stmtInsertBucket.close();
//
//         conn.close();
//        
//      }  
//      catch ( SQLException se )
//      {
//         result = false;
//         if ( DebugIndicator.ON )
//         {
//            System.out.println(se.getSQLState());
//            System.out.println("error code: " + se.getErrorCode());
//            se.printStackTrace();
//         }
//      }
//      catch ( Exception e )
//      {
//         result = false;
//         if ( DebugIndicator.ON )
//         {
//            e.printStackTrace(); 
//         }
//      }
//      
//      return result;
//
//   }

}
