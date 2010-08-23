/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.presentacion.visualizador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.agregaProperties.DecisorOffline;
import es.agrega.soporte.tag.url.TransformarURL;
import es.pode.buscar.negocio.buscar.servicios.MetadatoBasicoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO;
import es.pode.entregar.negocio.servicios.ArgObtOrganizacionesVO;
import es.pode.entregar.negocio.servicios.ItemVO;
import es.pode.entregar.negocio.servicios.ManifestVO;
import es.pode.entregar.negocio.servicios.OrganizacionVO;
import es.pode.entregar.negocio.servicios.SecuenciaVO;
import es.pode.presentacion.VisualizadorSession;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.presentacion.visualizador.VisualizadorController
 */
public class VisualizadorControllerImpl extends VisualizadorController
{
	protected static Logger logger = Logger.getLogger(VisualizadorControllerImpl.class);
	
	protected  static HashMap hOrganizaciones = null;
	protected static HashMap hDatos = null;
	protected static OrganizacionVO[] orgs =null;

	private static final String PROTOCOLO_HTTP="http://";
	private static final String PROTOCOLO_HTTPS="https://";
	private final static String POSICIONADO_DETALLE = "POSICIONADO_DETALLE";
	private final static String BARRA = "/";
	private final static String DETALLE_CORTA = "url_buscadorDetalleCorta";
	private final static String LOCALHOST = "localhost";
	private final static String ORIGEN_BUSQUEDA="BUSQUEDA";

