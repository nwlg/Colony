/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/

package es.pode.adminusuarios.negocio.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import sun.misc.BASE64Encoder;
import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.agrega.soporte.serverProperties.DependentServerPropertiesItf;
import es.pode.adminusuarios.negocio.comun.LDAPContactDAO;
import es.pode.adminusuarios.negocio.comun.MailSender;
import es.pode.adminusuarios.negocio.comun.MailSenderThread;
import es.pode.adminusuarios.negocio.dominio.Grupo;
import es.pode.adminusuarios.negocio.dominio.GrupoDao;
import es.pode.adminusuarios.negocio.dominio.GrupoTrabajo;
import es.pode.adminusuarios.negocio.dominio.GrupoTrabajoDao;
import es.pode.adminusuarios.negocio.dominio.Rol;
import es.pode.adminusuarios.negocio.dominio.RolDao;
import es.pode.adminusuarios.negocio.dominio.Usuario;
import es.pode.adminusuarios.negocio.dominio.UsuarioDao;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;

/**
 * @see es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService
 */

public class SrvAdminUsuariosServiceImpl extends es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosServiceBase
{

	private static Logger log = Logger.getLogger(SrvAdminUsuariosServiceImpl.class);
	private static final String AUTO_NIF_PREFIX = "A";

	private java.util.Properties pAdminUsuariosProperties = null;
	private java.util.Properties pAgregaProperties = null;

	/**
	 * Modifica los datos de un grupo
	 * @param GrupoVO grupo que se quiere modificar
	 * @throws Exception
	 */
	protected void handleModificarGrupo(es.pode.adminusuarios.negocio.servicios.GrupoVO grupo) throws java.lang.Exception
	{

		try
		{

			Long id = grupo.getId();
			Grupo grupoEntity = this.getGrupoDao().load(id);
			this.getGrupoDao().fromGrupoVO(grupo, grupoEntity);
			this.getGrupoDao().update(grupoEntity);

		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion " + e);
			ModificacionGrupoException exception = new ModificacionGrupoException("No se ha podido modificar el grupo", e);
			throw exception;
		}
	}

	/**
	 * Elimina de BD un conjunto de grupos
	 * 
	 * @param ids array con los identificadores de los grupos que se
	 * quieren eliminar
	 * @return ValidaBajaVO VO que contiene el numero de grupos que se han
	 * eliminado y una descripcion de la operacion
	 * @throws Exception
	 */
	protected ValidaBajaGrupoVO handleBajaGrupo(java.lang.Long[] ids) throws java.lang.Exception
	{

		ValidaBajaGrupoVO validaBajaVO = new ValidaBajaGrupoVO();
		int grupoDeleted = 0;
		List itemsDeleted = new ArrayList();
		
		try
		{
			grupoDeleted = 0;
			for (int j = 0; j < ids.length; j++)
			{
				Long identificador = ids[j];
				if (!(this.obtenerUsuariosGrupo(identificador)).booleanValue())
				{
					Grupo grupo = (this.getGrupoDao()).load(identificador);
					Grupo grupoAux = grupo;
					this.getGrupoDao().remove(grupo);
					grupoDeleted = grupoDeleted + 1;
					itemsDeleted.add((this.getGrupoDao()).toGrupoVO(grupoAux));
				}
			}
			if(log.isDebugEnabled())log.debug("despues de borrar todos los grupos");
			validaBajaVO.setItemsDeleted((GrupoVO[]) itemsDeleted.toArray(new GrupoVO[0]));
			if(log.isDebugEnabled())log.debug("despues de validaBajaVO.setItemsDeleted");
			if (grupoDeleted == ids.length)
			{
				validaBajaVO.setDescripcion("ok.borrarGrupo");
			} else
			{
				validaBajaVO.setDescripcion("errors.borrarGrupo.algunosGrupos");
			}

		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion " + e);
			BajaGrupoException exception = new BajaGrupoException("Error al eliminar el grupo ", e);

			validaBajaVO.setDescripcion("errors.borrarGrupo");
			throw exception;
		}

		// }

		return validaBajaVO;
	}

