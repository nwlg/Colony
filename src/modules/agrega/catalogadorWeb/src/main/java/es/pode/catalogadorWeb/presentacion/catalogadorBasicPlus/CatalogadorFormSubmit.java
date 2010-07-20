// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * 
 */
public final class CatalogadorFormSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final CatalogadorFormSubmitFormImpl specificForm = (CatalogadorFormSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _realizarSubmit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _volverAEmpaquetador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().volverAEmpaquetador(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = null;
        

        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _realizarSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().realizarSubmit(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = __recogeAccion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _confirmarGuardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().cargarDatosGuardar(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("guardarpres");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarArbol(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().eliminarArbol(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = _cargarDatos(mapping, form, request, response);

        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatosSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().cargarDatosSesion(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = mapping.findForward("taxonomias");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarMetadatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().validarMetadatos(mapping, (ValidarMetadatosForm)form, request, response);
        forward = __sonValidosMDBO(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _compararDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().chequearDatos(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = __actualizados(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _exportarLomes(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        //es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().exportarLomes(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().cargarDatos(mapping, (CargarDatosForm)form, request, response);
        forward = mapping.findForward("catalogador.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarExportar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        //es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().validarExportar(mapping, (CatalogadorFormSubmitFormImpl)form, request, response);
        forward = __sonValidosExportar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __sonValidosMDBO(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().sonValidosMDBO(mapping, (CatalogadorFormSubmitFormImpl)form, request, response));

        if (value.equals("false"))
        {
            return mapping.findForward("validador.no.ok");
        }
        if (value.equals("true"))
        {
            return mapping.findForward("validador.ok");
        }
    	
        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("validador.ok");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __recogeAccion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().recogeAccion(mapping, (CatalogadorFormSubmitFormImpl)form, request, response));

        if (value.equals("Cancelar"))
        {
            return _volverAEmpaquetador(mapping, form, request, response);
        }
        if (value.equals("Exportar"))
        {
            return _compararDatos(mapping, form, request, response);
        }
        if (value.equals("Eliminar"))
        {
            return _eliminarArbol(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarMetadatos(mapping, form, request, response);
        }
        if (value.equals("Arbol Curricular"))
        {
            return _cargarDatosSesion(mapping, form, request, response);
        }
        if (value.equals("Guardar"))
        {
            return _confirmarGuardar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _confirmarGuardar(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __sonValidosExportar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	/*
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().sonValidosExportar(mapping, (CatalogadorFormSubmitFormImpl)form, request, response));

        if (value.equals("false"))
        {
            return mapping.findForward("validador.no.ok");
        }
        if (value.equals("true"))
        {
            return _exportarLomes(mapping, form, request, response);
        }
		*/
    	
        // we take the last action in case we have an invalid return value from the controller
        return _exportarLomes(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __actualizados(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().actualizados(mapping, (CatalogadorFormSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return _validarExportar(mapping, form, request, response);
        }
        if (value.equals("false"))
        {
            return mapping.findForward("advertencia.exportar");
        }
    	
        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("advertencia.exportar");
    }

}
