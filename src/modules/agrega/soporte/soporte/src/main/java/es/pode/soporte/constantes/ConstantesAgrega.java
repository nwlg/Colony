/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.constantes;

/** Fichero de constantes de desarrollo de la plataforma AGREGA */ 
public interface ConstantesAgrega {
	public final static String TRABAJO_ERRONEO = "ERROR";
	public final static String TRABAJO_CORRECTO = "OK";
	public final static String TRABAJO_INTERRUMPIDO = "INTERRUMPIDO";
	public final static String NO_PERIODICA = "N";
	public final static String PERIODICA = "P";
    public final static String HORARIA = "H";
	public final static String DIARIA = "D";
	public final static String SEMANAL = "S";
	public final static String MENSUAL = "M";
	public final static String ANUAL = "A";
	public final static String GRUPO_MODIFICADOR = "GrupoModificador";
	public final static String TRIGGER_MODIFICADOR = "TriggerModificador";
	public final static String NOMBRE_MODIFICADOR = "Modificacion_";
	public final static String LISTA_IDIOMAS_BUSCABLES = "idiomas.buscables";
	public final static String LISTA_IDIOMAS_PLATAFORMA = "idiomas.plataforma";
	public final static String IDIOMA_DEFECTO_PLATAFORMA = "idioma.por.defecto";
	public final static String IDIOMA_SECUNDARIO_PLATAFORMA = "idioma.secundario";
	public final static String LISTA_IDIOMAS_TRADUCIBLES = "idiomas.traducibles";
	public final static String AMBITO_GENERAL = "MEC"; // identificador del nodo general
	public final static String AMBITO_NODO = "nodo";  // constante para acceder al identificador del nodo al que pertenezco
	public final static String DEFAULT_LOCALE = "org.apache.struts.action.LOCALE";
	public final static String APPLICATION_PROPERTIES = "application-resources";
	public final static String FICHERO = "FICHERO";
	public final static String ARCHIVO = "ARCHIVO";
	public final static String RCP = "RCP";
	public final static String CA = "CA";
	public final static String ODE_NO_VALIDO = "ODE_NO_VALIDO";
}
