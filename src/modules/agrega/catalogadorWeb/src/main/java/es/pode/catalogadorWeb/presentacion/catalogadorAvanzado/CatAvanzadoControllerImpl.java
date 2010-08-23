/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorAvanzado;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AgregadorORVO;
import es.pode.catalogacion.negocio.servicios.AvAnnotationVO;
import es.pode.catalogacion.negocio.servicios.AvClassificationVO;
import es.pode.catalogacion.negocio.servicios.AvEducationalVO;
import es.pode.catalogacion.negocio.servicios.AvGeneralVO;
import es.pode.catalogacion.negocio.servicios.AvLifeCycleVO;
import es.pode.catalogacion.negocio.servicios.AvMetametadataVO;
import es.pode.catalogacion.negocio.servicios.AvRelationVO;
import es.pode.catalogacion.negocio.servicios.AvRightsVO;
import es.pode.catalogacion.negocio.servicios.AvTechnicalVO;
import es.pode.catalogacion.negocio.servicios.ContribucionVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.EntidadVO;
import es.pode.catalogacion.negocio.servicios.EntryVO;
import es.pode.catalogacion.negocio.servicios.FechaVO;
import es.pode.catalogacion.negocio.servicios.IdVO;
import es.pode.catalogacion.negocio.servicios.IdentificadorVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.TaxonVO;
import es.pode.catalogacion.negocio.servicios.VersionMaxVO;
import es.pode.catalogacion.negocio.servicios.VersionMinVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController
 */
public class CatAvanzadoControllerImpl extends CatAvanzadoController
{ 


	protected static Logger logger = Logger.getLogger(CatAvanzadoControllerImpl.class); 

	private static final String HTTP ="http://";
	private static final String BARRA ="/";
	private static final String SEPARADOR =":";
	
