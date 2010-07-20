/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformes;


import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.informes.servicio.InformeVO;
import es.pode.contenidos.negocio.informes.servicio.SrvInformeService;



/**
 * @see es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController
 */
public class ListarInformesControllerImpl extends ListarInformesController
{


	private static Logger log = Logger.getLogger(ListarInformesControllerImpl.class);
	//final int BUFFER_SIZE = 2048;
	final int BUFFER_SIZE = 10000;



    /**
     * @see es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController#listarInformes(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.listarInformes.ListarInformesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void listarInformes(ActionMapping mapping, es.pode.administracion.presentacion.informes.listarInformes.ListarInformesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	try{
    		SrvInformeService srvInformeService = this.getSrvInformeService();
    		InformeVO[] informes = srvInformeService.listarInformes();
    		form.setInformesAsArray(cambiarFechaInforme(informes));
    	}catch (Exception e){
        	log.error("Se ha producido un error al listar los informes: " + e);
        	throw new ValidatorException ("{errors.listarInformes}");
    	}
    	
    	
     }
    
    private InformeDateVO[] cambiarFechaInforme (InformeVO[] lista){
    	InformeDateVO[] array=null;
    	if(lista!=null && lista.length>0){
	    	array = new InformeDateVO[lista.length];
	    	for (int i=0; i< lista.length; i++){
	    		array[i] = new InformeDateVO(); 
	    		array[i].setFecha(lista[i].getFecha().getTime());
	    		array[i].setNombre(lista[i].getNombre());
	    	}
    	}else{
    		array = new InformeDateVO[0];
    	}
    	return array;
    }




    /**
     * @see es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController#getInformes(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.listarInformes.GetInformesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void getInformes(ActionMapping mapping, es.pode.administracion.presentacion.informes.listarInformes.GetInformesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		List lista = ((FormularioListarInformesEliminarFormImpl)form).getNombreRowSelection();
    		if (lista == null){
    			throw new ValidatorException ("{errors.eliminarInformes.nombreNulo}");
	       }
	    	form.setIds(lista);
	    	if(log.isDebugEnabled())log.debug("Se van a eliminar los siguientes informes: " + lista); 
    	} catch (Exception e){
    		log.error("Se ha producido un error al intentar recuperar los ids de los informes a borrar: " +e);
    		throw e;
    	}

     }







    /**
     * @see es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController#recuperarInforme(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.listarInformes.RecuperarInformeForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarInforme(ActionMapping mapping, es.pode.administracion.presentacion.informes.listarInformes.RecuperarInformeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		try{
			String fichero = (String)form.getNombre();
			DataHandler dataHandler = null;
			SrvInformeService informeService = this.getSrvInformeService();
			try {
				dataHandler = informeService.recuperarInforme(fichero);
				
				
			}catch (Exception e){
				log.error("Error al recuperar el fichero");
			}
			if (dataHandler==null){
				log.error("El fichero recuperado está vacio");
				throw new ValidatorException("{recuperarInforme.FALLO}");
			}
			if (fichero.endsWith(".pdf")){
				response.setContentType("application/pdf");
			} else if (fichero.endsWith(".html") || fichero.endsWith(".htm")) {
				response.setContentType("application/html");
			} else if (fichero.endsWith(".xls")) {
				response.setContentType("application/xls");
			} else if (fichero.endsWith(".doc")) {
				response.setContentType("application/doc");
			}
			response.setHeader("Content-Disposition", "attachment;filename="+fichero);
			OutputStream out = response.getOutputStream();
			InputStream in = dataHandler.getInputStream();
			if(log.isDebugEnabled())log.debug("recuperando el fichero " + fichero);
			byte[] buffer = new byte[BUFFER_SIZE];
			int count;
			while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
			{
				out.write(buffer, 0, count);
			}
			
			out.flush();
			out.close();
			
		} catch (ValidatorException e){
			throw e;
		} catch (Exception e){
			log.error("Se ha producido el siguiente error: " +e);
			throw e;
		}
    	
    	
     }
    
    
    //Se crea un VO con la fecha tipo Date no Calendar
    public class InformeDateVO
    implements java.io.Serializable
{

    public InformeDateVO()
    {
    }

    /**
     * Constructor taking all properties.
     */
    public InformeDateVO(
        java.lang.String nombre,
        java.util.Date fecha)

    {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    /**
     * Copies constructor from other InformeVO
     */
    public InformeDateVO(InformeDateVO otherBean)
    {
        if (otherBean != null)
        {
            this.nombre = otherBean.getNombre();
            this.fecha = otherBean.getFecha();
        }
    }

    private java.lang.String nombre;

    /**
     * 
     */
    public java.lang.String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

    private java.util.Date fecha;

    /**
     * 
     */
    public java.util.Date getFecha()
    {
        return this.fecha;
    }

    public void setFecha(java.util.Date fecha)
    {
        this.fecha = fecha;
    }

}


}