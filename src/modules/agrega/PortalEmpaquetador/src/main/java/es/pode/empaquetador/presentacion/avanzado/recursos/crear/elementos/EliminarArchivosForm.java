// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarArchivos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController#eliminarArchivos
 */
public interface EliminarArchivosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setArchivos#sArray(Object[])
     */
    public void setArchivos(java.util.List archivos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArchivos#sArray()
     */
    public java.util.List getArchivos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArchivos(java.util.List)
     */
    public void setArchivosAsArray(Object[] archivos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArchivos()
     */
    public java.lang.Object[] getArchivosAsArray();

    /**
     * Resets the <code>archivos</code> field.
     */
    public void resetArchivos();

}
