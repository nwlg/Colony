// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.busquedaSQI;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizarFormulario</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController</code> controller.
 *
 * <p>
 * valida que los datos del formulario de la búsqueda sean
 * correctos
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController#analizarFormulario
 */
public interface AnalizarFormularioForm
{
    /**
     * Sets the <code>buscadorContenidoSolo</code> field.
     *
     * 
     */
    public void setBuscadorContenidoSolo(java.lang.String buscadorContenidoSolo);

    /**
     * Gets the <code>buscadorContenidoSolo</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorContenidoSolo();
    
    /**
     * Resets the <code>buscadorContenidoSolo</code> field.
     */
    public void resetBuscadorContenidoSolo();

    /**
     * Sets the <code>buscadorContenido</code> field.
     *
     * 
     */
    public void setBuscadorContenido(java.lang.String buscadorContenido);

    /**
     * Gets the <code>buscadorContenido</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorContenido();
    
    /**
     * Resets the <code>buscadorContenido</code> field.
     */
    public void resetBuscadorContenido();

    /**
     * Sets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

}
