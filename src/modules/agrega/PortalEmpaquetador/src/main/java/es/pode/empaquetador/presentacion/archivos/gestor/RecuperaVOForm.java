// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperaVO</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController#recuperaVO
 */
public interface RecuperaVOForm
{
    /**
     * Sets the <code>extension</code> field.
     *
     * 
     */
    public void setExtension(java.lang.String extension);

    /**
     * Gets the <code>extension</code> field.
     *
     * 
     */
    public java.lang.String getExtension();
    
    /**
     * Resets the <code>extension</code> field.
     */
    public void resetExtension();

    /**
     * Sets the <code>nombre</code> field.
     *
     * <p>
     * Nombre del archivo o carpeta seleccionado.
     * </p>
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * <p>
     * Nombre del archivo o carpeta seleccionado.
     * </p>
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

    /**
     * Sets the <code>archivoVO</code> field.
     *
     * 
     */
    public void setArchivoVO(es.pode.empaquetador.negocio.servicio.ArchivoVO archivoVO);

    /**
     * Gets the <code>archivoVO</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO getArchivoVO();
    
    /**
     * Resets the <code>archivoVO</code> field.
     */
    public void resetArchivoVO();

}
