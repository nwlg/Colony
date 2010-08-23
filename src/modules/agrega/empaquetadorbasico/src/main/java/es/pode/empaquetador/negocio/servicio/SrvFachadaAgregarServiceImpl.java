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
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import es.pode.catalogacion.negocio.servicios.ArbolCurricularVO;
import es.pode.catalogacion.negocio.servicios.ClassificationVO;
import es.pode.catalogacion.negocio.servicios.EducationalVO;
import es.pode.catalogacion.negocio.servicios.GeneralVO;
import es.pode.catalogacion.negocio.servicios.IdLomVO;
import es.pode.catalogacion.negocio.servicios.LomBasicoVO;
import es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService;
import es.pode.empaquetador.negocio.externos.UtilesFicheros;
import es.pode.empaquetador.negocio.utilidades.Utilidades;
import es.pode.empaquetador.negocio.uuid.PodeUUIDGenerator;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.Grp_any;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Metadata;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Organizations;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.castor.Resources;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.serializar.SerializadorObjetos;


/**
 * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService
 */

public class SrvFachadaAgregarServiceImpl
    extends es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarServiceBase
{

	private static final Logger logger = Logger.getLogger(SrvFachadaAgregarServiceImpl.class);

	private Utilidades utilidades = null;
	
	private static String PROTOCOL_DELIM="://";
	private static String HTTP_PREFIX="http://";
	private static String VACIA="";
	
	
    /**
	 * Realiza una llamada al servicio correspondiente para agregar un ODE desde
	 * el repositorio.
	 * 
	 * @param idOde
	 *            <p>
	 *            Identificador del ODE que esta siendo editado por el
	 *            empaquetador y en el cual se va a agregar el nuevo ODE.
	 *            </p>
	 * @param idDestino
	 *            <p>
	 *            Identificador del elemento del ODE (idOde) y en el que se
	 *            insertara el nuevo ODE. Este atributo puede ser:
	 *            </p>
	 *            <ul>
	 *            <li>Identificador de un submanifiesto (empaquetador
	 *            avanzado). El nuevo ODE se agrega como submanifiesto del
	 *            submanifiesto.</li>
	 *            <li>Identificador de un Item (empaquetador básico): Los
	 *            contenidos del ODE se añaden bajo el item identificado</li>
	 *            <li><em>null</em> (empaquetador avanzado): El nuevo ODE se
	 *            agrega directamente como submanifiesto del ODE que esta siendo
	 *            editado.</li>
	 *            </ul>
	 * @param tipoEmpaquetador
	 *            <p>
	 *            <em>avanzado</em> o <em>basico</em> según el editor que
	 *            esta siendo usado para agregar es el empaquetador avanzado o
	 *            el empaquetador básico.
	 *            </p>
	 * @param idAgregar
	 *            <p>
	 *            Identificador del ODE del repositorio que se desea agregar
	 *            como submanifiesto del ODE que esta siendo editado.
	 *            </p>
	 */
    protected void handleAgregar(java.lang.String idOde, java.lang.String idDestino, java.lang.String tipoEmpaquetador, java.lang.String idAgregar)
        throws java.lang.Exception
    {
    	if(TipoEmpaquetador.AVANZADO.toString().equalsIgnoreCase(tipoEmpaquetador)) {
    		this.getSrvGestorManifestService().agregarManifiestoRepositorio(idOde, idAgregar, idDestino);
    	} else {
    		this.getSrvEmpaquetadorBasicoService().agregarRepositorio(idOde, idAgregar, idDestino);
    	}
    }

	/**
	 * <p>
	 * Permite agregar un ODE de un repositorio remoto recuperando el ODE como
	 * archivo comprimido serializado
	 * </p>
	 * 
	 * @param idODE
	 *            <p>
	 *            Identificador del ODE que esta siendo editado por el
	 *            empaquetador y en el cual se va a agregar el nuevo ODE.
	 *            </p>
	 * @param idDestino
	 *            <p>
	 *            Identificador del elemento del ODE (idOde) y en el que se
	 *            insertara el nuevo ODE. Este atributo puede ser:
	 *            </p>
	 *            <ul>
	 *            <li>Identificador de un submanifiesto (empaquetador
	 *            avanzado). El nuevo ODE se agrega como submanifiesto del
	 *            submanifiesto.</li>
	 *            <li>Identificador de un Item (empaquetador básico): Los
	 *            contenidos del ODE se añaden bajo el item identificado</li>
	 *            <li><em>null</em> (empaquetador avanzado): El nuevo ODE se
	 *            agrega directamente como submanifiesto del ODE que esta siendo
	 *            editado.</li>
	 *            </ul>
	 * @param tipoEmpaquetador
	 *            <p>
	 *            <em>avanzado</em> o <em>basico</em> según el editor que
	 *            esta siendo usado para agregar es el empaquetador avanzado o
	 *            el empaquetador básico.
	 *            </p>
	 * @param paquete
	 *            Archivo comprimido conteniendo el ODE que se desea agregar
	 *            serializado en un objeto tipo javax.activation.Datahandler
	 */
	protected void handleAgregarFederado(String idODE, String idDestino, String tipoEmpaquetador, DataHandler paquete) throws Exception {
		if(TipoEmpaquetador.AVANZADO.toString().equalsIgnoreCase(tipoEmpaquetador)) {
			this.getSrvGestorManifestService().agregarManifiestoZIP(idODE, paquete, idDestino);
		} else {
			FicheroVO fichero = new FicheroVO();
			fichero.setDatos(paquete);
			fichero.setNombre("ode_federado.zip");
			this.getSrvEmpaquetadorBasicoService().agregarLocal(idODE, fichero, idDestino);
		}
	}

	/**
	 * Elimina el metadato del ODE solicitado del servicio de catalogacion (ver
	 * handlePrepararMetadatos).
	 * 
	 * @param identificador Identificador del ODE cuyo metadato se desea visualizar
	 */
	protected void handleDescargarMetadato(String identificador) throws Exception 
	{
		String tipoEmpaquetador = LdapUserDetailsUtils.getEmpaquetador().toLowerCase();
		String[] ids= new String[1];
		ids[0]=identificador;
		this.getSrvCatalogacionAvanzadaService().eliminarObjLoms(ids);
	}

	/**
	 * Parsea el ODE solicitado para precargar el metadato LOM-ES en el servicio
	 * de catalogacion. Esto permite visualizar los metadatos de un objeto
	 * publicado.
	 * 
	 * @param identificador
	 *            Identificador del ODE cuyo metadato se desea visualizar.
	 */
	protected String handlePrepararMetadatos(String identificador) throws Exception 
	{
		Manifest manifestImportado = null;
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String cargarObjLom="";
		String ruta = localizador.getPath();
		File rutaXml = new File(ruta + "/" + Utilidades.MANIFEST_NAME);
		manifestImportado = this.getScormDao().parsearODELazy(rutaXml);
		ManifestAgrega manifestAgrega=new ManifestAgrega(manifestImportado);
		Lom lom = manifestAgrega.obtenerLom(identificador, null);
		
		SerializadorObjetos so = new SerializadorObjetos();
		DataHandler dh = so.serializarObjeto(lom);
		String usuario=LdapUserDetailsUtils.getLogin();
		cargarObjLom = this.getSrvCatalogacionAvanzadaService().cargarObjLom(identificador, usuario, dh);
		return cargarObjLom;
	}

	/**
	 * Realiza las operaciones necesarias para agregar un ODE perteneciente a
	 * otro nodo de la federación Agrega. Para ello, usa la URL del objeto y
	 * abre un stream para descargar el objeto a una ruta temporal del nodo
	 * local.
	 * 
	 * @param idODE
	 *            Identificador del ODE en el que se desea agregar el objeto
	 *            remoto.
	 * @param idDestino
	 *            Identificador del elemento destino para el objeto agregado. Se
	 *            distinguen dos casos en función del tipo de empaquetador:<br/>
	 *            <ul>
	 *            <li>Empaquetador avanzado: idDestino es el identificador del
	 *            submanifiesto al que se va a agregar el objeto (null si se
	 *            desea agregar al ode raiz)</li>
	 *            <li>Empaquetador basico: Identificador del elemento (ítem
	 *            SCORM) que va a hacer referencia al objeto importado.</li>
	 *            </ul>
	 * @param tipoEmpaquetador
	 *            Especifica el tipo de empaquetador en uso y por tanto, el tipo
	 *            de agregación a realizar. Los valores posibles son
	 *            <em>avanzado</em> y <em>basico</em>.
	 * @param sUrl
	 *            URL del objeto remoto que se desea agregar.
	 */
	@Override
	protected void handleAgregarFederado(String idODE, String idDestino, String tipoEmpaquetador, String sUrl) throws Exception {

		if(logger.isDebugEnabled()) logger.debug("AgregarFederado con parametros : idODE=" + idODE + " ; idDestino = " + idDestino + " ; tipoEmpaquetador = " + tipoEmpaquetador + " ; url = " + sUrl);
		if(logger.isDebugEnabled()) logger.debug("Generando fichero temporal para descarga de Ode a agregar");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
		String fecha = formatter.format(new Date());
		java.io.File zipTemporal = java.io.File.createTempFile("ODE-agregado-federado"+fecha, ".zip");
		if(!zipTemporal.exists()) zipTemporal.createNewFile();
		if(logger.isDebugEnabled()) logger.debug("Fichero temporal generado con ruta " + zipTemporal.getPath());
		
		if(logger.isDebugEnabled()) logger.debug("Abriendo conexión con URL " + sUrl);
		java.net.URL url = new java.net.URL(sUrl);
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream(zipTemporal);
		IOUtils.copy(is, fos);
		IOUtils.closeQuietly(fos);
		if(logger.isDebugEnabled()) logger.debug("Fichero " + sUrl + " descargado a " + zipTemporal.getPath() + " con tamaño " + zipTemporal.length() + " bytes");

		if(TipoEmpaquetador.AVANZADO.toString().equalsIgnoreCase(tipoEmpaquetador)) {
			if(logger.isDebugEnabled()) logger.debug("Llamando a agregar de empaquetador avanzado");
			getSrvGestorManifestService().agregarManifiestoZipUrl(idODE, zipTemporal.getPath(), idDestino);
		} else {
			if(logger.isDebugEnabled()) logger.debug("Llamando a agregar de empaquetador basico");
			getSrvEmpaquetadorBasicoService().agregarLocalFichero(idODE, zipTemporal.getPath(), idDestino);
		}
		
		if(logger.isDebugEnabled()) logger.debug("Eliminado archivo temporale " + zipTemporal);
		FileUtils.deleteQuietly(zipTemporal);
		if(logger.isDebugEnabled()) {
			if(zipTemporal.exists()) logger.debug(zipTemporal + " eliminado correctamente");
		} else logger.debug("No se ha podido eliminar el fichero temporal");
	}

	/**
	 * Genera un descriptor SCORM2004 imsmanifest.xml a partir de un conjunto de
	 * URIs de ficheros y de una URI de inicio de recurso (puede ser una de las
	 * URIs del conjunto de ficheros o una URL a un recurso externo). Este
	 * método forma parte de las operaciones necesarias para importar a carpeta
	 * personal un objeto cualquiera (SCORM o no).
	 * 
	 * @param identificador Identificador del objeto cuyo imsmanifest.xml se desea generar.
	 * @param files Array de URIs (en formato java.lang.String) de los ficheros que compondrán el recurso del manifiesto.
	 * @param href URI del fichero principal del recurso.
	 * @param idioma Idioma que se usará para generar datos de catalogación.
	 * 
	 */
	@Override
	protected void handleGenerarManifest(String identificador, String[] files, String href, String idioma) throws Exception {
		SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
		LocalizadorVO localizador = localizadorService.consultaLocalizador(identificador);
		
		if(idioma==null) {
			idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		
//		String tituloProvisional = obtenerTituloProvisional("ode.sin.titulo",
//				new Locale(idioma), identificador);
		
		generarManifestComun(identificador, files, href, idioma, localizador, null);
   	}

	
	private void generarManifestComun(String identificador, String[] files,
			String href, String idioma, LocalizadorVO localizador, Lom lom) {
		/*
		 * Generamos el objeto Manifest inicial.
		 */
		Manifest manifest = manifestInicial(identificador, idioma);
		if (lom!=null) {
			Grp_any group = new Grp_any();
			group.addAnyObject(lom);
			manifest.getMetadata().setGrp_any(group);
		}
		//creamos un recurso con los todos los ficheros que se nos pasa en "files"
		logger.debug("Generamos identificador para el recurso");
		String newResourceId = PodeUUIDGenerator.getRecursoUUID(String
				.valueOf(java.lang.Math.random()));
		
		Resources resources = manifest.getResources();
		
		Resource resource = new Resource();
		resource.setHref(href);
		resource.setIdentifier(newResourceId);
		resource.setScormType("asset");
		resource.setType("webcontent");
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				es.pode.parseadorXML.castor.File file = new es.pode.parseadorXML.castor.File();
				file.setHref(files[i]);
				resource.addFile(file);
			}
			logger.debug("Ficheros añadidos al recurso");
		}

		resources.addResource(resource);
		logger.debug("Recurso añadidos a lista de recursos");
		
		//creamos un item con el recurso que hemos creado
		logger.debug("AOV: generamos identificador para el item");
		String newItemId = PodeUUIDGenerator.getItemUUID(String
				.valueOf(java.lang.Math.random()));
		logger
				.debug("AOV: añadimos item a la organizacion con el recurso anterior");
		Organizations orgs = manifest.getOrganizations();
		Organization org = orgs.getOrganization(0);
		Item item = new Item();
		item.setIdentifier(newItemId);
		item.setIdentifierref(newResourceId);
		item.setIsvisible(true);
		item.setTitle("Item");
		org.addItem(item);
		logger.debug("AOV: item añadido a la organizacion");
		/*
		 * Intento escribir un imsmanifest.xml inicial
		 */
		try {
			
			String ruta = localizador.getPath() + "/" + Utilidades.MANIFEST_NAME;
			this.getScormDao().escribirODE(manifest, new File(ruta));
			if(logger.isDebugEnabled()) logger.debug("imsmanifest.xml inicial escrito en disco");
		} catch (Exception e) {
			logger.error("Error al generar imsmanifest.xml inicial");
		}
	}

	/**
	 * Genera un imsmanifest.xml para componer un ODE SCORM2004 a partir de un
	 * paquete de intercambio de recursos (RCP). El manifiesto contendrá un ítem
	 * referenciando a cada recurso del paquete importado.
	 * 
	 * @param identificador Identificador del ODE cuyo manifiesto se desea generar.
	 * @param idioma Idioma para generar los datos de catalogación.
	 */
	@Override
	protected void handleGenerarManifestRCP(String identificador, String idioma) throws Exception {
		Manifest manifest = null;
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String ruta = localizador.getPath();
		File rutaXml = new File(ruta + "/" + Utilidades.MANIFEST_NAME);
		manifest = this.getScormDao().parsearODELazy(rutaXml);
		
//		Organizations orgs = manifest.getOrganizations();
		//creamos la organización que contendra un item por cada recurso del RCP
		Organization org = new Organization();
		//Generamos un identificador para la organización
		String newOrgId = PodeUUIDGenerator.getOrganizacionUUID(this.getClass()
				.toString());
		org.setIdentifier(newOrgId);
		org.setTitle(utilidades.getProperty("organizacion.por.defecto"));
		Resources resources = manifest.getResources();
		Resource[] recursos = resources.getResource();
		for(int i=0;i<recursos.length;i++){
			Resource recurso= recursos[i];
			String idRecurso = recurso.getIdentifier();
			//creamos un item por cada recurso
			String newItemId = PodeUUIDGenerator.getItemUUID(String
					.valueOf(java.lang.Math.random()));
			Item item = new Item();
			item.setIdentifier(newItemId);
			item.setIdentifierref(idRecurso);
			item.setTitle("Item"+i);
			//añadimos el item a la organizacion
			org.addItem(item);
		}
		
		//añadimos la organizacion a las organizaciones
		Organizations orgs = new Organizations();
		orgs.addOrganization(org);
		orgs.setDefault(org.getIdentifier());
		manifest.setOrganizations(orgs);

		try {
			
			ruta = localizador.getPath() + "/" + Utilidades.MANIFEST_NAME;
			this.getScormDao().escribirODE(manifest, new File(ruta));
			if(logger.isDebugEnabled()) logger.debug("imsmanifest.xml escrito en disco");
		} catch (Exception e) {
			logger.error("Error al generar imsmanifest.xml");
		}
	}
	
	private Manifest manifestInicial(String odeId, String idioma)
	{
		Manifest manifest = new Manifest();
		manifest.setIdentifier(odeId);
		String ident = PodeUUIDGenerator.getOrganizacionUUID(this
				.getClass().toString());
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

		logger.debug("Manifest inicial generado");
		return manifest;
	}

	private Metadata generarScormMetadata() {
		Metadata metadata = new Metadata();
		metadata.setSchema(utilidades.getProperty("empaquetador.crearOde.schema"));
		metadata.setSchemaversion(utilidades
				.getProperty("empaquetador.crearOde.schemaversion"));
		return metadata;
	}

