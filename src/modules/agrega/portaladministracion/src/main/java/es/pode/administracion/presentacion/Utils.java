/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.administracion.presentacion;

/**
 * @author dgonzalezd
 *
 */
public class Utils {
	
	
	static public String tidyEntities(String texto) {
		String LT="&lt;";
		String GT="&gt;";
		texto = searchEntity(texto, LT);
		texto = searchEntity(texto, GT);
		return texto;
	}

	static public String searchEntity(String texto, String entity) {
		int i=0;
		while (i!=-1&&i<texto.length()) {
			int index=texto.indexOf(entity, i);
			if (index!=-1) {
				String prev=texto.substring(0, index);
				String post=texto.substring(index+4);
				String wrapped = wrapEntity(texto, index, entity.length());
				texto=prev+wrapped+post;
				i = index + wrapped.length();
			} else {
				i=index;
			}
		}
		return texto;
	}
	
	static public String wrapEntity(String texto,int index, int entitylength) {
		String CDATA_init="<![CDATA[";
		String CDATA_end="]]>";

		String entity=texto.substring(index, index+entitylength);
		texto=CDATA_init+entity+CDATA_end;
		return texto;
	}
}
