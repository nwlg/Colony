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

/**
 * Class NavigationInterfaceType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class NavigationInterfaceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _hideLMSUIList.
     */
    private java.util.List _hideLMSUIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NavigationInterfaceType() {
        super();
        this._hideLMSUIList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vHideLMSUI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHideLMSUI(
            final es.pode.parseadorXML.castor.types.HideLMSUIType vHideLMSUI)
    throws java.lang.IndexOutOfBoundsException {
        this._hideLMSUIList.add(vHideLMSUI);
    }

    /**
     * 
     * 
     * @param index
     * @param vHideLMSUI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHideLMSUI(
            final int index,
            final es.pode.parseadorXML.castor.types.HideLMSUIType vHideLMSUI)
    throws java.lang.IndexOutOfBoundsException {
        this._hideLMSUIList.add(index, vHideLMSUI);
    }

    /**
     * Method enumerateHideLMSUI.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateHideLMSUI(
    ) {
        return java.util.Collections.enumeration(this._hideLMSUIList);
    }

    /**
     * Method getHideLMSUI.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.castor.types.HideLMSUIType at the given
     * index
     */
    public es.pode.parseadorXML.castor.types.HideLMSUIType getHideLMSUI(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._hideLMSUIList.size()) {
            throw new IndexOutOfBoundsException("getHideLMSUI: Index value '" + index + "' not in range [0.." + (this._hideLMSUIList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.castor.types.HideLMSUIType) _hideLMSUIList.get(index);
    }

    /**
     * Method getHideLMSUI.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.castor.types.HideLMSUIType[] getHideLMSUI(
    ) {
        es.pode.parseadorXML.castor.types.HideLMSUIType[] array = new es.pode.parseadorXML.castor.types.HideLMSUIType[0];
        return (es.pode.parseadorXML.castor.types.HideLMSUIType[]) this._hideLMSUIList.toArray(array);
    }

    /**
     * Method getHideLMSUICount.
     * 
     * @return the size of this collection
     */
    public int getHideLMSUICount(
    ) {
        return this._hideLMSUIList.size();
    }

    /**
     * Method iterateHideLMSUI.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateHideLMSUI(
    ) {
        return this._hideLMSUIList.iterator();
    }

    /**
     */
    public void removeAllHideLMSUI(
    ) {
        this._hideLMSUIList.clear();
    }

    /**
     * Method removeHideLMSUI.
     * 
     * @param vHideLMSUI
     * @return true if the object was removed from the collection.
     */
    public boolean removeHideLMSUI(
            final es.pode.parseadorXML.castor.types.HideLMSUIType vHideLMSUI) {
        boolean removed = _hideLMSUIList.remove(vHideLMSUI);
        return removed;
    }

    /**
     * Method removeHideLMSUIAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.castor.types.HideLMSUIType removeHideLMSUIAt(
            final int index) {
        java.lang.Object obj = this._hideLMSUIList.remove(index);
        return (es.pode.parseadorXML.castor.types.HideLMSUIType) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vHideLMSUI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHideLMSUI(
            final int index,
            final es.pode.parseadorXML.castor.types.HideLMSUIType vHideLMSUI)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._hideLMSUIList.size()) {
            throw new IndexOutOfBoundsException("setHideLMSUI: Index value '" + index + "' not in range [0.." + (this._hideLMSUIList.size() - 1) + "]");
        }
        
        this._hideLMSUIList.set(index, vHideLMSUI);
    }

    /**
     * 
     * 
     * @param vHideLMSUIArray
     */
    public void setHideLMSUI(
            final es.pode.parseadorXML.castor.types.HideLMSUIType[] vHideLMSUIArray) {
        //-- copy array
        _hideLMSUIList.clear();
        
        for (int i = 0; i < vHideLMSUIArray.length; i++) {
                this._hideLMSUIList.add(vHideLMSUIArray[i]);
        }
    }

}
