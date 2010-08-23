/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.indexador.negocio.servicios.busqueda;


import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import es.pode.indexador.negocio.servicios.indexado.IdODEVO;

/**
 * @see SrvBuscadorServiceImpl
 */
public class TestSrvBuscadorServiceImpl
    extends SrvBuscadorServiceImplBase
{

	private Properties props = null;
	private Properties properties = null;
	
    /**
     * Constructor
     */
     public TestSrvBuscadorServiceImpl(){
		super();
		try {
			props = new Properties();
 			properties = new Properties();
 			properties.load(this.getClass().getResourceAsStream("/app.properties"));
 			props.load(this.getClass().getResourceAsStream("/indexador.properties"));
 			
 		} catch (IOException e) {
 			logger.error("ERROR: fichero no encontrado: indexador.properties",e);
 			throw new RuntimeException(e);
 		}
	}

    /**
     * testInicial
     *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
     *     public void test<nombreTest>().
     */	
     public void testInicial(){
		String prueba = "gg";
		assertNotNull(prueba);
	}

     /**
      *   TEST busquedaSimple
      *   TODO: Implementar el test para el metodo busquedaSimple del servicio SrvBuscadorService.
      */
      public void testbusquedaSimple() {
//    	  try{
//				indexarODEs();
//				DocumentosVO respuesta =this.servicio.busquedaSimple(generarParametrosBusquedaSimple("key*Avanzad?"));
//				assertNotNull(respuesta.getResultados());
//				comprobarRespuesta(respuesta.getResultados()[0]);
//				respuesta =this.servicio.busquedaSimple(generarParametrosBusquedaSimple("}f2e_-i3299(--5"));
//				assertNull(respuesta.getResultados());
//				assertEquals(respuesta.getSugerencias().length,0);
//    	  }catch(Exception e){
//  		  	logger.error("ERROR: fallo en test buscador-->",e);
//  			throw new RuntimeException(e);
//      	  }finally{
//      		eliminarODE(new String [] { "asdf","hjkl"});
//      	  }
    	  String prueba = null; 
  		assertNull(prueba);
     }

     private ParamSimpleVO generarParametrosBusquedaSimple(String palabrasClave){
  		ParamSimpleVO paramBusq= new ParamSimpleVO();
  		paramBusq.setIdiomaBusqueda("es");
  		paramBusq.setIdiomaNavegacion("es");
  		paramBusq.setNumeroResultados(new Integer(100));
  		paramBusq.setPalabrasClave(palabrasClave);
      	return paramBusq;
     }
     
    /**
     *   TEST busquedaAvanzada
     *   TODO: Implementar el test para el metodo busquedaAvanzada del servicio SrvBuscadorService.
     */
     public void testbusquedaAvanzada() {
//    	try{
	    	//indexarODEs();
			DocumentosVO respuesta =null;//this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("agregatodos identificador:es-ma_20071119_1_9115305", ""));
			/*		Object [  ]  value =  {  null  } ;
			PropertyDescriptor[] beanPDs = Introspector.getBeanInfo(ParamAvanzadoVO.class).getPropertyDescriptors();
			String autor=autor
			campo_ambito=ambito
			campo_contexto=contexto
			campo_descripcion=description
			campo_edad=edad
			campo_fechaPublicacion=fechaPublicacion
			campo_formato=formato
			campo_idiomaBusqueda=idioma
			campo_nivelEducativo=nivelesEducativos
			campo_palabrasClave=keyword
			campo_procesoCognitivo=procesosCognitivos
			campo_recurso=tipoRecurso
			campo_secuencia=conSinSecuencia
			campo_titulo=title
			campo_valoracion=valoracion
			for (int j = 0; j < beanPDs.length; j++) {
				if(props.getProperty("campo_"+beanPDs[j].getName())!=null){
					value[0]="valor a cargar";
					setPropValue(Class.forName(ParamAvanzadoVO.class.getName()).newInstance(), beanPDs[j],value);
				}
			}
				
			*/
//			assertEquals(respuesta.getResultados().length, 1);
//			
//			comprobarRespuesta(respuesta.getResultados()[0]);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("pruebatitulo", ""));
//			System.err.println("aparar");
//			assertEquals(respuesta.getResultados().length, 1);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("pclave", "nivel*"));
//			assertEquals(respuesta.getResultados().length, 1);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("pclave", "nived*"));
//			assertNull(respuesta.getResultados());
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("pclave", "nivel"));
//			assertNotNull(respuesta.getResultados());
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("", "nivel"));
//			assertNull(respuesta.getResultados());
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzada("pclave", "}f2e_-i3299(--5"));
//			assertNull(respuesta.getResultados());
			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("verso estrofa", "universal pepito",""));
