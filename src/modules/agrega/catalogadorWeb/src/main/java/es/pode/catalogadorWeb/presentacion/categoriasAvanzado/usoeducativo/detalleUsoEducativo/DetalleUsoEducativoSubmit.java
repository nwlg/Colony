// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo;

/**
 * 
 */
public final class DetalleUsoEducativoSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DetalleUsoEducativoSubmitFormImpl specificForm = (DetalleUsoEducativoSubmitFormImpl)form;

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
    private org.apache.struts.action.ActionForward _eliminarProcesoCognitivo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarProcesoCognitivo(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _aceptar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().guardarUsoEducativo(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = __hayUsosEducativosGuardar(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarUsoEducativo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidoUsoEdu(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContenidoDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarContenidoDescripcion(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirIdioma(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirIdioma(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarIdioma(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarIdioma(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirProcesoCognitivo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirProcesoCognitivo(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().reset(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().cancelar(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = __hayUsosEducativos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContexto(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirContexto(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarRolUsuario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarRolUsuario(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirEdadTipica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirEdadTipica(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContexto(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarContexto(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirTipoRecurso(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirTipoRecurso(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirRolUsuario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirRolUsuario(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarTipoRecurso(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarTipoRecurso(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirDescripcion(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcionTiempoAp(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarDescTiempoAp(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContenidoDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirContenidoDescripcion(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarDescripcion(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirContenidoEdadTipica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirContenidoEdadTipica(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarEdadTipica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarEdadTipica(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcionTiempoAp(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirDescTiempoAp(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarContenidoEdadTipica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarContenidoEdadTipica(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcionCat(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().eliminarDescripcionCat(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcionCat(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().anadirDescripcionCat(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response);
        forward = mapping.findForward("detalle.uso.educativo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayUsosEducativos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().hayUsosEducativos(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("uso.educativo");
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
    private org.apache.struts.action.ActionForward __esValidoUsoEdu(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().esValidoUsoEdu(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("uso.educativo.valido");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("uso.educativo.no.valido");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("uso.educativo.no.valido");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayUsosEducativosGuardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().hayUsosEducativosGuardar(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("uso.educativo");
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
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEduControllerFactory.getDetalleUsoEduControllerInstance().accionSubmit(mapping, (DetalleUsoEducativoSubmitFormImpl)form, request, response));

        if (value.equals("Añadir Tipo Recurso"))
        {
            return _anadirTipoRecurso(mapping, form, request, response);
        }
        if (value.equals("Eliminar Tipo Recurso"))
        {
            return _eliminarTipoRecurso(mapping, form, request, response);
        }
        if (value.equals("Añadir Rol Usuario"))
        {
            return _anadirRolUsuario(mapping, form, request, response);
        }
        if (value.equals("Eliminar Rol Usuario"))
        {
            return _eliminarRolUsuario(mapping, form, request, response);
        }
        if (value.equals("Añadir Contexto"))
        {
            return _anadirContexto(mapping, form, request, response);
        }
        if (value.equals("Eliminar Contexto"))
        {
            return _eliminarContexto(mapping, form, request, response);
        }
        if (value.equals("Añadir Edad Tipica"))
        {
            return _anadirEdadTipica(mapping, form, request, response);
        }
        if (value.equals("Eliminar Edad Tipica"))
        {
            return _eliminarEdadTipica(mapping, form, request, response);
        }
        if (value.equals("Añadir Contenido Edad Tipica"))
        {
            return _anadirContenidoEdadTipica(mapping, form, request, response);
        }
        if (value.equals("Eliminar Contenido Edad Tipica"))
        {
            return _eliminarContenidoEdadTipica(mapping, form, request, response);
        }
        if (value.equals("Añadir Descripcion TiempoAp"))
        {
            return _anadirDescripcionTiempoAp(mapping, form, request, response);
        }
        if (value.equals("Eliminar Descripcion TiempoAp"))
        {
            return _eliminarDescripcionTiempoAp(mapping, form, request, response);
        }
        if (value.equals("Añadir Descripcion"))
        {
            return _anadirDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Descripcion"))
        {
            return _eliminarDescripcion(mapping, form, request, response);
        }
        if (value.equals("Añadir Contenido Descripcion"))
        {
            return _anadirContenidoDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar Contenido Descripcion"))
        {
            return _eliminarContenidoDescripcion(mapping, form, request, response);
        }
        if (value.equals("Añadir Idioma"))
        {
            return _anadirIdioma(mapping, form, request, response);
        }
        if (value.equals("Eliminar Idioma"))
        {
            return _eliminarIdioma(mapping, form, request, response);
        }
        if (value.equals("Añadir Proceso Cognitivo"))
        {
            return _anadirProcesoCognitivo(mapping, form, request, response);
        }
        if (value.equals("Eliminar Proceso Cognitivo"))
        {
            return _eliminarProcesoCognitivo(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _aceptar(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarUsoEducativo(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }
        if (value.equals("Reset"))
        {
            return _reset(mapping, form, request, response);
        }
        if (value.equals("Añadir DescripcionCat"))
        {
            return _anadirDescripcionCat(mapping, form, request, response);
        }
        if (value.equals("Eliminar DescripcionCat"))
        {
            return _eliminarDescripcionCat(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _eliminarDescripcionCat(mapping, form, request, response);
    }

}
