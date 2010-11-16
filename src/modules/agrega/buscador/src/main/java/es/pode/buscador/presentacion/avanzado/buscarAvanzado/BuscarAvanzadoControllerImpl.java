/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.HashMap;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.agregador.negocio.agregador.servicio.ParametrosBusquedaAgregadorVO;
import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO;
import es.pode.buscar.negocio.buscar.servicios.SrvBuscarService;
import es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO;
import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonPathVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.buscador.presentacion.IBuscadorConstants;
import javax.servlet.http.HttpSession;

/**
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController
 */

public class BuscarAvanzadoControllerImpl extends BuscarAvanzadoController{
	private static final long serialVersionUID = -8190956967832345670L;

	private java.util.Properties pSpringProperties = null;
	public final static String APPLICATION_PROPERTIES = "application-resources";
	private static Logger logger = Logger.getLogger(BuscarAvanzadoControllerImpl.class);
	
	private final static String SLASH = "/";
	public final static String ASTERISK = "*";
	public final static String ANDPERSAND = "&";
	private final static String NO_CHOICE_VALUE = "";
	public static final String HTML_PLUS = "%2B";
	public static final String JAVA_PLUS = "\\+";
	public static final String UNIVERSAL = "universal";
	public static final String IDENTIFICADOR_NODO = "server.id";
	private final static String ACCION_CONFIGURAR_AVANZADO = "CONFIGURAR_AVANZADO";
	private final static String ACCION_ESCOGER = "ESCOGER";
	private final static String ACCION_ELIMINAR = "ELIMINAR";
	private final static String ACCION_ESCOGER_TESAURO = "ESCOGER_TESAURO";
	private final static String ACCION_ELIMINAR_TESAURO = "ELIMINAR_TESAURO";
	private final static String ACCION_BUSCAR = "BUSCAR";
	private final static String ACCION_LIMPIAR = "LIMPIAR";
	private final static String ACCION_FORMULARIO_INVALIDO_AVANZADO = "FORMULARIO_INVALIDO_AVANZADO";
	private final static String ACCION_FORMULARIO_INVALIDO = "FORMULARIO_INVALIDO";
	private final static String ACCION_FORMULARIO_VALIDO = "FORMULARIO_VALIDO";
	private static final String ACCION_CON_RESULTADOS = "CON_RESULTADOS";
	private static final String ACCION_CON_SUGERENCIAS = "CON_SUGERENCIAS";
	private static final String ACCION_SIN_RESULTADOS = "SIN_RESULTADOS";
	private static final String ACCION_CON_IMAGENES = "CON_IMAGENES";
	private static final String ACCION_AGREGA = "AGREGA";
	private static final String ACCION_SQI = "SQI";
	private static final int BUFFER_SIZE = 2048;
	
	public final static String MENSAJE_NINGUNO_LLENO = "configurar.avanzado.controller.exception.NingunCampoLleno";
	public final static String MENSAJE_GENERICO_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";
	public final static String MENSAJE_DIA_INCORRECTO = "configurar.avanzado.controller.exception.diaFechaIncorrecta";
	public final static String MENSAJE_MES_INCORRECTO = "configurar.avanzado.controller.exception.mesFechaIncorrecta";
	public final static String MENSAJE_ANYO_INCORRECTO = "configurar.avanzado.controller.exception.anyoFechaIncorrecta";
	public final static String MENSAJE_CARACTER_FECHA = "configurar.avanzado.controller.exception.caracterComoFecha";
	public final static String MENSAJE_WILDCARD_ERRONEA = "configurar.avanzado.controller.exception.noAsteriscos";
	public final static String MENSAJE_WILDCARD_SOLA = "configurar.avanzado.controller.exception.noAsterisco";
	public final static String MENSAJE_SUMATORIO_INICIO = "configurar.avanzado.controller.exception.sumatorioInicio";
	
