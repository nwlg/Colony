/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.catalogacion.negocio.servicios.AgregadorORVO;
import es.pode.catalogacion.negocio.servicios.AmbitoVO;
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
import es.pode.catalogacion.negocio.servicios.DuracionVO;
import es.pode.catalogacion.negocio.servicios.EntidadVO;
import es.pode.catalogacion.negocio.servicios.EntryVO;
import es.pode.catalogacion.negocio.servicios.EsquemaDeMetadatosVO;
import es.pode.catalogacion.negocio.servicios.FormatoVO;
import es.pode.catalogacion.negocio.servicios.FuenteVO;
import es.pode.catalogacion.negocio.servicios.IdVO;
import es.pode.catalogacion.negocio.servicios.IdentificadorVO;
import es.pode.catalogacion.negocio.servicios.IdiomaVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LocalizacionVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.OtrosRequisitosVO;
import es.pode.catalogacion.negocio.servicios.PalabraClaveVO;
import es.pode.catalogacion.negocio.servicios.PautasInstalacionVO;
import es.pode.catalogacion.negocio.servicios.RangoEdadVO;
import es.pode.catalogacion.negocio.servicios.RequisitoVO;
import es.pode.catalogacion.negocio.servicios.RutaTaxonomicaVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.TamanioVO;
import es.pode.catalogacion.negocio.servicios.TaxonVO;
import es.pode.catalogacion.negocio.servicios.TituloVO;
import es.pode.catalogacion.negocio.servicios.VersionMaxVO;
import es.pode.catalogacion.negocio.servicios.VersionMinVO;
import es.pode.catalogacion.negocio.servicios.VersionVO;
import es.pode.catalogacion.soporte.Contribucion;
import es.pode.catalogacion.soporte.Entidad;
import es.pode.catalogacion.soporte.Fecha;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.catalogadorWeb.presentacion.DecisorOffline;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController
 */
public class VerMetadatosControllerImpl extends VerMetadatosController
{

	private static final String HTTP ="http://";
	private static final String BARRA ="/";
	private static final String SEPARADOR =":";


	protected static Logger logger = Logger.getLogger(VerMetadatosControllerImpl.class); 
	
	private String anyos;
  	private String meses;
  	private String dias;
//  	private String fechasCortas;
  	private String horas;
  	private String minutos;
  	private String segundosP1;
  	private String segundosP2;
  	private String duracion;
  	private int indi;
  	private int iEdu;
	private int iRel;
	
	String catalogo,entrada;

    /**
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController#cargarDatosAv(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosAvForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDatosAv(
    		ActionMapping mapping, 
    		CargarDatosAvForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		try{
	        
			javax.servlet.http.HttpSession session = request.getSession(true);
			Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
			
	        CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	        
	        String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	        String usuario =LdapUserDetailsUtils.getUsuario();//"empaquetador";//
	        String identificador =request.getParameter("identificador");
	        if(identificador==null){
	        	identificador=catalogadorAvSession.getIdentificador();
	        }
	        is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
	       

			LomAvanzadoVO lomAvanzado= null;
			
			//Para no modificar todo el método, hago aqi la comprobacion de si el identificador es null--> se ha perdido la sesion!!
			//ya que arriba se recoge de request y si no, de session!
			if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
			/////////////////////////////////////////////////////////////////////////////////////
			if (attribute == null || ((CatalogadorAvSession)attribute).getMDSesion() == null 
					|| !identificador.equals(((CatalogadorAvSession)attribute).getIdentificador()))
				lomAvanzado= this.getSrvCatalogacionAvanzadaService().obtenerLomAvanzado(identificador,usuario,idiomaLdap);//Engancharselo al objeto de session
			else
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
					lom.setGeneral(lomAvanzado.getGeneral());
				}
				
				//cargamos el ciclo de vida
				if(lomAvanzado.getLifeCycle()!=null){
					lom.setLifeCycle(lomAvanzado.getLifeCycle());
				}
				
				//cargamos los meta-metadatos
				if(lomAvanzado.getMetaMetadata()!=null){
					lom.setMetaMetadata(lomAvanzado.getMetaMetadata());
				}
				
				//cargamos tecnica		
				if(lomAvanzado.getTechnical()!=null){
					lom.setTechnical(lomAvanzado.getTechnical());
				}
				
				//cargamos usos educativos
				if((lomAvanzado.getEducational()!=null)&&(lomAvanzado.getEducational().length>0)){
					ArrayList educationals=new ArrayList();
					for (int i=0; i<lomAvanzado.getEducational().length;i++){
						educationals.add(lomAvanzado.getEducational()[i]);
					}
					AvEducationalVO[] educational=(AvEducationalVO[])educationals.toArray(new AvEducationalVO[educationals.size()]);
					lom.setEducational(educational);
				}
				
				
				//cargamos derechos
				if(lomAvanzado.getDerechos()!=null){
					lom.setDerechos(lomAvanzado.getDerechos());
				}
				
				
				//cargamos relaciones
				if((lomAvanzado.getRelaciones()!=null)&&(lomAvanzado.getRelaciones().length>0)){
					ArrayList relation=new ArrayList();
					for(int i=0;i<lomAvanzado.getRelaciones().length;i++){
						relation.add(lomAvanzado.getRelaciones()[i]);
					}
					AvRelationVO[] relaciones=(AvRelationVO[])relation.toArray(new AvRelationVO[relation.size()]);
					lom.setRelaciones(relaciones);
				}
				
				//cargamos anotaciones
				if((lomAvanzado.getAnotaciones()!=null)&&(lomAvanzado.getAnotaciones().length>0)){
					ArrayList annotation=new ArrayList();
					for(int i=0;i<lomAvanzado.getAnotaciones().length;i++){
						annotation.add(lomAvanzado.getAnotaciones()[i]);
					}
					AvAnnotationVO[] anotaciones=(AvAnnotationVO[])annotation.toArray(new AvAnnotationVO[annotation.size()]);
					lom.setAnotaciones(anotaciones);
				}
				
				//cargamos clasificaciones
				if((lomAvanzado.getClasificaciones()!=null)&&(lomAvanzado.getClasificaciones().length>0)){
					ArrayList classification=new ArrayList();
					for(int i=0;i<lomAvanzado.getClasificaciones().length;i++){
						classification.add(lomAvanzado.getClasificaciones()[i]);
					}
					AvClassificationVO[] clasificaciones=(AvClassificationVO[])classification.toArray(new AvClassificationVO[classification.size()]);
					lom.setClasificaciones(clasificaciones);
				}
				
				catalogadorAvSession.setMDSesion(lom);
				
			}else{
				//cargamos general
				if(lomAvanzado.getGeneral()!=null){
			       catalogadorAvSession.getMDSesion().setGeneral(lomAvanzado.getGeneral());
				}
		       //cargamos el ciclo de vida
				if(lomAvanzado.getLifeCycle()!=null){
			       catalogadorAvSession.getMDSesion().setLifeCycle(lomAvanzado.getLifeCycle());
				}
		       //cargamos el metametadata
				if(lomAvanzado.getMetaMetadata()!=null){
			       catalogadorAvSession.getMDSesion().setMetaMetadata(lomAvanzado.getMetaMetadata());
				}
		       //cargamos technical
				if(lomAvanzado.getTechnical()!=null){
			       catalogadorAvSession.getMDSesion().setTechnical(lomAvanzado.getTechnical());
				}
		       
		       //cargamos educationales
				if((lomAvanzado.getEducational()!=null)&&(lomAvanzado.getEducational().length>0)){
					
					ArrayList educationals=new ArrayList();
					for (int i=0; i<lomAvanzado.getEducational().length;i++){
						educationals.add(lomAvanzado.getEducational()[i]);
					}
					AvEducationalVO[] educational=(AvEducationalVO[])educationals.toArray(new AvEducationalVO[educationals.size()]);
					catalogadorAvSession.getMDSesion().setEducational(educational);
				}
				
		       //cargamos derechos
				if(lomAvanzado.getDerechos()!=null){
			       catalogadorAvSession.getMDSesion().setDerechos(lomAvanzado.getDerechos());
				}
		       //cargamos relaciones
				if((lomAvanzado.getRelaciones()!=null)&&(lomAvanzado.getRelaciones().length>0)){
			       ArrayList relation=new ArrayList();
					for(int i=0;i<lomAvanzado.getRelaciones().length;i++){
						relation.add(lomAvanzado.getRelaciones()[i]);
					}
					AvRelationVO[] relaciones=(AvRelationVO[])relation.toArray(new AvRelationVO[relation.size()]);
					catalogadorAvSession.getMDSesion().setRelaciones(relaciones);
				}
				
		       //cargamos anotaciones
				if((lomAvanzado.getAnotaciones()!=null)&&(lomAvanzado.getAnotaciones().length>0)){
			        ArrayList annotation=new ArrayList();
					for(int i=0;i<lomAvanzado.getAnotaciones().length;i++){
						annotation.add(lomAvanzado.getAnotaciones()[i]);
					}
					AvAnnotationVO[] anotaciones=(AvAnnotationVO[])annotation.toArray(new AvAnnotationVO[annotation.size()]);
					catalogadorAvSession.getMDSesion().setAnotaciones(anotaciones);
				}
		       
		       //cargamos clasificaciones
				if((lomAvanzado.getClasificaciones()!=null)&&(lomAvanzado.getClasificaciones().length>0)){   
			       ArrayList classification=new ArrayList();
					for(int i=0;i<lomAvanzado.getClasificaciones().length;i++){
						classification.add(lomAvanzado.getClasificaciones()[i]);
					}
					AvClassificationVO[] clasificaciones=(AvClassificationVO[])classification.toArray(new AvClassificationVO[classification.size()]);
					catalogadorAvSession.getMDSesion().setClasificaciones(clasificaciones);
				}
			}
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
			
		}catch (Exception e){
			logger.error("Error en Servicio de catalogacion avanzado, metodo cargarDatosAv" + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
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
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController#volverA(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.verMetadatos.VolverAForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void volverA(
    		ActionMapping mapping, 
    		VolverAForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	try {
	//    	Recogemos el parametro para ir al modulo que nos llama (posiblemente Buscador...)
			String returnUrl = this.getCatalogadorAvSession(request).getReturnURL();
	//		borramos datos de sesion
			request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
			
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
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
			
		}catch (Exception e){
			logger.error("Error en Servicio de catalogacion avanzado, metodo cargarDatosAv" + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}
    }




    /**
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController#cargarDatosGeneral(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosGeneralForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDatosGeneral(
    		ActionMapping mapping, 
    		CargarDatosGeneralForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
		InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

			//Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
		        
			//comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			}	
			//comprobamos que general no se ha null, si es null nos creamos uno	
			boolean generalEsNull = false;
			if (catalogadorAvSession.getMDSesion().getGeneral() == null){
				AvGeneralVO general = new AvGeneralVO();
				catalogadorAvSession.getMDSesion().setGeneral(general);
				generalEsNull=true;
			}
			
			
			//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
			String[] l_id = { prop.getProperty("idioma"),prop.getProperty("estructura"),prop.getProperty("nivelDeAgregacion"),prop.getProperty("idiomaDestinatario")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);

			longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
			TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
			ArrayList terminoypadrear=new ArrayList();
			
			Collection id = new ArrayList();
			Collection idDest = new ArrayList();
			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {
				case 0:
					
					id.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
					
					for (int li=0; li<terminos.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminos[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra="";
						if(!textoIdioma.equals("x-none")){
							idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						}else{
							idiomasTra=datosResources.getString("x-none");
						}
						idAux.setNomTermino(idiomasTra);
					}
					
					UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrd = terminosOrdDest1.ordenarTerminosVO(terminos, idiomaLdap);
					
					Collection id2 = Arrays.asList(terminosOrd);
					
					Iterator z = id2.iterator();
					while (z.hasNext()) {
						id.add(z.next());
					}

					if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getIdiomas() !=null)
							&& (catalogadorAvSession.getMDSesion().getGeneral().getIdiomas().length>0)) {
						IdiomaVO[] idiomasVO =catalogadorAvSession.getMDSesion().getGeneral().getIdiomas();
						for(int j=0;j<idiomasVO.length;j++){
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino(idiomasVO[j].getTexto());
							terminoypadrear.add(terminoypadreVO);
						}//terminoYPadreVO rellenado con los idiomas desde el lom avanzado
					}
					else {
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino("");
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 1:
					Collection tEstructura = new ArrayList();
					tEstructura.add(terminoVO);
					Collection tEstructura2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont = tEstructura2.iterator();
					while (cont.hasNext()) {
						tEstructura.add(cont.next());
					}
					form.setEstructuraBackingList(tEstructura, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getEstructura() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getGeneral().getEstructura().getValor());//terminoYPadre rellenado con estructura desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con estructura desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 2:
					Collection tNivelDeAgregacion = new ArrayList();
					tNivelDeAgregacion.add(terminoVO);
					Collection tNivelDeAgregacion2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont2 = tNivelDeAgregacion2.iterator();
					while (cont2.hasNext()) {
						tNivelDeAgregacion.add(cont2.next());
					}
					form.setNivelAgregacionBackingList(tNivelDeAgregacion, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getNivelAgregacion() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getGeneral().getNivelAgregacion().getValor());//terminoYPadre rellenado con nivel de agregacion desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con nivel de agregacion desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 3:
					idDest.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosDest.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosDest[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}

					UtilidadesOrdenarCombos terminosOrdDest2 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = terminosOrdDest2.ordenarTerminosVO(terminosDest, idiomaLdap);
					
					Collection idDest2 = Arrays.asList(terminosOrdDest);
					
					Iterator zDest = idDest2.iterator();
					while (zDest.hasNext()) {
						idDest.add(zDest.next());
					}
					form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					
					break;
				}
				
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

			}
			System.out.println("Cargados los combos");

				
				TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);

				TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
				//Dividimos los y idiomas de la estructura y el nivel de educación
				ArrayList arrayIdioma=new ArrayList();
				TerminoYPadreVO estructura=null;
				TerminoYPadreVO nivelAgregacion=null;
				
				for(int k=0;k<terminoYPadreVuelta.length;k++){
					String idPadre=terminoYPadreVuelta[k].getIdVocabulario();
					if(idPadre.equals(l_id[0])){//IDIOMA DESTINATARIO
						arrayIdioma.add(terminoYPadreVuelta[k]);
					}
					else if(idPadre.equals(l_id[1])){//ESTRUCTURA
						estructura=terminoYPadreVuelta[k];
					}
					else if(idPadre.equals(l_id[2])){//NIVEL AGREGACION
						nivelAgregacion=terminoYPadreVuelta[k];
					}
				}
				
				TerminoYPadreVO[] idiomasTP=(TerminoYPadreVO[])arrayIdioma.toArray(new TerminoYPadreVO[arrayIdioma.size()]);
				
				//IDIOMAS
				IdiomaVO[] aNuevoIdiomasVO =null;
				IdiomaVO[] aIdiomasVO =catalogadorAvSession.getMDSesion().getGeneral().getIdiomas();
				if (aIdiomasVO != null && (aIdiomasVO.length>0) ){ //&& !(aIdiomasVO.length==1 && aIdiomasVO[0].getTexto().equals(""))
					aNuevoIdiomasVO = new IdiomaVO[catalogadorAvSession.getMDSesion().getGeneral().getIdiomas().length];
					for (int idi = 0; idi<idiomasTP.length; idi++) {
						IdiomaVO idioma = new IdiomaVO();
						idioma.setTexto(idiomasTP[idi].getIdTermino());
						aNuevoIdiomasVO[idi]=idioma;
		            }
				}
				else{
					aNuevoIdiomasVO = new IdiomaVO[1];
					IdiomaVO idioma = new IdiomaVO();
					idioma.setTexto("");
					aNuevoIdiomasVO[0]=idioma;
				}
	            form.setIdiomasAsArray(aNuevoIdiomasVO);
	            form.setIdiomasBackingList(id, "idTermino", "nomTermino");

				
		        //ESTRUCTURA  
	            String idi ="";
		        if (estructura!=null)
				 idi =estructura.getIdTermino()!=null?estructura.getIdTermino():"";
				
				form.setEstructura(idi);
				
				//NIVEL AGREGACION
				idi="";
				if (nivelAgregacion!=null)
				idi = nivelAgregacion.getIdTermino()!=null?nivelAgregacion.getIdTermino():"";
				
				form.setNivelAgregacion(idi);
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados en el formulario los idiomas, la estructura y el nivel de agregacion" );
				}	
				
				//IDENTIFICADOR
				if(catalogadorAvSession.getMDSesion().getGeneral().getIdentificadores()!=null && (catalogadorAvSession.getMDSesion().getGeneral().getIdentificadores().length)> 0)
					form.setIdentificadoresAsArray(catalogadorAvSession.getMDSesion().getGeneral().getIdentificadores());
				else{
					IdentificadorVO[] aIdentificadores = new IdentificadorVO[1];
			    	IdentificadorVO identificadorVO=new IdentificadorVO();
			    	identificadorVO.setCatalogo("");
			    	identificadorVO.setEntrada("");
			    	aIdentificadores[0]=identificadorVO;
			    	form.setIdentificadoresAsArray(aIdentificadores);
				}
				//TITULOS
				
				ArrayList terminoYPadreTitulos = new  ArrayList();
				LangStringVO[] langTextosTitulo = null;
				LangStringVO[] nuevolangTextosTitulo =null;
				TituloVO[] aTituloVO = new TituloVO[1];
				TituloVO tituloVO= new TituloVO();
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getTitulo() !=null)&& (catalogadorAvSession.getMDSesion().getGeneral().getTitulo().getTextos().length)> 0) {
					langTextosTitulo =catalogadorAvSession.getMDSesion().getGeneral().getTitulo().getTextos();
					for(int j=0;j<langTextosTitulo.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario("5.11");
						terminoypadreVO.setIdTermino("");
						if(langTextosTitulo[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosTitulo[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreTitulos.add(terminoypadreVO);
					}
					
					TerminoYPadreVO[] arrayTerminoYPadreTitulos=(TerminoYPadreVO[])terminoYPadreTitulos.toArray(new TerminoYPadreVO[terminoYPadreTitulos.size()]);
					TerminoYPadreVO[] terminoYPadreTitulosVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreTitulos);
					
					nuevolangTextosTitulo = new LangStringVO[terminoYPadreTitulosVuelta.length];
					for (int i = 0; i<terminoYPadreTitulosVuelta.length; i++) {
						LangStringVO langTitulo = new LangStringVO();
						langTitulo.setTexto(langTextosTitulo[i].getTexto().trim());
						langTitulo.setIdioma(terminoYPadreTitulosVuelta[i].getIdTermino());
						nuevolangTextosTitulo[i] = langTitulo;
		            }
				} 
				else{
					nuevolangTextosTitulo = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosTitulo[0] = lang;
				}
				tituloVO.setTextos(nuevolangTextosTitulo);
				aTituloVO[0]=tituloVO;
	            form.setTitulosAsArray(aTituloVO);
				
	            //DESCRIPCION
	            ArrayList lDescripciones = new ArrayList();
				DescripcionVO[] descripcionVO =null;
				DescripcionVO[] nuevoDescripcionVO =null;
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getDescripciones() !=null)&& (catalogadorAvSession.getMDSesion().getGeneral().getDescripciones().length)> 0) {
					descripcionVO = catalogadorAvSession.getMDSesion().getGeneral().getDescripciones();
					nuevoDescripcionVO = new DescripcionVO[descripcionVO.length];
					if(descripcionVO.length == 1 && descripcionVO[0].getTextos().length== 0){
						DescripcionVO desc=new DescripcionVO();
						LangStringVO[] aLangString =new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						aLangString[0]=lang;
						desc.setTextos(aLangString);
						nuevoDescripcionVO[0]=desc;
					}
					else{
						for (int i = 0; i<descripcionVO.length; i++){
							LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
							ArrayList terminoYPadreDescripcion = new  ArrayList();
							if(langTextosDesc!=null && langTextosDesc.length>0){
								for(int j=0;j<langTextosDesc.length;j++){
									terminoypadreVO = new TerminoYPadreVO();
									terminoypadreVO.setIdiomaTermino("en");
									terminoypadreVO.setIdVocabulario("5.11");
									terminoypadreVO.setIdTermino("");
									if(langTextosDesc[j].getIdioma()!=null)
										terminoypadreVO.setNomTermino(langTextosDesc[j].getIdioma());
									else
										terminoypadreVO.setNomTermino("");
									terminoYPadreDescripcion.add(terminoypadreVO);							
								}
							}
							else{
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino("");
								terminoYPadreDescripcion.add(terminoypadreVO);	
							}
						//	if(langTextosDesc.length != 0)
								lDescripciones.add(terminoYPadreDescripcion);
						}

						for (int i = 0; i<lDescripciones.size();i++) {
							DescripcionVO descVO= new DescripcionVO();
							ArrayList terminoYPadreDesc = (ArrayList) lDescripciones.get(i);
							TerminoYPadreVO[] arrayTerminoYPadreDescripcion=(TerminoYPadreVO[])terminoYPadreDesc.toArray(new TerminoYPadreVO[terminoYPadreDesc.size()]);
							TerminoYPadreVO[] terminoYPadreDescripcionVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDescripcion);
							LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
							if(langTextosDesc!=null && langTextosDesc.length>0){
								LangStringVO[] nuevoLangTextosDesc = new LangStringVO[langTextosDesc.length];
								for (int j = 0; j<terminoYPadreDescripcionVuelta.length; j++) {
									LangStringVO nuevoLangDesc = new LangStringVO();
									nuevoLangDesc.setIdioma(terminoYPadreDescripcionVuelta[j].getIdTermino());
									nuevoLangDesc.setTexto(langTextosDesc[j].getTexto().trim());
									nuevoLangTextosDesc[j] = nuevoLangDesc;
								}
								descVO.setTextos(nuevoLangTextosDesc);
								
							}
							else{
								LangStringVO[] nuevoLangTextosDesc = new LangStringVO[1];
								LangStringVO nuevoLangDesc = new LangStringVO();
								nuevoLangDesc.setIdioma("");
								nuevoLangDesc.setTexto("");
								nuevoLangTextosDesc[0] = nuevoLangDesc;
								descVO.setTextos(nuevoLangTextosDesc);
								
							}
							nuevoDescripcionVO[i]=descVO;
						}	
					}
				}
				else{
					nuevoDescripcionVO = new DescripcionVO[1];
					LangStringVO[] aLangString =new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					aLangString[0]=lang;
					DescripcionVO descVO= new DescripcionVO();
					descVO.setTextos(aLangString);
					nuevoDescripcionVO[0] = descVO;
				}

	            form.setDescripcionesAsArray(nuevoDescripcionVO);
				
				//PALABRAS CLAVE
	            ArrayList lPalabras = new ArrayList();
				PalabraClaveVO[] palabraClaveVO =null;
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getPalabrasClave() !=null) && (catalogadorAvSession.getMDSesion().getGeneral().getPalabrasClave().length)> 0) {
					palabraClaveVO = catalogadorAvSession.getMDSesion().getGeneral().getPalabrasClave();
					for (int i = 0; i<palabraClaveVO.length; i++){
						LangStringVO[] langTextosPal = palabraClaveVO[i].getTextos();
						ArrayList terminoYPadrePalabras = new  ArrayList();
						if(langTextosPal!=null && langTextosPal.length>0){
							for(int j=0;j<langTextosPal.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								if(langTextosPal[j].getIdioma()!= null)
									terminoypadreVO.setNomTermino(langTextosPal[j].getIdioma());
								else
									terminoypadreVO.setNomTermino("");
								terminoYPadrePalabras.add(terminoypadreVO);
								
							}
						}
						else{
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario("5.11");
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoYPadrePalabras.add(terminoypadreVO);
						}
						lPalabras.add(terminoYPadrePalabras);
					}
				} else {
					ArrayList terminoYPadrePalabras = new  ArrayList();
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario("5.11");
					terminoypadreVO.setIdTermino("");
					terminoypadreVO.setNomTermino(((CategoriasFormGeneralFormImpl)form).getComboIdiomaLabelList()[0].toString());//terminoYPadre rellenado con los idiomas desde el formulario
					terminoYPadrePalabras.add(terminoypadreVO);
					lPalabras.add(terminoYPadrePalabras);
					LangStringVO[] cLangPalabras = new LangStringVO[1];
					LangStringVO vacio = new LangStringVO();
					vacio.setTexto("");
					vacio.setIdioma("");
					cLangPalabras[0]=vacio;
					PalabraClaveVO palVacio = new PalabraClaveVO();
					palVacio.setTextos(cLangPalabras);
					palabraClaveVO = new PalabraClaveVO[1];
					palabraClaveVO[0]=palVacio;
				}

				PalabraClaveVO[] palabrasClave = new PalabraClaveVO[lPalabras.size()];
				for (int i = 0; i<lPalabras.size();i++) {
					PalabraClaveVO pClaVO = new PalabraClaveVO();
					ArrayList terminoYPadrePalab = (ArrayList) lPalabras.get(i);
					if(terminoYPadrePalab!=null && terminoYPadrePalab.size()>0){
						TerminoYPadreVO[] arrayTerminoYPadrePalabras=(TerminoYPadreVO[])terminoYPadrePalab.toArray(new TerminoYPadreVO[terminoYPadrePalab.size()]);
						TerminoYPadreVO[] terminoYPadrePalabrasVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadrePalabras);
						LangStringVO[] langTextosPal = palabraClaveVO[i].getTextos();
						if(langTextosPal!=null && langTextosPal.length>0){
							LangStringVO[] nuevoLangTextosPal = new LangStringVO[langTextosPal.length];
							for (int j = 0; j<terminoYPadrePalabrasVuelta.length; j++) {
								LangStringVO nuevoLangPal = new LangStringVO();
								nuevoLangPal.setIdioma(terminoYPadrePalabrasVuelta[j].getIdTermino());
								nuevoLangPal.setTexto(langTextosPal[j].getTexto().trim());
								nuevoLangTextosPal[j]= nuevoLangPal;
								pClaVO.setTextos(nuevoLangTextosPal);
								
							}
						}else{
							LangStringVO[] nuevoLangTextosPal=new LangStringVO[1];
							LangStringVO nuevoLangPal = new LangStringVO();
							nuevoLangPal.setIdioma("");
							nuevoLangPal.setTexto("");
							nuevoLangTextosPal[0]= nuevoLangPal;
							pClaVO.setTextos(nuevoLangTextosPal);
						}
						palabrasClave[i]=pClaVO;
					}
					else{
						LangStringVO[] nuevoLangTextosPal = new LangStringVO[1];
						LangStringVO nuevoLangPal = new LangStringVO();
						nuevoLangPal.setIdioma("");
						nuevoLangPal.setTexto("");
						nuevoLangTextosPal[0]= nuevoLangPal;
						pClaVO.setTextos(nuevoLangTextosPal);
					}
					
					
					
				}
	            form.setPalabrasClaveAsArray(palabrasClave);;
           

				//AMBITO
	            ArrayList lAmbito = new ArrayList();
	            AmbitoVO[] ambitoVO =null;
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getAmbitos() !=null) && (catalogadorAvSession.getMDSesion().getGeneral().getAmbitos().length)> 0) {
					ambitoVO = catalogadorAvSession.getMDSesion().getGeneral().getAmbitos();
					for (int i = 0; i<ambitoVO.length; i++){
						LangStringVO[] langTextosAmb = ambitoVO[i].getTextos();
						ArrayList terminoYPadreAmbito = new  ArrayList();
						if(langTextosAmb!=null && langTextosAmb.length>0){
							
							for(int j=0;j<langTextosAmb.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								if(langTextosAmb[j].getIdioma()!=null)
									terminoypadreVO.setNomTermino(langTextosAmb[j].getIdioma());
								else
									terminoypadreVO.setNomTermino("");
								terminoYPadreAmbito.add(terminoypadreVO);	
							}
						}
						else{
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario("5.11");
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoYPadreAmbito.add(terminoypadreVO);	
						}
						lAmbito.add(terminoYPadreAmbito);
					}
				} else {
					ArrayList terminoYPadreAmbito = new  ArrayList();
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario("5.11");
					terminoypadreVO.setIdTermino("");
					terminoypadreVO.setNomTermino(((CategoriasFormGeneralFormImpl)form).getComboIdiomaLabelList()[0].toString());//terminoYPadre rellenado con los idiomas desde el formulario
					terminoYPadreAmbito.add(terminoypadreVO);
					lAmbito.add(terminoYPadreAmbito);
					LangStringVO[] cLangAmbito = new LangStringVO[1];
					LangStringVO vacio = new LangStringVO();
					vacio.setTexto("");
					vacio.setIdioma("");
					
					cLangAmbito[0]=vacio;
					AmbitoVO ambitoVacio = new AmbitoVO();
					ambitoVacio.setTextos(cLangAmbito);
					ambitoVO = new AmbitoVO[1];
					ambitoVO[0]=ambitoVacio;
				}
				
				AmbitoVO[] ambitos = new AmbitoVO[lAmbito.size()];
				for (int i = 0; i<lAmbito.size();i++) {
					AmbitoVO ambVO = new AmbitoVO();;
					ArrayList terminoYPadreAmb = (ArrayList) lAmbito.get(i);
					if(terminoYPadreAmb!=null && terminoYPadreAmb.size()>0){
						TerminoYPadreVO[] arrayTerminoYPadreAmbito=(TerminoYPadreVO[])terminoYPadreAmb.toArray(new TerminoYPadreVO[terminoYPadreAmb.size()]);
						TerminoYPadreVO[] terminoYPadreAmbitoVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreAmbito);
						LangStringVO[] langTextosAmb = ambitoVO[i].getTextos();
						if(langTextosAmb!=null && langTextosAmb.length>0){
							LangStringVO[] nuevoLangTextosAmb = new LangStringVO[langTextosAmb.length];
							for (int j = 0; j<terminoYPadreAmbitoVuelta.length; j++) {
								LangStringVO nuevoLangAmb =new LangStringVO();
								nuevoLangAmb.setIdioma(terminoYPadreAmbitoVuelta[j].getIdTermino());
								nuevoLangAmb.setTexto(langTextosAmb[j].getTexto().trim());
								nuevoLangTextosAmb[j]= nuevoLangAmb;
								ambVO.setTextos(nuevoLangTextosAmb);
							}
						}else{
							LangStringVO[] nuevoLangTextosAmb = new LangStringVO[1];
							LangStringVO nuevoLangAmb =new LangStringVO();
							nuevoLangAmb.setIdioma("");
							nuevoLangAmb.setTexto("");
							nuevoLangTextosAmb[0]= nuevoLangAmb;
							ambVO.setTextos(nuevoLangTextosAmb);
						}
					}
					else{
						LangStringVO[] nuevoLangTextosAmb = new LangStringVO[1];
						LangStringVO nuevoLangAmb =new LangStringVO();
						nuevoLangAmb.setIdioma("");
						nuevoLangAmb.setTexto("");
						nuevoLangTextosAmb[0]= nuevoLangAmb;
						ambVO.setTextos(nuevoLangTextosAmb);
					}
					
					ambitos[i]=ambVO;
				}
	            form.setAmbitosAsArray(ambitos);
	            
	            //si general era null en el objeto de session lo dejamos a null
	            if(generalEsNull)
	            	catalogadorAvSession.getMDSesion().setGeneral(null);
	            
        }catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarGeneral" + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
		
	}

//	private VocabularioVO[]  ordenar(VocabularioVO[]vocabulario) 
//	{
//		
//		String idioma=vocabulario[0].getIdioma();
//             
//		for(int i=0; i < vocabulario.length; i++)
//		{   
//			for (int j= 0; j<vocabulario[i].getTerminos().length -1; j++){
//
//		        for (int k= j+1; k<vocabulario[i].getTerminos().length; k++){
//		        	
//		             if (vocabulario[i].getTerminos()[j].getNomTermino().compareTo(vocabulario[i].getTerminos()[k].getNomTermino())>0 ){
//
//		           		   TerminoVO auxTerm=new TerminoVO();
//
//		                   String aux= vocabulario[i].getTerminos()[k].getNomTermino();
//		                   String auxId=vocabulario[i].getTerminos()[k].getIdTermino();
//		                   auxTerm.setIdiomaTermino(idioma);
//		                   auxTerm.setIdTermino(auxId);
//		                   auxTerm.setNomTermino(aux);
//		                               
//		                   vocabulario[i].getTerminos()[k]=vocabulario[i].getTerminos()[j];
//		                   vocabulario[i].getTerminos()[j]=auxTerm;          
//		             }
//		        }
//		    }
//		}
//		return vocabulario;
//	}
//
//	private TerminoVO[] ordena(TerminoVO[] termino, String idioma) {
//		for (int j= 0; j<termino.length -1; j++){
//
//	        for (int k= j+1; k<termino.length; k++){
//	        	
//	             if (termino[j].getNomTermino().compareTo(termino[k].getNomTermino())>0 ){
//
//	           		   TerminoVO auxTerm=new TerminoVO();
//
//	                   String aux= termino[k].getNomTermino();
//	                   String auxId=termino[k].getIdTermino();
//	                   auxTerm.setIdiomaTermino(idioma);
//	                   auxTerm.setIdTermino(auxId);
//	                   auxTerm.setNomTermino(aux);
//	                               
//	                   termino[k]=termino[j];
//	                   termino[j]=auxTerm;          
//	             }
//	        }
//	    }
//		
//		return termino;
//	}





	public void cargarDatosCicloDeVida(
			ActionMapping mapping, 
			CargarDatosCicloDeVidaForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
    	InputStream is = null;
    	Properties prop = new Properties();
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

	        is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
	        

//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
		     
			//comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			}	
			//comprobamos que ciclo de vida no se ha null, si es null nos creamos uno	
			boolean cicloEsNull = false;
			AvLifeCycleVO cicloVida =catalogadorAvSession.getMDSesion().getLifeCycle();
			if (cicloVida == null){
				cicloVida = new AvLifeCycleVO();
				catalogadorAvSession.getMDSesion().setLifeCycle(cicloVida);
				cicloEsNull = true;
			}
			
			
			//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
			String[] l_id = { prop.getProperty("estatus"),prop.getProperty("rol"),prop.getProperty("idiomaDestinatario")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);			

			longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de rol, la estatus y los idiomas
			TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
			ArrayList terminoypadrear=new ArrayList();
			
			Collection idDest = new ArrayList();
			
			for (int x = 0; x < longVocabulario; x++) {// for carga combos
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {
				case 0://ESTATUS
					Collection tEstado = new ArrayList();
					tEstado.add(terminoVO);
					Collection tEstadoAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont2 = tEstadoAux.iterator();
					while (cont2.hasNext()) {
						tEstado.add(cont2.next());
					}
					form.setEstatusBackingList(tEstado, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((cicloVida != null)&&(cicloVida.getEstado() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getLifeCycle().getEstado().getValor());
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 1://ROL
					Collection tRol = new ArrayList();
					tRol.add(terminoVO);
					Collection tRolAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont = tRolAux.iterator();
					while (cont.hasNext()) {
						tRol.add(cont.next());
					}
					form.setCrolBackingList(tRol, "idTermino", "nomTermino");
					if ((cicloVida != null)&&(cicloVida.getContribuciones() !=null)
							&&(cicloVida.getContribuciones().length !=0)) {
						ContribucionVO[] contribucionesVO =cicloVida.getContribuciones();
						for(int j=0;j<contribucionesVO.length;j++){
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							if (contribucionesVO!= null && contribucionesVO[j].getTipo()!=null)
								terminoypadreVO.setNomTermino(contribucionesVO[j].getTipo().getValor());
							else
								terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}//terminoYPadreVO rellenado con los idiomas desde el lom avanzado
					}
					else {
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino("");
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;

				case 2://IDIOMA PARA CAJA DE TEXTO
					idDest.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
					for (int k=0; k<terminosDest.length;k++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosDest[k];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = terminosOrdDest1.ordenarTerminosVO(terminosDest, idiomaLdap);					
					Collection idDest2 = Arrays.asList(terminosOrdDest);
					
					Iterator zDest = idDest2.iterator();
					while (zDest.hasNext()) {
						idDest.add(zDest.next());
					}
					form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					
					break;
				}
				
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}
			}//fin for carga combos
			
			System.out.println("Cargados los combos");
			
			//OBTENEMOS LOS IDs DE LOS TERMINOS SELECCIONADOS EN LOS COMBOS
			TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);
			TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);

			//ESTADO
			String estatus = terminoYPadreVuelta[0].getIdTermino();
			if (estatus == null) {
				estatus = "";//No hay ningún estado seleccionado
			}
			form.setEstatus(estatus);
			
			//VERSION
			ArrayList terminoYPadreVersiones = new  ArrayList();
			LangStringVO[] langTextosVersion = null;
			LangStringVO[] nuevolangTextosVersion =null;
			VersionVO[] aVersionVO = new VersionVO[1];
			VersionVO versionVO= new VersionVO();
			if ((cicloVida != null)&&(cicloVida.getVersion() !=null)&& (cicloVida.getVersion().getTextos().length)> 0) {
				langTextosVersion =cicloVida.getVersion().getTextos();
				if(langTextosVersion!=null && langTextosVersion.length>0){
					for(int j=0;j<langTextosVersion.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
						terminoypadreVO.setIdTermino("");
						if(langTextosVersion[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosVersion[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreVersiones.add(terminoypadreVO);
					}
				}else{
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
					terminoypadreVO.setIdTermino("");
					terminoypadreVO.setNomTermino("");
					terminoYPadreVersiones.add(terminoypadreVO);
				}
				
				TerminoYPadreVO[] arrayTerminoYPadreVersiones=(TerminoYPadreVO[])terminoYPadreVersiones.toArray(new TerminoYPadreVO[terminoYPadreVersiones.size()]);
				TerminoYPadreVO[] terminoYPadreVersionesVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreVersiones);
				
				ArrayList aNuevolangTextosVersion = new ArrayList();
				nuevolangTextosVersion = new LangStringVO[terminoYPadreVersionesVuelta.length];
				for (int i = 0; i<terminoYPadreVersionesVuelta.length; i++) {
					LangStringVO langVersion = new LangStringVO();
					langVersion.setTexto(langTextosVersion[i].getTexto());
					langVersion.setIdioma(terminoYPadreVersionesVuelta[i].getIdTermino());
					if(!langVersion.getTexto().trim().equals(""))
						aNuevolangTextosVersion.add(langVersion);
					//nuevolangTextosVersion[i] = langVersion;
	            }
				if(aNuevolangTextosVersion.size()==0){
					nuevolangTextosVersion = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosVersion[0] = lang;
				}
				else 
					nuevolangTextosVersion = (LangStringVO[])aNuevolangTextosVersion.toArray(new LangStringVO[aNuevolangTextosVersion.size()]);
			} 
			else{
				nuevolangTextosVersion = new LangStringVO[1];
				LangStringVO lang = new LangStringVO();
				lang.setIdioma("");
				lang.setTexto("");
				nuevolangTextosVersion[0] = lang;
			}
			versionVO.setTextos(nuevolangTextosVersion);
			aVersionVO[0]=versionVO;
            form.setVersionesAsArray(aVersionVO);
            

			
			//CONTRIBUCIONES
			//ArrayList terminoYPadreDescrip = new  ArrayList();
			LangStringVO[] langTextosDescrip = null;
			LangStringVO[] nuevolangTextosDescrip =null;
			
			
			if ((cicloVida != null)&&(cicloVida.getContribuciones() !=null)
					&& (cicloVida.getContribuciones().length)> 0) {
				ContribucionVO[] contribuciones = cicloVida.getContribuciones();
				Contribucion[] contribucionesAux=new Contribucion[contribuciones.length];
				DescripcionVO[] aDescripcionesVO = new DescripcionVO[contribuciones.length];
				for(int i = 0;i<contribuciones.length;i++){
					ArrayList terminoYPadreDescrip = new  ArrayList();
					Contribucion contribucionAux=new Contribucion();
					//2.3.3 Fecha
					/************************/
					//Descripcion de la fecha
					if(contribuciones[i].getFecha()!=null && contribuciones[i].getFecha().getDescripcion() !=null && contribuciones[i].getFecha().getDescripcion().getTextos()!= null &&contribuciones[i].getFecha().getDescripcion().getTextos().length>0){
						langTextosDescrip =contribuciones[i].getFecha().getDescripcion().getTextos();
						for(int j=0;j<langTextosDescrip.length;j++){
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
							terminoypadreVO.setIdTermino("");
							if(langTextosDescrip[j].getIdioma()!=null)
								terminoypadreVO.setNomTermino(langTextosDescrip[j].getIdioma());
							else
								terminoypadreVO.setNomTermino("");
							terminoYPadreDescrip.add(terminoypadreVO);
						}
					
					TerminoYPadreVO[] arrayTerminoYPadreDesc=(TerminoYPadreVO[])terminoYPadreDescrip.toArray(new TerminoYPadreVO[terminoYPadreDescrip.size()]);
					TerminoYPadreVO[] terminoYPadreDescVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDesc);
					
