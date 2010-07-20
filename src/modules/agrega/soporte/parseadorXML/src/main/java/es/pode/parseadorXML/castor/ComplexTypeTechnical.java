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
 * Class ComplexTypeTechnical.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeTechnical implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uniqueElementName.
     */
    private java.lang.String _uniqueElementName = "technical";

    /**
     * Field _formatList.
     */
    private java.util.List _formatList;

    /**
     * Field _size.
     */
    private es.pode.parseadorXML.castor.Size _size;

    /**
     * Field _locationList.
     */
    private java.util.List _locationList;

    /**
     * Field _requirementList.
     */
    private java.util.List _requirementList;

    /**
     * Field _installationRemarks.
     */
    private es.pode.parseadorXML.castor.InstallationRemarks _installationRemarks;

    /**
     * Field _otherPlatformRequirements.
     */
    private es.pode.parseadorXML.castor.OtherPlatformRequirements _otherPlatformRequirements;

    /**
     * Field _duration.
     */
    private es.pode.parseadorXML.castor.Duration _duration;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeTechnical() {
        super();
        setUniqueElementName("technical");
        this._formatList = new java.util.ArrayList();
        this._locationList = new java.util.ArrayList();
        this._requirementList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vFormat
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFormat(
            final es.pode.parseadorXML.castor.Format vFormat)
    throws java.lang.IndexOutOfBoundsException {
        this._formatList.add(vFormat);
    }

    /**
     * 
     * 
     * @param index
     * @param vFormat
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFormat(
            final int index,
            final es.pode.parseadorXML.castor.Format vFormat)
    throws java.lang.IndexOutOfBoundsException {
        this._formatList.add(index, vFormat);
    }

    /**
     * 
     * 
     * @param vLocation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLocation(
            final es.pode.parseadorXML.castor.LocationLomes vLocation)
    throws java.lang.IndexOutOfBoundsException {
        this._locationList.add(vLocation);
    }

    /**
     * 
     * 
     * @param index
     * @param vLocation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLocation(
            final int index,
            final es.pode.parseadorXML.castor.LocationLomes vLocation)
    throws java.lang.IndexOutOfBoundsException {
        this._locationList.add(index, vLocation);
    }

    /**
     * 
     * 
     * @param vRequirement
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRequirement(
            final es.pode.parseadorXML.castor.Requirement vRequirement)
    throws java.lang.IndexOutOfBoundsException {
        this._requirementList.add(vRequirement);
    }

    /**
     * 
     * 
     * @param index
     * @param vRequirement
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRequirement(
            final int index,
            final es.pode.parseadorXML.castor.Requirement vRequirement)
    throws java.lang.IndexOutOfBoundsException {
        this._requirementList.add(index, vRequirement);
    }

    /**
     * Method enumerateFormat.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateFormat(
    ) {
        return java.util.Collections.enumeration(this._formatList);
    }

    /**
     * Method enumerateLocation.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateLocation(
    ) {
        return java.util.Collections.enumeration(this._locationList);
    }

    /**
     * Method enumerateRequirement.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateRequirement(
    ) {
        return java.util.Collections.enumeration(this._requirementList);
    }

    /**
     * Returns the value of field 'duration'.
     * 
     * @return the value of field 'Duration'.
     */
    public es.pode.parseadorXML.castor.Duration getDuration(
    ) {
        return this._duration;
    }

    /**
     * Method getFormat.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Format at the given index
     */
    public es.pode.parseadorXML.castor.Format getFormat(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._formatList.size()) {
            throw new IndexOutOfBoundsException("getFormat: Index value '" + index + "' not in range [0.." + (this._formatList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Format) _formatList.get(index);
    }

    /**
     * Method getFormat.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Format[] getFormat(
    ) {
        es.pode.parseadorXML.castor.Format[] array = new es.pode.parseadorXML.castor.Format[0];
        return (es.pode.parseadorXML.castor.Format[]) this._formatList.toArray(array);
    }

    /**
     * Method getFormatCount.
     * 
     * @return the size of this collection
     */
    public int getFormatCount(
    ) {
        return this._formatList.size();
    }

    /**
     * Returns the value of field 'installationRemarks'.
     * 
     * @return the value of field 'InstallationRemarks'.
     */
    public es.pode.parseadorXML.castor.InstallationRemarks getInstallationRemarks(
    ) {
        return this._installationRemarks;
    }

    /**
     * Method getLocation.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.LocationLomes at the given index
     */
    public es.pode.parseadorXML.castor.LocationLomes getLocation(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._locationList.size()) {
            throw new IndexOutOfBoundsException("getLocation: Index value '" + index + "' not in range [0.." + (this._locationList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.LocationLomes) _locationList.get(index);
    }

    /**
     * Method getLocation.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.LocationLomes[] getLocation(
    ) {
        es.pode.parseadorXML.castor.LocationLomes[] array = new es.pode.parseadorXML.castor.LocationLomes[0];
        return (es.pode.parseadorXML.castor.LocationLomes[]) this._locationList.toArray(array);
    }

    /**
     * Method getLocationCount.
     * 
     * @return the size of this collection
     */
    public int getLocationCount(
    ) {
        return this._locationList.size();
    }

    /**
     * Returns the value of field 'otherPlatformRequirements'.
     * 
     * @return the value of field 'OtherPlatformRequirements'.
     */
    public es.pode.parseadorXML.castor.OtherPlatformRequirements getOtherPlatformRequirements(
    ) {
        return this._otherPlatformRequirements;
    }

    /**
     * Method getRequirement.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Requirement at the given
     * index
     */
    public es.pode.parseadorXML.castor.Requirement getRequirement(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._requirementList.size()) {
            throw new IndexOutOfBoundsException("getRequirement: Index value '" + index + "' not in range [0.." + (this._requirementList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Requirement) _requirementList.get(index);
    }

    /**
     * Method getRequirement.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Requirement[] getRequirement(
    ) {
        es.pode.parseadorXML.castor.Requirement[] array = new es.pode.parseadorXML.castor.Requirement[0];
        return (es.pode.parseadorXML.castor.Requirement[]) this._requirementList.toArray(array);
    }

    /**
     * Method getRequirementCount.
     * 
     * @return the size of this collection
     */
    public int getRequirementCount(
    ) {
        return this._requirementList.size();
    }

    /**
     * Returns the value of field 'size'.
     * 
     * @return the value of field 'Size'.
     */
    public es.pode.parseadorXML.castor.Size getSize(
    ) {
        return this._size;
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
     * Method iterateFormat.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateFormat(
    ) {
        return this._formatList.iterator();
    }

    /**
     * Method iterateLocation.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateLocation(
    ) {
        return this._locationList.iterator();
    }

    /**
     * Method iterateRequirement.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateRequirement(
    ) {
        return this._requirementList.iterator();
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
    public void removeAllFormat(
    ) {
        this._formatList.clear();
    }

    /**
     */
    public void removeAllLocation(
    ) {
        this._locationList.clear();
    }

    /**
     */
    public void removeAllRequirement(
    ) {
        this._requirementList.clear();
    }

    /**
     * Method removeFormat.
     * 
     * @param vFormat
     * @return true if the object was removed from the collection.
     */
    public boolean removeFormat(
            final es.pode.parseadorXML.castor.Format vFormat) {
        boolean removed = _formatList.remove(vFormat);
        return removed;
    }

    /**
     * Method removeFormatAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Format removeFormatAt(
            final int index) {
        java.lang.Object obj = this._formatList.remove(index);
        return (es.pode.parseadorXML.castor.Format) obj;
    }

    /**
     * Method removeLocation.
     * 
     * @param vLocation
     * @return true if the object was removed from the collection.
     */
    public boolean removeLocation(
            final es.pode.parseadorXML.castor.LocationLomes vLocation) {
        boolean removed = _locationList.remove(vLocation);
        return removed;
    }

    /**
     * Method removeLocationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.LocationLomes removeLocationAt(
            final int index) {
        java.lang.Object obj = this._locationList.remove(index);
        return (es.pode.parseadorXML.castor.LocationLomes) obj;
    }

    /**
     * Method removeRequirement.
     * 
     * @param vRequirement
     * @return true if the object was removed from the collection.
     */
    public boolean removeRequirement(
            final es.pode.parseadorXML.castor.Requirement vRequirement) {
        boolean removed = _requirementList.remove(vRequirement);
        return removed;
    }

    /**
     * Method removeRequirementAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Requirement removeRequirementAt(
            final int index) {
        java.lang.Object obj = this._requirementList.remove(index);
        return (es.pode.parseadorXML.castor.Requirement) obj;
    }

    /**
     * Sets the value of field 'duration'.
     * 
     * @param duration the value of field 'duration'.
     */
    public void setDuration(
            final es.pode.parseadorXML.castor.Duration duration) {
        this._duration = duration;
    }

    /**
     * 
     * 
     * @param index
     * @param vFormat
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFormat(
            final int index,
            final es.pode.parseadorXML.castor.Format vFormat)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._formatList.size()) {
            throw new IndexOutOfBoundsException("setFormat: Index value '" + index + "' not in range [0.." + (this._formatList.size() - 1) + "]");
        }
        
        this._formatList.set(index, vFormat);
    }

    /**
     * 
     * 
     * @param vFormatArray
     */
    public void setFormat(
            final es.pode.parseadorXML.castor.Format[] vFormatArray) {
        //-- copy array
        _formatList.clear();
        
        for (int i = 0; i < vFormatArray.length; i++) {
                this._formatList.add(vFormatArray[i]);
        }
    }

    /**
     * Sets the value of field 'installationRemarks'.
     * 
     * @param installationRemarks the value of field
     * 'installationRemarks'.
     */
    public void setInstallationRemarks(
            final es.pode.parseadorXML.castor.InstallationRemarks installationRemarks) {
        this._installationRemarks = installationRemarks;
    }

    /**
     * 
     * 
     * @param index
     * @param vLocation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLocation(
            final int index,
            final es.pode.parseadorXML.castor.LocationLomes vLocation)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._locationList.size()) {
            throw new IndexOutOfBoundsException("setLocation: Index value '" + index + "' not in range [0.." + (this._locationList.size() - 1) + "]");
        }
        
        this._locationList.set(index, vLocation);
    }

    /**
     * 
     * 
     * @param vLocationArray
     */
    public void setLocation(
            final es.pode.parseadorXML.castor.LocationLomes[] vLocationArray) {
        //-- copy array
        _locationList.clear();
        
        for (int i = 0; i < vLocationArray.length; i++) {
                this._locationList.add(vLocationArray[i]);
        }
    }

    /**
     * Sets the value of field 'otherPlatformRequirements'.
     * 
     * @param otherPlatformRequirements the value of field
     * 'otherPlatformRequirements'.
     */
    public void setOtherPlatformRequirements(
            final es.pode.parseadorXML.castor.OtherPlatformRequirements otherPlatformRequirements) {
        this._otherPlatformRequirements = otherPlatformRequirements;
    }

    /**
     * 
     * 
     * @param index
     * @param vRequirement
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setRequirement(
            final int index,
            final es.pode.parseadorXML.castor.Requirement vRequirement)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._requirementList.size()) {
            throw new IndexOutOfBoundsException("setRequirement: Index value '" + index + "' not in range [0.." + (this._requirementList.size() - 1) + "]");
        }
        
        this._requirementList.set(index, vRequirement);
    }

    /**
     * 
     * 
     * @param vRequirementArray
     */
    public void setRequirement(
            final es.pode.parseadorXML.castor.Requirement[] vRequirementArray) {
        //-- copy array
        _requirementList.clear();
        
        for (int i = 0; i < vRequirementArray.length; i++) {
                this._requirementList.add(vRequirementArray[i]);
        }
    }

    /**
     * Sets the value of field 'size'.
     * 
     * @param size the value of field 'size'.
     */
    public void setSize(
            final es.pode.parseadorXML.castor.Size size) {
        this._size = size;
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
     * es.pode.parseadorXML.castor.ComplexTypeTechnical
     */
    public static es.pode.parseadorXML.castor.ComplexTypeTechnical unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeTechnical) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeTechnical.class, reader);
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
