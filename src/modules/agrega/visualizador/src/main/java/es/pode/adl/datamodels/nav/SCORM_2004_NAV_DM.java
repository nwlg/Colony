/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

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
******************************************************************************/

package es.pode.adl.datamodels.nav;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

import es.pode.adl.datamodels.DMDelimiterDescriptor;
import es.pode.adl.datamodels.DMElement;
import es.pode.adl.datamodels.DMElementDescriptor;
import es.pode.adl.datamodels.DMErrorCodes;
import es.pode.adl.datamodels.DMProcessingInfo;
import es.pode.adl.datamodels.DMRequest;
import es.pode.adl.datamodels.DataModel;
import es.pode.adl.datamodels.RequestToken;
import es.pode.adl.datamodels.datatypes.URIValidator;
import es.pode.adl.datamodels.datatypes.VocabularyValidator;
import es.pode.adl.sequencer.ADLValidRequests;
import es.pode.adl.sequencer.SeqNavRequests;

/**
 * <strong>Filename:</strong> SCORM_2004_NAV_DM.java<br><br>
 * 
 * <strong>Description:</strong> This class implements the set of navigation events 
 * defined in the SCORM 2004.
 * 
 * @author ADL Technical Team
 */
public class SCORM_2004_NAV_DM extends DataModel implements Serializable
{
   /**
    * Describes the current known 'valid' set of navigation requests.
    */
   ADLValidRequests mNavRequests = null;
 
   /** 
    * Describes the current navigation request.
    */
   String mCurRequest = null;

   /**
    * Describes the dot-notation binding string for this data model.
    */
   private String mBinding = "adl";

   /**
    * Describes the data model elements managed by this data model.
    */
   private Hashtable mElements = null;

   /**
    * Default constructor required for serialization support.  Creates a 
    * complete set of navigation data model information.
    */
   public SCORM_2004_NAV_DM()
   {
      Vector children = null;

      SCORM_2004_NAV_DMElement element = null;
      DMElementDescriptor desc = null;
      DMDelimiterDescriptor del = null;

      mElements = new Hashtable();

      children = new Vector();

      // request
      String [] vocab = { "continue", "previous", "choice", "exit", "exitAll",
         "abandon", "abandonAll", "suspendAll", "_none_"};

      desc = new DMElementDescriptor("request", "_none_", 
                                     new VocabularyValidator(vocab));

      // The 'choice' request will include a delimiter
      del = new DMDelimiterDescriptor("target", null, 
                                      new URIValidator()); 

      desc.mDelimiters = new Vector();
      desc.mDelimiters.add(del);

      children.add(desc);

      Vector subChildren = new Vector();

      // continue
      String [] status = { "true", "false", "unknown"};
      desc = new DMElementDescriptor("continue", "unknown", 
                                     new VocabularyValidator(status));

      desc.mIsWriteable = false;
      subChildren.add(desc);

      // previous
      desc = new DMElementDescriptor("previous", "unknown", 
                                     new VocabularyValidator(status));

      desc.mIsWriteable = false;
      subChildren.add(desc);

      // choice
      desc = new DMElementDescriptor("choice", "unknown", 
                                     new VocabularyValidator(status));

      desc.mIsWriteable = false;
      subChildren.add(desc);

      // request_valid
      desc = new DMElementDescriptor("request_valid", subChildren);
      children.add(desc);

      desc = new DMElementDescriptor("nav", children);

      // Create and add this element to the data model
      element = new SCORM_2004_NAV_DMElement(desc, null, this);

      mElements.put(desc.mBinding, element);
   }

   /**
    * Processes an equals() request against this data model. Compares two 
    * values of the same data model element for equality.
    * 
    * @param iRequest The request (<code>DMRequest</code>) being processed.
    * 
    * @param iValidate Indicates if the provided value should be validated.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int equals(DMRequest iRequest, boolean iValidate)
   {

      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Create an 'out' variable
      DMProcessingInfo pi = new DMProcessingInfo();

      // Process this request
      result = findElement(iRequest, pi);

      // If we found the 'leaf' elmeent, finish the request
      if ( result == DMErrorCodes.NO_ERROR )
      {
         RequestToken tok = iRequest.getNextToken();

         // Before processing, make sure this is the last token in the request
         if ( !iRequest.hasMoreTokens() )
         {
            // Make sure this is a  Value token
            if ( tok.getType() == RequestToken.TOKEN_VALUE )
            {
               result = pi.mElement.equals(tok);
            }
            else
            {
               // Wrong type of token -- value expected
               result = DMErrorCodes.INVALID_REQUEST;
            }
         }
         else
         {
            // Too many tokens
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }

      return result;
   }

   /**
    * Describes this data model's binding string.
    * 
    * @return This data model's binding string.
    */
   public String getDMBindingString()
   {
      return mBinding;
   }

