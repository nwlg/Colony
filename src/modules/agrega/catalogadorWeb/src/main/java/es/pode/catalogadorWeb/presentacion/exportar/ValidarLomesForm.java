// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.exportar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarLomes</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.exportar.ExportarController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.exportar.ExportarController#validarLomes
 */
public interface ValidarLomesForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setMensajesError#sArray(Object[])
     */
    public void setMensajesError(java.util.Collection mensajesError);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getMensajesError#sArray()
     */
    public java.util.Collection getMensajesError();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setMensajesError(java.util.Collection)
     */
    public void setMensajesErrorAsArray(Object[] mensajesError);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getMensajesError()
     */
    public java.lang.Object[] getMensajesErrorAsArray();

    /**
     * Resets the <code>mensajesError</code> field.
     */
    public void resetMensajesError();

}
