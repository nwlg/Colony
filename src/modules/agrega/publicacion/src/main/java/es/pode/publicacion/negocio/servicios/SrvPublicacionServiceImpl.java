/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.publicacion.negocio.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.agrega.soporte.serverProperties.DependentServerPropertiesItf;
import es.pode.auditoria.negocio.servicios.TareaEjecutadaPlanVO;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.empaquetador.negocio.servicio.AnalizaArchivoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.indexador.negocio.servicios.indexado.IdODEVO;
import es.pode.indexador.negocio.servicios.indexado.IndexadorVO;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.LifeCycle;
import es.pode.parseadorXML.castor.Location;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Metadata;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.castor.Resources;
import es.pode.parseadorXML.lomes.lomesAgrega.LangStringAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.AccesoAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.AnnotationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.ClassificationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.ContribucionAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.DuracionAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.EducationalAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.FechaAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LifeCycleAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.MetaMetadataAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RelationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RequisitoAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RightsAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.TechnicalAgrega;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.publicacion.negocio.dominio.Estado;
import es.pode.publicacion.negocio.dominio.EstadoCompartidoCriteria;
import es.pode.publicacion.negocio.dominio.EstadoCompartidoUsuariosCriteria;
import es.pode.publicacion.negocio.dominio.EstadoCriteria;
import es.pode.publicacion.negocio.dominio.EstadoDao;
import es.pode.publicacion.negocio.dominio.EstadoDesdeHastaCriteria;
import es.pode.publicacion.negocio.dominio.IdODECriteria;
import es.pode.publicacion.negocio.dominio.IdODEFechaCriteria;
import es.pode.publicacion.negocio.dominio.IdODEsCriteria;
import es.pode.publicacion.negocio.dominio.IdiomaCriteria;
import es.pode.publicacion.negocio.dominio.OdePublicado;
import es.pode.publicacion.negocio.dominio.OdePublicadoDao;
import es.pode.publicacion.negocio.dominio.Transicion;
import es.pode.publicacion.negocio.dominio.TransicionDao;
import es.pode.publicacion.negocio.dominio.TransicionImpl;
import es.pode.publicacion.negocio.dominio.UsuarioCreacionEstadoFechaCriteria;
import es.pode.publicacion.negocio.dominio.UsuarioEstadoCriteria;
import es.pode.publicacion.negocio.dominio.UsuarioEstadoDesdeHastaCriteria;
import es.pode.publicacion.negocio.dominio.UsuariosCreacionEstadoFechaCriteria;
import es.pode.publicacion.negocio.soporte.TratamientoIndexacion;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.utiles.date.DateManager;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.validador.negocio.servicio.SrvValidadorService;
import es.pode.validador.negocio.servicio.ValidaVO;

public class SrvPublicacionServiceImpl extends es.pode.publicacion.negocio.servicios.SrvPublicacionServiceBase {

	private JmsTemplate jmsTemplate; 

	private static Logger logger = Logger.getLogger(SrvPublicacionServiceImpl.class);

	public static final String FILE_NAME_PROPERTIES = "/publicacion.properties";

	public static final String FILE_NAME_I18N = "publicacion";

	private static Properties props = null;

	private static HashMap<String, ResourceBundle> propsI18n = null;

	private final String MANIFEST_NAME = "imsmanifest.xml";

	public final static String SIN_ERRORES = "0.0";
	
	public final static String VOCAB_BORRADOS = "0.1";

	public final static String FALLO_ESCRITURA_DISCO_YA_EXISTE = "10.1";

	public final static String MEC_YA_EXISTE = "10.2";

	public final static String ERROR_INDEXACION = "10.3";

	public final static String FICHERO_ORIGINAL_ODE_NO_EXISTE = "10.4";

	public final static String IDENTIFICADOR_ODE_LOCALIZACION_INVALIDA = "10.5";

	public final static String ODE_YA_CREADO_EN_PLATAFORMA = "10.6";

	public final static String TRANSICION_ESTADO_INVALIDA = "10.7";

	public final static String FICHERO_YA_EXISTE = "10.8";

	public final static String EXCEPCION_INESPERADA = "10.9";

	public final static String CONSULTA_VALORACION_ERRONEA = "10.10";

	public final static String ERROR_PARSEO_MANIFEST = "10.11";

	public final static String ERROR_MAPEO_INDEXADO = "10.12";

	public final static String ERROR_FORMATO_ZIP = "10.13";

	public final static String ERROR_DESCOMPRIMIENDO_FICHERO_ZIP = "10.14";

	public final static String ERROR_COPIANDO_ESQUEMAS = "10.15";

	public final static String ERROR_DE_VALIDACION = "10.16";
	
	public final static String ERROR_EXCEDER = "10.17";

	public final static String NO_ESTADO_VALIDO = "10.18";

	public final static String LINEA_ERROR = "LINEA";

	public final static String COLUMNA_ERROR = "COLUMNA";

	public final static String TEXTO_ERROR = "TEXTO_ERROR";

	protected final static String FILE_SEPARATOR = "/";

	protected final static String FILE_UNDERSCORE = "_";

	protected final static String FILE_ICON_SIZE = "_icon_63_100";

	private final String UNIVERSAL = "universal";

	private final String SPLITTER = ";";
	
	// constantes para la generacion de la url de la ficha de los ODEs publicados
	private final String HTTP_PROTOCOL 			= "http://";
	private final String URL_FICHA 				= "url.recurso.ficha";
	private final String IDENTIFICADOR_FICHA 	= "identificadorODE";
	private final String IDIOMA_FICHA			= "idioma";
	
	private static final String IDENTIFICADOR_NODO = "server.id";
	
	
	/*
	 * constantes en la base de datos: CREACION PROPUESTO PUBLICADO RECHAZADO
	 * NO_DISPONIBLE PROPUESTO_CATALOGACION ELIMINADO
	 */

	public final static String CREACION = "CREACION";

	public final static String PROPUESTO = "PROPUESTO";

	public final static String PUBLICADO = "PUBLICADO";

	public final static String RECHAZADO = "RECHAZADO";

	public final static String NO_DISPONIBLE = "NO_DISPONIBLE";

	public final static String PROPUESTO_CATALOGACION = "CATALOGACION";

	public final static String ELIMINADO = "ELIMINADO";

	public final static String SOBRESCRIBIR_PUBLICADOS_SI = "s";

	public final static String SOBRESCRIBIR_PUBLICADOS_NO = "n";

	public final static int NUM_ESTADOS = 7;

	public final static String[] SECUENCIA_ESTADOS = new String[NUM_ESTADOS];

	public SrvPublicacionServiceImpl() {
		super();
		// Inicializamos la secuencia de estados que hay en el ciclo de vida de
		// un ODE.
		SECUENCIA_ESTADOS[0] = CREACION;
		SECUENCIA_ESTADOS[1] = PROPUESTO;
		SECUENCIA_ESTADOS[2] = PROPUESTO_CATALOGACION;
		SECUENCIA_ESTADOS[3] = PUBLICADO;
		SECUENCIA_ESTADOS[4] = RECHAZADO;
		SECUENCIA_ESTADOS[5] = NO_DISPONIBLE;
		SECUENCIA_ESTADOS[6] = ELIMINADO;
	}

	/**
	 * Consulta el estado actual del ODE que le pasan. Obtenemos el estado del
	 * ODE traducido al idioma que le pasamos.
	 * 
	 * @param idODE
	 *            El identificador correspondiente al ODE.
	 * @param idioma
	 *            El idioma al que traducir el texto descriptivo del estado.
	 * @return se retorna el estado del ODE.
	 * @throws Exception
	 * 
	 */
	protected EstadoVO handleObtenEstadoPorIdODE(java.lang.String idODE, java.lang.String idioma)
			throws java.lang.Exception {
		if(logger.isDebugEnabled())
			logger.debug("idODE[" + idODE + " idioma[" + idioma + "]");
		TransicionDao transicion = this.getTransicionDao();
		IdODECriteria criterio = new IdODECriteria();
		criterio.setIdODE(idODE);
		List<TransicionVO> list = transicion.buscarEstadoPorCriterioIdODE(TransicionDao.TRANSFORM_TRANSICIONVO, criterio);
		if (list == null || list.size() == 0) {
			logger.warn("No hay estado para el IdODE]" + idODE + "]");
			return null;
		} else {
			EstadoVO estado = list.get(0).getEstadoActual();
			if(logger.isDebugEnabled())
				logger.debug("idODE[" + idODE + "] en estado[" + estado.getClave() + "]");
			return estado;
		}
	}

	/**
	 * Obtiene un historial de las transiciones de estados por los que ha ido
	 * pasando en su historia un ODE.
	 * 
	 * @param idODE
	 *            El identificador correspondiente al ODE.
	 * @param idioma
	 *            El idioma al que traducir el texto descriptivo del estado.
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los estados del ODE
	 * @throws Exception
	 * 
	 */
	protected es.pode.publicacion.negocio.servicios.TransicionVO[] handleObtenHistorialPorIdODE(java.lang.String idODE,
			java.lang.String idioma) throws java.lang.Exception {
		return (TransicionVO[]) obtenHistorialPorIdODE(idODE, TransicionDao.TRANSFORM_TRANSICIONVO);
	}

	/**
	 * Obtiene la ultima transicion del ode al que corresponde el identificador.
	 * 
	 * @param idODE
	 *            El identificador correspondiente al ODE.
	 * @param idioma
	 *            El idioma al que traducir el texto descriptivo del estado.
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los estados del ODE
	 * @throws Exception
	 * 
	 */
	protected Transicion handleObtenerUltimaTransicion(String idODE) {
		TransicionDao transicionDao = this.getTransicionDao();
		List<Transicion> historial = transicionDao.buscarHistorialPorIdODE(idODE);
		Transicion transicion = null;
		if (logger.isDebugEnabled())
			logger.debug("historial size: " + historial.size());
		if (historial.size() > 0) {
			int i = 0;
			do {
				transicion = historial.get(i);
				if (logger.isDebugEnabled())
					logger.debug("transicion: " + transicion);
				i++;
			} while (transicion != null && transicion.getEstadoTransitado() != null);
		} else {
			transicion = transicionDao.fromTransicionVO(new TransicionVO());
			if (logger.isDebugEnabled())
				logger.debug("transicion else: " + transicion);
		}
		return transicion;
	}

	/**
	 * Mueve el contenido de un directorio a otro directorio.
	 * 
	 * @param oldDir
	 *            Directorio origen.
	 * @param newDir
	 *            Directorio destino.
	 * @return devuelve el tamanio del directorio movido.
	 * @throws Exception
	 * 
	 */
	protected Long handleMoveDir(File oldDir, File newDir) throws IOException {
		long longitudTransferida = 0;
		if (oldDir.isDirectory()) {
			newDir.mkdirs();
			String list[] = oldDir.list();

			for (int i = 0; i < list.length; i++) {
				String dest1 = newDir.getAbsolutePath() + "/" + list[i];
				String src1 = oldDir.getAbsolutePath() + "/" + list[i];
				longitudTransferida += handleMoveDir(new File(src1), new File(dest1)).longValue();
			}
		} else {
			FileInputStream fin = new FileInputStream(oldDir);
			FileOutputStream fos = new FileOutputStream(newDir);

			FileChannel sourceChannel = fin.getChannel();
			FileChannel targetChannel = fos.getChannel();
			longitudTransferida = sourceChannel.size();
			sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
			sourceChannel.close();
			targetChannel.close();
		}
		return new Long(longitudTransferida);
	}

	/**
	 * Genera un identificador MEC valido para el ODE.
	 * 
	 * @param localizador
	 *            Ruta del fichero imsmanifest.
	 * @return se retorna el identificador del MEC.
	 * @throws Exception
	 * 
	 */
	protected String handleGeneraMEC(String localizador) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Iniciamos generacion de mec para: " + localizador);
		DependentServerPropertiesItf properties = DependentServerProperties.getInstance();
		// String comunidad = properties.getProperty("nodo").toLowerCase();
		// String administracion = getPropertyValue("mec.prefix");
		// StringBuffer mecSB = new StringBuffer();
		// mecSB.append(administracion);
		// mecSB.append("-");
		// mecSB.append(comunidad);

		String comunidad = properties.getProperty(ConstantesAgrega.AMBITO_NODO).toLowerCase();
		String administracion = getPropertyValue("mec.prefix");
		StringBuffer mecSB = new StringBuffer();
		mecSB.append(administracion);
		// Si no estoy en el nodo mec, pongo la comunidad
		if (!comunidad.equals(ConstantesAgrega.AMBITO_GENERAL.toLowerCase())) {
			mecSB.append("-");
			mecSB.append(comunidad);
		}

		mecSB.append("_");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		mecSB.append(formatter.format(new Date()));
		mecSB.append("_");

		// Obtenemos el nivel de agregacion del ODE. Hay que parsearlo
		// Extraemos el manifest
		File extraeSubmanifest = new File(localizador, MANIFEST_NAME);
		Manifest imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
		ManifestAgrega manifest = new ManifestAgrega(imsmanifest);
		ArrayList<Lom> listLomes = new ArrayList<Lom>(manifest.recuperarLomes());
		int nivelDeAgregacion = 1; // utilizamos el nivel de agregacion 1 por
									// defecto
		if (listLomes != null && listLomes.size() > 0) {
			LomAgrega lomAg = new LomAgrega(listLomes.get(0));
			GeneralAgrega generalAgrega = lomAg.getGeneralAgrega();
			if (generalAgrega != null) {
				try {
					nivelDeAgregacion = Integer.parseInt(generalAgrega.getNivelDeAgregacion());
				} catch (Exception e) {
					logger.error("ERROR: handleGeneraMEC el campo nivel agregacion["
							+ generalAgrega.getNivelDeAgregacion()
							+ "] no es un entero valido. Se utiliza valor por defecto [" + nivelDeAgregacion + "].");
				}
			}
		}
		mecSB.append(nivelDeAgregacion);
		mecSB.append("_");
		mecSB.append(9);
		// horas minutos y segundos es un identificador único para
		// 1 millón de documentos diarios por comunidad, pero que
		// posibilidades hay que se publiquen dos elementos a la vez
		// justo en el mismo instante de tiempo?.
		formatter = new SimpleDateFormat("kkmmss");
		String date = formatter.format(new Date());
		mecSB.append(date);

