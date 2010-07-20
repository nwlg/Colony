// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearLomesInicial</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#crearLomesInicial
 */
public interface CrearLomesInicialForm
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

    /**
     * Sets the <code>identificador</code> field.
     *
     * 
     */
    public void setIdentificador(java.lang.String identificador);

    /**
     * Gets the <code>identificador</code> field.
     *
     * 
     */
    public java.lang.String getIdentificador();
    
    /**
     * Resets the <code>identificador</code> field.
     */
    public void resetIdentificador();

}
