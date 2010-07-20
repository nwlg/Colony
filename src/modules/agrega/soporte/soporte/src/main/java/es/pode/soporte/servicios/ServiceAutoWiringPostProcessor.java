/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.servicios;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * @author fjarrieta
 * 
 * Clase de utilidad que nos permite realizar autowiring en beans ya definidos en el contexto
 * y que no son editables por estar pregenerados
 *
 */
public class ServiceAutoWiringPostProcessor implements BeanPostProcessor, BeanFactoryAware {

	Log logger = LogFactory.getLog(this.getClass());
	
	private ListableBeanFactory beanFactory;
	
	private Pattern[] patterns = new Pattern[0];

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if(!isMatch(beanName) ) {
			if( logger.isDebugEnabled() )
				logger.debug("El bean de tipo " + bean.getClass().getName() + " con el nombre "
						+ beanName + " no cumple los criterios para la asignación automática de propiedades");
		} else {
			if( logger.isDebugEnabled() )
				logger.debug("");
			BeanWrapper wrapper = new BeanWrapperImpl(bean);
			
			PropertyDescriptor[] pds = wrapper.getPropertyDescriptors();
			
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor pd = pds[i];
				String propertyName = pd.getName();
				if( wrapper.isReadableProperty(propertyName) && wrapper.isWritableProperty(propertyName) ) {
					
					if( wrapper.getPropertyValue(propertyName) != null ) {
						if(logger.isInfoEnabled() ) {
							logger.info("La propiedad " + propertyName + " del bean " + beanName 
									+ " ya ha sido establecida, ignorandola" );
						}
					} else {
						autowire( wrapper, pd );
					}
					
 				} else {
 					if( logger.isInfoEnabled() )
 						logger.info("La propiedad " + propertyName + " del bean " + beanName 
 								+ " no es de lectura/escritura");
 					
 				}
			}
		}
		
		return bean;
	}

	private void autowire(BeanWrapper wrapper, PropertyDescriptor pd) {
		
		Class propertyType = pd.getPropertyType();
		String propertyName = pd.getName();
		
		if( logger.isDebugEnabled() ) {
			logger.debug("Buscando implementaciones en el contexto para propiedad " 
					+ propertyName + " de tipo " + propertyType.getName() );
		}
		
		Map candidates = BeanFactoryUtils.beansOfTypeIncludingAncestors(beanFactory, propertyType );
		
		if( candidates == null || candidates.size() == 0 ) {
			logger.info("No existe ningún bean definido de tipo " + propertyType.getName() + " para la propiedad " + propertyName );
		} else {
			
			if( candidates.size() > 1 ) {
				logger.warn("Hay " + candidates.size() + " beans de tipo " + propertyType.getName() + " definidas en el contexto: " + candidates.keySet().toString() );
				
			}
			
			String beanName = (String) candidates.keySet().iterator().next();
			Object value = candidates.get(beanName);
			
			if( logger.isInfoEnabled() ) 
				logger.info("Estableciendo la propiedad " + propertyName + " de tipo " + propertyType.getName() + " con el bean " + beanName + ": " + value );
			
			wrapper.setPropertyValue(propertyName, value);
			
		}
		
	}

	private boolean isMatch(String beanName) {
		
		for (int i = 0; i < patterns.length; i++) {
			
			if( patterns[i].matcher(beanName).matches() )
				return true;
		}
		
		return false;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		return bean;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ListableBeanFactory) beanFactory;
		
	}


	public void setPatterns( String[] patterns ) {
		
		Collection patternList = new ArrayList();
		
		for (int i = 0; i < patterns.length; i++) {
			String pattern = patterns[i];
			
			patternList.add( Pattern.compile( pattern ) ); 
		}
		
		this.patterns = (Pattern[])patternList.toArray( new Pattern[ patternList.size() ] );
		
	}

}
