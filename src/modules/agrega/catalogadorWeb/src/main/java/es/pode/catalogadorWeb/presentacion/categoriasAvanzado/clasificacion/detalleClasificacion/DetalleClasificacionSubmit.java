// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion;

/**
 * 
 */
public final class DetalleClasificacionSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DetalleClasificacionSubmitFormImpl specificForm = (DetalleClasificacionSubmitFormImpl)form;

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
    private org.apache.struts.action.ActionForward _anadirContenidoPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().anadirContenidoPalabraClave(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().cancelar(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = __hayClasificaciones(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarClasificacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidoClasificacion(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().reset(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContenidoPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().eliminarContenidoPalabraClave(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().eliminarPalabraClave(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _aceptar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().guardarClasificacion(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = __hayClasificacionesGuardar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().eliminarDescripcion(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirPalabraClave(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().anadirPalabraClave(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarRutaTaxonomica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().eliminarRutaTaxonomica(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().anadirDescripcion(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _seleccionarTaxones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().cargarTaxones(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirRutaTaxonomica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().anadirRutaTaxonomica(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.clasificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayClasificacionesGuardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().hayClasificacionesGuardar(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("clasificacion");
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
    private org.apache.struts.action.ActionForward __esValidoClasificacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().esValidoClasificacion(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("clasificacion.valida");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("clasificacion.no.valida");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("clasificacion.no.valida");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayClasificaciones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().hayClasificaciones(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("clasificacion");
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
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().accionSubmit(mapping, (DetalleClasificacionSubmitFormImpl)form, request, response));

        if (value.equals("Seleccionar Taxones"))
        {
            return _seleccionarTaxones(mapping, form, request, response);
        }
        if (value.equals("Añadir Ruta Taxonomica"))
        {
            return _anadirRutaTaxonomica(mapping, form, request, response);
        }
        if (value.equals("Eliminar Ruta Taxonomica"))
        {
            return _eliminarRutaTaxonomica(mapping, form, request, response);
        }
        if (value.equals("Añadir Descripcion"))
        {
            return _anadirDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Descripcion"))
        {
            return _eliminarDescripcion(mapping, form, request, response);
        }
        if (value.equals("Añadir Palabra Clave"))
        {
            return _anadirPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Eliminar Palabra Clave"))
        {
            return _eliminarPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarClasificacion(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _aceptar(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }
        if (value.equals("Añadir Detalle Palabra Clave"))
        {
            return _anadirContenidoPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Eliminar Detalle Palabra Clave"))
        {
            return _eliminarContenidoPalabraClave(mapping, form, request, response);
        }
        if (value.equals("Reset"))
        {
            return _reset(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _reset(mapping, form, request, response);
    }

}
