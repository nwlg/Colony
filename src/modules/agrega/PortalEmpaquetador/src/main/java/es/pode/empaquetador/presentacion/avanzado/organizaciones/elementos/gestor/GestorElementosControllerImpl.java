/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ControlModeVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.HideLMSUIVO;
import es.pode.empaquetador.negocio.servicio.NavigationInterfaceVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.negocio.servicio.PresentationVO;
import es.pode.empaquetador.negocio.servicio.SecuenciaVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosController
 */
public class GestorElementosControllerImpl extends GestorElementosController
{
	private static final String PEGAR_ACTION = "portal_empaquetado_gestorOrganizaciones.pegar";
	private static final String CORTAR_ACTION = "portal_empaquetado_gestorOrganizaciones.cortar";
	private static final String COPIAR_ACTION = "portal_empaquetado_gestorOrganizaciones.copiar";
	private static final String ELIMINAR_ACTION = "portal_empaquetado_gestorOrganizaciones.eliminar";
	private static final String PORTAL_EMPAQUETADO_EXCEPTION = "{portal_empaquetado.exception}";
	private static final String APPLICATION_RESOURCES = "application-resources";
	private static final String CORTAR = "Cortar";
	private static final String COPIAR = "Copiar";
	private static final String PORTAL_EMPAQUETADO_EXCEPTION_SESSION = "{portal_empaquetado.exception.session}";
	private static final String NORMAL = "Normal";
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
	
	
    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	
    	this.gestorSesion.refrescarObjetosSesion(request);
    	
