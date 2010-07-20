// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarODESPendientesCatalogacion</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.ObjetosPendientesCatalogacionController</code> controller.
 *
 * <p>
 * Muestra todos los odes del nodo (los de todos los usuarios del
 * nodo) que están en estado propuesto para catalogacion.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.ObjetosPendientesCatalogacionController#cargarODESPendientesCatalogacion
 */
public interface CargarODESPendientesCatalogacionForm
{
    /**
     * Sets the <code>idUsuario</code> field.
     *
     * 
     */
    public void setIdUsuario(java.lang.String idUsuario);

    /**
     * Gets the <code>idUsuario</code> field.
     *
     * 
     */
    public java.lang.String getIdUsuario();
    
    /**
     * Resets the <code>idUsuario</code> field.
     */
    public void resetIdUsuario();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListaODES#sArray(Object[])
     */
    public void setListaODES(java.util.Collection listaODES);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListaODES#sArray()
     */
    public java.util.Collection getListaODES();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListaODES(java.util.Collection)
     */
    public void setListaODESAsArray(Object[] listaODES);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListaODES()
     */
    public java.lang.Object[] getListaODESAsArray();

    /**
     * Resets the <code>listaODES</code> field.
     */
    public void resetListaODES();

}
