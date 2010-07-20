/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_pmh;

/**
 * Class IdentifyType.
 * 
 * @version $Revision$ $Date$
 */
public class IdentifyType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _repositoryName.
     */
    private java.lang.String _repositoryName;

    /**
     * Field _baseURL.
     */
    private java.lang.String _baseURL;

    /**
     * Field _protocolVersion.
     */
    private es.pode.parseadorXML.oai_pmh.types.ProtocolVersionType _protocolVersion;

    /**
     * Field _adminEmailList.
     */
    private java.util.List _adminEmailList;

    /**
     * Field _earliestDatestamp.
     */
    private java.lang.String _earliestDatestamp;

    /**
     * Field _deletedRecord.
     */
    private es.pode.parseadorXML.oai_pmh.types.DeletedRecordType _deletedRecord;

    /**
     * Field _granularity.
     */
    private es.pode.parseadorXML.oai_pmh.types.GranularityType _granularity;

    /**
     * Field _compressionList.
     */
    private java.util.List _compressionList;

    /**
     * Field _descriptionList.
     */
    private java.util.List _descriptionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public IdentifyType() {
        super();
        this._adminEmailList = new java.util.ArrayList();
        this._compressionList = new java.util.ArrayList();
        this._descriptionList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAdminEmail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAdminEmail(
            final java.lang.String vAdminEmail)
    throws java.lang.IndexOutOfBoundsException {
        this._adminEmailList.add(vAdminEmail);
    }

    /**
     * 
     * 
     * @param index
     * @param vAdminEmail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAdminEmail(
            final int index,
            final java.lang.String vAdminEmail)
    throws java.lang.IndexOutOfBoundsException {
        this._adminEmailList.add(index, vAdminEmail);
    }

    /**
     * 
     * 
     * @param vCompression
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCompression(
            final java.lang.String vCompression)
    throws java.lang.IndexOutOfBoundsException {
        this._compressionList.add(vCompression);
    }

    /**
     * 
     * 
     * @param index
     * @param vCompression
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCompression(
            final int index,
            final java.lang.String vCompression)
    throws java.lang.IndexOutOfBoundsException {
        this._compressionList.add(index, vCompression);
    }

    /**
     * 
     * 
     * @param vDescription
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDescription(
            final es.pode.parseadorXML.oai_pmh.Description vDescription)
    throws java.lang.IndexOutOfBoundsException {
        this._descriptionList.add(vDescription);
    }

    /**
     * 
     * 
     * @param index
     * @param vDescription
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDescription(
            final int index,
            final es.pode.parseadorXML.oai_pmh.Description vDescription)
    throws java.lang.IndexOutOfBoundsException {
        this._descriptionList.add(index, vDescription);
    }

    /**
     * Method enumerateAdminEmail.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAdminEmail(
    ) {
        return java.util.Collections.enumeration(this._adminEmailList);
    }

    /**
     * Method enumerateCompression.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateCompression(
    ) {
        return java.util.Collections.enumeration(this._compressionList);
    }

    /**
     * Method enumerateDescription.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateDescription(
    ) {
        return java.util.Collections.enumeration(this._descriptionList);
    }

    /**
     * Method getAdminEmail.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getAdminEmail(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._adminEmailList.size()) {
            throw new IndexOutOfBoundsException("getAdminEmail: Index value '" + index + "' not in range [0.." + (this._adminEmailList.size() - 1) + "]");
        }
        
        return (java.lang.String) _adminEmailList.get(index);
    }

    /**
     * Method getAdminEmail.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getAdminEmail(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._adminEmailList.toArray(array);
    }

    /**
     * Method getAdminEmailCount.
     * 
     * @return the size of this collection
     */
    public int getAdminEmailCount(
    ) {
        return this._adminEmailList.size();
    }

    /**
     * Returns the value of field 'baseURL'.
     * 
     * @return the value of field 'BaseURL'.
     */
    public java.lang.String getBaseURL(
    ) {
        return this._baseURL;
    }

    /**
     * Method getCompression.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getCompression(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._compressionList.size()) {
            throw new IndexOutOfBoundsException("getCompression: Index value '" + index + "' not in range [0.." + (this._compressionList.size() - 1) + "]");
        }
        
        return (java.lang.String) _compressionList.get(index);
    }

    /**
     * Method getCompression.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getCompression(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._compressionList.toArray(array);
    }

    /**
     * Method getCompressionCount.
     * 
     * @return the size of this collection
     */
    public int getCompressionCount(
    ) {
        return this._compressionList.size();
    }

    /**
     * Returns the value of field 'deletedRecord'.
     * 
     * @return the value of field 'DeletedRecord'.
     */
    public es.pode.parseadorXML.oai_pmh.types.DeletedRecordType getDeletedRecord(
    ) {
        return this._deletedRecord;
    }

    /**
     * Method getDescription.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.oai_pmh.Description at the given index
     */
    public es.pode.parseadorXML.oai_pmh.Description getDescription(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._descriptionList.size()) {
            throw new IndexOutOfBoundsException("getDescription: Index value '" + index + "' not in range [0.." + (this._descriptionList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_pmh.Description) _descriptionList.get(index);
    }

    /**
     * Method getDescription.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_pmh.Description[] getDescription(
    ) {
        es.pode.parseadorXML.oai_pmh.Description[] array = new es.pode.parseadorXML.oai_pmh.Description[0];
        return (es.pode.parseadorXML.oai_pmh.Description[]) this._descriptionList.toArray(array);
    }

    /**
     * Method getDescriptionCount.
     * 
     * @return the size of this collection
     */
    public int getDescriptionCount(
    ) {
        return this._descriptionList.size();
    }

    /**
     * Returns the value of field 'earliestDatestamp'.
     * 
     * @return the value of field 'EarliestDatestamp'.
     */
    public java.lang.String getEarliestDatestamp(
    ) {
        return this._earliestDatestamp;
    }

    /**
     * Returns the value of field 'granularity'.
     * 
     * @return the value of field 'Granularity'.
     */
    public es.pode.parseadorXML.oai_pmh.types.GranularityType getGranularity(
    ) {
        return this._granularity;
    }

    /**
     * Returns the value of field 'protocolVersion'.
     * 
     * @return the value of field 'ProtocolVersion'.
     */
    public es.pode.parseadorXML.oai_pmh.types.ProtocolVersionType getProtocolVersion(
    ) {
        return this._protocolVersion;
    }

    /**
     * Returns the value of field 'repositoryName'.
     * 
     * @return the value of field 'RepositoryName'.
     */
    public java.lang.String getRepositoryName(
    ) {
        return this._repositoryName;
    }

    /**
     * Method iterateAdminEmail.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAdminEmail(
    ) {
        return this._adminEmailList.iterator();
    }

    /**
     * Method iterateCompression.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateCompression(
    ) {
        return this._compressionList.iterator();
    }

    /**
     * Method iterateDescription.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateDescription(
    ) {
        return this._descriptionList.iterator();
    }

    /**
     * Method removeAdminEmail.
     * 
     * @param vAdminEmail
     * @return true if the object was removed from the collection.
     */
    public boolean removeAdminEmail(
            final java.lang.String vAdminEmail) {
        boolean removed = _adminEmailList.remove(vAdminEmail);
        return removed;
    }

    /**
     * Method removeAdminEmailAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeAdminEmailAt(
            final int index) {
        java.lang.Object obj = this._adminEmailList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     */
    public void removeAllAdminEmail(
    ) {
        this._adminEmailList.clear();
    }

    /**
     */
    public void removeAllCompression(
    ) {
        this._compressionList.clear();
    }

    /**
     */
    public void removeAllDescription(
    ) {
        this._descriptionList.clear();
    }

    /**
     * Method removeCompression.
     * 
     * @param vCompression
     * @return true if the object was removed from the collection.
     */
    public boolean removeCompression(
            final java.lang.String vCompression) {
        boolean removed = _compressionList.remove(vCompression);
        return removed;
    }

    /**
     * Method removeCompressionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeCompressionAt(
            final int index) {
        java.lang.Object obj = this._compressionList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * Method removeDescription.
     * 
     * @param vDescription
     * @return true if the object was removed from the collection.
     */
    public boolean removeDescription(
            final es.pode.parseadorXML.oai_pmh.Description vDescription) {
        boolean removed = _descriptionList.remove(vDescription);
        return removed;
    }

    /**
     * Method removeDescriptionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_pmh.Description removeDescriptionAt(
            final int index) {
        java.lang.Object obj = this._descriptionList.remove(index);
        return (es.pode.parseadorXML.oai_pmh.Description) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAdminEmail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAdminEmail(
            final int index,
            final java.lang.String vAdminEmail)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._adminEmailList.size()) {
            throw new IndexOutOfBoundsException("setAdminEmail: Index value '" + index + "' not in range [0.." + (this._adminEmailList.size() - 1) + "]");
        }
        
        this._adminEmailList.set(index, vAdminEmail);
    }

    /**
     * 
     * 
     * @param vAdminEmailArray
     */
    public void setAdminEmail(
            final java.lang.String[] vAdminEmailArray) {
        //-- copy array
        _adminEmailList.clear();
        
        for (int i = 0; i < vAdminEmailArray.length; i++) {
                this._adminEmailList.add(vAdminEmailArray[i]);
        }
    }

    /**
     * Sets the value of field 'baseURL'.
     * 
     * @param baseURL the value of field 'baseURL'.
     */
    public void setBaseURL(
            final java.lang.String baseURL) {
        this._baseURL = baseURL;
    }

    /**
     * 
     * 
     * @param index
     * @param vCompression
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCompression(
            final int index,
            final java.lang.String vCompression)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._compressionList.size()) {
            throw new IndexOutOfBoundsException("setCompression: Index value '" + index + "' not in range [0.." + (this._compressionList.size() - 1) + "]");
        }
        
        this._compressionList.set(index, vCompression);
    }

    /**
     * 
     * 
     * @param vCompressionArray
     */
    public void setCompression(
            final java.lang.String[] vCompressionArray) {
        //-- copy array
        _compressionList.clear();
        
        for (int i = 0; i < vCompressionArray.length; i++) {
                this._compressionList.add(vCompressionArray[i]);
        }
    }

    /**
     * Sets the value of field 'deletedRecord'.
     * 
     * @param deletedRecord the value of field 'deletedRecord'.
     */
    public void setDeletedRecord(
            final es.pode.parseadorXML.oai_pmh.types.DeletedRecordType deletedRecord) {
        this._deletedRecord = deletedRecord;
    }

    /**
     * 
     * 
     * @param index
     * @param vDescription
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDescription(
            final int index,
            final es.pode.parseadorXML.oai_pmh.Description vDescription)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._descriptionList.size()) {
            throw new IndexOutOfBoundsException("setDescription: Index value '" + index + "' not in range [0.." + (this._descriptionList.size() - 1) + "]");
        }
        
        this._descriptionList.set(index, vDescription);
    }

    /**
     * 
     * 
     * @param vDescriptionArray
     */
    public void setDescription(
            final es.pode.parseadorXML.oai_pmh.Description[] vDescriptionArray) {
        //-- copy array
        _descriptionList.clear();
        
        for (int i = 0; i < vDescriptionArray.length; i++) {
                this._descriptionList.add(vDescriptionArray[i]);
        }
    }

    /**
     * Sets the value of field 'earliestDatestamp'.
     * 
     * @param earliestDatestamp the value of field
     * 'earliestDatestamp'.
     */
    public void setEarliestDatestamp(
            final java.lang.String earliestDatestamp) {
        this._earliestDatestamp = earliestDatestamp;
    }

    /**
     * Sets the value of field 'granularity'.
     * 
     * @param granularity the value of field 'granularity'.
     */
    public void setGranularity(
            final es.pode.parseadorXML.oai_pmh.types.GranularityType granularity) {
        this._granularity = granularity;
    }

    /**
     * Sets the value of field 'protocolVersion'.
     * 
     * @param protocolVersion the value of field 'protocolVersion'.
     */
    public void setProtocolVersion(
            final es.pode.parseadorXML.oai_pmh.types.ProtocolVersionType protocolVersion) {
        this._protocolVersion = protocolVersion;
    }

    /**
     * Sets the value of field 'repositoryName'.
     * 
     * @param repositoryName the value of field 'repositoryName'.
     */
    public void setRepositoryName(
            final java.lang.String repositoryName) {
        this._repositoryName = repositoryName;
    }

}
