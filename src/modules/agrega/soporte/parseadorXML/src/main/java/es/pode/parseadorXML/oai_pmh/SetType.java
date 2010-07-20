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
 * Class SetType.
 * 
 * @version $Revision$ $Date$
 */
public class SetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _setSpec.
     */
    private java.lang.String _setSpec;

    /**
     * Field _setName.
     */
    private java.lang.String _setName;

    /**
     * Field _setDescriptionList.
     */
    private java.util.List _setDescriptionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SetType() {
        super();
        this._setDescriptionList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSetDescription
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSetDescription(
            final es.pode.parseadorXML.oai_pmh.SetDescription vSetDescription)
    throws java.lang.IndexOutOfBoundsException {
        this._setDescriptionList.add(vSetDescription);
    }

    /**
     * 
     * 
     * @param index
     * @param vSetDescription
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSetDescription(
            final int index,
            final es.pode.parseadorXML.oai_pmh.SetDescription vSetDescription)
    throws java.lang.IndexOutOfBoundsException {
        this._setDescriptionList.add(index, vSetDescription);
    }

    /**
     * Method enumerateSetDescription.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSetDescription(
    ) {
        return java.util.Collections.enumeration(this._setDescriptionList);
    }

    /**
     * Method getSetDescription.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.oai_pmh.SetDescription at the given inde
     */
    public es.pode.parseadorXML.oai_pmh.SetDescription getSetDescription(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._setDescriptionList.size()) {
            throw new IndexOutOfBoundsException("getSetDescription: Index value '" + index + "' not in range [0.." + (this._setDescriptionList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_pmh.SetDescription) _setDescriptionList.get(index);
    }

    /**
     * Method getSetDescription.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_pmh.SetDescription[] getSetDescription(
    ) {
        es.pode.parseadorXML.oai_pmh.SetDescription[] array = new es.pode.parseadorXML.oai_pmh.SetDescription[0];
        return (es.pode.parseadorXML.oai_pmh.SetDescription[]) this._setDescriptionList.toArray(array);
    }

    /**
     * Method getSetDescriptionCount.
     * 
     * @return the size of this collection
     */
    public int getSetDescriptionCount(
    ) {
        return this._setDescriptionList.size();
    }

    /**
     * Returns the value of field 'setName'.
     * 
     * @return the value of field 'SetName'.
     */
    public java.lang.String getSetName(
    ) {
        return this._setName;
    }

    /**
     * Returns the value of field 'setSpec'.
     * 
     * @return the value of field 'SetSpec'.
     */
    public java.lang.String getSetSpec(
    ) {
        return this._setSpec;
    }

    /**
     * Method iterateSetDescription.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSetDescription(
    ) {
        return this._setDescriptionList.iterator();
    }

    /**
     */
    public void removeAllSetDescription(
    ) {
        this._setDescriptionList.clear();
    }

    /**
     * Method removeSetDescription.
     * 
     * @param vSetDescription
     * @return true if the object was removed from the collection.
     */
    public boolean removeSetDescription(
            final es.pode.parseadorXML.oai_pmh.SetDescription vSetDescription) {
        boolean removed = _setDescriptionList.remove(vSetDescription);
        return removed;
    }

    /**
     * Method removeSetDescriptionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_pmh.SetDescription removeSetDescriptionAt(
            final int index) {
        java.lang.Object obj = this._setDescriptionList.remove(index);
        return (es.pode.parseadorXML.oai_pmh.SetDescription) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSetDescription
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSetDescription(
            final int index,
            final es.pode.parseadorXML.oai_pmh.SetDescription vSetDescription)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._setDescriptionList.size()) {
            throw new IndexOutOfBoundsException("setSetDescription: Index value '" + index + "' not in range [0.." + (this._setDescriptionList.size() - 1) + "]");
        }
        
        this._setDescriptionList.set(index, vSetDescription);
    }

    /**
     * 
     * 
     * @param vSetDescriptionArray
     */
    public void setSetDescription(
            final es.pode.parseadorXML.oai_pmh.SetDescription[] vSetDescriptionArray) {
        //-- copy array
        _setDescriptionList.clear();
        
        for (int i = 0; i < vSetDescriptionArray.length; i++) {
                this._setDescriptionList.add(vSetDescriptionArray[i]);
        }
    }

    /**
     * Sets the value of field 'setName'.
     * 
     * @param setName the value of field 'setName'.
     */
    public void setSetName(
            final java.lang.String setName) {
        this._setName = setName;
    }

    /**
     * Sets the value of field 'setSpec'.
     * 
     * @param setSpec the value of field 'setSpec'.
     */
    public void setSetSpec(
            final java.lang.String setSpec) {
        this._setSpec = setSpec;
    }

}
