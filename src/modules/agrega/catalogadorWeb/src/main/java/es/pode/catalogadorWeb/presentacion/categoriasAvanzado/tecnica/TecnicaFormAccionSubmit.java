// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica;

/**
 * 
 */
public final class TecnicaFormAccionSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final TecnicaFormAccionSubmitFormImpl specificForm = (TecnicaFormAccionSubmitFormImpl)form;

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
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().reset(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarTecnica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidaTecnica(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescDuracion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarDescDuracion(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _aceptar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().guardarTecnica(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().cancelar(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirInstalacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirInstalacion(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarAgregadorOR(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarAgregador(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirAgregadorOR(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirAgregador(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarRequerimiento(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarRequerimiento(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescDuracion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirDescDuracion(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarMasRequerimientos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarMasRequerimientos(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirMasRequerimientos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirMasRequerimientos(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarInstalacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarInstalacion(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirFormato(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirFormato(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirRequerimiento(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirRequerimiento(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarLocalizacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarLocalizacion(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirLocalizacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().anadirLocalizacion(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarFormato(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().eliminarFormato(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("tecnica.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esValidaTecnica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().esValidaTecnica(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("tecnica.valida");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("tecnica.no.valida");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("tecnica.no.valida");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __accionSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaControllerFactory.getTecnicaControllerInstance().accionSubmit(mapping, (TecnicaFormAccionSubmitFormImpl)form, request, response));

        if (value.equals("Añadir Formato"))
        {
            return _anadirFormato(mapping, form, request, response);
        }
        if (value.equals("Eliminar Formato"))
        {
            return _eliminarFormato(mapping, form, request, response);
        }
        if (value.equals("Añadir Localizacion"))
        {
            return _anadirLocalizacion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Localizacion"))
        {
            return _eliminarLocalizacion(mapping, form, request, response);
        }
        if (value.equals("Añadir Requerimiento"))
        {
            return _anadirRequerimiento(mapping, form, request, response);
        }
        if (value.equals("Eliminar Requerimiento"))
        {
            return _eliminarRequerimiento(mapping, form, request, response);
        }
        if (value.equals("Añadir AgregadorOR"))
        {
            return _anadirAgregadorOR(mapping, form, request, response);
        }
        if (value.equals("Eliminar AgregadorOR"))
        {
            return _eliminarAgregadorOR(mapping, form, request, response);
        }
        if (value.equals("Añadir Instalacion"))
        {
            return _anadirInstalacion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Instalacion"))
        {
            return _eliminarInstalacion(mapping, form, request, response);
        }
        if (value.equals("Añadir MasRequerimientos"))
        {
            return _anadirMasRequerimientos(mapping, form, request, response);
        }
        if (value.equals("Eliminar MasRequerimientos"))
        {
            return _eliminarMasRequerimientos(mapping, form, request, response);
        }
        if (value.equals("Añadir DescDuracion"))
        {
            return _anadirDescDuracion(mapping, form, request, response);
        }
        if (value.equals("Eliminar DescDuracion"))
        {
            return _eliminarDescDuracion(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _aceptar(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarTecnica(mapping, form, request, response);
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

}
