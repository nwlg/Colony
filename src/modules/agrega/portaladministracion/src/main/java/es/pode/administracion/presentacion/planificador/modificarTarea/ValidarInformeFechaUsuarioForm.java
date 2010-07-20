// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarInformeFechaUsuario</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController#validarInformeFechaUsuario
 */
public interface ValidarInformeFechaUsuarioForm
{
    /**
     * Sets the <code>anioHasta</code> field.
     *
     * 
     */
    public void setAnioHasta(java.lang.String anioHasta);

    /**
     * Gets the <code>anioHasta</code> field.
     *
     * 
     */
    public java.lang.String getAnioHasta();
    
    /**
     * Resets the <code>anioHasta</code> field.
     */
    public void resetAnioHasta();

    /**
     * Sets the <code>minutos</code> field.
     *
     * 
     */
    public void setMinutos(java.lang.String minutos);

    /**
     * Gets the <code>minutos</code> field.
     *
     * 
     */
    public java.lang.String getMinutos();
    
    /**
     * Resets the <code>minutos</code> field.
     */
    public void resetMinutos();

    /**
     * Sets the <code>anio</code> field.
     *
     * 
     */
    public void setAnio(java.lang.String anio);

    /**
     * Gets the <code>anio</code> field.
     *
     * 
     */
    public java.lang.String getAnio();
    
    /**
     * Resets the <code>anio</code> field.
     */
    public void resetAnio();

    /**
     * Sets the <code>trigger</code> field.
     *
     * 
     */
    public void setTrigger(java.lang.String trigger);

    /**
     * Gets the <code>trigger</code> field.
     *
     * 
     */
    public java.lang.String getTrigger();
    
    /**
     * Resets the <code>trigger</code> field.
     */
    public void resetTrigger();

    /**
     * Sets the <code>grupoTrigger</code> field.
     *
     * 
     */
    public void setGrupoTrigger(java.lang.String grupoTrigger);

    /**
     * Gets the <code>grupoTrigger</code> field.
     *
     * 
     */
    public java.lang.String getGrupoTrigger();
    
    /**
     * Resets the <code>grupoTrigger</code> field.
     */
    public void resetGrupoTrigger();

    /**
     * Sets the <code>grupoTrabajo</code> field.
     *
     * 
     */
    public void setGrupoTrabajo(java.lang.String grupoTrabajo);

    /**
     * Gets the <code>grupoTrabajo</code> field.
     *
     * 
     */
    public java.lang.String getGrupoTrabajo();
    
    /**
     * Resets the <code>grupoTrabajo</code> field.
     */
    public void resetGrupoTrabajo();

    /**
     * Sets the <code>tipoTarea</code> field.
     *
     * 
     */
    public void setTipoTarea(java.lang.String tipoTarea);

    /**
     * Gets the <code>tipoTarea</code> field.
     *
     * 
     */
    public java.lang.String getTipoTarea();
    
    /**
     * Resets the <code>tipoTarea</code> field.
     */
    public void resetTipoTarea();

    /**
     * Sets the <code>usuario</code> field.
     *
     * 
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * 
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

    /**
     * The <code>usuario</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getUsuario()
     * @see #getUsuarioValueList()
     * @see #getUsuarioLabelList()
     * @see #setUsuarioLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getUsuarioBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * usuario property. This method takes a collection of objects, as well as
     * the property names to query on these objects in order to find the corresponding
     * values and labels.
     * <p/>
     * Let's say you have a set of value objects with the following properties:
     * <ul>
     *  <li><code>id</code></li>
     *  <li><code>code</code></li>
     *  <li><code>name</code></li>
     *  <li><code>description</code></li>
     * </ul>
     * But you need to populate the usuario backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setUsuarioBackingList(valueObjects, "id", "name")</code>
     * <p/>
     * This method knows how to handle primitive property types as it simply delegates to
     * <code>org.apache.commons.beanutils.PropertyUtils.getProperty(Object, String)</code>.
     *
     * @param items The items from which to read the properties, if this argument is <code>null</code> this method
     *        will simply clear the existing values and labels
     * @param valueProperty the name of the property to query on each object to retrieve
     *        the corresponding value, cannot be <code>null</code>
     * @throws java.lang.IllegalArgumentException if the valueProperty or labelProperty is <code>null</code>
     * @throws java.lang.RuntimeException if one of the items in the collection is <code>null</code>, or
     *         if the caller does not have access one of the object's properties, if an exception was thrown while
     *         accessing a property or if the property does not exist on at least one of the items
     *
     * @see #getUsuario()
     * @see #getUsuarioValueList()
     * @see #getUsuarioLabelList()
     * @see #getUsuarioLabelList()
     */
    public void setUsuarioBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>usuario</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getUsuario()
     * @see #getUsuarioBackingList()
     */
    public java.lang.Object[] getUsuarioValueList();

    /**
     * The <code>usuario</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getUsuario()
     * @see #getUsuarioBackingList()
     */
    public void setUsuarioValueList(java.lang.Object[] usuarioValueList);

    /**
     * The <code>usuario</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getUsuario()
     * @see #getUsuarioBackingList()
     */
    public java.lang.Object[] getUsuarioLabelList();

