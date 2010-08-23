/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.busquedaSQI;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.buscar.servicios.LomEsVO;
import es.pode.buscar.negocio.buscar.servicios.ParamBusquedaSQIVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaSQIVO;
import es.pode.buscar.negocio.buscar.servicios.SrvBuscarService;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController
 */
public class BusquedaSQIControllerImpl extends BusquedaSQIController
{
	private static Logger logger = Logger.getLogger(BusquedaSQIControllerImpl.class);
	private java.util.Properties pSpringProperties = null;
	public final static String APPLICATION_PROPERTIES = "application-resources";

	
	public static final String HTML_PLUS = "%2B";
	public static final String JAVA_PLUS = "\\+";
	

	private final static String ACCION_FORMULARIO_ERROR = "FORMULARIO_ERROR";
	private final static String ACCION_FORMULARIO_VALIDO = "FORMULARIO_VALIDO";

	public final static String MENSAJE_NINGUNO_LLENO = "configurar.avanzado.controller.exception.NingunCampoLleno.SQI";
	public final static String MENSAJE_GENERICO_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";
	public final static String MENSAJE_WILDCARD_SOLA = "configurar.avanzado.controller.exception.noAsterisco";
	public final static String MENSAJE_SUMATORIO_INICIO = "configurar.avanzado.controller.exception.sumatorioInicio";
	
	public final static String MENSAJE_ERROR_AUTENTIFICACION="configurar.avanzado.controller.exception.errorAutentificacion";
	
	
	
	

