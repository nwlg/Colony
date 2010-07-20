/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.catalogacion.soporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DescripcionUsoEdu 
{
	public static int SELECCION_DESCRIPCION=0;
	public static int SELECCION_CPREVIOS=1;
	public static int SELECCION_ODIDACTICOS=2;
	public static int SELECCION_TCONOCIMIENTOS=3;
	
	
	private String conocimientoPrevio;
	private String objetivosDidacticos;
	private List tipoConocimiento;
	private int seleccionado;
	
	public String getConocimientoPrevio() {
		return conocimientoPrevio;
	}
	public void setConocimientoPrevio(String conocimientoPrevio) {
		this.conocimientoPrevio = conocimientoPrevio;
	}
	public String getObjetivosDidacticos() {
		return objetivosDidacticos;
	}
	public void setObjetivosDidacticos(String objetivosDidacticos) {
		this.objetivosDidacticos = objetivosDidacticos;
	}
	public List getTipoConocimiento() {
		return tipoConocimiento;
	}
	public void setTipoConocimiento(List tipoConocimiento) {
		this.tipoConocimiento = tipoConocimiento;
	}
	
	private DescripcionUsoEdu() 
	{
		this.conocimientoPrevio="";
		this.objetivosDidacticos="";
		this.tipoConocimiento= new ArrayList();
		this.seleccionado = 0;
	}
	
	
	public static DescripcionUsoEdu getInstance()
	{
		return new DescripcionUsoEdu();
	}
	
	public static DescripcionUsoEdu getInstance(String descripcion,String[] categorias)
	{
		DescripcionUsoEdu resultado= new DescripcionUsoEdu();
		
		if(descripcion!=null && !descripcion.equals("") &&
		   categorias!=null && categorias.length>0 	)
		{
			descripcion.trim();
			if(descripcion.toLowerCase().startsWith(categorias[0].toLowerCase())) // conocimiento previo
			{
				resultado.conocimientoPrevio= descripcion.substring( categorias[0].length() , descripcion.length() );
				resultado.seleccionado = SELECCION_CPREVIOS;
			}
			else if(descripcion.toLowerCase().startsWith(categorias[1].toLowerCase())) // objetivos didacticos
			{
				resultado.objetivosDidacticos= descripcion.substring( categorias[1].length() , descripcion.length() );
				resultado.seleccionado= SELECCION_ODIDACTICOS;
			}
			else if(descripcion.toLowerCase().startsWith(categorias[2].toLowerCase())) //tipo de conocimiento
			{
				String lista= descripcion.substring( categorias[2].length() , descripcion.length() ).toLowerCase();
				String[] listaTiposC = lista.split(",");
				if( listaTiposC!=null && listaTiposC.length>0)
				{
					for (int i = 0; i < listaTiposC.length; i++) {
						listaTiposC[i]= listaTiposC[i].trim().toLowerCase(); //quito los espacios y paso la cadena a minusculas
					}
					resultado.setTipoConocimiento(Arrays.asList(listaTiposC));
				}
				resultado.seleccionado= SELECCION_TCONOCIMIENTOS;
			}
		}
		
		return resultado;
	}

	
	public boolean getVacio()
	{
		boolean resultado=false;
		if( (conocimientoPrevio==null  || conocimientoPrevio.equals("")) &&
			(objetivosDidacticos==null || objetivosDidacticos.equals("")) &&
			(tipoConocimiento==null || tipoConocimiento.size()==0))
			resultado=true;
		
		return resultado;
	}
	
	public int getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}
}
