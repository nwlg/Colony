// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.principal;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.principal.OrganizacionPrincipalController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.principal.OrganizacionPrincipalController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setOrganizaciones#sArray(Object[])
     */
    public void setOrganizaciones(java.util.List organizaciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getOrganizaciones#sArray()
     */
    public java.util.List getOrganizaciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setOrganizaciones(java.util.List)
     */
    public void setOrganizacionesAsArray(Object[] organizaciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getOrganizaciones()
     */
    public java.lang.Object[] getOrganizacionesAsArray();

    /**
     * Resets the <code>organizaciones</code> field.
     */
    public void resetOrganizaciones();

    /**
     * Sets the <code>identifier</code> field.
     *
     * 
     */
    public void setIdentifier(java.lang.String identifier);

    /**
     * Gets the <code>identifier</code> field.
     *
     * 
     */
    public java.lang.String getIdentifier();
    
    /**
     * Resets the <code>identifier</code> field.
     */
    public void resetIdentifier();

}
