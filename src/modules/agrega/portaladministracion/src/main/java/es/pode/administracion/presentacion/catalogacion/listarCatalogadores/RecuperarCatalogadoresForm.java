// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.listarCatalogadores;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarCatalogadores</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.catalogacion.listarCatalogadores.listarCatalogadoresController</code> controller.
 *
 * <p>
 * devuleve los grupos de trabajo que estan almacenados en base de
 * datos
 * </p>
 *
 * @see es.pode.administracion.presentacion.catalogacion.listarCatalogadores.listarCatalogadoresController#recuperarCatalogadores
 */
public interface RecuperarCatalogadoresForm
{
    /**
     * Sets the <code>idModificado</code> field.
     *
     * 
     */
    public void setIdModificado(java.lang.Long idModificado);

    /**
     * Gets the <code>idModificado</code> field.
     *
     * 
     */
    public java.lang.Long getIdModificado();
    
    /**
     * Resets the <code>idModificado</code> field.
     */
    public void resetIdModificado();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setGruposTrabajo#sArray(Object[])
     */
    public void setGruposTrabajo(java.util.Collection gruposTrabajo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getGruposTrabajo#sArray()
     */
    public java.util.Collection getGruposTrabajo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setGruposTrabajo(java.util.Collection)
     */
    public void setGruposTrabajoAsArray(Object[] gruposTrabajo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getGruposTrabajo()
     */
    public java.lang.Object[] getGruposTrabajoAsArray();

    /**
     * Resets the <code>gruposTrabajo</code> field.
     */
    public void resetGruposTrabajo();

}
