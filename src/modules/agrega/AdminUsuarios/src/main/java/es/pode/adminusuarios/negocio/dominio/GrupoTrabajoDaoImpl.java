/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.adminusuarios.negocio.dominio;

/**
 * @see es.pode.adminusuarios.negocio.dominio.GrupoTrabajo
 */
public class GrupoTrabajoDaoImpl
    extends es.pode.adminusuarios.negocio.dominio.GrupoTrabajoDaoBase
{
    /**
     * @see es.pode.adminusuarios.negocio.dominio.GrupoTrabajoDao#toGrupoTrabajoVO(es.pode.adminusuarios.negocio.dominio.GrupoTrabajo)
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO toGrupoTrabajoVO(final es.pode.adminusuarios.negocio.dominio.GrupoTrabajo entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO) 
                  this.getBeanMapper().map(entity, es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO.class, DEF_MAPPING_GRUPOTRABAJO_GRUPOTRABAJOVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.adminusuarios.negocio.dominio.GrupoTrabajoDao#fromGrupoTrabajoVO(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO)
	 */
    public es.pode.adminusuarios.negocio.dominio.GrupoTrabajo fromGrupoTrabajoVO(final es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromGrupoTrabajoVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.adminusuarios.negocio.dominio.GrupoTrabajoDao#fromGrupoTrabajoVO(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO ,es.pode.adminusuarios.negocio.dominio.GrupoTrabajo)	 
	 */
    public void fromGrupoTrabajoVO(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO vo, es.pode.adminusuarios.negocio.dominio.GrupoTrabajo entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromGrupoTrabajoVO(vo, entity);
    }
}