// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarClasificacion</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionController#cargarClasificacion
 */
public interface CargarClasificacionForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoClasificacion#sArray(Object[])
     */
    public void setListadoClasificacion(java.util.Collection listadoClasificacion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoClasificacion#sArray()
     */
    public java.util.Collection getListadoClasificacion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoClasificacion(java.util.Collection)
     */
    public void setListadoClasificacionAsArray(Object[] listadoClasificacion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoClasificacion()
     */
    public java.lang.Object[] getListadoClasificacionAsArray();

    /**
     * Resets the <code>listadoClasificacion</code> field.
     */
    public void resetListadoClasificacion();

    /**
     * Sets the <code>identificadorOde</code> field.
     *
     * 
     */
    public void setIdentificadorOde(java.lang.String identificadorOde);

    /**
     * Gets the <code>identificadorOde</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorOde();
    
    /**
     * Resets the <code>identificadorOde</code> field.
     */
    public void resetIdentificadorOde();

}
