// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de manifests para la barra superior de navegacion. Nos
     * indica en que Manifests estamos navegando, siendo la posición 0
     * el Manifest principal y los Manifest que le siguen su
     * submanifiesto, el submanifiesto de su submanifiesto, etc...
     * </p>
     *
     * @see #setBarraSubmanifiestos#sArray(Object[])
     */
    public void setBarraSubmanifiestos(java.util.List barraSubmanifiestos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de manifests para la barra superior de navegacion. Nos
     * indica en que Manifests estamos navegando, siendo la posición 0
     * el Manifest principal y los Manifest que le siguen su
     * submanifiesto, el submanifiesto de su submanifiesto, etc...
     * </p>
     *
     * @see #getBarraSubmanifiestos#sArray()
     */
    public java.util.List getBarraSubmanifiestos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de manifests para la barra superior de navegacion. Nos
     * indica en que Manifests estamos navegando, siendo la posición 0
     * el Manifest principal y los Manifest que le siguen su
     * submanifiesto, el submanifiesto de su submanifiesto, etc...
     * </p>
     *
     * @see #setBarraSubmanifiestos(java.util.List)
     */
    public void setBarraSubmanifiestosAsArray(Object[] barraSubmanifiestos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de manifests para la barra superior de navegacion. Nos
     * indica en que Manifests estamos navegando, siendo la posición 0
     * el Manifest principal y los Manifest que le siguen su
     * submanifiesto, el submanifiesto de su submanifiesto, etc...
     * </p>
     *
     * @see #getBarraSubmanifiestos()
     */
    public java.lang.Object[] getBarraSubmanifiestosAsArray();

    /**
     * Resets the <code>barraSubmanifiestos</code> field.
     */
    public void resetBarraSubmanifiestos();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setSubmanifiestos#sArray(Object[])
     */
    public void setSubmanifiestos(java.util.List submanifiestos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getSubmanifiestos#sArray()
     */
    public java.util.List getSubmanifiestos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setSubmanifiestos(java.util.List)
     */
    public void setSubmanifiestosAsArray(Object[] submanifiestos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getSubmanifiestos()
     */
    public java.lang.Object[] getSubmanifiestosAsArray();

    /**
     * Resets the <code>submanifiestos</code> field.
     */
    public void resetSubmanifiestos();

}
