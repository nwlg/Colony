/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscador.presentacion.basico.listar;


import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;

public class ListarAreaCurricularColumDecorator implements DisplaytagColumnDecorator {

	
	private final static String SLIDE = "/";
	private final static String SPACE = " ";
	private final static int LONGITUD_AREA_CURRICULAR = 120;
	
	/* (non-Javadoc)
	 * @see org.displaytag.decorator.ColumnDecorator#decorate(java.lang.Object)
	 */
	
	
	public Object decorate(Object arg0, javax.servlet.jsp.PageContext pageContext, org.displaytag.properties.MediaTypeEnum media) throws DecoratorException {
		
//		Obtenemos el area curricular de la fila que estamos tratando. Este valor contiene un string[] con todas las 
//		areas curriculares.
//		Suponemos que el objeto que le pasan es ya el objeto que tengo que decorar, en este caso un string[]
		return concatenaArrayString((String[]) arg0);
	}
	
	
	private String concatenaArrayString(String[] string)
	{
		StringBuilder salida = new StringBuilder();
		salida.append("- ");
		StringBuilder areaCurricular = new StringBuilder();
		
		if (string!=null && string.length >0) {
	    	for (int i = 0; i < string.length; i++) {
	    		String[] areas = string[i].split(SLIDE);
	    		for (int k = 0; k < areas.length; k++) {
		    		String[] array = areas[k].split(SPACE);
		    		for(int j = 0; j < array.length; j++) {
		    			int primero=j;
	    				if (primero==0){
	    					areaCurricular.append(array [j]);
	    				}else{
	    					areaCurricular.append(SPACE);
	    					areaCurricular.append(array [j]);
	    				}
		    		}
		    		if (k != areas.length-1){
                        areaCurricular.append(SLIDE);
		    		}
	    		}
	    		if (i != string.length-1){
	    			salida.append(areaCurricular);
    				salida.append("<BR>");
    				areaCurricular = new StringBuilder();
    				areaCurricular.append("- ");
	    		}
	    	}
	    	if (!areaCurricular.equals("- ")){
	    		salida.append(areaCurricular);
	    	}
		}
		if (salida.equals("- ")){
			salida.delete(0, salida.length()-1);
			salida.append("");
		}
		return salida.toString();
	}

}