					//nuevolangTextosDescrip = new LangStringVO[terminoYPadreDescVuelta.length];
					ArrayList aNuevolangTextosDescrip =new ArrayList();
					for (int k = 0; k<terminoYPadreDescVuelta.length; k++) {
						LangStringVO langDesc = new LangStringVO();
						langDesc.setTexto(langTextosDescrip[k].getTexto());
						langDesc.setIdioma(terminoYPadreDescVuelta[k].getIdTermino());
						if(!langDesc.getTexto().trim().equals(""))
							aNuevolangTextosDescrip.add(langDesc);
						//nuevolangTextosDescrip[k] = langDesc;
		            }
					if(aNuevolangTextosDescrip.size()==0){
						nuevolangTextosDescrip = new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						nuevolangTextosDescrip[0] = lang;
					}
					else 
						nuevolangTextosDescrip = (LangStringVO[])aNuevolangTextosDescrip.toArray(new LangStringVO[aNuevolangTextosDescrip.size()]);
					DescripcionVO descripcionVO= new DescripcionVO();
					descripcionVO.setTextos(nuevolangTextosDescrip);
					aDescripcionesVO[i]=descripcionVO;
					}
					else{
						//Descripcion vacia
						DescripcionVO descripcionVO = new DescripcionVO();
						nuevolangTextosDescrip = new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						nuevolangTextosDescrip[0] = lang;
						descripcionVO.setTextos(nuevolangTextosDescrip);
						aDescripcionesVO[i]=descripcionVO;
					} 
	    			//FECHA --> 2007-06-09... Formato completo-->yyyy-MM-ddThh:mm:ss.S(+-)00:00 <--
					Fecha auxFecha=new Fecha();
					if( contribuciones[i].getFecha()!=null && 
						contribuciones[i].getFecha().getFecha()!=null)
					{
						String fvo=  contribuciones[i].getFecha().getFecha();
						auxFecha.setFechaLomes(fvo );
					}
	    			 contribucionAux.setFecha(auxFecha);
					

	    			 /************************/
					//2.3.1 Tipo (ROL)
					/************************/
					String rol = terminoYPadreVuelta[i+1].getIdTermino();
					if (rol == null) {
						rol = "";//No hay ningún estado seleccionado
					}
					SourceValueVO tipo = new SourceValueVO();
					tipo.setValor(rol);
					contribucionAux.setRol(tipo);
					/************************/
					//2.3.2 Entidades
					/************************/
