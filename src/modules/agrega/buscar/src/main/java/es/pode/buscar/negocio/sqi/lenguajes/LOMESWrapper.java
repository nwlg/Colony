/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.sqi.lenguajes;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.buscar.negocio.buscar.servicios.LomEsVO;
import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LangStringAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.TechnicalAgrega;

public class LOMESWrapper {
	
	public final static String TRANSFORM_LOMES_TO_LOMESVO = "TRANSFORM_LOMES_TO_LOMESVO";
	public static final int PALABRAS_MAX=10;
	
	protected static Log logger = LogFactory.getLog(LOMESWrapper.class);

	/**
	 * Este metodo recibe un string con uno o varios documentos lomes concatenados y devuelve un
	 * array de VO's, resultado del parseo de los textos y mapeo de los textos al VO.
	 * @param lomes
	 * 			El lom que recibimos en texto plano
	 * @param transform
	 * 
	 * @return LomEsVO[]
	 * @throws Exception
	 */
	public static Object[] map(final String lomes, String transform) throws Exception
	{
//		TODO: hay que implementar el mapeo de strings de lomes a objetos de LomESVO
		if (TRANSFORM_LOMES_TO_LOMESVO.equals(transform)){			
			return mapToLomEsVO(lomes);
		}
		else
			return null;
	}
	
