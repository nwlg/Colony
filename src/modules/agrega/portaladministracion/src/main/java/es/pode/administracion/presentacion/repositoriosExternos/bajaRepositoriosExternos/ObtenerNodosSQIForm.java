// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerNodosSQI</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos.BajaNodoSQIController</code> controller.
 *
 * <p>
 * Metodo para obtener los nodos de tipo SQI
 * </p>
 *
 * @see es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos.BajaNodoSQIController#obtenerNodosSQI
 */
public interface ObtenerNodosSQIForm
{
    /**
     * Sets the <code>listaId</code> field.
     *
     * <p>
     * Lista de identificadores para dar de baja
     * </p>
     */
    public void setListaId(java.lang.String listaId);

    /**
     * Gets the <code>listaId</code> field.
     *
     * <p>
     * Lista de identificadores para dar de baja
     * </p>
     */
    public java.lang.String getListaId();
    
    /**
     * Resets the <code>listaId</code> field.
     */
    public void resetListaId();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Coleccion de identificadores
     * </p>
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Coleccion de identificadores
     * </p>
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Coleccion de identificadores
     * </p>
     *
     * @see #setIds(java.util.Collection)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Coleccion de identificadores
     * </p>
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * Sets the <code>nodosSQI</code> field.
     *
     * <p>
     * Nodos de tipo SQI
     * </p>
     */
    public void setNodosSQI(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] nodosSQI);

    /**
     * Gets the <code>nodosSQI</code> field.
     *
     * <p>
     * Nodos de tipo SQI
     * </p>
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] getNodosSQI();
    
    /**
     * Resets the <code>nodosSQI</code> field.
     */
    public void resetNodosSQI();

}
