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
package es.pode.adl.datamodels.datatypes;

import java.io.Serializable;

import es.pode.adl.datamodels.DMErrorCodes;
import es.pode.adl.datamodels.DMTypeValidator;

/**
 * Provides support for Valid Vocabulary tokens and if the input is valid based
 * on a Vocablist, as defined in the SCORM 2004 RTE Book<br><br>
 * 
 * <strong>Filename:</strong> ResultValidator.java<br><br>
 * 
 * <strong>Description:</strong><br><br>
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
public class ResultValidator extends DMTypeValidator implements Serializable
{

   /**
    * Describes the set of valid vocabulary tokens
    */
   private String [] mVocabList = null;


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Constructors
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Default constructor required for serialization.
    */
   public ResultValidator() 
   {
     // The default constructor does not define any explicit functionality   
   }


   /**
    * Constructor required for vocabulary initialization.
    * @param iVocab An array of vocabulary string values to used for 
    * initialization
    */
   public ResultValidator(String [] iVocab) 
   { 
      mVocabList = iVocab;
   } 


   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
   
    Public Methods
   
   -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

   /**
    * Compares two valid data model elements for equality.
    * 
    * @param iFirst The first value being compared.
    * @param iSecond The second value being compared.
    * 
    * @return Returns <code>true</code> if the two values are equal, otherwise
    *         <code>false</code>.
    */
   public boolean compare(String iFirst, String iSecond)
   {
      boolean equal = true;
      boolean done = false;

      double val1 = Double.NaN;
      double val2 = Double.NaN;

      try
      {
         // Try to make both values into reals
         val1 = Double.parseDouble(iFirst);
         val2 = Double.parseDouble(iSecond);
      }
      catch ( NumberFormatException nfe )
      {
         // At least one of these must be a strings... Compare
         equal = iFirst.equals(iSecond);
         done = true;
      }

      if ( !done )
      {
         // Only allow 7 signifigant digits -- truncate after that...
         val1 = Math.floor(val1 * 1000000.0) / 1000000.0;
         val2 = Math.floor(val2 * 1000000.0) / 1000000.0;

         equal = Double.compare(val1, val2) == 0;
      }

      return equal;
   }

   /**
    * Validates the provided string against a known format.
    * 
    * @param iValue The value being validated.
    * 
    * @return An abstract data model error code indicating the result of this
    *         operation.
    */
   public int validate(String iValue)
   {
      // Assume the value is not valid
      int valid = DMErrorCodes.TYPE_MISMATCH;

      boolean done = false;

      // Check to see if constructor is null
      if ( mVocabList == null || iValue == null )
      {
         valid = DMErrorCodes.UNKNOWN_EXCEPTION;
         done = true;        
      }

      // See if this value is in the provided vocabulary
      if ( !done )
      {
         for ( int i = 0; i < mVocabList.length; i++ )
         {
            String tmpVocab = mVocabList[i];

            // Check to see if this element equals the input value
            if ( tmpVocab.equals(iValue) )
            {
               valid = DMErrorCodes.NO_ERROR;
               done = true;

               // done
               break;
            }
         }

         // There is no matching vocabulary item, see if the value is a real
         if ( !done )
         {
            try
            {
               // TODO:  The value variable is never read - only used to hold a return.  Should we remove the declaration?
               double value = Double.parseDouble(iValue);

               // The value is a valid real number
               valid = DMErrorCodes.NO_ERROR;
            }
            catch ( NumberFormatException nfe )
            {
               // The value is invalid
               valid = DMErrorCodes.TYPE_MISMATCH;
            }
         }
      }

      return valid;
   }

} // end ResultValidator

