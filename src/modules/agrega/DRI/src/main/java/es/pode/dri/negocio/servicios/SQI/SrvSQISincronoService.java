// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
package es.pode.dri.negocio.servicios.SQI;

/**
 * <p>
 * Esta clase implementa los metodos sincronos de busqueda del
 * modulo del intergfaz SQI.
 * </p>
 */
public interface SrvSQISincronoService
{
  /**
   * <p>
   * Este metodo realiza la query que se le pasa sobre la sesion que
   * indica. Recoge los resulados que genera y los devuelve teniendo
   * en cuenta el numero maximo de resultados para una query, el
   * numero de resultados de un result set y el indice del resultado
   * a partir del cual se esta interesado.
   * </p>
   * <p>
   * Se devuelve el resultado de la consulta.
   * </p>
      * @param targetSessionID  Identificador de la sesion que se va a utilizar.
         * @param queryStatement  Sentencia que se va a ejecutar.
         * @param startResult  Numero que indica el registro de comienzo del result set devuelto.
 Esta cifra existe en combinacion con el numero de resultados devueltos en un result set y el numero maximo de resultados por query.
 Una cifra correcta se encuentra entre 1 y el maximo numero de resultados por query.
 Para una consulta dada, se podrian recoger 5 resulados (numero de resultados devueltos en un result set) empezando por el decimo (con un startResult de 10) de una consulta que dio un maximo de resultados de 300.
 Ver documento: ftp://ftp.cenorm.be/PUBLIC/CWAs/e-Europe/WS-LT/CWA15454-00-2005-Nov.pdf pagina 19-20
      * @return java.lang.String
   */
    public java.lang.String synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult);

}
