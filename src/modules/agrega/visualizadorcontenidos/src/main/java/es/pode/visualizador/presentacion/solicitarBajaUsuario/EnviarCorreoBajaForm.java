// license-header java merge-point
package es.pode.visualizador.presentacion.solicitarBajaUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>enviarCorreoBaja</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.solicitarBajaUsuario.SolicitarBajaUsuarioController</code> controller.
 *
 * <p>
 * Enviara un correo con el login del usuario que se quiere dar de
 * baja (se metera en sesion)
 * </p>
 *
 * @see es.pode.visualizador.presentacion.solicitarBajaUsuario.SolicitarBajaUsuarioController#enviarCorreoBaja
 */
public interface EnviarCorreoBajaForm
{
    /**
     * Sets the <code>resultadoEnvio</code> field.
     *
     * 
     */
    public void setResultadoEnvio(java.lang.String resultadoEnvio);

    /**
     * Gets the <code>resultadoEnvio</code> field.
     *
     * 
     */
    public java.lang.String getResultadoEnvio();
    
    /**
     * Resets the <code>resultadoEnvio</code> field.
     */
    public void resetResultadoEnvio();

    /**
     * Sets the <code>usuario</code> field.
     *
     * 
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * 
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

}
