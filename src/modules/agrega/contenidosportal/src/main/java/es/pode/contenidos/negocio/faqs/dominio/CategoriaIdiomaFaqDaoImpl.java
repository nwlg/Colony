/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.faqs.dominio;

/**
 * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaq
 */
public class CategoriaIdiomaFaqDaoImpl
    extends es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaqDaoBase
{
    /**
     * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaqDao#toCategoriaIdiomaFaqVO(es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaq)
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO toCategoriaIdiomaFaqVO(final es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaq entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO) 
                  this.getBeanMapper().map(entity, es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO.class, DEF_MAPPING_CATEGORIAIDIOMAFAQ_CATEGORIAIDIOMAFAQVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaqDao#fromCategoriaIdiomaFaqVO(es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO)
	 */
    public es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaq fromCategoriaIdiomaFaqVO(final es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromCategoriaIdiomaFaqVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaqDao#fromCategoriaIdiomaFaqVO(es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO ,es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaq)	 
	 */
    public void fromCategoriaIdiomaFaqVO(es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO vo, es.pode.contenidos.negocio.faqs.dominio.CategoriaIdiomaFaq entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromCategoriaIdiomaFaqVO(vo, entity);
    }
}