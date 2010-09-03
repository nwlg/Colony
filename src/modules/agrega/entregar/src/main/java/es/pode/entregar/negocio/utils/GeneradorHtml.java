/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.entregar.negocio.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.pode.entregar.negocio.servicios.ItemVO;
import es.pode.entregar.negocio.servicios.ManifestVO;
import es.pode.entregar.negocio.servicios.OrganizacionVO;
import freemarker.core.Environment;
import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;



/*
 * Class GenearadorHtml
 * Clase que permite generar contenido html para ODEs
 */

//26/08/2010 Fernando Garcia: I have had to add 'titulo' parameter to all iFrames because sometimes is esential
//                            to have this dynamic parameter ready.
public class GeneradorHtml {
	
	private static Logger logger= Logger.getLogger(GeneradorHtml.class);
	private Properties props = new Properties();
	private Configuration cfg = new Configuration();
	private Map root = new HashMap();
	private NodeModel modelo=null;
	
	private String pathOde;
	private String dirDestino;
	private String pathLomesExterno=null;
	
	private static String MANIFEST="/imsmanifest.xml";
	
	
	
	/**
	 * Constructor
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * 
	 * @throws IOExeption si no puede leer fichero properties
         *
         * 11/08/2010 Fernando Garcia: the messages were hardcoded. I changed it and now it gets values from entregar.properties
         *
	 */
	public GeneradorHtml() 
	{
		
		try {
			java.io.InputStream is = this.getClass().getResourceAsStream("/entregar.properties");
			if (is != null)
				props.load(is);
			File templates=new File(props.getProperty("carpeta.templates"));
			if(!templates.exists())
				logger.debug("la carptea de templates no existe.... imposible crear los htmls" );
			cfg.setDirectoryForTemplateLoading(templates);

			root.put("noframesmensaje", props.getProperty("message.noframesmensaje"));
			root.put("enlaceCabecera", props.getProperty("message.enlaceCabecera"));
			root.put("enlaceMenu", props.getProperty("message.enlaceMenu"));
			root.put("enlaceContenido", props.getProperty("message.enlaceContenido"));
			root.put("enlace", props.getProperty("message.enlace"));
			root.put("redes", props.getProperty("message.redes"));
			root.put("comunidad", props.getProperty("message.comunidad"));
			root.put("contenido", props.getProperty("message.contenido"));
			root.put("contenidoPrincipal", props.getProperty("message.contenidoPrincipal"));
			root.put("salir", props.getProperty("message.salir"));
			root.put("siguiente", props.getProperty("message.siguiente"));
			root.put("anterior", props.getProperty("message.anterior"));
			root.put("infSiguiente", props.getProperty("message.infSiguiente"));
			root.put("infAnterior", props.getProperty("message.infAnterior"));

			NodeModel.useDefaultXPathSupport();
			cfg.setObjectWrapper(new DefaultObjectWrapper()); 
		} catch (Exception e) {
			logger.error("I cannot load the properties file");
		}
		
		
	}
	
	
	
	/**
	 * metodo que permite generar los ficheros html necesarios para visualizar el ODE
	 * como html
	 * 
	 * @param pathOde path donde se encuentra el ODE que se desea exportar
	 * @param dirDestino directorio donde se van a generar los ficheros html
	 * @throws Exception 
	 */
	public void generarFrames(String pathOde, String dirDestino)
	throws Exception
	{
		this.pathOde= pathOde;
		this.dirDestino= dirDestino;
		crearCarpeta(dirDestino + "/contenido");
		
		try {
			
			modelo= NodeModel.parse(new File(pathOde +MANIFEST));
			pathLomesExterno=chequearLomes();

                        String titulo=obtenerTitulo();

			generarBlanco(titulo);
			generarContenidoFrame(titulo);
			generarContenidoIndex(titulo);
			generarMenu(titulo);
			generarCabecera(titulo);
			generarIndex(titulo);
			
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarFrames .. " + e.getMessage() );}
			throw new Exception(e);
		}
	}
	
