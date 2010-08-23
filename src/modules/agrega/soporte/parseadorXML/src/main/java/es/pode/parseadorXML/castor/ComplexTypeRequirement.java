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
 * Class ComplexTypeRequirement.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeRequirement implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _orCompositeList.
     */
    private java.util.List _orCompositeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeRequirement() {
        super();
        this._orCompositeList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOrComposite
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOrComposite(
            final es.pode.parseadorXML.castor.OrComposite vOrComposite)
    throws java.lang.IndexOutOfBoundsException {
        this._orCompositeList.add(vOrComposite);
    }

    /**
     * 
     * 
     * @param index
     * @param vOrComposite
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOrComposite(
            final int index,
            final es.pode.parseadorXML.castor.OrComposite vOrComposite)
    throws java.lang.IndexOutOfBoundsException {
        this._orCompositeList.add(index, vOrComposite);
    }

    /**
     * Method enumerateOrComposite.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateOrComposite(
    ) {
        return java.util.Collections.enumeration(this._orCompositeList);
    }

    /**
     * Method getOrComposite.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.OrComposite at the given
     * index
     */
    public es.pode.parseadorXML.castor.OrComposite getOrComposite(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._orCompositeList.size()) {
            throw new IndexOutOfBoundsException("getOrComposite: Index value '" + index + "' not in range [0.." + (this._orCompositeList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.OrComposite) _orCompositeList.get(index);
    }

    /**
     * Method getOrComposite.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.OrComposite[] getOrComposite(
    ) {
        es.pode.parseadorXML.castor.OrComposite[] array = new es.pode.parseadorXML.castor.OrComposite[0];
        return (es.pode.parseadorXML.castor.OrComposite[]) this._orCompositeList.toArray(array);
    }

    /**
     * Method getOrCompositeCount.
     * 
     * @return the size of this collection
     */
    public int getOrCompositeCount(
    ) {
        return this._orCompositeList.size();
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
     * Method iterateOrComposite.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateOrComposite(
    ) {
        return this._orCompositeList.iterator();
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
    public void removeAllOrComposite(
    ) {
        this._orCompositeList.clear();
    }

    /**
     * Method removeOrComposite.
     * 
     * @param vOrComposite
     * @return true if the object was removed from the collection.
     */
    public boolean removeOrComposite(
            final es.pode.parseadorXML.castor.OrComposite vOrComposite) {
        boolean removed = _orCompositeList.remove(vOrComposite);
        return removed;
    }

    /**
     * Method removeOrCompositeAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.OrComposite removeOrCompositeAt(
            final int index) {
        java.lang.Object obj = this._orCompositeList.remove(index);
        return (es.pode.parseadorXML.castor.OrComposite) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vOrComposite
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOrComposite(
            final int index,
            final es.pode.parseadorXML.castor.OrComposite vOrComposite)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._orCompositeList.size()) {
            throw new IndexOutOfBoundsException("setOrComposite: Index value '" + index + "' not in range [0.." + (this._orCompositeList.size() - 1) + "]");
        }
        
        this._orCompositeList.set(index, vOrComposite);
    }

    /**
     * 
     * 
     * @param vOrCompositeArray
     */
    public void setOrComposite(
            final es.pode.parseadorXML.castor.OrComposite[] vOrCompositeArray) {
        //-- copy array
        _orCompositeList.clear();
        
        for (int i = 0; i < vOrCompositeArray.length; i++) {
                this._orCompositeList.add(vOrCompositeArray[i]);
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
     * es.pode.parseadorXML.castor.ComplexTypeRequirement
     */
    public static es.pode.parseadorXML.castor.ComplexTypeRequirement unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeRequirement) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeRequirement.class, reader);
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
