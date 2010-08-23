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
 * Class ComplexTypeContribute.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeContribute implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _role.
     */
    private es.pode.parseadorXML.castor.Role _role;

    /**
     * Field _entityUnboundedList.
     */
    private java.util.List _entityUnboundedList;

    /**
     * Field _date.
     */
    private es.pode.parseadorXML.castor.Date _date;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeContribute() {
        super();
        this._entityUnboundedList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vEntityUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEntityUnbounded(
            final es.pode.parseadorXML.castor.EntityUnbounded vEntityUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        this._entityUnboundedList.add(vEntityUnbounded);
    }

    /**
     * 
     * 
     * @param index
     * @param vEntityUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEntityUnbounded(
            final int index,
            final es.pode.parseadorXML.castor.EntityUnbounded vEntityUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        this._entityUnboundedList.add(index, vEntityUnbounded);
    }

    /**
     * Method enumerateEntityUnbounded.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateEntityUnbounded(
    ) {
        return java.util.Collections.enumeration(this._entityUnboundedList);
    }

    /**
     * Returns the value of field 'date'.
     * 
     * @return the value of field 'Date'.
     */
    public es.pode.parseadorXML.castor.Date getDate(
    ) {
        return this._date;
    }

    /**
     * Method getEntityUnbounded.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.EntityUnbounded at the
     * given index
     */
    public es.pode.parseadorXML.castor.EntityUnbounded getEntityUnbounded(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._entityUnboundedList.size()) {
            throw new IndexOutOfBoundsException("getEntityUnbounded: Index value '" + index + "' not in range [0.." + (this._entityUnboundedList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.EntityUnbounded) _entityUnboundedList.get(index);
    }

    /**
     * Method getEntityUnbounded.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.EntityUnbounded[] getEntityUnbounded(
    ) {
        es.pode.parseadorXML.castor.EntityUnbounded[] array = new es.pode.parseadorXML.castor.EntityUnbounded[0];
        return (es.pode.parseadorXML.castor.EntityUnbounded[]) this._entityUnboundedList.toArray(array);
    }

    /**
     * Method getEntityUnboundedCount.
     * 
     * @return the size of this collection
     */
    public int getEntityUnboundedCount(
    ) {
        return this._entityUnboundedList.size();
    }

    /**
     * Returns the value of field 'role'.
     * 
     * @return the value of field 'Role'.
     */
    public es.pode.parseadorXML.castor.Role getRole(
    ) {
        return this._role;
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
     * Method iterateEntityUnbounded.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateEntityUnbounded(
    ) {
        return this._entityUnboundedList.iterator();
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
    public void removeAllEntityUnbounded(
    ) {
        this._entityUnboundedList.clear();
    }

    /**
     * Method removeEntityUnbounded.
     * 
     * @param vEntityUnbounded
     * @return true if the object was removed from the collection.
     */
    public boolean removeEntityUnbounded(
            final es.pode.parseadorXML.castor.EntityUnbounded vEntityUnbounded) {
        boolean removed = _entityUnboundedList.remove(vEntityUnbounded);
        return removed;
    }

    /**
     * Method removeEntityUnboundedAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.EntityUnbounded removeEntityUnboundedAt(
            final int index) {
        java.lang.Object obj = this._entityUnboundedList.remove(index);
        return (es.pode.parseadorXML.castor.EntityUnbounded) obj;
    }

    /**
     * Sets the value of field 'date'.
     * 
     * @param date the value of field 'date'.
     */
    public void setDate(
            final es.pode.parseadorXML.castor.Date date) {
        this._date = date;
    }

    /**
     * 
     * 
     * @param index
     * @param vEntityUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEntityUnbounded(
            final int index,
            final es.pode.parseadorXML.castor.EntityUnbounded vEntityUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._entityUnboundedList.size()) {
            throw new IndexOutOfBoundsException("setEntityUnbounded: Index value '" + index + "' not in range [0.." + (this._entityUnboundedList.size() - 1) + "]");
        }
        
        this._entityUnboundedList.set(index, vEntityUnbounded);
    }

    /**
     * 
     * 
     * @param vEntityUnboundedArray
     */
    public void setEntityUnbounded(
            final es.pode.parseadorXML.castor.EntityUnbounded[] vEntityUnboundedArray) {
        //-- copy array
        _entityUnboundedList.clear();
        
        for (int i = 0; i < vEntityUnboundedArray.length; i++) {
                this._entityUnboundedList.add(vEntityUnboundedArray[i]);
        }
    }

    /**
     * Sets the value of field 'role'.
     * 
     * @param role the value of field 'role'.
     */
    public void setRole(
            final es.pode.parseadorXML.castor.Role role) {
        this._role = role;
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
     * es.pode.parseadorXML.castor.ComplexTypeContribute
     */
    public static es.pode.parseadorXML.castor.ComplexTypeContribute unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeContribute) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeContribute.class, reader);
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
