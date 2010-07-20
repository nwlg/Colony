// license-header java merge-point
package es.pode.presentacion.visualizador;

/**
 * 
 */
public final class Visualizar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final VisualizarFormImpl specificForm = (VisualizarFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _tipoVisualizar(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.presentacion.visualizador.VisualizadorControllerFactory.getVisualizadorControllerInstance().cargarDatos(mapping, (VisualizarFormImpl)form, request, response);
        forward = mapping.findForward("visualizar.datos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatosNav(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.presentacion.visualizador.VisualizadorControllerFactory.getVisualizadorControllerInstance().cargarDatosNav(mapping, (VisualizarFormImpl)form, request, response);
        forward = mapping.findForward("visualizar.datos.nav");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _tipoVisualizar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __cargarTipoVis(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _finSession(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.presentacion.visualizador.VisualizadorControllerFactory.getVisualizadorControllerInstance().finSession(mapping, (VisualizarFormImpl)form, request, response);
        forward = _cargarDatosNav(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __cargarTipoVis(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.presentacion.visualizador.VisualizadorControllerFactory.getVisualizadorControllerInstance().cargarTipoVis(mapping, (VisualizarFormImpl)form, request, response));

        if (value.equals("false"))
        {
            return _cargarDatos(mapping, form, request, response);
        }
        if (value.equals("true"))
        {
            return _finSession(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _finSession(mapping, form, request, response);
    }

}
