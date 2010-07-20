/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.tesauros.listar;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.fuentestaxonomicas.negocio.servicio.TipoVdex;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.administracion.presentacion.estructuraseducativas.tesauros.listar.ListarTesaurosController
 */
public class ListarTesaurosControllerImpl extends ListarTesaurosController
{
	private static Logger logger=Logger.getLogger(ListarTesaurosControllerImpl.class);
	
	public void obtenerTesauros(
			ActionMapping mapping, 
			ObtenerTesaurosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		form.setIdiomaBuscador("02");
		try{
			String idiomaSelected = LdapUserDetailsUtils.getIdioma();
			I18n i18n = I18n.getInstance();
			LocalizacionIdiomaVO[] localizadorIdioma =(LocalizacionIdiomaVO[]) i18n.obtenerIdiomasPlataformaLocalizados(idiomaSelected);
			form.setIdiomaBuscadorBackingList(Arrays.asList(localizadorIdioma), "idLocalizacion", "nombre");
		}catch (Exception e) {
			logger.error("error en ListarTesaurosController.obtenerTesauros: obteniendo idiomas ");
		}
	    
		try{
		Collection tesauros=Arrays.asList(this.getSrvEstructurasEducativasService().listarTesauros());
		form.setTesauros(tesauros);
		}catch (Exception e) {
			logger.error("error en ListarTesaurosController.obtenerTesauros: obteniendo vdex  ");
		}
	}

	public void validarSeleccionados(
			ActionMapping mapping, 
			ValidarSeleccionadosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response)
	throws Exception 
	{
		if(form.getSeleccionadoRowSelection()==null || form.getSeleccionadoRowSelection().size()==0)
		{
			throw new ValidatorException("{estructuras.tesauros.error.seleccionados.vacios}");
		}
		
		this.getEstructurasSession(request).setVdexEliminar(form.getSeleccionadoRowSelectionAsArray());
	}

	
	
	public void exportarTesauro(
			ActionMapping mapping,
			ExportarTesauroForm form, 
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception 
	{
		final int BUFFER_SIZE = 2048;
		if(form.getNombre()!=null && !form.getNombre().equals(""))
		{
			DataHandler dh =null;
			try{
				dh = this.getSrvEstructurasEducativasService().exportarVdex(form.getNombre(), TipoVdex.TESAURO);
				if(dh!=null)
				{
			    	response.setContentType("text/xml;charset=utf-8");
			    	response.setHeader("Content-Disposition", "attachment;filename="+ form.getNombre());
			    	OutputStream out = response.getOutputStream();
			    	InputStream in = dh.getInputStream();
			    	logger.debug("Descargando metadata.xml");
					byte[] buffer = new byte[BUFFER_SIZE];
					int count;
					while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
					{
						out.write(buffer, 0, count);
					}
					out.flush();
					
				}else{
//					logger.error("Fichero  vacio. Abortamos descarga.");
//		    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
				}

			}catch (Exception e) {
				logger.debug("error en la llamada al servicio estructuras educativas " + e.getMessage());
			}
				
		}else{
			logger.debug("error al intentar exportar el tesauro seleccionado");
		}

	}


}