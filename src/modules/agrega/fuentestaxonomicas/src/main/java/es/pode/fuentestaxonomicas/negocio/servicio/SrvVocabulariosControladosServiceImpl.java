/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

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
import java.util.Properties;

import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import org.apache.log4j.Logger;

import es.pode.soporte.i18n.I18n;



public class SrvVocabulariosControladosServiceImpl
    extends es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosServiceBase
{
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * Es el contructor y hace la llamada a cargarVocabularios()
	 * @throws Exception
	 */
	public SrvVocabulariosControladosServiceImpl() throws Exception {
		cargarVocabularios();
	}
	private static HashMap hashMapVocabularios = new HashMap();
	private static String nomFichVoc; 
//	Almacena en una lista todos los ficheros de la carpeta que se le pasa por par�metro.
	
	/**
	 * Recoge los ficheros de la carpeta que se le pasa por par�metro
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
            {
            	if (archivos[i].endsWith(".xml"))
            		lista.add(archivos[i]);
            }
        }
        return lista;
    }
	
	/**
	 * Carga los vocabularios de nombre vocabLOMES
	 * @throws Exception
	 */
	private  void cargarVocabularios() throws Exception{
		
		String rutaproperties = null;
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		
		try {
			is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties fproperties = new Properties();
			fproperties.load(is);
			nomFichVoc=fproperties.getProperty("nombreFichVoc");
			rutaproperties = fproperties.getProperty("rutaVocabularios");
			
//			tomamos el contenido de la carpeta en la lista
	        List ficherosaux = getFiles(rutaproperties);
	        List ficheros=new ArrayList();
//			Cogemos las properties que nos interesan
	        for(int j=0;j<ficherosaux.size();j++){
	        	if(((String)ficherosaux.get(j)).startsWith(nomFichVoc)){
	        		ficheros.add((String)ficherosaux.get(j));
	        	}
	        }
	        for(int i=0;i<ficheros.size();i++){
	        	
	        	String nombreFich = (String)ficheros.get(i);
	        	File docFile = new File(rutaproperties+(String)ficheros.get(i));
	        	Document doc = null;
	        	try{
//	        		Parseamos y lo incluimos en un hashmap
	        		SAXBuilder builder = new SAXBuilder(false);
	        		doc = builder.build(docFile);
	        		hashMapVocabularios.put(nombreFich,doc);       	
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
	 * Traduce los t�rminos con identificadores del l_id a ingles
	 * @param l_id Lista de identificadores de los vocabularios
	 * @return terminoypadreVO Array de tipo TerminoYPadreVO que contiene el identificador del termino,nombre del termino,idioma del termino (en este caso "en") y identificador del vocabulario
	 * @throws Exception
	 * 
	 */
    protected TerminoYPadreVO[] handleCrearTraduccionAIngles(String[] l_id) throws Exception
    {
    	String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
		String rutaproperties = fproperties.getProperty("rutaVocabularios");
		List ficherosaux = getFiles(rutaproperties);
	    boolean encontrado=false;
	    encontrado=buscaFichero(ficherosaux, "en");
	    if (!encontrado){
	    	String idioPlat=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	    	encontrado=buscaFichero(ficherosaux, idioPlat);
	    	if (!encontrado) {
	    		buscaFichero(ficherosaux, "es");
	    	}
	    }
		///////////////
    	Document doc = null;
		doc = (Document) hashMapVocabularios.get(nomFichVoc +"_en.xml");
		TerminoYPadreVO[] terminoypadreVO=null;

			try{	
				
				Element raiz=doc.getRootElement();
				Namespace namespace=raiz.getNamespace();
				List terminoNombre=new ArrayList();
				
				for(int iter=0;iter<l_id.length;iter++){
					//Los term de primer nivel
					List hijos=raiz.getChildren("term",namespace);
					Iterator i=hijos.iterator();
					
					while(i.hasNext()){
						
						Element e=(Element)i.next();
						Element termPadre=e.getChild("termIdentifier",namespace);
						//Los term de segundo nivel
						List id =e.getChildren("term",namespace);
						Iterator j=id.iterator();
						while(j.hasNext()){
							
							Element ed=(Element)j.next();
							//Los identificadores del segundo nivel
							Element nietos=ed.getChild("termIdentifier",namespace);
							//Si son iguales a los identificadores de la lista recogemos sus valores
							if(l_id[iter].equals(nietos.getText())){
								TerminoVO termino=new TerminoVO();
								TerminoYPadreVO terminoypadre=new TerminoYPadreVO();
								termino.setIdTermino(nietos.getText());
								terminoypadre.setIdTermino(nietos.getText());
								List nombre=ed.getChildren("caption", namespace);
								Iterator k=nombre.iterator();
								while(k.hasNext()){
									Element le=(Element)k.next();
									//Recogemos el texto de segundo nivel
									Element langstring=le.getChild("langstring", namespace);
									termino.setNomTermino(langstring.getText());
									terminoypadre.setNomTermino(langstring.getText());
				            		termino.setIdiomaTermino("en");
				            		terminoypadre.setIdiomaTermino("en");
				            		terminoypadre.setIdVocabulario(termPadre.getText());
				            		terminoNombre.add(terminoypadre);
								}	
							}
						}
						terminoypadreVO=(TerminoYPadreVO[])terminoNombre.toArray(new TerminoYPadreVO[terminoNombre.size()]);
					}	
				}
			}catch(Exception e){
				logger.error("Error en FuentesTaxonomicas, metodo handleCrearTraduccionAIngles " + e);
			}
		
        //@todo implement protected es.pode.FuentesTaxonomicas.negocio.servicio.TerminoVO[] handleTraduceAIdioma(java.util.List l_id, java.lang.String idioma)
        return terminoypadreVO;
    }

    /**
	 * Traduce los t�rminos con identificadores del l_id al idioma que le pasamos por par�metro
	 * @param l_id Lista de identificadores de los vocabularios
	 * @param idioma Idioma del vocabulario
	 * @return terminoypadreVO Array de tipo TerminoYPadreVO que contiene el identificador del termino,nombre del termino,idioma del termino  y identificador del vocabulario
	 * @throws Exception
	 * 
	 */
    protected TerminoVO[] handleCrearTraduccionAIdioma(String[] l_id, String idioma) throws Exception 
    {
//		buscamos si el fichero existe, en caso contrario lo comprobamos para el idioma de la plataforma o ya el propio espa�ol
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
		String rutaproperties = fproperties.getProperty("rutaVocabularios");
		List ficherosaux = getFiles(rutaproperties);
	    boolean encontrado=false;
	    encontrado=buscaFichero(ficherosaux, idioma);
	    if (!encontrado){
	    	String idioPlat=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	    	encontrado=buscaFichero(ficherosaux, idioPlat);
	    	if (!encontrado) {
	    		buscaFichero(ficherosaux, "es");
	    		idioma="es";
	    	}else {
	    		idioma=idioPlat;
	    	}
	    }
		///////////////
	    
    	Document doc = null;
		doc = (Document) hashMapVocabularios.get(nomFichVoc +"_"+idioma+".xml");
		TerminoVO[] terminoVO=null;

			try{	
				
				Element raiz=doc.getRootElement();
				Namespace namespace=raiz.getNamespace();
				List terminoNombre=new ArrayList();
				
				for(int iter=0;iter<l_id.length;iter++){
					//Los term de primer nivel
					List hijos=raiz.getChildren("term",namespace);
					Iterator i=hijos.iterator();
					
					while(i.hasNext()){
						
						Element e=(Element)i.next();
						
						//Los term de segundo nivel
						List id =e.getChildren("term",namespace);
						Iterator j=id.iterator();
						while(j.hasNext()){
							
							Element ed=(Element)j.next();
							//Los identificadores del segundo nivel
							Element nietos=ed.getChild("termIdentifier",namespace);
							//Si son iguales a los identificadores de la lista recogemos sus valores
							if(l_id[iter].equals(nietos.getText())){
								TerminoVO termino=new TerminoVO();
								ArrayList terminoypadre=new ArrayList();
								termino.setIdTermino(nietos.getText());
								terminoypadre.add(nietos.getText());
								List nombre=ed.getChildren("caption", namespace);
								Iterator k=nombre.iterator();
								while(k.hasNext()){
									Element le=(Element)k.next();
									//Recogemos el texto de segundo nivel
									Element langstring=le.getChild("langstring", namespace);
									termino.setNomTermino(langstring.getText());
									terminoypadre.add(langstring.getText());
				            		termino.setIdiomaTermino(idioma);
				            		terminoypadre.add(idioma);
				            		
				            		terminoNombre.add(termino);
								}	
							}
						}
						terminoVO=(TerminoVO[])terminoNombre.toArray(new TerminoVO[terminoNombre.size()]);
					}	
				}
			}catch(Exception e){
				logger.error("Error en FuentesTaxonomicas, metodo crearTraduccionaIdioma " + e);
				e.printStackTrace();
			}
		
        //@todo implement protected es.pode.FuentesTaxonomicas.negocio.servicio.TerminoVO[] handleTraduceAIdioma(java.util.List l_id, java.lang.String idioma)
        return terminoVO;
    }


    /**
     * Obtiene los identificadores de los terminos
     * @param terminoypadre Array de tipo TerminoYPadreVO que contiene el identificador del termino,nombre del termino,idioma del termino  y identificador del vocabulario
     * @return TerminoYPadreVO[] Array de tipo TerminoYPadreVO con el campo idTermino relleno
     * @throws Exception
     */
	protected TerminoYPadreVO[] handleObtenerIdTermino(TerminoYPadreVO[] terminoypadre) throws Exception {
	
		String idiomaTermino=terminoypadre[0].getIdiomaTermino();

//		buscamos si el fichero existe, en caso contrario lo comprobamos para el idioma de la plataforma o ya el propio espa�ol
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
		String rutaproperties = fproperties.getProperty("rutaVocabularios");
		List ficherosaux = getFiles(rutaproperties);
	    boolean encontrado=false;
	    encontrado=buscaFichero(ficherosaux, idiomaTermino);
	    if (!encontrado){
	    	String idioPlat=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	    	encontrado=buscaFichero(ficherosaux, idioPlat);
	    	if (!encontrado) {
	    		buscaFichero(ficherosaux, "es");
	    		idiomaTermino="es";
	    	}else {
	    		idiomaTermino=idioPlat;
	    	}
	    }
		///////////////
	    
		Document doc = null;
		doc = (Document) hashMapVocabularios.get(nomFichVoc+"_"+idiomaTermino+".xml");
		Collection aux2=new ArrayList();
		
		try{
			Element raiz=doc.getRootElement();
			Namespace namespace=raiz.getNamespace();
			for ( int i=0;i<terminoypadre.length;i++){
				
				TerminoYPadreVO terminoYPadre=new TerminoYPadreVO();
				terminoYPadre.setIdVocabulario(terminoypadre[i].getIdVocabulario());
				terminoYPadre.setNomTermino(terminoypadre[i].getNomTermino());
				terminoYPadre.setIdiomaTermino(idiomaTermino);

				List hijos=raiz.getChildren("term",namespace);
				Iterator j = hijos.iterator();
				
				while (j.hasNext()){
					Element e= (Element)j.next();
					//Buscamos las etiquetas termIdentifier que coincidan con las nuestras
					Element id =e.getChild("termIdentifier",namespace);
					if(terminoypadre[i].getIdVocabulario().equals(id.getText())){						
						List termino=e.getChildren("term",namespace);
							Iterator v=termino.iterator();
							while(v.hasNext()){
								Element ve=(Element)v.next();
								List captionId=ve.getChildren("caption", namespace);
								Iterator vv=captionId.iterator();
								while(vv.hasNext()){
									Element vvv=(Element)vv.next();
									Element langs=vvv.getChild("langstring", namespace);
									//Buscamos los langstring que coincidan con los nuestros y recogemos el termIdentifier
									if(terminoypadre[i].getNomTermino().equals(langs.getText())){
										Element termId=ve.getChild("termIdentifier",namespace);
										terminoYPadre.setIdTermino(termId.getText());
									}
								}
							}
							aux2.add(terminoYPadre);
						}
					}
				}

			}catch(Exception em){
				logger.error("Error en FuentesTaxonomicas, metodo obtenerIdTermino " + em);
			}

		return (TerminoYPadreVO[])aux2.toArray(new TerminoYPadreVO[aux2.size()]);

	}

	private boolean buscaFichero(List ficherosaux, String idioma ) {
		boolean encontrado=false;
		int j=0;
		while ((j<ficherosaux.size()) && (!encontrado)) {
			if ( (((String)ficherosaux.get(j)).startsWith(nomFichVoc)) 
				&& (ficherosaux.get(j).toString().equals(nomFichVoc+"_"+idioma+".xml")) ){
				encontrado=true;
			}
			j++;
		}
		return encontrado; 
	}
	
	/**
	 * Obtiene los vocabularios de identificadores de la lista l_id en el idioma que le pasamos por par�metro
	 * @param l_id Array de identificadores de los vocabularios
	 * @param idioma Idioma de los vocabularios
	 * @return VocabularioVO[] Array de tipo VocabulariosVO que contiene el identificador el termino, el idioma del termino y el nombre del termino
	 * @throws Exception
	 */
	protected VocabularioVO[] handleObtenerCombos(String[] l_id, String idioma) throws Exception {
		Document doc = null;
		
		//buscamos si el fichero existe, en caso contrario lo comprobamos para el idioma de la plataforma o ya el propio espa�ol
		String ficheroProperties = "/fuentestaxonomicas.properties";
		InputStream is= null;
		is= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fproperties = new Properties();
		fproperties.load(is);
		String rutaproperties = fproperties.getProperty("rutaVocabularios");
		List ficherosaux = getFiles(rutaproperties);
	    boolean encontrado=false;
	    encontrado=buscaFichero(ficherosaux, idioma);
	    if (!encontrado){
	    	String idioPlat=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	    	encontrado=buscaFichero(ficherosaux, idioPlat);
	    	if (!encontrado) {
	    		buscaFichero(ficherosaux, "es");
	    		idioma="es";
	    	}else {
	    		idioma=idioPlat;
	    	}
	    }
		///////////////
		
		doc = (Document) hashMapVocabularios.get(nomFichVoc+"_"+idioma+".xml");
		Collection aux2=new ArrayList();

			try{
				
				Element raiz=doc.getRootElement();
				//For para buscar etiquetas
				for(int iter=0;iter<l_id.length;iter++){
						VocabularioVO vocabulario=new VocabularioVO();
						Namespace namespace=raiz.getNamespace();
						//Buscamos las etiquetas term de primer nivel
						List hijos=raiz.getChildren("term",namespace);
						Iterator i = hijos.iterator();
						while (i.hasNext()){
							Element e= (Element)i.next();
							//Buscamos las etiquetas termIdentifier 
							Element id =e.getChild("termIdentifier",namespace); 
							if(l_id[iter].equals(id.getText())){
								vocabulario.setIdVocabulario(id.getText());
								List caption=e.getChildren("caption",namespace);
								Iterator k=caption.iterator();
								while (k.hasNext()){
									Element cp=(Element)k.next();
									//Recogemos el texto de la etiqueta lanstring
									Element nombre=(Element) cp.getChild("langstring",namespace);
									vocabulario.setNomVocabulario(nombre.getText());
									vocabulario.setIdioma(idioma);
								}
								List terminoNombre=new ArrayList();
								//Buscamos las etiquetas term segundo nivel
								List terminos=e.getChildren("term",namespace);
								Iterator j=terminos.iterator();
								while(j.hasNext()){
									TerminoVO termino=new TerminoVO();
									Element ed=(Element)j.next();
									//Recogemos los datos de los term de segundo nivel
									Element termId=ed.getChild("termIdentifier",namespace);
									termino.setIdTermino(termId.getText());
									List capHijo=ed.getChildren("caption",namespace);
									Iterator l=capHijo.iterator();
					            	while (l.hasNext()){
					            		Element captionHijo=(Element)l.next();
					            		Element nombreHijo=(Element) captionHijo.getChild("langstring",namespace);
					            		termino.setNomTermino(nombreHijo.getText());
					            		termino.setIdiomaTermino(idioma);
					            		terminoNombre.add(termino);
					            	}
								}
								TerminoVO[] terminoVO=(TerminoVO[])terminoNombre.toArray(new TerminoVO[terminoNombre.size()]);
								vocabulario.setTerminos(terminoVO);
								aux2.add(vocabulario);
							}
						}
				}
			}catch(Exception e){
				logger.error("Error en FuentesTaxonomicas, metodo obtenerCombos " + e);
			}
	
        //@todo implement protected es.pode.FuentesTaxonomicas.negocio.servicio.VocabularioVO[] handleCargarCombos(java.util.List l_id, java.lang.String idioma)
        return (VocabularioVO[])aux2.toArray(new VocabularioVO[aux2.size()]);
 
	}
}

	



