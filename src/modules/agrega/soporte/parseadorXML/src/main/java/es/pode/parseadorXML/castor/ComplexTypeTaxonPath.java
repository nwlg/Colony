/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

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
 * Class ComplexTypeTaxonPath.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeTaxonPath implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _source.
     */
    private es.pode.parseadorXML.castor.Source _source;

    /**
     * Field _taxonList.
     */
    private java.util.List _taxonList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeTaxonPath() {
        super();
        this._taxonList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTaxon
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTaxon(
            final es.pode.parseadorXML.castor.Taxon vTaxon)
    throws java.lang.IndexOutOfBoundsException {
        this._taxonList.add(vTaxon);
    }

    /**
     * 
     * 
     * @param index
     * @param vTaxon
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTaxon(
            final int index,
            final es.pode.parseadorXML.castor.Taxon vTaxon)
    throws java.lang.IndexOutOfBoundsException {
        this._taxonList.add(index, vTaxon);
    }

    /**
     * Method enumerateTaxon.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateTaxon(
    ) {
        return java.util.Collections.enumeration(this._taxonList);
    }

    /**
     * Returns the value of field 'source'.
     * 
     * @return the value of field 'Source'.
     */
    public es.pode.parseadorXML.castor.Source getSource(
    ) {
        return this._source;
    }

    /**
     * Method getTaxon.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Taxon at the given index
     */
    public es.pode.parseadorXML.castor.Taxon getTaxon(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._taxonList.size()) {
            throw new IndexOutOfBoundsException("getTaxon: Index value '" + index + "' not in range [0.." + (this._taxonList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Taxon) _taxonList.get(index);
    }

    /**
     * Method getTaxon.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Taxon[] getTaxon(
    ) {
        es.pode.parseadorXML.castor.Taxon[] array = new es.pode.parseadorXML.castor.Taxon[0];
        return (es.pode.parseadorXML.castor.Taxon[]) this._taxonList.toArray(array);
    }

    /**
     * Method getTaxonCount.
     * 
     * @return the size of this collection
     */
    public int getTaxonCount(
    ) {
        return this._taxonList.size();
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
     * Method iterateTaxon.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateTaxon(
    ) {
        return this._taxonList.iterator();
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
    public void removeAllTaxon(
    ) {
        this._taxonList.clear();
    }

    /**
     * Method removeTaxon.
     * 
     * @param vTaxon
     * @return true if the object was removed from the collection.
     */
    public boolean removeTaxon(
            final es.pode.parseadorXML.castor.Taxon vTaxon) {
        boolean removed = _taxonList.remove(vTaxon);
        return removed;
    }

    /**
     * Method removeTaxonAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Taxon removeTaxonAt(
            final int index) {
        java.lang.Object obj = this._taxonList.remove(index);
        return (es.pode.parseadorXML.castor.Taxon) obj;
    }

    /**
     * Sets the value of field 'source'.
     * 
     * @param source the value of field 'source'.
     */
    public void setSource(
            final es.pode.parseadorXML.castor.Source source) {
        this._source = source;
    }

    /**
     * 
     * 
     * @param index
     * @param vTaxon
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTaxon(
            final int index,
            final es.pode.parseadorXML.castor.Taxon vTaxon)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._taxonList.size()) {
            throw new IndexOutOfBoundsException("setTaxon: Index value '" + index + "' not in range [0.." + (this._taxonList.size() - 1) + "]");
        }
        
        this._taxonList.set(index, vTaxon);
    }

    /**
     * 
     * 
     * @param vTaxonArray
     */
    public void setTaxon(
            final es.pode.parseadorXML.castor.Taxon[] vTaxonArray) {
        //-- copy array
        _taxonList.clear();
        
        for (int i = 0; i < vTaxonArray.length; i++) {
                this._taxonList.add(vTaxonArray[i]);
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
     * es.pode.parseadorXML.castor.ComplexTypeTaxonPath
     */
    public static es.pode.parseadorXML.castor.ComplexTypeTaxonPath unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeTaxonPath) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeTaxonPath.class, reader);
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
