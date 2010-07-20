// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>esValido</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.validar.ValidarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.validar.ValidarController#esValido
 */
public interface EsValidoForm
{
    /**
     * Sets the <code>validaVO</code> field.
     *
     * 
     */
    public void setValidaVO(es.pode.empaquetador.negocio.servicio.ValidaVO validaVO);

    /**
     * Gets the <code>validaVO</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ValidaVO getValidaVO();
    
    /**
     * Resets the <code>validaVO</code> field.
     */
    public void resetValidaVO();

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
