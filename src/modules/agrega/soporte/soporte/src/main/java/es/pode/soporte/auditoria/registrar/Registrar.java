/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.soporte.auditoria.registrar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.soporte.auditoria.servicios.BusquedaVO;
import es.pode.soporte.auditoria.servicios.OperacionVO;
import es.pode.soporte.auditoria.servicios.SrvAuditoriaServicio;
import es.pode.soporte.auditoria.servicios.SrvAuditoriaServicioServiceLocator;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.validador.ValidadorMEC;
import es.pode.soporte.validador.ValidadorStrategy;

/** 
 * Clase que se encarga del registro de los datos capturados en la intercepción
 * 
 * @author jsimon
 */

public class Registrar {
	
	static Log log = LogFactory.getLog("Registrar");
	static final String SEPARADOR = "_"; 	
	static final String VACIO = " ";
	private static String HOST;
	private static String PUERTO;
	
	static {
		if (HOST == null || PUERTO == null) {	
			Properties prop = new Properties();
			ClassLoader loader = Registrar.class.getClassLoader();
			InputStream in = loader.getResourceAsStream("agrega.properties");
			
			try {
				prop.load(in);
				HOST = prop.getProperty("auditoria.host");
				PUERTO = prop.getProperty("auditoria.puerto");
			} 
			catch (IOException e) {
				log.error(e);
			}
		}
	}
	
	/** Método centralizador que se encarga de distribuir en función de la operación realizada 
	 * 	@param datosInterceptados Objeto con los datos interceptados
	 * */
	public static void operacion(DatosVO datosInterceptados) throws Exception {
		
		if (log.isDebugEnabled())
			hashMap2Traza(datosInterceptados.getValores());
		
		if (log.isDebugEnabled())
			log.debug("Módulo destino: " + datosInterceptados.getModuloDestino());
		
		if (RegistroCtes.OPERACION_BUSCAR.equals(datosInterceptados.getModuloDestino()))
			operacionBuscar(datosInterceptados);
		else if (RegistroCtes.OPERACION_BUSCAR_SQI.equals(datosInterceptados.getModuloDestino()))
			operacionBuscarSQI(datosInterceptados);
		else if (RegistroCtes.OPERACION_FICHA.equals(datosInterceptados.getModuloDestino())) 
			operacionFicha(datosInterceptados);
		else if (RegistroCtes.OPERACION_PREVISUALIZADO.equals(datosInterceptados.getModuloDestino())) 
			operacionPrevisualizar(datosInterceptados);
		else if (RegistroCtes.OPERACION_DESCARGADO.equals(datosInterceptados.getModuloDestino())) 
			operacionDescargado(datosInterceptados);		
		else if (RegistroCtes.OPERACION_ENVIAR_CORREO.equals(datosInterceptados.getModuloDestino())) 
			operacionEnviarCorreo(datosInterceptados);		
	}
	
	/** 
	 * Se registra la búsqueda realizada. 
	 * No se realiza el registro si se está moviéndose por la paginación 
	 * 	@param valores Tabla con los valores capturados
	 *  @param destino Operación realizada
	 * */
	public static void operacionBuscar(DatosVO datosInterceptados) {
		
		String usuario = null;
		String moduloDestino = datosInterceptados.getModuloDestino();
		HashMap valores = datosInterceptados.getValores();
		String ambito = getAmbito(valores);
		String valorBuscado = getValorBuscado(valores); 
		String tipoBusqueda = getTipoBusqueda(valores);
		String valoresInterceptados = getValoresInterceptados(valores);
		
		/* No registramos valores no controlados */
		if (VACIO.equals(ambito) || VACIO.equals(tipoBusqueda) || VACIO.equals(valorBuscado))
			return;

		if (LdapUserDetailsUtils.estaAutenticado()) 
			usuario = LdapUserDetailsUtils.getUsuario();
			
		BusquedaVO parametros = new BusquedaVO();		
		parametros.setTerminoBuscado(valorBuscado);
		parametros.setAmbito_busqueda(moduloDestino + SEPARADOR + ambito);
		parametros.setTipo_busqueda(tipoBusqueda);
		parametros.setTipo(valoresInterceptados); 
		parametros.setUsuario(usuario);
		parametros.setFecha(Calendar.getInstance());
		registrarBusqueda(parametros);		
	}
		