	/**
	 * Metodo para obtener el titulo, la descripcion y la localizacion del lom e insertarlos en un LomEsVO
	 * @param lomes
	 * 			El lom que recibimos en texto plano
	 * @return LomEsVO[]
	 * @throws Exception
	 */
	public static LomEsVO[] mapToLomEsVO(String lomes) throws Exception {
			
		try {//Vamos a ver cuando empieza y cuando acaba cada lom,y iremos insertandolo en un array
			int j=0;
			ArrayList<String> lomsArray=new ArrayList();
			int longitud = lomes.length();
//			if(logger.isDebugEnabled())
//				logger.debug("Todos los lom-es ["+lomes+"] ");
			while( j<longitud){
				int inicio=lomes.indexOf(LOMWrapper.INICIO_LOM);
				if(logger.isDebugEnabled())
					logger.debug("Indice de <lom ["+inicio+"]");
				int fin=lomes.indexOf(LOMWrapper.FIN_LOM);
				if(logger.isDebugEnabled())
					logger.debug("Indice de </lom> ["+fin+"]");
				lomsArray.add(lomes.substring(inicio, fin+LOMWrapper.FIN_LOM.length()));
//				if(logger.isDebugEnabled())
//					logger.debug("El lom ["+lomes.substring(inicio, fin+LOMWrapper.FIN_LOM.length())+"]");
				if(fin+LOMWrapper.FIN_LOM.length()<lomes.length()){
					lomes=lomes.substring(fin+LOMWrapper.FIN_LOM.length());
					j=fin+LOMWrapper.FIN_LOM.length();
				}else{
					if(logger.isDebugEnabled())
						logger.debug("Nos hemos pasado");
					j=longitud;
					lomes="";
				}
	
			}
			String[] loms=(String[])lomsArray.toArray(new String[lomsArray.size()]); 
			ArrayList arrayLom=new ArrayList();// y </lom>
etiqueta:	for(int i=0;i<loms.length && loms[i]!= null && !loms[i].equals("");i++){
//				Mapeo el lom a clases del parseador de agrega
				LomAgrega lomAgrega;
				try {
					lomAgrega = parseStringToLomAgrega(loms[i]);
				} catch (RuntimeException e) {
					logger.error("Error al parsear el lom-es"+i+" ["+loms[i]+"]");
					continue etiqueta; // si casca el parseo continuo con el siguiente lom.
				}
//				Implementamos la logica de mapeos a objetos Agrega.
//				Tomamos la decisión de si echamos en falta algún dato dentro del lom, lo mapeamos o no:
//				- Sin localizacion no hay nada que hacer
//				- Sin titulo: 
//					-Si hay descripcion ponemos las n primeras palabras de la descripcion como titulo
//					-Si no hay descripcion ponemos la lozalizacion como titulo y sin descripcion  
				if(lomAgrega!=null ){//El lom parseado no puede ser nulo
					TechnicalAgrega tecnical = lomAgrega.getTechnicalAgrega();
					
					if(tecnical!=null){//El tecnical no puede ser nulo
						ArrayList localizaciones = tecnical.getLocalizacionAv();
						if(localizaciones!=null && localizaciones.size()>0){
							String localizacion=localizaciones.get(0).toString();
							if(localizacion!=null && !localizacion.equals("")){//La localizacion no puede ser nula, si lo es deshechamos el lom
								LomEsVO lomVuelta=new LomEsVO();
								lomVuelta.setLocalizacion(localizacion);
								GeneralAgrega general = lomAgrega.getGeneralAgrega();
								if(general!=null){
									ArrayList titulos=general.getTitulosAv();
									ArrayList descripciones=general.getDescripcionesAv();
									if(titulos!=null && titulos.size()>0){
										LangStringAgrega titulo = (LangStringAgrega)(titulos.get(0));
										if(titulo!=null && !titulo.equals("")){
											String tit=titulo.getValor();
											lomVuelta.setTitulo(tit);
											if(logger.isDebugEnabled())
												logger.debug("Insertamos el titulo que hemos recogido del parseo,["+tit+"]");
											if(descripciones!=null && descripciones.size()>0){
												ArrayList<LangStringAgrega> descripcions=(ArrayList) (descripciones.get(0));
												if(descripcions!=null && descripcions.size()>0){													
													LangStringAgrega descripcion=(LangStringAgrega)descripcions.get(0);
													if(descripcion!=null && !descripcion.equals("")){
														String desc=descripcion.getValor();
														lomVuelta.setDescripcion(desc);
														if(logger.isDebugEnabled())
															logger.debug("Insertamos la descripcion que hemos recogido del parseo,["+desc+"]");
													}else{
														if(logger.isDebugEnabled())
															logger.debug("No tenemos descripcion, ["+descripcion+"], lo dejamos vacio");
														lomVuelta.setDescripcion("");
													}
												}else{
													lomVuelta.setTitulo(localizacion);
													lomVuelta.setDescripcion("");
													if(logger.isDebugEnabled())
														logger.debug("La descripcion es nula o esta vacia, ["+descripcions+"],al no tener ni titulo ni descripcion insertaremos la localizacion y la descripcion se quedara vacia");
												}
											}else{//no tenemos ni titulo ni descripcion; Le insertamos la localizacion en el titulo
												lomVuelta.setTitulo(localizacion);
												lomVuelta.setDescripcion("");
											}
										}else{
											logger.error("El titulo es nulo, o esta vacio ["+titulo+"]");
											if(descripciones!=null && descripciones.size()>0){
												ArrayList<LangStringAgrega> descripcions=(ArrayList) (descripciones.get(0));
												if(descripcions!=null && descripcions.size()>0){													
													LangStringAgrega descripcion=(LangStringAgrega)descripcions.get(0);
													if(descripcion!=null && !descripcion.equals("")){//Si no trae titulo, le metemos las primeras 10 palabras de la descripcion(o toda la descripcion si no llega a las 10 palabras)
														String desc=descripcion.getValor();
														String descr=obtenerTituloDeDescripcion(desc);
														lomVuelta.setTitulo(descr);
														lomVuelta.setDescripcion(desc);
														if(logger.isDebugEnabled())
															logger.debug("Insertamos las primeras "+PALABRAS_MAX+" palabras de la descripcion en el titulo, el titulo se quedaria ["+descr+"]; y la descripcion entera en la descripcion ["+desc+"]");
													}else{
														lomVuelta.setTitulo(localizacion);
														lomVuelta.setDescripcion("");
														if(logger.isDebugEnabled())
															logger.debug("La descripcion es nula o esta vacia, ["+descripcion+"],al no tener ni titulo ni descripcion insertaremos la localizacion y la descripcion se quedara vacia");
													}
												}else{
													lomVuelta.setTitulo(localizacion);
													lomVuelta.setDescripcion("");
													if(logger.isDebugEnabled())
														logger.debug("La descripcion es nula o esta vacia, ["+descripcions+"],al no tener ni titulo ni descripcion insertaremos la localizacion y la descripcion se quedara vacia");
												}
											}else{//no tenemos ni titulo ni descripcion; Le insertamos la localizacion en el titulo
												lomVuelta.setTitulo(localizacion);
												lomVuelta.setDescripcion("");
												if(logger.isDebugEnabled())
													logger.debug("Las descripciones son nulas, o no tienen longitud, ["+descripciones+"].No tenemos no titulo ni descripcion, por lo que en el titulo insertaremos la localizacion y la descripcion se quedara vacia");
											}
										}
									}else{//No tenemos titulo
										if(logger.isDebugEnabled())
											logger.debug("Los titulos son nulos, o no tiene longitud ["+titulos+"]");
										if(descripciones!=null && descripciones.size()>0){
											ArrayList<LangStringAgrega> descripcions=(ArrayList) (descripciones.get(0));
											if(descripcions!=null && descripcions.size()>0){													
												LangStringAgrega descripcion=(LangStringAgrega)descripcions.get(0);
												if(descripcion!=null && !descripcion.equals("")){//Si no trae titulo, le metemos las primeras 10 palabras de la descripcion(o toda la descripcion si no llega a las 10 palabras)
													String desc=descripcion.getValor();
													String descr=obtenerTituloDeDescripcion(desc);
													lomVuelta.setTitulo(descr);
													lomVuelta.setDescripcion(desc);
													if(logger.isDebugEnabled())
														logger.debug("Insertamos las primeras "+PALABRAS_MAX+" palabras de la descripcion en el titulo, el titulo se quedaria ["+descr+"]; y la descripcion entera en la descripcion ["+desc+"]");
												}else{
													if(logger.isDebugEnabled())
														logger.debug("La descripcion es nula o esta vacia, ["+descripcion+"],al no tener ni titulo ni descripcion insertaremos la localizacion y la descripcion se quedara vacia");
													lomVuelta.setTitulo(localizacion);
													lomVuelta.setDescripcion("");
												}
											}else{
												lomVuelta.setTitulo(localizacion);
												lomVuelta.setDescripcion("");
												if(logger.isDebugEnabled())
													logger.debug("La descripcion es nula o esta vacia, ["+descripcions+"],al no tener ni titulo ni descripcion insertaremos la localizacion y la descripcion se quedara vacia");
											}
										}else{//no tenemos ni titulo ni descripcion; Le insertamos la localizacion en el titulo
											if(logger.isDebugEnabled())
												logger.debug("Las descripciones son nulas, o no tienen longitud, ["+descripciones+"].No tenemos no titulo ni descripcion, por lo que en el titulo insertaremos la localizacion y la descripcion se quedara vacia");
											lomVuelta.setTitulo(localizacion);
											lomVuelta.setDescripcion("");
										}
									}
									
								}else{//Si no hay ni titulo ni descripcion, sin descripcion y en el titulo la localizacion
									if(logger.isDebugEnabled())
										logger.debug("No tenemos general, por lo que en le titulo insertaremos la localizacion y la descripcion quedara vacia");
									lomVuelta.setDescripcion("");
									lomVuelta.setTitulo(localizacion);
								}
								arrayLom.add(lomVuelta);
							}else{
								logger.error("Error, la localizacion es nula, o esta vacia");
							}
						}else{
							logger.error("Error, las localizaciones son nulas, o no tiene longitud ["+localizaciones+"]");
						}
					}else{
						logger.error("Error, el technical es nulo");
					}
				}else{
					logger.error("Error, el lomAgrega es nulo");
				}
			}
			LomEsVO[] lomesVuelta=(LomEsVO[])arrayLom.toArray(new LomEsVO[arrayLom.size()]);
			return lomesVuelta;
			
		} catch (ParseadorException e) {
			throw new Exception("Error en mapToLomEsVO con lomes ["+lomes+"]", e);
		}
		
	}
	
