// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.publicacion.negocio.servicios;

/**
 * <p>
 * Este Value Object modela todos aquellos atributos relevantes del
 * ODE que estan en el LOM-ES de catalogacion secundario del ODE.
 * </p>
 */
public class LomESSecundarioVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public LomESSecundarioVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param titulo  Titulo de un LOM-ES secundario.
     * @param palabrasClave  Son las palabras clave de catalogacion de un LOM-ES secundario.
     * @param descripcion  Descripcion de una catalogacion secundaria.
     */
    public LomESSecundarioVO(
        java.lang.String titulo,
        java.lang.String[] palabrasClave,
        java.lang.String descripcion)

    {
        this.titulo = titulo;
        this.palabrasClave = palabrasClave;
        this.descripcion = descripcion;
    }

    /**
     * Copies constructor from other LomESSecundarioVO
     * @param otherBean LomESSecundarioVO 
     */
    public LomESSecundarioVO(LomESSecundarioVO otherBean)
    {
        if (otherBean != null)
        {
            this.titulo = otherBean.getTitulo();
            this.palabrasClave = otherBean.getPalabrasClave();
            this.descripcion = otherBean.getDescripcion();
        }
    }

    private java.lang.String titulo;

    /**
     * <p>
     * Titulo de un LOM-ES secundario.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    /**
   * <p>
   * Titulo de un LOM-ES secundario.
   * </p>
     *  @param titulo  Titulo de un LOM-ES secundario.  
     */
    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.String[] palabrasClave;

    /**
     * <p>
     * Son las palabras clave de catalogacion de un LOM-ES secundario.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getPalabrasClave()
    {
        return this.palabrasClave;
    }

    /**
   * <p>
   * Son las palabras clave de catalogacion de un LOM-ES secundario.
   * </p>
     *  @param palabrasClave  Son las palabras clave de catalogacion de un LOM-ES secundario.  
     */
    public void setPalabrasClave(java.lang.String[] palabrasClave)
    {
        this.palabrasClave = palabrasClave;
    }

    private java.lang.String descripcion;

    /**
     * <p>
     * Descripcion de una catalogacion secundaria.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getDescripcion()
    {
        return this.descripcion;
    }

    /**
   * <p>
   * Descripcion de una catalogacion secundaria.
   * </p>
     *  @param descripcion  Descripcion de una catalogacion secundaria.  
     */
    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }

}