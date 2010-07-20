// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPropuestos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarODESPropuestos</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPropuestos.ObjetosPropuestosController</code> controller.
 *
 * <p>
 * Este metodo se encarga de recuperar la lista de ODEs propuestos
 * que tiene asociados el usuario que esta navegando. Se muestran
 * los odes pendientes de publicación o de catalogación.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPropuestos.ObjetosPropuestosController#cargarODESPropuestos
 */
public interface CargarODESPropuestosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de ODEs que estan propuestos para publicar para el usuario
     * dado.
     * </p>
     *
     * @see #setListaODES#sArray(Object[])
     */
    public void setListaODES(java.util.Collection listaODES);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de ODEs que estan propuestos para publicar para el usuario
     * dado.
     * </p>
     *
     * @see #getListaODES#sArray()
     */
    public java.util.Collection getListaODES();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ODEs que estan propuestos para publicar para el usuario
     * dado.
     * </p>
     *
     * @see #setListaODES(java.util.Collection)
     */
    public void setListaODESAsArray(Object[] listaODES);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ODEs que estan propuestos para publicar para el usuario
     * dado.
     * </p>
     *
     * @see #getListaODES()
     */
    public java.lang.Object[] getListaODESAsArray();

    /**
     * Resets the <code>listaODES</code> field.
     */
    public void resetListaODES();

}
