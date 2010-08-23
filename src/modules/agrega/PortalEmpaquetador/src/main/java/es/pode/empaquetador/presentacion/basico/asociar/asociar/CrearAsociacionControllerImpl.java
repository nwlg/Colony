/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.asociar;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.basico.asociar.AsociarSession;
import es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerImpl;



/**
 * @see es.pode.empaquetador.presentacion.basico.asociar.asociar.CrearAsociacionController
 */
public class CrearAsociacionControllerImpl extends CrearAsociacionController
{

	private static Logger logger = Logger.getLogger(GestorBasicoControllerImpl.class);





    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.asociar.CrearAsociacionController#crearRecurso(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.asociar.CrearRecursoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearRecurso(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.asociar.CrearRecursoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociarSession asociarSesion =this.getAsociarSession(request);
    	EmpaquetadorSession empSesion= this.getEmpaquetadorSession(request);
    	FileVO[] files= new FileVO[asociarSesion.getFicheros().size()];
    	for(int i=0; i<asociarSesion.getFicheros().size();i++)
    	{
    		files[i]= (FileVO)asociarSesion.getFicheros().get(i);
    	}
    	
    	try{
    		this.getSrvEmpaquetadorBasicoService().asociarContenidos(
    			empSesion.getIdLocalizador(), 
    			asociarSesion.getIdGrupo(), 
    			files,
    			asociarSesion.getHref());
    	}catch(RemoteException re)
    	{
    		if(logger.isDebugEnabled()) logger.debug("el Servicio devolvio un error, no se pudeo asociar los ficheros al recurso ");
    		this.saveErrorMessage(request,"{portal_empaquetado.exception}");
    	}catch(Exception e)
    	{
    		if(logger.isDebugEnabled()) logger.debug("ocurrio un error mientras se asociaban los ficheros al recurso " );
    		this.saveErrorMessage(request,"{portal_empaquetado.exception}");
    	}
    	// Eliminamos los datos de la sesion
    	this.removeAsociarSession(request);
    }

}