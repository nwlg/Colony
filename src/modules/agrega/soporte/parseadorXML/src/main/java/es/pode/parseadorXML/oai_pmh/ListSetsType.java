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
 * Class ListSetsType.
 * 
 * @version $Revision$ $Date$
 */
public class ListSetsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _setList.
     */
    private java.util.List _setList;

    /**
     * Field _listSetsTypeResumptionToken.
     */
    private es.pode.parseadorXML.oai_pmh.ListSetsTypeResumptionToken _listSetsTypeResumptionToken;


      //----------------/
     //- Constructors -/
    //----------------/

    public ListSetsType() {
        super();
        this._setList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSet(
            final es.pode.parseadorXML.oai_pmh.Set vSet)
    throws java.lang.IndexOutOfBoundsException {
        this._setList.add(vSet);
    }

    /**
     * 
     * 
     * @param index
     * @param vSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSet(
            final int index,
            final es.pode.parseadorXML.oai_pmh.Set vSet)
    throws java.lang.IndexOutOfBoundsException {
        this._setList.add(index, vSet);
    }

    /**
     * Method enumerateSet.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSet(
    ) {
        return java.util.Collections.enumeration(this._setList);
    }

    /**
     * Returns the value of field 'listSetsTypeResumptionToken'.
     * 
     * @return the value of field 'ListSetsTypeResumptionToken'.
     */
    public es.pode.parseadorXML.oai_pmh.ListSetsTypeResumptionToken getListSetsTypeResumptionToken(
    ) {
        return this._listSetsTypeResumptionToken;
    }

    /**
     * Method getSet.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the es.pode.parseadorXML.oai_pmh.Set at
     * the given index
     */
    public es.pode.parseadorXML.oai_pmh.Set getSet(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._setList.size()) {
            throw new IndexOutOfBoundsException("getSet: Index value '" + index + "' not in range [0.." + (this._setList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_pmh.Set) _setList.get(index);
    }

    /**
     * Method getSet.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_pmh.Set[] getSet(
    ) {
        es.pode.parseadorXML.oai_pmh.Set[] array = new es.pode.parseadorXML.oai_pmh.Set[0];
        return (es.pode.parseadorXML.oai_pmh.Set[]) this._setList.toArray(array);
    }

    /**
     * Method getSetCount.
     * 
     * @return the size of this collection
     */
    public int getSetCount(
    ) {
        return this._setList.size();
    }

    /**
     * Method iterateSet.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSet(
    ) {
        return this._setList.iterator();
    }

    /**
     */
    public void removeAllSet(
    ) {
        this._setList.clear();
    }

    /**
     * Method removeSet.
     * 
     * @param vSet
     * @return true if the object was removed from the collection.
     */
    public boolean removeSet(
            final es.pode.parseadorXML.oai_pmh.Set vSet) {
        boolean removed = _setList.remove(vSet);
        return removed;
    }

    /**
     * Method removeSetAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_pmh.Set removeSetAt(
            final int index) {
        java.lang.Object obj = this._setList.remove(index);
        return (es.pode.parseadorXML.oai_pmh.Set) obj;
    }

    /**
     * Sets the value of field 'listSetsTypeResumptionToken'.
     * 
     * @param listSetsTypeResumptionToken the value of field
     * 'listSetsTypeResumptionToken'.
     */
    public void setListSetsTypeResumptionToken(
            final es.pode.parseadorXML.oai_pmh.ListSetsTypeResumptionToken listSetsTypeResumptionToken) {
        this._listSetsTypeResumptionToken = listSetsTypeResumptionToken;
    }

    /**
     * 
     * 
     * @param index
     * @param vSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSet(
            final int index,
            final es.pode.parseadorXML.oai_pmh.Set vSet)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._setList.size()) {
            throw new IndexOutOfBoundsException("setSet: Index value '" + index + "' not in range [0.." + (this._setList.size() - 1) + "]");
        }
        
        this._setList.set(index, vSet);
    }

    /**
     * 
     * 
     * @param vSetArray
     */
    public void setSet(
            final es.pode.parseadorXML.oai_pmh.Set[] vSetArray) {
        //-- copy array
        _setList.clear();
        
        for (int i = 0; i < vSetArray.length; i++) {
                this._setList.add(vSetArray[i]);
        }
    }

}
