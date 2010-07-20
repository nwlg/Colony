// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaAgregacion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Comprueba si se quiere agregar desde un detalle federado o
 * local.
 * </p>
 * <p>
 * Devuelve la localización del ODE que se quiere agregar (Local o
 * Federado).
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#analizaAgregacion
 */
public interface AnalizaAgregacionForm
{
    /**
     * Sets the <code>tipoAgregacion</code> field.
     *
     * 
     */
    public void setTipoAgregacion(java.lang.String tipoAgregacion);

    /**
     * Gets the <code>tipoAgregacion</code> field.
     *
     * 
     */
    public java.lang.String getTipoAgregacion();
    
    /**
     * Resets the <code>tipoAgregacion</code> field.
     */
    public void resetTipoAgregacion();

}
