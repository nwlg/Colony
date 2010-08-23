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
 * Class AdditionType.
 * 
 * @version $Revision$ $Date$
 */
public class AdditionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lomTerm.
     */
    private java.lang.String _lomTerm;

    /**
     * Field _newValue.
     */
    private java.lang.String _newValue;

    /**
     * Field _termType.
     */
    private es.pode.modificador.negocio.cambios.configuracion.castor.types.TermType _termType = es.pode.modificador.negocio.cambios.configuracion.castor.types.TermType.valueOf("otro");

    /**
     * Field _mainLomOnly.
     */
    private boolean _mainLomOnly;

    /**
     * keeps track of state for field: _mainLomOnly
     */
    private boolean _has_mainLomOnly;


      //----------------/
     //- Constructors -/
    //----------------/

    public AdditionType() {
        super();
        setTermType(es.pode.modificador.negocio.cambios.configuracion.castor.types.TermType.valueOf("otro"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMainLomOnly(
    ) {
        this._has_mainLomOnly= false;
    }

    /**
     * Returns the value of field 'lomTerm'.
     * 
     * @return the value of field 'LomTerm'.
     */
    public java.lang.String getLomTerm(
    ) {
        return this._lomTerm;
    }

    /**
     * Returns the value of field 'mainLomOnly'.
     * 
     * @return the value of field 'MainLomOnly'.
     */
    public boolean getMainLomOnly(
    ) {
        return this._mainLomOnly;
    }

    /**
     * Returns the value of field 'newValue'.
     * 
     * @return the value of field 'NewValue'.
     */
    public java.lang.String getNewValue(
    ) {
        return this._newValue;
    }

    /**
     * Returns the value of field 'termType'.
     * 
     * @return the value of field 'TermType'.
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.types.TermType getTermType(
    ) {
        return this._termType;
    }

    /**
     * Method hasMainLomOnly.
     * 
     * @return true if at least one MainLomOnly has been added
     */
    public boolean hasMainLomOnly(
    ) {
        return this._has_mainLomOnly;
    }

    /**
     * Returns the value of field 'mainLomOnly'.
     * 
     * @return the value of field 'MainLomOnly'.
     */
    public boolean isMainLomOnly(
    ) {
        return this._mainLomOnly;
    }

    /**
     * Sets the value of field 'lomTerm'.
     * 
     * @param lomTerm the value of field 'lomTerm'.
     */
    public void setLomTerm(
            final java.lang.String lomTerm) {
        this._lomTerm = lomTerm;
    }

    /**
     * Sets the value of field 'mainLomOnly'.
     * 
     * @param mainLomOnly the value of field 'mainLomOnly'.
     */
    public void setMainLomOnly(
            final boolean mainLomOnly) {
        this._mainLomOnly = mainLomOnly;
        this._has_mainLomOnly = true;
    }

    /**
     * Sets the value of field 'newValue'.
     * 
     * @param newValue the value of field 'newValue'.
     */
    public void setNewValue(
            final java.lang.String newValue) {
        this._newValue = newValue;
    }

    /**
     * Sets the value of field 'termType'.
     * 
     * @param termType the value of field 'termType'.
     */
    public void setTermType(
            final es.pode.modificador.negocio.cambios.configuracion.castor.types.TermType termType) {
        this._termType = termType;
    }

}
