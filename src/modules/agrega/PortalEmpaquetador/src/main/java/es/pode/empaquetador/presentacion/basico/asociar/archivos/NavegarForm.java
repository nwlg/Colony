// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>navegar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController</code> controller.
 *
 * <p>
 * Modifica el path de la sesion para tener como carpeta actual la
 * carpeta seleccionada. Ademas, si el portapapeles tiene
 * elementos, se configura modoPegar a true, para indicar en en las
 * siguientes pantallas solo se puede pegar.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#navegar
 */
public interface NavegarForm
{
    /**
     * Sets the <code>href</code> field.
     *
     * 
     */
    public void setHref(java.lang.String href);

    /**
     * Gets the <code>href</code> field.
     *
     * 
     */
    public java.lang.String getHref();
    
    /**
     * Resets the <code>href</code> field.
     */
    public void resetHref();

}
