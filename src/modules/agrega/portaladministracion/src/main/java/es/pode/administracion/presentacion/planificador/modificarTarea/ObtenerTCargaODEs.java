// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * 
 */
public final class ObtenerTCargaODEs extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ObtenerTCargaODEsFormImpl specificForm = (ObtenerTCargaODEsFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarModificarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarModificarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarModificarFormImpl)previousFormObject;
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
     * <p>
     * Recuperamos los datos de la tarea carga ODEs seleccionada
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtener(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaModificarCargaODEs(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.i");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaInformeFechaUsuario(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.informe.fecha.usuario.i");


        return forward;
    }

    /**
     * <p>
     * Se recupera el tipo de tarea que va a ser modificada
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtenerTipoTarea(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTipoTarea(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = __obtenerTipoTarea(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFecha(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaInformeFecha(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.informe.fecha.i");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFederado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaInformeFederado(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.informe.federado.i");


        return forward;
    }

    /**
     * <p>
     * Se recuperan los datos de la tarea Eliminar tareas no
     * disponibles
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtenerNoDisponibles(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaNoDisponible(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.no.disponibles.i");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeFechaRango(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaInformeFechaRango(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.informes.fecha.rango.i");


        return forward;
    }

    /**
     * <p>
     * Se recuperan los datos de la tarea reindexado seleccionada
     * </p>
     */
    private org.apache.struts.action.ActionForward _obtenerReindexado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaReindexado(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.reindexado.i");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerInformeCatalogo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTareaInformeCatalogo(mapping, (ObtenerTCargaODEsFormImpl)form, request, response);
        forward = mapping.findForward("formulario.informe.catalogo.i");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __obtenerTipoTarea(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().obtenerTipoTarea(mapping, (ObtenerTCargaODEsFormImpl)form, request, response));

        if (value.equals("CargaODEs"))
        {
            return _obtener(mapping, form, request, response);
        }
        if (value.equals("Reindexado"))
        {
            return _obtenerReindexado(mapping, form, request, response);
        }
        if (value.equals("EliminarNoDisponibles"))
        {
            return _obtenerNoDisponibles(mapping, form, request, response);
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
