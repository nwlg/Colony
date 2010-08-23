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


/**
 * Enumeration of acceptable navigation requests.<br><br>
 * 
 * <strong>Filename:</strong> SeqNavRequests.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * The <code>ADLSequencer</code> will accept the navigation requests defined
 * in by this class.  Requests correspond to the IMS SS Specification section
 * Navagation Behavior (NB) section.<br><br>
 * 
 * Navigation requests are signaled to the sequencer through the <code>
 * ADLNavigation</code> interface.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE.<br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br>
 * This enumeration does not include the 'choice' navigation request.  Because 
 * the 'choice' navigation request requires a parameter indicating the target
 * activity, 'choice' navigation requests are triggered through an independent
 * method on the <code>ADLNavigation</code> interface.
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
public class SeqNavRequests
{

   /**
    * Enumeration of possible navigation requests -- 
    * In this case, No navigation request is also valid.
    * <br>None
    * <br><b>0</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_NONE               =  0;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>Start
    * <br><b>1</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_START              =  1;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>Resume All
    * <br><b>2</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_RESUMEALL          =  2;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>Continue
    * <br><b>3</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_CONTINUE           =  3;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>Previous
    * <br><b>4</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_PREVIOUS           =  4;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>Abandon
    * <br><b>5</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_ABANDON            =  5;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>AbandonAll
    * <br><b>6</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_ABANDONALL         =  6;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>SuspendAll
    * <br><b>7</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_SUSPENDALL         =  7; 

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>Exit
    * <br><b>8</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_EXIT               =  8;

   /**
    * Enumeration of possible navigation requests -- described in Navigation
    * Behavior (Section NB of the IMS SS Specification).
    * <br>ExitAll
    * <br><b>9</b>
    * <br>[SEQUENCING SUBSYSTEM CONSTANT]
    */
   public static final int NAV_EXITALL            =  9;


}  // end SeqNavRequests
