// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaResultados</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * En función del resultado de la búsqueda, se decide la pantalla
 * a presentar: sugerencias, resultados o la pantalla de
 * configuración del buscador avanzado con un mensaje de no se han
 * encontrado resultados.
 * </p>
 * <p>
 * Devuelve la página a la que nos debe devolver.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#analizaResultados
 */
public interface AnalizaResultadosForm
{
    /**
     * Sets the <code>mostrarAmbito</code> field.
     *
     * 
     */
    public void setMostrarAmbito(java.lang.Boolean mostrarAmbito);

    /**
     * Gets the <code>mostrarAmbito</code> field.
     *
     * 
     */
    public java.lang.Boolean getMostrarAmbito();
    
    /**
     * Resets the <code>mostrarAmbito</code> field.
     */
    public void resetMostrarAmbito();

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
     * Sets the <code>quisoDecir</code> field.
     *
     * 
     */
    public void setQuisoDecir(java.lang.String[] quisoDecir);

    /**
     * Gets the <code>quisoDecir</code> field.
     *
     * 
     */
    public java.lang.String[] getQuisoDecir();
    
    /**
     * Resets the <code>quisoDecir</code> field.
     */
    public void resetQuisoDecir();

    /**
     * Sets the <code>buscadorContenidoEnlace</code> field.
     *
     * 
     */
    public void setBuscadorContenidoEnlace(java.lang.String buscadorContenidoEnlace);

    /**
     * Gets the <code>buscadorContenidoEnlace</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorContenidoEnlace();
    
    /**
     * Resets the <code>buscadorContenidoEnlace</code> field.
     */
    public void resetBuscadorContenidoEnlace();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setResultadosVO#sArray(Object[])
     */
    public void setResultadosVO(java.util.Collection resultadosVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getResultadosVO#sArray()
     */
    public java.util.Collection getResultadosVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setResultadosVO(java.util.Collection)
     */
    public void setResultadosVOAsArray(Object[] resultadosVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getResultadosVO()
     */
    public java.lang.Object[] getResultadosVOAsArray();

    /**
     * Resets the <code>resultadosVO</code> field.
     */
    public void resetResultadosVO();

    /**
     * Sets the <code>sinResultados</code> field.
     *
     * 
     */
    public void setSinResultados(boolean sinResultados);

    /**
     * Gets the <code>sinResultados</code> field.
     *
     * 
     */
    public boolean isSinResultados();
    
    /**
     * Resets the <code>sinResultados</code> field.
     */
    public void resetSinResultados();

    /**
     * Sets the <code>tesauros</code> field.
     *
     * 
     */
    public void setTesauros(es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] tesauros);

    /**
     * Gets the <code>tesauros</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] getTesauros();
    
    /**
     * Resets the <code>tesauros</code> field.
     */
    public void resetTesauros();

}
