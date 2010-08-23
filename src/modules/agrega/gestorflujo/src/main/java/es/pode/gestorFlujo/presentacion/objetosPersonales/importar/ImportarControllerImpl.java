/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importar;

import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePartDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.pode.gestorFlujo.presentacion.objetosPersonales.ResultadoImportacion;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarController
 */
public class ImportarControllerImpl extends ImportarController {

	private Logger logger = Logger.getLogger(ImportarController.class);
	private final String splitter = ";";
	private final String RESULTADO_NO = String.valueOf(false);
	private final String RESULTADO_SI = String.valueOf(true);

	private ResultadoOperacionVO importarUnODE(FormFile fichero, String nombreFichero, String idioma) throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("Importando un ode");
		ResultadoOperacionVO resultado = new ResultadoOperacionVO();
		SrvPublicacionService publi = this.getSrvPublicacionService();

		// preparamos el formfile que hemos recibido y lo metemos con nuestra astuta técnica  de formfiles

		InternetHeaders ih = new InternetHeaders();
		MimeBodyPart mbp = new MimeBodyPart(ih, fichero.getFileData());

		DataSource dsource = new MimePartDataSource(mbp);
		DataHandler dFichero = new DataHandler(dsource);

		try {
			resultado = publi.crearPifConCuota(dFichero, LdapUserDetailsUtils.getUsuario(),fichero.getFileName(),
					nombreFichero, idioma);
			logger.info("resultado de la importacion de un ode:" + resultado);
		} catch (Exception ex) {
			// Si ha habido alguna excepción no controlada lo indicamos
			resultado.setIdResultado("11.1");
			resultado.setDescripcion("Excepción al importar");
			logger.error("Excepcion al importar el ode: " + fichero.getFileName(), ex);
		}

