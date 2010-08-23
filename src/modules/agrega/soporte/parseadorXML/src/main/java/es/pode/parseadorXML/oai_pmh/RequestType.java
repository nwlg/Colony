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
 * Define requestType, indicating the protocol request that 
 *  led to the response. Element content is BASE-URL, attributes
 * are arguments 
 *  of protocol request, attribute-values are values of arguments
 * of protocol 
 *  request
 * 
 * @version $Revision$ $Date$
 */
public class RequestType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content;

    /**
     * Field _verb.
     */
    private es.pode.parseadorXML.oai_pmh.types.VerbType _verb;

    /**
     * Field _identifier.
     */
    private java.lang.String _identifier;

    /**
     * Field _metadataPrefix.
     */
    private java.lang.String _metadataPrefix;

    /**
     * Field _from.
     */
    private java.lang.String _from;

    /**
     * Field _until.
     */
    private java.lang.String _until;

    /**
     * Field _set.
     */
    private java.lang.String _set;

    /**
     * Field _resumptionToken.
     */
    private java.lang.String _resumptionToken;


      //----------------/
     //- Constructors -/
    //----------------/

    public RequestType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'Content'.
     */
    public java.lang.String getContent(
    ) {
        return this._content;
    }

    /**
     * Returns the value of field 'from'.
     * 
     * @return the value of field 'From'.
     */
    public java.lang.String getFrom(
    ) {
        return this._from;
    }

    /**
     * Returns the value of field 'identifier'.
     * 
     * @return the value of field 'Identifier'.
     */
    public java.lang.String getIdentifier(
    ) {
        return this._identifier;
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
     * Returns the value of field 'resumptionToken'.
     * 
     * @return the value of field 'ResumptionToken'.
     */
    public java.lang.String getResumptionToken(
    ) {
        return this._resumptionToken;
    }

    /**
     * Returns the value of field 'set'.
     * 
     * @return the value of field 'Set'.
     */
    public java.lang.String getSet(
    ) {
        return this._set;
    }

    /**
     * Returns the value of field 'until'.
     * 
     * @return the value of field 'Until'.
     */
    public java.lang.String getUntil(
    ) {
        return this._until;
    }

    /**
     * Returns the value of field 'verb'.
     * 
     * @return the value of field 'Verb'.
     */
    public es.pode.parseadorXML.oai_pmh.types.VerbType getVerb(
    ) {
        return this._verb;
    }

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(
            final java.lang.String content) {
        this._content = content;
    }

    /**
     * Sets the value of field 'from'.
     * 
     * @param from the value of field 'from'.
     */
    public void setFrom(
            final java.lang.String from) {
        this._from = from;
    }

    /**
     * Sets the value of field 'identifier'.
     * 
     * @param identifier the value of field 'identifier'.
     */
    public void setIdentifier(
            final java.lang.String identifier) {
        this._identifier = identifier;
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
     * Sets the value of field 'resumptionToken'.
     * 
     * @param resumptionToken the value of field 'resumptionToken'.
     */
    public void setResumptionToken(
            final java.lang.String resumptionToken) {
        this._resumptionToken = resumptionToken;
    }

    /**
     * Sets the value of field 'set'.
     * 
     * @param set the value of field 'set'.
     */
    public void setSet(
            final java.lang.String set) {
        this._set = set;
    }

    /**
     * Sets the value of field 'until'.
     * 
     * @param until the value of field 'until'.
     */
    public void setUntil(
            final java.lang.String until) {
        this._until = until;
    }

    /**
     * Sets the value of field 'verb'.
     * 
     * @param verb the value of field 'verb'.
     */
    public void setVerb(
            final es.pode.parseadorXML.oai_pmh.types.VerbType verb) {
        this._verb = verb;
    }

}
