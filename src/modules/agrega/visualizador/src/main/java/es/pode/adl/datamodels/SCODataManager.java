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

package es.pode.adl.datamodels;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 * <strong>Filename:</strong>SCODataManager.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * This class is responsible for maintaining the SCORM Data Model for a single
 * instance of a Sharable Content Object (SCO). The SCO Data Manager is
 * responsible for any interactions the LMS, learner or SCO may have with the
 * Data Model.<br><br>
 * 
 * <strong>Design Issues:</strong><br> none.
 * <br><br>
 * 
 * <strong>Implementation Issues:</strong><br> None
 * <br><br>
 * 
 * <strong>Known Problems:</strong> None<br><br>
 * 
 * <strong>Side Effects:</strong> None<br><br>
 * 
 * <strong>References:</strong> SCORM 2004<br>
 *  
 * @author ADL Technical Team
 */
public class SCODataManager implements Serializable
{
   /**
    * Describes the set of run-time data models managed for the SCO.
    */
   private Hashtable mDataModels = null;

   /**
    * Default constructor required for serialization support. Its only action
    * is to create a null Hashtable mDataModels.
    */
   public SCODataManager() 
   {
      // Default constructor - no explicit functionallity defined   
   }

   /**
    * Adds the identified data model to the set of run-time data models managed
    * for this SCO.  First checks the current set of managed data models
    * to ensure that the data model to be added is not aready present in the 
    * Hashtable.
    * 
    * @param iModel  Describes the run-time data model to be added.
    */
   public void addDM(int iModel)
   {
      // Create the indicated data model
      DataModel dm = DMFactory.createDM(iModel);

      if ( dm != null )
      {
         // Make sure this data model isn't already being managed
         if ( mDataModels == null )
         {
            mDataModels = new Hashtable();

            mDataModels.put(dm.getDMBindingString(), dm);
         }
         else
         {
            DataModel check = 
               (DataModel)mDataModels.get(dm.getDMBindingString());

            if ( check == null )
            {
               mDataModels.put(dm.getDMBindingString(), dm);
            }
         }
      }
   }

   /**
    * Processes an equals() request against the SCO's run-time data.
    * 
    * @param iRequest The request (<code>DMRequest</code>) being processed.
    * 
    * @return A data model error code indicating the result of this
    *         operation.
    */
   public int equals(DMRequest iRequest)
   {

      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Make sure there is a request to process and some data model to
      // process it on
      if ( iRequest != null && mDataModels != null )
      {
         RequestToken tok = iRequest.getNextToken();

         // The first request token must be a data model token
         if ( tok.getType() == RequestToken.TOKEN_DATA_MODEL )
         {

            DataModel dm = (DataModel)mDataModels.get(tok.getValue());

            // Make sure the data model exists
            if ( dm != null )
            {
               // Process this request
               result = dm.equals(iRequest);
            }
            else
            {
               // Specified data model element does not exist
               result = DMErrorCodes.UNDEFINED_ELEMENT;
            }
         }
         else
         {
            // No data model specified
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         // Nothing to process or nothing to process on
         result = DMErrorCodes.UNKNOWN_EXCEPTION;
      }

      return result;
   }

   /**
    * Retrieves a specific Data Model managed by this 
    * <code>SCODataManager</code>.
    * 
    * @param iDataModel  Describes the dot-notation binding string of the
    *                    desired data model.
    * 
    * @return The <code>DataModel</code> object associated with the
    *         requested data model.
    */
   public DataModel getDataModel(String iDataModel)
   {
      DataModel dm = null;

      if ( mDataModels != null )
      {
         dm = (DataModel)mDataModels.get(iDataModel);
      }

      return dm;
   }

   /**
    * Processes a GetValue() request against the SCO's run-time data.
    * 
    * @param iRequest The request (<code>DMRequest</code>) being processed.
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

      // Make sure there is a request to process and some data model to
      // process it on
      if ( iRequest != null && mDataModels != null )
      {
         RequestToken tok = iRequest.getNextToken();

         // The first request token must be a data model token
         if ( tok.getType() == RequestToken.TOKEN_DATA_MODEL )
         {
            DataModel dm = (DataModel)mDataModels.get(tok.getValue());

            // Make sure the data model exists
            if ( dm != null )
            {
               // Process this request
               result = dm.getValue(iRequest, oInfo);
            }
            else
            {
               // Specified data model element does not exist
               result = DMErrorCodes.UNDEFINED_ELEMENT;
            }
         }
         else
         {
            // No data model specified
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         // Nothing to process or nothing to process on
         result = DMErrorCodes.UNKNOWN_EXCEPTION;
      }

      return result;
   }

   /** 
    * Initializes all data models being managed for this SCO.
    */
   public void initialize()
   {
      if ( mDataModels != null )
      {
         Enumeration theEnum = mDataModels.elements();

         while ( theEnum.hasMoreElements() )
         {
            DataModel dm = (DataModel)theEnum.nextElement();

            dm.initialize();
         }
      }
   }

   /**
    * Processes a SetValue() request against the SCO's run-time data.
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

      // Make sure there is a request to process and some data model to
      // process it on
      if ( iRequest != null && mDataModels != null )
      {
         RequestToken tok = iRequest.getNextToken();

         // The first request token must be a data model token
         if ( tok.getType() == RequestToken.TOKEN_DATA_MODEL )
         {
            DataModel dm = (DataModel)mDataModels.get(tok.getValue());

            // Make sure the data model exists
            if ( dm != null )
            {
               // Process this request
               result = dm.setValue(iRequest);
            }
            else
            {
               // Specified data model element does not exist
               result = DMErrorCodes.UNDEFINED_ELEMENT;
            }
         }
         else
         {
            // No data model specified
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         // Nothing to process or nothing to process on
         result = DMErrorCodes.UNKNOWN_EXCEPTION;
      }

      return result;
   }

   /** 
    * Terminates all data models being managed for this SCO.
    */
   public void terminate()
   {
      if ( mDataModels != null )
      {
         Enumeration theEnum = mDataModels.elements();

         while ( theEnum.hasMoreElements() )
         {
            DataModel dm = (DataModel)theEnum.nextElement();

            dm.terminate();
         }
      }
   }

   /**
    * Processes a validate() request against the SCO's run-time data.
    * 
    * @param iRequest The request (<code>DMRequest</code>) being processed.
    * 
    * @return A data model error code indicating the result of this
    *         operation.
    */
   public int validate(DMRequest iRequest)
   {
      // Assume no processing errors
      int result = DMErrorCodes.NO_ERROR;

      // Make sure there is a request to process and some data model to
      // process it on
      if ( iRequest != null && mDataModels != null )
      {
         RequestToken tok = iRequest.getNextToken();

         // The first request token must be a data model token
         if ( tok.getType() == RequestToken.TOKEN_DATA_MODEL )
         {

            DataModel dm = (DataModel)mDataModels.get(tok.getValue());

            // Make sure the data model exists
            if ( dm != null )
            {
               // Process this request
               result = dm.validate(iRequest);
            }
            else
            {
               // Specified data model element does not exist
               result = DMErrorCodes.UNDEFINED_ELEMENT;
            }
         }
         else
         {
            // No data model specified
            result = DMErrorCodes.INVALID_REQUEST;
         }
      }
      else
      {
         // Nothing to process or nothing to process on
         result = DMErrorCodes.UNKNOWN_EXCEPTION;
      }

      return result;
   }

}  // SCODataManager
