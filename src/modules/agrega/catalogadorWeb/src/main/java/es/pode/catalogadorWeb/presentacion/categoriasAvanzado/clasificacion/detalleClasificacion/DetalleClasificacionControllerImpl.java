/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.catalogacion.negocio.servicios.AvClassificationVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.EntryVO;
import es.pode.catalogacion.negocio.servicios.FuenteVO;
import es.pode.catalogacion.negocio.servicios.IdVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.PalabraClaveVO;
import es.pode.catalogacion.negocio.servicios.RutaTaxonomicaVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.TaxonVO;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiasFormImpl;
import es.pode.catalogadorWeb.presentacion.tesauros.TesaurosFormImpl;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController
 */
public class DetalleClasificacionControllerImpl extends DetalleClasificacionController
{   
	private static final String HTTP ="http://";
	private static final String BARRA ="/";
	private static final String SEPARADOR =":";

	protected static Logger logger = Logger.getLogger(DetalleClasificacionControllerImpl.class); 
	private DescripcionVO descripcion;
	private String razon;
	private PalabraClaveVO[] palabrasClave;
	private RutaTaxonomicaVO[] rutasTaxonomicas;
	int indi;

    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#cargarDetalleClasificacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarDetalleClasificacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDetalleClasificacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarDetalleClasificacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
 			String botonPulsado = form.getBotonPulsado();
 			
 			//Para saber si viene de las taxonomias o la lista de clasificaciones
 			if (botonPulsado==null && catalogadorAvSession.getClasificacionAux() !=null)
 				botonPulsado=prop.getProperty("botonModificar")!=null?prop.getProperty("botonModificar"):"";
 			else if(!prop.getProperty("botonModificar").equals(botonPulsado))
 				botonPulsado=null;
 			
 			
// 			form.setBotonPulsado(botonPulsado); //actualizamos si es modificar o crear
// 			String titulo = request.getParameter("titulo");
 			
