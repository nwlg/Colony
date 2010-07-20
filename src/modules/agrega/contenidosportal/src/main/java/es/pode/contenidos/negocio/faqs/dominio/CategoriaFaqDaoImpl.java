/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.faqs.dominio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq
 */
public class CategoriaFaqDaoImpl
    extends es.pode.contenidos.negocio.faqs.dominio.CategoriaFaqDaoBase
{
    /**
     * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaFaqDao#toCategoriaFaqVO(es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq)
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO toCategoriaFaqVO(final es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO) 
                  this.getBeanMapper().map(entity, es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO.class, DEF_MAPPING_CATEGORIAFAQ_CATEGORIAFAQVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaFaqDao#fromCategoriaFaqVO(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO)
	 */
    public es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq fromCategoriaFaqVO(final es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        //return super.fromCategoriaFaqVO(vo);
    	
    	CategoriaFaq resultado = super.fromCategoriaFaqVO(vo);
    	Collection colec = resultado.getCategoriaIdioma();
    	if (!(colec == null))
    	{
    		if(!(colec instanceof Set))
    		{
    			Set set = new HashSet();
    			set.addAll(colec);
    			resultado.setCategoriaIdioma(set);    			
    		}
    	}
    	return resultado;

    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.contenidos.negocio.faqs.dominio.CategoriaFaqDao#fromCategoriaFaqVO(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO ,es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq)	 
	 */
    public void fromCategoriaFaqVO(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO vo, es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromCategoriaFaqVO(vo, entity);
    }
}