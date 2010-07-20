// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController#selectAction
 */
public interface SelectActionForm
{
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

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRecursosVO#sArray(Object[])
     */
    public void setRecursosVO(java.util.List recursosVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRecursosVO#sArray()
     */
    public java.util.List getRecursosVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRecursosVO(java.util.List)
     */
    public void setRecursosVOAsArray(Object[] recursosVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRecursosVO()
     */
    public java.lang.Object[] getRecursosVOAsArray();

    /**
     * Resets the <code>recursosVO</code> field.
     */
    public void resetRecursosVO();

}
