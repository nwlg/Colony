/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.noticia;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaTraducidaVO;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO;
import es.pode.soporte.constantes.ConstantesAgrega;

/**
 * @see es.pode.visualizador.presentacion.noticia.NoticiaController
 */
public class NoticiaControllerImpl extends NoticiaController
{
	private Logger logger = Logger.getLogger(NoticiaController.class);
	
	private static final String GENERATED = "<!-- Generated";
	private static final String ERRORNOTICIANODISPONIBLE = "error.noticia.encontrar";
	
	private static String PBEGIN = "<p>";
	private static String PEND = "</p>";
	private static String BR = "<br/>";
    /**
     * @see es.pode.visualizador.presentacion.noticia.NoticiaController#cargaNoticia(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.noticia.CargaNoticiaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargaNoticia(ActionMapping mapping, es.pode.visualizador.presentacion.noticia.CargaNoticiaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
	    	Long id = form.getId();
	    	String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
	    	NoticiaTraducidaVO noticia = this.getSrvNoticiasService().obtenerNoticiaTraducida(id, idioma);
	    	if (noticia == null)
	    	{
	    		logger.error("La noticia no está disponible. Validator Exception");	  
	    		saveErrorMessage(request, ERRORNOTICIANODISPONIBLE);
	    		
	    	}else{
	    	
		    	form.setTitulo(noticia.getTitulo());
		    	
		    	form.setNoticiavo(noticia);	       
		        if (logger.isDebugEnabled()) logger.debug("Despues de fecha de publicacion ["+noticia.getFechaPublicacion()+"]");
		        
		        //sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII
				form.setTitulo(noticia.getTitulo().replaceAll("@","&#64"));
				form.setTitulo(form.getTitulo().replaceAll("\\\"","&#34"));
				form.setTitulo(form.getTitulo().replaceAll(":","&#58"));
				form.setTitulo(form.getTitulo().replaceAll("%","&#37"));
				form.setTitulo(form.getTitulo().replaceAll("\\+","&#43"));
				form.setTitulo(form.getTitulo().replaceAll("-","&#45"));
				form.setTitulo(form.getTitulo().replaceAll("'","&#39"));
				
		        //Sustituimos los retornos de carro por <br> en el campo Resumen
				form.setResumen(noticia.getResumen().replaceAll("\n\r", "<br/>"));
				form.setResumen(form.getResumen().replaceAll("\r\n", "<br/>"));
				form.setResumen(form.getResumen().replaceAll("\n", "<br/>"));
				form.setResumen(form.getResumen().replaceAll("\r", "<br/>"));
		
				if (logger.isDebugEnabled()) logger.debug("El valor de noticia.getCuerpo() es ["+noticia.getCuerpo()+"]");
				
		        //Sustituimos los retornos de carro por <br> en el campo Cuerpo				
				String cuerpo = "";
				if (noticia.getCuerpo().startsWith(GENERATED)){
					cuerpo = devuelveCuerpo(noticia.getCuerpo());	
					if (logger.isDebugEnabled()) logger.debug("El valor de cuerpo empezaba por generated y es ahora ["+cuerpo+"]");
				}
				else{
					cuerpo = noticia.getCuerpo();
					if (logger.isDebugEnabled()) logger.debug("El valor de cuerpo no empezaba por generated y es ahora ["+cuerpo+"]");
				}
					
				form.setCuerpo(cuerpo.replaceAll("\n\r", "<br/>"));
				form.setCuerpo(form.getCuerpo().replaceAll("\r\n", "<br/>"));
				form.setCuerpo(form.getCuerpo().replaceAll("\n", "<br/>"));
				form.setCuerpo(form.getCuerpo().replaceAll("\r", "<br/>"));	
				
				if (logger.isDebugEnabled()) logger.debug("El valor de cuerpo despues de las transformaciones es  ["+cuerpo+"]");
				
		        form.setCategoria(noticia.getCategoria());
		        form.setAlineamientoImg(noticia.getAlineamientoImg());
		        form.setURLImagen(noticia.getURLImagen());       		        
		        CategoriaNoticiaTraducidaVO categoriaNoticia = this.getSrvNoticiasService().obtenerCategoriaTraducida(noticia.getIdCategoria(), idioma);
		        form.setIdCategoria(noticia.getIdCategoria());
		        CategoriaCodex catCodex = CategoriaCodex.mapToCodex(categoriaNoticia);
		        form.setNombreCategoriaCodex(catCodex.getNombreCodex());
		        logger.debug("La categoriaCodex: "+form.getNombreCategoriaCodex());
		        logger.debug("La categoria: "+noticia.getCategoria());
	    	}
//	        form.setNombreCategoriaCodex(CategoriaCodex.mapToCodex(noticia.getCategoria()).getNombreCodex());
//	        logger.debug("La categoriaCodex: "+form.getNombreCategoriaCodex());
    	}catch(Exception e){
    		logger.error("La noticia no está disponible: ",e);
    		saveErrorMessage(request, ERRORNOTICIANODISPONIBLE);    		
    	}
     }
   
	public void obtenerCategoria(ActionMapping mapping, ObtenerCategoriaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		try{
			CategoriaNoticiaVO categoriaVO = new CategoriaNoticiaVO();
			if (form.getIdCategoria()!=null) 
			{
				categoriaVO = this.getSrvNoticiasService().obtenerCategoria(form.getIdCategoria());
//				categoriaVO.setNueva(new Boolean (false));
				form.setCategoriaVO(categoriaVO);
			}
		}catch(Exception e){
    		logger.error("La categoría no está disponible: ",e);
    		throw new ValidatorException("{error.categoria.encontrar}");
    	}
		
	}
	
	private String devuelveCuerpo (String cuerpo) throws Exception
	{
		//Se quita el parrafo (<p> y </p>)
		String cuerpoValidado = cuerpo;
    	cuerpoValidado.replaceAll(PBEGIN, "");
    	cuerpoValidado.replaceAll(PEND, BR);		    	
    	return cuerpoValidado.trim();		
			
	}

}