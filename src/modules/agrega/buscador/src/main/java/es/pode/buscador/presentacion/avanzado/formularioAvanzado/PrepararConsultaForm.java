// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.formularioAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>prepararConsulta</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoController</code> controller.
 *
 * <p>
 * Caso de uso de entrada al buscador avanzado, a traves del
 * formulario avanzado. Se inicializa la sesión y se carga el 
 * formulario.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoController#prepararConsulta
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
     * Sets the <code>enlaceComunidadesSeleccionadas</code> field.
     *
     * 
     */
    public void setEnlaceComunidadesSeleccionadas(java.lang.String enlaceComunidadesSeleccionadas);

    /**
     * Gets the <code>enlaceComunidadesSeleccionadas</code> field.
     *
     * 
     */
    public java.lang.String getEnlaceComunidadesSeleccionadas();
    
    /**
     * Resets the <code>enlaceComunidadesSeleccionadas</code> field.
     */
    public void resetEnlaceComunidadesSeleccionadas();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setComunidades#sArray(Object[])
     */
    public void setComunidades(java.util.List comunidades);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getComunidades#sArray()
     */
    public java.util.List getComunidades();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setComunidades(java.util.List)
     */
    public void setComunidadesAsArray(Object[] comunidades);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getComunidades()
     */
    public java.lang.Object[] getComunidadesAsArray();

    /**
     * Resets the <code>comunidades</code> field.
     */
    public void resetComunidades();

}
