/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.modificarRepositoriosExternos;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.repositoriosExternos.modificarNodoSQI.ModificarNodoSQIController
 */
public class ModificarNodoSQIControllerImpl extends ModificarNodoSQIController
{


	private static Logger logger = Logger.getLogger(ModificarNodoSQIControllerImpl.class);
	private static final String LENGUAJE_CONSULTA_VSQL="VSQL";
//	private static final String LENGUAJE_CONSULTA_QEL="QEL";//Seguramente seran solo VSQL y LOM (Corregir la validacion de alta)
//	private static final String LENGUAJE_CONSULTA_FIRE="FIRE";
	private static final String LENGUAJE_RESPUESTA_LOM="LOM";
//	private static final String LENGUAJE_RESPUESTA_RDF="RDF";
	private static final String LENGUAJE_RESPUESTA_LOMES="LOM-ES";



	public void cargarNodoSQI(ActionMapping mapping, CargarNodoSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
    		
    		Long id = new Long(request.getParameter("id"));
    		if (id == null){
    			throw new ValidatorException ("{errors.modificarnodoSQI.idNulo}");
    		}
    		Long[] ids=new Long[1];
    		if(logger.isDebugEnabled())
    			logger.debug("Estamos en cargarNodoSQI con id [ "+id+" ]");
    		ids[0]=id;
    		NodoSQIVO[] nodos = this.getSrvGestionSqiService().consultaNodosSQI(ids);
    		NodoSQIVO nodo=nodos[0];
    		form.setId(id);
    		form.setClave(nodo.getClave());
    		form.setDescripcionNodo(nodo.getDescripcionNodo());
    		form.setGestorSesion(nodo.getGestorSesion());
    		form.setIdentificadorSesion(nodo.getIdentificadorSesion());
    		form.setLenguajeConsulta(nodo.getLenguajeConsulta());
    		form.setLenguajeRespuesta(nodo.getLenguajeRespuesta());
    		form.setNombreNodo(nodo.getNombreNodo());
    		form.setUrlServicio(nodo.getUrlServicio());
    		form.setUsuario(nodo.getUsuario());
    		
    		
    	}catch (ValidatorException e){
    		logger.equals("Error al recuperar: " + e);
    		throw e;
    	}catch (Exception e){
    		logger.equals("Error al recuperar el nodoSQI: " + e);
    		throw e;
    	}
		
	}




	public void modificarNodoSQI(ActionMapping mapping, ModificarNodoSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try{
    		
    		
    		Long identificador=form.getId();
    		String nombreNodo=form.getNombreNodo();
    		String descripcionNodo=form.getDescripcionNodo();
    		String url=form.getUrlServicio();
    		String lenguajeConsulta=form.getLenguajeConsulta().toUpperCase();
    		String lenguajeRespuesta=form.getLenguajeRespuesta().toUpperCase();
    		String identificadorSesion=form.getIdentificadorSesion();
    		String usuario=form.getUsuario();
    		String clave=form.getClave();
    		String gestorSesion=form.getGestorSesion();
    		if(logger.isDebugEnabled())
    		logger.debug("Hemos recogidos los datos del formulario, nombreNodo:[" +nombreNodo+"], descripcionNodo:["+descripcionNodo+"],url:["+url+"], " +
    				"lenguajeConsulta:["+lenguajeConsulta+"],lenguajeRespuesta:["+lenguajeRespuesta+"],identificadorSesion:["+identificadorSesion+"], " +
    						"usuario:["+usuario+"], clave:["+clave+"] y gestorSesion:["+gestorSesion+"]");
    		
    		//Validacion
    		if(nombreNodo==null || nombreNodo.equals("")){
	        	logger.error("El nombre del nodo SQI es obligatorio ["+nombreNodo+"]");
				throw new ValidatorException("{errors.altanodoSQI.nombre}");
	        }
	        if(url==null || url.equals("")){
				logger.error("La URL del servicio es obligatorio ["+url+"]");
				throw new ValidatorException("{errors.altanodoSQI.url}");
			}
    		if(descripcionNodo==null || descripcionNodo.equals("")){
	        	logger.error("La descripcion del nodo SQI es obligatorio ["+descripcionNodo+"]");
				throw new ValidatorException("{errors.altanodoSQI.descripcion}");//Internacionalizar ( tambien en GestionSQI )
	        }
    		if(lenguajeConsulta !=null && !lenguajeConsulta.equals("")){
				if(!lenguajeConsulta.equalsIgnoreCase(LENGUAJE_CONSULTA_VSQL) ){
					logger.error("El lenguaje de consulta debe ser de tipo "+ LENGUAJE_CONSULTA_VSQL+ ",["+lenguajeConsulta+"]");
					throw new ValidatorException("{errors.altanodoSQI.lenguajeConsulta} "+ LENGUAJE_CONSULTA_VSQL);
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
				throw new ValidatorException("{errors.altanodoSQI.lenguajeRespuestaObliga}");
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

//    		cargamos el NodoSQIVO con los datos originales que tiene antes de modificarlo
			NodoSQIVO[] nodoCargado = new NodoSQIVO[1];
			NodoSQIVO nodo=new NodoSQIVO();
			nodo.setClave(clave);
			nodo.setDescripcionNodo(descripcionNodo);
			nodo.setGestorSesion(gestorSesion);
			nodo.setId(identificador);
			nodo.setIdentificadorSesion(identificadorSesion);
			nodo.setLenguajeConsulta(lenguajeConsulta);
			nodo.setLenguajeRespuesta(lenguajeRespuesta);
			nodo.setNombreNodo(nombreNodo);
			nodo.setUrlServicio(url);
			nodo.setUsuario(usuario);
			nodoCargado[0]=nodo;
			Long respuesta = this.getSrvGestionSqiService().modificarNodoSQI(nodoCargado[0]);
			form.setIdModificado(respuesta);
			if(logger.isDebugEnabled())
				logger.debug("Lo que ha devuelto es["+respuesta+"]");
			if(identificador.equals(respuesta)){
				form.setResultado("OK");
			}
			else{
				form.setResultado("FALLO");
			}
    	}catch (ValidatorException e)
		{
			throw e;
    	} catch (Exception e){
    		logger.error("Se ha producido un error al modificar el nodo: " + e);
    		throw new ValidatorException("{errors.modificarnodoSQI}");

    	}
		
	}









}