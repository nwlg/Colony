/* Agrega es una federaci n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut nomas propiedad de Red.es. Este c digo ha sido desarrollado por la Entidad P blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav s de la Secretar a de Estado de Telecomunicaciones y para la Sociedad de la Informaci n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci n y de Convergencia con Europa y entre Comunidades Aut nomas y Ciudades Aut nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006  Sociedad de la Informaci n 

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.publicacion.negocio.soporte;

import es.pode.parseadorXML.lomes.lomesAgrega.IdentificadorAgrega;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.Logger;

import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.indexador.negocio.servicios.indexado.IdODEVO;
import es.pode.indexador.negocio.servicios.indexado.LomESSecundarioVO;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.AccesoAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.AnnotationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.ClassificationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.EducationalAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LangStringAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LifeCycleAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RecursoAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RelationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RightsAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.TechnicalAgrega;
import es.pode.publicacion.negocio.servicios.SrvPublicacionServiceImpl;
import es.pode.soporte.utiles.date.DateManager;



public class TratamientoIndexacion {
// an loga a documento indexaci n, cuando termine la migraci n borrar
	
	private static Logger logger = Logger.getLogger(TratamientoIndexacion.class);
	public static String INDEXACION_SEPARATOR = "-";
	public static String AMBITO_UNIVERSAL = "universal";
	public static String AMBITO_NON_UNIVERSAL = "non-universal";
	private static final String IDENTIFICADOR_NODO = "server.id";
	
	//tokeniza un list de strings de strings
	
//	public static IdODEVO RellenarCamposPrincipales(IdODEVO idODEVOdoc, Lom lomes, SrvTaxonomiaService taxonomias, SrvNodoService nodos, SrvTesaurosServices tesauros)
	public static IdODEVO RellenarCamposPrincipales(IdODEVO idODEVOdoc, Lom lomes, SrvTaxonomiaService taxonomias, String[] nodosLocales, SrvTesaurosServices tesauros)
		throws Exception 
	{
		if (lomes == null)
		{
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("ERROR: RellenarCamposPrincipales imposible utilizar lom-es vacio para extraer informacion de indexacion con lomes["+null+"]");
			throw new Exception("ERROR: RellenarCamposPrincipales imposible utilizar lom-es vacio para extraer informacion de indexacion con lomes["+null+"]");
		}
		LomAgrega lomAg = new LomAgrega(lomes);
		GeneralAgrega generalAgrega = lomAg.getGeneralAgrega();
		String idioma = new String(); //idioma de catalogacion
		if (generalAgrega != null)
		{
//			TITULO
//			Indexamos el titulo que est  en el idioma de catalogaci n, si no hay el primer titulo 
//			de la lista de titulos que haya en el lomes, si no vac o.

			String titulo=new String();
			
			idioma = lomAg.getMetaMetadataAgrega().getIdioma();
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("idioma = " + idioma + " generalAgrega.getTitulo(idioma)= " + generalAgrega.getTitulo(idioma));
			if (generalAgrega.getTitulo(idioma).length()>0)
			{
				titulo=generalAgrega.getTitulo(lomAg.getMetaMetadataAgrega().getIdioma());
				logger.debug("titulo de catalogacion");
			}
			else{
				titulo = generalAgrega.getTitulos()!= null && generalAgrega.getTitulos().size() >0?
					(String)generalAgrega.getTitulos().get(0):"";  //indexamos el primer titulo
			}
			idODEVOdoc.getCatalogacionPrimaria().setTitulo(titulo);
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con titulo["+titulo+"]");
			
//			DESCRIPCION
//			Extraemos todas las descripciones pero solo indexamos la primera
//			TODO: Indexamos DESCRIPCIONES?
			String descripcion = (generalAgrega.getDescripciones()!= null && generalAgrega.getDescripciones().size() >0)?
					(String)generalAgrega.getDescripciones().get(0):
						"";// extraemos la primera descripcion.
			idODEVOdoc.getCatalogacionPrimaria().setDescripcion(descripcion);
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con descripcion["+descripcion+"]");
			
//			PALABRAS CLAVE
//			Cogemos todas las palabras clave independientemente del idioma en el que esten escritas.
			ArrayList palabrasClave = generalAgrega.getPalabrasClave();
			idODEVOdoc.getCatalogacionPrimaria().setPalabrasClave(arrayListString2ArrayStringUnique(palabrasClave,","));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con palabras clave["+arrayList2String(palabrasClave,"|")+"]");
			
//			NIVEL AGREGACION
			Integer nivelAgregacion;
			try {
				nivelAgregacion = new Integer(generalAgrega.getNivelDeAgregacion());
			} catch (Exception e) {
				nivelAgregacion = new Integer(1);// por defecto sera 1
				if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("ERROR: RellenarCamposPrincipales el campo nivel agregacion["+generalAgrega.getNivelDeAgregacion()+"] no es un entero valido. Se utiliza valor por defecto [1].");
			}
			idODEVOdoc.getCatalogacionPrimaria().setNivelAgregacion(nivelAgregacion);
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con nivel agregacion["+nivelAgregacion.toString()+"]");
			
//			ALCANCE (NUEVO CAMPO NECESARIO PARA EL DUBLIN CORE)
			ArrayList alcanceListaUnica = new ArrayList();
			ArrayList alcance = generalAgrega.getAmbitos();
			alcanceListaUnica = arrayList2ArrayListUnica(alcance);
			idODEVOdoc.getCatalogacionPrimaria().setAlcance(arrayListString2ArrayString(alcanceListaUnica,","));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con alcance["+arrayList2String(alcanceListaUnica,"|")+"]");
			
		}			

		LifeCycleAgrega agLifeCycle = null;
		if ((agLifeCycle = lomAg.getLifeCycleAgrega()) != null)
		{
//			AUTOR
			ArrayList autores = agLifeCycle.getAutores();
			idODEVOdoc.getCatalogacionPrimaria().setAutor(arrayListString2ArrayString(autores,","));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con autores["+arrayList2String(autores,"|")+"]");

//			AUTHOR ORGANISATION
			ArrayList aOrgs = agLifeCycle.getAuthorOrganisations();
			idODEVOdoc.getCatalogacionPrimaria().setAuthorOrganisation(
					arrayListString2ArrayString(aOrgs, ","));
            
//			CONTENT PROVIDER
			ArrayList cProviders = agLifeCycle.getContentProviders();
			idODEVOdoc.getCatalogacionPrimaria().setContentProvider(
					arrayListString2ArrayString(cProviders, ","));
			
//			FECHA PUBLICACION
			String fecha = agLifeCycle.getFechaPublicacion();
			try
			{
				idODEVOdoc.getCatalogacionPrimaria().setFechaPublicacion(DateManager.dateToCalendar(fecha!= null?extraeFechaDate(fecha):new Date()));
			}catch(Exception e)
			{
				logger.error("Se produce la siguiente excepcion "+e);
				Date fechaActual = new Date();
				idODEVOdoc.getCatalogacionPrimaria().setFechaPublicacion(DateManager.dateToCalendar(fechaActual));
			}
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con fecha["+fecha+"]");
			
//			PUBLICADOR (NUEVO CAMPO NECESARIO PARA EL DUBLIN CORE)
			ArrayList publicadores = agLifeCycle.getPublicadores();
			idODEVOdoc.getCatalogacionPrimaria().setPublicador(arrayListString2ArrayString(publicadores,","));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con publicadores["+arrayList2String(publicadores,"|")+"]");
			
//			CONTRIBUIDOR   REVISOR (NUEVO CAMPO NECESARIO PARA EL DUBLIN CORE)
			ArrayList contribuidores = agLifeCycle.getRevisores();
			idODEVOdoc.getCatalogacionPrimaria().setContribuidor(arrayListString2ArrayString(contribuidores,","));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con contribuidores["+arrayList2String(contribuidores,"|")+"]");
		}

		TechnicalAgrega techAgr;
		if ((techAgr = lomAg.getTechnicalAgrega())!=null)
		{
//			FORMATOS
			ArrayList formatos = techAgr.getFormatos();
			idODEVOdoc.getCatalogacionPrimaria().setFormatos(arrayList2ArrayString(formatos));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con formatos["+arrayList2String(formatos,"|")+"]");
		}
		
		ClassificationAgrega[] clas = (ClassificationAgrega[])(lomAg.getClassificationsAgrega()).toArray(new ClassificationAgrega[lomAg.getClassificationsAgrega().size()]);
		if (clas != null && clas.length>0)
		{
			ArrayList arbolesCurriclares = new ArrayList();
			ArrayList tesaurosList = new ArrayList();
			ArrayList taxonPath = new ArrayList();
			String etiqueta = SrvPublicacionServiceImpl.getPropertyValue("nombreAreaCurricularTax");
			String arbolCurricularVigente = taxonomias.obtenerVocabName(etiqueta, idioma);
			logger.debug("Utilizamos la etiqueta de area curricular vigente["+arbolCurricularVigente+"]");
			String etiquetaTesauro = SrvPublicacionServiceImpl.getPropertyValue("nombreTesauroTax");
			String tesauroVigente = tesauros.obtenerVocabName(etiquetaTesauro, idioma);
			logger.debug("Utilizamos la etiqueta de tesauro vigente["+tesauroVigente+"]");
//			No hay niveles educativos por ahora
//			ArrayList nivelesEducativos = new ArrayList();
			for (int i = 0; i < clas.length; i++ )
			{
//				Cada objeto de classification agrega puede ser un tesauro o un arbol curricular. No lo podemos saber a priori, pero si hacemos
//				get de uno y de otro, solo nos dara valores para el que es
//				Cogemos todos los arboles curriculares independientemente del idioma en el que esten
//				Cogemos los tesauros
				ArrayList lista;
				if ((lista = clas[i].getIdsArbolesCurriculares(arbolCurricularVigente)) != null)// si introducimos null, casca
					arbolesCurriclares.addAll(lista);
				if ((lista = clas[i].getIdsTesauroETB(tesauroVigente)) != null)
					tesaurosList.addAll(lista);

				// Materialise the taxon paths for this classification element.
 				for (int j = 0; j < clas[i].getTaxonPathsCount(); j++) {
					// Get the list of IDs for each path.
					ArrayList ids = clas[i].getIdentificadores(j);
					if (ids.size() > 0) {
						// Use the last one to retrieve the entire taxon path
						// array via SrvTaxonomiaService.
						final TaxonVO[] tp = taxonomias.obtenerTaxonPath(
							(String)ids.get(ids.size() - 1), etiqueta, idioma);
						addTaxonPathToArrList(tp, taxonPath);
					}
				}

//				Los niveles educativos no se consultan por ahora
//				nivelesEducativos.addAll(tokeniza(clas[i].getIdsNivelesEducativos(lomAg.getMetaMetadataAgrega().getIdioma())));
			}
//			ARBOL CURRICULAR VIGENTE
			idODEVOdoc.getCatalogacionPrimaria().setArbolCurricularVigente(arbolCurricularVigente);
			
//			ARBOL CURRICULAR
			idODEVOdoc.getCatalogacionPrimaria().setArbolCurricular(arrayList2ArrayString(arbolesCurriclares));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con["+arbolesCurriclares.size()+"] arbol curricular["+arrayList2String(arbolesCurriclares,"|")+"]");
			
//			TESAUROS
			idODEVOdoc.getCatalogacionPrimaria().setTesauros(arrayList2ArrayString(tesaurosList));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con["+tesaurosList.size()+"] tesauro["+arrayList2String(tesaurosList,"|")+"]");

//			TAXON PATH
			idODEVOdoc.getCatalogacionPrimaria().setTaxonPath(
					arrayList2ArrayString(taxonPath));

//			NIVELES EDUCATIVOS
//			No hay niveles educativos por ahora.
//			idODEVOdoc.getCatalogacionPrimaria().setNivelesEducativos(arrayListString2ArrayString(nivelesEducativos,"/"));
//			TratamientoIndexacion.traza("Rellenamos LomESPrimarioVO con nivel educativo["+arrayList2String(nivelesEducativos,"|")+"]");
		}
		
		EducationalAgrega[] educa = (EducationalAgrega[])lomAg.getEducationalsAgrega().toArray(new EducationalAgrega[lomAg.getEducationalsAgrega().size()]);
		if (educa != null && educa.length>0)
		{
			ArrayList recursos = new ArrayList();
			ArrayList destinatarios = new ArrayList();
			ArrayList procesosCognitivos = new ArrayList();
			ArrayList contextos = new ArrayList();
			ArrayList edades = new ArrayList();
			ArrayList descripciones = new ArrayList();
			ArrayList typLearningTimes = new ArrayList();
			W3CDurationNDRBMapper dMapper = new W3CDurationNDRBMapper();
			
			for (int i = 0; i < educa.length; i++ )
			{
				ArrayList temp;
				if ((temp = educa[i].getTiposDeRecurso())!= null)
					recursos.addAll(temp);
				if ((temp = educa[i].getDestinatarios()) != null)
					destinatarios.addAll(temp);
				if ((temp = educa[i].getProcesosCognitivos()) != null)
					procesosCognitivos.addAll(temp);
				if ((temp = educa[i].getContextos()) != null)
					contextos.addAll(temp);
				if ((temp = educa[i].getRangosEdad()) != null)
					edades.addAll(temp);
				if((temp=educa[i].getDescripcionesAv()) !=null)
					descripciones.addAll(temp);
				
				// Store Typical Learning Time if not null
				String duration = educa[i].getTiempoTipicoAprendizajeAv().
					getDuracion();
				if (duration != null) {
					typLearningTimes.add(dMapper.toNDRBBucket(duration));
				}
			}
//			RECURSOS
			idODEVOdoc.getCatalogacionPrimaria().setRecurso(arrayList2ArrayString(recursos));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con recursos["+arrayList2String(recursos,"|")+"]");
//			DESTINATARIOS
			idODEVOdoc.getCatalogacionPrimaria().setDestinatarios(arrayList2ArrayString(destinatarios));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con destinatarios["+arrayList2String(destinatarios,"|")+"]");
//			PROCESOS COGNITIVOS
			idODEVOdoc.getCatalogacionPrimaria().setProcesosCognitivos(arrayList2ArrayString(procesosCognitivos));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con procesos cognitivos["+arrayList2String(procesosCognitivos,"|")+"]");
//			CONTEXTOS
			idODEVOdoc.getCatalogacionPrimaria().setContextos(arrayList2ArrayString(contextos));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con contextos["+arrayList2String(contextos,"|")+"]");
//			EDADES DE DESTINATARIOS
			idODEVOdoc.getCatalogacionPrimaria().setEdades(arrayList2ArrayString(edades));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con edades["+arrayList2String(edades,"|")+"]");
//			DESCRIPCIONES
			String[] descripcionesObjetivo =arrayLangString2Array(descripciones, idioma);
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con descripciones["+arrayString2String(descripcionesObjetivo,"|")+"]");
			idODEVOdoc.getCatalogacionPrimaria().setDescripciones(descripcionesObjetivo);
//			TYPICAL LEARNING TIMES
			String[] typicalLearningTimes = arrayList2ArrayString(
					typLearningTimes);
			idODEVOdoc.getCatalogacionPrimaria().setTypicalLearningTime(
					typicalLearningTimes);
		}

		RightsAgrega dere = lomAg.getRightsAgrega();
		if (dere != null)
		{
			String dereAutor;

			if ((dereAutor = dere.getDerechosDeAutor())!= null) {
//				DERECHOS DE AUTOR
				idODEVOdoc.getCatalogacionPrimaria().setLicencia(dereAutor!= null?dereAutor:"");
				if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con derechos de autor["+dereAutor+"]");
			}

			ArrayList couList;
			if ((couList = dere.getDescripcionesAv()) != null) {
//				CONDITIONS OF USE
				idODEVOdoc.getCatalogacionPrimaria().setConditionsOfUse(
						arrayLangString2Array(couList, idioma));
			}
		}
		
//		Ambito-Acceso(catalogacion)
		AccesoAgrega acc;
		if (dere != null && (acc = dere.getAccesoAv()) != null)
		{
			// solo vamos a indexar los nodos del ODE que esten en la lista de nodos locales.
			///////String[] nodosLocales = obtenNodosLocales(nodos);
			String[] ambito = obtenAmbito(acc, nodosLocales);
			idODEVOdoc.getCatalogacionPrimaria().setAmbito(ambito);
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con ["+ambito.length+"]ambito");
		}
//		IDIOMA CATALOGACION
		idioma = lomAg.getMetaMetadataAgrega().getIdioma();
		idODEVOdoc.getCatalogacionPrimaria().setIdioma(idioma);
		if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con idioma["+idioma+"]");		

		RelationAgrega[] relation = (RelationAgrega[])(lomAg.getRelationsAgrega()).toArray(new RelationAgrega[lomAg.getRelationsAgrega().size()]);
		
		if (relation != null && relation.length>0)
		{
			ArrayList relacion = new ArrayList();
			ArrayList fuente = new ArrayList();
			ArrayList reltypes = new ArrayList();
			ArrayList reldescs = new ArrayList();
			ArrayList relids = new ArrayList();
			
			for (int i = 0; i < relation.length; i++ )
			{
				String temporalRelacion, temporalFuente;
				
				if ((temporalFuente = relation[i].getIdentificadorMEC()) != null)				
					fuente.add(temporalFuente);	
				if ((temporalRelacion = relation[i].getTipoRelacionMEC()) != null)				
					relacion.add(temporalRelacion);					
				if (relation[i].getTipoAv() != null)
					reltypes.add(relation[i].getTipoAv());

				RecursoAgrega reca = relation[i].getRecursoAv();
				if (reca != null) {
					// The title of a related resource is mapped to the relation
					// description as per the NDRB spec "ndrb Indexed fields -
					// Relative weighting for arbitrary search.doc".
					if (reca.getDescripciones() != null) {
						reldescs.addAll(reca.getDescripciones());
					}

					// The identifier for a related resource is the entry
					// attribute as per the NDRB spec "ndrb Indexed fields -
					// Relative weighting for arbitrary search.doc".
					final IdentificadorAgrega id = reca.getIdentificador();
					if (id != null) {
						relids.add(id.getEntrada());
					}
				}
			}
			
//			FUENTE (NUEVO CAMPO CREADO PARA EL DUBLIN CORE)
			idODEVOdoc.getCatalogacionPrimaria().setFuente((arrayList2ArrayString(fuente)));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con fuente["+arrayList2String(fuente,"|")+"]");
			
//			RELACION (NUEVO CAMPO CREADO PARA EL DUBLIN CORE)
			idODEVOdoc.getCatalogacionPrimaria().setRelacion(arrayList2ArrayString(relacion));
			if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESPrimarioVO con relacion["+arrayList2String(relacion,"|")+"]");		

//			RELATION TYPE
			idODEVOdoc.getCatalogacionPrimaria().setRelationKind(
					arrayList2ArrayString(reltypes));

//			RELATED RESOURCE IDENTIFIER
			idODEVOdoc.getCatalogacionPrimaria().setRelatedResourceIdentifier(
					arrayList2ArrayString(relids));

//			RELATED RESOURCE TITLE
			idODEVOdoc.getCatalogacionPrimaria().setRelatedResourceTitle(
					arrayLangString2Array(reldescs, idioma));
		}

		ArrayList anns = lomAg.getAnnotationsAgrega();
		ArrayList annDescs = new ArrayList();
		
		// Collect descriptions of annotations
		if (anns != null) {
			for (int i = 0; i < anns.size(); i++) {
				addAnnotationToArrList((AnnotationAgrega)anns.get(i), annDescs);
			}

			//
			// Set the resource annotation with multiplicity behavior that is
			// consistent with that of the other description lang strings.
			//
			// See eg the Educational DESCRIPCIONES section and the arrayLang*()
			// methods in this file for more details.
			//
			idODEVOdoc.getCatalogacionPrimaria().setAnnotation(
					arrayString2String(
							arrayLangString2Array(annDescs, idioma), ", "));
		}
		
		return idODEVOdoc;
	}
	
	
	
	public static es.pode.indexador.negocio.servicios.indexado.IdODEVO RellenarCamposSecundarios(IdODEVO idODEVOdoc, Lom[] lomes) 
	throws Exception 
	{

		// antes de llamar aqu  se borra el primer lomes
			idODEVOdoc.setCatalogacionSecundaria(new LomESSecundarioVO[lomes!= null&& lomes.length>0?lomes.length:0]);
			if (lomes != null && lomes.length > 0)
			{
				for (int x = 0; lomes!= null && x < lomes.length; x++) 
				{
					GeneralAgrega generalAgrega= (new LomAgrega(lomes[x])).getGeneralAgrega();

					if (generalAgrega != null)
					{
						LomESSecundarioVO lomEsSecundario = new LomESSecundarioVO();
						
//						PALABRAS CLAVE
//						indexamos todas las palabras clave independientemente del idioma
						ArrayList palabrasClave = generalAgrega.getPalabrasClave();
						lomEsSecundario.setPalabrasClave(
								palabrasClave != null && palabrasClave.size()>0?(String[])palabrasClave.toArray(new String[palabrasClave.size()]):
									new String[]{""});
						if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESSecundarioVO["+x+"] con keywords["+arrayList2String(palabrasClave,"|")+"]");

//						TITULO
//						indexamos el primer titulo que salga del lomes independientemente del idioma
//						TODO: Indexamos TITULOS?
						String titulo = generalAgrega.getTitulos()!= null && generalAgrega.getTitulos().size() >0?
								(String)generalAgrega.getTitulos().get(0):"";  //indexamos el primer titulo
						lomEsSecundario.setTitulo(titulo);
						if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESSecundarioVO["+x+"] con titulo["+titulo+"]");

//						DESCRIPCION
//						Extraemos todas las descripciones pero solo indexamos la primera
//						TODO: indexamos DESCRIPCIONES?
						String descripcion = (generalAgrega.getDescripciones()!= null && generalAgrega.getDescripciones().size() >0)?
								(String)generalAgrega.getDescripciones().get(0):
									"";// extraemos la primera descripcion.
						lomEsSecundario.setDescripcion(descripcion);
						if(TratamientoIndexacion.logger.isDebugEnabled()) TratamientoIndexacion.logger.debug("Rellenamos LomESSecundarioVO["+x+"] con descripcion["+descripcion+"]");
						
//						Asignamos el lomes secundario en la posicion que toque
						idODEVOdoc.getCatalogacionSecundaria()[x] = lomEsSecundario;
					}
				}
			}
		
		return idODEVOdoc;
	}
	
	/**
	 * Helper method for adding description(s) for an AnnotationAgrega instance
	 * to an ArrayList.
	 */
	private static void addAnnotationToArrList(
			AnnotationAgrega agAnn, ArrayList annDescs) {

		if (agAnn != null) {
			ArrayList descs = agAnn.getDescripcionAv();
			if (descs != null)
				annDescs.addAll(descs);
		}
	}

	/**
	 * Helper method for adding a taxon path array to an ArrayList.
	 */
	private static void addTaxonPathToArrList(
			TaxonVO[] tp, ArrayList tpList) {
		assert tpList != null;
		// We dare not assume or assert anything about the return value of
		// another web service.
		if (tp != null) {
			// Add each taxonomy term value to tpList
			for (int i = 0; i < tp.length; i++) {
				tpList.add(tp[i].getValorTax());
			}
		}
	}

	//Este metodo recibe un arrayList de objeros y devuelve y arrayList
	private static ArrayList arrayList2ArrayListUnica(ArrayList listaEntrada)
	{
		ArrayList listaReturn = new ArrayList();
		
		if(listaEntrada != null && listaEntrada.size() > 0){
			ArrayList listaTemporal = new ArrayList();
			//Recorremos la lista
			for (int i = 0; i < listaEntrada.size(); i++)
			{
				if(listaEntrada.get(i) != null )
				{
					//Compramos si la posicion i de la lista es a su vez otra lista
					listaTemporal = (ArrayList)listaEntrada.get(i);
					if(listaTemporal.size() > 0)
					{					
						//Recorremos la lista secundaria
						for (int j=0; j < listaTemporal.size(); j++)
						{
							listaReturn.add(listaTemporal.get(j));
						}
					}					
				}
			}
		}
		
		return listaReturn;
	}

