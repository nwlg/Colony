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
 * Class SequencingRulesType.
 * 
 * @version $Revision$ $Date$
 */
public class SequencingRulesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _preConditionRuleList.
     */
    private java.util.List _preConditionRuleList;

    /**
     * Field _exitConditionRuleList.
     */
    private java.util.List _exitConditionRuleList;

    /**
     * Field _postConditionRuleList.
     */
    private java.util.List _postConditionRuleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SequencingRulesType() {
        super();
        this._preConditionRuleList = new java.util.ArrayList();
        this._exitConditionRuleList = new java.util.ArrayList();
        this._postConditionRuleList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vExitConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addExitConditionRule(
            final es.pode.parseadorXML.castor.ExitConditionRule vExitConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        this._exitConditionRuleList.add(vExitConditionRule);
    }

    /**
     * 
     * 
     * @param index
     * @param vExitConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addExitConditionRule(
            final int index,
            final es.pode.parseadorXML.castor.ExitConditionRule vExitConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        this._exitConditionRuleList.add(index, vExitConditionRule);
    }

    /**
     * 
     * 
     * @param vPostConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPostConditionRule(
            final es.pode.parseadorXML.castor.PostConditionRule vPostConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        this._postConditionRuleList.add(vPostConditionRule);
    }

    /**
     * 
     * 
     * @param index
     * @param vPostConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPostConditionRule(
            final int index,
            final es.pode.parseadorXML.castor.PostConditionRule vPostConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        this._postConditionRuleList.add(index, vPostConditionRule);
    }

    /**
     * 
     * 
     * @param vPreConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreConditionRule(
            final es.pode.parseadorXML.castor.PreConditionRule vPreConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        this._preConditionRuleList.add(vPreConditionRule);
    }

    /**
     * 
     * 
     * @param index
     * @param vPreConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreConditionRule(
            final int index,
            final es.pode.parseadorXML.castor.PreConditionRule vPreConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        this._preConditionRuleList.add(index, vPreConditionRule);
    }

    /**
     * Method enumerateExitConditionRule.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateExitConditionRule(
    ) {
        return java.util.Collections.enumeration(this._exitConditionRuleList);
    }

    /**
     * Method enumeratePostConditionRule.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumeratePostConditionRule(
    ) {
        return java.util.Collections.enumeration(this._postConditionRuleList);
    }

    /**
     * Method enumeratePreConditionRule.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumeratePreConditionRule(
    ) {
        return java.util.Collections.enumeration(this._preConditionRuleList);
    }

    /**
     * Method getExitConditionRule.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorExitConditionRule at the
     * given index
     */
    public es.pode.parseadorXML.castor.ExitConditionRule getExitConditionRule(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._exitConditionRuleList.size()) {
            throw new IndexOutOfBoundsException("getExitConditionRule: Index value '" + index + "' not in range [0.." + (this._exitConditionRuleList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.ExitConditionRule) _exitConditionRuleList.get(index);
    }

    /**
     * Method getExitConditionRule.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.ExitConditionRule[] getExitConditionRule(
    ) {
        es.pode.parseadorXML.castor.ExitConditionRule[] array = new es.pode.parseadorXML.castor.ExitConditionRule[0];
        return (es.pode.parseadorXML.castor.ExitConditionRule[]) this._exitConditionRuleList.toArray(array);
    }

    /**
     * Method getExitConditionRuleCount.
     * 
     * @return the size of this collection
     */
    public int getExitConditionRuleCount(
    ) {
        return this._exitConditionRuleList.size();
    }

    /**
     * Method getPostConditionRule.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorPostConditionRule at the
     * given index
     */
    public es.pode.parseadorXML.castor.PostConditionRule getPostConditionRule(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._postConditionRuleList.size()) {
            throw new IndexOutOfBoundsException("getPostConditionRule: Index value '" + index + "' not in range [0.." + (this._postConditionRuleList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.PostConditionRule) _postConditionRuleList.get(index);
    }

    /**
     * Method getPostConditionRule.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.PostConditionRule[] getPostConditionRule(
    ) {
        es.pode.parseadorXML.castor.PostConditionRule[] array = new es.pode.parseadorXML.castor.PostConditionRule[0];
        return (es.pode.parseadorXML.castor.PostConditionRule[]) this._postConditionRuleList.toArray(array);
    }

    /**
     * Method getPostConditionRuleCount.
     * 
     * @return the size of this collection
     */
    public int getPostConditionRuleCount(
    ) {
        return this._postConditionRuleList.size();
    }

    /**
     * Method getPreConditionRule.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorPreConditionRule at the
     * given index
     */
    public es.pode.parseadorXML.castor.PreConditionRule getPreConditionRule(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._preConditionRuleList.size()) {
            throw new IndexOutOfBoundsException("getPreConditionRule: Index value '" + index + "' not in range [0.." + (this._preConditionRuleList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.PreConditionRule) _preConditionRuleList.get(index);
    }

    /**
     * Method getPreConditionRule.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.PreConditionRule[] getPreConditionRule(
    ) {
        es.pode.parseadorXML.castor.PreConditionRule[] array = new es.pode.parseadorXML.castor.PreConditionRule[0];
        return (es.pode.parseadorXML.castor.PreConditionRule[]) this._preConditionRuleList.toArray(array);
    }

    /**
     * Method getPreConditionRuleCount.
     * 
     * @return the size of this collection
     */
    public int getPreConditionRuleCount(
    ) {
        return this._preConditionRuleList.size();
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
     * Method iterateExitConditionRule.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateExitConditionRule(
    ) {
        return this._exitConditionRuleList.iterator();
    }

    /**
     * Method iteratePostConditionRule.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iteratePostConditionRule(
    ) {
        return this._postConditionRuleList.iterator();
    }

    /**
     * Method iteratePreConditionRule.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iteratePreConditionRule(
    ) {
        return this._preConditionRuleList.iterator();
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
    public void removeAllExitConditionRule(
    ) {
        this._exitConditionRuleList.clear();
    }

    /**
     */
    public void removeAllPostConditionRule(
    ) {
        this._postConditionRuleList.clear();
    }

    /**
     */
    public void removeAllPreConditionRule(
    ) {
        this._preConditionRuleList.clear();
    }

    /**
     * Method removeExitConditionRule.
     * 
     * @param vExitConditionRule
     * @return true if the object was removed from the collection.
     */
    public boolean removeExitConditionRule(
            final es.pode.parseadorXML.castor.ExitConditionRule vExitConditionRule) {
        boolean removed = _exitConditionRuleList.remove(vExitConditionRule);
        return removed;
    }

    /**
     * Method removeExitConditionRuleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.ExitConditionRule removeExitConditionRuleAt(
            final int index) {
        java.lang.Object obj = this._exitConditionRuleList.remove(index);
        return (es.pode.parseadorXML.castor.ExitConditionRule) obj;
    }

    /**
     * Method removePostConditionRule.
     * 
     * @param vPostConditionRule
     * @return true if the object was removed from the collection.
     */
    public boolean removePostConditionRule(
            final es.pode.parseadorXML.castor.PostConditionRule vPostConditionRule) {
        boolean removed = _postConditionRuleList.remove(vPostConditionRule);
        return removed;
    }

    /**
     * Method removePostConditionRuleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.PostConditionRule removePostConditionRuleAt(
            final int index) {
        java.lang.Object obj = this._postConditionRuleList.remove(index);
        return (es.pode.parseadorXML.castor.PostConditionRule) obj;
    }

    /**
     * Method removePreConditionRule.
     * 
     * @param vPreConditionRule
     * @return true if the object was removed from the collection.
     */
    public boolean removePreConditionRule(
            final es.pode.parseadorXML.castor.PreConditionRule vPreConditionRule) {
        boolean removed = _preConditionRuleList.remove(vPreConditionRule);
        return removed;
    }

    /**
     * Method removePreConditionRuleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.PreConditionRule removePreConditionRuleAt(
            final int index) {
        java.lang.Object obj = this._preConditionRuleList.remove(index);
        return (es.pode.parseadorXML.castor.PreConditionRule) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vExitConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setExitConditionRule(
            final int index,
            final es.pode.parseadorXML.castor.ExitConditionRule vExitConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._exitConditionRuleList.size()) {
            throw new IndexOutOfBoundsException("setExitConditionRule: Index value '" + index + "' not in range [0.." + (this._exitConditionRuleList.size() - 1) + "]");
        }
        
        this._exitConditionRuleList.set(index, vExitConditionRule);
    }

    /**
     * 
     * 
     * @param vExitConditionRuleArray
     */
    public void setExitConditionRule(
            final es.pode.parseadorXML.castor.ExitConditionRule[] vExitConditionRuleArray) {
        //-- copy array
        _exitConditionRuleList.clear();
        
        for (int i = 0; i < vExitConditionRuleArray.length; i++) {
                this._exitConditionRuleList.add(vExitConditionRuleArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vPostConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPostConditionRule(
            final int index,
            final es.pode.parseadorXML.castor.PostConditionRule vPostConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._postConditionRuleList.size()) {
            throw new IndexOutOfBoundsException("setPostConditionRule: Index value '" + index + "' not in range [0.." + (this._postConditionRuleList.size() - 1) + "]");
        }
        
        this._postConditionRuleList.set(index, vPostConditionRule);
    }

    /**
     * 
     * 
     * @param vPostConditionRuleArray
     */
    public void setPostConditionRule(
            final es.pode.parseadorXML.castor.PostConditionRule[] vPostConditionRuleArray) {
        //-- copy array
        _postConditionRuleList.clear();
        
        for (int i = 0; i < vPostConditionRuleArray.length; i++) {
                this._postConditionRuleList.add(vPostConditionRuleArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vPreConditionRule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPreConditionRule(
            final int index,
            final es.pode.parseadorXML.castor.PreConditionRule vPreConditionRule)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._preConditionRuleList.size()) {
            throw new IndexOutOfBoundsException("setPreConditionRule: Index value '" + index + "' not in range [0.." + (this._preConditionRuleList.size() - 1) + "]");
        }
        
        this._preConditionRuleList.set(index, vPreConditionRule);
    }

    /**
     * 
     * 
     * @param vPreConditionRuleArray
     */
    public void setPreConditionRule(
            final es.pode.parseadorXML.castor.PreConditionRule[] vPreConditionRuleArray) {
        //-- copy array
        _preConditionRuleList.clear();
        
        for (int i = 0; i < vPreConditionRuleArray.length; i++) {
                this._preConditionRuleList.add(vPreConditionRuleArray[i]);
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
     * es.pode.parseadorXML.castorSequencingRulesType
     */
    public static es.pode.parseadorXML.castor.SequencingRulesType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.SequencingRulesType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.SequencingRulesType.class, reader);
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
