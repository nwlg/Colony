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
 * Class ComplexTypeGeneral.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeGeneral implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uniqueElementName.
     */
    private java.lang.String _uniqueElementName = "general";

    /**
     * Field _identifierList.
     */
    private java.util.List _identifierList;

    /**
     * Field _title.
     */
    private es.pode.parseadorXML.castor.Title _title;

    /**
     * Field _languageList.
     */
    private java.util.List _languageList;

    /**
     * Field _descriptionUnboundedList.
     */
    private java.util.List _descriptionUnboundedList;

    /**
     * Field _keywordList.
     */
    private java.util.List _keywordList;

    /**
     * Field _coverageList.
     */
    private java.util.List _coverageList;

    /**
     * Field _structure.
     */
    private es.pode.parseadorXML.castor.Structure _structure;

    /**
     * Field _aggregationLevel.
     */
    private es.pode.parseadorXML.castor.AggregationLevel _aggregationLevel;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeGeneral() {
        super();
        setUniqueElementName("general");
        this._identifierList = new java.util.ArrayList();
        this._languageList = new java.util.ArrayList();
        this._descriptionUnboundedList = new java.util.ArrayList();
        this._keywordList = new java.util.ArrayList();
        this._coverageList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCoverage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCoverage(
            final es.pode.parseadorXML.castor.Coverage vCoverage)
    throws java.lang.IndexOutOfBoundsException {
        this._coverageList.add(vCoverage);
    }

    /**
     * 
     * 
     * @param index
     * @param vCoverage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCoverage(
            final int index,
            final es.pode.parseadorXML.castor.Coverage vCoverage)
    throws java.lang.IndexOutOfBoundsException {
        this._coverageList.add(index, vCoverage);
    }

    /**
     * 
     * 
     * @param vDescriptionUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDescriptionUnbounded(
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        this._descriptionUnboundedList.add(vDescriptionUnbounded);
    }

    /**
     * 
     * 
     * @param index
     * @param vDescriptionUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDescriptionUnbounded(
            final int index,
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        this._descriptionUnboundedList.add(index, vDescriptionUnbounded);
    }

    /**
     * 
     * 
     * @param vIdentifier
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIdentifier(
            final es.pode.parseadorXML.castor.Identifier vIdentifier)
    throws java.lang.IndexOutOfBoundsException {
        this._identifierList.add(vIdentifier);
    }

    /**
     * 
     * 
     * @param index
     * @param vIdentifier
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIdentifier(
            final int index,
            final es.pode.parseadorXML.castor.Identifier vIdentifier)
    throws java.lang.IndexOutOfBoundsException {
        this._identifierList.add(index, vIdentifier);
    }

    /**
     * 
     * 
     * @param vKeyword
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addKeyword(
            final es.pode.parseadorXML.castor.Keyword vKeyword)
    throws java.lang.IndexOutOfBoundsException {
        this._keywordList.add(vKeyword);
    }

    /**
     * 
     * 
     * @param index
     * @param vKeyword
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addKeyword(
            final int index,
            final es.pode.parseadorXML.castor.Keyword vKeyword)
    throws java.lang.IndexOutOfBoundsException {
        this._keywordList.add(index, vKeyword);
    }

    /**
     * 
     * 
     * @param vLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLanguage(
            final es.pode.parseadorXML.castor.Language vLanguage)
    throws java.lang.IndexOutOfBoundsException {
        this._languageList.add(vLanguage);
    }

    /**
     * 
     * 
     * @param index
     * @param vLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLanguage(
            final int index,
            final es.pode.parseadorXML.castor.Language vLanguage)
    throws java.lang.IndexOutOfBoundsException {
        this._languageList.add(index, vLanguage);
    }

    /**
     * Method enumerateCoverage.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateCoverage(
    ) {
        return java.util.Collections.enumeration(this._coverageList);
    }

    /**
     * Method enumerateDescriptionUnbounded.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateDescriptionUnbounded(
    ) {
        return java.util.Collections.enumeration(this._descriptionUnboundedList);
    }

    /**
     * Method enumerateIdentifier.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateIdentifier(
    ) {
        return java.util.Collections.enumeration(this._identifierList);
    }

    /**
     * Method enumerateKeyword.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateKeyword(
    ) {
        return java.util.Collections.enumeration(this._keywordList);
    }

    /**
     * Method enumerateLanguage.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateLanguage(
    ) {
        return java.util.Collections.enumeration(this._languageList);
    }

    /**
     * Returns the value of field 'aggregationLevel'.
     * 
     * @return the value of field 'AggregationLevel'.
     */
    public es.pode.parseadorXML.castor.AggregationLevel getAggregationLevel(
    ) {
        return this._aggregationLevel;
    }

    /**
     * Method getCoverage.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Coverage at the given index
     */
    public es.pode.parseadorXML.castor.Coverage getCoverage(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._coverageList.size()) {
            throw new IndexOutOfBoundsException("getCoverage: Index value '" + index + "' not in range [0.." + (this._coverageList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Coverage) _coverageList.get(index);
    }

    /**
     * Method getCoverage.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Coverage[] getCoverage(
    ) {
        es.pode.parseadorXML.castor.Coverage[] array = new es.pode.parseadorXML.castor.Coverage[0];
        return (es.pode.parseadorXML.castor.Coverage[]) this._coverageList.toArray(array);
    }

    /**
     * Method getCoverageCount.
     * 
     * @return the size of this collection
     */
    public int getCoverageCount(
    ) {
        return this._coverageList.size();
    }

    /**
     * Method getDescriptionUnbounded.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.DescriptionUnbounded at
     * the given index
     */
    public es.pode.parseadorXML.castor.DescriptionUnbounded getDescriptionUnbounded(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._descriptionUnboundedList.size()) {
            throw new IndexOutOfBoundsException("getDescriptionUnbounded: Index value '" + index + "' not in range [0.." + (this._descriptionUnboundedList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.DescriptionUnbounded) _descriptionUnboundedList.get(index);
    }

    /**
     * Method getDescriptionUnbounded.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.DescriptionUnbounded[] getDescriptionUnbounded(
    ) {
        es.pode.parseadorXML.castor.DescriptionUnbounded[] array = new es.pode.parseadorXML.castor.DescriptionUnbounded[0];
        return (es.pode.parseadorXML.castor.DescriptionUnbounded[]) this._descriptionUnboundedList.toArray(array);
    }

    /**
     * Method getDescriptionUnboundedCount.
     * 
     * @return the size of this collection
     */
    public int getDescriptionUnboundedCount(
    ) {
        return this._descriptionUnboundedList.size();
    }

    /**
     * Method getIdentifier.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Identifier at the given
     * index
     */
    public es.pode.parseadorXML.castor.Identifier getIdentifier(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._identifierList.size()) {
            throw new IndexOutOfBoundsException("getIdentifier: Index value '" + index + "' not in range [0.." + (this._identifierList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Identifier) _identifierList.get(index);
    }

    /**
     * Method getIdentifier.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Identifier[] getIdentifier(
    ) {
        es.pode.parseadorXML.castor.Identifier[] array = new es.pode.parseadorXML.castor.Identifier[0];
        return (es.pode.parseadorXML.castor.Identifier[]) this._identifierList.toArray(array);
    }

    /**
     * Method getIdentifierCount.
     * 
     * @return the size of this collection
     */
    public int getIdentifierCount(
    ) {
        return this._identifierList.size();
    }

    /**
     * Method getKeyword.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Keyword at the given index
     */
    public es.pode.parseadorXML.castor.Keyword getKeyword(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._keywordList.size()) {
            throw new IndexOutOfBoundsException("getKeyword: Index value '" + index + "' not in range [0.." + (this._keywordList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Keyword) _keywordList.get(index);
    }

    /**
     * Method getKeyword.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Keyword[] getKeyword(
    ) {
        es.pode.parseadorXML.castor.Keyword[] array = new es.pode.parseadorXML.castor.Keyword[0];
        return (es.pode.parseadorXML.castor.Keyword[]) this._keywordList.toArray(array);
    }

    /**
     * Method getKeywordCount.
     * 
     * @return the size of this collection
     */
    public int getKeywordCount(
    ) {
        return this._keywordList.size();
    }

    /**
     * Method getLanguage.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Language at the given index
     */
    public es.pode.parseadorXML.castor.Language getLanguage(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._languageList.size()) {
            throw new IndexOutOfBoundsException("getLanguage: Index value '" + index + "' not in range [0.." + (this._languageList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Language) _languageList.get(index);
    }

    /**
     * Method getLanguage.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Language[] getLanguage(
    ) {
        es.pode.parseadorXML.castor.Language[] array = new es.pode.parseadorXML.castor.Language[0];
        return (es.pode.parseadorXML.castor.Language[]) this._languageList.toArray(array);
    }

    /**
     * Method getLanguageCount.
     * 
     * @return the size of this collection
     */
    public int getLanguageCount(
    ) {
        return this._languageList.size();
    }

    /**
     * Returns the value of field 'structure'.
     * 
     * @return the value of field 'Structure'.
     */
    public es.pode.parseadorXML.castor.Structure getStructure(
    ) {
        return this._structure;
    }

    /**
     * Returns the value of field 'title'.
     * 
     * @return the value of field 'Title'.
     */
    public es.pode.parseadorXML.castor.Title getTitle(
    ) {
        return this._title;
    }

    /**
     * Returns the value of field 'uniqueElementName'.
     * 
     * @return the value of field 'UniqueElementName'.
     */
    public java.lang.String getUniqueElementName(
    ) {
        return this._uniqueElementName;
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
     * Method iterateCoverage.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateCoverage(
    ) {
        return this._coverageList.iterator();
    }

    /**
     * Method iterateDescriptionUnbounded.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateDescriptionUnbounded(
    ) {
        return this._descriptionUnboundedList.iterator();
    }

    /**
     * Method iterateIdentifier.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateIdentifier(
    ) {
        return this._identifierList.iterator();
    }

    /**
     * Method iterateKeyword.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateKeyword(
    ) {
        return this._keywordList.iterator();
    }

    /**
     * Method iterateLanguage.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateLanguage(
    ) {
        return this._languageList.iterator();
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
    public void removeAllCoverage(
    ) {
        this._coverageList.clear();
    }

    /**
     */
    public void removeAllDescriptionUnbounded(
    ) {
        this._descriptionUnboundedList.clear();
    }

    /**
     */
    public void removeAllIdentifier(
    ) {
        this._identifierList.clear();
    }

    /**
     */
    public void removeAllKeyword(
    ) {
        this._keywordList.clear();
    }

    /**
     */
    public void removeAllLanguage(
    ) {
        this._languageList.clear();
    }

    /**
     * Method removeCoverage.
     * 
     * @param vCoverage
     * @return true if the object was removed from the collection.
     */
    public boolean removeCoverage(
            final es.pode.parseadorXML.castor.Coverage vCoverage) {
        boolean removed = _coverageList.remove(vCoverage);
        return removed;
    }

    /**
     * Method removeCoverageAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Coverage removeCoverageAt(
            final int index) {
        java.lang.Object obj = this._coverageList.remove(index);
        return (es.pode.parseadorXML.castor.Coverage) obj;
    }

    /**
     * Method removeDescriptionUnbounded.
     * 
     * @param vDescriptionUnbounded
     * @return true if the object was removed from the collection.
     */
    public boolean removeDescriptionUnbounded(
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded) {
        boolean removed = _descriptionUnboundedList.remove(vDescriptionUnbounded);
        return removed;
    }

    /**
     * Method removeDescriptionUnboundedAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.DescriptionUnbounded removeDescriptionUnboundedAt(
            final int index) {
        java.lang.Object obj = this._descriptionUnboundedList.remove(index);
        return (es.pode.parseadorXML.castor.DescriptionUnbounded) obj;
    }

    /**
     * Method removeIdentifier.
     * 
     * @param vIdentifier
     * @return true if the object was removed from the collection.
     */
    public boolean removeIdentifier(
            final es.pode.parseadorXML.castor.Identifier vIdentifier) {
        boolean removed = _identifierList.remove(vIdentifier);
        return removed;
    }

    /**
     * Method removeIdentifierAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Identifier removeIdentifierAt(
            final int index) {
        java.lang.Object obj = this._identifierList.remove(index);
        return (es.pode.parseadorXML.castor.Identifier) obj;
    }

    /**
     * Method removeKeyword.
     * 
     * @param vKeyword
     * @return true if the object was removed from the collection.
     */
    public boolean removeKeyword(
            final es.pode.parseadorXML.castor.Keyword vKeyword) {
        boolean removed = _keywordList.remove(vKeyword);
        return removed;
    }

    /**
     * Method removeKeywordAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Keyword removeKeywordAt(
            final int index) {
        java.lang.Object obj = this._keywordList.remove(index);
        return (es.pode.parseadorXML.castor.Keyword) obj;
    }

    /**
     * Method removeLanguage.
     * 
     * @param vLanguage
     * @return true if the object was removed from the collection.
     */
    public boolean removeLanguage(
            final es.pode.parseadorXML.castor.Language vLanguage) {
        boolean removed = _languageList.remove(vLanguage);
        return removed;
    }

    /**
     * Method removeLanguageAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Language removeLanguageAt(
            final int index) {
        java.lang.Object obj = this._languageList.remove(index);
        return (es.pode.parseadorXML.castor.Language) obj;
    }

    /**
     * Sets the value of field 'aggregationLevel'.
     * 
     * @param aggregationLevel the value of field 'aggregationLevel'
     */
    public void setAggregationLevel(
            final es.pode.parseadorXML.castor.AggregationLevel aggregationLevel) {
        this._aggregationLevel = aggregationLevel;
    }

    /**
     * 
     * 
     * @param index
     * @param vCoverage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCoverage(
            final int index,
            final es.pode.parseadorXML.castor.Coverage vCoverage)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._coverageList.size()) {
            throw new IndexOutOfBoundsException("setCoverage: Index value '" + index + "' not in range [0.." + (this._coverageList.size() - 1) + "]");
        }
        
        this._coverageList.set(index, vCoverage);
    }

    /**
     * 
     * 
     * @param vCoverageArray
     */
    public void setCoverage(
            final es.pode.parseadorXML.castor.Coverage[] vCoverageArray) {
        //-- copy array
        _coverageList.clear();
        
        for (int i = 0; i < vCoverageArray.length; i++) {
                this._coverageList.add(vCoverageArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vDescriptionUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDescriptionUnbounded(
            final int index,
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._descriptionUnboundedList.size()) {
            throw new IndexOutOfBoundsException("setDescriptionUnbounded: Index value '" + index + "' not in range [0.." + (this._descriptionUnboundedList.size() - 1) + "]");
        }
        
        this._descriptionUnboundedList.set(index, vDescriptionUnbounded);
    }

    /**
     * 
     * 
     * @param vDescriptionUnboundedArray
     */
    public void setDescriptionUnbounded(
            final es.pode.parseadorXML.castor.DescriptionUnbounded[] vDescriptionUnboundedArray) {
        //-- copy array
        _descriptionUnboundedList.clear();
        
        for (int i = 0; i < vDescriptionUnboundedArray.length; i++) {
                this._descriptionUnboundedList.add(vDescriptionUnboundedArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vIdentifier
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIdentifier(
            final int index,
            final es.pode.parseadorXML.castor.Identifier vIdentifier)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._identifierList.size()) {
            throw new IndexOutOfBoundsException("setIdentifier: Index value '" + index + "' not in range [0.." + (this._identifierList.size() - 1) + "]");
        }
        
        this._identifierList.set(index, vIdentifier);
    }

    /**
     * 
     * 
     * @param vIdentifierArray
     */
    public void setIdentifier(
            final es.pode.parseadorXML.castor.Identifier[] vIdentifierArray) {
        //-- copy array
        _identifierList.clear();
        
        for (int i = 0; i < vIdentifierArray.length; i++) {
                this._identifierList.add(vIdentifierArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vKeyword
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setKeyword(
            final int index,
            final es.pode.parseadorXML.castor.Keyword vKeyword)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._keywordList.size()) {
            throw new IndexOutOfBoundsException("setKeyword: Index value '" + index + "' not in range [0.." + (this._keywordList.size() - 1) + "]");
        }
        
        this._keywordList.set(index, vKeyword);
    }

    /**
     * 
     * 
     * @param vKeywordArray
     */
    public void setKeyword(
            final es.pode.parseadorXML.castor.Keyword[] vKeywordArray) {
        //-- copy array
        _keywordList.clear();
        
        for (int i = 0; i < vKeywordArray.length; i++) {
                this._keywordList.add(vKeywordArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLanguage(
            final int index,
            final es.pode.parseadorXML.castor.Language vLanguage)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._languageList.size()) {
            throw new IndexOutOfBoundsException("setLanguage: Index value '" + index + "' not in range [0.." + (this._languageList.size() - 1) + "]");
        }
        
        this._languageList.set(index, vLanguage);
    }

    /**
     * 
     * 
     * @param vLanguageArray
     */
    public void setLanguage(
            final es.pode.parseadorXML.castor.Language[] vLanguageArray) {
        //-- copy array
        _languageList.clear();
        
        for (int i = 0; i < vLanguageArray.length; i++) {
                this._languageList.add(vLanguageArray[i]);
        }
    }

    /**
     * Sets the value of field 'structure'.
     * 
     * @param structure the value of field 'structure'.
     */
    public void setStructure(
            final es.pode.parseadorXML.castor.Structure structure) {
        this._structure = structure;
    }

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(
            final es.pode.parseadorXML.castor.Title title) {
        this._title = title;
    }

    /**
     * Sets the value of field 'uniqueElementName'.
     * 
     * @param uniqueElementName the value of field
     * 'uniqueElementName'.
     */
    public void setUniqueElementName(
            final java.lang.String uniqueElementName) {
        this._uniqueElementName = uniqueElementName;
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
     * es.pode.parseadorXML.castor.ComplexTypeGeneral
     */
    public static es.pode.parseadorXML.castor.ComplexTypeGeneral unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeGeneral) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeGeneral.class, reader);
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