    /**
     * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController#analizarFormulario(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.busquedaSQI.AnalizarFormularioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String analizarFormulario(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.busquedaSQI.AnalizarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	log("BusquedaSQIControllerImpl - analizarFormulario");
    	List errorMessages = null;
    	boolean formError =false;
    	if(form.getTipoLayoutBuscador()==null){
			try
			{
				AgregaProperties properties = AgregaPropertiesImpl.getInstance();
				String neutro = (AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO));	    	
		    	if(DetallarControllerImpl.TRUE.equals(neutro)) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_NEUTRO);
		    	else form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
		    	form.setBuscadorContenido(devolverTextoBusqueda(form.getBuscadorContenido(), form.getBuscadorContenidoSolo()));
//				Valido el formulario para ver si es correcto
				if(esVacioCajaTexto(form)){
					errorMessages.add(MENSAJE_NINGUNO_LLENO);
					formError=true;
				}
				else{
					formError=false;
					if(!validarAsterisco(form.getBuscadorContenido())){
						errorMessages.add(MENSAJE_WILDCARD_SOLA);
						formError=true;
					}
					if(!validarAndQuery(form.getBuscadorContenido())){
						errorMessages.add(MENSAJE_SUMATORIO_INICIO);
						formError=true;
					}
				}
			}catch (Exception e)
			{
				logger.error("BusquedaSQIControllerImpl - analizarFormulario ERROR: formulario erroneo", e);
				form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
			}
		}
    	if (formError){
    		return ACCION_FORMULARIO_ERROR;
    	}else{
    		return ACCION_FORMULARIO_VALIDO;
    	}		
    }


    /**
     * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController#ejecutarBusquedaSQI(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.busquedaSQI.EjecutarBusquedaSQIForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void ejecutarBusquedaSQI(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.busquedaSQI.EjecutarBusquedaSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	ParamBusquedaSQIVO param = null;
    	ResultadoBusquedaSQIVO resultados = new ResultadoBusquedaSQIVO();
    	String textoBusqueda = null;
    	List errores = new ArrayList();
    	try{
    		if(form.getTipoLayoutBuscador()==null) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);    		
			if(form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_BUSCADOR) || form.getTipoLayoutBuscador().equals(DetallarControllerImpl.LAYOUT_NEUTRO)){
				try{
					Boolean administrador=new Boolean (false);
					if(form.getKeyword()==null || form.getKeyword().trim().equals("")) administrador = new Boolean(LdapUserDetailsUtils.esAdministrador());
					form.setUsuarioAdministrador(administrador);
					log("BusquedaSQIControllerImpl - ejecutarBusquedaSQI:Administrador=="+administrador.toString());
				}catch(Exception e){
					form.setUsuarioAdministrador(new Boolean (false));
					errores.add(MENSAJE_ERROR_AUTENTIFICACION);					
					logger.error("Error al llamar a LdapUserDetailsUtils.esAdministrador() de Soporte");
				}
			}else form.setUsuarioAdministrador(new Boolean (false));			
			
    		String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
//        	Elimino los espacios en blanco del formulario de los campos de wild-card
    		
			form.setIdiomaBuscador((form.getIdioma()==null)?devolverIdiomaBuscador(form.getIdiomaBuscador()):form.getIdioma());
			
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
			log("BusquedaSQIControllerImpl - ejecutarBusquedaSQI con textoBusqueda["+textoBusqueda+"], idiomaBuscador["+form.getIdiomaBuscador()+"] y paginaRequerida["+form.getPagina()+"]");
//	        	PREPARAMOS LA CONSULTA DE BUSQUEDA
//	        	Por ahora utilizamos el locale. Cuando tengamos usuarios sera el idioma de navegacion por la aplicacion
    		param = new ParamBusquedaSQIVO();
    		param.setOrigenPagina(new Integer(form.getPagina()));
    		param.setPalabrasClave(eliminarEspaciosBlanco(textoBusqueda).replaceAll(DetallarControllerImpl.HTML_QUOTES, DetallarControllerImpl.JAVA_QUOTES).replaceAll(HTML_PLUS, JAVA_PLUS));
    		param.setNumeroResultados(new Integer(request.getSession().getServletContext().getInitParameter("max_res_totales")));
			Integer maxResPagina = 0;
			if(form.getNumeroResultados()!=null && !form.getNumeroResultados().equals(""))maxResPagina=new Integer(form.getNumeroResultados());
			else maxResPagina = new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"));
			param.setResultadoPorPagina(maxResPagina);
//		    	Invocamos el servicio de busqueda
			try{
				SrvBuscarService buscarService = this.getSrvBuscarService();
				resultados = buscarService.buscarSQI(param);
				log("BusquedaSQIControllerImpl - ejecutarBusquedaSQI: Resultados de busqueda avanzada ["+(resultados.getResultadoBusqueda()!= null?resultados.getResultadoBusqueda().length:0)+"]");
			}catch (Exception e){
				logger.error("BusquedaSQIControllerImpl - ejecutarBusquedaSQI: Error al recuperar los resultados de busqueda",e);
				resultados.setNumeroResultados(0);
				resultados.setResultadoBusqueda(new LomEsVO[0]);
			}

			String[] comuni=obtenerComunidades();
//			Comprobacion del nodo neutro
			if(comuni == null || comuni.length == 0) form.setMostrarAmbito(new Boolean(false));
			else form.setMostrarAmbito(new Boolean(true));
			
			form.setLomEsVO(Arrays.asList(resultados.getResultadoBusqueda()));
			form.setBuscadorContenido(textoBusqueda);
			int resultadosDesde = (Integer.parseInt(form.getPagina()) -1 ) * maxResPagina + 1;
			form.setResultadosDesde(resultadosDesde);

			int resultadosHasta = resultadosDesde + maxResPagina - 1;
			resultadosHasta = (resultadosHasta > resultados.getNumeroResultados().intValue()? resultados.getNumeroResultados().intValue(): resultadosHasta);
			form.setResultadosHasta(String.valueOf(resultadosHasta));
			form.setNumMaxRes(resultados.getNumeroResultados().toString());
			form.setResultadosDesde(resultadosDesde);
			form.setResultadosHasta(String.valueOf(resultadosHasta));

//		    Este metodo resuelve toda la problematica del banner de paginacion sobre el formulario.
			generarPaginas(	form,
					form.getPagina(),
    						resultados.getNumeroResultados(),
    						maxResPagina,
    						maxResPagina);
		}catch (Exception ex){
			resultados=null;
			logger.error("BusquedaSQIControllerImpl - ejecutarBusquedaSQI ERROR: Error en la invocacion a la Busqueda SQI ");
			logger.error("BuscquedaSQIControllerImpl - ejecutarBusquedaSQI ERROR:", ex);
			errores.add(MENSAJE_GENERICO_BUSQUEDA);			
		}
		for (int i=0;i<errores.size();i++){
			if(errores!=null && errores.size()>0) saveErrorMessage(request,(String)errores.get(i));
		}
    }

    /**
     * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController#analizarTipoBusqueda(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.busquedaSQI.AnalizarTipoBusquedaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String analizarTipoBusqueda(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.busquedaSQI.AnalizarTipoBusquedaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	BuscarSession sesion = this.getBuscarSession(request);
		 String tipoBusqueda = sesion.getTipoBusqueda();
		return tipoBusqueda;
    }

    
    private boolean esVacioCajaTexto(AnalizarFormularioForm form){
		if(!atributoConValor(form.getBuscadorContenido()) &&
		!atributoConValor(form.getBuscadorContenidoSolo()))return true;
		return false;
	}
    
    
    private boolean atributoConValor(String variable){
		//Compruebo que el existe el campo analizado
		return(variable!=null && !variable.equals(""));
	}
    
    
//  Este método nos devuelve el texto de búsqueda; que puede venir de tres sitios diferentes:del buscador general, de la página de resultados el buscador de arriba y de la página de resultados del buscador de abajo
    private String devolverTextoBusqueda(String buscadorContenido, String buscadorContenidoSolo){
    	log("BusquedaSQIControllerImpl - devuelveTextoBusqueda");
//    	Determinamos cuales han sido los parametros de busqueda con los que se nos ha invocado.
//    	Se pulsa sobre el buscador general
    	if (buscadorContenido!= null && !buscadorContenido.trim().equals("")) return buscadorContenido.replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES);    	 	
//    	Se pulsa sobre el buscador inferior
    	else if (buscadorContenidoSolo!= null && !buscadorContenidoSolo.trim().equals("")) return buscadorContenidoSolo.replaceAll(DetallarControllerImpl.JAVA_QUOTES, DetallarControllerImpl.HTML_QUOTES);
    	else return "";
    }
    
    
    private boolean validarAsterisco(String campo){
		log("BuscarAvanzadoControllerImpl - validaAsterisco: Campo=["+campo+"]");
		if(campo!=null){
			String[] palabras= campo.trim().split(" ");
			if(palabras.length>0)for(int i=0; i < palabras.length;i++) if(palabras[i].startsWith("*")||palabras[i].startsWith("?")||palabras[i].startsWith(DetallarControllerImpl.HTML_QUOTES+"*"+DetallarControllerImpl.HTML_QUOTES)||palabras[i].startsWith("'*'")) return false;
		}
		log("BuscarAvanzadoControllerImpl - validaAsterisco: Validado");
		return true;
	}
	
    
	private boolean validarAndQuery(String campo){
		log("BusquedaSQIControllerImpl - validarAndQuery +: Campo=["+campo+"]");
		if(campo!=null && !campo.trim().equals("") && (campo.trim().startsWith("+ ") || campo.trim().endsWith(" +")))return false;
		log("BusquedaSQIControllerImpl - validarAndQuery +: Validado");
		return true;
	}
    
	
	private String[] cargarNumeroResultadosLabel(Locale locale){
		  ResourceBundle datosResources = I18n.getInstance().getResource(APPLICATION_PROPERTIES, locale);
		  log("BusquedaSQIControllerImpl - cargarNumeroResultadosLabel: cargando labels de Numero resultados localizados en["+locale.getDisplayLanguage()+"]");
		  String[] formatoLabel = {datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.diez"),
		  datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.veinte"),datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.treinta"),
		  datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.cuarenta"),datosResources.getString("listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados.cincuenta")};
		  return formatoLabel;
	  }
	
	  private String[] cargarNumeroResultadosValue() throws IOException{
		  log("BusquedaSQIControllerImpl - cargarNumeroResultadosValue: cargando valores de Numero resultados");
		  String[] formatoArray = getPropertyValue("resultados.valor").split(",");
		  String[] formatoValue = {formatoArray[0], formatoArray[1], formatoArray[2], formatoArray[3], formatoArray[4]};
		  return formatoValue;
	  }
	  
	  
	  private String getPropertyValue(String sKey) throws IOException {
			InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
			if (this.pSpringProperties == null) {
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
			fIsSpringProperties.close();
			log("BuscquedaSQIControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//			 devolvemos la propiedad
			return pSpringProperties.getProperty(sKey);
		}
	  
	  private String devolverIdiomaBuscador(String idioma) throws Exception{
			String idiomaNavegacion = "";
			if ((idioma != null) && !idioma.equals("") && !idioma.equals("#")) return idioma;
			else if(LdapUserDetailsUtils.estaAutenticado()){
					try{
						idiomaNavegacion=LdapUserDetailsUtils.getIdiomaBusqueda();
						if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
					} catch (Exception e) {
						logger.error("BusquedaSQIControllerImpl - devolverIdiomaBuscador: Error en al obtener idioma búsqueda usuario LDAP, se recoge idioma de fichero propiedades.",e);
						idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
					}
		   	}else idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			return idiomaNavegacion;
		}
	  
	  
	  private boolean contains (String word, String pattern){
			return (word.indexOf(pattern) != -1);
		}
	  
	  
//	  Metodo que elimina los espacios en blanco de la variable
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
	    			log("BusquedaSQIControllerImpl - eliminarEspaciosBlanco: Campo depues=["+campo+"]");
	    		}
		    	return retorno.trim();
	    	}
	    	log("BusquedaSQUIControllerImpl - eliminarEspaciosBlanco FIN");
	    	return campo;
	    }
	  
	    
	    private void generarPaginas(EjecutarBusquedaSQIForm form, String pagina, Integer numRes, Integer numMaxResPagina, Integer numMaxPaginas){
	    	try{
//	    		Calculo el numero de paginas que salen del numero de resultados que se otienen por la busqueda.
	    		log("BusquedaSQIControllerImpl - generaPaginas");
	    		int numeroTotalPaginas = numRes.intValue() / numMaxResPagina.intValue();
	    		int paginaInt = Integer.parseInt(pagina);
	    		if ((numRes.intValue() % numMaxResPagina.intValue()) > 0) numeroTotalPaginas++;
//	    		Si el número de resultados por página es 1 no se pinta nada.
	    		if(numeroTotalPaginas==1){
	    			form.setPaginasAsArray(new String[1]);
	    			form.setAnterior(null);
	    			form.setSiguiente(null);   
	    		}else{
//	        		Calculo el siguiente y el anterior.
	    			if ((paginaInt -1) <= 0) form.setAnterior(null);
	    			else form.setAnterior(""+ (paginaInt - 1));
	    			
	    			if ((paginaInt) >= numeroTotalPaginas) form.setSiguiente(null);
	    				else form.setSiguiente(""+ (paginaInt + 1));
	    			
//	        		Calculo la horquilla de paginas por delante y por detras de la actual.
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
	    			log("BuscquedaSQIControllerImpl - generaPaginas FIN: listaDesde=["+listaDesde+"] listaHasta=["+listaHasta+"]");
	    		}
	    	}catch (Exception ex){
	    		logger.error("BusquedaSQIControllerImpl - generaPaginas ERROR: Error al generar las páginas. ",ex);
	    	}
	    }
	    
	    private String[] obtenerComunidades() throws RemoteException, Exception{		
			NodoVO[] nodoLista = this.getSrvNodoService().listarNodos();
	   	 	String[]comuni = new String[nodoLista.length];
	   	 	for(int j=0; j<nodoLista.length;j++) comuni[j]=nodoLista[j].getId().toString();
			return comuni;
		}
	    
	    private void log(String traza){
			if (logger.isDebugEnabled())logger.debug(traza);
		}
}