// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#submit
 */
public interface SubmitForm
{
    /**
     * Sets the <code>actionSubmit</code> field.
     *
     * 
     */
    public void setActionSubmit(java.lang.String actionSubmit);

    /**
     * Gets the <code>actionSubmit</code> field.
     *
     * 
     */
    public java.lang.String getActionSubmit();
    
    /**
     * Resets the <code>actionSubmit</code> field.
     */
    public void resetActionSubmit();

    /**
     * Sets the <code>actionCombo</code> field.
     *
     * 
     */
    public void setActionCombo(java.lang.String actionCombo);

    /**
     * Gets the <code>actionCombo</code> field.
     *
     * 
     */
    public java.lang.String getActionCombo();
    
    /**
     * Resets the <code>actionCombo</code> field.
     */
    public void resetActionCombo();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdentificadores#sArray(Object[])
     */
    public void setIdentificadores(java.util.List identificadores);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdentificadores#sArray()
     */
    public java.util.List getIdentificadores();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdentificadores(java.util.List)
     */
    public void setIdentificadoresAsArray(Object[] identificadores);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdentificadores()
     */
    public java.lang.Object[] getIdentificadoresAsArray();

    /**
     * Resets the <code>identificadores</code> field.
     */
    public void resetIdentificadores();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdentifierRowSelection#sArray(java.lang.String[])
     */
    public void setIdentifierRowSelection(java.util.List identifierRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdentifierRowSelection#sArray()
     */
    public java.util.List getIdentifierRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setIdentifierRowSelection(java.util.List)
     */
    public void setIdentifierRowSelectionAsArray(java.lang.String[] identifierRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdentifierRowSelection()
     */
    public java.lang.String[] getIdentifierRowSelectionAsArray();

    /**
     * Resets the <code>identifier</code> field.
     */
    public void resetIdentifier();

}