//					BEGIN:VCARD VERSION 3.0 FN:GT8/SC36/CT71 EMAIL;TYPE=INTERNET:GT8@aenor.es ORG:AENOR END:VCARD
					Entidad[] entidadesAux = null;
					ArrayList aEntidades= new ArrayList();
					if(contribuciones[i].getEntidades()!=null){
	    				EntidadVO[] entidades=cicloVida.getContribuciones()[i].getEntidades();
	    				//entidadesAux = new Entidad[entidades.length];
	    				
	    				for(int j=0;j<entidades.length;j++){
	    					String nombre="";
	    					String organizacion="";
	    					String email="";
	    					String sEntidad = entidades[j].getTexto();
	    					if(sEntidad !=null && !sEntidad.trim().equals("")){
			    				String[] trozos = sEntidad.split(":");
			    				for (int k=0; k<trozos.length; k++) {
			    					String elem=trozos[k];
			    					if (elem.toUpperCase().endsWith("EMAIL;TYPE=INTERNET")){
			    						int finNombre = elem.toUpperCase().indexOf("EMAIL;TYPE=INTERNET");
			    						nombre = elem.substring(0, finNombre);
			    					}
			    					else if (elem.toUpperCase().endsWith("ORG")){
			    						int finEmail = elem.toUpperCase().indexOf("ORG");
			    						email = elem.substring(0, finEmail);
			    						if(!validaEmail(email.trim()))
			    							email="";
			    					}
			    					else if (elem.toUpperCase().endsWith("END")){
			    						int finOrg = elem.toUpperCase().indexOf("END");
			    						organizacion = elem.substring(0, finOrg);
			    					} 
			    				}//end for
			    				
			    				Entidad entidad = new Entidad();
			    				entidad.setCorreo(email!=null?email:"");
			    				entidad.setNombre(nombre!=null?nombre:"");
			    				entidad.setOrganizacion(organizacion!=null?organizacion:"");
			    				aEntidades.add(entidad);
			    				//entidadesAux[j]=entidad;
	    					}	
	    					else{
	    						Entidad entidad = new Entidad();
			    				entidad.setCorreo("");
			    				entidad.setNombre("");
			    				entidad.setOrganizacion("");
			    				aEntidades.add(entidad);
	    					}
	    				}
	    				entidadesAux = (Entidad[])aEntidades.toArray(new Entidad[aEntidades.size()]);
	    				if(entidadesAux.length ==0){
							entidadesAux = new Entidad[1];
		    				Entidad entidad = new Entidad();
		    				entidad.setCorreo("");
		    				entidad.setNombre("");
		    				entidad.setOrganizacion("");
		    				entidadesAux[0]=entidad;
	    				}
    				}
					else{
						entidadesAux = new Entidad[1];
	    				Entidad entidad = new Entidad();
	    				entidad.setCorreo("");
	    				entidad.setNombre("");
	    				entidad.setOrganizacion("");
	    				entidadesAux[0]=entidad;
					}
    				contribucionAux.setEntidades(entidadesAux);
					/************************/
    				contribucionesAux[i]=contribucionAux;
				}
				form.setContribucionesAsArray(contribucionesAux);
				form.setDescripcionesAsArray(aDescripcionesVO);
			} 
			else{
				Contribucion[] contribucionesAux=new Contribucion[1];
				Contribucion contribucionAux = new Contribucion();
				//Descripcion vacia
				DescripcionVO[] aDescripcionesVO = new DescripcionVO[1];
				DescripcionVO descripcionVO = new DescripcionVO();
				nuevolangTextosDescrip = new LangStringVO[1];
				LangStringVO lang = new LangStringVO();
				lang.setIdioma("");
				lang.setTexto("");
				nuevolangTextosDescrip[0] = lang;
				descripcionVO.setTextos(nuevolangTextosDescrip);
				aDescripcionesVO[0]=descripcionVO;
				//Fecha vacia
				Fecha auxFecha = new Fecha();
				contribucionAux.setFecha(auxFecha);
				/************************/
				//Tipo (ROL)
				SourceValueVO tipo = new SourceValueVO();
				tipo.setSource("");
				tipo.setValor("");
				contribucionAux.setRol(tipo);
				/************************/
				//Entidades
				Entidad[] entidades = new Entidad[1];
				Entidad entidad = new Entidad();
				entidad.setCorreo("");
				entidad.setNombre("");
				entidad.setOrganizacion("");
				entidades[0]=entidad;
				contribucionAux.setEntidades(entidades);
				/************************/
				contribucionesAux[0]=contribucionAux;
				form.setContribucionesAsArray(contribucionesAux);
				form.setDescripcionesAsArray(aDescripcionesVO) ;
			}
            
            //si ciclo de vida era null en el objeto de session lo dejamos a null
            if (cicloEsNull)
            	catalogadorAvSession.getMDSesion().setLifeCycle(null);
        
        }catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarCicloVida " + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}
        finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
     }



	public void cargarDatosMetaMetadatos(
			ActionMapping mapping, 
			CargarDatosMetaMetadatosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{

		InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
		     
			//comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			}	
			//comprobamos que metaMetadata no se ha null, si es null nos creamos uno
			AvMetametadataVO metadatos = catalogadorAvSession.getMDSesion().getMetaMetadata();
			boolean metaMetadataEsNull = false;
			if (catalogadorAvSession.getMDSesion().getMetaMetadata() == null){
				metadatos = new AvMetametadataVO();
				catalogadorAvSession.getMDSesion().setMetaMetadata(metadatos);
				metaMetadataEsNull=true;
			}	
		
			//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
			String[] l_id = { prop.getProperty("idiomaDestinatario"),prop.getProperty("rolMetadatos")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);			

			longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
			TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
			ArrayList terminoypadrear=new ArrayList();

			Collection idDest = new ArrayList();
			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {
					case 0://IDIOMADEST
						idDest.add(terminoVO);
	//					modificamos las cadenas de idiomas
						TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
						for (int li=0; li<terminosDest.length;li++){
							TerminoVO idAux = new TerminoVO();
							idAux=terminosDest[li];
							String textoIdioma= idAux.getNomTermino();
							String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
							idAux.setNomTermino(idiomasTra);
						}
						UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
						TerminoVO[] terminosOrdDest = terminosOrdDest1.ordenarTerminosVO(terminosDest, idiomaLdap);						
						Collection idDest2 = Arrays.asList(terminosOrdDest);
						
						Iterator zDest = idDest2.iterator();
						while (zDest.hasNext()) {
							idDest.add(zDest.next());
						}
						form.setComboIdiomaMetaBackingList(idDest, "idTermino", "nomTermino");
						form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
						if ((metadatos != null)&&(metadatos.getIdioma() !=null)) {
							IdiomaVO idiomasVO =metadatos.getIdioma();
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino(idiomasVO.getTexto());
							terminoypadrear.add(terminoypadreVO);
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}	
						break;
						
					case 1://ROL
						Collection tRol = new ArrayList();
						tRol.add(terminoVO);
						Collection tRolAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
						Iterator cont = tRolAux.iterator();
						while (cont.hasNext()) {
							tRol.add(cont.next());
						}
						form.setCrolBackingList(tRol, "idTermino", "nomTermino");
						if ((metadatos != null)&&(metadatos.getContribuciones() !=null)
								&&(metadatos.getContribuciones().length !=0)) {
							ContribucionVO[] contribucionesVO =metadatos.getContribuciones();
							for(int j=0;j<contribucionesVO.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								if (contribucionesVO!= null && contribucionesVO[j].getTipo()!=null)
									terminoypadreVO.setNomTermino(contribucionesVO[j].getTipo().getValor());
								else
									terminoypadreVO.setNomTermino("");
								terminoypadrear.add(terminoypadreVO);
							}//terminoYPadreVO rellenado con los idiomas desde el lom avanzado
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						
						break;

				}
				
	            //si general era null en el objeto de session lo dejamos a null
	            if(metaMetadataEsNull)
	            	catalogadorAvSession.getMDSesion().setMetaMetadata(null);
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

			}
			System.out.println("Cargados los combos");

				
			TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);
			TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
			
			if( logger.isDebugEnabled() ){

                logger.debug("Cargados en el formulario los idiomas, la estructura y el nivel de agregacion" );
			}	
			//IDIOMA
			String idioma = terminoYPadreVuelta[0].getIdTermino();
			if (idioma == null) {
				idioma = "";//No hay ningún estado seleccionado
			}
			form.setComboIdiomaMeta(idioma);
			
			//IDENTIFICADOR
			if(catalogadorAvSession.getMDSesion().getMetaMetadata()!=null && catalogadorAvSession.getMDSesion().getMetaMetadata().getIdentificadores() != null&& (catalogadorAvSession.getMDSesion().getMetaMetadata().getIdentificadores().length)> 0){
				IdentificadorVO[] identVO= catalogadorAvSession.getMDSesion().getMetaMetadata().getIdentificadores();
				Collection identVOAux = new ArrayList();
				for(int i=0;i<identVO.length;i++){
					IdentificadorVO ident = new IdentificadorVO();
					if((identVO[i].getCatalogo()!=null && !identVO[i].getCatalogo().trim().equals("")) || (identVO[i].getEntrada()!=null && !identVO[i].getEntrada().trim().equals(""))){
						ident.setCatalogo(identVO[i].getCatalogo().trim());
						ident.setEntrada(identVO[i].getEntrada().trim());
						identVOAux.add(ident);
					}
				}
				if(identVOAux.size()==0){
					IdentificadorVO[] aIdentificadores = new IdentificadorVO[1];
			    	IdentificadorVO identificadorVO=new IdentificadorVO();
			    	identificadorVO.setCatalogo("");
			    	identificadorVO.setEntrada("");
			    	aIdentificadores[0]=identificadorVO;
			    	form.setIdentificadoresAsArray(aIdentificadores);
				}
				else
					form.setIdentificadores(identVOAux);
			}
			else{
				IdentificadorVO[] aIdentificadores = new IdentificadorVO[1];
		    	IdentificadorVO identificadorVO=new IdentificadorVO();
		    	identificadorVO.setCatalogo("");
		    	identificadorVO.setEntrada("");
		    	aIdentificadores[0]=identificadorVO;
		    	form.setIdentificadoresAsArray(aIdentificadores); 
			}
			
			//ESQUEMA
			AvMetametadataVO metaMetadata = catalogadorAvSession.getMDSesion().getMetaMetadata();
			if(metaMetadata!=null && metaMetadata.getEsquemas()!=null && (metaMetadata.getEsquemas().length)> 0){
				//form.setEsquemasMetaAsArray(metaMetadata.getEsquemas());
				EsquemaDeMetadatosVO[] esqVO= metaMetadata.getEsquemas();
				Collection esqVOAux = new ArrayList();
				for(int i=0;i<esqVO.length;i++){
					EsquemaDeMetadatosVO esq = new EsquemaDeMetadatosVO();
					if(esqVO[i].getTexto()!=null && !esqVO[i].getTexto().trim().equals("")){
						esq.setTexto(esqVO[i].getTexto().trim());
						esqVOAux.add(esq);
					}
				}
				if(esqVOAux.size()==0){
					EsquemaDeMetadatosVO[] aEsquemas = new EsquemaDeMetadatosVO[1];
					EsquemaDeMetadatosVO esquemaVO=new EsquemaDeMetadatosVO();
					esquemaVO.setTexto("");
					aEsquemas[0]=esquemaVO;
			    	form.setEsquemasMetaAsArray(aEsquemas);
				}
				else
					form.setEsquemasMeta(esqVOAux);
			}
			else{
				EsquemaDeMetadatosVO[] aEsquemas = new EsquemaDeMetadatosVO[1];
				EsquemaDeMetadatosVO esquemaVO=new EsquemaDeMetadatosVO();
				esquemaVO.setTexto("");
				aEsquemas[0]=esquemaVO;
		    	form.setEsquemasMetaAsArray(aEsquemas);
			}
			
			//CONTRIBUCIONES
			//ArrayList terminoYPadreDescrip = new  ArrayList();
			LangStringVO[] langTextosDescrip = null;
			LangStringVO[] nuevolangTextosDescrip =null;
			
			
			if ((metadatos != null)&&(metadatos.getContribuciones() !=null)
					&& (metadatos.getContribuciones().length)> 0) {
				ContribucionVO[] contribuciones = metadatos.getContribuciones();
				Contribucion[] contribucionesAux=new Contribucion[contribuciones.length];
				DescripcionVO[] aDescripcionesVO = new DescripcionVO[contribuciones.length];
				for(int i = 0;i<contribuciones.length;i++){
					ArrayList terminoYPadreDescrip = new  ArrayList();
					Contribucion contribucionAux=new Contribucion();
					//2.3.3 Fecha
					/************************/

					//Descripcion de la fecha
					if(contribuciones[i].getFecha()!=null && contribuciones[i].getFecha().getDescripcion() !=null && contribuciones[i].getFecha().getDescripcion().getTextos()!= null){
						langTextosDescrip =contribuciones[i].getFecha().getDescripcion().getTextos();
						for(int j=0;j<langTextosDescrip.length;j++){
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
							terminoypadreVO.setIdTermino("");
							if(langTextosDescrip[j].getIdioma()!=null)
								terminoypadreVO.setNomTermino(langTextosDescrip[j].getIdioma());
							else
								terminoypadreVO.setNomTermino("");
							terminoYPadreDescrip.add(terminoypadreVO);
						}
					
						TerminoYPadreVO[] arrayTerminoYPadreDesc=(TerminoYPadreVO[])terminoYPadreDescrip.toArray(new TerminoYPadreVO[terminoYPadreDescrip.size()]);
						TerminoYPadreVO[] terminoYPadreDescVuelta=null;
						if(arrayTerminoYPadreDesc!= null && arrayTerminoYPadreDesc.length>0){
							terminoYPadreDescVuelta=new TerminoYPadreVO[arrayTerminoYPadreDesc.length];
							terminoYPadreDescVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDesc);
						}else{
							terminoYPadreDescVuelta=new TerminoYPadreVO[0];
						}
						
						//nuevolangTextosDescrip = new LangStringVO[terminoYPadreDescVuelta.length];
						ArrayList aNuevolangTextosDescrip =new ArrayList();
						if(terminoYPadreDescVuelta!=null && terminoYPadreDescVuelta.length>0 ){
							for (int k = 0; k<terminoYPadreDescVuelta.length; k++) {
								LangStringVO langDesc = new LangStringVO();
								langDesc.setTexto(langTextosDescrip[k].getTexto());
								langDesc.setIdioma(terminoYPadreDescVuelta[k].getIdTermino());
								if(!langDesc.getTexto().trim().equals(""))
									aNuevolangTextosDescrip.add(langDesc);
								//nuevolangTextosDescrip[k] = langDesc;
				            }
						}else{
							LangStringVO langDesc = new LangStringVO();
							langDesc.setTexto("");
							langDesc.setIdioma("");
							if(!langDesc.getTexto().trim().equals(""))
								aNuevolangTextosDescrip.add(langDesc);
						}
						if(aNuevolangTextosDescrip.size()==0){
							nuevolangTextosDescrip = new LangStringVO[1];
							LangStringVO lang = new LangStringVO();
							lang.setIdioma("");
							lang.setTexto("");
							nuevolangTextosDescrip[0] = lang;
						}
						else 
							nuevolangTextosDescrip = (LangStringVO[])aNuevolangTextosDescrip.toArray(new LangStringVO[aNuevolangTextosDescrip.size()]);
						DescripcionVO descripcionVO= new DescripcionVO();
						descripcionVO.setTextos(nuevolangTextosDescrip);
						aDescripcionesVO[i]=descripcionVO;
					}
					else{
						//Descripcion vacia
						DescripcionVO descripcionVO = new DescripcionVO();
						nuevolangTextosDescrip = new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						nuevolangTextosDescrip[0] = lang;
						descripcionVO.setTextos(nuevolangTextosDescrip);
						aDescripcionesVO[i]=descripcionVO;
					} 
	    			//FECHA --> 2007-06-09... Formato completo-->yyyy-MM-ddThh:mm:ss.S(+-)00:00 <--
					Fecha auxFecha=new Fecha();
					if( contribuciones[i].getFecha()!=null && 
							contribuciones[i].getFecha().getFecha()!=null)
					{
						String fvo=  contribuciones[i].getFecha().getFecha();
						auxFecha.setFechaLomes(fvo );
					}
	    			 contribucionAux.setFecha(auxFecha);

	    			 
					/************************/
					//2.3.1 Tipo (ROL)
					/************************/
					String rol = terminoYPadreVuelta[i+1].getIdTermino();
					if (rol == null) {
						rol = "";//No hay ningún estado seleccionado
					}
					SourceValueVO tipo = new SourceValueVO();
					tipo.setValor(rol);
					contribucionAux.setRol(tipo);
					/************************/
					//2.3.2 Entidades
					/************************/
//					BEGIN:VCARD VERSION 3.0 FN:GT8/SC36/CT71 EMAIL;TYPE=INTERNET:GT8@aenor.es ORG:AENOR END:VCARD
					Entidad[] entidadesAux = null;
					ArrayList aEntidades= new ArrayList();
					if(contribuciones[i].getEntidades()!=null){
	    				EntidadVO[] entidades=metadatos.getContribuciones()[i].getEntidades();
	    				//entidadesAux = new Entidad[entidades.length];
	    				
	    				for(int j=0;j<entidades.length;j++){
	    					String nombre="";
	    					String organizacion="";
	    					String email="";
	    					String sEntidad = entidades[j].getTexto();
	    					if(sEntidad !=null && !sEntidad.trim().equals("")){
			    				String[] trozos = sEntidad.split(":");
			    				for (int k=0; k<trozos.length; k++) {
			    					String elem=trozos[k];
			    					if (elem.toUpperCase().endsWith("EMAIL;TYPE=INTERNET")){
			    						int finNombre = elem.toUpperCase().indexOf("EMAIL;TYPE=INTERNET");
			    						nombre = elem.substring(0, finNombre);
			    					}
			    					else if (elem.toUpperCase().endsWith("ORG")){
			    						int finEmail = elem.toUpperCase().indexOf("ORG");
			    						email = elem.substring(0, finEmail);
			    						if(!validaEmail(email.trim()))
			    							email="";
			    					}
			    					else if (elem.toUpperCase().endsWith("END")){
			    						int finOrg = elem.toUpperCase().indexOf("END");
			    						organizacion = elem.substring(0, finOrg);
			    					} 
			    				}//end for
			    				
			    				Entidad entidad = new Entidad();
			    				entidad.setCorreo(email!=null?email:"");
			    				entidad.setNombre(nombre!=null?nombre:"");
			    				entidad.setOrganizacion(organizacion!=null?organizacion:"");
			    				aEntidades.add(entidad);
			    				//entidadesAux[j]=entidad;
	    					}		    				
	    				}
	    				entidadesAux = (Entidad[])aEntidades.toArray(new Entidad[aEntidades.size()]);
	    				if(entidadesAux.length ==0){
							entidadesAux = new Entidad[1];
		    				Entidad entidad = new Entidad();
		    				entidad.setCorreo("");
		    				entidad.setNombre("");
		    				entidad.setOrganizacion("");
		    				entidadesAux[0]=entidad;
	    				}
    				}
					else{
						entidadesAux = new Entidad[1];
	    				Entidad entidad = new Entidad();
	    				entidad.setCorreo("");
	    				entidad.setNombre("");
	    				entidad.setOrganizacion("");
	    				entidadesAux[0]=entidad;
					}
    				contribucionAux.setEntidades(entidadesAux);
					/************************/
    				contribucionesAux[i]=contribucionAux;
				}
				form.setContribucionAsArray(contribucionesAux);
				form.setDescripcionesAsArray(aDescripcionesVO);
			} 
			else{
				Contribucion[] contribucionesAux=new Contribucion[1];
				Contribucion contribucionAux = new Contribucion();
				//Descripcion vacia
				DescripcionVO[] aDescripcionesVO = new DescripcionVO[1];
				DescripcionVO descripcionVO = new DescripcionVO();
				nuevolangTextosDescrip = new LangStringVO[1];
				LangStringVO lang = new LangStringVO();
				lang.setIdioma("");
				lang.setTexto("");
				nuevolangTextosDescrip[0] = lang;
				descripcionVO.setTextos(nuevolangTextosDescrip);
				aDescripcionesVO[0]=descripcionVO;
				//Fecha vacia
				Fecha auxFecha = new Fecha();
				contribucionAux.setFecha(auxFecha);
				/************************/
				//Tipo (ROL)
				SourceValueVO tipo = new SourceValueVO();
				tipo.setSource("");
				tipo.setValor("");
				contribucionAux.setRol(tipo);
				/************************/
				//Entidades
				Entidad[] entidades = new Entidad[1];
				Entidad entidad = new Entidad();
				entidad.setCorreo("");
				entidad.setNombre("");
				entidad.setOrganizacion("");
				entidades[0]=entidad;
				contribucionAux.setEntidades(entidades);
				/************************/
				contribucionesAux[0]=contribucionAux;
				form.setContribucionAsArray(contribucionesAux);
				form.setDescripcionesAsArray(aDescripcionesVO) ;
			}
			
			
	           //si metaMetadata era null en el objeto de session lo dejamos a null
            if (metaMetadataEsNull)
            	catalogadorAvSession.getMDSesion().setMetaMetadata(null);
	            
        }catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarMetametadatos " + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
		
	
     }



	public void cargarDatosTecnica(
			ActionMapping mapping, 
			CargarDatosTecnicaForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
    	InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			
//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
		     
//				comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			}	

//			comprobamos que tecnica no se ha null, si es null nos creamos uno	
			boolean tecnicaEsNull = false;
			if (catalogadorAvSession.getMDSesion().getTechnical() == null){
				AvTechnicalVO tecnica = new AvTechnicalVO();
				catalogadorAvSession.getMDSesion().setTechnical(tecnica);
				tecnicaEsNull=true;
			}
			
			//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
			String[] l_id = { prop.getProperty("formato"), prop.getProperty("tipo"),prop.getProperty("nombre"),prop.getProperty("idiomaDestinatario")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);		

			longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
			TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
			ArrayList terminoypadrear=new ArrayList();
			
			Collection id = new ArrayList();
			Collection idTipo = new ArrayList();
			Collection idNombre=new ArrayList();
			Collection idDest=new ArrayList();
			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {

				case 0:
					id.add(terminoVO);
//					modificamos las cadenas de formatos
					TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminos.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminos[li];
						idAux.setNomTermino(terminos[li].getNomTermino());
					}
					UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrd = terminosOrdDest1.ordenarTerminosVO(terminos, idiomaLdap);						
					Collection id2 = Arrays.asList(terminosOrd);
					
					Iterator z = id2.iterator();
					while (z.hasNext()) {
						id.add(z.next());
					}

					if ((catalogadorAvSession.getMDSesion().getTechnical() != null)&&(catalogadorAvSession.getMDSesion().getTechnical().getFormatos() !=null)) {
						FormatoVO[] formatosVO =catalogadorAvSession.getMDSesion().getTechnical().getFormatos();
						for(int j=0;j<formatosVO.length;j++){
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino(formatosVO[j].getTexto());
							terminoypadrear.add(terminoypadreVO);
						}//terminoYPadreVO rellenado con los formatos desde el lom avanzado
					}
					else {
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino("");
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 1:
					
					idTipo.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosTipo = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosTipo.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosTipo[li];
						idAux.setNomTermino(terminosTipo[li].getNomTermino());
					}
					UtilidadesOrdenarCombos terminosOrdDest3 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdTipo = terminosOrdDest3.ordenarTerminosVO(terminosTipo, idiomaLdap);						
					Collection idTipo2 = Arrays.asList(terminosOrdTipo);
					
					Iterator zTipo = idTipo2.iterator();
					while (zTipo.hasNext()) {
						idTipo.add(zTipo.next());
					}
					form.setComboTipoBackingList(idTipo, "idTermino", "nomTermino");
					
					break;
				case 2:
					idNombre.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosNombre = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosNombre.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosNombre[li];
						idAux.setNomTermino(terminosNombre[li].getNomTermino());
					}
					UtilidadesOrdenarCombos terminosOrdDest2 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdNombre = terminosOrdDest2.ordenarTerminosVO(terminosNombre, idiomaLdap);						
					Collection idNombre2 = Arrays.asList(terminosOrdNombre);
					
					Iterator zNombre = idNombre2.iterator();
					while (zNombre.hasNext()) {
						idNombre.add(zNombre.next());
					}
					form.setComboNombreBackingList(idNombre, "idTermino", "nomTermino");
					break;
				case 3:
					idDest.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosDest.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosDest[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrdDest4 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = terminosOrdDest4.ordenarTerminosVO(terminosDest, idiomaLdap);						
					Collection idDest2 = Arrays.asList(terminosOrdDest);
					
					Iterator zDest = idDest2.iterator();
					while (zDest.hasNext()) {
						idDest.add(zDest.next());
					}
					form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					
					break;
				}
				
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

			}
			System.out.println("Cargados los combos");

				
				TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);
				FormatoVO[] aNuevoFormatosVO =null;
				
				if ((arrayTerminoYPadre!=null) && (arrayTerminoYPadre.length>0)) {
					TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
					//FORMATOS
					FormatoVO[] aFormatosVO =catalogadorAvSession.getMDSesion().getTechnical().getFormatos();
					if (aFormatosVO != null && (aFormatosVO.length>0)){ //!(aFormatosVO.length==1 && aFormatosVO[0].getTexto().equals(""))
						aNuevoFormatosVO = new FormatoVO[catalogadorAvSession.getMDSesion().getTechnical().getFormatos().length];
						for (int idi = 0; idi<terminoYPadreVuelta.length; idi++) {
							FormatoVO formato = new FormatoVO();
							formato.setTexto(terminoYPadreVuelta[idi].getIdTermino());
							aNuevoFormatosVO[idi]=formato;
			            }
					}
					else{
						aNuevoFormatosVO = new FormatoVO[1];
						FormatoVO formato = new FormatoVO();
						formato.setTexto("");
						aNuevoFormatosVO[0]=formato;
					}
				} else { //si arrayTerminoYPadre es null
					aNuevoFormatosVO = new FormatoVO[1];
					FormatoVO formato = new FormatoVO();
					formato.setTexto("");
					aNuevoFormatosVO[0]=formato;
				}
	            form.setFormatosAsArray(aNuevoFormatosVO);
	            form.setFormatosBackingList(id, "idTermino", "nomTermino");
	            
	            //TAMAÑO

				if((catalogadorAvSession.getMDSesion().getTechnical()!=null) && (catalogadorAvSession.getMDSesion().getTechnical().getTamanio()!=null )&&(catalogadorAvSession.getMDSesion().getTechnical().getTamanio().getTexto()!=null))
					form.setTamanio(catalogadorAvSession.getMDSesion().getTechnical().getTamanio().getTexto().trim());
				else{//????
					TamanioVO tamanio=new TamanioVO();
					tamanio.setTexto("");
					form.setTamanio("");
			    	
				}
				//LOCALIZACION
				if((catalogadorAvSession.getMDSesion().getTechnical()!=null) && (catalogadorAvSession.getMDSesion().getTechnical().getLocalizaciones()!=null)&&(catalogadorAvSession.getMDSesion().getTechnical().getLocalizaciones().length>0)){
					ArrayList listLocalizaciones=new ArrayList();
					for(int i=0;i<catalogadorAvSession.getMDSesion().getTechnical().getLocalizaciones().length;i++){
						LocalizacionVO localizacion=new LocalizacionVO();
						localizacion.setTexto(catalogadorAvSession.getMDSesion().getTechnical().getLocalizaciones()[i].getTexto().trim());
						listLocalizaciones.add(localizacion);
					}
					LocalizacionVO[] localizaciones=(LocalizacionVO[])listLocalizaciones.toArray(new LocalizacionVO[listLocalizaciones.size()]);
					form.setLocalizacionAsArray(localizaciones);
				}else{
					LocalizacionVO[] aNuevoLocalizacionVO=new LocalizacionVO[1];
					LocalizacionVO nuevoLocalizacion=new LocalizacionVO();
					nuevoLocalizacion.setTexto("");
					aNuevoLocalizacionVO[0]=nuevoLocalizacion;
					form.setLocalizacionAsArray(aNuevoLocalizacionVO);
				}
				

				//REQUERIMIENTO
				RequisitoVO[] ArequisitoVO =null;
				RequisitoVO[] AnuevoRequisitoVO=null;
				if((catalogadorAvSession.getMDSesion().getTechnical()!=null)&&(catalogadorAvSession.getMDSesion().getTechnical().getRequisitos()!=null)&&(catalogadorAvSession.getMDSesion().getTechnical().getRequisitos().length>0)){
					ArequisitoVO=catalogadorAvSession.getMDSesion().getTechnical().getRequisitos();
					AnuevoRequisitoVO=new RequisitoVO[ArequisitoVO.length];
					TerminoYPadreVO[] arrayTerminoYPadreAgregados=null;
					for(int i=0;i<ArequisitoVO.length;i++){//Todos los requisitos unoa auno
						RequisitoVO lRequisito=new RequisitoVO();
//						AgregadorORVO[] nuevoLAgregadorVO=null;
						if((ArequisitoVO[i].getAgregadoresOR()!=null)&&(ArequisitoVO[i].getAgregadoresOR().length>0)){
							AgregadorORVO[] lAgregadorVO = ArequisitoVO[i].getAgregadoresOR();
							
							ArrayList lRequerimientos = new ArrayList();
							ArrayList agregados=new ArrayList();
							
							for (int j = 0; j<lAgregadorVO.length; j++){//Todos dos AgregadoresOR uno a uno
//								nuevoLAgregadorVO=new AgregadorORVO[lAgregadorVO.length];
								ArrayList terminoYPadreDescripcion = new  ArrayList();
								if(lAgregadorVO[j].getTipo()!=null){
									terminoypadreVO = new TerminoYPadreVO();
									terminoypadreVO.setIdiomaTermino("en");
									terminoypadreVO.setIdVocabulario("4.4.1.1");
									terminoypadreVO.setIdTermino("");
								
									if(ArequisitoVO[i].getAgregadoresOR()[j].getTipo().getValor() !=null){
										String tipo=ArequisitoVO[i].getAgregadoresOR()[j].getTipo().getValor();
										terminoypadreVO.setNomTermino(tipo);
									}
									else
										terminoypadreVO.setNomTermino("");
									terminoYPadreDescripcion.add(terminoypadreVO);
								}
								if(lAgregadorVO[j].getNombre()!=null){
									terminoypadreVO = new TerminoYPadreVO();
									terminoypadreVO.setIdiomaTermino("en");
									terminoypadreVO.setIdVocabulario("4.4.1.2");
									terminoypadreVO.setIdTermino("");
									if(ArequisitoVO[i].getAgregadoresOR()[j].getNombre().getValor() !=null){
										String nombre=ArequisitoVO[i].getAgregadoresOR()[j].getNombre().getValor();
										terminoypadreVO.setNomTermino(nombre);
									}
									else
										terminoypadreVO.setNomTermino("");
									terminoYPadreDescripcion.add(terminoypadreVO);							
								}
								
								lRequerimientos.add(terminoYPadreDescripcion);
								
							}
							ArrayList terminoYPadreAgregados=new ArrayList();
							for(int k=0;k<lRequerimientos.size();k++){//Cogemos todos los elementos de los arrayList uno a uno
								ArrayList lReque=(ArrayList)(lRequerimientos.get(k));
								for(int l=0;l<lReque.size();l++){
									terminoYPadreAgregados.add(lReque.get(l)) ;
								}
							}
							arrayTerminoYPadreAgregados=(TerminoYPadreVO[])terminoYPadreAgregados.toArray(new TerminoYPadreVO[terminoYPadreAgregados.size()]);
							TerminoYPadreVO[] terminoYPadreAgregadosVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreAgregados);
							
							for(int j=0;j<lAgregadorVO.length;j++){
								
									
								AgregadorORVO agregado=new AgregadorORVO();
								
									SourceValueVO tipo=new SourceValueVO();
									tipo.setSource(ArequisitoVO[i].getAgregadoresOR()[j].getTipo().getSource());
									tipo.setValor(terminoYPadreAgregadosVuelta[2*j].getIdTermino());
									agregado.setTipo(tipo);
									SourceValueVO nombre=new SourceValueVO();
									nombre.setSource(ArequisitoVO[i].getAgregadoresOR()[j].getNombre().getSource());
									nombre.setValor(terminoYPadreAgregadosVuelta[(2*j)+1].getIdTermino());
									agregado.setNombre(nombre);
									
									agregado.setVersionMax(ArequisitoVO[i].getAgregadoresOR()[j].getVersionMax());
									agregado.setVersionMin(ArequisitoVO[i].getAgregadoresOR()[j].getVersionMin());
								

								
								agregados.add(agregado);
								
							}
							AgregadorORVO[]  agregadores=(AgregadorORVO[])agregados.toArray(new AgregadorORVO[agregados.size()]);
							lRequisito.setAgregadoresOR(agregadores);
							AnuevoRequisitoVO[i]=lRequisito;
						}else{
							AnuevoRequisitoVO = new RequisitoVO[1];
							RequisitoVO requisi=new RequisitoVO();
							AgregadorORVO[] aAgregadores =new AgregadorORVO[1];
							AgregadorORVO agrega=new AgregadorORVO();
							String source = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
							SourceValueVO nombre=new SourceValueVO();
							nombre.setValor("");
							nombre.setSource(source);
							SourceValueVO tipo=new SourceValueVO();
							tipo.setValor("");
							tipo.setSource(source);
							agrega.setNombre(nombre);
							agrega.setTipo(tipo);
							VersionMaxVO maximo=new VersionMaxVO();
							maximo.setTexto("");
							agrega.setVersionMax(maximo);
							VersionMinVO minimo=new VersionMinVO();
							minimo.setTexto("");
							agrega.setVersionMin(minimo);
							aAgregadores[0]=agrega;
							requisi.setAgregadoresOR(aAgregadores);
							AnuevoRequisitoVO[0]=requisi;
							
							
							
						}
					}
					
					
				}else{
					AnuevoRequisitoVO = new RequisitoVO[1];
					RequisitoVO requisi=new RequisitoVO();
					AgregadorORVO[] aAgregadores =new AgregadorORVO[1];
					AgregadorORVO agrega=new AgregadorORVO();
					SourceValueVO nombre=new SourceValueVO();
					nombre.setValor("");
					String source = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
					nombre.setSource(source);
					SourceValueVO tipo=new SourceValueVO();
					tipo.setValor("");
					tipo.setSource(source);
					agrega.setNombre(nombre);
					agrega.setTipo(tipo);
					VersionMaxVO maximo=new VersionMaxVO();
					maximo.setTexto("");
					agrega.setVersionMax(maximo);
					VersionMinVO minimo=new VersionMinVO();
					minimo.setTexto("");
					agrega.setVersionMin(minimo);
					aAgregadores[0]=agrega;
					requisi.setAgregadoresOR(aAgregadores);
					AnuevoRequisitoVO[0]=requisi;
					
					
					
				}
				
				form.setRequerimientoAsArray(AnuevoRequisitoVO);
				
				//NOTAS DE INSTALACION
				
				
				ArrayList terminoYPadreNotas = new  ArrayList();
				LangStringVO[] langTextosNota = null;
				LangStringVO[] nuevolangTextosNota =null;
				PautasInstalacionVO[] aNotaVO = new PautasInstalacionVO[1];
				PautasInstalacionVO notaVO= new PautasInstalacionVO();
				if ((catalogadorAvSession.getMDSesion().getTechnical() != null)&&(catalogadorAvSession.getMDSesion().getTechnical().getPautasInstalacion() !=null)&& (catalogadorAvSession.getMDSesion().getTechnical().getPautasInstalacion().getTextos()!=null) && (catalogadorAvSession.getMDSesion().getTechnical().getPautasInstalacion().getTextos().length)> 0) {
					langTextosNota =catalogadorAvSession.getMDSesion().getTechnical().getPautasInstalacion().getTextos();
					for(int j=0;j<langTextosNota.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario("5.11");
						terminoypadreVO.setIdTermino("");
						if(langTextosNota[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosNota[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreNotas.add(terminoypadreVO);
					}
					
					TerminoYPadreVO[] arrayTerminoYPadreNotas=(TerminoYPadreVO[])terminoYPadreNotas.toArray(new TerminoYPadreVO[terminoYPadreNotas.size()]);
					TerminoYPadreVO[] terminoYPadreNotasVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreNotas);
					
					nuevolangTextosNota = new LangStringVO[terminoYPadreNotasVuelta.length];
					for (int i = 0; i<terminoYPadreNotasVuelta.length; i++) {
						LangStringVO langNota = new LangStringVO();
						langNota.setTexto(langTextosNota[i].getTexto().trim());
						langNota.setIdioma(terminoYPadreNotasVuelta[i].getIdTermino());
						nuevolangTextosNota[i] = langNota;
		            }
				} 
				else{
					nuevolangTextosNota = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosNota[0] = lang;
				}
				notaVO.setTextos(nuevolangTextosNota);
				aNotaVO[0]=notaVO;
	            form.setDescripcionInstalacionAsArray(aNotaVO);
	            
	            //MAS REQUERIMIENTOS
	            
	            ArrayList terminoYPadreOtros = new  ArrayList();
				LangStringVO[] langTextosOtro = null;
				LangStringVO[] nuevolangTextosOtro =null;
				OtrosRequisitosVO[] aOtroVO = new OtrosRequisitosVO[1];
				OtrosRequisitosVO otroVO= new OtrosRequisitosVO();
				if ((catalogadorAvSession.getMDSesion().getTechnical() != null)&&(catalogadorAvSession.getMDSesion().getTechnical().getOtrosRequisitos() !=null)&& (catalogadorAvSession.getMDSesion().getTechnical().getOtrosRequisitos().getTextos()!=null) && (catalogadorAvSession.getMDSesion().getTechnical().getOtrosRequisitos().getTextos().length)> 0) {
					langTextosOtro =catalogadorAvSession.getMDSesion().getTechnical().getOtrosRequisitos().getTextos();
					for(int j=0;j<langTextosOtro.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario("5.11");
						terminoypadreVO.setIdTermino("");
						if(langTextosOtro[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosOtro[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreOtros.add(terminoypadreVO);
					}
					
					TerminoYPadreVO[] arrayTerminoYPadreOtros=(TerminoYPadreVO[])terminoYPadreOtros.toArray(new TerminoYPadreVO[terminoYPadreOtros.size()]);
					TerminoYPadreVO[] terminoYPadreOtrosVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreOtros);
					
					nuevolangTextosOtro = new LangStringVO[terminoYPadreOtrosVuelta.length];
					for (int i = 0; i<terminoYPadreOtrosVuelta.length; i++) {
						LangStringVO langOtro = new LangStringVO();
						langOtro.setTexto(langTextosOtro[i].getTexto().trim());
						langOtro.setIdioma(terminoYPadreOtrosVuelta[i].getIdTermino());
						nuevolangTextosOtro[i] = langOtro;
		            }
				} 
				else{
					nuevolangTextosOtro = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosOtro[0] = lang;
				}
				otroVO.setTextos(nuevolangTextosOtro);
				aOtroVO[0]=otroVO;
	            form.setDescripcionRequerimientosAsArray(aOtroVO);
	            
//	          DURACION
				//Duracion   //expresion regular P[yY][mM][dD][T[hH][nM][s[.s]S]]
				anyos="";meses="";dias="";horas="";minutos="";segundosP1="";segundosP2="";
				if ((catalogadorAvSession.getMDSesion().getTechnical() != null) && (catalogadorAvSession.getMDSesion().getTechnical().getDuracion() !=null)){
					DuracionVO duracionVO=catalogadorAvSession.getMDSesion().getTechnical().getDuracion();
					if (duracionVO!=null && duracionVO.getDuracion()!=null){
						duracion = duracionVO.getDuracion();
						descifrarDuration();
					}
				}
				form.setAnyo(anyos);
				form.setMes(meses);
				form.setDia(dias);
				form.setHora(horas);
				form.setMinutos(minutos);
				form.setSegundoP1(segundosP1);
				form.setSegundoP2(segundosP2);
				
				//Descripcion duracion
				ArrayList terminoYPadreDescripTA = new  ArrayList();
				LangStringVO[] langTextosDescripTA = null;
				LangStringVO[] nuevolangTextosDescripTA =null;
				DescripcionVO[] aDescripcionesTA_VO = new DescripcionVO[1];
				DescripcionVO descripcionTA_VO= new DescripcionVO();
				if ((catalogadorAvSession.getMDSesion().getTechnical() != null) && (catalogadorAvSession.getMDSesion().getTechnical().getDuracion() !=null)
					&& (catalogadorAvSession.getMDSesion().getTechnical().getDuracion().getDescripcion() !=null)
					&& (catalogadorAvSession.getMDSesion().getTechnical().getDuracion().getDescripcion().getTextos()!=null)
					&& (catalogadorAvSession.getMDSesion().getTechnical().getDuracion().getDescripcion().getTextos().length)> 0) {
					langTextosDescripTA =catalogadorAvSession.getMDSesion().getTechnical().getDuracion().getDescripcion().getTextos();
					for(int j=0;j<langTextosDescripTA.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario("5.11");
						terminoypadreVO.setIdTermino("");
						if(langTextosDescripTA[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosDescripTA[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreDescripTA.add(terminoypadreVO);
					}
					
					TerminoYPadreVO[] arrayTerminoYPadreDescTA=(TerminoYPadreVO[])terminoYPadreDescripTA.toArray(new TerminoYPadreVO[terminoYPadreDescripTA.size()]);
					TerminoYPadreVO[] terminoYPadreDescTAVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDescTA);
					
					nuevolangTextosDescripTA = new LangStringVO[terminoYPadreDescTAVuelta.length];
					for (int i = 0; i<terminoYPadreDescTAVuelta.length; i++) {
						LangStringVO langDescTA = new LangStringVO();
						langDescTA.setTexto(langTextosDescripTA[i].getTexto().trim());
						langDescTA.setIdioma(terminoYPadreDescTAVuelta[i].getIdTermino());
						nuevolangTextosDescripTA[i] = langDescTA;
		            }
				} 
				else{
					nuevolangTextosDescripTA = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosDescripTA[0] = lang;
				}
				descripcionTA_VO.setTextos(nuevolangTextosDescripTA);
				aDescripcionesTA_VO[0]=descripcionTA_VO;
	            form.setDescripcionDuracionAsArray(aDescripcionesTA_VO); 
	            
	            
//	          si tecnica era null en el objeto de session lo dejamos a null
	            if(tecnicaEsNull)
	            	catalogadorAvSession.getMDSesion().setTechnical(null);
	            
        }catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarTecnica" + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
    }



	public void cargarDetalleUsoEdu(
			ActionMapping mapping, 
			CargarDetalleUsoEduForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
        try{
		
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);

			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

	        is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	       
			
//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
		     
			
			//comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			} 
			
			
			String botonPulsado = request.getParameter("botonPulsado");
			//form.setBotonPulsado(botonPulsado); //actualizamos si es modificar o crear
			String titulo = request.getParameter("titulo");
			form.setTituloUsoEducativo(titulo);//numero del titulo,ejem: Uso Educativo 1
			
			//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
			String[] l_id = { prop.getProperty("idiomaDestinatario"),prop.getProperty("tipoRecursoAprendizaje"),prop.getProperty("rolEdu"),
							prop.getProperty("contexto"),prop.getProperty("procesoCognitivo"),prop.getProperty("tipoInteractividad"),
							prop.getProperty("nivelInteractividad"),prop.getProperty("densidadSemantica"),prop.getProperty("dificultad")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);			

			//Cargamos los combos
			longVocabulario = vocabularioOrdenado.length;
	

			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");
				
				switch (x) {
				case 0://IDIOMA DESTINATARIO
					Collection id = new ArrayList();
					
					id.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminos.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminos[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrd = terminosOrdDest1.ordenarTerminosVO(terminos, idiomaLdap);					
					Collection id2 = Arrays.asList(terminosOrd);
					
					Iterator z = id2.iterator();
					while (z.hasNext()) {
						id.add(z.next());
					}

					form.setIdiomasBackingList(id, "idTermino", "nomTermino");//combo idiomas
					form.setComboIdiomaBackingList(id, "idTermino", "nomTermino");//combo idioma de lo campos de texto
					break;
					
				case 1://TIPO RECURSO EDUCATIVO
					Collection cTipoRecurso = new ArrayList();
					cTipoRecurso.add(terminoVO);
					Collection cTipoRecursoAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont2 = cTipoRecursoAux.iterator();
					while (cont2.hasNext()) {
						cTipoRecurso.add(cont2.next());
					}
					form.setComboTipoRecursoBackingList(cTipoRecurso, "idTermino", "nomTermino");
					break;
				case 2://DESTINATARIO O ROL DEL USUARIO FINAL
					Collection cDestinatrio = new ArrayList();
					cDestinatrio.add(terminoVO);
					Collection cDesctinatarioAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator contR = cDesctinatarioAux.iterator();
					while (contR.hasNext()) {
						cDestinatrio.add(contR.next());
					}
					form.setComboRolBackingList(cDestinatrio, "idTermino", "nomTermino");
					break;
				case 3://CONTEXTO
					Collection cContexto = new ArrayList();
					cContexto.add(terminoVO);
					Collection cContextoAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator contC = cContextoAux.iterator();
					while (contC.hasNext()) {
						cContexto.add(contC.next());
					}
					form.setComboContextoBackingList(cContexto, "idTermino", "nomTermino");
					break;
				case 4://PROCESO COGNITIVO 
					Collection cProcesoCog = new ArrayList();
					cProcesoCog.add(terminoVO);
					Collection cProcesoCogAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator contP = cProcesoCogAux.iterator();
					while (contP.hasNext()) {
						cProcesoCog.add(contP.next());
					}
					form.setComboProcesoBackingList(cProcesoCog, "idTermino", "nomTermino");
					break;
				case 5://TIPO INTERACTIVIDAD
					Collection cTipoInteract = new ArrayList();
					cTipoInteract.add(terminoVO);
					Collection cTipoInteractAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont = cTipoInteractAux.iterator();
					while (cont.hasNext()) {
						cTipoInteract.add(cont.next());
					}
					form.setTipoInteractividadBackingList(cTipoInteract, "idTermino", "nomTermino");
					break;

				case 6://NIVEL INTERACTIVIDAD
					Collection cNivelInteract = new ArrayList();
					cNivelInteract.add(terminoVO);
					Collection cNivelInteractAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator contN = cNivelInteractAux.iterator();
					while (contN.hasNext()) {
						cNivelInteract.add(contN.next());
					}
					form.setNivelInteractividadBackingList(cNivelInteract, "idTermino", "nomTermino");		

					break;
				case 7://DENSIDAD SEMANTICA
					Collection cDensidad = new ArrayList();
					cDensidad.add(terminoVO);
					Collection cDensidadAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator contD = cDensidadAux.iterator();
					while (contD.hasNext()) {
						cDensidad.add(contD.next());
					}
					form.setDensidadSemanticaBackingList(cDensidad, "idTermino", "nomTermino");
					break;
				case 8://DIFICULTAD
					Collection cDificultad= new ArrayList();
					cDificultad.add(terminoVO);
					Collection cDificultadAux = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator contDif = cDificultadAux.iterator();
					while (contDif.hasNext()) {
						cDificultad.add(contDif.next());
					}
					form.setDificultadBackingList(cDificultad, "idTermino", "nomTermino");
					break;
				}
				
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

			}
			System.out.println("Cargados los combos");

			
			//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			//ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			
			//Caso Modificacion
			String botonModificar=prop.getProperty("botonModificar")!=null?prop.getProperty("botonModificar"):"";
			AvEducationalVO[] educaciones =catalogadorAvSession.getMDSesion().getEducational();
			if (botonModificar.equals(botonPulsado)) { //Modificacion
				TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
				ArrayList terminoypadrear=new ArrayList();
			
				iEdu = Integer.parseInt(request.getParameter("titulo")) - 1;
				//comprobamos que educational no se ha null, si es null nos creamos uno	
				boolean educacionEsNull = false;
				if (educaciones[iEdu] == null){
					AvEducationalVO educational = new AvEducationalVO();
					educaciones[iEdu] = educational;
					educacionEsNull=true;
				}
				
				for (int x = 0; x < longVocabulario; x++) {
					switch (x) {
					case 0://IDIOMA DESTINATARIO
						//recogemos los idiomas (idioma destinatario)
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getIdiomas() !=null)) {
							IdiomaVO[] idiomasVO =educaciones[iEdu].getIdiomas();
							for(int j=0;j<idiomasVO.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(idiomasVO[j].getTexto());
								terminoypadrear.add(terminoypadreVO);
							}
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						
						break;
						
					case 1://TIPO RECURSO EDUCATIVO
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getTiposrecursoedu()!=null)) {
							SourceValueVO[] tiposRecursoVO =educaciones[iEdu].getTiposrecursoedu();
							for(int j=0;j<tiposRecursoVO.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(tiposRecursoVO[j].getValor());
								terminoypadrear.add(terminoypadreVO);
							}
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					case 2://DESTINATARIO O ROL DEL USUARIO FINAL
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getDestinatarios()!=null)) {
							SourceValueVO[] destinatariosVO =educaciones[iEdu].getDestinatarios();
							for(int j=0;j<destinatariosVO.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(destinatariosVO[j].getValor());
								terminoypadrear.add(terminoypadreVO);
							}
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					case 3://CONTEXTO
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getContextos()!=null)) {
							SourceValueVO[] contextosVO =educaciones[iEdu].getContextos();
							for(int j=0;j<contextosVO.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(contextosVO[j].getValor());
								terminoypadrear.add(terminoypadreVO);
							}
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					case 4://PROCESO COGNITIVO 
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getProcesoscognitivos()!=null)) {
							SourceValueVO[] procesosCogVO =educaciones[iEdu].getProcesoscognitivos();
							for(int j=0;j<procesosCogVO.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(procesosCogVO[j].getValor());
								terminoypadrear.add(terminoypadreVO);
							}
						}
						else {
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					case 5://TIPO INTERACTIVIDAD
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getTipoDeInteractividad() !=null)) {
							terminoypadreVO.setNomTermino(educaciones[iEdu].getTipoDeInteractividad().getValor());
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con estructura desde el formulario
							terminoypadrear.add(terminoypadreVO);
						}
						
						break;

					case 6://NIVEL INTERACTIVIDAD	
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getNivelInteractividad() !=null)) {
							terminoypadreVO.setNomTermino(educaciones[iEdu].getNivelInteractividad().getValor());
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					case 7://DENSIDAD SEMANTICA
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getDensidadSemantica() !=null)) {
							terminoypadreVO.setNomTermino(educaciones[iEdu].getDensidadSemantica().getValor());
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					case 8://DIFICULTAD
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getDificultad() !=null)) {
							terminoypadreVO.setNomTermino(educaciones[iEdu].getDificultad().getValor());
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino("");
							terminoypadrear.add(terminoypadreVO);
						}
						break;
					}// fin switch	
				}//fin for
				
				
				TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);
				TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
				//Dividimos el array
				ArrayList arrayIdioma=new ArrayList();
				ArrayList arrayTipoRecurso=new ArrayList();
				ArrayList arrayRol=new ArrayList();
				ArrayList arrayContexto=new ArrayList();
				ArrayList arrayProcesoCog=new ArrayList();
				ArrayList arrays=new ArrayList();
				for(int k=0;k<terminoYPadreVuelta.length;k++){
					String idPadre=terminoYPadreVuelta[k].getIdVocabulario();
					if(idPadre.equals(l_id[0])){//IDIOMA DESTINATARIO
						arrayIdioma.add(terminoYPadreVuelta[k]);
					}
					else if(idPadre.equals(l_id[1])){//TIPO RECURSO EDUCATIVO
						arrayTipoRecurso.add(terminoYPadreVuelta[k]);
					}
					else if(idPadre.equals(l_id[2])){//DESTINATARIO O ROL DEL USUARIO FINAL
						arrayRol.add(terminoYPadreVuelta[k]);
					}
					else if(idPadre.equals(l_id[3])){//CONTEXTO
						arrayContexto.add(terminoYPadreVuelta[k]);
					}
					else if(idPadre.equals(l_id[4])){//PROCESO COGNITIVO 
						arrayProcesoCog.add(terminoYPadreVuelta[k]);
					}
					else {//RESTO DE LOS COMBOS
						arrays.add(terminoYPadreVuelta[k]);
					}
				}
				TerminoYPadreVO[] idiomasTP=(TerminoYPadreVO[])arrayIdioma.toArray(new TerminoYPadreVO[arrayIdioma.size()]);
				TerminoYPadreVO[] tipoRecursoTP=(TerminoYPadreVO[])arrayTipoRecurso.toArray(new TerminoYPadreVO[arrayTipoRecurso.size()]);
				TerminoYPadreVO[] rolTP=(TerminoYPadreVO[])arrayRol.toArray(new TerminoYPadreVO[arrayRol.size()]);
				TerminoYPadreVO[] contextoTP=(TerminoYPadreVO[])arrayContexto.toArray(new TerminoYPadreVO[arrayContexto.size()]);
				TerminoYPadreVO[] procesoCogTP=(TerminoYPadreVO[])arrayProcesoCog.toArray(new TerminoYPadreVO[arrayProcesoCog.size()]);
				TerminoYPadreVO[] restoCombos=(TerminoYPadreVO[])arrays.toArray(new TerminoYPadreVO[arrays.size()]);
				
				//IDIOMAS DESTINATARIO
				IdiomaVO[] aNuevoIdiomasVO =null;
				IdiomaVO[] aIdiomasVO =educaciones[iEdu].getIdiomas();
				if (aIdiomasVO != null && aIdiomasVO.length!=0 && !(aIdiomasVO.length==1 && aIdiomasVO[0].getTexto().equals(""))){
					aNuevoIdiomasVO = new IdiomaVO[educaciones[iEdu].getIdiomas().length];
					for (int idi = 0; idi<idiomasTP.length; idi++) {
						IdiomaVO idioma = new IdiomaVO();
						idioma.setTexto(idiomasTP[idi].getIdTermino());
						aNuevoIdiomasVO[idi]=idioma;
		            }
				}
				else{
					aNuevoIdiomasVO = new IdiomaVO[1];
					IdiomaVO idioma = new IdiomaVO();
					idioma.setTexto("");
					aNuevoIdiomasVO[0]=idioma;
				}
	            form.setIdiomasAsArray(aNuevoIdiomasVO);
	            
	            //TIPO RECURSO EDUCATIVO
				SourceValueVO[] aNuevoTiposRecursoVO =null;
				SourceValueVO[] aTiposRecursoVO =educaciones[iEdu].getTiposrecursoedu();
				if (aTiposRecursoVO != null && aTiposRecursoVO.length!=0 && !(aTiposRecursoVO.length==1 && aTiposRecursoVO[0].getValor().equals(""))){
					aNuevoTiposRecursoVO = new SourceValueVO[educaciones[iEdu].getTiposrecursoedu().length];
					for (int idi = 0; idi<tipoRecursoTP.length; idi++) {
						SourceValueVO tipoRecurso = new SourceValueVO();
						tipoRecurso.setSource(source);
						tipoRecurso.setValor(tipoRecursoTP[idi].getIdTermino());
						aNuevoTiposRecursoVO[idi]=tipoRecurso;
		            }
				}
				else{
					aNuevoTiposRecursoVO = new SourceValueVO[1];
					SourceValueVO tipoRecurso = new SourceValueVO();
					tipoRecurso.setSource("");
					tipoRecurso.setValor("");
					aNuevoTiposRecursoVO[0]=tipoRecurso;
				}
	            form.setTipoRecursoAsArray(aNuevoTiposRecursoVO);
	            
	            //DESTINATARIO O ROL DEL USUARIO FINAL
				SourceValueVO[] aNuevoDestinatariosVO =null;
				SourceValueVO[] aDestinatariosVO =educaciones[iEdu].getDestinatarios();
				if (aDestinatariosVO != null && aDestinatariosVO.length!=0 &&!(aDestinatariosVO.length==1 && aDestinatariosVO[0].getValor().equals(""))){
					aNuevoDestinatariosVO = new SourceValueVO[educaciones[iEdu].getDestinatarios().length];
					for (int idi = 0; idi<rolTP.length; idi++) {
						SourceValueVO destinatario = new SourceValueVO();
						destinatario.setSource(source);
						destinatario.setValor(rolTP[idi].getIdTermino());
						aNuevoDestinatariosVO[idi]=destinatario;
		            }
				}
				else{
					aNuevoDestinatariosVO = new SourceValueVO[1];
					SourceValueVO destinatario = new SourceValueVO();
					destinatario.setSource("");
					destinatario.setValor("");
					aNuevoDestinatariosVO[0]=destinatario;
				}
	            form.setRolUsuarioAsArray(aNuevoDestinatariosVO);
	            
	            //CONTEXTO
				SourceValueVO[] aNuevoContextosVO =null;
				SourceValueVO[] aContextosVO =educaciones[iEdu].getContextos();
				if (aContextosVO != null && aContextosVO.length!=0 && !(aContextosVO.length==1 && aContextosVO[0].getValor().equals(""))){
					aNuevoContextosVO = new SourceValueVO[educaciones[iEdu].getContextos().length];
					for (int idi = 0; idi<contextoTP.length; idi++) {
						SourceValueVO contexto = new SourceValueVO();
						contexto.setSource(source);
						contexto.setValor(contextoTP[idi].getIdTermino());
						aNuevoContextosVO[idi]=contexto;
		            }
				}
				else{
					aNuevoContextosVO = new SourceValueVO[1];
					SourceValueVO contexto = new SourceValueVO();
					contexto.setSource("");
					contexto.setValor("");
					aNuevoContextosVO[0]=contexto;
				}
	            form.setContextoAsArray(aNuevoContextosVO);
	            
	            //PROCESO COGNITIVO
				SourceValueVO[] aNuevoProcesosVO =null;
				SourceValueVO[] aProcesosVO =educaciones[iEdu].getProcesoscognitivos();
				if (aProcesosVO != null && aProcesosVO.length!=0 && !(aProcesosVO.length==1 && aProcesosVO[0].getValor().equals(""))){
					aNuevoProcesosVO = new SourceValueVO[educaciones[iEdu].getProcesoscognitivos().length];
					for (int idi = 0; idi<procesoCogTP.length; idi++) {
						SourceValueVO proceso = new SourceValueVO();
						proceso.setSource(source);
						proceso.setValor(procesoCogTP[idi].getIdTermino());
						aNuevoProcesosVO[idi]=proceso;
		            }
				}
				else{
					aNuevoProcesosVO = new SourceValueVO[1];
					SourceValueVO proceso = new SourceValueVO();
					proceso.setSource("");
					proceso.setValor("");
					aNuevoProcesosVO[0]=proceso;
				}
	            form.setProcesoCognitivoAsArray(aNuevoProcesosVO);
	            
	            //TIPO INTERACTIVIDAD
				String idTI = restoCombos[0].getIdTermino();	
				if (idTI == null) {
					idTI = "";//No hay ningún tipo se recurso seleccionado por defecto
				}
				form.setTipoInteractividad(idTI);
				
				//NIVEL INTERACTIVIDAD
				String idNI = restoCombos[1].getIdTermino();	
				if (idNI == null) {
					idNI = "";//No hay ningún tipo se recurso seleccionado por defecto
				}
				form.setNivelInteractividad(idNI);
				//DENSIDAD SEMANTICA
				String idDS = restoCombos[2].getIdTermino();	
				if (idDS == null) {
					idDS = "";//No hay ningún tipo se recurso seleccionado por defecto
				}
				form.setDensidadSemantica(idDS);
				//DIFICULTAD
				String idD = restoCombos[3].getIdTermino();	
				if (idD == null) {
					idD = "";//No hay ningún tipo se recurso seleccionado por defecto
				}
				form.setDificultad(idD);
				
	//				if( logger.isDebugEnabled() ){
	//
	//	                logger.debug("Cargados en el formulario los idiomas, la estructura y el nivel de agregacion" );
	//				}	
	
				//TIEMPO DE APRENDIZAJE
				//Duracion   //expresion regular P[yY][mM][dD][T[hH][nM][s[.s]S]]
				anyos="";meses="";dias="";horas="";minutos="";segundosP1="";segundosP2="";
				if ((educaciones[iEdu] != null) && (educaciones[iEdu].getTiempoAprendizaje() !=null)){
					duracion = educaciones[iEdu].getTiempoAprendizaje().getDuracion();
					if (duracion!=null )
						descifrarDuration();
					}
				form.setAnyo(anyos);
				form.setMes(meses);
				form.setDia(dias);
				form.setHora(horas);
				form.setMinutos(minutos);
				form.setSegundoP1(segundosP1);
				form.setSegundoP2(segundosP2);
				
				//Descripcion tiempo de aprendizaje
				ArrayList terminoYPadreDescripTA = new  ArrayList();
				LangStringVO[] langTextosDescripTA = null;
				LangStringVO[] nuevolangTextosDescripTA =null;
				DescripcionVO[] aDescripcionesTA_VO = new DescripcionVO[1];
				DescripcionVO descripcionTA_VO= new DescripcionVO();
				if ((educaciones[iEdu] != null) && (educaciones[iEdu].getTiempoAprendizaje() !=null)
					&& (educaciones[iEdu].getTiempoAprendizaje().getDescripcion() !=null)
					&& (educaciones[iEdu].getTiempoAprendizaje().getDescripcion().getTextos().length)> 0) {
					langTextosDescripTA =educaciones[iEdu].getTiempoAprendizaje().getDescripcion().getTextos();
					for(int j=0;j<langTextosDescripTA.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario("5.11");
						terminoypadreVO.setIdTermino("");
						if(langTextosDescripTA[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosDescripTA[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreDescripTA.add(terminoypadreVO);
					}
					
					TerminoYPadreVO[] arrayTerminoYPadreDescTA=(TerminoYPadreVO[])terminoYPadreDescripTA.toArray(new TerminoYPadreVO[terminoYPadreDescripTA.size()]);
					TerminoYPadreVO[] terminoYPadreDescTAVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDescTA);
					
					nuevolangTextosDescripTA = new LangStringVO[terminoYPadreDescTAVuelta.length];
					for (int i = 0; i<terminoYPadreDescTAVuelta.length; i++) {
						LangStringVO langDescTA = new LangStringVO();
						langDescTA.setTexto(langTextosDescripTA[i].getTexto().trim());
						langDescTA.setIdioma(terminoYPadreDescTAVuelta[i].getIdTermino());
						nuevolangTextosDescripTA[i] = langDescTA;
		            }
				} 
				else{
					nuevolangTextosDescripTA = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosDescripTA[0] = lang;
				}
				descripcionTA_VO.setTextos(nuevolangTextosDescripTA);
				aDescripcionesTA_VO[0]=descripcionTA_VO;
	            form.setTiempoApDescripcionAsArray(aDescripcionesTA_VO);   
	            
				
	            //EDAD TIPICA O RANGO DE EDAD
	            ArrayList lrangosEdad = new ArrayList();
				RangoEdadVO[] rangosEdadVO =null;
				RangoEdadVO[] nuevoRangosEdadVO =null;
				if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getRangoedades() !=null)
						&& (educaciones[iEdu].getRangoedades().length)> 0) {
					rangosEdadVO = educaciones[iEdu].getRangoedades();
					nuevoRangosEdadVO = new RangoEdadVO[rangosEdadVO.length];
					if(rangosEdadVO.length == 1 && rangosEdadVO[0].getTextos().length== 0){
						LangStringVO[] aLangString =new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						aLangString[0]=lang;
						nuevoRangosEdadVO[0].setTextos(aLangString);
					}
					else{
						for (int i = 0; i<rangosEdadVO.length; i++){
							LangStringVO[] langTextosRangos = rangosEdadVO[i].getTextos();
							ArrayList terminoYPadreRangos = new  ArrayList();
							if(langTextosRangos!=null && langTextosRangos.length>0){
								
								for(int j=0;j<langTextosRangos.length;j++){
									terminoypadreVO = new TerminoYPadreVO();
									terminoypadreVO.setIdiomaTermino("en");
									terminoypadreVO.setIdVocabulario("5.11");
									terminoypadreVO.setIdTermino("");
									if(langTextosRangos[j].getIdioma()!=null)
										terminoypadreVO.setNomTermino(langTextosRangos[j].getIdioma());
									else
										terminoypadreVO.setNomTermino("");
									terminoYPadreRangos.add(terminoypadreVO);							
								}
								
							}else{
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino("");
								terminoYPadreRangos.add(terminoypadreVO);
							}
							lrangosEdad.add(terminoYPadreRangos);
						}
	
						for (int i = 0; i<lrangosEdad.size();i++) {
							RangoEdadVO rangoVO= new RangoEdadVO();
							ArrayList terminoYPadreRango = (ArrayList) lrangosEdad.get(i);
							TerminoYPadreVO[] arrayTerminoYPadreRango=(TerminoYPadreVO[])terminoYPadreRango.toArray(new TerminoYPadreVO[terminoYPadreRango.size()]);
							TerminoYPadreVO[] terminoYPadreRangoVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreRango);
							LangStringVO[] langTextosRango = rangosEdadVO[i].getTextos();
							if(langTextosRango!=null && langTextosRango.length>0){
								LangStringVO[] nuevoLangTextosRango = new LangStringVO[langTextosRango.length];
								for (int j = 0; j<terminoYPadreRangoVuelta.length; j++) {
									LangStringVO nuevoLangRango = new LangStringVO();
									nuevoLangRango.setIdioma(terminoYPadreRangoVuelta[j].getIdTermino());
									if(langTextosRango!=null && langTextosRango.length>0){
										nuevoLangRango.setTexto(langTextosRango[j].getTexto().trim());
									}else
										nuevoLangRango.setTexto("");
									nuevoLangTextosRango[j] = nuevoLangRango;
								}
								rangoVO.setTextos(nuevoLangTextosRango);
								nuevoRangosEdadVO[i]=rangoVO;
							}else{
								langTextosRango=new LangStringVO[1];
								LangStringVO nuevoLangTextoRango=new LangStringVO();
								nuevoLangTextoRango.setIdioma("");
								nuevoLangTextoRango.setTexto("");
								langTextosRango[0]=nuevoLangTextoRango;
								rangoVO.setTextos(langTextosRango);
								nuevoRangosEdadVO[i]=rangoVO;
							}
						}	
					}
				}
				else{
					nuevoRangosEdadVO = new RangoEdadVO[1];
					LangStringVO[] aLangString =new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					aLangString[0]=lang;
					RangoEdadVO rangoVO= new RangoEdadVO();
					rangoVO.setTextos(aLangString);
					nuevoRangosEdadVO[0] = rangoVO;
				}
	
	            form.setEdadTipicaAsArray(nuevoRangosEdadVO);
	            
	            
	            
	            //DESCRIPCION
	            ArrayList lDescripciones = new ArrayList();
				DescripcionVO[] descripcionVO =null;
				DescripcionVO[] nuevoDescripcionVO =null;
				if ((educaciones[iEdu] != null)&&(educaciones[iEdu].getDescripciones() !=null)&& (educaciones[iEdu].getDescripciones().length)> 0) {
					descripcionVO = educaciones[iEdu].getDescripciones();
					nuevoDescripcionVO = new DescripcionVO[descripcionVO.length];
					if(descripcionVO.length == 1 && descripcionVO[0].getTextos().length== 0){
						LangStringVO[] aLangString =new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						aLangString[0]=lang;
						nuevoDescripcionVO[0].setTextos(aLangString);
					}
					else{
						for (int i = 0; i<descripcionVO.length; i++){
							LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
							ArrayList terminoYPadreDescripcion = new  ArrayList();
							if(langTextosDesc!=null && langTextosDesc.length>0){
								for(int j=0;j<langTextosDesc.length;j++){
									terminoypadreVO = new TerminoYPadreVO();
									terminoypadreVO.setIdiomaTermino("en");
									terminoypadreVO.setIdVocabulario("5.11");
									terminoypadreVO.setIdTermino("");
									if(langTextosDesc[j].getIdioma()!=null)
										terminoypadreVO.setNomTermino(langTextosDesc[j].getIdioma());
									else
										terminoypadreVO.setNomTermino("");
									terminoYPadreDescripcion.add(terminoypadreVO);							
								}
							}else{
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino("");
								terminoYPadreDescripcion.add(terminoypadreVO);
							}
							lDescripciones.add(terminoYPadreDescripcion);
						}
	
						for (int i = 0; i<lDescripciones.size();i++) {
							DescripcionVO descVO= new DescripcionVO();
							ArrayList terminoYPadreDesc = (ArrayList) lDescripciones.get(i);
							TerminoYPadreVO[] arrayTerminoYPadreDescripcion=(TerminoYPadreVO[])terminoYPadreDesc.toArray(new TerminoYPadreVO[terminoYPadreDesc.size()]);
							TerminoYPadreVO[] terminoYPadreDescripcionVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDescripcion);
							LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
							if(langTextosDesc!= null && langTextosDesc.length>0){
								LangStringVO[] nuevoLangTextosDesc = new LangStringVO[langTextosDesc.length];
								for (int j = 0; j<terminoYPadreDescripcionVuelta.length; j++) {
									LangStringVO nuevoLangDesc = new LangStringVO();
									nuevoLangDesc.setIdioma(terminoYPadreDescripcionVuelta[j].getIdTermino());
									nuevoLangDesc.setTexto(langTextosDesc[j].getTexto().trim());
									nuevoLangTextosDesc[j] = nuevoLangDesc;
									descVO.setTextos(nuevoLangTextosDesc);
								}
							}else{
								LangStringVO[] nuevoLangTextosDesc = new LangStringVO[1];
								LangStringVO nuevoLangDesc = new LangStringVO();
								nuevoLangDesc.setIdioma("");
								nuevoLangDesc.setTexto("");
								nuevoLangTextosDesc[0] = nuevoLangDesc;
								descVO.setTextos(nuevoLangTextosDesc);
							}
							
							nuevoDescripcionVO[i]=descVO;
						}	
					}
				}
				else{
					nuevoDescripcionVO = new DescripcionVO[1];
					LangStringVO[] aLangString =new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					aLangString[0]=lang;
					DescripcionVO descVO= new DescripcionVO();
					descVO.setTextos(aLangString);
					nuevoDescripcionVO[0] = descVO;
				}
	
	            form.setDescripcionesAsArray(nuevoDescripcionVO);
	            
	            //si educational[i] era null en el objeto de session lo dejamos a null
	            if(educacionEsNull)
	            	catalogadorAvSession.getMDSesion().getEducational()[iEdu]=null;
			
			}
			else{
				// Caso CREAR
				
				//posicion en la que vamos a guardar la educacion
				titulo ="1";
				if(educaciones == null || educaciones.length == 0){//si no hay educaciones lo guardamos en la primera
					iEdu = 0;
					form.setTituloUsoEducativo(titulo); //el numero que se muestra junto con Uso educativo		
				}
				else{//si ya habia alguna la guardamos en al final habra que añadirle una posición al array de educaciones
					iEdu = educaciones.length;
					titulo = String.valueOf(educaciones.length + 1);
					form.setTituloUsoEducativo(titulo); //el numero	
					}

				//IDIOMAS
				IdiomaVO[] aNuevoIdiomasVO = new IdiomaVO[1];
				IdiomaVO idioma = new IdiomaVO();
				idioma.setTexto("");
				aNuevoIdiomasVO[0]=idioma;
				form.setIdiomasAsArray(aNuevoIdiomasVO);
				//TIPOS RECURSOS
				SourceValueVO[] aNuevoTiposRecursoVO = new SourceValueVO[1];
				SourceValueVO tipoRecurso = new SourceValueVO();
				tipoRecurso.setSource("");
				tipoRecurso.setValor("");
				aNuevoTiposRecursoVO[0]=tipoRecurso;
				form.setTipoRecursoAsArray(aNuevoTiposRecursoVO);
				//ROL O DESTINATARIOS
				SourceValueVO[] aNuevoDestinatariosVO = new SourceValueVO[1];
				SourceValueVO destinatario = new SourceValueVO();
				destinatario.setSource("");
				destinatario.setValor("");
				aNuevoDestinatariosVO[0]=destinatario;
				form.setRolUsuarioAsArray(aNuevoDestinatariosVO);
				//CONTEXTOS
				SourceValueVO[] aNuevoContextosVO = new SourceValueVO[1];
				SourceValueVO contexto = new SourceValueVO();
				contexto.setSource("");
				contexto.setValor("");
				aNuevoContextosVO[0]=contexto;
				form.setContextoAsArray(aNuevoContextosVO);
				//PROCESOS COGNITIVOS
				SourceValueVO[] aNuevoProcesosVO = new SourceValueVO[1];
				SourceValueVO proceso = new SourceValueVO();
				proceso.setSource("");
				proceso.setValor("");
				aNuevoProcesosVO[0]=proceso;
				form.setProcesoCognitivoAsArray(aNuevoProcesosVO);
				//TIPO INTERACTIVIDAD
				form.setTipoInteractividad("");
				//NIVEL INTERACTIVIDAD
				form.setNivelInteractividad("");
				//DENSIDAD SEMANTICA
				form.setDensidadSemantica("");
				//DIFICULTAD
				form.setDificultad("");
				//TIEMPO APRENDIZAJE
				form.setAnyo("");
				form.setMes("");
				form.setDia("");
				form.setHora("");
				form.setMinutos("");
				form.setSegundoP1("");
				form.setSegundoP2("");
				//DESCRIPCION TIEMPO APRENDIZAJE
				DescripcionVO descripcionTA_VO = new DescripcionVO();
				DescripcionVO[] aDescripcionesTA_VO = new DescripcionVO[1];
				LangStringVO[] nuevolangTextosDescripTA = new LangStringVO[1];
				LangStringVO langTA = new LangStringVO();
				langTA.setIdioma("");
				langTA.setTexto("");
				nuevolangTextosDescripTA[0] = langTA;
				descripcionTA_VO.setTextos(nuevolangTextosDescripTA);
				aDescripcionesTA_VO[0]=descripcionTA_VO;
				form.setTiempoApDescripcionAsArray(aDescripcionesTA_VO); 
				//EDAD TIPICA O RANGO DE EDAD
				RangoEdadVO[] nuevoRangosEdadVO = new RangoEdadVO[1];
				LangStringVO[] aLangString =new LangStringVO[1];
				LangStringVO lang = new LangStringVO();
				lang.setIdioma("");
				lang.setTexto("");
				aLangString[0]=lang;
				RangoEdadVO rangoVO= new RangoEdadVO();
				rangoVO.setTextos(aLangString);
				nuevoRangosEdadVO[0] = rangoVO;
				form.setEdadTipicaAsArray(nuevoRangosEdadVO);
				//DESCRIPCION
				DescripcionVO[] nuevoDescripcionVO = new DescripcionVO[1];
				LangStringVO[] aLangStringD =new LangStringVO[1];
				LangStringVO langD = new LangStringVO();
				langD.setIdioma("");
				langD.setTexto("");
				aLangStringD[0]=langD;
				DescripcionVO descVO= new DescripcionVO();
				descVO.setTextos(aLangStringD);
				nuevoDescripcionVO[0] = descVO;
				form.setDescripcionesAsArray(nuevoDescripcionVO);
			}
	            

	            
        }catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarDetalleUsoEducativo " + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
		
	
     }




	public void cargarUsosEducativos(
			ActionMapping mapping, 
			CargarUsosEducativosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
	  try{
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		//Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
		//evitamos así cualquier tipo de error
		 String identificador =request.getParameter("identificador");
	     if(identificador==null){
	        identificador=catalogadorAvSession.getIdentificador();
	     }
	     if (identificador == null) {
			//lanzamos la excepcion para que no de errores en la llamada al servicio
			throw new Exception();
		}
	     
    	if (catalogadorAvSession.getMDSesion()!=null) {
    		AvEducationalVO[] educaciones =catalogadorAvSession.getMDSesion().getEducational();
    		
    		form.setListadoUsosEduAsArray(educaciones);
    		form.setIdentificadorOde(catalogadorAvSession.getIdentificador());
    		
    	}
    
	  }catch (org.acegisecurity.AccessDeniedException ad) {
  		throw new java.lang.Exception("catalogador.avanzado", ad);
	  }catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarUsosEducativo " + e);
			throw new java.lang.Exception("ver.metadatos", e);
	  }
		
	}



	public void cargarDatosDerechos(
			ActionMapping mapping, 
			CargarDatosDerechosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		InputStream is = null;
    	Properties prop = new Properties();
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

			
//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}

			//comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			}	
			//comprobamos que general no se ha null, si es null nos creamos uno	
			boolean derechosEsNull = false;
			if (catalogadorAvSession.getMDSesion().getDerechos() == null){
				AvRightsVO derechos = new AvRightsVO();
				catalogadorAvSession.getMDSesion().setDerechos(derechos);	
				derechosEsNull=true;
			}

				
				
				
			String[] l_id = { prop.getProperty("coste"),prop.getProperty("copyrightAndOtherRestrictions"),prop.getProperty("accessType"),prop.getProperty("idiomaDestinatario")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);

			longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
			TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
			ArrayList terminoypadrear=new ArrayList();
			
			
			Collection idDest = new ArrayList();
			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {
				case 0:
					
					Collection tCoste = new ArrayList();
					tCoste.add(terminoVO);
					Collection tCoste2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont = tCoste2.iterator();
					while (cont.hasNext()) {
						tCoste.add(cont.next());
					}
					form.setCosteBackingList(tCoste, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getCoste() !=null) &&(catalogadorAvSession.getMDSesion().getDerechos().getCoste().getValor()!=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getCoste().getValor());//terminoYPadre rellenado con coste desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con coste desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 1:
					Collection tCopyright= new ArrayList();
					tCopyright.add(terminoVO);
					Collection tCopyright2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont1 = tCopyright2.iterator();
					while (cont1.hasNext()) {
						tCopyright.add(cont1.next());
					}
					form.setCopyRestriccionesBackingList(tCopyright, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor() !=null) && (catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor().getValor()!=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor().getValor());//terminoYPadre rellenado con derechos de autor desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con derechos de autor desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 2:
					Collection tTipoDeAcceso = new ArrayList();
					tTipoDeAcceso.add(terminoVO);
					Collection tTipoDeAcceso2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					Iterator cont2 = tTipoDeAcceso2.iterator();
					while (cont2.hasNext()) {
						tTipoDeAcceso.add(cont2.next());
					}
					form.setTipoAccesoBackingList(tTipoDeAcceso, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso() !=null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo() !=null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor()!=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor());//terminoYPadre rellenado con tipo de acceso desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con tipo de acceso desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 3:
					idDest.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosDest.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosDest[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = terminosOrdDest1.ordenarTerminosVO(terminosDest, idiomaLdap);						
					Collection idDest2 = Arrays.asList(terminosOrdDest);
					
					Iterator zDest = idDest2.iterator();
					while (zDest.hasNext()) {
						idDest.add(zDest.next());
					}
					form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					
					break;
				}
				
				

			}

			if( logger.isDebugEnabled() ){

                logger.debug("Cargados los combos del formulario" );
			}
			System.out.println("Cargados los combos");
			
				
			TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);

			TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);

			//COSTE
			String idi = terminoYPadreVuelta[0].getIdTermino();
				
			if (idi == null) {
				idi = "";//No hay ningún tipo se recurso seleccionado por defecto
			}
				
			form.setCoste(idi);
			
			//COPY Y RESTRICCIONES
			idi = terminoYPadreVuelta[1].getIdTermino();
				
			if (idi == null) {
				idi = "";//No hay ningún contexto seleccionado por defecto
			}
				
			form.setCopyRestricciones(idi);

			//TIPO ACCESO
			idi = terminoYPadreVuelta[2].getIdTermino();
				
			if (idi == null) {
				idi = "";//No hay ningún contexto seleccionado por defecto
			}
				
			form.setTipoAcceso(idi);
    

			if( logger.isDebugEnabled() ){

                logger.debug("Cargados en el formulario los idiomas, la estructura y el nivel de agregacion" );
			}	
						
			//DESCRIPCIONES
			ArrayList terminoYPadreDescrip = new  ArrayList();
			LangStringVO[] langTextosDescrip = null;
			LangStringVO[] nuevolangTextosDescrip =null;
			DescripcionVO[] aDescripcionesVO = new DescripcionVO[1];
			DescripcionVO descripcionVO= new DescripcionVO();
			if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getDescripcion() !=null)&& (catalogadorAvSession.getMDSesion().getDerechos().getDescripcion().getTextos().length)> 0) {
				langTextosDescrip =catalogadorAvSession.getMDSesion().getDerechos().getDescripcion().getTextos();
				for(int j=0;j<langTextosDescrip.length;j++){
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario("5.11");
					terminoypadreVO.setIdTermino("");
					if(langTextosDescrip[j].getIdioma()!=null)
						terminoypadreVO.setNomTermino(langTextosDescrip[j].getIdioma());
					else
						terminoypadreVO.setNomTermino("");
					terminoYPadreDescrip.add(terminoypadreVO);
				}
				
				TerminoYPadreVO[] arrayTerminoYPadreDesc=(TerminoYPadreVO[])terminoYPadreDescrip.toArray(new TerminoYPadreVO[terminoYPadreDescrip.size()]);
				TerminoYPadreVO[] terminoYPadreDescVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDesc);
				
				nuevolangTextosDescrip = new LangStringVO[terminoYPadreDescVuelta.length];
				for (int i = 0; i<terminoYPadreDescVuelta.length; i++) {
					LangStringVO langDesc = new LangStringVO();
					langDesc.setTexto(langTextosDescrip[i].getTexto().trim());
					langDesc.setIdioma(terminoYPadreDescVuelta[i].getIdTermino());
					nuevolangTextosDescrip[i] = langDesc;
	            }
			} 
			else{
				nuevolangTextosDescrip = new LangStringVO[1];
				LangStringVO lang = new LangStringVO();
				lang.setIdioma("");
				lang.setTexto("");
				nuevolangTextosDescrip[0] = lang;
			}
			descripcionVO.setTextos(nuevolangTextosDescrip);
			aDescripcionesVO[0]=descripcionVO;
            form.setDescripcionesAsArray(aDescripcionesVO);       
            
            // checkbox
            //Para ver lo que tenemos que marcar, miramos el combo tipo de Acceso, si es universal, marcamos todas(Mec), sino tenemos que leer del 
            //dependenceServer.properties las ccaas separadas por ,
            String tipoAcceso=form.getTipoAcceso();
            
            
            

			ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			List nodos= new ArrayList();

			NodoVO n= new NodoVO();
			n.setNodo(datosResources.getString("catalogadorAvanzado.Derechos.SoloAmbitoAcceso.Todas"));
			n.setIdNodo("MEC");
			nodos.add(n);

			try{

				if(!DecisorOffline.esOffline())
				{
					NodoVO nLocal= new NodoVO();
					nLocal.setNodo(datosResources.getString("catalogadorAvanzado.Derechos.SoloAmbitoAcceso.Local"));
					nLocal.setIdNodo(DependentServerProperties.getInstance().getProperty("server.id"));
					nodos.add(nLocal);
					
					SrvNodoService nodo = this.getSrvNodoService();
					NodoVO[] listaNodos = nodo.listarNodos();

					if(listaNodos.length > 0){
						for(int i=0; i<listaNodos.length;i++){
							nodos.add(listaNodos[i]);
						}
					}
				}
			}catch(Exception ex){
				logger.error("DerechosControllerImpl - cargaDatos ERROR: Error obteniendo nodos :",ex);
			}
			form.setListadoNodos(nodos);

            
            //comprobar cual viene
            List comSel= new ArrayList();
            String ccaa="";
        	if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&
        			(catalogadorAvSession.getMDSesion().getDerechos().getAcceso() !=null)&&
        			(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getDescripcion()!=null)) {
        		
        		LangStringVO[] textosAcceso =catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getDescripcion().getTextos();
        		//este array puede contener muchas descripciones, nos quedaremos con la primera
        		if ((textosAcceso!=null) && (textosAcceso.length>0)) 
        			ccaa=textosAcceso[0].getTexto();//No existen restricciones, para, esto,AN, porque,AR, esto, no,IC
        		if(ccaa.equals("") && catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor().equalsIgnoreCase("universal") )
        			ccaa="MEC";
        	}
        	if ((ccaa!=null) && (!ccaa.equals(""))) {
        		String[] lisAux = ccaa.split(",");
        		int l=0;
        		boolean ok= false;
        		while ((l<lisAux.length) && (!ok)) {
        			
        			if(!lisAux[l].equals("MEC"))
        			{
        				comSel.add(lisAux[l]);
        			}else
        			{
        				ok=true;
        			}
        			
        			l++;
        		}
        		if (ok==true) {
        			comSel= new ArrayList();
        			List todosNodos=form.getListadoNodos();
                	for(int i=0;i<todosNodos.size();i++){
                		NodoVO nodo=(NodoVO)todosNodos.get(i);
                		String nombreNodo=nodo.getIdNodo();
                		comSel.add(nombreNodo);
                	}
        		}
        	}

            form.setListadoComunidades((String[]) comSel.toArray( new String[comSel.size()]));
            
