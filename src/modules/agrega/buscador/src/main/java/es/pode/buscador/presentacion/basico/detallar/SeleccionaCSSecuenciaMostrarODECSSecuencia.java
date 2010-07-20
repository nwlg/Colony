// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * 
 */
public final class SeleccionaCSSecuenciaMostrarODECSSecuencia extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SeleccionaCSSecuenciaMostrarODECSSecuenciaFormImpl specificForm = (SeleccionaCSSecuenciaMostrarODECSSecuenciaFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __tipoVisualizador(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _visualizarConSec(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _visualizarSinSec(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _visualizarAdl(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __tipoVisualizador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().tipoVisualizador(mapping, (SeleccionaCSSecuenciaMostrarODECSSecuenciaFormImpl)form, request, response));

        if (value.equals("false"))
        {
            return _visualizarSinSec(mapping, form, request, response);
        }
        if (value.equals("true"))
        {
            return _visualizarConSec(mapping, form, request, response);
        }
        if (value.equals("adl"))
        {
            return _visualizarAdl(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _visualizarAdl(mapping, form, request, response);
    }

}
