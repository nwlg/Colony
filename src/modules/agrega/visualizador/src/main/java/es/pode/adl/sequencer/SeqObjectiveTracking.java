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
package es.pode.adl.sequencer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

import es.pode.adl.debug.DebugIndicator;

/**
 * Encapsulation mastery status tracking and behavior.<br><br>
 * 
 * <strong>Filename:</strong> SeqObjectiveTracking.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * The <code>SeqObjectiveTracking</code> encapsulates the objective tracking
 * information for one objective as described in the SS Tracking  Model
 * (TM) section.  This class provides seamless access to both local and global
 * objectives and provides for measure-based mastery evaluation.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE. <br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br><br>
 * 
 * <strong>Known Problems:</strong><br><br>
 * 
 * <strong>Side Effects:</strong><br><br>
 * 
 * <strong>References:</strong><br>
 * <ul>
 *     <li>IMS SS 1.0
 *     <li>SCORM 2004 3rd Edition
 * </ul>
 * 
 * @author ADL Technical Team
 */
public class SeqObjectiveTracking implements Serializable
{

	public HashMap datosObjs = new HashMap();
	
	public HashMap getDatosObjs()  {
		return this.datosObjs;
	}
	
	public void setDatosObjs(HashMap datosObjs) {
		this.datosObjs=datosObjs;
	}
	
   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = DebugIndicator.ON;

   /**
    * Identifies the learner with which this objective is associated.
    */
   private String mLearnerID = null;

   /**
    * Identifies the scope with which this objective is associated.
    */
   private String mScopeID = null;

   /**
    * Identifies the objective being tracked.
    */
   private SeqObjective mObj = null;

   /**
    * Indicates if the recorded Objective status is invalid
    */
   private boolean mDirtyObj = false;

   /** 
    * Indicates that the an objective set is unconditionally allowed
    */
   private boolean mSetOK = false;

   /**
    * Indicates if this objective has valid satisfaction data
    */
   private boolean mHasSatisfied = false;

   /**
    * This objective's satisfied status.
    */
   private boolean mSatisfied = false;

   /**
    * Indicates if this objective has a valid measure.
    */
   private boolean mHasMeasure = false;

   /**
    * This objective's measure.<br><br>
    * Valid range: <code>[[1.0..1.0]</code>
    */
   private double mMeasure = 0.0;

   /**
    * Indicates the unique global objective where satisfied status is read.
    */
   private String mReadStatus = null;

   /**
    * Indicates the unique global objective where measure is read.
    */
   private String mReadMeasure = null;

   /**
    * Indicates the set of global objectives that receive satisfied status
    */
   private Vector mWriteStatus = null;

