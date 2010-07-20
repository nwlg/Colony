// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.importar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitAdvertencia</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.importar.ImportarController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.importar.ImportarController#submitAdvertencia
 */
public interface SubmitAdvertenciaForm
{
    /**
     * Sets the <code>accion</code> field.
     *
     * 
     */
    public void setAccion(java.lang.String accion);

    /**
     * Gets the <code>accion</code> field.
     *
     * 
     */
    public java.lang.String getAccion();
    
    /**
     * Resets the <code>accion</code> field.
     */
    public void resetAccion();

}
