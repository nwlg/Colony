// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearSesion</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.AsociarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#crearSesion
 */
public interface CrearSesionForm
{
    /**
     * Sets the <code>tipo</code> field.
     *
     * 
     */
    public void setTipo(java.lang.String tipo);

    /**
     * Gets the <code>tipo</code> field.
     *
     * 
     */
    public java.lang.String getTipo();
    
    /**
     * Resets the <code>tipo</code> field.
     */
    public void resetTipo();

    /**
     * Sets the <code>identifier</code> field.
     *
     * 
     */
    public void setIdentifier(java.lang.String identifier);

    /**
     * Gets the <code>identifier</code> field.
     *
     * 
     */
    public java.lang.String getIdentifier();
    
    /**
     * Resets the <code>identifier</code> field.
     */
    public void resetIdentifier();

}
