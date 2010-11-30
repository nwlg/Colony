/* Agrega es una federaci n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut nomas propiedad de Red.es. Este c digo ha sido desarrollado por la Entidad P blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav s de la Secretar a de Estado de Telecomunicaciones y para la Sociedad de la Informaci n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci n y de Convergencia con Europa y entre Comunidades Aut nomas y Ciudades Aut nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006  Sociedad de la Informaci n 

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.indexador.negocio.soporte;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class DocumentoIndexacion {

	private static Logger logger = Logger.getLogger(DocumentoIndexacion.class);

	public static String INDEXACION_SEPARATOR = "-";
	
	final static String INDEXADO_NOR = "NORMAL";
	final static String INDEXADO_MAY = "MAYUSCULAS";
	final static String INDEXADO_MIN = "MINUSCULAS";
	
	// m todo auxiliar para rellenar los fields, adem s con la prioridad.
	private static Field generaField(String title, String arg2, Store store, Index index, float prioridad)
	{
		logger.debug("generaField");
		if (logger.isDebugEnabled())
			logger.debug("Se va a generar el campo title = " + title + " args = "+ arg2 + " store = " + store + " index = " + index + " prioridad = " + prioridad);
		Field field = new Field (title,arg2,store,index);
		field.setBoost(prioridad);
                field.setOmitNorms(true);//////removing norms!
		
		return field;		
	}
	
	public static Document GenerarCamposSecundarios(Document doc, es.pode.indexador.negocio.servicios.indexado.LomESSecundarioVO[] lomesSecundarios, Properties props) 
			throws Exception 
	{
		for (int x = 0; lomesSecundarios != null && x < lomesSecundarios.length; x++) 
		{
			es.pode.indexador.negocio.servicios.indexado.LomESSecundarioVO lomESSecundario = lomesSecundarios[x]; 
			
			if (lomESSecundario != null)
			{
				aniadeFieldaDocument(doc, props.getProperty("campo_keywords_secundario"),
						lomESSecundario.getPalabrasClave(), Field.Store.YES,Field.Index.TOKENIZED,
						Float.valueOf(props.getProperty("prioridad_palabraClave_secundario")).floatValue(), DocumentoIndexacion.INDEXADO_MIN);
				if(DocumentoIndexacion.logger.isDebugEnabled())
				DocumentoIndexacion.logger.debug("A adimos al documento el campo secundario campo_keywords_secundario ");
                                
				aniadeFieldaDocument(doc, props.getProperty("campo_title_secundario"),
						lomESSecundario.getTitulo(), Field.Store.YES,Field.Index.TOKENIZED,
						Float.valueOf(props.getProperty("prioridad_titulo_secundario")).floatValue(), DocumentoIndexacion.INDEXADO_MIN);
				if(DocumentoIndexacion.logger.isDebugEnabled())
					DocumentoIndexacion.logger.debug("A adimos al documento el campo secundario campo_title_secundario ");

				aniadeFieldaDocument(doc, props.getProperty("campo_description_secundario"),
						lomESSecundario.getDescripcion(), Field.Store.YES,Field.Index.TOKENIZED,
						Float.valueOf(props.getProperty("prioridad_descripcion_secundario")).floatValue(), DocumentoIndexacion.INDEXADO_MIN);
				if(DocumentoIndexacion.logger.isDebugEnabled())
					DocumentoIndexacion.logger.debug("A adimos al documento el campo secundario campo_description_secundario ");
			}
		}
		return doc;
	}

//	Este metodo aniade en el documento que le pasan el valor del campo que le pasan parametrizando ese aniadido con
//	cuestiones como, si ha de almacenarse, el tipo de indexacion que ha de hacerse, el peso del campo etc.
//	Se le pasa el fichero de propiedades del que hay que extraer el valor del campo a indexar.
	private static void aniadeFieldaDocument(Document doc, String campo, String valor, Field.Store almacena, Field.Index indexacion, float peso, String tipoTexto)
	{
		//Si indexamos un campo nulo, metemos como valor ""
		if (valor == null)
			valor = "";
		//Indexamos en minusculas, mayusculas o tal cual (por que si no, puede hacer sugerencias en mayusculas)
		if (campo != null && !campo.equals(""))
		{
			if (tipoTexto.equals(DocumentoIndexacion.INDEXADO_MIN))
				doc.add(generaField(campo, valor.toString().toLowerCase(), almacena, indexacion, peso));
			else if (tipoTexto.equals(DocumentoIndexacion.INDEXADO_NOR))
				doc.add(generaField(campo, valor.toString(), almacena, indexacion, peso));
			else if (tipoTexto.equals(DocumentoIndexacion.INDEXADO_MAY))
				doc.add(generaField(campo, valor.toString().toUpperCase(), almacena, indexacion, peso));
		}
	}
//	Este metodo aniade en el documento que le pasan el array de valores del campo que le pasan parametrizando ese aniadido con
//	cuestiones como, si ha de almacenarse, el tipo de indexacion que ha de hacerse, el peso del campo etc.
//	Se le pasa el fichero de propiedades del que hay que extraer el valor del campo a indexar.
	private static void aniadeFieldaDocument(Document doc, String campo, String[] valor, Field.Store almacena, Field.Index indexacion, float peso, String tipoTexto)
	{
//		En el caso de que haya multimples valores, los aniadimos todos
		if (valor != null && valor.length>0) {
			for (int i = 0; i < valor.length; i++) {
				aniadeFieldaDocument(doc, campo, valor[i], almacena, indexacion, peso, tipoTexto);
			}
		}
		else //en el caso de que no haya valores, indexamos vacio
		{
			aniadeFieldaDocument(doc, campo, "", almacena, indexacion, peso, tipoTexto);
		}
	}	
	public static Document GenerarCamposPrincipales(Document doc, es.pode.indexador.negocio.servicios.indexado.IdODEVO idODEVO, Properties props) throws Exception 
	{
		
//		catalogamos todo lo que esta en el ODE sin pertenecer a los lomes.
		aniadeFieldaDocument(doc, props.getProperty("campo_identificadorODE"),
				idODEVO.getIdODE(), Field.Store.YES,Field.Index.UN_TOKENIZED,
				Float.valueOf(props.getProperty("weight_identificadorODE_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
		aniadeFieldaDocument(doc, props.getProperty("campo_localizador"),
				idODEVO.getLocalizadorODE(), Field.Store.YES,Field.Index.UN_TOKENIZED,
				Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
		aniadeFieldaDocument(doc, props.getProperty("campo_valoracion"),
				idODEVO.getValoracion().toString(), Field.Store.YES,Field.Index.UN_TOKENIZED,
				Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
		aniadeFieldaDocument(doc, props.getProperty("campo_secuencia"),
				idODEVO.getSecuencia().toString(), Field.Store.YES,Field.Index.TOKENIZED,
				Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
		aniadeFieldaDocument(doc, props.getProperty("campo_imagen"),
				idODEVO.getImgFile(), Field.Store.YES,Field.Index.UN_TOKENIZED,
				Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
		//Tratamiento del campo tamanio
		
		Long tamanioLong = null;
		if(idODEVO.getTamanio() == null || idODEVO.getTamanio().equals(""))	tamanioLong = new Long(0);		
		else tamanioLong = new Long(idODEVO.getTamanio().longValue());			
			aniadeFieldaDocument(doc, props.getProperty("campo_tamanio"), 
					tamanioLong.toString(), Field.Store.YES,Field.Index.UN_TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);

		es.pode.indexador.negocio.servicios.indexado.LomESPrimarioVO lomesPrimario = idODEVO.getCatalogacionPrimaria();
//		Catalogamos todo lo que esta dentro del lomes primario
		if (lomesPrimario != null)
		{
			aniadeFieldaDocument(doc, props.getProperty("campo_titulo"),
					lomesPrimario.getTitulo(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_titulo_primario")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_descripcion"),
					lomesPrimario.getDescripcion(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_descripcion_primario")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);

			aniadeFieldaDocument(doc, props.getProperty("campo_palabrasClave"),
					lomesPrimario.getPalabrasClave(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_palabraClave_primario")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_autor"),
					lomesPrimario.getAutor(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("weight_author_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_fechaPublicacion"),
					obtenerFechaPublicacion(lomesPrimario.getFechaPublicacion().getTime())[0], Field.Store.YES,Field.Index.UN_TOKENIZED,
					Float.valueOf(props.getProperty("weight_datepublished_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_horaPublicacion"),
					obtenerFechaPublicacion(lomesPrimario.getFechaPublicacion().getTime())[1], Field.Store.YES,Field.Index.UN_TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_formato"),
					lomesPrimario.getFormatos(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("weight_format_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);

			// Annotation
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_annotation"),
					lomesPrimario.getAnnotation(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_annotation_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Author Organisation(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_authorOrganisation"),
					lomesPrimario.getAuthorOrganisation(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_authororg_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Content Provider(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_contentProvider"),
					lomesPrimario.getContentProvider(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_contentprovider_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Condition(s) of Use
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_conditionsOfUse"),
					lomesPrimario.getConditionsOfUse(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_conditionsOfUse_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Relation Kind(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_relationKind"),
					lomesPrimario.getRelationKind(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_relationkind_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Related Resource Title(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_relatedResourceTitle"),
					lomesPrimario.getRelatedResourceTitle(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_relresourcetitle_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Related Resource Identifier(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_relatedResourceIdentifier"),
					lomesPrimario.getRelatedResourceIdentifier(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_relresourceident_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Taxon Path(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_taxonPath"),
					lomesPrimario.getTaxonPath(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_taxonpath_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			// Typical Learning Time(s)
			aniadeFieldaDocument(
					doc,
					props.getProperty("campo_typicalLearningTime"),
					lomesPrimario.getTypicalLearningTime(),
					Field.Store.YES,
					Field.Index.TOKENIZED,
					Float.valueOf(
						props.getProperty("weight_typicallearningtime_primary")).
						floatValue(),
					DocumentoIndexacion.INDEXADO_NOR);

			aniadeFieldaDocument(doc, props.getProperty("campo_areaCurricular"),
					arrayString2ArrayStringAtomizado(lomesPrimario.getArbolCurricular(),"/"), Field.Store.YES,Field.Index.UN_TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_idTesauro"),
					arrayString2ArrayStringAtomizado(lomesPrimario.getTesauros(),"/"), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_areaCurricular_path"),
					lomesPrimario.getArbolCurricular(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_areaCurricular_nodo"),
					arrayString2ArrayStringAtomizadoUltimo(lomesPrimario.getArbolCurricular(),"/"), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			//Arbol curricular vigente
			aniadeFieldaDocument(doc, props.getProperty("campo_arbolCurricularVigente"), lomesPrimario.getArbolCurricularVigente(), Field.Store.YES, Field.Index.UN_TOKENIZED, 
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			
//			No tenemos en cuenta el nivel educativo para la indexacion
//			aniadeFieldaDocument(doc, props.getProperty("campo_nivelEducativo"),
//					lomesPrimario.getNivelesEducativos(), Field.Store.YES,Field.Index.TOKENIZED,
//					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_recurso"),
					lomesPrimario.getRecurso(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("weight_resourcetype_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_destinatarios"),
					lomesPrimario.getDestinatarios(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("weight_recipient_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_licencias"),
					lomesPrimario.getLicencia(), Field.Store.YES,Field.Index.TOKENIZED,
					Float.valueOf(props.getProperty("weight_copyrighttype_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
//			El ambito es un valor de un campo libre de la etiqueta de licencias que indica las comunicades autonomas con
//			permiso para ver este ODE. Consultar con Nora sobre la manera de extraer esta informacion y meterla en el
//			publicador.
			aniadeFieldaDocument(doc, props.getProperty("campo_ambito"),
					lomesPrimario.getAmbito(), Field.Store.YES,Field.Index.UN_TOKENIZED,
					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
//			El curso es una taxonomia m s. Todavia no hay metodo para extraer esta informacion por lo que hay que hablar
//			con Nora para ver si hay que tener en cuenta esta taxonomia y crear un metodo para obtener la informacion
//			o desaparece. Despues hay que meterla en el publicador.
//			Dejamos de indexar el curso hasta hablar con Nora.
//			aniadeFieldaDocument(doc, props.getProperty("campo_curso"),
//					lomesPrimario.getCurso(), Field.Store.YES,Field.Index.UN_TOKENIZED,
//					Float.valueOf(props.getProperty("prioridad_por_defecto")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			aniadeFieldaDocument(doc, props.getProperty("campo_idiomaBusqueda"),
					lomesPrimario.getIdioma(), Field.Store.YES,Field.Index.UN_TOKENIZED,
					Float.valueOf(props.getProperty("weight_language_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
//			Por ahora sumamos el valor del peso del boost del campo nivel agregacion al valor del nivel agregacion
//			para que tenga mas prioridad cuanto mas nivel agregacion
			float valorPesoNivelAgregacion = Float.parseFloat(props.getProperty("prioridad_nivel_agregacion_primario")) * lomesPrimario.getNivelAgregacion().intValue();
			aniadeFieldaDocument(doc, props.getProperty("campo_nivelAgregacion"),
					lomesPrimario.getNivelAgregacion().toString(), Field.Store.YES, Field.Index.UN_TOKENIZED, 
					Float.valueOf(props.getProperty("prioridad_nivel_agregacion_primario")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);
			
			//TRATAMIENTO DEL PUBLICADOR
			aniadeFieldaDocument(doc, props.getProperty("campo_publicador"), 
					lomesPrimario.getPublicador(), Field.Store.YES, Field.Index.TOKENIZED, 
					Float.valueOf(props.getProperty("weight_publicador_primary")).floatValue(), DocumentoIndexacion.INDEXADO_NOR);

//			Le damos el peso al documento en general dependiendo del peso del nivel de agregacion
			doc.setBoost(Float.valueOf(""+valorPesoNivelAgregacion).floatValue());
		
		}

		return doc;
	}

	
	
	private static String[] obtenerFechaPublicacion(Date fecha) {

		String[] retorno = new String[2];		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatoHora = new SimpleDateFormat("HHmmss");
		
		retorno[0] = formatoFecha.format(fecha);		
		retorno[1] = formatoHora.format(fecha);		
		return retorno;
	}

	//M todo que divide los identificadores de areas curriculares
	public static String[] arrayString2ArrayStringAtomizado(String[] array, String split)
	{
		String[] arrayFinal=null;
		List concatenado = new ArrayList();
		for(int i=0; array != null && array.length > 0 && i<array.length; i++){
			arrayFinal=array[i].split(split);
			for(int j=0;arrayFinal != null && arrayFinal.length > 0 && j<arrayFinal.length && !arrayFinal[j].equals("");j++){
				concatenado.add(arrayFinal[j]);
			}
		}
		if (concatenado.size() > 0)
			return (String[])concatenado.toArray(new String[concatenado.size()]);
		else
			return new String[]{""};
		
	}
	
//	M todo que divide los identificadores de areas curriculares y solo se queda con el ultimo nodo
	private static String[] arrayString2ArrayStringAtomizadoUltimo(String[] array, String split)
	{
		if (array == null || array.length == 0)
			return new String[] {""};
//		Cada entrada del array de strings es un string con eltos separados por "split". Solo me quiero quedar con
//		el ultimo de la cadena.
		String[] arrayFinal=null;
		List concatenado = new ArrayList();
		for(int i=0; array != null && array.length > 0 && i<array.length; i++){
			arrayFinal=array[i].split(split);
			String ultimo = "";
//			Con esto recorremos todos los items y nos quedamos con el ultimo.
			for(int j=0;arrayFinal != null && arrayFinal.length > 0 && j<arrayFinal.length && !arrayFinal[j].equals("");j++){
				ultimo = arrayFinal[j];
			}
			concatenado.add(ultimo);
		}
		if (concatenado.size() > 0)
			return (String[])concatenado.toArray(new String[concatenado.size()]);
		else
			return new String[]{""};
		
	}
	
	private static String removeAccents(String[] string){
		logger.debug("removeAccents String[]: Comienzo concatenacion array");
    	String salida = "";
    	if (string!=null && string.length >0) {
    		String[] array = string;
	    	for (int i = 0; i < array.length; i++) {
	    		if (salida.equals("")) salida = array[0];
	    		else salida=salida + " " + array[i];	    			
			}
    	}
    	logger.debug("removeAccents String[]: Se van a eliminar acentos");
    	return removeAccents(salida);
    }
	
	private static String removeAccents(String s){
		try {
			logger.debug("DocumentoIndexacion - removeAccents: Eliminar acentos para="+s);
            s = s.replaceAll( "[ÂÀÄÁÃ]", "A" );
            s = s.replaceAll( "[ÊÈËÉ]", "E" );
            s = s.replaceAll( "[ÎÌÏÍ]", "I" );
            s = s.replaceAll( "[ÔÒÖÓÕ]", "O" );
            s = s.replaceAll( "[ÛÙÜÚ]", "U" );
            s = s.replaceAll( "Ç", "C" );
            s = s.replaceAll( "[àâäá]", "a" );
            s = s.replaceAll( "[éèêë]", "e" );
            s = s.replaceAll( "[ïîìí]", "i" );
            s = s.replaceAll( "[ôöòóõ]", "o" );
            s = s.replaceAll( "[ûüùú]", "u" );
            s = s.replaceAll( "ç", "c" );
			logger.debug("DocumentoIndexacion - removeAccents: Acentos eliminados="+s);
			return s;
		} catch ( Exception ex ) {
			logger.error("DocumentoIndexacion - removeAccents: Error generando claves con Normalizer, para cadena="+s, ex);
			return "";
		}
		
		
	}
}
