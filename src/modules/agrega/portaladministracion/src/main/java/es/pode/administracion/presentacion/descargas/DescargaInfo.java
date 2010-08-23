/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.administracion.presentacion.descargas;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO;
import es.pode.contenidos.negocio.descargas.servicio.DescargaVO;

/**
 * @author dgonzalezd
 *
 */
public class DescargaInfo implements Serializable {
	private static final long serialVersionUID = 1320768929555504426L;
	
	private String titulo;
	private String identificador;
	private String fecha;
	
	private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private static String VACIA="";
	
	public DescargaInfo() {
		super();
	}
	
	public DescargaInfo(String fecha, String identificador, String titulo) {
		super();
		this.fecha = fecha;
		this.identificador = identificador;
		this.titulo = titulo;
	}
	
	public DescargaInfo(DescargaVO descarga, DescDescargaVO descripcion) {
		super();
		if(descripcion!=null) {
			this.titulo=descripcion.getTitulo()!=null?descripcion.getTitulo():VACIA;
		} else {
			this.titulo=VACIA;
		}
		if(descarga!=null) {
			setIdentificador(descarga.getIdentificador().toString()!=null?descarga.getIdentificador().toString():VACIA);
			setFecha(descarga.getFecha());
		} else {
			this.fecha=VACIA;
			this.identificador=VACIA;
		}
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
	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		setFecha(format.format(fecha));
	}
	
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Calendar fecha) {
		setFecha(fecha.getTime());
	}
	
	public void setFecha(String fecha) {
		this.fecha=fecha;
	}
}
