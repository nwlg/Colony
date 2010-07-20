/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_pmh_id;

/**
 * Class OaiIdentifierType.
 * 
 * @version $Revision$ $Date$
 */
public class OaiIdentifierType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _scheme.
     */
    private java.lang.String _scheme = "oai";

    /**
     * Field _repositoryIdentifier.
     */
    private java.lang.String _repositoryIdentifier;

    /**
     * Field _delimiter.
     */
    private java.lang.String _delimiter = ":";

    /**
     * Field _sampleIdentifier.
     */
    private java.lang.String _sampleIdentifier;


      //----------------/
     //- Constructors -/
    //----------------/

    public OaiIdentifierType() {
        super();
        setScheme("oai");
        setDelimiter(":");
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'delimiter'.
     * 
     * @return the value of field 'Delimiter'.
     */
    public java.lang.String getDelimiter(
    ) {
        return this._delimiter;
    }

    /**
     * Returns the value of field 'repositoryIdentifier'.
     * 
     * @return the value of field 'RepositoryIdentifier'.
     */
    public java.lang.String getRepositoryIdentifier(
    ) {
        return this._repositoryIdentifier;
    }

    /**
     * Returns the value of field 'sampleIdentifier'.
     * 
     * @return the value of field 'SampleIdentifier'.
     */
    public java.lang.String getSampleIdentifier(
    ) {
        return this._sampleIdentifier;
    }

    /**
     * Returns the value of field 'scheme'.
     * 
     * @return the value of field 'Scheme'.
     */
    public java.lang.String getScheme(
    ) {
        return this._scheme;
    }

    /**
     * Sets the value of field 'delimiter'.
     * 
     * @param delimiter the value of field 'delimiter'.
     */
    public void setDelimiter(
            final java.lang.String delimiter) {
        this._delimiter = delimiter;
    }

    /**
     * Sets the value of field 'repositoryIdentifier'.
     * 
     * @param repositoryIdentifier the value of field
     * 'repositoryIdentifier'.
     */
    public void setRepositoryIdentifier(
            final java.lang.String repositoryIdentifier) {
        this._repositoryIdentifier = repositoryIdentifier;
    }

    /**
     * Sets the value of field 'sampleIdentifier'.
     * 
     * @param sampleIdentifier the value of field 'sampleIdentifier'
     */
    public void setSampleIdentifier(
            final java.lang.String sampleIdentifier) {
        this._sampleIdentifier = sampleIdentifier;
    }

    /**
     * Sets the value of field 'scheme'.
     * 
     * @param scheme the value of field 'scheme'.
     */
    public void setScheme(
            final java.lang.String scheme) {
        this._scheme = scheme;
    }

}