    /**
     * The <code>usuario</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getUsuario()
     * @see #getUsuarioBackingList()
     */
    public void setUsuarioLabelList(java.lang.Object[] usuarioLabelList);

    /**
     * Sets the <code>informe</code> field.
     *
     * 
     */
    public void setInforme(java.lang.String informe);

    /**
     * Gets the <code>informe</code> field.
     *
     * 
     */
    public java.lang.String getInforme();
    
    /**
     * Resets the <code>informe</code> field.
     */
    public void resetInforme();

    /**
     * Sets the <code>dia</code> field.
     *
     * 
     */
    public void setDia(java.lang.String dia);

    /**
     * Gets the <code>dia</code> field.
     *
     * 
     */
    public java.lang.String getDia();
    
    /**
     * Resets the <code>dia</code> field.
     */
    public void resetDia();

    /**
     * Sets the <code>formato</code> field.
     *
     * 
     */
    public void setFormato(java.lang.String formato);

    /**
     * Gets the <code>formato</code> field.
     *
     * 
     */
    public java.lang.String getFormato();
    
    /**
     * Resets the <code>formato</code> field.
     */
    public void resetFormato();

    /**
     * Sets the <code>diaHasta</code> field.
     *
     * 
     */
    public void setDiaHasta(java.lang.String diaHasta);

    /**
     * Gets the <code>diaHasta</code> field.
     *
     * 
     */
    public java.lang.String getDiaHasta();
    
    /**
     * Resets the <code>diaHasta</code> field.
     */
    public void resetDiaHasta();

    /**
     * Sets the <code>anioDesde</code> field.
     *
     * 
     */
    public void setAnioDesde(java.lang.String anioDesde);

    /**
     * Gets the <code>anioDesde</code> field.
     *
     * 
     */
    public java.lang.String getAnioDesde();
    
    /**
     * Resets the <code>anioDesde</code> field.
     */
    public void resetAnioDesde();

    /**
     * Sets the <code>hora</code> field.
     *
     * 
     */
    public void setHora(java.lang.String hora);

    /**
     * Gets the <code>hora</code> field.
     *
     * 
     */
    public java.lang.String getHora();
    
    /**
     * Resets the <code>hora</code> field.
     */
    public void resetHora();

    /**
     * Sets the <code>msgNoInforme</code> field.
     *
     * 
     */
    public void setMsgNoInforme(java.lang.String msgNoInforme);

    /**
     * Gets the <code>msgNoInforme</code> field.
     *
     * 
     */
    public java.lang.String getMsgNoInforme();
    
    /**
     * Resets the <code>msgNoInforme</code> field.
     */
    public void resetMsgNoInforme();

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
     * Sets the <code>msgDescTrabajo</code> field.
     *
     * 
     */
    public void setMsgDescTrabajo(java.lang.String msgDescTrabajo);

    /**
     * Gets the <code>msgDescTrabajo</code> field.
     *
     * 
     */
    public java.lang.String getMsgDescTrabajo();
    
    /**
     * Resets the <code>msgDescTrabajo</code> field.
     */
    public void resetMsgDescTrabajo();

    /**
     * Sets the <code>msgInforme</code> field.
     *
     * 
     */
    public void setMsgInforme(java.lang.String msgInforme);

    /**
     * Gets the <code>msgInforme</code> field.
     *
     * 
     */
    public java.lang.String getMsgInforme();
    
    /**
     * Resets the <code>msgInforme</code> field.
     */
    public void resetMsgInforme();

    /**
     * Sets the <code>mes</code> field.
     *
     * 
     */
    public void setMes(java.lang.String mes);

    /**
     * Gets the <code>mes</code> field.
     *
     * 
     */
    public java.lang.String getMes();
    
    /**
     * Resets the <code>mes</code> field.
     */
    public void resetMes();

    /**
     * Sets the <code>periodicidad</code> field.
     *
     * 
     */
    public void setPeriodicidad(java.lang.String periodicidad);

    /**
     * Gets the <code>periodicidad</code> field.
     *
     * 
     */
    public java.lang.String getPeriodicidad();
    
    /**
     * Resets the <code>periodicidad</code> field.
     */
    public void resetPeriodicidad();

    /**
     * Sets the <code>mesHasta</code> field.
     *
     * 
     */
    public void setMesHasta(java.lang.String mesHasta);

    /**
     * Gets the <code>mesHasta</code> field.
     *
     * 
     */
    public java.lang.String getMesHasta();
    
    /**
     * Resets the <code>mesHasta</code> field.
     */
    public void resetMesHasta();

    /**
     * Sets the <code>mesDesde</code> field.
     *
     * 
     */
    public void setMesDesde(java.lang.String mesDesde);

    /**
     * Gets the <code>mesDesde</code> field.
     *
     * 
     */
    public java.lang.String getMesDesde();
    
    /**
     * Resets the <code>mesDesde</code> field.
     */
    public void resetMesDesde();

    /**
     * Sets the <code>diaDesde</code> field.
     *
     * 
     */
    public void setDiaDesde(java.lang.String diaDesde);

    /**
     * Gets the <code>diaDesde</code> field.
     *
     * 
     */
    public java.lang.String getDiaDesde();
    
    /**
     * Resets the <code>diaDesde</code> field.
     */
    public void resetDiaDesde();

}
