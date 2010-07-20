/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_dc.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import es.pode.parseadorXML.oai_dc.*;;

/**
 * Class ElementsGroupChoiceItemDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ElementsGroupChoiceItemDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public ElementsGroupChoiceItemDescriptor() {
        super();
        _nsURI = "http://purl.org/dc/elements/1.1/";
        _elementDefinition = false;
        
        //-- set grouping compositor
        setCompositorAsChoice();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _dcTitle
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcTitle.class, "_dcTitle", "title", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcTitle();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcTitle( (DcTitle) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcTitle();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcTitle
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcCreator
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcCreator.class, "_dcCreator", "creator", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcCreator();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcCreator( (DcCreator) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcCreator();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcCreator
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcSubject
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcSubject.class, "_dcSubject", "subject", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcSubject();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcSubject( (DcSubject) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcSubject();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcSubject
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcDescription
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcDescription.class, "_dcDescription", "description", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcDescription();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcDescription( (DcDescription) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcDescription();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcDescription
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcPublisher
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcPublisher.class, "_dcPublisher", "publisher", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcPublisher();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcPublisher( (DcPublisher) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcPublisher();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcPublisher
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcContributor
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcContributor.class, "_dcContributor", "contributor", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcContributor();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcContributor( (DcContributor) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcContributor();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcContributor
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcDate
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcDate.class, "_dcDate", "date", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcDate();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcDate( (DcDate) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcDate();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcDate
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcType
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcType.class, "_dcType", "type", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcType();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcType( (DcType) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcType();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcType
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcFormat
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcFormat.class, "_dcFormat", "format", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcFormat();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcFormat( (DcFormat) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcFormat();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcFormat
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcIdentifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcIdentifier.class, "_dcIdentifier", "identifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcIdentifier();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcIdentifier( (DcIdentifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcIdentifier();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcIdentifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcSource
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcSource.class, "_dcSource", "source", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcSource();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcSource( (DcSource) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcSource();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcSource
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcLanguage
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcLanguage.class, "_dcLanguage", "language", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcLanguage();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcLanguage( (DcLanguage) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcLanguage();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcLanguage
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcRelation
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcRelation.class, "_dcRelation", "relation", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcRelation();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcRelation( (DcRelation) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcRelation();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcRelation
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcCoverage
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcCoverage.class, "_dcCoverage", "coverage", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcCoverage();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcCoverage( (DcCoverage) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcCoverage();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcCoverage
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dcRights
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(DcRights.class, "_dcRights", "rights", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                return target.getDcRights();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElementsGroupChoiceItem target = (ElementsGroupChoiceItem) object;
                    target.setDcRights( (DcRights) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new DcRights();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://purl.org/dc/elements/1.1/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _dcRights
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
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
        return es.pode.parseadorXML.oai_dc.ElementsGroupChoiceItem.class;
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
