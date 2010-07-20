// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaFormularoLicencias</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController</code> controller.
 *
 * <p>
 * Carga el formulario de las licencias
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#cargaFormularoLicencias
 */
public interface CargaFormularoLicenciasForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setLicencias#sArray(Object[])
     */
    public void setLicencias(java.util.Collection licencias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getLicencias#sArray()
     */
    public java.util.Collection getLicencias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setLicencias(java.util.Collection)
     */
    public void setLicenciasAsArray(Object[] licencias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getLicencias()
     */
    public java.lang.Object[] getLicenciasAsArray();

    /**
     * Resets the <code>licencias</code> field.
     */
    public void resetLicencias();

    /**
     * Sets the <code>ambito_todas</code> field.
     *
     * 
     */
    public void setAmbito_todas(java.lang.String ambito_todas);

    /**
     * Gets the <code>ambito_todas</code> field.
     *
     * 
     */
    public java.lang.String getAmbito_todas();
    
    /**
     * Resets the <code>ambito_todas</code> field.
     */
    public void resetAmbito_todas();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setComunidades#sArray(Object[])
     */
    public void setComunidades(java.util.Collection comunidades);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getComunidades#sArray()
     */
    public java.util.Collection getComunidades();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setComunidades(java.util.Collection)
     */
    public void setComunidadesAsArray(Object[] comunidades);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getComunidades()
     */
    public java.lang.Object[] getComunidadesAsArray();

    /**
     * Resets the <code>comunidades</code> field.
     */
    public void resetComunidades();

    /**
     * Sets the <code>tipo_licencia</code> field.
     *
     * 
     */
    public void setTipo_licencia(java.lang.String tipo_licencia);

    /**
     * Gets the <code>tipo_licencia</code> field.
     *
     * 
     */
    public java.lang.String getTipo_licencia();
    
    /**
     * Resets the <code>tipo_licencia</code> field.
     */
    public void resetTipo_licencia();

}
