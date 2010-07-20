// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasPendientes;

/**
 * 
 */
public final class ListarTareasPendientes extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ListarTareasPendientesFormImpl specificForm = (ListarTareasPendientesFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioInicioCrearTareaFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioInicioCrearTareaFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioInicioCrearTareaFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFederadoAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFederadoAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFederadoAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasUsuariosAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasUsuariosAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasUsuariosAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioReindexadoAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioReindexadoAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioReindexadoAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasRangoAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasRangoAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioInformeFechasRangoAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioTareaCargaODEsAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioTareaCargaODEsAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioTareaCargaODEsAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.crearTarea.FormularioEliminarNoDisponiblesAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.crearTarea.FormularioEliminarNoDisponiblesAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.crearTarea.FormularioEliminarNoDisponiblesAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioReindexadoIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioReindexadoIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioReindexadoIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFederadoIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFederadoIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFederadoIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioNoDisponiblesIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioNoDisponiblesIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioNoDisponiblesIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaUsuarioIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaUsuarioIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaUsuarioIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaRangoIIAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaRangoIIAceptarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeFechaRangoIIAceptarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeCatalogoIContinuarFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeCatalogoIContinuarFormImpl previousForm = (es.pode.administracion.presentacion.planificador.modificarTarea.FormularioInformeCatalogoIContinuarFormImpl)previousFormObject;
            specificForm.setTareaModificada(previousForm.getTareaModificada());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeCatalogoVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeCatalogoVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeCatalogoVolverFormImpl)previousFormObject;
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setInforme(previousForm.getInforme());
            specificForm.setDia(previousForm.getDia());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoInforme(previousForm.getMsgNoInforme());
            specificForm.setMsgDescTrabajo(previousForm.getMsgDescTrabajo());
            specificForm.setMsgInforme(previousForm.getMsgInforme());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarCargaODEsVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarCargaODEsVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarCargaODEsVolverFormImpl)previousFormObject;
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setMsgPublicado(previousForm.getMsgPublicado());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setMsgDescCargaODEs(previousForm.getMsgDescCargaODEs());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setDia(previousForm.getDia());
            specificForm.setPathODEsCargados(previousForm.getPathODEsCargados());
            specificForm.setPathODEsNoCargados(previousForm.getPathODEsNoCargados());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoPublicado(previousForm.getMsgNoPublicado());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
            specificForm.setPathODEs(previousForm.getPathODEs());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaVolverFormImpl)previousFormObject;
            specificForm.setAnioHasta(previousForm.getAnioHasta());
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setInforme(previousForm.getInforme());
            specificForm.setDia(previousForm.getDia());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setDiaHasta(previousForm.getDiaHasta());
            specificForm.setAnioDesde(previousForm.getAnioDesde());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoInforme(previousForm.getMsgNoInforme());
            specificForm.setMsgDescTrabajo(previousForm.getMsgDescTrabajo());
            specificForm.setMsgInforme(previousForm.getMsgInforme());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
            specificForm.setMesHasta(previousForm.getMesHasta());
            specificForm.setDiaDesde(previousForm.getDiaDesde());
            specificForm.setMesDesde(previousForm.getMesDesde());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarReindexadoVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarReindexadoVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarReindexadoVolverFormImpl)previousFormObject;
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setMsgReindexado(previousForm.getMsgReindexado());
            specificForm.setDia(previousForm.getDia());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoReindexado(previousForm.getMsgNoReindexado());
            specificForm.setMes(previousForm.getMes());
            specificForm.setMsgDescReindexado(previousForm.getMsgDescReindexado());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
            specificForm.setRepositorio(previousForm.getRepositorio());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFederadoVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFederadoVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFederadoVolverFormImpl)previousFormObject;
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setInforme(previousForm.getInforme());
            specificForm.setDia(previousForm.getDia());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoInforme(previousForm.getMsgNoInforme());
            specificForm.setMsgDescTrabajo(previousForm.getMsgDescTrabajo());
            specificForm.setMsgInforme(previousForm.getMsgInforme());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaUsuarioVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaUsuarioVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaUsuarioVolverFormImpl)previousFormObject;
            specificForm.setAnioHasta(previousForm.getAnioHasta());
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setUsuario(previousForm.getUsuario());
            specificForm.setInforme(previousForm.getInforme());
            specificForm.setDia(previousForm.getDia());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setDiaHasta(previousForm.getDiaHasta());
            specificForm.setAnioDesde(previousForm.getAnioDesde());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoInforme(previousForm.getMsgNoInforme());
            specificForm.setMsgDescTrabajo(previousForm.getMsgDescTrabajo());
            specificForm.setMsgInforme(previousForm.getMsgInforme());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
            specificForm.setMesHasta(previousForm.getMesHasta());
            specificForm.setDiaDesde(previousForm.getDiaDesde());
            specificForm.setMesDesde(previousForm.getMesDesde());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarEliminarOdesVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarEliminarOdesVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarEliminarOdesVolverFormImpl)previousFormObject;
            specificForm.setAnioHasta(previousForm.getAnioHasta());
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setDia(previousForm.getDia());
            specificForm.setMsgNoEliminado(previousForm.getMsgNoEliminado());
            specificForm.setDiaHasta(previousForm.getDiaHasta());
            specificForm.setAnioDesde(previousForm.getAnioDesde());
            specificForm.setMsgEliminado(previousForm.getMsgEliminado());
            specificForm.setMsgDescTrabajo(previousForm.getMsgDescTrabajo());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
            specificForm.setMesHasta(previousForm.getMesHasta());
            specificForm.setDiaDesde(previousForm.getDiaDesde());
            specificForm.setMesDesde(previousForm.getMesDesde());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaRangoVolverFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaRangoVolverFormImpl previousForm = (es.pode.administracion.presentacion.planificador.descripcionTarea.MostrarInformeFechaRangoVolverFormImpl)previousFormObject;
            specificForm.setAnioHasta(previousForm.getAnioHasta());
            specificForm.setAnio(previousForm.getAnio());
            specificForm.setMinutos(previousForm.getMinutos());
            specificForm.setTrigger(previousForm.getTrigger());
            specificForm.setGrupoTrigger(previousForm.getGrupoTrigger());
            specificForm.setGrupoTrabajo(previousForm.getGrupoTrabajo());
            specificForm.setTipoTarea(previousForm.getTipoTarea());
            specificForm.setInforme(previousForm.getInforme());
            specificForm.setDia(previousForm.getDia());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setDiaHasta(previousForm.getDiaHasta());
            specificForm.setAnioDesde(previousForm.getAnioDesde());
            specificForm.setHora(previousForm.getHora());
            specificForm.setMsgNoInforme(previousForm.getMsgNoInforme());
            specificForm.setMsgDescTrabajo(previousForm.getMsgDescTrabajo());
            specificForm.setMsgInforme(previousForm.getMsgInforme());
            specificForm.setMes(previousForm.getMes());
            specificForm.setPeriodicidad(previousForm.getPeriodicidad());
            specificForm.setMesHasta(previousForm.getMesHasta());
            specificForm.setRango(previousForm.getRango());
            specificForm.setDiaDesde(previousForm.getDiaDesde());
            specificForm.setMesDesde(previousForm.getMesDesde());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargar(mapping, form, request, response);
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
     * Obtención de los trabajos pendientes
     * </p>
     */
    private org.apache.struts.action.ActionForward _cargar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.listarTareasPendientes.TareasPendientesControllerFactory.getTareasPendientesControllerInstance().obtenerTareasPendientes(mapping, (ListarTareasPendientesFormImpl)form, request, response);
        forward = mapping.findForward("listar");


        return forward;
    }

}
