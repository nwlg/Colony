// license-header java merge-point
package es.pode.administracion.presentacion.descargas.activas;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.descargas.activas.ActivasController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#submit
 */
public interface SubmitForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.List ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.List getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.List)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdentificadorRowSelection#sArray(java.lang.String[])
     */
    public void setIdentificadorRowSelection(java.util.List identificadorRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdentificadorRowSelection#sArray()
     */
    public java.util.List getIdentificadorRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setIdentificadorRowSelection(java.util.List)
     */
    public void setIdentificadorRowSelectionAsArray(java.lang.String[] identificadorRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdentificadorRowSelection()
     */
    public java.lang.String[] getIdentificadorRowSelectionAsArray();

    /**
     * Resets the <code>identificador</code> field.
     */
    public void resetIdentificador();

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