//			try{
//				SrvNodoService nodo = this.getSrvNodoService();
//				NodoVO[] listaNodos = nodo.listarNodos();
//
//				ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
//
//				List nodos= new ArrayList();
//				if(listaNodos.length > 0){
//					NodoVO n= new NodoVO();
//					n.setNodo(datosResources.getString("catalogadorAvanzado.Derechos.SoloAmbitoAcceso.Todas"));
//					n.setIdNodo("MEC");
//					nodos.add(n);
//
//					NodoVO nLocal= new NodoVO();
//					nLocal.setNodo(datosResources.getString("catalogadorAvanzado.Derechos.SoloAmbitoAcceso.Local"));
//					nLocal.setIdNodo(DependentServerProperties.getInstance().getProperty("server.id"));
//					nodos.add(nLocal);
//					for(int i=0; i<listaNodos.length;i++){
//						nodos.add(listaNodos[i]);
//					}
//					
//				}
//				form.setListadoNodos(nodos);
//				
//			}catch(Exception ex){
//				form.setListadoNodos(new ArrayList());
//				logger.error("DerechosControllerImpl - cargaDatos ERROR: Error obteniendo nodos :",ex);
//			}
//
//
//            //comprobar cual viene
//            List comSel= new ArrayList();
//            if (tipoAcceso.equals("")) {
//            } else if (tipoAcceso.equals(prop.getProperty("acceso.universal"))) {//universal poner en un property???6.4.1.1
//            	//marco el cero -->todas
//            	//comSel.add("MEC");
//            	List todosNodos=form.getListadoNodos();
//            	for(int i=0;i<todosNodos.size();i++){
//            		NodoVO nodo=(NodoVO)todosNodos.get(i);
//            		String nombreNodo=nodo.getIdNodo();
//            		comSel.add(nombreNodo);
//            	}
//            }else {//leemos la descripcion de tipo de acceso
//            	String ccaa="";
//            	if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&
//            			(catalogadorAvSession.getMDSesion().getDerechos().getAcceso() !=null)&&
//            			(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getDescripcion()!=null)) {
//            		
//            		LangStringVO[] textosAcceso =catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getDescripcion().getTextos();
//            		//este array puede contener muchas descripciones, nos quedaremos con la primera
//            		if ((textosAcceso!=null) && (textosAcceso.length>0)) 
//            			ccaa=textosAcceso[0].getTexto();//No existen restricciones, para, esto,AN, porque,AR, esto, no,IC
//            	}
//            	if ((ccaa!=null) && (!ccaa.equals(""))) {
//            		String[] lisAux = ccaa.split(",");
//            		int l=0;
//            		boolean ok= false;
//            		while ((l<lisAux.length) && (!ok)) {
//            			
//            			if(!lisAux[l].equals("MEC"))
//            			{
//            				comSel.add(lisAux[l]);
//            			}else
//            			{
//            				ok=true;
//            			}
//            			
//            			l++;
//            		}
//            		if (ok==true) {
//            			comSel= new ArrayList();
//            			List todosNodos=form.getListadoNodos();
//                    	for(int i=0;i<todosNodos.size();i++){
//                    		NodoVO nodo=(NodoVO)todosNodos.get(i);
//                    		String nombreNodo=nodo.getIdNodo();
//                    		comSel.add(nombreNodo);
//                    	}
//            		}
//            	}
//            }
//            form.setListadoComunidades((String[]) comSel.toArray( new String[comSel.size()]));
            
            //si derechos era null en el objeto de session lo dejamos a null
            if(derechosEsNull)
            	catalogadorAvSession.getMDSesion().setDerechos(null);
            
        }catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarDerechos" + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
		
		
	}




	public void cargarDetalleRelacion(
			ActionMapping mapping, 
			CargarDetalleRelacionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
    	InputStream is = null;
    	Properties prop = new Properties();
    	catalogo="";
    	entrada="";
    	
    	
    	try {
    		
    		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			
//			comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			} 
			
			String botonPulsado = request.getParameter("botonPulsado");
			form.setBotonPulsado(botonPulsado); //actualizamos si es modificar o crear
			String titulo = request.getParameter("titulo");
			form.setTituloRelacion(titulo); //el numero
			//Rellenamos combos
			is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador_ode =request.getParameter("identificador");
		     if(identificador_ode==null){
		        identificador_ode=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador_ode == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
			
			String[] l_id = {prop.getProperty("kind"), prop.getProperty("idiomaDestinatario")}; //es el idioma pero sin "ninguno"
			VocabularioVO[] vocaCombos = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocaCombos);			

			int longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
			
			
			Collection idTipo = new ArrayList();
			Collection idDest=new ArrayList();
			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {

				case 0:
					
					idTipo.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosTipo = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosTipo.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosTipo[li];
						idAux.setNomTermino(terminosTipo[li].getNomTermino());
					}
					UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdTipo = terminosOrdDest1.ordenarTerminosVO(terminosTipo, idiomaLdap);					
					Collection idTipo2 = Arrays.asList(terminosOrdTipo);
					
					Iterator zTipo = idTipo2.iterator();
					while (zTipo.hasNext()) {
						idTipo.add(zTipo.next());
					}
					form.setTipoBackingList(idTipo, "idTermino", "nomTermino");
					
					break;
				
				case 1:
					idDest.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosDest.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosDest[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrdDest2 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = terminosOrdDest2.ordenarTerminosVO(terminosDest, idiomaLdap);					
					Collection idDest2 = Arrays.asList(terminosOrdDest);
					
					Iterator zDest = idDest2.iterator();
					while (zDest.hasNext()) {
						idDest.add(zDest.next());
					}
					form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					
					break;
				}
				
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

			}
			System.out.println("Cargados los combos");
			
			//String idiomaLocale=((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage();
			//ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			
			//Caso Modificacion
			String botonModificar=prop.getProperty("botonModificar")!=null?prop.getProperty("botonModificar"):"";
			 AvRelationVO[] relaciones =catalogadorAvSession.getMDSesion().getRelaciones();
			 if (botonModificar.equals(botonPulsado)) { //Modificacion
				 TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
				 ArrayList terminoypadrear=new ArrayList();
				 iRel = Integer.parseInt(request.getParameter("titulo")) - 1;
				 //comprobamos que relation no se ha null, si es null nos creamos uno	
				 boolean relacionEsNull = false;
					if (relaciones[iRel] == null){
						AvRelationVO relation = new AvRelationVO();
						relaciones[iRel] = relation;
						relacionEsNull=true;
					}
				 
				
					for (int x = 0; x < longVocabulario; x++) {
						TerminoVO terminoVO = new TerminoVO();
						terminoVO.setIdiomaTermino("");
						terminoVO.setIdTermino("");
						terminoVO.setNomTermino("");
					
						switch (x) {
							case 0://KIND
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario(l_id[x]);
								terminoypadreVO.setIdTermino("");
								if ((relaciones[iRel] != null)&&(relaciones[iRel].getTipo() !=null) && (relaciones[iRel].getTipo().getValor()!=null)) {
									terminoypadreVO.setNomTermino(relaciones[iRel].getTipo().getValor());
									terminoypadrear.add(terminoypadreVO);
								} else {
									terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con estructura desde el formulario
									terminoypadrear.add(terminoypadreVO);
								}
								
								break;
						}
					}
					TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);
					TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
//					TIPO 
					String idTI = terminoYPadreVuelta[0].getIdTermino();	
					if (idTI == null) {
						idTI = "";//No hay ningún tipo se recurso seleccionado por defecto
					}
					form.setTipo(idTI);
					
//					RECURSO
		            ArrayList lDescripciones = new ArrayList();
					DescripcionVO[] descripcionVO =null;
					DescripcionVO[] nuevoDescripcionVO =null;
					if (relaciones.length>0 && (relaciones[iRel] != null)&&(relaciones[iRel].getRecurso() !=null) ) {
						IdentificadorVO identificador=relaciones[iRel].getRecurso().getIdentificador();
						if(identificador==null)
						{
							catalogo="";
							entrada="";
						}else
						{
							catalogo=identificador.getCatalogo();
							entrada=identificador.getEntrada();
						}
						form.setCatalogo(catalogo);
						form.setEntrada(entrada);
						if(relaciones[iRel].getRecurso().getDescripciones()!=null &&relaciones[iRel].getRecurso().getDescripciones().length>0){
							descripcionVO = relaciones[iRel].getRecurso().getDescripciones();
							nuevoDescripcionVO = new DescripcionVO[descripcionVO.length];
							if(descripcionVO.length == 1 && descripcionVO[0].getTextos().length== 0){
								LangStringVO[] aLangString =new LangStringVO[1];
								LangStringVO lang = new LangStringVO();
								lang.setIdioma("");
								lang.setTexto("");
								aLangString[0]=lang;
								nuevoDescripcionVO = new DescripcionVO[1];
								DescripcionVO nuevo=new DescripcionVO();
								nuevo.setTextos(aLangString);
								nuevoDescripcionVO[0]=nuevo;
							}
							else{
								for (int i = 0; i<descripcionVO.length; i++){
									LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
									ArrayList terminoYPadreDescripcion = new  ArrayList();
									if(langTextosDesc!=null && langTextosDesc.length>0){
										
										for(int j=0;j<langTextosDesc.length;j++){
											terminoypadreVO = new TerminoYPadreVO();
											terminoypadreVO.setIdiomaTermino("en");
											terminoypadreVO.setIdVocabulario("5.11");
											terminoypadreVO.setIdTermino("");
											if(langTextosDesc[j].getIdioma()!=null)
												terminoypadreVO.setNomTermino(langTextosDesc[j].getIdioma());
											else
												terminoypadreVO.setNomTermino("");
											terminoYPadreDescripcion.add(terminoypadreVO);							
										}
									}else{
										terminoypadreVO = new TerminoYPadreVO();
										terminoypadreVO.setIdiomaTermino("en");
										terminoypadreVO.setIdVocabulario("5.11");
										terminoypadreVO.setIdTermino("");
										terminoypadreVO.setNomTermino("");
										terminoYPadreDescripcion.add(terminoypadreVO);
									}
									lDescripciones.add(terminoYPadreDescripcion);
								}
			
								for (int i = 0; i<lDescripciones.size();i++) {
									DescripcionVO descVO= new DescripcionVO();
									ArrayList terminoYPadreDesc = (ArrayList) lDescripciones.get(i);
									TerminoYPadreVO[] arrayTerminoYPadreDescripcion=(TerminoYPadreVO[])terminoYPadreDesc.toArray(new TerminoYPadreVO[terminoYPadreDesc.size()]);
									TerminoYPadreVO[] terminoYPadreDescripcionVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDescripcion);
									LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
									LangStringVO[] nuevoLangTextosDesc = new LangStringVO[langTextosDesc.length];
									if(langTextosDesc!=null && langTextosDesc.length>0){
										for (int j = 0; j<terminoYPadreDescripcionVuelta.length; j++) {
											LangStringVO nuevoLangDesc = new LangStringVO();
											nuevoLangDesc.setIdioma(terminoYPadreDescripcionVuelta[j].getIdTermino());
											nuevoLangDesc.setTexto(langTextosDesc[j].getTexto().trim());
											nuevoLangTextosDesc[j] = nuevoLangDesc;
										}
										descVO.setTextos(nuevoLangTextosDesc);
									}else{
										nuevoLangTextosDesc=new LangStringVO[1];
										LangStringVO nuevoLangDesc = new LangStringVO();
										nuevoLangDesc.setIdioma("");
										nuevoLangDesc.setTexto("");
										nuevoLangTextosDesc[0] = nuevoLangDesc;
										descVO.setTextos(nuevoLangTextosDesc);
									}
									nuevoDescripcionVO[i]=descVO;
								}	
							}
						}
						else{
							nuevoDescripcionVO = new DescripcionVO[1];
							LangStringVO[] aLangString =new LangStringVO[1];
							LangStringVO lang = new LangStringVO();
							lang.setIdioma("");
							lang.setTexto("");
							aLangString[0]=lang;
							DescripcionVO descVO= new DescripcionVO();
							descVO.setTextos(aLangString);
							nuevoDescripcionVO[0] = descVO;
						}
			
			            form.setDescripcionAsArray(nuevoDescripcionVO);
					}else{
						//RECURSO
						
						form.setCatalogo("");
						form.setEntrada("");
						//DESCRIPCION
						nuevoDescripcionVO = new DescripcionVO[1];
						LangStringVO[] aLangStringD =new LangStringVO[1];
						LangStringVO langD = new LangStringVO();
						langD.setIdioma("");
						langD.setTexto("");
						aLangStringD[0]=langD;
						DescripcionVO descVO= new DescripcionVO();
						descVO.setTextos(aLangStringD);
						nuevoDescripcionVO[0] = descVO;
						form.setDescripcionAsArray(nuevoDescripcionVO);

						
					}
