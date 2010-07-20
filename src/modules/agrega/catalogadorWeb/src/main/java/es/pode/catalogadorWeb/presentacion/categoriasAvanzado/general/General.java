// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general;

/**
 * 
 */
public final class General extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GeneralFormImpl specificForm = (GeneralFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarGeneralFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarGeneralFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarGeneralFormImpl)previousFormObject;
            specificForm.setIdentificador(previousForm.getIdentificador());
            specificForm.setDatos(previousForm.getDatos());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargaGeneral(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargaGeneral(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralControllerFactory.getGeneralControllerInstance().cargarDatosGeneral(mapping, (GeneralFormImpl)form, request, response);
        forward = mapping.findForward("cargar");


        return forward;
    }

}