    public final void cargarDatos(
    		ActionMapping mapping, 
    		CargarDatosForm form, 
    		HttpServletRequest request,
    		HttpServletResponse response) 
    throws Exception
    {

    	try{
    		
    	String identificador = request.getParameter("identificador");//"MANIFEST-67ECF89A-C6CD-F6D0-F8A1-259F762A6F1B";//request.getParameter("identificador");
    	String idioma= request.getParameter("idioma");
    	String usuario ="";
    	String idiomaTit="";

    	if(LdapUserDetailsUtils.estaAutenticado()){
    		idiomaTit=LdapUserDetailsUtils.getIdioma();
    		usuario = LdapUserDetailsUtils.getUsuario(); 
    	}
    	else{
    		idiomaTit = request.getLocale().getLanguage();
    		usuario ="user";
    	}
    	if(idiomaTit==null || idiomaTit.equals("")){
    		idiomaTit=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    	}
    	if(idioma==null || idioma.equals("")){
    		idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    	}
    	
    	ArgObtOrganizacionesVO ode= new ArgObtOrganizacionesVO();
    	ode.setIdentificador(identificador);
    	ode.setIdioma(idioma);
    	ode.setUsuario(usuario);
    	ode.setIdiomaTitulo(idiomaTit);
    
	logger.error("ode is: " + ode);	
    	
    	ManifestVO manifest = this.getSrvEntregarService().obtenerOrganizaciones(ode);
    	orgs = manifest.getOrganizaciones();
    	
    	
    	
        form.setDatosSalidaAsArray(orgs);
        form.setUsuario(usuario);
        form.setIdentificador(manifest.getTitulo());
        form.setLocalizacion(manifest.getLocalizacionURL());
        
        

        
        VisualizadorSession visualizadorSession = this.getVisualizadorSession(request);	
        visualizadorSession.setTituloOde(manifest.getTitulo());
        visualizadorSession.setIdentificador(identificador);
        visualizadorSession.setIdiomaCat(idioma);
        visualizadorSession.setUsuario(usuario);
        visualizadorSession.setContenidoEmbebido(generarUrlFicha(request));
        
		//vemos si mostramos los items abiertos o cerrados
        if(orgs !=null){
        	boolean abiertos = true;
	        for(int i = 0; i < orgs.length && abiertos; i++){
	        	OrganizacionVO organizacion = orgs[i];
	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
	        		abiertos = this.mostrarAbiertos(organizacion.getItems());
	        		visualizadorSession.setAbiertos(abiertos);
	        	}
			}
        }
        
        
        //      Insertamos la página en blanco
        visualizadorSession.setUrlContenido( "" );
        ////Añadido para cargar el primer item, si solo tiene un item en una sola organizacion        
	//      Insertamos URL del primer item de la primera organizacion, si sólo tiene una organizacion y un solo item
	    	if(form.getDatosSalida()!=null && form.getDatosSalida().size()>0){
	    		OrganizacionVO[] organizacionLista=(OrganizacionVO[])form.getDatosSalida().toArray();
	    		OrganizacionVO organizacion=organizacionLista[0];

	    		
	    		
	    		if(organizacion.getItems()!=null && organizacion.getItems().length>0){

	    			//cargamos el primer item visible
	    			ArrayList lista = new ArrayList();
        			String refRecurso="";
        			contenidosArbolPre(organizacion.getItems(), lista);
        			if ((lista!=null) && (lista.size()>0)) {
        				ItemVO it = new ItemVO();
        				boolean enc=false;
        				for(int i=0; i < lista.size()&& !enc;i++){		
	        				it=(ItemVO)lista.get(i);
	        				if ((it!=null) && (it.getRecurso()!=null) && (it.getVisible()==null || it.getVisible())) {
	        					enc=true;
	        					refRecurso=it.getRecurso().getHrefRec();
		    					String urlContenido = form.getLocalizacion() + "/" + refRecurso;
		    					logger.debug("VISUALIZADOR CargarDatos urlContenido " + urlContenido);
		    					int co = -1;
		    					if( refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTP) >= 0)
		    						co = refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTP);
		    					else if( refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTPS) >= 0 )
		    						co = refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTPS);
		    						
		    					if (co < 0) {//pner tb en botones
		    						//String host =AgregaPropertiesImpl.getInstance().getProperty("host");
		    						String server = request.getServerName();
		    						if (server.equals(LOCALHOST) && DecisorOffline.esOffline())
		    							server = server + ":" + request.getServerPort();
		    						else
		    							server = server + LdapUserDetailsUtils.getSubdominio() ;
		    						
			    					urlContenido = PROTOCOLO_HTTP + server + urlContenido;
		    					}else{
		    						urlContenido =refRecurso.substring(co);
		    					}
		    					
		    
		    					String encoding = response.getCharacterEncoding();
		    					urlContenido = TransformarURL.transformaUrl(encoding, urlContenido);
		    					visualizadorSession.setUrlContenido(urlContenido);
		    					visualizadorSession.setIdSeleccionado(it.getIdItem());
		        				if( logger.isDebugEnabled() ){
	
		        		            logger.debug("VISUALIZADOR, URLCONTENIDO:"+urlContenido);
		        				}
		        			}
        				
        				}
        				
        				
	    			}
	    		}
	    	}
        
        //////////////////////
        logger.debug("VISULIZADOR cargarDatos localizacionURL " + manifest.getLocalizacionURL());
    	}
    	catch (Exception ex)
    	{

			logger
			.error("XXX Error en Servicio de visualizador de contenidos, metodo cargarDatos " + ex);
			logger.error(ex);
    	}

    }
	

    public final boolean cargarTipoVis(
    		ActionMapping mapping, 
    		CargarTipoVisForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
		// si este valor es false llama a carcarDatos, sino cargarDatosNav
		boolean secuencia = new Boolean(request.getParameter("secuencia")).booleanValue();//true;//new Boolean(request.getParameter("secuencia")).booleanValue();
		String strComunidad= request.getParameter("comunidadAgrega");
		boolean comunidadAgrega = true;
		
		if(strComunidad!=null)
			comunidadAgrega = new Boolean(strComunidad).booleanValue();
		
		VisualizadorSession sesionVis=this.getVisualizadorSession(request);
		sesionVis.setMasOpciones(false);
		sesionVis.setOffLine(DecisorOffline.esOffline());
		
    	if(LdapUserDetailsUtils.estaAutenticado() && 
    		comunidadAgrega && 
    	   !DecisorOffline.esOffline())
		{
			sesionVis.setMasOpciones(true);
		}

		
		if( logger.isDebugEnabled() ){

            logger.debug("VISUALIZADOR, CARGARTIPOVIS, VALOR DE SECUENCIA "+  secuencia);
		}
		return secuencia;
    }








    public final void cargarDatosNav(
    		ActionMapping mapping, 
    		CargarDatosNavForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
		try{
    		//PARAMETROS
	    	String identificador = request.getParameter("identificador");//"MANIFEST-67ECF89A-C6CD-F6D0-F8A1-259F762A6F1B";//request.getParameter("identificador");
	    	String idioma= request.getParameter("idioma");
	    	if (LdapUserDetailsUtils.estaAutenticado()) {
	        	String usuario ="";
	        	String idiomaTit="";

	        	if(LdapUserDetailsUtils.estaAutenticado()){
	        		idiomaTit=LdapUserDetailsUtils.getIdioma();
	        		usuario = LdapUserDetailsUtils.getUsuario(); 
	        	}
	        	else{
	        		idiomaTit = request.getLocale().getLanguage();
	        		usuario ="user";
	        	}
	        	if(idiomaTit==null || idiomaTit.equals("")){
	        		idiomaTit=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	        	}
	        	if(idioma==null || idioma.equals("")){
	        		idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	        	}
	    	
	    		ArgObtOrganizacionesVO ode= new ArgObtOrganizacionesVO();
	        	ode.setIdentificador(identificador);
	        	ode.setIdioma(idioma);
	        	ode.setUsuario(usuario);
	        	ode.setIdiomaTitulo(idiomaTit);
	    		
			logger.error("XXXX MCA ode is: " + ode);
			logger.error("XXXX Id is: " + ode.getIdentificador());

		    	ManifestVO manifest = this.getSrvEntregarService().obtenerOrganizaciones(ode);
		    	orgs = manifest.getOrganizaciones();
		    	VisualizadorSession sesionVis=this.getVisualizadorSession(request);
		    	
		    	sesionVis.setTituloOde(manifest.getTitulo());
		    	sesionVis.setIdentificador(identificador);
		    	sesionVis.setIdiomaCat(idioma);
		    	sesionVis.setUsuario(usuario);
		    	sesionVis.setContenidoEmbebido(generarUrlFicha(request));

		    	// --- tratamiento para la secuencia ---
		    	hOrganizaciones=new HashMap();
		    		for (int se=0; se <orgs.length; se++ ) {
		    			
		    			ItemVO[] items= recorreArbolPreorden(orgs[se]);
		    			//metodo para sequencia
		    			ItemVO[] itemsChoice = interpretaChoice (items);
		    			
		    			if ((orgs[se].getSecuenciaOrg()!= null) && (orgs[se].getSecuenciaOrg().getControlMode()!= null)){
		    				if (!orgs[se].getSecuenciaOrg().getControlMode().getChoice().booleanValue()){
		    					for (int i= 0; i<itemsChoice.length; i++){
		    						itemsChoice[i].setClicable(new Boolean(false));
		    					}	
		    				} else{
		    					for (int i= 0; i<itemsChoice.length; i++){
		    						if (itemsChoice[i].getIdPadre().equals(orgs[se].getIdOrg())){
		    							itemsChoice[i].setClicable(new Boolean(true));
		    						}
		    					}
		    				}
		    				//si tiene secuencia Flow y Forward Only para poner las flechas Solo para la primera!!
		    				if (se==0) {
				    				if (orgs[se].getSecuenciaOrg().getControlMode().getFlow().booleanValue()) {
				    					sesionVis.setBtnDerecho(new Boolean(true));
				    					if (orgs[se].getSecuenciaOrg().getControlMode().getForwardOnly().booleanValue()) {
				    						sesionVis.setBtnIzquierdo(new Boolean(false));
				    					} else {
				    						sesionVis.setBtnIzquierdo(new Boolean(true));
				    					}
				    					//En caso de entrar aqui tenemos que coger sus hijos
				    					ArrayList listaHijos = new ArrayList();
										for (int ih=0; ih<items.length;ih++) {
											if (orgs[se].getIdOrg().equals(items[ih].getIdPadre())) {
												listaHijos.add(items[ih]);
											}
										}
										ItemVO[] itemHijos = (ItemVO[]) listaHijos.toArray(new ItemVO[listaHijos.size()]);
										//metemos itemHIjos en session
										sesionVis.setItemsFlow(listaHijos);
										sesionVis.setIdSeleccionado(orgs[se].getIdOrg());
										
				    				} else {
				    					sesionVis.setBtnDerecho(new Boolean(false));
				    					sesionVis.setBtnIzquierdo(new Boolean(false));
				    				}
		    				}//fin flechas primera Org
		    			}
		    			
		    			hOrganizaciones.put(orgs[se].getIdOrg(), itemsChoice);
		    	    	
		    		}
		        form.setDatosSalidaAsArray(orgs);
		        form.setUsuario(usuario);
		        form.setIdentificador(manifest.getTitulo());
		        form.setLocalizacion(manifest.getLocalizacionURL());
		        
		        // RELLENAMOS LOS DATOS DE LA SESION
		        if(sesionVis.getDatosSalida()==null){
		        	sesionVis.setDatosSalida(form.getDatosSalida());
		        	sesionVis.setIdentificador(identificador);
		        	sesionVis.setUsuario(usuario);
		        	sesionVis.setLocalizadorCont(manifest.getLocalizacionURL());
		        	sesionVis.setTituloOde(manifest.getTitulo());
		        	
		        	
		    		//vemos si mostramos los items abiertos o cerrados
		            if(orgs !=null){
		            	boolean abiertos = true;
		    	        for(int i = 0; i < orgs.length && abiertos; i++){
		    	        	OrganizacionVO organizacion = orgs[i];
		    	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
		    	        		abiertos = this.mostrarAbiertos(organizacion.getItems());
		    	        		sesionVis.setAbiertos(abiertos);
		    	        	}
		    			}
		            }       
		     
		            
		        	//Insertamos la página en blanco
		        	sesionVis.setUrlContenido( "" );
		        	//Insertamos URL del primer item de la primera organizacion, si sólo tiene una organizacion y un solo item
		        	if(sesionVis.getDatosSalida()!=null && sesionVis.getDatosSalida().size()>0){
		        		OrganizacionVO[] organizacionLista=(OrganizacionVO[])sesionVis.getDatosSalida().toArray();
		        		OrganizacionVO organizacion=organizacionLista[0];
		        		if(organizacion.getItems()!=null && organizacion.getItems().length>0){
			    			//cargamos el primer item visible
		        			
		        			ArrayList lista = new ArrayList();
		        			String refRecurso="";
		        			contenidosArbolPre (organizacion.getItems(), lista);
		        			if ((lista!=null) && (lista.size()>0)) {
		        				ItemVO it = new ItemVO();
		        				boolean enc=false;
		        				for(int i=0; i < lista.size()&& !enc;i++){	
			        				it=(ItemVO)lista.get(i);
			        				if ((it!=null) && (it.getRecurso()!=null) && (it.getVisible()==null || it.getVisible())) {
			        					enc = true;
			        					refRecurso=it.getRecurso().getHrefRec();
			        					String urlContenido = sesionVis.getLocalizadorCont() + "/" + refRecurso;
				    					int co = -1;
				    					if( refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTP) >=0)
				    						co = refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTP);
				    					else if( refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTPS) >=0)
				    						co = refRecurso.toLowerCase().indexOf(PROTOCOLO_HTTPS);
				    						
			        					
				    					if (co < 0) {//pner tb en botones
				    						//String host =AgregaPropertiesImpl.getInstance().getProperty("host");
				    						String server = request.getServerName();
				    						if (server.equals(LOCALHOST) && DecisorOffline.esOffline())
				    							server = server + ":" + request.getServerPort();
				    						else
				    							server = server + LdapUserDetailsUtils.getSubdominio() ;
				    						
					    					urlContenido = PROTOCOLO_HTTP + server + urlContenido;
					    					
				    					}else{
				    						urlContenido =refRecurso.substring(co);
				    					}
				    					
				    			    					
				    					String encoding = response.getCharacterEncoding();
				    					urlContenido = TransformarURL.transformaUrl(encoding, urlContenido);
				    					sesionVis.setUrlContenido(urlContenido);
				    					sesionVis.setIdSeleccionado(it.getIdItem());
				    					sesionVis.setContador(sesionVis.getContador()+1);
	
				        				if( logger.isDebugEnabled() ){
	
				        		            logger.debug("VISUALIZADOR, URLCONTENIDO:"+urlContenido);
				        				}
				        				System.out.println(urlContenido );
			        					
			        				}
		        				}
		        			}
			        		if(organizacion.getItems().length<=1){
			        			sesionVis.setBtnDerecho(new Boolean(false));
			        			sesionVis.setBtnIzquierdo(new Boolean(false));
			        		}
		        			
		        		}
		        	}
		        	
		            //ruta del nodo seleccionado
		            if(orgs !=null){
		            	boolean encontrada = false;
		            	ArrayList rutaSeleccionado = new ArrayList();
		            	for(int i = 0; i < orgs.length && !encontrada; i++){
		    	        	OrganizacionVO organizacion = orgs[i];
		    	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
		    	        		
		    	        		encontrada = this.rutaIdSeleccionado(sesionVis.getIdSeleccionado(), orgs[i].getItems(), rutaSeleccionado);
		    	        		
		    	        	}
		    			}
		    	        if (encontrada)
		    	        	sesionVis.setRutaSeleccionado(rutaSeleccionado);
		            }	
		        	
		        }
		        //Fin Datos de Sesion
		        if( logger.isDebugEnabled() ){
					logger.debug("VISUALIZADOR, CARGARDATOS_NAV, USUARIO AUTENTICADO " + usuario);
					logger.debug("VISULIZADOR cargarDatos_NAV localizacionURL " + manifest.getLocalizacionURL());
				}
	    	} else {
	    		//Redirijo a la pagina de inicio de visualizador Contenidos
	    		String url="";
	    		url=request.getSession().getServletContext().getInitParameter("url_portada");
	    		if( logger.isDebugEnabled() ){
					logger.debug("VISUALIZADOR, CARGARDATOS_NAV, USUARIO SIN AUTENTICAR ");
				}
	    		response.sendRedirect(request.getServerName() + url);
	    	}
   
	    }
	    catch (Exception ex)
	    {
				logger
				.error("Error en Servicio de visualizador de contenidos, metodo cargarDatosNav " + ex);
				logger.error(ex);
	    }
		
	}

