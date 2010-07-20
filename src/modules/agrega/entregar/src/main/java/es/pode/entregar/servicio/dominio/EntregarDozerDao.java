/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.entregar.servicio.dominio;

import java.util.ArrayList;
import java.util.Arrays;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.entregar.negocio.servicios.ControlModeVO;
import es.pode.entregar.negocio.servicios.ItemVO;
import es.pode.entregar.negocio.servicios.ManifestVO;
import es.pode.entregar.negocio.servicios.OrganizacionVO;
import es.pode.entregar.negocio.servicios.RecursoVO;
import es.pode.entregar.negocio.servicios.SecuenciaVO;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Organizations;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.castor.Resources;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;

public class EntregarDozerDao {

	public EntregarDozerDao() {
		super();

	}

	Log logger = LogFactory.getLog(this.getClass());

	private MapperIF beanMapperAux = null;

	private SCORM2004Dao scorm = null;

	public MapperIF getBeanMapperAux() {
		return beanMapperAux;
	}

	public void setBeanMapperAux(MapperIF beanMapperAux) {
		this.beanMapperAux = beanMapperAux;
	}

	public ManifestVO transformarManifest2VO(Manifest manifest) {
		ManifestVO manifestVo = null;
		ArrayList arrayFinal = new ArrayList(5);
		OrganizacionVO[] arrayOrganizaciones = this
				.generaOrganizaciones(manifest);

		arrayFinal.addAll(Arrays.asList(arrayOrganizaciones));
		manifestVo = new ManifestVO();
		manifestVo.setTitulo(manifest.getIdentifier());
		manifestVo.setOrganizaciones((OrganizacionVO[]) arrayFinal
				.toArray(new OrganizacionVO[arrayFinal.size()]));
		return manifestVo;
	}

	private OrganizacionVO[] generaOrganizaciones(Manifest manifest) {
		OrganizacionVO[] arrayOrganizaciones = null;
		// organizaciones
		Organizations orgs = manifest.getOrganizations();
		// recursos
		Resources resources = manifest.getResources();
		// array de organizaciones
		Organization arrayOrgs[] = orgs.getOrganization();
		// tamaño del array de organizaciones
		int iLength = arrayOrgs.length;
		//--------- ManifestAgrega te trae las Secuencias -------
		ManifestAgrega ma= new ManifestAgrega();
		ma.setManifest(manifest); // le pasamos este parametro al metodo que rellena la secuencia
		// -- Fin declaracion ManifestAgrega --
		
		
		//Obtenemos los todos los recursos del manifest y submanifest, con la ruta correcta, teniendo en cuenta los base
		ArrayList submSalida = new ArrayList();
		aplanaSubmanifest(manifest, submSalida);
		Manifest[] lsubm = (Manifest[]) submSalida.toArray(new Manifest[submSalida.size()]);
		Resources resSalida = new Resources();
		aplanaRecursos(manifest, resSalida,manifest.getBase()!=null?manifest.getBase():""); //Formamos una lista con todos los Recursos del manifest global
	
		
		
		
		//// Arreglamos Submanifiestos
		arrayOrganizaciones = new OrganizacionVO[iLength];
		for (int i = 0; i < iLength; i++) {
			arrayOrganizaciones[i] = (OrganizacionVO) this.getBeanMapperAux().map(arrayOrgs[i], OrganizacionVO.class);
			ItemVO[] arrayItem = arrayOrganizaciones[i].getItems();
			ArrayList arrayItemAux = new ArrayList();

			for (int cont =0; cont<arrayItem.length;cont++){
				ItemVO item = arrayItem[cont];

				Resource  recurso = null;
				
				try {
					ma.obtenerResource(item.getIdItem_ref());
				} catch (Exception e) {
					logger.error("Recurso " + item.getIdItem_ref() + " no encontrado");
				}
				
				
				if (recurso != null){
					arrayItemAux.add(item);
				}else if (item.getItemHijos().length > 0){
					arrayItemAux.add(item);
				} else if (item.getIdItem_ref()==null) {
					arrayItemAux.add(item);
				} else if ((recurso==null)) { //(esSubm) && 
					arrayItemAux.add(item);
				}
			}//fin for
			arrayItem = (ItemVO[]) arrayItemAux.toArray(new ItemVO[arrayItemAux.size()]);
			arrayOrganizaciones[i].setItems(arrayItem);

			this.generaRecursos(arrayItem, resSalida, manifest.getBase(),lsubm);
			//rellenamos para cada Organizacion y sus hijos los datos de secuencia y navegacion iniciales
			try {
				obtenerSeqNavOrg(arrayOrganizaciones[i],ma);
			} catch (Exception e) {
				logger.debug("ASC- MODULO ENTREGAR; METODO generaOrganizaciones ---> Error obteniendo Secuencia");
			}
		    //fin secuencia y navegacion
		}//fin for orgs
		logger.debug(arrayOrganizaciones);
		return arrayOrganizaciones;
	}
	
