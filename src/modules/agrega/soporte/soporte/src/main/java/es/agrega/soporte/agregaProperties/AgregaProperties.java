/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.agregaProperties;

public interface AgregaProperties 
{
	public static final String PROPERTIES_FILE_NAME = "agrega"; 
	
	public static final String PROPERTY_IMAGE_SERVER_IP 	= "galeriaimg.server.ip";
	public static final String PROPERTY_IMAGE_SERVCIE_URL 	= "galeriaimg.service.url";
	public static final String PROPERTY_IMAGE_APACHE_PATH 	= "galeriaimg.path.image";
	public static final String PROPERTY_IMAGE_COMMON_PATH 	= "galeriaimg.common.image";
	public static final String PROPERTY_IMAGE_EXTENSION 	= "galeriaimg.image.ext";
	public static final String PROPERTY_IMAGE_COMMON_EXTENSION 	= "galeriaimg.image.common.ext";
	public static final String PROPERTY_IMAGE_COMMON_EXTENSION_FOTOGRAFIABLE 	= "galeriaimg.image.common.ext.fot";
	public static final String PROPERTY_ZONA_HORARIA		= "zona_horaria";
	public static final String PROPERTY_IMAGE_COMMON_LOCAL_PATH="galeriaimg.image.common.path";
	public static final String PROPERTY_IMAGE_DEFECTO		=	"pathImagenDefectoGrande";
	
	public static final String CATALOGO_AGREGA				= "catalogo.agrega";
	public static final String CATALOGO_MEC					= "catalogo.mec";
	public static final String URL_IMAGEN_DEFECTO			= "urlImagenDefecto";
	public static final String URL_IMAGEN_DINAMICA_DEFECTO  = "urlImagenDinamicaDefecto";
	public static final String URL_IMAGEN_DEFECTO_GRANDE	= "urlImagenDefectoGrande";
	public static final String URL_IMAGEN_DEFECTO_100x100	= "urlImagenDefecto100x100";
	public static final String URL_IMAGEN_DINAMICA_DISCO	= "urlImagenDinamicaDisco";
	public static final String PATH_IMAGEN_DINAMICA_DISCO	= "pathImagenDinamicaDisco";
	public static final String URL_REPOSITORIO_AGREGA		= "urlRepositorio";
	public static final String NOMBRE_REPOSITORIO			= "nombreRepositorio";
	public static final String EMAIL_ADMIN_REPOSITORIO		= "emailAdmin";
	public static final String TIMEOUT_EXTENDIDO			= "timeout.extendido";
	public static final String ESQUEMA_LOMES				= "esquemaDeMetadatos";
	public static final String HOST							= "host";
	public static final String ROL_ADMINISTRADOR			= "rol_administrador";
	public static final String ROL_PUBLICADOR				= "rol_publicador";
	public static final String ROL_CATALOGADOR				= "rol_catalogador";
	public static final String ROL_EMPAQUETADOR				= "rol_empaquetador";
	public static final String CONTACTO_MAIL				= "contacto_mail";
	public static final String CONTACTO_TELEFONO			= "contacto_telefono";
	public static final String CONTACTO_INCIDENCIAS_ACTIVAR	= "contacto_incidencias_activar";
	public static final String NEUTRO						= "neutro";
	public static final String URL_LOGO_AGREGA				= "urlLogoAgrega";
	public static final String PATH_INFORMES_FEDERADOS		= "destinoInformesFederadosDir";
	public static final String PATH_INFORMES				= "destinoInformesDir";
	public static final String PATH_INFORMES_MAS			= "destinoInformesMasDir";
	public static final String REGISTRO_CAS					= "registroCas";
	public static final String USAPROXY						= "usaProxy";
	public static final String HOSTPROXY					= "hostProxy";
	public static final String PORTPROXY					= "portProxy";
	public static final String USUARIOPROXY					= "usuarioProxy";
	public static final String CLAVEPROXY					= "claveProxy";
	public static final String TIMEOUTCOOKIEOPENID			= "timeoutCookieOpenId";
	public static final String VALOR_CUOTA_DEFECTO			= "valorCuotaDefecto";


	public String getProperty(String sKey);

}