//////////////////////////////////////
//// met para buscar el padre de un nodo
//le pasamos el idItem del padre    
public ItemVO buscaPadreItem (String idItem, ItemVO[] items) {
	ItemVO myItem= null;
	if ((items!=null) && (items.length>0)) {
		int indi=0;
		boolean es=false;
		while ((!es) && (indi<=items.length)) {
			if (idItem.equals(items[indi].getIdItem())) {
				myItem=items[indi];
				es=true;
			}
			indi++;
		}
	}
	return myItem;
}

public int damePosItem(String idItem,ItemVO[] items) {
	int indi=0;
	if ((items!=null) && (items.length>0)) {
		boolean es=false;
		while ((!es) && (indi<=items.length)) {
			if (idItem.equals(items[indi].getIdItem())) {
				es=true;
			}
			indi++;
		}
		if ((es) && (indi<=items.length) && (indi>0)) {
			indi=indi-1;
		}
	}
	return indi;
}


public ArrayList dameHIjos(String idItem,ItemVO[] items) {
	ArrayList listaHijos = new ArrayList();
	if ((items!=null) && (items.length>0)) {
		for (int ih=0; ih<items.length;ih++) {
			if (idItem.equals(items[ih].getIdPadre())) {
				listaHijos.add(items[ih]);
			}
		}/// fin meto hijos
	}
	return listaHijos;
}


public ItemVO[] mergeElementos(ItemVO[] itemsFlows, ArrayList losHijos, int posiPadreSi) {
	ArrayList salidaItem= new ArrayList();
	for (int i=0; i<=posiPadreSi; i++) {
		salidaItem.add(itemsFlows[i]);
	}
	for (int a=0; a<losHijos.size(); a++) {
		salidaItem.add(losHijos.get(a));
	}
	if (posiPadreSi+1<= itemsFlows.length) {
		for (int r=posiPadreSi+1; r<itemsFlows.length; r++) {
			salidaItem.add(itemsFlows[r]);
		}
	}
	return (ItemVO[])salidaItem.toArray(new ItemVO[salidaItem.size()]); 
}

