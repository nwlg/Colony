/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.modificador.negocio.cambios.configuracion.castor;

/**
 * Class OdeType.
 * 
 * @version $Revision$ $Date$
 */
public class OdeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _published.
     */
    private boolean _published;

    /**
     * keeps track of state for field: _published
     */
    private boolean _has_published;

    /**
     * Field _path.
     */
    private java.lang.String _path;


      //----------------/
     //- Constructors -/
    //----------------/

    public OdeType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deletePublished(
    ) {
        this._has_published= false;
    }

    /**
     * Returns the value of field 'path'.
     * 
     * @return the value of field 'Path'.
     */
    public java.lang.String getPath(
    ) {
        return this._path;
    }

    /**
     * Returns the value of field 'published'.
     * 
     * @return the value of field 'Published'.
     */
    public boolean getPublished(
    ) {
        return this._published;
    }

    /**
     * Method hasPublished.
     * 
     * @return true if at least one Published has been added
     */
    public boolean hasPublished(
    ) {
        return this._has_published;
    }

    /**
     * Returns the value of field 'published'.
     * 
     * @return the value of field 'Published'.
     */
    public boolean isPublished(
    ) {
        return this._published;
    }

    /**
     * Sets the value of field 'path'.
     * 
     * @param path the value of field 'path'.
     */
    public void setPath(
            final java.lang.String path) {
        this._path = path;
    }

    /**
     * Sets the value of field 'published'.
     * 
     * @param published the value of field 'published'.
     */
    public void setPublished(
            final boolean published) {
        this._published = published;
        this._has_published = true;
    }

}
