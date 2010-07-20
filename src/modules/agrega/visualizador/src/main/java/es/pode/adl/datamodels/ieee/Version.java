/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/******************************************************************************
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

package es.pode.adl.datamodels.ieee;

import es.pode.adl.datamodels.DMElement;
import es.pode.adl.datamodels.DMErrorCodes;
import es.pode.adl.datamodels.DMProcessingInfo;
import es.pode.adl.datamodels.DMRequest;
import es.pode.adl.datamodels.RequestToken;

/**
 * <br><br>
 * 
 * <strong>Filename:</strong> Version.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * Encapsulates the _version keyword datamodel element defined in SCORM 2004.
 * <br><br> 
 * 
 * <strong>Design Issues:</strong><br><br>
 * 
 * <strong>Implementation Issues:</strong><br><br>
 * 
 * <strong>Known Problems:</strong><br><br>
 * 
 * <strong>Side Effects:</strong><br><br>
 * 
 * <strong>References:</strong><br>
 * <ul>
 *     <li>SCORM 2004
 * </ul>
 * 
 * @author ADL Technical Team
 */
public class Version extends DMElement
{
   /**
    * Describes the dot-notation binding string for this data model element.
    */
   private String mBinding = "_version";


   /**
    * Describes the version of the data model
    */
   private String mVersion = null;


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Constructors
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Constructs a <code>_version</code> keyword data model element describing 
    * the version of data model.
    * 
    * @param iVersion The version indicator of the data model
    */
   public Version(String iVersion)
   {
      mVersion = iVersion;
   }


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Compares the provided value to the value stored in this data model
    * element.
    * 
    * @param iValue A token (<code>RequestToken</code>) object that provides the
    *               value to be compared against the exiting value; this request
    *               may include a set of delimiters.
    * 
    * @param iValidate Describes if the value being compared should be
    *                  validated first.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int equals(RequestToken iValue, boolean iValidate)
   {

      int result = DMErrorCodes.COMPARE_NOTHING;

      if ( iValue != null )
      {
         // Make sure there are no delimiters defined
         if ( iValue.getDelimiterCount() == 0 )
         {
            if ( iValue.getValue().equals(mVersion) )
            {
               result = DMErrorCodes.COMPARE_EQUAL;  
            }
            else
            {
               result = DMErrorCodes.COMPARE_NOTEQUAL;  
            }
         }
         else
         {
            result = DMErrorCodes.COMPARE_NOTEQUAL;  
         }
      }

      return result;
   }

   /**
    * Describes this data model element's binding string.
    * 
    * @return This data model element's binding string.  Note: The <code>
    *         String</code> returned only applies in the context of its
    *         containing data model or parent data model element.
    */
   public String getDMElementBindingString()
   {
      return mBinding;
   }

   /**
    * Attempt to get the value of this data model element, which may include
    * default delimiters.
    * 
    * @param iArguments  Describes the aruguments for this getValue() call.
    * 
    * @param iAdmin      Describes if this request is an administrative action.
    * 
    * @param iDelimiters Indicates if the data model element's default
    *                    delimiters should be included in the return string.
    * 
    * @param oInfo       Provides the value of this data model element.
    *                    <b>Note: The caller of this function must provide an
    *                    initialized (new) <code>DMProcessingInfo</code> to
    *                    hold the return value.</b>
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int getValue(RequestToken iArguments,
                       boolean iAdmin,
                       boolean iDelimiters,
                       DMProcessingInfo oInfo)
   {

      oInfo.mValue = mVersion;

      // Getting a keyword data model element never fails.
      return DMErrorCodes.NO_ERROR;
   }

   /**
    * Processes a data model request on this data model element.  This method
    * will enforce data model element depedencies and keyword application.
    * 
    * @param ioRequest Provides the dot-notation request being applied to this
    *                  data model element.  The <code>DMRequest</code> will be
    *                  updated to account for processing against this data
    *                  model element.
    * 
    * @param oInfo     Provides the value of this data model element.
    *                  <b>Note: The caller of this function must provide an
    *                  initialized (new) <code>DMProcessingInfo</code> to
    *                  hold the return value.</b>
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int processRequest(DMRequest ioRequest, DMProcessingInfo oInfo)
   {
      // Assume no processing errors
      int error = DMErrorCodes.NO_ERROR;

      // If there are more tokens to be processed, we don't have that data
      // model element.
      if ( ioRequest.hasMoreTokens() )
      {
         error = DMErrorCodes.UNDEFINED_ELEMENT;
      }
      else
      {
         // If we here, something is wrong with the request
         error = DMErrorCodes.UNKNOWN_EXCEPTION;
      }

      return error;
   }

   /**
    * Attempt to set the value of this data model element to the value 
    * indicated by the dot-notation token.
    * 
    * @param iValue A token (<code>RequestToken</code>) object that provides the
    *               value to be set and may include a set of delimiters.
    * 
    * @param iAdmin Indicates if this operation is administrative or not.  If
    *               The operation is administrative, read/write and data type
    *               characteristics of the data model element should be
    *               ignored.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int setValue(RequestToken iValue, boolean iAdmin)
   {
      // Never are allowed to set a _version keyword element, even as an
      // admin action
      return DMErrorCodes.SET_KEYWORD;
   }

   /**
    * Validates a dot-notation token against this data model's defined data
    * type.
    * 
    * @param iValue A token (<code>RequestToken</code>) object that provides 
    *               the value to be checked, possibily including a set of
    *               delimiters.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.     
    */
   public int validate(RequestToken iValue)
   {
      // Never have to validate _version, because it is a read-only element
      return DMErrorCodes.NO_ERROR; 
   }

}  // end Version
