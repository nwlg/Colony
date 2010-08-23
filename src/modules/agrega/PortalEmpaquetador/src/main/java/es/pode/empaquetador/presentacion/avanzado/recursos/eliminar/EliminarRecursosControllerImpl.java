/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.eliminar;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.DependenciaVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosSubmitFormImpl;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarRecursosController
 */
public class EliminarRecursosControllerImpl extends EliminarRecursosController
{

	private boolean submanifiestos(OdeVO[] ode,List recursos)
	{
		boolean hayRef=false;
		
		for(int i=0; i<ode.length;i++)
		{
		  RecursoVO[] recursosOde = ode[i].getRecursos();
		  for(int s=0;( s<recursosOde.length|| hayRef==true);s++)
		  {
			  if(recursos.contains(recursosOde[s]))
			  {
				  hayRef=true;
			  }
		  }
		  
		  OrganizacionVO[] organizaciones = ode[i].getOrganizaciones();
		  for(int j=0;j<organizaciones.length;j++ )
		  {
			GrupoVO[] grupos = organizaciones[j].getGrupos();
			for(int s=0;( s<grupos.length || hayRef==true);s++)
			{
				for (int z=0; (z<recursos.size()|| hayRef==true);z++)
				{
					if (((RecursoVO)recursos.get(z)).getIdentifier().equals(grupos[s].getElementoReferenciado()))
						hayRef=true;
				}
			 }
		  }
			
		
		  OdeVO[] submanifest = ode[i].getSubmanifiestos();
		  if(submanifest!=null || hayRef==false)
		  {
			  submanifiestos(submanifest,recursos);
		  }
		}
		return hayRef;
	}


//	Hecho
    public final java.lang.String hayReferencias(
    		ActionMapping mapping, 
    		es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.HayReferenciasForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
//      boolean hayRef=false;
      EmpaquetadorSession sesEmp=this.getEmpaquetadorSession(request);
      List recursos = form.getRecursosVO();
      OdeVO ode = (OdeVO)sesEmp.getSubmanifestPath().get(0);
      String resultado="No";
      if(ode!=null)
      {
    	  for (Iterator iter = recursos.iterator(); iter.hasNext();) 
    	  {
			String idRef= ((RecursoVO) iter.next()).getIdentifier();
			if(_hayReferencias(ode, idRef))
				return "Si";
    	  }
      }
      
      return resultado;
    }
//   Hecho
    public final void eliminar(
    		ActionMapping mapping, 
    		es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	String accion = form.getAction();
    	if (accion.equals(i18n.getString("portalempaquetado.avanzado.recursos.aceptar")) ||
    		accion.equals(i18n.getString("portal_empaquetado_recurso.eliminar")) ) 
    	{
    		if(request.getSession().getAttribute("form") instanceof  GestorRecursosSubmitFormImpl)
    		{
    			form.setRecursosVO( ((GestorRecursosSubmitFormImpl) request.getSession().getAttribute("form")).getRecursosVO() );
    		}else{
    			form.setRecursosVO( ((EliminarRecursosFormImpl) request.getSession().getAttribute("form")).getRecursosVO() );
    		}
    		
	    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
	        
	    	//todo ojo internacionalizacion
	        List path=sesEmpaq.getSubmanifestPath();
	    	OdeVO ultimo=(OdeVO) path.get(path.size()-1);
	    	Integer index=path.size()-1;
	    	String idOde = index==0?sesEmpaq.getIdLocalizador():ultimo.getIdentifier();
	    	List recursosEliminar = form.getRecursosVO();
	    	String identificador= "";
	    	
	    	if(recursosEliminar!=null && !recursosEliminar.isEmpty())
	    	{
	        	String[] recursosIdent = new String[recursosEliminar.size()] ;
	        	Object[] o=	recursosEliminar.toArray();
				
		    	for(int i=0; i<o.length;i++)
		    	{
		    		identificador=((RecursoVO) o[i]).getIdentifier();
		    		recursosIdent[i]=identificador;
		    	}
		    	this.getSrvGestorManifestService().eliminarRecursos(idOde, recursosIdent);
	
	    	}
    	}
    }



    private boolean _hayReferencias(Object o, String idRef)
    {
    	int i;
    	int j;
    	boolean resultado=false;
    	
    	//si es un ode
    	if(o instanceof OdeVO)
    	{
    		OdeVO ode =(OdeVO) o;
    		
    		RecursoVO[] recursos = ode.getRecursos();
    		//si tiene recursos verifico que no exista la referencia
    		if(recursos!=null && recursos.length>0)
    		{
    			DependenciaVO[] dep;
    			for(i=0;i<recursos.length;i++ )
    			{
    				dep= recursos[i].getDependencias();
    				if(dep!=null)
    				{
	    				for (j = 0; j< dep.length; j++) 
	    				{
							if(dep[j].getIdRef().equals(idRef))
								return true;
	    				}
	    			}
    			}
    		}
    		
    		// si tiene grupo, llamo nuevamente
    		OrganizacionVO[] orgs = ode.getOrganizaciones();
    		if(orgs!=null && orgs.length>0)
    		{
    			for (i = 0; i < orgs.length; i++) 
    			{
    				GrupoVO[] grupos = orgs[i].getGrupos();
    				if(grupos!=null)
    				{
	    				for (j = 0; j < grupos.length; j++) 
	    				{
							if(_hayReferencias(grupos[j] , idRef))
							{
								return true;
							}
						}
    				}
				}
    		}
    		
    		
    		
    		
    		
    		OdeVO[] subm =ode.getSubmanifiestos();  
    		
//    		si tiene submanifiestos vuelvo a llamar
    		if(subm !=null && subm.length>0)
    		{
    			for(i=0;i<subm.length;i++)
    			{
    				if( _hayReferencias(subm[i], idRef))
    				{
    					return true;
    				}
    			}
    		}
    		
    	}else if(o instanceof GrupoVO )
    	{
    		GrupoVO grupo = (GrupoVO) o;
    		
    		if(grupo.getElementoReferenciado()!=null &&  grupo.getElementoReferenciado().equals(idRef))
    		{
    			return true;
    		}else
    		{
    			GrupoVO[] subGrupos= grupo.getGrupos();
    			if(subGrupos!=null)
    			{
	    			for (i = 0; i < subGrupos.length; i++) 
	    			{
						 if(_hayReferencias( subGrupos[i] , idRef))
							 return true;
					}
    			}
    		}
    	}
    	
    	return resultado;
    }





}