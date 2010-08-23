/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.sitemapProperties;

public interface SitemapProperties 
{
	public static final String PROPERTIES_FILE_NAME = "generacionContenidos"; 

	
	public static final String PERIODICIDAD 									= "periodicidad";
	
	public static final String NUMERO_ENTRADAS_XML 								= "numeroEntradas";
	
	public static final String NOMBRE_FICHERO_SITEMAP 							= "ficheroSiteMap";
	public static final String NOMBRE_FICHERO_SITEMAP_INDEX 					= "ficheroSiteMapIndex";
	public static final String EXTENSION_FICHEROS_SITEMAP 						= "extensionFicheroSiteMap";
	
	public static final String ESQUEMA_SITEMAP									= "schemaSitemap";
	public static final String ESQUEMA_SITEMAP_XSI								= "schemaSitemapXsi";
	public static final String ESQUEMA_SITEMAP_LOCATION							= "schemaSitemapLocation";
	 
	public static final String DIRECTORIO_FICHEROS_SITEMAP						= "urlSiteMap";
	public static final String DIRECTORIO_FICHEROS_BACKUP_SITEMAP				= "urlSiteMapBackup";
	public static final String DIRECTORIO_FICHEROS_SITEMAP_PORTADA				= "urlSiteMapPortada";
	
	public static final String PROTOCOLO_HTTP									= "protocoloHttp";
	public static final String URL_FICHA_ODE									= "buscadorFicha";
	public static final String SEPARADOR										= "separador";
		
	public static final String NIVEL_AGREGACION_1								= "1";
	public static final String NIVEL_AGREGACION_2								= "2";
	public static final String NIVEL_AGREGACION_3								= "3";
	public static final String NIVEL_AGREGACION_4								= "4";
	
	public static final String HORATAREA 										= "horaTarea";
	public static final String MINUTOTAREA 										= "minutoTarea";
	public static final String SEGUNDOTAREA 									= "segundoTarea";
	
	public static final String HORATAREAODE 									= "horaTareaOde";
	public static final String MINUTOTAREAODE									= "minutoTareaOde";
	public static final String SEGUNDOTAREAODE									= "segundoTareaOde";
	public static final String PERIODICIDADODE									= "periocidadOdePortada";
	public static final String PERIODICIDADTAREA								= "periodicidadTarea";
	
	public static final String ESQUEMA_SITEMAP_INDEX							= "schemaSitemapIndex";
	public static final String ESQUEMA_SITEMAP_XSI_INDEX						= "schemaSitemapIndexXsi";
	public static final String ESQUEMA_SITEMAP_LOCATION_INDEX					= "schemaSitemapIndexLocation";
	
	
	
	
	
	
	public String getProperty(String sKey);
	
	

}
