// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>actualizados</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController#actualizados
 */
public interface ActualizadosForm
{
    /**
     * Sets the <code>actualizados</code> field.
     *
     * 
     */
    public void setActualizados(boolean actualizados);

    /**
     * Gets the <code>actualizados</code> field.
     *
     * 
     */
    public boolean isActualizados();
    
    /**
     * Resets the <code>actualizados</code> field.
     */
    public void resetActualizados();

}
