// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.publicacion.negocio.servicios;

/**
 * <p>
 * Esta clase almacena la actividad de un determinado estado.
 * </p>
 */
public class EstadoActividadVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public EstadoActividadVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param estado  Se trata del estado.
     * @param detalleTransicionVOs  
     */
    public EstadoActividadVO(
        java.lang.String estado,
        es.pode.publicacion.negocio.servicios.DetalleTransicionVO[] detalleTransicionVOs)

    {
        this.estado = estado;
        this.detalleTransicionVOs = detalleTransicionVOs;
    }

    /**
     * Copies constructor from other EstadoActividadVO
     * @param otherBean EstadoActividadVO 
     */
    public EstadoActividadVO(EstadoActividadVO otherBean)
    {
        if (otherBean != null)
        {
            this.estado = otherBean.getEstado();
            this.detalleTransicionVOs = otherBean.getDetalleTransicionVOs();
        }
    }

    private java.lang.String estado;

    /**
     * <p>
     * Se trata del estado.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getEstado()
    {
        return this.estado;
    }

    /**
   * <p>
   * Se trata del estado.
   * </p>
     *  @param estado  Se trata del estado.  
     */
    public void setEstado(java.lang.String estado)
    {
        this.estado = estado;
    }

    /**
   * <p>
   * Este value object contiene la informacion de detalle que se
   * necesita para una transicion.
   * </p>
     */
    private es.pode.publicacion.negocio.servicios.DetalleTransicionVO[] detalleTransicionVOs;

    /**
     * Getter of detalleTransicionVOs.  
     * @return es.pode.publicacion.negocio.servicios.DetalleTransicionVO[]  Este value object contiene la informacion de detalle que se necesita para una transicion.
     */
    public es.pode.publicacion.negocio.servicios.DetalleTransicionVO[] getDetalleTransicionVOs()
    {
        return this.detalleTransicionVOs;
    }

  /**
   * Setter of detalleTransicionVOs  
   *  @param detalleTransicionVOs  Este value object contiene la informacion de detalle que se necesita para una transicion. 
   */
    public void setDetalleTransicionVOs(es.pode.publicacion.negocio.servicios.DetalleTransicionVO[] detalleTransicionVOs)
    {
        this.detalleTransicionVOs = detalleTransicionVOs;
    }

}