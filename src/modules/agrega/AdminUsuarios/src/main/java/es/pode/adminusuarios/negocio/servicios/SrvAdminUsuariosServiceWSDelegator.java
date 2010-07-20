// license-header java merge-point
package es.pode.adminusuarios.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService}.
 *
 * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService
 */
public class SrvAdminUsuariosServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService}
     */
    private final es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService getSrvAdminUsuariosService()
    {
        return es.pode.ServiceLocator.instance().getSrvAdminUsuariosService();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#modificarGrupo(es.pode.adminusuarios.negocio.servicios.GrupoVO)
     */
    public void modificarGrupo(es.pode.adminusuarios.negocio.servicios.GrupoVO grupo)
        throws es.pode.adminusuarios.negocio.servicios.ModificacionGrupoException
    {
        getSrvAdminUsuariosService().modificarGrupo(grupo);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#bajaGrupo(java.lang.Long[])
     */
    public es.pode.adminusuarios.negocio.servicios.ValidaBajaGrupoVO bajaGrupo(java.lang.Long[] ids)
        throws es.pode.adminusuarios.negocio.servicios.BajaGrupoException
    {
        return getSrvAdminUsuariosService().bajaGrupo(ids);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarGrupos()
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoVO[] listarGrupos()
    {
        return getSrvAdminUsuariosService().listarGrupos();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#descripcionGrupo(java.lang.Long)
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoVO descripcionGrupo(java.lang.Long id)
    {
        return getSrvAdminUsuariosService().descripcionGrupo(id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#nuevaClave(es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public java.lang.Boolean nuevaClave(es.pode.adminusuarios.negocio.servicios.UsuarioVO emailNIF)
        throws es.pode.adminusuarios.negocio.servicios.NuevaClaveException
    {
        return getSrvAdminUsuariosService().nuevaClave(emailNIF);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#modificarUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public java.lang.String modificarUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario)
        throws es.pode.adminusuarios.negocio.servicios.ModificarUsuarioException
    {
        return getSrvAdminUsuariosService().modificarUsuario(usuario);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarRoles()
     */
    public es.pode.adminusuarios.negocio.servicios.RolVO[] listarRoles()
    {
        return getSrvAdminUsuariosService().listarRoles();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#altaUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO, es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public java.lang.Long altaUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario, es.pode.adminusuarios.negocio.servicios.UsuarioVO adminVO)
        throws es.pode.adminusuarios.negocio.servicios.EnviarCorreoException, es.pode.adminusuarios.negocio.servicios.AltaUsuarioException
    {
        return getSrvAdminUsuariosService().altaUsuario(usuario, adminVO);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#bajaUsuario(java.lang.Long[], es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public es.pode.adminusuarios.negocio.servicios.ValidaBajaUsuarioVO bajaUsuario(java.lang.Long[] ids, es.pode.adminusuarios.negocio.servicios.UsuarioVO emailAdmin)
        throws es.pode.adminusuarios.negocio.servicios.BajaUsuarioException
    {
        return getSrvAdminUsuariosService().bajaUsuario(ids, emailAdmin);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarUsuarios()
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] listarUsuarios()
    {
        return getSrvAdminUsuariosService().listarUsuarios();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#descripcionUsuario(java.lang.Long)
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO descripcionUsuario(java.lang.Long id)
        throws es.pode.adminusuarios.negocio.servicios.DescripcionUsuarioException
    {
        return getSrvAdminUsuariosService().descripcionUsuario(id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarRolesUsuario(java.lang.String)
     */
    public java.lang.String[] listarRolesUsuario(java.lang.String usuario)
    {
        return getSrvAdminUsuariosService().listarRolesUsuario(usuario);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#altaGrupo(es.pode.adminusuarios.negocio.servicios.GrupoVO)
     */
    public java.lang.Long altaGrupo(es.pode.adminusuarios.negocio.servicios.GrupoVO grupoVO)
        throws es.pode.adminusuarios.negocio.servicios.AltaGrupoException
    {
        return getSrvAdminUsuariosService().altaGrupo(grupoVO);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#getRol(java.lang.Long)
     */
    public es.pode.adminusuarios.negocio.servicios.RolVO getRol(java.lang.Long id)
    {
        return getSrvAdminUsuariosService().getRol(id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#existeDescripcion(java.lang.String, java.lang.Long)
     */
    public java.lang.Boolean existeDescripcion(java.lang.String descripcion, java.lang.Long id)
    {
        return getSrvAdminUsuariosService().existeDescripcion(descripcion, id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerUsuario(java.lang.String)
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO obtenerUsuario(java.lang.String nif)
    {
        return getSrvAdminUsuariosService().obtenerUsuario(nif);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#existeUsuario(java.lang.String)
     */
    public java.lang.Boolean existeUsuario(java.lang.String usuario)
    {
        return getSrvAdminUsuariosService().existeUsuario(usuario);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#enviarCorreoBaja(es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public java.lang.String enviarCorreoBaja(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario)
        throws es.pode.adminusuarios.negocio.servicios.EnviarCorreoException
    {
        return getSrvAdminUsuariosService().enviarCorreoBaja(usuario);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerDatosUsuario(java.lang.String)
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO obtenerDatosUsuario(java.lang.String usuario)
    {
        return getSrvAdminUsuariosService().obtenerDatosUsuario(usuario);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerUsuariosAdministrador()
     */
    public java.lang.Long[] obtenerUsuariosAdministrador()
    {
        return getSrvAdminUsuariosService().obtenerUsuariosAdministrador();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerGrupoAdministrador()
     */
    public java.lang.Long[] obtenerGrupoAdministrador()
    {
        return getSrvAdminUsuariosService().obtenerGrupoAdministrador();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarUsuariosPendientes()
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] listarUsuariosPendientes()
    {
        return getSrvAdminUsuariosService().listarUsuariosPendientes();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#solicitarAltaUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public java.lang.String solicitarAltaUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario)
    {
        return getSrvAdminUsuariosService().solicitarAltaUsuario(usuario);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#bajaUsuarioPendiente(java.lang.Long[], es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public es.pode.adminusuarios.negocio.servicios.ValidaBajaUsuarioVO bajaUsuarioPendiente(java.lang.Long[] ids, es.pode.adminusuarios.negocio.servicios.UsuarioVO emailAdmin)
    {
        return getSrvAdminUsuariosService().bajaUsuarioPendiente(ids, emailAdmin);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#usuariosActivos(es.pode.adminusuarios.negocio.servicios.ParametroAuditoriaUsuariosVO)
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioActivoVO[] usuariosActivos(es.pode.adminusuarios.negocio.servicios.ParametroAuditoriaUsuariosVO parametroAuditoriaVO)
    {
        return getSrvAdminUsuariosService().usuariosActivos(parametroAuditoriaVO);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#getEmailAdmin()
     */
    public java.lang.String[] getEmailAdmin()
    {
        return getSrvAdminUsuariosService().getEmailAdmin();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarTodosUsuarios()
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] listarTodosUsuarios()
    {
        return getSrvAdminUsuariosService().listarTodosUsuarios();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarUsuariosInactivos()
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] listarUsuariosInactivos()
    {
        return getSrvAdminUsuariosService().listarUsuariosInactivos();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#activarUsuario(java.lang.Long, java.lang.String)
     */
    public void activarUsuario(java.lang.Long id, java.lang.String admin)
    {
        getSrvAdminUsuariosService().activarUsuario(id, admin);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#desactivarUsuario(java.lang.Long, java.lang.String)
     */
    public void desactivarUsuario(java.lang.Long id, java.lang.String admin)
    {
        getSrvAdminUsuariosService().desactivarUsuario(id, admin);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerListaUsuariosGrupoTrabajo(java.lang.String)
     */
    public java.lang.String[] obtenerListaUsuariosGrupoTrabajo(java.lang.String usuarioGrupoTrabajo)
    {
        return getSrvAdminUsuariosService().obtenerListaUsuariosGrupoTrabajo(usuarioGrupoTrabajo);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#listarGruposTrabajo()
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO[] listarGruposTrabajo()
    {
        return getSrvAdminUsuariosService().listarGruposTrabajo();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#descripcionGrupoTrabajo(java.lang.Long)
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO descripcionGrupoTrabajo(java.lang.Long identificador)
    {
        return getSrvAdminUsuariosService().descripcionGrupoTrabajo(identificador);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#bajaGrupoTrabajo(java.lang.Long[])
     */
    public es.pode.adminusuarios.negocio.servicios.ValidaBajaGrupoTrabajoVO bajaGrupoTrabajo(java.lang.Long[] ids)
    {
        return getSrvAdminUsuariosService().bajaGrupoTrabajo(ids);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#modificarGrupoTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO)
     */
    public java.lang.Long modificarGrupoTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO grupoTrabajo)
    {
        return getSrvAdminUsuariosService().modificarGrupoTrabajo(grupoTrabajo);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#getEmailPublicadores()
     */
    public java.lang.String[] getEmailPublicadores()
    {
        return getSrvAdminUsuariosService().getEmailPublicadores();
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerUsuariosGrupo(java.lang.Long)
     */
    public java.lang.Boolean obtenerUsuariosGrupo(java.lang.Long id)
    {
        return getSrvAdminUsuariosService().obtenerUsuariosGrupo(id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerUsuariosGrupoTrabajo(java.lang.Long)
     */
    public java.lang.Boolean obtenerUsuariosGrupoTrabajo(java.lang.Long id)
    {
        return getSrvAdminUsuariosService().obtenerUsuariosGrupoTrabajo(id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#existeNombreTrabajo(java.lang.String, java.lang.Long)
     */
    public java.lang.Boolean existeNombreTrabajo(java.lang.String nombre, java.lang.Long id)
    {
        return getSrvAdminUsuariosService().existeNombreTrabajo(nombre, id);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#altaGrupoTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO)
     */
    public java.lang.Long altaGrupoTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO grupoTrabajo)
    {
        return getSrvAdminUsuariosService().altaGrupoTrabajo(grupoTrabajo);
    }

    /**
     * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService#obtenerUsuarioConOpenId(java.lang.String)
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO obtenerUsuarioConOpenId(java.lang.String openIdUrl)
    {
        return getSrvAdminUsuariosService().obtenerUsuarioConOpenId(openIdUrl);
    }

}