/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.servicio.vo;

import java.io.InputStream;
import java.util.ArrayList;

import junit.framework.TestCase;
import net.sf.dozer.util.mapping.MapperIF;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.pode.modificador.negocio.cambios.EspecialTermTypes;
import es.pode.modificador.negocio.cambios.configuracion.ConfiguracionDao;
import es.pode.modificador.negocio.cambios.configuracion.castor.ModificationTask;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

public class TestCustomDozerMappingsXml extends TestCase {

	private static MapperIF mapper = null;
	
	private static ConfiguracionDao dao = null;
	
	private static ClassPathXmlApplicationContext context = null;
	
	private static final String testOutputFolderName = "modificadorTest";
	
	public TestCustomDozerMappingsXml(String arg) {
		super(arg);
		if(context==null) {
			context = new ClassPathXmlApplicationContext(new String[]{"testContext.xml","user-applicationContext.xml"});
		}
		if(mapper==null) {
			mapper = (MapperIF)context.getBean("beanMapper");
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
		java.io.File testOutputFolder = new java.io.File(testOutputFolderName);
		if(!testOutputFolder.exists()) {
			boolean check = testOutputFolder.mkdirs();
			assertTrue("No se ha podido crear la carpeta de salida para el test: " + testOutputFolder,check);
		}
		if(dao==null) {
			dao = new ConfiguracionDao();
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		try {
			UtilesFicheros.eliminar(new java.io.File(testOutputFolderName));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	public void testConfiguracion2VO() {
		if(mapper==null) fail("mapper es null");
		InputStream is = this.getClass().getResourceAsStream("/xmls/test-configuracion-tareas.xml");
		ModificationTask task = null;
		
		try {
			task = dao.leerConfiguracion(is);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea taskVO = (es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea)mapper.map(task, es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea.class);
			assertNotNull("El VO obtenido es null",taskVO);
			assertNotNull("No se han mapeado las tareas", taskVO.getCambios());
			assertNotNull("No se han mapeado los objetos", taskVO.getObjetos());
			assertNotNull("No se ha mapeado el array de cambios", taskVO.getCambios().getCambios());
			assertEquals("La longitud del array de cambios es incorrecta",5, taskVO.getCambios().getCambios().length);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testVO2Configuracion() {
		if(mapper==null) fail("mapper es null");
		
		// Creo la clase VO
		ConfiguracionTarea task = new ConfiguracionTarea();
		Changes changes = new Changes();
		Change change = new Change();
		change.setType(CambioTypes.MODIFICAR_LOMES);
		change.setLomTerm("lom.technical.format");
		change.setValue("text/html");
		change.setNewValue("image/gif");
		change.setMainLomOnly(Boolean.TRUE);
		change.setReplaceAll(Boolean.FALSE);
		change.setRegExp(Boolean.FALSE);
		
		ArrayList cambiosList = new ArrayList();
		cambiosList.add(change);
		
		change = new Change();
		change.setType(CambioTypes.ADD_LOMES);
		change.setLomTerm("lom.technical.format");
		change.setNewValue("image/jpeg");
		change.setMainLomOnly(Boolean.TRUE);
		change.setTermType(EspecialTermTypes.OTRO);
		cambiosList.add(change);
		
		change = new Change();
		change.setType(CambioTypes.ADD_LOMES);
		change.setLomTerm("lom.classification.taxonPath");
		change.setNewValue("<taxonPath><taxon>1.1</taxon></taxonPath>");
		change.setMainLomOnly(Boolean.TRUE);
		change.setTermType(EspecialTermTypes.ARBOL_CURRICULAR);
		cambiosList.add(change);
		
		changes.setCambios((Change[])cambiosList.toArray(new Change[2]));
		
		Objects objs = new Objects();
		
		ODE ode = new ODE();
		
		ode.setPublished(Boolean.FALSE);
		ode.setPath("folder/ode");
		Folder folder1 = new Folder();
		Folder folder2 = new Folder();
		folder1.setPath("pathOdes");
		folder2.setPath("pathOdes2");
		objs.setObjetos(new ODE[]{ode});
		objs.setPaths(new Folder[]{folder1,folder2});
		
		task.setCambios(changes);
		task.setObjetos(objs);
		
		// Mapeo a objetos castor
		ModificationTask taskCastor = (ModificationTask)mapper.map(task, ModificationTask.class);
		assertNotNull("El resultado del mapeo es null", taskCastor);
		try {
			// Escribo el XML
			dao.guardarConfiguracion(taskCastor, testOutputFolderName.concat("/test-configuracion.xml"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testConfiguracion2Cambios() {
		
	}

}
