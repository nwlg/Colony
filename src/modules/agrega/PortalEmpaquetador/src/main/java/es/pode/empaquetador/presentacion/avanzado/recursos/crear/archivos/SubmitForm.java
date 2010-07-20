// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController#submit
 */
public interface SubmitForm
{
    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNombreRowSelection#sArray(java.lang.String[])
     */
    public void setNombreRowSelection(java.util.List nombreRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNombreRowSelection#sArray()
     */
    public java.util.List getNombreRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setNombreRowSelection(java.util.List)
     */
    public void setNombreRowSelectionAsArray(java.lang.String[] nombreRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNombreRowSelection()
     */
    public java.lang.String[] getNombreRowSelectionAsArray();

    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

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
     * @see #setArchivosSeleccionados#sArray(Object[])
     */
    public void setArchivosSeleccionados(java.util.List archivosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArchivosSeleccionados#sArray()
     */
    public java.util.List getArchivosSeleccionados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArchivosSeleccionados(java.util.List)
     */
    public void setArchivosSeleccionadosAsArray(Object[] archivosSeleccionados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArchivosSeleccionados()
     */
    public java.lang.Object[] getArchivosSeleccionadosAsArray();

    /**
     * Resets the <code>archivosSeleccionados</code> field.
     */
    public void resetArchivosSeleccionados();

}
