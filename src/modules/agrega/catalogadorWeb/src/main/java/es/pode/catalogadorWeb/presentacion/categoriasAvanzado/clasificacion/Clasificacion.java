// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;

/**
 * 
 */
public final class Clasificacion extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ClasificacionFormImpl specificForm = (ClasificacionFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarClasificacionFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarClasificacionFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarClasificacionFormImpl)previousFormObject;
            specificForm.setIdentificador(previousForm.getIdentificador());
            specificForm.setDatos(previousForm.getDatos());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionSubmitFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _clasificaciones(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _clasificaciones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __hayClasificaciones(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarClasificacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionControllerFactory.getClasificacionControllerInstance().cargarClasificacion(mapping, (ClasificacionFormImpl)form, request, response);
        forward = mapping.findForward("clasificacion.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayClasificaciones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionControllerFactory.getClasificacionControllerInstance().hayClasificaciones(mapping, (ClasificacionFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return _cargarClasificacion(mapping, form, request, response);
        }
        if (value.equals("false"))
        {
            return mapping.findForward("detalle.clasificacion");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("detalle.clasificacion");
    }

}
