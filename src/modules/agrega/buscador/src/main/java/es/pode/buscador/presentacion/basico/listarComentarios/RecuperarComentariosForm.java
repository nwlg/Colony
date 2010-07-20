// license-header java merge-point
package es.pode.buscador.presentacion.basico.listarComentarios;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarComentarios</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.listarComentarios.ListarComentariosController</code> controller.
 *
 * <p>
 * Este metodo recupera los comentarios relativos a un ODE.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.listarComentarios.ListarComentariosController#recuperarComentarios
 */
public interface RecuperarComentariosForm
{
    /**
     * Sets the <code>imagen</code> field.
     *
     * 
     */
    public void setImagen(java.lang.String imagen);

    /**
     * Gets the <code>imagen</code> field.
     *
     * 
     */
    public java.lang.String getImagen();
    
    /**
     * Resets the <code>imagen</code> field.
     */
    public void resetImagen();

    /**
     * Sets the <code>mostrarVuelta</code> field.
     *
     * 
     */
    public void setMostrarVuelta(java.lang.Boolean mostrarVuelta);

    /**
     * Gets the <code>mostrarVuelta</code> field.
     *
     * 
     */
    public java.lang.Boolean getMostrarVuelta();
    
    /**
     * Resets the <code>mostrarVuelta</code> field.
     */
    public void resetMostrarVuelta();

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
     * Sets the <code>idODE</code> field.
     *
     * 
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * 
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setComentarios#sArray(Object[])
     */
    public void setComentarios(java.util.Collection comentarios);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getComentarios#sArray()
     */
    public java.util.Collection getComentarios();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setComentarios(java.util.Collection)
     */
    public void setComentariosAsArray(Object[] comentarios);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getComentarios()
     */
    public java.lang.Object[] getComentariosAsArray();

    /**
     * Resets the <code>comentarios</code> field.
     */
    public void resetComentarios();

    /**
     * Sets the <code>idiomaODE</code> field.
     *
     * 
     */
    public void setIdiomaODE(java.lang.String idiomaODE);

    /**
     * Gets the <code>idiomaODE</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaODE();
    
    /**
     * Resets the <code>idiomaODE</code> field.
     */
    public void resetIdiomaODE();

    /**
     * Sets the <code>tituloODE</code> field.
     *
     * 
     */
    public void setTituloODE(java.lang.String tituloODE);

    /**
     * Gets the <code>tituloODE</code> field.
     *
     * 
     */
    public java.lang.String getTituloODE();
    
    /**
     * Resets the <code>tituloODE</code> field.
     */
    public void resetTituloODE();

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
