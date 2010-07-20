// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarLom;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectTipo</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomController</code> controller.
 *
 * <p>
 * Devuelve el tipo del Cambio, contenido en sesión
 * </p>
 *
 * @see es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomController#selectTipo
 */
public interface SelectTipoForm
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

}
