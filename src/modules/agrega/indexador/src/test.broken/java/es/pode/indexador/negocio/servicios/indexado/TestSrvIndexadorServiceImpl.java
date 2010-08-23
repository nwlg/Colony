/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.indexador.negocio.servicios.indexado;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;




/** 
 * @see SrvIndexadorServiceImpl
 */
public class TestSrvIndexadorServiceImpl
    extends SrvIndexadorServiceImplBase
{

	private Logger logger = Logger.getLogger(this.getClass());

	private Properties props = null;
	private Properties properties = null;
    /**
     * Constructor
     */
    
     public TestSrvIndexadorServiceImpl(){
 		super();
    	 try {
 			props = new Properties();
 			this.properties = new Properties();
 			
 			InputStream is = this.getClass().getResourceAsStream(
			"/app.properties");
 			properties.load(is);
	
 		props.load(this.getClass().getResourceAsStream("/indexador.properties"));
 			
 		} catch (IOException e) {
 			logger.error("ERROR: fichero no encontrado: indexador.properties",
 					e);
 			throw new RuntimeException(e);
 		}
	}
     
 	/**
 	 * Implementar si no desea usar DataSets
 	 */
     private String datasetFile = "SrvDataEmptyDataSet.xls";
     
    /**
     * testInicial
     *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
     *     public void test<nombreTest>().
     */	
     public void testInicial(){
		String prueba =null;
		assertNull(prueba);
	}
	
	
    /**
     *   TEST IndexarODE
     *   TODO: Implementar el test para el metodo IndexarODE del servicio SrvIndexadorService.
     * @throws IndexaODEException 
     */
     public void testIndexarODE() throws IndexaODEException {
//    	 String[] idTesauros= new String[]{"99999","88888","77777"};
//    	 IdODEVO[] array = new IdODEVO[]{generarIdOde("12345678902",idTesauros),generarIdOde("5678",idTesauros)};
//    	 IndexadorVO[] resultados = this.servicio.indexarODE(array);
//    	 assertNotNull(resultados);
    	 String prueba = null; 
   		assertNull(prueba);
    }

    /**
     *   TEST reindexarODE
     *   TODO: Implementar el test para el metodo reindexarODE del servicio SrvIndexadorService.
     * @throws ReindexaODEException 
     */
     public void testreindexarODE() throws ReindexaODEException { 
//    	 es.pode.indexador.negocio.servicios.indexado.IdODEVO[] loc=new es.pode.indexador.negocio.servicios.indexado.IdODEVO[1];
//    	 IdODEVO idODE =generarIdOde("es-mec_20080201_1_9125411", new String[] {"183","4444","5555"});
//    	 idODE.setValoracion(new Float(2));
//    	 loc[0]=idODE;
//    	 IndexadorVO[] respuesta= this.servicio.reindexarODE(loc);
// 		 assertEquals(respuesta[0].getCode(),0);
    	 String prueba = null; 
   		assertNull(prueba);
    }

    /**
     *   TEST eliminarODE
     *   TODO: Implementar el test para el metodo eliminarODE del servicio SrvIndexadorService.
     * @throws EliminaODEException 
     */
     public void testeliminarODE() throws EliminaODEException {
//    	 String[] loc=new String[1];
////    	 loc[0]="es-mec_20080201_1_9125538";    	 
//    	 loc[0]="12345678902";
//    	 IndexadorVO[] respuesta= this.servicio.eliminarODE(loc);
    	 String prueba = null; 
   		assertNull(prueba);
    }

    /**
     *   TEST IndexacionTotal
     *   TODO: Implementar el test para el metodo IndexacionTotal del servicio SrvIndexadorService.
     * @throws IndexacionTotalException 
     */
     public void testIndexacionTotal() throws IndexacionTotalException {
//    	 es.pode.indexador.negocio.servicios.indexado.IdODEVO[] loc=new es.pode.indexador.negocio.servicios.indexado.IdODEVO[6];
//    	 for(int i = 0 ;i < 6; i++)loc[i]=generarIdOde("id"+i,new String[]{});
//    	 IndexadorVO[] respuesta= this.servicio.indexacionTotal(loc);
//    	 assertEquals(respuesta.length,6);
//    	 for(int i = 0 ;i < 6; i++)assertEquals(respuesta[i].getCode(),0);
    	 String prueba = null; 
   		assertNull(prueba);
    }
     
     
     /**
      *   TEST AgregarOdeTesauro
      *   TODO: Implementar el test para el metodo AgregarOdeTesauro del servicio SrvIndexadorService.
      * @throws 
      */
      public void testAgregarOdeTesauro() {
    	  
//    	  String[] codigos= new String[]{"99999","88888","77777"};
//    	  String idioma="es";
//    	  this.servicio.agregarOdeTesauro(codigos, idioma);
    	  String prueba = null; 
    		assertNull(prueba);
     	 
     }
     
      
      /**
       *   TEST EliminarOdeTesauro
       *   TODO: Implementar el test para el metodo EliminarOdeTesauro del servicio SrvIndexadorService.
       * @throws 
       */
       public void testEliminarOdeTesauro() {
    	   
//    	  String[] codigos= new String[]{"99999","88888","77777"};
//     	  String idioma="es";
//     	  this.servicio.eliminarOdeTesauro(codigos, idioma);
    	   String prueba = null; 
     		assertNull(prueba);
      }
      
     
     private IdODEVO generarIdOde(String identificador, String[] idTesauro){
    	 try{
    		 String localizador = this.applicationContext.getResource("imsmanifest.xml").getFile().getPath();
	    	 IdODEVO idODE = new IdODEVO();
	    	 idODE.setLocalizadorODE(localizador.substring(0,localizador.lastIndexOf(File.separator)));
	    	 idODE.setIdODE(identificador);
	    	 idODE.setValoracion(Float.valueOf("5"));
	    	 idODE.setSecuencia(Boolean.FALSE);
	    	 //el primero tiene solo los campos mínimos para que funcione, con muchos a null
//	    	 LomESPrimarioVO cat = new LomESPrimarioVO("titulo", managedVariableNames, 
//	    			 managedVariableNames, managedVariableNames,managedVariableNames, datasetFile, 
//	    			 "es", managedVariableNames, datasetFile, managedVariableNames, 
//	    			 managedVariableNames, datasetFile, datasetFile, managedVariableNames, new String [] { "autor1"}, 
//	    			 managedVariableNames, new String [] { "managedVariableNames"}, new Integer(3),idTesauro, "arbol vigente",
//	    			 new String[] {"fuente"}, new String[] {"relacion"}, new String[] {"publicador"}, new String[] {"contribuidor"},new String[] {"alcance"}, new String[] {"arbol curricular alcance"}, new String[] {"Descripciones"});
//	    	 idODE.setCatalogacionPrimaria(cat);
	    	 return idODE;
	     }catch(IOException iO){
			 logger.error("ERROR: fichero no encontrado: imsmanifest.xml",iO);
				 throw new RuntimeException(iO);
		 }
     }
     
}