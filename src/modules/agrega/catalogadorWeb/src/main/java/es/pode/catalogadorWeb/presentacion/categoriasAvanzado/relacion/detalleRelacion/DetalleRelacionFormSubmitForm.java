// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion;

/**
 * 
 */
public final class DetalleRelacionFormSubmitForm extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DetalleRelacionFormSubmitFormFormImpl specificForm = (DetalleRelacionFormSubmitFormFormImpl)form;

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
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().eliminarDescripcion(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.relacion.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().anadirDescripcion(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.relacion.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _guardarRelacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().guardarRelacion(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = __hayRelacionesGuardar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarRelacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidaRelacion(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().eliminarContDescripcion(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.relacion.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().anadirContDescripcion(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.relacion.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().cancelar(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = __hayRelaciones(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().reset(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.relacion.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esValidaRelacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().esValidaRelacion(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("relacion.valida");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("relacion.no.valida");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("relacion.no.valida");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __accionSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().accionSubmit(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response));

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
        if (value.equals("Validar"))
        {
            return _validarRelacion(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _guardarRelacion(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward __hayRelacionesGuardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().hayRelacionesGuardar(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("relacion");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("catalogador.avanzado");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("catalogador.avanzado");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayRelaciones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionControllerFactory.getDetalleRelacionControllerInstance().hayRelaciones(mapping, (DetalleRelacionFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("relacion");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("catalogador.avanzado");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("catalogador.avanzado");
    }

}
