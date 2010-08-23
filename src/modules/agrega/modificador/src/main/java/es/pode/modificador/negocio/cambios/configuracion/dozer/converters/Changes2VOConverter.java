/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios.configuracion.dozer.converters;

import net.sf.dozer.util.mapping.converters.CustomConverter;

import org.apache.log4j.Logger;

import es.pode.modificador.negocio.cambios.EspecialTermTypes;
import es.pode.modificador.negocio.cambios.configuracion.castor.Addition;
import es.pode.modificador.negocio.cambios.configuracion.castor.ChangesTypeItem;
import es.pode.modificador.negocio.cambios.configuracion.castor.Check;
import es.pode.modificador.negocio.cambios.configuracion.castor.Modification;
import es.pode.modificador.negocio.cambios.configuracion.castor.Removal;
import es.pode.modificador.negocio.cambios.configuracion.castor.Validation;
import es.pode.modificador.negocio.cambios.configuracion.castor.types.TermType;
import es.pode.modificador.negocio.servicio.vo.CambioTypes;
import es.pode.modificador.negocio.servicio.vo.Change;

public class Changes2VOConverter implements CustomConverter {

	private static final Logger logger = Logger.getLogger(Changes2VOConverter.class);
	
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class destClass, Class sourceClass) {
		Object result = null;
		if(logger.isDebugEnabled()) logger.debug("Mapeando de " + sourceClass + " a " + destClass);
		if(sourceFieldValue instanceof Object[] ) {
			if(logger.isDebugEnabled()) logger.debug("Recorriendo el array");
			Object[] srcArray = (Object[])sourceFieldValue; 
			Object[] destArray = null;
			if(srcArray instanceof ChangesTypeItem[]) destArray = new Change[srcArray.length];
			else if(srcArray instanceof Change[]) destArray = new ChangesTypeItem[srcArray.length];
			if(destArray!=null) {
				for(int i=0;i<srcArray.length;i++) {
					Object item = srcArray[i];
					if(item instanceof ChangesTypeItem) {
						if(logger.isDebugEnabled()) logger.debug("Mapeando de ChangesTypeItem a VO");
						destArray[i] = convertCastor2VO((ChangesTypeItem)item);	
					} else if (item instanceof Change) {
						if(logger.isDebugEnabled()) logger.debug("Mapeando de VO a ChangeTypeItem");
						destArray[i] = convertVO2Castor((Change)item);	
					} else {
						if(logger.isDebugEnabled()) logger.debug("El array contiene objetos no esperados. Ignorando el mapeo.");
					}
				}
			}
			result = destArray;
		}
		
		return result;
	}

	private Object convertCastor2VO(ChangesTypeItem src) {
		Change vo = new Change();
		if(src.getChoiceValue() instanceof Validation) {
			vo.setType(CambioTypes.VALIDAR);
		} else if(src.getChoiceValue() instanceof Modification) {
			vo.setType(CambioTypes.MODIFICAR_LOMES);
			Modification change = (Modification)src.getChoiceValue();
			vo.setLomTerm(change.getLomTerm());
			vo.setValue(change.getValue());
			vo.setNewValue(change.getNewValue());
			vo.setRegExp(Boolean.valueOf(change.getRegExp()));
			vo.setReplaceAll(Boolean.valueOf(change.getReplaceAll()));
			vo.setMainLomOnly(Boolean.valueOf(change.getMainLomOnly()));
			vo.setLanguage(change.getLanguage());
		} else if(src.getChoiceValue() instanceof Addition) {
			vo.setType(CambioTypes.ADD_LOMES);
			Addition change = (Addition)src.getChoiceValue();
			vo.setLomTerm(change.getLomTerm());
			vo.setNewValue(change.getNewValue());
			vo.setMainLomOnly(Boolean.valueOf(change.getMainLomOnly()));
			EspecialTermTypes type = null;
			if(TermType.ARBOL_CURRICULAR.equals(change.getTermType())) {
				type = EspecialTermTypes.ARBOL_CURRICULAR;
			} else if(TermType.ETB.equals(change.getTermType())) {
				type = EspecialTermTypes.ETB;
			} else {
				type = EspecialTermTypes.OTRO;
			}
			vo.setTermType(type);
		} else if(src.getChoiceValue() instanceof Check) {
			vo.setType(CambioTypes.CHECK_LOMES);
			Check change = (Check)src.getChoiceValue();
			vo.setLomTerm(change.getLomTerm());
			vo.setValue(change.getValue());
			vo.setRegExp(Boolean.valueOf(change.getRegExp()));
			vo.setMainLomOnly(Boolean.valueOf(change.getMainLomOnly()));
			vo.setLanguage(change.getLanguage());
		} else if(src.getChoiceValue() instanceof Removal) {
			vo.setType(CambioTypes.ELIMINAR_LOMES);
			Removal change = (Removal)src.getChoiceValue();
			vo.setLomTerm(change.getLomTerm());
			vo.setValue(change.getValue());
			vo.setRegExp(Boolean.valueOf(change.getRegExp()));
			vo.setMainLomOnly(Boolean.valueOf(change.getMainLomOnly()));
			vo.setLanguage(change.getLanguage());
		}
		return vo;
	}
	
	private Object convertVO2Castor(Change src) {
		ChangesTypeItem item = new ChangesTypeItem();
		if(CambioTypes.VALIDAR.equals(src.getType())) {
			Validation choice = new Validation();
			item.setValidation(choice);
		} else if(CambioTypes.ADD_LOMES.equals(src.getType())) {
			Addition choice = new Addition();
			choice.setLomTerm(src.getLomTerm());
			choice.setNewValue(src.getNewValue());
			choice.setMainLomOnly(src.getMainLomOnly().booleanValue());
			TermType type = null;
			if(EspecialTermTypes.ARBOL_CURRICULAR.equals(src.getTermType())) {
				type = TermType.ARBOL_CURRICULAR;
			} else if (EspecialTermTypes.ETB.equals(src.getTermType())) {
				type = TermType.ETB;
			} else {
				type = TermType.OTRO;
			}
			choice.setTermType(type);
			item.setAddition(choice);
		} else if(CambioTypes.CHECK_LOMES.equals(src.getType())) {
			Check choice = new Check();
			choice.setLomTerm(src.getLomTerm());
			choice.setMainLomOnly(src.getMainLomOnly().booleanValue());
			choice.setLanguage(src.getLanguage());
			choice.setRegExp(src.getRegExp().booleanValue());
			choice.setValue(src.getValue());
			item.setCheck(choice);
		} else if(CambioTypes.MODIFICAR_LOMES.equals(src.getType())) {
			Modification choice = new Modification();
			choice.setLomTerm(src.getLomTerm());
			choice.setMainLomOnly(src.getMainLomOnly().booleanValue());
			choice.setLanguage(src.getLanguage());
			choice.setRegExp(src.getRegExp().booleanValue());
			choice.setValue(src.getValue());
			choice.setNewValue(src.getNewValue());
			choice.setReplaceAll(src.getReplaceAll().booleanValue());
			item.setModification(choice);
		} else if(CambioTypes.ELIMINAR_LOMES.equals(src.getType())) {
			Removal choice = new Removal();
			choice.setLomTerm(src.getLomTerm());
			choice.setMainLomOnly(src.getMainLomOnly().booleanValue());
			choice.setLanguage(src.getLanguage());
			choice.setRegExp(src.getRegExp().booleanValue());
			choice.setValue(src.getValue());
			item.setRemoval(choice);
		} 
		return item;
	}
}
