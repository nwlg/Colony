// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.indexador.negocio.servicios.busqueda;

/**
 * <p>
 * VO que alberga los parametros que acepta una busqueda avanzada.
 * </p>
 */
public class ParamAvanzadoVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public ParamAvanzadoVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param valoracion  
     * @param titulo  
     * @param secuencia  
     * @param recurso  
     * @param procesoCognitivo  
     * @param palabrasClave  
     * @param numeroResultados  
     * @param areaCurricular  
     * @param idiomaNavegacion  
     * @param idiomaBusqueda  
     * @param formato  
     * @param fechaPublicacion  
     * @param edad  
     * @param descripcion  
     * @param contexto  
     * @param autor  
     * @param idTesauro  Id del termino de tesauro por el que vamos a buscar
     * @param identificadorODE  Identifica un ode univocamente
     * @param fechaPublicacionRango  
     * @param nivelAgregacion  
     * @param arbolCurricularVigente  
     * @param destinatarios  
     * @param keyword  
     * @param ambito  
     * @param busquedaSimpleAvanzada
	 * @param searchFilters search filters as key-value pairs
     */
    public ParamAvanzadoVO(
        java.lang.String valoracion,
        java.lang.String titulo,
        java.lang.Boolean secuencia,
        java.lang.String recurso,
        java.lang.String procesoCognitivo,
        java.lang.String palabrasClave,
        java.lang.Integer numeroResultados,
        java.lang.String areaCurricular,
        java.lang.String idiomaNavegacion,
        java.lang.String idiomaBusqueda,
        java.lang.String formato,
        java.lang.String fechaPublicacion,
        java.lang.String edad,
        java.lang.String descripcion,
        java.lang.String contexto,
        java.lang.String autor,
        java.lang.String idTesauro,
        java.lang.String identificadorODE,
        java.lang.String fechaPublicacionRango,
        java.lang.String nivelAgregacion,
        java.lang.String arbolCurricularVigente,
        java.lang.String destinatarios,
        java.lang.String keyword,
        java.lang.String ambito,
        java.lang.String sortingMethod,
        java.lang.String busquedaSimpleAvanzada,
		java.util.HashMap searchFilters)
    {
        this.valoracion = valoracion;
        this.titulo = titulo;
        this.secuencia = secuencia;
        this.recurso = recurso;
        this.procesoCognitivo = procesoCognitivo;
        this.palabrasClave = palabrasClave;
        this.numeroResultados = numeroResultados;
        this.areaCurricular = areaCurricular;
        this.idiomaNavegacion = idiomaNavegacion;
        this.idiomaBusqueda = idiomaBusqueda;
        this.formato = formato;
        this.fechaPublicacion = fechaPublicacion;
        this.edad = edad;
        this.descripcion = descripcion;
        this.contexto = contexto;
        this.autor = autor;
        this.idTesauro = idTesauro;
        this.identificadorODE = identificadorODE;
        this.fechaPublicacionRango = fechaPublicacionRango;
        this.nivelAgregacion = nivelAgregacion;
        this.arbolCurricularVigente = arbolCurricularVigente;
        this.destinatarios = destinatarios;
        this.keyword = keyword;
        this.ambito = ambito;
        this.busquedaSimpleAvanzada = busquedaSimpleAvanzada;
        this.sortingMethod = sortingMethod;
		this.searchFilters = searchFilters;
    }

    /**
     * Copies constructor from other ParamAvanzadoVO
     * @param otherBean ParamAvanzadoVO 
     */
    public ParamAvanzadoVO(ParamAvanzadoVO otherBean)
    {
        if (otherBean != null)
        {
            this.valoracion = otherBean.getValoracion();
            this.titulo = otherBean.getTitulo();
            this.secuencia = otherBean.getSecuencia();
            this.recurso = otherBean.getRecurso();
            this.procesoCognitivo = otherBean.getProcesoCognitivo();
            this.palabrasClave = otherBean.getPalabrasClave();
            this.numeroResultados = otherBean.getNumeroResultados();
            this.areaCurricular = otherBean.getAreaCurricular();
            this.idiomaNavegacion = otherBean.getIdiomaNavegacion();
            this.idiomaBusqueda = otherBean.getIdiomaBusqueda();
            this.formato = otherBean.getFormato();
            this.fechaPublicacion = otherBean.getFechaPublicacion();
            this.edad = otherBean.getEdad();
            this.descripcion = otherBean.getDescripcion();
            this.contexto = otherBean.getContexto();
            this.autor = otherBean.getAutor();
            this.idTesauro = otherBean.getIdTesauro();
            this.identificadorODE = otherBean.getIdentificadorODE();
            this.fechaPublicacionRango = otherBean.getFechaPublicacionRango();
            this.nivelAgregacion = otherBean.getNivelAgregacion();
            this.arbolCurricularVigente = otherBean.getArbolCurricularVigente();
            this.destinatarios = otherBean.getDestinatarios();
            this.keyword = otherBean.getKeyword();
            this.ambito = otherBean.getAmbito();
            this.busquedaSimpleAvanzada = otherBean.getBusquedaSimpleAvanzada();
            this.sortingMethod = otherBean.getSortingMethod();
			this.searchFilters = otherBean.getSearchFilters();
        }
    }

    private java.lang.String valoracion;

    public java.lang.String getValoracion()
    {
        return this.valoracion;
    }

    public void setValoracion(java.lang.String valoracion)
    {
        this.valoracion = valoracion;
    }

    private java.lang.String titulo;

    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.Boolean secuencia;

    public java.lang.Boolean getSecuencia()
    {
        return this.secuencia;
    }

    public void setSecuencia(java.lang.Boolean secuencia)
    {
        this.secuencia = secuencia;
    }

    private java.lang.String recurso;

    public java.lang.String getRecurso()
    {
        return this.recurso;
    }

    public void setRecurso(java.lang.String recurso)
    {
        this.recurso = recurso;
    }

    private java.lang.String procesoCognitivo;

    public java.lang.String getProcesoCognitivo()
    {
        return this.procesoCognitivo;
    }

    public void setProcesoCognitivo(java.lang.String procesoCognitivo)
    {
        this.procesoCognitivo = procesoCognitivo;
    }

    private java.lang.String palabrasClave;

    public java.lang.String getPalabrasClave()
    {
        return this.palabrasClave;
    }

    public void setPalabrasClave(java.lang.String palabrasClave)
    {
        this.palabrasClave = palabrasClave;
    }

    private java.lang.Integer numeroResultados;

    public java.lang.Integer getNumeroResultados()
    {
        return this.numeroResultados;
    }

    public void setNumeroResultados(java.lang.Integer numeroResultados)
    {
        this.numeroResultados = numeroResultados;
    }

    private java.lang.String areaCurricular;

    public java.lang.String getAreaCurricular()
    {
        return this.areaCurricular;
    }

    public void setAreaCurricular(java.lang.String areaCurricular)
    {
        this.areaCurricular = areaCurricular;
    }

    private java.lang.String idiomaNavegacion;

    public java.lang.String getIdiomaNavegacion()
    {
        return this.idiomaNavegacion;
    }

    public void setIdiomaNavegacion(java.lang.String idiomaNavegacion)
    {
        this.idiomaNavegacion = idiomaNavegacion;
    }

    private java.lang.String idiomaBusqueda;

    public java.lang.String getIdiomaBusqueda()
    {
        return this.idiomaBusqueda;
    }

    public void setIdiomaBusqueda(java.lang.String idiomaBusqueda)
    {
        this.idiomaBusqueda = idiomaBusqueda;
    }

    private java.lang.String formato;

    public java.lang.String getFormato()
    {
        return this.formato;
    }

    public void setFormato(java.lang.String formato)
    {
        this.formato = formato;
    }

    private java.lang.String fechaPublicacion;

    public java.lang.String getFechaPublicacion()
    {
        return this.fechaPublicacion;
    }

    public void setFechaPublicacion(java.lang.String fechaPublicacion)
    {
        this.fechaPublicacion = fechaPublicacion;
    }

    private java.lang.String edad;

    public java.lang.String getEdad()
    {
        return this.edad;
    }

    public void setEdad(java.lang.String edad)
    {
        this.edad = edad;
    }

    private java.lang.String descripcion;

    public java.lang.String getDescripcion()
    {
        return this.descripcion;
    }

    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }

    private java.lang.String contexto;

    public java.lang.String getContexto()
    {
        return this.contexto;
    }

    public void setContexto(java.lang.String contexto)
    {
        this.contexto = contexto;
    }

    private java.lang.String autor;

    public java.lang.String getAutor()
    {
        return this.autor;
    }

    public void setAutor(java.lang.String autor)
    {
        this.autor = autor;
    }

    private java.lang.String idTesauro;

    /**
     * <p>
     * Id del termino de tesauro por el que vamos a buscar
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdTesauro()
    {
        return this.idTesauro;
    }

    /**
   * <p>
   * Id del termino de tesauro por el que vamos a buscar
   * </p>
     *  @param idTesauro  Id del termino de tesauro por el que vamos a buscar  
     */
    public void setIdTesauro(java.lang.String idTesauro)
    {
        this.idTesauro = idTesauro;
    }

    private java.lang.String identificadorODE;

    /**
     * <p>
     * Identifica un ode univocamente
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdentificadorODE()
    {
        return this.identificadorODE;
    }

    /**
   * <p>
   * Identifica un ode univocamente
   * </p>
     *  @param identificadorODE  Identifica un ode univocamente  
     */
    public void setIdentificadorODE(java.lang.String identificadorODE)
    {
        this.identificadorODE = identificadorODE;
    }

    private java.lang.String fechaPublicacionRango;

    public java.lang.String getFechaPublicacionRango()
    {
        return this.fechaPublicacionRango;
    }

    public void setFechaPublicacionRango(java.lang.String fechaPublicacionRango)
    {
        this.fechaPublicacionRango = fechaPublicacionRango;
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

    private java.lang.String arbolCurricularVigente;

    public java.lang.String getArbolCurricularVigente()
    {
        return this.arbolCurricularVigente;
    }

    public void setArbolCurricularVigente(java.lang.String arbolCurricularVigente)
    {
        this.arbolCurricularVigente = arbolCurricularVigente;
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

    private java.lang.String ambito;

    public java.lang.String getAmbito()
    {
        return this.ambito;
    }

    public void setAmbito(java.lang.String ambito)
    {
        this.ambito = ambito;
    }

    private java.lang.String busquedaSimpleAvanzada;

    public java.lang.String getBusquedaSimpleAvanzada()
    {
        return this.busquedaSimpleAvanzada;
    }

    public void setBusquedaSimpleAvanzada(java.lang.String busquedaSimpleAvanzada)
    {
        this.busquedaSimpleAvanzada = busquedaSimpleAvanzada;
    }



    private java.lang.String sortingMethod;

    public String getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(String sortingMethod) {
        this.sortingMethod = sortingMethod;
    }



    /* Search filters as key-value pairs. */
    private java.util.HashMap searchFilters;

    /**
     * Gets the searchFilters value for this ParametrosBusquedaAvanzadaVO.
     *
     * @return searchFilters Search filters as key-value pairs.
     */
    public java.util.HashMap getSearchFilters() {
        return searchFilters;
    }


    /**
     * Sets the searchFilters value for this ParametrosBusquedaAvanzadaVO.
     *
     * @param searchFilters Search filters as key-value pairs.
     */
    public void setSearchFilters(java.util.HashMap searchFilters) {
        this.searchFilters = searchFilters;
    }

}