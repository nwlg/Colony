/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida;

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
import es.pode.catalogacion.negocio.servicios.AvLifeCycleVO;
import es.pode.catalogacion.negocio.servicios.ContribucionVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.EntidadVO;
import es.pode.catalogacion.negocio.servicios.FechaVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.VersionVO;
import es.pode.catalogacion.soporte.Contribucion;
import es.pode.catalogacion.soporte.Entidad;
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
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController
 */
public class CiclodevidaControllerImpl extends CiclodevidaController
{ 
	protected static Logger logger = Logger.getLogger(CiclodevidaControllerImpl.class); 
	
	private DescripcionVO[] descripciones;//cada posicion del array es la descripcion que lleva la fecha de una contribucion
	private VersionVO[] versiones;
	private Contribucion[] contribuciones;
	private String estatus;




    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#cargarDatosCvida(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CargarDatosCvidaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDatosCvida(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CargarDatosCvidaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	InputStream is = null;
    	Properties prop = new Properties();
//		boolean bandera=false;
		
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
				
				
			}//fin for carga combos
			if( logger.isDebugEnabled() ){
                logger.debug("Cargados los combos del formulario" );
			}

			
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
					if( contribuciones[i].getFecha()!=null && 
						contribuciones[i].getFecha().getDescripcion() !=null && 
						contribuciones[i].getFecha().getDescripcion().getTextos()!= null && 
						contribuciones[i].getFecha().getDescripcion().getTextos().length>0)
					{
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
					auxFecha.setIdioma(idiomaLdap);
					
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
				auxFecha.setIdioma(idiomaLdap);
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
			logger.error("Error Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (Exception e) {
			logger
			.error("Error en catalogadorWeb, metodo cargarCicloVida " + e);
			throw new java.lang.Exception("ciclo.de.vida", e);
		
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#accionSubmit(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AccionSubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String accionSubmit(
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
		 	if (accionPartes.length == 3)
		 		request.setAttribute("posicionExterior", accionPartes[2]);
		 }
         String resAction = "";
         //String idioma=((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage();

 		 ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		 if (datosResources.getString("ciclo.Validar").equals(accion)) {
        	   resAction = "Validar";
         } else if (datosResources.getString("ciclo.Aceptar").equals(accion)) {
        	   resAction = "Aceptar";
         } else if (datosResources.getString("ciclo.Cancelar").equals(accion)) {
        	   resAction = "Cancelar";
         } else if (datosResources.getString("ciclo.Reset").equals(accion)) {
        	   resAction = "Reset";
         }
         else
        	 resAction= accion;
         
         return resAction;
    }




    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#anadirVersion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirVersionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirVersion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirVersionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
		try{
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
			else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
	  	
	//		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
		  	VersionVO[] aVersiones=(VersionVO[])form.getVersionesAsArray();
		  	LangStringVO[] lLang=aVersiones[0].getTextos();
	       
		  	int nuevoTamano = lLang.length +1;
		  	LangStringVO[] newALang = new LangStringVO[nuevoTamano];
		  	LangStringVO nuevaVersion=new LangStringVO();
		   
		  	nuevaVersion.setIdioma("");
		  	nuevaVersion.setTexto("");
		   
	
		  	for(int i = 0; i<lLang.length;i++)
		  		newALang[i]=lLang[i];
		  	newALang[nuevoTamano-1]= nuevaVersion;
		  	aVersiones[0].setTextos(newALang);
		  	form.setVersionesAsArray(aVersiones);
		  	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}
		catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo anadirVersion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método anadirVersion " + e);
			throw new Exception("ciclo.de.vida",e);
		}
		  	
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#eliminarVersion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarVersionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarVersion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarVersionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
		try{
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
	  	
	//		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
		  	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
		  	//posicion del identificador que se quiere eliminar   
	        String posicion = request.getAttribute("posicion").toString();
	        int posicionInt = Integer.parseInt(posicion);
	        VersionVO[] aVersiones=(VersionVO[])form.getVersionesAsArray();
	        LangStringVO[] aLang=aVersiones[0].getTextos();
	        LangStringVO[] nuevoLang=new LangStringVO[aLang.length-1];
		   
	     	//añado al nuevo array de identificadores todos los identificadores menos el que 
	     	//queremos eliminar
	     	for (int i = 0; i<nuevoLang.length;i++){
	     		if (i < posicionInt)
	     			nuevoLang[i] = aLang[i];
	     		else
	     			nuevoLang[i] = aLang[i+1]; 
	     	}
	     	aVersiones[0].setTextos(nuevoLang);
	     	form.setVersionesAsArray(aVersiones);
	     	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo eliminarVersion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método eliminarVersion " + e);
			throw new Exception("ciclo.de.vida",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#anadirContribucion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirContribucionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirContribucion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirContribucionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
		try{  
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
	  	
	//		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
		  	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
		  	
		  	
		  	Contribucion[] aContribuciones=(Contribucion[])form.getContribucionesAsArray();
	
		  	int nuevoTamano = aContribuciones.length +1;
		  	Contribucion[] newContribuciones= new Contribucion[nuevoTamano];
	
		  	for(int i = 0; i<aContribuciones.length;i++)
		  		newContribuciones[i]=aContribuciones[i];
		  	Contribucion contribucion = new Contribucion();
		  	//tipo
		  	SourceValueVO tipo = new SourceValueVO();
		  	tipo.setSource("");
		  	tipo.setValor("");
		  	//fecha
		  	Fecha fecha = new Fecha();
		  	//entidades
		  	Entidad[] entidades =new Entidad[1];
		  	Entidad entidad = new Entidad();
		  	entidad.setCorreo("");
		  	entidad.setNombre("");
		  	entidad.setOrganizacion("");
		  	entidades[0]=entidad;
		  	contribucion.setRol(tipo);
		  	contribucion.setFecha(fecha);
		  	contribucion.setEntidades(entidades);
		  	newContribuciones[aContribuciones.length]=contribucion;
		  	form.setContribucionesAsArray(newContribuciones);
		  	
	    	//se añade la descripcion de la fecha
		  	
	    	DescripcionVO[] descArray = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	DescripcionVO[] newDescArray = new DescripcionVO[descArray.length+1];
	    	for(int i = 0 ; i < descArray.length;i++){
	    		newDescArray[i]= descArray[i];
	    	}
	    	DescripcionVO newDesc= new DescripcionVO();
	    	LangStringVO nuevoTexto = new LangStringVO();
	    	LangStringVO[] nuevoTextos = new LangStringVO[1];
	    	nuevoTexto.setIdioma("");
	    	nuevoTexto.setTexto("");
	    	nuevoTextos[0]=nuevoTexto;
	    	newDesc.setTextos(nuevoTextos);
	    	newDescArray[aContribuciones.length]=newDesc;
	    	form.setDescripcionesAsArray(newDescArray);
	    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo anadirContribucion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método anadirContribucion " + e);
			throw new Exception("ciclo.de.vida",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#eliminarContribucion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarContribucionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarContribucion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarContribucionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
	    try{
    		if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
	  	
	//		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
		  	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
		  	
		  	//posicion de la contribucion que se quiere eliminar   
	        String posicion = request.getAttribute("posicion").toString();
	        int posicionInt = Integer.parseInt(posicion);
	        Contribucion[] aContribuciones=(Contribucion[])form.getContribucionesAsArray();
	        Contribucion[] nuevoContribuciones=new Contribucion[aContribuciones.length-1];
		   
	     	//añado al nuevo array de contribuciones todas las contribuciones menos el que 
	     	//queremos eliminar
	     	for (int i = 0; i<nuevoContribuciones.length;i++){
	     		if (i < posicionInt)
	     			nuevoContribuciones[i] = aContribuciones[i];
	     		else
	     			nuevoContribuciones[i] = aContribuciones[i+1]; 
	     	}
	     	form.setContribucionesAsArray(nuevoContribuciones);
	     	
	     	
	    	//eliminamos la descripcion correspondiente a la fecha
	    	DescripcionVO[] aDescripciones = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	DescripcionVO[] newDescripciones = new DescripcionVO[aDescripciones.length-1];
	
	    	for (int i = 0; i<newDescripciones.length;i++){
	    		if (i < posicionInt)
	    			newDescripciones[i] = aDescripciones[i];
	    		else
	    			newDescripciones[i] = aDescripciones[i+1]; 
	    	}
	    	form.setDescripcionesAsArray(newDescripciones);
	    
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo eliminarContribucion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método eliminarContribucion " + e);
			throw new Exception("ciclo.de.vida",e);
		}
	 }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#anadirIdentidad(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirIdentidadForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirIdentidad(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirIdentidadForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
    	try{
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
			
		//	hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
		  	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
			String posicion = request.getAttribute("posicion").toString();
			int posicionInt = Integer.parseInt(posicion);//indica la contribucion donde se añade la entidad
	    	//se recogen todas las descripciones
			Contribucion[] contribArray = (Contribucion[]) form.getContribucionesAsArray();
	    	//recogo los textos de la descripcion indicada y le añado un nuevo texto
	    	Entidad[] entidades = contribArray[posicionInt].getEntidades();
	    	Entidad[] nuevoEntidades = new Entidad[entidades.length+1];
	    	for(int i = 0 ; i < entidades.length;i++){
	    		nuevoEntidades[i]= entidades[i];
	    	}
	    	Entidad nuevaEntidad = new Entidad();
	    	nuevaEntidad.setCorreo("");
	    	nuevaEntidad.setNombre("");
	    	nuevaEntidad.setOrganizacion("");
	    	nuevoEntidades[nuevoEntidades.length-1] = nuevaEntidad;
	    	contribArray[posicionInt].setEntidades(nuevoEntidades);
	    	form.setContribucionesAsArray(contribArray);
	    
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo anadirIdentidad" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método anadirIdentidad " + e);
			throw new Exception("ciclo.de.vida",e);
		}
 
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#eliminarIdentidad(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarIdentidadForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarIdentidad(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarIdentidadForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
		try{  
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
	  	
	//		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
		  	
	        //posicion de contenido a eliminar   
	        String posicion = request.getAttribute("posicion").toString();
	        int posicionInt = Integer.parseInt(posicion);
			
			//posicion de la contribucion de la que se quiere eliminar una entidad
	        String posicionContrib = request.getAttribute("posicionExterior").toString();
	        int posicionContribInt = Integer.parseInt(posicionContrib);
	    	
	    	Contribucion[] aContribuciones = (Contribucion[]) form.getContribucionesAsArray();
	    	Entidad[] entidades = contribuciones[posicionContribInt].getEntidades();
	    	Entidad[] nuevoEntidades = new Entidad[entidades.length -1];
	    	//añado al nuevo array de entidades todos los entidades menos la que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoEntidades.length;i++){
	    		if (i < posicionInt)
	    			nuevoEntidades[i] = entidades[i];
	    		else
	    			nuevoEntidades[i] = entidades[i+1]; 
	    	}
	    	aContribuciones[posicionContribInt].setEntidades(nuevoEntidades);
	    	form.setContribucionesAsArray(aContribuciones);
	  	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo eliminarIdentidad" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método eliminarIdentidad " + e);
			throw new Exception("ciclo.de.vida",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#anadirDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.AnadirDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Object valor = request.getSession().getAttribute("form");
		try{	  
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
	  	
	//		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
		  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
		  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
		  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
			
		  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			
		  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
			for(int i= 0;i< form.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
			}
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
		  	
		  	//versiones
		  	form.setVersionesAsArray(versiones); 
		  	//descripciones de la fecha
		  	form.setDescripcionesAsArray(descripciones);
		  	//contribuciones
		  	form.setContribucionesAsArray(contribuciones);
		  	
			String posicion = request.getAttribute("posicion").toString();
			int posicionInt = Integer.parseInt(posicion);//indica la contribucion donde se añade la descripcion
	    	//se recogen todas las descripciones
	    	DescripcionVO[] descArray = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	//recogo los textos de la descripcion indicada y le añado un nuevo texto
	    	LangStringVO[] textos = descArray[posicionInt].getTextos();
	    	LangStringVO[] nuevoTextos = new LangStringVO[textos.length+1];
	    	for(int i = 0 ; i < textos.length;i++){
	    		nuevoTextos[i]= textos[i];
	    	}
	    	LangStringVO nuevoTexto = new LangStringVO();
	    	nuevoTexto.setIdioma("");
	    	nuevoTexto.setTexto("");
	    	nuevoTextos[nuevoTextos.length-1] = nuevoTexto;
	    	descArray[posicionInt].setTextos(nuevoTextos);
	    	form.setDescripcionesAsArray(descArray);
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo anadirDescripcion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método anadirDescripcion " + e);
			throw new Exception("ciclo.de.vida",e);
		}
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#eliminarDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EliminarDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
        	if (valor instanceof CicloDeVidaFormImpl) {
    	      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
    	      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
    	      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
    	      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
    	      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
    	      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
    	      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
    	      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
    		}
        	else if(valor instanceof CicloFormAccionSubmitFormImpl){
    	      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
    	      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
    	      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
    	      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
    	      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
    	      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
    	      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
    	      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
    	  	}else if(valor instanceof CicloValidoVolverFormImpl){
    	      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
    	      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
    	      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
    	      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
    	      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
    	      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
    	      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
    	      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
    	  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
    	      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
    	      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
    	      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
    	      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
    	      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
    	      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
    	      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
    	      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
    	  	}
        	
//    		hay tantas descripciones como contribuciones pues en una contribucion solo a un campo fecha con descripcionVO correspondiente
    	  	int longitudDescripciones=((DescripcionVO[])(form.getDescripcionesAsArray())).length;
    	  	int longitudVersiones =((VersionVO)(form.getVersionesAsArray()[0])).getTextos().length;
    	  	int longitudContribuciones=((Contribucion[])(form.getContribucionesAsArray())).length;
    		
    	  	int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		
    	  	int[] longitudEntidadesContrib = new int[form.getContribuciones().size()];
    		for(int i= 0;i< form.getContribuciones().size();i++){
    			longitudEntidadesContrib[i]=((Contribucion)(form.getContribucionesAsArray()[i])).getEntidades().length;
    		}
    		
    	  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
    	  			,longitudTextosDesc,longitudEntidadesContrib);
    	  	
    	  	//versiones
    	  	form.setVersionesAsArray(versiones); 
    	  	//descripciones de la fecha
    	  	form.setDescripcionesAsArray(descripciones);
    	  	//contribuciones
    	  	form.setContribucionesAsArray(contribuciones);	
    	  	
	        //posicion de contenido a eliminar   
	        String posicion = request.getAttribute("posicion").toString();
	        int posicionInt = Integer.parseInt(posicion);
			
			//posicion de la contribucion de la que se quiere eliminar una descripcion
	        String posicionContrib = request.getAttribute("posicionExterior").toString();
	        int posicionContribtInt = Integer.parseInt(posicionContrib);
	    	
	    	DescripcionVO[] aDescripciones = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	LangStringVO[] contenido = descripciones[posicionContribtInt].getTextos();
	    	LangStringVO[] nuevoContenido = new LangStringVO[contenido.length -1];
	    	//añado al nuevo array de contenidos todos los contenidos menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoContenido.length;i++){
	    		if (i < posicionInt)
	    			nuevoContenido[i] = contenido[i];
	    		else
	    			nuevoContenido[i] = contenido[i+1]; 
	    	}
	    	aDescripciones[posicionContribtInt].setTextos(nuevoContenido);
	    	form.setDescripcionesAsArray(aDescripciones);

		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría Ciclo de vida, metodo eliminarDescripcion" + ai);
		}catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría Ciclo de vida, método eliminarDescripcion " + e);
			throw new Exception("ciclo.de.vida",e);
		}
     }











    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#esValidoCicloVida(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EsValidoCicloVidaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean esValidoCicloVida(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.EsValidoCicloVidaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String resultado= "";
		boolean ok= true;
		InputStream is = null;
		Properties prop = new Properties();
		is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
		prop.load(is);
		String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		
		
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		Collection mensajes = new ArrayList();
		
		CatalogadorAvSession os = this.getCatalogadorAvSession(request);
	
		AvLifeCycleVO life = new AvLifeCycleVO();
		
		Object valor = request.getSession().getAttribute("form");
		
		
		int longitudDescripciones=0;
    	int longitudVersiones=0;
    	int longitudContribuciones=0;
    	int[] longitudTextosDesc = new int[0];
    	int[] longitudEntidadesContrib = new int[0];
    	if (valor instanceof CicloDeVidaFormImpl) {		  	
		  	CicloDeVidaFormImpl valorGen = ((CicloDeVidaFormImpl)valor);
    		Object[] desc = valorGen.getDescripcionesAsArray();
			longitudTextosDesc = new int[desc.length];
			for(int i= 0;i< desc.length;i++){
				longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
			}
    		
		  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
			for(int i= 0;i< valorGen.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
			}
			longitudContribuciones=valorGen.getContribuciones().size();
			longitudDescripciones=desc.length;
		  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length;
		  	
    	}
    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
    		CicloFormAccionSubmitFormImpl valorGen = ((CicloFormAccionSubmitFormImpl)valor);
    		Object[] desc = valorGen.getDescripcionesAsArray();
			longitudTextosDesc = new int[desc.length];
			for(int i= 0;i< desc.length;i++){
				longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
			}
    		
		  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
			for(int i= 0;i< valorGen.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
			}
			longitudContribuciones=valorGen.getContribuciones().size();
			longitudDescripciones=desc.length;
		  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length; 
    	}else if(valor instanceof CicloNoValidoVolverFormImpl){
    		CicloNoValidoVolverFormImpl valorGen = ((CicloNoValidoVolverFormImpl)valor);
    		Object[] desc = valorGen.getDescripcionesAsArray();
			longitudTextosDesc = new int[desc.length];
			for(int i= 0;i< desc.length;i++){
				longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
			}
    		
		  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
			for(int i= 0;i< valorGen.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
			}
			longitudContribuciones=valorGen.getContribuciones().size();
			longitudDescripciones=desc.length;
		  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length; 
    	}else if(valor instanceof CicloValidoVolverFormImpl){
    		CicloValidoVolverFormImpl valorGen = ((CicloValidoVolverFormImpl)valor);
    		Object[] desc = valorGen.getDescripcionesAsArray();
			longitudTextosDesc = new int[desc.length];
			for(int i= 0;i< desc.length;i++){
				longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
			}
    		
		  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
			for(int i= 0;i< valorGen.getContribuciones().size();i++){
				longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
			}
			longitudContribuciones=valorGen.getContribuciones().size();
			longitudDescripciones=desc.length;
		  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length; 
    	}
    	
    	//Recogemos los cambio del request mediante parametros
		
	  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
	  			,longitudTextosDesc,longitudEntidadesContrib);
	  	
	  	VersionVO version=new VersionVO();
	  	version=versiones[0];
	  	life.setVersion(version);
	  	
	  	SourceValueVO sv=new SourceValueVO();
		sv.setValor(form.getEstatus());
		life.setEstado(sv);
		
