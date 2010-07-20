// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.bajaGrupo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>bajaGrupo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.bajaGrupo.BajaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.bajaGrupo.BajaController#bajaGrupo
 */
public interface BajaGrupoForm
{
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
     * Sets the <code>gruposDeleted</code> field.
     *
     * 
     */
    public void setGruposDeleted(es.pode.adminusuarios.negocio.servicios.GrupoVO[] gruposDeleted);

    /**
     * Gets the <code>gruposDeleted</code> field.
     *
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoVO[] getGruposDeleted();
    
    /**
     * Resets the <code>gruposDeleted</code> field.
     */
    public void resetGruposDeleted();

    /**
     * Sets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public void setDescripcionBaja(java.lang.String descripcionBaja);

    /**
     * Gets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public java.lang.String getDescripcionBaja();
    
    /**
     * Resets the <code>descripcionBaja</code> field.
     */
    public void resetDescripcionBaja();

}
