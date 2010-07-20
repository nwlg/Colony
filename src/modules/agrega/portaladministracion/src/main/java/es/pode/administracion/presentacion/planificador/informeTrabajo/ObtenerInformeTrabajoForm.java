// license-header java merge-point
package es.pode.administracion.presentacion.planificador.informeTrabajo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerInformeTrabajo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.informeTrabajo.InformeController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.informeTrabajo.InformeController#obtenerInformeTrabajo
 */
public interface ObtenerInformeTrabajoForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.Long id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.Long getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * Sets the <code>trabajo</code> field.
     *
     * 
     */
    public void setTrabajo(java.lang.String trabajo);

    /**
     * Gets the <code>trabajo</code> field.
     *
     * 
     */
    public java.lang.String getTrabajo();
    
    /**
     * Resets the <code>trabajo</code> field.
     */
    public void resetTrabajo();

    /**
     * Sets the <code>descripcion</code> field.
     *
     * 
     */
    public void setDescripcion(java.lang.String descripcion);

    /**
     * Gets the <code>descripcion</code> field.
     *
     * 
     */
    public java.lang.String getDescripcion();
    
    /**
     * Resets the <code>descripcion</code> field.
     */
    public void resetDescripcion();

    /**
     * Sets the <code>fechaFin</code> field.
     *
     * 
     */
    public void setFechaFin(java.lang.String fechaFin);

    /**
     * Gets the <code>fechaFin</code> field.
     *
     * 
     */
    public java.lang.String getFechaFin();
    
    /**
     * Resets the <code>fechaFin</code> field.
     */
    public void resetFechaFin();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setInformeTrabajo#sArray(Object[])
     */
    public void setInformeTrabajo(java.util.Collection informeTrabajo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getInformeTrabajo#sArray()
     */
    public java.util.Collection getInformeTrabajo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setInformeTrabajo(java.util.Collection)
     */
    public void setInformeTrabajoAsArray(Object[] informeTrabajo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getInformeTrabajo()
     */
    public java.lang.Object[] getInformeTrabajoAsArray();

    /**
     * Resets the <code>informeTrabajo</code> field.
     */
    public void resetInformeTrabajo();

    /**
     * Sets the <code>fechaInicio</code> field.
     *
     * 
     */
    public void setFechaInicio(java.lang.String fechaInicio);

    /**
     * Gets the <code>fechaInicio</code> field.
     *
     * 
     */
    public java.lang.String getFechaInicio();
    
    /**
     * Resets the <code>fechaInicio</code> field.
     */
    public void resetFechaInicio();

}
