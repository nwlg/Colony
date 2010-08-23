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
 * Class ManifestType.
 * 
 * @version $Revision$ $Date$
 */
public class ManifestType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * See http://www.w3.org/TR/xmlbase/ for
     *  information about this attribute.
     */
    private java.lang.String _base;

    /**
     * Field _identifier.
     */
    private java.lang.String _identifier;

    /**
     * Field _version.
     */
    private java.lang.String _version;

    /**
     * Field _metadata.
     */
    private es.pode.parseadorXML.castor.Metadata _metadata;

    /**
     * Field _organizations.
     */
    private es.pode.parseadorXML.castor.Organizations _organizations;

    /**
     * Field _resources.
     */
    private es.pode.parseadorXML.castor.Resources _resources;

    /**
     * Field _manifestList.
     */
    private java.util.List _manifestList;

    /**
     * Field _grp_any.
     */
    private es.pode.parseadorXML.castor.Grp_any _grp_any;


      //----------------/
     //- Constructors -/
    //----------------/

    public ManifestType() {
        super();
        this._manifestList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vManifest
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addManifest(
            final es.pode.parseadorXML.castor.Manifest vManifest)
    throws java.lang.IndexOutOfBoundsException {
        this._manifestList.add(vManifest);
    }

    /**
     * 
     * 
     * @param index
     * @param vManifest
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addManifest(
            final int index,
            final es.pode.parseadorXML.castor.Manifest vManifest)
    throws java.lang.IndexOutOfBoundsException {
        this._manifestList.add(index, vManifest);
    }

    /**
     * Method enumerateManifest.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateManifest(
    ) {
        return java.util.Collections.enumeration(this._manifestList);
    }

    /**
     * Returns the value of field 'base'. The field 'base' has the
     * following description: See http://www.w3.org/TR/xmlbase/ for
     *  information about this attribute.
     * 
     * @return the value of field 'Base'.
     */
    public java.lang.String getBase(
    ) {
        return this._base;
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
     * Method getManifest.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Manifest at the given
     * index
     */
    public es.pode.parseadorXML.castor.Manifest getManifest(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._manifestList.size()) {
            throw new IndexOutOfBoundsException("getManifest: Index value '" + index + "' not in range [0.." + (this._manifestList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Manifest) _manifestList.get(index);
    }

    /**
     * Method getManifest.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Manifest[] getManifest(
    ) {
        es.pode.parseadorXML.castor.Manifest[] array = new es.pode.parseadorXML.castor.Manifest[0];
        return (es.pode.parseadorXML.castor.Manifest[]) this._manifestList.toArray(array);
    }

    /**
     * Method getManifestCount.
     * 
     * @return the size of this collection
     */
    public int getManifestCount(
    ) {
        return this._manifestList.size();
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
     * Returns the value of field 'organizations'.
     * 
     * @return the value of field 'Organizations'.
     */
    public es.pode.parseadorXML.castor.Organizations getOrganizations(
    ) {
        return this._organizations;
    }

    /**
     * Returns the value of field 'resources'.
     * 
     * @return the value of field 'Resources'.
     */
    public es.pode.parseadorXML.castor.Resources getResources(
    ) {
        return this._resources;
    }

    /**
     * Returns the value of field 'version'.
     * 
     * @return the value of field 'Version'.
     */
    public java.lang.String getVersion(
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
     * Method iterateManifest.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateManifest(
    ) {
        return this._manifestList.iterator();
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
    public void removeAllManifest(
    ) {
        this._manifestList.clear();
    }

    /**
     * Method removeManifest.
     * 
     * @param vManifest
     * @return true if the object was removed from the collection.
     */
    public boolean removeManifest(
            final es.pode.parseadorXML.castor.Manifest vManifest) {
        boolean removed = _manifestList.remove(vManifest);
        return removed;
    }

    /**
     * Method removeManifestAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Manifest removeManifestAt(
            final int index) {
        java.lang.Object obj = this._manifestList.remove(index);
        return (es.pode.parseadorXML.castor.Manifest) obj;
    }

    /**
     * Sets the value of field 'base'. The field 'base' has the
     * following description: See http://www.w3.org/TR/xmlbase/ for
     *  information about this attribute.
     * 
     * @param base the value of field 'base'.
     */
    public void setBase(
            final java.lang.String base) {
        this._base = base;
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
     * @param vManifest
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setManifest(
            final int index,
            final es.pode.parseadorXML.castor.Manifest vManifest)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._manifestList.size()) {
            throw new IndexOutOfBoundsException("setManifest: Index value '" + index + "' not in range [0.." + (this._manifestList.size() - 1) + "]");
        }
        
        this._manifestList.set(index, vManifest);
    }

    /**
     * 
     * 
     * @param vManifestArray
     */
    public void setManifest(
            final es.pode.parseadorXML.castor.Manifest[] vManifestArray) {
        //-- copy array
        _manifestList.clear();
        
        for (int i = 0; i < vManifestArray.length; i++) {
                this._manifestList.add(vManifestArray[i]);
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
     * Sets the value of field 'organizations'.
     * 
     * @param organizations the value of field 'organizations'.
     */
    public void setOrganizations(
            final es.pode.parseadorXML.castor.Organizations organizations) {
        this._organizations = organizations;
    }

    /**
     * Sets the value of field 'resources'.
     * 
     * @param resources the value of field 'resources'.
     */
    public void setResources(
            final es.pode.parseadorXML.castor.Resources resources) {
        this._resources = resources;
    }

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(
            final java.lang.String version) {
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
     * es.pode.parseadorXML.castor.ManifestType
     */
    public static es.pode.parseadorXML.castor.ManifestType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ManifestType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ManifestType.class, reader);
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
