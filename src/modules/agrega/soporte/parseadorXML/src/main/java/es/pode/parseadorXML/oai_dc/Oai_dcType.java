/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_dc;

/**
 * Class Oai_dcType.
 * 
 * @version $Revision$ $Date$
 */
public class Oai_dcType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Oai_dcType() {
        super();
        this._items = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOai_dcTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOai_dcTypeItem(
            final es.pode.parseadorXML.oai_dc.Oai_dcTypeItem vOai_dcTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vOai_dcTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vOai_dcTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOai_dcTypeItem(
            final int index,
            final es.pode.parseadorXML.oai_dc.Oai_dcTypeItem vOai_dcTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vOai_dcTypeItem);
    }

    /**
     * Method enumerateOai_dcTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateOai_dcTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getOai_dcTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.oai_dc.Oai_dcTypeItem at the given index
     */
    public es.pode.parseadorXML.oai_dc.Oai_dcTypeItem getOai_dcTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getOai_dcTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_dc.Oai_dcTypeItem) _items.get(index);
    }

    /**
     * Method getOai_dcTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_dc.Oai_dcTypeItem[] getOai_dcTypeItem(
    ) {
        es.pode.parseadorXML.oai_dc.Oai_dcTypeItem[] array = new es.pode.parseadorXML.oai_dc.Oai_dcTypeItem[0];
        return (es.pode.parseadorXML.oai_dc.Oai_dcTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getOai_dcTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getOai_dcTypeItemCount(
    ) {
        return this._items.size();
    }

    /**
     * Method iterateOai_dcTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateOai_dcTypeItem(
    ) {
        return this._items.iterator();
    }

    /**
     */
    public void removeAllOai_dcTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeOai_dcTypeItem.
     * 
     * @param vOai_dcTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeOai_dcTypeItem(
            final es.pode.parseadorXML.oai_dc.Oai_dcTypeItem vOai_dcTypeItem) {
        boolean removed = _items.remove(vOai_dcTypeItem);
        return removed;
    }

    /**
     * Method removeOai_dcTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_dc.Oai_dcTypeItem removeOai_dcTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (es.pode.parseadorXML.oai_dc.Oai_dcTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vOai_dcTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOai_dcTypeItem(
            final int index,
            final es.pode.parseadorXML.oai_dc.Oai_dcTypeItem vOai_dcTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setOai_dcTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }
        
        this._items.set(index, vOai_dcTypeItem);
    }

    /**
     * 
     * 
     * @param vOai_dcTypeItemArray
     */
    public void setOai_dcTypeItem(
            final es.pode.parseadorXML.oai_dc.Oai_dcTypeItem[] vOai_dcTypeItemArray) {
        //-- copy array
        _items.clear();
        
        for (int i = 0; i < vOai_dcTypeItemArray.length; i++) {
                this._items.add(vOai_dcTypeItemArray[i]);
        }
    }

}
