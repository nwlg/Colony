// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarFormularioImportar</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarController</code> controller.
 *
 * <p>
 * Este metodo carga en el formulario de la pantalla de importrar
 * lo que hace falta.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarController#cargarFormularioImportar
 */
public interface CargarFormularioImportarForm
{
    /**
     * Sets the <code>espacioLibre</code> field.
     *
     * <p>
     * El espacio del que dispone el usuario para la importacion
     * </p>
     */
    public void setEspacioLibre(java.lang.Long espacioLibre);

    /**
     * Gets the <code>espacioLibre</code> field.
     *
     * <p>
     * El espacio del que dispone el usuario para la importacion
     * </p>
     */
    public java.lang.Long getEspacioLibre();
    
    /**
     * Resets the <code>espacioLibre</code> field.
     */
    public void resetEspacioLibre();

}
