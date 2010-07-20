/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.fuentestaxonomicas.negocio.servicio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import es.pode.fuentestaxonomicas.negocio.soporte.EstructuraVdex;
import es.pode.fuentestaxonomicas.negocio.soporte.Taxon;
import es.pode.soporte.constantes.ConstantesAgrega;

import es.agrega.soporte.serverProperties.DependentServerProperties;


import org.apache.log4j.Logger;




public class SrvTaxonomiaServiceImpl
    extends es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaServiceBase
{ 
	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Es el constructor y hace la llamada a cargarTaxonomias()
	 * @throws Exception
	 */
	public SrvTaxonomiaServiceImpl() throws Exception {
		cargarTaxonomias();

	}

	private static HashMap hashMapCompleto = new HashMap();
	/**
	 * Devuelve los nombres de los identificadores que le pasamos como parámetro
	 * 
	 * @param listaHijos Lista de nombres
	 * @param name El namespace
	 * @return arrayHijos Un arrayList de los identificadores de esos nombres
	 */
	
//	saca los hijos de un nodo y los almacena en un arraylist
	private static ArrayList hijosDeNodo(List listaHijos, Namespace name){
		ArrayList arrayHijos = new ArrayList();
		Iterator iter = listaHijos.iterator();
		while ( iter.hasNext()){
			Element ele = (Element)iter.next();
			arrayHijos.add(ele.getChildText("termIdentifier",name));
		}
		return arrayHijos;
	}
	
	/**
	 * Crea la hashMap del árbol
	 * @param raiz La raiz del árbol
	 * @param nameSpace El namespace 
	 * @param hasmap Una hashMap
	 */
	
	//Devuelve en hasmap un árbol descuartizado
	private static void hashMapDeUnArbol(Element raiz, Namespace nameSpace,HashMap hasmap){
        
//		boolean isRoot = false;
        
        Taxon taxonRaiz = new Taxon();
		if( hasmap.isEmpty() ) {
			
			taxonRaiz = new Taxon();
			taxonRaiz.setId("vdex");
			taxonRaiz.setPadre(null);
			taxonRaiz.setValorTax("vdex");
			ArrayList hijosRaiz = new ArrayList();
//			System.out.println("El nombre de la raiz es "+raiz.getName());
			List hijos=raiz.getChildren("term", nameSpace);
			Iterator i = hijos.iterator();
			while (i.hasNext()){
				Element e = (Element)i.next();
				hijosRaiz.add((String)e.getChildText("termIdentifier",nameSpace));
			}
			taxonRaiz.setHijos(hijosRaiz);
			hasmap.put(taxonRaiz.getId(), taxonRaiz);
		}
			List hijos=raiz.getChildren("term", nameSpace);
	        Iterator i = hijos.iterator();
	        while (i.hasNext()){
	        	Taxon taxonAuxiliar = new Taxon();
//	            taxonAuxiliar.setPadre(raiz.getName());
	        	taxonAuxiliar.setPadre(raiz.getChildText("termIdentifier", nameSpace));
	        	Element e = (Element)i.next();
	        	String key = e.getChildText("termIdentifier",nameSpace);
	        	taxonAuxiliar.setId(e.getChildText("termIdentifier",nameSpace));
	        	
	        	Element listaCaption = e.getChild("caption",nameSpace);
	        	Element listaAmbito=e.getChild("description",nameSpace);
	        	
	        	String textoCaption=listaCaption.getChildText("langstring", nameSpace);
	        	String textoAmbito=null;
	        	if(listaAmbito!=null){
		        	textoAmbito=listaAmbito.getChildText("langstring", nameSpace);
		        	taxonAuxiliar.setAmbito(textoAmbito.trim());
		        	
		        	if(textoAmbito !=null){	        	
			        	taxonAuxiliar.setValorTax(textoCaption+ " ("+textoAmbito+")");
		        	}
	        	}
	        	else
	        		taxonAuxiliar.setValorTax(textoCaption);
	        	
	        	
	        	List listaHijos = e.getChildren("term",nameSpace);
	        	ArrayList arrayHijos = hijosDeNodo(listaHijos,nameSpace);
	        	taxonAuxiliar.setHijos(arrayHijos);

	        	hasmap.put(key,taxonAuxiliar);  
	        	hashMapDeUnArbol(e, nameSpace, hasmap);
	        }
	        
		               
	}
	
	/**
	 * Recoge los ficheros de la carpeta que se le pasa por parámetro
	 * @param src La URL de la carpeta
	 * @return lista Lista de ficheros de la carpeta
	 * @throws Exception
	 */
	//Almacena en una lista todos los ficheros de la carpeta que se le pasa por parámetro.
	private static List getFiles(String src) throws Exception{
        //Creamos el Objeto File con la URL que queremos desplegar
        File dir = new File(src);
        List lista = new ArrayList();
        if (dir.isDirectory()) {
            if (!dir.exists()) {
                throw new Exception("Error: El directorio no existe");
            }
            //tomamos los ficheros contenidos en la URL dada
            String[] archivos = dir.list();
            //agregamos cada fichero en una lista
            for(int i=0;i<archivos.length;i++)
            {
            	if (archivos[i].endsWith(".xml"))
            		lista.add(archivos[i]);
            }
                
        }
        return lista;
    }
	
	/**
	 * Carga las Taxonomias de nombre arbol_curricular
	 * @throws Exception
	 */
	private  void cargarTaxonomias() throws Exception{
		
		String rutaproperties = null;
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		
		try {
			is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties fproperties = new Properties();
			fproperties.load(is);
			rutaproperties = fproperties.getProperty("rutaArbolCurricular");
			
//			tomamos el contenido de la carpeta en la lista
	        List ficheros = getFiles(rutaproperties);
	        
	        for(int i=0;i<ficheros.size();i++){
	        	String nombreFich = (String)ficheros.get(i);
	        	File docFile = new File(rutaproperties+(String)ficheros.get(i));
	        	Document doc = null;
	        	try{
	          		SAXBuilder builder = new SAXBuilder(false);
	        		doc = builder.build(docFile);
	        		Element raiz = doc.getRootElement();
	        		Namespace nameSpace = raiz.getNamespace();
	        		Element vocab=raiz.getChild("vocabName", nameSpace);
	        		String vocabName=vocab.getChildText("langstring", nameSpace);
	        		HashMap hasmap = new HashMap();
	        		hashMapDeUnArbol(raiz, nameSpace,hasmap);
	        		EstructuraVdex estructura=new EstructuraVdex();
	        		estructura.setVocabName(vocabName);
	        		estructura.setHashMap(hasmap);
	        		hashMapCompleto.put(nombreFich,estructura);
	        	}catch (Exception e) {
	        		logger.error("Error en parseo sax", e);
	    			throw new RuntimeException(e);
	    			//e.printStackTrace();
	    		}
	        }
	        
	        rutaproperties = fproperties.getProperty("rutaTaxonomia");
			
//			tomamos el contenido de la carpeta en la lista
	        ficheros= null;
	        ficheros = getFiles(rutaproperties);
	        
	        for(int i=0;i<ficheros.size();i++){
	        	String nombreFich = (String)ficheros.get(i);
	        	File docFile = new File(rutaproperties+(String)ficheros.get(i));
	        	Document doc = null;
	        	try{
	          		SAXBuilder builder = new SAXBuilder(false);
	        		doc = builder.build(docFile);
	        		Element raiz = doc.getRootElement();
	        		Namespace nameSpace = raiz.getNamespace();
	        		Element vocab=raiz.getChild("vocabName", nameSpace);
	        		String vocabName=vocab.getChildText("langstring", nameSpace);
	        		HashMap hasmap = new HashMap();
	        		hashMapDeUnArbol(raiz, nameSpace,hasmap);
	        		EstructuraVdex estructura=new EstructuraVdex();
	        		estructura.setVocabName(vocabName);
	        		estructura.setHashMap(hasmap);
	        		hashMapCompleto.put(nombreFich,estructura);
	        	}catch (Exception e) {
	        		logger.error("Error en parseo sax", e);
	    			throw new RuntimeException(e);
	    			//e.printStackTrace();
	    		}
	        }
	        

		} catch (IOException e) {
			logger.error("Error: Fichero no encontrado: /fuentestaxonomicas.properties");
			throw new RuntimeException(e);
			//e.printStackTrace();
		}finally{
			if (is != null){
				try{
					is.close();
				}catch (IOException e){
					logger.error(e);
				}
			}
		}
        
	}
	
	/**
	 * Obtiene los hijos del nodo que tenga el identificador id de la Taxonomia de nombre nomTaxonomia con el idioma que le pasamos por parámetro
	 * @param id Identificador del nodo
	 * @param nomTaxonomia Nombre de la Taxonomia
	 * @param idioma Idioma de la Taxonomia
	 * @return TaxonVO[] Array de TaxonVO que contiene los hijos del nodo
	 * @throws Exception
	 */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerNodos(java.lang.String id, java.lang.String nomTaxonomia, java.lang.String idioma)
        throws java.lang.Exception
    {
        //@todo implement protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerNodos(java.lang.String id, java.lang.String nomTaxonomia, java.lang.String idioma)
    	
    	Collection taxones = new ArrayList();
    	String ambitoProp = null;
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
    	
    	try{
    		String nodo=ConstantesAgrega.AMBITO_NODO;
    		String ambito= DependentServerProperties.getInstance().getProperty(nodo);
   
//	    	String ambito= System.getProperty("nodo");
	    	
	    	is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties fproperties = new Properties();
			fproperties.load(is);
			ambitoProp = ConstantesAgrega.AMBITO_GENERAL;
	    	
			if(ambito==null){
	    		ambito=ambitoProp;
	    	}
			String nombreTax=fproperties.getProperty("arbolCurricular");
    		if(nombreTax.equals(nomTaxonomia)){
    			String nomTaxonomiaAgrega=obtenerArbolcurricularAgrega(idioma);
    			int posicion=nomTaxonomiaAgrega.lastIndexOf("_"+idioma);
    			if(posicion==0){
    				posicion=nomTaxonomiaAgrega.lastIndexOf("_es");
    			}
    			nomTaxonomia=nomTaxonomiaAgrega.substring(0, posicion);
    		}
	    	HashMap hasmap = new HashMap();
	    	EstructuraVdex estructura=(EstructuraVdex)hashMapCompleto.get(nomTaxonomia+"_"+idioma+".xml");
			hasmap = estructura.getHashMap();
			String vocabName=estructura.getVocabName();
			
			if (hasmap!=null){
				Taxon tax = (Taxon)hasmap.get(id.trim());
				ArrayList arr = tax.getHijos();
				for (Iterator iter = arr.iterator(); iter.hasNext();) {
					boolean bandera=false;
					String idHijo = (String)iter.next();
					Taxon taxAux = (Taxon)hasmap.get(idHijo);
					String amb=taxAux.getAmbito();
					
					if(!(amb.equals(""))){
					
					StringTokenizer token = new StringTokenizer(amb, ",");
					while (token.hasMoreElements()&&(!bandera)) {
						String ambLeido=token.nextElement().toString().trim();
						if(ambito.equalsIgnoreCase(ambLeido)){
							bandera=true;
							amb=ambLeido;
						}
					}
					if(ambito.equals(ambitoProp)){
						TaxonVO taxVO = new TaxonVO();
						taxVO.setId(taxAux.getId().trim());
						taxVO.setValorTax(taxAux.getValorTax().trim());
						taxVO.setEsHoja(new Boolean(taxAux.getHijos().isEmpty()));
						taxVO.setVocabName(vocabName);
						taxones.add(taxVO);
					}
					if(((amb.equals(ambito))||(amb.equals(ambitoProp)))&&(!ambito.equals(ambitoProp))){
					
						TaxonVO taxVO = new TaxonVO();
						taxVO.setId(taxAux.getId().trim());
						taxVO.setValorTax(taxAux.getValorTax().trim());
		//				taxVO.setAmbito(taxAux.getAmbito().trim());
						
			//			********************código nuevo***************************
						
						taxVO.setEsHoja(new Boolean(taxAux.getHijos().isEmpty()));
						taxVO.setVocabName(vocabName);
			//			********************términa código nuevo*******************			
						
						taxones.add(taxVO);
					}
					}else{
						TaxonVO taxVO = new TaxonVO();
						taxVO.setId(taxAux.getId().trim());
						taxVO.setValorTax(taxAux.getValorTax().trim());
		//				taxVO.setAmbito(taxAux.getAmbito().trim());
						
			//			********************código nuevo***************************
						
						taxVO.setEsHoja(new Boolean(taxAux.getHijos().isEmpty()));
						taxVO.setVocabName(vocabName);
			//			********************términa código nuevo*******************			
						
						taxones.add(taxVO);
					}
				}
			}
			

			
			
	    }catch(Exception e){
			e.printStackTrace();
		}
	    return (TaxonVO[]) taxones.toArray(new TaxonVO[taxones.size()]);
    }

   /**
    * Obtiene los nodos padre de la taxonomia
    * @param nomTaxonomia Nombre de la Taxonomia
    * @param idioma Idioma de la Taxonomia
    * @return TaxonVO[] Un array de TaxonVO que contiene los hijos del nodo vdex
    * @throws Exception
    */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTaxonomia(java.lang.String nomTaxonomia, java.lang.String idioma)
        throws java.lang.Exception
    {
        //@todo implement protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTaxonomia(java.lang.String nomTaxonomia, java.lang.String idioma)
    	String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
    	String nombreTax=fproperties.getProperty("arbolCurricular");
		if(nombreTax.equals(nomTaxonomia)){
			String nomTaxonomiaAgrega=obtenerArbolcurricularAgrega(idioma);
			int posicion=nomTaxonomiaAgrega.lastIndexOf("_"+idioma);
			if(posicion==0){
				posicion=nomTaxonomiaAgrega.lastIndexOf("_es");
			}
			nomTaxonomia=nomTaxonomiaAgrega.substring(0, posicion);
		}
    	return handleObtenerNodos("vdex", nomTaxonomia, idioma);
    }

    /**
     * Obtiene el taxonPath
     * @param id Identificador del Taxon en la hashMap
     * @param nomTaxonomia Nombre de la Taxonomia
     * @param idioma Idioma de la Taxonomia
     * @return TaxonVO[] Array de TaxonVO que contiene todos los taxones del taxonPath
     * @throws Exception
     */

	protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTaxonPath(java.lang.String id, java.lang.String nomTaxonomia, java.lang.String idioma) 
	throws java.lang.Exception {
		
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
    	String nombreTax=fproperties.getProperty("arbolCurricular");
		if(nombreTax.equals(nomTaxonomia)){
			String nomTaxonomiaAgrega=obtenerArbolcurricularAgrega(idioma);
			int posicion=nomTaxonomiaAgrega.lastIndexOf("_"+idioma);
			if(posicion==0){
				posicion=nomTaxonomiaAgrega.lastIndexOf("_es");
			}
			nomTaxonomia=nomTaxonomiaAgrega.substring(0, posicion);
		}
		
		Collection taxones = new ArrayList();
    	HashMap hasmap = new HashMap();
    	EstructuraVdex estructura=(EstructuraVdex)hashMapCompleto.get(nomTaxonomia+"_"+idioma+".xml");
		hasmap = estructura.getHashMap();
		String vocabName=estructura.getVocabName();
		try{
			if (hasmap!=null){
				boolean flag=true;
				while(flag){
					if(id ==null){
						flag=false;
					}else{
						Taxon tax = (Taxon)hasmap.get(id);
						if(tax!=null){
							TaxonVO taxonAux=new TaxonVO();
							taxonAux.setId(tax.getId().trim());
							taxonAux.setVocabName(vocabName);
							String taxo=tax.getValorTax().trim();
							int num=taxo.lastIndexOf("(");
							
							if(num>0){
								taxo=taxo.substring(0, num).trim();
							}
							taxonAux.setValorTax(taxo);
							
							taxonAux.setEsHoja(new Boolean(tax.getHijos().isEmpty()));
							taxones.add(taxonAux);
							id=tax.getPadre();
							
							if(id!=null)
								id=id.trim();
						}else
							id=null;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return (TaxonVO[]) taxones.toArray(new TaxonVO[taxones.size()]);
		
		// TODO Auto-generated method stub
	}

	protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonConRutaVO[] handleObtenerTaxonomiaCompletaPreorden(java.lang.String nomTaxonomia, java.lang.String idioma) throws Exception{
		logger.debug("ASC- ENTRAMOS EN EL METODO handleObtenerTaxonomiaCompletaPreorden ");
		TaxonConRutaVO[] taxPreorden=null;
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
    	String nombreTax=fproperties.getProperty("arbolCurricular");
    	if(nombreTax.equals(nomTaxonomia)){
			String nomTaxonomiaAgrega=obtenerArbolcurricularAgrega(idioma);
			logger.debug("ASC- NOMTAXONOMIAAGREGA  " + nomTaxonomiaAgrega);
			int posicion=nomTaxonomiaAgrega.lastIndexOf("_"+idioma);
			if(posicion==0){
				posicion=nomTaxonomiaAgrega.lastIndexOf("_es");
			}
			nomTaxonomia=nomTaxonomiaAgrega.substring(0, posicion);
		}
		
		EstructuraVdex ev= (EstructuraVdex)hashMapCompleto.get(nomTaxonomia+"_"+idioma+".xml");
		logger.debug("ASC- RECOGEMOS ESTRUCTURAVDEX DE LA HASHMAP EL FICHERO ES " + nomTaxonomia+"_"+idioma+".xml" );
		
		if (ev!=null) {
			HashMap hashTaxonomia = ev.getHashMap();
			ArrayList taxonomia =new ArrayList();
			if (hashTaxonomia != null){
				Taxon taxonRaiz = (Taxon) hashTaxonomia.get("vdex");
				taxonomiaPreordenRec(nomTaxonomia,idioma,taxonRaiz,taxonomia);
			}
			taxPreorden= (TaxonConRutaVO[]) taxonomia.toArray(new TaxonConRutaVO[taxonomia.size()]);
		}
		logger.debug("ASC- RESULTADO A DEVOLVER DE TAXPREORDEN " + taxPreorden);
		return taxPreorden;
	}
	private void taxonomiaPreordenRec(String nomTaxonomia, String idioma,Taxon taxon,ArrayList taxonomia) throws Exception{
		
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
		String nombreTax=fproperties.getProperty("arbolCurricular");
    	if(nombreTax.equals(nomTaxonomia)){
			String nomTaxonomiaAgrega=obtenerArbolcurricularAgrega(idioma);
			int posicion=nomTaxonomiaAgrega.lastIndexOf("_"+idioma);
			if(posicion==0){
				posicion=nomTaxonomiaAgrega.lastIndexOf("_es");
			}
			nomTaxonomia=nomTaxonomiaAgrega.substring(0, posicion);
		}
		
		EstructuraVdex ev= (EstructuraVdex)hashMapCompleto.get(nomTaxonomia+"_"+idioma+".xml");
		HashMap hashTaxonomia =null; 
		if (ev!=null) { 
			hashTaxonomia = ev.getHashMap();
		}
		if (hashTaxonomia != null){
			ArrayList hijos = taxon.getHijos();
			Iterator i = hijos.iterator();
			TaxonConRutaVO taxonRuta = new TaxonConRutaVO();
			taxonRuta.setId(taxon.getId());
			taxonRuta.setValorTax(taxon.getValorTax());
			taxonRuta.setTaxonPath(this.handleObtenerTaxonPath(taxon.getId(), nomTaxonomia, idioma));
			taxonomia.add(taxonRuta);
			if (hijos.size()>0){
				while (i.hasNext()){
					String hijo = (String) i.next();
					Taxon taxonHijo = (Taxon) hashTaxonomia.get(hijo);
			
					taxonomiaPreordenRec(nomTaxonomia,idioma,taxonHijo,taxonomia);
				}
			}
		}
	}
	
	private String obtenerArbolcurricularAgrega(String idioma) throws Exception{
		
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		
		String rutaArbolCurricular=fprop.getProperty("rutaArbolCurricular").toString();
		String nombreTax=fprop.getProperty("arbolCurricular");		
		List ficheros = getFiles(rutaArbolCurricular);
		String nomFich=null;
		String nomTaxonomia=null;
		boolean verdad=false;
		
		for(int i=0;i<ficheros.size();i++){
			if(!verdad){
				String nombreFich=ficheros.get(i).toString();
				String terminacion="_" + idioma +".xml";

				// Only check files with the right ending...
				if(nombreFich.endsWith(terminacion)){
					
					int posicion=nombreFich.lastIndexOf(terminacion);
					nomFich = nombreFich.substring(0, posicion);
					
					// Make sure we match the name in the properties file
		    		if(nomFich.equals(nombreTax)){
		    			nomTaxonomia = nomFich + "_" + idioma;
		    			verdad = true;
		    		}
					
				}else if((!verdad)&&(i==ficheros.size()-1)){
					terminacion="";
					terminacion=terminacion+"_es.xml";
					for(int j=0;j<ficheros.size();j++){
						String nombre=ficheros.get(j).toString();
						boolean acabaEnES=nombre.endsWith(terminacion);
						if(acabaEnES){
							int pos=nombre.lastIndexOf(terminacion);
							nomFich=nombre.substring(0, pos);
							nomTaxonomia=nomFich+"_es";
							idioma="es";
						}
					}
				}
			}
		}
		return nomTaxonomia;
	}

	protected void handleRecargar() throws Exception {
		cargarTaxonomias();
		
	}


	protected String handleObtenerVocabName(String nomTaxonomia, String idioma) throws Exception {
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		String vocabName=null;
		
		String nombreArbol=fprop.getProperty("arbolCurricular").toString();
		if(nombreArbol.equals(nomTaxonomia)){
			String nombreTaxonomia=this.obtenerArbolcurricularAgrega(idioma);
			EstructuraVdex estructuraTaxonomia = (EstructuraVdex)hashMapCompleto.get(nombreTaxonomia+".xml");
			if (estructuraTaxonomia!=null){
				vocabName=estructuraTaxonomia.getVocabName().toString();
			}
				
		}
		else if(!nombreArbol.equals(nomTaxonomia)){
			EstructuraVdex estructuraTaxonomia = (EstructuraVdex)hashMapCompleto.get(nomTaxonomia+"_"+idioma+".xml");
			if(estructuraTaxonomia!=null){
				vocabName=estructuraTaxonomia.getVocabName().toString();
			}
		}
		if(vocabName==null)
			vocabName="";
		return vocabName;
	}

	protected TaxonPathVO[] handleObtenerVariosTaxonPaths(String[] ides, String nomTaxonomia, String idioma) throws Exception {
		
			List array=new ArrayList();
			TaxonPathVO[] path=null;
			try{
				for(int i=0;i<ides.length;i++){
					TaxonVO[] taxonesVuelta=this.obtenerTaxonPath(ides[i], nomTaxonomia, idioma);
					
					if(taxonesVuelta!=null && taxonesVuelta.length>0){	
						TaxonPathVO taxonPath=new TaxonPathVO();
						taxonPath.setDatos(taxonesVuelta);
						array.add(taxonPath);
					}
				}
				path=(TaxonPathVO[])array.toArray(new TaxonPathVO[array.size()]);
				}catch(Exception e){
					e.printStackTrace();
				}
		return  path;
	}

	protected String[] handleObtenerVocabNames(String[] nomTaxonomias, String idioma) throws Exception {
		String[] vueltaVocabs=null;
		try{
			vueltaVocabs=new String[nomTaxonomias.length];
			for(int i=0;i<nomTaxonomias.length;i++){
				String vocabName=this.obtenerVocabName(nomTaxonomias[i], idioma);
				vueltaVocabs[i]=vocabName;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vueltaVocabs;
	}

	

//	public DatosSalidaTaxonPathsVO obtenerVariosTaxonPaths(String[] ides, String nomTaxonomia, String idioma) {
//		try{
//			Collection coleccion=new ArrayList();
//			for(int i=0;i<ides.length;i++){
//				TaxonVO[] taxonesVuelta=this.obtenerTaxonPath(ides[i], nomTaxonomia, idioma);
//				if(taxonesVuelta!=null && taxonesVuelta.length>0){	
//					coleccion.add(taxonesVuelta);
//					datos.setDatosSalida(coleccion);
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return datos;
//	}



	
	
}
