// license-header java merge-point
package es.pode.administracion.presentacion.planificador.crearTarea;

/**
 * 
 */
public final class FormularioInicioCrearTarea extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final FormularioInicioCrearTareaFormImpl specificForm = (FormularioInicioCrearTareaFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __crearTarea(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _crearTareaInformeCatalogo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaControllerFactory.getCrearTareaControllerInstance().crearTareaInformeCatalogo(mapping, (FormularioInicioCrearTareaFormImpl)form, request, response);
        forward = mapping.findForward("listar.tareas.pendientes");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarIdioma(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaControllerFactory.getCrearTareaControllerInstance().cargarIdiomaReindexado(mapping, (FormularioInicioCrearTareaFormImpl)form, request, response);
        forward = mapping.findForward("formulario.reindexado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerUsuarios(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaControllerFactory.getCrearTareaControllerInstance().obtenerUsuarios(mapping, (FormularioInicioCrearTareaFormImpl)form, request, response);
        forward = mapping.findForward("formulario.informe.fechas.usuarios");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __crearTarea(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaControllerFactory.getCrearTareaControllerInstance().crearTarea(mapping, (FormularioInicioCrearTareaFormImpl)form, request, response));

        if (value.equals("CargaODEs"))
        {
            return mapping.findForward("formulario.tarea.carga.odes");
        }
        if (value.equals("Error"))
        {
            return mapping.findForward("formulario.inicio");
        }
        if (value.equals("EliminarNoDisponibles"))
        {
            return mapping.findForward("formulario.eliminar.no.disponibles");
        }
        if (value.equals("InformeFecha"))
        {
            return mapping.findForward("formulario.informe.fechas");
        }
        if (value.equals("InformeFechaRango"))
        {
            return mapping.findForward("formulario.informe.fechas.rango");
        }
        if (value.equals("InformeFechaUsuario"))
        {
            return _obtenerUsuarios(mapping, form, request, response);
        }
        if (value.equals("Reindexado"))
        {
            return _cargarIdioma(mapping, form, request, response);
        }
        if (value.equals("InformeFederado"))
        {
            return mapping.findForward("formulario.informe.federado");
        }
        if (value.equals("InformeCatalogo"))
        {
            return _crearTareaInformeCatalogo(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _crearTareaInformeCatalogo(mapping, form, request, response);
    }

}
