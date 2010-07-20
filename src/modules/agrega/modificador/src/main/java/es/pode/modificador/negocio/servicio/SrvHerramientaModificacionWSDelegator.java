// license-header java merge-point
package es.pode.modificador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.modificador.negocio.servicio.SrvHerramientaModificacion}.
 *
 * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion
 */
public class SrvHerramientaModificacionWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.modificador.negocio.servicio.SrvHerramientaModificacion}
     */
    private final es.pode.modificador.negocio.servicio.SrvHerramientaModificacion getSrvHerramientaModificacion()
    {
        return es.pode.modificador.ServiceLocator.instance().getSrvHerramientaModificacion();
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerTipos()
     */
    public es.pode.modificador.negocio.servicio.vo.CambioTypes obtenerTipos()
    {
        return getSrvHerramientaModificacion().obtenerTipos();
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#validar(es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea)
     */
    public java.lang.Boolean validar(es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea configuracion)
    {
        return getSrvHerramientaModificacion().validar(configuracion);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerModificacionesConfiguradas()
     */
    public es.pode.modificador.negocio.servicio.ModificacionVO[] obtenerModificacionesConfiguradas()
    {
        return getSrvHerramientaModificacion().obtenerModificacionesConfiguradas();
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerModificacion(java.lang.Long)
     */
    public es.pode.modificador.negocio.servicio.ModificacionVO obtenerModificacion(java.lang.Long idModificacion)
    {
        return getSrvHerramientaModificacion().obtenerModificacion(idModificacion);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#recuperarResultadoODE(java.lang.Long, java.lang.Long)
     */
    public es.pode.modificador.negocio.servicio.ResultadoModificacionVO recuperarResultadoODE(java.lang.Long idModificacion, java.lang.Long id)
    {
        return getSrvHerramientaModificacion().recuperarResultadoODE(idModificacion, id);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#restaurar(java.lang.Long, java.lang.Long)
     */
    public java.lang.Boolean restaurar(java.lang.Long idModificacion, java.lang.Long id)
    {
        return getSrvHerramientaModificacion().restaurar(idModificacion, id);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#ejecutarModificacion(java.lang.Long)
     */
    public java.lang.Boolean ejecutarModificacion(java.lang.Long idModificacion)
    {
        return getSrvHerramientaModificacion().ejecutarModificacion(idModificacion);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#eliminarModificacion(java.lang.Long[])
     */
    public java.lang.Boolean eliminarModificacion(java.lang.Long[] identificadores)
    {
        return getSrvHerramientaModificacion().eliminarModificacion(identificadores);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerModificacionesEjecutadas()
     */
    public es.pode.modificador.negocio.servicio.ModificacionVO[] obtenerModificacionesEjecutadas()
    {
        return getSrvHerramientaModificacion().obtenerModificacionesEjecutadas();
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerResultadoModificacion(java.lang.Long)
     */
    public es.pode.modificador.negocio.servicio.ResultadoModificacionVO[] obtenerResultadoModificacion(java.lang.Long idModificacion)
    {
        return getSrvHerramientaModificacion().obtenerResultadoModificacion(idModificacion);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#importarModificacion(javax.activation.DataHandler)
     */
    public es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea importarModificacion(javax.activation.DataHandler fichero)
    {
        return getSrvHerramientaModificacion().importarModificacion(fichero);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#exportarModificacion(es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea)
     */
    public javax.activation.DataHandler exportarModificacion(es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea tarea)
    {
        return getSrvHerramientaModificacion().exportarModificacion(tarea);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#configurar(java.lang.Long, es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea, java.lang.String)
     */
    public java.lang.Long configurar(java.lang.Long idModificacion, es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea configuracion, java.lang.String nombre)
    {
        return getSrvHerramientaModificacion().configurar(idModificacion, configuracion, nombre);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#recuperarPlantillaLomes(java.lang.String)
     */
    public java.lang.String recuperarPlantillaLomes(java.lang.String terminoLomes)
    {
        return getSrvHerramientaModificacion().recuperarPlantillaLomes(terminoLomes);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#simularModificacion(es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea, java.lang.Integer)
     */
    public es.pode.modificador.negocio.servicio.ModificacionSimuladaVO simularModificacion(es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea configuracion, java.lang.Integer numeroOdes)
    {
        return getSrvHerramientaModificacion().simularModificacion(configuracion, numeroOdes);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerModificacionesEnEjecucion()
     */
    public es.pode.modificador.negocio.servicio.ModificacionVO[] obtenerModificacionesEnEjecucion()
    {
        return getSrvHerramientaModificacion().obtenerModificacionesEnEjecucion();
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#registrarResultadosTarea(java.lang.Long, es.pode.modificador.negocio.servicio.ResultadoModificacionVO[])
     */
    public java.lang.Boolean registrarResultadosTarea(java.lang.Long idModificacion, es.pode.modificador.negocio.servicio.ResultadoModificacionVO[] resultados)
    {
        return getSrvHerramientaModificacion().registrarResultadosTarea(idModificacion, resultados);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerFormularioModificar(java.lang.String)
     */
    public es.pode.modificador.negocio.servicio.vo.FormularioModificarVO obtenerFormularioModificar(java.lang.String idTermino)
    {
        return getSrvHerramientaModificacion().obtenerFormularioModificar(idTermino);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#navegarLom(java.lang.String)
     */
    public es.pode.modificador.negocio.servicio.TerminoLomVO navegarLom(java.lang.String idTermino)
    {
        return getSrvHerramientaModificacion().navegarLom(idTermino);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#navegarArbolCurricular(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.modificador.negocio.servicio.TaxonomiaVO navegarArbolCurricular(java.lang.String idNodo, java.lang.String nombreTaxonomia, java.lang.String idioma)
    {
        return getSrvHerramientaModificacion().navegarArbolCurricular(idNodo, nombreTaxonomia, idioma);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#navegarTesauro(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.modificador.negocio.servicio.TaxonomiaVO navegarTesauro(java.lang.String idNodo, java.lang.String nombreTaxonomia, java.lang.String idioma)
    {
        return getSrvHerramientaModificacion().navegarTesauro(idNodo, nombreTaxonomia, idioma);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#generarArbolCurricular(es.pode.modificador.negocio.servicio.TaxonomiaVO)
     */
    public java.lang.String generarArbolCurricular(es.pode.modificador.negocio.servicio.TaxonomiaVO taxonomia)
    {
        return getSrvHerramientaModificacion().generarArbolCurricular(taxonomia);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#planificarModificacion(java.lang.Long, java.util.Calendar)
     */
    public java.lang.Boolean planificarModificacion(java.lang.Long idModificacion, java.util.Calendar fechaEjecucion)
    {
        return getSrvHerramientaModificacion().planificarModificacion(idModificacion, fechaEjecucion);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#desprogramarTarea(java.lang.Long, java.lang.String)
     */
    public java.lang.Boolean desprogramarTarea(java.lang.Long idModificacion, java.lang.String idPlanificador)
    {
        return getSrvHerramientaModificacion().desprogramarTarea(idModificacion, idPlanificador);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#obtenerConfiguracionTarea(java.lang.Long)
     */
    public es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea obtenerConfiguracionTarea(java.lang.Long idModificacion)
    {
        return getSrvHerramientaModificacion().obtenerConfiguracionTarea(idModificacion);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#generarETB(es.pode.modificador.negocio.servicio.TaxonomiaVO)
     */
    public java.lang.String generarETB(es.pode.modificador.negocio.servicio.TaxonomiaVO taxonomia)
    {
        return getSrvHerramientaModificacion().generarETB(taxonomia);
    }

    /**
     * @see es.pode.modificador.negocio.servicio.SrvHerramientaModificacion#chequearResultadosODE(java.lang.String)
     */
    public es.pode.modificador.negocio.servicio.ModificacionVO[] chequearResultadosODE(java.lang.String pathOriginal)
    {
        return getSrvHerramientaModificacion().chequearResultadosODE(pathOriginal);
    }

}