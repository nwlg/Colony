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
 * Class ObjectiveType.
 * 
 * @version $Revision$ $Date$
 */
public class ObjectiveType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _satisfiedByMeasure.
     */
    private boolean _satisfiedByMeasure = false;

    /**
     * keeps track of state for field: _satisfiedByMeasure
     */
    private boolean _has_satisfiedByMeasure;

    /**
     * Field _minNormalizedMeasure.
     */
    private java.math.BigDecimal _minNormalizedMeasure = new java.math.BigDecimal("1.00000");

    /**
     * Field _mapInfo.
     */
    private es.pode.parseadorXML.castor.MapInfo _mapInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectiveType() {
        super();
        setMinNormalizedMeasure(new java.math.BigDecimal("1.00000"));
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
    public boolean getHasSatisfiedByMeasure() {
    	return this._has_satisfiedByMeasure;
    }
    public void setHasSatisfiedByMeasure(boolean value) {
    	this._has_satisfiedByMeasure=value;
    }
    
    
    /**
     */
    public void deleteSatisfiedByMeasure(
    ) {
        this._has_satisfiedByMeasure= false;
    }

    /**
     * Returns the value of field 'mapInfo'.
     * 
     * @return the value of field 'MapInfo'.
     */
    public es.pode.parseadorXML.castor.MapInfo getMapInfo(
    ) {
        return this._mapInfo;
    }

    /**
     * Returns the value of field 'minNormalizedMeasure'.
     * 
     * @return the value of field 'MinNormalizedMeasure'.
     */
    public java.math.BigDecimal getMinNormalizedMeasure(
    ) {
        return this._minNormalizedMeasure;
    }

    /**
     * Returns the value of field 'satisfiedByMeasure'.
     * 
     * @return the value of field 'SatisfiedByMeasure'.
     */
    public boolean getSatisfiedByMeasure(
    ) {
        return this._satisfiedByMeasure;
    }

    /**
     * Method hasSatisfiedByMeasure.
     * 
     * @return true if at least one SatisfiedByMeasure has been adde
     */
    public boolean hasSatisfiedByMeasure(
    ) {
        return this._has_satisfiedByMeasure;
    }

    /**
     * Returns the value of field 'satisfiedByMeasure'.
     * 
     * @return the value of field 'SatisfiedByMeasure'.
     */
    public boolean isSatisfiedByMeasure(
    ) {
        return this._satisfiedByMeasure;
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
     * Sets the value of field 'mapInfo'.
     * 
     * @param mapInfo the value of field 'mapInfo'.
     */
    public void setMapInfo(
            final es.pode.parseadorXML.castor.MapInfo mapInfo) {
        this._mapInfo = mapInfo;
    }

    /**
     * Sets the value of field 'minNormalizedMeasure'.
     * 
     * @param minNormalizedMeasure the value of field
     * 'minNormalizedMeasure'.
     */
    public void setMinNormalizedMeasure(
            final java.math.BigDecimal minNormalizedMeasure) {
        this._minNormalizedMeasure = minNormalizedMeasure;
    }

    /**
     * Sets the value of field 'satisfiedByMeasure'.
     * 
     * @param satisfiedByMeasure the value of field
     * 'satisfiedByMeasure'.
     */
    public void setSatisfiedByMeasure(
            final boolean satisfiedByMeasure) {
        this._satisfiedByMeasure = satisfiedByMeasure;
        this._has_satisfiedByMeasure = true;
    }
    
    public void setSatisfiedByMeasureMapped(
            final boolean satisfiedByMeasure) {
        this._satisfiedByMeasure = satisfiedByMeasure;
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
     * es.pode.parseadorXML.castorObjectiveType
     */
    public static es.pode.parseadorXML.castor.ObjectiveType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ObjectiveType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ObjectiveType.class, reader);
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
