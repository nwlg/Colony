// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>modificarTareaInformeFederado</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController</code> controller.
 *
 * <p>
 * modifica la tarea de informe federado con los nuevos datos
 * </p>
 *
 * @see es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController#modificarTareaInformeFederado
 */
public interface ModificarTareaInformeFederadoForm
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