	public final static String MENSAJE_USUARIO_NO_LOGADO="configurar.avanzado.controller.exception.usuarioNoLogado";
	public final static String MENSAJE_ERROR_ELIMINAR_ODE="configurar.avanzado.controller.exception.errorEliminarODE";
	public final static String MENSAJE_ERROR_AUTENTIFICACION="configurar.avanzado.controller.exception.errorAutentificacion";
	public final static String MENSAJE_ERROR_COMUNIDADES="configurar.avanzado.controller.exception.errorComunidades";
	public final static String MENSAJE_ERROR_TRADUCCIONES="listar.odecu.mostrar.resultados.detalles.errorTraduccionTermino";
	public final static String ERROR_ELIMINANDO_ODES="errors.odes.eliminar";
	private final static String DEFAULT_SEARCH_PATTERN = ".*";
    /**
     * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#cargaFormularioBusquedaAvanzada(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargaFormularioBusquedaAvanzadaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargaFormularioBusquedaAvanzada(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargaFormularioBusquedaAvanzadaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
     	try{
	    	BuscarSession sesion = this.getBuscarSession(request);
			if (sesion == null) {
				inicializarSesion(request);
				log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Sesion de busqueda creada inicializando formulario de busqueda avanzada. La sesion estaba vacia.");
				form.setContadorPropiedadesContenido("0");
				form.setContadorAreasCurriculares("0");
				form.setContadorAmbito("0");
			}
//			llamada traer nodos
			SrvNodoService nodo = this.getSrvNodoService();
			NodoVO[] listaNodos = nodo.listarNodos();
			if(listaNodos == null || listaNodos.length == 0) form.setMostrarAmbito(new Boolean(false));
			else form.setMostrarAmbito(new Boolean(true));
			if(form.getComunidades()==null){
				try{
					if(listaNodos.length > 0){
						ArrayList listaComunidades = new ArrayList();
						listaComunidades.add(I18n.getInstance().getResource("configurar.avanzado.comunidades.Todas", BuscarAvanzadoControllerImpl.APPLICATION_PROPERTIES, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
						listaComunidades.add(DependentServerProperties.getInstance().getServerOn());
						for(int i=0; i<listaNodos.length;i++){
							listaComunidades.add(listaNodos[i].getNodo());
						}
						form.setComunidades(listaComunidades);
					}else{
						form.setComunidades(new ArrayList());
					}
				}catch(Exception ex){
					form.setComunidades(new ArrayList());
					logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada ERROR: Error obteniendo nodos para configuracion b�squeda avanzada:",ex);
					saveErrorMessage(request,BuscarAvanzadoControllerImpl.MENSAJE_GENERICO_BUSQUEDA);
				}
			}else{
				form.setContadorAmbito(String.valueOf(form.getComunidades().size()+1));
			}
			String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Introduzco en el formulario los valores de la sesi�n o inicializados en funcion de si volvemos del detalle o entramos por primera vez. Si la b�squeda fu� incorrecta el formulario se queda como esta.");
			if(form.getBuscadorContenido()==null || form.getBuscadorContenido().equals(""))form.setBuscadorContenido((comprobarAtributoConValor(sesion.getBuscadorContenido()))?sesion.getBuscadorContenido():getPropertyValue("avanzado.buscadorContenido"));
			else form.setBuscadorContenido(form.getBuscadorContenido().replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES));
			if(form.getEdad()==null || form.getEdad().equals(""))form.setEdad((comprobarAtributoConValor(sesion.getEdad()))?sesion.getEdad():getPropertyValue("avanzado.edad"));
			else form.setEdad(form.getEdad().replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES));
			if(form.getAutor()==null || form.getAutor().equals(""))form.setAutor((comprobarAtributoConValor(sesion.getAutor()))?sesion.getAutor():getPropertyValue("avanzado.autor"));
			else form.setAutor(form.getAutor().replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES));
			if(form.getDiaPublicacion()==null || form.getDiaPublicacion().equals(""))form.setDiaPublicacion((comprobarAtributoConValor(sesion.getDiaPublicacion()))?sesion.getDiaPublicacion():getPropertyValue("avanzado.fechaDia"));	
			if(form.getMesPublicacion()==null || form.getMesPublicacion().equals(""))form.setMesPublicacion((comprobarAtributoConValor(sesion.getMesPublicacion()))?sesion.getMesPublicacion():getPropertyValue("avanzado.fechaMes"));		
			if(form.getAnyoPublicacion()==null || form.getAnyoPublicacion().equals(""))form.setAnyoPublicacion((comprobarAtributoConValor(sesion.getAnyoPublicacion()))?sesion.getAnyoPublicacion():getPropertyValue("avanzado.fechaAnyo"));
			if(form.getIdiomaBuscador()==null || form.getIdiomaBuscador().equals(""))form.setIdiomaBuscador((comprobarAtributoConValor(sesion.getIdioma()))?sesion.getIdioma():obtenerIdiomaBusqueda());
			if(form.getFormato()==null || form.getFormato().equals(""))form.setFormato((comprobarAtributoConValor(sesion.getFormato()))?sesion.getFormato():NO_CHOICE_VALUE);
			if(form.getRecurso()==null || form.getRecurso().equals(""))form.setRecurso((comprobarAtributoConValor(sesion.getRecurso()))?sesion.getRecurso():NO_CHOICE_VALUE);
			if(form.getProcesoCognitivo()==null || form.getProcesoCognitivo().equals(""))form.setProcesoCognitivo((comprobarAtributoConValor(sesion.getProcesoCognitivo()))?sesion.getProcesoCognitivo():NO_CHOICE_VALUE);
			if(form.getContexto()==null || form.getContexto().equals(""))form.setContexto((comprobarAtributoConValor(sesion.getContexto()))?sesion.getContexto():NO_CHOICE_VALUE);
			if(form.getC_s_secuencia()==null || form.getC_s_secuencia().equals("")) form.setC_s_secuencia((comprobarAtributoConValor(sesion.getSecuencia()))?sesion.getSecuencia():NO_CHOICE_VALUE);
			if(form.getValoracion()==null || form.getValoracion().equals("")) form.setValoracion((comprobarAtributoConValor(sesion.getValoracion()))?sesion.getValoracion():NO_CHOICE_VALUE);
			if(form.getNivelAgregacion()==null || form.getNivelAgregacion().equals("")) form.setNivelAgregacion((comprobarAtributoConValor(sesion.getNivelAgregacion()))?sesion.getNivelAgregacion():NO_CHOICE_VALUE);
			if(form.getDestinatarios()==null || form.getDestinatarios().equals("")) form.setDestinatarios((comprobarAtributoConValor(sesion.getDestinatarios()))?sesion.getDestinatarios():NO_CHOICE_VALUE);
			if(form.getTipoLayoutBuscador()==null)form.setTipoLayoutBuscador((sesion.getTipoLayoutBuscador()==null)?DetallarControllerImpl.LAYOUT_BUSCADOR:sesion.getTipoLayoutBuscador());
			String[]comunidadesSeleccAux=null;
			if(form.getEnlaceComunidadesSeleccionadas()!=null && form.getEnlaceComunidadesSeleccionadas().equals("") && form.getTipoBusqueda()!=null && form.getTipoBusqueda().equals("03") && (form.getEnlaceTodoAgrega()==null || form.getEnlaceTodoAgrega().equals(""))){
				form.setContadorAmbito("1");
				comunidadesSeleccAux=new String[]{"1"};
			}else if(((form.getEnlaceComunidadesSeleccionadas()!=null && !form.getEnlaceComunidadesSeleccionadas().equals("")) || (form.getEnlaceTodoAgrega()!=null && !form.getEnlaceTodoAgrega().equals(""))) && form.getComunidades()!=null){
				form.setContadorAmbito(String.valueOf(form.getComunidades().size()+1));
				comunidadesSeleccAux=new String[form.getComunidades().size()+2];
				for(int i=0; i<comunidadesSeleccAux.length;i++) comunidadesSeleccAux[i]=String.valueOf(i);
				String[]comunidadesSelecc = null;
				if(form.getEnlaceComunidadesSeleccionadas()!=null && !form.getEnlaceComunidadesSeleccionadas().equals("")){
					comunidadesSelecc = form.getEnlaceComunidadesSeleccionadas().split("-");
					comunidadesSeleccAux=new String[comunidadesSelecc.length+1];
					comunidadesSeleccAux[0]="1";
					for(int i=0; i<comunidadesSelecc.length;i++) comunidadesSeleccAux[i+1]=comunidadesSelecc[i];
				}else if(listaNodos!=null){
					comunidadesSelecc = form.getEnlaceTodoAgrega().split("-");
					comunidadesSeleccAux=new String[comunidadesSelecc.length+2];
					comunidadesSeleccAux[0]="0";
					comunidadesSeleccAux[1]="1";
					for(int i=0; i<comunidadesSelecc.length;i++){
						for(int j=0; j<listaNodos.length;j++){
							if(String.valueOf(listaNodos[j].getId()).equals(comunidadesSelecc[i])){
								comunidadesSeleccAux[i+2]=String.valueOf((i+1));
							}
						}
					}
				}
				form.setContadorAmbito(String.valueOf(comunidadesSeleccAux.length));
			}else{
				String[] comunidades = obtenerComunidades();
				if(comunidades!=null){
					form.setContadorAmbito(String.valueOf(comunidades.length+2));
					comunidadesSeleccAux = new String[comunidades.length+2];
					for(int i=0; i<comunidadesSeleccAux.length;i++) comunidadesSeleccAux[i]=String.valueOf(i);
				}
			}
			form.setComunidadesSeleccionadas(comunidadesSeleccAux);
			form.setContadorPropiedadesContenido(String.valueOf(contarCamposCargados(form.getNivelAgregacion(), form.getDestinatarios(),form.getFormato(), form.getIdiomaBuscador(), form.getRecurso(), form.getProcesoCognitivo(), form.getContexto(), form.getEdad(),form.getAutor(), form.getDiaPublicacion(), form.getMesPublicacion(), form.getAnyoPublicacion(), form.getC_s_secuencia(), form.getValoracion())));
			form.setTipoBusqueda("03");
//			seleccion de los combos de fuentes taxonomicas
			log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Carga de combos pantalla configuracion busqueda avanzada.");
			String[] identificadoresLOMES = new String[]{getPropertyValue("destinatarios"),getPropertyValue("recurso"),getPropertyValue("procesoCognitivo"),getPropertyValue("contexto")};
			try{	
				VocabularioVO[] traducciones = this.getSrvVocabulariosControladosService().obtenerCombos(identificadoresLOMES, getPropertyValue("idioma.terminos"));
				VocabularioVO[] traducciones_espanyol = this.getSrvVocabulariosControladosService().obtenerCombos(identificadoresLOMES, idiomaNavegacion);
				log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Obtenemos ["+traducciones.length+"] traducciones de los combos.");
				for(int i = 0; i < traducciones.length; i++) logger.debug("Obtenemos traduccion de ["+traducciones[i].getIdVocabulario() + "]["+traducciones[i].getNomVocabulario()+"] traducciones de los combos.");
//				Compruebo si tenia ya sesion el formato
				form.setDestinatariosLabelList(transformarTerminoVOaString(traducciones_espanyol[0].getTerminos(),(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
				form.setDestinatariosValueList(transformarTerminoValueVOaString(traducciones[0].getTerminos(),traducciones_espanyol[0].getTerminos(),form.getDestinatariosLabelList()));
				form.setRecursoLabelList(transformarTerminoVOaString(traducciones_espanyol[1].getTerminos(),(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
				form.setRecursoValueList(transformarTerminoValueVOaString(traducciones[1].getTerminos(),traducciones_espanyol[1].getTerminos(),form.getRecursoLabelList()));
				form.setProcesoCognitivoLabelList(transformarTerminoVOaString(traducciones_espanyol[2].getTerminos(),(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
				form.setProcesoCognitivoValueList(transformarTerminoValueVOaString(traducciones[2].getTerminos(),traducciones_espanyol[2].getTerminos(),form.getProcesoCognitivoLabelList()));
				form.setContextoLabelList(transformarTerminoVOaString(traducciones_espanyol[3].getTerminos(),(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
				form.setContextoValueList(transformarTerminoValueVOaString(traducciones[3].getTerminos(),traducciones_espanyol[3].getTerminos(),form.getContextoLabelList()));
			}catch(Exception ex){
	//			Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error invocando el servicio de vocabularios controlados. Imposible traducir los indices["+identificadoresLOMES[0]+"]["+identificadoresLOMES[1]+"]["+identificadoresLOMES[2]+"]["+identificadoresLOMES[3]+"]",ex);
				form.setDestinatarios(""); 
				form.setDestinatariosLabelList(new String[0]); 
				form.setDestinatariosValueList(new String[0]);
				form.setRecurso(""); 
				form.setRecursoLabelList(new String[0]); 
				form.setRecursoValueList(new String[0]);
				form.setProcesoCognitivo(""); 
				form.setProcesoCognitivoLabelList(new String[0]); 
				form.setProcesoCognitivoValueList(new String[0]);
				form.setContexto(""); 
				form.setContextoLabelList(new String[0]); 
				form.setContextoValueList(new String[0]);
				saveErrorMessage(request,DetallarControllerImpl.MENSAJE_TRADUCCION_BUSQUEDA);
			}
			log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Obteniendo idiomas localizados para combo para idioma usuario="+idiomaNavegacion);
			try{
				LocalizacionIdiomaVO[] localizacionesIdioma = I18n.getInstance().obtenerIdiomasBuscablesLocalizados(idiomaNavegacion);
				form.setIdiomaBuscadorBackingList(Arrays.asList(localizacionesIdioma), "idLocalizacion", "name");
			}catch(Exception ex){
	//			Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error invocando el servicio de obtener idiomas localizados. Imposible obtener idiomas localizados para:["+idiomaNavegacion+"]",ex);
				form.setIdiomaBuscador("");
				form.setIdiomaBuscadorBackingList(new ArrayList(), "idLocalizacion", "name");
				saveErrorMessage(request,DetallarControllerImpl.MENSAJE_IDIOMAS_BUSQUEDA);
			}
			log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Carga de combos pantalla configuracion busqueda avanzada desde properties");
			try{
				form.setFormatoLabelList(cargarFormatoLabel(new Locale(idiomaNavegacion)));
				form.setFormatoValueList(cargarFormatoValue());
			}catch(Exception ex){
				form.setFormato(""); 
				form.setFormatoLabelList(new String[0]); 
				form.setFormatoValueList(new String[0]);
				saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
			}
			try{
				form.setC_s_secuenciaLabelList(cargarC_S_SecuenciaLabel(new Locale(idiomaNavegacion)));
				form.setC_s_secuenciaValueList(cargarC_S_SecuenciaValue());
     		}catch(Exception ex){
//				Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error obteniendo valores para los combos de secuencia desde properties para idioma:["+idiomaNavegacion+"]",ex);
				form.setC_s_secuencia("");
				form.setC_s_secuenciaLabelList(new String[0]);
				form.setC_s_secuenciaValueList(new String[0]);
				saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
			}
     		try{
	     		form.setValoracionLabelList(cargarValoracionLabel(new Locale(idiomaNavegacion)));
				form.setValoracionValueList(cargarValoracionValue());
	     	}catch(Exception ex){
//				Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error obteniendo valores para los combos de valoraci�n desde properties para idioma:["+idiomaNavegacion+"]",ex);
				form.setValoracion("");
				form.setValoracionLabelList(new String[0]);
				form.setValoracionValueList(new String[0]);
				saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
			}
	     	try{
	     		form.setNivelAgregacionLabelList(cargarNivelAgregacionLabel(new Locale(idiomaNavegacion)));
				form.setNivelAgregacionValueList(cargarNivelAgregacionValue());
	     	}catch(Exception ex){
//				Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error obteniendo valores para los combos de NivelAgregacion desde properties para idioma:["+idiomaNavegacion+"]",ex);
				form.setNivelAgregacion("");
				form.setNivelAgregacionLabelList(new String[0]);
				form.setNivelAgregacionValueList(new String[0]);
				saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
			}
//    		Introduccion del area curricular
	     	log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Obtencion y traduccion de area curricular");
			try{
				if(sesion.getAreaCurricular()!=null) form.setAreaCurricular(sesion.getAreaCurricular());
				if(comprobarAtributoConValor(form.getAreaCurricular())){
					form.setAreaCurricularTexto(convertirStringAreaCurricular(form.getAreaCurricular(),idiomaNavegacion));
					form.setContadorAreasCurriculares(String.valueOf(1));
				}else form.setContadorAreasCurriculares(String.valueOf(0));
			}catch(Exception ex){
//				Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error obteniendo valores para la traduccion del area curricular:["+form.getAreaCurricular()+"]",ex);
				form.setAreaCurricularTexto("");
				form.setContadorAreasCurriculares(String.valueOf(0));
				saveErrorMessage(request,DetallarControllerImpl.MENSAJE_TRADUCCION_BUSQUEDA);
			}
			log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Obtencion y traduccion de tesauros");
			if(comprobarAtributoConValor(form.getNomTesauros()))form.setContadorTesauros(String.valueOf(1));
			else form.setContadorTesauros(String.valueOf(0));
			log("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: FIN");
     	} catch (Exception ex) {
     		logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada ERROR:",ex);
			saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
		}
    }

	public void limpiarFormulario(ActionMapping mapping, LimpiarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		form.setAnyoPublicacion("");
		form.setAreaCurricular("");
		form.setAreaCurricularTexto("");
		form.setAutor("");
		form.setBuscadorContenido("");
		form.setC_s_secuencia("");
		form.setContadorAreasCurriculares("0");
		form.setContadorPropiedadesContenido("1");
		form.setContadorTesauros("0");
		form.setContexto("");
		form.setDescripcion("");
		form.setDestinatarios("");
		form.setDiaPublicacion("");
		form.setEdad("");
		form.setEnlaceComunidadesSeleccionadas("");
		form.setFormato("");
		form.setIdiomaBuscador(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
		form.setIdTesauro("");
		form.setMesPublicacion("");
		form.setNivelAgregacion("");
		form.setNomTesauros("");
		form.setProcesoCognitivo("");
		form.setRecurso("");
		form.setTitulo("");
		form.setValoracion("");
		String[] comunidades = obtenerComunidades();
		if(comunidades!=null){
			form.setContadorAmbito(String.valueOf(comunidades.length+2));
			String[] comunidadesSeleccAux = new String[comunidades.length+2];
			for(int i=0; i<comunidadesSeleccAux.length;i++) comunidadesSeleccAux[i]=String.valueOf(i);
			form.setEnlaceComunidadesSeleccionadas("0-1"+DetallarControllerImpl.GUION+this.generarEnlaceComunidades(comunidadesSeleccAux));
		}
	}
    
	public void cargarFormularioQuisoDecir(ActionMapping mapping, CargarFormularioQuisoDecirForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idiomaNavegacion = null;
		try{
			if(form.getTipoBusqueda()==null)form.setTipoBusqueda("02");
			form.setIdiomaBuscador(devolverIdiomaBuscador(form.getIdiomaBuscador()));
			idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			LocalizacionIdiomaVO[] localizacionesIdioma = I18n.getInstance().obtenerIdiomasBuscablesLocalizados(idiomaNavegacion);
			form.setIdiomaBuscadorBackingList(Arrays.asList(localizacionesIdioma), "idLocalizacion", "name");
			try{
				form.setNumeroResultadosLabelList(cargarNumeroResultadosLabel(new Locale(idiomaNavegacion)));
				form.setNumeroResultadosValueList(cargarNumeroResultadosValue());
			}catch(Exception ex){
				form.setNumeroResultadosLabelList(new String[0]); 
				form.setNumeroResultadosValueList(new String[0]);
				saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
			}
			try{
				NodoSQIVO[] nodos = this.getSrvGestionSqiService().obtenerNodosSQI();
				if (nodos!=null && nodos.length>0){
					form.setNodosSQI(new Boolean(true));
					if (logger.isDebugEnabled()) logger.debug("BuscarAvanzadoControllerImpl - cargarFormularioQuisoDecir: Existen " + nodos.length + " nodos SQI indexados en la BBDD");
				}else{
					form.setNodosSQI(new Boolean(false));
					if (logger.isDebugEnabled()) logger.debug("BuscarAvanzadoControllerImpl - cargarFormularioQuisoDecir: No existe ning�n nodo SQI indexado en la BBDD");
				}
				
			}catch (Exception e){
				logger.error("BuscarAvanzadoControllerImpl - cargarFormularioQuisoDecir: Error al intentar recuperar el numero de nodos SQI indexados en la tabla",e);
				form.setNodosSQI(new Boolean(false));
			}
		}catch(Exception ex){
//			Si no hay traducciones posibles a los vocabularios controlados que se pintan, se muestran vacios
			logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error invocando el servicio de obtener idiomas localizados. Imposible obtener idiomas localizados para:["+idiomaNavegacion+"]",ex);
			form.setIdiomaBuscador("");
			form.setIdiomaBuscadorBackingList(new ArrayList(), "idLocalizacion", "name");
			saveErrorMessage(request,DetallarControllerImpl.MENSAJE_IDIOMAS_BUSQUEDA);
		}	
	}
    
    public void eliminarAreaCurricular(ActionMapping mapping, EliminarAreaCurricularForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	log("BuscarAvanzadoControllerImpl - eliminarAreaCurricular");
    	form.setAreaCurricular("");
    	form.setEnlaceComunidadesSeleccionadas(this.generarEnlaceComunidades(form.getComunidadesSeleccionadas()));
    	BuscarSession sesion = this.getBuscarSession(request);
    	if(sesion != null) sesion.setAreaCurricular("");
    	log("BuscarAvanzadoControllerImpl - eliminarAreaCurricular FIN");
	}
    
	public void eliminarTesauro(ActionMapping mapping, EliminarTesauroForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log("BuscarAvanzadoControllerImpl - eliminarTesauro");
    	form.setNomTesauros("");
    	form.setIdTesauro("");
    	form.setEnlaceComunidadesSeleccionadas(this.generarEnlaceComunidades(form.getComunidadesSeleccionadas()));
    	BuscarSession sesion = this.getBuscarSession(request);
    	if(sesion != null) sesion.setIdTesauro("");
    	log("BuscarAvanzadoControllerImpl - eliminarAreaCurricular FIN");
	}
    
	public String analizaEntrada(ActionMapping mapping, AnalizaEntradaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log("BuscarAvanzadoControllerImpl - analizaEntrada");
		BuscarSession sesion = this.getBuscarSession(request);
		if(form.getTipoLayoutBuscador()==null){
			try{	    	
		    	if(DetallarControllerImpl.TRUE.equals((String)AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO))) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_NEUTRO);
		    	else form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
			}catch (Exception e){
				logger.debug("BuscarAvanzadoControllerImpl - analizaEntrada: No existe la propiedad neutro del agregaProperties");
				form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
			}
		}
		if(form.getEmpIdOde() != null || form.getEmpIdDestino() != null || form.getEmpTipoEmpaquetador() != null){
//			 Inicializo sesi�n
			this.setBuscarSession(request,new BuscarSession());
			sesion = this.getBuscarSession(request);
			sesion.setEmpIdOde(form.getEmpIdOde());
			sesion.setEmpIdDestino(form.getEmpIdDestino());
			sesion.setEmpTipoEmpaquetador(form.getEmpTipoEmpaquetador());
			this.setBuscarSession(request, sesion);
			log("BuscarAvanzadoControllerImpl - analizaEntrada agregarOdes: Se agrega ode federado al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador());
			form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_EMPAQUETADOR);
		}else if(form.getBusquedaSimpleAvanzada() == null && sesion.getBusquedaSimpleAvanzada() != null && sesion.getBusquedaSimpleAvanzada().trim().equals(DetallarControllerImpl.BUSCAR)){
			cargarFormularioSesion(form,request);
			return ACCION_BUSCAR;
		}else if(form.getBusquedaSimpleAvanzada() != null && form.getBusquedaSimpleAvanzada().trim().equals(DetallarControllerImpl.BUSCAR_SIMPLE)){
			//form.setBusquedaSimpleAvanzada(ACCION_BUSCAR);
			return ACCION_BUSCAR;
		}
		cargarFormularioSesion(form,request);
		inicializarSesion(request);
		return ACCION_CONFIGURAR_AVANZADO;
	}
    
	public String analizaPulsacion(ActionMapping mapping, AnalizaPulsacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			log("BuscarAvanzadoControllerImpl - analizaPulsacion: ["+form.getPulsacion()+"] con valores["+datosResources.getString("configurar.avanzado.areaCurricular.aniadir")+"]["+datosResources.getString("configurar.avanzado.areaCurricular.eliminar")+"]["+datosResources.getString("configurar.avanzado.buscar.buscar")+"]");
			if (datosResources.getString("configurar.avanzado.areaCurricular.pulsacion.aniadir").equals(form.getPulsacion())) return ACCION_ESCOGER;
			else if (datosResources.getString("configurar.avanzado.areaCurricular.pulsacion.eliminar").equals(form.getPulsacion())) return ACCION_ELIMINAR;
			else if (datosResources.getString("configurar.avanzado.tesauros.pulsacion.aniadir").equals(form.getPulsacion())) return ACCION_ESCOGER_TESAURO;
			else if (datosResources.getString("configurar.avanzado.tesauros.eliminar").equals(form.getPulsacion())) return ACCION_ELIMINAR_TESAURO;
			else if (datosResources.getString("configurar.avanzado.buscar.pulsacion.limpiar").equals(form.getPulsacion())) return ACCION_LIMPIAR;
			return ACCION_BUSCAR;
		} catch (Exception ex) {
			logger.error("BuscarAvanzadoControllerImpl - analizaPulsacion ERROR: ",ex);
			saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
			return ACCION_FORMULARIO_INVALIDO;
		}
	}
  
	public void validarFormulario(ActionMapping mapping, ValidarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//Recupero los valores de los filtros seleccionados y los refresco
		log("BuscarAvanzadoControllerImpl - validarFormulario");
		List errorMessages = null;
		try{		
			form.setContadorPropiedadesContenido(contarCamposCargados(form.getNivelAgregacion(),form.getDestinatarios(),form.getFormato(), form.getIdiomaBuscador(), form.getRecurso(), form.getProcesoCognitivo(), form.getContexto(), form.getEdad(),form.getAutor(), form.getDiaPublicacion(), form.getMesPublicacion(), form.getAnyoPublicacion(), form.getC_s_secuencia(), form.getValoracion()));
			form.setContadorAreasCurriculares(contarCamposArbolCurricular(form));
			form.setBuscadorContenido(devolverTextoBusqueda(form.getBuscadorContenido(), form.getBuscadorContenidoSolo()));
			if(form.getAutor()!=null && !form.getAutor().trim().equals(""))form.setAutor(form.getAutor().replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES));
			if(form.getEdad()!=null && !form.getEdad().trim().equals(""))form.setEdad(form.getEdad().replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES));
			setDefaultsIfMissingSearchInput(form);
//			Valido el formulario para ver si es correcto
			errorMessages=validarCamposFecha(form.getDiaPublicacion(),form.getMesPublicacion(),form.getAnyoPublicacion());
			if(esVacioFormulario(form) && esVacioCajaTexto(form)) errorMessages.add(MENSAJE_NINGUNO_LLENO);
			else{
				if(!validarAsterisco(form.getBuscadorContenido()) || !validarAsterisco(form.getEdad()) || !validarAsterisco(form.getAutor())) errorMessages.add(MENSAJE_WILDCARD_SOLA);
				if(!validarAndQuery(form.getBuscadorContenido()) || !validarAndQuery(form.getEdad()) || !validarAndQuery(form.getAutor())) errorMessages.add(MENSAJE_SUMATORIO_INICIO);
				if(form.getTipoBusqueda() == null || !form.getTipoBusqueda().equals("03")) inicializarFormulario(form);
				if (form.getTipoBusqueda()!=null && form.getTipoBusqueda().equals("03")) validarPersonalizada(form);
			}
			if(errorMessages!=null && errorMessages.size()>0){
				SrvNodoService nodo = this.getSrvNodoService();
				NodoVO[] listaNodos = nodo.listarNodos();
				if(listaNodos == null || listaNodos.length == 0) form.setMostrarAmbito(new Boolean(false));
				else form.setMostrarAmbito(new Boolean(true));
				log("BuscarAvanzadoControllerImpl - validarFormulario: Existen errores de validacion="+errorMessages.toString());
				if(form.getBusquedaSimpleAvanzada()!=null && form.getBusquedaSimpleAvanzada().equals(DetallarControllerImpl.BUSCAR_SIMPLE))form.setValidado(ACCION_FORMULARIO_INVALIDO);
				else form.setValidado(ACCION_FORMULARIO_INVALIDO_AVANZADO);
				form.setEnlaceComunidadesSeleccionadas(this.generarEnlaceComunidades(form.getComunidadesSeleccionadas()));
				saveErrorMessage(request, errorMessages);
			}else{
				log("BuscarAvanzadoControllerImpl - validarFormulario: Formulario valido");
				form.setValidado(ACCION_FORMULARIO_VALIDO);
			}
			log("BuscarAvanzadoControllerImpl - validarFormulario FIN");
		}catch(Exception ex){
			logger.error("BuscarAvanzadoControllerImpl - validarFormulario ERROR: Formulario valido",ex);
			form.setValidado("ACCION_FORMULARIO_INVALIDO");
			saveErrorMessage(request, MENSAJE_GENERICO_BUSQUEDA);
		}
	}
	
	public void ejecutarBusquedaAvanzada(ActionMapping mapping, EjecutarBusquedaAvanzadaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ParametrosBusquedaAvanzadaVO param = null;
    	ResultadoBusquedaVO resultados = null;
    	String textoBusqueda = null;
    	
    //	Integer pagina= null;
    	List errores = new ArrayList();
    	try{
    		if(DetallarControllerImpl.TRUE.equals((String)AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO))) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_NEUTRO);
    		else if(form.getTipoLayoutBuscador()==null) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
			if(form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_BUSCADOR) || form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_NEUTRO)){
				try{
					Boolean administrador=new Boolean (false);
					//if(form.getKeyword()==null || form.getKeyword().trim().equals("")) 
					administrador = new Boolean(LdapUserDetailsUtils.esAdministrador());
					form.setUsuarioAdministrador(administrador);
					log("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada:Administrador=="+administrador.toString());
				}catch(Exception e){
					form.setUsuarioAdministrador(new Boolean (false));
					errores.add(MENSAJE_ERROR_AUTENTIFICACION);					
					logger.error("Error al llamar a LdapUserDetailsUtils.esAdministrador() de Soporte");
				}
			}else form.setUsuarioAdministrador(new Boolean (false));			
			
    		String idiomaNavegacion = null;
                try {
                    idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
                } catch (Exception e) {
                    idiomaNavegacion = "en"; //TODO: we have to fix this, ...
                }
//        	Elimino los espacios en blanco del formulario de los campos de wild-card
    		if(prepararFormulario(form)){
    			form.setIdiomaBuscador((form.getIdioma()==null)?devolverIdiomaBuscador(form.getIdiomaBuscador()):form.getIdioma());
    			form.setIdioma((form.getIdioma()==null)?form.getIdiomaBuscador():form.getIdioma());
//		    	Los idiomas que deben aparecer en el desplegable de buscar dependen del idioma de navegacion
				LocalizacionIdiomaVO[] localizacionesIdioma = I18n.getInstance().obtenerIdiomasBuscablesLocalizados(idiomaNavegacion);
				form.setIdiomaBuscadorBackingList(Arrays.asList(localizacionesIdioma), "idLocalizacion", "name");
				try{
					form.setNumeroResultadosLabelList(cargarNumeroResultadosLabel(new Locale(idiomaNavegacion)));
					form.setNumeroResultadosValueList(cargarNumeroResultadosValue());
				}catch(Exception ex){
					form.setNumeroResultadosLabelList(new String[0]); 
					form.setNumeroResultadosValueList(new String[0]);
					saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
				}
		    	if (form.getPagina() == null || form.getPagina().equals("")) form.setPagina("1");
				textoBusqueda = devolverTextoBusqueda(form.getBuscadorContenido(), form.getBuscadorContenidoSolo());
				form.setBuscadorContenidoEnlace(textoBusqueda.replaceAll(JAVA_PLUS, HTML_PLUS));
				log("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada con textoBusqueda["+textoBusqueda+"], idiomaBuscador["+form.getIdiomaBuscador()+"] y paginaRequerida["+form.getPagina()+"]");
//	        	PREPARAMOS LA CONSULTA DE BUSQUEDA
//	        	Por ahora utilizamos el locale. Cuando tengamos usuarios sera el idioma de navegacion por la aplicacion
	    		param = new ParametrosBusquedaAvanzadaVO();
	    		param.setIdiomaNavegacion(idiomaNavegacion);
	    		param.setIdiomaBusqueda(form.getIdioma());
	    		param.setOrigenPagina(new Integer(form.getPagina()));


                        // 16/11/2010   Fernando Garcia
                        //              We don't want removing dots or other characters from the original query
                        /*********************************/
                        if (textoBusqueda.trim().equals(".*")) {
                            param.setPalabrasClave("*");
                        } else {
                            param.setPalabrasClave(eliminarEspaciosBlanco(textoBusqueda));
                        }
                        // Original line
                        //param.setPalabrasClave(prepararTextoBusqueda(eliminarEspaciosBlanco(textoBusqueda)));
                        
