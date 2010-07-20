// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasPendientes;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerNombresTrabajos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.listarTareasPendientes.TareasPendientesController</code> controller.
 *
 * <p>
 * Obtiene las tareas pendientes seleccionados por el usuario que
 * van a ser eliminados
 * </p>
 *
 * @see es.pode.administracion.presentacion.planificador.listarTareasPendientes.TareasPendientesController#obtenerNombresTrabajos
 */
public interface ObtenerNombresTrabajosForm
{
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

}
