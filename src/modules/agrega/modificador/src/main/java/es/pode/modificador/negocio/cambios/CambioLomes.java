/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;



import es.pode.modificador.negocio.cambios.configuracion.ModificadorProperties;
import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;

public abstract class CambioLomes implements Cambio {

	protected static final String LOMES_NS = "http://ltsc.ieee.org/xsd/LOM";
	
	protected boolean lomesPrincipalSolo=true;
	protected String terminoLom;
	protected String valor=null;
	protected boolean regExp=false;
	protected String  lenguaje=null;
	protected ModificadorProperties props = null;
	protected LomESDao lomesDao = null;
	
	
	/**
	 * Objeto Logger para trazas de mensajes.
	 */
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see es.pode.modificador.negocio.cambios.Cambio#ejecutar(es.pode.parseadorXML.castor.Manifest, org.apache.log4j.Appender, java.lang.String)
	 */
	public boolean ejecutar(Manifest manifest, Appender informe, String path) 
	{
		ManifestAgrega manifestA=new ManifestAgrega(manifest);
		boolean lomPpalSolo = this.lomesPrincipalSolo;
		LomIdBean lomBean=null;
		boolean accion=false;
		logger.addAppender(informe);
		try
		{
			if (lomPpalSolo)
			{
				Lom lomPrincipal=manifestA.obtenerLom(manifest.getIdentifier(), null);
				LomIdBean bean = new LomIdBean();
				bean.setId(new String[]{manifest.getIdentifier()});
				bean.setLomArray(new Lom[]{lomPrincipal});
				lomBean=bean;
				logger.info("Iniciando cambio en lom principal de manifiesto " + manifest.getIdentifier());
			}
			else
			{
				
				lomBean = obtenerLomesArray(manifestA);
				logger.info("Iniciando cambio en todos los metadatos de manifiesto " + manifest.getIdentifier());
			}	
			CambioLomesResult result = ejecutar(lomBean.getLomArray());
			accion = result.isResult();
			// Inserto los Lomes en el manifesto
			
			for(int i=0;i<lomBean.getId().length;i++) {
				manifestA.setLom(lomBean.getId()[i], null, result.getLomArray()[i]);
			}
		}
		catch (Exception e) 
		{
			accion=false;
			logger.error("No se ha podido recuperar los metadatos del manifiesto " + manifest.getIdentifier(),e);
			if(logger.isDebugEnabled()) logger.debug(e);
		} finally {
			logger.removeAppender(informe);
		}
		return accion;
	}
	
	private LomIdBean obtenerLomesArray(ManifestAgrega ma) throws Exception {
		HashMap<String, Lom> map = ma.recuperarLomesMap();
		LomIdBean result = new LomIdBean();
		ArrayList<String> idArray = new ArrayList<String>();
		ArrayList<Lom> lomes = new ArrayList<Lom>();
//		Set ids = map.keySet();
		Set<Map.Entry<String, Lom>> entrySet = map.entrySet();
		for (Iterator<Entry<String, Lom>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Map.Entry<String, Lom> entry = (Map.Entry<String, Lom>) iterator.next();
			String id= entry.getKey();
			idArray.add(id);
			lomes.add(entry.getValue());
		}
		
//		for(Iterator it=ids.iterator();it.hasNext();) {
//			String id = (String)it.next();
//			idArray.add(id);
//			lomes.add(map.get(id));
//		}
		result.setId((String[])idArray.toArray(new String[idArray.size()]));
		result.setLomArray((Lom[])lomes.toArray(new Lom[lomes.size()]));
		return result;
	}
	
