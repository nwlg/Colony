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

import es.pode.adl.debug.DebugIndicator;

/**
 * Encapsulation of information required to display a valid table of contents
 * (TOC) for an activity tree.<br><br>
 * 
 * <strong>Filename:</strong> ADLTOC.java<br><br>
 *
 * <strong>Description:</strong><br>
 * The <code>ADLTOC</code> encapsulates the information required by the
 * SCORM 2004 3rd Edition Sample RTE delivery system to display a valid
 * table of contents (TOC) for an activity tree<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE. <br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br><br>
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
public class ADLTOC implements Serializable
{
   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = DebugIndicator.ON;

   /**
    * The title of this entry in the TOC.
    */
   public String mTitle = "";

   /**
    * The depth of this entry in the TOC.
    */
   public int mDepth = -1;

   /**
    * The relative position of this entry in the TOC.
    */
   public int mCount = -1;

   /** 
    * Identifies if the activity is a leaf
    */
   public boolean mLeaf = false;

   /**
    * Identifies the parent of this activity in the TOC
    */
   public int mParent = -1;

   /**
    * Identifies if the parent of this activity has choice = true
    */
   public boolean mInChoice = false;

   /**
    * Indicates if the activity is enabled.
    */
   public boolean mIsEnabled = true;

   /**
    * Indicates if the activity is visible.
    */
   public boolean mIsVisible = true;

   /**
    * Indicates if the activity is the current activity.
    */
   public boolean mIsCurrent = false;

   /**
    * Indicates if the activity is a valid target of choice
    */
   public boolean mIsSelectable = true;

   /**
    * The activity ID of this entry in the TOC.
    */
   public String mID = null;


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * This method provides the state this <code>ADLTOC</code> object for
    * diagnostic purposes.
    */
   public void dumpState()
   {
      if ( _Debug )
      {
         System.out.println("  :: ADLTOC       --> BEGIN - dumpState");

         System.out.println("  ::--> Title:       " + mTitle);
         System.out.println("  ::--> Depth:       " + mDepth);
         System.out.println("  ::--> Count:       " + mCount);
         System.out.println("  ::--> Activity ID: " + mID);
         System.out.println("  ::--> Leaf?        " + mLeaf);
         System.out.println("  ::--> In Choice?   " + mInChoice);
         System.out.println("  ::--> Parent:      " + mParent);
         System.out.println("  ::--> Enabled:     " + mIsEnabled);
         System.out.println("  ::--> Visible:     " + mIsVisible);
         System.out.println("  ::--> Current:     " + mIsCurrent);
         System.out.println("  ::--> Selectable:  " + mIsSelectable);

         System.out.println("  :: ADLTOC       --> END   - dumpState");
      }
   }

}  // end ADLTOC
