// license-header java merge-point
package es.pode.administracion.presentacion.planificador.pararTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>pararTrabajo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.pararTarea.PararTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.pararTarea.PararTareaController#pararTrabajo
 */
public interface PararTrabajoForm
{
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

}