//	Este metodo recibe un arraylist de objetos y devuelve un array de strings con la representacion en string
//	de cada uno de los elementos del arraylist
	private static String[] arrayList2ArrayString(ArrayList array)
	{
		String[] sb = null;
		
		if (array != null && array.size() >0)
		{
			sb = new String[array.size()];
			for (int i = 0; i < array.size(); i++)
			{
				sb[i] = String.valueOf(array.get(i));
			}
		}
		if (sb != null)
			return sb;
		else
			return new String[]{""};
	}
	
//	Este metodo recibe un arraylist de arrays de strings o de objetos LangStringAgrega con caracteres separadores
//	y devuelve un array de strings con la representacion en string
//	de cada uno de los elementos del arraylist sin el caracter separador (split)
	private static String[] arrayListString2ArrayString(ArrayList array, String split)
	{
		ArrayList listaFinal = new ArrayList();
		
		if (array != null && array.size() >0)
		{
			String[] tiraSinBarras = null;
			for (int i = 0; i < array.size(); i++)
			{
				//Comprobando de dentro de la posicion hay otro arrayList
				if (array.get(i) instanceof java.lang.String)
					tiraSinBarras = ((String)array.get(i)).split(split);
				else if (array.get(i) instanceof es.pode.parseadorXML.lomes.lomesAgrega.LangStringAgrega)
				{
					tiraSinBarras = ((LangStringAgrega)array.get(i)).getValor().split(split);
				}
				for (int j = 0; tiraSinBarras != null && tiraSinBarras.length > 0 && j < tiraSinBarras.length;j++){
					if (!tiraSinBarras[j].equals(""))
						listaFinal.add(tiraSinBarras[j].trim());
				}
			}
		}
		if (listaFinal.size() > 0)
			return (String[])listaFinal.toArray(new String[listaFinal.size()]);
		else
			return new String[]{""};
	}
	
