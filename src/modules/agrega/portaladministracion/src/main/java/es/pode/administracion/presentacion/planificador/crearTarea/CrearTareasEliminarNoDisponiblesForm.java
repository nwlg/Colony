// license-header java merge-point
package es.pode.administracion.presentacion.planificador.crearTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearTareasEliminarNoDisponibles</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaController</code> controller.
 *
 * <p>
 * Este metodo crea una tarea programada de eliminacion de ODEs en
 * estado no disponible durante un rango de tiempo y de un usuario
 * concreto.
 * </p>
 *
 * @see es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaController#crearTareasEliminarNoDisponibles
 */
public interface CrearTareasEliminarNoDisponiblesForm
{
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
     * Sets the <code>msgNoEliminado</code> field.
     *
     * 
     */
    public void setMsgNoEliminado(java.lang.String msgNoEliminado);

    /**
     * Gets the <code>msgNoEliminado</code> field.
     *
     * 
     */
    public java.lang.String getMsgNoEliminado();
    
    /**
     * Resets the <code>msgNoEliminado</code> field.
     */
    public void resetMsgNoEliminado();

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
     * Sets the <code>msgEliminado</code> field.
     *
     * 
     */
    public void setMsgEliminado(java.lang.String msgEliminado);

    /**
     * Gets the <code>msgEliminado</code> field.
     *
     * 
     */
    public java.lang.String getMsgEliminado();
    
    /**
     * Resets the <code>msgEliminado</code> field.
     */
    public void resetMsgEliminado();

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
     * Sets the <code>trabajo</code> field.
     *
     * <p>
     * Tipo de trabajo.
     * </p>
     */
    public void setTrabajo(java.lang.String trabajo);

    /**
     * Gets the <code>trabajo</code> field.
     *
     * <p>
     * Tipo de trabajo.
     * </p>
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
     * Sets the <code>tareaModificada</code> field.
     *
     * 
     */
    public void setTareaModificada(java.lang.String tareaModificada);

    /**
     * Gets the <code>tareaModificada</code> field.
     *
     * 
     */
    public java.lang.String getTareaModificada();
    
    /**
     * Resets the <code>tareaModificada</code> field.
     */
    public void resetTareaModificada();

    /**
     * Sets the <code>periodicidad</code> field.
     *
     * <p>
     * Periodicidad con la que se ejecuta el trabajo.
     * </p>
     */
    public void setPeriodicidad(java.lang.String periodicidad);

    /**
     * Gets the <code>periodicidad</code> field.
     *
     * <p>
     * Periodicidad con la que se ejecuta el trabajo.
     * </p>
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