		// si ya existe lanzamos una excepción
		IdODECriteria criteria = new IdODECriteria(mecSB.toString(), null);
		if (!this.getTransicionDao().buscarEstadoPorCriterioIdODE(criteria).isEmpty()) {
			// solo necesitamos comprobar la última transición, pq
			// el mec no cambia nunca
			logger.error("Se ha generado un mec nuevo ya existente");
			throw new Exception("Se ha generado un mec nuevo ya existente");
		}
		logger.info("Generacion de mec para: " + localizador + " terminada, mec: " + mecSB.toString());
		return mecSB.toString();
	}

	/**
	 * Busca identificadores de ODE's cuyo estado actual sea el mismo que el
	 * suministrado.
	 * 
	 * @param estado
	 *            Estado en el que se encuentra el ODE.
	 * @return se retorna el array de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected es.pode.publicacion.negocio.servicios.IdODEVO[] handleBuscarODEsPorEstado(String estado) throws Exception {

		try {
			if (logger.isDebugEnabled())
				logger.debug("buscando Odes por estado: " + estado);
			TransicionDao transicion = this.getTransicionDao();
			EstadoCriteria criterio = new EstadoCriteria();
			EstadoDao estadoDao = this.getEstadoDao();

			criterio.setEstadoActual(estadoDao.obtenEstadoPorNombre(estado));
			List<TransicionVO> transiciones = transicion.buscarODEsPorCriterioEstado(TransicionDao.TRANSFORM_TRANSICIONVO, criterio);
			List<es.pode.publicacion.negocio.servicios.IdODEVO> IdOdeVOs = new ArrayList<es.pode.publicacion.negocio.servicios.IdODEVO>();

			// aqui rellenar el ideodevo como en publicar pif
			for (int i = 0; i < transiciones.size(); i++) {
				// obtenemos el localizador, que es la llave para toda la info
				// del ode
				String idOde = transiciones.get(i).getIdODE();
				if (logger.isDebugEnabled())
					logger.debug("Encontrado Ode" + idOde + " en estado: " + estado);
				String rutaManifest = this.getSrvLocalizadorService().consultaLocalizador(idOde).getPath();
				File extraeSubmanifest = new File(rutaManifest, MANIFEST_NAME);
				Manifest imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);

				// rellenamos y añadimos a la lista todos los idodevos
				es.pode.publicacion.negocio.servicios.IdODEVO IdeOdePub = new es.pode.publicacion.negocio.servicios.IdODEVO();
				// mapeo
				ManifestAgrega manifAgrega = new ManifestAgrega(imsmanifest);
//				Long tamanioFloat = tamanioDir(rutaManifest);
				this.getBeanMapper().map(
						rellenaIdOdeVO(manifAgrega, rutaManifest, imsmanifest.getIdentifier(), "3", new Float(
								tamanioDir(rutaManifest).floatValue())), IdeOdePub);
				IdOdeVOs.add(IdeOdePub);

			}
			logger.info("Encontrados " + IdOdeVOs.size() + " odes con estado: " + estado);

			if (IdOdeVOs.size() > 0) {
				es.pode.publicacion.negocio.servicios.IdODEVO[] res = new es.pode.publicacion.negocio.servicios.IdODEVO[IdOdeVOs
						.size()];
				IdOdeVOs.toArray(res);

				return res;
			}

			// si no ha habido nada al menos no devolvemos un null, aunque sí
			// claro un length 0.
			return (new es.pode.publicacion.negocio.servicios.IdODEVO[0]);
		} catch (Exception e) {
			BuscarODEsEstadoException exception = new BuscarODEsEstadoException(
					"ERROR: fallo inesperado al buscar por estado " + estado, e);
			logger.error("ERROR: fallo inesperado al buscar por estado: " + estado + "; ", exception);
			throw exception;
		}
		// return null;
	}

	/**
	 * Obtiene un historial de las transiciones de estados por los que ha ido
	 * pasando en su historia un ODE.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los estados del ODE.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenHistorialPorIdODE(String idODE) throws Exception {
		return (TransicionVO[]) obtenHistorialPorIdODE(idODE, TransicionDao.TRANSFORM_TRANSICIONVO);
	}

	/**
	 * Errores del validador: 0.0 sin errores 1.1 imsmanifest es incorrecto 1.2
	 * error de parseo en el manifest 1.3 error, la etiqueta principal debe ser
	 * manifest o lom 1.4 error de chequeo de contenidos 2.1 el LOM-ES es
	 * obligatorio para metadata 2.2 el LOM-ES es incorrecto 2.3 el LOM-ES es
	 * incorrecto para la etiqueta de organizaciones 3.1 no existe el ODE 4.1
	 * los datos del formulario son obligatorios 4.2 el Titulo es obligatorio
	 * 4.3 el Idioma es obligatorio 4.4 la Descripcion es obligatoria 4.5 el
	 * Tipo es obligatorio 4.6 el Contexto es obligatorio 4.7 la Edad es
	 * obligatoria 4.8 el Idioma Destino es obligatorio 4.9 el Proceso Cognitivo
	 * es obligatorio Errores detectables en la publicacion de un ode via el
	 * metodo publica PIF 10.1 Fallo en escritura a disco o el fichero ya existe
	 * 10.2 El mec ya existía 10.3 No se ha podido publicar el ode, error en
	 * indexación 10.4 El fichero original del ODE no existe 10.5 El
	 * identificador del ODE tiene una lozalizacion invalida 10.6 El ODE ya esta
	 * creado en la plataforma
	 * 
	 */

	/**
	 * Publica objetos en formato PIF (ZIP).
	 * 
	 * @param pif
	 *            Objeto en formato PIF que se va a publicar.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que puede llevar la publicación.
	 * @param sobrescribir
	 *            Indica si la carga se ha de realizar sobrescribiendo el ODE si
	 *            este ya existe. Valores s/n.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handlePublicarPIF(DataHandler pif, String idUsuario, String comentarios,
			String sobrescribir, String titulo) throws Exception {

		try {
			String idODE = String.valueOf(System.currentTimeMillis());
			// creacion
			logger.info("Publicando PIF (de carga) utilizando identificador[" + idODE + "] idUsuario[" + idUsuario
					+ "] y comentarios[" + comentarios + "]");

			ResultadoOperacionVO res = handleCreacion(idODE, idUsuario, comentarios, titulo);
			if (!res.getIdResultado().equals(SIN_ERRORES)) {
				if (logger.isDebugEnabled())
					logger.error("ERROR[" + res.getIdResultado() + "][" + res.getDescripcion()
							+ "]:publicando PIF con fichero[" + pif != null ? pif.getName() : "null" + "] idusuario["
							+ idUsuario + "] comentarios[" + comentarios + "] idODE["+ res.getIdODE());
				return res;
			}
			SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
			LocalizadorVO localizadorNP = localizadorService.consultaLocalizador(idODE);

			logger.debug("Publicando PIF (de carga):Encontramos localizador con identificador[" + localizadorNP.getIdentificador() + "] usuario["
					+ localizadorNP.getIdUsuario() + "] MEC[" + localizadorNP.getMec() + "] path["
					+ localizadorNP.getPath() + "] URL[" + localizadorNP.getUrl() + "]");

			// empezamos a descomprimir el pif y guardar lo que nos devuelve
			// en un directorio temporal
			
			String pathtemp = "";
			pathtemp = localizadorNP.getPath() + getPropertyValue("carpeta.temporal") + "/" + localizadorNP.getIdentificador() + ".zip";
			File ficheroZip = new File(pathtemp);
			(ficheroZip.getParentFile()).mkdirs();
			ficheroZip.createNewFile();
			ficheroZip.deleteOnExit();
			FileOutputStream fos = new FileOutputStream(ficheroZip);
			pif.writeTo(fos);
			String pathtempDestino = localizadorNP.getPath();
			File destinoTemporal = new File(pathtempDestino);
			destinoTemporal.mkdirs();
			destinoTemporal.deleteOnExit();
			fos.close();
			if(logger.isDebugEnabled())
				logger.debug("Publicando PIF (de carga):Comenzamos a descomprimir el PIF"+ficheroZip.getPath()+ "" +
					"  y guardar en:" + pathtemp+";");
			if (this.getZipDao().esZip(pathtemp))
				try {
					this.getZipDao().descomprimir(ficheroZip.getPath(), pathtempDestino);
				} catch (Exception e1) {
					
					logger.error("Publicando PIF (de carga):Error descomprimiendo fichero [" + pathtemp + "], con nombre[" + pif.getName() + "]",
							e1);
					this.handleEliminar(idODE, idUsuario);
					return new ResultadoOperacionVO(ERROR_DESCOMPRIMIENDO_FICHERO_ZIP,
							getPropertyValueI18n(ERROR_DESCOMPRIMIENDO_FICHERO_ZIP),idODE,new Long(0));
				}
			else {
				logger.error("Error de formato descomprimiendo fichero [" + pathtemp + "], con nombre[" + pif.getName()
						+ "]");
				this.handleEliminar(idODE, idUsuario);
				return new ResultadoOperacionVO(ERROR_FORMATO_ZIP, getPropertyValueI18n(ERROR_FORMATO_ZIP),idODE,new Long(0));
			}

			// copiar los esquemas por si acaso no los trajese
			try {
				this.copiarEsquemas(pathtempDestino);
			} catch (Exception e1) {
				logger.error("Publicando PIF (de carga):No se pudieron copiar los esquemas al importar un pif: ", e1);
				this.handleEliminar(idODE, idUsuario);
				return new ResultadoOperacionVO(ERROR_COPIANDO_ESQUEMAS, getPropertyValueI18n(ERROR_COPIANDO_ESQUEMAS),idODE,new Long(0));
			}

			// validador
			SrvValidadorService validadorService = this.getSrvValidadorService();

			ValidaVO valid = validadorService.validarCargaOde(localizadorNP.getPath());
			logger.info("Publicando PIF (de carga):Validando el ODE [" + localizadorNP.getIdentificador() + "]");

			if (valid.getEsValidoManifest().booleanValue()) {

				// proponiendo catalogacion
				logger.info("Publicando PIF (de carga):Proponemos para catalogacion el ODE con identificador[" + idODE + "], idUsuario["
						+ idUsuario + "] y comentarios[" + comentarios + "]");
//				Proponemos para catalogar, pero sin validar ya que ya lo hemos hecho
				this.proponerCatalogacion(idODE, idUsuario, comentarios, titulo, false);

				// proponer publicacion
				logger.info("Publicando PIF (de carga):Proponemos para publicacion el ODE con identificador[" + idODE + "], idUsuario["
						+ idUsuario + "] y comentarios[" + comentarios + "]");
//				Proponemos para publicar, pero sin validar ya que ya lo hemos hecho
				this.proponerPublicacion(idODE, idUsuario, comentarios, titulo, false);

				// publicar

				// llamada a un metodo "validadorService.validarMec" que devuelve null si el mec es malo o no existe
				// y devuelve el valor del mec, si éste, es bueno
				String mec = validadorService.validarMec(localizadorNP.getPath());

				if (mec == null) {
					mec = this.handleGeneraMEC(localizadorNP.getPath());
					logger.info("Publicando PIF (de carga):MEC del ODE [" + localizadorNP.getPath() + "] invalido. Generado nuevo MEC [" + mec
							+ "]");

				}
				// si no comprobamos que no esté repetido, en cuyo caso lanzamos una excepción
				else {
					IdODECriteria criteria = new IdODECriteria(mec, null);
					if (!this.getTransicionDao().buscarEstadoPorCriterioIdODE(criteria).isEmpty()) {
						logger.info("Publicando PIF (de carga):El ODE [" + localizadorNP.getPath() + "] con mec[" + mec
								+ "] ya existia en la plataforma.");
						if (SOBRESCRIBIR_PUBLICADOS_NO.equals(sobrescribir)) {
							// solo necesitamos comprobar la última transición, pq  el mec no cambia nunca
							// Eliminamos todo lo que ha producido el intento de insercion de este ODE 
							// que al final ha resultado repetido
							this.handleEliminar(idODE, idUsuario);
							logger.warn("Publicando PIF (de carga):El ODE [" + localizadorNP.getPath() + "] con mec[" + mec
									+ "] ya existía y no lo sobrescribimos.");
							return new ResultadoOperacionVO(MEC_YA_EXISTE, getPropertyValueI18n(MEC_YA_EXISTE),idODE,new Long(0));
						} else if (SOBRESCRIBIR_PUBLICADOS_SI.equals(sobrescribir)) {
							logger.info("Publicando PIF (de carga):El ODE [" + localizadorNP.getPath() + "] con mec[" + mec
									+ "] existe. Eliminamos rastro para sobrescribirlo.");
							eliminaODEPublicado(mec);
						} else {
							logger.error("Publicando PIF (de carga):El mec ya existía y no hay criterio claro de sobrescritura[" + sobrescribir
									+ "]");
							this.handleEliminar(idODE, idUsuario);
							return new ResultadoOperacionVO(MEC_YA_EXISTE, getPropertyValueI18n(MEC_YA_EXISTE),idODE,new Long(0));
						}
					}
				}

				// vamos a comprobar que el mec no existe ya
				EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
				logger.info("Publicando PIF (de carga):Publicando ODE con identificador [" + idODE + "] en estado[" + estado.getClave()
						+ "] con usuario[" + idUsuario + "] y comentarios[" + comentarios + "].");
				if (estado.getClave().equals(PROPUESTO)) {
					// los odes que se cargan masivamente (de momento) no
					// tenemos que introducir información
					// de licencias
					ResultadoOperacionVO retorno = publicar_aux(idODE, mec, idUsuario, comentarios, null, "", "", true);
					if (!SIN_ERRORES.equals(retorno.getIdResultado())) {
						// Si la publicacion no ha ido bien, entendemos que ha tenido error y tenemos que borrar 
						// todo lo que el intento de publicacion ha creado en la plataforma
						logger.error("Publicando PIF (de carga):Error intentando publicar un ODE via PIF[" + retorno.getIdResultado()
								+ "] con id[" + idODE + "].");
						this.handleEliminar(idODE, idUsuario);
					}
					else
						logger.info("Publicando PIF (de carga):Publicado ODE con identificador[" + idODE + "] a mec[" + mec + "] via PIF.");
					return retorno;
				} else {
					logger.warn("Publicando PIF (de carga):error no se ha podido continuar ya que el ODE ya [" + mec + "], está creado");
					PublicarException e = new PublicarException("ERROR el ODE[" + mec
							+ "]ya esta creado en la plataforma");
					logger.warn(e);
					return new ResultadoOperacionVO(ODE_YA_CREADO_EN_PLATAFORMA,
							getPropertyValueI18n(ODE_YA_CREADO_EN_PLATAFORMA),idODE,new Long(0));
				}
			}// if (valid.getEsValidoManifest().booleanValue())
			else {
				logger.error("Publicando PIF (de carga):ERROR: no se ha validado el ODE [" + localizadorNP.getPath() + "]correctamente, código["
						+ valid.getResultadoValidacion() + "] ");
				this.handleEliminar(localizadorNP.getIdentificador(), idUsuario);			
				return new ResultadoOperacionVO(SrvPublicacionServiceImpl.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,new Long(0));
			}

		}// try
		catch (PublicarException e) {
			logger.error("Publicando PIF (de carga):Se ha producido un error al publicarPIF del tipo PublicarException", e);
			throw e;
		} catch (Exception e) {
			logger.error("Publicando PIF (de carga):Se ha producido un error al publicarPIF del tipo Desconocido", e);
			throw e;
		}
	}
	/**
	 * Crea un PIF en estado catalogado formato PIF (ZIP).
	 * 
	 * @param pif
	 *            Objeto en formato PIF que se va a dejar en estado catalogado.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que puede llevar cambiar el estado a catalogado.
	 * @param titulo
	 *            titulo del PIF
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleCrearPIFCatalogado(DataHandler pif, String idUsuario, String comentarios,
			String titulo) throws Exception {

		try {
			// creacion
			ResultadoOperacionVO res =this.handleCrearPIF(pif, idUsuario, comentarios, titulo, LdapUserDetailsUtils.getIdioma());//El idioma no lo necesitamos, pues luego lo vamos a modificar
			logger.info("Creando PIF en estado Catalogado utilizando identificador[" + res.getIdODE() + "] idUsuario[" + idUsuario
					+ "] y comentarios[" + comentarios + "]");
			if(!res.getIdResultado().equals(SIN_ERRORES)){
				logger.error("Error creando PIF en estado Catalogado utilizando identificador["+ res.getIdODE()+"]");
				return new ResultadoOperacionVO(res.getIdResultado(), res.getDescripcion(),res.getIdODE(),new Long(0));
			}else{
				Transicion transicionActual = handleObtenerUltimaTransicion(res.getIdODE());
				if (transicionActual.getIdODE() != null) {
					titulo=transicionActual.getTitulo();
				}
				ResultadoOperacionVO resultadoProponer=handleProponerCatalogacion(res.getIdODE(), idUsuario, comentarios, titulo);
				if(!resultadoProponer.getIdResultado().equals(SIN_ERRORES)){
					logger.error("Error proponiendo PIF utilizando identificador["+ res.getIdODE()+"]");
					this.handleEliminar(res.getIdODE(), idUsuario);
					if(logger.isDebugEnabled())
						logger.debug("Eliminando PIF de identificador["+ res.getIdODE()+"]");
					return new ResultadoOperacionVO(resultadoProponer.getIdResultado(), resultadoProponer.getDescripcion(),resultadoProponer.getIdODE(),new Long(0));
				}else{
					return resultadoProponer;
				}
			}


		}// try
		catch (PublicarException e) {
			logger.error("Creando PIF en estado Catalogado:Se ha producido un error del tipo PublicarException", e);
			throw e;
		} catch (Exception e) {
			logger.error("Creando PIF en estado Catalogado:Se ha producido un error del tipo Desconocido", e);
			throw e;
		}
	}

	/**
	 * Calcula los identificadores de ODEs que se encuentren en estado
	 * publicado.
	 * 
	 * @param no
	 *            hay parámetros de entrada.
	 * @return se retorna una lista de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected es.pode.publicacion.negocio.servicios.IdODEVO[] handleObtenODEsPublicados() throws Exception {

		// buscar aquí en la bbdd los odes publicados a pelo, parsearlos y
		// devolver idodevo.
		String estado = SrvPublicacionServiceImpl.PUBLICADO;
		es.pode.publicacion.negocio.servicios.IdODEVO[] arrayIds = this.handleBuscarODEsPorEstado(estado);
		if (arrayIds != null && arrayIds.length > 0) {
			SrvLocalizadorService localizador = this.getSrvLocalizadorService();
			for (int i = 0; i < arrayIds.length; i++) {
				String identifier = arrayIds[i].getIdODE();
				// logger.debug("El identificador que se va a reindexar es
				// ["+identifier+"]");
				LocalizadorVO localizacion = localizador.consultaLocalizador(identifier);
				// TODO: hay que replantear el concepto de valoracion en este
				// punto. Incluso si conviene introducirlo.
				arrayIds[i].setLocalizador(localizacion.getPath());
				// arrayIds[i].setValoracion(new Float("3"));
				// arrayIds[i].setImgFile(this.imagePathGenerate(
				// this.getManifest(localizacion.getPath()),identifier,localizacion.getPath()));

			}
		}
		logger.info("Obtenidos " + arrayIds.length + " odes publicados");

		return arrayIds;
	}

	/**
	 * Este metodo busca los ODEs que hay en la plataforma en el estado que le
	 * pasan para el usuario que le pasan.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param estado
	 *            Estado en el se encuentra el ODE.
	 * @return se retorna una lista de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleBuscarODEsPorEstadoUsuario(String idUsuario, String estado) throws Exception {
		if(logger.isDebugEnabled())
			logger.debug("buscando Odes por estado: " + estado + " para el usuario: " + idUsuario);
		TransicionDao transicion = this.getTransicionDao();
		EstadoDao estadoDao = this.getEstadoDao();
		EstadoCriteria criterio = new EstadoCriteria();
		UsuarioEstadoCriteria uec = new UsuarioEstadoCriteria();

		criterio.setEstadoActual(estadoDao.obtenEstadoPorNombre(estado));
		uec.setIdUsuario(idUsuario);
		uec.setEstadoActual(estadoDao.obtenEstadoPorNombre(estado));
		uec.setEstadoTransitado(null);

		List transiciones = transicion.buscarODEsPorCriterioEstadoUsuario(uec);

		TransicionVO[] resultado = new TransicionVO[transiciones.size()];
		for (int i = 0; i < transiciones.size(); i++) {
			// mapaemos los resultados
			TransicionVO aux = new TransicionVO();
			this.getBeanMapper().map(transiciones.get(i), aux);
			resultado[i] = aux;
		}
		logger.info("Obtenidos " + resultado.length + "odes en estado " + estado + " para el usuario " + idUsuario);
		return resultado;
	}

	/**
	 * Recupera la lista de ODEs en estado CREADO asociados a un usuario.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @return se retorna una lista de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODEsCreadosPorUsuario(String idUsuario) throws Exception {
		return obtenerODEsPorDosEstadosUsuario(idUsuario, SrvPublicacionServiceImpl.CREACION,
				SrvPublicacionServiceImpl.RECHAZADO);

	}

	/**
	 * Este metodo devuelve los ODEs en estado PROPUESTO asociados al usuario
	 * dado.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @return se retorna una lista de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODEsPropuestosPorUsuario(String idUsuario) throws Exception {
		return obtenerODEsPorEstadoUsuario(idUsuario, SrvPublicacionServiceImpl.PROPUESTO);
	}

	/**
	 * Este metodo selecciona los ODEs en estado PUBLICADO asociados al usuario
	 * dado.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @return se retorna una lista de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODEsPublicadosPorUsuario(String idUsuario) throws Exception {
		return obtenerODEsPorEstadoUsuario(idUsuario, SrvPublicacionServiceImpl.PUBLICADO);
	}

	/**
	 * Devuelve los odes del usuario que estan en estado rechazado.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @return se retorna una lista de identificadores de ODEs.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODEsRechazadosPorUsuario(String idUsuario) throws Exception {

		return obtenerODEsPorEstadoUsuario(idUsuario, SrvPublicacionServiceImpl.RECHAZADO);

	}

	/**
	 * Implementa las operaciones de creacion de un nuevo ODE desde la nada
	 * hasta el estado de Creacion.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la creación de un nuevo
	 *            ODE.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleCreacion(String idODE, String idUsuario, String comentarios, String titulo)
			throws Exception {
		try {
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			if (estado == null || estado.getClave().equals(CREACION) || estado.getClave().equals(RECHAZADO)
					|| estado.equals("")) {
				SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
				if(logger.isDebugEnabled())
					logger.debug("Creando ODE con idODE[" + idODE + "] idUsuario[" + idUsuario + "] comentarios["
						+ comentarios + "] titulo[" + titulo + "]");
				localizadorService.crearLocalizadorNoPublicado(idUsuario, idODE);
				EstadoDao estadoDao = this.getEstadoDao();
				TransicionDao transicionDao = this.getTransicionDao();
				Date fecha = new Date(System.currentTimeMillis());
				Transicion t = transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, idUsuario,// el usuario de creacion es el mismo que me pasan
						new Long(fecha.getTime()), // los milisegundos de la
													// fecha
						new Boolean(false),null, estadoDao.obtenEstadoPorNombre(CREACION));
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
			} else {
				logger.error("ERROR: creando ODE con identificador[" + idODE + "] idUsuario[" + idUsuario
						+ "] comentarios[" + comentarios
						+ "]. ODE en estado[CREADO/RECHAZADO] no se puede pasar a estado CREADO.");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
			}
		} catch (CreacionException e) {
			logger.error("Excepcion creando ODE con idODE[" + idODE + "] idUsuario[" + idUsuario + "] comentarios["
					+ comentarios + "] y titulo[" + titulo + "]", e);
			throw new Exception("Excepcion creando ODE con idODE[" + idODE + "] idUsuario[" + idUsuario
					+ "] comentarios[" + comentarios + "] y titulo[" + titulo + "]", e);
		} catch (Exception e) {
			CreacionException creacionException = new CreacionException("Fallo en la creación de ODE con id " + idODE
					+ " y usuario " + idUsuario, e);
			logger.error("Fallo en la creación de ODE con id " + idODE + " y usuario " + idUsuario, creacionException);
			throw creacionException;
		}
	}

	/**
	 * Implementa el paso a no disponible del ODE que le indican.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleNoDisponible(String idODE, String idUsuario, String comentarios, String titulo)
			throws Exception {
		try {
			if(logger.isDebugEnabled())
				logger.debug("pasando a no disponible ode [" + idODE + "] con titulo [" + titulo + "] de usuario ["
					+ idUsuario + "] ");
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			if (estado.getClave().equals(NO_DISPONIBLE) || estado.getClave().equals(PUBLICADO)) {

				// quitamos las valoraciones que no van a estar accesibles nunca
				// más
//				Eliminamos los comentarios que la gente a asociado a este ODE.
				this.getSrvValoracionService().eliminarTodosComentarios(idODE);
				
//				Eliminamos las valoraciones que la gente a asociado a este ODE.
				this.getSrvValoracionService().eliminarTodasValoraciones(idODE);
				
				// desindexamos, pq ahora no debe aparecer cuando se busca
				this.getSrvIndexadorService().eliminarODE(new String[] { idODE });

				// lo eliminamos de la lista de odes publicados
				this.getOdePublicadoDao().eliminaODEsPublicadosPorId(idODE);

				// si todo ha salido bien creamos la transición a no disponible

				EstadoDao estadoDao = this.getEstadoDao();
				TransicionDao transicionDao = this.getTransicionDao();

				Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
				transicionActual.setEstadoTransitado(estadoDao.obtenEstadoPorNombre(NO_DISPONIBLE));
				transicionDao.update(transicionActual);
				Date fecha = new Date(System.currentTimeMillis());
				transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, transicionActual
						.getIdUsuarioCreacion(),// arrastro el id del usuario de
												// creacion
						new Long(fecha.getTime()),new Boolean(false), null, estadoDao.obtenEstadoPorNombre(NO_DISPONIBLE));
				logger.info("Ode [" + idODE + "] con titulo [" + titulo + "] de usuario [" + idUsuario
						+ "] pasado a no disponible");
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
			} else {
				// Exception ex= new Exception("ERROR: haciendo no disponible
				// ODE con identificador["+idODE+"] idUsuario["+idUsuario+"]
				// comentarios["+comentarios+"]. ODE en estado[NO
				// DISPONIBLE/PUBLICADO] no se puede pasar a estado NO
				// DISPONIBLE.");
				logger.error("ERROR: haciendo no disponible ODE con identificador[" + idODE + "] idUsuario["
						+ idUsuario + "] comentarios[" + comentarios + "]y titulo[" + titulo
						+ "]ODE en estado[NO DISPONIBLE/PUBLICADO] no se puede pasar a estado NO DISPONIBLE.");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
				// throw ex;
			}
		} catch (Exception e) {
			logger.error("Fallo haciendo no disponible ODE con identificador[" + idODE + "] idUsuario[" + idUsuario
					+ "] comentarios[" + comentarios + "]y titulo[" + titulo + "]", e);
			throw e;
		}
	}

	/**
	 * Propone para publicacion el ODE que se le indica.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleProponerPublicacion(String idODE, String idUsuario, String comentarios,
			String titulo) throws Exception {
		return proponerPublicacion(idODE, idUsuario, comentarios, titulo, true);
	}

	/*
	 * Este metodo realiza la propuesta de publicacion del ODE validandolo o no.
	 * */
	private ResultadoOperacionVO proponerPublicacion(String idODE, String idUsuario, String comentarios, String titulo, boolean validar) throws Exception {
		try {
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			if(logger.isDebugEnabled())
			logger.debug("Proponiendo para publicacion ODE con identificador[" + idODE + "] usuario[" + idUsuario
					+ "] comentarios[" + comentarios + "] y en estado actual[" + estado + "]");
			if (estado != null && (estado.getClave().equals(SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION))) {
				// validador
				SrvValidadorService validadorService = this.getSrvValidadorService();
				SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
				LocalizadorVO localizadorNP = localizadorService.consultaLocalizador(idODE);
//				Hacemos la validacion que nos devuelve el texto de error menos detallado.
				boolean ODEvalido = false;
				ValidaVO valid = null;
				if (validar)  // si hay que validar el ODE, lo valido y miro a ver si continuo
				{
					valid = validadorService.obtenerValidacion(localizadorNP.getPath());
					ODEvalido = valid.getEsValidoManifest().booleanValue();
					if(logger.isDebugEnabled())
					logger.debug("Validando el ODE [" + localizadorNP.getPath() + "]");
				}
				else// si no hay que validar el ODE, es porque ya viene valido.
					ODEvalido = true;
				if (ODEvalido) {
					EstadoDao estadoDao = this.getEstadoDao();
					TransicionDao transicionDao = this.getTransicionDao();
					Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
					transicionActual.setEstadoTransitado(estadoDao.obtenEstadoPorNombre(PROPUESTO));
					transicionDao.update(transicionActual);
					logger.info("Actualizamos estado de ODE con identificador[" + idODE + "] a PROPUESTO.");
					Date fecha = new Date(System.currentTimeMillis());
					transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, transicionActual
							.getIdUsuarioCreacion(),// arrastramos el usuario de
													// creacion
							Long.valueOf(fecha.getTime()), Boolean.FALSE,null, estadoDao.obtenEstadoPorNombre(PROPUESTO));
					return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
				} else {

					logger.error("ERROR: proponiendo para publicacion ODE con identificador.[" + idODE
							+ "] ODE en estado[" + estado.getClave() + "]. El ode no valida correctamente: "
							+ valid.getResultadoValidacion());
					return new ResultadoOperacionVO(SrvPublicacionServiceImpl.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,new Long(0));
				}
			} else {
				if (estado!=null) {
					// Exception ex = new Exception("ERROR: proponiendo para
					// publicacion ODE con identificador. ODE en estado[CREADO] no
					// se puede pasar a estado PROPUESTO.");
					logger
							.error("ERROR: proponiendo para publicacion ODE con identificador. ODE en estado["
									+ estado.getClave()
									+ "] no se puede pasar a estado PROPUESTO.");
				} else {
					logger
					.error("ERROR: proponiendo para publicacion ODE con identificador."
							+ "No se puede pasar a estado PROPUESTO.");
				}
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
				// throw ex;
			}
		} catch (Exception e) {
			Exception propuesto = new Exception("Excepción en la proposicion de publicacion del ODE con identificador",
					e);
			logger.error("Excepción en la proposicion de publicacion del ODE con identificador[" + idODE
					+ "] idUsuario[" + idUsuario + "] comentarios[" + comentarios + "]y titulo[" + titulo + "]",
					propuesto);
			throw propuesto;
		}
	}
	
	/**
	 * Este metodo se encarga de coger un identificador de ODE y realizar todos
	 * los pasos para publicarlo, incluyendo la generacion del MEC.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handlePublicar(String idODE, String idUsuario, String comentarios, String titulo,
			String comunidades, String tipoLicencia, String universal) throws Exception {
		return publicar(idODE, idUsuario, comentarios, titulo,
				comunidades, tipoLicencia, universal, true);
	}
	
	/*
	 * Este metodo publica el ODE validandolo o no.
	 * */
	private ResultadoOperacionVO publicar(String idODE, String idUsuario, String comentarios, String titulo,
			String comunidades, String tipoLicencia, String universal, boolean validar) throws Exception {
		try {
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			if(logger.isDebugEnabled())
			logger.debug("Publicando ODE (Propuesto) con identificador [" + idODE + "] en estado[" + estado.getClave()
					+ "] con usuario[" + idUsuario + "] y comentarios[" + comentarios + "].");
			if (estado.getClave().equals(PROPUESTO)) {
				SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
				LocalizadorVO localizadorP = localizadorService.consultaLocalizador(idODE);
//				Hacemos la validacion que nos devuelve el texto de error menos detallado.
				boolean ODEvalido = false;
				ValidaVO valid = null;
				if (validar)  // si hay que validar el ODE, lo valido y miro a ver si continuo
				{
					valid = this.getSrvValidadorService().obtenerValidacion(localizadorP.getPath());
					ODEvalido = valid.getEsValidoManifest().booleanValue();
					if(logger.isDebugEnabled())
					logger.debug("Validando el ODE [" + localizadorP.getPath() + "]");
				}
				else// si no hay que validar el ODE, es porque ya viene valido.
					ODEvalido = true;
				if (ODEvalido) {
					logger.info("El ode: [" + localizadorP.getPath() + "] es válido y se va a publicar");
					return publicar_aux(idODE, this.handleGeneraMEC(localizadorP.getPath()), idUsuario, comentarios,
							comunidades, tipoLicencia, universal, false);

				}// si no es válido rollback
				else {
					logger.error("Imposible validar el ODE[" + localizadorP.getPath() + "] con error["
							+ valid.getResultadoValidacion() + "]. Imposible publicar");
					return new ResultadoOperacionVO(SrvPublicacionServiceImpl.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,Long.valueOf(0));
				}
			} else {
				logger.error("ERROR: Intentando publicar ODE con identificador [" + idODE + "] en estado["
						+ estado.getClave() + "] con usuario[" + idUsuario + "] y comentarios[" + comentarios
						+ "]. El estado del ODE no es PROPUESTO.");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
			}
		} catch (Exception e) {
			PublicarException exception = new PublicarException("Fallo en la publicación de ODE con id " + idODE
					+ " y usuario " + idUsuario, e);
			logger.error("Fallo en la publicación de ODE con id " + idODE + " y usuario " + idUsuario, exception);
			throw exception;
		}
	}
	/**
	 * Implementa el rechazo del ODE que le indican.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleRechazar(String idODE, String idUsuario, String comentarios, String titulo)
			throws Exception {
		try {
			if(logger.isDebugEnabled())
			logger.debug("Rechazando ODE con identificador [" + idODE + "] con usuario[" + idUsuario
					+ "] y comentarios[" + comentarios + "].");
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			if (estado.getClave().equals(PROPUESTO)
					|| estado.getClave().equals(SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION)) {
				EstadoDao estadoDao = this.getEstadoDao();
				TransicionDao transicionDao = this.getTransicionDao();
				Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
				transicionActual.setEstadoTransitado(estadoDao.obtenEstadoPorNombre(RECHAZADO));
				transicionDao.update(transicionActual);
				Date fecha = new Date(System.currentTimeMillis());
				transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, transicionActual
						.getIdUsuarioCreacion(),// arrastramos el identificador
												// del usuario creador
						Long.valueOf(fecha.getTime()),Boolean.FALSE, null, estadoDao.obtenEstadoPorNombre(RECHAZADO));
				logger.info("Rechazado ODE con identificador [" + idODE + "] en estado[" + estado + "] con usuario["
						+ idUsuario + "] y comentarios[" + comentarios + "].");
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
			} else {
				// Exception ex= new Exception("ERROR: rechazando ODE con
				// identificador["+idODE+"] idUsuario["+idUsuario+"]
				// comentarios["+comentarios+"]. ODE en estado[PROPUESTO] no se
				// puede pasar a estado RECHAZADO.");
				logger.error("ERROR: rechazando ODE con identificador[" + idODE + "] idUsuario[" + idUsuario
						+ "] comentarios[" + comentarios
						+ "]. ODE en estado[PROPUESTO] no se puede pasar a estado RECHAZADO.");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
				// throw ex;
			}
		} catch (Exception e) {
			logger.error("ERROR: rechazando ODE con identificador[" + idODE + "] idUsuario[" + idUsuario
					+ "] comentarios[" + comentarios + "].", e);
			throw e;
		}
	}

	/**
	 * Modifica los valores de titulo y comentarios de un ode en estado creado
	 * que le pasan. Si los valores de titulo o comentarios suministrados son
	 * alguno o los dos nulos, no se modificara el campo afectado. Solo se
	 * modificaran los campos con contenido.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param titulo
	 *            Titulo del ODE.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @return se retorna un booleano con el resultado de la modificacion y una
	 *         excepcion en caso de no existir ningun ode en creacion con esas
	 *         caracteristicas.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleModificaODECreado(String idODE, String idUsuario, String titulo, String comentarios)
	throws Exception {
		logger.info("Modificando ode["+idODE+"], con usuario["+idUsuario+"] con nuevo titulo["+titulo+"] y comentarios["+comentarios+"]");
		/*
		 * Tenemos que comprobar el espacio que ocupa en disco el ODE que se modifica.
		 * Tenemos que ver lo que ocupa lo que tiene en disco el tio ahora.
		 * Tenemos que ver si le cabe el ODE nuevo
		 * */
