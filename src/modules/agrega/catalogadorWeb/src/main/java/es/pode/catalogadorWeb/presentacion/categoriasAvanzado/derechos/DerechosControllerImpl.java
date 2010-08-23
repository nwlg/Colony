/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.catalogacion.negocio.servicios.AccesoVO;
import es.pode.catalogacion.negocio.servicios.AvEducationalVO;
import es.pode.catalogacion.negocio.servicios.AvRightsVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.soporte.DerechosDeAutor;
import es.pode.catalogacion.soporte.TiposDeRecursos;
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
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.derechosController
 */
public class DerechosControllerImpl extends DerechosController
{ 
	//FAlta el ambito del acceso
  	private DescripcionVO[] descripciones;
  	private String coste;
  	private String copyright;
  	private String tipoAcceso;
  	private String[] comunidades;

	protected static Logger logger = Logger.getLogger(DerechosControllerImpl.class); 
	
	public String accionSubmit(
			ActionMapping mapping, 
			AccionSubmitForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String accion;
		if(form.getAccion()==null || form.getAccion().equals("")){
			accion= obtenerAccion(request);
			form.setAccion(accion);
		}
		else
			accion=form.getAccion();

		String[] accionPartes = accion.split("-");
		accion = accionPartes[0];
		if (accionPartes.length  > 1){
			request.setAttribute("posicion", accionPartes[1]);
		}
        String resAction = "";
        //String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
//		if (datosResources.getString("derechos.AñadirDescripcion").equals(accion)) {
//			resAction = "Añadir";
//		}else if (datosResources.getString("derechos.EliminarDescripcion").equals(accion)) {
//			resAction = "Eliminar";
//		}else 
		if (datosResources.getString("derechos.Validar").equals(accion)) {
			resAction = "Validar";
		}else if (datosResources.getString("derechos.Aceptar").equals(accion)) {
			resAction = "Aceptar";
		} else if (datosResources.getString("derechos.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		} else if (datosResources.getString("derechos.Reset").equals(accion)) {
			resAction = "Reset";
		} else 
			resAction = accion;
		return resAction;
	}

	public void anadirDescripcion(
			ActionMapping mapping, 
			AnadirDescripcionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		InputStream is =null;
		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
		Properties prop = new Properties();
		prop.load(is);
		
		Object valor = request.getSession().getAttribute("form");
		try{ 
			if (valor instanceof DerechosFormImpl) {
				DerechosFormImpl formulario = (DerechosFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setDescripciones(formulario.getDescripciones());  
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoComunidades(formulario.getListadoComunidades());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}else if (valor instanceof DerechosFormSubmitFormFormImpl) {
				DerechosFormSubmitFormFormImpl formulario = (DerechosFormSubmitFormFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setDescripciones(formulario.getDescripciones());  
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoComunidades(formulario.getListadoComunidades());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}else if (valor instanceof ValidoNoOKVolverFormImpl) {
				ValidoNoOKVolverFormImpl formulario = (ValidoNoOKVolverFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setDescripciones(formulario.getDescripciones());  
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoComunidades(formulario.getListadoComunidades());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}else if (valor instanceof ValidoOKVolverFormImpl) {
				ValidoOKVolverFormImpl formulario = (ValidoOKVolverFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setDescripciones(formulario.getDescripciones());  
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoComunidades(formulario.getListadoComunidades());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}
	  	
		  	int longitudDescripciones=((DescripcionVO)(form.getDescripcionesAsArray()[0])).getTextos().length;
		  
		  	cambioFormulario(request,longitudDescripciones,null);
		  
		   	if (form.getTipoAcceso().equals(prop.getProperty("acceso.universal"))) {
		   		//marco el cero -->todas
	        	ArrayList uno= new ArrayList();
	        	uno.add("MEC");
	        	comunidades= (String[]) uno.toArray(new String[uno.size()]);
		   	}
		   form.setListadoComunidades(comunidades);
	       //descripciones
	       form.setDescripcionesAsArray(descripciones);
	        
	       DescripcionVO[] aDescripciones=(DescripcionVO[])form.getDescripcionesAsArray();
	       LangStringVO[] lLang=aDescripciones[0].getTextos();
	       
	       int nuevoTamano = lLang.length +1;
	       LangStringVO[] newALang = new LangStringVO[nuevoTamano];
		   LangStringVO descripcionVO=new LangStringVO();
		   
		   descripcionVO.setIdioma("");
		   descripcionVO.setTexto("");
		   
	
		   for(int i = 0; i<lLang.length;i++)
			   newALang[i]=lLang[i];
		   newALang[nuevoTamano-1]= descripcionVO;
		   aDescripciones[0].setTextos(newALang);
		   form.setDescripcionesAsArray(aDescripciones);
		
        }catch (org.acegisecurity.AccessDeniedException ad) {
        	logger.error("Error de Acceso. " + ad);
        	throw new java.lang.Exception("derechos", ad);
        	}
    		catch (IndexOutOfBoundsException ai) {
    			logger
    			.warn("Warning en catalogadorWeb, categoría Derechos, metodo anadirDescripcion" + ai);
    	    }
    		catch (Exception ad) {	
    			logger
    			.error("Error en catalogadorWeb, categoría Derechos, metodo anadirDescripcion" + ad);
    			throw new java.lang.Exception("derechos", ad);
            }
		
	}

	public void cargarDatos(
			ActionMapping mapping, 
			CargarDatosForm form, 
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
//					obtenemos todos derechos de autor que luego filtraremos segun los tipos de recursos
					Collection tCopyright2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					
					/* MCA: This bit seems tied to some kind of user right so hard-coding to enable...
					AvEducationalVO[] usosEducativos = catalogadorAvSession.getMDSesion().getEducational();
					//si no tenemos usos educativos cargamos el combo derechos de autor vacio
					//si tenemos algun uso educativos cargamos el combo segun los tipos de recurso
					if(usosEducativos!=null && usosEducativos.length>0){
						tCopyright2 = this.filtrarDerechos(tCopyright2,usosEducativos,prop.getProperty("tipoRecursoAprendizaje"));
						Iterator cont1 = tCopyright2.iterator();
						while (cont1.hasNext()) {
							tCopyright.add(cont1.next());
						}
					}
					*/
					
					/* MCA: here is the hard-coded bit */
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
			logger.debug("Cargados los combos");
				
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
//        		if(ccaa.equals("") && catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo()!=null && 
//        				catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor()!=null
//        				&& catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor().equalsIgnoreCase("universal") )
//        			ccaa="MEC";
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
            
            //si derechos era null en el objeto de session lo dejamos a null
            if(derechosEsNull)
            	catalogadorAvSession.getMDSesion().setDerechos(null);
            
        }catch (org.acegisecurity.AccessDeniedException ad) {
        	logger.error("Error de Acceso. " + ad);
        	throw new java.lang.Exception("derechos", ad);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogadorWeb, categoría Derechos, metodo cargarDerechos" + e);
			throw new java.lang.Exception("derechos", e);
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

	public void eliminarDescripcion(
			ActionMapping mapping, 
			EliminarDescripcionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		try{
			InputStream is =null;
			is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			Properties prop = new Properties();
			prop.load(is);
			
        	Object valor = request.getSession().getAttribute("form");
          
    		if (valor instanceof DerechosFormImpl) {
    			DerechosFormImpl formulario = (DerechosFormImpl) valor;
    	      	form.setCosteLabelList(formulario.getCosteLabelList());
    	      	form.setCosteValueList(formulario.getCosteValueList());
    	      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
    	      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
    	      	form.setDescripciones(formulario.getDescripciones());  
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
    	      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
    	      	form.setListadoComunidades(formulario.getListadoComunidades());
    	      	form.setListadoNodos(formulario.getListadoNodos());
    		}else if (valor instanceof DerechosFormSubmitFormFormImpl) {
    			DerechosFormSubmitFormFormImpl formulario = (DerechosFormSubmitFormFormImpl) valor;
    	      	form.setCosteLabelList(formulario.getCosteLabelList());
    	      	form.setCosteValueList(formulario.getCosteValueList());
    	      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
    	      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
    	      	form.setDescripciones(formulario.getDescripciones());  
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
    	      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
    	      	form.setListadoComunidades(formulario.getListadoComunidades());
    	      	form.setListadoNodos(formulario.getListadoNodos());
    		}else if (valor instanceof ValidoNoOKVolverFormImpl) {
    			ValidoNoOKVolverFormImpl formulario = (ValidoNoOKVolverFormImpl) valor;
    	      	form.setCosteLabelList(formulario.getCosteLabelList());
    	      	form.setCosteValueList(formulario.getCosteValueList());
    	      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
    	      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
    	      	form.setDescripciones(formulario.getDescripciones());  
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
    	      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
    	      	form.setListadoComunidades(formulario.getListadoComunidades());
    	      	form.setListadoNodos(formulario.getListadoNodos());
    		}else if (valor instanceof ValidoOKVolverFormImpl) {
    			ValidoOKVolverFormImpl formulario = (ValidoOKVolverFormImpl) valor;
    	      	form.setCosteLabelList(formulario.getCosteLabelList());
    	      	form.setCosteValueList(formulario.getCosteValueList());
    	      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
    	      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
    	      	form.setDescripciones(formulario.getDescripciones());  
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
    	      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
    	      	form.setListadoComunidades(formulario.getListadoComunidades());
    	      	form.setListadoNodos(formulario.getListadoNodos());
    		}
      	
        	
        	int longitudDescripciones=((DescripcionVO)(form.getDescripcionesAsArray()[0])).getTextos().length;
        	
        	cambioFormulario(request,longitudDescripciones,null);

            //descripciones
            form.setDescripcionesAsArray(descripciones); 	
         	
            if (form.getTipoAcceso().equals(prop.getProperty("acceso.universal"))) {
    	   		//marco el cero -->todas
            	ArrayList uno= new ArrayList();
            	uno.add("MEC");
            	comunidades= (String[]) uno.toArray(new String[uno.size()]);
    	   	}
            form.setListadoComunidades(comunidades);
            
            //posicion del identificador que se quiere eliminar   
        	String posicion = request.getAttribute("posicion").toString();
           int posicionInt = Integer.parseInt(posicion);
           DescripcionVO[] aDescripciones=(DescripcionVO[])form.getDescripcionesAsArray();
           LangStringVO[] aLang=aDescripciones[0].getTextos();
           LangStringVO[] nuevoLang=new LangStringVO[aLang.length-1];
    	   
	     	//añado al nuevo array de identificadores todos los identificadores menos el que 
	     	//queremos eliminar
	     	for (int i = 0; i<nuevoLang.length;i++){
	     		if (i < posicionInt)
	     			nuevoLang[i] = aLang[i];
	     		else
	     			nuevoLang[i] = aLang[i+1]; 
	     	}
	     	aDescripciones[0].setTextos(nuevoLang);
	     	form.setDescripcionesAsArray(aDescripciones);

        }catch (org.acegisecurity.AccessDeniedException ad) {
        	logger.error("Error de Acceso. " + ad);
        	throw new java.lang.Exception("derechos", ad);
        	}
    		catch (IndexOutOfBoundsException ai) {
    			logger
    			.warn("Warning en catalogadorWeb, categoría Derechos, metodo eliminarDescripcion" + ai);
    	    }
    		catch (Exception ad) {	
    			logger
    			.error("Error en catalogadorWeb, categoría Derechos, metodo eliminarDescripcion" + ad);
    			throw new java.lang.Exception("derechos", ad);
            }
		
	}

	public boolean esValidoDerechos(
			ActionMapping mapping, 
			EsValidoDerechosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		InputStream is =null;
		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
 	    
		Properties prop = new Properties();
		prop.load(is);
		
    	Object valor = request.getSession().getAttribute("form");

    	int longitudDescripciones=0;
//    	int longiComu=0;
    	if (valor instanceof DerechosFormImpl) {
    		DerechosFormImpl formulario= (DerechosFormImpl) valor;
    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
        	longitudDescripciones=desc[0].getTextos().length;
        }else if (valor instanceof DerechosFormSubmitFormFormImpl) {
        	DerechosFormSubmitFormFormImpl formulario= (DerechosFormSubmitFormFormImpl) valor;
    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
        	longitudDescripciones=desc[0].getTextos().length;
        }else if (valor instanceof ValidoOKVolverFormImpl) {
        	ValidoOKVolverFormImpl formulario= (ValidoOKVolverFormImpl) valor;
    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
        	longitudDescripciones=desc[0].getTextos().length;
        }else if (valor instanceof ValidoNoOKVolverFormImpl) {
        	ValidoNoOKVolverFormImpl formulario= (ValidoNoOKVolverFormImpl) valor;
    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
        	longitudDescripciones=desc[0].getTextos().length;
        }
    		
    	cambioFormulario(request,longitudDescripciones, valor);
    	
    	DescripcionVO[] 	descripcionesAux = new DescripcionVO[1];
    	LangStringVO[] langDescAux = new LangStringVO[descripciones[0].getTextos().length];
    	for(int i=0;i<descripciones[0].getTextos().length;i++){
    		LangStringVO nuevoLang = new LangStringVO();
    		nuevoLang.setIdioma(descripciones[0].getTextos()[i].getIdioma());
    		nuevoLang.setTexto(descripciones[0].getTextos()[i].getTexto());
    		langDescAux[i] = nuevoLang;
    	}
    	DescripcionVO descAux= new DescripcionVO();
    	descAux.setTextos(langDescAux);
    	descripcionesAux[0]=descAux;
    	
    	if (valor instanceof DerechosFormImpl) {
    		DerechosFormImpl formulario= (DerechosFormImpl) valor;
    		formulario.setDescripcionesAsArray(descripcionesAux);
    		formulario.setListadoComunidades(comunidades);
    	}else if (valor instanceof DerechosFormSubmitFormFormImpl) {
    		DerechosFormSubmitFormFormImpl formulario= (DerechosFormSubmitFormFormImpl) valor;
    		formulario.setDescripcionesAsArray(descripcionesAux);
    		formulario.setListadoComunidades(comunidades);
    	}else if (valor instanceof ValidoNoOKVolverFormImpl) {
    		ValidoNoOKVolverFormImpl formulario= (ValidoNoOKVolverFormImpl) valor;
    		formulario.setDescripcionesAsArray(descripcionesAux);
    		formulario.setListadoComunidades(comunidades);
    	}else if (valor instanceof ValidoOKVolverFormImpl) {
    		ValidoOKVolverFormImpl formulario= (ValidoOKVolverFormImpl) valor;
    		formulario.setDescripcionesAsArray(descripcionesAux);
    		formulario.setListadoComunidades(comunidades);
    	}

    	coste=form.getCoste();
    	copyright=form.getCopyRestricciones();
    	tipoAcceso=form.getTipoAcceso();

    	
    	Collection mensajes=new ArrayList();
    	//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

    	//COPYRIGHT 
    	if(copyright==null || copyright.equals(""))
    	{
    		mensajes.add(datosResources.getString("CAV.6.2"));
    	}
    	
    	//ACCESO
    	if(tipoAcceso==null || tipoAcceso.equals(""))
    	{
    		mensajes.add(datosResources.getString("CAV.6.4.1"));
    	}
    	
    	//AMBITO
    	if(comunidades==null || comunidades.length==0)
    	{
    		mensajes.add(datosResources.getString("CAV.6.4.2"));//Es necesario seleccionar al menos un &aacute;mbito
    	}
    	
		if(mensajes.size()>0)
		{
			form.setMensajesError(mensajes);
			return false;
		}else{
			return true;
		}

	}

	public void guardarDerechos(
			ActionMapping mapping, 
			GuardarDerechosForm form, 
			HttpServletRequest request,
			HttpServletResponse response) 
	throws Exception 
	{
		
		InputStream is =null;
		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
		boolean errorFaltaIdioma = false;
 	    boolean errorFaltaTexto = false;
 	    boolean errorAcceso = false;
 	    boolean errorAccesoUniversal = false;
 	    boolean errorAccesoNoUniversal = false;
 	    
		Properties prop = new Properties();
		prop.load(is);
		
    	Object valor = request.getSession().getAttribute("form");

    	int longitudDescripciones=0;
    	int longiComu=0;
    	try{
	    	if (valor instanceof DerechosFormImpl) {
	    		DerechosFormImpl formulario= (DerechosFormImpl) valor;
	    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
	        	longitudDescripciones=desc[0].getTextos().length;
	        	form.setListadoNodos(formulario.getListadoNodos());
	        }
	    	else if (valor instanceof DerechosFormSubmitFormFormImpl) {
	    		DerechosFormSubmitFormFormImpl formulario= (DerechosFormSubmitFormFormImpl) valor;
	    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
	        	longitudDescripciones=desc[0].getTextos().length;
	        	form.setListadoNodos(formulario.getListadoNodos());
	        }
	    	else if (valor instanceof ValidoNoOKVolverFormImpl) {
	    		ValidoNoOKVolverFormImpl formulario= (ValidoNoOKVolverFormImpl) valor;
	    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
	        	longitudDescripciones=desc[0].getTextos().length; 
	        	form.setListadoNodos(formulario.getListadoNodos());
	        }
	    	else if (valor instanceof ValidoOKVolverFormImpl) {
	    		ValidoOKVolverFormImpl formulario= (ValidoOKVolverFormImpl) valor;
	    		DescripcionVO[] desc = (DescripcionVO[]) formulario.getDescripcionesAsArray();
	        	longitudDescripciones=desc[0].getTextos().length; 
	        	form.setListadoNodos(formulario.getListadoNodos());
	        }
	    		
	    	cambioFormulario(request,longitudDescripciones, valor);
	    	
	    	DescripcionVO[] 	descripcionesAux = new DescripcionVO[1];
	    	LangStringVO[] langDescAux = new LangStringVO[descripciones[0].getTextos().length];
	    	for(int i=0;i<descripciones[0].getTextos().length;i++){
	    		LangStringVO nuevoLang = new LangStringVO();
	    		nuevoLang.setIdioma(descripciones[0].getTextos()[i].getIdioma());
	    		nuevoLang.setTexto(descripciones[0].getTextos()[i].getTexto().trim());
	    		langDescAux[i] = nuevoLang;
	    	}
	    	DescripcionVO descAux= new DescripcionVO();
	    	descAux.setTextos(langDescAux);
	    	descripcionesAux[0]=descAux;
	    	
	    	if (valor instanceof DerechosFormImpl) {
	    		DerechosFormImpl formulario=(DerechosFormImpl) valor;
	    		formulario.setDescripcionesAsArray(descripcionesAux);
	    		formulario.setListadoComunidades(comunidades);
	    	}else if (valor instanceof DerechosFormSubmitFormFormImpl) 
	    	{
	    		DerechosFormSubmitFormFormImpl formulario=(DerechosFormSubmitFormFormImpl) valor;
	    		formulario.setDescripcionesAsArray(descripcionesAux);
	    		formulario.setListadoComunidades(comunidades);
	    	}else if (valor instanceof ValidoNoOKVolverFormImpl) 
	    	{
	    		ValidoNoOKVolverFormImpl formulario=(ValidoNoOKVolverFormImpl) valor;
	    		formulario.setDescripcionesAsArray(descripcionesAux);
	    		formulario.setListadoComunidades(comunidades);
	    	}else if (valor instanceof ValidoOKVolverFormImpl) 
	    	{
	    		ValidoOKVolverFormImpl formulario=(ValidoOKVolverFormImpl) valor;
	    		formulario.setDescripcionesAsArray(descripcionesAux);
	    		formulario.setListadoComunidades(comunidades);
	    	}
	
	    	coste=form.getCoste();
	    	copyright=form.getCopyRestricciones();
	    	tipoAcceso=form.getTipoAcceso();
	    	
	    	
	    	
	    	//verificar si hay errores para saber a donde voy
	    	
	        if (descripciones!= null && descripciones.length != 0)
	        {
				DescripcionVO descripcion = (DescripcionVO) descripciones[0];
				LangStringVO[] textos=descripcion.getTextos();
				for(int j=0;j<textos.length;j++){
					LangStringVO lDesc=(LangStringVO) textos[j];
					if(lDesc !=null){
						String idioma=lDesc.getIdioma();
						String texto=lDesc.getTexto();
						if(((idioma==null)||(idioma.equals(""))) || 
						   ((texto==null) || (texto.trim().equals(""))))
						{
							if (idioma.equals("") && !texto.trim().equals("") )
								errorFaltaIdioma = true;
							if (!idioma.equals("") && texto.trim().equals(""))
								errorFaltaTexto = true;
						}
					}						 						 
				}
	
	        }
	    	//tipoAcceso
			if((tipoAcceso!=null)&& (!tipoAcceso.equals("")))
			{
				String formAcceso = form.getTipoAcceso()!=null?form.getTipoAcceso():""; 
				if (comunidades==null) {
					errorAcceso=true;
				}
				else if (formAcceso.equals(prop.getProperty("acceso.universal"))) //universal
				{
					int numNodos=form.getListadoNodos().size();
					int numNodosMarcados=comunidades.length;
					logger.debug("AOV: NUMERO DE NODOS:" + numNodos +" MARCADOS: "+ numNodosMarcados);
					if(numNodosMarcados>1 || (numNodosMarcados==1 && !comunidades[0].equals("MEC")))//si hay marcados mas de uno o si hay uno y no es MEC,entonces hay alguno sin marcar
						errorAccesoUniversal=true;//Si hay algun nodo sin marcar de seleccionar tipo de acceso no universal
				} 
				else if(!formAcceso.equals(prop.getProperty("acceso.universal"))){//no universal
					int numNodos=form.getListadoNodos().size();
					int numNodosMarcados=comunidades.length;
					logger.debug("AOV: NUMERO DE NODOS:" + numNodos +" MARCADOS: "+ numNodosMarcados);
					if(numNodosMarcados == 1 && comunidades[0].equals("MEC"))//si hay un nodo y ese nodo es MEC entonces estan marcados todos
						errorAccesoNoUniversal=true;//Si tenemos todos los nodos marcados el tipo de acceso debe ser universal
				}
				
			}
			else {
				if ((comunidades!=null) && (comunidades.length>0))  
					errorAcceso=true;
			}
	    	//fin comprobar errores
	        
	    	
	        
	        if(errorFaltaIdioma  || errorFaltaTexto || errorAcceso || errorAccesoUniversal || errorAccesoNoUniversal)
	        {	
	        	//proceso los errores
				form.setCodigoError("");
				if (errorFaltaIdioma && errorFaltaTexto)
				{
					form.setCodigoError("general.error.idioma_texto");
				}
				else if (errorAccesoUniversal)
				{
					form.setCodigoError("derechos.error.TipoAccesoUniversal");
				}	
				else if (errorAccesoNoUniversal)
				{
					form.setCodigoError("derechos.error.TipoAccesoNoUniversal");
				}
				else if (errorAcceso)
				{
					form.setCodigoError("derechos.error.TipoAcceso");
				}
				else
				{
					if (!errorFaltaIdioma && errorFaltaTexto)
					{
						form.setCodigoError("general.error.texto");
					}
					else
					{
						form.setCodigoError("general.error.idioma");
					}
				}
	        }else // no hay errores!!
	        {
	        
	    	dameTerminoId();
	        
	  	    
			 
	    	LomAvanzadoVO auxAvanzado=new LomAvanzadoVO();
		    	
	        CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	    	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
	        String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	        
	        String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	        
	        //String idiomaLdap="es";
	        String usuario =LdapUserDetailsUtils.getUsuario();
	        //String usuario="empaquetador";
	        String identificador =request.getParameter("identificador");
	        if(identificador==null){
	        	identificador=catalogadorAvSession.getIdentificador();
	        }
	        String returnURL=request.getParameter("returnURL");
	        if(returnURL==null)
	        	returnURL=catalogadorAvSession.getReturnURL();
				
	        catalogadorAvSession.setIdioma(idiomaLdap);
	        catalogadorAvSession.setIdentificador(identificador);
	        catalogadorAvSession.setUsuario(usuario);
	//			 metemos en la sesion el parametro de vuelta al empaquetador
	        catalogadorAvSession.setReturnURL(returnURL);
				
	        AvRightsVO rights=new AvRightsVO();
					
	        //DESCRIPCIONES
	        DescripcionVO descripcionVO = new DescripcionVO();
	        if (descripciones!= null && descripciones.length != 0){
				DescripcionVO descripcion = (DescripcionVO) descripciones[0];
				LangStringVO[] textos=descripcion.getTextos();
				ArrayList lista=new ArrayList();
				for(int j=0;j<textos.length;j++){
					LangStringVO lDesc=(LangStringVO) textos[j];
					 
					if(lDesc !=null){
						LangStringVO lLang=new LangStringVO();
						String idioma=lDesc.getIdioma();
						String texto=lDesc.getTexto();
						if(((idioma!=null)&&(!idioma.equals(""))) && ((texto!=null)&&(!texto.trim().equals("")))){
							lLang.setIdioma(idioma);
							lLang.setTexto(texto.trim());
							lista.add(lLang);
						}
						else{
							if (idioma.equals("") && !texto.trim().equals("") )
								errorFaltaIdioma = true;
							if (!idioma.equals("") && texto.trim().equals(""))
								errorFaltaTexto = true;
						}
					}						 						 
				}
				LangStringVO[] lLangS=(LangStringVO[])lista.toArray(new LangStringVO[lista.size()]);
				if(lLangS.length == 0)
					descripcionVO = null;
				else
					descripcionVO.setTextos(lLangS); 
	        }
				 else 
					 descripcionVO = null;
			
	
			 rights.setDescripcion(descripcionVO);
	        
		 	//Coste
			SourceValueVO costeSV=new SourceValueVO();
			if((coste!=null) && (!coste.equals(""))){//Coste viene relleno o no aparece ni la etiqueta
				costeSV.setValor(coste);
				costeSV.setSource(source);
			}
			else
				costeSV = null;
			rights.setCoste(costeSV);
			
			//Copyright y otras restricciones
			SourceValueVO copySV=new SourceValueVO();
			if((copyright!=null) && (!copyright.equals(""))){//Si viene vacio lo guardabamos con nomTErmino=null y nos da errores, para corregirlo
				copySV.setSource(source);//lo guardamos con "", suponiendo que nunca vendra copyrights=""; Le quitamos la condicion !copyright.equals("")
				copySV.setValor(copyright);
			}
			else
				copySV = null;
			
			rights.setDerechosDeAutor(copySV);
			
			//TipoAcceso
			AccesoVO acceso=new AccesoVO();
			SourceValueVO tipoAccesoSV=new SourceValueVO();
			if((tipoAcceso!=null)&& (!tipoAcceso.equals(""))){//Si viene vacio lo guardabamos con nomTErmino=null y nos da errores, para corregirlo
				tipoAccesoSV.setSource(source);//lo guardamos con "", suponiendo que nunca vendra tipoAcceso="";Le quitamos la condicion !tipoAcceso.equals("")
				tipoAccesoSV.setValor(tipoAcceso);
				acceso.setTipo(tipoAccesoSV);
				DescripcionVO descripcion = new DescripcionVO();
				StringBuffer sb = new StringBuffer();
				String formAcceso = form.getTipoAcceso()!=null?form.getTipoAcceso():""; //comparamos con este pq a tipoAcceso se le ha cambiado el codigo por su cadena 
				if (formAcceso.equals(prop.getProperty("acceso.universal"))) { // en lugar de 6.4.1.1 viene ya como universal
					sb.append("MEC,");
					ArrayList uno= new ArrayList();
		        	uno.add("MEC");
		        	comunidades=(String[]) uno.toArray(new String[uno.size()]);
				} else if (comunidades==null) {
					errorAcceso=true;
				}else {
					sb=new StringBuffer();
					if(comunidades!=null) 
					{
						boolean mec=true;
					  for (int i=0; i<comunidades.length && mec;i++) {
						  if(comunidades[i].equals(prop.getProperty("catalogadorAvanzado.Derechos.SoloAmbitoAcceso.Todas"))){
							  	sb.append("MEC,");
								ArrayList uno= new ArrayList();
					        	uno.add("MEC");
					        	comunidades=(String[]) uno.toArray(new String[uno.size()]);
					        	mec=false;
						  }else{
							  sb.append(comunidades[i]).append(",");
						  }
					  }
				   }
				}
				int longSb = sb.length()>0?sb.length() -1: sb.length();
				LangStringVO langstr = new LangStringVO();
				langstr.setTexto(sb.toString().substring(0, longSb));
				ArrayList arr = new ArrayList();
				arr.add(langstr);
				LangStringVO[] textos = (LangStringVO[])arr.toArray(new LangStringVO[arr.size()]);
				descripcion.setTextos(textos);
				acceso.setDescripcion(descripcion);
			}
			else {
				acceso = null;
				//si TipoAcceso es nulo como va unido a los checkbox no debemos permitir que no seleccionen nada 
				if ((comunidades!=null) && (comunidades.length>0))  
					errorAcceso=true;
			}
			
			rights.setAcceso(acceso);
			
			auxAvanzado.setDerechos(rights);
	        		
			form.setCodigoError("");
			//Cargamos el objeto de sesion
			if(catalogadorAvSession.getMDSesion()==null){
				catalogadorAvSession.setMDSesion(auxAvanzado);
			}
			else{
				if (descripcionVO == null && costeSV == null && copySV == null && acceso == null)
					catalogadorAvSession.getMDSesion().setDerechos(null);
				else
					catalogadorAvSession.getMDSesion().setDerechos(auxAvanzado.getDerechos());
			  }
		  }
    	}catch (org.acegisecurity.AccessDeniedException ad) {
 	    	logger.error("Error de Acceso. " + ad);
        	throw new java.lang.Exception("derechos", ad);
        }catch (Exception e) {
        	logger.error("Error en Servicio de catalogadorWeb, categoría Derechos, metodo guardarDerechos " + e);
			throw new java.lang.Exception("derechos", e);
        }
	}


	//Entran los ids y nos devuelve los nomTerminos
	private void dameTerminoId() throws Exception{
		//DESCRIPCIONES
		ArrayList idsDesc = new ArrayList();
	    LangStringVO[] langDescrip =descripciones[0].getTextos();
	    for ( int i=0;i<langDescrip.length;i++){
	    	idsDesc.add(langDescrip[i].getIdioma());
	    }
	    
	    String[] arrayIdsDesc = (String[])idsDesc.toArray(new String[idsDesc.size()]);
	    TerminoYPadreVO[] terminosTraducDesc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsDesc);
	    int jDesc= 0;
	    for (int cont=0;cont<terminosTraducDesc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jDesc<langDescrip.length){
				if (langDescrip[jDesc].getIdioma().equals("")){
					jDesc++; 
				}
				else{
					enc = true;
					langDescrip[jDesc].setIdioma(terminosTraducDesc[cont].getNomTermino());
					jDesc++;
				}
			}	
	    }
	    descripciones[0].setTextos(langDescrip);
		
		ArrayList ids = new ArrayList();
		ids.add(coste);
		ids.add(copyright);
		ids.add(tipoAcceso);
		String[] arrayIds=(String[])ids.toArray(new String[ids.size()]);
		TerminoYPadreVO[] traduccionIds = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIds);
		if(!coste.equals("")){
			coste=traduccionIds[0].getNomTermino();
			if(!copyright.equals("")){
				copyright=traduccionIds[1].getNomTermino();
				if(!tipoAcceso.equals("")){
					tipoAcceso=traduccionIds[2].getNomTermino();
				}
			}
			
		}else if(!copyright.equals("")){
			copyright=traduccionIds[0].getNomTermino();
			if(!tipoAcceso.equals("")){
				tipoAcceso=traduccionIds[1].getNomTermino();
			}
			
		}else if(!tipoAcceso.equals("")){
			tipoAcceso=traduccionIds[0].getNomTermino();
		}
	}	
	
	private void cambioFormulario(HttpServletRequest request,int longitudDescripciones,Object formRequestSession){
		descripciones = new DescripcionVO[1];
		
      	String[] textoDescripciones = new String[longitudDescripciones];
      	String[] idiomaDescripciones = new String[longitudDescripciones];
      	String [] arrStr = null;
      	
      	for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
      	{
      		String name = String.valueOf(names.nextElement());
      	 
		  	if (name.startsWith("Des")){
		      	 if(name.startsWith("DesTex")){
		              		 int i = Integer.parseInt(name.substring(6, name.length()));
		              		 textoDescripciones[i]=request.getParameter(name);
		              	 }	 
		  
		              	 if (name.startsWith("DesIdio")){
		      		 int i = Integer.parseInt(name.substring(7, name.length()));
		      		 idiomaDescripciones[i]=request.getParameter(name);
		      	 }
		  	} else if (name.startsWith("listadoComunidades")) {
		  		arrStr = request.getParameterValues(name);
		  		
		  	}
           
       }
       //descripciones
       
       DescripcionVO descVO = new DescripcionVO();
       LangStringVO[] aLangDescripciones = new LangStringVO[textoDescripciones.length];
       for (int i = 0; i<textoDescripciones.length;i++){
	  	 LangStringVO langDescripciones= new LangStringVO();
	  	 langDescripciones.setTexto(textoDescripciones[i]);
	  	 langDescripciones.setIdioma(idiomaDescripciones[i]);
	  	 aLangDescripciones[i] = langDescripciones;
       }
       descVO.setTextos(aLangDescripciones);
       descripciones[0]=descVO;
       ArrayList arrAux =new ArrayList();
       //vamos a comprobar antes de meter todo q no se haya pulsado Mec, si se ha pulsado, se quitan las demas
       int m=0;
       boolean ok=false;
       if (arrStr!=null) {
	       while ((m<arrStr.length) && (!ok)) {
	    	   if (arrStr[m].equals("MEC")) {
	    		   ok=true;
	    	   }
	    	   m++;
	       }
	       if (ok==true) {
	    	   arrAux.add("MEC");
	    	   arrStr=(String[])arrAux.toArray(new String[arrAux.size()]);
	       }
       }
	   comunidades=arrStr;
	}

	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//nada
		
	}

	public void cargarDerechosValidar(
			ActionMapping mapping, 
			CargarDerechosValidarForm form, 
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
			UtilidadesOrdenarCombos vocabulariosOrdDest2 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest2.ordenarVocabulariosVO(vocabulario);

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
					if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getCoste() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getCoste().getValor());//terminoYPadre rellenado con coste desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino(form.getCosteBackingList()[0].toString());//terminoYPadre rellenado con coste desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 1:
					Collection tCopyright= new ArrayList();
					tCopyright.add(terminoVO);
					//obtenemos todos derechos de autor que luego filtraremos segun los tipos de recursos
					Collection tCopyright2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
					//obtenemos los usos educativos
					AvEducationalVO[] usosEducativos = catalogadorAvSession.getMDSesion().getEducational();
					//si no tenemos usos educativos cargamos el combo derechos de autor vacio
					//si tenemos algun uso educativos cargamos el combo segun los tipos de recurso
					if(usosEducativos!=null && usosEducativos.length>0){
						tCopyright2 = this.filtrarDerechos(tCopyright2,usosEducativos,prop.getProperty("tipoRecursoAprendizaje"));
						Iterator cont1 = tCopyright2.iterator();
						while (cont1.hasNext()) {
							tCopyright.add(cont1.next());
						}
					}
					form.setCopyRestriccionesBackingList(tCopyright, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor().getValor());//terminoYPadre rellenado con derechos de autor desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino(form.getCopyRestriccionesBackingList()[0].toString());//terminoYPadre rellenado con derechos de autor desde el formulario
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
					if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso() !=null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor());//terminoYPadre rellenado con tipo de acceso desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino(form.getTipoAccesoBackingList()[0].toString());//terminoYPadre rellenado con tipo de acceso desde el formulario
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
				
				

			}

