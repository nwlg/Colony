// license-header java merge-point
package es.pode.administracion.presentacion.planificador.crearTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarFechaActual</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaController</code> controller.
 *
 * <p>
 * Se carga la fecha de hoy como fecha de inicio de la tarea
 * </p>
 *
 * @see es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaController#cargarFechaActual
 */
public interface CargarFechaActualForm
{
    /**
     * Sets the <code>anio</code> field.
     *
     * 
     */
    public void setAnio(java.lang.String anio);

    /**
     * Gets the <code>anio</code> field.
     *
     * 
     */
    public java.lang.String getAnio();
    
    /**
     * Resets the <code>anio</code> field.
     */
    public void resetAnio();

    /**
     * Sets the <code>mes</code> field.
     *
     * 
     */
    public void setMes(java.lang.String mes);

    /**
     * Gets the <code>mes</code> field.
     *
     * 
     */
    public java.lang.String getMes();
    
    /**
     * Resets the <code>mes</code> field.
     */
    public void resetMes();

    /**
     * Sets the <code>dia</code> field.
     *
     * 
     */
    public void setDia(java.lang.String dia);

    /**
     * Gets the <code>dia</code> field.
     *
     * 
     */
    public java.lang.String getDia();
    
    /**
     * Resets the <code>dia</code> field.
     */
    public void resetDia();

}
