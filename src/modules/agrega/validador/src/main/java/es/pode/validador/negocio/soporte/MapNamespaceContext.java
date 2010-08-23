/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.validador.negocio.soporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

public class MapNamespaceContext implements NamespaceContext {
	
	private Map prefixes2uris = new HashMap();
	
	public MapNamespaceContext() {
		
	}
	
	public MapNamespaceContext( String prefix, String uri ) {
		addMapping(prefix, uri);
	}

	public MapNamespaceContext( Map mappings ) {
		addMappings(mappings);
	}
	
	public void addMapping( String prefix, String uri ) {
		
		prefixes2uris.put(prefix, uri);
		
	}
	
	public void addMappings( Map mappings ) {
		prefixes2uris.putAll(mappings);
	}
	
	public String getNamespaceURI(String prefix) {
		
		String result = (String)prefixes2uris.get(prefix);
		
		if( result == null )
			result = XMLConstants.NULL_NS_URI;
		
		return result;
	}

	public String getPrefix(String uri) {
		
		for (Iterator iterator = prefixes2uris.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			
			String prefix = (String) entry.getKey();
			if( uri.equals(entry.getValue()))
				return prefix;
		}
		
		
		
		return XMLConstants.DEFAULT_NS_PREFIX;
	}

	public Iterator getPrefixes(String uri) {
		
		List list = new ArrayList();
		
		for (Iterator iterator = prefixes2uris.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			
			String prefix = (String) entry.getKey();
			if( uri.equals(entry.getValue()))
				list.add( prefix );
		}
		
		return list.iterator();
	}

}
