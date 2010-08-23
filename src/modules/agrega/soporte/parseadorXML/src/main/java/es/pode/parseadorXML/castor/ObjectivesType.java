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
 * The specification states: "Each activity must have one and only
 * one objective that contributes to rollup". The following type
 * describes an unbounded set of elements all named "objective"
 * that do not contribute to rollup, and one element called
 * "primaryObjective" that contributes to rollup.
 * 
 * @version $Revision$ $Date$
 */
public class ObjectivesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Contributes to rollup of the activity. 
     */
    private es.pode.parseadorXML.castor.PrimaryObjective _primaryObjective;

    /**
     * Does not contribute to the rollup of the activity.
     */
    private java.util.List _objectiveList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectivesType() {
        super();
        this._objectiveList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vObjective
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addObjective(
            final es.pode.parseadorXML.castor.Objective vObjective)
    throws java.lang.IndexOutOfBoundsException {
        this._objectiveList.add(vObjective);
    }

    /**
     * 
     * 
     * @param index
     * @param vObjective
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addObjective(
            final int index,
            final es.pode.parseadorXML.castor.Objective vObjective)
    throws java.lang.IndexOutOfBoundsException {
        this._objectiveList.add(index, vObjective);
    }

    /**
     * Method enumerateObjective.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateObjective(
    ) {
        return java.util.Collections.enumeration(this._objectiveList);
    }

    /**
     * Method getObjective.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castorObjective at the given inde
     */
    public es.pode.parseadorXML.castor.Objective getObjective(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._objectiveList.size()) {
            throw new IndexOutOfBoundsException("getObjective: Index value '" + index + "' not in range [0.." + (this._objectiveList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Objective) _objectiveList.get(index);
    }

    /**
     * Method getObjective.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Objective[] getObjective(
    ) {
        es.pode.parseadorXML.castor.Objective[] array = new es.pode.parseadorXML.castor.Objective[0];
        return (es.pode.parseadorXML.castor.Objective[]) this._objectiveList.toArray(array);
    }

    /**
     * Method getObjectiveCount.
     * 
     * @return the size of this collection
     */
    public int getObjectiveCount(
    ) {
        return this._objectiveList.size();
    }

    /**
     * Returns the value of field 'primaryObjective'. The field
     * 'primaryObjective' has the following description:
     * Contributes to rollup of the activity. 
     * 
     * @return the value of field 'PrimaryObjective'.
     */
    public es.pode.parseadorXML.castor.PrimaryObjective getPrimaryObjective(
    ) {
        return this._primaryObjective;
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
     * Method iterateObjective.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateObjective(
    ) {
        return this._objectiveList.iterator();
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
    public void removeAllObjective(
    ) {
        this._objectiveList.clear();
    }

    /**
     * Method removeObjective.
     * 
     * @param vObjective
     * @return true if the object was removed from the collection.
     */
    public boolean removeObjective(
            final es.pode.parseadorXML.castor.Objective vObjective) {
        boolean removed = _objectiveList.remove(vObjective);
        return removed;
    }

    /**
     * Method removeObjectiveAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Objective removeObjectiveAt(
            final int index) {
        java.lang.Object obj = this._objectiveList.remove(index);
        return (es.pode.parseadorXML.castor.Objective) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vObjective
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setObjective(
            final int index,
            final es.pode.parseadorXML.castor.Objective vObjective)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._objectiveList.size()) {
            throw new IndexOutOfBoundsException("setObjective: Index value '" + index + "' not in range [0.." + (this._objectiveList.size() - 1) + "]");
        }
        
        this._objectiveList.set(index, vObjective);
    }

    /**
     * 
     * 
     * @param vObjectiveArray
     */
    public void setObjective(
            final es.pode.parseadorXML.castor.Objective[] vObjectiveArray) {
        //-- copy array
        _objectiveList.clear();
        
        for (int i = 0; i < vObjectiveArray.length; i++) {
                this._objectiveList.add(vObjectiveArray[i]);
        }
    }

    /**
     * Sets the value of field 'primaryObjective'. The field
     * 'primaryObjective' has the following description:
     * Contributes to rollup of the activity. 
     * 
     * @param primaryObjective the value of field 'primaryObjective'
     */
    public void setPrimaryObjective(
            final es.pode.parseadorXML.castor.PrimaryObjective primaryObjective) {
        this._primaryObjective = primaryObjective;
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
     * es.pode.parseadorXML.castorObjectivesType
     */
    public static es.pode.parseadorXML.castor.ObjectivesType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ObjectivesType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ObjectivesType.class, reader);
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
