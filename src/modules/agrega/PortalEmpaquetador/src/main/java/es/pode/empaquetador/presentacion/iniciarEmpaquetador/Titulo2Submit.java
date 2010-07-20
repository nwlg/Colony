// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

/**
 * 
 */
public final class Titulo2Submit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final Titulo2SubmitFormImpl specificForm = (Titulo2SubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __selectActionEditar(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _crearLomesInicial(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorControllerFactory.getInicioEmpaquetadorControllerInstance().crearLomesInicial(mapping, (Titulo2SubmitFormImpl)form, request, response);
        forward = _crearSesion(mapping, form, request, response);


        return forward;
    }

    /**
     * <p>
     * Termina la sesion
     * </p>
     */
    private org.apache.struts.action.ActionForward _terminar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorControllerFactory.getInicioEmpaquetadorControllerInstance().redirect(mapping, (Titulo2SubmitFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _crearSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorControllerFactory.getInicioEmpaquetadorControllerInstance().crearSesion(mapping, (Titulo2SubmitFormImpl)form, request, response);
        forward = __esAvanzado(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectActionEditar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorControllerFactory.getInicioEmpaquetadorControllerInstance().selectActionEditar(mapping, (Titulo2SubmitFormImpl)form, request, response));

        if (value.equals("Aceptar"))
        {
            return _crearLomesInicial(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _terminar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _terminar(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esAvanzado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorControllerFactory.getInicioEmpaquetadorControllerInstance().esAvanzado(mapping, (Titulo2SubmitFormImpl)form, request, response));

        if (value.equals("Avanzado"))
        {
            return mapping.findForward("gestor.archivos");
        }
        if (value.equals("Basico"))
        {
            return mapping.findForward("gestor.basico");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.basico");
    }

}