	    		param.setFormato(form.getFormato());
	    		param.setKeyword(form.getKeyword());
	    		param.setDestinatarios(form.getDestinatarios());
	    		param.setRecurso(form.getRecurso());
	    		param.setBusquedaSimpleAvanzada((form.getBusquedaSimpleAvanzada() != null && !form.getBusquedaSimpleAvanzada().trim().equals(""))?form.getBusquedaSimpleAvanzada():DetallarControllerImpl.BUSCAR);
	    		param.setProcesoCognitivo(form.getProcesoCognitivo());
	    		param.setFechaPublicacion(construirFecha(form.getAnyoPublicacion(),form.getMesPublicacion(),form.getDiaPublicacion()));
				param.setContexto(form.getContexto());
				param.setNivelAgregacion(form.getNivelAgregacion());
				if(form.getEdad()!=null && !form.getEdad().trim().equals(""))param.setEdad(prepararTextoBusqueda(eliminarEspaciosBlanco(form.getEdad())));
				if(form.getAutor()!=null && !form.getAutor().trim().equals(""))param.setAutor(prepararTextoBusqueda(eliminarEspaciosBlanco(form.getAutor())));
				param.setSecuencia(form.getC_s_secuencia()!=null && !form.getC_s_secuencia().equals("")?new Boolean(form.getC_s_secuencia()):null);
				param.setValoracion(form.getValoracion()!=null && !form.getValoracion().equals("")?form.getValoracion().replaceAll(DetallarControllerImpl.GUION, DetallarControllerImpl.SEPARADOR_PALABRAS):null);
				if(form.getAreaCurricular()!=null && !form.getAreaCurricular().trim().equals("")){
					param.setAreaCurricular(form.getAreaCurricular());
					param.setArbolCurricularVigente(this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), form.getIdioma()));
    			}
				param.setIdTesauro((form.getIdTesauroSugerencia()!=null && !form.getIdTesauroSugerencia().trim().equals(""))?form.getIdTesauroSugerencia():form.getIdTesauro());
				String[] comuni=obtenerComunidades();
