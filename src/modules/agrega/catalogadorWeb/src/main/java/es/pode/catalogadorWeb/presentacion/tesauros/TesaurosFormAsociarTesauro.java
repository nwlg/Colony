// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.tesauros;

/**
 * 
 */
public final class TesaurosFormAsociarTesauro extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final TesaurosFormAsociarTesauroFormImpl specificForm = (TesaurosFormAsociarTesauroFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _asociarTesauro(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _asociarTesauro(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.tesauros.TesaurosControllerFactory.getTesaurosControllerInstance().jerarquiasLista(mapping, (TesaurosFormAsociarTesauroFormImpl)form, request, response);
        forward = __longitudJerarquia(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _asociar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.tesauros.TesaurosControllerFactory.getTesaurosControllerInstance().asociarTesauro(mapping, (TesaurosFormAsociarTesauroFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _actualizarJerarquia(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.tesauros.TesaurosControllerFactory.getTesaurosControllerInstance().cambiarJerarquiaSesion(mapping, (TesaurosFormAsociarTesauroFormImpl)form, request, response);
        forward = mapping.findForward("datos.aform");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __longitudJerarquia(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.tesauros.TesaurosControllerFactory.getTesaurosControllerInstance().longitudJerarquia(mapping, (TesaurosFormAsociarTesauroFormImpl)form, request, response));

        if (value.equals("1"))
        {
            return _asociar(mapping, form, request, response);
        }
        if (value.equals("2"))
        {
            return _actualizarJerarquia(mapping, form, request, response);
        }
        if (value.equals("0"))
        {
            return mapping.findForward("detalle.clasificacion");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("detalle.clasificacion");
    }

}