	/**
	 * Obtiene una lista con todos los grupos registrados en BD
	 * @return GrupoVO[] array de gruposVO
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.GrupoVO[] handleListarGrupos() throws java.lang.Exception
	{
		GrupoVO[] grupoV = null;

		try
		{
			// Collection grupos =
			// this.getGrupoDao().loadAll(GrupoDao.TRANSFORM_GRUPOVO);
			Collection grupos = this.getGrupoDao().getUsuarios();
			this.getGrupoDao().toGrupoVOCollection(grupos);
			if(log.isDebugEnabled())log.debug("los grupos obtenidos son " + grupos.size());
			grupoV = (GrupoVO[]) grupos.toArray(new GrupoVO[0]);

		} catch (Exception e)
		{
			log.error("Error: " + e);
			throw e;
		}
		return grupoV;
	}

	/**
	 * Obtiene un GrupoVO a partir de un identificador
	 * @param id
	 * @return GrupoVO
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.GrupoVO handleDescripcionGrupo(java.lang.Long id) throws java.lang.Exception
	{
		GrupoVO grupoVO = null;
		grupoVO = (GrupoVO) this.getGrupoDao().load(GrupoDao.TRANSFORM_GRUPOVO, id);
		return grupoVO;
	}

	/**
	 * Genera una nueva clave y se la envía por correo al usuario junto con
	 * su usuario (login). Puesto que la actualizacion de la clave se hace
	 * automáticamente (sin intermediación de un administrador) el from del
	 * correo que se enviará será del primer administrador registrado en el
	 * sistema, o también se podría poner una cuenta genérica
	 * @param emailNIF UsuarioVO
	 * @return resultado si ha ido bien(true) o mal(false)
	 * @throws Exception
	 */
	protected java.lang.Boolean handleNuevaClave(es.pode.adminusuarios.negocio.servicios.UsuarioVO emailNIF) throws java.lang.Exception
	{
		Boolean resultado = Boolean.FALSE;
		String nuevaClave = null;
		String claveOld = emailNIF.getClave();
		try
		{

			nuevaClave = this.getPassword();
			// /emailNIF.setClave(nuevaClave); La clave no se almacena en BD
			Long id = emailNIF.getId();
			Usuario usuarioEntity = this.getUsuarioDao().load(id);
			this.getUsuarioDao().fromUsuarioVO(emailNIF, usuarioEntity);
			usuarioEntity.setClaveEncriptada(EncriptacionUtiles.encriptar(nuevaClave));
			this.getUsuarioDao().update(usuarioEntity);

			// Actualizamos la entrada de ldap, se modificará unicamente el
			// password
			if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
			{
				this.getLdapHandler().modifyUser(emailNIF.getUsuario(), this.getHashPassword(nuevaClave), emailNIF.getNombre() + " " + emailNIF.getApellido1() + " " + emailNIF.getApellido2());
				if(log.isDebugEnabled())log.debug("Actualizamos la entrada de ldap");
			}

			
			StringBuffer contenido = new StringBuffer();
			contenido.append("<html>");			
			contenido.append(getResource("correo.nuevaClave.hola"));
			contenido.append("<br>");
			contenido.append(getResource("correo.nuevaClave1"));
			contenido.append("<br>");
			contenido.append("<br>");
			contenido.append(getResource("correo.nuevaClave1.1"));
			contenido.append(" ");
			contenido.append("<br>");
			contenido.append("<b>" + getResource("correo.nuevaClave2") + ":" + "</b>");
			contenido.append(emailNIF.getUsuario());
			contenido.append("<br>");
			contenido.append("<b>" + getResource("correo.nuevaClave3") + ":" + "</b>");
			contenido.append(" ");
			contenido.append(nuevaClave);
			contenido.append("<br>");
			contenido.append("<br>");
			contenido.append("<br>");
			contenido.append(getResource("correo.nuevaClave4"));
			contenido.append("<br>");
			contenido.append(getResource("correo.nuevaClave5"));
			contenido.append("<br>");
			contenido.append("<br>");
			contenido.append("<br>");
			contenido.append(getResource("correo.nuevaClave6"));
			contenido.append("</br>");
			if(!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
			{
				contenido.append("</html>");
			}

			// Se comprueba si el sistema tiene un ldap externo para
			// validacion
			if (this.getPropertyValue("ldapExternal").equalsIgnoreCase("true"))
			{
				if(log.isDebugEnabled())log.debug("El sistema dispone de un ldap externo de autenticacion");
				contenido.append("</br>");
				contenido.append(getResource("correo.nuevaClave.ldapExterno"));
				contenido.append("</html>");
				// Se enviara un correo al administrador del ldap externo para
				// que modifique la clave del usuario
				StringBuffer contenidoEmailAdmin = new StringBuffer();
				contenidoEmailAdmin.append("<html>");	
				contenidoEmailAdmin.append(getResource("correo.nuevaClave1.ldapExterno"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<b>" + getResource("correo.nuevaClave2") + ":" + "</b>");
				contenidoEmailAdmin.append(emailNIF.getUsuario());
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<b>" + getResource("correo.nuevaClave3") + ":" + "</b>");
				contenidoEmailAdmin.append(" ");
				contenidoEmailAdmin.append(nuevaClave);
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<b>" + getResource("correo.nuevaClave.ldapExterno.emailUsuario") + ":" + "</b>");
				contenidoEmailAdmin.append(emailNIF.getEmail());
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.nuevaClave4"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.nuevaClave5"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.nuevaClave6"));
				contenidoEmailAdmin.append("</br>");
				contenidoEmailAdmin.append("</html>");

				
				this.enviarCorreoThread(this.getPropertyValue("adminLdapExternal"), getResource("correo.nuevaClave.ldapExterno.asunto"), contenidoEmailAdmin, this.getPropertyValue("fromSender"));

			}
			// Habra que obtener el correo del administrador que esta
			// gestionando la nueva clave para que sea
			// el from del correo en vez de null
			
			this.enviarCorreoThread(emailNIF.getEmail(), getResource("correo.nuevaClave.asunto"), contenido, null);
			resultado = Boolean.TRUE;

		} catch (org.springframework.ldap.UncategorizedLdapException exception)
		{
			log.error("Se produce un error en ldap al actualizar la clave del usuario: UncategorizedLdapException ");

			emailNIF.setClave(claveOld);
			this.modificarUserTransaccion(emailNIF);

			if(log.isDebugEnabled())log.debug("Rollback en la BD al fallar la insercion en ldap");
			resultado = Boolean.FALSE;

		} catch (org.springframework.ldap.EntryNotFoundException entryNotFound)
		{
			log.error("Se produce un error en ldap al actualizar la clave del usuario :EntryNotFoundException ");

			emailNIF.setClave(claveOld);
			this.modificarUserTransaccion(emailNIF);

			if(log.isDebugEnabled())log.debug("Rollback en la BD al fallar la insercion en ldap");
			resultado = Boolean.FALSE;
		} catch (org.springframework.dao.DataRetrievalFailureException comunicationException)
		{
			log.error("Se produce un error en ldap al actualizar la clave del usuario : DataRetrievalFailureException ");

			emailNIF.setClave(claveOld);
			this.modificarUserTransaccion(emailNIF);
			if(log.isDebugEnabled())log.debug("Rollback en la BD al fallar la insercion en ldap");
			resultado = Boolean.FALSE;
		} catch (Exception e)
		{
			log.error("Exception al generar una nueva clave ", e);
			resultado = Boolean.FALSE;
		}
		return resultado;
	}

	/**
	 * Modifica en BD y en Ldap los datos del usuario
	 * @param UsuarioVO
	 * UsuarioVO que contiene los datos modificados del usuario
	 * @return resultado indica si la modificacion ha ido bien o no
	 * @throws Exception
	 */
	protected String handleModificarUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario) throws java.lang.Exception
	{

		
		Usuario usuarioOld = this.getUsuarioDao().load(usuario.getId());
		UsuarioVO usuarioVoOld = new UsuarioVO();
		usuarioVoOld.setApellido1(usuarioOld.getApellido1());
		usuarioVoOld.setApellido2(usuarioOld.getApellido2());
		usuarioVoOld.setNombre(usuarioOld.getNombre());
		usuarioVoOld.setEmail(usuarioOld.getEmail());
		usuarioVoOld.setIdioma(usuarioOld.getIdioma());
		usuarioVoOld.setIdiomaBusqueda(usuarioOld.getIdiomaBusqueda());
		usuarioVoOld.setNIF(usuarioOld.getNIF());
		usuarioVoOld.setTipoEmpaquetador(usuarioOld.getTipoEmpaquetador());
		usuarioVoOld.setUsuario(usuarioOld.getUsuario());
		usuarioVoOld.setFechaAlta(usuarioOld.getFechaAlta());
		usuarioVoOld.setFechaBaja(usuarioOld.getFechaBaja());
		usuarioVoOld.setId(usuarioOld.getId());

		if (usuarioOld.getGrupos() == null)
		{
			usuarioVoOld.setGrupos(null);
		} else
		{
			Collection grupos = usuarioOld.getGrupos();
			GrupoVO[] gruposVoOld = new GrupoVO[grupos.size()];
			Iterator iter = usuarioOld.getGrupos().iterator();
			int i = 0;
			while (iter.hasNext())
			{

				Grupo g = (Grupo) (iter.next());
				gruposVoOld[i] = this.getGrupoDao().toGrupoVO(g);
				i++;
			}
			usuarioVoOld.setGrupos(gruposVoOld);
		}

		String resultado = "";
		try
		{

			Usuario usuarioEntity = this.getUsuarioDao().load(usuario.getId());
			boolean emailLdapExt = (!(usuario.getClave() == null) && (!(usuario.getClave().equalsIgnoreCase(""))));
			String claveNueva = usuario.getClave();
			usuario.setClave(null);
			this.getUsuarioDao().fromUsuarioVO(usuario, usuarioEntity);
//			if (!(claveNueva == null) && !(claveNueva.equalsIgnoreCase("")))
//			{
//				//No se modifica la clave encriptada
//				String claveEncriptada = EncriptacionUtiles.encriptar(claveNueva);
//				usuarioEntity.setClaveEncriptada(claveEncriptada);
//			}
			this.getUsuarioDao().update(usuarioEntity);
			if(log.isDebugEnabled())log.debug("modificamos la entrada en el servidor ldap");
			
			if ((claveNueva == null) || (claveNueva.equalsIgnoreCase("")))
			{
				if(log.isDebugEnabled())log.debug("No se modifica la clave en ldap");

			} else
			{
				if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
				{
					if(log.isDebugEnabled())log.debug("Se modifica la entrada de ldap");
					this.getLdapHandler().modifyUser(usuario.getUsuario(), this.getHashPassword(claveNueva), usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2());
				}
			}

			if ((this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")) && (emailLdapExt))
			{
				if(log.isDebugEnabled())log.debug("El sistema cuenta con un servidor ldap externo de autenticacion");
				StringBuffer contenidoEmailAdmin = new StringBuffer();
				contenidoEmailAdmin.append("<html>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuarioHola"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.modificacionUsuario1.ldapExterno"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<b>" + getResource("correo.modificacionUsuario2.ldapExterno") + ":" + "</b>" + " ");
				contenidoEmailAdmin.append(usuario.getUsuario());
				contenidoEmailAdmin.append("<br>");
				if (!((claveNueva == null) || (claveNueva.equalsIgnoreCase(""))))
				{
					
					contenidoEmailAdmin.append("<b>" + getResource("correo.modificacionUsuario3.ldapExterno") + ":" + "</b>" + " ");
					contenidoEmailAdmin.append(claveNueva);
					contenidoEmailAdmin.append("<br>");
				}
				contenidoEmailAdmin.append("<b>" + getResource("correo.modificacionUsuario4.ldapExterno") + "</b>" + " ");
				contenidoEmailAdmin.append(usuario.getEmail());
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuario4"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuario5"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuario6"));
				contenidoEmailAdmin.append("</br>");
				contenidoEmailAdmin.append("</html>");
							
				this.enviarCorreoThread(this.getPropertyValue("adminLdapExternal"), getResource("correo.modificacionUsuario.asunto.ldapExterno"), contenidoEmailAdmin, this.getPropertyValue("fromSender"));
				
			}

			resultado = "OK.MODIFICARUSUARIO";
		} catch (org.springframework.dao.DataRetrievalFailureException comunicationException)
		{
			log.error("Se produce una excepcion en ldap damos marcha atras : DataRetrievalFailureException");

			this.modificarUserTransaccion(usuarioVoOld);
			resultado = "FALLO.MODIFICARUSUARIO";
		} catch (org.springframework.ldap.UncategorizedLdapException exception)
		{
			log.error("Se produce una excepcion en ldap damos marcha atras : UncategorizedLdapException");
			this.modificarUserTransaccion(usuarioVoOld);
			resultado = "FALLO.MODIFICARUSUARIO";

		} catch (Exception e)
		{

			log.error("Se ha producido la siguiente excepcion " + e);
			resultado = "FALLO.MODIFICARUSUARIO";
		}

		return resultado;
	}

	/**
	 * Obtiene todos los roles registrados en el sistema
	 * 
	 * @return RolVO[] array de RolVO
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.RolVO[] handleListarRoles() throws java.lang.Exception
	{
		RolVO[] rolV = null;

		try
		{
			
			Collection roles = this.getRolDao().getRoles();
			this.getRolDao().toRolVOCollection(roles);
			log.debug("los roles obtenidos son " + roles.size());
			rolV = (RolVO[]) roles.toArray(new RolVO[0]);

		} catch (Exception e)
		{
			log.error("Error: ", e);
			throw e;
		}

		return rolV;
	}

	/**
	 * Metodo para dar de alta un usuario. Se le agregará en el servidor
	 * ldap y se enviará un correo con el usuario y la clave
	 * @param usuario usuarioVO con los datos del usuario que se dara de alta
	 * @param admin usuarioVO con los datos del administrador
	 * @return resultado String que devuelve si el alta ha ido bien o no
	 * @throws Exception
	 */
	protected Long handleAltaUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario, es.pode.adminusuarios.negocio.servicios.UsuarioVO admin) throws java.lang.Exception
	{

		Usuario usuarioCreado = null;
		Long resultado = null;
		// En BD no se va a almacenar la clave del usuario unicamente en ldap
		String clave = usuario.getClave();
		usuario.setClave("");
		// No se almacena en BBDD la clave encriptada
//		usuario.setClaveEncriptada(EncriptacionUtiles.encriptar(clave));
		String login = usuario.getUsuario();
		usuario.setUsuario(login.toLowerCase());
		if(log.isDebugEnabled())log.debug("Se transaforma el login a minúsculas");
			
		
		try
		{

			if (usuario.getNIF() == null || usuario.getNIF().trim().length() == 0)
			{
				usuario.setNIF("");
				// Create the User Entity
			    Usuario usuarioEntity = this.getUsuarioDao().fromUsuarioVO(usuario);
			    usuarioCreado = this.getUsuarioDao().create(usuarioEntity);

				// Set the NIF value for the new user based on the ID (Surrogate key)
				// prepended with the NIF Prefix.
			    usuarioCreado.setNIF(AUTO_NIF_PREFIX + usuarioCreado.getId());
			    this.getUsuarioDao().update(usuarioCreado);

				// Create the User in the LDAP directory
			    if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
			    {
			    	this.getLdapHandler().insertUser(usuarioCreado.getUsuario(),
							this.getHashPassword(clave), usuarioCreado.getNombre() + " " +
							usuarioCreado.getApellido1() + " " + usuarioCreado.getApellido2());
			    }
			    if (log.isDebugEnabled()) log.debug("insertamos en ldap el usuario");
			}
			else if (this.obtenerUsuario(usuario.getNIF()) == null)
			{
				Usuario usuarioEntity = this.getUsuarioDao().fromUsuarioVO(usuario);
			    usuarioCreado = this.getUsuarioDao().create(usuarioEntity);
				if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
				{
					this.getLdapHandler().insertUser(usuarioCreado.getUsuario(), this.getHashPassword(clave), usuarioCreado.getNombre() + " " + usuarioCreado.getApellido1() + " " + usuarioCreado.getApellido2());
				}
				if(log.isDebugEnabled())log.debug("insertamos en ldap el usuario");

			} else
			{
				if(log.isDebugEnabled())log.debug("Modificamos un usuario ya registrado en el sistema");
				Usuario usuarioEntity = this.getUsuarioDao().load(usuario.getId());
				this.getUsuarioDao().fromUsuarioVO(usuario, usuarioEntity);
				this.getUsuarioDao().update(usuarioEntity);
				if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
				{
					this.getLdapHandler().insertUser(usuario.getUsuario(), this.getHashPassword(clave), usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2());
				}else
				{
					if(log.isDebugEnabled())log.debug("NO INSERTAMOS EN LDAP SOLO EN BD");
				}
				if(log.isDebugEnabled())log.debug("Modificamos el usuario en el servidor ldap");
			}
			String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
			int l=1;
			if(!(idiomaSecundario==null) && !idiomaSecundario.equals(""))
				l++;
			StringBuffer contenido = new StringBuffer();
			
			for(int j=0;j<l;j++){
				String idioma="";
				if(j==0){
					idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				}else{
					idioma=idiomaSecundario;
				}
				
				contenido.append("<html>");			
				contenido.append(getResource("correo.altaUsuarioHola",idioma));
				contenido.append("<br>");
				contenido.append(getResource("correo.altaUsuario1",idioma));
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append(getResource("correo.altaUsuario1.1",idioma));
				contenido.append("<br>");
				contenido.append(getResource("correo.altaUsuario2",idioma)+" : ");
				contenido.append(usuario.getUsuario());
				contenido.append("<br>");
				contenido.append(getResource("correo.altaUsuario3",idioma)+" : ");
				contenido.append(clave);
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append(getResource("correo.altaUsuario4",idioma));
				contenido.append("<br>");
				contenido.append(getResource("correo.altaUsuario5",idioma));
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append("<br>");
				if(l>1){
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
				}
			}
			if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
			{
				contenido.append("</html>");
			}

			//Comprobamos si el sistema tiene un ldap externo, en este
			// caso se mandara un email al administrador del ldap
			if (this.getPropertyValue("ldapExternal").equalsIgnoreCase("true"))
			{
				if(log.isDebugEnabled())log.debug("Alta en un servidor ldap externo");
				if(log.isDebugEnabled())log.debug("correo.altaUsuario.ldapExterno "+getResource("correo.altaUsuario.ldapExterno"));
				contenido.append(getResource("correo.altaUsuario.ldapExterno"));
				contenido.append("</html>");
				// Se enviara un correo al administrador del ldap externo para
				// que de de alta al usuario en ldap
				StringBuffer contenidoEmailAdmin = new StringBuffer();
				contenidoEmailAdmin.append("<html>");				
				contenidoEmailAdmin.append(getResource("correo.altaUsuario.ldapExterno1"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<b>" + getResource("correo.altaUsuario2") + ":" + "</b>" + " ");
				contenidoEmailAdmin.append(usuario.getUsuario());
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<b>" + getResource("correo.altaUsuario3") + ":" + "</b>" + " ");
				contenidoEmailAdmin.append(clave);
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuario4"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuario5"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.altaUsuario6"));
				contenidoEmailAdmin.append("</br>");
				contenidoEmailAdmin.append("</html>");

				this.enviarCorreoThread(this.getPropertyValue("adminLdapExternal"), getResource("correo.altaUsuario.asunto"), contenidoEmailAdmin, this.getPropertyValue("fromSender"));
				

			}
			
			this.enviarCorreoThread(usuario.getEmail(), getResource("correo.altaUsuario.asunto"),contenido, this.getPropertyValue("fromSender"));
	
			resultado = usuarioCreado.getId();
		} catch (org.springframework.dao.DataRetrievalFailureException comunicationException)
		{

			log.error("Problema en ldap : DataRetrievalFailureException");

			UsuarioVO usuarioCreated = this.obtenerDatosUsuario(usuario.getUsuario());
			this.eliminarUserTransaccion(usuarioCreated);

		} catch (org.springframework.ldap.UncategorizedLdapException exception)
		{


			log.error("Problema en ldap : org.springframework.ldap.UncategorizedLdapException");

			UsuarioVO usuarioCreated = this.obtenerDatosUsuario(usuario.getUsuario());
			this.eliminarUserTransaccion(usuarioCreated);
		} catch (org.springframework.dao.DataIntegrityViolationException dataIntegrityViolation)
		{

			log.error("Problema en ldap +org.springframework.dao.DataIntegrityViolationException ");

			UsuarioVO usuarioCreated = this.obtenerDatosUsuario(usuario.getUsuario());
			this.eliminarUserTransaccion(usuarioCreated);

		} catch (Exception e)
		{
			log.error("Error al dar de alta al usuario ", e);
		}

		return resultado;
	}

	/**
	 * Elimina de BD (actualiza la fecha de baja con la actual) y lo elimina
	 * del servidor ldap
	 * @param ids array de id de los usuarios que deben darse de baja
	 * @param emailAdmin usuarioVO del administrador que hace el proceso
	 * @return ValidaBajaVO incluye el numero de usuarios que han sido
	 *         eliminados y una descripcion con el resultado de la operacion
	 * @throws Exception
	 */
	
	protected ValidaBajaUsuarioVO handleBajaUsuario(java.lang.Long[] ids, UsuarioVO emailAdmin) throws java.lang.Exception
	{
		ValidaBajaUsuarioVO validaBajaVO = new ValidaBajaUsuarioVO();

		int usuarioDeleted = 0;
		Usuario usuario = null;
		Collection grupos = null;
		List itemsDeleted = new ArrayList();

		try
		{
			
			usuarioDeleted = 0;
			for (int j = 0; j < ids.length; j++)
			{
				Long identificador = ids[j];
				usuario = (this.getUsuarioDao()).load(identificador);
				grupos = usuario.getGrupos();
				usuario.setFechaBaja(new Date(System.currentTimeMillis()));
				usuario.setGrupos(null);
				////Elimino los grupos de trabajo que tiene asociados
				usuario.setGrupoTrabajo(null);
				///////////////////////
				this.getUsuarioDao().update(usuario);
				if(log.isDebugEnabled())log.debug("Se actualiza la fecha de baja del usuario");
				if (!(this.getPropertyValue("ldapExternal").equalsIgnoreCase("true")))
				{
					this.getLdapHandler().deleteContact(usuario.getUsuario());
				}
				log.info("[BAJAUSUARIO] El usuario " + usuario.getUsuario()+ "ha sido dado de baja por el administrador: " + emailAdmin.getUsuario());
				usuarioDeleted = usuarioDeleted + 1;
				itemsDeleted.add((this.getUsuarioDao()).toUsuarioVO(usuario));
				StringBuffer contenido = new StringBuffer();
				String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
				int l=1;
				if(!(idiomaSecundario==null) && !idiomaSecundario.equals(""))
					l++;
				for(int m=0;m<l;m++){
					String idioma="";
					if(m==0){
						idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
					}else{
						idioma=idiomaSecundario;
					}
					contenido.append("<html>");				
					contenido.append(getResource("correo.bajaUsuario.hola",idioma));
					contenido.append("<br>");
					contenido.append(getResource("correo.bajaUsuario.contenido1",idioma));
					contenido.append(" " + "<b>" + usuario.getUsuario() + "</b>" + ".");
					contenido.append("<br>");
					contenido.append("<br>");
					contenido.append("<br>");
					contenido.append(getResource("correo.bajaUsuario.contenido2",idioma));
					contenido.append("<br>");
					contenido.append(getResource("correo.bajaUsuario.contenido3",idioma));
					contenido.append("<br>");
					contenido.append("<br>");
					contenido.append("<br>");
					contenido.append(getResource("correo.bajaUsuario.contenido4",idioma));
					contenido.append("</br>");
					if(l>1){
						contenido.append("<br/>"); 
						contenido.append("<br/>"); 
						contenido.append("<br/>"); 
						contenido.append("<br/>"); 
					}
				}
				contenido.append("</html>");
				this.enviarCorreoThread(usuario.getEmail(), getResource("correo.bajaUsuario.asunto"), contenido, this.getPropertyValue("fromSender"));
			}
			validaBajaVO.setNumDeleted(new Integer(usuarioDeleted));
			validaBajaVO.setDescripcion("ok.borrarUsuarios");
			validaBajaVO.setItemsDeleted((UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]));
			// Enviamos un correo al administrador del ldap externo con
			// todos los usuarios que han sido realmente eliminados

			if (this.getPropertyValue("ldapExternal").equalsIgnoreCase("true"))
			{
				if(log.isDebugEnabled())log.debug("Enviamos un correo al administrador del ldap externo");
				UsuarioVO[] arrayUsuario = (UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]);
			
				StringBuffer contenidoEmailAdmin = new StringBuffer("<html>");
				contenidoEmailAdmin.append(getResource("correo.bajaUsuario1"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				for (int i = 0; i < arrayUsuario.length; i++)
				{
					contenidoEmailAdmin.append(arrayUsuario[i].getUsuario());
					contenidoEmailAdmin.append("<br>");
				}
				contenidoEmailAdmin.append("</br>");
				contenidoEmailAdmin.append("</html>");
				this.enviarCorreoThread(this.getPropertyValue("adminLdapExternal"), getResource("correo.solicitudBaja.asunto"), contenidoEmailAdmin, this.getPropertyValue("fromSender"));

			}

		} catch (org.springframework.dao.DataRetrievalFailureException comunicationException)
		{
			log.error("Se produce una excepcion de ldap : org.springframework.dao.DataRetrievalFailureException " + comunicationException);
			usuario.setFechaBaja(null);
			usuario.setGrupos(grupos);
			this.getUsuarioDao().update(usuario);
			validaBajaVO.setNumDeleted(new Integer(0));
			validaBajaVO.setDescripcion("errors.borrarUsuario");
			validaBajaVO.setItemsDeleted((UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]));
		} catch (org.springframework.ldap.UncategorizedLdapException exception)
		{
			log.error("Se produce una excepcion de ldap : org.springframework.ldap.UncategorizedLdapException " + exception);

			usuario.setFechaBaja(null);
			usuario.setGrupos(grupos);

			this.getUsuarioDao().update(usuario);
			if(log.isDebugEnabled())log.debug("despueds de rollback");
			validaBajaVO.setNumDeleted(new Integer(0));
			validaBajaVO.setDescripcion("errors.borrarUsuario");
			validaBajaVO.setItemsDeleted((UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]));
		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion ", e);
			BajaUsuarioException exception = new BajaUsuarioException("Error al eliminar el usuario ", e);
			validaBajaVO.setNumDeleted(new Integer(0));
			validaBajaVO.setDescripcion("errors.borrarUsuario");
			validaBajaVO.setItemsDeleted((UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]));
			throw exception;
		}

		// }

		return validaBajaVO;

	}

	/**
	 * Obtiene la lista de los usuarios activos
	 * @return usuarioV array de usuariosVO
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.UsuarioVO[] handleListarUsuarios() throws java.lang.Exception
	{
		UsuarioVO[] usuarioV = null;

		try
		{
			Collection usuarios = this.getUsuarioDao().getUsuarios();
			this.getUsuarioDao().toUsuarioVOCollection(usuarios);
			if(log.isDebugEnabled())log.debug("[LISTARUSUARIOS] usuarios ");

			usuarioV = (UsuarioVO[]) usuarios.toArray(new UsuarioVO[0]);

		} catch (Exception e)
		{
			log.error("Error: " + e);
			throw e;
		}

		return usuarioV;
	}

	/**
	 * Obtiene el usuario cuyo identificador sea el que se le pasa por
	 * parametro
	 * @param id identificador de un usuario
	 * @return UsuarioVO usuarioVO
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.UsuarioVO handleDescripcionUsuario(java.lang.Long id) throws java.lang.Exception
	{
		try
		{
			UsuarioVO usuarioVO = null;
			usuarioVO = (UsuarioVO) this.getUsuarioDao().load(UsuarioDao.TRANSFORM_USUARIOVO, id);
			return usuarioVO;
		} catch (Exception e)
		{
			log.error("Error al obtener el usuarioVO apartir del id");
			DescripcionUsuarioException descripcionUsuarioException = new DescripcionUsuarioException("Error al obtener el UsuarioVO apartir del id", e);
			throw descripcionUsuarioException;
		}
	}

	/**
	 * Obtiene un array con los roles (descripciones) del usuario cuyo login
	 * se pasa por parametro
	 * @param usuario login del usuario
	 * @return resultado Array de string con los roles del usuario
	 * @throws Exception
	 */
	protected String[] handleListarRolesUsuario(java.lang.String usuario) throws java.lang.Exception
	{
		String[] resultado = null;
		List roles = null;

		UsuarioDao usuarioDao = this.getUsuarioDao();
		Usuario datosUsuario = usuarioDao.obtenerDatosUsuario(usuario);
		if (datosUsuario.getFechaDesactivacion()==null) {
			roles = usuarioDao.consultaHQL(usuario.toLowerCase());
			if(log.isDebugEnabled())log.debug("roles " + roles.size());
			resultado = (String[]) roles.toArray(new String[0]);
			if(log.isDebugEnabled())log.debug("roles ordenados " + resultado.length+", primera posición de los ordenados es: "+ resultado[0]);
		} else {
			String rol[] = {"INACTIVO"};
			log.info("[LISTARROLESUSUARIO]el usuario está desactivado, le ponemos el rol INACTIVO");
			resultado = rol;
		}

		return resultado;
	}

	/**
	 * Da de alta un grupo en la BD
	 * @param GrupoVO Datos de un grupoVO
	 * @throws Exception
	 */
	protected Long handleAltaGrupo(es.pode.adminusuarios.negocio.servicios.GrupoVO grupoVO) throws java.lang.Exception
	{
		Long resultado=null;
		try
		{
			Grupo grupo = this.getGrupoDao().fromGrupoVO(grupoVO);
			Grupo grupoCreado = this.getGrupoDao().create(grupo);
			resultado=grupoCreado.getId();
			
		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion " + e);
			AltaGrupoException exception = new AltaGrupoException("No se ha podido dar de alta el grupo", e);
			throw exception;
		}
		return resultado;
	}
	
	
	/**
	 * Da de alta un grupo de trabajo en la BD
	 * @param GrupoTrabajoVO Datos de un grupoTrabajoVO
	 * @throws Exception
	 */
	protected Long handleAltaGrupoTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO grupoTrabajoVO) throws java.lang.Exception
	{
		Long resultado=null;
		try
		{
			GrupoTrabajo grupoTrabajo = this.getGrupoTrabajoDao().fromGrupoTrabajoVO(grupoTrabajoVO);
			GrupoTrabajo grupo=this.getGrupoTrabajoDao().create(grupoTrabajo);
			resultado=grupo.getIdentificador();

		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion " + e);
			throw e;
		}
		return resultado;
	}

	/**
	 * Obtiene el rol a partir del identificador
	 * @param id Identificador del rol
	 * @return r RolVO con los datos de un rol
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.RolVO handleGetRol(java.lang.Long id) throws java.lang.Exception
	{
		RolDao rolDao = this.getRolDao();
		RolVO r = (RolVO) rolDao.load(RolDao.TRANSFORM_ROLVO, id);
		return r;
	}

	/**
	 * Comprueba si la descripcion que se le pasa por parámetro esta
	 * asociado a otro grupo
	 * @param descripcion descripcion del grupo
	 * @param id identificador del grupo
	 * @return retorno String indicando si ha ido bien o no la operacion
	 * @throws Exception
	 */
	protected java.lang.Boolean handleExisteDescripcion(java.lang.String descripcion, java.lang.Long id) throws java.lang.Exception
	{
		Boolean retorno = new Boolean(false);
		GrupoVO[] grupoV = null;
		Collection grupos = this.getGrupoDao().loadAll(GrupoDao.TRANSFORM_GRUPOVO);
		grupoV = (GrupoVO[]) grupos.toArray(new GrupoVO[0]);
		if (id.compareTo(new Long("-1")) == 0)
		{

			if(log.isDebugEnabled())log.debug("Alta grupo la descripcion no puede coincidir");
			for (int j = 0; j < grupoV.length; j++)
			{
				if (grupoV[j].getDescripcion().equalsIgnoreCase(descripcion))
				{
					retorno = Boolean.TRUE;
				}
			}
		} else
		{

			for (int j = 0; j < grupoV.length; j++)
			{
				if (grupoV[j].getDescripcion().equalsIgnoreCase(descripcion))
				{
					if (grupoV[j].getId().compareTo(id) != 0)
					{
						retorno = Boolean.TRUE;
					}
				}
			}
		}
		return retorno;
	}

	/**
	 * Obtiene el usuario cuyo nif coincida con el que se pasa por
	 * parámetro. Este método se invocará durante el proceso de alta de un
	 * usuario puesto que no se va a permitir que existan dos usuarios
	 * registrados con el mismo nif.
	 * @param Nif nif del usuario
	 * @return Usuario usuarioVO, en caso de no haber en BD ningún usuario
	 *         con ese nif se devolverá null
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.UsuarioVO handleObtenerUsuario(java.lang.String nif) throws java.lang.Exception
	{
		UsuarioVO usuario = null;
		Usuario usuarioEntity = this.getUsuarioDao().obtenerUsuario(nif);
		if (usuarioEntity == null)
		{
			if(log.isDebugEnabled())log.debug("No existe un usuario en BD con ese nif " + nif);
		} else
		{
			usuario = this.getUsuarioDao().toUsuarioVO(usuarioEntity);
		}

		return usuario;
	}

	/**
	 * Compruebo si el usuario (login) que se le pasa por parámetro ya esta
	 * asociado a otro usuario
	 * @param usuario login del usuario
	 * @return resultado Boolean que inidica si ha ido bien o no la
	 *         operacion si existe ya en BD un usuario con ese login
	 *         devolverá un true.
	 * @throws Exception
	 */
	protected java.lang.Boolean handleExisteUsuario(java.lang.String usuario) throws java.lang.Exception
	{
		Boolean resultado = Boolean.TRUE;
		Usuario usuarioEntity = this.getUsuarioDao().obtenerDatosUsuario(usuario.toLowerCase());

		if (usuarioEntity == null)
		{
			resultado = Boolean.FALSE;
		}

		return resultado;
	}

	/**
	 * Se envia al usuario proporcionado como parametro un mail indicando
	 * que se le ha dado de alta en el sistema Agrega y se le pasan los
	 * datos de alta
	 * @param usuarioVO usuarioVO con los datos del usuario
	 * @return resultado String que indica si ha ido bien o no la operacion
	 * @throws Exception
	 */
	protected java.lang.String handleEnviarCorreoAlta(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuarioVO) throws java.lang.Exception
	{
		String resultado = "";
		String[] destinatarios = null;
		String nodo = "";
		try
		{
			String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
			int l=1;
			if(!(idiomaSecundario==null) && !idiomaSecundario.equals(""))
				l++;
			destinatarios = this.getEmailAdmin(); // Vector con los emails de
			// todos los administradores que estan dados de alta en el
			// sistema
			DependentServerPropertiesItf properties = DependentServerProperties.getInstance();
			nodo = (String) properties.getProperty("nodo");
			if(log.isDebugEnabled())log.debug("El valor de nodo es " + nodo);
			StringBuffer contenido = new StringBuffer();
			for(int j=0;j<l;j++){
				String idioma="";
			if(j==0){
				idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}else{
				idioma=idiomaSecundario;
			}
				contenido.append("<html>");
				contenido.append(getResource("correo.solicitudAlta.cabecera",idioma));
				contenido.append("<br/><br/>");
				contenido.append("<B>" + getResource("correo.solicitudAlta.datosPersonales",idioma) + "</B>");
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.nombre",idioma) + ":" + " ");
				contenido.append(usuarioVO.getNombre());
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.apellido1",idioma) + ":" + " ");
				contenido.append(usuarioVO.getApellido1());
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.apellido2",idioma) + ":" + " ");
				contenido.append(usuarioVO.getApellido2());
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.nif",idioma) + ":" + " ");
				contenido.append(usuarioVO.getNIF());
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.mail",idioma) + ":" + " ");
				contenido.append(usuarioVO.getEmail());
				contenido.append("<br/><br/>");
				contenido.append("<B>" + getResource("correo.solicitudAlta.datosAcceso",idioma) + "</B>");
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.usuario",idioma) + ":" + " ");
				contenido.append(usuarioVO.getUsuario());
				contenido.append("<br/><br/>");
				contenido.append("<B>" + getResource("correo.solicitudAlta.preferencias",idioma) + "</B>");
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.tipoEmpaquetador",idioma) + ":" + " ");
				contenido.append(usuarioVO.getTipoEmpaquetador());
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.idioma",idioma) + ":" + " ");
				contenido.append(usuarioVO.getIdiomaBusqueda());
				contenido.append("<br/>");
				contenido.append(getResource("correo.solicitudAlta.idiomaBusqueda",idioma) + ":" + " ");
				contenido.append(usuarioVO.getIdioma());
				contenido.append("<br/><br/>");
				contenido.append("<B>" + getResource("correo.solicitudAlta.comunidad",idioma) + "</B>");
				contenido.append("<br/>");
				contenido.append(getResource(nodo));
				contenido.append("<br/>"); 
				if(l>1){
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
				}
			}
			contenido.append("</html>");
			// //El metodo de envio de correo no permite pasarle un from
			// configurable
			int num_correos_enviados = 0;
			boolean envioCorrecto = false;
			for (int i = 0; i < destinatarios.length; i++)
			{
				if(log.isDebugEnabled())log.debug("destinatario " + destinatarios[i]);
				
				//envioCorrecto = this.enviarCorreo((String) destinatarios[i], ficheroRecursos.getString("correo.solicitudAlta.asunto"), contenido, this.getPropertyValue("fromSender"));
				envioCorrecto = this.enviarCorreo((String) destinatarios[i], getResource("correo.solicitudAlta.asunto"), contenido, this.getPropertyValue("fromSender"));
				if (envioCorrecto)
				{
					if(log.isDebugEnabled())log.debug("El correo ha sido enviado correctamente a uno de los administradores");
					num_correos_enviados = num_correos_enviados + 1;
				}
			}
			if (num_correos_enviados == 0)
			{
				resultado = "0";
			} else
			{
				resultado = "1";
			}
		} catch (Exception e)
		{

			log.error("Error al enviar el correo de solicitud de alta ", e);
			resultado = "0";
			// throw e;
		}

		if (this.getPropertyValue("ldapExternal").equalsIgnoreCase("true"))
		{
			try
			{
				// Se enviara un correo al administrador del ldap externo para
				// que modifique la clave del usuario
				StringBuffer contenidoEmailAdmin = new StringBuffer();
				contenidoEmailAdmin.append("<html>");
				contenidoEmailAdmin.append(getResource("correo.solicitudAlta1"));
				contenidoEmailAdmin.append("<B>" + getResource("correo.solicitudAlta5") + ":" + "</B>" + " ");
				contenidoEmailAdmin.append(usuarioVO.getUsuario());
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<B>" + getResource("correo.solicitudAlta6") + ":" + "</B>" + " ");
				contenidoEmailAdmin.append(usuarioVO.getClave());
				contenidoEmailAdmin.append("<br/><br/>");
				contenidoEmailAdmin.append("<B>" + getResource("correo.solicitudAlta.comunidad") + "</B>");
				contenidoEmailAdmin.append("<br/>");
				contenidoEmailAdmin.append(getResource(nodo));
				contenidoEmailAdmin.append("<br/>");
				contenidoEmailAdmin.append("</html>");
				this.enviarCorreoThread(this.getPropertyValue("adminLdapExternal"), getResource("correo.solicitudAlta.asunto"), contenidoEmailAdmin, this.getPropertyValue("fromSender"));

			} catch (Exception ex)
			{

				log.error("Error al enviar el correo de solicitud de alta ", ex);
				// resultado = "0";
			}
		}
		if(log.isDebugEnabled())log.debug("resultado del envio de la solicitud de alta vale " + resultado);
		return resultado;
	}

	/**
	 * Envio de correo cuando un usuario solicita la baja del sistema. Se
	 * envia un correo a todos los administradores con el login del usuario
	 * que se quiere dar de baja
	 * @param usuarioVo usuarioVO con los datos del usuario
	 * @retun resultado String que indica si ha ido bien o no la operacion
	 * @throws Exception
	 */
	protected java.lang.String handleEnviarCorreoBaja(UsuarioVO usuarioVO) throws java.lang.Exception
	{
		String resultado = "";
		String[] destinatarios = null;
		String nodo = "";
		try
		{
			String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
			int l=1;
			if(!(idiomaSecundario==null) && !idiomaSecundario.equals(""))
				l++;
			destinatarios = this.getEmailAdmin(); // Vector con los emails de
			// todos los administradores que estan dados de alta en el
			// sistema
			DependentServerPropertiesItf properties = DependentServerProperties.getInstance();
			nodo = (String) properties.getProperty("nodo");
			if(log.isDebugEnabled())log.debug("El valor de nodo es " + nodo);
			StringBuffer contenido = new StringBuffer();
			for(int j=0;j<l;j++){
				String idioma="";
			if(j==0){
				idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}else{
				idioma=idiomaSecundario;
			}
				contenido.append("<html>");				
				contenido.append(getResource("correo.solicitud.baja.hola",idioma));
				contenido.append("<br>");
				contenido.append(getResource("correo.solicitudBaja1",idioma));
				contenido.append(" " + "<b>" + usuarioVO.getUsuario() + "</b>" + " ");
				contenido.append(getResource("correo.solicitudBaja2"));
				contenido.append(" " + "<b>" + getResource(nodo,idioma) + "</b>" + ".");
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append(getResource("correo.solicitudBaja3",idioma));
				contenido.append("<br>");
				contenido.append(getResource("correo.solicitudBaja4",idioma));
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append(getResource("correo.solicitudBaja5",idioma));
				contenido.append("</br>");
				if(l>1){
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
					contenido.append("<br/>"); 
				}
			}
				contenido.append("</html>");
			
			// El metodo de envio de correo no permite pasarle un from
			// configurable
			int num_correos_enviados = 0;
			boolean envioCorrecto = false;
			for (int i = 0; i < destinatarios.length; i++)
			{
				if (!(((String) destinatarios[i]).equalsIgnoreCase(usuarioVO.getEmail())))
				{
				
					envioCorrecto = this.enviarCorreo((String) destinatarios[i], getResource("correo.solicitudBaja.asunto"), contenido, this.getPropertyValue("fromSender"));
					if (envioCorrecto)
					{
						if(log.isDebugEnabled())log.debug("El correo ha sido enviado correctamente a uno de los administradores");
						num_correos_enviados = num_correos_enviados + 1;
					}
				}
			}

			if (num_correos_enviados == 0)
			{
				resultado = "0";
			} else
			{
				resultado = "1";
			}
		} catch (Exception e)
		{

			log.error("Error al enviar el correo de solicitud de alta ", e);
			resultado = "0";

		}

		if (this.getPropertyValue("ldapExternal").equalsIgnoreCase("true"))
		{
			try
			{
				// Se enviara un correo al administrador del ldap externo para
				// que modifique la clave del usuario
				StringBuffer contenidoEmailAdmin = new StringBuffer();				
				contenidoEmailAdmin.append("<html>");				
				contenidoEmailAdmin.append(getResource("correo.solicitud.baja.hola"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.solicitudBaja1"));
				contenidoEmailAdmin.append(" " + "<b>" + usuarioVO.getUsuario() + "</b>" + " ");
				contenidoEmailAdmin.append(getResource("correo.solicitudBaja2"));
				contenidoEmailAdmin.append(" " + "<b>" + getResource(nodo) + "</b>" + ".");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.solicitudBaja3"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.solicitudBaja4"));
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append("<br>");
				contenidoEmailAdmin.append(getResource("correo.solicitudBaja5"));
				contenidoEmailAdmin.append("</br>");
				contenidoEmailAdmin.append("</html>");
				this.enviarCorreoThread(this.getPropertyValue("adminLdapExternal"), getResource("correo.solicitudBaja.asunto"), contenidoEmailAdmin, this.getPropertyValue("fromSender"));

			} catch (Exception ex)
			{

				log.error("Error al enviar el correo de solicitud de alta ", ex);
				// resultado = "0";
			}
		}
		if(log.isDebugEnabled())log.debug("resultado del envio de la solicitud de baja vale " + resultado);
		return resultado;
	}

	/**
	 * Obtiene los datos de un usuario deovolviendo el VO completo del
	 * usuario corespondiente al login que se pasa como parametro
	 * @param usuario String con el login del usuario
	 * @return usuarioVO usuarioVO con los datos del usuario
	 * @throws Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.UsuarioVO handleObtenerDatosUsuario(java.lang.String usuario) throws java.lang.Exception
	{
		UsuarioVO usuarioVO = null;
		Usuario usuarioEntity = this.getUsuarioDao().obtenerDatosUsuario(usuario.toLowerCase());
		if (usuarioEntity == null)
		{
			log.error("No existe un usuario cuyo login sea " + usuario);
		} else
		{
			usuarioVO = this.getUsuarioDao().toUsuarioVO(usuarioEntity);
		}

		return usuarioVO;
	}

	/**
	 * Devuelve los mails de los usuarios que en ese momento son
	 * administradores
	 * @param usuario String con el login del usuario
	 * @return usuarioVO usuarioVO con los datos del usuario
	 * @throws Exception
	 */
	protected String[] handleGetEmailAdmin() throws Exception
	{
		String[] resultado = null;
		try
		{
			List listaUsuarios = this.getUsuarioDao().obtenerEmailAdmin(this.getPropertyValue("rol_administrador"));
			if(log.isDebugEnabled())log.debug("Obtenemos los email de los admin del sistema " + listaUsuarios.size());

			// Obtenemos el correo de todos aquellos usuarios que tengan un
			// grupo administrador.
			resultado = new String[listaUsuarios.size()];
			Iterator iter = listaUsuarios.iterator();
			for (int i = 0; i < resultado.length; i++)
			{
				resultado[i] = (String) iter.next();
			}

			// Sacamos todos los usuarios que tienen como grupo el
			// administrador
		} catch (Exception e)
		{
			log.error("Se produce un error al intentar obtener los correos de los administradores ", e);
			throw e;
		}
		return resultado;

	}

	
	/**
	 * Devuelve los mails de los usuarios que en ese momento son
	 * administradores
	 * @param usuario String con el login del usuario
	 * @return usuarioVO usuarioVO con los datos del usuario
	 * @throws Exception
	 */
	protected String[] handleGetEmailPublicadores() throws Exception
	{
		String[] resultado = null;
		AgregaProperties properties = null;
		String rolPublicador = "";
		try
		{
			properties = AgregaPropertiesImpl.getInstance();
			rolPublicador = properties.getProperty("rol_publicador");
			List listaUsuarios = this.getUsuarioDao().obtenerEmailAdmin(rolPublicador);
			if(log.isDebugEnabled())log.debug("Obtenemos los email de los publicadores del sistema " + listaUsuarios.size());

			// Obtenemos el correo de todos aquellos usuarios que tengan un
			// grupo administrador.
			resultado = new String[listaUsuarios.size()];
			resultado = (String[])listaUsuarios.toArray(new String[0]);
			
			// Sacamos todos los usuarios que tienen como grupo el
			// administrador
		} catch (Exception e)
		{
			log.error("Se produce un error al intentar obtener los correos de los administradores ", e);
			throw e;
		}
		return resultado;

	}
	

	/**
	 * Obtiene los identificadores de los usuarios que son administradores
	 * @return resultado array de Long
	 * @throws Exception
	 */
	protected Long[] handleObtenerUsuariosAdministrador() throws Exception
	{
		Long[] resultado = null;
		try
		{
			String admin = this.getPropertyValue("rol_administrador");
			Collection lista = this.getUsuarioDao().obtenerUsuariosAdministradores(admin);
			resultado = (Long[]) lista.toArray(new Long[0]);
			return resultado;
		} catch (IOException io)
		{
			log.error("Se produce una excepcion al leer el fichero adminusuarios.properties", io);
			throw io;
		} catch (Exception e)
		{
			log.error("Se produce una excepcion al obtener los usuarios con rol administrador", e);
			throw e;
		}
	}

	/**
	 * Obtiene los identificadores de los grupos que contienen usuarios que
	 * son administradores
	 * @return resultado array de Long
	 * @throws Exception
	 */
	protected Long[] handleObtenerGrupoAdministrador() throws Exception
	{
		Long[] resultado = null;
		try
		{
			String admin = this.getPropertyValue("rol_administrador");
			List lista = this.getGrupoDao().obtenerGruposAdministradores(admin);
			resultado = (Long[]) lista.toArray(new Long[0]);

			return resultado;
		} catch (Exception io)
		{
			log.error("Se produce una excepcion al leer el fichero adminusuarios.properties", io);
			throw io;
		}

	}

	

	/**
	 * Obtiene los usuarios pendientes de dar de alta en el sistema
	 * @return usuarioV UsuarioVO[] con los datos de los usuarios pendientes
	 *         de dar de alta
	 * @throws Exception
	 */
	protected UsuarioVO[] handleListarUsuariosPendientes() throws Exception
	{
		UsuarioVO[] usuarioV = null;

		try
		{
			Collection usuarios = this.getUsuarioDao().getUsuariosPendientes();
			this.getUsuarioDao().toUsuarioVOCollection(usuarios);
			usuarioV = (UsuarioVO[]) usuarios.toArray(new UsuarioVO[0]);

			if(log.isDebugEnabled())log.debug("[LISTARUSUARIOSPENDIENTES] usuarios pendientes " + usuarios.size());

		} catch (Exception e)
		{
			log.error("Error: " + e);
			throw e;
		}
		return usuarioV;

	}

	/**
	 * Almacena en el sistema la solicitud de alta de un usuario.
	 * @param usuario UsuarioVO con los datos del usuario que solicita el alta
	 * @return resultado String que indica si la operación se ha llevado a cabo
	 *         con éxito o no
	 * @throws Exception
	 */
	protected String handleSolicitarAltaUsuario(UsuarioVO usuario) throws Exception
	{
		Usuario usuarioCreado = null;
		String resultado = "";
		try
		{
			usuario.setFechaSolicitudAlta(new java.util.Date());
			if (this.obtenerUsuario(usuario.getNIF()) == null)
			{
				usuarioCreado = this.getUsuarioDao().create(this.getUsuarioDao().fromUsuarioVO(usuario));
				if(log.isDebugEnabled())log.debug("Usuario almacenado en BBDD" + usuarioCreado.getUsuario());
			} else
			{

				if(log.isDebugEnabled())log.debug("Modificamos un usuario ya registrado en el sistema");
				Usuario usuarioEntity = this.getUsuarioDao().load(usuario.getId());
				this.getUsuarioDao().fromUsuarioVO(usuario, usuarioEntity);
				this.getUsuarioDao().update(usuarioEntity);
			}
			handleEnviarCorreoAlta(usuario);
			resultado = "OK";

		} catch (Exception e)
		{
			resultado = "FALLO";
			log.error("Error al dar de alta al usuario ", e);
		}
		return resultado;
	}

	/**
	 * Da de baja uno o varios usuarios que están pendientes de dar de alta 
	 * en el sistema.
	 * @param ids Long[] array de identificadores de usuarios
	 * @param emailAdmin UsuarioVO datos del administrador que efectúa la baja.
	 * @return validaBajaVO ValidaBajaUsuarioVO que contiene el número de usuarios
	 * dados de baja, un array con los usuarios y el resultado de la operación.
	 * @throws Exception
	 */
	protected ValidaBajaUsuarioVO handleBajaUsuarioPendiente(Long[] ids, UsuarioVO emailAdmin) throws Exception
	{
		ValidaBajaUsuarioVO validaBajaVO = new ValidaBajaUsuarioVO();

		int usuarioDeleted = 0;
		Usuario usuario = null;
		List itemsDeleted = new ArrayList();

		try
		{
			usuarioDeleted = 0;
			for (int j = 0; j < ids.length; j++)
			{
				Long identificador = ids[j];
				usuario = (this.getUsuarioDao()).load(identificador);
				usuario.setFechaBaja(new Date(System.currentTimeMillis()));
				usuario.setGrupos(null);
				this.getUsuarioDao().update(usuario);
				if(log.isDebugEnabled())log.debug("Se actualiza la fecha de baja del usuario pendiente");
				usuarioDeleted = usuarioDeleted + 1;
				itemsDeleted.add((this.getUsuarioDao()).toUsuarioVO(usuario));
				StringBuffer contenido = new StringBuffer();
				contenido.append("<html>");
				contenido.append("<br>");
				contenido.append("<br>");
				contenido.append(getResource("correo.bajaUsuarioPendiente.contenido1"));
				contenido.append(" " + "<b>" + usuario.getUsuario() + "</b>" + " ");
				contenido.append(getResource("correo.bajaUsuarioPendiente.contenido2"));
				contenido.append("</br>");
				contenido.append("</html>");
				this.enviarCorreoThread(usuario.getEmail(), getResource("correo.bajaUsuarioPendiente.asunto"), contenido, emailAdmin.getEmail());
			}
			validaBajaVO.setNumDeleted(new Integer(usuarioDeleted));
			validaBajaVO.setDescripcion("ok.borrarUsuarios");
			validaBajaVO.setItemsDeleted((UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]));

		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion ", e);
			BajaUsuarioException exception = new BajaUsuarioException("Error al eliminar el usuario ", e);
			validaBajaVO.setNumDeleted(new Integer(0));
			validaBajaVO.setDescripcion("errors.borrarUsuario");
			validaBajaVO.setItemsDeleted((UsuarioVO[]) itemsDeleted.toArray(new UsuarioVO[0]));
			throw exception;
		}

		return validaBajaVO;
	}

