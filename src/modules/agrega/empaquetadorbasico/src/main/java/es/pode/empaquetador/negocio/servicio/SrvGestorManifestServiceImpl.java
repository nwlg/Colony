/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.empaquetador.negocio.servicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.xml.rpc.ServiceException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.catalogacion.negocio.servicios.IdLomVO;
import es.pode.empaquetador.negocio.utilidades.Utilidades;
import es.pode.empaquetador.negocio.uuid.PodeUUIDGenerator;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.CompletionThreshold;
import es.pode.parseadorXML.castor.ControlMode;
import es.pode.parseadorXML.castor.DataFromLMS;
import es.pode.parseadorXML.castor.Dependency;
import es.pode.parseadorXML.castor.General;
import es.pode.parseadorXML.castor.Grp_any;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.MetaMetadata;
import es.pode.parseadorXML.castor.Metadata;
import es.pode.parseadorXML.castor.NavigationInterface;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Organizations;
import es.pode.parseadorXML.castor.Presentation;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.castor.Resources;
import es.pode.parseadorXML.castor.Sequencing;
import es.pode.parseadorXML.castor.TimeLimitAction;
import es.pode.parseadorXML.castor.types.HideLMSUIType;
import es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.IdentificadorAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.MetaMetadataAgrega;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosService;
import es.pode.soporte.serializar.SerializadorObjetos;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.soporte.zip.ZipDaoException;
import es.pode.validador.negocio.servicio.ValidaVO;

/**
 * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService
 */

