/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.monitorizarnodos.monitorizar;


import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.buscar.negocio.monitorizar.servicio.EstadoNodoVO;
import es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.monitorizarnodos.monitorizar.MonitorizarNodosController
 */
public class MonitorizarNodosControllerImpl extends MonitorizarNodosController
{



	private static Logger log = Logger.getLogger(MonitorizarNodosControllerImpl.class);
	ResourceBundle ficheroRecursos = null;


    /**
     * @see es.pode.administracion.presentacion.monitorizarnodos.monitorizar.MonitorizarNodosController#estadoNodos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.monitorizarnodos.monitorizar.EstadoNodosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void estadoNodos(ActionMapping mapping, es.pode.administracion.presentacion.monitorizarnodos.monitorizar.EstadoNodosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

    	
    	
    	try{
    	
	    	
			SrvMonitorizarService service =  this.getSrvMonitorizarService();
        	EstadoNodoVO[] estados = service.obtenerEstadoNodos();
        	prepararInformacion(estados, request.getLocale());
        	form.setEstadosAsArray(estados);
        } catch (Exception e){
        	log.error("Se ha producido un error al monitorizar los nodos: " + e);
        	throw new ValidatorException ("{errors.monitorizarnodos}");
        }

    	
     }

    
    //traduce la descripción del nombre del servicio
    private void prepararInformacion(EstadoNodoVO[] estadosVO, Locale locale){
    	String descripcion = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
    	for (int i=0; i<estadosVO.length;i++ ){
    		//intentamos traducir el nombre del servicio, si no se puede dejamos el de la BBDD
			try
			{
				descripcion = ficheroRecursos.getString(estadosVO[i].getNombreServicio());
			}
			catch(Exception ex)
			{
				log.warn("El nombre del servicio " + estadosVO[i].getNombreServicio() + " no esta en el fichero de internacionalizacion");
				descripcion = estadosVO[i].getDescripcionServicio();
			}
			estadosVO[i].setDescripcionServicio(descripcion);
    	}
    }
    

}