	/**
	 * Obtiene los usuarios activos en un rago de fechas determinado.
	 * @param parametroAuditoriaUsuariosVO
	 *                ParametroAuditoriaUsuariosVO contiene el rango de fechas
	 * @return usuariosActivosVO UsuarioActivoVO que contiene los usuarios activos 
	 * 		   en el rango especificado.
	 * @throws Exception
	 */
	protected UsuarioActivoVO[] handleUsuariosActivos(ParametroAuditoriaUsuariosVO parametroAuditoriaUsuariosVO) throws Exception
	{
		UsuarioActivoVO[] usuariosActivosVO = null;
		try
		{
			UsuarioDao usuarioDao = this.getUsuarioDao();
			if(log.isDebugEnabled())log.debug("despues de obtener usuarioDao " + usuarioDao);
			// log("parametrosAuditoriaUsuarioVO.getFechaHasta() "+parametrosAuditoriaUsuarioVO.getFechaHasta());
			// List list = usuarioDao.usuariosActivos(fechaFin);
			List list = usuarioDao.usuariosActivos(parametroAuditoriaUsuariosVO.getFechaHasta());
			usuariosActivosVO = new UsuarioActivoVO[list.size()];
			if(log.isDebugEnabled())log.debug("El tamanio de la lista de los usuarios activos es " + list.size());
			for (int i = 0; i < list.size(); i++)
			{
				usuariosActivosVO[i] = new UsuarioActivoVO();
				usuariosActivosVO[i].setNombre(((Usuario) list.get(i)).getNombre());
				usuariosActivosVO[i].setApellido1(((Usuario) list.get(i)).getApellido1());
				usuariosActivosVO[i].setApellido2(((Usuario) list.get(i)).getApellido2());
				usuariosActivosVO[i].setLogin(((Usuario) list.get(i)).getUsuario());
				usuariosActivosVO[i].setEmail(((Usuario) list.get(i)).getEmail());
				usuariosActivosVO[i].setIdiomaAplicacion(((Usuario) list.get(i)).getIdioma());
				usuariosActivosVO[i].setIdiomaBusqueda(((Usuario) list.get(i)).getIdiomaBusqueda());
				usuariosActivosVO[i].setTipoEmpaquetador(((Usuario) list.get(i)).getTipoEmpaquetador());
				usuariosActivosVO[i].setNIF(((Usuario) list.get(i)).getNIF());
				//Asignamos el array con el nombre de los grupos que tiene asignados
				String grupos = "";
				String rols = "";
				Grupo[] grupo = (Grupo[]) (((Usuario) list.get(i)).getGrupos().toArray(new Grupo[0]));
				if (!(grupo == null))
				{
					Vector roles = new Vector();
					for (int j = 0; j < grupo.length; j++)
					{
						grupos = grupos + " " + grupo[j].getDescripcion();
						Rol[] rolesGrupo = (Rol[]) (grupo[j].getRols()).toArray(new Rol[0]);

						for (int k = 0; k < rolesGrupo.length; k++)
						{
							if (!(roles.contains(rolesGrupo[k].getDescripcion())))
							{
								roles.add(rolesGrupo[k].getDescripcion());
							}
						}

					}
					//Asigno al usuario sus permisos
					for (int l = 0; l < roles.size(); l++)
					{
						rols = rols + " " + (String) roles.elementAt(l);
					}
					if(log.isDebugEnabled())log.debug("rols vale " + rols);
					usuariosActivosVO[i].setPermisos(rols);
					if(log.isDebugEnabled())log.debug("El usuario tiene " + (usuariosActivosVO[i].getPermisos()) + " permisos");
					usuariosActivosVO[i].setGrupos(grupos);
					if(log.isDebugEnabled())log.debug("El usuario tiene " + (usuariosActivosVO[i].getGrupos()) + " grupos");
				}

			}

		} catch (Exception e)
		{
			log.error("Error : " + e);
			throw e;
		}

		return usuariosActivosVO;
	}

