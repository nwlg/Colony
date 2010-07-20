// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>gestionarBusqueda</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Método que recupera los resultados de la página de resultados
 * en la que se encuentra
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#gestionarBusqueda
 */
public interface GestionarBusquedaForm
{
    /**
     * Sets the <code>resultados</code> field.
     *
     * 
     */
    public void setResultados(es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO resultados);

    /**
     * Gets the <code>resultados</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO getResultados();
    
    /**
     * Resets the <code>resultados</code> field.
     */
    public void resetResultados();

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

}
