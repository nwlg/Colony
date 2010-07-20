// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.indexador.negocio.servicios.indexado;

/**
 * <p>
 * Esta clase modela los datos relevantes de ser indexados en el
 * cuerpo de un LOM-ES primario de un ODE.
 * </p>
 */
public class LomESPrimarioVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public LomESPrimarioVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param titulo  
     * @param recurso  
     * @param procesosCognitivos  Procesos cognitivos del ODE.
     * @param palabrasClave  
     * @param nivelesEducativos  Niveles educativos presentes en el ODE.
     * @param licencia  La licencia a la que esta sujeta el ODE.
     * @param idioma  
     * @param formatos  Formatos presentes en el ODE.
     * @param fechaPublicacion  
     * @param edades  Edades de los usuarios a los que va dirigidos la accion lectiva del ODE.
     * @param destinatarios  
     * @param descripcion  
     * @param curso  
     * @param contextos  Los contextos presentes en el ODE.
     * @param autor  
     * @param arbolCurricular  
     * @param ambito  
     * @param nivelAgregacion  Nivel de Agregacion del ODE.
     * @param tesauros  
     * @param arbolCurricularVigente  
     * @param fuente  Fuentes sobre las que se relaciona el ODE.
     * @param relacion  Relacion del ODE con otros contenidos.
     * @param publicador  Publicador del ODE.
     * @param contribuidor  Contribuidor al contenido del ODE.
     * @param alcance  Alcance del contenido del ODE.
     * @param arbolCurricularLiteral  Se trata de los nombres de los nodos de las areas curriculares a las que pertenece el ODE o en las que puede estar clasificado.
     * @param descripciones  Variable para recuperar las descripciones del ODE
     * @param size string representation of the "size" attribute (in bytes) for a resource 
     * @param contentProvider content provider name(s)
     * @param typicalLearningTime NDRB representation of the typical learning time for a resource
     * @param relationKind relation kind(s)
     * @param relatedResourceTitle related resource title(s)
     * @param relatedResourceIdentifier related resource identifier(s)
     * @param relatedResourceLink related resource link(s)
     * @param taxonPath taxon path(s)
     * @param annotation notes
     * @param conditionsOfUse conditions of use (description(s) of restrictions)
     */
    public LomESPrimarioVO(
        java.lang.String titulo,
        java.lang.String[] recurso,
        java.lang.String[] procesosCognitivos,
        java.lang.String[] palabrasClave,
        java.lang.String[] nivelesEducativos,
        java.lang.String licencia,
        java.lang.String idioma,
        java.lang.String[] formatos,
        java.util.Calendar fechaPublicacion,
        java.lang.String[] edades,
        java.lang.String[] destinatarios,
        java.lang.String descripcion,
        java.lang.String curso,
        java.lang.String[] contextos,
        java.lang.String[] autor,
        java.lang.String[] arbolCurricular,
        java.lang.String[] ambito,
        java.lang.Integer nivelAgregacion,
        java.lang.String[] tesauros,
        java.lang.String arbolCurricularVigente,
        java.lang.String[] fuente,
        java.lang.String[] relacion,
        java.lang.String[] publicador,
        java.lang.String[] contribuidor,
        java.lang.String[] alcance,
        java.lang.String[] arbolCurricularLiteral,
        java.lang.String[] descripciones,
        java.lang.String size,
        java.lang.String[] contentProvider,
        java.lang.String[] typicalLearningTime,
        java.lang.String[] relationKind,
        java.lang.String[] relatedResourceTitle,
        java.lang.String[] relatedResourceIdentifier,
        java.lang.String[] relatedResourceLink,
        java.lang.String[] taxonPath,
        java.lang.String annotation,
        java.lang.String[] conditionsOfUse,
		java.lang.String[] authorOrganisation)

    {
        this.titulo = titulo;
        this.recurso = recurso;
        this.procesosCognitivos = procesosCognitivos;
        this.palabrasClave = palabrasClave;
        this.nivelesEducativos = nivelesEducativos;
        this.licencia = licencia;
        this.idioma = idioma;
        this.formatos = formatos;
        this.fechaPublicacion = fechaPublicacion;
        this.edades = edades;
        this.destinatarios = destinatarios;
        this.descripcion = descripcion;
        this.curso = curso;
        this.contextos = contextos;
        this.autor = autor;
        this.arbolCurricular = arbolCurricular;
        this.ambito = ambito;
        this.nivelAgregacion = nivelAgregacion;
        this.tesauros = tesauros;
        this.arbolCurricularVigente = arbolCurricularVigente;
        this.fuente = fuente;
        this.relacion = relacion;
        this.publicador = publicador;
        this.contribuidor = contribuidor;
        this.alcance = alcance;
        this.arbolCurricularLiteral = arbolCurricularLiteral;
        this.descripciones = descripciones;
        this.size = size;
        this.contentProvider = contentProvider;
        this.typicalLearningTime = typicalLearningTime;
        this.relationKind = relationKind;
        this.relatedResourceTitle = relatedResourceTitle;
        this.relatedResourceIdentifier = relatedResourceIdentifier;
        this.relatedResourceLink = relatedResourceLink;
        this.taxonPath = taxonPath;
        this.annotation = annotation;
        this.conditionsOfUse = conditionsOfUse;
		this.authorOrg = authorOrganisation;
    }

    /**
     * Copies constructor from other LomESPrimarioVO
     * @param otherBean LomESPrimarioVO 
     */
    public LomESPrimarioVO(LomESPrimarioVO otherBean)
    {
        if (otherBean != null)
        {
            this.titulo = otherBean.getTitulo();
            this.recurso = otherBean.getRecurso();
            this.procesosCognitivos = otherBean.getProcesosCognitivos();
            this.palabrasClave = otherBean.getPalabrasClave();
            this.nivelesEducativos = otherBean.getNivelesEducativos();
            this.licencia = otherBean.getLicencia();
            this.idioma = otherBean.getIdioma();
            this.formatos = otherBean.getFormatos();
            this.fechaPublicacion = otherBean.getFechaPublicacion();
            this.edades = otherBean.getEdades();
            this.destinatarios = otherBean.getDestinatarios();
            this.descripcion = otherBean.getDescripcion();
            this.curso = otherBean.getCurso();
            this.contextos = otherBean.getContextos();
            this.autor = otherBean.getAutor();
            this.arbolCurricular = otherBean.getArbolCurricular();
            this.ambito = otherBean.getAmbito();
            this.nivelAgregacion = otherBean.getNivelAgregacion();
            this.tesauros = otherBean.getTesauros();
            this.arbolCurricularVigente = otherBean.getArbolCurricularVigente();
            this.fuente = otherBean.getFuente();
            this.relacion = otherBean.getRelacion();
            this.publicador = otherBean.getPublicador();
            this.contribuidor = otherBean.getContribuidor();
            this.alcance = otherBean.getAlcance();
            this.arbolCurricularLiteral = otherBean.getArbolCurricularLiteral();
            this.descripciones = otherBean.getDescripciones();
            this.size = otherBean.getSize();
            this.contentProvider = otherBean.getContentProvider();
            this.typicalLearningTime = otherBean.getTypicalLearningTime();
            this.relationKind = otherBean.getRelationKind();
            this.relatedResourceTitle = otherBean.getRelatedResourceTitle();
            this.relatedResourceIdentifier = otherBean.getRelatedResourceIdentifier();
            this.relatedResourceLink = otherBean.getRelatedResourceLink();
            this.taxonPath = otherBean.getTaxonPath();
            this.annotation = otherBean.getAnnotation();
            this.conditionsOfUse = otherBean.getConditionsOfUse();
			this.authorOrg = otherBean.getAuthorOrganisation();
        }
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

    private java.lang.String[] recurso;

    public java.lang.String[] getRecurso()
    {
        return this.recurso;
    }

    public void setRecurso(java.lang.String[] recurso)
    {
        this.recurso = recurso;
    }

    private java.lang.String[] procesosCognitivos;

    /**
     * <p>
     * Procesos cognitivos del ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getProcesosCognitivos()
    {
        return this.procesosCognitivos;
    }

    /**
   * <p>
   * Procesos cognitivos del ODE.
   * </p>
     *  @param procesosCognitivos  Procesos cognitivos del ODE.  
     */
    public void setProcesosCognitivos(java.lang.String[] procesosCognitivos)
    {
        this.procesosCognitivos = procesosCognitivos;
    }

    private java.lang.String[] palabrasClave;

    public java.lang.String[] getPalabrasClave()
    {
        return this.palabrasClave;
    }

    public void setPalabrasClave(java.lang.String[] palabrasClave)
    {
        this.palabrasClave = palabrasClave;
    }

    private java.lang.String[] nivelesEducativos;

    /**
     * <p>
     * Niveles educativos presentes en el ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getNivelesEducativos()
    {
        return this.nivelesEducativos;
    }

    /**
   * <p>
   * Niveles educativos presentes en el ODE.
   * </p>
     *  @param nivelesEducativos  Niveles educativos presentes en el ODE.  
     */
    public void setNivelesEducativos(java.lang.String[] nivelesEducativos)
    {
        this.nivelesEducativos = nivelesEducativos;
    }

    private java.lang.String licencia;

    /**
     * <p>
     * La licencia a la que esta sujeta el ODE.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getLicencia()
    {
        return this.licencia;
    }

    /**
   * <p>
   * La licencia a la que esta sujeta el ODE.
   * </p>
     *  @param licencia  La licencia a la que esta sujeta el ODE.  
     */
    public void setLicencia(java.lang.String licencia)
    {
        this.licencia = licencia;
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

    private java.lang.String[] formatos;

    /**
     * <p>
     * Formatos presentes en el ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getFormatos()
    {
        return this.formatos;
    }

    /**
   * <p>
   * Formatos presentes en el ODE.
   * </p>
     *  @param formatos  Formatos presentes en el ODE.  
     */
    public void setFormatos(java.lang.String[] formatos)
    {
        this.formatos = formatos;
    }

    private java.util.Calendar fechaPublicacion;

    public java.util.Calendar getFechaPublicacion()
    {
        return this.fechaPublicacion;
    }

    public void setFechaPublicacion(java.util.Calendar fechaPublicacion)
    {
        this.fechaPublicacion = fechaPublicacion;
    }

    private java.lang.String[] edades;

    /**
     * <p>
     * Edades de los usuarios a los que va dirigidos la accion lectiva
     * del ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getEdades()
    {
        return this.edades;
    }

    /**
   * <p>
   * Edades de los usuarios a los que va dirigidos la accion lectiva
   * del ODE.
   * </p>
     *  @param edades  Edades de los usuarios a los que va dirigidos la accion lectiva del ODE.  
     */
    public void setEdades(java.lang.String[] edades)
    {
        this.edades = edades;
    }

    private java.lang.String[] destinatarios;

    public java.lang.String[] getDestinatarios()
    {
        return this.destinatarios;
    }

    public void setDestinatarios(java.lang.String[] destinatarios)
    {
        this.destinatarios = destinatarios;
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

    private java.lang.String curso;

    public java.lang.String getCurso()
    {
        return this.curso;
    }

    public void setCurso(java.lang.String curso)
    {
        this.curso = curso;
    }

    private java.lang.String[] contextos;

    /**
     * <p>
     * Los contextos presentes en el ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getContextos()
    {
        return this.contextos;
    }

    /**
   * <p>
   * Los contextos presentes en el ODE.
   * </p>
     *  @param contextos  Los contextos presentes en el ODE.  
     */
    public void setContextos(java.lang.String[] contextos)
    {
        this.contextos = contextos;
    }

    private java.lang.String[] autor;

    public java.lang.String[] getAutor()
    {
        return this.autor;
    }

    public void setAutor(java.lang.String[] autor)
    {
        this.autor = autor;
    }

    private java.lang.String[] arbolCurricular;

    public java.lang.String[] getArbolCurricular()
    {
        return this.arbolCurricular;
    }

    public void setArbolCurricular(java.lang.String[] arbolCurricular)
    {
        this.arbolCurricular = arbolCurricular;
    }

    private java.lang.String[] ambito;

    public java.lang.String[] getAmbito()
    {
        return this.ambito;
    }

    public void setAmbito(java.lang.String[] ambito)
    {
        this.ambito = ambito;
    }

    private java.lang.Integer nivelAgregacion;

    /**
     * <p>
     * Nivel de Agregacion del ODE.
     * </p>
     * @return java.lang.Integer
     */
    public java.lang.Integer getNivelAgregacion()
    {
        return this.nivelAgregacion;
    }

    /**
   * <p>
   * Nivel de Agregacion del ODE.
   * </p>
     *  @param nivelAgregacion  Nivel de Agregacion del ODE.  
     */
    public void setNivelAgregacion(java.lang.Integer nivelAgregacion)
    {
        this.nivelAgregacion = nivelAgregacion;
    }

    private java.lang.String[] tesauros;

    public java.lang.String[] getTesauros()
    {
        return this.tesauros;
    }

    public void setTesauros(java.lang.String[] tesauros)
    {
        this.tesauros = tesauros;
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

    private java.lang.String[] fuente;

    /**
     * <p>
     * Fuentes sobre las que se relaciona el ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getFuente()
    {
        return this.fuente;
    }

    /**
   * <p>
   * Fuentes sobre las que se relaciona el ODE.
   * </p>
     *  @param fuente  Fuentes sobre las que se relaciona el ODE.  
     */
    public void setFuente(java.lang.String[] fuente)
    {
        this.fuente = fuente;
    }

    private java.lang.String[] relacion;

    /**
     * <p>
     * Relacion del ODE con otros contenidos.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getRelacion()
    {
        return this.relacion;
    }

    /**
   * <p>
   * Relacion del ODE con otros contenidos.
   * </p>
     *  @param relacion  Relacion del ODE con otros contenidos.  
     */
    public void setRelacion(java.lang.String[] relacion)
    {
        this.relacion = relacion;
    }

    private java.lang.String[] publicador;

    /**
     * <p>
     * Publicador del ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getPublicador()
    {
        return this.publicador;
    }

    /**
   * <p>
   * Publicador del ODE.
   * </p>
     *  @param publicador  Publicador del ODE.  
     */
    public void setPublicador(java.lang.String[] publicador)
    {
        this.publicador = publicador;
    }

    private java.lang.String[] contribuidor;

    /**
     * <p>
     * Contribuidor al contenido del ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getContribuidor()
    {
        return this.contribuidor;
    }

    /**
   * <p>
   * Contribuidor al contenido del ODE.
   * </p>
     *  @param contribuidor  Contribuidor al contenido del ODE.  
     */
    public void setContribuidor(java.lang.String[] contribuidor)
    {
        this.contribuidor = contribuidor;
    }

    private java.lang.String[] alcance;

    /**
     * <p>
     * Alcance del contenido del ODE.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getAlcance()
    {
        return this.alcance;
    }

    /**
   * <p>
   * Alcance del contenido del ODE.
   * </p>
     *  @param alcance  Alcance del contenido del ODE.  
     */
    public void setAlcance(java.lang.String[] alcance)
    {
        this.alcance = alcance;
    }

    private java.lang.String[] arbolCurricularLiteral;

    /**
     * <p>
     * Se trata de los nombres de los nodos de las areas curriculares a
     * las que pertenece el ODE o en las que puede estar clasificado.
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getArbolCurricularLiteral()
    {
        return this.arbolCurricularLiteral;
    }

    /**
   * <p>
   * Se trata de los nombres de los nodos de las areas curriculares a
   * las que pertenece el ODE o en las que puede estar clasificado.
   * </p>
     *  @param arbolCurricularLiteral  Se trata de los nombres de los nodos de las areas curriculares a las que pertenece el ODE o en las que puede estar clasificado.  
     */
    public void setArbolCurricularLiteral(java.lang.String[] arbolCurricularLiteral)
    {
        this.arbolCurricularLiteral = arbolCurricularLiteral;
    }

    private java.lang.String[] descripciones;

    /**
     * <p>
     * Variable para recuperar las descripciones del ODE
     * </p>
     * @return java.lang.String[]
     */
    public java.lang.String[] getDescripciones()
    {
        return this.descripciones;
    }

    /**
   * <p>
   * Variable para recuperar las descripciones del ODE
   * </p>
     *  @param descripciones  Variable para recuperar las descripciones del ODE  
     */
    public void setDescripciones(java.lang.String[] descripciones)
    {
        this.descripciones = descripciones;
    }

    private java.lang.String size;

    public java.lang.String getSize()
    {
        return this.size;
    }

    public void setSize(java.lang.String size)
    {
        this.size = size;
    }

    private java.lang.String annotation;

    public java.lang.String getAnnotation()
    {
        return this.annotation;
    }

    public void setAnnotation(java.lang.String annotation)
    {
        this.annotation = annotation;
    }

    private java.lang.String[] conditionsOfUse;

    public java.lang.String[] getConditionsOfUse()
    {
        return this.conditionsOfUse;
    }

    public void setConditionsOfUse(java.lang.String[] conditionsOfUse)
    {
        this.conditionsOfUse = conditionsOfUse;
    }

    private java.lang.String[] contentProvider;

    public java.lang.String[] getContentProvider()
    {
        return this.contentProvider;
    }

    public void setContentProvider(java.lang.String[] contentProvider)
    {
        this.contentProvider = contentProvider;
    }

    private java.lang.String[] typicalLearningTime;

    public java.lang.String[] getTypicalLearningTime()
    {
        return this.typicalLearningTime;
    }

    public void setTypicalLearningTime(java.lang.String[] typicalLearningTime)
    {
        this.typicalLearningTime = typicalLearningTime;
    }

    private java.lang.String[] relationKind;

    public java.lang.String[] getRelationKind()
    {
        return this.relationKind;
    }

    public void setRelationKind(java.lang.String[] relationKind)
    {
        this.relationKind = relationKind;
    }

    private java.lang.String[] relatedResourceTitle;

    public java.lang.String[] getRelatedResourceTitle()
    {
        return this.relatedResourceTitle;
    }

    public void setRelatedResourceTitle(java.lang.String[] relatedResourceTitle)
    {
        this.relatedResourceTitle = relatedResourceTitle;
    }

    private java.lang.String[] relatedResourceIdentifier;

    public java.lang.String[] getRelatedResourceIdentifier()
    {
        return this.relatedResourceIdentifier;
    }

    public void setRelatedResourceIdentifier(java.lang.String[] relatedResourceIdentifier)
    {
        this.relatedResourceIdentifier = relatedResourceIdentifier;
    }

    private java.lang.String[] relatedResourceLink;

    public java.lang.String[] getRelatedResourceLink()
    {
        return this.relatedResourceLink;
    }

    public void setRelatedResourceLink(java.lang.String[] relatedResourceLink)
    {
        this.relatedResourceLink = relatedResourceLink;
    }

    private java.lang.String[] taxonPath;

    public java.lang.String[] getTaxonPath()
    {
        return this.taxonPath;
    }

    public void setTaxonPath(java.lang.String[] taxonPath)
    {
        this.taxonPath = taxonPath;
    }

    private java.lang.String[] authorOrg;

    public java.lang.String[] getAuthorOrganisation()
    {
        return this.authorOrg;
    }

    public void setAuthorOrganisation(java.lang.String[] authorOrg)
    {
        this.authorOrg = authorOrg;
    }
}