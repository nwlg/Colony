/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.DcDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.oai_dc.Dc;
import es.pode.parseadorXML.oai_dc.DcCreator;
import es.pode.parseadorXML.oai_dc.DcSubject;
import es.pode.parseadorXML.oai_dc.DcTitle;
import es.pode.parseadorXML.oai_dc.Oai_dcTypeItem;


public class DcDaoTest extends TestCase {

	private DcDao dao = null;

	private Properties properties = null;

	private Logger logger = Logger.getLogger(this.getClass());
	
	public DcDaoTest(){
		super();
		try {
			dao= new DcDao();
			
			this.properties = new Properties();
			InputStream is = this.getClass().getResourceAsStream(
					"/parseadorXML.properties");
			properties.load(is);
		} catch (IOException e) {
			logger.error("No se pudo abrir el fichero de propiedades; ", e);
		} catch (Exception e) {
			logger.error("Error en el constructor del test: ", e);
			fail("Error en la construccion del test : " + e.getMessage());
		}
	}
	
	protected void setUp() throws Exception {
		super.setUp();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testEscribirDC() {
		
		Dc dublinCore = new Dc();
		Oai_dcTypeItem item = new Oai_dcTypeItem();
		Oai_dcTypeItem item2 = new Oai_dcTypeItem();
		DcTitle titulo =new DcTitle();
		titulo.setContent("Grassmann's space analysis");
		titulo.setLang("en");
		
		DcCreator creador = new DcCreator();
		creador.setContent("Hyde, E. W. (Edward Wyllys)");
		
		DcSubject subject = new DcSubject();
		subject.setContent("LCSH:Ausdehnungslehre; LCCN QA205.H99");
		
		item.setDcTitle(titulo);
		item.setDcCreator(creador);
		item.setDcSubject(subject);
		
		
		DcTitle titulo2 =new DcTitle();
		titulo2.setContent("Grassmann");
		titulo2.setLang("en");
		
		DcCreator creador2 = new DcCreator();
		creador2.setContent("Hyde");
		
		DcSubject subject2 = new DcSubject();
		subject2.setContent("LCSH:Ausdehnungslehre; LCCN QA205.H95");
		
		item2.setDcTitle(titulo2);
		item2.setDcCreator(creador2);
		item2.setDcSubject(subject2);
		
		
		dublinCore.addOai_dcTypeItem(item);
		dublinCore.addOai_dcTypeItem(item2);
		
	
		try {
			dao.escribirDC(dublinCore,"D:/pruebaDC.xml");
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}	

}
