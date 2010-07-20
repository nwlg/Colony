// license-header java merge-point
package es.pode.visualizador.presentacion.noticia;

/**
 * 
 */
public final class Noticia extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final NoticiaFormImpl specificForm = (NoticiaFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.visualizador.presentacion.portada.NoticiasVerFormImpl)
        {
            final es.pode.visualizador.presentacion.portada.NoticiasVerFormImpl previousForm = (es.pode.visualizador.presentacion.portada.NoticiasVerFormImpl)previousFormObject;
            specificForm.setId(previousForm.getId());
        }
        else
        if (previousFormObject instanceof es.pode.visualizador.presentacion.noticias.NoticiasVerFormImpl)
        {
            final es.pode.visualizador.presentacion.noticias.NoticiasVerFormImpl previousForm = (es.pode.visualizador.presentacion.noticias.NoticiasVerFormImpl)previousFormObject;
            specificForm.setId(previousForm.getId());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargaNoticia(mapping, form, request, response);
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
     * Carga el vo de la noticia con toda la información
     * correspondiente a ella.
     * </p>
     */
    private org.apache.struts.action.ActionForward _cargaNoticia(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.visualizador.presentacion.noticia.NoticiaControllerFactory.getNoticiaControllerInstance().cargaNoticia(mapping, (NoticiaFormImpl)form, request, response);
        forward = mapping.findForward("noticia");


        return forward;
    }

}