//				Comprobacion del nodo neutro
				if(comuni == null || comuni.length == 0) form.setMostrarAmbito(new Boolean(false));
				else form.setMostrarAmbito(new Boolean(true));
				//si b�squeda federada entonces se selecciona TODAS
				if(comuni!=null && comuni.length>0 && form.getTipoBusqueda()!=null && form.getTipoBusqueda().equals("01")){
					try{
//						introduzco el nombre del servidor para que se realice la llamada tambien en local
						param.setComunidadPeticion(request.getServerName());
						param.setComunidadesSeleccionadas(comuni);
						form.setEnlaceTodoAgrega("0"+DetallarControllerImpl.GUION+this.generarEnlaceComunidades(comuni));
					}catch (Exception e){
						logger.error("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada: Comunidades aut�nomas: error a la hora de cargar las url�s de las comunidades",e);
						errores.add(MENSAJE_ERROR_COMUNIDADES);						
					}
				}else if(form.getTipoBusqueda()!=null && form.getTipoBusqueda().equals("03") && form.getComunidadesSeleccionadas()!=null && form.getComunidadesSeleccionadas().length>0){
						try{
							String enlaceComunidades=this.generarEnlaceComunidades(form.getComunidadesSeleccionadas());
							if(form.getComunidadesSeleccionadas()[0].equals("0")) param.setComunidadesSeleccionadas(comuni);
							else param.setComunidadesSeleccionadas(obtenerComunidades(form.getComunidadesSeleccionadas()));
							if(form.getTipoBusqueda()==null || !form.getTipoBusqueda().equals("03"))form.setTipoBusqueda("02");
							form.setEnlaceComunidadesSeleccionadas(enlaceComunidades.trim());						
						}catch(Exception ex){
							logger.error("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada: Comunidades aut�nomas: error a la hora de cargar las url�s de las comunidades",ex);
							errores.add(MENSAJE_ERROR_COMUNIDADES);								
						}
				}else if(form.getEnlaceComunidadesSeleccionadas()!=null && !form.getEnlaceComunidadesSeleccionadas().trim().equals("")){
					if(form.getTipoBusqueda()==null || !form.getTipoBusqueda().equals("03"))form.setTipoBusqueda("02");
					form.setComunidadesSeleccionadas(form.getEnlaceComunidadesSeleccionadas().split("-"));
					String[] comunidadesSelecc = form.getComunidadesSeleccionadas();
					if((form.getComunidadesSeleccionadas()[0].equals("0"))){
						comunidadesSelecc = new String[form.getComunidadesSeleccionadas().length-1];
						for(int i=0; i<comunidadesSelecc.length;i++) comunidadesSelecc[i]=form.getComunidadesSeleccionadas()[i+1];
					}
					param.setComunidadesSeleccionadas(obtenerComunidades(comunidadesSelecc));
				}else{
					if(form.getTipoBusqueda()==null || !form.getTipoBusqueda().equals("03"))form.setTipoBusqueda("02");
					form.setEnlaceComunidadesSeleccionadas("");
				}
				param.setComunidadPeticion(request.getServerName());
				param.setNumeroResultados(new Integer(request.getSession().getServletContext().getInitParameter("max_res_totales")));
				Integer maxResPagina = 0;
				if(form.getNumeroResultados()!=null && !form.getNumeroResultados().equals(""))maxResPagina=new Integer(form.getNumeroResultados());
				else maxResPagina = new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"));
				param.setResultadosPorPagina(maxResPagina);
				param.setSearchFilters(formToSearchFiltersMap(form, request));
//		    	Invocamos el servicio de busqueda
				SrvBuscarService buscarService = this.getSrvBuscarService();
				resultados = buscarService.buscarAvanzado(param);
				log("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada: Resultados de busqueda avanzada ["+(resultados.getResultadoBusqueda()!= null?resultados.getResultadoBusqueda().length:0)+"], sugerencias["+(resultados.getSugerencias()!= null&&resultados.getSugerencias().length>0?resultados.getSugerencias()[0]+" ...":"SIN SUGERENCIAS")+"]");
//		    	Hay que traducir los valores de "tipoRecurso" por sus identificadores en lom-es y pasarselos asi al formulario
				ValoresBusquedaVO[] valoresBusquedaVO = traducirResultadosBusqueda(form.getPagina(), resultados.getResultadoBusqueda(), request, idiomaNavegacion, maxResPagina);				
				form.setResultadosVO(Arrays.asList(valoresBusquedaVO));
				form.setBuscadorContenido(textoBusqueda);
				int resultadosDesde = (Integer.parseInt(form.getPagina()) -1 ) * maxResPagina + 1;
				form.setResultadosDesde(String.valueOf(resultadosDesde));

				int resultadosHasta = resultadosDesde + maxResPagina - 1;
				resultadosHasta = (resultadosHasta > resultados.getNumeroResultados().intValue()? resultados.getNumeroResultados().intValue(): resultadosHasta);
				form.setResultadosHasta(String.valueOf(resultadosHasta));
				form.setNumMaxRes(resultados.getTotalResultados().toString());
				form.setQuisoDecir(resultados.getSugerencias());
				form.setTesauros(resultados.getTesauros());
				try{
					NodoSQIVO[] nodos = this.getSrvGestionSqiService().obtenerNodosSQI();
					if (nodos!=null && nodos.length>0){
						form.setNodosSQI(new Boolean(true));
						log("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada: Existen " + nodos.length + " nodos SQI indexados en la BBDD");
					}else{
						form.setNodosSQI(new Boolean(false));
						log("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada: No existe ning�n nodo SQI indexado en la BBDD");
					}
					
				}catch (Exception e){
					logger.error("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada: Error al intentar recuperar el numero de nodos SQI indexados en la tabla",e);
					form.setNodosSQI(new Boolean(false));
				}
