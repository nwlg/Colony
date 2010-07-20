/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.visualizador.presentacion.informes;


import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.contenidos.negocio.informes.servicio.InformeVO;
import es.pode.contenidos.negocio.informes.servicio.SrvInformeService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.visualizador.presentacion.informes.ListarInformesController
 */
public class ListarInformesControllerImpl extends ListarInformesController
{


	private static Logger log = Logger.getLogger(ListarInformesControllerImpl.class);
	final int BUFFER_SIZE = 10000;

 
    /**
     * Lista en la portada los informes 'Mas' generados mediante una tarea programada
     */
    public final void listarInformes(ActionMapping mapping, es.pode.visualizador.presentacion.informes.ListarInformesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log.debug("ListarInformes");
    	try{
    		SrvInformeService srvInformeService = this.getSrvInformeService();
    		log.debug("srvInformeService "+srvInformeService);
    		InformeVO[] informes = srvInformeService.listarInformesMas();
    		if(informes == null)
    		{
    			log.debug("No hay informes");
    		}else
    		{
    			log.debug("Listado de informes Mas "+informes.length);
    		}
    		form.setPathInformes(AgregaPropertiesImpl.getInstance().getProperty("pathInformesPortada"));
    		form.setInformesAsArray(informes);
    	}catch (Exception e){
        	log.error("Se ha producido un error al listar los informes: " + e);
        	throw new ValidatorException ("{errors.listarInformes}");
    	}
     }

   

}