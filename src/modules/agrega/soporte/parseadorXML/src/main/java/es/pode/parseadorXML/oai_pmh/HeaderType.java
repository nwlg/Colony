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
 * A header has a unique identifier, a datestamp,
 *  and setSpec(s) in case the item from which
 *  the record is disseminated belongs to set(s).
 *  the header can carry a deleted status indicating
 *  that the record is deleted.
 * 
 * @version $Revision$ $Date$
 */
public class HeaderType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _status.
     */
    private es.pode.parseadorXML.oai_pmh.types.StatusType _status;

    /**
     * Field _identifier.
     */
    private java.lang.String _identifier;

    /**
     * Field _datestamp.
     */
    private java.lang.String _datestamp;

    /**
     * Field _setSpecList.
     */
    private java.util.List _setSpecList;


      //----------------/
     //- Constructors -/
    //----------------/

    public HeaderType() {
        super();
        this._setSpecList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSetSpec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSetSpec(
            final java.lang.String vSetSpec)
    throws java.lang.IndexOutOfBoundsException {
        this._setSpecList.add(vSetSpec);
    }

    /**
     * 
     * 
     * @param index
     * @param vSetSpec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSetSpec(
            final int index,
            final java.lang.String vSetSpec)
    throws java.lang.IndexOutOfBoundsException {
        this._setSpecList.add(index, vSetSpec);
    }

    /**
     * Method enumerateSetSpec.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSetSpec(
    ) {
        return java.util.Collections.enumeration(this._setSpecList);
    }

    /**
     * Returns the value of field 'datestamp'.
     * 
     * @return the value of field 'Datestamp'.
     */
    public java.lang.String getDatestamp(
    ) {
        return this._datestamp;
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
     * Method getSetSpec.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSetSpec(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._setSpecList.size()) {
            throw new IndexOutOfBoundsException("getSetSpec: Index value '" + index + "' not in range [0.." + (this._setSpecList.size() - 1) + "]");
        }
        
        return (java.lang.String) _setSpecList.get(index);
    }

    /**
     * Method getSetSpec.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSetSpec(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._setSpecList.toArray(array);
    }

    /**
     * Method getSetSpecCount.
     * 
     * @return the size of this collection
     */
    public int getSetSpecCount(
    ) {
        return this._setSpecList.size();
    }

    /**
     * Returns the value of field 'status'.
     * 
     * @return the value of field 'Status'.
     */
    public es.pode.parseadorXML.oai_pmh.types.StatusType getStatus(
    ) {
        return this._status;
    }

    /**
     * Method iterateSetSpec.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSetSpec(
    ) {
        return this._setSpecList.iterator();
    }

    /**
     */
    public void removeAllSetSpec(
    ) {
        this._setSpecList.clear();
    }

    /**
     * Method removeSetSpec.
     * 
     * @param vSetSpec
     * @return true if the object was removed from the collection.
     */
    public boolean removeSetSpec(
            final java.lang.String vSetSpec) {
        boolean removed = _setSpecList.remove(vSetSpec);
        return removed;
    }

    /**
     * Method removeSetSpecAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSetSpecAt(
            final int index) {
        java.lang.Object obj = this._setSpecList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * Sets the value of field 'datestamp'.
     * 
     * @param datestamp the value of field 'datestamp'.
     */
    public void setDatestamp(
            final java.lang.String datestamp) {
        this._datestamp = datestamp;
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
     * 
     * 
     * @param index
     * @param vSetSpec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSetSpec(
            final int index,
            final java.lang.String vSetSpec)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._setSpecList.size()) {
            throw new IndexOutOfBoundsException("setSetSpec: Index value '" + index + "' not in range [0.." + (this._setSpecList.size() - 1) + "]");
        }
        
        this._setSpecList.set(index, vSetSpec);
    }

    /**
     * 
     * 
     * @param vSetSpecArray
     */
    public void setSetSpec(
            final java.lang.String[] vSetSpecArray) {
        //-- copy array
        _setSpecList.clear();
        
        for (int i = 0; i < vSetSpecArray.length; i++) {
                this._setSpecList.add(vSetSpecArray[i]);
        }
    }

    /**
     * Sets the value of field 'status'.
     * 
     * @param status the value of field 'status'.
     */
    public void setStatus(
            final es.pode.parseadorXML.oai_pmh.types.StatusType status) {
        this._status = status;
    }

}
