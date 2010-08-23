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
 * Class ListMetadataFormatsType.
 * 
 * @version $Revision$ $Date$
 */
public class ListMetadataFormatsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metadataFormatList.
     */
    private java.util.List _metadataFormatList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ListMetadataFormatsType() {
        super();
        this._metadataFormatList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMetadataFormat
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetadataFormat(
            final es.pode.parseadorXML.oai_pmh.MetadataFormat vMetadataFormat)
    throws java.lang.IndexOutOfBoundsException {
        this._metadataFormatList.add(vMetadataFormat);
    }

    /**
     * 
     * 
     * @param index
     * @param vMetadataFormat
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetadataFormat(
            final int index,
            final es.pode.parseadorXML.oai_pmh.MetadataFormat vMetadataFormat)
    throws java.lang.IndexOutOfBoundsException {
        this._metadataFormatList.add(index, vMetadataFormat);
    }

    /**
     * Method enumerateMetadataFormat.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateMetadataFormat(
    ) {
        return java.util.Collections.enumeration(this._metadataFormatList);
    }

    /**
     * Method getMetadataFormat.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.parseadorXML.oai_pmh.MetadataFormat at the given inde
     */
    public es.pode.parseadorXML.oai_pmh.MetadataFormat getMetadataFormat(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._metadataFormatList.size()) {
            throw new IndexOutOfBoundsException("getMetadataFormat: Index value '" + index + "' not in range [0.." + (this._metadataFormatList.size() - 1) + "]");
        }
        
        return (es.pode.parseadorXML.oai_pmh.MetadataFormat) _metadataFormatList.get(index);
    }

    /**
     * Method getMetadataFormat.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.parseadorXML.oai_pmh.MetadataFormat[] getMetadataFormat(
    ) {
        es.pode.parseadorXML.oai_pmh.MetadataFormat[] array = new es.pode.parseadorXML.oai_pmh.MetadataFormat[0];
        return (es.pode.parseadorXML.oai_pmh.MetadataFormat[]) this._metadataFormatList.toArray(array);
    }

    /**
     * Method getMetadataFormatCount.
     * 
     * @return the size of this collection
     */
    public int getMetadataFormatCount(
    ) {
        return this._metadataFormatList.size();
    }

    /**
     * Method iterateMetadataFormat.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateMetadataFormat(
    ) {
        return this._metadataFormatList.iterator();
    }

    /**
     */
    public void removeAllMetadataFormat(
    ) {
        this._metadataFormatList.clear();
    }

    /**
     * Method removeMetadataFormat.
     * 
     * @param vMetadataFormat
     * @return true if the object was removed from the collection.
     */
    public boolean removeMetadataFormat(
            final es.pode.parseadorXML.oai_pmh.MetadataFormat vMetadataFormat) {
        boolean removed = _metadataFormatList.remove(vMetadataFormat);
        return removed;
    }

    /**
     * Method removeMetadataFormatAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.parseadorXML.oai_pmh.MetadataFormat removeMetadataFormatAt(
            final int index) {
        java.lang.Object obj = this._metadataFormatList.remove(index);
        return (es.pode.parseadorXML.oai_pmh.MetadataFormat) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMetadataFormat
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMetadataFormat(
            final int index,
            final es.pode.parseadorXML.oai_pmh.MetadataFormat vMetadataFormat)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._metadataFormatList.size()) {
            throw new IndexOutOfBoundsException("setMetadataFormat: Index value '" + index + "' not in range [0.." + (this._metadataFormatList.size() - 1) + "]");
        }
        
        this._metadataFormatList.set(index, vMetadataFormat);
    }

    /**
     * 
     * 
     * @param vMetadataFormatArray
     */
    public void setMetadataFormat(
            final es.pode.parseadorXML.oai_pmh.MetadataFormat[] vMetadataFormatArray) {
        //-- copy array
        _metadataFormatList.clear();
        
        for (int i = 0; i < vMetadataFormatArray.length; i++) {
                this._metadataFormatList.add(vMetadataFormatArray[i]);
        }
    }

}
