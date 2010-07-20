/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import java.io.InputStream;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class AdicionTermino extends CambioLomes {

	// Inicializo el tipo con valor por defecto OTRO
	private EspecialTermTypes tipoTermino = EspecialTermTypes.OTRO;

	private String nuevoValor;
	
	/**
	 * @return the nuevoValor
	 */
	public String getNuevoValor() {
		return nuevoValor;
	}

	/**
	 * @param nuevoValor
	 *            the nuevoValor to set
	 */
	public void setNuevoValor(String nuevoValor) {
		this.nuevoValor = nuevoValor;
	}

	/**
	 * @return the tipoTermino
	 */
	public EspecialTermTypes getTipoTermino() {
		return tipoTermino;
	}

	/**
	 * @param tipoTermino
	 *            the tipoTermino to set
	 */
	public void setTipoTermino(EspecialTermTypes tipoTermino) {
		this.tipoTermino = tipoTermino;
	}

	protected final boolean ejecutarAccion(Element[] termino) {

		boolean result = true;
		StringBuffer sb = generarMensaje("Adición");
		sb.append(" nuevo término =\n").append(nuevoValor).append("\n\n");
		if(termino !=null && termino.length>0) {
			logger.info(sb.append(" Se han encontrado ").append(
						termino.length).append(
						" términos donde insertar el nuevo término.")
						.append(" Insertando en el primero por defecto")
						.toString());
			if(logger.isDebugEnabled()) logger.debug("Parseando nuevoValor");
			Element nuevoTermino = parsearNuevoValor();
			if(nuevoTermino==null) {
				logger.error("No se ha podido generar un nuevo termino con el texto\n" + nuevoValor);
				result = false;
			} else {
				termino[0].addContent(nuevoTermino.detach());
				logger.info("Termino añadido con éxito");
			}
		} else {
			logger.error(sb.append("No se ha encontrado término ").append(
					terminoLom.substring(0, terminoLom.lastIndexOf('.')))
					.append(" donde insertar el nuevo término").toString());
			result = false;
		}
		
		return result;
	}

	private Element parsearNuevoValor() {
		Element result = null;
		SAXBuilder parser = new SAXBuilder();
		StringReader reader = new StringReader(nuevoValor);
		try {
			Document doc = parser.build(reader);
			result = doc.getRootElement();
		} catch (Exception e) {
			if(logger.isDebugEnabled()) 
				logger.debug("No se ha podido parsear el nuevo termino a añadir",e);
		}
		return result;
	}
	
	/**
	 * Sobreescribo el metodo obtenerTerminoLom(Element elemento) para obtener
	 * el padre del elemento que quiero añadir, o el clasification correcto en
	 * el caso de añadir árboles curriculares o ETBs. Si se encuentran varios,
	 * inserto nuevo termino dentro del primer encontrado.
	 * 
	 * En el caso especial de Arbol-Curricular - ETB, si no se encuentra el
	 * elemento donde insertar el nuevo arbol / ETB, se genera un classification
	 * por defecto con purpose = discipline para poder insertarlo. En cualquier
	 * otro caso, la tarea termina como error.
	 * 
	 * @param elemento
	 * @return
	 */
	public Element[] obtenerTerminoLomes(Element elemento) {
		Element[] result = null;
		String swapTerminoLom = null;
		// Temporalmente, asigno el terminoLom a swapTerminoLom. Debe restaurarse al final de este metodo
		swapTerminoLom = terminoLom;
		
		if (EspecialTermTypes.OTRO.equals(tipoTermino)) {
			// Reasigno el terminoLom: quiero localizar el padre del que se desea añadir
			terminoLom = getTerminoLom().substring(0,
					getTerminoLom().lastIndexOf('.'));
			Element[] encontrados = super.obtenerTerminoLomes(elemento);
			result = encontrados;
		} else if (EspecialTermTypes.ARBOL_CURRICULAR.equals(tipoTermino)
				|| EspecialTermTypes.ETB.equals(tipoTermino)) {
			if(logger.isDebugEnabled())
				logger.debug("Adicion de arbol / ETB: busco classification padre para insertar");
			// El padre del que se desea añadir es un classification:
			terminoLom = "lom.classification";
			Element[] padres = super.obtenerTerminoLomes(elemento);
			boolean insertar = true;
			if(padres!=null && padres.length>0) {
				for(int i=0;i<padres.length && insertar;i++) {
					Element purpose = padres[i].getChild("purpose", Namespace.getNamespace(CambioLomes.LOMES_NS));
					if(purpose!=null) {
						Element value = purpose.getChild("value", Namespace.getNamespace(CambioLomes.LOMES_NS));
						if(value != null && "discipline".equals(value.getValue())) {
							// Existe un classification con purpose=discipline.
							// Lo devuelvo como elemento padre
							if(logger.isDebugEnabled())
								logger.debug("Encontrado classification con purpose = discipline");
							insertar = false;
							result = new Element[]{padres[i]};
						}
					}
				}
			} 
			if(insertar) {
				/*
				 * No existe classification con purpose discipline. Lo inserto
				 */
				if(logger.isDebugEnabled()) logger.debug("Insertando un <classification> con purpose = discipline");
				// Parseo plantilla classification-disciplina.xml y la inserto en el lom
				InputStream is = this.getClass().getResourceAsStream("/plantillas/classification-disciplina.xml");
				String errMsg = "No se ha podido generar un classification para el Arbol curricular / ETB";
				if(is==null) {
					logger.fatal(errMsg);
					if(logger.isDebugEnabled()) logger.debug("No se encuentra la plantilla classification-disciplina");
				} else {
					try {
						SAXBuilder parser = new SAXBuilder();
						Document doc = parser.build(new InputSource(is));
						Element classification = doc.getRootElement();
						elemento.addContent(classification.detach());
						result = new Element[]{classification};
					} catch (Exception e) {
						logger.fatal(errMsg);
						if(logger.isDebugEnabled()) 
							logger.debug("Error de parseo de la plantilla classification-disciplina.xml",e);
					} finally {
						try {
							is.close();
						} catch (Exception e) {
							// Nada que hacer
						}
					}
				}
			}
		}
		terminoLom = swapTerminoLom;
		return result;
	}
}
