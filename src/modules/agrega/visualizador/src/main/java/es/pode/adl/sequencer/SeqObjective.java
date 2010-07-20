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
import java.util.Vector;

import es.pode.adl.debug.DebugIndicator;

/**
 * Encapsulation mastery status tracking and behavior.<br><br>
 * 
 * <strong>Filename:</strong> SeqObjective.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * The <code>SeqObjective</code> encapsulates one objective description and its
 * associated objective maps as described in the IMS SS Specification SD
 * section.  This class provides seamless access to both local and global
 * objectives and provides for score-based mastery evaluation.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE. <br>
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
public class SeqObjective implements Serializable
{

   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = DebugIndicator.ON;

   /**
    * Identifier of this objective.
    */
   public String mObjID = "_primary_";

   /** 
    * Indicates if this objective is satisfied by measure.
    */
   public boolean mSatisfiedByMeasure = false;

   /**
    * Indicates if the objective can be satisfied by measure when its activity
    * is still active.
    */
   public boolean mActiveMeasure = true;

   /**
    * Indicates the minimum measure used to satisfy this objective.<br><br>
    * Valid range: <code>[-1.0, 1.0]</code>
    */
   public double mMinMeasure = 1.0;

   /** 
    * Indicates if the objective contributes to rollup
    */
   public boolean mContributesToRollup = false;

   /**
    * Describes the mapping of local objective information to global objectives
    */
   public Vector mMaps = null;

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Constructors 
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
   /**
    * Default Constructor
    */
   public SeqObjective()
   {
   }

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Constructors 
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
   /**
    * This method provides the state this <code>ADLObjective</code> object for
    * diagnostic purposes.<br>
    */
   public void dumpState()
   {

      if ( _Debug )
      {
         System.out.println("  :: ADLObjective  --> BEGIN - dumpState");

         System.out.println("  ::--> ID:                 " + mObjID);
         System.out.println("  ::--> Satisfy by Measure: " +
                            mSatisfiedByMeasure);
         System.out.println("  ::--> Active Measure:     " + mActiveMeasure);
         System.out.println("  ::--> Min Measure:        " + mMinMeasure);
         System.out.println("  ::--> Contrib to Rollup:  " +
                            mContributesToRollup);
         System.out.println("  ::--> ------------------- <--::");

         if ( mMaps != null )
         {
            for ( int i = 0 ; i < mMaps.size(); i++ )
            {
               SeqObjectiveMap map = (SeqObjectiveMap)mMaps.elementAt(i);

               map.dumpState();
            }
         }

         System.out.println("  :: ADLObjective --> END   - dumpState");
      }
   }
}  // end SeqObjective
