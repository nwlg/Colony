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
 * Class ConstrainChoiceConsiderationsType.
 * 
 * @version $Revision$ $Date$
 */
public class ConstrainChoiceConsiderationsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _preventActivation.
     */
    private boolean _preventActivation = false;

    /**
     * keeps track of state for field: _preventActivation
     */
    private boolean _has_preventActivation;

    /**
     * Field _constrainChoice.
     */
    private boolean _constrainChoice = false;

    /**
     * keeps track of state for field: _constrainChoice
     */
    private boolean _has_constrainChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConstrainChoiceConsiderationsType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteConstrainChoice(
    ) {
        this._has_constrainChoice= false;
    }

    /**
     */
    public void deletePreventActivation(
    ) {
        this._has_preventActivation= false;
    }

    /**
     * Returns the value of field 'constrainChoice'.
     * 
     * @return the value of field 'ConstrainChoice'.
     */
    public boolean getConstrainChoice(
    ) {
        return this._constrainChoice;
    }

    /**
     * Returns the value of field 'preventActivation'.
     * 
     * @return the value of field 'PreventActivation'.
     */
    public boolean getPreventActivation(
    ) {
        return this._preventActivation;
    }

    /**
     * Method hasConstrainChoice.
     * 
     * @return true if at least one ConstrainChoice has been added
     */
    public boolean hasConstrainChoice(
    ) {
        return this._has_constrainChoice;
    }

    /**
     * Method hasPreventActivation.
     * 
     * @return true if at least one PreventActivation has been added
     */
    public boolean hasPreventActivation(
    ) {
        return this._has_preventActivation;
    }

    /**
     * Returns the value of field 'constrainChoice'.
     * 
     * @return the value of field 'ConstrainChoice'.
     */
    public boolean isConstrainChoice(
    ) {
        return this._constrainChoice;
    }

    /**
     * Returns the value of field 'preventActivation'.
     * 
     * @return the value of field 'PreventActivation'.
     */
    public boolean isPreventActivation(
    ) {
        return this._preventActivation;
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
     * Sets the value of field 'constrainChoice'.
     * 
     * @param constrainChoice the value of field 'constrainChoice'.
     */
    public void setConstrainChoice(
            final boolean constrainChoice) {
        this._constrainChoice = constrainChoice;
        this._has_constrainChoice = true;
    }

    /**
     * Sets the value of field 'preventActivation'.
     * 
     * @param preventActivation the value of field
     * 'preventActivation'.
     */
    public void setPreventActivation(
            final boolean preventActivation) {
        this._preventActivation = preventActivation;
        this._has_preventActivation = true;
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
     * es.pode.parseadorXML.castor.ConstrainChoiceConsiderationsType
     */
    public static es.pode.parseadorXML.castor.ConstrainChoiceConsiderationsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ConstrainChoiceConsiderationsType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ConstrainChoiceConsiderationsType.class, reader);
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
