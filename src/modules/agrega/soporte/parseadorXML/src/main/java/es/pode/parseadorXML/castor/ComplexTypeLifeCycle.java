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
 * Class ComplexTypeLifeCycle.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeLifeCycle implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uniqueElementName.
     */
    private java.lang.String _uniqueElementName = "lifeCycle";

    /**
     * Field _version.
     */
    private es.pode.parseadorXML.castor.Version _version;

    /**
     * Field _status.
     */
    private es.pode.parseadorXML.castor.Status _status;

    /**
     * Field _contributeList.
     */
    private java.util.List _contributeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeLifeCycle() {
        super();
        setUniqueElementName("lifeCycle");
        this._contributeList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContribute
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContribute(
            final es.pode.parseadorXML.castor.Contribute vContribute)
    throws java.lang.IndexOutOfBoundsException {
        this._contributeList.add(vContribute);
    }

    /**
     * 
     * 
     * @param index
     * @param vContribute
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContribute(
            final int index,
            final es.pode.parseadorXML.castor.Contribute vContribute)
    throws java.lang.IndexOutOfBoundsException {
        this._contributeList.add(index, vContribute);
    }

    /**
     * Method enumerateContribute.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateContribute(
    ) {
        return java.util.Collections.enumeration(this._contributeList);
    }

    /**
     * Method getContribute.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Contribute at the given
     * index
     */
    public es.pode.parseadorXML.castor.Contribute getContribute(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contributeList.size()) {
            throw new IndexOutOfBoundsException("getContribute: Index value '" + index + "' not in range [0.." + (this._contributeList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Contribute) _contributeList.get(index);
    }

    /**
     * Method getContribute.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Contribute[] getContribute(
    ) {
        es.pode.parseadorXML.castor.Contribute[] array = new es.pode.parseadorXML.castor.Contribute[0];
        return (es.pode.parseadorXML.castor.Contribute[]) this._contributeList.toArray(array);
    }

    /**
     * Method getContributeCount.
     * 
     * @return the size of this collection
     */
    public int getContributeCount(
    ) {
        return this._contributeList.size();
    }

    /**
     * Returns the value of field 'status'.
     * 
     * @return the value of field 'Status'.
     */
    public es.pode.parseadorXML.castor.Status getStatus(
    ) {
        return this._status;
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
     * Returns the value of field 'version'.
     * 
     * @return the value of field 'Version'.
     */
    public es.pode.parseadorXML.castor.Version getVersion(
    ) {
        return this._version;
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
     * Method iterateContribute.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateContribute(
    ) {
        return this._contributeList.iterator();
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
    public void removeAllContribute(
    ) {
        this._contributeList.clear();
    }

    /**
     * Method removeContribute.
     * 
     * @param vContribute
     * @return true if the object was removed from the collection.
     */
    public boolean removeContribute(
            final es.pode.parseadorXML.castor.Contribute vContribute) {
        boolean removed = _contributeList.remove(vContribute);
        return removed;
    }

    /**
     * Method removeContributeAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Contribute removeContributeAt(
            final int index) {
        java.lang.Object obj = this._contributeList.remove(index);
        return (es.pode.parseadorXML.castor.Contribute) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vContribute
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContribute(
            final int index,
            final es.pode.parseadorXML.castor.Contribute vContribute)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contributeList.size()) {
            throw new IndexOutOfBoundsException("setContribute: Index value '" + index + "' not in range [0.." + (this._contributeList.size() - 1) + "]");
        }
        
        this._contributeList.set(index, vContribute);
    }

    /**
     * 
     * 
     * @param vContributeArray
     */
    public void setContribute(
            final es.pode.parseadorXML.castor.Contribute[] vContributeArray) {
        //-- copy array
        _contributeList.clear();
        
        for (int i = 0; i < vContributeArray.length; i++) {
                this._contributeList.add(vContributeArray[i]);
        }
    }

    /**
     * Sets the value of field 'status'.
     * 
     * @param status the value of field 'status'.
     */
    public void setStatus(
            final es.pode.parseadorXML.castor.Status status) {
        this._status = status;
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
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(
            final es.pode.parseadorXML.castor.Version version) {
        this._version = version;
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
     * es.pode.parseadorXML.castor.ComplexTypeLifeCycle
     */
    public static es.pode.parseadorXML.castor.ComplexTypeLifeCycle unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeLifeCycle) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeLifeCycle.class, reader);
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
