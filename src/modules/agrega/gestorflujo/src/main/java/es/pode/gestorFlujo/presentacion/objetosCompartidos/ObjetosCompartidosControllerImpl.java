/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;
import es.pode.gestorFlujo.presentacion.objetosPersonales.TransicionConTamainoVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.publicacion.negocio.servicios.TransicionAutorVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.ObjetosCompartidosController
 */
public class ObjetosCompartidosControllerImpl extends ObjetosCompartidosController
{

	private Logger logger = Logger.getLogger(ObjetosCompartidosController.class);




    /**
     * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.ObjetosCompartidosController#cargarODESCompartidos(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosCompartidos.CargarODESCompartidosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarODESCompartidos(ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosCompartidos.CargarODESCompartidosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
			if(logger.isDebugEnabled())
				logger.debug("Cargando objetos compartidos");
			SrvPublicacionService publi = this.getSrvPublicacionService();
			SrvLocalizadorService localizador=this.getSrvLocalizadorService();
			SrvAdminUsuariosService admin=this.getSrvAdminUsuariosService();
			TransicionAutorVO[] odes =null;
			try {
				
				String[] todosUsuariosGrupos=admin.obtenerListaUsuariosGrupoTrabajo(LdapUserDetailsUtils.getUsuario());
//				
//				String[] todosUsuariosGrupos=new String[] {LdapUserDetailsUtils.getUsuario()};
				if(todosUsuariosGrupos!=null && todosUsuariosGrupos.length>0){
					logger.info("Obtenidos lista de usuarios de los grupos pertenecientes de usuario:["+LdapUserDetailsUtils.getUsuario()+"Numero de usuarios:["+todosUsuariosGrupos.length);
					 odes = publi.obtenODEsCompartidosPorUsuarios(todosUsuariosGrupos);
					logger.info("Obtenidos odes de esos usuarios, numero de odes pendientes de publicacion ["+odes.length);
				}else{
					logger.info("Obtenidos lista de todos los ODES, pues el usuario:["+LdapUserDetailsUtils.getUsuario()+" es parte de todos los grupos");
					odes=publi.obtenODESCompartidos();
					logger.info("Obtenidos odes de todos los usuarios, numero de odes pendientes de publicacion["+odes.length);
				}
				
			} catch (Exception ex) {
				logger.error("Imposible obtener los odes pendientes de publicacion", ex);
				throw new ValidatorException("{gestorFlujo.error.inesperado}");
			}
			 
			if(odes !=null && odes.length>0){
				TransicionConTamainoVO[] odesTamaino=new TransicionConTamainoVO[odes.length];

				String[] identificadoresOdesCompartidos=new String[odes.length];
				if(logger.isDebugEnabled()){
					logger.debug("Entramos en el mapeo de "+ odes.length+ " elementos");
				}
				for(int i=0;i<odes.length;i++){
					
					TransicionConTamainoVO conTamaino=new TransicionConTamainoVO();
					if(logger.isDebugEnabled())logger.debug("Estamos en la posicion: "+i);
					
					
					conTamaino.setComentarios(odes[i].getComentarios());
					
					conTamaino.setFecha(odes[i].getFecha());
					
					conTamaino.setIdODE(odes[i].getIdODE());
					
					identificadoresOdesCompartidos[i]=odes[i].getIdODE();//Los guardamos para hacer la consulta al localizador
					conTamaino.setIdUsuario(odes[i].getIdUsuarioCreacion());//Nombre del creador!!!!!!!!!!!!
					conTamaino.setTitulo(odes[i].getTitulo());
					odesTamaino[i]=conTamaino;

				}
				Long[] tamainoOdes=null;
				if(identificadoresOdesCompartidos!=null && identificadoresOdesCompartidos.length>0){
					tamainoOdes=localizador.consultaEspacioLocalizadores(identificadoresOdesCompartidos);
				}
				for(int i=0;i<odes.length;i++){
//					Vamos a insertar le tamaino en MB,no en bytes; 
					double mb = (double)tamainoOdes[i]/(1024*1024);
					String pattern="###.##";
					java.text.DecimalFormat myFormatter = new java.text.DecimalFormat(pattern);
					String output = myFormatter.format(mb);
					odesTamaino[i].setTamaino(output);
					if(logger.isDebugEnabled())
						logger.debug("Tamaino del ODE compartido con id:"+odesTamaino[i].getIdODE()+ ", su div["+mb+"] y su tamaino es:"+output);
				}
				form.setListaODESAsArray(odesTamaino);
			}else{
				if(logger.isDebugEnabled())
					logger.debug("No tiene objetos compartidos");
				form.setListaODESAsArray(odes);
			}
		}catch(Exception e){
			logger.error("Error al obtener los objetos compartidos: " , e);
			throw new ValidatorException("{gestor.flujo.error.obtener.compartidos}");
		}
     }




}