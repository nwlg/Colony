/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.verUsuarioPendiente;


import java.util.HashSet;
import java.util.Set;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.administracion.presentacion.adminusuarios.verUsuario.VerUsuarioControllerImpl;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.UsuarioVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.adminusuarios.verUsuarioPendiente.VerUsuarioPendienteController
 */
public class VerUsuarioPendienteControllerImpl extends VerUsuarioPendienteController
{


	private static Logger log = Logger
	.getLogger(VerUsuarioControllerImpl.class);




    /**
     * @see es.pode.administracion.presentacion.adminusuarios.verUsuarioPendiente.VerUsuarioPendienteController#recuperarUsuario(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.adminusuarios.verUsuarioPendiente.RecuperarUsuarioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarUsuario(ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.verUsuarioPendiente.RecuperarUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		
		try {
			
			Long id = Long.valueOf(request.getParameter("id"));
			log("Recupero los datos del usuario cuyo id es " + id);
			UsuarioVO usuario = this.getSrvAdminUsuariosService()
					.descripcionUsuario(id);
			form.setNombre(usuario.getNombre());
			form.setApellido1(usuario.getApellido1());
			form.setApellido2(usuario.getApellido2());
			form.setUsuario(usuario.getUsuario());
			form.setIdioma(usuario.getIdioma());
			form.setTipoEmpaquetador(usuario.getTipoEmpaquetador());
			form.setEmail(usuario.getEmail());
			form.setNIF(usuario.getNIF());
			form.setIdiomaBusqueda(usuario.getIdiomaBusqueda());
			form.setId(id);
			Set set = new HashSet();
			GrupoVO[] grupos = this.getSrvAdminUsuariosService()
					.descripcionUsuario(id).getGrupos();
			for (int i = 0; i < grupos.length; i++) {
				set.add(grupos[i]);
			}
			log("Tamanio de la lista de grupos del usuario seleccionado "
					+ set.size());
			form.setGrupos(set);
		} catch (Exception e) {
			log.error("Error: " + e);
			throw new ValidatorException("{verUsuario.error}");
		}
     }


	private void log(Object obj) {
		
		if (log.isDebugEnabled())
			log.debug(obj);
	}


}