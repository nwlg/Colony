// license-header java merge-point
package es.pode.administracion.presentacion.nodos.bajaNodo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>bajaNodo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController#bajaNodo
 */
public interface BajaNodoForm
{
    /**
     * Sets the <code>nodosBorrados</code> field.
     *
     * 
     */
    public void setNodosBorrados(es.pode.buscar.negocio.administrar.servicio.NodoVO[] nodosBorrados);

    /**
     * Gets the <code>nodosBorrados</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO[] getNodosBorrados();
    
    /**
     * Resets the <code>nodosBorrados</code> field.
     */
    public void resetNodosBorrados();

    /**
     * Sets the <code>listaId</code> field.
     *
     * 
     */
    public void setListaId(java.lang.String listaId);

    /**
     * Gets the <code>listaId</code> field.
     *
     * 
     */
    public java.lang.String getListaId();
    
    /**
     * Resets the <code>listaId</code> field.
     */
    public void resetListaId();

    /**
     * Sets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public void setDescripcionBaja(java.lang.String descripcionBaja);

    /**
     * Gets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public java.lang.String getDescripcionBaja();
    
    /**
     * Resets the <code>descripcionBaja</code> field.
     */
    public void resetDescripcionBaja();

}