//		    	Este metodo resuelve toda la problematica del banner de paginacion sobre el formulario.
				generarPaginas(	form,
						form.getPagina(),
	    						resultados.getNumeroResultados(),
	    						maxResPagina,
	    						maxResPagina);
    		}
		}catch (Exception ex){
			resultados=null;
			logger.error("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada ERROR: Error en la invocacion a la Busqueda Avanzada con parametros IdBusqueda["+param.getIdBusqueda()
					+"], IdiomaBusqueda["+param.getIdiomaBusqueda()+"], IdiomaNavegacion["+param.getIdiomaNavegacion()
					+"], PalabrasClave["+param.getPalabrasClave()+"], NumeroResultados["+param.getNumeroResultados()
					+"], OrigenPagina["+param.getOrigenPagina()+"],Formato["+param.getFormato()
					+"], Recurso["+param.getRecurso()+"], ProcesoCognitivo["+param.getProcesoCognitivo()
					+"], Contexto["+param.getContexto()+"], Edad["+param.getEdad()
					+"], Autor["+param.getAutor()+"], FechaPublicacion["+param.getFechaPublicacion()
					+"], AreaCurricular["+param.getAreaCurricular()+"], ArbolCurricularVigente["+param.getArbolCurricularVigente()
					+"], Secuencia["+param.getSecuencia()+"], NivelAgregacion["+param.getNivelAgregacion()+"], Valoracion["+param.getValoracion()
					+"], ResultadosPorPagina["+param.getResultadosPorPagina()+"]");
			logger.error("BuscarAvanzadoControllerImpl - ejecutarBusquedaAvanzada ERROR:", ex);
			errores.add(MENSAJE_GENERICO_BUSQUEDA);			
		}
		if(errores!=null && errores.size()>0)saveErrorMessage(request, errores);
	}
	
	public String analizaValidacion(ActionMapping mapping, AnalizaValidacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(form.getValidado().equals(ACCION_FORMULARIO_VALIDO))return ACCION_FORMULARIO_VALIDO;
		else if(form.getValidado().equals(ACCION_FORMULARIO_INVALIDO_AVANZADO)) return ACCION_FORMULARIO_INVALIDO_AVANZADO;
		return ACCION_FORMULARIO_INVALIDO;
	}
	
	public String analizaResultados(ActionMapping mapping, AnalizaResultadosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log("BuscarAvanzadoControllerImpl - analizaResultados");
		if(form.getResultadosVO()!=null && form.getResultadosVO().size() > 0) return ACCION_CON_RESULTADOS;
		else if((form.getBusquedaSimpleAvanzada()!=null && form.getBusquedaSimpleAvanzada().equals(DetallarControllerImpl.BUSCAR_SIMPLE)) || (form.getQuisoDecir()!=null && form.getQuisoDecir().length > 0) || (form.getTesauros()!=null && form.getTesauros().length > 0)) return ACCION_CON_SUGERENCIAS;
		form.setSinResultados(true);
		log("BuscarAvanzadoControllerImpl - analizaResultados: No existen resultados ni sugerencias.");
		return ACCION_SIN_RESULTADOS;
	}
	
	public String analizarVisualizacion(ActionMapping mapping, AnalizarVisualizacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		if(form.getTipoVisualizacion()!=null && !form.getTipoVisualizacion().equals("")) return form.getTipoVisualizacion();
//		return "SIN_IMAGENES";
		return ACCION_CON_IMAGENES;
	}
	
	public String analizaSeleccionEliminacion(ActionMapping mapping, AnalizaSeleccionEliminacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return form.getEliminados();
	}
	
	public void guardarBusquedaEnSesion(ActionMapping mapping, GuardarBusquedaEnSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			log("BuscarAvanzadoControllerImpl - guardarBusquedaEnSesion: Realizando insercion de datos de busqueda avanzada en sesion para retorno a este diagrama.");
			BuscarSession sesion = inicializarSesion(request);
			if(form.getTipoLayoutBuscador()!=null && form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_EMPAQUETADOR))logger.debug("BuscarAvanzadoControllerImpl - agregarOdes: Se agrega ode federado al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador());
			if (sesion == null) this.setBuscarSession(request, new BuscarSession());
//			Propiedades del contenido
			sesion.setBuscadorContenido(form.getBuscadorContenido());		
			sesion.setIdioma(form.getIdioma());
			sesion.setPagina((form.getPagina()!=null && !form.getPagina().trim().equals(""))?new Integer(form.getPagina()):null);
			sesion.setFormato(form.getFormato());
			sesion.setRecurso(form.getRecurso());
			sesion.setProcesoCognitivo(form.getProcesoCognitivo());
			sesion.setContexto(form.getContexto());
			sesion.setEdad(form.getEdad());
			sesion.setAutor(form.getAutor());
			sesion.setIdentificadorODE(form.getIdentificadorODE());
			sesion.setDiaPublicacion(form.getDiaPublicacion());
			sesion.setMesPublicacion(form.getMesPublicacion());
			sesion.setAnyoPublicacion(form.getAnyoPublicacion());
			sesion.setSecuencia(form.getC_s_secuencia());
			sesion.setKeyword(form.getKeyword());
			sesion.setValoracion(form.getValoracion());
			sesion.setNivelAgregacion(form.getNivelAgregacion());
			sesion.setDestinatarios(form.getDestinatarios());
			sesion.setTipoVisualizacion(form.getTipoVisualizacion());
			sesion.setTipoBusqueda(form.getTipoBusqueda());
			sesion.setAreaCurricular(form.getAreaCurricular());
			if (!generarEnlaceComunidades(form.getComunidadesSeleccionadas()).equals("") && generarEnlaceComunidades(form.getComunidadesSeleccionadas())!=null){
				sesion.setEnlaceComunidadesSeleccionadas(generarEnlaceComunidades(form.getComunidadesSeleccionadas()));
			}else sesion.setEnlaceComunidadesSeleccionadas(form.getEnlaceComunidadesSeleccionadas());
			sesion.setEnlaceTodoAgrega(form.getEnlaceTodoAgrega());
			sesion.setTipoLayoutBuscador(form.getTipoLayoutBuscador());
			sesion.setIdTesauro(form.getIdTesauro());
			sesion.setTesauroBusqueda(form.getIdTesauroSugerencia());
			sesion.setNomTesauros(form.getNomTesauros());
			sesion.setNumeroResultados(form.getNumeroResultados());
//			Si venimos desde la selecci�n del detalle de un ode en el listado, guardamos el origen para una posible vuelta del listado
			if((form.getListaIds()!=null && !form.getListaIds().equals("")) || (form.getIdentificadorODE() != null && !form.getIdentificadorODE().trim().equals("")))sesion.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSCAR);
			log("BuscarAvanzadoControllerImpl - guardarBusquedaEnSesion FIN");
		}catch (Exception ex){
    		logger.error("BuscarAvanzadoControllerImpl - guardarBusquedaEnSesion ERROR: Error al guardar la b�squeda en sesion",ex);
		}
	}
	
	public void listarIds(ActionMapping mapping, ListarIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			if (LdapUserDetailsUtils.esAdministrador()){		
				log("BuscarAvanzadoControllerImpl - listarIds: Es administrador");
				
				Object[] identificadoresODE=form.getIdRowSelectionAsArray();
				if(identificadoresODE!=null && identificadoresODE.length>0)
				{
					form.setEliminados("CON_RESULTADOS");
					log("BuscarAvanzadoControllerImpl - listarIds: Vamos a eliminar " + identificadoresODE.length + " ODEs");
					
					if (identificadoresODE.length>1)
					{
						form.setListaIds(identificadoresODE [0].toString()+ANDPERSAND);
						for (int k=1;k<identificadoresODE.length;k++) 
						{
							form.setListaIds(form.getListaIds()+(String) identificadoresODE [k]+ANDPERSAND);
						}
					}
					else if(identificadoresODE.length==1)
					{
						form.setListaIds(identificadoresODE [0].toString()+ANDPERSAND);
					}
					
					ParametrosBusquedaAvanzadaVO param=this.recuperarParametrosAvanzada(form, ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
					form.setIdHits(this.getSrvBuscarService().generadorIdentificadorAvanzado(param));
					try{
						form.setNumeroResultadosLabelList(cargarNumeroResultadosLabel(new Locale(form.getIdioma())));
						form.setNumeroResultadosValueList(cargarNumeroResultadosValue());
					}catch(Exception ex){
						form.setFormato(""); 
						form.setNumeroResultadosLabelList(new String[0]); 
						form.setNumeroResultadosValueList(new String[0]);
						saveErrorMessage(request,MENSAJE_GENERICO_BUSQUEDA);
					}
				}
				else
				{
					logger.error("BuscarAvanzadoControllerImpl - listarIds: No ha seleccionado ODEs");
					form.setEliminados("SIN_RESULTADOS");
					saveErrorMessage(request, ERROR_ELIMINANDO_ODES);
				}
			}else{
				logger.error("BuscarAvanzadoControllerImpl - listarIds: No tiene permisos para eliminar ODEs");
				saveErrorMessage(request, BuscarAvanzadoControllerImpl.MENSAJE_USUARIO_NO_LOGADO);
			}
		}catch(Exception e){
			logger.error("BuscarAvanzadoControllerImpl - listarIds: Error al intentar eliminar los ODEs seleccionados",e);
			saveErrorMessage(request, BuscarAvanzadoControllerImpl.MENSAJE_ERROR_ELIMINAR_ODE);
		}
	}
	
	@Override
	public void generarRSS(ActionMapping mapping, GenerarRSSForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			ParametrosBusquedaAgregadorVO param = new ParametrosBusquedaAgregadorVO();
			param.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSCARRSS);
			param.setIdiomaNavegacion(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
			param.setIdiomaBusqueda(form.getIdioma());
			param.setOrigenPagina(1);
			param.setPalabrasClave(eliminarEspaciosBlanco(form.getBuscadorContenido()).replaceAll(DetallarControllerImpl.HTML_QUOTES, DetallarControllerImpl.JAVA_QUOTES).replaceAll(HTML_PLUS, JAVA_PLUS).replaceAll(DetallarControllerImpl.DOT, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.DOUBLE_DOT, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_QUESTIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_QUESTIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_PARENTHESES, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_PARENTHESES, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_EXCLAMATIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_EXCLAMATIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.COMA, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.SLASH, DetallarControllerImpl.SEPARADOR_PALABRAS));
			param.setFormato(form.getFormato());
			param.setKeyword(form.getKeyword());
			param.setTipoBusqueda(form.getTipoBusqueda());
			param.setDestinatarios(form.getDestinatarios());
			param.setRecurso(form.getRecurso());
			param.setProcesoCognitivo(form.getProcesoCognitivo());
			param.setFechaPublicacion(construirFecha(form.getAnyoPublicacion(),form.getMesPublicacion(),form.getDiaPublicacion()));
			param.setContexto(form.getContexto());
			param.setNivelAgregacion(form.getNivelAgregacion());
			param.setEdad(form.getEdad());
			param.setAutor(form.getAutor());
			param.setComunidadPeticion(request.getServerName());
			param.setSecuencia(form.getC_s_secuencia()!=null && !form.getC_s_secuencia().equals("")?new Boolean(form.getC_s_secuencia()):null);
			param.setValoracion(form.getValoracion());
			if(form.getAreaCurricular()!=null && !form.getAreaCurricular().trim().equals("")){
				param.setAreaCurricular(form.getAreaCurricular());
				param.setArbolCurricularVigente(this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), form.getIdioma()));
			}
			param.setIdTesauro((form.getIdTesauroSugerencia()!=null && !form.getIdTesauroSugerencia().trim().equals(""))?form.getIdTesauroSugerencia():form.getIdTesauro());
			//si b�squeda federada entonces se selecciona TODAS
			if(form.getTipoBusqueda()!=null && form.getTipoBusqueda().equals("01") && form.getEnlaceTodoAgrega()!=null && !form.getEnlaceTodoAgrega().equals(""))param.setComunidadesSeleccionadas(obtenerComunidades());
			else if(form.getEnlaceComunidadesSeleccionadas()!=null && !form.getEnlaceComunidadesSeleccionadas().equals(""))param.setComunidadesSeleccionadas((form.getEnlaceComunidadesSeleccionadas().split("-")[0]!=null && form.getEnlaceComunidadesSeleccionadas().split("-")[0].equals("0"))?obtenerComunidades():obtenerComunidades(form.getEnlaceComunidadesSeleccionadas().split("-")));
			
			String maxRes = request.getSession().getServletContext().getInitParameter("max_res_totales");
			if (maxRes == null || maxRes.equals("")) maxRes = "1000";
			param.setNumeroResultados(new Integer(maxRes));
			param.setResultadosPorPagina(new Integer(20));
	
	//    	Invocamos el servicio de busqueda
			DataHandler data = this.getSrvAgregadorRssService().devuelveRssBusqueda(param);
			this.getSrvAgregadorRssService().eliminarFichero(param);
			if (data == null || data.getInputStream() == null){
				//logger.error("DescargarControllerImpl - descargarFicheroODE ERROR: Error generando el fichero ZIP con identificador["+form.getIdentificadorODE()+"]");
				//saveErrorMessage(request,MENSAJE_ERROR_DESCARGA);
			}
			response.setContentType("text/xml");
			OutputStream out = response.getOutputStream();
			InputStream in = data.getInputStream();
			//logger.debug("Descargando ODE con identificadorODE ["+form.getIdentificadorODE()+"] y nombre["+data.getName()+"]");
			byte[] buffer = new byte[BUFFER_SIZE];
			int count;
			while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
			{
				out.write(buffer, 0, count);
			}
			out.flush();
		}catch(Exception e){
			logger.error("BuscarAvanzadoControllerImpl - generarRSS: Error al intentar generar el Rss de la busqueda realizada",e);
		}
	}
	
	@Override
	public String analizaTipoBusqueda(ActionMapping mapping, AnalizaTipoBusquedaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(form.getTipoBusqueda()!=null && form.getTipoBusqueda().equals("04")) return ACCION_SQI;
		else return ACCION_AGREGA;
	}
	
	private String traducirNivelAgregacion(Integer nivelAgregacion,Locale locale) throws IOException{
		ResourceBundle datosResources = ResourceBundle.getBundle("application-resources",locale);
		String nivelAgregacionLabel = datosResources.getString(this.getPropertyValue("avanzado.agregacion."+nivelAgregacion.toString()));
		return nivelAgregacionLabel;
	}

	private void validarPersonalizada(ValidarFormularioForm form) throws Exception{
		if ((form.getAnyoPublicacion()==null || form.getAnyoPublicacion().equals(""))&& (form.getAreaCurricular()==null || form.getAreaCurricular().equals(""))&& 
				(form.getAutor()==null || form.getAutor().equals(""))&& (form.getC_s_secuencia()==null || form.getC_s_secuencia().equals(""))&&		
				(form.getContexto()==null || form.getContexto().equals(""))&& (form.getDescripcion()==null || form.getDescripcion().equals(""))&& 
				(form.getDestinatarios()==null || form.getDestinatarios().equals(""))&& (form.getDiaPublicacion()==null || form.getDiaPublicacion().equals(""))&&
				(form.getEdad()==null || form.getEdad().equals(""))&&	(form.getFormato()==null || form.getFormato().equals(""))&&(form.getKeyword()==null || form.getKeyword().equals(""))&& 
				(form.getIdTesauro()==null || form.getIdTesauro().equals(""))&& (form.getMesPublicacion()==null || form.getMesPublicacion().equals(""))&& 
				(form.getNivelAgregacion()==null || form.getNivelAgregacion().equals(""))&& (form.getNomTesauros()==null || form.getNomTesauros().equals(""))&& 
				(form.getProcesoCognitivo()==null || form.getProcesoCognitivo().equals(""))&& (form.getRecurso()==null || form.getRecurso().equals(""))&& 
				(form.getTitulo()==null || form.getTitulo().equals(""))&&(form.getValoracion()==null || form.getValoracion().equals(""))){
				String[] comunidades=obtenerComunidades();
				if ((form.getComunidadesSeleccionadas()==null || form.getComunidadesSeleccionadas().length==0) && (form.getEnlaceComunidadesSeleccionadas()==null || form.getEnlaceComunidadesSeleccionadas().equals("")) && (form.getEnlaceTodoAgrega()==null || form.getEnlaceTodoAgrega().equals(""))){
					form.setTipoBusqueda("02");
				}else if(form.getComunidadesSeleccionadas()!=null && (form.getComunidadesSeleccionadas().length-1==comunidades.length || form.getComunidadesSeleccionadas().length==comunidades.length)){
					form.setTipoBusqueda("01");
				}
		}else{
			form.setTipoBusqueda("03");
		}
		
	}
	
	private String generarEnlaceComunidades(String[] comunidadesSeleccionadas){
		String enlaceComunidades="";
		if(comunidadesSeleccionadas != null && comunidadesSeleccionadas.length>0) {
			for(int i=0; i<comunidadesSeleccionadas.length;i++){
				if(enlaceComunidades!="") enlaceComunidades=enlaceComunidades+"-"+comunidadesSeleccionadas[i];
				else enlaceComunidades=comunidadesSeleccionadas[i];
			}
		}
		return enlaceComunidades;
	}
	
	private boolean prepararFormulario(EjecutarBusquedaAvanzadaForm form){
		log("BuscarAvanzadoControllerImpl - prepararFormulario");
		if(form.getMesPublicacion()!=null) form.setMesPublicacion((!form.getMesPublicacion().trim().equals("") && Integer.parseInt(form.getMesPublicacion().trim())<10 && Integer.parseInt(form.getMesPublicacion().trim())>0)?"0"+Integer.parseInt(form.getMesPublicacion().trim()):form.getMesPublicacion().trim());
    	if(form.getDiaPublicacion()!=null) form.setDiaPublicacion((!form.getDiaPublicacion().trim().equals("") && Integer.parseInt(form.getDiaPublicacion().trim())<10 && Integer.parseInt(form.getDiaPublicacion().trim())>0)?"0"+Integer.parseInt(form.getDiaPublicacion().trim()):form.getDiaPublicacion().trim());
    	if(form.getAnyoPublicacion()!=null) form.setAnyoPublicacion(form.getAnyoPublicacion().trim());
    	log("BuscarAvanzadoControllerImpl - prepararFormulario FIN");
    	return true;
	}
	
    //Metodo que transforma un array de TerminoVO en un array de string; donde el valor del string ser� el valor del nom de cada TerminoVO
    private String[] transformarTerminoVOaString(TerminoVO[] termino, Locale locale){  
//    	Chequeamos que la informacion que nos pasan sea correcta.
    	if (termino != null && termino.length >0 ){
    		String[] var=new String[termino.length];
    		List varList=new ArrayList();
//  		Recorremos el vector de TerminoVO y vamos realizando los cambios
    		for(int i=0;i<var.length ; i++){
    			var[i]=termino[i].getNomTermino();
    			varList.add(var[i]);
    		}
    		 Collections.sort(varList);
    		 for(int i=0;i<varList.size() ; i++)	
     		 {
    			 var[i]=(String) varList.get(i);
     		 }
    		return var;
    	}
    	return new String[]{""};
    }
    
    
    private String[] transformarTerminoValueVOaString(TerminoVO[] terminoValue , TerminoVO[] termino, Object[] terminoOrdenado){   	
//    	Chequeamos que la informacion que nos pasan sea correcta.
    	if (terminoValue != null && terminoValue.length >0 ){
    		String[] var=new String[terminoOrdenado.length];
    		var[0]=BuscarAvanzadoControllerImpl.NO_CHOICE_VALUE;
//  		Recorremos el vector de TerminoVO y vamos realizando los cambios
    		for(int i=0;i<termino.length ; i++){
    			for(int j = 0; j < terminoOrdenado.length ; j++){
    				if(termino[i].getNomTermino().equals(terminoOrdenado[j].toString())){
    					var[j]=terminoValue[i].getNomTermino();
    				}
    			}
    		}
    		log("BuscarAvanzadoControllerImpl - transformarTerminoValueVOaString: Obtenemos labels["+terminoOrdenado.toString()+"] para values["+var.toString()+"]");
    		return var;
    	}
    	return new String[]{""};
    }
	//  Este metodo recibe el identificador del nivel educativo que se ha elegido y 
	//  extrae toda la ruta hasta el padre y la convierte a string con el texto ordenado
	//  desde el padre hasta el hijo traducido al idioma que se le diga.
	  private String convertirStringAreaCurricular(String areaCurricular, String idioma) throws Exception{
		  List rutaPadrevo = Arrays.asList(this.getSrvTaxonomiaService().obtenerTaxonPath(areaCurricular, this.getPropertyValue("nombreAreaCurricularTax"), idioma));
		  Collections.reverse(rutaPadrevo);
		  TaxonVO[] taxVORutaPadre = (TaxonVO[])rutaPadrevo.toArray();
		  String rutaPadre[] = new String[taxVORutaPadre.length];
		  for (int i = 0; i < taxVORutaPadre.length; i++) rutaPadre[i]= taxVORutaPadre[i].getValorTax();
		  return array2String(rutaPadre);
	  }
	  
	  private String array2String(String[] array) {
			String str = "";
			if (array != null && array.length > 0) {
				for (int i = 0; i < array.length; i++) {
					str+=array[i];
					if ((i + 1) < array.length) str+= SLASH;
				}
			}
			return str;
	  }
	  
	  private String[] cargarNumeroResultadosLabel(Locale locale){
		  ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, locale);
		  log("BuscarAvanzadoControllerImpl - cargarNumeroResultadosLabel: cargando labels de Numero resultados localizados en["+locale.getDisplayLanguage()+"]");
		  String[] formatoLabel = {datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.diez"),
		  datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.veinte"),datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.treinta"),
		  datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.cuarenta"),datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.cincuenta")};
		  return formatoLabel;
	  }
	
	  private String[] cargarNumeroResultadosValue() throws IOException{
		  log("BuscarAvanzadoControllerImpl - cargarNumeroResultadosValue: cargando valores de Numero resultados");
		  String[] formatoArray = getPropertyValue("resultados.valor").split(",");
		  String[] formatoValue = {formatoArray[0], formatoArray[1], formatoArray[2], formatoArray[3], formatoArray[4]};
		  return formatoValue;
	  }
  
	  private String[] cargarFormatoLabel(Locale locale){
		  ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, locale);
		  log("BuscarAvanzadoControllerImpl - cargarFormatoLabel: cargando labels de Formato localizados en["+locale.getDisplayLanguage()+"]");
		  String[] formatoLabel = {datosResources.getString("configurar.avanzado.formato.texto.uno"),
		  datosResources.getString("configurar.avanzado.formato.texto.dos"),datosResources.getString("configurar.avanzado.formato.texto.tres"),
		  datosResources.getString("configurar.avanzado.formato.texto.cuatro"),datosResources.getString("configurar.avanzado.formato.texto.cinco")};
		  return formatoLabel;
	  }
	
	  private String[] cargarFormatoValue(){
		  log("BuscarAvanzadoControllerImpl - cargarFormatoValue: cargando valores de Formato");
		  String[] formatoArray = pSpringProperties.getProperty("avanzado.formato").split(",");
		  String[] formatoValue = {formatoArray[0], formatoArray[1], formatoArray[2], formatoArray[3], formatoArray[4]};
		  return formatoValue;
	  }

	  private String[] cargarC_S_SecuenciaLabel(Locale locale){
		  ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, locale);
		  log("BuscarAvanzadoControllerImpl - cargarC_S_SecuenciaLabel: cargando labels de con/sin secuencia localizados en["+locale.getDisplayLanguage()+"]");
		  String[] c_s_secuenciaLabel = {
		  datosResources.getString("configurar.avanzado.c_s_secuencia.texto.conSecuencia"),
		  datosResources.getString("configurar.avanzado.c_s_secuencia.texto.sinSecuencia")};
		  return c_s_secuenciaLabel;
	  }
  
	  private String[] cargarC_S_SecuenciaValue(){
		  log("BuscarAvanzadoControllerImpl - cargarC_S_SecuenciaValue: cargando valores de con/sin secuencia");
		  String[] c_s_secArray = pSpringProperties.getProperty("avanzado.c_s_secuencia").split(",");
		  String[] c_s_secuenciaValue = {c_s_secArray[0], c_s_secArray[1]};
		  return c_s_secuenciaValue;
	  }

	private String[] cargarValoracionLabel(Locale locale){
		ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, locale);
		log("BuscarAvanzadoControllerImpl - cargarValoracionLabel: cargando labels de valoracion localizados en["+locale.getDisplayLanguage()+"]");
		String[] valoracionLabel = {datosResources.getString("configurar.avanzado.valoracion.texto.cero"),
			datosResources.getString("configurar.avanzado.valoracion.texto.uno"),datosResources.getString("configurar.avanzado.valoracion.texto.dos"),
			datosResources.getString("configurar.avanzado.valoracion.texto.tres"),datosResources.getString("configurar.avanzado.valoracion.texto.cuatro")};
		return valoracionLabel;
	}
	
	private String[] cargarValoracionValue(){
		log("BuscarAvanzadoControllerImpl - cargarValoracionValue: cargando valores de valoracion");
		String[] valoracionArray = pSpringProperties.getProperty("avanzado.valoracion").split(",");
		return valoracionArray;
	}
	
	private String[] cargarNivelAgregacionLabel(Locale locale){
		ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, locale);
		log("BuscarAvanzadoControllerImpl - cargarNivelAgregacionLabel: cargando labels de nivelAgregacion localizados en["+locale.getDisplayLanguage()+"]");
		String[] nivelAgregacionLabel = {datosResources.getString("configurar.avanzado.agregacion.texto.uno"),
			datosResources.getString("configurar.avanzado.agregacion.texto.dos"),datosResources.getString("configurar.avanzado.agregacion.texto.tres"),
			datosResources.getString("configurar.avanzado.agregacion.texto.cuatro")};
		return nivelAgregacionLabel;
	}
	
	private String[] cargarNivelAgregacionValue(){
		log("BuscarAvanzadoControllerImpl - cargarNivelAgregacionValue: cargando valores de nivelAgregacion");
		String[] nivelAgregacionArray = pSpringProperties.getProperty("avanzado.agregacion").split(",");
		return nivelAgregacionArray;
	}
	
	private boolean esVacioFormulario(ValidarFormularioForm form) throws Exception{
//		Ahora tenemos que comprobar que se haya seleccionado almenos un concepto entre todos los del
//		formulario para poder realizar una busqueda por algun concepto. Si no es asi, tenemos
//		que dar una excepcion. No comprobamos el idioma por	que nunca va a estar vacio, pero no vamos a permitir
//		buscar por todo el indice del idioma.
		if (!comprobarAtributoConValor(form.getAnyoPublicacion()) &&
			!comprobarAtributoConValor(form.getAreaCurricular()) &&
			!comprobarAtributoConValor(form.getAutor()) &&
			!comprobarAtributoConValor(form.getC_s_secuencia()) &&
			!comprobarAtributoConValor(form.getContexto()) &&
			!comprobarAtributoConValor(form.getDiaPublicacion()) &&
			!comprobarAtributoConValor(form.getEdad()) &&
			!comprobarAtributoConValor(form.getFormato()) &&
			!comprobarAtributoConValor(form.getKeyword()) &&
			!comprobarAtributoConValor(form.getMesPublicacion()) &&
			!comprobarAtributoConValor(form.getProcesoCognitivo()) &&
			!comprobarAtributoConValor(form.getRecurso()) &&
			!comprobarAtributoConValor(form.getIdTesauro()) &&
			!comprobarAtributoConValor(form.getIdTesauroSugerencia()) &&
			!comprobarAtributoConValor(form.getNivelAgregacion()) &&
			!comprobarAtributoConValor(form.getDestinatarios()) &&
			!comprobarAtributoConValor(form.getValoracion())){
			form.setContadorPropiedadesContenido("0");
			return true;
		}
		return false;
	}
	
	private boolean esVacioFormulario(CargaFormularioBusquedaAvanzadaForm form) throws Exception{
//		Ahora tenemos que comprobar que se haya seleccionado almenos un concepto entre todos los del
//		formulario para poder realizar una busqueda por algun concepto. Si no es asi, tenemos
//		que dar una excepcion. No comprobamos el idioma por	que nunca va a estar vacio, pero no vamos a permitir
//		buscar por todo el indice del idioma.
		if (!comprobarAtributoConValor(form.getAnyoPublicacion()) &&
			!comprobarAtributoConValor(form.getAreaCurricular()) &&
			!comprobarAtributoConValor(form.getAutor()) &&
			!comprobarAtributoConValor(form.getC_s_secuencia()) &&
			!comprobarAtributoConValor(form.getContexto()) &&
			!comprobarAtributoConValor(form.getDiaPublicacion()) &&
			!comprobarAtributoConValor(form.getEdad()) &&
			!comprobarAtributoConValor(form.getFormato()) &&
			!comprobarAtributoConValor(form.getMesPublicacion()) &&
			!comprobarAtributoConValor(form.getProcesoCognitivo()) &&
			!comprobarAtributoConValor(form.getRecurso()) &&
			!comprobarAtributoConValor(form.getIdTesauro()) &&
			!comprobarAtributoConValor(form.getNivelAgregacion()) &&
			!comprobarAtributoConValor(form.getDestinatarios()) &&
			!comprobarAtributoConValor(form.getValoracion())){
			return true;
		}
		return false;
	}
	
	private boolean esVacioCajaTexto(ValidarFormularioForm form){
		if(!comprobarAtributoConValor(form.getBuscadorContenido()) &&
		!comprobarAtributoConValor(form.getBuscadorContenidoSolo()))return true;
		return false;
	}
	
	private String contarCamposCargados(String nivelAgregacion, String destinatarios,String formato, String idiomaBuscador, String recurso, String procesoCognitivo, String contexto, String edad, String autor, String diaPublicacion, String mesPublicacion, String anyoPublicacion, String secuencia, String valoracion){
		int contador=0;
		if(comprobarAtributoConValor(formato)) contador++;
		if(comprobarAtributoConValor(idiomaBuscador)) contador++;
		if(comprobarAtributoConValor(recurso)) contador++;
		if(comprobarAtributoConValor(procesoCognitivo))contador++;
		if(comprobarAtributoConValor(contexto))contador++;
		if(comprobarAtributoConValor(edad))contador++;
		if(comprobarAtributoConValor(autor))contador++;
		if(comprobarAtributoConValor(diaPublicacion) || comprobarAtributoConValor(mesPublicacion) || comprobarAtributoConValor(anyoPublicacion))contador++;
		if(comprobarAtributoConValor(secuencia))contador++;
		if(comprobarAtributoConValor(valoracion))contador++;
		if(comprobarAtributoConValor(destinatarios))contador++;
		if(comprobarAtributoConValor(nivelAgregacion))contador++;
		log("BuscarAvanzadoControllerImpl - contarCamposCargados=["+String.valueOf(contador)+"]");
		return String.valueOf(contador);
	}
	
	private String contarCamposArbolCurricular(ValidarFormularioForm form){
		log("BuscarAvanzadoControllerImpl - contadorCamposArbolCurricular - areaCurricular=["+form.getAreaCurricular()+"]");
		if(comprobarAtributoConValor(form.getAreaCurricular())) return String.valueOf(1);
		return String.valueOf(0);
	}
	
	private boolean comprobarAtributoConValor(String variable){
		//Compruebo que el existe el campo analizado
		return(variable!=null && !variable.equals(""));
	}
	
