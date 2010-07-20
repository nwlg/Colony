/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.CompletionThresholdVO;
import es.pode.empaquetador.negocio.servicio.DataFromLMSVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.HideLMSUIVO;
import es.pode.empaquetador.negocio.servicio.NavigationInterfaceVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.negocio.servicio.PresentationVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.empaquetador.negocio.servicio.TimeLimitActionVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.uuid.PodeUUIDGenerator;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController
 */
public class CrearElementoControllerImpl extends CrearElementoController
{

	private static Logger logger = Logger.getLogger(CrearElementoControllerImpl.class);
	
	private static final String[] PRESENTATION ={"continue","previous","exit","exitAll","abandon","abandonAll","suspendAll"}; 
	private static final String[] COMPLETION ={"","exit,message","exit,no message","continue,message","continue,no message"};
	
	
	
	public final void recuperarSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.RecuperarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       CrearElementoSession sesElem=this.getCrearElementoSession(request);
       if(sesElem==null || sesElem.isEsModificar()==false) {
       
           request.getSession().removeAttribute(CrearElementoSession.SESSION_KEY);
           sesElem = new CrearElementoSession();
    	   sesElem.setEsModificar(false);
    	   sesElem.setReferenciado("Ninguno");
    	   sesElem.setTitle(null);
    	   sesElem.setIdentifier(PodeUUIDGenerator.getItemUUID(this.getClass().toString()));
    	   sesElem.setSelectPresentation(null);
    	   sesElem.setCompletionThreshold(null);
    	   sesElem.setDataFromLMS(null);
    	   sesElem.setTimeLimitAction(null);
    	   sesElem.setIsVisible(Boolean.TRUE);
    	   this.setCrearElementoSession(request, sesElem);
       }
       form.setTitle(sesElem.getTitle());
	   form.setReferenciado(sesElem.getReferenciado());
	   form.setCompletionThreshold((sesElem.getCompletionThreshold()!=null?sesElem.getCompletionThreshold().toString():null));
	   form.setDataFromLMS(sesElem.getDataFromLMS());
	   form.setTimeLimitAction(sesElem.getTimeLimitAction());
	   form.setSelectPresentation(sesElem.getSelectPresentation());//Valores seleccionandos
	   form.setPresentationAsArray(this.PRESENTATION);//Posibles valores que puede tener Presentation
	   form.setTimeLimitAsArray(this.COMPLETION);
	   form.setIsVisible(sesElem.getIsVisible());
     }



    public final void submit01(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.Submit01Form form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearElementoSession sesElem=this.getCrearElementoSession(request);
    	
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		String tipo = form.getReferenciado();
        String titulo = form.getTitle();
        String[] selectPresentation = form.getSelectPresentation();
        String completionThreshold = form.getCompletionThreshold();
        String dataFromLMS = form.getDataFromLMS();
        String timeLimitAction = form.getTimeLimitAction();
        Boolean isVisible = form.getIsVisible();
    	String accion = form.getAction();
    	logger.debug("Datos del form tras el paso 01 de crear elemento : title = " + form.getTitle() + " : tipo = " + form.getReferenciado());
    	if (accion.equals(i18n.getString("portal_empaquetado_crearElemento.continuar")))
    	{
    		sesElem.setReferenciado(tipo);
    		
    		if(form.getTitle()==null || form.getTitle().trim().equals(""))
    		{
    			throw new ValidatorException("{portal_empaquetado_crearElemento.exception}");
    		}
    		else
    		{
    			sesElem.setTitle(titulo);
    		}

    		sesElem.setSelectPresentation(selectPresentation);
    		Double content = null;
    		if(!completionThreshold.equals("")){
//	           	Pattern pattern = Pattern.compile("^[0-9]*(.[0-9]*)?$");
	           	Pattern pattern = Pattern.compile("^((0+(\\.[0-9]+)?)|(0*1(\\.0+)?))$");
	            Matcher matcher = pattern.matcher(completionThreshold);
	            
	            
	            if (matcher.find()) {
	                  content = new Double(completionThreshold);
	            }else{
	            	throw new ValidatorException("{portal_empaquetado_crearElemento.exceptionCompletion}" );
	            }
            }
    		sesElem.setCompletionThreshold(content);
    		sesElem.setDataFromLMS(dataFromLMS);
    		sesElem.setTimeLimitAction(timeLimitAction);
    		sesElem.setSelectPresentation(selectPresentation);
    		sesElem.setIsVisible(isVisible);
    	}
      }


    //hecho
    public final java.lang.String selectAction01(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.SelectAction01Form form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearElemento.cancelar")) )
		{
			result = "Cancelar";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearElemento.continuar"))) 
		{
			result = "Continuar";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearElemento.metadatos"))) 
		{
			result = "Metadatos";
		} else{
		
		logger.error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
		}
         return result;
    }


    //hecho
    public final void terminarSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.TerminarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 if(this.getCrearElementoSession(request)!=null)
         {
          	   request.getSession().removeAttribute(CrearElementoSession.SESSION_KEY);
         }
    }



    private List listaRecursos(OdeVO[]submanifiesto)
    {
    	ArrayList lista = new ArrayList();
     for(int i=0; i<submanifiesto.length;i++)
     {
    	if(submanifiesto[i].getRecursos()!=null)
    	{
	    	if(submanifiesto[i].getRecursos().length>0)
	    	{
	    		lista.addAll(Arrays.asList(submanifiesto[i].getRecursos()));
	    	}
    	}
    	
	    	if(submanifiesto[i].getSubmanifiestos().length>0)
	    	{
	    		lista.addAll(listaRecursos(submanifiesto[i].getSubmanifiestos()));
	    	}
    	
    	
    
     }
	return lista;
    	
    }
    
    private List listaSubmanifiestos(OdeVO[]submanifiesto)
    {
    	ArrayList lista = new ArrayList();
    	lista.addAll(Arrays.asList(submanifiesto));
    	
     for(int i=0; i<submanifiesto.length;i++)
     {
    	if(submanifiesto[i].getSubmanifiestos().length>0 )
    	{
    		lista.addAll(Arrays.asList(submanifiesto[i].getSubmanifiestos()));
    		lista.addAll(listaSubmanifiestos(submanifiesto[i].getSubmanifiestos()));
    	}
    	
    
     }
	return lista;
    	
    }
    //hecho
    public final void recuperarIdRef(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.RecuperarIdRefForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearElementoSession sesElem=this.getCrearElementoSession(request);
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	
    	//si modifico sesElem.getIdRef()!=null
    	form.setIdentifier(sesElem.getIdRef());
    	
//    	form.setEsRecurso(Boolean.valueOf(sesElem.isEsRecurso()));
    	
    	List elementos=new ArrayList();
    	
    	List submanifestpath=sesEmpaq.getSubmanifestPath();
    	OdeVO ultimoSubmanifestPath=(OdeVO) submanifestpath.get(submanifestpath.size()-1);
    	String identUltimo = ultimoSubmanifestPath.getIdentifier();
    	OdeVO primero = (OdeVO) submanifestpath.get(0);
    	
    	
    	if("Recurso".equals(sesElem.getReferenciado()))
    	{
    		if(primero.getRecursos().length>0)
        	{
        		elementos.addAll(filtrarDependencias(primero.getRecursos()));
        	}
    		if(primero.getSubmanifiestos().length>0)
        	{
        		elementos.addAll(listaRecursos(primero.getSubmanifiestos()));
        	}
    		form.setElementos(elementos);
    	}
    	else if("Submanifiesto".equals(sesElem.getReferenciado()))
    	{
    		
    		if(primero.getSubmanifiestos().length>0)
        	{
        		elementos.addAll(listaSubmanifiestos(primero.getSubmanifiestos()));
        	}
    		List elementosSinElQueEstamos=new ArrayList();
        	for(int i=0; i<elementos.size();i++)
        	{
        		OdeVO elem = (OdeVO) elementos.get(i);
        		String ident = elem.getIdentifier();
//        		if(ident!=identUltimo)
        		if(!ident.equals(identUltimo))
        		{
        			elementosSinElQueEstamos.add(elem);
        		}
        	}
        	form.setElementos(elementosSinElQueEstamos);
    	}
    	form.setIdentifier(sesElem.getIdRef());
    }

    
    private List filtrarDependencias(RecursoVO[] recursos)
    {
    	List listaRecursos = new ArrayList();
    	for(int i=0; i<recursos.length;i++)
    	{
    		if(recursos[i].getHref()!=null)
    		{
    			listaRecursos.add(recursos[i]);
    		}
    	}
    	
    	return listaRecursos;
    }
    
    
    public final void submit02(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.Submit02Form form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearElementoSession sesElem=this.getCrearElementoSession(request);
    	
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String identificador =form.getIdentifier();
		String accion=form.getAction();
    	if (accion.equals(i18n.getString("portal_empaquetado_crearElemento.aceptar2")))
    	{
    		sesElem.setIdRef(identificador);
    	}
      
     }


    //hecho
    public final void crear(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String identificador = form.getIdentifier();
        CrearElementoSession sesElem=this.getCrearElementoSession(request);
	   	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
	    
	    String identificadorGrupo = sesElem.getIdentifier();
	    List submanifestPath = sesEmpaq.getSubmanifestPath();
	    int submanifestPathSize = submanifestPath.size();
	    
	   	OdeVO ultimo = (OdeVO) submanifestPath.get(submanifestPath.size()-1);
	   	String identificadorUltimo = submanifestPathSize==1? sesEmpaq.getIdLocalizador():ultimo.getIdentifier();
	   	List idCollection = sesEmpaq.getIdCollection();
	   	Object ultimoIdCollection = idCollection.get(idCollection.size()-1);
	   	String identificadorPadre="";
     	GrupoVO[] grupos=null;
		if(idCollection.size()==1)
     	{
   	    		
     		OrganizacionVO organizacion = (OrganizacionVO)ultimoIdCollection;
     		grupos=organizacion.getGrupos();
     		identificadorPadre=organizacion.getIdentifier();
     		
     	}
     	else if(idCollection.size()>1)
     	{
     		GrupoVO grupo = (GrupoVO)ultimoIdCollection;
     		grupos=grupo.getGrupos();
     		identificadorPadre=grupo.getIdentifier();
     	}	
		boolean encontrado=false;
		GrupoVO grupoBuscar=null;
		for(int i=0;(encontrado==false&& i<grupos.length);i++)
		{
			if(grupos[i].getIdentifier().equals(identificadorGrupo))
			{
				encontrado=true;
				grupoBuscar=grupos[i];
			}
		}
		if(sesElem.isEsModificar()==true)
		{
			grupoBuscar.setTitle(sesElem.getTitle());
			grupoBuscar.setElementoReferenciado(sesElem.getIdRef());
			grupoBuscar.setIsVisible(sesElem.getIsVisible());
			this.getSrvGestorManifestService().modificarGrupo(identificadorUltimo, grupoBuscar);
		}
		else if(sesElem.isEsModificar()==false)
		{
			grupoBuscar=new GrupoVO();
			grupoBuscar.setTitle(sesElem.getTitle());
			grupoBuscar.setElementoReferenciado(sesElem.getIdRef());
			grupoBuscar.setIsVisible(sesElem.getIsVisible());
			grupoBuscar.setIdentifier(sesElem.getIdentifier());
			
			this.getSrvGestorManifestService().crearGrupo(identificadorUltimo, grupoBuscar, identificadorPadre);
		}
  
		TimeLimitActionVO timeLimit = null;
		if(!sesElem.getTimeLimitAction().equals("")){
			timeLimit = new TimeLimitActionVO();
			timeLimit.setContent(sesElem.getTimeLimitAction());
		}
		
		DataFromLMSVO dataFrom = null;
		if(!sesElem.getDataFromLMS().equals("")){
			dataFrom = new DataFromLMSVO();
			dataFrom.setContent(sesElem.getDataFromLMS());
		}	
		
		CompletionThresholdVO completion = null;
		if(sesElem.getCompletionThreshold()!=null && !sesElem.getCompletionThreshold().equals("")){
			completion = new CompletionThresholdVO();
			completion.setContent(sesElem.getCompletionThreshold());
		}
		
		
		PresentationVO presentation = null;
		String[] selectPresentation = sesElem.getSelectPresentation();
		if(selectPresentation!=null && selectPresentation.length > 0){
			presentation = new PresentationVO();
			NavigationInterfaceVO navigation = new NavigationInterfaceVO();
			HideLMSUIVO[] arrHide= new HideLMSUIVO[selectPresentation.length];
			for(int i=0; i<selectPresentation.length ;i++){
				HideLMSUIVO hide = new HideLMSUIVO();
				hide.setContent(selectPresentation[i]);
				arrHide[i]=hide;
			}
			navigation.setHideLMSUI(arrHide);
			presentation.setNavigationInterface(navigation);
		}
		
		
		this.getSrvGestorManifestService().asociarDatosItem(identificadorUltimo, identificadorGrupo,
				timeLimit, dataFrom, completion, presentation);
		
     }


    public final java.lang.String selectAction02(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.SelectAction02Form form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearElemento.cancelar2")) )
		{
			result = "Cancelar";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearElemento.aceptar2"))) 
		{
			result = "Aceptar";
		} 
		
		
		Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
       
         return result;
    }



	public String validaTipo(ActionMapping mapping, ValidaTipoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String result = null;
		String actionSubmit = form.getReferenciado();
		
		if ("Ninguno".equals(actionSubmit) )
		{
			result = "Si";
		} 
		else if ("Recurso".equals(actionSubmit)
				 ||  "Submanifiesto".equals(actionSubmit)) 
		{
			result = "No";
		}else
		{
			logger.error("El valor del tipo no es correcto (tipo = "
					+ actionSubmit + ";");

		}
		
		
        return result;

	}



	public void elementoVacio(ActionMapping mapping, ElementoVacioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}




}