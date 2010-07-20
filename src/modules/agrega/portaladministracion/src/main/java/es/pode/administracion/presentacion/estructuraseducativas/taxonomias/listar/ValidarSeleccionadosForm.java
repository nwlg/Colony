// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarSeleccionados</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar.ListarTaxonomiasController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar.ListarTaxonomiasController#validarSeleccionados
 */
public interface ValidarSeleccionadosForm
{
    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setSeleccionadoRowSelection#sArray(java.lang.String[])
     */
    public void setSeleccionadoRowSelection(java.util.List seleccionadoRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getSeleccionadoRowSelection#sArray()
     */
    public java.util.List getSeleccionadoRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setSeleccionadoRowSelection(java.util.List)
     */
    public void setSeleccionadoRowSelectionAsArray(java.lang.String[] seleccionadoRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getSeleccionadoRowSelection()
     */
    public java.lang.String[] getSeleccionadoRowSelectionAsArray();

    /**
     * Resets the <code>seleccionado</code> field.
     */
    public void resetSeleccionado();

}