//		Vamos a cambiar el titulo del ODE en la ultima transición del ODE. Aqui solo se cambia el titulo en la transicion, no en el ODE.
//		Se supone que el que ha llamado a este metodo ya ha realizado ese cambio.
		Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
		if (transicionActual.getIdODE() != null) {  // no estamos impidiendo que se realice la modificacion en nungun estado.
			try {
//				Primero vamos a comprobar que la modificacion del ODE no es ilegal VS la cuota de disco asignada al usuario.
				if (excedeCuotaUsuario(transicionActual))
				{
					logger.info("Error modificando ODE["+idODE+"] del usuario["+transicionActual.getIdUsuarioCreacion()+"]. El cambio excede la cuota de usuario.");
					return new ResultadoOperacionVO(ERROR_EXCEDER,getPropertyValueI18n(ERROR_EXCEDER) ,idODE,this.getSrvLocalizadorService().calculaEspacioLocalizador(idODE));
				}
//				Si no, realizamos la actualizacion
				if (titulo != null)
					transicionActual.setTitulo(titulo);

				if (comentarios != null)
					transicionActual.setComentarios(comentarios);
				this.getTransicionDao().update(transicionActual);
//				Actualizamos el tamaño del localizador de este ODE en la tabla de localizadores.
				this.getSrvLocalizadorService().actualizaEspacioLocalizador(idODE);
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,this.getSrvLocalizadorService().consultaEspacioLocalizador(idODE));
			} catch (Exception ex) {
				String mensaje = "Error modificando ODE. Excepcion inesperada modificando ODE["+idODE+"] con usuario["+idUsuario+"] titulo["+titulo+"] y comentarios["+comentarios+"].";
				logger.error(mensaje,ex);
				throw new Exception(mensaje, ex);
			}
		}
		throw (new Exception("Error modificando ODE. Error buscando ultima transicion del ODE con id[" + idODE+ "]. No se ha encontrado transicion."));
	}

	/**
	 * Realiza las operaciones de creacion de un ODE en estado CREADO. Valida la
	 * informacion del ODE que se pasa en formato PIF(ZIP) y lo alberga en la
	 * plataforma bajo el usuario con el que se crea. Se descomprime en un
	 * temporal para validarlo, y si valida se crea un localizador y se copia en
	 * él.
	 * 
	 * @param ficheroPIF
	 *            Fichero en formato PIF.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleCrearPIF(DataHandler ficheroPIF, String idUsuario, String comentarios,
			String titulo, String idioma) throws Exception {
		//Invocamos al metodo auxiliar indicandole que no queremos tener en cuenta la cuota de usuario
		return crearPIFAux(ficheroPIF, idUsuario, comentarios, titulo, idioma, false);
	}

	/**
	 * Elimina el ode que se pasa por parametro del usuario. Los odes
	 * eliminables por el usuario son los que estan en estado:creacion, no
	 * disponible, rechazado, propuesto.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleEliminar(String idODE, String idUsuario) throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("Intentando eliminar el ode con id: " + idODE + " del usuario: " + idUsuario);
		// recorremos todos los ids y borramos los que se puedan

		IdODECriteria criterio = new IdODECriteria();

		// primero lo buscamos con un criteria
		criterio.setIdODE(idODE);
		criterio.setEstadoTransitado(null);
		// esto nos devuelve el estado final de ese ode, si existe, si nos han
		// colado un id feo
		// salta

		try {
			TransicionDao transicionDao = this.getTransicionDao();
			TransicionVO trVO = (TransicionVO) transicionDao.buscarEstadoPorCriterioIdODE(
					TransicionDao.TRANSFORM_TRANSICIONVO, criterio).get(0);

			if (trVO.getEstadoActual().getClave().equals(SrvPublicacionServiceImpl.CREACION)
					|| trVO.getEstadoActual().getClave().equals(SrvPublicacionServiceImpl.PROPUESTO)
					|| trVO.getEstadoActual().getClave().equals(SrvPublicacionServiceImpl.RECHAZADO)
					|| trVO.getEstadoActual().getClave().equals(SrvPublicacionServiceImpl.NO_DISPONIBLE))

			{
				LocalizadorVO localizador = new LocalizadorVO();
				localizador = this.getSrvLocalizadorService().consultaLocalizador(idODE);

				// Si el localizador existe borramos los datos de disco y
				// eliminamos el localizador
				this.getSrvLocalizadorService().eliminarLocalizador(localizador.getIdentificador());
				if(logger.isDebugEnabled())
				logger.debug("Eliminado ode: " + localizador.getIdentificador() + " de usuario "
						+ localizador.getIdUsuario());
				if(logger.isDebugEnabled())
				logger.debug("Eliminamos ODE con identificador[" + idODE + "] usuario[" + idUsuario + "] titulo["
						+ trVO.getTitulo() + "].");

				if (trVO.getEstadoActual().getClave().equals(SrvPublicacionServiceImpl.NO_DISPONIBLE)) {
					// si es eliminar un no disponible (que ha estado publicado
					// por tanto) tiene que
					// quedar constancia de su existencia, no se borran las
					// transiciones pasadas
					// y se crea una nueva a eliminado

					EstadoDao estadoDao = this.getEstadoDao();
					Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
					transicionActual.setEstadoTransitado(estadoDao
							.obtenEstadoPorNombre(SrvPublicacionServiceImpl.ELIMINADO));
					transicionDao.update(transicionActual);
					Date fecha = new Date(System.currentTimeMillis());
					transicionDao.create(DateManager.dateToCalendar(fecha), "Ode despublicado eliminado", idODE, idUsuario, transicionActual
							.getTitulo(), transicionActual.getIdUsuarioCreacion(),// arrastramos
																					// el
																					// usuario
																					// de
																					// creaciond
																					// el
																					// ODE.
							new Long(fecha.getTime()),new Boolean(false), null, estadoDao
									.obtenEstadoPorNombre(SrvPublicacionServiceImpl.ELIMINADO));
				} else {
					// Eliminamos todas las transiciones que hay en la BBDD de
					// publicacion para este ODE.
					logger.info("Eliminamos las transiciones asociadas al idODE[" + idODE + "]");
					this.getTransicionDao().remove(this.getTransicionDao().buscarHistorialPorIdODE(idODE));
				}
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
			} else {
				logger.error("Error Eliminado ode con idODE[" + idODE + "] idUsuario[" + idUsuario
						+ "] por estado invalido[" + trVO.getEstadoActual().getClave() + "]");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
			}
		} catch (Exception ex) {
			logger.error("El ode [" + idODE + "] del usuario[" + idUsuario
					+ "] no se ha podido eliminar (probablemente no exista)");
			throw new Exception("El ode [" + idODE + "] del usuario[" + idUsuario
					+ "] no se ha podido eliminar (probablemente no exista)", ex);
		}
	}

	/**
	 * Este metodo elimina los ODEs en estado No Disponible que cumplen las
	 * condiciones de los parametros que se le pasan: rango de fecha en el que
	 * paso a no disponible, usuario al que pertenece el ODE, etc. Si la lista
	 * de usuarios es vacia, se tendran en cuenta los ODEs no disponibles de
	 * todo el repositorio. Si la fecha de fin es vacia, se tendra en cuenta la
	 * fecha actual como limite temporal superior. Si la fecha de inicio es
	 * vacia, no se tendra en cuenta limite temporal inferior.
	 * 
	 * @param parametro
	 *            Parametros con las condiciones a cumplir por los ODEs a
	 *            eliminar.
	 * @return EliminarResultadoVO[]Devuelve un array de resultados de eliminar
	 *         los ODEs que cumplen las condiciones de eliminacion.
	 * @throws Exception
	 * 
	 */
	protected EliminarResultadoVO[] handleEliminarNoDisponibles(EliminarNoDisponiblesVO parametro) throws Exception {
		// Higiene en los parametros.
		if (parametro == null) {
			logger.error("Error invocando eliminacion de odes no disponibles con parametro nulo.");
			throw new Exception("Error invocando eliminacion de odes no disponibles con parametro nulo.");
		}
		// Comprobamos las fechas
		Date fechaInicio = (parametro.getFechaInicio()!= null ?parametro.getFechaInicio().getTime():null);
		Date fechaFin = (parametro.getFechaFin()!= null?parametro.getFechaFin().getTime():null);
		if (fechaInicio == null)
			fechaInicio = new Date(0); // si la fecha de inicio es vacia,
										// cogemos 1970 como inicio.
		if (fechaFin == null)
			fechaFin = new Date(); // si la fecha de fin es vacia, utilzamos
									// hoy como tope.
		if (fechaInicio.after(fechaFin)) // hay una inconsistencia con las
											// fechas, no seguimos
		{
			logger.error("Error invocando la eliminacion de odes. Fechas desde[" + fechaInicio.toString()
					+ "] y hasta[" + fechaFin.toString() + "] inconsistentes.");
			throw new Exception("Error invocando la eliminacion de odes. Fechas desde[" + fechaInicio.toString()
					+ "] y hasta[" + fechaFin.toString() + "] inconsistentes.");
		}

		// Primero hay que recopilar todos los ODEs en estado no disponible por
		// usuario o cogerlos todos
		ArrayList<TransicionVO> odesNoDisponibles = new ArrayList<TransicionVO>();
		if (parametro.getIdUsuarios() == null || parametro.getIdUsuarios().length == 0) {// cogemos
																							// todos
																							// los
																							// ODEs
																							// no
																							// publicados
																							// independientemente
																							// del
																							// usuario.
			try {
				EstadoDesdeHastaCriteria criterio = new EstadoDesdeHastaCriteria();
				criterio.setFechaDesde(DateManager.dateToCalendar(fechaInicio));
				criterio.setFechaHasta(DateManager.dateToCalendar(fechaFin));
				criterio.setEstadoActual(getEstadoDao().obtenEstadoPorNombre(NO_DISPONIBLE));
				criterio.setEstadoTransitado(null);
				if(logger.isDebugEnabled())
				logger.debug("Buscamos ODEs no disponibles desde[" + criterio.getFechaDesde().toString() + "] hasta["
						+ criterio.getFechaHasta().toString() + "]");
				List<TransicionVO> odesNoDisponiblesArray = getTransicionDao().buscarODEsPorCriterioEstadoDesdeHasta(criterio);
				if (odesNoDisponiblesArray != null && odesNoDisponiblesArray.size() > 0)
					odesNoDisponibles.addAll(odesNoDisponiblesArray);
			} catch (Exception e) {
				logger.error("Error onteniendo la lista de ODEs No Disponibles para toda la plataforma desde["
						+ fechaInicio.toString() + "] hasta[" + fechaFin.toString() + "][" + e.getCause() + "]");
				throw new Exception("Error onteniendo la lista de ODEs No Disponibles para toda la plataforma desde["
						+ fechaInicio.toString() + "] hasta[" + fechaFin.toString() + "]", e);
			}
		} else {
			Estado estadoActual = getEstadoDao().obtenEstadoPorNombre(NO_DISPONIBLE);
			UsuarioEstadoDesdeHastaCriteria criterio = new UsuarioEstadoDesdeHastaCriteria();
			criterio.setEstadoActual(estadoActual);
			criterio.setEstadoTransitado(null);
			criterio.setFechaDesde(DateManager.dateToCalendar(fechaInicio));
			criterio.setFechaHasta(DateManager.dateToCalendar(fechaFin));
			for (int i = 0; i < parametro.getIdUsuarios().length; i++) {
				try {
					criterio.setIdUsuarioCreacion(parametro.getIdUsuarios()[i]);
					if(logger.isDebugEnabled())
					logger.debug("Buscamos ODEs no disponibles desde[" + criterio.getFechaDesde().toString()
							+ "] hasta[" + criterio.getFechaHasta().toString() + "] para usuario["
							+ criterio.getIdUsuarioCreacion() + "].");
					List<TransicionVO> odesNoDisponiblesArray = getTransicionDao().buscarODEsPorCriterioUsuarioEstadoDesdeHasta(
							criterio);
					if (odesNoDisponiblesArray != null && odesNoDisponiblesArray.size() > 0)
						odesNoDisponibles.addAll(odesNoDisponiblesArray);
					else{
						if(logger.isDebugEnabled())
					
						logger.debug("No hay ODEs en estado no disponible para el usuario["
								+ criterio.getIdUsuarioCreacion() + "] desde[" + criterio.getFechaDesde().toString()
								+ "] hasta[" + criterio.getFechaHasta().toString() + "]");
					}
				} catch (Exception e) {
					logger.error("Error obteniendo ODEs No Disponibles para usuario[" + parametro.getIdUsuarios()[i]
							+ "]. Continuamos con el resto[" + e.getCause() + "]");
				}
			}
		}
		if (odesNoDisponibles.size() == 0) {// no hay nada que hacer, no hay
											// ODEs no disponibles para los
											// usuarios seleccionados.
			logger.warn("No hay ODEs en estado no disponible entre las fechas [" + fechaInicio.toString() + "]->["
					+ fechaFin.toString() + "] para los usuarios dados["
					+ (parametro.getIdUsuarios() != null ? parametro.getIdUsuarios().length : 0) + "]");
			return new EliminarResultadoVO[0];
		}
		Transicion[] odesEliminablesArray = (Transicion[]) odesNoDisponibles.toArray(new Transicion[0]);
		EliminarResultadoVO[] retorno = new EliminarResultadoVO[odesEliminablesArray.length];
		for (int i = 0; i < odesEliminablesArray.length; i++) {
			try {
				retorno[i] = new EliminarResultadoVO();
				retorno[i].setIdODE(odesEliminablesArray[i].getIdODE());
				retorno[i].setTitulo(odesEliminablesArray[i].getTitulo());
				ResultadoOperacionVO resultado = handleEliminar(odesEliminablesArray[i].getIdODE(),
						odesEliminablesArray[i].getIdUsuario());
				if (resultado.getIdResultado().equals(SIN_ERRORES)) {
					retorno[i].setCode(SIN_ERRORES);
					// TODO: hay que terminar de componer el texto de vuelta del
					// error de manera i18n
					retorno[i].setMensaje(getPropertyValueI18n(SIN_ERRORES));
				} else {
					retorno[i].setCode(TRANSICION_ESTADO_INVALIDA);
					// TODO: hay que terminar de componer el texto de vuelta del
					// error de manera i18n
					retorno[i].setMensaje(getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA));
				}

			} catch (Exception e) {
				logger.error("Excepcion eliminando el ODE[" + odesEliminablesArray[i].getIdODE() + "].[" + e.getCause()
						+ "]");
				retorno[i].setCode(EXCEPCION_INESPERADA);
				retorno[i].setMensaje(getPropertyValueI18n(SrvPublicacionServiceImpl.EXCEPCION_INESPERADA) + "[" + e.getCause() + "].");
			}
		}
		return retorno;
	}

	/**
	 * Errores detectables en la reindexacion de un ode via el metodo
	 * ReindexarODEPublicado 10.7 El ode no estaba publicado
	 * 
	 */
	/**
	 * Reindexa en el indice de busqueda el ODE que se le indica con la
	 * valoracion que le pasan.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param valoracion
	 *            Valoracion asignada al ODE
	 * @return se retorna un VO con el resultado de la operacion.
	 * @throws Exception
	 * 
	 */
	protected ReindexarODEResultadoVO handleReindexarODEPublicado(String idODE, Float valoracion) throws Exception {

		// Comprobar que el identificador del ODE que me pasan coincide con un
		// ODE que esta en estado PUBLICADO
		IdODECriteria criterio = new IdODECriteria();
		criterio.setIdODE(idODE);
		criterio.setEstadoTransitado(null);
		List<Transicion> estadoActual = this.getTransicionDao().buscarEstadoPorCriterioIdODE(criterio);
		if (estadoActual != null
				&& estadoActual.get(0) != null
				&& estadoActual.get(0).getEstadoActual().getNombre().equals(
						SrvPublicacionServiceImpl.PUBLICADO)) {
			if(logger.isDebugEnabled())
			logger.debug("El ode con identificador [" + idODE + "] se encuentra publicado");

			// Obtener la localizacion del fichero imsmanifest del ODE y
			// parsearlo.
			String rutaManifest = this.getSrvLocalizadorService().consultaLocalizador(idODE).getPath();
			Manifest imsmanifest;
			try {
				File extraeSubmanifest = new File(rutaManifest, MANIFEST_NAME);
				imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
			} catch (Exception e) {
				logger.error("Error realizando el parseo del ODE[" + idODE + "]. Imposible reindexar el ODE.["
						+ e.getCause() + "]");
				return new ReindexarODEResultadoVO(rutaManifest, ERROR_PARSEO_MANIFEST, 11);
			}

			// Mapear la informacion de indexacion en el VO que pasamos al
			// indexador, utilizando la valoracion
			// que nos pasan para indexarla.
			// rellenamos y añadimos a la lista todos los idodevos
			es.pode.indexador.negocio.servicios.indexado.IdODEVO ODEaIndexar;
			try {
				ManifestAgrega manifAgrega = new ManifestAgrega(imsmanifest);
				ODEaIndexar = rellenaIdOdeVO(manifAgrega, rutaManifest, idODE, valoracion.toString(), new Float(
						tamanioDir(rutaManifest).floatValue()));
			} catch (Exception e) {
				logger.error("Error realizando el mapeo de indexacion del ODE[" + idODE
						+ "]. Imposible mapear el ODE.[" + e.getCause() + "]");
				return new ReindexarODEResultadoVO(rutaManifest, ERROR_MAPEO_INDEXADO, 12);
			}

			// Llamar al indexador reindexando el ODE concreto.
			es.pode.indexador.negocio.servicios.indexado.IdODEVO[] arrayIDODES = new IdODEVO[] { ODEaIndexar };
			IndexadorVO[] retornoIndexador = this.getSrvIndexadorService().reindexarODE(arrayIDODES);

			ReindexarODEResultadoVO retornoPublicador = new ReindexarODEResultadoVO();
			if (retornoIndexador != null && retornoIndexador.length > 1)
				this.getBeanMapper().map(retornoIndexador, retornoPublicador);
			return retornoPublicador;

		} else {
			if(logger.isDebugEnabled())
			logger.debug("El ode con identificador [" + idODE + "] no estaba publicado");
			return new ReindexarODEResultadoVO("", "10.7", 7);
		}

	}

	/**
	 * Este metodo reindexa la lista de ODEs publicados que le pasan (lista de
	 * identificadores). Los elimina del indice y los vuelve a reindexar cada
	 * uno en su idioma.
	 * 
	 * @param idODEs
	 *            Lista de identificadores de ODEs.
	 * @return Se devuelve un VO con codigo de exito/fracaso para cada ODE.
	 * @throws Exception
	 * 
	 */
	protected ReindexarODEResultadoVO[] handleReindexarODEsPublicados(String[] idODEs) throws Exception {

		if (idODEs == null || idODEs.length == 0) {
			// Si la lista de ODEs es null, no hacemos nada.
			logger.error("Error reindexando ODEs publicados. La lista de ODEs es vacia");
			throw new Exception("Error reindexando ODEs publicados. La lista de ODEs es vacia");
		}
		IdODEsCriteria criterio = new IdODEsCriteria();
		criterio.setIdODE(idODEs);
		List<OdePublicado> resultados = this.getOdePublicadoDao().obtenODEsPublicadosDeConjunto(criterio);
		OdePublicado[] odesPublicados = resultados.toArray(new OdePublicado[0]);
		logger.info("Reindexamos [" + odesPublicados.length + "] ODEs publicados de los [" + idODEs.length
				+ "] identificadores de ODEs que nos han pasado.");

		// Preparamos los objetos de salida, ya que pueden ocurrir errores con
		// los ODEs recuperados y habra que marcarlos como erroneos
		ArrayList<ReindexarODEResultadoVO> retornoPublicador = new ArrayList<ReindexarODEResultadoVO>();

		ArrayList<IdODEVO> listaAIndexar = new ArrayList<IdODEVO>();
		// Llegado este punto, ya tengo la lista de los ODEs que voy a utilizar
		// para reindexarlos.
		for (int i = 0; odesPublicados != null && i < odesPublicados.length; i++) {

			// Parseamos el ODE extrallendo la informacion a indexar
			if(logger.isDebugEnabled())
			logger.debug("Localizamos el ODE[" + odesPublicados[i].getIdODE() + "] y lo parseamos.");
			// Obtener la localizacion del fichero imsmanifest del ODE y
			// parsearlo.
			String rutaManifest = this.getSrvLocalizadorService().consultaLocalizador(odesPublicados[i].getIdODE())
					.getPath();

			// Extraemos la informacion de valoracion para este ODE.
			String valoracion = "";
			try {
				valoracion = (this.getSrvValoracionService().consultarValoracion(odesPublicados[i].getIdODE()))
						.toString();
			} catch (Exception e) {
				logger.error("Error obteniendo la valoracion del ODE[" + odesPublicados[i].getIdODE()
						+ "]. Descartamos este ODE para reindexarlo y continuamos con el resto.[" + e.getCause() + "]");
				retornoPublicador.add(new ReindexarODEResultadoVO(rutaManifest, CONSULTA_VALORACION_ERRONEA, 10));
				continue;
			}

			Manifest imsmanifest;
			try {
				// Parseamos
				File extraeSubmanifest = new File(rutaManifest, MANIFEST_NAME);
				imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
			} catch (Exception e) {
				logger.error("Error realizando el parseo del ODE[" + odesPublicados[i].getIdODE()
						+ "]. Descartamos este ODE para reindexarlo y continuamos con el resto.[" + e.getCause() + "]");
				retornoPublicador.add(new ReindexarODEResultadoVO(rutaManifest, ERROR_PARSEO_MANIFEST, 11));
				continue;
			}

			try {
				// Mapear la informacion de indexacion en el VO que pasamos al
				// indexador, utilizando la valoracion
				// que nos pasan para indexarla.
				// rellenamos y añadimos a la lista todos los idodevos
				if(logger.isDebugEnabled())
				logger.debug("Mapeamos la informacion del ODE[" + odesPublicados[i].getIdODE()
						+ "] al VO de indexacion.");
				ManifestAgrega manifAgrega = new ManifestAgrega(imsmanifest);
				es.pode.indexador.negocio.servicios.indexado.IdODEVO ODEaIndexar = rellenaIdOdeVO(manifAgrega,
						rutaManifest, odesPublicados[i].getIdODE(), valoracion, new Float(tamanioDir(rutaManifest)
								.floatValue())); // Estamos mapeando la
													// valoracion que tiene el
													// ODE.
				listaAIndexar.add(ODEaIndexar);
			} catch (Exception e) {
				logger.error("Error realizando el mapeo del ODE[" + odesPublicados[i].getIdODE()
						+ "]. Descartamos este ODE para reindexarlo y continuamos con el resto.[" + e.getCause() + "]");
				retornoPublicador.add(new ReindexarODEResultadoVO(rutaManifest, ERROR_MAPEO_INDEXADO, 12));
				continue;
			}

		}

		es.pode.indexador.negocio.servicios.indexado.IdODEVO[] arrayIDODES = (IdODEVO[]) listaAIndexar
				.toArray(new es.pode.indexador.negocio.servicios.indexado.IdODEVO[0]);
		// Llamar al indexador reindexando el ODE concreto.
		// Tengo que reindexar la lista dependiendo del numero de idiomas
		IndexadorVO[] retornoIndexador;
		try {
			if(logger.isDebugEnabled())
			logger.debug("Reindexando [" + arrayIDODES.length + "] odes publicados.");
			retornoIndexador = this.getSrvIndexadorService().reindexarODE(arrayIDODES);
		} catch (Exception e) {
			logger.error("Error invocando servicio de reindexado selectivo. Imposible reindexar.[" + e.getCause()
					+ "].");
			throw new Exception("Error invocando servicio de reindexado selectivo. Imposible reindexar.["
					+ e.getCause() + "].");
		}
		// Mapeamos los mensajes de retorno del metodo del indexador a mensajes
		// de retorno del publicador.
		ReindexarODEResultadoVO[] retornoPublicadorIndexados = new ReindexarODEResultadoVO[0];
		if (retornoIndexador != null && retornoIndexador.length > 1) {
			retornoPublicadorIndexados = new ReindexarODEResultadoVO[retornoIndexador.length];
			if(logger.isDebugEnabled())
			logger.debug("Mapeando [" + retornoIndexador.length + "]resultados de reindexado de odes publicados.");
			this.getBeanMapper().map(retornoIndexador, retornoPublicadorIndexados);
		}
		retornoPublicador.addAll(Arrays.asList(retornoPublicadorIndexados));
		return (ReindexarODEResultadoVO[]) retornoPublicador.toArray(new ReindexarODEResultadoVO[0]);
	}

	/**
	 * Se regeneran los indices de los idiomas que se pasan. Se borran todos los
	 * odes indexados en esos idiomas y se indexan los odes publicados en el
	 * momento de la invocacion para cada idioma afectado.
	 * 
	 * @throws Exception
	 */

	protected ReindexarODEResultadoVO[] handleRegeneraIndiceIdioma(RegeneracionIndiceVO paramRegenera) throws Exception {
		// TODO: Deberia haber un retorno publicador por idioma ¿no?
		ArrayList<ReindexarODEResultadoVO> retornoPublicador = new ArrayList<ReindexarODEResultadoVO>(10);
		TareaEjecutadaPlanVO trabajo = new TareaEjecutadaPlanVO(); // Creamos
																	// la tarea
																	// donde
																	// notificaremos
																	// el exito
																	// o el
																	// fracaso
		try {
			if (paramRegenera != null) {
				String[] idiomas = paramRegenera.getIdIdiomas();
				Long lIdTarea = paramRegenera.getIdTarea();

				// Higiene y validacion de los datos
				if (lIdTarea == null) {
					logger.error("Error intentando regenerar indices. No se suministra identificador de tarea.");
					throw new Exception("Error intentando regenerar indices. No se suministra identificador de tarea.");
				}
				if (idiomas == null || idiomas.length == 0) {
					logger.error("Error intentando regenerar indices. No se suministran idiomas sobre los que actuar.");
					trabajo.setEstado(ConstantesAgrega.TRABAJO_ERRONEO);
					trabajo.setFechaFin(Calendar.getInstance());
					trabajo.setId(paramRegenera.getIdTarea());
					try {
						this.getSrvAuditoriaServicio().registrarTrabajoFechaFinPlan(trabajo);

					} catch (Exception e) {
						e.printStackTrace();
						logger.error("Error en la invocacion al servicio de auditoria con estado del trabajo erroneo");
						throw new Exception(
								"Error en la invocacion al servicio de auditoria con estado del trabajo erroneo");
					}
					throw new Exception(
							"Error intentando regenerar indices. No se suministran idiomas sobre los que actuar.");
				}

				// Comenzamos con la paginacion
				for (int i = 0; i < idiomas.length; i++) {
					IdiomaCriteria criterioIdioma = new IdiomaCriteria();
					criterioIdioma.setIdioma(idiomas[i]);

					Boolean hayMas = new Boolean(true);
					Integer inicio = new Integer(0);
					if (logger.isDebugEnabled())
						logger.debug("Cogemos la propiedad pagina");
					Integer iPagina = new Integer(SrvPublicacionServiceImpl.getPropertyValue("pagina"));
					if (logger.isDebugEnabled())
						logger.debug("Pagina [" + iPagina + "]");
					Integer fin = iPagina;

					while (hayMas.booleanValue()) {
						logger.info("Regenerando indice[" + idiomas[i] + "] paginando desde[" + inicio + "] hasta["
								+ fin + "] hayMas?[" + hayMas + "]");
						criterioIdioma.setFirstResult(inicio);
						criterioIdioma.setMaximumResultSize(iPagina);

						// TODO: Paginar esta llamada,
						// de momento voy a paginarlo en plan cutre. LUego habra
						// que paginar las llamadas a base de datos
						List resultados = this.getOdePublicadoDao().obtenODEsPublicadosPorIdioma(criterioIdioma);
						if (resultados == null)
							hayMas = new Boolean(false);
						else if (resultados != null
								&& (resultados.size() == 0 || (resultados.size() > 0 && resultados.size() < iPagina
										.intValue())))
							hayMas = new Boolean(false);

						if (hayMas.booleanValue()) {
							inicio = fin;
							fin = new Integer(fin.intValue() + iPagina.intValue());
						}

						OdePublicado[] odesPublicados = null;
						if (resultados != null && resultados.size() > 0) {
							if (logger.isDebugEnabled())
								logger.debug("Resultados[" + resultados.size() + "]");
							odesPublicados = (OdePublicado[]) resultados.toArray(new OdePublicado[resultados.size()]);

							if (logger.isDebugEnabled())
								logger.debug("Recuperamos [" + resultados.size() + "] ODEs publicados para el idioma["
										+ idiomas[i] + "]");
							// Preparamos los objetos de salida, ya que pueden
							// ocurrir errores con los ODEs recuperados y
							// habra que marcarlos como erroneos
							es.pode.indexador.negocio.servicios.indexado.IdODEVO[] arrayIndexables = this
									.generaOdeIndiceFromPublicado(odesPublicados, retornoPublicador);

							IndexadorVO[] retornoIndexador = this.getSrvIndexadorService().regenerarIndice(idiomas[i],
									arrayIndexables);
							ReindexarODEResultadoVO[] retornoPublicadorIndexados = null;
							if (retornoIndexador != null && retornoIndexador.length > 0) {
								retornoPublicadorIndexados = new ReindexarODEResultadoVO[retornoIndexador.length];
								if (logger.isDebugEnabled())
									logger.debug("Mapeando [" + retornoIndexador.length
											+ "]resultados de regeneracion de indice de odes publicados.");
								this.getBeanMapper().map(retornoIndexador, retornoPublicadorIndexados);
							}
							retornoPublicador.addAll(Arrays.asList(retornoPublicadorIndexados));

						} else {
							logger.warn("NO existen odesPublicados para el indice de idioma [" + idiomas[i] + "]");
						}// else
						if (logger.isDebugEnabled())
							logger.debug("Fin del WHILE -> Inicio[" + inicio + "] fin [" + fin + "] hayMas [" + hayMas
									+ "]");
					}// while
				}// for
			} else {
				logger.error("Error intentando regenerar indices. No se suministran idiomas sobre los que actuar.");
				throw new PublicarException(
						"Error intentando regenerar indices. No se suministran idiomas sobre los que actuar.");
			}

		} catch (Exception ex) {
			logger.error("Se ha producido un error al reindexar", ex);
			throw ex;
		}

		// LLamamos al servicio de auditoria para actualizar el estado del
		// trabajo
		trabajo.setEstado(ConstantesAgrega.TRABAJO_CORRECTO);
		trabajo.setFechaFin(Calendar.getInstance());
		trabajo.setId(paramRegenera.getIdTarea());
		try {
			this.getSrvAuditoriaServicio().registrarTrabajoFechaFinPlan(trabajo);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la invocacion al servicio de auditoria con estado del trabajo correcto["
					+ e.getMessage() + "]");
			throw new Exception("Error en la invocacion al servicio de auditoria con estado del trabajo correcto", e);
		}

		return (ReindexarODEResultadoVO[]) retornoPublicador.toArray(new ReindexarODEResultadoVO[retornoPublicador
				.size()]);
	}

	private es.pode.indexador.negocio.servicios.indexado.IdODEVO[] generaOdeIndiceFromPublicado(
			OdePublicado[] arrayOdePublicados, ArrayList listResultado) throws Exception {
		es.pode.indexador.negocio.servicios.indexado.IdODEVO[] arrayODEsIndice = null;
		try {
			if (arrayOdePublicados != null && arrayOdePublicados.length > 0) // si
																				// hay
																				// odes
																				// publicados
																				// para
																				// este
																				// idioma
			{
				arrayODEsIndice = new es.pode.indexador.negocio.servicios.indexado.IdODEVO[arrayOdePublicados.length];
				// Cojemos todas las localizaciones para el array de
				// odesPublicados que nos pasan
				String[] arrayIds = new String[arrayOdePublicados.length];
				for (int i = 0; i < arrayOdePublicados.length; i++) {
					arrayIds[i] = arrayOdePublicados[i].getIdODE();
				}
				// Obtengo el array de localizadores
				LocalizadorVO[] arrayLocalizaciones = this.getSrvLocalizadorService()
						.buscarLocalizadoresPorId(arrayIds);
				// Para cada localizador Parseo el objeto
				ArrayList listIndexables = new ArrayList(10);
				for (int j = 0; j < arrayLocalizaciones.length; j++) {
					String sIdentificador = arrayLocalizaciones[j].getIdentificador();
					String sPath = arrayLocalizaciones[j].getPath();
					try {
						// Parseamos el ODE extrallendo la informacion a indexar
						if (logger.isDebugEnabled())
							logger.debug("Localizamos el ODE[" + sIdentificador + "] y con path [" + sPath
									+ "]y lo parseamos.");

						// Extraemos la informacion de valoracion para este ODE.
						// TODO: Generar un método en Valoracion para pedir las
						// valoraciones de un array de identificadores
						String sValoracion = String.valueOf(this.getSrvValoracionService().consultarValoracion(
								arrayIds[j]));
						if (logger.isDebugEnabled())
							logger.debug("La valoracion del ODE [" + sIdentificador + "] es [" + sValoracion + "]");

						// Parseamos
						File fileManifest = new File(sPath, MANIFEST_NAME);
						Manifest imsmanifest = this.getScormDao().parsearODEEager(fileManifest);

						// Mapear la informacion de indexacion en el VO que
						// pasamos al indexador, utilizando la valoracion
						// que nos pasan para indexarla.
						// rellenamos y añadimos a la lista todos los idodevos
						if (logger.isDebugEnabled())
							logger.debug("Generamos el objeto de indexacion del ODE [" + sIdentificador + "]");

						ManifestAgrega manifAgrega = new ManifestAgrega(imsmanifest);
						// Estamos mapeando la valoracion al reindexar.
												
						es.pode.indexador.negocio.servicios.indexado.IdODEVO obj2Index = this.rellenaIdOdeVO(
								manifAgrega, sPath, sIdentificador, sValoracion, new Float(tamanioDir(sPath)
										.floatValue()));
						listIndexables.add(obj2Index);
					} catch (Exception ex) {
						logger.warn("Se ha producido un error al intentar indexar el objeto [" + sIdentificador
								+ "] y path [" + sPath + "]", ex);
						listResultado.add(new ReindexarODEResultadoVO(sPath, ERROR_PARSEO_MANIFEST, 11));
					}
				}
				arrayODEsIndice = (es.pode.indexador.negocio.servicios.indexado.IdODEVO[]) listIndexables
						.toArray(new es.pode.indexador.negocio.servicios.indexado.IdODEVO[listIndexables.size()]);
				if (logger.isDebugEnabled())
					logger.debug("Tenemos un total de [" + arrayODEsIndice.length + "] odes correctos y ["
							+ listResultado.size() + "] odes con errores");
			} else {
				logger.error("No hay odes publicados ni se extrae informacion de indexacion para el idioma");
			}

		} catch (Exception ex) {
			logger.error("Error generando el indice de objetos publicados", ex);
			throw ex;
		}
		return arrayODEsIndice;
	}

	/**
	 * 
	 * método auxiliar que tiene la funcionalidad rellenar los VO para indexar,
	 * se apoya en otros métodos
	 * 
	 * @throws Exception
	 */
	private es.pode.indexador.negocio.servicios.indexado.IdODEVO rellenaIdOdeVO(ManifestAgrega manifest,
			String path_ode, String mec, String valoracion, Float tamanio) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Vamos a rellenar los VOs para enviárselos luego al indexador con manifest["
					+ manifest.toString() + "], path_ode[" + path_ode + "] mec[" + mec + "] y valoracion[" + valoracion
					+ "]");

		ArrayList listLomes = new ArrayList(manifest.recuperarLomes());
		es.pode.indexador.negocio.servicios.indexado.IdODEVO idOdeVo = new IdODEVO();
		// Ponemos la secuencia a false por defecto
		idOdeVo.setSecuencia(Boolean.valueOf(false));
		if (logger.isDebugEnabled())
			logger.debug("ODE con mec[" + mec + "] tiene[" + (listLomes == null ? 0 : listLomes.size()) + "] lomes.");
		if (listLomes != null && listLomes.size() > 0) {
			try {
				idOdeVo.setCatalogacionPrimaria(new es.pode.indexador.negocio.servicios.indexado.LomESPrimarioVO());
				if(logger.isDebugEnabled())
				logger.debug("Rellenamos los VOs con los campos primarios");
				/////Obtenemos los nodos //////////////////////////
				
				logger.debug("SecurityContextHolder.getContext() "+SecurityContextHolder.getContext());
				if(!(SecurityContextHolder.getContext().getAuthentication() == null))
				{
					logger.debug("El contexto tiene autenticacion");
					logger.debug("SecurityContextHolder.getContext().getAuthentication() "+SecurityContextHolder.getContext().getAuthentication());
					logger.debug("getPrincipal() "+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
					logger.debug("getCredentials() "+SecurityContextHolder.getContext().getAuthentication().getCredentials());
					logger.debug("getName() "+SecurityContextHolder.getContext().getAuthentication().getName());
					logger.debug("getDetails() "+SecurityContextHolder.getContext().getAuthentication().getDetails());
					logger.debug("isAuthenticated() "+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
					logger.debug("-Creamos de nuevo el contexto de seguridad");
//					Autenticar.cargarContextoSeguridad(SecurityContextHolder.getContext().getAuthentication().getName());
					
				}else
				{
					logger.debug("El contexto no tiene autenticacion");
				//	Autenticar.cargarContextoSeguridad("administrador");
				}
			
				
				logger.debug("despues de cargar el contexto de seguridad");
				NodoVO[] nodos = this.getSrvNodoService().listarNodos();
				logger.debug("nodos "+nodos);
//				Obtenemos el nodo local y lo añadimos
				String[] nodosReturn = new String[((nodos!=null)?nodos.length+1:1)];
				nodosReturn[0] = DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO);
				for (int i = 1; i < nodosReturn.length; i++) {
					nodosReturn[i] = nodos[i-1].getIdNodo();
				}
				logger.debug("nodosReturn[0] "+nodosReturn[0]);
				//////////////////////////////////////////////////
			////	idOdeVo = TratamientoIndexacion.RellenarCamposPrincipales(idOdeVo, (Lom) listLomes.get(0), this.getSrvTaxonomiaService(), this.getSrvNodoService(),this.getSrvTesaurosServices());
				idOdeVo = TratamientoIndexacion.RellenarCamposPrincipales(idOdeVo, (Lom) listLomes.get(0), this.getSrvTaxonomiaService(), nodosReturn,this.getSrvTesaurosServices());
				// Eliminamos el LOM-ES principal de la lista para tratar solo
				// los LOM-ES secundarios a la hora d
				// de indexar la informacion secundaria.
				listLomes.remove(0);
				if (listLomes.size() > 0) {
					logger.debug("Rellenamos los VOs con los campos secundarios");
					idOdeVo = TratamientoIndexacion.RellenarCamposSecundarios(idOdeVo, (Lom[]) listLomes
							.toArray(new Lom[listLomes.size()]));
				}
				// C/S SECUENCIA
				idOdeVo.setSecuencia(Boolean.valueOf(manifest.tieneSecuencias()));
				if (logger.isDebugEnabled())
					logger.debug("Rellenamos IdODEVO con c/s secuencia[" + manifest.tieneSecuencias() + "]");
			} catch (Exception e) {

				logger.error("Fallo al rellenaIdOdeVO con con manifest[" + manifest.toString() + "], path_ode["
						+ path_ode + "] mec[" + mec + "] y valoracion[" + valoracion + "]", e);
				throw new Exception("Fallo al rellenaIdOdeVO con con manifest[" + manifest.toString() + "], path_ode["
						+ path_ode + "] mec[" + mec + "] y valoracion[" + valoracion + "]", e);
			}
		} else {
			if (logger.isDebugEnabled())
				logger.debug("El ODE con mec[" + mec + "] no tiene lomes. Se mapean datos de indexacion minimos.");
		}
		// LOCALIZACION
		idOdeVo.setLocalizadorODE(path_ode);
		if (logger.isDebugEnabled())
			logger.debug("Rellenamos IdODEVO con localizador[" + path_ode + "]");
		// MEC
		idOdeVo.setIdODE(mec);
		if (logger.isDebugEnabled())
			logger.debug("Rellenamos IdODEVO con mec[" + mec + "]");
		// VALORACION
		idOdeVo.setValoracion(Float.valueOf(valoracion.trim()));
		if (logger.isDebugEnabled())
			logger.debug("Rellenamos IdODEVO con valoracion[" + valoracion + "]");
		// FICHERO DE LA IMAGEN
		String imgFile = this.imagePathGenerate(manifest, mec, path_ode);
		if (logger.isDebugEnabled())
			logger.debug("Rellenamos IdODEVO con la imagen[" + imgFile + "]");
		idOdeVo.setImgFile(imgFile);

		// TAMAÑO DEL ODE
		if (logger.isDebugEnabled())
			logger.debug("Rellenamos IdODEVO con el tamanio[" + tamanio + "]");
		idOdeVo.setTamanio(tamanio);

		return idOdeVo;
	}

	/**
	 * 
	 * método auxiliar que tiene la funcionalidad común de publicar y publicar
	 * pif: la transición, mover el ode y la indexación.
	 * 
	 * @throws Exception
	 */
	private ResultadoOperacionVO publicar_aux(java.lang.String idODE, String mec, java.lang.String idUsuario,
			java.lang.String comentarios, String comunidades, String tipoLicencia, String universal, boolean cargaMasiva)
			throws Exception {

		SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
		LocalizadorVO localizadorVO = localizadorService.crearLocalizadorPublicado(idODE, mec);
		if (logger.isDebugEnabled())
			logger.debug("Creamos el nuevo localizador publicado para identificador[" + idODE + "] y MEC[" + mec + "]");
		if (localizadorVO.getMec().equals(""))
		// esto es así pq el mec ahora está en el identifier del VO
		{
			EstadoDao estadoDao = this.getEstadoDao();
			TransicionDao transicionDao = this.getTransicionDao();
			OdePublicadoDao idiomaODEPublicadoDao = this.getOdePublicadoDao();

			// copiarlo
			LocalizadorVO oldLocal = localizadorService.consultaLocalizador(idODE);
			if (logger.isDebugEnabled()) {
				logger.debug("Movemos el contendio del ODE no publicado con identificador["
						+ oldLocal.getIdentificador() + "] a la localizacion del identificador["
						+ localizadorVO.getIdentificador() + "] publicado");
				logger.debug("Movemos [" + oldLocal.getPath() + "] -> [" + localizadorVO.getPath() + "]");
			}
			File oldFile = new File(oldLocal.getPath());
			if (oldFile.exists()) {
				// es necesario moverlo primero, pero solo lo borraremos al
				// final.
				File newFile = new File(localizadorVO.getPath());
				Long tamanioODE = handleMoveDir(oldFile, newFile);

				// Extraemos el manifest y modificamos el lom que queremos
				File extraeSubmanifest = new File(localizadorVO.getPath(), MANIFEST_NAME);
				Manifest imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
				ManifestAgrega manAgrega = new ManifestAgrega(imsmanifest);
				String identifiadorManifest = manAgrega.getManifest().getIdentifier();
				// TODO si es carga masiva ponemos universal hardcodeado
				if (!cargaMasiva) {

					// Lom lom = manAgrega.obtenerLom(idODE, null);
					Lom lom = manAgrega.obtenerLom(identifiadorManifest, null);

					if (lom != null) {
						if(logger.isDebugEnabled())
						logger.debug("Publicación del ode, añadiendo licencia;tipo: " + tipoLicencia + ",ambito: "
								+ universal + ", comunidades: " + comunidades + ";");

						LomAgrega lomAgrega = new LomAgrega(lom);
						lomAgrega.getRightsAgrega().setDerechosDeAutor(tipoLicencia);

						lomAgrega.getRightsAgrega().setAcceso(universal, comunidades);

						// Hacemos el set
						lom.setRights(lomAgrega.getRightsAgrega().getRights());
						if(logger.isDebugEnabled())
						logger.debug("introducePublicadorManifest:Re-introduciendo Lom en Manifest");
						// manAgrega.setLom(idODE, null, lom);
						manAgrega.setLom(identifiadorManifest, null, lom);
						imsmanifest = manAgrega.getManifest();
						if(logger.isDebugEnabled())
						logger.debug("introducePublicadorManifest:Lom modificado en objeto Manifest");
					}
					if(logger.isDebugEnabled())
					logger.debug("Publicación del ode, añadiendo licencia::Escribiendo Manifest modificado");

					// guardamos el manifest modificado
					File fManifest = new File(localizadorVO.getPath(), this.MANIFEST_NAME);
					this.getScormDao().escribirODE(imsmanifest, fManifest);
				} else {
					if(logger.isDebugEnabled())
					logger.debug("Publicación de ode en carga masiva, ponemos ambito a universal;");
					// Lom lom = manAgrega.obtenerLom(idODE, null);
					Lom lom = manAgrega.obtenerLom(identifiadorManifest, null);

					LomAgrega lomAgrega = new LomAgrega(lom);
					// licencia ponemos la que venga
					// lomAgrega.getRightsAgrega().setDerechosDeAutor(tipoLicencia);
					// TODO lo suuyo es sacarlo de un properties pero como van a
					// pedir cambiarlo, así se queda.
					lomAgrega.getRightsAgrega().setAcceso(this.UNIVERSAL, "");

					// Hacemos el set
					lom.setRights(lomAgrega.getRightsAgrega().getRights());
					if(logger.isDebugEnabled())
					logger.debug("introducePublicadorManifest:Re-introduciendo Lom en Manifest");
					// manAgrega.setLom(idODE, null, lom);
					manAgrega.setLom(identifiadorManifest, null, lom);
					imsmanifest = manAgrega.getManifest();
					if(logger.isDebugEnabled())
					logger.debug("introducePublicadorManifest:Lom modificado en objeto Manifest");
				}

				// Comprueba si es primera indexacion y en tal caso, introduce
				// MEC
				// en LOMES.

				cambiaUUIDxMEC(mec, localizadorVO.getPath(), imsmanifest, AgregaPropertiesImpl.getInstance()
						.getProperty(AgregaProperties.CATALOGO_MEC)); // utilizamos
																		// el
																		// catalogo
																		// mec

				// Aniadimos la contribucion del publicador
				introducePublicadorManifest(localizadorVO.getPath(), idUsuario, imsmanifest);

				// Despues de la contribucion, tenemos que meter la localizacion del ODE en a pantalla de busqueda para que la ficha sea publica
				// y accesible en el caso de una busqueda por SQI.
				
				introduceLocalizacionWEB(localizadorVO.getPath(), idUsuario, imsmanifest);

				// Aqui se hace el asunto de la imagen
				es.pode.indexador.negocio.servicios.indexado.IdODEVO idOdeVo = null;
				IndexadorVO res[] = null;
				es.pode.indexador.negocio.servicios.indexado.IdODEVO index[] = null;
				try {
					idOdeVo = rellenaIdOdeVO(new ManifestAgrega(imsmanifest) // Utilizamos
																				// el
																				// Manifest
																				// Agrega
																				// como
																				// wrapper
																				// del
																				// manifest
																				// del
																				// ODE.
							, localizadorVO.getPath(), mec, "-1", new Float(tamanioODE.floatValue()));

					index = new es.pode.indexador.negocio.servicios.indexado.IdODEVO[1];
					index[0] = idOdeVo;

					res = this.getSrvIndexadorService().indexarODE(index);
				} catch (Exception ex) {
					// Borramos la info y salimos, no hay que deshacer bbdd
					this.getSrvLocalizadorService().eliminarLocalizador(localizadorVO.getIdentificador());
					logger.error("No se ha podido indexar ODE con id[" + idODE + "] mec[" + mec + "] y usuario["
							+ idUsuario + "], no se copia a la carpeta de publicados: error en indexación", ex);
					return new ResultadoOperacionVO(ERROR_INDEXACION, getPropertyValueI18n(ERROR_INDEXACION),idODE,new Long(0));
				}
				// indexacion(localizadorVO.getPath(),
				// localizadorVO.getIdentificador());
				if (res == null || !(res.length > 0) || (res[0].getCode() == 1)) {
					this.getSrvLocalizadorService().eliminarLocalizador(localizadorVO.getIdentificador());
					logger.error("No se ha podido indexar ODE con id[" + idODE + "] mec[" + mec + "] y usuario["
							+ idUsuario + "], no se copia a la carpeta de publicados: error en indexación");
					return new ResultadoOperacionVO(ERROR_INDEXACION, getPropertyValueI18n(ERROR_INDEXACION),idODE,new Long(0));
				} else {
					if (logger.isDebugEnabled())
						logger.debug("Creamos la transicion del identificador[" + localizadorVO.getIdentificador()
								+ "] con estado actual[PUBLICADO]");

					// Creamos la transicion de ODE publicado
					Transicion transicionAux = handleObtenerUltimaTransicion(idODE);
					Date fecha = new Date(System.currentTimeMillis());
					transicionDao.create(DateManager.dateToCalendar(new Date(System.currentTimeMillis())), comentarios, mec, idUsuario, idOdeVo
							.getCatalogacionPrimaria().getTitulo(), transicionAux.getIdUsuarioCreacion(),// arrastramos
																											// el
																											// usuario
																											// de
																											// creaciond
																											// el
																											// ODE.
							new Long(fecha.getTime()),new Boolean(false), null, estadoDao.obtenEstadoPorNombre(PUBLICADO));
					// Actualizamos la transicion actual
					Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
					transicionActual.setEstadoTransitado(estadoDao.obtenEstadoPorNombre(PUBLICADO));
					transicionDao.update(transicionActual);

					// Creamos la nueva entrada del idioma en el que se ha
					// publicado el ode
					idiomaODEPublicadoDao.create(mec, idOdeVo.getCatalogacionPrimaria().getIdioma(), tamanioODE,
							DateManager.dateToCalendar(new Date(System.currentTimeMillis())), idOdeVo.getCatalogacionPrimaria().getTitulo());

					// Borramos la vieja info
					UtilesFicheros.eliminar(oldFile);
					if (logger.isDebugEnabled())
						logger.debug("Transitamos el estado de identificador[" + idODE + "] y mec[" + mec
								+ "] de estado actual[" + transicionActual.getEstadoActual().getNombre()
								+ "]a estado transitado[" + transicionActual.getEstadoTransitado().getNombre() + "]");

				}
			} else {
				logger.error("ERROR: Intentando publicar ODE con identificador [" + idODE + "]  con usuario["
						+ idUsuario + "] y comentarios[" + comentarios + "]. El fichero original[" + oldFile.getPath()
						+ "] no existe.");
				return new ResultadoOperacionVO(FICHERO_ORIGINAL_ODE_NO_EXISTE,
						getPropertyValueI18n(FICHERO_ORIGINAL_ODE_NO_EXISTE),idODE,new Long(0));
			}
		} else {
			logger.error("ERROR: Intentando publicar ODE con identificador [" + idODE + "]  con usuario[" + idUsuario
					+ "] y comentarios[" + comentarios
					+ "]. El identificador del ODE tiene una lozalizacion invalida => MEC[" + localizadorVO.getMec()
					+ "]");
			return new ResultadoOperacionVO(IDENTIFICADOR_ODE_LOCALIZACION_INVALIDA,
					getPropertyValueI18n(IDENTIFICADOR_ODE_LOCALIZACION_INVALIDA),idODE,new Long(0));
		}
		return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
	}

	/*
	 * Este metodo devuelve los ODEs que estando en el estado que se le pasa,
	 * han sido creados por el usuario que se le pasa. Devuelve la lista de
	 * transiciones de ODEs que cumplen esta condicion ordenada por
	 */
	private TransicionVO[] obtenerODEsPorEstadoUsuario(String idUsuario, String estado) {
		// Rescatamos los actuales que estan en el estado que nos pasan
		UsuarioCreacionEstadoFechaCriteria criterioActuales = new UsuarioCreacionEstadoFechaCriteria(idUsuario, // comprobamos que el usuario que nos pasan es el que creo el ODE.
				this.getEstadoDao().obtenEstadoPorNombre(estado), // estado actual
				null,// estado transitado
				null);// fecha
		// Obtenemos la lista de los ODEs que estan en estado actualmente.
		List lista = this.getTransicionDao().buscarODEsPorCriterioUsuarioCreacionEstadoFecha(
				TransicionDao.TRANSFORM_TRANSICIONVO, // vamos a devolver VOs
				criterioActuales); // el criterio de busqueda.

		// Devolvemos los elementos que hayamos encontrado que cumplen que el
		// ODE actual este en estado y que fue el
		// usuario que nos pasan el que creo el ODE en su dia.
		if(logger.isDebugEnabled())
		logger.debug("Obtenidos " + lista.size() + " odes por estado: " + estado + " para idusuario: " + idUsuario);
		return (TransicionVO[]) lista.toArray(new TransicionVO[lista.size()]);
	}
	
	/*
	 * Este metodo devuelve los ODEs que estando en el estado que se le pasa,
	 * han sido creados por el usuario que se le pasa. Devuelve la lista de
	 * transiciones de ODEs que cumplen esta condicion ordenada por
	 */
	private TransicionVO[] obtenerODEsPorEstadoUsuarios(String[] idUsuarios, String estado) {
		// Rescatamos los actuales que estan en el estado que nos pasan
		UsuariosCreacionEstadoFechaCriteria criterioActuales = new UsuariosCreacionEstadoFechaCriteria(idUsuarios, // comprobamos que el usuario que nos pasan es el que creo el ODE.
				null, // estado transitado
				this.getEstadoDao().obtenEstadoPorNombre(estado),// estado actual
				null);// fecha
		// Obtenemos la lista de los ODEs que estan en estado actualmente y pertenecen a los tipos que nos pasan
		List lista = this.getTransicionDao().buscarODEsPorCriterioUsuariosCreacionEstadoFecha(
				TransicionDao.TRANSFORM_TRANSICIONVO, // vamos a devolver VOs
				criterioActuales); // el criterio de busqueda.

		// Devolvemos los elementos que hayamos encontrado que cumplen que el
		// ODE actual este en estado y que fue alguno de los
		// usuarios que nos pasan los que crearon el ODE en su dia.
		if(logger.isDebugEnabled())
		logger.debug("Obtenidos " + lista.size() + " odes por estado: " + estado + " para usuarios: " + idUsuarios.length);
		return (TransicionVO[]) lista.toArray(new TransicionVO[lista.size()]);
	}

	/*
	 * Este metodo devuelve los ODEs que estando en el estado que se le pasa,
	 * han sido creados por el usuario que se le pasa. Devuelve la lista de
	 * transiciones de ODEs que cumplen esta condicion ordenada por
	 */
	private TransicionVO[] obtenerODEsPorDosEstadosUsuario(String idUsuario, String estado1, String estado2) {
		// ESTADO1
		// Rescatamos los actuales que estan en el estado que nos pasan
		UsuarioCreacionEstadoFechaCriteria criterioActuales = new UsuarioCreacionEstadoFechaCriteria(idUsuario, // comprobamos
																												// que
																												// el
																												// usuario
																												// que
																												// nos
																												// pasan
																												// es
																												// el
																												// que
																												// creo
																												// el
																												// ODE.
				this.getEstadoDao().obtenEstadoPorNombre(estado1), // estado
																	// actual
				null,// estado transitado
				null);// fecha
		// Obtenemos la lista de los ODEs que estan en estado actualmente.
		List lista = this.getTransicionDao().buscarODEsPorCriterioUsuarioCreacionEstadoFecha(
				TransicionDao.TRANSFORM_TRANSICIONVO, // vamos a devolver VOs
				criterioActuales); // el criterio de busqueda.

		// ESTADO2
		criterioActuales = new UsuarioCreacionEstadoFechaCriteria(idUsuario, // comprobamos
																				// que
																				// el
																				// usuario
																				// que
																				// nos
																				// pasan
																				// es
																				// el
																				// que
																				// creo
																				// el
																				// ODE.
				this.getEstadoDao().obtenEstadoPorNombre(estado2), // estado
																	// actual
				null,// estado transitado
				null);// fecha

		lista.addAll(this.getTransicionDao().buscarODEsPorCriterioUsuarioCreacionEstadoFecha(
				TransicionDao.TRANSFORM_TRANSICIONVO, // vamos a devolver VOs
				criterioActuales)); // el criterio de busqueda.
		// Devolvemos los elementos que hayamos encontrado que cumplen que el
		// ODE actual este en estado y que fue el
		// usuario que nos pasan el que creo el ODE en su dia.
		if(logger.isDebugEnabled())
		logger.debug("Obtenidos " + lista.size() + " odes por 2 estados: " + estado1 + " y " + estado2
				+ " para idusuario: " + idUsuario);
		return (TransicionVO[]) lista.toArray(new TransicionVO[lista.size()]);
	}

	/**
	 * Introduce en el manifest la contribucion del publicador que se le pasa.
	 * 
	 * @param imsmanifest
	 * @param idUsuario
	 * @throws ParseadorException
	 */
	private void introducePublicadorManifest(String localizador, String idUsuario, Manifest imsmanifest)
			throws Exception {
		try {

			ManifestAgrega manAgrega = new ManifestAgrega(imsmanifest);
			Lom lom = manAgrega.obtenerLom(imsmanifest.getIdentifier(), null);
			if (lom != null) {
				if(logger.isDebugEnabled())
				logger.debug("introducePublicadorManifest:Manipulando lom");
				LomAgrega lomAgrega = new LomAgrega(lom);
				LifeCycleAgrega cicloVida = lomAgrega.getLifeCycleAgrega();
				if (cicloVida == null)
					cicloVida = new LifeCycleAgrega(new LifeCycle());

				// Generamos la entidad VCARD con la entidad
				String entidad = "BEGIN:VCARD VERSION:3.0 FN: " + idUsuario + " EMAIL;TYPE=INTERNET:  ORG: Plataforma Agrega";
				// Generamos la fecha de hoy con formato YYYYMMDD
				java.util.Date date = new java.util.Date();
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
				String cadenaFecha = formato.format(date);
				String[] cadenas=cadenaFecha.split(" ");
				String fecha=cadenas[0].concat("T").concat(cadenas[1]).concat("Z");
//				cadenaFecha=cadenaFecha.concat("Z");//Para que el manifest recoja también las horas necesita esete formato
				// Hacemos el set
				cicloVida.addContribucionPublicacion(entidad, fecha);
				lom.setLifeCycle(cicloVida.getLifeCycle());
				if(logger.isDebugEnabled())
				logger.debug("introducePublicadorManifest:Re-introduciendo Lom en Manifest: entidad: " + entidad + " fecha: "+ cadenaFecha);
				manAgrega.setLom(imsmanifest.getIdentifier(), null, lom);
				imsmanifest = manAgrega.getManifest();
				if(logger.isDebugEnabled())
				logger.debug("introducePublicadorManifest:Lom modificado en objeto Manifest");
			}
			if(logger.isDebugEnabled())
			logger.debug("introducePublicadorManifest:Escribiendo Manifest modificado: localizador" + localizador );
			File prueba = new File(localizador, MANIFEST_NAME);
			this.getScormDao().escribirODE(imsmanifest, prueba);
			if(logger.isDebugEnabled())
			logger.debug("introducePublicadorManifest:Manifest modificado con exito. Manifest.id = "
					+ imsmanifest.getIdentifier());
		} catch (Exception e) {
			logger
					.error(
							"introducePublicadorManifest: Error durante la modificacion del manifest a publicar. No se ha podido introducir la contribucion del publicador["
									+ idUsuario + "]localizador[" + localizador + "]", e);
		}
		if(logger.isDebugEnabled())
		logger.debug("introducePublicadorManifest finalizado");
	}
	
	private void introduceLocalizacionWEB(String localizador, String idUsuario, Manifest imsmanifest)
		throws Exception {
		try {

			ManifestAgrega manAgrega = new ManifestAgrega(imsmanifest);
			Lom lom = manAgrega.obtenerLom(imsmanifest.getIdentifier(), null);
			LomAgrega lomAg = new LomAgrega(lom);
			if (lomAg != null) {
				if(logger.isDebugEnabled())
					logger.debug("introduceLocalizacionWEB:Manipulando lom");
				// sacamos el idioma en el que se va a indexar el ODE para poder construir la URL de la WEB
				MetaMetadataAgrega metaMeta = lomAg.getMetaMetadataAgrega();
				String idioma = metaMeta.getIdioma();
				TechnicalAgrega tecnical = lomAg.getTechnicalAgrega();
				ArrayList localizacionesOrigen = tecnical.getLocalizacionAv();
				ArrayList localizacionesDestino = new ArrayList();
				// la localizacion esta compuesta por una url con el host, el recurso del servlet que monta la ficha, el id del ode y el idioma
				String mec = lomAg.getGeneralAgrega().getPrimerIdentificador();
				String miNuevaLocalizacion= "";
				if(!(LdapUserDetailsUtils.getSubdominio() == "")&&!(LdapUserDetailsUtils.getSubdominio() == " ")&&!(LdapUserDetailsUtils.getSubdominio() == null))
				{
					miNuevaLocalizacion = HTTP_PROTOCOL +AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.HOST)+ LdapUserDetailsUtils.getSubdominio()+"/"+
								props.getProperty(URL_FICHA)+"?"+
								IDIOMA_FICHA+"="+idioma+"&"+
								IDENTIFICADOR_FICHA+"="+mec;
				}else
				{
					miNuevaLocalizacion = HTTP_PROTOCOL +AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.HOST)+ 
												props.getProperty(URL_FICHA)+"?"+
												IDIOMA_FICHA+"="+idioma+"&"+
												IDENTIFICADOR_FICHA+"="+mec;
				}
				localizacionesDestino.add(miNuevaLocalizacion);
				localizacionesDestino.addAll(localizacionesOrigen);
				tecnical.setLocalizadorAv(localizacionesDestino);
				lomAg.setTechnicalAgrega(tecnical);
				// reconstruimos el objeto lom
				manAgrega.setLom(imsmanifest.getIdentifier(), null, lomAg.getLom());
				imsmanifest = manAgrega.getManifest();
				if(logger.isDebugEnabled())
					logger.debug("introduceLocalizacionWEB:Escribiendo Manifest modificado: localizador" + localizador );
				File prueba = new File(localizador, MANIFEST_NAME);
				this.getScormDao().escribirODE(imsmanifest, prueba);
			}
		} catch (Exception e) {
			logger.error(
					"introduceLocalizacionWEB: Error durante la modificacion del manifest a publicar. No se ha podido introducir la contribucion del publicador["
					+ idUsuario + "]localizador[" + localizador + "]", e);
		}
		if(logger.isDebugEnabled())
			logger.debug("introduceLocalizacionWEB finalizado");
	}


	/**
	 * Parsea el manifest almacenado en <em>localizador</em> y comprueba que
	 * Manifest.getIdentifier devuelve el MEC. Si no es asi, significa que es la
	 * primera vez que indexamos este ODE (publicacion). Hay que cambiar el
	 * viejo UUID por el MEC e introducir el MEC en el campo LOM-ES del
	 * manifiesto.
	 * 
	 * @param mec
	 *            Identificativo MEC del ODE
	 * @param localizador
	 *            Localizador del ODE
	 */
	private void cambiaUUIDxMEC(String mec, String localizador, Manifest manifest, String catalogo) {
		if (logger.isDebugEnabled())
			logger.debug("Entrando en cambiaUUIDxMEC con mec " + mec + " y localizador " + localizador);
		try {

			if (logger.isDebugEnabled())
				logger.debug("MEC = " + mec + "; Identifier = " + manifest.getIdentifier());

			// Cambiar el mec si no es igual
			if (!mec.equals(manifest.getIdentifier())) {
				if(logger.isDebugEnabled())
				logger.debug("Cambiando el Manifest.getIdentifier");
				manifest.setIdentifier(mec);
			}

			// 
			if(logger.isDebugEnabled())
			logger.debug("Buscando LOM-ES principal del manifiesto");
			ManifestAgrega manAgrega = new ManifestAgrega(manifest);
			// Lom lom = manAgrega.obtenerLom(mec, null);
			Lom lom = manAgrega.obtenerLom(manifest.getIdentifier(), null);
			if (lom != null) {
				if(logger.isDebugEnabled())
				logger.debug("Manipulando lom");
				LomAgrega lomAgrega = new LomAgrega(lom);

				// hay que comprobar que es distinto el agrega del mec, si es
				// así lo recubrimos.
				if (lomAgrega.getGeneralAgrega() != null
						&& !lomAgrega.getGeneralAgrega().getPrimerIdentificador().equals(mec)) {
					lomAgrega.getGeneralAgrega().setIdentificadorMEC(catalogo, mec);

					// Campo 3.1 - Identificador del LOM-ES con sufijo meta
					lomAgrega.getMetaMetadataAgrega().setIdentificadorMEC(catalogo, mec + "-meta");
					if(logger.isDebugEnabled())
					logger.debug("MEC introducido en el LOM-ES del manifiesto");
					lom.setMetaMetadata(lomAgrega.getMetaMetadataAgrega().getMetaMetadata());
					if(logger.isDebugEnabled())
					logger.debug("Re-introduciendo Lom en Manifest");
					// manAgrega.setLom(mec, null, lom);
					manAgrega.setLom(manifest.getIdentifier(), null, lom);
					manifest = manAgrega.getManifest();
					if(logger.isDebugEnabled())
					logger.debug("Lom modificado en objeto Manifest");
				} else {
					logger.warn("El Lom del manifest [" + mec + "] no tiene objeto general o el primer identificador"
							+ " que contiene es igual al mec");
				}
			}
			if(logger.isDebugEnabled())
			logger.debug("Escribiendo Manifest modificado");
			File prueba = new File(localizador, MANIFEST_NAME);
			this.getScormDao().escribirODE(manifest, prueba);

			if (logger.isDebugEnabled())
				logger.debug("Manifest modificado con exito. Manifest.id = " + manifest.getIdentifier());

		} catch (Exception e) {
			logger.error("Error durante la modificacion del manifest publicado. No se ha podido introducir el MEC.", e);
		}
		if(logger.isDebugEnabled())
		logger.debug("cambiaUUIDxMEC finalizado");
	}

	/**Este metodo recoge los properties
	 * 
	 * @param sKey
	 * 			La clave de la propiedad
	 * @return
	 * 		Devuelve la propiedad como un String
	 */
	public static String getPropertyValue(String sKey) {
		String sReturn = new String();
		try {
			if (props == null) {
				InputStream fIsSpringProperties = SrvPublicacionServiceBase.class
						.getResourceAsStream(FILE_NAME_PROPERTIES);
				props = new java.util.Properties();
				props.load(fIsSpringProperties);
			}
			sReturn = props.getProperty(sKey);
			if (logger.isDebugEnabled())
				logger.debug("propiedad obtenida: " + sReturn.toString());
		} catch (IOException e) {
			logger.warn("Excepcion intentando obtener propiedad [" + sKey
					+ "] del fichero de propiedades del publicador[" + e.getCause() + "]");
		}
		// devolvemos la propiedad
		return sReturn;
	}



	/**Este metodo recoge los properties internacionalizados
	 * 
	 * @param sKey
	 * 			La clave de la propiedad
	 * @return
	 * 		Devuelve la propiedad como un String
	 */
	public static String getPropertyValueI18n(String sKey) {
		String idiomaUser = null;
		String retorno = null;
		try {
			if(logger.isDebugEnabled())
			logger.debug("Hemos entrado aqui");
			idiomaUser = LdapUserDetailsUtils.getIdioma();
			retorno = getPropertyValueI18n(sKey, idiomaUser);
		} catch (Exception e) {
			logger.warn("Excepcion intentando obtener propiedad [" + sKey + "] del fichero de propiedades i18n["
					+ idiomaUser + "] del publicador[" + e.getCause() + "]", e);
		}
		return retorno;
	}
	/**Este metodo recoge los properties internacionalizados, en el idioma que le indicamos
	 * 
	 * @param sKey
	 * 			La clave de la propiedad
	 * @param idioma
	 * 			Idioma en el que queremos internacionalizar
	 * @return
	 * 		Devuelve la propiedad como un String
	 */
	public static String getPropertyValueI18n(String sKey, String idioma) {
		String idiomaUser = null;
		ResourceBundle fichero = null;
		String retorno = null;
		try {
			idiomaUser = idioma;
			// No tengo mapa con los bundles de los idiomas o no tengo cargado
			// el del idioma, lo cargo e inicializo
			if (propsI18n == null || (fichero = (ResourceBundle) propsI18n.get(idiomaUser)) == null) {
				if (propsI18n == null) // inicializo la variable
					propsI18n = new HashMap();
				if ((fichero = (ResourceBundle) propsI18n.get(idiomaUser)) == null) // no
																					// hay
																					// fichero
																					// de
																					// bundle
																					// para
																					// este
																					// idioma,
																					// lo
																					// cargo
					addBundleFile(idiomaUser);
			}
			if ((fichero = (ResourceBundle) propsI18n.get(idiomaUser)) == null)
				throw new Exception("Error intentando acceder al fichero de propiedades["
						+ SrvPublicacionServiceImpl.FILE_NAME_I18N + "] i18n del publicador con idioma[" + idiomaUser
						+ "]. El fichero no existe.");
			retorno = fichero.getString(sKey);
			if (logger.isDebugEnabled())
				logger.debug("propiedad internacionalizada obtenida[" + sKey + "]->[" + retorno + "]");
		} catch (Exception e) {
			logger.warn("Excepcion intentando obtener propiedad [" + sKey + "] del fichero de propiedades i18n["
					+ idiomaUser + "] del publicador[" + e.getCause() + "]", e);
		}
		// devolvemos la propiedad
		return retorno;
	}

	/*
	 * Añade un bundle para ese idioma a la coleccion de bundles y lo devuelve
	 */
	private static ResourceBundle addBundleFile(String idioma) {
		// Chequeamos que exista el fichero de bundle para el idioma dado.
		// Si no existe el fichero de properties para el idioma, no lo añadimos
		ResourceBundle fichero = null;
		try {
			fichero = ResourceBundle.getBundle(SrvPublicacionServiceImpl.FILE_NAME_I18N, new Locale(idioma));
		} catch (RuntimeException e) {
			// No existe un resource bundle para un idioma dado
			logger.warn("Excepcion intentando buscar el fichero de bundle para el idioma[" + idioma + "]["
					+ e.getCause() + "]");
			return null;
		}
		if (fichero == null)
			return fichero;
		propsI18n.put(idioma, fichero);
		return fichero;
	}

	/**
	 * Muestra los odes de todos los usuarios del noodo que estan despublicados
	 * (no disponibles).
	 * 
	 * @return TransicionVO[] Devuelve las transiciones de los ODEs que estan en
	 *         este estado.
	 * @throws Exception
	 */
	protected TransicionVO[] handleObtenODEsDespublicados() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("buscando Odes por estado: " + SrvPublicacionServiceImpl.NO_DISPONIBLE);
		TransicionDao transicion = this.getTransicionDao();
		EstadoCriteria criterio = new EstadoCriteria();
		EstadoDao estadoDao = this.getEstadoDao();

		criterio.setEstadoActual(estadoDao.obtenEstadoPorNombre(SrvPublicacionServiceImpl.NO_DISPONIBLE));
		List transiciones = transicion.buscarODEsPorCriterioEstado(TransicionDao.TRANSFORM_TRANSICIONVO, criterio);
		return (TransicionVO[]) transiciones.toArray(new TransicionVO[transiciones.size()]);
	}

	/**
	 * Este metodo devuelve los ODEs que estan en estado No Disponible asociados
	 * al usuario dado.
	 * 
	 * @param idUsuario
	 *            Identificador del usuario que creo el ODE y al que se le
	 *            asocia el ODE.
	 * @return TransicionVO[] Devuelve las transiciones de los ODEs que estan en
	 *         este estado para el usuario dado.
	 * @throws Exception
	 */
	protected TransicionVO[] handleObtenODEsDespublicadosPorUsuario(String idUsuario) throws Exception {
		return obtenerODEsPorEstadoUsuario(idUsuario, SrvPublicacionServiceImpl.NO_DISPONIBLE);
	}

	/**
	 * Este metodo devuelve los ODEs que estan en estado propuesto
	 * 
	 * @return TransicionVO[] Devuelve las transiciones de los ODEs que estan en
	 *         este estado para el usuario dado.
	 * @throws Exception
	 */
	protected TransicionVO[] handleObtenODEsPropuestos() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("buscando Odes por estado: " + SrvPublicacionServiceImpl.PROPUESTO);
		TransicionDao transicion = this.getTransicionDao();
		EstadoCriteria criterio = new EstadoCriteria();
		EstadoDao estadoDao = this.getEstadoDao();

		criterio.setEstadoActual(estadoDao.obtenEstadoPorNombre(SrvPublicacionServiceImpl.PROPUESTO));
		List transiciones = transicion.buscarODEsPorCriterioEstado(TransicionDao.TRANSFORM_TRANSICIONVO, criterio);
		return (TransicionVO[]) transiciones.toArray(new TransicionVO[transiciones.size()]);

	}

	/**
	 * Publica un ode que este en estado despublicado. No genera un nuevo codigo
	 * mec.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return ResultadoOperacionVO Devuelve un VO con el error que se ha producido en el caso
	 *         de detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handlePublicarDespublicado(String idODE, String idUsuario, String comentarios,
			String titulo, String comunidades, String tipoLicencia, String universal) throws Exception {
		return publicarDespublicado( idODE, idUsuario, comentarios,
				titulo, comunidades, tipoLicencia, universal, true);
	}

	/**
	 * Publica un ode que este en estado despublicado. No genera un nuevo codigo
	 * mec.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @param comunidades 
	 * 				comunidades a los que se asocia el ode
	 * @param tipoLicencia
	 * 				tipo de licencia que tiene asociado el ode.
	 * @param universal
	 * 				si el ode tiene ámbito universal o no.
	 * @param validar 
	 * 				variable que indica si tenemos que validar el ode o no     
	 * @return ResultadoOperacionVO Devuelve un VO con el error que se ha producido en el caso
	 *         de detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO publicarDespublicado(String idODE, String idUsuario, String comentarios,
			String titulo, String comunidades, String tipoLicencia, String universal, boolean validar) throws Exception {
		try {
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());

			logger.info("Publicando ODE (Despublicado)con identificador [" + idODE + "] en estado[" + estado.getClave()
					+ "] con usuario[" + idUsuario + "] y comentarios[" + comentarios + "].");
			if (estado.getClave().equals(SrvPublicacionServiceImpl.NO_DISPONIBLE)) {
				SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
				LocalizadorVO localizadorP = localizadorService.consultaLocalizador(idODE);
//				Hacemos la validacion que nos devuelve el texto de error menos detallado.
				boolean ODEvalido = false;
				ValidaVO valid = null;
				if (validar)  // si hay que validar el ODE, lo valido y miro a ver si continuo
				{
					valid = this.getSrvValidadorService().obtenerValidacion(localizadorP.getPath());
					ODEvalido = valid.getEsValidoManifest().booleanValue();
					if(logger.isDebugEnabled())
					logger.debug("Validando el ODE [" + localizadorP.getPath() + "]");
				}
				else// si no hay que validar el ODE, es porque ya viene valido.
					ODEvalido = true;
				if (ODEvalido) {
					if (logger.isDebugEnabled())
						logger.debug("El ode: [" + localizadorP.getPath() + "] es válido");

					Long tamanio = tamanioDir(localizadorP.getPath());

					EstadoDao estadoDao = this.getEstadoDao();
					TransicionDao transicionDao = this.getTransicionDao();
					OdePublicadoDao idiomaODEPublicadoDao = this.getOdePublicadoDao();

					// Extraemos el manifest y modificamos el lom que queremos
					File extraeSubmanifest = new File(localizadorP.getPath(), MANIFEST_NAME);
					Manifest imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
					
					//Modificamos el ciclo de vida, le introducimos la entidad y la fecha
					introducePublicadorManifest(localizadorP.getPath(), idUsuario, imsmanifest);
					
					ManifestAgrega manAgrega = new ManifestAgrega(imsmanifest);
					// Lom lom = manAgrega.obtenerLom(idODE, null);
					Lom lom = manAgrega.obtenerLom(manAgrega.getManifest().getIdentifier(), null);
					if (lom != null) {
						if(logger.isDebugEnabled())
						logger.debug("Publicación del ode, añadiendo licencia:Manipulando lom");
						
						LomAgrega lomAgrega = new LomAgrega(lom);
						lomAgrega.getRightsAgrega().setDerechosDeAutor(tipoLicencia);
						lomAgrega.getRightsAgrega().setAcceso(universal, comunidades);

						// Hacemos el set
						lom.setRights(lomAgrega.getRightsAgrega().getRights());
						if(logger.isDebugEnabled())
						logger.debug("introducePublicadorManifest:Re-introduciendo Lom en Manifest");
						// manAgrega.setLom(idODE, null, lom);
						manAgrega.setLom(manAgrega.getManifest().getIdentifier(), null, lom);
						imsmanifest = manAgrega.getManifest();
						if(logger.isDebugEnabled())
						logger.debug("introducePublicadorManifest:Lom modificado en objeto Manifest");
					}
					if(logger.isDebugEnabled())
					logger.debug("Publicación del ode, añadiendo licencia::Escribiendo Manifest modificado");

					// guardamos el manifest modificado
					File fManifest = new File(localizadorP.getPath(), this.MANIFEST_NAME);
					this.getScormDao().escribirODE(imsmanifest, fManifest);

					// Rellenar VOs para indexación,la valoracion, la dejamos a
					// 3 de inicio, somos
					// relativamente positivos
					es.pode.indexador.negocio.servicios.indexado.IdODEVO idOdeVo = rellenaIdOdeVO(new ManifestAgrega(
							imsmanifest) // Utilizamos el Manifest Agrega
											// como wrapper del manifest del
											// ODE.
							, localizadorP.getPath(), idODE, "-1", new Float(tamanioDir(localizadorP.getPath())
									.floatValue()));

					es.pode.indexador.negocio.servicios.indexado.IdODEVO index[] = new es.pode.indexador.negocio.servicios.indexado.IdODEVO[1];
					index[0] = idOdeVo;

					IndexadorVO res[] = null;
					try {
						res = this.getSrvIndexadorService().indexarODE(index);
					} catch (Exception ex) {
						logger.error("No se ha podido indexar ODE con id[" + idODE + "] mec[" + idODE + "] y usuario["
								+ idUsuario + "], no se copia a la carpeta de publicados: error en indexación", ex);
						return new ResultadoOperacionVO(ERROR_INDEXACION, getPropertyValueI18n(ERROR_INDEXACION),idODE,new Long(0));
					}
					// indexacion(localizadorVO.getPath(),
					// localizadorVO.getIdentificador());
					if (res == null || !(res.length > 0) || (res[0].getCode() == 1)) {
						logger.error("No se ha podido indexar ODE con id[" + idODE + "] mec[" + idODE + "] y usuario["
								+ idUsuario + "], no se copia a la carpeta de publicados: error en indexación -- res check");
						return new ResultadoOperacionVO(ERROR_INDEXACION, getPropertyValueI18n(ERROR_INDEXACION),idODE,new Long(0));
					} else {
						// Creamos la transicion de ODE publicado
						Transicion transicionAux = handleObtenerUltimaTransicion(idODE);
						Date fecha = new Date(System.currentTimeMillis());
						transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, idOdeVo.getCatalogacionPrimaria()
								.getTitulo(), transicionAux.getIdUsuarioCreacion(),// arrastramos
																					// el
																					// usuario
																					// de
																					// creacion
																					// del
																					// ODE.
								new Long(fecha.getTime()),new Boolean(false), null, estadoDao.obtenEstadoPorNombre(PUBLICADO));
						logger.info("Creamos la transicion del identificador[" + localizadorP.getIdentificador()
								+ "] con estado actual[PUBLICADO]");

						// Actualizamos la transicion actual
						Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
						transicionActual.setEstadoTransitado(estadoDao.obtenEstadoPorNombre(PUBLICADO));
						transicionDao.update(transicionActual);

						if (logger.isDebugEnabled())
							logger.debug("Transitamos el estado de identificador[" + idODE + "] y mec[" + idODE
									+ "] de estado actual[" + transicionActual.getEstadoActual().getNombre()
									+ "]a estado transitado[" + transicionActual.getEstadoTransitado().getNombre()
									+ "]");

						// Creamos la nueva entrada del idioma en el que se ha
						// publicado el ode
						idiomaODEPublicadoDao.create(idODE, idOdeVo.getCatalogacionPrimaria().getIdioma(), tamanio,
								DateManager.dateToCalendar(new Date(System.currentTimeMillis())), idOdeVo.getCatalogacionPrimaria().getTitulo());
						return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
					}

				}// si no es válido no indexamos y no publicamos
				else {
					// bbdd
					logger.error("Imposible validar el ODE[" + localizadorP.getPath() + "] con error["
							+ valid.getResultadoValidacion() + "]. Imposible publicar");
					return new ResultadoOperacionVO(this.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,new Long(0));
				}
			} else {
				logger.error("ERROR: Intentando publicar ODE con identificador [" + idODE + "] en estado["
						+ estado.getClave() + "] con usuario[" + idUsuario + "] y comentarios[" + comentarios
						+ "]. El estado del ODE no es NO DISPONIBLES.");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
			}
		} catch (Exception e) {
			PublicarException exception = new PublicarException("Fallo en la publicación de ODE con id " + idODE
					+ " y usuario " + idUsuario, e);
			logger.error("Fallo en la publicación de ODE con id " + idODE + " y usuario " + idUsuario, exception);
			throw exception;
		}
	}
	
	/*
	 * Este metodo calcula el tamanio del directorio o fichero que le pasan. Si
	 * se trata de un directorio calcula el tamanio del directorio en funcion
	 * del tamanio de los ficheros que contiene incluidos los ficheros que se
	 * hallen en subdirectorios dentro del directorio.
	 */
	private Long tamanioDir(String path) throws IOException {
		if (path == null || path.equals(""))
			return new Long(0);

		long longitud = 0;
		File fichero = new File(path);
		if (fichero.isDirectory()) {
			String list[] = fichero.list();
			for (int i = 0; i < list.length; i++) {
				String subFichero = fichero.getAbsolutePath() + "/" + list[i];
				longitud += tamanioDir(subFichero).longValue();
			}
		} else {
			longitud = fichero.length();
		}
		return new Long(longitud);
	}

	/**
	 * Este metodo devuele la licencia de un ODE, del que sabemos su id.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @param idioma.
	 * @return LicenciaVO Devuelve la licencia.
	 * @throws Exception
	 */
	protected LicenciaVO handleObtenLicenciaODE(String idODE, String idioma) throws Exception {

		SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
		LocalizadorVO localizadorP = localizadorService.consultaLocalizador(idODE);

		File extraeSubmanifest = new File(localizadorP.getPath(), MANIFEST_NAME);
		Manifest imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
		ManifestAgrega manAgrega = new ManifestAgrega(imsmanifest);
		// Lom lom = manAgrega.obtenerLom(idODE, null);
		Lom lom = manAgrega.obtenerLom(manAgrega.getManifest().getIdentifier(), null);

		if (lom != null) {
			if(logger.isDebugEnabled())
			logger.debug("Obten Licencia del ode["+idODE+"], añadiendo licencia:Manipulando lom");

			LicenciaVO licencia = new LicenciaVO();
			LomAgrega lomAgrega = new LomAgrega(lom);
			if(logger.isDebugEnabled())
				logger.debug("Obten Licencia del ode["+idODE+"], obteniendo lomAgrega");
			
			// LOM-NDRB: Use the first description field as the license
			ArrayList rightsDescription = lomAgrega.getRightsAgrega().getDescripcionesAv();			
			licencia.setTipoLicencia(((LangStringAgrega)rightsDescription.get(0)).getValor());
			
			if(logger.isDebugEnabled())
				logger.debug("Obten Licencia del ode["+idODE+"], haciendo set de tipo licencia["+lomAgrega.getRightsAgrega().getDerechosDeAutor()+"]");
			licencia.setUniversal(lomAgrega.getRightsAgrega().getTipoDeAcceso());
			if(logger.isDebugEnabled())
				logger.debug("Obten Licencia del ode["+idODE+"], haciendo set de tipo acceso["+lomAgrega.getRightsAgrega().getTipoDeAcceso()+"]");
			licencia.setComunidades(lomAgrega.getRightsAgrega().getDescripcionAcceso(idioma));
			if(logger.isDebugEnabled())
				logger.debug("Obten Licencia del ode["+idODE+"], haciendo set de comunidades["+lomAgrega.getRightsAgrega().getDescripcionAcceso(idioma)+"]");
			return licencia;

		} else {
			logger.error("El Lom del ODE es null");
			return null;
		}

	}

	/**
	 * Este metodo elimina un ODE publicado sin dejar rastro en la plataforma: -
	 * Elimina el historico de transiciones. - Elimina la localizacion de disco
	 * y todos los recursos. - Elimina la valoracion con que se haya valorado el
	 * ODE. - Elimina la indexacion del ODE. - Elimina la entrada de la tabla de
	 * publicados.
	 */
	private void eliminaODEPublicado(String mec) throws Exception {
		logger.info("Invocando la eliminacion del ODE con mec[" + mec + "] de la plataforma.");
		// Eliminamos el historico de transiciones
		Transicion[] transiciones = (TransicionImpl[]) obtenHistorialPorIdODE(mec, TransicionDao.TRANSFORM_NONE);
		this.getTransicionDao().remove(Arrays.asList(transiciones));
		logger.info("Eliminadas [" + (transiciones != null ? transiciones.length : 0) + "] transiciones de mec[" + mec
				+ "] de la plataforma.");

		// Eliminamos los comentarios del ODE
		this.getSrvValoracionService().eliminarTodosComentarios(mec);
		logger.info("Eliminadas los comentarios de mec[" + mec + "] de la plataforma.");
		 //Eliminamos la valoracion del ODE
		this.getSrvValoracionService().eliminarTodasValoraciones(mec);
		logger.info("Eliminadas las valoraciones de mec[" + mec + "] de la plataforma.");
		// Eliminamos la entrada en la tabla de publicados
		this.getOdePublicadoDao().eliminaODEsPublicadosPorId(mec);
		logger.info("Eliminada la entrada en publicados de mec[" + mec + "] de la plataforma.");
		// Eliminamos la indexacion
		this.getSrvIndexadorService().eliminarODE(new String[] { mec });
		logger.info("Eliminada la indexacion de mec[" + mec + "] de la plataforma.");

		// Eliminamos la localizacion de disco y los recursos
		LocalizadorVO localizadorPub;
		LocalizadorVO localizadorNPub;
		try { // Eliminamos la localizacion publicada
			localizadorPub = (LocalizadorVO) this.getSrvLocalizadorService().consultaLocalizador(mec);
			this.getSrvLocalizadorService().eliminarLocalizador(localizadorPub.getIdentificador());
			logger.info("Eliminada la localizacion de mec[" + mec + "] de repositorio [" + localizadorPub.getPath()
					+ "]");
		} catch (Exception e) {
			logger.error("Error eliminando localizador publicado de mec[" + mec + "].[" + e.getMessage() + "]");
		}
		try {// Eliminamos la localizacion no publicada
			localizadorNPub = (LocalizadorVO) this.getSrvLocalizadorService().consultaLocalizadorNoPublicado(mec);
			this.getSrvLocalizadorService().eliminarLocalizador(localizadorNPub.getIdentificador());
			logger.info("Eliminada la localizacion de mec[" + mec + "] de taller [" + localizadorNPub.getPath() + "]");
		} catch (Exception e) {
			logger.error("Error eliminando localizador no publicado de mec[" + mec + "].[" + e.getMessage() + "]");
		}
		logger.info("Eliminado ODE publicado con mec[" + mec + "] de la plataforma.");

		return;
	}

	public void setJmsTemplate(JmsTemplate template) {

		this.jmsTemplate = template;
	}

	public JmsTemplate getJmsTemplate() {

		return this.jmsTemplate;
	}

	/**
	 * Metodo que realiza la creacion de la ruta a mostrar y decide si se debe o
	 * no enviar a la cola JMS la peticion para generar la imagen o no. Si el
	 * archivo principal es: .doc, .xls, .ppt, .pdf, .mp3, .wav, etc. Se
	 * apuntara a un icono por defecto y no se solicitara la generacion de dicha
	 * imagen.
	 * 
	 * @param OdeVO
	 *            vo del ode.
	 * @param String
	 *            decide si se debe o no enviar a la cola JMS la peticion para
	 *            generar la imagen o no.
	 * @throws Exception
	 */
	protected String handleCreateImage4Ode(OdeVO ode) throws Exception {
		String sReturn = null;
		try {
			if(logger.isDebugEnabled())
			logger.debug("Begin:createImage4Ode");
			// Chequeo que el Archivo principal y el identificador vengan
			// rellenos
			// Si no es así lanzo una excepción y ya está
			if (ode.getIdentificadorMEC() != null && !ode.getIdentificadorMEC().equals("") && ode.getMainFile() != null
					&& !ode.getMainFile().equals("") && ode.getServerOn() != null && !ode.getServerOn().equals("")) {
				if (logger.isDebugEnabled())
					logger.debug("Antes de enviar el mensaje id[" + ode.getIdentificadorMEC() + "] MainFile ["
							+ ode.getMainFile() + "] serverOn [" + ode.getServerOn() + "]");
				this.sendMessage(ode);
				if(logger.isDebugEnabled())
				logger.debug("El mensaje se ha enviado correctamente");
			} else
				throw new RuntimeException("EL archivo principal no va relleno");
			// Si todo es correctoenvío el VO en un mensaje
			if(logger.isDebugEnabled())
			logger.debug("End:createImage4Ode");
		} catch (Exception ex) {
			logger.error("Se ha producido un error en handleCreateImage4Ode", ex);
		}
		return sReturn;
	}

	/**
	 * Metodo encargado de enviar a la cola JMS el objeto del cual se desea
	 * generar una imagen.
	 * 
	 * @param OdeVO
	 *            vo del ode.
	 * @throws Exception
	 */
	protected void handleSendMessage(final OdeVO ode) throws Exception {
		this.jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return new SimpleMessageConverter().toMessage(ode, session);
			}
		});
	}

	private String localPathGenerate(ManifestAgrega manifestAgrega, String sMec, String sLocalizador,
			DependentServerPropertiesItf properties) throws Exception {
		StringBuffer sbLocalPath = new StringBuffer();

		try {
			String vuelta ="";
			//primero consultamos el recurso de la primera organización-> primer item. Si se trata de un recurso valido, lo escogemos
			if(manifestAgrega.getManifest().getOrganizations()!=null && manifestAgrega.getManifest().getOrganizations().getOrganizationCount()>0 &&
					manifestAgrega.getManifest().getOrganizations().getOrganization(0)!=null && 
					manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem()!=null &&
					manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItemCount()>0 &&
					manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(0)!=null ){
				String identiref=manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(0).getIdentifierref();
				if(logger.isDebugEnabled())
				logger.debug("Estamos en el organization, con el identifierref:["+identiref+"]");
				if(identiref!=null && !identiref.equals("")){
					
					Resource recurso=manifestAgrega.obtenerResource(identiref);
					if(recurso!=null && recurso.getHref()!=null && !recurso.getHref().equals("")){
						vuelta =generacionHref(manifestAgrega,recurso.getHref(),properties,sLocalizador);
						if(logger.isDebugEnabled())
						logger.debug("Se mira el recurso del manifest:["+recurso.getHref()+"] Y la generacion devuelve:["+vuelta+"]");
						if(vuelta!=null){
							return vuelta;
						}
					}
				}
				
			}if(vuelta==null||vuelta.equals("")){ // si no hemos tenido suerte con el recurso de la primera organizacion-> primer item, miramos en el cajon de los
				// recursos y el primero que nos valga, lo escogemos.
				Resources recursos = manifestAgrega.getManifest().getResources();
				if(recursos!=null && recursos.getResourceCount()>0){
					if(logger.isDebugEnabled())
						logger.debug("Se miran los recursos directamente");
					//Recorremos todos los recursos
					for (int i = 0; i < recursos.getResourceCount(); i++) {//Si hay recursos y no hemos encontrado todavía ninguno válido
						Resource recurso = recursos.getResource(i);
						if(recurso!=null && recurso.getHref()!=null && !recurso.getHref().equals("")){
							vuelta =generacionHref(manifestAgrega,recurso.getHref(),properties,sLocalizador);
							if(logger.isDebugEnabled())
								logger.debug("Se mira el recurso directamente:["+recurso.getHref()+"] Y la generacion devuelve:["+vuelta+"]");
							if(vuelta!=null){
								return vuelta;
							}
						}
					}
				}
			}
			
			// Si llego aqui, es que no hay forma de encontrar un recurso valido ni en la primera organizacion ni entre los recursos.
//			Imagen por defecto, puesto que no hay ningún recurso en el ODE válido o fotografiable
			logger.error("No existen recurso válidos] para el mec["
					+ sMec + "] con localizador[" + sLocalizador + "]");
			sbLocalPath.append(properties.getProperty("path"));
			sbLocalPath.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
			sbLocalPath.append(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_DEFECTO));

			if (logger.isDebugEnabled())
				logger.debug("La ruta del objeto en el servidor es [" + sbLocalPath + "], con imagen por defecto");

		} catch (Exception ex) {
			logger.error("Se ha producido un error en localPathGenerate", ex);
			throw ex;
		}
		logger.debug(" El local path que va a devolver el método localPathGenerate es [ "+sbLocalPath.toString());
		return sbLocalPath.toString();
	}

	private String imagePathGenerate(ManifestAgrega manifestAgrega, String sMec, String sLocalizador) {
		StringBuffer imagePathReturn = new StringBuffer();
		try {
			DependentServerPropertiesItf properties = DependentServerProperties.getInstance();
			String serverOn = properties.getServerOn();

			String sLocalPath = this.localPathGenerate(manifestAgrega, sMec, sLocalizador, properties);
			logger.info("Vamos a generar la imagen para el objeto cuya ruta en el servidor es [" + sLocalPath + "]");
			// Ahora debo saber en qué servidor estoy.
			if (logger.isDebugEnabled())
				logger.debug("El servidor es serverOn[" + serverOn + "]");
			AgregaProperties agregaProperties = AgregaPropertiesImpl.getInstance();

			// If we are dealing with a common image eg a static icon for a PDF,
			// the image path to return needs to be entirely different from that
			// generated for a resource thumbnail; see original code in the else
			// block for the latter.
			String localCommonPath = agregaProperties.getProperty(
					AgregaProperties.PROPERTY_IMAGE_COMMON_LOCAL_PATH);
			if (sLocalPath.contains(localCommonPath)) {
				String regex = "^.*" + Pattern.quote(localCommonPath);
				String replacement = Matcher.quoteReplacement(
						agregaProperties.getProperty(
								AgregaProperties.PROPERTY_IMAGE_COMMON_PATH
						));

				imagePathReturn.append(
						sLocalPath.replaceFirst(regex, replacement));
			} else {
				// genero la URL de la imagen
				imagePathReturn.append(agregaProperties.getProperty(AgregaProperties.PROPERTY_IMAGE_APACHE_PATH));
				imagePathReturn.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
//			Tenemos que añadir un codigo MD5 para impedir que en un mismo directorio haya mas de 32000 subdirectorios. El sistema de ficheros no lo 
//			soporta. Lo hacemos por MEC, para valancear la carga entre los codigos que salgan.
				String md5 = EncriptacionUtiles.md5String(sMec).substring(0, 2);
				imagePathReturn.append(md5);
				imagePathReturn.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
				imagePathReturn.append(sMec);
				imagePathReturn.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
				imagePathReturn.append(sMec);
				imagePathReturn.append(agregaProperties.getProperty(AgregaProperties.PROPERTY_IMAGE_EXTENSION));
				if (logger.isDebugEnabled()) {
					logger.debug("Genero el objeto de intercambio Mec [" + sMec + "] localPath [" + sLocalPath
							+ "] serverOn [" + serverOn + "]");
				}
			}

			// genero el Objeto de intercambio
			OdeVO ode = new OdeVO(sMec, sLocalPath, serverOn);
			this.handleCreateImage4Ode(ode);
			if (logger.isDebugEnabled())
				logger.debug("La imagen a indexar es [" + imagePathReturn + "]");
		} catch (Exception ex) {
			logger.error("Se ha producido un error en imageGenerate", ex);
			// throw ex;
		}
		return imagePathReturn.toString();

	}

