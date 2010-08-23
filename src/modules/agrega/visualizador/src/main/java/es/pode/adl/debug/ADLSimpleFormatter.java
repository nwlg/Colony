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

package es.pode.adl.debug;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * <strong>Filename: </strong> <br>
 * ADLSimpleFormatter.java <br>
 * <br>
 * <strong>Description: </strong> <br>
 * A <code>ADLSimpleFormatter</code> extends Java's SimpleFormatter class and
 * overrides that class's format function. This is so we can modify the messages
 * that are output using Java's logging output messages. Specifically, we do not
 * want the date/timestamp written on each and every message written to the
 * Console. <br>
 * <br>
 * 
 * @author ADL Technical Team <br>
 */
public class ADLSimpleFormatter extends SimpleFormatter
{
   /**
    * A line separator used to separate messages sent to the log.
    */
   private String mLineSeparator = (String)java.security.AccessController
      .doPrivileged(new sun.security.action.GetPropertyAction("line.separator"));

   /**
    * Overrides SimpleFormatter format function. Writes the output without
    * displaying the date/timestamp.
    * 
    * @param iRecord The log record that needs formatted.
    * @return A string formatted for a logging message
    */
   public synchronized String format(LogRecord iRecord)
   {
      StringBuffer sb = new StringBuffer();

      if( iRecord.getSourceClassName() != null )
      {
         sb.append(iRecord.getSourceClassName());
      }
      else
      {
         sb.append(iRecord.getLoggerName());
      }
      if( iRecord.getSourceMethodName() != null )
      {
         sb.append(" ");
         sb.append(iRecord.getSourceMethodName());
      }
      sb.append(" ");

      String message = formatMessage(iRecord);
      sb.append(iRecord.getLevel().getLocalizedName());
      sb.append(": ");
      sb.append(message);
      sb.append(mLineSeparator);

      return sb.toString();
   }
}