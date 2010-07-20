/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.modificar;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.archivos.modificar.ModificarArchivoController
 */
public class ModificarArchivoControllerImpl extends ModificarArchivoController
{
	
    /**
     * @see es.pode.empaquetador.presentacion.archivos.modificar.ModificarArchivoController#modificar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.archivos.modificar.ModificarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificar(ActionMapping mapping, es.pode.empaquetador.presentacion.archivos.modificar.ModificarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
		GestorArchivosSession sesArch = this.getGestorArchivosSession(request);

		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				locale);

		String opcion = form.getAction();

		if (opcion.equals(i18n.getString("portal_empaquetado.modificarNombre"))) {

			//nuevoNombre debe ser la concatenación de la extensión y el nuevo nombre
			String extension = form.getExtension();
			String nuevoNombre;
			if(extension.equals("")) {
				nuevoNombre = form.getNuevoNombre();
			} else
			{
				StringBuffer nombre=new StringBuffer(form.getNuevoNombre());
				nombre.append(".").append(extension);
				nuevoNombre=nombre.toString();
			}
			GestorSesion gs = new GestorSesion();
			gs.validarNombreFichero(nuevoNombre);

			ArchivoVO archivo = (ArchivoVO) request.getSession().getAttribute(
					"archivoVO");
			String nombre = archivo.getNombre();
			
			if(!extension.equals("")) {
				nombre=nombre+"."+extension;
			}

			if (!nombre.equals(nuevoNombre)) {
				
				// obtengo el identificador del ODEVO
				String identificador = sesEmpaq.getIdLocalizador();

				List path = sesArch.getPath();
				ArchivoVO ultimoPath = (ArchivoVO) path.get(path.size() - 1);
				// obtengo la carpetaDestino
				String carpetaPadre = null;
				if (path.size() > 1 && ultimoPath.getCarpetaPadre() == null) {
					carpetaPadre = ultimoPath.getNombre();
				} else if (path.size() > 1
						&& ultimoPath.getCarpetaPadre() != null) {
					carpetaPadre = ultimoPath.getCarpetaPadre().concat("/")
							.concat(ultimoPath.getNombre());
				}

				try {
					this.getSrvEmpaquetadorBasicoService().renombrar(identificador,
							carpetaPadre, nombre, nuevoNombre);
				} catch (Exception e) {
					throw new ValidatorException(
							"{portalempaquetado.archivos.error.renombrar}");
				}
			}
		}
     }









}