// license-header java merge-point
package es.pode.tagging.presentacion.listarMisTags;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.listarMisTags.ListarMisTagsController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.listarMisTags.ListarMisTagsController#submit
 */
public interface SubmitForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTagsEliminar#sArray(Object[])
     */
    public void setTagsEliminar(java.util.Collection tagsEliminar);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTagsEliminar#sArray()
     */
    public java.util.Collection getTagsEliminar();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTagsEliminar(java.util.Collection)
     */
    public void setTagsEliminarAsArray(Object[] tagsEliminar);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTagsEliminar()
     */
    public java.lang.Object[] getTagsEliminarAsArray();

    /**
     * Resets the <code>tagsEliminar</code> field.
     */
    public void resetTagsEliminar();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTagRowSelection#sArray(java.lang.String[])
     */
    public void setTagRowSelection(java.util.List tagRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTagRowSelection#sArray()
     */
    public java.util.List getTagRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setTagRowSelection(java.util.List)
     */
    public void setTagRowSelectionAsArray(java.lang.String[] tagRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTagRowSelection()
     */
    public java.lang.String[] getTagRowSelectionAsArray();

    /**
     * Resets the <code>tag</code> field.
     */
    public void resetTag();

    /**
     * Sets the <code>accion</code> field.
     *
     * 
     */
    public void setAccion(java.lang.String accion);

    /**
     * Gets the <code>accion</code> field.
     *
     * 
     */
    public java.lang.String getAccion();
    
    /**
     * Resets the <code>accion</code> field.
     */
    public void resetAccion();

}