	/**
	 * Registro de la operación previsualizar
	 * 	@param valores Tabla con los valores capturados
	 *  @param destino Operación realizada
	 */
	public static void operacionPrevisualizar(DatosVO datosInterceptados) throws Exception {
		
		String moduloDestino = datosInterceptados.getModuloDestino();
		HashMap valores = datosInterceptados.getValores();		
		
		String idODE = (String)valores.get(RegistroCtes.PARAMETRO_IDENTIFICADOR);
		String idioma = (String)valores.get(RegistroCtes.PARAMETRO_IDIOMA);
			
		registrarOperacion(idODE, idioma, moduloDestino);
	}

	/**
	 * Registro de la operación descargados
	 * 	@param valores Tabla con los valores capturados
	 *  @param destino Operación realizada
	 */
	public static void operacionDescargado(DatosVO datosInterceptados) throws Exception {
		
		String moduloDestino = datosInterceptados.getModuloDestino();
		HashMap valores = datosInterceptados.getValores();
				
		String 	idODE = (String)valores.get(RegistroCtes.PARAMETRO_ID_ODE);
		String idioma = (String)valores.get(RegistroCtes.PARAMETRO_IDIOMA);//En la operación de solicitar metadato(ficha) nos interesa el idioma de búsqueda
		String tipoPIF = (String)valores.get(RegistroCtes.PARAMETRO_TIPO_PIF); // En la operación descargado de ODE también interesa el tipo de descarga			
 		
		registrarOperacion(idODE, idioma, moduloDestino + SEPARADOR + tipoPIF);
	}
	
	/**
	 * Registro de la operación ficha
	 * 	@param valores Tabla con los valores capturados
	 *  @param destino Operación realizada
	 */
	public static void operacionFicha(DatosVO datosInterceptados) throws Exception {

		String moduloDestino = datosInterceptados.getModuloDestino();
		HashMap valores = datosInterceptados.getValores();
		
		String fichaBusquedaSimpleAvanzada = (String)valores.get(RegistroCtes.PARAMETRO_TIPO_BUSQUEDA); 
		
		log("Valores ficha busqueda simple avanzada:  " + fichaBusquedaSimpleAvanzada);
		
		/* Nos aseguramos que en la ficha es la llamada que nos interesa */
		if (!RegistroCtes.VALORES_FICHA_SIMPLEAVANZADA.equals(fichaBusquedaSimpleAvanzada)) 
			return;
		
		String idODE = (String)valores.get(RegistroCtes.PARAMETRO_IDENTIFICADOR_ODE); 
		String idioma = (String)valores.get(RegistroCtes.PARAMETRO_IDIOMA);//En la operación de solicitar metadato(ficha) nos interesa el idioma de búsqueda
			
		registrarOperacion(idODE, idioma, moduloDestino);
	}

    /**
	 * Registro de la operación de envío de correo
	 * 	@param valores Tabla con los valores capturados
	 *  @param destino Operación realizada
	 */
	public static void operacionEnviarCorreo(DatosVO datosInterceptados) throws Exception {

		String moduloDestino = datosInterceptados.getModuloDestino();
		HashMap valores = datosInterceptados.getValores();
		
		String idODE = (String)valores.get(RegistroCtes.PARAMETRO_IDENTIFICADOR_ODE); 
		String idioma = (String)valores.get(RegistroCtes.PARAMETRO_IDIOMA);
			
		registrarOperacion(idODE, idioma, moduloDestino);
	}

