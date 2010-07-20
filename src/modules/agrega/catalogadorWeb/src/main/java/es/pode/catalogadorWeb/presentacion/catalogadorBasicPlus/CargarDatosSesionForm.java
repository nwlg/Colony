// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatosSesion</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController</code> controller.
 *
 * <p>
 * Metodo encargado de recargar el formulario del catalogador
 * basico con los datos que se encuentren en el objeto de sesion
 * durante.
 * </p>
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController#cargarDatosSesion
 */
public interface CargarDatosSesionForm extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm
{

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setArboles#sArray(Object[])
     */
    public void setArboles(java.util.Collection arboles);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArboles#sArray()
     */
    public java.util.Collection getArboles();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArboles(java.util.Collection)
     */
    public void setArbolesAsArray(Object[] arboles);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArboles()
     */
    public java.lang.Object[] getArbolesAsArray();

}
