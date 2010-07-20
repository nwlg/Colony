// license-header java merge-point
package es.pode.empaquetador.presentacion.salir;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validacionOk</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.salir.SalirController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.salir.SalirController#validacionOk
 */
public interface ValidacionOkForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setMensajesError#sArray(Object[])
     */
    public void setMensajesError(java.util.List mensajesError);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getMensajesError#sArray()
     */
    public java.util.List getMensajesError();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setMensajesError(java.util.List)
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
