/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.bajaUsuario;

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;
import es.pode.adminusuarios.negocio.servicios.UsuarioVO;
import es.pode.adminusuarios.negocio.servicios.ValidaBajaUsuarioVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioController
 */
public class BajaUsuarioControllerImpl extends BajaUsuarioController {

    private static Logger log = Logger.getLogger(BajaUsuarioControllerImpl.class);

    /**
         * @see es.pode.admainistracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioController#obtenerIdiomas(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.bajaUsuario.ObtenerIdiomasForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void obtenerIdiomas(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.bajaUsuario.ObtenerIdiomasForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
		try {
	
		   
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		    Iterator iter = (form.getIds()).iterator();
		    UsuarioVO[] usuarios = new UsuarioVO[form.getIds().size()];
		    int i = 0;
		    String listaId = "";
		    while (iter.hasNext()) {
	
			Long id = new Long((String) iter.next());
			listaId = listaId + id.toString() + " ";
	
			UsuarioVO usuarioVO = srvAdminUsuariosService.descripcionUsuario(id);
			usuarios[i] = usuarioVO;
			i = i + 1;
		    }
		    form.setListaId(listaId.trim());
		    form.setUsuarios(usuarios);
	
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{errors.borrarUsuario}");
		}

    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioController#bajaUsuario(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void bajaUsuario(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    
		String listaId = request.getParameter("listaId");
		if(log.isDebugEnabled())log.debug("los ids de usuario que se quieren eliminar son " + listaId);
		Object[] objeto = listaId.split(" ");
	
		ResourceBundle ficheroRecursos = null;
		try {
		    
		    String login = LdapUserDetailsUtils.getLogin();
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		    UsuarioVO emailAdmin = srvAdminUsuariosService.obtenerDatosUsuario(login);
		    ValidaBajaUsuarioVO validaBaja = srvAdminUsuariosService.bajaUsuario(obtenerIds(objeto), emailAdmin);
		    Locale locale = request.getLocale();
		    ficheroRecursos = this.getFicherRecursos(locale);
		    form.setUsuariosDeleted(validaBaja.getItemsDeleted());
		    form.setDescripcionBaja(ficheroRecursos.getString(validaBaja.getDescripcion()));
		    form.setUsuariosDeleted(validaBaja.getItemsDeleted());
	
		} catch (Exception e) {
		    log.error("Se ha producido un error al eliminar el usuario " + e);
		    throw new ValidatorException("{errors.borrarUsuario}");
		}

    }


    private Long[] obtenerIds(Object[] id) {
    	
		Long[] resultado = new Long[id.length];
		for (int i = 0; i < id.length; i++) {
		    resultado[i] = new Long((String) id[i]);
		}
		return resultado;
    }

    private ResourceBundle getFicherRecursos(Locale locale) {
    	
		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
    }
}