public class SrvGestorManifestServiceImpl extends
		es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceBase {

	private static final String RUTA_SUBMANIFEST = "Ruta de destino del submanifest : ";

	private static final String TIPO_PADRE = "El objeto padre es de tipo ";

	private static final String VACIA = "";

	private static final String BARRA = "/";

	private CacheEmpaquetacion cacheEmpaquetacion;
	
	private Utilidades utilidades;

	private Logger logger = Logger.getLogger(this.getClass());

	public SrvGestorManifestServiceImpl() {
		super();
	}

	/**
	 * Carga un objeto manifests existente en la cache para su edición desde el
	 * Empaquetador.
	 * 
	 * @param identificador
	 *            Identificador del Ode a cargar.
	 * @return Identificador del Ode cargado
	 */
	@Override
	protected es.pode.empaquetador.negocio.servicio.OdeVO handleCargarManifest(
			java.lang.String identificador) throws java.lang.Exception {
		Manifest manifest;
		Object obj = cacheEmpaquetacion.get(identificador);
		OdeVO ode = null;

		if (obj instanceof es.pode.parseadorXML.castor.Manifest) {
			logger.debug("El ode " + ode + " es de tipo manifest");
			manifest = (Manifest) obj;
			ode = mapearManifestOdeVO(identificador, manifest);
			
		} else {
			if (obj == null) {
				ode = null;
			} else {
				logger.error("el ode " + ode + " no es de tipo manifest");
				throw new AlmacenamientoException("el ode no es de tipo manifest");
			}
		}
		return ode;
	}

	private OdeVO mapearManifestOdeVO(java.lang.String identificador,
			Manifest manifest) {
		OdeVO ode = new OdeVO();
		try {
			LocalizadorVO loc = getSrvLocalizadorService().consultaLocalizador(identificador);
			ode.setLocalizadorURL(loc.getUrl());
			ode.setUsuario(loc.getIdUsuario());
			ManifestAgrega ma = new ManifestAgrega(manifest);
			// Detecto si el ODE tiene secuencia para decidir en la previsualización
			ode.setConSecuencia(ma.tieneSecuencias());
		} catch (Exception e) {
			logger.error("El localizador " + identificador + " no existe",e);
		}
		getBeanMapper().map(manifest, ode);
		return ode;
	}

	/**
	 * Eliminar de la cache el objeto Manifest.
	 * 
	 * @param identificador
	 *            Identificador del objeto Manifest que se descargará de cache
	 * @return Boolean.TRUE indica éxito en la descarga del Ode
	 */
	@Override
	protected Boolean handleDescargarManifest(java.lang.String identificador)
			throws java.lang.Exception {
		Object obj = cacheEmpaquetacion.get(identificador);
		Boolean descarga;

		if (obj != null) {
			logger.debug("El objeto " + obj + " va a ser borrado");
			cacheEmpaquetacion.remove(identificador);
			descarga = Boolean.TRUE;
		} else {
			logger.warn("el objeto que se intenta borrar es null");
			descarga = Boolean.FALSE;
		}
		return descarga;
	}

	private String crearRuta(Manifest manifest, java.lang.String subId,
			java.lang.String path, LocalizadorVO localizador) {

		String ruta = localizador.getPath();
		if (subId != null) {
//			ruta = localizador.getPath();
//		} else {
			Manifest[] vectorManifest = manifest.getManifest();
			// voy a recorrer el array buscando el identificador del submanifest
			for (int i = 0; i < vectorManifest.length && path == null; i++) {
				logger.debug("Recorremos el vector de manifest buscando el identificador del submanifest");
				// llamada recursiva a obtenerSubm devuelve el path completo
				path = obtenerSubm(vectorManifest[i], subId);
			}
			ruta = ruta + BARRA + path;
		}
		if(!ruta.trim().endsWith(BARRA)) ruta=ruta+BARRA;
		if(logger.isDebugEnabled()) logger.debug("La ruta de destino para la importacion es " + ruta);
		return ruta;
	}

	/**
	 * Crea un objeto Item bajo la Organization / Item deseada a partir del
	 * Grupo
	 * 
	 * @param identificador
	 *            Identificador del ODE en edicion.
	 * @param grupoVO
	 *            Objeto VO con los datos del Item a crear.
	 * @param identificadorPadre
	 *            Identificador del objeto organization / item en el que se crea
	 *            el nuevo item.
	 * @return Identificador del item creado.
	 */
	@Override
	protected String handleCrearGrupo(
			java.lang.String identificador,
			es.pode.empaquetador.negocio.servicio.GrupoVO grupoVO,
			java.lang.String identificadorPadre) throws java.lang.Exception {

		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

//		logger.debug("voy a transformar el grupoVO pasado por parámetro en Item");
		Item nuevoItem = (Item) getBeanMapper().map(grupoVO, Item.class);

		// Object objeto = new Object();
		Object objeto = manifestAgrega.obtenerElemento(identificadorPadre);

		// buscar de que tipo es el object que devuelve
		if (objeto instanceof es.pode.parseadorXML.castor.Organization) {
			logger.debug(TIPO_PADRE+"organizacion");
			Organization org = (Organization) objeto;
			org.addItem(nuevoItem);
		} else if (objeto instanceof es.pode.parseadorXML.castor.Item) {
			logger.debug(TIPO_PADRE+"item");
			Item item = (Item) objeto;
			item.addItem(nuevoItem);
		} else {
			throw new AlmacenamientoException(TIPO_PADRE+"inesperado o es null");
		}

		// this.getBeanMapper().map(grupoVO,
		// manifestAgrega.obtenerItem(grupoVO.getIdentifier()));
		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return nuevoItem.getIdentifier();
	}

	/**
	 * Modifica un Item del ODE en edicion.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edicion.
	 * @param grupoVO
	 *            Grupo VO que identifica el ODE a cambiar y los cambios.
	 * @return Identificador del item modificado.
	 */
	@Override
	protected String handleModificarGrupo(
			java.lang.String identificador,
			es.pode.empaquetador.negocio.servicio.GrupoVO grupoVO)
			throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);;
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		logger.debug("Modificamos grupo con identificador= "
				+ grupoVO.getIdentifier());

		this.getBeanMapper().map(grupoVO,
				manifestAgrega.obtenerItem(grupoVO.getIdentifier()));
		
		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return grupoVO.getIdentifier();

	}

	/**
	 * Elimina el objeto Item deseado del ODE en edición.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param identificadorGrupo
	 *            Identificador del grupo a eliminar.
	 * @return Identificador del grupo eliminado.
	 */
	@Override
	protected String handleEliminarGrupo(
			java.lang.String identificador, java.lang.String identificadorGrupo)
			throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		logger.debug("voy a eliminar el grupo identificadorGrupo= "
				+ identificadorGrupo);

		Object padre = manifestAgrega.buscarPadre(identificadorGrupo);

		if (padre instanceof es.pode.parseadorXML.castor.Organization) {
			logger.debug(TIPO_PADRE+"organizacion");
			Organization org = (Organization) padre;
			org.removeItem(manifestAgrega.obtenerItem(identificadorGrupo));

		} else if (padre instanceof es.pode.parseadorXML.castor.Item) {
			logger.debug(TIPO_PADRE+"item");
			Item item = (Item) padre;
			item.removeItem(manifestAgrega.obtenerItem(identificadorGrupo));
		}

		else /*if (padre == null) */{
			throw new AlmacenamientoException(TIPO_PADRE+"inesperado o es null");
		}

		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return identificadorGrupo;

	}

	/**
	 * Añade un vinculo entre un Item y otro elemento (Resource o Manifest).
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param identificadorGrupo
	 *            Identificador del Grupo cuyo idRef debe apuntar al recurso.
	 * @param identificadorRecurso
	 *            Identificador del Recurso.
	 * @return Identificador del item modificado.
	 */
	@Override
	protected String handleVincularGrupo(
			java.lang.String identificador,
			java.lang.String identificadorGrupo,
			java.lang.String identificadorRecurso) throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		logger.debug("voy a vincular el grupo identificadorGrupo= "
				+ identificadorGrupo);
		manifestAgrega.obtenerItem(identificadorGrupo).setIdentifierref(
				identificadorRecurso);
		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return identificadorGrupo;

	}

	/**
	 * Desvincula el Item de su elemento referenciado.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param identificadorGrupo
	 *            Identificador del Grupo.
	 * @return Identificador del grupo modificado.
	 */
	protected String handleDesvincularGrupo(
			java.lang.String identificador, java.lang.String identificadorGrupo)
			throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		logger.debug("voy a desvincular el grupo identificadorGrupo= "
				+ identificadorGrupo);
		manifestAgrega.obtenerItem(identificadorGrupo).setIdentifierref(null);
		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return identificadorGrupo;

	}

	/**
	 * Genera un imsmanifest.xml a partir del objeto Manifest almacenado en la
	 * cache.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#guardarManifiesto(java.lang.String)
	 */
	@Override
	protected void handleGuardarManifiesto(java.lang.String identificador)
			throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);

		String ruta = localizador.getPath() + BARRA + Utilidades.MANIFEST_NAME;
		File fichero = new File(ruta);
		try {
			this.getScormDao().escribirODE(manifest, fichero);
		} catch (Exception e) {
			throw new AlmacenamientoException(
					"no se ha podido guardar el ode: " + identificador, e);
		}

		this.getSrvGestorArchivosService().eliminarBackup(identificador);
		this.getSrvGestorArchivosService().generarBackup(identificador);
		
		try {
			// Compruebo Lom del Ode.
//			ManifestAgrega ma = new ManifestAgrega(manifest);
			Lom lom = new ManifestAgrega(manifest).obtenerLom(manifest.getIdentifier(), null);
			LomAgrega la = new LomAgrega(lom);

			// Leo los datos del usuario. Compruebo configuracion para ver
			// si
			// accedo a seguridad o no.
			String idioma;
			String user;
			
			String offLine = utilidades.getProperty("empaquetador.offLine", "true");
			if ("false".equalsIgnoreCase(offLine)) {

				idioma = LdapUserDetailsUtils.getIdioma();
				user = LdapUserDetailsUtils.getUsuario();

			} else {
				user = utilidades.getProperty("usuario.offLine", "user");
				idioma = utilidades.getProperty("idioma.offLine", "es");
			}

			String titulo = null;
			try {
				titulo = la.getGeneralAgrega().getTitulo(idioma);
			} catch (Exception e) {
				logger.warn("No se pudo recuperar el titulo Lom-es para idioma "+ idioma, e);
			}
			if (titulo == null) {
				titulo = obtenerTituloProvisional("ode.sin.titulo",
						new Locale(idioma), identificador);
			}

//			String comentarios = VACIA;
			// Si no se ha catalogado, el titulo es null y no se modificara.
			if (logger.isDebugEnabled())
				logger
						.debug("Guardando cambios en publicacion para el manifest "
								+ identificador
								+ " con usuario "
								+ user
								+ " e idioma "
								+ idioma);
			if (!DecisorOffline.esOffline()) {
				this.getSrvPublicacionService().modificaODECreado(identificador, user, titulo, VACIA);
			} else {
				this.getDescomprimeYvalida().modificarOde(identificador, titulo);
			}
		} catch (Exception e) {
			logger.error("No se pudo modificar la transicion de "+ identificador + " al guardar los cambios",e);
		}
	}

	/**
	 * Crea una nueva organizacion para el ODE en edición.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param organizacion
	 *            VO con los datos de la organizacion a generar.
	 * @return Identificador de la nueva organizacion.
	 */
	@Override
	protected String handleCrearOrganizacion(
			java.lang.String identificador,
			es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion)
			throws java.lang.Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		Organization org = (Organization) this.getBeanMapper().map(
				organizacion, Organization.class);

		// obtengo las organizaciones del manifest y le añado la nueva
		Organizations orgs = manifest.getOrganizations();
		orgs.addOrganization(org);

		// hago el set al manifest de la org nueva
		logger.debug("voy a hacer el setOrganizations");
		manifest.setOrganizations(orgs);

		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return org.getIdentifier();
	}

	/**
	 * Elimina la organizacion del ODE en edición.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param idOrganizacion
	 *            Identificador de la organizacion a eliminar.
	 * @return Identificador de la organizacion eliminada.
	 */
	@Override
	protected String handleEliminarOrganizacion(
			java.lang.String identificador, java.lang.String idOrganizacion)
			throws java.lang.Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		// obtengo las organizaciones del manifest
		logger.debug("obtengo las organizaciones del manifest");
		Organizations orgs = manifest.getOrganizations();

		Organization org_a_borrar = manifestAgrega
				.obtenerOrganization(idOrganizacion);

		// fjespino: Si la organización a eliminar es la default, rotar default a la siguiente
		if(orgs.getDefault()!=null && orgs.getDefault().equals(org_a_borrar.getIdentifier())) {
			int i = Arrays.asList(orgs.getOrganization()).indexOf(org_a_borrar);
			if(i>-1 && i<orgs.getOrganizationCount()) {
				/*
				 * Tres casos:
				 * -Solo habia una organizacion -> Default = null
				 * -Habia mas de una y la eliminada era la ultima -> Default = orgs[0]
				 * -Otro caso -> Default = orgs[i+1]
				 */
				if(orgs.getOrganizationCount()==1) {
					if(logger.isDebugEnabled()) logger.debug("Solo habia una organizacion: default = null");
					orgs.setDefault(null);
				}
				else if(i==orgs.getOrganizationCount()-1) {
					if(logger.isDebugEnabled()) logger.debug("La organizacion eliminada era la ultima: default = orgs.getOrganization(0)");
					orgs.setDefault(orgs.getOrganization(0).getIdentifier());
				}
				else {
					if(logger.isDebugEnabled()) logger.debug("La organizacion eliminada no era la ultima: default = orgs.getOrganization(i+1)");
					orgs.setDefault(orgs.getOrganization(i+1).getIdentifier());
				}
			}
		}
		
		if (org_a_borrar != null) {
			orgs.removeOrganization(org_a_borrar);
		} else {
			logger.debug("El identificador es incorrecto");
		}

		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return idOrganizacion;
	}

	/**
	 * Modifica la organización deseada.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param organizacion
	 *            VO de la organizacion a modificar.
	 * @return Identificador de la organizacion modificada.
	 */
	@Override
	protected String handleModificarOrganizacion(
			java.lang.String identificador,
			es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion)
			throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		logger.debug("voy a modificar la organización identificador= "
				+ organizacion.getIdentifier());
		this.getBeanMapper().map(
				organizacion,
				manifestAgrega
						.obtenerOrganization(organizacion.getIdentifier()));

		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return organizacion.getIdentifier();

	}

	/**
	 * Cambia la organizacion por defecto.
	 * @param identificador Identificador del ODE en edición.
	 * @param idOrganizacion Identificador de la organización por defecto.
	 * @return Identificador de la nueva organizacion por defecto
	 * @throws Exception
	 */
	@Override
	protected String handleFijarOrganizacionPorDefecto(
			java.lang.String identificador, java.lang.String idOrganizacion)
			throws java.lang.Exception {
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
		manifestAgrega.setManifest(manifest);

		// obtengo las organizaciones del manifest
		logger.debug("obtengo las organizaciones del manifest");
		Organizations orgs = manifest.getOrganizations();

		// fijo la organizacion por defecto
		Organization org_Por_Defecto = manifestAgrega
				.obtenerOrganization(idOrganizacion);

		if (org_Por_Defecto != null) {
			orgs.setDefault(org_Por_Defecto.getIdentifier());
		} else {
			logger.debug("El identificador es incorrecto");
		}

		cacheEmpaquetacion.put(identificador, manifest);
		logger.debug("Introducimos manifest de id="+identificador+" en la cache");

		return idOrganizacion;
	}

	private Manifest submanifestValidado(String rutaSubmanifest,
			String submanifestId) throws ParseadorException {
		Manifest submanifest = null;

		logger.debug("la validacion binaria de la rutaManifest ha sido correcta");
		logger.debug("voy a pasear el submanifest");

		File ficheroRutaSubm = new File(rutaSubmanifest + BARRA + Utilidades.MANIFEST_NAME);
		submanifest = getScormDao().parsearODELazy(ficheroRutaSubm);

		logger.debug("voy a insertar el nuevo identificador: " + submanifestId);
		submanifest.setIdentifier(submanifestId);

		logger.debug("voy a insertar el atributoBase: " + submanifestId + BARRA);
		submanifest.setBase(submanifestId + BARRA);
		ManifestAgrega ma = new ManifestAgrega(submanifest);
		ma.resetearIds();
		return submanifest;
	}

	// llamada recursiva para obtener el path para descomprimir, se llama desde
	// AgregarManifiestoZIP
	private String obtenerSubm(Manifest manif, String id) {
		Manifest resultado = null;
		Manifest[] vectMan = manif.getManifest();
		String path = VACIA;
		String base = VACIA;

		if (!manif.getIdentifier().equals(id)) {
			if ((vectMan != null) && (vectMan.length != 0)) {
				for (int i = 0; i < vectMan.length && resultado == null; i++) {

					if (vectMan[i] != null
							&& vectMan[i].getIdentifier().equals(id)) {
						if (vectMan[i].getBase() == null)
							path = base;
						else
							path = vectMan[i].getBase();

					} else if (vectMan[i].getManifest() != null) {
						String tmp = obtenerSubm(vectMan[i], id);
						if (tmp != null) {
							if (vectMan[i].getBase() == null)
								path = BARRA + tmp;
							else
								path = vectMan[i].getBase() + BARRA + tmp;
						} else {
							path = null;
						}
					}
				}
			}

		} else
			path = manif.getBase() == null ? VACIA : manif.getBase();
		return path;
	}

	/**
	 * Agrega un ODE comprimido en un ZIP como submanifiesto del ODE actual.
	 * 
	 * @param identificador
	 *            Identificador del ODE sobre el que estamos trabajando.
	 * @param paqueteSCORM
	 *            Archivo comprimido conteniendo el paquete SCORM que se quiere
	 *            agregar como submanifiesto del ODE en que se está trabajando.
	 * @param subId
	 *            Este atributo, cuando es distinto de null, indica el
	 *            submanifiesto del manifiesto principal en que se desea agregar
	 *            el nuevo manifiesto. El metodo internamente debe resolver el
	 *            'base' completo donde deben descomprimirse los archivos del
	 *            submanifiesto.
	 * @return Identificador del submanifiesto agregado
	 * @throws Exception
	 */
	@Override
	protected String handleAgregarManifiestoZIP(
			java.lang.String identificador,
			javax.activation.DataHandler paqueteSCORM, String subId)
			throws java.lang.Exception {
		

		// obtengo un id para el submanifiesto
		String submanifestId = PodeUUIDGenerator.getSubmanifiestoUUID(String.valueOf(System.currentTimeMillis()));
		LocalizadorVO localizador = getSrvLocalizadorService().consultaLocalizador(identificador);
		
		String rutaZip = utilidades.obtenerRutaTemporal(identificador, localizador.getPath(),true) + BARRA + submanifestId + ".zip";
		
		File nuevoFichero = new File(rutaZip);
		
		if(logger.isDebugEnabled()) logger.debug("Volcando fichero zip a disco : " + nuevoFichero.getPath());
		nuevoFichero.createNewFile();
		nuevoFichero.deleteOnExit();
		FileOutputStream fos = new FileOutputStream(nuevoFichero);
		paqueteSCORM.writeTo(fos);
		IOUtils.closeQuietly(fos);
		if(logger.isDebugEnabled()) logger.debug(nuevoFichero.getPath() + " volcado a disco.");
		
		try {
			agregarLocal(identificador, subId, submanifestId, null, localizador,
				nuevoFichero);
		} catch (Exception e) {
			logger.error("Error al agrega submanifiesto desde fichero local " + nuevoFichero,e);
			throw e;
		} finally {
			FileUtils.deleteQuietly(nuevoFichero);
		}
		return submanifestId;
	}

	@Override
	protected String handleAgregarManifiestoZipUrl(String identificador,
			String fichero, String subId) throws Exception {
		// obtengo un id para el submanifiesto
		String submanifestId = PodeUUIDGenerator.getSubmanifiestoUUID(String.valueOf(System.currentTimeMillis()));
		String path = null;
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		try {
			agregarLocal(identificador, subId, submanifestId, path, localizador,
				new java.io.File(fichero));
		} catch (Exception e) {
			logger.error("Error al agrega submanifiesto desde fichero local " + fichero,e);
			throw e;
		} finally {
			FileUtils.deleteQuietly(new java.io.File(fichero));
		}
		return submanifestId;
	}
	
	
	private void agregarLocal(java.lang.String identificador, String subId,
			String submanifestId, String path, LocalizadorVO localizador,
			File nuevoFichero) throws Exception, ZipDaoException,
			RemoteException, ParseadorException, AlmacenamientoException {
		Manifest submanifest_padre;
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		if (subId != null) {
			submanifest_padre = cacheEmpaquetacion.comprobarManifest(subId);
		} else {
			submanifest_padre = manifest;
		}
		
		String rutaSubmanifest = crearRuta(manifest, subId, path, localizador);
//		if(rutaSubmanifest.trim().endsWith(BARRA))
//		{
			rutaSubmanifest = rutaSubmanifest+submanifestId;
//		}
//		else
//		{
//			rutaSubmanifest = rutaSubmanifest + BARRA+submanifestId;
//		}
		if(logger.isDebugEnabled()) logger.debug(RUTA_SUBMANIFEST + rutaSubmanifest);
		
		if (this.getZipDao().esZip(nuevoFichero.getPath())) {
			logger.debug("el fichero: " + nuevoFichero.getName() + " es .zip");
			File destino = new File(rutaSubmanifest);
			boolean destinoResult = destino.mkdirs();
				
			logger.debug("vamos a comprobar que la carpeta: "
					+ destino.getName()
					+ " donde se va a descomprimir el zip existe");
			if(destinoResult) {
				logger.debug("la carpeta: " + destino.getName()
						+ " donde se va a descomprimir el zip existe");
			}
			this.getZipDao().descomprimir(nuevoFichero.getPath(),
					rutaSubmanifest);
			logger.debug("validacion binaria de la rutaManifest");
			// Boolean valido;
//			Boolean valido = getSrvValidadorService()
//					.obtenerValidacionBin(rutaSubmanifest)
//					.getEsValidoManifest();
//
//			if (valido.booleanValue()) {
//
//				Manifest submanifest = submanifestValidado(rutaSubmanifest,
//						submanifestId);
//
////				if (subId == null) {// desciende del principal
////					manifest.addManifest(submanifest);
////				} else {
//					submanifest_padre.addManifest(submanifest);
//
////				}
//
//				cacheEmpaquetacion.put(identificador, manifest);
//
//				logger.debug("se ha introducido el manifest en la cache");
//			} else {
//				logger.debug("La validacion binaria del ODE agregado ha fallado");
//				rollBackAgregarSubmanifiesto(destino);
//				throw new AlmacenamientoException(
//						"La validacion binaria del ODE agregado ha fallado");
//			}
			validacionManifestAgregado(identificador, submanifest_padre, manifest,
					submanifestId, rutaSubmanifest, destino);
		} else {
			String msg ;
			if (!getZipDao().esZip(nuevoFichero.getPath())) {
				msg = "El fichero " + nuevoFichero.getPath()
				+ " no es .zip";
			} else {
				msg = "El fichero " + nuevoFichero.getPath()
						+ "no existe";
			}
			logger.error(msg);
			throw new AlmacenamientoException(msg);
		}
	}

	/**
	 * Agrega un ODE del repositorio como submanifiesto del ODE actual.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se está trabajando.
	 * @param localizador
	 *            Localizador del ODE publicador que se quiere agregar.
	 * @param subId
	 *            Este atributo, cuando es distinto de null, indica el
	 *            submanifiesto del manifiesto principal en que se desea agregar
	 *            el nuevo manifiesto. El metodo internamente debe resolver el
	 *            'base' completo donde deben descomprimirse los archivos del
	 *            submanifiesto.
	 * @return Identificador del submanifiesto agregado
	 * @throws Exception
	 */
	@Override
	protected String handleAgregarManifiestoRepositorio(
			java.lang.String identificador, java.lang.String localizador,
			String subId) throws java.lang.Exception {
		
		Manifest submanifest_padre;
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(identificador);
		if (subId != null) {
			submanifest_padre = cacheEmpaquetacion.comprobarManifest(identificador);
		} else {
			submanifest_padre=manifest;
		}

		// BLOQUE ÚNICO
		String submanifestId = PodeUUIDGenerator.getSubmanifiestoUUID(this.getClass().toString());
		LocalizadorVO destin = getSrvLocalizadorService().consultaLocalizador(identificador);
		LocalizadorVO orig = getSrvLocalizadorService().consultaLocalizador(localizador);
		manifest = (Manifest) cacheEmpaquetacion.get(identificador);

		String rutaDest = crearRuta(manifest, subId, null, destin);
//		rutaDest = rutaDest + BARRA + submanifestId;
		rutaDest = rutaDest + submanifestId;
		if(logger.isDebugEnabled()) logger.debug(RUTA_SUBMANIFEST + rutaDest);
	
		String rutaOrig = orig.getPath();
		File origen = new File(rutaOrig);
		logger
				.debug("Voy a crear la carpeta destino donde voy a copiar los datos");
		File destino = new File(rutaDest);
		boolean destinoResult = destino.mkdir();
		if(!destinoResult) {
			logger.error("No se ha podido crear la carpeta " + destino.getPath());
			throw new AlmacenamientoException("No se ha podido crear la carpeta " + destino.getPath());
		}
		if(logger.isDebugEnabled()) logger.debug("Copiando archivos de " + origen + " a " + destino);
		UtilesFicheros.copiar(origen, destino);
		// /BLOQUE UNICO
		
		logger.debug("Validando " + rutaDest);
		validacionManifestAgregado(identificador, submanifest_padre, manifest,
				submanifestId, rutaDest, destino);

		return submanifestId;
	}

	/**
	 * @param identificador
	 * @param submanifest_padre
	 * @param manifest
	 * @param submanifestId
	 * @param rutaDest
	 * @param destino
	 * @throws RemoteException
	 * @throws Exception
	 * @throws ParseadorException
	 * @throws AlmacenamientoException
	 */
	private void validacionManifestAgregado(java.lang.String identificador,
			Manifest submanifest_padre, Manifest manifest,
			String submanifestId, String rutaDest, File destino)
			throws RemoteException, Exception, ParseadorException,
			AlmacenamientoException {
		Boolean valido = this.getSrvValidadorService().obtenerValidacionBin(
				rutaDest).getEsValidoManifest();
		if (valido.booleanValue()) {
			// metodo privado
			// Manifest submanifest = submanifestValidado(rutaDest,
			// submanifestId);
			// manifest.addManifest(submanifest);

			Manifest submanifest = submanifestValidado(rutaDest, submanifestId);

//			if (subId == null) {// desciende del principal
//				manifest.addManifest(submanifest);
//			} else {
				submanifest_padre.addManifest(submanifest);

//			}

			cacheEmpaquetacion.put(identificador, manifest);
			logger.debug("se ha introducido el manifest en la cache");
		} else {
			logger.debug("la validacion binaria de la rutaManifest NO ha sido correcta");
			// Borrando carpeta
			rollBackAgregarSubmanifiesto(destino);
			throw new AlmacenamientoException(
					"la validacion binaria de la rutaManifest NO ha sido correcta");
		}
	}

	private boolean rollBackAgregarSubmanifiesto(File path) {
		// Borro el directorio creado al agregar submanifiesto
		boolean delete =false;
		try {
			UtilesFicheros.eliminar(path);
			delete = path.delete();
		} catch (Exception e) {
			logger.error("No se ha podido borrar la carpeta del submanifiesto " + path);
			if(logger.isDebugEnabled()) logger.debug(e);
		}
		return delete;
	}
	
	/**
	 * Desagrega un submanifiesto a la carpeta taller del usuario.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se esta trabajando
	 * @param submanifiestold
	 *            Identificador del submanifiesto que se quiere desagregar.
	 * @param subId
	 *            Este atributo, cuando es distinto de null, indica el
	 *            submanifiesto del manifiesto principal en que se desea agregar
	 *            el nuevo manifiesto. El metodo internamente debe resolver el
	 *            'base' completo donde deben buscarse los archivos del
	 *            submanifiesto.
	 * @throws Exception
	 */
	@Override
	protected void handleDesagregarSubmanifiestoRepositorio(
			java.lang.String identificador, java.lang.String submanifiestold,
			String subId) throws java.lang.Exception {

		Manifest manifest = null;
		Manifest submanifiestoDesagregar = null;
		manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega ma = new ManifestAgrega(manifest);
		Object obj = ma.obtenerElemento(submanifiestold);
		if (obj instanceof Manifest) {
			submanifiestoDesagregar = (Manifest) obj;
		} else return; //Si no es un Manifest, no tiene mucho sentido seguir con la operación

		Manifest aux;
		String nuevoId = PodeUUIDGenerator.getOdeUUID(String.valueOf(java.lang.Math.random()));
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		// String pathSubmanifiesto = submanifiestoDesagregar.getBase();

		String idUsuario = localizador.getIdUsuario();

		// hago un clon y modifico los datos
		aux = (Manifest) getScormDao().getBeanMapper().map(
				submanifiestoDesagregar, Manifest.class);
		aux.setBase(null);
		aux.setIdentifier(nuevoId);
		logger.debug("vamos a publicar el submanifiesto con id: " + nuevoId);
		/*
		 * Compruebo si tiene título. Si no, le genero uno provisional.
		 */
		ManifestAgrega maSubManifiesto = new ManifestAgrega(
				submanifiestoDesagregar);
		Lom lomSubmanifiesto = maSubManifiesto.obtenerLom(
				submanifiestoDesagregar.getIdentifier(), null);
		String titulo = null;
//		 Leo los datos del usuario. Compruebo configuracion para ver si
		// accedo a seguridad o no.
		String idioma = null;
		String user = null;
		String offLine = utilidades.getProperty("empaquetador.offLine","true");
		if ("false".equalsIgnoreCase(offLine)) {
			
			idioma = LdapUserDetailsUtils.getIdioma();
			user = LdapUserDetailsUtils.getUsuario();
			
		} else {
			user = utilidades.getProperty("usuario.offLine","user");
			idioma = utilidades.getProperty("idioma.offLine","es");
		}
		
		if (lomSubmanifiesto == null) {
			titulo = obtenerTituloProvisional("ode.sin.titulo", new Locale(
					idioma), submanifiestoDesagregar.getIdentifier());
		} else {
			LomAgrega la = new LomAgrega(lomSubmanifiesto);
			
			titulo = la.getGeneralAgrega().getTitulo(idioma);
			if (titulo == null)
				titulo = obtenerTituloProvisional("ode.sin.titulo", new Locale(
						idioma), submanifiestoDesagregar.getIdentifier());
		}
		if (logger.isDebugEnabled())
			logger
					.debug("Creando transicion de publicacion para el manifiesto desagregado "
							+ submanifiestoDesagregar.getIdentifier()
							+ " con usuario " + user + " e idioma " + idioma);
		try {
			ResultadoOperacionVO publica = this.getSrvPublicacionService().creacion(nuevoId,
					idUsuario, utilidades.getProperty("desagregar.comentario", null),
					titulo);
			if ("0.0".equals(publica.getIdResultado())) {

				LocalizadorVO nuevoLocId = this.getSrvLocalizadorService()
						.consultaLocalizador(nuevoId);

				logger.debug("el submanifiesto con id: " + submanifiestold
						+ " sera copiado sus contenidos");
				File origen;
				File destino;
				String rutaOrigen = VACIA;
				String path = null;

				destino = new File(nuevoLocId.getPath());

				rutaOrigen = crearRuta(manifest, subId, path, localizador);
				rutaOrigen = rutaOrigen + BARRA + submanifiestold;
				origen = new File(rutaOrigen);

				UtilesFicheros.copiar(origen, destino);

				File imsManifest = new File(nuevoLocId.getPath() + BARRA
						+ Utilidades.MANIFEST_NAME);
				this.getScormDao().escribirODE(aux, imsManifest);

			}
		} catch (Exception e) {
			logger.error("No se ha podido publicar correctamenta", e);
			throw new AlmacenamientoException(
					"Error al realizar la publicacion", e);
		}

	}

	/**
	 * Desagrega un submanifiesto del ODE en que se esta trabajando para que el
	 * usuario lo tenga disponible en local. Esto implica comprimir el
	 * submanifiesto a un archivo ZIP y dejarlo temporalmente en lugar accesible
	 * por HTTP para su descarga. El valor de retorno es la URL al archivo
	 * generado.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que es esta trabajando.
	 * @param subId
	 *            Identificador del submanifiesto que se quiere desagregar.
	 * @param parentId
	 *            Este atributo, cuando es distinto de null, indica el
	 *            submanifiesto del manifiesto principal en que se desea agregar
	 *            el nuevo manifiesto. El metodo internamente debe resolver el
	 *            'base' completo donde deben buscarse los archivos del
	 *            submanifiesto.
	 * @return URL del nuevo fichero que contiene el submanifiesto desagregado
	 * @throws Exception
	 */
	@Override
	protected DataHandler handleDesagregarSubmanifiestoLocal(String identificador,
			String subId, String parentId) throws Exception {

		Manifest manifest;
		Manifest submanifiestoDesagregar;
		manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega ma = new ManifestAgrega(manifest);
		Object obj = ma.obtenerElemento(subId);
		if (obj instanceof Manifest) {
			submanifiestoDesagregar = (Manifest) obj;
		} else {
			logger.error("Se ha intentado desagregar un submanifiesto ("
					+ subId + ") que no existe en el manifiesto "
					+ parentId);
			throw new AlmacenamientoException(
					"Se ha intentado desagregar un submanifiesto ("
							+ subId
							+ ") que no existe en el manifiesto " + parentId);
		}

		Manifest aux /* = new Manifest() */;
		String nuevoId = PodeUUIDGenerator.getOdeUUID(this.getClass()
				.toString());
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		// String pathSubmanifiesto = submanifiestoDesagregar.getBase();

		// String idUsuario = localizador.getIdUsuario();

		// hago un clon y modifico los datos
		aux = (Manifest) getScormDao().getBeanMapper().map(
				submanifiestoDesagregar, Manifest.class);
		aux.setBase(null);
		aux.setIdentifier(nuevoId);
		logger.debug("vamos a publicar el submanifiesto con id: " + nuevoId);

		logger.debug("el submanifiesto con id: " + subId
				+ " sera copiado sus contenidos");
		// rutaDestino=localizador.getPath()+"/"+
		// props.getProperty("carpeta.temporal")+"/"+nuevoId+ "/"+ nuevoId
		// +".zip";
		
		String rutaDestino = utilidades.obtenerRutaTemporal(identificador, localizador.getPath(),true);
		String rutaOrigen = crearRuta(manifest, subId, null, localizador);
		this.getScormDao().escribirODE(aux, rutaDestino+ BARRA + Utilidades.MANIFEST_NAME);
		
		if(parentId!=null)
		{
			rutaOrigen = rutaOrigen + BARRA + parentId;
		}
		String nombreZip = rutaDestino + BARRA + nuevoId + ".zip";
		if (parentId == null) {
			if(logger.isDebugEnabled()) logger.debug("Comprimiendo ODE localizado en " + rutaOrigen + " al archivo " + nombreZip);
			this.getZipDao().comprimir(nombreZip,rutaOrigen);
		} else {
			String tmp = localizador.getPath() + BARRA + rutaOrigen;
			if(logger.isDebugEnabled()) logger.debug("Comprimiendo ODE localizado en " + tmp + " al archivo " + nombreZip);
			this.getZipDao().comprimir(nombreZip,tmp);
		}
		DataHandler dh = utilidades.serializarExportado(nombreZip);
		return dh;

	}

	/**
	 * Comienza la edicion de un ODE existente en la carpeta taller del usuario.
	 * Esta operacion incluye cargar el Manifest en la cache, generar un backup
	 * de los contenidos previos y registrar los objetos Lom asociados al Ode en
	 * el servicio de catalogación. El resultado es un objeto OdeVO con los
	 * datos del ODE a editar.
	 * 
	 * @param identificador
	 *            Identificador del Ode que se desea editar.
	 * @return Ode modificado
	 * @throws Exception
	 */
	@Override
	protected OdeVO handleEditarODE(String identificador) throws Exception {
		Manifest manifest = null;
		Object obj = cacheEmpaquetacion.get(identificador);
		OdeVO ode = null;

		if (obj instanceof es.pode.parseadorXML.castor.Manifest) {
			logger
					.warn("Se ha editado el ODE "
							+ ode
							+ " cuando ya estaba en la cache de edicion. Se eliminara para volver a editarlo.");
			this.descargarManifest(identificador);

		}
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		File ruta = new File(localizador.getPath() + BARRA + Utilidades.MANIFEST_NAME);
		if(ruta.exists() && ruta.isFile())
		{
			manifest = this.getScormDao().parsearODELazy(ruta);
	
			logger.debug("voy a introducir el manifest en la cache");
			cacheEmpaquetacion.put(identificador, manifest);
			ode = mapearManifestOdeVO(identificador, manifest);
		}
		else
		{
			ode = manifestInicial(identificador,null,null);
		}
		logger.debug("voy a generar el backup");
		this.getSrvGestorArchivosService().generarBackup(identificador);

		logger.debug("voy a mapear el ODE y devolverlo");

		return ode;
	}

	/**
	 * Elimina un submanifiesto del ODE en que se esta trabajando. No elimina
	 * los archivos, ya que esta funcionalidad se puede realizar desde el gestor
	 * de archivos.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que estamos trabajando.
	 * @param submanifiestoId
	 *            Identificador del submanifiesto que se desea eliminar.
	 * @param idSubmanifestPadre
	 *            Identificador del submanifiesto en que estamos navegando, y
	 *            que es el padre del submanifiesto a eliminar. Si estamos
	 *            navegando en el manifiesto principal, idSUbmanifestPadre =
	 *            null
	 * @return Ode modificado
	 * @throws Exception
	 */
	@Override
	protected String handleEliminarSubmanifiesto(String identificador,
			String submanifiestoId, String idSubmanifestPadre) throws Exception {
		
		Manifest manifest = null;
		String  nombreSubmanifiestoEliminar = VACIA;
		String idPadre = idSubmanifestPadre == null ? identificador : idSubmanifestPadre;
		Object obj = cacheEmpaquetacion.get(idPadre);
		OdeVO ode = null;

		if (obj instanceof es.pode.parseadorXML.castor.Manifest) {
			logger.debug("El ode " + ode + " es de tipo manifest");
			manifest = (Manifest) obj;
			Manifest[] arrayManifest = manifest.getManifest();
			ArrayList tempList = new ArrayList();
			tempList.addAll(Arrays.asList(arrayManifest));

			for (int i = 0; i < tempList.size(); i++) {
				if (((Manifest) tempList.get(i)).getIdentifier().equals(submanifiestoId)){
					//Submanifiesto a eliminar
					nombreSubmanifiestoEliminar = ((Manifest) tempList.get(i)).getBase();	
					tempList.remove(i);
				}
			}
			logger.debug("voy a insertar en el manifest el nuevo array de Submanifest sin el que quiero borrar");			
			manifest.setManifest((Manifest[]) tempList.toArray(new Manifest[tempList.size()]));
			
			//Hallar la carpeta padre
			Manifest principal = (Manifest)cacheEmpaquetacion.get(identificador);
			String path = null;
			for (int i = 0; i < principal.getManifestCount() && path == null; i++) {
				// llamada recursiva a obtenerSubm devuelve el path completo
				path = obtenerSubm(principal.getManifest(i), idSubmanifestPadre);
			}
			if(logger.isDebugEnabled()) logger.debug("Ruta relativa del submanifiesto " + idSubmanifestPadre + " : " + path);
//			rutaSubmanifest = crearRuta(manifest, idSubmanifestPadre, null, this.getSrvLocalizadorService().consultaLocalizador(identificador));
			//Se elimina los recursos		
			ArchivoVO ficheros = new ArchivoVO();
				ficheros.setCarpetaPadre(path);					
				ficheros.setEsFichero(Boolean.FALSE);				
				ficheros.setNombre(nombreSubmanifiestoEliminar);					
			this.getSrvGestorArchivosService().eliminar(identificador, new ArchivoVO[]{ficheros});
		} else {
			if (obj == null) {
				ode = null;
			} else {
				logger.warn("el ode " + ode + " no es de tipo manifest");
				throw new AlmacenamientoException(
						"el ode no es de tipo manifest");
			}
		}
		cacheEmpaquetacion.put(idPadre, manifest);

		return submanifiestoId;

	}

	private String obtenerTituloProvisional(String key, Locale locale,
			String identificador) {
		/*
		 * Generamos un titulo provisional para el Ode, que se registrara en la
		 * tabla de transiciones.
		 */
		String tituloProvisional = null;
		try {
			ResourceBundle i18n = ResourceBundle.getBundle(
					"application-resources", locale);
			tituloProvisional = i18n.getString(key);
		} catch (Exception e) {
			logger.error(
					"No se pudo recuperar el ResourceBundle application-resources para locale "
							+ locale.getLanguage(), e);
		}
		if (tituloProvisional == null) {
			logger
					.error("No se ha recuperado el mensaje internacionalizado ode.sin.titulo para locale "
							+ locale.getLanguage());
			tituloProvisional = identificador;
		} else
			tituloProvisional = tituloProvisional.concat(" (").concat(
					identificador).concat(")");
		return tituloProvisional;
	}
	
	private OdeVO manifestInicial(String odeId, String titulo, String idioma)
	{
		Manifest manifest = new Manifest();
		manifest.setIdentifier(odeId);
		String ident = PodeUUIDGenerator.getOrganizacionUUID(this.getClass()
				.toString());
		logger.debug("voy a añadir la Organization a las Organizations");

		// creo una organizacion
		logger.debug("voy a crear organizacion");
		Organizations orgs = new Organizations();
		orgs.setDefault(ident);
		Organization org = new Organization();
		org.setIdentifier(ident);
		org.setTitle(utilidades.getProperty("organizacion.por.defecto"));
		orgs.addOrganization(org);

		logger.debug("inserto las Organizations en el  manifest");
		manifest.setOrganizations(orgs);

		// recursos vacios
		logger.debug("voy a insertar recurso vacío");
		Resources res = new Resources();
		manifest.setResources(res);

		// metadatas
		logger.debug("voy a crear metadata");
		Metadata metadata = generarScormMetadata();

		logger.debug("voy a insertar el metadata en el manifest");
		manifest.setMetadata(metadata);

		// Lomes: Si hay titulo inicial, creo un Lomes para incorporarlo
		if(titulo != null && idioma != null) {
			try {
				
				manifest.getMetadata().setGrp_any(new Grp_any());
				manifest.getMetadata().getGrp_any().addAnyObject(generarLomInicial(titulo, idioma, manifest.getIdentifier()));
			} catch (Exception e) {
				logger.error("No se pudo crear LOM-ES con titulo inicial para el ODE " + manifest.getIdentifier());
				if(logger.isDebugEnabled()) logger.debug(e);
			}
		}
		cacheEmpaquetacion.put(odeId, manifest);
		return (OdeVO) this.getBeanMapper().map(manifest, OdeVO.class);
	}

	private Metadata generarScormMetadata() {
		Metadata metadata = new Metadata();
		metadata.setSchema(utilidades.getProperty("empaquetador.crearOde.schema"));
		metadata.setSchemaversion(utilidades
				.getProperty("empaquetador.crearOde.schemaversion"));
		return metadata;
	}

	private Lom generarLomInicial(String titulo, String idioma, String identificador) throws Exception {
		Lom lom = new Lom();
		LomAgrega la = new LomAgrega(lom);
		GeneralAgrega ga = new GeneralAgrega(new General());
		ga.addTituloIdioma(idioma, titulo);
		IdentificadorAgrega id = new IdentificadorAgrega();
		id.setCatalogo(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.CATALOGO_AGREGA));
		id.setEntrada(identificador);
		ArrayList lista = new ArrayList();
		lista.add(id);
		ga.setIdentificadoresAv(lista);
		la.setGeneralAgrega(ga);
		/*
		 * Recupero el esquema de metadatos
		 */
		MetaMetadataAgrega metaA = new MetaMetadataAgrega(new MetaMetadata());
		String schema = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.ESQUEMA_LOMES);
		if(logger.isDebugEnabled()) logger.debug("Esquema de metadatos : " + schema);
		metaA.addEsquemaDeMetadatos(schema);
		// Idioma del metadato = idioma del usuario que cataloga
		metaA.setIdioma(idioma);
		la.setMetaMetadataAgrega(metaA);
		return la.getLom();
	}
	
	
	/**
	 * Inicia la edición de un nuevo ODE. Para ello, crea un localizador no
	 * publicador, registra un nuevo Manifest en la cacheEmpaquetacion, crea la
	 * estructura de carpetas inicial y inicia la catalogacion con un Lom vacío.
	 * El resultado es un OdeVO describiendo el nuevo ODE.
	 * 
	 * @param user
	 *            Identificación del usuario con el que se creará el Ode.
	 * @return nuevo Ode
	 * @throws Exception
	 */
	@Override
	protected OdeVO handleIniciarNuevoODE(String user, String titulo, String idioma) throws Exception {

		String odeId = PodeUUIDGenerator.getOdeUUID(this.getClass().toString());

		logger.error("#### MCA: about to try something useful...");

		/*
		 * Registramos el nuevo ODE en el servicio de publicacion.
		 */
		if(DecisorOffline.esOffline()) {
			this.getDescomprimeYvalida().creacion(odeId, null);
			//this.getSrvLocalizadorService().crearLocalizadorNoPublicado(user, odeId);
		} else {
		this.getSrvPublicacionService().creacion(odeId, user,
				utilidades.getProperty("creacion.mensaje"), titulo);
		}
		
		
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(odeId);

		utilidades.copiarEsquemas(localizador.getPath());
		
		/*
		 * Generamos el objeto Manifest inicial.
		 */
		OdeVO odeVO = manifestInicial(odeId, titulo, idioma);
		/*
		 * Intento escribir un imsmanifest.xml inicial
		 */
		try {
			Manifest manifest = (Manifest)cacheEmpaquetacion.get(odeVO.getIdentifier());
			String ruta = localizador.getPath() + BARRA + Utilidades.MANIFEST_NAME;
			logger.error("#### MCA: path is " + ruta);
			this.getScormDao().escribirODE(manifest, new File(ruta));
			if(logger.isDebugEnabled()) logger.debug("imsmanifest.xml inicial escrito en disco");
		} catch (Exception e) {
			logger.error("Error al generar imsmanifest.xml inicial");
		}
		odeVO.setConSecuencia(false);
		return odeVO;
	}

	/**
	 * Finaliza la edición del ODE. Esta operación implica eliminar de la cache
	 * el Manifest en edición, eliminar del servicio de Catalogación todos los
	 * objetos Lom asociados a este Ode. Y eliminar los backups que se generan
	 * al comenzar la edición o al guardar.
	 * 
	 * @param identificador
	 *            Identificador del ODE que se desea terminar.
	 * @throws Exception
	 */
	@Override
	protected void handleTerminarEdicion(String identificador) throws Exception {
		cacheEmpaquetacion.remove(identificador);
		this.getSrvGestorArchivosService().eliminarBackup(identificador);
		logger.info("edicion del ode terminada con identificador:"
				+ identificador);
	}

	/**
	 * Crear un recurso en el objeto manifest.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param recurso
	 *            Datos del recurso que se desea crear.
	 * @return Identificador del recurso añadido
	 * @throws Exception
	 */
	@Override
	protected String handleCrearRecurso(String identificador, RecursoVO recurso)
			throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		Resource resourc = (Resource) this.getBeanMapper().map(recurso,
				Resource.class);

		// obtengo los recursos del manifest
		logger.debug("obtengo los recursos del manifest");
		Resources recur = manifest.getResources();
		// le añado la nueva
		recur.addResource(resourc);

		// hago el set al manifest del recur nuevo
		logger.debug("voy a hacer el setResources");
		manifest.setResources(recur);

		logger.debug("voy a introducir el manifest en la cache");
		cacheEmpaquetacion.put(identificador, manifest);

		return resourc.getIdentifier();
	}

	/**
	 * Elimina los recursos solicitados y desvincula los grupos y recursos que
	 * dependieran de ellos.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param recursos
	 *            Identificadores de los recursos a eliminar
	 * @throws Exception
	 */
	@Override
	protected void handleEliminarRecursos(String identificador,
			String[] recursos) throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		for (int i = 0; i < recursos.length; i++) {

			// obtengo los recursos del manifest
			logger.debug("obtengo los recursos del manifest");
			Resources resor = manifest.getResources();

			logger.debug("voy a eliminar las referencias al recurso "
					+ recursos[i]);
			manifestAgrega.eliminarRecursos(recursos[i]);

			logger.debug("voy a eliminar el recurso " + recursos[i]);
			for (int j = 0; j < resor.getResource().length; j++) {
				if (resor.getResource()[j].getIdentifier().equals(recursos[i])) {
					resor.removeResource(resor.getResource(j));
				}
			}
		}

		logger.debug("voy a introducir el manifest en la cache");
		cacheEmpaquetacion.put(identificador, manifest);
	}

	/**
	 * Modifica el recurso deseado
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param recurso
	 *            VO del recurso a modificar.
	 * @return Identificador del recurso modificado
	 * @throws Exception
	 */
	@Override
	protected String handleModificarRecurso(String identificador,
			RecursoVO recurso) throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		if(logger.isDebugEnabled())  logger.debug("voy a modificar el recurso identificador= "
				+ recurso.getIdentifier());
		
		this.getBeanMapper().map(recurso,
				manifestAgrega.obtenerResource(recurso.getIdentifier()));
		if(logger.isDebugEnabled()) logger.debug("luego de mapear, emparejo las listas de fileVO y file");
		
		Resource resource= manifestAgrega.obtenerResource(recurso.getIdentifier());
		
		DependenciaVO[] dependenciasRecurso=recurso.getDependencias();
		Dependency[] dependenciasResource=resource.getDependency();
		if (logger.isDebugEnabled()) logger.debug("Contenidos de dependencias en el VO: " + Arrays.toString(dependenciasRecurso));
		if (logger.isDebugEnabled()) logger.debug("Contenidos de dependencias en el Resource del servicio: " + Arrays.toString(dependenciasResource));
		
		if (dependenciasResource!=null && dependenciasResource.length>0){
			if(dependenciasRecurso!=null  && dependenciasRecurso.length>0){
				Dependency[] dependencias=new Dependency[dependenciasRecurso.length];
				for(int i=0;i<dependenciasRecurso.length;i++){
					boolean encontrado=false;
					if (logger.isDebugEnabled()) logger.debug("Vamos a recorrer el array dependenciasResource");
					for (int k=0;k<dependenciasResource.length && !encontrado;k++){
						if (dependenciasRecurso[i].getIdRef().equals(dependenciasResource[k].getIdentifierref())){
							encontrado=true;	
							dependencias[i]=dependenciasResource[k];
							if (logger.isDebugEnabled()) logger.debug("Dependencia añadida al Resource : " + dependencias[i]);
						}
					}
				}
				resource.setDependency(dependencias);
			}
		}
