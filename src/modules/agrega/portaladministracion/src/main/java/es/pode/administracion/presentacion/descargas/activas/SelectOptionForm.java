// license-header java merge-point
package es.pode.administracion.presentacion.descargas.activas;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectOption</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.descargas.activas.ActivasController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#selectOption
 */
public interface SelectOptionForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.List ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.List getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.List)
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

    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

}