 			if (form.getTituloClasificacion()==null)
 				form.setTituloClasificacion(catalogadorAvSession.getTituloCategoria());
 			else 
 	 			catalogadorAvSession.setTituloCategoria(form.getTituloClasificacion()); //si el titulo no es null lo metemos en sesion
 			
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
						form.setRazonBackingList(idDest, "idTermino", "nomTermino");
						
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
		    	 int posicionClasi= Integer.parseInt(form.getTituloClasificacion()) -1;
		    	 
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
		    			form.setRazon(datosVO[0].getIdTermino()!=null?datosVO[0].getIdTermino():""); //marcamos el combo de source con su valor
	    			} else {
	    				form.setRazon(sourceProp);
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
		    	String titulo ="1";
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
				 form.setRazon("");
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


//Metodo auxiliar para recoger la accion que vamos a ejecutar
    private String obtenerAccion(HttpServletRequest request) throws Exception {

          String accion="";
          String[] partes;
          for (Enumeration names = request.getParameterNames();accion.equals("") && names.hasMoreElements();)
           {
              String name = String.valueOf(names.nextElement());
              if(name.startsWith("accion")) {
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



    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#accionSubmit(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AccionSubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String accionSubmit(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AccionSubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String resAction = "";
    	//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    	ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
        
        String accion;
        if(form.getAccion()==null || form.getAccion().equals("")){
            accion= obtenerAccion(request);
        	form.setAccion(accion);
        }
        else
           accion=form.getAccion();

        /////////////////////////////////////////////////////////////////////////////
        // En caso de Eliminar Recogemos los identificadores a eliminar
        String[] accionPartes = accion.split("-");
		accion = accionPartes[0];
		if (accionPartes.length  > 1){
			request.setAttribute("posicion", accionPartes[1]);
			if (accionPartes.length == 3)
				request.setAttribute("posicionExterior", accionPartes[2]);
		}
		
//        if (datosResources.getString("detalleclasi.SeleccionarTaxones").equals(accion)) {
//              resAction = "Seleccionar Taxones";
//              
//        }
//        else if (datosResources.getString("detalleclasi.AñadirRutaTaxonomica").equals(accion)) {
//        	resAction ="Añadir Ruta Taxonomica";
//        	
//        } else if (datosResources.getString("detalleclasi.EliminarRutaTaxonomica").equals(accion)) {
//        	resAction ="Eliminar Ruta Taxonomica";
//        	
//        } else if (datosResources.getString("detalleclasi.AñadirDescripcion").equals(accion)) {
//        	resAction ="Añadir Descripcion";
//        	
//        } else if (datosResources.getString("detalleclasi.EliminarDescripcion").equals(accion)) {
//        	resAction ="Eliminar Descripcion";
//        	
//        } else if (datosResources.getString("detalleclasi.AñadirPalabraClave").equals(accion)) {
//        	resAction ="Añadir Palabra Clave";
//        	
//        } else if (datosResources.getString("detalleclasi.EliminarPalabraClave").equals(accion)) {
//        	resAction ="Eliminar Palabra Clave";
//        	
//        } 
//        else 
        if (datosResources.getString("detalleclasi.Validar").equals(accion)) {
        	resAction ="Validar";
        	
        } else if (datosResources.getString("detalleclasi.Aceptar").equals(accion)) {
        	resAction ="Aceptar";
        	
        }
//        else if (datosResources.getString("detalleclasi.AñadirDetallePalabraClave").equals(accion)) {
//        	resAction="Añadir Detalle Palabra Clave";
//        
//        }else if (datosResources.getString("detalleclasi.EliminarDetallePalabraClave").equals(accion)) {
//        	resAction="Eliminar Detalle Palabra Clave";
//        	
//        }
        else if (datosResources.getString("detalleclasi.Cancelar").equals(accion)) {
        	resAction="Cancelar";
        }else if (datosResources.getString("detalleclasi.Reset").equals(accion)) {
        	resAction="Reset";
        }else 
        	resAction =accion;
        
        return resAction;
    }




    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#anadirRutaTaxonomica(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirRutaTaxonomicaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirRutaTaxonomica(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirRutaTaxonomicaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//solo añadimos una ruta si tiene el primer taxon relleno!!
    	Object valor = request.getSession().getAttribute("form");
    	try{
	    	if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
			form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			form.setPalabrasClaveAsArray(palabrasClave);
			boolean anadir=false;
			// comprobamos que la ultima ruta tenga taxones
	    	if ((rutasTaxonomicas!=null) && (rutasTaxonomicas.length>0)) {
	    		RutaTaxonomicaVO rutaTaxonomica= new RutaTaxonomicaVO();
	    		int ind = rutasTaxonomicas.length-1;
	    		rutaTaxonomica = rutasTaxonomicas[ind];
	    		if (rutaTaxonomica!=null) {
	    			TaxonVO[] taxonUno = rutaTaxonomica.getTaxones();
	    			if(taxonUno!=null && taxonUno.length>0){
	    				int cont=0;
	    				while(cont<taxonUno.length && anadir==false){
	    					if(taxonUno[cont].getId()!=null && taxonUno[cont].getId().getTexto()!=null && !taxonUno[cont].getId().getTexto().equals("")){
	    						anadir=true;
	    					}else{
	    						boolean encontradoTexto=false;
	    						int cont2=0;
	    						EntryVO entrada=taxonUno[cont].getEntry();
	    						if(entrada!=null && entrada.getTextos()!=null && entrada.getTextos().length>0){
	    							while(cont2<entrada.getTextos().length && encontradoTexto==false){
	    								LangStringVO textoEntra=entrada.getTextos()[cont2];
	    								if(textoEntra!=null &&  textoEntra.getTexto()!=null && !textoEntra.getTexto().equals("")){
	    									encontradoTexto=true;
	    									anadir=true;
	    								}
	    								cont2++;
	    							}
	    						}
	    					}
	    					cont++;
	    				}
	    			}
	    		} 
	    	}
	    	
	    	if (anadir) { //añadimos uno mas
	    		
	    		ArrayList rutasArr= new ArrayList();
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
				int nuevoTamano = rutasTaxonomicas.length + 1;
				RutaTaxonomicaVO[] newrut = new RutaTaxonomicaVO[nuevoTamano];
				
				for (int i=0; i< rutasTaxonomicas.length; i++) {
					newrut[i]=rutasTaxonomicas[i];
				}
				newrut[nuevoTamano-1] = rt;
				form.setRutaTaxonomicaAsArray(newrut);
			
	    	}else {
	    		//lanzamos el error de validacion
	    		form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
	//    		throw new ValidatorException("{detalleclasi.error.noPuedeCargarTaxones}");
	    		saveErrorMessage(request, "detalleclasi.error.noPuedeCargarTaxones");
	    	}
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo anadirRutaTaxonomica" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo anadirRutaTaxonomica " + e);
			throw new Exception("detalle.clasificacion",e);
		}		    

     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#eliminarRutaTaxonomica(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarRutaTaxonomicaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarRutaTaxonomica(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarRutaTaxonomicaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//    	solo añadimos una ruta si tiene el primer taxon relleno!!
    	Object valor = request.getSession().getAttribute("form");
    	try{
    	
	    	if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
			form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			form.setPalabrasClaveAsArray(palabrasClave);
			
	//		quitamos el elemento correspondiente de descripcion
			String posicion = request.getAttribute("posicion").toString();
			int posDesc = Integer.parseInt(posicion);
			
			RutaTaxonomicaVO[] rutasNew = new RutaTaxonomicaVO[rutasTaxonomicas.length-1];
			for (int i = 0; i<rutasNew.length;i++){
	     		if (i < posDesc)
	     			rutasNew[i] = rutasTaxonomicas[i];
	     		else
	     			rutasNew[i] = rutasTaxonomicas[i+1]; 
	     	}//fin for
			
			if(rutasNew.length==0)
			{
				RutaTaxonomicaVO[] rutaVacia = new RutaTaxonomicaVO[1];
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
				rutaVacia[0]=rt;
				
				//Lo introducimos en el form
				form.setRutaTaxonomicaAsArray(rutaVacia);			
				
			}	
			else form.setRutaTaxonomicaAsArray(rutasNew);	
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo eliminarRutaTaxonomica" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo eliminarRutaTaxonomica " + e);
			throw new Exception("detalle.clasificacion",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#cargarTaxones(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarTaxonesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarTaxones(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarTaxonesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	InputStream is = null;
    	Properties prop = new Properties();
    	Object valor = request.getSession().getAttribute("form");
    	boolean nocargaTax=true;
		boolean hayTaxones=false;
		String source="";
		String idioma = "";
		String url = "";
	    AvClassificationVO clasificacionAux= null;
		SourceValueVO sourceVO = null;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		String vocabName=null;
		try{
    		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
		  
		    if (valor instanceof DetalleClasificacionFormImpl) {
					form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
					form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
					form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
					form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
					form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
					form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
					form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
					form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
					form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
					form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
					
					
				} else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
					form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
					form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
					form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
					form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
					form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
					form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
					form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
					form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
					form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
					form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
				} else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
					form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
					form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
					form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
					form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
					form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
					form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
					form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
					form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
					form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
					form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
				}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
					form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
					form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
					form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
					form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
					form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
					form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
					form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
					form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
					form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
					form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
					
				}else if ((valor instanceof TaxonomiasFormImpl) || (valor instanceof TesaurosFormImpl)){
					//Tenemos que volver a cargar todo el formulario
	//				 llenar combos
					is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			 		prop.load(is);
	
			 		//String idiomaLocale=((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage();
					ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
						 
			 		String idiomaLdap=((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage();
			 		
					String[] l_id = { prop.getProperty("idiomaDestinatario"), prop.getProperty("proposito")}; 
					VocabularioVO[] vocaCombos = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
					
					if ((vocaCombos!=null) && (vocaCombos.length>0)) {
						// Rellenamos combos
						for (int ic=0;ic<vocaCombos.length; ic++) {
							if (vocaCombos[ic].getIdVocabulario().equals(prop.getProperty("proposito"))) {
								// 1.- Combo de Razon-Purpose 9.1
								TerminoVO[] terminosDest = vocaCombos[ic].getTerminos();
	
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
								form.setRazonBackingList(idDest, "idTermino", "nomTermino");
								
							}else if (vocaCombos[ic].getIdVocabulario().equals(prop.getProperty("idiomaDestinatario"))) {
								// 2.- Combo de idiomas sin none language 5.11 
								TerminoVO[] terminosDest = vocaCombos[ic].getTerminos();
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
								Collection idDest2 = Arrays.asList(terminosDest);
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
					Collection termsWVacio= new ArrayList();
					termsWVacio.add(termVacio); //Metemos el vacio para que nos salga en el combo ""
					Iterator zDest = idDest2.iterator();
					while (zDest.hasNext()) {
						termsWVacio.add(zDest.next());
					}
					
					//en terms tenemos un Array de TerminoVO 
						form.setSourceBackingList(termsWVacio, "idTermino", "nomTermino");
						/////////////////// FIN RECOGIDA COMBOS ///////////////////
						AvClassificationVO clVal= null;
						if (catalogadorAvSession.getClasificacionAux()!=null)
							clVal=catalogadorAvSession.getClasificacionAux();
						
						if (clVal!=null) {
							razon=clVal.getProposito().getValor()!=null?clVal.getProposito().getValor():"";
							descripcion= clVal.getDescripcion();
							rutasTaxonomicas = clVal.getRutasTaxonomicas();
							palabrasClave = clVal.getPalabrasClave();
						}
						form.setRazon(razon);
						form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
						form.setDescripcionesAsArray(descripcion.getTextos());
						form.setPalabrasClaveAsArray(palabrasClave);
						
				}
		    	
		    	
				int longitudTextosDesc=form.getDescripciones()!=null?form.getDescripciones().size():0;
				int longiP= form.getPalabrasClave()!=null?form.getPalabrasClave().size():0;
				int[] longitudTextosPCla= new int[longiP];
				for(int i= 0;i< longiP;i++){
					longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
				}
				int longitudPalabrasClave=longiP;
			  	
			  	int longitudRutaTaxonomica=form.getRutaTaxonomica()!=null?form.getRutaTaxonomica().size():0;
			  	int[] longiTextosFuente=new int[longitudRutaTaxonomica];
			  	int[] longiTaxones= new int[longitudRutaTaxonomica];
			  	if (form.getRutaTaxonomica()!=null) {
			  		for(int i= 0;i< longitudRutaTaxonomica;i++){
			  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
			  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
			  		}
			  	}
			  		
			  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
				//Actualizamos los valores del formulario
			  	form.setPalabrasClaveAsArray(palabrasClave);
				form.setRazon(razon);
				form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
				form.setDescripcionesAsArray(descripcion.getTextos());
				//y lo metemos en la sesion!!!!
				 if (catalogadorAvSession!=null){
					clasificacionAux= new AvClassificationVO();
					sourceVO = new SourceValueVO();
					 //dameTerminoId(catalogadorAvSession.getIdioma());
						sourceVO.setSource(AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos")); //source
						sourceVO.setValor(razon);
					 clasificacionAux.setProposito(sourceVO);
					 clasificacionAux.setRutasTaxonomicas(rutasTaxonomicas);
					 clasificacionAux.setDescripcion(descripcion);
					 clasificacionAux.setPalabrasClave(palabrasClave);
					 catalogadorAvSession.setClasificacionAux(clasificacionAux);//metidos los datos
					 catalogadorAvSession.setTituloCategoria(form.getTituloClasificacion());
				 }
				///////////
				 
				//UNA VEZ METIDOS LOS DATOS EN SESION, PARA QUE SI HAY ALGUN PROBLEMA SE QUEDE REFLEJADO EN EL FORMULARIO
				//ACTUALIZAMOS EL OBJETO VALOR
				 
				 if (valor instanceof DetalleClasificacionFormImpl) {
						DetalleClasificacionFormImpl formulario=(DetalleClasificacionFormImpl)valor;
						formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
						formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
						formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
						formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
						formulario.setTituloClasificacion(form.getTituloClasificacion());
						formulario.setRazonLabelList(form.getRazonLabelList());
						formulario.setRazonValueList(form.getRazonValueList());
						formulario.setRutaTaxonomica(form.getRutaTaxonomica());
						formulario.setSourceLabelList(form.getSourceLabelList());
						formulario.setSourceValueList(form.getSourceValueList());
						
						if(rutasTaxonomicas!=null && rutasTaxonomicas.length>0 && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente()!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0]!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto()!=null && !rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto().equals("")){
							String nomFicheroTax=rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto();
							//obtenemos el vocabName de combo
							boolean encontrado=false;
							for(int i=1;i<form.getSourceBackingList().length && !encontrado;i++){
								if(nomFicheroTax.equals(form.getSourceValueList()[i].toString())){
									vocabName=form.getSourceLabelList()[i].toString();
									encontrado=true;
								}
							}
							
						}
						formulario.setVocabName(vocabName);
					} 
			    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
			    		DetalleClasificacionSubmitFormImpl formulario=(DetalleClasificacionSubmitFormImpl)valor;
						formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
						formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
						formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
						formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
						formulario.setTituloClasificacion(form.getTituloClasificacion());
						formulario.setRazonLabelList(form.getRazonLabelList());
						formulario.setRazonValueList(form.getRazonValueList());
						formulario.setRutaTaxonomica(form.getRutaTaxonomica());
						formulario.setSourceLabelList(form.getSourceLabelList());
						formulario.setSourceValueList(form.getSourceValueList());
						if(rutasTaxonomicas!=null && rutasTaxonomicas.length>0 && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente()!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0]!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto()!=null && !rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto().equals("")){
							String nomFicheroTax=rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto();
							//obtenemos el vocabName de combo
							boolean encontrado=false;
							for(int i=1;i<form.getSourceBackingList().length && !encontrado;i++){
								if(nomFicheroTax.equals(form.getSourceValueList()[i].toString())){
									vocabName=form.getSourceLabelList()[i].toString();
									encontrado=true;
								}
							}
						}
						formulario.setVocabName(vocabName);
						
					}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
						ClasificacionNoValidaVolverFormImpl formulario=(ClasificacionNoValidaVolverFormImpl)valor;
						formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
						formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
						formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
						formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
						formulario.setTituloClasificacion(form.getTituloClasificacion());
						formulario.setRazonLabelList(form.getRazonLabelList());
						formulario.setRazonValueList(form.getRazonValueList());
						formulario.setRutaTaxonomica(form.getRutaTaxonomica());
						formulario.setSourceLabelList(form.getSourceLabelList());
						formulario.setSourceValueList(form.getSourceValueList());
						if(rutasTaxonomicas!=null && rutasTaxonomicas.length>0 && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente()!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0]!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto()!=null && !rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto().equals("")){
							String nomFicheroTax=rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto();
							//obtenemos el vocabName de combo
							boolean encontrado=false;
							for(int i=1;i<form.getSourceBackingList().length && !encontrado;i++){
								if(nomFicheroTax.equals(form.getSourceValueList()[i].toString())){
									vocabName=form.getSourceLabelList()[i].toString();
									encontrado=true;
								}
							}
						}
						formulario.setVocabName(vocabName);
					}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
						ClasificacionValidaVolverFormImpl formulario=(ClasificacionValidaVolverFormImpl)valor;
						formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
						formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
						formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
						formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
						formulario.setTituloClasificacion(form.getTituloClasificacion());
						formulario.setRazonLabelList(form.getRazonLabelList());
						formulario.setRazonValueList(form.getRazonValueList());
						formulario.setRutaTaxonomica(form.getRutaTaxonomica());
						formulario.setSourceLabelList(form.getSourceLabelList());
						formulario.setSourceValueList(form.getSourceValueList());
						if(rutasTaxonomicas!=null && rutasTaxonomicas.length>0 && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente()!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0]!=null && rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto()!=null && !rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto().equals("")){
							String nomFicheroTax=rutasTaxonomicas[rutasTaxonomicas.length-1].getFuente().getTextos()[0].getTexto();
							//obtenemos el vocabName de combo
							boolean encontrado=false;
							for(int i=1;i<form.getSourceBackingList().length && !encontrado;i++){
								if(nomFicheroTax.equals(form.getSourceValueList()[i].toString())){
									vocabName=form.getSourceLabelList()[i].toString();
									encontrado=true;
								}
							}

						}
						formulario.setVocabName(vocabName);
					}
				 
				//posicion que hemos pulsado
				String posicion = request.getAttribute("posicion").toString();
				int posDesc = Integer.parseInt(posicion);
				if (rutasTaxonomicas!=null) {
					int lengRutas=rutasTaxonomicas.length;
					if (posDesc<=lengRutas) {
						source=rutasTaxonomicas[posDesc].getFuente().getTextos()[0].getTexto();
						idioma=rutasTaxonomicas[posDesc].getFuente().getTextos()[0].getIdioma();//hay q traducir 1.3.3 por es ejm
						TaxonVO[] tax=rutasTaxonomicas[posDesc].getTaxones();
						String idTex="";
						String entryTex="";
						if (!source.equals("") && !idioma.equals("")) {
							if ((tax!=null) && (tax.length>0)) {
								idTex=tax[0].getId().getTexto();
								LangStringVO[] lanstex=tax[0].getEntry().getTextos();
								if ((lanstex!=null) && (lanstex.length>0)) {
									entryTex=lanstex[0].getTexto();
									if ((idTex.equals("")) && (entryTex.equals(""))){
										hayTaxones=true;
									} else
										hayTaxones=false;
								} 
							}
						} else {
							nocargaTax=false;
						}
	 					
					} 
				}
		} catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("detalle.clasificacion", ad);
		} catch (Exception e) {
    		logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarTaxones " + e);
    		throw new java.lang.Exception("detalle.clasificacion", e);
    		
        }
		
		if ((nocargaTax) && (hayTaxones)) {
			boolean idiomaTesExiste=true;
			try{	
				String nombreTax="";
				String taxOTex="";
				if ((source!=null) && (!source.equals("")&&(source.endsWith("_TAX")||(source.endsWith("_TES"))))) {
					nombreTax=source.substring(0, source.length()-4);
					if(idioma!=null && !idioma.equals("")){
						String[] datoIdiomaRuta= {idioma};
						TerminoYPadreVO[] terminosTraducPCla = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(datoIdiomaRuta);
						idioma=terminosTraducPCla[0].getNomTermino();
						if (source.endsWith("TAX")) {
							taxOTex="/catalogadorWeb/Taxonomias/Taxonomias.do?nomTaxonomia=" + nombreTax + "&idioma=" + idioma +"&vocabName="+vocabName;
						}else if (source.endsWith("TES")) {
							idiomaTesExiste=this.getSrvTesaurosServices().chequearExistenciaIdioma(idioma);
							if(idiomaTesExiste)
							{
								taxOTex="/catalogadorWeb/Tesauros/Tesauros.do?nomTesauro=" + nombreTax + "&idioma=" + idioma +"&vocabName="+ vocabName;
							}
						}		
					}
					else{
						if (source.endsWith("TAX")) {
							taxOTex="/catalogadorWeb/Taxonomias/Taxonomias.do?nomTaxonomia=" + nombreTax + "&idioma=" + catalogadorAvSession.getIdioma() +"&vocabName="+vocabName;
						}else if (source.endsWith("TES")) {
							taxOTex="/catalogadorWeb/Tesauros/Tesauros.do?nomTesauro=" + nombreTax + "&idioma=" + catalogadorAvSession.getIdioma()+"&vocabName="+ vocabName ;
						}
					}
					if(idiomaTesExiste)
					{
						url = HTTP +LdapUserDetailsUtils.getHost()+ LdapUserDetailsUtils.getSubdominio() + taxOTex;
						response.sendRedirect(url);
					}
				}
			}catch (Exception e) {
	    		logger
				.error("Error en Servicio de catalogacion avanzado, metodo cargarTaxones " + e);
	    		throw new java.lang.Exception("detalle.clasificacion", e);
	    		
	        }

			if(!idiomaTesExiste)
				throw new ValidatorException("{detalleclasi.error.tesauroSinIdioma}");
				
		  } else{
			  if (hayTaxones) 
				  throw new ValidatorException("{detalleclasi.error.hayTaxones}");
			  else
			    throw new ValidatorException("{detalleclasi.error.yaDatos}");
		  }
    	
     }

    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#anadirDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//datos de sesion del formulario
    	Object valor = request.getSession().getAttribute("form");
    	try {
	    	//	rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
				
			} else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
			int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
			//Actualizamos los valores del formulario
		  	form.setPalabrasClaveAsArray(palabrasClave);
			form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			
			//Tenemos que añadir una descripcion
			int nuevoTamano = descripcion.getTextos().length +1;
		    LangStringVO[] newALang = new LangStringVO[nuevoTamano];
			LangStringVO newDesc=new LangStringVO();
			newDesc.setIdioma("");
			newDesc.setTexto("");
			 
			for(int i = 0; i<descripcion.getTextos().length;i++)
			  newALang[i]=descripcion.getTextos()[i];
			  
			newALang[nuevoTamano-1]= newDesc;
			form.setDescripcionesAsArray(newALang); //metemos la nueva descripcion
    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo anadirDescripcion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo anadirDescripcion " + e);
			throw new Exception("detalle.clasificacion",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#eliminarDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//    	datos de sesion del formulario
    	Object valor = request.getSession().getAttribute("form");
    	try{
	    	//	rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
				
			} else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
			int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
			//Actualizamos los valores del formulario
		  	form.setPalabrasClaveAsArray(palabrasClave);
			form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			//quitamos el elemento correspondiente de descripcion
			String posicion = request.getAttribute("posicion").toString();
			
			int posDesc = Integer.parseInt(posicion);
			LangStringVO[] descOld = descripcion.getTextos();
			LangStringVO[] descActual = new LangStringVO[descOld.length-1];
			for (int i = 0; i<descActual.length;i++){
	     		if (i < posDesc)
	     			descActual[i] = descOld[i];
	     		else
	     			descActual[i] = descOld[i+1]; 
	     	}//fin for
			form.setDescripcionesAsArray(descActual); //todos menos esa posicion
    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo eliminarDescripcion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo eliminarDescripcion " + e);
			throw new Exception("detalle.clasificacion",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#anadirPalabraClave(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirPalabraClaveForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirPalabraClave(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirPalabraClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//  	datos de sesion del formulario
    	Object valor = request.getSession().getAttribute("form");
    	try{
	    	if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
			//Actualizamos los valores del formulario
	
			form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			//Tenemos que añadir una nueva palabra clave
			form.setPalabrasClaveAsArray(palabrasClave);
			 
			Object[] aPalabrasClave=form.getPalabrasClaveAsArray();
	        int nuevoTamano = aPalabrasClave.length +1;
	        Object[] newAPalabrasClave = new Object[nuevoTamano];
	        PalabraClaveVO palabraClaveVO=new PalabraClaveVO();
	  	    LangStringVO[] aLangString=new LangStringVO[1];
	  	    LangStringVO langString = new LangStringVO();
	  	    langString.setIdioma("");
	  	    langString.setTexto("");
	  	    aLangString[0]= langString;
	  	    palabraClaveVO.setTextos(aLangString);
	  	    for(int i = 0; i<aPalabrasClave.length;i++)
	  		   newAPalabrasClave[i]=aPalabrasClave[i];
	  	    newAPalabrasClave[nuevoTamano-1]= palabraClaveVO;
	  	   
	  	   form.setPalabrasClaveAsArray(newAPalabrasClave);
    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo anadirPalabraClave" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo anadirPalabraClave " + e);
			throw new Exception("detalle.clasificacion",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#eliminarPalabraClave(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarPalabraClaveForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarPalabraClave(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarPalabraClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//  	datos de sesion del formulario
    	Object valor = request.getSession().getAttribute("form");
    	try{
	    	if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
		  	
		  	form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			//Tenemos que añadir una nueva palabra clave
			form.setPalabrasClaveAsArray(palabrasClave);
			
	    	 //posicion del identificador que se quiere eliminar   
	        String posicion = request.getAttribute("posicion").toString();
	        int posicionInt = Integer.parseInt(posicion);
	    	PalabraClaveVO[] aPalabrasClave = (PalabraClaveVO[]) form.getPalabrasClaveAsArray();
	    	PalabraClaveVO[] nuevoPalabrasClave = new PalabraClaveVO[aPalabrasClave.length -1];
	    	//añado al nuevo array de PalabrasClave todas las palabrasClave menos la que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoPalabrasClave.length;i++){
	    		if (i < posicionInt)
	    			nuevoPalabrasClave[i] = aPalabrasClave[i];
	    		else
	    			nuevoPalabrasClave[i] = aPalabrasClave[i+1]; 
	    	}
	    	form.setPalabrasClaveAsArray(nuevoPalabrasClave);
	    
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo eliminarPalabraClave " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo eliminarPalabraClave " + e);
			throw new Exception("detalle.clasificacion",e);
		}
     }

    
    public void anadirContenidoPalabraClave(ActionMapping mapping, AnadirContenidoPalabraClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	Object valor = request.getSession().getAttribute("form");
    	try {
	    	if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
		  	
		  	form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			//Tenemos que añadir una nueva palabra clave
			form.setPalabrasClaveAsArray(palabrasClave);
			
			String posicion = request.getAttribute("posicion").toString();
		    int posicionInt = Integer.parseInt(posicion);//posicion de la PalabraClave a la que se quiere añadir contenido
	    	//se recogen todas las palabrasClave
	    	PalabraClaveVO[] aPalabrasClave = (PalabraClaveVO[]) form.getPalabrasClaveAsArray();
	    	//recogo los textos de la palabra clave indicada y le añado un nuevo texto
	    	LangStringVO[] textos = aPalabrasClave[posicionInt].getTextos();
	    	LangStringVO[] nuevoTextos = new LangStringVO[textos.length+1];
	    	for(int i = 0 ; i < textos.length;i++){
	    		nuevoTextos[i]= textos[i];
	    	}
	    	LangStringVO nuevoTexto = new LangStringVO();
	    	nuevoTexto.setIdioma("");
	    	nuevoTexto.setTexto("");
	    	nuevoTextos[nuevoTextos.length-1] = nuevoTexto;
	    	aPalabrasClave[posicionInt].setTextos(nuevoTextos);
	    	form.setPalabrasClaveAsArray(aPalabrasClave);
	    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo anadirContenidoPalabraClave" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo anadirContenidoPalabraClave " + e);
			throw new Exception("detalle.clasificacion",e);
		}
    	
	}




	public void eliminarContenidoPalabraClave(ActionMapping mapping, EliminarContenidoPalabraClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Object valor = request.getSession().getAttribute("form");
    	try{
	    	if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
		  	
		  	form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			//Tenemos que añadir una nueva palabra clave
			form.setPalabrasClaveAsArray(palabrasClave);
			
	//		posicion de contenido a eliminar   
	        String posicion = request.getAttribute("posicion").toString();
	        int posicionInt = Integer.parseInt(posicion);
			
	//      posicion de la palabraClave de la que se quiere eliminar parte de su contenido
	        String posicionExt = request.getAttribute("posicionExterior").toString();
	        int posicionExtInt = Integer.parseInt(posicionExt);
			
	    	PalabraClaveVO[] aPalabrasClave = (PalabraClaveVO[]) form.getPalabrasClaveAsArray();
	    	LangStringVO[] contenido = aPalabrasClave[posicionExtInt].getTextos();
	    	LangStringVO[] nuevoContenido = new LangStringVO[contenido.length -1];
	    	//añado al nuevo array de contenidos todos los contenidos menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoContenido.length;i++){
	    		if (i < posicionInt)
	    			nuevoContenido[i] = contenido[i];
	    		else
	    			nuevoContenido[i] = contenido[i+1]; 
	    	}
	    	aPalabrasClave[posicionExtInt].setTextos(nuevoContenido);
	    	form.setPalabrasClaveAsArray(aPalabrasClave);
	    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoria DetalleClasificacion, metodo anadirContenidoPalabraClave" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoria DetalleClasificacion, metodo anadirContenidoPalabraClave " + e);
			throw new Exception("detalle.clasificacion",e);
		}
	    	
	}

    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#esValidoClasificacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EsValidoClasificacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean esValidoClasificacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EsValidoClasificacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	InputStream is = null;
		Properties prop = new Properties();
		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
		prop.load(is);
		
		Collection mensajes = new ArrayList();
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		CatalogadorAvSession os = this.getCatalogadorAvSession(request);
			
