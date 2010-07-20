/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.indexador.negocio.soporte;

import org.apache.log4j.Logger;
import org.apache.lucene.util.PriorityQueue;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;

import es.pode.indexador.negocio.servicios.busqueda.PalabraClaveVO;
import es.pode.indexador.negocio.servicios.busqueda.ParamPalabrasClave;
import es.pode.indexador.negocio.servicios.busqueda.PrioridadPalabrasClaveVO;
import es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceImpl;

public class HighFreqTerms {
	private static Logger logger = Logger.getLogger(HighFreqTerms.class);
	
	public static PrioridadPalabrasClaveVO obtenerPalabrasClave(ParamPalabrasClave paramBusq, String indexPath) throws Exception {
		if(logger.isDebugEnabled())logger.debug("HighFreqTerms - obtenerPalabrasClave");
		PrioridadPalabrasClaveVO resultado = new PrioridadPalabrasClaveVO();
		try {
			Directory directory = FSDirectory.getDirectory(indexPath);
			IndexReader reader = IndexReader.open(directory);

			TermInfoQueue tiq = new TermInfoQueue(paramBusq.getNumeroResultados().intValue()+1);
			TermEnum terms = reader.terms();

			int minFreq = 0;
			int tamanio = 0;
			while (terms.next()) {
				if (terms.docFreq() >= minFreq && terms.term().field().equals("keyword") && !stopWord(new TermInfo(terms.term(), terms.docFreq()).term.text().trim().toLowerCase(),SrvBuscadorServiceImpl.props.getProperty("hightFreqTerms.stopWords." + paramBusq.getIdiomaBusqueda()).trim().split(SrvBuscadorServiceImpl.SEPARADOR_STOP_WORDS))) {
					tiq.put(new TermInfo(terms.term(), terms.docFreq()));
					if (tiq.size() == paramBusq.getNumeroResultados().intValue()+1) {		  // if tiq overfull
						tiq.pop();				  // remove lowest in tiq
						minFreq = ((TermInfo)tiq.top()).docFreq; // reset minFreq
					}else tamanio++;
				}
			}
			PalabraClaveVO[] palabrasClave = new PalabraClaveVO[(tamanio>=paramBusq.getNumeroResultados().intValue())?paramBusq.getNumeroResultados().intValue():tamanio];
			for(int i = (tamanio>=paramBusq.getNumeroResultados().intValue())?paramBusq.getNumeroResultados().intValue()-1:tamanio-1; i >= 0; i--) {
				PalabraClaveVO palabraClave = new PalabraClaveVO();
				TermInfo termInfo = (TermInfo)tiq.pop();
				palabraClave.setPalabraClave(termInfo.term.text());
				palabraClave.setRanking(new Integer(termInfo.docFreq));
				palabrasClave[i]=palabraClave;
				if(logger.isDebugEnabled())logger.debug(termInfo.term + " " + termInfo.docFreq);
			}
			resultado.setPalabrasClave(palabrasClave);
			reader.close();
			directory.close();
			return resultado;
		} catch (Exception e) {
			Exception exc = new Exception(" caught a " + e.getClass() + "\n with message: ",e);
			logger.error(exc);
			throw exc;
		}
	}
	
	private static boolean stopWord(String campo, String[] stopWords) {
		for(int i = 0 ; i < stopWords.length ; i++) if(stopWords[i].equals(campo)) return true;
		return false;
	}
}

final class TermInfo {
	TermInfo(Term t, int df) {
		term = t;
		docFreq = df;
	}
	int docFreq;
	Term term;
}

final class TermInfoQueue extends PriorityQueue {
	TermInfoQueue(int size) {
	    initialize(size);
	}
	
	protected final boolean lessThan(Object a, Object b) {
		TermInfo termInfoA = (TermInfo)a;
		TermInfo termInfoB = (TermInfo)b;
		return termInfoA.docFreq < termInfoB.docFreq;
	}
}