   /**
    * Provides the requested data model element.
    * 
    * @param iElement Describes the requested element's dot-notation bound name.
    * 
    * @return The <code>DMElement</code> corresponding to the requested element
    *         or <code>null</code> if the element does not exist in the data
    *         model.
    */
   public DMElement getDMElement(String iElement)
   {
      DMElement element = (DMElement)mElements.get(iElement);

      return element;
   }


   /**
    * Provides the current navigation request communicated by the SCO.
    * 
    * @return The current navigation request.
    */
   public String getNavRequest()
   {
      String request = null;
      int navEvent = SeqNavRequests.NAV_NONE;

      if ( mCurRequest != null )
      {
         if ( mCurRequest.equals("continue") )
         {
            navEvent = SeqNavRequests.NAV_CONTINUE;
         }
         else if ( mCurRequest.equals("previous") )
         {
            navEvent = SeqNavRequests.NAV_PREVIOUS;
         }
         else if ( mCurRequest.equals("exit") )
         {
            navEvent = SeqNavRequests.NAV_EXIT;
         }
         else if ( mCurRequest.equals("exitAll") )
         {
            navEvent = SeqNavRequests.NAV_EXITALL;
         }
         else if ( mCurRequest.equals("abandon") )
         {
            navEvent = SeqNavRequests.NAV_ABANDON;
         }
         else if ( mCurRequest.equals("abandonAll") )
         {
            navEvent = SeqNavRequests.NAV_ABANDONALL;
         }
         else if ( mCurRequest.equals("suspendAll") )
         {
            navEvent = SeqNavRequests.NAV_SUSPENDALL;
         }
         else if ( mCurRequest.equals("_none_") )
         {
            navEvent = SeqNavRequests.NAV_NONE;
         }
         else
         {
            // This must be a target for choice
            request = mCurRequest;
         }
      }

      if ( request == null )
      {
         request = Integer.toString(navEvent);
      }

      return request;
   }


   /**
    * Processes a GetValue() request against this data model.
    * 
    * @param iRequest The (<code>DMRequest</code>) being processed.
    * 
    * @param oInfo    Provides the value returned by this request.
    * 
    * @return A data model error code indicating the result of this
    *         operation.
    */
   public int getValue(DMRequest iRequest, DMProcessingInfo oInfo)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Create an 'out' variable
      DMProcessingInfo pi = new DMProcessingInfo();

      // Process this request
      result = findElement(iRequest, pi);

      // If we found the 'leaf' elmeent, finish the request
      if ( result == DMErrorCodes.NO_ERROR )
      {
         RequestToken tok = iRequest.getNextToken();

         // Before processing, make sure this is the last token in the request
         if ( !iRequest.hasMoreTokens() )
         {
            result = pi.mElement.getValue(tok,
                                          iRequest.isAdminRequest(),
                                          iRequest.supplyDefaultDelimiters(), 
                                          oInfo);
         }
         else
         {
            // Too many tokens
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }

      return result;
   }

   /**
    * Performs data model specific initialization.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int initialize()
   {
      return DMErrorCodes.NO_ERROR;
   }


   /**
    * Sets the current 'known' set of valid navigation requests for the SCO
    * to the SCO's instance of the SCORM Navigation Data Model.
    * 
    * @param iValid  The current 'known' set of valid navigation requests.
    */
   public void setValidRequests(ADLValidRequests iValid)
   {
      mNavRequests = iValid;
   }


   /**
    * Processes a SetValue() request against this data model.  Checks the 
    * request for validity.
    * 
    * @param iRequest The request (<code>DMRequest</code>) being processed.
    * 
    * @return A data model error code indicating the result of this
    *         operation.
    */
   public int setValue(DMRequest iRequest)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Create an 'out' variable
      DMProcessingInfo pi = new DMProcessingInfo();

      // Process this request
      result = findElement(iRequest, pi);

      // If we found the 'leaf' element, finish the request
      if ( result == DMErrorCodes.NO_ERROR )
      {
         RequestToken tok = iRequest.getNextToken();

         // Before processing, make sure this is the last token in the requset
         if ( !iRequest.hasMoreTokens() )
         {

            // Make sure this is a Value token
            if ( tok.getType() == RequestToken.TOKEN_VALUE )
            {
               if ( result == DMErrorCodes.NO_ERROR )
               {
                  result = pi.mElement.setValue(tok, iRequest.isAdminRequest());
               }
            }
            else
            {
               // Wrong type of token -- value expected
               result = DMErrorCodes.INVALID_REQUEST;
            }
         }
         else
         {
            // Too many tokens
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }

      return result;
   }

   /**
    * Displays the contents of the entire data model.
    */
   public void showAllElements()
   {
     // Not implemented at this time
   }

