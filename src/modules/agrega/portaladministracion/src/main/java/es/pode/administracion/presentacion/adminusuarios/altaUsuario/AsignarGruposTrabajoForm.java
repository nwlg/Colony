// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>asignarGruposTrabajo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController</code> controller.
 *
 * <p>
 * Asigna al usuario los grupos de trabajo seleccionados
 * </p>
 *
 * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController#asignarGruposTrabajo
 */
public interface AsignarGruposTrabajoForm
{
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

}
