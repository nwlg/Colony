// license-header java merge-point
package es.pode.buscador.presentacion.basico.descargar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarTiposFormato</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.descargar.DescargarController</code> controller.
 *
 * <p>
 * Este metodo recupera la informacion que se tiene que mostrar en
 * la pantalla de seleccion de formato de descarga.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.descargar.DescargarController#cargarTiposFormato
 */
public interface CargarTiposFormatoForm
{
    /**
     * Sets the <code>titulo</code> field.
     *
     * 
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * 
     */
    public java.lang.String getTitulo();
    
    /**
     * Resets the <code>titulo</code> field.
     */
    public void resetTitulo();

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
     * Sets the <code>idioma</code> field.
     *
     * <p>
     * Idioma del ODE.
     * </p>
     */
    public void setIdioma(java.lang.String idioma);

    /**
     * Gets the <code>idioma</code> field.
     *
     * <p>
     * Idioma del ODE.
     * </p>
     */
    public java.lang.String getIdioma();
    
    /**
     * Resets the <code>idioma</code> field.
     */
    public void resetIdioma();

    /**
     * Sets the <code>formato</code> field.
     *
     * 
     */
    public void setFormato(java.lang.String formato);

    /**
     * Gets the <code>formato</code> field.
     *
     * 
     */
    public java.lang.String getFormato();
    
    /**
     * Resets the <code>formato</code> field.
     */
    public void resetFormato();

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

}
