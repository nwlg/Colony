/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIController
 */
public class AltaNodoSQIControllerImpl extends AltaNodoSQIController
{


	private static Logger logger = Logger.getLogger(AltaNodoSQIControllerImpl.class);
	private static final String LENGUAJE_CONSULTA_VSQL="VSQL";
//	private static final String LENGUAJE_CONSULTA_QEL="QEL";//Seguramente seran solo VSQL y LOM (Corregir la validacion de alta)
//	private static final String LENGUAJE_CONSULTA_FIRE="FIRE";
	private static final String LENGUAJE_RESPUESTA_LOM="LOM";
//	private static final String LENGUAJE_RESPUESTA_RDF="RDF";
	private static final String LENGUAJE_RESPUESTA_LOMES="LOM-ES";


    /**
     * @see es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIController#altaNodoSQI(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void altaNodoSQI(ActionMapping mapping, es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
	        NodoSQIVO nodo=new NodoSQIVO();
	        String clave=form.getClave();
	        String descripcionNodo=form.getDescripcionNodo();
	        String gestorSesion=form.getGestorSesion();
	        Long id=form.getId();
	        String identificadorSesion=form.getIdentificadorSesion();
	        String lenguajeConsulta=form.getLenguajeConsulta().toUpperCase();
	        String lenguajeRespuesta=form.getLenguajeRespuesta().toUpperCase();
	        String nombreNodo=form.getNombreNodo();
	        String url=form.getUrlServicio();
	        String usuario=form.getUsuario();
	        //Validacion del NODO
	        if(nombreNodo==null || nombreNodo.equals("")){
	        	logger.error("El nombre del nodo SQI es obligatorio ["+nombreNodo+"]");
				throw new ValidatorException("{errors.altanodoSQI.nombre}");//Internacionalizar ( tambien en GestionSQI )
	        }
	        if(url==null || url.equals("")){
				logger.error("La URL del servicio es obligatorio ["+url+"]");
				throw new ValidatorException("{errors.altanodoSQI.url}");
			}
	        if(descripcionNodo==null || descripcionNodo.equals("")){
	        	logger.error("La descripcion del nodo SQI es obligatorio ["+descripcionNodo+"]");
				throw new ValidatorException("{errors.altanodoSQI.descripcion}");
	        }
	        if(lenguajeConsulta !=null && !lenguajeConsulta.equals("")){
				if(!lenguajeConsulta.equalsIgnoreCase(LENGUAJE_CONSULTA_VSQL) ){
					logger.error("El lenguaje de consulta debe ser de tipo "+ LENGUAJE_CONSULTA_VSQL+ ", ["+lenguajeConsulta+"]");
					throw new ValidatorException("{errors.altanodoSQI.lenguajeConsulta} ");
				}
			}else{
				logger.error("El lenguaje de consulta es obligatorio ["+lenguajeConsulta+"]");
				throw new ValidatorException("{errors.altanodoSQI.lenguajeConsultaObliga}");
			}
			if(lenguajeRespuesta !=null && !lenguajeRespuesta.equals("")){
				if(!lenguajeRespuesta.equalsIgnoreCase(LENGUAJE_RESPUESTA_LOM)&&!lenguajeRespuesta.equalsIgnoreCase(LENGUAJE_RESPUESTA_LOMES) ){
					logger.error("El lenguaje de respuesta debe ser de tipo "+ LENGUAJE_RESPUESTA_LOM+ "o tipo "+LENGUAJE_RESPUESTA_LOMES+"["+lenguajeRespuesta+"]");
					throw new ValidatorException("{errors.altanodoSQI.lenguajeRespuesta} ");
				}
			}else{
				logger.error("El lenguaje de respuesta es obligatorio ["+lenguajeRespuesta+"]");
				throw new ValidatorException("{errors.altanodoSQI.lenguajeConsultaObliga}");
			}
	       
			if(identificadorSesion==null || identificadorSesion.equals("")){
				if(gestorSesion==null || gestorSesion.equals("")){
					logger.error("La URL del gestor de sesiones o el identificador de la sesion es obligatorio, identificadorSesion ["+identificadorSesion+"] el gestor de sesiones ["+gestorSesion+"]");
					throw new ValidatorException("{errors.altanodoSQI.identiGestor}");
				}
			}
			
			if(usuario!=null && !usuario.equals("")){
				if(clave==null || clave.equals("")){
					logger.error("Si existe usuario,"+usuario+", es obligatoria la clave ["+clave+"]");
					throw new ValidatorException("{errors.altanodoSQI.usuarioClave}");
				}
			}
			if(clave!=null && !clave.equals("")){
				if(usuario==null || usuario.equals("")){
					logger.error("Si existe clave,"+clave+", es obligatorio el usuario ["+usuario+"]");
					throw new ValidatorException("{errors.altanodoSQI.claveUsuario}");
				}
			}
			nodo.setClave(clave);
			nodo.setDescripcionNodo(descripcionNodo);
			nodo.setGestorSesion(gestorSesion);
			nodo.setId(id);
			nodo.setIdentificadorSesion(identificadorSesion);
			nodo.setLenguajeConsulta(lenguajeConsulta);
			nodo.setLenguajeRespuesta(lenguajeRespuesta);
			nodo.setNombreNodo(nombreNodo);
			nodo.setUrlServicio(url);
			nodo.setUsuario(usuario);
			
			Long identificador=this.getSrvGestionSqiService().altaNodoSQI(nodo);
			form.setIdModificado(identificador);
    	}catch (ValidatorException e)
		{
			throw e;
		} 
		catch (Exception e)
		{
			logger.error("Error!! " + e);
			throw new ValidatorException("{errors.altanodoSQI}");
		}
     }









}