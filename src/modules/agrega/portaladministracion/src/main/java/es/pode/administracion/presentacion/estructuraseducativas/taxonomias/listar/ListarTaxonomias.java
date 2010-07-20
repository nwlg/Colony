// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar;

/**
 * 
 */
public final class ListarTaxonomias extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ListarTaxonomiasFormImpl specificForm = (ListarTaxonomiasFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.estructuraseducativas.taxonomias.alta.FormNuevaTaxonomiaSubmitFormImpl)
        {
            final es.pode.administracion.presentacion.estructuraseducativas.taxonomias.alta.FormNuevaTaxonomiaSubmitFormImpl previousForm = (es.pode.administracion.presentacion.estructuraseducativas.taxonomias.alta.FormNuevaTaxonomiaSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.estructuraseducativas.taxonomias.baja.ConfirmacionSubmitFormImpl)
        {
            final es.pode.administracion.presentacion.estructuraseducativas.taxonomias.baja.ConfirmacionSubmitFormImpl previousForm = (es.pode.administracion.presentacion.estructuraseducativas.taxonomias.baja.ConfirmacionSubmitFormImpl)previousFormObject;
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
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar.ListarTaxonomiasControllerFactory.getListarTaxonomiasControllerInstance().obtenerTaxonomias(mapping, (ListarTaxonomiasFormImpl)form, request, response);
        forward = mapping.findForward("form.listar.taxonomias");


        return forward;
    }

}
