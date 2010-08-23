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
 * The type associated with any top-level sequencing tag
 * 
 * @version $Revision$ $Date$
 */
public class SequencingType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ID.
     */
    private java.lang.String _ID;

    /**
     * Field _IDRef.
     */
    private java.lang.Object _IDRef;

    /**
     * non-exclusive definition of acceptable control-modes
     */
    private es.pode.parseadorXML.castor.ControlMode _controlMode;

    /**
     * Field _sequencingRules.
     */
    private es.pode.parseadorXML.castor.SequencingRules _sequencingRules;

    /**
     * Field _limitConditions.
     */
    private es.pode.parseadorXML.castor.LimitConditions _limitConditions;

    /**
     * Field _auxiliaryResources.
     */
    private es.pode.parseadorXML.castor.AuxiliaryResources _auxiliaryResources;

    /**
     * Field _rollupRules.
     */
    private es.pode.parseadorXML.castor.RollupRules _rollupRules;

    /**
     * Field _objectives.
     */
    private es.pode.parseadorXML.castor.Objectives _objectives;

    /**
     * Field _randomizationControls.
     */
    private es.pode.parseadorXML.castor.RandomizationControls _randomizationControls;

    /**
     * Field _deliveryControls.
     */
    private es.pode.parseadorXML.castor.DeliveryControls _deliveryControls;

    /**
     * Field _anyObject.
     */
    private java.util.List _anyObject;


      //----------------/
     //- Constructors -/
    //----------------/

    public SequencingType() {
        super();
        this._anyObject = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAnyObject
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnyObject(
            final java.lang.Object vAnyObject)
    throws java.lang.IndexOutOfBoundsException {
        this._anyObject.add(vAnyObject);
    }

    /**
     * 
     * 
     * @param index
     * @param vAnyObject
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnyObject(
            final int index,
            final java.lang.Object vAnyObject)
    throws java.lang.IndexOutOfBoundsException {
        this._anyObject.add(index, vAnyObject);
    }

    /**
     * Method enumerateAnyObject.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAnyObject(
    ) {
        return java.util.Collections.enumeration(this._anyObject);
    }

    /**
     * Method getAnyObject.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.Object at the given index
     */
    public java.lang.Object getAnyObject(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._anyObject.size()) {
            throw new IndexOutOfBoundsException("getAnyObject: Index value '" + index + "' not in range [0.." + (this._anyObject.size() - 1) + "]");
        }
        
        return (java.lang.Object) _anyObject.get(index);
    }

    /**
     * Method getAnyObject.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.Object[] getAnyObject(
    ) {
        java.lang.Object[] array = new java.lang.Object[0];
        return (java.lang.Object[]) this._anyObject.toArray(array);
    }

    /**
     * Method getAnyObjectCount.
     * 
     * @return the size of this collection
     */
    public int getAnyObjectCount(
    ) {
        return this._anyObject.size();
    }

    /**
     * Returns the value of field 'auxiliaryResources'.
     * 
     * @return the value of field 'AuxiliaryResources'.
     */
    public es.pode.parseadorXML.castor.AuxiliaryResources getAuxiliaryResources(
    ) {
        return this._auxiliaryResources;
    }

    /**
     * Returns the value of field 'controlMode'. The field
     * 'controlMode' has the following description: non-exclusive
     * definition of acceptable control-modes
     * 
     * @return the value of field 'ControlMode'.
     */
    public es.pode.parseadorXML.castor.ControlMode getControlMode(
    ) {
        return this._controlMode;
    }

    /**
     * Returns the value of field 'deliveryControls'.
     * 
     * @return the value of field 'DeliveryControls'.
     */
    public es.pode.parseadorXML.castor.DeliveryControls getDeliveryControls(
    ) {
        return this._deliveryControls;
    }

    /**
     * Returns the value of field 'ID'.
     * 
     * @return the value of field 'ID'.
     */
    public java.lang.String getID(
    ) {
        return this._ID;
    }

    /**
     * Returns the value of field 'IDRef'.
     * 
     * @return the value of field 'IDRef'.
     */
    public java.lang.Object getIDRef(
    ) {
        return this._IDRef;
    }

    /**
     * Returns the value of field 'limitConditions'.
     * 
     * @return the value of field 'LimitConditions'.
     */
    public es.pode.parseadorXML.castor.LimitConditions getLimitConditions(
    ) {
        return this._limitConditions;
    }

    /**
     * Returns the value of field 'objectives'.
     * 
     * @return the value of field 'Objectives'.
     */
    public es.pode.parseadorXML.castor.Objectives getObjectives(
    ) {
        return this._objectives;
    }

    /**
     * Returns the value of field 'randomizationControls'.
     * 
     * @return the value of field 'RandomizationControls'.
     */
    public es.pode.parseadorXML.castor.RandomizationControls getRandomizationControls(
    ) {
        return this._randomizationControls;
    }

    /**
     * Returns the value of field 'rollupRules'.
     * 
     * @return the value of field 'RollupRules'.
     */
    public es.pode.parseadorXML.castor.RollupRules getRollupRules(
    ) {
        return this._rollupRules;
    }

    /**
     * Returns the value of field 'sequencingRules'.
     * 
     * @return the value of field 'SequencingRules'.
     */
    public es.pode.parseadorXML.castor.SequencingRules getSequencingRules(
    ) {
        return this._sequencingRules;
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
     * Method iterateAnyObject.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAnyObject(
    ) {
        return this._anyObject.iterator();
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
    public void removeAllAnyObject(
    ) {
        this._anyObject.clear();
    }

    /**
     * Method removeAnyObject.
     * 
     * @param vAnyObject
     * @return true if the object was removed from the collection.
     */
    public boolean removeAnyObject(
            final java.lang.Object vAnyObject) {
        boolean removed = _anyObject.remove(vAnyObject);
        return removed;
    }

    /**
     * Method removeAnyObjectAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.Object removeAnyObjectAt(
            final int index) {
        java.lang.Object obj = this._anyObject.remove(index);
        return (java.lang.Object) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAnyObject
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAnyObject(
            final int index,
            final java.lang.Object vAnyObject)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._anyObject.size()) {
            throw new IndexOutOfBoundsException("setAnyObject: Index value '" + index + "' not in range [0.." + (this._anyObject.size() - 1) + "]");
        }
        
        this._anyObject.set(index, vAnyObject);
    }

    /**
     * 
     * 
     * @param vAnyObjectArray
     */
    public void setAnyObject(
            final java.lang.Object[] vAnyObjectArray) {
        //-- copy array
        _anyObject.clear();
        
        for (int i = 0; i < vAnyObjectArray.length; i++) {
                this._anyObject.add(vAnyObjectArray[i]);
        }
    }

    /**
     * Sets the value of field 'auxiliaryResources'.
     * 
     * @param auxiliaryResources the value of field
     * 'auxiliaryResources'.
     */
    public void setAuxiliaryResources(
            final es.pode.parseadorXML.castor.AuxiliaryResources auxiliaryResources) {
        this._auxiliaryResources = auxiliaryResources;
    }

    /**
     * Sets the value of field 'controlMode'. The field
     * 'controlMode' has the following description: non-exclusive
     * definition of acceptable control-modes
     * 
     * @param controlMode the value of field 'controlMode'.
     */
    public void setControlMode(
            final es.pode.parseadorXML.castor.ControlMode controlMode) {
        this._controlMode = controlMode;
    }

    /**
     * Sets the value of field 'deliveryControls'.
     * 
     * @param deliveryControls the value of field 'deliveryControls'
     */
    public void setDeliveryControls(
            final es.pode.parseadorXML.castor.DeliveryControls deliveryControls) {
        this._deliveryControls = deliveryControls;
    }

    /**
     * Sets the value of field 'ID'.
     * 
     * @param ID the value of field 'ID'.
     */
    public void setID(
            final java.lang.String ID) {
        this._ID = ID;
    }

    /**
     * Sets the value of field 'IDRef'.
     * 
     * @param IDRef the value of field 'IDRef'.
     */
    public void setIDRef(
            final java.lang.Object IDRef) {
        this._IDRef = IDRef;
    }

    /**
     * Sets the value of field 'limitConditions'.
     * 
     * @param limitConditions the value of field 'limitConditions'.
     */
    public void setLimitConditions(
            final es.pode.parseadorXML.castor.LimitConditions limitConditions) {
        this._limitConditions = limitConditions;
    }

    /**
     * Sets the value of field 'objectives'.
     * 
     * @param objectives the value of field 'objectives'.
     */
    public void setObjectives(
            final es.pode.parseadorXML.castor.Objectives objectives) {
        this._objectives = objectives;
    }

    /**
     * Sets the value of field 'randomizationControls'.
     * 
     * @param randomizationControls the value of field
     * 'randomizationControls'.
     */
    public void setRandomizationControls(
            final es.pode.parseadorXML.castor.RandomizationControls randomizationControls) {
        this._randomizationControls = randomizationControls;
    }

    /**
     * Sets the value of field 'rollupRules'.
     * 
     * @param rollupRules the value of field 'rollupRules'.
     */
    public void setRollupRules(
            final es.pode.parseadorXML.castor.RollupRules rollupRules) {
        this._rollupRules = rollupRules;
    }

    /**
     * Sets the value of field 'sequencingRules'.
     * 
     * @param sequencingRules the value of field 'sequencingRules'.
     */
    public void setSequencingRules(
            final es.pode.parseadorXML.castor.SequencingRules sequencingRules) {
        this._sequencingRules = sequencingRules;
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
     * es.pode.parseadorXML.castorSequencingType
     */
    public static es.pode.parseadorXML.castor.SequencingType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.SequencingType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.SequencingType.class, reader);
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
