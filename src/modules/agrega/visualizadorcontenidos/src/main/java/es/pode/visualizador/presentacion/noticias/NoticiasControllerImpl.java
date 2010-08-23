/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.noticias;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.visualizador.presentacion.noticia.NoticiaCodex;


/**
 * @see es.pode.visualizador.presentacion.noticias.NoticiasController
 */
public class NoticiasControllerImpl extends NoticiasController
{

	private java.util.Properties pSpringProperties = null;
	public final static String Puntos="...";
    /**
     * @see es.pode.visualizador.presentacion.noticias.NoticiasController#obtenerNoticias(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.noticias.ObtenerNoticiasForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerNoticias(ActionMapping mapping, es.pode.visualizador.presentacion.noticias.ObtenerNoticiasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		Long idCategoria = form.getIdCategoria(); 
    	Collection noticias = Arrays.asList(this.getSrvNoticiasService().listarNoticiasActivasPorIdioma(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage()));
       	NoticiaTraducidaVO[] not=null;
    	if (noticias!= null)
    	{
    		if(idCategoria==null)
    		{
    			not= (NoticiaTraducidaVO[]) noticias.toArray(); 
    		}
    		else
        	{
    			Logger.getLogger(this.getClass()).debug("Buscando por categoria = " + idCategoria);
        		not=this.getSrvNoticiasService().obtenerNoticiasActivasPorIdiomayCategoria(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage(), idCategoria);
        		if (not[0]!=null)
        			form.setCategoria(not[0].getCategoria());
        		Logger.getLogger(this.getClass()).debug("Noticias recuperadas : " + not.length);
        	}
    		
    		 
    		for(int i=0;i < not.length; i++)
    		{
    			//sustituimos los retornos de carro por <br> para que se muestre bien el resumen
    			not[i].setResumen(not[i].getResumen().replaceAll("\n\r", "<br/>"));
    			not[i].setResumen(not[i].getResumen().replaceAll("\r\n", "<br/>"));
    			not[i].setResumen(not[i].getResumen().replaceAll("\r", "<br/>"));
    			
    			//sustituimos los retornos de carro por <br> para que se muestre bien el cuerpo
    			not[i].setCuerpo(not[i].getCuerpo().replaceAll("\n\r", "<br/>"));
    			not[i].setCuerpo(not[i].getCuerpo().replaceAll("\r\n", "<br/>"));
    			not[i].setCuerpo(not[i].getCuerpo().replaceAll("\n", "<br/>"));
    			not[i].setCuerpo(not[i].getCuerpo().replaceAll("\r", "<br/>"));
    			
    			//sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII
    			not[i].setTitulo(not[i].getTitulo().replaceAll("@","&#64"));
    			not[i].setTitulo(not[i].getTitulo().replaceAll("\\\"","&#34"));
    			not[i].setTitulo(not[i].getTitulo().replaceAll(":","&#58"));
    			not[i].setTitulo(not[i].getTitulo().replaceAll("%","&#37"));
    			not[i].setTitulo(not[i].getTitulo().replaceAll("\\+","&#43"));
    			not[i].setTitulo(not[i].getTitulo().replaceAll("-","&#45"));
    			not[i].setTitulo(not[i].getTitulo().replaceAll("'","&#39"));
    		}
    	}
    	NoticiaCodex[] noticiaCodex=NoticiaCodex.mapToCodexArray(not);
    	form.setNoticiasAsArray(noticiaCodex);
    	form.setIdCategoria(idCategoria);
    	
    }
 
    public void obtenerCategoria(ActionMapping mapping, ObtenerCategoriaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
		if (form.getIdCategoria()!=null) {
			form.setIdCategoria(form.getIdCategoria());
		}
	}
    
    private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_visualizadorcontenidos.properties");
		if (this.pSpringProperties == null)
		{
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

	

	
    

}