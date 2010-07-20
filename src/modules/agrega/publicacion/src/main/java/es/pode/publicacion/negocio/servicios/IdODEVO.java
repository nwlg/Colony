// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.publicacion.negocio.servicios;

/**
 * <p>
 * Se trata del VO que recoge toda la informacion relevante del ODE
 * para la indexacion del mismo.
 * </p>
 * <p>
 * En nuestro caso, la informacion relevante para la indexacion
 * esta compuesta por los distintos elementos de catalogacion que
 * puede tener embebidos (elementos LOM-ES) y otros datos que caen
 * fuera de esta catalogacion.
 * </p>
 */
public class IdODEVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public IdODEVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param valoracion  Valoracion del ODE dentro de la plataforma.
     * @param secuencia  Con secuencia o sin secuencia.
     * @param localizador  El localizador que da la ruta para acceder al ODE.
     * @param idODE  Identificador de almacenamiento del ODE.
     * @param imgFile  
     * @param catalogacionPrimaria  
     * @param catalogacionSecundaria  
     */
    public IdODEVO(
        java.lang.Float valoracion,
        java.lang.Boolean secuencia,
        java.lang.String localizador,
        java.lang.String idODE,
        java.lang.String imgFile,
        es.pode.publicacion.negocio.servicios.LomESPrimarioVO catalogacionPrimaria,
        es.pode.publicacion.negocio.servicios.LomESSecundarioVO[] catalogacionSecundaria)

    {
        this.valoracion = valoracion;
        this.secuencia = secuencia;
        this.localizador = localizador;
        this.idODE = idODE;
        this.imgFile = imgFile;
        this.catalogacionPrimaria = catalogacionPrimaria;
        this.catalogacionSecundaria = catalogacionSecundaria;
    }

    /**
     * Copies constructor from other IdODEVO
     * @param otherBean IdODEVO 
     */
    public IdODEVO(IdODEVO otherBean)
    {
        if (otherBean != null)
        {
            this.valoracion = otherBean.getValoracion();
            this.secuencia = otherBean.getSecuencia();
            this.localizador = otherBean.getLocalizador();
            this.idODE = otherBean.getIdODE();
            this.imgFile = otherBean.getImgFile();
            this.catalogacionPrimaria = otherBean.getCatalogacionPrimaria();
            this.catalogacionSecundaria = otherBean.getCatalogacionSecundaria();
        }
    }

    private java.lang.Float valoracion;

    /**
     * <p>
     * Valoracion del ODE dentro de la plataforma.
     * </p>
     * @return java.lang.Float
     */
    public java.lang.Float getValoracion()
    {
        return this.valoracion;
    }

    /**
   * <p>
   * Valoracion del ODE dentro de la plataforma.
   * </p>
     *  @param valoracion  Valoracion del ODE dentro de la plataforma.  
     */
    public void setValoracion(java.lang.Float valoracion)
    {
        this.valoracion = valoracion;
    }

    private java.lang.Boolean secuencia;

    /**
     * <p>
     * Con secuencia o sin secuencia.
     * </p>
     * @return java.lang.Boolean
     */
    public java.lang.Boolean getSecuencia()
    {
        return this.secuencia;
    }

    /**
   * <p>
   * Con secuencia o sin secuencia.
   * </p>
     *  @param secuencia  Con secuencia o sin secuencia.  
     */
    public void setSecuencia(java.lang.Boolean secuencia)
    {
        this.secuencia = secuencia;
    }

    private java.lang.String localizador;

    /**
     * <p>
     * El localizador que da la ruta para acceder al ODE.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getLocalizador()
    {
        return this.localizador;
    }

    /**
   * <p>
   * El localizador que da la ruta para acceder al ODE.
   * </p>
     *  @param localizador  El localizador que da la ruta para acceder al ODE.  
     */
    public void setLocalizador(java.lang.String localizador)
    {
        this.localizador = localizador;
    }

    private java.lang.String idODE;

    /**
     * <p>
     * Identificador de almacenamiento del ODE.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

    /**
   * <p>
   * Identificador de almacenamiento del ODE.
   * </p>
     *  @param idODE  Identificador de almacenamiento del ODE.  
     */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    private java.lang.String imgFile;

    public java.lang.String getImgFile()
    {
        return this.imgFile;
    }

    public void setImgFile(java.lang.String imgFile)
    {
        this.imgFile = imgFile;
    }

    /**
   * <p>
   * Este Value Object modela todos aquellos atributos relevantes del
   * ODE que estan en el LOM-ES de catalogacion primario  del ODE.
   * </p>
     */
    private es.pode.publicacion.negocio.servicios.LomESPrimarioVO catalogacionPrimaria;

    /**
     * Getter of catalogacionPrimaria.  
     * @return es.pode.publicacion.negocio.servicios.LomESPrimarioVO  Este Value Object modela todos aquellos atributos relevantes del ODE que estan en el LOM-ES de catalogacion primario  del ODE.
     */
    public es.pode.publicacion.negocio.servicios.LomESPrimarioVO getCatalogacionPrimaria()
    {
        return this.catalogacionPrimaria;
    }

  /**
   * Setter of catalogacionPrimaria  
   *  @param catalogacionPrimaria  Este Value Object modela todos aquellos atributos relevantes del ODE que estan en el LOM-ES de catalogacion primario  del ODE. 
   */
    public void setCatalogacionPrimaria(es.pode.publicacion.negocio.servicios.LomESPrimarioVO catalogacionPrimaria)
    {
        this.catalogacionPrimaria = catalogacionPrimaria;
    }

    /**
   * <p>
   * Este Value Object modela todos aquellos atributos relevantes del
   * ODE que estan en el LOM-ES de catalogacion secundario del ODE.
   * </p>
     */
    private es.pode.publicacion.negocio.servicios.LomESSecundarioVO[] catalogacionSecundaria;

    /**
     * Getter of catalogacionSecundaria.  
     * @return es.pode.publicacion.negocio.servicios.LomESSecundarioVO[]  Este Value Object modela todos aquellos atributos relevantes del ODE que estan en el LOM-ES de catalogacion secundario del ODE.
     */
    public es.pode.publicacion.negocio.servicios.LomESSecundarioVO[] getCatalogacionSecundaria()
    {
        return this.catalogacionSecundaria;
    }

  /**
   * Setter of catalogacionSecundaria  
   *  @param catalogacionSecundaria  Este Value Object modela todos aquellos atributos relevantes del ODE que estan en el LOM-ES de catalogacion secundario del ODE. 
   */
    public void setCatalogacionSecundaria(es.pode.publicacion.negocio.servicios.LomESSecundarioVO[] catalogacionSecundaria)
    {
        this.catalogacionSecundaria = catalogacionSecundaria;
    }

}