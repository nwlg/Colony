// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
package es.pode.indexador.negocio.servicios.auditoria;

/**
 * <p>
 * Esta clase implementa el servicio que da soporte a todos los
 * metodos de auditoria del modulo de indexacion.
 * </p>
 */
public interface SrvAuditoriaIndexadorService
{
  /**
   * <p>
   * Este metodo recibe un recorrido de arbol curricular y devuelve
   * el recubrimiento del mismo que hacen los elementos que estan
   * indexados en el repositorio.
   * </p>
      * @param parametroAuditoria  Parametros del metodo para indicar el nodo de cobertura y las fechas desde y hasta ivolucradas en el periodo de tiempo.
      * @return es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[]
   */
    public es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] coberturaArbolCurricular(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO parametroAuditoria);

  /**
   * <p>
   * Este metodo devuelve el nivel de cobertura que tienen los
   * elementos del indice sobre el nivel de agregacion.
   * </p>
      * @param parametroAuditoria  Paramerto con todos los elementos necesarios para la ejecucion del metodo con las fechas involucradas en el periodo de tiempo.
      * @return es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[]
   */
    public es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] coberturaNivelAgregacion(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO parametroAuditoria);

  /**
   * <p>
   * Este metodo devuelve el nivel de cobertura de los elementos
   * indexados sobre todas las licencias.
   * </p>
      * @param parametroAuditoria  Parametro con todos los elementos para la ejecucion del metodo, incluyendo los periodos de tiempo ivolucrados
      * @return es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[]
   */
    public es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] coberturaLicencias(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO parametroAuditoria);

  /**
   * <p>
   * Metodo que devuelve las URLs de las imagenes pequenas de los
   * identificadores que le pasamos
   * </p>
      * @param idioma  El idioma para acceder al archivo del indexador
         * @param identificadores  Los identificadores mec
      * @return java.lang.String[]
   */
    public java.lang.String[] obtenerURLImagenPequena(java.lang.String idioma, java.lang.String[] identificadores);

}
