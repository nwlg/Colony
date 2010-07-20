// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.verCatalogadores;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDescripcion</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.catalogacion.verCatalogadores.verCatalogadoresController</code> controller.
 *
 * <p>
 * recupera la descripcion de un grupo de trabajo concreto
 * </p>
 *
 * @see es.pode.administracion.presentacion.catalogacion.verCatalogadores.verCatalogadoresController#recuperarDescripcion
 */
public interface RecuperarDescripcionForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.Long id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.Long getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

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
