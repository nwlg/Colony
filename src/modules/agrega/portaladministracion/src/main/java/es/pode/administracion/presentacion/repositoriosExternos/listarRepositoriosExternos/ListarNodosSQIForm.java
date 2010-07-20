// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>listarNodosSQI</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos.ListarNodosSQIController</code> controller.
 *
 * <p>
 * Metodo para listar los nodos de tipo SQI
 * </p>
 *
 * @see es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos.ListarNodosSQIController#listarNodosSQI
 */
public interface ListarNodosSQIForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Coleccion de nodos de tipo SQI
     * </p>
     *
     * @see #setNodos#sArray(Object[])
     */
    public void setNodos(java.util.Collection nodos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Coleccion de nodos de tipo SQI
     * </p>
     *
     * @see #getNodos#sArray()
     */
    public java.util.Collection getNodos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Coleccion de nodos de tipo SQI
     * </p>
     *
     * @see #setNodos(java.util.Collection)
     */
    public void setNodosAsArray(Object[] nodos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Coleccion de nodos de tipo SQI
     * </p>
     *
     * @see #getNodos()
     */
    public java.lang.Object[] getNodosAsArray();

    /**
     * Resets the <code>nodos</code> field.
     */
    public void resetNodos();

    /**
     * Sets the <code>idModificado</code> field.
     *
     * 
     */
    public void setIdModificado(java.lang.Long idModificado);

    /**
     * Gets the <code>idModificado</code> field.
     *
     * 
     */
    public java.lang.Long getIdModificado();
    
    /**
     * Resets the <code>idModificado</code> field.
     */
    public void resetIdModificado();

}
