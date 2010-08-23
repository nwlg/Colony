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
 * Class Lom.
 * 
 * @version $Revision$ $Date$
 */
public class Lom implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _general.
     */
    private es.pode.parseadorXML.castor.General _general;

    /**
     * Field _lifeCycle.
     */
    private es.pode.parseadorXML.castor.LifeCycle _lifeCycle;

    /**
     * Field _metaMetadata.
     */
    private es.pode.parseadorXML.castor.MetaMetadata _metaMetadata;

    /**
     * Field _technical.
     */
    private es.pode.parseadorXML.castor.Technical _technical;

    /**
     * Field _educationalList.
     */
    private java.util.List _educationalList;

    /**
     * Field _rights.
     */
    private es.pode.parseadorXML.castor.Rights _rights;

    /**
     * Field _relationList.
     */
    private java.util.List _relationList;

    /**
     * Field _annotationList.
     */
    private java.util.List _annotationList;

    /**
     * Field _classificationList.
     */
    private java.util.List _classificationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Lom() {
        super();
        this._educationalList = new java.util.ArrayList();
        this._relationList = new java.util.ArrayList();
        this._annotationList = new java.util.ArrayList();
        this._classificationList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAnnotation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnnotation(
            final es.pode.parseadorXML.castor.Annotation vAnnotation)
    throws java.lang.IndexOutOfBoundsException {
        this._annotationList.add(vAnnotation);
    }

    /**
     * 
     * 
     * @param index
     * @param vAnnotation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAnnotation(
            final int index,
            final es.pode.parseadorXML.castor.Annotation vAnnotation)
    throws java.lang.IndexOutOfBoundsException {
        this._annotationList.add(index, vAnnotation);
    }

    /**
     * 
     * 
     * @param vClassification
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addClassification(
            final es.pode.parseadorXML.castor.Classification vClassification)
    throws java.lang.IndexOutOfBoundsException {
        this._classificationList.add(vClassification);
    }

    /**
     * 
     * 
     * @param index
     * @param vClassification
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addClassification(
            final int index,
            final es.pode.parseadorXML.castor.Classification vClassification)
    throws java.lang.IndexOutOfBoundsException {
        this._classificationList.add(index, vClassification);
    }

    /**
     * 
     * 
     * @param vEducational
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEducational(
            final es.pode.parseadorXML.castor.Educational vEducational)
    throws java.lang.IndexOutOfBoundsException {
        this._educationalList.add(vEducational);
    }

    /**
     * 
     * 
     * @param index
     * @param vEducational
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEducational(
            final int index,
            final es.pode.parseadorXML.castor.Educational vEducational)
    throws java.lang.IndexOutOfBoundsException {
        this._educationalList.add(index, vEducational);
    }

    /**
     * 
     * 
     * @param vRelation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRelation(
            final es.pode.parseadorXML.castor.Relation vRelation)
    throws java.lang.IndexOutOfBoundsException {
        this._relationList.add(vRelation);
    }

    /**
     * 
     * 
     * @param index
     * @param vRelation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRelation(
            final int index,
            final es.pode.parseadorXML.castor.Relation vRelation)
    throws java.lang.IndexOutOfBoundsException {
        this._relationList.add(index, vRelation);
    }

    /**
     * Method enumerateAnnotation.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAnnotation(
    ) {
        return java.util.Collections.enumeration(this._annotationList);
    }

    /**
     * Method enumerateClassification.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateClassification(
    ) {
        return java.util.Collections.enumeration(this._classificationList);
    }

    /**
     * Method enumerateEducational.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateEducational(
    ) {
        return java.util.Collections.enumeration(this._educationalList);
    }

    /**
     * Method enumerateRelation.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateRelation(
    ) {
        return java.util.Collections.enumeration(this._relationList);
    }

    /**
     * Method getAnnotation.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Annotation at the given
     * index
     */
    public es.pode.parseadorXML.castor.Annotation getAnnotation(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._annotationList.size()) {
            throw new IndexOutOfBoundsException("getAnnotation: Index value '" + index + "' not in range [0.." + (this._annotationList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Annotation) _annotationList.get(index);
    }

    /**
     * Method getAnnotation.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Annotation[] getAnnotation(
    ) {
        es.pode.parseadorXML.castor.Annotation[] array = new es.pode.parseadorXML.castor.Annotation[0];
        return (es.pode.parseadorXML.castor.Annotation[]) this._annotationList.toArray(array);
    }

    /**
     * Method getAnnotationCount.
     * 
     * @return the size of this collection
     */
    public int getAnnotationCount(
    ) {
        return this._annotationList.size();
    }

    /**
     * Method getClassification.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Classification at the
     * given index
     */
    public es.pode.parseadorXML.castor.Classification getClassification(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._classificationList.size()) {
            throw new IndexOutOfBoundsException("getClassification: Index value '" + index + "' not in range [0.." + (this._classificationList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Classification) _classificationList.get(index);
    }

    /**
     * Method getClassification.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Classification[] getClassification(
    ) {
        es.pode.parseadorXML.castor.Classification[] array = new es.pode.parseadorXML.castor.Classification[0];
        return (es.pode.parseadorXML.castor.Classification[]) this._classificationList.toArray(array);
    }

    /**
     * Method getClassificationCount.
     * 
     * @return the size of this collection
     */
    public int getClassificationCount(
    ) {
        return this._classificationList.size();
    }

    /**
     * Method getEducational.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Educational at the given
     * index
     */
    public es.pode.parseadorXML.castor.Educational getEducational(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._educationalList.size()) {
            throw new IndexOutOfBoundsException("getEducational: Index value '" + index + "' not in range [0.." + (this._educationalList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Educational) _educationalList.get(index);
    }

    /**
     * Method getEducational.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Educational[] getEducational(
    ) {
        es.pode.parseadorXML.castor.Educational[] array = new es.pode.parseadorXML.castor.Educational[0];
        return (es.pode.parseadorXML.castor.Educational[]) this._educationalList.toArray(array);
    }

    /**
     * Method getEducationalCount.
     * 
     * @return the size of this collection
     */
    public int getEducationalCount(
    ) {
        return this._educationalList.size();
    }

    /**
     * Returns the value of field 'general'.
     * 
     * @return the value of field 'General'.
     */
    public es.pode.parseadorXML.castor.General getGeneral(
    ) {
        return this._general;
    }

    /**
     * Returns the value of field 'lifeCycle'.
     * 
     * @return the value of field 'LifeCycle'.
     */
    public es.pode.parseadorXML.castor.LifeCycle getLifeCycle(
    ) {
        return this._lifeCycle;
    }

    /**
     * Returns the value of field 'metaMetadata'.
     * 
     * @return the value of field 'MetaMetadata'.
     */
    public es.pode.parseadorXML.castor.MetaMetadata getMetaMetadata(
    ) {
        return this._metaMetadata;
    }

    /**
     * Method getRelation.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Relation at the given index
     */
    public es.pode.parseadorXML.castor.Relation getRelation(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._relationList.size()) {
            throw new IndexOutOfBoundsException("getRelation: Index value '" + index + "' not in range [0.." + (this._relationList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Relation) _relationList.get(index);
    }

    /**
     * Method getRelation.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Relation[] getRelation(
    ) {
        es.pode.parseadorXML.castor.Relation[] array = new es.pode.parseadorXML.castor.Relation[0];
        return (es.pode.parseadorXML.castor.Relation[]) this._relationList.toArray(array);
    }

    /**
     * Method getRelationCount.
     * 
     * @return the size of this collection
     */
    public int getRelationCount(
    ) {
        return this._relationList.size();
    }

    /**
     * Returns the value of field 'rights'.
     * 
     * @return the value of field 'Rights'.
     */
    public es.pode.parseadorXML.castor.Rights getRights(
    ) {
        return this._rights;
    }

    /**
     * Returns the value of field 'technical'.
     * 
     * @return the value of field 'Technical'.
     */
    public es.pode.parseadorXML.castor.Technical getTechnical(
    ) {
        return this._technical;
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
     * Method iterateAnnotation.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAnnotation(
    ) {
        return this._annotationList.iterator();
    }

    /**
     * Method iterateClassification.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateClassification(
    ) {
        return this._classificationList.iterator();
    }

    /**
     * Method iterateEducational.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateEducational(
    ) {
        return this._educationalList.iterator();
    }

    /**
     * Method iterateRelation.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateRelation(
    ) {
        return this._relationList.iterator();
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
    public void removeAllAnnotation(
    ) {
        this._annotationList.clear();
    }

    /**
     */
    public void removeAllClassification(
    ) {
        this._classificationList.clear();
    }

    /**
     */
    public void removeAllEducational(
    ) {
        this._educationalList.clear();
    }

    /**
     */
    public void removeAllRelation(
    ) {
        this._relationList.clear();
    }

    /**
     * Method removeAnnotation.
     * 
     * @param vAnnotation
     * @return true if the object was removed from the collection.
     */
    public boolean removeAnnotation(
            final es.pode.parseadorXML.castor.Annotation vAnnotation) {
        boolean removed = _annotationList.remove(vAnnotation);
        return removed;
    }

    /**
     * Method removeAnnotationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Annotation removeAnnotationAt(
            final int index) {
        java.lang.Object obj = this._annotationList.remove(index);
        return (es.pode.parseadorXML.castor.Annotation) obj;
    }

    /**
     * Method removeClassification.
     * 
     * @param vClassification
     * @return true if the object was removed from the collection.
     */
    public boolean removeClassification(
            final es.pode.parseadorXML.castor.Classification vClassification) {
        boolean removed = _classificationList.remove(vClassification);
        return removed;
    }

    /**
     * Method removeClassificationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Classification removeClassificationAt(
            final int index) {
        java.lang.Object obj = this._classificationList.remove(index);
        return (es.pode.parseadorXML.castor.Classification) obj;
    }

    /**
     * Method removeEducational.
     * 
     * @param vEducational
     * @return true if the object was removed from the collection.
     */
    public boolean removeEducational(
            final es.pode.parseadorXML.castor.Educational vEducational) {
        boolean removed = _educationalList.remove(vEducational);
        return removed;
    }

    /**
     * Method removeEducationalAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Educational removeEducationalAt(
            final int index) {
        java.lang.Object obj = this._educationalList.remove(index);
        return (es.pode.parseadorXML.castor.Educational) obj;
    }

    /**
     * Method removeRelation.
     * 
     * @param vRelation
     * @return true if the object was removed from the collection.
     */
    public boolean removeRelation(
            final es.pode.parseadorXML.castor.Relation vRelation) {
        boolean removed = _relationList.remove(vRelation);
        return removed;
    }

    /**
     * Method removeRelationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Relation removeRelationAt(
            final int index) {
        java.lang.Object obj = this._relationList.remove(index);
        return (es.pode.parseadorXML.castor.Relation) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAnnotation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAnnotation(
            final int index,
            final es.pode.parseadorXML.castor.Annotation vAnnotation)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._annotationList.size()) {
            throw new IndexOutOfBoundsException("setAnnotation: Index value '" + index + "' not in range [0.." + (this._annotationList.size() - 1) + "]");
        }
        
        this._annotationList.set(index, vAnnotation);
    }

    /**
     * 
     * 
     * @param vAnnotationArray
     */
    public void setAnnotation(
            final es.pode.parseadorXML.castor.Annotation[] vAnnotationArray) {
        //-- copy array
        _annotationList.clear();
        
        for (int i = 0; i < vAnnotationArray.length; i++) {
                this._annotationList.add(vAnnotationArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vClassification
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setClassification(
            final int index,
            final es.pode.parseadorXML.castor.Classification vClassification)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._classificationList.size()) {
            throw new IndexOutOfBoundsException("setClassification: Index value '" + index + "' not in range [0.." + (this._classificationList.size() - 1) + "]");
        }
        
        this._classificationList.set(index, vClassification);
    }

    /**
     * 
     * 
     * @param vClassificationArray
     */
    public void setClassification(
            final es.pode.parseadorXML.castor.Classification[] vClassificationArray) {
        //-- copy array
        _classificationList.clear();
        
        for (int i = 0; i < vClassificationArray.length; i++) {
                this._classificationList.add(vClassificationArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vEducational
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEducational(
            final int index,
            final es.pode.parseadorXML.castor.Educational vEducational)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._educationalList.size()) {
            throw new IndexOutOfBoundsException("setEducational: Index value '" + index + "' not in range [0.." + (this._educationalList.size() - 1) + "]");
        }
        
        this._educationalList.set(index, vEducational);
    }

    /**
     * 
     * 
     * @param vEducationalArray
     */
    public void setEducational(
            final es.pode.parseadorXML.castor.Educational[] vEducationalArray) {
        //-- copy array
        _educationalList.clear();
        
        for (int i = 0; i < vEducationalArray.length; i++) {
                this._educationalList.add(vEducationalArray[i]);
        }
    }

    /**
     * Sets the value of field 'general'.
     * 
     * @param general the value of field 'general'.
     */
    public void setGeneral(
            final es.pode.parseadorXML.castor.General general) {
        this._general = general;
    }

    /**
     * Sets the value of field 'lifeCycle'.
     * 
     * @param lifeCycle the value of field 'lifeCycle'.
     */
    public void setLifeCycle(
            final es.pode.parseadorXML.castor.LifeCycle lifeCycle) {
        this._lifeCycle = lifeCycle;
    }

    /**
     * Sets the value of field 'metaMetadata'.
     * 
     * @param metaMetadata the value of field 'metaMetadata'.
     */
    public void setMetaMetadata(
            final es.pode.parseadorXML.castor.MetaMetadata metaMetadata) {
        this._metaMetadata = metaMetadata;
    }

    /**
     * 
     * 
     * @param index
     * @param vRelation
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setRelation(
            final int index,
            final es.pode.parseadorXML.castor.Relation vRelation)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._relationList.size()) {
            throw new IndexOutOfBoundsException("setRelation: Index value '" + index + "' not in range [0.." + (this._relationList.size() - 1) + "]");
        }
        
        this._relationList.set(index, vRelation);
    }

    /**
     * 
     * 
     * @param vRelationArray
     */
    public void setRelation(
            final es.pode.parseadorXML.castor.Relation[] vRelationArray) {
        //-- copy array
        _relationList.clear();
        
        for (int i = 0; i < vRelationArray.length; i++) {
                this._relationList.add(vRelationArray[i]);
        }
    }

    /**
     * Sets the value of field 'rights'.
     * 
     * @param rights the value of field 'rights'.
     */
    public void setRights(
            final es.pode.parseadorXML.castor.Rights rights) {
        this._rights = rights;
    }

    /**
     * Sets the value of field 'technical'.
     * 
     * @param technical the value of field 'technical'.
     */
    public void setTechnical(
            final es.pode.parseadorXML.castor.Technical technical) {
        this._technical = technical;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled es.pode.parseadorXML.castor.Lom
     */
    public static es.pode.parseadorXML.castor.Lom unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.Lom) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.Lom.class, reader);
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