	/**
	 * @param nodo
	 * @return
	 * @throws Exception 
	 * @throws JDOMException
	 * @throws IOException
	 */
	public CambioLomesResult ejecutar(Lom[] lomes) throws Exception 
	{
		boolean resultadoFinal=true;
		CambioLomesResult result = new CambioLomesResult();
		result.setLomArray(new Lom[lomes.length]);
		for(int i=0; i<lomes.length;i++)
		{
			//transformo el lom a elemento
			Element	nodo=transformarLom2Element(lomes[i]);
			Element[] arrayElementos=obtenerTerminoLomes(nodo);
			
			resultadoFinal = ejecutarAccion(arrayElementos);
			//transformo el element a lomes y lo inserto en el array de nuevo
			//Captura excepcion y dar error de validación
			try {
				result.getLomArray()[i]=transformarElement2Lom(nodo);
			} catch (Exception e) {
				logger.error("Se ha producido un error de validación de Lomes");
				resultadoFinal=false;
			}
		}
		result.setResult(resultadoFinal);
		return result;
	}
	
	
	private List<Element> obtenerTerminoLome2(String[] terminos,Element elemento)
	{

		String[] terminos2 = null;
		List<Element> encontrados = new ArrayList<Element>();
		if (terminos.length == 1 && "lom".equals(terminos[0])) {
			encontrados.add(elemento);
		} else {
			terminos2 = new String[terminos.length - 1];

			// formo terminos2 desde el 2 hasta el final de terminos
			for (int i = 1; i < terminos.length; i++) {
				terminos2[i - 1] = terminos[i];
			}
			List<Element> elementos = elemento.getChildren(terminos2[0],
					Namespace.getNamespace(LOMES_NS));
			if (elementos != null) {
				for (int j = 0; j < elementos.size(); j++) {
					Element elementoLista = elementos.get(j);
					if (logger.isDebugEnabled())
						logger.debug("exploramos el elemento"
								+ elementoLista.getName());

					// NO estoy en la última posición
					if (terminos2.length > 1) {
						encontrados.addAll(obtenerTerminoLome2(terminos2,
								elementoLista));
					}
					// SÍ estoy en la última posición
					else {
						if (this.getValor() == null) {
							if (logger.isDebugEnabled())
								logger.debug("this.getValor es null");
							encontrados.add(elementoLista);
						} else if (this.isRegExp() == false) {
							if (logger.isDebugEnabled())
								logger.debug("this.isRegExp()==false");
							if (this.getValor()
									.equals(elementoLista.getValue())) {
								encontrarLanguage(encontrados, elementoLista);

							}
						} else if (this.isRegExp() == true) {
							if (logger.isDebugEnabled())
								logger.debug("this.isRegExp()==true");
							Pattern mask = Pattern.compile(this.getValor(),
									Pattern.DOTALL);
							Matcher matcher = mask.matcher(elementoLista
									.getValue());
							if (matcher.matches()) {
								if (logger.isDebugEnabled())
									logger
											.debug("coinciden las expresiones regulares:"
													+ this.getValor());
								encontrarLanguage(encontrados, elementoLista);
							}
						}
					}
				}
			}
		}
		return encontrados;
	}

	/**
	 * @param encontrados
	 * @param elementoLista
	 */
	private void encontrarLanguage(List<Element> encontrados,
			Element elementoLista) {
		if(this.getLenguaje()!=null)
		{
			if(logger.isDebugEnabled()) logger.debug("this.getLenguaje()=="+this.getLenguaje());
			Attribute language = elementoLista.getAttribute("language");
			if(language!=null && getLenguaje().equals(language.getValue()))
			{
				if(logger.isDebugEnabled()) logger.debug("hemos encontrado el language igual "+this.getLenguaje());
				encontrados.add(elementoLista);
			}
		}
		else
		{
			if(logger.isDebugEnabled()) logger.debug("this.getLenguaje()=null");
			encontrados.add(elementoLista);
		}
	}
	
