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

package es.pode.adl.server;

import java.io.Serializable;

/**
 * Encapsulation of information required for importing a course.<br><br>
 * 
 * <strong>Filename:</strong> ValidationResults.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * The <code>ValidationResults</code> encapsulates the information about 
 * the validation of the course submitted to be imported to the Sample RTE.
 * <br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the SCORM Sample RTE.<br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br>
 * This was intentionally written as a simple bean to allow servlet - jsp 
 * communication.<br><br>
 * 
 * <strong>Known Problems:</strong><br><br>
 * 
 * <strong>Side Effects:</strong><br><br>
 * 
 * <strong>References:</strong><br>
 * <ul>
 *     <li>IMS SS 1.0
 *     <li>SCORM 2004 3rd Edition
 * </ul>
 * 
 * @author ADL Technical Team
 */ 
public class ValidationResults implements Serializable
{
   /**
    * String representing validation
    */
   private String mValidation = "";

   /**
    * String saying whether the manifest exists
    */
   private String mManifestExists = "";

   /**
    * String saying whether the manifest was well formed
    */
   private String mWellFormed = "";

   /**
    * String saying whether the root was valid
    */
   private String mValidRoot = "";

   /**
    * String saying whether the manifest is valid to the 
    * schema
    */
   private String mValidToSchema = "";

   /**
    * String saying whether the manifest is valid
    * against the profile
    */
   private String mValidToProfile = "";

   /**
    * String saying whether the required files
    * were found
    */
   private String mRequiredFiles = "";

   /**
    * String value of true or false for whether the RedirectView test 
    * passed
    */
   private String mRedirectView = "";

   /**
    * Default constructor for ValidationResults class.<br><br>
    */
   public ValidationResults()
   {
      //nothing to add here
   }

   /**
    * Sets a string value of true or false for whether the Validation test 
    * is requested.
    * 
    * @param iValidation  true or false string representing whether the 
    *                     Validation test was successful
    */
   public void setValidation (String iValidation)
   {
      mValidation = iValidation;
   }

   /**
    * Returns a value of true or false for whether the Validation test 
    * passed.
    * 
    * @return  true or false string representing whether the Validation test 
    *          was successful
    */
   public String getValidation ()
   {
      return mValidation;
   }

   /**
    * Sets a string value of true or false for whether the ManifestExists test 
    * passed.
    * 
    * @param iManifestExists  true or false string representing whether the 
    *                     ManifestExists test was successful
    */
   public void setManifestExists (String iManifestExists)
   {
      mManifestExists = iManifestExists;
   }

   /**
    * Returns a value of true or false for whether the ManifestExists test 
    * passed.
    * 
    * @return  true or false string representing whether the ManifestExists
    *          test was successful
    */
   public String getManifestExists ()
   {
      return mManifestExists;
   }

   /**
    * Sets a string value of true or false for whether the WellFormed test 
    * passed.
    * 
    * @param iWellFormed  true or false string representing whether the 
    *                     WellFormed test was successful
    */
   public void setWellFormed (String iWellFormed)
   {
      mWellFormed = iWellFormed;
   }

   /**
    * Returns a value of true or false for whether the WellFormed test 
    * passed.
    * 
    * @return  true or false string representing whether the WellFormed test 
    * was successful
    */
   public String getWellFormed ()
   {
      return mWellFormed;
   }

   /**
    * Sets a string value of true or false for whether the ValidRoot test 
    * passed.
    * 
    * @param iValidRoot  true or false string representing whether the 
    *                     ValidRoot test was successful
    */
   public void setValidRoot (String iValidRoot)
   {
      mValidRoot = iValidRoot;
   }

   /**
    * Returns a value of true or false for whether the ValidRoot test 
    * passed.
    * 
    * @return  true or false string representing whether the ValidRoot test was 
    * successful
    */
   public String getValidRoot ()
   {
      return mValidRoot;
   }

   /**
    * Sets a string value of true or false for whether the ValidToSchema test 
    * passed.
    * 
    * @param iValidToSchema  true or false string representing whether the 
    *                     ValidToSchema test was successful
    */
   public void setValidToSchema (String iValidToSchema)
   {
      mValidToSchema = iValidToSchema;
   }

   /**
    * Returns a value of true or false for whether the ValidToSchema test 
    * passed.
    * 
    * @return  true or false string representing whether the ValidToSchema test 
    * was successful
    */
   public String getValidToSchema ()
   {
      return mValidToSchema;
   }

   /**
    * Sets a string value of true or false for whether the ValidToProfile test 
    * passed.
    * 
    * @param iValidToProfile  true or false string representing whether the 
    *                     ValidToProfile test was successful
    */
   public void setValidToProfile (String iValidToProfile)
   {
      mValidToProfile = iValidToProfile;
   }

   /**
    * Returns a value of true or false for whether the ValidToProfile test 
    * passed.
    * 
    * @return  true or false string representing whether the ValidToProfile test
    * was successful
    */
   public String getValidToProfile ()
   {
      return mValidToProfile;
   }

   /**
    * Sets a string value of true or false for whether the RequiredFiles test 
    * passed.
    * 
    * @param iRequiredFiles  true or false string representing whether the 
    *                     RequiredFiles test was successful
    */
   public void setRequiredFiles (String iRequiredFiles)
   {
      mRequiredFiles = iRequiredFiles;
   }

   /**
    * Returns a value of true or false for whether the RequiredFiles test 
    * passed.
    * 
    * @return  true or false string representing whether the RequiredFiles test 
    * was successful
    */
   public String getRequiredFiles ()
   {
      return mRequiredFiles;
   }

   /**
    * Sets a string value of true or false for whether the RedirectView test 
    * passed.
    * 
    * @param iRedirectView  true or false string representing whether the 
    *                     RequiredFiles test was successful
    */
   public void setRedirectView (String iRedirectView)
   {
      mRedirectView = iRedirectView;
   }

   /**
    * Returns a value of true or false for whether the RedirectView test 
    * passed.
    * 
    * @return  true or false string representing whether the RedirectView test 
    * was successful
    */
   public String getRedirectView ()
   {
      return mRedirectView;
   }

}
