// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.personales;

/**
 * 
 */
public final class ObjetosPersonalesAceptar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ObjetosPersonalesAceptarFormImpl specificForm = (ObjetosPersonalesAceptarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _agregar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesControllerFactory.getAgregarPersonalesControllerInstance().agregar(mapping, (ObjetosPersonalesAceptarFormImpl)form, request, response);
        forward = __tipoEmpaquetador(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesControllerFactory.getAgregarPersonalesControllerInstance().submit(mapping, (ObjetosPersonalesAceptarFormImpl)form, request, response);
        forward = __selectAction(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __tipoEmpaquetador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesControllerFactory.getAgregarPersonalesControllerInstance().tipoEmpaquetador(mapping, (ObjetosPersonalesAceptarFormImpl)form, request, response));

        if (value.equals("Avanzado"))
        {
            return mapping.findForward("gestor.submanifiestos");
        }
        if (value.equals("Basico"))
        {
            return mapping.findForward("gestor.basico");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.basico");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesControllerFactory.getAgregarPersonalesControllerInstance().selectAction(mapping, (ObjetosPersonalesAceptarFormImpl)form, request, response));

        if (value.equals("Cancelar"))
        {
            return mapping.findForward("agregar.submanifiesto");
        }
        if (value.equals("Aceptar"))
        {
            return _agregar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _agregar(mapping, form, request, response);
    }

}
