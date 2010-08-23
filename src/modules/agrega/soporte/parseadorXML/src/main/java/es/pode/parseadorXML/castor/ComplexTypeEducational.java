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
 * Class ComplexTypeEducational.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeEducational implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _interactivityType.
     */
    private es.pode.parseadorXML.castor.InteractivityType _interactivityType;

    /**
     * Field _learningResourceTypeList.
     */
    private java.util.List _learningResourceTypeList;

    /**
     * Field _interactivityLevel.
     */
    private es.pode.parseadorXML.castor.InteractivityLevel _interactivityLevel;

    /**
     * Field _semanticDensity.
     */
    private es.pode.parseadorXML.castor.SemanticDensity _semanticDensity;

    /**
     * Field _intendedEndUserRoleList.
     */
    private java.util.List _intendedEndUserRoleList;

    /**
     * Field _contextList.
     */
    private java.util.List _contextList;

    /**
     * Field _typicalAgeRangeList.
     */
    private java.util.List _typicalAgeRangeList;

    /**
     * Field _difficulty.
     */
    private es.pode.parseadorXML.castor.Difficulty _difficulty;

    /**
     * Field _typicalLearningTime.
     */
    private es.pode.parseadorXML.castor.TypicalLearningTime _typicalLearningTime;

    /**
     * Field _descriptionUnboundedList.
     */
    private java.util.List _descriptionUnboundedList;

    /**
     * Field _languageList.
     */
    private java.util.List _languageList;

    /**
     * Field _cognitiveProcessList.
     */
    private java.util.List _cognitiveProcessList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeEducational() {
        super();
        this._learningResourceTypeList = new java.util.ArrayList();
        this._intendedEndUserRoleList = new java.util.ArrayList();
        this._contextList = new java.util.ArrayList();
        this._typicalAgeRangeList = new java.util.ArrayList();
        this._descriptionUnboundedList = new java.util.ArrayList();
        this._languageList = new java.util.ArrayList();
        this._cognitiveProcessList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCognitiveProcess
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCognitiveProcess(
            final es.pode.parseadorXML.castor.CognitiveProcess vCognitiveProcess)
    throws java.lang.IndexOutOfBoundsException {
        this._cognitiveProcessList.add(vCognitiveProcess);
    }

    /**
     * 
     * 
     * @param index
     * @param vCognitiveProcess
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCognitiveProcess(
            final int index,
            final es.pode.parseadorXML.castor.CognitiveProcess vCognitiveProcess)
    throws java.lang.IndexOutOfBoundsException {
        this._cognitiveProcessList.add(index, vCognitiveProcess);
    }

    /**
     * 
     * 
     * @param vContext
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContext(
            final es.pode.parseadorXML.castor.Context vContext)
    throws java.lang.IndexOutOfBoundsException {
        this._contextList.add(vContext);
    }

    /**
     * 
     * 
     * @param index
     * @param vContext
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContext(
            final int index,
            final es.pode.parseadorXML.castor.Context vContext)
    throws java.lang.IndexOutOfBoundsException {
        this._contextList.add(index, vContext);
    }

    /**
     * 
     * 
     * @param vDescriptionUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDescriptionUnbounded(
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        this._descriptionUnboundedList.add(vDescriptionUnbounded);
    }

    /**
     * 
     * 
     * @param index
     * @param vDescriptionUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDescriptionUnbounded(
            final int index,
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        this._descriptionUnboundedList.add(index, vDescriptionUnbounded);
    }

    /**
     * 
     * 
     * @param vIntendedEndUserRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIntendedEndUserRole(
            final es.pode.parseadorXML.castor.IntendedEndUserRole vIntendedEndUserRole)
    throws java.lang.IndexOutOfBoundsException {
        this._intendedEndUserRoleList.add(vIntendedEndUserRole);
    }

    /**
     * 
     * 
     * @param index
     * @param vIntendedEndUserRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIntendedEndUserRole(
            final int index,
            final es.pode.parseadorXML.castor.IntendedEndUserRole vIntendedEndUserRole)
    throws java.lang.IndexOutOfBoundsException {
        this._intendedEndUserRoleList.add(index, vIntendedEndUserRole);
    }

    /**
     * 
     * 
     * @param vLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLanguage(
            final es.pode.parseadorXML.castor.Language vLanguage)
    throws java.lang.IndexOutOfBoundsException {
        this._languageList.add(vLanguage);
    }

    /**
     * 
     * 
     * @param index
     * @param vLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLanguage(
            final int index,
            final es.pode.parseadorXML.castor.Language vLanguage)
    throws java.lang.IndexOutOfBoundsException {
        this._languageList.add(index, vLanguage);
    }

    /**
     * 
     * 
     * @param vLearningResourceType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLearningResourceType(
            final es.pode.parseadorXML.castor.LearningResourceType vLearningResourceType)
    throws java.lang.IndexOutOfBoundsException {
        this._learningResourceTypeList.add(vLearningResourceType);
    }

    /**
     * 
     * 
     * @param index
     * @param vLearningResourceType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLearningResourceType(
            final int index,
            final es.pode.parseadorXML.castor.LearningResourceType vLearningResourceType)
    throws java.lang.IndexOutOfBoundsException {
        this._learningResourceTypeList.add(index, vLearningResourceType);
    }

    /**
     * 
     * 
     * @param vTypicalAgeRange
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTypicalAgeRange(
            final es.pode.parseadorXML.castor.TypicalAgeRange vTypicalAgeRange)
    throws java.lang.IndexOutOfBoundsException {
        this._typicalAgeRangeList.add(vTypicalAgeRange);
    }

    /**
     * 
     * 
     * @param index
     * @param vTypicalAgeRange
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTypicalAgeRange(
            final int index,
            final es.pode.parseadorXML.castor.TypicalAgeRange vTypicalAgeRange)
    throws java.lang.IndexOutOfBoundsException {
        this._typicalAgeRangeList.add(index, vTypicalAgeRange);
    }

    /**
     * Method enumerateCognitiveProcess.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateCognitiveProcess(
    ) {
        return java.util.Collections.enumeration(this._cognitiveProcessList);
    }

    /**
     * Method enumerateContext.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateContext(
    ) {
        return java.util.Collections.enumeration(this._contextList);
    }

    /**
     * Method enumerateDescriptionUnbounded.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateDescriptionUnbounded(
    ) {
        return java.util.Collections.enumeration(this._descriptionUnboundedList);
    }

    /**
     * Method enumerateIntendedEndUserRole.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateIntendedEndUserRole(
    ) {
        return java.util.Collections.enumeration(this._intendedEndUserRoleList);
    }

    /**
     * Method enumerateLanguage.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateLanguage(
    ) {
        return java.util.Collections.enumeration(this._languageList);
    }

    /**
     * Method enumerateLearningResourceType.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateLearningResourceType(
    ) {
        return java.util.Collections.enumeration(this._learningResourceTypeList);
    }

    /**
     * Method enumerateTypicalAgeRange.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateTypicalAgeRange(
    ) {
        return java.util.Collections.enumeration(this._typicalAgeRangeList);
    }

    /**
     * Method getCognitiveProcess.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.CognitiveProcess at the
     * given index
     */
    public es.pode.parseadorXML.castor.CognitiveProcess getCognitiveProcess(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._cognitiveProcessList.size()) {
            throw new IndexOutOfBoundsException("getCognitiveProcess: Index value '" + index + "' not in range [0.." + (this._cognitiveProcessList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.CognitiveProcess) _cognitiveProcessList.get(index);
    }

    /**
     * Method getCognitiveProcess.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.CognitiveProcess[] getCognitiveProcess(
    ) {
        es.pode.parseadorXML.castor.CognitiveProcess[] array = new es.pode.parseadorXML.castor.CognitiveProcess[0];
        return (es.pode.parseadorXML.castor.CognitiveProcess[]) this._cognitiveProcessList.toArray(array);
    }

    /**
     * Method getCognitiveProcessCount.
     * 
     * @return the size of this collection
     */
    public int getCognitiveProcessCount(
    ) {
        return this._cognitiveProcessList.size();
    }

    /**
     * Method getContext.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Context at the given index
     */
    public es.pode.parseadorXML.castor.Context getContext(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextList.size()) {
            throw new IndexOutOfBoundsException("getContext: Index value '" + index + "' not in range [0.." + (this._contextList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Context) _contextList.get(index);
    }

    /**
     * Method getContext.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Context[] getContext(
    ) {
        es.pode.parseadorXML.castor.Context[] array = new es.pode.parseadorXML.castor.Context[0];
        return (es.pode.parseadorXML.castor.Context[]) this._contextList.toArray(array);
    }

    /**
     * Method getContextCount.
     * 
     * @return the size of this collection
     */
    public int getContextCount(
    ) {
        return this._contextList.size();
    }

    /**
     * Method getDescriptionUnbounded.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.DescriptionUnbounded at
     * the given index
     */
    public es.pode.parseadorXML.castor.DescriptionUnbounded getDescriptionUnbounded(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._descriptionUnboundedList.size()) {
            throw new IndexOutOfBoundsException("getDescriptionUnbounded: Index value '" + index + "' not in range [0.." + (this._descriptionUnboundedList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.DescriptionUnbounded) _descriptionUnboundedList.get(index);
    }

    /**
     * Method getDescriptionUnbounded.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.DescriptionUnbounded[] getDescriptionUnbounded(
    ) {
        es.pode.parseadorXML.castor.DescriptionUnbounded[] array = new es.pode.parseadorXML.castor.DescriptionUnbounded[0];
        return (es.pode.parseadorXML.castor.DescriptionUnbounded[]) this._descriptionUnboundedList.toArray(array);
    }

    /**
     * Method getDescriptionUnboundedCount.
     * 
     * @return the size of this collection
     */
    public int getDescriptionUnboundedCount(
    ) {
        return this._descriptionUnboundedList.size();
    }

    /**
     * Returns the value of field 'difficulty'.
     * 
     * @return the value of field 'Difficulty'.
     */
    public es.pode.parseadorXML.castor.Difficulty getDifficulty(
    ) {
        return this._difficulty;
    }

    /**
     * Method getIntendedEndUserRole.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.IntendedEndUserRole at the
     * given index
     */
    public es.pode.parseadorXML.castor.IntendedEndUserRole getIntendedEndUserRole(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._intendedEndUserRoleList.size()) {
            throw new IndexOutOfBoundsException("getIntendedEndUserRole: Index value '" + index + "' not in range [0.." + (this._intendedEndUserRoleList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.IntendedEndUserRole) _intendedEndUserRoleList.get(index);
    }

    /**
     * Method getIntendedEndUserRole.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.IntendedEndUserRole[] getIntendedEndUserRole(
    ) {
        es.pode.parseadorXML.castor.IntendedEndUserRole[] array = new es.pode.parseadorXML.castor.IntendedEndUserRole[0];
        return (es.pode.parseadorXML.castor.IntendedEndUserRole[]) this._intendedEndUserRoleList.toArray(array);
    }

    /**
     * Method getIntendedEndUserRoleCount.
     * 
     * @return the size of this collection
     */
    public int getIntendedEndUserRoleCount(
    ) {
        return this._intendedEndUserRoleList.size();
    }

    /**
     * Returns the value of field 'interactivityLevel'.
     * 
     * @return the value of field 'InteractivityLevel'.
     */
    public es.pode.parseadorXML.castor.InteractivityLevel getInteractivityLevel(
    ) {
        return this._interactivityLevel;
    }

    /**
     * Returns the value of field 'interactivityType'.
     * 
     * @return the value of field 'InteractivityType'.
     */
    public es.pode.parseadorXML.castor.InteractivityType getInteractivityType(
    ) {
        return this._interactivityType;
    }

    /**
     * Method getLanguage.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.Language at the given index
     */
    public es.pode.parseadorXML.castor.Language getLanguage(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._languageList.size()) {
            throw new IndexOutOfBoundsException("getLanguage: Index value '" + index + "' not in range [0.." + (this._languageList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Language) _languageList.get(index);
    }

    /**
     * Method getLanguage.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Language[] getLanguage(
    ) {
        es.pode.parseadorXML.castor.Language[] array = new es.pode.parseadorXML.castor.Language[0];
        return (es.pode.parseadorXML.castor.Language[]) this._languageList.toArray(array);
    }

    /**
     * Method getLanguageCount.
     * 
     * @return the size of this collection
     */
    public int getLanguageCount(
    ) {
        return this._languageList.size();
    }

    /**
     * Method getLearningResourceType.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.LearningResourceType at
     * the given index
     */
    public es.pode.parseadorXML.castor.LearningResourceType getLearningResourceType(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._learningResourceTypeList.size()) {
            throw new IndexOutOfBoundsException("getLearningResourceType: Index value '" + index + "' not in range [0.." + (this._learningResourceTypeList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.LearningResourceType) _learningResourceTypeList.get(index);
    }

    /**
     * Method getLearningResourceType.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.LearningResourceType[] getLearningResourceType(
    ) {
        es.pode.parseadorXML.castor.LearningResourceType[] array = new es.pode.parseadorXML.castor.LearningResourceType[0];
        return (es.pode.parseadorXML.castor.LearningResourceType[]) this._learningResourceTypeList.toArray(array);
    }

    /**
     * Method getLearningResourceTypeCount.
     * 
     * @return the size of this collection
     */
    public int getLearningResourceTypeCount(
    ) {
        return this._learningResourceTypeList.size();
    }

    /**
     * Returns the value of field 'semanticDensity'.
     * 
     * @return the value of field 'SemanticDensity'.
     */
    public es.pode.parseadorXML.castor.SemanticDensity getSemanticDensity(
    ) {
        return this._semanticDensity;
    }

    /**
     * Method getTypicalAgeRange.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.TypicalAgeRange at the
     * given index
     */
    public es.pode.parseadorXML.castor.TypicalAgeRange getTypicalAgeRange(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._typicalAgeRangeList.size()) {
            throw new IndexOutOfBoundsException("getTypicalAgeRange: Index value '" + index + "' not in range [0.." + (this._typicalAgeRangeList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.TypicalAgeRange) _typicalAgeRangeList.get(index);
    }

    /**
     * Method getTypicalAgeRange.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.TypicalAgeRange[] getTypicalAgeRange(
    ) {
        es.pode.parseadorXML.castor.TypicalAgeRange[] array = new es.pode.parseadorXML.castor.TypicalAgeRange[0];
        return (es.pode.parseadorXML.castor.TypicalAgeRange[]) this._typicalAgeRangeList.toArray(array);
    }

    /**
     * Method getTypicalAgeRangeCount.
     * 
     * @return the size of this collection
     */
    public int getTypicalAgeRangeCount(
    ) {
        return this._typicalAgeRangeList.size();
    }

    /**
     * Returns the value of field 'typicalLearningTime'.
     * 
     * @return the value of field 'TypicalLearningTime'.
     */
    public es.pode.parseadorXML.castor.TypicalLearningTime getTypicalLearningTime(
    ) {
        return this._typicalLearningTime;
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
     * Method iterateCognitiveProcess.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateCognitiveProcess(
    ) {
        return this._cognitiveProcessList.iterator();
    }

    /**
     * Method iterateContext.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateContext(
    ) {
        return this._contextList.iterator();
    }

    /**
     * Method iterateDescriptionUnbounded.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateDescriptionUnbounded(
    ) {
        return this._descriptionUnboundedList.iterator();
    }

    /**
     * Method iterateIntendedEndUserRole.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateIntendedEndUserRole(
    ) {
        return this._intendedEndUserRoleList.iterator();
    }

    /**
     * Method iterateLanguage.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateLanguage(
    ) {
        return this._languageList.iterator();
    }

    /**
     * Method iterateLearningResourceType.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateLearningResourceType(
    ) {
        return this._learningResourceTypeList.iterator();
    }

    /**
     * Method iterateTypicalAgeRange.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateTypicalAgeRange(
    ) {
        return this._typicalAgeRangeList.iterator();
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
    public void removeAllCognitiveProcess(
    ) {
        this._cognitiveProcessList.clear();
    }

    /**
     */
    public void removeAllContext(
    ) {
        this._contextList.clear();
    }

    /**
     */
    public void removeAllDescriptionUnbounded(
    ) {
        this._descriptionUnboundedList.clear();
    }

    /**
     */
    public void removeAllIntendedEndUserRole(
    ) {
        this._intendedEndUserRoleList.clear();
    }

    /**
     */
    public void removeAllLanguage(
    ) {
        this._languageList.clear();
    }

    /**
     */
    public void removeAllLearningResourceType(
    ) {
        this._learningResourceTypeList.clear();
    }

    /**
     */
    public void removeAllTypicalAgeRange(
    ) {
        this._typicalAgeRangeList.clear();
    }

    /**
     * Method removeCognitiveProcess.
     * 
     * @param vCognitiveProcess
     * @return true if the object was removed from the collection.
     */
    public boolean removeCognitiveProcess(
            final es.pode.parseadorXML.castor.CognitiveProcess vCognitiveProcess) {
        boolean removed = _cognitiveProcessList.remove(vCognitiveProcess);
        return removed;
    }

    /**
     * Method removeCognitiveProcessAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.CognitiveProcess removeCognitiveProcessAt(
            final int index) {
        java.lang.Object obj = this._cognitiveProcessList.remove(index);
        return (es.pode.parseadorXML.castor.CognitiveProcess) obj;
    }

    /**
     * Method removeContext.
     * 
     * @param vContext
     * @return true if the object was removed from the collection.
     */
    public boolean removeContext(
            final es.pode.parseadorXML.castor.Context vContext) {
        boolean removed = _contextList.remove(vContext);
        return removed;
    }

    /**
     * Method removeContextAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Context removeContextAt(
            final int index) {
        java.lang.Object obj = this._contextList.remove(index);
        return (es.pode.parseadorXML.castor.Context) obj;
    }

    /**
     * Method removeDescriptionUnbounded.
     * 
     * @param vDescriptionUnbounded
     * @return true if the object was removed from the collection.
     */
    public boolean removeDescriptionUnbounded(
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded) {
        boolean removed = _descriptionUnboundedList.remove(vDescriptionUnbounded);
        return removed;
    }

    /**
     * Method removeDescriptionUnboundedAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.DescriptionUnbounded removeDescriptionUnboundedAt(
            final int index) {
        java.lang.Object obj = this._descriptionUnboundedList.remove(index);
        return (es.pode.parseadorXML.castor.DescriptionUnbounded) obj;
    }

    /**
     * Method removeIntendedEndUserRole.
     * 
     * @param vIntendedEndUserRole
     * @return true if the object was removed from the collection.
     */
    public boolean removeIntendedEndUserRole(
            final es.pode.parseadorXML.castor.IntendedEndUserRole vIntendedEndUserRole) {
        boolean removed = _intendedEndUserRoleList.remove(vIntendedEndUserRole);
        return removed;
    }

    /**
     * Method removeIntendedEndUserRoleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.IntendedEndUserRole removeIntendedEndUserRoleAt(
            final int index) {
        java.lang.Object obj = this._intendedEndUserRoleList.remove(index);
        return (es.pode.parseadorXML.castor.IntendedEndUserRole) obj;
    }

    /**
     * Method removeLanguage.
     * 
     * @param vLanguage
     * @return true if the object was removed from the collection.
     */
    public boolean removeLanguage(
            final es.pode.parseadorXML.castor.Language vLanguage) {
        boolean removed = _languageList.remove(vLanguage);
        return removed;
    }

    /**
     * Method removeLanguageAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Language removeLanguageAt(
            final int index) {
        java.lang.Object obj = this._languageList.remove(index);
        return (es.pode.parseadorXML.castor.Language) obj;
    }

    /**
     * Method removeLearningResourceType.
     * 
     * @param vLearningResourceType
     * @return true if the object was removed from the collection.
     */
    public boolean removeLearningResourceType(
            final es.pode.parseadorXML.castor.LearningResourceType vLearningResourceType) {
        boolean removed = _learningResourceTypeList.remove(vLearningResourceType);
        return removed;
    }

    /**
     * Method removeLearningResourceTypeAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.LearningResourceType removeLearningResourceTypeAt(
            final int index) {
        java.lang.Object obj = this._learningResourceTypeList.remove(index);
        return (es.pode.parseadorXML.castor.LearningResourceType) obj;
    }

    /**
     * Method removeTypicalAgeRange.
     * 
     * @param vTypicalAgeRange
     * @return true if the object was removed from the collection.
     */
    public boolean removeTypicalAgeRange(
            final es.pode.parseadorXML.castor.TypicalAgeRange vTypicalAgeRange) {
        boolean removed = _typicalAgeRangeList.remove(vTypicalAgeRange);
        return removed;
    }

    /**
     * Method removeTypicalAgeRangeAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.TypicalAgeRange removeTypicalAgeRangeAt(
            final int index) {
        java.lang.Object obj = this._typicalAgeRangeList.remove(index);
        return (es.pode.parseadorXML.castor.TypicalAgeRange) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCognitiveProcess
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCognitiveProcess(
            final int index,
            final es.pode.parseadorXML.castor.CognitiveProcess vCognitiveProcess)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._cognitiveProcessList.size()) {
            throw new IndexOutOfBoundsException("setCognitiveProcess: Index value '" + index + "' not in range [0.." + (this._cognitiveProcessList.size() - 1) + "]");
        }
        
        this._cognitiveProcessList.set(index, vCognitiveProcess);
    }

    /**
     * 
     * 
     * @param vCognitiveProcessArray
     */
    public void setCognitiveProcess(
            final es.pode.parseadorXML.castor.CognitiveProcess[] vCognitiveProcessArray) {
        //-- copy array
        _cognitiveProcessList.clear();
        
        for (int i = 0; i < vCognitiveProcessArray.length; i++) {
                this._cognitiveProcessList.add(vCognitiveProcessArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vContext
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContext(
            final int index,
            final es.pode.parseadorXML.castor.Context vContext)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextList.size()) {
            throw new IndexOutOfBoundsException("setContext: Index value '" + index + "' not in range [0.." + (this._contextList.size() - 1) + "]");
        }
        
        this._contextList.set(index, vContext);
    }

    /**
     * 
     * 
     * @param vContextArray
     */
    public void setContext(
            final es.pode.parseadorXML.castor.Context[] vContextArray) {
        //-- copy array
        _contextList.clear();
        
        for (int i = 0; i < vContextArray.length; i++) {
                this._contextList.add(vContextArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vDescriptionUnbounded
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDescriptionUnbounded(
            final int index,
            final es.pode.parseadorXML.castor.DescriptionUnbounded vDescriptionUnbounded)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._descriptionUnboundedList.size()) {
            throw new IndexOutOfBoundsException("setDescriptionUnbounded: Index value '" + index + "' not in range [0.." + (this._descriptionUnboundedList.size() - 1) + "]");
        }
        
        this._descriptionUnboundedList.set(index, vDescriptionUnbounded);
    }

    /**
     * 
     * 
     * @param vDescriptionUnboundedArray
     */
    public void setDescriptionUnbounded(
            final es.pode.parseadorXML.castor.DescriptionUnbounded[] vDescriptionUnboundedArray) {
        //-- copy array
        _descriptionUnboundedList.clear();
        
        for (int i = 0; i < vDescriptionUnboundedArray.length; i++) {
                this._descriptionUnboundedList.add(vDescriptionUnboundedArray[i]);
        }
    }

    /**
     * Sets the value of field 'difficulty'.
     * 
     * @param difficulty the value of field 'difficulty'.
     */
    public void setDifficulty(
            final es.pode.parseadorXML.castor.Difficulty difficulty) {
        this._difficulty = difficulty;
    }

    /**
     * 
     * 
     * @param index
     * @param vIntendedEndUserRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIntendedEndUserRole(
            final int index,
            final es.pode.parseadorXML.castor.IntendedEndUserRole vIntendedEndUserRole)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._intendedEndUserRoleList.size()) {
            throw new IndexOutOfBoundsException("setIntendedEndUserRole: Index value '" + index + "' not in range [0.." + (this._intendedEndUserRoleList.size() - 1) + "]");
        }
        
        this._intendedEndUserRoleList.set(index, vIntendedEndUserRole);
    }

    /**
     * 
     * 
     * @param vIntendedEndUserRoleArray
     */
    public void setIntendedEndUserRole(
            final es.pode.parseadorXML.castor.IntendedEndUserRole[] vIntendedEndUserRoleArray) {
        //-- copy array
        _intendedEndUserRoleList.clear();
        
        for (int i = 0; i < vIntendedEndUserRoleArray.length; i++) {
                this._intendedEndUserRoleList.add(vIntendedEndUserRoleArray[i]);
        }
    }

    /**
     * Sets the value of field 'interactivityLevel'.
     * 
     * @param interactivityLevel the value of field
     * 'interactivityLevel'.
     */
    public void setInteractivityLevel(
            final es.pode.parseadorXML.castor.InteractivityLevel interactivityLevel) {
        this._interactivityLevel = interactivityLevel;
    }

    /**
     * Sets the value of field 'interactivityType'.
     * 
     * @param interactivityType the value of field
     * 'interactivityType'.
     */
    public void setInteractivityType(
            final es.pode.parseadorXML.castor.InteractivityType interactivityType) {
        this._interactivityType = interactivityType;
    }

    /**
     * 
     * 
     * @param index
     * @param vLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLanguage(
            final int index,
            final es.pode.parseadorXML.castor.Language vLanguage)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._languageList.size()) {
            throw new IndexOutOfBoundsException("setLanguage: Index value '" + index + "' not in range [0.." + (this._languageList.size() - 1) + "]");
        }
        
        this._languageList.set(index, vLanguage);
    }

    /**
     * 
     * 
     * @param vLanguageArray
     */
    public void setLanguage(
            final es.pode.parseadorXML.castor.Language[] vLanguageArray) {
        //-- copy array
        _languageList.clear();
        
        for (int i = 0; i < vLanguageArray.length; i++) {
                this._languageList.add(vLanguageArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vLearningResourceType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLearningResourceType(
            final int index,
            final es.pode.parseadorXML.castor.LearningResourceType vLearningResourceType)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._learningResourceTypeList.size()) {
            throw new IndexOutOfBoundsException("setLearningResourceType: Index value '" + index + "' not in range [0.." + (this._learningResourceTypeList.size() - 1) + "]");
        }
        
        this._learningResourceTypeList.set(index, vLearningResourceType);
    }

    /**
     * 
     * 
     * @param vLearningResourceTypeArray
     */
    public void setLearningResourceType(
            final es.pode.parseadorXML.castor.LearningResourceType[] vLearningResourceTypeArray) {
        //-- copy array
        _learningResourceTypeList.clear();
        
        for (int i = 0; i < vLearningResourceTypeArray.length; i++) {
                this._learningResourceTypeList.add(vLearningResourceTypeArray[i]);
        }
    }

    /**
     * Sets the value of field 'semanticDensity'.
     * 
     * @param semanticDensity the value of field 'semanticDensity'.
     */
    public void setSemanticDensity(
            final es.pode.parseadorXML.castor.SemanticDensity semanticDensity) {
        this._semanticDensity = semanticDensity;
    }

    /**
     * 
     * 
     * @param index
     * @param vTypicalAgeRange
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTypicalAgeRange(
            final int index,
            final es.pode.parseadorXML.castor.TypicalAgeRange vTypicalAgeRange)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._typicalAgeRangeList.size()) {
            throw new IndexOutOfBoundsException("setTypicalAgeRange: Index value '" + index + "' not in range [0.." + (this._typicalAgeRangeList.size() - 1) + "]");
        }
        
        this._typicalAgeRangeList.set(index, vTypicalAgeRange);
    }

    /**
     * 
     * 
     * @param vTypicalAgeRangeArray
     */
    public void setTypicalAgeRange(
            final es.pode.parseadorXML.castor.TypicalAgeRange[] vTypicalAgeRangeArray) {
        //-- copy array
        _typicalAgeRangeList.clear();
        
        for (int i = 0; i < vTypicalAgeRangeArray.length; i++) {
                this._typicalAgeRangeList.add(vTypicalAgeRangeArray[i]);
        }
    }

    /**
     * Sets the value of field 'typicalLearningTime'.
     * 
     * @param typicalLearningTime the value of field
     * 'typicalLearningTime'.
     */
    public void setTypicalLearningTime(
            final es.pode.parseadorXML.castor.TypicalLearningTime typicalLearningTime) {
        this._typicalLearningTime = typicalLearningTime;
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
     * es.pode.parseadorXML.castor.ComplexTypeEducational
     */
    public static es.pode.parseadorXML.castor.ComplexTypeEducational unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ComplexTypeEducational) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ComplexTypeEducational.class, reader);
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
