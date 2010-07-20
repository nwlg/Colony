// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion;

/**
 * 
 */
public final class DetalleFormSubmitForm extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DetalleFormSubmitFormFormImpl specificForm = (DetalleFormSubmitFormFormImpl)form;

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
    private org.apache.struts.action.ActionForward _validarAnotacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidaAnotacion(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _guardarDetalleAnotacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().guardarAnotacion(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = __hayAnotacionesGuardar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().eliminarDescripcion(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().anadirDescripcion(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcionFecha(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().eliminarDescripcionFecha(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcionFecha(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().anadirDescripcionFecha(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().reset(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("detalle.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().cancelar(mapping, (DetalleFormSubmitFormFormImpl)form, request, response);
        forward = __hayAnotaciones(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayAnotaciones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().hayAnotaciones(mapping, (DetalleFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("anotacion");
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
    private org.apache.struts.action.ActionForward __hayAnotacionesGuardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().hayAnotacionesGuardar(mapping, (DetalleFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("anotacion");
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
    private org.apache.struts.action.ActionForward __accionSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().accionSubmit(mapping, (DetalleFormSubmitFormFormImpl)form, request, response));

        if (value.equals("Añadir DescFecha"))
        {
            return _anadirDescripcionFecha(mapping, form, request, response);
        }
        if (value.equals("Eliminar DescFecha"))
        {
            return _eliminarDescripcionFecha(mapping, form, request, response);
        }
        if (value.equals("Añadir Descripcion"))
        {
            return _anadirDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Descripcion"))
        {
            return _eliminarDescripcion(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _guardarDetalleAnotacion(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarAnotacion(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward __esValidaAnotacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionControllerFactory.getDetalleAnotacionControllerInstance().esValidaAnotacion(mapping, (DetalleFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("anotacion.valida");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("anotacion.no.valida");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("anotacion.no.valida");
    }

}