	/*
	 * Este metodo recibe un String con un lom-es y lo parsea mapeando el xml a clases del estilo del LomAgrega
	 * para su posterior manipulación.
	 * */
	private static LomAgrega parseStringToLomAgrega(String lom) throws Exception
	{
		try {
			LomESDao lomesDAO=new LomESDao();
			List lista = new ArrayList();
			lista.add("dozerMappings.xml");
			lomesDAO.setBeanMapper(new net.sf.dozer.util.mapping.DozerBeanMapper(lista));
			
			Lom lomES = lomesDAO.parsearLom(new StringReader(lom));
			return new LomAgrega(lomES);
		} catch (RuntimeException e) {
			throw new Exception("Error parseando LOM-ES ["+lom+"].",e);
		}
	}
	
	/*Este metodo recibe un String y lo acorta a n palabras, y si es más corta que n palabras lo deja como estaba.
	 * 
	 * */
	private static String obtenerTituloDeDescripcion(String descripcion) throws Exception{//Le pasamos la descripcion y vamos a recuperarlo para titulo, con la 5 primeras palabras
		String[] descripcionArray=descripcion.split(" ");//o si no contiene 5 palabras, toda la descripcion
		String tituloCorto="";
		try{
			if(descripcionArray.length>PALABRAS_MAX){
				for(int i=0;i<PALABRAS_MAX;i++){
					tituloCorto=tituloCorto+descripcionArray[i];
				}
				if(logger.isDebugEnabled()){
					logger.debug("La descripcion tiene mas de ["+PALABRAS_MAX+"] palabras, la descriprion es ["+descripcion+"], y el titulo queda ["+tituloCorto+"]");
				}
			}else{	
				tituloCorto=descripcion;
				if(logger.isDebugEnabled()){
					logger.debug("La descipcion tiene menos de ["+PALABRAS_MAX+"] palabras, la descriprion, y en este caso el titulo, es ["+descripcion+"]");
				}
			}
		}catch(Exception e){
			logger.error("Error en obtenerTituloDeDescripcion con el texto ["+descripcion+"]");
			throw new Exception("Error en obtenerTituloDeDescripcion con el texto ["+descripcion+"]");
		}
		return tituloCorto;
	}
}
