// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarHistorialODE</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.VerHistorialController</code> controller.
 *
 * <p>
 * Este metodo se encarga de recoger la informacion de historial
 * del ODE que se ha seleccionado en la web.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.VerHistorialController#cargarHistorialODE
 */
public interface CargarHistorialODEForm
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
     * <p>
     * Coleccion de objetos historial que se va a listar en la pantalla
     * de historial.
     * </p>
     *
     * @see #setHistoriales#sArray(Object[])
     */
    public void setHistoriales(java.util.Collection historiales);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Coleccion de objetos historial que se va a listar en la pantalla
     * de historial.
     * </p>
     *
     * @see #getHistoriales#sArray()
     */
    public java.util.Collection getHistoriales();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Coleccion de objetos historial que se va a listar en la pantalla
     * de historial.
     * </p>
     *
     * @see #setHistoriales(java.util.Collection)
     */
    public void setHistorialesAsArray(Object[] historiales);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Coleccion de objetos historial que se va a listar en la pantalla
     * de historial.
     * </p>
     *
     * @see #getHistoriales()
     */
    public java.lang.Object[] getHistorialesAsArray();

    /**
     * Resets the <code>historiales</code> field.
     */
    public void resetHistoriales();

}
