/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.presentacion;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceServiceLocator;
import es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceServiceLocator;

/**
 * @author fjespino
 * 
 */
public class EmpaquetadorSessionListener implements HttpSessionListener {

	private static Logger logger = Logger
			.getLogger(EmpaquetadorSessionListener.class);
	
	private GestorSesion gestorSesion =  new GestorSesion();
	
	/**
	 * @return the gestorSesion
	 */
	public GestorSesion getGestorSesion() {
		return gestorSesion;
	}


	/**
	 * @param gestorSesion the gestorSesion to set
	 */
	public void setGestorSesion(GestorSesion gestorSesion) {
		this.gestorSesion = gestorSesion;
	}

	/**
	 * Realiza las operaciones necesarias en el inicio de una session.
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		logger.info("Sesion iniciada en el empaquetador");
		// TODO Auto-generated method stub
	}

	/**
	 * <p>
	 * Realiza las operaciones necesarias cuando una sesion se destruye. Estas
	 * operaciones incluyen:
	 * </p>
	 * <ul>
	 * <li>Eliminar todos los objetos Lom del servicio de catalogacion mediante
	 * una llamada al servicio de Empaquetacion.</li>
	 * <li>FASE II: Restaurar backup de la sesion anterior, de modo que cuando
	 * se vuelva a editar, aparezca en el estado de la ultima vez que se guardo.</li>
	 * </ul>
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		logger.info("Sesion destruida en el empaquetador");
		
		// si la sesión ha caducado no será null:
		if (this.getEmpaquetadorSession(arg0) != null) {
			// eliminar ode, loms asociados,
			try {
				// this.getSrvEmpaquetadorBasicoService().eliminarLoms(
				// this.getEmpaquetadorSession(arg0).getOde());
				EmpaquetadorSession empSession = (EmpaquetadorSession) arg0
						.getSession().getAttribute(
								EmpaquetadorSession.SESSION_KEY);
			this.gestorSesion.comprobarPendientesCatalogacion(arg0.getSession());

				/*
				 * Llamo al servicio para restaurar el backup
				 */
				if(logger.isDebugEnabled()) logger.debug("Restaurando el backup de " + empSession.getIdLocalizador());;
				this.getSrvGestorArchivosService().restaurarBackup(
						empSession.getIdLocalizador());
				if(logger.isDebugEnabled()) logger.debug("Eliminando el backup de " + empSession.getIdLocalizador());;
				this.getSrvGestorArchivosService().eliminarBackup(empSession.getIdLocalizador());
				this.getSrvGestorManifestService().terminarEdicion(empSession.getIdLocalizador());
				if(!empSession.isGuardadoPrimeraVez()) {
					if(logger.isDebugEnabled()) logger.debug("Eliminando el ODE que no ha sido guardado nunca + " + empSession.getIdLocalizador());
					try {
						this.getSrvGestorManifestService().eliminarODE(empSession.getIdLocalizador());
					} catch (Exception e) {
						logger.error("No se ha podido eliminar el ODE " + empSession.getIdLocalizador(),e);
					}
				}
				if(logger.isDebugEnabled()) logger.debug("Eliminando el backup de " + empSession.getIdLocalizador());;
				// borrar todas las posibles sesiones activas:
				if(logger.isDebugEnabled()) logger.debug("Borrando los objetos de sesion");
				arg0.getSession().removeAttribute(
						EmpaquetadorSession.SESSION_KEY);
				
			} catch (RemoteException e) {
				logger
						.error(
								"Ocurrio un fallo durante las acciones de cierre de la sesion.",
								e);
			} catch (Exception e) {
				logger
						.error(
								"Ocurrio un fallo durante las acciones de cierre de la sesion.",
								e);
			}

		}
	}

	private EmpaquetadorSession getEmpaquetadorSession(HttpSessionEvent event) {
		EmpaquetadorSession session = null;
		HttpSession httpSession = event.getSession();
		if (httpSession != null) {
			session = (EmpaquetadorSession) httpSession
					.getAttribute(EmpaquetadorSession.SESSION_KEY);

		}
		return session;
	}

	private final es.pode.empaquetador.negocio.servicio.SrvGestorManifestService getSrvGestorManifestService()
			throws Exception {
		SrvGestorManifestServiceServiceLocator locator = new SrvGestorManifestServiceServiceLocator();
		return locator.getSrvGestorManifestService();
	}

	private final es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService getSrvGestorArchivosService()
			throws Exception {
		SrvGestorArchivosServiceServiceLocator locator = new SrvGestorArchivosServiceServiceLocator();
		return locator.getSrvGestorArchivosService();
	}

}
