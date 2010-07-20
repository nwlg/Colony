// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaSelec</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarController</code> controller.
 *
 * <p>
 * analiza si hay algún ode seleccionado o no para devolver un
 * saveErrorMessage
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarController#analizaSelec
 */
public interface AnalizaSelecForm
{
    /**
     * Sets the <code>seleccion</code> field.
     *
     * 
     */
    public void setSeleccion(java.lang.String seleccion);

    /**
     * Gets the <code>seleccion</code> field.
     *
     * 
     */
    public java.lang.String getSeleccion();
    
    /**
     * Resets the <code>seleccion</code> field.
     */
    public void resetSeleccion();

}
