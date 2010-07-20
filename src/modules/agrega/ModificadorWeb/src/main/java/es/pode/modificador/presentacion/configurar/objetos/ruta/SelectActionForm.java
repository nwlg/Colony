// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.ruta;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaController#selectAction
 */
public interface SelectActionForm
{
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

    /**
     * Sets the <code>path</code> field.
     *
     * 
     */
    public void setPath(java.lang.String path);

    /**
     * Gets the <code>path</code> field.
     *
     * 
     */
    public java.lang.String getPath();
    
    /**
     * Resets the <code>path</code> field.
     */
    public void resetPath();

}