	/**
	 * Obtiene un listado de todos los usuarios presentes en el sistema salvo 
	 * los que están pendientes de dar de alta
	 * @return usuarioV UsuarioVO[] con los datos de los usuarios del sistema.
	 * @throws Exception
	 */
	protected UsuarioVO[] handleListarTodosUsuarios() throws Exception
	{

		UsuarioVO[] usuarioV = null;
		try
		{
			Collection usuarios = this.getUsuarioDao().getTodosUsuarios();
			this.getUsuarioDao().toUsuarioVOCollection(usuarios);
			if(log.isDebugEnabled())log.debug("[LISTARTODOSUSUARIOS] usuarios: ");

			usuarioV = (UsuarioVO[]) usuarios.toArray(new UsuarioVO[0]);

		} catch (Exception e)
		{
			log.error("Error: " + e);
			throw e;
		}

		return usuarioV;
	}

	/**
	 * Activa un usuario que estaba inactivo
	 * @param id Long identificador del usuario que se desea activar
	 * @throws Exception
	 */
	protected void handleActivarUsuario(Long id, String admin) throws Exception {
		Usuario usuario = null;
		usuario = (this.getUsuarioDao()).load(id);
		usuario.setFechaDesactivacion(null);
		this.getUsuarioDao().update(usuario);
		log.info("[ACTIVARUSUARIO] El usuario " + usuario.getUsuario()+ "ha sido activado por el administrador: " + admin);
		
	}

