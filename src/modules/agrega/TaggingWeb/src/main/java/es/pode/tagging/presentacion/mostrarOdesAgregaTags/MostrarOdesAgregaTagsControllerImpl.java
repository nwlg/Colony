/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.tagging.presentacion.mostrarOdesAgregaTags;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.tagging.negocio.servicios.TaggingVO;
import es.pode.tagging.presentacion.TaggingSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.tagging.presentacion.mostrarOdesAgregaTags.MostrarOdesAgregaTagsController
 */
public class MostrarOdesAgregaTagsControllerImpl extends MostrarOdesAgregaTagsController
{

	public static final String NEUTRO = "neutro";
	public static final String LAYOUT_NEUTRO = "NEUTRO";
	public static final String TRUE = "true";

	protected static Logger logger = Logger.getLogger(MostrarOdesAgregaTagsControllerImpl.class); 



    /**
     * @see es.pode.tagging.presentacion.mostrarOdesAgregaTags.MostrarOdesAgregaTagsController#obtenerOdesTag(org.apache.struts.action.ActionMapping, es.pode.tagging.presentacion.mostrarOdesAgregaTags.ObtenerOdesTagForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerOdesTag(ActionMapping mapping, es.pode.tagging.presentacion.mostrarOdesAgregaTags.ObtenerOdesTagForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		TaggingSession taggingSession =  this.getTaggingSession(request);
    	if(taggingSession!=null){
    		String usuario = taggingSession.getUsuario();
    		if (usuario!=null) 
    			form.setEsAnonimo(false);// usuario conocido (esta autenticado)
    		else {
    			
    			//Comprobamos si seguimos autenticados si seguimos autenticados
    			//recuperamos el usuario de ldap y lo metemos en sesion
    			logger.debug("OBTENIENDO USUARIO: " +usuario);
    			try{
    				usuario = LdapUserDetailsUtils.getUsuario();
    				logger.debug("USUARIO CONOCIDO: " + usuario);
    			}
    			catch(Exception ad){
    				logger.debug("USUARIO ANONIMO");
    			}
    			taggingSession.setUsuario(usuario);
    			
    			if(usuario!=null)
    				form.setEsAnonimo(false);// usuario conocido (esta autenticado)
    			else
    				form.setEsAnonimo(true);// usuario anonimo
    		}
    				
    		String tag = form.getTag();

    		TaggingVO[] odes =null;
    		if(tag !=null && !tag.equals(""))
    		{
    			taggingSession.setTagPaginacion(tag);
    		}
    		if(taggingSession.getTagPaginacion()!=null && !taggingSession.getTagPaginacion().equals(""))
    		{
    			logger.info("Obteniendo ODES con TAG:" + taggingSession.getTagPaginacion());
    			odes = this.getSrvTaggingServer().obtenerOdesDeTag(taggingSession.getTagPaginacion());
    		}
    		
    		form.setOdesAsArray(odes);
        }
    	else 
    		form.setEsAnonimo(true);
    	
    	//si la peticion viene del nodo neutro mostrarmos el layout-sinlateral(layout del nodo neutro)
    	if(this.TRUE.equals(AgregaPropertiesImpl.getInstance().getProperty(this.NEUTRO)))
    		form.setTipoLayoutBuscador(this.LAYOUT_NEUTRO);
    	
     }









}