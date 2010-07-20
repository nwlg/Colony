// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.crearcarpeta;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearCarpeta</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.crearcarpeta.CrearCarpetaController</code> controller.
 *
 * <p>
 * Llama al servicio de gestion de archivos para la creacion de una
 * nueva carpeta.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.archivos.crearcarpeta.CrearCarpetaController#crearCarpeta
 */
public interface CrearCarpetaForm
{
    /**
     * Sets the <code>nombre</code> field.
     *
     * <p>
     * Nombre de la carpeta a crear.
     * </p>
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * <p>
     * Nombre de la carpeta a crear.
     * </p>
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

    /**
     * Sets the <code>action</code> field.
     *
     * <p>
     * Valor del boton de submit
     * </p>
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * <p>
     * Valor del boton de submit
     * </p>
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

}