	/**
	 * La operación realizada es una búsqueda por SQL
	 * @param valores
	 */
	public static void operacionBuscarSQI(DatosVO datosInterceptados) {
		
		String usuario = null;
		String moduloDestino = datosInterceptados.getModuloDestino();
		HashMap valores = datosInterceptados.getValores();
		String palabrasClave = null;
		String query = (String)valores.get(RegistroCtes.PARAMETRO_QUERY);
		String idiomaBusqueda = ((String)valores.get(RegistroCtes.PARAMETRO_IDIOMA_BUSQUEDA));
		
		if (RegistroCtes.SQI_LANG.equals(idiomaBusqueda)) {
			log("Parseando query SQL_LANG: " + idiomaBusqueda + " query: " + query);
			palabrasClave = parsearVSQL(query);
		}
		else if (RegistroCtes.LUCENE_LANG.equals(idiomaBusqueda)) {
			log.warn("No se contempla la búsqueda a través de Lucene Query Syntax");
			/* Hay que importar las librerías de Lucene. De momento no se hace ya que no hay que dar esta funcionalidad
			QueryParser parser = new QueryParser(props.getProperty("campo_titulo"), new StandardAnalyzer());
			parser.setLowercaseExpandedTerms(true);
			Query lqsQuery = parser.parse(unparsedQuery);
			query.add(lqsQuery);
			*/
		}
		
		if (LdapUserDetailsUtils.estaAutenticado()) 
			usuario = LdapUserDetailsUtils.getUsuario(); 

		log("Registro de la búsqueda SQI. PalabrasClave " + palabrasClave + " usuario: " + usuario);
		
		BusquedaVO parametros = new BusquedaVO();		
		parametros.setTerminoBuscado(palabrasClave);
		parametros.setUsuario(usuario);
		parametros.setFecha(Calendar.getInstance());
		parametros.setTipo_busqueda(moduloDestino);
		registrarBusqueda(parametros);		
	}
	
	
	/**
	 * Metodo copiado de SrvBuscadorServiceImpl para parseo de VSQI. TODO Corregir para
	 * hacer un parseo XML mas fiable.
	 * 
	 * @param queryStatement
	 * @return
	 */
	private static String parsearVSQL(String queryStatement) {
		
		String c = queryStatement.substring(13, queryStatement.length() - 14);
		StringBuffer terminosBuscados = new StringBuffer();
		String palabrasBuscadas = null;
		
		log("Query: " + queryStatement);
		
		while (c.startsWith("<term>")) {
			String term = new String(c.substring(6, c.indexOf("</term>")));
			terminosBuscados.append(term);
			terminosBuscados.append(" ");
			c = c.substring(13 + term.length());
		}
		
		palabrasBuscadas = terminosBuscados.deleteCharAt(terminosBuscados.length()).toString();		
		log(palabrasBuscadas);
		
		return palabrasBuscadas;
	}
	
