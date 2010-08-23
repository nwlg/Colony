/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica;

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

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.catalogacion.negocio.servicios.AgregadorORVO;
import es.pode.catalogacion.negocio.servicios.AvTechnicalVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.DuracionVO;
import es.pode.catalogacion.negocio.servicios.FormatoVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LocalizacionVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.OtrosRequisitosVO;
import es.pode.catalogacion.negocio.servicios.PautasInstalacionVO;
import es.pode.catalogacion.negocio.servicios.RequisitoVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.TamanioVO;
import es.pode.catalogacion.negocio.servicios.VersionMaxVO;
import es.pode.catalogacion.negocio.servicios.VersionMinVO;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController
 */
public class TecnicaControllerImpl extends TecnicaController
{ 
	
	protected static Logger logger = Logger.getLogger(TecnicaControllerImpl.class); 

	private FormatoVO[] formatos;
  	private String tamaño;
  	private LocalizacionVO[] localizaciones;
  	private RequisitoVO[] requisitos;
  	private AgregadorORVO[] agregadores;
  	private PautasInstalacionVO[] notasDeInstalacion;
  	private OtrosRequisitosVO[] masRequisitos;
  	private DescripcionVO[] duracionDesc;
  	private String tipo;
  	private String nombre;
  	
  	
  	
  	private String anyos;
  	private String meses;
  	private String dias;
  	private String horas;
  	private String minutos;
  	private String segundosP1;
  	private String segundosP2;
  	private DuracionVO duracion;

