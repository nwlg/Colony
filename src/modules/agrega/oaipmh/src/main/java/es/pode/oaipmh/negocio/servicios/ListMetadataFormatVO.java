// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.oaipmh.negocio.servicios;

/**
 * <p>
 * Value Object con todos los posibles valores de metadatos que
 * devuelve el repositorio
 * </p>
 */
public class ListMetadataFormatVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public ListMetadataFormatVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param nombreMetadato  Nombre del metadato
     * @param esquema  Url del esquema (xsd) del metadato de la respuesta. En nuestro caso se devolverá en formato dublin core
     * @param espacioNombres  Url con el espacio de nombres de los metadatos en los que se devolverá el contenido del repositorio
     */
    public ListMetadataFormatVO(
        java.lang.String nombreMetadato,
        java.lang.String esquema,
        java.lang.String espacioNombres)

    {
        this.nombreMetadato = nombreMetadato;
        this.esquema = esquema;
        this.espacioNombres = espacioNombres;
    }

    /**
     * Copies constructor from other ListMetadataFormatVO
     * @param otherBean ListMetadataFormatVO 
     */
    public ListMetadataFormatVO(ListMetadataFormatVO otherBean)
    {
        if (otherBean != null)
        {
            this.nombreMetadato = otherBean.getNombreMetadato();
            this.esquema = otherBean.getEsquema();
            this.espacioNombres = otherBean.getEspacioNombres();
        }
    }

    private java.lang.String nombreMetadato;

    /**
     * <p>
     * Nombre del metadato
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getNombreMetadato()
    {
        return this.nombreMetadato;
    }

    /**
   * <p>
   * Nombre del metadato
   * </p>
     *  @param nombreMetadato  Nombre del metadato  
     */
    public void setNombreMetadato(java.lang.String nombreMetadato)
    {
        this.nombreMetadato = nombreMetadato;
    }

    private java.lang.String esquema;

    /**
     * <p>
     * Url del esquema (xsd) del metadato de la respuesta. En nuestro
     * caso se devolverá en formato dublin core
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getEsquema()
    {
        return this.esquema;
    }

    /**
   * <p>
   * Url del esquema (xsd) del metadato de la respuesta. En nuestro
   * caso se devolverá en formato dublin core
   * </p>
     *  @param esquema  Url del esquema (xsd) del metadato de la respuesta. En nuestro caso se devolverá en formato dublin core  
     */
    public void setEsquema(java.lang.String esquema)
    {
        this.esquema = esquema;
    }

    private java.lang.String espacioNombres;

    /**
     * <p>
     * Url con el espacio de nombres de los metadatos en los que se
     * devolverá el contenido del repositorio
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getEspacioNombres()
    {
        return this.espacioNombres;
    }

    /**
   * <p>
   * Url con el espacio de nombres de los metadatos en los que se
   * devolverá el contenido del repositorio
   * </p>
     *  @param espacioNombres  Url con el espacio de nombres de los metadatos en los que se devolverá el contenido del repositorio  
     */
    public void setEspacioNombres(java.lang.String espacioNombres)
    {
        this.espacioNombres = espacioNombres;
    }

}