/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.empaquetador.negocio.servicio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.utilidades.OrganizationStringComparator;
import es.pode.empaquetador.negocio.utilidades.ResourceStringComparator;
import es.pode.empaquetador.negocio.utilidades.Utilidades;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.castor.File;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Metadata;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Organizations;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.castor.Resources;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.soporte.uuid.PodeUUIDGenerator;
import es.pode.validador.negocio.servicio.ValidaVO;

/**
 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService
 */

public class SrvEmpaquetadorBasicoServiceImpl extends
		es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoServiceBase {
	private CacheEmpaquetacion cacheEmpaquetacion = null;

	private Utilidades utilidades = null;

	private static Logger logger = Logger
			.getLogger(SrvEmpaquetadorBasicoServiceImpl.class);
	
	
	/**
	 * Editar ODE actual. Llama internamente a la operación editarOde del
	 * servicio GestorManifest y a continuación realiza aplanado de
	 * organizaciones y submanifiestos que pudiera haber.
	 * 
	 * @param idOde
	 *            Ode que se va a editar
	 * @return Objeto VO que representa un objeto Manifest de SCORM2004
	 *         simplificado. Para mapear objetos Manifest a OdeVO y viceversa se
	 *         emplea la librería Dozer. La configuración del mapeo se define en
	 *         un fichero de configuracion de Dozer.
	 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#editarOde(java.lang.String)
	 */
	protected es.pode.empaquetador.negocio.servicio.OdeVO handleEditarOde(
			java.lang.String idOde) throws java.lang.Exception {
		getSrvGestorManifestService().editarODE(idOde);
		if (logger.isDebugEnabled())
			logger.debug("Aplando estructura de ODE " + idOde);
		// Chequea si existen multiples organizaciones y las aplana
		Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
		procesarManifestBasico(manifest,true,true,null);
		if (logger.isDebugEnabled())
			logger.debug("ODE " + idOde + " aplanado.");
		getCacheEmpaquetacion().put(idOde, manifest);
		OdeVO odeVO =(OdeVO) getBeanMapper().map(manifest, OdeVO.class); 
		ManifestAgrega ma = new ManifestAgrega(manifest);
		odeVO.setConSecuencia(ma.tieneSecuencias());
		
		return odeVO;
	}

	/**
	 * Extrae el manifest solicitado de la cache y lo transforma para su edicio
	 * con la herramienta Empaquetador Basico. Para ello: -Recorre todos los
	 * Items buscando referencias a Submanifiestos y a recursos de
	 * submanifiestos. En caso de encontrarlas los añade al item como item
	 * hijos. Los recursos de submanifiestos los transforma a recursos del
	 * manifest principal cambiando los href de los recursos para que incorporen
	 * el base.
	 * 
	 * @param manifest
	 *            Objeto manifest que se desea procesar
	 * @param resetearIDs
	 *            True: resetea todas las IDs del manifest excepto la del
	 *            manifest principal.
	 */
	private void procesarManifestBasico(Manifest manifest, boolean resetearIDs, boolean aplanaRecursos,HashMap<String, Item> aplanados)
			throws java.lang.Exception {

		ManifestAgrega ma = new ManifestAgrega(manifest);

		// Aplano las organizaciones no principales
		aplanarOrganizaciones(manifest);

		
		// Aplano todos los recursos de los submanifiestos por defecto (tanto si
		// se usan en items como si no Agrega v1.1)
		// Solo para la primera iteración. No repetir en las llamadas recursivas
		if(aplanaRecursos) aplanarRecursosDeSubmanifiestos(manifest);
		
		// Recorro la organizacion para buscar referencias a submanifiestos
		aplanarSubmanifiestos(manifest, aplanados);
		// Para evitar conflictos de IDs, se resetean todas (EXCEPTO la id del manifest!!!)
		if(resetearIDs) {
			ma.resetearIds();
		}
	}

	private void aplanarRecursosDeSubmanifiestos(Manifest manifest) {
		String base = null;
		if(logger.isDebugEnabled()) logger.debug("Aplanando recursos de submanifiestos");
		for(int i=0;i<manifest.getManifestCount();i++) {
			// Aplano el submanifiesto
			base =  manifest.getManifest(i).getBase()==null?"":manifest.getManifest(i).getBase();
			aplanarRecursosDeSubmanifiestos(manifest.getManifest(i));
			if(manifest.getManifest(i).getResources()!=null){
				for(int j=0;j<manifest.getManifest(i).getResources().getResourceCount();j++) {
					Resource resource = manifest.getManifest(i).getResources().getResource(j);
					resource = aplanaRecurso(resource,base);
					manifest.getResources().addResource(resource);
				}
			}
		}
	}
	private Resource aplanaRecurso(Resource res, String base) {
		if (res.getHref() != null) {
			// Asegurarse de que la ruta tiene un / para concatenar
			if(base!=null && base.length()>0 && !base.endsWith("/")) base = base.concat("/");
			// Compruebo si href apunta a un file (sino, es URL)
			for (int i = 0; res.getFile() != null && i < res.getFile().length; i++) {
				if (res.getFile(i).getHref().equals(res.getHref())) {
					if (logger.isDebugEnabled())
						logger.debug("Aplanado href de recurso "
								+ res.getIdentifier());
					res.setHref(base + res.getHref());
					break;
				}
			}
		}
		// Aplano los File
		for (int i = 0; res.getFile() != null && i < res.getFile().length; i++) {
			if (logger.isDebugEnabled())
				logger.debug("Aplanado file de recurso " + res.getIdentifier()
						+ " : " + res.getFile(i).getHref() + " por " + base
						+ res.getFile(i).getHref());
			res.getFile(i).setHref(base + res.getFile(i).getHref());
		}
		return res;
	}

	
	private void aplanarOrganizaciones(Manifest manifest)
	throws java.lang.Exception {
		if (logger.isDebugEnabled())
			logger
					.debug("Aplanando las organizaciones no principales del manifiesto "
							+ manifest.getIdentifier());
		Organization[] organizations = manifest.getOrganizations()
				.getOrganization();
		Organization principal = getOrganizacionPrincipal(manifest);
		for (int i = 0; i < organizations.length; i++) {
			Organization organization = organizations[i];
			if (!organization.equals(principal)) {
				if (logger.isDebugEnabled())
					logger.debug("Aplanando la organizacion no principal "
							+ organization.getIdentifier());
				Item itemTemporal = new Item();
				itemTemporal.setIdentifier(organization.getIdentifier());
				itemTemporal.setTitle(organization.getTitle());
				itemTemporal.setItem(organization.getItem());
				principal.addItem(itemTemporal);
				if (logger.isDebugEnabled())
					logger.debug("Eliminando la organizacion aplanada");
				manifest.getOrganizations().removeOrganizationAt(i);
			}
		}
	}

	private void aplanarSubmanifiestos(Manifest manifest,HashMap<String, Item> aplanados) throws Exception {
		if(aplanados==null) aplanados = new HashMap<String, Item>(10);
		Organization org = getOrganizacionPrincipal(manifest);
		if (org.getItemCount() > 0)
			aplanaSubmanifiestoEnItems(org.getItem(), manifest, aplanados);
		// Elimino los submanifiestos una vez aplanados
		manifest.setManifest(new Manifest[] {});
	}

	private void aplanaSubmanifiestoEnItems(Item[] items, Manifest manifest,
			HashMap<String, Item> aplanados) throws Exception {
		ManifestAgrega ma = new ManifestAgrega(manifest);
		for (int i = 0; i < items.length; i++) {
			if (items[i].getItemCount() > 0) {
				/*
				 * Me interno primero en los hijos ya que cuando se aplane el
				 * submanifiesto, el item pasara a tener nuevos hijos.
				 */
				if (logger.isDebugEnabled())
					logger.debug("Iterando en los hijos de "
							+ items[i].getIdentifier());
				aplanaSubmanifiestoEnItems(items[i].getItem(), manifest,
						aplanados);
			}
			// Comprueba idRef


			if (items[i].getIdentifierref() != null) {
				Object obj = ma.obtenerElemento(items[i].getIdentifierref());
				/*
				 * Si el submanifiesto ha sido aplanado antes, esta en la cache, no en el manifest. 
				 * Compruebo si es null y en ese caso busco en la cache
				 */
				if(logger.isDebugEnabled()) logger.debug("obj=" + obj + "; aplanados.containsKey("+items[i].getIdentifierref()+")="+aplanados.containsKey(items[i].getIdentifierref()));
				if ((obj instanceof Manifest) || aplanados.containsKey(items[i].getIdentifierref())) {
					if (logger.isDebugEnabled())
						logger.debug("Submanifiesto "
								+ items[i].getIdentifierref()
								+ " referenciado por "
								+ items[i].getIdentifier());
					
					Item submanifiestoAplanado = null;
					if (aplanados.containsKey(items[i].getIdentifierref())) {
						/*
						 * Para evitar keys duplicadas al terminar de aplanar,
						 * debo clonar el Item de la cache, de lo contrario, al
						 * resetear IDs se generan IDs iguales para multiples
						 * elementos (referencias).
						 */
						Item tmp = (Item) aplanados.get(items[i].getIdentifierref());
						submanifiestoAplanado = (Item) getBeanMapper().map(tmp,
								Item.class);
						if (logger.isDebugEnabled())
							logger.debug("Submanifiesto "
									+ items[i].getIdentifierref()
									+ " recuperado de la cache de aplanados");
					} else {
						Manifest submanifiesto = (Manifest) obj;
						if (logger.isDebugEnabled())
							logger.debug("Procesando submanifiesto "
									+ items[i].getIdentifierref()
									+ " antes de aplanar");
						procesarManifestBasico(submanifiesto, false,false,aplanados);
						if (logger.isDebugEnabled())
							logger.debug("Aplanando submanifiesto");
						submanifiestoAplanado = aplanarSubmanifest((Manifest) obj);
						if (logger.isDebugEnabled())
							logger
									.debug("Introduciendo submanifiesto aplanado en la cache aplanados");
						aplanados.put(items[i].getIdentifierref(),
								submanifiestoAplanado);
						
//						aplanarRecursos(manifest, submanifiesto);
					}
					if (logger.isDebugEnabled())
						logger.debug("Insertando submanifiesto aplanado "
								+ items[i].getIdentifierref() + " en Item "
								+ items[i].getIdentifier());

					/*
					 * Cambios del C27: Se ha solicitado que al previsualizar
					 * items que referencian a submanifiestos se imite la
					 * estructura creada por los LMSs clasicos: el item que
					 * referencia hereda el título de la organización principal
					 * del submanifiesto y pierde el propio.
					 * El importar de empaquetador básico debe reproducir esta estructura.
					 */
//					items[i].addItem(0, submanifiestoAplanado);
					items[i].setTitle(submanifiestoAplanado.getTitle());
					ArrayList<Item> listaTmp = new ArrayList<Item>(); 
					listaTmp.addAll(Arrays.asList(submanifiestoAplanado.getItem()));
					if(items[i].getItemCount()>0) listaTmp.addAll(Arrays.asList(items[i].getItem()));
					items[i].setItem(listaTmp.toArray(new Item[listaTmp.size()]));
					
					items[i].setIdentifierref(null);
				}
			}
			
		}
	}

	

	

	
	
	/**
	 * Parsea un submanifiesto descomprimido en temporal o presente en el
	 * repositorio y lo adapta al esquema de agregacion del básico: item con los
	 * datos de su organizacion principal del que cuelgan los items hijos y el
	 * resto de las organizaciones (como items). Los recursos del submanifiesto
	 * tambien son añadidos.
	 * 
	 * @param idOde
	 * @throws java.lang.Exception
	 */
	private Item aplanarSubmanifest(Manifest subManifest)
			throws java.lang.Exception {
		Item itemManifest = new Item();
		// Id del Item = Id de la organizacion principal
		itemManifest.setIdentifier(PodeUUIDGenerator.getItemUUID(String
				.valueOf(java.lang.Math.random())));
		itemManifest.setItem(getOrganizacionPrincipal(subManifest).getItem());
//		itemManifest.setTitle(obtenerTituloSubmanifiesto(subManifest,getOrganizacionPrincipal(subManifest).getTitle()));
		itemManifest.setTitle(getOrganizacionPrincipal(subManifest).getTitle());

		return itemManifest;
	}

	private String obtenerTituloSubmanifiesto(Manifest submanifiesto,
			String porDefecto) throws Exception {
		String resultado = null;
		ManifestAgrega ma = new ManifestAgrega(submanifiesto);
		Lom lomes = ma.obtenerLom(submanifiesto.getIdentifier(), null);
		if (lomes == null) {
			resultado = porDefecto;
		} else {
			LomAgrega la = new LomAgrega(lomes);
			String titulo = la.getGeneralAgrega().getTitulo(
					la.getMetaMetadataAgrega().getIdioma());
			if (titulo == null)
				resultado = porDefecto;
			else
				resultado = titulo;
		}
		return resultado;
	}

	/**
	 * Agrega los recursos de un imsmanifestXML y crea un item por cada recurso
	 * 
	 * @param idOde
	 * @param rutaDescomprimido
	 * @param idGrupo
	 * @param title
	 * @throws java.lang.Exception
	 */
	private void importarRecursos(java.lang.String idOde,
			LocalizadorVO localizador, String rutaDescomprimido,
			String idGrupo, String nombre) throws java.lang.Exception {
		java.io.File fRutaDescomprimido = new java.io.File(rutaDescomprimido);
		java.io.File fManifesXML = new java.io.File(fRutaDescomprimido,
				Utilidades.MANIFEST_NAME);
		// Creo la carpeta de destino (compruebo que se crea, para evitar fallo
		// de carpeta existente
		java.io.File destino = utilidades.crearCarpetaSeguro(localizador, utilidades.nombreSinExtension(nombre));
		if (logger.isDebugEnabled())
			logger.debug("Copiando recursos importados a la carpeta "
					+ destino.getPath());
		// Copio los contenidos a la carpeta de destino
		UtilesFicheros.copiar(fRutaDescomprimido, destino);
		// Parseo el manifest
		if (logger.isDebugEnabled())
			logger
					.debug("Parseando imsmanifest.xml de los recursos importados "
							+ fManifesXML.getPath());
		Manifest rcpManifest = getScormDao().parsearODELazy(fManifesXML);
		// Obtengo los recursos
		Resource[] resources = rcpManifest.getResources().getResource();
		// Modifico los hrefs para incluir la carpeta base donde se han copiado
		String base = destino.getName();
		if (logger.isDebugEnabled())
			logger
					.debug("Modificando HREFs de recursos importados para incluir la carpeta base "
							+ base);
		for (int i = 0; i < resources.length; i++) {
			for (int j = 0; j < resources[i].getFile().length; j++) {
				String newHref = base + "/"
						+ resources[i].getFile()[j].getHref();
				if (resources[i].getFile()[j].getHref().equals(
						resources[i].getHref())) {
					if (logger.isDebugEnabled())
						logger.debug("Modificando href de recurso "
								+ resources[i].getIdentifier() + " a "
								+ newHref);
					resources[i].setHref(newHref);
				}
				resources[i].getFile()[j].setHref(newHref);
				if (logger.isDebugEnabled())
					logger.debug("Modificando href de file en recurso "
							+ resources[i].getIdentifier() + " a " + newHref);
			}
		}
		// Reseteo los IDs
		if (logger.isDebugEnabled())
			logger.debug("Reseteando IDs de los recursos importados");
		ManifestAgrega maRcp = new ManifestAgrega(rcpManifest);
		maRcp.resetearIds();
		// Añado los recursos al manifest en edicion
		Manifest manifest = getCacheEmpaquetacion().comprobarManifest(idOde);
		ArrayList<Resource> listaRecursos = new ArrayList<Resource>();
		listaRecursos.addAll(Arrays.asList(manifest.getResources()
				.getResource()));
		listaRecursos.addAll(Arrays.asList(rcpManifest.getResources()
				.getResource()));
		manifest.getResources().setResource(
				(Resource[]) listaRecursos.toArray(new Resource[listaRecursos
						.size()]));
		// Por cada recurso, creo un item
		GrupoVO itemPadre = new GrupoVO();
		itemPadre.setIdentifier(PodeUUIDGenerator.getItemUUID(String
				.valueOf(java.lang.Math.random())));
		itemPadre.setTitle(nombre);
		this.getSrvGestorManifestService()
				.crearGrupo(idOde, itemPadre, idGrupo);
		for (int i = 0; i < rcpManifest.getResources().getResourceCount(); i++) {
			GrupoVO item = new GrupoVO();
			String newItemId = PodeUUIDGenerator.getItemUUID(String
					.valueOf(java.lang.Math.random()));
			item.setIdentifier(newItemId);
			String title = null;
			if (rcpManifest.getResources().getResource(i).getHref() == null) {
				title = rcpManifest.getResources().getResource(i)
						.getIdentifier();
			} else {
				title = rcpManifest.getResources().getResource(i).getHref();
			}
			item.setTitle(title);
			item.setElementoReferenciado(rcpManifest.getResources()
					.getResource(i).getIdentifier());
			if (logger.isDebugEnabled())
				logger.debug("Creando item con identificador "
						+ item.getIdentifier()
						+ " para referenciar a recurso "
						+ rcpManifest.getResources().getResource(i)
								.getIdentifier());
			this.getSrvGestorManifestService().crearGrupo(idOde, item,
					itemPadre.getIdentifier());
		}
		if (logger.isDebugEnabled())
			logger.debug("Se han importado con exito "
					+ rcpManifest.getResources().getResourceCount()
					+ " recursos.");
	}

	

	/**
	 * Importa un manifest completo desde rutaManifest a la localizacion del ODE
	 * 
	 * @param idOde
	 * @param localizador
	 * @param rutaManifest
	 * @param idItem
	 */
	private void importarManifest(String idOde, LocalizadorVO localizador,
			String rutaManifest, String idItem, String nombre) throws Exception {
		// Creo un ID para la agregacion temporal de submanifiesto
		java.io.File destino = utilidades.crearCarpetaSeguro(localizador, nombre);
		java.io.File fRutaManifest = new java.io.File(rutaManifest);
		java.io.File fManifestXml = new java.io.File(rutaManifest,
				Utilidades.MANIFEST_NAME);
		if (logger.isDebugEnabled())
			logger.debug("Copiando manifiesto importado a la carpeta "
					+ destino.getPath());
		// Copiar archivos
		UtilesFicheros.copiar(fRutaManifest, destino);
		// Parsear manifiesto
		if (logger.isDebugEnabled())
			logger.debug("Parseando manifiesto importado");
		Manifest submanifest = getScormDao().parsearODELazy(fManifestXml);
		ManifestAgrega subMa = new ManifestAgrega(submanifest);
		if (logger.isDebugEnabled())
			logger.debug("Reseteando las IDs del submanifiesto importado");
		subMa.resetearIds();
		submanifest.setBase(destino.getName());
		// Agregando submanifiesto
		Manifest manifest = getCacheEmpaquetacion().comprobarManifest(idOde);
		if (logger.isDebugEnabled())
			logger.debug("Agregando temporalmente el submanifiesto importado");
		manifest.addManifest(submanifest);
		// Creando Item que referencie al submanifest
		if (logger.isDebugEnabled())
			logger.debug("Creando item que referencia a submanifiesto");
		String newIdItem = PodeUUIDGenerator.getItemUUID(String
				.valueOf(java.lang.Math.random()));
		GrupoVO item = new GrupoVO();
		item.setIdentifier(newIdItem);
		item
				.setTitle(obtenerTituloSubmanifiesto(submanifest, destino
						.getName()));
		item.setElementoReferenciado(submanifest.getIdentifier());
		this.getSrvGestorManifestService().crearGrupo(idOde, item, idItem);
		if (logger.isDebugEnabled())
			logger
					.debug("Creado item "
							+ newIdItem
							+ ". Procesando el manifest en edicion para aplanar la estructura");
		procesarManifestBasico(manifest, false,true,null);
		if (logger.isDebugEnabled())
			logger.debug("Fin de la importacion del manifest");
	}

	/**
	 * Devuelve la lista de items que referencian a este fichero dentro de este
	 * Ode
	 * 
	 * @param idOde
	 *            Identificador del Ode
	 * @param fichero
	 *            Fichero para el que buscamos referencias
	 * @return Value Object representado un fichero o carpeta en la localización
	 *         del ODE.
	 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#referenciadoPor(java.lang.String,
	 *      es.pode.empaquetador.negocio.servicio.FicheroVO)
	 */
	protected es.pode.empaquetador.negocio.servicio.GrupoVO[] handleReferenciadoPor(
			java.lang.String idOde,
			es.pode.empaquetador.negocio.servicio.ArchivoVO fichero)
			throws java.lang.Exception {
		Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
		Collection<String> recursos2File = obtenerRecursosReferencias(fichero, manifest, manifest.getBase());
		if(logger.isDebugEnabled()) logger.debug("Encontrados " + recursos2File.size() + " recursos con referencias a " + fichero.getNombre() + ":\n\n" + recursos2File.toString());
		// Obtengo referencias Item -> Resource
		GrupoVO[] salida = null;
		if(recursos2File.size()>0) {
			Collection<Item> items = obtenerItemReferencias(manifest, recursos2File);
			if(logger.isDebugEnabled()) logger.debug("Se han encontrado " + items.size()+ " items con referencias al archivo");
			if(items.size()>0) {
				ArrayList<Object> grupos = new ArrayList<Object>();
				for(Iterator<Item> it = items.iterator();it.hasNext();) {
					grupos.add(this.getBeanMapper().map(it.next(), GrupoVO.class));
				}
				salida = (GrupoVO[])grupos.toArray(new GrupoVO[grupos.size()]);
			} else salida = new GrupoVO[0];
		} else salida = new GrupoVO[0];
		return salida;
	}

	private Collection<Item> obtenerItemReferencias(final Manifest manifest, final Collection<String> recursos) {
		ArrayList<Item> lista = new ArrayList<Item>();
		for(int i=0;i<manifest.getOrganizations().getOrganizationCount();i++) {
			if(manifest.getOrganizations().getOrganization(i).getItemCount()>0) {
				lista.addAll(obtenerItemReferencias(manifest.getOrganizations().getOrganization(i).getItem(), recursos));
			}
		}
		// Buscamos en los submanifiestos
		for(int i=0;i<manifest.getManifestCount();i++) {
			Collection<Item> subItems = obtenerItemReferencias(manifest.getManifest(i), recursos);
			lista.addAll(subItems);
		}
		return lista;
	}
	
	private Collection<Item> obtenerItemReferencias(final Item[] items, final Collection<String> recursos) {
		ArrayList<Item> lista = new ArrayList<Item>();
		for(int i=0;i<items.length;i++) {
			if(logger.isDebugEnabled()) logger.debug("Comprobando item " + items[i].getIdentifier() + " con idRef " + items[i].getIdentifierref() + " : " + recursos.contains(items[i].getIdentifierref()));
			if(recursos.contains(items[i].getIdentifierref())) lista.add(items[i]);
			if(items[i].getItemCount()>0) lista.addAll(obtenerItemReferencias(items[i].getItem(), recursos));
		}
		return lista;
	}
	
	private Collection<String> obtenerRecursosReferencias(ArchivoVO archivo, Manifest manifest, String base) {
		ArrayList<String> lista = new ArrayList<String>();
		if(logger.isDebugEnabled()) logger.debug("obtenerRecursosReferencias con archivo " + (archivo.getCarpetaPadre()+"/"+archivo.getNombre()) + " y base " + base);
		if(base==null) base = "";
		Resource[] recursos = manifest.getResources().getResource();
		if(recursos!=null) {
			for(int i=0;i<recursos.length;i++) {
				File[] files = recursos[i].getFile();
				if(files!=null) {
					String[] nombreFiles = new String[files.length];
					for(int j=0;j<files.length;j++) {
						nombreFiles[j] = base.concat(files[j].getHref());
					}
					if(comparaArchivo2File(nombreFiles, (archivo.getCarpetaPadre()==null?archivo.getNombre():archivo.getCarpetaPadre()+"/"+archivo.getNombre()))) {
						if(logger.isDebugEnabled()) logger.debug("Encontrada referencia de recurso " + recursos[i].getIdentifier() + " a fichero " + (archivo.getCarpetaPadre()==null?archivo.getNombre():archivo.getCarpetaPadre()+"/"+archivo.getNombre()));
						lista.add(recursos[i].getIdentifier());
					}
				}
			}
		}
		// Compruebo los submanifiestos
		for(int i=0;i<manifest.getManifestCount();i++) {
			Collection<String> subRecursos = obtenerRecursosReferencias(archivo, manifest.getManifest(i), base.concat(manifest.getManifest(i).getBase()));
			lista.addAll(subRecursos);
		}
		return lista;
	}
	
	private boolean comparaArchivo2File(String[] nombreFicheros, String href) {
		boolean result = false;
		for(int i=0;i<nombreFicheros.length;i++) {
			if(logger.isDebugEnabled()) logger.debug("Comparando " + href + " con " + nombreFicheros[i] + "...");
			if(nombreFicheros[i].equals(href) || nombreFicheros[i].startsWith(href)) {
				if(logger.isDebugEnabled()) logger.debug("Referencia encontrada");
				result = true;
			}
		}
		return result;
	}

	/**
	 * Elimina el grupo indicado.
	 * 
	 * @param idOde
	 *            identificador del Ode del que se borrará el grupo
	 * @param idGrupo
	 *            Grupo que se debe eliminar
	 * @param eliminarFicheros
	 *            true: elimina los ficheros asociados a este recurso que no
	 *            estan referenciados por otros recursos.
	 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoServiceBase#handleEliminarGrupo(java.lang.String,
	 *      java.lang.String, java.lang.Boolean)
	 */
	protected void handleEliminarGrupo(String idOde, String idGrupo,
			Boolean eliminarFicheros) throws Exception {
		// Si boolean es false, elimina grupo a secas, si true, elimina también
		// ficheros
		Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
		Object grupo = manifestAgrega.obtenerElemento(idGrupo);
		if (grupo instanceof Item) {
			if (eliminarFicheros.booleanValue()) {
				//TODO
				String idResource = ((Item)grupo).getIdentifierref();
	 			Resource[] resources = manifest.getResources().getResource();
	 			Resource resource = resources[Arrays.binarySearch(resources,
	 					idResource, new ResourceStringComparator())];
	 			File[] files=resource.getFile();
	 			ArchivoVO[] ficheros =(ArchivoVO[])getBeanMapper().map((File[])files, ArchivoVO[].class);;
				getSrvGestorArchivosService().eliminar(idOde, ficheros);
			}

			((Item) grupo).removeAllItem();
			getSrvGestorManifestService().eliminarGrupo(idOde, idGrupo);
		}
	}

	
	/**
	 * Llama al SrvGestorArchivosService.renombrar para renombrar el fichero /
	 * carpeta solicitado y, adicionalmente, explora todas las referencias al
	 * fichero / carpeta contenidas en el manifest para modificarlas.
	 * 
	 * Llama al SrvGestorArchivosService.renombrar
	 * 
	 * @param identificador
	 *            Identificador del Ode en edición
	 * @param carpetaPadre
	 *            Carpeta padre (relativa a la localización del ODE) del fichero /
	 *            carpeta a modificar. Si se encuentra en la localización del
	 *            ODE, carpetaPadre = null.
	 * @param nombre
	 *            Nombre del fichero / carpeta que se desea modificar.
	 * @param nuevoNombre
	 *            Nuevo nombre
	 * @throws java.lang.Exception
	 *             Si ya existe un archivo con el mismo path
	 *             (carpetaPadre/nuevoNombre).
	 */
	protected void handleRenombrar(java.lang.String idOde,
			java.lang.String carpetaPadre, java.lang.String nombre,
			java.lang.String nuevoNombre) throws java.lang.Exception {
		
		String carpetaPadreMod = carpetaPadre==null ? "" : carpetaPadre.concat("/");
		String oldHref = carpetaPadreMod.concat(nombre);
		String newHref = carpetaPadreMod.concat(nuevoNombre);
		Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
		// Llamo a renombrar del GestorArchivos: si falla, omito la modificacion del manifest.
		try {
			this.getSrvGestorArchivosService().renombrar(idOde, carpetaPadre, nombre, nuevoNombre);
		} catch (Exception e) {
			logger.error("Error del Gestor de Archivos al renombrar ODE",e);
			throw e;
		}
		// Renombro los file y href que apuntaban al fichero / carpeta
		try {
			renombrarFiles(manifest, oldHref, newHref, null);
		} catch (Exception e) {
			logger.error("Error al renombrar hrefs del manifest (de " + oldHref + " a " + newHref,e);
			throw new AlmacenamientoException("Error al renombrar hrefs del manifest (de " + oldHref + " a " + newHref);
		}
	}
	
	/**
	 *   Metodo comun a renombrar y a mover.
	 * 
	 * @param manifest
	 * @param oldHref
	 * @param newHref
	 * @param base
	 */
	private void renombrarFiles(Manifest manifest, String oldHref, String newHref, String base) {
		String nnBase = "";
		if(base!=null) nnBase = nnBase.concat(base);
		// Exploro los recursos del manifest
		for(int i=0;i<manifest.getResources().getResourceCount();i++) {
			Resource resource = manifest.getResources().getResource(i);
			replacePath(resource, oldHref, newHref, nnBase);
		}
		// Submanifiestos
		
		for(int i=0;i<manifest.getManifestCount();i++) {
			String newBase = nnBase.concat(manifest.getManifest(i).getBase());
			if(newBase.endsWith("/")) newBase = newBase.substring(0,newBase.lastIndexOf('/'));
			if(oldHref.equals(newBase)) {
				if(logger.isDebugEnabled()) logger.debug("Renombrando base de submanifest " + manifest.getManifest(i).getIdentifier());
				String baseRenombrado = null;
				if(newHref.lastIndexOf('/')!=-1) baseRenombrado = newHref.substring(newHref.lastIndexOf('/'));
				else baseRenombrado = newHref;
				manifest.getManifest(i).setBase(baseRenombrado+"/");
				if(logger.isDebugEnabled()) logger.debug("Renombrado a " +manifest.getManifest(i).getBase()); 
			} else {
				// Me interno en el submanifiesto
				if(logger.isDebugEnabled()) logger.debug("Internandome en submanifiesto " + manifest.getManifest(i).getIdentifier());
				renombrarFiles(manifest.getManifest(i), oldHref, newHref, newBase);
			}
		}
	}
	
	private void replacePath(Resource resource, String oldHref,String newHref, String base) {
		resource.setHref(replacePath(resource.getHref(), oldHref, newHref, base));
		for(int j=0;j<resource.getFile().length;j++) {
			resource.getFile()[j].setHref(replacePath(resource.getFile()[j].getHref(), oldHref, newHref, base));
		}
	}

	
	private String replacePath(String href, String oldHref,String newHref, String base) {
		String result = href;
		if(href!=null) {
			// Para comparaciones de href, reconstruyo el absoluto base+href
			String fullHref = null;
			if("".equals(base)) fullHref = base.concat(href);
			else fullHref = base.concat("/").concat(href);
			if(oldHref.equals(fullHref)) {
				if(logger.isDebugEnabled()) logger.debug("Renombrado : " + href + " --> " + newHref);
//				 Si base no es "", lo elimino del href resultante
				if(!"".equals(base)) {
//					oldHref = oldHref.replaceFirst(base + "/", "");
					newHref = newHref.replaceFirst(base + "/", "");
				}
				result = newHref;
			} else if(fullHref.startsWith(oldHref)) {
				
				if(logger.isDebugEnabled()) logger.debug("Renombrado : " + href + " --> " + href.replaceFirst(oldHref, newHref));
				// Si base no es "", lo elimino del href resultante
				if(!"".equals(base)) {
					oldHref = oldHref.replaceFirst(base + "/", "");
					newHref = newHref.replaceFirst(base + "/", "");
				}
				result = href.replaceFirst(oldHref, newHref);
			}
		}
		return result;
	}
	
	/**
	 * Elimina del Ode el fichero indicado. Si es referenciado por algún item o
	 * recurso, no se elimina a no ser que checked=true.
	 * 
	 * @param idOde
	 *            Identificador del Ode del que se borrarán los ficheros
	 * @param fichero
	 *            Ficheros que se eliminarán.
	 * @param checked
	 *            Bandera que indica si se desea seguir adelante con el borrado
	 *            aunque algún fichero esté referenciado
	 * @return Devuelve true si se eliminó los ficheros, false si alguno es
	 *         referenciado por algún item o recurso.
	 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#eliminarFichero(java.lang.String,
	 *      es.pode.empaquetador.negocio.servicio.FicheroVO, boolean)
	 */
	protected boolean handleEliminarFicheros(java.lang.String idOde,
			es.pode.empaquetador.negocio.servicio.ArchivoVO[] fichero,
			boolean checked) throws java.lang.Exception {
		boolean result = true;
		try {
		// Eliminar los files de resources que apuntan a los ficheros eliminados
		
		// Construyo los href a partir de los ArchivoVO (hijos incluidos)
		HashSet<String> hrefs = new HashSet<String>();
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(idOde);
		Manifest manifest = getCacheEmpaquetacion().comprobarManifest(idOde);
		for(int i=0;i<fichero.length&&result;i++) {
			if(!checked) {
				//Si un fichero es referenciado, result=false.
				//Gracias al AND, una vez se ha marcado false se mantiene, sin sobreescrituras
				result=referenciadoPor(idOde, fichero[i]).length>0&&result;
			}
			String href = fichero[i].getCarpetaPadre()==null ? fichero[i].getNombre() : fichero[i].getCarpetaPadre().concat("/").concat(fichero[i].getNombre());
			if(fichero[i].getEsFichero().booleanValue()) {
				hrefs.add(href);
			} else {
				// Examinar los hijos y añadirlos como href
				hrefs.addAll(obtenerFilesHijosDeCarpetas(href,localizador.getPath()));
			}
		}
		if(logger.isDebugEnabled()) logger.debug("Recuperados hrefs a eliminar : " + Arrays.toString((String[])hrefs.toArray(new String[]{})));
		if (checked||!result) {
			deleteFilesFromManifest(manifest, hrefs, null);
			result=true;
		}		
		if(logger.isDebugEnabled()) logger.debug("Borro los archivos fisicamente");
		// Borro los archivos fisicamente
		this.getSrvGestorArchivosService().eliminar(idOde, fichero);
		} catch (Exception e) {
			logger.error("Error en eliminarFicheros",e);
			throw new EliminarException("Error en eliminarFicheros",e);
		}
		return result;
	}
	
	private void deleteFilesFromManifest(Manifest manifest, Collection<String> href, String base) {
		Resource[] resources = manifest.getResources().getResource();
		ArrayList<File> list=null;
		String nnBase = "";
		if(base!=null) nnBase = base;
		if(logger.isDebugEnabled()) logger.debug("deleteFilesFromManifest: borrando files de " + manifest.getIdentifier() + " con base " + base );
		for(int i=0;i<resources.length;i++) {
			list = new ArrayList<File>();
			list.addAll(Arrays.asList(resources[i].getFile()));
			for(Iterator<File> it=list.iterator();it.hasNext();) {
				File file = it.next();
				String fullHref = nnBase.concat(file.getHref());
				if(href.contains(fullHref)) {
					if(logger.isDebugEnabled()) logger.debug("borrando file " + file.getHref() + " de resource " + resources[i].getIdentifier());
					it.remove();
				}

			}
			if(resources[i].getHref()!=null) {
				String fullHref = nnBase.concat(resources[i].getHref());
				if(href.contains(fullHref)) {				
					if(list.size()>0) {
						if(logger.isDebugEnabled()) logger.debug("Modificando href de " + resources[i].getIdentifier() + " a " + ((File)list.get(0)).getHref());
						resources[i].setHref(((File)list.get(0)).getHref());
					} else {
						if(logger.isDebugEnabled()) logger.debug("Modificando href de " + resources[i].getIdentifier() + " a null");
						resources[i].setHref(null);
					}
	 
				}
			}
			resources[i].setFile((File[])list.toArray(new File[list.size()]));
		}
		if(logger.isDebugEnabled()) logger.debug("Recursos de " + manifest.getIdentifier() + " explorados. Examinando submanifiestos");
		for(int i=0;i<manifest.getManifestCount();i++) {
			String nextBase = nnBase.concat(manifest.getManifest(i).getBase());
			deleteFilesFromManifest(manifest.getManifest(i), href, nextBase);
		}
	}

	private Collection<String> obtenerFilesHijosDeCarpetas(String carpeta,String odePath) throws Exception {
		HashSet<String> resultado = new HashSet<String>();
		java.io.File fCarpeta = new java.io.File(odePath,carpeta);
		logger.debug("obtenerFilesHijosDeCarpetas: examinando " + carpeta);
		if(fCarpeta.isDirectory()) {
			java.io.File[] hijos = fCarpeta.listFiles();
			for(int i=0;i<hijos.length;i++) {
				String href = hijos[i].getPath();
				// Transforma href para comparacion
				href = href.replace('\\', '/');
				href = href.replaceFirst(odePath, "");
				if(href.startsWith("/")) href = href.replaceFirst("/", "");
				logger.debug("obtenerFilesHijosDeCarpetas: Analizando " + href);
				if(hijos[i].isFile()) {
					logger.debug("obtenerFilesHijosDeCarpetas: File detectado : " + hijos[i].getPath());
					resultado.add(href);
				} else {
					logger.debug("obtenerFilesHijosDeCarpetas: Directorio detectado : " + hijos[i].getPath() + "; examinando contenidos");
					resultado.addAll(obtenerFilesHijosDeCarpetas(href, odePath));
				}
			}
		} else {
			logger.error("Se ha intentado listar contenidos de una entrada que no es directorio : " + fCarpeta.getPath());
		}
		return resultado;
	}
	
	/**
	 * Agrega un paquete, sea un Ode, un RCP (Resource Content Package) o un
	 * conjunto de ficheros, comprimidos o no.
	 * 
	 * @param idOde
	 *            Identificador del ODE en edicion.
	 * @param fichero
	 *            Fichero del paquete a agregar
	 * @param idGrupo
	 *            Identificador del Item donde se esta agregando el contenido.
	 *            Es el item bajo el cual se creara el nuevo item que referencia
	 *            al contenido agregado.
	 */
	protected void handleAgregarLocal(String idOde, FicheroVO fichero,
			String idGrupo) throws Exception {
		if (logger.isDebugEnabled())
			logger
					.debug("Comenzando la importacion de contenidos subidos desde el portal: idOde"
							+ idOde
							+ " fichero.nombre "
							+ fichero.getNombre()
							+ " item de destino " + idGrupo);
		/*
		 * Escribo el fichero contenido en Datahandler a disco
		 */
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(idOde);
		String rutaTmp = utilidades.obtenerRutaTemporal(idOde, localizador
				.getPath(), true);
		String rutaTmpArchivo = rutaTmp + "/archivo";
		java.io.File fRutaTmpArchivo = new java.io.File(rutaTmpArchivo);
		if (!fRutaTmpArchivo.exists()) {
			boolean result = fRutaTmpArchivo.mkdirs();
			if (!result) {
				logger.error("No se pudo crear la ruta " + rutaTmpArchivo);
				throw new AlmacenamientoException("No se pudo crear la ruta "
						+ rutaTmpArchivo);
			}
		}
		java.io.File fArchivo = new java.io.File(fRutaTmpArchivo, fichero
				.getNombre());
		fArchivo.deleteOnExit();
		if (logger.isDebugEnabled())
			logger.debug("Ruta para almacenar archivo subido : "
					+ fArchivo.getPath());
		DataHandler dh = fichero.getDatos();
		FileOutputStream fos = new FileOutputStream(fArchivo);
		dh.writeTo(fos);
		fos.close();

		agregarLocal(idOde, idGrupo, localizador,
				rutaTmp, fArchivo);
		// Borrando los archivos temporales
		try {
			UtilesFicheros.eliminar(fRutaTmpArchivo);
		} catch (Exception e) {
			logger
					.warn(
							"No se pudieron eliminar los archivos temporales tras la importacion de archivos",
							e);
		}
	}

	private void agregarLocal(String idOde, String idGrupo,
			LocalizadorVO localizador, String rutaTmp, java.io.File fArchivo) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Archivo subido escrito en disco");
		String rutaTmpDescomprimido = rutaTmp + "/descomprimido";
		// Le paso el destino para descomprimir
		AnalizaArchivoVO tipo = analizaArchivo(fArchivo.getPath(), rutaTmpDescomprimido);
		if (tipo.getTipoArchivo().equals(ConstantesAgrega.FICHERO)) {
			agregaFicheros(idOde, fArchivo.getParent(), localizador, fArchivo
					.getName(), idGrupo);
		} else if (tipo.getTipoArchivo().equals(ConstantesAgrega.ARCHIVO)|| tipo.getTipoArchivo().equals(ConstantesAgrega.ODE_NO_VALIDO)) {
			agregaFicheros(idOde, rutaTmpDescomprimido, localizador, fArchivo
					.getName(), idGrupo);
		} else if (tipo.getTipoArchivo().equals(ConstantesAgrega.RCP)) {
			importarRecursos(idOde, localizador, rutaTmpDescomprimido, idGrupo,
					fArchivo.getName());
		} else if (tipo.getTipoArchivo().equals(ConstantesAgrega.CA)) {
			importarManifest(idOde, localizador, rutaTmpDescomprimido, idGrupo,
					fArchivo.getName());
		} else {
			logger
					.error("No se ha podido identificar el tipo de archivo subido desde el portal");
		}
		UtilesFicheros.eliminar(new java.io.File(rutaTmpDescomprimido));
	}

	@Override
	protected void handleAgregarLocalFichero(String idOde, String fichero,
			String idGrupo) throws Exception {
		try {
		LocalizadorVO localizador = this.getSrvLocalizadorService()
			.consultaLocalizador(idOde);
		String rutaTmp = utilidades.obtenerRutaTemporal(idOde, localizador
				.getPath(), true);
		agregarLocal(idOde, idGrupo, localizador,
				rutaTmp, new java.io.File(fichero));
		} catch (Exception e) {
			logger.error("Error al agregar ODE federado",e);
			throw e;
		}
	}
	
	
	
	private void agregaFicheros(String idOde, String rutaFicheros,
			LocalizadorVO localizador, String nombre, String idPadre)
			throws Exception {
		String newItemId = PodeUUIDGenerator.getItemUUID(String
				.valueOf(java.lang.Math.random()));
		String newResourceId = PodeUUIDGenerator.getRecursoUUID(String
				.valueOf(java.lang.Math.random()));
		if (logger.isDebugEnabled())
			logger.debug("Agregando los ficheros de " + rutaFicheros
					+ " al item " + idPadre + " del ODE " + idOde);
		String carpeta = localizador.getPath() + "/" + newItemId;
		java.io.File fCarpeta = new java.io.File(carpeta);
		if (!fCarpeta.exists()) {
			boolean result = fCarpeta.mkdirs();
			if (!result) {
				logger
						.error("Error al crear la carpeta de destino de los ficheros : "
								+ carpeta);
				throw new AlmacenamientoException(
						"Error al crear la carpeta de destino de los ficheros : "
								+ carpeta);
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("Copiando archivos a " + carpeta);
		UtilesFicheros.copiar(new java.io.File(rutaFicheros), fCarpeta);
		if (logger.isDebugEnabled())
			logger.debug("Generando resource e item para los archivos");
		FileVO[] files = obtenerResourceFilesAsArray(carpeta, null);
		RecursoVO resource = new RecursoVO();
		resource.setIdentifier(newResourceId);
		resource.setFileList(files);
		resource.setHref(files[0].getHref());
		resource.setScormType("asset");
		resource.setType("webcontent");
		GrupoVO item = new GrupoVO();
		item.setIdentifier(newItemId);
		item.setTitle(nombre);
		item.setElementoReferenciado(newResourceId);
		if (logger.isDebugEnabled())
			logger
					.debug("Llamando a SrvGestorManifestService para registrar el nuevo resource");
		this.getSrvGestorManifestService().crearRecurso(idOde, resource);
		if (logger.isDebugEnabled())
			logger
					.debug("Llamando a SrvGestorManifestService para registrar el nuevo item");
		this.getSrvGestorManifestService().crearGrupo(idOde, item, idPadre);
		if (logger.isDebugEnabled())
			logger.debug("Finalizada la agregacion de archivos");
	}

	private FileVO[] obtenerResourceFilesAsArray(String carpeta, String basePath) {
		return (FileVO[]) obtenerResourceFiles(new java.io.File(carpeta),
				basePath).toArray(new FileVO[] {});
	}

	/**
	 * @param fCarpeta
	 * @param basePath
	 *            Carpeta base respecto al localizador. Si la base es el
	 *            localizador, poner a null
	 * @return
	 */
	private ArrayList<FileVO> obtenerResourceFiles(java.io.File fCarpeta,
			String basePath) {
		ArrayList<FileVO> listaFicheros = new ArrayList<FileVO>();
		if (logger.isDebugEnabled())
			logger.debug("Comprobando file " + fCarpeta.getPath());
		if (fCarpeta.exists()) {
			if (fCarpeta.isFile()) {
				if (logger.isDebugEnabled())
					logger.debug("El file " + fCarpeta.getPath()
							+ " es un fichero: generando FileVO");
				FileVO fileVO = new FileVO();
				fileVO.setHref(basePath + "/" + fCarpeta.getName());
				if (logger.isDebugEnabled())
					logger.debug("FileVO con href " + fileVO.getHref()
							+ " generado.");
				listaFicheros.add(fileVO);
			} else if (fCarpeta.isDirectory()) {
				if (logger.isDebugEnabled())
					logger.debug("El file " + fCarpeta.getPath()
							+ " es una carpeta: examinando sus contenidos");
				java.io.File[] contenidos = fCarpeta.listFiles();
				String newBase = (basePath == null ? fCarpeta.getName()
						: basePath + "/" + fCarpeta.getName());
				for (int i = 0; i < contenidos.length; i++) {
					listaFicheros.addAll(obtenerResourceFiles(contenidos[i],
							newBase));
				}
			} else {
				logger.warn("El file " + fCarpeta.getPath()
						+ " existe pero no es fichero ni carpeta. Lo ignoro");
			}
		} else {
			logger.error("El fichero " + fCarpeta.getPath() + " no existe.");
		}
		return listaFicheros;
	}

	/**
	 * Analiza el archivo escrito en ruta Archivo y descomprime - en caso de que
	 * sea comprimido - a rutaDescomprimido.
	 * 
	 * @param rutaArchivo
	 * @param rutaDescomprimido
	 * @return
	 */
	@Override
	protected AnalizaArchivoVO handleAnalizaArchivo(String rutaArchivo,
			String rutaDescomprimido) throws Exception {
		AnalizaArchivoVO resultado = new AnalizaArchivoVO();
		if (rutaArchivo!=null) {
			if (this.getZipDao().esZip(rutaArchivo)) {
				if (logger.isDebugEnabled())
					logger
							.debug("El archivo "
									+ rutaArchivo
									+ " es un archivo comprimido. Comprobando contenidos");
				// Descomprimo el archivo
				java.io.File fRutaDescomprimido = new java.io.File(
						rutaDescomprimido);
				if (!fRutaDescomprimido.exists()) {
					boolean result = fRutaDescomprimido.mkdirs();
					if (!result) {
						logger.error("No se pudo crear la carpeta temporal "
								+ fRutaDescomprimido.getPath());
						throw new AlmacenamientoException(
								"No se pudo crear la carpeta temporal "
										+ fRutaDescomprimido.getPath());
					}
				}
				getZipDao().descomprimir(rutaArchivo, rutaDescomprimido);
				logger.debug("Archivo " + rutaArchivo + " descomprimido a "
							+ rutaDescomprimido);
				// Comprobando la existencia de un imsmanifest.xml
				java.io.File manifestXml = new java.io.File(rutaDescomprimido,
						Utilidades.MANIFEST_NAME);
				if (manifestXml.isFile()) {
					if (logger.isDebugEnabled())
						logger
								.debug("imsmanifest.xml encontrado: validando CA o RCP");
					ValidaVO validacionRCP = this.getSrvValidadorService()
							.obtenervalidacionLigera(rutaDescomprimido,
									ConstantesAgrega.RCP);
					ValidaVO validacionCA = this.getSrvValidadorService()
							.obtenervalidacionLigera(rutaDescomprimido,
									ConstantesAgrega.CA);
					String[] mensajes = validacionCA.getResultadoValidacion()!=null?validacionCA.getResultadoValidacion().split(";"):null;
					if (validacionCA.getEsValidoManifest().booleanValue()) {
						if (logger.isDebugEnabled())
							logger.debug("El archivo " + rutaArchivo
									+ " es un ODE SCORM");
						resultado.setTipoArchivo(ConstantesAgrega.CA);
					} else if (validacionRCP.getEsValidoManifest()
							.booleanValue()) {
						if (logger.isDebugEnabled())
							logger.debug("El archivo " + rutaArchivo
									+ " es un paquete RCP");
						resultado.setTipoArchivo(ConstantesAgrega.RCP);
					} else {
						logger
								.warn("El archivo "
										+ rutaArchivo
										+ " tiene un imsmanifest.xml que no valida correctamente. Se informa de validacion incorrecta");
						resultado.setTipoArchivo(ConstantesAgrega.ODE_NO_VALIDO);
						resultado.setMensajes(mensajes);
					}
				} else {
					if (logger.isDebugEnabled())
						logger
								.debug("No existe imsmanifest.xml. Agregando como conjunto de archivos.");
					resultado.setTipoArchivo(ConstantesAgrega.ARCHIVO);
				}
			} else {
				if (logger.isDebugEnabled())
					logger.debug("El archivo " + rutaArchivo
							+ " es un fichero.");
				resultado.setTipoArchivo(ConstantesAgrega.FICHERO);
			}
		}
		if (resultado.getTipoArchivo().equals("")) {
			logger.error("No se ha conseguido analizar el archivo "
					+ rutaArchivo + " con exito.");
			throw new AlmacenamientoException(
					"No se ha conseguido analizar el archivo " + rutaArchivo
							+ " con exito.");
		}
		return resultado;
	}

	/**
	 * Importa un ODE del repositorio indicado al ODE actual, bajo el
	 * identificador de grupo dado.
	 * 
	 * @param idOde
	 *            Identificador del ODE en edicion
	 * @param idLocalizador
	 *            Identificador del ODE del repositorio que desea agregarse al
	 *            ODE actual.
	 * @param idGrupo
	 *            Identificador del grupo bajo el que se agregan los contenidos.
	 */
	protected void handleAgregarRepositorio(String idOde, String idLocalizador,
			String idGrupo) throws Exception {
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(idOde);
		LocalizadorVO localizadorSubmaniest = this.getSrvLocalizadorService()
				.consultaLocalizador(idLocalizador);
		if (logger.isDebugEnabled())
			logger
					.debug("Llamando a importarManifest con argumentos : idOde = "
							+ idOde
							+ " ; rutaManifest = "
							+ localizadorSubmaniest.getPath()
							+ " ; idItem = "
							+ idGrupo + " ; nombre = " + idLocalizador);
		importarManifest(idOde, localizador, localizadorSubmaniest.getPath(),
				idGrupo, idLocalizador);
	}

	/**
	 * Asocia los ficheros dados al Recurso referenciado por el Item dado. Si no
	 * existe, se creará uno nuevo.
	 * 
	 * Emplea las operaciones crearRecurso y modificarRecurso del servicio
	 * GestorManifestService.
	 * 
	 * @param idOde
	 *            Identificador del ODE al que se asociarán los contenidos
	 * @param idGrupo
	 *            Identificador del Grupo bajo el que se asociarán los
	 *            contenidos
	 * @param ficheros
	 *            Contenidos para asociar
	 * @param href
	 *            Href del fichero principal o URL asociada al Grupo.
	 */
	protected void handleAsociarContenidos(String idOde, String idGrupo,
			FileVO[] ficheros, String href) throws Exception {
		//Buscamos idGrupo
		Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
		ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
		Object grupo = manifestAgrega.obtenerElemento(idGrupo);
		if (grupo!=null&&grupo instanceof Item) {
			String idRef = ((Item) grupo).getIdentifierref();
			Object ref = idRef!=null?manifestAgrega.obtenerElemento(idRef):null;
			RecursoVO recurso;
			if(logger.isDebugEnabled()) {
				logger.debug("Confirmamos si "+idGrupo+" tiene recursos asociados");
			}
			if(ref!=null&&ref instanceof Resource) {
				recurso = (RecursoVO)getBeanMapper().map((Resource)ref, RecursoVO.class);;
				//Existe el recurso
				if(logger.isDebugEnabled()) {
					logger.debug(idGrupo+" tiene recursos asociados:"+recurso.getIdentifier());
				}
			}else {
				if(logger.isDebugEnabled()) {
					logger.debug(idGrupo+" no tiene recursos asociados: creamos uno");
				}
				//No existe el recurso
				recurso = new RecursoVO();
				String recursoId = PodeUUIDGenerator.getRecursoUUID(String.valueOf(java.lang.Math.random()));
				recurso.setIdentifier(recursoId);
				((Item)grupo).setIdentifierref(recursoId);
				recurso.setType("webcontent");
				recurso.setScormType("asset");
				getSrvGestorManifestService().crearRecurso(idOde, recurso);
				if(logger.isDebugEnabled()) {
					logger.debug("Se creo recursos con id="+recurso.getIdentifier());
				}
			}
			//y asociar ficheros
			recurso.setFileList(ficheros);
			recurso.setHref(href);
			getSrvGestorManifestService().modificarRecurso(idOde, recurso);
			if(logger.isDebugEnabled()) {
				logger.debug("Se modificó el recurso "+recurso.getIdentifier());
			}
		} else if(logger.isDebugEnabled()){
			logger.debug("No se encontró el grupo "+idGrupo);
		}
	}

	/**
	 * Desagregar items a Ode autogenerado.
	 * 
	 * @param idOde
	 *            Ode origen
	 * @param items
	 *            Lista de items a desagregar
	 * @param esLocal
	 *            Selector de tipo de ruta. Si es True, se creará en local, si
	 *            es False, en repositorio
	 * @return String con el Ode generado que contiene los Items que se quiere
	 *         desagregar.
	 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#desagregarItem(java.lang.String,
	 *      es.pode.empaquetador.negocio.servicio.GrupoVO[], java.lang.Boolean)
	 */
	protected String desagregarItem(java.lang.String idOde,
			es.pode.empaquetador.negocio.servicio.GrupoVO[] items,
			java.lang.Boolean esLocal) throws java.lang.Exception {
		String resultado = "";
		ArrayList<Item> itemsDesagregados = new ArrayList<Item>();
		Manifest manifest = getCacheEmpaquetacion().comprobarManifest(idOde);
		ManifestAgrega ma = new ManifestAgrega(manifest);
		String rutaTmp = null;
		LocalizadorVO localizadorDesagregado = null;
		Manifest desagregado = null;
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(idOde);
		try {
			
			for(int i=0;i<items.length;i++) {
				Item item = ma.obtenerItem(items[i].getIdentifier());
				if(item!=null) {
					// Clono el Item
					itemsDesagregados.add((Item)getBeanMapper().map(item,Item.class));
				} else {
					logger.error("No se encuentra el item " +items[i].getIdentifier());
				}
			}
			if(itemsDesagregados.size()>items.length) {
				logger.error("No se han encontrado todos los items que se desean desagregar");
				throw new Exception("No se han encontrado todos los items que se desean desagregar");
			}
			/*
			 * Generamos en nuevo Manifest
			 */
			desagregado = new Manifest();
			desagregado.setIdentifier(PodeUUIDGenerator.getOdeUUID(String.valueOf(java.lang.Math.random())));
			desagregado.setMetadata(new Metadata());
			desagregado.getMetadata().setSchema(utilidades.getProperty("empaquetador.crearOde.schema"));
			desagregado.getMetadata().setSchemaversion(utilidades.getProperty("empaquetador.crearOde.schemaversion"));
			desagregado.setOrganizations(new Organizations());
			desagregado.getOrganizations().addOrganization(new Organization());
			String idOrg = PodeUUIDGenerator.getOrganizacionUUID(String.valueOf(java.lang.Math.random()));
			desagregado.getOrganizations().getOrganization(0).setIdentifier(idOrg);
			desagregado.getOrganizations().getOrganization(0).setTitle(utilidades.getProperty("organizacion.por.defecto"));
			desagregado.getOrganizations().setDefault(idOrg);
			desagregado.getOrganizations().getOrganization(0).setItem(itemsDesagregados.toArray(new Item[itemsDesagregados.size()]));
			// Recuperar recursos referenciados por items
			Resource[] resources = obtenerResourcesFromItemsAsArray(manifest,(Item[])itemsDesagregados.toArray(new Item[]{}));
			desagregado.setResources(new Resources());
			desagregado.getResources().setResource(resources);
			// Recuperar los files de los recursos para la copia de archivos
			File[] files = obtenerFilesFromResources(resources);
			
			// Crea ruta temporal para general el ODE
			
			if(logger.isDebugEnabled()) logger.debug("Creando carpeta temporal para la formacion del ODE desagregado");
			rutaTmp= utilidades.obtenerRutaTemporal(desagregado.getIdentifier(), localizador.getPath(), true);
			if(logger.isDebugEnabled()) logger.debug("Carpeta temporal = " + rutaTmp);
			java.io.File ruta = new java.io.File(rutaTmp,"ode");
			boolean carpetaCreada = ruta.mkdirs();
			if(!carpetaCreada) {
				logger.error("No se ha podido crear la carpeta temporal " + ruta.getPath() + " para desagregar");
				throw new AlmacenamientoException("No se ha podido crear la carpeta temporal " + ruta.getPath() + " para desagregar");
			}
			// Copia los archivos (esquemas, contenidos y imsmanifes.xml
			copiaContenidos(files,localizador.getPath(),ruta.getPath());
			utilidades.copiarEsquemas(ruta.getPath());
			getScormDao().escribirODE(desagregado, new java.io.File(ruta,Utilidades.MANIFEST_NAME));
			// Desagregar a local / personales
			if(esLocal.booleanValue()) {
				if(logger.isDebugEnabled()) logger.debug("Exportando a local");
				String zipName = desagregado.getIdentifier() + ".zip";
				String zip = rutaTmp + "/" + zipName;
				getZipDao().comprimir(zip, ruta.getPath());
				resultado = zip;
			} else {
				if(logger.isDebugEnabled()) logger.debug("Exportando a personales");
				localizadorDesagregado = obtenerLocalizador(idOde,localizador.getIdUsuario(),desagregado);
				if(logger.isDebugEnabled()) logger.debug("Copiando archivos a localizador " + localizadorDesagregado.getPath());
				UtilesFicheros.copiar(ruta, new java.io.File(localizadorDesagregado.getPath()));
				// Devuelvo el identificador del nuevo ODE
				resultado = localizadorDesagregado.getIdentificador();
			}

		} catch (Exception e) {
			if(!esLocal.booleanValue() && localizadorDesagregado!=null) { 
				if(logger.isDebugEnabled()) logger.debug("Borrando localizadorDesagregado por fallo de desagregar");
				try {
				this.getSrvPublicacionService().eliminar(desagregado.getIdentifier(), localizador.getIdUsuario());
				} catch (Exception ex) {
					logger.error(ex);
				}
			}
			throw new AlmacenamientoException("Error al desagregar items",e);
		}
		return resultado;
	}
	
	protected String handleDesagregarItem(String idOde, GrupoVO[] items) throws Exception {
		String id = desagregarItem(idOde, items, Boolean.FALSE);
		return id;
	}

	protected DataHandler handleDesagregarItemLocal(String idOde, GrupoVO[] items) throws Exception {
		String path = desagregarItem(idOde, items,Boolean.TRUE);
		DataHandler dh =utilidades.serializarExportado(path);
		return dh;
	}
	
	private LocalizadorVO obtenerLocalizador(String idOdePadre,String user, Manifest manifest) throws Exception {
		String idioma = null;
		try {
			idioma = LdapUserDetailsUtils.getIdioma();
		} catch (Throwable e) {
			logger.warn("No se ha podido recuperar el idioma del contexto de seguridad, usando es por defecto",e);
			idioma = "es";
		}
		if(logger.isDebugEnabled()) logger.debug("Creando entrada en el taller para ode desagregado " + manifest.getIdentifier());
		String comentarios = utilidades.getI18NMessage(idioma, "ode.desagregado.basico") + " " + idOdePadre;
		String titulo = utilidades.getI18NMessage(idioma, "ode.sin.titulo") + " (" + manifest.getIdentifier() + ")";
		getSrvPublicacionService().creacion(manifest.getIdentifier(), user, comentarios, titulo);
		return getSrvLocalizadorService().consultaLocalizador(manifest.getIdentifier());
	}
	
	private void copiaContenidos(File[] files, String origen, String destino) throws Exception {
		java.io.File fOrigen = new java.io.File(origen);
		java.io.File fDestino = new java.io.File(destino);
		if(logger.isDebugEnabled()) logger.debug("Copiando " + files.length + " ficheros de " + origen + " a " + destino);
		for(int i=0;i<files.length;i++) {
			java.io.File fHref = new java.io.File(fDestino,files[i].getHref());
			if(!fHref.getParentFile().exists()) {
				if(logger.isDebugEnabled()) logger.debug("Creando carpeta " + fHref.getParent());
				boolean created = fHref.getParentFile().mkdirs();
				if(!created) {
					logger.error("No se ha podido crear " + fHref.getParent());
					throw new Exception("No se ha podido crear " + fHref.getParent());
				}
			}
			java.io.File fFile = new java.io.File(fOrigen,files[i].getHref());
			if(logger.isDebugEnabled()) logger.debug("Copiando " + fFile.getPath());
			UtilesFicheros.copiar(fFile, fHref);
		}
	}

	private File[] obtenerFilesFromResources(Resource[] resources) {
		HashSet<File> files = new HashSet<File>();
		for(int i=0;i<resources.length;i++) {
//			File[] tmp = resources[i].getFile();
			if(logger.isDebugEnabled()) logger.debug("El recurso " + resources[i].getIdentifier() + " tiene " + resources[i].getFile().length + " ficheros");
			files.addAll(Arrays.asList(resources[i].getFile()));
		}
		if(logger.isDebugEnabled()) logger.debug("Se ha encontrado " + files.size() + " ficheros en total.");
		return (File[])files.toArray(new File[files.size()]);
	}
	
	private Resource[] obtenerResourcesFromItemsAsArray(Manifest manifest, Item[] items) throws Exception {
		return (Resource[])obtenerResourcesFromItems(manifest,items).toArray(new Resource[]{});
	}
	
	private Collection<Resource> obtenerResourcesFromItems(Manifest manifest, Item[] items)  throws Exception {
		ManifestAgrega ma = new ManifestAgrega(manifest);
		HashSet<Resource> resources = new HashSet<Resource>();
		if(logger.isDebugEnabled()) logger.debug("start obtenerResourcesFromItems with manifest = " + manifest + " : items = " + Arrays.toString(items));
		for(int i=0;i<items.length;i++) {
			if(items[i].getIdentifierref()!=null) {
				Resource resource = ma.obtenerResource(items[i].getIdentifierref());
				if(resource!=null) {
					if(logger.isDebugEnabled()) logger.debug("Recurso utilizado por " + items[i].getIdentifier() + " : " + resource.getIdentifier());
					boolean added = resources.add(resource);
					if(logger.isDebugEnabled()) logger.debug("Ha sido añadido al hashset? " + added);
				}
			}
			if(items[i].getItemCount() > 0 ) {
				if(logger.isDebugEnabled()) logger.debug("Iterando dentro de los hijos de " + items[i].getIdentifier());
				resources.addAll(obtenerResourcesFromItems(manifest, items[i].getItem()));
			}
		}
		if(logger.isDebugEnabled()) logger.debug("Se han encontrado " + resources.size() + " recursos");
		return resources;
	}
	
	/**
	 * Crea un objeto HTML con el código embebido suministrado. Inserta el
	 * código dado en una plantilla HTML simple, en el lugar del Body. No se
	 * chequea la validez o corrección del HTML resultante.
	 * 
	 * @param idOde Ode en el que quedará insertado
	 * @param contenido Código HTML a embeber
	 * @return  objeto HTML con el código embebido suministrado
	 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#crearObjetoEmbebido(java.lang.String,
	 *      java.lang.String)
	 */
	protected es.pode.empaquetador.negocio.servicio.ArchivoVO handleCrearObjetoEmbebido(
			java.lang.String idOde, java.lang.String contenido)
			throws java.lang.Exception {
		// Crear fichero html con "contenido"
		StringBuffer sb = new StringBuffer(utilidades
				.getProperty("embedded.initial"));
		sb.append("Titulo por defecto").append(
				utilidades.getProperty("embedded.middle"));
		sb.append(contenido).append(utilidades.getProperty("embedded.final"));

		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(idOde);
		String nombre = utilidades.getProperty("embedded.default.name");
		java.io.File fRutaTmpArchivo = utilidades.crearCarpetaSeguro(localizador, nombre);
		
		java.io.File fArchivo = new java.io.File(fRutaTmpArchivo, nombre.concat(".html"));
		
		FileWriter writer = new FileWriter(fArchivo);
		writer.write(sb.toString());
		writer.close();
		if(logger.isDebugEnabled()) logger.debug("Archivo HTML embedded generado en " + fArchivo.getPath());
		
		ArchivoVO salida = new ArchivoVO();
		salida.setEsFichero(Boolean.TRUE);
		salida.setEsProtegido(Boolean.TRUE);
		salida.setNombre(fArchivo.getName());
		salida.setMime("text/html");
		salida.setCarpetaPadre(fRutaTmpArchivo.getName());
		String href = localizador.getUrl().concat("/").concat(salida.getCarpetaPadre()).concat("/").concat(salida.getNombre());
		salida.setHref(href);
		return salida;
	}

	/**
	 * @return the utilidades
	 */
	public Utilidades getUtilidades() {
		return utilidades;
	}

	/**
	 * @param utilidades
	 *            the utilidades to set
	 */
	public void setUtilidades(Utilidades utilidades) {
		this.utilidades = utilidades;
	}

	/**
	 * @param cacheEmpaquetacion
	 *            the cacheEmpaquetacion to set
	 */
	public void setCacheEmpaquetacion(CacheEmpaquetacion cacheEmpaquetacion) {
		this.cacheEmpaquetacion = cacheEmpaquetacion;
	}

	/**
	 * @return the cacheEmpaquetacion
	 */
	public CacheEmpaquetacion getCacheEmpaquetacion() {
		return cacheEmpaquetacion;
	}

	private static Organization getOrganizacionPrincipal(Manifest manifest) {
		String principalId = manifest.getOrganizations().getDefault();
		int principalIndex = Arrays.binarySearch(manifest.getOrganizations()
				.getOrganization(), principalId, new OrganizationStringComparator());
		Organization principal = manifest.getOrganizations().getOrganization(
				principalIndex);
		return principal;
	}
	
	/**
	 * Copia los ficheros / carpetas especificados a la carpeta de destino
	 * deseada. A continuación elimina los ficheros / carpetas de origen con una
	 * llamada a eliminar.
	 * 
	 * Usa la operación cortar del servicio GestorArchivosService.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que estamos trabajando.
	 * @param carpetaDestino
	 *            Ruta relativa a la localizacion del ODE en que se esta
	 *            trabajando donde se desean copiar los ficheros / carpetas.
	 * @param ficheros
	 *            Ficheros / carpetas que se desean mover.
	 */
	protected void handleCortar(String identificador, String carpetaDestino, ArchivoVO[] ficheros) throws Exception {
		// Cortar o mover equivale a renombrar las referencias. Llamo a
		// renombrarFiles una vez por cada fichero
		Manifest manifest = getCacheEmpaquetacion().comprobarManifest(identificador);
		HashMap<String, String> cambios = new HashMap<String, String>(ficheros.length);
		// Preparo los pares viejo href - nuevo href
		for(int i=0;i<ficheros.length; i++) {
			String oldHref = ficheros[i].getCarpetaPadre()==null ? ficheros[i].getNombre() : ficheros[i].getCarpetaPadre().concat("/").concat(ficheros[i].getNombre());
			String newHref = carpetaDestino==null ? ficheros[i].getNombre() : carpetaDestino.concat("/").concat(ficheros[i].getNombre());
			cambios.put(oldHref, newHref);
		}
		// Llamo a cortar
		try {
			getSrvGestorArchivosService().cortar(identificador, carpetaDestino, ficheros);
		} catch (Exception e) {
			logger.error("Error al mover archivos",e);
			throw e;
		}
		// Renombro las referencias
//		Set<String> keys = cambios.keySet();
		Set<Map.Entry<String, String>> pares=cambios.entrySet();
		for (Iterator<Entry<String, String>> iterator = pares.iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
			if(logger.isDebugEnabled()) logger.debug("Renombrando referencias de " + entry.getKey() + " a " + entry.getValue());
			renombrarFiles(manifest, entry.getKey(), entry.getValue(), null);
		}
//		for(Iterator<String> it = keys.iterator();it.hasNext();) {
//			String key = it.next();
//			if(logger.isDebugEnabled()) logger.debug("Renombrando referencias de " + key + " a " + cambios.get(key));
//			renombrarFiles(manifest, key, cambios.get(key), null);
//		}
		
	}

	/**
	 * Parsea el fichero HTML que contiene el recurso embebido desde el
	 * empaquetador básico y devuelve el codigo tras descartar las etiquetas de
	 * cabecera y cuerpo.
	 * 
	 * @param idOde Identificador del objeto en edición.
	 * @param  file Ruta relativa al fichero que contiene el objeto embebido.
	 * @return Código del objeto embebido que se proporcionó en el momento de crear el recurso.
	 */
	@Override
	protected String handleEditarObjetoEmbebido(String idOde, String file) throws Exception {
		// TODO Auto-generated method stub
		LocalizadorVO localizador = this.getSrvLocalizadorService()
		.consultaLocalizador(idOde);
		String path=localizador.getPath();
		
		path = path.concat("/").concat(file);
		StringBuffer contenido = new StringBuffer ();

		java.io.BufferedReader br = null;
		String texto = "Embed";
		try{
			java.io.File f = new java.io.File(path);
			java.io.FileReader fr= new java.io.FileReader(f);
		
			br = new java.io.BufferedReader (fr);
			String linea;
			while (( linea = br.readLine()) != null){
				contenido.append(linea);
			} 
			
			StringBuffer inicio = new StringBuffer(utilidades.getProperty("embedded.initial"));
			inicio.append("Titulo por defecto").append(utilidades.getProperty("embedded.middle"));
			StringBuffer fin = new StringBuffer(utilidades.getProperty("embedded.final"));
			
			int start = inicio.length();
			int end = contenido.lastIndexOf(fin.toString());
			
			texto = contenido.substring(start, end);
		}
		catch(FileNotFoundException e){
			logger.error("Error, archivo " + path+ " no encontrado");
		} 
		catch (Exception e) {
			logger.error("Error al leer archivo en editarObjetoEmbebido", e);
		} 
		finally {
			if (br!= null) {
				br.close();
			}
		} 
		
		return texto;
	}

}