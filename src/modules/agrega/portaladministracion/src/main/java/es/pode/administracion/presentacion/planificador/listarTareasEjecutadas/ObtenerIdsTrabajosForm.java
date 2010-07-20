// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasEjecutadas;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerIdsTrabajos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.listarTareasEjecutadas.TareasEjecutadasController</code> controller.
 *
 * <p>
 * Obtiene los identificadores de aquellos trabajos que van a ser
 * eliminados
 * </p>
 *
 * @see es.pode.administracion.presentacion.planificador.listarTareasEjecutadas.TareasEjecutadasController#obtenerIdsTrabajos
 */
public interface ObtenerIdsTrabajosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.Collection)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

}
