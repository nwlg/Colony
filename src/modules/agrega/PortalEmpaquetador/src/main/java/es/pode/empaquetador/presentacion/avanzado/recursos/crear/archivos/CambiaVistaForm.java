// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cambiaVista</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController</code> controller.
 *
 * <p>
 * Cambia el valor de vistaArbol en el objeto de sesion de crear
 * recurso
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController#cambiaVista
 */
public interface CambiaVistaForm
{
    /**
     * Sets the <code>vistaArbol</code> field.
     *
     * 
     */
    public void setVistaArbol(boolean vistaArbol);

    /**
     * Gets the <code>vistaArbol</code> field.
     *
     * 
     */
    public boolean isVistaArbol();
    
    /**
     * Resets the <code>vistaArbol</code> field.
     */
    public void resetVistaArbol();

}
