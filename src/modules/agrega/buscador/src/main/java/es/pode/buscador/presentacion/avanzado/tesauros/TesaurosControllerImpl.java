/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.tesauros;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.BuscarSession;
import es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;



/**
 * @see es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController
 */
public class TesaurosControllerImpl extends TesaurosController
{

	private static Logger logger = Logger.getLogger(TesaurosControllerImpl.class);
	private static String VARIAS_RUTAS_DISPONIBLES = "0.0";
	private java.util.Properties pSpringProperties = null;
	
	private final static String TITULOTESAURO = "tesauro.NomTesauro";
	
	private static final String FICHERO = "application-resources";
	private static final String EUSKERA = "eu";
	private static final String INGLES = "en";
	private static final String SPACE = " ";

    /**
     * @see es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController#cargarTesauros(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.tesauros.CargarTesaurosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarTesauros(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.tesauros.CargarTesaurosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    		log("TesaurosControllerImpl - cargarTesauros.");
    		String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			String nomTesauro = this.getPropertyValue("nombreFichTesauros");
			TaxonVO[] taxVO =this.getSrvTesaurosServices().obtenerPrimerNivelTesauro(nomTesauro, idioma);//Se carga el primer nivel del tesauro	
			form.setIdioma(idioma);
			form.setNomTesauros("");
			form.setTaxonesVOAsArray(taxVO);
			TaxonVO[] taxVORutaPadre = new TaxonVO[0];//En la cabecera sólo pondrá Inicio
			form.setRutaPadreVOAsArray(taxVORutaPadre);
			BuscarSession os = this.getBuscarSession(request);
			os.setJerarquias(null);
			
//			Se obtiene el nombre del tesauro en el idioma de navegacion
			Locale locale = null;
			try {
				locale = devuelveLocale(request);
			} catch (Exception e) {
				logger.error("Error recuperando el locale",e);
			}
			log("TesaurosControllerImpl - cargarTesauros:Se obtiene el nombre del tesauro en el idioma de navegacion ["+idioma+"]");
			String tituloTesauro = "";
			String vocabNameTesauro = this.getSrvTesaurosServices().obtenerVocabName(nomTesauro, idioma);
//			Se forma el titulo del tesauro. El orden cambia dependiendo del idioma		 
			String literalTituloTesauro = this.getResource(TITULOTESAURO, FICHERO, locale);	
			if (EUSKERA.equals(idioma) || INGLES.equals(idioma))tituloTesauro = vocabNameTesauro + SPACE + literalTituloTesauro;
			else tituloTesauro = literalTituloTesauro + SPACE + vocabNameTesauro;
			form.setTituloTesauro(tituloTesauro);
		} catch (Exception e) {
			logger.error("TesaurosControllerImpl cargarTesauros: Error en CargarTesauro", e);
		}
     }

    /**
     * @see es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController#consultarId(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.tesauros.ConsultarIdForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void consultarId(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.tesauros.ConsultarIdForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("TesaurosControllerImpl - consultarId.");
    	String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		form.setIdioma(idioma);
		try{
			BuscarSession os = this.getBuscarSession(request);
			if(os.getJerarquias()!=null && form.isEsRuta()){//Si en el objeto de sesion las rutas jerarquicas no son nulas
				log("TesaurosControllerImpl - consultarId:Si en el objeto de sesion las rutas jerarquicas no son nulas");
				TaxonVO[] taxones = ((JerarquiaVO)os.getJerarquias().toArray()[Integer.parseInt(form.getIdTesauro())]).getJerarquia();
				JerarquiaVO jerar=new JerarquiaVO();
				jerar.setJerarquia(taxones);
				//Los terminos relacionados del ultimo taxon del array
				TaxonVO ultimoTaxon=taxones[taxones.length-1];
				TaxonVO[] terminosRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(ultimoTaxon.getId(), this.getPropertyValue("nombreFichTesauros"), idioma);
				if(terminosRelacionados!=null)for(int i = 0; i < terminosRelacionados.length;i++)terminosRelacionados[i].setValorTax("("+terminosRelacionados[i].getTipoRelacion()+") "+terminosRelacionados[i].getValorTax());
				//Insertamos en el formulario los taxones relacionados y la rutaPadre
				form.setTaxonesVO(Arrays.asList(terminosRelacionados));
				form.setRutaPadreVO(Arrays.asList(((JerarquiaVO)os.getJerarquias().toArray()[Integer.parseInt(form.getIdTesauro())]).getJerarquia()));
				form.setNomTesauros(ultimoTaxon.getValorTax());
				form.setIdTesauro(ultimoTaxon.getId());//Cambiamos el identificador de la posicion por la del ultimo taxon
				//os.setJerarquias(null);
				form.setEsRuta(false);
			}else{//Si en el objeto de sesion las rutas jerarquicas son nulas
				//Accedemos y recogemos el array de taxones de la posicion id; que sera la rutaPadre
				log("TesaurosControllerImpl - consultarId:Si en el objeto de sesion las rutas jerarquicas son nulas, accedemos y recogemos el array de taxones de la posicion id; que sera la rutaPadre");
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(form.getIdTesauro(), this.getPropertyValue("nombreFichTesauros"), idioma);
				if(taxonesRelacionados!=null)for(int i = 0; i < taxonesRelacionados.length;i++)taxonesRelacionados[i].setValorTax("("+taxonesRelacionados[i].getTipoRelacion()+") "+taxonesRelacionados[i].getValorTax());
				form.setTaxonesVO(Arrays.asList(taxonesRelacionados));//insertamos los taxones en el formulario
				JerarquiaVO[] jerarquia=this.getSrvTesaurosServices().obtenerJerarquia(form.getIdTesauro(), this.getPropertyValue("nombreFichTesauros"), idioma);//Obtenemos las jerarquias
				form.setRutaPadreVO(obtenerJerarquias(jerarquia, os , idioma));
			}
		}catch (Exception e) {
			logger.error("TesaurosControllerImpl - consultarId: Error en consulta Id", e);
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

    /**
     * @see es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController#consultarPadreTaxon(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.tesauros.ConsultarPadreTaxonForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void consultarPadreTaxon(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.tesauros.ConsultarPadreTaxonForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("TesaurosControllerImpl - consultarPadreTaxon");
    	String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		BuscarSession os = this.getBuscarSession(request);
		try{
			String nomTesauro = this.getPropertyValue("nombreFichTesauros");
			if(form.getIdTesauro()!=null && !form.getIdTesauro().equals(VARIAS_RUTAS_DISPONIBLES)){//Cuando viene con un identificador que no le hemos insertado nosotros
				log("TesaurosControllerImpl - consultarPadreTaxon:Cuando viene con un identificador que no le hemos insertado nosotros");
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(form.getIdTesauro(), nomTesauro, idioma);
				if(taxonesRelacionados!=null)for(int i = 0; i < taxonesRelacionados.length;i++)taxonesRelacionados[i].setValorTax("("+taxonesRelacionados[i].getTipoRelacion()+") "+taxonesRelacionados[i].getValorTax());
				form.setTaxonesVO(Arrays.asList(taxonesRelacionados));//insertamos los taxones en el formulario
				JerarquiaVO[] jerarquia=this.getSrvTesaurosServices().obtenerJerarquia(form.getIdTesauro(), nomTesauro, idioma);//Obtenemos las jerarquias
				form.setRutaPadreVO(obtenerJerarquias(jerarquia, os , idioma));
			}else{//Si viene con varias rutas disponibles, por eso lleva el identificador 0.0
				log("TesaurosControllerImpl - consultarPadreTaxon:Si viene con varias rutas disponibles, por eso lleva el identificador 0.0");
				Collection coleccionRutas=os.getJerarquias();
			    Collection taxones=new ArrayList();
				for(int i=0;i<coleccionRutas.size();i++){//Recorremos la coleccion de jerarquias en sesion
					TaxonVO nuevoTaxon=new TaxonVO();//Generamos un nuevo taxon
					nuevoTaxon.setEsHoja(new Boolean("false"));	
					form.setEsRuta(true);
					nuevoTaxon.setId(new Integer(i).toString());//Llevara por identificador la i(de la posicion en las rutas)					
					JerarquiaVO jerarquias=(JerarquiaVO)coleccionRutas.toArray()[i];
					TaxonVO[] jerarTax=jerarquias.getJerarquia();			
					String texto ="";
					for(int j=0;j<jerarTax.length;j++){	
							texto=texto+ jerarTax[j].getValorTax().toString();
							if(j<jerarTax.length-1)
								texto=texto+" -> ";
					}//El texto sera la concatenacion de todos los textos del array de taxones
					nuevoTaxon.setValorTax(texto);
					taxones.add(nuevoTaxon);//Array de taxones			
				}
				TaxonVO[] taxVORutaPadre = new TaxonVO[0];
				JerarquiaVO jerarquia=new JerarquiaVO();
				jerarquia.setJerarquia(taxVORutaPadre);//En la cabecera sólo aparecera Inicio
				form.setRutaPadreVOAsArray(taxVORutaPadre);
				form.setTaxonesVO(taxones);//insertamos los taxones relacionados en el formulario
			}	
		}catch (Exception e) {
			logger.error("TesaurosControllerImpl - consultarPadreTaxon: Error en consultaPadreTaxon", e);
		}
     }
    

    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		logger.debug("TesaurosControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//		 devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

	

	public void buscarTerminos(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.tesauros.BuscarTerminosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			log("TesaurosControllerImpl - buscarTerminos");
			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			String nomTesauro = this.getPropertyValue("nombreFichTesauros");
			form.setIdioma(idioma);
			String textoBusqueda = form.getTextoBusqueda();
			if(textoBusqueda==null)textoBusqueda=""; 
			JerarquiaVO[] jerarquias=this.getSrvTesaurosServices().obtenerTerminos(textoBusqueda,nomTesauro, idioma);
			BuscarSession os = this.getBuscarSession(request);
	    	Collection rutas=new ArrayList();
	    	if (jerarquias.length==1){
	    		String id = jerarquias[0].getJerarquia()[jerarquias[0].getJerarquia().length-1].getId();
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
				if(taxonesRelacionados!=null)for(int i = 0; i < taxonesRelacionados.length;i++)taxonesRelacionados[i].setValorTax("("+taxonesRelacionados[i].getTipoRelacion()+") "+taxonesRelacionados[i].getValorTax());
				form.setTaxonesVOAsArray(taxonesRelacionados);
				form.setNomTesauros(jerarquias[0].getJerarquia()[jerarquias[0].getJerarquia().length-1].getValorTax());
				form.setIdTesauro(jerarquias[0].getJerarquia()[jerarquias[0].getJerarquia().length-1].getId());
				form.setRutaPadreVOAsArray(jerarquias[0].getJerarquia());
				
	    	}else{
	    		rutas=rutasBusqueda(jerarquias);
		    	form.setRutaPadreVO(null);
		    	form.setTaxonesVO(rutas);
		    	form.setEsRuta(true);
		    	Collection cJerarquias = new ArrayList();
		    	for(int i=0;i<jerarquias.length;i++){
		    		cJerarquias.add(jerarquias[i]);
		    	}
		    	os.setJerarquias(cJerarquias);
	    	}
		}catch (Exception e) {
			logger.error("TesaurosControllerImpl buscarTerminos: Error en consultaPadreTaxon", e);
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