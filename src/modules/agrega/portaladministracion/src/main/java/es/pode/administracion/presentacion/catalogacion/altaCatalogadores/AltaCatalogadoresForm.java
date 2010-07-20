// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.altaCatalogadores;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>altaCatalogadores</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.catalogacion.altaCatalogadores.AltaCatalogadoresController</code> controller.
 *
 * <p>
 * metodo que da de alta un grupo de trabajo
 * </p>
 *
 * @see es.pode.administracion.presentacion.catalogacion.altaCatalogadores.AltaCatalogadoresController#altaCatalogadores
 */
public interface AltaCatalogadoresForm
{
    /**
     * Sets the <code>nombre</code> field.
     *
     * 
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * 
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

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
     * Sets the <code>descripcion</code> field.
     *
     * 
     */
    public void setDescripcion(java.lang.String descripcion);

    /**
     * Gets the <code>descripcion</code> field.
     *
     * 
     */
    public java.lang.String getDescripcion();
    
    /**
     * Resets the <code>descripcion</code> field.
     */
    public void resetDescripcion();

}