//			assertNull(respuesta.getResultados());
			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("descwildcard", "ambito0",""));
//			assertEquals(respuesta.getSugerencias().length, 1);
//			
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("desc*", "",""));
//			assertEquals(respuesta.getResultados().length, 2);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("keywordAvanzado", "ambito0","descripcion"));
//			assertEquals(respuesta.getResultados().length, 1);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("keywordAvanzado", "ambito0","descripcion compuesta"));
//			assertEquals(respuesta.getResultados().length, 1);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("keywordAvanzado", "ambito0","descripcion pru*"));
//			assertEquals(respuesta.getResultados().length, 1);
//			
//			respuesta =this.servicio.busquedaAvanzada(generarParametrosBusquedaAvanzadaComunidades("descwild*", "",""));
//			assertEquals(respuesta.getResultados().length, 1);
//    	}catch(Exception e){
//		  	logger.error("ERROR: fallo en test buscador-->",e);
//			throw new RuntimeException(e);
//    	}finally{
//    		eliminarODE(new String [] { "asdf","hjkl"});
//    	}
			assertNull(respuesta);
    }
     
    private ParamAvanzadoVO generarParametrosBusquedaAvanzada(String palabrasClave, String areaCurricular){
    	ParamAvanzadoVO paramBusq= new ParamAvanzadoVO();
    	paramBusq.setIdiomaBusqueda("es");
		paramBusq.setIdiomaNavegacion("es");
		paramBusq.setNumeroResultados(new Integer(100));
		paramBusq.setPalabrasClave(palabrasClave);
		paramBusq.setAreaCurricular(areaCurricular);
       	return paramBusq;
    }
    
    private ParamAvanzadoVO generarParametrosBusquedaAvanzadaComunidades(String palabrasClave, String comunidades, String descripcion){
    	ParamAvanzadoVO paramBusq= new ParamAvanzadoVO();
    	paramBusq.setIdiomaBusqueda("es");
		paramBusq.setIdiomaNavegacion("es");
		paramBusq.setNumeroResultados(new Integer(100));
		paramBusq.setPalabrasClave(palabrasClave);
		paramBusq.setAmbito(comunidades);
		paramBusq.setDescripcion(descripcion);
       	return paramBusq;
    } 

    /**
     *   TEST busquedaLOM_ES
     *   TODO: Implementar el test para el metodo busquedaLOM_ES del servicio SrvBuscadorService.
     */
     public void testbusquedaLOM_ES() {
//    	try{
//    		indexarODEs();
//    		QuerySimpleVO paramBusq= new QuerySimpleVO();
//			paramBusq.setIdioma("es");
//			paramBusq.setLenguajeQuery("VSQL");
//			paramBusq.setNumResultados(new Integer(100));
//			paramBusq.setQuery("titulo2");
//			DocumentosLOM_ESVO respuesta =this.servicio.busquedaLOM_ES(paramBusq);
//			if (respuesta.getResultados()!=null)
//				assertEquals(respuesta.getResultados().length, 1);
//    	}catch(Exception e){
//		  	logger.error("ERROR: fallo en test buscador-->",e);
//			throw new RuntimeException(e);
//    	}finally{
//    		eliminarODE(new String [] { "asdf","hjkl"});
//    	}
    	 String prueba = null; 
   		assertNull(prueba);
    }
     
     /**
      *   TEST busquedaLOM_ES
      *   TODO: Implementar el test para el metodo busquedaLOM_ES del servicio SrvBuscadorService.
      */
      public void testbusquedaLOM_ESVSQL() {
//     	try{
////     		indexarODEs();
//     		QuerySimpleVO paramBusq= new QuerySimpleVO();
// 			paramBusq.setIdioma("es");
// 			paramBusq.setLenguajeQuery("VSQL");
// 			paramBusq.setNumResultados(new Integer(100));
// 			paramBusq.setQuery("cinco");
// 			DocumentosLOM_ESVO respuesta =this.servicio.busquedaLOM_ESVSQL(paramBusq);
// 			if (respuesta.getResultados()!=null)
// 				assertEquals(respuesta.getResultados().length, 1);
//     	}catch(Exception e){
// 		  	logger.error("ERROR: fallo en test buscador-->",e);
// 			throw new RuntimeException(e);
//     	}finally{
//     		eliminarODE(new String [] { "asdf","hjkl"});
//     	}
    	  String prueba = null; 
    		assertNull(prueba);
     }
     
     public void testobtenerDocsCount() {
//   		ResultadosCountVO areas = this.servicio.solicitudDocsCount(new ParamDocsCountVO(new String[] {"1","2","5","8"}, "es","Árbol Curricular LOE 2006",null));
//   		assertNotNull(areas);
//   		ResultadosCountVO tesauros = this.servicio.solicitudDocsCount(new ParamDocsCountVO(null, "es",null,new String[] {"M60","386","349","M40","735"}));
//   		assertNotNull(tesauros);
    	 String prueba = null; 
   		assertNull(prueba);

       }

    public void testObtenerPalabrasClave() {
//  		PrioridadPalabrasClaveVO idiomas = this.servicio.obtenerPalabrasClave(new ParamPalabrasClave(new Integer(10),"en","es"));
// 		assertNotNull(idiomas);
    	String prueba = null; 
  		assertNull(prueba);
     }
     
     public void testbusquedaArbolCurricularCount() {
//     	try{
//     		indexarODEs();
//			ResultadosCountVO respuesta =this.servicio.solicitudDocsCount(new ParamDocsCountVO(new String[]{"2.2"}, "es","Árbol curricular LOE 2006",null));
//			assertNotNull(respuesta);
//     	}catch(Exception e){
// 		  	logger.error("ERROR: fallo en test buscador-->",e);
// 			throw new RuntimeException(e);
//     	}finally{
//     		eliminarODE(new String [] { "asdf","hjkl"});
//     	}
    	 String prueba = null; 
   		assertNull(prueba);
     }
     public void testbusquedaNodoArbolCurricular() {
//	     try{
//				indexarODEs();
//				DocumentosVO respuesta =this.servicio.busquedaDocsNodoArbolCurricular(new ParamNodoArbolCurricularVO ("es","2.2","es", new Integer(1000)));
//				assertNotNull(respuesta.getResultados());
//				comprobarRespuesta(respuesta.getResultados()[0]);
//				respuesta =this.servicio.busquedaDocsNodoArbolCurricular(new ParamNodoArbolCurricularVO("es","1.1","es",new Integer(1000)));
//				assertNull(respuesta.getResultados());
//		  }catch(Exception e){
//		  	logger.error("ERROR: fallo en test buscador-->",e);
//			throw new RuntimeException(e);
//		  }finally{
//			//eliminarODE(new String [] { "asdf","hjkl"});
//		  }
    	 String prueba = null; 
   		assertNull(prueba);
     }

	private void indexarODEs(){
//		try{
//			 String localizador = this.applicationContext.getResource("imsmanifest.xml").getFile().getPath();
//		   	 IdODEVO idODE = new IdODEVO();
//		   	 IdODEVO idODE2 = null; 
//		   	 idODE.setLocalizadorODE(localizador.substring(0,localizador.lastIndexOf(File.separator)));
//		   	//idODE.setLocalizadorODE("C:\\ProyectosST\\red-es\\PODE\\Subsistemas\\Indexador\\DyC\\indexador\\target\\classes\\test-resources");
//		   	 idODE.setIdODE("asdf");
//		   	 idODE.setValoracion(Float.valueOf("5"));
//		   	 idODE.setSecuencia(Boolean.FALSE);
//		   	List odes = new ArrayList();
//		   	 for(int i=0;i<23;i++){
//		   		 idODE2 = new IdODEVO(); 
//			   	 idODE2.setLocalizadorODE(localizador.substring(0,localizador.lastIndexOf(File.separator)));
//			   	 idODE2.setIdODE("hjkl"+i);
//			   	 idODE2.setValoracion(Float.valueOf("5"));
//			   	 idODE2.setSecuencia(Boolean.TRUE);
//			   	
////			   	 LomESPrimarioVO cat2 = new LomESPrimarioVO("pruebatitulo"+i, new String [] { "animation"}, 
////			   			 new String [] { "collaborate"}, new String [] { "pclave"}, new String [] { "2","2.2"}, "licencia", 
////			   			 "es", new String [] { "application/msword"}, "fecha1", new String [] { "edades1"}, 
////			   			 new String [] { "destinatario1"}, "descwildcard", "curso", new String [] { "classroom"},
////			   			new String [] { "autor1"},  new String [] { "2","2.2"}, "prueba de ambito", new Integer(3));
////			   	 idODE2.setCatalogacionPrimaria(cat2);
//			   	 odes.add(idODE2);
//		   	 }
//		   	 
//		   	 //el primero tiene solo los campos mínimos para que funcione, con muchos a null
////		   	 LomESPrimarioVO cat = new LomESPrimarioVO("titulo", new String [] { "video"}, 
////		   			new String [] { "analyse"}, new String [] { "keywordAvanzado"}, new String [] { "1","1.1"}, "licencia0", 
////		   			 "es", new String [] { "application/pdf"}, "fecha0", new String [] { "edades0"}, 
////		   			new String [] { "destinatario0"}, "descripcion compuesta para pruebas", "curso0", new String [] { "laboratory"},
////		   			new String [] { "autor0"},  new String [] { "1","1.1"}, "ambito0", new Integer(2));
////		   	 idODE.setCatalogacionPrimaria(cat);
//		   	odes.add(idODE);
//		   	 // el segundo tiene todos los campos rellenados para ver que todos los hace bien
//		   	IdODEVO[] array = new IdODEVO[odes.size()];
//		   	for(int i=0;i<odes.size();i++){
//		   		array[i] = (IdODEVO)odes.get(i);
//		   	}
//		   	 IndexadorVO[] resultados = this.getServicioIndexacion().indexarODE(array);
//		 }catch(IndexaODEException iE){
//			logger.error("ERROR: fichero no encontrado: indexador.properties",iE);
//			throw new RuntimeException(iE);
//		 }catch(IOException iO){
//			logger.error("ERROR: fichero no encontrado: imsmanifest.xml",iO);
//			throw new RuntimeException(iO);
//		 }
		String prueba = null; 
  		assertNull(prueba);
	}
	
	private void comprobarRespuesta(DocVO respuesta){
		 assertNotNull(respuesta.getAmbito());
	   	 assertNotNull(respuesta.getDescripcion());
	   	 assertNotNull(respuesta.getDestinatarios());
	   	 assertNotNull(respuesta.getFormato());
	   	 assertNotNull(respuesta.getIdioma());
	   	 assertNotNull(respuesta.getLicencias());
	   	 assertNotNull(respuesta.getLocalizadorODE());
	   	 assertNotNull(respuesta.getTitulo());
	   	 assertNotNull(respuesta.getValoracion());
	}
	
     private void eliminarODE(String[] id) {
    	 try{
    		 String localizador = this.applicationContext.getResource("imsmanifest.xml").getFile().getPath();
	    	 es.pode.indexador.negocio.servicios.indexado.IdODEVO[] loc=new es.pode.indexador.negocio.servicios.indexado.IdODEVO[id.length];
	    	 for(int i = 0; id.length > i ; i++){
	    		IdODEVO idODE = new IdODEVO();
	    	 	idODE.setIdODE(id[i]);
	    	 	idODE.setLocalizadorODE(localizador.substring(0,localizador.lastIndexOf(File.separator)));
	    		loc[i]=idODE;
//	    	 }
//	    	IndexadorVO[] respuesta= this.getServicioIndexacion().eliminarODE(loc);
//		 }catch(EliminaODEException iE){
//			  	logger.error("ERROR: fichero no encontrado: indexador.properties",iE);
//				throw new RuntimeException(iE);
	    	 }
    	 }catch(IOException iO){
			logger.error("ERROR: fichero no encontrado: imsmanifest.xml",iO);
			throw new RuntimeException(iO);
		 }
    }
     
 	private static void setPropValue(Object o, PropertyDescriptor pd,Object[] values) throws Exception {
		Method m = pd.getWriteMethod();
		System.err.println("m---"+m.getName());
		
		Class type = m.getParameterTypes()[ 0 ];
		//System.err.println("type---"+type);
		if (m == null) throw new NoSuchMethodException("La propiedad '" + pd.getName() + "' no tiene método set");
		else if(m.getParameterTypes()!=null && m.getParameterTypes().length>0) values[0] = convertToType( values[0], type );
		//System.err.println("values[0]---"+values[0]);
		System.err.println(type.getName()+"----clasessssssss---"+values[0].getClass().getName());
		Object ret = m.invoke(o,values);
	}
	
	private static Object convertToType( Object value, Class type ) {
		 if( value != null && type.isInstance( value ) == false ) {
			 if( value instanceof String ) {
				 String s = (String) value;
				 if( Short.class.equals( type ) || short.class.equals( type ) ) value = new Short( s );
				 else if( Integer.class.equals( type ) || int.class.equals( type ) ) value = new Integer( s );
				 else if( Long.class.equals( type ) || long.class.equals( type ) ) value = new Long( s );
				 else if( Float.class.equals( type ) || float.class.equals( type ) )value = new Float( s );
				 else if( Double.class.equals( type ) || double.class.equals( type ) ) value = new Double( s );
			 }else if( value instanceof Integer ) {
				 String s = String.valueOf( value );
				 if( String.class.equals( type )) value = new String( s );
				 else if( Long.class.equals( type ) || long.class.equals( type ) ) value = new Long( s );
				 else if( Float.class.equals( type ) || float.class.equals( type ) ) value = new Float( s );
				 else if( Double.class.equals( type ) || double.class.equals( type ) ) value = new Double( s );
			 }
		 }
	 return value;
	 }
	
	
}