//		CONTRIBUCIONES
		ContribucionVO[] contribucionesVO = null;
		if (contribuciones!= null && contribuciones.length != 0){
			contribucionesVO = new ContribucionVO[contribuciones.length];
			ArrayList listaContribuciones=new ArrayList();
			for(int k=0;k<contribuciones.length;k++){
				ContribucionVO contribucionVO = new ContribucionVO();
				//FECHA
				FechaVO fechaVO = new FechaVO();
				//Descripciones
				/**********************************************/
				if(descripciones!=null && descripciones.length != 0){
					if(descripciones[k]!=null){
						ArrayList listDesc=new ArrayList();
						DescripcionVO lDesc=(DescripcionVO)(descripciones[k]);
						DescripcionVO lDescripciones=new DescripcionVO();
						for(int j=0;j<lDesc.getTextos().length;j++){
							LangStringVO lang=lDesc.getTextos()[j];
							LangStringVO lLang=new LangStringVO();
							String idioma=lang.getIdioma();
							String texto=lang.getTexto();
							//((idioma!=null)&&(!idioma.trim().equals(""))) &&
							if( ((texto!=null)&&(!texto.trim().equals("")))){
								lLang.setIdioma(idioma.trim());
								lLang.setTexto(texto.trim());
								listDesc.add(lLang);
							}
							
						}
						
						if (listDesc.size() != 0){
							LangStringVO[] langs=(LangStringVO[])listDesc.toArray(new LangStringVO[listDesc.size()]); 
							lDescripciones.setTextos(langs); 
							fechaVO.setDescripcion(lDescripciones);
						}else{//meter una vacia???	
							fechaVO.setDescripcion(null);
						}
					}
					
				}
				/**********************************************/
					//fecha
				/**********************************************/
				// es obl al menos yyyy-MM-dd

				if(contribuciones[k].getFecha()!=null && contribuciones[k].getFecha().getFechaCorta()!=null)
				{
					//existe una fecha.. pero es erronea.. añado la fecha al vo para que no sea null el VO y 
					//no muestre el error que falta fecha..
					fechaVO.setFecha(contribuciones[k].getFecha().getFechaCorta());
				}else
				{
					fechaVO.setFecha(contribuciones[k].getFecha().getFechaLomes());
				}
				
				
				if(fechaVO.getDescripcion()==null && (fechaVO.getFecha()==null || fechaVO.getFecha().equals("") ))
					fechaVO=null;
				
				contribucionVO.setFecha(fechaVO);
					
				/**********************************************/
				//rol	
				/**********************************************/
				SourceValueVO rolVO=new SourceValueVO();
				String rol = contribuciones[k].getRol().getValor();
				if((rol!=null)&&(!rol.equals(""))){
					rolVO.setSource(source);
					rolVO.setValor(rol);
				}
				else{
					rolVO = null;
				}
				contribucionVO.setTipo(rolVO);
				/**********************************************/
				//entidad
				/**********************************************/
				EntidadVO[] entidadesVO = null;
				Entidad[] entidades = contribuciones[k].getEntidades();
				ArrayList listaEntidades= new ArrayList();
				for (int i=0;i<entidades.length;i++){
					Entidad entidad = entidades[i];
					EntidadVO entidadVO = new EntidadVO();
					String textoEnt="";
					if (!entidad.getOrganizacion().trim().equals("") || !entidad.getCorreo().trim().equals("") || !entidad.getNombre().trim().equals("")){
					textoEnt = new StringBuffer("BEGIN:VCARD VERSION:3.0 FN:").append(entidad.getNombre())
									  .append(" EMAIL;TYPE=INTERNET:").append(entidad.getCorreo())
									  .append(" ORG:").append(entidad.getOrganizacion()).append(" END:VCARD").toString();
						entidadVO.setTexto(textoEnt);
						listaEntidades.add(entidadVO);
					}
					
				}
				if (listaEntidades.size() == 0)
					entidadesVO = null;
				else
					entidadesVO=(EntidadVO[])listaEntidades.toArray(new EntidadVO[listaEntidades.size()]);
				contribucionVO.setEntidades(entidadesVO);
				/**********************************************/
				
				//añado contribucionVO si tiene algo
				if (contribucionVO.getEntidades() != null || contribucionVO.getFecha() != null || contribucionVO.getTipo() != null)
					listaContribuciones.add(contribucionVO);
				//contribucionesVO[k]=contribucionVO;
			}
			if (listaContribuciones.size() == 0)
				contribucionesVO = null;
			else
				contribucionesVO=(ContribucionVO[])listaContribuciones.toArray(new ContribucionVO[listaContribuciones.size()]);
		}
		else{
			contribucionesVO =null;
		}
		life.setContribuciones(contribucionesVO);
		
		
		os.setLomValidacion(new LomAvanzadoVO());
		os.getLomValidacion().setLifeCycle(life);
		
		this.setCatalogadorAvSession(request, os);

		boolean enc=false;
		boolean encDesc=false;
		boolean encTipo=false;
		SourceValueVO tipo=new SourceValueVO();
		String fech="";
		
		if(contribucionesVO!=null){
			for(int i=0;i<contribucionesVO.length;i++){
				tipo=contribucionesVO[i].getTipo();
				if(tipo ==null)
					encTipo=true;
				if(contribucionesVO[i].getEntidades()!=null && contribucionesVO[i].getEntidades().length>0){
					int j=0;
					while(!enc &&  j<contribucionesVO[i].getEntidades().length){
						if(contribucionesVO[i].getEntidades()[j].getTexto()==null)
							j++;
						else
							enc=true;
					}
				}
				if(contribucionesVO[i].getFecha()!=null){
					fech=contribucionesVO[i].getFecha().getFecha();
					int k=0;
					if(contribucionesVO[i].getFecha().getDescripcion()!=null){
						while(!encDesc && k<contribucionesVO[i].getFecha().getDescripcion().getTextos().length){
							if(contribucionesVO[i].getFecha().getDescripcion().getTextos()[k].getTexto().equals(""))
								k++;
							else
								encDesc=true;
						}
					}
				}
				
				if(encTipo&&(enc||encDesc||fech!=null) && !mensajes.contains(datosResources.getString("CAV.2.3.1"))){
					mensajes.add(datosResources.getString("CAV.2.3.1"));
				}
				if(!enc &&(!encTipo||encDesc||fech!=null) && !mensajes.contains(datosResources.getString("CAV.2.3.2"))){
					mensajes.add(datosResources.getString("CAV.2.3.2"));
				}
				if((fech==null || fech.trim().equals("")) && !encDesc &&(!encTipo||enc) && !mensajes.contains(datosResources.getString("CAV.2.3.3"))){
					mensajes.add(datosResources.getString("CAV.2.3.3"));
				}
				enc=false;
				encDesc=false;
				encTipo=false;
				
			}
			
		}
		
		
		//FECHA--DESCRIPCION
		boolean fechDesc=true;
		if(contribucionesVO!=null){
			for(int i=0;i<contribucionesVO.length && fechDesc;i++){
				String fecha="";
				String idiom="";
				String text="";
				if(contribucionesVO[i].getFecha()!=null){
					fecha=contribucionesVO[i].getFecha().getFecha();
					DescripcionVO descVO=contribucionesVO[i].getFecha().getDescripcion();
					if(descVO!=null){
						if(descVO.getTextos()!=null &&descVO.getTextos().length>0 &&fechDesc){
							for(int j=0;j<descVO.getTextos().length &&fechDesc;j++){
								idiom=descVO.getTextos()[j].getIdioma();
								text=descVO.getTextos()[j].getTexto();
							
								if((fecha==null||fecha.equals(""))&&(!idiom.equals("")||!text.equals(""))){
									mensajes.add(datosResources.getString("CAV.2.3.3.1"));
									fechDesc= false;
								}
							}
						}
					}
				}
			}	
					
		}
