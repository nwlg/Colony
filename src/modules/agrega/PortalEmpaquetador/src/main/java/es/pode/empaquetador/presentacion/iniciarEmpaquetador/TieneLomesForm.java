// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>tieneLomes</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController</code> controller.
 *
 * <p>
 * Comprueba si el ODE editado tiene lomes
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#tieneLomes
 */
public interface TieneLomesForm
{
    /**
     * Sets the <code>ode</code> field.
     *
     * 
     */
    public void setOde(es.pode.empaquetador.negocio.servicio.OdeVO ode);

    /**
     * Gets the <code>ode</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.OdeVO getOde();
    
    /**
     * Resets the <code>ode</code> field.
     */
    public void resetOde();

}
