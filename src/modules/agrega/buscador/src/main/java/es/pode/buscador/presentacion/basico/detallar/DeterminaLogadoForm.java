// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>determinaLogado</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Determina si el usuario está logado para mostrar la pantalla de
 * selección de secuencia, o enviarlo a la previsualización sin
 * secuencia con la url formada en la pantalla de detalle.
 * </p>
 * <p>
 * Devuelve el valor del estado del usuario de la aplicación
 * (logado/no logado).
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#determinaLogado
 */
public interface DeterminaLogadoForm
{
    /**
     * Sets the <code>seleccionarSecuencia</code> field.
     *
     * 
     */
    public void setSeleccionarSecuencia(java.lang.Boolean seleccionarSecuencia);

    /**
     * Gets the <code>seleccionarSecuencia</code> field.
     *
     * 
     */
    public java.lang.Boolean getSeleccionarSecuencia();
    
    /**
     * Resets the <code>seleccionarSecuencia</code> field.
     */
    public void resetSeleccionarSecuencia();

}
