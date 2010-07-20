// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

/**
 * 
 */
public final class GestorBasicoSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GestorBasicoSubmitFormImpl specificForm = (GestorBasicoSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _dummy(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("desagregar.basico");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().recuperarDatos(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("gestor.basico");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().submit(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = __selectAction(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _pegar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().pegar(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = _vaciarPortapapeles(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _copiar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().copiar(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().eliminar(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cortar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().cortar(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _vaciarPortapapeles(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().vaciarPortapapeles(mapping, (GestorBasicoSubmitFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().selectAction(mapping, (GestorBasicoSubmitFormImpl)form, request, response));

        if (value.equals("Copiar"))
        {
            return _copiar(mapping, form, request, response);
        }
        if (value.equals("Cortar"))
        {
            return _cortar(mapping, form, request, response);
        }
        if (value.equals("Pegar"))
        {
            return _pegar(mapping, form, request, response);
        }
        if (value.equals("Eliminar"))
        {
            return _eliminar(mapping, form, request, response);
        }
        if (value.equals("CrearCarpeta"))
        {
            return mapping.findForward("crear.carpeta.basico");
        }
        if (value.equals("Agregar"))
        {
            return mapping.findForward("agregar.submanifiesto");
        }
        if (value.equals("Ninguno"))
        {
            return _recuperarDatos(mapping, form, request, response);
        }
        if (value.equals("Desagregar"))
        {
            return _dummy(mapping, form, request, response);
        }
        if (value.equals("RenombrarOrganizacion"))
        {
            return mapping.findForward("renombrar.organizacion.basico");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("renombrar.organizacion.basico");
    }

}
