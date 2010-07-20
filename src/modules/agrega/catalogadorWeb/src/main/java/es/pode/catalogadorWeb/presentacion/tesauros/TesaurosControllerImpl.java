/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.tesauros;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AvClassificationVO;
import es.pode.catalogacion.negocio.servicios.EntryVO;
import es.pode.catalogacion.negocio.servicios.IdVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.RutaTaxonomicaVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.catalogadorWeb.presentacion.tesauros.TesaurosController
 */
public class TesaurosControllerImpl extends TesaurosController
{ 
	protected static Logger logger = Logger.getLogger(TesaurosControllerImpl.class);

	 /**
	 * Carga los tesauros con el nombre seleccionado en el combo de fuentes taxonómicas del
	 * catalogador avanzado y nos devuelve los términos de primer nivel, es decir, los que no tienen padre.
	 * Estos términos los metemos en taxonesvo, y en rutaPadrevo metemos un taxón vacío
	 * @throws Exception
	 */
    public final void cargaTesauros(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.CargaTesaurosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
			InputStream iss=null;
			
			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			String ficheroProperties = "/catalogadorAvanzado.properties";
			
			iss= this.getClass().getResourceAsStream(ficheroProperties);
			Properties fprop = new Properties();
			fprop.load(iss);

			String nomTesauro = "";
			String vocabName="";
			//recogemos idioma y nombreTesauro de los combos
			CatalogadorAvSession osa= this.getCatalogadorAvSession(request);
			if ((osa!=null)&&(osa.getMDSesion()!=null)){
				nomTesauro= request.getParameter("nomTesauro");
				idioma=request.getParameter("idioma");//valor que se ha recogido del combo del formulario
				vocabName=request.getParameter("vocabName");
			}
			
			
			TaxonVO[] taxVO =this.getSrvTesaurosServices().obtenerPrimerNivelTesauro(nomTesauro, idioma);//Se carga el primer nivel del tesauro
		
			form.setIdioma(idioma);
			
			form.setNomTesauro(nomTesauro);
			form.setVocabName(vocabName);
			form.setTaxonesvoAsArray(taxVO);
			
			CatalogadorAvSession os = this.getCatalogadorAvSession(request);
			
			os.setRutasJerarquicas(null);
			
			TaxonVO[] taxVORutaPadre = new TaxonVO[0];//En la cabecera sólo pondrá Inicio
			form.setRutaPadrevoAsArray(taxVORutaPadre);

		} catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo cargaTesauros " + e);
			throw new java.lang.Exception("tesauros", e);
		}
     }

    /**
	 * Obtiene los terminos relacionados del identificador que le pasamos mediante el servicio del tesauro.
	 * Si las rutas jerárquicas del objeto de sesion son nulas, o si es varias rutas disponible obtenemos los términos relacionados,
	 * con el identificador que nos viene de la request, que es el del término.Los taxones relacionados los almacenamos en taxonesvo.
	 * Calculamos las jerarquías de ese término. Si tiene mas de una jerarquía, los guardamos en sesión y nos generamos una ruta padre con variasRutasDisponibles
	 * y nuestro término y lo guardamos en el formulario. Si sólo tiene una jerarquía lo guardamos en el formulario y ponemos a null en el objeto de sesión
	 * las rutasJerarquicas.
	 * Si en el objeto de sesión las rutas no son nulas recogemos la jerarquia del objeto de sesión que esta en la posición id ( que va a ser el que le hemos metido nosotros, no es
	 * el identificador de ningún taxón, sino el del taxón que generamos concatenando todos los textos de los taxones. Recogemos los taxones y los metemos en el formulario, en rutaPadrevo.
	 * Recogemos los términos relacionados del último taxón de la concatenación y los metemos en taxonesvo. Cambiamos el identificador de la posición
	 * por el del taxón en el formulario.
	 * Ponemos las rutasJerarquicas a null
	 * @throws Exception
	 */
    public final void consultaTesId(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.ConsultaTesIdForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String idioma=request.getParameter("idioma");
    	if(idioma==null || idioma.equals("")){
    		idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    	}
		
    	InputStream iss=null;
		boolean bandera=false;
		
		String ficheroProperties = "/catalogadorAvanzado.properties";
		
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		
		String nomTesauro = request.getParameter("nomTesauro");
		String id = request.getParameter("id");
		String vocabName=request.getParameter("vocabName");
		form.setIdioma(idioma);
		form.setNomTesauro(nomTesauro);
		form.setVocabName(vocabName);
		String segundoId="";
		Object valor = request.getSession().getAttribute("form");
		
		if (valor instanceof TesaurosFormImpl) {
			form.setRutaPadrevo(((TesaurosFormImpl)valor).getRutaPadrevo());
		}
		else if( valor instanceof TesaurosFormConsultaNodoFormImpl){
			form.setRutaPadrevo(((TesaurosFormConsultaNodoFormImpl)valor).getRutaPadrevo());
		}
		else if( valor instanceof TesaurosFormBuscarFormImpl){
			form.setRutaPadrevo(((TesaurosFormBuscarFormImpl)valor).getRutaPadrevo());
		}else if( valor instanceof TesaurosFormConsultaPadreFormImpl){
			form.setRutaPadrevo(((TesaurosFormConsultaPadreFormImpl)valor).getRutaPadrevo());
		}
		
		if((form.getRutaPadrevo()!=null)){//Si rutapadrevo es distinto a null, recogemos el identificador del texon de la primera posicion, para saber 
			if(form.getRutaPadrevoAsArray().length>0){//si es varias rutas disponibles
				JerarquiaVO jerarquiaForm = (JerarquiaVO)(form.getRutaPadrevoAsArray()[0]);
				if(jerarquiaForm.getJerarquia().length>1){
					TaxonVO segundoTax = (TaxonVO)jerarquiaForm.getJerarquia()[0];
					segundoId=segundoTax.getId();
				}
			}
		}
		
		
		String iden="0.0";
		try{
			//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			
			CatalogadorAvSession os = this.getCatalogadorAvSession(request);
			if((os.getRutasJerarquicas()==null)||(iden.equals(segundoId))){//Si en el objeto de sesion las rutas jerarquicas son nulas
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
				Collection taxonesRelacion=new ArrayList();//Recogemos los taxones relacionados en una coleccion
				for(int j=0;j<taxonesRelacionados.length;j++){
					taxonesRelacion.add(taxonesRelacionados[j]);
				}
				form.setTaxonesvo(taxonesRelacion);//insertamos los taxones en el formulario
				JerarquiaVO[] jerarquia=this.getSrvTesaurosServices().obtenerJerarquia(id, nomTesauro, idioma);//Obtenemos las jerarquias
				if(jerarquia.length>1){//Si hay más de una jerarquia
					Collection jerarquiaC=new ArrayList();//Guardamos el en objeto de sesion todas las rutas disponibles
					for(int i=0;i<jerarquia.length;i++){
						jerarquiaC.add(jerarquia[i]);
					}
					os.setRutasJerarquicas(jerarquiaC);
					
					Collection rutaPadre=new ArrayList();
	//				El taxon para representar que hay mas de una ruta, con el texto varias rutas disponibles
					TaxonVO rutaAlternativa=new TaxonVO();				
					rutaAlternativa.setEsHoja(new Boolean("false"));
					rutaAlternativa.setId(iden);//Le metemos 0.0 como identificador
					String valorTax=datosResources.getString("variasRutasDisponibles").toString();
					rutaAlternativa.setValorTax(valorTax);
					//Vamos a recoger el taxon con identificador id
					JerarquiaVO fJerarquia=jerarquia[0];
					TaxonVO[] lTaxones=fJerarquia.getJerarquia();
					TaxonVO ultimoTaxon=lTaxones[lTaxones.length-1];
					List lTax=new ArrayList();
					lTax.add(rutaAlternativa);
					lTax.add(ultimoTaxon);
					//El array de TaxonesVO que contiene el varias rutas disponibles y el taxon del identificador id
					TaxonVO[] tax=(TaxonVO[])lTax.toArray(new TaxonVO[lTax.size()]);
					//Añadimos el array de taxones a una JerarquiaVO
					JerarquiaVO nuevaJerar=new JerarquiaVO();
					nuevaJerar.setJerarquia(tax);
					//Añadimos la JerarquiaVO a una coleccion ( a la rutaPadre)
					rutaPadre.add(nuevaJerar);
					form.setRutaPadrevo(rutaPadre);//Insertamos la rutaPadre en el formulario
					
				}else{
					Collection rutaPadre=new ArrayList();
					rutaPadre.add(jerarquia[0]);//a la colecion rutaPadre le insertamos la única jerarquia que tenemos y lo metemos en el formulario
					os.setRutasJerarquicas(null);
					form.setRutaPadrevo(rutaPadre);
				}
				form.setId(id);
			}else{//Si en el objeto de sesion las rutas jerarquicas no son nulas
				Collection rutaPadre=new ArrayList();
				Integer entero=null;
				entero=new Integer(id);
				//Accedemos y recogemos el array de taxones de la posicion id; que sera la rutaPadre
				Collection coleccionRutas=os.getRutasJerarquicas();
				JerarquiaVO jerarquia=(JerarquiaVO)coleccionRutas.toArray()[entero.intValue()];
				TaxonVO[] taxones = jerarquia.getJerarquia();
				JerarquiaVO jerar=new JerarquiaVO();
				jerar.setJerarquia(taxones);
				rutaPadre.add(jerar);
				//Los terminos relacionados del ultimo taxon del array
				TaxonVO ultimoTaxon=taxones[taxones.length-1];
				TaxonVO[] terminosRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(ultimoTaxon.getId(), nomTesauro, idioma);
				Collection taxonesRelacion=new ArrayList();//Recogemos los taxones relacionados en una coleccion
				for(int j=0;j<terminosRelacionados.length;j++){
					taxonesRelacion.add(terminosRelacionados[j]);
				}
				//Insertamos en el formulario los taxones relacionados y la rutaPadre
				form.setTaxonesvo(taxonesRelacion);
				form.setRutaPadrevo(rutaPadre);
				form.setId(ultimoTaxon.getId());//Cambiamos el identificador de la posicion por la del ultimo taxon
				os.setRutasJerarquicas(null);
			}
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo consultaTesId " + e);
			throw new java.lang.Exception("tesauros", e);
		}
     }

    /**
	 * Consulta los términos relacionados
	 * 
	 * Le viene el identificador por parametro. Si el identificador es distinto a "0.0", quiere decir que no es varias rutas disponibles.
	 * Calculamos los términos relacionados de ese identificador, y los metemos en taxonesvo del formulario. Calculamos las jerarquías, si tiene
	 * más de una jerarquía los guardamos en el objeto de sesión y nos generamos la jerarquía auxiliar, que tenga varias rutas disponibles y nuestro taxón
	 * y lo guardamos en la rutaPadrevo. Si sólo tiene una ruta lo metemos en la rutaPadrevo y ponemos a null rutasJerarquicas del objeto de sesión.
	 * Si el identificador es "0.0", quiere decir que hemos pulsado en varias rutas disponibles. Recogemos las rutas jerárquicas del objeto de sesión.
	 * Nos generamos nuevos taxones, que tendrán como identificador la "posición" y el texto será la concatenación de todos los textos de los taxones de
	 * cada ruta jerárquica.
	 * En la ruta padre insertaremos un taxón vacío, para que en la cabecera no aparezca nada, y insertaremos los taxones relacionados
	 * en taxonesvo.
	 * 
	 * @throws Exception
	 */
    public final void consultaPadreTaxon(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.ConsultaPadreTaxonForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		String idioma=request.getParameter("idioma");
		if(idioma==null||idioma.equals(""))
			idioma = this.getCatalogadorAvSession(request).getIdioma();
		String nomTesauro = request.getParameter("nomTesauro");
		String id = request.getParameter("id");
		String vocabName=request.getParameter("vocabName");
		CatalogadorAvSession os = this.getCatalogadorAvSession(request);
		
		String ficheroProperties = "/catalogadorAvanzado.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		fprop.load(iss);
		try{
			if(!id.equals("0.0")){//Cuando viene con un identificador que no le hemos insertado nosotros
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
				Collection taxonesRelacion=new ArrayList();//Recogemos los taxones relacionados en una coleccion
				for(int j=0;j<taxonesRelacionados.length;j++){
					taxonesRelacion.add(taxonesRelacionados[j]);
				}
				form.setTaxonesvo(taxonesRelacion);//insertamos los taxones en el formulario
				JerarquiaVO[] jerarquia=this.getSrvTesaurosServices().obtenerJerarquia(id, nomTesauro, idioma);//Obtenemos las jerarquias
				if(jerarquia.length>1){//Si hay más de una jerarquia
					Collection jerarquiaC=new ArrayList();//Guardamos el en objeto de sesion todas las rutas disponibles
					for(int i=0;i<jerarquia.length;i++){
						jerarquiaC.add(jerarquia[i]);
					}
					os.setRutasJerarquicas(jerarquiaC);
					
					Collection rutaPadre=new ArrayList();
	//				El taxon para representar que hay mas de una ruta, con el texto varias rutas disponibles
					TaxonVO rutaAlternativa=new TaxonVO();				
					rutaAlternativa.setEsHoja(new Boolean("false"));
					rutaAlternativa.setId("0.0");
					String valorTax=fprop.getProperty("variasRutasDisponibles").toString();
					rutaAlternativa.setValorTax(valorTax);
					//Vamos a recoger el taxon con identificador id
					JerarquiaVO fJerarquia=jerarquia[0];
					TaxonVO[] lTaxones=fJerarquia.getJerarquia();
					TaxonVO ultimoTaxon=lTaxones[lTaxones.length-1];
					List lTax=new ArrayList();
					lTax.add(rutaAlternativa);
					lTax.add(ultimoTaxon);
					//El array de TaxonesVO que contiene el varias rutas disponibles y el taxon del identificador id
					TaxonVO[] tax=(TaxonVO[])lTax.toArray(new TaxonVO[lTax.size()]);
					//Añadimos el array de taxones a una JerarquiaVO
					JerarquiaVO nuevaJerar=new JerarquiaVO();
					nuevaJerar.setJerarquia(tax);
					//Añadimos la JerarquiaVO a una coleccion ( a la rutaPadre)
					rutaPadre.add(nuevaJerar);
					form.setRutaPadrevo(rutaPadre);//Insertamos la rutaPadre en el formulario
					
				}else{
					Collection rutaPadre=new ArrayList();
					rutaPadre.add(jerarquia[0]);//a la colecion rutaPadre le insertamos la única jerarquia que tenemos y lo metemos en el formulario
					os.setRutasJerarquicas(null);
					form.setRutaPadrevo(rutaPadre);
				}
	
			}else{//Si viene con varias rutas disponibles, por eso lleva el identificador 0.0
				Collection coleccionRutas=os.getRutasJerarquicas();
			    Collection taxones=new ArrayList();
				for(int i=0;i<coleccionRutas.size();i++){//Recorremos la coleccion de jerarquias en sesion
					TaxonVO nuevoTaxon=new TaxonVO();//Generamos un nuevo taxon
					nuevoTaxon.setEsHoja(new Boolean("false"));
					
					Integer entero=null;
					entero=new Integer(i);
					nuevoTaxon.setId(entero.toString());//Llevara por identificador la i(de la posicion en las rutas)
					
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
				form.setRutaPadrevoAsArray(taxVORutaPadre);
				form.setTaxonesvo(taxones);//insertamos los taxones relacionados en el formulario
				
			}
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo consultaPadreTaxon " + e);
			throw new java.lang.Exception("tesauros", e);
		}
     }

    /**
	 * Asocia el tesauro cuando sólo tenemos una ruta.
	 * Recogemos la ruta padre del formulario y insertamos los taxones uno a uno en los taxones de tipo es.pode.catalogacion.negocio.servicios.TaxonVO.
	 * Los cargamos en el calsificacionAux  (teniendo en cuenta, que si traía alguna ruta de antes, se guardan los que había y se le añade el nuevo).
	 * @throws Exception
	 */
    public final void asociarTesauro(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.AsociarTesauroForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CatalogadorAvSession os = this.getCatalogadorAvSession(request);
//		Collection rutaPadre=new ArrayList();
		String idioma = form.getIdioma();// this.getCatalogadorBSession(request).getIdioma();
		String nomTesauro = form.getNomTesauro();// request.getParameter("nomTaxonomia");

		Object valor = request.getSession().getAttribute("form");
		
		if (valor instanceof TesaurosFormConsultaNodoFormImpl) {//??????????????
			form.setId(((TesaurosFormConsultaNodoFormImpl)valor).getId());
			form.setRutaPadrevo(((TesaurosFormConsultaNodoFormImpl)valor).getRutaPadrevo());
		}
		else if(valor instanceof TesaurosFormConsultaPadreFormImpl ){
			form.setId(((TesaurosFormConsultaPadreFormImpl)valor).getId());
			form.setRutaPadrevo(((TesaurosFormConsultaPadreFormImpl)valor).getRutaPadrevo());
		}
		else if(valor instanceof TesaurosFormBuscarFormImpl ){
			form.setId(((TesaurosFormBuscarFormImpl)valor).getId());
			form.setRutaPadrevo(((TesaurosFormBuscarFormImpl)valor).getRutaPadrevo());
		}
		Object[] jerarquias = form.getRutaPadrevoAsArray();

		try{
		   
				AvClassificationVO clasificacionAux=os.getClasificacionAux();
				RutaTaxonomicaVO[] rutasTaxonomicasClas=null;
				RutaTaxonomicaVO rutaTaxonomica=new RutaTaxonomicaVO();
				ArrayList lRutas=new ArrayList();
				if(clasificacionAux!=null){
					rutasTaxonomicasClas=clasificacionAux.getRutasTaxonomicas();//Recogemos las rutas padre que habia de antes y le añadimos el nuevo
					if(rutasTaxonomicasClas!=null)
						for(int i=0;i<rutasTaxonomicasClas.length;i++){
							lRutas.add(rutasTaxonomicasClas[i]);
						}
				}else{
					clasificacionAux=new AvClassificationVO();
				}
				ArrayList listaT=new ArrayList();
				JerarquiaVO jerarquia=((JerarquiaVO)jerarquias[0]);
				TaxonVO[] listTax=jerarquia.getJerarquia();
				for(int j=0;j<listTax.length;j++){//Generamos el array de taxones
					String ident=listTax[j].getId();
					String text=listTax[j].getValorTax();
					es.pode.catalogacion.negocio.servicios.TaxonVO taxonAux=new es.pode.catalogacion.negocio.servicios.TaxonVO();
					EntryVO entry=new EntryVO();
					ArrayList textos=new ArrayList();
					LangStringVO texto=new LangStringVO();
					texto.setTexto(text);
					texto.setIdioma(idioma);
					textos.add(texto);
					LangStringVO[] lang=(LangStringVO[])textos.toArray(new LangStringVO[textos.size()]);
					entry.setTextos(lang);
					taxonAux.setEntry(entry);
					IdVO ide=new IdVO();
					ide.setTexto(ident);
					taxonAux.setId(ide);
					listaT.add(taxonAux);
				}
				es.pode.catalogacion.negocio.servicios.TaxonVO[] lTaxones=(es.pode.catalogacion.negocio.servicios.TaxonVO[])listaT.toArray(new es.pode.catalogacion.negocio.servicios.TaxonVO[listaT.size()]);
				
//				rutaTaxonomica.setTaxones(lTaxones);
//				FuenteVO fuente=new FuenteVO();
//				LangStringVO texto=new LangStringVO();
//				ArrayList textos=new ArrayList();
//				texto.setIdioma(idioma);//El idioma que nos viene como parametro
//				texto.setTexto(nomTesauro);//El nombre del tesauro que nos viene como parametro
//				textos.add(texto);
//				LangStringVO[] lang=(LangStringVO[])textos.toArray(new LangStringVO[textos.size()]);
//				fuente.setTextos(lang);
//				rutaTaxonomica.setFuente(fuente);//Generada la nueva ruta taxonomica
//				lRutas.add(rutaTaxonomica);//Añadir a las rutas existentes
//				RutaTaxonomicaVO[] rutas=(RutaTaxonomicaVO[])lRutas.toArray(new RutaTaxonomicaVO[lRutas.size()]);
//				clasificacionAux.setRutasTaxonomicas(rutas);//Añadimos las rutas a la clasificacion auxiliar
//				os.setClasificacionAux(clasificacionAux);//Añadimos a la sesion la clasificacion
//				os.setRutasJerarquicas(null);

				AvClassificationVO clasAux= os.getClasificacionAux();
				RutaTaxonomicaVO rt= clasAux.getRutasTaxonomicas()[clasAux.getRutasTaxonomicas().length -1];
				if (rt!=null){
					rt.setTaxones(lTaxones);
					os.setRutasJerarquicas(null);
				}
				
	
				if( logger.isDebugEnabled() ){
		
		            logger.debug("Actualizados la sesion y el tesauro" );
				}
		   
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo asociarTesauro " + e);
			throw new java.lang.Exception("tesauros", e);
		}
    }

    /**
	 * Generamos la lista de las jerarquías.
	 * Si en el formulario las jerarquías son distintas a null comprobamos que el primer taxón no sea de varias rutas disponibles, si es así
	 * metemos esa jerarquia en el formulario.
	 * Si al contrario, el segundo taxón es varias rutas disponibles, obtenemos las jerarquias del identificador y los guardamos en el formulario.
	 * Si el formulario no tiene rutas, las obtenemos con el identificador y los guardamos en el formulario.
	 * @throws Exception
	 */
    public final void jerarquiasLista(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.JerarquiasListaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{//Recogemos el array de jerarquiaVO y lo insertamos en enu coleccion
    		Collection cJerarquia=new ArrayList();
    		Object valor = request.getSession().getAttribute("form");
    		
    		if (valor instanceof TesaurosFormConsultaNodoFormImpl) {
    			form.setId(((TesaurosFormConsultaNodoFormImpl)valor).getId());
    			form.setJerarquias(((TesaurosFormConsultaNodoFormImpl)valor).getRutaPadrevo());
    		}else if(valor instanceof TesaurosFormAsociarTesauroFormImpl){
    			form.setId(((TesaurosFormAsociarTesauroFormImpl)valor).getId());
    		}else if(valor instanceof TesaurosFormConsultaPadreFormImpl){
    			form.setId(((TesaurosFormConsultaPadreFormImpl)valor).getId());
    		}else if (valor instanceof TesaurosFormBuscarFormImpl){
    			form.setId(((TesaurosFormBuscarFormImpl)valor).getId());
    			form.setJerarquias(((TesaurosFormBuscarFormImpl)valor).getRutaPadrevo());
    		}
    		
	    	String idioma = form.getIdioma();// this.getCatalogadorBSession(request).getIdioma();
			String nomTesauro = form.getNomTesauro();

			String id=form.getId();// request.getParameter("nomTaxonomia");
			if(form.getJerarquias()!=null){
				Object[] listJerar=form.getJerarquiasAsArray();
				JerarquiaVO listTax=(JerarquiaVO)listJerar[0];
				TaxonVO[] lisTaxones=listTax.getJerarquia();
				if(!(lisTaxones[0].getId().equals("0.0"))){
					cJerarquia.add(listTax);
				}else{
					JerarquiaVO[] jerarquia = this.getSrvTesaurosServices().obtenerJerarquia(id, nomTesauro, idioma);
			        
			        if((jerarquia!=null)&&(jerarquia.length>0)){
			        	for(int i=0;i<jerarquia.length;i++){
			        		TaxonVO[] lTaxon=jerarquia[i].getJerarquia();
			        		cJerarquia.add(lTaxon);//En cada posicion de la coleccion meto el array de taxones
			        	}
			        }
				}
			}else{
			
		        JerarquiaVO[] jerarquia = this.getSrvTesaurosServices().obtenerJerarquia(id, nomTesauro, idioma);
		        
		        if((jerarquia!=null)&&(jerarquia.length>0)){
		        	for(int i=0;i<jerarquia.length;i++){
		        		TaxonVO[] lTaxon=jerarquia[i].getJerarquia();
		        		cJerarquia.add(lTaxon);//En cada posicion de la coleccion meto el array de taxones
		        	}
		        }
			}
	        form.setJerarquias(cJerarquia);//Lo metemos en el formulario
    	
    	}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo jerarquiasLista " + e);
			throw new java.lang.Exception("tesauros", e);
		}
       
    }

    /**
	 * Machacamos lo que había en las rutas jerárquicas del objeto de sesión, y le insertamos lo que hay en el formulario.
	 * Recogemos las rutas jerárquicas del formulario y los metemos en el objeto de sesión.
	 * Recorremos todas las jerarquías y los metemos en taxones auxiliares que tengan como identificador la posición y como texto la concatenación
	 * de los textos de los taxones de cada jerarquía.
	 * Ponemos a null la rutaPadrevo del formulario y metemos en taxonesvo los taxones auxiliares que acabamos de generar.
	 * @throws Exception
	 */
    public final void cambiarJerarquiaSesion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.CambiarJerarquiaSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{//Machacamos lo que habia en las rutas jerarquicas del objeto de sesion y le insertamos lo que hay en el formulario
	    	CatalogadorAvSession os = this.getCatalogadorAvSession(request);
	    	Collection jerarquias=form.getJerarquias();
	    	os.setRutasJerarquicas(jerarquias);
	    	
	    	Collection Aux=new ArrayList();
	    	Object[] jeraquiaArray = form.getJerarquiasAsArray();
	    	for(int i=0;i<jeraquiaArray.length;i++){

				TaxonVO nuevoTaxon=new TaxonVO();//Generamos un nuevo taxon que tenga como identificador la i y como texto la concatenacion de los textos del array de taxones
				nuevoTaxon.setEsHoja(new Boolean("false"));
				Integer entero=null;
				entero=new Integer(i);
				
				nuevoTaxon.setId(entero.toString());
				
				TaxonVO[] jerarTax=(TaxonVO[])(jeraquiaArray[i]);
				String valorTax="";
				for(int j=0;j<jerarTax.length;j++){	
					valorTax=valorTax+ jerarTax[j].getValorTax().toString();
					if(j<jerarTax.length-1)
						valorTax=valorTax+" -> ";
			}
				nuevoTaxon.setValorTax(valorTax);
				Aux.add(nuevoTaxon);
			}
	    	form.setRutaPadrevo(null);
	    	form.setTaxonesvo(Aux);
	    	
    	}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo cambiarJerarquiaSesion " + e);
			throw new java.lang.Exception("tesauros", e);
		}
     }

    /**
     * Recogemos las jerarquías del formulario y vemos si sólo tiene uno (true) o más (false).
     */
    public final int longitudJerarquia(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.LongitudJerarquiaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	int longitud=0;
    	try{//Nos dice si la longitud de la jerarquia es mayor que uno
	        Collection jerarquias=form.getJerarquias();
	        if(jerarquias.size()==1){//Si la longitud es 1, longitud sera true, para representar que es de longitud 1; si no se mantiene a  false
	        	longitud=1;
	        }
	        else if(jerarquias.size()==0){
	        	longitud=0;
	        }
	        else {
	        	longitud=2;
	        }
    	}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo longitudJerarquia " + e);
			throw new java.lang.Exception("tesauros", e);
		}
        return longitud;
    }

    /**
     * Asocia las Relaciones, es decir las rutas jerárquicas que hemos generado con identificador de la posición y el texto la concatenación de los textos de los taxones de cada una de las jerarquías.
     * Si clasificationAux tiene alguna ruta jerárquica lo guardamos y le añadiremos la nueva.
     * Recogemos las jerárquias del objeto de sesión y accedemos al que está en la posición id, y esos taxones los insertamos en taxones de tipo es.pode.catalogacion.negocio.servicios.TaxonVO[].
     * Los añadimos a clasificationAux,y este en el objeto de sesión.
     * Ponemos las rutasJerarquicas del objeto de sesión a null.
     */
    public final void asociaRelacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.tesauros.AsociaRelacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//Comprobamos que se ha seleccionado algun radioButton
    	if(form.getId()==null || form.getId().equals(""))
			throw new ValidatorException("{tesauro.relaciones.jerarquicas.seleccione}");
    	else{
	    	try{//Asocia  la relacion que esta en la posicion i, cogiendo los taxones uno a uno
	    		
	    		String id=request.getParameter("id");    		
		    	String idioma=form.getIdioma();
		    	String nomTesauro=form.getNomTesauro();	  

		    	CatalogadorAvSession os = this.getCatalogadorAvSession(request);
		    	Object[] jerarquias=os.getRutasJerarquicas().toArray();
		    	Integer entero=new Integer(id);
		    	AvClassificationVO clasificationAux = os.getClasificacionAux();
		    	RutaTaxonomicaVO[] rutasTaxonomicasClas=null;
	//			RutaTaxonomicaVO rutaTaxonomica=new RutaTaxonomicaVO();
		    	RutaTaxonomicaVO rutaTaxonomica= null;
				ArrayList lRutas=new ArrayList();
		    	if(clasificationAux!=null){
					rutasTaxonomicasClas=clasificationAux.getRutasTaxonomicas();//Recogemos las rutas padre que habia de antes y le añadimos el nuevo
					if(rutasTaxonomicasClas!=null)
						for(int i=0;i<rutasTaxonomicasClas.length;i++){
							lRutas.add(rutasTaxonomicasClas[i]);
						}
				}else{
					clasificationAux=new AvClassificationVO();
				}
		    	
		    	TaxonVO[] listTax=(TaxonVO[])jerarquias[entero.intValue()];//Array de taxones del objeto de sesion
				
				ArrayList listaT=new ArrayList();
				for(int j=0;j<listTax.length;j++){//Generamos el array de taxones
					String ident=listTax[j].getId();
					String text=listTax[j].getValorTax();
					es.pode.catalogacion.negocio.servicios.TaxonVO taxonAux=new es.pode.catalogacion.negocio.servicios.TaxonVO();
					EntryVO entry=new EntryVO();
					LangStringVO texto=new LangStringVO();
					ArrayList textos=new ArrayList();
					texto.setIdioma(idioma);//El idioma que nos viene como parametro
					texto.setTexto(text);//El nombre del tesauro que nos viene como parametro
					textos.add(texto);
					LangStringVO[] lang=(LangStringVO[])textos.toArray(new LangStringVO[textos.size()]);
					entry.setTextos(lang);
					taxonAux.setEntry(entry);
					IdVO ide=new IdVO();
					ide.setTexto(ident);
					taxonAux.setId(ide);
					listaT.add(taxonAux);
				}
				es.pode.catalogacion.negocio.servicios.TaxonVO[] lTaxones=(es.pode.catalogacion.negocio.servicios.TaxonVO[])listaT.toArray(new es.pode.catalogacion.negocio.servicios.TaxonVO[listaT.size()]);
				
				if ((rutasTaxonomicasClas!= null)&& (rutasTaxonomicasClas.length>0)){
					rutasTaxonomicasClas[rutasTaxonomicasClas.length-1].setTaxones(lTaxones);
	//				rutaTaxonomica.setTaxones(lTaxones);
	//				FuenteVO fuente=new FuenteVO();
	//				LangStringVO texto=new LangStringVO();
	//				ArrayList textos=new ArrayList();
	//				texto.setIdioma(idioma);//El idioma que nos viene como parametro
	//				texto.setTexto(nomTesauro);//El nombre del tesauro que nos viene como parametro
	//				textos.add(texto);
	//				LangStringVO[] lang=(LangStringVO[])textos.toArray(new LangStringVO[textos.size()]);
	//				fuente.setTextos(lang);
	//				rutaTaxonomica.setFuente(fuente);//Generada la nueva ruta taxonomica
	//				lRutas.add(rutaTaxonomica);//Añadir a las rutas existentes
	//				RutaTaxonomicaVO[] rutas=(RutaTaxonomicaVO[])lRutas.toArray(new RutaTaxonomicaVO[lRutas.size()]);
					clasificationAux.setRutasTaxonomicas(rutasTaxonomicasClas);//Añadimos las rutas a la clasificacion auxiliar
					os.setClasificacionAux(clasificationAux);//Añadimos la clasificacion a la sesion
					os.setRutasJerarquicas(null);
				}
				
		
	    	}catch (org.acegisecurity.AccessDeniedException ad) {
				logger.error("Error de Acceso " + ad);
	    		throw new java.lang.Exception("tesauros", ad);
			
			}catch (Exception e){
				logger.error("Error en catalogadorWeb, tesauros, metodo asociaRelacion " + e);
				throw new java.lang.Exception("tesauros", e);
			}
		}
    }

	public void buscarTerminos(ActionMapping mapping, BuscarTerminosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	 	String idioma=request.getParameter("idioma");
	 	try{
	    	if(idioma==null || idioma.equals("")){
	    		//Recogemos el idioma del navegador
	    		idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	    		
	    	}
			String nomTesauro = request.getParameter("nomTesauro");
			String vocabName= request.getParameter("vocabName");
			form.setIdioma(idioma);
			form.setNomTesauro(nomTesauro);
			form.setVocabName(vocabName);
			String textoBusqueda = form.getTextoBusqueda();
			if(textoBusqueda==null)
				textoBusqueda="";
			
			JerarquiaVO[] jerarquias=this.getSrvTesaurosServices().obtenerTerminos(textoBusqueda,nomTesauro, idioma);
			
			CatalogadorAvSession os = this.getCatalogadorAvSession(request);
	    	Collection rutas=new ArrayList();
	    	if (jerarquias.length==1){
	
	    		String id = jerarquias[0].getJerarquia()[jerarquias[0].getJerarquia().length-1].getId();
				TaxonVO[] taxonesRelacionados=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
				form.setTaxonesvoAsArray(taxonesRelacionados);
				
				Collection rutaPadre=new ArrayList();
				rutaPadre.add(jerarquias[0]);//a la colecion rutaPadre le insertamos la única jerarquia que tenemos y lo metemos en el formulario
				os.setRutasJerarquicas(null);
				form.setRutaPadrevo(rutaPadre);
				form.setId(id);
	    	}
	    	else{
	    		rutas=rutasBusqueda(jerarquias);
		    	form.setRutaPadrevo(null);
		    	form.setTaxonesvo(rutas);
		    	Collection cJerarquias = new ArrayList();
		    	for(int i=0;i<jerarquias.length;i++){
		    		cJerarquias.add(jerarquias[i]);
		    	}
		    	os.setRutasJerarquicas(cJerarquias);
	    	}
	 	
	 	}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("tesauros", ad);
		
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, tesauros, metodo buscaterminos " + e);
			throw new java.lang.Exception("tesauros", e);
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

}