	/**
	 * Registro de una operación realizada por el usuario
	 * 
	 * @param idODE Identificador del ODE
	 * @param idioma Idioma
	 * @param moduloDestino Operación
	 * @return registro
	 */
	private static boolean registrarOperacion(String idODE, String idioma, String moduloDestino) throws Exception {
		
		boolean registro = false;
		String usuario = null;
		
		/* Si no viene el idioma no registramos la operación */
		if (idioma == null || idioma.equals("")) 
			return registro;

		/* Se valida que el identificador del ODE sea correcto */
		if (!comprobarODE(idODE))
			return registro;
		
		/* Se recupera el usuario */
		if (LdapUserDetailsUtils.estaAutenticado()) 
			usuario = LdapUserDetailsUtils.getUsuario(); 
			
		log("Operación realizada: IdODE: " + idODE + " operación: " + moduloDestino 
				+ " usuario: " + usuario + " idioma: " + idioma);

		OperacionVO parametros = new OperacionVO();		
		parametros.setUsuario(usuario);		
		parametros.setIdOde(idODE);	
		parametros.setFecha(Calendar.getInstance());
		parametros.setIdioma(idioma);
		parametros.setOperacion(moduloDestino);
		
		SrvAuditoriaServicioServiceLocator serviceLocator = new SrvAuditoriaServicioServiceLocator();						
		SrvAuditoriaServicio servicio = null;
		
		try {			
			log("idODE: " + parametros.getIdOde());
			log("operación destino: " + parametros.getOperacion());			
			log("Fecha: " + parametros.getFecha());
			log("usuario: " + parametros.getUsuario());
			log("idioma: " + parametros.getIdioma());
			servicio = serviceLocator.getSrvAuditoriaServicio();
			servicio.registrarOperacion(parametros);
			registro = true;
		}
		catch (Exception e) {
			log.error("Se ha producido un error al invocar al web service auditoria. Revise el fichero de propiedades agrega.properties ");
			log.error("Error: " + e);				
			throw e;
		}
		
		return registro;
	}
	
	
	/**
	 * Registro de una busqueda realizada por el usuario
	 * 
	 * @param parametros Parámetros de la operación realizada
	 * @return registro
	 */
	private static boolean registrarBusqueda(BusquedaVO parametros) {
		
		SrvAuditoriaServicioServiceLocator serviceLocator = new SrvAuditoriaServicioServiceLocator();						
		SrvAuditoriaServicio servicio = null;
		boolean registro = false;
		
		try {			
			log("Término buscado: " + parametros.getTerminoBuscado());
			log("Tipo búsqueda: " + parametros.getTipo_busqueda());
			log("Ambito: " + parametros.getAmbito_busqueda());
			log("Tipo: " + parametros.getTipo());
			log("Usuario: " + parametros.getUsuario());
			log("Fecha: " + parametros.getFecha());
			
			servicio = serviceLocator.getSrvAuditoriaServicio();
			servicio.registrarBusqueda(parametros);
			registro = true;
		}
		catch (Exception e) {
			log.error("Se ha producido un error al invocar al web service auditoria. Revise el fichero de propiedades agrega.properties. " + e);							
		}
		
		return registro;
	}
	
	
	/**
	 * Método para comprobar si se debe registrar el ODE. 
	 * Si el idODE no es válido no se guarda
	 * @param idODE
	 * @return valido:  true: Si hay que registrarlo. false: Si no hay que registrarlo
	 * 		   			 	 
	 */
	public static boolean comprobarODE(String idODE) {
		
		ValidadorStrategy validadorIdODE = new ValidadorStrategy(new ValidadorMEC());
		boolean valido = validadorIdODE.validar(idODE);
		
		if (!valido)
			log("Identificador que no valida y no se registra: " + idODE);
		
		return valido;
	}
			
	/**
	 * En función del tipo de búsqueda el valor que hay que interceptar es distinto
	 * Busqueda normal son las palabrasClave
	 * Búsqueda arbol curricular es el areaCurricular
	 * Búsqueda por tesauro es idTesauro
	 * @param valores Son los datos interceptados
	 * @return valorBuscado El tipo de búsqueda realizado
	 * 		    	 
	 */
	private static String getValorBuscado(HashMap valores) {
		
		String palabrasClave = (String)valores.get(RegistroCtes.PARAMETRO_PALABRAS_CLAVE);
		String areaCurricular = (String)valores.get(RegistroCtes.PARAMETRO_AREACURRICULAR);
		String tesauro = (String)valores.get(RegistroCtes.PARAMETRO_TESAURO);
		String valorBuscado = null;
		
		if (palabrasClave != null && !palabrasClave.equals("")) 
			valorBuscado = palabrasClave;
		else if (areaCurricular != null && !areaCurricular.equals(""))
			valorBuscado = areaCurricular;
		else if (tesauro != null && !tesauro.equals(""))
			valorBuscado = tesauro;
		else
			valorBuscado = VACIO;
		
		log("Valor buscado: " + valorBuscado);
		
		return valorBuscado;
	}
	
