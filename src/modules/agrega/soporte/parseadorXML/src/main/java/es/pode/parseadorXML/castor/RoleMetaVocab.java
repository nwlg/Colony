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
 * Class RoleMetaVocab.
 * 
 * @version $Revision$ $Date$
 */
public class RoleMetaVocab implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _complexTypeRoleMetaVocabSource.
     */
    private es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabSource _complexTypeRoleMetaVocabSource;

    /**
     * Field _complexTypeRoleMetaVocabValue.
     */
    private es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabValue _complexTypeRoleMetaVocabValue;


      //----------------/
     //- Constructors -/
    //----------------/

    public RoleMetaVocab() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'complexTypeRoleMetaVocabSource'.
     * 
     * @return the value of field 'ComplexTypeRoleMetaVocabSource'.
     */
    public es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabSource getComplexTypeRoleMetaVocabSource(
    ) {
        return this._complexTypeRoleMetaVocabSource;
    }

    /**
     * Returns the value of field 'complexTypeRoleMetaVocabValue'.
     * 
     * @return the value of field 'ComplexTypeRoleMetaVocabValue'.
     */
    public es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabValue getComplexTypeRoleMetaVocabValue(
    ) {
        return this._complexTypeRoleMetaVocabValue;
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
     * Sets the value of field 'complexTypeRoleMetaVocabSource'.
     * 
     * @param complexTypeRoleMetaVocabSource the value of field
     * 'complexTypeRoleMetaVocabSource'.
     */
    public void setComplexTypeRoleMetaVocabSource(
            final es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabSource complexTypeRoleMetaVocabSource) {
        this._complexTypeRoleMetaVocabSource = complexTypeRoleMetaVocabSource;
    }

    /**
     * Sets the value of field 'complexTypeRoleMetaVocabValue'.
     * 
     * @param complexTypeRoleMetaVocabValue the value of field
     * 'complexTypeRoleMetaVocabValue'.
     */
    public void setComplexTypeRoleMetaVocabValue(
            final es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabValue complexTypeRoleMetaVocabValue) {
        this._complexTypeRoleMetaVocabValue = complexTypeRoleMetaVocabValue;
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
     * es.pode.parseadorXML.castor.RoleMetaVocab
     */
    public static es.pode.parseadorXML.castor.RoleMetaVocab unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.RoleMetaVocab) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.RoleMetaVocab.class, reader);
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
