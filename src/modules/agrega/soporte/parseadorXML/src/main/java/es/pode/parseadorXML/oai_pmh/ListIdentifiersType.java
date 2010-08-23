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
 * Class ListIdentifiersType.
 * 
 * @version $Revision$ $Date$
 */
public class ListIdentifiersType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _listIdentifiersTypeHeaderList.
     */
    private java.util.List _listIdentifiersTypeHeaderList;

    /**
     * Field _listIdentifiersTypeResumptionToken.
     */
    private es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeResumptionToken _listIdentifiersTypeResumptionToken;


      //----------------/
     //- Constructors -/
    //----------------/

    public ListIdentifiersType() {
        super();
        this._listIdentifiersTypeHeaderList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vListIdentifiersTypeHeader
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addListIdentifiersTypeHeader(
            final es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader vListIdentifiersTypeHeader)
    throws java.lang.IndexOutOfBoundsException {
        this._listIdentifiersTypeHeaderList.add(vListIdentifiersTypeHeader);
    }

    /**
     * 
     * 
     * @param index
     * @param vListIdentifiersTypeHeader
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addListIdentifiersTypeHeader(
            final int index,
            final es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader vListIdentifiersTypeHeader)
    throws java.lang.IndexOutOfBoundsException {
        this._listIdentifiersTypeHeaderList.add(index, vListIdentifiersTypeHeader);
    }

    /**
     * Method enumerateListIdentifiersTypeHeader.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateListIdentifiersTypeHeader(
    ) {
        return java.util.Collections.enumeration(this._listIdentifiersTypeHeaderList);
    }

    /**
     * Method getListIdentifiersTypeHeader.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader at
     * the given index
     */
    public es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader getListIdentifiersTypeHeader(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._listIdentifiersTypeHeaderList.size()) {
            throw new IndexOutOfBoundsException("getListIdentifiersTypeHeader: Index value '" + index + "' not in range [0.." + (this._listIdentifiersTypeHeaderList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader) _listIdentifiersTypeHeaderList.get(index);
    }

    /**
     * Method getListIdentifiersTypeHeader.Returns the contents of
     * the collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader[] getListIdentifiersTypeHeader(
    ) {
        es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader[] array = new es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader[0];
        return (es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader[]) this._listIdentifiersTypeHeaderList.toArray(array);
    }

    /**
     * Method getListIdentifiersTypeHeaderCount.
     * 
     * @return the size of this collection
     */
    public int getListIdentifiersTypeHeaderCount(
    ) {
        return this._listIdentifiersTypeHeaderList.size();
    }

    /**
     * Returns the value of field
     * 'listIdentifiersTypeResumptionToken'.
     * 
     * @return the value of field
     * 'ListIdentifiersTypeResumptionToken'.
     */
    public es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeResumptionToken getListIdentifiersTypeResumptionToken(
    ) {
        return this._listIdentifiersTypeResumptionToken;
    }

    /**
     * Method iterateListIdentifiersTypeHeader.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateListIdentifiersTypeHeader(
    ) {
        return this._listIdentifiersTypeHeaderList.iterator();
    }

    /**
     */
    public void removeAllListIdentifiersTypeHeader(
    ) {
        this._listIdentifiersTypeHeaderList.clear();
    }

    /**
     * Method removeListIdentifiersTypeHeader.
     * 
     * @param vListIdentifiersTypeHeader
     * @return true if the object was removed from the collection.
     */
    public boolean removeListIdentifiersTypeHeader(
            final es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader vListIdentifiersTypeHeader) {
        boolean removed = _listIdentifiersTypeHeaderList.remove(vListIdentifiersTypeHeader);
        return removed;
    }

    /**
     * Method removeListIdentifiersTypeHeaderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader removeListIdentifiersTypeHeaderAt(
            final int index) {
        java.lang.Object obj = this._listIdentifiersTypeHeaderList.remove(index);
        return (es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vListIdentifiersTypeHeader
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setListIdentifiersTypeHeader(
            final int index,
            final es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader vListIdentifiersTypeHeader)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._listIdentifiersTypeHeaderList.size()) {
            throw new IndexOutOfBoundsException("setListIdentifiersTypeHeader: Index value '" + index + "' not in range [0.." + (this._listIdentifiersTypeHeaderList.size() - 1) + "]");
        }
        
        this._listIdentifiersTypeHeaderList.set(index, vListIdentifiersTypeHeader);
    }

    /**
     * 
     * 
     * @param vListIdentifiersTypeHeaderArray
     */
    public void setListIdentifiersTypeHeader(
            final es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader[] vListIdentifiersTypeHeaderArray) {
        //-- copy array
        _listIdentifiersTypeHeaderList.clear();
        
        for (int i = 0; i < vListIdentifiersTypeHeaderArray.length; i++) {
                this._listIdentifiersTypeHeaderList.add(vListIdentifiersTypeHeaderArray[i]);
        }
    }

    /**
     * Sets the value of field
     * 'listIdentifiersTypeResumptionToken'.
     * 
     * @param listIdentifiersTypeResumptionToken the value of field
     * 'listIdentifiersTypeResumptionToken'.
     */
    public void setListIdentifiersTypeResumptionToken(
            final es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeResumptionToken listIdentifiersTypeResumptionToken) {
        this._listIdentifiersTypeResumptionToken = listIdentifiersTypeResumptionToken;
    }

}
