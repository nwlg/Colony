// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

/**
 * 
 */
public final class GestorRecursos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GestorRecursosFormImpl specificForm = (GestorRecursosFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.importar.LocalAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.importar.LocalAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.importar.LocalAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.exportar.FormularioExportarSelectActionFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.exportar.FormularioExportarSelectActionFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.exportar.FormularioExportarSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.TipoRecursoContinuarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.TipoRecursoContinuarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.TipoRecursoContinuarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoCrearFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoCrearFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoCrearFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.AdvertenciaAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.AdvertenciaAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.AdvertenciaAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarRecursosFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarRecursosFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarRecursosFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargarDatos(mapping, form, request, response);
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
     * Recupera de la sesion los recursos disponibles.
     * </p>
     */
    private org.apache.struts.action.ActionForward _cargarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosControllerFactory.getGestorRecursosControllerInstance().cargarDatos(mapping, (GestorRecursosFormImpl)form, request, response);
        forward = mapping.findForward("gestor.recursos");


        return forward;
    }

}
