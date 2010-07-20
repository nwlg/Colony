// license-header java merge-point
package es.pode.presentacion.visualizador;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>nodoOnClickBoton</code> method, which is located on the
 * <code>es.pode.presentacion.visualizador.VisualizadorController</code> controller.
 *
 * 
 *
 * @see es.pode.presentacion.visualizador.VisualizadorController#nodoOnClickBoton
 */
public interface NodoOnClickBotonForm
{
    /**
     * Sets the <code>contador</code> field.
     *
     * 
     */
    public void setContador(int contador);

    /**
     * Gets the <code>contador</code> field.
     *
     * 
     */
    public int getContador();
    
    /**
     * Resets the <code>contador</code> field.
     */
    public void resetContador();

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

    /**
     * Sets the <code>localizacion</code> field.
     *
     * 
     */
    public void setLocalizacion(java.lang.String localizacion);

    /**
     * Gets the <code>localizacion</code> field.
     *
     * 
     */
    public java.lang.String getLocalizacion();
    
    /**
     * Resets the <code>localizacion</code> field.
     */
    public void resetLocalizacion();

}
