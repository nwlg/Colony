/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.indexador.negocio.servicios.busqueda.DocVO;
import es.pode.indexador.negocio.servicios.busqueda.DocumentosVO;
import es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO;
import es.pode.modificador.negocio.servicio.ODE;
import es.pode.modificador.presentacion.configurar.objetos.buscar.BusquedaSession;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController
 */
public class ResultadosBuscarObjetoControllerImpl extends
		ResultadosBuscarObjetoController {
	private static String VACIA = new String("");

	private static final Logger logger = Logger
			.getLogger(ResultadosBuscarObjetoControllerImpl.class);

	/**
	 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController#buscar(org.apache.struts.action.ActionMapping,
	 *      es.pode.modificador.presentacion.configurar.objetos.resultados.BuscarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void buscar(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.objetos.resultados.BuscarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("Recuperamos lista previa de resultados");
		BusquedaSession sesion = getBusquedaSession(request);
		List resultados = sesion.getResultados();
		if (resultados == null) {
			logger.debug("No se encontraron resultados previos");
			ParamAvanzadoVO parametros = new ParamAvanzadoVO();
			// Fecha desde
			String fecha = VACIA;
			String fromYear = sesion.getAnyoDesde();
			String fromMonth = sesion.getMesDesde();
			String fromDay = sesion.getDiaDesde();
			String untilYear = sesion.getAnyoHasta();
			String untilMonth = sesion.getMesHasta();
			String untilDay = sesion.getDiaHasta();
			if (!vacia(fromYear) && !vacia(fromMonth) && !vacia(fromDay)
					&& !vacia(untilYear) && !vacia(untilMonth)
					&& !vacia(untilDay)) {
				logger
						.debug("Se encontraron parámetros de busqueda para intervalo fecha");
				fecha = fromYear + fromMonth + fromDay + " " + untilYear
						+ untilMonth + untilDay;
			}
			parametros.setFechaPublicacionRango(fecha);
			if (!vacia(sesion.getAutor())) {
				logger.debug("Se encontró parámetro de busqueda para autor");
				parametros.setAutor(sesion.getAutor());
			}
			if (!vacia(sesion.getTitulo())) {
				logger.debug("Se encontró parámetro de busqueda para título");
				parametros.setTitulo(sesion.getTitulo());
			}
			if (!vacia(sesion.getIdentificador())) {
				logger
						.debug("Se encontró parámetro de busqueda para identificador");
				parametros.setIdentificadorODE(sesion.getIdentificador());
			}
			String idioma = sesion.getIdioma()==null?"es":sesion.getIdioma();
//			String idioma = "es";
			parametros.setIdiomaBusqueda(idioma);
			parametros.setIdiomaNavegacion(idioma);
			parametros.setNumeroResultados(new Integer(-1));
			try {
				DocumentosVO resultado = getSrvBuscadorService()
						.busquedaAvanzada(parametros);
				DocVO docs[] = resultado.getResultados();
				resultados = new ArrayList();
				if (docs != null) {
					logger.debug("Se recuperaron " + (docs.length)
							+ " resultados");
					for (int i = 0; i < docs.length; i++) {
						//Corregimos problema de localizadorODE,
						// algunos Docs viene con "//" en path. Sustituimos por "/"
						String localizadorODE=docs[i].getLocalizadorODE().replaceAll("//", "/");
						docs[i].setLocalizadorODE(localizadorODE);
						resultados.add(docs[i]);
					}
				} else
					logger.debug("Se recuperaron 0 resultados");
				// sesion.setResultados(Arrays.asList(docs));
				logger.debug("Guardamos los resultados en sesión");
				sesion.setResultados(resultados);
				setBusquedaSession(request, sesion);
			} catch (Exception e) {
				logger.debug("Capturada excepción: "+e);
				throw new ValidatorException("{resultadosBusqueda.excepcion}");
			}			
		}
		logger.debug("Pasamos lista de seleccionados a Form");
		form.setSeleccionados(sesion.getSeleccionados());
		// form.setResultados(Arrays.asList(docs));
		logger.debug("Pasamos lista de resultados a Form");
		form.setResultados(resultados);

		form.setIdiomaBuscadorBackingList(
				IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(
						LdapUserDetailsUtils.getIdioma()), "idLocalizacion",
				"nombre");
	}

	/**
	 * Comprueba si la cadena dada tiene algo útil.
	 * 
	 * @param cadena
	 * @return
	 */
	private boolean vacia(String cadena) {
		return cadena == null || cadena.trim().equals(VACIA);
	}

	/**
	 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController#selectAction(org.apache.struts.action.ActionMapping,
	 *      es.pode.modificador.presentacion.configurar.objetos.resultados.SelectActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final java.lang.String selectAction(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.objetos.resultados.SelectActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				locale);

		String cancelar = "Cancelar";
		String seleccionar = "Seleccionar";
		String volver = "Volver";
		String selecTodos = "SeleccionarTodos";

		String action = form.getAction();
		if (action == null) {
			return volver;
		}

		if (action.equals(i18n.getString("comun.cancelar")))
			return cancelar;
		else if (action.equals(seleccionar))
			return seleccionar;
		else if (action.equals(i18n.getString("comun.seleccionarTodos")))
			return selecTodos;
		else if (action.equals(i18n.getString("comun.volver")))
			return volver;

		return null;
	}

	/**
	 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController#seleccionar(org.apache.struts.action.ActionMapping,
	 *      es.pode.modificador.presentacion.configurar.objetos.resultados.SeleccionarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void seleccionar(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.objetos.resultados.SeleccionarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List paths = form.getPaths();
		BusquedaSession sesion = getBusquedaSession(request);
		List resultados = sesion.getResultados();
		if (paths != null) {
			List actuales = sesion.getSeleccionados();
			if (actuales == null) {
				actuales=new ArrayList();
			}
			boolean alreadyAdded=false;
			for (Iterator iter = paths.iterator(); iter.hasNext();) {
				String path = (String) iter.next();
				for (Iterator iterator = resultados.iterator(); iterator
						.hasNext();) {
					DocVO element = (DocVO) iterator.next();
					if (element.getLocalizadorODE().equals(path)) {
						if(!actuales.contains(element)) {
							actuales.add(element);
						} else {
							//Está repetido
							alreadyAdded=true;
						}
					}
				}
			}

			getBusquedaSession(request).setSeleccionados(actuales);
			setBusquedaSession(request, sesion);
			//Mensaje de ya existente
			if(alreadyAdded) {
				throw new ValidatorException("{resultadosBusqueda.repeated}");
			}
		}
	}

	public void submit(ActionMapping mapping, SubmitForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List lista = form.getLocalizadorODERowSelection();
		if (lista != null) {
			form.setPaths(lista);
		}
	}

	public void seleccionarTodos(ActionMapping mapping,
			SeleccionarTodosForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BusquedaSession sesion = getBusquedaSession(request);
		List resultados = sesion.getResultados();
		if (resultados != null) {
			List actuales = sesion.getSeleccionados();
			if (actuales != null) {
				for (Iterator iter = resultados.iterator(); iter.hasNext();) {
					DocVO este = (DocVO) iter.next();
					// Evitamos duplicados					
					if (!actuales.contains(este))
						actuales.add(este);
				}
			} else {
				actuales = resultados;
			}
			getBusquedaSession(request).setSeleccionados(actuales);
			setBusquedaSession(request, sesion);
		}

	}

	public void guardarSeleccionados(ActionMapping mapping,
			GuardarSeleccionadosForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List seleccionados = getBusquedaSession(request).getSeleccionados();
		BusquedaSession sesion = getBusquedaSession(request);
		sesion.setResultados(null);
		setBusquedaSession(request, sesion);
		if (seleccionados!=null&&seleccionados.size() > 0) {
			List odes;
			if (getConfigurarModificacionSession(request).getConfiguracion()
					.getObjetos().getObjetos() != null) {
				odes = new ArrayList(Arrays.asList(getConfigurarModificacionSession(request)
						.getConfiguracion().getObjetos().getObjetos()));
			} else {
				odes = new ArrayList();
			}
			ODE nuevoOde;

			for (Iterator iter = seleccionados.iterator(); iter.hasNext();) {
				DocVO seleccionado = (DocVO) iter.next();
				nuevoOde = new ODE();
				nuevoOde.setPublished(Boolean.TRUE);
				nuevoOde.setPath(seleccionado.getLocalizadorODE());
				nuevoOde.setTitulo(seleccionado.getTitulo());
				// Control de duplicados
				if (!odes.contains(nuevoOde))
					odes.add(nuevoOde);
			}

			getConfigurarModificacionSession(request).getConfiguracion()
					.getObjetos()
					.setObjetos((ODE[]) odes.toArray(new ODE[] {}));
		}
		this.removeBusquedaSession(request);
	}

	public void eliminar(ActionMapping mapping, EliminarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String path = form.getPath();

		if (!vacia(path)) {
			BusquedaSession sesion = getBusquedaSession(request);
			List resultados = sesion.getResultados();
			List seleccionados = sesion.getSeleccionados();

			for (Iterator iterator = resultados.iterator(); iterator.hasNext();) {
				DocVO element = (DocVO) iterator.next();
				if (element.getLocalizadorODE().equals(path)) {
					seleccionados.remove(element);
				}
			}
		} else {
			java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			ResourceBundle i18n = ResourceBundle.getBundle(
					"application-resources", locale);
			throw new ValidatorException(i18n
					.getString("resultadosObjetos.noHaySeleccion"));
		}

	}

	public void eliminarTodos(ActionMapping mapping, EliminarTodosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		getBusquedaSession(request).setSeleccionados(null);
	}

	public void borrarSesion(ActionMapping mapping, BorrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BusquedaSession sesion=getBusquedaSession(request);
		sesion.setResultados(null);
		sesion.setSeleccionados(null);
	}
	
}