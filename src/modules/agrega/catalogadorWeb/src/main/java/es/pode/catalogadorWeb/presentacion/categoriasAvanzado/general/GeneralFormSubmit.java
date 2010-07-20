// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general;

/**
 * 
 */
public final class GeneralFormSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GeneralFormSubmitFormImpl specificForm = (GeneralFormSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submitForm(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _eliminarCaracteristica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarCaracteristica(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirCaracteristica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirCaracteristica(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarDescripcion(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirContenidoDescripcion(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarContenidoDescripcion(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirPalabrasClave(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarAmbitos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarAmbitos(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContAmbito(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirContenidoAmbito(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContAmbito(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarContenidoAmbito(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirDescripcion(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirIdioma(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirIdioma(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarIdioma(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarIdioma(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirAmbitos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirAmbitos(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _aceptar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().guardarGeneral(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submitForm(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __accionSubmit(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().reset(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().cancelar(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirTitulo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirTitulo(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarIdentificador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarIdentificador(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarGeneral(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidoGeneral(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarTitulo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarTitulo(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirContenidoPalabraClave(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarPalabrasClave(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirIdentificador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().anadirIdentificador(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().eliminarContenidoPalabraClave(mapping, (GeneralFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("general.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esValidoGeneral(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().esValidoGeneral(mapping, (GeneralFormSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("valido.general");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("no.valido.general");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("no.valido.general");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __accionSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().accionSubmit(mapping, (GeneralFormSubmitFormImpl)form, request, response));

        if (value.equals("Añadir Idioma"))
        {
            return _anadirIdioma(mapping, form, request, response);
        }
        if (value.equals("Eliminar Idioma"))
        {
            return _eliminarIdioma(mapping, form, request, response);
        }
        if (value.equals("Añadir Ambitos"))
        {
            return _anadirAmbitos(mapping, form, request, response);
        }
        if (value.equals("Eliminar Ambitos"))
        {
            return _eliminarAmbitos(mapping, form, request, response);
        }
        if (value.equals("Añadir ContAmbito"))
        {
            return _anadirContAmbito(mapping, form, request, response);
        }
        if (value.equals("Eliminar ContAmbito"))
        {
            return _eliminarContAmbito(mapping, form, request, response);
        }
        if (value.equals("Añadir Descripcion"))
        {
            return _anadirDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Descripcion"))
        {
            return _eliminarDescripcion(mapping, form, request, response);
        }
        if (value.equals("Añadir ContDescripcion"))
        {
            return _anadirContDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar ContDescripcion"))
        {
            return _eliminarContDescripcion(mapping, form, request, response);
        }
        if (value.equals("Añadir PalabraClave"))
        {
            return _anadirPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Eliminar PalabraClave"))
        {
            return _eliminarPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Añadir ContPalabraClave"))
        {
            return _anadirContPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Eliminar ContPalabraClave"))
        {
            return _eliminarContPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Añadir Identificador"))
        {
            return _anadirIdentificador(mapping, form, request, response);
        }
        if (value.equals("Eliminar Identificador"))
        {
            return _eliminarIdentificador(mapping, form, request, response);
        }
        if (value.equals("Añadir Titulo"))
        {
            return _anadirTitulo(mapping, form, request, response);
        }
        if (value.equals("Eliminar Titulo"))
        {
            return _eliminarTitulo(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _aceptar(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarGeneral(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }
        if (value.equals("Reset"))
        {
            return _reset(mapping, form, request, response);
        }
        if (value.equals("Añadir Caracteristica"))
        {
            return _anadirCaracteristica(mapping, form, request, response);
        }
        if (value.equals("Eliminar Caracteristica"))
        {
            return _eliminarCaracteristica(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _eliminarCaracteristica(mapping, form, request, response);
    }

}
