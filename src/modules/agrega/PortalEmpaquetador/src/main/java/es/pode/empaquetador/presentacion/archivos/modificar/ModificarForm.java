// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.modificar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>modificar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.modificar.ModificarArchivoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.archivos.modificar.ModificarArchivoController#modificar
 */
public interface ModificarForm
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

    /**
     * Sets the <code>nuevoNombre</code> field.
     *
     * 
     */
    public void setNuevoNombre(java.lang.String nuevoNombre);

    /**
     * Gets the <code>nuevoNombre</code> field.
     *
     * 
     */
    public java.lang.String getNuevoNombre();
    
    /**
     * Resets the <code>nuevoNombre</code> field.
     */
    public void resetNuevoNombre();

    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

}