//		resource.setDependency(dependencias);
		if (logger.isDebugEnabled()) logger.debug("Dependencias actualizadas en resource : " + Arrays.toString(resource.getDependency()));
		
		FileVO[] filesVO =recurso.getFileList();
		if(logger.isDebugEnabled()) logger.debug("lista de FileVO : " + Arrays.toString(filesVO));
		es.pode.parseadorXML.castor.File[] files= resource.getFile();
		if(logger.isDebugEnabled()) logger.debug("lista de File : " + Arrays.toString(files));
		es.pode.parseadorXML.castor.File[] tempFiles ;
		tempFiles = new es.pode.parseadorXML.castor.File[0];
		if (filesVO!=null) {
			if (filesVO.length > 0)
				tempFiles = new es.pode.parseadorXML.castor.File[filesVO.length];
			//		else
			//			tempFiles = new es.pode.parseadorXML.castor.File[0];
			for (int i = 0; i < filesVO.length; i++) {
				if (logger.isDebugEnabled())
					logger.debug("comparo el FileVO : " + filesVO[i]
							+ " con toda la lista de Files");

				if (filesVO[i]!=null) {
					for (int j = 0; j < files.length; j++) {
						if (filesVO[i].getHref().equals(files[j].getHref())) {
							if (logger.isDebugEnabled())
								logger
										.debug("existe en la lista por lo que lo agrego a la lista tempFiles : "
												+ files[j]);
							tempFiles[i] = files[j];

						}
					}
				}				
			}
		}		
		if(logger.isDebugEnabled()) logger.debug("lista resultante : " + Arrays.toString(tempFiles));
		if(logger.isDebugEnabled())logger.debug("agrego la lista al resource");
		resource.setFile(tempFiles);
		if(logger.isDebugEnabled())logger.debug("voy a introducir el manifest en la cache");
		cacheEmpaquetacion.put(identificador, manifest);

		return recurso.getIdentifier();

	}
	
	/**
	 * Llama al servicio de catalogación para recuperar (y eliminar de su cache)
	 * el objeto Lom asociado al identificador del objeto deseado. Si el objeto
	 * Lom esta vacío, no se asocia al objeto. Los cambios se almacenan en la
	 * cacheEmpaquetacion.
	 * 
	 * @param identificador
	 *            Identificador del ode que se esta editando.
	 * @param idElemento
	 *            Identificador del objeto (Manifest,Organization,Item,Resource)
	 *            cuyo objeto Lom se desea obtener del servicio de catalogacion.
	 * @param href
	 *            Atributo href del objeto File asociado a un recurso. Solo se
	 *            requiere cuando se desea recuperar el objeto Lom asociado al
	 *            File de un objeto resource, siendo el identificador
	 *            idElemento+href. En caso contrario, href debe ser null.
	 * @throws Exception
	 */
	 @Override
	protected void handleAsociarLom(String identificador, String idElemento,
			String href) throws Exception {
		
		String[] identificadores = new String[1];

		if (href == null) {
			logger.debug("El elemento no es File");
			identificadores[0] = idElemento;

		}
		// si href no es null significa que es un File
		else {
			logger.debug("El elemento es File");
			identificadores[0] = idElemento + href;
		}
		
		IdLomVO[] arrayLomVO;
		String perfil = null;
		try {
			perfil = LdapUserDetailsUtils.getCatalogador();
		} catch (Exception e) {
			logger.error("Error al leer el perfil de usuario del contexto de seguridad" , e);
		}
		
		if("avanzado".equalsIgnoreCase(perfil)) {
			arrayLomVO = this.getSrvCatalogacionAvanzadaService().obtenerObjLoms(identificadores);
			// Elimino el lom de la hash de catalogacion
			if(logger.isDebugEnabled()) logger.debug("Eliminando " + Arrays.toString(identificadores) + " de la hash de catalogacion avanzada");
			this.getSrvCatalogacionAvanzadaService().eliminarObjLoms(identificadores);
		} else if("basicplus".equalsIgnoreCase(perfil)) {
			arrayLomVO = this.getSrvCatalogacionAvanzadaService().obtenerObjLoms(identificadores);
			// Elimino el lom de la hash de catalogacion
			if(logger.isDebugEnabled()) logger.debug("Eliminando " + Arrays.toString(identificadores) + " de la hash de catalogacion avanzada");
			this.getSrvCatalogacionAvanzadaService().eliminarObjLoms(identificadores);
		} else {
			arrayLomVO = this.getSrvCatalogacionBasicaService().obtenerObjLoms(identificadores);
//			 Elimino el lom de la hash de catalogacion
			if(logger.isDebugEnabled()) logger.debug("Eliminando " + Arrays.toString(identificadores) + " de la hash de catalogacion basica");
			this.getSrvCatalogacionBasicaService().eliminarObjLoms(identificadores);
		}
		
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		if (arrayLomVO != null && arrayLomVO.length > 0) {
			for (int i=0;i<arrayLomVO.length;i++){
				if (arrayLomVO[i]!=null && arrayLomVO[i].getLomHandler()!= null){
					SerializadorObjetos so = new SerializadorObjetos();
					Object deserializado = so.deserializarObjeto(arrayLomVO[0].getLomHandler());
					Lom lom = null;
					try {
					lom = (Lom) deserializado;
					if(checkLom(lom)) {
						ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
						manifestAgrega.setLom(idElemento, href, lom);
						if(logger.isDebugEnabled()) logger.debug("Lom recuperado de catalogacion e insertado en " + (href == null ? idElemento : idElemento + href));
					} else {
						if(logger.isDebugEnabled()) logger.debug("Se recupero un Lom vacio de catalogacion. No se ha insertado en " + (href == null ? idElemento : idElemento + href));
					}
					} catch (Exception e) {
						logger.error("El Lom recuperado de catalogacion no era valido. Salto la asociacion de Lom al elemento " + (href == null ? idElemento : idElemento + href),e);
					}
				}
			}
		}
		
		logger.debug("voy a introducir el manifest en la cache");
		cacheEmpaquetacion.put(identificador, manifest);

	}

	private boolean checkLom(Lom lom) {
		boolean result = false;
		if(lom!=null) {
			// Chequear si tiene al menos una categoria distinta de null (o array con logitud  > 0 en multivaluados)
			if (lom.getGeneral() == null && lom.getLifeCycle() == null
					&& lom.getMetaMetadata() == null
					&& lom.getTechnical() == null
					&& (lom.getEducational() == null || lom.getEducational().length == 0)
					&& lom.getRights() == null
					&& (lom.getAnnotation()== null || lom.getAnnotation().length == 0)
					&& (lom.getRelation().length == 0 || lom.getRelation() == null)
					&& (lom.getClassification().length == 0 || lom.getClassification() == null)) {
				if(logger.isDebugEnabled()) logger.debug("El lom recuperado no tiene ninguna categoría. No se asocia al elemento");
				result = false;
			} else {
				result = true;
				if(lom.getGeneral()==null) logger.debug("El lom recuperado no tiene categoría general. Ode sin título");
				if(logger.isDebugEnabled()) logger.debug("El checkeo del Lom recuperado es valido; lom.getGeneral() = " + lom.getGeneral());
			}
		}
		return result;
	}
	
	/**
	 * Llama al servicio de catalogacion para cargar el objeto Lom asociado al
	 * objeto que se desea catalogar. Si no existe un objeto Lom previo, se
	 * carga uno vacio. El valor de retorno es el identificador con que se ha
	 * almacenado el objeto Lom en el servicio de catalogación.
	 * 
	 * @param identificador
	 *            Identificador del ode que se esta editando.
	 * @param idElemento
	 *            Identificador del objeto que se desea catalogar
	 *            (Manifest,Organization,Item o Resource). Si se desea catalogar
	 *            un File asociado a un Resource, ademas se debera dar valor al
	 *            parametro href.
	 * @param href
	 *            En caso de que se desée catalogar un File asociado a un
	 *            Resource, este parametro especifica el href de dicho File. Si
	 *            no se desea catalogar un File, este parametro sera null.
	 * @return Identificador del objeto que se desea catalogar
	 * @throws Exception
	 */
	@Override
	protected String handlePrepararCatalogacion(String identificador,
			String idElemento, String href) throws Exception

	{
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
		if(logger.isDebugEnabled()) logger.debug("Comprobando si hay un Lom insertado en id : " + idElemento + " href : " + href);
		Lom lomObtenido = null;
		if(manifestAgrega.obtenerElemento(idElemento, href)!=null) {
			lomObtenido = manifestAgrega.obtenerLom(idElemento, href);
		}
		if (lomObtenido == null) {
			lomObtenido = new Lom();
			if(logger.isDebugEnabled()) logger.debug("El elemento no tenia Lom asociado");
		} else {
			if(logger.isDebugEnabled()) logger.debug("El elemento tenia un Lom");
		}

		SerializadorObjetos so = new SerializadorObjetos();
		DataHandler serializado = so.serializarObjeto(lomObtenido);

		logger.debug("Obtengo el usuario mediante el localizador");
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		String usuario = localizador.getIdUsuario();
		
		String idCatalogacion = null;
		if (href != null) {
			idCatalogacion = idElemento + href;
		} else {
			idCatalogacion = idElemento;
		}
		
		// Leo perfil del usuario para saber a que catalogador tengo que llamar.
		String perfil = null;
		try {
			perfil = LdapUserDetailsUtils.getCatalogador();
			usuario = LdapUserDetailsUtils.getLogin();
		} catch (Exception e) {
			logger.error("Error al obtener perfil del usuario",e);
		}
		
		if("avanzado".equalsIgnoreCase(perfil)) {
			logger.debug("Voy a cargar el objeto LOM en catalogacion avanzada con parametros identificador : " + idCatalogacion + " usuario : " + usuario);
			this.getSrvCatalogacionAvanzadaService().cargarObjLom(idCatalogacion, usuario, serializado);
		} else {
			if ("basicplus".equalsIgnoreCase(perfil)) {
				logger.debug("Voy a cargar el objeto LOM en catalogacion basicplus con parametros identificador : " + idCatalogacion + " usuario : " + usuario);
				this.getSrvCatalogacionAvanzadaService().cargarObjLom(idCatalogacion, usuario, serializado);
			} else {// Dejo servicio de catalogacion basica por defecto
				logger.debug("Voy a cargar el objeto LOM en catalogacion basica con parametros identificador : " + idCatalogacion + " usuario : " + usuario);
				this.getSrvCatalogacionBasicaService().cargarObjLom(idCatalogacion, usuario, serializado);
			}
		}
		
		return idCatalogacion;

	}

	/**
	 * Reordena un Item moviendolo a una posición anterior en el array.
	 * 
	 * @param identificador
	 *            Identificador del ODE en edición.
	 * @param idItem
	 *            Identificador del item a subir
	 * @return Identificador del item modificado
	 * @throws Exception
	 */
	@Override
	protected String handleSubirItem(String identificador, String idItem)
			throws AlmacenamientoException, java.lang.Exception {

		Organization org;
		Item item;
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega ma = new ManifestAgrega(manifest);

		Object padre = ma.buscarPadre(idItem);

		if (padre != null) {
			Item[] arrayItems = null;
			if (padre instanceof es.pode.parseadorXML.castor.Organization) {
				logger.debug("El obj es de tipo Organization");
				org = (Organization) padre;
				arrayItems = org.getItem();
			} else if (padre instanceof es.pode.parseadorXML.castor.Item) {

				logger.debug("El obj es de tipo Item");
				item = (Item) padre;
				arrayItems = item.getItem();

			}

			if (arrayItems!=null) {
				logger
						.debug("voy a recorrer el array de items buscando el seleccionado");
				for (int i = 1; i < arrayItems.length; i++) {
					if (arrayItems[i].getIdentifier().equals(idItem)) {
						logger.debug("se va a mover el elemento: " + idItem
								+ "que se encuentra en la posicion: " + i);
						Item tmp = arrayItems[i];
						arrayItems[i] = arrayItems[i - 1];
						arrayItems[i - 1] = tmp;
					}
				}
				// compruebo si el item buscado es la primera posicion
				if (arrayItems[0].getIdentifier().equals(idItem)) {
					logger
							.debug("el elemento Item con identificador; "
									+ arrayItems[0].getIdentifier()
									+ " no se puede subir de posición porque es el primero");

				}
				if (padre instanceof es.pode.parseadorXML.castor.Organization) {
					logger.debug("El obj es de tipo Organization");
					org = (Organization) padre;

					org.setItem(arrayItems);
				} else if (padre instanceof es.pode.parseadorXML.castor.Item) {

					logger.debug("El obj es de tipo Item");
					item = (Item) padre;
					item.setItem(arrayItems);

				} else {
					logger.debug("El identificador es incorrecto");
				}
			}
		}
		cacheEmpaquetacion.put(identificador, manifest);

		return idItem;

	}

	/**
	 * Mueve a una posicion superior en el array el Item solicitado.
	 * @param identificador identificador del Ode en edición
	 * @param idItem identificador del item a bajar
	 * @return Identificador del item modificado
	 * @throws Exception
	 */
	@Override
	protected String handleBajarItem(String identificador, String idItem)
			throws AlmacenamientoException, java.lang.Exception {

		Organization org;
		Item item;
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		ManifestAgrega ma = new ManifestAgrega(manifest);
		Object padre = ma.buscarPadre(idItem);

		if (padre != null) {
			Item[] arrayItems = null;
			if (padre instanceof es.pode.parseadorXML.castor.Organization) {
				logger.debug("El obj es de tipo Organization");
				org = (Organization) padre;
				arrayItems = org.getItem();
			} else if (padre instanceof es.pode.parseadorXML.castor.Item) {

				logger.debug("El obj es de tipo Item");
				item = (Item) padre;
				arrayItems = item.getItem();

			}

			if (arrayItems!=null) {
				// compruebo si el item buscado es la ultima posicion
				if (arrayItems[arrayItems.length - 1].getIdentifier()
								.equals(idItem)) {
					logger
							.debug("el elemento Item con identificador; "
									+ arrayItems[arrayItems.length - 1]
											.getIdentifier()
									+ " no se puede bajar de posición porque es el último");

				} else {
					boolean encontrado = false;
					for (int i = 0; i < arrayItems.length - 1 && !encontrado; i++) {
						if (arrayItems[i].getIdentifier().equals(idItem)) {
							logger.debug("se va a mover el elemento: " + idItem
									+ "que se encuentra en la posicion: " + i);
							encontrado = true;
							Item tmp = arrayItems[i];
							arrayItems[i] = arrayItems[i + 1];
							arrayItems[i + 1] = tmp;
						}
					}
				}
				if (padre instanceof es.pode.parseadorXML.castor.Organization) {
					logger.debug("El obj es de tipo Organization");
					org = (Organization) padre;
					org.setItem(arrayItems);
				} else if (padre instanceof es.pode.parseadorXML.castor.Item) {
					logger.debug("El obj es de tipo Item");
					item = (Item) padre;
					item.setItem(arrayItems);

				}
			}
		}

		cacheEmpaquetacion.put(identificador, manifest);

		return idItem;
	}

	/**
	 * Sube la organización indicada
	 * @param identificador identificador del Ode en edición
	 * @param idOrganization identificador de la organización a subir
	 * @return Identificador de la organizacion modificada
	 * @throws AlmacenamientoException
	 * @throws Exception
	 */ 
	@Override
	protected String handleSubirOrganization(String identificador,
			String idOrganization) throws AlmacenamientoException,
			java.lang.Exception {

		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		Organization[] Orga = manifest.getOrganizations().getOrganization();
		ManifestAgrega ma = new ManifestAgrega(manifest);
		Object orga = ma.obtenerOrganization(idOrganization);

		if (orga != null) {
			for (int i = 1; i < Orga.length; i++) {
				if (Orga[i].getIdentifier().equals(idOrganization)) {
					logger.debug("se va a mover el elemento: " + idOrganization
							+ "que se encuentra en la posicion: " + i);
					Organization tmp = Orga[i];
					Orga[i] = Orga[i - 1];
					Orga[i - 1] = tmp;
				}
			}

			// compruebo si el item buscado es la primera posicion
			if (Orga[0].getIdentifier().equals(idOrganization)) {
				logger
						.debug("Organizacion con identificador; "
								+ Orga[0].getIdentifier()
								+ " no se puede subir de posición porque es la primera");
			}
		} else {
			logger.debug("El identificador es incorrecto");
		}
		manifest.getOrganizations().setOrganization(Orga);
		cacheEmpaquetacion.put(identificador, manifest);

		return idOrganization;
	}

	/**
	 * Baja la organización indicada
	 * @param identificador Identificador del ode en edición
	 * @param idOrganization Identificador de la organización a bajar
	 * @return Identificador de la organizacion modificada
	 * @throws AlmacenamientoException
	 * @throws Exception
	 */
	protected String handleBajarOrganization(String identificador,
			String idOrganization) throws AlmacenamientoException,
			java.lang.Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		Organization[] Orga = manifest.getOrganizations().getOrganization();
		ManifestAgrega ma = new ManifestAgrega(manifest);
		Object organ = ma.obtenerOrganization(idOrganization);

		if (organ != null) {

			// compruebo si el item buscado es la ultima posicion
			if (Orga[Orga.length - 1].getIdentifier().equals(idOrganization)) {
				logger.debug("la organizacion con identificador; "
						+ Orga[Orga.length - 1].getIdentifier()
						+ " no se puede bajar de posición porque es el último");
			} else {
				boolean encontrado = false;
				for (int i = 0; i < Orga.length - 1 && !encontrado; i++) {

					if (Orga[i].getIdentifier().equals(idOrganization)) {
						logger.debug("se va a mover el elemento: "
								+ idOrganization
								+ "que se encuentra en la posicion: " + i);
						encontrado = true;
						Organization tmp = Orga[i];
						Orga[i] = Orga[i + 1];
						Orga[i + 1] = tmp;
					}
				}
			}

		} else {
			logger.debug("El identificador es incorrecto");

		}
		manifest.getOrganizations().setOrganization(Orga);
		cacheEmpaquetacion.put(identificador, manifest);

		return idOrganization;

	}

	private void modificarIdHijos(Item[] arrayItem) {
		String ident = VACIA;

		for (int i = 0; i < arrayItem.length; i++) {
			// modifico el id

			ident = PodeUUIDGenerator.getItemUUID(this.getClass().toString());
			arrayItem[i].setIdentifier(ident);

			Item[] arrayItemHijos = arrayItem[i].getItem();
			if (arrayItemHijos != null && arrayItemHijos.length != 0) {
				modificarIdHijos(arrayItemHijos);
			}
		}

	}

	private ManifestAgrega comunCopiarMover(String destino, ManifestAgrega ma,
			Item[] arrayElementos) throws ParseadorException {

		Object destin = ma.obtenerElemento(destino);

		Item[] arrayItems = null;

		if (destin instanceof es.pode.parseadorXML.castor.Organization) {
			logger.debug("El obj es de tipo Organization");
			Organization org = (Organization) destin;
			arrayItems = org.getItem();
		} else if (destin instanceof es.pode.parseadorXML.castor.Item) {

			logger.debug("El obj es de tipo Item");
			Item item = (Item) destin;
			arrayItems = item.getItem();

		}
		List list = new ArrayList();
		if (arrayItems != null && arrayItems.length > 0) {
			list.addAll(Arrays.asList(arrayItems));
			list.addAll(Arrays.asList(arrayElementos));
		} else {
			list.addAll(Arrays.asList(arrayElementos));
		}

		logger.debug("voy a añadir la lista de elementos al destino");

		arrayItems = (Item[]) list.toArray(new Item[list.size()]);

		if (destin instanceof es.pode.parseadorXML.castor.Organization) {
			((Organization) destin).setItem(arrayItems);
		} else if (destin instanceof es.pode.parseadorXML.castor.Item) {
			((Item) destin).setItem(arrayItems);
		}
		return ma;

	}

	/**
	 * Copia los elementos indicados bajo el elemento destino
	 * @param identificador Identificador del ode en edición
	 * @param elementos Identificadores de los elementos a copiar
	 * @param destino Elemento destino del que colgarán los elementos copiados
	 * @throws AlmacenamientoException
	 * @throws ParseadorException
	 * @throws Exception
	 */
	@Override
	protected void handleCopiarElementos(String identificador,
			String[] elementos, String destino) throws AlmacenamientoException,
			ParseadorException, java.lang.Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega ma = new ManifestAgrega(manifest);
		Item[] arrayElementos = new Item[elementos.length];

		logger
				.debug("voy a guardar los items en un array generando un nuevo identificador");
		String ident = VACIA;
		for (int i = 0; i < elementos.length; i++) {
			Item elemento = ma.obtenerItem(elementos[i]);
			Item copia = (Item) this.getBeanMapper().map(elemento, Item.class);
			ident = PodeUUIDGenerator.getItemUUID(this.getClass().toString());
			copia.setIdentifier(ident);

			// busco si tiene hijos
			Item[] hijo = copia.getItem();
			// Si tiene hijos, modifico sus identificadores
			if (hijo != null && hijo.length != 0) {
				modificarIdHijos(hijo);
			}
			arrayElementos[i] = copia;
		}
		logger.debug("busco donde quiero mover los items");
		ma = comunCopiarMover(destino, ma, arrayElementos);
		//TODO Guardar cambios!!
		
		cacheEmpaquetacion.put(identificador, manifest);
	}

	/**
	 * Mueve los elementos indicados bajo el elemento destino
	 * @param identificador Identificador del ode en edición
	 * @param elementos Identificadores de los elementos a mover
	 * @param destino Elemento destino del que colgarán los elementos
	 * @throws AlmacenamientoException
	 * @throws ParseadorException
	 * @throws Exception
	 */
	@Override
	protected void handleMoverElementos(String identificador,
			String[] elementos, String destino) throws AlmacenamientoException,
			ParseadorException, java.lang.Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega ma = new ManifestAgrega(manifest);
		Item[] arrayElementos = new Item[elementos.length];

		if(logger.isDebugEnabled()) logger.debug("voy a guardar los items en un array");
		for (int i = 0; i < elementos.length; i++) {
			Item elemento = ma.obtenerItem(elementos[i]);
			if(logger.isDebugEnabled()) logger.debug("MOVER ELEMENTO: Elimino elemento " + elemento.getIdentifier() + " antes de pegarlo");
			ma.eliminarItem(elementos[i]);
			arrayElementos[i] = elemento;
		}
		if(logger.isDebugEnabled()) logger.debug("busco donde quiero mover los items");
		ma = comunCopiarMover(destino, ma, arrayElementos);
		//TODO Guardar cambios!!
		cacheEmpaquetacion.put(identificador, manifest);
	}

	/**
	 * Comprueba si el elemento idElemento tiene secuencia asociada y mapea los cambios a su ControlMode (si la secuencia existía) o crea una nueva con los datos proporcionados (en caso de que no existiera).
	 * @param identificador Identificador del Ode en edición
	 * @param idElemento ID del elemento al que se quiere asociar la secuencia.
	 * @param controlMode ControlMode al que se mapearán los cambios
	 * @return Identificador del elemento modificado
	 * @throws Exception
	 */
	@Override
	protected String handleAsociarSecuencia(String identificador,
			String idElemento, ControlModeVO controlMode) throws Exception {

		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega ma = new ManifestAgrega(manifest);

		Sequencing secuencia = ma.obtenerSequencing(idElemento);

		if (secuencia == null) {
			logger.debug("creo una nueva secuencia porque no existe");
			ControlMode ctrlMode = (ControlMode) this.getBeanMapper().map(
					controlMode,
					es.pode.parseadorXML.castor.ControlMode.class);
			secuencia = new Sequencing();
			secuencia.setControlMode(ctrlMode);
		} else {
			logger.debug("modifico la secuencia");
			this.getBeanMapper().map(controlMode, secuencia.getControlMode());
		}

		logger.debug("incorporo los cambios al ManifestAgrega");
		ma.setSequencing(idElemento, secuencia);

		cacheEmpaquetacion.put(identificador, manifest);

		return idElemento;

	}

	/**
	 * Extrae el elemento solicitado del Manifesto y lo introduce en la cache
	 * como referencia para futuras modificaciones (edicion de submanifiestos).
	 * 
	 * @param identificador
	 *            Identificador del Ode en edicion
	 * @param idElemento
	 *            identificador del elemento que se quiere meter en caché
	 * @return Boolean.TRUE si se introdujo en caché
	 * @throws Exception
	 */
	@Override
	protected Boolean handleCrearReferenciaEnCache(String identificador,
			String idElemento) throws Exception {
		Boolean valido = Boolean.FALSE;
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega ma = new ManifestAgrega(manifest);
		Object elemento = ma.obtenerElemento(idElemento);
		if (elemento != null) {
			logger
					.debug("vamos a guardar en la cache la referencia idElemento: "
							+ idElemento);
			cacheEmpaquetacion.put(idElemento, elemento);
			valido = Boolean.TRUE;
		}
		return valido;
	}

	/**
	 * Retorna la URL donde se ha generado el archivo comprimido con el paquete
	 * de recursos SCORM.
	 * 
	 * @param identificador
	 *            Identificador del Ode en edicion.
	 * @param recursos
	 *            Identificadores de los recursos a exportar.
	 * @param submanifestId
	 *            Si es distinto de null, identificador del submanifiesto donde
	 *            se deben buscar los recursos. El metodo sera responsable de
	 *            resolver el base completo para obtener la ruta donde encontrar
	 *            los archivos.
	 * @param nombre
	 *            Nombre del paquete de recursos a generar.
	 * @return URL donde se ha generado el archivo comprimido con el paquete de
	 *         recursos SCORM.
	 * @throws Exception
	 */
	@Override
	protected DataHandler handleExportarRecursos(String identificador,
			String[] recursos, String submanifestId, String nombre)
			throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		Manifest manifest2 = this.cacheEmpaquetacion.comprobarManifest(identificador);

		if (submanifestId == null)
			manifest = (Manifest) cacheEmpaquetacion.get(identificador);
		else
			manifest2 = (Manifest) this.cacheEmpaquetacion.get(submanifestId);

		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		
		String ruta = null;

		String rutaSubmanifest = null;
		rutaSubmanifest = crearRuta(manifest, submanifestId, ruta, localizador);

		ManifestAgrega ma = null;
		if (submanifestId != null) {
			ma = new ManifestAgrega(manifest2);
		} else {
			ma = new ManifestAgrega(manifest);
		}
		List recur = new ArrayList();

		// obtengo los recursos del manifest
		logger.debug("obtengo los recursos del manifest");

		for (int i = 0; i < recursos.length; i++) {
			Resource recurs = ma.obtenerResource(recursos[i]);
			recur.add(recurs);

		}

		// transformo la List en un array
		Resource[] arrayRecursos = (Resource[]) recur
				.toArray(new Resource[recur.size()]);

		logger
				.debug("voy a crear el fichero destino/temporal donde guardar los ficheros de los recursos");
		String pathtemp = localizador.getPath()
				+ utilidades.getProperty("carpeta.temporal") + BARRA + identificador;
		File destino = new File(pathtemp);
		destino.mkdirs();
		
		if(logger.isDebugEnabled()) logger.debug("copio los esquemas ");
		utilidades.copiarEsquemas(pathtemp);

		
		for (int i = 0; i < recur.size(); i++) {
			logger.debug("voy a recorrer el array de ficheros de la posición: "
					+ i + " del array de recursos");
			for (int j = 0; j < arrayRecursos[i].getFile().length; j++) {
				File ficheroOrigen = new File(rutaSubmanifest + BARRA
						+ arrayRecursos[i].getFile()[j].getHref());
				File ficheroDestino = new File(destino, arrayRecursos[i]
						.getFile()[j].getHref());
				ficheroDestino.getParentFile().mkdirs();
				logger.debug("voy a copiar el fichero: "
						+ ficheroOrigen.getName());
				UtilesFicheros.copiar(ficheroOrigen, ficheroDestino
						.getParentFile());
			}
		}

		logger.debug("voy a crear un nuevo manifest");
		Manifest nuevoManifest = new Manifest();
		String identNuevoManifest = PodeUUIDGenerator.getOdeUUID(this
				.getClass().toString());
		nuevoManifest.setIdentifier(identNuevoManifest);

		logger.debug("voy a crear una nueva Organizations");
		Organizations organizacionNueva = new Organizations();
		nuevoManifest.setOrganizations(organizacionNueva);

		nuevoManifest.setMetadata(new Metadata());
		nuevoManifest.getMetadata().setSchema(utilidades.getProperty("empaquetador.crearOde.schema"));
		nuevoManifest.getMetadata().setSchemaversion(utilidades.getProperty("empaquetador.crearOde.schemaversion"));
		
		nuevoManifest.setResources(new Resources());
		nuevoManifest.getResources().setResource(arrayRecursos);
		this.getScormDao().escribirODE(nuevoManifest,
				new File(destino, Utilidades.MANIFEST_NAME));
		
		this.getZipDao()
				.comprimir(destino.getPath() + "/../" + nombre + ".zip",
						destino.getPath());
		
		String valorRetorno = localizador.getPath()
				+ utilidades.getProperty("carpeta.temporal") + BARRA + identificador
				+ "/../" + nombre + ".zip";
		logger.debug("Voy a serializar: " + valorRetorno);
		DataHandler dh = utilidades.serializarExportado(valorRetorno);
