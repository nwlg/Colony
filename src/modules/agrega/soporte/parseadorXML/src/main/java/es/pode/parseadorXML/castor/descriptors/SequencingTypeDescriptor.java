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

import es.pode.parseadorXML.castor.SequencingType;

/**
 * Class SequencingTypeDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class SequencingTypeDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public SequencingTypeDescriptor() {
        super();
        _nsURI = "http://www.imsglobal.org/xsd/imsss";
        _xmlName = "sequencingType";
        _elementDefinition = false;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- _ID
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_ID", "ID", org.exolab.castor.xml.NodeType.Attribute);
        this._identity = desc;
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getID();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setID( (java.lang.String) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new java.lang.String();
            }
        };
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _ID
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
            org.exolab.castor.xml.validators.IdValidator typeValidator;
            typeValidator = new org.exolab.castor.xml.validators.IdValidator();
            fieldValidator.setValidator(typeValidator);
        }
        desc.setValidator(fieldValidator);
        //-- _IDRef
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Object.class, "_IDRef", "IDRef", org.exolab.castor.xml.NodeType.Attribute);
        desc.setReference(true);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getIDRef();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setIDRef( (java.lang.Object) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new java.lang.Object();
            }
        };
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _IDRef
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
            org.exolab.castor.xml.validators.IdRefValidator typeValidator;
            typeValidator = new org.exolab.castor.xml.validators.IdRefValidator();
            fieldValidator.setValidator(typeValidator);
        }
        desc.setValidator(fieldValidator);
        //-- initialize element descriptors
        
        //-- _controlMode
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.ControlMode.class, "_controlMode", "controlMode", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getControlMode();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setControlMode( (es.pode.parseadorXML.castor.ControlMode) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.ControlMode();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _controlMode
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _sequencingRules
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.SequencingRules.class, "_sequencingRules", "sequencingRules", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getSequencingRules();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setSequencingRules( (es.pode.parseadorXML.castor.SequencingRules) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.SequencingRules();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _sequencingRules
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _limitConditions
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.LimitConditions.class, "_limitConditions", "limitConditions", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getLimitConditions();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setLimitConditions( (es.pode.parseadorXML.castor.LimitConditions) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.LimitConditions();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _limitConditions
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _auxiliaryResources
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.AuxiliaryResources.class, "_auxiliaryResources", "auxiliaryResources", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getAuxiliaryResources();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setAuxiliaryResources( (es.pode.parseadorXML.castor.AuxiliaryResources) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.AuxiliaryResources();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _auxiliaryResources
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _rollupRules
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.RollupRules.class, "_rollupRules", "rollupRules", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getRollupRules();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setRollupRules( (es.pode.parseadorXML.castor.RollupRules) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.RollupRules();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _rollupRules
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _objectives
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.Objectives.class, "_objectives", "objectives", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getObjectives();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setObjectives( (es.pode.parseadorXML.castor.Objectives) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.Objectives();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _objectives
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _randomizationControls
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.RandomizationControls.class, "_randomizationControls", "randomizationControls", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getRandomizationControls();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setRandomizationControls( (es.pode.parseadorXML.castor.RandomizationControls) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.RandomizationControls();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _randomizationControls
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _deliveryControls
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(es.pode.parseadorXML.castor.DeliveryControls.class, "_deliveryControls", "deliveryControls", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getDeliveryControls();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.setDeliveryControls( (es.pode.parseadorXML.castor.DeliveryControls) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new es.pode.parseadorXML.castor.DeliveryControls();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.imsglobal.org/xsd/imsss");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _deliveryControls
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _anyObject
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Object.class, "_anyObject", (java.lang.String) null, org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SequencingType target = (SequencingType) object;
                return target.getAnyObject();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SequencingType target = (SequencingType) object;
                    target.addAnyObject(  value );
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    SequencingType target = (SequencingType) object;
                    target.removeAllAnyObject();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setHandler(handler);
        desc.setMatches("*");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _anyObject
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
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
        return es.pode.parseadorXML.castor.SequencingType.class;
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
