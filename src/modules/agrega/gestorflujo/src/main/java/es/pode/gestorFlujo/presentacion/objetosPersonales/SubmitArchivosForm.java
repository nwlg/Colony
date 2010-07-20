// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitArchivos</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController</code> controller.
 *
 * <p>
 * Necesitamos pasar un idoOdeRowSelection y un parámetro, pero
 * esto no lo permite ibuilder, así que necesitamos de una
 * transición para reempaquetar los datos que nos vienen en uno
 * nuevo y en el dato que queremos pasar, que en este caso es el
 * origen de la llamada.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController#submitArchivos
 */
public interface SubmitArchivosForm
{
    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * <p>
     * Identificadores de los ODEs que se seleciconan para ser
     * eliminados.
     * </p>
     *
     * @see #setIdODERowSelection#sArray(java.lang.String[])
     */
    public void setIdODERowSelection(java.util.List idODERowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * <p>
     * Identificadores de los ODEs que se seleciconan para ser
     * eliminados.
     * </p>
     *
     * @see #getIdODERowSelection#sArray()
     */
    public java.util.List getIdODERowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * <p>
     * Identificadores de los ODEs que se seleciconan para ser
     * eliminados.
     * </p>
     *
     * @see #setIdODERowSelection(java.util.List)
     */
    public void setIdODERowSelectionAsArray(java.lang.String[] idODERowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Identificadores de los ODEs que se seleciconan para ser
     * eliminados.
     * </p>
     *
     * @see #getIdODERowSelection()
     */
    public java.lang.String[] getIdODERowSelectionAsArray();

    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

    /**
     * Sets the <code>listODEs</code> field.
     *
     * 
     */
    public void setListODEs(java.lang.String[] listODEs);

    /**
     * Gets the <code>listODEs</code> field.
     *
     * 
     */
    public java.lang.String[] getListODEs();
    
    /**
     * Resets the <code>listODEs</code> field.
     */
    public void resetListODEs();

    /**
     * Sets the <code>origen</code> field.
     *
     * 
     */
    public void setOrigen(java.lang.String origen);

    /**
     * Gets the <code>origen</code> field.
     *
     * 
     */
    public java.lang.String getOrigen();
    
    /**
     * Resets the <code>origen</code> field.
     */
    public void resetOrigen();

}
