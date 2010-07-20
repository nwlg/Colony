// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardarMetadatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController#guardarMetadatos
 */
public interface GuardarMetadatosForm
{
    /**
     * Sets the <code>usuario</code> field.
     *
     * 
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * 
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

    /**
     * Sets the <code>identificador</code> field.
     *
     * 
     */
    public void setIdentificador(java.lang.String identificador);

    /**
     * Gets the <code>identificador</code> field.
     *
     * 
     */
    public java.lang.String getIdentificador();
    
    /**
     * Resets the <code>identificador</code> field.
     */
    public void resetIdentificador();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDatos#sArray(Object[])
     */
    public void setDatos(java.util.Collection datos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDatos#sArray()
     */
    public java.util.Collection getDatos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDatos(java.util.Collection)
     */
    public void setDatosAsArray(Object[] datos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDatos()
     */
    public java.lang.Object[] getDatosAsArray();

    /**
     * Resets the <code>datos</code> field.
     */
    public void resetDatos();

}
