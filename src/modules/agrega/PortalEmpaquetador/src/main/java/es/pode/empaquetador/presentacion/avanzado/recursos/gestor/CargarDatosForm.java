// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController#cargarDatos
 */
public interface CargarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Listado de los recursos disponibles en el manifiesto.
     * </p>
     *
     * @see #setListado#sArray(Object[])
     */
    public void setListado(java.util.List listado);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Listado de los recursos disponibles en el manifiesto.
     * </p>
     *
     * @see #getListado#sArray()
     */
    public java.util.List getListado();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Listado de los recursos disponibles en el manifiesto.
     * </p>
     *
     * @see #setListado(java.util.List)
     */
    public void setListadoAsArray(Object[] listado);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Listado de los recursos disponibles en el manifiesto.
     * </p>
     *
     * @see #getListado()
     */
    public java.lang.Object[] getListadoAsArray();

    /**
     * Resets the <code>listado</code> field.
     */
    public void resetListado();

}
