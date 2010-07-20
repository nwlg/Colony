/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios.configuracion;



import java.io.StringWriter;

import org.apache.log4j.Logger;

import es.pode.modificador.negocio.servicio.TaxonVO;
import es.pode.modificador.negocio.servicio.TaxonomiaVO;
import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.castor.Classification;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.ClassificationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;

public class GeneradorTaxonomias {
	private ModificadorProperties props = null;
	private LomESDao lomesDao = null;
	private static final String TAXONOMIA_ETB = "taxonomias.ETB.source";
	private static final String TAXONOMIA_ARBOL = "taxonomias.arbolcurricular.source";
	public static final int ARBOL_CURRICULAR = 0;
	public static final int ETB = 1;
	private static final Logger logger = Logger.getLogger(GeneradorTaxonomias.class);
	/**
	 * @return the lomesDao
	 */
	public LomESDao getLomesDao() {
		return lomesDao;
	}

	/**
	 * @param lomesDao the lomesDao to set
	 */
	public void setLomesDao(LomESDao lomesDao) {
		this.lomesDao = lomesDao;
	}

	/**
	 * @return the props
	 */
	public ModificadorProperties getProps() {
		return props;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(ModificadorProperties props) {
		this.props = props;
	}
	
	/**
	 * Genera el XML correspondiente a un taxonPath para añadir un arbol
	 * curricular o un ETB
	 * 
	 * @param taxonomia
	 * @return
	 */
	public String generarTaxonomia(TaxonomiaVO taxonomia, int tipo) {
		String result = null;
		
		Lom lom = new Lom();
		LomAgrega lomAgr = new LomAgrega(lom);
		Classification classif = new Classification();
		ClassificationAgrega ca = new ClassificationAgrega(classif);
		try {
			if(logger.isDebugEnabled()) logger.debug("llamada a generarTaxonomia con tipo = " + tipo);
			// Compongo un classification
			ca.setProposito("discipline");
			String source = null;
			if(tipo == ARBOL_CURRICULAR) source = props.getProperty(TAXONOMIA_ARBOL);
			else if(tipo == ETB) source = props.getProperty(TAXONOMIA_ETB);
			ca.setFuente(0, taxonomia.getIdioma(), source);
			TaxonVO[] taxones = taxonomia.getTaxonPath();
			for(int i=0;i<taxones.length;i++) {
				ca.addTaxon(0, taxones[i].getId(), taxones[i].getValorTax(), taxonomia.getIdioma());
			}
			lomAgr.addClassificationAgrega(ca);
			// Escribo el XML
			StringWriter writer = new StringWriter();
			lomesDao.escribirLom(lom, writer);
			String tmp = writer.toString();
			int first = tmp.indexOf("<taxonPath");
			int last = tmp.indexOf("</taxonPath>")+12;
			result=tmp.substring(first, last);
		} catch (Exception e) {
			logger.error("Error generando la taxonomia (" + e.getMessage()+")");
			if(logger.isDebugEnabled()) logger.debug(e);
		}
		if(logger.isDebugEnabled()) logger.debug("Termina generarTaxonomia (tipo="+tipo+") con resultado \n" + result);
		return result;
	}
	
}
