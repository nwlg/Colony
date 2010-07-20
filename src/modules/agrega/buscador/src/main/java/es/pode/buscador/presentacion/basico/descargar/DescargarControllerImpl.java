/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.basico.descargar;

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.BuscarSession;
import es.pode.entregar.negocio.servicios.PaquetePifVO;
import es.pode.entregar.negocio.servicios.SrvEntregarService;
import es.pode.entregar.negocio.servicios.TipoPifVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.buscador.presentacion.basico.descargar.DescargarController
 */
public class DescargarControllerImpl extends DescargarController
{

	private java.util.Properties pSpringProperties = null;

	private static Logger logger = Logger.getLogger(DescargarControllerImpl.class);

	private final static String MENSAJE_ERROR_DESCARGA = "descargar.odecu.errorDescargandoFicheros";
	
    private static final int BUFFER_SIZE = 2048;
    
    public final static String FORMATO_POR_DEFECTO = "descargar.formatos.CONTENIDOS_VALUE";

	/**
     * @see es.pode.buscador.presentacion.basico.descargar.DescargarController#descargarFicheroODE(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.descargar.DescargarFicheroODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void descargarFicheroODE(ActionMapping mapping, es.pode.buscador.presentacion.basico.descargar.DescargarFicheroODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception

    {
    	log("DescargarControllerImpl - descargarFicheroODE");
	    PaquetePifVO resultadoEntregar = new PaquetePifVO();	
	//     REALIZAMOS EL TRATAMIENTO DE LOS LITERALES PARA PODER INTRODUCIRLOS EN EL CÓDIGO HTML
	
	    try{	
	    String literalFormato = getPropertyValue(form.getFormato());	
	    log("DescargarControllerImpl - descargarFicheroODE: Descargar ODE con identificadorODE ["+form.getIdentificadorODE()+"] y formato["+literalFormato+"]");	
	    
	    SrvEntregarService entregarService = this.getSrvEntregarService();	
	    resultadoEntregar = entregarService.generarPaquetePIFTipoPIF(new TipoPifVO(form.getIdentificadorODE(), literalFormato, form.getIdioma()));
	    log("DescargarControllerImpl - descargarFicheroODE: URL a descargar=["+resultadoEntregar.getHref()+"] del ODE=["+form.getTitulo()+"]");	
	    String titulo = (form.getTitulo()!=null)?form.getTitulo().trim().replaceAll(" ", "_"):form.getIdentificadorODE();	
	    response.setContentType("application/zip");	
	    response.setHeader("Content-Disposition", "attachment;filename="+titulo+".zip");	
	    response.setHeader("Cache-Control", "public");	
	    response.addDateHeader("Expires", System.currentTimeMillis()+(24*60*60*1000));	
	    response.sendRedirect("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+resultadoEntregar.getHref());	
	
	    }catch (Exception e){	
		    logger.error("DescargarControllerImpl - descargarFicheroODE ERROR: Error generando el fichero ZIP con identificador["+form.getIdentificadorODE()+"] error devuelto ResultadoValidacion="+resultadoEntregar.getResultadoValidacion().getResultadoValidacion()+" Ruta manifest="+resultadoEntregar.getResultadoValidacion().getRutaManifest()+" Es valido manifest="+resultadoEntregar.getResultadoValidacion().getEsValidoManifest());	
		    logger.error("DescargarControllerImpl - DescargarFicheroODE ERROR: Error al descargar el fichero del ODE",e);	
		    saveErrorMessage(request,MENSAJE_ERROR_DESCARGA);	
	    }
    }

	/* (non-Javadoc)
	 * @see es.pode.buscador.presentacion.basico.descargar.DescargarController#cargarTiposFormato(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.descargar.CargarTiposFormatoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void cargarTiposFormato(ActionMapping mapping, CargarTiposFormatoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			//TODO Este metodo tiene que preguntar al servicio de entregar los formatos que tiene disponibles para la
//			descarga de ODEs
			String idioma = "";
			try{
				idioma=LdapUserDetailsUtils.getIdioma();
				if (idioma == null)	idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			} catch (Exception e) {
				logger.error("DescargarControllerImpl - cargarTiposFormato: Error en al obtener idioma usuario LDAP, se recoge idioma de fichero propiedades.");
				idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}
			//Recuperamos el valor del titulo de la sesion
			BuscarSession sesion = this.getBuscarSession(request);
			if (sesion == null) {
				BuscarSession session = new BuscarSession();
				this.setBuscarSession(request, session);
				log("Sesion de busqueda creada en busqueda avanzada. La sesion estaba vacia.");
			}
			form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
			form.setTitulo(sesion.getTitulo());
			form.setFormato(FORMATO_POR_DEFECTO);
		}catch (Exception e){
			logger.error("DescargarControllerImpl - cargarTiposFormato ERROR: Error al cargar los tipos del formato",e);
		}
	}

	private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream(
				"/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		this.logger.debug("Propiedad recuperada: " + sKey + " : "
				+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}