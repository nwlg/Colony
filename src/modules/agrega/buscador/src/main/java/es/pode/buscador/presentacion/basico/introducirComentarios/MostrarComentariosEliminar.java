// license-header java merge-point
package es.pode.buscador.presentacion.basico.introducirComentarios;

/**
 * 
 */
public final class MostrarComentariosEliminar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final MostrarComentariosEliminarFormImpl specificForm = (MostrarComentariosEliminarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperarSeleccion(mapping, form, request, response);
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
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarSeleccion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosControllerFactory.getIntroducirComentariosControllerInstance().recuperarSeleccionIds(mapping, (MostrarComentariosEliminarFormImpl)form, request, response);
        forward = __validaBotonEliminar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarComentarios(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosControllerFactory.getIntroducirComentariosControllerInstance().recuperarComentariosODE(mapping, (MostrarComentariosEliminarFormImpl)form, request, response);
        forward = mapping.findForward("listar.comentarios");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __validaBotonEliminar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosControllerFactory.getIntroducirComentariosControllerInstance().validaBotonEliminar(mapping, (MostrarComentariosEliminarFormImpl)form, request, response));

        if (value.equals("NO"))
        {
            return _recuperarComentarios(mapping, form, request, response);
        }
        if (value.equals("SI"))
        {
            return mapping.findForward("advertencia.eliminar");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("advertencia.eliminar");
    }

}