	/**
	 * A partir de los datos enviados se recupera la 
	 * @param valores Son los datos interceptados
	 * @return tipoBusqueda El tipo de búsqueda realizado
	 * 		    	 
	 */
	private static String getAmbito(HashMap valores) {
		
		String numPagina = (String)valores.get(RegistroCtes.PARAMETRO_ORIGEN_PAGINA);
		String comunidadesSeleccionadas = (String)valores.get(RegistroCtes.PARAMETRO_COMUNIDADES);	
		String ambito = null;
		
		if (numPagina == null || RegistroCtes.BUSCAR_PAGINA1.equals(numPagina))
			log("Pagina inicial. Se registra");
		else {
			/* No registramos las paginaciones */
			log("Pagina no inicial paginación: " + numPagina + " no se registra");
			return VACIO;
		}
				
		if (comunidadesSeleccionadas != null)
			ambito = RegistroCtes.BUSQUEDA_FEDERADA;
		else
			ambito = RegistroCtes.BUSQUEDA_LOCAL;
		
		log("Ambito búsqueda: " + ambito);
		
		return ambito;
	}
	
	/**
	 * A partir de los datos enviados se recupera el tipo de búsqueda avanzada, simple, árbol curricular y tesauro
	 * @param valores Son los datos interceptados
	 * @return tipo El tipo de búsqueda realizado
	 * 		    	 
	 */
	private static String getTipoBusqueda(HashMap valores) {
		
		String tipoBusqueda = (String)valores.get(RegistroCtes.PARAMETRO_TIPO_BUSQUEDA);
		String tipo =  null;
			
		if (tipoBusqueda == null)
			tipo = RegistroCtes.ENVIO_BUSQUEDA_NORMAL; // Por defecto se considera nulo
		else if (tipoBusqueda.equals(RegistroCtes.VALORES_BUSCAR_SIMPLE))
			tipo = RegistroCtes.ENVIO_BUSQUEDA_NORMAL;
		else if (tipoBusqueda.equals(RegistroCtes.VALORES_BUSCAR_AVANZADO))
			tipo = RegistroCtes.ENVIO_BUSQUEDA_AVANZADA;
		else if (tipoBusqueda.equals(RegistroCtes.VALORES_BUSCAR_ARBOLCURRICULAR))
			tipo = RegistroCtes.ENVIO_BUSQUEDA_AREACURRICULAR;
		else if (tipoBusqueda.equals(RegistroCtes.VALORES_BUSCAR_TESAURO))
			tipo = RegistroCtes.ENVIO_BUSQUEDA_TESAURO;
		else
			tipo = RegistroCtes.ENVIO_BUSQUEDA_NORMAL; // Por defecto se considera nulo
		
		log("Tipo de búsqueda a realizar: " + tipo);
		
		return tipo;
	}
	
	private static void hashMap2Traza (HashMap tabla) {	
		
		for (Iterator it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
            String s1 = (String)tabla.get(s);
            log.debug("Valores Hash: " + s + " " + s1);
		}
	}
	
	/**
	 * A partir de los datos enviados se recupera el tipo de búsqueda avanzada, simple, árbol curricular y tesauro
	 * @param tabla Son los datos interceptados en formato HashMap
	 * @return valores Los valores interceptados en formato String
	 * 		    	 
	 */
	private static String getValoresInterceptados (HashMap tabla) {
		
		StringBuffer valores = new StringBuffer();
		
		try {	
			for (Iterator it = tabla.keySet().iterator(); it.hasNext();) {
	            String s = (String)it.next();
	            String s1 = (String)tabla.get(s);
				valores.append(s + ": " + s1 + "  "); 			
			}
		}
		catch (Exception e) {
			log.error("Error captura valores interceptados: " + e);
			valores.append(VACIO); 
		}
			
		return valores.toString();
	}
	
	public static String getHost() {
		return HOST;
	}
	
	public static String getPort() {
		return PUERTO;
	}
	
	private static void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
