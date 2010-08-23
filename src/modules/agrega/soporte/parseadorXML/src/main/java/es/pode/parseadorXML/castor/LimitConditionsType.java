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
 * Class LimitConditionsType.
 * 
 * @version $Revision$ $Date$
 */
public class LimitConditionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Limit Condition Attempt Limit
     */
    private long _attemptLimit;

    /**
     * keeps track of state for field: _attemptLimit
     */
    private boolean _has_attemptLimit;

    /**
     * Limit Condition Activity Attempt Absolute Duration Limit.
     * Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     */
    private org.exolab.castor.types.Duration _attemptAbsoluteDurationLimit;

    /**
     * Limit Condition Activity Attempt Experienced Duration Limit.
     * Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     */
    private org.exolab.castor.types.Duration _attemptExperiencedDurationLimit;

    /**
     * Limit Condition Activity Absolute Duration Limit. Typed as
     * xs:duration: see http://www.w3.org/TR/xmlschema-2/#duration
     */
    private org.exolab.castor.types.Duration _activityAbsoluteDurationLimit;

    /**
     * Limit Condition Activity Experienced Duration Limit. Typed
     * as xs:duration: see http://www.w3.org/TR/xmlschema-2/#duratio
     */
    private org.exolab.castor.types.Duration _activityExperiencedDurationLimit;

    /**
     * Limit Condition Begin Time Limit
     */
    private java.util.Date _beginTimeLimit;

    /**
     * Limit Condition End Time Limit
     */
    private java.util.Date _endTimeLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public LimitConditionsType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /*
	 * Metodos get y set de los atributos _has_XXXX usados por Dozer para los
	 * mapeos
	 * 
	 * fjespino
	 */
    
    public boolean getHasAttemptLimit() {
    	return this._has_attemptLimit;
    }
    
    public void setHasAttemptLimit(boolean value) {
    	this._has_attemptLimit=value;
    }
    /**
     */
    public void deleteAttemptLimit(
    ) {
        this._has_attemptLimit= false;
    }

    /**
     * Returns the value of field 'activityAbsoluteDurationLimit'.
     * The field 'activityAbsoluteDurationLimit' has the following
     * description: Limit Condition Activity Absolute Duration
     * Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @return the value of field 'ActivityAbsoluteDurationLimit'.
     */
    public org.exolab.castor.types.Duration getActivityAbsoluteDurationLimit(
    ) {
        return this._activityAbsoluteDurationLimit;
    }

    /**
     * Returns the value of field
     * 'activityExperiencedDurationLimit'. The field
     * 'activityExperiencedDurationLimit' has the following
     * description: Limit Condition Activity Experienced Duration
     * Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @return the value of field 'ActivityExperiencedDurationLimit'
     */
    public org.exolab.castor.types.Duration getActivityExperiencedDurationLimit(
    ) {
        return this._activityExperiencedDurationLimit;
    }

    /**
     * Returns the value of field 'attemptAbsoluteDurationLimit'.
     * The field 'attemptAbsoluteDurationLimit' has the following
     * description: Limit Condition Activity Attempt Absolute
     * Duration Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @return the value of field 'AttemptAbsoluteDurationLimit'.
     */
    public org.exolab.castor.types.Duration getAttemptAbsoluteDurationLimit(
    ) {
        return this._attemptAbsoluteDurationLimit;
    }

    /**
     * Returns the value of field
     * 'attemptExperiencedDurationLimit'. The field
     * 'attemptExperiencedDurationLimit' has the following
     * description: Limit Condition Activity Attempt Experienced
     * Duration Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @return the value of field 'AttemptExperiencedDurationLimit'.
     */
    public org.exolab.castor.types.Duration getAttemptExperiencedDurationLimit(
    ) {
        return this._attemptExperiencedDurationLimit;
    }

    /**
     * Returns the value of field 'attemptLimit'. The field
     * 'attemptLimit' has the following description: Limit
     * Condition Attempt Limit
     * 
     * @return the value of field 'AttemptLimit'.
     */
    public long getAttemptLimit(
    ) {
        return this._attemptLimit;
    }

    /**
     * Returns the value of field 'beginTimeLimit'. The field
     * 'beginTimeLimit' has the following description: Limit
     * Condition Begin Time Limit
     * 
     * @return the value of field 'BeginTimeLimit'.
     */
    public java.util.Date getBeginTimeLimit(
    ) {
        return this._beginTimeLimit;
    }

    /**
     * Returns the value of field 'endTimeLimit'. The field
     * 'endTimeLimit' has the following description: Limit
     * Condition End Time Limit
     * 
     * @return the value of field 'EndTimeLimit'.
     */
    public java.util.Date getEndTimeLimit(
    ) {
        return this._endTimeLimit;
    }

    /**
     * Method hasAttemptLimit.
     * 
     * @return true if at least one AttemptLimit has been added
     */
    public boolean hasAttemptLimit(
    ) {
        return this._has_attemptLimit;
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
     * Sets the value of field 'activityAbsoluteDurationLimit'. The
     * field 'activityAbsoluteDurationLimit' has the following
     * description: Limit Condition Activity Absolute Duration
     * Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @param activityAbsoluteDurationLimit the value of field
     * 'activityAbsoluteDurationLimit'.
     */
    public void setActivityAbsoluteDurationLimit(
            final org.exolab.castor.types.Duration activityAbsoluteDurationLimit) {
        this._activityAbsoluteDurationLimit = activityAbsoluteDurationLimit;
    }

    /**
     * Sets the value of field 'activityExperiencedDurationLimit'.
     * The field 'activityExperiencedDurationLimit' has the
     * following description: Limit Condition Activity Experienced
     * Duration Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @param activityExperiencedDurationLimit the value of field
     * 'activityExperiencedDurationLimit'.
     */
    public void setActivityExperiencedDurationLimit(
            final org.exolab.castor.types.Duration activityExperiencedDurationLimit) {
        this._activityExperiencedDurationLimit = activityExperiencedDurationLimit;
    }

    /**
     * Sets the value of field 'attemptAbsoluteDurationLimit'. The
     * field 'attemptAbsoluteDurationLimit' has the following
     * description: Limit Condition Activity Attempt Absolute
     * Duration Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @param attemptAbsoluteDurationLimit the value of field
     * 'attemptAbsoluteDurationLimit'.
     */
    public void setAttemptAbsoluteDurationLimit(
            final org.exolab.castor.types.Duration attemptAbsoluteDurationLimit) {
        this._attemptAbsoluteDurationLimit = attemptAbsoluteDurationLimit;
    }

    /**
     * Sets the value of field 'attemptExperiencedDurationLimit'.
     * The field 'attemptExperiencedDurationLimit' has the
     * following description: Limit Condition Activity Attempt
     * Experienced Duration Limit. Typed as xs:duration: see
     * http://www.w3.org/TR/xmlschema-2/#duration
     * 
     * @param attemptExperiencedDurationLimit the value of field
     * 'attemptExperiencedDurationLimit'.
     */
    public void setAttemptExperiencedDurationLimit(
            final org.exolab.castor.types.Duration attemptExperiencedDurationLimit) {
        this._attemptExperiencedDurationLimit = attemptExperiencedDurationLimit;
    }

    /**
     * Sets the value of field 'attemptLimit'. The field
     * 'attemptLimit' has the following description: Limit
     * Condition Attempt Limit
     * 
     * @param attemptLimit the value of field 'attemptLimit'.
     */
    public void setAttemptLimit(
            final long attemptLimit) {
        this._attemptLimit = attemptLimit;
        this._has_attemptLimit = true;
    }
    
    public void setAttemptLimitMapped(
            final long attemptLimit) {
        this._attemptLimit = attemptLimit;
    }

    /**
     * Sets the value of field 'beginTimeLimit'. The field
     * 'beginTimeLimit' has the following description: Limit
     * Condition Begin Time Limit
     * 
     * @param beginTimeLimit the value of field 'beginTimeLimit'.
     */
    public void setBeginTimeLimit(
            final java.util.Date beginTimeLimit) {
        this._beginTimeLimit = beginTimeLimit;
    }

    /**
     * Sets the value of field 'endTimeLimit'. The field
     * 'endTimeLimit' has the following description: Limit
     * Condition End Time Limit
     * 
     * @param endTimeLimit the value of field 'endTimeLimit'.
     */
    public void setEndTimeLimit(
            final java.util.Date endTimeLimit) {
        this._endTimeLimit = endTimeLimit;
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
     * es.pode.parseadorXML.LimitConditionsType
     */
    public static es.pode.parseadorXML.castor.LimitConditionsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.LimitConditionsType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.LimitConditionsType.class, reader);
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
