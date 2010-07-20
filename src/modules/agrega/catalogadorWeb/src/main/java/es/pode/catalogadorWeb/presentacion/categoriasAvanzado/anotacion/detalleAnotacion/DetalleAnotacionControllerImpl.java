/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AvAnnotationVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.EntidadVO;
import es.pode.catalogacion.negocio.servicios.FechaVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.soporte.Fecha;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionController
 */
public class DetalleAnotacionControllerImpl extends DetalleAnotacionController
{  

	protected static Logger logger = Logger.getLogger(DetalleAnotacionControllerImpl.class); 
	private DescripcionVO descripcion;
	private DescripcionVO fechdescripcion;
	private String nombre, organizacion, email, fechaCorta, hora, minutos, segP1, segP2, zona, comboZonaH, zhHora, zhMinutos;
	int indi;
	
	private void cargarCombos(
			CargarAnotacionValidarForm form, 
			HttpServletRequest request)
	throws Exception
	{
		 InputStream is = null;
    	 Properties prop = new Properties();
		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
		prop.load(is);
		String idiomaLdap=this.getCatalogadorAvSession(request).getIdioma();
		
		String[] l_id = { prop.getProperty("idiomaDestinatario")}; //es el idioma pero sin "ninguno"
		VocabularioVO[] vocaCombos = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);

		String titulo = request.getParameter("titulo");
		form.setTituloAnotacion(titulo);//numero del titulo,ejem: Uso Educativo 1
		
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
	