//	Este metodo recibe un arraylist de arrays de strings o de objetos LangStringAgrega con caracteres separadores
//	y devuelve un array de strings con la representacion en string
//	de cada uno de los elementos del arraylist sin el caracter separador (split). Se eliminan las repeticiones
//	del array devuelto
	private static String[] arrayListString2ArrayStringUnique(ArrayList array, String split)
	{
		HashSet listaFinal = new HashSet();
		
		if (array != null && array.size() >0)
		{
			String[] tiraSinBarras = null;
			for (int i = 0; i < array.size(); i++)
			{
				if (array.get(i) instanceof java.lang.String)
					tiraSinBarras = ((String)array.get(i)).split(split);
				else if (array.get(i) instanceof es.pode.parseadorXML.lomes.lomesAgrega.LangStringAgrega)
				{
					tiraSinBarras = ((LangStringAgrega)array.get(i)).getValor().split(split);
				}
				for (int j = 0; tiraSinBarras != null && tiraSinBarras.length > 0 && j < tiraSinBarras.length;j++){
					if (!tiraSinBarras[j].equals(""))
					{
						listaFinal.add(tiraSinBarras[j].trim());
					}
				}
			}
		}
		if (listaFinal.size() > 0)
			return (String[])listaFinal.toArray(new String[listaFinal.size()]);
		else
			return new String[]{""};
	}
	
	
