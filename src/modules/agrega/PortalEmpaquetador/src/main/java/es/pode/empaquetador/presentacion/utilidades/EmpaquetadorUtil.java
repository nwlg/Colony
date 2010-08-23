/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.presentacion.utilidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;

/**
 * @author fjespino
 * 
 */
public class EmpaquetadorUtil implements Serializable {

	protected static EmpaquetadorUtil util = null;
	
	/**
	 * 
	 */
	protected EmpaquetadorUtil() {
	}

	public static EmpaquetadorUtil getInstance() {
		if(EmpaquetadorUtil.util==null) {
			EmpaquetadorUtil.util = new EmpaquetadorUtil();
		}
		return EmpaquetadorUtil.util;
	}
	
	/**
	 * Busca el grupo/organizacion del Ode referenciado por idPadre e inserta el
	 * grupo como hijo suyo. Si idPadre no identifica a ningun
	 * Grupo/Organizacion, se devolverá null
	 * 
	 * @param grupo
	 * @param idPadre
	 * @param ode
	 * @return
	 */
	public OdeVO setGrupoVO(GrupoVO grupo, String idPadre, OdeVO ode) {
		OdeVO result = null;
		OrganizacionVO[] organizaciones = ode.getOrganizaciones();
		boolean flag = true;
		for (int i = 0; i < organizaciones.length && flag; i++) {
			if (organizaciones[i].getIdentifier().equals(idPadre)) {
				/*
				 * idPadre corresponde a una OrganizacionVO
				 */
				List lista = new java.util.ArrayList();
				lista.add(grupo);
				if (ode.getOrganizaciones()[i].getGrupos() != null) {
					lista.addAll(0, Arrays.asList(ode.getOrganizaciones()[i]
							.getGrupos()));
				}
				ode.getOrganizaciones()[i].setGrupos((GrupoVO[]) lista
						.toArray(new GrupoVO[] {}));
				flag = false;
				result = ode;
			} else {
				/*
				 * idPadre corresponde a un GrupoVO. Hay que buscar
				 * recursivamente el grupo.
				 */
				GrupoVO[] grupos = organizaciones[i].getGrupos();
				List lista = new java.util.ArrayList();
				if (getIdActual(idPadre, grupos) != null) {
					GrupoVO[] subGrupos = getIdActual(idPadre, grupos)
							.getGrupos();
					lista.add(grupo);
					lista.addAll(0, Arrays.asList(getIdActual(idPadre, grupos)
							.getGrupos()));
					getIdActual(idPadre, grupos).setGrupos(
							(GrupoVO[]) lista.toArray(new GrupoVO[] {}));
					flag = false;
					result = ode;
				}
			}
		}
		return result;
	}

	/**
	 * Devuelve el objeto (OrganizacionVO o GrupoVO) identificado por idActual.
	 * 
	 * @param idActual
	 * @return
	 */
	public Object getIdActual(String idActual, OdeVO ode) {
		Object objActual = null;
		OrganizacionVO[] organizaciones = ode.getOrganizaciones();
		OrganizacionVO organizacion = null;
		for (int i = 0; i < organizaciones.length && objActual == null; i++) {
			organizacion = organizaciones[i];
			if (organizacion.getIdentifier().equals(idActual))
				objActual = organizacion;
			else {
				GrupoVO[] grupos = organizacion.getGrupos();
				objActual = getIdActual(idActual, grupos);
			}
		}
		return objActual;
	}

	/**
	 * Explora de forma recursiva el array de GrupoVO hasta encontrar el GrupoVO
	 * cuyo indentificador sea idActual.
	 * 
	 * @param idActual
	 * @param grupos
	 * @return
	 */
	private GrupoVO getIdActual(String idActual, GrupoVO[] grupos) {
		GrupoVO grupo = null;
		for (int i = 0; i < grupos.length && grupo == null; i++) {
			if (grupos[i].getIdentifier().equals(idActual))
				grupo = grupos[i];
			else if (grupos[i].getGrupos() != null)
				grupo = getIdActual(idActual, grupos[i].getGrupos());
		}
		return grupo;
	}
}
