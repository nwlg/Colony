/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.presentacion.visualizadorAdl;

import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adl.server.LMSManifestHandler;
import es.pode.adl.util.ADLUtils;
import es.pode.adl.validator.ADLValidatorOutcome;
import es.pode.adl.validator.contentpackage.LaunchData;
import es.pode.entregar.negocio.servicios.LocalizadorAdlVO;
import es.pode.entregar.negocio.servicios.PaquetePifDriVO;
import es.pode.entregar.negocio.servicios.PaquetePifVO;
import es.pode.entregar.negocio.servicios.TipoPifVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.utiles.ficheros.*;

/**
 * @see es.pode.presentacion.visualizadorAdl.VisualizadorAdlController
 */
public class VisualizadorAdlControllerImpl extends VisualizadorAdlController
{
	protected static Logger logger = Logger.getLogger(VisualizadorAdlControllerImpl.class);

    /**
     * @see es.pode.presentacion.visualizadorAdl.VisualizadorAdlController#cargarDatosAdl(org.apache.struts.action.ActionMapping, es.pode.presentacion.visualizadorAdl.CargarDatosAdlForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDatosAdl(ActionMapping mapping, es.pode.presentacion.visualizadorAdl.CargarDatosAdlForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    try{
    	String identificador = request.getParameter("identificador");//"MANIFEST-67ECF89A-C6CD-F6D0-F8A1-259F762A6F1B";//request.getParameter("identificador");
    	String idioma= request.getParameter("idioma");
    	LocalizadorAdlVO localAdl = this.getSrvEntregarService().localizacionPaquetePIF(identificador);
    	
    	request.getSession().setAttribute("rutaodes", localAdl.getPath());
			
		LMSManifestHandler lmsManifestHandler = new LMSManifestHandler(localAdl.getPath());
   		
		//rellenamos el webpath con la ruta de la clase
		String adlutilpath = ADLUtils.getADLUserDir();
   		lmsManifestHandler.setWebPath(adlutilpath);
   		lmsManifestHandler.setCourseID(identificador); //"my_Photoshop"
   		//identificador de la session
   		//http://+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() +”/”+url
   		String probandoHost = "http://" +LdapUserDetailsUtils.getHost()+ LdapUserDetailsUtils.getSubdominio();
   		
   		String miUrl= probandoHost + (localAdl.getUrl().startsWith("/")?localAdl.getUrl():"/"+localAdl.getUrl())+ "/";
   		lmsManifestHandler.setIdSession(request.getSession().getId());
   		ADLValidatorOutcome adlvaloutcome= lmsManifestHandler.processPackage(localAdl.getPath(), false);
   		if (adlvaloutcome.getIsValidRoot()) {
   			logger.info("El Root es Valido! ");
   	        request.getSession().setAttribute("COURSEID", lmsManifestHandler.getCourseID());
   	        request.getSession().setAttribute("USERID", "admin");
   	        request.getSession().setAttribute("TOC", "true");
   	        request.getSession().setAttribute("activityID", null);
   	        request.getSession().setAttribute("launchdataList", lmsManifestHandler.getLaunchDataList());
   	        request.getSession().setAttribute("idSession", lmsManifestHandler.getIdSession().toString());
   	    	request.getSession().setAttribute("webPath", lmsManifestHandler.getWebPath());
   	        
   	        //Conversion de launchdataList
   	        Vector vLD = new Vector();
   	        vLD = (Vector)request.getSession().getAttribute("launchdataList");
   	        Vector newVLD = new Vector();
   	        int iv=0;
   	        while (iv<vLD.size()) {
   	        	LaunchData ld = (LaunchData)vLD.get(iv);
   	        	String alteredLocation = new String();
                    //If it's blank or it's external, don't concatenate to the 
                    //local Web root.
                    if ((ld.getLocation().equals(""))|| (ld.getLocation().startsWith("http://"))||
                        (ld.getLocation().startsWith("https://")))
                    {
                   	alteredLocation = URLDecoder.decode(ld.getLocation(), "UTF-8" ); 
                       if ( !(ld.getParameters().equals("")) && 
                             !(ld.getParameters() == null ) )
                       {
                          alteredLocation = lmsManifestHandler.addParameters(alteredLocation,ld.getParameters());
                       }
                    } else
                    {                    	                    	
                       // Create the altered location (with decoded url)
                    	alteredLocation=miUrl +  URLDecoder.decode(ld.getLocation(),"UTF-8" );
                   	 	if ( !(ld.getParameters().equals("")) && 
                   	 		!(ld.getParameters() == null ) )
                   	 	{
                          alteredLocation = lmsManifestHandler.addParameters(alteredLocation,ld.getParameters());
                   	 	}
                    }	
   	         ld.setLocation(alteredLocation);
   	         newVLD.add(ld);
   	         iv++;
   	        }
   	        //lo metemos en session
   	        request.getSession().setAttribute("launchdataList", newVLD);   	        
   			
   		}else {
   			logger.info(" El Root no es Valido! ");
   		}
   		
   }
   catch (Exception ex)
   {
			logger
			.error("Error en Servicio de visualizador Adl, metodo cargarDatosAdl " + ex);
			logger.error(ex);
   }
	
   }

	@Override
	public void borrarDatosAdl(ActionMapping mapping, BorrarDatosAdlForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String identificador = request.getParameter("identificador");
		HttpSession session = request.getSession();
		//de ahí hay que borrar 
		String rutaAux= session.getAttribute("webPath") + File.separator + session.getAttribute("idSession");
        File fileAux = new File(rutaAux);
		try {
			UtilesFicheros.eliminar(fileAux);
			logger.info("eliminada la ruta de ficheros!!");
			session.invalidate();
		}catch (Exception e) {
			logger.error("Error en Servicio visualizador, método borrarDatosAdl " + e);
		}
	}

}



