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

package es.pode.adl.datamodels;

import java.util.NoSuchElementException;


/**
 * <strong>Filename:</strong>DMInterface.java<br><br>
 *
 * <strong>Description:</strong><br>
 *
 * <strong>Design Issues:</strong> None <br><br>
 *
 * <strong>Implementation Issues:</strong> None <br><br>
 *
 * <strong>Known Problems:</strong> None <br><br>
 *
 * <strong>Side Effects:</strong> None <br><br>
 *
 * <strong>References:</strong><br>
 * <ul>
 *     <li>SCORM 1.3</li>
 * </ul>
 *
 * @author ADL Technical Team
 */
public class DMInterface
{

   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Processes a GetValue() against a known set of SCO run-time data
    * (<code>SCODataManager</code>.
    * 
    * @param iRequest       A dot-notation binding of the desired data model
    *                       element.
    * 
    * @param iDefDelimiters Indicates if the value returned should include
    *                       default delimiters.
    * 
    * @param ioSCOData      An instance of the <code>SCODataManager</code> that
    *                       contains the run-time data for the individual SCO.
    * 
    * @param oInfo          Provides the value of this data model element.
    *                       <b>Note: The caller of this function must provide an
    *                       initialized (new) <code>DMProcessingInfo</code> to
    *                       hold the return value.</b>
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public static int processGetValue(String iRequest,
                                     boolean iDefDelimiters,
                                     SCODataManager ioSCOData,
                                     DMProcessingInfo oInfo)
   {
      // Delegate non-admin calls
      return processGetValue(iRequest, false, iDefDelimiters, ioSCOData, oInfo);
   }


   /**
    * Processes a GetValue() against a known set of SCO run-time data
    * (<code>SCODataManager</code>.
    * 
    * @param iRequest       A dot-notation binding of the desired data model
    *                       element.
    * 
    * @param iAdmin         Indicates if this GetValue is an admin acttion
    * 
    * @param iDefDelimiters Indicates if the value returned should include
    *                       default delimiters.
    * 
    * @param ioSCOData      An instance of the <code>SCODataManager</code> that
    *                       contains the run-time data for the individual SCO.
    * 
    * @param oInfo          Provides the value of this data model element.
    *                       <b>Note: The caller of this function must provide an
    *                       initialized (new) <code>DMProcessingInfo</code> to
    *                       hold the return value.</b>
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public static int processGetValue(String iRequest,
                                     boolean iAdmin,
                                     boolean iDefDelimiters,
                                     SCODataManager ioSCOData,
                                     DMProcessingInfo oInfo)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      DMRequest request = null;

      if ( iRequest != null && !iRequest.equals("") )
      {
         // Attempt to create a DMRequest using the provided value
         try
         {
            request = new DMRequest(iRequest, iAdmin, iDefDelimiters);

            // Process the GetValue() request
            result = ioSCOData.getValue(request, oInfo);
         }
         catch ( NullPointerException npe )
         {
            result = DMErrorCodes.INVALID_REQUEST; 
         }
         catch (NumberFormatException nfe)
         {
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         result = DMErrorCodes.ELEMENT_NOT_SPECIFIED;
      }

      return result;
   }

   /**
    * Processes a SetValue() against a known set of SCO run-time data
    * (<code>SCODataManager</code>.
    * 
    * @param iRequest  A dot-notation binding of the desired data model element.
    * 
    * @param iValue    Indicates the value that will be set.
    * 
    * @param iAdmin    Indicates if this SetValue is an administrative action.
    * 
    * @param ioSCOData An instance of the <code>SCODataManager</code> that
    *                  contains the run-time data for the individual SCO.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public static int processSetValue(String iRequest, 
                                     String iValue,
                                     boolean iAdmin,
                                     SCODataManager ioSCOData)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      DMRequest request = null;


      if ( iRequest != null && !iRequest.equals("") )
      {

         if ( iValue != null )
         {        
            // Attempt to create a DMRequest using the provided value
            try
            {
               request = new DMRequest(iRequest, iValue, iAdmin);
   
               // Process the SetValue() request
               result = ioSCOData.setValue(request);
            }
            catch ( NullPointerException npe )
            {
               result = DMErrorCodes.INVALID_REQUEST; 
            }
            catch (NumberFormatException nfe)
            {
               result = DMErrorCodes.INVALID_REQUEST;
            }
         }
         else
         {
            // No second parameter defined
            result = DMErrorCodes.GEN_ARGUMENT_ERROR;
         }
      }
      else
      {
         result = DMErrorCodes.ELEMENT_NOT_SPECIFIED;
      }

      return result;
   }


   /**
    * Processes an equals() against a known set of SCO run-time data
    * (<code>SCODataManager</code>.
    * 
    * @param iRequest  A dot-notation binding of the desired data model element.
    * 
    * @param iValue    Indicates the value that will be compared.
    * 
    * @param ioSCOData An instance of the <code>SCODataManager</code> that
    *                  contains the run-time data for the individual SCO.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public static int processEquals(String iRequest, 
                                   String iValue,
                                   SCODataManager ioSCOData)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      DMRequest request = null;

      if ( iRequest != null )
      {
         // Attempt to create a DMRequest using the provided value
         try
         {
            request = new DMRequest(iRequest, iValue, false);

            // Process the Equals() request
            result = ioSCOData.equals(request);
         }
         catch ( NullPointerException npe )
         {
            result = DMErrorCodes.INVALID_REQUEST; 
         }
         catch (NumberFormatException nfe)
         {
            result = DMErrorCodes.INVALID_REQUEST;
         }
         catch (NoSuchElementException nee )
         {
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         result = DMErrorCodes.ELEMENT_NOT_SPECIFIED;
      }

      return result;
   }


   /**
    * Processes a validate() against a known set of SCO run-time data
    * (<code>SCODataManager</code>.
    * 
    * @param iRequest  A dot-notation binding of the desired data model element.
    * 
    * @param iValue    Indicates the value that will be compared.
    * 
    * @param ioSCOData An instance of the <code>SCODataManager</code> that
    *                  contains the run-time data for the individual SCO.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public static int processValidate(String iRequest, 
                                     String iValue,
                                     SCODataManager ioSCOData)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      DMRequest request = null;

      if ( iRequest != null )
      {
         // Attempt to create a DMRequest using the provided value
         try
         {
            request = new DMRequest(iRequest, iValue, false);

            // Process the Equals() request
            result = ioSCOData.validate(request);
         }
         catch ( NullPointerException npe )
         {
            result = DMErrorCodes.INVALID_REQUEST; 
         }
         catch (NumberFormatException nfe)
         {
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         result = DMErrorCodes.ELEMENT_NOT_SPECIFIED;
      }

      return result;
   }


} // end DMInterface
