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
 * Class OrganizationType.
 * 
 * @version $Revision$ $Date$
 */
public class OrganizationType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _identifier.
     */
    private java.lang.String _identifier;

    /**
     * Field _structure.
     */
    private java.lang.String _structure = "hierarchical";

    /**
     * Field _title.
     */
    private java.lang.String _title;

    /**
     * Field _itemList.
     */
    private java.util.List _itemList;

    /**
     * Field _metadata.
     */
    private es.pode.parseadorXML.castor.Metadata _metadata;

    /**
     * Field _grp_any.
     */
    private es.pode.parseadorXML.castor.Grp_any _grp_any;


      //----------------/
     //- Constructors -/
    //----------------/

    public OrganizationType() {
        super();
        setStructure("hierarchical");
        this._itemList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addItem(
            final es.pode.parseadorXML.castor.Item vItem)
    throws java.lang.IndexOutOfBoundsException {
        this._itemList.add(vItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addItem(
            final int index,
            final es.pode.parseadorXML.castor.Item vItem)
    throws java.lang.IndexOutOfBoundsException {
        this._itemList.add(index, vItem);
    }

    /**
     * Method enumerateItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateItem(
    ) {
        return java.util.Collections.enumeration(this._itemList);
    }

    /**
     * Returns the value of field 'grp_any'.
     * 
     * @return the value of field 'Grp_any'.
     */
    public es.pode.parseadorXML.castor.Grp_any getGrp_any(
    ) {
        return this._grp_any;
    }

    /**
     * Returns the value of field 'identifier'.
     * 
     * @return the value of field 'Identifier'.
     */
    public java.lang.String getIdentifier(
    ) {
        return this._identifier;
    }

    /**
     * Method getItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Item at the given index
     */
    public es.pode.parseadorXML.castor.Item getItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._itemList.size()) {
            throw new IndexOutOfBoundsException("getItem: Index value '" + index + "' not in range [0.." + (this._itemList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Item) _itemList.get(index);
    }

    /**
     * Method getItem.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Item[] getItem(
    ) {
        es.pode.parseadorXML.castor.Item[] array = new es.pode.parseadorXML.castor.Item[0];
        return (es.pode.parseadorXML.castor.Item[]) this._itemList.toArray(array);
    }

    /**
     * Method getItemCount.
     * 
     * @return the size of this collection
     */
    public int getItemCount(
    ) {
        return this._itemList.size();
    }

    /**
     * Returns the value of field 'metadata'.
     * 
     * @return the value of field 'Metadata'.
     */
    public es.pode.parseadorXML.castor.Metadata getMetadata(
    ) {
        return this._metadata;
    }

    /**
     * Returns the value of field 'structure'.
     * 
     * @return the value of field 'Structure'.
     */
    public java.lang.String getStructure(
    ) {
        return this._structure;
    }

    /**
     * Returns the value of field 'title'.
     * 
     * @return the value of field 'Title'.
     */
    public java.lang.String getTitle(
    ) {
        return this._title;
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
     * Method iterateItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateItem(
    ) {
        return this._itemList.iterator();
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
    public void removeAllItem(
    ) {
        this._itemList.clear();
    }

    /**
     * Method removeItem.
     * 
     * @param vItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeItem(
            final es.pode.parseadorXML.castor.Item vItem) {
        boolean removed = _itemList.remove(vItem);
        return removed;
    }

    /**
     * Method removeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Item removeItemAt(
            final int index) {
        java.lang.Object obj = this._itemList.remove(index);
        return (es.pode.parseadorXML.castor.Item) obj;
    }

    /**
     * Sets the value of field 'grp_any'.
     * 
     * @param grp_any the value of field 'grp_any'.
     */
    public void setGrp_any(
            final es.pode.parseadorXML.castor.Grp_any grp_any) {
        this._grp_any = grp_any;
    }

    /**
     * Sets the value of field 'identifier'.
     * 
     * @param identifier the value of field 'identifier'.
     */
    public void setIdentifier(
            final java.lang.String identifier) {
        this._identifier = identifier;
    }

    /**
     * 
     * 
     * @param index
     * @param vItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setItem(
            final int index,
            final es.pode.parseadorXML.castor.Item vItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._itemList.size()) {
            throw new IndexOutOfBoundsException("setItem: Index value '" + index + "' not in range [0.." + (this._itemList.size() - 1) + "]");
        }
        
        this._itemList.set(index, vItem);
    }

    /**
     * 
     * 
     * @param vItemArray
     */
    public void setItem(
            final es.pode.parseadorXML.castor.Item[] vItemArray) {
        //-- copy array
        _itemList.clear();
        
        for (int i = 0; i < vItemArray.length; i++) {
                this._itemList.add(vItemArray[i]);
        }
    }

    /**
     * Sets the value of field 'metadata'.
     * 
     * @param metadata the value of field 'metadata'.
     */
    public void setMetadata(
            final es.pode.parseadorXML.castor.Metadata metadata) {
        this._metadata = metadata;
    }

    /**
     * Sets the value of field 'structure'.
     * 
     * @param structure the value of field 'structure'.
     */
    public void setStructure(
            final java.lang.String structure) {
        this._structure = structure;
    }

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(
            final java.lang.String title) {
        this._title = title;
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
     * es.pode.parseadorXML.castor.OrganizationType
     */
    public static es.pode.parseadorXML.castor.OrganizationType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.OrganizationType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.OrganizationType.class, reader);
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
