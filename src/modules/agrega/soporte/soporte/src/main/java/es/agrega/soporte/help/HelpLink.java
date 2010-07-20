/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.help;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class HelpLink 
{
	private static HelpLink help= null;
	
	private HelpLink ()
	{
		
	}
	
	public static HelpLink getInstance()
	{
		if (HelpLink.help == null)
			HelpLink.help = new HelpLink();
		
		return HelpLink.help;
	}

	public String getRequestAttribute(ServletRequest request, String attrKey) 
	{
		String requestUrl = null;
		if (request != null && request instanceof HttpServletRequest)
		{
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			requestUrl = String.valueOf(httpRequest.getAttribute(attrKey));
		}
		else
			requestUrl = String.valueOf(request.getAttribute(attrKey));
		return requestUrl;
	}

}
