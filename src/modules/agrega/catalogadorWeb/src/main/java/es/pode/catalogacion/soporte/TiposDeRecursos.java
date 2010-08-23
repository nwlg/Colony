/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.catalogacion.soporte;

public class TiposDeRecursos {
	//Todos estos valores se podrían recoger de un properties en vez
	//de tenerlos como constantes.
	/*************************************************************
	 * 						    MEDIA							 *
	 * ***********************************************************/
	public static final String  FOTOGRAFIA	= "5.2.1";
	public static final String  ILUSTRACION	= "5.2.2";
	public static final String  VIDEO	= "5.2.3";
	public static final String  ANIMACION	= "5.2.4";
	public static final String  MUSICA	= "5.2.5";
	public static final String  EFECTO_SONORO	= "5.2.6";
	public static final String  LOCUCION	= "5.2.7";
	public static final String  AUDIO_COMPUESTO	= "5.2.8";
	public static final String  TEXTO_NARRATIVO	= "5.2.9";
	public static final String  HIPERTEXTO	= "5.2.10";
	public static final String  GRAFISMO  = "5.2.11";
	public static final String  MEDIA_INTEGRADO  = "5.2.12";
	/*************************************************************
	 * SISTEMA DE REPRESENTACION DE INFORMACION Y/O CONOCIMIENTO *
	 * ***********************************************************/
	public static final String  BASE_DE_DATOS	= "5.2.13";
	public static final String  TABLA	= "5.2.14";
	public static final String  GRAFICO	= "5.2.15";
	public static final String  MAPA_CONCEPTUAL	= "5.2.16";
	public static final String  MAPA_DE_NAVEGACION	= "5.2.17";
	public static final String  PRESENTACION_MULTIMEDIA	= "5.2.18";
	public static final String  TUTORIAL	= "5.2.19";
	public static final String  DICCIONARIO_DIGITAL	= "5.2.20";
	public static final String  ENCICLOPEDIA_DIGITAL	= "5.2.21";
	public static final String  PUBLICACION_DIGITAL_PERIODICA	= "5.2.22";
	public static final String  WEB_PORTAL_TEMATICO_O_CORPORATIVO  = "5.2.23";
	public static final String  WIKI  = "5.2.24";
	public static final String  WEBLOG  = "5.2.25";
	/*************************************************************
	 *                    APLICACION INFORMATICA                 *
	 * ***********************************************************/
	public static final String  HERRAMIENTA_MULTIMEDIA	= "5.2.26";//herramienta de creación/edición multimedia
	public static final String  HERRAMIENTA_WEB	= "5.2.27";//herramienta de creación/edición web
	public static final String  HERRAMIENTA_OFIMATICA	= "5.2.28";//herramienta de ofimática
	public static final String  HERRAMIENTA_PROGRAMACION	= "5.2.29";//herramienta de programación
	public static final String  HERRAMIENTA_ANALISIS= "5.2.30";//herramienta de análisis/organización de información/conocimiento
	public static final String  HERRAMIENTA_APOYO	= "5.2.31";//herramienta de apoyo a procesos/procedimientos
	public static final String  HERRAMIENTA_GESTION	= "5.2.32";//herramienta de gestión de aprendizaje/trabajo individual/cooperativo/ colaborativo
	/*************************************************************
	 *                           SERVICIO                        *
	 * ***********************************************************/
	public static final String  SERVICIO_MULTIMEDIA	= "5.2.33";//servicio de creación/edición multimedia
	public static final String  SERVICIO_WEB	= "5.2.34";//servicio de creación/edición web
	public static final String  SERVICIO_OFIMATICA	= "5.2.35";//servicio de ofimática
	public static final String  SERVICIO_PROGRAMACION	= "5.2.36";//servicio de programación
	public static final String  SERVICIO_ANALISIS	= "5.2.37";//servicio de análisis/organización de información/conocimiento
	public static final String  SERVICIO_APOYO	= "5.2.38";//servicio de apoyo a procesos/procedimientos
	public static final String  SERVICIO_GESTION	= "5.2.39";//servicio de gestión de aprendizaje/trabajo individual/cooperativo/colaborativo
	/*************************************************************
	 *                    CONTENIDO DIDACTICO                    *
	 * ***********************************************************/
	public static final String  LECTURAS_GUIADAS	= "5.2.40";//lecturas guiadas
	public static final String  LECCION_MAGISTRAL	= "5.2.41";//lección magistral
	public static final String  COMENTARIOS_DE_TEXTO_IMAGEN	= "5.2.42";//comentarios de texto-imagen
	public static final String  ACTIVIDAD_DISCUSION	= "5.2.43";//actividad de discusión
	public static final String  EJERCICIO_O_PROBLEMA	= "5.2.44";//ejercicio o problema cerrado
	public static final String  CASO_CONTEXTUALIZADO	= "5.2.45";//caso contextualizado
	public static final String  PROBLEMA_ABIERTO	= "5.2.46";//problema abierto
	public static final String  ESCENARIO_APRENDIZAJE	= "5.2.47";//escenario real o virtual de aprendizaje
	public static final String  JUEGO_DIDACTICO	= "5.2.48";//juego didáctico
	public static final String  WEBQUEST	= "5.2.49";//webquest
	public static final String  EXPERIMENTO	= "5.2.50";//experimento
	public static final String  PROYECTO_REAL	= "5.2.51";//proyecto real
	public static final String  SIMULACION	= "5.2.52";//simulación
	public static final String  CUESTIONARIO	= "5.2.53";//cuestionario
	public static final String  EXAMEN	= "5.2.54";//examen
	public static final String  AUTOEVALUACION	= "5.2.55";//autoevaluación
	
	
	
	
	public boolean esMedia(String tipoRecurso){
		boolean resultado =false;
		resultado = tipoRecurso.equals(FOTOGRAFIA) ||
					tipoRecurso.equals(ILUSTRACION) ||
					tipoRecurso.equals(VIDEO) ||
					tipoRecurso.equals(ANIMACION) ||
					tipoRecurso.equals(MUSICA) ||
					tipoRecurso.equals(EFECTO_SONORO) ||
					tipoRecurso.equals(LOCUCION) ||
					tipoRecurso.equals(AUDIO_COMPUESTO) ||
					tipoRecurso.equals(TEXTO_NARRATIVO) ||
					tipoRecurso.equals(HIPERTEXTO) ||
					tipoRecurso.equals(GRAFISMO) ||
					tipoRecurso.equals(MEDIA_INTEGRADO);

					
		return resultado;
	}
	
