// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.publicacion.negocio.servicios;

/**
 * <p>
 * Esta clase almacena la informacion de transicion entre estados
 * de cada ODE almacenado en la plataforma a�diendo el
 * idUsuarioCreacion.
 * </p>
 */
public class TransicionAutorVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public TransicionAutorVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param idODE  Identificador del ODE al que hace referencia la transicion.
     * @param comentarios  Los comentarios de la transicion.
     * @param fecha  La fecha de la transicion.
     * @param titulo  Titulo del ODE, en caso de tenerlo.
     * @param idUsuario  Identificador del usuario.
     * @param compartido  Un boolean para saber si el ODE ha sido compartido
     * @param idUsuarioCreacion  Identificador del usuario que ha creado el ODE
     */
    public TransicionAutorVO(
        java.lang.String idODE,
        java.lang.String comentarios,
        java.util.Calendar fecha,
        java.lang.String titulo,
        java.lang.String idUsuario,
        java.lang.Boolean compartido,
        java.lang.String idUsuarioCreacion)

    {
        this.idODE = idODE;
        this.comentarios = comentarios;
        this.fecha = fecha;
        this.titulo = titulo;
        this.idUsuario = idUsuario;
        this.compartido = compartido;
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    /**
     * Copies constructor from other TransicionAutorVO
     * @param otherBean TransicionAutorVO 
     */
    public TransicionAutorVO(TransicionAutorVO otherBean)
    {
        if (otherBean != null)
        {
            this.idODE = otherBean.getIdODE();
            this.comentarios = otherBean.getComentarios();
            this.fecha = otherBean.getFecha();
            this.titulo = otherBean.getTitulo();
            this.idUsuario = otherBean.getIdUsuario();
            this.compartido = otherBean.getCompartido();
            this.idUsuarioCreacion = otherBean.getIdUsuarioCreacion();
        }
    }

    private java.lang.String idODE;

    /**
     * <p>
     * Identificador del ODE al que hace referencia la transicion.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

    /**
   * <p>
   * Identificador del ODE al que hace referencia la transicion.
   * </p>
     *  @param idODE  Identificador del ODE al que hace referencia la transicion.  
     */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    private java.lang.String comentarios;

    /**
     * <p>
     * Los comentarios de la transicion.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getComentarios()
    {
        return this.comentarios;
    }

    /**
   * <p>
   * Los comentarios de la transicion.
   * </p>
     *  @param comentarios  Los comentarios de la transicion.  
     */
    public void setComentarios(java.lang.String comentarios)
    {
        this.comentarios = comentarios;
    }

    private java.util.Calendar fecha;

    /**
     * <p>
     * La fecha de la transicion.
     * </p>
     * @return java.util.Calendar
     */
    public java.util.Calendar getFecha()
    {
        return this.fecha;
    }

    /**
   * <p>
   * La fecha de la transicion.
   * </p>
     *  @param fecha  La fecha de la transicion.  
     */
    public void setFecha(java.util.Calendar fecha)
    {
        this.fecha = fecha;
    }

    private java.lang.String titulo;

    /**
     * <p>
     * Titulo del ODE, en caso de tenerlo.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    /**
   * <p>
   * Titulo del ODE, en caso de tenerlo.
   * </p>
     *  @param titulo  Titulo del ODE, en caso de tenerlo.  
     */
    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.String idUsuario;

    /**
     * <p>
     * Identificador del usuario.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }

    /**
   * <p>
   * Identificador del usuario.
   * </p>
     *  @param idUsuario  Identificador del usuario.  
     */
    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    private java.lang.Boolean compartido;

    /**
     * <p>
     * Un boolean para saber si el ODE ha sido compartido
     * </p>
     * @return java.lang.Boolean
     */
    public java.lang.Boolean getCompartido()
    {
        return this.compartido;
    }

    /**
   * <p>
   * Un boolean para saber si el ODE ha sido compartido
   * </p>
     *  @param compartido  Un boolean para saber si el ODE ha sido compartido  
     */
    public void setCompartido(java.lang.Boolean compartido)
    {
        this.compartido = compartido;
    }

    private java.lang.String idUsuarioCreacion;

    /**
     * <p>
     * Identificador del usuario que ha creado el ODE
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdUsuarioCreacion()
    {
        return this.idUsuarioCreacion;
    }

    /**
   * <p>
   * Identificador del usuario que ha creado el ODE
   * </p>
     *  @param idUsuarioCreacion  Identificador del usuario que ha creado el ODE  
     */
    public void setIdUsuarioCreacion(java.lang.String idUsuarioCreacion)
    {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

}