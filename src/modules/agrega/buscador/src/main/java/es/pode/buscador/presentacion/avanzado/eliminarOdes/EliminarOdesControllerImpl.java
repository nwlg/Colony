/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.eliminarOdes;

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscar.negocio.buscar.servicios.MetadatoBasicoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.buscador.presentacion.avanzado.eliminarOdes.EliminarOdesController
 */
public class EliminarOdesControllerImpl extends EliminarOdesController{
	
	private static final long serialVersionUID = -8190967967832345670L;
	private java.util.Properties pSpringProperties = null;
	Logger logger = Logger.getLogger(this.getClass());
	public final static String MENSAJE_RESULTADO_CORRECTO = "configurar.avanzado.texto.eliminarODE.resultadoCorrecto";
	public final static String MENSAJE_IDIOMAS_BUSQUEDA = "listar.odecu.mostrar.resultados.detalles.errorTraduccionTermino";
	public final static String ERROR_ELIMINANDO_ODES = "errors.odes.eliminar";
	public final static String ERROR_METADATOS = "errors.odes.metadatos";
	
	public final static String SIN_ERRORES = "0.0";

    /**
     * @see es.pode.buscador.presentacion.avanzado.eliminarOdes.EliminarOdesController#obtenerIdiomas(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.eliminarOdes.ObtenerIdiomasForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerIdiomas(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.eliminarOdes.ObtenerIdiomasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		log("EliminarOdesControllerImpl - obtenerIdiomas.");
    		if (LdapUserDetailsUtils.esAdministrador()){
				form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
		        if(form.getListaIds()!=null && !form.getListaIds().equals("")){
    		        String listIDs=form.getListaIds();
    		        String[] arrayListaIDs=(listIDs.split(BuscarAvanzadoControllerImpl.ANDPERSAND));
    		        form.setSeleccionado("CON_RESULTADOS");
    		        try{
    		        	MetadatoBasicoVO[] metadatoAux=new MetadatoBasicoVO[arrayListaIDs.length];
	    		        metadatoAux=listarMetadatos(arrayListaIDs,form.getIdioma());
	    		        form.setOdesAsArray(metadatoAux);
    		        }catch (Exception e){
    		        	logger.error("Error al obtener los metadatos",e);
    			    	saveErrorMessage(request, ERROR_METADATOS);
					}
		        }else{
		        	form.setSeleccionado("SIN_RESULTADOS");
		        	saveErrorMessage(request, ERROR_ELIMINANDO_ODES);
		        }
    		}else{
				logger.error("EliminarOdesControllerImpl - obtenerIdiomas: No tiene permisos para eliminar ODEs");
				saveErrorMessage(request, BuscarAvanzadoControllerImpl.MENSAJE_USUARIO_NO_LOGADO);
			}
		}catch(Exception e){
			logger.error("EliminarOdesControllerImpl - obtenerIdiomas: Error al intentar eliminar los ODEs seleccionados",e);
			saveErrorMessage(request, BuscarAvanzadoControllerImpl.MENSAJE_ERROR_ELIMINAR_ODE);
		}
     }
    
    private  MetadatoBasicoVO[] listarMetadatos(String[] ids,String idioma) throws RemoteException, Exception
	{
    	MetadatoBasicoVO[] metadatos= new MetadatoBasicoVO[ids.length];
    	for(int i=0; i<ids.length;i++){
	    	ParametroMetadatoVO parametroMetadato = new ParametroMetadatoVO(ids[i],idioma,"");
	    	metadatos[i] = this.getSrvBuscarService().solicitarMetadato(parametroMetadato);
    	}
		return metadatos;
	}

    /**
     * @see es.pode.buscador.presentacion.avanzado.eliminarOdes.EliminarOdesController#eliminarOdes(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.eliminarOdes.EliminarOdesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarOdes(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.eliminarOdes.EliminarOdesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("EliminarOdesControllerImpl - eliminarOdes.");
    	try{
    		if (LdapUserDetailsUtils.esAdministrador())
    		{
    			if (form.getListaIds()!=null && !form.getListaIds().equals("")){
    				log("EliminarOdesControllerImpl - eliminarOdes: Es administrador");
					String[] identificadores = form.getListaIds().split(BuscarAvanzadoControllerImpl.ANDPERSAND);
					MetadatoBasicoVO[] metadatoAux=new MetadatoBasicoVO[identificadores.length];
    		        metadatoAux=listarMetadatos(identificadores, form.getIdioma());
    		        form.setOdesDeletedAsArray(metadatoAux);
					for (int k=0;k<identificadores.length;k++){				
						String idODE= identificadores [k];
						String titulo=metadatoAux[k].getTitulo();
						log("EliminarOdesControllerImpl - eliminarOdes: idODE: " + idODE + "   Titulo: " + titulo);
						String comentarios=this.getResource(MENSAJE_RESULTADO_CORRECTO, BuscarAvanzadoControllerImpl.APPLICATION_PROPERTIES, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
						String usuario = LdapUserDetailsUtils.getUsuario();
						ResultadoOperacionVO resultado = this.getSrvPublicacionService().noDisponible(idODE, usuario, comentarios, titulo);
						if (SIN_ERRORES.equals(resultado.getIdResultado()))
						{							
							log("BuscarAvanzadoControllerImpl - eliminarOdes: ODE eliminado correctamente");
							this.getSrvBuscarService().borrarHitCache(form.getIdHits());
						}else
							saveErrorMessage(request, "ERROR_ELIMINANDO_ODES");
					}
    			}else{
    				saveErrorMessage(request, "ERROR_ELIMINANDO_ODES");
    			}
			}else{
				logger.error("EliminarOdesControllerImpl - eliminarOdes: No tiene permisos para eliminar ODEs");
				saveErrorMessage(request, BuscarAvanzadoControllerImpl.MENSAJE_USUARIO_NO_LOGADO);
			}
		}
    	catch(Exception e)
    	{
			logger.error("EliminarOdesControllerImpl - eliminarOdes: Error al intentar eliminar los ODEs seleccionados",e);
			saveErrorMessage(request, BuscarAvanzadoControllerImpl.MENSAJE_ERROR_ELIMINAR_ODE);
		}
    	
     }

	public static String getResource(String key, String baseName, Locale locale){
        String recurso = "";
        try{
           ResourceBundle theResourceBundle = ResourceBundle.getBundle(baseName,locale);
           if (theResourceBundle!=null){
                       recurso = theResourceBundle.getString(key);
           }
        }catch (MissingResourceException mre){
        	try{
	        	ResourceBundle theResourceBundle = ResourceBundle.getBundle(baseName);
	            if (theResourceBundle!=null){
	                 recurso = theResourceBundle.getString(key);
	            }
        	 }catch (MissingResourceException m){
        		 recurso = key;
        	 }
        }
        return recurso;
    }
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}