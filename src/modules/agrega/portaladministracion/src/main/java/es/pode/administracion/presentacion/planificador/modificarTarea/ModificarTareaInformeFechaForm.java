// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>modificarTareaInformeFecha</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController#modificarTareaInformeFecha
 */
public interface ModificarTareaInformeFechaForm
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
