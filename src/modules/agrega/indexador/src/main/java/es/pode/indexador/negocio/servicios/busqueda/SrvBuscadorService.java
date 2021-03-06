// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
package es.pode.indexador.negocio.servicios.busqueda;

/**
 * <p>
 * Este servicio implementa la funcionalidad de busqueda de odes
 * sobre los odes indexados.
 * </p>
 */
public interface SrvBuscadorService
{
  /**
   * <p>
   * Permite una b�squeda avanzada por distintos campos en el
   * repositorio de ODEs indexados
   * </p>
   * <p>
   * Retorna los documentos que cumplen con la b�squeda.
   * </p>
      * @param paramBusq  Par�metros para la b�squeda avanzada
      * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaAvanzada(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO paramBusq);

  /**
   * <p>
   * Permite la b�squeda de cadenas de texto en el repositorio de
   * ODEs indexados.
   * </p>
      * @param paramBusq  Par�metros de la b�squeda
      * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaSimple(es.pode.indexador.negocio.servicios.busqueda.ParamSimpleVO paramBusq);

  /**
   * <p>
   * Este metodo tiene que buscar los resultados que ajusten a los
   * parametros de busqueda. Ordena los resultados y los devuelve
   * convertidos en un texto LOM-ES.
   * </p>
      * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO busquedaLOM_ES(es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO paramBusq);

  /**
   * <p>
   * Este metodo realiza una busqueda utilizando el identificador MEC
   * de un ODE como parametro de busqueda.
   * </p>
   * <p>
   * En el caso de encontrar un resultado, devuelve un VO con la
   * coleccion de caracteristicas que describen el ODE. En el caso de
   * no encontrar ningun resultado, no devuelve nada.
   * </p>
      * @param identificadorMEC  Identificador alfanumerico MEC que identifica un ODE de forma unica.
         * @param idiomaBusqueda  Idioma en el que se realiza la busqueda.
      * @return es.pode.indexador.negocio.servicios.busqueda.DocVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocVO busquedaMEC(java.lang.String identificadorMEC, java.lang.String idiomaBusqueda);

  /**
   * <p>
   * Este m�todo realiza una b�squeda que devuelve el n�mero de
   * documentos asociados a un �rea curricular en funci�n de unos
   * par�metros que se le pasan.
   * </p>
      * @param paramBusq  Alberga los par�metros necesarios para realizar la solicitud del n�mero de documentos asociados a un �rea curricular.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO solicitudDocsCount(es.pode.indexador.negocio.servicios.busqueda.ParamDocsCountVO paramBusq);

  /**
   * <p>
   * Este m�todo realiza una b�squeda por �rbol curricular dentro del
   * �ndice y devuelve los elementos que hay en el �ndice
   * perteneciente a dicha rama.
   * </p>
   * <p>
   * Retorna los documentos que cumplen con la b�squeda.
   * </p>
      * @param paramBusq  VO que alberga los par�metros que acepta una b�squeda por nodo de �rbol curricular.
      * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaDocsNodoArbolCurricular(es.pode.indexador.negocio.servicios.busqueda.ParamNodoArbolCurricularVO paramBusq);

  /**
   * <p>
   * Este metodo busca los documentos que tienen fecha entre las
   * fechas desde y hasta dados y que tengan el campo de arbol
   * curricular nodo coincidente con el identificador de nodo que le
   * pasan. Esto devuelve el numero de documentos indexados que estan
   * catalogados exactamente en ese nodo de arbol curricular.
   * </p>
      * @param idNodo  Identificador del nodo de arbol curricular del que se quiere averiguar el numero de documentos que tiene asociados.
         * @param fechaDesde  Fecha desde del periodo en el que se esta interesado.
         * @param fechaHasta  Fecha hasta del periodo en el que se esta interesado.
         * @param idioma  Iidoma del indice donde buscar.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO busquedaDocsNodoFechaArbolCurricular(java.lang.String idNodo, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idioma);

  /**
   * <p>
   * Este metodo busca los documentos indexados que cumplan tener la
   * valoracion que le pasan dentro de las fechas desde y hasta.
   * </p>
      * @param nivelAgregacion  Valor de nivel de agregacion.
         * @param fechaDesde  Fecha desde del periodo en el que se esta interesado.
         * @param fechaHasta  Fecha hasta del periodo en el que se esta interesado.
         * @param idioma  Idioma del indice donde buscar.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO busquedaDocsRangoFechaNivelAgregacion(java.lang.String nivelAgregacion, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idioma);

  /**
   * <p>
   * Este metodo busca los documentos indexados que cumplen estar
   * dentro del rango de fechas dado y que tengan el valor de
   * licencia dado.
   * </p>
      * @param licencia  Licencia de la que se quiere saber el numero de documentos que la contiene.
         * @param fechaDesde  Fecha desde del periodo en el que se esta interesado.
         * @param fechaHasta  Fecha hasta del periodo en el que se esta interesado.
         * @param idioma  Idioma del indice donde buscar.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO busquedaDocsLicenciaFecha(java.lang.String licencia, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idioma);

  /**
   * <p>
   * Este m�todo realiza una b�squeda en el �ndice para devolver la
   * nube de tags.
   * </p>
   * <p>
   * Retorna el listado obtenido del �ndice con el n�mero de
   * resultados.
   * </p>
      * @param paramBusq  Par�metro que alberga los datos con la informaci�n necesaria para realizar la b�squeda en el �ndice de la nube de tags
      * @return es.pode.indexador.negocio.servicios.busqueda.PrioridadPalabrasClaveVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.PrioridadPalabrasClaveVO obtenerPalabrasClave(es.pode.indexador.negocio.servicios.busqueda.ParamPalabrasClave paramBusq);

  /**
   * <p>
   * Este metodo busca el identificador en todo el repositorio del
   * indexador.
   * </p>
      * @param idMEC  Identificador del ODE que se quiere buscar dentro del repositorio del indice.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO busquedaMECRepositorio(java.lang.String idMEC);

  /**
   * <p>
   * Este metodo busca los ODEs indexados en todos los indices que
   * cumplan las condiciones de busqueda que le pasan como parametro.
   * </p>
   * <p>
   * Las fechas desde y hasta se interpretan inclusives y en el caso
   * de no estar presentes, sin limite superior o inferior.
   * </p>
      * @param paramBusq  Parametros de busqueda de ODEs dentro del repositorio.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[]
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] busquedaHeadersRepositorio(es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO paramBusq);

  /**
   * <p>
   * Metodo que ejecuta una busqueda en todo el repositorio con los
   * parametros de busqueda que le pasan.
   * </p>
      * @param paramBusq  Periodo desde hasta en el que se esta interesado buscar en el repositorio.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[]
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] busquedaRepositorio(es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO paramBusq);

  /**
   * <p>
   * Este metodo devuelve la fecha del ODE mas viejo indexado en el
   * repositorio.
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar fechaInicioRepositorio();

  /**
   * <p>
   * Este metodo busca un ODE al azar de dentro del repositorio.
   * </p>
   * @return es.pode.indexador.negocio.servicios.busqueda.DocVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocVO obtenerODERandom();

  /**
   * <p>
   * Este metodo devuelve todos los ODEs indexados en el repositorio
   * para todos los idiomas, pero solo devuelve los ODEs publicos.
   * </p>
   * @return es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO[]
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO[] obtenerRepositorio();

  /**
   * <p>
   * Metodo para recoger los ODE que tienen el nivel de agregacion
   * mayor o igual el que le pasan.
   * </p>
      * @param nivelAgregacion  Nivel de agregacion minimo que tienen que cumplir los ODEs del catalogo que se genere.
      * @return es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO[]
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO[] obtenerCatalogoRepositorioParam(java.lang.Integer nivelAgregacion);

  /**
   * <p>
   * Obtiene el n�mero total de odes que existen en todos los indices
   * </p>
   * @return es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO obtenerTotalesRepositorio();

  /**
   * <p>
   * Metodo para obtener la busqueda e introducirle la localizacion
   * de la ficha
   * </p>
      * @param paramBusqueda  Los parametros de busqueda
      * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO
   */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO busquedaLOM_ESVSQL(es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO paramBusqueda);

}