    	List idCollection= sesEmpaq.getIdCollection();
    	Object ultimoIdCollection = idCollection.get(idCollection.size()-1);
    	OrganizacionVO primerIdCollection=(OrganizacionVO) idCollection.get(0);
    	ControlModeVO secuencia=null;
    	boolean encontrado;
		if(idCollection.size()==1)
    	{
    		OrganizacionVO organizacion = (OrganizacionVO)ultimoIdCollection;
    		form.setGruposAsArray(organizacion.getGrupos());
    		SecuenciaVO[] arraySecuencia = organizacion.getSecuencia();
    		encontrado=false;
    		if (arraySecuencia != null){
    			for(int i=0;(arraySecuencia!=null && encontrado==false&& i<arraySecuencia.length);i++)
    			{
    				if(arraySecuencia[i].getControlMode()!=null)
    				{
    					encontrado=true;
    					secuencia=arraySecuencia[i].getControlMode();
    				}
    			}
    		}
    		
    		
    	}
    	else if(idCollection.size()>1)
    	{
    		GrupoVO grupo = (GrupoVO)ultimoIdCollection;
    		form.setGruposAsArray(grupo.getGrupos());
    		SecuenciaVO[] arraySecuencia =grupo.getSecuencia();
    		encontrado=false;
    		if (arraySecuencia != null){
    			for(int i=0;(encontrado==false && i<arraySecuencia.length);i++)
    			{
    				if(arraySecuencia[i].getControlMode()!=null)
    				{
    					encontrado=true;
    					secuencia=arraySecuencia[i].getControlMode();
    				}
    			}
    		}
    		
    	}
    	if(secuencia!=null )
    	{
    		form.setSecuencia(secuencia);
    	}
    	else
    	{
          	
          	ControlModeVO controlM = new ControlModeVO();
          	controlM.setChoice(Boolean.TRUE);
          	controlM.setChoiceExit(Boolean.FALSE);
          	controlM.setFlow(Boolean.TRUE);
          	controlM.setForwardOnly(Boolean.FALSE);
          
          	form.setSecuencia(controlM);
    	}
    	List portapapeles = sesEmpaq.getPortapapeles();
    	form.setPortapapeles(portapapeles);
    	form.setIdCollection(idCollection);
    	form.setOrganizacion(primerIdCollection);
      }

    private List rellenarBarraNavegacion(GrupoVO[] grupos, String id) {
		List lista = new ArrayList();
		if (grupos != null) {
			for (int i = 0; i < grupos.length && lista.isEmpty(); i++) {
				if (id.equals(grupos[i].getIdentifier())) {
					lista.add(grupos[i]);
				} else {
					List tmpList = rellenarBarraNavegacion(grupos[i]
							.getGrupos(), id);
					if (tmpList != null && tmpList.size() > 0) {
						lista.add(grupos[i]);
						lista.addAll(tmpList);
					}
				}
			}
		}
		return lista;
	}
    
    public final void navegar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.NavegarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//TODO Revisar navegación por lista, problemas al hacer click
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
		List lista = new ArrayList();
		List submanifestPath = sesEmpaq.getSubmanifestPath();
		OdeVO ode = (OdeVO) submanifestPath.get(submanifestPath.size()>0?submanifestPath.size()-1:0);
		String id = form.getIdentifier();
		OrganizacionVO[] orgs = ode.getOrganizaciones();
		for (int i = 0; i < orgs.length && lista.isEmpty(); i++) {
			if (id.equals(orgs[i].getIdentifier())) {
				lista.add(orgs[i]);
			} else {
				List tmpList = rellenarBarraNavegacion(orgs[i].getGrupos(), id);
				if (tmpList != null && tmpList.size() > 0) {
					lista.add(orgs[i]);
					lista.addAll(tmpList);
				}
			}
		}
		sesEmpaq.setIdCollection(lista);
		
		if(sesEmpaq.getPortapapeles().size()>0)
		{
			sesEmpaq.setModoPegar(true);
		}
     }


    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	List identificadores = form.getIdentifierRowSelection();
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle(APPLICATION_RESOURCES,locale);
		String accion = form.getAction();
		if ((accion.equals(i18n.getString(ELIMINAR_ACTION))) 
    			||(accion.equals(i18n.getString(COPIAR_ACTION)))
    			||(accion.equals(i18n.getString(CORTAR_ACTION))))
		{
			if((identificadores==null)||(identificadores.size()==0))
			{
				throw new ValidatorException(PORTAL_EMPAQUETADO_EXCEPTION);
			}
			else
			{
				form.setIdentificadores(identificadores);
			}
		}
		else if((accion.equals(i18n.getString(PEGAR_ACTION))))
		{
			if((sesEmpaq.getPortapapeles()==null)||(sesEmpaq.getPortapapeles().size()==0))
			{
				throw new ValidatorException(PORTAL_EMPAQUETADO_EXCEPTION);
			}
		}
 		
     }


    public final java.lang.String selectAction(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
		ResourceBundle i18n = ResourceBundle.getBundle(APPLICATION_RESOURCES,locale);
		
		if (form.getAction()== (null))
		{
			throw new ValidatorException(PORTAL_EMPAQUETADO_EXCEPTION);
		}
			
		else if (actionSubmit.equals(i18n.getString(COPIAR_ACTION)) )
		{
			result = COPIAR;
		} 
		else if (actionSubmit.equals(i18n.getString(CORTAR_ACTION))) 
		{
			result = CORTAR;
		} 
		else if (actionSubmit.equals(i18n.getString(PEGAR_ACTION))) 
		{
			result = "Pegar";
		} 
		else if (actionSubmit.equals(i18n.getString(ELIMINAR_ACTION))) {
			result = "Eliminar";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.crearGrupoElemento"))) 
		{
			result = "CrearGrupo";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.crearElemento"))) 
		{
			result = "CrearElemento";
		} 
		
       
         return result;
    }


    public final void subir(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.SubirForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
        String idItem = form.getIdentifier();
        List subPath = sesEmpaq.getSubmanifestPath();
    	OdeVO ultimoPath = (OdeVO) subPath.get(subPath.size()-1);
    	String identificador = subPath.size()==1?sesEmpaq.getIdLocalizador():ultimoPath.getIdentifier();
        this.getSrvGestorManifestService().subirItem(identificador, idItem);
     }


    public final void bajar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.BajarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	List subPath = sesEmpaq.getSubmanifestPath();
    	OdeVO ultimoPath = (OdeVO) subPath.get(subPath.size()-1);
    	String identificador = subPath.size()==1?sesEmpaq.getIdLocalizador():ultimoPath.getIdentifier();
    
    	
    	String idItem = form.getIdentifier();
        
        this.getSrvGestorManifestService().bajarItem(identificador, idItem);
     }



    public final void copiar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.CopiarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String action=COPIAR;
    	List elementos =form.getIdentificadores();
    	
    	copiarCortarComun(request, action, elementos);
    }

    public final void cortar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.CortarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String action=CORTAR;
    	List elementos =form.getIdentificadores();
    	
    	copiarCortarComun(request, action, elementos);
     }

	/**
	 * @param request
	 * @param action
	 * @param elementos
	 */
	private void copiarCortarComun(HttpServletRequest request, String action,
			List elementos) {
		EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	List portapapeles=sesEmpaq.getPortapapeles();
    	List idCollection = sesEmpaq.getIdCollection();
    	
    	Object ultimoIdCollection = idCollection.get(idCollection.size()-1);
    	
    	GrupoVO[] grupos=null;
    	if(idCollection.size()==1)
    	{
    		OrganizacionVO organizacion = (OrganizacionVO)ultimoIdCollection;
    		grupos = organizacion.getGrupos();
     	}
    	else if(idCollection.size()>1)
    	{
    		GrupoVO grupo = (GrupoVO)ultimoIdCollection;
    		grupos=grupo.getGrupos();
    	}	
    	if (grupos!=null) {
			for (int i = 0; i < grupos.length; i++) {
				String identGrupo = grupos[i].getIdentifier();
				if (elementos.contains(identGrupo)) {
					portapapeles.add(grupos[i]);
				}
			}
		}
		sesEmpaq.setAccion(action);
    	sesEmpaq.setPortapapeles(portapapeles);
	}
	
    public final void pegar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.PegarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	List portapapeles = sesEmpaq.getPortapapeles();
    	List idCollection = sesEmpaq.getIdCollection();
    	String destino="";
    	if(sesEmpaq.isModoPegar())
    	{
    		if((portapapeles!=null)&&(portapapeles.size()>0))
    		{
    			Object ultimoIdCollection = idCollection.get(idCollection.size()-1);
    	    
    			GrupoVO[]portapapelesG=(GrupoVO[]) portapapeles.toArray(new GrupoVO[]{});
    			List elementos = new ArrayList();
    			
    	    	for (int i=0; i<portapapeles.size();i++)
    	    	{
    	    		String identificadorElem=portapapelesG[i].getIdentifier();
    	    		elementos.add(identificadorElem);
    	    	}
    	    	String[]elemento=(String[]) elementos.toArray(new String[]{});
    			
    			if(idCollection.size()==1)
    	    	{
    	    		OrganizacionVO organizacion = (OrganizacionVO)ultimoIdCollection;
    	    		destino=organizacion.getIdentifier();
    	    		
    	    	}
    	    	else if(idCollection.size()>1)
    	    	{
    	    		GrupoVO grupo = (GrupoVO)ultimoIdCollection;
    	    		destino=grupo.getIdentifier();
    	    	}	
    			List subPath = sesEmpaq.getSubmanifestPath();
    	    	OdeVO ultimoPath = (OdeVO) subPath.get(subPath.size()-1);
    	    	String identificador = subPath.size()==1?sesEmpaq.getIdLocalizador():ultimoPath.getIdentifier();
    	    	if(sesEmpaq.getAccion().equals(COPIAR))
    	    	{
    	    		this.getSrvGestorManifestService().copiarElementos(identificador, elemento, destino);
    	    	}
    	    	else if(sesEmpaq.getAccion().equals(CORTAR))
    	    	{
    	    		this.getSrvGestorManifestService().moverElementos(identificador, elemento, destino);
    	    	}
    		}
//    		portapapeles.clear();
    	}
    	
    	
    	/*
		 * No vaciar el portapapeles aqui. La siguiente actividad es
		 * vaciarPortapapeles
		 */
