/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.DependenciaVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosController
 */
public class GestorRecursosControllerImpl extends GestorRecursosController
{
	
	private GestorSesion gestorSesion =  new GestorSesion();
	
	/**
	 * @return the gestorSesion
	 */
	public GestorSesion getGestorSesion() {
		return gestorSesion;
	}


	/**
	 * @param gestorSesion the gestorSesion to set
	 */
	public void setGestorSesion(GestorSesion gestorSesion) {
		this.gestorSesion = gestorSesion;
	}
	

    public final void cargarDatos(ActionMapping mapping, 
    		es.pode.empaquetador.presentacion.avanzado.recursos.gestor.CargarDatosForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	gestorSesion.refrescarObjetosSesion(request);
    	List submanifestPath=this.getEmpaquetadorSession(request).getSubmanifestPath();
    	
    	OdeVO ultimoElemSubmPath = (OdeVO) submanifestPath.get(submanifestPath.size()-1);
    	List recursos=new ArrayList();
    	RecursoVO[] recur = ultimoElemSubmPath.getRecursos();
    	List recursosLista = Arrays.asList(recur);
    	recursos.addAll(recursosLista);
    	form.setListado(recursos);

     }


     public final void submit(
    		 ActionMapping mapping, 
    		 es.pode.empaquetador.presentacion.avanzado.recursos.gestor.SubmitForm form, 
    		 HttpServletRequest request, 
    		 HttpServletResponse response) 
     throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	String accion = form.getAction();
    	if ((accion.equals(i18n.getString("presentacion.avanzado.recursos.gestor.submit.exportar"))) 
    			||(accion.equals(i18n.getString("presentacion.avanzado.recursos.gestor.submit.eliminar"))))
    	{
    	
    		List elementos = form.getIdentifierRowSelection();
    		if (elementos!=null && elementos.size()>0)
    		{
    			List SubmanifestPath = sesEmpaq.getSubmanifestPath();
    	    	OdeVO ultimoElemSubmPath = (OdeVO) SubmanifestPath.get(SubmanifestPath.size()-1);
    	    	
    	    	RecursoVO[] recur = ultimoElemSubmPath.getRecursos();
    	    	
    	    	List recurRecuperados=new ArrayList();
    	    	for(int i=0; i<recur.length;i++)
    	    	{
    	    		if(elementos.contains(recur[i].getIdentifier()))
    	    		{
    	    			recurRecuperados.add(recur[i]);	
    	    		}
    	    	}
    	    	
    	    	form.setRecursosVO(recurRecuperados);
    		}//fin_if (elementos!=null && elementos.size()!=0)
    		else
    		{
    			throw new ValidatorException("{presentacion.avanzado.recursos.gestor.submit.error.seleccionar.recursos}");
    		}
    		
    	}
 
    	
   }

    
    public final java.lang.String selectAction(
    		ActionMapping mapping, 
    		es.pode.empaquetador.presentacion.avanzado.recursos.gestor.SelectActionForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
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
			
		else if (actionSubmit.equals(i18n.getString("presentacion.avanzado.recursos.gestor.submit.crear")) )
		{
			result = "Crear";
		} 
		else if (actionSubmit.equals(i18n.getString("presentacion.avanzado.recursos.gestor.submit.importar"))) 
		{
			result = "Importar";
		} 
		else if (actionSubmit.equals(i18n.getString("presentacion.avanzado.recursos.gestor.submit.exportar"))) 
		{
			result = "Exportar";
		} 
		else if (actionSubmit.equals(i18n.getString("presentacion.avanzado.recursos.gestor.submit.eliminar"))) 
		{
			result = "Eliminar";
		}else{
		
		Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
		}
         return result;
    }


    public final void prepararSesionModificar(
    		ActionMapping mapping, 
    		es.pode.empaquetador.presentacion.avanzado.recursos.gestor.PrepararSesionModificarForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
       EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
       GestorArchivosSession sesArch = this.getGestorArchivosSession(request);
       CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
       
       List path=new ArrayList();
       path.addAll(sesArch.getPath());
       
       List SubmanifestPath = sesEmpaq.getSubmanifestPath();
       OdeVO ultimoElemSubmPath = (OdeVO) SubmanifestPath.get(SubmanifestPath.size()-1);
   	
   	   RecursoVO[] recur = ultimoElemSubmPath.getRecursos();
   	   RecursoVO recursoBuscado=new RecursoVO();
   	   for(int i=0; i<recur.length;i++)
   	   {
   		   if(recur[i].getIdentifier().equals(form.getIdentifier()))
   		   {
   			   recursoBuscado=recur[i];
   		   }
   	   }
   		
   	   //si existe la session la borro y la hago nueva
       if(this.getCrearRecursoAvanzadoSession(request)!=null)
       {
    	   request.getSession().removeAttribute(CrearRecursoAvanzadoSession.SESSION_KEY);
    	 
       }
       sesRecurs = new CrearRecursoAvanzadoSession();
       sesRecurs.setArchivos(Arrays.asList(recursoBuscado.getFileList()));
       if(recursoBuscado.getDependencias()!=null && recursoBuscado.getDependencias().length>0)
       {
    	   sesRecurs.setDependencias(getRecursosPorDependencias( recursoBuscado.getDependencias(), ultimoElemSubmPath));
       }else
       {
    	   sesRecurs.setDependencias(new ArrayList());
       }
	   sesRecurs.setIdentifier(form.getIdentifier());
	   sesRecurs.setModificar(true);
	   sesRecurs.setPathArchivos(path);
	   sesRecurs.setPrincipal(recursoBuscado.getHref());
	   sesRecurs.setTipo(recursoBuscado.getScormType());
	   sesRecurs.setVistaArbol(false);
	   this.setCrearRecursoAvanzadoSession(request, sesRecurs);
	   
	   
    }
    
    private List getRecursosPorDependencias(DependenciaVO[] deps , OdeVO ode)
    {
    	//obtener lista completa de recursos
    	List recursos = new ArrayList();
    	recursos.addAll(Arrays.asList( ode.getRecursos() ) );
    	if(ode.getSubmanifiestos()!=null && ode.getSubmanifiestos().length>0)
    	{
    		listaRecursos(ode.getSubmanifiestos(), recursos);
    	}
    	
    	// creo una lista de recursos que se corresponda con el array de dependencias
    	List dependencias= new ArrayList();
    	
    	for(int i=0; i<deps.length;i++)
    	{
    		for(int j=0;j<recursos.size();j++)
    		{
    			if(deps[i].getIdRef().equals(((RecursoVO) recursos.get(j)).getIdentifier() ))
    			{
    				dependencias.add( (RecursoVO) recursos.get(j));
    			}
    		}
    	}
    	
    	return dependencias;
    }
    
    private List listaRecursos(OdeVO[] ode ,List recursos)
    {
  
     for(int i=0; i<ode.length;i++)
     {
    	if(ode[i].getRecursos().length>0)
    	{
    		RecursoVO[] rec = ode[i].getRecursos();
    		for (int j = 0; j < rec.length; j++) {
				recursos.add(rec[j]);
			}
    	}
    	if(ode[i].getSubmanifiestos().length>0)
    	{
    		listaRecursos(ode[i].getSubmanifiestos(),recursos);
    	}
    	
    
     }
     return recursos;
    	
    }
}