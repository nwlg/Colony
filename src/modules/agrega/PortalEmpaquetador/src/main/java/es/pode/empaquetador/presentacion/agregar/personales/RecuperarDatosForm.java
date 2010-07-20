// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.personales;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPersonales#sArray(Object[])
     */
    public void setPersonales(java.util.List personales);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPersonales#sArray()
     */
    public java.util.List getPersonales();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPersonales(java.util.List)
     */
    public void setPersonalesAsArray(Object[] personales);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPersonales()
     */
    public java.lang.Object[] getPersonalesAsArray();

    /**
     * Resets the <code>personales</code> field.
     */
    public void resetPersonales();

    /**
     * Sets the <code>compartidos</code> field.
     *
     * 
     */
    public void setCompartidos(java.lang.String compartidos);

    /**
     * Gets the <code>compartidos</code> field.
     *
     * 
     */
    public java.lang.String getCompartidos();
    
    /**
     * Resets the <code>compartidos</code> field.
     */
    public void resetCompartidos();

}
