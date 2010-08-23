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
 * Class RandomizationType.
 * 
 * @version $Revision$ $Date$
 */
public class RandomizationType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _randomizationTiming.
     */
    private es.pode.parseadorXML.castor.types.RandomTimingType _randomizationTiming = es.pode.parseadorXML.castor.types.RandomTimingType.valueOf("never");

    /**
     * Field _selectCount.
     */
    private long _selectCount;

    /**
     * keeps track of state for field: _selectCount
     */
    private boolean _has_selectCount;

    /**
     * Field _reorderChildren.
     */
    private boolean _reorderChildren = false;

    /**
     * keeps track of state for field: _reorderChildren
     */
    private boolean _has_reorderChildren;

    /**
     * Field _selectionTiming.
     */
    private es.pode.parseadorXML.castor.types.RandomTimingType _selectionTiming = es.pode.parseadorXML.castor.types.RandomTimingType.valueOf("never");


      //----------------/
     //- Constructors -/
    //----------------/

    public RandomizationType() {
        super();
        setRandomizationTiming(es.pode.parseadorXML.castor.types.RandomTimingType.valueOf("never"));
        setSelectionTiming(es.pode.parseadorXML.castor.types.RandomTimingType.valueOf("never"));
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
    public boolean getHasSelectCount() {
    	return this._has_selectCount;
    }
    public void setHasSelectCount(boolean value) {
    	this._has_selectCount=value;
    }
    
    public boolean getHasReorderChildren() {
    	return this._has_reorderChildren;
    }
    public void setHasReorderChildren(boolean value) {
    	this._has_reorderChildren=value;
    }
    
    /**
     */
    public void deleteReorderChildren(
    ) {
        this._has_reorderChildren= false;
    }

    /**
     */
    public void deleteSelectCount(
    ) {
        this._has_selectCount= false;
    }

    /**
     * Returns the value of field 'randomizationTiming'.
     * 
     * @return the value of field 'RandomizationTiming'.
     */
    public es.pode.parseadorXML.castor.types.RandomTimingType getRandomizationTiming(
    ) {
        return this._randomizationTiming;
    }

    /**
     * Returns the value of field 'reorderChildren'.
     * 
     * @return the value of field 'ReorderChildren'.
     */
    public boolean getReorderChildren(
    ) {
        return this._reorderChildren;
    }

    /**
     * Returns the value of field 'selectCount'.
     * 
     * @return the value of field 'SelectCount'.
     */
    public long getSelectCount(
    ) {
        return this._selectCount;
    }

    /**
     * Returns the value of field 'selectionTiming'.
     * 
     * @return the value of field 'SelectionTiming'.
     */
    public es.pode.parseadorXML.castor.types.RandomTimingType getSelectionTiming(
    ) {
        return this._selectionTiming;
    }

    /**
     * Method hasReorderChildren.
     * 
     * @return true if at least one ReorderChildren has been added
     */
    public boolean hasReorderChildren(
    ) {
        return this._has_reorderChildren;
    }

    /**
     * Method hasSelectCount.
     * 
     * @return true if at least one SelectCount has been added
     */
    public boolean hasSelectCount(
    ) {
        return this._has_selectCount;
    }

    /**
     * Returns the value of field 'reorderChildren'.
     * 
     * @return the value of field 'ReorderChildren'.
     */
    public boolean isReorderChildren(
    ) {
        return this._reorderChildren;
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
     * Sets the value of field 'randomizationTiming'.
     * 
     * @param randomizationTiming the value of field
     * 'randomizationTiming'.
     */
    public void setRandomizationTiming(
            final es.pode.parseadorXML.castor.types.RandomTimingType randomizationTiming) {
        this._randomizationTiming = randomizationTiming;
    }

    /**
     * Sets the value of field 'reorderChildren'.
     * 
     * @param reorderChildren the value of field 'reorderChildren'.
     */
    public void setReorderChildren(
            final boolean reorderChildren) {
        this._reorderChildren = reorderChildren;
        this._has_reorderChildren = true;
    }
    
    public void setReorderChildrenMapped(
            final boolean reorderChildren) {
        this._reorderChildren = reorderChildren;
    }

    /**
     * Sets the value of field 'selectCount'.
     * 
     * @param selectCount the value of field 'selectCount'.
     */
    public void setSelectCount(
            final long selectCount) {
        this._selectCount = selectCount;
        this._has_selectCount = true;
    }
    
    public void setSelectCountMapped(
            final long selectCount) {
        this._selectCount = selectCount;
    }

    /**
     * Sets the value of field 'selectionTiming'.
     * 
     * @param selectionTiming the value of field 'selectionTiming'.
     */
    public void setSelectionTiming(
            final es.pode.parseadorXML.castor.types.RandomTimingType selectionTiming) {
        this._selectionTiming = selectionTiming;
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
     * es.pode.parseadorXML.RandomizationType
     */
    public static es.pode.parseadorXML.castor.RandomizationType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.RandomizationType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.RandomizationType.class, reader);
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
