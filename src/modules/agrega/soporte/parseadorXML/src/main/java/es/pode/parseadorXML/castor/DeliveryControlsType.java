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
 * The type that describes any element which fullfills a delivery
 * control semantic
 * 
 * @version $Revision$ $Date$
 */
public class DeliveryControlsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tracked.
     */
    private boolean _tracked = true;

    /**
     * keeps track of state for field: _tracked
     */
    private boolean _has_tracked;

    /**
     * Field _completionSetByContent.
     */
    private boolean _completionSetByContent = false;

    /**
     * keeps track of state for field: _completionSetByContent
     */
    private boolean _has_completionSetByContent;

    /**
     * Field _objectiveSetByContent.
     */
    private boolean _objectiveSetByContent = false;

    /**
     * keeps track of state for field: _objectiveSetByContent
     */
    private boolean _has_objectiveSetByContent;


      //----------------/
     //- Constructors -/
    //----------------/

    public DeliveryControlsType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    
    /*
	 * Metodos get y set de los atributos _has_XXXX usados por Dozer para los
	 * mapeos
	 * 
	 * fjespino
	 */
    public boolean getHasTracked() {
    	return this._has_tracked;
    }
    
    public void setHasTracked(boolean value) {
    	this._has_tracked=value;
    }
    
    public boolean getHasCompletionSetByContent() {
    	return this._has_completionSetByContent;
    }
    
    public void setHasCompletionSetByContent(boolean value) {
    	this._has_completionSetByContent=value;
    }
    
    public boolean getHasObjectiveSetByContent() {
    	return this._has_objectiveSetByContent;
    }
    
    public void setHasObjectiveSetByContent(boolean value) {
    	this._has_objectiveSetByContent=value;
    }
    
    
    
    /**
     */
    public void deleteCompletionSetByContent(
    ) {
        this._has_completionSetByContent= false;
    }

    /**
     */
    public void deleteObjectiveSetByContent(
    ) {
        this._has_objectiveSetByContent= false;
    }

    /**
     */
    public void deleteTracked(
    ) {
        this._has_tracked= false;
    }

    /**
     * Returns the value of field 'completionSetByContent'.
     * 
     * @return the value of field 'CompletionSetByContent'.
     */
    public boolean getCompletionSetByContent(
    ) {
        return this._completionSetByContent;
    }

    /**
     * Returns the value of field 'objectiveSetByContent'.
     * 
     * @return the value of field 'ObjectiveSetByContent'.
     */
    public boolean getObjectiveSetByContent(
    ) {
        return this._objectiveSetByContent;
    }

    /**
     * Returns the value of field 'tracked'.
     * 
     * @return the value of field 'Tracked'.
     */
    public boolean getTracked(
    ) {
        return this._tracked;
    }

    /**
     * Method hasCompletionSetByContent.
     * 
     * @return true if at least one CompletionSetByContent has been
     * added
     */
    public boolean hasCompletionSetByContent(
    ) {
        return this._has_completionSetByContent;
    }

    /**
     * Method hasObjectiveSetByContent.
     * 
     * @return true if at least one ObjectiveSetByContent has been
     * added
     */
    public boolean hasObjectiveSetByContent(
    ) {
        return this._has_objectiveSetByContent;
    }

    /**
     * Method hasTracked.
     * 
     * @return true if at least one Tracked has been added
     */
    public boolean hasTracked(
    ) {
        return this._has_tracked;
    }

    /**
     * Returns the value of field 'completionSetByContent'.
     * 
     * @return the value of field 'CompletionSetByContent'.
     */
    public boolean isCompletionSetByContent(
    ) {
        return this._completionSetByContent;
    }

    /**
     * Returns the value of field 'objectiveSetByContent'.
     * 
     * @return the value of field 'ObjectiveSetByContent'.
     */
    public boolean isObjectiveSetByContent(
    ) {
        return this._objectiveSetByContent;
    }

    /**
     * Returns the value of field 'tracked'.
     * 
     * @return the value of field 'Tracked'.
     */
    public boolean isTracked(
    ) {
        return this._tracked;
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
     * Sets the value of field 'completionSetByContent'.
     * 
     * @param completionSetByContent the value of field
     * 'completionSetByContent'.
     */
    public void setCompletionSetByContent(
            final boolean completionSetByContent) {
        this._completionSetByContent = completionSetByContent;
        this._has_completionSetByContent = true;
    }
    
    public void setCompletionSetByContentMapped(
            final boolean completionSetByContent) {
        this._completionSetByContent = completionSetByContent;
    }

    /**
     * Sets the value of field 'objectiveSetByContent'.
     * 
     * @param objectiveSetByContent the value of field
     * 'objectiveSetByContent'.
     */
    public void setObjectiveSetByContent(
            final boolean objectiveSetByContent) {
        this._objectiveSetByContent = objectiveSetByContent;
        this._has_objectiveSetByContent = true;
    }
    
    public void setObjectiveSetByContentMapped(
            final boolean objectiveSetByContent) {
        this._objectiveSetByContent = objectiveSetByContent;
     
    }

    /**
     * Sets the value of field 'tracked'.
     * 
     * @param tracked the value of field 'tracked'.
     */
    public void setTracked(
            final boolean tracked) {
        this._tracked = tracked;
        this._has_tracked = true;
    }
    
    public void setTrackedMapped(
            final boolean tracked) {
        this._tracked = tracked;
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
     * es.pode.parseadorXML.DeliveryControlsType
     */
    public static es.pode.parseadorXML.castor.DeliveryControlsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.DeliveryControlsType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.DeliveryControlsType.class, reader);
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
