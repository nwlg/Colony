// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion;

/**
 * 
 */
public final class DetalleClasificacion extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DetalleClasificacionFormImpl specificForm = (DetalleClasificacionFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiaAsociarFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiaAsociarFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiaAsociarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormDetalleClasificacionFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormDetalleClasificacionFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormDetalleClasificacionFormImpl)previousFormObject;
            specificForm.setBotonPulsado(previousForm.getBotonPulsado());
            specificForm.setTituloClasificacion(previousForm.getTituloClasificacion());
            specificForm.setIdentificadorOde(previousForm.getIdentificadorOde());
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.tesauros.RelacionesJerarquicasFormDatosRelacionFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.tesauros.RelacionesJerarquicasFormDatosRelacionFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.tesauros.RelacionesJerarquicasFormDatosRelacionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.tesauros.TesaurosFormAsociarTesauroFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.tesauros.TesaurosFormAsociarTesauroFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.tesauros.TesaurosFormAsociarTesauroFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargarDetalleClasificacion(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargarDetalleClasificacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionControllerFactory.getDetalleClasificacionControllerInstance().cargarDetalleClasificacion(mapping, (DetalleClasificacionFormImpl)form, request, response);
        forward = mapping.findForward("datos.aform");


        return forward;
    }

}
