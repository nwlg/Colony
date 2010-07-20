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
 * The type that describes an individual objective mapping. Mapping
 * one local objective GUID to one global objective GUID
 * 
 * @version $Revision$ $Date$
 */
public class ObjectiveMappingType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _targetObjectiveID.
     */
    private java.lang.String _targetObjectiveID;

    /**
     * Field _readSatisfiedStatus.
     */
    private boolean _readSatisfiedStatus = true;

    /**
     * keeps track of state for field: _readSatisfiedStatus
     */
    private boolean _has_readSatisfiedStatus;

    /**
     * Field _readNormalizedMeasure.
     */
    private boolean _readNormalizedMeasure = true;

    /**
     * keeps track of state for field: _readNormalizedMeasure
     */
    private boolean _has_readNormalizedMeasure;

    /**
     * Field _writeSatisfiedStatus.
     */
    private boolean _writeSatisfiedStatus = false;

    /**
     * keeps track of state for field: _writeSatisfiedStatus
     */
    private boolean _has_writeSatisfiedStatus;

    /**
     * Field _writeNormalizedMeasure.
     */
    private boolean _writeNormalizedMeasure = false;

    /**
     * keeps track of state for field: _writeNormalizedMeasure
     */
    private boolean _has_writeNormalizedMeasure;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectiveMappingType() {
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
    
    public boolean getHasReadSatisfiedStatus() {
    	return this._has_readSatisfiedStatus;
    }
    public void setHasReadSatisfiedStatus(boolean value) {
    	this._has_readSatisfiedStatus=value;
    }
    
    public boolean getHasReadNormalizedMeasure() {
    	return this._has_readNormalizedMeasure;
    }
    public void setHasReadNormalizedMeasure(boolean value) {
    	this._has_readNormalizedMeasure=value;
    }
    
    public boolean getHasWriteSatisfiedStatus() {
    	return this._has_writeSatisfiedStatus;
    }
    public void setHasWriteSatisfiedStatus(boolean value) {
    	this._has_writeSatisfiedStatus=value;
    }
    
    public boolean getHasWriteNormalizedMeasure() {
    	return this._has_writeNormalizedMeasure;
    }
    public void setHasWriteNormalizedMeasure(boolean value) {
    	this._has_writeNormalizedMeasure=value;
    }
    
    /**
     */
    public void deleteReadNormalizedMeasure(
    ) {
        this._has_readNormalizedMeasure= false;
    }

    /**
     */
    public void deleteReadSatisfiedStatus(
    ) {
        this._has_readSatisfiedStatus= false;
    }

    /**
     */
    public void deleteWriteNormalizedMeasure(
    ) {
        this._has_writeNormalizedMeasure= false;
    }

    /**
     */
    public void deleteWriteSatisfiedStatus(
    ) {
        this._has_writeSatisfiedStatus= false;
    }

    /**
     * Returns the value of field 'readNormalizedMeasure'.
     * 
     * @return the value of field 'ReadNormalizedMeasure'.
     */
    public boolean getReadNormalizedMeasure(
    ) {
        return this._readNormalizedMeasure;
    }

    /**
     * Returns the value of field 'readSatisfiedStatus'.
     * 
     * @return the value of field 'ReadSatisfiedStatus'.
     */
    public boolean getReadSatisfiedStatus(
    ) {
        return this._readSatisfiedStatus;
    }

    /**
     * Returns the value of field 'targetObjectiveID'.
     * 
     * @return the value of field 'TargetObjectiveID'.
     */
    public java.lang.String getTargetObjectiveID(
    ) {
        return this._targetObjectiveID;
    }

    /**
     * Returns the value of field 'writeNormalizedMeasure'.
     * 
     * @return the value of field 'WriteNormalizedMeasure'.
     */
    public boolean getWriteNormalizedMeasure(
    ) {
        return this._writeNormalizedMeasure;
    }

    /**
     * Returns the value of field 'writeSatisfiedStatus'.
     * 
     * @return the value of field 'WriteSatisfiedStatus'.
     */
    public boolean getWriteSatisfiedStatus(
    ) {
        return this._writeSatisfiedStatus;
    }

    /**
     * Method hasReadNormalizedMeasure.
     * 
     * @return true if at least one ReadNormalizedMeasure has been
     * added
     */
    public boolean hasReadNormalizedMeasure(
    ) {
        return this._has_readNormalizedMeasure;
    }

    /**
     * Method hasReadSatisfiedStatus.
     * 
     * @return true if at least one ReadSatisfiedStatus has been
     * added
     */
    public boolean hasReadSatisfiedStatus(
    ) {
        return this._has_readSatisfiedStatus;
    }

    /**
     * Method hasWriteNormalizedMeasure.
     * 
     * @return true if at least one WriteNormalizedMeasure has been
     * added
     */
    public boolean hasWriteNormalizedMeasure(
    ) {
        return this._has_writeNormalizedMeasure;
    }

    /**
     * Method hasWriteSatisfiedStatus.
     * 
     * @return true if at least one WriteSatisfiedStatus has been
     * added
     */
    public boolean hasWriteSatisfiedStatus(
    ) {
        return this._has_writeSatisfiedStatus;
    }

    /**
     * Returns the value of field 'readNormalizedMeasure'.
     * 
     * @return the value of field 'ReadNormalizedMeasure'.
     */
    public boolean isReadNormalizedMeasure(
    ) {
        return this._readNormalizedMeasure;
    }

    /**
     * Returns the value of field 'readSatisfiedStatus'.
     * 
     * @return the value of field 'ReadSatisfiedStatus'.
     */
    public boolean isReadSatisfiedStatus(
    ) {
        return this._readSatisfiedStatus;
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
     * Returns the value of field 'writeNormalizedMeasure'.
     * 
     * @return the value of field 'WriteNormalizedMeasure'.
     */
    public boolean isWriteNormalizedMeasure(
    ) {
        return this._writeNormalizedMeasure;
    }

    /**
     * Returns the value of field 'writeSatisfiedStatus'.
     * 
     * @return the value of field 'WriteSatisfiedStatus'.
     */
    public boolean isWriteSatisfiedStatus(
    ) {
        return this._writeSatisfiedStatus;
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
     * Sets the value of field 'readNormalizedMeasure'.
     * 
     * @param readNormalizedMeasure the value of field
     * 'readNormalizedMeasure'.
     */
    public void setReadNormalizedMeasure(
            final boolean readNormalizedMeasure) {
        this._readNormalizedMeasure = readNormalizedMeasure;
        this._has_readNormalizedMeasure = true;
    }
    
    public void setReadNormalizedMeasureMapped(
            final boolean readNormalizedMeasure) {
        this._readNormalizedMeasure = readNormalizedMeasure;
    }

	/**
     * Sets the value of field 'readSatisfiedStatus'.
     * 
     * @param readSatisfiedStatus the value of field
     * 'readSatisfiedStatus'.
     */
    public void setReadSatisfiedStatus(
            final boolean readSatisfiedStatus) {
        this._readSatisfiedStatus = readSatisfiedStatus;
        this._has_readSatisfiedStatus = true;
    }

    /**
     * Sets the value of field 'readSatisfiedStatus'.
     * 
     * @param readSatisfiedStatus the value of field
     * 'readSatisfiedStatus'.
     */
    public void setReadSatisfiedStatusMapped(
            final boolean readSatisfiedStatus) {
        this._readSatisfiedStatus = readSatisfiedStatus;
    }

    /**
     * Sets the value of field 'targetObjectiveID'.
     * 
     * @param targetObjectiveID the value of field
     * 'targetObjectiveID'.
     */
    public void setTargetObjectiveID(
            final java.lang.String targetObjectiveID) {
        this._targetObjectiveID = targetObjectiveID;
    }

	/**
     * Sets the value of field 'writeNormalizedMeasure'.
     * 
     * @param writeNormalizedMeasure the value of field
     * 'writeNormalizedMeasure'.
     */
    public void setWriteNormalizedMeasure(
            final boolean writeNormalizedMeasure) {
        this._writeNormalizedMeasure = writeNormalizedMeasure;
        this._has_writeNormalizedMeasure = true;
    }

    /**
     * Sets the value of field 'writeNormalizedMeasure'.
     * 
     * @param writeNormalizedMeasure the value of field
     * 'writeNormalizedMeasure'.
     */
    public void setWriteNormalizedMeasureMapped(
            final boolean writeNormalizedMeasure) {
        this._writeNormalizedMeasure = writeNormalizedMeasure;
    }

	/**
     * Sets the value of field 'writeSatisfiedStatus'.
     * 
     * @param writeSatisfiedStatus the value of field
     * 'writeSatisfiedStatus'.
     */
    public void setWriteSatisfiedStatus(
            final boolean writeSatisfiedStatus) {
        this._writeSatisfiedStatus = writeSatisfiedStatus;
        this._has_writeSatisfiedStatus = true;
    }
	
    /**
     * Sets the value of field 'writeSatisfiedStatus'.
     * 
     * @param writeSatisfiedStatus the value of field
     * 'writeSatisfiedStatus'.
     */
    public void setWriteSatisfiedStatusMapped(
            final boolean writeSatisfiedStatus) {
        this._writeSatisfiedStatus = writeSatisfiedStatus;
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
     * es.pode.parseadorXML.castorObjectiveMappingType
     */
    public static es.pode.parseadorXML.castor.ObjectiveMappingType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ObjectiveMappingType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ObjectiveMappingType.class, reader);
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
