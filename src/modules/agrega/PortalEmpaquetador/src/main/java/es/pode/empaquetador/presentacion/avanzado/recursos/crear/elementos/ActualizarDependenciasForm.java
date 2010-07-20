// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>actualizarDependencias</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController#actualizarDependencias
 */
public interface ActualizarDependenciasForm
{
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

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDependencias#sArray(Object[])
     */
    public void setDependencias(java.util.List dependencias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDependencias#sArray()
     */
    public java.util.List getDependencias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDependencias(java.util.List)
     */
    public void setDependenciasAsArray(Object[] dependencias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDependencias()
     */
    public java.lang.Object[] getDependenciasAsArray();

    /**
     * Resets the <code>dependencias</code> field.
     */
    public void resetDependencias();

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
