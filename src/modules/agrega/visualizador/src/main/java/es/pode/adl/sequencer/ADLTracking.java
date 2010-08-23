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
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import es.pode.adl.debug.DebugIndicator;

/**
 * Encapsulation of information tracked for each attempt at an activity.<br><br>
 * 
 * <strong>Filename:</strong> ADLTracking.java<br>
 *
 * <strong>Description:</strong><br>
 * An <code>ADLTracking</code> encapsulates the information required by the
 * sequencer to track status for each new attempt on an activity.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE.<br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br>
 * All fields are purposefully public to allow immediate access to known data
 * elements.<br><br>
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
public class ADLTracking implements Serializable
{

   /**
    * Enumeration of possible values for tracking elements  -- described in 
    * Tracking Model elements 2.1 and 2.2 of the IMS SS Specification.
    * <br>unknown
    * <br><b>"unknown"</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static String TRACK_UNKNOWN            = "unknown";

   /**
    * Enumeration of possible values for tracking elements  -- described in 
    * Tracking Model elements 2.1 and 2.2 of the IMS SS Specification.
    * <br>satisfied
    * <br><b>"satisfied"</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]           
    */
   public static String TRACK_SATISFIED          = "satisfied";

   /**
    * Enumeration of possible values for tracking elements  -- described in 
    * Tracking Model elements 2.1 and 2.2 of the IMS SS Specification.
    * <br>notSatisfied
    * <br><b>"notSatisfied"</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static String TRACK_NOTSATISFIED       = "notSatisfied";

   /**
    * Enumeration of possible values for tracking elements  -- described in 
    * Tracking Model elements 2.1 and 2.2 of the IMS SS Specification.
    * <br>completed
    * <br><b>"completed"</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static String TRACK_COMPLETED          = "completed";

   /**
    * Enumeration of possible values for tracking elements  -- described in 
    * Tracking Model elements 2.1 and 2.2 of the IMS SS Specification.
    * <br>incomplete
    * <br><b>"incomplete"</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static String TRACK_INCOMPLETE         = "incomplete";


   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = DebugIndicator.ON;

   /**
    * Indicates if the recorded Progress status is invalid
    */
   public boolean mDirtyPro = false;


   /**
    * The objectives associated with this activity
    */
   public Hashtable mObjectives = null;

   /**
    * Describes the ID for the objective that contributes to rollup.
    */
   public String mPrimaryObj = "_primary_";

   /**
    * The progress tracking status.
    */
   public String mProgress = ADLTracking.TRACK_UNKNOWN;


   /** 
    * This describes the activity's absolute duration.<br>
    * Tracking element 1.2.2 Element 4
    */
   public ADLDuration mAttemptAbDur = null;

   /** 
    * This describes the activity's experienced duration.<br>
    * Tracking element 1.2.2 Element 5
    */
   public ADLDuration mAttemptExDur = null;


   /**
    * Represents the attempt number.
    */
   public long mAttempt = 0;


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Initializes tracking status information for this attempt on the
    * associated activity.
    * 
    * @param iObjs      A list of local Objectives (<code>SeqObjective</code>).
    * 
    * @param iLearnerID Identifies the learner this tracking information is
    *                   related to.
    * 
    * @param iScopeID   Identifies the scope this tracking information applies
    */
   ADLTracking(Vector iObjs, String iLearnerID, String iScopeID) 
   {

      if ( iObjs != null )
      {

         for ( int i = 0; i < iObjs.size(); i++ )
         {
            SeqObjective obj = (SeqObjective)iObjs.elementAt(i);

            if ( _Debug )
            {
               System.out.println("  ::--> Building Objective  :: " 
                                  + obj.mObjID);
            }

            // Construct an objective for each local objective
            SeqObjectiveTracking objTrack = 
            new SeqObjectiveTracking(obj, iLearnerID, iScopeID);


            // If the objective is defined, add it to the set of objectives
            // associated with this activity
            if ( mObjectives == null )
            {
               mObjectives = new Hashtable();
            }

            mObjectives.put(obj.mObjID, objTrack);

            // Remember if this objective contributes to rollup
            if ( obj.mContributesToRollup )
            {
               mPrimaryObj = obj.mObjID;
            }
         }
      }
      else
      {
         if ( _Debug )
         {
            System.out.println("  ::--> Making default Obj");
         }

         // All activities must have at least one objective and that objective
         // is the primary objective

         SeqObjective def = new SeqObjective();
         def.mContributesToRollup = true;

         SeqObjectiveTracking objTrack =
         new SeqObjectiveTracking(def, iLearnerID, iScopeID);

         if ( mObjectives == null )
         {
            mObjectives = new Hashtable();
         }

         mObjectives.put(def.mObjID, objTrack);

         mPrimaryObj = def.mObjID;
      }
   }


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * This method provides the state this <code>ADLTracking</code> object for
    * diagnostic purposes.<br>
    */
   public void dumpState()
   {

      if ( _Debug )
      {
         System.out.println("  :: ADLTracking   --> BEGIN - dumpState");

         System.out.println("\t  ::--> Attempt #:   " + mAttempt);
         System.out.println("\t  ::--> Dirty Pro:   " + mDirtyPro);

         if ( mObjectives == null )
         {
            System.out.println("\t  ::--> Objectives :       NULL");
         }
         else
         {

            System.out.println("\t  ::--> Objectives :       [" + 
                               mObjectives.size() + "]");

            Enumeration theEnum = mObjectives.keys();

            while ( theEnum.hasMoreElements() )
            {
               String key = (String)theEnum.nextElement();

               System.out.println("\t\t  :: " + key + " ::");

               SeqObjectiveTracking obj = 
               (SeqObjectiveTracking)mObjectives.get(key);

               System.out.println("\t\t  ::--> " + 
                                  obj.getObjStatus(false));
               System.out.println("\t\t  ::--> " + 
                                  obj.getObjMeasure(false));
            }

         }

         System.out.println("\t  ::--> Primary:       " + mPrimaryObj);  
         System.out.println("\t  ::--> Progress:      " + mProgress);

         System.out.println("  :: ADLTracking   --> END   - dumpState");
      }
   }

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Package Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
     * Indicates that the current Objective state is invalid due to a new
     * attempt on the activity's parent.
     */
   void setDirtyObj()
   {
      if ( _Debug )
      {
         System.out.println("  :: ADLTracking     --> BEGIN - " +
                            "setDirtyObj");
      }

      if ( mObjectives != null )
      {

         Enumeration theEnum = mObjectives.keys();

         while ( theEnum.hasMoreElements() )
         {
            String key = (String)theEnum.nextElement();

            SeqObjectiveTracking obj =
            (SeqObjectiveTracking)mObjectives.get(key);

            obj.setDirtyObj();

         }
      }

      if ( _Debug )
      {
         System.out.println("  :: ADLTracking     --> END   - " +
                            "setDirtyObj");
      }
   }

}  // end ADLTracking
