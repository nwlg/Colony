// license-header java merge-point
package es.pode.administracion.presentacion.noticias.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarSeleccion</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.noticias.eliminar.EliminarController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.noticias.eliminar.EliminarController#validarSeleccion
 */
public interface ValidarSeleccionForm
{
    /**
     * Sets the <code>seleccionado</code> field.
     *
     * 
     */
    public void setSeleccionado(java.lang.String seleccionado);

    /**
     * Gets the <code>seleccionado</code> field.
     *
     * 
     */
    public java.lang.String getSeleccionado();
    
    /**
     * Resets the <code>seleccionado</code> field.
     */
    public void resetSeleccionado();

}