	//Metodo que une dos arrays de ItemVO
	private ItemVO[] combinarHijos(ItemVO[] hijosSubmi, ItemVO[] hijosAntes) {
		ItemVO[] hijosComb = null;
		ArrayList arrHA = new ArrayList();
		if (hijosAntes != null){
			for (int j=0; j< hijosAntes.length; j++) {
				arrHA.add(hijosAntes[j]);
			}
		}
		if (hijosSubmi!=null) {
			for (int z=0; z< hijosSubmi.length; z++) {
				arrHA.add(hijosSubmi[z]);
			}
		}
		hijosComb = (ItemVO[]) arrHA.toArray(new ItemVO[arrHA.size()]);
		return hijosComb;
	}
	
	//Metodo para aplanar submanifiesto
	private void aplanaSubmanifest(Manifest manifest, ArrayList listSalida) {
		if (manifest!=null) {
			//listSalida.add(manifest);
			Manifest[] listSubAnidados = manifest.getManifest();
			if (listSubAnidados!=null) {
				for (int i=0; i<listSubAnidados.length;i++) {
					listSalida.add(listSubAnidados[i]);
					//llamada a los hijos
					aplanaSubmanifest(listSubAnidados[i], listSalida);
				}
			
			}
		}
	}
	
	//Metodo para aplanar recursos dado el Manifest, te devuelve un array con todos los recursos
	private void aplanaRecursos(Manifest manifest, Resources listSalida,String base) {
	//	String base="";
		if (manifest!= null) {
			Resources res = manifest.getResources();
			String baseManifest = manifest.getBase()!=null?manifest.getBase():"";
			base=base!=""?base + "/" + baseManifest:baseManifest;
			for (int r=0; r<res.getResourceCount(); r++) {
				Resource rAux= res.getResource(r);
				if ((base!=null) && (!base.equals(""))) {
					String href=rAux.getHref();
					rAux.setHref(base + "/" + href);					
				}
				listSalida.addResource(rAux);
			}
			Manifest[] listSubAnidados = manifest.getManifest();
			if (listSubAnidados!=null) {
				for (int i=0; i<listSubAnidados.length;i++) {
					aplanaRecursos(listSubAnidados[i], listSalida,base);
				}
			}
		}
	}
	
	private ArrayList recogeItemsSubm(Manifest submanif, String idPadre, Resources resources) {
		
		ArrayList itemsOrgSub = new ArrayList();
		if (submanif!=null){//si tiene hijos no les hace nada hacer recursividad!
			Organizations orgs = submanif.getOrganizations();
//			Resources res = submanif.getResources();
			String base= submanif.getBase();
			for (int or=0; or< orgs.getOrganizationCount(); or++) {
				ItemVO itOrg = new ItemVO();
				ArrayList itemsSubm = new ArrayList();
				itOrg.setIdItem(orgs.getOrganization(or).getIdentifier());
				itOrg.setIdPadre(idPadre);
				itOrg.setTitulo(orgs.getOrganization(or).getTitle());
				for (int oi=0; oi<orgs.getOrganization(or).getItemCount();oi++) {
					ItemVO it= (ItemVO) this.getBeanMapperAux().map(orgs.getOrganization(or).getItem(oi), ItemVO.class);
					Resource resI = getResourceByIdentifier(resources,it.getIdItem_ref());
					if (resI!=null) {
						RecursoVO rec=(RecursoVO) this.getBeanMapperAux().map(resI, RecursoVO.class);
//						String href= base.concat("/" + rec.getHrefRec());
//						rec.setHrefRec(href);
						it.setRecurso(rec);					  
					}
					if ((it.getItemHijos()!=null) && (it.getItemHijos().length>0)) {
						generaRecursos(it.getItemHijos(), resources, base, submanif.getManifest());
					}
					itemsSubm.add(it);
				}
				ItemVO[] itemHijos = (ItemVO[]) itemsSubm.toArray(new ItemVO[itemsSubm.size()]);
				itOrg.setItemHijos(itemHijos);
				itemsOrgSub.add(itOrg);
			}
			
		}
		
		return itemsOrgSub;
	}
	
