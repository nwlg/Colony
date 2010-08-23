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

/**
 * <strong>Filename:</strong> InteractionTrunc.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * Provides support for the SCORM Data Model Interaction data types, as defined 
 * in the SCORM 2004.
 * 
 * @author ADL Technical Team
 */
public class InteractionTrunc
{
   /**
    * Truncates all parts of an interaction datatype to their SPMs
    * 
    * @param iValue The value being truncated
    * @param iType  The type of the value being truncated
    * 
    * @return Returns the Truncated value
    */
   public static String trunc(String iValue, int iType)
   {
      String trunc = new String("");

      // SCORM defined separators
      String comma  = new String("\\[,\\]");
      
      // Ensure value contains seperators before processing
      if ( iValue.equals("") || iValue.indexOf(comma) == -1 )
      {
         return iValue;
      }

      int idx = -1;

      // Switch on the interaction type
      switch ( iType )
      {
         case InteractionValidator.MULTIPLE_CHOICE :
         {
            // Check for an empty set
            if ( iValue.trim().length() == 0 )
            {
               // Value OK
               break;
            }

            String choices[] = iValue.split(comma);
            trunc = "";

            // Check to determine if each choice is within the SPM range  
            for ( int i = 0; i < 36; i++ )
            {
               if ( choices[i].length() > 250 )
               {
                  trunc = trunc + choices[i].substring(0, 250);
               }
               else
               {
                  trunc = trunc + choices[i];
               }

               if ( i != 35 )
               {
                  trunc = trunc + "[,]";
               }
            }

            break;
         }
         case InteractionValidator.FILL_IN :
         { 
            // Extract each part of the match_text
            String matchText[] = iValue.split(comma);
            trunc = "";

            for ( int i = 0; i < 10; i++ )
            {
               String matchString = null;
               String langString = null;

               // Look for the 'lang' delimiter
               if ( matchText[i].startsWith("{lang=") )
               {
                  // Find the closing '}'
                  idx = matchText[i].indexOf('}');
                  if ( idx != -1 )
                  {
                     matchString = matchText[i].substring(idx + 1);
                     langString = matchText[i].substring(6, idx);
                  }
                  else
                  {
                     matchString = matchText[i];
                  }
               }
               else
               {
                  matchString = matchText[i];
               }

               if ( langString.length() > 250)
               {
                  trunc = trunc + "{lang=" + 
                     langString.substring(0, 250) + "}";
               }
               else
               {
                  trunc = trunc + "{lang=" + 
                     langString + "}"; 
               }


               if ( matchString.length() > 250 )
               {               
                  trunc = trunc + matchString.substring(0, 250);
               }
               else
               {
                  trunc = trunc + matchString;
               }

               if ( i != 9 )
               {
                  trunc = trunc + "[,]";
               }
            }

            break;
         }
         case InteractionValidator.LONG_FILL_IN :
         {
            if ( iValue.length() > 4000 )
            {
               trunc = iValue.substring(0, 4000);
            }
            else
            {
               trunc = iValue;
            }

            break;
         }
         case InteractionValidator.LIKERT :
         {
            if ( iValue.length() > 250 )
            {
               trunc = iValue.substring(0, 250);
            }

            break;
         }
         case InteractionValidator.MATCHING :
         {
            if ( iValue.trim().length() == 0 )
            {
               // Value OK
               break;
            }

            String commas[] = iValue.split(comma);
            trunc = "";

            for ( int i = 0; i < 36; i++ )
            {
               idx = commas[i].indexOf("[.]");

               String target = commas[i].substring(0, idx);
               String source = commas[i].substring(idx + 3, 
                                                   commas[i].length());

               if ( target.length() > 250 )
               {
                  trunc = trunc + target.substring(0, 250);
               }
               else
               {
                  trunc = trunc + target;
               }

               trunc = trunc + "[.]";

               if ( source.length() > 250 )
               {
                  trunc = trunc + source.substring(0, 250);  
               }
               else
               {
                  trunc = trunc + source;
               }
                 
               if ( i != 35 )
               {
                  trunc = trunc + "[,]";
               }
            } 

            break;
         }
         case InteractionValidator.PERFORMANCE : 
         {
            String commaCheck[] = iValue.split(comma);  
            trunc = "";

            for ( int i = 0; i < 125; i++ )
            {
               idx = commaCheck[i].indexOf("[.]");

               String sn = commaCheck[i].substring(0, idx);
               String sa = commaCheck[i].substring(idx + 3, 
                              commaCheck[i].length());


               if ( sn.length() > 250 )
               {
                  trunc = trunc + sn.substring(0, 250);
               }
               else
               {
                  trunc = trunc + sn;
               }

               trunc = trunc + "[.]";

               if ( sa.length() > 250 )
               {
                  trunc = trunc + sa.substring(0, 250);  
               }
               else
               {
                  trunc = trunc + sa;
               } 

               if ( i != 124 )
               {
                  trunc = trunc + "[,]";
               }
            } 

            break;
         }
         case InteractionValidator.SEQUENCING :
         {
            String array[] = iValue.split(comma);
            trunc = "";
        
            for ( int i = 0; i < 36; i++ )
            {
 
               if ( array[i].length() > 250 )
               {
                  trunc = trunc + array[i].substring(0, 250);
               }
               else
               {
                  trunc = array[i];
               }

               if ( i != 35 )
               {
                  trunc = trunc + "[,]";
               }
            }

            break;
         }
         case InteractionValidator.NUMERIC :  
         {
            trunc = iValue;

            break;
         }
         default :
         {
            break;
         }
      }

      return trunc;
   }

} // end InteractionTrunc
