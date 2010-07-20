// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.listarODETesauro;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>decidirSalida</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController</code> controller.
 *
 * <p>
 * En esta actividad controlamos publicamos en la sesión los datos
 * necesarios para la navegación al diagrama de actividad, bien de
 * detalle de ode o navegación por el tesauro. Devuelve el valor
 * de la salida que se va a tomar.
 * </p>
 *
 * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController#decidirSalida
 */
public interface DecidirSalidaForm
{
    /**
     * Sets the <code>pagina</code> field.
     *
     * 
     */
    public void setPagina(java.lang.String pagina);

    /**
     * Gets the <code>pagina</code> field.
     *
     * 
     */
    public java.lang.String getPagina();
    
    /**
     * Resets the <code>pagina</code> field.
     */
    public void resetPagina();

    /**
     * Sets the <code>busquedaSimpleAvanzada</code> field.
     *
     * 
     */
    public void setBusquedaSimpleAvanzada(java.lang.String busquedaSimpleAvanzada);

    /**
     * Gets the <code>busquedaSimpleAvanzada</code> field.
     *
     * 
     */
    public java.lang.String getBusquedaSimpleAvanzada();
    
    /**
     * Resets the <code>busquedaSimpleAvanzada</code> field.
     */
    public void resetBusquedaSimpleAvanzada();

    /**
     * Sets the <code>identificadorODE</code> field.
     *
     * 
     */
    public void setIdentificadorODE(java.lang.String identificadorODE);

    /**
     * Gets the <code>identificadorODE</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorODE();
    
    /**
     * Resets the <code>identificadorODE</code> field.
     */
    public void resetIdentificadorODE();

    /**
     * Sets the <code>idioma</code> field.
     *
     * 
     */
    public void setIdioma(java.lang.String idioma);

    /**
     * Gets the <code>idioma</code> field.
     *
     * 
     */
    public java.lang.String getIdioma();
    
    /**
     * Resets the <code>idioma</code> field.
     */
    public void resetIdioma();

    /**
     * Sets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol);

    /**
     * Gets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusquedaArbol();
    
    /**
     * Resets the <code>tipoBusquedaArbol</code> field.
     */
    public void resetTipoBusquedaArbol();

    /**
     * Sets the <code>nodo</code> field.
     *
     * 
     */
    public void setNodo(java.lang.String nodo);

    /**
     * Gets the <code>nodo</code> field.
     *
     * 
     */
    public java.lang.String getNodo();
    
    /**
     * Resets the <code>nodo</code> field.
     */
    public void resetNodo();

    /**
     * Sets the <code>tesauroBusqueda</code> field.
     *
     * 
     */
    public void setTesauroBusqueda(java.lang.String tesauroBusqueda);

    /**
     * Gets the <code>tesauroBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTesauroBusqueda();
    
    /**
     * Resets the <code>tesauroBusqueda</code> field.
     */
    public void resetTesauroBusqueda();

    /**
     * Sets the <code>idiomaBuscador</code> field.
     *
     * 
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaBuscador();
    
    /**
     * Resets the <code>idiomaBuscador</code> field.
     */
    public void resetIdiomaBuscador();

}
