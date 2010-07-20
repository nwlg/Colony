// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.principal;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.principal.PrincipalController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.principal.PrincipalController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de FileVO
     * </p>
     *
     * @see #setFicheros#sArray(Object[])
     */
    public void setFicheros(java.util.List ficheros);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de FileVO
     * </p>
     *
     * @see #getFicheros#sArray()
     */
    public java.util.List getFicheros();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de FileVO
     * </p>
     *
     * @see #setFicheros(java.util.List)
     */
    public void setFicherosAsArray(Object[] ficheros);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de FileVO
     * </p>
     *
     * @see #getFicheros()
     */
    public java.lang.Object[] getFicherosAsArray();

    /**
     * Resets the <code>ficheros</code> field.
     */
    public void resetFicheros();

    /**
     * Sets the <code>principal</code> field.
     *
     * 
     */
    public void setPrincipal(java.lang.String principal);

    /**
     * Gets the <code>principal</code> field.
     *
     * 
     */
    public java.lang.String getPrincipal();
    
    /**
     * Resets the <code>principal</code> field.
     */
    public void resetPrincipal();

    /**
     * Sets the <code>idRecurso</code> field.
     *
     * 
     */
    public void setIdRecurso(java.lang.String idRecurso);

    /**
     * Gets the <code>idRecurso</code> field.
     *
     * 
     */
    public java.lang.String getIdRecurso();
    
    /**
     * Resets the <code>idRecurso</code> field.
     */
    public void resetIdRecurso();

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
