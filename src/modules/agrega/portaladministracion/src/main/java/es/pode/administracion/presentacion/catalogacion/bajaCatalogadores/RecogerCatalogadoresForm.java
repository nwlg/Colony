// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.bajaCatalogadores;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recogerCatalogadores</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController</code> controller.
 *
 * <p>
 * recupera los grupos de trabajo que se han seleccionado para ser
 * eliminados
 * </p>
 *
 * @see es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController#recogerCatalogadores
 */
public interface RecogerCatalogadoresForm
{
    /**
     * Sets the <code>usuariosAsociados</code> field.
     *
     * 
     */
    public void setUsuariosAsociados(java.lang.Boolean usuariosAsociados);

    /**
     * Gets the <code>usuariosAsociados</code> field.
     *
     * 
     */
    public java.lang.Boolean getUsuariosAsociados();
    
    /**
     * Resets the <code>usuariosAsociados</code> field.
     */
    public void resetUsuariosAsociados();

    /**
     * Sets the <code>listaId</code> field.
     *
     * 
     */
    public void setListaId(java.lang.String listaId);

    /**
     * Gets the <code>listaId</code> field.
     *
     * 
     */
    public java.lang.String getListaId();
    
    /**
     * Resets the <code>listaId</code> field.
     */
    public void resetListaId();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.Collection)
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
     * Sets the <code>gruposTrabajo</code> field.
     *
     * 
     */
    public void setGruposTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO[] gruposTrabajo);

    /**
     * Gets the <code>gruposTrabajo</code> field.
     *
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO[] getGruposTrabajo();
    
    /**
     * Resets the <code>gruposTrabajo</code> field.
     */
    public void resetGruposTrabajo();

}