	/**
	 * Desactiva un usuario que estaba activo
	 * @param id Long identificador del usuario que se desea desactivar
	 * @throws Exception
	 */
	protected void handleDesactivarUsuario(Long id, String admin) throws Exception {

		Usuario usuario = null;
		usuario = (this.getUsuarioDao()).load(id);
		usuario.setFechaDesactivacion(new Date(System.currentTimeMillis()));
		this.getUsuarioDao().update(usuario);
		
		String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
		int l=1;
		if(!(idiomaSecundario==null) && !idiomaSecundario.equals(""))
			l++;
		//Se manda un correo al usuario para notificarle la desactivación
		StringBuffer contenido = new StringBuffer();
		for(int j=0;j<l;j++){
			String idioma="";
			if(j==0){
				idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}else{
				idioma=idiomaSecundario;
			}
		log.info("[DESACTIVARUSUARIO] El usuario " + usuario.getUsuario()+ "ha sido desactivado por el administrador: " + admin);
			contenido.append("<html>");
			contenido.append("<br>");
			contenido.append("<br>");
			contenido.append(getResource("correo.desactivacionUsuario.contenido1",idioma));
			contenido.append(" " + "<b>" + usuario.getUsuario() + "</b>" + " ");
			contenido.append(getResource("correo.desactivacionUsuario.contenido2",idioma));
			contenido.append("</br>");
			if(l>1){
				contenido.append("<br/>"); 
				contenido.append("<br/>"); 
			}
		}
		contenido.append("</html>");
		this.enviarCorreoThread(usuario.getEmail(), getResource("correo.desactivacionUsuario.asunto"), contenido, this.getPropertyValue("fromSender"));
		
	}

