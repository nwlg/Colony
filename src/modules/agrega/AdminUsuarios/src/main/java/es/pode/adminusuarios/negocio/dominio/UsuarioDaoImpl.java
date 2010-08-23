/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.adminusuarios.negocio.dominio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @see es.pode.adminusuarios.negocio.dominio.Usuario
 */
public class UsuarioDaoImpl extends es.pode.adminusuarios.negocio.dominio.UsuarioDaoBase {
    /**
     * @see es.pode.adminusuarios.negocio.dominio.UsuarioDao#toUsuarioVO(es.pode.adminusuarios.negocio.dominio.Usuario)
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO toUsuarioVO(
	    final es.pode.adminusuarios.negocio.dominio.Usuario entity) {
	// default mapping between entity and VO
	// @todo verify or customize behaviour of this mapping
	return (es.pode.adminusuarios.negocio.servicios.UsuarioVO) this.getBeanMapper().map(entity,
		es.pode.adminusuarios.negocio.servicios.UsuarioVO.class, DEF_MAPPING_USUARIO_USUARIOVO);
    }

    /**
     * Copy a VO to a new entity.
     * 
     * @param vo the source bean (VO)
     * @return A new entity created with the values extracted from the vo.
     * @see es.pode.adminusuarios.negocio.dominio.UsuarioDao#fromUsuarioVO(es.pode.adminusuarios.negocio.servicios.UsuarioVO)
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario fromUsuarioVO(
	    final es.pode.adminusuarios.negocio.servicios.UsuarioVO vo) {
	// default mapping between VO and entity
	// @todo verify or customize behaviour of this mapping
	// return super.fromUsuarioVO(vo);
    	logger.debug("fromUsuarioVO ");
	Usuario resultado = super.fromUsuarioVO(vo);
	Collection col = resultado.getGrupos();
	if (col == null) {

	} else {
	    if (!(col instanceof Set)) {
		Set set = new HashSet();
		set.addAll(col);
		resultado.setGrupos(set);
	    }
	}
	//Añado la transformación de los grupos de trabajo
	Collection colGrupoTrabajo = resultado.getGrupoTrabajo();
	logger.debug("colGrupoTrabajo "+colGrupoTrabajo);
	if (colGrupoTrabajo == null) {

	} else {
	    if (!(colGrupoTrabajo instanceof Set)) {
	    	logger.debug("No es instancia de Set");
		Set setGruposTrabajo = new HashSet();
		setGruposTrabajo.addAll(colGrupoTrabajo);
		resultado.setGrupoTrabajo(setGruposTrabajo);
	    }
	}
	return resultado;
    }

    /**
     * Copy a VO to an existing entity.
     * 
     * @param vo the source bean (VO)
     * @param entity the destination bean (an existing entity)
     * @see es.pode.adminusuarios.negocio.dominio.UsuarioDao#fromUsuarioVO(es.pode.adminusuarios.negocio.servicios.UsuarioVO
     *      ,es.pode.adminusuarios.negocio.dominio.Usuario)
     */
    public void fromUsuarioVO(es.pode.adminusuarios.negocio.servicios.UsuarioVO vo,
	    es.pode.adminusuarios.negocio.dominio.Usuario entity) {
	// default mapping between VO and entity
	// @todo verify or customize behaviour of this mapping
	super.fromUsuarioVO(vo, entity);
    }

    /**
     * Copy a VO to an existing entity. Modifico los grupos de usuario para
     * asegurar que sean una instancia de Set, esto es debido al problema de
     * mapeo
     * 
     * @param vo the source bean (VO)
     * @param entity the destination bean (an existing entity)
     * @see es.pode.adminusuarios.negocio.dominio.UsuarioDao#fromUsuarioVO(es.pode.adminusuarios.negocio.servicios.UsuarioVO
     *      ,es.pode.adminusuarios.negocio.dominio.Usuario)
     */
    public void update(es.pode.adminusuarios.negocio.dominio.Usuario usuario) {
	if (usuario == null) {
	    throw new IllegalArgumentException("Usuario.update - 'usuario' can not be null");
	}
	if (usuario.getGrupos() == null) {

	} else {
	    if (!(usuario.getGrupos() instanceof Set)) {

		Set set = new HashSet();
		set.addAll(usuario.getGrupos());
		usuario.setGrupos(set);
	    }
	}
	
	//Actualización de los grupos de trabajo
	if (usuario.getGrupoTrabajo() == null) {

	} else {
	    if (!(usuario.getGrupoTrabajo() instanceof Set)) {

		Set set = new HashSet();
		set.addAll(usuario.getGrupoTrabajo());
		usuario.setGrupoTrabajo(set);
	    }
	}
	
	this.getHibernateTemplate().update(usuario);

    }

}