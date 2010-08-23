/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.importar;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePartDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;



public class ImportarControllerImpl extends ImportarController
{

	private static final Logger logger = Logger.getLogger(ImportarControllerImpl.class);


    public final void subirFichero(
    		ActionMapping mapping, 
    		SubirFicheroForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	//llamar a la validacion
		DataHandler dh= this.getCatalogadorAvSession(request).getLomesImportado();

		// llamo al servicio de catalogacion para obtener un LomAvanzadoVO
    	LomAvanzadoVO lomAv=null;
    	try{
    		//En caso de que se vaya la sesion dh sera null, y para que no de excepcion por llamada al servicio con
    		//parametro vacio lo controlamos aqui
    		if (dh!=null) {
    			lomAv = this.getSrvCatalogacionAvanzadaService().importarLomes(dh);
    		}else {
    			throw new Exception(); 
    		}
    	}catch(Exception e)
    	{
			if (logger.isDebugEnabled()) {logger.debug("error al llamar al servicio");}
			this.saveErrorMessage(request, "catalogadorAvanzado.importar.error");
    	}
    	
    	if(lomAv!=null)
    	{
			//mensaje de exito
			this.saveSuccessMessage(request, "catalogadorAvanzado.importar.exito");
			
	    	// cargo el lomavanzado obtenido en sesion
			this.getCatalogadorAvSession(request).setMDSesion(lomAv);
    	}
    	//elimino el lomes importado de sesion
    	this.getCatalogadorAvSession(request).setLomesImportado(null);
    }


	public String submit(
			ActionMapping mapping, 
			SubmitForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		String resultado="";
		String action=form.getAccion();
		
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle i18n =I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
		if(action!=null)
		{
			if(action.equals(i18n.getString("catalogadorAvanzado.importar.aceptar")))
			{
				resultado= "Aceptar";
		    	if(form.getFichero()==null || form.getFichero().getFileName().equals("") || form.getFichero().getFileSize()==0)
		    		throw new ValidatorException("{catalogadorAvanzado.importar.error.ficherovacio}");
		    	
		    	//crear el datahandler
				InternetHeaders ih = new InternetHeaders();
				MimeBodyPart mbp = null;
				DataSource source = null;
				DataHandler dh = null;
				try
				{
					FormFile ff=(FormFile) form.getFichero();
					mbp = new MimeBodyPart(ih, ff.getFileData());
					source = new MimePartDataSource(mbp);
					dh = new DataHandler(source);
				}catch (Exception e) {
					if (logger.isDebugEnabled()) {logger.debug("error al crear el datahandler");}
					throw new ValidatorException("{catalogadorAvanzado.importar.error}");
				}

		    	//validar el fichero
		    	Boolean valido= new Boolean(false);
		    	try{
		    		valido= this.getSrvValidadorService().obtenerValidacionLomes(dh);
		    	}catch(Exception e)
		    	{
					if (logger.isDebugEnabled()) {logger.debug("error al llamar al servicio de validación");}
					throw new ValidatorException("{catalogadorAvanzado.importar.error.novalido}");
		    	}
				
		    	if(!valido.booleanValue())
		    		throw new ValidatorException("{catalogadorAvanzado.importar.error.novalido}");
				
				//agregar el datahandler a sesion
				this.getCatalogadorAvSession(request).setLomesImportado(dh);
				
				
			}else if(action.equals(i18n.getString("catalogadorAvanzado.importar.cancelar")))
				resultado= "Cancelar";
		}
		return resultado;
	}
	
	
	private boolean lomesVacio(HttpServletRequest request)
	throws Exception
	{
		boolean resultado= true;
		LomAvanzadoVO lomav= this.getCatalogadorAvSession(request).getMDSesion();
		
		if(lomav.getGeneral()!=null)
			resultado=false;
		if(lomav.getLifeCycle()!=null)
			resultado=false;
		if(lomav.getMetaMetadata()!=null)
			resultado=false;
		if(lomav.getTechnical()!=null)
			resultado=false;
		if(lomav.getEducational()!=null && lomav.getEducational().length>0)
			resultado=false;
		if(lomav.getDerechos()!=null)
			resultado=false;
		if(lomav.getRelaciones()!=null && lomav.getRelaciones().length>0)
			resultado=false;
		if(lomav.getAnotaciones()!=null && lomav.getAnotaciones().length>0)
			resultado=false;
		if(lomav.getClasificaciones()!=null && lomav.getClasificaciones().length>0)
			resultado=false;

		return resultado;
	}


	public String comprobarLomesVacio(
			ActionMapping mapping, 
			ComprobarLomesVacioForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String resultado="Vacio";
		try{
			if(!lomesVacio(request))
				resultado="NoVacio";
		}catch(Exception e )
		{
			logger.debug("error compbrobando lomes vacio");
		}
		
		return resultado;
	}
	
	
	
	
	
	
	

	public String submitAdvertencia(
			ActionMapping mapping, 
			SubmitAdvertenciaForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String resultado="";
		String action=form.getAccion();
		
		//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		ResourceBundle i18n = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
		if(action!=null)
		{
			if(action.equals(i18n.getString("catalogadorAvanzado.importar.advertencia.aceptar")))
			{
				resultado= "Aceptar";
			}else 
			{
				resultado= "Cancelar";
				this.getCatalogadorAvSession(request).setLomesImportado(null);
			}
		}
		return resultado;
	}

	
	
	
	
	
	
}