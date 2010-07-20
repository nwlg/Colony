// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController</code> controller.
 *
 * <p>
 * Recoge los identificadores seleccionados y recupera los objetos
 * RecursoVO para pasarselos a la actividad seleccionada. Ademas,
 * en funcion de los datos pasados y del action recibido, realiza
 * una validacion para asegurar que hay recursos seleccionados
 * cuando se pretende Eliminar o Exportar Recursos.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController#submit
 */
public interface SubmitForm
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

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRecursosVO#sArray(Object[])
     */
    public void setRecursosVO(java.util.List recursosVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRecursosVO#sArray()
     */
    public java.util.List getRecursosVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRecursosVO(java.util.List)
     */
    public void setRecursosVOAsArray(Object[] recursosVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRecursosVO()
     */
    public java.lang.Object[] getRecursosVOAsArray();

    /**
     * Resets the <code>recursosVO</code> field.
     */
    public void resetRecursosVO();

}