//		 Elimina los ficheros
		return dh;

	}

	

	/**
	 *   Crea un metadato Lom-es para el manifiesto con el titulo idioma y esquema de metadatos.
	 *   
	 *   @param titulo Titulo del Ode (categoría general.title de Lomes)
	 *   @param idioma Idioma de catalogación (categoría metaMetadata.language)
	 *   @param identificador Identificador del manifiesto a modificar.
	 */
	@Override
	protected OdeVO handleGenerarMetadatoInicial(String titulo, String idioma, String identificador) throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		if(manifest.getMetadata()==null) {
			manifest.setMetadata(generarScormMetadata());
		}
		if(manifest.getMetadata().getGrp_any()==null) manifest.getMetadata().setGrp_any(new Grp_any());
		manifest.getMetadata().getGrp_any().addAnyObject(generarLomInicial(titulo, idioma, identificador));
		logger.info("Metadato con titulo inicial '" + titulo + "' generado para ode " + identificador);
		this.cacheEmpaquetacion.put(identificador, manifest);
		OdeVO odeVO = (OdeVO)getBeanMapper().map(manifest, OdeVO.class);
		ManifestAgrega ma = new ManifestAgrega(manifest);
		odeVO.setConSecuencia(ma.tieneSecuencias());
		return odeVO;
		/*
		 * No se almacena el titulo en la tabla del publicador hasta que se pulse guardar.
		 */
