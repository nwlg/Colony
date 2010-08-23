/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.indexador.negocio.soporte;

import org.apache.log4j.Logger;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.TermEnum;

import es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO;

public class NumTermsArbol {
	private static Logger logger = Logger.getLogger(NumTermsArbol.class);
	
	public static ResultadosCountVO obtenerNumeroNodos(String[] identificadores, String indexPath, String campo) throws Exception {
		if(logger.isDebugEnabled())logger.debug("NumTermsArbol - obtenerNumeroNodos");
		try {
			Directory directory = FSDirectory.getDirectory(indexPath);
			IndexReader reader = IndexReader.open(directory);

			TermEnum terms = reader.terms();
			ResultadosCountVO resultado = new ResultadosCountVO();
			resultado.setConteo(new Integer[identificadores.length]);
			int minFreq = 0;
			while (terms.next()) {
				if (terms.docFreq() >= minFreq && terms.term().field().equals(campo)) {
					for(int i = 0 ; i < identificadores.length; i++){
						if(identificadores[i]!=null && identificadores[i].equals(new TermInfo(terms.term(), terms.docFreq()).term.text().toUpperCase())){
							if(logger.isDebugEnabled())logger.debug("NumTermsArbol - obtenerNumeroNodos: terms.docFreq()="+terms.docFreq()+"   new TermInfo(terms.term(), terms.docFreq()).term.text()="+new TermInfo(terms.term(), terms.docFreq()).term.text());
							resultado.getConteo()[i]=new Integer(terms.docFreq());
							continue;
						}
					}
				}
			}
			int suma = 0;
			for(int i = 0 ; i < resultado.getConteo().length; i++){
				if(resultado.getConteo()[i]==null) resultado.getConteo()[i]=new Integer(0);
				else suma = suma + resultado.getConteo()[i].intValue();
			}
			resultado.setDocumentosCount(new Integer(suma));
			return resultado;
		} catch (Exception e) {
			Exception exc = new Exception(" caught a " + e.getClass() + "\n with message: ",e);
			logger.error(exc);
			throw exc;
		}
	}
}

