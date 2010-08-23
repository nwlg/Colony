/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.baja;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.estructuraseducativas.EstructurasSession;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



public class BajaTaxonomiasControllerImpl extends BajaTaxonomiasController
{
	private static Logger logger= Logger.getLogger(BajaTaxonomiasControllerImpl.class);
	
	
	
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
		}catch (Exception e) {
			logger.error("error en BajaTaxonomiasController.obtenerIdiomas ");
		}
		

    }


    public final void bajaTaxonomia(
    		ActionMapping mapping, 
    		BajaTaxonomiaForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	EstructurasSession estructurasSession=getEstructurasSession(request);
    	SrvEstructurasEducativasService servicio=this.getSrvEstructurasEducativasService();
    	int[] resultado= servicio.eliminarBackups(estructurasSession.getVdexEliminar());
    	boolean eliminados=true;
    	
    	
    	for (int i = 0; i < resultado.length; i++) {
			if(resultado[i]==0)
				eliminados=false;
		}
    	
    	if(eliminados)
    	{
    		this.saveSuccessMessage(request, "estructuras.taxonomias.baja.exito");
    	}else
    	{
   			this.saveSuccessMessage(request, "estructuras.taxonomias.baja.fallo");	
    	}

    	
    	estructurasSession.setVdexEliminar(null);
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
		Locale locale =(Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE");
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources", locale);

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