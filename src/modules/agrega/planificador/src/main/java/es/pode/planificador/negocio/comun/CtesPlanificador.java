/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.planificador.negocio.comun;

public class CtesPlanificador 
{	
	public final static String NO_PERIODICA = "N";
	public final static String PERIODICA = "P";
	public final static String HORARIA = "H";
	public final static String DIARIA = "D";
	public final static String SEMANAL = "S";
	public final static String MENSUAL = "M";
	public final static String ANUAL = "A";
	public final static String GRUPO_JOBS = "GrupoTareas";
	public final static String QUARTZ_PROPERTIES = "quartz_priority.properties";
	public final static String JOB = "Tarea-";
	public final static String TRIGGER = "Disp-";
	public final static String GRUPO_TRIGGER = "GrupoProg";
	public final static String PERIODICIDAD = "periodicidad";
	public final static String PARAMETROS = "parametros";
	public final static String TIPO_TAREA = "tipoTarea";
	public final static String USUARIO = "usuario";
	public final static String SEPARACION_TAREA = "!!"; 
	public final static String MSG_PUBLICADO = "ODE OK";
	public final static String MSG_NOPUBLICADO = "ODE KO";
	public final static String MSG_REINDEXADO = "Reindexado correctamente";
	public final static String MSG_NOREINDEXADO = "Reindexado incorrectamente";
	public final static String MSG_ELIMINACIONODES_OK = "Eliminación ODEs correcta";
	public final static String MSG_ELIMINACIONODES_KO = "No se ha podido eliminar los ODEs";
	public final static String MSG_INFORMES_OK = "Generación del informe correcta";
	public final static String MSG_INFORMES_KO = "Generación del informe incorrecta";
	public final static String MSG_DESC_INFORMES = "Generación de informes";
	public final static String TAREA_GENERAR_INFORME = "GenerarInforme";
}