   /**
    * Indicates the set of global objectives that receive measure
    */
   private Vector mWriteMeasure = null;


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Constructors 
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Initializes the objective tracking information for one objective.
    * 
    * @param iObj       The objective being tracked.
    * 
    * @param iLearnerID The learner this objective is associated with.
    * 
    * @param iScopeID   The scope to which this objective can be resolved.
    *
    */
   public SeqObjectiveTracking(SeqObjective iObj, 
                               String iLearnerID,
                               String iScopeID)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking --> BEGIN -  " +
                            "constructor");
         System.out.println("  ::--> " + iLearnerID);
         System.out.println("  ::--> " + iScopeID);
      }

      if ( iObj != null )
      {

         if ( _Debug )
         {
            System.out.println("  ::--> Objective ID : " + 
                               iObj.mObjID);
         }

         mObj = iObj;
         mLearnerID = iLearnerID;
         mScopeID = iScopeID;

         if ( iObj.mMaps != null )
         {
            if ( _Debug )
            {
               System.out.println("  ::--> Setting up obj maps");
            }

            for ( int i = 0; i < mObj.mMaps.size(); i++ )
            {
               SeqObjectiveMap map = (SeqObjectiveMap)mObj.mMaps.elementAt(i);

               if ( map.mReadStatus )
               {
                  mReadStatus = map.mGlobalObjID;
               }

               if ( map.mReadMeasure )
               {
                  mReadMeasure = map.mGlobalObjID;
               }

               if ( map.mWriteStatus )
               {
                  if ( mWriteStatus == null )
                  {
                     mWriteStatus = new Vector();
                  }

                  mWriteStatus.add(map.mGlobalObjID);
               }

               if ( map.mWriteMeasure )
               {
                  if ( mWriteMeasure == null )
                  {
                     mWriteMeasure = new Vector();
                  }

                  mWriteMeasure.add(map.mGlobalObjID);
               }
            }
         }
      }
      else
      {
         if ( _Debug )
         {
            System.out.println("  ::--> ERROR : No associated objective");
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking --> END   -  " +
                            "constructor");
      }
   }

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Package Methods 
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
   
   /**
    * Get the objective ID of this objective.
    * 
    * @return The ID (<code>String</code>) of this objective.
    */
   String getObjID()
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " +
                            "getObjID");
         System.out.println("  ::-->  " + mObj.mObjID);
         System.out.println("  :: SeqObjectiveTracking   --> END   - " + 
                            "getObjID");
      }

      return mObj.mObjID;
   }


   /**
    * Get the objective definition for this objective status record
    * 
    * @return The objective (<code>SeqObjective</code>) for this objective
    *         status record.
    */
   SeqObjective getObj()
   {
      return mObj;
   }

   /**
    * Sets the activity's objective status as determined by rollup.  This method
    * only applies to measure rollup.
    * 
    * @param iSatisfied Desired objective status.   
    */
   void forceObjStatus(String iSatisfied)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " +
                            "forceObjStatus");
         System.out.println("  ::-->  " + iSatisfied);
      }


      if ( iSatisfied.equals(ADLTracking.TRACK_UNKNOWN) )
      {
         clearObjStatus();
      }
      else
      {
         // Set any global objectives
         if ( mWriteStatus != null )
         {
            for ( int i = 0; i < mWriteStatus.size(); i++ )
            {
               String objID = (String)mWriteStatus.elementAt(i);

               ADLSeqUtilities.setGlobalObjSatisfied(objID, 
                                                     mLearnerID,
                                                     mScopeID,
                                                     iSatisfied);
            }
         }

         mHasSatisfied = true;

         if ( iSatisfied.equals(ADLTracking.TRACK_SATISFIED) )
         {
            mSatisfied = true;
         }
         else
         {
            mSatisfied = false;
         }
      }


      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> END   - " +
                            "forceObjStatus");
      }
   }

   /**
    * Sets the activity's objective status.
    * 
    * @param iSatisfied Desired objective status.   
    */
   void setObjStatus(String iSatisfied)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " +
                            "setObjStatus");
         System.out.println("  ::-->  " + mObj.mObjID);
         System.out.println("  ::-->  " + iSatisfied);
      }

      // If the objective is only satified my measure, don't set its status
      if ( mObj.mSatisfiedByMeasure && !mSetOK )
      {
         if ( _Debug )
         {
            System.out.println("  ::--> Cannot set: Objective satisfied by " +
                               "measure");
         }
      }
      else
      {
         if ( iSatisfied.equals(ADLTracking.TRACK_UNKNOWN) )
         {
            clearObjStatus();
         }
         else
         {

            // Set any global objectives
            if ( mWriteStatus != null )
            {
               for ( int i = 0; i < mWriteStatus.size(); i++ )
               {
                  String objID = (String)mWriteStatus.elementAt(i);

                  ADLSeqUtilities.setGlobalObjSatisfied(objID, 
                                                        mLearnerID,
                                                        mScopeID,
                                                        iSatisfied);
               }
            }

            mHasSatisfied = true;

            if ( iSatisfied.equals(ADLTracking.TRACK_SATISFIED) )
            {
               mSatisfied = true;
            }
            else
            {
               mSatisfied = false;
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> END   - " +
                            "setObjStatus");
      }
   }

   /**
    * Clears the recorded objective status.
    *
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   boolean clearObjStatus()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " +
                            "clearObjStatus");
      }

      boolean statusChange = false;

      if ( mHasSatisfied )
      {

         if ( mObj.mSatisfiedByMeasure )
         {
            if ( _Debug )
            {
               System.out.println("  ::--> Cannot clear: Objective " +
                                  "satisfied by measure");
            }
         }
         else
         {

            // Clear any global objectives
            if ( mWriteStatus != null )
            {
               for ( int i = 0; i < mWriteStatus.size(); i++ )
               {
                  String objID = (String)mWriteStatus.elementAt(i);

                  ADLSeqUtilities.
                  setGlobalObjSatisfied(objID, 
                                        mLearnerID, 
                                        mScopeID,
                                        ADLTracking.TRACK_UNKNOWN);
               }
            }

            // Clear the satisfaction status
            mHasSatisfied = false;
            statusChange = true;
         }
      }


      if ( _Debug )
      {
         System.out.println("  ::--> " + statusChange);
         System.out.println("  :: SeqObjectiveTracking   --> END   - " +
                            "clearObjStatus");
      }

      return statusChange;
   }

   /**
    * Clears the recorded measure for this objective.
    * 
    * @param iAffectSatisfaction
    *                 Indicates if the minNormalizedMeasure should
    *                 be evaluated
    * 
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   boolean clearObjMeasure(boolean iAffectSatisfaction)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " + 
                            "clearObjMeasure");
         System.out.println("  ::--> " + iAffectSatisfaction);
      }
      //primero relleno la tabla y me quedo con la hashmap
      boolean statusChange = false;

      if ( mHasMeasure )
      {
         // Clear any global objectives
         if ( mWriteMeasure != null )
         {
            for ( int i = 0; i < mWriteMeasure.size(); i++ )
            {
               String objID = (String)mWriteMeasure.elementAt(i);
               ADLSeqUtilities.setGlobalObjMeasure(objID, 
                                                   mLearnerID,
                                                   mScopeID,
                                                   ADLTracking.TRACK_UNKNOWN, this.datosObjs);
            }
         }

         // Clear the measure
         mHasMeasure = false;

         // If measure is used to determine status, status is also cleared
         if ( iAffectSatisfaction )
         {
            forceObjStatus(ADLTracking.TRACK_UNKNOWN);
         }
      }

      if ( _Debug )
      {
         System.out.println("  ::--> " + statusChange);
         System.out.println("  :: SeqObjectiveTracking   --> END   - " + 
                            "clearObjMeasure");
      }

      return statusChange;
   }

   /**
    * Sets an activity's measure and compares the new measure with a defined
    * minimum measure, if one exists. The objectives's status may be set
    * based on this comparison.
    * 
    * @param iMeasure Desired measure
    * 
    * @param iAffectSatisfaction
    *                 Indicates if the minNormalizedMeasure should
    *                 be evaluated
    */
   void setObjMeasure(double iMeasure, boolean iAffectSatisfaction)             
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " + 
                            "setObjMeasure");
         System.out.println("  ::-->  " + iMeasure);
         System.out.println("  ::-->  " + iAffectSatisfaction);
      }

      // Validate the range of the measure
      if ( iMeasure < -1.0 || iMeasure > 1.0 )
      {
         if ( _Debug )
         {
            System.out.println("  ::--> Invalid Measure: " + iMeasure);
            System.out.println("  ::--> Assume 'Unknown'");
         }

         clearObjMeasure(iAffectSatisfaction);
      }
      else
      {
         mHasMeasure = true;
         mMeasure = iMeasure;

         // Set any global objectives
         if ( mWriteMeasure != null )
         {
            for ( int i = 0; i < mWriteMeasure.size(); i++ )
            {
               String objID = (String)mWriteMeasure.elementAt(i);
                
               ADLSeqUtilities.setGlobalObjMeasure(objID, 
                                   mLearnerID,
                                   mScopeID,
                                   (new Double(iMeasure)).toString(), this.datosObjs);
            }
         }

         // If objective status is determined by measure, set it
         if ( iAffectSatisfaction )
         {
            if ( mMeasure >= mObj.mMinMeasure )
            {
               forceObjStatus(ADLTracking.TRACK_SATISFIED);
            }
            else
            {
               forceObjStatus(ADLTracking.TRACK_NOTSATISFIED);
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> END - " + 
                            "setObjMeasure");
      }
   }

   /**
    * Retrieves the objective's status.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return The objective's status -- <code>unknown, true, false</code>.
    */
   String getObjStatus(boolean iIsRetry)
   {
      return getObjStatus(iIsRetry, false);
   }

   /**
    * Retrieves the objective's status.
    * 
    * @param iIsRetry  Indicates if this evaluation is occuring during the
    *                  processing of a 'retry' sequencing request.
    * 
    * @param iUseLocal Indicates if only the local status should be
    *                  returned.
    * 
    * @return The objective's status -- <code>unknown, true, false</code>.
    */
   String getObjStatus(boolean iIsRetry, boolean iUseLocal)
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " + 
                            "getObjStatus");
         System.out.println("  ::  LOCAL --> " + iUseLocal);
      }

      String ret = ADLTracking.TRACK_UNKNOWN;
      boolean done = false;

      // if satisfied by measure, ensure that it has been set if a measure is
      // avaliable.
      if ( mObj.mSatisfiedByMeasure )
      {
         if ( _Debug )
         {
            System.out.println("  ::--> Only using Measure +---><---+  ");
         }

         done = true;
         String measure = null;

         // Is there a 'read' objective map?
         if ( mReadMeasure != null )
         {
   
            if ( _Debug )
            {
                 System.out.println("  ::-->  Looking at shared measure");
            }
            
            measure =
            	ADLSeqUtilities.getGlobalObjMeasure(mReadMeasure, 
      			 		           mLearnerID,
      		 		 	           mScopeID, this.datosObjs);
         }
   
   
         if ( mHasMeasure && measure == null )
         {
            if ( _Debug )
            {
               System.out.println("  ::--> Using local measure");
            }
       
      	    if ( mHasMeasure && !(iIsRetry && mDirtyObj) )
      	    {
      	       measure = (new Double(mMeasure)).toString();
      	    }
         }

         double val = -999.0;

         try
         {
            val = (new Double(measure)).doubleValue();
         }
         catch ( Exception e )
         {
            if ( _Debug )
            {
               System.out.println("  ::--> ERROR: Bad measure value");
            }
         }

         // Validate the range of the measure
         if ( val < -1.0 || val > 1.0 )
         {
            if ( _Debug )
            {
               System.out.println("  ::--> ERROR :  Invalid Measure: " + val);
            }
         }
         else
         {
            if ( val >= mObj.mMinMeasure )
            {
               ret = ADLTracking.TRACK_SATISFIED;
            }
            else
            {
               ret = ADLTracking.TRACK_NOTSATISFIED;
            }
         }
      }

      if ( !done )
      {        
	 // Is there a 'read' objective map?
	 if ( mReadStatus != null )
	 {
	    if ( _Debug )
	    {
	       System.out.println("  ::--> Using shared status");
	    } 

	    // Retrieve shared competency mastery status
	    String status =
	    ADLSeqUtilities.getGlobalObjSatisfied(mReadStatus, 
						 mLearnerID,
						 mScopeID);
	    if ( status != null )
	    {
	       ret = status;
	       done = true;
	    }
	 }

         if ( mHasSatisfied && ( !done || iUseLocal ) )
         {
            if ( _Debug )
            {
               System.out.println("  ::--> Using local objective status");
            }

            if ( mHasSatisfied && !(iIsRetry && mDirtyObj) )
            {
               if ( mSatisfied )
               {
                  ret = ADLTracking.TRACK_SATISFIED;
               }
               else
               {
                  ret = ADLTracking.TRACK_NOTSATISFIED;
               }
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  ::-->  " + ret);
         System.out.println("  :: SeqObjectiveTracking   --> END   - " +
                            "getObjStatus");
      }

      return ret;
   }


   /**
    * Retrieves the Objective's measure.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    *
    * @return The objective's measure (<code>[-1.0, 1.0]</code>), or <code>
    *         unknown</code>, if the objective does not have a valid measure.
    */
   String getObjMeasure(boolean iIsRetry)
   {
      return getObjMeasure(iIsRetry, false);
   }

   /**
    * Retrieves the Objective's measure.
    * 
    * @param iIsRetry  Indicates if this evaluation is occuring during the
    *                  processing of a 'retry' sequencing request.
    * 
    * @param iUseLocal Indicates if only the local status should be
    *                  returned.
    * 
    * @return The objective's measure (<code>[-1.0, 1.0]</code>), or <code>
    *         unknown</code>, if the objective does not have a valid measure.
    */
   String getObjMeasure(boolean iIsRetry, boolean iUseLocal)
   {

      // Do not assume there is a valid measure
      String ret = ADLTracking.TRACK_UNKNOWN;

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN   - " +
                            "getObjMeasure");
         System.out.println("  ::  LOCAL --> " + iUseLocal);
      }

      boolean done = false;

      // Is there a 'read' objective map?
      if ( mReadMeasure != null )
      {

	 if ( _Debug )
	 {
	    System.out.println("  ::-->  Looking at shared measure");
	 }
	 
	 String measure =
		 ADLSeqUtilities.getGlobalObjMeasure(mReadMeasure, 
			 		     mLearnerID,
		 		 	     mScopeID, this.datosObjs);

         // Always use shared measure if available
	 if ( measure != null )
	 {
	    ret = measure;
	    done = true;
	 }
      }


      if ( mHasMeasure && ( !done || iUseLocal ) )
      {
    
	 if ( _Debug )
	 {
	    System.out.println("  ::--> Using local measure");
	 }
    
	 if ( mHasMeasure && !(iIsRetry && mDirtyObj) )
	 {
	    ret = (new Double(mMeasure)).toString();
	 }
      }

       // If a global measure or a local min measure is defined,
       // test the threshold and set status
       if ( !ret.equals(ADLTracking.TRACK_UNKNOWN) &&
	    mObj.mSatisfiedByMeasure && !(iIsRetry && mDirtyObj) )
       {

	  double val = -999.0;

	  try
	  {
	     val = (new Double(ret)).doubleValue();
	  }
	  catch ( Exception e )
	  {
	     if ( _Debug )
	     {
		System.out.println("  ::--> ERROR: Bad measure value");
	     }
	  }

	  // Validate the range of the measure
	  if ( val < -1.0 || val > 1.0 )
	  {
	     if ( _Debug )
	     {
		System.out.println("  ::--> ERROR :  Invalid Measure: "
				   + val);
	     }
	  }
	  else
	  {
	     mSetOK = true;

	     if ( val >= mObj.mMinMeasure )
	     {
		setObjStatus(ADLTracking.TRACK_SATISFIED);
	     }
	     else
	     {
		setObjStatus(ADLTracking.TRACK_NOTSATISFIED);
	     }

	     mSetOK = false;
	  }
       }

      if ( _Debug )
      {
         System.out.println("  ::-->  " + ret);
         System.out.println("  :: SeqObjectiveTracking   --> END   - " + 
                            "getObjMeasure");
      }

      return ret;
   }

   /**
    * Determines if the activity's objective is satisfied by measure.
    * 
    * @return <code>true</code> if the objective is satisfied by measure,
    *         otherwise <code>false</code>
    */
   boolean getByMeasure()
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> BEGIN - " + 
                            "getByMeasure");
      }

      boolean byMeasure = false;

      if ( mObj != null )
      {
         byMeasure = mObj.mSatisfiedByMeasure;
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking   --> END   - " + 
                            "getByMeasure");
      }

      return byMeasure;
   }

   /**
     * Indicates that the current Objective state is invalid due to a new
     * attempt on the activity's parent.
     */
   void setDirtyObj()
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking     --> BEGIN - " +
                            "setDirtyObj");
      }

      mDirtyObj = true;

      if ( _Debug )
      {
         System.out.println("  :: SeqObjectiveTracking     --> END   - " +
                            "setDirtyObj");
      }
   }

}  // end SeqObjectiveTracking
