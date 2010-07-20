// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo;

/**
 * 
 */
public final class UsoEducativo extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final UsoEducativoFormImpl specificForm = (UsoEducativoFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarUsoEducativoFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarUsoEducativoFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriasFormModificarUsoEducativoFormImpl)previousFormObject;
            specificForm.setIdentificador(previousForm.getIdentificador());
            specificForm.setDatos(previousForm.getDatos());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _usosEducativos(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _usosEducativos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __hayUsosEducativos(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargaUsoEducativo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoControllerFactory.getUsoeducativoControllerInstance().cargarUsosEducativos(mapping, (UsoEducativoFormImpl)form, request, response);
        forward = mapping.findForward("usos.educativos.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayUsosEducativos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoControllerFactory.getUsoeducativoControllerInstance().hayUsosEducativos(mapping, (UsoEducativoFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return _cargaUsoEducativo(mapping, form, request, response);
        }
        if (value.equals("false"))
        {
            return mapping.findForward("detalle.uso.edu");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("detalle.uso.edu");
    }

}
