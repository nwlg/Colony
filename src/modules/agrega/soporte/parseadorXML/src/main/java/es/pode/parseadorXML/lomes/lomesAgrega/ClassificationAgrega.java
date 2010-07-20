/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.Classification;
import es.pode.parseadorXML.castor.ComplexTypePurposeVocabSource;
import es.pode.parseadorXML.castor.ComplexTypePurposeVocabValue;
import es.pode.parseadorXML.castor.Description;
import es.pode.parseadorXML.castor.EntryTaxon;
import es.pode.parseadorXML.castor.GroupClassificationClassification;
import es.pode.parseadorXML.castor.GroupDescriptionDescription;
import es.pode.parseadorXML.castor.GroupEntryTaxonEntry;
import es.pode.parseadorXML.castor.GroupIdId;
import es.pode.parseadorXML.castor.GroupKeywordKeyword;
import es.pode.parseadorXML.castor.GroupPurposePurpose;
import es.pode.parseadorXML.castor.GroupSourceSource;
import es.pode.parseadorXML.castor.GroupTaxonPathTaxonPath;
import es.pode.parseadorXML.castor.GroupTaxonTaxon;
import es.pode.parseadorXML.castor.Id;
import es.pode.parseadorXML.castor.Keyword;
import es.pode.parseadorXML.castor.LanguageStringItem;
import es.pode.parseadorXML.castor.Purpose;
import es.pode.parseadorXML.castor.Source;
import es.pode.parseadorXML.castor.Taxon;
import es.pode.parseadorXML.castor.TaxonPath;

public class ClassificationAgrega {

	private Classification classification = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public ClassificationAgrega(Classification classification) {
		super();
		
		if (classification.getGroupClassificationClassification()==null){
			classification.setGroupClassificationClassification(new GroupClassificationClassification());
		}
		
		setClassification(classification);  
	}
	

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	
	// método que recoge el propósito de Classification
	public java.lang.String getProposito (
    ) throws java.lang.Exception {
		
		java.lang.String p= null;
		
		try{
			p= classification.getGroupClassificationClassification().getPurpose().getGroupPurposePurpose().getComplexTypePurposeVocabValue().getContent();
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger el propósito de Classification";
			logger.warn(mensaje);
			
			p= null;
			return p;
			//throw e;
		}
		
		return p;
		
	}
	
	// método que inserta un propósito en Classification. Si ya existe uno, sobreescribe el anterior.
	public void setProposito (java.lang.String proposito
    ) throws java.lang.Exception {
		
		Properties properties = new Properties(); 
		InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
		properties.load(is);
		String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		
		Purpose p= new Purpose();
		GroupPurposePurpose gpp= new GroupPurposePurpose();
		ComplexTypePurposeVocabSource ctpvs= new ComplexTypePurposeVocabSource();
		ComplexTypePurposeVocabValue ctpvv= new ComplexTypePurposeVocabValue();
		
		ctpvs.setContent(lomes);
		ctpvv.setContent(proposito);
		gpp.setComplexTypePurposeVocabSource(ctpvs);
		gpp.setComplexTypePurposeVocabValue(ctpvv);
		p.setGroupPurposePurpose(gpp);
		
		if (classification == null){
			classification= new Classification();
		}
		    
		if (classification.getGroupClassificationClassification()== null){
			GroupClassificationClassification gccAux= new GroupClassificationClassification();
			classification.setGroupClassificationClassification(gccAux);
		}
		
		classification.getGroupClassificationClassification().setPurpose(p);
		
	}
	
