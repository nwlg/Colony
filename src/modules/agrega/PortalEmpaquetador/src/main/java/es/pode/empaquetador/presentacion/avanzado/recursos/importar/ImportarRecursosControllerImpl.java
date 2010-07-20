/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.importar;

import java.util.List;
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
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.importar.ImportarRecursosController
 */
public class ImportarRecursosControllerImpl extends ImportarRecursosController
{

    public final void importarZIP(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.recursos.importar.ImportarZIPForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String opcion=form.getAction();
		
		if (opcion.equals(i18n.getString("portalempaquetado.avanzado.recursos.aceptar")))
    	{
			
				FormFile fichero = form.getFichero();
				if(fichero.getFileName()==null || fichero.getFileName().equals("") || fichero.getFileSize()==0)
				{
					throw new ValidatorException("{portalempaquetado.avanzado.recursos.importar.exception}");
					//tratar exception
				}
				try
				{	
				
				InternetHeaders ih = new InternetHeaders();
				MimeBodyPart mbp = null;
				DataSource source = null;
				DataHandler dFichero = null;
				
				
				mbp = new MimeBodyPart(ih, fichero.getFileData());
	    		source = new MimePartDataSource(mbp);
	    		dFichero = new DataHandler(source);
	    		
	    		EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
	        	
	        	
	        	List listSubmPath = sesEmpaq.getSubmanifestPath();
	        	
	        	//cojo el primer elemento que dedberia ser el padre
	    		String identificador=sesEmpaq.getIdLocalizador();
	    		if(listSubmPath.size()==1)
	    		{
	    			this.getSrvGestorManifestService().importarRecursos(identificador,dFichero,null);
	    		}
	    		else if(listSubmPath.size()>1)
	    		{
		    		OdeVO odeultim= (OdeVO) listSubmPath.get(listSubmPath.size()-1);
		    		String submanifestId=odeultim.getIdentifier();
		    		this.getSrvGestorManifestService().importarRecursos(identificador,dFichero, submanifestId);
	    		}
			}
			catch (Exception e) 
			{
				throw new ValidatorException("{portalempaquetado.avanzado.recursos.importar.exception.validar}");
				
			}
    	}
		
    }

}