		return resultado;
	}
	
	class CurrentState {
		ArrayList<ResultadoImportacion> resultado;
		Long diferencia;
		int nr_archivos_subidos;
		String archivosSubidos;
		boolean hemoshechoalgo;
		
	}

	/**
	 * @throws ValidatorException 
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarController#importarODE(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void importarODE(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarODEForm form,
			HttpServletRequest request, HttpServletResponse response) throws ValidatorException {
//		ResultadoOperacionVO unResultado = new ResultadoOperacionVO();
		int nr_archivos_subidos = 0;
		String archivosSubidos = new String("(");
		boolean hemoshechoalgo = false;
//		Long diferencia=new Long(0);
		Long diferencia=form.getEspacioLibre();
		ArrayList<ResultadoImportacion> resultado = new ArrayList<ResultadoImportacion>();
		
		//Wrapping
		CurrentState estadoActual= new CurrentState();
		//TODO Fusionar declaraciones anteriores con asignación actual
		estadoActual.diferencia=diferencia;
		estadoActual.resultado=resultado;
		estadoActual.archivosSubidos=archivosSubidos;
		estadoActual.nr_archivos_subidos=nr_archivos_subidos;
		estadoActual.hemoshechoalgo=hemoshechoalgo;
		

		logger.debug("Importando odes");
		// comprobamos las 5 cajas:

		FormFile formFile=form.getFicheroODE1();
		String caja="caja 1";
		String odeOrder="primer";
		comprobarFormFile(form, request, estadoActual, formFile, caja, odeOrder);
		
		formFile=form.getFicheroODE2();
		caja="caja 2";
		odeOrder="segundo";
		comprobarFormFile(form, request, estadoActual, formFile, caja, odeOrder);
		
		formFile=form.getFicheroODE3();
		caja="caja 3";
		odeOrder="tercer";
		comprobarFormFile(form, request, estadoActual, formFile, caja, odeOrder);
		
		formFile=form.getFicheroODE4();
		caja="caja 4";
		odeOrder="cuarto";
		comprobarFormFile(form, request, estadoActual, formFile, caja, odeOrder);
		
		formFile = form.getFicheroODE5();
		caja="caja 5";
		odeOrder="quinto";
		comprobarFormFile(form, request, estadoActual, formFile, caja, odeOrder);

		//Unwrapping
		resultado=estadoActual.resultado;
		archivosSubidos=estadoActual.archivosSubidos;
		nr_archivos_subidos=estadoActual.nr_archivos_subidos;
		hemoshechoalgo=estadoActual.hemoshechoalgo;
		
		// si no hemos importado nada mostramos mensajito de información:
		if (!hemoshechoalgo) {
			logger.warn("Formfile sin longitud ");
			throw new ValidatorException("{gestorFlujo.error.vacio}");
		}
		logger.debug("ArchivosSubidos: " + archivosSubidos);
		if (nr_archivos_subidos > 0) {
			logger.info("Se han importado correctamente los archivos: " + archivosSubidos);
			if (archivosSubidos.endsWith(",")) {
				archivosSubidos = (String) archivosSubidos.subSequence(0, archivosSubidos.length() - 1);
				archivosSubidos = nr_archivos_subidos + ": " + archivosSubidos;
				archivosSubidos = archivosSubidos + ")";
			}
			
//			saveSuccessMessage(request, "gestorFlujo.importar.importados", new String[] { archivosSubidos });
		}
		form.setResultado(resultado);
 
	}

	/**
	 * @param form
	 * @param request
	 * @param estadoActual
	 * @param formFile
	 * @param caja
	 * @param odeOrder
	 * @throws ValidatorException
	 */
	private void comprobarFormFile(
			es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarODEForm form,
			HttpServletRequest request, CurrentState estadoActual,
			FormFile formFile, String caja, String odeOrder)
			throws ValidatorException {
		if (formFile != null && formFile.getFileName().length() != 0) {
			if(logger.isDebugEnabled())
			logger.debug("El espacio libre restante:"+form.getEspacioLibre());
			if(estadoActual.diferencia>0){
				estadoActual.hemoshechoalgo = true;
				try {
					ResultadoImportacion resultadoParcial = new ResultadoImportacion();
					resultadoParcial.setTitulo(formFile.getFileName());
					ResultadoOperacionVO unResultado = new ResultadoOperacionVO();
					unResultado = importarUnODE(formFile, formFile.getFileName(), request
							.getLocale().getLanguage());				
					if (unResultado.getIdResultado().equals("0.0")) {
						resultadoParcial.setValido(null);
						estadoActual.nr_archivos_subidos++;
						estadoActual.archivosSubidos = estadoActual.archivosSubidos + formFile.getFileName() + ",";
						estadoActual.diferencia=estadoActual.diferencia-unResultado.getTamainoODE();
					}
					else if(unResultado.getIdResultado().equals("0.1")){
						logger.debug("Borrados vocabularios controlados y fechas incorrectas");
						resultadoParcial.setValido(RESULTADO_SI);
						resultadoParcial.setMensajes(unResultado.getDescripcion().split(splitter));
						estadoActual.nr_archivos_subidos++;
						estadoActual.archivosSubidos = estadoActual.archivosSubidos + formFile.getFileName() + ",";
						estadoActual.diferencia=estadoActual.diferencia-unResultado.getTamainoODE();
					} 		
					else {
						resultadoParcial.setValido(RESULTADO_NO);
						logger.error("El archivo de la "+caja+" no se ha podido importar: " + unResultado.getDescripcion());
	//					saveErrorMessage(request, "gestorFlujo.error.importar.validar", new String[] {
	//							form.getFicheroODE1().getFileName(), unResultado.getDescripcion() });					
						resultadoParcial.setMensajes(unResultado.getDescripcion().split(splitter));
						estadoActual.diferencia=form.getEspacioLibre();
					}
					estadoActual.resultado.add(resultadoParcial);
//					resultado.add(resultadoParcial);
					
	
				} catch (Exception ex) {
					logger.error("Excepcion al importar el ode "+caja+": ", ex);
					throw new ValidatorException("{gestorFlujo.error.inesperado}");
				}
			}
			else{
//				diferencia=form.getEspacioLibre();
				ResultadoImportacion resultadoParcial = new ResultadoImportacion();
				String[] textos=new String[1];
				String texto="El "+odeOrder+" no se ha podido importar, pues excede la cuota libre del usuario:"+estadoActual.diferencia;
				textos[0]=texto;
				logger.error("El "+odeOrder+" no se ha podido importar, pues excede la cuota libre del usuario:"+estadoActual.diferencia);
				resultadoParcial.setMensajes(textos);
				resultadoParcial.setTitulo(formFile.getFileName());
				resultadoParcial.setValido(RESULTADO_NO);
				estadoActual.resultado.add(resultadoParcial);
//				resultado.add(resultadoParcial);
				
			}
	
		}
	}

	public void cargarFormularioImportar(ActionMapping mapping, CargarFormularioImportarForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.info("Formularo importar cargado correctamente");
		long tamaino=new Long(request.getParameter("espacioLibre"));
		logger.debug("Tamaino:["+tamaino);
		long tamainoForm=form.getEspacioLibre();
		if(logger.isDebugEnabled())
		logger.debug("Tamaino formulario:["+tamainoForm);

		
	}

}