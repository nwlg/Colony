// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarDePortapapeles</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController</code> controller.
 *
 * <p>
 * Elimina un elemento del portapapeles.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController#eliminarDePortapapeles
 */
public interface EliminarDePortapapelesForm
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

}
