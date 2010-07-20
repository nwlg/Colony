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
 * Class RollupRulesType.
 * 
 * @version $Revision$ $Date$
 */
public class RollupRulesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rollupObjectiveSatisfied.
     */
    private boolean _rollupObjectiveSatisfied = true;

    /**
     * keeps track of state for field: _rollupObjectiveSatisfied
     */
    private boolean _has_rollupObjectiveSatisfied;

    /**
     * Field _rollupProgressCompletion.
     */
    private boolean _rollupProgressCompletion = true;

    /**
     * keeps track of state for field: _rollupProgressCompletion
     */
    private boolean _has_rollupProgressCompletion;

    /**
     * Field _objectiveMeasureWeight.
     */
    private java.math.BigDecimal _objectiveMeasureWeight = new java.math.BigDecimal("1.0000");

    /**
     * Field _rollupRuleList.
     */
    private java.util.List _rollupRuleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RollupRulesType() {
        super();
        setObjectiveMeasureWeight(new java.math.BigDecimal("1.0000"));
        this._rollupRuleList = new java.util.ArrayList();
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
    
    public boolean getHasRollupObjectiveSatisfied() {
    	return this._has_rollupObjectiveSatisfied;
    }
    public void setHasRollupObjectiveSatisfied(boolean value) {
    	this._has_rollupObjectiveSatisfied=value;
    }
    
    public boolean getHasRollupProgressCompletion() {
    	return this._has_rollupProgressCompletion;
    }
    public void setHasRollupProgressCompletion(boolean value) {
    	this._has_rollupProgressCompletion=value;
    }
    
    
    /**
     * 
     * 
     * @param vRollupRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRollupRule(
            final es.pode.parseadorXML.castor.RollupRule vRollupRule)
    throws java.lang.IndexOutOfBoundsException {
        this._rollupRuleList.add(vRollupRule);
    }

    /**
     * 
     * 
     * @param index
     * @param vRollupRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRollupRule(
            final int index,
            final es.pode.parseadorXML.castor.RollupRule vRollupRule)
    throws java.lang.IndexOutOfBoundsException {
        this._rollupRuleList.add(index, vRollupRule);
    }

    /**
     */
    public void deleteRollupObjectiveSatisfied(
    ) {
        this._has_rollupObjectiveSatisfied= false;
    }

    /**
     */
    public void deleteRollupProgressCompletion(
    ) {
        this._has_rollupProgressCompletion= false;
    }

    /**
     * Method enumerateRollupRule.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateRollupRule(
    ) {
        return java.util.Collections.enumeration(this._rollupRuleList);
    }

    /**
     * Returns the value of field 'objectiveMeasureWeight'.
     * 
     * @return the value of field 'ObjectiveMeasureWeight'.
     */
    public java.math.BigDecimal getObjectiveMeasureWeight(
    ) {
        return this._objectiveMeasureWeight;
    }

    /**
     * Returns the value of field 'rollupObjectiveSatisfied'.
     * 
     * @return the value of field 'RollupObjectiveSatisfied'.
     */
    public boolean getRollupObjectiveSatisfied(
    ) {
        return this._rollupObjectiveSatisfied;
    }

    /**
     * Returns the value of field 'rollupProgressCompletion'.
     * 
     * @return the value of field 'RollupProgressCompletion'.
     */
    public boolean getRollupProgressCompletion(
    ) {
        return this._rollupProgressCompletion;
    }

    /**
     * Method getRollupRule.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorRollupRule at the given
     * index
     */
    public es.pode.parseadorXML.castor.RollupRule getRollupRule(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._rollupRuleList.size()) {
            throw new IndexOutOfBoundsException("getRollupRule: Index value '" + index + "' not in range [0.." + (this._rollupRuleList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.RollupRule) _rollupRuleList.get(index);
    }

    /**
     * Method getRollupRule.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.RollupRule[] getRollupRule(
    ) {
        es.pode.parseadorXML.castor.RollupRule[] array = new es.pode.parseadorXML.castor.RollupRule[0];
        return (es.pode.parseadorXML.castor.RollupRule[]) this._rollupRuleList.toArray(array);
    }

    /**
     * Method getRollupRuleCount.
     * 
     * @return the size of this collection
     */
    public int getRollupRuleCount(
    ) {
        return this._rollupRuleList.size();
    }

    /**
     * Method hasRollupObjectiveSatisfied.
     * 
     * @return true if at least one RollupObjectiveSatisfied has
     * been added
     */
    public boolean hasRollupObjectiveSatisfied(
    ) {
        return this._has_rollupObjectiveSatisfied;
    }

    /**
     * Method hasRollupProgressCompletion.
     * 
     * @return true if at least one RollupProgressCompletion has
     * been added
     */
    public boolean hasRollupProgressCompletion(
    ) {
        return this._has_rollupProgressCompletion;
    }

    /**
     * Returns the value of field 'rollupObjectiveSatisfied'.
     * 
     * @return the value of field 'RollupObjectiveSatisfied'.
     */
    public boolean isRollupObjectiveSatisfied(
    ) {
        return this._rollupObjectiveSatisfied;
    }

    /**
     * Returns the value of field 'rollupProgressCompletion'.
     * 
     * @return the value of field 'RollupProgressCompletion'.
     */
    public boolean isRollupProgressCompletion(
    ) {
        return this._rollupProgressCompletion;
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
     * Method iterateRollupRule.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateRollupRule(
    ) {
        return this._rollupRuleList.iterator();
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
     */
    public void removeAllRollupRule(
    ) {
        this._rollupRuleList.clear();
    }

    /**
     * Method removeRollupRule.
     * 
     * @param vRollupRule
     * @return true if the object was removed from the collection.
     */
    public boolean removeRollupRule(
            final es.pode.parseadorXML.castor.RollupRule vRollupRule) {
        boolean removed = _rollupRuleList.remove(vRollupRule);
        return removed;
    }

    /**
     * Method removeRollupRuleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.RollupRule removeRollupRuleAt(
            final int index) {
        java.lang.Object obj = this._rollupRuleList.remove(index);
        return (es.pode.parseadorXML.castor.RollupRule) obj;
    }

    /**
     * Sets the value of field 'objectiveMeasureWeight'.
     * 
     * @param objectiveMeasureWeight the value of field
     * 'objectiveMeasureWeight'.
     */
    public void setObjectiveMeasureWeight(
            final java.math.BigDecimal objectiveMeasureWeight) {
        this._objectiveMeasureWeight = objectiveMeasureWeight;
    }

    /**
     * Sets the value of field 'rollupObjectiveSatisfied'.
     * 
     * @param rollupObjectiveSatisfied the value of field
     * 'rollupObjectiveSatisfied'.
     */
    public void setRollupObjectiveSatisfied(
            final boolean rollupObjectiveSatisfied) {
        this._rollupObjectiveSatisfied = rollupObjectiveSatisfied;
        this._has_rollupObjectiveSatisfied = true;
    }
    
    public void setRollupObjectiveSatisfiedMapped(
            final boolean rollupObjectiveSatisfied) {
        this._rollupObjectiveSatisfied = rollupObjectiveSatisfied;
    }

    /**
     * Sets the value of field 'rollupProgressCompletion'.
     * 
     * @param rollupProgressCompletion the value of field
     * 'rollupProgressCompletion'.
     */
    public void setRollupProgressCompletion(
            final boolean rollupProgressCompletion) {
        this._rollupProgressCompletion = rollupProgressCompletion;
        this._has_rollupProgressCompletion = true;
    }
    
    public void setRollupProgressCompletionMapped(
            final boolean rollupProgressCompletion) {
        this._rollupProgressCompletion = rollupProgressCompletion;
    }

    /**
     * 
     * 
     * @param index
     * @param vRollupRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setRollupRule(
            final int index,
            final es.pode.parseadorXML.castor.RollupRule vRollupRule)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._rollupRuleList.size()) {
            throw new IndexOutOfBoundsException("setRollupRule: Index value '" + index + "' not in range [0.." + (this._rollupRuleList.size() - 1) + "]");
        }
        
        this._rollupRuleList.set(index, vRollupRule);
    }

    /**
     * 
     * 
     * @param vRollupRuleArray
     */
    public void setRollupRule(
            final es.pode.parseadorXML.castor.RollupRule[] vRollupRuleArray) {
        //-- copy array
        _rollupRuleList.clear();
        
        for (int i = 0; i < vRollupRuleArray.length; i++) {
                this._rollupRuleList.add(vRollupRuleArray[i]);
        }
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
     * es.pode.parseadorXML.castorRollupRulesType
     */
    public static es.pode.parseadorXML.castor.RollupRulesType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.RollupRulesType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.RollupRulesType.class, reader);
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
