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
 * Class ComplexTypeRights.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeRights implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uniqueElementName.
     */
    private java.lang.String _uniqueElementName = "rights";

    /**
     * Field _cost.
     */
    private es.pode.parseadorXML.castor.Cost _cost;

    /**
     * Field _copyrightAndOtherRestrictions.
     */
    private es.pode.parseadorXML.castor.CopyrightAndOtherRestrictions _copyrightAndOtherRestrictions;

    /**
     * Field _description.
     */
    private es.pode.parseadorXML.castor.Description _description;

    /**
     * Field _access.
     */
    private es.pode.parseadorXML.castor.Access _access;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeRights() {
        super();
        setUniqueElementName("rights");
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'access'.
     * 
     * @return the value of field 'Access'.
     */
    public es.pode.parseadorXML.castor.Access getAccess(
    ) {
        return this._access;
    }

    /**
     * Returns the value of field 'copyrightAndOtherRestrictions'.
     * 
     * @return the value of field 'CopyrightAndOtherRestrictions'.
     */
    public es.pode.parseadorXML.castor.CopyrightAndOtherRestrictions getCopyrightAndOtherRestrictions(
    ) {
        return this._copyrightAndOtherRestrictions;
    }

    /**
     * Returns the value of field 'cost'.
     * 
     * @return the value of field 'Cost'.
     */
    public es.pode.parseadorXML.castor.Cost getCost(
    ) {
        return this._cost;
    }

    /**
     * Returns the value of field 'description'.
     * 
     * @return the value of field 'Description'.
     */
    public es.pode.parseadorXML.castor.Description getDescription(
    ) {
        return this._description;
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
     * Sets the value of field 'access'.
     * 
     * @param access the value of field 'access'.
     */
    public void setAccess(
            final es.pode.parseadorXML.castor.Access access) {
        this._access = access;
    }

    /**
     * Sets the value of field 'copyrightAndOtherRestrictions'.
     * 
     * @param copyrightAndOtherRestrictions the value of field
     * 'copyrightAndOtherRestrictions'.
     */
    public void setCopyrightAndOtherRestrictions(
            final es.pode.parseadorXML.castor.CopyrightAndOtherRestrictions copyrightAndOtherRestrictions) {
        this._copyrightAndOtherRestrictions = copyrightAndOtherRestrictions;
    }

    /**
     * Sets the value of field 'cost'.
     * 
     * @param cost the value of field 'cost'.
     */
    public void setCost(
            final es.pode.parseadorXML.castor.Cost cost) {
        this._cost = cost;
    }

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(
            final es.pode.parseadorXML.castor.Description description) {
        this._description = description;
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
     * es.pode.parseadorXML.castor.ComplexTypeRights
     */
    public static es.pode.parseadorXML.castor.ComplexTypeRights unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeRights) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeRights.class, reader);
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
