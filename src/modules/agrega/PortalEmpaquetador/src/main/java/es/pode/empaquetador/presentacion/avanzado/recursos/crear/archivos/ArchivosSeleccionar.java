// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

/**
 * 
 */
public final class ArchivosSeleccionar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ArchivosSeleccionarFormImpl specificForm = (ArchivosSeleccionarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosControllerFactory.getCrearRecursoAvanzadoArchivosControllerInstance().submit(mapping, (ArchivosSeleccionarFormImpl)form, request, response);
        forward = __selectAction(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _sumarArchivos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosControllerFactory.getCrearRecursoAvanzadoArchivosControllerInstance().sumarArchivos(mapping, (ArchivosSeleccionarFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosControllerFactory.getCrearRecursoAvanzadoArchivosControllerInstance().cancelar(mapping, (ArchivosSeleccionarFormImpl)form, request, response);
        forward = mapping.findForward("crear.recurso.avanzado.elementos");


        return forward;
    }

    /**
     * <p>
     * Llama a gestion de archivos para recuperar los archivos
     * disponibles en disco (tanto la estructura del arbol como el
     * listado del directorio principal). Envia los datos al JSP para
     * su representación.
     * </p>
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosControllerFactory.getCrearRecursoAvanzadoArchivosControllerInstance().recuperarDatos(mapping, (ArchivosSeleccionarFormImpl)form, request, response);
        forward = mapping.findForward("archivos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosControllerFactory.getCrearRecursoAvanzadoArchivosControllerInstance().selectAction(mapping, (ArchivosSeleccionarFormImpl)form, request, response));

        if (value.equals("Cancelar"))
        {
            return mapping.findForward("crear.recurso.avanzado.elementos");
        }
        if (value.equals("Seleccionar"))
        {
            return _sumarArchivos(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _cancelar(mapping, form, request, response);
    }

}
