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

package es.pode.adl.client;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URL;

import es.pode.adl.debug.DebugIndicator;
import es.pode.adl.server.LMSCMIServletRequest;
import es.pode.adl.server.LMSCMIServletResponse;
import es.pode.adl.util.servlet.ServletWriter;

/**
 * 
 * <strong>Filename:</strong> ServletProxy<br><br>
 *
 * <strong>Description:</strong><br>
 * This class encapsulates communication between the API Adapter applet and
 * the <code>LMSCMIServlet</code>.<br><br>
 *
 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the SCORM 2004 3rd Edition Sample RTE. <br>
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
 *     <li>SCORM 2004 3rd Edition</li>
 * </ul>
 *
 * @author ADL Technical Team
 */
public class ServletProxy
{
   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = false;

   /**
    * The URL of the target servlet.
    */
   private URL mServletURL = null;

   /**
    * Constructor
    *
    * @param iURL  The URL of the target servlet.
    */
   public ServletProxy(URL iURL)
   {
      mServletURL = iURL;
   }

   /**
    * Reads from the LMS server via the <code>LMSCMIServlet</code>; the
    * <code>SCODataManager</code> object containing all of the run-time data
    *  model elements relevant for the current user (student) and current SCO.
    *
    * @param iRequest A <code>LMSCMIServletRequest</code> object that
    *                 provides all the data neccessary to POST a call to
    *                 the <code>LMSCMIServlet</code>.
    *
    * @return The <code>LMSCMIServletResponse</code> object provided by the
    *         <code>LMSCMIServlet</code>.
    */
   public LMSCMIServletResponse postLMSRequest(LMSCMIServletRequest iRequest)
   {

      if( _Debug )
      {
         System.out.println("In ServletProxy::postLMSRequest()");
      }

      LMSCMIServletResponse response = new LMSCMIServletResponse();

      try
      {
         if( _Debug )
         {
            System.out.println("In ServletProxy::postLMSRequest()");
         }

         Serializable[] data = { iRequest };

         if( _Debug )
         {
            System.out.println("Before postObjects()");
         }

         ObjectInputStream in = ServletWriter.postObjects(mServletURL, data);

         if( _Debug )
         {
            System.out.println("Back In ServletProxy::postLMSRequest()");
            System.out.println("Attempting to read servlet " + "response now...");
         }

         response = (LMSCMIServletResponse)in.readObject();

         in.close();
         response.mError = "OK";
      }
      catch( Exception e )
      {
         if( _Debug )
         {
            System.out.println("Exception caught in " + "ServletProxy::postLMSRequest()");
            System.out.println(e.getMessage());
         }

         e.printStackTrace();
         response.mError = "FAILED";
      }

      return response;
   }

   /**
    * Reads from the LMS server via the <code>SSP_Servlet</code>; the
    * response containing the information requested.
    *
    * @param iRequest A <code>SSP_ServletRequest</code> object that
    *                 provides all the data neccessary to POST a call to
    *                 the <code>SSP_Servlet</code>.
    *
    * @return The <code>LMSCMIServletResponse</code> object provided by the
    *         <code>LMSCMIServlet</code>.
    */
//   public SSP_ServletResponse postLMSRequest(SSP_ServletRequest iRequest)
//   {
//
//      if( _Debug )
//      {
//         System.out.println("In ServletProxy::postLMSRequest()");
//      }
//
//      SSP_ServletResponse response = new SSP_ServletResponse();
//
//      try
//      {
//         Serializable[] data = { iRequest };
//
//         if( _Debug )
//         {
//            System.out.println("Before postObjects()");
//         }
//
//         ObjectInputStream in = ServletWriter.postObjects(mServletURL, data);
//
//         if( _Debug )
//         {
//            System.out.println("Back In " + "ServletProxy::postLMSRequest()");
//            System.out.println("Attempting to read servlet " + "response now...");
//         }
//
//         response = (SSP_ServletResponse)in.readObject();
//
//         in.close();
//      }
//      catch( Exception e )
//      {
//         if( _Debug )
//         {
//            System.out.println("Exception caught in " + "ServletProxy::postLMSRequest()");
//            System.out.println(e.getMessage());
//         }
//
//         e.printStackTrace();
//         response.mManagedBucketInfo.setSuccessStatus(SuccessStatus.FAILURE);
//      }
//
//      return response;
//   }
//
} // ServletProxy
