/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.basico.listar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;



/**
 * @see es.pode.buscador.presentacion.basico.listar.ListarController
 */
public class ListarControllerImpl extends ListarController
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8488797616127926807L;
	
	private java.util.Properties pSpringProperties = null;
	public static final String LOCALE_KEY = "org.apache.struts.action.LOCALE";
	private static Logger logger = Logger.getLogger(ListarControllerImpl.class);
	
	
	public void prepararConsulta(ActionMapping mapping, PrepararConsultaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			log("ListarControllerImpl - prepararConsulta.");
			form.setBuscadorContenido(form.getBuscadorGeneral());
	    	form.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSCAR_SIMPLE);
	    	try{
		    	if(DetallarControllerImpl.TRUE.equals((String)AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO))) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_NEUTRO);
		    	else form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
	    	}catch(Exception e){
	    		log("Error recuperando la propiedad neutro del agregaProperties");
	    		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
	    	}
	    	this.setBuscarSession(request, new BuscarSession());
		} catch (Exception ex) {
     		logger.error("ListarControllerImpl - prepararConsulta ERROR:",ex);
			saveErrorMessage(request,BuscarAvanzadoControllerImpl.MENSAJE_GENERICO_BUSQUEDA);
		}
	}
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}