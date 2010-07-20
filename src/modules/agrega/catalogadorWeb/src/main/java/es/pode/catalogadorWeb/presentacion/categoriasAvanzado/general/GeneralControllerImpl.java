/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.catalogacion.negocio.servicios.AmbitoVO;
import es.pode.catalogacion.negocio.servicios.AvGeneralVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.IdentificadorVO;
import es.pode.catalogacion.negocio.servicios.IdiomaVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.PalabraClaveVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.TituloVO;
import es.pode.catalogacion.soporte.Caracteristica;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController
 */
public class GeneralControllerImpl extends GeneralController
{ 


	protected static Logger logger = Logger.getLogger(GeneralControllerImpl.class); 

	private IdentificadorVO[] identificadores;
  	private TituloVO[] titulos;
  	private IdiomaVO[] idiomas;
  	private DescripcionVO[] descripciones;
  	private PalabraClaveVO[] palabrasClave;
  	private AmbitoVO[] ambitos;
  	private String estructura;
  	private String nivelAgregacion;

  	private Caracteristica[][] caracteristicas;
  	Map listaIdiomas;
  	
    public final void anadirIdentificador(
    		ActionMapping mapping, 
    		AnadirIdentificadorForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	
     try{

		Object valor = request.getSession().getAttribute("form");
	  
		if (valor instanceof GeneralFormImpl) {
			GeneralFormImpl formulario=(GeneralFormImpl)valor;
	      	form.setAmbitos(formulario.getAmbitos());
	      	form.setDescripciones(formulario.getDescripciones());
	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	      	form.setIdentificadores(formulario.getIdentificadores());
	      	form.setIdiomas(formulario.getIdiomas());
	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	      	form.setPalabrasClave(formulario.getPalabrasClave());
	      	form.setTitulos(formulario.getTitulos());
	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	      	
	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
	      	
		} else if (valor instanceof GeneralFormSubmitFormImpl) {
			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
	      	form.setAmbitos(formulario.getAmbitos());
	      	form.setDescripciones(formulario.getDescripciones());
	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	      	form.setIdentificadores(formulario.getIdentificadores());
	      	form.setIdiomas(formulario.getIdiomas());
	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	      	form.setPalabrasClave(formulario.getPalabrasClave());
	      	form.setTitulos(formulario.getTitulos());
	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	      	
	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
	      	form.setAmbitos(formulario.getAmbitos());
	      	form.setDescripciones(formulario.getDescripciones());
	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	      	form.setIdentificadores(formulario.getIdentificadores());
	      	form.setIdiomas(formulario.getIdiomas());
	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	      	form.setPalabrasClave(formulario.getPalabrasClave());
	      	form.setTitulos(formulario.getTitulos());
	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	      	
	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
	      	form.setAmbitos(formulario.getAmbitos());
	      	form.setDescripciones(formulario.getDescripciones());
	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	      	form.setIdentificadores(formulario.getIdentificadores());
	      	form.setIdiomas(formulario.getIdiomas());
	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	      	form.setPalabrasClave(formulario.getPalabrasClave());
	      	form.setTitulos(formulario.getTitulos());
	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	      	
	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
		}

		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
		for(int i= 0;i< form.getDescripciones().size();i++){
			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
		}
		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
		for(int i= 0;i< form.getPalabrasClave().size();i++){
			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
		}
		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
		for(int i= 0;i< form.getAmbitos().size();i++){
			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
		}
	  	int longitudDescripciones=form.getDescripciones().size();
	  	int longitudPalabrasClave=form.getPalabrasClave().size();
	  	int longitudAmbitos=form.getAmbitos().size();
	  	int longitudIdentificadores=form.getIdentificadores().size();
	  	int longitudIdiomas=form.getIdiomas().size();
	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
	  	
	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
				longitudIdiomas,longitudTitulo);

       //identificadores
       form.setIdentificadoresAsArray(identificadores);
       //titulo
       form.setTitulosAsArray(titulos);        
       //idioma
       form.setIdiomasAsArray(idiomas);
       //descripciones
       form.setDescripcionesAsArray(descripciones);
       form.setCaracteristicasAsArray(caracteristicas); 	
       //palabras clave
       form.setPalabrasClaveAsArray(palabrasClave); 
       //ambitos
       form.setAmbitosAsArray(ambitos);
    	
           
           Object[] aIdentificadores=form.getIdentificadoresAsArray();
           int nuevoTamano = aIdentificadores.length +1;
           Object[] newAIdentificadores = new Object[nuevoTamano];
    	   IdentificadorVO identificadorVO=new IdentificadorVO();
    	   identificadorVO.setCatalogo("");
    	   identificadorVO.setEntrada("");
    	   for(int i = 0; i<aIdentificadores.length;i++)
    		   newAIdentificadores[i]=aIdentificadores[i];
    	   newAIdentificadores[nuevoTamano-1]= identificadorVO;
    	   
    	   form.setIdentificadoresAsArray(newAIdentificadores);
    	   
       }catch (org.acegisecurity.AccessDeniedException ad) {
   	   	logger.error("Error de Acceso " + ad);
	   	throw new Exception("general",ad);
       }
		catch (IndexOutOfBoundsException ai) {
			logger
			.warn("Warning en catalogadorWeb, categoría General, metodo anadirIdentificador" + ai);
	    }catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría General, método anadirIdentificador " + e);
			throw new Exception("general",e);
       }
     
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirTitulo(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirTituloForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirTitulo(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirTituloForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
	    	Object valor = request.getSession().getAttribute("form");
	        
			if (valor instanceof GeneralFormImpl) {
				GeneralFormImpl formulario=(GeneralFormImpl)valor;
		      	form.setAmbitos(formulario.getAmbitos());
		      	form.setDescripciones(formulario.getDescripciones());
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdentificadores(formulario.getIdentificadores());
		      	form.setIdiomas(formulario.getIdiomas());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setPalabrasClave(formulario.getPalabrasClave());
		      	form.setTitulos(formulario.getTitulos());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof GeneralFormSubmitFormImpl) {
				GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
		      	form.setAmbitos(formulario.getAmbitos());
		      	form.setDescripciones(formulario.getDescripciones());
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdentificadores(formulario.getIdentificadores());
		      	form.setIdiomas(formulario.getIdiomas());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setPalabrasClave(formulario.getPalabrasClave());
		      	form.setTitulos(formulario.getTitulos());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof ValidoGeneralVolverFormImpl) {
				ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
		      	form.setAmbitos(formulario.getAmbitos());
		      	form.setDescripciones(formulario.getDescripciones());
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdentificadores(formulario.getIdentificadores());
		      	form.setIdiomas(formulario.getIdiomas());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setPalabrasClave(formulario.getPalabrasClave());
		      	form.setTitulos(formulario.getTitulos());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
				NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
		      	form.setAmbitos(formulario.getAmbitos());
		      	form.setDescripciones(formulario.getDescripciones());
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdentificadores(formulario.getIdentificadores());
		      	form.setIdiomas(formulario.getIdiomas());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setPalabrasClave(formulario.getPalabrasClave());
		      	form.setTitulos(formulario.getTitulos());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			}

			int[] longitudTextosDesc = new int[form.getDescripciones().size()];
			for(int i= 0;i< form.getDescripciones().size();i++){
				longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
			}
			int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
			for(int i= 0;i< form.getPalabrasClave().size();i++){
				longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
			}
			int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
			for(int i= 0;i< form.getAmbitos().size();i++){
				longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
			}
		  	int longitudDescripciones=form.getDescripciones().size();
		  	int longitudPalabrasClave=form.getPalabrasClave().size();
		  	int longitudAmbitos=form.getAmbitos().size();
		  	int longitudIdentificadores=form.getIdentificadores().size();
		  	int longitudIdiomas=form.getIdiomas().size();
		  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
		  	
		  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
					longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
					longitudIdiomas,longitudTitulo);

	       //identificadores
	       form.setIdentificadoresAsArray(identificadores);
	       //titulo
	       form.setTitulosAsArray(titulos);        
	       //idioma
	       form.setIdiomasAsArray(idiomas);
	       //descripciones
	       form.setDescripcionesAsArray(descripciones);
	       form.setCaracteristicasAsArray(caracteristicas); 	
	       //palabras clave
	       form.setPalabrasClaveAsArray(palabrasClave); 
	       //ambitos
	       form.setAmbitosAsArray(ambitos);
      
	           
			Object[] aTitulos=form.getTitulosAsArray();
			TituloVO tituloVO = (TituloVO)aTitulos[0];
			LangStringVO[] textos = tituloVO.getTextos();
			int nuevoTamano = textos.length +1;
			LangStringVO[] newTextos = new LangStringVO[nuevoTamano];
			for(int i=0;i<textos.length;i++)
				newTextos[i]=textos[i];
			LangStringVO langTitulo=new LangStringVO();
			langTitulo.setIdioma("");
			langTitulo.setTexto("");
			newTextos[nuevoTamano-1]=langTitulo;
			
			tituloVO.setTextos(newTextos);
			aTitulos[0]=tituloVO;
			form.setTitulosAsArray(aTitulos);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
    		catch (IndexOutOfBoundsException ai) {
    			logger
    			.warn("Warning en catalogadorWeb, categoría General, metodo anadirTitulo" + ai);
    	    }catch (Exception e) {
    			logger
    			.error("Error en Servicio de catalogacionWeb, categoría General, método anadirTitulo " + e);
    			throw new Exception("general",e);
           }	
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirIdioma(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirIdiomaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirIdioma(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirIdiomaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
        	
               //añadimos un campo de idioma vacio
               Object[] aIdiomas=form.getIdiomasAsArray();
               int nuevoTamano = aIdiomas.length +1;
               Object[] newAIdiomas = new Object[nuevoTamano];
        	   IdiomaVO idiomaVO=new IdiomaVO();
        	   idiomaVO.setTexto("");
        	   for(int i = 0; i<aIdiomas.length;i++)
        		   newAIdiomas[i]=aIdiomas[i];
        	   newAIdiomas[nuevoTamano-1]= idiomaVO;
        	   
        	   form.setIdiomasAsArray(newAIdiomas);
        	   
    	}catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
       	   	throw new Exception("general",ad);
    	}
    	catch (IndexOutOfBoundsException ai) {
    		logger
    		.warn("Warning en catalogadorWeb, categoría General, metodo anadirIdioma" + ai);
    	}catch (Exception e) {
    		logger
    		.error("Error en Servicio de catalogacionWeb, categoría General, método anadirIdioma " + e);
    		throw new Exception("general",e);
    	}

     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirContenidoDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirContenidoDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 try{
         	Object valor = request.getSession().getAttribute("form");
            
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas);
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
           
           
    		 
           	String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
 	    	//se recogen todas las descripciones
 	    	DescripcionVO[] descArray = (DescripcionVO[]) form.getDescripcionesAsArray();
 	    	//recogo los textos de la descripcion indicada y le añado un nuevo texto
 	    	LangStringVO[] textos = descArray[posicionInt].getTextos();
 	    	LangStringVO[] nuevoTextos = new LangStringVO[textos.length+1];
 	    	for(int i = 0 ; i < textos.length;i++){
 	    		nuevoTextos[i]= textos[i];
 	    	}
 	    	LangStringVO nuevoTexto = new LangStringVO();
 	    	nuevoTexto.setIdioma("");
 	    	nuevoTexto.setTexto("");
 	    	nuevoTextos[nuevoTextos.length-1] = nuevoTexto;
 	    	descArray[posicionInt].setTextos(nuevoTextos);
 	    	form.setDescripcionesAsArray(descArray);
     	
         }catch (org.acegisecurity.AccessDeniedException ad) {
        	   	logger.error("Error de Acceso " + ad);
        	   	throw new Exception("general",ad);
//         }
//         catch (IndexOutOfBoundsException ai) {
//        	 logger
//        	 .warn("Warning en catalogadorWeb, categoría General, metodo anadirContenidoDescripcion" + ai);
         }catch (Exception e) {
        	 logger
        	 .error("Error en Servicio de catalogacionWeb, categoría General, método anadirContenidoDescripcion " + e);
        	 throw new Exception("general",e);
         }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{		
        	Object valor = request.getSession().getAttribute("form");
          
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());

    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
        	
               //añadimos un campo de idioma vacio
               Object[] aDescripciones=form.getDescripcionesAsArray();
               int nuevoTamano = aDescripciones.length +1;
               Object[] newADescripciones = new Object[nuevoTamano];
        	   DescripcionVO descripcionVO=new DescripcionVO();
        	   LangStringVO[] aLangString=new LangStringVO[1];
        	   LangStringVO langString = new LangStringVO();
        	   langString.setIdioma("");
        	   langString.setTexto("");
        	   aLangString[0]= langString;
        	   descripcionVO.setTextos(aLangString);
        	   for(int i = 0; i<aDescripciones.length;i++)
        		   newADescripciones[i]=aDescripciones[i];
        	   newADescripciones[nuevoTamano-1]= descripcionVO;
        	   
        	   form.setDescripcionesAsArray(newADescripciones);
        	   
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo anadirDescripcion" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método anadirDescripcion " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirContenidoPalabraClave(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoPalabraClaveForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirContenidoPalabraClave(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoPalabraClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
         	Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
   		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
    		
    	    String posicion = request.getAttribute("posicion").toString();
    	    int posicionInt = Integer.parseInt(posicion);//posicion de la PalabraClave a la que se quiere añadir contenido
	    	//se recogen todas las palabrasClave
	    	PalabraClaveVO[] aPalabrasClave = (PalabraClaveVO[]) form.getPalabrasClaveAsArray();
	    	//recogo los textos de la palabra clave indicada y le añado un nuevo texto
	    	LangStringVO[] textos = aPalabrasClave[posicionInt].getTextos();
	    	LangStringVO[] nuevoTextos = new LangStringVO[textos.length+1];
	    	for(int i = 0 ; i < textos.length;i++){
	    		nuevoTextos[i]= textos[i];
	    	}
	    	LangStringVO nuevoTexto = new LangStringVO();
	    	nuevoTexto.setIdioma("");
	    	nuevoTexto.setTexto("");
	    	nuevoTextos[nuevoTextos.length-1] = nuevoTexto;
	    	aPalabrasClave[posicionInt].setTextos(nuevoTextos);
	    	form.setPalabrasClaveAsArray(aPalabrasClave);
    	
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo anadirContenidoPalabrasClave" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método anadirContenidoPalabrasClave " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirPalabrasClave(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirPalabrasClaveForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirPalabrasClave(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirPalabrasClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
        	
               //añadimos un campo de idioma vacio
               Object[] aPalabrasClave=form.getPalabrasClaveAsArray();
               int nuevoTamano = aPalabrasClave.length +1;
               Object[] newAPalabrasClave = new Object[nuevoTamano];
               PalabraClaveVO palabraClaveVO=new PalabraClaveVO();
        	   LangStringVO[] aLangString=new LangStringVO[1];
        	   LangStringVO langString = new LangStringVO();
        	   langString.setIdioma("");
        	   langString.setTexto("");
        	   aLangString[0]= langString;
        	   palabraClaveVO.setTextos(aLangString);
        	   for(int i = 0; i<aPalabrasClave.length;i++)
        		   newAPalabrasClave[i]=aPalabrasClave[i];
        	   newAPalabrasClave[nuevoTamano-1]= palabraClaveVO;
        	   
        	   form.setPalabrasClaveAsArray(newAPalabrasClave);
        	   
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo anadirPalabrasClave" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método anadirPalabrasClave " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirContenidoAmbito(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoAmbitoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirContenidoAmbito(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoAmbitoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
         	Object valor = request.getSession().getAttribute("form");
            
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
        	
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
	    	//se recogen todas las descripciones
	    	AmbitoVO[] ambArray = (AmbitoVO[]) form.getAmbitosAsArray();
	    	//recogo los textos de la descripcion indicada y le añado un nuevo texto
	    	LangStringVO[] textos = ambArray[posicionInt].getTextos();
	    	LangStringVO[] nuevoTextos = new LangStringVO[textos.length+1];
	    	for(int i = 0 ; i < textos.length;i++){
	    		nuevoTextos[i]= textos[i];
	    	}
	    	LangStringVO nuevoTexto = new LangStringVO();
	    	nuevoTexto.setIdioma("");
	    	nuevoTexto.setTexto("");
	    	nuevoTextos[nuevoTextos.length-1] = nuevoTexto;
	    	ambArray[posicionInt].setTextos(nuevoTextos);
	    	form.setAmbitosAsArray(ambArray);
		
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo anadirContenidoAmbito" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método anadirContenidoAmbito " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#anadirAmbitos(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirAmbitosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirAmbitos(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirAmbitosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
        	
               //añadimos un campo de idioma vacio
               Object[] aAmbitos=form.getAmbitosAsArray();
               int nuevoTamano = aAmbitos.length +1;
               Object[] newAAmbitos = new Object[nuevoTamano];
               AmbitoVO ambitoVO=new AmbitoVO();
        	   LangStringVO[] aLangString=new LangStringVO[1];
        	   LangStringVO langString = new LangStringVO();
        	   langString.setIdioma("");
        	   langString.setTexto("");
        	   aLangString[0]= langString;
        	   ambitoVO.setTextos(aLangString);
        	   for(int i = 0; i<aAmbitos.length;i++)
        		   newAAmbitos[i]=aAmbitos[i];
        	   newAAmbitos[nuevoTamano-1]= ambitoVO;
        	   
        	   form.setAmbitosAsArray(newAAmbitos);
        	   
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo anadirAmbitos" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método anadirAmbitos " + e);
        	throw new Exception("general",e);
        }

     }
 


    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#guardarGeneral(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GuardarGeneralForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarGeneral(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GuardarGeneralForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
			boolean errorFaltaIdioma = false;
			boolean errorFaltaTexto = false;
			boolean errorFaltaUnTitulo = false;
			InputStream is = null;
			Properties prop = new Properties();
			CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			LomAvanzadoVO auxAvanzado=null;
			TituloVO tituloVO=null;
			SourceValueVO nivel=null;
			SourceValueVO estructuraSV=null;
			
			try{
			
				auxAvanzado=new LomAvanzadoVO();
				 
				AvGeneralVO general = new AvGeneralVO();
				auxAvanzado.setGeneral(general);
				
				is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
				prop.load(is);
				String source=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");;
				String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
				//String idiomaLdap="es";
				String usuario =LdapUserDetailsUtils.getUsuario();
				//String usuario="empaquetador";
				String identificador =request.getParameter("identificador");
				if(identificador==null){
				   identificador=catalogadorAvSession.getIdentificador();
				}
				String returnURL=request.getParameter("returnURL");
				if(returnURL==null)
					returnURL=catalogadorAvSession.getReturnURL();
				
				catalogadorAvSession.setIdioma(idiomaLdap);
				catalogadorAvSession.setIdentificador(identificador);
				catalogadorAvSession.setUsuario(usuario);
				//			 metemos en la sesion el parametro de vuelta al empaquetador
				catalogadorAvSession.setReturnURL(returnURL);
	    	
	    	
		    	Object valor = request.getSession().getAttribute("form");
	
		    	//Obtenemos la longitudes de los VOs, que pasamos a cambioFormulario para que se obtengan del request los cambios que hemos hecho
		    	//Pues en el form que nos viene como parametro no los guarda.
		    	int longitudDescripciones=0;
		    	int longitudPalabrasClave=0;
		    	int longitudAmbitos=0;
		    	int longitudIdentificadores=0;
		    	int longitudIdiomas=0;
		    	int longitudTitulo=0;
		    	int[] longitudTextosDesc = new int[0];
		    	int[] longitudTextosPCla = new int[0];
		    	int[] longitudTextosAmbitos = new int[0];
		    	Object[] desc=null;
		    	Object[] pCla=null;
		    	Object[] amb=null;
	
		    	if(valor instanceof GeneralFormImpl)
		    	{
		    		GeneralFormImpl valorGen = ((GeneralFormImpl)valor);
		    		desc = valorGen.getDescripcionesAsArray();
		    		pCla = valorGen.getPalabrasClaveAsArray();
		    		amb = valorGen.getAmbitosAsArray();
		    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
				  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
				  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
				  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
				  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;
		    	}else if(valor instanceof GeneralFormSubmitFormImpl)
		    	{
		    		GeneralFormSubmitFormImpl valorGen = ((GeneralFormSubmitFormImpl)valor);
		    		desc = valorGen.getDescripcionesAsArray();
		    		pCla = valorGen.getPalabrasClaveAsArray();
		    		amb = valorGen.getAmbitosAsArray();
		    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
				  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
				  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
				  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
				  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;
		    		
		    	}else if(valor instanceof ValidoGeneralVolverFormImpl){
		    		ValidoGeneralVolverFormImpl valorGen = ((ValidoGeneralVolverFormImpl)valor);
		    		desc = valorGen.getDescripcionesAsArray();
		    		pCla = valorGen.getPalabrasClaveAsArray();
		    		amb = valorGen.getAmbitosAsArray();
		    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
				  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
				  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
				  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
				  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;
		    		
		    	}else if(valor instanceof NoValidoGeneralVolverFormImpl){
		    		NoValidoGeneralVolverFormImpl valorGen = ((NoValidoGeneralVolverFormImpl)valor);
		    		desc = valorGen.getDescripcionesAsArray();
		    		pCla = valorGen.getPalabrasClaveAsArray();
		    		amb = valorGen.getAmbitosAsArray();
		    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
				  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
				  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
				  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
				  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;
				
		    	}
		    	
		    	longitudTextosDesc = new int[desc.length];
				for(int i= 0;i< desc.length;i++){
					longitudTextosDesc[i]=((DescripcionVO)(desc[i])).getTextos().length;
				}
				longitudTextosPCla= new int[pCla.length];
				for(int i= 0;i< pCla.length;i++){
					longitudTextosPCla[i]=((PalabraClaveVO)pCla[i]).getTextos().length;
				}
				longitudTextosAmbitos= new int[amb.length];
				for(int i= 0;i< amb.length;i++){
					longitudTextosAmbitos[i]=((AmbitoVO)amb[i]).getTextos().length;
				}
				longitudDescripciones=desc.length;
		    	
		    	
	
		    	
		    	//Recogemos los cambio del request mediante parametros
			  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
						longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
						longitudIdiomas,longitudTitulo);
		    	
		    	//Guardamos los cambios en el form obtenido de request.getSession.getAttribute("form") para que en caso de faltar
			  	//algun idioma o texto sin rellenar cargue el formulario con lo cambio y no perdamos todo lo modificado hasta ese
			  	//momento, si no lo hicieramos cargaría el formulario anterior. (Nivel de Agregacion y Estructura si mantienen los
			  	//cambios)
			  	
			  	//IDENTIFICADORES
			  	IdentificadorVO[] identificadoresAux = new IdentificadorVO[identificadores.length];
		    	for(int i=0;i<identificadores.length;i++){
		    		IdentificadorVO auxIdentificador = new IdentificadorVO();
		    		auxIdentificador.setCatalogo(identificadores[i].getCatalogo().trim());
		    		auxIdentificador.setEntrada(identificadores[i].getEntrada().trim());
		    		identificadoresAux[i] = auxIdentificador;
		    	}
			  	
			  	//IDIOMAS
			  	IdiomaVO[] 	idiomasAux = new IdiomaVO[idiomas.length];
		    	for(int i=0;i<idiomas.length;i++){
		    		IdiomaVO auxIdioma = new IdiomaVO();
		    		auxIdioma.setTexto(idiomas[i].getTexto());
		    		idiomasAux[i] = auxIdioma;
		    	}
			  	
		    	//TITULOS
		    	TituloVO[] 	titulosAux = new TituloVO[1];
		    	LangStringVO[] langTitAux = new LangStringVO[titulos[0].getTextos().length];
		    	for(int i=0;i<titulos[0].getTextos().length;i++){
		    		LangStringVO nuevoLang = new LangStringVO();
		    		nuevoLang.setIdioma(titulos[0].getTextos()[i].getIdioma());
		    		nuevoLang.setTexto(titulos[0].getTextos()[i].getTexto().trim());
		    		langTitAux[i] = nuevoLang;
		    	}
		    	TituloVO titAux= new TituloVO();
		    	titAux.setTextos(langTitAux);
		    	titulosAux[0]=titAux;
		    	
		    	//DESCRIPCIONES
		    	DescripcionVO[]	descripcionesAux = new DescripcionVO[descripciones.length];
		    	for(int i=0;i<descripciones.length;i++){
		    		DescripcionVO descripAux= new DescripcionVO();
		    		LangStringVO[] langDescrip = descripciones[i].getTextos();
		    		LangStringVO[] langDescripAux = new LangStringVO[langDescrip.length];
		    		for(int j=0;j<langDescrip.length;j++){
		    			LangStringVO nuevoLang = new LangStringVO();
		    			nuevoLang.setIdioma(langDescrip[j].getIdioma());
		    			nuevoLang.setTexto(langDescrip[j].getTexto().trim());
		    			langDescripAux[j] = nuevoLang;
		    		}
		    		descripAux.setTextos(langDescripAux);
		    		descripcionesAux[i]=descripAux;
		    	}
	
		    	//PALABRAS CLAVE
		    	PalabraClaveVO[] palabrasClaveAux = new PalabraClaveVO[palabrasClave.length];
		    	for(int i=0;i<palabrasClave.length;i++){
		    		PalabraClaveVO pClaveAux= new PalabraClaveVO();
		    		LangStringVO[] langPClave= palabrasClave[i].getTextos();
		    		LangStringVO[] langPClaveAux = new LangStringVO[langPClave.length];
		    		for(int j=0;j<langPClave.length;j++){
		    			LangStringVO nuevoLang = new LangStringVO();
		    			nuevoLang.setIdioma(langPClave[j].getIdioma());
		    			nuevoLang.setTexto(langPClave[j].getTexto().trim());
		    			langPClaveAux[j] = nuevoLang;
		    		}
		    		pClaveAux.setTextos(langPClaveAux);
		    		palabrasClaveAux[i]=pClaveAux;
		    	}
		    	
		    	//AMBITOS
		    	AmbitoVO[] ambitosAux = new AmbitoVO[ambitos.length];
		    	for(int i=0;i<ambitos.length;i++){
		    		AmbitoVO ambAux= new AmbitoVO();
		    		LangStringVO[] langAmbitos= ambitos[i].getTextos();
		    		LangStringVO[] langAmbitosAux = new LangStringVO[langAmbitos.length];
		    		for(int j=0;j<langAmbitos.length;j++){
		    			LangStringVO nuevoLang = new LangStringVO();
		    			nuevoLang.setIdioma(langAmbitos[j].getIdioma());
		    			nuevoLang.setTexto(langAmbitos[j].getTexto().trim());
		    			langAmbitosAux[j] = nuevoLang;
		    		}
		    		ambAux.setTextos(langAmbitosAux);
		    		ambitosAux[i]=ambAux;
		    	}
		    	
		    	if (valor instanceof GeneralFormImpl) {
		    		((GeneralFormImpl)valor).setIdiomasAsArray(idiomasAux);
		    		((GeneralFormImpl)valor).setTitulosAsArray(titulosAux);
		    		((GeneralFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
		    		((GeneralFormImpl)valor).setPalabrasClaveAsArray(palabrasClaveAux);
		    		((GeneralFormImpl)valor).setAmbitosAsArray(ambitosAux);
				}
		    	else if(valor instanceof GeneralFormSubmitFormImpl){
		    		((GeneralFormSubmitFormImpl)valor).setIdiomasAsArray(idiomasAux);
			      	((GeneralFormSubmitFormImpl)valor).setTitulosAsArray(titulosAux);
			      	((GeneralFormSubmitFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
					((GeneralFormSubmitFormImpl)valor).setPalabrasClaveAsArray(palabrasClaveAux);
		    		((GeneralFormSubmitFormImpl)valor).setAmbitosAsArray(ambitosAux);
		      	}else if (valor instanceof ValidoGeneralVolverFormImpl) {
		    		((ValidoGeneralVolverFormImpl)valor).setIdiomasAsArray(idiomasAux);
		    		((ValidoGeneralVolverFormImpl)valor).setTitulosAsArray(titulosAux);
		    		((ValidoGeneralVolverFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
		    		((ValidoGeneralVolverFormImpl)valor).setPalabrasClaveAsArray(palabrasClaveAux);
		    		((ValidoGeneralVolverFormImpl)valor).setAmbitosAsArray(ambitosAux);
		      	}else if (valor instanceof NoValidoGeneralVolverFormImpl) {
		    		((NoValidoGeneralVolverFormImpl)valor).setIdiomasAsArray(idiomasAux);
		    		((NoValidoGeneralVolverFormImpl)valor).setTitulosAsArray(titulosAux);
		    		((NoValidoGeneralVolverFormImpl)valor).setDescripcionesAsArray(descripcionesAux);
		    		((NoValidoGeneralVolverFormImpl)valor).setPalabrasClaveAsArray(palabrasClaveAux);
		    		((NoValidoGeneralVolverFormImpl)valor).setAmbitosAsArray(ambitosAux);
				}
	
		
			  	estructura = form.getEstructura();
				nivelAgregacion = form.getNivelAgregacion();
			  	
				//Obtnemos los terminos de los ids seleccionados en todos los combos, y los guarda en los VO 
				dameTerminoId();         
	    		 
				//Comprobamos si los campos ha sido rellenados adecuadamente
				
				 //IDENTIFICADORES		 
				if (identificadores!= null && identificadores.length != 0){
					ArrayList lista=new ArrayList();
					for(int j=0;j<identificadores.length;j++){
						IdentificadorVO ident=(IdentificadorVO) identificadores[j];
							 
						if(ident !=null){
							IdentificadorVO identAux=new IdentificadorVO();
							String catalogo=ident.getCatalogo().trim();
							String entrada=ident.getEntrada().trim();
							if(((catalogo!=null)&&(!catalogo.equals(""))) || ((entrada!=null)&&(!entrada.equals("")))){
								identAux.setCatalogo(catalogo);
								identAux.setEntrada(entrada);
								lista.add(identAux);
							}
						}						 						 
					}
					identificadores=(IdentificadorVO[])lista.toArray(new IdentificadorVO[lista.size()]);
					if(identificadores.length == 0)
						identificadores = null; 
				}
				else 
					identificadores = null;
				 
				auxAvanzado.getGeneral().setIdentificadores(identificadores);
				  
				//TITULOS
				tituloVO=new TituloVO();
				if (titulos!= null && titulos.length != 0){
					TituloVO titulo = (TituloVO) titulos[0];
					LangStringVO[] textos=titulo.getTextos();
					ArrayList lista=new ArrayList();
					for(int j=0;j<textos.length;j++){
						LangStringVO lTit=(LangStringVO) textos[j];
							 
						if(lTit !=null){
							LangStringVO lLang=new LangStringVO();
							String idioma=lTit.getIdioma();
							String texto=lTit.getTexto().trim();
							
							if(((idioma!=null)&&(!idioma.equals(""))) && ((texto!=null)&&(!texto.equals("")))){
								lLang.setIdioma(idioma);
								lLang.setTexto(texto);
								lista.add(lLang);
							}
							else{
								if (idioma.equals("") && !texto.equals("") )
									errorFaltaIdioma = true;
								if (!idioma.equals("") && texto.equals(""))
									errorFaltaTexto = true;
							}
						}
						
					}
					LangStringVO[] lLangS=(LangStringVO[])lista.toArray(new LangStringVO[lista.size()]);
					if(lLangS.length == 0){
						tituloVO = null;
						errorFaltaUnTitulo =true;
					}
					else
						tituloVO.setTextos(lLangS); 
				}
				else{ 
					tituloVO = null;
					errorFaltaUnTitulo =true;	
				}
				 
				auxAvanzado.getGeneral().setTitulo(tituloVO);
				 
				//IDIOMAS
				ArrayList lTextos=new ArrayList();
				//if(!((idiomas.length == 1) && (idiomas[0].getTexto().equals("")))){
				if(idiomas != null && !((idiomas.length == 1) && (idiomas[0].getTexto().equals("")))){
					for(int i=0;i<idiomas.length;i++){
						if(idiomas[i]!=null){
							IdiomaVO idiomaVO=new IdiomaVO();
							IdiomaVO idiVO=(IdiomaVO)(idiomas[i]);
							if((idiVO.getTexto()!=null)&&(!idiVO.getTexto().equals(""))){
								idiomaVO.setTexto(idiVO.getTexto());
								lTextos.add(idiomaVO);
							}
						}
						else
							idiomas =null;
					}
					idiomas=(IdiomaVO[])lTextos.toArray(new IdiomaVO[lTextos.size()]);
					if(idiomas.length == 0)
						idiomas = null;
				}
				else{
					idiomas=null;
				}
				
				auxAvanzado.getGeneral().setIdiomas(idiomas);
				 
				//DESCRIPCIONES
				ArrayList listaDesc=new ArrayList();
				if(descripciones!=null && descripciones.length != 0){
					LangStringVO[] textos = descripciones[0].getTextos();
					if(descripciones.length == 1 && textos.length == 1 & textos[0].getIdioma().equals("") 
							&& textos[0].getTexto().equals("")){
						descripciones = null;
					}
					else{
						for(int i=0;i<descripciones.length;i++){
							if(descripciones[i]!=null){
								ArrayList listDesc=new ArrayList();
								DescripcionVO lDesc=(DescripcionVO)(descripciones[i]);
								DescripcionVO lDescripciones=new DescripcionVO();
								for(int j=0;j<lDesc.getTextos().length;j++){
									LangStringVO lang=lDesc.getTextos()[j];
									LangStringVO lLang=new LangStringVO();
									String idioma=lang.getIdioma();
									String texto=lang.getTexto().trim();
									if(((idioma!=null)&&(!idioma.equals(""))) && ((texto!=null)&&(!texto.equals("")))){
										lLang.setIdioma(idioma);
										lLang.setTexto(texto);
										listDesc.add(lLang);
									}
									else{
										if (idioma.equals("") && !texto.equals("") )
											errorFaltaIdioma = true;
										if (!idioma.equals("") && texto.equals("") )
											errorFaltaTexto = true;
									} 
								}
								if (listDesc.size() != 0){
									LangStringVO[] langs=(LangStringVO[])listDesc.toArray(new LangStringVO[listDesc.size()]); 
									lDescripciones.setTextos(langs);   
									listaDesc.add(lDescripciones);
								}
							}
						}
						if(listaDesc.size()== 0)
							descripciones = null;
						else
							descripciones=(DescripcionVO[])listaDesc.toArray(new DescripcionVO[listaDesc.size()]);
					}
				}
				else{
					descripciones =null;
				}
				auxAvanzado.getGeneral().setDescripciones(descripciones);
				
				//PALABRAS CLAVE
				ArrayList listaPalabras=null;
				if(palabrasClave!=null && palabrasClave.length !=0){
					LangStringVO[] textos = palabrasClave[0].getTextos();
					if (palabrasClave.length== 1 && textos.length == 1 & textos[0].getIdioma().equals("") 
							&& textos[0].getTexto().equals("")){
						palabrasClave= null;		
					}
					else{
						listaPalabras=new ArrayList();
						for(int i=0;i<palabrasClave.length;i++){
							if(palabrasClave[i]!=null){
								ArrayList listPalabras=new ArrayList();
								PalabraClaveVO lPalabras=(PalabraClaveVO)(palabrasClave[i]);
								PalabraClaveVO lPalabrasClave=new PalabraClaveVO();
								for(int j=0;j<lPalabras.getTextos().length;j++){
									LangStringVO lang=(LangStringVO)(lPalabras.getTextos()[j]);
									LangStringVO lLang=new LangStringVO();
									String idioma=lang.getIdioma();
									String texto=lang.getTexto().trim();
									if(((idioma!=null)&&(!idioma.equals("")))&&((texto!=null)&&(!texto.equals("")))){
										 lLang.setIdioma(idioma);
										 lLang.setTexto(texto);
										 listPalabras.add(lLang);
									}
									else{
										if (idioma.equals("") && !texto.equals("") )
											errorFaltaIdioma = true;
										if (!idioma.equals("") && texto.equals("") )
											errorFaltaTexto = true;
										
									}
								}
								if (listPalabras.size() != 0){
									LangStringVO[] langs=(LangStringVO[])listPalabras.toArray(new LangStringVO[listPalabras.size()]); 
									lPalabrasClave.setTextos(langs);  
									listaPalabras.add(lPalabrasClave);
								}
							}
						}
						if (listaPalabras.size() == 0)
							palabrasClave = null;
						else
							palabrasClave=(PalabraClaveVO[])listaPalabras.toArray(new PalabraClaveVO[listaPalabras.size()]);
					}
				}
				else
					palabrasClave =null;
				
				auxAvanzado.getGeneral().setPalabrasClave(palabrasClave);
				
				//AMBITOS
				ArrayList listaAmbitos=null;
				if(ambitos!=null && ambitos.length !=0){
					LangStringVO[] textos = ambitos[0].getTextos();
					if (ambitos.length == 1 && textos.length == 1 & textos[0].getIdioma().equals("")
							&&textos[0].getTexto().equals("")){
						ambitos=null;
					}
					else{
						listaAmbitos=new ArrayList();
						for(int i=0;i<ambitos.length;i++){
							if(ambitos[i]!=null){
								ArrayList listAmbito=new ArrayList();
								AmbitoVO lAmbito=(AmbitoVO)(ambitos[i]);
								AmbitoVO lAmb=new AmbitoVO();
								for(int j=0;j<lAmbito.getTextos().length;j++){
									LangStringVO lang=(LangStringVO)(lAmbito.getTextos()[j]);
									LangStringVO lLang=new LangStringVO();
									String idioma=lang.getIdioma();
									String texto=lang.getTexto().trim();
									if(((idioma!=null)&&(!idioma.equals("")))&&((texto!=null)&&(!texto.equals("")))){
										 lLang.setIdioma(idioma);
										 lLang.setTexto(texto);
										 listAmbito.add(lLang);
									}
									else{
										if (idioma.equals("") && !texto.equals("") )
											errorFaltaIdioma = true;
										if (!idioma.equals("") && texto.equals("") )
											errorFaltaTexto = true;
										
									}
								}
								if (listAmbito.size() != 0){
									LangStringVO[] langs=(LangStringVO[])listAmbito.toArray(new LangStringVO[listAmbito.size()]); 
									lAmb.setTextos(langs);  
									listaAmbitos.add(lAmb);
								}
							}
						}
						if (listaAmbitos.size() == 0)
							ambitos = null;
						else
							ambitos=(AmbitoVO[])listaAmbitos.toArray(new AmbitoVO[listaAmbitos.size()]);
					}
				}
				else 
					ambitos = null;
				
				auxAvanzado.getGeneral().setAmbitos(ambitos);
				
				//ESTRUCTURA
				estructuraSV=new SourceValueVO();
				if((estructura!=null)&&(!estructura.equals(""))){
					estructuraSV.setValor(estructura);
					estructuraSV.setSource(source);
				}
				else{
					estructuraSV = null;
				}
				auxAvanzado.getGeneral().setEstructura(estructuraSV);
				
				//NIVEL AGREGACION
				nivel=new SourceValueVO();
				if((nivelAgregacion!=null)&&(!nivelAgregacion.equals(""))){
					nivel.setSource(source);
					nivel.setValor(nivelAgregacion);
				}
				else{
					nivel = null;
				}
				auxAvanzado.getGeneral().setNivelAgregacion(nivel);
				
			}catch (org.acegisecurity.AccessDeniedException ad) {
	    	   	logger.error("Error de Acceso " + ad);
	    	   	throw new Exception("general",ad);
	        }catch (Exception e) {
				logger
				.error("Error en Servicio de catalogacionWeb, categoría General, método guardarGeneral " + e);
				throw new Exception("general",e);
	        }
	        
			if(!errorFaltaIdioma && !errorFaltaTexto && !errorFaltaUnTitulo){			
				try {
					//			Cargamos el objeto de sesion
					if(catalogadorAvSession.getMDSesion()==null){
						catalogadorAvSession.setMDSesion(auxAvanzado);
						
					}else{
						if (identificadores == null && idiomas == null && tituloVO == null && descripciones == null & palabrasClave == null
								&& ambitos == null && nivel == null && estructuraSV == null)
							catalogadorAvSession.getMDSesion().setGeneral(null);
						else
							catalogadorAvSession.getMDSesion().setGeneral(auxAvanzado.getGeneral());
				       
					}
				}catch (Exception e) {
					logger
					.error("Error en Servicio de catalogacionWeb, categoría General, método guardarGeneral " + e);
					throw new Exception("general",e);
		        }

			}else{
				if (errorFaltaIdioma && errorFaltaTexto)
					throw new ValidatorException("{general.error.idioma_texto}");
				else if (!errorFaltaIdioma && errorFaltaTexto)
					throw new ValidatorException("{general.error.texto}");
				else if (errorFaltaIdioma && !errorFaltaTexto)
					throw new ValidatorException("{general.error.idioma}");
				else if(errorFaltaUnTitulo)
					throw new ValidatorException("{general.error.falta_titulo}");
	
			}

     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarIdentificador(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarIdentificadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarIdentificador(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarIdentificadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
          
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
            
            //posicion del identificador que se quiere eliminar   
        	String posicion = request.getAttribute("posicion").toString();
           int posicionInt = Integer.parseInt(posicion);
    	   IdentificadorVO[] aIdentificadores=(IdentificadorVO[]) form.getIdentificadoresAsArray();
    	   IdentificadorVO[] nuevoIdentificadores = new IdentificadorVO[identificadores.length -1];
	     	//añado al nuevo array de identificadores todos los identificadores menos el que 
	     	//queremos eliminar
	     	for (int i = 0; i<nuevoIdentificadores.length;i++){
	     		if (i < posicionInt)
	     			nuevoIdentificadores[i] = aIdentificadores[i];
	     		else
	     			nuevoIdentificadores[i] = aIdentificadores[i+1]; 
	     	}
    	   
    	   	form.setIdentificadoresAsArray(nuevoIdentificadores);
        	
        	
        	
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarIdentificador" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarIdentificador " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarTitulo(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarTituloForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarTitulo(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarTituloForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{

        	Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
               
               //posicion del identificador que se quiere eliminar   
           	String posicion = request.getAttribute("posicion").toString();
              int posicionInt = Integer.parseInt(posicion);
        	TituloVO[] aTitulos=(TituloVO[]) form.getTitulosAsArray();
        	LangStringVO[] langString = aTitulos[0].getTextos();
        	LangStringVO[] nuevolangString = new LangStringVO[langString.length -1];
  	     	//añado al nuevo array de titulos todos los titulos menos el que 
  	     	//queremos eliminar
  	     	for (int i = 0; i<nuevolangString.length;i++){
  	     		if (i < posicionInt)
  	     			nuevolangString[i] = langString[i];
  	     		else
  	     			nuevolangString[i] = langString[i+1]; 
  	     	}
  	     	TituloVO tituloVO = new TituloVO();
  	     	tituloVO.setTextos(nuevolangString);
  	     	aTitulos[0]= tituloVO;
  	     	form.setTitulosAsArray(aTitulos);
        	   
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarTitulo" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarTitulo " + e);
        	throw new Exception("general",e);
        }
 		
	
     }


    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarIdioma(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarIdiomaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarIdioma(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarIdiomaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
    		
            //posicion del identificador que se quiere eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
        	
            IdiomaVO[] aIdiomas=(IdiomaVO[]) form.getIdiomasAsArray();
        	IdiomaVO[] nuevoIdiomas = new IdiomaVO[aIdiomas.length -1];
  	     	//añado al nuevo array de identificadores todos los identificadores menos el que 
  	     	//queremos eliminar
  	     	for (int i = 0; i<nuevoIdiomas.length;i++){
  	     		if (i < posicionInt)
  	     			nuevoIdiomas[i] = aIdiomas[i];
  	     		else
  	     			nuevoIdiomas[i] = aIdiomas[i+1]; 
  	     	}
        	   
  	     	form.setIdiomasAsArray(nuevoIdiomas);
        	   
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarIdioma " + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarIdioma " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarContenidoDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarContenidoDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		Object valor = request.getSession().getAttribute("form");
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
    		
            //posicion de contenido a eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
    		
    		//posicion de la descripcion de la que se quiere eliminar parte de su contenido
            String posicionExt = request.getAttribute("posicionExterior").toString();
            int posicionExtInt = Integer.parseInt(posicionExt);
	    	
	    	DescripcionVO[] aDescripciones = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	LangStringVO[] contenido = descripciones[posicionExtInt].getTextos();
	    	LangStringVO[] nuevoContenido = new LangStringVO[contenido.length -1];
	    	
	    	Caracteristica[][] aCaracteristicas = (Caracteristica[][]) form.getCaracteristicasAsArray();
	    	Caracteristica[] contCaracteristicas= caracteristicas[posicionExtInt];
	    	Caracteristica[] nuevoContCaract= new Caracteristica[contenido.length -1] ;
	    	
	    	//añado al nuevo array de contenidos todos los contenidos menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoContenido.length;i++){
	    		if (i < posicionInt)
	    		{
	    			nuevoContenido[i] = contenido[i];
	    			nuevoContCaract[i]= contCaracteristicas[i];
	    		}
	    		else
	    		{
	    			nuevoContenido[i] = contenido[i+1];
	    			nuevoContCaract[i]= contCaracteristicas[i+1];
	    		}
	    	}
	    	
	    	if(nuevoContenido.length==0)
	    	{
	    		nuevoContenido = new LangStringVO[1];
	    		LangStringVO vacio= new LangStringVO();
	    		vacio.setIdioma("");
	    		vacio.setTexto("");
	    		nuevoContenido[0]= vacio;
	    		
	    		nuevoContCaract= new Caracteristica[1] ;
	    		Caracteristica vacia= Caracteristica.getInstance(null, null);
	    		nuevoContCaract[0]= vacia;
	    	}
	    	
	    	
	    	
	    	aDescripciones[posicionExtInt].setTextos(nuevoContenido);
	    	form.setDescripcionesAsArray(aDescripciones);
	    	
	    	aCaracteristicas[posicionExtInt]= nuevoContCaract;
	    	form.setCaracteristicasAsArray(aCaracteristicas);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarContenidoDescripcion" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarContenidoDescripcion " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarDescripcion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarDescripcion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
			Object valor = request.getSession().getAttribute("form");
			            
			if (valor instanceof GeneralFormImpl) {
				GeneralFormImpl formulario=(GeneralFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof GeneralFormSubmitFormImpl) {
				GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof ValidoGeneralVolverFormImpl) {
				ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
				NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
            //posicion del identificador que se quiere eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
	    	DescripcionVO[] aDescripciones = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	DescripcionVO[] nuevoDescripciones = new DescripcionVO[aDescripciones.length -1];
	    	
	    	Caracteristica[][] aCaracteristicas= (Caracteristica[][]) form.getCaracteristicasAsArray();
	    	Caracteristica[][] nuevoCaracteristicas= new Caracteristica[aDescripciones.length -1][];
	    	//añado al nuevo array de descripciones todas las descripciones menos la que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoDescripciones.length;i++){
	    		if (i < posicionInt)
	    		{
	    			nuevoDescripciones[i] = aDescripciones[i];
	    			nuevoCaracteristicas[i]= aCaracteristicas[i];
	    		}
	    		else
	    		{
	    			nuevoDescripciones[i] = aDescripciones[i+1];
	    			nuevoCaracteristicas[i]= aCaracteristicas[i+1];
	    		}
	    	}
	    	form.setDescripcionesAsArray(nuevoDescripciones);
	    	form.setCaracteristicasAsArray(nuevoCaracteristicas);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarDescripcion " + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarDescripcion " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarContenidoPalabraClave(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoPalabraClaveForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarContenidoPalabraClave(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoPalabraClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
			Object valor = request.getSession().getAttribute("form");
			            
			if (valor instanceof GeneralFormImpl) {
				GeneralFormImpl formulario=(GeneralFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof GeneralFormSubmitFormImpl) {
				GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof ValidoGeneralVolverFormImpl) {
				ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
				NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
			  	form.setAmbitos(formulario.getAmbitos());
			  	form.setDescripciones(formulario.getDescripciones());
			  	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
			  	form.setEstructuraValueList(formulario.getEstructuraValueList());
			  	form.setIdentificadores(formulario.getIdentificadores());
			  	form.setIdiomas(formulario.getIdiomas());
			  	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
			  	form.setIdiomasValueList(formulario.getIdiomasValueList());
			  	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
			  	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
			  	form.setPalabrasClave(formulario.getPalabrasClave());
			  	form.setTitulos(formulario.getTitulos());
			  	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
			  	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
    		
            //posicion de contenido a eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
    		
//          posicion de la palabraClave de la que se quiere eliminar parte de su contenido
            String posicionExt = request.getAttribute("posicionExterior").toString();
            int posicionExtInt = Integer.parseInt(posicionExt);
    		
	    	PalabraClaveVO[] aPalabrasClave = (PalabraClaveVO[]) form.getPalabrasClaveAsArray();
	    	LangStringVO[] contenido = aPalabrasClave[posicionExtInt].getTextos();
	    	LangStringVO[] nuevoContenido = new LangStringVO[contenido.length -1];
	    	//añado al nuevo array de contenidos todos los contenidos menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoContenido.length;i++){
	    		if (i < posicionInt)
	    			nuevoContenido[i] = contenido[i];
	    		else
	    			nuevoContenido[i] = contenido[i+1]; 
	    	}
	    	aPalabrasClave[posicionExtInt].setTextos(nuevoContenido);
	    	form.setPalabrasClaveAsArray(aPalabrasClave);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarContenidoPalabraClave " + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarContenidoPalabraClave " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarPalabrasClave(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarPalabrasClaveForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarPalabrasClave(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarPalabrasClaveForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		Object valor = request.getSession().getAttribute("form");
            
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
            //posicion del identificador que se quiere eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
	    	PalabraClaveVO[] aPalabrasClave = (PalabraClaveVO[]) form.getPalabrasClaveAsArray();
	    	PalabraClaveVO[] nuevoPalabrasClave = new PalabraClaveVO[aPalabrasClave.length -1];
	    	//añado al nuevo array de PalabrasClave todas las palabrasClave menos la que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoPalabrasClave.length;i++){
	    		if (i < posicionInt)
	    			nuevoPalabrasClave[i] = aPalabrasClave[i];
	    		else
	    			nuevoPalabrasClave[i] = aPalabrasClave[i+1]; 
	    	}
	    	form.setPalabrasClaveAsArray(nuevoPalabrasClave);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarPalabrasClave " + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarPalabrasClave " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarContenidoAmbito(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoAmbitoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarContenidoAmbito(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoAmbitoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		Object valor = request.getSession().getAttribute("form");
            
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
    		
            //posicion de contenido a eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
    		
//          posicion del ambito del que se quiere eliminar parte de su contenido
            String posicionExt = request.getAttribute("posicionExterior").toString();
            int posicionExtInt = Integer.parseInt(posicionExt);
    		
	    	AmbitoVO[] aAmbitos = (AmbitoVO[]) form.getAmbitosAsArray();
	    	LangStringVO[] contenido = aAmbitos[posicionExtInt].getTextos();
	    	LangStringVO[] nuevoContenido = new LangStringVO[contenido.length -1];
	    	//añado al nuevo array de contenidos todas las contenidos menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoContenido.length;i++){
	    		if (i < posicionInt)
	    			nuevoContenido[i] = contenido[i];
	    		else
	    			nuevoContenido[i] = contenido[i+1]; 
	    	}
	    	aAmbitos[posicionExtInt].setTextos(nuevoContenido);
	    	form.setAmbitosAsArray(aAmbitos);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarContenidoAmbito" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarContenidoAmbito " + e);
        	throw new Exception("general",e);
        }
     }







    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#eliminarAmbitos(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarAmbitosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarAmbitos(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarAmbitosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		
    	try{
    		Object valor = request.getSession().getAttribute("form");
            
    		if (valor instanceof GeneralFormImpl) {
    			GeneralFormImpl formulario=(GeneralFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof GeneralFormSubmitFormImpl) {
    			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
    			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
    			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
    	      	form.setAmbitos(formulario.getAmbitos());
    	      	form.setDescripciones(formulario.getDescripciones());
    	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
    	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
    	      	form.setIdentificadores(formulario.getIdentificadores());
    	      	form.setIdiomas(formulario.getIdiomas());
    	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
    	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
    	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
    	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
    	      	form.setPalabrasClave(formulario.getPalabrasClave());
    	      	form.setTitulos(formulario.getTitulos());
    	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
    	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
    	      	
    	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
    	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
    	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
    	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
    	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
    	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
    	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
    	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
    	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
    	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
    	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
    	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
    	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
    	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
    	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
    	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
    		}

          	
    		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
    		for(int i= 0;i< form.getDescripciones().size();i++){
    			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
    		for(int i= 0;i< form.getPalabrasClave().size();i++){
    			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
    		}
    		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
    		for(int i= 0;i< form.getAmbitos().size();i++){
    			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
    		}
    	  	int longitudDescripciones=form.getDescripciones().size();
    	  	int longitudPalabrasClave=form.getPalabrasClave().size();
    	  	int longitudAmbitos=form.getAmbitos().size();
    	  	int longitudIdentificadores=form.getIdentificadores().size();
    	  	int longitudIdiomas=form.getIdiomas().size();
    	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
    	  	
    	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
    				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
    				longitudIdiomas,longitudTitulo);

           //identificadores
           form.setIdentificadoresAsArray(identificadores);
           //titulo
           form.setTitulosAsArray(titulos);        
           //idioma
           form.setIdiomasAsArray(idiomas);
           //descripciones
           form.setDescripcionesAsArray(descripciones);
           form.setCaracteristicasAsArray(caracteristicas); 	
           //palabras clave
           form.setPalabrasClaveAsArray(palabrasClave); 
           //ambitos
           form.setAmbitosAsArray(ambitos);
    		
            //posicion del identificador que se quiere eliminar   
            String posicion = request.getAttribute("posicion").toString();
            int posicionInt = Integer.parseInt(posicion);
	    	
            AmbitoVO[] aAmbitos = (AmbitoVO[]) form.getAmbitosAsArray();
	    	AmbitoVO[] nuevoAmbitos = new AmbitoVO[aAmbitos.length -1];
	    	//añado al nuevo array de ambitos todos los ambitos menos el que 
	    	//queremos eliminar
	    	for (int i = 0; i<nuevoAmbitos.length;i++){
	    		if (i < posicionInt)
	    			nuevoAmbitos[i] = aAmbitos[i];
	    		else
	    			nuevoAmbitos[i] = aAmbitos[i+1]; 
	    	}
	    	form.setAmbitosAsArray(nuevoAmbitos);
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
           }
        catch (IndexOutOfBoundsException ai) {
        	logger
        	.warn("Warning en catalogadorWeb, categoría General, metodo eliminarAmbitos" + ai);
        }catch (Exception e) {
        	logger
        	.error("Error en Servicio de catalogacionWeb, categoría General, método eliminarAmbitos " + e);
        	throw new Exception("general",e);
        }
     }



	public void cargarDatosGeneral(
			ActionMapping mapping, 
			CargarDatosGeneralForm form,
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		InputStream is = null;
    	Properties prop = new Properties();
		boolean bandera=false;
		
		String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
        try{
        	int longVocabulario = 0;
        	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
        	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
			prop.load(is);
			String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

			//comprobamos que el objeto de sesion no se ha null, si es null nos creamos uno	
			if (catalogadorAvSession.getMDSesion() == null){
				LomAvanzadoVO mdSession = new LomAvanzadoVO();
				catalogadorAvSession.setMDSesion(mdSession);
			}	
			//comprobamos que general no se ha null, si es null nos creamos uno	
			boolean generalEsNull = false;
			if (catalogadorAvSession.getMDSesion().getGeneral() == null){
				AvGeneralVO general = new AvGeneralVO();
				catalogadorAvSession.getMDSesion().setGeneral(general);
				generalEsNull=true;
			}
			
			
			//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
			String[] l_id = { prop.getProperty("idioma"),prop.getProperty("estructura"),prop.getProperty("nivelDeAgregacion"),prop.getProperty("idiomaDestinatario"),prop.getProperty("caracteristicas.color"),prop.getProperty("caracteristicas.bandaSonora"),prop.getProperty("caracteristicas.formato"),prop.getProperty("caracteristicas.tipoPlano"),prop.getProperty("caracteristicas.luz"),prop.getProperty("caracteristicas.estructuraFormal"),prop.getProperty("caracteristicas.angulacion"),prop.getProperty("caracteristicas.dimension")};
			VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
			//guardo una lista de los idiomas con sus correspondientes codigos
			listaIdiomas = new HashMap();
			for (int i = 0; i < vocabulario[3].getTerminos().length; i++) {
				listaIdiomas.put(vocabulario[3].getTerminos()[i].getIdTermino(), vocabulario[3].getTerminos()[i].getNomTermino());
			}
			
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);

			longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
			TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
			ArrayList terminoypadrear=new ArrayList();
			
			Collection id = new ArrayList();
			Collection idDest = new ArrayList();
			
			UtilidadesOrdenarCombos uoc = new UtilidadesOrdenarCombos();
			Iterator itDest=null;
			TerminoVO[] tod=null;
			
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");

				switch (x) {
				case 0:
					
					id.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
					
					for (int li=0; li<terminos.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminos[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra="";
						if(!textoIdioma.equals("x-none")){
							idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						}else{
							idiomasTra=datosResources.getString("x-none");
						}
						idAux.setNomTermino(idiomasTra);
					}
					
					TerminoVO[] terminosOrd = uoc.ordenarTerminosVO(terminos, idiomaLdap);
					itDest= Arrays.asList(terminosOrd).iterator();
					while (itDest.hasNext()) {
						id.add(itDest.next());
					}

					if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getIdiomas() !=null)
							&& (catalogadorAvSession.getMDSesion().getGeneral().getIdiomas().length>0)) {
						IdiomaVO[] idiomasVO =catalogadorAvSession.getMDSesion().getGeneral().getIdiomas();
						for(int j=0;j<idiomasVO.length;j++){
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario(l_id[x]);
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino(idiomasVO[j].getTexto());
							terminoypadrear.add(terminoypadreVO);
						}//terminoYPadreVO rellenado con los idiomas desde el lom avanzado
					}
					else {
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario(l_id[x]);
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino("");
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 1:
					Collection tEstructura = new ArrayList();
					tEstructura.add(terminoVO);
//					Collection tEstructura2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
//					Iterator cont = tEstructura2.iterator();
					
					itDest = Arrays.asList(vocabularioOrdenado[x].getTerminos()).iterator();
					while (itDest.hasNext()) {
						tEstructura.add(itDest.next());
					}
					form.setEstructuraBackingList(tEstructura, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getEstructura() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getGeneral().getEstructura().getValor());//terminoYPadre rellenado con estructura desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con estructura desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 2:
					Collection tNivelDeAgregacion = new ArrayList();
					tNivelDeAgregacion.add(terminoVO);

					itDest = Arrays.asList(vocabularioOrdenado[x].getTerminos()).iterator();
					while (itDest.hasNext()) {
						tNivelDeAgregacion.add(itDest.next());
					}
					form.setNivelAgregacionBackingList(tNivelDeAgregacion, "idTermino", "nomTermino");
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getNivelAgregacion() !=null)) {
						terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getGeneral().getNivelAgregacion().getValor());//terminoYPadre rellenado con nivel de agregacion desde el lom avanzado
						terminoypadrear.add(terminoypadreVO);
					} else {
						terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con nivel de agregacion desde el formulario
						terminoypadrear.add(terminoypadreVO);
					}
					
					break;
				case 3:
					idDest.add(terminoVO);
//					modificamos las cadenas de idiomas
					TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminosDest.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminosDest[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
						idAux.setNomTermino(idiomasTra);
					}

//					UtilidadesOrdenarCombos terminosOrdDest2 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrdDest = uoc.ordenarTerminosVO(terminosDest, idiomaLdap);
					
					itDest = Arrays.asList(terminosOrdDest).iterator();
					while (itDest.hasNext()) {
						idDest.add(itDest.next());
					}
					form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
					
					break;
				case 4://Caracteristicas : Modo Color
					Collection listaColor= new ArrayList();
					listaColor.add(terminoVO);
					TerminoVO[] caractColor = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractColor, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaColor.add(itDest.next());
					}
					form.setComboCaractColorBackingList(listaColor, "idTermino", "nomTermino");
					
					break;
				case 5://Caracteristicas : Banda Sonora
					Collection listaBanda= new ArrayList();
					listaBanda.add(terminoVO);
					TerminoVO[] caractModos = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractModos, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaBanda.add(itDest.next());
					}
					form.setComboCaractBandaSonoraBackingList(listaBanda, "idTermino", "nomTermino");
					
					break;
				case 6://Caracteristicas : Formato
					Collection listaFormatos= new ArrayList();
					listaFormatos.add(terminoVO);
					TerminoVO[] caractFormatos = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractFormatos, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaFormatos.add(itDest.next());
					}
					form.setComboCaractFormatoBackingList(listaFormatos, "idTermino", "nomTermino");
					
					break;
				case 7://Caracteristicas : Tipo de plano
					Collection listaPlanos= new ArrayList();
					listaPlanos.add(terminoVO);
					TerminoVO[] caractPlanos = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractPlanos, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaPlanos.add(itDest.next());
					}
					form.setComboCaractTipoPlanoBackingList(listaPlanos, "idTermino", "nomTermino");
					
					break;
				case 8://Caracteristicas : Luz
					Collection listaLuz= new ArrayList();
					listaLuz.add(terminoVO);
					TerminoVO[] caractLuz = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractLuz, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaLuz.add(itDest.next());
					}
					form.setComboCaractLuzBackingList(listaLuz, "idTermino", "nomTermino");
					
					break;
				case 9://Caracteristicas : Estructura formal
					Collection listaEstructuras= new ArrayList();
					listaEstructuras.add(terminoVO);
					TerminoVO[] caractEstructuras = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractEstructuras, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaEstructuras.add(itDest.next());
					}
					form.setComboCaractEstructuraFormalBackingList(listaEstructuras, "idTermino", "nomTermino");
					
					break;
				case 10://Caracteristicas : Angulación
					Collection listaAngulacion= new ArrayList();
					listaAngulacion.add(terminoVO);
					TerminoVO[] caractAngulacion = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractAngulacion, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaAngulacion.add(itDest.next());
					}
					form.setComboCaractAngulacionBackingList(listaAngulacion, "idTermino", "nomTermino");
					
					break;
				case 11://Caracteristicas : Dimensión
					Collection listaDimensiones= new ArrayList();
					listaDimensiones.add(terminoVO);
					TerminoVO[] caractDimensiones = vocabularioOrdenado[x].getTerminos();
					tod = uoc.ordenarTerminosVO(caractDimensiones, idiomaLdap);
					
					itDest = Arrays.asList(tod).iterator();
					while (itDest.hasNext()) {
						listaDimensiones.add(itDest.next());
					}
					form.setComboCaractDimensionBackingList(listaDimensiones, "idTermino", "nomTermino");
					
					break;
				}
				
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados los combos del formulario" );
				}

			}

			logger.debug("Cargados los combos");

				
				TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);

				TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
				//Dividimos los y idiomas de la estructura y el nivel de educación
				ArrayList arrayIdioma=new ArrayList();
				TerminoYPadreVO estructura=null;
				TerminoYPadreVO nivelAgregacion=null;
				
				for(int k=0;k<terminoYPadreVuelta.length;k++){
					String idPadre=terminoYPadreVuelta[k].getIdVocabulario();
					if(idPadre.equals(l_id[0])){//IDIOMA DESTINATARIO
						arrayIdioma.add(terminoYPadreVuelta[k]);
					}
					else if(idPadre.equals(l_id[1])){//ESTRUCTURA
						estructura=terminoYPadreVuelta[k];
					}
					else if(idPadre.equals(l_id[2])){//NIVEL AGREGACION
						nivelAgregacion=terminoYPadreVuelta[k];
					}
				}
				
				TerminoYPadreVO[] idiomasTP=(TerminoYPadreVO[])arrayIdioma.toArray(new TerminoYPadreVO[arrayIdioma.size()]);
				
				//IDIOMAS
				IdiomaVO[] aNuevoIdiomasVO =null;
				IdiomaVO[] aIdiomasVO =catalogadorAvSession.getMDSesion().getGeneral().getIdiomas();
				if (aIdiomasVO != null && (aIdiomasVO.length>0) ){ //&& !(aIdiomasVO.length==1 && aIdiomasVO[0].getTexto().equals(""))
					aNuevoIdiomasVO = new IdiomaVO[catalogadorAvSession.getMDSesion().getGeneral().getIdiomas().length];
					for (int idi = 0; idi<idiomasTP.length; idi++) {
						IdiomaVO idioma = new IdiomaVO();
						idioma.setTexto(idiomasTP[idi].getIdTermino());
						aNuevoIdiomasVO[idi]=idioma;
		            }
				}
				else{
					aNuevoIdiomasVO = new IdiomaVO[1];
					IdiomaVO idioma = new IdiomaVO();
					idioma.setTexto("");
					aNuevoIdiomasVO[0]=idioma;
				}
	            form.setIdiomasAsArray(aNuevoIdiomasVO);
	            form.setIdiomasBackingList(id, "idTermino", "nomTermino");

				
		        //ESTRUCTURA  
	            String idi ="";
		        if (estructura!=null)
				 idi =estructura.getIdTermino()!=null?estructura.getIdTermino():"";
				
				form.setEstructura(idi);
				
				//NIVEL AGREGACION
				idi="";
				if (nivelAgregacion!=null)
				idi = nivelAgregacion.getIdTermino()!=null?nivelAgregacion.getIdTermino():"";
				
				form.setNivelAgregacion(idi);
				
				if( logger.isDebugEnabled() ){

	                logger.debug("Cargados en el formulario los idiomas, la estructura y el nivel de agregacion" );
				}	
				
				//IDENTIFICADOR
				if(catalogadorAvSession.getMDSesion().getGeneral().getIdentificadores()!=null && (catalogadorAvSession.getMDSesion().getGeneral().getIdentificadores().length)> 0)
					form.setIdentificadoresAsArray(catalogadorAvSession.getMDSesion().getGeneral().getIdentificadores());
				else{
					IdentificadorVO[] aIdentificadores = new IdentificadorVO[1];
			    	IdentificadorVO identificadorVO=new IdentificadorVO();
			    	identificadorVO.setCatalogo("");
			    	identificadorVO.setEntrada("");
			    	aIdentificadores[0]=identificadorVO;
			    	form.setIdentificadoresAsArray(aIdentificadores);
				}
				//TITULOS
				
				ArrayList terminoYPadreTitulos = new  ArrayList();
				LangStringVO[] langTextosTitulo = null;
				LangStringVO[] nuevolangTextosTitulo =null;
				TituloVO[] aTituloVO = new TituloVO[1];
				TituloVO tituloVO= new TituloVO();
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getTitulo() !=null)&& (catalogadorAvSession.getMDSesion().getGeneral().getTitulo().getTextos().length)> 0) {
					langTextosTitulo =catalogadorAvSession.getMDSesion().getGeneral().getTitulo().getTextos();
					for(int j=0;j<langTextosTitulo.length;j++){
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino("en");
						terminoypadreVO.setIdVocabulario("5.11");
						terminoypadreVO.setIdTermino("");
						if(langTextosTitulo[j].getIdioma()!=null)
							terminoypadreVO.setNomTermino(langTextosTitulo[j].getIdioma());
						else
							terminoypadreVO.setNomTermino("");
						terminoYPadreTitulos.add(terminoypadreVO);
					}
					
					TerminoYPadreVO[] arrayTerminoYPadreTitulos=(TerminoYPadreVO[])terminoYPadreTitulos.toArray(new TerminoYPadreVO[terminoYPadreTitulos.size()]);
					TerminoYPadreVO[] terminoYPadreTitulosVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreTitulos);
					
					nuevolangTextosTitulo = new LangStringVO[terminoYPadreTitulosVuelta.length];
					for (int i = 0; i<terminoYPadreTitulosVuelta.length; i++) {
						LangStringVO langTitulo = new LangStringVO();
						langTitulo.setTexto(langTextosTitulo[i].getTexto().trim());
						langTitulo.setIdioma(terminoYPadreTitulosVuelta[i].getIdTermino());
						nuevolangTextosTitulo[i] = langTitulo;
		            }
				} 
				else{
					nuevolangTextosTitulo = new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					nuevolangTextosTitulo[0] = lang;
				}
				tituloVO.setTextos(nuevolangTextosTitulo);
				aTituloVO[0]=tituloVO;
	            form.setTitulosAsArray(aTituloVO);
				
	            //DESCRIPCION
	            ArrayList lDescripciones = new ArrayList();
				DescripcionVO[] descripcionVO =null;
				DescripcionVO[] nuevoDescripcionVO =null;
				
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getDescripciones() !=null)&& (catalogadorAvSession.getMDSesion().getGeneral().getDescripciones().length)> 0) {
					descripcionVO = catalogadorAvSession.getMDSesion().getGeneral().getDescripciones();
					nuevoDescripcionVO = new DescripcionVO[descripcionVO.length];
					if(descripcionVO.length == 1 && descripcionVO[0].getTextos().length== 0){
						DescripcionVO desc=new DescripcionVO();
						LangStringVO[] aLangString =new LangStringVO[1];
						LangStringVO lang = new LangStringVO();
						lang.setIdioma("");
						lang.setTexto("");
						aLangString[0]=lang;
						desc.setTextos(aLangString);
						nuevoDescripcionVO[0]=desc;
					}
					else{
						for (int i = 0; i<descripcionVO.length; i++){
							LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
							ArrayList terminoYPadreDescripcion = new  ArrayList();
							if(langTextosDesc!=null && langTextosDesc.length>0){
								for(int j=0;j<langTextosDesc.length;j++){
									terminoypadreVO = new TerminoYPadreVO();
									terminoypadreVO.setIdiomaTermino("en");
									terminoypadreVO.setIdVocabulario("5.11");
									terminoypadreVO.setIdTermino("");
									if(langTextosDesc[j].getIdioma()!=null)
										terminoypadreVO.setNomTermino(langTextosDesc[j].getIdioma());
									else
										terminoypadreVO.setNomTermino("");
									terminoYPadreDescripcion.add(terminoypadreVO);							
								}
							}
							else{
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino("");
								terminoYPadreDescripcion.add(terminoypadreVO);	
							}
						//	if(langTextosDesc.length != 0)
								lDescripciones.add(terminoYPadreDescripcion);
						}

						for (int i = 0; i<lDescripciones.size();i++) {
							DescripcionVO descVO= new DescripcionVO();
							ArrayList terminoYPadreDesc = (ArrayList) lDescripciones.get(i);
							TerminoYPadreVO[] arrayTerminoYPadreDescripcion=(TerminoYPadreVO[])terminoYPadreDesc.toArray(new TerminoYPadreVO[terminoYPadreDesc.size()]);
							TerminoYPadreVO[] terminoYPadreDescripcionVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreDescripcion);
							LangStringVO[] langTextosDesc = descripcionVO[i].getTextos();
							if(langTextosDesc!=null && langTextosDesc.length>0){
								LangStringVO[] nuevoLangTextosDesc = new LangStringVO[langTextosDesc.length];
								for (int j = 0; j<terminoYPadreDescripcionVuelta.length; j++) {
									LangStringVO nuevoLangDesc = new LangStringVO();
									nuevoLangDesc.setIdioma(terminoYPadreDescripcionVuelta[j].getIdTermino());
									nuevoLangDesc.setTexto(langTextosDesc[j].getTexto().trim());
									nuevoLangTextosDesc[j] = nuevoLangDesc;
								}
								descVO.setTextos(nuevoLangTextosDesc);
								
							}
							else{
								LangStringVO[] nuevoLangTextosDesc = new LangStringVO[1];
								LangStringVO nuevoLangDesc = new LangStringVO();
								nuevoLangDesc.setIdioma("");
								nuevoLangDesc.setTexto("");
								nuevoLangTextosDesc[0] = nuevoLangDesc;
								descVO.setTextos(nuevoLangTextosDesc);
								
							}
							nuevoDescripcionVO[i]=descVO;
						}	
					}
				}
				else{
					nuevoDescripcionVO = new DescripcionVO[1];
					LangStringVO[] aLangString =new LangStringVO[1];
					LangStringVO lang = new LangStringVO();
					lang.setIdioma("");
					lang.setTexto("");
					aLangString[0]=lang;
					DescripcionVO descVO= new DescripcionVO();
					descVO.setTextos(aLangString);
					nuevoDescripcionVO[0] = descVO;
				}

	            form.setDescripcionesAsArray(nuevoDescripcionVO);
				
				//caracteristicas
	            Caracteristica[][] lCaracteristicas= new Caracteristica[nuevoDescripcionVO.length][];
				I18n i18n= I18n.getInstance();
				
				for (int i = 0; i < nuevoDescripcionVO.length; i++) {
					LangStringVO[] listaTextos = nuevoDescripcionVO[i].getTextos();
					Caracteristica[] arrayCaract = new Caracteristica[listaTextos.length];
					for (int j = 0; j < listaTextos.length; j++) {
						String idioma=(String)  listaIdiomas.get( listaTextos[j].getIdioma() );
						if(idioma!=null)
						{
							String[] captions = i18n.getResource("caracteristicas.captions", "application-resources" , new Locale(idioma)).split(",");
							arrayCaract[j]= Caracteristica.getInstance(listaTextos[j].getTexto(), captions);
							TerminoYPadreVO[] arraytyp= new TerminoYPadreVO[8];
							if(arrayCaract[j]!=null && !arrayCaract[j].getVacio())
							{
								
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.2");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getDimension());
								arraytyp[0]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.3");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getModoColor());
								arraytyp[1]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.4");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getBandaSonora());
								arraytyp[2]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.5");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getFormato());
								arraytyp[3]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.6");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getTipoPlano());
								arraytyp[4]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.7");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getLuz());
								arraytyp[5]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.8");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getEstructuraFormal());
								arraytyp[6]= terminoypadreVO;
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino(idioma);
								terminoypadreVO.setIdVocabulario("1.4.9");
								terminoypadreVO.setIdTermino("");
								terminoypadreVO.setNomTermino(arrayCaract[j].getAngulacion());
								arraytyp[7]= terminoypadreVO;

								TerminoYPadreVO[] typVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arraytyp);
								
								
								arrayCaract[j].setDimension(typVuelta[0].getIdTermino());
								arrayCaract[j].setModoColor(typVuelta[1].getIdTermino());
								arrayCaract[j].setBandaSonora(typVuelta[2].getIdTermino());
								arrayCaract[j].setFormato(typVuelta[3].getIdTermino());
								arrayCaract[j].setTipoPlano(typVuelta[4].getIdTermino());
								arrayCaract[j].setLuz(typVuelta[5].getIdTermino());
								arrayCaract[j].setEstructuraFormal(typVuelta[6].getIdTermino());
								arrayCaract[j].setAngulacion(typVuelta[7].getIdTermino());
							}						
						}else
							arrayCaract[j]= Caracteristica.getInstance(listaTextos[j].getTexto(), null);
					}
					
					lCaracteristicas[i]= arrayCaract;
				}
	            
				form.setCaracteristicasAsArray(lCaracteristicas);
				
				//PALABRAS CLAVE
	            ArrayList lPalabras = new ArrayList();
				PalabraClaveVO[] palabraClaveVO =null;
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getPalabrasClave() !=null) && (catalogadorAvSession.getMDSesion().getGeneral().getPalabrasClave().length)> 0) {
					palabraClaveVO = catalogadorAvSession.getMDSesion().getGeneral().getPalabrasClave();
					for (int i = 0; i<palabraClaveVO.length; i++){
						LangStringVO[] langTextosPal = palabraClaveVO[i].getTextos();
						ArrayList terminoYPadrePalabras = new  ArrayList();
						if(langTextosPal!=null && langTextosPal.length>0){
							for(int j=0;j<langTextosPal.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								if(langTextosPal[j].getIdioma()!= null)
									terminoypadreVO.setNomTermino(langTextosPal[j].getIdioma());
								else
									terminoypadreVO.setNomTermino("");
								terminoYPadrePalabras.add(terminoypadreVO);
								
							}
						}
						else{
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario("5.11");
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoYPadrePalabras.add(terminoypadreVO);
						}
						lPalabras.add(terminoYPadrePalabras);
					}
				} else {
					ArrayList terminoYPadrePalabras = new  ArrayList();
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario("5.11");
					terminoypadreVO.setIdTermino("");
					terminoypadreVO.setNomTermino(((GeneralFormImpl)form).getComboIdiomaLabelList()[0].toString());//terminoYPadre rellenado con los idiomas desde el formulario
					terminoYPadrePalabras.add(terminoypadreVO);
					lPalabras.add(terminoYPadrePalabras);
					LangStringVO[] cLangPalabras = new LangStringVO[1];
					LangStringVO vacio = new LangStringVO();
					vacio.setTexto("");
					vacio.setIdioma("");
					cLangPalabras[0]=vacio;
					PalabraClaveVO palVacio = new PalabraClaveVO();
					palVacio.setTextos(cLangPalabras);
					palabraClaveVO = new PalabraClaveVO[1];
					palabraClaveVO[0]=palVacio;
				}

				PalabraClaveVO[] palabrasClave = new PalabraClaveVO[lPalabras.size()];
				for (int i = 0; i<lPalabras.size();i++) {
					PalabraClaveVO pClaVO = new PalabraClaveVO();
					ArrayList terminoYPadrePalab = (ArrayList) lPalabras.get(i);
					if(terminoYPadrePalab!=null && terminoYPadrePalab.size()>0){
						TerminoYPadreVO[] arrayTerminoYPadrePalabras=(TerminoYPadreVO[])terminoYPadrePalab.toArray(new TerminoYPadreVO[terminoYPadrePalab.size()]);
						TerminoYPadreVO[] terminoYPadrePalabrasVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadrePalabras);
						LangStringVO[] langTextosPal = palabraClaveVO[i].getTextos();
						if(langTextosPal!=null && langTextosPal.length>0){
							LangStringVO[] nuevoLangTextosPal = new LangStringVO[langTextosPal.length];
							for (int j = 0; j<terminoYPadrePalabrasVuelta.length; j++) {
								LangStringVO nuevoLangPal = new LangStringVO();
								nuevoLangPal.setIdioma(terminoYPadrePalabrasVuelta[j].getIdTermino());
								nuevoLangPal.setTexto(langTextosPal[j].getTexto().trim());
								nuevoLangTextosPal[j]= nuevoLangPal;
								pClaVO.setTextos(nuevoLangTextosPal);
								
							}
						}else{
							LangStringVO[] nuevoLangTextosPal=new LangStringVO[1];
							LangStringVO nuevoLangPal = new LangStringVO();
							nuevoLangPal.setIdioma("");
							nuevoLangPal.setTexto("");
							nuevoLangTextosPal[0]= nuevoLangPal;
							pClaVO.setTextos(nuevoLangTextosPal);
						}
						palabrasClave[i]=pClaVO;
					}
					else{
						LangStringVO[] nuevoLangTextosPal = new LangStringVO[1];
						LangStringVO nuevoLangPal = new LangStringVO();
						nuevoLangPal.setIdioma("");
						nuevoLangPal.setTexto("");
						nuevoLangTextosPal[0]= nuevoLangPal;
						pClaVO.setTextos(nuevoLangTextosPal);
					}
					
					
					
				}
	            form.setPalabrasClaveAsArray(palabrasClave);;
           

				//AMBITO
	            ArrayList lAmbito = new ArrayList();
	            AmbitoVO[] ambitoVO =null;
				if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getAmbitos() !=null) && (catalogadorAvSession.getMDSesion().getGeneral().getAmbitos().length)> 0) {
					ambitoVO = catalogadorAvSession.getMDSesion().getGeneral().getAmbitos();
					for (int i = 0; i<ambitoVO.length; i++){
						LangStringVO[] langTextosAmb = ambitoVO[i].getTextos();
						ArrayList terminoYPadreAmbito = new  ArrayList();
						if(langTextosAmb!=null && langTextosAmb.length>0){
							
							for(int j=0;j<langTextosAmb.length;j++){
								terminoypadreVO = new TerminoYPadreVO();
								terminoypadreVO.setIdiomaTermino("en");
								terminoypadreVO.setIdVocabulario("5.11");
								terminoypadreVO.setIdTermino("");
								if(langTextosAmb[j].getIdioma()!=null)
									terminoypadreVO.setNomTermino(langTextosAmb[j].getIdioma());
								else
									terminoypadreVO.setNomTermino("");
								terminoYPadreAmbito.add(terminoypadreVO);	
							}
						}
						else{
							terminoypadreVO = new TerminoYPadreVO();
							terminoypadreVO.setIdiomaTermino("en");
							terminoypadreVO.setIdVocabulario("5.11");
							terminoypadreVO.setIdTermino("");
							terminoypadreVO.setNomTermino("");
							terminoYPadreAmbito.add(terminoypadreVO);	
						}
						lAmbito.add(terminoYPadreAmbito);
					}
				} else {
					ArrayList terminoYPadreAmbito = new  ArrayList();
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario("5.11");
					terminoypadreVO.setIdTermino("");
					terminoypadreVO.setNomTermino(((GeneralFormImpl)form).getComboIdiomaLabelList()[0].toString());//terminoYPadre rellenado con los idiomas desde el formulario
					terminoYPadreAmbito.add(terminoypadreVO);
					lAmbito.add(terminoYPadreAmbito);
					LangStringVO[] cLangAmbito = new LangStringVO[1];
					LangStringVO vacio = new LangStringVO();
					vacio.setTexto("");
					vacio.setIdioma("");
					
					cLangAmbito[0]=vacio;
					AmbitoVO ambitoVacio = new AmbitoVO();
					ambitoVacio.setTextos(cLangAmbito);
					ambitoVO = new AmbitoVO[1];
					ambitoVO[0]=ambitoVacio;
				}
				
				AmbitoVO[] ambitos = new AmbitoVO[lAmbito.size()];
				for (int i = 0; i<lAmbito.size();i++) {
					AmbitoVO ambVO = new AmbitoVO();;
					ArrayList terminoYPadreAmb = (ArrayList) lAmbito.get(i);
					if(terminoYPadreAmb!=null && terminoYPadreAmb.size()>0){
						TerminoYPadreVO[] arrayTerminoYPadreAmbito=(TerminoYPadreVO[])terminoYPadreAmb.toArray(new TerminoYPadreVO[terminoYPadreAmb.size()]);
						TerminoYPadreVO[] terminoYPadreAmbitoVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadreAmbito);
						LangStringVO[] langTextosAmb = ambitoVO[i].getTextos();
						if(langTextosAmb!=null && langTextosAmb.length>0){
							LangStringVO[] nuevoLangTextosAmb = new LangStringVO[langTextosAmb.length];
							for (int j = 0; j<terminoYPadreAmbitoVuelta.length; j++) {
								LangStringVO nuevoLangAmb =new LangStringVO();
								nuevoLangAmb.setIdioma(terminoYPadreAmbitoVuelta[j].getIdTermino());
								nuevoLangAmb.setTexto(langTextosAmb[j].getTexto().trim());
								nuevoLangTextosAmb[j]= nuevoLangAmb;
								ambVO.setTextos(nuevoLangTextosAmb);
							}
						}else{
							LangStringVO[] nuevoLangTextosAmb = new LangStringVO[1];
							LangStringVO nuevoLangAmb =new LangStringVO();
							nuevoLangAmb.setIdioma("");
							nuevoLangAmb.setTexto("");
							nuevoLangTextosAmb[0]= nuevoLangAmb;
							ambVO.setTextos(nuevoLangTextosAmb);
						}
					}
					else{
						LangStringVO[] nuevoLangTextosAmb = new LangStringVO[1];
						LangStringVO nuevoLangAmb =new LangStringVO();
						nuevoLangAmb.setIdioma("");
						nuevoLangAmb.setTexto("");
						nuevoLangTextosAmb[0]= nuevoLangAmb;
						ambVO.setTextos(nuevoLangTextosAmb);
					}
					
					ambitos[i]=ambVO;
				}
	            form.setAmbitosAsArray(ambitos);
	            
	            //si general era null en el objeto de session lo dejamos a null
	            if(generalEsNull)
	            	catalogadorAvSession.getMDSesion().setGeneral(null);
	            
        }catch (org.acegisecurity.AccessDeniedException ad) {
    	   	logger.error("Error de Acceso " + ad);
    	   	throw new Exception("general",ad);
        }catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría General, método cargarDagosgeneral " + e);
			throw new Exception("general",e);
        }finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
        }
		
	}


	public String accionSubmit(
			ActionMapping mapping, 
			AccionSubmitForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		
		String accion;
		if(form.getAccion()==null || form.getAccion().equals("")){
			accion= obtenerAccion(request);
			form.setAccion(accion);
		}
		else
			accion=form.getAccion();
		String[] accionPartes = accion.split("-");
		accion = accionPartes[0];
		if (accionPartes.length  > 1){
			request.setAttribute("posicion", accionPartes[1]);
			if (accionPartes.length == 3)
				request.setAttribute("posicionExterior", accionPartes[2]);
		}
        String resAction = "";
        //String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
//        
//        if (datosResources.getString("general.AñadirIdioma").equals(accion)) {
//              resAction = "Añadir Idioma";
//        }else if (datosResources.getString("general.EliminarIdioma").equals(accion)) {
//              resAction = "Eliminar Idioma";
//        }else if (datosResources.getString("general.AñadirAmbitos").equals(accion)) {
//              resAction = "Añadir Ambitos";
//        }else if (datosResources.getString("general.EliminarAmbitos").equals(accion)) {
//              resAction = "Eliminar Ambitos";
//        }else if (datosResources.getString("general.AñadirContAmbito").equals(accion)) {
//              resAction = "Añadir ContAmbito";
//        }else if (datosResources.getString("general.EliminarContAmbito").equals(accion)) {
//              resAction = "Eliminar ContAmbito";
//        }else if (datosResources.getString("general.AñadirDescripcion").equals(accion)) {
//              resAction = "Añadir Descripcion";
//        }else if (datosResources.getString("general.EliminarDescripcion").equals(accion)) {
//              resAction = "Eliminar Descripcion";
//        }else if (datosResources.getString("general.AñadirContDescripcion").equals(accion)) {
//              resAction = "Añadir ContDescripcion";
//        }else if (datosResources.getString("general.EliminarContDescripcion").equals(accion)) {
//              resAction = "Eliminar ContDescripcion";
//        }else if (datosResources.getString("general.AñadirPalabraClave").equals(accion)) {
//              resAction = "Añadir PalabraClave";
//        }else if (datosResources.getString("general.EliminarPalabraClave").equals(accion)) {
//              resAction = "Eliminar PalabraClave";
//        }else if (datosResources.getString("general.AñadirContPalabraClave").equals(accion)) {
//              resAction = "Añadir ContPalabraClave";
//        }else if (datosResources.getString("general.EliminarContPalabraClave").equals(accion)) {
//              resAction = "Eliminar ContPalabraClave";
//        }else if (datosResources.getString("general.AñadirIdentificador").equals(accion)) {
//              resAction = "Añadir Identificador";
//        }else if (datosResources.getString("general.EliminarIdentificador").equals(accion)) {
//              resAction = "Eliminar Identificador";
//        }else if (datosResources.getString("general.AñadirTitulo").equals(accion)) {
//              resAction = "Añadir Titulo";
//        }else if (datosResources.getString("general.EliminarTitulo").equals(accion)) {
//              resAction = "Eliminar Titulo";
//        }else 
        if (datosResources.getString("general.Aceptar").equals(accion)) {
              resAction = "Aceptar";
        }else if (datosResources.getString("general.Validar").equals(accion)) {
              resAction = "Validar";
        }else if (datosResources.getString("general.Cancelar").equals(accion)) {
              resAction = "Cancelar";
        }else if (datosResources.getString("general.Reset").equals(accion)) {
            resAction = "Reset";
      }
        else
        	resAction= accion;
        
        return resAction;

	}


	public boolean esValidoGeneral(ActionMapping mapping, EsValidoGeneralForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String resultado= "";
		boolean ok= true;
		
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		Collection mensajes = new ArrayList();
		
		CatalogadorAvSession os = this.getCatalogadorAvSession(request);
	
		AvGeneralVO gn = new AvGeneralVO();
		
		Object valor = request.getSession().getAttribute("form");

		
    	//Obtenemos la longitudes de los VOs, que pasamos a cambioFormulario para que se obtengan del request los cambios que hemos hecho
    	//Pues en el form que nos viene como parametro no los guarda.
    	int longitudDescripciones=0;
    	int longitudPalabrasClave=0;
    	int longitudAmbitos=0;
    	int longitudIdentificadores=0;
    	int longitudIdiomas=0;
    	int longitudTitulo=0;
    	int[] longitudTextosDesc = new int[0];
    	int[] longitudTextosPCla = new int[0];
    	int[] longitudTextosAmbitos = new int[0];
    	Object[] desc=null;
    	Object[] pCla=null;
    	Object[] amb=null;

    	if(valor instanceof GeneralFormImpl)
    	{
    		GeneralFormImpl valorGen = ((GeneralFormImpl)valor);
    		desc = valorGen.getDescripcionesAsArray();
    		pCla = valorGen.getPalabrasClaveAsArray();
    		amb = valorGen.getAmbitosAsArray();
    		longitudPalabrasClave= valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
		  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
		  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
		  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
		  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;
    	}else if(valor instanceof GeneralFormSubmitFormImpl)
    	{
    		GeneralFormSubmitFormImpl valorGen = ((GeneralFormSubmitFormImpl)valor);
    		desc = valorGen.getDescripcionesAsArray();
    		pCla = valorGen.getPalabrasClaveAsArray();
    		amb = valorGen.getAmbitosAsArray();
    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
		  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
		  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
		  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
		  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;
    		
    	}else if(valor instanceof ValidoGeneralVolverFormImpl){
    		ValidoGeneralVolverFormImpl valorGen = ((ValidoGeneralVolverFormImpl)valor);
    		desc = valorGen.getDescripcionesAsArray();
    		pCla = valorGen.getPalabrasClaveAsArray();
    		amb = valorGen.getAmbitosAsArray();
    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
		  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
		  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
		  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
		  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;

    		
    	}else if(valor instanceof NoValidoGeneralVolverFormImpl){
    		NoValidoGeneralVolverFormImpl valorGen = ((NoValidoGeneralVolverFormImpl)valor);
    		desc = valorGen.getDescripcionesAsArray();
    		pCla = valorGen.getPalabrasClaveAsArray();
    		amb = valorGen.getAmbitosAsArray();
    		longitudPalabrasClave=valorGen.getPalabrasClaveAsArray()!=null?valorGen.getPalabrasClaveAsArray().length:0;
		  	longitudAmbitos=valorGen.getAmbitosAsArray()!=null?valorGen.getAmbitosAsArray().length:0;
		  	longitudIdentificadores=valorGen.getIdentificadoresAsArray()!=null?valorGen.getIdentificadoresAsArray().length:0;
		  	longitudIdiomas=valorGen.getIdiomasAsArray()!=null?valorGen.getIdiomasAsArray().length:0;
		  	longitudTitulo=(((TituloVO[])valorGen.getTitulosAsArray())[0])!=null?(((TituloVO[])valorGen.getTitulosAsArray())[0]).getTextos().length:0;

		
    	}
    	
    	longitudTextosDesc = new int[desc.length];
		for(int i= 0;i< desc.length;i++){
			longitudTextosDesc[i]=((DescripcionVO)(desc[i]))!=null?((DescripcionVO)(desc[i])).getTextos().length:0;
		}
		longitudTextosPCla= new int[pCla.length];
		for(int i= 0;i< pCla.length;i++){
			longitudTextosPCla[i]=((PalabraClaveVO)pCla[i])!=null?((PalabraClaveVO)pCla[i]).getTextos().length:0;
		}
		longitudTextosAmbitos= new int[amb.length];
		for(int i= 0;i< amb.length;i++){
			longitudTextosAmbitos[i]=((AmbitoVO)amb[i])!=null?((AmbitoVO)amb[i]).getTextos().length:0;
		}
		longitudDescripciones=desc.length;
     	
    	//Recogemos los cambio del request mediante parametros
	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
				longitudIdiomas,longitudTitulo);
    	
    	//Guardamos los cambios en el form obtenido de request.getSession.getAttribute("form") para que en caso de faltar
	  	//algun idioma o texto sin rellenar cargue el formulario con lo cambio y no perdamos todo lo modificado hasta ese
	  	//momento, si no lo hicieramos cargaría el formulario anterior. (Nivel de Agregacion y Estructura si mantienen los
	  	//cambios)
		
		
		gn.setIdentificadores(identificadores);
		gn.setTitulo(titulos[0]);
		gn.setIdiomas(idiomas);
		gn.setDescripciones(descripciones);
		gn.setPalabrasClave(palabrasClave);
		gn.setAmbitos(ambitos);
		SourceValueVO sv=new SourceValueVO();
		sv.setValor(form.getEstructura());
		gn.setEstructura(sv);
		
		sv= new SourceValueVO();
		sv.setValor(form.getNivelAgregacion());
		gn.setNivelAgregacion(sv);
		
		os.setLomValidacion(new LomAvanzadoVO());
		os.getLomValidacion().setGeneral(gn);
		
		this.setCatalogadorAvSession(request, os);
		
		