	/**
	 *	metodo que permite generar los ficheros html necesarios para visualizar el ODE
	 * 	como html
	 *  
	 * @param pathOde path donde se encuentra el ODE que se desea exportar
	 * @param dirDestino directorio donde se van a generar los ficheros html
	 * @param orgs ManifestVO objeto utilizado para generar el los datos que van a ser presentados
	 * @throws Exception
	 */
	public void generarFrames(String pathOde, String dirDestino,ManifestVO orgs)
	throws Exception
	{
		this.pathOde= pathOde;
		this.dirDestino= dirDestino;

		try {
                        String titulo=obtenerTitulo();
			
                        generarBlanco(titulo);
			generarContenidoFrame(titulo);
			generarContenidoIndex(titulo);
			generarMenu(orgs, titulo);
			generarCabecera(orgs.getTitulo());
			generarIndex(titulo);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarFrames .. " + e.getMessage() );}
			throw  e;
		}
	}
	

	/**
	 * genera la cabecera de la presentación... busca en el fichero manifest si
	 * el titulo del ODE
	 * 
	 * @throws Exception
	 */
//	private void generarCabecera()
//	throws Exception
//	{
//		FileOutputStream fo=null;
//		Writer out=null;
//		File index=null;
//		Template temp;
//		try {
//			String titulo=obtenerTitulo();
//			root.put("titulo", titulo);
//
//
//			temp = cfg.getTemplate("cabecera.ftl");
//			index= new File(dirDestino + "/contenido/cabecera.html");
//			boolean creado= index.createNewFile();
//			if(creado)
//			{
//				fo= new FileOutputStream(index);
//				out = new OutputStreamWriter(fo);
//				temp.process(root, out);
//				out.flush();
//			}
//
//		} catch (Exception e) {
//			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarCabecera .. " + e.getMessage() );}
//			throw  e;
//		}finally{
//			index=null;
//			if(fo!=null)
//			{
//				try {
//					fo.close();
//					out.close();
//				} catch (IOException e) {}
//			}
//		}
//	}

