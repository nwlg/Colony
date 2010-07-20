// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.carpeta;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.carpeta.CrearCarpetaBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.carpeta.CrearCarpetaBasicoController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * Sets the <code>title</code> field.
     *
     * 
     */
    public void setTitle(java.lang.String title);

    /**
     * Gets the <code>title</code> field.
     *
     * 
     */
    public java.lang.String getTitle();
    
    /**
     * Resets the <code>title</code> field.
     */
    public void resetTitle();

    /**
     * Sets the <code>esModificar</code> field.
     *
     * 
     */
    public void setEsModificar(boolean esModificar);

    /**
     * Gets the <code>esModificar</code> field.
     *
     * 
     */
    public boolean isEsModificar();
    
    /**
     * Resets the <code>esModificar</code> field.
     */
    public void resetEsModificar();

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
