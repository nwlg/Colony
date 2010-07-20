/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.exportar;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.entregar.negocio.servicios.PaquetePifVO;
import es.pode.entregar.negocio.servicios.SrvEntregarService;
import es.pode.entregar.negocio.servicios.TipoPifVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController
 */
public class ExportarControllerImpl extends ExportarController {

	private Logger logger = Logger.getLogger(ExportarControllerImpl.class);
	private final String SPLITTER = ";";
	private final String mal = "mal";
	private final String bien = "bien";

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController#exportaODEFichero(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportaODEFicheroForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final String exportaODEFichero(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportaODEFicheroForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SrvEntregarService entregar = this.getSrvEntregarService();

		// para esta entrega todavía no se utilizan el tipo de formato, pero ya lo tenemos hecho
		// para cuando sea necesario aquí y en el jsp (a fuego)
		//entregar.generarPaquetePIFTipoPIF(form.getIdODE(), form.getFormatoExportacion());

		final int BUFFER_SIZE = 2048;
		
		PaquetePifVO resultadoEntregar=null; 
		try {
			if(logger.isDebugEnabled())
			logger.debug("Generando paquete pif tipo: " + form.getFormatoExportacion() + " de ide ode: "
					+ form.getIdODE());
			TipoPifVO tpifVO = new TipoPifVO();
			tpifVO.setIdODE(form.getIdODE());
			tpifVO.setTipoPif(form.getFormatoExportacion());
			resultadoEntregar = entregar.generarPaquetePIFTipoPIF(tpifVO);

		} catch (Exception ex) {
			logger
					.error("Error en la obtencion del fichero ZIP del ODE con identificadorODE[" + form.getIdODE()
							+ "] ");
			logger.error(ex);
			throw new ValidatorException("{gestorFlujo.error.exportar.descargar}");
		}

		
		if (!resultadoEntregar.getResultadoValidacion().getEsValidoManifest().booleanValue())
		{
			form.setMensajes(resultadoEntregar.getResultadoValidacion().getResultadoValidacion().substring(0,resultadoEntregar.getResultadoValidacion().getResultadoValidacion().length()-2).split(SPLITTER));
			form.setHref(resultadoEntregar.getHref());
			return mal;
		}
		if (resultadoEntregar.getHref() == null) {//Nos devuelve el href de donde se encuentra el objeto
			logger
					.error("Fichero ZIP del ODE con identificadorODE[" + form.getIdODE()
							+ "] vacio. Abortamos descarga.");
			throw new ValidatorException("{gestorFlujo.error.exportar.descargar}");
		}
		
		response.sendRedirect("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/"+resultadoEntregar.getHref());//Redireccionamos la URL que nos ha llegado

//		// asignamos el titulo del ode al nombre del archivo a descargar.
//		
//		response.setContentType("application/zip");
//		response.setHeader("Content-Disposition", "attachment;filename=" + form.getTitulo().trim().replace(' ', '_')
//				+ ".zip");
//		OutputStream out = response.getOutputStream();
//		InputStream in = resultadoEntregar.getPaquetePIF().getInputStream();
//		logger.debug("Descargando ODE con identificadorODE [" + form.getIdODE() + "] y nombre[" + resultadoEntregar.getPaquetePIF().getName()
//				+ " - " + form.getTitulo() + "]");
//		byte[] buffer = new byte[BUFFER_SIZE];
//		int count;
//		while ((count = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
//			out.write(buffer, 0, count);
//		}
//
//		out.flush();
//		out.close();
//		logger.info("Descargando ODE con identificadorODE [" + form.getIdODE() + "] y nombre[" + resultadoEntregar.getPaquetePIF().getName()
//				+ " - " + form.getTitulo() + "]");
//		
//		
//		//Devolvemos el resultado de validacion para el punto de decision
		
		return bien;

	}

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController#cargarFormatosExportacion(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.CargarFormatosExportacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void cargarFormatosExportacion(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.CargarFormatosExportacionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("cargando formatos de exportacion para ode: " + form.getIdODE() + "de titulo: " + form.getTitulo());
	}

}