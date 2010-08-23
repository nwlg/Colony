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
 * Class ComplexTypeMetaMetadata.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeMetaMetadata implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uniqueElementName.
     */
    private java.lang.String _uniqueElementName = "metaMetadata";

    /**
     * Field _identifierList.
     */
    private java.util.List _identifierList;

    /**
     * Field _contributeMetaList.
     */
    private java.util.List _contributeMetaList;

    /**
     * Field _metadataSchemaList.
     */
    private java.util.List _metadataSchemaList;

    /**
     * Field _language.
     */
    private es.pode.parseadorXML.castor.Language _language;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeMetaMetadata() {
        super();
        setUniqueElementName("metaMetadata");
        this._identifierList = new java.util.ArrayList();
        this._contributeMetaList = new java.util.ArrayList();
        this._metadataSchemaList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContributeMeta
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContributeMeta(
            final es.pode.parseadorXML.castor.ContributeMeta vContributeMeta)
    throws java.lang.IndexOutOfBoundsException {
        this._contributeMetaList.add(vContributeMeta);
    }

    /**
     * 
     * 
     * @param index
     * @param vContributeMeta
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContributeMeta(
            final int index,
            final es.pode.parseadorXML.castor.ContributeMeta vContributeMeta)
    throws java.lang.IndexOutOfBoundsException {
        this._contributeMetaList.add(index, vContributeMeta);
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
     * @param vMetadataSchema
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetadataSchema(
            final es.pode.parseadorXML.castor.MetadataSchema vMetadataSchema)
    throws java.lang.IndexOutOfBoundsException {
        this._metadataSchemaList.add(vMetadataSchema);
    }

    /**
     * 
     * 
     * @param index
     * @param vMetadataSchema
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetadataSchema(
            final int index,
            final es.pode.parseadorXML.castor.MetadataSchema vMetadataSchema)
    throws java.lang.IndexOutOfBoundsException {
        this._metadataSchemaList.add(index, vMetadataSchema);
    }

    /**
     * Method enumerateContributeMeta.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateContributeMeta(
    ) {
        return java.util.Collections.enumeration(this._contributeMetaList);
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
     * Method enumerateMetadataSchema.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateMetadataSchema(
    ) {
        return java.util.Collections.enumeration(this._metadataSchemaList);
    }

    /**
     * Method getContributeMeta.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.ContributeMeta at the
     * given index
     */
    public es.pode.parseadorXML.castor.ContributeMeta getContributeMeta(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contributeMetaList.size()) {
            throw new IndexOutOfBoundsException("getContributeMeta: Index value '" + index + "' not in range [0.." + (this._contributeMetaList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.ContributeMeta) _contributeMetaList.get(index);
    }

    /**
     * Method getContributeMeta.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.ContributeMeta[] getContributeMeta(
    ) {
        es.pode.parseadorXML.castor.ContributeMeta[] array = new es.pode.parseadorXML.castor.ContributeMeta[0];
        return (es.pode.parseadorXML.castor.ContributeMeta[]) this._contributeMetaList.toArray(array);
    }

    /**
     * Method getContributeMetaCount.
     * 
     * @return the size of this collection
     */
    public int getContributeMetaCount(
    ) {
        return this._contributeMetaList.size();
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
     * Returns the value of field 'language'.
     * 
     * @return the value of field 'Language'.
     */
    public es.pode.parseadorXML.castor.Language getLanguage(
    ) {
        return this._language;
    }

    /**
     * Method getMetadataSchema.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.MetadataSchema at the
     * given index
     */
    public es.pode.parseadorXML.castor.MetadataSchema getMetadataSchema(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._metadataSchemaList.size()) {
            throw new IndexOutOfBoundsException("getMetadataSchema: Index value '" + index + "' not in range [0.." + (this._metadataSchemaList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.MetadataSchema) _metadataSchemaList.get(index);
    }

    /**
     * Method getMetadataSchema.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.MetadataSchema[] getMetadataSchema(
    ) {
        es.pode.parseadorXML.castor.MetadataSchema[] array = new es.pode.parseadorXML.castor.MetadataSchema[0];
        return (es.pode.parseadorXML.castor.MetadataSchema[]) this._metadataSchemaList.toArray(array);
    }

    /**
     * Method getMetadataSchemaCount.
     * 
     * @return the size of this collection
     */
    public int getMetadataSchemaCount(
    ) {
        return this._metadataSchemaList.size();
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
     * Method iterateContributeMeta.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateContributeMeta(
    ) {
        return this._contributeMetaList.iterator();
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
     * Method iterateMetadataSchema.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateMetadataSchema(
    ) {
        return this._metadataSchemaList.iterator();
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
    public void removeAllContributeMeta(
    ) {
        this._contributeMetaList.clear();
    }

    /**
     */
    public void removeAllIdentifier(
    ) {
        this._identifierList.clear();
    }

    /**
     */
    public void removeAllMetadataSchema(
    ) {
        this._metadataSchemaList.clear();
    }

    /**
     * Method removeContributeMeta.
     * 
     * @param vContributeMeta
     * @return true if the object was removed from the collection.
     */
    public boolean removeContributeMeta(
            final es.pode.parseadorXML.castor.ContributeMeta vContributeMeta) {
        boolean removed = _contributeMetaList.remove(vContributeMeta);
        return removed;
    }

    /**
     * Method removeContributeMetaAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.ContributeMeta removeContributeMetaAt(
            final int index) {
        java.lang.Object obj = this._contributeMetaList.remove(index);
        return (es.pode.parseadorXML.castor.ContributeMeta) obj;
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
     * Method removeMetadataSchema.
     * 
     * @param vMetadataSchema
     * @return true if the object was removed from the collection.
     */
    public boolean removeMetadataSchema(
            final es.pode.parseadorXML.castor.MetadataSchema vMetadataSchema) {
        boolean removed = _metadataSchemaList.remove(vMetadataSchema);
        return removed;
    }

    /**
     * Method removeMetadataSchemaAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.MetadataSchema removeMetadataSchemaAt(
            final int index) {
        java.lang.Object obj = this._metadataSchemaList.remove(index);
        return (es.pode.parseadorXML.castor.MetadataSchema) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vContributeMeta
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContributeMeta(
            final int index,
            final es.pode.parseadorXML.castor.ContributeMeta vContributeMeta)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contributeMetaList.size()) {
            throw new IndexOutOfBoundsException("setContributeMeta: Index value '" + index + "' not in range [0.." + (this._contributeMetaList.size() - 1) + "]");
        }
        
        this._contributeMetaList.set(index, vContributeMeta);
    }

    /**
     * 
     * 
     * @param vContributeMetaArray
     */
    public void setContributeMeta(
            final es.pode.parseadorXML.castor.ContributeMeta[] vContributeMetaArray) {
        //-- copy array
        _contributeMetaList.clear();
        
        for (int i = 0; i < vContributeMetaArray.length; i++) {
                this._contributeMetaList.add(vContributeMetaArray[i]);
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
     * Sets the value of field 'language'.
     * 
     * @param language the value of field 'language'.
     */
    public void setLanguage(
            final es.pode.parseadorXML.castor.Language language) {
        this._language = language;
    }

    /**
     * 
     * 
     * @param index
     * @param vMetadataSchema
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMetadataSchema(
            final int index,
            final es.pode.parseadorXML.castor.MetadataSchema vMetadataSchema)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._metadataSchemaList.size()) {
            throw new IndexOutOfBoundsException("setMetadataSchema: Index value '" + index + "' not in range [0.." + (this._metadataSchemaList.size() - 1) + "]");
        }
        
        this._metadataSchemaList.set(index, vMetadataSchema);
    }

    /**
     * 
     * 
     * @param vMetadataSchemaArray
     */
    public void setMetadataSchema(
            final es.pode.parseadorXML.castor.MetadataSchema[] vMetadataSchemaArray) {
        //-- copy array
        _metadataSchemaList.clear();
        
        for (int i = 0; i < vMetadataSchemaArray.length; i++) {
                this._metadataSchemaList.add(vMetadataSchemaArray[i]);
        }
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
     * es.pode.parseadorXML.castor.ComplexTypeMetaMetadata
     */
    public static es.pode.parseadorXML.castor.ComplexTypeMetaMetadata unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeMetaMetadata) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeMetaMetadata.class, reader);
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
