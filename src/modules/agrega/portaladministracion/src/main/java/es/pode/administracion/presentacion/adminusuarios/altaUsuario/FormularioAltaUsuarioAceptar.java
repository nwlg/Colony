// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

/**
 * 
 */
public final class FormularioAltaUsuarioAceptar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final FormularioAltaUsuarioAceptarFormImpl specificForm = (FormularioAltaUsuarioAceptarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _altaUsuario(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _asignarGruposTrabajo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioControllerFactory.getAltaUsuarioControllerInstance().asignarGruposTrabajo(mapping, (FormularioAltaUsuarioAceptarFormImpl)form, request, response);
        forward = __altaUsuario(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarGruposTrabajo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioControllerFactory.getAltaUsuarioControllerInstance().recuperarGruposTrabajo(mapping, (FormularioAltaUsuarioAceptarFormImpl)form, request, response);
        forward = mapping.findForward("formulario.grupos.trabajo");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _comprobarRol(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioControllerFactory.getAltaUsuarioControllerInstance().rolParaGruposTrabajo(mapping, (FormularioAltaUsuarioAceptarFormImpl)form, request, response);
        forward = __rolParaGruposTrabajo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _vacia(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("listar.usuarios");
        return forward;
    }

    /**
     * <p>
     * Alta del usuario en el sistema
     * </p>
     */
    private org.apache.struts.action.ActionForward _altaUsuario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioControllerFactory.getAltaUsuarioControllerInstance().submit(mapping, (FormularioAltaUsuarioAceptarFormImpl)form, request, response);
        forward = _comprobarRol(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __rolParaGruposTrabajo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioControllerFactory.getAltaUsuarioControllerInstance().rolParaGruposTrabajo(mapping, (FormularioAltaUsuarioAceptarFormImpl)form, request, response));

        if (value.equals("OK"))
        {
            return _recuperarGruposTrabajo(mapping, form, request, response);
        }
        if (value.equals("FALLO"))
        {
            return _asignarGruposTrabajo(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _asignarGruposTrabajo(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __altaUsuario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioControllerFactory.getAltaUsuarioControllerInstance().altaUsuario(mapping, (FormularioAltaUsuarioAceptarFormImpl)form, request, response));

        if (value.equals("FALLO"))
        {
            return mapping.findForward("confirmacion.fallo.alta.usuario");
        }
        if (value.equals("OK"))
        {
            return _vacia(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _vacia(mapping, form, request, response);
    }

}
