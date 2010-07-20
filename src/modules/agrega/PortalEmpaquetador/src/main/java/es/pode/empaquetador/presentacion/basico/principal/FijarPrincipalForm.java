// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.principal;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>fijarPrincipal</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.principal.PrincipalController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.principal.PrincipalController#fijarPrincipal
 */
public interface FijarPrincipalForm
{
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
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.String getPrincipalOptionValue(int optionIndex);

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
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

}
