/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularControllerImpl;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.NavegarArbolCurricularController
 */
public class NavegarArbolCurricularControllerImpl extends NavegarArbolCurricularController
{
	private java.util.Properties pSpringProperties = null;
	private static final long serialVersionUID = -8190956967834990490L;
	private static Logger logger = Logger.getLogger(AreaCurricularControllerImpl.class);
	public final static String MENSAJE_ERROR_ARBOL = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";


    /**
     * @see es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.NavegarArbolCurricularController#obtenerAreasCurriculares(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.ObtenerAreasCurricularesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerAreasCurriculares(ActionMapping mapping, es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.ObtenerAreasCurricularesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    	try{
    		log("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares: TipoBusquedaArbol= "+ form.getTipoBusquedaArbol());
	    	TaxonVO[] taxVO = null;
 	    	Object[] taxVORutaPadre = null;
 	    	String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    		BuscarSession os = this.getBuscarSession(request);
    		if(form.getTipoBusquedaArbol()!=null) os.setTipoBusquedaArbol(form.getTipoBusquedaArbol());
    		else form.setTipoBusquedaArbol(os.getTipoBusquedaArbol());
			ResultadosNodoCountVO count = null;
			ResultadosTaxonVO[] resultadosTaxon = null;
			try{
//  			Detectamos si se ha pulsado sobre un identificador de la lista de taxones desplegada
    			if (form.getAreaCurricularBusqueda() == null || form.getAreaCurricularBusqueda().equals("")){
    				log("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares:Cargando taxones de vacio en busqueda por arbol curricular.");
	    			taxVO = this.getSrvTaxonomiaService().obtenerTaxonomia(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion);
	    			taxVORutaPadre = new TaxonVO[0];
	    			String[] areasCurriculares = new String[taxVO.length];
	    			for(int i = 0; i < taxVO.length; i++){
	    				areasCurriculares[i] = taxVO[i].getId();
	    			}
	    			try{
	    				ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),areasCurriculares,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),null);
	    				count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
	//    				if(form.getNumeroResultados()!=null && !form.getNumeroResultados().equals(""))form.setNumeroResultados(count.getNumeroResultados());
	    		    } catch (Exception e) {
	    				logger.error("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares ERROR: Error cargando solicitud de numero de documentos ["+this.getPropertyValue("nombreAreaCurricularTax")+"] en busqueda por arbol curricular.",e);
	    				saveErrorMessage(request, MENSAJE_ERROR_ARBOL);
	    			}
	    			log("Recuperados["+taxVO.length+"] taxones de vacio en busqueda por arbol curricular.");
	    			resultadosTaxon=new ResultadosTaxonVO[taxVO.length];
	    			for (int i=0;i<resultadosTaxon.length;i++){
	    				ResultadosTaxonVO resul=new ResultadosTaxonVO();
	    				resul.setIdentificador(new String (taxVO[i].getId()));
	    				resul.setNombre(new String(taxVO[i].getValorTax()));
	    				resul.setEsHoja(taxVO[i].getEsHoja());
	    				resul.setNumeroOdesAsociados(count.getConteo()[i]);
	    				resultadosTaxon[i]=resul;
	    			}
    			}else{
    				log("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares: Cargando taxones del identificador["+form.getAreaCurricularBusqueda()+"] en busqueda por arbol curricular.");
	    			taxVO = this.getSrvTaxonomiaService().obtenerNodos(form.getAreaCurricularBusqueda(),this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion);
	    			List rutaPadrevo = Arrays.asList(this.getSrvTaxonomiaService().obtenerTaxonPath(form.getAreaCurricularBusqueda(), this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion));
	    			log("Recuperados["+taxVO.length+"] taxones de del identificador["+form.getAreaCurricularBusqueda()+"] en busqueda por arbol curricular.");
	    			Collections.reverse(rutaPadrevo);
	    			taxVORutaPadre = rutaPadrevo.toArray();
	    			String[] areasCurriculares = new String[taxVO.length+1];
	    			for(int i = 0; i < taxVO.length; i++){
	    				areasCurriculares[i] = taxVO[i].getId();
	    			}
	    			areasCurriculares[taxVO.length]=form.getAreaCurricularBusqueda();
	    			try{
	    				ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),areasCurriculares,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),null);
	    				count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
	 //   				if(form.getNumeroResultados()==null && !form.getNumeroResultados().equals(""))form.setNumeroResultados(count.getNumeroResultados());
	    		    } catch (Exception e) {
	    				logger.error("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares ERROR: Error cargando solicitud de numero de documentos ["+this.getPropertyValue("nombreAreaCurricularTax")+"] en busqueda por arbol curricular.",e);
	    				saveErrorMessage(request, MENSAJE_ERROR_ARBOL);
	    			}
	    		    resultadosTaxon=new ResultadosTaxonVO[taxVO.length];
	    			for (int i=0;i<resultadosTaxon.length;i++){
	    				ResultadosTaxonVO resul=new ResultadosTaxonVO();
	    				resul.setIdentificador(new String (taxVO[i].getId()));
	    				resul.setNombre(new String(taxVO[i].getValorTax()));
	    				resul.setEsHoja(taxVO[i].getEsHoja());
	    				resul.setNumeroOdesAsociados(count.getConteo()[i]);
	    				resultadosTaxon[i]=resul;
	    			}
	    			form.setNumeroResultados(count.getConteo()[count.getConteo().length-1]);
    			}
			} catch (Exception e) {
				logger.error("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares ERROR: Error cargando taxonomias de "+(form.getAreaCurricularBusqueda() == null?"null":form.getAreaCurricularBusqueda())+" en busqueda por arbol curricular.",e);
				saveErrorMessage(request, DetallarControllerImpl.MENSAJE_TRADUCCION_BUSQUEDA);
			}
			log("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares: Cargados["+taxVO.length+"] taxones del identificador ["+(form.getAreaCurricularBusqueda() == null?"null":form.getAreaCurricularBusqueda())+"] en busqueda por arbol curricular.");
			form.setNodosAsArray(resultadosTaxon);
			form.setRutaArbolAsArray(taxVORutaPadre);
    	} catch (Exception e) {
			logger.error("NavegarArbolCurricularControllerImpl - obtenerAreasCurriculares ERROR: Error cargando taxonomias de ["+this.getPropertyValue("nombreAreaCurricularTax")+"] en busqueda por arbol curricular.", e);
			saveErrorMessage(request, MENSAJE_ERROR_ARBOL);
		}
     }
    
    public void buscarIdiomasBuscador(ActionMapping mapping, BuscarIdiomasBuscadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.setBuscarSession(request, new BuscarSession());
		form.setTipoBusquedaArbol("02");
		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
	}

    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("NavegarArbolCurricularControllerImpl - getPropertyValue:Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
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