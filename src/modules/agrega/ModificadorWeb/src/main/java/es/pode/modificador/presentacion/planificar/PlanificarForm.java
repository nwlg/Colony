// license-header java merge-point
package es.pode.modificador.presentacion.planificar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>planificar</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.planificar.PlanificarController</code> controller.
 *
 * <p>
 * Esta llamada convierte la fecha a Calendar usando la zona
 * horaria de las preferencias del servidor en el que se ejecuta y
 * llama al servicio de planificación del servicio
 * SrvHerramientaModificacion
 * </p>
 *
 * @see es.pode.modificador.presentacion.planificar.PlanificarController#planificar
 */
public interface PlanificarForm
{
    /**
     * Sets the <code>minutos</code> field.
     *
     * 
     */
    public void setMinutos(java.lang.String minutos);

    /**
     * Gets the <code>minutos</code> field.
     *
     * 
     */
    public java.lang.String getMinutos();
    
    /**
     * Resets the <code>minutos</code> field.
     */
    public void resetMinutos();

    /**
     * Sets the <code>fecha</code> field.
     *
     * 
     */
    public void setFecha(java.lang.String fecha);

    /**
     * Gets the <code>fecha</code> field.
     *
     * 
     */
    public java.lang.String getFecha();
    
    /**
     * Resets the <code>fecha</code> field.
     */
    public void resetFecha();

    /**
     * Sets the <code>horas</code> field.
     *
     * 
     */
    public void setHoras(java.lang.String horas);

    /**
     * Gets the <code>horas</code> field.
     *
     * 
     */
    public java.lang.String getHoras();
    
    /**
     * Resets the <code>horas</code> field.
     */
    public void resetHoras();

    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

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
