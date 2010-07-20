/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.listarODEArea;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscador.presentacion.basico.listar.ListarControllerImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO;
import es.pode.buscar.negocio.buscar.servicios.SrvBuscarService;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


/**
 * @see es.pode.buscador.presentacion.arbolCurricular.listarODEArea.ListarODEAreaController
 */
public class ListarODEAreaControllerImpl extends ListarODEAreaController
{
	private java.util.Properties pSpringProperties = null;
	
	private static final long serialVersionUID = -8190956967838990490L;
	
	private static Logger logger = Logger.getLogger(ListarControllerImpl.class);
	
	public static final String DETALLE_ODE = "DETALLE_ODE";
	
	public final static String MENSAJE_GENERICO_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";
	
	public final static String DETALLE_ODE_FEDERADA = "DETALLE_ODE_FEDERADA";

    /**
     * @see es.pode.buscador.presentacion.arbolCurricular.listarODEArea.ListarODEAreaController#buscarDocumentosArea(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolCurricular.listarODEArea.BuscarDocumentosAreaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void buscarDocumentosArea(ActionMapping mapping, es.pode.buscador.presentacion.arbolCurricular.listarODEArea.BuscarDocumentosAreaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		BuscarSession sesion = this.getBuscarSession(request);
    		if (sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().equals("")){
    			form.setAreaCurricularBusqueda(sesion.getAreaCurricularBusqueda());
    			form.setPagina(sesion.getPagina().toString());
    			form.setTipoBusquedaArbol(sesion.getTipoBusquedaArbol());
    			this.setBuscarSession(request,new BuscarSession());
    		}
    		TaxonVO[] taxVO = null;
    		Object[] taxVORutaPadre = null;
    		String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    		String idiomaBuscador = obtenerIdiomaBusqueda();
    		form.setIdiomaBuscador(idiomaBuscador);
    		form.setTipoBusqueda("02");
    		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    		try {
    			//Detectamos si se ha pulsado sobre un identificador de la lista de taxones desplegada
    			if (form.getAreaCurricularBusqueda() != null && !form.getAreaCurricularBusqueda().equals("")){
    				log("ListarODEAreaControllerImpl - buscarDocumentosArea: Cargando taxones del identificador["+form.getAreaCurricularBusqueda()+"] en busqueda por arbol curricular.");
    				taxVO = this.getSrvTaxonomiaService().obtenerNodos(form.getAreaCurricularBusqueda(),this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion);
    				List rutaPadrevo = Arrays.asList(this.getSrvTaxonomiaService().obtenerTaxonPath(form.getAreaCurricularBusqueda(), this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion));
    				log("ListarODEAreaControllerImpl - buscarDocumentosArea: Recuperados["+taxVO.length+"] taxones de del identificador["+form.getAreaCurricularBusqueda()+"] en busqueda por arbol curricular.");
    				Collections.reverse(rutaPadrevo);
    				taxVORutaPadre = rutaPadrevo.toArray();
    			}
    			if(taxVO!=null && taxVO.length>0)form.setEsHoja(false);
    			else form.setEsHoja(true);
    			if (logger.isDebugEnabled() && taxVO!=null)logger.debug("ListarODEAreaControllerImpl - buscarDocumentosArea: Cargados["+taxVO.length+"] taxones del identificador ["+(form.getAreaCurricularBusqueda() == null?"null":form.getAreaCurricularBusqueda())+"] en busqueda por arbol curricular.");
    			form.setRutaArbolAsArray(taxVORutaPadre);
    			//Determinamos cuales han sido los parametros de busqueda con los que se nos ha invocado.
    			//PAGINA DE RESULTADOS REQUERIDA
    			Integer pagina = new Integer(1);
    			if (form.getPagina() != null) pagina = new Integer(form.getPagina());
    			log("ListarODEAreaControllerImpl - buscarDocumentosArea: Busqueda con areaCurricular["+form.getAreaCurricularBusqueda()+"], idiomaBuscador["+idiomaBuscador+"], idiomaNavegacion["+idiomaNavegacion+"] y paginaRequerida["+pagina+"]");
    			//PREPARAMOS LA CONSULTA DE BUSQUEDA
    			
    			ParametrosBusquedaAvanzadaVO param = new ParametrosBusquedaAvanzadaVO();
    			//Por ahora utilizamos el locale. Cuando tengamos usuarios sera el idioma de navegacion por la aplicacion
    			param.setIdiomaNavegacion(idiomaNavegacion);
    			param.setIdiomaBusqueda(idiomaBuscador);
    			param.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSQUEDA_ARBOL);
    			String maxRes = request.getSession().getServletContext().getInitParameter("max_res_totales");
    			if (maxRes == null || maxRes.equals("")) maxRes = "100";
    			param.setNumeroResultados(new Integer(maxRes));
    			param.setOrigenPagina(pagina);
    			param.setAreaCurricular(form.getAreaCurricularBusqueda());
    			param.setArbolCurricularVigente(this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion));
    			String resPag = request.getSession().getServletContext().getInitParameter("max_res_pagina");
    			if (resPag == null || resPag.equals("")) resPag = "10";
    			param.setResultadosPorPagina(new Integer(resPag));
    			if(form.getTipoBusquedaArbol()!=null && form.getTipoBusquedaArbol().equals("01")){
    				param.setComunidadesSeleccionadas(obtenerComunidades()) ;
    				param.setComunidadPeticion(request.getServerName());
    			}
    			if (form.getIdBusqueda() != null) param.setIdBusqueda(form.getIdBusqueda());
    			else param.setIdBusqueda("");
    			//Invocamos el servicio de busqueda
    			ResultadoBusquedaVO resultados;
    			log("ListarODEAreaControllerImpl - buscarDocumentosArea: La invocacion a la Busqueda con parametros IdBusqueda["+param.getIdBusqueda()
    					+"], IdiomaBusqueda["+param.getIdiomaBusqueda()+"], IdiomaNavegacion["+param.getIdiomaNavegacion()
    					+"], areaCurricular["+param.getAreaCurricular()+"], NumeroResultados["+param.getNumeroResultados()
    					+"], OrigenPagina["+param.getOrigenPagina()
    					+"], ResultadosPorPagina["+param.getResultadosPorPagina()+"]");
				SrvBuscarService buscarService = this.getSrvBuscarService();
				resultados = buscarService.buscarAvanzado(param);
				for (int i = 0; i < resultados.getResultadoBusqueda().length; i++) {
					if (resultados.getResultadoBusqueda()[i].getAmbito()[0]!=null && resultados.getResultadoBusqueda()[i].getAmbito()[0].equals(BuscarAvanzadoControllerImpl.UNIVERSAL)){
						resultados.getResultadoBusqueda()[i].setEsVisualizable(new Boolean (true));
					}else{
						boolean encontrado=false;
						for (int j=0;j<resultados.getResultadoBusqueda()[i].getAmbito().length;j++){
							if (resultados.getResultadoBusqueda()[i].getAmbito()[j]!=null && resultados.getResultadoBusqueda()[i].getAmbito()[j].equals(DependentServerProperties.getInstance().getProperty(BuscarAvanzadoControllerImpl.IDENTIFICADOR_NODO).toString())){
								resultados.getResultadoBusqueda()[i].setEsVisualizable(new Boolean (true));
								encontrado=true;
							}
						}
						if (!encontrado){
							resultados.getResultadoBusqueda()[i].setEsVisualizable(new Boolean (false));
						}
					}
				}
 				log("ListarODEAreaControllerImpl - buscarDocumentosArea: Resultados de busqueda ["+(resultados.getResultadoBusqueda()!= null?resultados.getResultadoBusqueda().length:0)+"], sugerencias["+(resultados.getSugerencias()!= null&&resultados.getSugerencias().length>0?resultados.getSugerencias()[0]+" ...":"SIN SUGERENCIAS")+"]");  	
				//Rellenamos los parametros del formulario
	    	
				//Hay que traducir los valores de "tipoRecurso" por sus identificadores en lom-es y pasarselos asi al formulario
				form.setResultadosVO(resultados.getResultadoBusqueda());
				form.setPagina(pagina.toString());
				form.setAreaCurricularBusqueda(form.getAreaCurricularBusqueda());
	    	
				int resultadosDesde = (pagina.intValue() -1 ) * (new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"))).intValue() + 1;
				//int resultadosDesde = (pagina.intValue() -1 ) * 10 + 1;
	    	
				form.setResultadosDesde(String.valueOf(resultadosDesde));
	    	
				int resultadosHasta = resultadosDesde + (new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"))).intValue() - 1;
				//int resultadosHasta = resultadosDesde + 10 - 1;
				resultadosHasta = (resultadosHasta > resultados.getNumeroResultados().intValue()? resultados.getNumeroResultados().intValue(): resultadosHasta);
				form.setResultadosHasta(String.valueOf(resultadosHasta));
				if (form.getAreaCurricularBusqueda() != null && !form.getAreaCurricularBusqueda().equals("")){
					if(resultados.getTotalResultados()<11){
						form.setNumMaxResultados(resultados.getTotalResultados());
					}else if(form.getNumMaxResultados()==null){
						ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),new String[]{form.getAreaCurricularBusqueda()},idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),null);
						ResultadosNodoCountVO count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
						form.setNumMaxResultados(count.getConteo()[count.getConteo().length-1]);
					}
				}
				form.setIdBusqueda(resultados.getIdBusqueda());
				//Este metodo resuelve toda la problematica del banner de paginacion sobre el formulario.
				generaPaginas(	form, pagina, resultados.getNumeroResultados(), (new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"))), (new Integer(request.getSession().getServletContext().getInitParameter("num_max_paginas"))));
    		}catch (Exception ex){
    			if(taxVO==null){
    				logger.error("ListarODEAreaControllerImpl - buscarDocumentosArea ERROR: Error cargando taxonomias de ["+this.getPropertyValue("nombreAreaCurricularTax")+"] en busqueda por arbol curricular.", ex);
    			}else{
    				logger.error("ListarODEAreaControllerImpl - buscarDocumentosArea ERROR: Error en la invocacion a la Busqueda.",ex);
    			}
    			saveErrorMessage(request, MENSAJE_GENERICO_BUSQUEDA);
    		}
    	}catch (Exception e){
    		logger.error("ListarODEAreaControllerImpl - buscarDocumentosArea ERROR: error al buscar los documentos.",e);
    	}
    }
    
    /**
     * @see es.pode.buscador.presentacion.arbolCurricular.listarODEArea.ListarODEAreaController#decidirSalida(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolCurricular.listarODEArea.DecidirSalidaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String decidirSalida(ActionMapping mapping, es.pode.buscador.presentacion.arbolCurricular.listarODEArea.DecidirSalidaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    	try{
    		form.setIdioma(obtenerIdiomaBusqueda());
    		BuscarSession sesion = this.getBuscarSession(request);
    		sesion.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSQUEDA_ARBOL);
    		form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
    		sesion.setAreaCurricularBusqueda(form.getAreaCurricularBusqueda());
    		sesion.setPagina(new Integer(form.getPagina()));
    		sesion.setIdioma(form.getIdioma());
    		sesion.setTipoBusquedaArbol(form.getTipoBusquedaArbol());
   			sesion.setNodoOrigen(LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio());
    		if(form.getIdentificadorODE().trim().equals("")) return DetallarControllerImpl.BUSQUEDA_ARBOL;
    	}catch (Exception e){
    		logger.error("ListarODEAreaControllerImpl - decidirSalida ERROR: error al decidir la salida",e);
    	}
    		return DETALLE_ODE;
    }
    
    private String[] obtenerComunidades() throws RemoteException, Exception{
		NodoVO[] nodoLista = this.getSrvNodoService().listarNodos();
		String [] comuni = new String[nodoLista.length];
		for(int j=0; j<nodoLista.length;j++){
			comuni[j]=nodoLista[j].getId().toString();
		}
		return comuni;
		
	}

    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("ListarODEAreaControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

   private void generaPaginas(BuscarDocumentosAreaForm form, Integer pagina, Integer numRes, Integer numMaxResPagina, Integer numMaxPaginas){
	   try{
		   //Calculo el numero de paginas que salen del numero de resultados que se otienen por la busqueda.
		   int numeroTotalPaginas = numRes.intValue() / numMaxResPagina.intValue();
		   int paginaInt = pagina.intValue();
		   if ((numRes.intValue() % numMaxResPagina.intValue()) > 0) numeroTotalPaginas++;
		   //Si el número de resultados por página es 1 no se pinta nada.
		   if(numeroTotalPaginas==1){
			   String paginas[] = new String[1];
			   form.setPaginasAsArray(paginas);
			   form.setAnterior(null);
			   form.setSiguiente(null);   
		   }else{
			   //Calculo el siguiente y el anterior.
			   if ((paginaInt -1) <= 0) form.setAnterior("");
			   	else form.setAnterior(""+ (paginaInt - 1));
			   if ((paginaInt) >= numeroTotalPaginas)	form.setSiguiente("");
			   	else form.setSiguiente(""+ (paginaInt + 1));
			   //Calculo la horquilla de paginas por delante y por detras de la actual.
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
		   }
	   }catch (Exception e){
		   logger.error("ListarODEAreaControllerImpl - generaPAginas ERROR: error al generar las paginas",e);
	   }
    }
   
   private String obtenerIdiomaBusqueda() throws Exception{
   	String idiomaNavegacion = "";
   	if(LdapUserDetailsUtils.estaAutenticado()){
			try{
				idiomaNavegacion=LdapUserDetailsUtils.getIdiomaBusqueda();
				if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			} catch (Exception e) {
				logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada: Error en al obtener idioma búsqueda usuario LDAP, se recoge idioma de fichero propiedades.",e);
				idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}
   	}else idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		return idiomaNavegacion;
   }

	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}