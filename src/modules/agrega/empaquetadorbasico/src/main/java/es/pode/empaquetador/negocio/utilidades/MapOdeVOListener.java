/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.negocio.utilidades;

import java.util.HashMap;
import java.util.List;

import net.sf.dozer.util.mapping.event.DozerEvent;
import net.sf.dozer.util.mapping.event.DozerEventListener;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * Listener de dozer para el proceso en tiempo de ejecucion de los beans
 * mapeados.
 * 
 * @author fjespino
 * 
 */
public class MapOdeVOListener implements DozerEventListener {

	private final static Logger logger = Logger.getLogger(MapOdeVOListener.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.dozer.util.mapping.event.DozerEventListener#mappingFinished(net.sf.dozer.util.mapping.event.DozerEvent)
	 */
	public void mappingFinished(DozerEvent event) {
		/*
		 * Post-Proceso de los mapeos Manifest -> OdeVO: Ciertos atributos de
		 * OdeVO y de los VOs contenidos tienen que ser inicializados en funcion
		 * del resultado del mapeo. Para asegurarme de que el objeto mapeado es
		 * el OdeVO principal y no uno de sus submanifiestos, compruebo que el
		 * atributo ruta es null.
		 */
		if (event.getDestinationObject() instanceof OdeVO
				&& ((OdeVO) event.getDestinationObject()).getRuta() == null) {
			OdeVO ode = (OdeVO) event.getDestinationObject();
			HashMap referencias = generarMapaReferencias(ode);
//			String url = null;
//			String user = null;
//			SrvLocalizadorServiceServiceLocator locator = new SrvLocalizadorServiceServiceLocator();
//			try {
//				LocalizadorVO localizador = locator.getSrvLocalizadorService()
//						.consultaLocalizador(ode.getIdentifier());
//				url = localizador.getUrl();
//				user = localizador.getIdUsuario();
//			} catch (Exception e) {
//				Logger.getLogger(this.getClass()).error(
//						"No se pudo obtener una referencia al localizador.", e);
//			}
//			// Atributos del OdeVO
//			ode.setUsuario(user);
//			ode.setLocalizadorURL(url);

			completaGruposVO(ode, null, referencias);

			/*
			 * Busco referencias a metadatos externos en objetos LomVO. Uso el
			 * path del metadato externo junto al path del ODE para cargar el
			 * Lom y recuperar el título
			 */
			if(ode.getLom()!= null && ode.getLom().getMetadatoExterno() != null && event.getSourceObject() instanceof Manifest) {
				Manifest manifest = (Manifest)event.getSourceObject();
				String pathOde = manifest.getManifestBasePath();
				if(pathOde==null) {
					if(logger.isDebugEnabled()) logger.debug("El manifest no tiene manifestBasePath. No se ha podido comprobar la existencia de metadatos externos.");
				} else {
					if(logger.isDebugEnabled()) logger.debug("manifestBasePath = " + pathOde);
					if(ode.getLom()!=null && ode.getLom().getMetadatoExterno()!=null && ode.getLom().getTitulo()==null) {
						if(logger.isDebugEnabled()) logger.debug("Recuperando metadato externo " + pathOde + "/" + ode.getLom().getMetadatoExterno());
						ManifestAgrega ma = new ManifestAgrega(manifest);
						try {
							Lom lom = ma.obtenerLom(ode.getIdentifier(), null);
							if(lom!=null) {
								String idiomaUsuario = LdapUserDetailsUtils.getIdioma();
								LomAgrega la = new LomAgrega(lom);
								String titulo = null;
								if(idiomaUsuario!=null) {
									titulo = la.getGeneralAgrega().getTitulo(idiomaUsuario);
								}
								if(titulo== null) {
									List titulos = la.getGeneralAgrega().getTitulos();
									if(titulos!=null && titulos.size()>0) titulo = (String)titulos.get(0);
								}
								ode.getLom().setTitulo(titulo);
								ode.getLom().setIdioma(la.getMetaMetadataAgrega().getIdioma());
							}
						} catch (Exception e) {
							logger.error("Error durante la recuperación de metadato externo : " + e.getMessage());
							if(logger.isDebugEnabled()) logger.debug(e);
						}
						
					}
				}
			}
			
			
			// Fin del mapeo
			Logger.getLogger(this.getClass()).info(
					"Se ha posprocesado el Ode " + ode.getIdentifier());
		}
	}

	private void completaGruposVO(OdeVO ode, String base, HashMap referencias) {
		String baseModificado = (base == null ? "" : base);
		// Recursos
		completarRecursos(ode);
		// Submanifiestos
		OdeVO[] submanifiestos = ode.getSubmanifiestos();
		for (int i = 0; i < submanifiestos.length; i++) {
			submanifiestos[i].setLocalizadorURL(ode.getLocalizadorURL() + "/"
					+ submanifiestos[i].getRuta());
			String nextBase = null;
			if (base == null && submanifiestos[i].getRuta() == null)
				nextBase = null;
			else
				nextBase = baseModificado + submanifiestos[i].getRuta();
			completaGruposVO(submanifiestos[i], nextBase, referencias);
		}
		// Atributos de los GruposVO del Ode
		for (int i = 0; i < ode.getOrganizaciones().length; i++) {
			OrganizacionVO org = ode.getOrganizaciones()[i];
			for (int j = 0; j < org.getGrupos().length; j++) {
				completaGrupoVO(org.getGrupos()[j], ode.getLocalizadorURL(),
						referencias, ode.getIdentifier());
			}
		}

	}

	private void completarRecursos(OdeVO ode) {
		for (int i = 0; i < ode.getRecursos().length; i++) {
			ode.getRecursos()[i].setIdManifest(ode.getIdentifier());
			if (ode.getRecursos()[i].getHref() != null) {
				if(ode.getRecursos()[i].getFileList()==null || ode.getRecursos()[i].getFileList().length==0) {
					ode.getRecursos()[i].setRecursoURL(ode.getRecursos()[i].getHref());
				} else { 
					ode.getRecursos()[i].setRecursoURL(ode.getLocalizadorURL()
							+ "/" + ode.getRecursos()[i].getHref());
					// completo las url de los files
					for(int j=0;j<ode.getRecursos()[i].getFileList().length;j++) {
						FileVO file = ode.getRecursos()[i].getFileList()[j];
						file.setUrl(ode.getLocalizadorURL() + "/" + file.getHref());
					}
				}
			}
		}
	}

	/**
	 * Completa los atributos esCarpeta,esSubmanifiesto,esRecurso y recursoURL
	 * del objeto grupo.
	 * 
	 * @param grupo
	 * @param url
	 * @param referencias
	 */
	private void completaGrupoVO(GrupoVO grupo, String url,
			HashMap referencias, String identificadorOde) {
		String urlModificado = (url == null ? "" : (url + "/"));

		grupo.setIdManifest(identificadorOde);
		// ¿Contiene a otros grupos?
		if (grupo.getGrupos() != null && grupo.getGrupos().length > 0) {
			// Modifica los subgrupos
			for (int i = 0; i < grupo.getGrupos().length; i++) {
				completaGrupoVO(grupo.getGrupos()[i], url, referencias,
						identificadorOde);
			}
		} else
			grupo.setEsCarpeta(Boolean.FALSE);
		// ¿Referencia algun elemento del Ode?
		if (grupo.getElementoReferenciado() != null) {
			Object obj = referencias.get(grupo.getElementoReferenciado());
			if (obj instanceof RecursoVO) {
				RecursoVO recurso = (RecursoVO) obj;
				if(recurso.getFileList()==null || recurso.getFileList().length==0) {
					// Es una URL absoluta
					grupo.setRecursoURL(recurso.getHref());
				} else {
					// Es una referencia a un fichero
					grupo.setRecursoURL(recurso.getRecursoURL());
				}
				grupo.setEsRecurso(Boolean.TRUE);
				grupo.setEsSubmanifiesto(Boolean.FALSE);
			} else if (obj instanceof OdeVO) {
				grupo.setEsSubmanifiesto(Boolean.TRUE);
				grupo.setEsRecurso(Boolean.FALSE);
			}
		} else {
			grupo.setEsRecurso(Boolean.FALSE);
			grupo.setEsSubmanifiesto(Boolean.FALSE);
			grupo.setEsCarpeta(Boolean.TRUE);
		}
	}

	/**
	 * Genera un mapa con los recursos y submanifiestos del Ode
	 * 
	 * @param ode
	 * @return
	 */
	private HashMap generarMapaReferencias(OdeVO ode) {

		HashMap referencias = new HashMap(10);
		if (ode.getRecursos() != null) {
			for (int i = 0; i < ode.getRecursos().length; i++) {
				referencias.put(ode.getRecursos()[i].getIdentifier(), ode
						.getRecursos()[i]);
			}
		}
		if (ode.getSubmanifiestos() != null) {
			for (int i = 0; i < ode.getSubmanifiestos().length; i++) {
				referencias.put(ode.getSubmanifiestos()[i].getIdentifier(), ode
						.getSubmanifiestos()[i]);
			}
			// Para cada submanifiesto, referencias de recursos y submanifiestos
			for (int i = 0; i < ode.getSubmanifiestos().length; i++) {
				HashMap subReferencias = generarMapaReferencias(ode
						.getSubmanifiestos()[i]);
				referencias.putAll(subReferencias);
			}
		}

		return referencias;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.dozer.util.mapping.event.DozerEventListener#mappingStarted(net.sf.dozer.util.mapping.event.DozerEvent)
	 */
	public void mappingStarted(DozerEvent event) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.dozer.util.mapping.event.DozerEventListener#postWritingDestinationValue(net.sf.dozer.util.mapping.event.DozerEvent)
	 */
	public void postWritingDestinationValue(DozerEvent event) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.dozer.util.mapping.event.DozerEventListener#preWritingDestinationValue(net.sf.dozer.util.mapping.event.DozerEvent)
	 */
	public void preWritingDestinationValue(DozerEvent event) {
		// TODO Auto-generated method stub
	}

}
