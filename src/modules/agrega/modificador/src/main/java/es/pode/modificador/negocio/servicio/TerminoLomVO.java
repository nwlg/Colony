// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.modificador.negocio.servicio;

/**
 * <p>
 * VO para la navegacion por el arbol Lom en la seleccion del
 * termino a modificar, a�adir, eliminar ...
 * </p>
 */
public class TerminoLomVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public TerminoLomVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param idTermino  Identificador del termino (p.e: 3.2.1).
     * @param nombreTermino  Nombre del termino lomes (p.e: metadata)
     * @param rutaTermino  Ruta completa del termino separada por puntos (p.e: lom.metadata.contribute)
     * @param modificable  
     * @param aniadir  
     * @param eliminable  
     * @param hijos  
     * @param padres  
     */
    public TerminoLomVO(
        java.lang.String idTermino,
        java.lang.String nombreTermino,
        java.lang.String rutaTermino,
        java.lang.Boolean modificable,
        java.lang.Boolean aniadir,
        java.lang.Boolean eliminable,
        es.pode.modificador.negocio.servicio.TerminoLomVO[] hijos,
        es.pode.modificador.negocio.servicio.TerminoLomVO[] padres)

    {
        this.idTermino = idTermino;
        this.nombreTermino = nombreTermino;
        this.rutaTermino = rutaTermino;
        this.modificable = modificable;
        this.aniadir = aniadir;
        this.eliminable = eliminable;
        this.hijos = hijos;
        this.padres = padres;
    }

    /**
     * Copies constructor from other TerminoLomVO
     * @param otherBean TerminoLomVO 
     */
    public TerminoLomVO(TerminoLomVO otherBean)
    {
        if (otherBean != null)
        {
            this.idTermino = otherBean.getIdTermino();
            this.nombreTermino = otherBean.getNombreTermino();
            this.rutaTermino = otherBean.getRutaTermino();
            this.modificable = otherBean.getModificable();
            this.aniadir = otherBean.getAniadir();
            this.eliminable = otherBean.getEliminable();
            this.hijos = otherBean.getHijos();
            this.padres = otherBean.getPadres();
        }
    }

    private java.lang.String idTermino;

    /**
     * <p>
     * Identificador del termino (p.e: 3.2.1).
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdTermino()
    {
        return this.idTermino;
    }

    /**
   * <p>
   * Identificador del termino (p.e: 3.2.1).
   * </p>
     *  @param idTermino  Identificador del termino (p.e: 3.2.1).  
     */
    public void setIdTermino(java.lang.String idTermino)
    {
        this.idTermino = idTermino;
    }

    private java.lang.String nombreTermino;

    /**
     * <p>
     * Nombre del termino lomes (p.e: metadata)
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getNombreTermino()
    {
        return this.nombreTermino;
    }

    /**
   * <p>
   * Nombre del termino lomes (p.e: metadata)
   * </p>
     *  @param nombreTermino  Nombre del termino lomes (p.e: metadata)  
     */
    public void setNombreTermino(java.lang.String nombreTermino)
    {
        this.nombreTermino = nombreTermino;
    }

    private java.lang.String rutaTermino;

    /**
     * <p>
     * Ruta completa del termino separada por puntos (p.e:
     * lom.metadata.contribute)
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getRutaTermino()
    {
        return this.rutaTermino;
    }

    /**
   * <p>
   * Ruta completa del termino separada por puntos (p.e:
   * lom.metadata.contribute)
   * </p>
     *  @param rutaTermino  Ruta completa del termino separada por puntos (p.e: lom.metadata.contribute)  
     */
    public void setRutaTermino(java.lang.String rutaTermino)
    {
        this.rutaTermino = rutaTermino;
    }

    private java.lang.Boolean modificable;

    public java.lang.Boolean getModificable()
    {
        return this.modificable;
    }

    public void setModificable(java.lang.Boolean modificable)
    {
        this.modificable = modificable;
    }

    private java.lang.Boolean aniadir;

    public java.lang.Boolean getAniadir()
    {
        return this.aniadir;
    }

    public void setAniadir(java.lang.Boolean aniadir)
    {
        this.aniadir = aniadir;
    }

    private java.lang.Boolean eliminable;

    public java.lang.Boolean getEliminable()
    {
        return this.eliminable;
    }

    public void setEliminable(java.lang.Boolean eliminable)
    {
        this.eliminable = eliminable;
    }

    /**
   * <p>
   * VO para la navegacion por el arbol Lom en la seleccion del
   * termino a modificar, a�adir, eliminar ...
   * </p>
     */
    private es.pode.modificador.negocio.servicio.TerminoLomVO[] hijos;

    /**
     * Getter of hijos.  
     * @return es.pode.modificador.negocio.servicio.TerminoLomVO[]  VO para la navegacion por el arbol Lom en la seleccion del termino a modificar, a�adir, eliminar ...
     */
    public es.pode.modificador.negocio.servicio.TerminoLomVO[] getHijos()
    {
        return this.hijos;
    }

  /**
   * Setter of hijos  
   *  @param hijos  VO para la navegacion por el arbol Lom en la seleccion del termino a modificar, a�adir, eliminar ... 
   */
    public void setHijos(es.pode.modificador.negocio.servicio.TerminoLomVO[] hijos)
    {
        this.hijos = hijos;
    }

    /**
   * <p>
   * VO para la navegacion por el arbol Lom en la seleccion del
   * termino a modificar, a�adir, eliminar ...
   * </p>
     */
    private es.pode.modificador.negocio.servicio.TerminoLomVO[] padres;

    /**
     * Getter of padres.  
     * @return es.pode.modificador.negocio.servicio.TerminoLomVO[]  VO para la navegacion por el arbol Lom en la seleccion del termino a modificar, a�adir, eliminar ...
     */
    public es.pode.modificador.negocio.servicio.TerminoLomVO[] getPadres()
    {
        return this.padres;
    }

  /**
   * Setter of padres  
   *  @param padres  VO para la navegacion por el arbol Lom en la seleccion del termino a modificar, a�adir, eliminar ... 
   */
    public void setPadres(es.pode.modificador.negocio.servicio.TerminoLomVO[] padres)
    {
        this.padres = padres;
    }

}