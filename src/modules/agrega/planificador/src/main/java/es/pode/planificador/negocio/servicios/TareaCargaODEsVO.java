// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.planificador.negocio.servicios;

/**
 * 
 */
public class TareaCargaODEsVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public TareaCargaODEsVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param trabajo  
     * @param grupoTrabajo  
     * @param trigger  
     * @param grupoTrigger  
     * @param cron  
     * @param fechaInicio  
     * @param periodicidad  
     * @param pathODE  
     * @param pathODEsCargados  
     * @param pathODEsNoCargados  
     * @param usuario  
     * @param tipoTarea  
     * @param msgPublicado  Mensaje cuando se publica un ODE
     * @param msgNoPublicado  Mensaje cuando no se publica un ODE
     * @param msgDescripcionTrabajo  
     * @param error  Campo identificativo del error. S�lo tendr� alg�n valor si se ha producido alg�n error.
     * @param sobrescribir  
     */
    public TareaCargaODEsVO(
        java.lang.String trabajo,
        java.lang.String grupoTrabajo,
        java.lang.String trigger,
        java.lang.String grupoTrigger,
        java.lang.String cron,
        java.util.Calendar fechaInicio,
        java.lang.String periodicidad,
        java.lang.String pathODE,
        java.lang.String pathODEsCargados,
        java.lang.String pathODEsNoCargados,
        java.lang.String usuario,
        java.lang.String tipoTarea,
        java.lang.String msgPublicado,
        java.lang.String msgNoPublicado,
        java.lang.String msgDescripcionTrabajo,
        java.lang.String error,
        java.lang.String sobrescribir)

    {
        this.trabajo = trabajo;
        this.grupoTrabajo = grupoTrabajo;
        this.trigger = trigger;
        this.grupoTrigger = grupoTrigger;
        this.cron = cron;
        this.fechaInicio = fechaInicio;
        this.periodicidad = periodicidad;
        this.pathODE = pathODE;
        this.pathODEsCargados = pathODEsCargados;
        this.pathODEsNoCargados = pathODEsNoCargados;
        this.usuario = usuario;
        this.tipoTarea = tipoTarea;
        this.msgPublicado = msgPublicado;
        this.msgNoPublicado = msgNoPublicado;
        this.msgDescripcionTrabajo = msgDescripcionTrabajo;
        this.error = error;
        this.sobrescribir = sobrescribir;
    }

    /**
     * Copies constructor from other TareaCargaODEsVO
     * @param otherBean TareaCargaODEsVO 
     */
    public TareaCargaODEsVO(TareaCargaODEsVO otherBean)
    {
        if (otherBean != null)
        {
            this.trabajo = otherBean.getTrabajo();
            this.grupoTrabajo = otherBean.getGrupoTrabajo();
            this.trigger = otherBean.getTrigger();
            this.grupoTrigger = otherBean.getGrupoTrigger();
            this.cron = otherBean.getCron();
            this.fechaInicio = otherBean.getFechaInicio();
            this.periodicidad = otherBean.getPeriodicidad();
            this.pathODE = otherBean.getPathODE();
            this.pathODEsCargados = otherBean.getPathODEsCargados();
            this.pathODEsNoCargados = otherBean.getPathODEsNoCargados();
            this.usuario = otherBean.getUsuario();
            this.tipoTarea = otherBean.getTipoTarea();
            this.msgPublicado = otherBean.getMsgPublicado();
            this.msgNoPublicado = otherBean.getMsgNoPublicado();
            this.msgDescripcionTrabajo = otherBean.getMsgDescripcionTrabajo();
            this.error = otherBean.getError();
            this.sobrescribir = otherBean.getSobrescribir();
        }
    }

    private java.lang.String trabajo;

    public java.lang.String getTrabajo()
    {
        return this.trabajo;
    }

    public void setTrabajo(java.lang.String trabajo)
    {
        this.trabajo = trabajo;
    }

    private java.lang.String grupoTrabajo;

    public java.lang.String getGrupoTrabajo()
    {
        return this.grupoTrabajo;
    }

    public void setGrupoTrabajo(java.lang.String grupoTrabajo)
    {
        this.grupoTrabajo = grupoTrabajo;
    }

    private java.lang.String trigger;

    public java.lang.String getTrigger()
    {
        return this.trigger;
    }

    public void setTrigger(java.lang.String trigger)
    {
        this.trigger = trigger;
    }

    private java.lang.String grupoTrigger;

    public java.lang.String getGrupoTrigger()
    {
        return this.grupoTrigger;
    }

    public void setGrupoTrigger(java.lang.String grupoTrigger)
    {
        this.grupoTrigger = grupoTrigger;
    }

    private java.lang.String cron;

    public java.lang.String getCron()
    {
        return this.cron;
    }

    public void setCron(java.lang.String cron)
    {
        this.cron = cron;
    }

    private java.util.Calendar fechaInicio;

    public java.util.Calendar getFechaInicio()
    {
        return this.fechaInicio;
    }

    public void setFechaInicio(java.util.Calendar fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    private java.lang.String periodicidad;

    public java.lang.String getPeriodicidad()
    {
        return this.periodicidad;
    }

    public void setPeriodicidad(java.lang.String periodicidad)
    {
        this.periodicidad = periodicidad;
    }

    private java.lang.String pathODE;

    public java.lang.String getPathODE()
    {
        return this.pathODE;
    }

    public void setPathODE(java.lang.String pathODE)
    {
        this.pathODE = pathODE;
    }

    private java.lang.String pathODEsCargados;

    public java.lang.String getPathODEsCargados()
    {
        return this.pathODEsCargados;
    }

    public void setPathODEsCargados(java.lang.String pathODEsCargados)
    {
        this.pathODEsCargados = pathODEsCargados;
    }

    private java.lang.String pathODEsNoCargados;

    public java.lang.String getPathODEsNoCargados()
    {
        return this.pathODEsNoCargados;
    }

    public void setPathODEsNoCargados(java.lang.String pathODEsNoCargados)
    {
        this.pathODEsNoCargados = pathODEsNoCargados;
    }

    private java.lang.String usuario;

    public java.lang.String getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    private java.lang.String tipoTarea;

    public java.lang.String getTipoTarea()
    {
        return this.tipoTarea;
    }

    public void setTipoTarea(java.lang.String tipoTarea)
    {
        this.tipoTarea = tipoTarea;
    }

    private java.lang.String msgPublicado;

    /**
     * <p>
     * Mensaje cuando se publica un ODE
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getMsgPublicado()
    {
        return this.msgPublicado;
    }

    /**
   * <p>
   * Mensaje cuando se publica un ODE
   * </p>
     *  @param msgPublicado  Mensaje cuando se publica un ODE  
     */
    public void setMsgPublicado(java.lang.String msgPublicado)
    {
        this.msgPublicado = msgPublicado;
    }

    private java.lang.String msgNoPublicado;

    /**
     * <p>
     * Mensaje cuando no se publica un ODE
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getMsgNoPublicado()
    {
        return this.msgNoPublicado;
    }

    /**
   * <p>
   * Mensaje cuando no se publica un ODE
   * </p>
     *  @param msgNoPublicado  Mensaje cuando no se publica un ODE  
     */
    public void setMsgNoPublicado(java.lang.String msgNoPublicado)
    {
        this.msgNoPublicado = msgNoPublicado;
    }

    private java.lang.String msgDescripcionTrabajo;

    public java.lang.String getMsgDescripcionTrabajo()
    {
        return this.msgDescripcionTrabajo;
    }

    public void setMsgDescripcionTrabajo(java.lang.String msgDescripcionTrabajo)
    {
        this.msgDescripcionTrabajo = msgDescripcionTrabajo;
    }

    private java.lang.String error;

    /**
     * <p>
     * Campo identificativo del error. S�lo tendr� alg�n valor si se ha
     * producido alg�n error.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getError()
    {
        return this.error;
    }

    /**
   * <p>
   * Campo identificativo del error. S�lo tendr� alg�n valor si se ha
   * producido alg�n error.
   * </p>
     *  @param error  Campo identificativo del error. S�lo tendr� alg�n valor si se ha producido alg�n error.  
     */
    public void setError(java.lang.String error)
    {
        this.error = error;
    }

    private java.lang.String sobrescribir;

    public java.lang.String getSobrescribir()
    {
        return this.sobrescribir;
    }

    public void setSobrescribir(java.lang.String sobrescribir)
    {
        this.sobrescribir = sobrescribir;
    }

}