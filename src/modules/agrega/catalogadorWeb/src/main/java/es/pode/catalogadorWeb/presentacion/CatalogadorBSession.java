// license-header java merge-point
package es.pode.catalogadorWeb.presentacion;

import java.io.Serializable;

/**
 * <p>
 * Objeto de sesion que mantendra cargados en memoria los datos
 * recogidos del formulario del catalogador basico para poder
 * recargarlos en la navegacion de pantallas.
 * </p>
 */
public class CatalogadorBSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "catalogadorBSession";

    private es.pode.catalogacion.negocio.servicios.LomBasicoVO MBOSesion;

  /**
   * <p>
   * LomBasicoVO que recoge todos los campos del formulario
   * clasificados en las categorias General, Educational y
   * Classification.
   * </p>
   * <p>
   * Este atributo puede ser nulo, ya que al inicio de la sesion en
   * el catalogador aun no habra sido cargado con ningun valor.
   * </p>
   * @return es.pode.catalogacion.negocio.servicios.LomBasicoVO
   */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO getMBOSesion()
    {
        return this.MBOSesion;
    }

  /**
   * <p>
   * LomBasicoVO que recoge todos los campos del formulario
   * clasificados en las categorias General, Educational y
   * Classification.
   * </p>
   * <p>
   * Este atributo puede ser nulo, ya que al inicio de la sesion en
   * el catalogador aun no habra sido cargado con ningun valor.
   * </p>
   *  @param MBOSesion  LomBasicoVO que recoge todos los campos del formulario clasificados en las categorias General, Educational y Classification.
 Este atributo puede ser nulo, ya que al inicio de la sesion en el catalogador aun no habra sido cargado con ningun valor.  
   */
    public void setMBOSesion(es.pode.catalogacion.negocio.servicios.LomBasicoVO MBOSesion)
    {
        this.MBOSesion = MBOSesion;
    }

    private java.lang.String idioma;

  /**
   * <p>
   * Idioma en el que el usuario esta navegando por el catalogador
   * basico. Dicho idioma estara asociado al perfil de usuario.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }

  /**
   * <p>
   * Idioma en el que el usuario esta navegando por el catalogador
   * basico. Dicho idioma estara asociado al perfil de usuario.
   * </p>
   *  @param idioma  Idioma en el que el usuario esta navegando por el catalogador basico. Dicho idioma estara asociado al perfil de usuario.  
   */
    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    private java.lang.String usuario;

  /**
   * <p>
   * Usuario que esta realizando la catalogacion.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getUsuario()
    {
        return this.usuario;
    }

  /**
   * <p>
   * Usuario que esta realizando la catalogacion.
   * </p>
   *  @param usuario  Usuario que esta realizando la catalogacion.  
   */
    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    private java.lang.String identificador;

  /**
   * <p>
   * Identificador del objeto propietario del metadato LOM-ES que se
   * esta editando en el catalogador.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }

  /**
   * <p>
   * Identificador del objeto propietario del metadato LOM-ES que se
   * esta editando en el catalogador.
   * </p>
   *  @param identificador  Identificador del objeto propietario del metadato LOM-ES que se esta editando en el catalogador.  
   */
    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    private java.util.Collection arbolesController;

  /**
   * <p>
   * Coleccion que contiene las diferentes rutas de taxones recogidas
   * del arbol curricular.
   * </p>
   * @return java.util.Collection
   */
    public java.util.Collection getArbolesController()
    {
        return this.arbolesController;
    }

  /**
   * <p>
   * Coleccion que contiene las diferentes rutas de taxones recogidas
   * del arbol curricular.
   * </p>
   *  @param arbolesController  Coleccion que contiene las diferentes rutas de taxones recogidas del arbol curricular.  
   */
    public void setArbolesController(java.util.Collection arbolesController)
    {
        this.arbolesController = arbolesController;
    }

    private java.lang.String returnURL;

    public java.lang.String getReturnURL()
    {
        return this.returnURL;
    }

    public void setReturnURL(java.lang.String returnURL)
    {
        this.returnURL = returnURL;
    }

    private javax.activation.DataHandler lomesImportado;

    public javax.activation.DataHandler getLomesImportado()
    {
        return this.lomesImportado;
    }

    public void setLomesImportado(javax.activation.DataHandler lomesImportado)
    {
        this.lomesImportado = lomesImportado;
    }


}
