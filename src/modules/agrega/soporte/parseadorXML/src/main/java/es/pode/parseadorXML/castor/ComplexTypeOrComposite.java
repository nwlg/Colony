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
 * Class ComplexTypeOrComposite.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeOrComposite implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _type.
     */
    private es.pode.parseadorXML.castor.Type _type;

    /**
     * Field _name.
     */
    private es.pode.parseadorXML.castor.Name _name;

    /**
     * Field _minimumVersion.
     */
    private es.pode.parseadorXML.castor.MinimumVersion _minimumVersion;

    /**
     * Field _maximumVersion.
     */
    private es.pode.parseadorXML.castor.MaximumVersion _maximumVersion;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeOrComposite() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'maximumVersion'.
     * 
     * @return the value of field 'MaximumVersion'.
     */
    public es.pode.parseadorXML.castor.MaximumVersion getMaximumVersion(
    ) {
        return this._maximumVersion;
    }

    /**
     * Returns the value of field 'minimumVersion'.
     * 
     * @return the value of field 'MinimumVersion'.
     */
    public es.pode.parseadorXML.castor.MinimumVersion getMinimumVersion(
    ) {
        return this._minimumVersion;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public es.pode.parseadorXML.castor.Name getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public es.pode.parseadorXML.castor.Type getType(
    ) {
        return this._type;
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
     * Sets the value of field 'maximumVersion'.
     * 
     * @param maximumVersion the value of field 'maximumVersion'.
     */
    public void setMaximumVersion(
            final es.pode.parseadorXML.castor.MaximumVersion maximumVersion) {
        this._maximumVersion = maximumVersion;
    }

    /**
     * Sets the value of field 'minimumVersion'.
     * 
     * @param minimumVersion the value of field 'minimumVersion'.
     */
    public void setMinimumVersion(
            final es.pode.parseadorXML.castor.MinimumVersion minimumVersion) {
        this._minimumVersion = minimumVersion;
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final es.pode.parseadorXML.castor.Name name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final es.pode.parseadorXML.castor.Type type) {
        this._type = type;
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
     * es.pode.parseadorXML.castor.ComplexTypeOrComposite
     */
    public static es.pode.parseadorXML.castor.ComplexTypeOrComposite unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeOrComposite) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeOrComposite.class, reader);
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