//	M�todo que comprueba que en los campos de fecha son valores son correctos
	private List validarCamposFecha(String dia, String mes, String anyo) throws Exception{
		log("BuscarAvanzadoControllerImpl - validarCamposFecha");
		List errorMessages = new ArrayList();
//		Comprobamos si los campos de fecha son numeros
		try {
			if (dia != null && !dia.trim().equals("") && (Integer.valueOf(dia.trim()).intValue() > 31 || Integer.valueOf(dia.trim()).intValue() < 1))
				errorMessages.add(MENSAJE_DIA_INCORRECTO);
			if (mes != null && !mes.trim().equals("") && (Integer.valueOf(mes.trim()).intValue() > 12 || Integer.valueOf(mes.trim()).intValue() < 1))
				errorMessages.add(MENSAJE_MES_INCORRECTO);
			if (anyo != null && !anyo.trim().equals("") && (Integer.valueOf(anyo.trim()).intValue() > 2999 || Integer.valueOf(anyo.trim()).intValue() < 1900))
				errorMessages.add(MENSAJE_ANYO_INCORRECTO);
		} catch (Exception e) {
			errorMessages.add(MENSAJE_CARACTER_FECHA);
		}
		log("BuscarAvanzadoControllerImpl - validaCamposFecha=["+dia+"/"+mes+"/"+anyo+"]. Validado=["+errorMessages.isEmpty());
		return errorMessages;
	}

	private void saveErrorMessage(HttpServletRequest request, List messages) throws Exception{
		log("BuscarAvanzadoControllerImpl - saveErrorMessage: Formulario incorrecto------------.");
		boolean encontrado;		
		if(request!=null && messages!=null && messages.size()>0)
		{
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
	
	private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("BuscarAvanzadoControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//		 devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
	
	private boolean validarAsterisco(String campo){
		log("BuscarAvanzadoControllerImpl - validaAsterisco: Campo=["+campo+"]");
		if(campo!=null){
			String[] palabras= campo.trim().split(" ");
			if(palabras.length>0)for(int i=0; i < palabras.length;i++) if(palabras[i].startsWith("*")||palabras[i].startsWith("?")||palabras[i].startsWith(DetallarControllerImpl.HTML_QUOTES+"*")||palabras[i].startsWith("'*")) return false;
		}
		log("BuscarAvanzadoControllerImpl - validaAsterisco: Validado");
		return true;
	}
	
	private boolean validarAndQuery(String campo){
		log("BuscarAvanzadoControllerImpl - validarAndQuery +: Campo=["+campo+"]");
		if(campo!=null && !campo.trim().equals("") && (campo.trim().startsWith("+ ") || campo.trim().endsWith(" +")))return false;
		log("BuscarAvanzadoControllerImpl - validarAndQuery +: Validado");
		return true;
	}
	
//  Metodo que elimina los espacios en blanco de la variable
    private String eliminarEspaciosBlanco(String campo){
    	log("BuscarAvanzadoControllerImpl - eliminarEspaciosBlanco: Campo antes=["+campo+"]");
    	if(campo!=null){
    		String retorno = "";
    		while(!campo.trim().equals("")){
    			if(contains(campo, DetallarControllerImpl.HTML_QUOTES) && contains(campo.substring(campo.indexOf(DetallarControllerImpl.HTML_QUOTES)+1), DetallarControllerImpl.HTML_QUOTES)){
	    			StringBuffer resultado = new StringBuffer();
	    			int indiceFinalFrase = campo.substring(campo.indexOf(DetallarControllerImpl.HTML_QUOTES)+1).indexOf(DetallarControllerImpl.HTML_QUOTES)+campo.indexOf(DetallarControllerImpl.HTML_QUOTES)+7;
	    			String[] palabras = campo.substring(campo.indexOf(DetallarControllerImpl.HTML_QUOTES),indiceFinalFrase).trim().split(DetallarControllerImpl.SEPARADOR_PALABRAS);
			    	if(palabras.length>0){
			    		for(int i=0; i < palabras.length;i++) if(!palabras[i].equals("")) resultado.append((palabras[i].equals(DetallarControllerImpl.HTML_QUOTES) || resultado.toString().equals(DetallarControllerImpl.HTML_QUOTES))? palabras[i] : DetallarControllerImpl.SEPARADOR_PALABRAS + palabras[i]);	
			    	}
			    	if(!campo.substring(0 , campo.indexOf(DetallarControllerImpl.HTML_QUOTES)).trim().equals(""))retorno = retorno +  DetallarControllerImpl.SEPARADOR_PALABRAS + campo.substring(0 , campo.indexOf(DetallarControllerImpl.HTML_QUOTES)).trim();
			    	retorno = retorno + DetallarControllerImpl.SEPARADOR_PALABRAS + resultado.toString();
			    	campo = DetallarControllerImpl.SEPARADOR_PALABRAS + campo.substring(indiceFinalFrase).trim();
    			}else{
    				String[] palabras = campo.trim().split(DetallarControllerImpl.SEPARADOR_PALABRAS);
			    	for(int i=0; i < palabras.length ;i++) if(!palabras[i].equals("")) retorno = retorno + DetallarControllerImpl.SEPARADOR_PALABRAS + palabras[i];
			    	campo="";
    			}
    			log("BuscarAvanzadoControllerImpl - eliminarEspaciosBlanco: Campo depues=["+campo+"]");
    		}
	    	return retorno.trim();
    	}
    	log("BuscarAvanzadoControllerImpl - eliminarEspaciosBlanco FIN");
    	return campo;
    }
    
    private void generarPaginas(EjecutarBusquedaAvanzadaForm form, String pagina, Integer numRes, Integer numMaxResPagina, Integer numMaxPaginas){
    	try{
//    		Calculo el numero de paginas que salen del numero de resultados que se otienen por la busqueda.
    		log("BuscarAvanzadoControllerImpl - generaPaginas");
    		int numeroTotalPaginas = numRes.intValue() / numMaxResPagina.intValue();
    		int paginaInt = Integer.parseInt(pagina);
    		if ((numRes.intValue() % numMaxResPagina.intValue()) > 0) numeroTotalPaginas++;
//    		Si el n�mero de resultados por p�gina es 1 no se pinta nada.
    		if(numeroTotalPaginas==1){
    			form.setPaginasAsArray(new String[1]);
    			form.setAnterior(null);
    			form.setSiguiente(null);   
    		}else{
//        		Calculo el siguiente y el anterior.
    			if ((paginaInt -1) <= 0) form.setAnterior(null);
    			else form.setAnterior(""+ (paginaInt - 1));
    			
    			if ((paginaInt) >= numeroTotalPaginas) form.setSiguiente(null);
    				else form.setSiguiente(""+ (paginaInt + 1));
    			
//        		Calculo la horquilla de paginas por delante y por detras de la actual.
    			int orquilla = numMaxPaginas.intValue() / 2;
    			int listaDesde;
    			int listaHasta;
    			if ((paginaInt - orquilla) <= 0) listaDesde = 1;
    				else listaDesde = paginaInt - orquilla;
    			if ((paginaInt + orquilla) >= numeroTotalPaginas) listaHasta = numeroTotalPaginas;
    				else listaHasta = paginaInt + orquilla;
    			String paginas[] = new String[listaHasta - listaDesde + 1]; 
    			for (int i = 0; i < paginas.length; i++) {
    				paginas[i] = ""+ listaDesde;
    				listaDesde++;
    			}
    			form.setPaginasAsArray(paginas);
    			log("BuscarAvanzadoControllerImpl - generaPaginas FIN: listaDesde=["+listaDesde+"] listaHasta=["+listaHasta+"]");
    		}
    	}catch (Exception ex){
    		logger.error("BuscarAvanzadoControllerImpl - generaPaginas ERROR: Error al generar las p�ginas. ",ex);
    	}
    }
    
//  Este m�todo nos devuelve el texto de b�squeda; que puede venir de tres sitios diferentes:del buscador general, de la p�gina de resultados el buscador de arriba y de la p�gina de resultados del buscador de abajo
    private String devolverTextoBusqueda(String buscadorContenido, String buscadorContenidoSolo){
    	log("BuscarAvanzadoControllerImpl - devuelveTextoBusqueda");
//    	Determinamos cuales han sido los parametros de busqueda con los que se nos ha invocado.
//    	Se pulsa sobre el buscador general
    	if (buscadorContenido!= null && !buscadorContenido.trim().equals("")) return buscadorContenido.replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES);    	 	
//    	Se pulsa sobre el buscador inferior
    	else if (buscadorContenidoSolo!= null && !buscadorContenidoSolo.trim().equals("")) return buscadorContenidoSolo.replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES);
    	else return "";
    }
	
	/**
	 * Metodo que construye el string de la fecha de publicacion necesario para la busqueda
	 */
	private String construirFecha(String anyoFechaPublicacion,String mesFechaPublicacion,String diaFechaPublicacion){
		log("BuscarAvanzadoControllerImpl - construyeFecha");
		if(!comprobarAtributoConValor(anyoFechaPublicacion) && !comprobarAtributoConValor(mesFechaPublicacion) &&	!comprobarAtributoConValor(diaFechaPublicacion)) return "";
		log("BuscarAvanzadoControllerImpl - construyeFecha: fecha a enviar=["+traducirFecha(anyoFechaPublicacion) + traducirFecha(mesFechaPublicacion) + traducirFecha(diaFechaPublicacion)+"]");
		return traducirFecha(anyoFechaPublicacion) + traducirFecha(mesFechaPublicacion) + traducirFecha(diaFechaPublicacion);
		
	}
	
	private String traducirFecha(String campo){
		if(campo!=null && !campo.trim().equals(""))return campo;
		return ASTERISK;
	}
	
//  Este metodo traduce los campos de resultados de busqueda que hagan falta.
//  
//  de los valores de busqueda que le pasan a sus identificadores
//  en el vocabulario del lom-es. Devuelve la misma lista de resultados de busqueda con las listas de tipo de recurso
//  traducidas de esta manera y sin tocar el resto de datos.
		private ValoresBusquedaVO[] traducirResultadosBusqueda(String pagina,ValoresBusquedaVO[] sResults, HttpServletRequest request, String idioma, Integer maxResPagina) throws Exception{
		log("BuscarAvanzadoControllerImpl - traduceResultadosBusqueda");
		if (sResults != null && sResults.length > 0) {
			ValoresBusquedaVO[] valoresRetorno = new
					ValoresBusquedaVO[sResults.length];
			log("BuscarAvanzadoControllerImpl - traduceResultadosBusqueda: Traduciendo ["+sResults.length+"] resultados de busqueda avanzada");
			List <String>listaRecurso = new ArrayList<String>();
			String taxonomia = this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idioma);
			for (int i = 0; i < sResults.length; i++) {
				for (int j = 0; j < sResults[i].getTipoRecurso().length; j++) {
					listaRecurso.add(sResults[i].getTipoRecurso()[j]);
				}
			}
			TerminoVO[] terminosTraducidos = new TerminoVO[0];
			try{
				TerminoYPadreVO[] terminoArray = new TerminoYPadreVO[listaRecurso.size()];
				log("BuscarAvanzadoControllerImpl - traduceTipoRecurso: Traduciendo ["+listaRecurso.size()+"] tipos de recurso en resultados avanzados");
				for (int i = 0; i < listaRecurso.size(); i++) {
		//		Vamos rellenando este objeto con todos los terminos que nos encontremos y traducirlos al mismo tiempo
					log("BuscarAvanzadoControllerImpl - traduceTipoRecurso: Queremos traducir ["+listaRecurso.get(i)+"] tipo de recurso");
					terminoArray[i] = new TerminoYPadreVO(this.getPropertyValue("tipoRecurso"),listaRecurso.get(i),"en","");
				}
				terminoArray = this.getSrvVocabulariosControladosService().obtenerIdTermino(terminoArray);
				List <String>retornoArray = new ArrayList<String>();
				for (int i = 0; i < terminoArray.length; i++) {
					if (terminoArray[i].getIdTermino() != null) retornoArray.add(terminoArray[i].getIdTermino());
				}
				terminosTraducidos = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(retornoArray.toArray(new String[0]),idioma);
				log("BuscarAvanzadoControllerImpl - traduceTipoRecurso: Obtenida traduccion de ["+terminosTraducidos.length+"] terminos para idioma["+"idioma"+"]");
			} catch (RemoteException e) {
				logger.error("BuscarAvanzadoControllerImpl - traduceTipoRecurso ERROR: Error en la invocacion al servicio de vocabularios controlados traduciendo tipos de recurso"+array2String(listaRecurso.toArray(new String[0]))+"] idioma en LOM-ES[en] identificador vocabulario["+taxonomia+"]",e);
			} catch (IOException e) {
				logger.error("BuscarAvanzadoControllerImpl - traduceTipoRecurso ERROR: Error obteniendo propiedad \"tipoRecurso\" del fichero de propiedades del modulo Buscador traduciendo tipos de recurso"+array2String(listaRecurso.toArray(new String[0]))+"] idioma en LOM-ES[en] identificador vocabulario["+taxonomia+"]",e);
			} catch (Exception e) {
				logger.error("BuscarAvanzadoControllerImpl - traduceTipoRecurso ERROR: Error general traduciendo tipos de recurso["+array2String(listaRecurso.toArray(new String[0]))+"] idioma en LOM-ES[en] identificador vocabulario["+taxonomia+"]",e);
				e.printStackTrace();
			}

			int h=0;

			for (int i = 0; i < sResults.length; i++) {
				String[] recurso = new String[0];
				recurso = new String[sResults[i].getTipoRecurso().length];
				for (int j = 0; j < sResults[i].getTipoRecurso().length; j++, h++) {
					//
					// Ugly HACK ALERT:
					//
					// As agreed with NWLG, we will set the resource type to
					// a default value for display purposes whenever there are
					// _any_ issues with retrieving the type of a resource in
					// the results.
					//
					try {
						recurso[j] = terminosTraducidos[h].getNomTermino();
					} catch (Exception e) {
						if (logger.isDebugEnabled()) {
							logger.debug("HACK: Stifled "+ e + ", setting " +
									"the type to \""+ IBuscadorConstants.
									DEFAULT_RESOURCE_TYPE + "\" for the " +
									"resource [ ID: '" + sResults[i].getId() +
									"', Title: '" + sResults[i].getTitulo() +
									"' ].");
						}
						if (logger.isTraceEnabled()) {
							logger.trace("Stack Trace for the Exception " +
									"raised during resource type retrieval", e);
						}
						recurso[j] = IBuscadorConstants.DEFAULT_RESOURCE_TYPE;
					}
				}

				// Raw Curriculars: Concatenated strings of taxon IDs for each
				// taxon path assigned to this resource.
				String[] rCurriculars = sResults[i].getAreaCurricular();

				// If taxonomy matches, materialise each taxon path found.  This
				// is another instance where agrega assumes a single taxonomy.
				List<String> mCurriculars = new ArrayList<String>();
				
				if (sResults[i].getArbolCurricularVigente().equals(taxonomia) &&
						rCurriculars != null) {

					if (logger.isDebugEnabled()) {
						logger.debug("Materialising " +	rCurriculars.length +
								" taxon path(s) for Result #" + i);
					}

					for (int j = 0; j < rCurriculars.length; j++) {
						if (rCurriculars[j] != null) {
							String[] acTermIds = rCurriculars[j].split("/");
							assert acTermIds.length > 0 :
									"String.split() should return an array " +
									"of at least one string.";

							String tid = acTermIds[acTermIds.length - 1];
							addCurricularToList(
									tid,
									mCurriculars,
									getPropertyValue("nombreAreaCurricularTax"),
									idioma);
						}
					}

					if (logger.isDebugEnabled()) {
						logger.debug("Completed materialising taxon path(s) " +
								"for Result #" + i);
					}
				}
				
				valoresRetorno[i] = new ValoresBusquedaVO(sResults[i].getValoracion(), sResults[i].getTitulo(), recurso, sResults[i].getRanking(), mCurriculars.toArray(new String[0]), sResults[i].getCurso(), sResults[i].getId(), calcularNumeroOde(pagina, i + 1, maxResPagina), sResults[i].getUrlImagen(), sResults[i].getNodo(), sResults[i].getArbolCurricularVigente(), sResults[i].getNivelAgregacion(), sResults[i].getFormato(), this.traducirNivelAgregacion(sResults[i].getNivelAgregacion(), new Locale(idioma)), sResults[i].getAmbito(), sResults[i].getEsVisualizable(), sResults[i].getDescripcion(), sResults[i].getFechaPublicacion(), sResults[i].getHoraPublicacion(), sResults[i].getSize(), sResults[i].getContentProviders(), sResults[i].getAuthors(), sResults[i].getTypicalLearningTime());
				boolean visualizable = false;
				for (int j = 0; j < valoresRetorno[i].getAmbito().length && !visualizable; j++) {
					if(valoresRetorno[i].getAmbito()!=null && valoresRetorno[i].getAmbito()[0]!=null && (valoresRetorno[i].getAmbito()[0].equals(UNIVERSAL) || valoresRetorno[i].getAmbito()[j].trim().equals(DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO).toString()))){
						valoresRetorno[i].setEsVisualizable(new Boolean (true));
						visualizable=true;
					}
				}
				if(!visualizable){
					valoresRetorno[i].setEsVisualizable(new Boolean (false));
				}
			}
			return valoresRetorno;
		}
		log("BuscarAvanzadoControllerImpl - traduceResultadosBusqueda FIN: No se ha traducido nada");
		return sResults;// si no hay nada que hacer, pues devolvemos lo mismo.
	}

	private void addCurricularToList(
			String tid, List acList, String taxon, String lang)
			throws Exception {

		assert acList != null;

		if (tid != null && tid.length() != 0) {
			
			// Retrieve the reverse Taxon Path VOs for the Term ID
			final TaxonVO[] tp = this.getSrvTaxonomiaService().
					obtenerTaxonPath(tid, taxon, lang);

			if (tp != null && tp.length > 0) {
				StringBuilder cBuilder = new StringBuilder();

				//
				// Add each term value to the area curricular in reverse.
                //
                // We could prepend in normal order but that would lower the
                // readability for the loop body and would entail additional
                // bound checking penalty in StringBuilder.insert().
				//
				cBuilder.append(tp[tp.length - 1].getValorTax());
				for (int i = tp.length - 2; i >= 0; i--) {
					cBuilder.append('/').append(tp[i].getValorTax());
				}

				String curricular = cBuilder.toString();

				if (logger.isDebugEnabled()) {
					logger.debug("Materialised '" + curricular + "'");
				}

				acList.add(curricular);
			}
		}
	}

	private String calcularNumeroOde(String numeroPagina, int numOde, Integer maxResPagina){
		String numeroOde="";
		if(numeroPagina !=null){
			String decenasString="";
			String unidadesString = "";
			int numPag=Integer.parseInt(numeroPagina);
			if(numPag==1){
				if (numOde>=10){
					unidadesString = String.valueOf(numOde).substring(1);
					decenasString = String.valueOf(numOde).substring(0,1);
				}else{
					unidadesString = String.valueOf(numOde);
				}
			}else{
				if (numOde>=10){
					unidadesString = String.valueOf(numOde).substring(1);
					int decenas=(maxResPagina*(numPag-1))+numOde;
					decenasString = String.valueOf(decenas).substring(0,String.valueOf(decenas).length()-1);
				}else{
					int decenas=(maxResPagina*(numPag-1))+numOde;
					decenasString = String.valueOf(decenas).substring(0,String.valueOf(decenas).length()-1);
					unidadesString = String.valueOf(numOde);
				}
			}
	//		Quitamos el cero de la primera pagina
			if(decenasString.equals("0")) numeroOde = unidadesString;
			else numeroOde = decenasString + unidadesString;
		}
		return numeroOde;
	}
	
