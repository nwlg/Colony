/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.presentacion;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.ControlModeVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.empaquetador.negocio.servicio.SecuenciaVO;
import es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class GestorSesion {

	private static Logger logger = Logger
			.getLogger(GestorSesion.class);
	
	private static Properties props = null;

	private static Pattern mask = Pattern.compile("[\\w.!()'~-]*");

	public String tipoEmpaquetador(EmpaquetadorSession sesionObj) {
		String resultado = null;
        if("Avanzado".equalsIgnoreCase(sesionObj.getTipoEmpaquetador())) {
        	resultado = "Avanzado";
        } else if("Basico".equalsIgnoreCase(sesionObj.getTipoEmpaquetador())) {
        	resultado = "Basico";
        } else {
        	logger.error("No se ha encontrado el empaquetador usado en la sesion. Usando Avanzado por defecto");
        	resultado = "Avanzado";
        }
        return resultado;
	}
	
	public void refrescarObjetosSesion(HttpServletRequest request)
			throws Exception {

		this.comprobarPendientesCatalogacion(request);

		EmpaquetadorSession empSession = getEmpaquetadorSession(request);
		OdeVO ode = this.getSrvGestorManifestService().cargarManifest(
				empSession.getIdLocalizador());
		this.getEmpaquetadorSession(request).setOde(ode);
		// Refresco las listas de los objetos de sesion
		List idCollection = this.getEmpaquetadorSession(request)
				.getIdCollection();
		// Refresco la lista de navegacion de submanifiestos
		empSession.setSubmanifestPath(this
				.refrescarListaSubmanifestPath(request));
		// Refresco la lista de navegacion de Elementos
		OdeVO ultimoOde = (OdeVO) empSession.getSubmanifestPath().get(
				empSession.getSubmanifestPath().size() - 1);
		empSession.setIdCollection(this
				.rellenarBarraNavegacionGestorIdCollection(ultimoOde,
						idCollection));
		request.getSession().setAttribute(EmpaquetadorSession.SESSION_KEY,
				empSession);

	}

	public void comprobarPendientesCatalogacion(HttpServletRequest request) {
		comprobarPendientesCatalogacion(request.getSession());
	}

	public void comprobarPendientesCatalogacion(HttpSession session) {
		EmpaquetadorSession empSession = getHttpSessionEvent(session);
		if (empSession != null
				&& empSession.getPendientesCatalogacion() != null
				&& empSession.getPendientesCatalogacion().size() > 0) {
			if (logger.isDebugEnabled())
				logger
						.debug("Asocio los Loms pendientes para eliminarlos del servicio de catalogacion");
			for (int i = 0; i < empSession.getPendientesCatalogacion().size(); i++) {
				CatalogacionBean bean = null;
				try {
					bean = (CatalogacionBean) empSession
							.getPendientesCatalogacion().get(i);
					this.getSrvGestorManifestService().asociarLom(
							empSession.getIdLocalizador(),
							bean.getIdentifier(), bean.getHref());
					empSession.getPendientesCatalogacion().remove(i);
					if (logger.isDebugEnabled())
						logger
								.debug(empSession.getPendientesCatalogacion()
										.size()
										+ " elementos en Pendientes de catalogar tras catalogar "
										+ bean.getIdentifier() + bean.getHref());
				} catch (Exception e) {
					logger.warn("Se produjo una excepcion al catalogar "
							+ bean.getIdentifier() + bean.getHref(), e);
				}
			}
			Object timeout = session.getAttribute("timeout.empaquetador");
			if(logger.isDebugEnabled()) logger.debug("Restauro el timeout de la sesion al valor prealmacenado : " + timeout);
			if(timeout instanceof Integer) {
				session.setMaxInactiveInterval(((Integer)timeout).intValue());
				logger.debug("Timeout restaurado a " + session.getMaxInactiveInterval());
			}
		}
	}

	public String obtenerUsuario(HttpServletRequest request) {

		String user;
		try {
			user = LdapUserDetailsUtils.getUsuario();
		} catch (Exception e) {
			user = "user";
		}
		return user;

	}

	public String obtenerIdiomaUsuario(HttpServletRequest request) {

		String idiomaUser;
		try {
			idiomaUser = LdapUserDetailsUtils.getIdioma();
		} catch (Exception e) {
			idiomaUser = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		}
		return idiomaUser;

	}
	
	public boolean esAvanzado() throws Exception {
		boolean resultado = true;
		String empaquetador = null;
		try {
			if(logger.isDebugEnabled()) logger.debug("Recupero datos de autenticacion");
			empaquetador = LdapUserDetailsUtils.getEmpaquetador();
			
		} catch (Exception e) {
			logger.warn("El empaquetador no pudo recuperar el perfil del usuario. Usando empaquetador por defecto");
			empaquetador = getProperty("default.empaquetador");
			if(empaquetador== null) {
				logger.error("No se ha encontrado empaquetador por defecto. Uso Avanzado");
				resultado = true;
			}
		}
		
		if("avanzado".equals(empaquetador)) resultado = true;
		else if ("basico".equals(empaquetador)) resultado=false;
		
		if(logger.isDebugEnabled()) logger.debug("Tipo de empaquetador detectado por validar : " + resultado);
		return resultado;
	}
	
	public String getProperty(String key) throws Exception {
		if(key==null) {
			throw new NullPointerException("key");
		}
			
		if(props==null) {
			props = new Properties();
			InputStream is = this.getClass().getResourceAsStream("/spring.properties");
			if(is==null) {
				logger.error("No  se encontro spring.properties");
				throw new Exception("No se encontro spring.properties");
			}
			props.load(is);
		}
		return props.getProperty(key);
	}
	
	private List refrescarListaSubmanifestPath(HttpServletRequest request)
			throws Exception {
		EmpaquetadorSession empSession = getEmpaquetadorSession(request);
		List subman = empSession.getSubmanifestPath();
		subman.set(0, empSession.getOde());
		return rellenarBarraNavegacionGestorElemento(subman);
	}

	private List rellenarBarraNavegacionGestorElemento(List subman) {
		if (subman != null) {
			for (int i = 1; i < subman.size(); i++) {
				OdeVO primerElem = (OdeVO) subman.get(i - 1);
				OdeVO SiguienteElem = (OdeVO) subman.get(i);
				String identificador = SiguienteElem.getIdentifier();
				OdeVO[] submanifiestos = primerElem.getSubmanifiestos();
				boolean encontrado = false;
				for (int j = 0; (j < submanifiestos.length && encontrado == false); j++) {
					if (submanifiestos[j].getIdentifier().equals(identificador)) {
						encontrado = true;
						subman.set(i, submanifiestos[j]);
					}
				}
			}
		}
		return subman;
	}

	private List rellenarBarraNavegacionGestorIdCollection(OdeVO ode,
			List idCollection) {
		List resultado = new ArrayList();
		if (idCollection != null && idCollection.size() > 0) {
			String idOrg = ((OrganizacionVO) idCollection.get(0))
					.getIdentifier();
			// Recupero la organizacion del ode que me pasan
			OrganizacionVO org = null;
			for (int i = 0; i < ode.getOrganizaciones().length && org == null; i++) {
				if (ode.getOrganizaciones()[i].getIdentifier().equals(idOrg))
					org = ode.getOrganizaciones()[i];
			}
			// Sustituyo la organizacion del idCollection
			if (org != null) {
				resultado.add(org);

				for (int i = 1; i < idCollection.size(); i++) {
					GrupoVO[] hijos = obtenerHijos(resultado.get(i - 1));
					GrupoVO siguienteElem = (GrupoVO) idCollection.get(i);
					String identificador = siguienteElem.getIdentifier();

					boolean encontrado = false;
					for (int j = 0; (j < hijos.length && encontrado == false); j++) {
						if (hijos[j].getIdentifier().equals(identificador)) {
							encontrado = true;
							resultado.add(hijos[j]);
						}
					}
				}
			}
		}
		return resultado;
	}

	private GrupoVO[] obtenerHijos(Object o) {
		GrupoVO[] resultado = null;
		if (o instanceof OrganizacionVO)
			resultado = ((OrganizacionVO) o).getGrupos();
		else if (o instanceof GrupoVO)
			resultado = ((GrupoVO) o).getGrupos();
		else
			resultado = new GrupoVO[0];
		return resultado;
	}

	private EmpaquetadorSession getHttpSessionEvent(HttpSession arg0) {
		return (EmpaquetadorSession) arg0
				.getAttribute(EmpaquetadorSession.SESSION_KEY);
	}

	private EmpaquetadorSession getEmpaquetadorSession(
			HttpServletRequest request) {
		return (EmpaquetadorSession) request.getSession().getAttribute(
				EmpaquetadorSession.SESSION_KEY);
	}


	protected final es.pode.empaquetador.negocio.servicio.SrvGestorManifestService getSrvGestorManifestService()
    throws java.lang.Exception
{
    String srvGestorManifestServiceFile="importedServices.properties";	    
    java.io.InputStream srvGestorManifestServiceInputStream=InicioEmpaquetadorController.class.getClassLoader().getResourceAsStream(srvGestorManifestServiceFile);
    java.util.Properties srvGestorManifestServiceProperties = new java.util.Properties();
    srvGestorManifestServiceProperties.load(srvGestorManifestServiceInputStream);
    String srvGestorManifestServiceEndPointAddress="";
    srvGestorManifestServiceEndPointAddress=(String) srvGestorManifestServiceProperties.get("srvGestorManifestServicePort");
    System.out.println("srvGestorManifestServiceEndPointAddress del fichero --> " + srvGestorManifestServiceEndPointAddress);
		es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceService srvGestorManifestService = new es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceServiceLocator();                                                                                                                                                                                                                                                    
    if (srvGestorManifestServiceEndPointAddress.length()>0) 
		((es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceServiceLocator)srvGestorManifestService).setSrvGestorManifestServiceEndpointAddress(srvGestorManifestServiceEndPointAddress);				
	es.pode.empaquetador.negocio.servicio.SrvGestorManifestService port = srvGestorManifestService.getSrvGestorManifestService();	    
    return port;
}

	protected final es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService getSrvGestorArchivosService()
    throws java.lang.Exception
{
    String srvGestorArchivosServiceFile="importedServices.properties";	    
    java.io.InputStream srvGestorArchivosServiceInputStream=InicioEmpaquetadorController.class.getClassLoader().getResourceAsStream(srvGestorArchivosServiceFile);
    java.util.Properties srvGestorArchivosServiceProperties = new java.util.Properties();
    srvGestorArchivosServiceProperties.load(srvGestorArchivosServiceInputStream);
    String srvGestorArchivosServiceEndPointAddress="";
    srvGestorArchivosServiceEndPointAddress=(String) srvGestorArchivosServiceProperties.get("srvGestorArchivosServicePort");
    System.out.println("srvGestorArchivosServiceEndPointAddress del fichero --> " + srvGestorArchivosServiceEndPointAddress);
		es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceService srvGestorArchivosService = new es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceServiceLocator();                                                                                                                                                                                                                                                    
    if (srvGestorArchivosServiceEndPointAddress.length()>0) 
		((es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceServiceLocator)srvGestorArchivosService).setSrvGestorArchivosServiceEndpointAddress(srvGestorArchivosServiceEndPointAddress);				
	es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService port = srvGestorArchivosService.getSrvGestorArchivosService();	    
    return port;
}
	
	public void validarNombreFichero(String nombre) throws ValidatorException
	{
		if(logger.isDebugEnabled()) logger.debug("inicio la validacion del nombre de fichero");
		if(nombre==null || nombre.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("el nombre es null o vacio, lanzo una exception");
    		throw new ValidatorException("{nuevo_grupo.error}");
		}
		
    	Matcher matcher = mask.matcher(nombre);
    	if(!matcher.matches())
    	{
    		if(logger.isDebugEnabled()) logger.debug("el nombre no coincide con el patron, nombre no válido");
    		throw new ValidatorException("{nuevo_grupo.error.caracterIlegal}");
    	}

	}
	
	public void validarNombreFicheroAgrega(String nombre) throws ValidatorException
	{
		if(logger.isDebugEnabled()) logger.debug("inicio la validacion del nombre de fichero");
		if(nombre==null || nombre.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("el nombre es null o vacio, lanzo una exception");
    		throw new ValidatorException("{nuevo_grupo.error}");
		}
		
    	Matcher matcher = mask.matcher(nombre);
    	if(!matcher.matches())
    	{
    		if(logger.isDebugEnabled()) logger.debug("el nombre no coincide con el patron, nombre no válido");
    		throw new ValidatorException("{nuevo_grupo.error.caracterIlegal}");
    	}

	}

	
	public void validarNombreCarpeta(String nombre) throws ValidatorException
	{
		if(logger.isDebugEnabled()) logger.debug("inicio la validacion del nombre de Carpeta");
		if(nombre==null || nombre.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("el nombre es null o vacio, lanzo una exception");
    		throw new ValidatorException("{nuevo_grupo.error}");
		}
		if(nombre.length()>80)
		{
			if(logger.isDebugEnabled()) logger.debug("la longitd del nombre de Carpeta es demasiada larga, lanzo una exception");
    		throw new ValidatorException("{portalempaquetado.nombre.validacion.error.longitud}");
		}
		
    	Matcher matcher = mask.matcher(nombre);
    	if(!matcher.matches())
    	{
    		if(logger.isDebugEnabled()) logger.debug("el nombre no coincide con el patron, nombre no válido");
    		throw new ValidatorException("{nuevo_grupo.error.caracterIlegalCarpeta}");
    	}

	}

	
	public ControlModeVO obtenerCM(SecuenciaVO[] sec) 
	{
		ControlModeVO cm = null;

		if(sec!=null && sec.length>0) {
			for(int i=0;i<sec.length&&cm==null;i++) {
				if(sec[i].getControlMode()!=null) {
					cm=sec[i].getControlMode();
				}
			}
		}
		if(cm==null) {
			cm = new ControlModeVO();
			cm.setChoice(Boolean.TRUE);
			cm.setChoiceExit(Boolean.FALSE);
			cm.setFlow(Boolean.TRUE);
			cm.setForwardOnly(Boolean.FALSE);
		}
		return cm;
	}
	
	public GrupoVO[] buscarHijosIdCollection(HttpServletRequest request) throws Exception {
		// Obtener hijos de grupo en edicion
		Object ultimoIdCollection = this.getEmpaquetadorSession(request)
				.getIdCollection().get(
						this.getEmpaquetadorSession(request).getIdCollection()
								.size()-1);
		GrupoVO[] hijos = null;
		if (ultimoIdCollection instanceof OrganizacionVO) {
			hijos = ((OrganizacionVO) ultimoIdCollection).getGrupos();
		} else if (ultimoIdCollection instanceof GrupoVO) {
			hijos = ((GrupoVO) ultimoIdCollection).getGrupos();
		} else {
			logger.error("No hay nada en el IdCollection");
			throw new Exception("No hay nada en el IdCollection");
		}
		return hijos;
	}
	
	public RecursoVO buscarRecurso(HttpServletRequest request, String idRecurso)
			throws Exception {
		RecursoVO[] recursos = this.getEmpaquetadorSession(request).getOde()
				.getRecursos();
		RecursoVO recurso = null;
		for (int i = 0; i < recursos.length && recurso == null; i++) {
			if (recursos[i].getIdentifier().equals(idRecurso)) {
				if (logger.isDebugEnabled())
					logger
							.debug("Encontrado RecursoVO seleccionado para principal");
				recurso = recursos[i];
			}
		}
		if (recurso == null) {
			logger.error("No se encuentra el recurso " + idRecurso);
			throw new Exception("No se encuentra el recurso " + idRecurso);
		}
		return recurso;
	}
	
	
	
	
    public  List rellenarBarraNavegacion(ArchivoVO[] archivo, String href) 
    {
    	List path = null;
		if (archivo != null) 
		{
			for (int i = 0; i < archivo.length && path==null; i++) 
			{
				
				if (archivo[i].getHref().equals(href)) 
				{
					path = new ArrayList();
					path.add(archivo[i]);
				} 
				else 
				{
					List tmpPath = rellenarBarraNavegacion(archivo[i].getContenidos(), href);
					if (tmpPath != null && tmpPath.size() > 0) 
					{
						path = new ArrayList();
						path.add(archivo[i]);
						path.addAll(tmpPath);
											
					}
				}
			}
		}
		return path;
	}

   public void iniciarDescargaFichero(DataHandler dh, HttpServletResponse response, String nombre) throws Exception{
		
		response.setContentType("application/zip");
    	response.setHeader("Content-Disposition", "attachment;filename="+nombre);
    	OutputStream out = response.getOutputStream();
    	logger.debug("Descargando fichero");
		dh.writeTo(out);
		
		out.flush();
	}
}
