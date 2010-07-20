/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.auditoria.negocio.servicios.NumeroOperacionesVO;
import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl;
import es.pode.buscador.presentacion.basico.descargar.DescargarControllerImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.buscar.servicios.MetadatoBasicoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO;
import es.pode.buscar.negocio.buscar.servicios.SrvBuscarService;
import es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService;
import es.pode.entregar.negocio.servicios.PaquetePifVO;
import es.pode.entregar.negocio.servicios.SrvEntregarService;
import es.pode.entregar.negocio.servicios.TipoPifVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.estadisticas.EstadisticasProperties;
import es.pode.soporte.estadisticas.EstadisticasPropertiesImpl;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.buscador.presentacion.IBuscadorConstants;


/**
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController
 */
public class DetallarControllerImpl extends DetallarController{
	
   private static final long serialVersionUID = -8190956967834990490L;

	private java.util.Properties pSpringProperties = null;
	public static final String LAYOUT_BUSCADOR = "BUSCADOR";
	public static final String LAYOUT_EMPAQUETADOR = "EMPAQUETADOR";
	public static final String LAYOUT_FEDERADO = "FEDERADO";
	public static final String LAYOUT_NEUTRO = "NEUTRO";
	public static final String TRUE = "true";
	public static final String USUARIO_LOGADO = "USUARIO_LOGADO";
	public static final String USUARIO_NO_LOGADO = "USUARIO_NO_LOGADO";
	public static final String BUSCAR = "BUSCAR";
	public static final String BUSCARRSS = "BUSCARRSS";
	public static final String BUSCAR_SIMPLE = "BUSCAR_SIMPLE";
	public static final String BUSQUEDA_FEDERADA = "BUSQUEDA_FEDERADA";
	public static final String BUSQUEDA_ARBOL = "BUSQUEDA_ARBOL";
	public static final String BUSQUEDA_TESAURO = "BUSQUEDA_TESAURO";
	public static final String BUSQUEDA_DETALLE = "BUSQUEDA_DETALLE";
	public static final String DETALLE_FEDERADO="DETALLE_FEDERADO";
	public static final String SEPARADOR_PALABRAS = " ";
	public static final String AMBITO_UNIVERSAL = "universal";
	public static final String IDENTIFICADOR_NODO = "server.id";
	public static final String GUION = "-";
	private final static String POSICIONADO_DETALLE = "POSICIONADO_DETALLE";
	private final static String DETALLE_SIN_POSICIONAMIENTO = "DETALLE_SIN_POSICIONAMIENTO";
	private final static String ODE_LOCAL = "ODE_LOCAL";
	private final static String ODE_FEDERADO = "ODE_FEDERADO";
	public final static String HTML_QUOTES = "&quot;";
	public static final String JAVA_QUOTES = "\"";
	public final static String DOT = "\\.";
	public final static String COMA = "\\,";
	public final static String SLASH = "\\/";
	public final static String DOUBLE_DOT = "\\:";
	public final static String OPEN_QUESTIONMARK = "\\�";
	public final static String CLOSE_QUESTIONMARK = "\\?";
	public final static String OPEN_EXCLAMATIONMARK = "\\�";
	public final static String CLOSE_EXCLAMATIONMARK = "\\!";
	public final static String OPEN_PARENTHESES = "\\(";
	public final static String CLOSE_PARENTHESES = "\\)";
	private final static String ANTERIOR = "ANTERIOR";
	private final static String SIGUIENTE = "SIGUIENTE";
	private final static String MENSAJE_ERROR_DETALLES = "listar.odecu.mostrar.resultados.detalles.errorObteniendoDetalles";
	public final static String MENSAJE_TRADUCCION_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorTraduccionBusqueda";
	public final static String MENSAJE_OBTENCION_VALORACION = "listar.odecu.mostrar.resultados.consulta.cabecera.errorObtencionValoracion";
	public final static String MENSAJE_OBTENCION_ESTADISTICA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorObtencionEstadistica";
	public final static String MENSAJE_AGREGACION_ODE = "listar.odecu.mostrar.resultados.consulta.detalles.errorAgregacionOde";
	public final static String MENSAJE_IDIOMAS_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorIdiomasBusqueda";
	public final static String MENSAJE_OBTENCION_TAGS = "listar.odecu.mostrar.resultados.consulta.cabecera.errorObtencionTag";
	public final static String ERROR_OBTENIENDO_VALORACION = "introducir.comentarios.ode.errorObteniendoValoracion";
	private final static String ERROR_INSERTANDO_VALORACION = "introducir.comentarios.ode.errorInsertandoValoracion";
	private static Logger logger = Logger.getLogger(DetallarControllerImpl.class);

