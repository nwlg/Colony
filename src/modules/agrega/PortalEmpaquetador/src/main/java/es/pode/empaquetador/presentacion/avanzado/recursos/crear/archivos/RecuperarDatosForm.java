// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setArchivos#sArray(Object[])
     */
    public void setArchivos(java.util.List archivos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArchivos#sArray()
     */
    public java.util.List getArchivos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArchivos(java.util.List)
     */
    public void setArchivosAsArray(Object[] archivos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArchivos()
     */
    public java.lang.Object[] getArchivosAsArray();

    /**
     * Resets the <code>archivos</code> field.
     */
    public void resetArchivos();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Se almacena en sesion en el objeto CrearRecursoSession.
     * </p>
     *
     * @see #setPathArchivos#sArray(Object[])
     */
    public void setPathArchivos(java.util.List pathArchivos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Se almacena en sesion en el objeto CrearRecursoSession.
     * </p>
     *
     * @see #getPathArchivos#sArray()
     */
    public java.util.List getPathArchivos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Se almacena en sesion en el objeto CrearRecursoSession.
     * </p>
     *
     * @see #setPathArchivos(java.util.List)
     */
    public void setPathArchivosAsArray(Object[] pathArchivos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Se almacena en sesion en el objeto CrearRecursoSession.
     * </p>
     *
     * @see #getPathArchivos()
     */
    public java.lang.Object[] getPathArchivosAsArray();

    /**
     * Resets the <code>pathArchivos</code> field.
     */
    public void resetPathArchivos();

    /**
     * Sets the <code>arbol</code> field.
     *
     * 
     */
    public void setArbol(es.pode.empaquetador.negocio.servicio.ArchivoVO arbol);

    /**
     * Gets the <code>arbol</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO getArbol();
    
    /**
     * Resets the <code>arbol</code> field.
     */
    public void resetArbol();

    /**
     * Sets the <code>vistaArbol</code> field.
     *
     * 
     */
    public void setVistaArbol(boolean vistaArbol);

    /**
     * Gets the <code>vistaArbol</code> field.
     *
     * 
     */
    public boolean isVistaArbol();
    
    /**
     * Resets the <code>vistaArbol</code> field.
     */
    public void resetVistaArbol();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setArchivosSeleccionados#sArray(Object[])
     */
    public void setArchivosSeleccionados(java.util.List archivosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArchivosSeleccionados#sArray()
     */
    public java.util.List getArchivosSeleccionados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArchivosSeleccionados(java.util.List)
     */
    public void setArchivosSeleccionadosAsArray(Object[] archivosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArchivosSeleccionados()
     */
    public java.lang.Object[] getArchivosSeleccionadosAsArray();

    /**
     * Resets the <code>archivosSeleccionados</code> field.
     */
    public void resetArchivosSeleccionados();

}
