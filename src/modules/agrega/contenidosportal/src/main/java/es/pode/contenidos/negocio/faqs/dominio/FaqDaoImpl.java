/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

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
 * @see es.pode.contenidos.negocio.faqs.dominio.Faq
 */
public class FaqDaoImpl
    extends es.pode.contenidos.negocio.faqs.dominio.FaqDaoBase
{
    /**
     * @see es.pode.contenidos.negocio.faqs.dominio.FaqDao#toFaqVO(es.pode.contenidos.negocio.faqs.dominio.Faq)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqVO toFaqVO(final es.pode.contenidos.negocio.faqs.dominio.Faq entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.contenidos.negocio.faqs.servicio.FaqVO) 
                  this.getBeanMapper().map(entity, es.pode.contenidos.negocio.faqs.servicio.FaqVO.class, DEF_MAPPING_FAQ_FAQVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.contenidos.negocio.faqs.dominio.FaqDao#fromFaqVO(es.pode.contenidos.negocio.faqs.servicio.FaqVO)
	 */
    public es.pode.contenidos.negocio.faqs.dominio.Faq fromFaqVO(final es.pode.contenidos.negocio.faqs.servicio.FaqVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        //return super.fromFaqVO(vo);
        
        Faq resultado = super.fromFaqVO(vo);
    	Collection colec = resultado.getDescripcionFaq();
    	if (!(colec == null))
    	{
    		if(!(colec instanceof Set))
    		{
    			Set set = new HashSet();
    			set.addAll(colec);
    			resultado.setDescripcionFaq(set);    			
    		}
    	}
    	return resultado;

    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.contenidos.negocio.faqs.dominio.FaqDao#fromFaqVO(es.pode.contenidos.negocio.faqs.servicio.FaqVO ,es.pode.contenidos.negocio.faqs.dominio.Faq)	 
	 */
    public void fromFaqVO(es.pode.contenidos.negocio.faqs.servicio.FaqVO vo, es.pode.contenidos.negocio.faqs.dominio.Faq entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromFaqVO(vo, entity);
    }

}