	// método que recoge la fuente de la ruta taxonómica indicada en la posición del parámetro y en el idioma especificado
	public java.lang.String getFuente (int indexRutaTax, java.lang.String idioma
    ) throws java.lang.Exception {
		
		java.lang.String f= null;
		
		try{
			LanguageStringItem[] lsi= classification.getGroupClassificationClassification().getTaxonPath(indexRutaTax).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem();
			if (lsi!= null){
				if ((lsi != null) && (lsi.length>0)){
		    		int cont= 0;
					boolean idiEncontrado= false;
					while ((cont<lsi.length) && (idiEncontrado== false)){
						if (idioma.equals(lsi[cont].getString().getLanguage())){
							idiEncontrado= true;
						}
						else{
							cont++;
						}
					}
					if ((idiEncontrado) && (cont<lsi.length)){
						f= lsi[cont].getString().getContent();
					}
					//si no encuentra el idioma buscado, devuelve el primero por defecto
					else{
						f= lsi[0].getString().getContent();
					}
		    	}
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger la fuente de la ruta taxonómica de la posición: " +indexRutaTax;
			logger.warn(mensaje);
			
			f= null;
//			Devuelve null
			   return f;
			//throw e;
		}
		
		return f;	
	}
	
	// método que recoge todas las fuentes existentes en Classification en el idioma especificado
	public ArrayList getFuentesIdioma (java.lang.String idioma
    ) throws java.lang.Exception {
		
		ArrayList fList= new ArrayList();
		
		try{
			TaxonPath[] tp=classification.getGroupClassificationClassification().getTaxonPath();
			if (tp!= null){
				for (int i= 0; i<tp.length; i++){
					LanguageStringItem[] lsi= tp[i].getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem();
					if ((lsi != null) && (lsi.length>0)){
			    		int cont= 0;
						boolean idiEncontrado= false;
						while ((cont<lsi.length) && (idiEncontrado== false)){
							if (idioma.equals(lsi[cont].getString().getLanguage())){
								idiEncontrado= true;
							}
							else{
								cont++;
							}
						}
						if ((idiEncontrado) && (cont<lsi.length)){
							fList.add(lsi[cont].getString().getContent());
						}
						
			    	}
				}
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger la fuentes de las rutas taxonómicas";
			logger.warn(mensaje);
			
			fList= new ArrayList();
			return fList;
			//throw e;
		}
		
		return fList;
	}
	
	//	 método que recoge todas las fuentes existentes en Classification en cualquier idioma
	public ArrayList getFuentes(
    ) throws java.lang.Exception {
		
		ArrayList fList= new ArrayList();
		
		try{
			TaxonPath[] tp=classification.getGroupClassificationClassification().getTaxonPath();
			if (tp!= null){
				for (int i= 0; i<tp.length; i++){
					fList.add(tp[i].getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem(0).getString().getContent());
				}
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger la fuentes de las rutas taxonómicas";
			logger.warn(mensaje);
			
			fList= new ArrayList();
			return fList;
			//throw e;
		}
		
		return fList;
	}
	
	// método que recoge el id del taxón existente en una ruta dada y en la posición indicada en el parámetro
	public java.lang.String getIdentificador (int indexRuta, int indexTaxon
    ) throws java.lang.Exception {
		
		java.lang.String i= null;
		
		try{
			i= classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getTaxon(indexTaxon).getGroupTaxonTaxon().getId().getGroupIdId().getContent();
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger el identificador de la ruta: " +indexRuta;
			logger.warn(mensaje);
			
//			Devuelve null
			   return i;
			//throw e;
		}
		
		return i;
	}
	
	// método que recoge todos los ids de los taxones que conforman la ruta taxonómica de la posición indexRuta
	public ArrayList getIdentificadores (int indexRuta
    ) throws java.lang.Exception {
		
		ArrayList iList= new ArrayList();
		
		try{
			Taxon[] t= classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getTaxon();
			if (t!= null){
				for (int i= 0; i<t.length; i++){
					iList.add(t[i].getGroupTaxonTaxon().getId().getGroupIdId().getContent());
				}
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger los identificadores de la ruta: " +indexRuta;
			logger.warn(mensaje);
			
			
			iList= new ArrayList();
//			Devuelve lista vacía
			   return iList;
			//throw e;
		}
		
		return iList;
	}
	
	// método que recoge el entry del taxón en la posición indexTaxon de un taxonPath dado en el idioma especificado
	public java.lang.String getEntrada (int indexRuta, int indexTaxon, java.lang.String idioma
    ) throws java.lang.Exception {
		
		java.lang.String en= null;
		
		try{
			LanguageStringItem[] lsi=classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getTaxon(indexTaxon).getGroupTaxonTaxon().getEntryTaxon().getGroupEntryTaxonEntry().getLanguageStringItem();
			if ((lsi != null) && (lsi.length>0)){
	    		int cont= 0;
				boolean idiEncontrado= false;
				while ((cont<lsi.length) && (idiEncontrado== false)){
					if (idioma.equals(lsi[cont].getString().getLanguage())){
						idiEncontrado= true;
					}
					else{
						cont++;
					}
				}
				if ((idiEncontrado) && (cont<lsi.length)){
					en= lsi[cont].getString().getContent();
				}
				//si no encuentra el idioma buscado, devuelve el primero por defecto
				else{
					en= lsi[0].getString().getContent();
				}
	    	}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger el identificador de la ruta: " +indexRuta;
			logger.warn(mensaje);
			
			en= null;
			//Devuelve null
			return en;
			//throw e;
		}
		
		return en;
	}
	
	// método que introduce la fuente en un taxonPath
	public void setFuente(
    		int indexRuta, java.lang.String idioma, java.lang.String fue ) 
    throws java.lang.Exception{
		
		Source s= new Source();
		GroupSourceSource gss= new GroupSourceSource();
		LanguageStringItem lsi= new LanguageStringItem();
		es.pode.parseadorXML.castor.String st= new es.pode.parseadorXML.castor.String();
		st.setContent(fue);
		st.setLanguage(idioma);
		lsi.setString(st);
		gss.addLanguageStringItem(lsi);
		s.setGroupSourceSource(gss);
		
		try{
			
			if (indexRuta<classification.getGroupClassificationClassification().getTaxonPath().length){
				boolean encontrado= false;
	    		int i= 0;
	    		while ((!encontrado) && (i<classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItemCount())){
	    			if (idioma.equals(classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem(i).getString().getLanguage())){
	    				encontrado = true;
	    			}
	    			else
	    				i++;
	    		}
	    		
	    		if (encontrado){
	    			classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem(i).getString().setContent(fue);
	    	
	    		}
	    		else{
	    			if (classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getSource()!= null){
	    				classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().addLanguageStringItem(lsi);
	    			}
	    			else{
	    				classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().setSource(s);
	    			}

	    		}
			}
			else{
				TaxonPath tp= new TaxonPath();
				GroupTaxonPathTaxonPath gtt= new GroupTaxonPathTaxonPath();
				tp.setGroupTaxonPathTaxonPath(gtt);
				tp.getGroupTaxonPathTaxonPath().setSource(s);
				
				classification.getGroupClassificationClassification().addTaxonPath(tp);
			}

			
		} catch (Exception e){
			String mensaje = "Error: No es posible insertar la fuente en la ruta: " +indexRuta;
			logger.error(mensaje);
			throw e;
		}
	}
	
	public void addTaxon (int indexRuta, java.lang.String ide, java.lang.String ent, java.lang.String idioma
    ) throws java.lang.Exception {
		
		Taxon t= new Taxon();
		GroupTaxonTaxon gtt= new GroupTaxonTaxon();
		
		Id id= new Id();
		GroupIdId gii= new GroupIdId();
		gii.setContent(ide);
		id.setGroupIdId(gii);
		
		EntryTaxon et= new EntryTaxon();
		GroupEntryTaxonEntry gete= new GroupEntryTaxonEntry();
		LanguageStringItem lsi= new LanguageStringItem();
		es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
		s.setContent(ent);
		s.setLanguage(idioma);
		lsi.setString(s);
		gete.addLanguageStringItem(lsi);
		et.setGroupEntryTaxonEntry(gete);
		
		gtt.setId(id);
		gtt.setEntryTaxon(et);
		t.setGroupTaxonTaxon(gtt);
		
		try{
			classification.getGroupClassificationClassification().getTaxonPath(indexRuta).getGroupTaxonPathTaxonPath().addTaxon(t);
			
		} catch (Exception e){
			String mensaje = "Error: No es posible insertar el taxón en la ruta: " +indexRuta;
			logger.error(mensaje);
			throw e;
		}
	}
	
	public void removeTaxonPath (int indexRuta
    ) throws java.lang.Exception {
		
		try{
			classification.getGroupClassificationClassification().removeTaxonPathAt(indexRuta);
			
		} catch (Exception e){
			String mensaje = "Error: No es posible eliminar el taxonPath en la posición: " +indexRuta;
			logger.error(mensaje);
			throw e;
		}
	}
	
	public int getIndiceUltimoTaxonPath (
    ) throws java.lang.Exception {
		
		int ultimoTaxonPath= -1;
		
		try{
			TaxonPath[] t= classification.getGroupClassificationClassification().getTaxonPath();
			
			if (t != null){
				ultimoTaxonPath= t.length -1;
			}
		} catch (Exception e){
			String mensaje = "Warning: No es posible obtener el índice del último taxonPath";
			logger.warn(mensaje);
			
			ultimoTaxonPath= -1;
			return ultimoTaxonPath;
			//throw e;
		}
		
		
		return ultimoTaxonPath;
		
	}
	
	public int getIndiceUltimoTaxon (int indexTaxonPath
    ) throws java.lang.Exception {
		
		int ultimoTaxon= -1;
		
		try{
			Taxon[] t= classification.getGroupClassificationClassification().getTaxonPath(indexTaxonPath).getGroupTaxonPathTaxonPath().getTaxon();
			if (t!= null){
				ultimoTaxon= t.length -1;
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible obtener el índice del último taxón de la ruta en la posición: " +indexTaxonPath;
			logger.warn(mensaje);
			
			return -1;
			//throw e;
		}
		
		return ultimoTaxon;
	}
	
	public int getTaxonPathsCount (
    ) throws java.lang.Exception {
		
		int longitud= 0;
		
		try{
			TaxonPath[] tp= classification.getGroupClassificationClassification().getTaxonPath();
			if (tp != null){
				longitud= tp.length;
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible obtener el número de taxonPaths";
			logger.warn(mensaje);
			
			longitud= 0;
			return longitud;
			//throw e;
		}
		
		return longitud;
	}
	
//  Este metodo devuelve todos los arboles curriculares que contenga un metadato LOM en el idioma solicitado.
//  De cada árbol curricular, se devolverán todas las entradas de sus taxones concatenadas mediante el caracter '/'
  public ArrayList getArbolesCurriculares (java.lang.String arbolCurricular, java.lang.String idioma)
  throws java.lang.Exception {
	  
	  ArrayList al= new ArrayList();
  	  java.lang.String arbol= "";
  	  
//  	  Properties properties = new Properties(); 
//	  InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
//	  properties.load(is);
	  
//	  String arbolCurricular= properties.getProperty("arbol_curricular");
	  
	  int nTaxonPaths= this.getIndiceUltimoTaxonPath();
	  
	  for (int i= 0; i<= nTaxonPaths; i++){
  		java.lang.String fuente= this.getFuente(i, idioma);
  		if (fuente != null){
  			if (arbolCurricular.equals(fuente)){
  				int nUltimoTaxon= this.getIndiceUltimoTaxon(i);
  				for (int j= 0; j<= nUltimoTaxon; j++){
  					arbol= arbol.concat(this.getEntrada(i, j, idioma)+"/");
  				}
  				al.add(arbol);	
  			}
  		}  		
  	  } 
	  if (al.size() == 0){
  		al= null;
  	  }
	  
  	  return al; 
  }
  
//Este metodo devuelve todos los identificadores de las ramas pertenecientes a los arboles curriculares que 
//contenga un metadato LOM en el idioma solicitado.
//De cada árbol curricular, se devolverán todas los identificadores de sus taxones concatenados mediante el caracter '/'
  public ArrayList getIdsArbolesCurriculares (java.lang.String arbolCurricular)
  throws java.lang.Exception {
	
	ArrayList al= new ArrayList();
	java.lang.String arbol= "";
	ArrayList lFuentes;
	boolean encontrado= false;
	
//	Properties properties = new Properties(); 
//	InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
//	properties.load(is);
//	  
//	String arbolCurricular= properties.getProperty("arbol_curricular");
	  
	int nTaxonPaths= this.getIndiceUltimoTaxonPath();
	
	if (arbolCurricular!=null){
		for (int i= 0; i<= nTaxonPaths; i++){
			
			encontrado= false;
			
			LanguageStringItem[] lsi= classification.getGroupClassificationClassification().getTaxonPath(i).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem();
			if (lsi!=null){
				int cont= 0;
				
				while ((cont<lsi.length)&& (!encontrado)){
					if (arbolCurricular.equals(lsi[cont].getString().getContent())){
						encontrado= true;
					}
					else{
						cont ++;
					}
				}	
			}
			
			if (encontrado){
					int nUltimoTaxon= this.getIndiceUltimoTaxon(i);
					for (int j= 0; j<= nUltimoTaxon; j++){
						arbol= arbol.concat(this.getIdentificador(i, j)+"/");
					}
					al.add(arbol);
					arbol= "";
			}
	  	}
	}
	
	
	if (al.size() == 0){
  		al= null;
  	}
	
  	return al;
  }
  
  
//Este metodo devuelve todos los identificadores de las ramas pertenecientes al tesauro ETB.
//De cada rama del tesauro, se devolverán todas los identificadores de sus taxones concatenados mediante el caracter '/'
  public ArrayList getIdsTesauroETB (java.lang.String nomTesauro)
  throws java.lang.Exception {
	
	ArrayList al= new ArrayList();
	java.lang.String etb= "";
	ArrayList lFuentes;
	boolean encontrado= false;
	
//	Properties properties = new Properties(); 
//	InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
//	properties.load(is);
//	  
//	String nomTesauro= properties.getProperty("tesauro_etb");
	  
	int nTaxonPaths= this.getIndiceUltimoTaxonPath();
	
	if (nomTesauro!= null){
		
		for (int i= 0; i<= nTaxonPaths; i++){
			
			encontrado= false;
			
			LanguageStringItem[] lsi= classification.getGroupClassificationClassification().getTaxonPath(i).getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem();
			if (lsi!=null){
				int cont= 0;
				
				while ((cont<lsi.length)&& (!encontrado)){
					if (nomTesauro.equals(lsi[cont].getString().getContent())){
						encontrado= true;
					}
					else{
						cont ++;
					}
				}	
			}
			
			if (encontrado){
					int nUltimoTaxon= this.getIndiceUltimoTaxon(i);
					for (int j= 0; j<= nUltimoTaxon; j++){
						etb= etb.concat(this.getIdentificador(i, j)+"/");
					}
					al.add(etb);
					etb= "";
			}
	  	}
		
	}
	

	if (al.size() == 0){
  		al= null;
  	}
	
  	return al;
  }
  
  
  
  public ArrayList getIdsNivelesEducativos (java.lang.String idioma)
  throws java.lang.Exception {
	  
		ArrayList al= new ArrayList();
		java.lang.String arbol= "";
		  
		Properties properties = new Properties(); 
		InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
		properties.load(is);
		  
		String arbolCurricular= properties.getProperty("nivel_educativo");
		
		int nTaxonPaths= this.getIndiceUltimoTaxonPath();
	  	
	  	for (int i= 0; i<= nTaxonPaths; i++){
	  		java.lang.String fuente= this.getFuente(i, idioma);
	  		if (fuente != null){
	  			if (arbolCurricular.equals(fuente)){
	  				int nUltimoTaxon= this.getIndiceUltimoTaxon(i);
	  				for (int j= 0; j<= nUltimoTaxon; j++){
	  					arbol= arbol.concat(this.getIdentificador(i, j)+"/");
	  				}	
	  				al.add(arbol);
	  				arbol= null;
	  			}
	  		}
	  	}	
	  	if (al.size() == 0){
	  		al= null;
	  	}
	  	
	  	return al;
  }
  /*********** Métodos para Catalogador Avanzado ***************/
  
  public String getPropositoAv() throws Exception{
	//  String proposito=getProposito();
	  
		java.lang.String proposito= null;
		
		try{
			if(classification.getGroupClassificationClassification().getPurpose()!=null)
				proposito= classification.getGroupClassificationClassification().getPurpose().getGroupPurposePurpose().getComplexTypePurposeVocabValue().getContent();
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger el propósito de Classification";
			logger.warn(mensaje);
			
			proposito= null;
			return proposito;
			//throw e;
		}
		
		return proposito;
  }
	
  public ArrayList getRutaTaxonomicasAv(){
	  ArrayList rutas=new ArrayList();
	  
	  try{
		TaxonPath[] path = classification.getGroupClassificationClassification().getTaxonPath();
		if((path!=null)&&(path.length>0)){
			for(int i=0;i<path.length;i++){
				RutaTaxonomicaAgrega ruta=new RutaTaxonomicaAgrega();
				ArrayList lFuentes=new ArrayList();
				ArrayList lTaxones=new ArrayList();
				LanguageStringItem[] lsi = path[i].getGroupTaxonPathTaxonPath().getSource().getGroupSourceSource().getLanguageStringItem();
				Taxon[] tax = path[i].getGroupTaxonPathTaxonPath().getTaxon();
				if((lsi!=null)&&(lsi.length>0)){
					for(int j=0;j<lsi.length;j++){
						LangStringAgrega fuente=new LangStringAgrega();
						fuente.setValor(lsi[j].getString().getContent());
						fuente.setIdioma(lsi[j].getString().getLanguage());
						lFuentes.add(fuente);
					}
				}
				ruta.setFuente(lFuentes);
				if((tax!=null)&&(tax.length>0)){
					for(int j=0;j<tax.length;j++){
						TaxonAgrega taxon=new TaxonAgrega();
						ArrayList lista=new ArrayList();
						taxon.setIdentificador(tax[j].getGroupTaxonTaxon().getId().getGroupIdId().getContent());
						LanguageStringItem[] lsit = tax[j].getGroupTaxonTaxon().getEntryTaxon().getGroupEntryTaxonEntry().getLanguageStringItem();
						if((lsit!=null)&&(lsit.length>0)){
							for(int k=0;k<lsit.length;k++){
								LangStringAgrega lEntrada=new LangStringAgrega();
								lEntrada.setValor(lsit[k].getString().getContent());
								lEntrada.setIdioma(lsit[k].getString().getLanguage());
								lista.add(lEntrada);
							}
							taxon.setTaxones(lista);
						}
						
						lTaxones.add(taxon);
					}
				}
				
				ruta.setTaxones(lTaxones);
				rutas.add(ruta);
			}
			
		}
		
		
	  }catch (Exception e){
		   String mensaje = "Warning: No es posible recoger la lista de las rutas taxonómicas";
		   logger.warn(mensaje);
		   rutas=new ArrayList();
		   return rutas;
		   //throw e;
	   }
	  
	  return rutas;
  }
  
  public ArrayList getDescripcionesAv(){
	  ArrayList descripciones=new ArrayList();
	  try{
		  Description descrip = classification.getGroupClassificationClassification().getDescription();
		  if(descrip!=null){
			  LanguageStringItem[] lsi = descrip.getGroupDescriptionDescription().getLanguageStringItem();
			  if((lsi!=null)&&(lsi.length>0)){
				  for(int i=0;i<lsi.length;i++){
					  LangStringAgrega des=new LangStringAgrega();
					  des.setValor(lsi[i].getString().getContent());
					  des.setIdioma(lsi[i].getString().getLanguage());
					  descripciones.add(des);
				  }
			  }
		  }
	  }catch (Exception e){
		   String mensaje = "Warning: No es posible recoger la lista de las descripciones";
		   logger.warn(mensaje);
		   descripciones=new ArrayList();
		   return descripciones;
		   //throw e;
	   }
	  
	  return descripciones;
	  
  }
  
  public ArrayList getPalabrasClaveAv(){
	  ArrayList lPalabras=new ArrayList();
	  try{
		  Keyword[] key = classification.getGroupClassificationClassification().getKeyword();
		  if((key!=null)&&(key.length>0)){
			  for(int i=0;i<key.length;i++){
				  ArrayList lsik=new ArrayList();
				  LanguageStringItem[] lsi = key[i].getGroupKeywordKeyword().getLanguageStringItem();
				  if((lsi!=null)&&(lsi.length>0)){
					  for(int j=0;j<lsi.length;j++){
						  LangStringAgrega l=new LangStringAgrega();
						  l.setValor(lsi[j].getString().getContent());
						  l.setIdioma(lsi[j].getString().getLanguage());
						  lsik.add(l);
					  }
				  }
				  lPalabras.add(lsik); 
			  }
			  
		  }
		  
	  }catch (Exception e){
		   String mensaje = "Warning: No es posible recoger la lista de las palabras clave";
		   logger.warn(mensaje);
		   lPalabras=new ArrayList();
		   return lPalabras;
		   //throw e;
	   }
	  
	  return lPalabras;
  }
  
  /*************Métodos SET para el Avanzado****************/
  
  public void setPropostitoAv(String proposito) throws Exception{
	 //setProposito(proposito);

		String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		
		Purpose p= null;
		if(proposito !=null){
			p= new Purpose();
			GroupPurposePurpose gpp= new GroupPurposePurpose();
			ComplexTypePurposeVocabSource ctpvs= new ComplexTypePurposeVocabSource();
			ComplexTypePurposeVocabValue ctpvv= new ComplexTypePurposeVocabValue();
			
			ctpvs.setContent(lomes);
			ctpvv.setContent(proposito);
			gpp.setComplexTypePurposeVocabSource(ctpvs);
			gpp.setComplexTypePurposeVocabValue(ctpvv);
			p.setGroupPurposePurpose(gpp);
		}
		
		if (classification == null){
			classification= new Classification();
		}
		    
		if (classification.getGroupClassificationClassification()== null){
			GroupClassificationClassification gccAux= new GroupClassificationClassification();
			classification.setGroupClassificationClassification(gccAux);
		}
		
		classification.getGroupClassificationClassification().setPurpose(p);
  }
  
  public void setDescripcionesAv(ArrayList descripciones) throws Exception{
	  try{
		   
	  	   Description du=new Description();
	  	   GroupDescriptionDescription gdud=new GroupDescriptionDescription();
	  	   ArrayList array=new ArrayList();
		   if((descripciones!=null)&&(descripciones.size()>0)){
 
			   for(int i=0;i<descripciones.size();i++){

				   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
				   LanguageStringItem lsi=new LanguageStringItem();
					   
				   String idioma= ((LangStringAgrega)(descripciones.get(i))).getIdioma();
				   String valor= ((LangStringAgrega)(descripciones.get(i))).getValor();
				   string.setContent(valor);
				   string.setLanguage(idioma);
				   lsi.setString(string);
				   array.add(lsi);	   
   
			   }
			   
			  
		   }
		   
		   
		   LanguageStringItem[] lang=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
		   gdud.setLanguageStringItem(lang); 
		   
		   du.setGroupDescriptionDescription(gdud);
		   classification.getGroupClassificationClassification().setDescription(du);
		   
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las descripciones ";
		    logger.error(mensaje);
		    throw e;
	    } 
  }
  
  public void setPalabrasClaveAv(ArrayList palabrasClave) throws Exception{
	  try{
		  
		   ArrayList arrayPalabras=new ArrayList();
		   if((palabrasClave!=null)&&(palabrasClave.size()>0)){
			  
			   
			   for(int i=0;i<palabrasClave.size();i++){
				   GroupKeywordKeyword gkk=new GroupKeywordKeyword();
				   Keyword keyWord=new Keyword();
				   ArrayList palabras=(ArrayList)(palabrasClave.get(i));
				   ArrayList array=new ArrayList();
				   for(int j=0;j<palabras.size();j++){
					   
					   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
					   LanguageStringItem lsi=new LanguageStringItem();
					   String idioma=((LangStringAgrega)(palabras.get(j))).getIdioma();
					   String valor=((LangStringAgrega)(palabras).get(j)).getValor();
					   string.setContent(valor);
					   string.setLanguage(idioma);
					   lsi.setString(string);
					   array.add(lsi);
				   }
				   LanguageStringItem[] lang=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
				   gkk.setLanguageStringItem(lang);
				   keyWord.setGroupKeywordKeyword(gkk);
				   arrayPalabras.add(keyWord);
			   }
			   
			   Keyword[] key=(Keyword[])arrayPalabras.toArray(new Keyword[arrayPalabras.size()]);
			   
			   classification.getGroupClassificationClassification().setKeyword(key);
		   }
		   
		   
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las palabras clave ";
		    logger.error(mensaje);
		    throw e;
	    } 
  }
  
  public void setRutaTaxonomicasAv(ArrayList rutaTaxonomica) throws Exception{
	  try{
		  
		
	  	  ArrayList array=new ArrayList();
		  if((rutaTaxonomica!=null)&&(rutaTaxonomica.size()>0)){
			 
			  for(int i=0;i<rutaTaxonomica.size();i++){
				  TaxonPath taxonPath=new TaxonPath();
				  GroupTaxonPathTaxonPath gtptp=new GroupTaxonPathTaxonPath();
				  ArrayList lFuentes=((RutaTaxonomicaAgrega)(rutaTaxonomica.get(i))).getFuente();
				  ArrayList lTaxones=  ((RutaTaxonomicaAgrega)(rutaTaxonomica.get(i))).getTaxones();
				  
				  Source source=new Source();
				  GroupSourceSource gss=new GroupSourceSource();
				  ArrayList lista=new ArrayList();
				  if((lFuentes!=null)&&(lFuentes.size()>0)){
					  
					  for(int j=0;j<lFuentes.size();j++){
						  String idioma=((LangStringAgrega)(lFuentes.get(j))).getIdioma();
						  String valor=((LangStringAgrega)(lFuentes.get(j))).getValor();
						  es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
						  LanguageStringItem lsi=new LanguageStringItem();
						  string.setContent(valor);
						  string.setLanguage(idioma);
						  lsi.setString(string);
						  lista.add(lsi);
						  
					  }
				  }
				  LanguageStringItem[] llsi=(LanguageStringItem[])lista.toArray(new LanguageStringItem[lista.size()]);
				  gss.setLanguageStringItem(llsi);
				  source.setGroupSourceSource(gss);
				  gtptp.setSource(source);
				  
				  ArrayList llTax=new ArrayList();
				  
				  if((lTaxones!=null)&&(lTaxones.size()>0)){
					  for(int j=0;j<lTaxones.size();j++){
						  
						  EntryTaxon entry=new EntryTaxon();
						
						  String identificador=((TaxonAgrega)(lTaxones.get(j))).getIdentificador();
						  Id id=new Id();
						  GroupIdId gii=new GroupIdId ();
						  gii.setContent(identificador);
						  id.setGroupIdId(gii);
						  ArrayList taxones=((TaxonAgrega)(lTaxones.get(j))).getTaxones();
						  
						  Taxon taxon=new Taxon();
						  GroupTaxonTaxon gtt=new GroupTaxonTaxon();
						  
						 
						  GroupEntryTaxonEntry gete=new GroupEntryTaxonEntry();
						  ArrayList lTaxEn=new ArrayList();
						  if((taxones!=null)&&(taxones.size()>0)){
							  
							  for(int k=0;k<taxones.size();k++){
								  
								  LanguageStringItem lsiTax=new LanguageStringItem();
								  
								  es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
								 
								  String idiomaTax=((LangStringAgrega)(taxones.get(k))).getIdioma();
								  String valorTax=((LangStringAgrega)(taxones.get(k))).getValor();
								  string.setContent(valorTax);
								  string.setLanguage(idiomaTax);
								  lsiTax.setString(string);
								  lTaxEn.add(lsiTax);
							  
							  }
							  LanguageStringItem[] lTaxo=(LanguageStringItem[])lTaxEn.toArray(new LanguageStringItem[lTaxEn.size()]);
							  gete.setLanguageStringItem(lTaxo);
							  entry.setGroupEntryTaxonEntry(gete);
							  
						  }
						  gtt.setEntryTaxon(entry);
						  gtt.setId(id);
						  taxon.setGroupTaxonTaxon(gtt);
						  llTax.add(taxon);
					  }
					  
					  
					  Taxon[] lTaxoness=(Taxon[])llTax.toArray(new Taxon[llTax.size()]);
					  gtptp.setTaxon(lTaxoness);
				  }
				 
				  taxonPath.setGroupTaxonPathTaxonPath(gtptp);
				  array.add(taxonPath);
			  }
		  }
		  
		  TaxonPath[] lTaxonPath=(TaxonPath[])array.toArray(new TaxonPath[array.size()]);
		  classification.getGroupClassificationClassification().setTaxonPath(lTaxonPath);
	  }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las rutas taxonomicas ";
		    logger.error(mensaje);
		    throw e;
	    } 
  }
}
