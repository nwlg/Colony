// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarUsosEducativos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoController#cargarUsosEducativos
 */
public interface CargarUsosEducativosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoUsosEdu#sArray(Object[])
     */
    public void setListadoUsosEdu(java.util.Collection listadoUsosEdu);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoUsosEdu#sArray()
     */
    public java.util.Collection getListadoUsosEdu();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoUsosEdu(java.util.Collection)
     */
    public void setListadoUsosEduAsArray(Object[] listadoUsosEdu);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoUsosEdu()
     */
    public java.lang.Object[] getListadoUsosEduAsArray();

    /**
     * Resets the <code>listadoUsosEdu</code> field.
     */
    public void resetListadoUsosEdu();

    /**
     * Sets the <code>identificadorOde</code> field.
     *
     * 
     */
    public void setIdentificadorOde(java.lang.String identificadorOde);

    /**
     * Gets the <code>identificadorOde</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorOde();
    
    /**
     * Resets the <code>identificadorOde</code> field.
     */
    public void resetIdentificadorOde();

}
