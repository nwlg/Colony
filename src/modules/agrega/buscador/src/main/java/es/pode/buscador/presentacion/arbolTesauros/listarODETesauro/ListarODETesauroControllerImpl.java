/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.listarODETesauro;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

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
 * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController
 */
public class ListarODETesauroControllerImpl extends ListarODETesauroController
{

	private java.util.Properties pSpringProperties = null;
	
	private static final long serialVersionUID = -8190956967838990490L;
	
	private static Logger logger = Logger.getLogger(ListarControllerImpl.class);
	
	public static final String DETALLE_ODE = "DETALLE_ODE";	
	public final static String MENSAJE_GENERICO_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";	
	public final static String DETALLE_ODE_FEDERADA = "DETALLE_ODE_FEDERADA";	
	public final static String TITULOTESAURO = "navegar.tesauro.nombre";	
	
	private static final String FICHERO = "application-resources";
	private static final String EUSKERA = "eu";
	private static final String INGLES = "en";
	private static final String SPACE = " ";

    /**
     * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController#buscarDocumentosTesauro(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.BuscarDocumentosTesauroForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void buscarDocumentosTesauro(ActionMapping mapping, es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.BuscarDocumentosTesauroForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		BuscarSession sesion = this.getBuscarSession(request);
    		log("La sesion tiene un valor de ["+sesion+"] y el valor del campo de la sesion tituloTesauro es ["+sesion.getTituloTesauro()+"]");
    		if (sesion.getNodoOrigen()!=null && !sesion.getNodoOrigen().equals("")){
    			form.setTesauroBusqueda(sesion.getTesauroBusqueda());
    			form.setPagina(sesion.getPagina().toString());
    			form.setTipoBusquedaArbol(sesion.getTipoBusquedaArbol());    			
    			this.setBuscarSession(request,new BuscarSession());
    		}
    		if (sesion.getTituloTesauro() != null && !sesion.getTituloTesauro().equals(""))
    			form.setTituloTesauro(sesion.getTituloTesauro());
    		else
    		{
    			String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    	    	String nomTesauro = this.getPropertyValue("nombreFichTesauros");
    	    	log("Se obtiene el nombre del tesauro con el idioma de navegacion ["+idiomaNavegacion+"]");
    			Locale locale = null;
    			try {
    				locale = devuelveLocale(request);
    			} catch (Exception e) {
    				logger.error("Error recuperando el locale",e);
    			}
    			String tituloTesauro = "";
    			String vocabNameTesauro = this.getSrvTesaurosServices().obtenerVocabName(nomTesauro, idiomaNavegacion);
//    			Se forma el titulo del tesauro. El orden cambia dependiendo del idioma		 
    			String literalTituloTesauro = this.getResource(TITULOTESAURO, FICHERO, locale);	
    			if (EUSKERA.equals(idiomaNavegacion) || INGLES.equals(idiomaNavegacion))tituloTesauro = vocabNameTesauro + SPACE + literalTituloTesauro;
    			else tituloTesauro = literalTituloTesauro + SPACE + vocabNameTesauro;
    			form.setTituloTesauro(tituloTesauro);  
    			sesion.setTituloTesauro(tituloTesauro);
    		}
    		TaxonVO[] taxVO = null;
    		Object[] taxVORutaPadre = null;
    		String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			form.setTipoBusqueda("02");
    		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    		try {
    			//Detectamos si se ha pulsado sobre un identificador de la lista de taxones desplegada
    			if (form.getTesauroBusqueda() != null && !form.getTesauroBusqueda().equals("")){
    				if (logger.isDebugEnabled())logger.debug("ListarODETesauroControllerImpl - buscarDocumentosTesauro: Cargando taxones del identificador["+form.getTesauroBusqueda()+"] en busqueda por tesauro.");
    				taxVO = this.getSrvTaxonomiaService().obtenerNodos(form.getTesauroBusqueda(),this.getPropertyValue("nombreFichTesauros"), idiomaNavegacion);
    				
    				List rutaPadrevo = Arrays.asList(this.getSrvTesaurosServices().obtenerJerarquia(form.getTesauroBusqueda(), this.getPropertyValue("nombreFichTesauros"), idiomaNavegacion)[0].getJerarquia());
    				log("ListarODETesauroControllerImpl - buscarDocumentosTesauro: Recuperados["+taxVO.length+"] taxones de del identificador["+form.getTesauroBusqueda()+"] en busqueda por tesauro.");
    				taxVORutaPadre = rutaPadrevo.toArray();
    			}
    			if(taxVO!=null && taxVO.length>0)form.setEsRuta(false);
    			else form.setEsRuta(true);
    			if (logger.isDebugEnabled() && taxVO!=null)logger.debug("ListarODETesauroControllerImpl - buscarDocumentosTesauro: Cargados["+taxVO.length+"] taxones del identificador ["+(form.getTesauroBusqueda() == null?"null":form.getTesauroBusqueda())+"] en busqueda por tesauro.");
    			form.setRutaTesauroAsArray(taxVORutaPadre);
    			//Determinamos cuales han sido los parametros de busqueda con los que se nos ha invocado.
    			//PAGINA DE RESULTADOS REQUERIDA
    			Integer pagina = new Integer(1);
    			if (form.getPagina() != null) pagina = new Integer(form.getPagina());
    			log("ListarODETesauroControllerImpl - buscarDocumentosTesauro: Busqueda con tesauro ["+form.getTesauroBusqueda()+"], idiomaBuscador["+idiomaNavegacion+"] y paginaRequerida["+pagina+"]");
    			//PREPARAMOS LA CONSULTA DE BUSQUEDA
    			
    			ParametrosBusquedaAvanzadaVO param = new ParametrosBusquedaAvanzadaVO();
    			//Por ahora utilizamos el locale. Cuando tengamos usuarios sera el idioma de navegacion por la aplicacion
    			param.setIdiomaNavegacion(idiomaNavegacion);
    			param.setIdiomaBusqueda(obtenerIdiomaBusqueda());
    			param.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSQUEDA_TESAURO);
    			String maxRes = request.getSession().getServletContext().getInitParameter("max_res_totales");
    			if (maxRes == null || maxRes.equals("")) maxRes = "100";
    			param.setNumeroResultados(new Integer(maxRes));
    			param.setOrigenPagina(pagina);
    			param.setIdTesauro(form.getTesauroBusqueda());
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
    			log("ListarODETesauroControllerImpl - buscarDocumentosTesauro: La invocacion a la Busqueda con parametros IdBusqueda["+param.getIdBusqueda()
    					+"], IdiomaBusqueda["+param.getIdiomaBusqueda()+"], IdiomaNavegacion["+param.getIdiomaNavegacion()
    					+"], Tesauro["+param.getIdTesauro()+"], NumeroResultados["+param.getNumeroResultados()
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
 				log("ListarODETesauroControllerImpl - buscarDocumentosTesauro: Resultados de busqueda ["+(resultados.getResultadoBusqueda()!= null?resultados.getResultadoBusqueda().length:0)+"], sugerencias["+(resultados.getSugerencias()!= null&&resultados.getSugerencias().length>0?resultados.getSugerencias()[0]+" ...":"SIN SUGERENCIAS")+"]");  	
				//Rellenamos los parametros del formulario
	    	
				//Hay que traducir los valores de "tipoRecurso" por sus identificadores en lom-es y pasarselos asi al formulario
				form.setResultadosVO(resultados.getResultadoBusqueda());
				form.setPagina(pagina.toString());
				form.setTesauroBusqueda(form.getTesauroBusqueda());
	    	
				int resultadosDesde = (pagina.intValue() -1 ) * (new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"))).intValue() + 1;
				form.setResultadosDesde(String.valueOf(resultadosDesde));
	    	
				int resultadosHasta = resultadosDesde + (new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"))).intValue() - 1;
				resultadosHasta = (resultadosHasta > resultados.getNumeroResultados().intValue()? resultados.getNumeroResultados().intValue(): resultadosHasta);
				form.setResultadosHasta(String.valueOf(resultadosHasta));
				if(form.getTesauroBusqueda()!=null && !form.getTesauroBusqueda().equals("")){
					if(resultados.getTotalResultados()<11){
						form.setNumMaxResultados(resultados.getTotalResultados());
					}else if(form.getNumMaxResultados()==null){
						ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),new String[]{form.getTesauroBusqueda()});
						ResultadosNodoCountVO count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
						form.setNumMaxResultados(count.getConteo()[count.getConteo().length-1]);
					}
				}
				form.setIdBusqueda(resultados.getIdBusqueda());
				//Este metodo resuelve toda la problematica del banner de paginacion sobre el formulario.
				generaPaginas(	form, pagina, resultados.getNumeroResultados(), (new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"))), (new Integer(request.getSession().getServletContext().getInitParameter("num_max_paginas"))));
    		}catch (Exception ex){
    			if(taxVO==null){
    				logger.error("ListarODETesauroControllerImpl - buscarDocumentosTesauro ERROR: Error cargando taxonomias de ["+this.getPropertyValue("nombreFichTesauros")+"] en busqueda por tesauro.", ex);
    			}else{
    				logger.error("ListarODETesauroControllerImpl - buscarDocumentosTesauro ERROR: Error en la invocacion a la Busqueda.",ex);
    			}
    			saveErrorMessage(request, MENSAJE_GENERICO_BUSQUEDA);
    		}
    	}catch (Exception e){
    		logger.error("ListarODETesauroControllerImpl - buscarDocumentosTesauro ERROR: error al buscar los documentos.",e);
    	}
     }

    /**
     * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController#decidirSalida(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.DecidirSalidaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String decidirSalida(ActionMapping mapping, es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.DecidirSalidaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		form.setIdioma(obtenerIdiomaBusqueda());
    		BuscarSession sesion = this.getBuscarSession(request);
    		sesion.setBusquedaSimpleAvanzada(DetallarControllerImpl.BUSQUEDA_TESAURO);
    		form.setBusquedaSimpleAvanzada(sesion.getBusquedaSimpleAvanzada());
    		sesion.setTesauroBusqueda(form.getTesauroBusqueda());
    		sesion.setPagina(new Integer(form.getPagina()));
    		sesion.setIdioma(form.getIdioma());
    		sesion.setTipoBusquedaArbol(form.getTipoBusquedaArbol());
    		sesion.setNodoOrigen(LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio());
    		if(form.getIdentificadorODE().trim().equals("")) return DetallarControllerImpl.BUSQUEDA_TESAURO;
    	}catch (Exception e){
    		logger.error("ListarODETesauroControllerImpl - decidirSalida ERROR: error al decidir la salida",e);
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
		log("ListarODETesauroControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

   private void generaPaginas(BuscarDocumentosTesauroForm form, Integer pagina, Integer numRes, Integer numMaxResPagina, Integer numMaxPaginas){
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
		   logger.error("ListarODETesauroControllerImpl - generaPAginas ERROR: error al generar las paginas",e);
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
   
//	MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
	public static String getResource(String key, String baseName, Locale locale)
	{
       String recurso = "";
       ResourceBundle theResourceBundle = getResource(baseName,locale);
       try{
       	if (theResourceBundle!=null){
              recurso = theResourceBundle.getString(key);
          }
       }catch (MissingResourceException mre){
       	recurso = key;
       }
       return recurso;
   }
	
	public static ResourceBundle getResource(String baseName, Locale locale)
	{
       try{
       	return ResourceBundle.getBundle(baseName,locale);
           
       }catch (MissingResourceException mre){
       		locale = new Locale("","");
       		return ResourceBundle.getBundle(baseName,locale);
            
       }
   }
	
	private Locale devuelveLocale(HttpServletRequest request) throws Exception
	{	
		
		Locale locale=null;
		if (request instanceof HttpServletRequest) {
			locale = (Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			
		}
		else{ 	    					
			try {
				locale=new Locale(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
			} catch (Exception e) {								
				logger.error("DevuelveLocale-- Error recuperando el locale del request", e);
			}
		}
		return locale;
	}
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}