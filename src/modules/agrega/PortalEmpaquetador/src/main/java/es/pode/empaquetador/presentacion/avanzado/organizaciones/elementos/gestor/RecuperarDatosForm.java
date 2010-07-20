// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosController#recuperarDatos
 */
public interface RecuperarDatosForm
{
    /**
     * Sets the <code>secuencia</code> field.
     *
     * <p>
     * Secuencia asociada al grupo / organizacion en edicion (puede ser
     * null).
     * </p>
     */
    public void setSecuencia(es.pode.empaquetador.negocio.servicio.ControlModeVO secuencia);

    /**
     * Gets the <code>secuencia</code> field.
     *
     * <p>
     * Secuencia asociada al grupo / organizacion en edicion (puede ser
     * null).
     * </p>
     */
    public es.pode.empaquetador.negocio.servicio.ControlModeVO getSecuencia();
    
    /**
     * Resets the <code>secuencia</code> field.
     */
    public void resetSecuencia();

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
     * <p>
     * Elementos copiados / cortados listos para pegar.
     * </p>
     *
     * @see #setPortapapeles#sArray(Object[])
     */
    public void setPortapapeles(java.util.List portapapeles);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Elementos copiados / cortados listos para pegar.
     * </p>
     *
     * @see #getPortapapeles#sArray()
     */
    public java.util.List getPortapapeles();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Elementos copiados / cortados listos para pegar.
     * </p>
     *
     * @see #setPortapapeles(java.util.List)
     */
    public void setPortapapelesAsArray(Object[] portapapeles);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Elementos copiados / cortados listos para pegar.
     * </p>
     *
     * @see #getPortapapeles()
     */
    public java.lang.Object[] getPortapapelesAsArray();

    /**
     * Resets the <code>portapapeles</code> field.
     */
    public void resetPortapapeles();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de carpetas en las que se esta navegando (ver Gestor
     * Basico)
     * </p>
     *
     * @see #setIdCollection#sArray(Object[])
     */
    public void setIdCollection(java.util.List idCollection);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de carpetas en las que se esta navegando (ver Gestor
     * Basico)
     * </p>
     *
     * @see #getIdCollection#sArray()
     */
    public java.util.List getIdCollection();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de carpetas en las que se esta navegando (ver Gestor
     * Basico)
     * </p>
     *
     * @see #setIdCollection(java.util.List)
     */
    public void setIdCollectionAsArray(Object[] idCollection);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de carpetas en las que se esta navegando (ver Gestor
     * Basico)
     * </p>
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
     * <p>
     * Lista de grupos y elementos para la vista por carpeta.
     * </p>
     *
     * @see #setGrupos#sArray(Object[])
     */
    public void setGrupos(java.util.List grupos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de grupos y elementos para la vista por carpeta.
     * </p>
     *
     * @see #getGrupos#sArray()
     */
    public java.util.List getGrupos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de grupos y elementos para la vista por carpeta.
     * </p>
     *
     * @see #setGrupos(java.util.List)
     */
    public void setGruposAsArray(Object[] grupos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de grupos y elementos para la vista por carpeta.
     * </p>
     *
     * @see #getGrupos()
     */
    public java.lang.Object[] getGruposAsArray();

    /**
     * Resets the <code>grupos</code> field.
     */
    public void resetGrupos();

}
