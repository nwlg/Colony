/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import es.pode.soporte.constantes.ConstantesAgrega;

public class I18n {

	
	private static HashMap mapaIdiomas = new HashMap(); // mapa que alberga los bunlde para cada idioma.
										// se accede al property por idioma
	private static Logger logger = Logger.getLogger(I18n.class);
	private static final String ficheroProps = "/i18n.properties";
	private static Properties props = null;
	private static ResourceBundle theResourceBundle = null;
	private static I18n i18n = null;
	private HashSet setIdiomasSoportados = null;  //Conjunto de idiomas soportados por la plataforma
	/*
	 * Obtiene un resoruce bundle para el idioma dado. Si no esta cargado lo carga. Si no existe devuelve null;
	 * */
	private ResourceBundle getBundleFile(String idioma)
	{
		ResourceBundle fichero = null;
		if ((fichero = (ResourceBundle)mapaIdiomas.get(idioma)) == null)  // si no existe, lo intentamos cargar
			fichero = addBundleFile(idioma);
		return fichero;
	}
	
	/*
	 * Añade un bundle para ese idioma a la coleccion de bundles y lo devuelve
	 * */
	private ResourceBundle addBundleFile(String idioma)
	{
		// Chequeamos que exista el fichero de bundle para el idioma dado.
		// Si no existe el fichero de properties para el idioma, no lo añadimos
		ResourceBundle fichero = null;
		try {
			fichero = ResourceBundle.getBundle("i18n", new Locale(idioma));
		} catch (RuntimeException e) {
			// No existe un resource bundle para un idioma dado
			logger.warn("Excepcion intentando buscar el fichero de bundle para el idioma["+idioma+"]["+e.getCause()+"]");
			return null;
		}
		if (fichero == null)
			return fichero;
		
		mapaIdiomas.put(idioma, fichero);
		return fichero;
	}
	/**
	 * Este metodo traduce la etiqueta que le pasan al idioma que se le suministra
	 * @param etiqueta tag que se quiere traducir
	 * @param idioma codigo de idioma ISO-639 en el que se quiere obtener la traduccion
	 * @return
	 */
	public String traduceEtiqueta(String etiqueta, String idioma)
	{
		
		ResourceBundle fichero = getBundleFile(idioma);
		if (fichero != null)
			return fichero.getString(etiqueta);
		else
			return "";
	}
	
	/**
	 * @param String idioma a localizar
	 * @return LocalizacionIdiomaVO[] Devuelve la lista de los idiomas buscables localizados al idioma que se le pasa.
	 */
	public LocalizacionIdiomaVO[] obtenerIdiomasBuscablesLocalizados(String idioma) throws Exception {
//		Comprobamos que existe el fichero de bundle del idioma al que se quiere traducir.
		ResourceBundle fichero = getBundleFile(idioma);
		if (idioma == null) {
			logger.error("ERROR: idioma no encontrado: [" + idioma + "]");
			throw new Exception("Excepcion: obtenerIdiomasBuscablesLocalizados: Idioma["+idioma+"] sin fichero de localizacion registrado.");
		}
		
//		Obtenemos la lista de los idiomas del fichero de properties del propio i18n
		String idiomas = getPropertyValue(ConstantesAgrega.LISTA_IDIOMAS_BUSCABLES);
		String[] listaIdiomasBuscables = (idiomas!= null)?idiomas.split(","):null;
//		Para cada idioma voy buscando en el fichero de bundle su correspondiente traduccion y genero el vo
		LocalizacionIdiomaVO[] retorno = new LocalizacionIdiomaVO[(listaIdiomasBuscables!=null)?listaIdiomasBuscables.length:0]; 
		for (int i = 0; listaIdiomasBuscables!= null &&  i < listaIdiomasBuscables.length; i++) {
//			Planteamos la traduccion del codigo de idioma contra el fichero de bundle con las palabras localizadas al idioma adecuado.
			LocalizacionIdiomaVO item = new LocalizacionIdiomaVO( fichero.getString(listaIdiomasBuscables[i]),
					listaIdiomasBuscables[i]);
			retorno[i] = item;
		}
		return retorno;
	}
	
	
	/**
	 * @return String[] Devuelve la lista de los idiomas buscables en la plataforma
	 * @throws Exception 
	 */
	public String[] obtenerIdiomasBuscables() throws Exception {
		
//		Obtenemos la lista de los idiomas del fichero de properties del propio i18n
		String idiomas = getPropertyValue(ConstantesAgrega.LISTA_IDIOMAS_BUSCABLES);
		if (idiomas == null || idiomas.length()==0) {
			logger.error("ERROR: idiomas no encontrados: [" + idiomas+ "]");
			throw new Exception("Excepcion: obtenerIdiomasBuscables: No se han encontrado los idiomas en el fichero de propiedades");
		}
		String[] listaIdiomasBuscables = (idiomas!= null)?idiomas.split(","):null;
		return listaIdiomasBuscables;
	}
	
