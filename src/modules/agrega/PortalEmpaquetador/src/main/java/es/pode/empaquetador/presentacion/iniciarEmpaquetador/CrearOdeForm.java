// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearOde</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#crearOde
 */
public interface CrearOdeForm
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

    /**
     * Sets the <code>titulo</code> field.
     *
     * 
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * 
     */
    public java.lang.String getTitulo();
    
    /**
     * Resets the <code>titulo</code> field.
     */
    public void resetTitulo();

}
