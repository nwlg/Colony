// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarRelaciones</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController#cargarRelaciones
 */
public interface CargarRelacionesForm
{
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

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoRelaciones#sArray(Object[])
     */
    public void setListadoRelaciones(java.util.Collection listadoRelaciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoRelaciones#sArray()
     */
    public java.util.Collection getListadoRelaciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoRelaciones(java.util.Collection)
     */
    public void setListadoRelacionesAsArray(Object[] listadoRelaciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoRelaciones()
     */
    public java.lang.Object[] getListadoRelacionesAsArray();

    /**
     * Resets the <code>listadoRelaciones</code> field.
     */
    public void resetListadoRelaciones();

}