	// -- METODOS QUE RELLENAN LOS NUEVOS DATOS PARA SECUENCIA Y NAVEGABILIDAD DE ORGANIZACIONES E ITEMS
	private void obtenerSeqNavOrg(OrganizacionVO orgs, ManifestAgrega ma) 
	   throws Exception, ParseadorException{
		
		if (orgs!=null) {
			String idPadre = orgs.getIdOrg();
			ItemVO[] items = orgs.getItems();
			//rellenamos los IdPadre de los items con el idOrg
			if (items !=null) {
				obtenerSeqNavItems(idPadre, items, ma, orgs.getIdOrg());
			}
			//--- Rellenamos la secuencia de la organizacion ---  
			try {
				es.pode.parseadorXML.castor.Sequencing secuenciaOrg= ma.obtenerSequencing(idPadre);
				if (secuenciaOrg !=null) {
					es.pode.parseadorXML.castor.ControlMode cMode = secuenciaOrg.getControlMode();
					ControlModeVO controlMode = new ControlModeVO();
					controlMode.setChoice(new Boolean(cMode.getChoice()));
					controlMode.setChoiceExit(new Boolean(cMode.getChoiceExit()));
					controlMode.setFlow(new Boolean(cMode.getFlow()));
					controlMode.setForwardOnly(new Boolean(cMode.getForwardOnly()));
					SecuenciaVO secuenciavo = new SecuenciaVO();
					secuenciavo.setControlMode(controlMode);
					orgs.setSecuenciaOrg(secuenciavo);
				}
			} catch (ParseadorException e) {
				throw new Exception("ASC- MODULO ENTREGAR; METODO rellenaIdPadre ---> Error obteniendo Secuencia ");
			}
			 // -- rellenamos opciones de navegacion --
			orgs.setClicable(new Boolean(true));
			// id de org Padre sera null
			orgs.setIdPadre(null);
			// -- Fin Navegacion --
			
		}
	}
	// rellena los idPadre de los hijos de forma recursiva
	private void obtenerSeqNavItems(String idItem, ItemVO[] arrayItems, ManifestAgrega ma, String idOrg) 
	   throws Exception, ParseadorException{
		
		if (arrayItems !=null){
		  for (int it=0; it<arrayItems.length; it++ ){
			  // -- actualizamos la secuencia de los Items si la tienen --
			  try {
				es.pode.parseadorXML.castor.Sequencing seqItem = ma.obtenerSequencing(arrayItems[it].getIdItem());
				if ((seqItem !=null) && (seqItem.getControlMode() != null)) {
				 es.pode.parseadorXML.castor.ControlMode cMode = seqItem.getControlMode();
				 ControlModeVO controlMode = new ControlModeVO();
				 controlMode.setChoice(new Boolean(cMode.getChoice()));
				 controlMode.setChoiceExit(new Boolean(cMode.getChoiceExit()));
				 controlMode.setFlow(new Boolean(cMode.getFlow()));
				 controlMode.setForwardOnly(new Boolean(cMode.getForwardOnly()));
				 SecuenciaVO secuenciavo = new SecuenciaVO();
				 secuenciavo.setControlMode(controlMode);
				 arrayItems[it].setSecuenciaItem(secuenciavo);
				}
			  } catch (ParseadorException e) {
				  throw new Exception("ASC- MODULO ENTREGAR; METODO rellenaHijosItems---> Error obteniendo Secuencia ");
			  }
			  // -- Fin secuencia Items --
			  // -- rellenamos opciones de navegacion --
			  
			  arrayItems[it].setClicable(new Boolean(true));
			  arrayItems[it].setIdOrg(idOrg!=null?idOrg:"");
			  arrayItems[it].setIdPadre(idItem);
			  //llamada recursiva
			  obtenerSeqNavItems(arrayItems[it].getIdItem(),arrayItems[it].getItemHijos(), ma , idOrg);
			  // -- fin navegacion --
		  }
		}
	}
	// -- FIN SEQUENCIA Y NAV --
	
	
	private String obtieneOrg (String idElem, ManifestAgrega ma) {
		String idOrg=null;
		
		Object obj = ma.buscarPadre(idElem);
		if (obj instanceof Organization) {
			Organization newObj = (Organization) obj;
			idOrg=newObj.getIdentifier();
			return idOrg;
		} else if (obj==null) {
			return idOrg;
		}
		else {
			es.pode.parseadorXML.castor.Item objItem = (es.pode.parseadorXML.castor.Item) obj;
			idOrg=obtieneOrg(objItem.getIdentifier(), ma);
			return idOrg;
		}
		
	}
	
