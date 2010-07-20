// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor;

/**
 * 
 */
public final class GestorSubmanifiestos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GestorSubmanifiestosFormImpl specificForm = (GestorSubmanifiestosFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.SeleccionarDestinoAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.SeleccionarDestinoAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.SeleccionarDestinoAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.AdvertenciaAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.AdvertenciaAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.AdvertenciaAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.agregar.local.SubirArchivoAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.agregar.local.SubirArchivoAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.agregar.local.SubirArchivoAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.agregar.personales.ObjetosPersonalesAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.agregar.personales.ObjetosPersonalesAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.agregar.personales.ObjetosPersonalesAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenAceptarFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperarDatos(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosControllerFactory.getGestorSubmanifiestosControllerInstance().recuperarDatos(mapping, (GestorSubmanifiestosFormImpl)form, request, response);
        forward = mapping.findForward("gestor.submanifiestos");


        return forward;
    }

}
