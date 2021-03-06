// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.modificador.negocio.servicio;

/**
 * 
 */
public class ResultadoModificacionVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public ResultadoModificacionVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param idOde  
     * @param status  
     * @param pathTraza  
     * @param pathBackup  
     * @param pathOriginal  
     * @param traza  
     * @param publicado  
     * @param msgError  
     * @param titulo  
     * @param id  
     */
    public ResultadoModificacionVO(
        java.lang.String idOde,
        es.pode.modificador.negocio.utilidades.EstadosTarea status,
        java.lang.String pathTraza,
        java.lang.String pathBackup,
        java.lang.String pathOriginal,
        java.lang.String traza,
        java.lang.Boolean publicado,
        java.lang.String msgError,
        java.lang.String titulo,
        java.lang.Long id)

    {
        this.idOde = idOde;
        this.status = status;
        this.pathTraza = pathTraza;
        this.pathBackup = pathBackup;
        this.pathOriginal = pathOriginal;
        this.traza = traza;
        this.publicado = publicado;
        this.msgError = msgError;
        this.titulo = titulo;
        this.id = id;
    }

    /**
     * Copies constructor from other ResultadoModificacionVO
     * @param otherBean ResultadoModificacionVO 
     */
    public ResultadoModificacionVO(ResultadoModificacionVO otherBean)
    {
        if (otherBean != null)
        {
            this.idOde = otherBean.getIdOde();
            this.status = otherBean.getStatus();
            this.pathTraza = otherBean.getPathTraza();
            this.pathBackup = otherBean.getPathBackup();
            this.pathOriginal = otherBean.getPathOriginal();
            this.traza = otherBean.getTraza();
            this.publicado = otherBean.getPublicado();
            this.msgError = otherBean.getMsgError();
            this.titulo = otherBean.getTitulo();
            this.id = otherBean.getId();
        }
    }

    private java.lang.String idOde;

    public java.lang.String getIdOde()
    {
        return this.idOde;
    }

    public void setIdOde(java.lang.String idOde)
    {
        this.idOde = idOde;
    }

    private es.pode.modificador.negocio.utilidades.EstadosTarea status;

    public es.pode.modificador.negocio.utilidades.EstadosTarea getStatus()
    {
        return this.status;
    }

    public void setStatus(es.pode.modificador.negocio.utilidades.EstadosTarea status)
    {
        this.status = status;
    }

    private java.lang.String pathTraza;

    public java.lang.String getPathTraza()
    {
        return this.pathTraza;
    }

    public void setPathTraza(java.lang.String pathTraza)
    {
        this.pathTraza = pathTraza;
    }

    private java.lang.String pathBackup;

    public java.lang.String getPathBackup()
    {
        return this.pathBackup;
    }

    public void setPathBackup(java.lang.String pathBackup)
    {
        this.pathBackup = pathBackup;
    }

    private java.lang.String pathOriginal;

    public java.lang.String getPathOriginal()
    {
        return this.pathOriginal;
    }

    public void setPathOriginal(java.lang.String pathOriginal)
    {
        this.pathOriginal = pathOriginal;
    }

    private java.lang.String traza;

    public java.lang.String getTraza()
    {
        return this.traza;
    }

    public void setTraza(java.lang.String traza)
    {
        this.traza = traza;
    }

    private java.lang.Boolean publicado;

    public java.lang.Boolean getPublicado()
    {
        return this.publicado;
    }

    public void setPublicado(java.lang.Boolean publicado)
    {
        this.publicado = publicado;
    }

    private java.lang.String msgError;

    public java.lang.String getMsgError()
    {
        return this.msgError;
    }

    public void setMsgError(java.lang.String msgError)
    {
        this.msgError = msgError;
    }

    private java.lang.String titulo;

    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.Long id;

    public java.lang.Long getId()
    {
        return this.id;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

}