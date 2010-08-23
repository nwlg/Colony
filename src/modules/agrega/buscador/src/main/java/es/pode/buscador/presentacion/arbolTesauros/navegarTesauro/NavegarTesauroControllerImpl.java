/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.navegarTesauro;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularControllerImpl;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO;
import es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController
 */
public class NavegarTesauroControllerImpl extends NavegarTesauroController
{
	private java.util.Properties pSpringProperties = null;
	private static Logger logger = Logger.getLogger(AreaCurricularControllerImpl.class);
	private static String VARIAS_RUTAS_DISPONIBLES = "0.0";
	public final static String MENSAJE_ERROR_TESAURO = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";

    /**
     * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController#buscarIdiomasBuscador(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.BuscarIdiomasBuscadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void buscarIdiomasBuscador(ActionMapping mapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.BuscarIdiomasBuscadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	this.setBuscarSession(request, new BuscarSession());
    	form.setTipoBusquedaArbol("02");
    	form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
     }

    /**
     * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController#cargarTesauros(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.CargarTesaurosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarTesauros(ActionMapping mapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.CargarTesaurosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    		log("NavegarTesauroControllerImpl - cargarTesauros");
    		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    		String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    		BuscarSession os = this.getBuscarSession(request);
			os.setJerarquias(null);
    		if(form.getTipoBusquedaArbol()!=null) os.setTipoBusquedaArbol(form.getTipoBusquedaArbol());
    		else form.setTipoBusquedaArbol(os.getTipoBusquedaArbol());
			String nomTesauro = this.getPropertyValue("nombreFichTesauros");
			TaxonVO[] taxVO =this.getSrvTesaurosServices().obtenerPrimerNivelTesauro(nomTesauro, idiomaNavegacion);//Se carga el primer nivel del tesauro
			String[] tesauros=null;
			if (taxVO !=null && taxVO.length>0){
				tesauros=new String[taxVO.length];
				for (int i=0;i<taxVO.length;i++){
					tesauros[i]=taxVO[i].getId();
				}
			}
			
			es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO count=null;
			log("NavegarTesauroControllerImpl - cargarTesauros: Obtenidos tesauros, se van a obtener odes por item de tesauro");
			try{
				ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),null, tesauros);
				count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
		    } catch (Exception e) {
				logger.error("NavegarTesauroControllerImpl - cargarTesauros ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
				saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
			}
		    form.setNumeroResultados(count.getNumeroResultados());
		    ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[taxVO.length];
		    for (int i=0;i<count.getConteo().length;i++){
				ResultadosTaxonVO resul=new ResultadosTaxonVO();
				resul.setIdentificador(taxVO[i].getId());
				resul.setNombre(taxVO[i].getValorTax());
				resul.setEsHoja(taxVO[i].getEsHoja());
				resul.setNumeroOdesAsociados(count.getConteo()[i]);
				resultadosTaxon[i]=resul;
			}
		    form.setIdioma(idiomaNavegacion);
//			form.setNomTesauros("");
			form.setTaxonesVOAsArray(resultadosTaxon);
			TaxonVO[] taxVORutaPadre
			= new TaxonVO[0];//En la cabecera sólo pondrá Inicio
			form.setRutaPadreVOAsArray(taxVORutaPadre);
			form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
			
		} catch (Exception e) {
			logger.error("NavegarTesauroControllerImpl - cargarTesauros: Error en CargarTesauro", e);
		}
     }

    /**
     * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController#consultarId(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.ConsultarIdForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void consultarId(ActionMapping mapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.ConsultarIdForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("NavegarTesauroControllerImpl - consultarId");
    	form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    	String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		form.setIdioma(idiomaNavegacion);
		try{
			BuscarSession os = this.getBuscarSession(request);
			es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO count=null;
			if(os.getJerarquias()!=null && form.isEsRuta()){//Si en el objeto de sesion las rutas jerarquicas son nulas
				log("NavegarTesauroControllerImpl - consultarId:Si en el objeto de sesion las rutas jerarquicas son nulas");
				TaxonVO[] taxones = ((JerarquiaVO)os.getJerarquias().toArray()[Integer.parseInt(form.getIdTesauro())]).getJerarquia();
				
				JerarquiaVO jerar=new JerarquiaVO();
				jerar.setJerarquia(taxones);
				//Los terminos relacionados del ultimo taxon del array
				TaxonVO ultimoTaxon=taxones[taxones.length-1];
				TaxonVO[] terminosRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(ultimoTaxon.getId(), this.getPropertyValue("nombreFichTesauros"), idiomaNavegacion);
				String[] tesauros=null;
				if (terminosRelacionados !=null && terminosRelacionados.length>0){
					tesauros=new String[terminosRelacionados.length+1];
					for (int i=0;i<terminosRelacionados.length;i++){
						tesauros[i]=terminosRelacionados[i].getId(); 
					}
					tesauros[tesauros.length-1]=ultimoTaxon.getId();
				}
			    TaxonVO[] taxVORutaPadre = new TaxonVO[0];//En la cabecera sólo pondrá Inicio
				form.setRutaPadreVOAsArray(taxVORutaPadre);
				form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
				//Insertamos en el formulario los taxones relacionados y la rutaPadre
				
				form.setRutaPadreVO(Arrays.asList(((JerarquiaVO)os.getJerarquias().toArray()[Integer.parseInt(form.getIdTesauro())]).getJerarquia()));
//				form.setNomTesauros(ultimoTaxon.getValorTax());
				form.setIdTesauro(ultimoTaxon.getId());//Cambiamos el identificador de la posicion por la del ultimo taxon
				//os.setJerarquias(null);
				form.setEsRuta(false);
				try{
					ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),tesauros);
					count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
			    } catch (Exception e) {
					logger.error("NavegarTesauroControllerImpl - consultarId ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
					saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
				}
			    
			    ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[terminosRelacionados.length];
			    for (int i=0;i<terminosRelacionados.length;i++){
					ResultadosTaxonVO resul=new ResultadosTaxonVO();
					resul.setIdentificador(new String (terminosRelacionados[i].getId()));
					resul.setNombre("("+terminosRelacionados[i].getTipoRelacion()+") "+terminosRelacionados[i].getValorTax());
					resul.setEsHoja(terminosRelacionados[i].getEsHoja());
					resul.setNumeroOdesAsociados(count.getConteo()[i]);
					resultadosTaxon[i]=resul;
				}
			    form.setNumeroResultados(count.getConteo()[count.getConteo().length-1]);
			    form.setTaxonesVOAsArray(resultadosTaxon);
			    form.setTaxonesVO(Arrays.asList(resultadosTaxon));
			}else{//Si en el objeto de sesion las rutas jerarquicas no son nulas
				//Accedemos y recogemos el array de taxones de la posicion id; que sera la rutaPadre
				log("NavegarTesauroControllerImpl - consultarId:Si en el objeto de sesion las rutas jerarquicas no son nulas, accedemos y recogemos el array de taxones de la posicion id; que sera la rutaPadre");
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(form.getIdTesauro(), this.getPropertyValue("nombreFichTesauros"), idiomaNavegacion);
				String[] tesauros=null;
				if (taxonesRelacionados !=null && taxonesRelacionados.length>0){
					tesauros=new String[taxonesRelacionados.length+1];
					for (int i=0;i<taxonesRelacionados.length;i++){
						tesauros[i]=taxonesRelacionados[i].getId();
					}
					tesauros[tesauros.length-1]=form.getIdTesauro();
				}
				JerarquiaVO[] jerarquia=this.getSrvTesaurosServices().obtenerJerarquia(form.getIdTesauro(), this.getPropertyValue("nombreFichTesauros"), idiomaNavegacion);//Obtenemos las jerarquias
				form.setRutaPadreVO(obtenerJerarquias(jerarquia, os , idiomaNavegacion));
				try{
					ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),tesauros);
					count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
					
			    } catch (Exception e) {
					logger.error("NavegarTesauroControllerImpl - consultarId ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
					saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
				}
			    ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[taxonesRelacionados.length];
			    for (int i=0;i<taxonesRelacionados.length;i++){
					ResultadosTaxonVO resul=new ResultadosTaxonVO();
					resul.setIdentificador(new String (taxonesRelacionados[i].getId()));
					resul.setNombre("("+taxonesRelacionados[i].getTipoRelacion()+") "+taxonesRelacionados[i].getValorTax());
					resul.setEsHoja(taxonesRelacionados[i].getEsHoja());
					resul.setNumeroOdesAsociados(count.getConteo()[i]);
					resultadosTaxon[i]=resul;
				}
			    //form.setNumeroResultados(count.getConteo()[count.getConteo().length-1]);
			    form.setTaxonesVOAsArray(resultadosTaxon);
			    form.setTaxonesVO(Arrays.asList(resultadosTaxon));
			}
		}catch (Exception e) {
			logger.error("NavegarTesauroControllerImpl - consultarId: Error en consultaTesId", e);
		}
     }

    /**
     * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController#consultarPadreTaxon(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.ConsultarPadreTaxonForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void consultarPadreTaxon(ActionMapping mapping, es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.ConsultarPadreTaxonForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("NavegarTesauroControllerImpl - consultarPadreTaxon.");
    	String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
		String nomTesauro = this.getPropertyValue("nombreFichTesauros");
		BuscarSession os = this.getBuscarSession(request);
		try{
			es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO count=null;
			if(form.getIdTesauro()!=null && !form.getIdTesauro().equals(VARIAS_RUTAS_DISPONIBLES)){//Cuando viene con un identificador que no le hemos insertado nosotros
				log("NavegarTesauroControllerImpl - consultarPadreTaxon:Cuando viene con un identificador que no le hemos insertado nosotros");
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(form.getIdTesauro(), nomTesauro, idiomaNavegacion);
				String[] tesauros=null;
				if (taxonesRelacionados !=null && taxonesRelacionados.length>0){
					tesauros=new String[taxonesRelacionados.length+1];
					for (int i=0;i<taxonesRelacionados.length;i++){
						tesauros[i]=taxonesRelacionados[i].getId();
					}
					tesauros[tesauros.length-1]=form.getIdTesauro();
				}
				
				JerarquiaVO[] jerarquia=this.getSrvTesaurosServices().obtenerJerarquia(form.getIdTesauro(), nomTesauro, idiomaNavegacion);//Obtenemos las jerarquias
				form.setRutaPadreVO(obtenerJerarquias(jerarquia, os , idiomaNavegacion));
				try{
					ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),this.getSrvTaxonomiaService().obtenerVocabName(this.getPropertyValue("nombreAreaCurricularTax"), idiomaNavegacion),tesauros);
					count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
					
			    } catch (Exception e) {
					logger.error("NavegarTesauroControllerImpl - consultarPadreTaxon ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
					saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
				}
			    ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[taxonesRelacionados.length];
			    for (int i=0;i<taxonesRelacionados.length;i++){
					ResultadosTaxonVO resul=new ResultadosTaxonVO();
					resul.setIdentificador(taxonesRelacionados[i].getId());
					resul.setNombre("("+taxonesRelacionados[i].getTipoRelacion()+") "+taxonesRelacionados[i].getValorTax());
					resul.setEsHoja(taxonesRelacionados[i].getEsHoja());
					resul.setNumeroOdesAsociados(count.getConteo()[i]);
					resultadosTaxon[i]=resul;
				}
			    form.setNumeroResultados(count.getConteo()[count.getConteo().length-1]);
			    form.setTaxonesVO(Arrays.asList(resultadosTaxon));//insertamos los taxones en el formulario
			}else{//Si viene con varias rutas disponibles, por eso lleva el identificador 0.0
				log("NavegarTesauroControllerImpl - consultarPadreTaxon:Si viene con varias rutas disponibles, por eso lleva el identificador 0.0");
				Collection coleccionRutas=os.getJerarquias();
			    String[] tesauros= new String[coleccionRutas.size()];
			    try{
					ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),null,tesauros);
					count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
					form.setNumeroResultados(count.getNumeroResultados());
			    } catch (Exception e) {
					logger.error("NavegarTesauroControllerImpl - consultarPadreTaxon ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
					saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
				}
			    ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[coleccionRutas.size()];
				for(int i=0;i<coleccionRutas.size();i++){//Recorremos la coleccion de jerarquias en sesion
					ResultadosTaxonVO nuevoTaxon=new ResultadosTaxonVO();//Generamos un nuevo taxon
					nuevoTaxon.setEsHoja(new Boolean("false"));	
					form.setEsRuta(true);
					nuevoTaxon.setIdentificador(new Integer(i).toString());//Llevara por identificador la i(de la posicion en las rutas)					
					JerarquiaVO jerarquias=(JerarquiaVO)coleccionRutas.toArray()[i];
					TaxonVO[] jerarTax=jerarquias.getJerarquia();			
					String texto ="";
					for(int j=0;j<jerarTax.length;j++){	
							texto=texto+ jerarTax[j].getValorTax().toString();
							if(j<jerarTax.length-1)
								texto=texto+" -> ";
					}//El texto sera la concatenacion de todos los textos del array de taxones
					nuevoTaxon.setNombre(texto);
					nuevoTaxon.setNumeroOdesAsociados(count.getConteo()[i]);
					resultadosTaxon[i]=nuevoTaxon;//Array de taxones			
					tesauros[i]=nuevoTaxon.getIdentificador();
				}
				TaxonVO[] taxVORutaPadre = new TaxonVO[0];
				JerarquiaVO jerarquia=new JerarquiaVO();
				jerarquia.setJerarquia(taxVORutaPadre);//En la cabecera sólo aparecera Inicio
				form.setRutaPadreVOAsArray(taxVORutaPadre);
				form.setTaxonesVO(Arrays.asList(resultadosTaxon));//insertamos los taxones en el formulario
			}	
		}catch (Exception e) {
			logger.error("NavegarTesauroControllerImpl - consultarPadreTaxon: Error en consultaPadreTaxon", e);
		}
     }
    
    
    private List obtenerJerarquias(JerarquiaVO[] jerarquia, BuscarSession os, String idioma){
    	TaxonVO[] lTaxones = null;
	    if(jerarquia.length>1){//Si hay más de una jerarquia
			
			os.setJerarquias(Arrays.asList(jerarquia));
			TaxonVO taxonVariosDisponibles=new TaxonVO();				
			taxonVariosDisponibles.setEsHoja(new Boolean("false"));
			taxonVariosDisponibles.setId(VARIAS_RUTAS_DISPONIBLES);
			ResourceBundle datosResources = ResourceBundle.getBundle("application-resources", new Locale(idioma));
			taxonVariosDisponibles.setValorTax(datosResources.getString("tesauro.variasRutasDisponibles"));
			lTaxones = new TaxonVO[2];
			lTaxones[0]=taxonVariosDisponibles;
			lTaxones[1]=jerarquia[0].getJerarquia()[jerarquia[0].getJerarquia().length-1];	
		}else{
			lTaxones = jerarquia[0].getJerarquia();//a la colecion rutaPadre le insertamos la única jerarquia que tenemos y lo metemos en el formulario
		}
	    return Arrays.asList(lTaxones);
	}
    
    
    public void buscarTerminos(ActionMapping mapping, BuscarTerminosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			log("NavegarTesauroControllerImpl - buscarTerminos.");
	    	String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	    	String nomTesauro = this.getPropertyValue("nombreFichTesauros");
			
			form.setIdioma(idiomaNavegacion);
			form.setNomTesauro(nomTesauro);
			form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
			String textoBusqueda = form.getTextoBusqueda();
			if(textoBusqueda==null)
				textoBusqueda="";
			
			JerarquiaVO[] jerarquias=this.getSrvTesaurosServices().obtenerTerminos(textoBusqueda,nomTesauro, idiomaNavegacion);
			
			BuscarSession os = this.getBuscarSession(request);
	    	Collection rutas=new ArrayList();
	    	es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO count=null;
	    	if (jerarquias.length==1){
	
	    		String id = jerarquias[0].getJerarquia()[jerarquias[0].getJerarquia().length-1].getId();
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(id, nomTesauro, idiomaNavegacion);
				String[] tesauros=null;
				if (taxonesRelacionados !=null && taxonesRelacionados.length>0){
					tesauros=new String[taxonesRelacionados.length+1];
					for (int i=0;i<taxonesRelacionados.length;i++){
						tesauros[i]=taxonesRelacionados[i].getId();
					}
					tesauros[tesauros.length-1]=id;
				}
				try{
					ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),null,tesauros);
					count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
					form.setNumeroResultados(count.getNumeroResultados());
			    } catch (Exception e) {
					logger.error("NavegarTesauroControllerImpl - buscarTerminos ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
					saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
				}
			    ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[taxonesRelacionados.length];
			    for (int i=0;i<taxonesRelacionados.length;i++){
					ResultadosTaxonVO resul=new ResultadosTaxonVO();
					resul.setIdentificador(new String (taxonesRelacionados[i].getId()));
					resul.setNombre("("+taxonesRelacionados[i].getTipoRelacion()+") "+taxonesRelacionados[i].getValorTax());
					resul.setEsHoja(taxonesRelacionados[i].getEsHoja());
					resul.setNumeroOdesAsociados(count.getConteo()[i]);
					resultadosTaxon[i]=resul;
				}
			    form.setNumeroResultados(count.getConteo()[count.getConteo().length-1]);
				form.setTaxonesVOAsArray(resultadosTaxon);
				form.setRutaPadreVOAsArray(jerarquias[0].getJerarquia());
				form.setIdTesauro(id);
	    	}
	    	else{
	    		rutas=rutasBusqueda(jerarquias);
	    		TaxonVO[] rutasTaxon=new TaxonVO[rutas.size()];
	    		String[] tesauros=new String[rutas.size()];
	    		for (int i=0;i<rutas.size();i++){
	    			rutasTaxon[i]=(TaxonVO)rutas.toArray()[i];
	    			tesauros[i]=rutasTaxon[i].getId();
	    		}
	    		
	    		try{
					ParametrosDocsCountVO parametrosCount = new ParametrosDocsCountVO(obtenerIdiomaBusqueda(),null,idiomaNavegacion,form.getTipoBusquedaArbol(),request.getServerName(),null,tesauros);
					count = this.getSrvBuscarService().solicitarDocsCount(parametrosCount);
					form.setNumeroResultados(count.getNumeroResultados());
			    } catch (Exception e) {
					logger.error("NavegarTesauroControllerImpl - buscarTerminos ERROR: Error cargando solicitud de numero de documentos en busqueda por tesauro.",e);
					saveErrorMessage(request, MENSAJE_ERROR_TESAURO);
				}
			    
			    
	    		ResultadosTaxonVO[] resultadosTaxon=new ResultadosTaxonVO[rutasTaxon.length];
			    for (int i=0;i<rutasTaxon.length;i++){
					ResultadosTaxonVO resul=new ResultadosTaxonVO();
					resul.setIdentificador(new String (rutasTaxon[i].getId()));
					resul.setNombre(rutasTaxon[i].getValorTax());
					resul.setEsHoja(rutasTaxon[i].getEsHoja());
					resul.setNumeroOdesAsociados(count.getConteo()[i]);
					resultadosTaxon[i]=resul;
				}
				form.setTaxonesVOAsArray(resultadosTaxon);
		    	form.setRutaPadreVO(null);
		    	form.setEsRuta(true);
		    	Collection cJerarquias = new ArrayList();
		    	for(int i=0;i<jerarquias.length;i++){
		    		cJerarquias.add(jerarquias[i]);
		    	}
		    	os.setJerarquias(cJerarquias);
	    	}
		}catch (Exception e) {
			logger.error("NavegarTesauroControllerImpl - buscarTerminos: Error en buscarTerminos", e);
		}
	}
    
	public Collection rutasBusqueda(JerarquiaVO[] jerarquias){
    	Collection aux=new ArrayList();
    	for(int i=0;i<jerarquias.length;i++){
    		
			TaxonVO nuevoTaxon=new TaxonVO();//Generamos un nuevo taxon que tenga como identificador la i y como texto la concatenacion de los textos del array de taxones
			nuevoTaxon.setEsHoja(new Boolean("false"));
			Integer entero=null;
			entero=new Integer(i);
			
			nuevoTaxon.setId(entero.toString());
			JerarquiaVO jerarquia=jerarquias[i];
			TaxonVO[] jerarTax=(TaxonVO[])(jerarquia.getJerarquia());
			String valorTax="";
			for(int j=0;j<jerarTax.length;j++){	
				valorTax=valorTax+ jerarTax[j].getValorTax().toString();
				if(j<jerarTax.length-1)
					valorTax=valorTax+" -> ";
			}
			nuevoTaxon.setValorTax(valorTax);
			aux.add(nuevoTaxon);
		}
    	return aux;
	}

    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("NavegarTesauroControllerImpl - getPropertyValue:Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
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
					logger.error("NavegarTesauroControllerImpl - obtenerIdiomaBusqueda: Error en al obtener idioma búsqueda usuario LDAP, se recoge idioma de fichero propiedades.",e);
					idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				}
	   	}else idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			return idiomaNavegacion;
	}
    
    private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}