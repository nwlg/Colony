/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.catalogacion.soporte;


public class Caracteristica {
	
	private String  resolucion;
	private String  dimension;
	private String  modoColor;
	private String  bandaSonora;
	private String  formato;
	private String  tipoPlano;
	private String  luz;
	private String  estructuraFormal;
	private String  angulacion;
	
	
	public static Caracteristica getInstance(String texto, String[] titulosTraducidos )
	{
		Caracteristica resultado=new Caracteristica();
		
		if(titulosTraducidos!=null && texto.startsWith(titulosTraducidos[0]))
		{
			for (int i = 0; i < titulosTraducidos.length; i++) {
				int indice=0;
				indice= texto.indexOf(titulosTraducidos[i]);
				if(indice>0)
				{
					int inicio= texto.indexOf("(", indice);
					int fin= texto.indexOf(")", indice);
				
					switch (i) {
					case 1://resolucion
						resultado.setResolucion( texto.substring(inicio+1, fin));
						break;
					case 2:
						resultado.setDimension( texto.substring(inicio+1, fin));
						break;
					case 3:
						resultado.setModoColor( texto.substring(inicio+1, fin));
						break;
					case 4:
						resultado.setBandaSonora( texto.substring(inicio+1, fin));
						break;
					case 5:
						resultado.setFormato( texto.substring(inicio+1, fin));
						break;
					case 6:
						resultado.setTipoPlano( texto.substring(inicio+1, fin));
						break;
					case 7:
						resultado.setLuz( texto.substring(inicio+1, fin));
						break;
					case 8:
						resultado.setEstructuraFormal( texto.substring(inicio+1, fin));
						break;
					case 9:
						resultado.setAngulacion( texto.substring(inicio+1, fin));
						break;
					}
				}

			}
			
		}
		
		return resultado;
	}
	
	private Caracteristica()
	{
		this.resolucion="";
		this.dimension="";
		this.modoColor="";
		this.bandaSonora="";
		this.formato="";
		this.tipoPlano="";
		this.luz="";
		this.estructuraFormal="";
		this.angulacion="";
	}
	
	
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getModoColor() {
		return modoColor;
	}
	public void setModoColor(String modoColor) {
		this.modoColor = modoColor;
	}
	public String getBandaSonora() {
		return bandaSonora;
	}
	public void setBandaSonora(String bandaSonora) {
		this.bandaSonora = bandaSonora;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getTipoPlano() {
		return tipoPlano;
	}
	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}
	public String getLuz() {
		return luz;
	}
	public void setLuz(String luz) {
		this.luz = luz;
	}
	public String getEstructuraFormal() {
		return estructuraFormal;
	}
	public void setEstructuraFormal(String estructuraFormal) {
		this.estructuraFormal = estructuraFormal;
	}
	public String getAngulacion() {
		return angulacion;
	}
	public void setAngulacion(String angulacion) {
		this.angulacion = angulacion;
	}

	public boolean getVacio() 
	{
		if( (resolucion==null || resolucion.equals("")) &&
			(dimension==null || dimension.equals("")) &&
			(modoColor==null || modoColor.equals("")) &&
			(bandaSonora==null || bandaSonora.equals("")) &&
			(formato==null || formato.equals("")) &&
			(tipoPlano==null || tipoPlano.equals("")) &&
			(luz==null || luz.equals("")) &&
			(estructuraFormal==null || estructuraFormal.equals("")) &&
			(angulacion==null || angulacion.equals("") )	)
			return true;
		else 
		{
			return false;
		}
	}
	
	public String[] getCodigos()
	{
		
		String[] listaCodigos= new String[8];
		
		listaCodigos[0]= this.dimension;
		listaCodigos[1]= this.modoColor;
		listaCodigos[2]= this.bandaSonora;
		listaCodigos[3]= this.formato;
		listaCodigos[4]= this.tipoPlano;
		listaCodigos[5]= this.luz;
		listaCodigos[6]= this.estructuraFormal;
		listaCodigos[7]= this.angulacion;
		
		return listaCodigos;
	}
}
