// license-header java merge-point
package es.pode.administracion.presentacion.categorias.verCategoria;

/**
 * 
 */
public final class VerCategoria extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final VerCategoriaFormImpl specificForm = (VerCategoriaFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.categorias.categorias.CategoriasNoticiasVerCateFormImpl)
        {
            final es.pode.administracion.presentacion.categorias.categorias.CategoriasNoticiasVerCateFormImpl previousForm = (es.pode.administracion.presentacion.categorias.categorias.CategoriasNoticiasVerCateFormImpl)previousFormObject;
            specificForm.setIdCategoriaNoticia(previousForm.getIdCategoriaNoticia());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _obtieneCategoria(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _obtieneCategoria(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.categorias.verCategoria.ObtenerCategoriaControllerFactory.getObtenerCategoriaControllerInstance().obtieneCategoria(mapping, (VerCategoriaFormImpl)form, request, response);
        forward = mapping.findForward("ver");


        return forward;
    }

}