	public boolean esSistemaDeRepresentacion(String tipoRecurso){
		boolean resultado =false;
		resultado = tipoRecurso.equals(BASE_DE_DATOS) ||
					tipoRecurso.equals(TABLA) ||
					tipoRecurso.equals(GRAFICO) ||
					tipoRecurso.equals(MAPA_CONCEPTUAL) ||
					tipoRecurso.equals(MAPA_DE_NAVEGACION) ||
					tipoRecurso.equals(PRESENTACION_MULTIMEDIA) ||
					tipoRecurso.equals(TUTORIAL) ||
					tipoRecurso.equals(DICCIONARIO_DIGITAL) ||
					tipoRecurso.equals(ENCICLOPEDIA_DIGITAL) ||
					tipoRecurso.equals(PUBLICACION_DIGITAL_PERIODICA) ||
					tipoRecurso.equals(WEB_PORTAL_TEMATICO_O_CORPORATIVO) ||
					tipoRecurso.equals(WIKI) ||
					tipoRecurso.equals(WEBLOG);
					
		return resultado;
	}
	

	public boolean esAplicacionInformatica(String tipoRecurso){
		boolean resultado =false;
		resultado = tipoRecurso.equals(HERRAMIENTA_ANALISIS) ||
					tipoRecurso.equals(HERRAMIENTA_APOYO) ||
					tipoRecurso.equals(HERRAMIENTA_GESTION) ||
					tipoRecurso.equals(HERRAMIENTA_MULTIMEDIA) ||
					tipoRecurso.equals(HERRAMIENTA_OFIMATICA) ||
					tipoRecurso.equals(HERRAMIENTA_PROGRAMACION) ||
					tipoRecurso.equals(HERRAMIENTA_WEB);

					
		return resultado;
	}
	
	public boolean esServicio(String tipoRecurso){
		boolean resultado =false;
		resultado = tipoRecurso.equals(SERVICIO_ANALISIS) ||
					tipoRecurso.equals(SERVICIO_APOYO) ||
					tipoRecurso.equals(SERVICIO_GESTION) ||
					tipoRecurso.equals(SERVICIO_MULTIMEDIA) ||
					tipoRecurso.equals(SERVICIO_OFIMATICA) ||
					tipoRecurso.equals(SERVICIO_PROGRAMACION) ||
					tipoRecurso.equals(SERVICIO_WEB);

					
		return resultado;
	}
	
	public boolean esContenidoDidactico(String tipoRecurso){
		boolean resultado =false;
		resultado = tipoRecurso.equals(LECTURAS_GUIADAS) ||
					tipoRecurso.equals(LECCION_MAGISTRAL) ||
					tipoRecurso.equals(COMENTARIOS_DE_TEXTO_IMAGEN) ||
					tipoRecurso.equals(ACTIVIDAD_DISCUSION) ||
					tipoRecurso.equals(EJERCICIO_O_PROBLEMA) ||
					tipoRecurso.equals(CASO_CONTEXTUALIZADO) ||
					tipoRecurso.equals(PROBLEMA_ABIERTO) ||
					tipoRecurso.equals(ESCENARIO_APRENDIZAJE) ||
					tipoRecurso.equals(JUEGO_DIDACTICO) ||
					tipoRecurso.equals(WEBQUEST) ||
					tipoRecurso.equals(EXPERIMENTO) ||
					tipoRecurso.equals(PROYECTO_REAL) ||
					tipoRecurso.equals(SIMULACION) ||
					tipoRecurso.equals(CUESTIONARIO) ||
					tipoRecurso.equals(EXAMEN) ||
					tipoRecurso.equals(AUTOEVALUACION);		
		return resultado;
	}
	
}
