/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePartDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.pode.catalogacion.negocio.servicios.ArbolCurricularVO;
import es.pode.catalogacion.negocio.servicios.CBTaxonVO;
import es.pode.catalogacion.negocio.servicios.ClassificationVO;
import es.pode.catalogacion.negocio.servicios.EducationalVO;
import es.pode.catalogacion.negocio.servicios.GeneralVO;
import es.pode.catalogacion.negocio.servicios.LomBasicoVO;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorBSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.validador.negocio.servicio.MDBasicosOblVO;
import es.pode.validador.negocio.servicio.ValidaVO;

/**
 * @see es.pode.catalogadorBasico.presentacion.catalogador.CatBasicoController
 */
public class CatBasicoControllerImpl extends CatBasicoController {
 
	protected static Logger logger = Logger
			.getLogger(CatBasicoControllerImpl.class); 
	private static final String HTTP ="http://";
	private static final String BARRA ="/";
	private static final String SEPARADOR =":";

	/**
	 * @see es.pode.catalogadorBasico.presentacion.catalogador.CatBasicoController#cargarDatos(org.apache.struts.action.ActionMapping,
	 *      es.pode.catalogadorBasico.presentacion.catalogador.CargarDatosForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	
	public final void cargarDatos(
			ActionMapping mapping,
			es.pode.catalogadorWeb.presentacion.catalogadorBasico.CargarDatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		InputStream is = null;
		try {
 
			
///////////////////////////////////////////////////////////////////////////////////////////
			ResourceBundle datosResources = I18n.getInstance().getResource(
						"application-resources", 
						(Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			String ficheroProperties = "/catalogadorBasico.properties";
			is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties prop = new Properties();
			prop.load(is);
////////////////////////////////////////////////////////////////////////////////////////////
			
			
			int longVocabulario = 0;

			String[] l_id = { prop.getProperty("idioma"),
					prop.getProperty("tipoDeRecurso"),
					prop.getProperty("idiomaDestinatario")};
			VocabularioVO[] vocabulario = this
					.getSrvVocabulariosControladosService().obtenerCombos(l_id,
							idioma);
			
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabularioOrdenado1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabularioOrdenado1.ordenarVocabulariosVO(vocabulario);				
			
			longVocabulario = vocabularioOrdenado.length;
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");
				switch (x) {
				case 0:
					Collection id = new ArrayList();
					id.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminos.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminos[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra="";
						if(!textoIdioma.equals("x-none")){
							idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idioma);
						}else{
							idiomasTra=datosResources.getString("x-none");
						}
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrd2 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrd = terminosOrd2.ordenarTerminosVO(terminos, idioma);						
					Collection id2 = Arrays
							.asList(terminosOrd);
					
					Iterator z = id2.iterator();
					while (z.hasNext()) {
						id.add(z.next());
					}
					
					form.setIdiomaBackingList(id, "idTermino", "nomTermino");
					break;
				case 1:
					Collection tRecurso = new ArrayList();
					tRecurso.add(terminoVO);
					Collection tRecurso2 = Arrays.asList(vocabularioOrdenado[x]
							.getTerminos());
					Iterator cont = tRecurso2.iterator();
					while (cont.hasNext()) {
						tRecurso.add(cont.next());
					}
					form.setTipoRecursoBackingList(tRecurso, "idTermino",
							"nomTermino");
					break;
				case 2:
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosIds = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosIds.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosIds[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idioma);
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosIdsOrd1 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosIdsOrd = terminosIdsOrd1.ordenarTerminosVO(terminosIds, idioma);					
					Collection idDest = new ArrayList();
					idDest.add(terminoVO);
					Collection idDest2 = Arrays.asList(terminosIdsOrd);
					Iterator cont2 = idDest2.iterator();
					while (cont2.hasNext()) {
						idDest.add(cont2.next());
					}
					form.setIdiomaDestinatarioBackingList(idDest, "idTermino",
							"nomTermino");
					break;
				}
				

			}
			if( logger.isDebugEnabled() ){

                logger.debug("Cargados los combos del formulario" );
			}


			// **********************************************************************************************
			CatalogadorBSession os = this.getCatalogadorBSession(request);
			LomBasicoVO lomBasico;
			
			
			if (os.getMBOSesion() == null) 
			{
			
			
					String usuario =LdapUserDetailsUtils.getUsuario();
					
					String identificador =request.getParameter("identificador");//"idLOM1";//
					//introducido nuevo parametro para vuelta al empaquetador
					String returnURL=request.getParameter("returnURL");
					//PortalEmpaquetador/Inicio/Inicio.do
					
					os.setIdioma(idioma);
					os.setIdentificador(identificador);
					os.setUsuario(usuario);
					//metemos en la sesion el parametro de vuelta al empaquetador
					os.setReturnURL(returnURL);
					

					lomBasico = this.getSrvCatalogacionBasicaService().obtenerLomBasico(identificador, usuario, idioma);
					if(lomBasico!=null)
					{
						if(lomBasico.getClassification()==null)
							lomBasico.setClassification(new ClassificationVO());
						if(lomBasico.getEducational()==null)
							lomBasico.setEducational(new EducationalVO());
						if(lomBasico.getGeneral()==null)
							lomBasico.setGeneral(new GeneralVO());
					}
					
					
					
					TerminoYPadreVO[] terminoypadrear = new TerminoYPadreVO[longVocabulario];

					for (int i = 0; i < longVocabulario; i++) {
					TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[i]);
					terminoypadreVO.setIdTermino("");
					switch (i) {
					case 0:
						if ((lomBasico.getGeneral() != null)&&(lomBasico.getGeneral().getIdioma() !=null)) {
							terminoypadreVO.setNomTermino(lomBasico.getGeneral().getIdioma()); //terminoYPadreVO rellenado con idioma desde el lom basico
						} else {
							terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con idioma desde el formulario
						}
						break;
					case 1:
						if ((lomBasico.getEducational() != null)&&(lomBasico.getEducational().getTipo() !=null)) {
							terminoypadreVO.setNomTermino(lomBasico
									.getEducational().getTipo());//terminoYPadre rellenado con tipo desde el lom basico
						} else {
							terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con tipo desde el formulario
						}

						break;
					case 2:
						if ((lomBasico.getEducational() != null)&&(lomBasico.getEducational().getIdiomaDest() !=null)) {
							terminoypadreVO.setNomTermino(lomBasico
									.getEducational().getIdiomaDest());//terminoYPadre rellenado con idioma destinatario desde el lom basico
						} else {
							terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con idioma destinatario desde el formulario
						}

						break;
					}

					terminoypadrear[i] = terminoypadreVO;
					
				}

				TerminoYPadreVO[] terminoYPadreVuelta = this
						.getSrvVocabulariosControladosService()
						.obtenerIdTermino(terminoypadrear);
				String idi = terminoYPadreVuelta[0].getIdTermino();//Se recoge el idtermino del idioma si lo hay
				if (idi == null) {
					idi = "";//No hay ningún idioma seleccionado por defecto
				}
				lomBasico.getGeneral().setIdioma(idi);
				
				idi = terminoYPadreVuelta[1].getIdTermino();
				if (idi == null) {
					idi = "";//No hay ningún tipo se recurso seleccionado por defecto
				}
				lomBasico.getEducational().setTipo(idi);
				
				idi = terminoYPadreVuelta[2].getIdTermino();
				if (idi == null) {
					idi = "";//No hay ningún idioma destinatario seleccionado por defecto
				}
				lomBasico.getEducational().setIdiomaDest(idi);
				
				lomBasico.getEducational().setContexto("");
				lomBasico.getEducational().setEdad("");
				lomBasico.getEducational().setProcesoCog("");
				
				this.getCatalogadorBSession(request).setMBOSesion(lomBasico);
			
			}
			
			
//			rellenar formulario
			if(os.getMBOSesion().getClassification()==null )
			{
				os.getMBOSesion().setClassification(new ClassificationVO());
			}	
			if (os.getMBOSesion().getClassification().getArbolesCurriculares() == null) {
				
				os.getMBOSesion().getClassification().setArbolesCurriculares(new ArbolCurricularVO[] {});
			}
			this.getCatalogadorBSession(request).setArbolesController(
					Arrays.asList(os.getMBOSesion().getClassification().getArbolesCurriculares()));
			
			
			form.setDescripcion(os.getMBOSesion().getGeneral().getDesc());
			form.setTipoRecurso(os.getMBOSesion().getEducational().getTipo());
			form.setTitulo(os.getMBOSesion().getGeneral().getTitulo());
			form.setIdioma(os.getMBOSesion().getGeneral().getIdioma());
			form.setIdiomaDestinatario(os.getMBOSesion().getEducational().getIdiomaDest());
			form.setArbolesAsArray(os.getMBOSesion().getClassification().getArbolesCurriculares());

			
		} catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.basico", ad);
			
		}catch (Exception e){
			logger.error("Error en Servicio de catalogacion, metodo cargarDatos" + e);
			throw new java.lang.Exception("catalogador.basico", e);
			
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		
		// **********************************************************************************************
	}

	public void cargarDatosGuardar(ActionMapping mapping,
			CargarDatosGuardarForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CatalogadorBSession os = this.getCatalogadorBSession(request); //Recogemos el objeto de sesión	

		LomBasicoVO lomDatosSesion = new LomBasicoVO();
		EducationalVO ed = new EducationalVO();
		GeneralVO gn = new GeneralVO();
		ClassificationVO cl = new ClassificationVO();
		ed.setIdiomaDest(form.getIdiomaDestinatario());//recogemos idioma destinatario desde el formulario y insertamos en educationalVO
		ed.setTipo(form.getTipoRecurso());//recogemos tipo de recurso desde el formulario y insertamos en educationalVO
		gn.setDesc(form.getDescripcion());//recogemos descripcion desde el formulario y insertamos en generalVO
		gn.setIdioma(form.getIdioma());//recogemos idioma desde el formulario y insertamos en generalVO
		gn.setTitulo(form.getTitulo());//recogemos titulo desde el formulario y insertamos en generalVO
		//recogemos los arboles de la sesion
		ArbolCurricularVO[] arboles=new ArbolCurricularVO[0];
		if (os.getArbolesController()!= null) {
			List dpr = Arrays.asList(os.getArbolesController().toArray());
			arboles = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
		}
		if (arboles !=null){
			cl.setArbolesCurriculares(arboles);
			lomDatosSesion.setClassification(cl);//insertamos los arboles no nulos en el lomBasicoVO
		}else{
			cl.setArbolesCurriculares(new ArbolCurricularVO[0]);
			lomDatosSesion.setClassification(cl);//insertamos el arbol nulo en el lomBasicoVO
		}
		
		lomDatosSesion.setEducational(ed);//insertamos el educationalVO en el lomBasicoVO
		lomDatosSesion.setGeneral(gn);//insertamos el generalVO en el lomBasicoVO
		os.setMBOSesion(lomDatosSesion);//insertamos el lomBasicoVO en el objeto de sesion
		
		String returnURL = this.getCatalogadorBSession(request).getReturnURL();
		os.setReturnURL(returnURL);
		this.setCatalogadorBSession(request, os);
		if( logger.isDebugEnabled() ){

            logger.debug("Insertamos los valores del formulario en el objeto de sesion" );
		}

	}

	private ArbolCurricularVO[] ordenaTaxonesEnArboles(ArbolCurricularVO[] arbolesAlrreves) {
	
		ArbolCurricularVO[] arbolOrdenado = null;
		ArrayList datos = new ArrayList();
		if (arbolesAlrreves != null) {
			CBTaxonVO [] taxones = new CBTaxonVO[0];
			for (int ina=0; ina < arbolesAlrreves.length; ina++){
				ArbolCurricularVO arbolOr = new ArbolCurricularVO();
				taxones= arbolesAlrreves[ina].getTaxones();
				int longitax= taxones.length;
				if (longitax>0) {
					String[] ultTax = taxones[longitax -1].getId().split("\\.");
					int longiUlt=ultTax.length;
					String[] iniTax = taxones[0].getId().split("\\.");
					int longiPrim = iniTax.length;
					if (longiPrim > longiUlt) { //estan al reves y hay que darle la vuelta
						//damos la vuelta a los taxones
						List taxonesLis = Arrays.asList(taxones);
						Collections.reverse(taxonesLis);
						CBTaxonVO [] taxOk = (CBTaxonVO []) taxonesLis.toArray(new CBTaxonVO [taxonesLis.size()]);
						arbolOr.setTaxones(taxOk);
						
					} else { //esta ordenado el arbol y lo metemos tal cual
						CBTaxonVO [] taxOk =arbolesAlrreves[ina].getTaxones();
						arbolOr.setTaxones(taxOk);
					}
					//el idArbol siempre lo metemos
					arbolOr.setIdArbol(arbolesAlrreves[ina].getIdArbol());
					datos.add(arbolOr);
				}
			}
		}
		arbolOrdenado = (ArbolCurricularVO[]) datos.toArray(new ArbolCurricularVO[datos.size()]);
		return arbolOrdenado;
	}
	
	private ArbolCurricularVO[] desordenaTaxonesEnArboles(ArbolCurricularVO[] arbolesAlrreves) {
		
		ArbolCurricularVO[] arbolOrdenado = null;
		ArrayList datos = new ArrayList();
		if (arbolesAlrreves != null) {
			CBTaxonVO [] taxones = new CBTaxonVO[0];
			for (int ina=0; ina < arbolesAlrreves.length; ina++){
				ArbolCurricularVO arbolOr = new ArbolCurricularVO();
				taxones= arbolesAlrreves[ina].getTaxones();
				int longitax= taxones.length;
				if (longitax>0) {
					String[] ultTax = taxones[longitax -1].getId().split("\\.");
					int longiUlt=ultTax.length;
					String[] iniTax = taxones[0].getId().split("\\.");
					int longiPrim = iniTax.length;
					if (longiPrim < longiUlt) { //estan al reves y hay que darle la vuelta
						//damos la vuelta a los taxones
						List taxonesLis = Arrays.asList(taxones);
						Collections.reverse(taxonesLis);
						CBTaxonVO [] taxOk = (CBTaxonVO []) taxonesLis.toArray(new CBTaxonVO [taxonesLis.size()]);
						arbolOr.setTaxones(taxOk);
						
					} else { //esta ordenado el arbol y lo metemos tal cual
						CBTaxonVO [] taxOk =arbolesAlrreves[ina].getTaxones();
						arbolOr.setTaxones(taxOk);
					}
					//el idArbol siempre lo metemos
					arbolOr.setIdArbol(arbolesAlrreves[ina].getIdArbol());
					datos.add(arbolOr);
				}
			}
		}
		arbolOrdenado = (ArbolCurricularVO[]) datos.toArray(new ArbolCurricularVO[datos.size()]);
		return arbolOrdenado;
	}
	/**
	 * @see es.pode.catalogadorBasico.presentacion.catalogador.CatBasicoController#guardarMetadatos(org.apache.struts.action.ActionMapping,
	 *      es.pode.catalogadorBasico.presentacion.catalogador.GuardarMetadatosForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void guardarMetadatos(
			ActionMapping mapping,
			es.pode.catalogadorWeb.presentacion.catalogadorBasico.GuardarMetadatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		InputStream is = null;
	
		try {
			String identificador;
			if (this.getCatalogadorBSession(request) == null) {
				identificador = request.getParameter("identificador");
			} else {
				identificador = this.getCatalogadorBSession(request)
						.getIdentificador();
			}
			String usuario =LdapUserDetailsUtils.getUsuario(); 
				//"user";//request.getParameter("usuario");
			//Recogemos el idioma del navegador
			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			
	        Properties prop = new Properties();
	        
			LomBasicoVO lomBasico = new LomBasicoVO();
			GeneralVO general = new GeneralVO();
			EducationalVO educational = new EducationalVO();
			ClassificationVO classification = new ClassificationVO();
			CatalogadorBSession os = this.getCatalogadorBSession(request);
			if (os != null) {//Recogidos los datos de la sesion e incluidas en los VO-s
				general.setIdioma(os.getMBOSesion().getGeneral().getIdioma());
				general.setTitulo(os.getMBOSesion().getGeneral().getTitulo());
				general.setDesc(os.getMBOSesion().getGeneral().getDesc());
				educational.setContexto("");
				educational.setTipo(os.getMBOSesion().getEducational().getTipo());
				educational.setEdad("");
				educational.setIdiomaDest(os.getMBOSesion().getEducational()
						.getIdiomaDest());
				educational.setProcesoCog("");
	
	//			recogemos los arboles de la sesion
				ArbolCurricularVO[] arbolesAlrreves=new ArbolCurricularVO[0];
				if (os.getArbolesController()!= null) {
					List dpr = Arrays.asList(os.getArbolesController().toArray());
					arbolesAlrreves = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
				}
				
				if (arbolesAlrreves !=null){
					//les damos la vuelta a los taxones para que los guarde en orden correcto
					ArbolCurricularVO[] arbolesOrdenados=new ArbolCurricularVO[0];
					arbolesOrdenados= ordenaTaxonesEnArboles(arbolesAlrreves);
					classification.setArbolesCurriculares(arbolesOrdenados);
					lomBasico.setClassification(classification);
				}
				
	            String[] idxatraduc = new String[3];
	            for ( int cont=0;cont<idxatraduc.length;cont++){
	                  switch (cont){
	                       case 0: idxatraduc[0]=general.getIdioma();
	                                   break;
	                       case 1: idxatraduc[1]=educational.getTipo();
	                                   break;
	                       case 2: idxatraduc[2]=educational.getIdiomaDest();
	                                   break;
	                  }
	
	            }
	            
	            
	            is= this.getClass().getResourceAsStream("/catalogadorBasico.properties");
	            prop.load(is);
	            String[] l_id = { prop.getProperty("idioma"),
				prop.getProperty("tipoDeRecurso"),
				prop.getProperty("idiomaDestinatario")};
		
	            TerminoYPadreVO[] terminosTraduc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(idxatraduc);
	            for (int cont=0;cont<terminosTraduc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	            	if (l_id[0].equals(terminosTraduc[cont].getIdVocabulario())){
	            		general.setIdioma(terminosTraduc[cont].getNomTermino());
	            	}
	            	else if (l_id[1].equals(terminosTraduc[cont].getIdVocabulario())){
	            		educational.setTipo(terminosTraduc[cont].getNomTermino());
	            	}
	            	else if (l_id[2].equals(terminosTraduc[cont].getIdVocabulario())){
	            		educational.setIdiomaDest(terminosTraduc[cont].getNomTermino());
	            	}
	
	            }
				
				lomBasico.setGeneral(general);
				lomBasico.setEducational(educational);
				lomBasico.setClassification(classification);
				if( logger.isDebugEnabled() ){

	                logger.debug("Añadidos en el lomBasico los datos de sesion en ingles" );
				}
			}
			 //llamada al servicio y modificacion de arboles de sesion
			 List arbolesCont= Arrays.asList(this.getSrvCatalogacionBasicaService().generarMetadatos(identificador,
					usuario, lomBasico, idioma).getClassification().getArbolesCurriculares());
			 
			 //	les damos la vuelta a los taxones para que los guarde en orden correcto
			 ArbolCurricularVO [] arboles = (ArbolCurricularVO[])arbolesCont.toArray(new ArbolCurricularVO[arbolesCont.size()]);
			ArbolCurricularVO[] arbolesOrdenados=desordenaTaxonesEnArboles(arboles);
			arbolesCont = Arrays.asList(arbolesOrdenados);
			 os.setArbolesController(arbolesCont);
			//actualizamos los datos en sesion
			if (os.getMBOSesion() != null) {
				os.getMBOSesion().getClassification().setArbolesCurriculares(arbolesOrdenados);//Añadidos los arboles curriculares en la sesion
			}
	
		} catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.basico", ad);
			
		}catch (Exception e) {
			logger.error("Error Catalogacion, metodo guardarMetadatos. " + e);
			throw new java.lang.Exception("catalogador.basico", e);
			
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

	public void cargarDatosSesion(ActionMapping mapping,
			CargarDatosSesionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		CatalogadorBSession os = this.getCatalogadorBSession(request);

		LomBasicoVO lomDatosSesion = new LomBasicoVO();
		EducationalVO ed = new EducationalVO();
		GeneralVO gn = new GeneralVO();
		ClassificationVO cl = new ClassificationVO();
		ed.setIdiomaDest(form.getIdiomaDestinatario());
		ed.setTipo(form.getTipoRecurso());
		gn.setDesc(form.getDescripcion());
		gn.setIdioma(form.getIdioma());
		gn.setTitulo(form.getTitulo());
		//recogemos los arboles de la sesion
		ArbolCurricularVO[] arboles=new ArbolCurricularVO[0];
		if (os != null){//Recogidos arboles curriculares desde el objeto de sesion
			if (os.getArbolesController()!= null) {
				List dpr = Arrays.asList(os.getArbolesController().toArray());
				arboles = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
			}
		}
		cl.setArbolesCurriculares(arboles);
		lomDatosSesion.setEducational(ed);
		lomDatosSesion.setGeneral(gn);
		lomDatosSesion.setClassification(cl);
		os.setMBOSesion(lomDatosSesion);
		this.setCatalogadorBSession(request, os);
	}

	public boolean sonValidosMDBO(ActionMapping mapping,
			SonValidosMDBOForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// despues de validar metadatos viene aqui donde comprobaremos si el
		// resultado es true o false
		Collection mensajes = new ArrayList();

		ValidaVO datos = form.getValida();


		if (datos != null) {
			// leemos los resultados de la validacion
			String mens = datos.getResultadoValidacion().toString();
			StringTokenizer token = new StringTokenizer(mens, ";");
			while (token.hasMoreElements()) {
				mensajes.add(token.nextElement().toString());
				// token.nextElement();
				
			}
			form.setMensajesError(mensajes);
			
		} else {
			datos.setEsValidoManifest(new Boolean(false));//Devuelve false para la validación
		}
		return datos.getEsValidoManifest().booleanValue();//Devuelve el resultado de la validación, true o false
		
	}

	public void validarMetadatos(ActionMapping mapping,
			ValidarMetadatosForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MDBasicosOblVO metadatosObl = new MDBasicosOblVO();
		metadatosObl.setTitulo(form.getTitulo());
		metadatosObl.setIdioma(form.getIdioma());
		metadatosObl.setDescripcion(form.getDescripcion());
		metadatosObl.setIdiomaDest(form.getIdiomaDestinatario());
		metadatosObl.setTipoRecurso(form.getTipoRecurso());
		metadatosObl.setContexto("");
		metadatosObl.setEdad("");
		metadatosObl.setProcesoCog("");
		
		CatalogadorBSession os = this.getCatalogadorBSession(request);

		LomBasicoVO lomDatosSesion = new LomBasicoVO();
		EducationalVO ed = new EducationalVO();
		GeneralVO gn = new GeneralVO();
		ClassificationVO cl = new ClassificationVO();
		ed.setIdiomaDest(form.getIdiomaDestinatario());
		ed.setTipo(form.getTipoRecurso());
		ed.setContexto("");
		ed.setEdad("");
		ed.setProcesoCog("");
		gn.setDesc(form.getDescripcion());
		gn.setIdioma(form.getIdioma());
		gn.setTitulo(form.getTitulo());
		if( logger.isDebugEnabled() ){

            logger.debug("Recogemos los campos del formulario" );
		}
		//recogemos los arboles
		ArbolCurricularVO[] arboles=new ArbolCurricularVO[0];
		if (os != null){//Recogemos los arboles del objeto de sesion
			if (os.getArbolesController()!= null) {
				List dpr = Arrays.asList(os.getArbolesController().toArray());
				arboles = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
			}
		}
		cl.setArbolesCurriculares(arboles);
		lomDatosSesion.setEducational(ed);
		lomDatosSesion.setGeneral(gn);
		lomDatosSesion.setClassification(cl);
		os.setMBOSesion(lomDatosSesion);
		this.setCatalogadorBSession(request, os);
		
		ValidaVO valida=null;
		try{
			valida = this.getSrvValidadorService().validarMDBasicosObl(metadatosObl);
		}catch (Exception e) {
			logger.error("CatalogadorBasico.validarMetadatos: error al llamar al servicio de validacion.");
		}
		form.setValida(valida);
		
	}

	public void eliminarArbol(ActionMapping mapping, EliminarArbolForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		boolean idArbolNoSeleccionado=false;
		try{
			CatalogadorBSession os = this.getCatalogadorBSession(request); //Recogemos el objeto de sesión	
	
			LomBasicoVO lomDatosSesion = new LomBasicoVO();
			EducationalVO ed = new EducationalVO();
			GeneralVO gn = new GeneralVO();
			ClassificationVO cl = new ClassificationVO();
			ed.setIdiomaDest(form.getIdiomaDestinatario());//recogemos idioma destinatario desde el formulario y insertamos en educationalVO
			ed.setTipo(form.getTipoRecurso());//recogemos tipo de recurso desde el formulario y insertamos en educationalVO
			ed.setContexto("");
			ed.setEdad("");
			ed.setProcesoCog("");
			gn.setDesc(form.getDescripcion());//recogemos descripcion desde el formulario y insertamos en generalVO
			gn.setIdioma(form.getIdioma());//recogemos idioma desde el formulario y insertamos en generalVO
			gn.setTitulo(form.getTitulo());//recogemos titulo desde el formulario y insertamos en generalVO
			//recogemos los arboles de la sesion
			ArbolCurricularVO[] arboles=new ArbolCurricularVO[0];
			if (os.getArbolesController()!= null) {
				List dpr = Arrays.asList(os.getArbolesController().toArray());
				arboles = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
			}
			if (arboles !=null){
				cl.setArbolesCurriculares(arboles);
				lomDatosSesion.setClassification(cl);//insertamos los arboles no nulos en el lomBasicoVO
			}else{
				cl.setArbolesCurriculares(new ArbolCurricularVO[0]);
				lomDatosSesion.setClassification(cl);//insertamos el arbol nulo en el lomBasicoVO
			}
			
			lomDatosSesion.setEducational(ed);//insertamos el educationalVO en el lomBasicoVO
			lomDatosSesion.setGeneral(gn);//insertamos el generalVO en el lomBasicoVO
			os.setMBOSesion(lomDatosSesion);//insertamos el lomBasicoVO en el objeto de sesion
			
			this.setCatalogadorBSession(request, os);
			if( logger.isDebugEnabled() ){
	
	            logger.debug("Insertamos los valores del formulario en el objeto de sesion" );
			}
			
	//		******************************************************************************
			String[] idArboles =(String[]) request.getParameterValues("idArbol");

			if(idArboles!=null && idArboles.length>0){
			
				LomBasicoVO lb= new LomBasicoVO();
				LomBasicoVO lb2;
				ClassificationVO cl2= new ClassificationVO();
				GeneralVO g= new GeneralVO();
				//Insertamos valores vacios en los campo
				g.setDesc("");
				g.setIdioma("");
				g.setTitulo("");
				EducationalVO ed2= new EducationalVO();
				ed2.setContexto("");
				ed2.setEdad("");
				ed2.setIdiomaDest("");
				ed2.setProcesoCog("");
				ed2.setTipo("");
				//recogemos los arboles del objeto de sesion
				ArbolCurricularVO[] datos=new ArbolCurricularVO[0];
				if (os != null){
					if (os.getArbolesController()!= null) {
						List dpr = Arrays.asList(os.getArbolesController().toArray());
						datos = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
					}
				}
					
			    if (datos != null) {	
				  cl2.setArbolesCurriculares(datos);//Insertamos los arboles no nulos en clasification
			    }else {
			    	datos = new ArbolCurricularVO[0];
			    	cl2.setArbolesCurriculares(datos);//Insertamos los arboles nulos en clasification
			    }
				lb.setGeneral(g);
				lb.setEducational(ed2);
				lb.setClassification(cl2);
				
				lb2= this.getSrvCatalogacionBasicaService().eliminarTaxonomiasEnLomBasico(lb, idArboles);
				//meto los arboles actuales en el objeto de sesion
				List datoAarbolController = Arrays.asList(lb2.getClassification().getArbolesCurriculares());
				os.setArbolesController(datoAarbolController);
				
				if (os.getMBOSesion() != null) {
					//convierto de Collection a array 
					datos =(ArbolCurricularVO[])datoAarbolController.toArray(new ArbolCurricularVO[datoAarbolController.size()]);
					os.getMBOSesion().getClassification().setArbolesCurriculares(datos);
				}
				if( logger.isDebugEnabled() ){
		
		            logger.debug("Insertamos los arboles en el objeto de sesion" );
				}
			}else {
				idArbolNoSeleccionado=true;
			}
		}catch (org.acegisecurity.AccessDeniedException ad) {
			  throw new Exception("catalogador.basico", ad);
			  
		} catch (Exception e) {
			logger.error("Error catBasico, método eliminarArbol " + e);
			throw new Exception("catalogador.basico", e);
		}
		//Cambiamos el ValidatorException, para que no sea capturado por el Exception y lanze la jsp de error
		if (idArbolNoSeleccionado)
		    throw new ValidatorException("{catalogadorBasico.EliminarTaxonomia}");
		
	}

	public void volverAEmpaquetador(ActionMapping mapping, VolverAEmpaquetadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Recogemos el parametro para ir a PortalEmpaquetador
		String returnUrl = this.getCatalogadorBSession(request).getReturnURL();
//		borramos datos de sesion
		request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY);
		
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

	public void realizarSubmit(ActionMapping mapping, RealizarSubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String accion = form.getAccionSubmit();
		
	}

	public String recogeAccion(ActionMapping mapping, RecogeAccionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Recogemos la accion a realizar
		String accion= form.getAccionSubmit();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasico.Aceptar").equals(accion)) {
			resAction = "Guardar";
		} else if (datosResources.getString("catalogadorBasico.Validar").equals(accion)) {
			resAction = "Validar";
		} else if (datosResources.getString("catalogadorBasico.ArbolCurricular").equals(accion)) {
			resAction = "Arbol Curricular";
		} else if( datosResources.getString("catalogadorBasico.Eliminar").equals(accion)) {
			resAction = "Eliminar";
		}else if( datosResources.getString("catalogadorBasico.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		}else if( accion==null || datosResources.getString("catalogadorBasico.Exportar").equals(accion) ) {
			resAction = "Exportar";
		}
		
		return resAction;
	}

	public void exportarLomes(
			ActionMapping mapping, 
			ExportarLomesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		CatalogadorBSession catBas= this.getCatalogadorBSession(request);
        final int BUFFER_SIZE = 2048;
        
    	DataHandler dh=null;
    	try{
    		dh= this.getSrvCatalogacionBasicaService().exportarLomes(catBas.getIdentificador(), catBas.getUsuario(), form.getLomExportar(), catBas.getIdioma());
    		
    	}catch (Exception e) {
    		logger.error(e);
    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
		}
    	    	
    	if(dh==null)
    	{
			logger.error("Fichero  vacio. Abortamos descarga.");
    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
    	}
    	
//    	 asignamos el titulo del fichero que vamos a exportar
    	

    	response.setContentType("text/xml;charset=utf-8");
    	response.setHeader("Content-Disposition", "attachment;filename=metadataLOMES.xml");
    	OutputStream out = response.getOutputStream();
    	InputStream in = dh.getInputStream();
    	logger.debug("Descargando metadata.xml");
		byte[] buffer = new byte[BUFFER_SIZE];
		int count;
		while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
		{
			out.write(buffer, 0, count);
		}
		
		out.flush();
	}

	public void validarExportar(
			ActionMapping mapping, 
			ValidarExportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String ficheroProperties = "/catalogadorBasico.properties";
		InputStream is;
		Properties prop = new Properties();
		MDBasicosOblVO metadatosObl = new MDBasicosOblVO();
		LomBasicoVO lomExportar= new LomBasicoVO();
		LomBasicoVO lomDatosSesion = this.getCatalogadorBSession(request).getMBOSesion();
		EducationalVO ed = new EducationalVO();
		GeneralVO gn = new GeneralVO();
		ClassificationVO cl = new ClassificationVO();


		
		is= this.getClass().getResourceAsStream(ficheroProperties);
		prop.load(is);

		if( form.getTitulo()!=null || form.getIdioma()!=null ||
				form.getDescripcion()!=null || form.getTipoRecurso()!=null ||
				form.getIdiomaDestinatario()!=null ||
				form.getArboles()!=null	)
			{

				ed.setIdiomaDest(form.getIdiomaDestinatario());
				ed.setTipo(form.getTipoRecurso());
				ed.setContexto("");
				ed.setEdad("");
				ed.setProcesoCog("");
				gn.setDesc(form.getDescripcion());
				gn.setIdioma(form.getIdioma());
				gn.setTitulo(form.getTitulo());
				
				if(lomDatosSesion!=null && lomDatosSesion.getEducational()!=null)
				{
					lomDatosSesion.getEducational().setIdiomaDest(form.getIdiomaDestinatario());
					lomDatosSesion.getEducational().setTipo(form.getTipoRecurso());
				}
				if(lomDatosSesion!=null && lomDatosSesion.getGeneral()!=null)
				{
					lomDatosSesion.getGeneral().setDesc(form.getDescripcion());
					lomDatosSesion.getGeneral().setIdioma(form.getIdioma());
					lomDatosSesion.getGeneral().setTitulo(form.getTitulo());
				}
				
				
			}else{

				ed.setIdiomaDest(lomDatosSesion.getEducational().getIdiomaDest()==null ? "" :lomDatosSesion.getEducational().getIdiomaDest() );
				ed.setTipo(lomDatosSesion.getEducational().getTipo()==null ? "" :lomDatosSesion.getEducational().getTipo() );
				ed.setContexto("");
				ed.setEdad("");
				ed.setProcesoCog("");
				gn.setDesc(lomDatosSesion.getGeneral().getDesc()==null ? "" :lomDatosSesion.getGeneral().getDesc() );
				gn.setIdioma(lomDatosSesion.getGeneral().getIdioma()==null ? "" :lomDatosSesion.getGeneral().getIdioma() );
				gn.setTitulo(lomDatosSesion.getGeneral().getTitulo()==null ? "" :lomDatosSesion.getGeneral().getTitulo() );
			}
		
		
//completo el objeto para validar		
		metadatosObl.setTitulo(gn.getTitulo() );
		metadatosObl.setIdioma(gn.getIdioma());
		metadatosObl.setDescripcion(gn.getDesc());
		metadatosObl.setIdiomaDest(ed.getIdiomaDest());
		metadatosObl.setTipoRecurso(ed.getTipo());
		metadatosObl.setContexto("");
		metadatosObl.setEdad("");
		metadatosObl.setProcesoCog("");
		
//		llamo al servicio validacion		
		ValidaVO valida=null;
		try{
			valida= this.getSrvValidadorService().validarMDBasicosObl(metadatosObl);  
				
		}catch (Exception e) {
			logger.error("CatalogadorBasico.validarExportar: error al llamar al servicio de validacion.");
    		throw new ValidatorException("{catalogadorBasico.exportar.advertencia.error}");
		}

		
		
			
//traduccion para exportar
        String[] idxatraduc = new String[3];
        for ( int cont=0;cont<idxatraduc.length;cont++){
              switch (cont){
                   case 0: idxatraduc[0]=gn.getIdioma();
                               break;
                   case 1: idxatraduc[1]=ed.getTipo();
                               break;
                   case 2: idxatraduc[2]=ed.getIdiomaDest();
                               break;
              }

        }
        
        
        String[] l_id = { prop.getProperty("idioma"),
		prop.getProperty("tipoDeRecurso"),
		prop.getProperty("idiomaDestinatario")};

        TerminoYPadreVO[] terminosTraduc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(idxatraduc);
        for (int cont=0;cont<terminosTraduc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
        	if (l_id[0].equals(terminosTraduc[cont].getIdVocabulario())){
        		gn.setIdioma(terminosTraduc[cont].getNomTermino());
        	}
        	else if (l_id[1].equals(terminosTraduc[cont].getIdVocabulario())){
        		ed.setTipo(terminosTraduc[cont].getNomTermino());
        	}
        	else if (l_id[2].equals(terminosTraduc[cont].getIdVocabulario())){
        		ed.setIdiomaDest(terminosTraduc[cont].getNomTermino());
        	}

        }


		
		//recogemos los arboles
		ArbolCurricularVO[] arboles=new ArbolCurricularVO[0];
		if (this.getCatalogadorBSession(request) != null){//Recogemos los arboles del objeto de sesion
			if (this.getCatalogadorBSession(request).getArbolesController()!= null) {
				List dpr = Arrays.asList(this.getCatalogadorBSession(request).getArbolesController().toArray());
				arboles = (ArbolCurricularVO[])dpr.toArray(new ArbolCurricularVO[dpr.size()]);
			}
		}
		cl.setArbolesCurriculares(arboles);
		lomExportar.setEducational(ed);
		lomExportar.setGeneral(gn);
		lomExportar.setClassification(cl);
			

			
		
		form.setValida(valida);
		form.setLomExportar(lomExportar);
	}

	public boolean sonValidosExportar(
			ActionMapping mapping, 
			SonValidosExportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{

		Collection mensajes = new ArrayList();

		ValidaVO datos = form.getValida();


		if (datos != null) {
			// leemos los errores de validacion
			String mens = datos.getResultadoValidacion().toString();
			StringTokenizer token = new StringTokenizer(mens, ";");
			while (token.hasMoreElements()) {
				mensajes.add(token.nextElement().toString());
				// token.nextElement();
				
			}
			form.setMensajesError(mensajes);
			
		} else {
			datos.setEsValidoManifest(new Boolean(false));//Devuelve false para la validación
		}
		return datos.getEsValidoManifest().booleanValue();//Devuelve el resultado de la validación, true o false

	}


	public String submitAdvertenciaExportar(
			ActionMapping mapping, 
			SubmitAdvertenciaExportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String accion= form.getAccion();
		String resAction = "";
		
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasico.exportar.advertencia.exportar").equals(accion)) {
			resAction = "Exportar";
		} else if (datosResources.getString("catalogadorBasico.exportar.advertencia.volver").equals(accion)) {
			resAction = "Volver";
		}else{
			resAction = "Volver";
		}
		
		return resAction;

	}


	public boolean actualizados(
			ActionMapping mapping, 
			ActualizadosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		return form.isActualizados();
		
	}

	public void chequearDatos(
			ActionMapping mapping, 
			ChequearDatosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		if( form.getTitulo()==null && form.getIdioma()==null &&
			form.getDescripcion()==null && form.getTipoRecurso()==null &&
			form.getIdiomaDestinatario()==null && 
			form.getArboles()==null	)
		{
//			verifico si el lomes esta vacío, si es asi, indico que está 
//			actualizado para que se salte la pantalla de advertencia y siga a la pantalla de lomes no válido
			if(lomesVacio(request ))  
				form.setActualizados(true);
			else
				form.setActualizados(false);
		}else{
			form.setActualizados(true);
			
		}
		
	}

	
	private boolean lomesVacio(HttpServletRequest request)
	throws Exception
	{
		boolean resultado= true;
		LomBasicoVO lom= this.getCatalogadorBSession(request).getMBOSesion();
		Collection arboles= this.getCatalogadorBSession(request).getArbolesController();
		if(lom!=null){
			if(lom.getGeneral()!=null && 
			   lom.getGeneral().getTitulo()!=null && !lom.getGeneral().getTitulo().equals("") &&
			   lom.getGeneral().getIdioma()!=null && !lom.getGeneral().getIdioma().equals("") &&
			   lom.getGeneral().getDesc()!=null && !lom.getGeneral().getDesc().equals(""))
				resultado=false;
			if(lom.getEducational()!=null &&
			   lom.getEducational().getTipo()!=null && !lom.getEducational().getTipo().equals("") &&
			   lom.getEducational().getIdiomaDest()!=null && !lom.getEducational().getIdiomaDest().equals("")  
			   )
				resultado=false;
			if(arboles!=null && arboles.size()>0)
				resultado=false;
		}
		return resultado;
	}

	
	
	public String comprobarLomesVacio(
			ActionMapping mapping, 
			ComprobarLomesVacioForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		String resultado="Vacio";
		try{
			if(!lomesVacio(request))
				resultado="NoVacio";
		}catch(Exception e )
		{
			logger.debug("error comprobando lomes vacio");
		}
		
		return resultado;
		
	}

	public void subirFichero(
			ActionMapping mapping, 
			SubirFicheroForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String ficheroProperties = "/catalogadorBasico.properties";
		InputStream is;
		try{
			is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties prop = new Properties();
			prop.load(is);
	
			
			DataHandler dh= this.getCatalogadorBSession(request).getLomesImportado();
	
			// llamo al servicio de catalogacion para obtener un LomAvanzadoVO
	    	LomBasicoVO lom=null;
	    	try{
	    		lom = this.getSrvCatalogacionBasicaService().importarLomes(dh,this.getCatalogadorBSession(request).getIdioma());
	    	}catch(Exception e)
	    	{
				if (logger.isDebugEnabled()) {logger.debug("error al llamar al servicio");}
				this.saveErrorMessage(request, "catalogadorBasico.importar.error");
	    	}
	    	
	    	if(lom!=null)
	    	{
	    		//busco las traducciones
	    		String[] l_id = { prop.getProperty("idioma"),
						prop.getProperty("tipoDeRecurso"),
						prop.getProperty("idiomaDestinatario")};
	    		VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,this.getCatalogadorBSession(request).getIdioma());
	    		//vamos a ordenar vocabulario
				UtilidadesOrdenarCombos vocabularioOrdenado1 = new UtilidadesOrdenarCombos();
				VocabularioVO[] vocabularioOrdenado = vocabularioOrdenado1.ordenarVocabulariosVO(vocabulario);				
				
				int longVocabulario = vocabularioOrdenado.length;
	   		
				TerminoYPadreVO[] terminoypadrear = new TerminoYPadreVO[longVocabulario];
				for (int i = 0; i < longVocabulario; i++) {
					TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[i]);
					terminoypadreVO.setIdTermino("");
					switch (i) {
					case 0:
						if ((lom.getGeneral() != null)&&(lom.getGeneral().getIdioma() !=null)) {
							terminoypadreVO.setNomTermino(lom.getGeneral().getIdioma()); //terminoYPadreVO rellenado con idioma desde el lom basico
						} else {
							terminoypadreVO.setNomTermino("");
						}
						break;
					case 1:
						if ((lom.getEducational() != null)&&(lom.getEducational().getTipo() !=null)) {
							terminoypadreVO.setNomTermino(lom.getEducational().getTipo());//terminoYPadre rellenado con tipo desde el lom basico
						} else {
							terminoypadreVO.setNomTermino("");
						}
	
						break;
					case 2:
						if ((lom.getEducational() != null)&&(lom.getEducational().getIdiomaDest() !=null)) {
							terminoypadreVO.setNomTermino(lom.getEducational().getIdiomaDest());//terminoYPadre rellenado con idioma destinatario desde el lom basico
						} else {
							terminoypadreVO.setNomTermino("");
						}
	
						break;
					}
	
					terminoypadrear[i] = terminoypadreVO;
					
					if( logger.isDebugEnabled() ){
	
		                logger.debug("Rellenado terminoypadreVO["+i+"] con los datos del lom basico" );
					}
				}
	
				TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(terminoypadrear);
	
				String idi = terminoYPadreVuelta[0].getIdTermino();//Se recoge el idtermino del idioma si lo hay
				if (idi == null) {
					idi = "";//No hay ningún idioma seleccionado por defecto
				}
				lom.getGeneral().setIdioma(idi);
				
				idi = terminoYPadreVuelta[1].getIdTermino();
				if (idi == null) {
					idi = "";//No hay ningún tipo se recurso seleccionado por defecto
				}
				lom.getEducational().setTipo(idi);
				
				idi = terminoYPadreVuelta[2].getIdTermino();
				if (idi == null) {
					idi = "";//No hay ningún idioma destinatario seleccionado por defecto
				}
				lom.getEducational().setIdiomaDest(idi);
	    		
	    		
	    		//mensaje de exito
				this.saveSuccessMessage(request, "catalogadorBasico.importar.exito");
		    	// cargo el lomavanzado obtenido en sesion
				this.getCatalogadorBSession(request).setMBOSesion(lom);
	    	}
	    	//elimino el lomes importado de sesion
	    	this.getCatalogadorBSession(request).setLomesImportado(null);
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("catalogador.basico", ad);
			
		}catch (Exception e) {
			logger.error("error en el catBasicoController, método subirFichero");
			throw new java.lang.Exception("catalogador.basico", e);
		}
}

	public String submitAdvertenciaImportar(
			ActionMapping mapping, 
			SubmitAdvertenciaImportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		String accion= form.getAccion();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasico.importar.advertencia.aceptar").equals(accion)) {
			resAction = "Aceptar";
		} else if (datosResources.getString("catalogadorBasico.importar.advertencia.cancelar").equals(accion)) {
			resAction = "Cancelar";
		}
		
		return resAction;

	}

	public String submitImportar(
			ActionMapping mapping, 
			SubmitImportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		String accion= form.getAccion();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		if (datosResources.getString("catalogadorBasico.importar.aceptar").equals(accion)) {
			resAction = "Aceptar";
			
	    	if(form.getFichero()==null || form.getFichero().getFileName().equals("") )
	    		throw new ValidatorException("{catalogadorBasico.importar.error.ficherovacio}");
	    	
	    	//crear el datahandler
			InternetHeaders ih = new InternetHeaders();
			MimeBodyPart mbp = null;
			DataSource source = null;
			DataHandler dh = null;
			try
			{
				FormFile ff=(FormFile) form.getFichero();
				mbp = new MimeBodyPart(ih, ff.getFileData());
				source = new MimePartDataSource(mbp);
				dh = new DataHandler(source);
			}catch (Exception e) {
				if (logger.isDebugEnabled()) {logger.debug("error al crear el datahandler");}
				throw new ValidatorException("{catalogadorBasico.importar.error}");
			}

	    	//validar el fichero
	    	Boolean valido= new Boolean(false);
	    	try{
	    		valido= this.getSrvValidadorService().obtenerValidacionLomes(dh);
	    	}catch(Exception e)
	    	{
				if (logger.isDebugEnabled()) {logger.debug("error al llamar al servicio de validación");}
				throw new ValidatorException("{catalogadorBasico.importar.error.novalido}");
	    	}
			
	    	if(!valido.booleanValue())
	    		throw new ValidatorException("{catalogadorBasico.importar.error.novalido}");
			
			//agregar el datahandler a sesion
			this.getCatalogadorBSession(request).setLomesImportado(dh);
			

			
		} else if (datosResources.getString("catalogadorBasico.importar.cancelar").equals(accion)) {
			resAction = "Cancelar";
		}
		
		return resAction;

	}

	public String guardarDatos(ActionMapping mapping, GuardarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Recogemos la accion a realizar
		String accion= form.getAccion();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasico.AceptarGuardar").equals(accion)) {
			resAction = "AceptarGuardar";
		} else if (datosResources.getString("catalogadorBasico.NoGuardar").equals(accion)) {
			resAction = "NoGuardar";
		} else if( datosResources.getString("catalogadorBasico.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		}
		
		return resAction;
	}
}