// license-header java merge-point
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService}.
 *
 * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService
 */
public class SrvVocabulariosControladosServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService}
     */
    private final es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService getSrvVocabulariosControladosService()
    {
        return es.pode.fuentestaxonomicas.negocio.ServiceLocator.instance().getSrvVocabulariosControladosService();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService#obtenerCombos(java.lang.String[], java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO[] obtenerCombos(java.lang.String[] l_id, java.lang.String idioma)
    {
        return getSrvVocabulariosControladosService().obtenerCombos(l_id, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService#crearTraduccionAIngles(java.lang.String[])
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO[] crearTraduccionAIngles(java.lang.String[] l_id)
    {
        return getSrvVocabulariosControladosService().crearTraduccionAIngles(l_id);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService#crearTraduccionAIdioma(java.lang.String[], java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO[] crearTraduccionAIdioma(java.lang.String[] l_id, java.lang.String idioma)
    {
        return getSrvVocabulariosControladosService().crearTraduccionAIdioma(l_id, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService#obtenerIdTermino(es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO[])
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO[] obtenerIdTermino(es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO[] terminoypadre)
    {
        return getSrvVocabulariosControladosService().obtenerIdTermino(terminoypadre);
    }

}