// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>gestionarPosicionamiento</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Método que se encarga de gestionar los botones que deben
 * aparecer en la ficha del detalle del ODE, de actualizar la
 * página del listado en la que aparece el objeto del que se está
 * consultando la ficha y de ver a que nodo se le está solicitando
 * el ODE para mostrar su detalle
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#gestionarPosicionamiento
 */
public interface GestionarPosicionamientoForm
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
     * Sets the <code>posicionamiento</code> field.
     *
     * 
     */
    public void setPosicionamiento(java.lang.String posicionamiento);

    /**
     * Gets the <code>posicionamiento</code> field.
     *
     * 
     */
    public java.lang.String getPosicionamiento();
    
    /**
     * Resets the <code>posicionamiento</code> field.
     */
    public void resetPosicionamiento();

    /**
     * Sets the <code>nodoDestino</code> field.
     *
     * 
     */
    public void setNodoDestino(java.lang.String nodoDestino);

    /**
     * Gets the <code>nodoDestino</code> field.
     *
     * 
     */
    public java.lang.String getNodoDestino();
    
    /**
     * Resets the <code>nodoDestino</code> field.
     */
    public void resetNodoDestino();

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

}