/////////////////////////////////////
    public final void nodoOnClick(
    		ActionMapping mapping, 
    		es.pode.presentacion.visualizador.NodoOnClickForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {

		try{
			OrganizacionVO[] organizaciones= null;
			
			List lista=null;
			ItemVO[] items=null;
			int posItem=-1;
//			Recogemos el nodo que hemos pulsado
			String idNodo=form.getIdNodo();
			VisualizadorSession visualizadorSession = this.getVisualizadorSession(request);		
			logger.debug("VISUALIZADOR, nodoOnclick Identificador: " + visualizadorSession.getIdentificador() + " USUARIO: " + visualizadorSession.getUsuario());
			logger.debug("VISUALIZADOR nodoOnclick localizadorCont " + visualizadorSession.getLocalizadorCont() + " valor form " + form.getLocalizacion());
//			url de los contenidos en principio en blanco
			//if( visualizadorSession.getUrlContenido() == null || visualizadorSession.getUrlContenido().length() == 0 ) {
				visualizadorSession.setUrlContenido( "" );
			//}
			if(form.getDatosSalida()!=null)
				lista= Arrays.asList(form.getDatosSalida().toArray());
			if(lista==null){
				lista=Arrays.asList(visualizadorSession.getDatosSalida().toArray());
			}
			//inicializamos los botones
			//No Botones
			visualizadorSession.setBtnIzquierdo(new Boolean(false));
			visualizadorSession.setBtnDerecho(new Boolean(false));
			visualizadorSession.setContador(-1); // lo inicializamos a -1
			visualizadorSession.setIdSeleccionado(idNodo); //nodo seleccionado
			
			boolean encontradoNodo=false;
			int j=0;
			organizaciones=(OrganizacionVO[])lista.toArray(new OrganizacionVO[lista.size()]);
			while ((j<organizaciones.length) && (!encontradoNodo)){
				if(idNodo.equals(organizaciones[j].getIdOrg())) {
					encontradoNodo=true;
					items = (ItemVO[]) hOrganizaciones.get(organizaciones[j].getIdOrg());
					if ((organizaciones[j].getSecuenciaOrg()!=null) && 
						(organizaciones[j].getSecuenciaOrg().getControlMode()!=null)) {
							//Almacenamos su forwardOnly en sesion
							//visualizadorSession.setSecPadreForwardOnly(secPadreForwardOnly);
							items = (ItemVO[]) hOrganizaciones.get(organizaciones[j].getIdOrg());
							
							//aplicamos secuencia choice a los hijos de primer nivel para reiniciar secuencia
							if (!organizaciones[j].getSecuenciaOrg().getControlMode().getChoice().booleanValue()){
			    				for (int i= 0; i<items.length; i++){
			    					items[i].setClicable(new Boolean(false));
			    				}	
			    			} else{
			    				for (int i= 0; i<items.length; i++){
			    					if (items[i].getIdPadre().equals(organizaciones[j].getIdOrg())){
			    						items[i].setClicable(new Boolean(true));
			    					}
			    				}
			    			}
//							Aplicamos secuencia choice a los hijos
							items=interpretaChoice(items);	
							//Secuencia Flow y Forward Only
							if (organizaciones[j].getSecuenciaOrg().getControlMode().getFlow().booleanValue()) {
								//Tenemos Botones Siempre Derecho, Si Forward Only es true tb boton Iquierdo
								ItemVO[] itemHijos = null;
								ArrayList listaHijos = new ArrayList();
								for (int ih=0; ih<items.length;ih++) {
									if (organizaciones[j].getIdOrg().equals(items[ih].getIdPadre())) {
										listaHijos.add(items[ih]);
									}
								}
								itemHijos = (ItemVO[]) listaHijos.toArray(new ItemVO[listaHijos.size()]);
								//metemos itemHIjos en session
								visualizadorSession.setItemsFlow(listaHijos);
								
								if (!organizaciones[j].getSecuenciaOrg().getControlMode().getForwardOnly().booleanValue()) {
									//Poner Btn Iquierdo en Sesion
									visualizadorSession.setBtnDerecho(new Boolean(true));
									visualizadorSession.setBtnIzquierdo(new Boolean(true));
								} else {
										visualizadorSession.setBtnDerecho(new Boolean(true));
								}
								
								
							}  else {
								//No Botones
								visualizadorSession.setBtnIzquierdo(new Boolean(false));
								visualizadorSession.setBtnDerecho(new Boolean(false));
								
							}
							//Ponemos los items modificados en la hasth!! 
							hOrganizaciones.put(organizaciones[j].getIdOrg(), items);
					} else {
//						No Botones
						visualizadorSession.setBtnIzquierdo(new Boolean(false));
						visualizadorSession.setBtnDerecho(new Boolean(false));
					}
				}
				j++;
			}
			logger.debug("VISUALIZADOR, nodoOnclick nodo pulsado idNodo: " + idNodo + " localizacion cont " + visualizadorSession.getLocalizadorCont());
			//Buscamos si el nodo pulsado es un Item
			if (!encontradoNodo) {
				int io=0;
				while ((io<organizaciones.length) && (!encontradoNodo)) {
					String idOrg=organizaciones[io].getIdOrg();
					if (!hOrganizaciones.isEmpty()) {
						items= (ItemVO[])hOrganizaciones.get(idOrg);
						int k=0;
						while ((k<items.length) && (!encontradoNodo)){
							if(idNodo.equals(items[k].getIdItem())) {
								encontradoNodo=true;
								posItem=k;
							}
							k++;
						}
					}
					io++;
				}
			}
			if ((encontradoNodo) && (items!=null) && (items.length>0) ) {
				if ((posItem >-1) && (items[posItem].getSecuenciaItem()!=null) 
					&& (items[posItem].getSecuenciaItem().getControlMode()!=null)) {
					//secuencia choice
					items=interpretaChoice(items);
					if (!items[posItem].getSecuenciaItem().getControlMode().getChoiceExit().booleanValue()) {
						// Choice Exit: ponemos los hermanso a false y todos los descendientes de los hermanos 
						// menos el mismo
						int indicePrimerHijo=-1; 
						for (int h=0; h<items.length; h++){
							if (items[h].getIdPadre().equals(items[posItem].getIdPadre()))  {
								if ( !(items[h].getIdItem().equals(items[posItem].getIdItem()))) {
									items[h].setClicable(new Boolean(false));
									ArrayList l = new ArrayList();
									l=getIndexPrimerHijo(items,h, l);
									if (!l.isEmpty()) {
										indicePrimerHijo = Integer.parseInt(l.get(l.size() -1).toString());
										if (indicePrimerHijo >-1)
											for (int ind=indicePrimerHijo; ind<h; ind++) {
												items[ind].setClicable(new Boolean(false));
											}
									}
								}
								
							}
						}
					}//Fin Choice Exit
					
					//Secuencia Flow y Forward Only
					ItemVO[] itemsFlows = (ItemVO[])visualizadorSession.getItemsFlow().toArray(new ItemVO[visualizadorSession.getItemsFlow().size()]);
					if (items[posItem].getSecuenciaItem().getControlMode().getFlow().booleanValue()) {
						//Tenemos Botones Siempre Derecho, Si Forward Only es false tb boton Iquierdo
						
						//si no ha sido encontrado, miro quien es el padre y meto en el vector a los hermanos del
						//pulsado y los hijos
						ArrayList rutaSel = new ArrayList();
						//boolean rutaEnc = this.rutaIdSeleccionado(items[posItem].getIdItem(), items, rutaSel);
						//el mismo no esta en el vector de itemsFlow así que lo metemos el primero
						boolean estaitem=false;
						ItemVO unPadre=null;
						if (!(estaItemDVector(items[posItem].getIdItem(), itemsFlows))) {
							rutaSel.add(items[posItem]);
							// buscamos a su padre y vemos si está en el vector
							//tenemos que seguir metiendo padres hasta que encontremos un padre que si esté en itemsFlows
							unPadre=buscaPadreItem (items[posItem].getIdPadre(), items);
							estaitem=estaItemDVector(unPadre.getIdItem(), itemsFlows);
							while ((unPadre!=null) && (!estaitem)) {							
								rutaSel.add(unPadre);
								unPadre=buscaPadreItem(unPadre.getIdPadre(), items);
								estaitem=estaItemDVector(unPadre.getIdItem(), itemsFlows);
							}
						}else{
							//el item esta en itemsFlows
							estaitem=true;
							unPadre=items[posItem];//lo ponemos a el mismo
						}
						if (estaitem) { //hemos encontrado un padre que esta en itemsFlows
							//ahora miramos si tienen hijos y si están metidos, si no lo estan, los metemos
							//en unPadre se queda el padre encontrado!!!!!! buscamos su posicion en itemsFlows
							int posiPadreSi=damePosItem(unPadre.getIdItem(),itemsFlows);
							ItemVO[] nVectorItems=null;
							//si el padre ademas de hijos tiene flow a true
							if ((unPadre.getSecuenciaItem()!=null) && (unPadre.getSecuenciaItem().getControlMode()!=null) 
								&& (unPadre.getSecuenciaItem().getControlMode().getFlow()) && (unPadre.getItemHijos()!=null) && (unPadre.getItemHijos().length>0)) {
								if (!(estaItemDVector(unPadre.getItemHijos()[0].getIdItem(), itemsFlows))) {
									ArrayList losHijos = new ArrayList();
									losHijos=dameHIjos(unPadre.getIdItem(), items);
									nVectorItems=mergeElementos(itemsFlows, losHijos, posiPadreSi);
									itemsFlows=nVectorItems;
								}
								
							}
							//ahora los elementos que estan en el arraylist
							//le damos la vuelta
							Collections.reverse(rutaSel);
							for (int ia=0; ia<rutaSel.size(); ia++) {
								unPadre=(ItemVO)rutaSel.get(ia);
								if ((!(estaItemDVector(unPadre.getIdItem(), itemsFlows))) && (estaItemDVector(unPadre.getIdPadre(), itemsFlows))){
									posiPadreSi=damePosItem(unPadre.getIdPadre(),itemsFlows);
									ArrayList elMismo=new ArrayList();
									elMismo.add(unPadre);
									nVectorItems=mergeElementos(itemsFlows,elMismo, posiPadreSi);
								}
								if ((unPadre.getSecuenciaItem()!=null) && (unPadre.getSecuenciaItem().getControlMode()!=null) 
									&& (unPadre.getSecuenciaItem().getControlMode().getFlow()) && (unPadre.getItemHijos()!=null) && (unPadre.getItemHijos().length>0)) {
									if (!(estaItemDVector(unPadre.getItemHijos()[0].getIdItem(), itemsFlows))) {
										//busco y meto los hijos
										ArrayList losHijos = new ArrayList();
										losHijos=dameHIjos(unPadre.getIdItem(), items);
										posiPadreSi=damePosItem(unPadre.getIdItem(),itemsFlows);
										itemsFlows=mergeElementos(nVectorItems,losHijos, posiPadreSi);
									}
								}
										//a lo mejor hay que actualizar aqi itemsFlows
							}//end for
						}
															    
						
					  //itemHijos = (ItemVO[]) listaHijos.toArray(new ItemVO[listaHijos.size()]);
						 //itemHijos = (ItemVO[]) losItemsMez.toArray(new ItemVO[losItemsMez.size()]);
						//metemos itemHIjos en session
						//visualizadorSession.setItemsFlow(listaHijos);
						 visualizadorSession.setItemsFlow(Arrays.asList(itemsFlows));
						 //ojo
						 int idv= damePosItem(items[posItem].getIdItem(), itemsFlows);
						 visualizadorSession.setContador(idv); // lo modificamos
						 visualizadorSession.setIdSeleccionado(items[posItem].getIdItem());
						if (!items[posItem].getSecuenciaItem().getControlMode().getForwardOnly().booleanValue()) {
							//Poner Btn Iquierdo en Sesion
							visualizadorSession.setBtnDerecho(new Boolean(true));
							visualizadorSession.setBtnIzquierdo(new Boolean(true));
						} else {
							//solo Boton Derecho
							visualizadorSession.setBtnDerecho(new Boolean(true));
						}
						
						
					}  else {
						//No Botones
						visualizadorSession.setBtnIzquierdo(new Boolean(false));
						visualizadorSession.setBtnDerecho(new Boolean(false));
						
					}
					
					
				}
				if ((posItem < items.length) && (posItem > -1)){
					String idPadre=items[posItem].getIdPadre();
					int posPadre=-1;
					int or=0;
					boolean encontradoPadre= false;
					SecuenciaVO seqPadre = null;
					while ((or<items.length) && (!encontradoPadre)) {
						if (items[or].getIdItem().equals(idPadre)) {
							encontradoPadre=true;
							seqPadre= items[or].getSecuenciaItem();
							posPadre=or;
						}
						or++;
					}
					if (!encontradoPadre) {
						int ir=0;
						while ((ir<organizaciones.length) && (!encontradoPadre)) {
							if (organizaciones[ir].getIdOrg().equals(idPadre)) {
								encontradoPadre=true;
								seqPadre= organizaciones[ir].getSecuenciaOrg();
								posPadre=ir;
							}
							ir++;
						}
					}
					boolean orgEncontradoAb=false;
					
					if ((encontradoPadre) && (seqPadre!=null)) {
						int indicePrimerHijo=-1;
						if ((seqPadre.getControlMode()!=null) 
							&& (seqPadre.getControlMode().getForwardOnly().booleanValue())) {
							for (int it=0; it<posItem;it++) {
								if (items[it].getIdPadre().equals(idPadre)) {
									items[it].setClicable(new Boolean(false));
									// creo que este estaba fuera pq si un item tiene hijos ylo pulsamos el es visible
									//pero los hijos no!! ejem Actividads 1 !!!!
									ArrayList l = new ArrayList();
									l=getIndexPrimerHijo(items,it, l);
									if (!l.isEmpty()) {
										indicePrimerHijo = Integer.parseInt(l.get(l.size() -1).toString());
										if (indicePrimerHijo>-1)
										for (int ind=indicePrimerHijo; ind<it; ind++) {
											items[ind].setClicable(new Boolean(false));
										}
									} 
									
								}
							} //for
						}
					}
					
				}
				if ((posItem < items.length) && (posItem > -1)){
					//Temina secuencia, volvemos a actualizar el hashmap con la secuencia correcta
					hOrganizaciones.put(items[posItem].getIdOrg(), items);
				}
			}

			//Comprobamos que no sea una Organizacion (no tiene contenido)
			if ((posItem < items.length) && (posItem > -1)){
	//			Tb debemos mostrar el contenido del item que estamos clicando
				if ((items[posItem].getClicable().booleanValue()) 
						&& (items[posItem].getRecurso()!=null) && 
						(items[posItem].getRecurso().getHrefRec()!=null)) {
					//Comprobamos q no sea una url sino la tratamos y no le concatenamos el localizador
					String contenido = items[posItem].getRecurso().getHrefRec();
					String urlContenido = visualizadorSession.getLocalizadorCont() + "/" + contenido;
					logger.debug("VISUALIZADOR nodoOnClick urlContenido " + urlContenido);
					int co = -1;
					if( urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTP) >=0)
						co = urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTP);
					else if( urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTPS) >=0)
						co = urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTPS);
						
					if (co < 0) {//pner tb en botones
						//String host =AgregaPropertiesImpl.getInstance().getProperty("host");
						String server = request.getServerName();
						if (server.equals(LOCALHOST) && DecisorOffline.esOffline())
							server = server + ":" + request.getServerPort();
						else
							server = server + LdapUserDetailsUtils.getSubdominio() ;
						
    					urlContenido = PROTOCOLO_HTTP + server + urlContenido;
    				
					}else{
						urlContenido =contenido.substring(co);
					}
					
					
					String encoding = response.getCharacterEncoding();
					urlContenido = TransformarURL.transformaUrl(encoding, urlContenido);
					visualizadorSession.setUrlContenido(urlContenido);
					logger.debug("VISUALIZADOR nodoOnClick urlContenido Final" + urlContenido);
					
				} else {
					visualizadorSession.setUrlContenido( "" );
					logger.debug("VISUALIZADOR nodoOnClick urlContenido vacia" );
				}
			}
			if( logger.isDebugEnabled() ){
				logger.debug("URL localizacion contenido "+ visualizadorSession.getLocalizadorCont());
			}
			//meto datos en el form				
			form.setDatosSalida((Collection)lista);
			String identificador=request.getParameter("identificador");
			if (visualizadorSession == null) {
				identificador = request.getParameter("identificador");
			}
			else {
				identificador = visualizadorSession.getIdentificador();
			}
			form.setIdentificador(identificador);
			String usuario= LdapUserDetailsUtils.getUsuario();//request.getParameter("usuario");
			if (usuario==null) {
				usuario=visualizadorSession.getUsuario();
			}
			form.setUsuario(usuario);
			form.setLocalizacion(visualizadorSession.getLocalizadorCont());
			
    		//vemos si mostramos los items abiertos o cerrados
            if(orgs !=null && visualizadorSession.isAbiertos()){
            	boolean abiertos = true;
    	        for(int i = 0; i < orgs.length && abiertos; i++){
    	        	OrganizacionVO organizacion = orgs[i];
    	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
    	        		abiertos = this.mostrarAbiertos(organizacion.getItems());
    	        		visualizadorSession.setAbiertos(abiertos);
    	        	}
    			}
            }
            
            //ruta del nodo seleccionado
            
            if(orgs !=null){
            	boolean encontrada = false;
            	ArrayList rutaSeleccionado = new ArrayList();
            	for(int i = 0; i < orgs.length && !encontrada; i++){
    	        	OrganizacionVO organizacion = orgs[i];
    	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
    	        		
    	        		encontrada = this.rutaIdSeleccionado(visualizadorSession.getIdSeleccionado(), orgs[i].getItems(), rutaSeleccionado);
    	        		
    	        	}
    			}
    	        if (encontrada)
                	visualizadorSession.setRutaSeleccionado(rutaSeleccionado);
            }
            
			
		}
		catch (Exception ex)
    	{

			logger
			.error("Error en Servicio de visualizador de contenidos, metodo nodoOnClick " + ex);
			logger.error(ex);
    	}
			
	
    }




