// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarGrupo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDescripcion</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGruposController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGruposController#cargarDescripcion
 */
public interface CargarDescripcionForm
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
