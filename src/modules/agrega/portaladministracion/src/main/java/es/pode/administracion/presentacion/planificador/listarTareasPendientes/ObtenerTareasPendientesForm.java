// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasPendientes;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerTareasPendientes</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.listarTareasPendientes.TareasPendientesController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.listarTareasPendientes.TareasPendientesController#obtenerTareasPendientes
 */
public interface ObtenerTareasPendientesForm
{
    /**
     * Sets the <code>tareaModificada</code> field.
     *
     * 
     */
    public void setTareaModificada(java.lang.String tareaModificada);

    /**
     * Gets the <code>tareaModificada</code> field.
     *
     * 
     */
    public java.lang.String getTareaModificada();
    
    /**
     * Resets the <code>tareaModificada</code> field.
     */
    public void resetTareaModificada();

}
