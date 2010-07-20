// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq;

/**
 * 
 */
public final class FormularioModificarCategoriaFaqValidarFormulario extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final FormularioModificarCategoriaFaqValidarFormularioFormImpl specificForm = (FormularioModificarCategoriaFaqValidarFormularioFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _validarFormulario(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _validarFormulario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqControllerFactory.getModificarCategoriaFaqControllerInstance().validarFormulario(mapping, (FormularioModificarCategoriaFaqValidarFormularioFormImpl)form, request, response);
        forward = __analizaValidacion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqControllerFactory.getModificarCategoriaFaqControllerInstance().recuperarDatos(mapping, (FormularioModificarCategoriaFaqValidarFormularioFormImpl)form, request, response);
        forward = mapping.findForward("recupera.datos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _modificarCategoriaFaq(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqControllerFactory.getModificarCategoriaFaqControllerInstance().modificarCategoriaFaq(mapping, (FormularioModificarCategoriaFaqValidarFormularioFormImpl)form, request, response);
        forward = mapping.findForward("aceptar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaValidacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqControllerFactory.getModificarCategoriaFaqControllerInstance().analizaValidacion(mapping, (FormularioModificarCategoriaFaqValidarFormularioFormImpl)form, request, response));

        if (value.equals("TRUE"))
        {
            return _modificarCategoriaFaq(mapping, form, request, response);
        }
        if (value.equals("FALSE"))
        {
            return _recuperarDatos(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _recuperarDatos(mapping, form, request, response);
    }

}
