// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>sumarArchivos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController#sumarArchivos
 */
public interface SumarArchivosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setArchivosSeleccionados#sArray(Object[])
     */
    public void setArchivosSeleccionados(java.util.List archivosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArchivosSeleccionados#sArray()
     */
    public java.util.List getArchivosSeleccionados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArchivosSeleccionados(java.util.List)
     */
    public void setArchivosSeleccionadosAsArray(Object[] archivosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArchivosSeleccionados()
     */
    public java.lang.Object[] getArchivosSeleccionadosAsArray();

    /**
     * Resets the <code>archivosSeleccionados</code> field.
     */
    public void resetArchivosSeleccionados();

}
