/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.descargas.crear;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession;
import es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;



/**
 * @see es.pode.administracion.presentacion.descargas.crear.CrearDescargaController
 */
public class CrearDescargaControllerImpl extends CrearDescargaController
{
	private static final long serialVersionUID = -62452977525040076L;
	private static final Logger logger = Logger.getLogger(CrearDescargaControllerImpl.class);
	private static String applicationResources="application-resources";
	private static String VACIA="";
	
	private static String descripcionPorDefecto = "crearDescarga.descarga.descripcion.tooltip";

    /**
     * @see es.pode.administracion.presentacion.descargas.crear.CrearDescargaController#obtenerDatos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.crear.ObtenerDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerDatos(ActionMapping mapping, es.pode.administracion.presentacion.descargas.crear.ObtenerDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		ConfigurarDescargaSession sesion = getConfigurarDescargaSession(request);
		if (sesion!=null) {
				List<DescDescargaVO> descripciones = sesion.getDescripciones();
				logger.debug("Lista de descripciones construida");
				List<CrearDescargaInfo> lista=new ArrayList<CrearDescargaInfo>();
				LocalizacionIdiomaVO[] idiomas=I18n.getInstance().obtenerIdiomasPlataformaLocalizados(idiomaActual(request));
				for (int i=0;i<idiomas.length;i++) {
					CrearDescargaInfo info = new CrearDescargaInfo();
					DescDescargaVO descripcion = descripcionIdioma(descripciones, idiomas[i].getIdLocalizacion());
					if (descripcion!=null) {
						info.setTitulo(descripcion.getTitulo());
						info.setDescripcion(descripcion.getDescripcion());
					} else {
						info.setTitulo(VACIA);
						info.setDescripcion(VACIA);
					}
					info.setIdioma(idiomas[i].getIdLocalizacion());
					info.setIdiomadesc(idiomas[i].getName());
					lista.add(info);
				}
				form.setDescripciones(lista);
				form.setPath(sesion.getPath()!=null?sesion.getPath():VACIA);
		}
	}
    
    public void guardarDescarga(ActionMapping mapping,
			GuardarDescargaForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
    	ResourceBundle resources = ResourceBundle.getBundle(applicationResources, (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		if(resources.getString("comun.aceptar").equals(form.getAction())) {
			ConfigurarDescargaSession sesion=getConfigurarDescargaSession(request);
			List<DescDescargaVO> descripciones = new ArrayList<DescDescargaVO>();
			boolean alMenosUna=false;

			String desc;
			String titulo;
			String idioma;
			
			desc=compruebaDescripcion(form.getDescripcion_es(),request);
			titulo=compruebaTitulo(form.getTitulo_es(), request);
			idioma="es";
			alMenosUna = addDescripcion(descripciones, alMenosUna, desc,
					titulo, idioma);
			
			desc=compruebaDescripcion(form.getDescripcion_ca(),request);
			titulo=compruebaTitulo(form.getTitulo_ca(), request);
			idioma="ca";
			alMenosUna = addDescripcion(descripciones, alMenosUna, desc,
					titulo, idioma);
			
			desc=compruebaDescripcion(form.getDescripcion_en(),request);
			titulo=compruebaTitulo(form.getTitulo_en(), request);
			idioma="en";
			alMenosUna = addDescripcion(descripciones, alMenosUna, desc,
					titulo, idioma);
			
			desc=compruebaDescripcion(form.getDescripcion_eu(),request);
			titulo=compruebaTitulo(form.getTitulo_eu(), request);
			idioma="eu";
			alMenosUna = addDescripcion(descripciones, alMenosUna, desc,
					titulo, idioma);
			
			desc=compruebaDescripcion(form.getDescripcion_gl(),request);
			titulo=compruebaTitulo(form.getTitulo_gl(), request);
			idioma="gl";
			alMenosUna = addDescripcion(descripciones, alMenosUna, desc,
					titulo, idioma);
			
			desc=compruebaDescripcion(form.getDescripcion_va(),request);
			titulo=compruebaTitulo(form.getTitulo_va(), request);
			idioma="va";
			alMenosUna = addDescripcion(descripciones, alMenosUna, desc,
					titulo, idioma);
			
			if(!alMenosUna) {
				throw new ValidatorException("{crearDescarga.noDescripcion.exception}");
			}
			
			String path="";
			if(sesion.getPath()==null||!sesion.getPath().equals(form.getPath())) {
				path = form.getPath();
			}
			
			Long identificador=sesion.getIdentificador()!=null?sesion.getIdentificador():null;
			
	    	identificador=getSrvDescargas().modificarDescarga(identificador, path, sesion.getActiva(),descripciones.toArray(new DescDescargaVO[]{} ));
	    	if(identificador==null) {
	    		throw new ValidatorException("{crearDescarga.noFichero.exception}");
	    	}
	    	form.setIdModificada(identificador);
		}
    	removeConfigurarDescargaSession(request);
		
	}

	private boolean addDescripcion(List<DescDescargaVO> descripciones, boolean alMenosUna,
			String desc, String titulo, String idioma) {
		DescDescargaVO descripcion = new DescDescargaVO(idioma,
				desc, titulo);
		descripciones.add(descripcion);
		if (desc!=null&&!desc.equals(VACIA)&&titulo!=null&&!titulo.equals(VACIA)) {
			alMenosUna=true;
		}
		return alMenosUna;
	}

	private DescDescargaVO descripcionIdioma(List<DescDescargaVO> descripciones, String idioma) {
    	DescDescargaVO descripcion=null;
    	if(descripciones!=null){
    		for (Iterator<DescDescargaVO> iterator = descripciones.iterator(); iterator
					.hasNext();) {
    			DescDescargaVO desc = iterator.next();
				if (desc.getIdioma().equals(idioma)) {
					descripcion=desc;
				}
			}
		}
    	return descripcion;
    }
    
	private String idiomaActual(HttpServletRequest request) {
		return ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	}
	
	private String compruebaDescripcion(String descripcion, HttpServletRequest request) {
		ResourceBundle resources = ResourceBundle.getBundle("application-resources", (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		if(descripcion==null||descripcion.equals(resources.getString(descripcionPorDefecto))) {
			descripcion=VACIA;
		}
		return descripcion;
	}
	
	private String compruebaTitulo(String titulo, HttpServletRequest request) {
		if(titulo==null) {
			titulo=VACIA;
		}
		return titulo;
	}
	
	public class CrearDescargaInfo {
		private String titulo;
		private String descripcion;
		private String idioma;
		private String idiomadesc;
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
		/**
		 * @return the idioma
		 */
		public String getIdioma() {
			return idioma;
		}
		/**
		 * @param idioma the idioma to set
		 */
		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}
		/**
		 * @return the idiomaDesc
		 */
		public String getIdiomadesc() {
			return idiomadesc;
		}
		/**
		 * @param idiomaDesc the idiomaDesc to set
		 */
		public void setIdiomadesc(String idiomaDesc) {
			this.idiomadesc = idiomaDesc;
		}
	}
}