	/**
	 * @param String idioma a localizar
	 * @return LocalizacionIdiomaVO[] Devuelve la lista de los idiomas de la plataforma localizados al idioma que se le pasa.
	 */
	public LocalizacionIdiomaVO[] obtenerIdiomasPlataformaLocalizados(String idioma) throws Exception {
//		Comprobamos que existe el fichero de bundle del idioma al que se quiere traducir.
		ResourceBundle fichero = getBundleFile(idioma);
		if (idioma == null) {
			logger.error("ERROR: idioma no encontrado: [" + idioma + "]");
			throw new Exception("Excepcion: obtenerIdiomasPlataformaLocalizados: Idioma["+idioma+"] sin fichero de localizacion registrado.");
		}
		
//		Obtenemos la lista de los idiomas del fichero de properties del propio i18n
		String idiomas = getPropertyValue(ConstantesAgrega.LISTA_IDIOMAS_PLATAFORMA);
		String[] listaIdiomasPlataforma = (idiomas!= null)?idiomas.split(","):null;
//		Para cada idioma voy buscando en el fichero de bundle su correspondiente traduccion y genero el vo
		LocalizacionIdiomaVO[] retorno = new LocalizacionIdiomaVO[(listaIdiomasPlataforma!=null)?listaIdiomasPlataforma.length:0]; 
		for (int i = 0; listaIdiomasPlataforma!= null &&  i < listaIdiomasPlataforma.length; i++) {
//			Planteamos la traduccion del codigo de idioma contra el fichero de bundle con las palabras localizadas al idioma adecuado.
			LocalizacionIdiomaVO item = new LocalizacionIdiomaVO( fichero.getString(listaIdiomasPlataforma[i]),
					listaIdiomasPlataforma[i]);
			retorno[i] = item;
		}
		return retorno;
	}
	/**
	 * @param String idioma a localizar
	 * @return Stirng[] Devuelve la lista de los idiomas para los que la plataforma esta traducida.
	 */
	public String[] obtenerIdiomasPlataforma() throws Exception {
//		Obtenemos la lista de los idiomas del fichero de properties del propio i18n
		String idiomas = getPropertyValue(ConstantesAgrega.LISTA_IDIOMAS_PLATAFORMA);
		if (idiomas != null && idiomas.length() > 0)
			return idiomas.split(",");
		else
			return null;
	}
	
	/**
	 * @param String idioma a localizar
	 * @return Stirng Devuelve el idioma por defecto en el que se traduce la plataforma.
	 */
	public String obtenerIdiomaDefectoPlataforma() throws Exception {
//		Obtenemos el idioma por defecto de la plataforma
		return getPropertyValue(ConstantesAgrega.IDIOMA_DEFECTO_PLATAFORMA);
	}
	