//		Collection errores=new ArrayList();
		//CATALOGOS
		int i= 0;
		while ((ok)&&(i<gn.getIdentificadores().length)){
			String cat= gn.getIdentificadores()[i].getCatalogo().trim();
			String ent= gn.getIdentificadores()[i].getEntrada().trim();
			
			if(((cat==null)||(cat.equals("")))&& ((ent!=null)&&(!ent.equals(""))))//Si existe una entrada, un catálogo es obligatorio
					mensajes.add(datosResources.getString("CAV.1.1.1"));

			if (!resultado.equals("")){
				ok= false;
			}
			else{
				i++;
			}	
		}
		//ENTRADAS
		i= 0;
		while ((ok)&&(i<gn.getIdentificadores().length)){
			String cat= gn.getIdentificadores()[i].getCatalogo().trim();
			String ent= gn.getIdentificadores()[i].getEntrada().trim();
			
			if (((ent==null)||(ent.equals("")))&& ((cat!=null)&&(!cat.equals(""))))//Si existe un catálogo, una entrada es obligatoria
				mensajes.add(datosResources.getString("CAV.1.1.2"));
			
			
			if (!resultado.equals("")){
				ok= false;
			}
			else{
				i++;
			}	
		}
		//TITULOS
		boolean todosVacios=true;
		String texto;
		for(i=0;i<gn.getTitulo().getTextos().length && todosVacios ;i++)
		{
			texto=gn.getTitulo().getTextos()[i].getTexto().trim();
			if(texto!=null && !texto.equals(""))
			{
				todosVacios=false;
			}
		}
		if(todosVacios)
			mensajes.add(datosResources.getString("CAV.1.2"));//debe tener por lo menos un titulo
		
		//IDIOMA
		todosVacios=true;
		String idioma;
		for(i=0;i<gn.getIdiomas().length && todosVacios;i++)
		{
			idioma= gn.getIdiomas()[i].getTexto();
			if(idioma!=null && !idioma.equals(""))
			{
				todosVacios=false;
			}
		}
		if(todosVacios)
			mensajes.add(datosResources.getString("CAV.1.3"));//debe tener por lo menos un idioma
		
		todosVacios=true;
		String descripcion;
		for(i=0;i<gn.getDescripciones().length && todosVacios;i++)
		{
			for(int j=0;j<gn.getDescripciones()[i].getTextos().length && todosVacios;j++)
			{
				descripcion=gn.getDescripciones()[i].getTextos()[j].getTexto().trim();
				if(descripcion!=null && !descripcion.equals(""))
				{
					todosVacios=false;
				}
			}
		}
		if(todosVacios)
			mensajes.add(datosResources.getString("CAV.1.4"));//al menos una descripcion
		
		//NIVEL DE AGREGACION
		if(gn.getNivelAgregacion().getValor()==null || gn.getNivelAgregacion().getValor().equals(""))
			mensajes.add(datosResources.getString("CAV.1.8"));


		if(mensajes.size()>0)
		{
			form.setMensajesError(mensajes);
			return false;
		}else{
			return true;
		}
		
	}
	
