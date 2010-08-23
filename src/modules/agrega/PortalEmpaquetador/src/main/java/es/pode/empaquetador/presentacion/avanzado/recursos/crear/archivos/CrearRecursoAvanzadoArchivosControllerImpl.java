/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController
 */
public class CrearRecursoAvanzadoArchivosControllerImpl extends CrearRecursoAvanzadoArchivosController
{

//    Hecho
    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
    	 form.setVistaArbol(sesRecurs.isVistaArbol());
    	 
      	 List files = sesRecurs.getPathArchivos();
      	 if(files!=null && !files.isEmpty())
      	 {
	    	 ArchivoVO primero=(ArchivoVO) files.get(0);
	    	 form.setArbol(primero);
	    	 ArchivoVO ultimo=(ArchivoVO) files.get(files.size()-1);
	    	 form.setArchivos(Arrays.asList(ultimo.getContenidos()));
	    	 form.setPathArchivos(sesRecurs.getPathArchivos());
      	 }
     }
  

    private List rellenarBarraNavegacion(ArchivoVO[] archivo, String href) 
    {
    	List path = null;
		if (archivo != null) 
		{
			for (int i = 0; i < archivo.length && path==null; i++)
			{
				if (archivo[i].getHref().equals(href)) 
				{
					path= new ArrayList();
					path.add(archivo[i]);
				} 
				else 
				{
					List tmpPath = rellenarBarraNavegacion(archivo[i].getContenidos(), href);
					if (tmpPath != null && tmpPath.size() > 0) 
					{
						path = new ArrayList();
						path.add(archivo[i]);
						path.addAll(tmpPath);
											
					}
				}
			}
		}
		return path;
	}
    
    /**
     * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoAvanzadoArchivosController#navegar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.NavegarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void navegar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.NavegarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
    	
    	String referencia = form.getHref();
    	List listaPath = sesRecurs.getPathArchivos();
    	
    	List ruta=new ArrayList();
    	//path es el primer ArchivoVO
    	ArchivoVO path = (ArchivoVO) listaPath.get(0);
    	
    	//si el hrfe está aki, se acaba, si no se hace recursividad
    	if(path.getHref().equals(referencia))
    	{
    		ruta.add(path);
    	}
    	else
    	{
    		//llama a un método recursivo para calcular la ruta
    		List tmpList = rellenarBarraNavegacion(path.getContenidos(), referencia);
    		ruta.add(path);
	    	if (tmpList != null && tmpList.size() > 0) 
	    	{
	    		ruta.addAll(tmpList);
	    	}
	    }
    	sesRecurs.setPathArchivos(ruta);
    }

//    Hecho
    public final void cambiaVista(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CambiaVistaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {	
    	
    	boolean vista = form.isVistaArbol();
    
    	
    	  CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
     	  sesRecurs.setVistaArbol(vista);
     }

//   Hecho
    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);

    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	String accion = form.getAction();
    	if ((accion.equals(i18n.getString("presentacion.avanzado.recursos.crear.archivos.submit.seleccionar"))))
    	{
    		List archivosARecuperar=new ArrayList();
    		List elementos = form.getNombreRowSelection();
    		if (elementos!=null && elementos.size()>0)
    		{
    			/**
    			 * voy a recorrer la lista recuperando los nombres
    			 * para recuperar los ArchivosVO
    			 */
    			for (int i=0; i<elementos.size();i++)
    			{
    				String nombre = (String) elementos.get(i);
    				//hijos del ultimo elemento del path
    				
    				List path = sesRecurs.getPathArchivos();
    				
    				//obtengo el ultimo elemento
    				ArchivoVO ultimoElemento=(ArchivoVO) path.get(path.size()-1);
    				
    				ArchivoVO[] hijosUltimoElemento = ultimoElemento.getContenidos();
    				
    				//comparo los nombres de los archivosVO y si es =, lo inserto en la lista "archivosARecuperar"
    				boolean cortar= false;
    				for(int j=0; j<hijosUltimoElemento.length && cortar==false;j++)
    				{
    					if (hijosUltimoElemento[j].getNombre().equals(nombre))
    					{
    						archivosARecuperar.add(hijosUltimoElemento[j]);
    						cortar=true;
    					}
    				}
    			}//fin_for (int i=0; i<elementos.size();i++)
    			
    			//inserto la lista de ArchivosVO que he recuperado
    			form.setArchivosSeleccionados(archivosARecuperar);
    			//todo: pasar archivos seleccionados al objeto de session
    			
    		}//fin_if (elementos!=null && elementos.size()!=0)
    		else
    		{
    			throw new ValidatorException("{presentacion.avanzado.recursos.crear.archivos.error.seleccionar.archivos}");
    		}
    		
    	}
    	
    }