    /**
     * @see es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController#cargarDatosAv(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CargarDatosAvForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDatosAv(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CargarDatosAvForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		try{
	        
			javax.servlet.http.HttpSession session = request.getSession(true);
			Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
			//Cogemos el idioma de LanguageFilter de Soporte, que si estas logado coge el idioma de LDAP
			Locale idio=(Locale)session.getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			String idiomaLdap=idio.getLanguage();
			
	        CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	        
	        //String idiomaLdap=LdapUserDetailsUtils.getIdioma();//"es";
	        String usuario =LdapUserDetailsUtils.getUsuario();//"empaquetador";//
	        String identificador =request.getParameter("identificador");
	        if(identificador==null){
	        	identificador=catalogadorAvSession.getIdentificador();
	        }
//	        is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
//			prop.load(is);
//			if (idiomaLdap==null || idiomaLdap.equals("")){
//				idiomaLdap=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
//			}
//	        String idiomas=prop.getProperty("idiomas.properties").toString();
//			idiomas="es,en,eu";//Redefinido hasta que tengamos las traducciones de los vocabularios en catalán y gallego
//			StringTokenizer token = new StringTokenizer(idiomas, ",");
//			while (token.hasMoreElements()&&(!bandera)) {
//				String idiomaLeido=token.nextElement().toString();
//				if(idiomaLdap.equals(idiomaLeido)){
//					bandera=true;
//				}
//			}
//			
//			if(bandera==false){
//				idiomaLdap= "es";
//			}

			LomAvanzadoVO lomAvanzado= null;
			
			if (attribute == null || ((CatalogadorAvSession)attribute).getMDSesion() == null) {
				//si aqi llega el identificador a null qiere decir que se ha ido la session, para evitar error de servicio
				// lanzamos directamente la excepcion
				if (identificador!= null) {
					lomAvanzado= this.getSrvCatalogacionAvanzadaService().obtenerLomAvanzado(identificador,usuario,idiomaLdap);//Engancharselo al objeto de session
				}else{
					throw new Exception();
				}
			}else
				lomAvanzado = catalogadorAvSession.getMDSesion();
//			Cargamos el objeto de session desde el lom avanzado
//			introducido nuevo parametro para vuelta al empaquetador
			String returnURL=request.getParameter("returnURL");
			if(returnURL==null)
				returnURL=catalogadorAvSession.getReturnURL();
			catalogadorAvSession.setIdioma(idiomaLdap);
			catalogadorAvSession.setIdentificador(identificador);
			catalogadorAvSession.setUsuario(usuario);
//			metemos en la sesion el parametro de vuelta al empaquetador
			catalogadorAvSession.setReturnURL(returnURL);			
			
			
//			Cargamos el objeto de sesion
			if(catalogadorAvSession.getMDSesion()==null){
				LomAvanzadoVO lom=new LomAvanzadoVO();
				//cargamos el general
				
				if(lomAvanzado.getGeneral()!=null){
					AvGeneralVO gen=new AvGeneralVO();
					gen.setIdentificadores(lomAvanzado.getGeneral().getIdentificadores());
					gen.setTitulo(lomAvanzado.getGeneral().getTitulo());
					gen.setIdiomas(lomAvanzado.getGeneral().getIdiomas());
					gen.setDescripciones(lomAvanzado.getGeneral().getDescripciones());
					gen.setPalabrasClave(lomAvanzado.getGeneral().getPalabrasClave());
					gen.setAmbitos(lomAvanzado.getGeneral().getAmbitos());
					gen.setEstructura(lomAvanzado.getGeneral().getEstructura());
					gen.setNivelAgregacion(lomAvanzado.getGeneral().getNivelAgregacion());
					lom.setGeneral(gen);
				}
				
				//cargamos el ciclo de vida
				
				if(lomAvanzado.getLifeCycle()!=null){
					AvLifeCycleVO life=new AvLifeCycleVO();
					life.setVersion(lomAvanzado.getLifeCycle().getVersion());
					life.setEstado(lomAvanzado.getLifeCycle().getEstado());
					life.setContribuciones(lomAvanzado.getLifeCycle().getContribuciones());
					lom.setLifeCycle(life);
				}
				
				//cargamos los meta-metadatos
				
				if(lomAvanzado.getMetaMetadata()!=null){
					AvMetametadataVO meta=new AvMetametadataVO();
					meta.setIdentificadores(lomAvanzado.getMetaMetadata().getIdentificadores());
					meta.setContribuciones(lomAvanzado.getMetaMetadata().getContribuciones());
					meta.setEsquemas(lomAvanzado.getMetaMetadata().getEsquemas());
					meta.setIdioma(lomAvanzado.getMetaMetadata().getIdioma());
					lom.setMetaMetadata(meta);
				}
				
				//cargamos tecnica
				
				if(lomAvanzado.getTechnical()!=null){
					AvTechnicalVO tech=new AvTechnicalVO();
					tech.setFormatos(lomAvanzado.getTechnical().getFormatos());
					tech.setTamanio(lomAvanzado.getTechnical().getTamanio());
					tech.setLocalizaciones(lomAvanzado.getTechnical().getLocalizaciones());
					tech.setRequisitos(lomAvanzado.getTechnical().getRequisitos());
					tech.setPautasInstalacion(lomAvanzado.getTechnical().getPautasInstalacion());
					tech.setOtrosRequisitos(lomAvanzado.getTechnical().getOtrosRequisitos());
					tech.setDuracion(lomAvanzado.getTechnical().getDuracion());
					lom.setTechnical(tech);
				}
				
				//cargamos usos educativos
				
				if((lomAvanzado.getEducational()!=null)&&(lomAvanzado.getEducational().length>0)){
					ArrayList educationals=new ArrayList();
					for (int i=0; i<lomAvanzado.getEducational().length;i++){
						AvEducationalVO edu=new AvEducationalVO();
						edu.setTipoDeInteractividad(lomAvanzado.getEducational()[i].getTipoDeInteractividad());
						edu.setTiposrecursoedu(lomAvanzado.getEducational()[i].getTiposrecursoedu());
						edu.setNivelInteractividad(lomAvanzado.getEducational()[i].getNivelInteractividad());
						edu.setDensidadSemantica(lomAvanzado.getEducational()[i].getDensidadSemantica());
						edu.setDestinatarios(lomAvanzado.getEducational()[i].getDestinatarios());
						edu.setContextos(lomAvanzado.getEducational()[i].getContextos());
						edu.setRangoedades(lomAvanzado.getEducational()[i].getRangoedades());
						edu.setDificultad(lomAvanzado.getEducational()[i].getDificultad());
						edu.setTiempoAprendizaje(lomAvanzado.getEducational()[i].getTiempoAprendizaje());
						edu.setDescripciones(lomAvanzado.getEducational()[i].getDescripciones());
						edu.setIdiomas(lomAvanzado.getEducational()[i].getIdiomas());
						edu.setProcesoscognitivos(lomAvanzado.getEducational()[i].getProcesoscognitivos());
						educationals.add(edu);
					}
					AvEducationalVO[] educational=(AvEducationalVO[])educationals.toArray(new AvEducationalVO[educationals.size()]);
					lom.setEducational(educational);
				}
				
				
				//cargamos derechos
				
				if(lomAvanzado.getDerechos()!=null){
					AvRightsVO derechos=new AvRightsVO();
					derechos.setCoste(lomAvanzado.getDerechos().getCoste());
					derechos.setDerechosDeAutor(lomAvanzado.getDerechos().getDerechosDeAutor());
					derechos.setDescripcion(lomAvanzado.getDerechos().getDescripcion());
					derechos.setAcceso(lomAvanzado.getDerechos().getAcceso());
					lom.setDerechos(derechos);
				}
				
				
				//cargamos relaciones
				
				if((lomAvanzado.getRelaciones()!=null)&&(lomAvanzado.getRelaciones().length>0)){
					ArrayList relation=new ArrayList();
					for(int i=0;i<lomAvanzado.getRelaciones().length;i++){
						AvRelationVO relacion=new AvRelationVO();
						relacion.setTipo(lomAvanzado.getRelaciones()[i].getTipo());
						relacion.setRecurso(lomAvanzado.getRelaciones()[i].getRecurso());
						relation.add(relacion);
					}
					AvRelationVO[] relaciones=(AvRelationVO[])relation.toArray(new AvRelationVO[relation.size()]);
					lom.setRelaciones(relaciones);
				}
				
				//cargamos anotaciones
				
				if((lomAvanzado.getAnotaciones()!=null)&&(lomAvanzado.getAnotaciones().length>0)){
					ArrayList annotation=new ArrayList();
					for(int i=0;i<lomAvanzado.getAnotaciones().length;i++){
						AvAnnotationVO anotacion=new AvAnnotationVO();
						anotacion.setEntidad(lomAvanzado.getAnotaciones()[i].getEntidad());
						anotacion.setFecha(lomAvanzado.getAnotaciones()[i].getFecha());
						anotacion.setDescripcion(lomAvanzado.getAnotaciones()[i].getDescripcion());
						annotation.add(anotacion);
					}
					AvAnnotationVO[] anotaciones=(AvAnnotationVO[])annotation.toArray(new AvAnnotationVO[annotation.size()]);
					lom.setAnotaciones(anotaciones);
				}
				
				//cargamos clasificaciones
				
				if((lomAvanzado.getClasificaciones()!=null)&&(lomAvanzado.getClasificaciones().length>0)){
					ArrayList classification=new ArrayList();
					for(int i=0;i<lomAvanzado.getClasificaciones().length;i++){
						AvClassificationVO clasificacion=new AvClassificationVO();
						clasificacion.setProposito(lomAvanzado.getClasificaciones()[i].getProposito());
						clasificacion.setRutasTaxonomicas(lomAvanzado.getClasificaciones()[i].getRutasTaxonomicas());
						clasificacion.setDescripcion(lomAvanzado.getClasificaciones()[i].getDescripcion());
						clasificacion.setPalabrasClave(lomAvanzado.getClasificaciones()[i].getPalabrasClave());
						classification.add(clasificacion);
					}
					AvClassificationVO[] clasificaciones=(AvClassificationVO[])classification.toArray(new AvClassificationVO[classification.size()]);
					lom.setClasificaciones(clasificaciones);
				}
				
				catalogadorAvSession.setMDSesion(lom);
				
			}else{
				//cargamos general
				if(lomAvanzado.getGeneral()!=null){
			       catalogadorAvSession.getMDSesion().getGeneral().setIdentificadores(lomAvanzado.getGeneral().getIdentificadores());
			       catalogadorAvSession.getMDSesion().getGeneral().setTitulo(lomAvanzado.getGeneral().getTitulo());
			       catalogadorAvSession.getMDSesion().getGeneral().setIdiomas(lomAvanzado.getGeneral().getIdiomas());
			       catalogadorAvSession.getMDSesion().getGeneral().setDescripciones(lomAvanzado.getGeneral().getDescripciones());
			       catalogadorAvSession.getMDSesion().getGeneral().setPalabrasClave(lomAvanzado.getGeneral().getPalabrasClave());
			       catalogadorAvSession.getMDSesion().getGeneral().setAmbitos(lomAvanzado.getGeneral().getAmbitos());
			       catalogadorAvSession.getMDSesion().getGeneral().setEstructura(lomAvanzado.getGeneral().getEstructura());
			       catalogadorAvSession.getMDSesion().getGeneral().setNivelAgregacion(lomAvanzado.getGeneral().getNivelAgregacion());
				}
		       //cargamos el ciclo de vida
				if(lomAvanzado.getLifeCycle()!=null){
			       catalogadorAvSession.getMDSesion().getLifeCycle().setVersion(lomAvanzado.getLifeCycle().getVersion());
			       catalogadorAvSession.getMDSesion().getLifeCycle().setEstado(lomAvanzado.getLifeCycle().getEstado());
			       catalogadorAvSession.getMDSesion().getLifeCycle().setContribuciones(lomAvanzado.getLifeCycle().getContribuciones());
				}
		       //cargamos el metametadata
				if(lomAvanzado.getMetaMetadata()!=null){
			       catalogadorAvSession.getMDSesion().getMetaMetadata().setIdentificadores(lomAvanzado.getMetaMetadata().getIdentificadores());
			       catalogadorAvSession.getMDSesion().getMetaMetadata().setContribuciones(lomAvanzado.getMetaMetadata().getContribuciones());
			       catalogadorAvSession.getMDSesion().getMetaMetadata().setEsquemas(lomAvanzado.getMetaMetadata().getEsquemas());
			       catalogadorAvSession.getMDSesion().getMetaMetadata().setIdioma(lomAvanzado.getMetaMetadata().getIdioma());
				}
		       //cargamos technical
				if(lomAvanzado.getTechnical()!=null){
			       catalogadorAvSession.getMDSesion().getTechnical().setFormatos(lomAvanzado.getTechnical().getFormatos());
			       catalogadorAvSession.getMDSesion().getTechnical().setTamanio(lomAvanzado.getTechnical().getTamanio());
			       catalogadorAvSession.getMDSesion().getTechnical().setLocalizaciones(lomAvanzado.getTechnical().getLocalizaciones());
			       catalogadorAvSession.getMDSesion().getTechnical().setRequisitos(lomAvanzado.getTechnical().getRequisitos());
			       catalogadorAvSession.getMDSesion().getTechnical().setPautasInstalacion(lomAvanzado.getTechnical().getPautasInstalacion());
			       catalogadorAvSession.getMDSesion().getTechnical().setOtrosRequisitos(lomAvanzado.getTechnical().getOtrosRequisitos());
			       catalogadorAvSession.getMDSesion().getTechnical().setDuracion(lomAvanzado.getTechnical().getDuracion());
				}
		       
		       //cargamos educationales
				if((lomAvanzado.getEducational()!=null)&&(lomAvanzado.getEducational().length>0)){
			       for(int i=0;i<lomAvanzado.getEducational().length;i++){
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setTipoDeInteractividad(lomAvanzado.getEducational()[i].getTipoDeInteractividad());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setTiposrecursoedu(lomAvanzado.getEducational()[i].getTiposrecursoedu());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setNivelInteractividad(lomAvanzado.getEducational()[i].getNivelInteractividad());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setDensidadSemantica(lomAvanzado.getEducational()[i].getDensidadSemantica());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setDestinatarios(lomAvanzado.getEducational()[i].getDestinatarios());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setContextos(lomAvanzado.getEducational()[i].getContextos());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setRangoedades(lomAvanzado.getEducational()[i].getRangoedades());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setDificultad(lomAvanzado.getEducational()[i].getDificultad());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setTiempoAprendizaje(lomAvanzado.getEducational()[i].getTiempoAprendizaje());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setDescripciones(lomAvanzado.getEducational()[i].getDescripciones());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setIdiomas(lomAvanzado.getEducational()[i].getIdiomas());
			    	   catalogadorAvSession.getMDSesion().getEducational()[i].setProcesoscognitivos(lomAvanzado.getEducational()[i].getProcesoscognitivos());
			       }
				}
		       //cargamos derechos
				if(lomAvanzado.getDerechos()!=null){
			       catalogadorAvSession.getMDSesion().getDerechos().setCoste(lomAvanzado.getDerechos().getCoste());
			       catalogadorAvSession.getMDSesion().getDerechos().setDerechosDeAutor(lomAvanzado.getDerechos().getDerechosDeAutor());
			       catalogadorAvSession.getMDSesion().getDerechos().setDescripcion(lomAvanzado.getDerechos().getDescripcion());
			       catalogadorAvSession.getMDSesion().getDerechos().setAcceso(lomAvanzado.getDerechos().getAcceso());
				}
		       //cargamos relaciones
				if((lomAvanzado.getRelaciones()!=null)&&(lomAvanzado.getRelaciones().length>0)){
			       for(int i=0;i<lomAvanzado.getRelaciones().length;i++){
			    	   catalogadorAvSession.getMDSesion().getRelaciones()[i].setTipo(lomAvanzado.getRelaciones()[i].getTipo());
			    	   catalogadorAvSession.getMDSesion().getRelaciones()[i].setRecurso(lomAvanzado.getRelaciones()[i].getRecurso());
			       }
				}
		       //cargamos anotaciones
				if((lomAvanzado.getAnotaciones()!=null)&&(lomAvanzado.getAnotaciones().length>0)){
			       for(int i=0;i<lomAvanzado.getAnotaciones().length;i++){
			    	   catalogadorAvSession.getMDSesion().getAnotaciones()[i].setEntidad(lomAvanzado.getAnotaciones()[i].getEntidad());
			    	   catalogadorAvSession.getMDSesion().getAnotaciones()[i].setFecha(lomAvanzado.getAnotaciones()[i].getFecha());
			    	   catalogadorAvSession.getMDSesion().getAnotaciones()[i].setDescripcion(lomAvanzado.getAnotaciones()[i].getDescripcion());
			       }
				}
		       
		       //cargamos clasificaciones
				if((lomAvanzado.getClasificaciones()!=null)&&(lomAvanzado.getClasificaciones().length>0)){
			       for(int i=0;i<lomAvanzado.getClasificaciones().length;i++){
			    	   catalogadorAvSession.getMDSesion().getClasificaciones()[i].setProposito(lomAvanzado.getClasificaciones()[i].getProposito());
			    	   catalogadorAvSession.getMDSesion().getClasificaciones()[i].setRutasTaxonomicas(lomAvanzado.getClasificaciones()[i].getRutasTaxonomicas());
			    	   catalogadorAvSession.getMDSesion().getClasificaciones()[i].setDescripcion(lomAvanzado.getClasificaciones()[i].getDescripcion());
			    	   catalogadorAvSession.getMDSesion().getClasificaciones()[i].setPalabrasClave(lomAvanzado.getClasificaciones()[i].getPalabrasClave());
			       }
				}
			}
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
			
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarDatosAv" + e);
    		throw new java.lang.Exception("catalogador.avanzado", e);
    		
    	} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController#categoriaSeleccionada(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriaSeleccionadaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String categoriaSeleccionada(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CategoriaSeleccionadaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setCategoria("categoria-test");
         return null;
    }



	public void volverAEmpaquetador(
			ActionMapping mapping, 
			VolverAEmpaquetadorForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		//Recogemos el parametro para ir a PortalEmpaquetador
		String returnUrl = this.getCatalogadorAvSession(request).getReturnURL();
//		borramos datos de sesion
		request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
		
		//Por si no nos llaman con el parametro returnURL, ponemos esta comprobacion que
		//debemos quitar en un futuro!!
		
		String url = HTTP + LdapUserDetailsUtils.getHost();
		if(returnUrl==null){
			returnUrl = BARRA + request.getSession().getServletContext().getInitParameter("url_portada");
		}
		if(LdapUserDetailsUtils.getSubdominio()!=null && 
		   !LdapUserDetailsUtils.getSubdominio().equals("") && 
		   !returnUrl.startsWith(LdapUserDetailsUtils.getSubdominio()))
		{
			returnUrl = LdapUserDetailsUtils.getSubdominio() + returnUrl;
		}
		url= url + returnUrl;

		response.sendRedirect(url);
	}







	public String accionSubmit(ActionMapping mapping, AccionSubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String accion= form.getAccion();
		
		String resAction = "";
		
		String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		//ResourceBundle datosResources = ResourceBundle.getBundle("application-resources_"+idioma);
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
		if (datosResources.getString("catalogadorAvanzado.Aceptar").equals(accion)) {
			resAction = "GuardarDatos";
		} else if (datosResources.getString("catalogadorAvanzado.Validar").equals(accion)) {
			resAction = "Validar";
		}else// if (datosResources.getString("catalogadorAvanzado.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		//}

		return resAction;
	}







	public void guardarMetadatos(ActionMapping mapping, GuardarMetadatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		InputStream is = null;
		String identificador= "";
		String usuario= "";
		String idioma= "";
		
		try {
			
			if (this.getCatalogadorAvSession(request) == null) {
				identificador = request.getParameter("identificador");
			} else {
				identificador = this.getCatalogadorAvSession(request)
						.getIdentificador();
			}
			usuario =LdapUserDetailsUtils.getUsuario(); 
			//Recogemos el idioma del navegador
//			idioma=LdapUserDetailsUtils.getIdioma();
//			if (idioma==null || idioma.equals("")){
//				idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
//			}
			javax.servlet.http.HttpSession session = request.getSession(true);
//			Cogemos el idioma de LanguageFilter de Soporte, que si estas logado coge el idioma de LDAP
			Locale idio=(Locale)session.getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			idioma=idio.getLanguage();
			
			LomAvanzadoVO lomAv= this.getCatalogadorAvSession(request).getMDSesion();
			
			if (lomAv == null){
				lomAv= new LomAvanzadoVO();
			}
			logger.debug("ASC - antes de entrar a generarMetadatos, IDENTIFICADOR " + identificador + " USUARIO " + usuario + " IDIOMA " + idioma);
	        this.getSrvCatalogacionAvanzadaService().generarMetadatos(identificador, usuario, lomAv, idioma);
			
	
		} catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
			
		}catch (Exception e){
			logger.error("Error Catalogacion, metodo guardarMetadatos: " + identificador + "; " + usuario + "; " +idioma);
			throw new java.lang.Exception("catalogador.avanzado", e);
		} 
		
		
	}




	public boolean sonValidosMetadatos(ActionMapping mapping, SonValidosMetadatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

//		String resultado= ""; 
		boolean ok= true;
		
		//String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
		Collection mensajes = new ArrayList();
		
		LomAvanzadoVO lomAv= this.getCatalogadorAvSession(request).getMDSesion();
		
		if (lomAv == null){
			lomAv= new LomAvanzadoVO();
		}
		logger.debug("Método de validacion de metadatos avanzados");
		
		// -- GENERAL --
		if(lomAv.getGeneral()==null){
			mensajes.add(datosResources.getString("CAV.1"));
		}
		else{
			
			AvGeneralVO gn = lomAv.getGeneral();
			if(gn.getIdentificadores()!=null && gn.getIdentificadores().length>0){
	//			CATALOGOS
				int i= 0;
				while ((ok)&&(i<gn.getIdentificadores().length)){
					
					if (gn.getIdentificadores()[i]!=null){
						String cat= gn.getIdentificadores()[i].getCatalogo();
						String ent= gn.getIdentificadores()[i].getEntrada();
						
						if(((cat==null)||(cat.trim().equals("")))&& ((ent!=null)&&(!ent.trim().equals("")))){//Si existe una entrada, un catálogo es obligatorio
								mensajes.add(datosResources.getString("CAV.1.1.1"));
								ok= false;
						}
					}
					
					i++;
				}
				//ENTRADAS
				i= 0;
				ok=true;
				while ((ok)&&(i<gn.getIdentificadores().length)){
					
					if (gn.getIdentificadores()[i]!=null){
						String cat= gn.getIdentificadores()[i].getCatalogo();
						String ent= gn.getIdentificadores()[i].getEntrada();
						
						if (((ent==null)||(ent.trim().equals("")))&& ((cat!=null)&&(!cat.trim().equals("")))){//Si existe un catálogo, una entrada es obligatoria
							mensajes.add(datosResources.getString("CAV.1.1.2"));
							ok= false;
						}
					}
						
					i++;
				}
			}
			//TITULOS
			boolean todosVacios=true;
			String texto= null;
			if(gn.getTitulo()!=null){
				for(int i=0;i<gn.getTitulo().getTextos().length && todosVacios ;i++)
				{
					if (gn.getTitulo().getTextos()[i]!=null){
						texto=gn.getTitulo().getTextos()[i].getTexto();
					}
					
					if(texto!=null && !texto.trim().equals(""))
					{
						todosVacios=false;
					}
				}
				if(todosVacios)
					mensajes.add(datosResources.getString("CAV.1.2"));//debe tener por lo menos un titulo
			}else
				mensajes.add(datosResources.getString("CAV.1.2"));//debe tener por lo menos un titulo
			
			//IDIOMA
			todosVacios=true;
			String idioma= null;
			if(gn.getIdiomas()!=null && gn.getIdiomas().length>0){
				for(int i=0;i<gn.getIdiomas().length && todosVacios;i++)
				{
					if (gn.getIdiomas()[i]!=null){
						idioma= gn.getIdiomas()[i].getTexto();
					}		
					if(idioma!=null && !idioma.equals(""))
					{
						todosVacios=false;
					}
				}
				if(todosVacios)
					mensajes.add(datosResources.getString("CAV.1.3"));//debe tener por lo menos un idioma
			}else
				mensajes.add(datosResources.getString("CAV.1.3"));//debe tener por lo menos un idioma
			
			todosVacios=true;
			String descripcion= null;
			if(gn.getDescripciones()!=null && gn.getDescripciones().length>0){
				for(int i=0;i<gn.getDescripciones().length && todosVacios;i++)
				{
					if (gn.getDescripciones()[i]!=null){
						for(int j=0;j<gn.getDescripciones()[i].getTextos().length && todosVacios;j++)
						{
							if (gn.getDescripciones()[i].getTextos()[j]!=null){
								descripcion=gn.getDescripciones()[i].getTextos()[j].getTexto();
							}

							if(descripcion!=null && !descripcion.trim().equals(""))
							{
								todosVacios=false;
							}
						}
					}
					
				}
				if(todosVacios)
					mensajes.add(datosResources.getString("CAV.1.4"));//al menos una descripcion
			}else
				mensajes.add(datosResources.getString("CAV.1.4"));//al menos una descripcion
			
			//NIVEL DE AGREGACION
			if(gn.getNivelAgregacion()!=null){
				if(gn.getNivelAgregacion().getValor()==null || gn.getNivelAgregacion().getValor().equals(""))
					mensajes.add(datosResources.getString("CAV.1.8"));
			}else
				mensajes.add(datosResources.getString("CAV.1.8"));
		}
		
		//		 -- CICLO DE VIDA --
		if(lomAv.getLifeCycle()!=null){
			AvLifeCycleVO life = lomAv.getLifeCycle();
//			CONTRIBUCION
			String rol;
			boolean errorContRol=false;
			boolean errorContEntidad=false;
			boolean errorContFecha=false;
			boolean errorFecha=true;
			boolean errorFechaVacia=false;
			boolean errorDescVacia=false;
			boolean errorMinutos=false;
			
			boolean todosVacios=true;

			ContribucionVO[] contribuciones= life.getContribuciones();
			
			

			if(contribuciones!=null && contribuciones.length>0){
				for(int i=0;i<contribuciones.length && (!errorContRol || !errorContEntidad || !errorContFecha) ;i++ )
				{
	//				ROL
					if(!errorContRol)
					{
						if(contribuciones[i].getTipo()!=null){
							rol=contribuciones[i].getTipo().getValor();
							if(rol==null || rol.trim().equals(""))
							{
								errorContRol =true;
								mensajes.add(datosResources.getString("CAV.2.3.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
							}
						}else{
							errorContRol =true;
							mensajes.add(datosResources.getString("CAV.2.3.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
						}
					}	
	//			//entidad
					if(!errorContEntidad)
					{
						todosVacios=true;
						if(contribuciones[i].getEntidades()!=null && contribuciones[i].getEntidades().length>0){
							for(int j=0;j<contribuciones[i].getEntidades().length && todosVacios;j++)
							{
								EntidadVO ent=contribuciones[i].getEntidades()[j];
								
								if (ent != null){
									if ((ent.getTexto()==null)||(ent.getTexto().trim().equals(""))){
										errorContEntidad=true;
										mensajes.add(datosResources.getString("CAV.2.3.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
									}
								}
								
							}
						}else{
							errorContEntidad=true;
							mensajes.add(datosResources.getString("CAV.2.3.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
						}
					}
					
						
					//fecha
					if(!errorContFecha)
					{
						if(contribuciones[i].getFecha()!=null){
							FechaVO fechaCont= contribuciones[i].getFecha();
							DescripcionVO descCont=fechaCont.getDescripcion();
							
							boolean fechaVacia=true;
							
							if (fechaCont!=null && fechaVacia){
								if ((fechaCont.getFecha()==null)||(fechaCont.getFecha().equals(""))){
									fechaVacia=false;
								}
							}else{
								fechaVacia=false;
							}
							
							
							boolean descVacios=true;
							String descFec= null;
							if (descCont!= null && descCont.getTextos()!=null && descCont.getTextos().length>0){
								for(int j=0;j<descCont.getTextos().length && descVacios;j++)
								{
									descFec= descCont.getTextos()[j].getTexto();
									if(descFec==null || descFec.trim().equals(""))
									{
										descVacios=false;// si todos los campos descripcion son vacios
									}
								}
							}else{
								descVacios=false;
							}
							
							if(descVacios && fechaVacia && !errorFecha)
							{
//								errorContFecha=true;
								errorFecha=false;
								mensajes.add(datosResources.getString("CAV.2.3.3"));//El campo FECHA	 es obligatorio
							}else if(!descVacios && fechaVacia && !errorFechaVacia && errorFecha ) 
							{
//								errorContFecha=true;
								errorFechaVacia=true;
								mensajes.add(datosResources.getString("CAV.2.3.3.2"));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
							}else if(descVacios && !fechaVacia && !errorDescVacia && errorFecha)
							{
//								errorContFecha=true;
								errorDescVacia=true;
								mensajes.add(datosResources.getString("CAV.2.3.3.1"));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
							}
				
//							if(errorFecha && errorFechaVacia && errorDescVacia && errorMinutos)
//								errorContFecha=true;
						}else{
							errorContFecha=true;
							errorFecha=false;
							mensajes.add(datosResources.getString("CAV.2.3.3"));//El campo FECHA	 es obligatorio
						}
					}
				}
			}
		}
		
		//		 -- METAMETADATA --
		if(lomAv.getMetaMetadata()==null){
			mensajes.add(datosResources.getString("CAV.3"));
		}
		else{
			AvMetametadataVO mm = lomAv.getMetaMetadata();
			
			int i= 0;
			boolean completo=true;
			boolean todosVacios=true;
			
			//IDENTIFICADORES
			IdentificadorVO[] identificadores= mm.getIdentificadores();
			if(identificadores!=null && identificadores.length>0){
				for(i=0;i<identificadores.length && completo;i++)
				{
					if((identificadores[i].getCatalogo()!=null && identificadores[i].getCatalogo().trim().equals("")) &&
					   (identificadores[i].getEntrada()!=null && !identificadores[i].getEntrada().trim().equals("")) )
					{
						completo=false;
						mensajes.add(datosResources.getString("CAV.3.1.1"));//Si existe una entrada para un identificador, un cat&aacute;logo es obligatorio
					}
				}
				completo=true;
				for(i=0;i<identificadores.length && completo;i++)
				{
					if((identificadores[i].getCatalogo()!=null && !identificadores[i].getCatalogo().trim().equals("")) &&
					   (identificadores[i].getEntrada()!=null && identificadores[i].getEntrada().trim().equals("")) )
					{
						completo=false;
						mensajes.add(datosResources.getString("CAV.3.1.2"));//Si existe un cat&aacute;logo para un identificador, una entrada es obligatoria
					}
				}
			}
			
			
			//CONTRIBUCION
			String rol;
			boolean errorContRol=false;
			boolean errorContEntidad=false;
			boolean errorContFecha=false;
			boolean errorFecha=true;
			boolean errorFechaVacia=false;
			boolean errorDescVacia=false;
			boolean errorMinutos=false;

			ContribucionVO[] contribuciones= mm.getContribuciones();
			if(contribuciones!=null && contribuciones.length>0){
				for(i=0;i<contribuciones.length && (!errorContRol || !errorContEntidad || !errorContFecha) ;i++ )
				{
	//				ROL
					if(!errorContRol)
					{
						if(contribuciones[i].getTipo()!=null){
							rol=contribuciones[i].getTipo().getValor();
							if(rol==null || rol.trim().equals(""))
							{
								errorContRol =true;
								mensajes.add(datosResources.getString("CAV.3.2.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
							}
						}else{
							errorContRol =true;
							mensajes.add(datosResources.getString("CAV.3.2.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
						}
					}	
	//			//entidad
					if(!errorContEntidad)
					{
						todosVacios=true;
						if(contribuciones[i].getEntidades()!=null && contribuciones[i].getEntidades().length>0){
							for(int j=0;j<contribuciones[i].getEntidades().length && todosVacios;j++)
							{
								EntidadVO ent=contribuciones[i].getEntidades()[j];
								
								if (ent != null){
									if ((ent.getTexto()==null)||(ent.getTexto().trim().equals(""))){
										errorContEntidad=true;
										mensajes.add(datosResources.getString("CAV.3.2.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
									}
								}
								
							}
						}else{
							errorContEntidad=true;
							mensajes.add(datosResources.getString("CAV.3.2.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
						}
					}
						
					//fecha
					if(!errorContFecha)
					{
						if(contribuciones[i].getFecha()!=null){
							FechaVO fechaCont= contribuciones[i].getFecha();
							DescripcionVO descCont=fechaCont.getDescripcion();
							
							boolean fechaVacia=true;
							
							if (fechaCont!=null && fechaVacia){
								if ((fechaCont.getFecha()==null)||(fechaCont.getFecha().equals(""))){
									fechaVacia=false;
								}
							}else{
								fechaVacia=false;
							}
							
							boolean descVacios=true;
							String descFec= null;
							if (descCont!= null){
								for(int j=0;j<descCont.getTextos().length && descVacios;j++)
								{
									descFec= descCont.getTextos()[j].getTexto();
									if(descFec==null && descFec.trim().equals(""))
									{
										descVacios=false;// si todos los campos descripcion son vacios
									}
								}
							}else{
								descVacios=false;
							}
							
							if(descVacios && fechaVacia && !errorFecha)
							{
//								errorContFecha=true;
								errorFecha=false;
								mensajes.add(datosResources.getString("CAV.3.2.3"));//El campo FECHA	 es obligatorio
							}else if(!descVacios && fechaVacia && !errorFechaVacia && errorFecha) 
							{
//								errorContFecha=true;
								errorFechaVacia=true;
								mensajes.add(datosResources.getString("CAV.3.2.3.2"));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
							}else if(descVacios && !fechaVacia && !errorDescVacia && errorFecha)
							{
//								errorContFecha=true;
								errorDescVacia=true;
								mensajes.add(datosResources.getString("CAV.3.2.3.1"));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
							}
				
//							if(errorFecha && errorFechaVacia && errorDescVacia && errorMinutos)
//								errorContFecha=true;
						}else{
							errorContFecha=true;
							errorFecha=true;
							mensajes.add(datosResources.getString("CAV.3.2.3"));//El campo FECHA	 es obligatorio
						}
					}
				}
			}

//			EsquemaDeMetadatosVO[] esquemasMeta= mm.getEsquemas(); No es obligatorio
//			//ESQUEMA METADATOS
//			todosVacios=true;
//			String esquema;
//			if(esquemasMeta!=null && esquemasMeta.length>0){
//				for(i=0;i<esquemasMeta.length && todosVacios;i++)
//				{
//					esquema=esquemasMeta[i].getTexto();
//					if(esquema!=null && !esquema.trim().equals(""))
//					{
//						todosVacios=false;
//					}
//				}
//				if(todosVacios)
//					mensajes.add(datosResources.getString("CAV.3.3"));//El campo Esquema de metadatos es obligatorio
//			}else{
//				mensajes.add(datosResources.getString("CAV.3.3"));//El campo Esquema de metadatos es obligatorio
//			}
			
			
			//IDIOMA
			if(mm.getIdioma()!=null){
				if(mm.getIdioma().getTexto()==null || mm.getIdioma().getTexto().equals(""))
					mensajes.add(datosResources.getString("CAV.3.4"));//El campo Idioma es obligatorio
			}else
				mensajes.add(datosResources.getString("CAV.3.4"));//El campo Idioma es obligatorio
			
		}
		
		//		 -- TECHNICAL --
		if (lomAv.getTechnical()!=null){
			
			AvTechnicalVO tec= lomAv.getTechnical();
			
//			NOMBRE

			
			if(tec.getRequisitos()!=null && tec.getRequisitos().length>0){
				
				ok=true;
				int i= 0;
				while ((ok)&&(i<tec.getRequisitos().length)){
					AgregadorORVO[] cat= tec.getRequisitos()[i].getAgregadoresOR();
					if(cat!=null && cat.length>0){
						int j=0;
						while((ok)&&(j<cat.length)){
							String nombre="";
							String tipo="";
							String maxi="";
							String mini="";
							SourceValueVO sNombre= cat[j].getNombre();
							SourceValueVO sTipo=cat[j].getTipo();
							if(sNombre!=null){
								nombre=sNombre.getValor();
							}
							if(sTipo!=null){
								tipo=sTipo.getValor();
							}
							VersionMinVO min=cat[j].getVersionMin();
							if(min!=null && min.getTexto()!=null){
								mini=min.getTexto().trim();
							}
							
							VersionMaxVO max=cat[j].getVersionMax();
							if(max!=null && max.getTexto()!=null){
								maxi=max.getTexto().trim();
							}

							if(((nombre==null)||(nombre.equals("")))&&(((!tipo.equals("")))||((!mini.equals("")))||((!maxi.equals(""))))){
								mensajes.add(datosResources.getString("CAV.4.4.1.2"));
								ok= false;
							}
							
							j++;		
						}
						
					}
						
					i++;
				}
				
				//TIPO
				ok=true;
				i= 0;
				while ((ok)&&(i<tec.getRequisitos().length)){
					AgregadorORVO[] cat= tec.getRequisitos()[i].getAgregadoresOR();
					if(cat!=null && cat.length>0){
						int j=0;
						while((ok)&&(j<cat.length)){
							String nombre="";
							String tipo="";
							String maxi="";
							String mini="";
							SourceValueVO sNombre= cat[j].getNombre();
							SourceValueVO sTipo=cat[j].getTipo();
							if(sNombre!=null){
								nombre=sNombre.getValor();
							}
							if(sTipo!=null){
								tipo=sTipo.getValor();
							}
							VersionMinVO min=cat[j].getVersionMin();
							if(min!=null && min.getTexto()!=null){
								mini=min.getTexto().trim();
							}
							
							VersionMaxVO max=cat[j].getVersionMax();
							if(max!=null && max.getTexto()!=null){
								maxi=max.getTexto().trim();
							}
							if(((tipo==null)||(tipo.equals("")))&&(((!nombre.equals("")))||((!mini.equals("")))||((!maxi.equals(""))))){
								mensajes.add(datosResources.getString("CAV.4.4.1.1"));
								ok= false;
							}
							
							j++;		
						}
					}
						i++;
					
				}
				
				//DURACION
				boolean todosVacios=true;

		        String descripcion;
		        if(tec.getDuracion()!=null){
		        	if((tec.getDuracion().getDescripcion()!=null)&&(tec.getDuracion().getDescripcion().getTextos()!=null)&&(tec.getDuracion().getDescripcion().getTextos().length>0)){
				        for(i=0;i<tec.getDuracion().getDescripcion().getTextos().length && todosVacios;i++)
				        {
		                    descripcion=tec.getDuracion().getDescripcion().getTextos()[i].getTexto();
		                    if(descripcion!=null && !descripcion.trim().equals(""))
		                    {
		                         todosVacios=false;
		                    }
				        }
		        	}
		        }
		        boolean duracionVacia=true;
		        if(tec.getDuracion()!=null){
			        if ((tec.getDuracion().getDuracion() != null)&&(!tec.getDuracion().getDuracion().equals(""))){
			        	duracionVacia=false;
			        }
		        }
	
		        if(todosVacios && !duracionVacia)
		              mensajes.add(datosResources.getString("CAV.4.7.2"));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
		        if(!todosVacios && duracionVacia)
		             mensajes.add(datosResources.getString("CAV.4.7.1"));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n
			}
		}
		//USO EDUCATIVO
		if ((lomAv.getEducational()==null)||(lomAv.getEducational().length==0)){
			mensajes.add(datosResources.getString("CAV.5")); //Al menos debe existir una categor&iacute;a Uso Educativo
		}
		else{
			for (int indexEdu= 0; indexEdu<lomAv.getEducational().length; indexEdu++){
				AvEducationalVO edu= lomAv.getEducational()[indexEdu];
				
				boolean todosVacios=true;
				int i;

			  	//TIPO DE RECURSO DE APRENDIZAJE
				String recurso= null;
				if(edu.getTiposrecursoedu()!=null && edu.getTiposrecursoedu().length>0){
					for(i=0;i<edu.getTiposrecursoedu().length && todosVacios;i++)
					{
						recurso= edu.getTiposrecursoedu()[i].getValor();
						if(recurso!=null && !recurso.equals(""))
						{
							todosVacios=false;
						}
					}
					if(todosVacios)
						mensajes.add(datosResources.getString("CAV.5.2.1")+" "+ (indexEdu+1));//El campo Tipo de recurso es obligatorio
				}else
					mensajes.add(datosResources.getString("CAV.5.2.1")+" "+ (indexEdu+1));//El campo Tipo de recurso es obligatorio
				//IDIOMA
				todosVacios=true;
				String idioma= null;
				if(edu.getIdiomas()!=null && edu.getIdiomas().length>0){
					for(i=0;i<edu.getIdiomas().length && todosVacios;i++)
					{
						idioma= edu.getIdiomas()[i].getTexto();
						if(idioma!=null && !idioma.equals(""))
						{
							todosVacios=false;
						}
					}
					if(todosVacios)
						mensajes.add(datosResources.getString("CAV.5.11.1")+" "+(indexEdu+1));//El campo Idioma es obligatorio
				}else
					mensajes.add(datosResources.getString("CAV.5.11.1")+" "+(indexEdu+1));//El campo Idioma es obligatorio
				
			  	//TIEMPO DE APRENDIZAJE
				//DESCRIPCIONES
				todosVacios=true;
				String descripcion;
				if(edu.getTiempoAprendizaje()!=null && edu.getTiempoAprendizaje().getDescripcion()!=null && edu.getTiempoAprendizaje().getDescripcion().getTextos()!=null && edu.getTiempoAprendizaje().getDescripcion().getTextos().length>0){
					for(i=0;i<edu.getTiempoAprendizaje().getDescripcion().getTextos().length && todosVacios;i++)
					{
							descripcion=edu.getTiempoAprendizaje().getDescripcion().getTextos()[i].getTexto();
							if(descripcion!=null && !descripcion.trim().equals(""))
							{
								todosVacios=false;
							}
					}
				}
				
				//DURACION
				boolean duracionVacia=true;
				if(edu.getTiempoAprendizaje()!=null){
					if ((edu.getTiempoAprendizaje().getDuracion()!=null)&&(!edu.getTiempoAprendizaje().getDuracion().equals(""))){
						duracionVacia=false;
					}
				}
							
				if(todosVacios && !duracionVacia)
					mensajes.add(datosResources.getString("CAV.5.9.2.1")+" "+(indexEdu+1));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
				if(!todosVacios && duracionVacia)
					mensajes.add(datosResources.getString("CAV.5.9.1.1")+" "+(indexEdu+1));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n

			}
		}
		
		// -- DERECHOS --
		if(lomAv.getDerechos()==null){
			mensajes.add(datosResources.getString("CAV.6"));
		}
		else{
//			COPYRIGHT 
			AvRightsVO de= lomAv.getDerechos();
			if(de!=null && de.getDerechosDeAutor()!=null){
				String copyright= de.getDerechosDeAutor().getValor();
		    	if(copyright==null || copyright.equals(""))
		    	{
		    		mensajes.add(datosResources.getString("CAV.6.2"));
		    	}
			}else{
				mensajes.add(datosResources.getString("CAV.6.2"));
			}
	    	
	    	//ACCESO
			if(de!=null && de.getAcceso()!=null && de.getAcceso().getTipo()!=null){
		    	String tipoAcceso= de.getAcceso().getTipo().getValor();
		    	if(tipoAcceso==null || tipoAcceso.equals(""))
		    	{
		    		mensajes.add(datosResources.getString("CAV.6.4.1"));
		    	}
			}else{
				mensajes.add(datosResources.getString("CAV.6.4.1"));
			}
	    	
	    	//AMBITO
			if(de!=null && 
			   de.getAcceso()!=null && de.getAcceso().getDescripcion()!=null && 
			   de.getAcceso().getDescripcion().getTextos()!=null && de.getAcceso().getDescripcion().getTextos().length>0)
			{
				if(de.getAcceso().getTipo()!=null && de.getAcceso().getTipo().getValor() !=null && !de.getAcceso().getTipo().getValor().equalsIgnoreCase("universal"))
				{
			    	String comunidades= de.getAcceso().getDescripcion().getTextos()[0].getTexto();
			    	if(comunidades==null || comunidades.trim().equals(""))
			    	{
			    		mensajes.add(datosResources.getString("CAV.6.4.2"));//Es necesario seleccionar al menos un &aacute;mbito
			    	}
				}
			}
		}
		
		// -- RELACION --
		if ((lomAv.getRelaciones()!=null)&&(lomAv.getRelaciones().length>0)){
			
			for (int indexRelacion= 0; indexRelacion<lomAv.getRelaciones().length; indexRelacion++){
				AvRelationVO re= lomAv.getRelaciones()[indexRelacion];

				ok= true;
				
				//TIPO
				if((re.getTipo()!=null)){
					String tip=re.getTipo().getValor();
					if((tip==null)||(tip.equals("")))
						mensajes.add(datosResources.getString("CAV.7.1.7")+" "+(indexRelacion+1));
				}
				
				//IDENTIFICADOR
				if (ok && ((re.getRecurso() == null) ||(re.getRecurso().getIdentificador()== null))&&(re.getTipo()!=null))
					mensajes.add(datosResources.getString("CAV.7.3.7")+" "+(indexRelacion+1));
				if((ok)&&(re.getRecurso()!=null)&&(re.getRecurso().getIdentificador()!=null)&&(re.getTipo()!=null)){
					String cat=re.getRecurso().getIdentificador().getCatalogo();
					String ent=re.getRecurso().getIdentificador().getEntrada();
					
					if(((cat==null)||(cat.trim().equals("")))&& ((ent==null)||(ent.trim().equals("")))){//Si existe una entrada, un catálogo es obligatorio
						mensajes.add(datosResources.getString("CAV.7.3.7")+" "+(indexRelacion+1));
						ok= false;
					}
					
				}
	//			CATALOGOS
				ok=true;
				if((ok)&&(re.getRecurso()!=null)&&(re.getRecurso().getIdentificador()!=null)&&(re.getTipo()!=null)){
					String cat=re.getRecurso().getIdentificador().getCatalogo();
					String ent=re.getRecurso().getIdentificador().getEntrada();
					
					if(((cat==null)||(cat.trim().equals("")))&& ((ent!=null)&&(!ent.trim().equals("")))){//Si existe una entrada, un catálogo es obligatorio
						mensajes.add(datosResources.getString("CAV.7.3.1.7")+" "+(indexRelacion+1));
						ok= false;
					}
					
				}
				
				//ENTRADAS
				if((ok)&&(re.getRecurso()!=null)&&(re.getRecurso().getIdentificador()!=null)){
					String cat=re.getRecurso().getIdentificador().getCatalogo();
					String ent=re.getRecurso().getIdentificador().getEntrada();
					
					if (((ent==null)||(ent.trim().equals("")))&& ((cat!=null)&&(!cat.trim().equals("")))){//Si existe un catálogo, una entrada es obligatoria
						mensajes.add(datosResources.getString("CAV.7.3.2.7")+ " "+(indexRelacion+1));
						ok= false;
					}
					
				}
			}
		}
		
		// -- ANOTACION --
		if ((lomAv.getAnotaciones()!=null)&&(lomAv.getAnotaciones().length>0)){
			int i;
			boolean todosVacios=true;
			
			for (int indexAnotacion= 0; indexAnotacion<lomAv.getAnotaciones().length; indexAnotacion++){
				
				AvAnnotationVO an= lomAv.getAnotaciones()[indexAnotacion];
				//ENTIDAD
				if(an.getEntidad()!=null){
					String entidad= an.getEntidad().getTexto();
					if ((entidad==null)||(entidad.trim().equals(""))){
						mensajes.add(datosResources.getString("CAV.8.1.8")+" "+(indexAnotacion+1));//El campo Entidad es obligatorio
					}
				}
				
				//FECHA
				boolean fechaVacia=false;
				if(an.getFecha()!=null){
					String fecha= an.getFecha().getFecha();
					if ((fecha==null)||(fecha.equals(""))){
						fechaVacia=true;
					}
				}else{
					fechaVacia=true;
				}
				
				boolean descVacios=false;
				if(an.getFecha()!=null && an.getFecha().getDescripcion()!=null && an.getFecha().getDescripcion().getTextos()!=null && an.getFecha().getDescripcion().getTextos().length>0){
					String descFec= an.getFecha().getDescripcion().getTextos()[0].getTexto();
					if ((descFec==null)||(descFec.trim().equals(""))){
						descVacios=true;
					}
				}else{
					descVacios=true;
				}
	
	
				if(descVacios && fechaVacia)
				{
					mensajes.add(datosResources.getString("CAV.8.2.8")+" "+(indexAnotacion+1));//El campo FECHA es obligatorio
				}else if(descVacios && !fechaVacia)
				{
					mensajes.add(datosResources.getString("CAV.8.2.2.8")+" "+(indexAnotacion+1));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
				}else if(!descVacios && fechaVacia)
				{
					mensajes.add(datosResources.getString("CAV.8.2.1.8")+" "+(indexAnotacion+1));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
				}
				
				
				//DESCRIPCION
				String desc;
				if(an.getDescripcion()!=null && an.getDescripcion().getTextos()!=null && an.getDescripcion().getTextos().length>0){
					for(i=0;i<an.getDescripcion().getTextos().length && todosVacios;i++)
					{
						desc= an.getDescripcion().getTextos()[i].getTexto();
						if(desc!=null && !desc.trim().equals(""))
						{
							todosVacios=false;
						}
					}
					if(todosVacios)
						mensajes.add(datosResources.getString("CAV.8.3.8")+" "+(indexAnotacion+1));//El campo Descripci&oacute;n es obligatorio
				}else
					mensajes.add(datosResources.getString("CAV.8.3.8")+" "+(indexAnotacion+1));//El campo Descripci&oacute;n es obligatorio
			}
		}
		// --CLASIFICACION--
		
		if ((lomAv.getClasificaciones()!=null)&&(lomAv.getClasificaciones().length>0)){
			
			for (int indexClasificacion= 0; indexClasificacion<lomAv.getClasificaciones().length; indexClasificacion++){
				AvClassificationVO cl= lomAv.getClasificaciones()[indexClasificacion];
				
			
				if(cl.getProposito()!=null){
					if ((cl.getProposito().getValor()==null)||(cl.getProposito().getValor().equals(""))){
						mensajes.add(datosResources.getString("CAV.9.1.9")+" "+(indexClasificacion+1));
					}
				}
				else{
					mensajes.add(datosResources.getString("CAV.9.1.9")+" "+(indexClasificacion+1));
				}
			  	boolean errorDado=true;
				if(cl.getRutasTaxonomicas()!=null && cl.getRutasTaxonomicas().length>0 && errorDado){
					for (int i= 0; i<cl.getRutasTaxonomicas().length; i++){
						boolean vacio=false;
						boolean propVacio=false;
						boolean taxonVacio=false;
						boolean todoVacio=true;
						if(cl.getRutasTaxonomicas().length==1){
							if(cl.getRutasTaxonomicas()[0].getFuente()!=null && cl.getRutasTaxonomicas()[0].getFuente().getTextos()!=null && cl.getRutasTaxonomicas()[0].getFuente().getTextos().length>0){
								String sce= cl.getRutasTaxonomicas()[i].getFuente().getTextos()[0].getTexto();
								if ((sce==null)||(sce.equals(""))){
									propVacio=true;
								}
							}
							if(cl.getRutasTaxonomicas()[0].getTaxones()!=null && cl.getRutasTaxonomicas()[0].getTaxones().length>0 ){
								if(cl.getRutasTaxonomicas()[0].getTaxones().length==1){
									if(cl.getRutasTaxonomicas()[0].getTaxones()[0].getId()!=null &&  cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry()!=null &&
											cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry().getTextos()!=null && cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry().getTextos().length>0){ 
											String id= cl.getRutasTaxonomicas()[0].getTaxones()[0].getId().getTexto();
											String entry= cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry().getTextos()[0].getTexto();
											if ((id==null)||(id.equals(""))||((entry==null)||(entry.equals("")))){
												taxonVacio=true;
											}
									}
								}
								
							}
							if(propVacio && taxonVacio){
								mensajes.add(datosResources.getString("CAV.9.2")+" "+(indexClasificacion+1));
								todoVacio=false;
							}
						}
						
						if(cl.getRutasTaxonomicas()[i].getFuente()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos().length>0 && todoVacio){
							String sce= cl.getRutasTaxonomicas()[i].getFuente().getTextos()[0].getTexto();
							if ((sce==null)||(sce.equals(""))){
								mensajes.add(datosResources.getString("CAV.9.2.1")+" "+(indexClasificacion+1));
								errorDado=false;
							}	
						}
						else{
							mensajes.add(datosResources.getString("CAV.9.2.1")+" "+(indexClasificacion+1));
							errorDado=false;
						}
						
						
						if(cl.getRutasTaxonomicas()[i].getTaxones()!=null && cl.getRutasTaxonomicas()[i].getTaxones().length>0){
							if(cl.getRutasTaxonomicas()[i].getTaxones().length==1){
								TaxonVO[] taxones=cl.getRutasTaxonomicas()[i].getTaxones();
								boolean identVacio=false;
								if(taxones!=null && taxones.length>0){
									EntryVO entrada=taxones[0].getEntry();
									IdVO identif=taxones[0].getId();
									
									if(identif!=null && !identif.equals("")){
										String identifiTexto=identif.getTexto();
										if(identifiTexto!=null && !identifiTexto.equals("")){
											identVacio=false;
										}else{
											identVacio=true;
										}
									}else{
										identVacio=true;
									}
									boolean entradaLlena=false;
									if(entrada!=null && entrada.getTextos()!=null && entrada.getTextos().length>0){
										int k=0;
										
										while(k<entrada.getTextos().length && !entradaLlena){
											LangStringVO[] entradaTexto = entrada.getTextos();
											String textoEntrada=entradaTexto[k].getTexto();
											if(textoEntrada!=null && !textoEntrada.equals("")){
												entradaLlena=true;
											}
											k++;
										}
									}else{
										entradaLlena=true;
									}
									if(!entradaLlena && identVacio){
										mensajes.add(datosResources.getString("CAV.9.2.2.9")+" "+(indexClasificacion+1));
										errorDado=false;
									}
								}else{
									mensajes.add(datosResources.getString("CAV.9.2.2.9")+" "+(indexClasificacion+1));
									errorDado=false;
								}
							}
						}else{
							mensajes.add(datosResources.getString("CAV.9.2.2.9")+" "+(indexClasificacion+1));
							errorDado=false;
						}
					}
				}
				else{
					mensajes.add(datosResources.getString("CAV.9.2.2.9")+" "+(indexClasificacion+1));
					errorDado=false;
				}
				
			}
		}
        	
		if(mensajes.size()>0)
		{ 
			form.setMensajesError(mensajes);
			return false;
		}else{
			return true;
		}
	}







	public void borrarSesion(
			ActionMapping mapping, 
			BorrarSesionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String returnUrl = this.getCatalogadorAvSession(request).getReturnURL();
    	//	borramos datos de sesion
		request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
		//Por si no nos llaman con el parametro returnURL, ponemos esta comprobacion que
		//si hemos perdido la sesion vamos a la portada del visualizador de contenidos
		
		String url = HTTP + LdapUserDetailsUtils.getHost();
		if(returnUrl==null){
			returnUrl = BARRA + request.getSession().getServletContext().getInitParameter("url_portada");
		}
		if(LdapUserDetailsUtils.getSubdominio()!=null && 
		   !LdapUserDetailsUtils.getSubdominio().equals("") && 
		   !returnUrl.startsWith(LdapUserDetailsUtils.getSubdominio()))
		{
			returnUrl = LdapUserDetailsUtils.getSubdominio() + returnUrl;
		}
		url= url + returnUrl;
		
		response.sendRedirect(url);//Redirigimos a Empaquetador
	}

}