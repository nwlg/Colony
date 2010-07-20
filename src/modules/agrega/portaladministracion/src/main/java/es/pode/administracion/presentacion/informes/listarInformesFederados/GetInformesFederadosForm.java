// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformesFederados;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>getInformesFederados</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosController#getInformesFederados
 */
public interface GetInformesFederadosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.Collection)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

}
