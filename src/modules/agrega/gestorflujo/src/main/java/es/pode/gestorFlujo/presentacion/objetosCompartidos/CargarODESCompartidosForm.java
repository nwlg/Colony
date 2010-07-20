// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarODESCompartidos</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosCompartidos.ObjetosCompartidosController</code> controller.
 *
 * 
 *
 * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.ObjetosCompartidosController#cargarODESCompartidos
 */
public interface CargarODESCompartidosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListaODES#sArray(Object[])
     */
    public void setListaODES(java.util.Collection listaODES);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListaODES#sArray()
     */
    public java.util.Collection getListaODES();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListaODES(java.util.Collection)
     */
    public void setListaODESAsArray(Object[] listaODES);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListaODES()
     */
    public java.lang.Object[] getListaODESAsArray();

    /**
     * Resets the <code>listaODES</code> field.
     */
    public void resetListaODES();

    /**
     * Sets the <code>tamainoODES</code> field.
     *
     * 
     */
    public void setTamainoODES(java.lang.Long[] tamainoODES);

    /**
     * Gets the <code>tamainoODES</code> field.
     *
     * 
     */
    public java.lang.Long[] getTamainoODES();
    
    /**
     * Resets the <code>tamainoODES</code> field.
     */
    public void resetTamainoODES();

}
