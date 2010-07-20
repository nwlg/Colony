/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.descargas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO;
import es.pode.contenidos.negocio.descargas.servicio.DescargaVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.visualizador.presentacion.descargas.DescargasController
 */
public class DescargasControllerImpl extends DescargasController
{
	
	private static final Logger logger = Logger.getLogger(DescargasControllerImpl.class);
	private static String VACIA="";

    /**
     * @see es.pode.visualizador.presentacion.descargas.DescargasController#listadoDescargas(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.descargas.ListadoDescargasForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void listadoDescargas(ActionMapping mapping, es.pode.visualizador.presentacion.descargas.ListadoDescargasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			String idioma = locale.getLanguage();
			logger.debug("Recuperado idioma :"+idioma);
			DescargaVO descargas[] = getSrvDescargas().obtenerDescargasActivas();
			logger.debug("Recuperadas "+descargas.length!=null?descargas.length:0+" descargas");
			ArrayList<DescargaInfo> listaDescargas = new ArrayList<DescargaInfo>();
			if (descargas!=null&&descargas.length>0) {
				
				DescDescargaVO[] descs = getSrvDescargas()
						.obtenerDescDescargasIdioma(descargas, idioma);
				logger.debug("Recuperadas " + descs.length
						+ " descripciones de descargas");
				for (int i = 0; i < descargas.length; i++) {
					DescargaInfo info = new DescargaInfo();
					info.setTitulo(descs[i]!=null&&descs[i].getTitulo()!=null?descs[i].getTitulo():VACIA);
					info.setDescripcion(descs[i]!=null&&descs[i].getDescripcion()!=null?descs[i].getDescripcion():VACIA);
					info.setIdentificador(descargas[i]!=null&&descargas[i].getIdentificador()!=null?descargas[i].getIdentificador().toString():VACIA);
					info.setPeso(descargas[i]!=null&&descargas[i].getPeso()!=null?descargas[i].getPeso():0L,locale);
					info.setRuta(descargas[i]!=null&&descargas[i].getPath()!=null?request.getServerName()+"/"+descargas[i].getPath():VACIA);
					listaDescargas.add(info);
				}
			}
			logger.debug("Lista de descargas construida");
			form.setDescargas(listaDescargas);
		} catch (Exception e) {
			logger.debug("Error al recuperar descargas.",e);
			throw new ValidatorException("{listaDescargas.error}");
		}
     }

	/* (non-Javadoc)
	 * @see es.pode.visualizador.presentacion.descargas.DescargasController#submit(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.descargas.SubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public String submit(ActionMapping mapping, SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sId = form.getIdentificador();
		
		if(logger.isDebugEnabled()) logger.debug("Descargas: Submit con parametros identificador = " + sId);
		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources", locale);
        Long id = Long.valueOf(sId);
        DescargaVO descarga = getSrvDescargas().obtenerDescarga(id);
	
		String url = "/"+descarga.getPath();
		//URLs tipo host/agrega
		url="http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+url;
		if(logger.isDebugEnabled()) logger.debug("Descargando a : "+ url);
		response.sendRedirect(url);

		return "Descargar";
	}
   
	public class DescargaInfo {
		private String titulo;
		private String identificador;
		private String peso;
		private String ruta;
		private String descripcion;
		
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
		 * @return the peso
		 */
		public String getPeso() {
			return peso;
		}
		/**
		 * @param peso the peso to set
		 */
		public void setPeso(String peso) {
			this.peso = peso;
		}
		/**
		 * @param peso the peso to set
		 */
		public void setPeso(Long peso, Locale locale) {
			String unidad = " bytes";
			if (peso > 1024) {
				peso = peso / 1024;
				unidad = " KB";
			}
			if (peso > 1024) {
				peso = peso / 1024;
				unidad = " MB";
			}
			NumberFormat format = NumberFormat.getInstance(locale);
			format.setMaximumFractionDigits(2);
			this.peso = format.format(peso) + unidad;
		}
		/**
		 * @return the ruta
		 */
		public String getRuta() {
			return ruta;
		}
		/**
		 * @param ruta the ruta to set
		 */
		public void setRuta(String ruta) {
			this.ruta = ruta;
		}
		/**
		 * @return the descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}
		/**
		 * @param descripcion the descripcion to set
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	}
}
