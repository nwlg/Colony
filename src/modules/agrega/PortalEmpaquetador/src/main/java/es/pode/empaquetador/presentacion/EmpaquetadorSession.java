// license-header java merge-point
package es.pode.empaquetador.presentacion;

import java.io.Serializable;

/**
 * <p>
 * Objeto de sesión del Empaquetador. Contiene los elementos
 * necesarios para las diferentes actividades que se llevan a cabo
 * durante la creación de un ODE.
 * </p>
 */
public class EmpaquetadorSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "empaquetadorSession";

    private es.pode.empaquetador.negocio.servicio.OdeVO ode;

  /**
   * <p>
   * ODE en edición.
   * </p>
   * @return es.pode.empaquetador.negocio.servicio.OdeVO
   */
    public es.pode.empaquetador.negocio.servicio.OdeVO getOde()
    {
        return this.ode;
    }

  /**
   * <p>
   * ODE en edición.
   * </p>
   *  @param ode  ODE en edición.  
   */
    public void setOde(es.pode.empaquetador.negocio.servicio.OdeVO ode)
    {
        this.ode = ode;
    }

    private java.util.List portapapeles;

  /**
   * <p>
   * Elementos GrupoVO que se han copiado/cortado y que estan
   * disponibles para pegar.
   * </p>
   * @return java.util.List
   */
    public java.util.List getPortapapeles()
    {
        return this.portapapeles;
    }

  /**
   * <p>
   * Elementos GrupoVO que se han copiado/cortado y que estan
   * disponibles para pegar.
   * </p>
   *  @param portapapeles  Elementos GrupoVO que se han copiado/cortado y que estan disponibles para pegar.  
   */
    public void setPortapapeles(java.util.List portapapeles)
    {
        this.portapapeles = portapapeles;
    }

    private boolean catalogado;

  /**
   * <p>
   * Flag que indica si el ODE ha sido catalogado.
   * </p>
   * @return boolean
   */
    public boolean isCatalogado()
    {
        return this.catalogado;
    }

  /**
   * <p>
   * Flag que indica si el ODE ha sido catalogado.
   * </p>
   *  @param catalogado  Flag que indica si el ODE ha sido catalogado.  
   */
    public void setCatalogado(boolean catalogado)
    {
        this.catalogado = catalogado;
    }

    private java.lang.Boolean vistaCarpeta;

  /**
   * <p>
   * Flag para marcar la vista seleccionada:
   * </p>
   * <p>
   * true = Vista por carpeta
   * </p>
   * <p>
   * false = Vista plana
   * </p>
   * @return java.lang.Boolean
   */
    public java.lang.Boolean getVistaCarpeta()
    {
        return this.vistaCarpeta;
    }

  /**
   * <p>
   * Flag para marcar la vista seleccionada:
   * </p>
   * <p>
   * true = Vista por carpeta
   * </p>
   * <p>
   * false = Vista plana
   * </p>
   *  @param vistaCarpeta  Flag para marcar la vista seleccionada:
 true = Vista por carpeta
 false = Vista plana  
   */
    public void setVistaCarpeta(java.lang.Boolean vistaCarpeta)
    {
        this.vistaCarpeta = vistaCarpeta;
    }

    private es.pode.empaquetador.negocio.servicio.ValidaVO validacion;

  /**
   * <p>
   * Objeto resultado de la última validación.
   * </p>
   * @return es.pode.empaquetador.negocio.servicio.ValidaVO
   */
    public es.pode.empaquetador.negocio.servicio.ValidaVO getValidacion()
    {
        return this.validacion;
    }

  /**
   * <p>
   * Objeto resultado de la última validación.
   * </p>
   *  @param validacion  Objeto resultado de la última validación.  
   */
    public void setValidacion(es.pode.empaquetador.negocio.servicio.ValidaVO validacion)
    {
        this.validacion = validacion;
    }

    private java.util.List idCollection;

  /**
   * <p>
   * Contiene los grupos sobre los que se esta navegando, desde la
   * organizacion principal hasta el grupo actual.
   * </p>
   * <p>
   * En el caso del empaquetador avanzado, donde se permite navegar
   * en los submanifiestos, idCollection se reinicia cada vez que se
   * navega dentro o fuera de un submanifiesto, tomando los grupos
   * del OdeVO almacenado en la ultima posicion de submanifestPath.
   * </p>
   * @return java.util.List
   */
    public java.util.List getIdCollection()
    {
        return this.idCollection;
    }

  /**
   * <p>
   * Contiene los grupos sobre los que se esta navegando, desde la
   * organizacion principal hasta el grupo actual.
   * </p>
   * <p>
   * En el caso del empaquetador avanzado, donde se permite navegar
   * en los submanifiestos, idCollection se reinicia cada vez que se
   * navega dentro o fuera de un submanifiesto, tomando los grupos
   * del OdeVO almacenado en la ultima posicion de submanifestPath.
   * </p>
   *  @param idCollection  Contiene los grupos sobre los que se esta navegando, desde la organizacion principal hasta el grupo actual.
 En el caso del empaquetador avanzado, donde se permite navegar en los submanifiestos, idCollection se reinicia cada vez que se navega dentro o fuera de un submanifiesto, tomando los grupos del OdeVO almacenado en la ultima posicion de submanifestPath.  
   */
    public void setIdCollection(java.util.List idCollection)
    {
        this.idCollection = idCollection;
    }

    private java.util.List pendientesCatalogacion;

  /**
   * <p>
   * Lista de identificadores que han sido catalogados pero no estan
   * insertados en el manifest de servicio.
   * </p>
   * @return java.util.List
   */
    public java.util.List getPendientesCatalogacion()
    {
        return this.pendientesCatalogacion;
    }

  /**
   * <p>
   * Lista de identificadores que han sido catalogados pero no estan
   * insertados en el manifest de servicio.
   * </p>
   *  @param pendientesCatalogacion  Lista de identificadores que han sido catalogados pero no estan insertados en el manifest de servicio.  
   */
    public void setPendientesCatalogacion(java.util.List pendientesCatalogacion)
    {
        this.pendientesCatalogacion = pendientesCatalogacion;
    }

    private java.lang.String accion;

  /**
   * <p>
   * Flag que permite distinguir la accion a realizar cuando el
   * portapapeles esta lleno: CORTAR, COPIAR, NORMAL.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getAccion()
    {
        return this.accion;
    }

  /**
   * <p>
   * Flag que permite distinguir la accion a realizar cuando el
   * portapapeles esta lleno: CORTAR, COPIAR, NORMAL.
   * </p>
   *  @param accion  Flag que permite distinguir la accion a realizar cuando el portapapeles esta lleno: CORTAR, COPIAR, NORMAL.  
   */
    public void setAccion(java.lang.String accion)
    {
        this.accion = accion;
    }

    private boolean modoPegar;

  /**
   * <p>
   * Flag para indicar si el modo copiar/pegar esta bloqueado hasta
   * que se pegue o se vacie el contenido del portapapeles.
   * </p>
   * @return boolean
   */
    public boolean isModoPegar()
    {
        return this.modoPegar;
    }

  /**
   * <p>
   * Flag para indicar si el modo copiar/pegar esta bloqueado hasta
   * que se pegue o se vacie el contenido del portapapeles.
   * </p>
   *  @param modoPegar  Flag para indicar si el modo copiar/pegar esta bloqueado hasta que se pegue o se vacie el contenido del portapapeles.  
   */
    public void setModoPegar(boolean modoPegar)
    {
        this.modoPegar = modoPegar;
    }

    private java.util.List submanifestPath;

  /**
   * <p>
   * En el gestor avanzado es posible navegar a traves de los
   * submanifiestos, reabriendo el gestor avanzado con el
   * submanifiesto en lugar del manifiesto principal. Esta lista
   * permite mantener el control del submanifiesto en que nos
   * encontramos. El la actividad Iniciar Edicion Ode, la lista se
   * inicializa con el Ode principal. Cada vez que navegamos en un
   * submanifiesto, se añada el submanifiesto a la lista.
   * </p>
   * @return java.util.List
   */
    public java.util.List getSubmanifestPath()
    {
        return this.submanifestPath;
    }

  /**
   * <p>
   * En el gestor avanzado es posible navegar a traves de los
   * submanifiestos, reabriendo el gestor avanzado con el
   * submanifiesto en lugar del manifiesto principal. Esta lista
   * permite mantener el control del submanifiesto en que nos
   * encontramos. El la actividad Iniciar Edicion Ode, la lista se
   * inicializa con el Ode principal. Cada vez que navegamos en un
   * submanifiesto, se añada el submanifiesto a la lista.
   * </p>
   *  @param submanifestPath  En el gestor avanzado es posible navegar a traves de los submanifiestos, reabriendo el gestor avanzado con el submanifiesto en lugar del manifiesto principal. Esta lista permite mantener el control del submanifiesto en que nos encontramos. El la actividad Iniciar Edicion Ode, la lista se inicializa con el Ode principal. Cada vez que navegamos en un submanifiesto, se añada el submanifiesto a la lista.  
   */
    public void setSubmanifestPath(java.util.List submanifestPath)
    {
        this.submanifestPath = submanifestPath;
    }

    private java.lang.String tipoEmpaquetador;

    public java.lang.String getTipoEmpaquetador()
    {
        return this.tipoEmpaquetador;
    }

    public void setTipoEmpaquetador(java.lang.String tipoEmpaquetador)
    {
        this.tipoEmpaquetador = tipoEmpaquetador;
    }

    private boolean guardadoPrimeraVez;

    public boolean isGuardadoPrimeraVez()
    {
        return this.guardadoPrimeraVez;
    }

    public void setGuardadoPrimeraVez(boolean guardadoPrimeraVez)
    {
        this.guardadoPrimeraVez = guardadoPrimeraVez;
    }

    private java.lang.String urlCerrar;

    public java.lang.String getUrlCerrar()
    {
        return this.urlCerrar;
    }

    public void setUrlCerrar(java.lang.String urlCerrar)
    {
        this.urlCerrar = urlCerrar;
    }

    private java.lang.String idLocalizador;

    public java.lang.String getIdLocalizador()
    {
        return this.idLocalizador;
    }

    public void setIdLocalizador(java.lang.String idLocalizador)
    {
        this.idLocalizador = idLocalizador;
    }

    private java.lang.Boolean esOffline;

    public java.lang.Boolean getEsOffline()
    {
        return this.esOffline;
    }

    public void setEsOffline(java.lang.Boolean esOffline)
    {
        this.esOffline = esOffline;
    }

    private java.lang.String espacioLibre;

    public java.lang.String getEspacioLibre()
    {
        return this.espacioLibre;
    }

    public void setEspacioLibre(java.lang.String espacioLibre)
    {
        this.espacioLibre = espacioLibre;
    }

    private java.lang.String espacioOde;

    public java.lang.String getEspacioOde()
    {
        return this.espacioOde;
    }

    public void setEspacioOde(java.lang.String espacioOde)
    {
        this.espacioOde = espacioOde;
    }


}