//    	sesEmpaq.setAccion("Normal");
//    	sesEmpaq.setModoPegar(false);
//    	sesEmpaq.setPortapapeles(portapapeles);
    }



    public final void eliminar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.EliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	List subPath = sesEmpaq.getSubmanifestPath();
    	OdeVO ultimoPath = (OdeVO) subPath.get(subPath.size()-1);
    	String identificador = subPath.size()==1?sesEmpaq.getIdLocalizador():ultimoPath.getIdentifier();
    	String[] elementos = (String[]) form.getIdentificadoresAsArray();
    
    	for(int i=0; i<elementos.length;i++)
        {
        	this.getSrvGestorManifestService().eliminarGrupo(identificador, elementos[i]);
        }
     }

    
    public final void cambiarVista(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.CambiarVistaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {	
    	Boolean vistaCarp= form.isVistaArbol();
    	
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
     	sesEmpaq.setVistaCarpeta(vistaCarp);
     }

    public final void prepararModificacion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.PrepararModificacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearElementoSession sesElem=this.getCrearElementoSession(request);
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    
    	List idCollection = sesEmpaq.getIdCollection();
    	Object ultimoIdCollection = idCollection.get(idCollection.size()-1);
    	
      	GrupoVO[] grupos=null;
		if(idCollection.size()==1)
      	{
      		OrganizacionVO organizacion = (OrganizacionVO)ultimoIdCollection;
      		grupos=organizacion.getGrupos();	
      	}
      	else if(idCollection.size()>1)
      	{
      		GrupoVO grupo = (GrupoVO)ultimoIdCollection;
      		grupos=grupo.getGrupos();
      	}	
   
		String identificador = form.getIdentifier();
		boolean encontrado=false;
		GrupoVO grupoModif=null;
		for(int i=0;(encontrado==false&&i<grupos.length);i++)
		{
			if(grupos[i].getIdentifier().equals(identificador))
			{
				encontrado=true;
				grupoModif=grupos[i];
			}
		}
		sesElem.setTitle(grupoModif.getTitle());
		if (Boolean.TRUE.equals(grupoModif.getEsRecurso())) {
			sesElem.setReferenciado("Recurso");
		} else if(Boolean.TRUE.equals(grupoModif.getEsSubmanifiesto())) {
			sesElem.setReferenciado("Submanifiesto");
		} else {
			sesElem.setReferenciado("Ninguno");
		}
		sesElem.setIdentifier(grupoModif.getIdentifier());
		sesElem.setIdRef(grupoModif.getElementoReferenciado());
		sesElem.setEsModificar(true);
		sesElem.setIsVisible(grupoModif.getIsVisible());
		if (grupoModif.getTimeLimitAction()!=null)
			sesElem.setTimeLimitAction(grupoModif.getTimeLimitAction().getContent());
		if (grupoModif.getDataFromLMS()!=null)
			sesElem.setDataFromLMS(grupoModif.getDataFromLMS().getContent());
		if (grupoModif.getCompletionThreshold()!=null)
			sesElem.setCompletionThreshold(grupoModif.getCompletionThreshold().getContent());
		PresentationVO presentationVO = grupoModif.getPresentation();
		if (presentationVO!=null){
			NavigationInterfaceVO navigVO = presentationVO.getNavigationInterface();
			if(navigVO!=null){
				HideLMSUIVO[] hide = navigVO.getHideLMSUI();
				if(hide!=null){
					ArrayList listPresentation= new ArrayList();
					for(int i=0;i < hide.length; i++){
						if(hide[i]!=null)
							listPresentation.add(hide[i].getContent());
					}
					String[] selectPresentation = (String[]) listPresentation.toArray(new String[listPresentation.size()]);
					sesElem.setSelectPresentation(selectPresentation);
				}
			}
		}
			
     }


    public final void prepararSecuencia(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.PrepararSecuenciaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    
    	List idCollection = sesEmpaq.getIdCollection();
    	Object ultimoIdCollection = idCollection.get(idCollection.size()-1);
    	SecuenciaVO[] secuencia =null;
      	if(idCollection.size()==1)
      	{
      		OrganizacionVO organizacion = (OrganizacionVO)ultimoIdCollection;
      		secuencia=organizacion.getSecuencia();
      		
      	}
      	else if(idCollection.size()>1)
      	{
      		GrupoVO grupo = (GrupoVO)ultimoIdCollection;
      		secuencia=grupo.getSecuencia();
      	}	
   
//		SecuenciaVO ultimaSecuencia=null;
      	boolean encontrado = false;
      	if(secuencia!=null)
      	{
	      	for(int i=0; (encontrado==false && i<secuencia.length);i++)
	      	{
	      		if(secuencia[i].getControlMode()!=null)
	      		{
	      			encontrado=true;
//	      			ultimaSecuencia=secuencia[i];
					ControlModeVO controlM = secuencia[i].getControlMode();
					form.setChoice(controlM.getChoice());
					form.setChoiceExit(controlM.getChoiceExit());
					form.setFlow(controlM.getFlow());
					form.setForwardOnly(controlM.getForwardOnly());
	      		}
	      	}
//	      	if (encontrado) {
//				ControlModeVO controlM = ultimaSecuencia.getControlMode();
//				form.setChoice(controlM.getChoice());
//				form.setChoiceExit(controlM.getChoiceExit());
//				form.setFlow(controlM.getFlow());
//				form.setForwardOnly(controlM.getForwardOnly());
//			}
      	}
      	if(!encontrado) {
      		form.setChoice(Boolean.TRUE);
          	form.setChoiceExit(Boolean.FALSE);
          	form.setFlow(Boolean.TRUE);
          	form.setForwardOnly(Boolean.FALSE);
      	}
   	}

	public final void eliminarPortapapeles(ActionMapping mapping, EliminarPortapapelesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		EmpaquetadorSession sesEmpa=this.getEmpaquetadorSession(request);
    	
    	List portapapeles = sesEmpa.getPortapapeles();
    	
    	String identificadorEliminar=form.getIdentifier();
    	
    	//voy recorriendo el portapapeles comprobando el nombre a eliminar
    	if(portapapeles!=null && portapapeles.size()>0)
    	{
	    	for(int i=0; i<portapapeles.size();i++)
	    	{
	    		GrupoVO porta=(GrupoVO) portapapeles.get(i);
	    		if (porta.getIdentifier().equals(identificadorEliminar))
	    		{
	    			portapapeles.remove(i);
	    		}
	    	}
	    	
	    	if(portapapeles.size()==0)
	    	{
	    		sesEmpa.setAccion(NORMAL);
	    		sesEmpa.setModoPegar(false);
	    	}
	    	 // inserto el portapapeles sin el elemento a eliminar
	    	sesEmpa.setPortapapeles(portapapeles);
    	}
    	else
    	{
    		throw new ValidatorException(PORTAL_EMPAQUETADO_EXCEPTION_SESSION);
    	}
    	
       
		
	}

	public final void vaciarPortapapeles(ActionMapping mapping, VaciarPortapapelesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		 
    	EmpaquetadorSession sesEmpa=this.getEmpaquetadorSession(request);
		
    	List portapapeles=sesEmpa.getPortapapeles();
    	if(portapapeles!=null && portapapeles.size()>0)
    	{
    		portapapeles.clear();
    		sesEmpa.setPortapapeles(portapapeles);
    		sesEmpa.setAccion(NORMAL);
    		sesEmpa.setModoPegar(false);
    	}
    	else
    	{
    		throw new ValidatorException(PORTAL_EMPAQUETADO_EXCEPTION_SESSION);
    	}
		
	}
       
  


}