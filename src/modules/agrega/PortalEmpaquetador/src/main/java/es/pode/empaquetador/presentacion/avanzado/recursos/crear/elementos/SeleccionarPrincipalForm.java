// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>seleccionarPrincipal</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController</code> controller.
 *
 * <p>
 * Fija el archivo principal del recurso en el objeto de sesion.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController#seleccionarPrincipal
 */
public interface SeleccionarPrincipalForm
{
    /**
     * Sets the <code>principal</code> field.
     *
     * 
     */
    public void setPrincipal(java.lang.String principal);

    /**
     * Gets the <code>principal</code> field.
     *
     * 
     */
    public java.lang.String getPrincipal();
    
    /**
     * Resets the <code>principal</code> field.
     */
    public void resetPrincipal();

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