			if( logger.isDebugEnabled() ){

                logger.debug("Cargados los combos del formulario" );
			}

			logger.debug("Cargados los combos");
			
			
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
			
			
			form.setCoste(coste);
			form.setCopyRestricciones(copyright);
			form.setDescripcionesAsArray(descripciones);
			form.setTipoAcceso(tipoAcceso);
			
			if(comunidades!=null && comunidades.length==1 && comunidades[0].equals("MEC"))
			{
				String[] tempComunidades= new String[form.getListadoNodos().size()];
				for (int i = 0; i < form.getListadoNodos().size(); i++) {
					tempComunidades[i]= ((NodoVO) form.getListadoNodos().get(i)).getIdNodo();
				}
				form.setListadoComunidades(tempComunidades);
			}else
				form.setListadoComunidades(comunidades);
			
            //si derechos era null en el objeto de session lo dejamos a null
            if(derechosEsNull)
            	catalogadorAvSession.getMDSesion().setDerechos(null);
        }catch (org.acegisecurity.AccessDeniedException ad) {
        	logger.error("Error de Acceso. " + ad);
        	throw new java.lang.Exception("derechos", ad);
        }catch (Exception e) {
        	   logger.error("Error en Servicio de catalogadorWeb, categoría Derechos, metodo cargarDerechosValidar " + e);
			throw new java.lang.Exception("derechos", e);
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
	
	
	
	private String obtenerAccion(HttpServletRequest request) 
	throws Exception
	{
		String accion="";
		String[] partes;
		for (Enumeration names = request.getParameterNames();accion.equals("") && names.hasMoreElements();)
	       {
	      	 String name = String.valueOf(names.nextElement());
	           if(name.startsWith("accion"))
	           {
	        	   partes= name.split("_");
		        	 if(partes.length>0){
		        		 String anadidos=partes[1];
		        		 for(int i=2;i<partes.length;i++){
		        			 anadidos=anadidos+"_"+partes[i];
		        		 }
		        	 accion=anadidos;
		        	 }
	        	}
		
	        }
		return accion;
	}

	public String comprobarErrores(
			ActionMapping mapping, 
			ComprobarErroresForm form,
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String resultado=null;
		if(form.getCodigoError()!=null && !form.getCodigoError().equals(""))
		{
			this.saveErrorMessage(request, form.getCodigoError());
			resultado="ConErrores";

/////cargo los combos

			InputStream is = null;
	    	Properties prop = new Properties();
			boolean bandera=false;
			
	        try{
	        	int longVocabulario = 0;
	        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
				prop.load(is);
				String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
				
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
				UtilidadesOrdenarCombos vocabulariosOrdDest2 = new UtilidadesOrdenarCombos();
				VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest2.ordenarVocabulariosVO(vocabulario);

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
						if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getCoste() !=null)) {
							terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getCoste().getValor());//terminoYPadre rellenado con coste desde el lom avanzado
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino(form.getCosteBackingList()[0].toString());//terminoYPadre rellenado con coste desde el formulario
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
						if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor() !=null)) {
							terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getDerechosDeAutor().getValor());//terminoYPadre rellenado con derechos de autor desde el lom avanzado
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino(form.getCopyRestriccionesBackingList()[0].toString());//terminoYPadre rellenado con derechos de autor desde el formulario
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
						if ((catalogadorAvSession.getMDSesion().getDerechos() != null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso() !=null)&&(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo() !=null)) {
							terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getDerechos().getAcceso().getTipo().getValor());//terminoYPadre rellenado con tipo de acceso desde el lom avanzado
							terminoypadrear.add(terminoypadreVO);
						} else {
							terminoypadreVO.setNomTermino(form.getTipoAccesoBackingList()[0].toString());//terminoYPadre rellenado con tipo de acceso desde el formulario
							terminoypadrear.add(terminoypadreVO);
						}
						
						break;
					case 3:
						idDest.add(terminoVO);
