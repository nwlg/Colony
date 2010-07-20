// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>compartirDescompartirODE</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController</code> controller.
 *
 * <p>
 * Metodo para compartir o descompartir un ODE de la lista de los
 * objetos personales del usuario
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController#compartirDescompartirODE
 */
public interface CompartirDescompartirODEForm
{
    /**
     * Sets the <code>idODE</code> field.
     *
     * 
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * 
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

    /**
     * Sets the <code>compartidoSN</code> field.
     *
     * 
     */
    public void setCompartidoSN(java.lang.String compartidoSN);

    /**
     * Gets the <code>compartidoSN</code> field.
     *
     * 
     */
    public java.lang.String getCompartidoSN();
    
    /**
     * Resets the <code>compartidoSN</code> field.
     */
    public void resetCompartidoSN();

}
