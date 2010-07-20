// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTrabajoEjecutado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerTrabajos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.eliminarTrabajoEjecutado.EliminarTrabajoController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.eliminarTrabajoEjecutado.EliminarTrabajoController#obtenerTrabajos
 */
public interface ObtenerTrabajosForm
{
    /**
     * Sets the <code>listaIds</code> field.
     *
     * 
     */
    public void setListaIds(java.lang.String listaIds);

    /**
     * Gets the <code>listaIds</code> field.
     *
     * 
     */
    public java.lang.String getListaIds();
    
    /**
     * Resets the <code>listaIds</code> field.
     */
    public void resetListaIds();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.Collection)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * Sets the <code>listaNombres</code> field.
     *
     * 
     */
    public void setListaNombres(java.lang.String[] listaNombres);

    /**
     * Gets the <code>listaNombres</code> field.
     *
     * 
     */
    public java.lang.String[] getListaNombres();
    
    /**
     * Resets the <code>listaNombres</code> field.
     */
    public void resetListaNombres();

}
