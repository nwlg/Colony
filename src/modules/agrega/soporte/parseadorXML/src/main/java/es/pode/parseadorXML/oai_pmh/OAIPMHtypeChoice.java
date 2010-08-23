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
 * Class OAIPMHtypeChoice.
 * 
 * @version $Revision$ $Date$
 */
public class OAIPMHtypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _errorList.
     */
    private java.util.List _errorList;

    /**
     * Field _identify.
     */
    private es.pode.parseadorXML.oai_pmh.Identify _identify;

    /**
     * Field _listMetadataFormats.
     */
    private es.pode.parseadorXML.oai_pmh.ListMetadataFormats _listMetadataFormats;

    /**
     * Field _listSets.
     */
    private es.pode.parseadorXML.oai_pmh.ListSets _listSets;

    /**
     * Field _getRecord.
     */
    private es.pode.parseadorXML.oai_pmh.GetRecord _getRecord;

    /**
     * Field _listIdentifiers.
     */
    private es.pode.parseadorXML.oai_pmh.ListIdentifiers _listIdentifiers;

    /**
     * Field _listRecords.
     */
    private es.pode.parseadorXML.oai_pmh.ListRecords _listRecords;


      //----------------/
     //- Constructors -/
    //----------------/

    public OAIPMHtypeChoice() {
        super();
        this._errorList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vError
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addError(
            final es.pode.parseadorXML.oai_pmh.Error vError)
    throws java.lang.IndexOutOfBoundsException {
        this._errorList.add(vError);
    }

    /**
     * 
     * 
     * @param index
     * @param vError
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addError(
            final int index,
            final es.pode.parseadorXML.oai_pmh.Error vError)
    throws java.lang.IndexOutOfBoundsException {
        this._errorList.add(index, vError);
    }

    /**
     * Method enumerateError.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateError(
    ) {
        return java.util.Collections.enumeration(this._errorList);
    }

    /**
     * Method getError.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the es.pode.parseadorXML.oai_pmh.Error
     * at the given index
     */
    public es.pode.parseadorXML.oai_pmh.Error getError(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._errorList.size()) {
            throw new IndexOutOfBoundsException("getError: Index value '" + index + "' not in range [0.." + (this._errorList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_pmh.Error) _errorList.get(index);
    }

    /**
     * Method getError.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_pmh.Error[] getError(
    ) {
        es.pode.parseadorXML.oai_pmh.Error[] array = new es.pode.parseadorXML.oai_pmh.Error[0];
        return (es.pode.parseadorXML.oai_pmh.Error[]) this._errorList.toArray(array);
    }

    /**
     * Method getErrorCount.
     * 
     * @return the size of this collection
     */
    public int getErrorCount(
    ) {
        return this._errorList.size();
    }

    /**
     * Returns the value of field 'getRecord'.
     * 
     * @return the value of field 'GetRecord'.
     */
    public es.pode.parseadorXML.oai_pmh.GetRecord getGetRecord(
    ) {
        return this._getRecord;
    }

    /**
     * Returns the value of field 'identify'.
     * 
     * @return the value of field 'Identify'.
     */
    public es.pode.parseadorXML.oai_pmh.Identify getIdentify(
    ) {
        return this._identify;
    }

    /**
     * Returns the value of field 'listIdentifiers'.
     * 
     * @return the value of field 'ListIdentifiers'.
     */
    public es.pode.parseadorXML.oai_pmh.ListIdentifiers getListIdentifiers(
    ) {
        return this._listIdentifiers;
    }

    /**
     * Returns the value of field 'listMetadataFormats'.
     * 
     * @return the value of field 'ListMetadataFormats'.
     */
    public es.pode.parseadorXML.oai_pmh.ListMetadataFormats getListMetadataFormats(
    ) {
        return this._listMetadataFormats;
    }

    /**
     * Returns the value of field 'listRecords'.
     * 
     * @return the value of field 'ListRecords'.
     */
    public es.pode.parseadorXML.oai_pmh.ListRecords getListRecords(
    ) {
        return this._listRecords;
    }

    /**
     * Returns the value of field 'listSets'.
     * 
     * @return the value of field 'ListSets'.
     */
    public es.pode.parseadorXML.oai_pmh.ListSets getListSets(
    ) {
        return this._listSets;
    }

    /**
     * Method iterateError.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateError(
    ) {
        return this._errorList.iterator();
    }

    /**
     */
    public void removeAllError(
    ) {
        this._errorList.clear();
    }

    /**
     * Method removeError.
     * 
     * @param vError
     * @return true if the object was removed from the collection.
     */
    public boolean removeError(
            final es.pode.parseadorXML.oai_pmh.Error vError) {
        boolean removed = _errorList.remove(vError);
        return removed;
    }

    /**
     * Method removeErrorAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_pmh.Error removeErrorAt(
            final int index) {
        java.lang.Object obj = this._errorList.remove(index);
        return (es.pode.parseadorXML.oai_pmh.Error) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vError
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setError(
            final int index,
            final es.pode.parseadorXML.oai_pmh.Error vError)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._errorList.size()) {
            throw new IndexOutOfBoundsException("setError: Index value '" + index + "' not in range [0.." + (this._errorList.size() - 1) + "]");
        }
        
        this._errorList.set(index, vError);
    }

    /**
     * 
     * 
     * @param vErrorArray
     */
    public void setError(
            final es.pode.parseadorXML.oai_pmh.Error[] vErrorArray) {
        //-- copy array
        _errorList.clear();
        
        for (int i = 0; i < vErrorArray.length; i++) {
                this._errorList.add(vErrorArray[i]);
        }
    }

    /**
     * Sets the value of field 'getRecord'.
     * 
     * @param getRecord the value of field 'getRecord'.
     */
    public void setGetRecord(
            final es.pode.parseadorXML.oai_pmh.GetRecord getRecord) {
        this._getRecord = getRecord;
    }

    /**
     * Sets the value of field 'identify'.
     * 
     * @param identify the value of field 'identify'.
     */
    public void setIdentify(
            final es.pode.parseadorXML.oai_pmh.Identify identify) {
        this._identify = identify;
    }

    /**
     * Sets the value of field 'listIdentifiers'.
     * 
     * @param listIdentifiers the value of field 'listIdentifiers'.
     */
    public void setListIdentifiers(
            final es.pode.parseadorXML.oai_pmh.ListIdentifiers listIdentifiers) {
        this._listIdentifiers = listIdentifiers;
    }

    /**
     * Sets the value of field 'listMetadataFormats'.
     * 
     * @param listMetadataFormats the value of field
     * 'listMetadataFormats'.
     */
    public void setListMetadataFormats(
            final es.pode.parseadorXML.oai_pmh.ListMetadataFormats listMetadataFormats) {
        this._listMetadataFormats = listMetadataFormats;
    }

    /**
     * Sets the value of field 'listRecords'.
     * 
     * @param listRecords the value of field 'listRecords'.
     */
    public void setListRecords(
            final es.pode.parseadorXML.oai_pmh.ListRecords listRecords) {
        this._listRecords = listRecords;
    }

    /**
     * Sets the value of field 'listSets'.
     * 
     * @param listSets the value of field 'listSets'.
     */
    public void setListSets(
            final es.pode.parseadorXML.oai_pmh.ListSets listSets) {
        this._listSets = listSets;
    }

}
