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
 * Class Resource.
 * 
 * @version $Revision$ $Date$
 */
public class ResourceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _identifier.
     */
    private java.lang.String _identifier;

    /**
     * Field _type.
     */
    private java.lang.String _type;
    
    /**
     * Field _scormType
     */
    private java.lang.String _scormType;

    /**
     * See http://www.w3.org/TR/xmlbase/ for
     *  information about this attribute.
     */
    private java.lang.String _base;

    /**
     * Field _href.
     */
    private java.lang.String _href;

    /**
     * Field _metadata.
     */
    private es.pode.parseadorXML.castor.Metadata _metadata;

    /**
     * Field _fileList.
     */
    private java.util.List _fileList;

    /**
     * Field _dependencyList.
     */
    private java.util.List _dependencyList;

    /**
     * Field _grp_any.
     */
    private es.pode.parseadorXML.castor.Grp_any _grp_any;


      //----------------/
     //- Constructors -/
    //----------------/

    public ResourceType() {
        super();
        this._fileList = new java.util.ArrayList();
        this._dependencyList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDependency
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDependency(
            final es.pode.parseadorXML.castor.Dependency vDependency)
    throws java.lang.IndexOutOfBoundsException {
        this._dependencyList.add(vDependency);
    }

    /**
     * 
     * 
     * @param index
     * @param vDependency
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDependency(
            final int index,
            final es.pode.parseadorXML.castor.Dependency vDependency)
    throws java.lang.IndexOutOfBoundsException {
        this._dependencyList.add(index, vDependency);
    }

    /**
     * 
     * 
     * @param vFile
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFile(
            final es.pode.parseadorXML.castor.File vFile)
    throws java.lang.IndexOutOfBoundsException {
        this._fileList.add(vFile);
    }

    /**
     * 
     * 
     * @param index
     * @param vFile
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFile(
            final int index,
            final es.pode.parseadorXML.castor.File vFile)
    throws java.lang.IndexOutOfBoundsException {
        this._fileList.add(index, vFile);
    }

    /**
     * Method enumerateDependency.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateDependency(
    ) {
        return java.util.Collections.enumeration(this._dependencyList);
    }

    /**
     * Method enumerateFile.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateFile(
    ) {
        return java.util.Collections.enumeration(this._fileList);
    }

    /**
     * Returns the value of field 'base'. The field 'base' has the
     * following description: See http://www.w3.org/TR/xmlbase/ for
     *  information about this attribute.
     * 
     * @return the value of field 'Base'.
     */
    public java.lang.String getBase(
    ) {
        return this._base;
    }

    /**
     * Method getDependency.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the es.pode.parseadorXML.scorm2004.castor.Dependency at the
     * given index
     */
    public es.pode.parseadorXML.castor.Dependency getDependency(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dependencyList.size()) {
            throw new IndexOutOfBoundsException("getDependency: Index value '" + index + "' not in range [0.." + (this._dependencyList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.Dependency) _dependencyList.get(index);
    }

    /**
     * Method getDependency.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.Dependency[] getDependency(
    ) {
        es.pode.parseadorXML.castor.Dependency[] array = new es.pode.parseadorXML.castor.Dependency[0];
        return (es.pode.parseadorXML.castor.Dependency[]) this._dependencyList.toArray(array);
    }

    /**
     * Method getDependencyCount.
     * 
     * @return the size of this collection
     */
    public int getDependencyCount(
    ) {
        return this._dependencyList.size();
    }

    /**
     * Method getFile.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the es.pode.parseadorXML.scorm2004.castor.File at the given
     * index
     */
    public es.pode.parseadorXML.castor.File getFile(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._fileList.size()) {
            throw new IndexOutOfBoundsException("getFile: Index value '" + index + "' not in range [0.." + (this._fileList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.File) _fileList.get(index);
    }

    /**
     * Method getFile.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.File[] getFile(
    ) {
        es.pode.parseadorXML.castor.File[] array = new es.pode.parseadorXML.castor.File[0];
        return (es.pode.parseadorXML.castor.File[]) this._fileList.toArray(array);
    }

    /**
     * Method getFileCount.
     * 
     * @return the size of this collection
     */
    public int getFileCount(
    ) {
        return this._fileList.size();
    }

    /**
     * Returns the value of field 'grp_any'.
     * 
     * @return the value of field 'Grp_any'.
     */
    public es.pode.parseadorXML.castor.Grp_any getGrp_any(
    ) {
        return this._grp_any;
    }

    /**
     * Returns the value of field 'href'.
     * 
     * @return the value of field 'Href'.
     */
    public java.lang.String getHref(
    ) {
        return this._href;
    }

    /**
     * Returns the value of field 'identifier'.
     * 
     * @return the value of field 'Identifier'.
     */
    public java.lang.String getIdentifier(
    ) {
        return this._identifier;
    }

    /**
     * Returns the value of field 'metadata'.
     * 
     * @return the value of field 'Metadata'.
     */
    public es.pode.parseadorXML.castor.Metadata getMetadata(
    ) {
        return this._metadata;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public java.lang.String getType(
    ) {
        return this._type;
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
     * Method iterateDependency.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateDependency(
    ) {
        return this._dependencyList.iterator();
    }

    /**
     * Method iterateFile.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateFile(
    ) {
        return this._fileList.iterator();
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
    public void removeAllDependency(
    ) {
        this._dependencyList.clear();
    }

    /**
     */
    public void removeAllFile(
    ) {
        this._fileList.clear();
    }

    /**
     * Method removeDependency.
     * 
     * @param vDependency
     * @return true if the object was removed from the collection.
     */
    public boolean removeDependency(
            final es.pode.parseadorXML.castor.Dependency vDependency) {
        boolean removed = _dependencyList.remove(vDependency);
        return removed;
    }

    /**
     * Method removeDependencyAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.Dependency removeDependencyAt(
            final int index) {
        java.lang.Object obj = this._dependencyList.remove(index);
        return (es.pode.parseadorXML.castor.Dependency) obj;
    }

    /**
     * Method removeFile.
     * 
     * @param vFile
     * @return true if the object was removed from the collection.
     */
    public boolean removeFile(
            final es.pode.parseadorXML.castor.File vFile) {
        boolean removed = _fileList.remove(vFile);
        return removed;
    }

    /**
     * Method removeFileAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.File removeFileAt(
            final int index) {
        java.lang.Object obj = this._fileList.remove(index);
        return (es.pode.parseadorXML.castor.File) obj;
    }

    /**
     * Sets the value of field 'base'. The field 'base' has the
     * following description: See http://www.w3.org/TR/xmlbase/ for
     *  information about this attribute.
     * 
     * @param base the value of field 'base'.
     */
    public void setBase(
            final java.lang.String base) {
        this._base = base;
    }

    /**
     * 
     * 
     * @param index
     * @param vDependency
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDependency(
            final int index,
            final es.pode.parseadorXML.castor.Dependency vDependency)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dependencyList.size()) {
            throw new IndexOutOfBoundsException("setDependency: Index value '" + index + "' not in range [0.." + (this._dependencyList.size() - 1) + "]");
        }
        
        this._dependencyList.set(index, vDependency);
    }

    /**
     * 
     * 
     * @param vDependencyArray
     */
    public void setDependency(
            final es.pode.parseadorXML.castor.Dependency[] vDependencyArray) {
        //-- copy array
        _dependencyList.clear();
        
        for (int i = 0; i < vDependencyArray.length; i++) {
                this._dependencyList.add(vDependencyArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vFile
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFile(
            final int index,
            final es.pode.parseadorXML.castor.File vFile)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._fileList.size()) {
            throw new IndexOutOfBoundsException("setFile: Index value '" + index + "' not in range [0.." + (this._fileList.size() - 1) + "]");
        }
        
        this._fileList.set(index, vFile);
    }

    /**
     * 
     * 
     * @param vFileArray
     */
    public void setFile(
            final es.pode.parseadorXML.castor.File[] vFileArray) {
        //-- copy array
        _fileList.clear();
        
        for (int i = 0; i < vFileArray.length; i++) {
                this._fileList.add(vFileArray[i]);
        }
    }

    /**
     * Sets the value of field 'grp_any'.
     * 
     * @param grp_any the value of field 'grp_any'.
     */
    public void setGrp_any(
            final es.pode.parseadorXML.castor.Grp_any grp_any) {
        this._grp_any = grp_any;
    }

    /**
     * Sets the value of field 'href'.
     * 
     * @param href the value of field 'href'.
     */
    public void setHref(
            final java.lang.String href) {
        this._href = href;
    }

    /**
     * Sets the value of field 'identifier'.
     * 
     * @param identifier the value of field 'identifier'.
     */
    public void setIdentifier(
            final java.lang.String identifier) {
        this._identifier = identifier;
    }

    /**
     * Sets the value of field 'metadata'.
     * 
     * @param metadata the value of field 'metadata'.
     */
    public void setMetadata(
            final es.pode.parseadorXML.castor.Metadata metadata) {
        this._metadata = metadata;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final java.lang.String type) {
        this._type = type;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled es.pode.parseadorXML.scorm2004.castor.ResourceType
     */
    public static es.pode.parseadorXML.castor.ResourceType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.ResourceType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.ResourceType.class, reader);
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


	/**
	 * @return the _scormType
	 */
	public java.lang.String getScormType() {
		return _scormType;
	}


	/**
	 * @param type the _scormType to set
	 */
	public void setScormType(java.lang.String type) {
		_scormType = type;
	}

}