	/**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#cargarDatosTecnica(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CargarDatosTecnicaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDatosTecnica(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CargarDatosTecnicaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			logger.debug("Cargados los combos");

				
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
							SourceValueVO nombre=new SourceValueVO();
							nombre.setValor("");
							nombre.setSource("LOM-ESv1.0");
							SourceValueVO tipo=new SourceValueVO();
							tipo.setValor("");
							tipo.setSource("LOM-ESv1.0");
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
					nombre.setSource("LOM-ESv1.0");
					SourceValueVO tipo=new SourceValueVO();
					tipo.setValor("");
					tipo.setSource("LOM-ESv1.0");
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
					
					duracion = catalogadorAvSession.getMDSesion().getTechnical().getDuracion();
					if (duracion!=null && duracion.getDuracion()!=null)
						descifrarDuration();
				}
				form.setAnyo(anyos);
				form.setMes(meses);
				form.setDia(dias);
				form.setHora(horas);
				form.setMinutos(minutos);
				form.setSegundosP1(segundosP1);
				form.setSegundosP2(segundosP2);
				
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
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tecnica", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Tecnica, metodo cargarDatosTecnica " + e);
			throw new java.lang.Exception("tecnica", e);
		
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#accionSubmit(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AccionSubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String accionSubmit(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AccionSubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			if (accionPartes.length == 3)
				request.setAttribute("posicionExterior", accionPartes[2]);
		}
        String resAction = "";
       
        //String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
        
//        if (datosResources.getString("tecnica.AñadirFormato").equals(accion)) {
//              resAction = "Añadir Formato";
//        } else if (datosResources.getString("tecnica.EliminarFormato").equals(accion)) {
//        	  resAction = "Eliminar Formato";
//        } else if (datosResources.getString("tecnica.AñadirLocalizacion").equals(accion)) {
//     	   resAction = "Añadir Localizacion";
//        } else if (datosResources.getString("tecnica.EliminarLocalizacion").equals(accion)) {
//       	   resAction = "Eliminar Localizacion";
//        } else if (datosResources.getString("tecnica.AñadirRequerimiento").equals(accion)) {
//       	   resAction = "Añadir Requerimiento";
//        } else if (datosResources.getString("tecnica.EliminarRequerimiento").equals(accion)) {
//       	   resAction = "Eliminar Requerimiento";
//       	} else if (datosResources.getString("tecnica.AñadirAgregador").equals(accion)) {
//       	   resAction = "Añadir AgregadorOR";
//        } else if (datosResources.getString("tecnica.EliminarAgregador").equals(accion)) {
//       	   resAction = "Eliminar AgregadorOR";
//        } else if (datosResources.getString("tecnica.AñadirInstalacion").equals(accion)) {
//           resAction = "Añadir Instalacion";
//        } else if (datosResources.getString("tecnica.EliminarInstalacion").equals(accion)) {
//           resAction = "Eliminar Instalacion";
//        } else if (datosResources.getString("tecnica.AñadirMasRequerimientos").equals(accion)) {
//        	   resAction = "Añadir MasRequerimientos";
//        }else if (datosResources.getString("tecnica.EliminarMasRequerimientos").equals(accion)) {
//        	   resAction = "Eliminar MasRequerimientos";
//        }else if (datosResources.getString("tecnica.AñadirDescDuracion").equals(accion)) {
//        	   resAction = "Añadir DescDuracion";
//        }else if (datosResources.getString("tecnica.EliminarDescDuracion").equals(accion)) {
//        	   resAction = "Eliminar DescDuracion";
//        }else 
		if (datosResources.getString("tecnica.Validar").equals(accion)) {
       	   resAction = "Validar";
        } else if (datosResources.getString("tecnica.Aceptar").equals(accion)) {
       	   resAction = "Aceptar";
        } else if (datosResources.getString("tecnica.Cancelar").equals(accion)) {
        	   resAction = "Cancelar";
        } else if (datosResources.getString("tecnica.Reset").equals(accion)) {
      	   resAction = "Reset";
         }
        else
        	resAction= accion;
		
        return resAction;
    }




    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#anadirFormato(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirFormatoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirFormato(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirFormatoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);

        	
               
               Object[] aFormatos=form.getFormatosAsArray();
               int nuevoTamano = aFormatos.length +1;
               Object[] newAFormatos = new Object[nuevoTamano];
        	   FormatoVO formatoVO=new FormatoVO();
        	   formatoVO.setTexto("");
        	   
        	   for(int i = 0; i<aFormatos.length;i++)
        		   newAFormatos[i]=aFormatos[i];
        	   newAFormatos[nuevoTamano-1]= formatoVO;
        	   
        	   form.setFormatosAsArray(newAFormatos);
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirFormato " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirFormato " + e);
			throw new Exception("tecnica",e);
		}        	

     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarFormato(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarFormatoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarFormato(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarFormatoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
               
//         posicion del formato que se quiere eliminar   
           String posicion = request.getAttribute("posicion").toString();
           int posicionInt = Integer.parseInt(posicion);
       	
           FormatoVO[] aFormatos=(FormatoVO[]) form.getFormatosAsArray();
           FormatoVO[] nuevoFormatos = new FormatoVO[aFormatos.length -1];
 	     	//añado al nuevo array de formatos todos los identificadores menos el que 
 	     	//queremos eliminar
 	     	for (int i = 0; i<nuevoFormatos.length;i++){
 	     		if (i < posicionInt)
 	     			nuevoFormatos[i] = aFormatos[i];
 	     		else
 	     			nuevoFormatos[i] = aFormatos[i+1]; 
 	     	}
       	   
 	     	form.setFormatosAsArray(nuevoFormatos);
    		   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarFormato " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo eliminarFormato " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#anadirLocalizacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirLocalizacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirLocalizacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirLocalizacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
           Object[] aLocalizadores=form.getLocalizacionAsArray();
           int nuevoTamano = aLocalizadores.length +1;
           Object[] newALocalizadores = new Object[nuevoTamano];
    	   LocalizacionVO localizacionVO=new LocalizacionVO();
    	   localizacionVO.setTexto("");

    	   for(int i = 0; i<aLocalizadores.length;i++)
    		   newALocalizadores[i]=aLocalizadores[i];
    	   newALocalizadores[nuevoTamano-1]= localizacionVO;
    	   
    	   form.setLocalizacionAsArray(newALocalizadores);
    		
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirLocalizacion " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirLocalizacion " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarLocalizacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarLocalizacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarLocalizacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarLocalizacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
           
//         posicion de localizacion que se quiere eliminar   
          	String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
	       	LocalizacionVO[] aLocalizacion=(LocalizacionVO[]) form.getLocalizacionAsArray();
	       	LocalizacionVO[] nuevoLocalizacion=new LocalizacionVO[aLocalizacion.length-1];

 	     	//añado al nuevo array de localizaciones todos las localizaciones menos el que 
 	     	//queremos eliminar
 	     	for (int i = 0; i<nuevoLocalizacion.length;i++){
 	     		if (i < posicionInt)
 	     			nuevoLocalizacion[i] = aLocalizacion[i];
 	     		else
 	     			nuevoLocalizacion[i] = aLocalizacion[i+1]; 
 	     	}

 	     	form.setLocalizacionAsArray(nuevoLocalizacion);
    		
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarLocalizacion " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo elimianrLocalizacion " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#anadirRequerimiento(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirRequerimientoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirRequerimiento(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirRequerimientoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
			
			String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           
           Object[] aRequisitos=form.getRequerimientoAsArray();
           int nuevoTamano = aRequisitos.length +1;
           Object[] newARequisitos = new Object[nuevoTamano];
           RequisitoVO requisitoVO=new RequisitoVO();
           AgregadorORVO[] lAgregador=new AgregadorORVO[1];
           AgregadorORVO nuevoAgregador=new AgregadorORVO();
	    	SourceValueVO type=new SourceValueVO();
	    	type.setValor("");
	    	type.setSource(source);
	    	SourceValueVO name=new SourceValueVO();
	    	name.setValor("");
	    	name.setSource(source);
	    	nuevoAgregador.setTipo(type);
	    	nuevoAgregador.setNombre(name);
	    	VersionMinVO min=new VersionMinVO();
	    	min.setTexto("");
	    	VersionMaxVO max=new VersionMaxVO();
	    	max.setTexto("");
	    	nuevoAgregador.setVersionMax(max);
	    	nuevoAgregador.setVersionMin(min);
	    	lAgregador[0]=nuevoAgregador;
           requisitoVO.setAgregadoresOR(lAgregador);
    	   

    	   for(int i = 0; i<aRequisitos.length;i++)
    		   newARequisitos[i]=aRequisitos[i];
    	   newARequisitos[nuevoTamano-1]= requisitoVO;
    	   
    	   form.setRequerimientoAsArray(newARequisitos);
  
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirRequerimiento " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirRequerimiento " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarRequerimiento(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarRequerimientoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarRequerimiento(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarRequerimientoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           

//         posicion de requerimiento que se quiere eliminar   
          	String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
	       	RequisitoVO[] aRequisito=(RequisitoVO[]) form.getRequerimientoAsArray();
	       	RequisitoVO[] nuevoRequisito=new RequisitoVO[aRequisito.length-1];

 	     	//añado al nuevo array de requisitos todos los requisitos menos el que 
 	     	//queremos eliminar
 	     	for (int i = 0; i<nuevoRequisito.length;i++){
 	     		if (i < posicionInt)
 	     			nuevoRequisito[i] = aRequisito[i];
 	     		else
 	     			nuevoRequisito[i] = aRequisito[i+1]; 
 	     	}

 	     	form.setRequerimientoAsArray(nuevoRequisito);
  
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarRequerimiento " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo eliminarRequerimiento " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#anadirAgregador(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirAgregadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirAgregador(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirAgregadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
			
			String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           String posicion = request.getAttribute("posicion").toString();
           int posicionInt = Integer.parseInt(posicion);
	    	//se recogen todos los requisitos
	    	RequisitoVO[] reqArray = (RequisitoVO[]) form.getRequerimientoAsArray();
	    	//Recojo el agreagdor indicado y añado otro nuevo
	    	
	    	AgregadorORVO[] agregadores = reqArray[posicionInt].getAgregadoresOR();
	    	AgregadorORVO[] nuevoAgregadores = new AgregadorORVO[agregadores.length+1];
	    	for(int i = 0 ; i < agregadores.length;i++){
	    		nuevoAgregadores[i]= agregadores[i];
	    	}
	    	AgregadorORVO nuevoAgregador=new AgregadorORVO();
	    	SourceValueVO type=new SourceValueVO();
	    	type.setValor("");
	    	type.setSource(source);
	    	SourceValueVO name=new SourceValueVO();
	    	name.setValor("");
	    	name.setSource(source);
	    	nuevoAgregador.setTipo(type);
	    	nuevoAgregador.setNombre(name);
	    	VersionMinVO min=new VersionMinVO();
	    	min.setTexto("");
	    	VersionMaxVO max=new VersionMaxVO();
	    	max.setTexto("");
	    	nuevoAgregador.setVersionMax(max);
	    	nuevoAgregador.setVersionMin(min);
	    	
	    	nuevoAgregadores[nuevoAgregadores.length-1] = nuevoAgregador;
	    	reqArray[posicionInt].setAgregadoresOR(nuevoAgregadores);
	    	form.setRequerimientoAsArray(reqArray);
        	
    		
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirAgregador " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirAgregador " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarAgregador(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarAgregadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarAgregador(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarAgregadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           //posicion de contenido a eliminar   
           String posicion = request.getAttribute("posicion").toString();
           int posicionInt = Integer.parseInt(posicion);//Requerimiento
   		
   			//posicion del  requerimiento de la que se quiere eliminar parte de su contenido
           String posicionExt = request.getAttribute("posicionExterior").toString();
           int posicionExtInt = Integer.parseInt(posicionExt);//Agregador
	    	
	    	RequisitoVO[] aRequisitos = (RequisitoVO[]) form.getRequerimientoAsArray();
	    	AgregadorORVO[] agregador = requisitos[posicionInt].getAgregadoresOR();
	    	AgregadorORVO[] nuevoAgregador = new AgregadorORVO[agregador.length -1];
	    	//añado al nuevo array de agregadores todos los agregadores menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoAgregador.length;i++){
	    		if (i < posicionExtInt)
	    			nuevoAgregador[i] = agregador[i];
	    		else
	    			nuevoAgregador[i] = agregador[i+1]; 
	    	}
	    	aRequisitos[posicionInt].setAgregadoresOR(nuevoAgregador);
	    	form.setRequerimientoAsArray(aRequisitos);
        	
    		
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarAgregador " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo eliminarAgregador " + e);
			throw new Exception("tecnica",e);
		}     
     }


    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarInstalacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarInstalacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarInstalacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarInstalacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           //posicion de la pauta que se quiere eliminar   
          	String posicion = request.getAttribute("posicion").toString();
             int posicionInt = Integer.parseInt(posicion);
	       	PautasInstalacionVO[] aPautas=(PautasInstalacionVO[]) form.getDescripcionInstalacionAsArray();
	       	LangStringVO[] langString = aPautas[0].getTextos();
	       	LangStringVO[] nuevolangString = new LangStringVO[langString.length -1];
 	     	//añado al nuevo array de pautas todos las pautas menos el que 
 	     	//queremos eliminar
 	     	for (int i = 0; i<nuevolangString.length;i++){
 	     		if (i < posicionInt)
 	     			nuevolangString[i] = langString[i];
 	     		else
 	     			nuevolangString[i] = langString[i+1]; 
 	     	}
 	     	PautasInstalacionVO pautaVO = new PautasInstalacionVO();
 	     	pautaVO.setTextos(nuevolangString);
 	     	aPautas[0]= pautaVO;
 	     	form.setDescripcionInstalacionAsArray(aPautas);
        	
    		
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarInstalacion " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo eliminarInstalacion " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#anadirMasRequerimientos(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirMasRequerimientosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirMasRequerimientos(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirMasRequerimientosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           Object[] aMasReq=form.getDescripcionRequerimientosAsArray();
			OtrosRequisitosVO masVO = (OtrosRequisitosVO)aMasReq[0];
			LangStringVO[] textos = masVO.getTextos();
			int nuevoTamano = textos.length +1;
			LangStringVO[] newTextos = new LangStringVO[nuevoTamano];
			for(int i=0;i<textos.length;i++)
				newTextos[i]=textos[i];
			LangStringVO langMas=new LangStringVO();
			langMas.setIdioma("");
			langMas.setTexto("");
			newTextos[nuevoTamano-1]=langMas;
			
			masVO.setTextos(newTextos);
			aMasReq[0]=masVO;
			form.setDescripcionRequerimientosAsArray(aMasReq);
         	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirMasRequerimientos " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirMasRequerimientos " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarMasRequerimientos(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarMasRequerimientosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarMasRequerimientos(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarMasRequerimientosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           //posicion del reque que se quiere eliminar   
          	String posicion = request.getAttribute("posicion").toString();
             int posicionInt = Integer.parseInt(posicion);
	       	OtrosRequisitosVO[] aOtros=(OtrosRequisitosVO[]) form.getDescripcionRequerimientosAsArray();
	       	LangStringVO[] langString = aOtros[0].getTextos();
	       	LangStringVO[] nuevolangString = new LangStringVO[langString.length -1];
 	     	//añado al nuevo array de requerimientos todos los requerimientos menos el que 
 	     	//queremos eliminar
 	     	for (int i = 0; i<nuevolangString.length;i++){
 	     		if (i < posicionInt)
 	     			nuevolangString[i] = langString[i];
 	     		else
 	     			nuevolangString[i] = langString[i+1]; 
 	     	}
 	     	OtrosRequisitosVO otroVO = new OtrosRequisitosVO();
 	     	otroVO.setTextos(nuevolangString);
 	     	aOtros[0]= otroVO;
 	     	form.setDescripcionRequerimientosAsArray(aOtros);
        	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarMasRequerimientos " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo eliminarMasRequerimientos " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#anadirDescDuracion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirDescDuracionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirDescDuracion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirDescDuracionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
    	if (valor instanceof TecnicaFormImpl) {
    		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
          	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
          	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
			form.setMes(((TecnicaFormImpl)valor).getMes());
			form.setDia(((TecnicaFormImpl)valor).getDia());
			form.setHora(((TecnicaFormImpl)valor).getHora());
			form.setMinutos(((TecnicaFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

          	
          	
		}
    	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
    		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
    		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
          	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
          	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
			form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
			form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
			form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
			form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
      	}
    	else if(valor instanceof TecnicaValidaVolverFormImpl){
    		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
    		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
          	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
          	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
			form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
			form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
			form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
			form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
    	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
    		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
    		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
          	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
          	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
			form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
			form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
			form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
			form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
    	}
    	int longitudFormatos=form.getFormatos().size();
    	int longitudLocalizacion=form.getLocalizacion().size();
    	int longitudRequisitos=form.getRequerimiento().size();
    	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
    	for(int i= 0;i< form.getRequerimiento().size();i++){
    		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
		}
    	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
    	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
    	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
	  	
	  	
	  	
	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

       //formatos
       form.setFormatosAsArray(formatos); 
       //Tamaño
       form.setTamanio(tamaño);
       //localizacion
       form.setLocalizacionAsArray(localizaciones);
       //requeriminetos
       form.setRequerimientoAsArray(requisitos); 	
       //notas de instalacion
       form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
       //mas requerimientos
       form.setDescripcionRequerimientosAsArray(masRequisitos);
       form.setDescripcionDuracionAsArray(duracionDesc);
       form.setAnyo(anyos);
		form.setMes(meses);
		form.setDia(dias);
		form.setHora(horas);
		form.setMinutos(minutos);
		form.setSegundosP1(segundosP1);
		form.setSegundosP2(segundosP2);
		
		
		Object[] aDuDesc=form.getDescripcionDuracionAsArray();
		DescripcionVO taDescVO = (DescripcionVO)aDuDesc[0];
		LangStringVO[] textos = taDescVO.getTextos();
		int nuevoTamano = textos.length +1;
		LangStringVO[] newTextos = new LangStringVO[nuevoTamano];
		for(int i=0;i<textos.length;i++)
			newTextos[i]=textos[i];
		LangStringVO langDuDesc=new LangStringVO();
		langDuDesc.setIdioma("");
		langDuDesc.setTexto("");
		newTextos[nuevoTamano-1]=langDuDesc;
		
		taDescVO.setTextos(newTextos);
		aDuDesc[0]=taDescVO;
		form.setDescripcionDuracionAsArray(aDuDesc);
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirDescDuracion " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirDescDuracion " + e);
			throw new Exception("tecnica",e);
		}     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#eliminarDescDuracion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarDescDuracionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarDescDuracion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarDescDuracionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
    	if (valor instanceof TecnicaFormImpl) {
    		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
          	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
          	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
			form.setMes(((TecnicaFormImpl)valor).getMes());
			form.setDia(((TecnicaFormImpl)valor).getDia());
			form.setHora(((TecnicaFormImpl)valor).getHora());
			form.setMinutos(((TecnicaFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

          	
          	
		}
    	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
    		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
    		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
          	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
          	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
			form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
			form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
			form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
			form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
      	}
    	else if(valor instanceof TecnicaValidaVolverFormImpl){
    		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
    		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
          	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
          	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
			form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
			form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
			form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
			form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
    	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
    		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
    		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
          	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
          	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
          	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
          	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
          	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
          	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
          	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
          	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
          	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
          	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
          	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
	      	
	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
			form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
			form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
			form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
			form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
			form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
			form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
			form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
    	}
    	int longitudFormatos=form.getFormatos().size();
    	int longitudLocalizacion=form.getLocalizacion().size();
    	int longitudRequisitos=form.getRequerimiento().size();
    	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
    	for(int i= 0;i< form.getRequerimiento().size();i++){
    		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
		}
    	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
    	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
    	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
	  	
	  	
	  	
	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

       //formatos
       form.setFormatosAsArray(formatos); 
       //Tamaño
       form.setTamanio(tamaño);
       //localizacion
       form.setLocalizacionAsArray(localizaciones);
       //requeriminetos
       form.setRequerimientoAsArray(requisitos); 	
       //notas de instalacion
       form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
       //mas requerimientos
       form.setDescripcionRequerimientosAsArray(masRequisitos);
       form.setDescripcionDuracionAsArray(duracionDesc);
       form.setAnyo(anyos);
		form.setMes(meses);
		form.setDia(dias);
		form.setHora(horas);
		form.setMinutos(minutos);
		form.setSegundosP1(segundosP1);
		form.setSegundosP2(segundosP2);
		
		
		 //posicion de la descripcion que se quiere eliminar   
       	String posicion = request.getAttribute("posicion").toString();
       	int posicionInt = Integer.parseInt(posicion);
    	DescripcionVO[] aDuDesc=(DescripcionVO[]) form.getDescripcionDuracionAsArray();
    	LangStringVO[] langString = aDuDesc[0].getTextos();
    	LangStringVO[] nuevolangString = new LangStringVO[langString.length -1];
     	//añado al nuevo array de descripcion con todas las descripciones menos la que 
     	//queremos eliminar
     	for (int i = 0; i<nuevolangString.length;i++){
     		if (i < posicionInt)
     			nuevolangString[i] = langString[i];
     		else
     			nuevolangString[i] = langString[i+1]; 
     	}
     	DescripcionVO duDescVO = new DescripcionVO();
     	duDescVO.setTextos(nuevolangString);
     	aDuDesc[0]= duDescVO;
     	form.setDescripcionDuracionAsArray(aDuDesc);
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo eliminarDescDuracion " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo eliminarDescDuracion " + e);
			throw new Exception("tecnica",e);
		}     
     }




    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#esValidaTecnica(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EsValidaTecnicaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean esValidaTecnica(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EsValidaTecnicaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

    	String resultado= ""; 
		boolean ok= true;

		
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		Collection mensajes = new ArrayList();
		
		CatalogadorAvSession os = this.getCatalogadorAvSession(request);
	
		AvTechnicalVO tec = new AvTechnicalVO();
		
		Object valor = request.getSession().getAttribute("form");

		
		
		
		
		
    	//Obtenemos la longitudes de los VOs, que pasamos a cambioFormulario para que se obtengan del request los cambios que hemos hecho
    	//Pues en el form que nos viene como parametro no los guarda.
		
		int longitudFormatos=0;
    	int longitudTamanio=1;
    	int longitudLocalizaciones=0;
    	int longitudRequerimientos=0;
    	int[] longitudAgregadores=new int[0];
    	int longitudInstalaciones=0;
    	int longitudMasRequerimientos=0;
    	int longitudDescDuracion=0;
    	
    	if (valor instanceof TecnicaFormImpl) {
    		TecnicaFormImpl valorTec = ((TecnicaFormImpl)valor);
    		Object[] req = valorTec.getRequerimientoAsArray();
			longitudAgregadores = new int[req.length];
			for(int i= 0;i< req.length;i++){
				longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
			}
			
		  	longitudRequerimientos=req.length;
		  	longitudFormatos=((TecnicaFormImpl)valor).getFormatosAsArray().length;
		  	longitudLocalizaciones=((TecnicaFormImpl)valor).getLocalizacionAsArray().length;
		  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
		  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
		  	
		  	longitudDescDuracion=((DescripcionVO[])((TecnicaFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
		  	
    	  			
    	}else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
    		TecnicaFormAccionSubmitFormImpl valorTec = ((TecnicaFormAccionSubmitFormImpl)valor);
    		Object[] req = valorTec.getRequerimientoAsArray();
			longitudAgregadores = new int[req.length];
			for(int i= 0;i< req.length;i++){
				longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
			}
			
		  	longitudRequerimientos=req.length;
		  	longitudFormatos=((TecnicaFormAccionSubmitFormImpl)valor).getFormatosAsArray().length;
		  	longitudLocalizaciones=((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacionAsArray().length;
		  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
		  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
		  	longitudDescDuracion=((DescripcionVO[])((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	}else if(valor instanceof TecnicaValidaVolverFormImpl){
    		TecnicaValidaVolverFormImpl valorTec = ((TecnicaValidaVolverFormImpl)valor);
    		Object[] req = valorTec.getRequerimientoAsArray();
			longitudAgregadores = new int[req.length];
			for(int i= 0;i< req.length;i++){
				longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
			}
			
		  	longitudRequerimientos=req.length;
		  	longitudFormatos=((TecnicaValidaVolverFormImpl)valor).getFormatosAsArray().length;
		  	longitudLocalizaciones=((TecnicaValidaVolverFormImpl)valor).getLocalizacionAsArray().length;
		  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
		  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
		  	longitudDescDuracion=((DescripcionVO[])((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
    		TecnicaNoValidaVolverFormImpl valorTec = ((TecnicaNoValidaVolverFormImpl)valor);
    		Object[] req = valorTec.getRequerimientoAsArray();
			longitudAgregadores = new int[req.length];
			for(int i= 0;i< req.length;i++){
				longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
			}
			
		  	longitudRequerimientos=req.length;
		  	longitudFormatos=((TecnicaNoValidaVolverFormImpl)valor).getFormatosAsArray().length;
		  	longitudLocalizaciones=((TecnicaNoValidaVolverFormImpl)valor).getLocalizacionAsArray().length;
		  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
		  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
		  	longitudDescDuracion=((DescripcionVO[])((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
    	}
    	
    	cambioFormulario(request,longitudFormatos,longitudLocalizaciones,longitudRequerimientos,
				longitudAgregadores,longitudInstalaciones,longitudMasRequerimientos,longitudDescDuracion);
    	
//    	Guardamos los cambios en el form obtenido de request.getSession.getAttribute("form") para que en caso de faltar
	  	//algun idioma o texto sin rellenar cargue el formulario con lo cambio y no perdamos todo lo modificado hasta ese
	  	//momento, si no lo hicieramos cargaría el formulario anterior.
    	
    	tec.setFormatos(formatos);
    	TamanioVO tam=new TamanioVO();
    	tam.setTexto(tamaño);
    	tec.setTamanio(tam);
    	tec.setLocalizaciones(localizaciones);
    	tec.setRequisitos(requisitos);
    	tec.setPautasInstalacion(notasDeInstalacion[0]);
    	tec.setOtrosRequisitos(masRequisitos[0]);
    	tec.setDuracion(duracion);
    	
  
		
		os.setLomValidacion(new LomAvanzadoVO());
		os.getLomValidacion().setTechnical(tec);
		
		this.setCatalogadorAvSession(request, os);
		
		
//		Collection errores=new ArrayList();
		
		//NOMBRE
		
		String nombre="";
		String tipo="";
		int i= 0;
		while ((ok)&&(i<tec.getRequisitos().length)){
			AgregadorORVO[] cat= tec.getRequisitos()[i].getAgregadoresOR();
			if(cat!=null && cat.length>0){
				int j=0;
				while((ok)&&(j<cat.length)){
					SourceValueVO sNombre= cat[j].getNombre();
					SourceValueVO sTipo=cat[j].getTipo();
					if(sNombre!=null){
						nombre=sNombre.getValor();
					}
					if(sTipo!=null){
						tipo=sTipo.getValor();
					}
					String min=cat[j].getVersionMin().getTexto().trim();
					String max=cat[j].getVersionMax().getTexto().trim();

					if(((nombre==null)||(nombre.equals("")))&&(((!tipo.equals("")))||((!min.equals("")))||((!max.equals(""))))){
						mensajes.add(datosResources.getString("CAV.4.4.1.2"));
					}
					if (!resultado.equals("")){
						ok= false;
					}else{
						j++;
					}
							
				}
				
			}if (!resultado.equals("")){
				ok= false;
			}else
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
					SourceValueVO sNombre= cat[j].getNombre();
					SourceValueVO sTipo=cat[j].getTipo();
					if(sNombre!=null){
						nombre=sNombre.getValor();
					}
					if(sTipo!=null){
						tipo=sTipo.getValor();
					}
					String min=cat[j].getVersionMin().getTexto().trim();
					String max=cat[j].getVersionMax().getTexto().trim();
					if(((tipo==null)||(tipo.equals("")))&&(((!nombre.equals("")))||((!min.equals("")))||((!max.equals(""))))){
						mensajes.add(datosResources.getString("CAV.4.4.1.1"));
					}
					if (!resultado.equals("")){
						ok= false;
					}else{
						j++;
					}
							
				}
			}if (!resultado.equals("")){
				ok= false;
			}else
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

        //DURACION

        boolean duracionVacia=false;
        
        if(   (anyos!=null && anyos.trim().equals("")) && 
              (meses!=null && meses.trim().equals("")) &&
              (dias!=null && dias.trim().equals("")) &&
              (horas!=null && horas.trim().equals("")) &&
              (minutos!=null && minutos.trim().equals("")) &&
              (segundosP1!=null && segundosP1.trim().equals("")) &&
              (segundosP2!=null && segundosP2.trim().equals("")))
        {
              //si alguno de los campos dia, mes o anyo esta vacio, fecha esta vacio
              duracionVacia=true;
        }

        if(todosVacios && !duracionVacia)
              mensajes.add(datosResources.getString("CAV.4.7.2"));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
        if(!todosVacios && duracionVacia)
             mensajes.add(datosResources.getString("CAV.4.7.1"));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n
        
        //TAMAÑO
        if(tamaño!=null && !tamaño.equals("")){
	        try{
	        	Long bigTamaño=new Long(tamaño);
	        	if(bigTamaño.intValue()<0){
	        		mensajes.add(datosResources.getString("CAV.4.1"));//Meterle la validación del integer no negativo
	        	}
	        }catch(Exception e){
	        	mensajes.add(datosResources.getString("CAV.4.1"));//Meterle la validación del integer no negativo
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#guardarTecnica(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.GuardarTecnicaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarTecnica(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.GuardarTecnicaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	boolean errorFaltaIdioma = false;
		boolean errorFaltaTexto = false;
		boolean errorNoNumero = false;
		boolean errorSegundos = false;
		boolean tamNum=true;
		
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		LomAvanzadoVO auxAvanzado=null;
		TamanioVO tamAux=null;
		PautasInstalacionVO pautas=null;
		OtrosRequisitosVO otros=null;
		DuracionVO duracionVO =null;
		
		try{
			auxAvanzado=new LomAvanzadoVO();
			AvTechnicalVO tecnica=new AvTechnicalVO();
			auxAvanzado.setTechnical(tecnica);
			
			String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
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
		
		
	    	Object valor = request.getSession().getAttribute("form");
	    	
	    	//Obtenemos la longitudes de los VOs, que pasamos a cambioFormulario para que se obtengan del request los cambios que hemos hecho
	    	//Pues en el form que nos viene como parametro no los guarda.
	    	
	    	int longitudFormatos=0;
	    	int longitudTamanio=1;
	    	int longitudLocalizaciones=0;
	    	int longitudRequerimientos=0;
	    	int[] longitudAgregadores=new int[0];
	    	int longitudInstalaciones=0;
	    	int longitudMasRequerimientos=0;
	    	int longitudDescDuracion=0;
	    	
	    	if (valor instanceof TecnicaFormImpl) {
	    		TecnicaFormImpl valorTec = ((TecnicaFormImpl)valor);
	    		Object[] req = valorTec.getRequerimientoAsArray();
				longitudAgregadores = new int[req.length];
				for(int i= 0;i< req.length;i++){
					longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
				}
				
			  	longitudRequerimientos=req.length;
			  	longitudFormatos=((TecnicaFormImpl)valor).getFormatosAsArray().length;
			  	longitudLocalizaciones=((TecnicaFormImpl)valor).getLocalizacionAsArray().length;
			  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
			  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
			  	
			  	longitudDescDuracion=((DescripcionVO[])((TecnicaFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
	    	  	
	    	  			
	    	}else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
	    		TecnicaFormAccionSubmitFormImpl valorTec = ((TecnicaFormAccionSubmitFormImpl)valor);
	    		Object[] req = valorTec.getRequerimientoAsArray();
				longitudAgregadores = new int[req.length];
				for(int i= 0;i< req.length;i++){
					longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
				}
				
			  	longitudRequerimientos=req.length;
			  	longitudFormatos=((TecnicaFormAccionSubmitFormImpl)valor).getFormatosAsArray().length;
			  	longitudLocalizaciones=((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacionAsArray().length;
			  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
			  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
			  	longitudDescDuracion=((DescripcionVO[])((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
	    	  	
	    	  	
	    	}else if(valor instanceof TecnicaValidaVolverFormImpl){
	    		TecnicaValidaVolverFormImpl valorTec = ((TecnicaValidaVolverFormImpl)valor);
	    		Object[] req = valorTec.getRequerimientoAsArray();
				longitudAgregadores = new int[req.length];
				for(int i= 0;i< req.length;i++){
					longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
				}
				
			  	longitudRequerimientos=req.length;
			  	longitudFormatos=((TecnicaValidaVolverFormImpl)valor).getFormatosAsArray().length;
			  	longitudLocalizaciones=((TecnicaValidaVolverFormImpl)valor).getLocalizacionAsArray().length;
			  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
			  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
			  	longitudDescDuracion=((DescripcionVO[])((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
	    	  	
	    	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
	    		TecnicaNoValidaVolverFormImpl valorTec = ((TecnicaNoValidaVolverFormImpl)valor);
	    		Object[] req = valorTec.getRequerimientoAsArray();
				longitudAgregadores = new int[req.length];
				for(int i= 0;i< req.length;i++){
					longitudAgregadores[i]=((RequisitoVO)(req[i])).getAgregadoresOR().length;
				}
				
			  	longitudRequerimientos=req.length;
			  	longitudFormatos=((TecnicaNoValidaVolverFormImpl)valor).getFormatosAsArray().length;
			  	longitudLocalizaciones=((TecnicaNoValidaVolverFormImpl)valor).getLocalizacionAsArray().length;
			  	longitudInstalaciones=(((PautasInstalacionVO[])((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacionAsArray())[0]).getTextos().length;
			  	longitudMasRequerimientos=(((OtrosRequisitosVO[])((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientosAsArray())[0]).getTextos().length;
			  	longitudDescDuracion=((DescripcionVO[])((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracionAsArray())[0].getTextos().length;
	    	}
	    	
	    	cambioFormulario(request,longitudFormatos,longitudLocalizaciones,longitudRequerimientos,
					longitudAgregadores,longitudInstalaciones,longitudMasRequerimientos,longitudDescDuracion);
	    	
	//    	Guardamos los cambios en el form obtenido de request.getSession.getAttribute("form") para que en caso de faltar
		  	//algun idioma o texto sin rellenar cargue el formulario con lo cambio y no perdamos todo lo modificado hasta ese
		  	//momento, si no lo hicieramos cargaría el formulario anterior.
	    	
	    	//FORMATOS
	    	
	    	FormatoVO[] formatosAux=new FormatoVO[formatos.length];
	    	for(int i=0;i<formatos.length;i++){
	    		FormatoVO auxFormato=new FormatoVO();
	    		auxFormato.setTexto(formatos[i].getTexto().trim());
	    		formatosAux[i]=auxFormato;
	    		
	    	}
	    	
	    	//TAMAÑO
	    	tamAux=new TamanioVO();
	    	if(!tamaño.equals(""))
	    		tamAux.setTexto(tamaño);
	    	else
	    		tamAux=null;
	    	//tamaño=tamaño;
	    	
	    	//LOCALIZACIONES
	    	
	    	LocalizacionVO[] localizacionesAux=new LocalizacionVO[localizaciones.length];
	    	for(int i=0;i<localizaciones.length;i++){
	    		LocalizacionVO auxLocalizacion=new LocalizacionVO();
	    		auxLocalizacion.setTexto(localizaciones[i].getTexto().trim());
	    		localizacionesAux[i]=auxLocalizacion;
	    	}
	    	
	    	//REQUERIMIENTOS
	    	
	    	RequisitoVO[] requisitoAux=new RequisitoVO[requisitos.length];
	    	for(int i=0;i<requisitos.length;i++){
	    		RequisitoVO auxRequisito=new RequisitoVO();
	    		RequisitoVO requisito=requisitos[i];
	    		AgregadorORVO[] agrega=requisito.getAgregadoresOR();
	    		AgregadorORVO[] agregadoresAux=new AgregadorORVO[agrega.length];
	    		for(int j=0;j<agrega.length;j++){
	    			AgregadorORVO auxAgregador=new AgregadorORVO();
	    			SourceValueVO nom=new SourceValueVO();
	    			nom.setSource(agrega[j].getNombre().getSource());
	    			nom.setValor(agrega[j].getNombre().getValor());
	    			auxAgregador.setNombre(nom);
	    			SourceValueVO tip=new SourceValueVO();
	    			tip.setSource(agrega[j].getTipo().getSource());
	    			tip.setValor(agrega[j].getTipo().getValor());
	    			auxAgregador.setTipo(tip);
	    			VersionMaxVO max=new VersionMaxVO();
	    			max.setTexto(agrega[j].getVersionMax().getTexto().trim());
	    			auxAgregador.setVersionMax(max);
	    			VersionMinVO min=new VersionMinVO();
	    			min.setTexto(agrega[j].getVersionMin().getTexto().trim());
	    			auxAgregador.setVersionMin(min);
	    			agregadoresAux[j]=auxAgregador;
	    		}
	    		auxRequisito.setAgregadoresOR(agregadoresAux);
	    		requisitoAux[i]=auxRequisito;
	    	}
	    	
	    	//NOTAS DE INSTALACION
	    	PautasInstalacionVO[] pautasAux=new PautasInstalacionVO[1];
	 
	    	LangStringVO[] langPautaAux = new LangStringVO[notasDeInstalacion[0].getTextos().length];
	    	for(int i=0;i<notasDeInstalacion[0].getTextos().length;i++){
	    		LangStringVO nuevoLang = new LangStringVO();
	    		nuevoLang.setIdioma(notasDeInstalacion[0].getTextos()[i].getIdioma());
	    		nuevoLang.setTexto(notasDeInstalacion[0].getTextos()[i].getTexto().trim());
	    		langPautaAux[i] = nuevoLang;
	    	}
	    	PautasInstalacionVO pautaAux= new PautasInstalacionVO();
	    	pautaAux.setTextos(langPautaAux);
	    	pautasAux[0]=pautaAux;
	    	
	    	//MAS REQUERIMIENTOS
	    	
	    	OtrosRequisitosVO[] otrosAux=new OtrosRequisitosVO[1];
	    	 
	    	LangStringVO[] langOtroAux = new LangStringVO[masRequisitos[0].getTextos().length];
	    	for(int i=0;i<masRequisitos[0].getTextos().length;i++){
	    		LangStringVO nuevoLang = new LangStringVO();
	    		nuevoLang.setIdioma(masRequisitos[0].getTextos()[i].getIdioma());
	    		nuevoLang.setTexto(masRequisitos[0].getTextos()[i].getTexto().trim());
	    		langOtroAux[i] = nuevoLang;
	    	}
	    	OtrosRequisitosVO otroAux= new OtrosRequisitosVO();
	    	otroAux.setTextos(langOtroAux);
	    	otrosAux[0]=otroAux;
	    	
	    	//DURACION
	    	
	    	DescripcionVO[] descAux=new DescripcionVO[1];
	    	LangStringVO[] langDescAux=new LangStringVO[duracionDesc[0].getTextos().length];
	    	for(int i=0;i<duracionDesc[0].getTextos().length;i++){
	    		LangStringVO nuevoLang = new LangStringVO();
	    		nuevoLang.setIdioma(duracionDesc[0].getTextos()[i].getIdioma());
	    		nuevoLang.setTexto(duracionDesc[0].getTextos()[i].getTexto().trim());
	    		langDescAux[i] = nuevoLang;
	    	}
	    	DescripcionVO otroDesc=new DescripcionVO();
	    	otroDesc.setTextos(langDescAux);
	    	descAux[0]=otroDesc;
	    	
	    	if (valor instanceof TecnicaFormImpl) {
	    		((TecnicaFormImpl)valor).setFormatosAsArray(formatosAux);
	    		((TecnicaFormImpl)valor).setTamanio(tamaño);
	    		((TecnicaFormImpl)valor).setLocalizacionAsArray(localizacionesAux);
	    		((TecnicaFormImpl)valor).setRequerimientoAsArray(requisitoAux);
	    		((TecnicaFormImpl)valor).setDescripcionInstalacionAsArray(pautasAux);
	    		((TecnicaFormImpl)valor).setDescripcionRequerimientosAsArray(otrosAux);
	    		((TecnicaFormImpl)valor).setDescripcionDuracionAsArray(descAux);
	    		((TecnicaFormImpl)valor).setAnyo(anyos);
	    		((TecnicaFormImpl)valor).setMes(meses);
	    		((TecnicaFormImpl)valor).setDia(dias);
	    		((TecnicaFormImpl)valor).setHora(horas);
	    		((TecnicaFormImpl)valor).setMinutos(minutos);
	    		((TecnicaFormImpl)valor).setSegundosP1(segundosP1);
	    		((TecnicaFormImpl)valor).setSegundosP2(segundosP2);
			}
	    	else if(valor instanceof TecnicaFormAccionSubmitFormImpl ){
	    		((TecnicaFormAccionSubmitFormImpl)valor).setFormatosAsArray(formatosAux);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setTamanio(tamaño);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setLocalizacionAsArray(localizacionesAux);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setRequerimientoAsArray(requisitoAux);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setDescripcionInstalacionAsArray(pautasAux);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setDescripcionRequerimientosAsArray(otrosAux);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setDescripcionDuracionAsArray(descAux);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setAnyo(anyos);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setMes(meses);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setDia(dias);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setHora(horas);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setMinutos(minutos);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setSegundosP1(segundosP1);
	    		((TecnicaFormAccionSubmitFormImpl)valor).setSegundosP2(segundosP2);
	      	}else if(valor instanceof TecnicaValidaVolverFormImpl){
	    		((TecnicaValidaVolverFormImpl)valor).setFormatosAsArray(formatosAux);
	    		((TecnicaValidaVolverFormImpl)valor).setTamanio(tamaño);
	    		((TecnicaValidaVolverFormImpl)valor).setLocalizacionAsArray(localizacionesAux);
	    		((TecnicaValidaVolverFormImpl)valor).setRequerimientoAsArray(requisitoAux);
	    		((TecnicaValidaVolverFormImpl)valor).setDescripcionInstalacionAsArray(pautasAux);
	    		((TecnicaValidaVolverFormImpl)valor).setDescripcionRequerimientosAsArray(otrosAux);
	    		((TecnicaValidaVolverFormImpl)valor).setDescripcionDuracionAsArray(descAux);
	    		((TecnicaValidaVolverFormImpl)valor).setAnyo(anyos);
	    		((TecnicaValidaVolverFormImpl)valor).setMes(meses);
	    		((TecnicaValidaVolverFormImpl)valor).setDia(dias);
	    		((TecnicaValidaVolverFormImpl)valor).setHora(horas);
	    		((TecnicaValidaVolverFormImpl)valor).setMinutos(minutos);
	    		((TecnicaValidaVolverFormImpl)valor).setSegundosP1(segundosP1);
	    		((TecnicaValidaVolverFormImpl)valor).setSegundosP2(segundosP2);
	      	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
	    		((TecnicaNoValidaVolverFormImpl)valor).setFormatosAsArray(formatosAux);
	    		((TecnicaNoValidaVolverFormImpl)valor).setTamanio(tamaño);
	    		((TecnicaNoValidaVolverFormImpl)valor).setLocalizacionAsArray(localizacionesAux);
	    		((TecnicaNoValidaVolverFormImpl)valor).setRequerimientoAsArray(requisitoAux);
	    		((TecnicaNoValidaVolverFormImpl)valor).setDescripcionInstalacionAsArray(pautasAux);
	    		((TecnicaNoValidaVolverFormImpl)valor).setDescripcionRequerimientosAsArray(otrosAux);
	    		((TecnicaNoValidaVolverFormImpl)valor).setDescripcionDuracionAsArray(descAux);
	    		((TecnicaNoValidaVolverFormImpl)valor).setAnyo(anyos);
	    		((TecnicaNoValidaVolverFormImpl)valor).setMes(meses);
	    		((TecnicaNoValidaVolverFormImpl)valor).setDia(dias);
	    		((TecnicaNoValidaVolverFormImpl)valor).setHora(horas);
	    		((TecnicaNoValidaVolverFormImpl)valor).setMinutos(minutos);
	    		((TecnicaNoValidaVolverFormImpl)valor).setSegundosP1(segundosP1);
	    		((TecnicaNoValidaVolverFormImpl)valor).setSegundosP2(segundosP2);
	      	}
	    	
	//    	Obtnemos los terminos de los ids seleccionados en todos los combos, y los guarda en los VO 
			dameTerminoId();  
	//		Comprobamos si los campos ha sido rellenados adecuadamente
			
			//FORMATOS
			
			if((formatos!=null)&&(formatos.length!=0)){
				ArrayList lista=new ArrayList();
				for(int i=0;i<formatos.length;i++){
					FormatoVO forma=(FormatoVO)formatos[i];
					if((forma!=null)&&(!forma.getTexto().equals(""))){
						FormatoVO formatoAux=new FormatoVO();
						formatoAux.setTexto(forma.getTexto().trim());
						lista.add(formatoAux);
					}
				}
				formatos=(FormatoVO[])lista.toArray(new FormatoVO[lista.size()]);
				if(formatos.length==0)
					formatos=null;
			}else
				formatos=null;
			auxAvanzado.getTechnical().setFormatos(formatos);
			
			//TAMAÑO??
			auxAvanzado.getTechnical().setTamanio(tamAux);
			
			//LOCALIZACION
			if((localizaciones!=null)&&(localizaciones.length!=0)){
				ArrayList lista=new ArrayList();
				for(int i=0;i<localizaciones.length;i++){
					LocalizacionVO loca=(LocalizacionVO)localizaciones[i];
					if((loca!=null)&&(!loca.getTexto().equals(""))){
						LocalizacionVO localizacionAux=new LocalizacionVO();
						localizacionAux.setTexto(loca.getTexto().trim());
						lista.add(localizacionAux);
					}
				}
				localizaciones=(LocalizacionVO[])lista.toArray(new LocalizacionVO[lista.size()]);
				if(localizaciones.length==0)
					localizaciones=null;
			}else
				localizaciones=null;
			auxAvanzado.getTechnical().setLocalizaciones(localizaciones);
			
			//REQUERIMIENTOS
			
			if((requisitos!=null)&&(requisitos.length!=0)){
				ArrayList lista=new ArrayList();
				AgregadorORVO[] agregadores=requisitos[0].getAgregadoresOR();
			
				if(requisitos.length==1&&agregadores.length==1 && agregadores[0].getNombre().getValor().equals("")&& 
						agregadores[0].getTipo().getValor().equals("")
						&& agregadores[0].getVersionMax().getTexto().equals("")&& agregadores[0].getVersionMin().getTexto().equals("")){
					requisitos=null;
				}else{
						for(int i=0;i<requisitos.length;i++){
							if(requisitos!=null){
								ArrayList listAgr=new ArrayList();
								RequisitoVO lRequi=(RequisitoVO)requisitos[i];
								RequisitoVO lRequisitos=new RequisitoVO();
								for(int j=0;j<lRequi.getAgregadoresOR().length;j++){
									AgregadorORVO agrega=lRequi.getAgregadoresOR()[j];
									AgregadorORVO lAgrega=new AgregadorORVO();
									String name=agrega.getNombre().getValor();
									String type=agrega.getTipo().getValor();
									String min=agrega.getVersionMin().getTexto();
									String max=agrega.getVersionMax().getTexto();
									if(((name!=null)&&(!name.equals("")))  ||
									   ((type!=null)&&(!type.equals("")))||
									   ((min!=null)&&(!min.trim().equals("")))||
									   ((max!=null)&&(!max.trim().equals("")))){
										SourceValueVO nombre=new SourceValueVO();
										nombre.setSource(source);
										nombre.setValor(name);
										lAgrega.setNombre(nombre);
										SourceValueVO tipo=new SourceValueVO();
										tipo.setSource(source);
										tipo.setValor(type);
										lAgrega.setTipo(tipo);
										VersionMaxVO maxi=new VersionMaxVO();
										maxi.setTexto(max.trim());
										lAgrega.setVersionMax(maxi);
										VersionMinVO mini=new VersionMinVO();
										mini.setTexto(min.trim());
										lAgrega.setVersionMin(mini);
										listAgr.add(lAgrega);
									}
								}
								if (listAgr.size() != 0){
									AgregadorORVO[] agregas=(AgregadorORVO[])listAgr.toArray(new AgregadorORVO[listAgr.size()]);
									lRequisitos.setAgregadoresOR(agregas);
									lista.add(lRequisitos);
									
								}
							}
						}
						if(lista.size()== 0)
							requisitos = null;
						else
							requisitos=(RequisitoVO[])lista.toArray(new RequisitoVO[lista.size()]);
					}
			}else
				requisitos =null;
			auxAvanzado.getTechnical().setRequisitos(requisitos);
			
			//NOTAS DE INSTALACION
			
			pautas=new PautasInstalacionVO();
			if(notasDeInstalacion!=null && notasDeInstalacion.length!=0){
				PautasInstalacionVO pauta=(PautasInstalacionVO)notasDeInstalacion[0];
				LangStringVO[] textos=pauta.getTextos();
				ArrayList lista=new ArrayList();
				for(int j=0;j<textos.length;j++){
					LangStringVO lPat=(LangStringVO) textos[j];
						 
					if(lPat !=null){
						LangStringVO lLang=new LangStringVO();
						String idioma=lPat.getIdioma();
						String texto=lPat.getTexto().trim();
						if(((idioma!=null)&&(!idioma.equals(""))) && ((texto!=null)&&(!texto.trim().equals("")))){
							lLang.setIdioma(idioma);
							lLang.setTexto(texto);
							lista.add(lLang);
						}
						else{
							if (idioma.equals("") && !texto.equals("") )
								errorFaltaIdioma = true;
							if (!idioma.equals("") && texto.equals(""))
								errorFaltaTexto = true;
						}
					}						 						 	
				}
				LangStringVO[] lLangS=(LangStringVO[])lista.toArray(new LangStringVO[lista.size()]);
				if(lLangS.length == 0)
					pautas = null;
				else
					pautas.setTextos(lLangS); 
			}
			else 
				pautas = null;
		
			auxAvanzado.getTechnical().setPautasInstalacion(pautas);
			
			//MAS REQUERIMIENTOS
			
			otros=new OtrosRequisitosVO();
			if(masRequisitos!=null && masRequisitos.length!=0){
				OtrosRequisitosVO otro=(OtrosRequisitosVO)masRequisitos[0];
				LangStringVO[] textos=otro.getTextos();
				ArrayList lista=new ArrayList();
				for(int j=0;j<textos.length;j++){
					LangStringVO lOtro=(LangStringVO) textos[j];
						 
					if(lOtro !=null){
						LangStringVO lLang=new LangStringVO();
						String idioma=lOtro.getIdioma();
						String texto=lOtro.getTexto();
						if(((idioma!=null)&&(!idioma.equals(""))) && ((texto!=null)&&(!texto.trim().equals("")))){
							lLang.setIdioma(idioma);
							lLang.setTexto(texto.trim());
							lista.add(lLang);
						}
						else{
							if (idioma.equals("") && !texto.equals("") )
								errorFaltaIdioma = true;
							if (!idioma.equals("") && texto.equals(""))
								errorFaltaTexto = true;
						}
					}						 						 	
				}
				LangStringVO[] lLangS=(LangStringVO[])lista.toArray(new LangStringVO[lista.size()]);
				if(lLangS.length == 0)
					otros = null;
				else
					otros.setTextos(lLangS); 
			}
			else 
				otros = null;
			
		
			auxAvanzado.getTechnical().setOtrosRequisitos(otros);
			
			//Duracion
			DescripcionVO duras=new DescripcionVO();
			if(duracionDesc!=null && duracionDesc.length!=0){
				DescripcionVO descD=(DescripcionVO)duracionDesc[0];
				LangStringVO[] textos=descD.getTextos();
				ArrayList lista=new ArrayList();
				for(int j=0;j<textos.length;j++){
					LangStringVO lOtro=(LangStringVO) textos[j];
						 
					if(lOtro !=null){
						LangStringVO lLang=new LangStringVO();
						String idioma=lOtro.getIdioma();
						String texto=lOtro.getTexto();
						if(((idioma!=null)&&(!idioma.equals(""))) && ((texto!=null)&&(!texto.trim().equals("")))){
							lLang.setIdioma(idioma);
							lLang.setTexto(texto.trim());
							lista.add(lLang);
						}
						else{
							if (idioma.equals("") && !texto.equals("") )
								errorFaltaIdioma = true;
							if (!idioma.equals("") && texto.equals(""))
								errorFaltaTexto = true;
						}
					}						 						 	
				}
				LangStringVO[] lLangS=(LangStringVO[])lista.toArray(new LangStringVO[lista.size()]);
				if(lLangS.length == 0)
					duras = null;
				else
					duras.setTextos(lLangS); 
			}
			else 
				duras = null;
			anyos=anyos.trim();
			meses=meses.trim();
			dias=dias.trim();
			horas=horas.trim();
			minutos=minutos.trim();
			segundosP1=segundosP1.trim();
			segundosP2=segundosP2.trim();
			form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
			
			duracionVO = new DuracionVO();
			duracionVO.setDescripcion(duras);
			
			String duration="";
			if (!dias.equals("") || !meses.equals("") || !anyos.equals("")){
				duration="P";
				if(!anyos.equals(""))
					if (!anyos.matches("\\d{1,}"))
						errorNoNumero = true;
					else
						duration = duration + anyos + "Y";
				if(!meses.equals(""))
					if (!meses.matches("\\d{1,}"))
						errorNoNumero = true;
					else
						duration = duration + meses + "M";
				if(!dias.equals("")){
					if (!dias.matches("\\d{1,}"))
						errorNoNumero = true;
					else		
						duration = duration + dias + "D";
				}
				
				
			}
			if (!horas.equals("") || !minutos.equals("") || !segundosP1.equals("") || !segundosP2.equals("")){
				if (duration.equals(""))
					duration = "PT";
				else
					duration = duration + "T";
				if (!horas.equals(""))
					if (!horas.matches("\\d{1,}"))
						errorNoNumero = true;
					else
						duration = duration + horas + "H";
				if (!minutos.equals(""))
					if (!minutos.matches("\\d{1,}"))
						errorNoNumero = true;
					else
						duration = duration + minutos + "M";
				if (!segundosP1.equals(""))
					if (!segundosP1.matches("\\d{1,}"))
						errorNoNumero = true;
					else
						if (segundosP2.equals(""))
							duration = duration + segundosP1 + "S";
						else
							if (!segundosP2.matches("\\d{1,}"))
								errorNoNumero = true;
							else
								duration = duration + segundosP1 + "." + segundosP2 + "S";
				if (segundosP1.equals("") && !segundosP2.equals(""))
					errorSegundos = true;
			}
			if(duration.equals(""))
				duration=null;
			duracionVO.setDuracion(duration);
			
			if((duracionVO.getDescripcion()==null)&&(duracionVO.getDuracion()==null)){
				duracionVO=null;
			}
			
			auxAvanzado.getTechnical().setDuracion(duracionVO);
			 //TAMAÑO
			if(tamaño!=null && !tamaño.equals("")){
		        try{
		        	Long bigTamaño=new Long(tamaño);
		        	if(bigTamaño.intValue()<0){
		        		tamNum=false;
		        	}
		        }catch(Exception e){
		        	tamNum=false;
		        }
			}
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tecnica", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Tecnica, metodo guardarTecnica " + e);
			throw new java.lang.Exception("tecnica", e);
		
		}
		
		if(!errorFaltaIdioma && !errorFaltaTexto && !errorNoNumero && !errorSegundos && tamNum){				
			try{
				//			Cargamos el objeto de sesion
				if(catalogadorAvSession.getMDSesion()==null){
						catalogadorAvSession.setMDSesion(auxAvanzado);
								
				}else{
					if (formatos == null && tamAux == null && localizaciones == null && requisitos == null && pautas == null
									&& otros == null && duracionVO==null )
							catalogadorAvSession.getMDSesion().setTechnical(null);
					else
							catalogadorAvSession.getMDSesion().setTechnical(auxAvanzado.getTechnical());
				}
			}catch (Exception e) {
				logger.error("Error en catalogadorWeb, categoría Tecnica, método guardarTecnica " + e);
				throw new java.lang.Exception("tecnica", e);
			}

		}else{
			if (errorFaltaIdioma && errorFaltaTexto)
				throw new ValidatorException("{tecnica.error.idioma_texto}");
			else if (!errorFaltaIdioma && errorFaltaTexto)
				throw new ValidatorException("{tecnica.error.texto}");
			else if (errorFaltaIdioma && !errorFaltaTexto)
				throw new ValidatorException("{tecnica.error.idioma}");
			else if (errorNoNumero)
				throw new ValidatorException("{tecnica.error.NoNumero}");
			else if(errorSegundos)
				throw new ValidatorException("{tecnica.error.Segundos}");
			else if(!tamNum)
				throw new ValidatorException("{tecnica.error.Tamaino}");
		}
		
     }







	public void anadirInstalacion(ActionMapping mapping, AnadirInstalacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof TecnicaFormImpl) {
        		form.setFormatos((((TecnicaFormImpl)valor).getFormatos()));
              	form.setFormatosLabelList((((TecnicaFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormImpl)valor).getFormatosValueList()));
              	form.setLocalizacion(((TecnicaFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormImpl)valor).getMes());
				form.setDia(((TecnicaFormImpl)valor).getDia());
				form.setHora(((TecnicaFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormImpl)valor).getSegundosP2());

              	
              	
    		}
        	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
        		form.setFormatos((((TecnicaFormAccionSubmitFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaFormAccionSubmitFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaFormAccionSubmitFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaFormAccionSubmitFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaFormAccionSubmitFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaFormAccionSubmitFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaFormAccionSubmitFormImpl)valor).getAnyo());
				form.setMes(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setDia(((TecnicaFormAccionSubmitFormImpl)valor).getDia());
				form.setHora(((TecnicaFormAccionSubmitFormImpl)valor).getHora());
				form.setMinutos(((TecnicaFormAccionSubmitFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaFormAccionSubmitFormImpl)valor).getSegundosP2());
          	}
        	else if(valor instanceof TecnicaValidaVolverFormImpl){
        		form.setFormatos((((TecnicaValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaValidaVolverFormImpl)valor).getSegundosP2());
        	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
        		form.setFormatos((((TecnicaNoValidaVolverFormImpl)valor).getFormatos()));
        		form.setFormatosLabelList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosLabelList()));
              	form.setFormatosValueList((((TecnicaNoValidaVolverFormImpl)valor).getFormatosValueList()));
              	form.setTamanio(((TecnicaNoValidaVolverFormImpl)valor).getTamanio());
              	form.setLocalizacion(((TecnicaNoValidaVolverFormImpl)valor).getLocalizacion());
              	form.setComboTipoLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoLabelList());
              	form.setComboTipoValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboTipoValueList());
              	form.setComboNombreLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreLabelList());
              	form.setComboNombreValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboNombreValueList());
              	form.setRequerimiento(((TecnicaNoValidaVolverFormImpl)valor).getRequerimiento());
              	form.setDescripcionInstalacion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionInstalacion());
              	form.setDescripcionRequerimientos(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionRequerimientos());
              	form.setComboIdiomaLabelList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((TecnicaNoValidaVolverFormImpl)valor).getComboIdiomaValueList());
    	      	
    	      	form.setDescripcionDuracion(((TecnicaNoValidaVolverFormImpl)valor).getDescripcionDuracion());
				form.setAnyo(((TecnicaNoValidaVolverFormImpl)valor).getAnyo());
				form.setMes(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setDia(((TecnicaNoValidaVolverFormImpl)valor).getDia());
				form.setHora(((TecnicaNoValidaVolverFormImpl)valor).getHora());
				form.setMinutos(((TecnicaNoValidaVolverFormImpl)valor).getMes());
				form.setSegundosP1(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP1());
				form.setSegundosP2(((TecnicaNoValidaVolverFormImpl)valor).getSegundosP2());
        	}
        	int longitudFormatos=form.getFormatos().size();
        	int longitudLocalizacion=form.getLocalizacion().size();
        	int longitudRequisitos=form.getRequerimiento().size();
        	int[] longitudAgregadores=new int[form.getRequerimiento().size()];
        	for(int i= 0;i< form.getRequerimiento().size();i++){
        		longitudAgregadores[i]=(((RequisitoVO)(form.getRequerimientoAsArray()[i])).getAgregadoresOR()).length;
    		}
        	int longitudNotasDeInstalacion=((PautasInstalacionVO[])form.getDescripcionInstalacionAsArray())[0].getTextos().length;
        	int longitudMasRequerimientos=((OtrosRequisitosVO[])form.getDescripcionRequerimientosAsArray())[0].getTextos().length;
        	int longitudDecDuracion=((DescripcionVO[])form.getDescripcionDuracionAsArray())[0].getTextos().length;
    	  	
    	  	
    	  	
    	  	cambioFormulario(request,longitudFormatos,longitudLocalizacion,longitudRequisitos,
    				longitudAgregadores,longitudNotasDeInstalacion,longitudMasRequerimientos,longitudDecDuracion);

           //formatos
           form.setFormatosAsArray(formatos); 
           //Tamaño
           form.setTamanio(tamaño);
           //localizacion
           form.setLocalizacionAsArray(localizaciones);
           //requeriminetos
           form.setRequerimientoAsArray(requisitos); 	
           //notas de instalacion
           form.setDescripcionInstalacionAsArray(notasDeInstalacion); 
           //mas requerimientos
           form.setDescripcionRequerimientosAsArray(masRequisitos);
           form.setDescripcionDuracionAsArray(duracionDesc);
           form.setAnyo(anyos);
			form.setMes(meses);
			form.setDia(dias);
			form.setHora(horas);
			form.setMinutos(minutos);
			form.setSegundosP1(segundosP1);
			form.setSegundosP2(segundosP2);
        	
               
           Object[] aPautas=form.getDescripcionInstalacionAsArray();
			PautasInstalacionVO pautaVO = (PautasInstalacionVO)aPautas[0];
			LangStringVO[] textos = pautaVO.getTextos();
			int nuevoTamano = textos.length +1;
			LangStringVO[] newTextos = new LangStringVO[nuevoTamano];
			for(int i=0;i<textos.length;i++)
				newTextos[i]=textos[i];
			LangStringVO langPauta=new LangStringVO();
			langPauta.setIdioma("");
			langPauta.setTexto("");
			newTextos[nuevoTamano-1]=langPauta;
			
			pautaVO.setTextos(newTextos);
			aPautas[0]=pautaVO;
			form.setDescripcionInstalacionAsArray(aPautas);
        	
    		
        	   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("tecnica", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Tecnica, metodo anadirInstalacion " + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Tecnica, metodo anadirInstalacion " + e);
			throw new Exception("tecnica",e);
		}     
		
	}	

	private void cambioFormulario(HttpServletRequest request,int longitudFormatos,int longitudLocalizacion,int longitudRequisitos,
			int[] longitudAgregadores, int longitudNotasDeInstalacion, int longitudMasRequerimientos, int longitudDescDuracion) throws Exception{
				
			String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
			
			formatos=new FormatoVO[longitudFormatos];//form.getIdentificadores().size()
		  	localizaciones = new LocalizacionVO[longitudLocalizacion];//form.getIdiomas().size()
		  	requisitos = new RequisitoVO[longitudRequisitos];//form.getDescripciones().size()
//		  	agregadores = new AgregadorORVO[longitudAgregadores];//form.getPalabrasClave().size()
		  	notasDeInstalacion =new PautasInstalacionVO[1];
		  	masRequisitos =new OtrosRequisitosVO[1];
		  	duracion=new DuracionVO();
		  	duracionDesc=new DescripcionVO[1];
		  	String[] formatoValor = new String[longitudFormatos];
		  	String[] localiza = new String[longitudLocalizacion];
		  	ArrayList[] tipos=new ArrayList[longitudAgregadores.length];
		  	ArrayList[] nombres=new ArrayList[longitudAgregadores.length];
		  	ArrayList[] minimos=new ArrayList[longitudAgregadores.length];
		  	ArrayList[] maximos=new ArrayList[longitudAgregadores.length];
		  	String[] idiomaIns=new String[longitudNotasDeInstalacion];
		  	String[] texIns=new String[longitudNotasDeInstalacion];
		  	String[] idiomaMasReq=new String[longitudMasRequerimientos];
		  	String[] texMasReq=new String[longitudMasRequerimientos];
		  	DescripcionVO[] textDura=new DescripcionVO[1];
		  	String[] descDura=new String[longitudDescDuracion];
		  	String[] idiomaDura=new String[longitudDescDuracion];
		  	
		  	
	       for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
	       {
	      	 String name = String.valueOf(names.nextElement());
	      	if (name.startsWith("Form")){
	      		 int i = Integer.parseInt(name.substring(4, name.length()));
	      		 formatoValor[i]=request.getParameter(name);
	           }
	      	if (name.startsWith("Tam")){
	      		tamaño=request.getParameter(name);
	           }
	        if(name.startsWith("Loc")) {
	           
	        	int i = Integer.parseInt(name.substring(3, name.length()));
	        	localiza[i]=request.getParameter(name);
	        }
	        
	        if(name.startsWith("Tipo")){
	          	 
	          	 String[] namePartido = name.split("_");
	          	 int i = Integer.parseInt(namePartido[0].substring(4, namePartido[0].length()));
	          	 
	          	 int j = Integer.parseInt(namePartido[1].substring(0, namePartido[1].length()));
	          		 ArrayList lTipos = tipos[i];
	          		 if(lTipos == null){
	          			lTipos= new ArrayList();
	          			 for (int k=0;k<longitudAgregadores[i];k++)
	          				lTipos.add("");
	          		 }
	          		 
	          		lTipos.set(j, request.getParameter(name));
	          		tipos[i]=lTipos;

	        }
	        if(name.startsWith("Nom")){
	        	String[] namePartido = name.split("_");
	          	 int i = Integer.parseInt(namePartido[0].substring(3, namePartido[0].length()));
	          	 
	          	 int j = Integer.parseInt(namePartido[1].substring(0, namePartido[1].length()));
	          		 ArrayList lNom = nombres[i];
	          		 if(lNom == null){
	          			lNom= new ArrayList();
	          			 for (int k=0;k<longitudAgregadores[i];k++)
	          				lNom.add("");
	          		 }
	          		 
	          		lNom.set(j, request.getParameter(name));
	          		nombres[i]=lNom;
	        }
	        if(name.startsWith("Mini")){
	        	String[] namePartido = name.split("_");
	          	 int i = Integer.parseInt(namePartido[0].substring(4, namePartido[0].length()));
	          	 
	          	 int j = Integer.parseInt(namePartido[1].substring(0, namePartido[1].length()));
	          		 ArrayList lMin= minimos[i];
	          		 if(lMin == null){
	          			lMin= new ArrayList();
	          			 for (int k=0;k<longitudAgregadores[i];k++)
	          				lMin.add("");
	          		 }
	          		 
	          		lMin.set(j, request.getParameter(name));
	          		minimos[i]=lMin;
	        }
	        if(name.startsWith("Max")){
	        	String[] namePartido = name.split("_");
	          	 int i = Integer.parseInt(namePartido[0].substring(3, namePartido[0].length()));
	          	 
	          	 int j = Integer.parseInt(namePartido[1].substring(0, namePartido[1].length()));
	          		 ArrayList lMax= maximos[i];
	          		 if(lMax == null){
	          			lMax= new ArrayList();
	          			 for (int k=0;k<longitudAgregadores[i];k++)
	          				lMax.add("");
	          		 }
	          		 
	          		lMax.set(j, request.getParameter(name));
	          		maximos[i]=lMax;
	        }
	        if(name.startsWith("Ins")){
	        	
	        	if(name.startsWith("InsTex")){
	        		int i = Integer.parseInt(name.substring(6, name.length()));
	        		texIns[i]=request.getParameter(name);
	        		
	        	}if(name.startsWith("InsIdio")){
	        		int i = Integer.parseInt(name.substring(7, name.length()));
	        		idiomaIns[i]=request.getParameter(name);
	        	}
	        }
	        if(name.startsWith("MasReq")){
	        	if(name.startsWith("MasReqTex")){
	        		int i = Integer.parseInt(name.substring(9, name.length()));
	        		texMasReq[i]=request.getParameter(name);
	        		
	        	}if(name.startsWith("MasReqIdio")){
	        		int i = Integer.parseInt(name.substring(10, name.length()));
	        		idiomaMasReq[i]=request.getParameter(name);
	        	}
	        }
	        if (name.equals("Anyos"))
	    		   anyos = request.getParameter(name);
	    	if (name.equals("Meses"))
	    		   meses = request.getParameter(name);
	    	if (name.equals("Dias"))
	    		   dias = request.getParameter(name);
	    	if (name.equals("Horas"))
	    		   horas = request.getParameter(name);
	    	if (name.equals("Minutos"))
	    		   minutos = request.getParameter(name);
	    	if (name.equals("SegundosP1"))
	    		   segundosP1 = request.getParameter(name);
	    	if (name.equals("SegundosP2"))
	    		   segundosP2 = request.getParameter(name);
	    	if (name.startsWith("DesDur")){
	        	   if(name.startsWith("DesDurTex")){
	        		   int i = Integer.parseInt(name.substring(9, name.length()));
	        		   descDura[i]=request.getParameter(name);
	        	   }	 
	        	   
	        	   if (name.startsWith("DesDurIdio")){
	        		   int i = Integer.parseInt(name.substring(10, name.length()));
	        		   idiomaDura[i]=request.getParameter(name);
	        	   }
	           }
	       }
	       for (int i = 0; i<formatoValor.length;i++){
	    	   FormatoVO formVO = new FormatoVO();
	    	   String formatoValorI=formatoValor[i]!=null?formatoValor[i]:"";
	    	   formVO.setTexto(formatoValorI.trim());
	    	   formatos[i] = formVO;
	       }
	       for (int i = 0; i<localiza.length;i++){
	    	   LocalizacionVO localizaVO = new LocalizacionVO();
	    	   String localizaI=localiza[i]!=null?localiza[i]:"";
	    	   localizaVO.setTexto(localizaI.trim()); 
	    	   localizaciones[i] = localizaVO;
	       } 


	       for(int i=0;i< longitudAgregadores.length;i++){
	    	   RequisitoVO requi=new RequisitoVO();
	    	   AgregadorORVO[] lAgregadores=new AgregadorORVO[longitudAgregadores[i]];
	    	   for(int j=0;j<longitudAgregadores[i];j++){
	    		   AgregadorORVO agregad=new AgregadorORVO();
	    		   SourceValueVO type=new SourceValueVO();
	    		   String tiposIJ="";
	    		   if ((tipos[i]!=null) && (tipos[i].get(j)!=null)) {
	    			   tiposIJ=tipos[i].get(j).toString();
	    		   }
	    		   type.setValor(tiposIJ.trim());
	    		   type.setSource(source);
	    		   SourceValueVO name=new SourceValueVO();
	    		   String nombresIJ="";
	    		   if ((nombres[i]!=null) && (nombres[i].get(j) !=null)) {
	    			   nombresIJ=nombres[i].get(j).toString();
	    		   }
	    		   name.setValor(nombresIJ.trim());
	    		   name.setSource(source);
	    		   VersionMinVO min=new VersionMinVO();
	    		   String minimosIJ="";
	    		   if ((minimos[i]!=null) && (minimos[i].get(j)!=null)) { 
	    			   minimosIJ=minimos[i].get(j).toString();
	    		   }
	    		   min.setTexto(minimosIJ.trim());
	    		   VersionMaxVO max=new VersionMaxVO();
	    		   String maximosIJ="";
	    		   if ((maximos[i]!=null) && (maximos[i].get(j)!=null)) {
	    			   maximosIJ= maximos[i].get(j).toString();
	    		   }
	    		   max.setTexto(maximosIJ.trim());
	    		   agregad.setTipo(type);
	    		   agregad.setNombre(name);
	    		   agregad.setVersionMin(min);
	    		   agregad.setVersionMax(max);
	    		   lAgregadores[j]=agregad;
	    	   }
	    	   requi.setAgregadoresOR(lAgregadores);
	    	   requisitos[i]=requi;
	       }

	       
	       PautasInstalacionVO pautas=new PautasInstalacionVO();
	       LangStringVO[] aLangPautas=new LangStringVO[texIns.length];
	       for(int i=0;i<longitudNotasDeInstalacion;i++){
	    	   LangStringVO langPauta=new LangStringVO();
	    	   String texInsI=texIns[i]!=null?texIns[i]:"";
	    	   langPauta.setTexto(texInsI.trim());
	    	   langPauta.setIdioma(idiomaIns[i]);
	    	   aLangPautas[i]=langPauta;
	       }
	       pautas.setTextos(aLangPautas);
	       notasDeInstalacion[0]=pautas;
	       
	       OtrosRequisitosVO otros=new OtrosRequisitosVO();
	       LangStringVO[] aLangOtros=new LangStringVO[texMasReq.length];
	       for(int i=0;i<longitudMasRequerimientos;i++){
	    	   LangStringVO langOtro=new LangStringVO();
	    	   String texMasReqI=texMasReq[i]!=null?texMasReq[i]:"";
	    	   langOtro.setTexto(texMasReqI.trim());
	    	   String idiomaMasReqI=idiomaMasReq[i]!=null?idiomaMasReq[i]:"";
	    	   langOtro.setIdioma(idiomaMasReqI);
	    	   aLangOtros[i]=langOtro;
	       }
	       otros.setTextos(aLangOtros);
	       masRequisitos[0]=otros;
	       
//	     descripcion duracion
	       DescripcionVO taDescVO = new DescripcionVO();
	       LangStringVO[] aLangTADesc = new LangStringVO[descDura.length];
	       for (int i = 0; i<descDura.length;i++){
	    	   LangStringVO langTADesc= new LangStringVO();
	    	   String descDuraI=descDura[i]!=null?descDura[i]:"";
	    	   langTADesc.setTexto(descDuraI.trim());
	    	   String idiomaDuraI=idiomaDura[i]!=null?idiomaDura[i]:"";
	    	   langTADesc.setIdioma(idiomaDuraI);
	    	   aLangTADesc[i] = langTADesc;
	       }
	       taDescVO.setTextos(aLangTADesc);
	       textDura[0]=taDescVO;
	       duracionDesc[0]=taDescVO;
	     duracion.setDescripcion(duracionDesc[0]);
	     
	    }
		
	private void dameTerminoId() throws Exception{
			
		String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		//Formatos
		ArrayList idsForm = new ArrayList();
		for ( int i=0;i<formatos.length;i++){
			idsForm.add(formatos[i].getTexto().trim());
		}

	    String[] arrayIdsForm = (String[])idsForm.toArray(new String[idsForm.size()]);
	    TerminoYPadreVO[] terminosTraducForm = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsForm);
	    int jForm= 0;
	    for (int cont=0;cont<terminosTraducForm.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jForm<formatos.length){
				if (formatos[jForm].getTexto().trim().equals("")){
					jForm++; 
				}
				else{
					enc = true;
					formatos[jForm].setTexto(terminosTraducForm[cont].getNomTermino());
					jForm++;
				}
			}	
	    }
	    //Requerimientos 
	    

	    for ( int i=0;i<requisitos.length;i++ ){
	    	AgregadorORVO[] agregadoresListVO = requisitos[i].getAgregadoresOR();
	    	String[] arrayIdsNom=null;
	    	String[] arrayIdsTipo=null;
	    	for ( int j=0;j<agregadoresListVO.length;j++){
	    		ArrayList idsNom = new ArrayList();
		    	ArrayList idsTipo = new ArrayList();
	    		idsNom.add(agregadoresListVO[j].getNombre().getValor());
	    		idsTipo.add(agregadoresListVO[j].getTipo().getValor());
		        arrayIdsNom = (String[])idsNom.toArray(new String[idsNom.size()]);
		        arrayIdsTipo = (String[])idsTipo.toArray(new String[idsTipo.size()]);
		        if(arrayIdsNom!=null && !arrayIdsNom[0].equals("")){
		        	TerminoYPadreVO[] terminosTraducNom = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsNom);
		        	SourceValueVO nomb=new SourceValueVO();
    				nomb.setValor(terminosTraducNom[0].getNomTermino());
    				nomb.setSource(source);
    				agregadoresListVO[j].setNombre(nomb);
		        }
		        if(arrayIdsTipo!=null && !arrayIdsTipo[0].equals("")){
		        	TerminoYPadreVO[] terminosTraducTipo = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsTipo);
		        	SourceValueVO tip=new SourceValueVO();
    				tip.setValor(terminosTraducTipo[0].getNomTermino());
    				tip.setSource(source);
    				agregadoresListVO[j].setTipo(tip);
		        }
		        
	    	}
	        
	        requisitos[i].setAgregadoresOR(agregadoresListVO);
	    }
	    //Notas de instalacion
		ArrayList idsInstalacion = new ArrayList();
	    LangStringVO[] langInstalacion =notasDeInstalacion[0].getTextos();
	    for ( int i=0;i<langInstalacion.length;i++){
	    	idsInstalacion.add(langInstalacion[i].getIdioma());
	    }
	    
	    String[] arrayIdsInstalacion = (String[])idsInstalacion.toArray(new String[idsInstalacion.size()]);
	    TerminoYPadreVO[] terminosTraducInstalacion = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsInstalacion);
	    int jIns= 0;
	    for (int cont=0;cont<terminosTraducInstalacion.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jIns<langInstalacion.length){
				if (langInstalacion[jIns].getIdioma().equals("")){
					jIns++; 
				}
				else{
					enc = true;
					langInstalacion[jIns].setIdioma(terminosTraducInstalacion[cont].getNomTermino());
					jIns++;
				}
			}	
	    }

	    //Mas requeriminetos
	    ArrayList idsMas = new ArrayList();
	    LangStringVO[] langMas =masRequisitos[0].getTextos();
	    for ( int i=0;i<langMas.length;i++){
	    	idsMas.add(langMas[i].getIdioma());
	    }
	    
	    String[] arrayIdsMas = (String[])idsMas.toArray(new String[idsMas.size()]);
	    TerminoYPadreVO[] terminosTraducMas = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsMas);
	    int jMas= 0;
	    for (int cont=0;cont<terminosTraducMas.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jMas<langMas.length){
				if (langMas[jMas].getIdioma().equals("")){
					jMas++; 
				}
				else{
					enc = true;
					langMas[jMas].setIdioma(terminosTraducMas[cont].getNomTermino());
					jMas++;
				}
			}	
	    }
	    
	    
	    //descripcion duracion
		ArrayList idsTADesc = new ArrayList();
	    LangStringVO[] langTADesc =duracionDesc[0].getTextos();
	    
	    
	    	
	    for ( int i=0;i<langTADesc.length;i++){
	    	idsTADesc.add(langTADesc[i].getIdioma());
	    }
	    
	    String[] arrayIdsTADesc = (String[])idsTADesc.toArray(new String[idsTADesc.size()]);
	    TerminoYPadreVO[] terminosTraducTADesc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsTADesc);
	    int jTADesc= 0;
	    for (int cont=0;cont<terminosTraducTADesc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jTADesc<langTADesc.length){
				if (langTADesc[jTADesc].getIdioma().equals("")){
					jTADesc++; 
				}
				else{
					enc = true;
					langTADesc[jTADesc].setIdioma(terminosTraducTADesc[cont].getNomTermino());
					jTADesc++;
				}
			}	
	    }
	}
	
	
	private void descifrarDuration(){
		//expresion regular duracion = P[yY][mM][dD][T[hH][nM][s[.s]S]]
		String duraci=duracion.getDuracion();
		 Pattern mask=Pattern.compile("^P([0-9]+Y){0,1}([0-9]+M){0,1}([0-9]+D){0,1}(T([0-9]+H){0,1}([0-9]+M){0,1}([0-9]+(.[0-9]+){0,1}S){0,1}){0,1}$"); //ejm ee-zz
		 Matcher matcher = mask.matcher(duraci);
		 boolean correcto = matcher.matches();
		 
		if(duraci != null && !duraci.equals("") && correcto && !duraci.equals("P") && !duraci.equals("PT")){
			//duracionAux = [yY][mM][dD][T[hH][nM][s[.s]S]]
			String duracionAux= duraci.substring(1, duraci.length());
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




	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}




	public void cargarTechnicalValidar(ActionMapping mapping, CargarTechnicalValidarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

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
			UtilidadesOrdenarCombos vocabulariosOrdDest2 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest2.ordenarVocabulariosVO(vocabulario);			

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
					UtilidadesOrdenarCombos terminosOrdDest5 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrd = terminosOrdDest5.ordenarTerminosVO(terminos, idiomaLdap);						
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
					UtilidadesOrdenarCombos terminosOrdDest6 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdTipo = terminosOrdDest6.ordenarTerminosVO(terminosTipo, idiomaLdap);						
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
					UtilidadesOrdenarCombos terminosOrdDest7 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdNombre = terminosOrdDest7.ordenarTerminosVO(terminosNombre, idiomaLdap);						
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
					UtilidadesOrdenarCombos terminosOrdDest8 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = terminosOrdDest8.ordenarTerminosVO(terminosDest, idiomaLdap);						
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
			logger.debug("Cargados los combos");

				
				TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);

				TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
				//Dividimos los formatos de los tipos y nombres
				ArrayList arrayFormato=new ArrayList();
				ArrayList arrays=new ArrayList();
				for(int k=0;k<terminoYPadreVuelta.length;k++){
					String idPadre=terminoYPadreVuelta[k].getIdVocabulario();
					if(arrayFormato.size()==0){
						arrayFormato.add(terminoYPadreVuelta[k]);
					}else{
						if(idPadre.equals(((TerminoYPadreVO)arrayFormato.get(0)).getIdVocabulario())){
							arrayFormato.add(terminoYPadreVuelta[k]);
						}else {
							
							arrays.add(terminoYPadreVuelta[k]);
						}
					}
				}
				TerminoYPadreVO[] formatosTP=(TerminoYPadreVO[])arrayFormato.toArray(new TerminoYPadreVO[arrayFormato.size()]);
				TerminoYPadreVO[] tipoYNombre=(TerminoYPadreVO[])arrays.toArray(new TerminoYPadreVO[arrays.size()]);
				
				//FORMATOS
				FormatoVO[] aNuevoFormatosVO =null;
				FormatoVO[] aFormatosVO =catalogadorAvSession.getMDSesion().getTechnical().getFormatos();
				if (aFormatosVO != null && !(aFormatosVO.length==1 && aFormatosVO[0].getTexto().equals(""))){
					aNuevoFormatosVO = new FormatoVO[catalogadorAvSession.getMDSesion().getTechnical().getFormatos().length];
					for (int idi = 0; idi<formatosTP.length; idi++) {
						FormatoVO formato = new FormatoVO();
						formato.setTexto(formatosTP[idi].getIdTermino());
						aNuevoFormatosVO[idi]=formato;
		            }
				}
				else{
					aNuevoFormatosVO = new FormatoVO[1];
					FormatoVO formato = new FormatoVO();
					formato.setTexto("");
					aNuevoFormatosVO[0]=formato;
				}

	            form.setFormatosBackingList(id, "idTermino", "nomTermino");
	            
	            logger.debug("cargarTechnicalValidar");
	            
	            AvTechnicalVO tec= this.getCatalogadorAvSession(request).getLomValidacion().getTechnical();
	        	form.setFormatosAsArray(tec.getFormatos());
	        	form.setTamanio(tec.getTamanio().getTexto());
	        	form.setLocalizacionAsArray(tec.getLocalizaciones());
	        	form.setRequerimientoAsArray(tec.getRequisitos());
	        	PautasInstalacionVO[] pautas=new PautasInstalacionVO[1];
	        	pautas[0]=tec.getPautasInstalacion();
	        	form.setDescripcionInstalacionAsArray(pautas);
	        	OtrosRequisitosVO[] otros=new OtrosRequisitosVO[1];
	        	otros[0]=tec.getOtrosRequisitos();
	        	form.setDescripcionRequerimientosAsArray(otros);
	        	
	        	form.setDescripcionDuracionAsArray(duracionDesc);
	
	        	form.setAnyo(anyos);
	        	form.setMes(meses);
	        	form.setDia(dias);
	        	form.setHora(horas);
	        	form.setMinutos(minutos);
	        	form.setSegundosP1(segundosP1);
	        	form.setSegundosP2(segundosP2);
	        	
//		          si tecnica era null en el objeto de session lo dejamos a null
	            if(tecnicaEsNull)
	            	catalogadorAvSession.getMDSesion().setTechnical(null);
	            
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tecnica", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Tecnica, metodo cargarTechnicalValidar " + e);
			throw new java.lang.Exception("tecnica", e);
		
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
	        
	    	if (valor instanceof TecnicaFormImpl) {
	    		TecnicaFormImpl formulario=(TecnicaFormImpl) valor;
	          	form.setFormatosLabelList(formulario.getFormatosLabelList());
	          	form.setFormatosValueList(formulario.getFormatosValueList());
	          	form.setComboTipoLabelList(formulario.getComboTipoLabelList());
	          	form.setComboTipoValueList(formulario.getComboTipoValueList());
	          	form.setComboNombreLabelList(formulario.getComboNombreLabelList());
	          	form.setComboNombreValueList(formulario.getComboNombreValueList());
	          	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setDescripcionDuracion(formulario.getDescripcionDuracion());
			}
	    	else if(valor instanceof TecnicaFormAccionSubmitFormImpl){
	    		TecnicaFormAccionSubmitFormImpl formulario=(TecnicaFormAccionSubmitFormImpl) valor;
	          	form.setFormatosLabelList(formulario.getFormatosLabelList());
	          	form.setFormatosValueList(formulario.getFormatosValueList());
	          	form.setComboTipoLabelList(formulario.getComboTipoLabelList());
	          	form.setComboTipoValueList(formulario.getComboTipoValueList());
	          	form.setComboNombreLabelList(formulario.getComboNombreLabelList());
	          	form.setComboNombreValueList(formulario.getComboNombreValueList());
	          	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setDescripcionDuracion(formulario.getDescripcionDuracion());
	      	}
	    	else if(valor instanceof TecnicaValidaVolverFormImpl){
	    		TecnicaValidaVolverFormImpl formulario=(TecnicaValidaVolverFormImpl) valor;
	          	form.setFormatosLabelList(formulario.getFormatosLabelList());
	          	form.setFormatosValueList(formulario.getFormatosValueList());
	          	form.setComboTipoLabelList(formulario.getComboTipoLabelList());
	          	form.setComboTipoValueList(formulario.getComboTipoValueList());
	          	form.setComboNombreLabelList(formulario.getComboNombreLabelList());
	          	form.setComboNombreValueList(formulario.getComboNombreValueList());
	          	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setDescripcionDuracion(formulario.getDescripcionDuracion());
	    	}else if(valor instanceof TecnicaNoValidaVolverFormImpl){
	    		TecnicaNoValidaVolverFormImpl formulario=(TecnicaNoValidaVolverFormImpl) valor;
	          	form.setFormatosLabelList(formulario.getFormatosLabelList());
	          	form.setFormatosValueList(formulario.getFormatosValueList());
	          	form.setComboTipoLabelList(formulario.getComboTipoLabelList());
	          	form.setComboTipoValueList(formulario.getComboTipoValueList());
	          	form.setComboNombreLabelList(formulario.getComboNombreLabelList());
	          	form.setComboNombreValueList(formulario.getComboNombreValueList());
	          	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	form.setDescripcionDuracion(formulario.getDescripcionDuracion());
	    	}
	
	    	//FORMATO
	    	
	    	//TAMANIO
	    	form.setTamanio("");
	    	
	    	//LOCALIZACION
			LocalizacionVO[] aNuevoLocalizacionVO=new LocalizacionVO[1];
			LocalizacionVO nuevoLocalizacion=new LocalizacionVO();
			nuevoLocalizacion.setTexto("");
			aNuevoLocalizacionVO[0]=nuevoLocalizacion;
			form.setLocalizacionAsArray(aNuevoLocalizacionVO);
		
	    	//INSTALACION
			
			LangStringVO[] nuevolangTextosNota = new LangStringVO[1];
			LangStringVO lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosNota[0] = lang;
			PautasInstalacionVO[] aNotaVO = new PautasInstalacionVO[1];
			PautasInstalacionVO notaVO= new PautasInstalacionVO();
			notaVO.setTextos(nuevolangTextosNota);
			aNotaVO[0]=notaVO;
			form.setDescripcionInstalacionAsArray(aNotaVO);    	
			
			
	    	//REQUISITOS
			
			RequisitoVO[] nuevoRequisitoVO = new RequisitoVO[1];
			RequisitoVO requisi=new RequisitoVO();
			AgregadorORVO[] aAgregadores =new AgregadorORVO[1];
			AgregadorORVO agrega=new AgregadorORVO();
			SourceValueVO nombre=new SourceValueVO();
			nombre.setValor("");
			nombre.setSource("LOM-ESv1.0");
			SourceValueVO tipo=new SourceValueVO();
			tipo.setValor("");
			tipo.setSource("LOM-ESv1.0");
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
			nuevoRequisitoVO[0]=requisi;
			
			form.setRequerimientoAsArray(nuevoRequisitoVO);
			
	        //MAS REQUERIMIENTOS
			LangStringVO[] nuevolangTextosOtro = new LangStringVO[1];
			lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosOtro[0] = lang;
	
			OtrosRequisitosVO[] aOtroVO = new OtrosRequisitosVO[1];
			OtrosRequisitosVO otroVO= new OtrosRequisitosVO();
			otroVO.setTextos(nuevolangTextosOtro);
			aOtroVO[0]=otroVO;
		    form.setDescripcionRequerimientosAsArray(aOtroVO);
	
	
	    	//DURACION
			form.setAnyo("");
			form.setMes("");
			form.setDia("");
			form.setHora("");
			form.setMinutos("");
			form.setSegundosP1("");
			form.setSegundosP2("");
	
	        //TAMAÑO
	
			
			LangStringVO[] nuevolangTextosDescripTA = new LangStringVO[1];
			lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosDescripTA[0] = lang;
			DescripcionVO[] aDescripcionesTA_VO = new DescripcionVO[1];
			DescripcionVO descripcionTA_VO= new DescripcionVO();
			descripcionTA_VO.setTextos(nuevolangTextosDescripTA);
			aDescripcionesTA_VO[0]=descripcionTA_VO;
		    form.setDescripcionDuracionAsArray(aDescripcionesTA_VO); 
	
		    //FORMATOS
			FormatoVO[] aNuevoFormatosVO = new FormatoVO[1];
			FormatoVO formato = new FormatoVO();
			formato.setTexto("");
			aNuevoFormatosVO[0]=formato;
			form.setFormatosAsArray(aNuevoFormatosVO);
	    
	    }catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tecnica", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Tecnica, metodo reset " + e);
			throw new java.lang.Exception("tecnica", e);
		
		}
    	
	}


}