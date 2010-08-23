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
 * Class RemovalType.
 * 
 * @version $Revision$ $Date$
 */
public class RemovalType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lomTerm.
     */
    private java.lang.String _lomTerm;

    /**
     * Field _value.
     */
    private java.lang.String _value;

    /**
     * Field _language.
     */
    private java.lang.String _language;

    /**
     * Field _regExp.
     */
    private boolean _regExp;

    /**
     * keeps track of state for field: _regExp
     */
    private boolean _has_regExp;

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

    public RemovalType() {
        super();
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
     */
    public void deleteRegExp(
    ) {
        this._has_regExp= false;
    }

    /**
     * Returns the value of field 'language'.
     * 
     * @return the value of field 'Language'.
     */
    public java.lang.String getLanguage(
    ) {
        return this._language;
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
     * Returns the value of field 'regExp'.
     * 
     * @return the value of field 'RegExp'.
     */
    public boolean getRegExp(
    ) {
        return this._regExp;
    }

    /**
     * Returns the value of field 'value'.
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue(
    ) {
        return this._value;
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
     * Method hasRegExp.
     * 
     * @return true if at least one RegExp has been added
     */
    public boolean hasRegExp(
    ) {
        return this._has_regExp;
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
     * Returns the value of field 'regExp'.
     * 
     * @return the value of field 'RegExp'.
     */
    public boolean isRegExp(
    ) {
        return this._regExp;
    }

    /**
     * Sets the value of field 'language'.
     * 
     * @param language the value of field 'language'.
     */
    public void setLanguage(
            final java.lang.String language) {
        this._language = language;
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
     * Sets the value of field 'regExp'.
     * 
     * @param regExp the value of field 'regExp'.
     */
    public void setRegExp(
            final boolean regExp) {
        this._regExp = regExp;
        this._has_regExp = true;
    }

    /**
     * Sets the value of field 'value'.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(
            final java.lang.String value) {
        this._value = value;
    }

}
