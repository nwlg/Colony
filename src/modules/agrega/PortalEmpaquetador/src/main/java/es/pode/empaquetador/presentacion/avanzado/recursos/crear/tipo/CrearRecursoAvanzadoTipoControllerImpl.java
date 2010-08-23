/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.uuid.PodeUUIDGenerator;

/**
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.CrearRecursoAvanzadoTipoController
 */
public class CrearRecursoAvanzadoTipoControllerImpl extends
		CrearRecursoAvanzadoTipoController {
	private static Logger logger = Logger
			.getLogger(CrearRecursoAvanzadoTipoControllerImpl.class);

	public final java.lang.String selectAction(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.SelectActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Metodo de decision para el action. Analiza los parametros
		 * actionSubmit (value de los botones submit) para redirigir al caso de
		 * uso correspondiente. El actionSubmit llegara internacionalizado, por
		 * lo que es necesario acceder al ResouceBundle para obtener el valor
		 * correcto en la comparacion.
		 */

		String result = null;
		String actionSubmit = form.getAction();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				locale);

		if (form.getAction() == (null)) {
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
		// Cancelar
		else if (actionSubmit
				.equals(i18n
						.getString("portalempaquetado.avanzado.recursos.crear.paso1.cancelar"))) {
			result = "Cancelar";
		}
		// Aceptar
		else if (actionSubmit
				.equals(i18n
						.getString("portalempaquetado.avanzado.recursos.crear.paso1.continuar"))) {
			result = "Continuar";
		}
		// Aceptar
		else if (actionSubmit
				.equals(i18n
						.getString("portalempaquetado.avanzado.recursos.crear.paso1.anadirmetadatos"))) {
			result = "Metadato";
		} else {
			Logger.getLogger(this.getClass()).error(
					"El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
		}
		return result;
	}

	public final void submit(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.SubmitForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CrearRecursoAvanzadoSession sesRecurs = this
				.getCrearRecursoAvanzadoSession(request);

		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				locale);

		String accion = form.getAction();
		String tipo = form.getTipo();

		// continuar
		if (accion
				.equals(i18n
						.getString("portalempaquetado.avanzado.recursos.crear.paso1.continuar"))) {
			if ((tipo != null)
					&& (tipo
							.equals("asset") || tipo
							.equals("sco"))) {
				sesRecurs.setTipo(tipo);

			}

		}
	}

	public final void crearSesion(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.CrearSesionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		GestorArchivosSession sesArch = this.getGestorArchivosSession(request);
		CrearRecursoAvanzadoSession sesRecurs = this
				.getCrearRecursoAvanzadoSession(request);

		List path = new ArrayList();
		path.addAll(sesArch.getPath());

		List archivos = new ArrayList();
		List dependencias = new ArrayList();

		if (this.getCrearRecursoAvanzadoSession(request) == null
				|| this.getCrearRecursoAvanzadoSession(request).isModificar() == false) {
			if (logger.isDebugEnabled())
				logger.debug("Creando nueva sesion de CrearRecursoAvanzado");
			sesRecurs = new CrearRecursoAvanzadoSession();
			if (logger.isDebugEnabled())
				logger.debug("Lista de Archivos : " + archivos);
			sesRecurs.setArchivos(archivos);
			if (logger.isDebugEnabled())
				logger.debug("Lista de dependencias : " + dependencias);
			sesRecurs.setDependencias(dependencias);
			sesRecurs.setIdentifier(PodeUUIDGenerator.getRecursoUUID(this
					.getClass().toString()));
			if (logger.isDebugEnabled())
				logger.debug("Identificador del nuevo recurso : "
						+ sesRecurs.getIdentifier());
			sesRecurs.setModificar(false);
			if (logger.isDebugEnabled())
				logger.debug("Path " + path);
			sesRecurs.setPathArchivos(path);
			sesRecurs.setPrincipal(null);
			sesRecurs.setTipo("asset");
			sesRecurs.setVistaArbol(false);
			this.setCrearRecursoAvanzadoSession(request, sesRecurs);
		} else {
			if(logger.isDebugEnabled()) logger.debug("CrearRecursoAvanzado: se va a modificar un recurso:");
			if (logger.isDebugEnabled())
				logger.debug("Lista de Archivos : " + sesRecurs.getArchivos());
			if (logger.isDebugEnabled())
				logger.debug("Lista de dependencias : " + sesRecurs.getDependencias());
			if (logger.isDebugEnabled())
				logger.debug("Identificador del recurso : "
						+ sesRecurs.getIdentifier());
			if (logger.isDebugEnabled())
				logger.debug("Href del recurso : "
						+ sesRecurs.getPrincipal());
			if (logger.isDebugEnabled())
				logger.debug("Flag de modificar : "
						+ sesRecurs.isModificar());
		}
		if (sesRecurs.getTipo() != null && !sesRecurs.getTipo().equals("")) {
			form.setTipo(sesRecurs.getTipo().toLowerCase());
		} else {
			form.setTipo("asset");
		}

		
//		sesRecurs.setArchivos(archivos);
		if (this.getCrearRecursoArchivosSession(request).getArchivos() == null) {
			this.getCrearRecursoArchivosSession(request).setArchivos(
					new ArrayList());
		}
	}

	public final void destruirSesion(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.DestruirSesionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.getCrearRecursoAvanzadoSession(request) != null) {
			request.getSession().removeAttribute(
					CrearRecursoAvanzadoSession.SESSION_KEY);
		}
	}

}