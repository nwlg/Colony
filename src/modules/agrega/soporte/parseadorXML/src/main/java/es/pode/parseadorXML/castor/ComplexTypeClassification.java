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
 * Class ComplexTypeClassification.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeClassification implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _purpose.
     */
    private es.pode.parseadorXML.castor.Purpose _purpose;

    /**
     * Field _taxonPathList.
     */
    private java.util.List _taxonPathList;

    /**
     * Field _description.
     */
    private es.pode.parseadorXML.castor.Description _description;

    /**
     * Field _keywordList.
     */
    private java.util.List _keywordList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeClassification() {
        super();
        this._taxonPathList = new java.util.ArrayList();
        this._keywordList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * @param vTaxonPath
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTaxonPath(
            final es.pode.parseadorXML.castor.TaxonPath vTaxonPath)
    throws java.lang.IndexOutOfBoundsException {
        this._taxonPathList.add(vTaxonPath);
    }

    /**
     * 
     * 
     * @param index
     * @param vTaxonPath
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTaxonPath(
            final int index,
            final es.pode.parseadorXML.castor.TaxonPath vTaxonPath)
    throws java.lang.IndexOutOfBoundsException {
        this._taxonPathList.add(index, vTaxonPath);
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
     * Method enumerateTaxonPath.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateTaxonPath(
    ) {
        return java.util.Collections.enumeration(this._taxonPathList);
    }

    /**
     * Returns the value of field 'description'.
     * 
     * @return the value of field 'Description'.
     */
    public es.pode.parseadorXML.castor.Description getDescription(
    ) {
        return this._description;
    }

    /**
     * Method getKeyword.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.lomes.castor.Keyword at the given index
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
     * Returns the value of field 'purpose'.
     * 
     * @return the value of field 'Purpose'.
     */
    public es.pode.parseadorXML.castor.Purpose getPurpose(
    ) {
        return this._purpose;
    }

    /**
     * Method getTaxonPath.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.lomes.castor.TaxonPath at the given inde
     */
    public es.pode.parseadorXML.castor.TaxonPath getTaxonPath(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._taxonPathList.size()) {
            throw new IndexOutOfBoundsException("getTaxonPath: Index value '" + index + "' not in range [0.." + (this._taxonPathList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.TaxonPath) _taxonPathList.get(index);
    }

    /**
     * Method getTaxonPath.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.TaxonPath[] getTaxonPath(
    ) {
        es.pode.parseadorXML.castor.TaxonPath[] array = new es.pode.parseadorXML.castor.TaxonPath[0];
        return (es.pode.parseadorXML.castor.TaxonPath[]) this._taxonPathList.toArray(array);
    }

    /**
     * Method getTaxonPathCount.
     * 
     * @return the size of this collection
     */
    public int getTaxonPathCount(
    ) {
        return this._taxonPathList.size();
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
     * Method iterateTaxonPath.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateTaxonPath(
    ) {
        return this._taxonPathList.iterator();
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
    public void removeAllKeyword(
    ) {
        this._keywordList.clear();
    }

    /**
     */
    public void removeAllTaxonPath(
    ) {
        this._taxonPathList.clear();
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
     * Method removeTaxonPath.
     * 
     * @param vTaxonPath
     * @return true if the object was removed from the collection.
     */
    public boolean removeTaxonPath(
            final es.pode.parseadorXML.castor.TaxonPath vTaxonPath) {
        boolean removed = _taxonPathList.remove(vTaxonPath);
        return removed;
    }

    /**
     * Method removeTaxonPathAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.TaxonPath removeTaxonPathAt(
            final int index) {
        java.lang.Object obj = this._taxonPathList.remove(index);
        return (es.pode.parseadorXML.castor.TaxonPath) obj;
    }

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(
            final es.pode.parseadorXML.castor.Description description) {
        this._description = description;
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
     * Sets the value of field 'purpose'.
     * 
     * @param purpose the value of field 'purpose'.
     */
    public void setPurpose(
            final es.pode.parseadorXML.castor.Purpose purpose) {
        this._purpose = purpose;
    }

    /**
     * 
     * 
     * @param index
     * @param vTaxonPath
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTaxonPath(
            final int index,
            final es.pode.parseadorXML.castor.TaxonPath vTaxonPath)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._taxonPathList.size()) {
            throw new IndexOutOfBoundsException("setTaxonPath: Index value '" + index + "' not in range [0.." + (this._taxonPathList.size() - 1) + "]");
        }
        
        this._taxonPathList.set(index, vTaxonPath);
    }

    /**
     * 
     * 
     * @param vTaxonPathArray
     */
    public void setTaxonPath(
            final es.pode.parseadorXML.castor.TaxonPath[] vTaxonPathArray) {
        //-- copy array
        _taxonPathList.clear();
        
        for (int i = 0; i < vTaxonPathArray.length; i++) {
                this._taxonPathList.add(vTaxonPathArray[i]);
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
     * es.pode.parseadorXML.lomes.castor.ComplexTypeClassification
     */
    public static es.pode.parseadorXML.castor.ComplexTypeClassification unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeClassification) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeClassification.class, reader);
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