//	Convierte una fecha en formato yyyy-MM-dd'T'hh:mm:ss.SS a formato YYYYMMDD
	private static String extraeFechaYYYYMMDD(String fecha)
	{
		String retorno = "";
		SimpleDateFormat formatoIn = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SS");
		SimpleDateFormat formatoOut = new SimpleDateFormat("yyyyMMdd");
		if (fecha != null && !fecha.equals(""))
		{
//			String[] lista = fecha.split("-");
//			if (lista!= null && lista.length == 3)
//				retorno+=lista[0]+lista[1]+lista[2];
			Date fechaDate = (Date)formatoIn.parse(fecha, new ParsePosition(0));
			retorno+= formatoOut.format(fechaDate);
		}
		return retorno;
	}
//	Lee una fecha en formato yyyy-MM-dd'T'hh:mm:ss.SS a Date
	private static Date extraeFechaDate(String fecha)
	{
		
		Date fechaDate = new Date();  // a las malas devuelvo hoy
		SimpleDateFormat formatoIn = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SS");
		if (fecha != null && !fecha.equals(""))
		{
			fechaDate = (Date)formatoIn.parse(fecha, new ParsePosition(0));
		}
		return fechaDate;
	}

	private static String arrayList2String(ArrayList array, String separator)
	{
		String sb = null;

		if (array != null && array.size() >0)
		{
			for (int i = 0; i < array.size(); i++)
			{
				if (i == array.size())
					sb+= String.valueOf(array.get(i));
				else
					sb+= String.valueOf(array.get(i)) + separator;
			}
		}
		if (sb != null)
			return sb;
		else
			return "";
	}
	
	private static String arrayString2String(String[] array, String separator)
	{
		String sb = "";
		
		if (array != null && array.length>0)
		{
			for (int i = 0; i < array.length; i++)
			{
				if (i == (array.length -1))
					sb+= String.valueOf(array[i]);
				else
					sb+= String.valueOf(array[i]) + separator;
			}
		}
		if (sb != null)
			return sb;
		else
			return "";
	}
	
	/*
	 * Este metodo recoge el contenido del ambito de la parte del lomes del ODE donde se almacena
	 * y recupera la informacion relevante para la indexacion*/
	private static String[] obtenAmbito(AccesoAgrega acc, String[] nodos)
	{
//		El ambito de un ODE puede tener dos valores: universal y non-universal. En el caso de la
//		primera, indexamos el texto universal y el caso del segundo tenemos que indexar el valor
//		de la descripcion en el que se expresan las CCAA que estan licenciadas en el ambito separa-
//		das por comas.
		String[] retorno = new String[0];
		if (acc.getTipoAcceso().equals(AMBITO_UNIVERSAL))
		{
			retorno = new String[] {AMBITO_UNIVERSAL};
		}
		else if (acc.getTipoAcceso().equals(AMBITO_NON_UNIVERSAL))
		{
//			Primero obtenemos las CCAA que hay disponibles en el nodo
			;
//			HashSet nodosTotal = new HashSet(Arrays.asList(DependentServerProperties.getInstance().getNodos().split(",")));
			HashSet nodosTotal = new HashSet(Arrays.asList(nodos));
//			Obtenemos los nodos que hay en el lom-es
			String[] lista = arrayListString2ArrayStringUnique(acc.getDescripcion(),",");
			HashSet nodosLeidos = new HashSet(Arrays.asList(lista));
			nodosLeidos.retainAll(nodosTotal);
//			nodosTotal.retainAll(); // eliminamos de los nodos totales los que no esten en la lista de los que hay en el LOM-ES
			retorno = (String[]) nodosLeidos.toArray(new String[0]);
		}
		else
		{
			retorno = new String[0];
		}
		if (logger.isDebugEnabled()) logger.debug("Ambitos leidos["+TratamientoIndexacion.arrayList2String(new ArrayList(Arrays.asList(retorno)), ",")+"]");
		return retorno;
	}

	/*
	 * Este metodo devuelve la lista de nodos locales que estan dados de alta en el nodo.
	 * */
	private static String[] obtenNodosLocales(SrvNodoService srvNodos) throws Exception
	{
		NodoVO[] nodos = srvNodos.listarNodos();
//		Obtenemos el nodo local y lo a adimos
		String[] nodosReturn = new String[((nodos!=null)?nodos.length+1:1)];
		nodosReturn[0] = DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO);
		for (int i = 1; i < nodosReturn.length; i++) {
			nodosReturn[i] = nodos[i-1].getIdNodo();
		}
		return nodosReturn;
	}
	
	//M todo para ordenar las descripciones, si existen descripciones con el idioma de catalogacion devolvemos esos; si no existen con el idioma de catalogacion
	//devolvemos los que no tienen idioma; y si no encuentra ningunos de esos dos caso se devuelven todas las descripciones
	private static String[] arrayLangString2Array(ArrayList array,String  idiomaMeta)
	{
		ArrayList listaReturn1 = new ArrayList();
		ArrayList listaReturn2 = new ArrayList();
		ArrayList listaReturn3 = new ArrayList();
		
		if (array != null && array.size() >0)
		{
			for (int i = 0; i < array.size(); i++)
			{
				
				LangStringAgrega langString=(LangStringAgrega)array.get(i);
				String idiomaDesc=langString.getIdioma();
				if(idiomaDesc!=null && !idiomaDesc.equals("") && idiomaDesc.equals(idiomaMeta)){
					listaReturn1.add(langString.getValor());
				}else if(idiomaDesc==null || idiomaDesc.equals("")){
					listaReturn2.add(langString.getValor());
				}else{
					listaReturn3.add(langString.getValor());
				}
		
			}
			if(listaReturn1!=null && listaReturn1.size()>0){
				return (String[])listaReturn1.toArray(new String[0]);
			}else if(listaReturn2 !=null && listaReturn2.size()>0){
				return (String[])listaReturn2.toArray(new String[0]);
				
			}
		}
		return (String[])listaReturn3.toArray(new String[0]);
	}
}

