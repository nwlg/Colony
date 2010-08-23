/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.presentacion.pendientes;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;

public class MarcarModificado extends TableDecorator{

	private static Logger logger = Logger.getLogger(MarcarModificado.class);
	
	@Override
	public String addRowClass() {	
		String resultado = null;
		PageContext pageContext =  this.getPageContext();
		Object valor = pageContext.getAttribute("valor");
		String atributo = (String) pageContext.getAttribute("atributo");
		Object filaActual = this.getCurrentRowObject();
		
		if(valor !=null && atributo!=null && filaActual!=null){
			if(PropertyUtils.isReadable(filaActual, atributo)){
				try {
					Object valorFila = PropertyUtils.getSimpleProperty(filaActual, atributo);
					if(valorFila !=null && valorFila.toString().equals(valor)) {
						logger.debug("Cambiando class de la fila " + this.getViewIndex());
						resultado = "tr_color";
					}
				} catch (IllegalAccessException e) {
					logger.error(e);
				} catch (InvocationTargetException e) {
					logger.error(e);
				} catch (NoSuchMethodException e) {
					logger.error(e);
				}

			}
		}
		
		return resultado;
	}
	
}