   /**
    * Performs data model specific termination.
    * 
    * @return A data model error code indicating the result of this
    *         operation.
    */
   public int terminate()
   {
      // Clear the current nav request
      DMRequest req = new DMRequest("adl.nav.request", "_none_", true);
      
      // Remove the data model token, since we do not need the return
      // value, there is no need to assign it to a local variable
      req.getNextToken();

      // Invoke a SetValue() method call sending in the DMRequest.  There is
      // no need to capture the return from the setValue(), therefore there
      // is no need to assign it to a local variable
      setValue(req);
      
      mCurRequest = null;

      // Clear the current set of valid navigation requests
      mNavRequests = null;

      return DMErrorCodes.NO_ERROR;
   }

   /**
    * Processes a validate() request against this data model.
    * 
    * @param iRequest The (<code>DMRequest</code>) being processed.
    * 
    * @return A data model error code indicating the result of this
    *         operation.
    */
   public int validate(DMRequest iRequest)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Create an 'out' variable
      DMProcessingInfo pi = new DMProcessingInfo();

      // Process this request
      result = findElement(iRequest, pi);

      // If we found the 'leaf' element, finish the request
      if ( result == DMErrorCodes.NO_ERROR )
      {
         RequestToken tok = iRequest.getNextToken();

         // Before processing, make sure this is the last token in the request
         if ( !iRequest.hasMoreTokens() )
         {
            // Make sure this is a Value token
            if ( tok.getType() == RequestToken.TOKEN_VALUE )
            {
               result = pi.mElement.validate(tok);
            }
            else
            {
               // Wrong type of token -- value expected
               result = DMErrorCodes.INVALID_REQUEST;
            }
         }
         else
         {
            // Too many tokens
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }

      return result;
   }

   /**
    * Processes a data model request by finding the target leaf element.
    * If the requested value is found, it is returned in the parameter
    * oInfo.
    * 
    * @param iRequest The (<code>DMRequest</code>) being processed.
    * 
    * @param oInfo    Provides the value returned by this request.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   private int findElement(DMRequest iRequest, DMProcessingInfo oInfo)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Get the first specified element
      RequestToken tok = iRequest.getNextToken();

      if ( tok != null && tok.getType() == RequestToken.TOKEN_ELEMENT )
      {

         DMElement element = (DMElement)mElements.get(tok.getValue());

         if ( element != null )
         {

            oInfo.mElement = element;

            // Check if we need to stop before the last token
            tok = iRequest.getCurToken();
            boolean done = false;

            if ( tok != null )
            {
               if ( iRequest.isGetValueRequest() )
               {
                  if ( tok.getType() == RequestToken.TOKEN_ARGUMENT )
                  {
                     // We're done
                     done = true;
                  }
                  else if ( tok.getType() == RequestToken.TOKEN_VALUE )
                  {
                     // Get requests cannot have value tokens
                     result = DMErrorCodes.INVALID_REQUEST;

                     done = true;
                  }
               }
               else
               {
                  if ( tok.getType() == RequestToken.TOKEN_VALUE )
                  {
                     // We're done
                     done = true;
                  }
                  else if ( tok.getType() == RequestToken.TOKEN_ARGUMENT )
                  {
                     // Set requests cannot have argument tokens
                     result = DMErrorCodes.INVALID_REQUEST;

                     done = true;
                  }
               }
            }

            // Process remaining tokens
            while ( !done && iRequest.hasMoreTokens() && 
                    result == DMErrorCodes.NO_ERROR )
            {
               result = element.processRequest(iRequest, oInfo);

               // Move to the next element if processing was successful
               if ( result == DMErrorCodes.NO_ERROR )
               {
                  element = oInfo.mElement;
               }
               else
               {
                  oInfo.mElement = null;
               }

               // Check if we need to stop before the last token
               tok = iRequest.getCurToken();

               if ( tok != null )
               {
                  if ( iRequest.isGetValueRequest() )
                  {
                     if ( tok.getType() == RequestToken.TOKEN_ARGUMENT )
                     {
                        // We're done
                        done = true;
                     }
                     else if ( tok.getType() == RequestToken.TOKEN_VALUE )
                     {
                        // Get requests cannot have value tokens
                        result = DMErrorCodes.INVALID_REQUEST;
   
                        done = true;
                     }
                  }
                  else
                  {
                     if ( tok.getType() == RequestToken.TOKEN_VALUE )
                     {
                        // We're done
                        done = true;
                     }
                     else if ( tok.getType() == RequestToken.TOKEN_ARGUMENT )
                     {
                        // Set requests cannot have argument tokens
                        result = DMErrorCodes.INVALID_REQUEST;
   
                        done = true;
                     }
                  }
               }
            }
         }
         else
         {
            // Unknown element
            result = DMErrorCodes.UNDEFINED_ELEMENT;
         }
      }
      else
      {
         // No initial element specified
         result = DMErrorCodes.INVALID_REQUEST;
      }

      return result;
   }

} // end SCORM_2004_NAV_DM
