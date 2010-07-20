// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarAnotaciones</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.AnotacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.AnotacionController#cargarAnotaciones
 */
public interface CargarAnotacionesForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoAnotaciones#sArray(Object[])
     */
    public void setListadoAnotaciones(java.util.Collection listadoAnotaciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoAnotaciones#sArray()
     */
    public java.util.Collection getListadoAnotaciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoAnotaciones(java.util.Collection)
     */
    public void setListadoAnotacionesAsArray(Object[] listadoAnotaciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoAnotaciones()
     */
    public java.lang.Object[] getListadoAnotacionesAsArray();

    /**
     * Resets the <code>listadoAnotaciones</code> field.
     */
    public void resetListadoAnotaciones();

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
