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
 * Class RollupConsiderationsType.
 * 
 * @version $Revision$ $Date$
 */
public class RollupConsiderationsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _requiredForSatisfied.
     */
    private es.pode.parseadorXML.castor.types.RollupConsiderationType _requiredForSatisfied = es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always");

    /**
     * Field _requiredForNotSatisfied.
     */
    private es.pode.parseadorXML.castor.types.RollupConsiderationType _requiredForNotSatisfied = es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always");

    /**
     * Field _requiredForCompleted.
     */
    private es.pode.parseadorXML.castor.types.RollupConsiderationType _requiredForCompleted = es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always");

    /**
     * Field _requiredForIncomplete.
     */
    private es.pode.parseadorXML.castor.types.RollupConsiderationType _requiredForIncomplete = es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always");

    /**
     * Field _measureSatisfactionIfActive.
     */
    private boolean _measureSatisfactionIfActive = true;

    /**
     * keeps track of state for field: _measureSatisfactionIfActive
     */
    private boolean _has_measureSatisfactionIfActive;


      //----------------/
     //- Constructors -/
    //----------------/

    public RollupConsiderationsType() {
        super();
        setRequiredForSatisfied(es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always"));
        setRequiredForNotSatisfied(es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always"));
        setRequiredForCompleted(es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always"));
        setRequiredForIncomplete(es.pode.parseadorXML.castor.types.RollupConsiderationType.valueOf("always"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMeasureSatisfactionIfActive(
    ) {
        this._has_measureSatisfactionIfActive= false;
    }

    /**
     * Returns the value of field 'measureSatisfactionIfActive'.
     * 
     * @return the value of field 'MeasureSatisfactionIfActive'.
     */
    public boolean getMeasureSatisfactionIfActive(
    ) {
        return this._measureSatisfactionIfActive;
    }

    /**
     * Returns the value of field 'requiredForCompleted'.
     * 
     * @return the value of field 'RequiredForCompleted'.
     */
    public es.pode.parseadorXML.castor.types.RollupConsiderationType getRequiredForCompleted(
    ) {
        return this._requiredForCompleted;
    }

    /**
     * Returns the value of field 'requiredForIncomplete'.
     * 
     * @return the value of field 'RequiredForIncomplete'.
     */
    public es.pode.parseadorXML.castor.types.RollupConsiderationType getRequiredForIncomplete(
    ) {
        return this._requiredForIncomplete;
    }

    /**
     * Returns the value of field 'requiredForNotSatisfied'.
     * 
     * @return the value of field 'RequiredForNotSatisfied'.
     */
    public es.pode.parseadorXML.castor.types.RollupConsiderationType getRequiredForNotSatisfied(
    ) {
        return this._requiredForNotSatisfied;
    }

    /**
     * Returns the value of field 'requiredForSatisfied'.
     * 
     * @return the value of field 'RequiredForSatisfied'.
     */
    public es.pode.parseadorXML.castor.types.RollupConsiderationType getRequiredForSatisfied(
    ) {
        return this._requiredForSatisfied;
    }

    /**
     * Method hasMeasureSatisfactionIfActive.
     * 
     * @return true if at least one MeasureSatisfactionIfActive has
     * been added
     */
    public boolean hasMeasureSatisfactionIfActive(
    ) {
        return this._has_measureSatisfactionIfActive;
    }

    /**
     * Returns the value of field 'measureSatisfactionIfActive'.
     * 
     * @return the value of field 'MeasureSatisfactionIfActive'.
     */
    public boolean isMeasureSatisfactionIfActive(
    ) {
        return this._measureSatisfactionIfActive;
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
     * Sets the value of field 'measureSatisfactionIfActive'.
     * 
     * @param measureSatisfactionIfActive the value of field
     * 'measureSatisfactionIfActive'.
     */
    public void setMeasureSatisfactionIfActive(
            final boolean measureSatisfactionIfActive) {
        this._measureSatisfactionIfActive = measureSatisfactionIfActive;
        this._has_measureSatisfactionIfActive = true;
    }

    /**
     * Sets the value of field 'requiredForCompleted'.
     * 
     * @param requiredForCompleted the value of field
     * 'requiredForCompleted'.
     */
    public void setRequiredForCompleted(
            final es.pode.parseadorXML.castor.types.RollupConsiderationType requiredForCompleted) {
        this._requiredForCompleted = requiredForCompleted;
    }

    /**
     * Sets the value of field 'requiredForIncomplete'.
     * 
     * @param requiredForIncomplete the value of field
     * 'requiredForIncomplete'.
     */
    public void setRequiredForIncomplete(
            final es.pode.parseadorXML.castor.types.RollupConsiderationType requiredForIncomplete) {
        this._requiredForIncomplete = requiredForIncomplete;
    }

    /**
     * Sets the value of field 'requiredForNotSatisfied'.
     * 
     * @param requiredForNotSatisfied the value of field
     * 'requiredForNotSatisfied'.
     */
    public void setRequiredForNotSatisfied(
            final es.pode.parseadorXML.castor.types.RollupConsiderationType requiredForNotSatisfied) {
        this._requiredForNotSatisfied = requiredForNotSatisfied;
    }

    /**
     * Sets the value of field 'requiredForSatisfied'.
     * 
     * @param requiredForSatisfied the value of field
     * 'requiredForSatisfied'.
     */
    public void setRequiredForSatisfied(
            final es.pode.parseadorXML.castor.types.RollupConsiderationType requiredForSatisfied) {
        this._requiredForSatisfied = requiredForSatisfied;
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
     * es.pode.parseadorXML.castor.RollupConsiderationsType
     */
    public static es.pode.parseadorXML.castor.RollupConsiderationsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.RollupConsiderationsType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.RollupConsiderationsType.class, reader);
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