//    	Recoge los valores y los cambios en el formulario
		Object valor = request.getSession().getAttribute("form");
		//rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
		if (valor instanceof DetalleClasificacionFormImpl) {
			form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
			form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
			form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
			form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
			form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
			form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
			form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
			form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
			form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
			form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
		} 
    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
			form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
			form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
			form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
			form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
			form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
			form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
			form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
			form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
			form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
			form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			
		} else if (valor instanceof ClasificacionValidaVolverFormImpl) {
			form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
			form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
			form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
			form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
			form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
			form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
			form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
			form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
			form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
			form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			
		}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
			form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
			form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
			form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
			form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
			form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
			form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
			form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
			form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
			form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
			form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			
		}
    	
		int longitudTextosDesc=form.getDescripciones().size();
		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
		for(int i= 0;i< form.getPalabrasClave().size();i++){
			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
		}
		int longitudPalabrasClave=form.getPalabrasClave().size();
	  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
	  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
	  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
	  	if (form.getRutaTaxonomica()!=null) {
	  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
	  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
	  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
	  		}
	  	}
	  		
	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
	  	
	  	AvClassificationVO cl = new AvClassificationVO();
	  	SourceValueVO proposito = new SourceValueVO();
		proposito.setSource(AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos")); //source
		proposito.setValor(razon);
		cl.setProposito(proposito);
	  	cl.setDescripcion(descripcion);
	  	cl.setPalabrasClave(palabrasClave);
	  	cl.setRutasTaxonomicas(rutasTaxonomicas);
	  	ArrayList arrCl = new ArrayList();
	  	arrCl.add(cl);
	  	AvClassificationVO[] avClasiValida = (AvClassificationVO[])arrCl.toArray(new AvClassificationVO[arrCl.size()]);
	  	os.setLomValidacion(new LomAvanzadoVO());
		os.getLomValidacion().setClasificaciones(avClasiValida);
		String titulo = form.getTituloClasificacion()!=null?form.getTituloClasificacion():"0";
		os.setTituloCategoria(titulo);
		this.setCatalogadorAvSession(request, os);
	  	
	  	if(cl.getProposito()!=null){
			if ((cl.getProposito().getValor()==null)||(cl.getProposito().getValor().equals(""))){
				mensajes.add(datosResources.getString("CAV.9.1"));
			}
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
						mensajes.add(datosResources.getString("CAV.9.2"));
						todoVacio=false;
					}
				}
				
				if(cl.getRutasTaxonomicas()[i].getFuente()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos().length>0 && todoVacio){
					String sce= cl.getRutasTaxonomicas()[i].getFuente().getTextos()[0].getTexto();
					if ((sce==null)||(sce.equals(""))){
						mensajes.add(datosResources.getString("CAV.9.2.1"));
						errorDado=false;
					}
					
				}
				if(cl.getRutasTaxonomicas()[i].getTaxones()!=null && cl.getRutasTaxonomicas()[i].getTaxones().length==1 ){
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
							mensajes.add(datosResources.getString("CAV.9.2.2"));
							errorDado=false;
						}
					}else{
						mensajes.add(datosResources.getString("CAV.9.2.2"));
						errorDado=false;
					}
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







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#guardarClasificacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.GuardarClasificacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarClasificacion(
    		ActionMapping mapping,
    		GuardarClasificacionForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	boolean errorFaltaIdioma = false;
		boolean errorFaltaTexto = false;
		boolean errorDatosEntidad = false;
		boolean errorFechaObli = false;
		
		boolean errorFuenteTexto=false;
		boolean errorFuenteIdioma=false;
		boolean errorTaxones=false;
		RutaTaxonomicaVO[] rutasT=null;
		InputStream is = null;
		Properties prop = new Properties();
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		AvClassificationVO clasificacionG = null;
		
		try{
			is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			
			String usuario =LdapUserDetailsUtils.getUsuario();
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
			// metemos en la sesion el parametro de vuelta al empaquetador
			catalogadorAvSession.setReturnURL(returnURL);
			//Recoge los valores y los cambios en el formulario
			Object valor = request.getSession().getAttribute("form");
			//rellenamos los datos del formulario dependiendo del tipo de formulario que nos venga
			if (valor instanceof DetalleClasificacionFormImpl) {
				form.setComboIdiomaValueList(((DetalleClasificacionFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionFormImpl)valor).getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
	    		form.setComboIdiomaValueList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaValueList());
				form.setComboIdiomaLabelList(((DetalleClasificacionSubmitFormImpl)valor).getComboIdiomaLabelList());
				form.setDescripciones(((DetalleClasificacionSubmitFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((DetalleClasificacionSubmitFormImpl)valor).getPalabrasClave());
				form.setTituloClasificacion(((DetalleClasificacionSubmitFormImpl)valor).getTituloClasificacion());
				form.setRazonValueList(((DetalleClasificacionSubmitFormImpl)valor).getRazonValueList());
				form.setRazonLabelList(((DetalleClasificacionSubmitFormImpl)valor).getRazonLabelList());
				form.setRutaTaxonomica(((DetalleClasificacionSubmitFormImpl)valor).getRutaTaxonomica());
				form.setSourceValueList(((DetalleClasificacionSubmitFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((DetalleClasificacionSubmitFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionNoValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionNoValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionNoValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionNoValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionNoValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionNoValidaVolverFormImpl)valor).getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				form.setComboIdiomaLabelList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaLabelList());
				form.setComboIdiomaValueList(((ClasificacionValidaVolverFormImpl)valor).getComboIdiomaValueList());
				form.setDescripciones(((ClasificacionValidaVolverFormImpl)valor).getDescripciones());
				form.setPalabrasClave(((ClasificacionValidaVolverFormImpl)valor).getPalabrasClave());
				form.setRazonLabelList(((ClasificacionValidaVolverFormImpl)valor).getRazonLabelList());
				form.setRazonValueList(((ClasificacionValidaVolverFormImpl)valor).getRazonValueList());
				form.setRutaTaxonomica(((ClasificacionValidaVolverFormImpl)valor).getRutaTaxonomica());
				form.setTituloClasificacion(((ClasificacionValidaVolverFormImpl)valor).getTituloClasificacion());
				form.setSourceValueList(((ClasificacionValidaVolverFormImpl)valor).getSourceValueList());
				form.setSourceLabelList(((ClasificacionValidaVolverFormImpl)valor).getSourceLabelList());
			}
	    	
	    	int longitudTextosDesc=form.getDescripciones().size();
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int longitudPalabrasClave=form.getPalabrasClave().size();
		  	int longitudRutaTaxonomica=form.getRutaTaxonomica().size();
		  	int[] longiTextosFuente=new int[form.getRutaTaxonomica().size()];
		  	int[] longiTaxones= new int[form.getRutaTaxonomica().size()];
		  	if (form.getRutaTaxonomica()!=null) {
		  		for(int i= 0;i< form.getRutaTaxonomica().size();i++){
		  			longiTextosFuente[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getFuente().getTextos().length;
		  			longiTaxones[i]=((RutaTaxonomicaVO)(form.getRutaTaxonomicaAsArray()[i])).getTaxones().length;
		  		}
		  	}
		  		
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudPalabrasClave,longitudRutaTaxonomica, longiTextosFuente, longiTaxones, null);
		  	form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			form.setPalabrasClaveAsArray(palabrasClave);
			//MODIFICAMOS VALOR!!
			if (valor instanceof DetalleClasificacionFormImpl) {
				DetalleClasificacionFormImpl formulario=(DetalleClasificacionFormImpl)valor;
				formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
				formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
				formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
				formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
				formulario.setTituloClasificacion(form.getTituloClasificacion());
				formulario.setRazonLabelList(form.getRazonLabelList());
				formulario.setRazonValueList(form.getRazonValueList());
				formulario.setRutaTaxonomica(form.getRutaTaxonomica());
				formulario.setSourceLabelList(form.getSourceLabelList());
				formulario.setSourceValueList(form.getSourceValueList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
	    		DetalleClasificacionSubmitFormImpl formulario=(DetalleClasificacionSubmitFormImpl)valor;
				formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
				formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
				formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
				formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
				formulario.setTituloClasificacion(form.getTituloClasificacion());
				formulario.setRazonLabelList(form.getRazonLabelList());
				formulario.setRazonValueList(form.getRazonValueList());
				formulario.setRutaTaxonomica(form.getRutaTaxonomica());
				formulario.setSourceLabelList(form.getSourceLabelList());
				formulario.setSourceValueList(form.getSourceValueList());
				
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				ClasificacionNoValidaVolverFormImpl formulario=(ClasificacionNoValidaVolverFormImpl)valor;
				formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
				formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
				formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
				formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
				formulario.setTituloClasificacion(form.getTituloClasificacion());
				formulario.setRazonLabelList(form.getRazonLabelList());
				formulario.setRazonValueList(form.getRazonValueList());
				formulario.setRutaTaxonomica(form.getRutaTaxonomica());
				formulario.setSourceLabelList(form.getSourceLabelList());
				formulario.setSourceValueList(form.getSourceValueList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				ClasificacionValidaVolverFormImpl formulario=(ClasificacionValidaVolverFormImpl)valor;
				formulario.setComboIdiomaLabelList(form.getComboIdiomaLabelList());
				formulario.setComboIdiomaValueList(form.getComboIdiomaValueList());
				formulario.setDescripcionesAsArray(form.getDescripcionesAsArray());
				formulario.setPalabrasClaveAsArray(form.getPalabrasClaveAsArray());
				formulario.setTituloClasificacion(form.getTituloClasificacion());
				formulario.setRazonLabelList(form.getRazonLabelList());
				formulario.setRazonValueList(form.getRazonValueList());
				formulario.setRutaTaxonomica(form.getRutaTaxonomica());
				formulario.setSourceLabelList(form.getSourceLabelList());
				formulario.setSourceValueList(form.getSourceValueList());
			}
			
			////////////////////////////////////////////////////////////////////////////
			//Hasta aqui tenemos recogidos todos los cambios del formulario que vams a guardar
			clasificacionG = new AvClassificationVO();
			clasificacionG.setRutasTaxonomicas(rutasTaxonomicas);
			 //clasificacionG.setRutasTaxonomicas(rutasT);
			
			 //Guardamos DESCRIPCIONES
			 if (descripcion != null) {
				LangStringVO[] landDesc = descripcion.getTextos();
				ArrayList descAux = new ArrayList();
				for (int d=0; d< landDesc.length; d++){
					if (landDesc[d]!=null) {
						String textoDesc=landDesc[d].getTexto();
						String idioDesc=landDesc[d].getIdioma();
						if(((textoDesc!=null)&&(!textoDesc.equals(""))) && ((idioDesc!=null)&&(!idioDesc.equals("")))){
							LangStringVO lanDescAux= new LangStringVO();
							lanDescAux.setTexto(textoDesc);
							lanDescAux.setIdioma(idioDesc);
							descAux.add(lanDescAux); //lo metemos en el array auxiliar
						}else{//comprueba si alguno esta incompleto
							if (idioDesc.equals("") && !textoDesc.equals("") )
								errorFaltaIdioma = true;
							if (!idioDesc.equals("") && textoDesc.equals("") )
								errorFaltaTexto = true;
						} 
							
					}
				}
				LangStringVO[] textos =null;
				if (descAux.size()>0) 
					textos = (LangStringVO[])descAux.toArray(new LangStringVO[descAux.size()]);
					descripcion.setTextos(textos);
			 }
			 clasificacionG.setDescripcion(descripcion);
			
			 //Guardamos PALABRAS CLAVE
			 ArrayList listaPalabras=null;
			 if(palabrasClave!=null && palabrasClave.length !=0){
			   LangStringVO[] textos = palabrasClave[0].getTextos();
			   if (palabrasClave.length== 1 && textos.length == 1 & textos[0].getIdioma().equals("") 
					&& textos[0].getTexto().equals("")){
						palabrasClave= null;		
			   }
			   else{
				listaPalabras=new ArrayList();
				for(int i=0;i<palabrasClave.length;i++){
					if(palabrasClave[i]!=null){
						ArrayList listPalabras=new ArrayList();
						PalabraClaveVO lPalabras=(PalabraClaveVO)(palabrasClave[i]);
						PalabraClaveVO lPalabrasClave=new PalabraClaveVO();
						for(int j=0;j<lPalabras.getTextos().length;j++){
							LangStringVO lang=(LangStringVO)(lPalabras.getTextos()[j]);
							LangStringVO lLang=new LangStringVO();
							String idioma=lang.getIdioma();
							String texto=lang.getTexto();
							if(((idioma!=null)&&(!idioma.equals("")))&&((texto!=null)&&(!texto.equals("")))){
								lLang.setIdioma(idioma);
								lLang.setTexto(texto);
								listPalabras.add(lLang);
							}else{
								if (idioma.equals("") && !texto.equals("") )
									errorFaltaIdioma = true;
								if (!idioma.equals("") && texto.equals("") )
									errorFaltaTexto = true;
										
							}
						 }
						 if (listPalabras.size() != 0){
							LangStringVO[] langs=(LangStringVO[])listPalabras.toArray(new LangStringVO[listPalabras.size()]); 
							lPalabrasClave.setTextos(langs);  
							listaPalabras.add(lPalabrasClave);
						 }
					}
				}
				if (listaPalabras.size() == 0)
					palabrasClave = null;
				else
					palabrasClave=(PalabraClaveVO[])listaPalabras.toArray(new PalabraClaveVO[listaPalabras.size()]);
			 }
			}//fin inicio palabra clave
			else
				palabrasClave =null;
			 clasificacionG.setPalabrasClave(palabrasClave);
			 
			 
			 
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("detalle.clasificacion", ad);
		}catch (Exception e) {
    		logger
			.error("Error en catalogadorWeb, categoria DetalleClasificacion, metodo guardarMetadatos " + e);
    		throw new java.lang.Exception("detalle.clasificacion", e);
    		
        } 
			 //fin
		if(!errorFuenteTexto && !errorFuenteIdioma  && !errorTaxones && !errorFaltaIdioma && !errorFaltaTexto){	
		   try{	
		 	 //no hay errores y guardamos
			  String titulo="";
			  titulo=form.getTituloClasificacion();
			  if (titulo==null) {
				  titulo=catalogadorAvSession.getTituloCategoria()!=null?catalogadorAvSession.getTituloCategoria():"1";
			  }
			  int posiTitu = Integer.parseInt(titulo) -1;
				
				//Obtnemos los terminos de los ids seleccionados en todos los combos
				dameTerminoId("en"); //para guardar es en ingles
//				Guardamos PROPOSITO (RAZON)
				 SourceValueVO proposito = new SourceValueVO();
				 proposito.setSource(AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos")); //source
				 proposito.setValor(razon!=null?razon:""); //Tengo q recoger su nombre dameId
				 clasificacionG.setProposito(proposito);
				 
				 //RUTAS TAXONOMICAS
				//volvemos a guardar las rutas q ya estan traducidas ejm idioma --> es en vez de 5.1.1
				 //Añadimos los cambios para que no cargue las etiquetas vacías
				 ArrayList arrayRutas=new ArrayList();
				 if(rutasTaxonomicas!=null && rutasTaxonomicas.length>0){
					 for(int i=0;i<rutasTaxonomicas.length;i++){
						FuenteVO fuente= rutasTaxonomicas[i].getFuente();
						
						if(fuente!=null && fuente.getTextos()!=null && fuente.getTextos().length>0){
//							comprobamos que si es la ultima ruta taxonomica tenga taxones asociados si no es asi
//							quiere decir que tenemos los combos y no guardamos esos valores pues no hay taxones
							if(i!=rutasTaxonomicas.length-1 || (i== rutasTaxonomicas.length-1 && tieneTaxonNoVacio())){
								LangStringVO[] langFuente = fuente.getTextos();
								for(int j=0;j<langFuente.length;j++){
									String langIdioma=langFuente[j].getIdioma();
									langFuente[j].setIdioma(langIdioma);
									String langTexto=langFuente[j].getTexto();
									if((langTexto==null || langTexto.equals(""))){
										fuente=null;
									}
								}
							}else fuente = null;
						}else{
							fuente=null;
						}
						rutasTaxonomicas[i].setFuente(fuente);
						TaxonVO[] taxones = rutasTaxonomicas[i].getTaxones();
						ArrayList arrayTaxo=new ArrayList();
						
						if(taxones!=null && taxones.length>0){
							for(int j=0;j<taxones.length;j++){
								EntryVO entry=taxones[j].getEntry();
								if(entry!=null && entry.getTextos()!=null && entry.getTextos().length>0){
									LangStringVO[] entryTex = entry.getTextos();
									for(int k=0;k<entryTex.length;k++){
										String idiomaEntry=entryTex[k].getIdioma();
										entryTex[k].setIdioma(idiomaEntry);
										String textoEntry=entryTex[k].getTexto();
										if((idiomaEntry==null || idiomaEntry.equals("")&&(textoEntry==null || textoEntry.equals("")))){
											entry=null;
										}
									}
								}else{
									entry=null;
								}
								IdVO id = taxones[j].getId();
								String textoId=id.getTexto();
								if(textoId==null || textoId.equals(""))
									id=null;
								if(id!=null && textoId!=null && !textoId.equals("")){
									LangStringVO[] lang=null;
									entry=taxones[j].getEntry();
									if(entry!=null && entry.getTextos()!=null && entry.getTextos().length>0){
										LangStringVO[] entryTex = entry.getTextos();
										ArrayList arrayEntry=new ArrayList();
										for(int k=0;k<entryTex.length;k++){
											
											String textoEntry=entryTex[k].getTexto();
											if(textoEntry!=null && !textoEntry.equals("")){
												arrayEntry.add(entryTex[k]);
											}
										}
										lang=(LangStringVO[])arrayEntry.toArray(new LangStringVO[arrayEntry.size()]);
										entry.setTextos(lang);
									}else{
										entry=null;
									}
									
								}
								
								if(entry==null && id==null){
									taxones[j]=null;	
								}
	
							if(taxones[j]!=null)
								arrayTaxo.add(taxones[j]);
							}
	
						}
						if(arrayTaxo!=null && arrayTaxo.size()>0){
							taxones=(TaxonVO[])arrayTaxo.toArray(new TaxonVO[arrayTaxo.size()]);
						}else{
							taxones=new TaxonVO[0];
						}
						rutasTaxonomicas[i].setTaxones(taxones);
						if(rutasTaxonomicas[i].getFuente()==null && (rutasTaxonomicas[i].getTaxones()==null ||rutasTaxonomicas[i].getTaxones().length==0))
							rutasTaxonomicas[i]=null;
						if(rutasTaxonomicas[i]!=null)
							arrayRutas.add(rutasTaxonomicas[i]);
					 }
					 if(arrayRutas!=null && arrayRutas.size()>0){
						 rutasTaxonomicas=(RutaTaxonomicaVO[])arrayRutas.toArray(new RutaTaxonomicaVO[arrayRutas.size()]);
					 }else{
						 rutasTaxonomicas=null;
					 }
					
					 
				 }else 
					 rutasTaxonomicas=null;
				 clasificacionG.setRutasTaxonomicas(rutasTaxonomicas);
				 
				 if(clasificacionG.getDescripcion().getTextos()==null && 
					clasificacionG.getProposito().getValor().equals("") && 
					clasificacionG.getPalabrasClave()==null &&
					clasificacionG.getRutasTaxonomicas()== null )
					 clasificacionG=null;
				 
				if (catalogadorAvSession.getMDSesion()==null) { //tenemos que crearnos un LomAvanzadoVO
					LomAvanzadoVO lomNew = new LomAvanzadoVO();
					AvClassificationVO[] clasificaciones=null;
					ArrayList arrClasi = new ArrayList();
					arrClasi.add(clasificacionG);
					clasificaciones = (AvClassificationVO[])arrClasi.toArray(new AvClassificationVO[arrClasi.size()]);
					lomNew.setClasificaciones(clasificaciones);
					catalogadorAvSession.setMDSesion(lomNew);
					
				} else if (catalogadorAvSession.getMDSesion().getClasificaciones()==null){ //no hay ninguna clasificacion
					if(clasificacionG !=null){
						AvClassificationVO[] clasificaciones=null;
						ArrayList arrClasi = new ArrayList();
						arrClasi.add(clasificacionG);
						clasificaciones = (AvClassificationVO[])arrClasi.toArray(new AvClassificationVO[arrClasi.size()]);
						catalogadorAvSession.getMDSesion().setClasificaciones(clasificaciones);
					}
					
				} else { //tenemos que buscar la clasificacion
					AvClassificationVO[] clasificaciones=catalogadorAvSession.getMDSesion().getClasificaciones();
					
					if (clasificaciones.length == posiTitu)//GUARDAR CUANDO HEMOS PULSADO BOTON CREAR
					{
						 ArrayList listaClasi= new ArrayList();
						 for(int i = 0; i<clasificaciones.length;i++)
							 listaClasi.add( clasificaciones[i]);
						 
						 if(clasificacionG!=null )
						 {
							 listaClasi.add( clasificacionG);
						 }
						 
						 AvClassificationVO[] clasificacionesAux = (AvClassificationVO[]) listaClasi.toArray(new AvClassificationVO[0]);
						 catalogadorAvSession.getMDSesion().setClasificaciones(clasificacionesAux);
						
					}else //boton modificar
					{
						 ArrayList listaClasi= new ArrayList();
						 for(int i = 0; i<clasificaciones.length;i++)
						 {
							 if(posiTitu==i)
							 {
								 if(clasificacionG!=null)
									 listaClasi.add(clasificacionG);
							 }else
								 listaClasi.add(clasificaciones[i]);
						 }
						 AvClassificationVO[] clasificacionesAux = (AvClassificationVO[]) listaClasi.toArray(new AvClassificationVO[0]);
						 catalogadorAvSession.getMDSesion().setClasificaciones(clasificacionesAux);
					}
					
					
//					if ((posiTitu>=0) && (posiTitu<clasificaciones.length)) {
//						clasificaciones[posiTitu]=clasificacionG;
//						catalogadorAvSession.getMDSesion().setClasificaciones(clasificaciones);
//						
//					}else if (posiTitu>= clasificaciones.length) { //si es uno nuevo
////						tenemos que crearlo al final
//						int newTam=clasificaciones.length +1;
//						AvClassificationVO[] clasiAux = new AvClassificationVO[newTam];
//						 for(int i = 0; i<clasificaciones.length;i++)
//							 clasiAux[i]=clasificaciones[i];
//						 clasiAux[newTam-1]= clasificacionG;//clasificacion a guardar
//						 catalogadorAvSession.getMDSesion().setClasificaciones(clasiAux);
//					}
				}
				
//					al final del todo inicializamos setClasificacionAux
			    	if (catalogadorAvSession!=null)
						 catalogadorAvSession.setClasificacionAux(null); //inicializado
		   		
		   		}catch (Exception e) {
		    		logger
					.error("Error en catalogadorWeb, categoria DetalleClasificacion, metodo guardarMetadatos " + e);
		    		throw new java.lang.Exception("detalle.clasificacion", e);
		    	}
		   		
			} else {
					//lanzamos errores de validacion
				if (errorTaxones) {
					throw new ValidatorException("{detalleclasi.error.taxones}");
				}
				else if ((errorFaltaIdioma && errorFaltaTexto) || (errorFuenteTexto && errorFuenteIdioma))
					throw new ValidatorException("{general.error.idioma_texto}");
				
				else 
					if ((!errorFaltaIdioma && errorFaltaTexto) || (!errorFuenteIdioma && errorFuenteTexto))
						throw new ValidatorException("{general.error.texto}");
					else 
						throw new ValidatorException("{general.error.idioma}");
			}
			if (is != null) {
    			is.close();
    		} 
    	
     }




	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//borramos lo que hay en clasificacionAux
		 CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		 if (catalogadorAvSession!=null)
			 catalogadorAvSession.setClasificacionAux(null); //inicializado
		
	}



	//Metodo que recorre un directorio dado y sus subdirectorios y nos devuelve el nombre de los ficheros
	//C:\MDA\jboss-4.0.2/uploads\xmls\--> contiene
	// Dir 1.- arbolcurricular\ ..arbol_curricular_ca, ...nivel_educativo_es.xml ..
	// Dir 2.- taxonomias\ ...Arbol_curricular_LOE_2006_ca.xml...Nivel_educativo_LOM-ESv1.0_es.xml..
	// Dir 3.- tesauros\ ...ETB-LRE_MEC-CCAA_V.1.0_en.xml, ETB-LRE_MEC-CCAA_V.1.0_es.xml Nivel_educativo_LOM-ESv1.0_ca.xml
	public void recogeRutasDir(File dirBus, String idioma, Collection arr) throws Exception 
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
		    				  String nomProp="";
		    				  if(nuevoNomFich.endsWith("_TAX")){
		    					  nomProp= this.getSrvTaxonomiaService().obtenerVocabName(lnom, idioma);
		    				  }else if(nuevoNomFich.endsWith("_TES")){
		    					  nomProp= this.getSrvTesaurosServices().obtenerVocabName(lnom, idioma);
		    				  }
		    		   		  TerminoVO term = new TerminoVO();
							  term.setIdiomaTermino("");
							  term.setIdTermino(nuevoNomFich );
							  term.setNomTermino(nomProp);
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




	public void cargarClassificationValidar(ActionMapping mapping, CargarClassificationValidarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// llenar combos
		InputStream is = null;
    	Properties prop = new Properties();
    	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
 		prop.load(is);

 		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
 		//ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			
 		//recogemos de la sesion los datos a cargar
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			 
 		String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
 		
		String[] l_id = { prop.getProperty("idiomaDestinatario"), prop.getProperty("proposito")}; 
		VocabularioVO[] vocaCombos = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
		
		if ((vocaCombos!=null) && (vocaCombos.length>0)) {
			// Rellenamos combos
			for (int ic=0;ic<vocaCombos.length; ic++) {
				if (vocaCombos[ic].getIdVocabulario().equals(prop.getProperty("proposito"))) {
					// 1.- Combo de Razon-Purpose 9.1
					TerminoVO[] terminosDest = vocaCombos[ic].getTerminos();

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
					form.setRazonBackingList(idDest, "idTermino", "nomTermino");
					
				}else if (vocaCombos[ic].getIdVocabulario().equals(prop.getProperty("idiomaDestinatario"))) {
					// 2.- Combo de idiomas sin none language 5.11 
					TerminoVO[] terminosDest = vocaCombos[ic].getTerminos();
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
					Collection idDest2 = Arrays.asList(terminosDest);
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
		Collection termsWVacio= new ArrayList();
		termsWVacio.add(termVacio); //Metemos el vacio para que nos salga en el combo ""
		Iterator zDest = idDest2.iterator();
		while (zDest.hasNext()) {
			termsWVacio.add(zDest.next());
		}
		
		//en terms tenemos un Array de TerminoVO 
			form.setSourceBackingList(termsWVacio, "idTermino", "nomTermino");
			/////////////////// FIN RECOGIDA COMBOS ///////////////////
			AvClassificationVO clVal= null;
			if (catalogadorAvSession.getLomValidacion()!=null)
				clVal=catalogadorAvSession.getLomValidacion().getClasificaciones()[0];
			
			if (clVal!=null) {
				razon=clVal.getProposito().getValor()!=null?clVal.getProposito().getValor():"";
				descripcion= clVal.getDescripcion();
				rutasTaxonomicas = clVal.getRutasTaxonomicas();
				palabrasClave = clVal.getPalabrasClave();
			}
			form.setRazon(razon);
			form.setRutaTaxonomicaAsArray(rutasTaxonomicas);
			form.setDescripcionesAsArray(descripcion.getTextos());
			form.setPalabrasClaveAsArray(palabrasClave);
			form.setTituloClasificacion(catalogadorAvSession.getTituloCategoria());
		
	}


	

	private void cambioFormulario(HttpServletRequest request, int longitudTextosDesc,int[] longitudTextosPCla,int longitudPalabrasClave,
			int longitudRutasTax,int[] longiTextosFuente,int[] longiTaxones, Object formRequestSession) 
		throws Exception{
			
			descripcion = new DescripcionVO();
			palabrasClave = new PalabraClaveVO[longitudPalabrasClave];
			rutasTaxonomicas= new RutaTaxonomicaVO[longitudRutasTax];
			
			String[] textoDescripcion = new String[longitudTextosDesc];
	      	String[] idiomaDescripcion = new String[longitudTextosDesc];
	      	ArrayList[] textoPalabrasClave = new ArrayList[longitudPalabrasClave];
	      	ArrayList[] idiomaPalabrasClave = new ArrayList[longitudPalabrasClave];
	      	ArrayList[] textoRutasTaxFuente = new ArrayList[longitudRutasTax];
	      	ArrayList textoRutasTaxTaxones = new ArrayList();
	      	Hashtable hDatos = new Hashtable();
	      	
			for (Enumeration names = request.getParameterNames(); names.hasMoreElements();) {
				String name = String.valueOf(names.nextElement());
	           
				if (name.startsWith("Des")){ //Descripciones
		      	  if(name.startsWith("DesTex")){
		            int i = Integer.parseInt(name.substring(6, name.length()));
		            textoDescripcion[i]=request.getParameter(name);
		          }	 
		      	  if(name.startsWith("DesIdio")){
		      	    int i = Integer.parseInt(name.substring(7, name.length()));
		      	    idiomaDescripcion[i]=request.getParameter(name);
		      	  }
				} else if (name.startsWith("Pcla")){//Palabras Clave
		          	 String[] namePartido = name.split("_");
		          	 int i = Integer.parseInt(namePartido[0].substring(4, namePartido[0].length()));
		          	 if (namePartido[1].startsWith("Tex")){
		          		 int j = Integer.parseInt(namePartido[1].substring(3, namePartido[1].length()));
		          		 ArrayList lPCla = textoPalabrasClave[i];
		          		 if(lPCla == null){
		          			 lPCla= new ArrayList();
		          			 for (int k=0;k<longitudTextosPCla[i];k++)
		          				 lPCla.add("");
		          		 }
		          		 
		          		 lPCla.set(j, request.getParameter(name));
		          		 textoPalabrasClave[i]=lPCla;
		          	 }
		          	 else{//Idio
		          		 int j = Integer.parseInt(namePartido[1].substring(4, namePartido[1].length()));
		          		 ArrayList lPCla = idiomaPalabrasClave[i];
		          		 if(lPCla == null){
		          			 lPCla= new ArrayList();
		          			 for (int k=0;k<longitudTextosPCla[i];k++)
		          				 lPCla.add("");
		          		 }
		          		 
		          		 lPCla.set(j, request.getParameter(name));
		          		 idiomaPalabrasClave[i]=lPCla;
		          	 }
	           } else if (name.startsWith("rutaTax")) { 
//	        	rutaTax${i }_source, rutaTax${i}_taxon${t}_Id${u }//rutaTax${i}_taxon${t}_EntryTex${u} //rutaTax${i}_taxon${t}_EntryIdio${u}
	        	  hDatos.put(name, request.getParameter(name));
	           }else if (name.startsWith("razon")){
	        	   razon=request.getParameter(name);
	           } 
	       }
			
		   if (hDatos.size()>0) {
			   ArrayList arrRutaTax = new ArrayList();
			   for (int i=0; i< longitudRutasTax; i++){
				   RutaTaxonomicaVO rutavo = new RutaTaxonomicaVO();
				   //rellenams fuentes
//				   String source= hDatos.get("rutaTax" + i + "_source").toString();
				   String source= hDatos.get("rutaTax" + i + "_source")!=null?hDatos.get("rutaTax" + i + "_source").toString():"";
//				   String idio= hDatos.get("rutaTax" + i + "_idio").toString();
				   String idio= hDatos.get("rutaTax" + i + "_idio")!=null?hDatos.get("rutaTax" + i + "_idio").toString():"";
				   LangStringVO textFuente= new LangStringVO();
				   textFuente.setTexto(source);
				   textFuente.setIdioma(idio);
				   FuenteVO fuente = new FuenteVO();
				   LangStringVO[] textosFuentes= new LangStringVO[1];
				   textosFuentes[0]=textFuente;
				   fuente.setTextos(textosFuentes);//metidas las fuentes de una RutaTaxonomica
				   
				   //rutasTaxonomicas[i].setFuente(fuente);
				   //ahora metemos los taxones para esa fuente
				   ArrayList taxones = new ArrayList();
				   for (int j=0; j< longiTaxones[i]; j++){
					   ArrayList taxonij= new ArrayList();
					   TaxonVO tax = new TaxonVO();
					   EntryVO entry = new EntryVO();
					   ArrayList lans = new ArrayList();
					   
					   String textoId="";
					   if (hDatos.get("rutaTax" + i + "_taxon" + j + "_Id" + 0)!=null )
						   textoId=hDatos.get("rutaTax" + i + "_taxon" + j + "_Id" + 0).toString();
					   
					   IdVO id = new IdVO();
					   id.setTexto(textoId);
					   for (int u=0; u<hDatos.size(); u++) {
						   LangStringVO lanvo = new LangStringVO();
						   if (hDatos.containsKey("rutaTax" + i + "_taxon" + j + "_EntryTex" + u)) {
							   String textoTax = "";
							   if (hDatos.get("rutaTax" + i + "_taxon" + j + "_EntryTex" + u)!=null)
								   textoTax= hDatos.get("rutaTax" + i + "_taxon" + j + "_EntryTex" + u).toString();
							   lanvo.setTexto(textoTax);
							   String idioTax = "";
							   if (hDatos.get("rutaTax" + i + "_taxon" + j + "_EntryIdio" + u)!=null)
								   idioTax=hDatos.get("rutaTax" + i + "_taxon" + j + "_EntryIdio" + u).toString();
							   lanvo.setIdioma(idioTax);
							   lans.add(lanvo); //array d langs para entryvo
							}
					   }
					   //*****************
					   if(lans.size()==0){
						   LangStringVO lanvo = new LangStringVO();
						   lanvo.setIdioma("");
						   lanvo.setTexto("");
						   lans.add(lanvo);
					   }
					   //*****************
					   LangStringVO[] textosEnt= (LangStringVO[])lans.toArray(new LangStringVO[lans.size()]);
					   entry.setTextos(textosEnt);
					   
					   tax.setId(id);
					   tax.setEntry(entry); //un Taxon
					   taxones.add(tax);
				   }
				   TaxonVO[] rutaTaxones = (TaxonVO[])taxones.toArray(new TaxonVO[taxones.size()]);
				   rutavo.setFuente(fuente);
				   rutavo.setTaxones(rutaTaxones);//tenemos una RutaTaxonomica
				   arrRutaTax.add(rutavo);
			   }
			   rutasTaxonomicas= (RutaTaxonomicaVO[]) arrRutaTax.toArray(new RutaTaxonomicaVO[arrRutaTax.size()]);
			   RutaTaxonomicaVO[] rutasTaxonomicas2=rutaLimpia(rutasTaxonomicas);
			   rutasTaxonomicas=new RutaTaxonomicaVO[rutasTaxonomicas2.length];
			   rutasTaxonomicas=rutasTaxonomicas2;
		   }
			
		   //descripcion
		   DescripcionVO descVO = new DescripcionVO();
		   LangStringVO[] aLangDescripciones = new LangStringVO[textoDescripcion.length];
		   for (int i = 0; i<textoDescripcion.length;i++){
			  LangStringVO langDescripciones= new LangStringVO();
			  langDescripciones.setTexto(textoDescripcion[i]);
			  langDescripciones.setIdioma(idiomaDescripcion[i]);
			  aLangDescripciones[i] = langDescripciones;
		   }
		   descVO.setTextos(aLangDescripciones);
		   descripcion=descVO;	
	  	
	  	   //palabras clave
	       for (int i=0;i<textoPalabrasClave.length;i++){
	            PalabraClaveVO pClaVO = new PalabraClaveVO();
	            if (textoPalabrasClave[i]!=null) {
		  	        LangStringVO[] aLangPCla = new LangStringVO[textoPalabrasClave[i].size()];
		  	        for (int j = 0; j<textoPalabrasClave[i].size();j++){
		  	        	 LangStringVO langPCla= new LangStringVO();
		  	        	 langPCla.setTexto(textoPalabrasClave[i].get(j).toString());
		  	        	 langPCla.setIdioma(idiomaPalabrasClave[i].get(j).toString());
		  	        	 aLangPCla[j] = langPCla;
		  	        }
		  	        pClaVO.setTextos(aLangPCla);
	            }
	            else{
	        	   LangStringVO[] aLangString=new LangStringVO[1];
	        	   LangStringVO langString = new LangStringVO();
	        	   langString.setIdioma("");
	        	   langString.setTexto("");
	        	   aLangString[0]= langString;
	        	   pClaVO.setTextos(aLangString);
	            }
	  	        palabrasClave[i]=pClaVO;     
	       }
	      

	    }//fin cambioformulatrio
	
	private void dameTerminoId(String idiomaTrad) throws Exception{
		
		InputStream is = null;
    	Properties prop = new Properties();
    	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
		prop.load(is);
		
	   //Razon	
	   if (razon!=null) {
		   String[] idRazon= new String [1];
		   idRazon[0]=razon;
		   TerminoVO[] termRazon = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(idRazon, idiomaTrad);
		   if ((termRazon!=null) && (termRazon.length>0)){
			   razon=termRazon[0].getNomTermino();
		   }
	    }
		//para Descripcion
		if ((descripcion!=null) && (descripcion.getTextos()!=null) && (descripcion.getTextos().length>0)) {
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
		
		//Palabras Clave
		ArrayList idsPCla = new ArrayList();
	    if ((palabrasClave!=null) && (palabrasClave.length>0)) {
		  for ( int i=0;i<palabrasClave.length;i++ ){
			LangStringVO[] langPalabrasClave = palabrasClave[i].getTextos();
			for ( int j=0;j<langPalabrasClave.length;j++){
				idsPCla.add(langPalabrasClave[j].getIdioma());
		    	
		        String[] arrayIdsPCla = (String[])idsPCla.toArray(new String[idsPCla.size()]);
		        TerminoVO[] terminosTraducPCla = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(arrayIdsPCla, idiomaTrad);
		        
		        int jPCla= 0;
		        for (int cont=0;cont<terminosTraducPCla.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
		        	
		    		boolean enc=false; 		
		    		while(!enc && jPCla<langPalabrasClave.length){
		    			if (langPalabrasClave[jPCla].getIdioma().equals("")){
		    				jPCla++; 
		    			}
		    			else{
		    				enc = true;
		    				langPalabrasClave[jPCla].setIdioma(terminosTraducPCla[cont].getNomTermino());
		    				jPCla++;
		    			}
		    		}	
		        }
		        }
		        palabrasClave[i].setTextos(langPalabrasClave);
		    }
	    }
		  // Rutas Taxonomicas
		  Collection terms= new ArrayList();
		  String idiomaRutas=LdapUserDetailsUtils.getIdioma();
		  if (idiomaRutas==null || idiomaRutas.equals("")){
			  idiomaRutas=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
  		}
		  String[] rutaBus = prop.getProperty("rutaSource").split(",");
		  for (int i=0; i< rutaBus.length;i++) {
				File dirBus = new File(rutaBus[i]);
				recogeRutasDir(dirBus, idiomaRutas, terms);
		  }
		  if ((rutasTaxonomicas!=null) && (rutasTaxonomicas.length>0)) {
			    for (int r=0; r<rutasTaxonomicas.length; r++) {
			    	//Fuentes
					LangStringVO langstring= rutasTaxonomicas[r].getFuente().getTextos()[0];
					if (langstring.getTexto()!=null){
						String[] idSource = {langstring.getTexto()};
						String traducido=devuelveSinFinal(idSource[0], terms);
						
						if ((traducido!=null) && (!traducido.equals("")) ) {
						  langstring.setTexto(traducido);
						} else {
							if (!langstring.getTexto().equals("")){ 
                                if(langstring.getTexto().endsWith("_TES") || langstring.getTexto().endsWith("_TAX"))                                                                                                
                                             langstring.setTexto(langstring.getTexto().substring(0, langstring.getTexto().length()-4));
                    }
                     else
                                 langstring.setTexto("");
						}
					}

					if (langstring.getIdioma()!=null && !langstring.getIdioma().equals("")){
//						comprobamos que si es la ultima ruta taxonomica tenga taxones asociados si no es asi
//						quiere decir que tenemos los combos y no guardamos esos valores pues no hay taxones
						if(r!=rutasTaxonomicas.length-1 || (r== rutasTaxonomicas.length-1 && tieneTaxonNoVacio())){
							String[] datoIdiomaRuta= {langstring.getIdioma()};						
							if(datoIdiomaRuta !=null && datoIdiomaRuta.length >0 && datoIdiomaRuta[0] !=null && !datoIdiomaRuta[0].equals("")){
								String terminosTraducPCla= I18n.getInstance().obtenerIdiomaIso(datoIdiomaRuta[0], idiomaRutas);//dameIdiomaProp(datoIdiomaRuta[0]);						
								
								if(terminosTraducPCla==null || terminosTraducPCla.equals("")){// Cuando viene con identificador no da ningun valor dameIdiomaProp
								TerminoVO[] terminosTraducPCla2 = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(datoIdiomaRuta, idiomaTrad);
									if ((terminosTraducPCla!=null) && terminosTraducPCla.length()>0) {
										langstring.setIdioma(terminosTraducPCla2[0].getNomTermino());
									}
								}else{//
									langstring.setIdioma(terminosTraducPCla);
								}
							}
						}
					}
					//fin fuentes
					//Taxones (traduccion de los idiomas a sus textos correspondientes)
					if ((rutasTaxonomicas[r].getTaxones()!=null) && (rutasTaxonomicas[r].getTaxones().length>0)) {
						TaxonVO[] taxonesAtrad= rutasTaxonomicas[r].getTaxones();
						for (int ir=0; ir<taxonesAtrad.length;ir++) {
							if ((taxonesAtrad[ir].getEntry()!=null) && (taxonesAtrad[ir].getEntry().getTextos()!=null) && 
							    (taxonesAtrad[ir].getEntry().getTextos().length>0)) {
								LangStringVO[] textosTax=taxonesAtrad[ir].getEntry().getTextos();
								for (int et=0;et<textosTax.length;et++) {
									if ((textosTax[et].getIdioma()!=null) && (!textosTax[et].getIdioma().equals(""))) {
										//tenemos castellano... buscamos el q le corresponde
										String idiomaOk=I18n.getInstance().obtenerIdiomaIso(textosTax[et].getIdioma(), idiomaRutas);//dameIdiomaProp(textosTax[et].getIdioma());
										if((idiomaOk==null || idiomaOk.equals(""))&& (textosTax[et].getIdioma()!=null && !textosTax[et].getIdioma().equals(""))){
											idiomaOk=textosTax[et].getIdioma();
										}
										textosTax[et].setIdioma(idiomaOk);
//										String[] termsTraducIdio= {textosTax[et].getIdioma()}; //ese elemento contiene castellano
//										TerminoVO[] idiomaTraducTax = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(termsTraducIdio, idiomaTrad);
//										if ((idiomaTraducTax!=null) && (idiomaTraducTax.length>0)) {
//											textosTax[et].setIdioma(idiomaTraducTax[0].getNomTermino()); //lo modificamos sobre el mismo
//										}
									}
								}
									
							}
						}
							
					}//end if taxones
				}//end for taxones
					 
		
		  }
		  /////////////////////////////
		
	}//fin damdIds
	
	//metodo provisional hasta q se quite de properties
//	private String dameIdiomaProp(String idiomaTrad) throws Exception{
//		String idiomaSalida="";
//		InputStream is = null;
//	Properties prop = new Properties();
//    	String idiomaLdap=LdapUserDetailsUtils.getIdioma();
//    	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
//		prop.load(is);
//		
//		String idiomas = prop.getProperty("idiomas.properties"); //es, en, eu...
//		StringTokenizer token = new StringTokenizer(idiomas, ",");
//		boolean encontrado=false;
//		while (token.hasMoreElements()&&(!encontrado)) {
//			String idiomaLeido=token.nextElement().toString();//es, en..
//			try{
//				if ((I18n.getInstance().obtenerIdiomaTraducido(idiomaLeido, idiomaLdap)!=null) && 
//						     (I18n.getInstance().obtenerIdiomaTraducido(idiomaLeido, idiomaLdap).equals(idiomaTrad))){
//					idiomaSalida=idiomaLeido;
//					encontrado=true;
//				}
//			}catch(Exception e){
//				idiomaSalida="";
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
	    	
	    	if (valor instanceof DetalleClasificacionFormImpl) {
	    		DetalleClasificacionFormImpl formulario= (DetalleClasificacionFormImpl) valor;
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setTituloClasificacion(formulario.getTituloClasificacion());
				form.setRazonValueList(formulario.getRazonValueList());
				form.setRazonLabelList(formulario.getRazonLabelList());
				form.setSourceValueList(formulario.getSourceValueList());
				form.setSourceLabelList(formulario.getSourceLabelList());
			} 
	    	else if (valor instanceof DetalleClasificacionSubmitFormImpl) {
	    		DetalleClasificacionSubmitFormImpl formulario= (DetalleClasificacionSubmitFormImpl) valor;
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setTituloClasificacion(formulario.getTituloClasificacion());
				form.setRazonValueList(formulario.getRazonValueList());
				form.setRazonLabelList(formulario.getRazonLabelList());
				form.setSourceValueList(formulario.getSourceValueList());
				form.setSourceLabelList(formulario.getSourceLabelList());
			}else if (valor instanceof ClasificacionNoValidaVolverFormImpl) {
				ClasificacionNoValidaVolverFormImpl formulario= (ClasificacionNoValidaVolverFormImpl) valor;
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setTituloClasificacion(formulario.getTituloClasificacion());
				form.setRazonValueList(formulario.getRazonValueList());
				form.setRazonLabelList(formulario.getRazonLabelList());
				form.setSourceValueList(formulario.getSourceValueList());
				form.setSourceLabelList(formulario.getSourceLabelList());
			}else if (valor instanceof ClasificacionValidaVolverFormImpl) {
				ClasificacionValidaVolverFormImpl formulario= (ClasificacionValidaVolverFormImpl) valor;
				form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
				form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
				form.setTituloClasificacion(formulario.getTituloClasificacion());
				form.setRazonValueList(formulario.getRazonValueList());
				form.setRazonLabelList(formulario.getRazonLabelList());
				form.setSourceValueList(formulario.getSourceValueList());
				form.setSourceLabelList(formulario.getSourceLabelList());
			}
	    	
			 form.setRazon("");
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
			 
		} catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("detalle.clasificacion", ad);
		} catch (Exception e) {
    		logger
			.error("Error en catalogadorWeb, categoria DetalleClasificacion, metodo reset" + e);
    		throw new java.lang.Exception("detalle.clasificacion", e);
    		
       }

	}


	private boolean tieneTaxonNoVacio(){
		boolean resultado = false;
		if((rutasTaxonomicas!=null) && (rutasTaxonomicas.length>0) 
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()!=null)
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones().length > 0)
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getId()!=null)
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getId().getTexto()!=null)
				&& (!rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getId().getTexto().equals(""))
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getEntry()!=null)
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getEntry().getTextos()!=null)
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getEntry().getTextos().length>0)
				&& (rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getEntry().getTextos()[0].getTexto()!=null)
				&& (!rutasTaxonomicas[rutasTaxonomicas.length-1].getTaxones()[0].getEntry().getTextos()[0].getTexto().equals(""))
				)
		{
			resultado = true;
		}
		return resultado;
	}


	public boolean hayClasificaciones(
			ActionMapping mapping, 
			HayClasificacionesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvClassificationVO[] clasificaciones =catalogadorAvSession.getMDSesion().getClasificaciones();
	    		if (clasificaciones == null || clasificaciones.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	   
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayClasificaciones "+ e);
			throw new java.lang.Exception("clasificacion", e);
		}
		return result;
	}
	
	
	public boolean hayClasificacionesGuardar(
			ActionMapping mapping,
			HayClasificacionesGuardarForm form, 
			HttpServletRequest request,
			HttpServletResponse response) 
	throws Exception 
	{
		boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvClassificationVO[] clasificaciones =catalogadorAvSession.getMDSesion().getClasificaciones();
	    		if (clasificaciones == null || clasificaciones.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayClasificacionesGuardar "+ e);
			throw new java.lang.Exception("clasificacion", e);
		}
		return result;
	}
}