// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * 
 */
public final class FormularioReindexadoIContinuar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final FormularioReindexadoIContinuarFormImpl specificForm = (FormularioReindexadoIContinuarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _validarFormularioReindexado(mapping, form, request, response);
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
     * Se validan los datos introducidos en la primera pantalla de
     * reindexado
     * </p>
     */
    private org.apache.struts.action.ActionForward _validarFormularioReindexado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaControllerFactory.getObtenerTareaControllerInstance().validarFormularioReindexado(mapping, (FormularioReindexadoIContinuarFormImpl)form, request, response);
        forward = mapping.findForward("continuar");


        return forward;
    }

}
