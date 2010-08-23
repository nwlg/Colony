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
 * Class OrganizationsType.
 * 
 * @version $Revision$ $Date$
 */
public class OrganizationsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _default.
     */
    private java.lang.String _default;

    /**
     * Field _organizationList.
     */
    private java.util.List _organizationList;

    /**
     * Field _grp_any.
     */
    private es.pode.parseadorXML.castor.Grp_any _grp_any;


      //----------------/
     //- Constructors -/
    //----------------/

    public OrganizationsType() {
        super();
        this._organizationList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOrganization
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOrganization(
            final es.pode.parseadorXML.castor.Organization vOrganization)
    throws java.lang.IndexOutOfBoundsException {
        this._organizationList.add(vOrganization);
    }

    /**
     * 
     * 
     * @param index
     * @param vOrganization
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOrganization(
            final int index,
            final es.pode.parseadorXML.castor.Organization vOrganization)
    throws java.lang.IndexOutOfBoundsException {
        this._organizationList.add(index, vOrganization);
    }

    /**
     * Method enumerateOrganization.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateOrganization(
    ) {
        return java.util.Collections.enumeration(this._organizationList);
    }

    /**
     * Returns the value of field 'default'.
     * 
     * @return the value of field 'Default'.
     */
    public java.lang.String getDefault(
    ) {
        return this._default;
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
     * Method getOrganization.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Organization at the
     * given index
     */
    public es.pode.parseadorXML.castor.Organization getOrganization(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._organizationList.size()) {
            throw new IndexOutOfBoundsException("getOrganization: Index value '" + index + "' not in range [0.." + (this._organizationList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Organization) _organizationList.get(index);
    }

    /**
     * Method getOrganization.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Organization[] getOrganization(
    ) {
        es.pode.parseadorXML.castor.Organization[] array = new es.pode.parseadorXML.castor.Organization[0];
        return (es.pode.parseadorXML.castor.Organization[]) this._organizationList.toArray(array);
    }

    /**
     * Method getOrganizationCount.
     * 
     * @return the size of this collection
     */
    public int getOrganizationCount(
    ) {
        return this._organizationList.size();
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
     * Method iterateOrganization.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateOrganization(
    ) {
        return this._organizationList.iterator();
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
    public void removeAllOrganization(
    ) {
        this._organizationList.clear();
    }

    /**
     * Method removeOrganization.
     * 
     * @param vOrganization
     * @return true if the object was removed from the collection.
     */
    public boolean removeOrganization(
            final es.pode.parseadorXML.castor.Organization vOrganization) {
        boolean removed = _organizationList.remove(vOrganization);
        return removed;
    }

    /**
     * Method removeOrganizationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Organization removeOrganizationAt(
            final int index) {
        java.lang.Object obj = this._organizationList.remove(index);
        return (es.pode.parseadorXML.castor.Organization) obj;
    }

    /**
     * Sets the value of field 'default'.
     * 
     * @param _default
     * @param default the value of field 'default'.
     */
    public void setDefault(
            final java.lang.String _default) {
        this._default = _default;
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
     * 
     * 
     * @param index
     * @param vOrganization
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOrganization(
            final int index,
            final es.pode.parseadorXML.castor.Organization vOrganization)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._organizationList.size()) {
            throw new IndexOutOfBoundsException("setOrganization: Index value '" + index + "' not in range [0.." + (this._organizationList.size() - 1) + "]");
        }
        
        this._organizationList.set(index, vOrganization);
    }

    /**
     * 
     * 
     * @param vOrganizationArray
     */
    public void setOrganization(
            final es.pode.parseadorXML.castor.Organization[] vOrganizationArray) {
        //-- copy array
        _organizationList.clear();
        
        for (int i = 0; i < vOrganizationArray.length; i++) {
                this._organizationList.add(vOrganizationArray[i]);
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
     * es.pode.parseadorXML.castor.OrganizationsType
     */
    public static es.pode.parseadorXML.castor.OrganizationsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.OrganizationsType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.OrganizationsType.class, reader);
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
