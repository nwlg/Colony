/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.basico.anadirCarpetaPersonal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.entregar.negocio.servicios.PaquetePifDriVO;
import es.pode.entregar.negocio.servicios.SrvEntregarService;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.buscador.presentacion.basico.anadirCarpetaPersonal.AnadirCarpetaPersonalController
 */
public class AnadirCarpetaPersonalControllerImpl extends AnadirCarpetaPersonalController
{

	private java.util.Properties pSpringProperties = null;
	private static Logger logger = Logger.getLogger(AnadirCarpetaPersonalControllerImpl.class);
	
	private final static String MENSAJE_ERROR_ANADIR = "anadir.ode.carpeta.personal";
	private final static String MENSAJE_COMENTARIOS = "comentarios.anadir.ode";
	private final static String FICHERO = "application-resources";
	private final static String ERROR_EXCESO_CUOTA_DESCRIPCION = "error.anadir.ode.carpeta.personal.exceso.cuota";
	private final static String ERROR_DESCOMPRIMIENDO_FICHERO_ZIP_DESCRIPCION = "error.anadir.ode.carpeta.personal.fichero.zip";
	private final static String ERROR_COPIANDO_ESQUEMAS_DESCRIPCION = "error.anadir.ode.carpeta.personal.esquemas";
	private final static String ERROR_DE_VALIDACION_DESCRIPCION = "error.anadir.ode.carpeta.personal.validacion";
	
	public final static String SIN_ERRORES = "0.0";
	public final static String WARNINGS = "0.1";
	public final static String ERROR_DESCOMPRIMIENDO_FICHERO_ZIP = "10.14";
	public final static String ERROR_COPIANDO_ESQUEMAS = "10.15";
	public final static String ERROR_DE_VALIDACION = "10.16";	
	public final static String ERROR_EXCEDER = "10.17";

    /**
     * @see es.pode.buscador.presentacion.basico.anadirCarpetaPersonal.AnadirCarpetaPersonalController#anadirODECarpetaPersonal(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.anadirCarpetaPersonal.AnadirODECarpetaPersonalForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirODECarpetaPersonal(ActionMapping mapping, es.pode.buscador.presentacion.basico.anadirCarpetaPersonal.AnadirODECarpetaPersonalForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	ResultadoOperacionVO resultado = new ResultadoOperacionVO();
    	DataHandler data = null;
    	try{ 	
	    	/**
	    	 * *********************************************************************************************************************************
	    	 * **************************** SE OBTIENE EL PAQUETE PIF DEL SERVICIO ENTREGAR ****************************************************
	    	 * *********************************************************************************************************************************
	    	 * */
	    	log("AnadirCarpetaPersonalControllerImpl - anadirODECarpetaPersonal.");
	    	
	    	PaquetePifDriVO paquete = new PaquetePifDriVO();	    	
	    	form.setResultadoOperacion(new Boolean(true));
			log("anadirODECarpetaPersonal: anadir ODE con identificadorODE ["+form.getIdentificadorODE()+"]");
			SrvEntregarService entregarService = this.getSrvEntregarService();
			paquete = entregarService.generarPaquetePIF(form.getIdentificadorODE());
			data = paquete.getPaquetePIF();
			if (data == null || data.getInputStream() == null){
				form.setResultadoOperacion(new Boolean(false));
				logger.error("anadirODECarpetaPersonal ERROR: Error generando el fichero ZIP con identificador["+form.getIdentificadorODE()+"] error devuelto ResultadoValidacion="+paquete.getResultadoValidacion().getResultadoValidacion()+" Ruta manifest="+paquete.getResultadoValidacion().getRutaManifest()+" Es valido manifest="+paquete.getResultadoValidacion().getEsValidoManifest());
				saveErrorMessage(request,MENSAJE_ERROR_ANADIR);
			}
    			
			/**
	    	 * *********************************************************************************************************************************
	    	 * *************************************** SE LLAMA EL PUBLICADOR PARA AÑADIRLO ****************************************************
	    	 * *********************************************************************************************************************************
	    	 * */			
			
