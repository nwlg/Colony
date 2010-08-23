/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.modificador.negocio.cambios.configuracion.castor;

/**
 * Class ObjectsType.
 * 
 * @version $Revision$ $Date$
 */
public class ObjectsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _odeList.
     */
    private java.util.List _odeList;

    /**
     * Field _folderList.
     */
    private java.util.List _folderList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectsType() {
        super();
        this._odeList = new java.util.ArrayList();
        this._folderList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vFolder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFolder(
            final es.pode.modificador.negocio.cambios.configuracion.castor.Folder vFolder)
    throws java.lang.IndexOutOfBoundsException {
        this._folderList.add(vFolder);
    }

    /**
     * 
     * 
     * @param index
     * @param vFolder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFolder(
            final int index,
            final es.pode.modificador.negocio.cambios.configuracion.castor.Folder vFolder)
    throws java.lang.IndexOutOfBoundsException {
        this._folderList.add(index, vFolder);
    }

    /**
     * 
     * 
     * @param vOde
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOde(
            final es.pode.modificador.negocio.cambios.configuracion.castor.Ode vOde)
    throws java.lang.IndexOutOfBoundsException {
        this._odeList.add(vOde);
    }

    /**
     * 
     * 
     * @param index
     * @param vOde
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOde(
            final int index,
            final es.pode.modificador.negocio.cambios.configuracion.castor.Ode vOde)
    throws java.lang.IndexOutOfBoundsException {
        this._odeList.add(index, vOde);
    }

    /**
     * Method enumerateFolder.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateFolder(
    ) {
        return java.util.Collections.enumeration(this._folderList);
    }

    /**
     * Method enumerateOde.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateOde(
    ) {
        return java.util.Collections.enumeration(this._odeList);
    }

    /**
     * Method getFolder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.modificador.negocio.cambios.configuracion.castor.Folder at
     * the given index
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.Folder getFolder(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._folderList.size()) {
            throw new IndexOutOfBoundsException("getFolder: Index value '" + index + "' not in range [0.." + (this._folderList.size() - 1) + "]");
        }
        
        return (es.pode.modificador.negocio.cambios.configuracion.castor.Folder) _folderList.get(index);
    }

    /**
     * Method getFolder.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.Folder[] getFolder(
    ) {
        es.pode.modificador.negocio.cambios.configuracion.castor.Folder[] array = new es.pode.modificador.negocio.cambios.configuracion.castor.Folder[0];
        return (es.pode.modificador.negocio.cambios.configuracion.castor.Folder[]) this._folderList.toArray(array);
    }

    /**
     * Method getFolderCount.
     * 
     * @return the size of this collection
     */
    public int getFolderCount(
    ) {
        return this._folderList.size();
    }

    /**
     * Method getOde.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * es.pode.modificador.negocio.cambios.configuracion.castor.Ode at the
     * given index
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.Ode getOde(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._odeList.size()) {
            throw new IndexOutOfBoundsException("getOde: Index value '" + index + "' not in range [0.." + (this._odeList.size() - 1) + "]");
        }
        
        return (es.pode.modificador.negocio.cambios.configuracion.castor.Ode) _odeList.get(index);
    }

    /**
     * Method getOde.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.Ode[] getOde(
    ) {
        es.pode.modificador.negocio.cambios.configuracion.castor.Ode[] array = new es.pode.modificador.negocio.cambios.configuracion.castor.Ode[0];
        return (es.pode.modificador.negocio.cambios.configuracion.castor.Ode[]) this._odeList.toArray(array);
    }

    /**
     * Method getOdeCount.
     * 
     * @return the size of this collection
     */
    public int getOdeCount(
    ) {
        return this._odeList.size();
    }

    /**
     * Method iterateFolder.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateFolder(
    ) {
        return this._folderList.iterator();
    }

    /**
     * Method iterateOde.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateOde(
    ) {
        return this._odeList.iterator();
    }

    /**
     */
    public void removeAllFolder(
    ) {
        this._folderList.clear();
    }

    /**
     */
    public void removeAllOde(
    ) {
        this._odeList.clear();
    }

    /**
     * Method removeFolder.
     * 
     * @param vFolder
     * @return true if the object was removed from the collection.
     */
    public boolean removeFolder(
            final es.pode.modificador.negocio.cambios.configuracion.castor.Folder vFolder) {
        boolean removed = _folderList.remove(vFolder);
        return removed;
    }

    /**
     * Method removeFolderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.Folder removeFolderAt(
            final int index) {
        java.lang.Object obj = this._folderList.remove(index);
        return (es.pode.modificador.negocio.cambios.configuracion.castor.Folder) obj;
    }

    /**
     * Method removeOde.
     * 
     * @param vOde
     * @return true if the object was removed from the collection.
     */
    public boolean removeOde(
            final es.pode.modificador.negocio.cambios.configuracion.castor.Ode vOde) {
        boolean removed = _odeList.remove(vOde);
        return removed;
    }

    /**
     * Method removeOdeAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public es.pode.modificador.negocio.cambios.configuracion.castor.Ode removeOdeAt(
            final int index) {
        java.lang.Object obj = this._odeList.remove(index);
        return (es.pode.modificador.negocio.cambios.configuracion.castor.Ode) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vFolder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFolder(
            final int index,
            final es.pode.modificador.negocio.cambios.configuracion.castor.Folder vFolder)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._folderList.size()) {
            throw new IndexOutOfBoundsException("setFolder: Index value '" + index + "' not in range [0.." + (this._folderList.size() - 1) + "]");
        }
        
        this._folderList.set(index, vFolder);
    }

    /**
     * 
     * 
     * @param vFolderArray
     */
    public void setFolder(
            final es.pode.modificador.negocio.cambios.configuracion.castor.Folder[] vFolderArray) {
        //-- copy array
        _folderList.clear();
        
        for (int i = 0; i < vFolderArray.length; i++) {
                this._folderList.add(vFolderArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vOde
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOde(
            final int index,
            final es.pode.modificador.negocio.cambios.configuracion.castor.Ode vOde)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._odeList.size()) {
            throw new IndexOutOfBoundsException("setOde: Index value '" + index + "' not in range [0.." + (this._odeList.size() - 1) + "]");
        }
        
        this._odeList.set(index, vOde);
    }

    /**
     * 
     * 
     * @param vOdeArray
     */
    public void setOde(
            final es.pode.modificador.negocio.cambios.configuracion.castor.Ode[] vOdeArray) {
        //-- copy array
        _odeList.clear();
        
        for (int i = 0; i < vOdeArray.length; i++) {
                this._odeList.add(vOdeArray[i]);
        }
    }

}
