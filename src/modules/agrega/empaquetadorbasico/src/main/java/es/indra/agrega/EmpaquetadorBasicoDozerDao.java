/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.indra.agrega;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.empaquetador.negocio.gestionficheros.Fichero;
import es.pode.empaquetador.negocio.servicio.FicheroVO;

public class EmpaquetadorBasicoDozerDao {
	Log logger = LogFactory.getLog(this.getClass());
	
	public EmpaquetadorBasicoDozerDao() {
	}
	
	private MapperIF beanMapperAux = null;

	public MapperIF getBeanMapperAux() {
		return beanMapperAux;
	}

	public void setBeanMapperAux(MapperIF beanMapperAux) {
		this.beanMapperAux = beanMapperAux;
	}
	
	public FicheroVO toFicheroVO(Fichero fichero) {
		FicheroVO nuevoFichero = (FicheroVO) this.getBeanMapperAux().map(fichero, FicheroVO.class);
		
		return nuevoFichero;
	}
	
	public Fichero fromFicheroVO(FicheroVO ficheroVO) {
		Fichero nuevoFichero = (Fichero) this.getBeanMapperAux().map(ficheroVO, Fichero.class);
		return nuevoFichero;
	}
}
