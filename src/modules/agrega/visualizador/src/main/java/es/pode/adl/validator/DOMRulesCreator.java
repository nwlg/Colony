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
******************************************************************************/
package es.pode.adl.validator;

import java.util.logging.Logger;

import org.w3c.dom.Document;

import es.pode.adl.parsers.ADLDOMParser;

/**
 *
 * <strong>Filename: </strong>DOMRulesCreator.java<br><br>
 *
 * <strong>Description: </strong>The <code>DOMRulesCreator</code> will create
 * a DOM of the XML rules that are neccessary for each Application Profile
 * (ie.,  Content Package Validator - resource and content aggregation /
 * Metadata Validator - adlreg ) /
 * Sequence Validator - sequence<br><br>
 *
 * <strong>Design Issues: </strong>none<br><br>
 *
 * <strong>Implementation Issues: </strong>none<br><br>
 *
 * <strong>Known Problems: </strong>none<br><br>
 *
 * <strong>Side Effects: </strong>none<br><br>
 *
 * <strong>References: </strong>SCORM <br><br>
 *
 * @author ADL Technical Team
 */
public class DOMRulesCreator
{
   /**
    * The application profile type to read the rules for the following:
    * <ul>
    *    <li><strong>Metadata</strong>
    *       <ul>
    *          <li>adlreg</li>
    *       </ul>
    *    </li>
    *    <li><strong>Content Package</strong>
    *       <ul>
    *          <li>resource</li>
    *          <li>content aggregation</li>
    *       </ul>
    *    </li>
    *    <li><strong>Sequence</strong>
    *       <ul>
    *          <li>sequence</li>
    *       </ul>
    *    </li>
    * </ul>
    */
   private String mApplicationProfileType;

   /**
    * The validator type that this class is providing for the following:
    * <ul>
    *    <li>metadata</li>
    *    <li>contentpackage</li>
    *    <li>sequence</li>
    * </ul>
    */
   private String mValidatorType;

   /**
    * Logger object used for debug logging.
    */
   private Logger mLogger;

   /**
    *
    * Constructor that sets the application profile and validator attributes
    * values.
    *
    * @param iApplicationProfileType Application Profile Rules to be retrieved.
    * 
    * @param iValidatorType Type of validator being used.  Valid values
    * include: contentpackage, metadata, sequence  
    */
   public DOMRulesCreator( String iApplicationProfileType,
                           String iValidatorType )
   {
      mLogger = Logger.getLogger("org.adl.util.debug.validator");

      mLogger.entering( "DOMRulesCreator", "DOMRulesCreator()" );
      mLogger.info("      iApplicationProfileType coming in is " +
                           iApplicationProfileType );
      mLogger.info("      iValidatorType coming in is " +
                           iValidatorType );

      mApplicationProfileType = iApplicationProfileType;
      mValidatorType = iValidatorType;

      mLogger.exiting( "DOMRulesCreator", "DOMRulesCreator()" );
   }

   /**
    *
    * Performs the reading in and parsing of the xml rules.
    *
    * @return Document DOM of the parsed xml rules
    */
   public Document provideRules()
   {
      mLogger.entering( "DOMRulesCreator", "provideRules()" );

      // create an ADLDOMParser object to parse the rules and provide a dom
      ADLDOMParser mParser = new ADLDOMParser();
      java.net.URL urlLocation = null;
      Document doc = null;

      // now we must determine which XML rules document it's location

      if( mValidatorType.equals("metadata") &&
         mApplicationProfileType.equals("adlreg") )
      {
         urlLocation = 
            DOMRulesCreator.class.
            getResource("metadata/rules/md_adlregRules.xml");
      
          mLogger.info( "adlreg fileLocation is" + urlLocation );
      }      
      else if ( mValidatorType.equals("contentpackage") &&
                mApplicationProfileType.equals("resource") )
      {
         urlLocation = 
            DOMRulesCreator.class.
               getResource("contentpackage/rules/cp_resourceRules.xml");

         mLogger.info( "resource fileLocation is" + urlLocation );
      }
      else if ( mValidatorType.equals("contentpackage") &&
                mApplicationProfileType.equals("contentaggregation") )
      {
         urlLocation = 
            DOMRulesCreator.class.
             getResource("contentpackage/rules/cp_contentaggregationRules.xml");

         mLogger.info( "contentaggregation fileLocation is" + urlLocation );
      }
      else if ( mValidatorType.equals("sequence") &&
                mApplicationProfileType.equals("sequence") )
      {
         urlLocation = 
            DOMRulesCreator.class.
               getResource("sequence/rules/sequenceRules.xml");

         mLogger.info( "sequence fileLocation is" + urlLocation );
      }
      else
      {
         mLogger.severe( "Error, ApplicationProfile and/or ValidatorType DNE" );
      }

      if ( urlLocation != null )
      {
         // parse XML rules document to provide a dom
         mParser.parseForWellformedness( urlLocation, false, false );

         if( mParser.getIsWellformed() )
         {
            doc = mParser.getDocument();
         }
      }
      mLogger.exiting( "DOMRulesCreator", "provideRules()" );

      return doc;
    }
}
