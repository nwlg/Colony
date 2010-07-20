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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import es.pode.fuentestaxonomicas.negocio.soporte.EstructuraVdex;
import es.pode.fuentestaxonomicas.negocio.soporte.Relaciones;
/**
 * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices
 */

public class SrvTesaurosServicesImpl
    extends es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServicesBase
{
	
	 
	private static HashMap hashMapTerm = new HashMap();//tabla hash, con key igual nombreTesauro_idioma, que
													//contiene otras tablas hash,una o mas por cada tesauro según en 
													//los idioma en los que este,esta otras tablas tienen como key el
													//texto del termino y como valor su identificador
	
	private static HashMap hashMapId = new HashMap();//igual que la anterior con la diferencia que las tablas hash que
													//contiene tienen como key el id del termino y como valor su texto

	private static HashMap hashMapRelaciones = new HashMap();//tabla hash, con key igual al nombre del Tesauro(una sola
												//tabla independientemente del número de idioma que tengamos), que
												//contiene otras tablas hash con las relaciones entre los términos del
												//del tesauro, que tienen como key el identificador de cada término
												//y como valor un objeto del tipo Relaciones que contiene las relaciones
												//asociativas y jerárquicas del término y todos sus padres
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * Es el constructor, hace la llamada a cargarTesauro()
	 * @throws Exception
	 */
	public SrvTesaurosServicesImpl() throws Exception {
		cargarTesauro();
		// TODO Auto-generated constructor stub
	}

    /**
     * Obtiene los terminos que están relacionados pasándole como parámetro el identificador de un termino
     * @param id Identificador del término
     * @param nomTesauro Nombre del Tesauro
     * @param idioma Idioma del Tesauro
     * @return relacionadosId Array de TaxonVO que contienen el identificador y el valor del taxon
     * @throws Exception
     */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTerminosRelacionadosPorId(
    		java.lang.String id, 
    		java.lang.String nomTesauro, 
    		java.lang.String idioma)
        throws java.lang.Exception
    {
    	
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
      	
      	//para el id indicado se obtienen las relaciones y sus padres
    	TaxonVO[] relacionesAsoc = obtenerTerminosRelacionAsociativa(id, nomTesauro, idioma);
    	TaxonVO[] relacionesJerar = obtenerTerminosRelacionJerarquica(id, nomTesauro, idioma);
    	TaxonVO[] padres = obtenerPadres(id, idioma, nomTesauro);
    	int tamañoJerar = relacionesJerar.length;
    	int tamañoAsoc = relacionesAsoc.length;
    	int tamañoPadres = padres.length;
    	int tamaño = tamañoJerar + tamañoAsoc + tamañoPadres;
    	int tamañoPadresJerar= tamañoJerar + tamañoPadres;
    	
    	//lo juntamos todo en un array de TaxonVO
    	TaxonVO[] relacionadosId = new TaxonVO[tamaño];
    	for( int j=0;j<tamañoPadres;j++){
       	   TaxonVO taxon = new TaxonVO(); 
       	   taxon.setId(padres[j].getId());
       	   taxon.setValorTax(padres[j].getValorTax());
       	   taxon.setEsHoja(new Boolean(false));
       	   taxon.setVocabName(padres[j].getVocabName());
       	   taxon.setTipoRelacion("TG");
       	   relacionadosId[j] = taxon;
          }
    	for( int j=tamañoPadres;j<(tamañoJerar+tamañoPadres);j++){
      	   TaxonVO taxon = new TaxonVO(); 
      	   int m = j-tamañoPadres;
      	   taxon.setId(relacionesJerar[m].getId());
      	   taxon.setValorTax(relacionesJerar[m].getValorTax());
      	   taxon.setEsHoja(new Boolean(false));
      	   taxon.setVocabName(relacionesJerar[m].getVocabName());
      	   taxon.setTipoRelacion("TE");
      	   relacionadosId[j] = taxon;
         }
         
     	for( int j=tamañoPadresJerar;j<tamaño;j++){
      	   TaxonVO taxon = new TaxonVO(); 
      	   int k = j-tamañoPadresJerar;
      	   taxon.setId(relacionesAsoc[k].getId());
      	   taxon.setValorTax(relacionesAsoc[k].getValorTax());
      	   taxon.setEsHoja(new Boolean(false));
      	   taxon.setVocabName(relacionesAsoc[k].getVocabName());
      	   taxon.setTipoRelacion("TR");
      	   relacionadosId[j] = taxon;
         }
    	
    	return relacionadosId;
    }

    /**
     * Obtiene la jerarquia de un termino
     * @param id Identificador del termino
     * @param nomTesauro Nombre del Tesauro
     * @param idioma Idioma del Tesauro
     * @return 
     * @return rutaTextoAux Array de JerarquiaVO, donde JerarquiaVO es un array de TaxonVO
     * @throws Exception
     */
    protected  JerarquiaVO[] handleObtenerJerarquia(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
        throws java.lang.Exception
    {	
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
    	
    	//obtenemos todas las rutas o jerarquias que le corresponde al identificador indicado
    	List lRutaI = obtenerRutas(id,nomTesauro,null,null);
    	List lRutaTexto = obtenerTextoRutas(idioma,nomTesauro,lRutaI);
    	ArrayList listaTax=new ArrayList();
    	for(int i=0;i<lRutaTexto.size();i++){
    		JerarquiaVO jerarquia=new JerarquiaVO();
    		TaxonVO[] taxones = (TaxonVO[])lRutaTexto.get(i);
    		jerarquia.setJerarquia(taxones);
    		listaTax.add(jerarquia);
    	}
    	JerarquiaVO[] rutaTextoAux =(JerarquiaVO []) listaTax.toArray(new JerarquiaVO[listaTax.size()]);
    	
       return rutaTextoAux;
    }

    /**
     * Obtiene el primer nivel del Tesauro, es decir aquellos terminos que no tengan padre
     * @param nomTesauro Nombre del Tesauro
     * @param idioma Idioma del Tesauro
     * @return primerNivelOrd Array de TaxonVO que contenga todos los taxones que no tengan identificador del padre
     * @throws Exception
     */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerPrimerNivelTesauro(
    		String nomTesauro, 
    		String idioma)
    throws java.lang.Exception
    {
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
    	
    	TaxonVO[] primerNivelOrd =null;
    	List lIdPrimerNivel = new ArrayList();
    	String fichero = nomTesauro + "_" + idioma + ".xml";
    	EstructuraVdex cEstIdes = ((EstructuraVdex)(hashMapTerm.get(fichero)));
    	 
    	if(cEstIdes!=null){
	    	Collection cIdes=cEstIdes.getHashMap().values();
	        Iterator i = cIdes.iterator();
	       
	        //obtenemos los ides de los terminos que no tenga padre (termino general)
	    	while(i.hasNext()){
	    		String j = i.next().toString();
	    		EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
	    		HashMap hash = estructura.getHashMap() ;
	    		String vocabName=estructura.getVocabName();
	        	Relaciones relacion =(Relaciones)(hash.get(j));
	        	int idPadre = relacion.getIdPadres().size();
	
	        	if ((idPadre ==0)){
	        		lIdPrimerNivel.add(j);
	        	}
	        }
    	
	    	//obtenemos el texto para cada uno de los ides y ordenamos el array de TaxonVO
	    	TaxonVO[] primerNivel = obtenerTexto(lIdPrimerNivel, idioma, nomTesauro);
	    	primerNivelOrd = ordenarAlfabeticamente(primerNivel);
    	}
    	return primerNivelOrd;
    }

    /**
     * Obtiene los terminos que están relacionados pasándole como parámetro el texto de un termino
     * @param textoTesauro Texto del término
     * @param nomTesauro Nombre del Tesauro
     * @param idioma Idioma del Tesauro
     * @return relacionadosTexto Array de TaxonVO que contienen el identificador y el valor del taxon
     * @throws Exception
     */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTerminosRelacionadosPorTexto(java.lang.String textoTesauro, java.lang.String nomTesauro, java.lang.String idioma)
        throws java.lang.Exception
    {
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
    	
    	//obtenemos los identificadores del texto pasado por parámetro
    	List lIds = obtenerIdentificador(textoTesauro, idioma, nomTesauro);
    	if(lIds.size() >0){//el texto coincide con algun término del tesauro
    		List relacionesJerar=new ArrayList();
    		List relacionesAsoc =new ArrayList();
    		List padres=new ArrayList();
    	
	    	//para cada id que se corresponda con el texto se obtienen las relaciones y sus padres
	    	for (int i=0;i<lIds.size();i++){
	    		EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
	    		HashMap hash=estructura.getHashMap();
	    		List padresAux = ((Relaciones)hash.get(lIds.get(i).toString())).getIdPadres();
	    		for(int j=0; j<padresAux.size();j++){
		        	if(!padres.contains(padresAux.get(j)))
		        		padres.add(padresAux.get(j));
		        }	
	    		List relacionesJerarAux = obtenerRelacionJerarquica(lIds.get(i).toString(), nomTesauro); 
		        for(int j=0; j<relacionesJerarAux.size();j++){
		        	if(!relacionesJerar.contains(relacionesJerarAux.get(j)))
		        		relacionesJerar.add(relacionesJerarAux.get(j));
		        }
		        List relacionesAsocAux = obtenerRelacionAsociativa(lIds.get(i).toString(), nomTesauro);
		        for(int j=0; j<relacionesAsocAux.size();j++){
		        	if(!relacionesAsoc.contains(relacionesAsocAux.get(j)))
		        		relacionesAsoc.add(relacionesAsocAux.get(j));
		        }
	    	}
	    	if(relacionesJerar.size()>0 || relacionesAsoc.size()>0){//termino tiene relaciones jerarquicas o asociativas
	    	
		    	//obtenemos el texto y ordenamos alfabeticamente las relaciones y los padres obtenidos
		    	TaxonVO[] rAsociativas = obtenerTexto(relacionesAsoc, idioma, nomTesauro);
		    	TaxonVO[] rAsociaOrdenadas = ordenarAlfabeticamente(rAsociativas);
		    	TaxonVO[] rJerar = obtenerTexto(relacionesJerar, idioma, nomTesauro);
		    	TaxonVO[] rJerarOrdenadas = ordenarAlfabeticamente(rJerar);
		    	TaxonVO[] tPadres = obtenerTexto(padres, idioma, nomTesauro);
		    	TaxonVO[] tPadresOrdenados = ordenarAlfabeticamente(tPadres);
		    	int tamañoJerar = rJerarOrdenadas.length;
		    	int tamañoAsoc = rAsociaOrdenadas.length;
		    	int tamañoPadres = tPadresOrdenados.length;
		    	int tamaño = tamañoJerar + tamañoAsoc + tamañoPadres;
		    	int tamañoPadresJerar= tamañoJerar + tamañoPadres;
	    	
		    	//lo juntamos todo en un array de TaxonVO
		    	TaxonVO[] relacionadosTexto = new TaxonVO[tamaño];
		    	
		    	for( int j=0;j<tamañoPadres;j++){
		       	   TaxonVO taxon = new TaxonVO(); 
		       	   taxon.setId(tPadresOrdenados[j].getId());
		       	   taxon.setValorTax(tPadresOrdenados[j].getValorTax());
		       	   taxon.setEsHoja(new Boolean(false));
		       	   taxon.setVocabName(tPadresOrdenados[j].getVocabName());
		       	   taxon.setTipoRelacion("TG");
		       	   relacionadosTexto[j] = taxon;
		          }
		    	for( int j=tamañoPadres;j<(tamañoPadresJerar);j++){
		      	   TaxonVO taxon = new TaxonVO(); 
		      	   int m = j-tamañoPadres;
		      	   taxon.setId(rJerarOrdenadas[m].getId());
		      	   taxon.setValorTax(rJerarOrdenadas[m].getValorTax());
		      	   taxon.setEsHoja(new Boolean(false));
		      	   taxon.setVocabName(rJerarOrdenadas[m].getVocabName());
		      	   taxon.setTipoRelacion("TE");
		      	   relacionadosTexto[j] = taxon;
		         }
		         
		     	for( int j=tamañoPadresJerar;j<tamaño;j++){
		      	   TaxonVO taxon = new TaxonVO(); 
		      	   int k = j-tamañoPadresJerar;
		      	   taxon.setId(rAsociaOrdenadas[k].getId());
		      	   taxon.setValorTax(rAsociaOrdenadas[k].getValorTax());
		      	   taxon.setEsHoja(new Boolean(false));
		      	   taxon.setVocabName(rAsociaOrdenadas[k].getVocabName());
		      	   taxon.setTipoRelacion("TR");
		      	   relacionadosTexto[j] = taxon;
		     	}
		     	return relacionadosTexto;
	     	}
	    	else{//coincide pero no tiene relaciones ni jerarquicas ni asociativas (es hoja)
	    		//Buscamos los terminos que contengan el texto
	    		
	    		TaxonVO[] relacionadosTexto=relacionadosTexto=this.obtenerTerminosTexto(textoTesauro, nomTesauro, idioma);
	    		if(relacionadosTexto.length == 1){//solo un termino contiene el texto buscado por tanto mostramos las relaciones
	    								 //de dicho termino
    				TaxonVO taxon= relacionadosTexto[0];
    				
    				relacionadosTexto=this.handleObtenerTerminosRelacionadosPorId(taxon.getId(), nomTesauro, idioma);
	    			
	    		}

	    		return relacionadosTexto;	    		
	    	}
    	}
    	else{//el texto no coincide con ningún término
//    		Buscamos los terminos que contengan el texto

    		TaxonVO[] relacionadosTexto=relacionadosTexto=this.obtenerTerminosTexto(textoTesauro, nomTesauro, idioma);
    		if(relacionadosTexto.length == 1){//solo un termino contiene el texto buscado por tanto mostramos las relaciones
    								 //de dicho termino
				TaxonVO taxon = relacionadosTexto[0];
			
				relacionadosTexto=this.handleObtenerTerminosRelacionadosPorId(taxon.getId(), nomTesauro, idioma);
    			
    		}

    		return relacionadosTexto;
    	}

    }
    
    
//    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTerminosRelacionadosPorTexto(java.lang.String textoTesauro, java.lang.String nomTesauro, java.lang.String idioma)
//    throws java.lang.Exception
//{
//  	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
//  	
//  	nomTesauro= nombreTesauro[0];
//  	idioma= nombreTesauro[1];
//	
//	//obtenemos los identificadores del texto pasado por parámetro
//	List lIds = obtenerIdentificador(textoTesauro, idioma, nomTesauro);
//	List relacionesJerar=new ArrayList();
//	List relacionesAsoc =new ArrayList();
//	List padres=new ArrayList();
//	
//	//para cada id que se corresponda con el texto se obtienen las relaciones y sus padres
//	for (int i=0;i<lIds.size();i++){
//		EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
//		HashMap hash=estructura.getHashMap();
//		List padresAux = ((Relaciones)hash.get(lIds.get(i).toString())).getIdPadres();
//		for(int j=0; j<padresAux.size();j++){
//        	if(!padres.contains(padresAux.get(j)))
//        		padres.add(padresAux.get(j));
//        }	
//		List relacionesJerarAux = obtenerRelacionJerarquica(lIds.get(i).toString(), nomTesauro); 
//        for(int j=0; j<relacionesJerarAux.size();j++){
//        	if(!relacionesJerar.contains(relacionesJerarAux.get(j)))
//        		relacionesJerar.add(relacionesJerarAux.get(j));
//        }
//        List relacionesAsocAux = obtenerRelacionAsociativa(lIds.get(i).toString(), nomTesauro);
//        for(int j=0; j<relacionesAsocAux.size();j++){
//        	if(!relacionesAsoc.contains(relacionesAsocAux.get(j)))
//        		relacionesAsoc.add(relacionesAsocAux.get(j));
//        }
//	}
//	//obtenemos el texto y ordenamos alfabeticamente las relaciones y los padres obtenidos
//	TaxonVO[] rAsociativas = obtenerTexto(relacionesAsoc, idioma, nomTesauro);
//	TaxonVO[] rAsociaOrdenadas = ordenarAlfabeticamente(rAsociativas);
//	TaxonVO[] rJerar = obtenerTexto(relacionesJerar, idioma, nomTesauro);
//	TaxonVO[] rJerarOrdenadas = ordenarAlfabeticamente(rJerar);
//	TaxonVO[] tPadres = obtenerTexto(padres, idioma, nomTesauro);
//	TaxonVO[] tPadresOrdenados = ordenarAlfabeticamente(tPadres);
//	int tamañoJerar = rJerarOrdenadas.length;
//	int tamañoAsoc = rAsociaOrdenadas.length;
//	int tamañoPadres = tPadresOrdenados.length;
//	int tamaño = tamañoJerar + tamañoAsoc + tamañoPadres;
//	int tamañoPadresJerar= tamañoJerar + tamañoPadres;
//	
//	//lo juntamos todo en un array de TaxonVO
//	TaxonVO[] relacionadosTexto = new TaxonVO[tamaño];
//	
//	for( int j=0;j<tamañoPadres;j++){
//   	   TaxonVO taxon = new TaxonVO(); 
//   	   taxon.setId(tPadresOrdenados[j].getId());
//   	   taxon.setValorTax(tPadresOrdenados[j].getValorTax());
//   	   taxon.setEsHoja(new Boolean(false));
//   	   taxon.setVocabName(tPadresOrdenados[j].getVocabName());
//   	   taxon.setTipoRelacion("TG");
//   	   relacionadosTexto[j] = taxon;
//      }
//	for( int j=tamañoPadres;j<(tamañoPadresJerar);j++){
//  	   TaxonVO taxon = new TaxonVO(); 
//  	   int m = j-tamañoPadres;
//  	   taxon.setId(rJerarOrdenadas[m].getId());
//  	   taxon.setValorTax(rJerarOrdenadas[m].getValorTax());
//  	   taxon.setEsHoja(new Boolean(false));
//  	   taxon.setVocabName(rJerarOrdenadas[m].getVocabName());
//  	   taxon.setTipoRelacion("TE");
//  	   relacionadosTexto[j] = taxon;
//     }
//     
// 	for( int j=tamañoPadresJerar;j<tamaño;j++){
//  	   TaxonVO taxon = new TaxonVO(); 
//  	   int k = j-tamañoPadresJerar;
//  	   taxon.setId(rAsociaOrdenadas[k].getId());
//  	   taxon.setValorTax(rAsociaOrdenadas[k].getValorTax());
//  	   taxon.setEsHoja(new Boolean(false));
//  	   taxon.setVocabName(rAsociaOrdenadas[k].getVocabName());
//  	   taxon.setTipoRelacion("TR");
//  	   relacionadosTexto[j] = taxon;
//     }
//	
//	return relacionadosTexto;
//}
    
    

    /**
     * Obtiene los terminos relacionados asociativamente con el identificador que le pasamos como parámetro
     * @param id Identificador del termino
     * @param nomTesauro Nombre del Tesauro
     * @param idioma Idioma del Tesauro
     * @return rAsociaOrdenadas Array de TaxonVO que contiene los términos relacionados asociativamente ordenadas alfabeticamente
     * @throws Exception
     */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTerminosRelacionAsociativa(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
        throws java.lang.Exception
    {
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
    	//obtenemos la relaciones asociativas del id indicado, obtenemos su texto y lo ordenamos alfabeticamente
    	List relacionesAsoc = obtenerRelacionAsociativa(id,nomTesauro);
    	TaxonVO[] rAsociativas = obtenerTexto(relacionesAsoc, idioma, nomTesauro);
    	TaxonVO[] rAsociaOrdenadas = ordenarAlfabeticamente(rAsociativas);
        return     	rAsociaOrdenadas;
    }

    /**
     * Obtiene los terminos relacionados jerarquicamente con el identificador que le pasamos como parámetro
     * @param id Identificador del termino
     * @param nomTesauro Nombre del Tesauro
     * @param idioma Idioma del Tesauro
     * @return rJerarOrdenadas Array de TaxonVO que contiene los términos relacionados jerarquicamente ordenadas alfabeticamente
     * @throws Exception
     */
    protected es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] handleObtenerTerminosRelacionJerarquica(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
        throws java.lang.Exception
    {
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
    	//obtenemos la relaciones jerarquicas del id indicado, obtenemos su texto y lo ordenamos alfabeticamente
    	List relacionesJerar = obtenerRelacionJerarquica(id,nomTesauro);
    	TaxonVO[] rJerarquicas = obtenerTexto(relacionesJerar, idioma, nomTesauro);
        TaxonVO[] rJerarOrdenadas = ordenarAlfabeticamente(rJerarquicas);
        return rJerarOrdenadas;
    }
    
    /**
     * Carga los Tesauros de nombre Tesauro
     * @throws Exception
     */
    private void cargarTesauro() throws Exception{
    	//carga los tesauros disponibles en las tablas hash
		String rutaproperties = null;
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		
		try {
			is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties fproperties = new Properties();
			fproperties.load(is);
			rutaproperties = fproperties.getProperty("rutaTesauro");
			//obtenemos los ficheros que tenemos en la ruta donde se encuentran los tesauros
	        List ficheros = getFiles(rutaproperties);
	        
	        for(int i=0;i<ficheros.size();i++){
	        	String nombreFich = (String)ficheros.get(i);
//	        	String nombreTesauro = fproperties.getProperty("nombreFichTesauro");
	        	File docFile = new File(rutaproperties+(String)ficheros.get(i));
	        	
	        	Document doc = null;
	        	try{
	          		SAXBuilder builder = new SAXBuilder(false);
	        		doc = builder.build(docFile);
	        		Element raiz = doc.getRootElement();
	        		Namespace nameSpace = raiz.getNamespace();
	        		Element vocab=raiz.getChild("vocabName", nameSpace);
	        		String vocabName=vocab.getChildText("langstring", nameSpace);
	        		HashMap hasmapId = new HashMap();
	        		HashMap hasmapTerm = new HashMap();
	        		HashMap hasmapRelacionesFich = new HashMap();
	        		int posi=nombreFich.lastIndexOf("_");
	        		String nombreTesauro=nombreFich.substring(0, posi);
	        		boolean crearRelaciones = hashMapRelaciones.containsKey(nombreTesauro);
	        		//creamos las hashMap para cada fichero
	        		crearHashMaps(raiz, nameSpace,hasmapId,hasmapTerm,hasmapRelacionesFich,!crearRelaciones);
	        		EstructuraVdex estructuraId=new EstructuraVdex();
	        		estructuraId.setVocabName(vocabName);
	        		estructuraId.setHashMap(hasmapId);
	        		hashMapId.put(nombreFich,estructuraId);		
	        		EstructuraVdex estructuraTerm=new EstructuraVdex();
	        		estructuraTerm.setVocabName(vocabName);
	        		estructuraTerm.setHashMap(hasmapTerm);
	        		hashMapTerm.put(nombreFich,estructuraTerm);
	        				
	        		if (!crearRelaciones){
	        			//si tenemos el tesauro en varios idiomas solo generaremos la relaciones una vez
	        			hashMapDeRelacion(raiz, nameSpace,hasmapRelacionesFich);	
	        			EstructuraVdex estructuraRelaciones=new EstructuraVdex();
	        			estructuraRelaciones.setVocabName(vocabName);
	        			estructuraRelaciones.setHashMap(hasmapRelacionesFich);
	        			hashMapRelaciones.put(nombreTesauro, estructuraRelaciones);
	        		}
	        			
	        	}catch (Exception e) {
	        		logger.error("Error en parseo sax", e);
	    			throw new RuntimeException(e);
	    			//e.printStackTrace();
	    		}
	        }
		} catch (IOException e) {
			logger.error("Error: Fichero no encontrado: /xml.properties");
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
	 * Recoge los ficheros de la carpeta que se le pasa por parámetro
	 * @param src La URL de la carpeta
	 * @return lista Lista de ficheros de la carpeta
	 * @throws Exception
	 */

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
                lista.add(archivos[i]);
        }
        return lista;
    }
	
	/**
	 * Genera los HashMaps hasmapId, hasmapTerm y hasmapRelaciones; El primero contiene identificador y texto; el segundo texto e identificador y el tercero contiene todas las relaciones
	 * @param raiz La raiz del vdex
	 * @param nameSpace El namespace del vdex
	 * @param hasmapId HashMap de identificadores
	 * @param hasmapTerm HashMap de terminos
	 * @param hasmapRelaciones HashMap de relaciones
	 * @param creaRelaciones Un booleano para que la hashMap de relaciones sólo lo genere un vez
	 */
    
    //Se generan una HasMap que contiene los terminos(caption) como key y los identificadores como value, otra HashMap
	//con los identificadores como key y los terminos(caption) como value y otra HashMap para la relaciones con los
	//values inicializados, los cuales se completaran en otro metodo
    private static void crearHashMaps(Element raiz, Namespace nameSpace,HashMap hasmapId,HashMap hasmapTerm,HashMap hasmapRelaciones,boolean creaRelaciones){
        
		if( (hasmapId.isEmpty())&&(hasmapTerm.isEmpty()) ) {
			//obtenemos todos los terminos
			List hijos=raiz.getChildren("term", nameSpace);
			Iterator i = hijos.iterator();
			//recorremos todos los terminos y los metemos en las HashMap
			int x = 0;
			boolean fin=false;
			while (i.hasNext()){
				Element e = (Element)i.next();
				//obtenemos el identificador del término
				String ident=e.getChildText("termIdentifier",nameSpace);
				Element listaCaption = e.getChild("caption",nameSpace);
				//obtenemos el texto del término
				String textoCaption=listaCaption.getChildText("langstring", nameSpace);
				//añadimos el id y su texto a la tabla de ids
				hasmapId.put(ident, textoCaption);
				
				//comprabamos que el texto del termino no ha sido introducido ya en la hash, si no esta lo añadimos
				// si ya esta lo redefinimos como agrega_num_textoTermino, pues tenemos otro termino con el mismo texto
				//y distinto id
				if(hasmapTerm.containsKey(textoCaption))
					while(!fin){
						x++;
						if(!hasmapTerm.containsKey("agrega_"+ x +"_"+textoCaption)){
							hasmapTerm.put("agrega_"+ x +"_"+textoCaption, ident);
							fin = true;
						}	
					}
					
				else
					//añadimos el texto y su id a la tabla de terminos
					hasmapTerm.put(textoCaption, ident);
				fin= false;
				x=0;
				//si la tabla de relaciones para este tesauro no han sido inicializada, la inicializamos
				if (creaRelaciones){
					Relaciones relaciones = new Relaciones();
					hasmapRelaciones.put(ident, relaciones);
				}
					
			}
	        
		}	
		
    }

    /**
     * Genera la HashMap que contiene todas las relaciones, tanto jerarquicas como asociativas
     * @param raiz La raiz del vdex
     * @param nameSpace El namespace del vdex
     * @param  hasmapRelaciones HashMap que contiene todas las relaciones
     */
    private static void hashMapDeRelacion(Element raiz, Namespace nameSpace,HashMap hasmapRelaciones){
    //Se completa la HashMap que contiene las relaciones entre los terminos del tesauro, los valores son objetos
    //de la clase Relaciones que contiene un List con las relaciones asociativas,otro con las relaciones jerarquicas y 
    //otro con todos sus padres
        
    	if(!hasmapRelaciones.isEmpty()) {
    		//obtenemos todas las relaciones
    		List relaciones=raiz.getChildren("relationship", nameSpace);
			Iterator j=relaciones.iterator();
		
			while (j.hasNext()){
				Element l = (Element) j.next();
				String fuente=l.getChildText("sourceTerm", nameSpace);
				String destino=l.getChildText("targetTerm", nameSpace);
				String tipoRelacion=l.getChildText("relationshipType", nameSpace);

				Relaciones rFuente = (Relaciones) hasmapRelaciones.get(fuente);
				Relaciones rDestino = (Relaciones) hasmapRelaciones.get(destino);
				
				if(tipoRelacion.startsWith("TE")){
					if (!rFuente.getJerarquicas().contains(destino))
						rFuente.getJerarquicas().add(destino);
					if(!rDestino.getIdPadres().contains(fuente))
						rDestino.getIdPadres().add(fuente);
				}
				if(tipoRelacion.startsWith("TR")){
					if (!rFuente.getAsociativas().contains(destino))
						rFuente.getAsociativas().add(destino);
					if (!rDestino.getAsociativas().contains(fuente))
						rDestino.getAsociativas().add(fuente);
				}
			}

		}
	}

    
    /**
     * Recupera el texto de los identificadores que le pasamos en el idioma indicado
     * @param ides Lista de identificadores
     * @param idioma Idioma del Tesauro
     * @param nomTesauro Nombre del Tesauro
     * @return taxones Array de TaxonVO que contiene los identificadores y el valor del taxon
     */
    private static TaxonVO[] obtenerTexto(List ides, String idioma,String nomTesauro){
    	
    	//Entra un array de identificadores y nos devuelve el texto de cada uno de ellos en 
    	//en el idioma que le indiquemos en array de TaxonVO
    	TaxonVO[] taxones=new TaxonVO[ides.size()];
    	EstructuraVdex estructura=(EstructuraVdex)hashMapId.get(nomTesauro+"_"+idioma+".xml");
    	
    	HashMap has=estructura.getHashMap();
    	String vocabName=estructura.getVocabName();
    	for( int i=0;i<ides.size();i++){
    		String id=ides.get(i).toString();
    		String texto=has.get(id).toString();
    		TaxonVO taxon = new TaxonVO();
    		taxon.setId(id);
    		taxon.setValorTax(texto);
    		taxon.setEsHoja(new Boolean(false));
    		taxon.setVocabName(vocabName);
    		taxones[i]=taxon;   		
    	}
		return taxones;
    	
    }
    /**
     * Recupera el identificador de los textos que le pasamos en el idioma indicado
     * @param texto El texto
     * @param idioma Idioma del Tesauro
     * @param nomTesauro Nombre del Tesauro
     * @return lIdes Lista de identificadores que tengan el texto que le pasamos como parámetro
     */
  private static List obtenerIdentificador(String texto,String idioma,String nomTesauro){
	  //Para el texto que se recibe se devuelve una lista de identificadores que le corresponden
	  List lIdes = new ArrayList();
	  //Eliminamos los espacio que tenga el texto tanto al principio como al final
	  texto = texto.trim();
	  //Pasamos texto a minuscula y sustituimos la vocales con tildes con vocales sin tilde
	  texto = texto.toLowerCase();
	
	  texto = texto.replace('á', 'a');
	  texto = texto.replace('é', 'e');
	  texto = texto.replace('í', 'i');
	  texto = texto.replace('ó', 'o');
	  texto = texto.replace('ú', 'u');
		
	  texto = texto.replace('à', 'a');
	  texto = texto.replace('è', 'e');
	  texto = texto.replace('ì', 'i');
	  texto = texto.replace('ò', 'o');
	  texto = texto.replace('ù', 'u');
		
	  texto = texto.replace('ä', 'a');
	  texto = texto.replace('ë', 'e');
	  texto = texto.replace('ï', 'i');
	  texto = texto.replace('ö', 'o');
	  texto = texto.replace('ü', 'u');
	  
	  String fichero = nomTesauro+"_"+idioma+".xml";
	  EstructuraVdex estruc = (EstructuraVdex) (hashMapId.get(fichero));
	  if(estruc!=null){
		  HashMap auxHashId = estruc.getHashMap();//hashMap con id con key y terminos como value
		  EstructuraVdex estructura = (EstructuraVdex) (hashMapTerm.get(fichero));
		  if(estructura!=null){
			  //terminos del tesauro
			  HashMap auxHashTerm = estructura.getHashMap();//hashMap con termino con key y id como value
			  Collection cTerminos = auxHashTerm.values();//identificadores
			  Iterator iTerminos=cTerminos.iterator();
			  while(iTerminos.hasNext()){//para cada identificador 
				  String id= (String) iTerminos.next();//identificador
				  String term = (String) auxHashId.get(id);//termino correspondiente a id
				  //eliminamos los espacios,pasamos a minusculas y eliminamos la tildes del termino
				  term = term.trim();
				  term = term.toLowerCase();

					String termAux = term.replace('á', 'a');
					termAux = termAux.replace('é', 'e');
					termAux = termAux.replace('í', 'i');
					termAux = termAux.replace('ó', 'o');
					termAux = termAux.replace('ú', 'u');
					
					termAux = termAux.replace('à', 'a');
					termAux = termAux.replace('è', 'e');
					termAux = termAux.replace('ì', 'i');
					termAux = termAux.replace('ò', 'o');
					termAux = termAux.replace('ù', 'u');
					
					termAux = termAux.replace('ä', 'a');
					termAux = termAux.replace('ë', 'e');
					termAux = termAux.replace('ï', 'i');
					termAux = termAux.replace('ö', 'o');
					termAux = termAux.replace('ü', 'u');
					
				  //comparamos el texto con el termino si son iguales añadimos el id
				  if(termAux.equals(texto)) {
					  lIdes.add(id);
				  }
				  //añadimos los terminos cuya traducción al ingles es igual 
				  //ejem: attitude(actitud) --> 118 y attitude(actitudes) --> 1654
				  //añadimos los dos ids si la palabra buscada es attitude
				  boolean fin = false;
				  int x =0;
				  while(!fin){
					  x++;
					  if(termAux.equals("agrega_"+ x +"_"+texto)){
						  lIdes.add(id);
					  }
					  else fin = true;
				  }
			  }
		  }
	  }
	  return lIdes;
  }	
    
    
//    private static List obtenerIdentificador(String texto,String idioma,String nomTesauro){
//    	//Para el texto que se recibe se devuelve una lista de identificadores que le corresponden
//    	List lIdes = new ArrayList();
//    	String fichero = nomTesauro+"_"+idioma+".xml";
//    	EstructuraVdex estructura=(EstructuraVdex)hashMapTerm.get(fichero);
//    	HashMap hash = estructura.getHashMap();
//    	String vocabName=estructura.getVocabName();
//    	if (hash.containsKey(texto)){
//	    	String identificador = hash.get(texto).toString();
//	    	lIdes.add(identificador);
//	    	boolean fin = false;
//	    	int x =0;
//	    	while(!fin){
//				x++;
//				if(hash.containsKey("agrega_"+ x +"_"+texto)){
//					lIdes.add(hash.get("agrega_"+ x +"_"+texto));
//				}
//				else fin = true;
//			}
//    	}
//    	return lIdes;
//    }
    
    /**
     * Obtiene todas las relaciones asociativas del identificador que le pasamos
     * @param id Identificador del término
     * @param nomTesauro Nombre del Tesauro
     * @return lAsocia Lista de identificadores relacionados asociativamente con el identificador que le pasamos como parámetro
     */
    private static List obtenerRelacionAsociativa(String id,String nomTesauro){
    	//Relaciones asociativas del identificador indicado (tanto las que el identificador
    	//sea fuente, como los casos en el que sea destino)
    	List lAsocia=new ArrayList();
    	EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
    	HashMap hash = estructura.getHashMap() ;
    	if (hash.containsKey(id))
    		lAsocia = ((Relaciones)hash.get(id)).getAsociativas();
    	return lAsocia;
    }

    /**
     * Obtiene todas las relaciones jerarquicas del identificador que le pasamos
     * @param id Identificador del término
     * @param nomTesauro Nombre del Tesauro
     * @return lAsocia Lista de identificadores relacionados jerarquicamente con el identificador que le pasamos como parámetro
     */
    
    private static List obtenerRelacionJerarquica(String id,String nomTesauro){
    	//Relaciones jerarquicas del identificador indicado
    	List lJerar=new ArrayList();
    	EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
    	HashMap hash = estructura.getHashMap() ;
    	if (hash.containsKey(id))
    		lJerar=((Relaciones)hash.get(id)).getJerarquicas();
    	return lJerar;
    }
    
   
   /**
    * Ordena alfabéticamente el array de TaxonVO que le pasamos como parámetro
    * @param taxones array de TaxonVO que contiene el identificador y el texto de los taxones
    * @return taxones array de TaxonVO que le pasamos como parámetro ordenado alfabéticamente
    */ 
    private static TaxonVO[] ordenarAlfabeticamente(TaxonVO[] taxones){
    	TaxonVO[] taxonesSinTildes = new TaxonVO[taxones.length];
    	
    	//eliminamos las tildes para poder hacer la comparación correctamente
    	for (int k=0;k<taxones.length;k++){
    		TaxonVO taxonSinTildes = new TaxonVO();
    		String valorTax = taxones[k].getValorTax();
    		valorTax = valorTax.replace('á', 'a');
    		valorTax = valorTax.replace('é', 'e');
    		valorTax = valorTax.replace('í', 'i');
    		valorTax = valorTax.replace('ó', 'o');
    		valorTax = valorTax.replace('ú', 'u');
    		valorTax = valorTax.replace('Á', 'A');
    		valorTax = valorTax.replace('É', 'E');
    		valorTax = valorTax.replace('Í', 'I');
    		valorTax = valorTax.replace('Ó', 'O');
    		valorTax = valorTax.replace('Ú', 'U');
    				
    		valorTax = valorTax.replace('à', 'a');
    		valorTax = valorTax.replace('è', 'e');
			valorTax = valorTax.replace('ì', 'i');
			valorTax = valorTax.replace('ò', 'o');
			valorTax = valorTax.replace('ù', 'u');
    		valorTax = valorTax.replace('À', 'A');
    		valorTax = valorTax.replace('È', 'A');
			valorTax = valorTax.replace('Ì', 'I');
			valorTax = valorTax.replace('Ò', 'O');
			valorTax = valorTax.replace('Ù', 'U');
						
			valorTax = valorTax.replace('ä', 'a');
			valorTax = valorTax.replace('ë', 'e');
			valorTax = valorTax.replace('ï', 'i');
			valorTax = valorTax.replace('ö', 'o');
			valorTax = valorTax.replace('ü', 'u');
			valorTax = valorTax.replace('Ä', 'A');
			valorTax = valorTax.replace('Ë', 'E');
			valorTax = valorTax.replace('Ï', 'i');
			valorTax = valorTax.replace('Ö', 'O');
			valorTax = valorTax.replace('Ü', 'U');
			
    		taxonSinTildes.setValorTax(valorTax);
    		taxonSinTildes.setId(taxones[k].getId());
    		taxonSinTildes.setVocabName(taxones[k].getVocabName());
    		taxonSinTildes.setTipoRelacion(taxones[k].getTipoRelacion());
    		taxonesSinTildes[k]= taxonSinTildes;
    	}
    	
    	for( int i=0;i<taxones.length-1;i++){                 
    		for (int j=i+1;j<taxones.length;j++){
    			String aux=null;
    			String auxId=null;
    			String aux2=null;
    			String auxId2=null;
    			String auxVocab=null;
    			String auxVocab2=null;
    			String auxTipo=null;
    			String auxTipo2=null;
    			String valorTaxI = taxonesSinTildes[i].getValorTax();
    			String valorTaxJ = taxonesSinTildes[j].getValorTax();
    			
    			//comparamos los texto sin tildes y ordenamos a la vez tanto el array con los taxones sin tildes
    			//como el array con los taxones originales que sera el que vamos devolver
    			if(valorTaxI.compareToIgnoreCase(valorTaxJ)>0){
    				aux=taxonesSinTildes[j].getValorTax();
    				taxonesSinTildes[j].setValorTax(taxonesSinTildes[i].getValorTax());
    				taxonesSinTildes[i].setValorTax(aux);
    				auxId=taxonesSinTildes[j].getId();
    				taxonesSinTildes[j].setId(taxonesSinTildes[i].getId());
    				taxonesSinTildes[i].setId(auxId);
    				auxVocab=taxonesSinTildes[j].getVocabName();
    				taxonesSinTildes[j].setVocabName(taxonesSinTildes[i].getVocabName());
    				taxonesSinTildes[i].setVocabName(auxVocab);
    				auxTipo=taxonesSinTildes[j].getTipoRelacion();
    				taxonesSinTildes[j].setTipoRelacion(taxonesSinTildes[i].getTipoRelacion());
    				taxonesSinTildes[i].setTipoRelacion(auxTipo);
    				
    				aux2=taxones[j].getValorTax();
    				taxones[j].setValorTax(taxones[i].getValorTax());
    				taxones[i].setValorTax(aux2);
    				auxId2=taxones[j].getId();
    				taxones[j].setId(taxones[i].getId());
    				taxones[i].setId(auxId2);
    				auxVocab2=taxones[j].getVocabName();
    				taxones[j].setVocabName(taxones[i].getVocabName());
    				taxones[i].setVocabName(auxVocab2);
    				auxTipo2=taxones[j].getTipoRelacion();
    				taxones[j].setTipoRelacion(taxones[i].getTipoRelacion());
    				taxones[i].setTipoRelacion(auxTipo2);
    			}	
    		}
    	}
    	return taxones;
    }
    
    private static List obtenerRutas(String id,String nomTesauro,List rutaActual,List rutas){
    	
    	List ruta = new ArrayList();
    	String nuevoDest=id;
    	EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
    	HashMap hash = estructura.getHashMap() ;
		if (rutas == null)
			rutas = new ArrayList();
    	if (hash.containsKey(nuevoDest)){
    		if (rutaActual == null)
    			rutaActual = new ArrayList();
    		rutaActual.add(nuevoDest);
    		Relaciones r = (Relaciones)hash.get(nuevoDest);
    		List padres = r.getIdPadres();
    		if(padres.size()== 0){
    			//componemos la ruta
    			for(int i= 0;i<rutaActual.size();i++){
    				ruta.add(rutaActual.get(i));
    			}
    			//añadimos la ruta con las demas
    			rutas.add(ruta);	
    		}
	    	else {
	    		for(int i = 0;i<padres.size();i++){
	    			nuevoDest=r.getIdPadres().get(i).toString();
	    			obtenerRutas(nuevoDest,nomTesauro,rutaActual,rutas);
	    			rutaActual.remove(nuevoDest);
    			}
	    	}	
    	} 	
		return rutas;
    }
    
    private static List obtenerTextoRutas(String idioma,String nomTesauro,List rutas){
    	//obtiene el texto de las rutas que se le pasa por parámetro y devuelve una lista de arrays de TaxonVO
    	//y ademas ordena correctamente cada ruta
    	List rutasTexto = new ArrayList();
    	Iterator i = rutas.iterator();
    	List sigRuta = null;
    	while (i.hasNext()){
    		//para cada ruta obtenemos su texto
    		sigRuta = (List) i.next();
    		TaxonVO[] sigRutaTexto = obtenerTexto(sigRuta, idioma, nomTesauro);
    	    
    		int tamaño = sigRutaTexto.length;   
    	    TaxonVO[] rutaOrdenada = new TaxonVO[tamaño];
	       
    	    //ordenamos correctamente la ruta
    	    for( int j=tamaño;j>0;j--){
	    	   TaxonVO taxon = new TaxonVO(); 
	    	   taxon.setId(sigRutaTexto[j-1].getId());
	    	   taxon.setValorTax(sigRutaTexto[j-1].getValorTax());
	    	   taxon.setEsHoja(sigRutaTexto[j-1].getEsHoja());
	    	   taxon.setVocabName(sigRutaTexto[j-1].getVocabName());
	    	   taxon.setTipoRelacion(sigRutaTexto[j-1].getTipoRelacion());
	    	   rutaOrdenada[tamaño-j] = taxon;
    	    }
    		rutasTexto.add(rutaOrdenada);
    	}
    	return rutasTexto;
    }
    
    private static TaxonVO[] obtenerPadres(String id,String idioma,String nomTesauro){
    	//se obtiene los padres del id pasado por parametros en orden alfabético
    	List lPadres=new ArrayList();
    	EstructuraVdex estructura=(EstructuraVdex)hashMapRelaciones.get(nomTesauro);
    	HashMap hash = estructura.getHashMap() ;
    	//obtenemos los padre del id
    	if (hash.containsKey(id))
    		lPadres = ((Relaciones)hash.get(id)).getIdPadres();
    	TaxonVO[] padres = obtenerTexto(lPadres, idioma, nomTesauro);
        TaxonVO[] padresOrdenados = ordenarAlfabeticamente(padres);
        return padresOrdenados;
    	
    }

	protected void handleRecargar() throws Exception {
		cargarTesauro();
		
	}

	

	protected String handleObtenerVocabName(
			String nomTesauro, 
			String idioma) 
	throws Exception 
	{
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];

		
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		String vocabName=null;

		EstructuraVdex estructuraTesauro = (EstructuraVdex)hashMapTerm.get(nomTesauro+"_"+idioma+".xml");
		if(estructuraTesauro!=null)
			vocabName=estructuraTesauro.getVocabName().toString();	
		if(vocabName==null)
			vocabName="";
		
		return vocabName;
	}

	protected String[] handleObtenerVocabNames(
			String[] nomTesauros, 
			String idioma) 
	throws Exception 
	{
		
		String[] vueltaVocabs=null;
		try{
			vueltaVocabs=new String[nomTesauros.length];
			for(int i=0;i<nomTesauros.length;i++){
				String vocabName=this.obtenerVocabName(nomTesauros[i], idioma);
				vueltaVocabs[i]=vocabName;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vueltaVocabs;
	}

	protected JerarquiaVO[] handleObtenerTerminos(
			String texto, 
			String nomTesauro, 
			String idioma)
	throws Exception 
	{
      	String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	
      	nomTesauro= nombreTesauro[0];
      	idioma= nombreTesauro[1];
		
		ArrayList terminosEnc = new ArrayList();
		//Eliminamos los espacio que tenga el texto tanto al principio como al final
		texto = texto.trim();
		//Pasamos texto a minuscula y sustituimos la vocales con tildes con vocales sin tilde
		String textoBuscar = texto.toLowerCase(); 
		textoBuscar = textoBuscar.replace('á', 'a');
		textoBuscar = textoBuscar.replace('é', 'e');
		textoBuscar = textoBuscar.replace('í', 'i');
		textoBuscar = textoBuscar.replace('ó', 'o');
		textoBuscar = textoBuscar.replace('ú', 'u');
		
		textoBuscar = textoBuscar.replace('à', 'a');
		textoBuscar = textoBuscar.replace('è', 'e');
		textoBuscar = textoBuscar.replace('ì', 'i');
		textoBuscar = textoBuscar.replace('ò', 'o');
		textoBuscar = textoBuscar.replace('ù', 'u');
		
		textoBuscar = textoBuscar.replace('ä', 'a');
		textoBuscar = textoBuscar.replace('ë', 'e');
		textoBuscar = textoBuscar.replace('ï', 'i');
		textoBuscar = textoBuscar.replace('ö', 'o');
		textoBuscar = textoBuscar.replace('ü', 'u');

		//comprobamos que esta bien formada
		Pattern mask=Pattern.compile("^([0-9][a-zñ.\\'ç\\-0-9\\s/]*)|[a-zñ.\\'ç\\-/][a-zñ0-9.\\'ç\\-/][a-zñ0-9.\\'ç\\-\\s/]*$");//
		Matcher matcher = mask.matcher(textoBuscar);
		boolean correcto = matcher.matches();
		
		if(!texto.equals("") && correcto){
			//elimininamos espacio en blanco ejem:"historia de   la    filosofia" --> "historia de la filosofia"
			String[] aux2 =textoBuscar.split("  ");
			textoBuscar="";
			for(int i=0;i<aux2.length;i++){
				if(!aux2[i].trim().equals("")){
					textoBuscar = textoBuscar + " " + aux2[i];
				}
			}
			textoBuscar = textoBuscar.trim();

			String fichero = nomTesauro+"_"+idioma+".xml";
			EstructuraVdex estruc = (EstructuraVdex) (hashMapId.get(fichero));
			if(estruc!=null){
				HashMap auxHashId = estruc.getHashMap();//hashMap con id con key y terminos como value
				EstructuraVdex estructura = (EstructuraVdex) (hashMapTerm.get(fichero));
				if(estructura!=null){
					//terminos del tesauro
					HashMap auxHashTerm = estructura.getHashMap();//hashMap con termino con key y id como value
					Collection cTerminos = auxHashTerm.values();//identificadores
					Iterator iTerminos=cTerminos.iterator();
					while(iTerminos.hasNext()){//para cada identificador 
						String id= (String) iTerminos.next();//identificador
						String term = (String) auxHashId.get(id);//termino correspondiente a id
						//eliminamos los espacios,pasamos a minusculas y eliminamos la tildes del termino
						term = term.trim();
						term = term.toLowerCase();
						String termAux = term.replace('á', 'a');
						termAux = termAux.replace('é', 'e');
						termAux = termAux.replace('í', 'i');
						termAux = termAux.replace('ó', 'o');
						termAux = termAux.replace('ú', 'u');
						
						termAux = termAux.replace('à', 'a');
						termAux = termAux.replace('è', 'e');
						termAux = termAux.replace('ì', 'i');
						termAux = termAux.replace('ò', 'o');
						termAux = termAux.replace('ù', 'u');
						
						termAux = termAux.replace('ä', 'a');
						termAux = termAux.replace('ë', 'e');
						termAux = termAux.replace('ï', 'i');
						termAux = termAux.replace('ö', 'o');
						termAux = termAux.replace('ü', 'u');
								
						String[] aux =termAux.split(textoBuscar);
						//si el vector obtenido en el split es mayor que uno, el texto que estamos buscando esta contenido en el termino
						//si el vector es menor o igual a uno, puede ser que el texto a buscar coincida con el termino o
						// que el texto a buscar se la parte final del termino donde estamos buscando.
						//En todos estos casos se ha encontrado resultado por lo tanto se obtienen las jerarquias correspondientes 
						//al identificador del terminos
						if(aux.length>1 || termAux.equals(textoBuscar) || termAux.endsWith(textoBuscar)) {			
							JerarquiaVO[] jeraq = this.handleObtenerJerarquia(id, nomTesauro, idioma);
							for(int i=0;i<jeraq.length;i++){
								terminosEnc.add(jeraq[i]);
							}					
						}
					}
				}
			}
		}
		JerarquiaVO[] jerarquias = (JerarquiaVO[]) terminosEnc.toArray(new JerarquiaVO[terminosEnc.size()]);
		return jerarquias;
	}
	
	private String[] obtenerNombreTesauro(
			String nomTesauro, 
			String idioma)
	throws Exception
	{
		String[] resultado=new String[2];
		String nombre=null;
		String idio=null;
		
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		String ruta= fprop.getProperty("rutaTesauro");
		File directorio= new File(ruta);
		String[] lista = directorio.list();
		int i;
		if(nomTesauro!=null && nomTesauro.equals(fprop.getProperty("tesauroETB")))
		{
			if(directorio.exists() && directorio.isDirectory())
			{
				//busco el fichero que se corresponde con el idioma
				for (i = 0; i < lista.length && nombre==null; i++) 
				{
					if(lista[i].endsWith(idioma + ".xml"))
					{
						nombre= lista[i].substring(0,lista[i].length() - 7);
						idio=idioma;
					}
				}
				// si no ha encontrado el fichero para el idioma indicado .. busco el fichero para español
				for (i = 0; i < lista.length && nombre==null; i++) 
				{
					if(lista[i].endsWith("es.xml"))
					{
						nombre= lista[i].substring(0,lista[i].length() - 7);
						idio="es";
					}//if
				}//for
			}//if
		}//if
		else
		{
			//por el momento tiene el mismo comportamiento que si fuera un tesauroETB
			//porque no hay mas opciones.. cuando se aceptem mas tesauros se debera cambiar
			//esto para realizar la busqueda del tesauro e idiomas correspondientes
			if(directorio.exists() && directorio.isDirectory())
			{
				//busco el fichero que se corresponde con el idioma
				for (i = 0; i < lista.length && nombre==null; i++) 
				{
					if(lista[i].endsWith(idioma + ".xml"))
					{
						nombre= lista[i].substring(0,lista[i].length() - 7);
						idio=idioma;
					}
				}
				// si no ha encontrado el fichero para el idioma indicado .. busco el fichero para español
				for (i = 0; i < lista.length && nombre==null; i++) 
				{
					if(lista[i].endsWith("es.xml"))
					{
						nombre= lista[i].substring(0,lista[i].length() - 7);
						idio="es";
					}//if
				}//for
			}//if
		}
		
		resultado[0]=nombre;
		resultado[1]=idio;
		return resultado;
	}

	protected boolean handleChequearExistenciaIdioma(
			String idioma) 
	throws Exception 
	{
		boolean resultado = false;
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		String ruta= fprop.getProperty("rutaTesauro");
		File directorio= new File(ruta);
		String[] lista = directorio.list();
		int i;
		
		for (i = 0; i < lista.length && !resultado; i++) 
		{
			if(lista[i].endsWith(idioma + ".xml"))
			{
				resultado= true;
			}
		}

		return resultado;
	}

	private TaxonVO[] obtenerTerminosTexto(
			String texto, 
			String nomTesauro, 
			String idioma)
	throws Exception 
	{	
		ArrayList terminosEnc = new ArrayList();
		//Eliminamos los espacio que tenga el texto tanto al principio como al final
		texto = texto.trim();
		//Pasamos texto a minuscula y sustituimos la vocales con tildes con vocales sin tilde
		String textoBuscar=texto.toLowerCase(); 
		textoBuscar = textoBuscar.replace('á', 'a');
		textoBuscar = textoBuscar.replace('é', 'e');
		textoBuscar = textoBuscar.replace('í', 'i');
		textoBuscar = textoBuscar.replace('ó', 'o');
		textoBuscar = textoBuscar.replace('ú', 'u');
		
		textoBuscar = textoBuscar.replace('à', 'a');
		textoBuscar = textoBuscar.replace('è', 'e');
		textoBuscar = textoBuscar.replace('ì', 'i');
		textoBuscar = textoBuscar.replace('ò', 'o');
		textoBuscar = textoBuscar.replace('ù', 'u');
		
		textoBuscar = textoBuscar.replace('ä', 'a');
		textoBuscar = textoBuscar.replace('ë', 'e');
		textoBuscar = textoBuscar.replace('ï', 'i');
		textoBuscar = textoBuscar.replace('ö', 'o');
		textoBuscar = textoBuscar.replace('ü', 'u');
		//comprobamos que esta bien formada
		Pattern mask=Pattern.compile("^([0-9][a-zñ.\\'ç\\-0-9\\s/]*)|[a-zñ.\\'ç\\-/][a-zñ0-9.\\'ç\\-/][a-zñ0-9.\\'ç\\-\\s/]*$");//
		Matcher matcher = mask.matcher(textoBuscar);
		boolean correcto = matcher.matches();
		
		if(!texto.equals("") && correcto){
			//elimininamos espacio en blanco ejem:"historia de   la    filosofia" --> "historia de la filosofia"
			String[] aux2 =textoBuscar.split("  ");
			textoBuscar="";
			for(int i=0;i<aux2.length;i++){
				if(!aux2[i].trim().equals("")){
					textoBuscar = textoBuscar + " " + aux2[i];
				}
			}
			textoBuscar = textoBuscar.trim();

			String fichero = nomTesauro+"_"+idioma+".xml";
			EstructuraVdex estruc = (EstructuraVdex) (hashMapId.get(fichero));
			if(estruc!=null){
				HashMap auxHashId = estruc.getHashMap();//hashMap con id con key y terminos como value
				EstructuraVdex estructura = (EstructuraVdex) (hashMapTerm.get(fichero));
				if(estructura!=null){
					//terminos del tesauro
					HashMap auxHashTerm = estructura.getHashMap();//hashMap con termino con key y id como value
					Collection cTerminos = auxHashTerm.values();//identificadores
					Iterator iTerminos=cTerminos.iterator();
					while(iTerminos.hasNext()){//para cada identificador 
						String id= (String) iTerminos.next();//identificador
						String term = (String) auxHashId.get(id);//termino correspondiente a id
						//eliminamos los espacios,pasamos a minusculas y eliminamos la tildes del termino
						term = term.trim();
						term = term.toLowerCase();
			
						String termAux = term.replace('á', 'a');
						termAux = termAux.replace('é', 'e');
						termAux = termAux.replace('í', 'i');
						termAux = termAux.replace('ó', 'o');
						termAux = termAux.replace('ú', 'u');
						
						termAux = termAux.replace('à', 'a');
						termAux = termAux.replace('è', 'e');
						termAux = termAux.replace('ì', 'i');
						termAux = termAux.replace('ò', 'o');
						termAux = termAux.replace('ù', 'u');
						
						termAux = termAux.replace('ä', 'a');
						termAux = termAux.replace('ë', 'e');
						termAux = termAux.replace('ï', 'i');
						termAux = termAux.replace('ö', 'o');
						termAux = termAux.replace('ü', 'u');
						
						if(termAux.equals(textoBuscar) || termAux.endsWith(" " + textoBuscar ) 
								|| termAux.startsWith(textoBuscar + " " ) 
								|| termAux.indexOf(" " + textoBuscar + " ") > -1) {
							TaxonVO taxon = new TaxonVO();
					      	   taxon.setId(id);
					      	   taxon.setValorTax(term);
					      	   taxon.setEsHoja(new Boolean(false));
					      	   taxon.setVocabName(estructura.getVocabName());	
					      	   terminosEnc.add(taxon);
						}
					}
				}
			}
		}
		TaxonVO[] terminos = (TaxonVO[]) terminosEnc.toArray(new TaxonVO[terminosEnc.size()]);
		return terminos;
	}

	@Override
	protected TaxonVO[] handleObtenerTextosDeIds(String[] ids, String idioma, String nomTesauro) throws Exception {
		// TODO Auto-generated method stub
		
		String[] nombreTesauro = this.obtenerNombreTesauro(nomTesauro, idioma);
      	String nomTesauroOK= nombreTesauro[0];
      	String idiomaOK= nombreTesauro[1];
		
		List listaIds= Arrays.asList(ids);
	
		TaxonVO[] taxones= obtenerTexto(listaIds, idiomaOK, nomTesauroOK);
		
		return taxones;
	}

}