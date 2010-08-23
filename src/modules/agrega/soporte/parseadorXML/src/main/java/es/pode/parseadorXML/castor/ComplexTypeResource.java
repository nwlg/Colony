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
 * Class ComplexTypeResource.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeResource implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uniqueElementName.
     */
    private java.lang.String _uniqueElementName = "resource";

    /**
     * Field _identifier.
     */
    private es.pode.parseadorXML.castor.Identifier _identifier;

    /**
     * Field _descriptionUnboundedList.
     */
    private java.util.List _descriptionUnboundedList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeResource() {
        super();
        setUniqueElementName("resource");
        this._descriptionUnboundedList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'identifier'.
     * 
     * @return the value of field 'Identifier'.
     */
    public es.pode.parseadorXML.castor.Identifier getIdentifier(
    ) {
        return this._identifier;
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
    public void removeAllDescriptionUnbounded(
    ) {
        this._descriptionUnboundedList.clear();
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
     * Sets the value of field 'identifier'.
     * 
     * @param identifier the value of field 'identifier'.
     */
    public void setIdentifier(
            final es.pode.parseadorXML.castor.Identifier identifier) {
        this._identifier = identifier;
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
     * es.pode.parseadorXML.castor.ComplexTypeResource
     */
    public static es.pode.parseadorXML.castor.ComplexTypeResource unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeResource) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeResource.class, reader);
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