//    Hecho
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	/*
		 * Metodo de decision para el action. Analiza los parametros
		 * actionSubmit (value de los botones submit) para redirigir al caso de uso
		 * correspondiente. El actionSubmit llegara
		 * internacionalizado, por lo que es necesario acceder al ResouceBundle
		 * para obtener el valor correcto en la comparacion.
		 */
    	
		String result = null;
		String actionSubmit = form.getAction();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		if (form.getAction()== (null))
		{
			throw new ValidatorException("{comunes.error.generico}");
		}
			
		else if (actionSubmit.equals(i18n.getString("presentacion.avanzado.recursos.crear.archivos.submit.seleccionar")) )
		{
			result = "Seleccionar";
		} 
		else if (actionSubmit.equals(i18n.getString("presentacion.avanzado.recursos.crear.archivos.submit.cancelar"))) 
		{
			result = "Cancelar";
		} 
		else{
		Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
		}
         return result;
    }

    
    
    private void _sumarArchivos(ArchivoVO archivo , List lista , Set setComp)
    {
    	if(!archivo.getEsFichero().booleanValue())
    	{
    		ArchivoVO[] contenidos =archivo.getContenidos(); 
    		for (int i = 0; i < contenidos.length; i++) 
    		{
				_sumarArchivos(contenidos[i], lista , setComp);
			}
    	}else
    	{
    		String padre= "";
        	String href="";
        	
    		padre= archivo.getCarpetaPadre();
    		href = archivo.getNombre();
    		FileVO file = new FileVO();
    		file.setUrl(archivo.getHref());
    		if(padre!=null && !padre.equals(""))
    			file.setHref(padre+"/"+href);
    		else
    			file.setHref(href);
    		if(setComp.add(file))
    			lista.add(file);
    	}
    }
    
    
//    Hecho
    public final void sumarArchivos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.SumarArchivosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearRecursoArchivosSession sesRecursArch=this.getCrearRecursoArchivosSession(request);
    	List archivosSeleccionados = form.getArchivosSeleccionados();
    	List tempList= new ArrayList();
    	tempList.addAll(sesRecursArch.getArchivos());
    	Set tempSet= new HashSet(sesRecursArch.getArchivos());
    	
    	for(int i=0; i<archivosSeleccionados.size();i++)
    	{
    		_sumarArchivos( (ArchivoVO) archivosSeleccionados.get(i) , tempList,tempSet);
    	}
    	
    	sesRecursArch.setArchivos(tempList);
     }

    
//    Hecho
    public final void terminarSeleccionArchivos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.TerminarSeleccionArchivosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	  CrearRecursoArchivosSession sesRecursArch=this.getCrearRecursoArchivosSession(request);
    	  CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
    	  
    	  sesRecurs.setArchivos(sesRecursArch.getArchivos());
    }


//    Hecho
    public final void eliminar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.EliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	   
	  	  CrearRecursoArchivosSession sesRecursArch=this.getCrearRecursoArchivosSession(request);
	  	  ArrayList templist= (ArrayList) sesRecursArch.getArchivos();
	  	  
	  	  String hrefEliminar = form.getHref();
	      for ( Iterator iter =templist.iterator();  iter.hasNext();) 
	      {
			FileVO file = (FileVO) iter.next();
			if(file.getHref().equals(hrefEliminar))
			{
				iter.remove();
			}
			
	      }
	      
	      
	      sesRecursArch.setArchivos(templist );
     }


//    Hecho
    public final void eliminarTodos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.EliminarTodosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    
    	  CrearRecursoArchivosSession sesRecursArch=this.getCrearRecursoArchivosSession(request);
    	  sesRecursArch.getArchivos().clear();
    }


//    Hecho
    public final void cancelar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 if(this.getCrearRecursoArchivosSession(request)!=null)
         {
          	   request.getSession().removeAttribute(CrearRecursoArchivosSession.SESSION_KEY);
         }
    }

//    Hecho
    public final void terminarSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.TerminarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 if(this.getCrearRecursoArchivosSession(request)!=null)
         {
          	   request.getSession().removeAttribute(CrearRecursoArchivosSession.SESSION_KEY);
         }
    	 if(this.getCrearRecursoAvanzadoSession(request)!=null)
         {
          	   request.getSession().removeAttribute(CrearRecursoAvanzadoSession.SESSION_KEY);
         }
    }

}