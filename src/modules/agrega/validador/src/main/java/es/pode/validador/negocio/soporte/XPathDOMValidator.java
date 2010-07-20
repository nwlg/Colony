/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.validador.negocio.soporte;

import java.util.regex.Pattern;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.InitializingBean;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.pode.parseadorXML.ValidacionException;

public class XPathDOMValidator implements DOMValidator, InitializingBean {

	private final String xpathExpression;
	
	private final Pattern pattern;
	
	private NamespaceContext nsContext;

	private javax.xml.xpath.XPathExpression expression;
	
	public XPathDOMValidator( String xpath, String pattern ) {
		super();
		
		this.xpathExpression = xpath;
		this.pattern = Pattern.compile(pattern);
		
	}
	
	public void afterPropertiesSet() {
		

		// 1. Instantiate an XPathFactory.
		javax.xml.xpath.XPathFactory factory = 
		                    javax.xml.xpath.XPathFactory.newInstance();
		  
		// 2. Use the XPathFactory to create a new XPath object
		javax.xml.xpath.XPath xpath = factory.newXPath();
		
		if( this.nsContext != null )
			xpath.setNamespaceContext(nsContext);
		
		
		try {
			expression = xpath.compile(xpathExpression);
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void validate(Node rootNode) throws Exception {
		
		NodeList list = (NodeList) expression.evaluate(rootNode, XPathConstants.NODESET);
		
		int length = list.getLength();
		for(int i=0;i<length;i++) {
			Node node = list.item(i);
			
			String content = null;
			if( Node.ELEMENT_NODE == node.getNodeType() ) {
				
				content = ((Element)node).getFirstChild().getNodeValue();
			} else if( Node.ATTRIBUTE_NODE == node.getNodeType() ) {
				
				content = ((Attr)node).getNodeValue();
			}
			
			if( ! pattern.matcher(content).matches() )
				throw new ValidacionException("El nodo " + node.getLocalName() + " no cumple la condición establecida " + pattern.pattern() );
		}

	}

	public void setNsContext(NamespaceContext nsContext) {
		this.nsContext = nsContext;
	}

}
