/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformesFederados;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.informes.servicio.InformeVO;
import es.pode.contenidos.negocio.informes.servicio.SrvInformeService;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosController
 */
public class ListarInformesFederadosControllerImpl extends ListarInformesFederadosController
{


	private static Logger logger = Logger.getLogger(ListarInformesFederadosControllerImpl.class);

	final int BUFFER_SIZE = 10000;

    /**
     * @see es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosController#listarInformesFederados(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void listarInformesFederados(ActionMapping mapping, es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		
    	try{
    		SrvInformeService srvInformeService = this.getSrvInformeService();
    		InformeVO[] informes = srvInformeService.listarInformesFederados();
    		form.setInformesAsArray(cambiarFechaInforme(informes));
    	}catch (Exception e){
        	logger.error("Se ha producido un error al listar los informes federados: " + e);
        	throw new ValidatorException ("{errors.listarInformesFederados}");
    	}
     }







    /**
     * @see es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosController#recuperarInformeFederado(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.listarInformesFederados.RecuperarInformeFederadoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarInformeFederado(ActionMapping mapping, es.pode.administracion.presentacion.informes.listarInformesFederados.RecuperarInformeFederadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
			String fichero = (String)form.getNombre();
			DataHandler dataHandler = null;
			SrvInformeService informeService = this.getSrvInformeService();
			try {
				dataHandler = informeService.recuperarInformesFederados(fichero);
				
				
			}catch (Exception e){
				logger.error("Error al recuperar el fichero");
			}
			if (dataHandler==null){
				logger.error("El fichero recuperado está vacio");
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
			if(logger.isDebugEnabled())logger.debug("recuperando el fichero federado" + fichero);
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
			logger.error("Se ha producido el siguiente error: " +e);
			throw e;
		}
     }







    /**
     * @see es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosController#getInformesFederados(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.listarInformesFederados.GetInformesFederadosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void getInformesFederados(ActionMapping mapping, es.pode.administracion.presentacion.informes.listarInformesFederados.GetInformesFederadosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    		List lista = ((FormularioListarInformesFederadosEliminarFormImpl)form).getNombreRowSelection();
    		if (lista == null){
    			throw new ValidatorException ("{errors.eliminarInformes.nombreNuloFederado}");
	       }
	    	form.setIds(lista);
	    	if(logger.isDebugEnabled())logger.debug("Se van a eliminar los siguientes informes federados: " + lista); 
    	} catch (Exception e){
    		logger.error("Se ha producido un error al intentar recuperar los ids de los informes federados a borrar: " +e);
    		throw e;
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
	
		public java.lang.String getNombre() {
			return nombre;
		}
	
		public void setNombre(java.lang.String nombre) {
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