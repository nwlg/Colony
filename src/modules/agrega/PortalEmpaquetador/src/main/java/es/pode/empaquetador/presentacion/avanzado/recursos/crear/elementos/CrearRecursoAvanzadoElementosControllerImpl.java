/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.DependenciaVO;
import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.empaquetador.negocio.servicio.LomVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.empaquetador.presentacion.CatalogacionBean;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession;
import es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession;
import es.pode.soporte.constantes.ConstantesAgrega;

public class CrearRecursoAvanzadoElementosControllerImpl extends CrearRecursoAvanzadoElementosController
{
	
	private static Logger logger = Logger.getLogger(CrearRecursoAvanzadoElementosControllerImpl.class);

//	Hecho
	@Override
     public final void submitDependencias(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SubmitDependenciasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	String accion = form.getAction();
    	
    	if (accion.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.dependencias.eliminar")))
    	{
    		if(form.getIdentifierRowSelection()!=null &&form.getIdentifierRowSelection().size()>0)
    		{
    			form.setIdentificadores(form.getIdentifierRowSelection());
    		}
    		else
    		{
    			throw new ValidatorException("{portal_empaquetado.exception}");
    		}
    	}
     }

//    Hecho
     @Override
    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	CrearRecursoAvanzadoSession sesion = this.getCrearRecursoAvanzadoSession(request);
    	if(logger.isDebugEnabled()) logger.debug("Chequeando el archivo principal: principal= " + sesion.getPrincipal() + " archivos = " + sesion.getArchivos());
    	
    	String accion = form.getAction();
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	if (accion.equals(i18n.getString("portalempaquetado.avanzado.recursos.aceptar")))
    	{
    		
    		if((sesion.getArchivos()==null || sesion.getArchivos().size()==0) &&
    			(sesion.getDependencias()==null || sesion.getDependencias().size()==0) &&
    			StringUtils.isEmpty(sesion.getPrincipal()))
    		{
    			if(logger.isDebugEnabled()) logger.debug("No se han agregado archivos, dependencias o URL");
    			throw new ValidatorException("{portalempaquetado.avanzado.recursos.error.listasvacias}");
    		}
	    	if(sesion.getArchivos()!=null && sesion.getArchivos().size()>0 && sesion.getPrincipal()==null ) 
	    	{
	    		if(sesion.getArchivos().size() == 1) 
		    	{
	    			sesion.setPrincipal(((FileVO)sesion.getArchivos().get(0)).getHref());
	    			if(logger.isDebugEnabled()) logger.debug("Se ha seleccionado el unico archivo como principal");
	    		}else
	    		{
		    		if(logger.isDebugEnabled()) logger.debug("Se ha pulsado crear recurso sin un archivo principal");
		    		/*
		    		 * fjespino:
		    		 * Reload y el estandar SCORM permite crear recursos sin URI que 
		    		 * apunte a fichero principal. Anulo esta validación.
		    		 */
	    			//throw new ValidatorException("{portal_empaquetado.recursos.avanzado.principal.no.seleccionado}");
	    		}
	    	}
	    	if(logger.isDebugEnabled()) logger.debug("Fin del submit");
	    	
    	}
    }

//   Hecho
    @Override
    public final void submitArchivos(
    	ActionMapping mapping, 
    	es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SubmitArchivosForm form, 
    	HttpServletRequest request, 
    	HttpServletResponse response) 
    throws Exception
    {
    	
        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
        
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	String accion = form.getAction();
    	
    	if (accion.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.archivos.eliminar")))
    	{
    		if(form.getHrefRowSelection()!=null &&form.getHrefRowSelection().size()>0)
    		{
    			form.setArchivos(form.getHrefRowSelection());
    		}
    		else
    		{
    			throw new ValidatorException("{presentacion.avanzado.recursos.crear.elementos.error.seleccionar.archivos}");
    		}
    	}
    	else if(accion.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.archivos.principal")))
    	{
    		if((sesRecurs.getArchivos()!=null)&&(sesRecurs.getArchivos().size()==0))
    		{
    			throw new ValidatorException("{portal_empaquetado.exception.archivoPrincipalVacio}");
    		}
    	}
    	
     }

//  Hecho
    @Override
    public final java.lang.String selectActionDependencias(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SelectActionDependenciasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
			
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.dependencias.eliminar")) )
		{
			if(logger.isDebugEnabled()) logger.debug("actionSubmit vale ["+actionSubmit+"]");
			if(logger.isDebugEnabled()) logger.debug("result va a valer Eliminar");
			result = "Eliminar";
		} 
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.dependencias.anadir"))) 
		{
			if(logger.isDebugEnabled()) logger.debug("actionSubmit vale ["+actionSubmit+"]");
			if(logger.isDebugEnabled()) logger.debug("result va a valer Crear");
			result = "Crear";
		}else{
			logger.error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
		}
         return result;
    }


//    Hecho
    @Override
    public final java.lang.String selectActionCrear(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SelectActionCrearForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
     	
		String result = null;
		String actionSubmit = form.getAction();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		if(logger.isDebugEnabled()) logger.debug("selectActionCrear: action = " + form.getAction() + " de [" + i18n.getString("portalempaquetado.avanzado.recursos.cancelar") + " , " + i18n.getString("portalempaquetado.avanzado.recursos.aceptar"));
		if (form.getAction()== (null))
		{
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.cancelar")) )
		{
			if(logger.isDebugEnabled()) logger.debug("Metodo SelectActionCrear;actionSubmit vale ["+actionSubmit+"]");
			if(logger.isDebugEnabled()) logger.debug("result va a valer Cancelar");
			
			result = "Cancelar";
		} 
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.aceptar"))) 
		{
			if(logger.isDebugEnabled()) logger.debug("Metodo SelectActionCrear;actionSubmit vale ["+actionSubmit+"]");
			if(logger.isDebugEnabled()) logger.debug("result va a valer Crear");
			
			result = "Crear";
		} else{
			Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
		}
         return result;
    }
    
    private List listaRecursos(OdeVO[]submanifiesto ,List recursos)
    {
  
     for(int i=0; i<submanifiesto.length;i++)
     {
    	if(submanifiesto[i].getRecursos().length>0)
    	{
    		RecursoVO[] rec = submanifiesto[i].getRecursos();
    		for (int j = 0; j < rec.length; j++) {
				recursos.add(rec[j]);
			}
    	}
    	if(submanifiesto[i].getSubmanifiestos().length>0)
    	{
    		listaRecursos(submanifiesto[i].getSubmanifiestos(),recursos);
    	}
    	
    
     }
	return recursos;
    	
    }
    

//    Hecho
    @Override
    public final void recuperarDependencias(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecuperarDependenciasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
        
        List path=sesEmpaq.getSubmanifestPath();
        List recursos=new ArrayList();
     
        
    	OdeVO primero=(OdeVO) path.get(0);
    	if(primero.getRecursos().length>0)
    	{
    		RecursoVO[] rec = primero.getRecursos();
    		
    		for (int i = 0; i < rec.length; i++) {
				recursos.add(rec[i]);
			}
    	}
    	if(primero.getSubmanifiestos().length>0)
    	{
    		listaRecursos(primero.getSubmanifiestos(),recursos);
    	}
    	
    	
      	List dependencias = new ArrayList();
      	dependencias= sesRecurs.getDependencias();
    	
      	boolean encontrado=false;
      	if (recursos.size()>0){
      		for (int k=0;k<recursos.size() && !encontrado ;k++){
      			RecursoVO recur=(RecursoVO) recursos.get(k);
      			if (recur.getIdentifier().equals(sesRecurs.getIdentifier())){
      				recursos.remove(k);
      				encontrado=true;
      			
      			}
      		}
      	}
      	form.setRecursos(recursos);
    	form.setDependencias(dependencias);
    	
     }

//    Hecho
    @Override
    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
    	 CrearRecursoArchivosSession sesArch= this.getCrearRecursoArchivosSession(request);
    	 List archivos = sesRecurs.getArchivos();
    	 // Comprueba catalogacion para ver si hay que 'falsear' los Lom de los file aun no creados
    	 if(this.getEmpaquetadorSession(request).getPendientesCatalogacion()!=null) {
    		 if(logger.isDebugEnabled()) logger.debug("Hay " + this.getEmpaquetadorSession(request).getPendientesCatalogacion().size() + " elementos en pendientesCatalogacion");
    	 }
    	 if(this.getEmpaquetadorSession(request).getPendientesCatalogacion()!=null && this.getEmpaquetadorSession(request).getPendientesCatalogacion().size()>0) {
    		 String idRec = sesRecurs.getIdentifier();
    		 List pendientesCatalogacion = this.getEmpaquetadorSession(request).getPendientesCatalogacion();
    		 for(int i=0;i<archivos.size();i++) {
    			 FileVO file = (FileVO)archivos.get(i);
    			 CatalogacionBean cb = new CatalogacionBean();
    			 cb.setIdentifier(idRec);
    			 cb.setHref(file.getHref());
    			 if(logger.isDebugEnabled()) logger.debug("Comprobando file " + cb.getIdentifier() + cb.getHref() + " en la coleccion pendientesCatalogacion " + this.getEmpaquetadorSession(request).getPendientesCatalogacion().toString());
    			 if(pendientesCatalogacion.contains(cb)) {
    				 if(logger.isDebugEnabled()) logger.debug("File con lom encontrado: falseo lom para icono durante la creacion");
    				 file.setLom(new LomVO());
    				 file.getLom().setTitulo("Temporal");
    				 archivos.set(i,file);
    			 }
    		 }
    		 this.getCrearRecursoAvanzadoSession(request).setArchivos(archivos);
    	 }
    	 
    	 sesArch.setArchivos(archivos);
    	 
    	 form.setArchivos(sesRecurs.getArchivos());
    	 form.setDependencias(sesRecurs.getDependencias());
    	 if(sesRecurs.getPrincipal()!=null && !sesRecurs.getPrincipal().equals(""))
    		 form.setPrincipal(sesRecurs.getPrincipal());
    	
     }
    
   

//	Hecho
    @Override
    public final void eliminarDependencias(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.EliminarDependenciasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
    	List identificadoresEliminar = form.getIdentificadores();
    	List dependencias = sesRecurs.getDependencias();
    	Iterator iter;
    	boolean cortar;
    	
    	for(int i=0;i<identificadoresEliminar.size();i++)
    	{
    		iter = dependencias.iterator();
    		cortar= false;
    		while (iter.hasNext() && !cortar) 
    		{
				RecursoVO recurso = (RecursoVO) iter.next();
				
				if(recurso.getIdentifier().equals(identificadoresEliminar.get(i)))
				{
					iter.remove();
					cortar=true;
				}
					
			}
    	}
    	sesRecurs.setDependencias(dependencias);
    }


//    Hecho
    @Override
    public final void crearRecurso(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	GestorArchivosSession sesArch = this.getGestorArchivosSession(request);
        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
        if(logger.isDebugEnabled()) logger.debug("Comenzando la creacion de recurso: id=" + sesRecurs.getIdentifier() + " : href = " + sesRecurs.getPrincipal() + " : scormType = " + sesRecurs.getTipo() + "  : archivos " + sesRecurs.getArchivos() + " : dependencias " + sesRecurs.getDependencias());
    	List path = sesArch.getPath();
    	OdeVO ultimo=(OdeVO) this.getEmpaquetadorSession(request).getSubmanifestPath().get(
    			this.getEmpaquetadorSession(request).getSubmanifestPath().size()-1);
    	Integer index= this.getEmpaquetadorSession(request).getSubmanifestPath().size()-1;
    	String identificador=index==0?getEmpaquetadorSession(request).getIdLocalizador():ultimo.getIdentifier();
    	RecursoVO recurso=new RecursoVO();
    	if(logger.isDebugEnabled()) logger.debug("Preparando dependencias");
    	List temp= sesRecurs.getDependencias();
    	DependenciaVO[] dep= new DependenciaVO[temp.size()];
    	
    	for (int i=0;i< temp.size(); i++) 
    	{
    		DependenciaVO d= new DependenciaVO();
    		d.setIdRef(((RecursoVO) temp.get(i)).getIdentifier());
    		dep[i]=d;
		}
    	
    	
    	recurso.setDependencias(dep);
    	if(logger.isDebugEnabled()) logger.debug("Dependencias metidas en recurso VO");
    	Object[] ficherosTemp= sesRecurs.getArchivos().toArray();
    	FileVO[] ficheros;
    	ficheros= new FileVO[ficherosTemp.length];
    	for(int i=0;i<ficherosTemp.length;i++)
    	{
    		ficheros[i]= (FileVO) ficherosTemp[i];
    	}
    	
    	recurso.setFileList(ficheros);
    	if(logger.isDebugEnabled()) logger.debug("Archivos metidos como FileVO[]");
    	recurso.setHref(sesRecurs.getPrincipal());
    	recurso.setIdentifier(sesRecurs.getIdentifier());
    	recurso.setLom(null);
    	recurso.setScormType(sesRecurs.getTipo());
    	recurso.setType("WebContent");
    	
    	if(sesRecurs.isModificar()==true){
    		if(logger.isDebugEnabled()) logger.debug("Llamando a modificar recurso en idOde " + identificador + " y recurso " + recurso);
    		this.getSrvGestorManifestService().modificarRecurso(identificador, recurso);
    	}
    	else {
    		if(logger.isDebugEnabled()) logger.debug("Llamando a crear recurso en idOde " + identificador + " y recurso " + recurso);
    		this.getSrvGestorManifestService().crearRecurso(identificador, recurso);
    	}

    }

//    Hecho
    @Override
    public final void actualizarDependencias(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.ActualizarDependenciasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
        List dependencias= new ArrayList();
        
		String actionSubmit = form.getAction();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		if (form.getAction()== (null))
		{
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
			
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.dependencias.aceptar")) )
		{
	        List path=sesEmpaq.getSubmanifestPath();
	    	OdeVO ultimo=(OdeVO) path.get(path.size()-1);
	    	List identificadoresActualizar =new ArrayList(); 
	    	if(form.getIdentifierRowSelection()!=null)
	    	{
	    		identificadoresActualizar=form.getIdentifierRowSelection();
	    	}
	    	//obtengo lista completa de recursos
	        List recursos=new ArrayList();
	     
	    	if(ultimo.getRecursos().length>0)
	    	{
	    		RecursoVO[] rec = ultimo.getRecursos();
	    		
	    		for (int i = 0; i < rec.length; i++) {
					recursos.add(rec[i]);
				}
	    	}
	    	
	    		if(identificadoresActualizar.size()>0)
	    		{
	    				listaRecursos(ultimo.getSubmanifiestos(),recursos);
	    				if (logger.isDebugEnabled()) 
	    					logger.debug("Se han añadido " + recursos.size()+ " dependencias");
	    	    }
	    		else 
	    		{
	    	    		logger.error("Error al añadir dependencias. No se ha seleccionado ninguna");
	    	    		throw new ValidatorException ("{portalempaquetado.avanzado.recursos.crear.dependencias.error}");
	    	    }
	    	
	       //busco el recurso con el identificador
	       
	    	for (Iterator iter = identificadoresActualizar.iterator(); iter.hasNext();) 
	    	{
				String id = (String ) iter.next();
				
				boolean corte=false;
				Iterator iterator = recursos.iterator();
				while ( iterator.hasNext() && !corte) 
				{
					RecursoVO recurso = (RecursoVO) iterator.next();
					if(recurso.getIdentifier().equals(id))
					{
						dependencias.add(recurso);
						corte=true;
					}
				}
				
			}
	    	
	    	sesRecurs.setDependencias(dependencias);
			
		} 
     }

//	Hecho
    @Override
    public final java.lang.String selectActionArchivos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SelectActionArchivosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
			
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.archivos.eliminar")) )
		{
			result = "Eliminar";
		} 
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.archivos.anadir")))
		{
			result = "Crear";
		} 
		else if (actionSubmit.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.paso2.archivos.principal"))) 
		{
			result = "Principal";
		}else
		{
			Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
								+ actionSubmit + ";");
		}
         return result;
    }

    
//   Hecho
    @Override
    public final void eliminarArchivos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.EliminarArchivosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
    	if(logger.isDebugEnabled()) logger.debug("Eliminando archivos seleccionados en recurso " + sesRecurs.getIdentifier());
      	List hrefEliminar = form.getArchivos();
      	if(logger.isDebugEnabled()) logger.debug("Archivos a eliminar " + hrefEliminar);
      	List archivos = new ArrayList(); 
      	archivos.addAll(sesRecurs.getArchivos());
      	if(logger.isDebugEnabled()) logger.debug("Archivos seleccionados antes de eliminar " + archivos.size());
      	for(int i=0;i<hrefEliminar.size();i++)
      	{
      		if(logger.isDebugEnabled()) logger.debug("Iterando archivos para encontrar " + (hrefEliminar == null ? hrefEliminar : hrefEliminar.get(i)));
      		for (Iterator iter = archivos.iterator(); iter.hasNext();) 
      		{
				FileVO archivo = (FileVO) iter.next();
				if(archivo.getHref().equals(hrefEliminar.get(i))) 
				{
					if(logger.isDebugEnabled()) logger.debug("Chequeo si el file que voy a eliminar no sea el principal del recurso ");
					String principal=sesRecurs.getPrincipal();
					if(principal==null ||principal.equals(""))
					{		
						logger.debug("principal es null");
					}
					else
					{
						if(principal.equals(archivo.getHref()))
						{
							sesRecurs.setPrincipal(null);
						}
					}
					if(logger.isDebugEnabled()) logger.debug("Eliminando " + archivo.getHref());
					iter.remove();
					if(logger.isDebugEnabled()) logger.debug(archivo.getHref() + " eliminado");
				}
			}
      	}
      	sesRecurs.setArchivos(archivos);
     }

//	Hecho
    @Override
    public final void recuperarArchivos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecuperarArchivosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
	   	 CrearRecursoArchivosSession sesArch= this.getCrearRecursoArchivosSession(request);
		 sesArch.setArchivos(sesRecurs.getArchivos());

      	form.setArchivos(sesRecurs.getArchivos());
    	form.setPrincipal(sesRecurs.getPrincipal());
     }

//    Hecho
    @Override
    public final void seleccionarPrincipal(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SeleccionarPrincipalForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String principal = form.getPrincipal();
    	
    	
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
        String Action=form.getAction();
        

        
        if (Action.equals(i18n.getString("portalempaquetado.avanzado.recursos.crear.archivo.principal.aceptar")))
		{
        	if(principal==null || principal.equals(""))
        	{
        		logger.error("No se ha seleccionado ningun archivo principal");
        		throw new ValidatorException ("{portalempaquetado.avanzado.recursos.crear.archivo.principal.error.archivonoseleccionado}");
        	}

        	if(sesRecurs.getArchivos().size()==1) {
        		if(logger.isDebugEnabled()) logger.debug("Se ha seleccionado el unico archivo como principal");
        		sesRecurs.setPrincipal((String)sesRecurs.getArchivos().get(0));
        		saveSuccessMessage(request, "{portal_empaquetado.recursos.avanzado.principal.unico}");
        	}
        	if(principal!=null ){
        		sesRecurs.setPrincipal(principal);
        	}
		}  
       
     }

//  Hecho
    @Override
    public final void catalogarFichero(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CatalogarFicheroForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        CrearRecursoAvanzadoSession sesRecurs=this.getCrearRecursoAvanzadoSession(request);
        Logger.getLogger("el href que me pasan es: "+form.getHref());
        form.setIdentifier(sesRecurs.getIdentifier());        
        form.setReturnURL(request.getContextPath()+"/"+mapping.findForward("crear.recurso.avanzado.elementos").getPath());
      
     }

//    Hecho
    @Override
    public final void terminarSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.TerminarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 if(this.getCrearRecursoAvanzadoSession(request)!=null)
         {
          	   request.getSession().removeAttribute(CrearRecursoAvanzadoSession.SESSION_KEY);
         }
    }
    @Override
	public String esUnArchivo(ActionMapping mapping, EsUnArchivoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List archivos = form.getArchivos();
		String resultado = null;
		if(archivos ==null) {
			if(logger.isDebugEnabled()) logger.debug("Archivos en el recurso en creacion es NULL");
		} else {
			if(archivos.size()==1) {
				if(logger.isDebugEnabled()) logger.debug("El recurso en creacion solo tiene un archivo");
				resultado = "Si";
			} else {
				if(logger.isDebugEnabled()) logger.debug("El recurso en creacion tiene mas de un archivo");
				resultado ="No";
			}
		}
		return resultado;
	}

	@Override
	public void modificarPrincipal(ActionMapping mapping,
			ModificarPrincipalForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = form.getAction();
		String url = form.getUrl();
		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n=ResourceBundle.getBundle("application-resources", locale);
		if(logger.isDebugEnabled()) logger.debug("modificarPrincipal con parametros action = " + action + " y url = " + url);
		if(i18n.getString("comunes.aceptar").equals(action)) {
			//Fuerzo null en caso de cadena vacia
			if(StringUtils.isEmpty(url)) url = null;
			getCrearRecursoAvanzadoSession(request).setPrincipal(url);
		}
	}

	@Override
	public void recuperarURL(ActionMapping mapping, RecuperarURLForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(logger.isDebugEnabled()) logger.debug("Recuperando URI de recurso de la sesion: " + getCrearRecursoAvanzadoSession(request).getPrincipal());
		form.setUrl(getCrearRecursoAvanzadoSession(request).getPrincipal());
	}

	@Override
	public String submitArchivoPrincipal(ActionMapping mapping,
			SubmitArchivoPrincipalForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = form.getAction();
		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources", locale);
		String result = null;
		
		if(logger.isDebugEnabled()) logger.debug("submitArchivoPrincipal con parametros : action=" + action);
		if(i18n.getString("presentacion.avanzado.recursos.crear.elementos.principal.elegir").equals(action)) {
			// Seleccionar archivo
			if((getCrearRecursoAvanzadoSession(request).getArchivos()!=null)&&(getCrearRecursoAvanzadoSession(request).getArchivos().size()==0))
    		{
    			throw new ValidatorException("{portal_empaquetado.exception.archivoPrincipalVacio}");
    		}
			result = "Principal";
		} else {
			// Editar
			result = "Editar";
		}
		return result;
	}

}