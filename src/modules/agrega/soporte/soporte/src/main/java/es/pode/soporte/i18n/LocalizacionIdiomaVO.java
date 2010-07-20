/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.i18n;

/**
 * 
 */
public class LocalizacionIdiomaVO
    implements java.io.Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -660749601558127657L;

	public LocalizacionIdiomaVO()
    {
    }

	public LocalizacionIdiomaVO(String name, String idLocalizacion)
    {
		this.idLocalizacion = idLocalizacion;
		this.name = name;
    }
    private java.lang.String name;  /*etiqueta traducida del idioma*/
    private java.lang.String idLocalizacion; /*etiqueta del idioma internacional*/

	public java.lang.String getIdLocalizacion() {
		return idLocalizacion;
	}
	public void setIdLocalizacion(java.lang.String idLocalizacion) {
		this.idLocalizacion = idLocalizacion;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}

}