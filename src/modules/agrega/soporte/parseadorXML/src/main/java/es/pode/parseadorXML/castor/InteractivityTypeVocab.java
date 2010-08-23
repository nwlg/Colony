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
 * Class InteractivityTypeVocab.
 * 
 * @version $Revision$ $Date$
 */
public class InteractivityTypeVocab implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _complexTypeInteractivityTypeVocabSource.
     */
    private es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabSource _complexTypeInteractivityTypeVocabSource;

    /**
     * Field _complexTypeInteractivityTypeVocabValue.
     */
    private es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabValue _complexTypeInteractivityTypeVocabValue;


      //----------------/
     //- Constructors -/
    //----------------/

    public InteractivityTypeVocab() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field
     * 'complexTypeInteractivityTypeVocabSource'.
     * 
     * @return the value of field
     * 'ComplexTypeInteractivityTypeVocabSource'.
     */
    public es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabSource getComplexTypeInteractivityTypeVocabSource(
    ) {
        return this._complexTypeInteractivityTypeVocabSource;
    }

    /**
     * Returns the value of field
     * 'complexTypeInteractivityTypeVocabValue'.
     * 
     * @return the value of field
     * 'ComplexTypeInteractivityTypeVocabValue'.
     */
    public es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabValue getComplexTypeInteractivityTypeVocabValue(
    ) {
        return this._complexTypeInteractivityTypeVocabValue;
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
     * Sets the value of field
     * 'complexTypeInteractivityTypeVocabSource'.
     * 
     * @param complexTypeInteractivityTypeVocabSource the value of
     * field 'complexTypeInteractivityTypeVocabSource'.
     */
    public void setComplexTypeInteractivityTypeVocabSource(
            final es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabSource complexTypeInteractivityTypeVocabSource) {
        this._complexTypeInteractivityTypeVocabSource = complexTypeInteractivityTypeVocabSource;
    }

    /**
     * Sets the value of field
     * 'complexTypeInteractivityTypeVocabValue'.
     * 
     * @param complexTypeInteractivityTypeVocabValue the value of
     * field 'complexTypeInteractivityTypeVocabValue'.
     */
    public void setComplexTypeInteractivityTypeVocabValue(
            final es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabValue complexTypeInteractivityTypeVocabValue) {
        this._complexTypeInteractivityTypeVocabValue = complexTypeInteractivityTypeVocabValue;
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
     * es.pode.parseadorXML.castor.InteractivityTypeVocab
     */
    public static es.pode.parseadorXML.castor.InteractivityTypeVocab unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.InteractivityTypeVocab) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.InteractivityTypeVocab.class, reader);
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
