/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.scorm2004.agrega;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.SpringBootstrapContextLoader;
import es.pode.parseadorXML.castor.Location;
import es.pode.parseadorXML.castor.Presentation;
import es.pode.parseadorXML.castor.CompletionThreshold;
import es.pode.parseadorXML.castor.DataFromLMS;
import es.pode.parseadorXML.castor.TimeLimitAction;
import es.pode.parseadorXML.castor.Sequencing;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.MetadataSchema;
import es.pode.parseadorXML.castor.Dependency;
import es.pode.parseadorXML.castor.File;
import es.pode.parseadorXML.castor.Grp_any;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Metadata;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Organizations;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.castor.Resources;
import es.pode.soporte.uuid.PodeUUIDGenerator;

public class ManifestAgrega implements Serializable {
	
	private Manifest manifest = null;
	
	private Lom lomesExternoTmp = null;

	private Logger logger = Logger.getLogger(this.getClass());

	public ManifestAgrega() {
		super();
	}

	public ManifestAgrega(Manifest manifest) {
		super();
		setManifest(manifest);
	}

	/**
	 * @return the manifest
	 */
	public Manifest getManifest() {
		return manifest;
	}

	/**
	 * @param manifest
	 *            the manifest to set
	 */
	public void setManifest(Manifest manifest) {
		this.manifest = manifest;
	}

	/**
	 * Explora el manifest (organizaciones e items del manifest y
	 * submanifiestos) en busca de objetos de secuencia IMSSS (Sequencing) o ADL
	 * (Presentation).
	 * 
	 * @return True si el manifiesto o alguno de sus submanifiestos tiene al
	 *         menos un objeto de secuencia.
	 * @throws ParseadorException
	 *             Si el manifest del objeto ManifestAgrega no ha sido
	 *             inicializado.
	 */
	public boolean tieneSecuencias() throws ParseadorException {
		boolean resultado = false;
		// Busca secuencias en las organizaciones e items del submanifiesto
		check();
		Organization[] orgs = manifest.getOrganizations().getOrganization();
		for (int i = 0; i < orgs.length && !resultado; i++) {
			Item[] items = orgs[i].getItem();
			for (int j = 0; j < items.length && !resultado; j++) {
				resultado = buscarSecuenciaEnItems(items[j]);
			}
		}
		// Si no la ha encontrado, buscar en los submanifiestos
		if (!resultado) {
			Manifest[] submanifiestos = manifest.getManifest();
			for (int i = 0; i < submanifiestos.length && !resultado; i++) {
				ManifestAgrega ma = new ManifestAgrega(submanifiestos[i]);
				resultado = ma.tieneSecuencias();
			}
		}
		return resultado;
	}

	private boolean tieneSecuencia(Grp_any grpAny) {
		boolean resultado = false;
		if (grpAny != null) {
			Object[] objs = grpAny.getAnyObject();
			for (int i = 0; i < objs.length && !resultado; i++) {
				if (objs[i] instanceof Sequencing
						|| objs[i] instanceof Presentation) {
					resultado = true;
				}
			}
		}
		return resultado;
	}

	private boolean buscarSecuenciaEnItems(Item item) {
		boolean resultado = false;
		// ¿Tiene secuecia?
		resultado = tieneSecuencia(item.getGrp_any());
		// Si tiene hijos, repetir la busqueda en ellos
		if (!resultado && item.getItem() != null && item.getItem().length > 0) {
			Item[] array = item.getItem();
			for (int i = 0; i < array.length && !resultado; i++) {
				resultado = buscarSecuenciaEnItems(array[i]);
			}
		}
		return resultado;
	}

	/**
	 * 
	 * Analiza las organizaciones para devolver el elemento identificador por
	 * identifier
	 * 
	 * @param identifier
	 * @return
	 */
	public Item obtenerItem(String identifier) throws ParseadorException {
		Item resultado = null;
		check();
		Organizations organizations = manifest.getOrganizations();
		Organization[] organizationArray = null;
		if (organizations != null)
			organizationArray = organizations.getOrganization();
		if (organizations != null && organizationArray != null) {
			for (int i = 0; i < organizationArray.length && resultado == null; i++) {
				resultado = obtenerItem(organizationArray[i].getItem(),
						identifier);
			}
		}
		return resultado;
	}

	private Item obtenerItem(Item[] itemArray, String identifier) {
		Item resultado = null;
		if (itemArray != null) {
			for (int i = 0; i < itemArray.length && resultado == null; i++) {
				if (itemArray[i] != null
						&& itemArray[i].getIdentifier().equals(identifier))
					resultado = itemArray[i];
				else if (itemArray[i].getItem() != null)
					resultado = obtenerItem(itemArray[i].getItem(), identifier);
			}
		}
		return resultado;
	}

	public Organization obtenerOrganization(String identifier)
			throws ParseadorException {
		Organization resultado = null;
		check();
		Organizations organizations = manifest.getOrganizations();
		Organization[] organizationArray = null;
		if (organizations != null)
			organizationArray = organizations.getOrganization();
		if (organizations != null && organizationArray != null) {
			for (int i = 0; i < organizationArray.length && resultado == null; i++) {
				if (organizationArray[i].getIdentifier().equals(identifier))
					resultado = organizationArray[i];
			}
		}
		return resultado;
	}

