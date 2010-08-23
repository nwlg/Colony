/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.publicacion.negocio.servicios.TransicionVO;

/**
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.VerHistorialController
 */
public class VerHistorialControllerImpl extends VerHistorialController {

	private Logger logger = Logger.getLogger(VerHistorialController.class);

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.VerHistorialController#cargarHistorialODE(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.CargarHistorialODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void cargarHistorialODE(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.CargarHistorialODEForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("cargando historiales para el ode: " + form.getIdODE() + " de titulo: " + form.getTitulo());
		try

		{
			TransicionVO tr_vo_array[] = this.getSrvPublicacionService().obtenHistorialPorIdODE(form.getIdODE());
			Transicion_VO_date tr_date[] = new Transicion_VO_date[tr_vo_array.length];

			//recorremos el array para dar formato bonito a la fecha
			for (int i = 0; i < tr_vo_array.length; i++) {
				tr_date[i] = map_transicion(tr_vo_array[i]);
			}
			if(logger.isDebugEnabled())
			logger.info("Encontrados " + tr_date.length + " historiales para " + form.getIdODE());
			form.setHistorialesAsArray(tr_date);
		} catch (Exception ex) {
			logger.error("Error al obtener los historiales: " + ex.getMessage());
			throw new ValidatorException("{gestorFlujo.error.historiales}");
		}

	}

	private Transicion_VO_date map_transicion(TransicionVO tr) {
		Transicion_VO_date tr_date = new Transicion_VO_date();

		tr_date.setComentarios(tr.getComentarios());
		tr_date.setEstadoActual(tr.getEstadoActual());
		tr_date.setFecha(tr.getFecha().getTime());
		tr_date.setIdODE(tr.getIdODE());
		tr_date.setTitulo(tr.getTitulo());
		tr_date.setIdUsuario(tr.getIdUsuario());

		return tr_date;

	}

	public class Transicion_VO_date {

		/* Identificador del ODE al que hace referencia la transicion. */
		private java.lang.String idODE;

		/* Los comentarios de la transicion. */
		private java.lang.String comentarios;

		/* La fecha de la transicion. */
		private java.util.Date fecha;

		/* Titulo del ODE, en caso de tenerlo. */
		private java.lang.String titulo;

		/* Usuario */
		private java.lang.String idUsuario;

		private es.pode.publicacion.negocio.servicios.EstadoVO estadoActual;

		private es.pode.publicacion.negocio.servicios.EstadoVO estadoTransitado;

		public Transicion_VO_date() {
		}

		public java.lang.String getComentarios() {
			return comentarios;
		}

		public void setComentarios(java.lang.String comentarios) {
			this.comentarios = comentarios;
		}

		public es.pode.publicacion.negocio.servicios.EstadoVO getEstadoActual() {
			return estadoActual;
		}

		public void setEstadoActual(es.pode.publicacion.negocio.servicios.EstadoVO estadoActual) {
			this.estadoActual = estadoActual;
		}

		public es.pode.publicacion.negocio.servicios.EstadoVO getEstadoTransitado() {
			return estadoTransitado;
		}

		public void setEstadoTransitado(es.pode.publicacion.negocio.servicios.EstadoVO estadoTransitado) {
			this.estadoTransitado = estadoTransitado;
		}

		public java.util.Date getFecha() {
			return fecha;
		}

		public void setFecha(java.util.Date fecha) {
			this.fecha = fecha;
		}

		public java.lang.String getIdODE() {
			return idODE;
		}

		public void setIdODE(java.lang.String idODE) {
			this.idODE = idODE;
		}

		public java.lang.String getTitulo() {
			return titulo;
		}

		public void setTitulo(java.lang.String titulo) {
			this.titulo = titulo;
		}

		public java.lang.String getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(java.lang.String idUsuario) {
			this.idUsuario = idUsuario;
		}
	}

}