//					si relacion[i] era null en el objeto de session lo dejamos a null
		            if(relacionEsNull)
		            {
		            	catalogadorAvSession.getMDSesion().getRelaciones()[iRel]=null;
		            }
			 }else{
					// Caso CREAR
					
					//posicion en la que vamos a guardar la relacion
				 
				 titulo ="1";
				 if(relaciones == null || relaciones.length == 0){//si no hay relaciones lo guardamos en la primera
						iRel = 0;
						form.setTituloRelacion(titulo); //el numero que se muestra junto con Relacion
					}
					else{//si ya habia alguna la guardamos en al final habra que añadirle una posición al array de relaciones
						iRel = relaciones.length;
						titulo = String.valueOf(relaciones.length + 1);
						form.setTituloRelacion(titulo); //el numero	
					}
				 
//				TIPO
					form.setTipo("");
					
				//RECURSO
					
					form.setCatalogo("");
					form.setEntrada("");
					//DESCRIPCION
					DescripcionVO[] nuevoDescripcionVO = new DescripcionVO[1];
					LangStringVO[] aLangStringD =new LangStringVO[1];
					LangStringVO langD = new LangStringVO();
					langD.setIdioma("");
					langD.setTexto("");
					aLangStringD[0]=langD;
					DescripcionVO descVO= new DescripcionVO();
					descVO.setTextos(aLangStringD);
					nuevoDescripcionVO[0] = descVO;
					form.setDescripcionAsArray(nuevoDescripcionVO);
					
			 }
			 
			
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.avanzado", ad);
		}catch (Exception e){
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarRelaciones" + e);
			throw new java.lang.Exception("ver.metadatos", e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }	 
   	 
     }


	public void cargarRelaciones(
			ActionMapping mapping, 
			CargarRelacionesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
	  
      try{
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	
//		Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
		//evitamos así cualquier tipo de error
		 String identificador =request.getParameter("identificador");
	     if(identificador==null){
	        identificador=catalogadorAvSession.getIdentificador();
	     }
	     if (identificador == null) {
			//lanzamos la excepcion para que no de errores en la llamada al servicio
			throw new Exception();
		}
    	if (catalogadorAvSession.getMDSesion()!=null) {
    		AvRelationVO[] relaciones =catalogadorAvSession.getMDSesion().getRelaciones();
    		
    		form.setListadoRelacionesAsArray(relaciones);
    		form.setIdentificadorOde(catalogadorAvSession.getIdentificador());
    	}
     
      }catch (org.acegisecurity.AccessDeniedException ad) {
  		  throw new java.lang.Exception("catalogador.avanzado", ad);
      }catch (Exception e){
		logger
		.error("Error en Servicio de catalogacion avanzado, metodo cargarRelaciones" + e);
		throw new java.lang.Exception("ver.metadatos", e);
      }
		
   }



	public void cargarAnotaciones(
			ActionMapping mapping, 
			CargarAnotacionesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
      try{
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
//		Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
		//evitamos así cualquier tipo de error
		 String identificador =request.getParameter("identificador");
	     if(identificador==null){
	        identificador=catalogadorAvSession.getIdentificador();
	     }
	     if (identificador == null) {
			//lanzamos la excepcion para que no de errores en la llamada al servicio
			throw new Exception();
		}
    	if (catalogadorAvSession.getMDSesion()!=null) {
    		AvAnnotationVO[] anotaciones =catalogadorAvSession.getMDSesion().getAnotaciones();
    		
    		form.setListadoAnotacionesAsArray(anotaciones);
    		form.setIdentificadorOde(catalogadorAvSession.getIdentificador());
    	}
		
      }catch (org.acegisecurity.AccessDeniedException ad) {
  			throw new java.lang.Exception("catalogador.avanzado", ad);
	  }catch (Exception e){
		    logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarAnotaciones" + e);
			throw new java.lang.Exception("ver.metadatos", e);
	 }
   }



	public void cargarClasificaciones(
			ActionMapping mapping, 
			CargarClasificacionesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
    	try{
    		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
//    		Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
//    		evitamos así cualquier tipo de error
    		 String identificador =request.getParameter("identificador");
    	     if(identificador==null){
    	        identificador=catalogadorAvSession.getIdentificador();
    	     }
    	     if (identificador == null) {
    			//lanzamos la excepcion para que no de errores en la llamada al servicio
    			throw new Exception();
    		}

    		if ((catalogadorAvSession!=null) && (catalogadorAvSession.getMDSesion()!=null)) {
	    		AvClassificationVO[] clasificaciones = catalogadorAvSession.getMDSesion().getClasificaciones();
	    		form.setListadoClasificacionesAsArray(clasificaciones);
	        	String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

	        	if(clasificaciones!=null){
	    			String[] listaProposito=new String[clasificaciones.length];
	    			String[] lista=new String[clasificaciones.length];
		    		for(int i=0;i< clasificaciones.length;i++){
		    			SourceValueVO sourcePro=clasificaciones[i].getProposito();
		    			if(sourcePro!=null && !sourcePro.equals("")){
			    			String propoIngles=sourcePro.getValor();
			    			if(propoIngles!=null && !propoIngles.equals("")){
			    				lista[i]=propoIngles;
			    			}else{
			    				lista[i]="";
			    			}
		    			}else
		    				lista[i]="";
		    			
		    		}
		    		TerminoYPadreVO[] terminoypadre=new TerminoYPadreVO[clasificaciones.length];
		    		for(int k=0;k<terminoypadre.length;k++){
		    			TerminoYPadreVO termino=new TerminoYPadreVO();
		    			termino.setNomTermino(lista[k]);
		    			termino.setIdVocabulario("9.1");
		    			termino.setIdiomaTermino("en");
		    			termino.setIdTermino("");
		    			terminoypadre[k]=termino;
		    		}
		    		TerminoYPadreVO[] listaIds=this.getSrvVocabulariosControladosService().obtenerIdTermino(terminoypadre);
		    		String[] isd=new String[clasificaciones.length];
		    		for(int l=0;l<clasificaciones.length;l++){
		    			if(listaIds[l].getIdTermino()!=null){
		    				isd[l]=listaIds[l].getIdTermino();
		    			}
		    			else{
		    				isd[l]="";
		    			}
		    			
		    		}
		    		int i=0;
		    		TerminoVO[] traduccion = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(isd, idiomaLdap);
		    		for(int j=0;j<clasificaciones.length;j++){
		    			if(!isd[j].equals("")){
			    			String propoTrad=traduccion[j-i].getNomTermino();
			    			if(propoTrad!=null && !propoTrad.equals("")){
			    				listaProposito[j]=propoTrad;
			    			}
		    			}else{
		    				listaProposito[j]="";
		    				i=i+1;
		    			}
		    		}
		    		catalogadorAvSession.setListaProposito(listaProposito);
	    		}
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("VerMetadatos:clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error categoria clasificacion, método cargarClasificacion " + e);
			throw new java.lang.Exception("VerMetadatos:clasificacion", e);
		}
    }




	public void cargarDetalleAnotacion(
			ActionMapping mapping, 
			CargarDetalleAnotacionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		 InputStream is = null;
		 Properties prop = new Properties();
		 String nombre="";
		 String organizacion="";
		 String email="";
		 String fechaCorta="";
		 String hora="";
		 String minutos="";
		 String segP1="";
		 String segP2="";
		 try {
			String botonPulsado = request.getParameter("botonPulsado");
			form.setBotonPulsado(botonPulsado); //actualizamos si es modificar o crear
			String titulo = request.getParameter("titulo");
			form.setTituloAnotacion(titulo); //el numero
			
			CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			//Rellenamos combos
			is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			
//			Para controlar si ha expirado la sesion controlamos si el identificador esta en la request o sesion
			//evitamos así cualquier tipo de error
			 String identificador =request.getParameter("identificador");
		     if(identificador==null){
		        identificador=catalogadorAvSession.getIdentificador();
		     }
		     if (identificador == null) {
				//lanzamos la excepcion para que no de errores en la llamada al servicio
				throw new Exception();
			}
			
			String[] l_id = { prop.getProperty("idiomaDestinatario")}; //es el idioma pero sin "ninguno"
			VocabularioVO[] vocaCombos = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			/////////////////combo idioma //////////////////
			TerminoVO[] terminosDest =null;
			if ((vocaCombos!=null) && (vocaCombos.length>=1)){
				terminosDest=vocaCombos[0].getTerminos();
				for (int li=0; li<terminosDest.length;li++){
					TerminoVO idAux = new TerminoVO();
					idAux=terminosDest[li];
					String textoIdioma= idAux.getNomTermino();
					String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
					idAux.setNomTermino(idiomasTra);
				}
				UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
				TerminoVO[] terminosOrdDest = terminosOrdDest1.ordenarTerminosVO(terminosDest, idiomaLdap);	
//				 crear el ordena en un fichero de utilidades TerminoVO[] terminosOrdDest = ordena(terminosDest, idiomaLdap);
				TerminoVO termVacio = new TerminoVO();
				termVacio.setIdiomaTermino("");
				termVacio.setIdTermino("");
				termVacio.setNomTermino("");
				Collection idDest2 = Arrays.asList(terminosOrdDest);
				Collection idDest= new ArrayList();
				idDest.add(termVacio); //Metemos el vacio para que nos salga en el combo ""
				Iterator zDest = idDest2.iterator();
				while (zDest.hasNext()) {
					idDest.add(zDest.next());
				}
				form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
				logger.debug("ASC - cargado comobo idioma");
				//fin combo idioma
			}
			
			
			//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			//ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			 
			 
			 //recogemos de la sesion los datos a cargar
			 AvAnnotationVO anotacion =new AvAnnotationVO();
			 
			 if (catalogadorAvSession.getMDSesion()==null) {
				 LomAvanzadoVO mdSession = new LomAvanzadoVO();
				 catalogadorAvSession.setMDSesion(mdSession);
			 }	
			
		   	 AvAnnotationVO[] anotaciones =catalogadorAvSession.getMDSesion().getAnotaciones();
		   	
		   	 //	Caso Modificacion
		   	String botonModificar=prop.getProperty("botonModificar")!=null?prop.getProperty("botonModificar"):"";
		   	indi=0;
		     if (botonModificar.equals(botonPulsado)) { //Modificacion
		    	logger.debug("ASC- ESTAMOS MODIFICANDO...");
		    	 int posicionAnotacion= Integer.parseInt(titulo) -1;
	    		 if (anotaciones!= null) {
	    			boolean esta=false;
	    			//int indi=0;
	    			while ((indi<anotaciones.length) && (!esta)) {
	    				if (indi==posicionAnotacion) {
	    					esta=true;
	    				}
	    				indi++;
	    			}
	    			if (esta) {
	    				//recogemos los datos para esa posicion
	    				if (indi>0)
	    					indi= indi-1;
	    				anotacion=anotaciones[indi];
	    				logger.debug("ASC- ESTAMOS MODIFICANDO ENCONTRAMOS POSICION " + indi + " IDENTIFICADOR "+ catalogadorAvSession.getIdentificador());
	    				//8.1 RECURSO ->BEGIN:VCARD VERSION 3.0 FN:GT8/SC36/CT71 EMAIL;TYPE=INTERNET:GT8@aenor.es ORG:AENOR END:VCARD
	    				String entidad="";
	    				if ((anotacion!=null) && (anotacion.getEntidad()!=null)){
	    					entidad=anotacion.getEntidad().getTexto()!=null?anotacion.getEntidad().getTexto().trim():"";
	    					String[] trozos = entidad.split(":");
		    				for (int i=0; i<trozos.length; i++) {
		    					String elem=trozos[i];
		    					if (elem.toUpperCase().endsWith("EMAIL;TYPE=INTERNET")){
		    						int finNombre = elem.toUpperCase().indexOf("EMAIL;TYPE=INTERNET");
		    						nombre = elem.substring(0, finNombre);
		    					}
		    					else if (elem.toUpperCase().endsWith("ORG")){
		    						int finEmail = elem.toUpperCase().indexOf("ORG");
		    						email = elem.substring(0, finEmail);
		    						if(!validaEmail(email.trim()))
		    							email="";
		    					}
		    					else if (elem.toUpperCase().endsWith("END")){
		    						int finOrg = elem.toUpperCase().indexOf("END");
		    						organizacion = elem.substring(0, finOrg);
		    					} 
		    				}//end for
	    				}
	    				form.setNombre(nombre!=null?nombre:"");
		    			form.setOrganizacion(organizacion!=null?organizacion:"");
		    			form.setEmail(email!=null?email:"");
		    			logger.debug("ASC- SACAMOS ENTIDAD  ");
		    			//8.2 FECHA --> 2007-06-09... Formato completo-->yyyy-MM-ddThh:mm:ss.S(+-)00:00 
		    			
		    			Fecha fecha= new Fecha();
		    			if ((anotacion!=null) && (anotacion.getFecha()!=null)) {
			    			fecha.setFechaLomes(anotacion.getFecha().getFecha());
		    			}
 		    			form.setFechaCorta(fecha.getFechaCorta());
		    			 form.setHora(fecha.getHora());
		    			 form.setMinutos(fecha.getMinutos());
		    			 form.setSegundoP1(fecha.getSegundoP1());
		    			 form.setSegundoP2(fecha.getSegundoP2());
		    			 form.setZhHora(fecha.getZhHora());
	    				 form.setZhMinutos(fecha.getZhMinutos());
	    				 form.setComboZonaH(fecha.getMasOmenos());
	    				 form.setMeridianocero(fecha.getMeridianoCero());


		    			
		    			//Descripciones de Fecha
	    				 DescripcionVO fDescripciones= new DescripcionVO();
	    				 LangStringVO[] descAForm=null;
		    			 if ((anotacion.getFecha()!=null) && (anotacion.getFecha().getDescripcion()!=null)) {
		    				 logger.debug("ASC- SACAMOS LA FECHA DE LA ANOTACION Y SU DESCRIPCION " + anotacion.getFecha() + "  " + anotacion.getFecha().getDescripcion());
		    				 logger.debug("ASC- antes de getTextos " + anotacion.getFecha().getDescripcion().getTextos());
		    				LangStringVO[] fechaDesc= anotacion.getFecha().getDescripcion().getTextos();
		    				if ((fechaDesc!=null) && (fechaDesc.length>0)) {
		    					logger.debug("ASC - DENTRO IF FECHA DESC " + fechaDesc);
		    					TerminoYPadreVO datoCompleto =null;
		    					ArrayList datosDesc= new ArrayList();
		    					for (int fl=0; fl<fechaDesc.length;fl++) {
		    						logger.debug("ASC- DENTRO FOR fl " + fl);
		    						datoCompleto = new TerminoYPadreVO();
		    						datoCompleto.setIdiomaTermino("en");
		    						datoCompleto.setIdVocabulario(prop.getProperty("idiomaDestinatario")); //Vocab de idioma sin el none
		    						datoCompleto.setIdTermino("");
		    						
		    						datoCompleto.setNomTermino(fechaDesc[fl].getIdioma()!=null?fechaDesc[fl].getIdioma():"");
		    						datosDesc.add(datoCompleto); //metemos cada descripcion en el array
		    					}//fin for
		    					
		    					//llamamos al servicio para que complete los idTermino de las descripciones
		    					logger.debug("ASC- fecha descripcion ");
		    					if (datosDesc.size()>0) {
			    					TerminoYPadreVO[] datosDescVO = this.getSrvVocabulariosControladosService().
			    												obtenerIdTermino((TerminoYPadreVO[])datosDesc.toArray(new TerminoYPadreVO[datosDesc.size()]));
			    					
			    					descAForm = new LangStringVO[datosDescVO.length];
			    					for (int i = 0; i<datosDescVO.length; i++) {
			    						LangStringVO langDesc = new LangStringVO();
			    						langDesc.setTexto(fechaDesc[i].getTexto().trim());
			    						langDesc.setIdioma(datosDescVO[i].getIdTermino());
			    						descAForm[i]= langDesc;
			    					}
		    					}else {
		    						descAForm = new LangStringVO[1];
			    					LangStringVO langvo = new LangStringVO();
			    					langvo.setIdioma("");
			    					langvo.setTexto("");
			    					descAForm[0] = langvo;
			    					logger.error("ASC- FECHA DESCRIPCION TIENE EL ARRAY CON SIZE 0");
		    					}
		    					
		    				}else{
		    					descAForm = new LangStringVO[1];
		    					LangStringVO langvo = new LangStringVO();
		    					langvo.setIdioma("");
		    					langvo.setTexto("");
		    					descAForm[0] = langvo;
		    					logger.debug("ASC- ELSE!!!! fecha descripcion " );
		    				}
		    				fDescripciones.setTextos(descAForm);
		    				form.setDescripcionFechaAsArray(fDescripciones.getTextos());
		    			 } else {
		    				 	descAForm = new LangStringVO[1];
		    					LangStringVO langvo = new LangStringVO();
		    					langvo.setIdioma("");
		    					langvo.setTexto("");
		    					descAForm[0] = langvo;
		    					logger.debug("ASC- fecha null!!");
		    			 }//end if descripcion fecha
		    			 	fDescripciones.setTextos(descAForm);
		    				form.setDescripcionFechaAsArray(fDescripciones.getTextos());
		    			 //8.3 DESCRIPCION 
		    			 DescripcionVO descripciones=new DescripcionVO();
		    			 logger.debug("ASC- SACAMOS LA DESCRIPCION DE ANOTACION " + anotacion.getDescripcion());
		    			 if ((anotacion!=null) && (anotacion.getDescripcion()!=null)) {
		    				LangStringVO[] descTex= anotacion.getDescripcion().getTextos();
		    				if ((descTex!=null) && (descTex.length>0)) {
		    					TerminoYPadreVO datoCompleto =null;
		    					ArrayList datosDesc= new ArrayList();
		    					for (int fl=0; fl<descTex.length;fl++) {
		    						datoCompleto = new TerminoYPadreVO();
		    						datoCompleto.setIdiomaTermino("en");
		    						datoCompleto.setIdVocabulario(prop.getProperty("idiomaDestinatario")); //Vocab de idioma sin el none
		    						datoCompleto.setIdTermino("");
		    						
		    						datoCompleto.setNomTermino(descTex[fl].getIdioma()!=null?descTex[fl].getIdioma():"");
		    						datosDesc.add(datoCompleto); //metemos cada descripcion en el array
		    					}//fin for
		    					//llamamos al servicio para que complete los idTermino de las descripciones
		    					logger.debug("ASC- descripcion " + datoCompleto.getNomTermino());
		    					if (datosDesc.size()>0) {
			    					TerminoYPadreVO[] datosDescVO = this.getSrvVocabulariosControladosService().
			    												obtenerIdTermino((TerminoYPadreVO[])datosDesc.toArray(new TerminoYPadreVO[datosDesc.size()]));
			    					
			    					descAForm = new LangStringVO[datosDescVO.length];
			    					for (int i = 0; i<datosDescVO.length; i++) {
			    						LangStringVO langDesc = new LangStringVO();
			    						langDesc.setTexto(descTex[i].getTexto().trim());
			    						langDesc.setIdioma(datosDescVO[i].getIdTermino());
			    						descAForm[i]= langDesc;
			    		            }
		    					} else {
		    						descAForm = new LangStringVO[1];
			    					LangStringVO langvo = new LangStringVO();
			    					langvo.setIdioma("");
			    					langvo.setTexto("");
			    					descAForm[0] = langvo;
			    					logger.error("ASC- DESCRIPCION TIENE EL ARRAY CON SIZE 0");
		    					}
		    				}else{
		    					descAForm = new LangStringVO[1];
		    					LangStringVO langvo = new LangStringVO();
		    					langvo.setIdioma("");
		    					langvo.setTexto("");
		    					descAForm[0] = langvo;
		    					logger.debug("ASC- ELSE!!!!! descripcion " );
		    				}
		    				
		    			
		    			 }else {
		    				 	descAForm = new LangStringVO[1];
		    					LangStringVO langvo = new LangStringVO();
		    					langvo.setIdioma("");
		    					langvo.setTexto("");
		    					descAForm[0] = langvo;
		    					logger.debug("ASC- DESCRIPCION  NULL");
		    			 }
		    			 //fin descripcion
		    			 	descripciones.setTextos(descAForm);
		    				form.setDescripcionAsArray(descAForm); //metemos el array de langStringVO en el formulario
		    			 
	    			} //end if esta
	    		}//fin anotaciones
		     } else {
		    	 // Caso CREAR
//		    	 //comprobamos que anotaciones no se ha null, si es null nos creamos uno	
//				 int longitud=0;
//				 if (catalogadorAvSession.getMDSesion().getAnotaciones()== null){
////					AvAnnotationVO[] anotaciones = new AvAnnotationVO[1];
////					catalogadorAvSession.getMDSesion().setAnotaciones(anotaciones);
//					longitud=1; 
//					
//				 } else 
//		    		 //creamos uno mas
//		    		 longitud= anotaciones.length +1;
		    	 
					//posicion en la que vamos a guardar la educacion

		    	 
//				 logger.debug("ASC- ESTAMOS CREANDO... INDICE ANOTACION " + longitud);
//				 form.setTituloAnotacion(String.valueOf(longitud));//longitud es 3 tengo q crear el 4
				 
					titulo ="1";
					if(anotaciones == null || anotaciones.length == 0){//si no hay educaciones lo guardamos en la primera
						indi = 0;
						form.setTituloAnotacion(titulo); //el numero que se muestra junto con Uso educativo		
					}
					else{//si ya habia alguna la guardamos en al final habra que añadirle una posición al array de educaciones
						indi = anotaciones.length;
						titulo = String.valueOf(anotaciones.length + 1);
						form.setTituloAnotacion(titulo); //el numero	
						}
					logger.debug("ASC- ESTAMOS CREANDO... INDICE ANOTACION " + titulo);
		    	 //los combos estan metidos arriba, ahora actualizamos el resto de los campos del formulario
		    	 form.setNombre("");
		    	form.setOrganizacion("");
		    	form.setEmail("");
		    	form.setFechaCorta("");
		    	form.setHora("");
		    	form.setMinutos("");
		    	form.setSegundoP1("");
		    	form.setSegundoP2("");
		    	form.setComboZonaH("");
		    	form.setZhHora("");
		    	form.setZhMinutos("");
		    	form.setMeridianocero("");
		    	form.setDescripcionAsArray(new LangStringVO[1]);
		    	form.setDescripcionFechaAsArray(new LangStringVO[1]);
		
		     }
	    	 
		    	
		 }catch (org.acegisecurity.AccessDeniedException ad) {
	  		 throw new java.lang.Exception("catalogador.avanzado", ad);
		 }catch (Exception e){
			  logger
				.error("Error en Servicio de catalogacion avanzado, metodo cargarDetalleAnotacion" + e);
			 throw new java.lang.Exception("ver.metadatos", e);
		 }finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						logger.error(e);
					}
				}
	        }	 		 
	}




	public void cargarDetalleClasificacion(
			ActionMapping mapping, 
			CargarDetalleClasificacionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
    	InputStream is = null;
    	Properties prop = new Properties();
    	try {
    		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
 			prop.load(is);

// 			String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
// 			ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
// 			
			
 			 //recogemos de la sesion los datos a cargar
			 CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			 
 			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
 			
			catalogadorAvSession.setIdioma(idiomaLdap);
 			String botonPulsado = request.getParameter("botonPulsado");
 			
 			if (botonPulsado==null)
 				botonPulsado=prop.getProperty("botonModificar")!=null?prop.getProperty("botonModificar"):"";
 			
 			form.setBotonPulsado(botonPulsado); //actualizamos si es modificar o crear
 			String titulo = request.getParameter("titulo");
 			if (titulo==null)
 				titulo=catalogadorAvSession.getTituloCategoria();
 			else 
 	 			catalogadorAvSession.setTituloCategoria(titulo); //si el titulo no es null lo metemos en sesion
 			
 			form.setTituloClasificacion(titulo); //el numero
 			//Recogemos los identificadores de los combos a rellenar y llamada al servicio
 			String[] l_id = { prop.getProperty("idiomaDestinatario"), prop.getProperty("proposito")}; 
			VocabularioVO[] vocaCombos = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
//			vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocaCombos);
			
			if ((vocabularioOrdenado!=null) && (vocabularioOrdenado.length>0)) {
				// Rellenamos combos
				for (int ic=0;ic<vocabularioOrdenado.length; ic++) {
					if (vocabularioOrdenado[ic].getIdVocabulario().equals(prop.getProperty("proposito"))) {
						// 1.- Combo de Razon-Purpose 9.1
						TerminoVO[] terminosDest = vocabularioOrdenado[ic].getTerminos();

						// crear el ordena en un fichero de utilidades TerminoVO[] terminosOrdDest = ordena(terminosDest, idiomaLdap);
						TerminoVO termVacio = new TerminoVO();
						termVacio.setIdiomaTermino("");
						termVacio.setIdTermino("");
						termVacio.setNomTermino("");
						Collection idDest2 = Arrays.asList(terminosDest);
						Collection idDest= new ArrayList();
						idDest.add(termVacio); //Metemos el vacio para que nos salga en el combo ""
						Iterator zDest = idDest2.iterator();
						while (zDest.hasNext()) {
							idDest.add(zDest.next());
						}
						form.setPropositoBackingList(idDest, "idTermino", "nomTermino");
						
					}else if (vocabularioOrdenado[ic].getIdVocabulario().equals(prop.getProperty("idiomaDestinatario"))) {
						// 2.- Combo de idiomas sin none language 5.11 
						TerminoVO[] terminosDest = vocabularioOrdenado[ic].getTerminos();
						for (int li=0; li<terminosDest.length;li++){
							TerminoVO idAux = new TerminoVO();
							idAux=terminosDest[li];
							String textoIdioma= idAux.getNomTermino();
							String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
							idAux.setNomTermino(idiomasTra);
						}
						// crear el ordena en un fichero de utilidades TerminoVO[] terminosOrdDest = ordena(terminosDest, idiomaLdap);
						TerminoVO termVacio = new TerminoVO();
						termVacio.setIdiomaTermino("");
						termVacio.setIdTermino("");
						termVacio.setNomTermino("");
						UtilidadesOrdenarCombos terminosOrdDest1 = new UtilidadesOrdenarCombos();
						TerminoVO[] terminosOrdDest = terminosOrdDest1.ordenarTerminosVO(terminosDest, idiomaLdap);	
						Collection idDest2 = Arrays.asList(terminosOrdDest);
						
						Collection idDest= new ArrayList();
						idDest.add(termVacio); //Metemos el vacio para que nos salga en el combo ""
						Iterator zDest = idDest2.iterator();
						while (zDest.hasNext()) {
							idDest.add(zDest.next());
						}
						form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					}//fin if
				}//fin for
				
			}//fin vocaCombos
			
 			//3.- Combo de Source--> generado por nosotros
 			//metodo de prueba
			Collection terms= new ArrayList();
			String[] rutaBus = prop.getProperty("rutaSource").split(",");
			for (int i=0; i< rutaBus.length;i++) {
				File dirBus = new File(rutaBus[i]);
				recogeRutasDir(dirBus, idiomaLdap, terms);
			}
			TerminoVO termVacio = new TerminoVO();
			termVacio.setIdiomaTermino("");
			termVacio.setIdTermino("");
			termVacio.setNomTermino("");
			Collection idDest2 = terms;
			TerminoVO[] terminos=new TerminoVO[idDest2.size()];
			for(int i=0;i<terminos.length;i++){
				terminos[i]=(TerminoVO)idDest2.toArray()[i];
			}
			UtilidadesOrdenarCombos utilidades=new UtilidadesOrdenarCombos();
			TerminoVO[] terminosOrdFuente = utilidades.ordenarTerminosVO(terminos, idiomaLdap);
			Collection idDest3 = Arrays.asList(terminosOrdFuente);
			Collection termsWVacio= new ArrayList();
			termsWVacio.add(termVacio); //Metemos el vacio para que nos salga en el combo ""
			Iterator zDest = idDest3.iterator();
			while (zDest.hasNext()) {
				termsWVacio.add(zDest.next());
			}
			
			//en terms tenemos un Array de TerminoVO 
 			form.setSourceBackingList(termsWVacio, "idTermino", "nomTermino");
 			/////////////////// FIN RECOGIDA COMBOS ///////////////////
			 //COMPROBAMOS SI VENIMOS DE TAXONOMIAS O TESAUROS
 			AvClassificationVO[] lisClasificacion=null;
 			if (catalogadorAvSession.getMDSesion()!=null) {
			  lisClasificacion =catalogadorAvSession.getMDSesion().getClasificaciones();
 			}
 			
			String idiomaObtenerIdTerm="";
			boolean tradSourceServ=false;
		   	///////////////////////////////////////////////////////////////////////
			//	Caso Modificacion
			String botonModificar=prop.getProperty("botonModificar")!=null?prop.getProperty("botonModificar"):"";
			 if (botonModificar.equals(botonPulsado)) { //Modificacion
		    	 int posicionClasi= Integer.parseInt(titulo) -1;
		    	 
		    	 AvClassificationVO clasificacion= null;
	    		 if (lisClasificacion!=null) {
		    		 if ((posicionClasi>=0) && (posicionClasi<lisClasificacion.length)) {
		    			 if (catalogadorAvSession.getClasificacionAux()!=null) {
		    				 clasificacion=catalogadorAvSession.getClasificacionAux();
		    			 	 idiomaObtenerIdTerm=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		    			 	 tradSourceServ=true;
		    			 }else {
		    			     clasificacion=lisClasificacion[posicionClasi];
		    			     tradSourceServ=false;
		    			 }
		    			
		    		 } else if(posicionClasi>=lisClasificacion.length) {
		    			 clasificacion=catalogadorAvSession.getClasificacionAux();
		    			 idiomaObtenerIdTerm=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		    			 tradSourceServ=true;
		    		 }
		 			}else {
		 				clasificacion=catalogadorAvSession.getClasificacionAux();//si no tiene nada todavia
		 				tradSourceServ=true;
		 			}
		    	
	    		 	//	clasificacion=lisClasificacion[indi];
	    			// Recogemos los datos de la clasificacion correspondiente
	    			//1.- Recogemos Propósito
	    			String sourceProp="";
	    			if (clasificacion.getProposito()!=null) {
	    				sourceProp=(clasificacion.getProposito().getValor()!=null?clasificacion.getProposito().getValor():"" );
	    			}
	    			if (!tradSourceServ) {
		    			//para señalar el source concreto... aprovechamos y metemos tb el idioma para que nos dev los idTerminos del idioma tb
		    			ArrayList datos=new ArrayList();
		    			TerminoYPadreVO datoCompleto = new TerminoYPadreVO();
		    			if (idiomaObtenerIdTerm.equals("")) //si venimos de fuentes taxonomicas ese idioma lo cogems de ldap
		    				idiomaObtenerIdTerm="en";
	 					datoCompleto.setIdiomaTermino(idiomaObtenerIdTerm);
	 					datoCompleto.setIdVocabulario(prop.getProperty("proposito"));
	 					datoCompleto.setIdTermino("");
	 					datoCompleto.setNomTermino(sourceProp!=null?sourceProp:"");
	 					datos.add(datoCompleto); 
	 					// llamamos al servicio para que complete los idTermino
	    				TerminoYPadreVO[] datosVO = this.getSrvVocabulariosControladosService().
	    											obtenerIdTermino((TerminoYPadreVO[])datos.toArray(new TerminoYPadreVO[datos.size()]));
		    			//////////////////////////////
		    			form.setProposito(datosVO[0].getIdTermino()!=null?datosVO[0].getIdTermino():""); //marcamos el combo de source con su valor
	    			} else {
	    				form.setProposito(sourceProp);
	    			}
	    				 
//	    			2.- Recogemos Taxones
	    			ArrayList rutasArr =new ArrayList();
	    			if ((clasificacion.getRutasTaxonomicas()!=null) && (clasificacion.getRutasTaxonomicas().length>0)){
	    				//Se comprueba si idiomaObtenerIdTerm venia vacio o no. Si venia vacio se introduce "en"
	    				if (idiomaObtenerIdTerm.equals(""))
    	    				idiomaObtenerIdTerm="en";
	    				RutaTaxonomicaVO[] rutas = clasificacion.getRutasTaxonomicas();
	    				RutaTaxonomicaVO[] rutaLimpia=rutaLimpia(rutas);
	    				if(rutaLimpia!=null && rutaLimpia.length>0){
	    				//Se recorre el array, se obtiene la informacion y se almacena.
	    				
		    				for (int r=0; r<rutaLimpia.length; r++) {
		    					RutaTaxonomicaVO unaRuta = new RutaTaxonomicaVO();//voy almacenando ahí mis datos 	    					
		    					LangStringVO[] langstring=null;
		    					LangStringVO langSource = new LangStringVO(); 			
		    					
		    					if ((rutaLimpia[r].getFuente()!=null) && (rutaLimpia[r].getFuente().getTextos()!=null) && (rutaLimpia[r].getFuente().getTextos().length>0) ) {
		    						langstring= rutaLimpia[r].getFuente().getTextos();    						
		    						
		    						/*
			    					 * ----DECLARACION DE LAS VARIABLES---	    					 
			    					 * */
			    					String sourceIdentificador = ""; //Arbol_Curricular_LOE_2006_TAX
			    					String sourceTraducido = ""; //Arbol Curricular LOE 2006
			    					String idiomaIdentificador = ""; //5.11.1
			    					String idiomaEquivalente = "";//castellano	    					
			    					
			    					/*
			    					 * ---POBLAMOS LAS VARIABLES---
			    					 * 1. EL SOURCE PUEDE VENIR EN 2 VARIANTES:
			    					 * 	A. IDENTIFICADOR (Arbol_Curricular_LOE_2006_TAX)		    					 
			    					 * 	B. TERMINO TRADUCIDO (Arbol Curricular LOE 2006)
			    					 * 2. EL IDIOMA PUEDE VENIR EN 3 VARIANTES
			    					 * 	A. IDENTIFICADOR (5..1.1)
			    					 * 	B. ISO (es)
			    					 * 	C. EQUIVALENCIA (castellano)
			    					 * */
			    					
			    					logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Los datos de entrada son: SOURCE:["+langstring[0].getTexto()+"] e IDIOMA:["+langstring[0].getIdioma()+"]");
			    					
			    					/*-----------------------------
			    					 * TRATAMOS EL CASO DEL SOURCE
			    					 * ----------------------------*/
			    					
			    					//PRIMERO: Intentamos traducir 
			    					logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Intentamos realizar la traduccion del source");
			    					String[] idSource = {langstring[0].getTexto()!=null?langstring[0].getTexto():""};		                        
			                        String traducido = devuelveSinFinal(idSource[0], terms);
			                        if(traducido!=null && !traducido.equals(""))
			                        {   //Se ha realizado la traduccion correctamente. El termino de entrada era el identificador
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Se ha podido traducir el source, el termino de entrada era el identificador con valor ["+idSource[0]+"]");
			                        	sourceIdentificador = idSource[0]; 
			                            sourceTraducido = traducido;		                            
			                        }   
			                        else
			                        {
			                        	/*No se ha realizado correctamente la traduccion. Ya venia el termino traducido*/
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- No se ha podido traducir el source, el termino de entrada era ya el traducido, con valor ["+idSource[0]+"]");
			                        	sourceIdentificador = devuelveIdTerms(idSource[0], terms);
			                        	sourceTraducido = idSource[0];
			                        	
			                        	
			                        }
			                        
			                        /*-----------------------------
			    					 * TRATAMOS EL CASO DEL IDIOMA
			    					 * ----------------------------*/
			                        logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Intentamos realizar la traduccion del idioma");
			                        String[] idIdioma = {langstring[0].getIdioma()!=null?langstring[0].getIdioma():""};
			                        TerminoVO[] terminosTraducIdioma = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(idIdioma, idiomaObtenerIdTerm);
			                        if(terminosTraducIdioma!=null && terminosTraducIdioma.length>0)
			                        {   //Se ha realizado la traduccion correctamente. El termino de entrada era el identificador
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Se ha podido traducir el idioma, el termino de entrada era el identificador con valor ["+idIdioma[0]+"]");
			                        	idiomaIdentificador = idIdioma[0]; 
			                            String properIdioma=I18n.getInstance().obtenerIdiomaTraducido(terminosTraducIdioma[0].getNomTermino(), idiomaLdap);
			                            idiomaEquivalente = properIdioma;	
			                            
			                        } 
			                        else
			                        {
			                        	/*No se ha realizado correctamente la traduccion. Dos opciones:
			                        	 * 1. Venia ISO (es)
			                        	 * 2. Venia el equivalente (castellano)*/
			                        	
			                        	//Miramos si era el iso con el properties
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- No se ha podido traducir el idioma, miramos si el termino de entrada era el iso o ya el traducido");
			                        	boolean bandera=false;
			                        	String[] idiomas=I18n.getInstance().obtenerIdiomasPlataforma();
			                        	ArrayList listaIdiomasPlataforma = new ArrayList(Arrays.asList(idiomas));
			                        	if (listaIdiomasPlataforma.contains(idIdioma[0])) {
			                        		bandera=true;
			                        	}
			                        	
//			                			StringTokenizer token = new StringTokenizer(idiomas, ",");
//			                			while (token.hasMoreElements()&&(!bandera)) {
//			                				String idiomaLeido=token.nextElement().toString();
//			                				if(idIdioma[0].equals(idiomaLeido)){
//			                					bandera=true;
//			                				}
//			                			}
			                        	
			                			if(bandera)
			                			{
			                				//viene el iso
			                				logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- No se ha podido traducir el idioma, el termino de entrada era el iso con valor ["+langstring[0].getIdioma()+"]");
			                				ArrayList lanEnIdiomas = new ArrayList();
				                            TerminoYPadreVO tpLanEnt = new TerminoYPadreVO();
			                                if (idiomaObtenerIdTerm.equals("")) 
			                                idiomaObtenerIdTerm="en";
			                                tpLanEnt.setIdiomaTermino(idiomaObtenerIdTerm);
			                                tpLanEnt.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
			                                tpLanEnt.setIdTermino("");
			                                tpLanEnt.setNomTermino(langstring[0].getIdioma());
			                                lanEnIdiomas.add(tpLanEnt);                                                                                                    
				                            TerminoYPadreVO[] datosLangvo = this.getSrvVocabulariosControladosService().obtenerIdTermino((TerminoYPadreVO[])lanEnIdiomas.toArray(new TerminoYPadreVO[lanEnIdiomas.size()]));
				                            idiomaIdentificador=datosLangvo[0].getIdTermino();
			                				String properIdioma=I18n.getInstance().obtenerIdiomaTraducido(idIdioma[0], idiomaLdap);
				                            idiomaEquivalente = properIdioma;	                				
			                			}
			                			else
			                			{
			                				//venia el equivalente (castellano)
			                				logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- No se ha podido traducir el idioma, el termino de entrada era el equivalente con valor ["+langstring[0].getIdioma()+"]");
			                				idiomaEquivalente = idIdioma[0];
	//		                				Obtengo el idtermino
			                				String isoIdioma =""; 
			                				if (!idIdioma[0].equals("")){
			                					isoIdioma=I18n.getInstance().obtenerIdiomaIso(idIdioma[0], idiomaLdap);//dameIdiomaProp(idIdioma[0]);
			                				}
			                                ArrayList lanEnIdiomas = new ArrayList();
			                                TerminoYPadreVO tpLanEnt = new TerminoYPadreVO();
				                                 if (idiomaObtenerIdTerm.equals("")) 
				                                	 idiomaObtenerIdTerm="en";
			                                 tpLanEnt.setIdiomaTermino(idiomaObtenerIdTerm);
			                                 tpLanEnt.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
			                                 tpLanEnt.setIdTermino("");
			                                 tpLanEnt.setNomTermino(isoIdioma);
			                                 lanEnIdiomas.add(tpLanEnt);                                                                                                    
			                               TerminoYPadreVO[] datosLangvo = this.getSrvVocabulariosControladosService().obtenerIdTermino((TerminoYPadreVO[])lanEnIdiomas.toArray(new TerminoYPadreVO[lanEnIdiomas.size()]));
			                               idiomaIdentificador=datosLangvo[0].getIdTermino();
	
	
			                			}
			                        	
			                        }
			                        
			                        /*
			                         * ----**** INTRODUCIMOS LOS VALORES EN EL LANGSOURCE DEPENDIENDO DE: ****----
			                         * 1. VINIENDO DE LAS CATEGORIAS DEL CATALOGADOR
			                         * 	A. CON TAXONES ASOCIADOS
			                         * 	B. SIN TAXONES ASOCIADOS
			                         * 2. VINIENDO DE LA ASOCIACION DE ALGUN TAXON
			                         * 	A. CON TAXONES ASOCIADOS
			                         * 	B. SIN TAXONES ASOCIADOS
			                         * */	                  
		                        
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Los valores de las variables son los siguientes:");
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- El identificador del source ["+sourceIdentificador+"]");
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- El termino traducido del source ["+sourceTraducido+"]");
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- El identificador del idioma ["+idiomaIdentificador+"]");
			                        	logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- El termino traducido del idioma ["+idiomaEquivalente+"]");
			                        	if(rutaLimpia[r].getTaxones()!=null && rutaLimpia[r].getTaxones().length > 0 && rutaLimpia[r].getTaxones()[0].getId().getTexto()!=null && !rutaLimpia[r].getTaxones()[0].getId().getTexto().equals(""))
			                        	{
			                        		//CON TAXONES ASOCIADOS
			                        		logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Venia con taxones asociados");
			                        		langSource.setIdioma(idiomaEquivalente);
			                        		langSource.setTexto(sourceTraducido);
			                        	}
			                        	else
			                        	{
			                        		//sin taxones asociados
			                        		logger.debug("DetalleClasificacionControllerImpl Recoger Taxones--- Venia sin taxones asociados");
			                        		langSource.setIdioma(idiomaIdentificador);
			                        		langSource.setTexto(sourceIdentificador);
			                        	}
		    					}	    				 
		    					
		    					//Hemos recogido el source y su idioma q es un LangString
		    					FuenteVO fSource =new FuenteVO();
		    					LangStringVO[]sourceAForm = new LangStringVO[1];
		    					sourceAForm[0] = langSource;
		    					fSource.setTextos(sourceAForm);
		    					unaRuta.setFuente(fSource);
		    					//ya tenemos en unaRuta metido el source e idioma
		    					TaxonVO[] taxRutar= rutaLimpia[r].getTaxones();
		    					ArrayList arrTax = new ArrayList();
			    				if (taxRutar!=null && taxRutar.length>0){
			    					  for (int tr=0;tr<taxRutar.length;tr++){
			    						  LangStringVO[] lanEntryAForm =null;
			    							TaxonVO taxAux = new TaxonVO();
			    							IdVO idAux = new IdVO();
			    							if(taxRutar[tr].getId()!=null && taxRutar[tr].getId().getTexto()!=null){
			    								idAux.setTexto(taxRutar[tr].getId().getTexto());
			    							}else{
			    								idAux.setTexto("");
			    							}
			    							taxAux.setId(idAux);
			    							if(taxRutar[tr].getEntry()!=null && taxRutar[tr].getEntry().getTextos()!=null && taxRutar[tr].getEntry().getTextos().length>0){	  
				    							LangStringVO[] lanEntry = taxRutar[tr].getEntry().getTextos();
				    							if (lanEntry!=null){
				    								if (!tradSourceServ) {//no venimos de tesauros ni taxonomia
					    								ArrayList lanEnIdiomas = new ArrayList();
					    								if(lanEntry!=null && lanEntry.length>0){
						    								for (int lE=0; lE<lanEntry.length;lE++){
						    									TerminoYPadreVO tpLanEnt = new TerminoYPadreVO();
						    									if (idiomaObtenerIdTerm.equals("")) //si venimos de fuentes taxonomicas ese idioma lo cogems de ldap
						    					    				idiomaObtenerIdTerm="en";
						    									tpLanEnt.setIdiomaTermino(idiomaObtenerIdTerm);
						    									tpLanEnt.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
						    									tpLanEnt.setIdTermino("");
						    									tpLanEnt.setNomTermino(lanEntry[lE].getIdioma()!=null?lanEntry[lE].getIdioma():"");
						    									lanEnIdiomas.add(tpLanEnt);
						    								}
					    								}else{
					    									TerminoYPadreVO tpLanEnt = new TerminoYPadreVO();
					    									tpLanEnt.setIdiomaTermino("");
					    									tpLanEnt.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
					    									tpLanEnt.setIdTermino("");
					    									tpLanEnt.setNomTermino("");
					    									lanEnIdiomas.add(tpLanEnt);
					    								}
					    								//ahora llamamos al servicio para que nos dev. los identificadores correspondientes a los idiomas de cada uno
					    								TerminoYPadreVO[] datosLangvo = this.getSrvVocabulariosControladosService().
					    																obtenerIdTermino((TerminoYPadreVO[])lanEnIdiomas.toArray(new TerminoYPadreVO[lanEnIdiomas.size()]));
					    								
					    								
					    								lanEntryAForm = new LangStringVO[datosLangvo.length];
					    								for (int i = 0; i<datosLangvo.length; i++) {
					    									LangStringVO langDesc = new LangStringVO();
					    									langDesc.setTexto(lanEntry[i].getTexto());
					    									//	para convertir el combo en una caja de texto tenemo qe hacer la traduccion del idioma
					    									String[] termsTraducIdio= {datosLangvo[i].getIdTermino()!=null?datosLangvo[i].getIdTermino():""};//1.3.1
					    									if (idiomaObtenerIdTerm.equals("")) //si venimos de fuentes taxonomicas ese idioma lo cogems de ldap
					    					    				idiomaObtenerIdTerm="en";
															TerminoVO[] idiomaTraducTax = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(termsTraducIdio, idiomaObtenerIdTerm);
															if ((idiomaTraducTax!=null) && (idiomaTraducTax.length>0)) {
																
																String textoIdioma=idiomaTraducTax[0].getNomTermino()!=null?idiomaTraducTax[0].getNomTermino():"";
																String proper="";
																try{	
						    										proper=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						    									}catch(Exception e){
						    										proper=textoIdioma;
						    									}
																langDesc.setIdioma(proper);//prop.getProperty(textoIdioma)
															}else if((idiomaTraducTax==null || idiomaTraducTax.length==0)&& datosLangvo[i].getNomTermino()!=null &&(!datosLangvo[i].getNomTermino().equals(""))){
																langDesc.setIdioma(datosLangvo[i].getNomTermino());
															}
															else {
																langDesc.setIdioma("");
															}
					    									lanEntryAForm[i]= langDesc;
					    								}
				    								}else {
				    									//	venimos de Taxonomias o Tesauros
				    									//tengo que traducir los idiomas para que aparezcan castellano en lugar de es
				    									lanEntryAForm = new LangStringVO[lanEntry.length];
				    									for (int i = 0; i<lanEntry.length; i++) {
				    										LangStringVO langDesc = new LangStringVO();
					    									langDesc.setTexto(lanEntry[i].getTexto());
					    									String textoIdioma=lanEntry[i].getIdioma()!=null?lanEntry[i].getIdioma():"";
					    									String proper="";
					    									try{	
					    										proper=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
					    									}catch(Exception e){
					    										proper=textoIdioma;
					    									}
															langDesc.setIdioma(proper);
															lanEntryAForm[i]= langDesc;
					    								}
				    									
				    								}
				    							}
			    							}else{
			    								lanEntryAForm = new LangStringVO[1];
			    								LangStringVO langVacio=new LangStringVO();
			    								langVacio.setIdioma("");
			    								langVacio.setTexto("");
			    								lanEntryAForm[0]=langVacio;
			    								
			    							}
			    							EntryVO entry= new EntryVO();
			    							entry.setTextos(lanEntryAForm);
			    							taxAux.setEntry(entry);
			    							arrTax.add(taxAux);//taxones incluidos
			    								  
			    					}
			    			  }
			    				if(arrTax!=null && arrTax.size()>0){
			    					taxRutar = (TaxonVO[])arrTax.toArray(new TaxonVO[arrTax.size()]);
			    				}else{
			    					taxRutar=new TaxonVO[1];
			    					TaxonVO unTax = new TaxonVO();
			    					LangStringVO[] textoVacioAForm = new LangStringVO[1];
			    					LangStringVO langvo = new LangStringVO();
					    			langvo.setIdioma("");
					    			langvo.setTexto("");
					    			textoVacioAForm[0] = langvo;
			    					EntryVO entry= new EntryVO();
				    				IdVO id = new IdVO();
				    				entry.setTextos(textoVacioAForm);
				    				id.setTexto("");
				    				unTax.setEntry(entry);
				    				unTax.setId(id);
				    					 
				    				taxRutar[0]=unTax;
			    				}
		    				  unaRuta.setTaxones(taxRutar);
		    				  rutasArr.add(unaRuta);//aqui tenemos una Ruta TAxonomica completa
		    						  
		    				}
		    			}else {//si esta todo vacio!!--> clasificacion.getRutasTaxonomicas()==null o tamaño 0
		    				RutaTaxonomicaVO rt = new RutaTaxonomicaVO();
		    				FuenteVO fvo = new FuenteVO();
		    				LangStringVO[] textoVacioAForm = new LangStringVO[1];
			    			LangStringVO langvo = new LangStringVO();
			    			langvo.setIdioma("");
			    			langvo.setTexto("");
			    			textoVacioAForm[0] = langvo;
		    				fvo.setTextos(textoVacioAForm);
		    				rt.setFuente(fvo);
		    					 
		    				TaxonVO[] taxVacioAform= new TaxonVO[1];
		    				TaxonVO unTax = new TaxonVO();
		    					 
		    				EntryVO entry= new EntryVO();
		    				IdVO id = new IdVO();
		    				entry.setTextos(textoVacioAForm);
		    				id.setTexto("");
		    				unTax.setEntry(entry);
		    				unTax.setId(id);
		    					 
		    				taxVacioAform[0]=unTax;
		    				rt.setTaxones(taxVacioAform);
		    				rutasArr.add(rt);
		    		    }
	    			} else {//si esta todo vacio!!--> clasificacion.getRutasTaxonomicas()==null o tamaño 0
	    				RutaTaxonomicaVO rt = new RutaTaxonomicaVO();
	    				FuenteVO fvo = new FuenteVO();
	    				LangStringVO[] textoVacioAForm = new LangStringVO[1];
		    			LangStringVO langvo = new LangStringVO();
		    			langvo.setIdioma("");
		    			langvo.setTexto("");
		    			textoVacioAForm[0] = langvo;
	    				fvo.setTextos(textoVacioAForm);
	    				rt.setFuente(fvo);
	    					 
	    				TaxonVO[] taxVacioAform= new TaxonVO[1];
	    				TaxonVO unTax = new TaxonVO();
	    					 
	    				EntryVO entry= new EntryVO();
	    				IdVO id = new IdVO();
	    				entry.setTextos(textoVacioAForm);
	    				id.setTexto("");
	    				unTax.setEntry(entry);
	    				unTax.setId(id);
	    					 
	    				taxVacioAform[0]=unTax;
	    				rt.setTaxones(taxVacioAform);
	    				rutasArr.add(rt);
	    		    }
	    			form.setRutaTaxonomica(rutasArr);
	    				 
	    			//3.- Recogemos Descripciones
	    				 //clasificacion.getDescripcion();
	    			LangStringVO[] descAForm=null;
	    			DescripcionVO descripcines = new DescripcionVO();
	    			if ((clasificacion!=null) && (clasificacion.getDescripcion()!=null) && 
	    					(clasificacion.getDescripcion().getTextos()!=null) && (clasificacion.getDescripcion().getTextos().length>0)) {
	    				LangStringVO[] descText= clasificacion.getDescripcion().getTextos();
	    				if (descText!=null){
	    					if (!tradSourceServ){
		    					TerminoYPadreVO datoCDesc =null;
		    					ArrayList datosDescArr= new ArrayList();
		    					for (int fl=0; fl<descText.length;fl++) {
		    						datoCDesc = new TerminoYPadreVO();
		    						if (idiomaObtenerIdTerm.equals("")) //si venimos de fuentes taxonomicas ese idioma lo cogems de ldap
					    				idiomaObtenerIdTerm="en";
		    						datoCDesc.setIdiomaTermino(idiomaObtenerIdTerm);
		    						datoCDesc.setIdVocabulario(prop.getProperty("idiomaDestinatario")); //Vocab de idioma sin el none
		    						datoCDesc.setIdTermino("");
		    						datoCDesc.setNomTermino(descText[fl].getIdioma()!=null?descText[fl].getIdioma():"");
		    						datosDescArr.add(datoCDesc); //metemos cada descripcion en el array
		    					}//fin for
		    					if (datosDescArr.size()>0) {//si el array tiene datos
			    					TerminoYPadreVO[] datosDescVO = this.getSrvVocabulariosControladosService().
			    												obtenerIdTermino((TerminoYPadreVO[])datosDescArr.toArray(new TerminoYPadreVO[datosDescArr.size()]));
			    					
			    					descAForm = new LangStringVO[datosDescVO.length];
			    					for (int i = 0; i<datosDescVO.length; i++) {
			    						LangStringVO langDesc = new LangStringVO();
			    						langDesc.setTexto(descText[i].getTexto());
			    						langDesc.setIdioma(datosDescVO[i].getIdTermino());
			    						descAForm[i]= langDesc;
			    		            }
		    					} else {//si el array no tiene datos
		    						descAForm = new LangStringVO[1];
			    					LangStringVO langvo = new LangStringVO();
			    					langvo.setIdioma("");
			    					langvo.setTexto("");
			    					descAForm[0] = langvo;
			    					logger.debug("ASC- DESCRIPCION TIENE EL ARRAY CON SIZE 0");
		    					}
	    					} else {
	    						descAForm=descText;
	    					}
	    				
	    				} else {//inicializamos descripciones
	    					descAForm = new LangStringVO[1];
	    					LangStringVO langvo = new LangStringVO();
	    					langvo.setIdioma("");
	    					langvo.setTexto("");
	    					descAForm[0] = langvo;
	    				}
	    			} else {//si no tenemos descripciones lo inicializams
	    				descAForm = new LangStringVO[1];
    					LangStringVO langvo = new LangStringVO();
    					langvo.setIdioma("");
    					langvo.setTexto("");
    					descAForm[0] = langvo;
    					logger.debug("ASC- DETALLE-CLASIFICACION; ELSE!!!!! descripcion " );
	    			}
	    			descripcines.setTextos(descAForm);
	    			form.setDescripcionesAsArray(descAForm);
	    			
	    			//4.- Recogemos Palabras Clave
	    			PalabraClaveVO[] palabraClaveVO=null; 
	    			TerminoYPadreVO terminoypadreVO= null;
	    			ArrayList lPalabras= new ArrayList();
	    			if ((clasificacion!=null) && (clasificacion.getPalabrasClave()!=null) && (clasificacion.getPalabrasClave().length>0)) {
	    				palabraClaveVO = clasificacion.getPalabrasClave();
	    				int longiPalClave=0;
	    				if (palabraClaveVO==null) {
	    					palabraClaveVO = new PalabraClaveVO[0];
	    				} else 
	    					longiPalClave=palabraClaveVO.length;
	    				
	    				PalabraClaveVO[] palabrasClaveVO =new PalabraClaveVO[longiPalClave];
	    				if (!tradSourceServ) {
								for (int i = 0; i<longiPalClave; i++){
									ArrayList terminoYPadrePalabras = new  ArrayList();
									if(palabraClaveVO[i].getTextos()!=null && palabraClaveVO[i].getTextos().length>0){
										LangStringVO[] langTextosPal = palabraClaveVO[i].getTextos();
										
										for(int j=0;j<langTextosPal.length;j++){
											terminoypadreVO = new TerminoYPadreVO();
											if (idiomaObtenerIdTerm.equals("")) //si venimos de fuentes taxonomicas ese idioma lo cogems de ldap
							    				idiomaObtenerIdTerm="en";
											terminoypadreVO.setIdiomaTermino(idiomaObtenerIdTerm);
											terminoypadreVO.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
											terminoypadreVO.setIdTermino("");
											if(langTextosPal[j].getIdioma()!= null)
												terminoypadreVO.setNomTermino(langTextosPal[j].getIdioma());
											else
												terminoypadreVO.setNomTermino("");
											terminoYPadrePalabras.add(terminoypadreVO);
											
										}
										
									}else{
										terminoYPadrePalabras = new  ArrayList();
										terminoypadreVO = new TerminoYPadreVO();
										terminoypadreVO.setIdiomaTermino("en");
										terminoypadreVO.setIdTermino("");
										terminoypadreVO.setIdVocabulario(prop.getProperty("idiomaDestinatario"));
										terminoypadreVO.setNomTermino("");
										terminoYPadrePalabras.add(terminoypadreVO);
										
									}
									lPalabras.add(terminoYPadrePalabras);
								}
			    				palabrasClaveVO = new PalabraClaveVO[lPalabras.size()];
								for (int i = 0; i<lPalabras.size();i++) {
									PalabraClaveVO pClaVO = new PalabraClaveVO();
									ArrayList terminoYPadrePalab = (ArrayList) lPalabras.get(i);
									TerminoYPadreVO[] arrayTerminoYPadrePalabras=(TerminoYPadreVO[])terminoYPadrePalab.toArray(new TerminoYPadreVO[terminoYPadrePalab.size()]);
									TerminoYPadreVO[] terminoYPadrePalabrasVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadrePalabras);
									LangStringVO[] langTextosPal = palabraClaveVO[i].getTextos();
									if(langTextosPal!=null && langTextosPal.length>0){
										LangStringVO[] nuevoLangTextosPal = new LangStringVO[langTextosPal.length];
										for (int j = 0; j<terminoYPadrePalabrasVuelta.length; j++) {
											LangStringVO nuevoLangPal = new LangStringVO();
											nuevoLangPal.setIdioma(terminoYPadrePalabrasVuelta[j].getIdTermino());
											nuevoLangPal.setTexto(langTextosPal[j].getTexto());
											nuevoLangTextosPal[j]= nuevoLangPal;
											
										}
										pClaVO.setTextos(nuevoLangTextosPal);
									}else{
										LangStringVO[] nuevoLangTextosPal=new LangStringVO[1];
										LangStringVO nuevoLangPal = new LangStringVO();
										nuevoLangPal.setIdioma("");
										nuevoLangPal.setTexto("");
										nuevoLangTextosPal[0]= nuevoLangPal;
										pClaVO.setTextos(nuevoLangTextosPal);
									}
									
									palabrasClaveVO[i]=pClaVO;
								}
	    				}else {
	    					palabrasClaveVO=palabraClaveVO;
	    				}
						form.setPalabrasClaveAsArray(palabrasClaveVO);
						
	    			}else {//si no hay palabras clave las inicializamos
	    				 palabraClaveVO = new PalabraClaveVO[1];
	    				 LangStringVO langvo = new LangStringVO();
	    				 langvo.setIdioma("");
	    				 langvo.setTexto("");
	    				 ArrayList arrPcl =new ArrayList();
	    				 PalabraClaveVO unaPC= new PalabraClaveVO();
	    				 LangStringVO[] palClaAForm = new LangStringVO[1];
	    				 palClaAForm[0]=langvo; //es lo mismo vacio
	    				 unaPC.setTextos(palClaAForm);
	    				 arrPcl.add(unaPC);
	    				 palabraClaveVO= (PalabraClaveVO[])arrPcl.toArray(new PalabraClaveVO[arrPcl.size()]);
	    				 form.setPalabrasClaveAsArray(palabraClaveVO);
	    			}
	    	
		    }else {
		       // Caso CREAR
		    	titulo ="1";
				if(lisClasificacion == null || lisClasificacion.length == 0){
					indi = 0;
					form.setTituloClasificacion(titulo); //el numero que se muestra junto con Uso educativo		
				}
				else{//si ya habia alguna la guardamos en al final habra que añadirle una posición al array de educaciones
					indi = lisClasificacion.length;
					titulo = String.valueOf(lisClasificacion.length + 1);
					form.setTituloClasificacion(titulo); //el numero	
				 }
			   
				 form.setTituloClasificacion(titulo);//longitud es 3 tengo q crear el 4
				 form.setProposito("");
				 catalogadorAvSession.setTituloCategoria(titulo);
				//Inicializamos rutas taxonomicas
				 ArrayList rutasArr = new ArrayList();
				 RutaTaxonomicaVO rt = new RutaTaxonomicaVO();
				 FuenteVO fvo = new FuenteVO();
				 LangStringVO[] textoVacioAForm = new LangStringVO[1];
				 LangStringVO langvo = new LangStringVO();
				 langvo.setIdioma("");
				 langvo.setTexto("");
				 textoVacioAForm[0] = langvo;
				 fvo.setTextos(textoVacioAForm);
				 rt.setFuente(fvo);
				 
				 TaxonVO[] taxVacioAform= new TaxonVO[1];
				 TaxonVO unTax = new TaxonVO();
				 
				 EntryVO entry= new EntryVO();
				 IdVO id = new IdVO();
				 entry.setTextos(textoVacioAForm);
				 id.setTexto("");
				 unTax.setEntry(entry);
				 unTax.setId(id);
				 
				 taxVacioAform[0]=unTax;
				 rt.setTaxones(taxVacioAform);
				 rutasArr.add(rt);
				 form.setRutaTaxonomica(rutasArr);
				 //Inicializamos descripciones
				 LangStringVO[] descAForm = new LangStringVO[1];
				 langvo.setIdioma("");
				 langvo.setTexto("");
				 descAForm[0] = langvo;
				 DescripcionVO descripciones =new DescripcionVO();
				 descripciones.setTextos(descAForm);
				 form.setDescripcionesAsArray(descAForm);
				 //Inicializamos palabras clave
				 PalabraClaveVO[] pClave = new PalabraClaveVO[1];
				 ArrayList arrPcl =new ArrayList();
				 PalabraClaveVO unaPC= new PalabraClaveVO();
				 LangStringVO[] palClaAForm = new LangStringVO[1];
				 palClaAForm[0]=langvo; //es lo mismo vacio
				 unaPC.setTextos(palClaAForm);
				 arrPcl.add(unaPC);
				 pClave= (PalabraClaveVO[])arrPcl.toArray(new PalabraClaveVO[arrPcl.size()]);
				 form.setPalabrasClaveAsArray(pClave);
				 
		     }
    	} catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("detalle.clasificacion", ad);
		} catch (Exception e) {
    		logger
			.error("Error en catalogadorWeb, categoria DetalleClasificacion, metodo cargarDetalleClasificacion" + e);
    		throw new java.lang.Exception("detalle.clasificacion", e);
    		
        } finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }//fin finally	
   	 
    }

	//metodo provisional hasta q se quite de properties