	/**
     * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#buscarDetalleODE(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.detallar.BuscarDetalleODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void buscarDetalleODE(ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.BuscarDetalleODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    		//aqu� ya no llega el nodoOrigen, mirar a ver d�nde se pierde
    		List errorMessages = new ArrayList();
    		String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	        BuscarSession sesion = this.getBuscarSession(request);
			if (sesion == null) {
				BuscarSession session = new BuscarSession();
				this.setBuscarSession(request, session);
				logger.debug("DetallarControllerImpl - buscarDetalleODE: Sesion de busqueda creada en busqueda avanzada. La sesion estaba vacia.");
			}
			if(form.getMostrarVuelta()==null || form.getMostrarVuelta().equals(""))form.setMostrarVuelta(new Boolean(mostrarVuelta(form)));
			if(sesion.getExisteSesion()==null || sesion.getExisteSesion().booleanValue()){
				form.setExisteSesion(new Boolean(existeSesion(sesion) || (form.getNodoOrigen()!=null && !form.getNodoOrigen().equals(""))));
				sesion.setExisteSesion(form.getExisteSesion());
			}
			if(form.getNodoOrigen()!=null && !form.getNodoOrigen().equals("") && !form.getTipoLayoutBuscador().equals(LAYOUT_EMPAQUETADOR)){
				form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_FEDERADO);
				sesion.setPosicionamientoAnterior(form.getPosicionamientoAnterior());
				sesion.setPosicionamientoSiguiente(form.getPosicionamientoSiguiente());
				sesion.setNodoOrigen(form.getNodoOrigen());
			}else if(form.getPosicionamientoAnterior()==null && form.getPosicionamientoSiguiente()==null){
				form.setPosicionamientoAnterior(sesion.getPosicionamientoAnterior());
				form.setPosicionamientoSiguiente(sesion.getPosicionamientoSiguiente());
			}
			if(form.getTipoLayoutBuscador()==null){
	        	try{
			    	if(DetallarControllerImpl.TRUE.equals(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO))) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_NEUTRO);
			    	else form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
	        	}catch(Exception e){
	        		logger.debug("No existe la propiedad neutro del agregaProperties");
	        		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);	        		
	        	}
		    	
	        }
	        log("DetallarControllerImpl - buscarDetalleODE: Detallar ODE con identificadorODE ["+form.getIdentificadorODE()+"] e idioma de busqueda["+form.getIdioma()+"]");
	    	ParametroMetadatoVO parametroMetadato = new ParametroMetadatoVO(form.getIdentificadorODE(),form.getIdioma(),POSICIONADO_DETALLE);
	    	MetadatoBasicoVO metadatos = this.getSrvBuscarService().solicitarMetadato(parametroMetadato);
	    	log("DetallarControllerImpl - buscarDetalleODE: Se han solicitado metadatos, comienza la traduccion");
    		String terminosTraducidos = traducirTerminos(new String []{metadatos.getIdioma()},getPropertyValue("idioma"),getPropertyValue("idioma.terminos"),idiomaNavegacion);
    		if(terminosTraducidos!=null)form.setIdiomaODE(I18n.getInstance().obtenerIdiomaTraducido(terminosTraducidos,idiomaNavegacion));
    		else{
    			form.setIdioma("");
    			logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error al obtener idioma =["+metadatos.getIdioma()+"]");
        		errorMessages.add(MENSAJE_TRADUCCION_BUSQUEDA);
        	}
    		terminosTraducidos = traducirTerminos(metadatos.getLicencias(),getPropertyValue("licencias"),getPropertyValue("idioma.terminos"),idiomaNavegacion);
    		if(terminosTraducidos!=null)form.setLicencias(terminosTraducidos);
    		else{
    			logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error al obtener licencias =["+metadatos.getLicencias()+"]");
    			if(metadatos.getLicencias()!=null)form.setLicencias(concatenaArrayString(metadatos.getLicencias()));
    			else form.setLicencias("");
        		errorMessages.add(MENSAJE_TRADUCCION_BUSQUEDA);
        	}
    		terminosTraducidos = traducirTerminos(metadatos.getDestinatarios(),getPropertyValue("destinatarios"),getPropertyValue("idioma.terminos"),idiomaNavegacion);
    		if(terminosTraducidos!=null)form.setDestinatarios(terminosTraducidos);
    		else{
    			logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error al obtener licencias =["+metadatos.getDestinatarios()+"]");
    			form.setDestinatarios("");
        		errorMessages.add(MENSAJE_TRADUCCION_BUSQUEDA);
        	}
    		form.setFormato(concatenaArrayString(metadatos.getFormato()));
    		form.setTitulo(metadatos.getTitulo());
			//Introducimos el valor del titulo en la sesion
			if(form.getTipoLayoutBuscador()!=null && form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_EMPAQUETADOR))logger.debug("DetallarControllerImpl - agregarOdes: Se agrega ode federado al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador());
			if(form.getBusquedaSimpleAvanzada()!=null && !form.getBusquedaSimpleAvanzada().equals(""))sesion.setBusquedaSimpleAvanzada(form.getBusquedaSimpleAvanzada());
			else if(sesion.getBusquedaSimpleAvanzada()!=null && !sesion.getBusquedaSimpleAvanzada().equals(""))form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
			if(form.getNodoOrigen()!=null && !form.getNodoOrigen().equals(""))sesion.setNodoOrigen(form.getNodoOrigen());
			else if(sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().equals(""))form.setNodoOrigen(sesion.getNodoOrigen());
			if(form.getAreaCurricularBusqueda()!=null && !form.getAreaCurricularBusqueda().equals(""))sesion.setAreaCurricularBusqueda(form.getAreaCurricularBusqueda());
			if(form.getTesauroBusqueda()!=null && !form.getTesauroBusqueda().equals(""))sesion.setTesauroBusqueda(form.getTesauroBusqueda());
			if(form.getTipoBusquedaArbol()!=null && !form.getTipoBusquedaArbol().equals(""))sesion.setTipoBusquedaArbol(form.getTipoBusquedaArbol());
			sesion.setTitulo(metadatos.getTitulo());
			form.setAgregarFederado(new Boolean(false));
			form.setValoracion(metadatos.getValoracion().toString());
	        form.setDescripcion(metadatos.getDescripcion());
	        form.setLocalizadorODE(metadatos.getLocalizadorODE());
	        form.setAmbito(concatenaArrayString(metadatos.getAmbito()));
	        form.setIdentificadorODE(metadatos.getIdentificadorODE());
	        form.setTamanio(convertirMB(metadatos.getTamanio()));
	        form.setSize(metadatos.getSize());
			String resType = metadatos.getLearningResourceType();
			if (resType == null || resType.length() == 0) {
				form.setLearningResourceType(
						IBuscadorConstants.DEFAULT_RESOURCE_TYPE);
			} else {
				form.setLearningResourceType(
						metadatos.getLearningResourceType());
			}
	        form.setAnnotation(metadatos.getAnnotation());
	        form.setImagen("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+comprobarImagen(request.getServerName(),metadatos.getImagen()));
	        form.setImagenAmpliada("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+ampliarImagen (comprobarImagen(request.getServerName(),metadatos.getImagen())));
	        if (metadatos.getFechaPublicacion()!=null && !metadatos.getFechaPublicacion().equals("")){
	        	String fechaPublicacion=metadatos.getFechaPublicacion().substring(6,8) + "/" + metadatos.getFechaPublicacion().substring(4,6) + "/" + metadatos.getFechaPublicacion().substring(0,4);
	        	if(metadatos.getHoraPublicacion()!=null && !metadatos.getHoraPublicacion().equals("")) fechaPublicacion=fechaPublicacion+SEPARADOR_PALABRAS+metadatos.getHoraPublicacion().substring(0,2)+":"+metadatos.getHoraPublicacion().substring(2,4)+":"+metadatos.getHoraPublicacion().substring(4,6);
	        	form.setFechaPublicacion(fechaPublicacion);
	        }
	        //ESTADISTICAS DEL ODE
	        try{
		        NumeroOperacionesVO[] operaciones = this.getSrvAuditoriaServicio().obtenNumeroOperaciones(form.getIdentificadorODE());
		        String[] descargas = EstadisticasPropertiesImpl.getInstance().getProperty(EstadisticasProperties.PROPERTY_OPERACIONES_DESCARGA).split(",");
		        int numDescargas=0;
		        for (int i=0;i<operaciones.length;i++){
		        	for(int j=0;j<descargas.length;j++){
		        		if (operaciones[i].getOperacion().equals(descargas[j])){
		        			numDescargas = numDescargas + operaciones[i].getNumeroOperaciones();
		        			log("DetallarControllerImpl - buscarDetalleODE: La estad�stica de "+descargas[j]+" es "+operaciones[i].getNumeroOperaciones());
		        		}
		        	}
		        	if (operaciones[i].getOperacion().equals(EstadisticasPropertiesImpl.getInstance().getProperty(EstadisticasProperties.PROPERTY_OPERACIONES_VISTO))){
		        		Integer veces= new Integer (operaciones[i].getNumeroOperaciones());
		        		form.setNumVecesVisto(veces.toString());
		        	}else if (operaciones[i].getOperacion().equals(EstadisticasPropertiesImpl.getInstance().getProperty(EstadisticasProperties.PROPERTY_OPERACIONES_PREVISUALIZADO))){
		        		Integer veces= new Integer (operaciones[i].getNumeroOperaciones());
		        		form.setNumVecesPrevisualizado(veces.toString());
		        	}else if (operaciones[i].getOperacion().equals(EstadisticasPropertiesImpl.getInstance().getProperty(EstadisticasProperties.PROPERTY_OPERACIONES_ENVIO))){
		        		Integer veces= new Integer (operaciones[i].getNumeroOperaciones());
		        		form.setNumVecesEnviado(veces.toString());
		        	}
		        }
		        form.setNumVecesDescargado(String.valueOf(numDescargas));
		        log("DetallarControllerImpl - buscarDetalleODE Estad�sticas: Descargado ["+numDescargas+"] Visto ["+form.getNumVecesVisto()+"] Previsualizado ["+form.getNumVecesPrevisualizado()+"] Enviado ["+form.getNumVecesEnviado()+"]");
	        }catch(Exception ex){
	        	form.setNumVecesPrevisualizado("");
	        	form.setNumVecesEnviado("");
	        	form.setNumVecesVisto("");
	        	form.setNumVecesDescargado("");
        		logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error al obtener la estad�stica del ODE para el identificador de ode=["+form.getIdentificadorODE()+"]",ex);
        		errorMessages.add(MENSAJE_OBTENCION_ESTADISTICA);
        	}
	        
	        try{
	        	String[] etiquetas =this.getSrvTaggingServer().obtenerTagsDeOde(form.getIdentificadorODE());
	        	form.setEtiquetas(etiquetas);
	        	if (etiquetas!=null && etiquetas.length>0){
	        		form.setExistenEtiquetas(new Boolean(true));
	        	}else{
	        		form.setExistenEtiquetas(new Boolean(false));
	        	}
	        	log("DetallarControllerImpl - buscarDetalleODE: Existen ["+etiquetas.length+"] etiquetas para el ODE con identificador ["+form.getIdentificadorODE()+"]");
	        }catch(Exception ex){
	        	logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error al obtener las etiquetas del ODE para el identificador de ode=["+form.getIdentificadorODE()+"]",ex);
        		errorMessages.add(MENSAJE_OBTENCION_TAGS);
        		form.setExistenEtiquetas(new Boolean(false));
	        }
	        

	        log("DetallarControllerImpl - buscarDetalleODE: Se ha realizado la traducci�n, comienza la obtenci�n de n�mero de comentarios");
	        try{		        
		        if (this.getSrvValoracionService().obtenerComentarios(form.getIdentificadorODE())!=null){
		        	int nrComentarios = this.getSrvValoracionService().obtenerComentarios(form.getIdentificadorODE()).length;
		        	log("DetallarControllerImpl - buscarDetalleODE: Existen ["+nrComentarios+"] comentarios");
		        	form.setNrComentarios(String.valueOf(nrComentarios));
		        }else{
		        	log("DetallarControllerImpl - buscarDetalleODE: No existen comentarios");
		        	form.setNrComentarios("0");
		        }
	        }catch (Exception ex){
	        	form.setNrComentarios("0");
        		logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error al obtener la valoraci�n del ODE para el identificador de ode=["+form.getIdentificadorODE()+"]",ex);
        		errorMessages.add(MENSAJE_OBTENCION_VALORACION);
        	}
	        log("DetallarControllerImpl - buscarDetalleODE: Detalle del ODE  identificadorODE ["+form.getIdentificadorODE()+"]:idioma["+metadatos.getIdioma()+"] ambito["+concatenaArrayString(metadatos.getAmbito())+"] licencias["+concatenaArrayString(metadatos.getLicencias())+"] titulo["+metadatos.getTitulo()+"] valoracion["+metadatos.getValoracion()+"] destinatarios["+concatenaArrayString(metadatos.getDestinatarios())+"] descripcion["+metadatos.getDescripcion()+"] localizadorODE["+metadatos.getLocalizadorODE()+"] formato["+metadatos.getFormato()+"]");
	        if(form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_BUSCADOR)){
	        	try{
		        	form.setUsuarioLogado(new Boolean(LdapUserDetailsUtils.estaAutenticado()));
		        	log("DetallarControllerImpl - buscarDetalleODE: UsuarioLogado: "+form.getUsuarioLogado());
		        }catch (Exception ex){
	        		logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error obteniendo autenticacion del usuario.",ex);
	        		form.setUsuarioLogado(new Boolean(false));
	        		errorMessages.add(MENSAJE_ERROR_DETALLES);
	        	}
			}else form.setUsuarioLogado(new Boolean (false));
	        //Se analiza la secuencia
	        if(metadatos.getConSinSecuencia() == null)metadatos.setConSinSecuencia(new Boolean(false));
	        if(!form.getUsuarioLogado().booleanValue() || (form.getUsuarioLogado().booleanValue() && !metadatos.getConSinSecuencia().booleanValue()))form.setSeleccionarSecuencia(new Boolean(false));
	        else form.setSeleccionarSecuencia(new Boolean(true));
	        log("DetallarControllerImpl - buscarDetalleODE: UsuarioLogado()="+form.getUsuarioLogado().booleanValue()+" NivelAgregacion="+metadatos.getNivelAgregacion()+" SeleccionarSecuencia="+form.getSeleccionarSecuencia());
	        if(errorMessages!=null && errorMessages.size()>0){
	        	log("DetallarControllerImpl - buscarDetalleODE: Existen errores en la traduccion de terminos para el detalle="+errorMessages.toString());
				saveErrorMessage(request, errorMessages);
			}
	        log("DetallarControllerImpl - buscarDetalleODE: BuscadorEmpaquetador:"+form.getTipoLayoutBuscador());
//        Nos falta por rellenar los parametros que nos pueden hacer falta para el boton de atras.
	        rellenaFormularioDesdeSesion(request, form);  
    	}catch (java.net.ConnectException cEx){
    		logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error en la conexi�n a servicios con metadatos para ODE con identificadorODE["+form.getIdentificadorODE()+"]",cEx);
    		saveErrorMessage(request,MENSAJE_ERROR_DETALLES);
    	}catch (Exception ex){
    		logger.error("DetallarControllerImpl - buscarDetalleODE ERROR: Error en la obtencion de metadatos para ODE con identificadorODE["+form.getIdentificadorODE()+"]",ex);
    		saveErrorMessage(request,MENSAJE_ERROR_DETALLES);
    	}
     }
    
    public void valorarODE(ActionMapping mapping, ValorarODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.debug("DetallarControllerImpl - valorarODE: identificadorODE="+form.getIdentificadorODE()+" idioma="+form.getIdioma()+" valoracion="+form.getValoracion());
        Float valoracion;        
        try {
        	valoracion = new Float(form.getValoracion());
		} catch (Exception e) {
			logger.error("Error convirtiendo valoracion["+form.getValoracion()+"] a float.",e);
			saveErrorMessage(request, DetallarControllerImpl.ERROR_OBTENIENDO_VALORACION);
			return; // no progresamos la insercion del comentario.
		}
		try {
			this.getSrvValoracionService().introducirValoracion(valoracion, form.getIdentificadorODE(), LdapUserDetailsUtils.getLogin(), form.getIdioma());			
		} catch (Exception e) {
			logger.error("Error insertando valoracion con idODE["+form.getIdentificadorODE()+"] idiomaODE["+form.getIdioma()+"] y autor["+LdapUserDetailsUtils.getLogin()+"]",e);
			saveErrorMessage(request, DetallarControllerImpl.ERROR_INSERTANDO_VALORACION);
		}		
	}
    
	public void prepararQueEsEsto(ActionMapping mapping, PrepararQueEsEstoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		log("DetallarControllerImpl - prepararQueEsEsto");
	}
    
    /*
	 * Este metodo extrae de la sesion los parametros de busqueda que se han utilizado para llegar hasta esta pantalla
	 * de detalles de busqueda para poder realizar la misma busqueda y llegar a la misma pagina de resultados en el
	 * caso de que se pulse el boton de atras.
	 * */
	public String determinaAtras(ActionMapping mapping, DeterminaAtrasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Tenemos que acceder al parametro de la sesion que nos indica la ultima busqueda que se hizo,
//		desde donde se hizo (avanzada o basica) y dependiendo del resultado, rellenamos el formulario con los parametros
//		de la busqueda avanzada o basica dependiendo de a donde tengamos que ir.
		try{
			//Consultamos la sesion
			BuscarSession sesion = this.getBuscarSession(request);
			if (sesion == null || sesion.getBusquedaSimpleAvanzada()==null){
	//			Si no hay sesion, pinto la traza e invoco una busqueda simple a secas sin parametros. Esto desenvocara
	//			en una pagina de sugerencias vacia.
				logger.error("Error obteniendo la sesion al pulsar atras en los detalles de Avanzada/Basica["+form.getBusquedaSimpleAvanzada()+"]buscadorContenido["+form.getBuscadorContenido()+"]idioma["+form.getIdiomaBuscador()+"], enviamos al usuario a la busqueda simple sin argumentos.");
				form.setBuscadorContenido("");
				form.setIdiomaBuscador("");
				form.setPagina("1");
				return BUSCAR;
	//			 Si la b�squeda fue simple  o avanzada
			}else if (sesion.getBusquedaSimpleAvanzada().equals(BUSCAR)){
	//			 Si adem�s fu� federada
				if(sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().trim().equals("")){
					log("DetallarControllerImpl - determinaAtras: atras a listado busqueda federado:"+sesion.getNodoOrigen());
					response.sendRedirect("http://"+sesion.getNodoOrigen()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorAvanzado"));	
					return BUSQUEDA_FEDERADA;
				}
				log("DetallarControllerImpl - determinaAtras: atras a listado busqueda: Tipo busqueda="+sesion.getTipoBusqueda()+" busquedaSimpleAvanzada="+sesion.getBusquedaSimpleAvanzada());
				form.setTipoBusqueda(sesion.getTipoBusqueda());
				form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
				return BUSCAR;
	//			 Si la b�squeda fu� por arbol curricular
			}else if (sesion.getBusquedaSimpleAvanzada().equals(BUSQUEDA_ARBOL)){
	//			 Si adem�s fu� federada
				if(sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().trim().equals("")){
					log("DetallarControllerImpl - determinaAtras: atras a listado arbol curricular federado:"+sesion.getNodoOrigen());
					response.sendRedirect("http://"+sesion.getNodoOrigen()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorListarODEArea"));	
					return BUSQUEDA_FEDERADA;
				}
				log("DetallarControllerImpl - determinaAtras: atras a listado arbol curricular: TipoBusquedaArbol="+sesion.getTipoBusquedaArbol()+" AreaCurricularBusqueda="+sesion.getAreaCurricularBusqueda()+" Pagina="+sesion.getPagina());
				form.setTipoBusquedaArbol(sesion.getTipoBusquedaArbol());
				form.setAreaCurricularBusqueda(sesion.getAreaCurricularBusqueda());
				form.setPagina(sesion.getPagina().toString());
				return BUSQUEDA_ARBOL;
			}else if (sesion.getBusquedaSimpleAvanzada().equals(BUSQUEDA_TESAURO)){
	//			 Si adem�s fu� federada
				if(sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().trim().equals("")){
					log("DetallarControllerImpl - determinaAtras: atras a listado de tesauros federado:"+sesion.getNodoOrigen());
					response.sendRedirect("http://"+sesion.getNodoOrigen()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorListarODETesauro"));	
					return BUSQUEDA_FEDERADA;
				}
				log("DetallarControllerImpl - determinaAtras: atras a listado tesauros: TipoBusquedaArbol="+sesion.getTipoBusquedaArbol()+" IdTesauro="+sesion.getIdTesauro()+" Pagina="+sesion.getPagina());
				form.setTipoBusquedaArbol(sesion.getTipoBusquedaArbol());
				form.setTesauroBusqueda(sesion.getTesauroBusqueda());
				form.setPagina(sesion.getPagina().toString());
				return BUSQUEDA_TESAURO;
			}
		}catch (Exception ex){
    		logger.error("DetallarControllerImpl - determinaAtras ERROR: Error al determinar la vuelta.",ex);
    	}
    	return BUSCAR;
	}
	
	/* (non-Javadoc)
	 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#seleccionaCSSecuencia(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.detallar.SeleccionaCSSecuenciaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void seleccionaCSSecuencia(ActionMapping mapping, SeleccionaCSSecuenciaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Implementar el relleno del idioma de la pantalla de selecciona con sin secuencia
		try {
			log("Elige la opcion de con/sin secuencia en el ODE con identificadorODE ["+form.getIdentificadorODE()+"] e idioma de busqueda["+form.getIdiomaBuscador()+"]");
			BuscarSession sesion = this.getBuscarSession(request);
			if (sesion == null) {
				BuscarSession session = new BuscarSession();
				this.setBuscarSession(request, session);
				log("Sesion de busqueda creada en busqueda avanzada. La sesion estaba vacia.");
			}
			form.setTitulo(sesion.getTitulo()); 
			form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
			log("Detalle del ODE  identificadorODE ["+form.getIdentificadorODE()+"]:idioma["+form.getIdioma()+"]  titulo["+form.getTitulo()+"] localizadorODE["+form.getLocalizadorODE()+"]");
		}catch (Exception ex){
    		logger.error("Error en la obtencion de metadatos para ODE con identificadorODE["+form.getIdentificadorODE()+"]",ex);
    		saveErrorMessage(request, MENSAJE_ERROR_DETALLES);
    	}
	}

	public String determinaLogado(ActionMapping mapping, DeterminaLogadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			log("DetallarControllerImpl determinaLogado: SeleccionarSecuencia=["+form.getSeleccionarSecuencia()+"]");
			if (form.getSeleccionarSecuencia().booleanValue()) return USUARIO_LOGADO;
		}catch (Exception ex){
    		logger.error("DetallarControllerImpl previsualizar determinaLogado: Error determinando si usuario logado",ex);
    		saveErrorMessage(request, MENSAJE_ERROR_DETALLES);
    	}
		return USUARIO_NO_LOGADO;
	}
	
	public void agregarODEFederado(ActionMapping mapping, AgregarODEFederadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			BuscarSession sesion = this.getBuscarSession(request);
			String literalFormato = getPropertyValue(DescargarControllerImpl.FORMATO_POR_DEFECTO);
			if (sesion == null) {
				logger.error("DetallarControllerImpl - agregarODEFederado: Sesion perdida desde comienzo agregaci�n");
				form.setAgregacionCorrecta(new Boolean(false));
				saveErrorMessage(request, MENSAJE_AGREGACION_ODE);
			}else{
				try{
					log("DetallarControllerImpl - agregarODEFederado: Descargar ODE con identificadorODE ["+form.getIdentificadorODEFederado()+"] y formato["+literalFormato+"] desde["+form.getNodoDestino()+"] y url="+form.getUrlEntregar());
					try{
						log("DetallarControllerImpl - agregarODEFederado: Se agrega ode federado al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador()+" y DataHandler del ODE");
						SrvFachadaAgregarService agregarService = this.getSrvFachadaAgregarService();
						agregarService.agregarFederado(sesion.getEmpIdOde(), sesion.getEmpIdDestino(), sesion.getEmpTipoEmpaquetador(), "http://"+form.getNodoDestino()+form.getUrlEntregar());
				    	form.setAgregacionCorrecta(new Boolean(true));
			    	} catch (Exception ex){
						logger.error("DetallarControllerImpl - agregarODEFederado: Error agregando al empaquetador DataHandler del ODE con identificadorODE["+form.getIdentificadorODEFederado()+"] y formato["+literalFormato+"]",ex);
						form.setAgregacionCorrecta(new Boolean(false));
					}
					
				} catch (Exception ex){
	    			logger.error("DetallarControllerImpl - agregarODEFederado: Error en la obtencion del fichero ZIP del ODE con identificadorODE["+form.getIdentificadorODEFederado()+"] y formato["+literalFormato+"]",ex);
	    			saveErrorMessage(request, MENSAJE_AGREGACION_ODE);
	    			form.setAgregacionCorrecta(new Boolean(false));
	    		}
			}
		}catch (Exception ex){
			logger.error("DetallarControllerImpl - agregarODEFederado:Error agregando ode federado, Error en la obtencion del fichero ZIP del ODE con identificadorODE["+form.getIdentificadorODEFederado()+"] y formato por defecto ["+DescargarControllerImpl.FORMATO_POR_DEFECTO+"]",ex);
			saveErrorMessage(request, MENSAJE_AGREGACION_ODE);
		}
	}

	public String analizaEntrada(ActionMapping mapping, AnalizaEntradaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(form.getIdentificadorODEFederado()!=null && !form.getIdentificadorODEFederado().equals("")){
				log("DetallarControllerImpl - analizaEntrada: NODO DESTINO="+form.getNodoDestino()+" e identificador ODE federado="+form.getIdentificadorODEFederado());
				return DETALLE_FEDERADO;
			}else if(form.getPosicionamiento()!=null && !form.getPosicionamiento().equals("")){
				return POSICIONADO_DETALLE;
			}else if(!existeSesion(this.getBuscarSession(request))){
				return DETALLE_SIN_POSICIONAMIENTO;
			}
		}catch (Exception ex){
			logger.error("DetallarControllerImpl - analizaEntrada: Error entrada caso de uso",ex);
			saveErrorMessage(request, MENSAJE_ERROR_DETALLES);
		}
		return "DETALLE";
	}
	
	public void agregarOdes(ActionMapping mapping, AgregarOdesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			BuscarSession sesion = this.getBuscarSession(request);
			if (sesion == null) {
				if (logger.isDebugEnabled())logger.error("DetallarControllerImpl - agregarOdes: Sesion perdida desde comienzo agregaci�n");
				form.setAgregacionCorrecta(new Boolean(false));
				saveErrorMessage(request, MENSAJE_AGREGACION_ODE);
			}else{
	//			 ODE federado, devuelvo DataHandler al empaquetador
				try {
					if(sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().trim().equals("")){
						SrvEntregarService entregarService = this.getSrvEntregarService();
						PaquetePifVO resultadoEntregar = entregarService.generarPaquetePIFTipoPIF(new TipoPifVO(form.getIdentificadorODE(), getPropertyValue("descargar.formatos.SCORM_2004_VALUE"), form.getIdioma()));
						log("DetallarControllerImpl - agregarOdes: Se prepara la redireci�n al nodoOrigen["+sesion.getNodoOrigen()+"] desde nodo destino ["+request.getServerName()+"]");
						form.setTipoAgregacion("AGREGACION_FEDERADA");
						response.sendRedirect("http://"+sesion.getNodoOrigen()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorDetalle")+"?identificadorODEFederado="+form.getIdentificadorODE()+"&tipoLayoutBuscador="+LAYOUT_EMPAQUETADOR+"&nodoDestino="+request.getServerName()+"&urlEntregar="+resultadoEntregar.getHref());
					}else{
						log("DetallarControllerImpl - agregarOdes: Se agrega ode local al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador()+" e IdentificadorODE()a agregar: "+form.getIdentificadorODE());
						SrvFachadaAgregarService agregarService = this.getSrvFachadaAgregarService();
						agregarService.agregar(sesion.getEmpIdOde(), sesion.getEmpIdDestino(), sesion.getEmpTipoEmpaquetador(), form.getIdentificadorODE());
						form.setAgregacionCorrecta(new Boolean(true));
						form.setTipoAgregacion("AGREGACION_LOCAL");
						log("DetallarControllerImpl - agregarOdes: ODE agregado");
					}
				} catch (Exception ex){
	    			logger.error("DetallarControllerImpl - agregarOdes: Error agregando al empaquetador local identificadorODE["+form.getIdentificadorODE()+"]",ex);
	    			saveErrorMessage(request, MENSAJE_AGREGACION_ODE);
	    			form.setAgregacionCorrecta(new Boolean(false));
	    		}
			}
		}catch (Exception ex){
			logger.error("DetallarControllerImpl - agregarOdes ERROR: Agregando ode local desde buscador empaquetador",ex);
			saveErrorMessage(request, MENSAJE_AGREGACION_ODE);
		}
	}
	
	public String analizaAgregacion(ActionMapping mapping, AnalizaAgregacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(form.getTipoAgregacion()!=null && form.getTipoAgregacion().equals("AGREGACION_FEDERADA")) return form.getTipoAgregacion();
		}catch (Exception ex){
			logger.error("DetallarControllerImpl - analizaAgregacion ERROR: Analizando tipo agregaci�n buscador empaquetador",ex);
		}
		return "AGREGACION_LOCAL";
	}
	
	public void cargarMetadatosCatalogador(ActionMapping mapping, CargarMetadatosCatalogadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(LdapUserDetailsUtils.estaAutenticado()){
				log("DetallarControllerImpl - cargarMetadatosCatalogador: Se cargan metadatos para IdentificadorODE="+form.getIdentificadorODE());
				this.getSrvFachadaAgregarService().prepararMetadatos(form.getIdentificadorODE());
				log("DetallarControllerImpl - cargarMetadatosCatalogador: Se redirige a el catalogador con IdentificadorODE="+form.getIdentificadorODE()+", idioma="+LdapUserDetailsUtils.getIdioma()+" y usuario="+LdapUserDetailsUtils.getUsuario());
				response.sendRedirect("http://"+request.getServerName()+LdapUserDetailsUtils.getSubdominio()+"/catalogadorWeb/VerMetadatos/VerMetadatos.do?identificador="+form.getIdentificadorODE()+"&idioma="+LdapUserDetailsUtils.getIdioma()+"&usuario="+LdapUserDetailsUtils.getUsuario());
			}	
		} catch (Exception ex) {
			logger.error("DetallarControllerImpl - cargarMetadatosCatalogador ERROR: Error en la carga de metadatos en el empaquetador para IdentificadorODE="+form.getIdentificadorODE(),ex);
		}
	}
	
	public void gestionarBotonera(ActionMapping mapping, GestionarBotoneraForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			BuscarSession sesion = this.getBuscarSession(request);
			if(sesion.getPagina()!=null && form.getResultados().getResultadoBusqueda()!=null && form.getResultados().getResultadoBusqueda().length > 0){
		        for(int i = 0; i < form.getResultados().getResultadoBusqueda().length; i++){
		        	if(form.getResultados().getResultadoBusqueda()[i].getId()!=null && form.getResultados().getResultadoBusqueda()[i].getId().equals(form.getIdentificadorODE())){
		        		form.setNodoDestino(form.getResultados().getResultadoBusqueda()[i].getNodo());
		        		if(i==0 && sesion.getPagina().intValue()==1 && form.getResultados().getNumeroResultados().intValue()==1){
		        			form.setPosicionamientoAnterior("");
		        			form.setPosicionamientoSiguiente("");
		        			break;
		        		}else if(i==0 && sesion.getPagina().intValue()==1 && form.getResultados().getNumeroResultados().intValue()>1){
		        			form.setPosicionamientoAnterior("");
		        			form.setPosicionamientoSiguiente(SIGUIENTE);
		        			break;
		        		}else if(i==form.getResultados().getResultadoBusqueda().length-1 && (form.getResultados().getNumeroResultados().intValue()/sesion.getPagina().intValue())<=Integer.parseInt(request.getSession().getServletContext().getInitParameter("max_res_pagina"))){
		        			form.setPosicionamientoAnterior(ANTERIOR);
		        	        form.setPosicionamientoSiguiente("");
		        	        break;
		        		}else{
		        			form.setPosicionamientoAnterior(ANTERIOR);
		        	        form.setPosicionamientoSiguiente(SIGUIENTE);
		        	        break;
		        		}
		        	}
		        }
			}
		} catch (Exception ex) {
			logger.error("DetallarControllerImpl - gestionarBotonera ERROR: Error gestionando la botonera de posicionado",ex);
		}
	}

	public String analizaPosicionamiento(ActionMapping mapping, AnalizaPosicionamientoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			if(form.getNodoDestino() != null && !form.getNodoDestino().trim().equals("")){
				BuscarSession sesion = this.getBuscarSession(request);
				String destino = "http://"+form.getNodoDestino()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorDetalle")+
					"?idioma="+form.getIdioma()+
					"&identificadorODE="+((form.getIdentificadorODE()!=null)?form.getIdentificadorODE():"")+
					"&tipoLayoutBuscador="+((sesion.getTipoLayoutBuscador()!=null)?sesion.getTipoLayoutBuscador():DetallarControllerImpl.LAYOUT_BUSCADOR)+
					"&nodoOrigen="+((request.getServerName()!=null)?request.getServerName()+LdapUserDetailsUtils.getSubdominio():"")+
					"&posicionamientoAnterior="+form.getPosicionamientoAnterior()+
					"&posicionamientoSiguiente="+form.getPosicionamientoSiguiente()+
					"&busquedaSimpleAvanzada="+sesion.getBusquedaSimpleAvanzada();
				response.sendRedirect(destino);
				return ODE_FEDERADO;
			}
		} catch (Exception ex) {
			logger.error("DetallarControllerImpl - analizaPosicionamiento ERROR: Error analizando el posicionamiento entre local o federado",ex);
		}
		return ODE_LOCAL;
	}
	
	public void gestionarBusqueda(ActionMapping mapping, GestionarBusquedaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			SrvBuscarService buscarService = this.getSrvBuscarService();
			form.setResultados(buscarService.buscarAvanzado(cargarParametros(request,this.getBuscarSession(request).getPagina(),form.getIdioma(),this.getBuscarSession(request).getNumeroResultados(),BUSQUEDA_DETALLE)));
		}catch (Exception ex) {
			logger.error("DetallarControllerImpl - gestionarBusqueda ERROR: Error lanzando b�squeda de posicionamiento",ex);
		}
	}

	public String analizaFlujoPosicionamiento(ActionMapping mapping, AnalizaFlujoPosicionamientoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			if(form.getNodoOrigen()!=null && !form.getNodoOrigen().equals("")){
				BuscarSession sesion = this.getBuscarSession(request);
				if(sesion.getBusquedaSimpleAvanzada()!=null && sesion.getBusquedaSimpleAvanzada().equals(BUSQUEDA_ARBOL)) response.sendRedirect("http://"+form.getNodoOrigen()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorDetalle")+"?idioma="+form.getIdioma()+"&identificadorODE="+form.getIdentificadorODE()+"&posicionamiento="+form.getPosicionamiento()+"&tipoBusquedaArbol=");
				else response.sendRedirect("http://"+form.getNodoOrigen()+"/"+request.getSession().getServletContext().getInitParameter("url_buscadorDetalle")+"?idioma="+form.getIdioma()+"&identificadorODE="+form.getIdentificadorODE()+"&posicionamiento="+form.getPosicionamiento());
				return ODE_FEDERADO;
			}
		} catch (Exception ex) {
			logger.error("DetallarControllerImpl - analizaPosicionamiento ERROR: Error analizando el posicionamiento entre local o federado",ex);
		}
		return ODE_LOCAL;
	}

	public void gestionarPosicionamiento(ActionMapping mapping, GestionarPosicionamientoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			BuscarSession sesion = this.getBuscarSession(request);
			boolean posicionado = false;
			SrvBuscarService buscarService = this.getSrvBuscarService();
			ResultadoBusquedaVO resultados = buscarService.buscarAvanzado(cargarParametros(request,sesion.getPagina(), form.getIdioma(), sesion.getNumeroResultados(),BUSQUEDA_DETALLE));
			for(int i=0; i < resultados.getResultadoBusqueda().length && !posicionado; i++){
				if(form.getIdentificadorODE().equals(resultados.getResultadoBusqueda()[i].getId())){
					if(form.getPosicionamiento().equals(ANTERIOR)){
						if(i>0){
							form.setNodoDestino(resultados.getResultadoBusqueda()[i-1].getNodo());
							form.setIdentificadorODE(resultados.getResultadoBusqueda()[i-1].getId());
						}else{
							sesion.setPagina(new Integer(sesion.getPagina().intValue()-1));
							resultados = buscarService.buscarAvanzado(cargarParametros(request,sesion.getPagina(),form.getIdioma(),sesion.getNumeroResultados(),BUSQUEDA_DETALLE));
							form.setNodoDestino(resultados.getResultadoBusqueda()[resultados.getResultadoBusqueda().length-1].getNodo());
							form.setIdentificadorODE(resultados.getResultadoBusqueda()[resultados.getResultadoBusqueda().length-1].getId());
						}
						posicionado = true;
					}else if(form.getPosicionamiento().equals(SIGUIENTE)){
						if(i<resultados.getResultadoBusqueda().length-1){
							form.setNodoDestino(resultados.getResultadoBusqueda()[i+1].getNodo());
							form.setIdentificadorODE(resultados.getResultadoBusqueda()[i+1].getId());
						}else{
							sesion.setPagina(new Integer(sesion.getPagina().intValue()+1));
							resultados = buscarService.buscarAvanzado(cargarParametros(request,sesion.getPagina(),form.getIdioma(),sesion.getNumeroResultados(),BUSQUEDA_DETALLE));
							form.setNodoDestino(resultados.getResultadoBusqueda()[0].getNodo());
							form.setIdentificadorODE(resultados.getResultadoBusqueda()[0].getId());
						}
						posicionado = true;
					}
				}
			}
			form.setResultados(resultados);
		} catch (Exception ex) {
			logger.error("DetallarControllerImpl - gestionarPosicionamiento ERROR: En el posicionado dentro de la b�squeda del ode con ambito correcto que sigue o antecede.",ex);
		}
	}
	
//	M�todo que comprueba que en los campos de fecha son valores son correctos
	private void saveErrorMessage(HttpServletRequest request, List messages) throws Exception{
		log("DetallarControllerImpl - saveErrorMessage: Formulario incorrecto------------.");
		boolean encontrado;		
		if(request!=null && messages!=null && messages.size()>0){
			//Pintamos la posici�n cero de la lista
			saveErrorMessage(request, messages.get(0).toString());
			//Recorremos el vector comprobando si el mensaje de error ha sido pintado anteriormente
			for(int i = 1; messages.size() > i ; i++){ 
				encontrado = false;
				for(int j=i; j>0 ;j--){
					if(messages.get(j-1).equals(messages.get(i)))
						encontrado = true;
				}
				if(!encontrado)
					saveErrorMessage(request, messages.get(i).toString());
			}
		}
	}
    
	private void rellenaFormularioDesdeSesion(HttpServletRequest request, BuscarDetalleODEForm form){
//		Si no hay sesion introducimos valores de busqueda por defecto
		BuscarSession sesion = this.getBuscarSession(request);
		if (sesion == null) {
			sesion = new BuscarSession();
			sesion.setPagina(new Integer("1"));
			sesion.setBuscadorContenido("");
			sesion.setIdioma("");
			form.setBusquedaSimpleAvanzada(BUSCAR);
		}else if (sesion.getBusquedaSimpleAvanzada()==null || sesion.getBusquedaSimpleAvanzada().equals(BUSCAR)){
			form.setBusquedaSimpleAvanzada(BUSCAR);
			log("Hemos detectado el boton atras de detalles seleccionado desde busqueda AVANZADA");
		}else if (sesion.getBusquedaSimpleAvanzada().equals(BUSQUEDA_ARBOL)){
			form.setBusquedaSimpleAvanzada(BUSQUEDA_ARBOL);
			log("Hemos detectado el boton atras de detalles seleccionado desde BUSQUEDA_ARBOL");
		}
	}
	
	private String convertirMB(String string){
		try{
			BigDecimal tamanio=new BigDecimal(string);
	        BigDecimal pasarMB=new BigDecimal(1048576);
	  
	        BigDecimal tamanioMB=tamanio.divide(pasarMB,2,2);
	    	return String.valueOf(tamanioMB) ;
		}catch(Exception ex){
			if (logger.isDebugEnabled())logger.error("El formato del tama�o del ODE no es correcto");
			return "0.00";
		}
    }
	
    private String concatenaArrayString(String[] string){
    	String salida = "";
    	if (string!=null && string.length >0) {
    		String[] array = string;
	    	for (int i = 0; i < array.length; i++) {
	    		if (salida.equals("")) salida = array[0];
	    		else salida=salida + ", " + array[i];	    			
			}
    	}
    	return salida;
    }

    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		logger.debug("Propiedad recuperada: " + sKey + " : "
				+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
    
//    Tenemos terminos en ingles que queremos traducir al castellano. Cada termino pertenece a un vocabulario y le
//    corresponde un identificador dentro de ese vocabulario que tambien tiene un identificador.
//    Recibe un String con los destinatarios separados por ":" y los devuelve traducidos separados por ","
    private String traducirTerminos(String[] terminos, String identificadorVocabulario, String idiomaTerminos,String idiomaNavegacion) throws Exception{
    	String salida = null;
		if (terminos!=null) {
			TerminoYPadreVO terminoTraducido=null;
			for (int i = 0; i < terminos.length; i++) {
//	    			Ahora tenemos que recuperar de los vocabularios controlados el valor del identificador del termino que
//	    			hemos encontrado en los destinatarios y con ese identificador obtener la traduccion del termino
//	    			Primero averiguamos el identificador del termino y luego obtenemos la traduccion del mismo
				if(!terminos[i].trim().equals("")){
					try{
						TerminoYPadreVO terminoVO = new TerminoYPadreVO(identificadorVocabulario, terminos[i],idiomaTerminos,"");
						TerminoYPadreVO[] terminoArray = this.getSrvVocabulariosControladosService().obtenerIdTermino(new TerminoYPadreVO[]{terminoVO});
						if(terminoArray!=null && terminoArray.length>0) terminoTraducido=terminoArray[0];
						log("DetallarControllerImpl - traducirTerminos: Obtenido identificador["+terminoArray[0].getIdTermino()+"] para vocabulario["+identificadorVocabulario+"] con termino["+terminos[i]+"] escrito en idioma["+idiomaTerminos+"]");
					}catch (RemoteException e) {
			    		logger.error("DetallarControllerImpl - traducirTerminos ERROR: Error en la invocacion al servicio de vocabularios controlados obteniendo el identificador del termino["+terminos[i]+"] idioma en LOM-ES["+idiomaTerminos+"] identificador vocabulario["+identificadorVocabulario+"]",e);
					} catch (Exception ex) {
						logger.error("DetallarControllerImpl - traducirTerminos ERROR: Error en la obtencion de identificador del termino["+terminos[i]+"] idioma en LOM-ES["+idiomaTerminos+"] identificador vocabulario["+identificadorVocabulario+"]",ex);
					}
					if (terminoTraducido != null && terminoTraducido.getIdTermino() != null){
//			    		Aqui habria que plantear la obtencion del idioma al que queremos que se traduzcan las palabras.
//			    		Se puede obtener del idioma de navegacion y tener en cuenta algun idioma por defecto.
//			    		Ahora ponemos castellano
				    	try {
//				    		Tenemos un identificador de vocabulario y un termino que pertenece al mismo (en formato texto) y el idioma
//				    		en el que esta escrito el termino. Queremos averiguar el identificador de dicho termino.
				    		String[] idTerminos = new String[]{terminoTraducido.getIdTermino()};
							TerminoVO[] terminoArray = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(idTerminos,idiomaNavegacion);
							log("DetallarControllerImpl - traducirTerminos: Obtenida traduccion["+ terminoArray[0].getNomTermino()+"] de termino["+terminoTraducido.getIdTermino()+"] para idioma["+idiomaNavegacion+"]");
							String traduccion = terminoArray[0].getNomTermino();
							log("DetallarControllerImpl - traducirTerminos: Traduciendo destinatario["+terminos[i]+"]->["+traduccion+"]");
							if (i == 0)	salida = traduccion;
							else salida= salida + ", " + traduccion;
				    	}
				    	catch (RemoteException e) {
				    		logger.error("DetallarControllerImpl - traducirTerminos ERROR: Error en la invocacion al servicio de vocabularios controlados obteniendo la traduccion del termino["+terminoTraducido.getIdTermino()+"] con idioma a traducir["+idiomaTerminos+"]",e);
						} catch (Exception ex) {
							logger.error("DetallarControllerImpl - traducirTerminos ERROR: Error en la traduccion de identificador de termino["+terminoTraducido.getIdTermino()+"] idioma a traducir["+idiomaTerminos+"]",ex);
						}
					}
				}else salida = "";
			}
		}
    	return salida;
    }
    
    private String getAdress(String node, String serverPort, String urlService) {
		return "http://"+node+":"+serverPort+urlService;
	}
    
    private boolean existeSesion(BuscarSession sesion){
    	if(sesion.getAnyoPublicacion()==null && sesion.getAreaCurricular()==null && sesion.getAreaCurricularBusqueda()==null 
    	&& sesion.getAutor()==null && sesion.getBuscadorContenido()==null && sesion.getTipoLayoutBuscador()==null && sesion.getTipoLayoutBuscador()==null
    	&& sesion.getBusquedaSimpleAvanzada()==null && sesion.getContexto()==null && sesion.getDescripcion()==null && sesion.getDiaPublicacion()==null
    	&& sesion.getEdad()==null && sesion.getEmpIdDestino()==null && sesion.getEmpIdOde()==null && sesion.getEmpTipoEmpaquetador()==null && sesion.getEnlaceComunidadesSeleccionadas()==null
    	&& sesion.getEnlaceTodoAgrega()==null && sesion.getFormato()==null && sesion.getIdentificadorODE()==null && sesion.getIdioma()==null 
    	&& sesion.getIdTesauro()==null && sesion.getJerarquias()==null && sesion.getMesPublicacion()==null && sesion.getNodoOrigen()==null
    	&& sesion.getPagina()==null && sesion.getProcesoCognitivo()==null && sesion.getRecurso()==null && sesion.getSecuencia()==null && sesion.getTipoBusqueda()==null
    	&& sesion.getTipoBusquedaArbol()==null && sesion.getTipoVisualizacion()==null && sesion.getTitulo()==null && sesion.getValoracion()==null && sesion.getNivelAgregacion()==null && sesion.getDestinatarios()==null) return false;
    	return true;
    }
    
    private boolean mostrarVuelta(es.pode.buscador.presentacion.basico.detallar.BuscarDetalleODEForm form){
    	if(form.getAreaCurricularBusqueda()==null && form.getBuscadorContenido()==null && form.getTipoLayoutBuscador()==null && form.getTipoLayoutBuscador()==null && form.getPagina()==null && form.getTipoBusqueda()==null
    	&& form.getBusquedaSimpleAvanzada()==null && form.getDescripcion()==null && form.getFormato()==null && form.getIdentificadorODE()!=null && form.getIdioma()!=null && form.getNodoOrigen()==null
    	&& form.getTipoBusquedaArbol()==null && form.getTitulo()==null && form.getValoracion()==null && form.getDestinatarios()==null && (form.getPosicionamientoAnterior()==null || form.getPosicionamientoAnterior().equals(""))
    	&& (form.getPosicionamientoSiguiente()==null || form.getPosicionamientoSiguiente().equals(""))) return false;
    	return true;
    }
    
    private String ampliarImagen (String url){
    	try{
    		if(url!=null && url.equals("/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_100x100))){
    			return "/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_GRANDE);
    		}else if(url!=null && !("").equals(url)){
	    		String urlImagenReturn = "";
	    		String[] urlImagenArray = url.split(DOT);
				for(int i=0; urlImagenArray!=null && i<urlImagenArray.length; i++){
					if((this.getPropertyValue("imagen.ampliada.png")).equals(urlImagenArray[i]))
						urlImagenArray[i] = this.getPropertyValue("imagen.ampliada.captured"); 
					urlImagenReturn = urlImagenReturn + urlImagenArray[i];
				}
				return(urlImagenReturn.trim());
	    	}
    	}catch(IOException e){
    		logger.error("DetallarControllerImpl - ampliarImagen: Error al ampliar imagen con url="+url, e);
    	}
    	return "";
    }
	
	private ParametrosBusquedaAvanzadaVO cargarParametros(HttpServletRequest request,Integer pagina,String idioma,String numeroResultados, String busquedaSimpleAvanzada) throws Exception {
		log("DetallarControllerImpl - cargarParametros");
		BuscarSession sesion = this.getBuscarSession(request);
		ParametrosBusquedaAvanzadaVO param = new ParametrosBusquedaAvanzadaVO();
		param.setIdiomaNavegacion(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
		param.setIdiomaBusqueda(idioma);
		param.setOrigenPagina(pagina);
		param.setPalabrasClave(prepararTextoBusqueda(sesion.getBuscadorContenido()));
		param.setFormato(sesion.getFormato());
		param.setRecurso(sesion.getRecurso());
		param.setNivelAgregacion(sesion.getNivelAgregacion());
		param.setDestinatarios(sesion.getDestinatarios());
		param.setProcesoCognitivo(sesion.getProcesoCognitivo());
		param.setFechaPublicacion(construirFecha(sesion.getAnyoPublicacion(),sesion.getMesPublicacion(),sesion.getDiaPublicacion()));
		param.setContexto(sesion.getContexto());
		param.setEdad(prepararTextoBusqueda(sesion.getEdad()));
		param.setBusquedaSimpleAvanzada(busquedaSimpleAvanzada);
		param.setKeyword(sesion.getKeyword());
		param.setIdTesauro((sesion.getIdTesauro()!=null && !sesion.getIdTesauro().equals(""))?sesion.getIdTesauro():sesion.getTesauroBusqueda());
		param.setAutor(prepararTextoBusqueda(sesion.getAutor()));
		param.setSecuencia((sesion.getSecuencia()!=null && !sesion.getSecuencia().equals(""))?new Boolean(sesion.getSecuencia()):null);
		param.setValoracion(sesion.getValoracion()!=null && !sesion.getValoracion().equals("")?sesion.getValoracion().replaceAll(GUION, SEPARADOR_PALABRAS):null);
		if(sesion.getAreaCurricularBusqueda()!=null && !sesion.getAreaCurricularBusqueda().trim().equals("")){
			param.setAreaCurricular(sesion.getAreaCurricularBusqueda());
			param.setArbolCurricularVigente(this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idioma));
		}else if(sesion.getAreaCurricular()!=null && !sesion.getAreaCurricular().trim().equals("")){
			param.setAreaCurricular(sesion.getAreaCurricular());
			param.setArbolCurricularVigente(this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idioma));
		}
		param.setAmbito(AMBITO_UNIVERSAL+SEPARADOR_PALABRAS+DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO));
		param.setAreaCurricular((sesion.getAreaCurricularBusqueda()!=null && !sesion.getAreaCurricularBusqueda().equals(""))?sesion.getAreaCurricularBusqueda():sesion.getAreaCurricular());
		param.setComunidadPeticion((sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().equals(""))?sesion.getNodoOrigen():request.getServerName());
		if(sesion.getTipoBusqueda()!=null && sesion.getTipoBusqueda().equals("01") && sesion.getEnlaceTodoAgrega()!=null && !sesion.getEnlaceTodoAgrega().equals(""))param.setComunidadesSeleccionadas(obtenerComunidades());
		else if(sesion.getEnlaceComunidadesSeleccionadas()!=null && !sesion.getEnlaceComunidadesSeleccionadas().equals(""))param.setComunidadesSeleccionadas(obtenerComunidades(sesion.getEnlaceComunidadesSeleccionadas().split("-")));
		else if(sesion.getTipoBusquedaArbol()!=null && sesion.getTipoBusquedaArbol().equals("01")){
			param.setComunidadesSeleccionadas(obtenerComunidades());
		}
		//si b�squeda federada entonces se selecciona TODAS
		String maxRes = request.getSession().getServletContext().getInitParameter("max_res_totales");
		if (maxRes == null || maxRes.equals("")) maxRes = "1000";
		param.setNumeroResultados(new Integer(maxRes));
		if (numeroResultados == null || numeroResultados.equals("")) numeroResultados = "10";
		param.setResultadosPorPagina(new Integer(numeroResultados));
		return param;
	}
	
	private String[] obtenerComunidades() throws RemoteException, Exception{		
		NodoVO[] nodoLista = this.getSrvNodoService().listarNodos();
   	 	String[]comuni = new String[nodoLista.length];
   	 	for(int j=0; j<nodoLista.length;j++) comuni[j]=nodoLista[j].getId().toString();
		return comuni;
	}
    
    private String[] obtenerComunidades(String[] comunidadesSeleccionadas) throws RemoteException, Exception{		
		String[] comunidades = obtenerComunidades();
		String[] resultado = new String[(comunidadesSeleccionadas[0].equals("0"))?comunidadesSeleccionadas.length-1:comunidadesSeleccionadas.length];
		for(int i=0; i < comunidadesSeleccionadas.length;i++){
   	 		for(int j=0; j < comunidades.length;j++) {
   	 			if(!comunidadesSeleccionadas[i].equals("0") && j==Integer.parseInt(comunidadesSeleccionadas[i])-2) resultado[(comunidadesSeleccionadas[0].equals("0"))?i-1:i]=comunidades[j];
   	 		}
		}
		return resultado;
	}
    
    public String construirFecha(String anyoFechaPublicacion,String mesFechaPublicacion,String diaFechaPublicacion){
		log("DetallarControllerImpl - construyeFecha");
		if(!comprobarAtributoConValor(anyoFechaPublicacion) && !comprobarAtributoConValor(mesFechaPublicacion) &&	!comprobarAtributoConValor(diaFechaPublicacion)) return "";
		log("DetallarControllerImpl - construyeFecha: fecha a enviar=["+traducirFecha(anyoFechaPublicacion) + traducirFecha(mesFechaPublicacion) + traducirFecha(diaFechaPublicacion)+"]");
		return traducirFecha(anyoFechaPublicacion) + traducirFecha(mesFechaPublicacion) + traducirFecha(diaFechaPublicacion);
		
	}
	
	private String traducirFecha(String campo){
		if(campo!=null && !campo.trim().equals(""))return campo;
		return BuscarAvanzadoControllerImpl.ASTERISK;
	}
	
	private boolean comprobarAtributoConValor(String variable){
		//Compruebo que el existe el campo analizado
		return(variable!=null && !variable.equals(""));
	}
	
	private String comprobarImagen(String servidor, String imagen){
		try{
			InputStreamReader in = new InputStreamReader(new URL("http://"+servidor+LdapUserDetailsUtils.getSubdominio()+imagen).openStream());
			return imagen;
		}catch(Exception ex){
			log("DetallarControllerImpl - comprobarImagen=http://"+servidor+LdapUserDetailsUtils.getSubdominio()+imagen);
			return LdapUserDetailsUtils.getSubdominio()+"/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_100x100);
		}
	}

	@Override
	public String tipoVisualizador(ActionMapping mapping, TipoVisualizadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String identificadorODE= request.getParameter("identificador");
			String tipoVisualizador = request.getParameter("secuencia"); //nombre del radio seleccionado
			log("TIPOVISUALIZADOR IDENTIFICADOR DE ODE " + identificadorODE);
			log("TIPOVISUALIZADOR TIPOVISUALIZADOR " + tipoVisualizador);
			form.setIdentificadorODE(identificadorODE);
			form.setTipoVisualizador(tipoVisualizador);
			//formamos la url
			String urlaVisualizar="http://"+LdapUserDetailsUtils.getHost()+ LdapUserDetailsUtils.getSubdominio() + "/";
			log("el valor de urlaVisualizar " + urlaVisualizar);
			if ((tipoVisualizador!= null) && (!tipoVisualizador.equals("")) && (tipoVisualizador.equals("false"))){
				//redireccion a visualizador sin secuencia
				urlaVisualizar = urlaVisualizar + request.getSession().getServletContext().getInitParameter("url_visualizador") +
				"?identificador=" + form.getIdentificadorODE() + "&secuencia=" + false;			
				
			} else if ((tipoVisualizador!= null) && (!tipoVisualizador.equals("")) && (tipoVisualizador.equals("true"))) {
				//redireccion a visualizador con secuencia
				urlaVisualizar = urlaVisualizar + request.getSession().getServletContext().getInitParameter("url_visualizador") +
				"?identificador=" + form.getIdentificadorODE() + "&secuencia=" + true;
				
			}else if ((tipoVisualizador!= null) && (!tipoVisualizador.equals("")) && (tipoVisualizador.equals("adl"))) {
				//redireccion a visualizador Adl
				urlaVisualizar = urlaVisualizar + request.getSession().getServletContext().getInitParameter("url_visualizador_adl") +
				"?identificador=" + form.getIdentificadorODE();
			}
			log("redirigimos a url " + urlaVisualizar);
			response.sendRedirect(urlaVisualizar);
		} catch (Exception e) {
			logger.error("Se ha producido un Error en tipoVisualizador ", e);
		}
			return null;
	}
	
	private String prepararTextoBusqueda(String texto){
		if(texto!=null && !texto.equals(""))return texto.replaceAll(DetallarControllerImpl.HTML_QUOTES, DetallarControllerImpl.JAVA_QUOTES).replaceAll(BuscarAvanzadoControllerImpl.HTML_PLUS, BuscarAvanzadoControllerImpl.JAVA_PLUS).replaceAll(DetallarControllerImpl.DOT, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.DOUBLE_DOT, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_QUESTIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_QUESTIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_PARENTHESES, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_PARENTHESES, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_EXCLAMATIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_EXCLAMATIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.COMA, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.SLASH, DetallarControllerImpl.SEPARADOR_PALABRAS);
		return "";
	}
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}