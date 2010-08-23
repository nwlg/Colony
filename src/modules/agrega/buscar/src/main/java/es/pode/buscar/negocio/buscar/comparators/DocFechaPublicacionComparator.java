/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.buscar.comparators;

import java.util.Comparator;

import es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO;

public class DocFechaPublicacionComparator implements Comparator {
	
	public int compare(Object o1, Object o2) {
		if(((ValoresBusquedaVO) o2).getFechaPublicacion()==null || ((ValoresBusquedaVO) o2).getFechaPublicacion().equals(""))return -1;
		else if(((ValoresBusquedaVO) o1).getFechaPublicacion()==null || ((ValoresBusquedaVO) o1).getFechaPublicacion().equals(""))return 1;
		else if(Integer.parseInt(((ValoresBusquedaVO) o2).getFechaPublicacion()) < Integer.parseInt(((ValoresBusquedaVO) o1).getFechaPublicacion())) return -1;
		else if(Integer.parseInt(((ValoresBusquedaVO) o1).getFechaPublicacion()) < Integer.parseInt(((ValoresBusquedaVO) o2).getFechaPublicacion())) return 1;
		else if(((ValoresBusquedaVO) o2).getHoraPublicacion()==null || ((ValoresBusquedaVO) o2).getHoraPublicacion().equals(""))return -1;
		else if(((ValoresBusquedaVO) o1).getHoraPublicacion()==null || ((ValoresBusquedaVO) o1).getHoraPublicacion().equals(""))return 1;
		else if(Integer.parseInt(((ValoresBusquedaVO) o2).getHoraPublicacion()) < Integer.parseInt(((ValoresBusquedaVO) o1).getHoraPublicacion())) return -1;
		else if(Integer.parseInt(((ValoresBusquedaVO) o1).getHoraPublicacion()) < Integer.parseInt(((ValoresBusquedaVO) o2).getHoraPublicacion())) return 1;
		else return 0;
	}

}
