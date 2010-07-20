// license-header java merge-point
package es.pode.administracion.presentacion.planificador.descripcionTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerTipoTarea</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaController#obtenerTipoTarea
 */
public interface ObtenerTipoTareaForm
{
    /**
     * Sets the <code>trigger</code> field.
     *
     * 
     */
    public void setTrigger(java.lang.String trigger);

    /**
     * Gets the <code>trigger</code> field.
     *
     * 
     */
    public java.lang.String getTrigger();
    
    /**
     * Resets the <code>trigger</code> field.
     */
    public void resetTrigger();

    /**
     * Sets the <code>grupoTrigger</code> field.
     *
     * 
     */
    public void setGrupoTrigger(java.lang.String grupoTrigger);

    /**
     * Gets the <code>grupoTrigger</code> field.
     *
     * 
     */
    public java.lang.String getGrupoTrigger();
    
    /**
     * Resets the <code>grupoTrigger</code> field.
     */
    public void resetGrupoTrigger();

    /**
     * Sets the <code>trabajo</code> field.
     *
     * 
     */
    public void setTrabajo(java.lang.String trabajo);

    /**
     * Gets the <code>trabajo</code> field.
     *
     * 
     */
    public java.lang.String getTrabajo();
    
    /**
     * Resets the <code>trabajo</code> field.
     */
    public void resetTrabajo();

    /**
     * Sets the <code>grupoTrabajo</code> field.
     *
     * 
     */
    public void setGrupoTrabajo(java.lang.String grupoTrabajo);

    /**
     * Gets the <code>grupoTrabajo</code> field.
     *
     * 
     */
    public java.lang.String getGrupoTrabajo();
    
    /**
     * Resets the <code>grupoTrabajo</code> field.
     */
    public void resetGrupoTrabajo();

}
