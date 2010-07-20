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

import java.io.Serializable;

import es.pode.adl.datamodels.SCODataManager;

/**
 * <strong>Filename:</strong> LMSCMIServletRequest<br><br>
 *
 * This class contains the data that the <code>APIAdapterApplet</code> needs
 * to send across the socket to the <code>LMSCMIServlet</code>.<br><br>
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the SCORM Sample RTE. <br>
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
 *     <li>IMS SS Specification
 *     <li>SCORM 2004</li>
 * </ul>
 *
 * @author ADL Technical Team
 */
public class LMSCMIServletRequest implements Serializable
{
   /**
    * Enumeration of possible request types that are processed by the <code>
    * LMSCMIServlet</code>.
    */
   public static final int TYPE_UNKNOWN = 0;

   /**
    * Enumeration of possible request types that are processed by the <code>
    * LMSCMIServlet</code>.
    */
   public static final int TYPE_INIT = 1;

   /**
    * Enumeration of possible request types that are processed by the <code>
    * LMSCMIServlet</code>.
    */
   public static final int TYPE_GET = 2;

   /**
    * Enumeration of possible request types that are processed by the <code>
    * LMSCMIServlet</code>.
    */
   public static final int TYPE_TIMEOUT = 3;

   /**
    * Enumeration of possible request types that are processed by the <code>
    * LMSCMIServlet</code>.
    */
   public static final int TYPE_SET = 4;

   /**
    * Enumeration of possible request types that are processed by the <code>
    * LMSCMIServlet</code>.
    */
   public static final int TYPE_NAV = 5;

   /**
    * The run-time data that is being send from the client
    */
   public SCODataManager mActivityData = null;

   /**
    * Indicates if the request is being sent due to an LMSFinish
    */
   public boolean mIsFinished = false;

   /**
    * The activity ID of the activity that caused a time out.
    */
   public String mTimeoutActivity = null;

   /**
    * The type of the current Request.
    */
   public int mRequestType = LMSCMIServletRequest.TYPE_UNKNOWN;

   /**
    * The ID of the course associated with this request.
    */
   public String mCourseID = null;

   /**
    * The ID of the student associated with this request.
    */
   public String mStudentID = null;

   /**
    * The name of the student associated with this request.
    */
   public String mUserName = null;

   /**
    * The ID of the run-time data associated with this request.
    */
   public String mStateID = null;

   /**
    * The attempt count associated with the run-time data.
    */
   public String mNumAttempt = null;

   /**
    * The ID of the activity associated with this request.
    */
   public String mActivityID = null;

   /**
    * The location of the SSP Servlet.
    */
   public String mSSPServerLocation = null;

   /**
    * Default constuctor. No defined implementation.
    */
   public LMSCMIServletRequest()
   {
   }

} // LMSCMIServletRequest

