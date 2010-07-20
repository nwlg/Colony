// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformes;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>listarInformes</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController#listarInformes
 */
public interface ListarInformesForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setInformes#sArray(Object[])
     */
    public void setInformes(java.util.Collection informes);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getInformes#sArray()
     */
    public java.util.Collection getInformes();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setInformes(java.util.Collection)
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
