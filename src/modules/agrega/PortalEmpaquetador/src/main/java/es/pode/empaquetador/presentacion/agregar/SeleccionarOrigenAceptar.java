// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar;

/**
 * 
 */
public final class SeleccionarOrigenAceptar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SeleccionarOrigenAceptarFormImpl specificForm = (SeleccionarOrigenAceptarFormImpl)form;

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
    private org.apache.struts.action.ActionForward _repositorio(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("abrir.buscador");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __tipoEmpaquetador(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __seleccionarOrigen(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __tipoEmpaquetador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoControllerFactory.getAgregarSubmanifiestoControllerInstance().tipoEmpaquetador(mapping, (SeleccionarOrigenAceptarFormImpl)form, request, response));

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
    private org.apache.struts.action.ActionForward __seleccionarOrigen(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoControllerFactory.getAgregarSubmanifiestoControllerInstance().seleccionarOrigen(mapping, (SeleccionarOrigenAceptarFormImpl)form, request, response));

        if (value.equals("Local"))
        {
            return mapping.findForward("agregar.local");
        }
        if (value.equals("Personales"))
        {
            return mapping.findForward("agregar.personales");
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }
        if (value.equals("Repositorio"))
        {
            return _repositorio(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _repositorio(mapping, form, request, response);
    }

}
