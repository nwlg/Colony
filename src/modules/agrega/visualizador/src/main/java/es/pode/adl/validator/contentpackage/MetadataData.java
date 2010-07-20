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
package es.pode.adl.validator.contentpackage;

import org.w3c.dom.Node;

/**
 *
 * <strong>Filename: </strong><br>MetadataData.java<br><br>
 *
 * <strong>Description: </strong><br>A <CODE>MetadataData</CODE> is a Data
 * Structure used to store information for the validation of Metadata found
 * in the Manifest.  This data structure tracks inline metadata (extensions to
 * the imsmanifest) as well as the location of the external metadata instances.
 * The metadata application profile type of each metadata tracked is stored in
 * this data structure as well.
 * 
 * @author ADL Technical Team
 */
public class MetadataData
{
   /**
    * This attribute stores the Application Profile of the metadata found within
    * the <code>&lt;metadata&gt;</code> tag of the Content Package.  Valid 
    * values include:
    * <ul>
    *    <li><code>adlreg</code></li>
    * </ul>
    */
   private String mApplicationProfileType = "";

   /**
    * This attribute stores the inline metadata, specifically in the form of its
    * root node.
    */
   private Node mRootLOMNode;

   /**
    * This attribute serves as the file location of the external metadata test
    * subject.  The attribute value "inline" denotes that an inline metadata
    * lom element exists.  Otherwise, the uri location of the stand alone test
    * subject is stored here.
    */
   private String mLocation = "";

   /**
    * This attribute stores the identifier value of the major elements
    * (item, orgs, etc/) that house the metadata instance.
    */
   private String mIdentifier;

   /**
    * The default constructor. Sets the attributes to their initial values.
    */
   public MetadataData()
   {
      // no functionality
   }

   /**
    * This method returns the application profile type of the metadata instance.
    * Valid values include:
    * <ul>
    *    <li><code>adlreg</code></li>

    * </ul>
    * 
    * @return the Application Profile Type
    */
   public String getApplicationProfileType()
   {
      return mApplicationProfileType;
   }

   /**
    * This method returns the uri location value of the external metadata
    * instance. If the metadata instance is in the form of inline metadata,
    * then the value returned will be "inline".
    *
    * @return String location value of the metadata test subject.
    */
   public String getLocation()
   {
      return mLocation;
   }

   /**
    * This method retruns the root node of the inline metadata if it exists
    * in the form of extensions to the imsmanifest file.
    *
    * @return Node root lom node of the inline metadata.
    */
   public Node getRootLOMNode()
   {
      return mRootLOMNode;
   }

   /**
    * This method returns the identifier attribute which stores the identifier
    * value of the major elements (item, orgs, etc/) that house the metadata
    * instance.
    *
    * @return String The identifier value of the parent of the metadata.
    */
   public String getIdentifier()
   {
      return mIdentifier;
   }

   /**
    * This method returns a boolean value based on the form of metadata.  If the
    * metadata is in the form of inline metadata, than the boolean value
    * <code>true</code> is returned.  If the metadata is in the form of 
    * external standalone metadata, than the boolean value of 
    * <code>false</code> is returned.
    *
    * @return boolean 
    * <ul>
    *    <li><code>true</code>:  if the metadata is inline</li>
    *    <li><code>false</code>: otherwises</li>
    * </ul>
    */
   public boolean isInlineMetadata()
   {
      boolean result = true;
      if ( getRootLOMNode() == null )
      {
         result = false;
      }
      return result;
   }

   /**
    * This method sets the application profile type of the metadata.
    * Valid set values include:
    * <ul>
    *    <li><code>adlreg</code></li>
    * </ul>
    * 
    * @param iApplicationProfileType the application profile value to be set.
    */
   public void setApplicationProfileType( String iApplicationProfileType )
   {
      mApplicationProfileType = iApplicationProfileType;
   }

   /**
    * This method sets the file location of the external metadata test
    * subject if the metadata is external to the package. If the metadata is
    * inline, than the value of "inline" is set.
    *
    * @param iLocation the location value to be set.
    */
   public void setLocation( String iLocation )
   {
      mLocation = iLocation;
   }

   /**
    * This method sets the root document node, if the metadata exists in the
    * form of inline metadata.
    *
    * @param iNode the root lom node to be set.
    */
   public void setRootLOMNode( Node iNode )
   {
      mRootLOMNode = iNode;
   }

   /**
    * This method sets the identifier value of the major elements
    * (item, orgs, etc/) that house the metadata instance.
    *
    * @param iIdentifier the identifier value to be set.
    */
   public void setIdentifier( String iIdentifier )
   {
      mIdentifier = iIdentifier;
   }
}