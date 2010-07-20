/* Agrega es una federaciÛn de repositorios de objetos digitales educativos formada por todas las Comunidades AutÛnomas propiedad de Red.es. Este cÛdigo ha sido desarrollado por la Entidad P˙blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a travÈs de la SecretarÌa de Estado de Telecomunicaciones y para la Sociedad de la InformaciÛn, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la InformaciÛn y de Convergencia con Europa y entre Comunidades AutÛnomas y Ciudades AutÛnomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 ìSociedad de la InformaciÛnî

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvAdminUsuariosService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.seguridad.servicios;

public interface SrvAdminUsuariosService extends java.rmi.Remote {

    /**

     */
    public void activarUsuario(java.lang.Long id, java.lang.String admin) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Long altaGrupo(es.pode.soporte.seguridad.servicios.GrupoVO grupoVO) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Long altaGrupoTrabajo(es.pode.soporte.seguridad.servicios.GrupoTrabajoVO grupoTrabajo) throws java.rmi.RemoteException;

    /**
     * Alta de un usuario
     */
    public java.lang.Long altaUsuario(es.pode.soporte.seguridad.servicios.UsuarioVO usuario, es.pode.soporte.seguridad.servicios.UsuarioVO adminVO) throws java.rmi.RemoteException;

    /**
     * Eliminaci√≥n de un grupo
     */
    public es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO bajaGrupo(java.lang.Long[] ids) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO bajaGrupoTrabajo(java.lang.Long[] ids) throws java.rmi.RemoteException;

    /**
     * Eliminaci√≥n de usuarios
     */
    public es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO bajaUsuario(java.lang.Long[] ids, es.pode.soporte.seguridad.servicios.UsuarioVO emailAdmin) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO bajaUsuarioPendiente(java.lang.Long[] ids, es.pode.soporte.seguridad.servicios.UsuarioVO emailAdmin) throws java.rmi.RemoteException;

    /**

     */
    public void desactivarUsuario(java.lang.Long id, java.lang.String admin) throws java.rmi.RemoteException;

    /**
     * Descripci√≥n de los datos de un grupo
     */
    public es.pode.soporte.seguridad.servicios.GrupoVO descripcionGrupo(java.lang.Long id) throws java.rmi.RemoteException;

    /**
     * Obtiene el grupo de trabajo cuyo identificador se pasa como
     * par√°metro
     */
    public es.pode.soporte.seguridad.servicios.GrupoTrabajoVO descripcionGrupoTrabajo(java.lang.Long identificador) throws java.rmi.RemoteException;

    /**
     * Los datos de un usuario
     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO descripcionUsuario(java.lang.Long id) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.String enviarCorreoBaja(es.pode.soporte.seguridad.servicios.UsuarioVO usuario) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Boolean existeDescripcion(java.lang.String descripcion, java.lang.Long id) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Boolean existeNombreTrabajo(java.lang.String nombre, java.lang.Long id) throws java.rmi.RemoteException;

    /**
     * Comprueba si existe en el sistema un usuario con ese usuario
     * (login)
     */
    public java.lang.Boolean existeUsuario(java.lang.String usuario) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.String[] getEmailAdmin() throws java.rmi.RemoteException;

    /**
     * Obtiene los correos de todos los publicadores de la plataforma
     */
    public java.lang.String[] getEmailPublicadores() throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.RolVO getRol(java.lang.Long id) throws java.rmi.RemoteException;

    /**
     * Listado de los grupos existentes
     */
    public es.pode.soporte.seguridad.servicios.GrupoVO[] listarGrupos() throws java.rmi.RemoteException;

    /**
     * Obtiene el listado de los grupos de trabajo que existen
     *                 actualmente en la plataforma. Adem√°s de los que est√©n
     * dados de
     *                 alta en la plataforma se devolver√° el grupo "Todos",
     * si el
     *                 usuario selecciona este grupo de trabajo se le asociar√°n
     * todos
     *                 los grupos.
     */
    public es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[] listarGruposTrabajo() throws java.rmi.RemoteException;

    /**
     * Listado de los roles existentes
     */
    public es.pode.soporte.seguridad.servicios.RolVO[] listarRoles() throws java.rmi.RemoteException;

    /**

     */
    public java.lang.String[] listarRolesUsuario(java.lang.String usuario) throws java.rmi.RemoteException;

    /**
     * Lista todos los usuarios del sistema (salvo los pendientes
     * de
     *                 dar de alta)
     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarTodosUsuarios() throws java.rmi.RemoteException;

    /**
     * Listado de todos los usuarios del nodo que ya han sido dados
     * de
     *                 alta por el administrador
     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarUsuarios() throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarUsuariosInactivos() throws java.rmi.RemoteException;

    /**
     * Listado de los usuarios del nodo que no han sido dados de alta
     * por el administrador
     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarUsuariosPendientes() throws java.rmi.RemoteException;

    /**
     * Modificaci√≥n de los datos de un grupo
     */
    public void modificarGrupo(es.pode.soporte.seguridad.servicios.GrupoVO grupo) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Long modificarGrupoTrabajo(es.pode.soporte.seguridad.servicios.GrupoTrabajoVO grupoTrabajo) throws java.rmi.RemoteException;

    /**
     * Datos nuevos del usuario. La propiedad id del objeto UsuarioVO
     * es el identificado del usuarioque va a ser modificado
     */
    public java.lang.String modificarUsuario(es.pode.soporte.seguridad.servicios.UsuarioVO usuario) throws java.rmi.RemoteException;

    /**
     * Los usuarios podr√°n solicitar una nueva clave y que est√° se
     * les
     *                 env√≠e por correo electr√≥nico a la cuenta que tienen
     * dada de alta
     *                 en el sistema. Para ello deber√°n introducir la direcci√≥n
     * de
     *                 correo electr√≥nico y el NIF
     */
    public java.lang.Boolean nuevaClave(es.pode.soporte.seguridad.servicios.UsuarioVO emailNIF) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO obtenerDatosUsuario(java.lang.String usuario) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Long[] obtenerGrupoAdministrador() throws java.rmi.RemoteException;

    /**
     * Obtiene la lista de usuarios que pertenecen al mismo grupo
     * de
     *                 trabajo que el usuario que se pasa como par√°metro
     */
    public java.lang.String[] obtenerListaUsuariosGrupoTrabajo(java.lang.String usuarioGrupoTrabajo) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO obtenerUsuario(java.lang.String nif) throws java.rmi.RemoteException;

    /**
     * Metodo para obtener el usuario que pertenezca ese openId
     */
    public es.pode.soporte.seguridad.servicios.UsuarioVO obtenerUsuarioConOpenId(java.lang.String openIdUrl) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Long[] obtenerUsuariosAdministrador() throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Boolean obtenerUsuariosGrupo(java.lang.Long id) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Boolean obtenerUsuariosGrupoTrabajo(java.lang.Long id) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.String solicitarAltaUsuario(es.pode.soporte.seguridad.servicios.UsuarioVO usuario) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.seguridad.servicios.UsuarioActivoVO[] usuariosActivos(es.pode.soporte.seguridad.servicios.ParametroAuditoriaUsuariosVO parametroAuditoriaVO) throws java.rmi.RemoteException;
}
