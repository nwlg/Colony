/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

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
 * Implementation of an activity tree.<br><br>
 * 
 * <strong>Filename:</strong> SeqActivityTree.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * This is an implementation of an activity tree used for sequencing; it
 * does utilize a tree as its data structure and it does not attempt to
 * provide any performance optimizations.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE. <br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br>
 * This implementation has not been optimized.<br><br>
 * 
 * <strong>Known Problems:</strong><br><br>
 * 
 * <strong>Side Effects:</strong><br><br>
 * 
 * <strong>References:</strong><br>
 * <ul>
 *     <li>IMS SS Specification 1.0</li>
 *     <li>SCORM 2004 3rd Edition</li>
 * </ul>
 * 
 * @author ADL Technical Team
 */
public class SeqActivityTree implements Serializable
{

   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = DebugIndicator.ON;

   /**
    * This the representation of the activity tree
    */
   private SeqActivity mRoot = null;

   /**
    * The set of valid navigation requests for the current state of the activity
    * tree.
    */
   private ADLValidRequests mValidReq = null;

   /**
    * This is the identifier for the last leaf in the activity tree
    */
   private String mLastLeaf = null; 

   /**
    * This is the scope of this activity tree's objectives
    */
   private String mScopeID = null;

   /**
    * This is the course identifier for the current activity tree
    */
   private String mCourseID = null; 

   /**
    * This is the student identifier for the student utilizing this activity
    * tree
    */
   private String mLearnerID = null;


   // Internal state of the activity tree
   /**
    * This is the current activity<br><br>
    * Defined in IMS SS AM
    */
   private SeqActivity mCurActivity = null;

   /**
   * This is the first candidate activity to for sequencing requests.
   */
   private SeqActivity mFirstCandidate = null;

   /**
    * This is last activity experienced by the student prior to a SuspendAll
    * sequencing request.<br><br>
    * Defined in IMS SS AM
    */
   private SeqActivity mSuspendAll = null;

   /**
    * This is an internal 'quick' reference map of the activity tree's nodes
    */
   private Hashtable mActivityMap = null;

   /**
    * This is the set of global objective IDs used in this activity tree.
    */
   private Vector mObjSet = null;

   /**
    * This is a map of activities that read from each of the global shared
    * objectives.
    */
   private Hashtable mObjMap = null;

   /**
    * This indicates if the global objective IDs have been determined for this 
    * tree.
    */
   private boolean mObjScan = false;

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
   Constructors 
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
   /**
    * Default constructor
    */
   public SeqActivityTree()
   {
      // Default constructor - no specified functionality defined.
   }

