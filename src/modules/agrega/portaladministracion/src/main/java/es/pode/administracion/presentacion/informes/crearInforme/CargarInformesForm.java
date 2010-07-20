// license-header java merge-point
package es.pode.administracion.presentacion.informes.crearInforme;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarInformes</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#cargarInformes
 */
public interface CargarInformesForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setInformes#sArray(Object[])
     */
    public void setInformes(java.util.List informes);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getInformes#sArray()
     */
    public java.util.List getInformes();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setInformes(java.util.List)
     */
    public void setInformesAsArray(Object[] informes);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getInformes()
     */
    public java.lang.Object[] getInformesAsArray();

    /**
     * Resets the <code>informes</code> field.
     */
    public void resetInformes();

}