	/**
	 * Obtiene un listado de todos los usuarios inactivos del sistema.
	 * @return usuarioV UsuarioVO[] con los datos de los usuarios inactivos.
	 * @throws Exception
	 */
	protected UsuarioVO[] handleListarUsuariosInactivos() throws Exception {
		UsuarioVO[] usuarioV = null;

		try
		{
			Collection usuarios = this.getUsuarioDao().getUsuariosInactivos();
			this.getUsuarioDao().toUsuarioVOCollection(usuarios);
			usuarioV = (UsuarioVO[]) usuarios.toArray(new UsuarioVO[0]);

			if(log.isDebugEnabled())log.debug("[LISTARUSUARIOSINACTIVOS] usuarios inactivos " + usuarios.size());

		} catch (Exception e)
		{
			log.error("Error: " + e);
			throw e;
		}
		return usuarioV;
	}
	
	

	/**
	 * Obtiene un listado de todos los grupos de trabajo del sistema.
	 * @return grupoTrabajo GrupoTrabajoVO[] con los datos de los grupos de trabajo.
	 * @throws Exception
	 */
	
	protected GrupoTrabajoVO[] handleListarGruposTrabajo() throws Exception
	{
		
		GrupoTrabajoVO[] resultado = null;
		try
		{
			Collection gruposTrabajo = this.getGrupoTrabajoDao().loadAll(GrupoTrabajoDao.TRANSFORM_GRUPOTRABAJOVO);
			resultado = (GrupoTrabajoVO[]) gruposTrabajo.toArray(new GrupoTrabajoVO[0]);
	
		} catch (Exception e)
		{
			log.error("Error: " + e);
			throw e;
		}
		return resultado;
	}

