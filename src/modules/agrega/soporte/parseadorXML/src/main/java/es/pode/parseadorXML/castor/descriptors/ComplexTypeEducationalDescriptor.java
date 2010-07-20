/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.castor.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import es.pode.parseadorXML.castor.ComplexTypeEducational;

/**
 * Class ComplexTypeEducationalDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ComplexTypeEducationalDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _elementDefinition.
     */
    private boolean _elementDefinition;

    /**
     * Field _nsPrefix.
     */
    private java.lang.String _nsPrefix;

    /**
     * Field _nsURI.
     */
    private java.lang.String _nsURI;

    /**
     * Field _xmlName.
     */
    private java.lang.String _xmlName;

    /**
     * Field _identity.
     */
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComplexTypeEducationalDescriptor() {
        super();
        _nsURI = "http://ltsc.ieee.org/xsd/LOM";
        _xmlName = "educational";
        _elementDefinition = false;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _interactivityType
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.InteractivityType.class, "_interactivityType", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getInteractivityType();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.setInteractivityType( (es.pode.parseadorXML.castor.InteractivityType) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.InteractivityType();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.InteractivityTypeDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _interactivityType
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _learningResourceTypeList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.LearningResourceType.class, "_learningResourceTypeList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getLearningResourceType();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addLearningResourceType( (es.pode.parseadorXML.castor.LearningResourceType) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllLearningResourceType();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.LearningResourceType();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.LearningResourceTypeDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _learningResourceTypeList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _interactivityLevel
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.InteractivityLevel.class, "_interactivityLevel", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getInteractivityLevel();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.setInteractivityLevel( (es.pode.parseadorXML.castor.InteractivityLevel) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.InteractivityLevel();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.InteractivityLevelDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _interactivityLevel
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _semanticDensity
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.SemanticDensity.class, "_semanticDensity", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getSemanticDensity();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.setSemanticDensity( (es.pode.parseadorXML.castor.SemanticDensity) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.SemanticDensity();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.SemanticDensityDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _semanticDensity
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _intendedEndUserRoleList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.IntendedEndUserRole.class, "_intendedEndUserRoleList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getIntendedEndUserRole();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addIntendedEndUserRole( (es.pode.parseadorXML.castor.IntendedEndUserRole) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllIntendedEndUserRole();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.IntendedEndUserRole();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.IntendedEndUserRoleDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _intendedEndUserRoleList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _contextList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.Context.class, "_contextList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getContext();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addContext( (es.pode.parseadorXML.castor.Context) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllContext();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.Context();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.ContextDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _contextList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _typicalAgeRangeList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.TypicalAgeRange.class, "_typicalAgeRangeList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getTypicalAgeRange();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addTypicalAgeRange( (es.pode.parseadorXML.castor.TypicalAgeRange) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllTypicalAgeRange();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.TypicalAgeRange();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.TypicalAgeRangeDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _typicalAgeRangeList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _difficulty
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.Difficulty.class, "_difficulty", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getDifficulty();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.setDifficulty( (es.pode.parseadorXML.castor.Difficulty) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.Difficulty();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.DifficultyDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _difficulty
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _typicalLearningTime
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.TypicalLearningTime.class, "_typicalLearningTime", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getTypicalLearningTime();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.setTypicalLearningTime( (es.pode.parseadorXML.castor.TypicalLearningTime) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.TypicalLearningTime();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.TypicalLearningTimeDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _typicalLearningTime
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _descriptionUnboundedList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.DescriptionUnbounded.class, "_descriptionUnboundedList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getDescriptionUnbounded();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addDescriptionUnbounded( (es.pode.parseadorXML.castor.DescriptionUnbounded) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllDescriptionUnbounded();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.DescriptionUnbounded();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.DescriptionUnboundedDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _descriptionUnboundedList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _languageList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.Language.class, "_languageList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getLanguage();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addLanguage( (es.pode.parseadorXML.castor.Language) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllLanguage();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.Language();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.LanguageDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _languageList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _cognitiveProcessList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.CognitiveProcess.class, "_cognitiveProcessList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ComplexTypeEducational target = (ComplexTypeEducational) object;
                return target.getCognitiveProcess();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.addCognitiveProcess( (es.pode.parseadorXML.castor.CognitiveProcess) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ComplexTypeEducational target = (ComplexTypeEducational) object;
                    target.removeAllCognitiveProcess();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.CognitiveProcess();
            }
        };
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new es.pode.parseadorXML.castor.descriptors.CognitiveProcessDescriptor());
        desc.setNameSpaceURI("http://ltsc.ieee.org/xsd/LOM");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _cognitiveProcessList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode.
     * 
     * @return the access mode specified for this class.
     */
    public org.exolab.castor.mapping.AccessMode getAccessMode(
    ) {
        return null;
    }

    /**
     * Method getIdentity.
     * 
     * @return the identity field, null if this class has no
     * identity.
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity(
    ) {
        return _identity;
    }

    /**
     * Method getJavaClass.
     * 
     * @return the Java class represented by this descriptor.
     */
    public java.lang.Class getJavaClass(
    ) {
        return es.pode.parseadorXML.castor.ComplexTypeEducational.class;
    }

    /**
     * Method getNameSpacePrefix.
     * 
     * @return the namespace prefix to use when marshaling as XML.
     */
    public java.lang.String getNameSpacePrefix(
    ) {
        return _nsPrefix;
    }

    /**
     * Method getNameSpaceURI.
     * 
     * @return the namespace URI used when marshaling and
     * unmarshaling as XML.
     */
    public java.lang.String getNameSpaceURI(
    ) {
        return _nsURI;
    }

    /**
     * Method getValidator.
     * 
     * @return a specific validator for the class described by this
     * ClassDescriptor.
     */
    public org.exolab.castor.xml.TypeValidator getValidator(
    ) {
        return this;
    }

    /**
     * Method getXMLName.
     * 
     * @return the XML Name for the Class being described.
     */
    public java.lang.String getXMLName(
    ) {
        return _xmlName;
    }

    /**
     * Method isElementDefinition.
     * 
     * @return true if XML schema definition of this Class is that
     * of a global
     * element or element with anonymous type definition.
     */
    public boolean isElementDefinition(
    ) {
        return _elementDefinition;
    }

}
