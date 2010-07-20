// license-header java merge-point
package es.pode.buscador.presentacion;

import java.io.Serializable;

/**
 * 
 */
public class BuscarSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "buscarSession";

    private java.lang.String titulo;

  /**
   * <p>
   * Titulo del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

  /**
   * <p>
   * Titulo del ODE.
   * </p>
   *  @param titulo  Titulo del ODE.  
   */
    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.String descripcion;

  /**
   * <p>
   * La descripcion del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getDescripcion()
    {
        return this.descripcion;
    }

  /**
   * <p>
   * La descripcion del ODE.
   * </p>
   *  @param descripcion  La descripcion del ODE.  
   */
    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }

    private java.lang.String recurso;

  /**
   * <p>
   * Recurso del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getRecurso()
    {
        return this.recurso;
    }

  /**
   * <p>
   * Recurso del ODE.
   * </p>
   *  @param recurso  Recurso del ODE.  
   */
    public void setRecurso(java.lang.String recurso)
    {
        this.recurso = recurso;
    }

    private java.lang.String formato;

  /**
   * <p>
   * Formato del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getFormato()
    {
        return this.formato;
    }

  /**
   * <p>
   * Formato del ODE.
   * </p>
   *  @param formato  Formato del ODE.  
   */
    public void setFormato(java.lang.String formato)
    {
        this.formato = formato;
    }

    private java.lang.String procesoCognitivo;

  /**
   * <p>
   * Proceso cognitivo del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getProcesoCognitivo()
    {
        return this.procesoCognitivo;
    }

  /**
   * <p>
   * Proceso cognitivo del ODE.
   * </p>
   *  @param procesoCognitivo  Proceso cognitivo del ODE.  
   */
    public void setProcesoCognitivo(java.lang.String procesoCognitivo)
    {
        this.procesoCognitivo = procesoCognitivo;
    }

    private java.lang.String contexto;

  /**
   * <p>
   * Contexto del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getContexto()
    {
        return this.contexto;
    }

  /**
   * <p>
   * Contexto del ODE.
   * </p>
   *  @param contexto  Contexto del ODE.  
   */
    public void setContexto(java.lang.String contexto)
    {
        this.contexto = contexto;
    }

    private java.lang.String edad;

  /**
   * <p>
   * Edad del publico al que va dirigido el ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getEdad()
    {
        return this.edad;
    }

  /**
   * <p>
   * Edad del publico al que va dirigido el ODE.
   * </p>
   *  @param edad  Edad del publico al que va dirigido el ODE.  
   */
    public void setEdad(java.lang.String edad)
    {
        this.edad = edad;
    }

    private java.lang.String autor;

  /**
   * <p>
   * Autor del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getAutor()
    {
        return this.autor;
    }

  /**
   * <p>
   * Autor del ODE.
   * </p>
   *  @param autor  Autor del ODE.  
   */
    public void setAutor(java.lang.String autor)
    {
        this.autor = autor;
    }

    private java.lang.String anyoPublicacion;

  /**
   * <p>
   * Anio de publicacion del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getAnyoPublicacion()
    {
        return this.anyoPublicacion;
    }

  /**
   * <p>
   * Anio de publicacion del ODE.
   * </p>
   *  @param anyoPublicacion  Anio de publicacion del ODE.  
   */
    public void setAnyoPublicacion(java.lang.String anyoPublicacion)
    {
        this.anyoPublicacion = anyoPublicacion;
    }

    private java.lang.String secuencia;

  /**
   * <p>
   * Con secuencia o sin secuencia.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getSecuencia()
    {
        return this.secuencia;
    }

  /**
   * <p>
   * Con secuencia o sin secuencia.
   * </p>
   *  @param secuencia  Con secuencia o sin secuencia.  
   */
    public void setSecuencia(java.lang.String secuencia)
    {
        this.secuencia = secuencia;
    }

    private java.lang.String valoracion;

  /**
   * <p>
   * Valoracion del ODE dentro de la plataforma.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getValoracion()
    {
        return this.valoracion;
    }

  /**
   * <p>
   * Valoracion del ODE dentro de la plataforma.
   * </p>
   *  @param valoracion  Valoracion del ODE dentro de la plataforma.  
   */
    public void setValoracion(java.lang.String valoracion)
    {
        this.valoracion = valoracion;
    }

    private java.lang.String areaCurricular;

  /**
   * <p>
   * El area curricular del ODE. Es un array de Strings ordenados con
   * desde el nodo raiz hasta el hoja.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getAreaCurricular()
    {
        return this.areaCurricular;
    }

  /**
   * <p>
   * El area curricular del ODE. Es un array de Strings ordenados con
   * desde el nodo raiz hasta el hoja.
   * </p>
   *  @param areaCurricular  El area curricular del ODE. Es un array de Strings ordenados con desde el nodo raiz hasta el hoja.  
   */
    public void setAreaCurricular(java.lang.String areaCurricular)
    {
        this.areaCurricular = areaCurricular;
    }

    private java.lang.String enlaceComunidadesSeleccionadas;

  /**
   * <p>
   * Comunidades en las que se busca el ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getEnlaceComunidadesSeleccionadas()
    {
        return this.enlaceComunidadesSeleccionadas;
    }

  /**
   * <p>
   * Comunidades en las que se busca el ODE.
   * </p>
   *  @param enlaceComunidadesSeleccionadas  Comunidades en las que se busca el ODE.  
   */
    public void setEnlaceComunidadesSeleccionadas(java.lang.String enlaceComunidadesSeleccionadas)
    {
        this.enlaceComunidadesSeleccionadas = enlaceComunidadesSeleccionadas;
    }

    private java.lang.Integer pagina;

  /**
   * <p>
   * Pagina de resultados desde la que se ha seleciconado el detalle
   * del ODE.
   * </p>
   * @return java.lang.Integer
   */
    public java.lang.Integer getPagina()
    {
        return this.pagina;
    }

  /**
   * <p>
   * Pagina de resultados desde la que se ha seleciconado el detalle
   * del ODE.
   * </p>
   *  @param pagina  Pagina de resultados desde la que se ha seleciconado el detalle del ODE.  
   */
    public void setPagina(java.lang.Integer pagina)
    {
        this.pagina = pagina;
    }

    private java.lang.String buscadorContenido;

  /**
   * <p>
   * Contenido de la caja de texto del buscador.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getBuscadorContenido()
    {
        return this.buscadorContenido;
    }

  /**
   * <p>
   * Contenido de la caja de texto del buscador.
   * </p>
   *  @param buscadorContenido  Contenido de la caja de texto del buscador.  
   */
    public void setBuscadorContenido(java.lang.String buscadorContenido)
    {
        this.buscadorContenido = buscadorContenido;
    }

    private java.lang.String busquedaSimpleAvanzada;

  /**
   * <p>
   * Se trata del ultimo tipo de busqueda que realizo el usuario de
   * la sesion. Sirve para poder saber en el caso de las vueltas
   * atras de las pantallas de detalles de resultados de busqueda a
   * que pantalla de resulados volver.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getBusquedaSimpleAvanzada()
    {
        return this.busquedaSimpleAvanzada;
    }

  /**
   * <p>
   * Se trata del ultimo tipo de busqueda que realizo el usuario de
   * la sesion. Sirve para poder saber en el caso de las vueltas
   * atras de las pantallas de detalles de resultados de busqueda a
   * que pantalla de resulados volver.
   * </p>
   *  @param busquedaSimpleAvanzada  Se trata del ultimo tipo de busqueda que realizo el usuario de la sesion. Sirve para poder saber en el caso de las vueltas atras de las pantallas de detalles de resultados de busqueda a que pantalla de resulados volver.  
   */
    public void setBusquedaSimpleAvanzada(java.lang.String busquedaSimpleAvanzada)
    {
        this.busquedaSimpleAvanzada = busquedaSimpleAvanzada;
    }

    private java.lang.String mesPublicacion;

  /**
   * <p>
   * Mes de publicacion del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getMesPublicacion()
    {
        return this.mesPublicacion;
    }

  /**
   * <p>
   * Mes de publicacion del ODE.
   * </p>
   *  @param mesPublicacion  Mes de publicacion del ODE.  
   */
    public void setMesPublicacion(java.lang.String mesPublicacion)
    {
        this.mesPublicacion = mesPublicacion;
    }

    private java.lang.String diaPublicacion;

  /**
   * <p>
   * Dia de publicacion del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getDiaPublicacion()
    {
        return this.diaPublicacion;
    }

  /**
   * <p>
   * Dia de publicacion del ODE.
   * </p>
   *  @param diaPublicacion  Dia de publicacion del ODE.  
   */
    public void setDiaPublicacion(java.lang.String diaPublicacion)
    {
        this.diaPublicacion = diaPublicacion;
    }

    private java.lang.String areaCurricularBusqueda;

    public java.lang.String getAreaCurricularBusqueda()
    {
        return this.areaCurricularBusqueda;
    }

    public void setAreaCurricularBusqueda(java.lang.String areaCurricularBusqueda)
    {
        this.areaCurricularBusqueda = areaCurricularBusqueda;
    }

    private java.lang.String tipoVisualizacion;

    public java.lang.String getTipoVisualizacion()
    {
        return this.tipoVisualizacion;
    }

    public void setTipoVisualizacion(java.lang.String tipoVisualizacion)
    {
        this.tipoVisualizacion = tipoVisualizacion;
    }

    private java.lang.String nodoOrigen;

    public java.lang.String getNodoOrigen()
    {
        return this.nodoOrigen;
    }

    public void setNodoOrigen(java.lang.String nodoOrigen)
    {
        this.nodoOrigen = nodoOrigen;
    }

    private java.lang.String tipoBusquedaArbol;

    public java.lang.String getTipoBusquedaArbol()
    {
        return this.tipoBusquedaArbol;
    }

    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol)
    {
        this.tipoBusquedaArbol = tipoBusquedaArbol;
    }

    private java.lang.String tipoBusqueda;

    public java.lang.String getTipoBusqueda()
    {
        return this.tipoBusqueda;
    }

    public void setTipoBusqueda(java.lang.String tipoBusqueda)
    {
        this.tipoBusqueda = tipoBusqueda;
    }

    private java.lang.String enlaceTodoAgrega;

    public java.lang.String getEnlaceTodoAgrega()
    {
        return this.enlaceTodoAgrega;
    }

    public void setEnlaceTodoAgrega(java.lang.String enlaceTodoAgrega)
    {
        this.enlaceTodoAgrega = enlaceTodoAgrega;
    }

    private java.lang.String identificadorODE;

    public java.lang.String getIdentificadorODE()
    {
        return this.identificadorODE;
    }

    public void setIdentificadorODE(java.lang.String identificadorODE)
    {
        this.identificadorODE = identificadorODE;
    }

    private java.lang.String empIdOde;

    public java.lang.String getEmpIdOde()
    {
        return this.empIdOde;
    }

    public void setEmpIdOde(java.lang.String empIdOde)
    {
        this.empIdOde = empIdOde;
    }

    private java.lang.String empIdDestino;

    public java.lang.String getEmpIdDestino()
    {
        return this.empIdDestino;
    }

    public void setEmpIdDestino(java.lang.String empIdDestino)
    {
        this.empIdDestino = empIdDestino;
    }

    private java.lang.String empTipoEmpaquetador;

    public java.lang.String getEmpTipoEmpaquetador()
    {
        return this.empTipoEmpaquetador;
    }

    public void setEmpTipoEmpaquetador(java.lang.String empTipoEmpaquetador)
    {
        this.empTipoEmpaquetador = empTipoEmpaquetador;
    }

    private java.lang.String tipoLayoutBuscador;

    public java.lang.String getTipoLayoutBuscador()
    {
        return this.tipoLayoutBuscador;
    }

    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador)
    {
        this.tipoLayoutBuscador = tipoLayoutBuscador;
    }

    private java.util.Collection jerarquias;

    public java.util.Collection getJerarquias()
    {
        return this.jerarquias;
    }

    public void setJerarquias(java.util.Collection jerarquias)
    {
        this.jerarquias = jerarquias;
    }

    private java.lang.String idTesauro;

    public java.lang.String getIdTesauro()
    {
        return this.idTesauro;
    }

    public void setIdTesauro(java.lang.String idTesauro)
    {
        this.idTesauro = idTesauro;
    }

    private java.lang.String nomTesauros;

    public java.lang.String getNomTesauros()
    {
        return this.nomTesauros;
    }

    public void setNomTesauros(java.lang.String nomTesauros)
    {
        this.nomTesauros = nomTesauros;
    }

    private java.lang.String idioma;

    public java.lang.String getIdioma()
    {
        return this.idioma;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    private java.lang.String nivelAgregacion;

    public java.lang.String getNivelAgregacion()
    {
        return this.nivelAgregacion;
    }

    public void setNivelAgregacion(java.lang.String nivelAgregacion)
    {
        this.nivelAgregacion = nivelAgregacion;
    }

    private java.lang.Boolean existeSesion;

    public java.lang.Boolean getExisteSesion()
    {
        return this.existeSesion;
    }

    public void setExisteSesion(java.lang.Boolean existeSesion)
    {
        this.existeSesion = existeSesion;
    }

    private java.lang.String tesauroBusqueda;

    public java.lang.String getTesauroBusqueda()
    {
        return this.tesauroBusqueda;
    }

    public void setTesauroBusqueda(java.lang.String tesauroBusqueda)
    {
        this.tesauroBusqueda = tesauroBusqueda;
    }

    private java.lang.String destinatarios;

    public java.lang.String getDestinatarios()
    {
        return this.destinatarios;
    }

    public void setDestinatarios(java.lang.String destinatarios)
    {
        this.destinatarios = destinatarios;
    }

    private java.lang.String keyword;

    public java.lang.String getKeyword()
    {
        return this.keyword;
    }

    public void setKeyword(java.lang.String keyword)
    {
        this.keyword = keyword;
    }

    private java.lang.String posicionamientoAnterior;

    public java.lang.String getPosicionamientoAnterior()
    {
        return this.posicionamientoAnterior;
    }

    public void setPosicionamientoAnterior(java.lang.String posicionamientoAnterior)
    {
        this.posicionamientoAnterior = posicionamientoAnterior;
    }

    private java.lang.String posicionamientoSiguiente;

    public java.lang.String getPosicionamientoSiguiente()
    {
        return this.posicionamientoSiguiente;
    }

    public void setPosicionamientoSiguiente(java.lang.String posicionamientoSiguiente)
    {
        this.posicionamientoSiguiente = posicionamientoSiguiente;
    }

    private java.lang.String tituloTesauro;

  /**
   * <p>
   * Nombre del tesauro en el idioma de navegación.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getTituloTesauro()
    {
        return this.tituloTesauro;
    }

  /**
   * <p>
   * Nombre del tesauro en el idioma de navegación.
   * </p>
   *  @param tituloTesauro  Nombre del tesauro en el idioma de navegación.  
   */
    public void setTituloTesauro(java.lang.String tituloTesauro)
    {
        this.tituloTesauro = tituloTesauro;
    }

    private java.lang.String numeroResultados;

  /**
   * <p>
   * numero de resultados a mostrar por pagina
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getNumeroResultados()
    {
        return this.numeroResultados;
    }

  /**
   * <p>
   * numero de resultados a mostrar por pagina
   * </p>
   *  @param numeroResultados  numero de resultados a mostrar por pagina  
   */
    public void setNumeroResultados(java.lang.String numeroResultados)
    {
        this.numeroResultados = numeroResultados;
    }


}
