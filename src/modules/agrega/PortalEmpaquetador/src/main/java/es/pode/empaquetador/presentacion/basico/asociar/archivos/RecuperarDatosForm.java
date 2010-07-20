// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de ficheros que estan asociados al Grupo (Recurso). Se
     * usaran para dibujar correctamente cada fila de la tabla.
     * </p>
     *
     * @see #setFicherosSeleccionados#sArray(Object[])
     */
    public void setFicherosSeleccionados(java.util.List ficherosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de ficheros que estan asociados al Grupo (Recurso). Se
     * usaran para dibujar correctamente cada fila de la tabla.
     * </p>
     *
     * @see #getFicherosSeleccionados#sArray()
     */
    public java.util.List getFicherosSeleccionados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ficheros que estan asociados al Grupo (Recurso). Se
     * usaran para dibujar correctamente cada fila de la tabla.
     * </p>
     *
     * @see #setFicherosSeleccionados(java.util.List)
     */
    public void setFicherosSeleccionadosAsArray(Object[] ficherosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ficheros que estan asociados al Grupo (Recurso). Se
     * usaran para dibujar correctamente cada fila de la tabla.
     * </p>
     *
     * @see #getFicherosSeleccionados()
     */
    public java.lang.Object[] getFicherosSeleccionadosAsArray();

    /**
     * Resets the <code>ficherosSeleccionados</code> field.
     */
    public void resetFicherosSeleccionados();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Listado de ficheros hijos de la ruta en que se está navegando.
     * </p>
     *
     * @see #setFicheros#sArray(Object[])
     */
    public void setFicheros(java.util.List ficheros);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Listado de ficheros hijos de la ruta en que se está navegando.
     * </p>
     *
     * @see #getFicheros#sArray()
     */
    public java.util.List getFicheros();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Listado de ficheros hijos de la ruta en que se está navegando.
     * </p>
     *
     * @see #setFicheros(java.util.List)
     */
    public void setFicherosAsArray(Object[] ficheros);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Listado de ficheros hijos de la ruta en que se está navegando.
     * </p>
     *
     * @see #getFicheros()
     */
    public java.lang.Object[] getFicherosAsArray();

    /**
     * Resets the <code>ficheros</code> field.
     */
    public void resetFicheros();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Barra de navegacion (breadcrumb)
     * </p>
     *
     * @see #setPath#sArray(Object[])
     */
    public void setPath(java.util.List path);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Barra de navegacion (breadcrumb)
     * </p>
     *
     * @see #getPath#sArray()
     */
    public java.util.List getPath();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Barra de navegacion (breadcrumb)
     * </p>
     *
     * @see #setPath(java.util.List)
     */
    public void setPathAsArray(Object[] path);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Barra de navegacion (breadcrumb)
     * </p>
     *
     * @see #getPath()
     */
    public java.lang.Object[] getPathAsArray();

    /**
     * Resets the <code>path</code> field.
     */
    public void resetPath();

    /**
     * Sets the <code>arbol</code> field.
     *
     * <p>
     * Solo para el caso en que se implemente la vista por arbol en
     * este caso de uso.
     * </p>
     */
    public void setArbol(es.pode.empaquetador.negocio.servicio.ArchivoVO arbol);

    /**
     * Gets the <code>arbol</code> field.
     *
     * <p>
     * Solo para el caso en que se implemente la vista por arbol en
     * este caso de uso.
     * </p>
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO getArbol();
    
    /**
     * Resets the <code>arbol</code> field.
     */
    public void resetArbol();

}