	/**
	 * Método que devuelve el título de ode en caso que existiera..
	 * busca el título en el lomes integrado en el manifest o en 
	 * algun lomes externo si lo tuviera.
	 * 
	 * @return String con el título del ode
	 */
	private String obtenerTitulo()
	throws Exception
	{
		String resultado="";
		if(pathLomesExterno==null)
			return resultado;
		boolean terminado =false;

		if(pathLomesExterno.equals(""))
		{
			Node nodo= modelo.getNode().getChildNodes().item(0);
			NodeModel.simplify(nodo);
			
			NodeList hijos = nodo.getChildNodes();
			for (int i = 0; i < hijos.getLength() && !terminado; i++) {
				Node child = hijos.item(i);
				if (child.getLocalName()!=null &&  child.getLocalName().equals("metadata")) {
					
					NodeList hijos2 = child.getChildNodes();
					for (int j = 0; j < hijos2.getLength() && !terminado; j++) {
						Node child2 = hijos2.item(j);
						if (child2.getLocalName()!=null &&  child2.getLocalName().equals("lom")) {
							
							
							NodeList hijos3 = child2.getChildNodes();
							for (int k = 0; k < hijos3.getLength() && !terminado; k++) {
								Node child3 = hijos3.item(k);
								if (child3.getLocalName()!=null &&  child3.getLocalName().equals("general")) {
	
									NodeList hijos4 = child3.getChildNodes();
									for (int l = 0; l < hijos4.getLength() && !terminado; l++) {
										Node child4 = hijos4.item(l);
										if (child4.getLocalName()!=null &&  child4.getLocalName().equals("title")) {
	
											NodeList hijos5 = child4.getChildNodes();
											for (int ll = 0; ll < hijos5.getLength() && !terminado; ll++) {
												Node child5 = hijos5.item(ll);
												if (child5.getLocalName()!=null &&  child5.getLocalName().equals("string")) {
													resultado=child5.getFirstChild().getNodeValue();
													
													terminado=true;
												}
											}
										}
									}
								}
							}
						}
					}
				}//metadata
			}
		}else
		{
			NodeModel modeloExterno=null;
			try {
				modeloExterno= NodeModel.parse(new File(pathOde +"/" + pathLomesExterno));
				
				Node nodo= modeloExterno.getNode().getChildNodes().item(0);
				NodeModel.simplify(nodo);
				
				NodeList hijos = nodo.getChildNodes();
				for (int i = 0; i < hijos.getLength() && !terminado; i++) {
					Node child = hijos.item(i);
					if (child.getLocalName()!=null && child.getLocalName().equals("general")) {
						
						NodeList hijos2 = child.getChildNodes();
						for (int j = 0; j < hijos2.getLength() && !terminado; j++) {
							Node child2 = hijos2.item(j);
							if (child2.getLocalName()!=null &&  child2.getLocalName().equals("title")) {
								
								
								NodeList hijos3 = child2.getChildNodes();
								for (int k = 0; k < hijos3.getLength() && !terminado; k++) {
									Node child3 = hijos3.item(k);
									if (child3.getLocalName()!=null &&  child3.getLocalName().equals("string")) {
										resultado=child3.getFirstChild().getNodeValue();
										terminado=true;
									}
								}
		
								
							}
						}
						
					}//metadata
				}

			} catch (Exception e) {
				if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:obtenerTitulo .. " + e.getMessage() );}
				throw e;
			}

			
		}
		
		return resultado;
	}
	
	
	/**
	 * genera la cabecera de la presentación... 
	 * 
	 * @param titulo String con el título del ODE
	 * @throws Exception
	 */
	private void generarCabecera(String titulo)
	throws Exception
	{
                if (titulo!=null) {
                    root.put("titulo", titulo);
                } else {
                    root.put("titulo", "");
                }

		
		FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			temp = cfg.getTemplate("cabecera.ftl");
			index= new File(dirDestino + "/contenido/cabecera.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
			
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarCabecera .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	/**
	 * método que permite generar el fichero blanco.html
	 * 
	 * @throws Exception
	 */
	private void generarBlanco(String titulo)
	throws Exception
	{
                if (titulo!=null) {
                    root.put("titulo", titulo);
                } else {
                    root.put("titulo", "");
                }

		FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			temp = cfg.getTemplate("blanco.ftl");
			index= new File(dirDestino + "/contenido/blanco.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarBlanco .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	/**
	 * método que genera el fichero contenido_frame.html
	 * 
	 * @throws Exception
	 */
	private void generarContenidoFrame(String titulo)
	throws Exception
	{

		if (titulo!=null) {
                    root.put("titulo", titulo);
                } else {
                    root.put("titulo", "");
                }


		FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			temp = cfg.getTemplate("contenido_frame.ftl");
			index= new File(dirDestino + "/contenido/contenido_frame.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
		} catch (Exception e) {
			
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarContenidoFrame .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	/**
 	 * método que genera el fichero contenido_index.html
 	 * 
	 * @throws Exception
	 */
	
	private void generarContenidoIndex(String titulo)
	throws Exception
	{

                if (titulo!=null) {
                    root.put("titulo", titulo);
                } else {
                    root.put("titulo", "");
                }

		FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			temp = cfg.getTemplate("contenido_index.ftl");
			index= new File(dirDestino + "/contenido/contenido_index.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
			
		} catch (Exception e) {
			
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarContenidoIndex .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	
	/**
	 * Método para generar fichero menu.html
	 * 
	 * @throws Exception
	 */
	private void generarMenu(String titulo)
	throws Exception
	{

                if (titulo!=null) {
                    root.put("titulo", titulo);
                } else {
                    root.put("titulo", "");
                }


                FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			modelo= NodeModel.parse(new File(pathOde +MANIFEST));
			root.put("doc",modelo);
			
			
			temp = cfg.getTemplate("menuXML.ftl");
			index= new File(dirDestino + "/contenido/menu.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
			
		} catch (Exception e) {
			
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarMenu .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	
	
	/**
	 * método para generar fichero menu.html
	 * 
	 * @param orgs ManifestVO necesario para generar contenido del menu
	 * @throws Exception
	 */
	private void generarMenu(ManifestVO orgs, String titulo)
	throws Exception
	{

                if (titulo!=null) {
                    root.put("titulo", titulo);
                } else {
                    root.put("titulo", "");
                }


		FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			OrganizacionVO[] aOrganizaciones=  orgs.getOrganizaciones();
			List listOrganizaciones = new ArrayList();
			for(int j=0;j<aOrganizaciones.length;j++){
				List listItems = new ArrayList();
				OrganizacionVO organizacion=aOrganizaciones[j];
				Map org = new HashMap();
				if(organizacion!=null){	
					
					org.put("tituloOrg", organizacion.getTituloOrg());
					org.put("idOrg", organizacion.getIdOrg());
					String localizacion = "file:///"+dirDestino + "/contenido";
					org.put("localizacion", localizacion);
					ItemVO[] items = organizacion.getItems();
					for(int i=0;i<items.length;i++){
						Map item = generarItems(items[i]);
						listItems.add(item);
					}
					org.put("itemsOrg", listItems);
					listOrganizaciones.add(org);
				}
			}
			root.put("organizaciones", listOrganizaciones);
			temp = cfg.getTemplate("menuClase.ftl");
			index= new File(dirDestino + "/contenido/menu.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
			
		} catch (Exception e) {
			
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarMenu .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}

	private Map generarItems(ItemVO item)
	throws Exception
	{
		Map mapItem = new HashMap();
		mapItem.put("idItem", item.getIdItem());
		mapItem.put("titulo", item.getTitulo());
		String recurso=null;
		if(item.getRecurso()!=null){
			recurso =item.getRecurso().getHrefRec();
		}	
		mapItem.put("recurso", recurso);
		ItemVO[] itemsHijos=item.getItemHijos();
		if(itemsHijos!=null && itemsHijos.length>0){
			List listItemsHijos = new ArrayList();
			for(int i=0;i<itemsHijos.length;i++){
				Map hijo = generarItems(itemsHijos[i]);
				listItemsHijos.add(hijo);
			}
			mapItem.put("itemsHijos", listItemsHijos);
		}
		else
			mapItem.put("itemsHijos", null);
		return mapItem;
	}
	
	/**
	 * Método público que permite generar fichero de metadatos en carpeta separada.
	 * Comprueba si el fichero manifest tiene un lomes integrado o un metadato externo.
	 * si el ODE no tiene metadatos.. no genera nada
	 * 
	 * @param pathOde path del ODE que se desea exportar
	 * @param dirDestino directorio donde se va a copiar la catalogacion lomes
	 * @param subdirDestino target subdirectory
	 * @throws Exception 
	 */
	public void obtenerLOMES(String pathOde, String dirDestino,
			String subdirDestino, String lomFileName) throws Exception {
		this.pathOde= pathOde;
		this.dirDestino= dirDestino;
		
		crearCarpeta(dirDestino + File.separator + subdirDestino);

		modelo= NodeModel.parse(new File(pathOde +MANIFEST));
		root.put("doc",modelo);

		pathLomesExterno=chequearLomes();
		obtenerLOMES(subdirDestino + File.separator + lomFileName);
	}
	
	
	/**
	 * método que permite generar fichero de metadatos en carpeta separada
	 * comprueba si el fichero manifest tiene un lomes integrado o un metadato externo.
	 * si el ODE no tiene metadatos.. no genera nada
	 *
	 */
	private void obtenerLOMES(String lomFileName)
	throws Exception
	{
		FileOutputStream fo=null;
		FileInputStream fin=null;
		Writer out=null;
		File lomes=null;
		Template template;
		try {
			if(pathLomesExterno!=null)
			{
				lomes= new File(dirDestino + File.separator + lomFileName);
				if(!lomes.exists())
					lomes.createNewFile();
			}
					
					
					
			if(pathLomesExterno!=null && pathLomesExterno.equals(""))
			{
				// tiene lomes y no es un fichero externo adlcp:location
				template = cfg.getTemplate("lomes.ftl");
				cfg.setDefaultEncoding("UTF-8");
				fo= new FileOutputStream(lomes);
				out = new OutputStreamWriter(fo,"UTF-8");
				Environment env = template.createProcessingEnvironment(root, out);
				env.setOutputEncoding("UTF-8");
				env.process(); 

				out.flush();
				
			}else if(pathLomesExterno!=null && !pathLomesExterno.equals(""))
			{// fichero externo.. por lo que solamente lo copio al destino
				File origen = new File(pathOde + "/" + pathLomesExterno);
				fin = new FileInputStream(origen);
				fo = new FileOutputStream (lomes);
				int c;
				while ((c = fin.read()) >= 0)
				{
					fo.write(c);
				}
				fin.close();
				fo.close();
				origen=null;

			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:obtenerLOMES .. " + e.getMessage() );}
			throw e;
		}finally{
			lomes=null;
			if(fo!=null)
			{
				try {
					fo.close();
				} catch (IOException e) {}
			}
			if(fin!=null)
			{
				try {
					fin.close();
				} catch (IOException e) {}
			}
			
		}
	}
	
	
	
	/**
	 * método que permite verificar si el ODE tiene metadatos.. ya sea integrados en el manifest
	 * o externos al mismo.
	 * 
	 * 
	 * 
	 * @return String con tres posibles valores
	 * <ul>
	 * 	<li>null  . - si el ODE no tiene metadatos</li>
	 * 	<li>vacio . - si el ODE tiene metadatos integrados en el manifest</li>
	 *  <li>path al metadato. - si el ODE tiene metadatos externos que sean lomes validos</li>
	 * </ul
	 */
	private String chequearLomes()
	throws Exception
	{
		String resultado=null;
		List listaLomes= new ArrayList();
		
		
		Node nodo= modelo.getNode().getChildNodes().item(0);
		NodeModel.simplify(nodo);
		boolean terminado= false;
		
		NodeList hijos = nodo.getChildNodes();
		for (int i = 0; i < hijos.getLength() && !terminado; i++) {
			Node child = hijos.item(i);
			if (child.getLocalName()!=null &&  child.getLocalName().equals("metadata")) {
				NodeList hijos2 = child.getChildNodes();
				for (int j = 0; j < hijos2.getLength()  && !terminado; j++) {
					Node child2 = hijos2.item(j);
					if (child2.getLocalName()!=null && child2.getLocalName().equals("lom")) {
						resultado="";
						terminado=true;
					}
					if(child2.getLocalName()!=null && child2.getLocalName().equals("location"))
					{
						listaLomes.add(child2.getFirstChild().getNodeValue());
					}
				}
				
			}//metadata
		}
		
		
		if(resultado==null && listaLomes.size()>0)
		{// busco en la lista de nodos externos al primero que sea lomes 
			boolean encontrado=false;			
			for (Iterator iter = listaLomes.iterator() ; iter.hasNext() && !encontrado ;) 
			{
				String path=(String) iter.next();
				if(chequearTipoLomesExterno(path))
				{
					resultado=path;
					encontrado=true;
				}
				
			}
		}
		
		
		return resultado;
	}

	
	/**
	 * metodo que permite verificar si un fichero lomes externo es un fichero lomes
	 * 
	 * @param lomesExterno path al fichero xml con los metadatos
	 * @return 
	 * 	<ul>
	 * 		<li>true .- si es un lomes </li>
	 * 		<li>false.- si no es un lomes</li>
	 *  </ul>
	 */
	private boolean chequearTipoLomesExterno(String lomesExterno)
	throws Exception
	{
		boolean resultado= false;

		NodeModel modeloExterno=null;
		try {
			modeloExterno= NodeModel.parse(new File(pathOde +"/" + lomesExterno));
			Node nodo= modeloExterno.getNode().getChildNodes().item(0);
			if(nodo!=null && nodo.getNamespaceURI()!=null && nodo.getNamespaceURI().equals("http://ltsc.ieee.org/xsd/LOM"))
			{
				resultado=true;
			}
			
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:chequearTipoLomesExterno .. problemas al leer fichero lomes externo: " + e.getMessage());}
			throw e;
		}
		return resultado;
	}
	
	
	
	
	
	
	/**
	 * método que permite generar fichero index.html
	 * 
	 * @throws Exception
	 */
	private void generarIndex(String titulo)
	throws Exception
	{
		FileOutputStream fo=null;
		Writer out=null;
		File index=null;
		Template temp;
		try {
			temp = cfg.getTemplate("index.ftl");
			index= new File(dirDestino + "/index.html");
			boolean creado= index.createNewFile();
			if(creado)
			{
				fo= new FileOutputStream(index);
				out = new OutputStreamWriter(fo);
				temp.process(root, out);
				out.flush();  
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en GeneradorHTML:generarIndex .. " + e.getMessage() );}
			throw  e;
		}finally{
			index=null;
			if(fo!=null)
			{
				try {
					fo.close();
					out.close();
				} catch (IOException e) {}
			}
		}
	}
	
	private void crearCarpeta(String path)
	{
		File carpeta= new File(path );
		if(!carpeta.exists())
		{
			carpeta.mkdirs();
		}
		
	}
}