//	private String dameIdiomaProp(String idiomaTrad) throws Exception{
//		String idiomaSalida="";
//		InputStream is = null;
//    	Properties prop = new Properties();
//    	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
//		prop.load(is);
//		
//		String idiomas = prop.getProperty("idiomas.properties"); //es, en, eu...
//		StringTokenizer token = new StringTokenizer(idiomas, ",");
//		boolean encontrado=false;
//		while (token.hasMoreElements()&&(!encontrado)) {
//			String idiomaLeido=token.nextElement().toString();//es, en..
//			if ((prop.getProperty(idiomaLeido)!=null) && 
//					     (prop.getProperty(idiomaLeido).equals(idiomaTrad))){
//				idiomaSalida=idiomaLeido;
//				encontrado=true;
//			}
//		}
//		return idiomaSalida; //el suyo si castellano->es
//	}
	
	private String devuelveSinFinal(String variable, Collection terms){
		String traducido="";
		if(variable!=null && !variable.equals("")){
			for(int i=0;i<terms.size();i++){
				if(variable.equals((((TerminoVO) terms.toArray()[i]).getIdTermino()))){
					traducido=(((TerminoVO) terms.toArray()[i]).getNomTermino());
				}
					
			}
		}
		return traducido;
	}
	
	private String devuelveIdTerms(String variable, Collection terms){		
		String id = "";
		if(variable!=null && !variable.equals("")){
			for(int i=0;i<terms.size();i++){
				if(variable.equals((((TerminoVO) terms.toArray()[i]).getNomTermino()))){
					id=(((TerminoVO) terms.toArray()[i]).getIdTermino());
				}
					
			}
		}
		return id;
	}	
	
	private RutaTaxonomicaVO[]rutaLimpia(RutaTaxonomicaVO[] rutas){
		ArrayList rutaLim=new ArrayList();
		RutaTaxonomicaVO[] rutasLimpias=null;
		if(rutas!=null && rutas.length>0){						
			for(int i=0;i < rutas.length-1;i++){//Todas las rutas las limpiamos, menos la última que es especial pues si viene vacío lo tenemos que guardar
				boolean vacio=false;//Si la entrada y identificador vienen bien rellenos los guardamos; y si alguno de los dos o los dos vienen vacíos
				FuenteVO fuente=rutas[i].getFuente();// quitamos la ruta taxonómica
				TaxonVO[] taxones=rutas[i].getTaxones();
				if(taxones!=null && taxones.length>0){
					for(int j=0;j<taxones.length && !vacio;j++){
						EntryVO entry=taxones[j].getEntry();
						IdVO id=taxones[j].getId();
						if(entry!=null && !vacio){
							LangStringVO[] lang=entry.getTextos();
							if(lang!=null && lang.length>0){
								boolean langLleno=false;
								for(int k=0;k<lang.length && !langLleno;k++){
									String texto=lang[k].getTexto();
									if(texto!=null || !texto.equals("")){
										langLleno=true;
										vacio=false;
									}else{
										vacio=true;
									}
								}
							}
						}else{
							vacio=true;
						}
						if(id!=null && !vacio){
							String ident=id.getTexto();
							if(ident==null || ident.equals("")){
								vacio=true;
							}
						}else{
							vacio=true;
						}
					}
				}
				if(!vacio){
					rutaLim.add(rutas[i]);
				}
			}for(int l=rutas.length-1;l < rutas.length;l++){//La última ruta taxonómica es diferente, puesto que si trae la fuente lo tenemos que guardar si está bien relleno o si viene
				if(rutas[l].getTaxones()!=null && rutas[l].getTaxones().length>0){
					TaxonVO[] taxonesUlti=rutas[l].getTaxones();//vacío, para poder pintar los combos de la fuente y el idioma.
					if(taxonesUlti!=null && taxonesUlti.length>0){
						boolean vacio=false;
						if(taxonesUlti.length==1){
							boolean entradaLlena=false;
							boolean identiLleno=false;
							EntryVO entrada=taxonesUlti[0].getEntry();
							IdVO identificador=taxonesUlti[0].getId();
							if(entrada!=null && entrada.getTextos()!=null && entrada.getTextos().length>0 && !entradaLlena){
								for(int k=0;k<entrada.getTextos().length && !entradaLlena; k++){
									LangStringVO[] textosEntrada=entrada.getTextos();
									for(int m=0;m<textosEntrada.length && !entradaLlena;m++){
										if(textosEntrada[m].getTexto()!=null && !textosEntrada[m].getTexto().equals("")){
											entradaLlena=true;
										}
									}
								}
							}
							if(identificador!=null && identificador.getTexto()!=null && !identificador.getTexto().equals("")){
								identiLleno=true;
							}
							if((entradaLlena && identiLleno) || (!entradaLlena && ! identiLleno)){
								rutas[l].setTaxones(taxonesUlti);
								rutaLim.add(rutas[l]);
							}
							
						}else{
							vacio=false;
							for(int j=0;j<taxonesUlti.length && !vacio;j++){
								EntryVO entry=taxonesUlti[j].getEntry();
								IdVO id=taxonesUlti[j].getId();
								if(entry!=null && !vacio){
									LangStringVO[] lang=entry.getTextos();
									if(lang!=null && lang.length>0){
										boolean langLleno=false;
										for(int k=0;k<lang.length && !langLleno;k++){
											String texto=lang[k].getTexto();
											if(texto!=null || !texto.equals("")){
												langLleno=true;
												vacio=false;
											}else{
												vacio=true;
											}
										}
									}
								}else{
									vacio=true;
								}
								if(id!=null && !vacio){
									String ident=id.getTexto();
									if(ident==null || ident.equals("")){
										vacio=true;
									}
								}else{
									vacio=true;
								}
							}
							if(!vacio){
								rutaLim.add(rutas[l]);
							}
						}
						
					}else{
						TaxonVO[] taxonesAñadidos=new TaxonVO[1];
						TaxonVO taxonAñadido=new TaxonVO();
						EntryVO entry=new EntryVO();
						LangStringVO[] textos=new LangStringVO[1];
						LangStringVO texto=new LangStringVO();
						texto.setIdioma("");
						texto.setTexto("");
						textos[0]=texto;
						entry.setTextos(textos);
						taxonAñadido.setEntry(entry);
						IdVO id=new IdVO();
						id.setTexto("");
						taxonAñadido.setId(id);
						taxonesAñadidos[0]=taxonAñadido;
						rutas[l].setTaxones(taxonesAñadidos);
						rutaLim.add(rutas[l]);
					}
				}else{
					TaxonVO[] taxonesAñadidos=new TaxonVO[1];
					TaxonVO taxonAñadido=new TaxonVO();
					EntryVO entry=new EntryVO();
					LangStringVO[] textos=new LangStringVO[1];
					LangStringVO texto=new LangStringVO();
					texto.setIdioma("");
					texto.setTexto("");
					textos[0]=texto;
					entry.setTextos(textos);
					taxonAñadido.setEntry(entry);
					IdVO id=new IdVO();
					id.setTexto("");
					taxonAñadido.setId(id);
					taxonesAñadidos[0]=taxonAñadido;
					rutas[l].setTaxones(taxonesAñadidos);
					rutaLim.add(rutas[l]);
				}
				rutasLimpias=(RutaTaxonomicaVO[])rutaLim.toArray(new RutaTaxonomicaVO[rutaLim.size()]);
			}
		}else{
			rutasLimpias=new RutaTaxonomicaVO[0];
		}
		
		return rutasLimpias;
	}

	
	
	
	
	private void descifrarDuration(){
		//expresion regular duracion = P[yY][mM][dD][T[hH][nM][s[.s]S]]
		
		 Pattern mask=Pattern.compile("^P([0-9]+Y){0,1}([0-9]+M){0,1}([0-9]+D){0,1}(T([0-9]+H){0,1}([0-9]+M){0,1}([0-9]+(.[0-9]+){0,1}S){0,1}){0,1}$"); //ejm ee-zz
		 Matcher matcher = mask.matcher(duracion);
		 boolean correcto = matcher.matches();
		
		if(duracion != null && !duracion.equals("") && correcto && !duracion.equals("P") && !duracion.equals("PT")){
			//duracionAux = [yY][mM][dD][T[hH][nM][s[.s]S]]
			String duracionAux= duracion.substring(1, duracion.length());
			int posiT = duracionAux.indexOf("T");
			//duracionParteT = [hH][nM][s[.s]S]
			if (posiT < 0)
				posiT = duracionAux.length();
			else 
			{
				//duracionParteT = [hH][nM][s[.s]S]
				String duracionParteT=duracionAux.substring(posiT+1,duracionAux.length());
				int posiH=duracionParteT.indexOf("H");
				if (posiH > -1)
					horas = duracionParteT.substring(0, posiH);
				//duracionParteT = [nM][s[.s]S]
				duracionParteT = duracionParteT.substring(posiH+1, duracionParteT.length());
				int posiMi=duracionParteT.indexOf("M");
				if(posiMi > -1)
					minutos= duracionParteT.substring(0,posiMi);
				//duracionParteT = [s[.s]S]
				duracionParteT = duracionParteT.substring(posiMi+1, duracionParteT.length());
				int posiPunto = duracionParteT.indexOf(".");
				int posiS = duracionParteT.indexOf("S");
				if(posiS>-1){
					if (posiPunto < 0 && !duracionParteT.equals(""))
						segundosP1 = duracionParteT.substring(0, duracionParteT.length()-1);
					else{
						segundosP1 = duracionParteT.substring(0, posiPunto);
						segundosP2 = duracionParteT.substring(posiPunto+1, duracionParteT.length()-1);
					}
				}
				
			}
			//duracionResto = [yY][mM][dD]
			String duracionResto=duracionAux.substring(0,posiT);
			int posiY=duracionResto.indexOf("Y");
			if (posiY > -1)
				anyos=duracionResto.substring(0,posiY);
			//duracionResto = [mM][dD]
			duracionResto= duracionResto.substring(posiY+1,duracionResto.length());
			int posiM= duracionResto.indexOf("M");
			if (posiM > -1)
				meses=duracionResto.substring(0,posiM);
			//duracionResto = [dD]
			duracionResto = duracionResto.substring(posiM+1,duracionResto.length());
			int posiD= duracionResto.indexOf("D");
			if (posiD > -1)
			dias=duracionResto.substring(0,duracionResto.length()-1);	
		}
		else {
			anyos="";meses="";dias="";horas="";minutos="";segundosP1="";segundosP2="";
		}
	}

    private boolean validaEmail(String email){
        boolean resultado = true;

        Pattern pattern = Pattern.compile("^[A-Za-z0-9]([A-Za-z0-9.-_])*@[A-Za-z0-9]([A-Za-z0-9.-_])*.([A-Za-z0-9])+$");

        Matcher matcher = pattern.matcher(email.trim());

        if (!matcher.find()) {
              resultado = false;
        }

        return resultado;
  }


	//Metodo que recorre un directorio dado y sus subdirectorios y nos devuelve el nombre de los ficheros
	//C:\MDA\jboss-4.0.2/uploads\xmls\--> contiene
	// Dir 1.- arbolcurricular\ ..arbol_curricular_ca, ...nivel_educativo_es.xml ..
	// Dir 2.- taxonomias\ ...Arbol_curricular_LOE_2006_ca.xml...Nivel_educativo_LOM-ESv1.0_es.xml..
	// Dir 3.- tesauros\ ...ETB-LRE_MEC-CCAA_V.1.0_en.xml, ETB-LRE_MEC-CCAA_V.1.0_es.xml Nivel_educativo_LOM-ESv1.0_ca.xml
	public void recogeRutasDir(
			File dirBus, 
			String idioma, 
			Collection arr) 
	throws Exception 
	{ 
	    try{
	    	InputStream is = null;
	    	Properties prop = new Properties();
	    	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
 			prop.load(is);
 			
	    	String nuevoNomFich="";
	    	String completaFich="";
	    	String nombreFich="";
	    	if (dirBus.isDirectory()) {
	    		if((dirBus.toString().endsWith("arbolcurricular")) ||
	 	    		(dirBus.toString().endsWith("taxonomias"))){
	 	    			 completaFich="_TAX";
	 	    			 
	 	    	} else if (dirBus.toString().endsWith("tesauros")) {
	 	    			 completaFich="_TES";
	 	    	}
	    		String list[] = dirBus.list();
	    		for (int i = 0; i < list.length; i++)
	    		{
	    		  String[] nomAux=list[i].split("\\."); //error [Nivel_educativo_LOM-ESv1, 0_ca, xml] ó [Arbol_curricular_LOE_2006_ca, xml]
	    		  if (nomAux.length>1) {
	    			  int lnomAux=0;
	    			  if (nomAux.length>=2)
	    				  lnomAux = nomAux.length-2;
	    			else
	    				  lnomAux = nomAux.length-1;
	    			 
	    			  String [] nomFAux = nomAux[lnomAux].split("_"); //coge el ultimo: 0_ca,arbol_curricular_ca, 
		    		  if (nomFAux.length>1) {
		    			  int longi= nomFAux.length-1;
		    			  if (idioma.equals(nomFAux[longi])) { //comparamos los idiomas y si coinciden continuamos
		    				  int len = list[i].length();
		    				  nombreFich=list[i].substring(0, len-7);
		    				  nuevoNomFich=new StringBuffer(nombreFich).append(completaFich).toString();
		    				  //	cogemos los nombres
		    				  //en principio cogemos los nombres q coincidan del property, si no coinciden le ponemos el q viene
		    				  String lnom=list[i].substring(0, len-7);
		    				  String nomProp= prop.getProperty(lnom)!=null?prop.getProperty(lnom):lnom;
		    		   		  TerminoVO term = new TerminoVO();
							  term.setIdiomaTermino("");
							  term.setIdTermino(nuevoNomFich );
							  term.setNomTermino(lnom);
							  arr.add(term);
		    			  }
		    		  }
	    			}
	    		  
	    		}
	    	 }	
	    }catch(Exception e){
	      		throw new Exception ("Error!!!");
	      	}
	    }



}