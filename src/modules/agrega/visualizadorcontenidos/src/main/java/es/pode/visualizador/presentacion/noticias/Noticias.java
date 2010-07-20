// license-header java merge-point
package es.pode.visualizador.presentacion.noticias;

/**
 * 
 */
public final class Noticias extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final NoticiasFormImpl specificForm = (NoticiasFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.visualizador.presentacion.portada.NoticiasCategoriaFormImpl)
        {
            final es.pode.visualizador.presentacion.portada.NoticiasCategoriaFormImpl previousForm = (es.pode.visualizador.presentacion.portada.NoticiasCategoriaFormImpl)previousFormObject;
            specificForm.setIdCategoria(previousForm.getIdCategoria());
        }
        else
        if (previousFormObject instanceof es.pode.visualizador.presentacion.noticia.NoticiaCategoriaFormImpl)
        {
            final es.pode.visualizador.presentacion.noticia.NoticiaCategoriaFormImpl previousForm = (es.pode.visualizador.presentacion.noticia.NoticiaCategoriaFormImpl)previousFormObject;
            specificForm.setCategoriaVO(previousForm.getCategoriaVO());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperarParametros(mapping, form, request, response);
        }
        catch (java.lang.Exception exception)
        {
            // we populate the current form with only the request parameters
            Object currentForm = request.getSession().getAttribute("form");
            // if we can't get the 'form' from the session, try from the request
            if (currentForm == null)
            {
                currentForm = request.getAttribute("form");
            }
            if (currentForm != null)
            {
                final java.util.Map parameters = new java.util.HashMap();
                for (final java.util.Enumeration names = request.getParameterNames(); names.hasMoreElements();)
                {
                    final String name = String.valueOf(names.nextElement());
                    parameters.put(name, request.getParameter(name));
                }
                try
                {
                    org.apache.commons.beanutils.BeanUtils.populate(currentForm, parameters);
                }
                catch (java.lang.Exception populateException)
                {
                    // ignore if we have an exception here (we just don't populate).
                }
            }
            throw exception;
        }
        request.getSession().setAttribute("form", form);


        return forward;
    }

    /**
     * <p>
     * Obtiene un listado de noticias. Segun los datos de entrada, el
     * listado es de noticias redactadas en el idioma deseado o de
     * noticias redactadas en el idioma y pertenecientes a la categoria
     * indicada. El listado se ordena por fecha de publicación.
     * </p>
     */
    private org.apache.struts.action.ActionForward _cargaNoticias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.visualizador.presentacion.noticias.NoticiasControllerFactory.getNoticiasControllerInstance().obtenerNoticias(mapping, (NoticiasFormImpl)form, request, response);
        forward = mapping.findForward("noticias");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarParametros(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = _cargaNoticias(mapping, form, request, response);
        return forward;
    }

}
