/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * The type associated with a control-mode element (see the element
 * controlMode)
 * 
 * @version $Revision$ $Date$
 */
public class ControlModeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _choice.
     */
    private boolean _choice = true;

    /**
     * keeps track of state for field: _choice
     */
    private boolean _has_choice;

    /**
     * Field _choiceExit.
     */
    private boolean _choiceExit = true;

    /**
     * keeps track of state for field: _choiceExit
     */
    private boolean _has_choiceExit;

    /**
     * Field _flow.
     */
    private boolean _flow = false;

    /**
     * keeps track of state for field: _flow
     */
    private boolean _has_flow;

    /**
     * Field _forwardOnly.
     */
    private boolean _forwardOnly = false;

    /**
     * keeps track of state for field: _forwardOnly
     */
    private boolean _has_forwardOnly;

    /**
     * Field _useCurrentAttemptObjectiveInfo.
     */
    private boolean _useCurrentAttemptObjectiveInfo = true;

    /**
     * keeps track of state for field:
     * _useCurrentAttemptObjectiveInfo
     */
    private boolean _has_useCurrentAttemptObjectiveInfo;

    /**
     * Field _useCurrentAttemptProgressInfo.
     */
    private boolean _useCurrentAttemptProgressInfo = true;

    /**
     * keeps track of state for field: _useCurrentAttemptProgressInf
     */
    private boolean _has_useCurrentAttemptProgressInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public ControlModeType() {
        super();
    }

	/*
	 * Metodos get y set de los atributos _has_XXXX usados por Dozer para los
	 * mapeos
	 * 
	 * fjespino
	 */
    public boolean getHasChoice() {
    	return _has_choice;
    }
    
    public void setHasChoice(boolean value) {
    	this._has_choice=value;
    }
    
    public boolean getHasChoiceExit() {
    	return _has_choiceExit;
    }
    
    public void setHasChoiceExit(boolean value) {
    	this._has_choiceExit=value;
    }
    
    public boolean getHasFlow() {
    	return _has_flow;
    }
    
    public void setHasFlow(boolean value) {
    	this._has_flow=value;
    }
    
    public boolean getHasForwardOnly() {
    	return _has_forwardOnly;
    }
    
    public void setHasForwardOnly(boolean value) {
    	this._has_forwardOnly=value;
    }
    
    public boolean getHasUseCurrentAttemptObjectiveInfo() {
    	return _has_useCurrentAttemptObjectiveInfo;
    }
    
    public void setHasUseCurrentAttemptObjectiveInfo(boolean value) {
    	this._has_useCurrentAttemptObjectiveInfo=value;
    }
    
    public boolean getHasUseCurrentAttemptProgressInfo() {
    	return _has_useCurrentAttemptProgressInfo;
    }
    
    public void setHasUseCurrentAttemptProgressInfo(boolean value) {
    	this._has_useCurrentAttemptProgressInfo=value;
    }
      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteChoice(
    ) {
        this._has_choice= false;
    }

    /**
     */
    public void deleteChoiceExit(
    ) {
        this._has_choiceExit= false;
    }

    /**
     */
    public void deleteFlow(
    ) {
        this._has_flow= false;
    }

    /**
     */
    public void deleteForwardOnly(
    ) {
        this._has_forwardOnly= false;
    }

    /**
     */
    public void deleteUseCurrentAttemptObjectiveInfo(
    ) {
        this._has_useCurrentAttemptObjectiveInfo= false;
    }

    /**
     */
    public void deleteUseCurrentAttemptProgressInfo(
    ) {
        this._has_useCurrentAttemptProgressInfo= false;
    }

    /**
     * Returns the value of field 'choice'.
     * 
     * @return the value of field 'Choice'.
     */
    public boolean getChoice(
    ) {
        return this._choice;
    }

    /**
     * Returns the value of field 'choiceExit'.
     * 
     * @return the value of field 'ChoiceExit'.
     */
    public boolean getChoiceExit(
    ) {
        return this._choiceExit;
    }

    /**
     * Returns the value of field 'flow'.
     * 
     * @return the value of field 'Flow'.
     */
    public boolean getFlow(
    ) {
        return this._flow;
    }

    /**
     * Returns the value of field 'forwardOnly'.
     * 
     * @return the value of field 'ForwardOnly'.
     */
    public boolean getForwardOnly(
    ) {
        return this._forwardOnly;
    }

    /**
     * Returns the value of field 'useCurrentAttemptObjectiveInfo'.
     * 
     * @return the value of field 'UseCurrentAttemptObjectiveInfo'.
     */
    public boolean getUseCurrentAttemptObjectiveInfo(
    ) {
        return this._useCurrentAttemptObjectiveInfo;
    }

    /**
     * Returns the value of field 'useCurrentAttemptProgressInfo'.
     * 
     * @return the value of field 'UseCurrentAttemptProgressInfo'.
     */
    public boolean getUseCurrentAttemptProgressInfo(
    ) {
        return this._useCurrentAttemptProgressInfo;
    }

    /**
     * Method hasChoice.
     * 
     * @return true if at least one Choice has been added
     */
    public boolean hasChoice(
    ) {
        return this._has_choice;
    }

    /**
     * Method hasChoiceExit.
     * 
     * @return true if at least one ChoiceExit has been added
     */
    public boolean hasChoiceExit(
    ) {
        return this._has_choiceExit;
    }

    /**
     * Method hasFlow.
     * 
     * @return true if at least one Flow has been added
     */
    public boolean hasFlow(
    ) {
        return this._has_flow;
    }

    /**
     * Method hasForwardOnly.
     * 
     * @return true if at least one ForwardOnly has been added
     */
    public boolean hasForwardOnly(
    ) {
        return this._has_forwardOnly;
    }

    /**
     * Method hasUseCurrentAttemptObjectiveInfo.
     * 
     * @return true if at least one UseCurrentAttemptObjectiveInfo
     * has been added
     */
    public boolean hasUseCurrentAttemptObjectiveInfo(
    ) {
        return this._has_useCurrentAttemptObjectiveInfo;
    }

    /**
     * Method hasUseCurrentAttemptProgressInfo.
     * 
     * @return true if at least one UseCurrentAttemptProgressInfo
     * has been added
     */
    public boolean hasUseCurrentAttemptProgressInfo(
    ) {
        return this._has_useCurrentAttemptProgressInfo;
    }

    /**
     * Returns the value of field 'choice'.
     * 
     * @return the value of field 'Choice'.
     */
    public boolean isChoice(
    ) {
        return this._choice;
    }

    /**
     * Returns the value of field 'choiceExit'.
     * 
     * @return the value of field 'ChoiceExit'.
     */
    public boolean isChoiceExit(
    ) {
        return this._choiceExit;
    }

    /**
     * Returns the value of field 'flow'.
     * 
     * @return the value of field 'Flow'.
     */
    public boolean isFlow(
    ) {
        return this._flow;
    }

    /**
     * Returns the value of field 'forwardOnly'.
     * 
     * @return the value of field 'ForwardOnly'.
     */
    public boolean isForwardOnly(
    ) {
        return this._forwardOnly;
    }

    /**
     * Returns the value of field 'useCurrentAttemptObjectiveInfo'.
     * 
     * @return the value of field 'UseCurrentAttemptObjectiveInfo'.
     */
    public boolean isUseCurrentAttemptObjectiveInfo(
    ) {
        return this._useCurrentAttemptObjectiveInfo;
    }

    /**
     * Returns the value of field 'useCurrentAttemptProgressInfo'.
     * 
     * @return the value of field 'UseCurrentAttemptProgressInfo'.
     */
    public boolean isUseCurrentAttemptProgressInfo(
    ) {
        return this._useCurrentAttemptProgressInfo;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'choice'.
     * 
     * @param choice the value of field 'choice'.
     */
    public void setChoice(
            final boolean choice) {
        this._choice = choice;
        this._has_choice = true;
    }

    /**
     * Sets the value of field 'choice' without changing _has_choice (mapping purposes)
     * 
     * @param choice the value of field 'choice'.
     */
    public void setChoiceMapped(
            final boolean choice) {
        this._choice = choice;
    }
    
    /**
     * Sets the value of field 'choiceExit'.
     * 
     * @param choiceExit the value of field 'choiceExit'.
     */
    public void setChoiceExit(
            final boolean choiceExit) {
        this._choiceExit = choiceExit;
        this._has_choiceExit = true;
    }
    
    /**
     * Sets the value of field 'choiceExit' (no _has).
     * 
     * @param choiceExit the value of field 'choiceExit'.
     */
    public void setChoiceExitMapped(
            final boolean choiceExit) {
        this._choiceExit = choiceExit;
    }

    /**
     * Sets the value of field 'flow'.
     * 
     * @param flow the value of field 'flow'.
     */
    public void setFlow(
            final boolean flow) {
        this._flow = flow;
        this._has_flow = true;
    }
    
    /**
     * Sets the value of field 'flow'. No _has
     * 
     * @param flow the value of field 'flow'.
     */
    public void setFlowMapped(
            final boolean flow) {
        this._flow = flow;
    }

    /**
     * Sets the value of field 'forwardOnly'.
     * 
     * @param forwardOnly the value of field 'forwardOnly'.
     */
    public void setForwardOnly(
            final boolean forwardOnly) {
        this._forwardOnly = forwardOnly;
        this._has_forwardOnly = true;
    }
    
    /**
     * Sets the value of field 'forwardOnly'. No _has
     * 
     * @param forwardOnly the value of field 'forwardOnly'.
     */
    public void setForwardOnlyMapped(
            final boolean forwardOnly) {
        this._forwardOnly = forwardOnly;
    }

    /**
     * Sets the value of field 'useCurrentAttemptObjectiveInfo'.
     * 
     * @param useCurrentAttemptObjectiveInfo the value of field
     * 'useCurrentAttemptObjectiveInfo'.
     */
    public void setUseCurrentAttemptObjectiveInfo(
            final boolean useCurrentAttemptObjectiveInfo) {
        this._useCurrentAttemptObjectiveInfo = useCurrentAttemptObjectiveInfo;
        this._has_useCurrentAttemptObjectiveInfo = true;
    }
    
    /**
     * Sets the value of field 'useCurrentAttemptObjectiveInfo'. No _has
     * 
     * @param useCurrentAttemptObjectiveInfo the value of field
     * 'useCurrentAttemptObjectiveInfo'.
     */
    public void setUseCurrentAttemptObjectiveInfoMapped(
            final boolean useCurrentAttemptObjectiveInfo) {
        this._useCurrentAttemptObjectiveInfo = useCurrentAttemptObjectiveInfo;
    }

    /**
     * Sets the value of field 'useCurrentAttemptProgressInfo'.
     * 
     * @param useCurrentAttemptProgressInfo the value of field
     * 'useCurrentAttemptProgressInfo'.
     */
    public void setUseCurrentAttemptProgressInfo(
            final boolean useCurrentAttemptProgressInfo) {
        this._useCurrentAttemptProgressInfo = useCurrentAttemptProgressInfo;
        this._has_useCurrentAttemptProgressInfo = true;
    }
    
    /**
     * Sets the value of field 'useCurrentAttemptProgressInfo'.
     * 
     * @param useCurrentAttemptProgressInfo the value of field
     * 'useCurrentAttemptProgressInfo'.
     */
    public void setUseCurrentAttemptProgressInfoMapped(
            final boolean useCurrentAttemptProgressInfo) {
        this._useCurrentAttemptProgressInfo = useCurrentAttemptProgressInfo;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * es.pode.parseadorXML.ControlModeType
     */
    public static es.pode.parseadorXML.castor.ControlModeType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ControlModeType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ControlModeType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
