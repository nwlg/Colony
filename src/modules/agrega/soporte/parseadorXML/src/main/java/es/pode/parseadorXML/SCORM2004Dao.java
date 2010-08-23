/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

import es.pode.parseadorXML.castor.Grp_any;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.ManifestType;
import es.pode.parseadorXML.castor.Organizations;
import es.pode.parseadorXML.castor.Sequencing;
import es.pode.parseadorXML.castor.SequencingCollection;
import es.pode.parseadorXML.castor.Manifest;

public class SCORM2004Dao {

	public final static int LAZY = 1;

	public final static int EAGER = 2;

	private MapperIF beanMapper = null;

	private static Logger logger = Logger.getLogger(SCORM2004Dao.class);

	public MapperIF getBeanMapper() {
		return beanMapper;
	}

	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}

	private static Properties props = null;
	
	public String getProperty(String key) throws ParseadorException {
		if(props==null) {
			InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
			props = new Properties();
			try {
				props.load(is);
			} catch (Exception e) {
				logger.error("Error al leer parseadorXML.properties : " + e.getMessage());
				if(logger.isDebugEnabled()) logger.debug(e);
				throw new ParseadorException(e.getMessage(),e);
			}
		}
		String value = props.getProperty(key);
		return value;
	}
	
	/**
	 * 
	 * Parsea un manifest de SCORM2004 y transforma los objetos parseados a las
	 * clases del paquete es.pode.parseadorXML.scorm2004. El modo permite elegir
	 * entre resolver las referencias a LOM-ES externos o dejarlas
	 * referenciadas.
	 * 
	 * @param modo
	 *            Modo en que se resuelven las referencias a LOM-ES externos.
	 *            Para dejarlos referenciados, usar SCORM2004Dao.LAZY. Para
	 *            resolverlos e incorporarlos, SCORM2004Dao.EAGER.
	 * @param imsManifest
	 *            Objeto java.io.File apuntando al manifest a parsear.
	 * @return Objeto Manifest que define el ODE.
	 * @throws ParseadorException
	 *             Cuando el fichero a parsear no existe o no se pudo abrir para
	 *             su lectura.
	 */
	public Manifest parsearODE(int modo, InputSource is)
			throws ParseadorException {
		/*
		 * TODO: Implementar la funcionalidad EAGER.
		 */
		// Abrir fichero xml para su lectura.
		Manifest manifestType = null;

		
		try {
			
			// Parsear XML
			// manifestType = ManifestType.unmarshal(is);
			Unmarshaller unmarshaller = new Unmarshaller(Manifest.class);
			// Omito la validacion para evitar fallos de validacion de IDREF de
			// imsss
			unmarshaller.setValidation(false);
			manifestType = (Manifest) unmarshaller.unmarshal(is);

			/*
			 * Preproceso el manifest para eliminar las sequencing colection y
			 * sustituirlas por secuencias en los items/organizations
			 */
			preprocesarSequencingCollection(manifestType);
			
			
			/*
			 * Se elimina la validacion de castor para la fase III: El
			 * catalogador avanzado posibilita que catalogaciones incompletas
			 * sean guardadas en el manifiesto, lo que provocaría un error de
			 * validación al intentar guardar.
			 */
//			if(logger.isDebugEnabled()) logger.debug("Validando el manifest tras el preprocesado de <sequencingcollection>");
//			manifestType.validate();
			
			

			// Cerrar fichero
			
		} catch (MarshalException e) {
			logger.error("Error de parseo : " + e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
			throw new ParseadorException("Error en el parseo del manifest", e);
		} catch (ValidationException e) {
			logger.error("Error de parseo : " + e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
			throw new ValidacionException(
					"Error de validacion en el parseo del manifest", e);
		}
		return manifestType;
	}
	
	public Manifest parsearODE(int modo, File file)
	throws ParseadorException {
		FileInputStream fis = null;
		Manifest manifest = null;
		try {
			fis = new FileInputStream(file);
			manifest = parsearODE(modo, fis);
			/*
			 * Inserto la ruta base al manifiesto. Esta información se usara
			 * para la recuperación de archivos de metadatos.
			 */
			manifest.setManifestBasePath(file.getParentFile().getPath());
		} catch (IOException e) {
			logger.error("Error en el parseo del manifiesto : " + e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
			throw new ParseadorException(e.getMessage(),e);
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch (Exception e) {
				// No hacer nada
			}
		}
		return manifest;
	}
	
	public Manifest parsearODE(int modo, String xmlPath)
	throws ParseadorException {
		File file = new File(xmlPath);
		Manifest manifest = null;
		if(file.isFile() && "imsmanifest.xml".equals(file.getName())) {
			manifest = parsearODE(modo, file);
		} else {
			throw new ParseadorException("El fichero " + xmlPath + " no existe o no es un imsmanifest.xml");
		}
		return manifest;
	}
	
	public Manifest parsearODE(int modo, InputStream is)
	throws ParseadorException {
		InputSource isrc = null;
		Manifest manifest = null;
		isrc = new InputSource(is);
		manifest = parsearODE(modo, isrc);
		return manifest;
	}
	
	public Manifest parsearODE(int modo, Reader reader)
	throws ParseadorException {
		InputSource isrc = null;
		Manifest manifest = null;
		isrc = new InputSource(reader);
		manifest = parsearODE(modo, isrc);
		return manifest;
	}

	private void preprocesarSequencingCollection(ManifestType manifest) {
		if (manifest == null)
			throw new NullPointerException(
					"manifest null en preprocesarSequencingCollection");
		if (manifest.getGrp_any() != null
				&& manifest.getGrp_any().getAnyObjectCount() > 0) {
			SequencingCollection sqc = extraerSequencingCollection(manifest);
			if (sqc == null) {
				if(logger.isDebugEnabled()) logger.debug("El manifiesto " + manifest.getIdentifier()
						+ " no tiene <secuencingcollection>");
			} else {
				if(logger.isDebugEnabled()) logger.debug("El manifiesto " + manifest.getIdentifier()
						+ " tiene un <secuencingcollection>");
				if(logger.isDebugEnabled()) logger.debug("Elimino el sequencing collection del manifest");
				manifest.setGrp_any(null);
				/*
				 * Recorro las organizaciones y los items para sustituir las
				 * referencias a sequencing del sequencingcollection por clones
				 * de la sequencing referenciada.
				 */
				if(logger.isDebugEnabled()) logger.debug("Clonando las secuencias del sequencingCollection a los items y organizaciones");
				clonarSequencings(manifest, sqc);
				if(logger.isDebugEnabled()) logger.debug("Finalizado el preprocesado de sequencingcollection");
			}
		} else {
			if(logger.isDebugEnabled()) logger.debug("El manifiesto " + manifest.getIdentifier()
					+ " no tiene <secuencingcollection>");
		}
	}

	private void clonarSequencings(ManifestType manifest,
			SequencingCollection sqc) {
		Organizations orgs = manifest.getOrganizations();
		if(logger.isDebugEnabled()) logger.debug("Recorro las organizaciones sustituyendo las secuencias.");
		for (int i = 0; i < orgs.getOrganizationCount(); i++) {
			if (orgs.getOrganization(i).getGrp_any() != null) {
				if(logger.isDebugEnabled()) logger.debug("Sustituyendo las secuencias referenciadas de organizacion "
								+ orgs.getOrganization(i).getIdentifier());
				sustituirSecuenciaReferenciada(orgs.getOrganization(i)
						.getGrp_any(), sqc);
			}
			if(logger.isDebugEnabled()) logger.debug("Recorro los hijos de "
					+ orgs.getOrganization(i).getIdentifier()
					+ " para comprobar sus secuencias");
			comprobarSecuenciasEnItems(orgs.getOrganization(i).getItem(), sqc);
		}
		if(logger.isDebugEnabled()) logger.debug("clonarSequencings finalizado");
	}

	private void comprobarSecuenciasEnItems(Item[] items,
			SequencingCollection sqc) {
		if (items != null) {
			for (int i = 0; i < items.length; i++) {
				if(logger.isDebugEnabled()) logger.debug("Sustituyendo las secuencias referenciadas de item "
								+ items[i].getIdentifier());
				sustituirSecuenciaReferenciada(items[i].getGrp_any(), sqc);
				if(items[i].getItemCount()>0) {
					if(logger.isDebugEnabled()) logger.debug("Iterando en los hijos de " + items[i].getIdentifier());
					comprobarSecuenciasEnItems(items[i].getItem(), sqc);
				}
			}
		}
	}

	private void sustituirSecuenciaReferenciada(Grp_any grpAny,
			SequencingCollection sqc) {
		for (int i = 0; i < grpAny.getAnyObjectCount(); i++) {
			if ((grpAny.getAnyObject(i) instanceof Sequencing)
					&& ((Sequencing) grpAny.getAnyObject(i)).getIDRef() != null) {
				if(logger.isDebugEnabled()) logger.debug("Sustituyendo sequencia referenciada "
						+ ((Sequencing) grpAny.getAnyObject(i)).getIDRef()
						+ " por una secuencia clonada");
				grpAny.setAnyObject(i, clonarSecuencia(((Sequencing) grpAny
						.getAnyObject(i)), sqc));
			}
		}
	}

	private Sequencing clonarSecuencia(Sequencing seq, SequencingCollection sqc) {
		Sequencing clon = null;
		Sequencing result = null;
			
		if (seq == null) {
			logger
					.error("No se ha encontrado la secuencia referenciada. IDREF no valido en manifiesto.");
		} else {
			// Clon limpio de la secuencia que está en SequencingCollection
			clon = (Sequencing) getBeanMapper().map((Sequencing)seq.getIDRef(), Sequencing.class);
			// Suprimo el ID para evitar problemas de validacion
			clon.setID(null);
			
			// Mapeo la secuencia original (sin IDREF) al clon para generar el resultado final
			seq.setIDRef(null);
			getBeanMapper().map(seq, clon);
			result = clon;
			
			if(logger.isDebugEnabled()) logger.debug("Secuencia " + seq.getID() + " clonada.");
		}

		return result;
	}

	private SequencingCollection extraerSequencingCollection(
			ManifestType manifest) {
		SequencingCollection sqc = null;
		for (int i = 0; i < manifest.getGrp_any().getAnyObjectCount()
				&& sqc == null; i++) {
			Object obj = manifest.getGrp_any().getAnyObject(i);
			if (obj instanceof SequencingCollection)
				sqc = (SequencingCollection) obj;
		}
		return sqc;
	}

	/**
	 * Parsea un manifest de SCORM2004 dejando las referencias a LOM-ES externos
	 * sin cargar.
	 * 
	 * @param imsManifest
	 * @return
	 * @throws ParseadorException
	 */
	public Manifest parsearODELazy(String imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.LAZY, imsManifest);
	}
	
	public Manifest parsearODELazy(File imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.LAZY, imsManifest);
	}
	
	public Manifest parsearODELazy(InputStream imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.LAZY, imsManifest);
	}
	
	public Manifest parsearODELazy(Reader imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.LAZY, imsManifest);
	}

	public Manifest parsearODELazy(InputSource imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.LAZY, imsManifest);
	}
	
	/**
	 * Parsea un manifest de SCORM2004 resolviendo las referencias a LOM-ES
	 * externos y cargandolas dentro del objeto Manifest.
	 * 
	 * @param imsManifest
	 * @return
	 * @throws ParseadorException
	 */
	public Manifest parsearODEEager(File imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.EAGER, imsManifest);
	}
	
	public Manifest parsearODEEager(String imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.EAGER, imsManifest);
	}
	
	public Manifest parsearODEEager(InputStream imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.EAGER, imsManifest);
	}
	
	public Manifest parsearODEEager(Reader imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.EAGER, imsManifest);
	}
	
	public Manifest parsearODEEager(InputSource imsManifest) throws ParseadorException {
		return parsearODE(SCORM2004Dao.EAGER, imsManifest);
	}

	/**
	 * 
	 * Genera el fichero XML de SCORM2004 a partir del Manifest.
	 * 
	 * @param ode
	 *            Objeto Manifest que describe el ODE.
	 * @param imsManifest
	 *            Objeto java.io.File apuntando al fichero XML de destino.
	 * @throws ParseadorException
	 *             En los casos en que:
	 *             <ul>
	 *             <li> No se pudo abrir / crear el fichero para su escritura.
	 *             <li> Castor genero un error al formar el XML deacuerdo con el
	 *             esquema de SCORM2004.
	 *             </ul>
	 */
	public void escribirODE(Manifest ode, Writer osw)
			throws ParseadorException {
		try {

			String encoding = getProperty("default.encoding");
			// // Garantizamos que el encoding del marshaller es el mismo que el
			// del OutputStream
			Marshaller marshaller = new Marshaller(osw);
			marshaller.setEncoding(encoding);
			// Incluir los mapeos de namespaces LOM, ADL y IMSSS en la cabecera
			// del Manifest
			marshaller.setNamespaceMapping("lomes",
					"http://ltsc.ieee.org/xsd/LOM");
			marshaller.setNamespaceMapping("adlcp",
					"http://www.adlnet.org/xsd/adlcp_v1p3");
			marshaller.setNamespaceMapping("imsss",
					"http://www.imsglobal.org/xsd/imsss");
			marshaller.setNamespaceMapping("adlseq",
					"http://www.adlnet.org/xsd/adlseq_v1p3");
			marshaller.setNamespaceMapping("adlnav",
					"http://www.adlnet.org/xsd/adlnav_v1p3");
			marshaller.setNamespaceMapping("xsi",
					"http://www.w3.org/2001/XMLSchema-instance");
			marshaller
					.setSchemaLocation("http://www.imsglobal.org/xsd/imscp_v1p1 imscp_v1p1.xsd http://ltsc.ieee.org/xsd/LOM lom.xsd http://www.adlnet.org/xsd/adlcp_v1p3 adlcp_v1p3.xsd http://www.imsglobal.org/xsd/imsss imsss_v1p0.xsd http://www.adlnet.org/xsd/adlseq_v1p3 adlseq_v1p3.xsd http://www.adlnet.org/xsd/adlnav_v1p3 adlnav_v1p3.xsd");
			/*
			 * Sequencing esta volcando mal el xsi:type. Desactivo el volcado de
			 * este atributo para evitar una validacion incorrecta contra
			 * esquema.
			 */
			marshaller.setSuppressXSIType(true);
			// Para evitar fallos de validacion por lomes incompletos
			// (catalogador avanzado), elimino la validacion castor.
			marshaller.setValidation(false);
			marshaller.marshal(ode);

		} catch (MarshalException e) {
			throw new ParseadorException(
					"Error de parseo al escribir manifest", e);
		} catch (ValidationException e) {
			throw new ValidacionException(
					"Error de validacion al escribir el manifest", e);
		} catch (IOException e) {
			throw new ParseadorException(
					"No se pudo abrir el manifest para su escritura", e);
		} 
	}

	public void escribirODE(Manifest ode, String file)
	throws ParseadorException {
		File fFile = new File(file);
		escribirODE(ode, fFile);
	}
	
	public void escribirODE(Manifest ode, OutputStream out)
	throws ParseadorException {
		String encoding = getProperty("default.encoding");
		try {
			OutputStreamWriter osw = new OutputStreamWriter(out,encoding);
			escribirODE(ode, osw);
		} catch (UnsupportedEncodingException e) {
			throw new ParseadorException(e.getMessage(),e);
		}
	}
	
	public void escribirODE(Manifest ode, File file)
	throws ParseadorException {
		FileOutputStream fos = null;
		try {
			if(!file.exists()) file.createNewFile();
			else if(file.isDirectory()) {
				throw new ParseadorException("El path " + file.getPath() + " es una carpeta y no puede sobreescribirse como fichero");
			}
		} catch (IOException e) {
			throw new ParseadorException(e.getMessage(),e);
		}
		try {
			fos = new FileOutputStream(file);
			escribirODE(ode, fos);
		} catch (IOException e) {
			throw new ParseadorException(e.getMessage(),e);
		} finally {
			try {
				if(fos!=null) fos.close();
			} catch (Exception e) {
				// no hacer nada
			}
		}
	}
	
}
