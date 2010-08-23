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
 * Class SequencingCollection.
 * 
 * @version $Revision$ $Date$
 */
public class SequencingCollection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The root element for all sequencing tags. This tag will
     * usually appear as a child element to an IMS CP item tag.
     */
    private java.util.List _sequencingList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SequencingCollection() {
        super();
        this._sequencingList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSequencing
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSequencing(
            final es.pode.parseadorXML.castor.Sequencing vSequencing)
    throws java.lang.IndexOutOfBoundsException {
        this._sequencingList.add(vSequencing);
    }

    /**
     * 
     * 
     * @param index
     * @param vSequencing
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSequencing(
            final int index,
            final es.pode.parseadorXML.castor.Sequencing vSequencing)
    throws java.lang.IndexOutOfBoundsException {
        this._sequencingList.add(index, vSequencing);
    }

    /**
     * Method enumerateSequencing.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSequencing(
    ) {
        return java.util.Collections.enumeration(this._sequencingList);
    }

    /**
     * Method getSequencing.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorSequencing at the given
     * index
     */
    public es.pode.parseadorXML.castor.Sequencing getSequencing(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sequencingList.size()) {
            throw new IndexOutOfBoundsException("getSequencing: Index value '" + index + "' not in range [0.." + (this._sequencingList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Sequencing) _sequencingList.get(index);
    }

    /**
     * Method getSequencing.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Sequencing[] getSequencing(
    ) {
        es.pode.parseadorXML.castor.Sequencing[] array = new es.pode.parseadorXML.castor.Sequencing[0];
        return (es.pode.parseadorXML.castor.Sequencing[]) this._sequencingList.toArray(array);
    }

    /**
     * Method getSequencingCount.
     * 
     * @return the size of this collection
     */
    public int getSequencingCount(
    ) {
        return this._sequencingList.size();
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
     * Method iterateSequencing.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSequencing(
    ) {
        return this._sequencingList.iterator();
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
    public void removeAllSequencing(
    ) {
        this._sequencingList.clear();
    }

    /**
     * Method removeSequencing.
     * 
     * @param vSequencing
     * @return true if the object was removed from the collection.
     */
    public boolean removeSequencing(
            final es.pode.parseadorXML.castor.Sequencing vSequencing) {
        boolean removed = _sequencingList.remove(vSequencing);
        return removed;
    }

    /**
     * Method removeSequencingAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Sequencing removeSequencingAt(
            final int index) {
        java.lang.Object obj = this._sequencingList.remove(index);
        return (es.pode.parseadorXML.castor.Sequencing) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSequencing
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSequencing(
            final int index,
            final es.pode.parseadorXML.castor.Sequencing vSequencing)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sequencingList.size()) {
            throw new IndexOutOfBoundsException("setSequencing: Index value '" + index + "' not in range [0.." + (this._sequencingList.size() - 1) + "]");
        }
        
        this._sequencingList.set(index, vSequencing);
    }

    /**
     * 
     * 
     * @param vSequencingArray
     */
    public void setSequencing(
            final es.pode.parseadorXML.castor.Sequencing[] vSequencingArray) {
        //-- copy array
        _sequencingList.clear();
        
        for (int i = 0; i < vSequencingArray.length; i++) {
                this._sequencingList.add(vSequencingArray[i]);
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
     * es.pode.parseadorXML.castorSequencingCollection
     */
    public static es.pode.parseadorXML.castor.SequencingCollection unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.SequencingCollection) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.SequencingCollection.class, reader);
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
