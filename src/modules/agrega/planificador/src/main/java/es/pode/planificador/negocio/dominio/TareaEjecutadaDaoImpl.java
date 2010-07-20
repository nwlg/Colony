/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.planificador.negocio.dominio;

/**
 * @see es.pode.planificador.negocio.dominio.TareaEjecutada
 */
public class TareaEjecutadaDaoImpl
    extends es.pode.planificador.negocio.dominio.TareaEjecutadaDaoBase
{
    /**
     * @see es.pode.planificador.negocio.dominio.TareaEjecutadaDao#toTareaEjecutadaVO(es.pode.planificador.negocio.dominio.TareaEjecutada)
     */
    public es.pode.planificador.negocio.servicios.TareaEjecutadaVO toTareaEjecutadaVO(final es.pode.planificador.negocio.dominio.TareaEjecutada entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.planificador.negocio.servicios.TareaEjecutadaVO) 
                  this.getBeanMapper().map(entity, es.pode.planificador.negocio.servicios.TareaEjecutadaVO.class, DEF_MAPPING_TAREAEJECUTADA_TAREAEJECUTADAVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.planificador.negocio.dominio.TareaEjecutadaDao#fromTareaEjecutadaVO(es.pode.planificador.negocio.servicios.TareaEjecutadaVO)
	 */
    public es.pode.planificador.negocio.dominio.TareaEjecutada fromTareaEjecutadaVO(final es.pode.planificador.negocio.servicios.TareaEjecutadaVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromTareaEjecutadaVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.planificador.negocio.dominio.TareaEjecutadaDao#fromTareaEjecutadaVO(es.pode.planificador.negocio.servicios.TareaEjecutadaVO ,es.pode.planificador.negocio.dominio.TareaEjecutada)	 
	 */
    public void fromTareaEjecutadaVO(es.pode.planificador.negocio.servicios.TareaEjecutadaVO vo, es.pode.planificador.negocio.dominio.TareaEjecutada entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromTareaEjecutadaVO(vo, entity);
    }
}