/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.oaipmh.soporte;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;


public class OAIPMHProperties {

	private static final String oaiConfigFile = "/oaiPmh.properties";
	private static Properties props;
	private static Logger logger = Logger.getLogger(OAIPMHProperties.class);
	
//	Valores de las keys del fichero de propiedades
	
	public static final String KEY_SOPORTA_CONJUNTOS 			= "soportaConjuntos";
	public static final String KEY_GRANULARIDAD					= "granularidad";
	public static final String KEY_GRANULARIDAD_FORMATER		= "granularidadFormater";
	public static final String KEY_NOMBRE_REPOSITORIO			= "nombreRepositorio";
	public static final String KEY_URL_REPOSITORIO				= "urlRepositorio";
	public static final String KEY_VERSION_PROTOCOLO			= "versionProtocolo";
	public static final String KEY_POLITICA_BORRADO				= "politicaBorrado";
	public static final String KEY_EMAIL_ADMIN					= "emailAdmin";
	public static final String KEY_ESQUEMAS_METADATOS			= "metadatoSquema";
	public static final String KEY_METADATOS 					= "metadatoPrefijo";
	public static final String KEY_NAMESPACE_METADATOS 			= "metadatoNamespace";
	public static final String KEY_EJEMPLO_IDENTIFIER_OAI		= "ejemploIdentificadorOai";
	private static final String KEY_SCHEME_IDENTIFIER 			= "esquemaIdentificador";
	private static final String KEY_NAMESPACE_IDENTIFIER		= "namespaceIdentificador";	
	
//	Valores para soportar los conjuntos
	public static final String VALUE_SOPORTA_CONJUNTOS_VALUE_SI = "si";
	public static final String VALUE_SOPORTA_CONJUNTOS_VALUE_NO = "no";
//	Lista de prefijos de metadatos soportados
	public static final String VALUE_METADATO_DC				= "oai_dc";
//	Granularidades de tiempo soportadas
	public static final String VALUE_GRANULARIDAD_YYYYMMDD		= "granularidad";
	public static final String VALUE_GRANULARIDAD_YYYYMMDDHHMMSSZ= "YYYY-MM-DDThh:mm:ssZ";
//	Valores de borrado posibles
	public static final String VALUE_DELETE_POLICY_NO			= "no";
	public static final String VALUE_DELETE_POLICY_PERSISTENT	= "persistent";
	public static final String VALUE_DELETE_POLICY_TRANSIENT	= "transient";
//	Valores de generacion de identificadores
	private static String VALUE_SCHEME_IDENTIFIER;
	private static String VALUE_NAMESPACE_IDENTIFIER;
	
	
//	Lista de verbos
	public static final String VERB_GET_RECORD 					= "GetRecord";
	public static final String VERB_IDENTIFY 					= "Identify";
	public static final String VERB_LIST_IDENTIFIERS 			= "ListIdentifiers";
	public static final String VERB_LIST_METADATA_FORMATS 		= "ListMetadataFormats";
	public static final String VERB_LIST_RECORDS 				= "ListRecords";
	public static final String VERB_LIST_SETS					= "ListSets";
//	Lista de errores
	public static final String ERR_CAN_NOT_DISEMINATE_FORMAT 	= "cannotDisseminateFormat";
	public static final String ERR_ID_DOES_NOT_EXIST 			= "idDoesNotExist";
	public static final String ERR_BAD_ARGUMENT 				= "badArgument";
	public static final String ERR_BAD_VERB 					= "badVerb";
	public static final String ERR_NO_METADATA_FORMATS 			= "noMetadataFormats";
	public static final String ERR_NO_RECORDS_MATCH 			= "noRecordsMatch";
	public static final String ERR_BAD_RESUMPTION_TOK 			= "badResumptionToken";
	public static final String ERR_NO_SET_HIERARCHY 			= "noSetHierarchy";
	public static final String ERR_ERROR_GENERICO 				= "ERROR";	
	
// Descripción de los errores
	public static final String ERR_CAN_NOT_DISEMINATE_FORMAT_DES 	= "Tipo de metadato no soportado en la plataforma";
	public static final String ERR_ID_DOES_NOT_EXIST_DES			= "El identificador no existe en la plataforma";
	public static final String ERR_BAD_ARGUMENT_DES 				= "La llamada incluye un parámetro incorrecto o no incluye un argumento obligatorio";
	public static final String ERR_BAD_VERB_DES						= "El argumento verb es incorrecto";
	public static final String ERR_NO_METADATA_FORMATS_DES 			= "No existe tipos de metadatos disponibles para el item";
	public static final String ERR_NO_RECORDS_MATCH_DES 			= "No existen registros en la plataforma";
	public static final String ERR_BAD_RESUMPTION_TOK_DES 			= "El resumptionToken es incorrecto";
	public static final String ERR_NO_SET_HIERARCHY_DES 			= "La plataforma no soporta conjuntos";
	public static final String ERR_ERROR_GENERICO_DES 				= "Error";	
	public static final String ERR_SEVERAL_IDENTIFIER_DES			= "El argumento identifier esta repetido";
	public static final String ERR_SEVERAL_METADATAPREFIX_DES		= "El argumento metadataPrefix esta repetido";
	public static final String ERR_SEVERAL_FROM_DES					= "El argumento from esta repetido";
	public static final String ERR_SEVERAL_UNTIL_DES				= "El argumento until esta repetido";
	public static final String ERR_SEVERAL_SET_DES					= "El argumento set esta repetido";
	public static final String ERR_SEVERAL_RESUMPTIONTOKEN_DES		= "El argumento resumptionToken esta repetido";
	
