// license-header java merge-point
package es.pode.administracion.presentacion.noticias.eliminar;

/**
 * 
 */
public final class EliminarNoticias extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final EliminarNoticiasFormImpl specificForm = (EliminarNoticiasFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.noticias.noticias.NoticiasEliminarFormImpl)
        {
            final es.pode.administracion.presentacion.noticias.noticias.NoticiasEliminarFormImpl previousForm = (es.pode.administracion.presentacion.noticias.noticias.NoticiasEliminarFormImpl)previousFormObject;
            specificForm.setIds(previousForm.getIds());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _obtenerIdiomas(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _obtenerIdiomas(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.noticias.eliminar.EliminarControllerFactory.getEliminarControllerInstance().obtenerIdiomas(mapping, (EliminarNoticiasFormImpl)form, request, response);
        forward = __validarSeleccion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __validarSeleccion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.noticias.eliminar.EliminarControllerFactory.getEliminarControllerInstance().validarSeleccion(mapping, (EliminarNoticiasFormImpl)form, request, response));

        if (value.equals("CON_SELECCION"))
        {
            return mapping.findForward("confirmacion");
        }
        if (value.equals("SIN_SELECCION"))
        {
            return mapping.findForward("noticias");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("noticias");
    }

}