			UtilidadesOrdenarCombos terminosOrdDest2 = new UtilidadesOrdenarCombos();
			TerminoVO[] terminosOrdDest = terminosOrdDest2.ordenarTerminosVO(terminosDest, idiomaLdap);	
//			 crear el ordena en un fichero de utilidades TerminoVO[] terminosOrdDest = ordena(terminosDest, idiomaLdap);
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

		
	}
	
	
	
	
	public void cargarDetalle(
			ActionMapping mapping, 
			CargarDetalleForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		 InputStream is = null;
    	 Properties prop = new Properties();
    	 String nombre="";
		 String organizacion="";
		 String email="";
//		 String fechaCorta="";
//		 String hora="";
//		 String minutos="";
//		 String segP1="";
//		 String segP2="";
		 try {
//			String botonPulsado = request.getParameter("botonPulsado");
//			form.setBotonPulsado(botonPulsado); //actualizamos si es modificar o crear
			
			 String botonPulsado =form.getBotonPulsado(); 
			 String titulo = form.getTituloAnotacion();//indice

//			 if(form.getTituloAnotacion()!=null)
//				 titulo= form.getTituloAnotacion();
			//logger.debug("ASC-EL TITULO DE LA ANOTACION ES " +titulo );
			//Rellenamos combos
			is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String[] l_id = { prop.getProperty("idiomaDestinatario")}; //es el idioma pero sin "ninguno"
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			
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
			
			 
			 //recogemos de la sesion los datos a cargar
			 AvAnnotationVO anotacion =new AvAnnotationVO();
			 CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
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
		    			//8.2 FECHA --> 2007-06-09... Formato completo-->yyyy-MM-ddThh:mm:ss.S(+-)00:00 <--

		    			Fecha fecha= new Fecha();
		    			fecha.setIdioma(idiomaLdap);
		    			if ((anotacion!=null) && (anotacion.getFecha()!=null) && anotacion.getFecha().getFecha()!=null) {
			    			fecha.setFechaLomes(anotacion.getFecha().getFecha());
		    			}
 		    			form.setFechaCorta(fecha.getFechaCorta());
		    			form.setThora(fecha.getHora());
		    			form.setTminuto(fecha.getMinutos());
		    			form.setTsegundoP1(fecha.getSegundoP1());
		    			form.setTsegundoP2(fecha.getSegundoP2());
		    			form.setZhHora(fecha.getZhHora());
	    				form.setZhMinutos(fecha.getZhMinutos());
	    				form.setComboZonaH(fecha.getMasOmenos());
	    				form.setMeridianoCero(fecha.getMeridianoCero());
		    			form.setFormato(fecha.getFormato());
		    			form.setOffSet(fecha.getOffSet());
		    			
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

		    	Fecha fecha= new Fecha();
    			fecha.setIdioma(idiomaLdap);
    			form.setFechaCorta(fecha.getFechaCorta());
    			form.setThora(fecha.getHora());
    			form.setTminuto(fecha.getMinutos());
    			form.setTsegundoP1(fecha.getSegundoP1());
    			form.setTsegundoP2(fecha.getSegundoP2());
    			form.setZhHora(fecha.getZhHora());
				form.setZhMinutos(fecha.getZhMinutos());
				form.setComboZonaH(fecha.getMasOmenos());
				form.setMeridianoCero(fecha.getMeridianoCero());
    			form.setFormato(fecha.getFormato());
    			form.setOffSet(fecha.getOffSet());
    			
    			form.setDescripcionAsArray(new LangStringVO[1]);
		    	form.setDescripcionFechaAsArray(new LangStringVO[1]);
		
		     }
	    	 
		    	
		 }catch (org.acegisecurity.AccessDeniedException ad) {
	    		throw new java.lang.Exception("detalle.anotacion.cu", ad);
				
		 } catch (Exception e) {
				logger
				.error("Error en Servicio de catalogacion avanzado, metodo cargarDetalleAnotacion" + e);
				throw new java.lang.Exception("detalle.anotacion.cu", e);
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

        String resAction = "";
        //String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
        ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

        /////////////////////////////////////////////////////////////////////////////
        // En caso de Eliminar Recogemos los identificadores a eliminar
        String[] accionPartes = accion.split("-");
		accion = accionPartes[0];
		if (accionPartes.length  > 1){
			request.setAttribute("posicion", accionPartes[1]);
		}
		/////////////////////////////////////////////////////////////////////////////
//        if (datosResources.getString("anotacion.AñadirDescripcion").equals(accion)) {
//              resAction = "Añadir Descripcion";
//        }else if (datosResources.getString("anotacion.EliminarDescripcion").equals(accion)) {
//              resAction = "Eliminar Descripcion";
//        }else if (datosResources.getString("anotacion.AñadirDescFecha").equals(accion)) {
//              resAction = "Añadir DescFecha";
//        }else if (datosResources.getString("anotacion.EliminarDescFecha").equals(accion)) {
//              resAction = "Eliminar DescFecha";
//        }else 
        if (datosResources.getString("anotacion.Aceptar").equals(accion)) {
              resAction = "Aceptar";
        }else if (datosResources.getString("anotacion.Validar").equals(accion)) {
			resAction = "Validar";
		} else if (datosResources.getString("anotacion.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		} else if (datosResources.getString("anotacion.Reset").equals(accion)) {
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
//		recogemos los datos de la sesion del formulario para volver a cargar los combos
		Object valor = request.getSession().getAttribute("form");
		try{
			//		rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleAnotacionCUFormImpl) {
				DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
				DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionValidaVolverFormImpl) {
				AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
				AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			}
	
			
			//en la descripcion tenems directamente los LangStringVO[] cambiar despues
			int longitudTextosDesc = 0;
			int longitudFechDesc=0;
			longitudTextosDesc=form.getDescripcionAsArray().length;
			longitudFechDesc=form.getDescripcionFechaAsArray().length;
			
			//actualizamos los datos que hemos cambiado con este metodo
			//cambioFormulario
			cambioFormulario(request, longitudTextosDesc, longitudFechDesc, null);
			
			form.setNombre(nombre);
			form.setOrganizacion(organizacion);
			form.setEmail(email);
			form.setFechaCorta(fechaCorta);
			form.setThora(hora);
			form.setTminuto(minutos);
			form.setTsegundoP1(segP1);
			form.setTsegundoP2(segP2);
			//		el combo y la fecha de la zona horaria solo se recogen si el checkbox esta activo
			form.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
			form.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
			form.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
			form.setMeridianoCero(zona!=null?zona:"");
			Fecha auxFecha = new Fecha();
			auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
			form.setFormato(auxFecha.getFormato());
			form.setOffSet(auxFecha.getOffSet());

			form.setDescripcionAsArray(descripcion.getTextos());
			form.setDescripcionFechaAsArray(fechdescripcion.getTextos());
			
			//Añadimos una posicion mas vacia
			int nuevoTamano = descripcion.getTextos().length +1;
		       LangStringVO[] newALang = new LangStringVO[nuevoTamano];
			   LangStringVO newDesc=new LangStringVO();
			   newDesc.setIdioma("");
			   newDesc.setTexto("");
			 
			   for(int i = 0; i<descripcion.getTextos().length;i++)
				   newALang[i]=descripcion.getTextos()[i];
			   	newALang[nuevoTamano-1]= newDesc;
			    form.setDescripcionAsArray(newALang);
		
			   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.anotacion.cu", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, detalle anotacion, metodo anadirDescripcion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, detalle anotacion, metodo anadirDescripcion " + e);
			throw new Exception("detalle.anotacion.cu",e);
		}	
		
	}

	public void anadirDescripcionFecha(ActionMapping mapping, AnadirDescripcionFechaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//recogemos los datos de la sesion del formulario para volver a cargar los combos
		
		Object valor = request.getSession().getAttribute("form");
		try{
			//		rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleAnotacionCUFormImpl) {
				DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
				DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionValidaVolverFormImpl) {
				AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
				AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			}
			
			//en la descripcion tenems directamente los LangStringVO[] cambiar despues
			int longitudTextosDesc = 0;
			int longitudFechDesc=0;
			longitudTextosDesc=form.getDescripcionAsArray().length;
			longitudFechDesc=form.getDescripcionFechaAsArray().length;
			
			//actualizamos los datos que hemos cambiado con este metodo
			//cambioFormulario
			cambioFormulario(request, longitudTextosDesc, longitudFechDesc, null);
			
			form.setNombre(nombre);
			form.setOrganizacion(organizacion);
			form.setEmail(email);
			form.setFechaCorta(fechaCorta);
			form.setThora(hora);
			form.setTminuto(minutos);
			form.setTsegundoP1(segP1);
			form.setTsegundoP2(segP2);
			//el combo y la fecha de la zona horaria solo se recogen si el checkbox esta activo
			form.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
			form.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
			form.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
			Fecha auxFecha = new Fecha();
			auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
			form.setFormato(auxFecha.getFormato());
			form.setOffSet(auxFecha.getOffSet());

			form.setMeridianoCero(zona!=null?zona:"");
			form.setDescripcionAsArray(descripcion.getTextos());
			form.setDescripcionFechaAsArray(fechdescripcion.getTextos());
			
			//Añadimos una posicion mas vacia
			int nuevoTamano = fechdescripcion.getTextos().length +1;
		       LangStringVO[] newALang = new LangStringVO[nuevoTamano];
			   LangStringVO newDesc=new LangStringVO();
			   newDesc.setIdioma("");
			   newDesc.setTexto("");
			 
			   for(int i = 0; i<fechdescripcion.getTextos().length;i++)
				   newALang[i]=fechdescripcion.getTextos()[i];
			   	newALang[nuevoTamano-1]= newDesc;
			    form.setDescripcionFechaAsArray(newALang);
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.anotacion.cu", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, detalle anotacion, metodo anadirDescripcionFecha" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, detalle anotacion, metodo anadirDescripcionFecha " + e);
			throw new Exception("detalle.anotacion.cu",e);
		}	
		
	}
	
	private void cambioFormulario(HttpServletRequest request,int longitudTextosDesc, int longitudFechDesc, Object formRequestSession){
		descripcion = new DescripcionVO();
		fechdescripcion = new DescripcionVO();
		
		
      	String[] textoDescripcion = new String[longitudTextosDesc];
      	String[] idiomaDescripcion = new String[longitudTextosDesc];
      	
      	String[] textoFecDesc = new String[longitudFechDesc];
      	String[] idiomaFecDesc = new String[longitudFechDesc];
      	
      	for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
      	{
      		String name = String.valueOf(names.nextElement());
      	   //DesFecTex DesFecIdio Des DesIdio
		  	if (name.startsWith("DesFec")){
		  		if(name.startsWith("DesFecTex")){
			       int i = Integer.parseInt(name.substring(9, name.length()));
			       textoFecDesc[i]=request.getParameter(name);
			     }	 
			     if(name.startsWith("DesFecIdio")){
			        int i = Integer.parseInt(name.substring(10, name.length()));//DesFecIdio0
			        idiomaFecDesc[i]=request.getParameter(name);
			     }
		  	}else if (name.startsWith("Des")){
		      	 if(name.startsWith("DesTex")){
		           int i = Integer.parseInt(name.substring(6, name.length()));
		           textoDescripcion[i]=request.getParameter(name);
		         }	 
		      	 if(name.startsWith("DesIdio")){
		      	   int i = Integer.parseInt(name.substring(7, name.length()));
		      	   idiomaDescripcion[i]=request.getParameter(name);
		      	 }
		  	}else if (name.startsWith("Nombre")) {
		  		nombre=request.getParameter(name);
		  	}else if (name.startsWith("Organizacion")) {
		  		organizacion=request.getParameter(name);
		  	}else if (name.startsWith("Email")) {
		  		email=request.getParameter(name);
		  	} else if (name.startsWith("FechaCorta")) {
		  		fechaCorta=request.getParameter(name);
		  	}else if (name.startsWith("HoraDur")) {
		  		hora=request.getParameter(name);
		  	}else if (name.startsWith("MinutosDur")) {
		  		minutos=request.getParameter(name);
		  	}else if (name.startsWith("SegDurP1")) {
		  		segP1=request.getParameter(name);
		  	}else if (name.startsWith("SegDurP2")) {
		  		segP2=request.getParameter(name);
		  	}else if (name.startsWith("meridianoCero")) {
		  		zona=request.getParameter(name);
		  	} else if (name.startsWith("comboZonaH")) {
		  		comboZonaH=request.getParameter(name);
		  	}else if (name.startsWith("zhHora")){
		  		zhHora=request.getParameter(name);
		  	}else if (name.startsWith("zhMinutos")) {
		  		zhMinutos=request.getParameter(name);
		  	}
       }
      	
       //descripcion
       DescripcionVO descVO = new DescripcionVO();
       LangStringVO[] aLangDescripciones = new LangStringVO[textoDescripcion.length];
       for (int i = 0; i<textoDescripcion.length;i++){
	  	 LangStringVO langDescripciones= new LangStringVO();
	  	 String textoDescripcionI=textoDescripcion[i]!=null?textoDescripcion[i]:"";
	  	 langDescripciones.setTexto(textoDescripcionI.trim());
	  	 langDescripciones.setIdioma(idiomaDescripcion[i]);
	  	 aLangDescripciones[i] = langDescripciones;
       }
       descVO.setTextos(aLangDescripciones);
       descripcion=descVO;	
       
       //descripcion fecha
       DescripcionVO fechDescVO = new DescripcionVO();
       LangStringVO[] aLangFechDesc = new LangStringVO[textoFecDesc.length];
       for (int i = 0; i<textoFecDesc.length;i++){
	  	 LangStringVO langFechDesc= new LangStringVO();
	  	 String textoFecDescI=textoFecDesc[i]!=null?textoFecDesc[i]:"";
	  	 langFechDesc.setTexto(textoFecDescI.trim());
	  	 langFechDesc.setIdioma(idiomaFecDesc[i]);
	  	 aLangFechDesc[i] = langFechDesc;
       }
       fechDescVO.setTextos(aLangFechDesc);
       fechdescripcion=fechDescVO;
       
	   }
	
	

	public void eliminarDescripcion(ActionMapping mapping, EliminarDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	
//		primero recoge los valores y los cambios en el formulario
		Object valor = request.getSession().getAttribute("form");
		try{
			//rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleAnotacionCUFormImpl) {
				DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
				DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionValidaVolverFormImpl) {
				AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
				AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			}
			
			//en la descripcion tenems directamente los LangStringVO[] cambiar despues
			int longitudTextosDesc = 0;
			int longitudFechDesc=0;
			longitudTextosDesc=form.getDescripcionAsArray().length;
			longitudFechDesc=form.getDescripcionFechaAsArray().length;
			
			//actualizamos los datos que hemos cambiado con este metodo
			cambioFormulario(request, longitudTextosDesc, longitudFechDesc, null);
			
			form.setNombre(nombre);
			form.setOrganizacion(organizacion);
			form.setEmail(email);
			form.setFechaCorta(fechaCorta);
			form.setThora(hora);
			form.setTminuto(minutos);
			form.setTsegundoP1(segP1);
			form.setTsegundoP2(segP2);
	//		el combo y la fecha de la zona horaria solo se recogen si el checkbox esta activo
			form.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
			form.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
			form.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
			form.setMeridianoCero(zona!=null?zona:"");
			Fecha auxFecha = new Fecha();
			auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
			form.setFormato(auxFecha.getFormato());
			form.setOffSet(auxFecha.getOffSet());

			form.setDescripcionAsArray(descripcion.getTextos());
			form.setDescripcionFechaAsArray(fechdescripcion.getTextos());
			
			// Una vez actualizados todos los campos buscamos la posicion y la eliminamos
			String posicion = request.getAttribute("posicion").toString();
			
			int posDesc = Integer.parseInt(posicion);
			LangStringVO[] descOld = (LangStringVO[]) form.getDescripcionAsArray();
			LangStringVO[] descActual = new LangStringVO[descOld.length-1];
			for (int i = 0; i<descActual.length;i++){
	     		if (i < posDesc)
	     			descActual[i] = descOld[i];
	     		else
	     			descActual[i] = descOld[i+1]; 
	     	}//fin for
			form.setDescripcionAsArray(descActual); //todos menos posDescFecha
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.anotacion.cu", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, detalle anotacion, metodo eliminarDescripcion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, detalle anotacion, metodo eliminarDescripcion " + e);
			throw new Exception("detalle.anotacion.cu",e);
		}	
	}

	public void eliminarDescripcionFecha(ActionMapping mapping, EliminarDescripcionFechaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//primero recoge los valores y los cambios en el formulario
		Object valor = request.getSession().getAttribute("form");
		try{
			//rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleAnotacionCUFormImpl) {
				DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
				DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionValidaVolverFormImpl) {
				AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
				AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcion(formulario.getDescripcion());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			}
			
			//en la descripcion tenems directamente los LangStringVO[] cambiar despues
			int longitudTextosDesc = 0;
			int longitudFechDesc=0;
			longitudTextosDesc=form.getDescripcionAsArray().length;
			longitudFechDesc=form.getDescripcionFechaAsArray().length;
			
			//actualizamos los datos que hemos cambiado con este metodo
			cambioFormulario(request, longitudTextosDesc, longitudFechDesc, null);
			
			form.setNombre(nombre);
			form.setOrganizacion(organizacion);
			form.setEmail(email);
			form.setFechaCorta(fechaCorta);
			form.setThora(hora);
			form.setTminuto(minutos);
			form.setTsegundoP1(segP1);
			form.setTsegundoP2(segP2);
	//		el combo y la fecha de la zona horaria solo se recogen si el checkbox esta activo
			form.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
			form.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
			form.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
			form.setMeridianoCero(zona!=null?zona:"");
			Fecha auxFecha = new Fecha();
			auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
			form.setFormato(auxFecha.getFormato());
			form.setOffSet(auxFecha.getOffSet());

			form.setDescripcionAsArray(descripcion.getTextos());
			form.setDescripcionFechaAsArray(fechdescripcion.getTextos());
			
			// Una vez actualizados todos los campos buscamos la posicion y la eliminamos
			String posicion = request.getAttribute("posicion").toString();
			int posDescFecha = Integer.parseInt(posicion);
			LangStringVO[] descFechaOld = (LangStringVO[]) form.getDescripcionFechaAsArray();
			LangStringVO[] desFechaActual = new LangStringVO[descFechaOld.length-1];
			for (int i = 0; i<desFechaActual.length;i++){
	     		if (i < posDescFecha)
	     			desFechaActual[i] = descFechaOld[i];
	     		else
	     			desFechaActual[i] = descFechaOld[i+1]; 
	     	}//fin for
			form.setDescripcionFechaAsArray(desFechaActual); //todos menos posDescFecha
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.anotacion.cu", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, detalle anotacion, metodo eliminarDescripcionFecha " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, detalle anotacion, metodo eliminarDescripcionFecha " + e);
			throw new Exception("detalle.anotacion.cu",e);
		}	
		
	}

	public boolean esValidaAnotacion(
			ActionMapping mapping, 
			EsValidaAnotacionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		//String idiomaLocale=(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		Collection mensajes = new ArrayList();
		AvAnnotationVO anotacionAux= new AvAnnotationVO();
		//Recoge los valores y los cambios en el formulario
		Object valor = request.getSession().getAttribute("form");
		//rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
		
		
		
		if (valor instanceof DetalleAnotacionCUFormImpl) {
			DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
			form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
			form.setDescripcion(formulario.getDescripcion());
			form.setDescripcionFecha(formulario.getDescripcionFecha());
			form.setTituloAnotacion(formulario.getTituloAnotacion());
		} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
			DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
			form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
			form.setDescripcion(formulario.getDescripcion());
			form.setDescripcionFecha(formulario.getDescripcionFecha());
			form.setTituloAnotacion(formulario.getTituloAnotacion());
		} else if (valor instanceof AnotacionValidaVolverFormImpl) {
			AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
			form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
			form.setDescripcion(formulario.getDescripcion());
			form.setDescripcionFecha(formulario.getDescripcionFecha());
			form.setTituloAnotacion(formulario.getTituloAnotacion());
		} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
			AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
			form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
			form.setDescripcion(formulario.getDescripcion());
			form.setDescripcionFecha(formulario.getDescripcionFecha());
			form.setTituloAnotacion(formulario.getTituloAnotacion());
		}
		
		//en la descripcion tenems directamente los LangStringVO[] cambiar despues
		int longitudTextosDesc = 0;
		int longitudFechDesc=0;
		longitudTextosDesc=form.getDescripcionAsArray().length;
		longitudFechDesc=form.getDescripcionFechaAsArray().length;
		
		//actualizamos los datos que hemos cambiado con este metodo
		cambioFormulario(request, longitudTextosDesc, longitudFechDesc, null);
		
		//completo los valores de annotation
		EntidadVO entidad= new EntidadVO();
		entidad.setTexto(nombre+";"+email+";"+organizacion);
		anotacionAux.setEntidad(entidad);
		
		FechaVO fechaVO= new FechaVO();
			fechaVO.setFecha("");
				DescripcionVO descripcionVO= new DescripcionVO();
				descripcionVO.setTextos(fechdescripcion.getTextos() );
			fechaVO.setDescripcion(descripcionVO);
		anotacionAux.setFecha(fechaVO);
		
		DescripcionVO descripcionVO2= new DescripcionVO();
			descripcionVO2.setTextos(descripcion.getTextos());
		anotacionAux.setDescripcion(descripcionVO2);
		

		int i;
		boolean todosVacios=true;
		
		//ENTIDAD
		if(	(nombre==null || nombre.equals("")) &&
			(email==null || email.equals("")) &&
			(organizacion==null || organizacion.equals("")))
		{
			
			mensajes.add(datosResources.getString("CAV.8.1"));//El campo Entidad es obligatorio
		}
		
		//FECHA
		boolean fechaVacia=false;
		
		if(	fechaCorta!=null && 
			(fechaCorta.trim().equals("") ||
			fechaCorta.equals("dd/mm/aaaa") ||
			fechaCorta.equals("mm/dd/yyyy") ||
			fechaCorta.equals("aaaa/mm/dd") ))
		{
			//si alguno de los campos dia, mes o anyo esta vacio, fecha esta vacio
			fechaVacia=true;
		}
		boolean descVacios=true;
		String descFec;
		for(i=0;i<fechdescripcion.getTextos().length && descVacios;i++)
		{
			descFec= fechdescripcion.getTextos()[i].getTexto();
			if(descFec!=null && !descFec.trim().equals(""))
			{
				descVacios=false;
			}
		}


		if(descVacios && fechaVacia)
		{
			mensajes.add(datosResources.getString("CAV.8.2"));//El campo FECHA	 es obligatorio
		}else if(descVacios && !fechaVacia)
		{
			mensajes.add(datosResources.getString("CAV.8.2.2"));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
		}else if(!descVacios && fechaVacia)
		{
			mensajes.add(datosResources.getString("CAV.8.2.1"));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
		}
		if(	fechaVacia && 
			((hora!=null && !hora.trim().equals("")) ||
			 (minutos!=null && !minutos.trim().equals(""))
			))
		{
			mensajes.add(datosResources.getString("CAV.8.2.3"));//La fecha es obligatoria si el tiempo est&aacute; definido
		}
		
		
		
		//DESCRIPCION
		String desc;
		for(i=0;i<anotacionAux.getDescripcion().getTextos().length && todosVacios;i++)
		{
			desc= anotacionAux.getDescripcion().getTextos()[i].getTexto();
			if(desc!=null && !desc.trim().equals(""))
			{
				todosVacios=false;
			}
		}
		if(todosVacios)
			mensajes.add(datosResources.getString("CAV.8.3"));//El campo Descripci&oacute;n es obligatorio

		
		
		//
		if(mensajes.size()>0)
		{
			form.setMensajesError(mensajes);
			return false;
		}else{
			return true;
		}
	}

	public void guardarAnotacion(
			ActionMapping mapping, 
			GuardarAnotacionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		boolean errorFaltaIdioma = false;
		boolean errorFaltaTexto = false;
		boolean errorDatosEntidad = false;
		boolean errorFechaObli = false;
		boolean errorFechaObliHorMin = false;
		boolean errorFechaZonaHoraria =false;
		boolean errorFechaComboZH =false;
		boolean errorFecha = false;
		boolean errorEmail=false;
		boolean errorNoNumero=false;
		boolean errorZHFueraRango =false;
		boolean errorFechaFueraRango=false;
		boolean errorFormatoFecha=false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		
		InputStream is = null;
		Properties prop = new Properties();
		LomAvanzadoVO auxAvanzado=new LomAvanzadoVO();
		AvAnnotationVO[] anotaciones = null;
		AvAnnotationVO anotacionAux = new AvAnnotationVO();
		EntidadVO entidad =null;
		FechaVO fecha = null;
		
		try {
				auxAvanzado.setAnotaciones(anotaciones);
				
				is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
				prop.load(is);
								
				
				String usuario =LdapUserDetailsUtils.getUsuario();
				String identificador =request.getParameter("identificador");
				if(identificador==null){
				   identificador=catalogadorAvSession.getIdentificador();
				}
				String returnURL=request.getParameter("returnURL");
				if(returnURL==null)
					returnURL=catalogadorAvSession.getReturnURL();
				
				catalogadorAvSession.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
				catalogadorAvSession.setIdentificador(identificador);
				catalogadorAvSession.setUsuario(usuario);
				// metemos en la sesion el parametro de vuelta al empaquetador
				catalogadorAvSession.setReturnURL(returnURL);
				
				//Recoge los valores y los cambios en el formulario
				Object valor = request.getSession().getAttribute("form");
				//rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
				if (valor instanceof DetalleAnotacionCUFormImpl) {
					DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
					form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
					form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
					form.setDescripcion(formulario.getDescripcion());
					form.setDescripcionFecha(formulario.getDescripcionFecha());
					form.setTituloAnotacion(formulario.getTituloAnotacion());
				} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
					DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
					form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
					form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
					form.setDescripcion(formulario.getDescripcion());
					form.setDescripcionFecha(formulario.getDescripcionFecha());
					form.setTituloAnotacion(formulario.getTituloAnotacion());
				} else if (valor instanceof AnotacionValidaVolverFormImpl) {
					AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
					form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
					form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
					form.setDescripcion(formulario.getDescripcion());
					form.setDescripcionFecha(formulario.getDescripcionFecha());
					form.setTituloAnotacion(formulario.getTituloAnotacion());
				} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
					AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
					form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
					form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
					form.setDescripcion(formulario.getDescripcion());
					form.setDescripcionFecha(formulario.getDescripcionFecha());
					form.setTituloAnotacion(formulario.getTituloAnotacion());
				}
				
				//en la descripcion tenems directamente los LangStringVO[] cambiar despues
				int longitudTextosDesc = 0;
				int longitudFechDesc=0;
				longitudTextosDesc=form.getDescripcionAsArray().length;
				longitudFechDesc=form.getDescripcionFechaAsArray().length;
				
				//actualizamos los datos que hemos cambiado con este metodo
				cambioFormulario(request, longitudTextosDesc, longitudFechDesc, null);
				form.setNombre(nombre);
				form.setOrganizacion(organizacion);
				form.setEmail(email);
				form.setFechaCorta(fechaCorta);
				form.setThora(hora);
				form.setTminuto(minutos);
				form.setTsegundoP1(segP1);
				form.setTsegundoP2(segP2);
				//el combo y la fecha de la zona horaria solo se recogen si el checkbox esta activo
				form.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
				form.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
				form.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
				form.setMeridianoCero(zona!=null?zona:"");
				Fecha auxFecha = new Fecha();
				auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
				form.setFormato(auxFecha.getFormato());
				form.setOffSet(auxFecha.getOffSet());

				form.setDescripcionAsArray(descripcion.getTextos());
				form.setDescripcionFechaAsArray(fechdescripcion.getTextos());
				
				// despues de actualizar el formulario, lo hacemos del obj valor, por si hay algun error que mantenga los cambios Visibles
				if (valor instanceof DetalleAnotacionCUFormImpl) 
				{
					DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor; 
					formulario.setNombre(nombre);
					formulario.setOrganizacion(organizacion);
					formulario.setEmail(email);
					formulario.setFechaCorta(fechaCorta);
					formulario.setThora(hora);
					formulario.setTminuto(minutos);
					formulario.setTsegundoP1(segP1);
					formulario.setTsegundoP2(segP2);
					formulario.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
					formulario.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
					formulario.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
					formulario.setMeridianoCero(zona!=null?zona:"");
					form.setFormato(auxFecha.getFormato());
					form.setOffSet(auxFecha.getOffSet());
					formulario.setDescripcionAsArray(descripcion.getTextos());
					formulario.setDescripcionFechaAsArray(fechdescripcion.getTextos());
		    		
		    	}else if (valor instanceof DetalleFormSubmitFormFormImpl)
		    	{ 
		    		DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor; 
					formulario.setNombre(nombre);
					formulario.setOrganizacion(organizacion);
					formulario.setEmail(email);
					formulario.setFechaCorta(fechaCorta);
					formulario.setThora(hora);
					formulario.setTminuto(minutos);
					formulario.setTsegundoP1(segP1);
					formulario.setTsegundoP2(segP2);
					formulario.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
					formulario.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
					formulario.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
					formulario.setMeridianoCero(zona!=null?zona:"");
					form.setFormato(auxFecha.getFormato());
					form.setOffSet(auxFecha.getOffSet());
					formulario.setDescripcionAsArray(descripcion.getTextos());
					formulario.setDescripcionFechaAsArray(fechdescripcion.getTextos());
		    	}else if (valor instanceof AnotacionValidaVolverFormImpl)
		    	{ 
		    		AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor; 
					formulario.setNombre(nombre);
					formulario.setOrganizacion(organizacion);
					formulario.setEmail(email);
					formulario.setFechaCorta(fechaCorta);
					formulario.setThora(hora);
					formulario.setTminuto(minutos);
					formulario.setTsegundoP1(segP1);
					formulario.setTsegundoP2(segP2);
					formulario.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
					formulario.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
					formulario.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
					formulario.setMeridianoCero(zona!=null?zona:"");
					form.setFormato(auxFecha.getFormato());
					form.setOffSet(auxFecha.getOffSet());

					formulario.setDescripcionAsArray(descripcion.getTextos());
					formulario.setDescripcionFechaAsArray(fechdescripcion.getTextos());
		
				}else if (valor instanceof AnotacionNoValidaVolverFormImpl)
				{ 
					AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor; 
					formulario.setNombre(nombre);
					formulario.setOrganizacion(organizacion);
					formulario.setEmail(email);
					formulario.setFechaCorta(fechaCorta);
					formulario.setThora(hora);
					formulario.setTminuto(minutos);
					formulario.setTsegundoP1(segP1);
					formulario.setTsegundoP2(segP2);
					formulario.setComboZonaH(((zona!=null) && (zona.equals("1")))? comboZonaH:"" );
					formulario.setZhHora(((zona!=null) && (zona.equals("1")))? zhHora:"");
					formulario.setZhMinutos(((zona!=null) && (zona.equals("1")))? zhMinutos:"");
					formulario.setMeridianoCero(zona!=null?zona:"");
					form.setFormato(auxFecha.getFormato());
					form.setOffSet(auxFecha.getOffSet());

					formulario.setDescripcionAsArray(descripcion.getTextos());
					formulario.setDescripcionFechaAsArray(fechdescripcion.getTextos());
			  	}
			 
				 
				//Comprobamos si los campos ha sido rellenados adecuadamente
				//Tenemos que componer nuestro AvAnnotationVO que ira dentro del array en la posicion tituloAnotacion!!!!!!
				//anotacion
				
				///////////// ENTIDAD 
				//8.1 RECURSO ->BEGIN:VCARD VERSION 3.0 FN:GT8/SC36/CT71 EMAIL;TYPE=INTERNET:GT8@aenor.es ORG:AENOR END:VCARD
				entidad = new EntidadVO();
				String textoEnt="";
				if (!organizacion.equals("") || !email.equals("") || !nombre.equals("")){
					if(!email.trim().equals("")){
						if(validaEmail(email.trim())){	
							textoEnt = new StringBuffer("BEGIN:VCARD VERSION:3.0 FN:").append(nombre.trim())
											  .append(" EMAIL;TYPE=INTERNET:").append(email.trim())
											  .append(" ORG:").append(organizacion.trim()).append(" END:VCARD").toString();
						}
						else errorEmail=true;
					}
					else{
						textoEnt = new StringBuffer("BEGIN:VCARD VERSION:3.0 FN:").append(nombre.trim())
						  .append(" EMAIL;TYPE=INTERNET:").append(email.trim())
						  .append(" ORG:").append(organizacion.trim()).append(" END:VCARD").toString();
					}
				}
				if(textoEnt!=null && !textoEnt.trim().equals(""))
				{
					entidad.setTexto(textoEnt.trim());
				}else{
					entidad=null;
				}
				
				anotacionAux.setEntidad(entidad); //EntidadVO
				
		//		EntidadVO entidad = new EntidadVO();
		//		String textoEnt="";
		//		textoEnt = new StringBuffer("BEGIN:VCARD VERSION 3.0 FN:").append(nombre).append(" EMAIL;TYPE=INTERNET:").append(email)
		//						  .append(" ORG:").append(organizacion).append(" END:VCARD").toString();
		//		entidad.setTexto(textoEnt);
		//		anotacionAux.setEntidad(entidad); //EntidadVO
				
				///////// FECHA
				
				// es obl al menos yyyy-MM-dd

				
				Fecha fechaAux = new Fecha();
				fechaAux.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
				fechaAux.setFechaCorta(fechaCorta);
				fechaAux.setHora(hora);
				fechaAux.setMinutos(minutos);
				fechaAux.setSegundoP1(segP1);
				fechaAux.setSegundoP2(segP2);
				fechaAux.setMeridianoCero(zona);
				fechaAux.setMasOmenos(comboZonaH);
				fechaAux.setZhHora(zhHora);
				fechaAux.setZhMinutos(zhMinutos);
				
				
				
				Integer[] errores= fechaAux.validar();
				if(errores.length>0)
				{
					for (int i = 0; i < errores.length; i++) {
						if(errores[i].equals(Fecha.ErrorNoNumero) && !errorNoNumero)
								errorNoNumero= true;
						else if(errores[i].equals(Fecha.ErrorFechaFueraRango)&& !errorFechaFueraRango)
							errorFechaFueraRango= true;
						else if(errores[i].equals(Fecha.ErrorZHFueraRango) && !errorZHFueraRango)
							errorZHFueraRango= true;
						else if(errores[i].equals(Fecha.ErrorFechaComboZH) && !errorFechaComboZH)
							errorFechaComboZH= true;
						else if(errores[i].equals(Fecha.ErrorFechaZonaHoraria) && !errorFechaZonaHoraria)
							errorFechaZonaHoraria= true;
						else if(errores[i].equals(Fecha.ErrorFechaObliHorMin) && !errorFechaObliHorMin)
							errorFechaObliHorMin= true;
						else if(errores[i].equals(Fecha.ErrorFechaObli) && !errorFechaObli)
							errorFechaObli= true;
						else if(errores[i].equals(Fecha.ErrorFormatoFecha) && !errorFormatoFecha)
							errorFormatoFecha= true;
						
					}
				}
				fecha = new FechaVO();
				if(errores.length==0 )
				{
					fecha.setFecha(fechaAux.getFechaLomes());
				}else
				{
					fecha.setFecha(null);
				}
				
				
				/// descripcion fecha
				if (fechdescripcion!= null) {
					LangStringVO[] landFechDesc = fechdescripcion.getTextos();
					ArrayList fechDescAux = new ArrayList();
					String textoDesc="";
					String idioDesc="";
					for (int d=0; d< landFechDesc.length; d++){
						if (landFechDesc[d]!=null) {
							textoDesc=landFechDesc[d].getTexto();
							idioDesc=landFechDesc[d].getIdioma();
							if(((textoDesc!=null)&&(!textoDesc.equals(""))) && ((idioDesc!=null)&&(!idioDesc.equals("")))){
								LangStringVO lanDescAux= new LangStringVO();
								lanDescAux.setTexto(textoDesc.trim());
								lanDescAux.setIdioma(idioDesc);
								fechDescAux.add(lanDescAux); //lo metemos en el array auxiliar
							}else{//comprueba si alguno esta incompleto
								if (idioDesc.equals("") && !textoDesc.trim().equals("") )
									errorFaltaIdioma = true;
								if (!idioDesc.equals("") && textoDesc.trim().equals("") )
									errorFaltaTexto = true;
							} 
							
						}
					}
					LangStringVO[] textos=null;
					if (fechDescAux.size()>0) 
						textos = (LangStringVO[])fechDescAux.toArray(new LangStringVO[fechDescAux.size()]);
					if(textos!=null)
						fechdescripcion.setTextos(textos);
					else
						fechdescripcion=null;
				}
				fecha.setDescripcion(fechdescripcion); //DescripcionVO
				
				
				if(fecha.getDescripcion()==null && fecha.getFecha()==null )
					fecha=null;
				
				anotacionAux.setFecha(fecha); //FechaVO
				
				/////////	DESCRIPCIONES
				if (descripcion != null) {
					LangStringVO[] landDesc = descripcion.getTextos();
					ArrayList descAux = new ArrayList();
					for (int d=0; d< landDesc.length; d++){
						if (landDesc[d]!=null) {
							String textoDesc=landDesc[d].getTexto();
							String idioDesc=landDesc[d].getIdioma();
							if(((textoDesc!=null)&&(!textoDesc.trim().equals(""))) && ((idioDesc!=null)&&(!idioDesc.equals("")))){
								LangStringVO lanDescAux= new LangStringVO();
								lanDescAux.setTexto(textoDesc.trim());
								lanDescAux.setIdioma(idioDesc);
								descAux.add(lanDescAux); //lo metemos en el array auxiliar
							}else{//comprueba si alguno esta incompleto
								if (idioDesc.equals("") && !textoDesc.trim().equals("") )
									errorFaltaIdioma = true;
								if (!idioDesc.equals("") && textoDesc.trim().equals("") )
									errorFaltaTexto = true;
							} 
							
						}
					}
					LangStringVO[] textos =null;
					if (descAux.size()>0) 
					{
						textos = (LangStringVO[])descAux.toArray(new LangStringVO[descAux.size()]);
						descripcion.setTextos(textos);
					}else{ 
						descripcion=null;
					}
				}
				anotacionAux.setDescripcion(descripcion); //DescripcionVO
			
				if(anotacionAux.getDescripcion()==null && anotacionAux.getEntidad()==null && anotacionAux.getFecha()==null)
					anotacionAux=null;
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("detalle.anotacion.cu", ad);
			
		 } catch (Exception e) {
				logger
				.error("Error en Servicio de catalogacion avanzado, metodo guardarAnotacion" + e);
				throw new java.lang.Exception("detalle.anotacion.cu", e);
	    }
		 
		//Antes de guardar comprobamos que no haya habido errores
		if(!errorFaltaIdioma && !errorFaltaTexto  && !errorFechaObli && !errorFechaObliHorMin && !errorFechaZonaHoraria && !errorFechaComboZH
				&& !errorEmail && !errorNoNumero && !errorFechaFueraRango && !errorZHFueraRango && !errorFormatoFecha){				
			//Obtnemos los terminos de los ids seleccionados en todos los combos
			dameTerminoId(); 

			//Cargamos el objeto de sesion
			if(catalogadorAvSession.getMDSesion()==null || catalogadorAvSession.getMDSesion().getAnotaciones()==null)
			{
				if(anotacionAux==null)
					anotaciones= new AvAnnotationVO[0];
				else
				{
					ArrayList lisAnotaAux = new ArrayList();
					lisAnotaAux.add(anotacionAux);
					anotaciones= (AvAnnotationVO[])lisAnotaAux.toArray(new AvAnnotationVO[lisAnotaAux.size()]);
				}
				//auxAvanzado.setAnotaciones(anotaciones);
//				catalogadorAvSession.setMDSesion(auxAvanzado);//metemos lom entero
				catalogadorAvSession.getMDSesion().setAnotaciones(anotaciones);
				
			}else{
				    //lo metemos en la posicion correspondiente
					anotaciones=catalogadorAvSession.getMDSesion().getAnotaciones();
					if (indi< anotaciones.length) {
						ArrayList listaAnotaciones= new ArrayList();
						
						for (int i = 0; i < anotaciones.length ; i++) {
							if(i==indi)
							{
								if ( anotacionAux!=null)
									listaAnotaciones.add(anotacionAux);
							}else{
								listaAnotaciones.add(anotaciones[i]);
							}
						}
						anotaciones = (AvAnnotationVO[]) listaAnotaciones.toArray(new AvAnnotationVO[0]);
						catalogadorAvSession.getMDSesion().setAnotaciones(anotaciones);
					}else if(anotacionAux!=null)
					{
						//tenemos que crearlo al final
						int newTam=anotaciones.length +1;
						AvAnnotationVO[] AnotaAux = new AvAnnotationVO[newTam];
						 for(int i = 0; i<anotaciones.length;i++)
							 AnotaAux[i]=anotaciones[i];
						 AnotaAux[newTam-1]= anotacionAux;
						 catalogadorAvSession.getMDSesion().setAnotaciones(AnotaAux);
					}
					
			}

		}else{
			if (errorFormatoFecha)
				throw new ValidatorException("{error.FormatoFecha}");
			else if (errorNoNumero)
				throw new ValidatorException("{error.NoNumero}");
			else if(errorFechaFueraRango)
				throw new ValidatorException("{error.fechaFueraRango}");
			else if(errorFechaObli)
				throw new ValidatorException("{error.fechaIncompleta}");
			else if (errorFechaObliHorMin)
				throw new ValidatorException("{error.fechaIncompletaHorMin}");
			else if (errorFechaZonaHoraria)
				throw new ValidatorException("{error.fechaIncompletaZonaHora}");
			else if (errorFechaComboZH)
				throw new ValidatorException("{error.fechaSelecionaCombo}");
			else if (errorZHFueraRango)
				throw new ValidatorException("{error.ZonaHoraria}");
			else if (errorEmail)
				throw new ValidatorException("{error.email}");
			else if (errorFaltaIdioma && errorFaltaTexto)
				throw new ValidatorException("{general.error.idioma_texto}");
				//throw new ValidatorException("{anotaciones.error.datosEntidad_obl}{general.error.idioma_texto}" );
//			else if (errorFechaObli)
//				throw new ValidatorException("{anotaciones.error.fecha_obl}");
			else 
				if (!errorFaltaIdioma && errorFaltaTexto)
					throw new ValidatorException("{general.error.texto}");
				else 
					throw new ValidatorException("{general.error.idioma}");
		
		
		}
	}

	// cuando trabajamos con los combos de idiomas, vamos guardando el codigo (1.3.1) en lugar del texto (es) para
	//guardarlo en sesion y lom correctamente necesitamos guardar el texto, asi q hacemos la traduccion
	private void dameTerminoId() throws Exception{
		
		//para Descripcion Fecha
		if ((fechdescripcion !=null) && (fechdescripcion.getTextos()!=null)) {
			ArrayList idsFecDesc = new ArrayList();
	    	LangStringVO[] langFecDescripcion = fechdescripcion.getTextos();
	    	for ( int j=0;j<langFecDescripcion.length;j++){
	    		idsFecDesc.add(langFecDescripcion[j].getIdioma());
		    	
		        String[] arrayIdsFecDesc = (String[])idsFecDesc.toArray(new String[idsFecDesc.size()]);
		        TerminoYPadreVO[] termsTraducFecDesc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsFecDesc);
		        
		        int jDesc= 0;
		        for (int cont=0;cont<termsTraducFecDesc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
		        	
		    		boolean enc=false; 		
		    		while(!enc && jDesc<langFecDescripcion.length){
		    			if (langFecDescripcion[jDesc].getIdioma().equals("")){
		    				jDesc++; 
		    			}
		    			else{
		    				enc = true;
		    				langFecDescripcion[jDesc].setIdioma(termsTraducFecDesc[cont].getNomTermino());
		    				jDesc++;
		    			}
		    		}	
		        }
	        }
	    }
		//para Descripcion
		if ((descripcion!=null) && (descripcion.getTextos()!=null)) {
			ArrayList idsDesc = new ArrayList();
	    	LangStringVO[] langDescripcion = descripcion.getTextos();
	    	for ( int j=0;j<langDescripcion.length;j++){
		    	idsDesc.add(langDescripcion[j].getIdioma());
		    	
		        String[] arrayIdsDesc = (String[])idsDesc.toArray(new String[idsDesc.size()]);
		        TerminoYPadreVO[] terminosTraducDesc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsDesc);
		        
		        int jDesc= 0;
		        for (int cont=0;cont<terminosTraducDesc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
		        	
		    		boolean enc=false; 		
		    		while(!enc && jDesc<langDescripcion.length){
		    			if (langDescripcion[jDesc].getIdioma().equals("")){
		    				jDesc++; 
		    			}
		    			else{
		    				enc = true;
		    				langDescripcion[jDesc].setIdioma(terminosTraducDesc[cont].getNomTermino());
		    				jDesc++;
		    			}
		    		}	
		        }
	        }
		}
	}//fin damdIds

	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.print("");
		
	}

	public void cargarAnotacionValidar(
			ActionMapping mapping, 
			CargarAnotacionValidarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		//llenar combos
		cargarCombos(form, request);
		
		
		form.setNombre(nombre);
		form.setOrganizacion(organizacion);
		form.setEmail(email);
		
		form.setFechaCorta(fechaCorta);
		
		form.setThora(hora);
		form.setTminuto(minutos);
		form.setTsegundoP1(segP1);
		form.setTsegundoP2(segP2);
		form.setComboZonaH(comboZonaH);
		
		form.setMeridianoCero(zona);
		form.setZhHora(zhHora);
		form.setZhMinutos(zhMinutos);
		
		Fecha auxFecha = new Fecha();
		auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
		form.setFormato(auxFecha.getFormato());
		form.setOffSet(auxFecha.getOffSet());

		
		form.setDescripcionFechaAsArray(fechdescripcion.getTextos());
		
		form.setDescripcionAsArray(descripcion.getTextos());
	

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
			//		rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleAnotacionCUFormImpl) {
				DetalleAnotacionCUFormImpl formulario=(DetalleAnotacionCUFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof DetalleFormSubmitFormFormImpl) {
				DetalleFormSubmitFormFormImpl formulario=(DetalleFormSubmitFormFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionValidaVolverFormImpl) {
				AnotacionValidaVolverFormImpl formulario=(AnotacionValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			} else if (valor instanceof AnotacionNoValidaVolverFormImpl) {
				AnotacionNoValidaVolverFormImpl formulario=(AnotacionNoValidaVolverFormImpl)valor;
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setDescripcionFecha(formulario.getDescripcionFecha());
				form.setTituloAnotacion(formulario.getTituloAnotacion());
			}
			
			//ENTIDAD
			form.setNombre("");
			form.setOrganizacion("");
			form.setEmail("");
			
			//FECHA
			form.setFechaCorta("");
			
			form.setThora("");
			form.setTminuto("");
			form.setTsegundoP1("");
			form.setTsegundoP2("");
			
			form.setMeridianoCero("");
			form.setZnHora("");
			form.setZnMinutos("");
			form.setComboZonaH("");
			
			Fecha auxFecha = new Fecha();
			auxFecha.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
			form.setFormato(auxFecha.getFormato());
			form.setOffSet(auxFecha.getOffSet());

			//DESCRIPCIONES
			
	    	form.setDescripcionFechaAsArray(new LangStringVO[1]);
	    	form.setDescripcionAsArray(new LangStringVO[1]);
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("detalle.anotacion.cu", ad);
			
		 } catch (Exception e) {
				logger.error("Error en CatalogadorWeb, Categoria detalleAnotacion, metodo reset" + e);
				throw new java.lang.Exception("detalle.anotacion.cu", e);
	    }
		
	}

	public boolean hayAnotaciones(
			ActionMapping mapping, 
			HayAnotacionesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvAnnotationVO[] anotaciones =catalogadorAvSession.getMDSesion().getAnotaciones();
	    		if (anotaciones == null || anotaciones.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	   
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("anotacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayAnotaciones "+ e);
			throw new java.lang.Exception("anotacion", e);
		}
		return result;
	}




	
	public boolean hayAnotacionesGuardar(
			ActionMapping mapping,
			HayAnotacionesGuardarForm form, 
			HttpServletRequest request,
			HttpServletResponse response) 
	throws Exception 
	{		boolean result = false;
	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	try {
    	if (catalogadorAvSession.getMDSesion()!=null) {
    		AvAnnotationVO[] anotaciones =catalogadorAvSession.getMDSesion().getAnotaciones();
    		if (anotaciones == null || anotaciones.length == 0 ){
    			result = false;
    		}
    		else 
    			result = true;
   
    	}
	}catch (org.acegisecurity.AccessDeniedException ad) {
		logger.error("Error Acceso Denegado " + ad);
		throw new java.lang.Exception("anotacion", ad);
	}catch (Exception e) {
		logger.error("Error AnotacionController, método hayAnotacionesGuardar "+ e);
		throw new java.lang.Exception("anotacion", e);
	}
	return result;
}
	
	
}