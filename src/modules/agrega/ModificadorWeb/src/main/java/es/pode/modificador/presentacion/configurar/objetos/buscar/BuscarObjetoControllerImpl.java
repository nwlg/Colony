/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.buscar;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.modificador.presentacion.configurar.objetos.buscar.BuscarObjetoController
 */
public class BuscarObjetoControllerImpl extends BuscarObjetoController
{
	private static String VACIA="";

    /**
     * @see es.pode.modificador.presentacion.configurar.objetos.buscar.BuscarObjetoController#recuperarDatos(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.objetos.buscar.RecuperarDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarDatos(ActionMapping mapping, es.pode.modificador.presentacion.configurar.objetos.buscar.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//Recuperamos valores previos de la sesión
    	BusquedaSession sesion=getBusquedaSession(request);
    	if(sesion==null) sesion=new BusquedaSession();
    	
        form.setDiaDesde(sesion.getDiaDesde()!=null?sesion.getDiaDesde():VACIA);
        form.setDiaHasta(sesion.getDiaHasta()!=null?sesion.getDiaHasta():VACIA);
        form.setMesDesde(sesion.getMesDesde()!=null?sesion.getMesDesde():VACIA);
        form.setMesHasta(sesion.getMesHasta()!=null?sesion.getMesHasta():VACIA);
        form.setAnyoDesde(sesion.getAnyoDesde()!=null?sesion.getAnyoDesde():VACIA);
        form.setAnyoHasta(sesion.getAnyoHasta()!=null?sesion.getAnyoHasta():VACIA);
        form.setTitulo(sesion.getTitulo()!=null?sesion.getTitulo():VACIA);
        form.setAutor(sesion.getAutor()!=null?sesion.getAutor():VACIA);
        form.setIdentificador(sesion.getIdentificador()!=null?sesion.getIdentificador():VACIA);
        form.setIdioma(sesion.getIdioma());
        
        form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
        
        form.setIdiomaBackingList(Arrays.asList(I18n.getInstance().obtenerIdiomasBuscablesLocalizados(((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage())), "idLocalizacion", "name");
        setBusquedaSession(request, sesion);
        
     }

    /**
     * @see es.pode.modificador.presentacion.configurar.objetos.buscar.BuscarObjetoController#selectAction(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.objetos.buscar.SelectActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.modificador.presentacion.configurar.objetos.buscar.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				locale);

		String volver = "Volver";
		String buscar = i18n.getString("buscarObjeto.Buscar");
		String action = form.getAction();
		if (action == null) {
			return volver;
		}
		if (action.equals(buscar)) {

			// Guarda datos búsqueda en sesión
			BusquedaSession sesion = getBusquedaSession(request);
			boolean alMenosUnParametro = false;
			boolean parteFecha = false;
			
			if (vacia(form.getIdioma())) {
				throw new ValidatorException("{buscarObjeto.msgErrorIdioma}");
			}
			if (!vacia(form.getAutor())) {

				alMenosUnParametro = true;
			}
			if (!vacia(form.getIdentificador())) {

				alMenosUnParametro = true;
			}
			if (!vacia(form.getTitulo())) {

				alMenosUnParametro = true;
			}
			if (fechaValida(form.getAnyoDesde())/*&&fechaValida(form.getDiaDesde())&&fechaValida(form.getMesDesde())*/) {

				alMenosUnParametro = true;
				parteFecha = true;
			}
			if (fechaValida(form.getAnyoHasta())/*&&fechaValida(form.getDiaHasta())&&fechaValida(form.getMesHasta())*/) {

				alMenosUnParametro = true;
				parteFecha = true;
			}
			if (fechaValida(form.getDiaDesde())) {

				alMenosUnParametro = true;
				parteFecha = true;
			}
			if (fechaValida(form.getDiaHasta())) {

				alMenosUnParametro = true;
				parteFecha = true;
			}
			if (fechaValida(form.getMesDesde())) {

				alMenosUnParametro = true;
				parteFecha = true;
			}
			if (fechaValida(form.getMesHasta())) {

				alMenosUnParametro = true;
				parteFecha = true;
			}

			//Si al menos uno de los campos de una fecha se ha introducido, se da error si falta otro
			
			if(parteFecha) {
				if (!fechaValida(form.getDiaDesde())) {
					throw new ValidatorException("{buscarObjeto.msgErrorDiaDesde}");
				} else if (!fechaValida(form.getMesDesde())) {
					throw new ValidatorException("{buscarObjeto.msgErrorMesDesde}");
				} else if (!fechaValida(form.getAnyoDesde())) {
					throw new ValidatorException("{buscarObjeto.msgErrorAnyoDesde}");
				} else if (!fechaValida(form.getDiaHasta())) {
					throw new ValidatorException("{buscarObjeto.msgErrorDiaHasta}");
				} else if (!fechaValida(form.getMesHasta())) {
					throw new ValidatorException("{buscarObjeto.msgErrorMesHasta}");
				} else if (!fechaValida(form.getAnyoHasta())) {
					throw new ValidatorException("{buscarObjeto.msgErrorAnyoHasta}");
				}
			}
			
			if (!alMenosUnParametro) {
				throw new ValidatorException("{buscarObjeto.exception}");
			}

			//Vuelco el form a la sesion
			sesion.setAutor(form.getAutor());
			sesion.setIdentificador(form.getIdentificador());
			sesion.setTitulo(form.getTitulo());
			sesion.setIdioma(form.getIdioma());
			
			if (fechaValida(form.getDiaDesde())&&fechaValida(form.getMesDesde())&&fechaValida(form.getAnyoDesde())
					&&fechaValida(form.getDiaHasta())&&fechaValida(form.getMesHasta())&&fechaValida(form.getAnyoHasta())) {
				//Comprobaciones de la fecha
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				format.setLenient(false);
				
				String guion = "-";
				int dayFrom, dayTo, yearFrom, yearTo, monthFrom, monthTo;
				try {
					dayFrom = Integer.valueOf(form.getDiaDesde()).intValue();
					dayTo = Integer.valueOf(form.getDiaHasta()).intValue();
					yearFrom = Integer.valueOf(form.getAnyoDesde()).intValue();
					yearTo = Integer.valueOf(form.getAnyoHasta()).intValue();
					monthFrom = Integer.valueOf(form.getMesDesde()).intValue();
					monthTo = Integer.valueOf(form.getMesHasta()).intValue();
				} catch (Exception e) {
					throw new ValidatorException(
							"{buscarObjetos.msgErrorFormato}");
				}
				StringBuffer fechaFromStr = new StringBuffer();
				fechaFromStr.append(dayFrom).append(guion).append(monthFrom)
						.append(guion).append(yearFrom);
				
				Date fechaFrom;
				Date fechaTo;
				
				try {
					fechaFrom = format.parse(fechaFromStr.toString());
					StringBuffer fechaToStr = new StringBuffer();
					fechaToStr.append(dayTo).append(guion).append(monthTo).append(
							guion).append(yearTo);
					
					fechaTo = format.parse(fechaToStr.toString());
					if (fechaTo.before(fechaFrom)) {
						throw new ValidatorException(
								"{buscarObjetos.msgErrorFormato}");
					}
				} catch (Exception e) {
					throw new ValidatorException("{buscarObjetos.msgErrorFormato}");
				}
				//Saco ahora campos de fecha a sesion
				String[] partes = format.format(fechaFrom).split("-");
				sesion.setDiaDesde(partes[0]);
				sesion.setMesDesde(partes[1]);
				sesion.setAnyoDesde(partes[2]);
				partes = format.format(fechaTo).split("-");
				sesion.setDiaHasta(partes[0]);
				sesion.setMesHasta(partes[1]);
				sesion.setAnyoHasta(partes[2]);
			} else {
				//Actualizamos los campos de fecha en sesion aunque no sean buenos
				sesion.setDiaDesde(form.getDiaDesde());
				sesion.setMesDesde(form.getMesDesde());
				sesion.setAnyoDesde(form.getAnyoDesde());
				sesion.setDiaHasta(form.getDiaHasta());
				sesion.setMesHasta(form.getMesHasta());
				sesion.setAnyoHasta(form.getAnyoHasta());
			}
			sesion.setResultados(null);
			return "Buscar";
		}

		return volver;
	}

	public void borrarSesion(ActionMapping mapping, BorrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	removeBusquedaSession(request);
	}
	
	/**
	 * Comprueba si la cadena dada tiene algo útil.
	 * @param cadena
	 * @return
	 */
	private boolean vacia(String cadena) {
		return cadena==null||cadena.trim().equals(VACIA);
	}
	
	private boolean esNumero(String cadena) {
		try {
			Integer.parseInt(cadena);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}
	
	private boolean fechaValida(String cadena) {
		return !vacia(cadena)&&esNumero(cadena);
	}
    
}
