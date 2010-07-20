// license-header java merge-point
package es.pode.administracion.presentacion.planificador.descripcionTarea;

/**
 * 
 */
public final class DescripcionTarea extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DescripcionTareaFormImpl specificForm = (DescripcionTareaFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarMostrarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarMostrarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarMostrarFormImpl)previousFormObject;
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTrabajo(previousForm.getTrabajo());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _obtenerTipoTarea(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _obtenerEliminarOdes(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaEliminarOdes(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.eliminar.odes");


        return forward;
    }

    /**
     * <p>
     * Recupera el tipo de la tarea a mostrar
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtenerTipoTarea(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTipoTarea(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = __obtenerTipoTarea(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFecha(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaInformeFecha(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.informe.fecha");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFechaRango(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaInformeFechaRango(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.informe.fecha.rango");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaInformeFechaUsuario(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.informe.fecha.usuario");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFederado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obternerTareaInformeFederado(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.informe.federado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeCatalogo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaInformeCatalogo(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.informe.catalogo");


        return forward;
    }

    /**
     * <p>
     * Recupera los datos de la tarea de reindexado seleccionada
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtenerReindexado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaReindexado(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.reindexado");


        return forward;
    }

    /**
     * <p>
     * Recupera los datos de la tarea carga ODEs seleccionada
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtenerCargaODEs(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTareaModificarCargaODEs(mapping, (DescripcionTareaFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.carga.odes");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __obtenerTipoTarea(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.planificador.descripcionTarea.DescripcionTareaControllerFactory.getDescripcionTareaControllerInstance().obtenerTipoTarea(mapping, (DescripcionTareaFormImpl)form, request, response));

        if (value.equals("CargaODEs"))
        {
            return _obtenerCargaODEs(mapping, form, request, response);
        }
        if (value.equals("Reindexado"))
        {
            return _obtenerReindexado(mapping, form, request, response);
        }
        if (value.equals("EliminarNoDisponibles"))
        {
            return _obtenerEliminarOdes(mapping, form, request, response);
        }
        if (value.equals("InformeFecha"))
        {
            return _obtenerInformeFecha(mapping, form, request, response);
        }
        if (value.equals("InformeFechaRango"))
        {
            return _obtenerInformeFechaRango(mapping, form, request, response);
        }
        if (value.equals("InformeFechaUsuario"))
        {
            return _obtenerInformeFechaUsuario(mapping, form, request, response);
        }
        if (value.equals("InformeFederado"))
        {
            return _obtenerInformeFederado(mapping, form, request, response);
        }
        if (value.equals("InformeCatalogo"))
        {
            return _obtenerInformeCatalogo(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _obtenerInformeCatalogo(mapping, form, request, response);
    }

}
