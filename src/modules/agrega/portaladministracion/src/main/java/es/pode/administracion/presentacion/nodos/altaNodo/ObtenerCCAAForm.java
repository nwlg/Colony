// license-header java merge-point
package es.pode.administracion.presentacion.nodos.altaNodo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCCAA</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.nodos.altaNodo.AltaNodoController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.nodos.altaNodo.AltaNodoController#obtenerCCAA
 */
public interface ObtenerCCAAForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setCcaa#sArray(Object[])
     */
    public void setCcaa(java.util.Collection ccaa);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCcaa#sArray()
     */
    public java.util.Collection getCcaa();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCcaa(java.util.Collection)
     */
    public void setCcaaAsArray(Object[] ccaa);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCcaa()
     */
    public java.lang.Object[] getCcaaAsArray();

    /**
     * Resets the <code>ccaa</code> field.
     */
    public void resetCcaa();

}
