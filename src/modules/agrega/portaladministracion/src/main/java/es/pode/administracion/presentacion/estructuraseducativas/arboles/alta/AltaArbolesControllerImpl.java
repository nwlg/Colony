/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.arboles.alta;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.pode.administracion.presentacion.estructuraseducativas.tesauros.alta.AltaTesaurosControllerImpl;
import es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService;
import es.pode.fuentestaxonomicas.negocio.servicio.VdexVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.administracion.presentacion.estructuraseducativas.arboles.alta.AltaArbolesController
 */
public class AltaArbolesControllerImpl extends AltaArbolesController
{

	private static Logger logger= Logger.getLogger(AltaTesaurosControllerImpl.class);

    public final void nuevoArbol(
    		ActionMapping mapping, 
    		NuevoArbolForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	VdexVO[] resultado=null;

    	List ficheros=new ArrayList();
    	if(form.getFichero1()!=null && form.getFichero1().getFileName()!=null && !form.getFichero1().getFileName().equals("") )//&& form.getFichero1().getFileSize()>0 
    		ficheros.add(form.getFichero1());
    	if(form.getFichero2()!=null && form.getFichero2().getFileName()!=null && !form.getFichero2().getFileName().equals("") )
    		ficheros.add(form.getFichero2());
    	if(form.getFichero3()!=null && form.getFichero3().getFileName()!=null && !form.getFichero3().getFileName().equals("") )
    		ficheros.add(form.getFichero3());
    	if(form.getFichero4()!=null && form.getFichero4().getFileName()!=null && !form.getFichero4().getFileName().equals("") )
    		ficheros.add(form.getFichero4());
    	if(form.getFichero5()!=null && form.getFichero5().getFileName()!=null && !form.getFichero5().getFileName().equals("") )
    		ficheros.add(form.getFichero5());
    	
    	
		if(ficheros.size()==0)
		{
			throw new ValidatorException("{estructuras.arboles.error.fichero.vacio}");
		}
		
		
		List arrayParam=new ArrayList();
		InternetHeaders ih = new InternetHeaders();
		MimeBodyPart mbp = null;
		DataSource source = null;
		DataHandler dh = null;
		for (int i = 0; i < ficheros.size(); i++) 
		{
			try
			{
				FormFile ff=(FormFile) ficheros.get(i);
				mbp = new MimeBodyPart(ih, ff.getFileData());
				source = new MimePartDataSource(mbp);
				dh = new DataHandler(source);
		    	arrayParam.add(new ParamVdexVO(dh , ff.getFileName()));
				
			}catch (Exception e) {
				if (logger.isDebugEnabled()) {logger.debug("error al cargar la lista de paramVDEXVO");}
			}
		}
		try{
	    	SrvEstructurasEducativasService servicio= this.getSrvEstructurasEducativasService();
	    	resultado = servicio.subirArbolesCurriculares((ParamVdexVO[])arrayParam.toArray(new ParamVdexVO[0]));
			
			for (int i = 0; i < resultado.length; i++) 
			{
				String[] nombreVdex= new String[1];
				nombreVdex[0]= ((FormFile) ficheros.get(i)).getFileName();
		    	if(resultado[i].getCodigoError()!=null && !resultado[i].getCodigoError().equals(""))
		    	{
		    		logger.debug("hubo un error al crear el nuevo arbol, se muestra el error en la jsp");
		    		this.saveErrorMessage(request, "estructuras.error.alta." + resultado[i].getCodigoError(),nombreVdex);
		    	}else{
		    		this.saveSuccessMessage(request, "estructuras.arboles.alta.exito" , nombreVdex);
		    	}
			}
			
		}catch(Exception e)
		{
			if (logger.isDebugEnabled()) {logger.debug("error al dar de alta lista de arboles");}
			this.saveErrorMessage(request, "estructuras.error.alta.0");
		}

    }






    public final void obtenerIdiomas(
    		ActionMapping mapping, 
    		ObtenerIdiomasForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
		form.setIdiomaBuscador("02");
		try{
			String idiomaSelected = LdapUserDetailsUtils.getIdioma();
			I18n i18n = I18n.getInstance();
			LocalizacionIdiomaVO[] localizadorIdioma =(LocalizacionIdiomaVO[]) i18n.obtenerIdiomasPlataformaLocalizados(idiomaSelected);
			form.setIdiomaBuscadorBackingList(Arrays.asList(localizadorIdioma), "idLocalizacion", "nombre");
		}catch(Exception e)
		{
			logger.error("error en AltaArbolesControllerImpl.obtenerIdiomas");
		}

     }



    public final java.lang.String submit(
    		ActionMapping mapping, 
    		SubmitForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
		String resultado="";
		String action=form.getAction();
//		String idioma=((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage();
//		ResourceBundle i18n = ResourceBundle.getBundle("application-resources_"+idioma);

		
		Locale locale = (Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE");
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",	locale);
		if(action!=null)
		{
			if(action.equals(i18n.getString("estructuras.aceptar")))
			{
				resultado= "ACEPTAR";
			}else if(action.equals(i18n.getString("estructuras.cancelar")))
				resultado= "CANCELAR";
		}
		return resultado;
    }









}