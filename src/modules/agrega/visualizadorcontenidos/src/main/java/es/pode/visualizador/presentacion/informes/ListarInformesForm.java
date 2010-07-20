// license-header java merge-point
package es.pode.visualizador.presentacion.informes;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>listarInformes</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.informes.ListarInformesController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.informes.ListarInformesController#listarInformes
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

    /**
     * Sets the <code>pathInformes</code> field.
     *
     * 
     */
    public void setPathInformes(java.lang.String pathInformes);

    /**
     * Gets the <code>pathInformes</code> field.
     *
     * 
     */
    public java.lang.String getPathInformes();
    
    /**
     * Resets the <code>pathInformes</code> field.
     */
    public void resetPathInformes();

}
