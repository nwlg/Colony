// license-header java merge-point
package es.pode.buscador.presentacion.basico.listar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>prepararConsulta</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.listar.ListarController</code> controller.
 *
 * <p>
 * Este metodo efectua la busqueda de resultados para la consulta
 * que se ha configurado en el buscador de la aplicacion.
 * </p>
 * <p>
 * Los parametros de busqueda de la consulta que tiene que realizar
 * se los pasan por la URL de la invocacion y se mapean al
 * formulario que recibe como parametro.
 * </p>
 * <p>
 * Tambien se encarga de resolver la paginacion sobre una busqueda
 * ya realizada.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.listar.ListarController#prepararConsulta
 */
public interface PrepararConsultaForm
{
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
     * Sets the <code>keyword</code> field.
     *
     * 
     */
    public void setKeyword(java.lang.String keyword);

    /**
     * Gets the <code>keyword</code> field.
     *
     * 
     */
    public java.lang.String getKeyword();
    
    /**
     * Resets the <code>keyword</code> field.
     */
    public void resetKeyword();

    /**
     * Sets the <code>buscadorGeneral</code> field.
     *
     * 
     */
    public void setBuscadorGeneral(java.lang.String buscadorGeneral);

    /**
     * Gets the <code>buscadorGeneral</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorGeneral();
    
    /**
     * Resets the <code>buscadorGeneral</code> field.
     */
    public void resetBuscadorGeneral();

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

    /**
     * Sets the <code>tipoBusqueda</code> field.
     *
     * 
     */
    public void setTipoBusqueda(java.lang.String tipoBusqueda);

    /**
     * Gets the <code>tipoBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusqueda();
    
    /**
     * Resets the <code>tipoBusqueda</code> field.
     */
    public void resetTipoBusqueda();

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
