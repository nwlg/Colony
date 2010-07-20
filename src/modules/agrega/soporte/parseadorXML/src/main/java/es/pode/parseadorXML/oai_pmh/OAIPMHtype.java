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
 * Class OAIPMHtype.
 * 
 * @version $Revision$ $Date$
 */
public class OAIPMHtype implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _responseDate.
     */
    private java.util.Date _responseDate;

    /**
     * Field _request.
     */
    private es.pode.parseadorXML.oai_pmh.Request _request;

    /**
     * Field _OAIPMHtypeChoice.
     */
    private es.pode.parseadorXML.oai_pmh.OAIPMHtypeChoice _OAIPMHtypeChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public OAIPMHtype() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'OAIPMHtypeChoice'.
     * 
     * @return the value of field 'OAIPMHtypeChoice'.
     */
    public es.pode.parseadorXML.oai_pmh.OAIPMHtypeChoice getOAIPMHtypeChoice(
    ) {
        return this._OAIPMHtypeChoice;
    }

    /**
     * Returns the value of field 'request'.
     * 
     * @return the value of field 'Request'.
     */
    public es.pode.parseadorXML.oai_pmh.Request getRequest(
    ) {
        return this._request;
    }

    /**
     * Returns the value of field 'responseDate'.
     * 
     * @return the value of field 'ResponseDate'.
     */
    public java.util.Date getResponseDate(
    ) {
        return this._responseDate;
    }

    /**
     * Sets the value of field 'OAIPMHtypeChoice'.
     * 
     * @param OAIPMHtypeChoice the value of field 'OAIPMHtypeChoice'
     */
    public void setOAIPMHtypeChoice(
            final es.pode.parseadorXML.oai_pmh.OAIPMHtypeChoice OAIPMHtypeChoice) {
        this._OAIPMHtypeChoice = OAIPMHtypeChoice;
    }

    /**
     * Sets the value of field 'request'.
     * 
     * @param request the value of field 'request'.
     */
    public void setRequest(
            final es.pode.parseadorXML.oai_pmh.Request request) {
        this._request = request;
    }

    /**
     * Sets the value of field 'responseDate'.
     * 
     * @param responseDate the value of field 'responseDate'.
     */
    public void setResponseDate(
            final java.util.Date responseDate) {
        this._responseDate = responseDate;
    }

}