private void cambioFormulario(HttpServletRequest request,int[] longitudTextosDesc,int[] longitudTextosPCla,int[] longitudTextosAmbitos,int longitudDescripciones,
		int longitudPalabrasClave,int longitudAmbitos, int longitudIdentificadores, int longitudIdiomas,
		int longitudTitulo) throws Exception{
    	
	  	identificadores=new IdentificadorVO[longitudIdentificadores];//form.getIdentificadores().size()
	  	titulos = new TituloVO[1];
	  	idiomas = new IdiomaVO[longitudIdiomas];//form.getIdiomas().size()
	  	descripciones = new DescripcionVO[longitudDescripciones];//form.getDescripciones().size()
	  	caracteristicas = new Caracteristica[longitudDescripciones][];
	  	palabrasClave = new PalabraClaveVO[longitudPalabrasClave];//form.getPalabrasClave().size()
	  	ambitos = new AmbitoVO[longitudAmbitos];
      	ArrayList[] textoDescripciones = new ArrayList[longitudDescripciones];
      	ArrayList[] caractDescrpciones = new ArrayList[longitudDescripciones];
      	ArrayList[] idiomaDescripciones = new ArrayList[longitudDescripciones];
      	
      	ArrayList[] textoPalabrasClave = new ArrayList[longitudPalabrasClave];
      	ArrayList[] idiomaPalabrasClave = new ArrayList[longitudPalabrasClave];
      	ArrayList[] textoAmbito = new ArrayList[longitudAmbitos];//form.getAmbitos().size()
      	ArrayList[] idiomaAmbito = new ArrayList[longitudAmbitos];
      	String[] catalogos = new String[longitudIdentificadores];
      	String[] entradas = new String[longitudIdentificadores];
      	String[] textoTitulo = new String[longitudTitulo];
      	String[] idiomaTitulo = new String[longitudTitulo];
      	String[] idiomaValor = new String[longitudIdiomas];
       for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
       {
      	 String name = String.valueOf(names.nextElement());
           if(name.startsWith("Id")){
          	 if(name.startsWith("IdCat")){
              		 int i = Integer.parseInt(name.substring(5, name.length()));
              		 catalogos[i]=request.getParameter(name);
              	 }	 
  
              	 if (name.startsWith("IdEnt")){
          		 int i = Integer.parseInt(name.substring(5, name.length()));
          		 entradas[i]=request.getParameter(name);
          	 }
           }
           if (name.startsWith("Tit")){
          	 if(name.startsWith("TitTex")){
              		 int i = Integer.parseInt(name.substring(6, name.length()));
              		 textoTitulo[i]=request.getParameter(name);
              	 }	 
  
              	 if (name.startsWith("TitIdio")){
          		 int i = Integer.parseInt(name.substring(7, name.length()));
          		 idiomaTitulo[i]=request.getParameter(name);
          	 }
           }
           if (name.startsWith("Idio")){
      		 int i = Integer.parseInt(name.substring(4, name.length()));
      		 idiomaValor[i]=request.getParameter(name);
           }
           if (name.startsWith("Des")){       	 
          	 String[] namePartido = name.split("_");
          	 int i = Integer.parseInt(namePartido[0].substring(3, namePartido[0].length()));
          	 if (namePartido[1].startsWith("Tex")){
          		 int j = Integer.parseInt(namePartido[1].substring(3, namePartido[1].length()));
          		 ArrayList lDesc = textoDescripciones[i];
          		 if(lDesc == null){
          			 lDesc= new ArrayList();
          			 for (int k=0;k<longitudTextosDesc[i];k++)
          				 lDesc.add("");
          		 }
          		 
          		 lDesc.set(j, request.getParameter(name));
          		 textoDescripciones[i]=lDesc;
          	 }
          	 else if(namePartido[1].startsWith("Idio")){//Idio
          		 int j = Integer.parseInt(namePartido[1].substring(4, namePartido[1].length()));
          		 ArrayList lDesc = idiomaDescripciones[i];
          		 if(lDesc == null){
          			 lDesc= new ArrayList();
          			 for (int k=0;k<longitudTextosDesc[i];k++)
          				 lDesc.add("");
          		 }
          		 
          		 lDesc.set(j, request.getParameter(name));
          		 idiomaDescripciones[i]=lDesc;
          	 }else { //caracteristicas
          		 int j = Integer.parseInt(namePartido[1].substring(4, namePartido[1].length()));
          		 ArrayList lCarac = caractDescrpciones[i];
          		 if(lCarac == null){
          			lCarac= new ArrayList();
          			 for (int k=0;k<longitudTextosDesc[i];k++)
          				lCarac.add(Caracteristica.getInstance("", null)); //creo un objeto caracteristica vacio
          		 }
          		 if(namePartido[1].startsWith("CDim"))//Dimension
          			 ((Caracteristica) lCarac.get(j)).setDimension(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CCol"))//Color
          			 ((Caracteristica) lCarac.get(j)).setModoColor(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CBan"))//Banda Sonora
          			 ((Caracteristica) lCarac.get(j)).setBandaSonora(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CFor"))//Formato
          			 ((Caracteristica) lCarac.get(j)).setFormato(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CTip"))//Tipo Plano
          			 ((Caracteristica) lCarac.get(j)).setTipoPlano(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CLuz"))//Luz
          			 ((Caracteristica) lCarac.get(j)).setLuz(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CEst"))//Estructura Formal
          			 ((Caracteristica) lCarac.get(j)).setEstructuraFormal(request.getParameter(name));
          		 else if(namePartido[1].startsWith("CAng"))//Angulacion
          			 ((Caracteristica) lCarac.get(j)).setAngulacion(request.getParameter(name));
          		 else //Resolucion
          			 ((Caracteristica) lCarac.get(j)).setResolucion(request.getParameter(name));

          		caractDescrpciones[i]=lCarac;
          	 }
           }
           else if (name.startsWith("Pcla")){
          	 String[] namePartido = name.split("_");
          	 int i = Integer.parseInt(namePartido[0].substring(4, namePartido[0].length()));
          	 if (namePartido[1].startsWith("Tex")){
          		 int j = Integer.parseInt(namePartido[1].substring(3, namePartido[1].length()));
          		 ArrayList lPCla = textoPalabrasClave[i];
          		 if(lPCla == null){
          			 lPCla= new ArrayList();
          			 for (int k=0;k<longitudTextosPCla[i];k++)
          				 lPCla.add("");
          		 }
          		 
          		 lPCla.set(j, request.getParameter(name));
          		 textoPalabrasClave[i]=lPCla;
          	 }
          	 else{//Idio
          		 int j = Integer.parseInt(namePartido[1].substring(4, namePartido[1].length()));
          		 ArrayList lPCla = idiomaPalabrasClave[i];
          		 if(lPCla == null){
          			 lPCla= new ArrayList();
          			 for (int k=0;k<longitudTextosPCla[i];k++)
          				 lPCla.add("");
          		 }
          		 
          		 lPCla.set(j, request.getParameter(name));
          		 idiomaPalabrasClave[i]=lPCla;
          	 }
           }
           else if (name.startsWith("Amb")){
          	 String[] namePartido = name.split("_");
          	 int i = Integer.parseInt(namePartido[0].substring(3, namePartido[0].length()));
          	 if (namePartido[1].startsWith("Tex")){
          		 int j = Integer.parseInt(namePartido[1].substring(3, namePartido[1].length()));
          		 ArrayList lAmb= textoAmbito[i];
          		 if(lAmb == null){
          			 lAmb= new ArrayList();
          			 
          			 for (int k=0;k<longitudTextosAmbitos[i];k++)
          				 lAmb.add("");
          		 }
          		 
          		 lAmb.set(j, request.getParameter(name));
          		 textoAmbito[i]=lAmb;
          	 }
          	 else{//Idio
          		 int j = Integer.parseInt(namePartido[1].substring(4, namePartido[1].length()));
          		 ArrayList lAmb = idiomaAmbito[i];
          		 if(lAmb == null){
          			 lAmb= new ArrayList();
          			 for (int k=0;k<longitudTextosAmbitos[i];k++)
          				 lAmb.add("");
          		 }
          		 
          		 lAmb.set(j, request.getParameter(name));
          		 idiomaAmbito[i]=lAmb;
          	 }
           }             
       }
       
       
       //identificadores
       for (int i = 0; i<catalogos.length;i++){
    	 IdentificadorVO idVO = new IdentificadorVO();
  	  	 String catalogosI=catalogos[i]!=null?catalogos[i]:"";
  	  	 idVO.setCatalogo(catalogosI.trim());
  	  	 String entradasI=entradas[i]!=null?entradas[i]:"";
  	  	 idVO.setEntrada(entradasI.trim()); 
  	  	 identificadores[i] = idVO;
       }

       //titulo
       TituloVO titVO = new TituloVO();
       LangStringVO[] aLangTitulo = new LangStringVO[textoTitulo.length];
       for (int i = 0; i<textoTitulo.length;i++){
    	 LangStringVO langTitulo= new LangStringVO();
  	  	 String textoTituI=textoTitulo[i]!=null?textoTitulo[i]:"";
  	  	 langTitulo.setTexto(textoTituI.trim());
  	  	 String idiomaTituI=idiomaTitulo[i]!=null?idiomaTitulo[i]:"";
  	  	 langTitulo.setIdioma(idiomaTituI);
  	  	 aLangTitulo[i] = langTitulo;
       }
       titVO.setTextos(aLangTitulo);
       titulos[0]=titVO;
            
       //idioma
       for (int i = 0; i<idiomaValor.length;i++){
      	 IdiomaVO idioVO = new IdiomaVO();
      	 idioVO.setTexto(idiomaValor[i]);
      	 idiomas[i] = idioVO;
       }
    
       //caracteristicas
       for (int i = 0; i < caractDescrpciones.length; i++) {
		 caracteristicas[i]= (Caracteristica[]) caractDescrpciones[i].toArray(new Caracteristica[0]);
       } 
       //descripciones
       I18n i18n = I18n.getInstance();
       
       for(int i=0;i<textoDescripciones.length;i++){
    	 DescripcionVO descVO = new DescripcionVO();
  	  	 if (textoDescripciones[i]!=null) {
  		     LangStringVO[] aLangDesc = new LangStringVO[textoDescripciones[i].size()];
  		     for (int j = 0; j<textoDescripciones[i].size();j++){
  		    	 LangStringVO langDesc= new LangStringVO();
  		    	 String idiomaDescIJ= (idiomaDescripciones[i].get(j)!=null?idiomaDescripciones[i].get(j):"").toString();
  		    	 langDesc.setIdioma(idiomaDescIJ);

  		    	 String textoDescIJ ;
  		    	 String idioma=(String)  listaIdiomas.get( idiomaDescIJ);
  		    	 if(idioma==null)
  		    		 idioma= this.getCatalogadorAvSession(request).getIdioma();

  		    	 if(caracteristicas[i][j]!=null && !caracteristicas[i][j].getVacio() && idioma!=null)
  		    	 {
  					 String[] captions = i18n.getResource("caracteristicas.captions", "application-resources" , new Locale(idioma)).split(",");
  		    		 Caracteristica caractAux = caracteristicas[i][j]; 
  		    		 StringBuffer sb = new StringBuffer();
  		    		 sb.append(captions[0]); 
  		    		
  		    		 // busco las traducciones correspondientes a cada idioma
  		    		 String[] codigos= caractAux.getCodigos();
  		    		 TerminoVO[] terminosTrad = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(codigos, idioma);
  		    		 
  		    		 int indice=0;
  		    		 if(caractAux.getResolucion()!=null && !caractAux.getResolucion().equals(""))
  		    		 	 sb.append(captions[1]).append(" (").append(caractAux.getResolucion()).append("),");
  		    		 if(caractAux.getDimension()!=null && !caractAux.getDimension().equals("") && codigos[0]!="")
  		    		 {
  		    			 sb.append(captions[2]).append(" (").append( terminosTrad[indice].getNomTermino()).append("),");
  		    			 indice++;
  		    		 }
  		    		 if(caractAux.getModoColor()!=null && !caractAux.getModoColor().equals("") && codigos[1]!="")
  		    		 {
  		    		 	 sb.append(captions[3]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	indice++;
  		    		 }
  		    		 if(caractAux.getBandaSonora()!=null && !caractAux.getBandaSonora().equals("") && codigos[2]!="")
  		    		 {
  		    		 	 sb.append(captions[4]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	 indice++;
  		    		 }
  		    		 if(caractAux.getFormato()!=null && !caractAux.getFormato().equals("") && codigos[3]!="")
  		    		 {
  		    		 	 sb.append(captions[5]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	 indice++;
  		    		 }
  		    		 if(caractAux.getTipoPlano()!=null && !caractAux.getTipoPlano().equals("") && codigos[4]!="")
  		    		 {
  		    		 	 sb.append(captions[6]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	 indice++;
  		    		 }
  		    		 if(caractAux.getLuz()!=null && !caractAux.getLuz().equals("") && codigos[5]!="")
  		    		 {
  		    		 	 sb.append(captions[7]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	 indice++;
  		    		 }
  		    		 if(caractAux.getEstructuraFormal()!=null && !caractAux.getEstructuraFormal().equals("") && codigos[6]!="")
  		    		 {
  		    		 	 sb.append(captions[8]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	 indice++;
  		    		 }
  		    		 if(caractAux.getAngulacion()!=null && !caractAux.getAngulacion().equals("") && codigos[7]!="")
  		    		 {
  		    		 	 sb.append(captions[9]).append(" (").append(terminosTrad[indice].getNomTermino()).append("),");
  		    		 	 indice++;
  		    		 }

  		    		 textoDescIJ=sb.toString();
  		    		 textoDescIJ= textoDescIJ.substring(0,textoDescIJ.length()-1);// le quito la ultima coma
  		    	 }else
  		    	 {
  		    		textoDescIJ=(textoDescripciones[i].get(j)!=null?textoDescripciones[i].get(j):"").toString();
  		    	 }
  		    	 langDesc.setTexto(textoDescIJ.trim());

  		    	 aLangDesc[j] = langDesc;
  		     }
  		   descVO.setTextos(aLangDesc);
  	  	 } else {
  	  		 LangStringVO[] aLangString=new LangStringVO[1];
  	  		 LangStringVO langString = new LangStringVO();
  	  		 langString.setIdioma("");
  	  		 langString.setTexto("");
  	  		 aLangString[0]= langString;
  	  		 descVO.setTextos(aLangString);
  	  	 }
  		 descripciones[i]=descVO;
  	  	}
  	
  	//palabras clave
  
           for(int i=0;i<textoPalabrasClave.length;i++){
        	   PalabraClaveVO pClaVO = new PalabraClaveVO();
	           if (textoPalabrasClave[i]!=null) {
			         LangStringVO[] aLangPCla = new LangStringVO[textoPalabrasClave[i].size()];
			         for (int j = 0; j<textoPalabrasClave[i].size();j++){
			        	 LangStringVO langPCla= new LangStringVO();
			        	 String textoPalClaveIJ=(textoPalabrasClave[i].get(j)!=null?textoPalabrasClave[i].get(j):"").toString();
			        	 langPCla.setTexto(textoPalClaveIJ.trim());
			        	 String idiomaPalClaveIJ=(idiomaPalabrasClave[i].get(j)!=null?idiomaPalabrasClave[i].get(j):"").toString();
			        	 langPCla.setIdioma(idiomaPalClaveIJ);
			        	 aLangPCla[j] = langPCla;
			         }
			         pClaVO.setTextos(aLangPCla);
			              
	           }else {
	        	   LangStringVO[] aLangString=new LangStringVO[1];
	        	   LangStringVO langString = new LangStringVO();
	        	   langString.setIdioma("");
	        	   langString.setTexto("");
	        	   aLangString[0]= langString;
	        	   pClaVO.setTextos(aLangString);
	           }
	           palabrasClave[i]=pClaVO;
           }
  //         form.setPalabrasClaveAsArray(palabrasClave); 
  	//ambitos
       
       for(int i=0;i<textoAmbito.length;i++){
    	   AmbitoVO ambVO = new AmbitoVO();
  	  	 if (textoAmbito[i]!=null) {
  		     LangStringVO[] aLangAmb = new LangStringVO[textoAmbito[i].size()];
  		     for (int j = 0; j<textoAmbito[i].size();j++){
  		    	 LangStringVO langAmb= new LangStringVO();
  		    	 String textoAmbitoIJ=(textoAmbito[i].get(j)!=null?textoAmbito[i].get(j):"").toString();
  		    	 langAmb.setTexto(textoAmbitoIJ.trim());
  		    	 String idiomaAmbitoIJ=(idiomaAmbito[i].get(j)!=null?idiomaAmbito[i].get(j):"").toString();
  		    	 langAmb.setIdioma(idiomaAmbitoIJ);
  		    	 aLangAmb[j] = langAmb;
  		     }
  		     ambVO.setTextos(aLangAmb);
  		    
  	  	 }else {
  	  		LangStringVO[] aLangString=new LangStringVO[1];
  	  		LangStringVO langString = new LangStringVO();
  	  		langString.setIdioma("");
  	  		langString.setTexto("");
  	  		aLangString[0]= langString;
  	  		ambVO.setTextos(aLangString);
  	  	 }
  	     ambitos[i]=ambVO;
       }
    //       form.setAmbitosAsArray(ambitos);
    }
	
private void dameTerminoId() throws Exception{
	
    //titulos
	ArrayList idsTit = new ArrayList();
    LangStringVO[] langTitulo =titulos[0].getTextos();
    for ( int i=0;i<langTitulo.length;i++){
    	idsTit.add(langTitulo[i].getIdioma());
    }
    
    TerminoYPadreVO[] terminosTraducTit= null;
    if (langTitulo.length>0){
    	String[] arrayIdsTit = (String[])idsTit.toArray(new String[idsTit.size()]);
        terminosTraducTit = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsTit);
    }
    else{
    	if (langTitulo.length==0){
    		TerminoYPadreVO typ= new TerminoYPadreVO();
    		typ.setIdiomaTermino("");
    		typ.setIdTermino("");
    		typ.setIdVocabulario("");
    		typ.setNomTermino("");
    		ArrayList typArray= new ArrayList();
    		typArray.add(typ);
    		terminosTraducTit= (TerminoYPadreVO[]) typArray.toArray(new TerminoYPadreVO[typArray.size()]);
    	}
    }
    if (terminosTraducTit!= null){
    	int jTit= 0;
        for (int cont=0;cont<terminosTraducTit.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
        	
    		boolean enc=false; 		
    		while(!enc && jTit<langTitulo.length){
    			if (langTitulo[jTit].getIdioma().equals("")){
    				jTit++; 
    			}
    			else{
    				enc = true;
    				langTitulo[jTit].setIdioma(terminosTraducTit[cont].getNomTermino());
    				jTit++;
    			}
    		}	
        }
    }
    
    ArrayList idsDesc = new ArrayList();
    
    for ( int i=0;i<descripciones.length;i++ ){
    	LangStringVO[] langDescripcion = descripciones[i].getTextos();
    	for ( int j=0;j<langDescripcion.length;j++){
    		
    		String idioma = (String) listaIdiomas.get(langDescripcion[j].getIdioma());
    		if (idioma!=null)
    		{
    			langDescripcion[j].setIdioma(idioma);
    		}
    		
//	    	idsDesc.add(langDescripcion[j].getIdioma());
	    	
//	    	TerminoYPadreVO[] terminosTraducDesc= null;
//	    	if (langDescripcion.length > 0){
//	    		String[] arrayIdsDesc = (String[])idsDesc.toArray(new String[idsDesc.size()]);
//		        terminosTraducDesc = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsDesc);
//	    	}
//	    	else{
//	    		if (langDescripcion.length == 0){
//	    			TerminoYPadreVO typ= new TerminoYPadreVO();
//	        		typ.setIdiomaTermino("");
//	        		typ.setIdTermino("");
//	        		typ.setIdVocabulario("");
//	        		typ.setNomTermino("");
//	        		ArrayList typArray= new ArrayList();
//	        		typArray.add(typ);
//	        		terminosTraducDesc= (TerminoYPadreVO[]) typArray.toArray(new TerminoYPadreVO[typArray.size()]);
//	    		}
//	    	}
//	        
//	        if (terminosTraducDesc!= null){
//	        	int jDesc= 0;
//		        for (int cont=0;cont<terminosTraducDesc.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
//		        	
//		    		boolean enc=false; 		
//		    		while(!enc && jDesc<langDescripcion.length){
//		    			if (langDescripcion[jDesc].getIdioma().equals("")){
//		    				jDesc++; 
//		    			}
//		    			else{
//		    				enc = true;
//		    				langDescripcion[jDesc].setIdioma(terminosTraducDesc[cont].getNomTermino());
//		    				jDesc++;
//		    			}
//		    		}	
//		        }
//	        }
	        
        }
        descripciones[i].setTextos(langDescripcion);
    }
    
    //PALABRAS CLAVE
    
  ArrayList idsPCla = new ArrayList();
    
  for ( int i=0;i<palabrasClave.length;i++ ){
	LangStringVO[] langPalabrasClave = palabrasClave[i].getTextos();
	for ( int j=0;j<langPalabrasClave.length;j++){
		idsPCla.add(langPalabrasClave[j].getIdioma());
    	
		TerminoYPadreVO[] terminosTraducPCla= null;
		if (langPalabrasClave.length>0){
			String[] arrayIdsPCla = (String[])idsPCla.toArray(new String[idsPCla.size()]);
	        terminosTraducPCla = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsPCla);
		}
		else{
			if (langPalabrasClave.length==0){
				TerminoYPadreVO typ= new TerminoYPadreVO();
        		typ.setIdiomaTermino("");
        		typ.setIdTermino("");
        		typ.setIdVocabulario("");
        		typ.setNomTermino("");
        		ArrayList typArray= new ArrayList();
        		typArray.add(typ);
        		terminosTraducPCla= (TerminoYPadreVO[]) typArray.toArray(new TerminoYPadreVO[typArray.size()]);
			}
		}
        
        if (terminosTraducPCla!=null){
        	int jPCla= 0;
            for (int cont=0;cont<terminosTraducPCla.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
            	
        		boolean enc=false; 		
        		while(!enc && jPCla<langPalabrasClave.length){
        			if (langPalabrasClave[jPCla].getIdioma().equals("")){
        				jPCla++; 
        			}
        			else{
        				enc = true;
        				langPalabrasClave[jPCla].setIdioma(terminosTraducPCla[cont].getNomTermino());
        				jPCla++;
        			}
        		}	
            }
        }
        
        }
        palabrasClave[i].setTextos(langPalabrasClave);
    }
    
    
    


  
  ArrayList idsAmb = new ArrayList();
  
  for ( int i=0;i<ambitos.length;i++ ){
  	LangStringVO[] langAmbitos = ambitos[i].getTextos();
  	for ( int j=0;j<langAmbitos.length;j++){
  		idsAmb.add(langAmbitos[j].getIdioma());
    	
  		TerminoYPadreVO[] terminosTraducAmb= null;
  		if (langAmbitos.length>0){
  			String[] arrayIdsAmb = (String[])idsAmb.toArray(new String[idsAmb.size()]);
  	        terminosTraducAmb = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsAmb);
  		}
  		else{
  			if (langAmbitos.length==0){
  				TerminoYPadreVO typ= new TerminoYPadreVO();
        		typ.setIdiomaTermino("");
        		typ.setIdTermino("");
        		typ.setIdVocabulario("");
        		typ.setNomTermino("");
        		ArrayList typArray= new ArrayList();
        		typArray.add(typ);
        		terminosTraducAmb= (TerminoYPadreVO[]) typArray.toArray(new TerminoYPadreVO[typArray.size()]);
  			}
  		}
        
        if (terminosTraducAmb!=null){
        	int jAmb= 0;
            for (int cont=0;cont<terminosTraducAmb.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
            	
        		boolean enc=false; 		
        		while(!enc && jAmb<langAmbitos.length){
        			if (langAmbitos[jAmb].getIdioma().equals("")){
        				jAmb++; 
        			}
        			else{
        				enc = true;
        				langAmbitos[jAmb].setIdioma(terminosTraducAmb[cont].getNomTermino());
        				jAmb++;
        			}
        		}	
            }
        }
        
        }
        ambitos[i].setTextos(langAmbitos);
    }
  
  
    ArrayList idsIdio = new ArrayList();
	for ( int i=0;i<idiomas.length;i++){
		idsIdio.add(idiomas[i].getTexto());
	}

	TerminoYPadreVO[] terminosTraducIdio= null;
	if (idiomas.length>0){
		String[] arrayIdsIdio = (String[])idsIdio.toArray(new String[idsIdio.size()]);
	    terminosTraducIdio = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsIdio);
	}
	else{
		if (idiomas.length==0){
			TerminoYPadreVO typ= new TerminoYPadreVO();
    		typ.setIdiomaTermino("");
    		typ.setIdTermino("");
    		typ.setIdVocabulario("");
    		typ.setNomTermino("");
    		ArrayList typArray= new ArrayList();
    		typArray.add(typ);
    		terminosTraducIdio= (TerminoYPadreVO[]) typArray.toArray(new TerminoYPadreVO[typArray.size()]);
		}
	}
	
	if (terminosTraducIdio != null){
		int jIdio= 0;
	    for (int cont=0;cont<terminosTraducIdio.length;cont++){//Cambiado el identificador del termino al nombre del termino en ingles
	    	
			boolean enc=false; 		
			while(!enc && jIdio<idiomas.length){
				if (idiomas[jIdio].getTexto().equals("")){
					jIdio++; 
				}
				else{
					enc = true;
					idiomas[jIdio].setTexto(terminosTraducIdio[cont].getNomTermino());
					jIdio++;
				}
			}	
	    }
	}
    
    ArrayList idsEstYNivel = new ArrayList();
    idsEstYNivel.add(estructura);
    idsEstYNivel.add(nivelAgregacion);
    String[] arrayIdsEstructuraYNivel = (String[])idsEstYNivel.toArray(new String[idsEstYNivel.size()]);
    TerminoYPadreVO[] terminosTraducEstructuraYNivel = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(arrayIdsEstructuraYNivel);
    if (!estructura.equals("")){
    	estructura=terminosTraducEstructuraYNivel[0].getNomTermino();
    	if (!nivelAgregacion.equals(""))
    		nivelAgregacion =terminosTraducEstructuraYNivel[1].getNomTermino();
    }
    else if (!nivelAgregacion.equals(""))
		nivelAgregacion =terminosTraducEstructuraYNivel[0].getNomTermino();   
}







public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	
}






public void cargarGeneralValidar(
		ActionMapping mapping, 
		CargarGeneralValidarForm form, 
		HttpServletRequest request, 
		HttpServletResponse response) 
throws Exception 
{
//	Object valor = request.getSession().getAttribute("form");
	//
	cargarCombos(form, request);
	
	AvGeneralVO gn= this.getCatalogadorAvSession(request).getLomValidacion().getGeneral();
	form.setIdentificadoresAsArray(gn.getIdentificadores());
		TituloVO[] arrayTit= new TituloVO[1];
		arrayTit[0]=gn.getTitulo();
	form.setTitulosAsArray(arrayTit);
	
	form.setIdiomasAsArray(gn.getIdiomas());
	
	form.setDescripcionesAsArray(gn.getDescripciones());
	form.setPalabrasClaveAsArray(gn.getPalabrasClave());
	form.setAmbitosAsArray(gn.getAmbitos());
	form.setEstructura(gn.getEstructura().getValor());
	form.setNivelAgregacion(gn.getNivelAgregacion().getValor());
}



private void cargarCombos(
		CargarGeneralValidarForm form, 
		HttpServletRequest request)
throws Exception
{
	

InputStream is = null;
Properties prop = new Properties();
boolean bandera=false;

//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

try{
	int longVocabulario = 0;
	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	is = this.getClass().getResourceAsStream("/catalogadorAvanzado.properties");
	prop.load(is);
	String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
  

	//comprobamos que el objeto de sesion no sea null, si es null nos creamos uno	
	if (catalogadorAvSession.getMDSesion() == null){
		LomAvanzadoVO mdSession = new LomAvanzadoVO();
		catalogadorAvSession.setMDSesion(mdSession);
	}	
	//comprobamos que general no se ha null, si es null nos creamos uno	
	boolean generalEsNull = false;
	if (catalogadorAvSession.getMDSesion().getGeneral() == null){
		AvGeneralVO general = new AvGeneralVO();
		catalogadorAvSession.getMDSesion().setGeneral(general);
		generalEsNull=true;
	}
	
	
	//Carga del formulario (ahora desde el objeto de session)(Los combos y lo que debe pintarse)
	String[] l_id = { prop.getProperty("idioma"),prop.getProperty("estructura"),prop.getProperty("nivelDeAgregacion"),prop.getProperty("idiomaDestinatario"),prop.getProperty("caracteristicas.color"),prop.getProperty("caracteristicas.bandaSonora"),prop.getProperty("caracteristicas.formato"),prop.getProperty("caracteristicas.tipoPlano"),prop.getProperty("caracteristicas.luz"),prop.getProperty("caracteristicas.estructuraFormal"),prop.getProperty("caracteristicas.angulacion"),prop.getProperty("caracteristicas.dimension")};
	VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(l_id,idiomaLdap);
	//guardo una lista de los idiomas con sus correspondientes codigos
//	Map listaIdiomas = new HashMap();
//	for (int i = 0; i < vocabulario[3].getTerminos().length; i++) {
//		listaIdiomas.put(vocabulario[3].getTerminos()[i].getIdTermino(), vocabulario[3].getTerminos()[i].getNomTermino());
//	}
	
	//vamos a ordenar vocabulario
	UtilidadesOrdenarCombos vocabulariosOrdDest1 = new UtilidadesOrdenarCombos();
	VocabularioVO[] vocabularioOrdenado = vocabulariosOrdDest1.ordenarVocabulariosVO(vocabulario);

	longVocabulario = vocabularioOrdenado.length;//Cargamos los combos de idioma, la estructura y el nivel de agregacion
	TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
	ArrayList terminoypadrear=new ArrayList();
	
	Collection id = new ArrayList();
	Collection idDest = new ArrayList();
	
	UtilidadesOrdenarCombos uoc = new UtilidadesOrdenarCombos();
	Iterator itDest=null;
	TerminoVO[] tod=null;
	
	for (int x = 0; x < longVocabulario; x++) {
		TerminoVO terminoVO = new TerminoVO();
		terminoVO.setIdiomaTermino("");
		terminoVO.setIdTermino("");
		terminoVO.setNomTermino("");

		switch (x) {
		case 0:
			
			id.add(terminoVO);
//			modificamos las cadenas de idiomas
			TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
			
			for (int li=0; li<terminos.length;li++){
				TerminoVO idAux = new TerminoVO();
				idAux=terminos[li];
				String textoIdioma= idAux.getNomTermino();
				String idiomasTra="";
				if(!textoIdioma.equals("x-none")){
					idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
				}else{
					idiomasTra=datosResources.getString("x-none");
				}
				idAux.setNomTermino(idiomasTra);
			}
			
			TerminoVO[] terminosOrd = uoc.ordenarTerminosVO(terminos, idiomaLdap);
			itDest= Arrays.asList(terminosOrd).iterator();
			while (itDest.hasNext()) {
				id.add(itDest.next());
			}

			if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getIdiomas() !=null)
					&& (catalogadorAvSession.getMDSesion().getGeneral().getIdiomas().length>0)) {
				IdiomaVO[] idiomasVO =catalogadorAvSession.getMDSesion().getGeneral().getIdiomas();
				for(int j=0;j<idiomasVO.length;j++){
					terminoypadreVO = new TerminoYPadreVO();
					terminoypadreVO.setIdiomaTermino("en");
					terminoypadreVO.setIdVocabulario(l_id[x]);
					terminoypadreVO.setIdTermino("");
					terminoypadreVO.setNomTermino(idiomasVO[j].getTexto());
					terminoypadrear.add(terminoypadreVO);
				}//terminoYPadreVO rellenado con los idiomas desde el lom avanzado
			}
			else {
				terminoypadreVO = new TerminoYPadreVO();
				terminoypadreVO.setIdiomaTermino("en");
				terminoypadreVO.setIdVocabulario(l_id[x]);
				terminoypadreVO.setIdTermino("");
				terminoypadreVO.setNomTermino("");
				terminoypadrear.add(terminoypadreVO);
			}
			
			break;
		case 1:
			Collection tEstructura = new ArrayList();
			tEstructura.add(terminoVO);
//			Collection tEstructura2 = Arrays.asList(vocabularioOrdenado[x].getTerminos());
//			Iterator cont = tEstructura2.iterator();
			
			itDest = Arrays.asList(vocabularioOrdenado[x].getTerminos()).iterator();
			while (itDest.hasNext()) {
				tEstructura.add(itDest.next());
			}
			form.setEstructuraBackingList(tEstructura, "idTermino", "nomTermino");
			terminoypadreVO = new TerminoYPadreVO();
			terminoypadreVO.setIdiomaTermino("en");
			terminoypadreVO.setIdVocabulario(l_id[x]);
			terminoypadreVO.setIdTermino("");
			if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getEstructura() !=null)) {
				terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getGeneral().getEstructura().getValor());//terminoYPadre rellenado con estructura desde el lom avanzado
				terminoypadrear.add(terminoypadreVO);
			} else {
				terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con estructura desde el formulario
				terminoypadrear.add(terminoypadreVO);
			}
			
			break;
		case 2:
			Collection tNivelDeAgregacion = new ArrayList();
			tNivelDeAgregacion.add(terminoVO);

			itDest = Arrays.asList(vocabularioOrdenado[x].getTerminos()).iterator();
			while (itDest.hasNext()) {
				tNivelDeAgregacion.add(itDest.next());
			}
			form.setNivelAgregacionBackingList(tNivelDeAgregacion, "idTermino", "nomTermino");
			terminoypadreVO = new TerminoYPadreVO();
			terminoypadreVO.setIdiomaTermino("en");
			terminoypadreVO.setIdVocabulario(l_id[x]);
			terminoypadreVO.setIdTermino("");
			if ((catalogadorAvSession.getMDSesion().getGeneral() != null)&&(catalogadorAvSession.getMDSesion().getGeneral().getNivelAgregacion() !=null)) {
				terminoypadreVO.setNomTermino(catalogadorAvSession.getMDSesion().getGeneral().getNivelAgregacion().getValor());//terminoYPadre rellenado con nivel de agregacion desde el lom avanzado
				terminoypadrear.add(terminoypadreVO);
			} else {
				terminoypadreVO.setNomTermino("");//terminoYPadre rellenado con nivel de agregacion desde el formulario
				terminoypadrear.add(terminoypadreVO);
			}
			
			break;
		case 3:
			idDest.add(terminoVO);
//			modificamos las cadenas de idiomas
			TerminoVO[] terminosDest = vocabularioOrdenado[x].getTerminos();
			for (int li=0; li<terminosDest.length;li++){
				TerminoVO idAux = new TerminoVO();
				idAux=terminosDest[li];
				String textoIdioma= idAux.getNomTermino();
				String idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idiomaLdap);
				idAux.setNomTermino(idiomasTra);
			}

//			UtilidadesOrdenarCombos terminosOrdDest2 = new UtilidadesOrdenarCombos();
			TerminoVO[] terminosOrdDest = uoc.ordenarTerminosVO(terminosDest, idiomaLdap);
			
			itDest = Arrays.asList(terminosOrdDest).iterator();
			while (itDest.hasNext()) {
				idDest.add(itDest.next());
			}
			form.setComboIdiomaBackingList(idDest, "idTermino", "nomTermino");
			
			break;
		case 4://Caracteristicas : Modo Color
			Collection listaColor= new ArrayList();
			listaColor.add(terminoVO);
			TerminoVO[] caractColor = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractColor, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaColor.add(itDest.next());
			}
			form.setComboCaractColorBackingList(listaColor, "idTermino", "nomTermino");
			
			break;
		case 5://Caracteristicas : Banda Sonora
			Collection listaBanda= new ArrayList();
			listaBanda.add(terminoVO);
			TerminoVO[] caractModos = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractModos, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaBanda.add(itDest.next());
			}
			form.setComboCaractBandaSonoraBackingList(listaBanda, "idTermino", "nomTermino");
			
			break;
		case 6://Caracteristicas : Formato
			Collection listaFormatos= new ArrayList();
			listaFormatos.add(terminoVO);
			TerminoVO[] caractFormatos = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractFormatos, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaFormatos.add(itDest.next());
			}
			form.setComboCaractFormatoBackingList(listaFormatos, "idTermino", "nomTermino");
			
			break;
		case 7://Caracteristicas : Tipo de plano
			Collection listaPlanos= new ArrayList();
			listaPlanos.add(terminoVO);
			TerminoVO[] caractPlanos = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractPlanos, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaPlanos.add(itDest.next());
			}
			form.setComboCaractTipoPlanoBackingList(listaPlanos, "idTermino", "nomTermino");
			
			break;
		case 8://Caracteristicas : Luz
			Collection listaLuz= new ArrayList();
			listaLuz.add(terminoVO);
			TerminoVO[] caractLuz = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractLuz, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaLuz.add(itDest.next());
			}
			form.setComboCaractLuzBackingList(listaLuz, "idTermino", "nomTermino");
			
			break;
		case 9://Caracteristicas : Estructura formal
			Collection listaEstructuras= new ArrayList();
			listaEstructuras.add(terminoVO);
			TerminoVO[] caractEstructuras = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractEstructuras, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaEstructuras.add(itDest.next());
			}
			form.setComboCaractEstructuraFormalBackingList(listaEstructuras, "idTermino", "nomTermino");
			
			break;
		case 10://Caracteristicas : Angulación
			Collection listaAngulacion= new ArrayList();
			listaAngulacion.add(terminoVO);
			TerminoVO[] caractAngulacion = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractAngulacion, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaAngulacion.add(itDest.next());
			}
			form.setComboCaractAngulacionBackingList(listaAngulacion, "idTermino", "nomTermino");
			
			break;
		case 11://Caracteristicas : Dimensión
			Collection listaDimensiones= new ArrayList();
			listaDimensiones.add(terminoVO);
			TerminoVO[] caractDimensiones = vocabularioOrdenado[x].getTerminos();
			tod = uoc.ordenarTerminosVO(caractDimensiones, idiomaLdap);
			
			itDest = Arrays.asList(tod).iterator();
			while (itDest.hasNext()) {
				listaDimensiones.add(itDest.next());
			}
			form.setComboCaractDimensionBackingList(listaDimensiones, "idTermino", "nomTermino");
			
			break;
		}
		
		
		if( logger.isDebugEnabled() ){

            logger.debug("Cargados los combos del formulario" );
		}

	}

	logger.debug("Cargados los combos");

		
		TerminoYPadreVO[] arrayTerminoYPadre=(TerminoYPadreVO[])terminoypadrear.toArray(new TerminoYPadreVO[terminoypadrear.size()]);

		TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arrayTerminoYPadre);
		//Dividimos los y idiomas de la estructura y el nivel de educación
		ArrayList arrayIdioma=new ArrayList();
		ArrayList arrays=new ArrayList();
		for(int k=0;k<terminoYPadreVuelta.length;k++){
			String idPadre=terminoYPadreVuelta[k].getIdVocabulario();
			if(arrayIdioma.size()==0){
				arrayIdioma.add(terminoYPadreVuelta[k]);
			}else{
				if(idPadre.equals(((TerminoYPadreVO)arrayIdioma.get(0)).getIdVocabulario())){
					arrayIdioma.add(terminoYPadreVuelta[k]);
				}else {
					
					arrays.add(terminoYPadreVuelta[k]);
				}
			}
		}
		TerminoYPadreVO[] idiomasTP=(TerminoYPadreVO[])arrayIdioma.toArray(new TerminoYPadreVO[arrayIdioma.size()]);
		TerminoYPadreVO[] estructuraYNivel=(TerminoYPadreVO[])arrays.toArray(new TerminoYPadreVO[arrays.size()]);
		
		//IDIOMAS
		IdiomaVO[] aNuevoIdiomasVO =null;
		IdiomaVO[] aIdiomasVO =catalogadorAvSession.getMDSesion().getGeneral().getIdiomas();
		if (aIdiomasVO != null && (aIdiomasVO.length>0) ){ //&& !(aIdiomasVO.length==1 && aIdiomasVO[0].getTexto().equals(""))
			aNuevoIdiomasVO = new IdiomaVO[catalogadorAvSession.getMDSesion().getGeneral().getIdiomas().length];
			for (int idi = 0; idi<idiomasTP.length; idi++) {
				IdiomaVO idioma = new IdiomaVO();
				idioma.setTexto(idiomasTP[idi].getIdTermino());
				aNuevoIdiomasVO[idi]=idioma;
            }
		}
		else{
			aNuevoIdiomasVO = new IdiomaVO[1];
			IdiomaVO idioma = new IdiomaVO();
			idioma.setTexto("");
			aNuevoIdiomasVO[0]=idioma;
		}
        form.setIdiomasAsArray(aNuevoIdiomasVO);
        form.setIdiomasBackingList(id, "idTermino", "nomTermino");

		//caracteristicas
        Caracteristica[][] lCaracteristicas= new Caracteristica[descripciones.length][];
		I18n i18n= I18n.getInstance();
		
		for (int i = 0; i < descripciones.length; i++) {
			LangStringVO[] listaTextos = descripciones[i].getTextos();
			Caracteristica[] arrayCaract = new Caracteristica[listaTextos.length];
			for (int j = 0; j < listaTextos.length; j++) {
				String idioma=(String)  listaIdiomas.get( listaTextos[j].getIdioma() );
				if(idioma!=null)
				{
					String[] captions = i18n.getResource("caracteristicas.captions", "application-resources" , new Locale(idioma)).split(",");
					arrayCaract[j]= Caracteristica.getInstance(listaTextos[j].getTexto(), captions);
					TerminoYPadreVO[] arraytyp= new TerminoYPadreVO[8];
					if(arrayCaract[j]!=null && !arrayCaract[j].getVacio())
					{
						
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.2");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getDimension());
						arraytyp[0]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.3");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getModoColor());
						arraytyp[1]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.4");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getBandaSonora());
						arraytyp[2]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.5");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getFormato());
						arraytyp[3]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.6");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getTipoPlano());
						arraytyp[4]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.7");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getLuz());
						arraytyp[5]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.8");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getEstructuraFormal());
						arraytyp[6]= terminoypadreVO;
						terminoypadreVO = new TerminoYPadreVO();
						terminoypadreVO.setIdiomaTermino(idioma);
						terminoypadreVO.setIdVocabulario("1.4.9");
						terminoypadreVO.setIdTermino("");
						terminoypadreVO.setNomTermino(arrayCaract[j].getAngulacion());
						arraytyp[7]= terminoypadreVO;

						TerminoYPadreVO[] typVuelta = this.getSrvVocabulariosControladosService().obtenerIdTermino(arraytyp);
						
						
						arrayCaract[j].setDimension(typVuelta[0].getIdTermino());
						arrayCaract[j].setModoColor(typVuelta[1].getIdTermino());
						arrayCaract[j].setBandaSonora(typVuelta[2].getIdTermino());
						arrayCaract[j].setFormato(typVuelta[3].getIdTermino());
						arrayCaract[j].setTipoPlano(typVuelta[4].getIdTermino());
						arrayCaract[j].setLuz(typVuelta[5].getIdTermino());
						arrayCaract[j].setEstructuraFormal(typVuelta[6].getIdTermino());
						arrayCaract[j].setAngulacion(typVuelta[7].getIdTermino());
					}						
				}else
					arrayCaract[j]= Caracteristica.getInstance(listaTextos[j].getTexto(), null);
			}
			
			lCaracteristicas[i]= arrayCaract;
		}
        
		form.setCaracteristicasAsArray(lCaracteristicas);

        
        
        //si general era null en el objeto de session lo dejamos a null
        if(generalEsNull)
        	catalogadorAvSession.getMDSesion().setGeneral(null);
        
		}catch(Exception e){
			
		}
	}


	private String obtenerAccion(HttpServletRequest request) 
	throws Exception
	{
		String accion="";
		String[] partes;
		for (Enumeration names = request.getParameterNames();accion.equals("") && names.hasMoreElements();)
	       {
	      	 String name = String.valueOf(names.nextElement());
	           if(name.startsWith("accion"))
	           {
	        	 partes= name.split("_");
	        	 if(partes.length>0){
	        		 String anadidos=partes[1];
	        		 for(int i=2;i<partes.length;i++){
	        			 anadidos=anadidos+"_"+partes[i];
	        		 }
	        	 accion=anadidos;
	        	 }
	        	 
	        	 
	        	}
		
	        }
		return accion;
	}





	public void reset(
			ActionMapping mapping, 
			ResetForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		try{
			Object valor = request.getSession().getAttribute("form");
			CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
			//si el identificador de la sesion es null, entonces lanzamos la excepcion de fin de sesion, 
			//ya que todos los combos se quedan vacios y da error 
			if ((catalogadorAvSession == null) || (catalogadorAvSession.getIdentificador()==null)) {
				throw new Exception();
			}
			
			if (valor instanceof GeneralFormImpl) {
				GeneralFormImpl formulario=(GeneralFormImpl)valor;
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof GeneralFormSubmitFormImpl) {
				GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof ValidoGeneralVolverFormImpl) {
				ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
				NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
		      	form.setAmbitos(formulario.getAmbitos());
		      	form.setDescripciones(formulario.getDescripciones());
		      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
		      	form.setEstructuraValueList(formulario.getEstructuraValueList());
		      	form.setIdentificadores(formulario.getIdentificadores());
		      	form.setIdiomas(formulario.getIdiomas());
		      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
		      	form.setIdiomasValueList(formulario.getIdiomasValueList());
		      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
		      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
		      	form.setPalabrasClave(formulario.getPalabrasClave());
		      	form.setTitulos(formulario.getTitulos());
		      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
		      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
		      	
		      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
		      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
		      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
		      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
		      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
		      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
		      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
		      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
		      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
		      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
		      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
		      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
		      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
		      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
		      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
		      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
			}
			
			//IDENTIFICADORES
			IdentificadorVO[] aIdentificadores = new IdentificadorVO[1];
	    	IdentificadorVO identificadorVO=new IdentificadorVO();
	    	identificadorVO.setCatalogo("");
	    	identificadorVO.setEntrada("");
	    	aIdentificadores[0]=identificadorVO;
	    	form.setIdentificadoresAsArray(aIdentificadores);
	    	
			//TITULOS
			LangStringVO[] nuevolangTextosTitulo = new LangStringVO[1];
			LangStringVO lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			nuevolangTextosTitulo[0] = lang;
			TituloVO tituloVO= new TituloVO();
			tituloVO.setTextos(nuevolangTextosTitulo);
			TituloVO[] aTituloVO= new TituloVO[1];
			aTituloVO[0]=tituloVO;
			form.setTitulosAsArray(aTituloVO);
			
			//IDIOMAS
			IdiomaVO[] aNuevoIdiomasVO =null;
			aNuevoIdiomasVO = new IdiomaVO[1];
			IdiomaVO idioma = new IdiomaVO();
			idioma.setTexto("");
			aNuevoIdiomasVO[0]=idioma;
	        form.setIdiomasAsArray(aNuevoIdiomasVO);
			
			//DESCRIPCIONES
	        
			DescripcionVO[] nuevoDescripcionVO = new DescripcionVO[1];
			LangStringVO[] aLangString =new LangStringVO[1];
			lang = new LangStringVO();
			lang.setIdioma("");
			lang.setTexto("");
			aLangString[0]=lang;
			DescripcionVO descVO= new DescripcionVO();
			descVO.setTextos(aLangString);
			nuevoDescripcionVO[0] = descVO;
			form.setDescripcionesAsArray(nuevoDescripcionVO);
			
			Caracteristica[][] lCaracteristicas= new Caracteristica[1][];
			Caracteristica[] caracteristicas = new Caracteristica[1];
			caracteristicas[0]= Caracteristica.getInstance("", null);
			lCaracteristicas[0]=caracteristicas;
			
			form.setCaracteristicasAsArray(lCaracteristicas);
			
			//PALABRAS CLAVE
			LangStringVO[] nuevoLangTextosPal = new LangStringVO[1];
			LangStringVO nuevoLangPal = new LangStringVO();
			nuevoLangPal.setIdioma("");
			nuevoLangPal.setTexto("");
			nuevoLangTextosPal[0]= nuevoLangPal;
			PalabraClaveVO pClaVO=new PalabraClaveVO();
			pClaVO.setTextos(nuevoLangTextosPal);
			
			PalabraClaveVO[] aPalabrasClave= new PalabraClaveVO[1];
			aPalabrasClave[0]=pClaVO;
			form.setPalabrasClaveAsArray(aPalabrasClave);;
			
			//AMBITOS
			AmbitoVO[] ambitos = new AmbitoVO[1];
			LangStringVO[] nuevoLangTextosAmb = new LangStringVO[1];
			LangStringVO nuevoLangAmb =new LangStringVO();
			nuevoLangAmb.setIdioma("");
			nuevoLangAmb.setTexto("");
			nuevoLangTextosAmb[0]= nuevoLangAmb;
	
			AmbitoVO ambVO= new AmbitoVO();
			ambVO.setTextos(nuevoLangTextosAmb);
			ambitos[0]=ambVO;
	        form.setAmbitosAsArray(ambitos);
			
			//ESTRUCTURAS
			form.setEstructura("");
			
			//NIVEL AGREGACION
			form.setNivelAgregacion("");
		
		}catch (org.acegisecurity.AccessDeniedException ad) {
	   	   	logger.error("Error de Acceso " + ad);
		   	throw new Exception("general",ad);
	    }catch (Exception e) {
			logger
			.error("Error en Servicio de catalogacionWeb, categoría General, método reset " + e);
			throw new Exception("general",e);
	    }
		
 	}






	public void anadirCaracteristica(
			ActionMapping mapping,
			AnadirCaracteristicaForm form, 
			HttpServletRequest request,
			HttpServletResponse response) 
	throws Exception 
	{

   	 try{
        	Object valor = request.getSession().getAttribute("form");
           
   		if (valor instanceof GeneralFormImpl) {
   			GeneralFormImpl formulario=(GeneralFormImpl)valor;
   	      	form.setAmbitos(formulario.getAmbitos());
   	      	form.setDescripciones(formulario.getDescripciones());
   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
   	      	form.setIdentificadores(formulario.getIdentificadores());
   	      	form.setIdiomas(formulario.getIdiomas());
   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
   	      	form.setPalabrasClave(formulario.getPalabrasClave());
   	      	form.setTitulos(formulario.getTitulos());
   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
   	      	
   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
   		} else if (valor instanceof GeneralFormSubmitFormImpl) {
   			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
   	      	form.setAmbitos(formulario.getAmbitos());
   	      	form.setDescripciones(formulario.getDescripciones());
   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
   	      	form.setIdentificadores(formulario.getIdentificadores());
   	      	form.setIdiomas(formulario.getIdiomas());
   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
   	      	form.setPalabrasClave(formulario.getPalabrasClave());
   	      	form.setTitulos(formulario.getTitulos());
   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
   	      	
   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
   		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
   			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
   	      	form.setAmbitos(formulario.getAmbitos());
   	      	form.setDescripciones(formulario.getDescripciones());
   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
   	      	form.setIdentificadores(formulario.getIdentificadores());
   	      	form.setIdiomas(formulario.getIdiomas());
   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
   	      	form.setPalabrasClave(formulario.getPalabrasClave());
   	      	form.setTitulos(formulario.getTitulos());
   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
   	      	
   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
   		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
   			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
   	      	form.setAmbitos(formulario.getAmbitos());
   	      	form.setDescripciones(formulario.getDescripciones());
   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
   	      	form.setIdentificadores(formulario.getIdentificadores());
   	      	form.setIdiomas(formulario.getIdiomas());
   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
   	      	form.setPalabrasClave(formulario.getPalabrasClave());
   	      	form.setTitulos(formulario.getTitulos());
   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
   	      	
   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
   		}

   		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
   		for(int i= 0;i< form.getDescripciones().size();i++){
   			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
   		}
   		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
   		for(int i= 0;i< form.getPalabrasClave().size();i++){
   			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
   		}
   		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
   		for(int i= 0;i< form.getAmbitos().size();i++){
   			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
   		}
   	  	int longitudDescripciones=form.getDescripciones().size();
   	  	int longitudPalabrasClave=form.getPalabrasClave().size();
   	  	int longitudAmbitos=form.getAmbitos().size();
   	  	int longitudIdentificadores=form.getIdentificadores().size();
   	  	int longitudIdiomas=form.getIdiomas().size();
   	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
   	  	
   	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
   				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
   				longitudIdiomas,longitudTitulo);

          //identificadores
          form.setIdentificadoresAsArray(identificadores);
          //titulo
          form.setTitulosAsArray(titulos);        
          //idioma
          form.setIdiomasAsArray(idiomas);
          //descripciones
          form.setDescripcionesAsArray(descripciones);
          form.setCaracteristicasAsArray(caracteristicas);
          //palabras clave
          form.setPalabrasClaveAsArray(palabrasClave); 
          //ambitos
          form.setAmbitosAsArray(ambitos);
          
          
          //posicion de contenido a eliminar   
          String posicion = request.getAttribute("posicion").toString();
          int posicionInt = Integer.parseInt(posicion);
  		
  		//posicion de la descripcion de la que se quiere eliminar parte de su contenido
          String posicionExt = request.getAttribute("posicionExterior").toString();
          int posicionExtInt = Integer.parseInt(posicionExt);

          if(caracteristicas[posicionInt][posicionExtInt].getVacio())
          {
	    	//se recogen todas las descripciones
	    	DescripcionVO[] descArray = (DescripcionVO[]) form.getDescripcionesAsArray();
	    	//recogo los textos de la descripcion indicada y le añado un nuevo texto
	    	LangStringVO[] textos = descArray[posicionInt].getTextos();

	    	LangStringVO nuevoTexto = new LangStringVO();
	    	nuevoTexto.setIdioma("");
	    	nuevoTexto.setTexto("");
	    	textos[posicionExtInt]= nuevoTexto;
	    	descArray[posicionInt].setTextos(textos);
	    	form.setDescripcionesAsArray(descArray);
	    	
	    	caracteristicas[posicionInt][posicionExtInt]= Caracteristica.getInstance("", null);
	    	form.setCaracteristicasAsArray(caracteristicas);
          }
          
        }catch (org.acegisecurity.AccessDeniedException ad) {
       	   	logger.error("Error de Acceso " + ad);
       	   	throw new Exception("general",ad);
        }catch (Exception e) {
       	 logger
       	 .error("Error en Servicio de catalogacionWeb, categoría General, método anadirContenidoDescripcion " + e);
       	 throw new Exception("general",e);
        }
    
	}






	public void eliminarCaracteristica(
			ActionMapping mapping,
			EliminarCaracteristicaForm form, 
			HttpServletRequest request,
			HttpServletResponse response) 
	throws Exception 
	{

	   	 try{
	        	Object valor = request.getSession().getAttribute("form");
	           
	   		if (valor instanceof GeneralFormImpl) {
	   			GeneralFormImpl formulario=(GeneralFormImpl)valor;
	   	      	form.setAmbitos(formulario.getAmbitos());
	   	      	form.setDescripciones(formulario.getDescripciones());
	   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	   	      	form.setIdentificadores(formulario.getIdentificadores());
	   	      	form.setIdiomas(formulario.getIdiomas());
	   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	   	      	form.setPalabrasClave(formulario.getPalabrasClave());
	   	      	form.setTitulos(formulario.getTitulos());
	   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	   	      	
	   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
	   		} else if (valor instanceof GeneralFormSubmitFormImpl) {
	   			GeneralFormSubmitFormImpl formulario=(GeneralFormSubmitFormImpl)valor;
	   	      	form.setAmbitos(formulario.getAmbitos());
	   	      	form.setDescripciones(formulario.getDescripciones());
	   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	   	      	form.setIdentificadores(formulario.getIdentificadores());
	   	      	form.setIdiomas(formulario.getIdiomas());
	   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	   	      	form.setPalabrasClave(formulario.getPalabrasClave());
	   	      	form.setTitulos(formulario.getTitulos());
	   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	   	      	
	   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
	   		} else if (valor instanceof ValidoGeneralVolverFormImpl) {
	   			ValidoGeneralVolverFormImpl formulario=(ValidoGeneralVolverFormImpl)valor;
	   	      	form.setAmbitos(formulario.getAmbitos());
	   	      	form.setDescripciones(formulario.getDescripciones());
	   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	   	      	form.setIdentificadores(formulario.getIdentificadores());
	   	      	form.setIdiomas(formulario.getIdiomas());
	   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	   	      	form.setPalabrasClave(formulario.getPalabrasClave());
	   	      	form.setTitulos(formulario.getTitulos());
	   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	   	      	
	   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
	   		} else if (valor instanceof NoValidoGeneralVolverFormImpl) {
	   			NoValidoGeneralVolverFormImpl formulario=(NoValidoGeneralVolverFormImpl)valor;
	   	      	form.setAmbitos(formulario.getAmbitos());
	   	      	form.setDescripciones(formulario.getDescripciones());
	   	      	form.setEstructuraLabelList(formulario.getEstructuraLabelList());
	   	      	form.setEstructuraValueList(formulario.getEstructuraValueList());
	   	      	form.setIdentificadores(formulario.getIdentificadores());
	   	      	form.setIdiomas(formulario.getIdiomas());
	   	      	form.setIdiomasLabelList(formulario.getIdiomasLabelList());
	   	      	form.setIdiomasValueList(formulario.getIdiomasValueList());
	   	      	form.setNivelAgregacionLabelList(formulario.getNivelAgregacionLabelList());
	   	      	form.setNivelAgregacionValueList(formulario.getNivelAgregacionValueList());
	   	      	form.setPalabrasClave(formulario.getPalabrasClave());
	   	      	form.setTitulos(formulario.getTitulos());
	   	      	form.setComboIdiomaLabelList(formulario.getComboIdiomaLabelList());
	   	      	form.setComboIdiomaValueList(formulario.getComboIdiomaValueList());
	   	      	
	   	      	form.setComboCaractDimensionLabelList(formulario.getComboCaractDimensionLabelList());
	   	      	form.setComboCaractDimensionValueList(formulario.getComboCaractDimensionValueList());
	   	      	form.setComboCaractColorLabelList(formulario.getComboCaractColorLabelList());
	   	      	form.setComboCaractColorValueList(formulario.getComboCaractColorValueList());
	   	      	form.setComboCaractBandaSonoraLabelList(formulario.getComboCaractBandaSonoraLabelList());
	   	      	form.setComboCaractBandaSonoraValueList(formulario.getComboCaractBandaSonoraValueList());
	   	      	form.setComboCaractFormatoLabelList(formulario.getComboCaractFormatoLabelList());
	   	      	form.setComboCaractFormatoValueList(formulario.getComboCaractFormatoValueList());
	   	      	form.setComboCaractTipoPlanoLabelList(formulario.getComboCaractTipoPlanoLabelList());
	   	      	form.setComboCaractTipoPlanoValueList(formulario.getComboCaractTipoPlanoValueList());
	   	      	form.setComboCaractLuzLabelList(formulario.getComboCaractLuzLabelList());
	   	      	form.setComboCaractLuzValueList(formulario.getComboCaractLuzValueList());
	   	      	form.setComboCaractEstructuraFormalLabelList(formulario.getComboCaractEstructuraFormalLabelList());
	   	      	form.setComboCaractEstructuraFormalValueList(formulario.getComboCaractEstructuraFormalValueList());
	   	      	form.setComboCaractAngulacionLabelList(formulario.getComboCaractAngulacionLabelList());
	   	      	form.setComboCaractAngulacionValueList(formulario.getComboCaractAngulacionValueList());
	   		}

	   		int[] longitudTextosDesc = new int[form.getDescripciones().size()];
	   		for(int i= 0;i< form.getDescripciones().size();i++){
	   			longitudTextosDesc[i]=((DescripcionVO)(form.getDescripcionesAsArray()[i])).getTextos().length;
	   		}
	   		int[] longitudTextosPCla= new int[form.getPalabrasClave().size()];
	   		for(int i= 0;i< form.getPalabrasClave().size();i++){
	   			longitudTextosPCla[i]=((PalabraClaveVO)(form.getPalabrasClaveAsArray()[i])).getTextos().length;
	   		}
	   		int[] longitudTextosAmbitos= new int[form.getAmbitos().size()];
	   		for(int i= 0;i< form.getAmbitos().size();i++){
	   			longitudTextosAmbitos[i]=((AmbitoVO)(form.getAmbitosAsArray()[i])).getTextos().length;
	   		}
	   	  	int longitudDescripciones=form.getDescripciones().size();
	   	  	int longitudPalabrasClave=form.getPalabrasClave().size();
	   	  	int longitudAmbitos=form.getAmbitos().size();
	   	  	int longitudIdentificadores=form.getIdentificadores().size();
	   	  	int longitudIdiomas=form.getIdiomas().size();
	   	  	int longitudTitulo=(((TituloVO[])form.getTitulosAsArray())[0]).getTextos().length;
	   	  	
	   	  	cambioFormulario(request,longitudTextosDesc,longitudTextosPCla,longitudTextosAmbitos,
	   				longitudDescripciones,longitudPalabrasClave,longitudAmbitos,longitudIdentificadores,
	   				longitudIdiomas,longitudTitulo);

	          //identificadores
	          form.setIdentificadoresAsArray(identificadores);
	          //titulo
	          form.setTitulosAsArray(titulos);        
	          //idioma
	          form.setIdiomasAsArray(idiomas);
	          //descripciones
	          form.setDescripcionesAsArray(descripciones);
	          form.setCaracteristicasAsArray(caracteristicas);
	          //palabras clave
	          form.setPalabrasClaveAsArray(palabrasClave); 
	          //ambitos
	          form.setAmbitosAsArray(ambitos);
	          
	          
	   		 
	            //posicion de contenido a eliminar   
	            String posicion = request.getAttribute("posicion").toString();
	            int posicionInt = Integer.parseInt(posicion);
	    		
	    		//posicion de la descripcion de la que se quiere eliminar parte de su contenido
	            String posicionExt = request.getAttribute("posicionExterior").toString();
	            int posicionExtInt = Integer.parseInt(posicionExt);

		    	//se recogen todas las descripciones
		    	DescripcionVO[] descArray = (DescripcionVO[]) form.getDescripcionesAsArray();
		    	//recogo los textos de la descripcion indicada y le añado un nuevo texto
		    	LangStringVO[] textos = descArray[posicionInt].getTextos();

		    	LangStringVO nuevoTexto = new LangStringVO();
		    	nuevoTexto.setIdioma("");
		    	nuevoTexto.setTexto("");
		    	textos[posicionExtInt]= nuevoTexto;
		    	descArray[posicionInt].setTextos(textos);
		    	form.setDescripcionesAsArray(descArray);
		    	
		    	caracteristicas[posicionInt][posicionExtInt]= Caracteristica.getInstance("", null);
		    	form.setCaracteristicasAsArray(caracteristicas);
	    	
	        }catch (org.acegisecurity.AccessDeniedException ad) {
	       	   	logger.error("Error de Acceso " + ad);
	       	   	throw new Exception("general",ad);
	        }catch (Exception e) {
	       	 logger
	       	 .error("Error en Servicio de catalogacionWeb, categoría General, método anadirContenidoDescripcion " + e);
	       	 throw new Exception("general",e);
	        }
	    
		}

}
	