//	Este metodo recibe un array de identificadores de areas curriculares que han sido encontradas y 

//	traduce cada entrada del indice por su correspondiente etiqueta
	private String[] convertirStringAreaCurricular(String[] areaCurricular, String idioma) throws Exception{
		if (areaCurricular != null && areaCurricular.length > 0 ){
			ArrayList taxones = new ArrayList();
			for (int i = 0; i < areaCurricular.length; i++){
				String[] split=null;
				if (!areaCurricular[i].equals("")){
//					Hago el split por '/'
					split=areaCurricular[i].split("/");
//					Ordenamos los taxones, ya que nadie me asegura que esten ordenados. El resultado me da el taxon m�s
//					largo el primero de la lista despues de una comparacion lexicogr�fica.
					sortAreaCurricularDescendente(split,split.length);
//					Ahora cogemos el primer elemento y lo mandamos traducir. Nos devuelve la ruta traducida hasta el padre.
					try{
						List rutaPadrevo = Arrays.asList(this.getSrvTaxonomiaService().obtenerTaxonPath(split[0], this.getPropertyValue("nombreAreaCurricularTax"), idioma));
						TaxonVO[] taxVORutaPadre = (TaxonVO[])rutaPadrevo.toArray();
						String ruta = "";
						for (int j= 0; j< taxVORutaPadre.length; j++){
							if (j == (taxVORutaPadre.length-1))ruta= taxVORutaPadre[j].getValorTax() + ruta;
							else if (j==0)ruta= "/" + taxVORutaPadre[j].getValorTax();
							else ruta= "/" + taxVORutaPadre[j].getValorTax() + ruta;
						}
						log("BuscarAvanzadoControllerImpl - convertirStringAreaCurricular: Traducido path de arbol curricular ["+ruta+"] a idioma["+idioma+"]");
						taxones.add(ruta);
					}catch(Exception e){
//						 Puede pasar que la traduccion no funcione, pero no por ello me tengo que parar.
						 logger.error("BuscarAvanzadoControllerImpl - convertirStringAreaCurricular ERROR: Error al traducir area curricular con taxon["+split[0]+"] al idioma["+idioma+"]. No hay traduccion posible." , e);
					}
				}
			}
			return (taxones.size()>0?(String[])taxones.toArray(new String[taxones.size()]):new String[]{""});
		}
		return new String[]{""};
	}

	private static String sortAreaCurricularDescendente(String [] array, int len){
		int a,b;
		String temp;
		int sortTheStrings = len - 1;
		for (a = 0; a < sortTheStrings; ++a)
		for (b = 0; b < sortTheStrings; ++b)
		if(array[b].compareTo(array[b + 1]) < 0){
			temp = array[b];
			array[b] = array[b + 1];
			array[b + 1] = temp;
		}
		return array[0];
	}
	
	private boolean contains (String word, String pattern){
		return (word.indexOf(pattern) != -1);
	}
    
    private es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO recuperarParametrosAvanzada(ListarIdsForm form, String idiomaNavegacion){
    	ParametrosBusquedaAvanzadaVO param=new ParametrosBusquedaAvanzadaVO();  
    	param.setAutor(form.getAutor());
    	param.setContexto(form.getContexto());
    	param.setDescripcion(form.getDescripcion());
    	param.setEdad(form.getEdad());
    	param.setFechaPublicacion(construirFecha(form.getAnyoPublicacion(),form.getMesPublicacion(),form.getDiaPublicacion()));
    	param.setFormato(form.getFormato());
    	param.setIdiomaBusqueda(form.getIdioma());
    	param.setIdiomaNavegacion(idiomaNavegacion);
    	param.setAreaCurricular(form.getAreaCurricular());
    	param.setPalabrasClave(form.getBuscadorContenido());
    	param.setProcesoCognitivo(form.getProcesoCognitivo()); 
    	param.setRecurso(form.getRecurso()); 
    	param.setSecuencia(form.getC_s_secuencia()!=null && !form.getC_s_secuencia().equals("")?new Boolean(form.getC_s_secuencia()):null); 
    	param.setTitulo(form.getTitulo()); 
    	param.setValoracion(form.getValoracion()!=null && !form.getValoracion().equals("")?form.getValoracion():null);
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
		String[] resultado = new String[comunidadesSeleccionadas.length];
		for(int i=0; i < comunidadesSeleccionadas.length;i++){
   	 		for(int j=0; j < comunidades.length;j++) {
   	 			if(!comunidadesSeleccionadas[i].equals("0") && j==Integer.parseInt(comunidadesSeleccionadas[i])-2) resultado[i]=comunidades[j];
   	 		}
		}
		return resultado;
	}
    
    private void cargarFormularioSesion (AnalizaEntradaForm form, HttpServletRequest request){
		BuscarSession sesion = this.getBuscarSession(request);
		form.setAutor(sesion.getAutor());
		form.setBuscadorContenido(sesion.getBuscadorContenido());
		form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
		form.setC_s_secuencia(sesion.getSecuencia());
		if(sesion.getEnlaceComunidadesSeleccionadas()!=null && !sesion.getEnlaceComunidadesSeleccionadas().equals("")){
			form.setComunidadesSeleccionadas(sesion.getEnlaceComunidadesSeleccionadas().split("-"));
			form.setEnlaceComunidadesSeleccionadas(sesion.getEnlaceComunidadesSeleccionadas());
		}
		form.setContexto(sesion.getContexto());
		form.setDescripcion(sesion.getDescripcion());
		form.setEdad(sesion.getEdad());
		form.setDiaPublicacion(sesion.getDiaPublicacion());
		form.setMesPublicacion(sesion.getMesPublicacion());
		form.setAnyoPublicacion(sesion.getAnyoPublicacion());
		form.setFormato(sesion.getFormato());
		form.setIdioma(sesion.getIdioma());
		form.setKeyword(sesion.getKeyword());
		form.setAreaCurricular(sesion.getAreaCurricular());
		if(sesion.getPagina()!=null && !sesion.getPagina().equals(""))form.setPagina(sesion.getPagina().toString());
		form.setProcesoCognitivo(sesion.getProcesoCognitivo());
		form.setRecurso(sesion.getRecurso());
		form.setTitulo(sesion.getTitulo());
		form.setValoracion(sesion.getValoracion());
		form.setNivelAgregacion(sesion.getNivelAgregacion());
		form.setTipoVisualizacion(sesion.getTipoVisualizacion());
		form.setTipoBusqueda(sesion.getTipoBusqueda());
		form.setDestinatarios(sesion.getDestinatarios());
		form.setNumeroResultados(sesion.getNumeroResultados());
		if(sesion.getTipoLayoutBuscador()!=null && !sesion.getTipoLayoutBuscador().equals(""))form.setTipoLayoutBuscador(sesion.getTipoLayoutBuscador());
		if(sesion.getIdTesauro()!=null && !sesion.getIdTesauro().equals(""))form.setIdTesauro(sesion.getIdTesauro());
		if(sesion.getTesauroBusqueda()!=null && !sesion.getTesauroBusqueda().equals(""))form.setIdTesauroSugerencia(sesion.getTesauroBusqueda());
		if(sesion.getNomTesauros()!=null && !sesion.getNomTesauros().equals(""))form.setNomTesauros(sesion.getNomTesauros());
	}
	
	private BuscarSession inicializarSesion(HttpServletRequest request){
		BuscarSession sesion = this.getBuscarSession(request);
//		Conservo los �nicos par�metros constantes
		if(sesion.getEmpIdOde() != null || sesion.getEmpIdDestino() != null || sesion.getEmpTipoEmpaquetador() != null){
			log("BuscarAvanzadoControllerImpl - inicializarSesion: Se agrega ode federado al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador());
			String idODe=sesion.getEmpIdOde();
			String idDestino=sesion.getEmpIdDestino();
			String tipoEmpaquetador=sesion.getEmpTipoEmpaquetador();
			sesion = new BuscarSession();
			sesion.setEmpIdOde(idODe);
			sesion.setEmpIdDestino(idDestino);
			sesion.setEmpTipoEmpaquetador(tipoEmpaquetador);
		}else{
			sesion = new BuscarSession();
		}
		this.setBuscarSession(request,sesion);
		return sesion;
	}
	
	private void inicializarFormulario(ValidarFormularioForm form){
//		Conservo los �nicos par�metros constantes
		form.setAutor(null);
		form.setC_s_secuencia(null);
		form.setComunidadesSeleccionadas(null);
		form.setEnlaceComunidadesSeleccionadas(null);
		form.setContexto(null);
		form.setDescripcion(null);
		form.setEdad(null);
		form.setDiaPublicacion(null);
		form.setMesPublicacion(null);
		form.setAnyoPublicacion(null);
		form.setFormato(null);
		form.setAreaCurricular(null);
		form.setProcesoCognitivo(null);
		form.setRecurso(null);
		form.setTitulo(null);
		form.setValoracion(null);
		form.setKeyword(null);
		form.setNivelAgregacion(null);
		form.setIdTesauro(null);
		form.setNomTesauros(null);
	}
	
	private String devolverIdiomaBuscador(String idioma) throws Exception{
		String idiomaNavegacion = "";
		if ((idioma != null) && !idioma.equals("") && !idioma.equals("#")) return idioma;
		else if(LdapUserDetailsUtils.estaAutenticado()){
				try{
					idiomaNavegacion=LdapUserDetailsUtils.getIdiomaBusqueda();
					if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				} catch (Exception e) {
					logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error en al obtener idioma b�squeda usuario LDAP, se recoge idioma de fichero propiedades.",e);
					idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				}
	   	}else idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		return idiomaNavegacion;
	}
	
	private String obtenerIdiomaBusqueda() throws Exception{
	   	String idiomaNavegacion = "";
	   	if(LdapUserDetailsUtils.estaAutenticado()){
				try{
					idiomaNavegacion=LdapUserDetailsUtils.getIdiomaBusqueda();
					if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				} catch (Exception e) {
					logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error en al obtener idioma b�squeda usuario LDAP, se recoge idioma de fichero propiedades.",e);
					idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				}
	   	}else idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			return idiomaNavegacion;   
	}
	
	private String prepararTextoBusqueda(String texto){
		if(texto!=null && !texto.equals(""))return texto.replaceAll(DetallarControllerImpl.HTML_QUOTES, DetallarControllerImpl.JAVA_QUOTES).replaceAll(BuscarAvanzadoControllerImpl.HTML_PLUS, BuscarAvanzadoControllerImpl.JAVA_PLUS).replaceAll(DetallarControllerImpl.DOT, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.DOUBLE_DOT, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_QUESTIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_QUESTIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_PARENTHESES, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_PARENTHESES, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.OPEN_EXCLAMATIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.CLOSE_EXCLAMATIONMARK, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.COMA, DetallarControllerImpl.SEPARADOR_PALABRAS).replaceAll(DetallarControllerImpl.SLASH, DetallarControllerImpl.SEPARADOR_PALABRAS);
		return "";
	}
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}

	private HashMap formToSearchFiltersMap(
			EjecutarBusquedaAvanzadaForm form, HttpServletRequest req) {
		HashMap sfMap = new HashMap();
		HttpSession session = req.getSession();
		assert form != null;

		//
		// Keep mapping simple for this small list of filters.  The form bean
		// attributes are passed as empty strings if not set by the user from
		// the home page.  During pagination and while returning from other
		// pages eg resource details, agrega passes all the form attributes as
		// request parameters.  There are too many entry points to deal with
		// so we track filter keys as session parameters.
		//
		// TODO: Retrieve the target indexador key names as configurable values
		//       from a common utility source that may some day exist in agrega.
		//

		setFilterParam(
				session,
				sfMap,
				form.getKeystageSearchFilter(),
				"campo_keystage"
		);

		setFilterParam(
				session,
				sfMap,
				form.getSubjectSearchFilter(),
				"campo_subject"
		);

		setFilterParam(
				session,
				sfMap,
				form.getLearningTimeSearchFilter(),
				"campo_typicalLearningTime"
		);


		setFilterParam(
				session,
				sfMap,
				form.getIntendedEndUserRoleSearchFilter(),
				"campo_destinatarios"
		);


		setFilterParam(
				session,
				sfMap,
				form.getIntendedFMTSearchFilter(),
				"campo_formato"
		);



		return sfMap;
	}

	private void setFilterParam(
			HttpSession session, HashMap sfMap, String fVal, String fKey) {

		if (fVal == null) {              // No filters from the referer
			Object fValSessionObj = session.getAttribute(fKey);
			if (fValSessionObj instanceof String) {
				sfMap.put(fKey, (String)fValSessionObj);
			}
		} else if (fVal.length() == 0) { // User did not select this filter key
			session.removeAttribute(fKey);
		} else {                         // User specified a filter value
			sfMap.put(fKey, fVal);
			session.setAttribute(fKey, fVal);
		}

	}

	private void setDefaultsIfMissingSearchInput(ValidarFormularioForm form) {
		assert form != null;
		String searchTerms = form.getBuscadorContenido();
		
		// No search terms specified?
		if (searchTerms == null || searchTerms.trim().length() == 0) {
			form.setBuscadorContenido(DEFAULT_SEARCH_PATTERN);
		}
	}
}