//		DESCRIPCION-FECHA
		fechDesc=true;
		if(contribucionesVO!=null){
			for(int i=0;i<contribucionesVO.length && fechDesc;i++){
				String fecha="";
				String idiom="";
				String text="";
				if(contribucionesVO[i].getFecha()!=null){
					fecha=contribucionesVO[i].getFecha().getFecha();
					DescripcionVO descVO=contribucionesVO[i].getFecha().getDescripcion();
					if(descVO!=null){
						if(descVO.getTextos()!=null &&descVO.getTextos().length>0 &&fechDesc){
							for(int j=0;j<descVO.getTextos().length&&fechDesc;j++){
								idiom=descVO.getTextos()[j].getIdioma();
								text=descVO.getTextos()[j].getTexto();
								if(fechDesc&& fecha!=null &&((text.equals("")))){
									if(fechDesc&& !fecha.equals("")&&((text.equals("")))){
										mensajes.add(datosResources.getString("CAV.2.3.3.2"));
										fechDesc= false;
									}
								}
							}
						}
					}else{
						mensajes.add(datosResources.getString("CAV.2.3.3.2"));
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#guardarCicloVida(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.GuardarCicloVidaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarCicloVida(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.GuardarCicloVidaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

    	boolean errorFaltaIdioma = false;
		boolean errorFaltaTexto = false;
		boolean errorFechaObli= false;
		boolean errorFechaObliHorMin = false;
		boolean errorFechaZonaHoraria =false;
		boolean errorFechaComboZH =false;
		boolean errorEmail=false;
		boolean errorNoNumero=false;
		boolean errorFecha = false;
		boolean errorFormatoFecha=false;
		boolean errorZHFueraRango =false;
		boolean errorFechaFueraRango=false;
		
		VersionVO version =null;
		ContribucionVO[] contribucionesVO = null;
		SourceValueVO estatusSV= null;
		VersionVO versionVO=null;
		
		LomAvanzadoVO auxAvanzado=new LomAvanzadoVO();
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		try{
			AvLifeCycleVO lifeCycle = new AvLifeCycleVO();
			auxAvanzado.setLifeCycle(lifeCycle);
			
			String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");

			
			
			String usuario =LdapUserDetailsUtils.getUsuario();
			//String usuario="empaquetador";
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
			//			 metemos en la sesion el parametro de vuelta al empaquetador
			catalogadorAvSession.setReturnURL(returnURL);
		
		
	    	Object valor = request.getSession().getAttribute("form");
	
	    	//Obtenemos la longitudes de los VOs, que pasamos a cambioFormulario para que se obtengan del request los cambios que hemos hecho
	    	//Pues en el form que nos viene como parametro no los guarda.
	    	int longitudDescripciones=0;
	    	int longitudVersiones=0;
	    	int longitudContribuciones=0;
	    	int[] longitudTextosDesc = new int[0];
	    	int[] longitudEntidadesContrib = new int[0];
	    	if (valor instanceof CicloDeVidaFormImpl) {		  	
			  	CicloDeVidaFormImpl valorGen = ((CicloDeVidaFormImpl)valor);
	    		Object[] desc = valorGen.getDescripcionesAsArray();
				longitudTextosDesc = new int[desc.length];
				for(int i= 0;i< desc.length;i++){
					longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
				}
	    		
			  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
				for(int i= 0;i< valorGen.getContribuciones().size();i++){
					longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
				}
				longitudContribuciones=valorGen.getContribuciones().size();
				longitudDescripciones=desc.length;
			  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length;
			  	
	    	}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
	    		CicloFormAccionSubmitFormImpl valorGen = ((CicloFormAccionSubmitFormImpl)valor);
	    		Object[] desc = valorGen.getDescripcionesAsArray();
				longitudTextosDesc = new int[desc.length];
				for(int i= 0;i< desc.length;i++){
					longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
				}
	    		
			  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
				for(int i= 0;i< valorGen.getContribuciones().size();i++){
					longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
				}
				longitudContribuciones=valorGen.getContribuciones().size();
				longitudDescripciones=desc.length;
			  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length; 
	    	}else if(valor instanceof CicloNoValidoVolverFormImpl){
	    		CicloNoValidoVolverFormImpl valorGen = ((CicloNoValidoVolverFormImpl)valor);
	    		Object[] desc = valorGen.getDescripcionesAsArray();
				longitudTextosDesc = new int[desc.length];
				for(int i= 0;i< desc.length;i++){
					longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
				}
	    		
			  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
				for(int i= 0;i< valorGen.getContribuciones().size();i++){
					longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
				}
				longitudContribuciones=valorGen.getContribuciones().size();
				longitudDescripciones=desc.length;
			  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length; 
	    	}else if(valor instanceof CicloValidoVolverFormImpl){
	    		CicloValidoVolverFormImpl valorGen = ((CicloValidoVolverFormImpl)valor);
	    		Object[] desc = valorGen.getDescripcionesAsArray();
				longitudTextosDesc = new int[desc.length];
				for(int i= 0;i< desc.length;i++){
					longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
				}
	    		
			  	longitudEntidadesContrib = new int[valorGen.getContribuciones().size()];
				for(int i= 0;i< valorGen.getContribuciones().size();i++){
					longitudEntidadesContrib[i]=((Contribucion)(valorGen.getContribucionesAsArray()[i])).getEntidades().length;
				}
				longitudContribuciones=valorGen.getContribuciones().size();
				longitudDescripciones=desc.length;
			  	longitudVersiones=(((VersionVO[])valorGen.getVersionesAsArray())[0]).getTextos().length; 
	    	}
	    	
	    	//Recogemos los cambio del request mediante parametros
			
		  	cambioFormulario(request,longitudDescripciones,longitudVersiones,longitudContribuciones
		  			,longitudTextosDesc,longitudEntidadesContrib);
		  	
	    	//Guardamos los cambios en el form obtenido de request.getSession.getAttribute("form") para que en caso de faltar
		  	//algun idioma o texto sin rellenar cargue el formulario con lo cambio y no perdamos todo lo modificado hasta ese
		  	//momento, si no lo hicieramos cargaría el formulario anterior.
	
	    	//VERSION
	    	VersionVO[] versionesAux = new VersionVO[1];
	    	LangStringVO[] langVerAux = new LangStringVO[versiones[0].getTextos().length];
	    	for(int i=0;i<versiones[0].getTextos().length;i++){
	    		LangStringVO nuevoLang = new LangStringVO();
	    		nuevoLang.setIdioma(versiones[0].getTextos()[i].getIdioma());
	    		nuevoLang.setTexto(versiones[0].getTextos()[i].getTexto());
	    		langVerAux[i] = nuevoLang;
	    	}
	    	VersionVO VerAux= new VersionVO();
	    	VerAux.setTextos(langVerAux);
	    	versionesAux[0]=VerAux;
	
	    	//DESCRIPCIONES
	    	DescripcionVO[]	descripcionesAux = new DescripcionVO[descripciones.length];
	    	for(int i=0;i<descripciones.length;i++){
	    		DescripcionVO descripAux= new DescripcionVO();
	    		LangStringVO[] langDescrip = descripciones[i].getTextos();
	    		LangStringVO[] langDescripAux = new LangStringVO[langDescrip.length];
	    		for(int j=0;j<langDescrip.length;j++){
	    			LangStringVO nuevoLang = new LangStringVO();
	    			nuevoLang.setIdioma(langDescrip[j].getIdioma());
	    			nuevoLang.setTexto(langDescrip[j].getTexto());
	    			langDescripAux[j] = nuevoLang;
	    		}
	    		descripAux.setTextos(langDescripAux);
	    		descripcionesAux[i]=descripAux;
	    	}
	    	//CONTRIBUCIONES
	    	Contribucion[]	contribucionesAux = new Contribucion[contribuciones.length];
	        for(int i=0;i<contribuciones.length;i++){
	        	Contribucion contribucionAux = new Contribucion();
	        	//rol
	        	SourceValueVO rolAux = new SourceValueVO();
	        	rolAux.setValor(contribuciones[i].getRol().getValor());
	        	//entidad
	        	Entidad[] entidades = contribuciones[i].getEntidades() ;
	        	Entidad[] entidadesAux = new Entidad[entidades.length];
	        	for(int j=0;j< entidadesAux.length;j++){
	        		Entidad entidad = new Entidad();
	        		entidad.setCorreo(entidades[j].getCorreo());
	        		entidad.setNombre(entidades[j].getNombre());
	        		entidad.setOrganizacion(entidades[j].getOrganizacion());
	        		entidadesAux[j]=entidad;
	        	}
	        	//fecha
	        	Fecha fechaAux = contribuciones[i].getFecha();
	        	//contribucion
	        	contribucionAux.setRol(rolAux);
	        	contribucionAux.setEntidades(entidadesAux);
	        	contribucionAux.setFecha(fechaAux);
	        	contribucionesAux[i]=contribucionAux;
	        }
	    	
	    	if (valor instanceof CicloDeVidaFormImpl) {
	    		((CicloDeVidaFormImpl)valor).setVersionesAsArray(versionesAux);
	    		((CicloDeVidaFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
	    		((CicloDeVidaFormImpl)valor).setContribucionesAsArray(contribucionesAux);
	
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
	    		((CicloFormAccionSubmitFormImpl)valor).setVersionesAsArray(versionesAux);
	    		((CicloFormAccionSubmitFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
	    		((CicloFormAccionSubmitFormImpl)valor).setContribucionesAsArray(contribucionesAux);
	      	}
	    	else if(valor instanceof CicloValidoVolverFormImpl){
	    		((CicloValidoVolverFormImpl)valor).setVersionesAsArray(versionesAux);
	    		((CicloValidoVolverFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
	    		((CicloValidoVolverFormImpl)valor).setContribucionesAsArray(contribucionesAux);
	      	}
	    	else if(valor instanceof CicloNoValidoVolverFormImpl){
	    		((CicloNoValidoVolverFormImpl)valor).setVersionesAsArray(versionesAux);
	    		((CicloNoValidoVolverFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
	    		((CicloNoValidoVolverFormImpl)valor).setContribucionesAsArray(contribucionesAux);
	      	}
	
		  	estatus = form.getEstatus();
		  	
			//Obtnemos los terminos de los ids seleccionados en todos los combos, y los guarda en los VO 
			dameTerminoId();         
			 
			//Comprobamos si los campos ha sido rellenados adecuadamente
			  
			//VERSIONES
			versionVO=new VersionVO();
			if (versiones!= null && versiones.length != 0){
				version = (VersionVO) versiones[0];
				LangStringVO[] textos=version.getTextos();
				ArrayList lista=new ArrayList();
				for(int j=0;j<textos.length;j++){
					LangStringVO lVer=(LangStringVO) textos[j];
						 
					if(lVer !=null){
						LangStringVO lLang=new LangStringVO();
						String idioma=lVer.getIdioma();
						String texto=lVer.getTexto();
						if(((idioma!=null)&&(!idioma.trim().equals(""))) && ((texto!=null)&&(!texto.trim().equals("")))){
							lLang.setIdioma(idioma.trim());
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
					versionVO = null;
				else
					versionVO.setTextos(lLangS); 
			}
			else 
				versionVO = null;
			 
			auxAvanzado.getLifeCycle().setVersion(versionVO);		 
			
			//ESTATUS
			estatusSV=new SourceValueVO();
			if((estatus!=null)&&(!estatus.equals(""))){
				estatusSV.setValor(estatus);
				estatusSV.setSource(source);
			}
			else{
				estatusSV = null;
			}
			auxAvanzado.getLifeCycle().setEstado(estatusSV);
					
			//CONTRIBUCIONES
			contribucionesVO = null;
			if (contribuciones!= null && contribuciones.length != 0){
				contribucionesVO = new ContribucionVO[contribuciones.length];
				ArrayList listaContribuciones=new ArrayList();
				for(int k=0;k<contribuciones.length;k++){
					ContribucionVO contribucionVO = new ContribucionVO();
					//FECHA
					FechaVO fechaVO = new FechaVO();
					//Descripciones
					/**********************************************/
					if(descripciones!=null && descripciones.length != 0){
						if(descripciones[k]!=null){
							ArrayList listDesc=new ArrayList();
							DescripcionVO lDesc=(DescripcionVO)(descripciones[k]);
							DescripcionVO lDescripciones=new DescripcionVO();
							for(int j=0;j<lDesc.getTextos().length;j++){
								LangStringVO lang=lDesc.getTextos()[j];
								LangStringVO lLang=new LangStringVO();
								String idioma=lang.getIdioma();
								String texto=lang.getTexto();
								if(((idioma!=null)&&(!idioma.trim().equals(""))) && ((texto!=null)&&(!texto.trim().equals("")))){
									lLang.setIdioma(idioma.trim());
									lLang.setTexto(texto.trim());
									listDesc.add(lLang);
								}
								else{
									if (idioma.equals("") && !texto.trim().equals("") )
										errorFaltaIdioma = true;
									if (!idioma.equals("") && texto.trim().equals("") )
										errorFaltaTexto = true;
								} 
							}
							
							if (listDesc.size() != 0){
								LangStringVO[] langs=(LangStringVO[])listDesc.toArray(new LangStringVO[listDesc.size()]); 
								lDescripciones.setTextos(langs); 
								fechaVO.setDescripcion(lDescripciones);
							}else{//meter una vacia???	
								fechaVO.setDescripcion(null);
							}
						}
						
					}
					/**********************************************/
					//fecha
					/**********************************************/
					// es obl al menos yyyy-MM-dd
					
					Fecha fechaAux = contribuciones[k].getFecha();
//					fechaAux.setIdioma(idiomaLdap);
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

					if(errores.length==0 )
					{
						fechaVO.setFecha(fechaAux.getFechaLomes());
					}else
					{
						fechaVO.setFecha(null);
					}
					
					if(fechaVO.getDescripcion()==null && fechaVO.getFecha()==null )
						fechaVO=null;
					
					contribucionVO.setFecha(fechaVO);
						
					/**********************************************/
					//rol	
					/**********************************************/
					SourceValueVO rolVO=new SourceValueVO();
					String rol = contribuciones[k].getRol().getValor();
					if((rol!=null)&&(!rol.equals(""))){
						rolVO.setSource(source);
						rolVO.setValor(rol);
					}
					else{
						rolVO = null;
					}
					contribucionVO.setTipo(rolVO);
					/**********************************************/
					//entidad
					/**********************************************/
					EntidadVO[] entidadesVO = null;
					Entidad[] entidades = contribuciones[k].getEntidades();
					ArrayList listaEntidades= new ArrayList();
					for (int i=0;i<entidades.length;i++){
						Entidad entidad = entidades[i];
						EntidadVO entidadVO = new EntidadVO();
						String textoEnt="";
						if (!entidad.getOrganizacion().trim().equals("") || !entidad.getCorreo().trim().equals("") || !entidad.getNombre().trim().equals("")){
							if(!entidad.getCorreo().trim().equals("")){
								if(validaEmail(entidad.getCorreo())){	
									textoEnt = new StringBuffer("BEGIN:VCARD VERSION:3.0 FN:").append(entidad.getNombre().trim())
													  .append(" EMAIL;TYPE=INTERNET:").append(entidad.getCorreo().trim())
													  .append(" ORG:").append(entidad.getOrganizacion().trim()).append(" END:VCARD").toString();
									entidadVO.setTexto(textoEnt);
									listaEntidades.add(entidadVO);
								}
								else errorEmail=true;}
							else{
								textoEnt = new StringBuffer("BEGIN:VCARD VERSION:3.0 FN:").append(entidad.getNombre().trim())
													.append(" EMAIL;TYPE=INTERNET:").append(entidad.getCorreo().trim())
													.append(" ORG:").append(entidad.getOrganizacion().trim()).append(" END:VCARD").toString();
								entidadVO.setTexto(textoEnt);
								listaEntidades.add(entidadVO);
							}
						}
					}
					if (listaEntidades.size() == 0)
						entidadesVO = null;
					else
						entidadesVO=(EntidadVO[])listaEntidades.toArray(new EntidadVO[listaEntidades.size()]);
					contribucionVO.setEntidades(entidadesVO);
					/**********************************************/
					
					//añado contribucionVO si tiene algo
					if (contribucionVO.getEntidades() != null || contribucionVO.getFecha() != null || contribucionVO.getTipo() != null)
						listaContribuciones.add(contribucionVO);
					//contribucionesVO[k]=contribucionVO;
				}
				if (listaContribuciones.size() == 0)
					contribucionesVO = null;
				else
					contribucionesVO=(ContribucionVO[])listaContribuciones.toArray(new ContribucionVO[listaContribuciones.size()]);
			}
			else{
				contribucionesVO =null;
			}
			auxAvanzado.getLifeCycle().setContribuciones(contribucionesVO);
			
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (Exception e) {
			logger.error("Error categoria ciclodevida, metodo guardarMetadatos " + e);
			throw new java.lang.Exception("ciclo.de.vida", e);
		}
		
		if(!errorFaltaIdioma && !errorFaltaTexto  && !errorFechaObli && !errorFechaObliHorMin && !errorFechaZonaHoraria && !errorFechaComboZH
				&& !errorEmail && !errorNoNumero && !errorFechaFueraRango && !errorZHFueraRango && !errorFormatoFecha){				
//			Cargamos el objeto de sesion
			if(catalogadorAvSession.getMDSesion()==null){
				catalogadorAvSession.setMDSesion(auxAvanzado);
				
			}else{	       
		       if (versionVO == null && estatusSV == null && contribucionesVO == null)
		    	   catalogadorAvSession.getMDSesion().setLifeCycle(null);
				else{
					catalogadorAvSession.getMDSesion().setLifeCycle(auxAvanzado.getLifeCycle());				
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
			else if (!errorFaltaIdioma && errorFaltaTexto)
				throw new ValidatorException("{general.error.texto}");
			else 
				throw new ValidatorException("{general.error.idioma}");

		}

 
     }

	//Entran los ids y nos devuelve los nomTerminos
	private void dameTerminoId() throws Exception{
	    //VERSION
		ArrayList idsVer = new ArrayList();
	    LangStringVO[] langVersion =versiones[0].getTextos();
	    for ( int i=0;i<langVersion.length;i++){
	    	idsVer.add(langVersion[i].getIdioma());
	    }
	    
	    String[] arrayIdsVer = (String[])idsVer.toArray(new String[idsVer.size()]);
	    TerminoYPadreVO[] terminosTraducVer = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsVer);
	    int jVer= 0;
	    for (int cont=0;cont<terminosTraducVer.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jVer<langVersion.length){
				if (langVersion[jVer].getIdioma().equals("")){
					jVer++; 
				}
				else{
					enc = true;
					langVersion[jVer].setIdioma(terminosTraducVer[cont].getNomTermino());
					jVer++;
				}
			}	
	    }	    
	    versiones[0].setTextos(langVersion);
	    
	    //CONTRIBUCION
	    ArrayList idsRol = new ArrayList();
	    for (int i = 0;i<contribuciones.length;i++){
	    	idsRol.add(contribuciones[i].getRol().getValor());
	    }
	    
        String[] arrayIdsRol = (String[])idsRol.toArray(new String[idsRol.size()]);
        TerminoYPadreVO[] terminosTraducRol = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsRol);
	    
      //  boolean encC = false;
        int contC =0;//MAAAAALLLLLLLL
        for (int i = 0;i<contribuciones.length;i++){
        //	for (int cont=0;cont<terminosTraducRol.length;cont++){
       // 	while(!encC && contC < terminosTraducRol.length){
        		if (!contribuciones[i].getRol().getValor().equals("")){
    				contribuciones[i].getRol().setValor(terminosTraducRol[contC].getNomTermino());
    				contC++;
//    				encC=true;
        		}
//        		contC++;
//        	}
      //  	encC=false;
    	//	}
        }
        
	    //descripciones de la fecha
		ArrayList idsDesc = new ArrayList();
	    
	    for ( int i=0;i<descripciones.length;i++ ){
	    	LangStringVO[] langDescripcion = descripciones[i].getTextos();
	    	for ( int j=0;j<langDescripcion.length;j++){
		    	idsDesc.add(langDescripcion[j].getIdioma());
	    	}
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
	        
	        descripciones[i].setTextos(langDescripcion);
	    }
	    
	    
	    
    
	    ArrayList ids = new ArrayList();
	    ids.add(estatus);
	    
	    String[] arrayIds = (String[])ids.toArray(new String[ids.size()]);
	    TerminoYPadreVO[] terminosTraduc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIds);
	    if (!estatus.equals("")){
	    	estatus=terminosTraduc[0].getNomTermino();
	    }

	}

	private void cambioFormulario(HttpServletRequest request,int longitudDescripciones,int longitudVersiones
			,int longitudContribuciones	,int[] longitudTextosDesc,int[] longitudEntidadesContrib){
		
		//descripciones
		descripciones = new DescripcionVO[longitudDescripciones];
		versiones = new VersionVO[1];
		contribuciones = new Contribucion[longitudContribuciones];
		  	
      	ArrayList[] textoDescripciones = new ArrayList[longitudDescripciones];
      	ArrayList[] idiomaDescripciones = new ArrayList[longitudDescripciones];
      	ArrayList[] nombresEntidades = new ArrayList[longitudContribuciones];
      	ArrayList[] orgsEntidades = new ArrayList[longitudContribuciones];
      	ArrayList[] correoEntidades = new ArrayList[longitudContribuciones];
      	String[] idiomaVersion = new String[longitudVersiones];
      	String[] textoVersion = new String[longitudVersiones];
      	String[] fechaCorta= new String[longitudContribuciones];
      	String[] horas = new String[longitudContribuciones];
      	String[] minutos = new String[longitudContribuciones];
      	String[] segundos1 = new String[longitudContribuciones];
      	String[] segundos2 = new String[longitudContribuciones];
      	String[] zhHoras = new String[longitudContribuciones];
      	String[] zhMinutos = new String[longitudContribuciones];
      	String[] roles = new String[longitudContribuciones];
      	String[] zonaH = new String[longitudContribuciones];
      	String[] meridianosCero= new String[longitudContribuciones];
      	
      	
      	for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
      	{
      		String name = String.valueOf(names.nextElement());
      		
      		if (name.startsWith("Cont")){//descripciones       	 
	          	 String[] namePartido = name.split("_");
	          	 int i = Integer.parseInt(namePartido[0].substring(4, namePartido[0].length()));
	          	 //Descripciones fechas
	          	 if (namePartido[1].startsWith("DesFecTex")){
	          		 int j = Integer.parseInt(namePartido[1].substring(9, namePartido[1].length()));
	          		 ArrayList lDesc = textoDescripciones[i];
	          		 if(lDesc == null){
	          			 lDesc= new ArrayList();
	          			 for (int k=0;k<longitudTextosDesc[i];k++)
	          				 lDesc.add("");
	          		 }
	          		 
	          		 lDesc.set(j, request.getParameter(name));
	          		 textoDescripciones[i]=lDesc;
	          	 }
	          	 else if (namePartido[1].startsWith("DesFecIdio")){//Idio
	          		 int j = Integer.parseInt(namePartido[1].substring(10, namePartido[1].length()));
	          		 ArrayList lDesc = idiomaDescripciones[i];
	          		 if(lDesc == null){
	          			 lDesc= new ArrayList();
	          			 for (int k=0;k<longitudTextosDesc[i];k++)
	          				 lDesc.add("");
	          		 }
	          		 
	          		 lDesc.set(j, request.getParameter(name));
	          		 idiomaDescripciones[i]=lDesc;
	          	 }
	          	 // partes de la fecha
	          	 else if (namePartido[1].startsWith("FechaCorta"))
			      	 fechaCorta[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("FechaHora"))
			      	 horas[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("FechaMin"))
			      	 minutos[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("FechaSeg1"))
			      	 segundos1[i]=request.getParameter(name);	          	 
	          	 else if (namePartido[1].startsWith("FechaSeg2"))
			      	 segundos2[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("FechaZHHora"))
			      	 zhHoras[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("FechaZHMinutos"))
			      	 zhMinutos[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("FechaZonaH"))
			      	 zonaH[i]=request.getParameter(name);
	          	 else if (namePartido[1].startsWith("Rol"))
	          		 roles[i]=request.getParameter(name);
	          	 //entidades
	          	 else if (namePartido[1].startsWith("Ent")){
	          		 int j = Integer.parseInt(namePartido[1].substring(3, namePartido[1].length()));
	          		 if(namePartido[2].startsWith("Nom")){
	              		 ArrayList lNom = nombresEntidades[i];
		          		 if(lNom == null){
		          			lNom= new ArrayList();
		          			 for (int k=0;k<longitudEntidadesContrib[i];k++)
		          				lNom.add("");
		          		 }
		          		 
		          		lNom.set(j, request.getParameter(name));
		          		nombresEntidades[i]=lNom;
	          		 }
	          		 if(namePartido[2].startsWith("Org")){
	              		 ArrayList lOrg = orgsEntidades[i];
		          		 if(lOrg == null){
		          			lOrg= new ArrayList();
		          			 for (int k=0;k<longitudEntidadesContrib[i];k++)
		          				lOrg.add("");
		          		 }
		          		 
		          		lOrg.set(j, request.getParameter(name));
		          		orgsEntidades[i]=lOrg;
	          		 }
	          		 if(namePartido[2].startsWith("Cor")){
	              		 ArrayList lCor = correoEntidades[i];
		          		 if(lCor == null){
		          			lCor= new ArrayList();
		          			 for (int k=0;k<longitudEntidadesContrib[i];k++)
		          				lCor.add("");
		          		 }
		          		 
		          		lCor.set(j, request.getParameter(name));
		          		correoEntidades[i]=lCor;
	          		 }
	
	          	 }
	          	 else if (namePartido[1].startsWith("meridianoCero")){
	          		 meridianosCero[i]=request.getParameter(name);
	          	 }
     		}
		  	if (name.startsWith("Ver")){
		  		if(name.startsWith("VerTex")){
		  			int i = Integer.parseInt(name.substring(6, name.length()));
		  			textoVersion[i]=request.getParameter(name);
		  		}	 
    
		  		if (name.startsWith("VerIdio")){
		  			int i = Integer.parseInt(name.substring(7, name.length()));
		  			idiomaVersion[i]=request.getParameter(name);
		  		}
		  	}
           
       }

        //Versiones
        VersionVO VerVO = new VersionVO();
        LangStringVO[] aLangVersion = new LangStringVO[textoVersion.length];
        for (int i = 0; i<textoVersion.length;i++){
        	LangStringVO langVersion= new LangStringVO();
        	langVersion.setTexto(textoVersion[i]);
        	langVersion.setIdioma(idiomaVersion[i]);
        	aLangVersion[i] = langVersion;
        }
        VerVO.setTextos(aLangVersion);
        versiones[0]=VerVO;	
      	
        //descripciones
        for(int i=0;i<textoDescripciones.length;i++){
        	DescripcionVO descVO = new DescripcionVO();
        	if (textoDescripciones[i]!=null) {
	        	LangStringVO[] aLangDesc = new LangStringVO[textoDescripciones[i].size()];
	        	for (int j = 0; j<textoDescripciones[i].size();j++){
	        		LangStringVO langDesc= new LangStringVO();
	        		langDesc.setTexto(textoDescripciones[i].get(j).toString());
	        		langDesc.setIdioma(idiomaDescripciones[i].get(j).toString());
	        		aLangDesc[j] = langDesc;
	        	}
	        	descVO.setTextos(aLangDesc);
        	}else {
        		 LangStringVO[] aLangString=new LangStringVO[1];
      	  		 LangStringVO langString = new LangStringVO();
      	  		 langString.setIdioma("");
      	  		 langString.setTexto("");
      	  		 aLangString[0]= langString;
      	  		 descVO.setTextos(aLangString);
        	}
        	descripciones[i]=descVO;     
       }
        //contribuciones
        for(int i=0;i<longitudContribuciones;i++){
        	Contribucion contribucionAux = new Contribucion();
        	//rol
        	SourceValueVO rolAux = new SourceValueVO();
        	rolAux.setValor(roles[i]);
        	//entidad
        	Entidad[] entidadesAux = new Entidad[longitudEntidadesContrib[i]];
        	for(int j=0;j< entidadesAux.length;j++){
        		Entidad entidad = new Entidad();
        		String correoEntIJ="";
        		if ((correoEntidades[i]!=null) && (correoEntidades[i].get(j))!=null) {
        			correoEntIJ=correoEntidades[i].get(j).toString();
        		}
        		entidad.setCorreo(correoEntIJ);
        		String nombresEntIJ="";
        		if ((nombresEntidades[i]!=null) && (nombresEntidades[i].get(j)!=null)) {
        			nombresEntIJ=nombresEntidades[i].get(j).toString();
        		}
        		entidad.setNombre(nombresEntIJ);
        		String orgsEntIJ="";
        		if ((orgsEntidades[i]!=null) && (orgsEntidades[i].get(j)!=null)) {
        			orgsEntIJ=orgsEntidades[i].get(j).toString();
        		}
        		entidad.setOrganizacion(orgsEntIJ);
        		entidadesAux[j]=entidad;
        	}
        	//fecha
        	Fecha fechaAux = new Fecha();
        	fechaAux.setIdioma(this.getCatalogadorAvSession(request).getIdioma());
        	fechaAux.setFechaCorta(fechaCorta[i]);
        	fechaAux.setHora(horas[i]);
        	fechaAux.setMinutos(minutos[i]);
        	fechaAux.setSegundoP1(segundos1[i]);
        	fechaAux.setSegundoP2(segundos2[i]);
        	fechaAux.setZhHora(zhHoras[i]==null?"":zhHoras[i]);
        	fechaAux.setZhMinutos(zhMinutos[i]==null?"":zhMinutos[i]);
        	fechaAux.setMasOmenos(zonaH[i]==null?"":zonaH[i]);
        	fechaAux.setMeridianoCero(meridianosCero[i]);	
        	//contribucion
        	contribucionAux.setRol(rolAux);
        	contribucionAux.setEntidades(entidadesAux);
        	contribucionAux.setFecha(fechaAux);
        	contribuciones[i]=contribucionAux;
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



	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Acción cancelar");
	}




	public void cargarLifeCycleValidar(ActionMapping mapping, CargarLifeCycleValidarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap= this.getCatalogadorAvSession(request).getIdioma();

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
			UtilidadesOrdenarCombos vocabulariosOrdDest2 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest2.ordenarVocabulariosVO(vocabulario);			

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
			}//fin for carga combos
			
			logger.debug("Cargados los combos");
			
			AvLifeCycleVO life= this.getCatalogadorAvSession(request).getLomValidacion().getLifeCycle();
			
        	form.setEstatus(life.getEstado().getValor());
        	VersionVO[] versions=new VersionVO[1];
        	versions[0]=life.getVersion();
        	form.setVersionesAsArray(versions);
        	form.setContribucionesAsArray(contribuciones);
        	form.setDescripcionesAsArray(descripciones);
        	
        	
            
            //si ciclo de vida era null en el objeto de session lo dejamos a null
            if (cicloEsNull)
            	catalogadorAvSession.getMDSesion().setLifeCycle(null);
			
			
        }catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacion avanzado, metodo cargarLifeCycleValidar" + e);
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
			
	    	if (valor instanceof CicloDeVidaFormImpl) {
		      	form.setDescripciones(((CicloDeVidaFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloDeVidaFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloDeVidaFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloDeVidaFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloDeVidaFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloDeVidaFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloDeVidaFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloDeVidaFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloDeVidaFormImpl)valor).getContribuciones());
			}
	    	else if(valor instanceof CicloFormAccionSubmitFormImpl){
		      	form.setDescripciones(((CicloFormAccionSubmitFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloFormAccionSubmitFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloFormAccionSubmitFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloFormAccionSubmitFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloFormAccionSubmitFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloFormAccionSubmitFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloFormAccionSubmitFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloFormAccionSubmitFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloValidoVolverFormImpl){
		      	form.setDescripciones(((CicloValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloValidoVolverFormImpl)valor).getContribuciones());
		  	}else if(valor instanceof CicloNoValidoVolverFormImpl){
		      	form.setDescripciones(((CicloNoValidoVolverFormImpl)valor).getDescripciones());  
		      	form.setComboIdiomaLabelList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(((CicloNoValidoVolverFormImpl)valor).getComboIdiomaValueList());
		      	form.setEstatusLabelList(((CicloNoValidoVolverFormImpl)valor).getEstatusLabelList());
		      	form.setEstatusValueList(((CicloNoValidoVolverFormImpl)valor).getEstatusValueList());
		      	form.setCrolLabelList(((CicloNoValidoVolverFormImpl)valor).getCrolLabelList());
		      	form.setCrolValueList(((CicloNoValidoVolverFormImpl)valor).getCrolValueList());
		      	form.setVersiones(((CicloNoValidoVolverFormImpl)valor).getVersiones());
		      	form.setContribuciones(((CicloNoValidoVolverFormImpl)valor).getContribuciones());
		  	}
		    	
		    //VERSION
		    LangStringVO[] nuevolangTextosVersion = new LangStringVO[1];
			LangStringVO lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosVersion[0] = lang;
			VersionVO versionVO= new VersionVO(); 
			versionVO.setTextos(nuevolangTextosVersion);
			VersionVO[] aVersionVO= new VersionVO[1];
			aVersionVO[0]=versionVO;
	        form.setVersionesAsArray(aVersionVO);
	
	        //ESTADO
		    form.setEstatus("");
		    
		    //CONTRIBUCIONES
	
			Contribucion[] contribucionesAux=new Contribucion[1];
			Contribucion contribucionAux = new Contribucion();
			//Descripcion vacia
			DescripcionVO[] aDescripcionesVO = new DescripcionVO[1];
			DescripcionVO descripcionVO = new DescripcionVO();
			LangStringVO[] nuevolangTextosDescrip = new LangStringVO[1];
			lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosDescrip[0] = lang;
			descripcionVO.setTextos(nuevolangTextosDescrip);
			aDescripcionesVO[0]=descripcionVO;
			//Fecha vacia
			Fecha fechaAux= new Fecha();
			fechaAux.setIdioma(catalogadorAvSession.getIdioma());
			contribucionAux.setFecha(fechaAux);
			
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
	
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error Acceso " + ad);
			throw new java.lang.Exception("ciclo.de.vida", ad);
		}catch (Exception e) {
			logger
			.error("Error en catalogadorWeb, categoria CicloVida, metodo reset " + e);
			throw new java.lang.Exception("ciclo.de.vida", e);
		
		}
	}
}