/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.presentacion.decorators;

import java.util.ResourceBundle;
import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;

// Esta clase se utiliza para realizar el mapeo de valores obtenidos de la busqueda del campo TipoRecurso
// a imagenes representativas de cada resultado posible para este campo
public class ListarTipoRecursoColumDecorator implements DisplaytagColumnDecorator {

	/* (non-Javadoc)
	 * @see org.displaytag.decorator.ColumnDecorator#decorate(java.lang.Object)
	 */
	public Object decorate(Object arg0, javax.servlet.jsp.PageContext pageContext, org.displaytag.properties.MediaTypeEnum media) throws DecoratorException {
		
//		Con este codigo recogemos del fichero de internacionalizacion la cadena internaiconalizada de "Mas informacion"
		java.util.Locale locale = pageContext.getRequest().getLocale();
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String textoIntenacional = i18n.getString("listar.odecu.mostrar.resultados.consulta.tablaResultadosBusqueda.masInformacion");
//		BasicDynaBean basicDynaBean = ((BasicDynaBean) this.getCurrentRowObject());
//		
//		Obtenemos el tipo de recurso de la fila que estamos tratando. Este valor contiene un string con todos los 
//		los tipos de recursos que hay asignados al ODE separados por "-"
//		Suponemos que el objeto que le pasan es ya el objeto que tengo que decorar, en este caso un string
		String[] tipoRecurso = (String[]) arg0;
//		String cabecera = "<a href=\"#\">&nbsp;<em>Más información:</em> <br class=\"oculto\" /><span>";
		String cabecera = "<a href=\"#\">&nbsp;<em>"+textoIntenacional+"</em> <br class=\"oculto\" /><span>";
		String cuerpo = "";
		String cola = "</span></a>";
//		Para cada tipo de recurso, escribimos una entrada "strong" con el texto tal cual.
		for (int i = 0; i < tipoRecurso.length; i++) {
			cuerpo+="<strong>"+tipoRecurso[i]+"</strong><br />";
		}
		
		return cabecera + cuerpo + cola;
	}
}
