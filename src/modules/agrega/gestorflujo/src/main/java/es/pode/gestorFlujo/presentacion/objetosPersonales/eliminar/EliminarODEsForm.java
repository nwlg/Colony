// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarODEs</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar.eliminarPersonalesController</code> controller.
 *
 * <p>
 * Elimina los odes que haya seleccionado el usuario, es el
 * controller que llama al servicio.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar.eliminarPersonalesController#eliminarODEs
 */
public interface EliminarODEsForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTitulos#sArray(Object[])
     */
    public void setTitulos(java.util.Collection titulos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTitulos#sArray()
     */
    public java.util.Collection getTitulos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTitulos(java.util.Collection)
     */
    public void setTitulosAsArray(Object[] titulos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTitulos()
     */
    public java.lang.Object[] getTitulosAsArray();

    /**
     * Resets the <code>titulos</code> field.
     */
    public void resetTitulos();

}
