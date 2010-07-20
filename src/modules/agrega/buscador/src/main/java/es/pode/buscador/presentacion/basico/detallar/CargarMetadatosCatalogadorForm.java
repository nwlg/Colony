// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarMetadatosCatalogador</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Envía un identificador de ODE a el empaquetador para que lo
 * precargue, y poder posteriormente abrir una ventana nueva con el
 * catalogador.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#cargarMetadatosCatalogador
 */
public interface CargarMetadatosCatalogadorForm
{
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

}
