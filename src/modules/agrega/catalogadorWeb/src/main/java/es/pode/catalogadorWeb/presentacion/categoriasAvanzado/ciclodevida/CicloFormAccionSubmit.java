// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida;

/**
 * 
 */
public final class CicloFormAccionSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final CicloFormAccionSubmitFormImpl specificForm = (CicloFormAccionSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __accionSubmit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _anadirIdentidad(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().anadirIdentidad(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarIdentidad(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().eliminarIdentidad(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().anadirDescripcion(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().eliminarDescripcion(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarCiclo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidoCicloVida(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _aceptar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().guardarCicloVida(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().cancelar(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarVersion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().eliminarVersion(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirVersion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().anadirVersion(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().reset(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContribucion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().eliminarContribucion(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContribucion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().anadirContribucion(mapping, (CicloFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("ciclo.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __accionSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().accionSubmit(mapping, (CicloFormAccionSubmitFormImpl)form, request, response));

        if (value.equals("Añadir Version"))
        {
            return _anadirVersion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Version"))
        {
            return _eliminarVersion(mapping, form, request, response);
        }
        if (value.equals("Añadir Contribucion"))
        {
            return _anadirContribucion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Contribucion"))
        {
            return _eliminarContribucion(mapping, form, request, response);
        }
        if (value.equals("Añadir Identidad"))
        {
            return _anadirIdentidad(mapping, form, request, response);
        }
        if (value.equals("Eliminar Identidad"))
        {
            return _eliminarIdentidad(mapping, form, request, response);
        }
        if (value.equals("Añadir Descripcion"))
        {
            return _anadirDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Descripcion"))
        {
            return _eliminarDescripcion(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarCiclo(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _aceptar(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }
        if (value.equals("Reset"))
        {
            return _reset(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _reset(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esValidoCicloVida(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaControllerFactory.getCiclodevidaControllerInstance().esValidoCicloVida(mapping, (CicloFormAccionSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("ciclo.valido");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("ciclo.no.valido");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("ciclo.no.valido");
    }

}
