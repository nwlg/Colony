// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>rolParaGruposTrabajo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController</code> controller.
 *
 * <p>
 * metodo que comprueba si el usuario tiene rol de empaquetador o
 * catalogador para poder asignar los grupos de trabajo o no
 * </p>
 *
 * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController#rolParaGruposTrabajo
 */
public interface RolParaGruposTrabajoForm
{
    /**
     * Sets the <code>resultado</code> field.
     *
     * 
     */
    public void setResultado(java.lang.String resultado);

    /**
     * Gets the <code>resultado</code> field.
     *
     * 
     */
    public java.lang.String getResultado();
    
    /**
     * Resets the <code>resultado</code> field.
     */
    public void resetResultado();

}
