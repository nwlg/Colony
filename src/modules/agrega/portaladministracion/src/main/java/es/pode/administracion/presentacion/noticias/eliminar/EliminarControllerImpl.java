/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.noticias.eliminar;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


/**
 * @see es.pode.administracion.presentacion.noticias.eliminar.EliminarController
 */
public class EliminarControllerImpl extends EliminarController {	
	
	Logger logger = Logger.getLogger(this.getClass());
	public final static String MENSAJE_IDIOMAS_BUSQUEDA="listar.odecu.mostrar.resultados.detalles.errorTraduccionTermino";
	public final static String ERROR_ELIMINANDO_NOTICIAS="errors.noticias.eliminar";
	public final static String ERROR_ELIMINANDO_NOTICIAS_IDS="errors.noticias.borrar.ids";
	public final static String ERROR_CARGAR_NOTICIAS="errors.noticias.borrar.cargar";
	
	private final static String NEWS = "news";	

	/**
	 * @see es.pode.administracion.presentacion.noticias.eliminar.EliminarController#eliminar(org.apache.struts.action.ActionMapping,
	 *      es.pode.administracion.presentacion.noticias.eliminar.EliminarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void eliminar(
			ActionMapping mapping,
			es.pode.administracion.presentacion.noticias.eliminar.EliminarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		try
		{
			logger.debug("Eliminando noticias " + form.getNoticiasDeleted());
			
			if (form.getListaIds() != null && !"".equals(form.getListaIds())) 
			{
							
				String[]listIDsStrings=form.getListaIds().split(" ");
				Long[] listIDs =new Long[listIDsStrings.length];
				for(int i=0; i<listIDsStrings.length;i++)
				{
					listIDs[i]=Long.valueOf(listIDsStrings[i]);
				}
				NoticiaTraducidaVO[] noticiasAux = (NoticiaTraducidaVO[])request.getSession().getAttribute(NEWS);
				form.setNoticiasDeletedAsArray(noticiasAux);
				this.getSrvNoticiasService().eliminarNoticias(listIDs);
				logger.debug("Noticias eliminadas");
				request.getSession().setAttribute(NEWS, null);
			
			}
			else
				
				saveErrorMessage(request, "ERROR_ELIMINANDO_NOTICIAS");
			
				
		}
		catch (Exception e) 
		{
			logger.error("EliminarControllerImpl - eliminar ERROR: Eliminando noticias con ids["+form.getListaIds()+"]");
			logger.error(e);
			saveErrorMessage(request, ERROR_ELIMINANDO_NOTICIAS_IDS);
		}
	}

	public void obtenerIdiomas(ActionMapping mapping, ObtenerIdiomasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		try
		{
			Object[] listIDs = form.getIdsAsArray();

	        if(listIDs==null || listIDs.length==0)
	        {
	        	
	        	form.setSeleccionado("SIN_SELECCION");
	        	saveErrorMessage(request, ERROR_ELIMINANDO_NOTICIAS);//No se ha seleccionado ninguna noticia
	        	
	        }
	        else
	        {
	        	form.setSeleccionado("CON_SELECCION");	
	        	
	        	Iterator iter = (form.getIds()).iterator();	  		   
	 		    int i = 0;
	 		    String listaId = "";
	 		    ArrayList IDs = new ArrayList();
	 		    while (iter.hasNext()) {	
	 		    	Long id = new Long((String) iter.next());
	 		    	IDs.add(id);
	 		    	listaId = listaId + id.toString() + " ";				
	 		    	i = i + 1;
	 		    }        	
	        	       	
	        	NoticiaTraducidaVO[] noticiasAux = new NoticiaTraducidaVO[listIDs.length];	        	
	        	
	        	if (logger.isDebugEnabled()) logger.debug("Obtenemos los idiomas traducibles");
	    		
	    		String[] idiomasPlataforma = I18n.getInstance().obtenerIdiomasPlataforma();
	    		if (logger.isDebugEnabled()) logger.debug("Hay ["+idiomasPlataforma.length+"] en la plataforma");		
	    		
	    		String idiomaLogado = LdapUserDetailsUtils.getIdioma();
	    		String idiomaPrioritario = I18n.getInstance().obtenerIdiomaDefectoPlataforma();		
	    		String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
	    		if (logger.isDebugEnabled()) logger.debug("El idioma del usuario es ["+idiomaLogado+"], idioma prioritario de la plataforma es ["+idiomaPrioritario+"] y el secundario es ["+idiomaSecundario+"]");			
	    		
	    		NoticiasControllerImpl noticiasController = new NoticiasControllerImpl();	    		
		        noticiasAux=noticiasElim((Long[])IDs.toArray(new Long[0]),noticiasController.devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario) );
				
			
		        form.setListaIds(listaId.trim());
				form.setNoticiasAsArray(noticiasAux);
				request.getSession().setAttribute(NEWS, noticiasAux);
				
			  }
	        
		}
		catch (Exception e) 
		{
			logger.error("EliminarControllerImpl - obtenerIdiomas ERROR: Error al intentar cargar noticias");
			logger.error(e);
			saveErrorMessage(request, ERROR_CARGAR_NOTICIAS);
		}
	}
	
	private  NoticiaTraducidaVO[] noticiasElim(Long[] listIDs, String[] idiomasTraducibles) throws RemoteException, Exception
	{
		NoticiaTraducidaVO[] noticias = this.getSrvNoticiasService().obtenerNoticiasTraducidas(idiomasTraducibles);
		NoticiaTraducidaVO[] noticiasTemp = new NoticiaTraducidaVO[listIDs.length];
		for(int j=0;j<listIDs.length;j++)
		{
			for(int h=0;h<noticias.length;h++)
			{
				if(noticias[h].getIdNoticia().equals(listIDs[j]))
				{
				
				//sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("@","&#64"));
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("\\\"","&#34"));
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll(":","&#58"));
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("%","&#37"));
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("\\+","&#43"));
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("-","&#45"));
					noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("'","&#39"));
					
					noticiasTemp[j]=noticias[h];
				}
			}
		}
		return noticiasTemp;
		
	}
	

	public String validarSeleccion(ActionMapping mapping, ValidarSeleccionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
			return form.getSeleccionado();

	}

}