	public Element[] obtenerTerminoLomes(Element nodo)
	{
		
		String[] terminos=terminoLom.split("\\.");
		if(logger.isDebugEnabled()) logger.debug("Se van a buscar los siguientes terminoLom: "+terminoLom);
		List<Element> elem=new ArrayList<Element>();
		if(terminos!=null && terminos.length>0)
		{
			elem=obtenerTerminoLome2(terminos,nodo);
		}
		Element[] elementos=new Element[elem.size()];
		for(int i=0;i<elem.size();i++)
		{
			elementos[i]=elem.get(i);
		}
		
		return elementos;
	}

	
	public Element transformarLom2Element(Lom lom) throws Exception {
		
		StringWriter writer = new StringWriter();

		try
		{
			lomesDao.escribirLom(lom, writer);
		} 
		catch (ParseadorException e)
		{
			if(logger.isDebugEnabled()) logger.debug("No se ha podido transformar Lom2Element",e);
		}

        String xml = writer.toString();

        // Parsear xml con JDOM
        StringReader  reader = new StringReader(xml);
        SAXBuilder parser = new SAXBuilder();  
        Document doc = parser.build(new InputSource(reader));
        Element elementoDom = doc.getRootElement();
		return elementoDom;
	}
	
	public Lom transformarElement2Lom(Element element) throws Exception
	{
		Lom lomes=null;
		if(element.getName().equals("lom"))
		{
			Document doc=element.getDocument();
			Writer writer = new StringWriter();
			XMLOutputter outputter = new XMLOutputter();
			try 
			{
			    outputter.output(doc, writer);       
			}
			catch (Exception e) 
			{
				if(logger.isDebugEnabled()) logger.debug("No se ha podido transformar Element2Lom "+e);
			}
			
			String xml = writer.toString();
			lomes= lomesDao.parsearLom(new StringReader(xml));	
		}	
		return lomes;
	}
	
	protected StringBuffer generarMensaje(String tipoModificacion) {
		StringBuffer sb = new StringBuffer();
		sb.append(tipoModificacion).append(" de término ").append(terminoLom);
		if(valor!=null) {
			sb.append(" con valor ").append(valor);
			if(lenguaje!=null) sb.append(" y lenguaje " + lenguaje);
		}
		return sb;
	}
	
	protected abstract boolean ejecutarAccion(Element[] terminos);



	/**
	 * @return the lomesPrincipalSolo
	 */
	public boolean isLomesPrincipalSolo()
	{
		return lomesPrincipalSolo;
	}



	/**
	 * @param lomesPrincipalSolo the lomesPrincipalSolo to set
	 */
	public void setLomesPrincipalSolo(boolean lomesPrincipalSolo)
	{
		this.lomesPrincipalSolo = lomesPrincipalSolo;
	}
	/**
	 * @return the props
	 */
	public ModificadorProperties getProps() {
		return props;
	}

	/**
	 * @return the lomesDao
	 */
	public LomESDao getLomesDao()
	{
		return lomesDao;
	}

	/**
	 * @param lomesDao the lomesDao to set
	 */
	public void setLomesDao(LomESDao lomesDao)
	{
		this.lomesDao = lomesDao;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(ModificadorProperties props)
	{
		this.props = props;
	}

	/**
	 * @return the terminoLom
	 */
	public String getTerminoLom()
	{
		return terminoLom;
	}

	/**
	 * @param terminoLom the terminoLom to set
	 */
	public void setTerminoLom(String terminoLom)
	{
		this.terminoLom = terminoLom;
	}

	/**
	 * @return the lenguaje
	 */
	public String getLenguaje()
	{
		return lenguaje;
	}

	/**
	 * @param lenguaje the lenguaje to set
	 */
	public void setLenguaje(String lenguaje)
	{
		this.lenguaje = lenguaje;
	}

	/**
	 * @return the regExp
	 */
	public boolean isRegExp()
	{
		return regExp;
	}

	/**
	 * @param regExp the regExp to set
	 */
	public void setRegExp(boolean regExp)
	{
		this.regExp = regExp;
	}

	/**
	 * @return the valor
	 */
	public String getValor()
	{
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor)
	{
		this.valor = valor;
	}
	
	static private class LomIdBean {
		private String[] id = null;
		private Lom[] lomArray = null;
		/**
		 * @return the id
		 */
		public String[] getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String[] id) {
			this.id = id;
		}
		/**
		 * @return the lom
		 */
		public Lom[] getLomArray() {
			return lomArray;
		}
		/**
		 * @param lom the lom to set
		 */
		public void setLomArray(Lom[] lom) {
			this.lomArray = lom;
		}
		
	}
}