	public static final String NUM_RESULT_PAG						= "num_result_pag";
	
//	Numero maximo de resultados por pagina
	public static final int numMaxPaginaInt = (new Integer(OAIPMHProperties.getPropertyValue(OAIPMHProperties.NUM_RESULT_PAG))).intValue();
	
//  Nombre del fichero donde se ecribirá el xml
	public static final String KEY_FICHERO_XML						="ficheroXML";
	public static final String KEY_BARRA							="barra";
	
	static
	{
//		Inicializamos el fichero properties
		try {
				InputStream fIsSpringProperties = OAIPMHProperties.class.getResourceAsStream(oaiConfigFile);
				props = new java.util.Properties();
				props.load(fIsSpringProperties);
		} catch (IOException e) {
			logger.error("Excepcion inicializando clase OAIPMHProperties."+ e);
		}
	}
	
	public static String getPropertyValue(String sKey) 
	{
		String sReturn=new String();
		try {
			if (props == null)
			{
				InputStream fIsSpringProperties = OAIPMHProperties.class.getResourceAsStream(oaiConfigFile);
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
	
	/* 
		Este metodo devuelve si el repositorio de OAI-PMH admite conjuntos
	*/
	public static boolean repositorioAdmiteSets()
	{
		return OAIPMHProperties.VALUE_SOPORTA_CONJUNTOS_VALUE_SI.equals(props.getProperty(OAIPMHProperties.KEY_SOPORTA_CONJUNTOS));
	}
	
	/*
		Este metodo recorre la lista de metadatos admitidos y mira a ver si el que se le pasa esta.
	*/
	public static boolean esFormatoMetadatoAdmitido(String metadato)
	{
		if (metadato == null || metadato.equals(""))
			return false;
		String metadatos = props.getProperty(OAIPMHProperties.KEY_METADATOS);
//		Si no hay valor para la lista de metadatos, pues no es compatible.
		if (metadatos == null || metadatos.equals(""))
			return false;
		ArrayList lista = new ArrayList(Arrays.asList(metadatos.split(",")));
		return lista.contains(metadato);
	}
	
	/*
		Este metodo extrae el esquema del prefijo de metadato que le pasan.
	*/
	public static String esquemaMetadato(String metadato)
	{
		if (metadato == null || metadato.equals(""))
			return null;
		if (!esFormatoMetadatoAdmitido(metadato))
			return null;
		String metadatos = props.getProperty(OAIPMHProperties.KEY_METADATOS);
		String esquemas = props.getProperty(OAIPMHProperties.KEY_ESQUEMAS_METADATOS);
//		De la lista de prefijos de metadatos, tengo que saber la posicion que ocupa para extraer el esquema de la lista de esquemas
		if (esquemas == null || esquemas.equals(""))
			return null;
		String[] arrayMetadatos = metadatos.split(",");
		String[] arrayEsquemas = esquemas.split(",");
//		Tiene que haber el mismo numero de esquemas que de prefijos de metadatos.
		if (arrayMetadatos.length != arrayEsquemas.length)
			return null;
		for (int i = 0; i < arrayMetadatos.length; i++) {
			if (arrayMetadatos[i].equals(metadato)) // hemos encontrado el metadato en la lista de metadatos, con la posicion devuelvo el mismo elemento de la lista de esquemas
				return arrayEsquemas[i];
		}
		return null;
	}
	
	/*
		Este metodo extrae el namespace del prefijo de metadato que le pasan
	*/
	public static String namespaceMetadato(String metadato)
	{
		if (metadato == null || metadato.equals(""))
			return null;
		if (!esFormatoMetadatoAdmitido(metadato))
			return null;
		String metadatos = props.getProperty(OAIPMHProperties.KEY_METADATOS);
		String namespaces = props.getProperty(OAIPMHProperties.KEY_NAMESPACE_METADATOS);
//		De la lista de prefijos de metadatos, tengo que saber la posicion que ocupa para extraer el esquema de la lista de esquemas
		if (namespaces == null || namespaces.equals(""))
			return null;
		String[] arrayMetadatos = metadatos.split(",");
		String[] arrayNamespaces = namespaces.split(",");
//		Tiene que haber el mismo numero de namespaces que de prefijos de metadatos.
		if (arrayMetadatos.length != arrayNamespaces.length)
			return null;
		for (int i = 0; i < arrayMetadatos.length; i++) {
			if (arrayMetadatos[i].equals(metadato)) // hemos encontrado el metadato en la lista de metadatos, con la posicion devuelvo el mismo elemento de la lista de esquemas
				return arrayNamespaces[i];
		}
		return null;
	}
	
	/*
	 * Devuelve el numero de metadatas format que hay en el repositorio
	 */
    public static int devuelveNumMetadataFormat () throws Exception    {
    	
    	String[] metadataFormat = OAIPMHProperties.KEY_METADATOS.split(",");
    	return metadataFormat.length;
    }
	
	/*
		Este metodo extrae el valor del equema de identificadores
	*/
	public static String eschemaIdentifier()
	{
		if (VALUE_SCHEME_IDENTIFIER == null || VALUE_SCHEME_IDENTIFIER.equals(""))
			VALUE_SCHEME_IDENTIFIER= getPropertyValue(KEY_SCHEME_IDENTIFIER);
		return VALUE_SCHEME_IDENTIFIER;
	}
	
	/*
		Este metodo extrae el valor del namespace de identificadores
	*/
	public static String namespaceIdentifier()
	{
		if (VALUE_NAMESPACE_IDENTIFIER == null || VALUE_NAMESPACE_IDENTIFIER.equals(""))
			VALUE_NAMESPACE_IDENTIFIER= getPropertyValue(KEY_NAMESPACE_IDENTIFIER);
		return VALUE_NAMESPACE_IDENTIFIER;
	}
}
