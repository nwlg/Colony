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

import java.io.Serializable;


/**
 * Encapsulation of information required for processing a data model request.
 * <br><br>
 * 
 * <strong>Filename:</strong> DMDelimiterDescriptor.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * Encapsulation of all information required to describe one dot-notation bound
 * delimiter.  This information will be used to create instances of delimiters
 * assocaited with data model elements.<br><br>
 * 
 * <strong>Design Issues:</strong><br><br>
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
 *     <li>SCORM 2004
 * </ul>
 * 
 * @author ADL Technical Team
 */ 
public class DMDelimiterDescriptor implements Serializable 
{

   /**
    * Describes the name of this delimiter
    */
   public String mName = null;


   /**
    * Describes if the default value of this delimiter
    */
   public String mDefault = null;


   /**
    * Describes the SPM for the value.
    */
   public int mValueSPM = -1;


   /**
    * Describes the method used to validate the value of this delimiter.
    */
   public DMTypeValidator mValidator = null;

   /**
    * Provides a way to store delimiter information such as name, default value,
    * and type of validator.
    * 
    * @param iName  The name of the delimiter
    * @param iDefault  The default value for the delimiter
    * @param iValidator  The validator associated with the delimiter
    */
   public DMDelimiterDescriptor(String iName, 
                                String iDefault,
                                DMTypeValidator iValidator)
   {
      mName = iName;
      mDefault = iDefault;
      mValidator = iValidator;
   }

   /**
    * Provides a way to store delimiter information such as name, default value,
    * and type of validator.
    * 
    * @param iName The name of the delimiter
    * 
    * @param iDefault The default value for the delimiter
    * 
    * @param iValueSPM The smallest permitted maximum size allowed for this
    *                      delimiter
    * 
    * @param iValidator The validator associated with the delimiter
    */
   public DMDelimiterDescriptor(String iName, 
                                String iDefault,
                                int iValueSPM,
                                DMTypeValidator iValidator)
   {
      mName = iName;
      mDefault = iDefault;
      mValueSPM = iValueSPM;
      mValidator = iValidator;
   }


}  // end DMDelimiterDescriptor