//		if(!DecisorOffline.esOffline()) {
//			try {
//				this.getSrvPublicacionService().modificaODECreado(manifest.getIdentifier(), LdapUserDetailsUtils.getUsuario(), titulo, "Ode modificador el " + (new java.util.Date()).toString());
//			} catch (Exception e) {
//				logger.error("Error al modificar el titulo del ode " + manifest.getIdentifier() + " : " + titulo,e);
//			}
//		}
	}
	
	/**
	 * Retorna el OdeVO del manifiesto / submanifiesto principal editado.
	 * 
	 * @param identificador
	 *            Identificador del Ode en edicion.
	 * @param paqueteRCP
	 *            Datahandler recubriendo el archivo comprimido con los recursos
	 *            a importar.
	 * @param submanifestId
	 *            Si es distinto de null, identificador del submanifiesto donde
	 *            se deben almacenar los recursos. El metodo sera responsable de
	 *            resolver el base completo para obtener la ruta donde almacenar
	 *            los archivos.
	 * @throws Exception
	 */
	@Override
	protected void handleImportarRecursos(String identificador,
			DataHandler paqueteRCP, String submanifestId) throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);
		Manifest manifestImportado = null;

		// consulta del localizador
		String path = VACIA;
		String rutaSubmanifest;
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);

		logger
				.debug("voy a recorrer los submanifiestos para encontrar la ruta completa");
		rutaSubmanifest = crearRuta(manifest, submanifestId, path, localizador);

		// File dirManifest = new File (rutaSubmanifest);
		// Ruta donde se crea el zip
		String pathtemp = VACIA;

		pathtemp = localizador.getPath() 
				+ utilidades.getProperty("carpeta.temporal") + BARRA + identificador
				+ BARRA + identificador + ".zip";

		File ficheroZip = new File(pathtemp);
		(ficheroZip.getParentFile()).mkdirs();
		ficheroZip.createNewFile();
		ficheroZip.deleteOnExit();
		FileOutputStream fos = new FileOutputStream(ficheroZip);
		paqueteRCP.writeTo(fos);
		String pathtempDestino = localizador.getPath() + utilidades.getProperty("carpeta.temporal") + BARRA
				+ "DestinoTemporal";
		File destinoTemporal = new File(pathtempDestino);
		destinoTemporal.mkdirs();
		destinoTemporal.deleteOnExit();
		fos.close();
		if (validaRCP(ficheroZip.getPath(), pathtempDestino)) {
			logger.debug("el fichero: " + ficheroZip.getName() + " es .zip");
			File destino = new File(rutaSubmanifest);

			// parseo el imsmanifest.xml
			logger.debug("voy a parsear el imsmanifest.xml");

			File rutaXml = new File(pathtempDestino + BARRA + Utilidades.MANIFEST_NAME);
			manifestImportado = this.getScormDao().parsearODELazy(rutaXml);
			// comprobar booo
			boolean borrado = rutaXml.delete();
			if (borrado == false) {
				logger.debug("no se ha conseguido borrar el fichero temporal: "
						+ rutaXml.getName());
			}

			UtilesFicheros.copiar(destinoTemporal, destino);

			// creo manifestagrega con manif y refrescar ids
			ManifestAgrega man = new ManifestAgrega(manifestImportado);
			man.resetearIds();
			Resource[] recurs = manifestImportado.getResources().getResource();

			logger.debug("voy a insertar los recursos");
			for (int i = 0; i < recurs.length; i++) {
				manifest.getResources().addResource(recurs[i]);
			}
			cacheEmpaquetacion.put(identificador, manifest);
			logger.debug("se ha introducido el manifest en la cache");

		} else {
			if (!this.getZipDao().esZip(ficheroZip.getPath())) {
				logger.debug("el fichero no es .zip");
			} else {
				logger.debug("el fichero no existe");
				throw new Exception("Seleccione un paquete de recursos (RCP) v&aacute;lido a importar");
			}
		}
	}

	private boolean validaRCP(String zip, String pathTemp) throws Exception {
		boolean validacion = false;

		this.getZipDao().descomprimir(zip, pathTemp);
		ValidaVO validacionVO = this.getSrvValidadorService()
				.obtenervalidacionLigera(pathTemp, "RCP");
		validacion = validacionVO.getEsValidoManifest().booleanValue();

		return validacion;
	}

	/**
	 * Llama al servicio de validacion
	 * 
	 * @param identificador
	 *            identificador del Ode en edicion.
	 * @param tipo
	 *            Tipo de validacion deseada:
	 *            <ul>
	 *            <li>LIGERA</li>
	 *            <li>BINARIA</li>
	 *            <li>COMPLETA</li>
	 *            </ul>
	 * @return Resultado de la validación
	 * @throws Exception
	 */
	@Override
	protected es.pode.empaquetador.negocio.servicio.ValidaVO handleValidar(
			String identificador, String tipo) throws Exception {
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);

		// Llama al servicio de validacion
		es.pode.validador.negocio.servicio.ValidaVO validaVO = null;

		if ("BINARIA".equals(tipo)) {
			validaVO = this.getSrvValidadorService().obtenerValidacionBin(
					localizador.getPath());
		} else if ("LIGERA".equals(tipo)) {
			// Ligera: CA - Valida ODE
			// RCP - Valida Resource Content Package
			validaVO = this.getSrvValidadorService().obtenervalidacionLigera(
					localizador.getPath(), "CA");
		} else if ("COMPLETA".equals(tipo)) {
			validaVO = this.getSrvValidadorService().obtenerValidacion(localizador.getPath());
			
		} else {
			logger.error("Se ha llamado a handleValidar con tipo incorrecto: "
					+ tipo);
			throw new Exception(
					"Se ha llamado a handleValidar con tipo incorrecto: "
							+ tipo);
		}

		es.pode.empaquetador.negocio.servicio.ValidaVO valida = (es.pode.empaquetador.negocio.servicio.ValidaVO) this
				.getBeanMapper().map(validaVO,
						es.pode.empaquetador.negocio.servicio.ValidaVO.class);
		return valida;
	}

	/**
	 * Carga en el servicio de Entregar el Objeto Digital Educativo que se
	 * quiere previsualizar. El identificador devuelto por el servicio de
	 * entregar se usara para llamar al modulo Visualizador.
	 * 
	 * @param identifier
	 *            Identificador del ODE en edicion.
	 * @return identificador del manifest (manifest.getIdentifier()) y el
	 *         prefijo EMP
	 * @throws Exception
	 */
	@Override
	protected String handlePrevisualizarOde(String identifier) throws Exception {

		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identifier);
		LocalizadorVO localizadorOde = this.getSrvLocalizadorService()
				.consultaLocalizador(identifier);
		// con el localizador obtenemos la ruta del ode
		// hay que obtener usuario, de momento "user"
		String usuario = localizadorOde.getIdUsuario();

		// Generamos DataHandler (uso de ByteArrayDataSource para serializar
		// objeto
		if (logger.isDebugEnabled())
			logger.debug("Serializando Manifest " + manifest.getIdentifier() + " de la clase " + manifest.getClass());
		SerializadorObjetos so = new SerializadorObjetos();

		/*
		 * Sustituyo el identificador del manifest por el del localizador. Asi
		 * evito fallo en el modulo entregar, que espera (requisito de la
		 * on-line) que idLocalizador e identificador de manifest sean iguales
		 */
		String idOriginal = manifest.getIdentifier(); 
		manifest.setIdentifier(identifier);
		
		DataHandler dh = so.serializarObjeto(manifest);
		if (logger.isDebugEnabled())
			logger.debug("Enviando manifest " + manifest.getIdentifier()
					+ " al servicio Entregar");
		String resultado = this.getSrvEntregarService().cargarObjManifest(
				usuario, dh);
		// Restauro el identificador original.
		manifest.setIdentifier(idOriginal);
		Logger.getLogger(this.getClass()).info(
				"Ode cargado en Entregar con id " + resultado);
		// Devolvemos ID para que Visualizador busque el ODE.

		/*
		 * Escribo el manifiesto. Necesito esto para poder previsualizar con
		 * ADL-RTE. No uso handleGuardar para no generar copias de seguridad.
		 */
		String ruta = localizadorOde.getPath() + "/imsmanifest.xml";
		logger.info("Escribiendo manifiesto para previsualizacion ADL en " + ruta);
		try {
			getScormDao().escribirODE(manifest, ruta);
		} catch (Exception e) {
			logger.error("No se pudo escribir el manifiesto en " + ruta,e);
		}
		
		return resultado;
	}

	/**
	 * Obtiene un listado de objetos personales del usuario.
	 * @param user Usuario del que se obtendrá objetos personales
	 * @return Transiciones de los objetos personales
	 * @throws Exception
	 */
	@Override
	protected TransicionVO[] handleObtenerObjetosPersonales(String user)
			throws Exception {
		TransicionVO[] resultado = null;
		boolean offline = DecisorOffline.esOffline();
		try {
			if (logger.isDebugEnabled())
				logger
						.debug("Llamando a Publicacion para recuperar objetos en creacion de "
								+ user);
			es.pode.publicacion.negocio.servicios.TransicionVO[] transiciones = null;
			es.pode.herramientaOffline.negocio.soporte.OdeVO odes[] = null;
			if(offline) {
				odes = this.getDescomprimeYvalida().listarOdes();
			} else {
				transiciones = this.getSrvPublicacionService().obtenODEsCreadosPorUsuario(user);
			}
			if (logger.isDebugEnabled()) {
				if ((transiciones == null && !offline) || (odes==null && offline))
					logger
							.debug("El servicio de publicacion no devolvió objetos para "
									+ user);
				else
					logger.debug("Publicacion devolvió " + (offline?odes.length:transiciones.length)
							+ "objetos para " + user);
			}
			if (transiciones!=null && !offline) {
				resultado = new TransicionVO[transiciones.length];
				for (int i = 0; i < transiciones.length; i++) {
					resultado[i] = (TransicionVO) this.getBeanMapper().map(
							transiciones[i], TransicionVO.class);
				}
			} else {
				resultado = new TransicionVO[odes.length];
				for (int i = 0; i < odes.length; i++) {
					resultado[i]=new TransicionVO();
					resultado[i].setIdODE(odes[i].getIdODE());
					resultado[i].setTitulo(odes[i].getTitulo());
				}
			}
		} catch (Exception e) {
			logger
					.error(
							"Se produjo un error al llamar al servicio de Publicacion.",
							e);
			throw e;
		}
		return resultado;
	}

	/**
	 * Elimina fisicamente el ODE (se usara para eliminar aquellos ODEs que se
	 * cierran sin haber sido guardados por primera vez).
	 * 
	 * @param identificador
	 *            Identificador del Ode a borrar
	 * @throws Exception
	 */
	@Override
	protected void handleEliminarODE(String identificador) throws Exception {
		if(logger.isDebugEnabled()) logger.debug("Eliminando el ODE " + identificador + " desde el Empaquetador.");
		try {
			LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
			String user = localizador.getIdUsuario();
			if(DecisorOffline.esOffline()) {
			this.getDescomprimeYvalida().eliminarOdes(new String[]{identificador});	
			} else {
			this.getSrvPublicacionService().eliminar(identificador, user);
			}
			
			
		} catch (Exception e) {
			logger.error("Se produjo un error al eliminar el ODE " + identificador,e);
		}
	}

	/**
	 * @return the cacheEmpaquetacion
	 */
	public CacheEmpaquetacion getCacheEmpaquetacion() {
		return cacheEmpaquetacion;
	}

	/**
	 * @param cacheEmpaquetacion the cacheEmpaquetacion to set
	 */
	public void setCacheEmpaquetacion(CacheEmpaquetacion cacheEmpaquetacion) {
		this.cacheEmpaquetacion = cacheEmpaquetacion;
	}

	/**
	 * @return the utilidades
	 */
	public Utilidades getUtilidades() {
		return utilidades;
	}

	/**
	 * @param utilidades the utilidades to set
	 */
	public void setUtilidades(Utilidades utilidades) {
		this.utilidades = utilidades;
	}

	/**
	 * Asocia los datos que se pasan por parametro al elemento(item) que se
	 * indica, si el elemento ya tenia datos esto datos se sobreescriben con los
	 * nuevos datos
	 * 
	 * @param identificador
	 *            Identificador del Ode en edición
	 * @param idElemento
	 *            ID del elemento al que se quiere asociar los datos.
	 * @param controlMode
	 *            ControlMode
	 * @param timeLimitAction
	 *            TimeLimitAction
	 * @param dataFromLMS
	 *            DataFromLMS
	 * @param completionThreshold
	 *            CompletionThreshold
	 * @param presentation
	 *            Presentation
	 * @throws Exception
	 */
	@Override
	protected void handleAsociarDatosItem(String identificador, String idElemento, TimeLimitActionVO timeLimitAction, DataFromLMSVO dataFromLMS, CompletionThresholdVO completionThreshold, PresentationVO presentation) throws Exception {
		Manifest manifest = this.cacheEmpaquetacion.comprobarManifest(identificador);

		ManifestAgrega ma = new ManifestAgrega(manifest);
		
		//PRESENTATION
		Presentation present = null;	
		if (presentation !=null){
			present = new Presentation();
			NavigationInterface navig = new NavigationInterface();
			NavigationInterfaceVO navigVO = presentation.getNavigationInterface();
			HideLMSUIVO[] arrayHideVO = navigVO.getHideLMSUI();
			for(int i = 0 ; i<arrayHideVO.length; i++){
				if(arrayHideVO[i]!=null && arrayHideVO[i].getContent() !=null 
						&& !arrayHideVO[i].getContent().trim().equals(VACIA)){
					try{
					HideLMSUIType hide = HideLMSUIType.valueOf(arrayHideVO[i].getContent());
					navig.addHideLMSUI(hide);
					}catch(IllegalArgumentException e){
						logger.warn("Warning, el valor " + arrayHideVO[i].getContent() + " no es un valor definido para HideLMSUI");
					}				
				}
			}
	
			present.setNavigationInterface(navig);
		}
		
		ma.setPresentation(idElemento, present);
		
		//TIMELIMITACTION
		TimeLimitAction time = null;
		if(timeLimitAction!=null){
			String content = timeLimitAction.getContent();
			if(content!=null && !content.equals(VACIA)){
				time = new TimeLimitAction();
				time.setContent(content);
			}
		}
		ma.setTimeLimitAction(idElemento, time);
		
		//DATAFORMLMS
		DataFromLMS data = null;
		if(dataFromLMS !=null){
			String contentData = dataFromLMS.getContent();
			if(contentData!=null && !contentData.equals(VACIA)){
				data = new DataFromLMS();	
				data.setContent(contentData);
			}
		}
		ma.setDataFromLMS(idElemento, data);
		
		//COMPLETIONTHRESHOLD
		CompletionThreshold completion = null;
		if(completionThreshold!= null){
			Double contentComp = completionThreshold.getContent();
			if(contentComp!=null /*&& !contentComp.equals("")*/){
				completion = new CompletionThreshold();
				completion.setContent(new BigDecimal(contentComp));
			}
		}
		ma.setCompletionThreshold(idElemento, completion);
		
		cacheEmpaquetacion.put(identificador, manifest);
	}

	/** 
	 * Obtiene del servicio de publicación un listado de los objetos compartidos por otros usuarios del mismo grupo de trabajo.
	 * 
	 * @return Listado de <em>Value Objects</em> con información de los objetos compartidos.
	 */
	@Override
	protected TransicionVO[] handleObtenerObjetosCompartidos() throws Exception {
		// TODO Auto-generated method stub
		es.pode.publicacion.negocio.servicios.TransicionAutorVO[] transiciones = null;
		if(logger.isDebugEnabled()) logger.debug("Estamos en obtenerObjetoscompartidos");
		String[] admin = this.getSrvAdminUsuariosService().obtenerListaUsuariosGrupoTrabajo(LdapUserDetailsUtils.getUsuario());
		if(logger.isDebugEnabled()) logger.debug("Hemos recogido "+(admin==null?0:admin.length)+" usuarios");
		if(admin!=null)	{
			transiciones = this.getSrvPublicacionService().obtenODEsCompartidosPorUsuarios(admin);
			if(logger.isDebugEnabled()) logger.debug("Hemos recogido "+ transiciones.length +" odes compartidos");
		}
		TransicionVO[] resultado = null;
		if (transiciones!=null) {
			resultado = new TransicionVO[transiciones.length];
			for (int i = 0; i < transiciones.length; i++) {
				resultado[i]=new TransicionVO();
				resultado[i].setIdODE(transiciones[i].getIdODE());
				resultado[i].setIdUsuario(transiciones[i].getIdUsuarioCreacion());//Usuario de creacion
				resultado[i].setTitulo(transiciones[i].getTitulo());
			}
		}
		return resultado;
	}

	private SrvAdminUsuariosService getSrvAdminUsuariosService() throws ServiceException, IOException {
		 String srvAdminUsuariosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvAdminUsuariosServiceInputStream=this.getClass().getClassLoader().getResourceAsStream(srvAdminUsuariosServiceFile);
	        java.util.Properties srvAdminUsuariosServiceProperties = new java.util.Properties();
	        srvAdminUsuariosServiceProperties.load(srvAdminUsuariosServiceInputStream);
	        String srvAdminUsuariosServiceEndPointAddress="";
	        srvAdminUsuariosServiceEndPointAddress=(String) srvAdminUsuariosServiceProperties.get("srvAdminUsuariosServicePort");
	        logger.info("srvAdminUsuariosServiceEndPointAddress del fichero --> " + srvAdminUsuariosServiceEndPointAddress);
			es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceService srvAdminUsuariosService = new es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceServiceLocator();                                                                                                                                                                                                                                                    
         if (srvAdminUsuariosServiceEndPointAddress.length()>0) 
				((es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceServiceLocator)srvAdminUsuariosService).setSrvAdminUsuariosServiceEndpointAddress(srvAdminUsuariosServiceEndPointAddress);				
         es.pode.soporte.seguridad.servicios.SrvAdminUsuariosService port = srvAdminUsuariosService.getSrvAdminUsuariosService();	    
	        return port;
	}
	
}