	private void generaRecursos(ItemVO[] arrayItems, Resources resources,
			String base, Manifest[] submanif) {
		
		ItemVO item = null;
		for (int j = 0; arrayItems != null && j < arrayItems.length; j++) {
			item = arrayItems[j];
			Resource recurso = getResourceByIdentifier(resources, item
					.getIdItem_ref());
			//Manifest[] submanif=manifest.getManifest();
			if (submanif!=null) {
				for (int s=0; s<submanif.length;s++) {
					String identifSub = submanif[s].getIdentifier();
					if ((item.getIdItem_ref()!=null) && (item.getIdItem_ref().equals(identifSub))) {
						//transformacion de Manifest A Item
						ArrayList arrItSubm = new ArrayList();
						arrItSubm=recogeItemsSubm(submanif[s], item.getIdItem(), resources);
						ItemVO[] hijosSubmi = (ItemVO[])arrItSubm.toArray(new ItemVO[arrItSubm.size()]);
						ItemVO[] hijosAntes=item.getItemHijos();
						ItemVO[] hijosSubm = combinarHijos(hijosSubmi, hijosAntes);
						
						if (hijosSubmi != null){
							if (hijosSubmi.length>0){
								item.setTitulo(hijosSubmi[0].getTitulo());
								item.setItemHijos(hijosSubmi[0].getItemHijos());
							}
						}
						
						
//						item.setItemHijos(hijosSubm);
						//manif=  submanif[s].getManifest();
						
					}
				}
			}
			if ((item.getIdItem_ref() != null) && (recurso != null)) {
				item.setRecurso((RecursoVO) this.getBeanMapperAux().map(
						recurso, RecursoVO.class));
				// Si existe en el submanifest "Base", se inserta delante del
				// titulo
				// de HrefRec
				//ya no hace falta poner el base, se pone en el metodo que aplana los recursos
//				if (base != null) {
//					item.setHrefRec(base.concat("/" + recurso.getHref()));
//					item.getRecurso().setHrefRec(item.getHrefRec());
//				}
			}
			// resources.getResourceByIdentifier(item.getIdItem_ref() tiene que
			// ser !null
			this.generaRecursos(item.getItemHijos(), resources, base, submanif);
		}
	}

	private Resource getResourceByIdentifier(Resources resources, String id) {
		Resource res = null;
		
		if(resources == null) throw new NullPointerException("resources=null");

		boolean notFound=true;
		if(id!=null) {
			for(int i=0;i<resources.getResourceCount()&&notFound;i++) {
				if(id.equals(resources.getResource(i).getIdentifier())) {
					res = resources.getResource(i);
					notFound=false;
				}
			}
		} else logger.warn("Solicitando recurso con id null en EntregarDozerDao.getResourceByIdentifier");
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public SCORM2004Dao getScorm() {
		return scorm;
	}

	public void setScorm(SCORM2004Dao scorm) {
		this.scorm = scorm;
	}

}
