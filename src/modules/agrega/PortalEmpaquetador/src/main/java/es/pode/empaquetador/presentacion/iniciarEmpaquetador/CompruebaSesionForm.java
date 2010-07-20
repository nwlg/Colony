// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>compruebaSesion</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController</code> controller.
 *
 * <p>
 * Comprueba la sesion web, para obligar a que cada vez que se
 * entre por este punto, se cree una nueva sesion.
 * </p>
 * <p>
 * Si se encuentra una sesion existente (p.e., porque se cerro la
 * pestaña del navegador y se volvio a abrir el empaquetador), se
 * debe forzar la caducidad de la sesion para que se activen todos
 * los mecanismos de restaurar backups de la sesion anterior.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#compruebaSesion
 */
public interface CompruebaSesionForm
{
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
