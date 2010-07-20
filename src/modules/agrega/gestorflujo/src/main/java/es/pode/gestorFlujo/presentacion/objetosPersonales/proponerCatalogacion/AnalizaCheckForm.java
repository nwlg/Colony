// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaCheck</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController</code> controller.
 *
 * <p>
 * Metodo par verificar si a aceptado las condiciones legales
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController#analizaCheck
 */
public interface AnalizaCheckForm
{
    /**
     * Sets the <code>seleccion</code> field.
     *
     * <p>
     * Para que acepte las condiciones legales
     * </p>
     */
    public void setSeleccion(java.lang.String seleccion);

    /**
     * Gets the <code>seleccion</code> field.
     *
     * <p>
     * Para que acepte las condiciones legales
     * </p>
     */
    public java.lang.String getSeleccion();
    
    /**
     * Resets the <code>seleccion</code> field.
     */
    public void resetSeleccion();

}