//metodo de prueba: vamos a borrar del array el ItemVO que tenga ese identificador
    public boolean estaItemDVector(String idItem, ItemVO[] items) {
    	boolean enc=false;
    	if ((items!=null) && (items.length>0)) {
    		int id=0;
    		while ((!enc) && ( id<items.length)) {
    			if (idItem.equals(items[id].getIdItem())) {
    				enc=true;
    			}
    			id++;
    		}
    	}
 		return enc;
   }
//////////////////////////////////
    public final void nodoOnClickBoton(
    		ActionMapping mapping, 
    		es.pode.presentacion.visualizador.NodoOnClickBotonForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {

		
		VisualizadorSession visualizadorSession = this.getVisualizadorSession(request);
		String urlContenido=null;
		ArrayList lClicables = new ArrayList();
		int contador=form.getContador();
		ItemVO[] itemsHermanos = (ItemVO[])visualizadorSession.getItemsFlow().toArray(new ItemVO[visualizadorSession.getItemsFlow().size()]);
		
		if (contador>=0) {
			if (contador <= itemsHermanos.length) {
				// nos quedamos con itemsHermanos[contador]
				if ((itemsHermanos[contador].getSecuenciaItem()!= null) 
					&& (itemsHermanos[contador].getSecuenciaItem().getControlMode()!=null)) {
					//Comprobamos su secuencia Choice Exit
//					if (!itemsHermanos[contador].getSecuenciaItem().getControlMode().getChoiceExit().booleanValue()) {
//						
//						for (int ci=0; ci< itemsHermanos.length; ci++) {
//							if (!(itemsHermanos[contador].getIdItem().equals(itemsHermanos[ci].getIdItem()))) {
//								//ponemos todos los demas a false
//								itemsHermanos[ci].setClicable(new Boolean(false));
//							}
//						}
//					}
					// Aplicamos el flow y forward only si lo tiene
					String idOrg=itemsHermanos[contador].getIdOrg();
					ItemVO[] items= (ItemVO[]) hOrganizaciones.get(idOrg);
					if (!itemsHermanos[contador].getSecuenciaItem().getControlMode().getChoiceExit().booleanValue()) {
						// Choice Exit: ponemos los hermanso a false y todos los descendientes de los hermanos 
						int indicePrimerHijo=-1;
						for (int h=0; h<items.length; h++){
							if (items[h].getIdPadre().equals(itemsHermanos[contador].getIdPadre())) {
								items[h].setClicable(new Boolean(false));
								ArrayList l = new ArrayList();
								l=getIndexPrimerHijo(items,h, l);
								if (!l.isEmpty()) {
									indicePrimerHijo = Integer.parseInt(l.get(l.size() -1).toString());
									if (indicePrimerHijo >-1)
										for (int ind=indicePrimerHijo; ind<h; ind++) {
											items[ind].setClicable(new Boolean(false));
										}
								}
								
							}

						}
					}//Fin Choice Exit
					
					// Vuelvo a meter el array en la Hash
					hOrganizaciones.put(idOrg, items);

					//ajustamos el vector de itemsFlow, para que contenga los valores que deben llevar los botones!!
					if ((itemsHermanos[contador].getSecuenciaItem()!=null) && (itemsHermanos[contador].getSecuenciaItem().getControlMode()!=null)
						&& (itemsHermanos[contador].getSecuenciaItem().getControlMode().getFlow().booleanValue())) {
								ArrayList mezclaItems = new ArrayList();								
								//miramos los hijos directos 
								if ((itemsHermanos[contador].getItemHijos()!=null) && (itemsHermanos[contador].getItemHijos().length>0)) {
									ItemVO[] hijosDirvo=itemsHermanos[contador].getItemHijos();
									//monto el array con la mezcla explosiva!!
									for (int li=0; li<=contador;li++){
									  mezclaItems.add(itemsHermanos[li]);
									}
									// miro si el primer hijo está ya en el array si no esta lo meto
									if (!(estaItemDVector(hijosDirvo[0].getIdItem(),itemsHermanos))) {
									  //meto los hijos del elemento de contador
									  for (int hi=0;hi<hijosDirvo.length;hi++) {
										mezclaItems.add(hijosDirvo[hi]);
									  }
									}
									//meto el resto
									if (contador+1 <=itemsHermanos.length) {
									   for (int ji=contador+1; ji<itemsHermanos.length;ji++) {
										 mezclaItems.add(itemsHermanos[ji]);
									   }
									}
									itemsHermanos =(ItemVO[])mezclaItems.toArray(new ItemVO[mezclaItems.size()]);
								}
								// metemos todo en sesion, como mas abajo utilizamos itemsHeramos, lo renombramos con los datos
								//actuales para que se le apliquen los cambios
							   
							   visualizadorSession.setItemsFlow(Arrays.asList(itemsHermanos));
							   // en este caso que tiene hijos y flow a true, ponemos los botones izq y drcho a true
							   //BOTONES ACTUALIZADOS
							   visualizadorSession.setBtnIzquierdo(new Boolean(true));
							   visualizadorSession.setBtnDerecho(new Boolean(true));
							} else {
								visualizadorSession.setItemsFlow(Arrays.asList(itemsHermanos));
							}
					//////
					//visualizadorSession.setItemsFlow(lClicables);
				}
				//Si es Forward
				List lista=null;
				if(form.getDatosSalida()!=null)
					lista= Arrays.asList(form.getDatosSalida().toArray());
				if(lista==null){
					lista=Arrays.asList(visualizadorSession.getDatosSalida().toArray());
				}
				OrganizacionVO[] organizaciones=(OrganizacionVO[])lista.toArray(new OrganizacionVO[lista.size()]);
				String idPadre=itemsHermanos[contador].getIdPadre();
				//Miramos si es una organizacion el padre 
				int posiOrg=-1;
				boolean padreEsOrgYForward=false;
				//Miramos si el padre es una organizacion
				for(int i=0;i<organizaciones.length;i++){
					if(organizaciones[i].getIdOrg().equals(idPadre)){
						SecuenciaVO secuenciaPadre=organizaciones[i].getSecuenciaOrg();
						//Miramos si el padre es un forwardOnly
						if(secuenciaPadre.getControlMode().getForwardOnly().booleanValue()){
							for(int j=0;j<contador;j++){//Ponemos todos los items anteriores a no clicables
								itemsHermanos[j].setClicable(new Boolean (false));
								
							}
							padreEsOrgYForward=true;
							//ponemos a false la flecha izquierda
							visualizadorSession.setBtnIzquierdo(new Boolean(false));
						}
						posiOrg=i;
					}
				}
				
					
					ItemVO[] enPreorden =null;
					int k=0;
					if(posiOrg>=0){//Si lo hemos encontrado en las organizaciones lo ponemos enPreorden
						enPreorden =recorreArbolPreorden(orgs[posiOrg]);
						
					}else{//Si no lo hemos encontrado en las organizaciones, lo buscamos en la variable global y lo ponemos enPreorden
						
						boolean orgEncontrada=false;
						while(k<orgs.length && !orgEncontrada){
							enPreorden = recorreArbolPreorden(orgs[k]);
							for(int l=0;l<enPreorden.length && !orgEncontrada;l++){
								if(enPreorden[l].getIdPadre().equals(idPadre)){
									orgEncontrada=true;									
								}else{
									k++;
								}
							}
						}
					}
					boolean encontrado=false;
					if(padreEsOrgYForward){//Si el padre es organizacion y forwardOnly buscamos en el preorden el item correspondiente
						for(int i=0;i<enPreorden.length&& !encontrado;i++){
//							enPreorden[i].setClicable(new Boolean(false));//Lo que está mal
							if(enPreorden[i].getIdItem().equals(itemsHermanos[contador].getIdItem())){
								encontrado=true;
								if(contador-1>=0){
									ItemVO itemAnterior = itemsHermanos[contador-1];
//									int n=0;
									for(int j=0;j<enPreorden.length&& !enPreorden[j].getIdItem().equals(itemAnterior.getIdItem());j++){
//										n++;
										enPreorden[j].setClicable(new Boolean(false));
									}
//									if(n>=0){
//										for(int l=0;l<n;l++){
//											enPreorden[l].setClicable(new Boolean(false));
//										}
//									}
								}
							}
						}
					}else{// Si el padre no es organizacion buscamos el padre en el preorden, pues será un item
						for(int m=0;m<enPreorden.length;m++){
							if(enPreorden[m].getIdItem().equals(idPadre)){
								SecuenciaVO secuenciaItem=enPreorden[m].getSecuenciaItem();//Miramos si al encontrarlo es un forwardOnly
								if(secuenciaItem!=null && secuenciaItem.getControlMode()!=null && secuenciaItem.getControlMode().getForwardOnly().booleanValue()){
									for(int j=0;j<m;j++){//Si lo es todos los items anteriores los ponemos no clicables
										enPreorden[j].setClicable(new Boolean (false));												
									}
									//como forward only es true se invalida la flecha izquierda
									visualizadorSession.setBtnIzquierdo(new Boolean(false));
								}
								
							}
						}
					}
				if ((itemsHermanos[contador].getRecurso()!=null) && 
						itemsHermanos[contador].getRecurso().getHrefRec()!= null) {
					String contenido = itemsHermanos[contador].getRecurso().getHrefRec();
					urlContenido = visualizadorSession.getLocalizadorCont() + "/" + contenido;
					int co = -1;
					if( urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTP) >=0)
						co = urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTP);
					else if( urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTPS) >=0)
						co = urlContenido.toLowerCase().indexOf(PROTOCOLO_HTTPS);
						
					
					if (co < 0) {//pner tb en botones
						//String host =AgregaPropertiesImpl.getInstance().getProperty("host");
						String server = request.getServerName();
						if (server.equals(LOCALHOST) && DecisorOffline.esOffline())
							server = server + ":" + request.getServerPort();
						else
							server = server + LdapUserDetailsUtils.getSubdominio() ;
						
    					urlContenido = PROTOCOLO_HTTP + server + urlContenido;
    					
					}else
					{
						urlContenido =contenido.substring(co);
					}

				} else {
					urlContenido= "";
				}
				//contenido a mostrar

				String encoding = response.getCharacterEncoding();
				urlContenido = TransformarURL.transformaUrl(encoding, urlContenido);
				visualizadorSession.setUrlContenido(urlContenido);
				visualizadorSession.setContador(contador); // lo modificamos
				visualizadorSession.setIdSeleccionado(itemsHermanos[contador].getIdItem());
			}
			
			
		}
		// si tiene contenido hay que mostrarlo
		
		form.setDatosSalida(visualizadorSession.getDatosSalida());
		String identificador=request.getParameter("identificador");
		if (identificador==null) {
			identificador= visualizadorSession.getIdentificador();
		}
		form.setIdentificador(identificador);
		String usuario= LdapUserDetailsUtils.getUsuario();//request.getParameter("usuario");
		if (usuario==null) {
			usuario=visualizadorSession.getUsuario();
		}
		form.setUsuario(usuario);
		
		//vemos si mostramos los items abiertos o cerrados
        if(orgs !=null && visualizadorSession.isAbiertos()){
        	boolean abiertos = true;
	        for(int i = 0; i < orgs.length && abiertos; i++){
	        	OrganizacionVO organizacion = orgs[i];
	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
	        		abiertos = this.mostrarAbiertos(organizacion.getItems());
	        		visualizadorSession.setAbiertos(abiertos);
	        	}
			}
        }
        
        //ruta del nodo seleccionado
        
        if(orgs !=null){
        	boolean encontrada = false;
        	ArrayList rutaSeleccionado = new ArrayList();
        	for(int i = 0; i < orgs.length && !encontrada; i++){
	        	OrganizacionVO organizacion = orgs[i];
	        	if(organizacion != null && organizacion.getItems()!=null && organizacion.getItems().length>0){
	        		
	        		encontrada = this.rutaIdSeleccionado(visualizadorSession.getIdSeleccionado(), orgs[i].getItems(), rutaSeleccionado);
	        		
	        	}
			}
	        if (encontrada)
            	visualizadorSession.setRutaSeleccionado(rutaSeleccionado);
        }
		
    }







    public final void finSession(
    		ActionMapping mapping, 
    		es.pode.presentacion.visualizador.FinSessionForm form, 
    		HttpServletRequest request, HttpServletResponse response) 
    throws Exception
    {

		//No borramos los datos de la sesion al iniciar el previsualizador 
		// ya que da problemas con los datos del usuario que Acegi lo guarda en sesion 
		//request.getSession().removeAttribute(es.pode.presentacion.VisualizadorSession.SESSION_KEY);
		//Iniciamos Una nueva sesion
		VisualizadorSession visualizadorSession = this.getVisualizadorSession(request);	
		String identificador = request.getParameter("identificador");
		if (LdapUserDetailsUtils.estaAutenticado()) {
			String usuario = LdapUserDetailsUtils.getUsuario();//request.getParameter("usuario");
			//los metemos en sesion
			visualizadorSession.setIdentificador(identificador);
			visualizadorSession.setUsuario(usuario);
			//Inicializamos ahora aqui los botones y el contador
			visualizadorSession.setBtnDerecho(new Boolean(false));
			visualizadorSession.setBtnIzquierdo(new Boolean(false));
			visualizadorSession.setContador(-1); // lo inicializamos a -1
			visualizadorSession.setIdSeleccionado("");
			visualizadorSession.setTituloOde("");
			visualizadorSession.setUrlContenido("");
			visualizadorSession.setLocalizadorCont("");
			visualizadorSession.setDatosSalida(null);
			visualizadorSession.setItemsFlow(null);
			/*
			 * fjespino: Parametro urlCerrar para que la herramienta offline pueda abrir el visualizador en la misma pantalla.
			 */
			visualizadorSession.setUrlCerrar(request.getParameter("urlCerrar"));
			if( logger.isDebugEnabled() ){
				logger.debug("VISUALIZADOR, FINSESSION, USUARIO AUTENTICADO " + usuario);
			}
		} else {
			if( logger.isDebugEnabled() ){
				logger.debug("VISUALIZADOR, FINSESSION, USUARIO SIN AUTENTICAR ");
			}
		}
	}


	// funcion que recorre el arbol en preorden y guarda los items que tienen contenido
	private void contenidosArbolPre (ItemVO[] items, ArrayList lista) {
		if ((items!=null) && items.length>0) {
			for (int j=0; j<items.length;j++) {
				if ((items[j].getRecurso()!=null) && (items[j].getRecurso().getHrefRec()!=null)) {
					lista.add(items[j]);
				}else if ((items[j].getItemHijos()!=null) && (items[j].getItemHijos().length>0)) {
					contenidosArbolPre(items[j].getItemHijos(), lista);
				}
			}
		}
	}
	////////////////////////////////////////////////////////////////


	
	
	public ItemVO[] recorreArbolPreorden(OrganizacionVO organizacionVO){
		
		ArrayList itemPreorden=new ArrayList();
		
		if (organizacionVO !=null){
			ItemVO[] itemVO=organizacionVO.getItems();
			if(itemVO!=null){
				 for( int j=0;j<itemVO.length;j++){
					 consigueItems(itemVO[j], itemPreorden);
							 
				 }
			}
		}
		return (ItemVO[])itemPreorden.toArray(new ItemVO[itemPreorden.size()]);
	}
	
	public ArrayList consigueItems(ItemVO itemVO, ArrayList item){

		ItemVO[] itemVO1=itemVO.getItemHijos();
		if(itemVO1!=null){
			for(int k=0;k<itemVO1.length;k++){
			consigueItems(itemVO1[k],  item);

			}
			item.add(itemVO);
			
		}else{
			item.add(itemVO);
		}
		return item;
	}
	
	private ArrayList getIndexPrimerHijo(ItemVO[] items , int posPadre, ArrayList l) {
		int index=-1;
		boolean encontrado=false;
		int cont=0;
		
		while ((cont<items.length) && (!encontrado)) {
			if (items[cont].getIdPadre().equals(items[posPadre].getIdItem())) {
				encontrado=true;
				l.add(new Integer(cont));
				getIndexPrimerHijo(items, cont, l);
				
			} else {
				cont++;
			}
		}
		return l;
	}
	
	private ItemVO[] interpretaChoice (ItemVO[] items) {
		int indicePrimerHijo=-1;
		for (int i=0; i<items.length; i++) {
			if ((items[i].getSecuenciaItem()!=null) && (items[i].getSecuenciaItem().getControlMode()!=null)) {
				if (items[i].getSecuenciaItem().getControlMode().getChoice().booleanValue()) {
					for (int ji=0; ji<items.length; ji++) {
						if (items[ji].getIdPadre().equals(items[i].getIdItem())) {
							//clicables
							items[ji].setClicable(new Boolean(true));
						}
					}
				} else  {
					//sus descendientes no visibles
					ArrayList l = new ArrayList();
					l=getIndexPrimerHijo(items,i, l);
					if (!l.isEmpty()) {
						indicePrimerHijo = Integer.parseInt(l.get(l.size() -1).toString());
						if (indicePrimerHijo>-1) 
							for (int ind=indicePrimerHijo; ind<i; ind++) {
								items[ind].setClicable(new Boolean(false));
							}	
					}
					
				}
			} else { //ponemos a sus hijos lo que el tenga (clicable/no clicable)
				for (int ji=0; ji<items.length; ji++) {
					if (items[ji].getIdPadre().equals(items[i].getIdItem())) {
						items[ji].setClicable(items[i].getClicable());
					}
				}
			}
		}
		return items;
	}
	
	// funcion que recorre el arbol en preorden y guarda los items que tienen contenido
	private void ContenidosArbolPre (ItemVO[] items, ArrayList lista) {
		if ((items!=null) && items.length>0) {
			for (int j=0; j<items.length;j++) {
				if ((items[j].getRecurso()!=null) && (items[j].getRecurso().getHrefRec()!=null)) {
					lista.add(items[j]);
				}else if ((items[j].getItemHijos()!=null) && (items[j].getItemHijos().length>0)) {
					ContenidosArbolPre(items[j].getItemHijos(), lista);
				}
			}
		}
		
	}
	////////////////////////////////////////////////////////////////



	private String generarUrlFicha(HttpServletRequest request)
	{
		String urlImagen = ""; 
		String textoAlt="";
		String urlFicha="";
		String servidor=PROTOCOLO_HTTP + request.getServerName() +LdapUserDetailsUtils.getSubdominio();
		
		VisualizadorSession sesion= this.getVisualizadorSession(request);
		
		ParametroMetadatoVO paramMetadato= new ParametroMetadatoVO();
    	paramMetadato.setIdentificadorODE(sesion.getIdentificador());
    	paramMetadato.setIdioma(sesion.getIdiomaCat());
    	paramMetadato.setBusquedaSimpleAvanzada(POSICIONADO_DETALLE);
    	logger.debug("\n\ngernarUrlFicha");
    	logger.debug("identificador: " + sesion.getIdentificador());
    	logger.debug("idioma: " + sesion.getIdiomaCat());
    	logger.debug("BusquedaSimpleAvanzada: " + POSICIONADO_DETALLE);
    	
    	MetadatoBasicoVO metadato=null;
    	
    	try {
			metadato= this.getSrvBuscarService().solicitarMetadato(paramMetadato);
		} catch (Exception e) {
			logger.error("no se pudo obtener el metadato correspondiente por un error en el servicio SrvBuscarService.." , e);
		}
		
		if(metadato!=null && metadato.getImagen()!=null)
		{
			urlImagen=servidor + BARRA + metadato.getImagen();
		}
		else
		{
			urlImagen=servidor + BARRA + AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
		}
		logger.debug("urlImagen: " + urlImagen);
		
		textoAlt = sesion.getTituloOde();
		urlFicha = servidor 
					+ BARRA + request.getSession().getServletContext().getInitParameter(DETALLE_CORTA) 
					+ BARRA + sesion.getIdiomaCat() 
					+ BARRA + sesion.getIdentificador() ;
		
		StringBuffer resultado= new StringBuffer();
		resultado.append("<a href='"+ urlFicha+ "' target='_blank'>");
		resultado.append("<img src='" + urlImagen + "' alt='" + textoAlt + "' title='" + sesion.getIdentificador() + "'>");
		resultado.append("</a>");
		return resultado.toString();
	}
	
	private boolean mostrarAbiertos(ItemVO[] items){
		boolean abiertos = true;
		if(items.length>4)
			abiertos = false;
		else{
			for(int i = 0; i < items.length && abiertos; i++){
				ItemVO item = items[i];
				if(abiertos && item.getItemHijos()!=null && item.getItemHijos().length >0){
					abiertos = mostrarAbiertos(item.getItemHijos());
				}
			}
		}
		return abiertos;
	}
	
	private boolean rutaIdSeleccionado(String idSelec, ItemVO[] items, ArrayList rutaActual){
		ArrayList ruta = new ArrayList();
		boolean enc = false;
		for(int i=0; i < items.length && !enc ; i++){
			ItemVO item = items[i];
			rutaActual.add(item.getIdItem());
			if(idSelec.equals(item.getIdItem())){
				enc = true;
			}
			else if (item!=null && item.getItemHijos()!=null && item.getItemHijos().length >0){
				enc = rutaIdSeleccionado(idSelec, item.getItemHijos(), rutaActual);
				if(!enc){
					rutaActual.remove(rutaActual.size() -1);
				}
			}else{
				if(!enc){
					rutaActual.remove(rutaActual.size() -1);
				}
			}
			
			
		}
		
		
		return enc;
		
	}
}
