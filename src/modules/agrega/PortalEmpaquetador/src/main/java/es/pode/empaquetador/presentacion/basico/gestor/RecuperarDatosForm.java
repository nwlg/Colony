// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * Sets the <code>organizacion</code> field.
     *
     * 
     */
    public void setOrganizacion(es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion);

    /**
     * Gets the <code>organizacion</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.OrganizacionVO getOrganizacion();
    
    /**
     * Resets the <code>organizacion</code> field.
     */
    public void resetOrganizacion();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setActionComboValues#sArray(Object[])
     */
    public void setActionComboValues(java.util.List actionComboValues);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getActionComboValues#sArray()
     */
    public java.util.List getActionComboValues();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setActionComboValues(java.util.List)
     */
    public void setActionComboValuesAsArray(Object[] actionComboValues);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getActionComboValues()
     */
    public java.lang.Object[] getActionComboValuesAsArray();

    /**
     * Resets the <code>actionComboValues</code> field.
     */
    public void resetActionComboValues();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPortapapeles#sArray(Object[])
     */
    public void setPortapapeles(java.util.List portapapeles);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPortapapeles#sArray()
     */
    public java.util.List getPortapapeles();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPortapapeles(java.util.List)
     */
    public void setPortapapelesAsArray(Object[] portapapeles);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPortapapeles()
     */
    public java.lang.Object[] getPortapapelesAsArray();

    /**
     * Resets the <code>portapapeles</code> field.
     */
    public void resetPortapapeles();

    /**
     * Sets the <code>controlMode</code> field.
     *
     * 
     */
    public void setControlMode(es.pode.empaquetador.negocio.servicio.ControlModeVO controlMode);

    /**
     * Gets the <code>controlMode</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ControlModeVO getControlMode();
    
    /**
     * Resets the <code>controlMode</code> field.
     */
    public void resetControlMode();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdCollection#sArray(Object[])
     */
    public void setIdCollection(java.util.List idCollection);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdCollection#sArray()
     */
    public java.util.List getIdCollection();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdCollection(java.util.List)
     */
    public void setIdCollectionAsArray(Object[] idCollection);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdCollection()
     */
    public java.lang.Object[] getIdCollectionAsArray();

    /**
     * Resets the <code>idCollection</code> field.
     */
    public void resetIdCollection();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setGrupos#sArray(Object[])
     */
    public void setGrupos(java.util.List grupos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getGrupos#sArray()
     */
    public java.util.List getGrupos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setGrupos(java.util.List)
     */
    public void setGruposAsArray(Object[] grupos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getGrupos()
     */
    public java.lang.Object[] getGruposAsArray();

    /**
     * Resets the <code>grupos</code> field.
     */
    public void resetGrupos();

}
