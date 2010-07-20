// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

/**
 * 
 */
public final class AdvertenciaExportarSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final AdvertenciaExportarSubmitFormImpl specificForm = (AdvertenciaExportarSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __submitAdvertenciaExportar(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _exportarLomes(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoControllerFactory.getCatBasicoControllerInstance().exportarLomes(mapping, (AdvertenciaExportarSubmitFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarExportar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoControllerFactory.getCatBasicoControllerInstance().validarExportar(mapping, (AdvertenciaExportarSubmitFormImpl)form, request, response);
        forward = __sonValidosExportar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __submitAdvertenciaExportar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoControllerFactory.getCatBasicoControllerInstance().submitAdvertenciaExportar(mapping, (AdvertenciaExportarSubmitFormImpl)form, request, response));

        if (value.equals("Exportar"))
        {
            return _validarExportar(mapping, form, request, response);
        }
        if (value.equals("Volver"))
        {
            return mapping.findForward("catalogador.basico");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("catalogador.basico");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __sonValidosExportar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoControllerFactory.getCatBasicoControllerInstance().sonValidosExportar(mapping, (AdvertenciaExportarSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return _exportarLomes(mapping, form, request, response);
        }
        if (value.equals("false"))
        {
            return mapping.findForward("validador.no.ok");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("validador.no.ok");
    }

}
