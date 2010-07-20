// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController#submit
 */
public interface SubmitForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPaths#sArray(Object[])
     */
    public void setPaths(java.util.List paths);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPaths#sArray()
     */
    public java.util.List getPaths();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPaths(java.util.List)
     */
    public void setPathsAsArray(Object[] paths);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPaths()
     */
    public java.lang.Object[] getPathsAsArray();

    /**
     * Resets the <code>paths</code> field.
     */
    public void resetPaths();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setLocalizadorODERowSelection#sArray(java.lang.String[])
     */
    public void setLocalizadorODERowSelection(java.util.List localizadorODERowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getLocalizadorODERowSelection#sArray()
     */
    public java.util.List getLocalizadorODERowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setLocalizadorODERowSelection(java.util.List)
     */
    public void setLocalizadorODERowSelectionAsArray(java.lang.String[] localizadorODERowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getLocalizadorODERowSelection()
     */
    public java.lang.String[] getLocalizadorODERowSelectionAsArray();

    /**
     * Resets the <code>localizadorODE</code> field.
     */
    public void resetLocalizadorODE();

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
