// license-header java merge-point
package es.pode.tagging.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.tagging.negocio.servicios.SrvTaggingServer}.
 *
 * @see es.pode.tagging.negocio.servicios.SrvTaggingServer
 */
public class SrvTaggingServerWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.tagging.negocio.servicios.SrvTaggingServer}
     */
    private final es.pode.tagging.negocio.servicios.SrvTaggingServer getSrvTaggingServer()
    {
        return es.pode.ServiceLocator.instance().getSrvTaggingServer();
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#introducirTags(java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.String)
     */
    public void introducirTags(java.lang.String idOde, java.lang.String titulo, java.lang.String idiomaCat, java.lang.String[] tags, java.lang.String idUsuario)
    {
        getSrvTaggingServer().introducirTags(idOde, titulo, idiomaCat, tags, idUsuario);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#obtenerTagsDeUsuario(java.lang.String)
     */
    public es.pode.tagging.negocio.servicios.TagVO[] obtenerTagsDeUsuario(java.lang.String idUsuario)
    {
        return getSrvTaggingServer().obtenerTagsDeUsuario(idUsuario);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#obtenerOdesDeTagYUsuario(java.lang.String, java.lang.String)
     */
    public es.pode.tagging.negocio.servicios.TaggingVO[] obtenerOdesDeTagYUsuario(java.lang.String tag, java.lang.String idUsuario)
    {
        return getSrvTaggingServer().obtenerOdesDeTagYUsuario(tag, idUsuario);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#obtenerTodosTags()
     */
    public es.pode.tagging.negocio.servicios.TagVO[] obtenerTodosTags()
    {
        return getSrvTaggingServer().obtenerTodosTags();
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#obtenerOdesDeTag(java.lang.String)
     */
    public es.pode.tagging.negocio.servicios.TaggingVO[] obtenerOdesDeTag(java.lang.String tag)
    {
        return getSrvTaggingServer().obtenerOdesDeTag(tag);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#eliminarTags(java.lang.String[])
     */
    public boolean eliminarTags(java.lang.String[] tagsABorrar)
    {
        return getSrvTaggingServer().eliminarTags(tagsABorrar);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#modificarTag(java.lang.String, java.lang.String)
     */
    public boolean modificarTag(java.lang.String oldTag, java.lang.String newTag)
    {
        return getSrvTaggingServer().modificarTag(oldTag, newTag);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#modificarTagDeUsuario(java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean modificarTagDeUsuario(java.lang.String oldTag, java.lang.String newTag, java.lang.String idUsuario)
    {
        return getSrvTaggingServer().modificarTagDeUsuario(oldTag, newTag, idUsuario);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#eliminarTagsDeUsuario(java.lang.String[], java.lang.String)
     */
    public boolean eliminarTagsDeUsuario(java.lang.String[] tagsABorrar, java.lang.String idUsuario)
    {
        return getSrvTaggingServer().eliminarTagsDeUsuario(tagsABorrar, idUsuario);
    }

    /**
     * @see es.pode.tagging.negocio.servicios.SrvTaggingServer#obtenerTagsDeOde(java.lang.String)
     */
    public java.lang.String[] obtenerTagsDeOde(java.lang.String idOde)
    {
        return getSrvTaggingServer().obtenerTagsDeOde(idOde);
    }

}