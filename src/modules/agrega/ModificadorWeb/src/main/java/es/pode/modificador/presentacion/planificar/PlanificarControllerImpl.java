/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.planificar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;


import es.pode.modificador.negocio.servicio.ModificacionVO;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.modificador.presentacion.planificar.PlanificarController
 */
public class PlanificarControllerImpl extends PlanificarController
{
	private static String guion="-";

    public final void planificar(ActionMapping mapping, es.pode.modificador.presentacion.planificar.PlanificarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    
		String actionSubmit = form.getAction();
		int day, year, month, hour, minute;
    	Calendar fechaHoy = Calendar.getInstance();
			
		if (actionSubmit.equals("Aceptar") )
		{
			if (form.getFecha() == null || form.getFecha().equals("")) {
				throw new ValidatorException("{planificar.msgErrorFecha}");
			} else if (form.getHoras() == null || form.getHoras().equals("")) {
				throw new ValidatorException("{planificar.msgErrorHora}");
			} else if (form.getMinutos() == null
					|| form.getMinutos().equals("")) {
				throw new ValidatorException("{planificar.msgErrorMinutos}");
			} else {

				String idModificacion = form.getIdModificacion();
				try {
					hour = Integer.valueOf(form.getHoras()).intValue();
					minute = Integer.valueOf(form.getMinutos()).intValue();

				} catch (Exception e) {
					throw new ValidatorException("{planificar.msgErrorFormato}");
				}

				try {
					StringBuffer fechaStr = new StringBuffer();
					fechaStr.append(form.getFecha()).append(guion).append(hour).append(
							guion);
					fechaStr.append(minute);
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-HH-mm");
					format.setLenient(false);
					
					Date fecha = format.parse(fechaStr.toString());
					Calendar fechaEjecucion = Calendar.getInstance();
					fechaEjecucion.setTime(fecha);
					if (fechaHoy.before(fechaEjecucion)) {
						Long idModificacionLong = Long.valueOf(idModificacion);

						this.getSrvHerramientaModificacion()
								.planificarModificacion(idModificacionLong,
										fechaEjecucion);
					} else {
						throw new ValidatorException(
								"{planificar.msgErrorFecha}");

					}
				} catch (ParseException e1) {
					throw new ValidatorException("{planificar.msgErrorFormato}");
				} catch (ValidatorException e2) {
					throw new ValidatorException("{planificar.msgErrorFecha}");
				} catch (Exception e3) {
					throw new ValidatorException("{planificar.msgExcepcion}");
				}

			}

		}
    }


    public final void obtenerFecha(ActionMapping mapping, es.pode.modificador.presentacion.planificar.ObtenerFechaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String idModificacion = form.getIdModificacion();
    	Long idModificacionLong=Long.valueOf(idModificacion);
    	ModificacionVO modificacion = this.getSrvHerramientaModificacion().obtenerModificacion(idModificacionLong);
    	Calendar fecha = modificacion.getFechaEjecucion();
    	if(fecha!=null)
    	{
    		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
    		
    		String[] partes= formateador.format(fecha.getTime()).split("-");
    		form.setFecha(partes[0]+"/"+partes[1]+"/"+partes[2]);
    			        
	        form.setHoras(partes[3]);
	        form.setMinutos(partes[4]);
    	}
    	 form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

     }

}