//						modificamos las cadenas de idiomas
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
					
					

				}

				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

				logger.debug("Cargados los combos");
				
				
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
				
				
				form.setCoste(coste);
				form.setCopyRestricciones(copyright);
				form.setDescripcionesAsArray(descripciones);
				form.setTipoAcceso(tipoAcceso);
				if(comunidades!=null && comunidades.length==1 && comunidades[0].equals("MEC"))
				{
					String[] tempComunidades= new String[form.getListadoNodos().size()];
					for (int i = 0; i < form.getListadoNodos().size(); i++) {
						tempComunidades[i]= ((NodoVO) form.getListadoNodos().get(i)).getIdNodo();
					}
					form.setListadoComunidades(tempComunidades);
				}else
					form.setListadoComunidades(comunidades);
				
	            //si derechos era null en el objeto de session lo dejamos a null
	            if(derechosEsNull)
	            	catalogadorAvSession.getMDSesion().setDerechos(null);
	        }catch (Exception e) {
				logger
				.error("Error en Servicio de catalogacion avanzado, metodo cargarDerechosValidar" + e);
	        }finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						logger.error(e);
					}
				}
	        }

		
		
/////		
		}else{
			resultado="SinErrores";
		}
		return resultado;
	}

	public void reset(
			ActionMapping mapping, 
			ResetForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		try{
			Object valor = request.getSession().getAttribute("form");
			CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			//si el identificador de la sesion es null, entonces lanzamos la excepcion de fin de sesion, 
			//ya que todos los combos se quedan vacios y da error 
			if ((catalogadorAvSession == null) || (catalogadorAvSession.getIdentificador()==null)) {
				throw new Exception();
			}
			if (valor instanceof DerechosFormImpl) {
				DerechosFormImpl formulario = (DerechosFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}else if (valor instanceof DerechosFormSubmitFormFormImpl) {
				DerechosFormSubmitFormFormImpl formulario = (DerechosFormSubmitFormFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}else if (valor instanceof ValidoNoOKVolverFormImpl) {
				ValidoNoOKVolverFormImpl formulario = (ValidoNoOKVolverFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}else if (valor instanceof ValidoOKVolverFormImpl) {
				ValidoOKVolverFormImpl formulario = (ValidoOKVolverFormImpl) valor;
		      	form.setCosteLabelList(formulario.getCosteLabelList());
		      	form.setCosteValueList(formulario.getCosteValueList());
		      	form.setCopyRestriccionesLabelList(formulario.getCopyRestriccionesLabelList());
		      	form.setCopyRestriccionesValueList(formulario.getCopyRestriccionesValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setTipoAccesoLabelList(formulario.getTipoAccesoLabelList());
		      	form.setTipoAccesoValueList(formulario.getTipoAccesoValueList());
		      	form.setListadoNodos(formulario.getListadoNodos());
			}
			//COSTE
			form.setCoste("");
			//DERECHOS
			form.setCopyRestricciones("");
			//DESCRIPCION
			LangStringVO[] nuevolangTextosDescrip ;
			nuevolangTextosDescrip = new LangStringVO[1];
			LangStringVO lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosDescrip[0] = lang;
			
			DescripcionVO descripcionVO= new DescripcionVO();
			DescripcionVO[] aDescripcionesVO = new DescripcionVO[1];
			descripcionVO.setTextos(nuevolangTextosDescrip);
			aDescripcionesVO[0]=descripcionVO;
		    form.setDescripcionesAsArray(aDescripcionesVO);       
	
			
			//ACCESO
			form.setTipoAcceso("");
			
			//LISTADO COMUNIDADES
			form.setListadoComunidades(new String[0]);
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
        	logger.error("Error de Acceso. " + ad);
        	throw new java.lang.Exception("derechos", ad);
		}catch (Exception e) {
			logger
			.error("Error en catalogadorWeb, categoría Derechos, metodo reset" + e);
			throw new java.lang.Exception("derechos", e);
        }
	}
	
	
	/**
	 * 
	 * @param fichManifest: Objeto Manifest serializado.
	 * @param usuario: usuario.
	 * @return String: el identificador.
	 */
	private Collection filtrarDerechos(Collection copyRights, AvEducationalVO[] usosEducativos,String vocabulario) throws Exception{
		Collection derechos = new ArrayList();//Guarda los derechos de autor que cargaremos en el combo (resultado del filtro)
		
		boolean esMedia = false;
		boolean esSistemaDeRepresentacion = false;
		boolean esAplicacionInformatica = false;
		boolean esContenidoDidactico = false;
		boolean esServicio = false;
		TiposDeRecursos tiposRecursos = new TiposDeRecursos();
		DerechosDeAutor derechosAutor = new DerechosDeAutor();
		
		//obtenemos todos los tipos de recursos que tenemos en los usos educativos
		ArrayList terminos = new ArrayList(); 
		for (int i=0; i<usosEducativos.length;i++){
			SourceValueVO[] tipoDeRecurso= usosEducativos[i].getTiposrecursoedu();
			if(tipoDeRecurso !=null){
				for(int j = 0; j< tipoDeRecurso.length;j++){
					TerminoYPadreVO term = new TerminoYPadreVO();
					term.setNomTermino(tipoDeRecurso[j].getValor());	
					term.setIdVocabulario(vocabulario);
					term.setIdiomaTermino("en");
					term.setIdTermino("");
					terminos.add(term);
				}
			}
		}
		
		TerminoYPadreVO[] arrayTerminos=(TerminoYPadreVO[])terminos.toArray(new TerminoYPadreVO[terminos.size()]);
		
		if(arrayTerminos!=null && arrayTerminos.length>0){
			
			//obtenemos los identificadores de los tipos de recurso
			TerminoYPadreVO[] terminosId = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminos);
			
			//clasificamos los tipos de recursos que tenemos para ver que derechos tenemos que mostrar
			for (int i = 0; i<terminosId.length;i++){
				String idRecurso = terminosId[i].getIdTermino();
	
				if(tiposRecursos.esAplicacionInformatica(idRecurso)){
					esAplicacionInformatica = true;
				}
				else if(tiposRecursos.esServicio(idRecurso)){	
					esServicio = true;
				}else if(tiposRecursos.esMedia(idRecurso)){
					esMedia =true;
				}else if(tiposRecursos.esContenidoDidactico(idRecurso)){
					esContenidoDidactico =true;
				}else if(tiposRecursos.esSistemaDeRepresentacion(idRecurso)){
					esSistemaDeRepresentacion =true;
				}	
			}
			
			if (esServicio){//Si hay algun tipo de recurso de este grupo añadimos los derechos que le corresponden
				String[]derechosServicio = derechosAutor.dameDerechosServicio();
				for(int i=0; i<derechosServicio.length;i++){
					String id = derechosServicio[i];
					boolean enc = false;
					Iterator iteCopyRights = copyRights.iterator();
					while (iteCopyRights.hasNext() && !enc){
						TerminoVO term = (TerminoVO) iteCopyRights.next();
						if(term.getIdTermino().equals(id) && !derechos.contains(term)){
							derechos.add(term);
							enc = true;
						}
					}
				}
			}
	
			if(esAplicacionInformatica){//Si hay algun tipo de recurso de este grupo añadimos los derechos que le corresponden
				String[]derechosAplicaciones = derechosAutor.dameDerechosAplicacionInformatica();
				for(int i=0; i<derechosAplicaciones.length;i++){
					String id = derechosAplicaciones[i];
					boolean enc = false;
					Iterator iteCopyRights = copyRights.iterator();
					while (iteCopyRights.hasNext() && !enc){
						TerminoVO term = (TerminoVO) iteCopyRights.next();
						if(term.getIdTermino().equals(id) && !derechos.contains(term)){
							derechos.add(term);
							enc=true;
						}
					}
				}
			}
			if(esSistemaDeRepresentacion || esContenidoDidactico || esMedia){//Si hay algun tipo de recurso de este grupo añadimos los derechos que le corresponden
				String[]derechosResto = derechosAutor.dameDerechosNoServicioNoAplicacionInformatica();
				
				for(int i=0; i<derechosResto.length;i++){
					String id = derechosResto[i];
					boolean enc = false;
					Iterator iteCopyRights = copyRights.iterator();
					while (iteCopyRights.hasNext() && !enc){
						TerminoVO term = (TerminoVO) iteCopyRights.next();
						if(term.getIdTermino().equals(id) && !derechos.contains(term)){
							derechos.add(term);
							enc = true;
						}
					}
				}
			}
		}
		return derechos;
		
	}
}