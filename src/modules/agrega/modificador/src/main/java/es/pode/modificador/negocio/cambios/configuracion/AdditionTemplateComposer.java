/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios.configuracion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import org.apache.log4j.Logger;

import es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosServiceServiceLocator;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;

public class AdditionTemplateComposer {

	private ModificadorProperties properties=null;
	
	private final static String LOAD = "load\\:";
	private final static String VOCAB = "vocab";
	private final static String TEMPLATE_PREFIX = "template\\.";
	private final static String TEMPLATE_SUFIX = "\\.xml";
	public final static String TEMPLATE_FILE_PREFIX = "template.";
	public final static String TEMPLATE_FILE_SUFIX = ".xml";
	private final static String TEMPLATE_PATH = "/plantillas";
	private final static String TEXTO_OPCIONES = "opciones : ";
	// Para obtener los combos, uso siempre el ingles. No realizo traducciones
	private final static String DEFAULT_LANGUAGE = "en";
	
	private final static Logger logger = Logger.getLogger(AdditionTemplateComposer.class);
	
	private static HashMap cargados = new HashMap(20);
	
	/**
	 * Obtiene una plantilla para la creacion de un nuevo termino a añadir. Si
	 * el término tiene elementos con valores controlados, se accede al servicio
	 * de fuentes taxonómicas para recuperar las opciones disponibles para ese
	 * término.
	 * 
	 * @param template
	 * @return
	 */
	public String getTemplate(String template, final String parent) {
		String result = null;
		// Recupero la plantilla
		if(cargados.containsKey(template)) result = cargados.get(template).toString();
		else {
			try {
				String content = leerFichero(template);
				if(logger.isDebugEnabled()) logger.debug("Contenido bruto del fichero : " + content);
				if(content!=null) {
					// Procesar el fichero recuperado para hacer las sustituciones de las cadenas ${...}
					result = procesarPlantilla(content,parent);
					// Es posible que si han pedido un termino final, quede la cadena ${vocab} sin reemplazar
					if(result.indexOf("${vocab}")>-1) result = replaceVocab(result, template, parent);
					// Cachear en hashmap para proximos usos
					cargados.put(template, result);
				}
			} catch (Exception e) {
				logger.error("Error durante la recuperacion de la plantilla " + template);
				if(logger.isDebugEnabled()) logger.debug(e);
			}
		}
		return result;
	}

	private String procesarPlantilla(final String source, final String parent) {
		String result = null;
		// Busca sustituciones load:
		StringBuffer sb = new StringBuffer(source);
		int first = -1;
		int last = -1; 
		do {
			first = sb.indexOf("${load:");
			last = sb.indexOf("}");
			if(first >-1 && last>first) {
				// Encontrada secuencia de sustitucion
				String subTemplate = sb.substring(first+ 7, last);
				if(logger.isDebugEnabled()) logger.debug("Cargando plantilla " + subTemplate);
				String subContent = getTemplate(subTemplate, parent);
				// Comprobar vocab
				if(subContent.indexOf("${vocab}")>-1) subContent = replaceVocab(subContent, subTemplate, parent);
				// Sustituir
				sb.replace(first, last+1, subContent);
			}
		} while (first >-1 && last>first);
		if(sb.length()>0) result = sb.toString();
		return result;
	}
	
	/**
	 * @param content
	 * @return
	 */
	private String replaceVocab(String content,final String subTemplate, final String parent) {
		String result=content;
		String id = parent!=null?parent:subTemplate.replaceAll(TEMPLATE_PREFIX, "").replaceAll(TEMPLATE_SUFIX, "");
		if(logger.isDebugEnabled()) logger.debug("Obtenido id para consulta de combos " + id + " a partir de " + subTemplate);
		try {
			SrvVocabulariosControladosService service = (new SrvVocabulariosControladosServiceServiceLocator()).getSrvVocabulariosControladosService();
			if(service!=null) {
				VocabularioVO[] voc = service.obtenerCombos(new String[]{id}, DEFAULT_LANGUAGE);
				if(voc!=null && voc.length>0) {
					TerminoVO[] terms = voc[0].getTerminos();
					StringBuffer sb = new StringBuffer("opciones : ");
					for(int i=0;i<terms.length;i++) {
						sb.append(terms[i].getNomTermino());
						if(i<terms.length-1)sb.append(" | ");
					}
					result = content.replaceAll("\\$\\{vocab\\}", sb.toString());
				}
			} else {
				logger.error("No se pudo recuperar el valor de los combos para id " + id);
			}
		} catch (Exception e) {
			logger.error("No se pudo recuperar el valor de los combos para id " + id);
			if(logger.isDebugEnabled()) logger.debug(e);
		}
		return result;
	}
	
	private String leerFichero(String fichero) throws Exception {
		String result =null;
		
		URL url = this.getClass().getResource(TEMPLATE_PATH+"/"+fichero);
		if(logger.isDebugEnabled()) logger.debug("El fichero " + fichero + " tiene java.net.URL=" + url);
		if(url!=null) {
			StringBuffer sb = new StringBuffer();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String line = null;
				while ((line = reader.readLine())!=null) {
					if(sb.length()>0) sb.append("\n");
					sb.append(line);
				}
				if(logger.isDebugEnabled()) logger.debug(fichero + " recuperado: \n" + sb.toString());
			result = (sb.length()>0?sb.toString():null);
		}
		if(logger.isDebugEnabled()) logger.debug("Resultado de leer " + fichero + " = " + result);
		return result;
	}
	
	
	/**
	 * @return the properties
	 */
	public ModificadorProperties getProperties() {
		return properties;
	}


	/**
	 * @param properties the properties to set
	 */
	public void setProperties(ModificadorProperties properties) {
		this.properties = properties;
	}
	
	public static void  main(String [] args0) {
		String result = (new AdditionTemplateComposer()).getTemplate("template.2.xml",null);
		System.out.println(result);
		
	}
}
