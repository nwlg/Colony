/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.servicios;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class WiringPostProcessor implements BeanPostProcessor,
		BeanFactoryAware, InitializingBean {

	private static class PropertyMapping {
		
		private Pattern beanName;
		
		private Pattern beanProperty;
		
		private Pattern propertyBeanName;
		
	}
	
	private boolean allowPropertyOverride = false;
	
	private String[] propertyMappings = new String[0];
	
	private PropertyMapping[] mapping = new PropertyMapping[0];
	
	private ListableBeanFactory beanFactory;
	
	private String separator = ";";
	
	private Log logger = LogFactory.getLog(this.getClass());

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ListableBeanFactory) beanFactory;

	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				
		for (int i = 0; i < mapping.length; i++) {
			PropertyMapping pm = mapping[i];
			
			Pattern pattern = pm.beanName;
			
			if( pattern.matcher(beanName).matches() ) {
				if( logger.isDebugEnabled() )
					logger.debug("Procesando bean " + beanName + " para el establecimiento de la propiedad " + pm.beanProperty );
				wireProperty( bean, beanName, pm );
				
			}
		}
		return bean;
	}

	private void wireProperty(Object bean, String beanName, PropertyMapping pm) {
		
		BeanWrapper wrapper = new BeanWrapperImpl( bean );
		
		PropertyDescriptor[] descriptors = wrapper.getPropertyDescriptors();
		
		boolean anyMatch = false;
		
		for (int i = 0; i < descriptors.length; i++) {
			PropertyDescriptor pd = descriptors[i];
		
			String propertyName = pd.getName();
			
			if( pm.beanProperty.matcher(propertyName).matches() ) {
			
				if( pd.getWriteMethod() == null ) {
					logger.warn("La propiedad " + propertyName + " del bean " + beanName + " no se puede escribir" );
					
				} else {
					
					if( pd.getReadMethod() == null ) {
						if( logger.isInfoEnabled() )
							logger.info("La propiedad " + propertyName + " del bean " + beanName + " no se puede leer" );
						
					}
					
					if( ! allowPropertyOverride ) {
						//No se permite reescribir la propiedad
						//por lo que comprobamos que se puede leer y que está vacía
						if( !wrapper.isReadableProperty(propertyName) || wrapper.getPropertyValue( propertyName ) != null ) {
							logger.warn("La propiedad allowPropertyOverride no está activada, se ignorará el establecimiento de la propiedad " + propertyName
									+ " del bean " + beanName );
							
							continue;
						}
					}
					
					if( allowPropertyOverride && ( !wrapper.isReadableProperty(propertyName) || wrapper.getPropertyValue(propertyName) != null ) )
						logger.warn("La propiedad " + propertyName + " del bean " + beanName + " no se puede leer o ya ha sido establecida y se va a cambiar su valor" );
					
					Object value = null;
					String chosenBeanName = null;
					anyMatch = true;
					
					if( logger.isDebugEnabled() ) {
						logger.debug( "Buscando beans que cumplan el patrón " + pm.propertyBeanName.pattern() + "para la propiedad " + propertyName + " del bean " + beanName + " que cumplan el tipo especificado "+ pd.getPropertyType().getName() );
					}
					
					String candidates[] = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(beanFactory, pd.getPropertyType() );
					
					if( logger.isDebugEnabled() )
						logger.debug("Se han encontrado los siguientes candidatos para la propiedad " + propertyName + " del bean " + beanName + ": " + candidates );
					
					List matchingCandidates = new ArrayList();
					for (int j = 0; j < candidates.length; j++) {
						String candidateName = candidates[j];
						
						if( pm.propertyBeanName.matcher(candidateName).matches() )
							matchingCandidates.add(candidateName);
					}
					
					if( logger.isDebugEnabled() )
						logger.debug("Se han encontrado los siguientes candidatos para la propiedad " + propertyName + " del bean " + beanName + " que cumplen el patrón " + pm.propertyBeanName.pattern() 
								+ ": " + matchingCandidates );
					
					
					if( matchingCandidates.size() == 0 ) {
						logger.warn("No se ha encontrado ningún bean que cumpla el patrón " + pm.propertyBeanName.pattern() + " de tipo " + pd.getPropertyType().getName() );
					} else {
						chosenBeanName = (String) matchingCandidates.get(0);
						if( matchingCandidates.size() > 1 ) {
							logger.warn("Eligiendo el bean " + chosenBeanName + " para la propiedad " + propertyName + " del bean " 
									+ beanName + " entre los candidatos " + matchingCandidates );
						}

						value = beanFactory.getBean(chosenBeanName);
					}
					
					if( logger.isInfoEnabled() )
						logger.info("Asignando la propiedad " + propertyName + " del bean " + beanName + " con el bean " + chosenBeanName );
					
					wrapper.setPropertyValue(propertyName, value);
					
				}
			} else {
				if( logger.isTraceEnabled() ) 
					logger.trace("La propiedad " + propertyName + " del bean " + beanName + " no cumple el patrón asignado " + pm.beanProperty.pattern() );
			}
		}
		
		if( ! anyMatch ) {
			logger.warn("El bean " + beanName + " no tiene ninguna propiedad que cumpla el patrón " + pm.beanProperty.pattern() );
		}
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		return bean;
	}

	public void afterPropertiesSet() throws Exception {
		
		if( propertyMappings!= null && propertyMappings.length > 0 ) {

			List mappingList = new ArrayList(propertyMappings.length ); 
			
			for (int i = 0; i < propertyMappings.length; i++) {
				PropertyMapping mapping = processMapping( propertyMappings[i] );
				
				if( mapping != null ) {
					mappingList.add( mapping );
				} else {
					logger.warn("No se pudo procesar el mapeo " + propertyMappings[i] );
				}
			}
			
			this.mapping = (PropertyMapping[]) mappingList.toArray( new PropertyMapping[ mappingList.size() ]);
		}
		
	}

	private PropertyMapping processMapping(String string) {
		
		String[] parts = string.split( separator );
		
		if( parts.length > 3 || parts.length  < 2 ) {
			logger.warn("La cadena " + string + " no es una cadena válida de definición de mapeo de propiedad con el separador " + separator );

			return null;
		}
		
		PropertyMapping pm = new PropertyMapping();
		pm.beanName = Pattern.compile(parts[0]);
		pm.beanProperty = Pattern.compile(parts[1]);
		
		String propertyBeanName = parts[1];
		if( parts.length > 2 )
			propertyBeanName = parts[2];
		
		pm.propertyBeanName = Pattern.compile(propertyBeanName);
		
		return pm;
		
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public void setPropertyMappings(String[] propertyMappings) {
		this.propertyMappings = propertyMappings;
	}

	public void setAllowPropertyOverride(boolean allowWriteOnlyMaps) {
		this.allowPropertyOverride = allowWriteOnlyMaps;
	}

}
