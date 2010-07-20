/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;

/**
 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosController
 */
public class GestorSubmanifiestosControllerImpl extends
		GestorSubmanifiestosController {

	private static final String EXCEPTION = "{portal_empaquetado.exception}";
	private static final String DESAGREGAR = "portal_empaquetado_gestorSubman.desagregar";
	private static final String AGREGAR = "portal_empaquetado_gestorSubman.agregar";
	private static final String ELIMINAR = "portal_empaquetado_gestorSubman.eliminar";
	private static final String APPLICATION_RESOURCES = "application-resources";
	private GestorSesion gestorSesion = new GestorSesion();
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @return the gestorSesion
	 */
	public GestorSesion getGestorSesion() {
		return gestorSesion;
	}

	/**
	 * @param gestorSesion
	 *            the gestorSesion to set
	 */
	public void setGestorSesion(GestorSesion gestorSesion) {
		this.gestorSesion = gestorSesion;
	}

	public final void recuperarDatos(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.RecuperarDatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		gestorSesion.refrescarObjetosSesion(request);
		EmpaquetadorSession session = this.getEmpaquetadorSession(request);
		if (session.getSubmanifestPath() != null) {
			form.setBarraSubmanifiestos(session.getSubmanifestPath());
			OdeVO ode = (OdeVO) session.getSubmanifestPath().get(
					session.getSubmanifestPath().size() - 1);
			form.setSubmanifiestosAsArray(ode.getSubmanifiestos());
		}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosController#submit(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.SubmitForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void submit(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.SubmitForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle(APPLICATION_RESOURCES,
				locale);

		String accion = form.getAction();
		if ((accion.equals(i18n.getString(ELIMINAR)))|| (accion.equals(i18n.getString(DESAGREGAR)))) {
			if (form.getIdentifierRowSelection() != null
					&& form.getIdentifierRowSelection().size() > 0) {
				form.setIdentificadores(form.getIdentifierRowSelection());
			} else {
				throw new ValidatorException("{exportar.subirArchivo}");
			}
		}
	}

	public final java.lang.String selectAction(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.SelectActionForm form,
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
		ResourceBundle i18n = ResourceBundle.getBundle(APPLICATION_RESOURCES,
				locale);

		if (form.getAction() == (null)) {
			throw new ValidatorException(EXCEPTION);
		}

		else if (actionSubmit.equals(i18n
				.getString(AGREGAR))) {
			result = "Agregar";
		} else if (actionSubmit.equals(i18n
				.getString(DESAGREGAR))) {
			result = "Desagregar";
		} else if (actionSubmit.equals(i18n
				.getString(ELIMINAR))) {
			result = "Eliminar";
		} else {
			logger.error("El valor del submit no es correcto (actionSubmit = "
						+ actionSubmit + ")");
		}

		return result;
	}

	public final void navegarSubmanifiesto(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.NavegarSubmanifiestoForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			boolean encontrado = false;
			String identificador = form.getIdentifier();
			EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
			List subman = sesEmpaq.getSubmanifestPath();

			// ultimo ODE
			OdeVO ode = (OdeVO) subman.get(subman.size() - 1);
			Integer index = subman.size() - 1;
			String identificadorOde = index==0?sesEmpaq.getIdLocalizador():ode.getIdentifier();

			// cojo los hijos del ultimo ODE
			OdeVO[] hijos = ode.getSubmanifiestos();
			// los recorro viendo si coinciden
			for (int i = 0; (encontrado == false && i < hijos.length); i++) {
				if (hijos[i].getIdentifier().equals(identificador)) {
					encontrado = true;
					Boolean nuevoOde = this
							.getSrvGestorManifestService()
							.crearReferenciaEnCache(identificadorOde, identificador);
					if (nuevoOde.booleanValue() == false) {
						throw new ValidatorException(
								"{portal_empaquetado_gestorSubman.exception}");
					} else {
						subman.add(hijos[i]);

					}
				}
			}
			if (encontrado == false) {
				// recorro el sesEmpaq.getSubmanifestPath();
				for (int i = 0; (i < subman.size() && !encontrado ); i++) {
					OdeVO submanifiesto = (OdeVO) subman.get(i);
					if (submanifiesto.getIdentifier().equals(identificador)) {
						// Voy a borrar a partir del identificador encontrado
						encontrado = true;

						for (int j = i + 1; j < subman.size(); j++) {
							OdeVO elemento = (OdeVO) subman.get(j);
							this.getSrvGestorManifestService().descargarManifest(
									elemento.getIdentifier());
							subman.remove(j);
						}

					}
				}
				sesEmpaq.setSubmanifestPath(subman);
			}
	}
}
