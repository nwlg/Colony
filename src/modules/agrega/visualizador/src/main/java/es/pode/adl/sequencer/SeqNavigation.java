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
 * Provides an interface for the RTE to communicate navigation requests to the
 * sequencer<br><br>.
 * 
 * <strong>Filename:</strong> SeqNavigation.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * This interface represents the entry point to the Overall Sequencing Process
 * described in IMS ss.  The two <code>navigate</code> methods provide a way
 * for the RTE to signal a navigation request. Each <code>navigate</code>
 * method provides an <code>SeqLaunch</code> object, which contains the 
 * information required by the RTE to launch the resource(s) associated with the
 * idenified activity, or an error code if any sequencing process fails.<br><br>
 * 
 * When an navigation request does not result in an activity to be delivered,
 * an <code>ADLLaunch</code> object will still be returned by, however the value
 * its <code>mSeqNonContent</code> field will contain a special value from the
 * <code>ADLLaunch.LAUNCH_[XXX]</code> enumeration.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE. <br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br>
 * It is the responsibility of the implementation of this interface to
 * perform any and all prelauch actions to prepare the identifed activity (and
 * its resource(s)) for launch, prior to returning an <code>ADLLaunch</code> 
 * object.<br><br>
 * 
 * If the navigation event does not result in a deliverable activity, it is the
 * responsibily of the RTE to gracefully handle other results.<br><br>
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
public interface SeqNavigation
{
   /**
    * This method is used to inform the sequencer that a navigation request,
    * other than 'Choice' has occured.
    * 
    * @param iRequest Indicates which navigation request should be processed.
    * 
    * @return Information about the 'Next' activity to delivery or a processing
    *         error.
    * @see org.adl.sequencer.SeqNavRequests
    * @see org.adl.sequencer.ADLLaunch
    */
   ADLLaunch navigate(int iRequest);


   /**
    * This method is used to inform the sequencer that a 'Choice' navigation
    * request has occured.
    * 
    * @param iTarget ID (<code>String</code>) of the target activity.
    * 
    * @return Information about the 'Next' activity to delivery or a processing
    *         error.
    * @see org.adl.sequencer.ADLLaunch
    */
   ADLLaunch navigate(String iTarget);


}  // end SeqNavigation