	/**
	 * Obtiene un listado de todos los usuarios que pertenezcan al mismo grupo/s de trabajos que el usuario que se pasa como parámetro
	 * como mínimo todos los usuarios estarán en un grupo de trabajo.
	 * @param  usuarioGrupoTrabajo identificador del usuario cuyos grupos se quieren obtener
	 * @return String[] Array de identificadores de los usuarios.
	 * @throws Exception
	 */
	
	protected String[] handleObtenerListaUsuariosGrupoTrabajo(String loginUsuarioGrupoTrabajo) throws Exception
	{
		String[] resultado = null;
		List listaUsuarios = null;
		UsuarioVO usuarioGrupoTrabajo = null;
		GrupoTrabajoVO[] grupoTrabajo = null;
		//Primero vamos a comprobar si el usuario tiene el grupo Todos, en este caso devolveríamos todos los usuarios con grupo
		
		usuarioGrupoTrabajo = (UsuarioVO)this.getUsuarioDao().obtenerDatosUsuario(UsuarioDao.TRANSFORM_USUARIOVO, loginUsuarioGrupoTrabajo);
		if(log.isDebugEnabled())log.debug("usuarioGrupoTrabajo "+usuarioGrupoTrabajo);
		grupoTrabajo = usuarioGrupoTrabajo.getGrupoTrabajo();
		if(!(grupoTrabajo == null) || !(grupoTrabajo.length == 0))
		{
			//Si alguno de los grupos de trabajo del usuario es el grupo "Todos" se devolverá null 
			//de esta forma desde el catalogador se obtendrán todos los odes en estado pendientes de catalogación
			if((this.estaGrupoTrabajoTodos(grupoTrabajo)).booleanValue())
			{
				if(log.isDebugEnabled())log.debug("El usuario tiene como grupo de trabajo Todos");
				/////listaUsuarios = this.getUsuarioDao().getUsuariosTodosGruposTrabajo();
				////log("tamanio listaUsuarios (todos) "+listaUsuarios.size());
			
			}else
			{
				if(log.isDebugEnabled())log.debug("el usuario a partir del que se van a obtener los grupos de trabajo "+loginUsuarioGrupoTrabajo);
				listaUsuarios = this.getUsuarioDao().getUsuariosGrupoTrabajo(loginUsuarioGrupoTrabajo);
				if(log.isDebugEnabled())log.debug("tamanio listaUsuarios "+listaUsuarios.size());
				resultado = (String[]) listaUsuarios.toArray(new String[0]);
			
			}
			
		}
		return resultado;
	}

	/**
	 * Obtiene un listado de todos los usuarios que pertenezcan al mismo grupo/s de trabajos que el usuario que se pasa como parámetro
	 * @param  usuarioGrupoTrabajo identificador del usuario cuyos grupos se quieren obtener
	 * @return String[] Array de identificadores de los usuarios.
	 * @throws Exception
	 */
	protected GrupoTrabajoVO handleDescripcionGrupoTrabajo(Long identificador) throws Exception
	{
		GrupoTrabajoVO grupoTrabajoVO = null;
		grupoTrabajoVO = (GrupoTrabajoVO) this.getGrupoTrabajoDao().load(GrupoTrabajoDao.TRANSFORM_GRUPOTRABAJOVO, identificador);
		return grupoTrabajoVO;
		
	}
	
	
	
	/**
	 * Actualiza los datos del grupo de trabajo pasado por parametro con los datos que este contiene
	 * @param grupoTrabajo grupoTrabajoVO obtiene los nuevos datos de este grupo de trabajo
	 * @throws java.lang.Exception
	 */
	protected Long handleModificarGrupoTrabajo(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO grupoTrabajo) throws java.lang.Exception
    {
		Long id=null;
		try
		{

			id = grupoTrabajo.getIdentificador();
			GrupoTrabajo grupoTrabajoEntity = this.getGrupoTrabajoDao().load(id);
			this.getGrupoTrabajoDao().fromGrupoTrabajoVO(grupoTrabajo, grupoTrabajoEntity);
			this.getGrupoTrabajoDao().update(grupoTrabajoEntity);

		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion " + e);
			ModificacionGrupoException exception = new ModificacionGrupoException("No se ha podido modificar el grupo", e);
			throw exception;
		}
		return id;
    }
	
	
	/**
	 * Elimina los grupos de trabajo cuyo identoficador coincide con los pasados como parametro 
	 * @param ids identificadores de grupos de trabajo para ser eliminados
	 * @return
	 * @throws java.lang.Exception
	 */
	protected es.pode.adminusuarios.negocio.servicios.ValidaBajaGrupoTrabajoVO handleBajaGrupoTrabajo(java.lang.Long[] ids) throws java.lang.Exception
	{
		ValidaBajaGrupoTrabajoVO validaBajaVO = new ValidaBajaGrupoTrabajoVO();

		int grupoDeleted = 0;

		List itemsDeleted = new ArrayList();
		try
		{
			grupoDeleted = 0;
			for (int j = 0; j < ids.length; j++)
			{
				Long identificador = ids[j];
				if (!(this.obtenerUsuariosGrupoTrabajo(identificador)).booleanValue())
				{
					GrupoTrabajo grupoTrabajo = (this.getGrupoTrabajoDao()).load(identificador);
					GrupoTrabajo grupoTrabajoAux = grupoTrabajo;
					this.getGrupoTrabajoDao().remove(grupoTrabajo);
					grupoDeleted = grupoDeleted + 1;
					itemsDeleted.add((this.getGrupoTrabajoDao()).toGrupoTrabajoVO(grupoTrabajoAux));
				}
			}
			if(log.isDebugEnabled())log.debug("despues de borrar todos los grupos de trabajo");
			validaBajaVO.setItemsDeleted((GrupoTrabajoVO[]) itemsDeleted.toArray(new GrupoTrabajoVO[0]));
			if(log.isDebugEnabled())log.debug("despues de validaBajaVO.setItemsDeleted");
			if (grupoDeleted == ids.length)
			{
				validaBajaVO.setDescripcion("ok.borrarGrupo");
			} else
			{
				validaBajaVO.setDescripcion("errors.borrarGrupo.algunosGrupos");
			}

		} catch (Exception e)
		{
			log.error("Se ha producido la siguiente excepcion " + e);
			BajaGrupoException exception = new BajaGrupoException("Error al eliminar el grupo ", e);

			validaBajaVO.setDescripcion("errors.borrarGrupo");
			throw exception;
		}

		// }

		return validaBajaVO;

	}
	
	/**
	 * Elimina en BD el usuario que se le pasa como parametro, se invocara
	 * este metodo si se produce un error en la insercion en ldap
	 * @param usuario: usuario que quiere eliminar de la BD
	 * @param usuario usuarioVO con los datos del usuario
	 */
	private void eliminarUserTransaccion(UsuarioVO usuario)
	{

		try
		{

			Usuario usuarioEntity = this.getUsuarioDao().load(usuario.getId());
			this.getUsuarioDao().fromUsuarioVO(usuario, usuarioEntity);
			usuarioEntity.setGrupos(null);
			this.getUsuarioDao().update(usuarioEntity);
			this.getUsuarioDao().remove(usuarioEntity);

		} catch (Exception e)
		{
			log.error("se produce una excepcion ", e);
		}
	}

	/**
	 * Modifica los datos del usuario una vez que se ha solicitado la
	 * modificacion
	 * @param usuario usuarioVO con los datos del usuario
	 */
	private void modificarUserTransaccion(UsuarioVO usuario)
	{
		try
		{

			Usuario usuarioEntityModificar = this.getUsuarioDao().load(usuario.getId());
			this.getUsuarioDao().fromUsuarioVO(usuario, usuarioEntityModificar);
			this.getUsuarioDao().update(usuarioEntityModificar);
		} catch (Exception e)
		{
			log.error("se produce una excepcion ", e);
		}

	}


