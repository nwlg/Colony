// license-header java merge-point
package es.pode.modificador.presentacion.informes.tarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>restaurarODEs</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.informes.tarea.InformeTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.informes.tarea.InformeTareaController#restaurarODEs
 */
public interface RestaurarODEsForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.String id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.String getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setOdes#sArray(Object[])
     */
    public void setOdes(java.util.List odes);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getOdes#sArray()
     */
    public java.util.List getOdes();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setOdes(java.util.List)
     */
    public void setOdesAsArray(Object[] odes);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getOdes()
     */
    public java.lang.Object[] getOdesAsArray();

    /**
     * Resets the <code>odes</code> field.
     */
    public void resetOdes();

}