//	private boolean mustBeImageGenerated(String imagePath) {
//		// Obtenemos la extensión y en función de eso mandamos a generar la
//		// imagen o no
//		// Si el fichero tiene extensión:
//		// MP3, WAV, WMA, AIFF, OGG, TAR, RAR, ZIP, TGZ, PPT, PDF, XLS, DOC,...
//		// No se deben generar y su imagen será la existente previamente
//		boolean mustBeGenerated = true;
//		// Cojo la extensión del fichero y si está
//		// en la lista de posible de posibles imagenes
//		// devuelvo true.
//		if (logger.isDebugEnabled())
//			logger.debug("Chequeamos la extension del MainFile[" + imagePath + "]");
//		String[] arrayExtensions = AgregaPropertiesImpl.getInstance().getProperty("galeriaimg.image.common.ext").split(
//				",");
//
//		// Cojo la extension
//		String extension = imagePath.substring(imagePath.lastIndexOf('.') + 1);
//		if (logger.isDebugEnabled())
//			logger.debug("La extensión del MainFile es [" + extension + "]");
//		// Chequeo que exista en la lista de extensiones previamnete generadas
//		if (arrayExtensions != null && arrayExtensions.length > 0 && extension != null && !extension.equals("")) {
//			for (int i = 0; i < arrayExtensions.length && mustBeGenerated; i++) {
//				mustBeGenerated = !arrayExtensions[i].equalsIgnoreCase(extension);
//			}
//		}
//		if (logger.isDebugEnabled())
//			logger.debug("Se debe generar la imagen? [" + mustBeGenerated + "]");
//		return mustBeGenerated;
//	}

	protected es.pode.publicacion.negocio.servicios.IdODEVO[] handleObtenODEsPublicadosPorPagina(Integer inicio,
			Integer fin, Boolean hayMas) throws Exception {
		// TODO: NO sirve eliminar del modelo
		return null;
	}

	protected es.pode.publicacion.negocio.servicios.IdODEVO[] handleBuscarODEsPorEstado(String estado, Integer inicio,
			Integer fin, Boolean hayMas) throws Exception {
		// TODO: NO sirve eliminar del modelo
		return null;
	}

	/**
	 * Obtiene un historial de las transiciones de estados por los que ha ido
	 * pasando en su historia un ODE.
	 * 
	 * @param idODE
	 *            Identificador del ODE.
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los estados del ODE.
	 * @throws Exception
	 * 
	 */
	/*
	 * Obtiene un historial de las transiciones de estados por los que ha ido
	 * pasando en su historia un ODE. Recibe un identificador de ODE y un
	 * identificador de transformacion para saber que clase de resultado se
	 * quiere: el VO de transicion o el Entity
	 */
	private Object[] obtenHistorialPorIdODE(String idODE, int transform) throws Exception {
		try {
			// Buscamos las transiciones ordenadas por fecha con el
			// identificador que me pasan
			IdODEFechaCriteria criterio = new IdODEFechaCriteria(idODE, // identificador
																		// del
																		// ODE
					null); // fecha
			TransicionDao transicion = this.getTransicionDao();
			// Obtenemos el historial del ODE que nos pasan.
			List list = transicion.buscarHistorialPorIdODEFecha(transform, criterio);

			// Tenemos que revisar que el id que nos pasan sea un MEC, en cuyo
			// caso tenemos que recuperar el UUID
			// y anejar la informacion del ODE con el pasado con el UUID a la
			// que ya hemos rescatado con el MEC
			LocalizadorVO localizadorNP = this.getSrvLocalizadorService().consultaLocalizadorNoPublicado(idODE);
			if (localizadorNP != null) {
				// Vamos a buscar el pasado de este ODE antes de ser publicado
				IdODEFechaCriteria criterio2 = new IdODEFechaCriteria(localizadorNP.getIdentificador(), // identificador
																										// del
																										// ODE
																										// (UUID)
						null); // fecha
				// Tenemos que recuperar el pasado del ODE cuando no estaba
				// publicado y anejarlo al que tenemos publicado
				List listaPasado = transicion.buscarHistorialPorIdODEFecha(transform, criterio2);// utilizamos
																									// el
																									// UUID
																									// del
																									// ODE.
				list.addAll(listaPasado);
			}
			if (TransicionDao.TRANSFORM_TRANSICIONVO == transform)
				return list.toArray(new TransicionVO[list.size()]);
			else
				return list.toArray(new TransicionImpl[list.size()]);
		} catch (Exception e) {
			ObtenerHistoriaODEException exception = new ObtenerHistoriaODEException("ERROR: fallo inesperado con id "
					+ idODE, e);
			logger.error(exception);
			throw exception;
		}
	}

	/*
	 * Copiamos los esquemas XSD a la carpeta del ODE
	 */

	private void copiarEsquemas(String rutaDestino) throws Exception {
		File ficheroNuevo = new File(rutaDestino);
		File ficheroViejo = new File(getPropertyValue("carpeta.schema"));

		if (ficheroViejo.exists()) {
			if(logger.isDebugEnabled())
			logger.debug("vamos a copiar el esquema");
			UtilesFicheros.copiar(ficheroViejo, ficheroNuevo);
		} else {
			logger.error("El fichero origen no existe");
			throw new Exception("El fichero origen " + ficheroViejo.getName() + " no existe en la ruta "
					+ ficheroViejo.getPath());
		}

	}
	/**
	 * Obtiene los odes que están propuestos para catalogación
	 * 
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado propuestos para catalogación.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODESPropuestosCatalogacion() throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("buscando Odes por estado: " + SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION);
		TransicionDao transicion = this.getTransicionDao();
		EstadoCriteria criterio = new EstadoCriteria();
		EstadoDao estadoDao = this.getEstadoDao();
		criterio.setEstadoActual(estadoDao.obtenEstadoPorNombre(SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION));
		List transiciones = transicion.buscarODEsPorCriterioEstado(TransicionDao.TRANSFORM_TRANSICIONVO, criterio);
		logger.info("Obtenidos " + transiciones.size() + " odes en estado "
				+ SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION);
		return (TransicionVO[]) transiciones.toArray(new TransicionVO[transiciones.size()]);

	}
	/**
	 * Obtiene los odes que están propuestos para catalogación por un usuario
	 * 
	 * @param idUsuario
	 * 			El identificador del usuario
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado propuestos para catalogación por un usuario.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODESPropuestosCatalogacionPorUsuario(String idUsuario) throws Exception {
		return obtenerODEsPorEstadoUsuario(idUsuario, SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION);
	}
/**
 * Este método propone para catalogación con o sin validación del ODE
 * @param idODE
 * 			Identificador del ODE.
 * @param idUsuario
 * 			Identificador del usuario que va a proponer para catalogación
 * @comentarios
 * 			Comentarios que pueden ir asociados a la acción realizada.
 * @param titulo
 * 			Titulo del ODE.
 * @param validar
 * 			Boolean para especificar si se debe validar el ode o no.
 * @return ResultadoOperacionVO Devuelve un VO con el error que se ha producido en el caso
 *         de detectarse algun problema.
 * @throws Exception
 */
	protected ResultadoOperacionVO handleProponerCatalogacion(String idODE, String idUsuario, String comentarios,
			String titulo) throws Exception {
		return proponerCatalogacion(idODE, idUsuario, comentarios,	titulo, true);

	}

	/**
	 * Este método propone para catalogación con o sin validación del ODE
	 * @param idODE
	 * 			Identificador del ODE.
	 * @param idUsuario
	 * 			Identificador del usuario que va a proponer para catalogación
	 * @comentarios
	 * 			Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 * 			Titulo del ODE.
	 * @param validar
	 * 			Boolean para especificar si se debe validar el ode o no.
	 * @return ResultadoOperacionVO Devuelve un VO con el error que se ha producido en el caso
	 *         de detectarse algun problema.
	 * @throws Exception
	 */
	protected ResultadoOperacionVO proponerCatalogacion(String idODE, String idUsuario, String comentarios,	String titulo, boolean validar) throws Exception {
		try {
			EstadoVO estado = this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			if(logger.isDebugEnabled())
			logger.debug("Proponiendo para catalogación ODE con identificador[" + idODE + "] usuario[" + idUsuario
					+ "] comentarios[" + comentarios + "] y en estado actual[" + estado + "]");
			if (estado != null
					&& (estado.getClave().equals(SrvPublicacionServiceImpl.CREACION) || estado.getClave().equals(
							SrvPublicacionServiceImpl.RECHAZADO))) {
				// validador
				SrvValidadorService validadorService = this.getSrvValidadorService();
				SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
				LocalizadorVO localizadorNP = localizadorService.consultaLocalizador(idODE);
//				Hacemos la validacion que nos devuelve el texto de error menos detallado.
				boolean ODEvalido = false;
				ValidaVO valid = null;
				if (validar)  // si hay que validar el ODE, lo valido y miro a ver si continuo
				{
					valid = validadorService.obtenerValidacion(localizadorNP.getPath());
					ODEvalido = valid.getEsValidoManifest().booleanValue();
					if(logger.isDebugEnabled())
					logger.debug("Validando el ODE [" + localizadorNP.getPath() + "]");
				}
				else// si no hay que validar el ODE, es porque ya viene valido.
					ODEvalido = true;
				if (ODEvalido) {
					EstadoDao estadoDao = this.getEstadoDao();
					TransicionDao transicionDao = this.getTransicionDao();
					Transicion transicionActual = handleObtenerUltimaTransicion(idODE);
					transicionActual.setEstadoTransitado(estadoDao
							.obtenEstadoPorNombre(SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION));
					transicionDao.update(transicionActual);
					logger.info("Actualizamos estado de ODE con identificador[" + idODE
							+ "] a PROPUESTO para catalogacion.");
					Date fecha = new Date(System.currentTimeMillis());
					transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, transicionActual
							.getIdUsuarioCreacion(),// arrastramos el usuario de
													// creacion
							new Long(fecha.getTime()),new Boolean(false), null, estadoDao
									.obtenEstadoPorNombre(SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION));
					return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
				} else {

					logger.error("ERROR: proponiendo para catalogación ODE con identificador.[" + idODE
							+ "] ODE en estado[" + estado.getClave() + "]. El ode no valida correctamente: "
							+ valid.getResultadoValidacion());
					return new ResultadoOperacionVO(this.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,new Long(0));
				}
			} else {
				// Exception ex = new Exception("ERROR: proponiendo para
				// catalogación ODE con identificador. ODE en estado[CREADO] no
				// se puede pasar a estado PROPUESTO.");
				logger.error("ERROR: proponiendo para catalogacion ODE con identificador[" + idODE
						+ "]. ODE en estado[" + estado.getClave()
						+ "] no se puede pasar a estado PROPUESTO para catalogacion.");
				return new ResultadoOperacionVO(TRANSICION_ESTADO_INVALIDA,
						getPropertyValueI18n(TRANSICION_ESTADO_INVALIDA),idODE,new Long(0));
				// throw ex;
			}
		} catch (Exception e) {
			Exception propuesto = new Exception(
					"Excepción en la proposicion de catalogación del ODE con identificador", e);
			logger.error("Excepción en la proposicion de catalogación del ODE con identificador[" + idODE
					+ "] idUsuario[" + idUsuario + "] comentarios[" + comentarios + "]y titulo[" + titulo + "]",
					propuesto);
			throw propuesto;
		}

	}
	private boolean recursoValido(String href) throws URISyntaxException{


		URI uri=new URI(href);	
		if(uri!=null && !uri.equals("")){
			if(!uri.isOpaque()){//Para quitar las URL-s de tipo mailto:java-net@java.sun.com
				if (logger.isDebugEnabled())
					logger.debug("El recurso con href ["+href+"] es valido");
				return true;
			}else{		
				if (logger.isDebugEnabled())
					logger.debug("El recurso con href ["+href+"] NO es valido");
				return false;
			}
		}
		return false;
	}
	
	private String generacionHref(ManifestAgrega manifestAgrega,String href,DependentServerPropertiesItf properties,String sLocalizador) throws URISyntaxException{
		String sufijosArray=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_COMMON_EXTENSION).toUpperCase();//Para asegurarnos que la comparacion se haga en mayúsculas
		sufijosArray=sufijosArray.replace(" ", "");//Para asegurarnos que los sufijos no tengan ningun espacio en blanco
		String[] sufijos=sufijosArray.split(",");
		//Las extensiones fotografiables, las que hay que fotografiar
		String sufijosFotoArray=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_COMMON_EXTENSION_FOTOGRAFIABLE).toUpperCase();//Para asegurarnos que la comparacion se haga en mayúsculas
		sufijosArray=sufijosFotoArray.replace(" ", "");//Para asegurarnos que los sufijos no tengan ningun espacio en blanco
		String[] sufijosFoto=sufijosFotoArray.split(",");
		
		StringBuffer sbLocalPath = new StringBuffer();
		String hrefCon=href.replace(" ", "_");//Para que cuando tengo espacios vacíos no nso de errores par generar la URI, pero sólo lo utilizamos
		//para validar si es válido ( es decir si es opaco, y si tiene esquema; par generar la imagen fotografiable le pasamos su href con espacios vacíos
		if(this.recursoValido(hrefCon)){
			if(sufijos!=null && sufijos.length>0 ){
				URI urlAux=new URI(hrefCon);
				if(urlAux.getScheme()!=null && !urlAux.getScheme().equals("")){//Si tiene esquema es de tipo http://, https:// o ftp://
//						Imagen por defecto, no podemos dejar que se abra un navegador por lo que pueda contener.
					//Por ahora le ponemos la imagen por defecto, hasta tener el icono
					if(logger.isDebugEnabled())
						logger.debug("Es de tipo http, https, ftp, ftps");
					sbLocalPath.append(properties.getProperty("path"));
					sbLocalPath.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
					sbLocalPath.append(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_DEFECTO));
					if (logger.isDebugEnabled())
						logger.debug("La ruta del objeto en el servidor es [" + sbLocalPath + "], siendo el href del recurso ["+ href+"]");
					return sbLocalPath.toString();
				}else{
					if(sufijosFoto !=null || sufijosFoto.length>0){
						ArrayList listaSufFoto=new ArrayList(Arrays.asList(sufijosFoto));
						boolean contenerSufFoto=listaSufFoto.contains((href.substring(href.lastIndexOf('.') + 1)).toUpperCase().trim());
						logger.info("Esta en los fotografiables?"+contenerSufFoto);
						ArrayList listaSuf=new ArrayList(Arrays.asList(sufijos));
						boolean contenerIcono=listaSuf.contains((href.substring(href.lastIndexOf('.') + 1)).toUpperCase().trim());
						logger.info("Esta en los iconos?"+contenerIcono);
						if(contenerSufFoto || contenerIcono){
							if(logger.isDebugEnabled())
								logger.debug("Es fotografiable con extension ["+(href.substring(href.lastIndexOf('.') + 1)).toUpperCase().trim()+"]");
							if(contenerIcono){//Si tiene una extension a la que hay que meter un icono por defecto
								if(logger.isDebugEnabled())
									logger.debug("Lleva la imagen por defecto con extension ["+(href.substring(href.lastIndexOf('.') + 1)).toUpperCase().trim()+"]");
								sbLocalPath.append(properties.getProperty("path"));
								sbLocalPath.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
								sbLocalPath.append(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_COMMON_LOCAL_PATH));
								sbLocalPath.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
								sbLocalPath.append((href.substring(href.lastIndexOf('.') + 1)).toLowerCase());
								sbLocalPath.append(SrvPublicacionServiceImpl.FILE_ICON_SIZE);
								sbLocalPath.append(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_EXTENSION));
								logger.info("LocalPath generado para las extensiones con iconos [" + sbLocalPath+ "] ");
								return sbLocalPath.toString();
							}
							//Las extensiones a las que hay que sacar foto
							if(logger.isDebugEnabled())
								logger.debug("Es un recurso a la que hay que sacar la foto, extension ["+(href.substring(href.lastIndexOf('.') + 1)).toUpperCase().trim()+"]");
							sbLocalPath.append(properties.getProperty("path"));
							if (logger.isDebugEnabled())
								logger.debug("El path es ["+properties.getProperty("path")+"]");
							sbLocalPath.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
							sbLocalPath.append(sLocalizador);
							if (logger.isDebugEnabled())
								logger.debug("El sLocalizador es ["+sLocalizador+"]");	
							sbLocalPath.append(SrvPublicacionServiceImpl.FILE_SEPARATOR);
							sbLocalPath.append(href);
							if (logger.isDebugEnabled())
							logger.debug("La ruta del objeto en el servidor es [" + sbLocalPath + "], siendo el href del recurso ["+ href+"]");
							return sbLocalPath.toString();
						}
					}
				}
			}
		}
		
		return null;
	}

	
	/*
	 * * Realiza las operaciones de creacion de un ODE en estado CREADO. Valida la
	 * informacion del ODE que se pasa en formato PIF(ZIP) y lo alberga en la
	 * plataforma bajo el usuario con el que se crea. Se descomprime en un
	 * temporal para validarlo, y si valida se crea un localizador y se copia en
	 * él teniendo en cuenta la cuota del usuario.
	 * */
	/**
	 * Un método como crearPif, sólo que toma en cuenta el tamaño del ODE a la hora de validar.
	 * Este metodo crea un ODE en estado CREADO a partir de un fichero PIF teniendo en cuenta el espacio consumido por el usuario (CREADOS más RECHAZADOS) y la cuota de espacio del usuario.
	 * Si el ODE no cabe en la cuota del usuario, se devuelve un error en consecuencia. Si hay espacio suficiente se crea el ODE.
	 * 
	 * @param ficheroPIF
	 *            Fichero en formato PIF.
	 * @param idUsuario
	 *            Identificador del usuario.
	 * @param comentarios
	 *            Comentarios que pueden ir asociados a la acción realizada.
	 * @param titulo
	 *            Titulo del ODE.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	
	protected ResultadoOperacionVO handleCrearPifConCuota(DataHandler pif, String idUsuario, String comentarios, String titulo, String idioma) throws Exception {
//	Invocamos al metodo auxiliar indicandole que queremos tener en cuenta la cuota de usuario.
		return crearPIFAux(pif, idUsuario, comentarios, titulo, idioma, true);
	}
	/* Este metodo nos da las transiciones de los ODEs propuestos para catalogacion del grupo(s) de trabajo(s) al/ a los que pertenece
	 * el usuario. Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * */
	/**
	 * Este metodo nos da las transiciones de los ODEs propuestos para catalogacion del grupo(s) de trabajo(s) al/ a los que pertenece
	 * el usuario. Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * 
	 * @param idsUsuarios
	 * 			Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado propuestos para catalogación por un array de usuarios.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODEsPropuestosCatalogacionPorUsuarios(String[] idsUsuarios) throws Exception {

		return obtenerODEsPorEstadoUsuarios(idsUsuarios, SrvPublicacionServiceImpl.PROPUESTO_CATALOGACION);
	}
	
	/*
	 * Este metodo calcula la cuota de disco consumida por el usuario. Para ello, tiene en cuenta los ODEs en estado CREADO y RECHAZADO para
	 * calcular su consumo.
	 * */
	private long calculaCuotaConsumidaUsuario(String idUsuario) throws Exception
	{
		TransicionVO[] odesEnDisco =  (TransicionVO[])this.handleObtenODEsCreadosPorUsuario(idUsuario);
		if (odesEnDisco == null || odesEnDisco.length == 0) // no hay nada para este usuario, no ha consumido nada.
			return 0;
//		Para cada identificador tengo que saber cuanto ocupan en disco, utilizo el localizador.
		String[] identificadores = new String[odesEnDisco.length];
		for (int i = 0; i < odesEnDisco.length; i++) {
			identificadores[i] = odesEnDisco[i].getIdODE();
		}
//		Se los mando al localizador para que me diga cuanto ocupan las localizaciones en disco.
		Long[] espaciosOcupados = this.getSrvLocalizadorService().consultaEspacioLocalizadores(identificadores);
		long consumoTotal = 0;
		for (int i = 0; i < espaciosOcupados.length; i++) {
			consumoTotal+=(espaciosOcupados[i]!=null?espaciosOcupados[i].longValue():0);
		}
		if (logger.isDebugEnabled()) logger.debug("El espacio consumido por los ODEs en estado CREADO y RECHAZADO del usuario["+idUsuario+"] es de ["+consumoTotal+"] bytes");
		return consumoTotal;
	}
	
	private ResultadoOperacionVO crearPIFAux(DataHandler ficheroPIF, String idUsuario, String comentarios, String titulo, String idioma, boolean chequeaCuota) throws Exception {

		String id_localizadorNP = new String();
		try {
			// utilizar un id generado por la clase de soporte que genera un
			// uuid
			String idODE = es.pode.soporte.uuid.PodeUUIDGenerator
					.getOdeUUID(String.valueOf(System.currentTimeMillis()));
			// creacion
			this.getSrvLocalizadorService().crearLocalizadorNoPublicado(idUsuario, idODE);
			logger.info("Creando PIF utilizando identificador[" + idODE + "], idUsuario[" + idUsuario
					+ "], comentarios[" + comentarios + "] y titulo[" + titulo + "]");

			SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
			LocalizadorVO localizadorNP = localizadorService.consultaLocalizador(idODE);
			id_localizadorNP = localizadorNP.getIdentificador();
			if(logger.isDebugEnabled())
			logger.debug("Encontramos localizador con identificador[" + localizadorNP.getIdentificador() + "] usuario["
					+ localizadorNP.getIdUsuario() + "] MEC[" + localizadorNP.getMec() + "] path["
					+ localizadorNP.getPath() + "] URL[" + localizadorNP.getUrl() + "]");

			// empezamos a descomprimir el pif y guardar lo que nos devuelve
			// en un directorio temporal
			if(logger.isDebugEnabled())
			logger.debug("Comenzamos a descomprimir el PIF y guardar en un dir temporal.");

			String pathtemp = "";
			pathtemp = localizadorNP.getPath() + getPropertyValue("carpeta.temporal") + "/" + titulo;
			File ficheroZip = new File(pathtemp);
			(ficheroZip.getParentFile()).mkdirs();
			ficheroZip.createNewFile();
			ficheroZip.deleteOnExit();
			FileOutputStream fos = new FileOutputStream(ficheroZip);
			ficheroPIF.writeTo(fos);
			String pathtempDestino = localizadorNP.getPath();
			File destinoTemporal = new File(pathtempDestino);
			destinoTemporal.mkdirs();
			destinoTemporal.deleteOnExit();
			fos.close();
//			 La comprobacion se delega en el
			// empaquetador para hacer un 'importar inteligente'. El atributo
			// 'titulo' es el nombre del fichero proporcionado por la aplicación
			// cliente
			AnalizaArchivoVO resultadoAnalisis = null;
			String tipoFichero =null;
			try {
				resultadoAnalisis = this.getSrvFachadaAgregarService().analizarArchivo(
						pathtemp); 
				tipoFichero = resultadoAnalisis.getTipoArchivo();
				if(logger.isDebugEnabled()) logger.debug("El fichero importado " + titulo + " es de tipo " + tipoFichero);
				// Si el tipo de fichero es comprimido, lo descomprimimos en la localización definitiva
				if(ConstantesAgrega.FICHERO.equals(tipoFichero)) {
					UtilesFicheros.copiar(ficheroZip, destinoTemporal);
				} else {
					getZipDao().descomprimir(ficheroZip.getPath(), pathtempDestino);
				}
			} catch (Exception e) {
//				 borramos todo lo que hayamos hecho hasta ahora
				this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
				logger.error("Error analizando fichero [" + pathtemp + "], con nombre[" + titulo + "]", e);
				return new ResultadoOperacionVO(ERROR_DESCOMPRIMIENDO_FICHERO_ZIP,
						getPropertyValueI18n(ERROR_DESCOMPRIMIENDO_FICHERO_ZIP),idODE,new Long(0));
			} 
			/*
			 * En funcion del tipo de archivo hay que generar un imsmanifest.xml que recubra el contenido.
			 */
			if(ConstantesAgrega.FICHERO.equals(tipoFichero)) {
				this.getSrvFachadaAgregarService().generarManifest(localizadorNP.getIdentificador(), new String[]{titulo}, titulo, idioma);
			} else if(ConstantesAgrega.ARCHIVO.equals(tipoFichero)) {
				Collection<File> ficheros = FileUtils.listFiles(destinoTemporal, null, true);
				if(ficheros!=null ) {
					java.io.File[] ficherosArray = new java.io.File[ficheros.size()];
					if(logger.isDebugEnabled()) logger.debug("Se han encontrado " + ficheros.size() + "dentro del zip " + titulo);
					ficherosArray = (java.io.File[])ficheros.toArray(ficherosArray);
					String[] rutas = new String[ficheros.size()];
					String rutaAReemplazar = destinoTemporal.getPath().replaceAll("\\\\", "/");
					if(logger.isDebugEnabled()) logger.debug("Ruta a reemplazar con / : " + rutaAReemplazar);
					for(int i=0;i<ficherosArray.length;i++) {
						String ruta = ficherosArray[i].getPath().replaceAll(destinoTemporal.getPath(), "");
						if(ruta.startsWith("/")) ruta = ruta.substring(1);
						if(logger.isDebugEnabled()) logger.debug("Ruta " + ficherosArray[i].getPath() + " cambiada a " +ruta);
						rutas[i]=ruta;
					}
					getSrvFachadaAgregarService().generarManifest(localizadorNP.getIdentificador(), rutas, rutas[0], idioma);
				} else {
					logger.error("Se ha intentado importar un ZIP vacio");
				}
			} else if(ConstantesAgrega.RCP.equals(tipoFichero)) {
				this.getSrvFachadaAgregarService().generarManifestRCP(localizadorNP.getIdentificador(), idioma);
			} // PARA ConstantesAgrega.CA no hace falta hacer nada

			// copiar los esquemas por si acaso no los trajese
			try {
				this.copiarEsquemas(pathtempDestino);
			} catch (Exception e1) {
				logger.error("No se pudieron copiar los esquemas al importar un pif: ", e1);
				// borramos todo lo que hayamos hecho hasta ahora
				this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
				return new ResultadoOperacionVO(ERROR_COPIANDO_ESQUEMAS, getPropertyValueI18n(ERROR_COPIANDO_ESQUEMAS),idODE,new Long(0));
			}

			Long consumoODE = new Long(0);
			if (chequeaCuota)  // si atendemos al chequeo del espacio en disco usado.
			{
			//Antes de seguir vemos si el ODE no supera el espacio de su cuota. Ya tenemos descomprimido el ODE en disco y podemos ver si se ha pasado
				consumoODE = this.getSrvLocalizadorService().consultaEspacioLocalizador(id_localizadorNP);
				long cuotaConsumida = calculaCuotaConsumidaUsuario(idUsuario);
				long cuotaUsuario = LdapUserDetailsUtils.getCuota().longValue();
				if(logger.isDebugEnabled()) logger.debug("El espacio consumido en disco por el ODE["+idODE+"] con localizador["+localizadorNP.getPath()+"]del usuario["+idUsuario+"] es de ["+consumoODE+"] bytes");
				
				if(logger.isDebugEnabled()) logger.debug("Los ODEs del usuario["+idUsuario+"] ocupan un total de ["+cuotaConsumida+"] y tiene una cuota de ["+cuotaUsuario+"] bytes");
				if ((cuotaConsumida + consumoODE) > cuotaUsuario) // nos hemos pasado de cuota, le damos la vuelta al asunto y salimos
				{
					logger.error("Error creando ODE. La cuota del usuario["+idUsuario+"]["+cuotaUsuario+"]bytes se ha superado con el ODE["+idODE+"]["+consumoODE+"]bytes en ["+(cuotaConsumida - cuotaUsuario)+"]bytes");
					// borramos todo lo que hayamos hecho hasta ahora
					this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
					return new ResultadoOperacionVO(ERROR_EXCEDER,getPropertyValueI18n(ERROR_EXCEDER) ,idODE,new Long(consumoODE));
				}
				logger.info("Creando ODE desde PIF con id["+idODE+"] tamanio["+consumoODE+"] para usuario["+idUsuario+"] con cuota consumida["+cuotaConsumida+"] y cuota total["+cuotaUsuario+"]");
			}

			// validador
			SrvValidadorService validadorService = this.getSrvValidadorService();
			// reaalizamos una validacion ligera en lugar de carga ode.
			ValidaVO valid = validadorService.obtenervalidacionLigera(localizadorNP.getPath(), "CA");
			logger.info("Validando el ODE a importar[" + localizadorNP.getPath() + "] : Valido["
					+ valid.getEsValidoManifest().booleanValue() + "]");

			// la hora de testear cuidado con el validador
			if (valid.getEsValidoManifest().booleanValue()) {
				// Extraemos el manifest del ODE.
				File extraeSubmanifest = new File(localizadorNP.getPath(), MANIFEST_NAME);
				Manifest imsmanifest = this.getScormDao().parsearODEEager(extraeSubmanifest);
				if(logger.isDebugEnabled())
				logger.debug("Validado el ODE [" + localizadorNP.getPath() + "]!!");
				
				String resultadoVocab = this.comprobarVocabulariosYFechas(imsmanifest);
				
				// Por ultimo, en caso de que todo haya ido bien, tenemos que
				// recubrir el MEC y el identificador del
				// manifest que tenga este ODE con el identificador UUID que
				// utilizamos en la plataforma, ya que este
				// ODE esta en estado CREADO => esta en el taller. Para ello
				// vamos autilizar el mismo metodo que ya
				// existe y hace todo esto con el identificador MEC en el
				// momento de publicar, pero le vamos a pasar
				// el identificador de taller (el UUID)

				cambiaUUIDxMEC(idODE, localizadorNP.getPath(), imsmanifest, AgregaPropertiesImpl.getInstance()
						.getProperty(AgregaProperties.CATALOGO_AGREGA)); // utilizamos
																			// el
																			// catalogo
																			// agrega
				// imsmanifest.
				// si el ode tiene lomes el título lo cambiamos al que trajese
				// con el lomes

				// manifest en la posicion exacta
				ManifestAgrega manAgrega = new ManifestAgrega(imsmanifest);
				String identifiadorManifest = manAgrega.getManifest().getIdentifier();
				// Lom lom = manAgrega.obtenerLom(idODE, null);
				Lom lom = manAgrega.obtenerLom(identifiadorManifest, null);
				if (lom != null) {
					LomAgrega lomAgrega = new LomAgrega(lom);
					idioma=lomAgrega.getMetaMetadataAgrega().getIdioma();
					titulo = lomAgrega.getGeneralAgrega().getTitulo(idioma);

				} else {
					logger.warn("El Lom del manifest " + idODE
							+ " no tiene objeto general, el nombre del fichero será el titulo del ODE");
				}

				// Creamos la transicion
				EstadoDao estadoDao = this.getEstadoDao();
				TransicionDao transicionDao = this.getTransicionDao();
				Date fecha = new Date(System.currentTimeMillis());
				Transicion t = transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, idUsuario,// el usuario de creacion es el mismo que me pasan
						new Long(fecha.getTime()),Boolean.FALSE, null, estadoDao.obtenEstadoPorNombre(CREACION));
				if(resultadoVocab.equals(""))
					return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,consumoODE);
				else
					return new ResultadoOperacionVO(VOCAB_BORRADOS, resultadoVocab,idODE,consumoODE);

			}// si no es válido rollback
			else {
				// borrar la info
				// borramos todo lo que hayamos hecho hasta ahora
				this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);

				// Lanzamos una excepción para que haga el rollback de las bbdd
				// Ahora no lanzamos la excepcion pq no hay nada que deshacer
				// String errorValidacion="";
				// if (valid.getErrores() != null && valid.getErrores().length
				// >0)
				// {
				// errorValidacion = valid.getResultadoValidacion();
				// // errorValidacion = ""+
				// getPropertyValueI18n(LINEA_ERROR)+"["+valid.getErrores()[0].getLinea()+"]
				// "+
				// //
				// getPropertyValueI18n(COLUMNA_ERROR)+"["+valid.getErrores()[0].getColumna()+"]
				// "+
				// //
				// getPropertyValueI18n(TEXTO_ERROR)+"["+valid.getErrores()[0].getMensaje()+"]";
				// }
				logger.error("Atención: no se ha validado el ODE [" + localizadorNP.getPath()
						+ "]correctamente. No se ha creado el Pif, error: " + valid.getResultadoValidacion() + "]");
				return new ResultadoOperacionVO(this.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,new Long(0));
			}
		}// try
		catch (Exception e) {
			logger.error("Fallo creando PIF con fichero[" + titulo + "] idusuario[" + idUsuario + "] comentarios["
					+ comentarios + "] titulo[" + titulo + "] )", e);
			// borramos todo lo que hayamos hecho hasta ahora
			this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
			throw new Exception(e);
		}
	}

	/**
	 * Este metodo nos da las transiciones de los ODEs compartidos
	 * 
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado compartido.
	 * @throws Exception
	 * 
	 */

	protected TransicionAutorVO[] handleObtenODESCompartidos() throws Exception {
		
		
		TransicionDao transicion = this.getTransicionDao();
		EstadoCompartidoCriteria criterio=new EstadoCompartidoCriteria();
		EstadoCompartidoCriteria criterio2=new EstadoCompartidoCriteria();
		criterio2.setCompartido(new Boolean(true));
		criterio2.setEstadoTransitado(null);
		criterio2.setEstadoActual(this.getEstadoDao().obtenEstadoPorNombre(CREACION));

		criterio.setCompartido(new Boolean(true));
		criterio.setEstadoTransitado(null);
		criterio.setEstadoActual(this.getEstadoDao().obtenEstadoPorNombre(RECHAZADO));

		
		List transiciones = transicion.buscarOdesPorEstadoCompartido(TransicionDao.TRANSFORM_TRANSICIONAUTORVO, criterio2);
		List transiciones2=transicion.buscarOdesPorEstadoCompartido(TransicionDao.TRANSFORM_TRANSICIONAUTORVO, criterio);
		transiciones.addAll(transiciones2);
		logger.info("Obtenidos " + transiciones.size() + " odes en estado "
				+ SrvPublicacionServiceImpl.CREACION+" y "+SrvPublicacionServiceImpl.RECHAZADO);
		return (TransicionAutorVO[]) transiciones.toArray(new TransicionAutorVO[transiciones.size()]);

	} 

	/*
	 * Este metodo recibe la ultima transicion del ODE y calcula si para el ODE al que pertenece la transicion se ha superado la cuota de usuario.
	 * Un usuario excede su cuota si el espacio consumido por sus ODEs en estado CREADO y RECHAZADO supera su asignación de espacio en disco.
	 * */
	private boolean excedeCuotaUsuario(Transicion transicion) throws Exception
	{
//		Para comprobar si el ODE al que pertenece la transición ha superado el espacio asignado al usuario, tenemos que ver el espacio consumido
//		por el usuario actualmente y el espacio que consume el ODE al que pertenece la transicion.
		
//		Primero considero el estado en el que esta el ODE. Si no esta CREADO o RECHAZADO, no me preocupa
		if (!transicion.getEstadoActual().getNombre().equals(SrvPublicacionServiceImpl.CREACION) ||
				!transicion.getEstadoActual().getNombre().equals(SrvPublicacionServiceImpl.RECHAZADO))
				return false; // si no esta en estado CREADO ni RECHAZADO, no "pesa" a la hora de calcular el espacio consumido. No excedemos la cuota
//		Calculamos el consumo de la cuota
		long cuotaConsumida = this.calculaCuotaConsumidaUsuario(transicion.getIdUsuarioCreacion());
//		Calculamos el consumo actual del ODE concreto.
		long consumoODE = this.getSrvLocalizadorService().calculaEspacioLocalizador(transicion.getIdODE()).longValue();
//		Calculamos el consumo anterior del ODE
		long consumoAnterior =this.getSrvLocalizadorService().consultaEspacioLocalizador(transicion.getIdODE()).longValue();
		if (logger.isDebugEnabled())logger.debug("Calculando exceso de cuota para usuario["+transicion.getIdUsuarioCreacion()+"] ode["+transicion.getIdODE()+"]: cuota consumida["+cuotaConsumida+"], consumo ODE["+consumoODE+"] consumo anterior["+consumoAnterior+"]");
//		Si el consumo acumulado, menos lo que ocupaba antes el ode, más lo que ocupa ahora es mayor que lo disponible, no cabe.
		return ((cuotaConsumida-consumoAnterior)+consumoODE) > LdapUserDetailsUtils.getCuota().longValue();
	}
	
	/**
	 * Metodo para descompartir un ODE que esta compartido
	 * 
	 * @param idODE
	 *            El identifcador que se quiere descompartir.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleCompartirODE(String idODE) throws Exception {

		try {
			logger.debug("Hemos entrado en compartirODE con identificador:["+idODE+"]");
			EstadoVO actual=this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			logger.debug("El estadoVO que obtenemos con ese ODE es: clave ["+actual.getClave()+"], nombre["+actual.getClave());
			logger.debug("Las transiciones valida son["+SrvPublicacionServiceImpl.CREACION+" y " +SrvPublicacionServiceImpl.RECHAZADO);
			if(((actual.getClave()).equals(SrvPublicacionServiceImpl.CREACION))||((actual.getClave()).equals(SrvPublicacionServiceImpl.RECHAZADO))){
				Transicion transicion = handleObtenerUltimaTransicion(idODE);;
				transicion.setCompartido(new Boolean(true));
				this.getTransicionDao().update(transicion);
				logger.info("Se ha compartido bien el ODE con identificador" + idODE + "]");
				
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
			}else{
				logger.error("El ODE para compartir con identificador ["+ idODE+"] no esta en estado [" + SrvPublicacionServiceImpl.CREACION + "] o [" + SrvPublicacionServiceImpl.RECHAZADO + "] esta en estado ["
						+ actual.getClave() + "]  )");
				
				return new ResultadoOperacionVO(NO_ESTADO_VALIDO, getPropertyValueI18n(NO_ESTADO_VALIDO),idODE,new Long(0));
			}
		} catch (RuntimeException e) {
			
			logger.error("Fallo compartiendo ODE con identificador[" + idODE + "] )", e);
			throw new Exception(e);
		}
	}

	/**
	 * Metodo para compartir un ODE que esta compartido
	 * 
	 * @param idODE
	 *            El identifcador que se quiere compartir.
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleDescompartirODE(String idODE) throws Exception {
		try {
			logger.debug("Hemos entrado en descompartirODE con identificador:["+idODE+"]");
			EstadoVO actual=this.obtenEstadoPorIdODE(idODE, LdapUserDetailsUtils.getIdioma());
			logger.debug("El estadoVO que obtenemos con ese ODE es: clave ["+actual.getClave()+"], nombre["+actual.getClave());
			logger.debug("Las transiciones valida son["+SrvPublicacionServiceImpl.CREACION+" y " +SrvPublicacionServiceImpl.RECHAZADO);
			if(((actual.getClave()).equals(SrvPublicacionServiceImpl.CREACION))||((actual.getClave()).equals(SrvPublicacionServiceImpl.RECHAZADO))){
				Transicion transicion = handleObtenerUltimaTransicion(idODE);
				transicion.setCompartido(new Boolean(false));
				this.getTransicionDao().update(transicion);
				logger.info("Se ha descompartido bien el ODE con identificador" + idODE + "]");
				
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,new Long(0));
			}else{
				logger.error("El ODE para descompartir con identificador ["+ idODE+"] no esta en estado [" + SrvPublicacionServiceImpl.CREACION + "] o [" + SrvPublicacionServiceImpl.RECHAZADO + "] esta en estado ["
						+ actual.getClave() + "]  )");
				
				return new ResultadoOperacionVO(NO_ESTADO_VALIDO, getPropertyValueI18n(NO_ESTADO_VALIDO),idODE,new Long(0));
			}
		} catch (RuntimeException e) {
			
			logger.error("Fallo descompartiendo ODE con identificador[" + idODE + "] )", e);
			throw new Exception(e);
		}
		
	}

	/**
	 * Metodo para crear ode desde una URL dada.
	 * 
	 * @param url
	 *            URL donde está el ode
	 * @param idUsuario
	 * 				Identificador del usuario
	 * @param comentarios
	 * 				Comentarios introducidos
	 * @param titulo
	 * 				Titulo del ode
	 * @param idioma	
	 * 				Idioma del ode
	 * @param idiomaDestinatario
	 * 				Idioma del destinatario del ode
	 * @param tipo
	 * 				Tipo de recurso
	 * @return se retorna un VO con el error que se ha producido en el caso de
	 *         detectarse algun problema.
	 * @throws Exception
	 * 
	 */
	protected ResultadoOperacionVO handleCrearDesdeURL(String url,
			String idUsuario, String comentarios, String titulo, String idioma, String idiomaDestinatario, String tipo) throws Exception {
		String id_localizadorNP = "";
		try {
			// utilizar un id generado por la clase de soporte que genera un
			// uuid
			String idODE = es.pode.soporte.uuid.PodeUUIDGenerator
					.getOdeUUID(String.valueOf(System.currentTimeMillis()));
			// creacion
			this.getSrvLocalizadorService().crearLocalizadorNoPublicado(idUsuario, idODE);
			logger.info("Creando ODE utilizando url"+url+"], identificador[" + idODE + "], idUsuario[" + idUsuario
					+ "], comentarios[" + comentarios + "] y titulo[" + titulo + "]");

			SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
			LocalizadorVO localizadorNP = localizadorService.consultaLocalizador(idODE);
			id_localizadorNP = localizadorNP.getIdentificador();
			if(logger.isDebugEnabled())
			logger.debug("Encontramos localizador con identificador[" + id_localizadorNP + "] usuario["
					+ localizadorNP.getIdUsuario() + "] MEC[" + localizadorNP.getMec() + "] path["
					+ localizadorNP.getPath() + "] URL[" + localizadorNP.getUrl() + "]");
			
			this.getSrvFachadaAgregarService().generarManifestLom(id_localizadorNP, null, url, idioma, titulo, comentarios,idiomaDestinatario, tipo);

			Long consumoODE = 0L;
			//Antes de seguir vemos si el ODE no supera el espacio de su cuota. Ya tenemos descomprimido el ODE en disco y podemos ver si se ha pasado
			consumoODE = this.getSrvLocalizadorService().consultaEspacioLocalizador(id_localizadorNP);
			long cuotaConsumida = calculaCuotaConsumidaUsuario(idUsuario);
			long cuotaUsuario = LdapUserDetailsUtils.getCuota().longValue();
			if(logger.isDebugEnabled()) logger.debug("El espacio consumido en disco por el ODE["+idODE+"] con localizador["+localizadorNP.getPath()+"]del usuario["+idUsuario+"] es de ["+consumoODE+"] bytes");
			
			if(logger.isDebugEnabled()) logger.debug("Los ODEs del usuario["+idUsuario+"] ocupan un total de ["+cuotaConsumida+"] y tiene una cuota de ["+cuotaUsuario+"] bytes");
			if ((cuotaConsumida + consumoODE) > cuotaUsuario) // nos hemos pasado de cuota, le damos la vuelta al asunto y salimos
			{
				logger.error("Error creando ODE. La cuota del usuario["+idUsuario+"]["+cuotaUsuario+"]bytes se ha superado con el ODE["+idODE+"]["+consumoODE+"]bytes en ["+(cuotaConsumida - cuotaUsuario)+"]bytes");
				// borramos todo lo que hayamos hecho hasta ahora
				this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
				return new ResultadoOperacionVO(ERROR_EXCEDER,getPropertyValueI18n(ERROR_EXCEDER) ,idODE,Long.valueOf(consumoODE));
			}
			logger.info("Creando ODE desde PIF con id["+idODE+"] tamanio["+consumoODE+"] para usuario["+idUsuario+"] con cuota consumida["+cuotaConsumida+"] y cuota total["+cuotaUsuario+"]");

			// validador
			SrvValidadorService validadorService = this.getSrvValidadorService();
			// reaalizamos una validacion ligera en lugar de carga ode.
			ValidaVO valid = validadorService.obtenervalidacionLigera(localizadorNP.getPath(), "CA");
			logger.info("Validando el ODE a importar[" + localizadorNP.getPath() + "] : Valido["
					+ valid.getEsValidoManifest().booleanValue() + "]");

			// la hora de testear cuidado con el validador
			if (valid.getEsValidoManifest().booleanValue()) {
				if(logger.isDebugEnabled())
				logger.debug("Validado el ODE [" + localizadorNP.getPath() + "]!!");

				// Creamos la transicion
				EstadoDao estadoDao = this.getEstadoDao();
				TransicionDao transicionDao = this.getTransicionDao();
				Date fecha = new Date(System.currentTimeMillis());
				transicionDao.create(DateManager.dateToCalendar(fecha), comentarios, idODE, idUsuario, titulo, idUsuario,// el usuario de creacion es el mismo que me pasan
						Long.valueOf(fecha.getTime()),Boolean.FALSE, null, estadoDao.obtenEstadoPorNombre(CREACION));
				return new ResultadoOperacionVO(SIN_ERRORES, getPropertyValueI18n(SIN_ERRORES),idODE,consumoODE);

			}// si no es válido rollback
			else {
				// borrar la info
				// borramos todo lo que hayamos hecho hasta ahora
				this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
				logger.error("Atención: no se ha validado el ODE [" + localizadorNP.getPath()
						+ "]correctamente. No se ha creado el Pif, error: " + valid.getResultadoValidacion() + "]");
				return new ResultadoOperacionVO(SrvPublicacionServiceImpl.ERROR_DE_VALIDACION, valid.getResultadoValidacion(),idODE,Long.valueOf(0));
			}
		}// try
		catch (Exception e) {
			logger.error("Fallo creando ODE con url[" + url +"] titulo["+titulo+ "] idusuario[" + idUsuario + "] comentarios["
					+ comentarios+"] )", e);
			// borramos todo lo que hayamos hecho hasta ahora
			this.getSrvLocalizadorService().eliminarLocalizador(id_localizadorNP);
			throw new Exception(e);
		}
	}

	
	private String comprobarVocabulariosYFechas(Manifest manifest) throws Exception{
		logger.debug("AOV: Recogiendo vocabularios controlados...");
		String vocabControlados = getPropertyValue("vocabulariosControlados");
//		String vocabControlados = "1.3,1.7,1.8,2.2,2.3.1,3.2.1,3.4,4.1,4.4.1.1,4.4.1.2,5.1,5.2,5.3,5.4,5.5,5.6,5.8,5.11,5.12,6.1,6.2,6.4.1,7.1,9.1";
		String[] vocabularios = vocabControlados.split(",");
		logger.debug("AOV: Vamos a obtener los valores de los vocabularios");
		
		SrvVocabulariosControladosService vocabSrv= this.getSrvVocabulariosControladosService();
		VocabularioVO[] vocabVO = vocabSrv.obtenerCombos(vocabularios, "en");
		
		/********vocabularios de general********/
		VocabularioVO idiomaV = vocabVO[0];//1.3
		ArrayList aIdiomaV = this.obtenValoresVocabulario(idiomaV);
		
		VocabularioVO estructuraV = vocabVO[1];//1.7
		ArrayList aEstructuraV = this.obtenValoresVocabulario(estructuraV);
		
		VocabularioVO nivelAgregacionV = vocabVO[2];//1.8
		ArrayList aNivelAgregacionV = this.obtenValoresVocabulario(nivelAgregacionV);
		
		/********vocabularios de ciclo de vida********/
		VocabularioVO estadoV = vocabVO[3];//2.2
		ArrayList aEstadoV = this.obtenValoresVocabulario(estadoV);
		
		VocabularioVO tipoContribucionV = vocabVO[4];//2.3.1
		ArrayList aTipoContribucionV = this.obtenValoresVocabulario(tipoContribucionV);
		
		/********vocabularios de meta-metadatos********/
		VocabularioVO tipoContribucionMetaV = vocabVO[5];//3.2.1
		ArrayList aTipoContribucionMetaV = this.obtenValoresVocabulario(tipoContribucionMetaV);
		
		VocabularioVO idiomaCatalogacionV = vocabVO[6];//3.4
		ArrayList aIdiomaCatalogacionV = this.obtenValoresVocabulario(idiomaCatalogacionV);
		
		/********vocabularios de tecnica********/
		VocabularioVO formatoV = vocabVO[7];//4.1
		ArrayList aFormatoV = this.obtenValoresVocabulario(formatoV);
		
		VocabularioVO tipoRequisitoV = vocabVO[8];//4.4.1.1
		ArrayList aTipoRequisitoV = this.obtenValoresVocabulario(tipoRequisitoV);
		
		VocabularioVO nombreRequisitoV = vocabVO[9];//4.4.1.2
		ArrayList aNombreRequisitosV = this.obtenValoresVocabulario(nombreRequisitoV);
		
		/********vocabularios de uso educativo********/
		VocabularioVO tipoInteractividadV = vocabVO[10];//5.1
		ArrayList aTipoInteractividadV = this.obtenValoresVocabulario(tipoInteractividadV);
		
		VocabularioVO tipoRecursoV = vocabVO[11];//5.2
		ArrayList aTipoRecursoV = this.obtenValoresVocabulario(tipoRecursoV);
		
		VocabularioVO nivelInteractividadV = vocabVO[12];//5.3
		ArrayList aNivelInteractividadV = this.obtenValoresVocabulario(nivelInteractividadV);
		
		VocabularioVO densidadSemanticaV = vocabVO[13];//5.4
		ArrayList aDensidadSemanticaV = this.obtenValoresVocabulario(densidadSemanticaV);
		
		VocabularioVO destinatarioV = vocabVO[14];//5.5
		ArrayList aDestinatarioV = this.obtenValoresVocabulario(destinatarioV);
		
		VocabularioVO contextoV = vocabVO[15];//5.6
		ArrayList aContextoV = this.obtenValoresVocabulario(contextoV);
		
		VocabularioVO dificultadV = vocabVO[16];//5.8
		ArrayList aDificultadV = this.obtenValoresVocabulario(dificultadV);
		
		VocabularioVO idiomaDestinatarioV = vocabVO[17];//5.11
		ArrayList aIdiomaDestinatarioV = this.obtenValoresVocabulario(idiomaDestinatarioV);
		
		VocabularioVO procesoCognitivoV = vocabVO[18];//5.12
		ArrayList aProcesoCognitivoV = this.obtenValoresVocabulario(procesoCognitivoV);
		
		/********vocabularios de derechos********/
		VocabularioVO costeV = vocabVO[19];//6.1
		ArrayList aCosteV = this.obtenValoresVocabulario(costeV);
		
		VocabularioVO derechosAutorV = vocabVO[20];//6.2
		ArrayList aDerechosAutorV = this.obtenValoresVocabulario(derechosAutorV);
		
		VocabularioVO tipoAccesoV = vocabVO[21];//6.4.1
		ArrayList aTipoAccesoV = this.obtenValoresVocabulario(tipoAccesoV);
		
		/********vocabularios de relacion********/
		VocabularioVO tipoRelacionV = vocabVO[22];//7.1
		ArrayList aTipoRelacionV = this.obtenValoresVocabulario(tipoRelacionV);
		
		/********vocabularios de clasificacion********/
		VocabularioVO propositoV = vocabVO[23];//9.1
		ArrayList aPropositoV = this.obtenValoresVocabulario(propositoV);
		
		StringBuffer resultado = new StringBuffer("");
		
		
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

		HashMap lomesMap = manifestAgrega.recuperarLomesMap();
		
		Set padreLomes = lomesMap.keySet();
		Object[] padresLomesArray= padreLomes.toArray();
		
		for(int i=0; i< padresLomesArray.length;i++){
			boolean haCambiado = false;
			String idPadre = (String) padresLomesArray[i];
			Lom lomes = (Lom) lomesMap.get(padresLomesArray[i]);
			LomAgrega lomAgrega = new LomAgrega(lomes);
			
//			/**********************General**********************/
			logger.debug("Comprobando campos de la categoría General");
			GeneralAgrega generalAgrega = lomAgrega.getGeneralAgrega();
			List idiomas = generalAgrega.getIdiomasAv();

			boolean cambioIdiomas = false;
			ArrayList new_Idiomas= new ArrayList();
			for(int k = 0; k < idiomas.size();k++){
				String idioma = (String) idiomas.get(k);
				if(idioma !=null && !aIdiomaV.contains(idioma)){
//				if(idioma !=null){
					logger.debug("Valor erroneo de idioma: " + idioma + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
							 .append(getPropertyValueI18n("vocabularios.idioma"))
							 .append(idioma).append(SPLITTER);
					haCambiado = true;
					cambioIdiomas = true;
				}
				else{
					new_Idiomas.add(idioma);
				}
			}
			if(cambioIdiomas)
				generalAgrega.setIdiomasAv(new_Idiomas);
			
			String estructura = generalAgrega.getEstructuraAv();
			if(estructura !=null && !aEstructuraV.contains(estructura)){
//			if(estructura !=null){
				logger.debug("Valor erroneo de estructura: " + estructura +". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
						 .append(getPropertyValueI18n("vocabularios.estructura"))
						 .append(estructura).append(SPLITTER);

				generalAgrega.setEstructuraAv(null);
				haCambiado = true;			
				
			}
			
			String nivelAgregacion = generalAgrega.getNivelDeAgregacionAv();
			if(nivelAgregacion !=null && !aNivelAgregacionV.contains(nivelAgregacion)){
//			if(nivelAgregacion !=null){
				logger.debug("Valor erroneo de nivel de agregacion: " + nivelAgregacion +". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
						 .append(getPropertyValueI18n("vocabularios.nivelAgregacion"))
						 .append(nivelAgregacion).append(SPLITTER);
				generalAgrega.setNivelDeAgregacionAv(null);
				haCambiado = true;
			}
			
//			/**********************Ciclo de vida**********************/
			logger.debug("Comprobando campos de la categoría Ciclo de vida");
			LifeCycleAgrega cicloAgrega = lomAgrega.getLifeCycleAgrega();
			
			String estado = cicloAgrega.getEstatusAv();
			if(estado !=null && !aEstadoV.contains(estado)){
//			if(estado !=null){
				logger.debug("Valor erroneo de estado: " + estado +". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
				 		 .append(getPropertyValueI18n("vocabularios.estado"))
				 		 .append(estado).append(SPLITTER);
				cicloAgrega.setEstatusAv(null);
				haCambiado = true;
			}
			
			ArrayList<ContribucionAgrega> contribuciones = cicloAgrega.getContribucionesAv();
			ArrayList<ContribucionAgrega> new_contribuciones= new ArrayList<ContribucionAgrega>();
			boolean cambioContrib = false;
			for(int j = 0; j < contribuciones.size(); j++){
				ContribucionAgrega contribucion = contribuciones.get(j);
				String tipo = contribucion.getTipo();
//				if(tipo !=null){
				if(tipo !=null && !aTipoContribucionV.contains(tipo)){
					logger.debug("Valor erroneo de tipo de contribucion: " + tipo + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
					 		 .append(getPropertyValueI18n("vocabularios.tipoContribCiclo"))
					 		 .append(tipo).append(SPLITTER);
					contribucion.setTipo(null);
//					contribuciones.set(j, contribucion);
					haCambiado = true;
					cambioContrib = true;
				}
				
				FechaAgrega fecha = contribucion.getFecha();
				if(fecha!=null && fecha.getFecha()!=null){
					String sFecha = fecha.getFecha();
					boolean correcta = this.comprobarFecha(sFecha);

					if(!correcta){
						logger.debug("Valor erroneo de fecha: " + sFecha + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
				 		 		 .append(getPropertyValueI18n("vocabularios.fechaCiclo"))
				 		 		 .append(sFecha).append(SPLITTER);
						fecha.setFecha(null);
						contribucion.setTipo(null);
//						contribuciones.set(j, contribucion);
						haCambiado = true;
						cambioContrib = true;
					}
					
				}
				
				if((contribucion.getEntidad()!=null && contribucion.getEntidad().size()>0)||
					(contribucion.getTipo()!=null && !contribucion.getTipo().equals("")) ||
					(contribucion.getFecha()!=null && contribucion.getFecha().getFecha()!=null && !contribucion.getFecha().getFecha().equals("")) ||
					(contribucion.getFecha()!=null && contribucion.getFecha().getDescripciones()!=null && contribucion.getFecha().getDescripciones().size()>0)){
					new_contribuciones.add(contribucion);
				}
			}
			if(cambioContrib){
				cicloAgrega.setContribucionesAv(new_contribuciones);
			}
			
//			/**********************Meta-metadatos**********************/
			logger.debug("Comprobando campos de la categoría Meta-metadatos");
			MetaMetadataAgrega metadatosAgrega =lomAgrega.getMetaMetadataAgrega();
			String idiomaCatalogacion = metadatosAgrega.getIdiomaAv();
//			if(idiomaCatalogacion !=null){
			if(idiomaCatalogacion !=null && !aIdiomaCatalogacionV.contains(idiomaCatalogacion)){
				logger.debug("Valor erroneo de idioma de catalogacion: " + idiomaCatalogacion + ". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
		 		 		 .append(getPropertyValueI18n("vocabularios.idiomaCatalogacion"))
		 		 		 .append(idiomaCatalogacion).append(SPLITTER);
				metadatosAgrega.setIdiomasAv(null);
				haCambiado = true;
			}
			
			ArrayList<ContribucionAgrega> contribucionesMeta = metadatosAgrega.getContribucionesAv();
			ArrayList<ContribucionAgrega> new_contribucionesMeta= new ArrayList<ContribucionAgrega>();
			boolean cambioContribMeta = false;
			for(int j = 0; j < contribucionesMeta.size(); j++){
				ContribucionAgrega contribucionMeta = contribucionesMeta.get(j);
				
				String tipo = contribucionMeta.getTipo();
//				if(tipo !=null){
				if(tipo !=null && !aTipoContribucionMetaV.contains(tipo)){
					logger.debug("Valor erroneo de tipo de contribucion: " + tipo + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
			 		 		 .append(getPropertyValueI18n("vocabularios.tipoContribMeta"))
			 		 		 .append(tipo).append(SPLITTER);
					contribucionMeta.setTipo(null);
//					contribucionesMeta.set(j, contribucionMeta);
					haCambiado = true;
					cambioContribMeta = true;
				}
				
				FechaAgrega fecha = contribucionMeta.getFecha();
				if(fecha!=null && fecha.getFecha()!=null){
					String sFecha = fecha.getFecha();
					boolean correcta = this.comprobarFecha(sFecha);

					if(!correcta){
						logger.debug("Valor erroneo de fecha: " + sFecha + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
		 		 		 		 .append(getPropertyValueI18n("vocabularios.fechaMeta"))
		 		 		 		 .append(sFecha).append(SPLITTER);
						fecha.setFecha(null);
						contribucionMeta.setTipo(null);
//						contribucionesMeta.set(j, contribucionMeta);
						haCambiado = true;
						cambioContribMeta = true;
					}
					
				}
				if((contribucionMeta.getEntidad()!=null && contribucionMeta.getEntidad().size()>0)||
						(contribucionMeta.getTipo()!=null && !contribucionMeta.getTipo().equals("")) ||
						(contribucionMeta.getFecha()!=null && contribucionMeta.getFecha().getFecha()!=null && !contribucionMeta.getFecha().getFecha().equals("")) ||
						(contribucionMeta.getFecha()!=null && contribucionMeta.getFecha().getDescripciones()!=null && contribucionMeta.getFecha().getDescripciones().size()>0)){
						new_contribucionesMeta.add(contribucionMeta);
					}
				}
				if(cambioContribMeta){
					cicloAgrega.setContribucionesAv(new_contribucionesMeta);
				}			
		
			/**********************Tecnica**********************/
			logger.debug("Comprobando campos de la categoría Tecnica");
			TechnicalAgrega tecnicaAgrega = lomAgrega.getTechnicalAgrega();
			
			ArrayList  formatos = tecnicaAgrega.getFormatosAv();
			boolean cambioFormatos = false;
			ArrayList new_formatos = new ArrayList();
			for(int j = 0; j < formatos.size();j++){
				String formato = (String) formatos.get(j);
				if(formato !=null && !aFormatoV.contains(formato)){
//				if(formato !=null){
					logger.debug("Valor erroneo de formato: " + formato + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
							 .append(getPropertyValueI18n("vocabularios.formato"))
							 .append(formato).append(SPLITTER);
					haCambiado = true;
					cambioFormatos = true;
				}
				else{
					new_formatos.add(formato);
				}
			}
			if(cambioFormatos)
				tecnicaAgrega.setFormatosAv(new_formatos);
				
			ArrayList requisitos = tecnicaAgrega.getRequisitosAv();
			boolean cambioRequisitos = false;
			for(int j = 0; j < requisitos.size();j++){
				ArrayList<RequisitoAgrega> orComposites = (ArrayList<RequisitoAgrega>) requisitos.get(j);
				boolean cambioOrComposites = true;
				for(int k = 0; k < orComposites.size(); k++){
					RequisitoAgrega requisito = orComposites.get(k);
					String tipo = requisito.getTipo();
					boolean cambioRequisito =false;
					if(tipo !=null && !aTipoRequisitoV.contains(tipo)){
//					if(tipo !=null){
						logger.debug("Valor erroneo de tipo requisito: " + tipo + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
		 		 		 		 .append(getPropertyValueI18n("vocabularios.tipoRequisito"))
		 		 		 		 .append(tipo).append(SPLITTER);
						requisito.setTipo(null);
						haCambiado = true;
						cambioRequisitos = true;
						cambioOrComposites =true;
						cambioRequisito= true;
					}
					
					String nombre = requisito.getNombre();
					if(nombre !=null && !aNombreRequisitosV.contains(nombre)){
//					if(nombre !=null){
						logger.debug("Valor erroneo de nombre de requisito: " + nombre + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
		 		 		 		 .append(getPropertyValueI18n("vocabularios.nombreRequisito"))
		 		 		 		 .append(nombre).append(SPLITTER);
						requisito.setNombre(null);
						haCambiado = true;
						cambioRequisitos = true;
						cambioOrComposites = true;
						cambioRequisito = true;
					}
					if(cambioRequisito)
						orComposites.set(k, requisito);
						
					
				}
				if(cambioOrComposites)
					requisitos.set(j, orComposites);
			}
			if(cambioRequisitos)
				tecnicaAgrega.setRequisitosAv(requisitos);
			
			/**********************Uso educativo**********************/
			logger.debug("Comprobando campos de la categoría Uso educativo");
			ArrayList<EducationalAgrega> usosEduAgrega = lomAgrega.getEducationalsAgrega();
			ArrayList<EducationalAgrega> new_usosEducativos= new ArrayList<EducationalAgrega>();
			boolean cambioUsosEdu = false;
			for(int j = 0; j < usosEduAgrega.size();j++){
				EducationalAgrega usoEducativo = usosEduAgrega.get(j);
				//***********tipoInteractividad***********
				String tipoInteractividad = usoEducativo.getTipoDeInteractividadAv();
				if(tipoInteractividad !=null && !aTipoInteractividadV.contains(tipoInteractividad)){
//				if(tipoInteractividad !=null){
					logger.debug("Valor erroneo de tipo de interactividad: " + tipoInteractividad + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
							 .append(getPropertyValueI18n("vocabularios.tipoInteractividad"))
							 .append(tipoInteractividad).append(SPLITTER);
					usoEducativo.setTipoDeInteractividadAv(null);
					haCambiado = true;
					cambioUsosEdu=true;
				}
				//***********tipoRecurso***********							
				ArrayList<String> tipoRecurso = usoEducativo.getTiposDeRecursoAv();
				boolean cambioTipoRecurso = false;
				ArrayList new_tipoRecurso = new ArrayList();
				for(int k = 0; k < tipoRecurso.size();k++){
					String recurso = (String) tipoRecurso.get(k);
					if(recurso !=null && !aTipoRecursoV.contains(recurso)){
//					if(recurso !=null){
						logger.debug("Valor erroneo de tipo de recurso: " + recurso + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
						 		 .append(getPropertyValueI18n("vocabularios.tipoRecurso"))
						 		 .append(recurso).append(SPLITTER);
						haCambiado = true;
						cambioTipoRecurso = true;
						cambioUsosEdu=true;
					}
					else{
						new_tipoRecurso.add(recurso);
					}
				}
				if(cambioTipoRecurso)
					usoEducativo.setTiposDeRecursoAv(new_tipoRecurso);
				//***********nivelInteractividad***********
				String nivelInteractividad = usoEducativo.getNivelDeInteractividadAv();
				if(nivelInteractividad !=null && !aNivelInteractividadV.contains(nivelInteractividad)){
//				if(nivelInteractividad !=null){
					logger.debug("Valor erroneo de nivel de interactividad: " + nivelInteractividad + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
			 		 		 .append(getPropertyValueI18n("vocabularios.nivelInteractividad"))
			 		 		 .append(nivelInteractividad).append(SPLITTER);
					usoEducativo.setNivelDeInteractividadAv(null);
					haCambiado = true;
					cambioUsosEdu=true;
				}
				//***********densidadSemantica***********
				String densidadSemantica = usoEducativo.getDensidadSemanticaAv();
				if(densidadSemantica !=null && !aDensidadSemanticaV.contains(densidadSemantica)){
//				if(densidadSemantica !=null){
					logger.debug("Valor erroneo de densidad semantica: " + densidadSemantica + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
							 .append(getPropertyValueI18n("vocabularios.densidadSemantica"))
							 .append(densidadSemantica).append(SPLITTER);
					usoEducativo.setDensidadSemanticaAv(null);
					haCambiado = true;
					cambioUsosEdu=true;
				}
				//***********destinatarios***********
				ArrayList<String> destinatarios = usoEducativo.getDestinatariosAv();
				boolean cambioDestinatarios = false;
				ArrayList new_Destinatarios = new ArrayList();
				for(int k = 0; k < destinatarios.size();k++){
					String destinatario = (String) destinatarios.get(k);
					if(destinatario !=null && !aDestinatarioV.contains(destinatario)){
//					if(destinatario !=null){
						logger.debug("Valor erroneo de destinatario: " + destinatario + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
								 .append(getPropertyValueI18n("vocabularios.destinatario"))
								 .append(destinatario).append(SPLITTER);
						haCambiado = true;
						cambioDestinatarios = true;
						cambioUsosEdu=true;
					}
					else{
						new_Destinatarios.add(destinatario);
					}
				}
				if(cambioDestinatarios)
					usoEducativo.setDestinatariosAv(new_Destinatarios);
				//***********contextos***********
				ArrayList<String> contextos = usoEducativo.getContextosAv();
				boolean cambioContextos = false;
				ArrayList new_Contextos = new ArrayList();
				for(int k = 0; k < contextos.size();k++){
					String contexto = (String) contextos.get(k);
					if(contexto !=null && !aContextoV.contains(contexto)){
//					if(contexto !=null){
						logger.debug("Valor erroneo de contexto: " + contexto + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
						 		 .append(getPropertyValueI18n("vocabularios.contexto"))
						 		 .append(contexto).append(SPLITTER);
						haCambiado = true;
						cambioContextos = true;
						cambioUsosEdu=true;
					}
					else{
						new_Contextos.add(contexto);
					}
				}
				if(cambioContextos)
					usoEducativo.setContextosAv(new_Contextos);
				
				//***********dificultad***********
				String dificultad = usoEducativo.getDificultadAv();
				if(dificultad !=null && !aDificultadV.contains(dificultad)){
//				if(dificultad !=null){
					logger.debug("Valor erroneo de dificultad: " + dificultad + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
			 		 		 .append(getPropertyValueI18n("vocabularios.dificultad"))
			 		 		 .append(dificultad).append(SPLITTER);
					usoEducativo.setDificultadAv(null);
					haCambiado = true;
					cambioUsosEdu=true;
				}
				
				//***********Tiempo de aprendizaje***********				
				DuracionAgrega duracionAgrega = usoEducativo.getTiempoTipicoAprendizajeAv();
				if(duracionAgrega!=null){
					String duracion =duracionAgrega.getDuracion();
					if(duracion!=null){
						Pattern mask=Pattern.compile("^P([0-9]+Y){0,1}([0-9]+M){0,1}([0-9]+D){0,1}(T([0-9]+H){0,1}([0-9]+M){0,1}([0-9]+(.[0-9]+){0,1}S){0,1}){0,1}$"); //ejm ee-zz
						Matcher matcher = mask.matcher(duracion);
						boolean correcto = matcher.matches();
						if(!correcto){
							logger.debug("Valor erroneo de duracion: " + duracion + ". Borramos valor.");
							resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
							 		 .append(getPropertyValueI18n("vocabularios.duracion"))
							 		 .append(duracion).append(SPLITTER);
							duracionAgrega.setDuracion(null);
							usoEducativo.setTiempoTipicoAprendizajeAv(duracionAgrega);
							haCambiado = true;
							cambioUsosEdu=true;
						}
					}
				}
				
				
				//***********idiomasDestinatarios***********
				ArrayList<String> idiomasDestinatarios = usoEducativo.getIdiomasDestinatarioAv();
				boolean cambioIdiomasDest = false;
				ArrayList new_IdiomasDest = new ArrayList();
				for(int k = 0; k < idiomasDestinatarios.size();k++){
					String idioma = (String) idiomasDestinatarios.get(k);
					if(idioma !=null && !aIdiomaDestinatarioV.contains(idioma)){
//					if(idioma !=null){
						logger.debug("Valor erroneo de idioma destinario: " + idioma + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
				 		 		 .append(getPropertyValueI18n("vocabularios.idiomaDestinatario"))
				 		 		 .append(idioma).append(SPLITTER);
						haCambiado = true;
						cambioIdiomasDest = true;
						cambioUsosEdu=true;
					}
					else{
						new_IdiomasDest.add(idioma);
					}
				}
				if(cambioIdiomasDest)
					usoEducativo.setIdiomasDestinatarioAv(new_IdiomasDest);
				//***********procesosCognitivos***********				
				ArrayList<String> procesosCognitivos = usoEducativo.getProcesosCognitivosAv();
				boolean cambioProcesosCog = false;
				ArrayList new_ProcesosCog = new ArrayList();
				for(int k = 0; k < procesosCognitivos.size();k++){
					String proceso = (String) procesosCognitivos.get(k);
					if(proceso !=null && !aProcesoCognitivoV.contains(proceso)){
//					if(proceso !=null){
						logger.debug("Valor erroneo de proceso cognitivo: " + proceso + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
		 		 		 		 .append(getPropertyValueI18n("vocabularios.proceso"))
		 		 		 		 .append(proceso).append(SPLITTER);
						haCambiado = true;
						cambioProcesosCog = true;
						cambioUsosEdu=true;
					}
					else{
						new_ProcesosCog.add(proceso);
					}
				}
				if(cambioProcesosCog)
					usoEducativo.setProcesosCognitivosAv(new_ProcesosCog);

				
				if((usoEducativo.getTipoDeInteractividadAv()!=null && !usoEducativo.getTipoDeInteractividadAv().equals("")) ||
					(usoEducativo.getTiposDeRecursoAv()!=null && usoEducativo.getTiposDeRecursoAv().size()>0) ||
					(usoEducativo.getNivelDeInteractividadAv()!=null && !usoEducativo.getNivelDeInteractividadAv().equals("")) ||
					(usoEducativo.getDensidadSemanticaAv()!=null && !usoEducativo.getDensidadSemanticaAv().equals("")) ||
					(usoEducativo.getDestinatariosAv()!=null && usoEducativo.getDestinatarios().size()>0) ||
					(usoEducativo.getContextosAv()!=null && usoEducativo.getContextosAv().size()>0) ||
					(usoEducativo.getRangosEdadAv()!=null && usoEducativo.getRangosEdadAv().size()>0) ||
					(usoEducativo.getDificultadAv()!=null && !usoEducativo.getDificultadAv().equals("")) ||
					(usoEducativo.getTiempoTipicoAprendizajeAv()!=null && usoEducativo.getTiempoTipicoAprendizajeAv().getDuracion()!=null && !usoEducativo.getTiempoTipicoAprendizajeAv().getDuracion().equals("")) ||
					(usoEducativo.getTiempoTipicoAprendizajeAv()!=null && usoEducativo.getTiempoTipicoAprendizajeAv().getDescripciones()!=null && usoEducativo.getTiempoTipicoAprendizajeAv().getDescripciones().size()>0) ||
					(usoEducativo.getDescripcionesAv()!=null && usoEducativo.getDescripcionesAv().size()>0) ||
					(usoEducativo.getIdiomasDestinatarioAv()!=null && usoEducativo.getIdiomasDestinatarioAv().size()>0) ||
					(usoEducativo.getProcesosCognitivosAv()!=null && usoEducativo.getProcesosCognitivosAv().size()>0)){
					new_usosEducativos.add(usoEducativo);
				}
				
			}
			if(cambioUsosEdu){
				EducationalAgrega[] aUsosEducativos= (EducationalAgrega[]) new_usosEducativos.toArray(new EducationalAgrega[new_usosEducativos.size()]);
				lomAgrega.setEducationalsAgrega(aUsosEducativos);
			}
			/**********************Derechos**********************/
			logger.debug("Comprobando campos de la categoría Derechos");
			RightsAgrega derechosAgrega = lomAgrega.getRightsAgrega();
			
			String coste = derechosAgrega.getCosteAv();
			if(coste !=null && !aCosteV.contains(coste)){
//			if(coste !=null){
				logger.debug("Valor erroneo de coste: " + coste + ". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
						 .append(getPropertyValueI18n("vocabularios.coste"))
						 .append(coste).append(SPLITTER);
				derechosAgrega.setCosteAv(null);
				haCambiado = true;
			}
			
			String derechosAutor = derechosAgrega.getDerechosDeAutorAv();
			if(derechosAutor !=null && !aDerechosAutorV.contains(derechosAutor)){
//			if(derechosAutor !=null){
				logger.debug("Valor erroneo de derechos de autor: " + derechosAutor + ". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
				 		 .append(getPropertyValueI18n("vocabularios.derechosAutor"))
				 		 .append(derechosAutor).append(SPLITTER);
				derechosAgrega.setDerechosDeAutorAv(null);
				haCambiado = true;
			}
			
			AccesoAgrega acceso = derechosAgrega.getAccesoAv();
			String tipoAcceso = acceso.getTipoAcceso();
			if(tipoAcceso !=null && !aTipoAccesoV.contains(tipoAcceso)){
//			if(tipoAcceso !=null){
				logger.debug("Valor erroneo de tipo de acceso: " + tipoAcceso + ". Borramos valor.");
				resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
		 		 		 .append(getPropertyValueI18n("vocabularios.tipoAcceso"))
		 		 		 .append(tipoAcceso).append(SPLITTER);
				acceso.setTipoAcceso(null);
				derechosAgrega.setAccesoAv(acceso);
				haCambiado = true;
			}
			
			/**********************Relación**********************/
			logger.debug("Comprobando campos de la categoría Relacion");
			ArrayList<RelationAgrega> relacionesAgrega = lomAgrega.getRelationsAgrega();
			ArrayList<RelationAgrega> new_relaciones= new ArrayList<RelationAgrega>();
			boolean cambioRelacion = false;
			for(int j = 0;j < relacionesAgrega.size(); j++){
				RelationAgrega relacionAgrega = relacionesAgrega.get(j);
				String tipo = relacionAgrega.getTipoAv();
				if(tipo !=null && !aTipoRelacionV.contains(tipo)){
//				if(tipo !=null){
					logger.debug("Valor erroneo de tipo de relacion: " + tipo + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
							 .append(getPropertyValueI18n("vocabularios.tipoRelacion"))
							 .append(tipo).append(SPLITTER);
					relacionAgrega.setTipoAv(null);
					haCambiado = true;
					cambioRelacion=true;
				}
				if((relacionAgrega.getTipoAv()!=null && !relacionAgrega.getTipoAv().equals("")) ||
					(relacionAgrega.getRecursoAv()!=null && relacionAgrega.getRecursoAv().getDescripciones()!=null && 
							relacionAgrega.getRecursoAv().getDescripciones().size()>0) ||
					(relacionAgrega.getRecursoAv()!=null && relacionAgrega.getRecursoAv().getIdentificador()!=null && 
							relacionAgrega.getRecursoAv().getIdentificador().getCatalogo()!=null && 
							!relacionAgrega.getRecursoAv().getIdentificador().getCatalogo().equals("")) ||
					(relacionAgrega.getRecursoAv()!=null && relacionAgrega.getRecursoAv().getIdentificador()!=null && 
							relacionAgrega.getRecursoAv().getIdentificador().getEntrada()!=null && 
							!relacionAgrega.getRecursoAv().getIdentificador().getEntrada().equals(""))){
					new_relaciones.add(relacionAgrega);
				}
			}
			if(cambioRelacion){
				RelationAgrega[] aRelaciones= (RelationAgrega[]) new_relaciones.toArray(new RelationAgrega[new_relaciones.size()]);
				lomAgrega.setRelationsAgrega(aRelaciones);
			}
			/**********************Anotacion**********************/
			logger.debug("Comprobando campos de la categoría Anotacion");
			ArrayList<AnnotationAgrega> anotacionesAgrega = lomAgrega.getAnnotationsAgrega();
			ArrayList<AnnotationAgrega> new_anotaciones= new ArrayList<AnnotationAgrega>();
			boolean cambioAnotacion = false;
			for(int j = 0;j < anotacionesAgrega.size(); j++){
				AnnotationAgrega anotacionAgrega = anotacionesAgrega.get(j);
				FechaAgrega fecha = anotacionAgrega.getFechaAv();
				if(fecha!=null && fecha.getFecha()!=null){
					String sFecha = fecha.getFecha();
					boolean correcta = this.comprobarFecha(sFecha);

					if(!correcta){
						logger.debug("Valor erroneo de fecha: " + sFecha + ". Borramos valor.");
						resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
						 		 .append(getPropertyValueI18n("vocabularios.fechaAnotacion"))
						 		 .append(sFecha).append(SPLITTER);
						fecha.setFecha(null);
						anotacionAgrega.setFechaAv(fecha);
						haCambiado = true;
						cambioAnotacion=true;
					}
					if(fecha.getFecha() != null || (fecha.getDescripciones()!=null && fecha.getDescripciones().size()>0)){
						new_anotaciones.add(anotacionAgrega);
					}
					
				}								
			}
			if(cambioAnotacion){
				AnnotationAgrega[] aAnotaciones= (AnnotationAgrega[]) new_anotaciones.toArray(new AnnotationAgrega[new_anotaciones.size()]);
				lomAgrega.setAnnotationsAgrega(aAnotaciones);
			}
			/**********************Clasificacion**********************/
			logger.debug("Comprobando campos de la categoría Clasificacion");
			ArrayList<ClassificationAgrega> clasificacionesAgrega = lomAgrega.getClassificationsAgrega();
			ArrayList<ClassificationAgrega> new_clasificaciones= new ArrayList<ClassificationAgrega>();
			boolean cambioClasificacion = false;
			for(int j = 0; j < clasificacionesAgrega.size(); j++){
				ClassificationAgrega clasificacionAgrega = clasificacionesAgrega.get(j);
				String proposito = clasificacionAgrega.getPropositoAv();
				if(proposito !=null && !aPropositoV.contains(proposito)){
//				if(proposito !=null){
					logger.debug("Valor erroneo de proposito: " + proposito + ". Borramos valor.");
					resultado.append(getPropertyValueI18n("vocabularios.texto.borrado"))
			 		 		 .append(getPropertyValueI18n("vocabularios.proposito"))
			 		 		 .append(proposito).append(SPLITTER);
					clasificacionAgrega.setPropostitoAv(null);
					haCambiado = true;
					cambioClasificacion=true;
				}
				if((clasificacionAgrega.getPropositoAv()!=null && !clasificacionAgrega.getPropositoAv().equals("")) ||
					(clasificacionAgrega.getRutaTaxonomicasAv()!=null && clasificacionAgrega.getRutaTaxonomicasAv().size() >0) ||
					(clasificacionAgrega.getPalabrasClaveAv()!=null && clasificacionAgrega.getPalabrasClaveAv().size()>0) ||
					(clasificacionAgrega.getDescripcionesAv()!=null && clasificacionAgrega.getDescripcionesAv().size()>0)){
					new_clasificaciones.add(clasificacionAgrega);
				}
			}
			if(cambioClasificacion){
				ClassificationAgrega[] aClasificaciones= (ClassificationAgrega[]) new_clasificaciones.toArray(new ClassificationAgrega[new_clasificaciones.size()]);
				lomAgrega.setClassificationsAgrega(aClasificaciones);
			}
			
			
			//obtenemos la localización del lomes, por si estuviera referenciado por location
			Object elemento = manifestAgrega.obtenerElemento(idPadre);
			String location = null;
			if (elemento instanceof Manifest) {
				Manifest new_elemento = (Manifest) elemento;
				location = this.obtenLocation(new_elemento.getMetadata());				
			}else if (elemento instanceof Organization){
				Organization new_elemento = (Organization) elemento;
				location = this.obtenLocation(new_elemento.getMetadata());
			}else if (elemento instanceof Item){
				Item new_elemento = (Item) elemento;
				location = this.obtenLocation(new_elemento.getMetadata());
			}else if (elemento instanceof Resource){
				Resource new_elemento = (Resource) elemento;
				location = this.obtenLocation(new_elemento.getMetadata());
			}
			
			if (haCambiado)//si el lomes ha cambiado se inserta de nuevo el manifest o se sobreescribe 
						   //el fichero si estuviera referenciado mediante location
				manifestAgrega.setLom(idPadre, location, lomes);
		}

		return resultado.toString();
	}
	
	private String obtenLocation(Metadata metadata){
		String location = null;
		if (metadata != null && metadata.getGrp_any() != null
				&& metadata.getGrp_any().getAnyObject() != null) {
			
			Object[] array = metadata.getGrp_any().getAnyObject();
			for (int k = 0;  k < array.length; k++) {
				if (array[k] instanceof Location) {
					location = ((Location)array[k]).getContent();
				
				}
			}
		}
		return location;
	}
	
	private ArrayList obtenValoresVocabulario(VocabularioVO vocabulario){
		ArrayList resultado = new ArrayList();
		
		TerminoVO[] valores = vocabulario.getTerminos();
		for(int i = 0; i< valores.length;i++){
			resultado.add(valores[i].getNomTermino());
		}
		
		return resultado;
	}
	
	private boolean comprobarFecha(String fecha){
		boolean correcto = true;
		
		String expresion = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})(\\-(0[1-9]|1[0-2])(\\-(0[1-9]|[1-2][0-9]|3[0-1])(T([0-1][0-9]|2[0-3])(:[0-5][0-9](:[0-5][0-9](\\.[0-9]{1,}(Z|((\\+|\\-)([0-1][0-9]|2[0-3]):[0-5][0-9]))?)?)?)?)?)?)?$";
		
		Pattern mask=Pattern.compile(expresion);
		Matcher matcher = mask.matcher(fecha);
		correcto = matcher.matches();
		
		return correcto;
	}
	/**
	 * Este metodo nos da las transiciones de los ODEs propuestos para publicaión del grupo(s) de trabajo(s) al/ a los que pertenece
	 * el usuario. Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * 
	 * @param idsUsuarios
	 * 			Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado propuestos para publicación por un array de usuarios.
	 * @throws Exception
	 * 
	 */
	
	protected TransicionVO[] handleObtenODEsPropuestosPorUsuarios(String[] ids) throws Exception {
		return obtenerODEsPorEstadoUsuarios(ids, SrvPublicacionServiceImpl.PROPUESTO);
	}

	/**
	 * Este metodo nos da las transiciones de los ODEs compartidos del grupo(s) de trabajo(s) al/ a los que pertenece
	 * el usuario. Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * 
	 * @param ids
	 * 			Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado propuestos para catalogación por un array de usuarios.
	 * @throws Exception
	 * 
	 */
	protected TransicionAutorVO[] handleObtenODEsCompartidosPorUsuarios(String[] ids) throws Exception {
		TransicionAutorVO[] result = null;
		try {
		TransicionDao transicion = this.getTransicionDao();
		EstadoCompartidoUsuariosCriteria criterio=new EstadoCompartidoUsuariosCriteria();
		EstadoCompartidoUsuariosCriteria criterio2=new EstadoCompartidoUsuariosCriteria();
		criterio2.setCompartido(new Boolean(true));
		criterio2.setEstadoTransitado(null);
		criterio2.setEstadoActual(this.getEstadoDao().obtenEstadoPorNombre(CREACION));
		criterio2.setIdsUsuarios(ids);
		criterio.setCompartido(new Boolean(true));
		criterio.setEstadoTransitado(null);
		criterio.setEstadoActual(this.getEstadoDao().obtenEstadoPorNombre(RECHAZADO));
		criterio.setIdsUsuarios(ids);
		
		List transiciones = transicion.buscarOdesPorEstadoCompartidoUsuarios(TransicionDao.TRANSFORM_TRANSICIONAUTORVO, criterio2);
		List transiciones2=transicion.buscarOdesPorEstadoCompartidoUsuarios(TransicionDao.TRANSFORM_TRANSICIONAUTORVO, criterio);
		transiciones.addAll(transiciones2);
		logger.info("Obtenidos " + transiciones.size() + " odes en estado "
				+ SrvPublicacionServiceImpl.CREACION+" y "+SrvPublicacionServiceImpl.RECHAZADO+" para la lista de usuarios");
			result = (TransicionAutorVO[]) transiciones.toArray(new TransicionAutorVO[transiciones.size()]);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		return result;
	}

	/**
	 * Este metodo nos da las transiciones de los ODEs despublicados del grupo(s) de trabajo(s) al/ a los que pertenece
	 * el usuario. Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * 
	 * @param ids
	 * 			Los identificadores de entrada son los identificadores de los usuarios que comparten grupo(s) con nuestro usuario
	 * @return se retorna el array con las transiciones ordenadas por fecha de
	 *         los ODEs en estado propuestos para catalogación por un array de usuarios.
	 * @throws Exception
	 * 
	 */
	protected TransicionVO[] handleObtenODEsDespublicadosPorUsuarios(String[] ids) throws Exception {
		return obtenerODEsPorEstadoUsuarios(ids, SrvPublicacionServiceImpl.NO_DISPONIBLE);
	}

	
}
