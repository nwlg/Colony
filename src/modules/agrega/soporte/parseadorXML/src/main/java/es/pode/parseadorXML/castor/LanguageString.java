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
 * Class LanguageString.
 * 
 * @version $Revision$ $Date$
 */
public class LanguageString implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public LanguageString() {
        super();
        this._items = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLanguageStringItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLanguageStringItem(
            final es.pode.parseadorXML.castor.LanguageStringItem vLanguageStringItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vLanguageStringItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vLanguageStringItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLanguageStringItem(
            final int index,
            final es.pode.parseadorXML.castor.LanguageStringItem vLanguageStringItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vLanguageStringItem);
    }

    /**
     * Method enumerateLanguageStringItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateLanguageStringItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getLanguageStringItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.LanguageStringItem at the
     * given index
     */
    public es.pode.parseadorXML.castor.LanguageStringItem getLanguageStringItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getLanguageStringItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.LanguageStringItem) _items.get(index);
    }

    /**
     * Method getLanguageStringItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.LanguageStringItem[] getLanguageStringItem(
    ) {
        es.pode.parseadorXML.castor.LanguageStringItem[] array = new es.pode.parseadorXML.castor.LanguageStringItem[0];
        return (es.pode.parseadorXML.castor.LanguageStringItem[]) this._items.toArray(array);
    }

    /**
     * Method getLanguageStringItemCount.
     * 
     * @return the size of this collection
     */
    public int getLanguageStringItemCount(
    ) {
        return this._items.size();
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
     * Method iterateLanguageStringItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateLanguageStringItem(
    ) {
        return this._items.iterator();
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
    public void removeAllLanguageStringItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeLanguageStringItem.
     * 
     * @param vLanguageStringItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeLanguageStringItem(
            final es.pode.parseadorXML.castor.LanguageStringItem vLanguageStringItem) {
        boolean removed = _items.remove(vLanguageStringItem);
        return removed;
    }

    /**
     * Method removeLanguageStringItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.LanguageStringItem removeLanguageStringItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (es.pode.parseadorXML.castor.LanguageStringItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vLanguageStringItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLanguageStringItem(
            final int index,
            final es.pode.parseadorXML.castor.LanguageStringItem vLanguageStringItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setLanguageStringItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }
        
        this._items.set(index, vLanguageStringItem);
    }

    /**
     * 
     * 
     * @param vLanguageStringItemArray
     */
    public void setLanguageStringItem(
            final es.pode.parseadorXML.castor.LanguageStringItem[] vLanguageStringItemArray) {
        //-- copy array
        _items.clear();
        
        for (int i = 0; i < vLanguageStringItemArray.length; i++) {
                this._items.add(vLanguageStringItemArray[i]);
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
     * es.pode.parseadorXML.castor.LanguageString
     */
    public static es.pode.parseadorXML.castor.LanguageString unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.LanguageString) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.LanguageString.class, reader);
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