	private Grp_any getGrp_Any(Object obj) throws Exception {
		Grp_any resultado = null;
		Method metodo = obj.getClass().getMethod("getGrp_any", new Class[] {});
		Object grpObj = metodo.invoke(obj, new Object[] {});
		if (grpObj instanceof Grp_any)
			resultado = (Grp_any) grpObj;
		return resultado;
	}

	private void setGrp_Any(Object obj, Grp_any grpAny) throws Exception {

		Method metodo = obj.getClass().getMethod("setGrp_any",
				new Class[] { Grp_any.class });
		metodo.invoke(obj, new Object[] { grpAny });
	}

	public void setSequencing(String identificador, Sequencing seq)
			throws ParseadorException {
		try {
			check();
			Object elemento = obtenerElemento(identificador);
			if (elemento == null) {
				throw new ParseadorException("El elemento " + identificador
						+ " no se encuentra en el manifiesto "
						+ manifest.getIdentifier());
			} else {
				Grp_any grpAny = getGrp_Any(elemento);
				if (grpAny == null)
					grpAny = new Grp_any();
				Object[] array = grpAny.getAnyObject();
				boolean flag = false;
				for (int i = 0; i < array.length && !flag; i++) {
					if (array[i] instanceof Sequencing) {
						array[i] = seq;
						flag = true;
					}
				}
				// Si no existia, lo añado
				if (!flag)
					grpAny.addAnyObject(seq);
				// Inserto en el grpAny
				else
					grpAny.setAnyObject(array);
				setGrp_Any(elemento, grpAny);

			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(
					"Error al insertar secuencia en " + identificador);
			throw new ParseadorException("Error al insertar secuencia en "
					+ identificador, e);
		}
	}

	/**
	 * 
	 * Obtiene el objeto Sequencing asociado al objeto con un identificador
	 * dado. La secuencia se busca en organizaciones e items.
	 * 
	 * @param identificador
	 * @return
	 */
	public Sequencing obtenerSequencing(String identificador)
	throws ParseadorException {
		Sequencing resultado = null;
		check();
		Object[] grpAny = null;
		Object obj = obtenerElemento(identificador);
		if (obj instanceof Organization) {
			Organization org = (Organization)obj;
			if (org.getGrp_any() != null) {
				grpAny = org.getGrp_any().getAnyObject();
			}
		} else if (obj instanceof Item) {
			Item item = (Item)obj;
			if (item.getGrp_any() != null)
				grpAny = item.getGrp_any().getAnyObject();
		} else {
			logger.error(
					"El objeto " + identificador + " no existe.");
		}
		if (grpAny != null) {
			for (int i = 0; i < grpAny.length && resultado == null; i++) {
				if (grpAny[i] instanceof Sequencing) {
					resultado = (Sequencing) grpAny[i];
				}
			}
		}
		return resultado;
	}
	
	public void setPresentation(String identificador, Presentation pre)
	throws ParseadorException {
		try {
			check();
			Object elemento = obtenerElemento(identificador);
			if (elemento == null) {
				throw new ParseadorException("El elemento " + identificador
						+ " no se encuentra en el manifiesto "
						+ manifest.getIdentifier());
			} else {
				boolean flag = false;
				Object[] array =null;
				Grp_any grpAny = getGrp_Any(elemento);
				if (grpAny == null && pre != null){
					grpAny = new Grp_any();
				}
				if(grpAny !=null){
					array = grpAny.getAnyObject();
					ArrayList aList = new ArrayList();
					for (int i = 0; i < array.length; i++) {
						if (array[i] instanceof Presentation) {	
							array[i] = pre;
							flag = true;
						}else {
							aList.add(array[i]);
						}
					}
					if(pre ==null)
						array = aList.toArray(new Object[aList.size()]);
				}
				// Si no existia, lo añado
				if (!flag && pre != null){
					grpAny.addAnyObject(pre);
					setGrp_Any(elemento, grpAny);	
				}
				// Inserto en el grpAny
				if (flag){
					grpAny.setAnyObject(array);
					setGrp_Any(elemento, grpAny);
				}

			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(
					"Error al insertar Presentation en " + identificador);
			throw new ParseadorException("Error al insertar Presentation en "
					+ identificador, e);
		}
	}

	public void setDataFromLMS(String identificador, DataFromLMS dat)
	throws ParseadorException {
		try {
			check();
			Object elemento = obtenerElemento(identificador);
			if (elemento == null) {
				throw new ParseadorException("El elemento " + identificador
						+ " no se encuentra en el manifiesto "
						+ manifest.getIdentifier());
			} else {
				boolean flag = false;
				Object[] array =null;
				Grp_any grpAny = getGrp_Any(elemento);
				if (grpAny == null && dat != null){
					grpAny = new Grp_any();
				}
				if(grpAny !=null){
					array = grpAny.getAnyObject();
					ArrayList aList = new ArrayList();
					for (int i = 0; i < array.length; i++) {
						if (array[i] instanceof DataFromLMS) {	
							array[i] = dat;
							flag = true;
						}else {
							aList.add(array[i]);
						}
					}
					if(dat ==null)
						array = aList.toArray(new Object[aList.size()]);
				}
				// Si no existia, lo añado
				if (!flag && dat != null){
					grpAny.addAnyObject(dat);
					setGrp_Any(elemento, grpAny);	
				}
				// Inserto en el grpAny
				if (flag){
					grpAny.setAnyObject(array);
					setGrp_Any(elemento, grpAny);
				}

			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(
					"Error al insertar DataFromLMS en " + identificador);
			throw new ParseadorException("Error al insertar DataFromLMS en "
					+ identificador, e);
		}
	}
		
	public void setTimeLimitAction(String identificador, TimeLimitAction time)
	throws ParseadorException {
		try {
			check();
			Object elemento = obtenerElemento(identificador);
			if (elemento == null) {
				throw new ParseadorException("El elemento " + identificador
						+ " no se encuentra en el manifiesto "
						+ manifest.getIdentifier());
			} else {
				boolean flag = false;
				Object[] array =null;
				Grp_any grpAny = getGrp_Any(elemento);
				if (grpAny == null && time != null){
					grpAny = new Grp_any();
				}
				if(grpAny !=null){
					array = grpAny.getAnyObject();
					ArrayList aList = new ArrayList();
					for (int i = 0; i < array.length; i++) {
						if (array[i] instanceof TimeLimitAction) {	
							array[i] = time;
							flag = true;
						}else {
							aList.add(array[i]);
						}
					}
					if(time ==null)
						array = aList.toArray(new Object[aList.size()]);
				}
				// Si no existia, lo añado
				if (!flag && time != null){
					grpAny.addAnyObject(time);
					setGrp_Any(elemento, grpAny);	
				}
				// Inserto en el grpAny
				if (flag){
					grpAny.setAnyObject(array);
					setGrp_Any(elemento, grpAny);
				}

			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(
					"Error al insertar TimeLimitAction en " + identificador);
			throw new ParseadorException("Error al insertar TimeLimitAction en "
					+ identificador, e);
		}
	}
	
	public void setCompletionThreshold(String identificador, CompletionThreshold comp)
	throws ParseadorException {
		try {
			check();
			Object elemento = obtenerElemento(identificador);
			if (elemento == null) {
				throw new ParseadorException("El elemento " + identificador
						+ " no se encuentra en el manifiesto "
						+ manifest.getIdentifier());
			} else {
				boolean flag = false;
				Object[] array =null;
				Grp_any grpAny = getGrp_Any(elemento);
				if (grpAny == null && comp != null){
					grpAny = new Grp_any();
				}
				if(grpAny !=null){
					array = grpAny.getAnyObject();
					ArrayList aList = new ArrayList();
					for (int i = 0; i < array.length; i++) {
						if (array[i] instanceof CompletionThreshold) {	
							array[i] = comp;
							flag = true;
						}else {
							aList.add(array[i]);
						}
					}
					if(comp ==null)
						array = aList.toArray(new Object[aList.size()]);
				}
				// Si no existia, lo añado
				if (!flag && comp != null){
					grpAny.addAnyObject(comp);
					setGrp_Any(elemento, grpAny);	
				}
				// Inserto en el grpAny
				if (flag){
					grpAny.setAnyObject(array);
					setGrp_Any(elemento, grpAny);
				}

			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(
					"Error al insertar CompletionThreshold en " + identificador);
			throw new ParseadorException("Error al insertar CompletionThreshold en "
					+ identificador, e);
		}
	}
	
	private void eliminarReferenciaRecursoItem(Item arrayItem[],
			String identificador_recurso) {
		if (identificador_recurso == null)
			throw new NullPointerException("identificador_recurso");
		for (int i = 0; i < arrayItem.length; i++) {
			Item arrayItemRec[] = arrayItem[i].getItem();
			if (arrayItemRec.length == 0) {
				if (identificador_recurso.equals(arrayItem[i]
						.getIdentifierref()))
					arrayItem[i].setIdentifierref(null);
			} else {
				eliminarReferenciaRecursoItem(arrayItemRec,
						identificador_recurso);
			}
		}

	}

	public void eliminarRecursos(String identificador) {

		// PRIMERO: elimino las dependencias de los registros
		Resources resources = manifest.getResources();
		Resource arrayRec[] = null;

		if (resources != null)
			arrayRec = resources.getResource();
		if (arrayRec != null) {

			for (int i = 0; i < arrayRec.length; i++) {
				boolean encontrado = false;
				for (int h = 0; h < arrayRec[i].getDependency().length
						&& !encontrado; h++) {
					if (identificador.equals(arrayRec[i].getDependency(h)
							.getIdentifierref())) {
						arrayRec[i].removeDependencyAt(h);
						encontrado = true;
					}
				}
			}
		}

		// AHORA: elimino las dependencias de los grupos
		Organizations organizations = manifest.getOrganizations();
		Organization arrayOrg[] = null;
		Item arrayItem[] = null;
		if (organizations != null)
			arrayOrg = organizations.getOrganization();
		if (arrayOrg != null) {
			for (int j = 0; j < arrayOrg.length; j++) {
				arrayItem = arrayOrg[j].getItem();
				eliminarReferenciaRecursoItem(arrayItem, identificador);
			}

		}
	}

	public Resource obtenerResource(String identificador)
			throws ParseadorException {
		Resource resultado = null;
		check();
		Resources resources = manifest.getResources();
		Resource[] array = null;
		if (resources != null)
			array = resources.getResource();
		if (array != null) {
			for (int i = 0; i < array.length && resultado == null; i++) {
				if (identificador.equals(array[i].getIdentifier()))
					resultado = array[i];
			}
		}
		return resultado;
	}

	/**
	 * @param identificador
	 * @param href
	 * @return
	 */
	public Object obtenerElemento(String identificador, String href)
			throws ParseadorException {
		Object resultado = null;

		Object elemento = obtenerElemento(identificador);
		if (elemento instanceof Resource && href != null) {
			Resource res = (Resource) elemento;
			File[] ficheros = res.getFile();
			for (int i = 0; i < ficheros.length && resultado == null; i++) {
				if (ficheros[i].getHref().equals(href)) {
					resultado = ficheros[i];
				}
			}
		} else if (elemento != null) {
			resultado = elemento;
		} else {
			Logger.getLogger(this.getClass()).warn(
					"No existe el elemento " + identificador);
		}

		return resultado;
	}

	public Object obtenerElemento(String identificador)
			throws ParseadorException {
		Object resultado = null;
		check();
		// Examina el manifest en busca del elemento (manifest,organization,item
		// o resource) con identifier=identificador
		if (manifest.getIdentifier().equals(identificador))
			resultado = manifest;
		if (resultado == null)
			resultado = obtenerOrganization(identificador);
		if (resultado == null)
			resultado = obtenerResource(identificador);
		if (resultado == null)
			resultado = obtenerItem(identificador);
		// Si no he encontrado el identificador, busco en los submanifiestos
		if (resultado == null) {
			Manifest[] submanifiestos = manifest.getManifest();
			if (submanifiestos != null) {
				for (int i = 0; i < submanifiestos.length && resultado == null; i++) {
					ManifestAgrega subManifestAgrega = new ManifestAgrega(
							submanifiestos[i]);
					resultado = subManifestAgrega
							.obtenerElemento(identificador);
				}
			}
		}

		return resultado;
	}

	private Metadata obtenerMetadata(Object obj) throws ParseadorException {
		Metadata resultado = null;
		try {
			Class clase = obj.getClass();
			Method metodoGet = clase.getMethod("getMetadata", new Class[] {});
			Object retorno = metodoGet.invoke(obj, new Object[] {});
			if (retorno instanceof Metadata)
				resultado = (Metadata) retorno;
			else
				Logger.getLogger(this.getClass()).debug(
						"El objeto " + obj + " no tiene Metadata");
		} catch (SecurityException e) {
			throw new ParseadorException(
					"Error al invocar getMetadata() sobre " + obj, e);
		} catch (NoSuchMethodException e) {
			throw new ParseadorException("El objeto " + obj
					+ " no tiene metodo getMetadata", e);
		} catch (IllegalAccessException e) {
			throw new ParseadorException(
					"Error al invocar getMetadata() sobre " + obj, e);
		} catch (InvocationTargetException e) {
			throw new ParseadorException(
					"Error al invocar getMetadata() sobre " + obj, e);
		}
		return resultado;
	}

	private void setMetadata(Object obj, Metadata metadata)
			throws ParseadorException {
		Metadata resultado = null;
		try {
			Class clase = obj.getClass();
			Method metodoGet = clase.getMethod("setMetadata",
					new Class[] { Metadata.class });
			Object retorno = metodoGet.invoke(obj, new Object[] { metadata });

		} catch (SecurityException e) {
			throw new ParseadorException(
					"Error al invocar setMetadata() sobre " + obj
							+ " con argumento " + metadata, e);
		} catch (NoSuchMethodException e) {
			throw new ParseadorException("El objeto " + obj
					+ " no tiene metodo setMetadata", e);
		} catch (IllegalAccessException e) {
			throw new ParseadorException(
					"Error al invocar setMetadata() sobre " + obj
							+ " con argumento " + metadata, e);
		} catch (InvocationTargetException e) {
			throw new ParseadorException(
					"Error al invocar setMetadata() sobre " + obj
							+ " con argumento " + metadata, e);
		}
	}

	private Object obtenerItemPadre(Item[] itemArray, String identifier,
			Object padre) {
		Object resultado = null;
		if (itemArray != null) {
			for (int i = 0; i < itemArray.length && resultado == null; i++) {
				if (itemArray[i] != null
						&& itemArray[i].getIdentifier().equals(identifier))
					resultado = padre;
				else if (itemArray[i].getItem() != null)
					resultado = obtenerItemPadre(itemArray[i].getItem(),
							identifier, itemArray[i]);
			}
		}
		return resultado;
	}

	public Object buscarPadre(String identificador) {
		Object resultado = null;

		Organization[] orgs = manifest.getOrganizations().getOrganization();
		if (orgs != null) {
			for (int i = 0; i < orgs.length && resultado == null; i++) {
				resultado = obtenerItemPadre(orgs[i].getItem(), identificador,
						orgs[i]);
			}
		}
		return resultado;
	}

	public void eliminarItem(String identificador) throws ParseadorException {
		check();
		Object padre = buscarPadre(identificador);
		// if (padre == null) {
		if (padre instanceof Organization) {
			Organization org = (Organization) padre;
			org.removeItem(obtenerItem(identificador));
		} else {
			Item itemABorrar = obtenerItem(identificador);
			try {
				Method metodo = padre.getClass().getMethod("removeItem",
						new Class[] { Item.class });
				metodo.invoke(padre, new Object[] { itemABorrar });
			} catch (Exception e) {
				Logger.getLogger(this.getClass()).error(
						"Error al eliminar el item " + identificador
								+ "del objeto " + padre, e);
			}
		}
	}

	/**
	 * 
	 * Obtiene (si existe) el objeto Lom asociado al Metadata del elemento
	 * 'identificador'
	 * 
	 * @param identificador
	 * @param href
	 * @return
	 * @throws ParseadorException
	 */
	public Lom obtenerLom(String identificador, String href)
			throws ParseadorException {
		Lom lom = null;
		check();
		Object elemento = obtenerElemento(identificador, href);
		if (elemento == null) {
			throw new ParseadorException("El elemento " + identificador
					+ " no se encuentra en el manifiesto "
					+ manifest.getIdentifier());
		} else {
			Metadata metadata = obtenerMetadata(elemento);
			if (metadata != null && metadata.getGrp_any() != null
					&& metadata.getGrp_any().getAnyObject() != null) {
				Object[] array = metadata.getGrp_any().getAnyObject();
				for (int i = 0; i < array.length && lom == null; i++) {
					if (array[i] instanceof Lom)
						lom = (Lom) array[i];
					else if (array[i] instanceof Location) {
						// Tiene un metadato externo. Examinar para ver si es
						// LOM-ES. En ese caso, parsear y devolver objeto LOM.
						// Comprobación LOM vs. LOM-ES: Campo metaMetadata -> metadataSchema like lomes-v1.0
						// Usar para localizar el XML la ruta base del manifiesto (manifest.getManifestBasePath())
						String location = ((Location)array[i]).getContent();
						String fullPath = manifest.getManifestBasePath() + "/" + location;
						if(logger.isDebugEnabled()) logger.debug("Examinando adlcp:location = " + location + " (ruta = " + fullPath + ")");
						// Si el fichero no es Lomes, la carga devuelve null,
						// por lo que la busqueda continúa.
						lom = cargaLomesExterno(fullPath);
					}
				}
			}
		}
		return lom;
	}

	private Lom cargaLomesExterno(String path) {
		Lom result = null;
		try {
			LomESDao dao = SpringBootstrapContextLoader.getLomesDao();
			result = dao.parsearLom(path);
		} catch (Exception e) {
			logger.warn("No se ha podido parsear el metadato " + path + ". No es de tipo Lom o el xml tiene errores (causa: " + e.getMessage() + ")");
			if(logger.isDebugEnabled()) logger.debug(e);
		}
		if(result!=null) {
			// Comprobar si es LomES o Lom IEEE
			MetadataSchema[] esquemas = result.getMetaMetadata().getGroupMetaMetadataMetaMetadata().getMetadataSchema();
			if(esquemas!=null && esquemas.length>0) {
				boolean flag = false;
				for(int i=0;i<esquemas.length && !flag;i++) {
					if("lom-esv1.0".equalsIgnoreCase(esquemas[i].getGroupMetadataSchemaMetadataSchema().getContent().trim().replaceAll(" ", ""))) {
						// Es un LomES valido
						flag = true;
					}
				}
				if(!flag) {
					logger.warn("Lom rechazado. No es conforme al esquema Lom-ES");
					result = null;
				}
			} else {
				// Rechazo el metadato por no tener declarado el campo 3.3
				result = null;
			}
		}
		return result;
	}
	
	/**
	 * Inserta el objeto Lom en el elemento 'identificador'. Si ya existe
	 * previamente un objeto Lom, lo reemplaza.
	 * 
	 * @param identificador
	 * @param
	 * @param lom
	 */
	public void setLom(String identificador, String href, Lom lom)
			throws ParseadorException {
		check();
		Object elemento = obtenerElemento(identificador, href);
		if (elemento == null) {
			throw new ParseadorException("El elemento " + identificador
					+ " no se encuentra en el manifiesto "
					+ manifest.getIdentifier());
		} else {
			Metadata metadata = obtenerMetadata(elemento);
			/*
			 * ¿Tiene Lom previo?
			 */
			if (obtenerLom(identificador, href) == null) {
				/*
				 * Introducir Lom en Metadata (respetando el Metadata si ya
				 * existe
				 */
				if (metadata == null)
					metadata = new Metadata();
				if (metadata.getGrp_any() == null)
					metadata.setGrp_any(new Grp_any());
				if (metadata.getGrp_any().getAnyObject() == null)
					metadata.getGrp_any().setAnyObject(new Object[] { lom });
				else
					metadata.getGrp_any().addAnyObject(lom);
			} else {
				/*
				 * Reemplazar Lom existente
				 * 20080416 - Si el Lom existente es externo, hay que mantenerlo como externo. Se usa LomesDao para escribir el metadato.
				 */
				Object[] array = metadata.getGrp_any().getAnyObject();
				boolean continuar = true;
				for (int i = 0; i < array.length && continuar; i++) {
					if (array[i] instanceof Lom) {
						array[i] = lom;
						continuar = false;
					} else if(array[i] instanceof Location) {
						/*
						 * Compruebo si este location corresponde a un LOMES y si es así, lo sobreescribo.
						 */
						String location = ((Location)array[i]).getContent();
						String fullPath = manifest.getManifestBasePath() + "/" + location;
						if(cargaLomesExterno(fullPath)!=null) {
							continuar=false;
							LomESDao dao = SpringBootstrapContextLoader.getLomesDao();
							if(logger.isDebugEnabled()) logger.debug("Escribiendo metadato " + fullPath);
							try {
								dao.escribirLom(lom, fullPath);
							} catch (Exception e) {
								String message = "Error al escribir metadato lomes " + fullPath + ": " + e.getMessage(); 
								logger.error(message);
								if(logger.isDebugEnabled()) logger.debug(e);
								throw new ParseadorException(message,e);
							}
						} else {
							logger.warn("El path de metadato " + fullPath + " no corresponde a un metadato LOMES");
						}
					}
				}
				metadata.getGrp_any().setAnyObject(array);
			}
			/*
			 * Insertamos el Metadata en el objeto
			 */
			setMetadata(elemento, metadata);
		}
	}

	private void check() throws ParseadorException {
		if (manifest == null) {
			Logger
					.getLogger(this.getClass())
					.error(
							"ManifestAgrega no ha sido inicializado con un objeto Manifest");
			throw new ParseadorException(
					"ManifestAgrega no ha sido inicializado con un objeto Manifest");
		}
	}

	/**
	 * Resetea los Ids de Resources y Manifests anidados guardando en un mapa
	 * las relaciones entre viejo ID y nuevo ID.
	 * 
	 * @return El mapa con las relaciones
	 * @throws ParseadorException
	 */
	private HashMap reseteaReferenciables() throws ParseadorException {
		HashMap referenciables = new HashMap();
		// Comprobando recursos
		Resource[] recursos = this.manifest.getResources().getResource();
		for (int i = 0; i < recursos.length; i++) {

			String nuevoId = PodeUUIDGenerator.getRecursoUUID(generarSemilla());
			if (logger.isDebugEnabled())
				logger.debug("Cambiando " + recursos[i].getIdentifier()
						+ " por " + nuevoId);
			referenciables.put(recursos[i].getIdentifier(), nuevoId);
			recursos[i].setIdentifier(nuevoId);
		}
		// Iterando en los submanifiestos para cambiar las Ids de submanifiestos
		// y sus recursos
		Manifest[] submanifiestos = this.manifest.getManifest();
		if (submanifiestos != null) {
			if (logger.isDebugEnabled())
				logger
						.debug("Iterando en los " + submanifiestos.length
								+ " submanifiestos de "
								+ this.manifest.getIdentifier());
			for (int i = 0; i < submanifiestos.length; i++) {
				String nuevoId = PodeUUIDGenerator
						.getSubmanifiestoUUID(generarSemilla());
				if (logger.isDebugEnabled())
					logger.debug("Cambiando "
							+ submanifiestos[i].getIdentifier() + " por "
							+ nuevoId);
				referenciables.put(submanifiestos[i].getIdentifier(), nuevoId);
				submanifiestos[i].setIdentifier(nuevoId);
				if (logger.isDebugEnabled())
					logger.debug("Iterando en el submanifiesto "
							+ submanifiestos[i].getIdentifier());
				ManifestAgrega ma = new ManifestAgrega(submanifiestos[i]);
				HashMap refSubmanifiesto = ma.reseteaReferenciables();
				if (logger.isDebugEnabled())
					logger.debug("Recuperado el mapa de referenciables de "
							+ submanifiestos[i] + ": Valores: "
							+ refSubmanifiesto);
				referenciables.putAll(refSubmanifiesto);
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("Referenciables de " + this.manifest.getIdentifier()
					+ " recuperados. Valor de retorno : " + referenciables);
		return referenciables;
	}

	/**
	 * Resetea Organizations e Items y modifica todos los atributos idRef a
	 * partir del mapa de relaciones.
	 * 
	 * @param relaciones
	 */
	private void resetearElementosConIdRef(HashMap relaciones) {
		// Reseteo las idRef de los recursos (dependencias)
		for (int i = 0; i < manifest.getResources().getResourceCount(); i++) {
			if (logger.isDebugEnabled()
					&& manifest.getResources().getResource(i).getDependency() != null
					&& manifest.getResources().getResource(i).getDependency().length > 0)
				logger
						.debug("Refrescando los idRef de las dependencias del recurso "
								+ manifest.getResources().getResource(i)
										.getIdentifier());
			Dependency[] dependencias = manifest.getResources().getResource(i)
					.getDependency();
			for (int j = 0; dependencias != null && j < dependencias.length; j++) {
				String nuevoIdRef = (String) relaciones.get(dependencias[j]
						.getIdentifierref());
				if (logger.isDebugEnabled())
					logger.debug("Cambiando idRef de dependencia : "
							+ dependencias[j].getIdentifierref() + " por "
							+ nuevoIdRef);
				if (nuevoIdRef == null)
					logger.error("Error al obtener la nueva idRef del recurso "
							+ manifest.getResources().getResource(i)
									.getIdentifier() + ". Viejo idRef : "
							+ dependencias[j].getIdentifierref());
				dependencias[j].setIdentifierref(nuevoIdRef);
			}
		}
		if (logger.isDebugEnabled())
			logger
					.debug("Cambiados los idRef de las dependencias de recursos.");
		// Reseteo las Organizaciones e Items (idRef de organizacion principal
		// inclusive).
		Organizations organizations = manifest.getOrganizations();
		for (int i = 0; i < organizations.getOrganizationCount(); i++) {
			if (logger.isDebugEnabled())
				logger.debug("Reseteando organizacion "
						+ organizations.getOrganization(i).getIdentifier());
			String nuevoID = PodeUUIDGenerator
					.getOrganizacionUUID(generarSemilla());
			if (organizations.getDefault().equals(
					organizations.getOrganization(i).getIdentifier())) {
				if (logger.isDebugEnabled())
					logger.debug("Cambiando idRef organizacion por defecto : "
							+ organizations.getDefault() + " por " + nuevoID);
				organizations.setDefault(nuevoID);
			}
			if (logger.isDebugEnabled())
				logger.debug("Cambiando ID de organizacion "
						+ organizations.getOrganization(i).getIdentifier()
						+ " por " + nuevoID);
			organizations.getOrganization(i).setIdentifier(nuevoID);
			// Reseteo los Items de la organizacion
			if (logger.isDebugEnabled())
				logger.debug("Reseteo los Items de la organizacion...");
			resetearItems(relaciones, organizations.getOrganization(i)
					.getItem());
		}
		// Iteramos dentro de los submanifiestos
		for (int i = 0; i < manifest.getManifestCount(); i++) {
			if (logger.isDebugEnabled())
				logger
						.debug("Iterando dentro del submanifiesto "
								+ manifest.getManifest(i).getIdentifier()
								+ " para cambiar organizations, items y dependencias de recurso.");
			ManifestAgrega ma = new ManifestAgrega(manifest.getManifest(i));
			ma.resetearElementosConIdRef(relaciones);
		}
	}

	/**
	 * Reseteo los IDs de los Items dependientes de la organizacion. Los idRef
	 * se renuevan en base a las relaciones descritas en el mapa. El parametro
	 * org es un referencia, por lo que los cambios se reflejan en el ambito que
	 * llama a este metodo.
	 * 
	 * @param relaciones
	 * @param org
	 */
	private void resetearItems(HashMap relaciones, Item[] item) {
		if (item != null) {
			for (int i = 0; i < item.length; i++) {
				String nuevoId = PodeUUIDGenerator
						.getItemUUID(generarSemilla());
				if (logger.isDebugEnabled())
					logger.debug("Nuevo id para Item generado : " + nuevoId);
				String nuevoIdRef = null;
				if (item[i].getIdentifierref() != null) {
					nuevoIdRef = (String) relaciones.get(item[i]
							.getIdentifierref());
					if (logger.isDebugEnabled())
						logger.debug("Nuevo idRef obtenido para Item "
								+ item[i].getIdentifier() + " es " + nuevoIdRef
								+ " (viejo idRef : "
								+ item[i].getIdentifierref() + ").");
					if (nuevoIdRef == null)
						logger.error("Error al obtener el nuevo idRef para "
								+ item[i].getIdentifierref());
				}
				if (logger.isDebugEnabled())
					logger.debug("Cambiando id " + item[i].getIdentifier()
							+ " por " + nuevoId);
				item[i].setIdentifier(nuevoId);
				if (logger.isDebugEnabled())
					logger
							.debug("Cambiando idRef "
									+ item[i].getIdentifierref() + " por "
									+ nuevoIdRef);
				item[i].setIdentifierref(nuevoIdRef);
				// Itero sobre los hijos
				if (item[i].getItemCount() > 0) {
					if (logger.isDebugEnabled())
						logger.debug("Iterando en los hijos de item "
								+ item[i].getIdentifier());
					resetearItems(relaciones, item[i].getItem());
				}
			}
		}
	}

	private String generarSemilla() {
		return String.valueOf(java.lang.Math.random());
	}

	/**
	 * Cambia todos los identificadores de los elementos del Manifest (a
	 * excepcion del identificador del propio manifest) manteniendo la
	 * coherencia de los idRefs.
	 */
	public void resetearIds() throws ParseadorException {
		// referenciables: Almacena los ids de aquellos elementos referenciables
		// por Items (i.e.
		// Resources y Manifests agregados) junto a los nuevos ids asignados. La
		// key es el viejo identificador y el valor el nuevo.
		HashMap referenciables = null;
		check();
		if (logger.isDebugEnabled())
			logger.debug("Comenzando el reseteo de identificadores de "
					+ this.manifest.getIdentifier());
		referenciables = reseteaReferenciables();
		if (logger.isDebugEnabled())
			logger.debug("Reseteados los elementos referenciables de "
					+ manifest.getIdentifier() + ". Valores del mapa : "
					+ referenciables);
		if (logger.isDebugEnabled())
			logger.debug("Comenzando el reseteo de Organizations e Items...");
		resetearElementosConIdRef(referenciables);
		if (logger.isDebugEnabled())
			logger
					.debug("Manifest " + manifest.getIdentifier()
							+ " reseteado.");
	}

	public Lom[] recuperarLomesAsArray() throws ParseadorException {
		Lom[] resultado = null;
		Collection col = recuperarLomes();
		if (col == null)
			resultado = new Lom[] {};
		else
			resultado = (Lom[]) col.toArray(new Lom[col.size()]);
		return resultado;
	}

	public Collection recuperarLomes() throws ParseadorException {
		Collection resultado = new ArrayList();
		check();
		Collection identificadores = recuperaManifestIDs(this.manifest);
		Lom lom = null;
		for(Iterator it = identificadores.iterator(); it.hasNext();) {
			ParIdentificadorHref parId = (ParIdentificadorHref)it.next();
			lom = obtenerLom(parId.getIdentifier(), parId.getHref());
			if(lom!=null) {
				if(logger.isDebugEnabled()) logger.debug("Lom recuperado para " + parId.getIdentifier() + " href = " + parId.getHref());
				resultado.add(lom);
			}
		}
		return resultado;
	}
	
	public HashMap recuperarLomesMap() throws ParseadorException {
		HashMap result = new HashMap();
		check();

		/*
		 * Inspecciono el manifest para recuperar todos los identificadores de
		 * los elementos catalogables (Manifest, Organization, Item, Resource,
		 * File)
		 */
		Collection identificadores = recuperaManifestIDs(this.manifest);
		Lom lom = null;
		
		for(Iterator it = identificadores.iterator(); it.hasNext();) {
			ParIdentificadorHref parId = (ParIdentificadorHref)it.next();
			lom = obtenerLom(parId.getIdentifier(), parId.getHref());
			if(lom!=null) {
				if(logger.isDebugEnabled()) logger.debug("Lom recuperado para " + parId.getIdentifier() + " href = " + parId.getHref());
				result.put(parId.getIdentifier(),lom);
			}
		}
		if(logger.isDebugEnabled()) logger.debug("Recuperados " + result.size() + " loms de " + manifest.getIdentifier());
		return result;
	}
	
	public String[] recuperaManifestIDs() {
		return (String[])recuperaManifestIDs(manifest).toArray(new String[]{});
	}
	
	private Collection recuperaManifestIDs(Manifest manifest) {
		Collection resultado = null;
		if(manifest!=null) {
			resultado = new ArrayList();
			if(logger.isDebugEnabled()) logger.debug("Identificador manifest recuperado " + manifest.getIdentifier());
			resultado.add(new ParIdentificadorHref(manifest.getIdentifier()));
			if(logger.isDebugEnabled()) logger.debug("Inspecciono las organizaciones");
			for(int i=0;i<manifest.getOrganizations().getOrganizationCount();i++) {
				if(logger.isDebugEnabled()) logger.debug("Identificador organization recuperado " + manifest.getOrganizations().getOrganization(i).getIdentifier());
				resultado.add(new ParIdentificadorHref(manifest.getOrganizations().getOrganization(i).getIdentifier()));
				if(manifest.getOrganizations().getOrganization(i).getItemCount()>0) {
					if(logger.isDebugEnabled()) logger.debug("Inspeccionando Items hijos de " + manifest.getOrganizations().getOrganization(i).getIdentifier());
					resultado.addAll(recuperaItemIDs(manifest.getOrganizations().getOrganization(i).getItem()));
				}
			}
			if(logger.isDebugEnabled()) logger.debug("Inspecciono los resources");
			for(int i=0;i<manifest.getResources().getResourceCount();i++) {
				if(logger.isDebugEnabled()) logger.debug("Identificador resource recuperado " + manifest.getResources().getResource(i).getIdentifier());
				resultado.add(new ParIdentificadorHref(manifest.getResources().getResource(i).getIdentifier()));
				if(logger.isDebugEnabled()) logger.debug("Inspecciono files de recurso " + manifest.getResources().getResource(i).getIdentifier());
				if(manifest.getResources().getResource(i).getFile()!=null) {
					for(int j=0;j<manifest.getResources().getResource(i).getFile().length;j++) {
						File file = manifest.getResources().getResource(i).getFile(j);
						if(logger.isDebugEnabled()) logger.debug("Identificador file recuperado " + manifest.getResources().getResource(i).getIdentifier() + " : " + file.getHref());
						resultado.add(new ParIdentificadorHref(manifest.getResources().getResource(i).getIdentifier(),file.getHref()));
					}
				}
			}
			if(logger.isDebugEnabled()) logger.debug("Inspecciono los submanifiestos");
			for(int i=0;i<manifest.getManifestCount();i++) {
				resultado.addAll(recuperaManifestIDs(manifest.getManifest(i)));
			}
		} else {
			logger.error("Manifest nulo en la recuperacion de submanifiestos");
			resultado = new ArrayList();
		}
		return resultado;
	}
	
	private Collection recuperaItemIDs(Item[] items) {
		Collection resultado = new ArrayList();
		for(int i=0;i<items.length;i++) {
			if(logger.isDebugEnabled()) logger.debug("Identificador item recuperado " + items[i].getIdentifier());
			resultado.add(new ParIdentificadorHref(items[i].getIdentifier()));
			if(items[i].getItemCount()>0) {
				if(logger.isDebugEnabled()) logger.debug("Inspeccionando Items hijos de " + items[i].getIdentifier());
				resultado.addAll(recuperaItemIDs(items[i].getItem()));
			}
		}
		return resultado;
	}
	
	/**
	 * Bean interno para manejar pares identifer-href (identificador combinado
	 * para Lom de File)
	 * 
	 * @author fjespino
	 * 
	 */
	private class ParIdentificadorHref {
		private String identifier = null;
		private String href = null;
		
		public ParIdentificadorHref(){}
		public ParIdentificadorHref(String identificador) {
			this.identifier=identificador;
		}
		public ParIdentificadorHref(String identificador, String href) {
			this.identifier=identificador;
			this.href=href;
		}
		public String getIdentifier() {return identifier;}
		public void setIdentifier(String identifier) {this.identifier=identifier;}
		public String getHref() {return href;}
		public void setHref(String href) {this.href=href;}
		
	}
}