	/**
	 * @param String idioma a localizar
	 * @return Stirng Devuelve el idioma secundario en el que se traduce la plataforma.
	 */
	public String obtenerIdiomaSecundarioPlataforma() throws Exception {
//		Obtenemos el idioma secundario de la plataforma
		return getPropertyValue(ConstantesAgrega.IDIOMA_SECUNDARIO_PLATAFORMA);
	}
	
	/**
	 * @param String idioma a identificar
	 * @return Boolean Devuelve un booleano indicando si el idioma de navegacion que se le pasa esta entre los soportados por la plataforma.
	 */
	public Boolean idiomaSoportadoPorPlataforma(String idiomaNavegacion) throws Exception {
		
		if (setIdiomasSoportados == null) // relleno los idiomas soportados por la plataforma si no lo estaban ya
		{
			String[] idiomas = I18n.getInstance().obtenerIdiomasPlataforma();
			setIdiomasSoportados =new HashSet(Arrays.asList(idiomas));
		}
//		devuelvo si el idioma de navegacion del tipo esta entre los que reconozco
		return new Boolean(setIdiomasSoportados.contains(idiomaNavegacion)); 
	}
	
	/**
	 * @param String idiomaTraducir Idioma que se va a traducir
	 * @param String idiomaTraduccion Idioma al que se quiere traducir.
	 * @return String el idioma a traducir traducido al idioma de traduccion.
	 */
	public String obtenerIdiomaTraducido(String idiomaTraducir, String idiomaTraduccion) throws Exception
	{
//		idiomas.traducibles;	
		if (idiomaTraduccion == null || idiomaTraduccion.equals("")) {
			logger.error("ERROR: idioma de traduccion vacio: [" + idiomaTraduccion + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma de traduccion ["+idiomaTraduccion+"] vacio.");
		}
		if (idiomaTraducir == null || idiomaTraducir.equals("")) {
			logger.error("ERROR: idioma a traducir vacio: [" + idiomaTraducir + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma a traducir ["+idiomaTraduccion+"] vacio.");
		} 
//		Obtengo la lista de idiomas de los que tengo traduccion
		String idiomasTraducibles = getPropertyValue(ConstantesAgrega.LISTA_IDIOMAS_TRADUCIBLES);
		String[] arrayIdiomasPlataforma = (idiomasTraducibles!= null)?idiomasTraducibles.split(","):null;
		ArrayList listaIdiomasPlataforma = new ArrayList(Arrays.asList(arrayIdiomasPlataforma));
		if (!listaIdiomasPlataforma.contains(idiomaTraducir))
		{
			logger.error("ERROR: idioma a traducir ["+idiomaTraducir+"]no encontrado en la lista: [" + listaIdiomasPlataforma.toString() + "] de idiomas traducibles.");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma["+idiomaTraducir+"] sin traduccion posible.");			
		}
//		Comprobamos que existe el fichero de bundle del idioma al que se quiere traducir.
		ResourceBundle fichero = getBundleFile(idiomaTraduccion);
		if (fichero == null)
		{
			logger.error("ERROR: idioma de traduccion no encontrado: [" + idiomaTraduccion + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma["+idiomaTraduccion+"] sin fichero de localizacion registrado.");		
		}	
		String idioma = "";
		if ((idioma = fichero.getString(idiomaTraducir))!= null)
			return idioma;
		else
			return idioma;
	}
	
	/**
	 * @param String[] idiomasTraducir Idiomas que se van a traducir
	 * @param String idiomaTraduccion Idioma al que se quiere traducir.
	 * @return String[] idiomas Los idiomas a traducir traducidos al idioma de traduccion.
	 */
	public String[] obtenerIdiomaTraducido(String[] idiomaTraducir, String idiomaTraduccion) throws Exception
	{
//		idiomas.traducibles;	
		if (idiomaTraduccion == null || idiomaTraduccion.equals("")) {
			logger.error("ERROR: idioma de traduccion vacio: [" + idiomaTraduccion + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma de traduccion ["+idiomaTraduccion+"] vacio.");
		}
		if (idiomaTraducir == null || idiomaTraducir.length == 0) {
			logger.error("ERROR: idiomas a traducir vacio.");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idiomas a traducir vacio.");
		} 
//		Delego en el metodo atomico el averiguar si hay o no traduccion, me limito a llamarlo n veces, como idiomas a traducir haya
		ArrayList idiomasTraducidos = new ArrayList();
		String traduccion = "";
		for (int i = 0; i < idiomaTraducir.length; i++) {
			try {
				traduccion = obtenerIdiomaTraducido(idiomaTraducir[i], idiomaTraduccion);
				idiomasTraducidos.add(traduccion);
			} catch (Exception e) {
//				Hemos tenido un error traduciendo, lo capturamos y no añadimos la traduccion al array
				logger.warn("ERROR: Idioma a traducir["+idiomaTraducir[i]+"] si traduccion para el idioma["+idiomaTraduccion+"]. Continuamos con el resto.", e);
			}
		}
		return (String[])idiomasTraducidos.toArray(new String[0]);
	}
	
	public String obtenerIdiomaIso(String idiomaTraducir, String idiomaTraduccion) throws Exception
	{
//		idiomas.traducibles;	
		if (idiomaTraduccion == null || idiomaTraduccion.equals("")) {
			logger.error("ERROR: idioma de traduccion vacio: [" + idiomaTraduccion + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma de traduccion ["+idiomaTraduccion+"] vacio.");
		}
		if (idiomaTraducir == null || idiomaTraducir.equals("")) {
			logger.error("ERROR: idioma a traducir vacio: [" + idiomaTraducir + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma a traducir ["+idiomaTraduccion+"] vacio.");
		} 

//		Comprobamos que existe el fichero de bundle del idioma al que se quiere traducir.
		ResourceBundle fichero = getBundleFile(idiomaTraduccion);
		if (fichero == null)
		{
			logger.error("ERROR: idioma de traduccion no encontrado: [" + idiomaTraduccion + "]");
			throw new Exception("Excepcion: obtenerIdiomaTraducido: Idioma["+idiomaTraduccion+"] sin fichero de localizacion registrado.");		
		}	
		String idioma = "";
		if ((idioma = fichero.getString(idiomaTraducir))!= null)
			return idioma;
		else
			return idioma;
	}
	
	private static String getPropertyValue(String sKey) 
	{
		String sReturn=new String();
		try {
			if (props == null)
			{
				InputStream fIsSpringProperties = I18n.class.getResourceAsStream(ficheroProps);
				props = new java.util.Properties();
				props.load(fIsSpringProperties);
			}
			sReturn = props.getProperty(sKey);
		} catch (IOException e) {
			logger.warn("Excepcion intentando obtener propiedad ["+sKey+"] del fichero de propiedades del i18n["+e.getMessage()+"]");
		}		
		// devolvemos la propiedad
		return sReturn;
	}
	
	public String getResource(String key, String baseName, Locale locale){
        String recurso = "";
        ResourceBundle theResourceBundle = getResource(baseName,locale);
        try{
        	if (theResourceBundle!=null){
               recurso = theResourceBundle.getString(key);
           }
        }catch (MissingResourceException mre){
        	recurso = key;
        }
        return recurso;
    }
	
	public ResourceBundle getResource(String baseName, Locale locale){
        try{
        	return ResourceBundle.getBundle(baseName,locale);
        }catch (MissingResourceException mre){
        	try{
            	return ResourceBundle.getBundle(baseName,new Locale(getPropertyValue(ConstantesAgrega.IDIOMA_DEFECTO_PLATAFORMA)));
                
            }catch (MissingResourceException mr){
        		locale = new Locale("","");
        		return ResourceBundle.getBundle(baseName,locale);
            }
             
        }
    }
	
	public static I18n getInstance()
	{
		if (i18n == null)
			i18n = new I18n();
		return i18n;
	}
	
}
