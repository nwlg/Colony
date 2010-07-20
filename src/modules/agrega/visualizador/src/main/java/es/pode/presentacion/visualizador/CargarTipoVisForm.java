// license-header java merge-point
package es.pode.presentacion.visualizador;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarTipoVis</code> method, which is located on the
 * <code>es.pode.presentacion.visualizador.VisualizadorController</code> controller.
 *
 * 
 *
 * @see es.pode.presentacion.visualizador.VisualizadorController#cargarTipoVis
 */
public interface CargarTipoVisForm
{
    /**
     * Sets the <code>secuencia</code> field.
     *
     * 
     */
    public void setSecuencia(java.lang.Boolean secuencia);

    /**
     * Gets the <code>secuencia</code> field.
     *
     * 
     */
    public java.lang.Boolean getSecuencia();
    
    /**
     * Resets the <code>secuencia</code> field.
     */
    public void resetSecuencia();

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

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDatosSalida#sArray(Object[])
     */
    public void setDatosSalida(java.util.Collection datosSalida);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDatosSalida#sArray()
     */
    public java.util.Collection getDatosSalida();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDatosSalida(java.util.Collection)
     */
    public void setDatosSalidaAsArray(Object[] datosSalida);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDatosSalida()
     */
    public java.lang.Object[] getDatosSalidaAsArray();

    /**
     * Resets the <code>datosSalida</code> field.
     */
    public void resetDatosSalida();

}
