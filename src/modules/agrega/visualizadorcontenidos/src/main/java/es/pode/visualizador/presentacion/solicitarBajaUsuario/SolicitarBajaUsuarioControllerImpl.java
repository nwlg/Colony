/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.solicitarBajaUsuario;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.adminusuarios.negocio.servicios.UsuarioVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.solicitarBajaUsuario.SolicitarBajaUsuarioController
 */
public class SolicitarBajaUsuarioControllerImpl extends SolicitarBajaUsuarioController {

	private static Logger log = Logger.getLogger(SolicitarBajaUsuarioControllerImpl.class);

		
	/**
	 * @see es.pode.administracion.presentacion.adminusuarios.solicitarBajaUsuario.SolicitarBajaUsuarioController#enviarCorreoBaja(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.adminusuarios.solicitarBajaUsuario.EnviarCorreoBajaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void enviarCorreoBaja(ActionMapping mapping,
			es.pode.visualizador.presentacion.solicitarBajaUsuario.EnviarCorreoBajaForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	   	String usuario = LdapUserDetailsUtils.getUsuario();
		UsuarioVO usuarioSesion = this.getSrvAdminUsuariosService().obtenerDatosUsuario(usuario);
		String resultado = this.getSrvAdminUsuariosService().enviarCorreoBaja(usuarioSesion);
		log("El resultado del envio es " + resultado);
		form.setResultadoEnvio(resultado);
	}

	private void log(Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}

}