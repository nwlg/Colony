// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController</code> controller.
 *
 * <p>
 * almacena los datos del usuario en sesion para despues de
 * seleccionar los grupos almacenarlo en base de datos
 * </p>
 *
 * @see es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController#submit
 */
public interface SubmitForm
{
    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdRowSelection#sArray(java.lang.String[])
     */
    public void setIdRowSelection(java.util.List idRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdRowSelection#sArray()
     */
    public java.util.List getIdRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setIdRowSelection(java.util.List)
     */
    public void setIdRowSelectionAsArray(java.lang.String[] idRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdRowSelection()
     */
    public java.lang.String[] getIdRowSelectionAsArray();

    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

}