			log("anadirODECarpetaPersonal: anadir ODE con identificadorODE ["+form.getIdentificadorODE()+"]");		
			resultado = this.getSrvPublicacionService().crearPifConCuota(data, LdapUserDetailsUtils.getUsuario(), this.getPropertyValue(MENSAJE_COMENTARIOS), form.getIdentificadorODE()+ ".zip", form.getIdiomaODE());
					
			logger.info("resultado de la importacion de un ode:" + resultado);	
			
			if (!(SIN_ERRORES).equals(resultado.getIdResultado()) && !WARNINGS.equals(resultado.getIdResultado()))
			{
				//Hay cuatro posibles errores					
//					ERROR_DESCOMPRIMIENDO_FICHERO_ZIP
//					ERROR_COPIANDO_ESQUEMAS
//					ERROR_DE_VALIDACION	
//					ERROR_EXCEDER
				form.setResultadoOperacion(new Boolean(false));
				if (ERROR_DESCOMPRIMIENDO_FICHERO_ZIP.equals(resultado.getIdResultado()))
				{
					form.setDescripcionCodigoErroneo(this.getResource(ERROR_DESCOMPRIMIENDO_FICHERO_ZIP_DESCRIPCION, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
					resultado.setIdResultado(resultado.getIdResultado());
					resultado.setDescripcion("Excepción al añadir el ode a la carpeta personal. Error descomprimiendo zip");
					logger.error("Error al añadir el ode a la carpeta personal. Error descomprimiendo zip");						
				}
				else if (ERROR_COPIANDO_ESQUEMAS.equals(resultado.getIdResultado()))
				{
					form.setDescripcionCodigoErroneo(this.getResource(ERROR_COPIANDO_ESQUEMAS_DESCRIPCION, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
					resultado.setIdResultado(resultado.getIdResultado());
					resultado.setDescripcion("Excepción al añadir el ode a la carpeta personal. Error copiando esquemas");
					logger.error("Error al añadir el ode a la carpeta personal. Error copiando esquemas");						
				}
				else if (ERROR_DE_VALIDACION.equals(resultado.getIdResultado()))
				{
					form.setDescripcionCodigoErroneo(this.getResource(ERROR_DE_VALIDACION_DESCRIPCION, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
					resultado.setIdResultado(resultado.getIdResultado());
					resultado.setDescripcion("Excepción al añadir el ode a la carpeta personal. Error de validacion del ode");
					logger.error("Error al añadir el ode a la carpeta personal. Error de validacion del ode");						
				}
				else if (ERROR_EXCEDER.equals(resultado.getIdResultado()))
				{
					form.setDescripcionCodigoErroneo(this.getResource(ERROR_EXCESO_CUOTA_DESCRIPCION, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
					resultado.setIdResultado(resultado.getIdResultado());
					resultado.setDescripcion("Excepción al añadir el ode a la carpeta personal. Exceso de cuota");
					logger.error("Error al añadir el ode a la carpeta personal. Exceso de cuota");
				}							
					
			}				
		
		} catch (Exception e)
		{
//			 Si ha habido alguna excepción no controlada lo indicamos
			logger.error("anadirODECarpetaPersonal: Excepcion al importar el ode: ", e);
			form.setResultadoOperacion(new Boolean(false));
			form.setDescripcionCodigoErroneo("");
			resultado.setIdResultado("11.1");
			resultado.setDescripcion("Excepción al añadir el ode a la carpeta personal");
		}
    }
    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("anadirODECarpetaPersonal: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}    
    
    public static String getResource(String key, String baseName, Locale locale){
        String recurso = "";
        ResourceBundle theResourceBundle = getResource(baseName,locale);
        try{
        	if (theResourceBundle!=null){
               recurso = theResourceBundle.getString(key);
           }
        }catch (MissingResourceException mre){
        	recurso = key;
        }
        return recurso;
    }
    
    public static ResourceBundle getResource(String baseName, Locale locale){
        try{
        	return ResourceBundle.getBundle(baseName,locale);
            
        }catch (MissingResourceException mre){
        		locale = new Locale("","");
        		return ResourceBundle.getBundle(baseName,locale);
             
        }
    }

    private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}