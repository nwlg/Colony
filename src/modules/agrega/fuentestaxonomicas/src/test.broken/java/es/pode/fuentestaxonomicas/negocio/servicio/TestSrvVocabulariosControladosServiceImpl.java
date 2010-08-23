/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.fuentestaxonomicas.negocio.servicio;
import java.util.ArrayList;
import java.util.List;
/**
 * @see SrvVocabulariosControladosServiceImpl
 */
public class TestSrvVocabulariosControladosServiceImpl
    extends SrvVocabulariosControladosServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvVocabulariosControladosServiceImpl(){
		super();
	}

   

    /**
     * testInicial
     *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
     *     public void test<nombreTest>().
     */	
     public void testInicial(){
		assertTrue(true);
	}
	
	
    /**
     *   TEST obtenerCombos
     *   TODO: Implementar el test para el metodo obtenerCombos del servicio SrvVocabulariosControladosService.
     */
     public void testobtenerCombos() {
    	 
    	 java.util.ArrayList l_id=new ArrayList();
    	 
    	 l_id.add("1.3");
    	 l_id.add("5.6");
    	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
    	 
    	 List identificadores=new ArrayList();
    	 List identificadoresHijos=new ArrayList();
    	 List nombres=new ArrayList();
    	 List nombresHijos=new ArrayList();
    	 
    	 identificadores.add("1.3");
    	 identificadores.add("5.6");
    	 
    	 nombres.add("language");
    	 nombres.add("context");
    	 
    	 identificadoresHijos.add("1.3.1");
    	 identificadoresHijos.add("1.3.2");
    	 identificadoresHijos.add("1.3.3");
    	 identificadoresHijos.add("1.3.4");
    	 identificadoresHijos.add("1.3.5");
    	 identificadoresHijos.add("1.3.6");
    	 identificadoresHijos.add("5.6.1");
    	 identificadoresHijos.add("5.6.2");
    	 identificadoresHijos.add("5.6.3");
    	 identificadoresHijos.add("5.6.4");
    	 identificadoresHijos.add("5.6.5");
    	 identificadoresHijos.add("5.6.6");
    	 identificadoresHijos.add("5.6.7");
    	 identificadoresHijos.add("5.6.8");
    	 identificadoresHijos.add("5.6.9");
    	 identificadoresHijos.add("5.6.10");
    	 identificadoresHijos.add("5.6.11");
    	 identificadoresHijos.add("5.6.12");
    	 identificadoresHijos.add("5.6.13");
    	 identificadoresHijos.add("5.6.14");
    	 
    	 nombresHijos.add("es");
    	 nombresHijos.add("ca");
    	 nombresHijos.add("en");
    	 nombresHijos.add("eu");
    	 nombresHijos.add("gl");
    	 nombresHijos.add("x-none");
    	 nombresHijos.add("classroom");
    	 nombresHijos.add("laboratory");
    	 nombresHijos.add("real environment");
    	 nombresHijos.add("home");
    	 nombresHijos.add("mixed");
    	 nombresHijos.add("teacher");
    	 nombresHijos.add("family");
    	 nombresHijos.add("tutor");
    	 nombresHijos.add("schoolmate");
    	 nombresHijos.add("independent");
    	 nombresHijos.add("blended");
    	 nombresHijos.add("presencial");
    	 nombresHijos.add("face to face");
    	 nombresHijos.add("distance");
    	 

    	 String idioma ="en";
    	 SrvVocabulariosControladosService vocabulario=this.servicio;

		
		try{
			VocabularioVO[]localPrueba=vocabulario.obtenerCombos(l_id2,idioma);
			List terminoaux=new ArrayList();
			List idaux=new ArrayList();
			assertNotNull(localPrueba);
			
			for(int i=0;i<localPrueba.length;i++){
				assertNotNull(localPrueba[i].getIdioma());
				assertNotNull(localPrueba[i].getNomVocabulario());
				
				assertEquals(identificadores.get(i),localPrueba[i].getIdVocabulario());
				assertEquals(nombres.get(i),localPrueba[i].getNomVocabulario());
				TerminoVO[] termino = localPrueba[i].getTerminos();
				
				for (int j=0;j<termino.length;j++){
					assertNotNull(termino[j].getIdiomaTermino());
					terminoaux.add(termino[j].getNomTermino());
					idaux.add(termino[j].getIdTermino());
				}
				
				
			}
			for (int k=0;k<terminoaux.size();k++){
				assertNotNull(terminoaux.get(k));
				assertNotNull(idaux.get(k));
				assertEquals(nombresHijos.get(k), terminoaux.get(k));
				assertEquals(identificadoresHijos.get(k),idaux.get(k));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

    }
public void testobtenerCombos2() {
    	 
    	 java.util.ArrayList l_id=new ArrayList();
    	 
    	 l_id.add("5.11");
    	 l_id.add("5.6");
    	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
    	 
    	 List identificadores=new ArrayList();
    	 List identificadoresHijos=new ArrayList();
    	 List nombres=new ArrayList();
    	 List nombresHijos=new ArrayList();
    	 
    	 identificadores.add("5.11");
    	 identificadores.add("5.6");
    	 
    	 nombres.add("language");
    	 nombres.add("context");
    	 
    	 identificadoresHijos.add("5.11.1");
    	 identificadoresHijos.add("5.11.2");
    	 identificadoresHijos.add("5.11.3");
    	 identificadoresHijos.add("5.11.4");
    	 identificadoresHijos.add("5.11.5");
    	 identificadoresHijos.add("5.6.1");
//    	 identificadoresHijos.add("5.11.6");
    	 identificadoresHijos.add("5.6.2");
    	 identificadoresHijos.add("5.6.3");
    	 identificadoresHijos.add("5.6.4");
    	 identificadoresHijos.add("5.6.5");
    	 identificadoresHijos.add("5.6.6");
    	 identificadoresHijos.add("5.6.7");
    	 identificadoresHijos.add("5.6.8");
    	 identificadoresHijos.add("5.6.9");
    	 identificadoresHijos.add("5.6.10");
    	 identificadoresHijos.add("5.6.11");
    	 identificadoresHijos.add("5.6.12");
    	 identificadoresHijos.add("5.6.13");
    	 identificadoresHijos.add("5.6.14");
    	 
    	 nombresHijos.add("es");
    	 nombresHijos.add("ca");
    	 nombresHijos.add("en");
    	 nombresHijos.add("eu");
    	 nombresHijos.add("gl");
    	 nombresHijos.add("aula");
//    	 nombresHijos.add("ninguno");
    	 nombresHijos.add("laboratorio");
    	 nombresHijos.add("entorno real");
    	 nombresHijos.add("domicilio");
    	 nombresHijos.add("lugar mixto");
    	 nombresHijos.add("docente");
    	 nombresHijos.add("familia");
    	 nombresHijos.add("tutor");
    	 nombresHijos.add("compañero");
    	 nombresHijos.add("independiente");
    	 nombresHijos.add("asistencia mixta");
    	 nombresHijos.add("presencial");
    	 nombresHijos.add("semipresencial");
    	 nombresHijos.add("distancia");
    	 

    	 String idioma ="es";
    	 SrvVocabulariosControladosService vocabulario=this.servicio;

		
		try{
			VocabularioVO[]localPrueba=vocabulario.obtenerCombos(l_id2,idioma);
			List terminoaux=new ArrayList();
			List idaux=new ArrayList();
			assertNotNull(localPrueba);
			
			for(int i=0;i<localPrueba.length;i++){
				assertNotNull(localPrueba[i].getIdioma());
				assertNotNull(localPrueba[i].getNomVocabulario());
				
				assertEquals(identificadores.get(i),localPrueba[i].getIdVocabulario());
				assertEquals(nombres.get(i),localPrueba[i].getNomVocabulario());
				TerminoVO[] termino = localPrueba[i].getTerminos();
				
				for (int j=0;j<termino.length;j++){
					assertNotNull(termino[j].getIdiomaTermino());
					terminoaux.add(termino[j].getNomTermino());
					idaux.add(termino[j].getIdTermino());
				}
				
				
			}
			for (int k=0;k<terminoaux.size();k++){
				assertNotNull(terminoaux.get(k));
				assertNotNull(idaux.get(k));
				assertEquals(nombresHijos.get(k), terminoaux.get(k));
				assertEquals(identificadoresHijos.get(k),idaux.get(k));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

    }
	public void testobtenerCombos3() {
		
		 java.util.ArrayList l_id=new ArrayList();
   	 
	   	 l_id.add("5.11");
	   	 l_id.add("5.6");
	   	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
	   	 
	   	 List identificadores=new ArrayList();
	   	 List identificadoresHijos=new ArrayList();
	   	 List nombres=new ArrayList();
	   	 List nombresHijos=new ArrayList();
	   	 
	   	 identificadores.add("5.11");
	   	 identificadores.add("5.6");
	   	 
	   	 nombres.add("language");
	   	 nombres.add("context");
	   	 
	   	 identificadoresHijos.add("5.11.1");
	   	 identificadoresHijos.add("5.11.2");
	   	 identificadoresHijos.add("5.11.3");
	   	 identificadoresHijos.add("5.11.4");
	   	 identificadoresHijos.add("5.11.5");
//	   	 identificadoresHijos.add("5.11.6");
	   	 identificadoresHijos.add("5.6.1");
	   	 identificadoresHijos.add("5.6.2");
	   	 identificadoresHijos.add("5.6.3");
	   	 identificadoresHijos.add("5.6.4");
	   	 identificadoresHijos.add("5.6.5");
	   	 identificadoresHijos.add("5.6.6");
	   	 identificadoresHijos.add("5.6.7");
	   	 identificadoresHijos.add("5.6.8");
	   	 identificadoresHijos.add("5.6.9");
	   	 identificadoresHijos.add("5.6.10");
	   	 identificadoresHijos.add("5.6.11");
	   	 identificadoresHijos.add("5.6.12");
	   	 identificadoresHijos.add("5.6.13");
	   	 identificadoresHijos.add("5.6.14");
	   	 
	   	 nombresHijos.add("es");
	   	 nombresHijos.add("ca");
	   	 nombresHijos.add("en");
	   	 nombresHijos.add("eu");
	   	 nombresHijos.add("gl");
//	   	 nombresHijos.add("bat ere ez");
	   	 nombresHijos.add("ikasgela");
	   	 nombresHijos.add("laborategia");
	   	 nombresHijos.add("ingurune erreala");
	   	 nombresHijos.add("bizilekua");
	   	 nombresHijos.add("konposatua");
	   	 nombresHijos.add("irakaslea");
	   	 nombresHijos.add("familia");
	   	 nombresHijos.add("tutorea");
	   	 nombresHijos.add("ikaskidea");
	   	 nombresHijos.add("independentea");
	   	 nombresHijos.add("mista");
	   	 nombresHijos.add("presentziazkoa");
	   	 nombresHijos.add("erdipresentziazkoa");
	   	 nombresHijos.add("distantzia");
	   	 
	
	   	 String idioma ="eu";
	   	 SrvVocabulariosControladosService vocabulario=this.servicio;
	
			
			try{
				VocabularioVO[]localPrueba=vocabulario.obtenerCombos(l_id2,idioma);
				List terminoaux=new ArrayList();
				List idaux=new ArrayList();
				assertNotNull(localPrueba);
				
				for(int i=0;i<localPrueba.length;i++){
					assertNotNull(localPrueba[i].getIdioma());
					assertNotNull(localPrueba[i].getNomVocabulario());
					
					assertEquals(identificadores.get(i),localPrueba[i].getIdVocabulario());
					assertEquals(nombres.get(i),localPrueba[i].getNomVocabulario());
					TerminoVO[] termino = localPrueba[i].getTerminos();
					
					for (int j=0;j<termino.length;j++){
						assertNotNull(termino[j].getIdiomaTermino());
						terminoaux.add(termino[j].getNomTermino());
						idaux.add(termino[j].getIdTermino());
					}
					
					
				}
				for (int k=0;k<terminoaux.size();k++){
					assertNotNull(terminoaux.get(k));
					assertNotNull(idaux.get(k));
					assertEquals(nombresHijos.get(k), terminoaux.get(k));
					assertEquals(identificadoresHijos.get(k),idaux.get(k));
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}

    /**
     *   TEST crearTraduccionAIngles
     *   TODO: Implementar el test para el metodo crearTraduccionAIngles del servicio SrvVocabulariosControladosService.
     */
     public void testcrearTraduccionAIngles() {
    	 java.util.ArrayList l_id=new ArrayList();
    	 
    	 l_id.add("1.3.2");
    	 l_id.add("5.2.34");
    	 l_id.add("5.12.3");
    	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
    	 
    	 List identificadores=new ArrayList();
    	 List nombres=new ArrayList();
    	 List idPadre=new ArrayList();
    	 identificadores.add("1.3.2");
    	 identificadores.add("5.2.34");
    	 identificadores.add("5.12.3");
    	 nombres.add("ca");
    	 nombres.add("web design service");
    	 nombres.add("collaborate");
    	 idPadre.add("1.3");
    	 idPadre.add("5.2");
    	 idPadre.add("5.12");
 
    	 
    	 SrvVocabulariosControladosService traduceIngles=this.servicio;

		
		try{
			TerminoYPadreVO[]localPrueba=traduceIngles.crearTraduccionAIngles(l_id2);
			assertNotNull(localPrueba);
			for(int i=0;i<localPrueba.length;i++){
				assertNotNull(localPrueba[i].getIdiomaTermino());
				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());
				assertEquals(nombres.get(i),localPrueba[i].getNomTermino());
				assertEquals(idPadre.get(i),localPrueba[i].getIdVocabulario());
			}
		}catch(Exception e){
			e.printStackTrace();
		}

    }
     
     
     public void testcrearTraduccionAIngles2() {
    	 java.util.ArrayList l_id=new ArrayList();
    	 
    	 l_id.add("5.11.2");
    	 l_id.add("5.2.35");
    	 l_id.add("1.3.5");
    	 l_id.add("5.12.2");
    	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
    	 
    	 List identificadores=new ArrayList();
    	 List nombres=new ArrayList();
    	 List idPadre=new ArrayList();
    	 identificadores.add("5.11.2");
    	 identificadores.add("5.2.35");
    	 identificadores.add("1.3.5");
    	 identificadores.add("5.12.2");
    	 nombres.add("ca");
    	 nombres.add("office service");
    	 nombres.add("gl");
    	 nombres.add("implement");
    	 idPadre.add("5.11");
    	 idPadre.add("5.2");
    	 idPadre.add("1.3");
    	 idPadre.add("5.12");

    	 SrvVocabulariosControladosService traduceIngles=this.servicio;

		
		try{
			TerminoYPadreVO[]localPrueba=traduceIngles.crearTraduccionAIngles(l_id2);
			assertNotNull(localPrueba);
			for(int i=0;i<localPrueba.length;i++){
				assertNotNull(localPrueba[i].getIdiomaTermino());
				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());
				assertEquals(nombres.get(i),localPrueba[i].getNomTermino());
				assertEquals(idPadre.get(i),localPrueba[i].getIdVocabulario());
			}
		}catch(Exception e){
			e.printStackTrace();
		}

    }

    /**
     *   TEST crearTraduccionAIdioma
     *   TODO: Implementar el test para el metodo crearTraduccionAIdioma del servicio SrvVocabulariosControladosService.
     */
     public void testcrearTraduccionAIdioma() {
    	 java.util.ArrayList l_id=new ArrayList();
    	 
    	 l_id.add("5.6.13");
    	 l_id.add("5.12.23");
    	 l_id.add("5.2.43");
    	 l_id.add("1.3.6");
    	 
    	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
    	 String idioma="es";
    	  
    	 ArrayList identificadores=new ArrayList();
    	 ArrayList nombres=new ArrayList();
    	 identificadores.add("5.6.13");
    	 identificadores.add("5.12.23");
    	 identificadores.add("5.2.43");
    	 identificadores.add("1.3.6");
    	 nombres.add("semipresencial");
    	 nombres.add("investigar");
    	 nombres.add("actividad de discusión");
    	 nombres.add("x-none");
    	 
    	 
    	 SrvVocabulariosControladosService traduceIdioma=this.servicio;

		
		try{
			TerminoVO[]localPrueba=traduceIdioma.crearTraduccionAIdioma(l_id2,idioma);
			assertNotNull(localPrueba);
			for(int i=0;i<localPrueba.length;i++){
				assertNotNull(localPrueba[i].getIdiomaTermino());
				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());
				assertEquals(nombres.get(i),localPrueba[i].getNomTermino());
			}
		}catch(Exception e){
			e.printStackTrace();
		}


    }
     
     public void testcrearTraduccionAIdioma2() {
    	 java.util.ArrayList l_id=new ArrayList();
    	 
    	 l_id.add("5.2.5");
    	 l_id.add("5.11.3");
    	 l_id.add("5.12.23");
    	 l_id.add("1.3.6");
    	 l_id.add("5.6.12");
    	 l_id.add("1.3.5");
    	 
    	 String[] l_id2 = (String[])l_id.toArray(new String[l_id.size()]);
    	 String idioma="eu";
    	  
    	 ArrayList identificadores=new ArrayList();
    	 ArrayList nombres=new ArrayList();
    	 identificadores.add("5.2.5");
    	 identificadores.add("5.11.3");
    	 identificadores.add("5.12.23");
    	 identificadores.add("1.3.6");
    	 identificadores.add("5.6.12");
    	 identificadores.add("1.3.5");
    	 nombres.add("musika");
    	 nombres.add("en");
    	 nombres.add("ikertu");
//    	 nombres.add("bat ere ez");
    	 nombres.add("x-none");
    	 nombres.add("presentziazkoa");
    	 nombres.add("gl");
    	 
    	 
    	 SrvVocabulariosControladosService traduceIdioma=this.servicio;

		
		try{
			TerminoVO[]localPrueba=traduceIdioma.crearTraduccionAIdioma(l_id2,idioma);
			assertNotNull(localPrueba);
			for(int i=0;i<localPrueba.length;i++){
				assertNotNull(localPrueba[i].getIdiomaTermino());
				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());
				assertEquals(nombres.get(i),localPrueba[i].getNomTermino());
			}
		}catch(Exception e){
			e.printStackTrace();
		}


    }
     
     
     public void testobtenerIdTermino(){

    	 ArrayList identificadores=new ArrayList();
    	 ArrayList lista=new ArrayList();
    	    	 
    	 identificadores.add("5.2.24");
    	 identificadores.add("5.12.4");
    	 
    	 TerminoYPadreVO terminoypadre=new TerminoYPadreVO();
    	
    	 terminoypadre.setIdiomaTermino("en");
    	 terminoypadre.setIdVocabulario("5.2");
    	 terminoypadre.setNomTermino("wiki");
    	 lista.add(terminoypadre);
    	 
    	 
    	 TerminoYPadreVO terminoypadre2=new TerminoYPadreVO();
    	 
    	 terminoypadre2.setIdiomaTermino("en");
    	 terminoypadre2.setIdVocabulario("5.12");
    	 terminoypadre2.setNomTermino("compare");
    	 lista.add(terminoypadre2);
    	
    	 TerminoYPadreVO[] terminoypadreVO=(TerminoYPadreVO[])lista.toArray(new TerminoYPadreVO[lista.size()]);
    	 
    	 SrvVocabulariosControladosService obtieneIdTermino=this.servicio;
    	 
    	 try{
    		 TerminoYPadreVO[] localPrueba=obtieneIdTermino.obtenerIdTermino(terminoypadreVO);
    		 assertNotNull(localPrueba);
    		 for(int i=0;i<localPrueba.length;i++){
 				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());	
 			}
    		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     
     
     
     public void testobtenerIdTermino2(){

    	 ArrayList identificadores=new ArrayList();
    	 ArrayList lista=new ArrayList();
    	    	 
    	 identificadores.add("1.3.2");
    	 identificadores.add("5.6.8");
    	 
    	 TerminoYPadreVO terminoypadre=new TerminoYPadreVO();
    	
    	 terminoypadre.setIdiomaTermino("es");
    	 terminoypadre.setIdVocabulario("1.3");
    	 terminoypadre.setNomTermino("ca");
    	 lista.add(terminoypadre);
    	 
    	 
    	 TerminoYPadreVO terminoypadre2=new TerminoYPadreVO();
    	 
    	 terminoypadre2.setIdiomaTermino("es");
    	 terminoypadre2.setIdVocabulario("5.6");
    	 terminoypadre2.setNomTermino("tutor");
    	 lista.add(terminoypadre2);
    	
    	 TerminoYPadreVO[] terminoypadreVO=(TerminoYPadreVO[])lista.toArray(new TerminoYPadreVO[lista.size()]);
    	 
    	 SrvVocabulariosControladosService obtieneIdTermino=this.servicio;
    	 
    	 try{
    		 TerminoYPadreVO[] localPrueba=obtieneIdTermino.obtenerIdTermino(terminoypadreVO);
    		 assertNotNull(localPrueba);
    		 for(int i=0;i<localPrueba.length;i++){
 				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());	
 			}
    		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     
     public void testobtenerIdTermino3(){

    	 ArrayList identificadores=new ArrayList();
    	 ArrayList lista=new ArrayList();
    	    	 
    	 identificadores.add("1.3.2");
    	 identificadores.add("5.6.9");
    	 identificadores.add("5.2.45");
    	 
    	 TerminoYPadreVO terminoypadre=new TerminoYPadreVO();
    	
    	 terminoypadre.setIdiomaTermino("eu");
    	 terminoypadre.setIdVocabulario("1.3");
    	 terminoypadre.setNomTermino("ca");
    	 lista.add(terminoypadre);
    	 
    	 
    	 TerminoYPadreVO terminoypadre2=new TerminoYPadreVO();
    	 
    	 terminoypadre2.setIdiomaTermino("eu");
    	 terminoypadre2.setIdVocabulario("5.6");
    	 terminoypadre2.setNomTermino("ikaskidea");
    	 lista.add(terminoypadre2);
    	 
    	 TerminoYPadreVO terminoypadre3=new TerminoYPadreVO();
    	 
    	 terminoypadre3.setIdiomaTermino("eu");
    	 terminoypadre3.setIdVocabulario("5.2");
    	 terminoypadre3.setNomTermino("kontextualizaturiko kasua");
    	 lista.add(terminoypadre3);
    	
    	 TerminoYPadreVO[] terminoypadreVO=(TerminoYPadreVO[])lista.toArray(new TerminoYPadreVO[lista.size()]);
    	 
    	 SrvVocabulariosControladosService obtieneIdTermino=this.servicio;
    	 
    	 try{
    		 TerminoYPadreVO[] localPrueba=obtieneIdTermino.obtenerIdTermino(terminoypadreVO);
    		 assertNotNull(localPrueba);
    		 for(int i=0;i<localPrueba.length;i++){
 				assertEquals(identificadores.get(i), localPrueba[i].getIdTermino());	
 			}
    		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     


}