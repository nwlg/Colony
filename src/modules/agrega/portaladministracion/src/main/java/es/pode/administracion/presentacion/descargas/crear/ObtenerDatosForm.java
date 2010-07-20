// license-header java merge-point
package es.pode.administracion.presentacion.descargas.crear;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerDatos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.descargas.crear.CrearDescargaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.descargas.crear.CrearDescargaController#obtenerDatos
 */
public interface ObtenerDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripciones#sArray(Object[])
     */
    public void setDescripciones(java.util.List descripciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripciones#sArray()
     */
    public java.util.List getDescripciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripciones(java.util.List)
     */
    public void setDescripcionesAsArray(Object[] descripciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripciones()
     */
    public java.lang.Object[] getDescripcionesAsArray();

    /**
     * Resets the <code>descripciones</code> field.
     */
    public void resetDescripciones();

    /**
     * Sets the <code>path</code> field.
     *
     * 
     */
    public void setPath(java.lang.String path);

    /**
     * Gets the <code>path</code> field.
     *
     * 
     */
    public java.lang.String getPath();
    
    /**
     * Resets the <code>path</code> field.
     */
    public void resetPath();

}
