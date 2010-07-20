// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
package es.pode.dri.negocio.servicios.Sesion;

/**
 * <p>
 * Este servicio implementa la administracion de las sesiones que
 * hay que mantener en el DRI para dar soporte a la funcionalidad
 * de SQI.
 * </p>
 * <p>
 * Se trata de un servicio local.
 * </p>
 */
public interface SrvSesionesService
{
  /**
   * <p>
   * Este metodo crea una nueva sesion asociada al usuario.
   * </p>
   * <p>
   * Devuelve el identificador de la sesion creada.
   * </p>
   * <p>
   * Chequea contra el autenticador la identidad del usuario que
   * intenta crear una conexion.
   * </p>
      * @param userID  Usuaro que crea la sesion.
         * @param password  Clave del usuario que crea la sesion.
      * @return java.lang.String
   * @throws throws es.pode.dri.negocio.servicios.Sesion.WrongCredentialsException Exception
   */
    public java.lang.String createSession(java.lang.String userID, java.lang.String password)
        throws es.pode.dri.negocio.servicios.Sesion.WrongCredentialsException;

  /**
   * <p>
   * Este metodo crea una sesion sin usuario definido o con usuario
   * anonimo.
   * </p>
   * <p>
   * Devuelve el identificador de lla sesion creada.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String createAnonymousSession();

  /**
   * <p>
   * Este metodo limpia las sesiones caducadas almacenadas en la
   * tabla de sesiones.
   * </p>
   * @throws throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException Exception
   */
    public void limpiarSesiones()
        throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException;

  /**
   * <p>
   * Este metodo borra una sesion del sistema.
   * </p>
   * <p>
   * Toma como parametro el identificador de la sesion que se quiere
   * eliminar.
   * </p>
      * @param sessionID  Identificador de la sesion que se quiere eliminar.
      * @throws throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException Exception
   */
    public void destroySession(java.lang.String sessionID)
        throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException;

  /**
   * <p>
   * Este metodo devuelve una sesion.
   * </p>
   * <p>
   * Toma como parametro de entrada el identificador de una sesion.
   * </p>
   * <p>
   * Devuelve la sesion con ese identificador.
   * </p>
      * @param id  Identificador de la sesion.
      * @return es.pode.dri.negocio.servicios.SesionVO
   * @throws throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException Exception
   */
    public es.pode.dri.negocio.servicios.SesionVO consultaSesion(java.lang.String id)
        throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException;

  /**
   * <p>
   * Este metodo modifica una sesion.
   * </p>
   * <p>
   * Le pasan la sesion que se tiene que modificar con los parametros
   * modificados.
   * </p>
   * <p>
   * Se tiene que comprobar que dicha sesion existe antes de
   * modificarla.
   * </p>
      * @param sesion  La sesion que se ha de modificar.
      * @return es.pode.dri.negocio.servicios.SesionVO
   * @throws throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException Exception
   */
    public es.pode.dri.negocio.servicios.SesionVO modificarSesion(es.pode.dri.negocio.servicios.SesionVO sesion)
        throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException;

}
