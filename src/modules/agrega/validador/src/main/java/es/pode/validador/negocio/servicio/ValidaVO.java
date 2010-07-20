// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.validador.negocio.servicio;

/**
 * <p>
 * Tipo que sera devuelto por los metodos del servicio. Esta
 * compuesto por tres Atributos:
 * </p>
 * <p>
 * rutaManifest: su tipo es string e informa de la ruta donde se
 * encuentra el fichero                                   
 * principal imsmanifest.xml
 * </p>
 * <p>
 * esValidoManifes: su tipo es Boolean e informa de si la
 * validacion ha sido correcta o no
 * </p>
 * <p>
 * resultadoValidacion: su tipo es String e informa de los errores
 * que se han producido con una serie de codigos que se detallan a
 * continuacion:
 * </p>
 * <p>
 * 0.0 sin errores
 * </p>
 * <p>
 * 1.1 imsmanifest es incorrecto
 * </p>
 * <p>
 * 1.2 error de parseo en el manifest
 * </p>
 * <p>
 * 1.3 error, la etiqueta principal debe ser manifest o lom
 * </p>
 * <p>
 * 1.4 error de chequeo de contenidos
 * </p>
 * <p>
 * 2.1 el LOM-ES es obligatorio para metadata
 * </p>
 * <p>
 * 2.2 el LOM-ES es incorrecto
 * </p>
 * <p>
 * 2.3 el LOM-ES es incorrecto para la etiqueta de organizaciones
 * </p>
 * <p>
 * 3.1 no existe el ODE
 * </p>
 * <p>
 * 4.1 los datos del formulario son obligatorios
 * </p>
 * <p>
 * 4.2 el Titulo es obligatorio
 * </p>
 * <p>
 * 4.3 el Idioma es obligatorio
 * </p>
 * <p>
 * 4.4 la Descripcion es obligatoria
 * </p>
 * <p>
 * 4.5 el Tipo es obligatorio
 * </p>
 * <p>
 * 4.6 el Contexto es obligatorio
 * </p>
 * <p>
 * 4.7 la Edad es obligatoria
 * </p>
 * <p>
 * 4.8 el Idioma Destino es obligatorio
 * </p>
 * <p>
 * 4.9 el Proceso Cognitivo es obligatorio
 * </p>
 * <p>
 * detalleValidacion: de tipo String, donde se recogerán los
 * errores de Xerces cuando se produzca un error en el parseo
 * contra esquemas.
 * </p>
 */
public class ValidaVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public ValidaVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param rutaManifest  
     * @param esValidoManifest  
     * @param resultadoValidacion  
     * @param errores  
     */
    public ValidaVO(
        java.lang.String rutaManifest,
        java.lang.Boolean esValidoManifest,
        java.lang.String resultadoValidacion,
        es.pode.validador.negocio.servicio.ErrorParseoVO[] errores)

    {
        this.rutaManifest = rutaManifest;
        this.esValidoManifest = esValidoManifest;
        this.resultadoValidacion = resultadoValidacion;
        this.errores = errores;
    }

    /**
     * Copies constructor from other ValidaVO
     * @param otherBean ValidaVO 
     */
    public ValidaVO(ValidaVO otherBean)
    {
        if (otherBean != null)
        {
            this.rutaManifest = otherBean.getRutaManifest();
            this.esValidoManifest = otherBean.getEsValidoManifest();
            this.resultadoValidacion = otherBean.getResultadoValidacion();
            this.errores = otherBean.getErrores();
        }
    }

    private java.lang.String rutaManifest;

    public java.lang.String getRutaManifest()
    {
        return this.rutaManifest;
    }

    public void setRutaManifest(java.lang.String rutaManifest)
    {
        this.rutaManifest = rutaManifest;
    }

    private java.lang.Boolean esValidoManifest;

    public java.lang.Boolean getEsValidoManifest()
    {
        return this.esValidoManifest;
    }

    public void setEsValidoManifest(java.lang.Boolean esValidoManifest)
    {
        this.esValidoManifest = esValidoManifest;
    }

    private java.lang.String resultadoValidacion;

    public java.lang.String getResultadoValidacion()
    {
        return this.resultadoValidacion;
    }

    public void setResultadoValidacion(java.lang.String resultadoValidacion)
    {
        this.resultadoValidacion = resultadoValidacion;
    }

    /**
   * <p>
   * Objeto VO conteniendo los datos del mensaje de error devuelto en
   * el parseo contra esquema de los manifiestos.
   * </p>
     */
    private es.pode.validador.negocio.servicio.ErrorParseoVO[] errores;

    /**
     * Getter of errores.  
     * @return es.pode.validador.negocio.servicio.ErrorParseoVO[]  Objeto VO conteniendo los datos del mensaje de error devuelto en el parseo contra esquema de los manifiestos.
     */
    public es.pode.validador.negocio.servicio.ErrorParseoVO[] getErrores()
    {
        return this.errores;
    }

  /**
   * Setter of errores  
   *  @param errores  Objeto VO conteniendo los datos del mensaje de error devuelto en el parseo contra esquema de los manifiestos. 
   */
    public void setErrores(es.pode.validador.negocio.servicio.ErrorParseoVO[] errores)
    {
        this.errores = errores;
    }

}