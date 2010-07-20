// license-header java merge-point
package es.pode.modificador.presentacion.pendientes;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarTarea</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController#recuperarTarea
 */
public interface RecuperarTareaForm
{
    /**
     * Sets the <code>tarea</code> field.
     *
     * 
     */
    public void setTarea(es.pode.modificador.negocio.servicio.ConfiguracionTarea tarea);

    /**
     * Gets the <code>tarea</code> field.
     *
     * 
     */
    public es.pode.modificador.negocio.servicio.ConfiguracionTarea getTarea();
    
    /**
     * Resets the <code>tarea</code> field.
     */
    public void resetTarea();

    /**
     * Sets the <code>idModificacion</code> field.
     *
     * 
     */
    public void setIdModificacion(java.lang.String idModificacion);

    /**
     * Gets the <code>idModificacion</code> field.
     *
     * 
     */
    public java.lang.String getIdModificacion();
    
    /**
     * Resets the <code>idModificacion</code> field.
     */
    public void resetIdModificacion();

}