	/**
	 * Convierte el string que se pasa como parametro, que es el password, a
	 * un hash y se devuelve el resultado
	 * @param password String que contiene el password del usuario
	 * @retun String String
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	private String getHashPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{

		byte[] theTextToDigestAsBytes = password.getBytes("8859_1" /* encoding */);
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(theTextToDigestAsBytes);
		byte[] digest = md.digest();
		BASE64Encoder encoder = new BASE64Encoder();
		String sha = "{SHA}";
		return sha + encoder.encode(digest);
	}

	/**
	 * Recoge un literal del archivo properties agrega.properties referenciando el codigo de
	 * dicho literal
	 * @param sKey codigo del literal
	 * @return String String con el literal
	 * @throws IOException
	 */
	private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/agrega.properties");
		if (this.pAgregaProperties == null)
		{
			pAgregaProperties = new java.util.Properties();
			pAgregaProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pAgregaProperties.getProperty(sKey);
	}

	/**
	 * Recoge la traducción de un literal del archivo de traducciones application-resources. 
	 * El idioma en el que se traducirá será el de por defecto de la plataforma 
	 * @param Key codigo del literal
	 * @return String Traducción del literal
	 * @throws IOException
	 */
	private static String getResource(String key){

        String recurso = "";
       
        try
        {
        	String idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
        	if(log.isDebugEnabled())log.debug("idiomaNavegacion "+idiomaNavegacion);
        	Locale localeNavegacion = new Locale(idiomaNavegacion);
        	
        	ResourceBundle ficheroRecursos = null;
    		ficheroRecursos = ResourceBundle.getBundle("application-resources", localeNavegacion);
        	if(ficheroRecursos == null)
        	{
        		ficheroRecursos = ResourceBundle.getBundle("application-resources",new Locale("es"));
        		if(log.isDebugEnabled())log.debug("application resources por defecto");
        	}else
        	{
        		recurso = ficheroRecursos.getString(key);
        		
        	}

        }catch (MissingResourceException mre){

                  recurso = key;

        }catch (Exception e)
        {
        	recurso = key;
        }

        return recurso;

    }
	
	/**
	 * Recoge la traducción de un literal del archivo de traducciones application-resources. 
	 * El idioma en el que se traducirá será el que se pase por parámetro 
	 * @param Key código del literal
	 * @param idioma idioma de traducción
	 * @return String Traducción del literal
	 * @throws IOException
	 */
	private static String getResource(String key,String idioma){

        String recurso = "";
       
        try
        {
        	Locale localeNavegacion = new Locale(idioma);
        	
        	ResourceBundle ficheroRecursos = null;
    		ficheroRecursos = ResourceBundle.getBundle("application-resources", localeNavegacion);
        	if(ficheroRecursos == null)
        	{
        		ficheroRecursos = ResourceBundle.getBundle("application-resources",new Locale("es"));
        		if(log.isDebugEnabled())log.debug("application resources por defecto");
        	}else
        	{
        		recurso = ficheroRecursos.getString(key);
        		
        	}

        }catch (MissingResourceException mre){

                  recurso = key;

        }catch (Exception e)
        {
        	recurso = key;
        }

        return recurso;

    }
	

	/**
	 * Comprueba si alguno de los grupos del usuario es el grupo "Todos" 
	 * @param gruposTrabajo array con todos los grupos de trabajo a los que pertenece el usuario
	 * @return Boolean devolverá true si alguno de los grupos de trabajo que se pasan como parámetro es el grupo Todos
	 * @throws IOException
	 */
	private Boolean estaGrupoTrabajoTodos(GrupoTrabajoVO[] gruposTrabajo)
	{
		if(log.isDebugEnabled())log.debug("estaGrupoTrabajoTodos");
		Boolean resultado = new Boolean(false);
		try
		{
			for(int i=0;i<gruposTrabajo.length;i++)
			{
			
				if(log.isDebugEnabled())log.debug("gruposTrabajo[i].getNombre() "+gruposTrabajo[i].getNombre());
				if(gruposTrabajo[i].getNombre().equalsIgnoreCase(this.getAdminUsuariosPropertyValue("grupoTrabajoTodos")))
				{
					resultado = new Boolean(true);
					break;
				}
			}
		}catch(Exception e)
		{
			log.error("Error al leer del fichero adminusuarios.properties "+e);
			
		}
		return resultado;
	}
	
	/**
	 * Asiganamos un manejador de LDAP
	 * @return ldapContact ldapContactDAO
	 * @throws Exception
	 */
	private LDAPContactDAO getLdapHandler() throws Exception
	{
		LDAPContactDAO ldapContact = null;
		try
		{
			Resource resource = new ClassPathResource("springldap.xml");
			if(log.isDebugEnabled())log.debug("Despues de obtener el resource " + resource.getFilename());
			BeanFactory factory = new XmlBeanFactory(resource);
			if(log.isDebugEnabled())log.debug("Despues de obtener el factory " + factory);
			ldapContact = (LDAPContactDAO) factory.getBean("ldapContact");
			if(log.isDebugEnabled())log.debug("Despues de obtener el bean ldapContact " + ldapContact);
			return ldapContact;
		} catch (Exception e)
		{
			log.error("Se produce la siguiente excepcion " + e);
			throw e;
		}
	}

	/**
	 * Envia un correo, por ahora el from esta fijo en el fichero
	 * mail.properties.
	 * @param to a quien se le manda el mail
	 * @param asunto asunto del mail
	 * @param body el cuerpo del mail
	 * @param from quien envia el mail
	 */

	private void enviarCorreoThread(String to, String asunto, StringBuffer body, String from)
	{
		if(log.isDebugEnabled())log.debug("Envio de correo por otro hilo de ejecucion");
		MailSenderThread mailSenderT = new MailSenderThread(to, asunto, body, from);
		mailSenderT.start();
		// boolean resultado = mailSender.send(to, asunto, body, from);

	}

	/**
	 * Envia un correo, por ahora el from esta fijo en el fichero
	 * mail.properties.
	 * @param to a quien se le manda el mail
	 * @param asunto asunto del mail
	 * @param body el cuerpo del mail
	 * @param from quien envia el mail
	 * @return resultado boolean que indica si ha ido bien o no la operacion
	 * @throws Exception
	 */
	private boolean enviarCorreo(String to, String asunto, StringBuffer body, String from) throws Exception
	{
		// Envio de correo por el mismo hilo de ejecucion necesitamos conocer el
		// resultado del envio para mostrarselo al usuario
		boolean resultado = true;
		if(log.isDebugEnabled())log.debug("Envio de correo por el mismo hilo de ejecucion");
		try
		{
			MailSender mailSender = new MailSender();
			resultado = mailSender.send(to, asunto, body, from);
		} catch (Exception e)
		{
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Método para obtener una nueva clave para el usuario Estará formada
	 * por números y letras entre 7 y 10 caracteres.
	 * @return clave String que contiene la clave del usuario
	 */
	private String getPassword()
	{

		Random random = new Random();
		int max_caracs = 7 + random.nextInt(4);
		String[] caracteres =
		{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String clave = "";
		for (int i = 0; i < max_caracs; i++)
		{
			int esLetra = random.nextInt(2);
			if (esLetra == 1)
			{

				clave = clave + caracteres[random.nextInt(26)];
			} else
			{

				clave = clave + (new Integer(random.nextInt(10))).toString();
			}
		}

		return clave;
	}
	
	
	/**
	 * Obtiene los usuarios que pertenecen a un grupo que se identifica con
	 * el id que se pasa como parametro
	 * @param id identificador del grupo
	 * @return resultado Boolean que indica si existen o no usuarios en el
	 *         grupo especificado
	 * @throws Exception
	 */
	public Boolean handleObtenerUsuariosGrupo(Long id) throws Exception
	{
		try
		{
			Boolean resultado = Boolean.FALSE;
			List usuarios = this.getUsuarioDao().obtenerNumUsuariosGrupo(id);
			int numUsuarios = usuarios.size();
			if (numUsuarios > 0)
			{
				resultado = Boolean.TRUE;
			}
			return resultado;
		} catch (Exception e)
		{
			throw e;
		}
	}
	
	/**
	 * Método que comprueba si existen usuarios cuyo grupo de trabajo sea el mismo que el del usuario cuyo identificador
	 * se pasa como parámetro
	 * @param id Long identificador del usuario
	 * @return Boolean indica si existen o no más usuarios con el mismo grupo de trabajo
	 */
	public Boolean handleObtenerUsuariosGrupoTrabajo(Long id) throws Exception
	{
		try
		{
			Boolean resultado = Boolean.FALSE;
			List usuarios = this.getUsuarioDao().obtenerUsuariosPertenecenGrupoTrabajo(id);
			int numUsuarios = usuarios.size();
			if (numUsuarios > 0)
			{
				resultado = Boolean.TRUE;
			}
			return resultado;
		} catch (Exception e)
		{
			throw e;
		}
	}
	
	/**
	 * Recoge un literal del archivo properties adminusuarios.properties referenciando el codigo de
	 * dicho literal
	 * @param sKey codigo del literal
	 * @return String String con el literal
	 * @throws IOException
	 */
	private String getAdminUsuariosPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/adminusuarios.properties");
		if (this.pAdminUsuariosProperties == null)
		{
			pAdminUsuariosProperties = new java.util.Properties();
			pAdminUsuariosProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pAdminUsuariosProperties.getProperty(sKey);
	}
	
	
	/**
	 * Comprueba si el nombre que se le pasa por parámetro esta
	 * asociado a otro grupo de trabajo
	 * @param descripcion descripcion del grupo
	 * @param id identificador del grupo
	 * @return retorno String indicando si ha ido bien o no la operacion
	 * @throws Exception
	 */
	protected java.lang.Boolean handleExisteNombreTrabajo(java.lang.String nombre, java.lang.Long id) throws java.lang.Exception
	{
		Boolean retorno = new Boolean(false);
		GrupoTrabajoVO[] grupoTrabajoVO = null;
		
		if(log.isDebugEnabled())log.debug("Estoy antes de recoger los grupos de usuarios");
		
		Collection gruposTrabajo = this.getGrupoTrabajoDao().loadAll(GrupoTrabajoDao.TRANSFORM_GRUPOTRABAJOVO);
		grupoTrabajoVO = (GrupoTrabajoVO[]) gruposTrabajo.toArray(new GrupoTrabajoVO[0]);
		
		if(log.isDebugEnabled())log.debug("Estoy antes de comparar si el id es -1 (para alta) o no (para modificar)");
		
		if (id.compareTo(new Long("-1")) == 0)
		{

			if(log.isDebugEnabled())log.debug("Alta grupo trabajo - la descripcion no puede coincidir");
			for (int j = 0; j < grupoTrabajoVO.length; j++)
			{
				if (grupoTrabajoVO[j].getNombre().equalsIgnoreCase(nombre))
				{
					retorno = Boolean.TRUE;
				}
			}
		} 
		else
		{
			
			if(log.isDebugEnabled())log.debug("Modificar grupo trabajo - ni descripcion ni el id pueden coincidir");
			for (int j = 0; j < grupoTrabajoVO.length; j++)
			{
				if (grupoTrabajoVO[j].getNombre().equalsIgnoreCase(nombre))
				{
					if (grupoTrabajoVO[j].getIdentificador().compareTo(id) != 0)
					{
						retorno = Boolean.TRUE;
					}
				}
			}
		}
		if(log.isDebugEnabled())log.debug("Estoy antes de return");
		return retorno;
	}

	/**
	 * Obtiene los usuarios pasandole el openId
	 * @param openIdUrl el identificador del openId
	 * @return UsuarioVO el usuario que tiene ese openIdUrl
	 * @throws Exception
	 */
	protected UsuarioVO handleObtenerUsuarioConOpenId(java.lang.String openIdUrl) throws Exception {
		UsuarioVO usuari=new UsuarioVO();
		try{
			UsuarioDao usuario = this.getUsuarioDao();
			obtenerUsuarioPorOpenIdCriteria criteria=new obtenerUsuarioPorOpenIdCriteria();
			criteria.setOpenIdUrl(openIdUrl);
			List<UsuarioVO> usuarios=usuario.obtenerUsuariosPorOpenId(UsuarioDao.TRANSFORM_USUARIOVO, criteria);
			
			if(usuarios!=null && usuarios.size()>0){
				usuari=(UsuarioVO)usuarios.get(0);
			}else{
				usuari=null;
			}
		}catch(Exception e){
			log.error("Error al obtener los usuarios con el openId");
			throw e;
		}
		
		return usuari;
	}
	

}
