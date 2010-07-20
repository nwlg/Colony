// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerTareas</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.eliminarTarea.EliminarTareasController</code> controller.
 *
 * <p>
 * Obtiene las tareas que van a ser eliminadas
 * </p>
 *
 * @see es.pode.administracion.presentacion.planificador.eliminarTarea.EliminarTareasController#obtenerTareas
 */
public interface ObtenerTareasForm
{
    /**
     * Sets the <code>listaTrabajo</code> field.
     *
     * <p>
     * Array de string con las tareas que se desean eliminar
     * </p>
     */
    public void setListaTrabajo(java.lang.String[] listaTrabajo);

    /**
     * Gets the <code>listaTrabajo</code> field.
     *
     * <p>
     * Array de string con las tareas que se desean eliminar
     * </p>
     */
    public java.lang.String[] getListaTrabajo();
    
    /**
     * Resets the <code>listaTrabajo</code> field.
     */
    public void resetListaTrabajo();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTrabajos#sArray(Object[])
     */
    public void setTrabajos(java.util.Collection trabajos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTrabajos#sArray()
     */
    public java.util.Collection getTrabajos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTrabajos(java.util.Collection)
     */
    public void setTrabajosAsArray(Object[] trabajos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTrabajos()
     */
    public java.lang.Object[] getTrabajosAsArray();

    /**
     * Resets the <code>trabajos</code> field.
     */
    public void resetTrabajos();

    /**
     * Sets the <code>listaTrabajoPlana</code> field.
     *
     * 
     */
    public void setListaTrabajoPlana(java.lang.String listaTrabajoPlana);

    /**
     * Gets the <code>listaTrabajoPlana</code> field.
     *
     * 
     */
    public java.lang.String getListaTrabajoPlana();
    
    /**
     * Resets the <code>listaTrabajoPlana</code> field.
     */
    public void resetListaTrabajoPlana();

}