//	private Lom generarLomInicial(String titulo, String idioma, String identificador) throws Exception {
//		Lom lom = new Lom();
//		LomAgrega la = new LomAgrega(lom);
//		GeneralAgrega ga = new GeneralAgrega(new General());
//		ga.addTituloIdioma(idioma, titulo);
//		IdentificadorAgrega id = new IdentificadorAgrega();
//		id.setCatalogo(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.CATALOGO_AGREGA));
//		id.setEntrada(identificador);
//		ArrayList<IdentificadorAgrega> lista = new ArrayList<IdentificadorAgrega>();
//		lista.add(id);
//		ga.setIdentificadoresAv(lista);
//		la.setGeneralAgrega(ga);
//		/*
//		 * Recupero el esquema de metadatos
//		 */
//		MetaMetadataAgrega metaA = new MetaMetadataAgrega(new MetaMetadata());
//		String schema = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.ESQUEMA_LOMES);
//		if(logger.isDebugEnabled()) logger.debug("Esquema de metadatos : " + schema);
//		metaA.addEsquemaDeMetadatos(schema);
//		// Idioma del metadato = idioma del usuario que cataloga
//		metaA.setIdioma(idioma);
//		la.setMetaMetadataAgrega(metaA);
//		return la.getLom();
//	}

	/**
	 * Analiza un archivo para comprobar si pertenece a uno de los siguientes tipos de archivo contemplados en la importación a carpeta personal:<br/><ul><li>Objeto SCORM2004 completo</li><li>Paquete de intercambio de recursos SCORM (RCP)</li><li>Archivo comprimido</li><li>Fichero único</li></ul>
	 * 
	 * @param rutaArchivo Ruta al archivo que se desea analizar.
	 * @return <em>Value Object</em> con los datos resultantes de analizar el archivo.
	 */
	@Override
	protected AnalizaArchivoVO handleAnalizarArchivo(String rutaArchivo)
			throws Exception {
		// Creamos rutaDesc en temp
		File temp= File.createTempFile("emp", "report");
		String rutaDescomprimido=temp.getParentFile().getPath()+"/"+temp.getName();
		boolean deleted=temp.delete();
		if(!deleted) {
			logger.debug("No se pudo borrar fichero temporal");
		}
		AnalizaArchivoVO resultado = getSrvEmpaquetadorBasicoService().analizaArchivo(rutaArchivo, rutaDescomprimido);
		//Borramos rutaDesc y su contenido
		File rutaDesc = new File(rutaDescomprimido);
		UtilesFicheros.eliminar(rutaDesc);
		return resultado;
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
	 * Genera un imsmanifest.xml a partir de un conjunto de ficheros y unos
	 * datos de catalogación básica. Realiza las mismas operaciones que el
	 * método handleGenerarManifest añadiendo un metadato válido equivalente al
	 * generado por el catalogador básico.
	 * 
	 * @param identificador Identificador del objeto cuyo imsmanifest.xml se desea generar.
	 * @param files Array de URIs (en formato java.lang.String) de los ficheros que compondrán el recurso del manifiesto.
	 * @param href URI del fichero principal del recurso.
	 * @param idioma Idioma que se usará para generar datos de catalogación (categoría 3.4 de LOM-ES).
	 * @param titulo Titulo del objeto cuyo manifiesto se desea generar (categoría 1.2 de LOM-ES).
	 * @param descripcion Descripción del objeto (categoría 1.4 de LOM-ES).
	 * @param idiomaDestinatario Idioma del destinatario del curso (categoría 5.11 de LOM-ES).
	 * @param tipo Tipo de recurso educativo (categoría 5.2 de LOM-ES). 
	 * 
	 * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarServiceBase#handleGenerarManifest(java.lang.String,
	 *      java.lang.String[], java.lang.String, java.lang.String)
	 */
	@Override
	protected void handleGenerarManifestLom(String identificador,
			String[] files, String href, String idioma, String titulo,
			String descripcion, String idiomaDestinatario, String tipo) throws Exception {
		Lom lom = new Lom();

		logger
				.debug("Asignamos campos de catalogación obtenidos a LomBasicoVO");
		LomBasicoVO lomBasico = new LomBasicoVO();
		GeneralVO general = lomBasico.getGeneral() != null ? lomBasico
				.getGeneral() : new GeneralVO();
		general.setTitulo(titulo);
		general.setIdioma(idioma);
		general.setDesc(descripcion);
		lomBasico.setGeneral(general);
		EducationalVO educational = lomBasico.getEducational() != null ? lomBasico
				.getEducational()
				: new EducationalVO();
		educational.setIdiomaDest(idiomaDestinatario);
		// Los campos para los que no tengo valor los asigno a cadena vacía para
		// evitar nullPointer
		educational.setContexto(VACIA);
		educational.setEdad(VACIA);
		educational.setProcesoCog(VACIA);
		// educational.setTipo("thematic or corporate webs/web portals");
		educational.setTipo(tipo);
		lomBasico.setEducational(educational);
		ClassificationVO clasificacion = lomBasico.getClassification() != null ? lomBasico
				.getClassification()
				: new ClassificationVO();
		clasificacion.setArbolesCurriculares(new ArbolCurricularVO[0]);
		lomBasico.setClassification(clasificacion);

		SrvLocalizadorService localizadorService = this
				.getSrvLocalizadorService();
		LocalizadorVO localizador = localizadorService
				.consultaLocalizador(identificador);

		logger.debug("Idioma es " + idioma);
		if (idioma == null) {
			String posibleIdioma = I18n.getInstance()
					.obtenerIdiomaDefectoPlataforma();
			logger.debug("Idioma posible es " + posibleIdioma);
			idioma = posibleIdioma != null && !posibleIdioma.equals(VACIA) ? posibleIdioma
					: "es";
		}

		String usuario = localizador.getIdUsuario();
		SerializadorObjetos so = new SerializadorObjetos();
		DataHandler serializado;
		try {
			logger
					.debug("Serializamos Lom vacio para insertar en cache de Catalogador");
			serializado = so.serializarObjeto(lom);
		} catch (Exception e1) {
			logger.error("Excepcion al serializar: ", e1);
			throw e1;
		}

		SrvCatalogacionBasicaService catalogacion = this
				.getSrvCatalogacionBasicaService();
		try {
			logger.debug("Cargamos Lom vacio en cache de Catalogador");
			catalogacion.cargarObjLom(identificador, usuario, serializado);
		} catch (Exception e) {
			logger.error("Excepcion al cargar Lom en cache:", e);
			throw e;
		}
		try {
			logger.debug("Generamos metadatos");
			catalogacion.generarMetadatos(identificador, usuario, lomBasico,
					idioma);
		} catch (Exception e) {
			logger.error("Excepcion al generarMetadatos: ", e);
			throw e;
		}
		try {
			IdLomVO[] ids = catalogacion
					.obtenerObjLoms(new String[] { identificador });
			lom = (Lom) so.deserializarObjeto(ids[0].getLomHandler());
		} catch (Exception e) {
			logger.error("Excepcion al deserializar: ", e);
			throw e;
		}
		
		if (!href.contains(PROTOCOL_DELIM)) {
			href = HTTP_PREFIX + href;
		}

		logger.debug("Llamando a generarManifestComun con id=" + identificador
				+ ", href=" + href + ", idioma=" + idioma + ", idiomaDes="
				+ idiomaDestinatario);
		generarManifestComun(identificador, files, href, idioma, localizador,
				lom);
		//Copiamos esquemas
		logger.debug("Empezamos a copiar esquemas...");
		utilidades.copiarEsquemas(localizador.getPath());
		logger.debug("Esquemas copiados");
	}
	
}