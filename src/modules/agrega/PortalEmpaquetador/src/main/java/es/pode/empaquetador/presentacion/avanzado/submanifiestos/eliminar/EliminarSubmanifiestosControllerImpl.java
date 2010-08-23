/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.soporte.constantes.ConstantesAgrega;

/**
 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosController
 */
public class EliminarSubmanifiestosControllerImpl extends
		EliminarSubmanifiestosController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private boolean _hayReferencias(Object obj, String idRef) {
		boolean resultado = false;

		// si es un ode
		if (obj instanceof OdeVO) {
			OdeVO ode = (OdeVO) obj;
			// OdeVO[] submanifiestos = ode.getSubmanifiestos();
			// si tiene grupo, llamo nuevamente
			OrganizacionVO[] orgs = ode.getOrganizaciones();
			if (orgs != null && orgs.length > 0) {
				for (int i = 0; i < orgs.length; i++) {
					GrupoVO[] grupos = orgs[i].getGrupos();
					if (grupos != null) {
						for (int j = 0; j < grupos.length; j++) {
							if (_hayReferencias(grupos[j], idRef)) {
								return true;
							}
						}
					}
				}
			}

			OdeVO[] subm = ode.getSubmanifiestos();

			// si tiene submanifiestos vuelvo a llamar
			if (subm != null && subm.length > 0) {
				for (int i = 0; i < subm.length; i++) {
					if (_hayReferencias(subm[i], idRef)) {
						return true;
					}
				}
			}
		} else if (obj instanceof GrupoVO) {
			GrupoVO grupo = (GrupoVO) obj;

			if (grupo.getElementoReferenciado() != null
					&& grupo.getElementoReferenciado().equals(idRef)) {
				return true;
			} else {
				GrupoVO[] subGrupos = grupo.getGrupos();
				if (subGrupos != null) {
					for (int i = 0; i < subGrupos.length; i++) {
						if (_hayReferencias(subGrupos[i], idRef))
							return true;
					}
				}
			}
		}

		return resultado;
	}

	/**
	 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosController#hayReferencias(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.HayReferenciasForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final java.lang.String hayReferencias(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.HayReferenciasForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesEmp = this.getEmpaquetadorSession(request);
		List<String> identificadores = form.getIdentificadores();
		OdeVO ode = (OdeVO) sesEmp.getSubmanifestPath().get(0);
		String resultado = "No";
		if (ode != null) {
			for (int i = 0; i < identificadores.size(); i++) {
				String idRef = identificadores.get(i);
				if (_hayReferencias(ode, idRef)) {
					return "Si";
				}
			}
		}
		return resultado;
	}

	/**
	 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosController#eliminar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void eliminar(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			java.util.Locale locale = (Locale) request.getSession().getAttribute(
					ConstantesAgrega.DEFAULT_LOCALE);
			ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
					locale);

			EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
			if (form.getAction().equals(i18n.getString("portalempaquetado.avanzado.submanifiestos.aceptar"))
					|| form.getAction().equals(i18n.getString("portal_empaquetado_gestorSubmanifiestos.eliminar"))) {
				List path = sesEmpaq.getSubmanifestPath();
				String idSubmanifestPadre = null;
				if (path.size() > 1) {
					OdeVO ultimo = (OdeVO) path.get(path.size() - 1);
					idSubmanifestPadre = ultimo.getIdentifier();
				}
				String idOde = this.getEmpaquetadorSession(request)
						.getIdLocalizador();
				Object[] identificadores = this.getEliminarSubmanifiestosSession(
						request).getIdentificadores().toArray();

				String[] submanifIdent = new String[identificadores.length];

				for (int i = 0; i < identificadores.length; i++) {
					submanifIdent[i] = (String) identificadores[i];

					// Compruebo el objeto de sesion de archivos. Si estaba
					// navegando en el directorio de submanifiesto, retrocedo al
					// directorio anterior para evitar un error
					GestorArchivosSession sesionArchivos = this
							.getGestorArchivosSession(request);
					if (sesionArchivos != null) {
						List archivosPath = sesionArchivos.getPath();
						List subPath = this.getEmpaquetadorSession(request)
								.getSubmanifestPath();
						if (archivosPath != null && archivosPath.size() > 0
								&& subPath != null && subPath.size() > 0) {
							ArchivoVO ultimo = (ArchivoVO) archivosPath.get(archivosPath.size() - 1);
							OdeVO ultimoSubm = (OdeVO) subPath.get(subPath.size() - 1);
							OdeVO odeABorrar = null;
							if (ultimoSubm.getSubmanifiestos() != null) {
								for (int j = 0; j < ultimoSubm.getSubmanifiestos().length
										&& odeABorrar == null; j++) {
									if (submanifIdent[i].equals(ultimoSubm.getSubmanifiestos()[i].getIdentifier()))
										odeABorrar = ultimoSubm.getSubmanifiestos()[i];
								}
								if (odeABorrar!=null&&odeABorrar.getRuta() != null) {
									if (ultimo.getNombre().equals(odeABorrar.getRuta().replaceAll("/", "")))
										archivosPath.remove(archivosPath.size() - 1);
								}
							}

						}
					}

					try {
						this.getSrvGestorManifestService().eliminarSubmanifiesto(idOde,
								submanifIdent[i], idSubmanifestPadre);
					} catch (Exception e) {
						logger.error("Error en llamada al servicio de eliminación de submanifiesto(s): "+Arrays.toString(submanifIdent)+", mensaje: "+e);
						throw e;
					}

				}
			}
		} catch (Exception e) {
			logger.error("Error al eliminar submanifiesto, "+e);
			throw e;
		}
	}

	public void recuperarDatos(ActionMapping mapping, RecuperarDatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List identificadores = form.getIdentificadores();
		if (identificadores == null) {
			identificadores = new ArrayList();
			Logger.getLogger(this.getClass()).error("Se ha llamado a EliminarSubmanifiestos sin identificadores");
		}
		this.getEliminarSubmanifiestosSession(request).setIdentificadores(
				identificadores);

	}

	public void borrarObjetoSesion(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.BorrarObjetoSesionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.getEliminarSubmanifiestosSession(request) != null) {
			request.getSession().removeAttribute(
					EliminarSubmanifiestosSession.SESSION_KEY);
		}

	}

}
