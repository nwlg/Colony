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
 * Class RuleConditions.
 * 
 * @version $Revision$ $Date$
 */
public class RuleConditions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _conditionCombination.
     */
    private es.pode.parseadorXML.castor.types.ConditionCombinationType _conditionCombination = es.pode.parseadorXML.castor.types.ConditionCombinationType.valueOf("all");

    /**
     * Field _ruleConditionList.
     */
    private java.util.List _ruleConditionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RuleConditions() {
        super();
        setConditionCombination(es.pode.parseadorXML.castor.types.ConditionCombinationType.valueOf("all"));
        this._ruleConditionList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vRuleCondition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRuleCondition(
            final es.pode.parseadorXML.castor.RuleCondition vRuleCondition)
    throws java.lang.IndexOutOfBoundsException {
        this._ruleConditionList.add(vRuleCondition);
    }

    /**
     * 
     * 
     * @param index
     * @param vRuleCondition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRuleCondition(
            final int index,
            final es.pode.parseadorXML.castor.RuleCondition vRuleCondition)
    throws java.lang.IndexOutOfBoundsException {
        this._ruleConditionList.add(index, vRuleCondition);
    }

    /**
     * Method enumerateRuleCondition.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateRuleCondition(
    ) {
        return java.util.Collections.enumeration(this._ruleConditionList);
    }

    /**
     * Returns the value of field 'conditionCombination'.
     * 
     * @return the value of field 'ConditionCombination'.
     */
    public es.pode.parseadorXML.castor.types.ConditionCombinationType getConditionCombination(
    ) {
        return this._conditionCombination;
    }

    /**
     * Method getRuleCondition.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorRuleCondition at the given
     * index
     */
    public es.pode.parseadorXML.castor.RuleCondition getRuleCondition(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ruleConditionList.size()) {
            throw new IndexOutOfBoundsException("getRuleCondition: Index value '" + index + "' not in range [0.." + (this._ruleConditionList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.RuleCondition) _ruleConditionList.get(index);
    }

    /**
     * Method getRuleCondition.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.RuleCondition[] getRuleCondition(
    ) {
        es.pode.parseadorXML.castor.RuleCondition[] array = new es.pode.parseadorXML.castor.RuleCondition[0];
        return (es.pode.parseadorXML.castor.RuleCondition[]) this._ruleConditionList.toArray(array);
    }

    /**
     * Method getRuleConditionCount.
     * 
     * @return the size of this collection
     */
    public int getRuleConditionCount(
    ) {
        return this._ruleConditionList.size();
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
     * Method iterateRuleCondition.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateRuleCondition(
    ) {
        return this._ruleConditionList.iterator();
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
    public void removeAllRuleCondition(
    ) {
        this._ruleConditionList.clear();
    }

    /**
     * Method removeRuleCondition.
     * 
     * @param vRuleCondition
     * @return true if the object was removed from the collection.
     */
    public boolean removeRuleCondition(
            final es.pode.parseadorXML.castor.RuleCondition vRuleCondition) {
        boolean removed = _ruleConditionList.remove(vRuleCondition);
        return removed;
    }

    /**
     * Method removeRuleConditionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.RuleCondition removeRuleConditionAt(
            final int index) {
        java.lang.Object obj = this._ruleConditionList.remove(index);
        return (es.pode.parseadorXML.castor.RuleCondition) obj;
    }

    /**
     * Sets the value of field 'conditionCombination'.
     * 
     * @param conditionCombination the value of field
     * 'conditionCombination'.
     */
    public void setConditionCombination(
            final es.pode.parseadorXML.castor.types.ConditionCombinationType conditionCombination) {
        this._conditionCombination = conditionCombination;
    }

    /**
     * 
     * 
     * @param index
     * @param vRuleCondition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setRuleCondition(
            final int index,
            final es.pode.parseadorXML.castor.RuleCondition vRuleCondition)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ruleConditionList.size()) {
            throw new IndexOutOfBoundsException("setRuleCondition: Index value '" + index + "' not in range [0.." + (this._ruleConditionList.size() - 1) + "]");
        }
        
        this._ruleConditionList.set(index, vRuleCondition);
    }

    /**
     * 
     * 
     * @param vRuleConditionArray
     */
    public void setRuleCondition(
            final es.pode.parseadorXML.castor.RuleCondition[] vRuleConditionArray) {
        //-- copy array
        _ruleConditionList.clear();
        
        for (int i = 0; i < vRuleConditionArray.length; i++) {
                this._ruleConditionList.add(vRuleConditionArray[i]);
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
     * es.pode.parseadorXML.castorRuleConditions
     */
    public static es.pode.parseadorXML.castor.RuleConditions unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.RuleConditions) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.RuleConditions.class, reader);
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
