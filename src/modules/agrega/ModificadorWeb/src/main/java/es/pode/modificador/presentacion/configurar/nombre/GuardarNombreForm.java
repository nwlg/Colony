// license-header java merge-point
package es.pode.modificador.presentacion.configurar.nombre;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardarNombre</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.nombre.ConfigurarNombreController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.nombre.ConfigurarNombreController#guardarNombre
 */
public interface GuardarNombreForm
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