   /**
    * Initializes an activity tree (<code>SeqActivityTree</code>) to be
    * utilized during the sequencing process.
    * 
    * @param iCourseID  ID of the course this activity tree is associated w
    * 
    * @param iLearnerID ID of the student this activity tree is associated
    *                   with.
    * 
    * @param iScopeID   ID associated with the scope of this activity tree's
    *                   objectives.
    * 
    * @param iRoot      Root of the internal representation of the activity
    *                   tree's root <code>SeqActivity</code>
    */
   public SeqActivityTree(String iCourseID, 
                          String iLearnerID, 
                          String iScopeID,
                          SeqActivity iRoot)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - constructor");
         System.out.println("  ::--> Course ID     : " + iCourseID);
         System.out.println("  ::--> Student ID    : " + iLearnerID);
         System.out.println("  ::--> Scope ID      : " + iScopeID);
      }

      mCourseID = iCourseID;
      mLearnerID = iLearnerID;
      mScopeID = iScopeID;

      mRoot = iRoot;


      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - constructor");
      }
   }

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
   Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Sets the ID of the learner associated with this activity tree.
    * 
    * @param iLearnerID The ID of the student associated with this tree
    */
   public void setLearnerID(String iLearnerID)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - setLearnerID");
         System.out.println("  ::--> Learner ID    : " + iLearnerID);
      }

      mLearnerID = iLearnerID;

      // Associate each activity in the activity tree with this learner
      // This is required to access certain objectives
      buildActivityMap();

      if ( !(mActivityMap == null || iLearnerID == null) )
      {

         Enumeration theEnum = mActivityMap.elements();

         while ( theEnum.hasMoreElements() )
         {
            SeqActivity act = (SeqActivity)theEnum.nextElement();

            act.setLearnerID(iLearnerID);
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - setLearnerID");
      }
   }

   /**
    * Retrieves ID of the learner associated with this activity tree.
    * 
    * @return The ID (<code>String</code>) of the learner associated with this
    *         activity tree or <code>null</code> if none has been assigned.
    */
   public String getLearnerID()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - getLearnerID");
         System.out.println("  ::--> Learner ID    : " + mLearnerID);
         System.out.println("  :: SeqActivityTree  --> END   - getLearnerID");
      }

      return mLearnerID;
   }

   /**
    * Sets the ID of the course associated with this activity tree.
    * 
    * @param iCourseID Describes the course ID
    */
   public void setCourseID(String iCourseID)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - setCourseID");
         System.out.println("  ::--> Course ID     : " + iCourseID);
      }

      mCourseID = iCourseID;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - setCourseID");
      }
   }

   /**
    * Retrieves ID of the course associated with this activity tree.
    * 
    * @return The ID (<code>String</code>) of the course associated with this
    *         activity tree or <code>null</code> if none has been assigned.
    */
   public String getCourseID()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - getCourseID");
         System.out.println("  ::--> Student ID    : " + mCourseID);
         System.out.println("  :: SeqActivityTree  --> END   - getCourseID");
      }

      return mCourseID;
   }

   /**
    * Sets the scope of the global objectives managed by this activity tree.
    * 
    * @param iScopeID Indicates the ID of the scope associated with this
    *                 activity tree's objectives, or <code>null</code> of the
    *                 objectives are global to the system.
    */
   public void setScopeID(String iScopeID)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "setScopeID");
         System.out.println("  ::-->  " + iScopeID);
      }

      mScopeID = iScopeID;

      if ( mScopeID != null )
      {

         // Associate each activity in the activity tree with this scope
         // This is required to access certain objectives
         buildActivityMap();

         if ( mActivityMap != null )
         {

            Enumeration theEnum = mActivityMap.elements();

            while ( theEnum.hasMoreElements() )
            {
               SeqActivity act = (SeqActivity)theEnum.nextElement();

               act.setScopeID(mScopeID);
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " + 
                            "setScopeID");
      }
   }

   /**
    * Retrieves ID of the course associated with the scope of this activity
    * tree's objectives.
    * 
    * @return The ID (<code>String</code>) of associated with this activity
    *         tree's objectives, or <code>null</code> if the objectives are
    *         global to the system.
    */
   public String getScopeID()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "getScopeID");
         System.out.println("  ::--> " + mScopeID);
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "getScopeID");
      }

      return mScopeID;
   }

   /**
    * This method provides the state this <code>SeqActivityTree</code> object
    * for diagnostic purposes.
    */
   public void dumpState()
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqActivtyTree   --> BEGIN - dumpState");

         System.out.println("  ::--> Course ID:       " + mCourseID);
         System.out.println("  ::--> Student ID:      " + mLearnerID);
         System.out.println("  ::--> Scope ID  :      " + mScopeID);
         System.out.println("  ::--> Last Leaf:       " + mLastLeaf);


         if ( mObjSet == null )
         {
            System.out.println("  ::--> Global Obj Set:       NULL");
         }
         else
         {
            System.out.println("  ::--> Global Obj Set:       [" + 
                               mObjSet.size() + "]");

            for ( int i = 0; i < mObjSet.size(); i++ )
            {
               System.out.println("\t" + (String)mObjSet.elementAt(i));
            }
         }

         if ( mSuspendAll == null )
         {
            System.out.println("  ::--> SuspendAll:           NULL");
         }
         else
         {
            System.out.println("  ::--> SuspendAll:           " +
                               mSuspendAll.getID());
         }

         if ( mCurActivity == null )
         {
            System.out.println("  ::--> Current Activity:     NULL");
         }
         else
         {
            System.out.println("  ::--> Current Activity:     " +
                               mCurActivity.getID());
         }

         if ( mFirstCandidate == null )
         {
            System.out.println("  ::--> First Candidate:      NULL");
         }
         else
         {
            System.out.println("  ::--> First Candidate:      " +
                               mFirstCandidate.getID());
         }

         if ( mRoot == null )
         {
            System.out.println("  ::--> Root:                 NULL");
         }
         else
         {
            System.out.println("  ::--> Activity Tree ::");

            // Walk the activity tree, reporting state for each activity
            SeqActivity walk =  mRoot;
            long depth = 0;

            Vector lookAt = new Vector();
            Vector depthTrack = new Vector();

            while ( walk != null )
            {
               // Display the state of this activity
               walk.dumpState();

               // Check if it has children
               if ( walk.hasChildren(true) )
               {
                  // Look at its children later
                  lookAt.add(walk);
                  depthTrack.add(new Long(depth + 1));
               }

               // Walk the current level of the tree
               walk = walk.getNextSibling(true);

               // If there is not another sibling
               if ( walk == null )
               {
                  // Look one level deeper
                  if ( lookAt.size() != 0 )
                  {
                     // Remove the activity from the 'lookat' list
                     walk = (SeqActivity)lookAt.elementAt(0);
                     lookAt.remove(0);

                     // Look at the activity's first child
                     walk = (SeqActivity)(walk.getChildren(true)).elementAt(0);

                     // Remember how deep we are in the tree
                     depth = ((Long)(depthTrack.elementAt(0))).longValue();
                     depthTrack.remove(0);
                  }
                  else
                  {
                     // Done
                     walk = null;
                  }
               }
            }
         }

         System.out.println("  :: SeqActivityTree   --> END   - dumpState");
      }
   }

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

    Package Methods

   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Sets the root (<code>SeqActivity</code>) of the activity tree.
    * 
    * @param iRoot The root of the activity tree.
    */
   void setRoot(SeqActivity iRoot)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - setRoot"); 

         if ( iRoot != null )
         {
            System.out.println("  ::-->  " + iRoot.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL root.");
         }
      }

      mRoot = iRoot;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - setRoot"); 
      }
   }

   /**
    * Retrieves the activity (<code>SeqActivity</code>) associated with the root
    * of this activity tree.
    * 
    * @return The activity (<code>SeqActivity</code>)  associated with the root
    *         or <code>null</code> if none has been assigned.
    */ 
   SeqActivity getRoot()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - getRoot");

         if ( mRoot != null )
         {
            System.out.println("  ::-->  " + mRoot.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL Root");
         }

         System.out.println("  :: SeqActivityTree  --> END   - getRoot");
      }

      return mRoot;
   }

   /**
    * Sets the ID of the last activity in the activity tree.
    * 
    * @param iLastLeaf The ID of the last activity in the tree
    */
   void setLastLeaf(String iLastLeaf)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - setLastLeaf"); 

         System.out.println("  ::-->  " + iLastLeaf);
      }

      mLastLeaf = iLastLeaf;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - setLastLeaf"); 
      }
   }

   /**
    * Retrieves the ID associated with the last leaf activity in the tree.
    * 
    * @return The ID (<code>String</code>) associated with the last leaf in the
    *         last leaf activity.
    */
   String getLastLeaf()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - getLastLeaf");
         System.out.println("  ::-->  " + mLastLeaf);
         System.out.println("  :: SeqActivityTree  --> END   - GetLastLeaf");
      }

      return mLastLeaf;
   }

   /**
    * Sets the set of valid navigation requests associated with the current 
    * state of the tree.
    * 
    * @param iValidRequests The set of valid sequencing requests (<code>
    * ADLValidRequests</code>).
    */
   void setValidRequests(ADLValidRequests iValidRequests)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "setValidRequests");

         if ( iValidRequests == null )
         {
            System.out.println("  ::-->  NULL set");
         }
      }

      mValidReq = iValidRequests;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "setValidRequests"); 
      }
   }

   /**
    * Retrieves the set of valid navigation requests (<code>ADLValidRequests
    * </code>) for the activity tree.
    * 
    * @return The set of valid navigation requests (<code>ADLValidRequests
    *         </code>) associated with the activity tree, or <code>null</code> 
    *         if the sequencing session hasn't begun.
    */ 
   ADLValidRequests getValidRequests()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "getValidRequests");

         if ( mValidReq == null )
         {
            System.out.println("  ::-->  NULL Set");
         }

         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "getValidRequests");
      }

      return mValidReq;
   }

   /**
    * Retrieves the activity (<code>SeqActivity</code>) associated with the
    * current activity.
    * 
    * @return The activity (<code>SeqActivity</code>) associated with the
    *         current activity or <code>null</code> if none exists.
    */ 
   SeqActivity getCurrentActivity()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "getCurrentActivity");
      }

      if ( _Debug )
      {

         if ( mCurActivity != null )
         {
            System.out.println("  ::-->  " + mCurActivity.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL current activity");
         }

         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "getCurrentActivity");
      }

      return mCurActivity;
   }


   /**
    * Sets 'current' activity for this activity tree.  The determination of
    * which activity is 'current' is performed by the sequencer.  This
    * information is maintained by the activity tree to allow for persistence.
    * 
    * @param iCurrent The 'current' activity (<code>SeqActivity</code>).
    */
   public void setCurrentActivity(SeqActivity iCurrent)
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "setCurrentActivity");

         if ( iCurrent != null )
         {
            System.out.println("  ::-->  " + iCurrent.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL current activity.");
         }
      }

      mCurActivity = iCurrent;


      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "setCurrentActivity");
      }
   }

   /**
    * Retrieves the activity (<code>SeqActivity</code>) from which sequencing
    * requests should begin processing.
    * 
    * @return The activity (<code>SeqActivity</code>) where sequencing requests
    *         should be processed from.
    */         
   SeqActivity getFirstCandidate()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "getFirstCandidate");
      }


      if ( _Debug )
      {

         if ( mFirstCandidate != null )
         {
            System.out.println("  ::-->  " + mFirstCandidate.getID());
         }
         else if ( mCurActivity != null )
         {
            System.out.println("  ::--> [Cur] " + mCurActivity.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL first candidate");
         }

         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "getFirstCandidate");
      }
      
      // If the first candidiate is null, then return the current 
      // activity
      if ( mFirstCandidate == null )
      {
         return mCurActivity;
      }
      
      // else return the first candidate activity
      return mFirstCandidate;

   }

   /**
    * Sets first candidate activity for processing sequencing requests.  The   
    * determination of this activity is performed by the sequencer.  This
    * information is maintained by the activity tree to allow for persistence.
    * 
    * @param iFirst The first candidate activity (<code>SeqActivity</code>).
    */ 
   public void setFirstCandidate(SeqActivity iFirst)
   {
      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "setFirstCandidate");

         if ( iFirst != null )
         {
            System.out.println("  ::-->  " + iFirst.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL current activity.");
         }
      }

      mFirstCandidate = iFirst;


      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "setFirstCandidate");
      }
   }

   /**
    * Sets activity in this activity tree that was last attempted prior to a
    * 'SuspendAll' sequencing event. The determination of this activity is
    * performed by the sequencer.  This information is maintained by the
    * activity tree to allow for persistence.
    * 
    * @param iSuspendTarget
    *              The Activity (<code>SeqActivity</code>) last
    *              attempted by the student, prior to a 'SuspendAll' sequencing 
    */
   void setSuspendAll(SeqActivity iSuspendTarget)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "setSuspendAll");

         if ( iSuspendTarget != null )
         {
            System.out.println("  ::-->  " + iSuspendTarget.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL suspend target.");
         }
      }

      mSuspendAll = iSuspendTarget;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "setSuspendAll");
      }
   }

   /**
    * Retrieves the activity (<code>SeqActivity</code>) associated with the
    * last attempted activity before a 'SuspendAll' sequencing request.
    * 
    * @return The activity (<code>SeqActivity</code>) associated with the last
    *         attempted activity or <code>null</code> if none exists.
    */
   public SeqActivity getSuspendAll()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "getSuspendAll");

         if ( mSuspendAll != null )
         {
            System.out.println("  ::-->  " + mSuspendAll.getID());
         }
         else
         {
            System.out.println("  ::-->  NULL suspend all activity.");
         }

         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "getSuspendAll");
      }

      return mSuspendAll;
   }

   /**
    * Retrieves the activity (<code>SeqActivity</code>) associated with the
    * ID requested
    * 
    * @param iActivityID The activity id
    * 
    * @return The activity (<code>SeqActivity</code>) associated with the ID
    *         request or <code>null</code> if no activity with that ID exists in
    *         current activity tree.
    */
   public SeqActivity getActivity(String iActivityID)
   {

      // Make sure the Activity Map has been created
      if ( mActivityMap == null )
      {
         buildActivityMap();
      }

      SeqActivity temp = null;

      if ( iActivityID != null )
      {
         temp = (SeqActivity)mActivityMap.get(iActivityID);
      }

      return temp;
   }

   /**
    * Retrieves the set of activities in the activity tree that read from a
    * specified global shared objective
    * 
    * @param iObjID objective id
    * 
    * @return The set of activity IDs <code>Vector</code> or <code>null</code>
    *         if none exist.
    */
   public Vector getObjMap(String iObjID)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "getObjMap");
      }

      Vector actSet = null;

      // If we haven't scanned the current tree for global objective IDs, do 
      // it now.
      if ( !mObjScan )
      {
         scanObjectives();

         // Do not allow an empty set
         if ( mObjMap != null )
         {
            if ( mObjMap.size() == 0 )
            {
               mObjMap = null;
            }
         }
      }

      if ( mObjMap != null )
      {
         actSet = (Vector)mObjMap.get(iObjID);
      }

      if ( _Debug )
      {
         if ( actSet == null )
         {
            System.out.println("  ::-->  NULL");
         }
         else
         {
            System.out.println("  ::--> [" + actSet.size() + "]");
         }

         System.out.println("  :: SeqActivityTree  --> END   - " + 
                            "getObjMap");
      }

      return actSet;
   }

   /**
    * Retrieves the set of global objective IDs used in this activity tree.
    * 
    * @return The set of global objective IDs <code>Vector</code> or <code>
    *         null</code> if none exist.
    */
   public Vector getGlobalObjectives()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " + 
                            "getGlobalObjectives");
      }

      // If we haven't scanned the current tree for global objective IDs, do 
      // it now.
      if ( !mObjScan )
      {
         scanObjectives();
      }

      if ( _Debug )
      {
         if ( mObjSet == null )
         {
            System.out.println("  ::-->  NULL");
         }
         else
         {
            System.out.println("  ::--> [" + mObjSet.size() + "]");
         }

         System.out.println("  :: SeqActivityTree  --> END   - " + 
                            "getGlobalObjectives");
      }

      // Do not return an empty set
      if ( mObjSet != null )
      {
         if ( mObjSet.size() == 0 )
         {
            mObjSet = null;
         }
      }

      return mObjSet;
   }

   /**
    * Clears the current state of the activity tree, except for its SuspsendAll
    * state.
    */
   public void clearSessionState()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "clearSessionState"); 
      }

      mActivityMap = null;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "clearSessionState"); 
      }
   }

   /**
    * Set the count of all activities in the activity tree.
    */
   public void setDepths()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "setDepths"); 
      }

      if ( mRoot != null )
      {
         // Walk the activity tree, setting depths
         SeqActivity walk =  mRoot;
         int depth = 0;

         Vector lookAt = new Vector();
         Vector depths = new Vector();

         while ( walk != null )
         {
            // Check if the activity has children
            if ( walk.hasChildren(true) )
            {
               // Look at its children later
               lookAt.add(walk);
               depths.add(new Integer(depth + 1));
            }

            walk.setDepth(depth);

            // Walk the current level of the tree
            walk = walk.getNextSibling(true);

            // If there is not another sibling
            if ( walk == null )
            {
               // Look one level deeper
               if ( lookAt.size() != 0 )
               {
                  // Remove the activity from the 'lookat' list
                  walk = (SeqActivity)lookAt.elementAt(0);
                  lookAt.remove(0);

                  // Remove the depth of the new activity from the 'depths' list
                  depth = ((Integer)depths.elementAt(0)).intValue();
                  depths.remove(0);

                  // Start at the first child of the activity
                  walk = (SeqActivity)(walk.getChildren(true).elementAt(0));
               }
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "setDepths"); 
      }
   }

   /**
    * Set the count of all activities in the activity tree.
    */
   public void setTreeCount()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "setTreeCount"); 
      }

      if ( mRoot != null )
      {
         // Walk the activity tree, setting count
         SeqActivity walk =  mRoot;
         int count = 0;

         Vector lookAt = new Vector();

         while ( walk != null )
         {
            count++;
            walk.setCount(count);

            // Save the activity for later
            if ( walk.hasChildren(true) )
            {
               lookAt.add(walk);

               walk = (SeqActivity)walk.getChildren(true).elementAt(0);
            }
            else
            {
               walk = walk.getNextSibling(true);
            }

            while ( lookAt.size() != 0 && walk == null )
            {
               // Remove the activity from the 'lookat' list
               walk = (SeqActivity)lookAt.elementAt(0);
               lookAt.remove(0);

               walk = walk.getNextSibling(true);
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "setTreeCount"); 
      }
   }

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Private Utility Methods Affecting the Activity Tree
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Constructs a <code>Hashtable</code> associating activity IDs to activities
    * (<code>SeqActivity</code>).
    */
   private void buildActivityMap()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "buildActivityMap");
      }

      // Create or clear the activity map
      if ( mActivityMap != null )
      {
         mActivityMap.clear();
      }
      else
      {
         mActivityMap = new Hashtable();
      }

      // Walk the activity tree -- add a reference to the activity map for
      // each activity in the tree
      // Make sure we have an activity tree to use
      if ( mRoot != null )
      {
         addChildActivitiestoMap(mRoot);
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "buildActivityMap");
      }

   }

   /**
    * Adds all the child activities of an activity to the activity map.
    * 
    * @param iNode Node whose child activities will be added to the activity
    *              map.
    */
   private void addChildActivitiestoMap(SeqActivity iNode)
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "addChildActivitiestoMap");
      }

      // Make sure the node is not empty
      if ( iNode != null )
      {
         Vector children = iNode.getChildren(true);
         int i = 0;

         if ( _Debug )
         {
            System.out.println("  ::--> Adding node : " + iNode.getID());
         }

         // Add the current activity to the activity map
         mActivityMap.put(iNode.getID(), iNode);

         // If the activity has children, add each child to the activity map
         if ( children != null )
         {
            for ( i = 0; i < children.size(); i++ )
            {
               addChildActivitiestoMap((SeqActivity)children.elementAt(i));
            }
         }
      }

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "addChildActivitiestoMap");
      }
   }

   /**
    * Scans the activity tree for global objectives and sets of activities
    * that reference specific global objectives.
    */
   private void scanObjectives()
   {

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> BEGIN - " +
                            "scanObjectives");
      }

      // Walk the activity tree, recording all mapped global objectives
      SeqActivity walk =  mRoot;

      Vector lookAt = new Vector();

      while ( walk != null )
      {
         // Check if the activity has children
         if ( walk.hasChildren(true) )
         {
            // Look at its children later
            lookAt.add(walk);
         }

         // Check if the activity references global objectives
         Vector objs = walk.getObjectives();

         if ( objs != null )
         {

            for ( int i = 0; i < objs.size(); i++ )
            {
               SeqObjective obj = (SeqObjective)objs.elementAt(i);

               if ( obj.mMaps != null )
               {
                  for ( int j = 0; j < obj.mMaps.size(); j++ )
                  {
                     SeqObjectiveMap map = 
                     (SeqObjectiveMap)obj.mMaps.elementAt(j);
                     String target = map.mGlobalObjID;

                     // Make sure we haven't already added this objective
                     if ( mObjSet == null )
                     {
                        mObjSet = new Vector();
                        mObjSet.add(target);
                     }
                     else
                     {
                        boolean found = false;

                        for ( int k = 0; k < mObjSet.size() && !found; k++ )
                        {
                           String id = (String)mObjSet.elementAt(k);
                           found = id.equals(target);
                        }

                        if ( !found )
                        {
                           mObjSet.add(target);
                        }
                     }

                     // If this is a 'read' objective add it to our obj map
                     if ( map.mReadStatus || map.mReadMeasure )
                     {
                        if ( mObjMap == null )
                        {
                           mObjMap = new Hashtable();
                        }

                        Vector actList = (Vector)mObjMap.get(target);

                        if ( actList == null )
                        {
                           actList = new Vector();
                        }

                        actList.add(walk.getID());
                        mObjMap.put(target, actList);
                     }
                  }
               }
            }
         }

         // Walk the current level of the tree
         walk = walk.getNextSibling(true);

         // If there is not another sibling
         if ( walk == null )
         {
            // Look one level deeper
            if ( lookAt.size() != 0 )
            {
               // Remove the activity from the 'lookat' list
               walk = (SeqActivity)lookAt.elementAt(0);
               lookAt.remove(0);

               // Start at the first child of the activity
               walk = (SeqActivity)(walk.getChildren(true).elementAt(0));
            }
         }
      }

      mObjScan = true;

      if ( _Debug )
      {
         System.out.println("  :: SeqActivityTree  --> END   - " +
                            "scanObjectives");
      }
   }

}  // end SeqActivityTree
