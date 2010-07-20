// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.verRepositoriosExternos;

/**
 * 
 */
public final class VerNodoSQI extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final VerNodoSQIFormImpl specificForm = (VerNodoSQIFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos.FormularioNodosSQIVerNodoSQIFormImpl)
        {
            final es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos.FormularioNodosSQIVerNodoSQIFormImpl previousForm = (es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos.FormularioNodosSQIVerNodoSQIFormImpl)previousFormObject;
            specificForm.setId(previousForm.getId());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargaNodoSQI(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargaNodoSQI(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.repositoriosExternos.verRepositoriosExternos.VerNodoSQIControllerFactory.getVerNodoSQIControllerInstance().cargaNodoSQI(mapping, (VerNodoSQIFormImpl)form, request, response);
        forward = mapping.findForward("detalle.nodo.sqi");


        return forward;
    }

}
