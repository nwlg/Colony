// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuarios;

/**
 * 
 */
public final class ListarUsuarios extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ListarUsuariosFormImpl specificForm = (ListarUsuariosFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioAltaUsuarioAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioAltaUsuarioAceptarFormImpl previousForm = (es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioAltaUsuarioAceptarFormImpl)previousFormObject;
            specificForm.setIdModificado(previousForm.getIdModificado());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioGruposTrabajoAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioGruposTrabajoAceptarFormImpl previousForm = (es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioGruposTrabajoAceptarFormImpl)previousFormObject;
            specificForm.setIdModificado(previousForm.getIdModificado());
        }
        else
        if (previousFormObject instanceof es.pode.administracion.presentacion.adminusuarios.modificarUsuario.FormularioResultadoModificacionGrupoAceptarFormImpl)
        {
            final es.pode.administracion.presentacion.adminusuarios.modificarUsuario.FormularioResultadoModificacionGrupoAceptarFormImpl previousForm = (es.pode.administracion.presentacion.adminusuarios.modificarUsuario.FormularioResultadoModificacionGrupoAceptarFormImpl)previousFormObject;
            specificForm.setIdModificado(previousForm.getIdModificado());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperarUsuarios(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _recuperarUsuarios(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosControllerFactory.getListarUsuariosControllerInstance().obtenerUsuarios(mapping, (ListarUsuariosFormImpl)form, request, response);
        forward = mapping.findForward("formulario.listado.usuarios");


        return forward;
    }

}
