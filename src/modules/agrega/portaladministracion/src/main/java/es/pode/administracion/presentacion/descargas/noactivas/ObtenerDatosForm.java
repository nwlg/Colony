// license-header java merge-point
package es.pode.administracion.presentacion.descargas.noactivas;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerDatos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.descargas.noactivas.NoActivasController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.descargas.noactivas.NoActivasController#obtenerDatos
 */
public interface ObtenerDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescargas#sArray(Object[])
     */
    public void setDescargas(java.util.List descargas);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescargas#sArray()
     */
    public java.util.List getDescargas();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescargas(java.util.List)
     */
    public void setDescargasAsArray(Object[] descargas);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescargas()
     */
    public java.lang.Object[] getDescargasAsArray();

    /**
     * Resets the <code>descargas</code> field.
     */
    public void resetDescargas();

}