/**
 * W3CDurationNDRBMapper --
 *     W3C Duration => NDRB Duration Bucket
 * 
 * While parts of Agrega seem to not know* it stores content for elements such
 * as the "typical learning time" by using the W3C Duration data type:
 * 
 *     http://www.w3.org/TR/2001/REC-xmlschema-2-20010502/#duration
 * 
 * Per the "LOM NDRB implementation details document v1.0", this class maps a
 * Duration String to one of the following NDRB duration buckets:
 * 
 *     Less than 10 mins
 *     10-30 mins
 *     30 mins - 1 hour
 *     1-8 hours
 *     More than 8 hours
 * 
 * * -- eg see the manual parsing code in catalogadorWeb::TecnicaControllerImpl,
 *      or you'd much rather not.  :-)
 *
 * TODO: Factor this out as a Utility class.
 */
class W3CDurationNDRBMapper {

	/**
	 * Returns the NDRB duration bucket value for a W3C duration string.
	 * @param duration a W3C Duration <code>java.lang.String</code>
	 * @return the corresponding NDRB duration bucket value
	 * @throws java.text.ParseException if an invalid duration is provided
	 */
	public String toNDRBBucket(String duration) throws java.text.ParseException {
		if (duration == null)
			return null;

		// Convert to mins from the millisecs returned by Castor Duration
		long dmins = new org.exolab.castor.types.Duration(duration).toLong()
				/ SECS_X_MS;

		// Return the corresponding bucket title
		if (dmins < 10)
			return "Less than 10 mins";
		else if (dmins < 30)
			return "10-30 mins";
		else if (dmins < 60)
			return "30 mins - 1 hour";
		else if (dmins < (8 * 60))
			return "1-8 hours";
		else
			return "More than 8 hours";
	}

	private static final int SECS_X_MS = (60 * 1000);
}
