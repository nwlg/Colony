/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

public class ODE {
	private boolean publicado = false;
	private String pathOriginal = null;
	private String pathTaller = null;
	private String backup = null;
	private String traza = null;
	private boolean comprimido = false;
	private String titulo = null;
	
	/**
	 * @return the backup
	 */
	public String getBackup() {
		return backup;
	}
	/**
	 * @param backup the backup to set
	 */
	public void setBackup(String backup) {
		this.backup = backup;
	}
	/**
	 * @return the comprimido
	 */
	public boolean isComprimido() {
		return comprimido;
	}
	/**
	 * @param comprimido the comprimido to set
	 */
	public void setComprimido(boolean comprimido) {
		this.comprimido = comprimido;
	}
	/**
	 * @return the pathOriginal
	 */
	public String getPathOriginal() {
		return pathOriginal;
	}
	/**
	 * @param pathOriginal the pathOriginal to set
	 */
	public void setPathOriginal(String pathOriginal) {
		this.pathOriginal = pathOriginal;
	}
	/**
	 * @return the pathTaller
	 */
	public String getPathTaller() {
		return pathTaller;
	}
	/**
	 * @param pathTaller the pathTaller to set
	 */
	public void setPathTaller(String pathTaller) {
		this.pathTaller = pathTaller;
	}
	/**
	 * @return the publicado
	 */
	public boolean isPublicado() {
		return publicado;
	}
	/**
	 * @param publicado the publicado to set
	 */
	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer(this.getClass().toString());
		sb.append(" : pathOriginal=").append(pathOriginal).append(
				" : pathTaller=").append(pathTaller).append(" : backup=")
				.append(backup).append(" : comprimido=").append(comprimido)
				.append(" : publicado=").append(publicado);
		return sb.toString();
	}
	/**
	 * @return the traza
	 */
	public String getTraza()
	{
		return traza;
	}
	/**
	 * @param traza the traza to set
	 */
	public void setTraza(String traza)
	{
		this.traza = traza;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
