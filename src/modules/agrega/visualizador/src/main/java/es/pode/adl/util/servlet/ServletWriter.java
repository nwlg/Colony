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

package es.pode.adl.util.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
//import org.apache.log4j.Logger;
import java.util.logging.Logger;
import es.pode.adl.debug.DebugIndicator;


/**
 * Provides a means to 'POST' multiple serialized objects to a servlet.<br><br>
 *
 * <strong>Filename:</strong> ServletWriter<br><br>
 *
 * <strong>Description:</strong><br>
 * This class provides a method of posting multiple serialized objects to a
 * Java servlet and getting objects in return. This code was inspired by code
 * samples from the book 'Java Servlet Programming' by Jason Hunter and William
 * Crawford (O'Reilly & Associates. 1998).<br><br>
 *
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the SCORM 2004 3rd Edtion Sample
 * RTE. <br>
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
 *     <li>SCORM 2004 3rd Edition
 * </ul>
 *
 * @author ADL Technical Team
 */
public class ServletWriter
{
	Logger mLogger = Logger.getLogger("ServletWriter");

   /**
    * This controls display of log messages to the java console
    */
   private static boolean _Debug = DebugIndicator.ON;


   /**
    * Provides a means to 'POST' multiple serialized objects to a servlet.
    *
    * @param iServlet   The URL of the target servlet.
    *
    * @param iObjs      A list of objects to be serialized during the POST.
    *
    * @return A stream of serialized objects.
    * @exception Exception
    */
   static public ObjectInputStream postObjects(URL iServlet,
                                               Serializable iObjs[])
                                               throws Exception
   {
	   Logger mLogger = Logger.getLogger("ServletWriter");
	   
      if ( _Debug )
      {
         mLogger.info("In ServletWriter::postObjects()");
      }

      URLConnection con = null;

      try
      {
         if ( _Debug )
         {
            mLogger.info("Opening HTTP URL connection to " +
                               "servlet.");
         }

         con = iServlet.openConnection();
      }
      catch ( Exception e )
      {
         mLogger.severe("e = 1");

         if ( _Debug )
         {
            mLogger.severe("Exception caught in " +
                               "ServletWriter::postObjects() ");
           
         }

         mLogger.severe(e.getMessage());
         throw e;
      }


      if ( _Debug )
      {
         mLogger.info("HTTP connection to servlet is open");
         mLogger.info("configuring HTTP connection properties");
      }

      con.setDoInput(true);
      con.setDoOutput(true);
      con.setUseCaches(false);
      con.setRequestProperty("Content-Type","text/plain");
      con.setAllowUserInteraction(false);

      // Write the arguments as post data
      ObjectOutputStream out = null;

      try
      {
         if ( _Debug )
         {
            mLogger.info("Creating new http output stream");
         }

         out = new ObjectOutputStream(con.getOutputStream());

         if ( _Debug )
         {
            mLogger.info("Created new http output stream.");
            mLogger.info("Writing command and data to servlet...");
         }

         int numObjects = iObjs.length;

         if ( _Debug )
         {
            mLogger.info ("Num objects: " + numObjects);
         }

         for ( int i = 0; i < numObjects; i++ )
         {
            out.writeObject( iObjs[i]);

            if ( _Debug )
            {
               mLogger.info("Just wrote a serialized object on " +
                                  "output stream... " +
                                  iObjs[i].getClass().getName());
            }
         }
      }
      catch ( Exception e )
      {
         if ( _Debug )
         {
            mLogger.severe("Exception caught in " +
                               "ServletWriter::postObjects()");
            mLogger.severe(e.getMessage());
         }

         mLogger.severe(" Exception " + e);
         throw e;
      }

      try
      {
         if ( _Debug )
         {
            mLogger.info("Flushing Object Output Stream.");
         }
         out.flush();
      }
      catch ( IOException ioe )
      {
         if ( _Debug )
         {
            mLogger.severe("Caught IOException when calling " +
                               "out.flush()");
            mLogger.severe(ioe.getMessage());
         }

         mLogger.severe("Caught IOException when calling " +
         "out.flush()" + ioe);
         throw ioe;
      }
      catch ( Exception e )
      {
         if ( _Debug )
         {
            mLogger.info("Caught Exception when calling " +
                               "out.flush()" );
            mLogger.info(e.getMessage());
         }

         mLogger.severe("Caught Exception when calling " +
         "out.flush() " +e );
         throw e;
      }

      try
      {
         if ( _Debug )
         {
            mLogger.info("Closing object output stream.");
         }
         out.close();
      }
      catch ( IOException  ioe )
      {
         if ( _Debug )
         {
            mLogger.info("Caught IOException when calling " +
                               "out.close()");
            mLogger.info(ioe.getMessage());
         }

         mLogger.severe("Caught IOException when calling " +
         "out.close() " + ioe);
         throw ioe;
      }
      catch ( Exception e )
      {
         if ( _Debug )
         {
            mLogger.info("Caught Exception when calling " +
                               "out.close()");
            mLogger.info(e.getMessage());
         }

         mLogger.severe("Caught Exception when calling " +
                            "out.close() " +e);
        throw e;
      }

      ObjectInputStream in;

      try
      {
         if ( _Debug )
         {
            mLogger.info("Creating new http input stream.");
         }

         in = new ObjectInputStream(con.getInputStream());
      }
      catch ( Exception e )
      {
         if ( _Debug )
         {
            mLogger.info("Exception caught in " +
                               "ServletWriter::postObjects()");
            mLogger.info( e.getMessage() );
         }
         mLogger.severe("Exception caught in " +
         "ServletWriter::postObjects() " + e );
         throw e;
      }

      return in;
   }

} // ServletWriter
