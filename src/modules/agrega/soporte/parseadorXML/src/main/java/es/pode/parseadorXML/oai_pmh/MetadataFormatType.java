/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_pmh;

/**
 * Class MetadataFormatType.
 * 
 * @version $Revision$ $Date$
 */
public class MetadataFormatType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metadataPrefix.
     */
    private java.lang.String _metadataPrefix;

    /**
     * Field _schema.
     */
    private java.lang.String _schema;

    /**
     * Field _metadataNamespace.
     */
    private java.lang.String _metadataNamespace;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetadataFormatType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'metadataNamespace'.
     * 
     * @return the value of field 'MetadataNamespace'.
     */
    public java.lang.String getMetadataNamespace(
    ) {
        return this._metadataNamespace;
    }

    /**
     * Returns the value of field 'metadataPrefix'.
     * 
     * @return the value of field 'MetadataPrefix'.
     */
    public java.lang.String getMetadataPrefix(
    ) {
        return this._metadataPrefix;
    }

    /**
     * Returns the value of field 'schema'.
     * 
     * @return the value of field 'Schema'.
     */
    public java.lang.String getSchema(
    ) {
        return this._schema;
    }

    /**
     * Sets the value of field 'metadataNamespace'.
     * 
     * @param metadataNamespace the value of field
     * 'metadataNamespace'.
     */
    public void setMetadataNamespace(
            final java.lang.String metadataNamespace) {
        this._metadataNamespace = metadataNamespace;
    }

    /**
     * Sets the value of field 'metadataPrefix'.
     * 
     * @param metadataPrefix the value of field 'metadataPrefix'.
     */
    public void setMetadataPrefix(
            final java.lang.String metadataPrefix) {
        this._metadataPrefix = metadataPrefix;
    }

    /**
     * Sets the value of field 'schema'.
     * 
     * @param schema the value of field 'schema'.
     */
    public void setSchema(
            final java.lang.String schema) {
        this._schema = schema;
    }

}
