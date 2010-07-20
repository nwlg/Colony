/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.fuentestaxonomicas.negocio.servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @see SrvTaxonomiaServiceImpl
 */
public class TestSrvTaxonomiaServiceImpl
    extends SrvTaxonomiaServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvTaxonomiaServiceImpl(){
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
     *   TEST obtenerNodos
     *   TODO: Implementar el test para el metodo obtenerNodos del servicio SrvTaxonomiaService.
     */
//     public void testobtenerNodos() {//Error no tenemos arbol_curricular_en
//		String id="1";
//		String nomTaxonomia="arbol_curricular";
//		String idioma="en";
//		
//		List identificadores=new ArrayList();
//		List nomTaxon=new ArrayList();
//		
//		identificadores.add("1.1");
//		identificadores.add("1.2");
//		nomTaxon.add("First Cycle");
//		nomTaxon.add("Second Cycle");
//
//		SrvTaxonomiaService taxonomia = this.servicio;
//		try{
//			
//			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
//			assertNotNull(localPrueba);
//			for(int i=0;i<localPrueba.length;i++){
//				assertNotNull(localPrueba[i].getId());
//				assertNotNull(localPrueba[i].getValorTax());
//				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
//				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//    }
     
//     public void testobtenerNodos2(){//Error no tenemos arbol_curricular_en
//    	 
//    	 String nomTaxonomia="arbol_curricular";
//    	 String idioma="en";
//    	 
//    	 List identificadores=new ArrayList();
// 		 List nomTaxon=new ArrayList();
// 		 
// 		String id="1.2";
//
//		identificadores.add("1.2.1");
//		identificadores.add("1.2.2");
//		identificadores.add("1.2.3");
//		nomTaxon.add("Knowledge of itself and personal autonomy");
//		nomTaxon.add("Knowledge of the surroundings");
//		nomTaxon.add("Languages: Communication and representation");
//		SrvTaxonomiaService taxonomia = this.servicio;
//		
//		try{
//			
//			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
//			assertNotNull(localPrueba);
//			for(int i=0;i<localPrueba.length;i++){
//				assertNotNull(localPrueba[i].getId());
//				assertNotNull(localPrueba[i].getValorTax());
//				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
//				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//     }
//     
//     public void testobtenerNodos3(){//Error no tenemos arbol_curricular_en
//    	String nomTaxonomia="arbol_curricular";
// 		String idioma="en";
// 		String id="1.2.1";
// 		
// 		List identificadores=new ArrayList();
// 		List nomTaxon=new ArrayList();
// 		identificadores.add("1.2.1.1");
//		identificadores.add("1.2.1.2");
//		identificadores.add("1.2.1.3");
//		identificadores.add("1.2.1.4");
//		nomTaxon.add("Block 1: The body and the own image");
//		nomTaxon.add("Block 2: Game and movement");
//		nomTaxon.add("Block 3: The activity and the daily life");
//		nomTaxon.add("Block 4: The personal care and the health");
//		SrvTaxonomiaService taxonomia = this.servicio;
//		try{
//			
//			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
//			assertNotNull(localPrueba);
//			for(int i=0;i<localPrueba.length;i++){
//				assertNotNull(localPrueba[i].getId());
//				assertNotNull(localPrueba[i].getValorTax());
//				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
//				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
// 		
//     }
     public void testobtenerNodos4() {//Prueba hecha con MEC=NA
 		String id="2.1.2";
 		String nomTaxonomia="Arbol_curricular_LOE_2006";
 		String idioma="es";
 		
 		List identificadores=new ArrayList();
 		List nomTaxon=new ArrayList();
 		
 		identificadores.add("2.1.2.1");
 		identificadores.add("2.1.2.2");
 		identificadores.add("2.1.2.3");
// 		identificadores.add("2.1.2.4");
// 		identificadores.add("2.1.2.5");
// 		identificadores.add("2.1.2.6");
// 		identificadores.add("2.1.2.7");
// 		identificadores.add("2.1.2.8");
// 		identificadores.add("2.1.2.9");
// 		identificadores.add("2.1.2.10");
 		nomTaxon.add("Observaci�n pl�stica (MEC)");
 		nomTaxon.add("Expresi�n y creaci�n pl�stica; su experiencia y disfrute (MEC)");
 		nomTaxon.add("Audici�n, interpretaci�n y creaci�n musical (MEC)");
// 		nomTaxon.add("Observaci�n, expresi�n y creaci�n art�sticas");
// 		nomTaxon.add("Observaci�n y curiosidad por descubrir las posibilidades art�sticas que ofrece el entorno natural, artificial y art�stico ");
// 		nomTaxon.add("Organizaci�n de un proyecto art�stico");
// 		nomTaxon.add("Comprensi�n del sonido y del lenguaje musical");
// 		nomTaxon.add("Explorar y percibir");
// 		nomTaxon.add("Interpretar y crear");
// 		nomTaxon.add("Conexiones con otras �reas");
 		
 		SrvTaxonomiaService taxonomia = this.servicio;
 		try{
 			
 			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
 			assertNotNull(localPrueba);
 			for(int i=0;i<localPrueba.length;i++){
 				assertNotNull(localPrueba[i].getId());
 				assertNotNull(localPrueba[i].getValorTax());
 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId());
 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax());
 			}
 			
 		}catch(Exception e){
 			e.printStackTrace();
 		}

     }
     
     
     public void testobtenerNodos5() {//Con comunidad NA
  		String id="2.1.5";
  		String nomTaxonomia="Arbol_curricular_LOE_2006";
  		String idioma="es";
  		
  		List identificadores=new ArrayList();
  		List nomTaxon=new ArrayList();
  		
  		identificadores.add("2.1.5.1");
  		identificadores.add("2.1.5.2");
  		identificadores.add("2.1.5.3");
  		identificadores.add("2.1.5.4");
  		identificadores.add("2.1.5.5");
  		identificadores.add("2.1.5.6");
  		identificadores.add("2.1.5.7");
  		identificadores.add("2.1.5.8");
  		identificadores.add("2.1.5.9");
  		identificadores.add("2.1.5.10");
  		identificadores.add("2.1.5.11");
  		identificadores.add("2.1.5.12");
  		identificadores.add("2.1.5.13");
  		identificadores.add("2.1.5.14");
  		identificadores.add("2.1.5.15");
//  		identificadores.add("2.1.5.18");
  		nomTaxon.add("N�meros y operadores. Comprensi�n, representaci�n y uso (MEC)");
  		nomTaxon.add("N�meros naturales y operaciones (MEC)");
  		nomTaxon.add("Estrategias de c�lculo (MEC)");
  		nomTaxon.add("La medida: Estimaci�n y c�lculo de magnitudes (MEC)");
  		nomTaxon.add(" Longitud, peso/masa y capacidad (MEC)");
  		nomTaxon.add("Medida del tiempo (MEC)");
  		nomTaxon.add("Sistema monetario y calculadora (MEC)");
  		nomTaxon.add("Geometr�a. C�lculo, medida y an�lisis de formas. Elementos geom�tricos (MEC)");
  		nomTaxon.add(" La situaci�n en el espacio distancias y giros (MEC)");
  		nomTaxon.add("Formas planas y espaciales (MEC)");
  		nomTaxon.add("Regularidades y simetr�as (MEC)");
  		nomTaxon.add(" Tratamiento de la informaci�n, azar y probabilidad (MEC)");
  		nomTaxon.add("Gr�ficos y tablas (MEC)");
  		nomTaxon.add(" Car�cter aleatorio de algunas experiencias (MEC)");
  		nomTaxon.add("Gr�ficos estad�sticos (MEC)");
//  		nomTaxon.add(" Introducci�n al sistema monetario de la Uni�n Europea");
  		
  		SrvTaxonomiaService taxonomia = this.servicio;
  		try{
  			
  			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
  			assertNotNull(localPrueba);
  			for(int i=0;i<localPrueba.length;i++){
  				assertNotNull(localPrueba[i].getId());
  				assertNotNull(localPrueba[i].getValorTax());
  				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId());
  				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax());
  			}
  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}

      }
     
     public void testobtenerNodos6() {//Con comunidad NA
   		String id="2.2.1";
   		String nomTaxonomia="Arbol_curricular_LOE_2006";
   		String idioma="es";
   		
   		List identificadores=new ArrayList();
   		List nomTaxon=new ArrayList();
   		
   		identificadores.add("2.2.1.1");
   		identificadores.add("2.2.1.2");
   		identificadores.add("2.2.1.3");
   		identificadores.add("2.2.1.4");
   		identificadores.add("2.2.1.5");
   		identificadores.add("2.2.1.6");
   		identificadores.add("2.2.1.7");
//   		identificadores.add("2.2.1.13");
//   		identificadores.add("2.2.1.14");
//   		identificadores.add("2.2.1.15");
   		
   		nomTaxon.add(" El entorno: Conocimiento, construcci�n y conservaci�n (MEC)");
   		nomTaxon.add("La diversidad de los seres vivos (MEC)");
   		nomTaxon.add("La salud y el desarrollo personal (MEC)");
   		nomTaxon.add(" Personas, culturas y organizaci�n social (MEC)");
   		nomTaxon.add("Cambios en el tiempo (MEC)");
   		nomTaxon.add("Materia y energ�a (MEC)");
   		nomTaxon.add("Objetos, m�quinas y tecnolog�as (MEC)");
//   		nomTaxon.add(" La vida, cultura y la convivencia en sociedad");
//   		nomTaxon.add(" Las personas y la salud");
//   		nomTaxon.add("Cambio y continuidad en el tiempo");
   		
   		
   		SrvTaxonomiaService taxonomia = this.servicio;
   		try{
   			
   			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
   			assertNotNull(localPrueba);
//   			for(int i=0;i<localPrueba.length-1;i++){
   			for(int i=0;i<nomTaxon.size()-1;i++){
   				assertNotNull(localPrueba[i].getId());
   				assertNotNull(localPrueba[i].getValorTax());
   				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId());
   				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax());
   			}
   			
   		}catch(Exception e){
   			e.printStackTrace();
   		}

       }

     
//     public void testobtenerNodos7() {//Error no tenemos arbol_curricular_eu
//  		String id="2.1.2";
//  		String nomTaxonomia="arbol_curricular";
//  		String idioma="eu";
//  		
//  		List identificadores=new ArrayList();
//  		List nomTaxon=new ArrayList();
//  		
//  		identificadores.add("2.1.2.1");
//  		identificadores.add("2.1.2.2");
//  		identificadores.add("2.1.2.3");
//  		identificadores.add("2.1.2.4");
//  		nomTaxon.add("1 Blokea: Azterketa plastikoa");
//  		nomTaxon.add("2 Blokea: Adierazpen eta sorkuntza plastikoa");
//  		nomTaxon.add("3 Blokea: Entzumena");
//  		nomTaxon.add("4 Blokea: Interpretazio eta sorkuntza musikala");
//
//  		SrvTaxonomiaService taxonomia = this.servicio;
//  		try{
//  			
//  			TaxonVO[] localPrueba=taxonomia.obtenerNodos(id, nomTaxonomia, idioma);
//  			assertNotNull(localPrueba);
//  			for(int i=0;i<localPrueba.length;i++){
//  				assertNotNull(localPrueba[i].getId());
//  				assertNotNull(localPrueba[i].getValorTax());
//  				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
//  				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
//  			}
//  			
//  		}catch(Exception e){
//  			e.printStackTrace();
//  		}
//
//      }
     
     
    /**
     *   TEST obtenerTaxonomia
     *   TODO: Implementar el test para el metodo obtenerTaxonomia del servicio SrvTaxonomiaService.
     */
//     public void testobtenerTaxonomia() {//Error no tenemos arbol_curricular_en
// 		String nomTaxonomia="arbol_curricular";
// 		String idioma="en";
// 		
// 		List identificadores=new ArrayList();
// 		List nomTaxon=new ArrayList();
// 		
// 		identificadores.add("1");
// 		identificadores.add("2");
// 		identificadores.add("3");
// 		identificadores.add("4");
// 		identificadores.add("5");
// 		identificadores.add("6");
// 		identificadores.add("7");
// 		nomTaxon.add("Infantile education");
// 		nomTaxon.add("Primary education");
// 		nomTaxon.add("Obligatory Secondary education");
// 		nomTaxon.add("Baccalaureate");
// 		nomTaxon.add("Specific Professional formation");
// 		nomTaxon.add("Artistic lessons");
// 		nomTaxon.add("Lessons of languages");
// 		
// 		SrvTaxonomiaService taxonomia = this.servicio;
//
// 		try{
// 			TaxonVO[] localPrueba=taxonomia.obtenerTaxonomia( nomTaxonomia, idioma);
// 			assertNotNull(localPrueba);
// 			for(int i=0;i<localPrueba.length;i++){
// 				assertNotNull(localPrueba[i].getId());
// 				assertNotNull(localPrueba[i].getValorTax());
// 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
// 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
// 			}
// 			
// 		}catch(Exception e){
// 			e.printStackTrace();
// 		}
//     }
     
     public void testobtenerTaxonomia2() {
  		String nomTaxonomia="Arbol_curricular_LOE_2006";
  		String idioma="es";
  		
  		List identificadores=new ArrayList();
  		List nomTaxon=new ArrayList();
  		
  		identificadores.add("1");
  		identificadores.add("2");
  		identificadores.add("3");
  		identificadores.add("4");
  		identificadores.add("5");
  		identificadores.add("6");
  		identificadores.add("7");
  		
  		nomTaxon.add("Educaci�n Infantil (MEC)");
  		nomTaxon.add("Educaci�n Primaria (MEC)");
  		nomTaxon.add("Educaci�n Secundaria Obligatoria (MEC)");
  		nomTaxon.add("Bachillerato (MEC)");
  		nomTaxon.add("Formaci�n Profesional Espec�fica (MEC)");
  		nomTaxon.add("Ense�anzas Art�sticas: M�sica y Danza (MEC)");
  		nomTaxon.add("Ense�anza Oficial de Idiomas (MEC)");
  		
  		
  		SrvTaxonomiaService taxonomia = this.servicio;

  		try{
  			TaxonVO[] localPrueba=taxonomia.obtenerTaxonomia( nomTaxonomia, idioma);
  			assertNotNull(localPrueba);
  			for(int i=0;i<localPrueba.length;i++){
  				assertNotNull(localPrueba[i].getId());
  				assertNotNull(localPrueba[i].getValorTax());
  				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
  				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
  			}
  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}
      }
     
//     public void testobtenerTaxonomia3() {//Error no tenemos arbol_curricular_eu
//  		String nomTaxonomia="arbol_curricular";
//  		String idioma="eu";
//  		
//  		List identificadores=new ArrayList();
//  		List nomTaxon=new ArrayList();
//  		
//  		identificadores.add("1");
//  		identificadores.add("2");
//  		identificadores.add("3");
//  		identificadores.add("4");
//  		identificadores.add("5");
//  		identificadores.add("6");
//  		identificadores.add("7");
//  		
//  		nomTaxon.add("Haur-hezkuntza");
//  		nomTaxon.add("Lehen Hezkuntza");
//  		nomTaxon.add("Derrigorrezko Bigarren Hezkuntza");
//  		nomTaxon.add("Batxillergoa");
//  		nomTaxon.add("Formazio Profesional Espezifikoa");
//  		nomTaxon.add("Irakaskuntza artistikoa");
//  		nomTaxon.add("Hizkuntz irakaskuntza");
//  		
//  		SrvTaxonomiaService taxonomia = this.servicio;
//
//  		try{
//  			TaxonVO[] localPrueba=taxonomia.obtenerTaxonomia( nomTaxonomia, idioma);
//  			assertNotNull(localPrueba);
//  			for(int i=0;i<localPrueba.length;i++){
//  				assertNotNull(localPrueba[i].getId());
//  				assertNotNull(localPrueba[i].getValorTax());
//  				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
//  				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
//  			}
//  			
//  		}catch(Exception e){
//  			e.printStackTrace();
//  		}
//      }
 		
// 		public void testobtenerTaxonPath(){//Error no tenemos arbol_curricular_en
// 			String id="1.2.1.1";
// 			String nomTaxonomia="arbol_curricular";
// 	 		String idioma="en";
// 	 		
// 	 		List identificadores=new ArrayList();
// 	 		List nomTaxon=new ArrayList();
// 	 		
// 	 		identificadores.add("1.2.1.1");
// 	 		identificadores.add("1.2.1");
// 	 		identificadores.add("1.2");
// 	 		identificadores.add("1");
// 	 		
// 	 		nomTaxon.add("Block 1: The body and the own image");
// 	 		nomTaxon.add("Knowledge of itself and personal autonomy");
// 	 		nomTaxon.add("Second Cycle");
// 	 		nomTaxon.add("Infantile education");
// 
// 	 		SrvTaxonomiaService taxonomiaPath = this.servicio;
// 	 		
// 	 		try{
// 	 			TaxonVO[] localPrueba=taxonomiaPath.obtenerTaxonPath( id,nomTaxonomia, idioma);
// 	 			assertNotNull(localPrueba);
// 	 			for(int i=0;i<localPrueba.length;i++){
// 	 				assertNotNull(localPrueba[i].getId());
// 	 				assertNotNull(localPrueba[i].getValorTax());
// 	 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
// 	 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
// 	 			}
// 	 			
// 	 		}catch(Exception e){
// 	 			e.printStackTrace();
// 	 		}
// 		}
 			
 	 		
 	 		public void testobtenerTaxonPath2(){
 	 			String id="3.4.5.2";
 	 			String nomTaxonomia="Arbol_curricular_LOE_2006";
 	 	 		String idioma="es";
 	 	 		
 	 	 		List identificadores=new ArrayList();
 	 	 		List nomTaxon=new ArrayList();
 	 	 		
 	 	 		identificadores.add("3.4.5.2");
 	 	 		identificadores.add("3.4.5");
 	 	 		identificadores.add("3.4");
 	 	 		identificadores.add("3");
 	 	 		
 	 	 		nomTaxon.add(" Identidad y alteridad. Educaci�n afectivoemocional");
 	 	 		nomTaxon.add("Educaci�n �tico - C�vica");
 	 	 		nomTaxon.add("Cuarto curso");
 	 	 		nomTaxon.add("Educaci�n Secundaria Obligatoria");
 	 
 	 	 		SrvTaxonomiaService taxonomiaPath = this.servicio;
 	 	 		
 	 	 		try{
 	 	 			TaxonVO[] localPrueba=taxonomiaPath.obtenerTaxonPath( id,nomTaxonomia, idioma);
 	 	 			assertNotNull(localPrueba);
 	 	 			for(int i=0;i<localPrueba.length;i++){
 	 	 				assertNotNull(localPrueba[i].getId());
 	 	 				assertNotNull(localPrueba[i].getValorTax());
 	 	 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
 	 	 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
 	 	 			}
 	 	 			
 	 	 		}catch(Exception e){
 	 	 			e.printStackTrace();
 	 	 		}
 	 	 		
 	 	 		
 		}
 	 		
 	 		public void testobtenerTaxonPath3(){//Con comunidad CL, pero no lo podemos probar, no recoge la propiedad del sistema
 	 			String id="2.2.5.15";
 	 			String nomTaxonomia="Arbol_curricular_LOE_2006";
 	 	 		String idioma="es";
 	 	 		
 	 	 		List identificadores=new ArrayList();
 	 	 		List nomTaxon=new ArrayList();
 	 	 		
 	 	 		identificadores.add("2.2.5.15");
 	 	 		identificadores.add("2.2.5");
 	 	 		identificadores.add("2.2");
 	 	 		identificadores.add("2");
 	 	 		
 	 	 		nomTaxon.add("Contenidos comunes");
 	 	 		nomTaxon.add("Matem�ticas");
 	 	 		nomTaxon.add("Segundo ciclo");
 	 	 		nomTaxon.add("Educaci�n Primaria");
 	 
 	 	 		SrvTaxonomiaService taxonomiaPath = this.servicio;
 	 	 		
 	 	 		try{
 	 	 			TaxonVO[] localPrueba=taxonomiaPath.obtenerTaxonPath( id,nomTaxonomia, idioma);
 	 	 			assertNotNull(localPrueba);
 	 	 			for(int i=0;i<localPrueba.length;i++){
 	 	 				assertNotNull(localPrueba[i].getId());
 	 	 				assertNotNull(localPrueba[i].getValorTax());
 	 	 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
 	 	 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
 	 	 			}
 	 	 			
 	 	 		}catch(Exception e){
 	 	 			e.printStackTrace();
 	 	 		}
 	 	 		
 	 	 		
 		}
 	 		
 	 		public void testobtenerTaxonPath4(){
 	 			String id="2.1";
 	 			String nomTaxonomia="Arbol_curricular_LOE_2006";
 	 	 		String idioma="es";
 	 	 		
 	 	 		List identificadores=new ArrayList();
 	 	 		List nomTaxon=new ArrayList();
 	 	 		
 	 	 		identificadores.add("2.1");
 	 	 		identificadores.add("2");
 	 	 		
 	 	 		nomTaxon.add("Primer ciclo");
 	 	 		nomTaxon.add("Educaci�n Primaria");
 	 	 		
 	 
 	 	 		SrvTaxonomiaService taxonomiaPath = this.servicio;
 	 	 		
 	 	 		try{
 	 	 			TaxonVO[] localPrueba=taxonomiaPath.obtenerTaxonPath( id,nomTaxonomia, idioma);
 	 	 			assertNotNull(localPrueba);
 	 	 			for(int i=0;i<localPrueba.length;i++){
 	 	 				assertNotNull(localPrueba[i].getId());
 	 	 				assertNotNull(localPrueba[i].getValorTax());
 	 	 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
 	 	 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
 	 	 			}
 	 	 			
 	 	 		}catch(Exception e){
 	 	 			e.printStackTrace();
 	 	 		}
 	 		}
 	 		
// 	 		public void testobtenerTaxonPath5(){//Error no tenemos arbol_curricular_en
// 	 			String id="2.1.1.2";
// 	 			String nomTaxonomia="arbol_curricular";
// 	 	 		String idioma="en";
// 	 	 		
// 	 	 		List identificadores=new ArrayList();
// 	 	 		List nomTaxon=new ArrayList();
// 	 	 		
// 	 	 		identificadores.add("2.1.1.2");
// 	 	 		identificadores.add("2.1.1");
// 	 	 		identificadores.add("2.1");
// 	 	 		identificadores.add("2");
// 	 	 		
// 	 	 		nomTaxon.add("Block 2: The diversity of the alive beings");
// 	 	 		nomTaxon.add("Knowledge of natural, social and cultural means");
// 	 	 		nomTaxon.add("First Cycle");
// 	 	 		nomTaxon.add("Primary education");
// 	 	 		
// 	 	 		
// 	 
// 	 	 		SrvTaxonomiaService taxonomiaPath = this.servicio;
// 	 	 		
// 	 	 		try{
// 	 	 			TaxonVO[] localPrueba=taxonomiaPath.obtenerTaxonPath( id,nomTaxonomia, idioma);
// 	 	 			assertNotNull(localPrueba);
// 	 	 			for(int i=0;i<localPrueba.length;i++){
// 	 	 				assertNotNull(localPrueba[i].getId());
// 	 	 				assertNotNull(localPrueba[i].getValorTax());
// 	 	 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
// 	 	 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
// 	 	 			}
// 	 	 			
// 	 	 		}catch(Exception e){
// 	 	 			e.printStackTrace();
// 	 	 		}
// 	 		}
 	 		
// 	 		public void testobtenerTaxonPath6(){//Error no tenemos arbol_curricular_eu
// 	 			String id="1.2.1.1";
// 	 			String nomTaxonomia="arbol_curricular";
// 	 	 		String idioma="eu";
// 	 	 		
// 	 	 		List identificadores=new ArrayList();
// 	 	 		List nomTaxon=new ArrayList();
// 	 	 		
// 	 	 		identificadores.add("1.2.1.1");
// 	 	 		identificadores.add("1.2.1");
// 	 	 		identificadores.add("1.2");
// 	 	 		identificadores.add("1");
// 	 	 		
// 	 	 		nomTaxon.add("1 Blokea: Gorputza eta norbanakoaren itxura");
// 	 	 		nomTaxon.add("Bere buruaren ezagutza eta autonomia pertsonala");
// 	 	 		nomTaxon.add("Bigarren Zikloa");
// 	 	 		nomTaxon.add("Haur-hezkuntza");
// 	 
// 	 	 		SrvTaxonomiaService taxonomiaPath = this.servicio;
// 	 	 		
// 	 	 		try{
// 	 	 			TaxonVO[] localPrueba=taxonomiaPath.obtenerTaxonPath( id,nomTaxonomia, idioma);
// 	 	 			assertNotNull(localPrueba);
// 	 	 			for(int i=0;i<localPrueba.length;i++){
// 	 	 				assertNotNull(localPrueba[i].getId());
// 	 	 				assertNotNull(localPrueba[i].getValorTax());
// 	 	 				assertEquals(identificadores.get(i).toString().trim(),localPrueba[i].getId().trim());
// 	 	 				assertEquals(nomTaxon.get(i).toString().trim(),localPrueba[i].getValorTax().trim());
// 	 	 			}
// 	 	 			
// 	 	 		}catch(Exception e){
// 	 	 			e.printStackTrace();
// 	 	 		}
// 	 		}
 	 		
 	 		public void testobtenerTaxonomiaCompletaPreorden(){
 	 			SrvTaxonomiaService taxonomiaServ = this.servicio;
 	 			TaxonConRutaVO[] taxonomia = taxonomiaServ.obtenerTaxonomiaCompletaPreorden("arbol_curricular", "es");
 	 			
 	 			for (int i=0; i< taxonomia.length;i++){
 	 				System.out.println(taxonomia[i].getId());
 	 			}
 	 		}
 	 		
 	 		public String testobtenerVocabName(){
 	 			SrvTaxonomiaService taxonomiaServ = this.servicio;
 	 			String vocabName=taxonomiaServ.obtenerVocabName("Arbol_Curricular_Agrega", "es");
 	 			System.out.println(vocabName);
				return vocabName;
				
 	 		}
 	 		public String testobtenerVocabName1(){
 	 			SrvTaxonomiaService taxonomiaServ = this.servicio;
 	 			String vocabName=taxonomiaServ.obtenerVocabName("Competencia_LOM-ES", "es");
 	 			System.out.println(vocabName);
				return vocabName;
				
 	 		}	
 	 		public void testobtenerVariosTaxonPaths(){
 	 			SrvTaxonomiaService taxonomiaServ = this.servicio;
 	 			Collection datosSalida=new ArrayList();
 	 			String[] ides=new String[4];
 	 			ides[0]="2.2.5.15";
 	 			ides[1]="2.1";
 	 			ides[2]="17.9";
 	 			ides[3]="2.2.4";
 	 			TaxonPathVO[] datos=taxonomiaServ.obtenerVariosTaxonPaths(ides, "Arbol_curricular_LOE_2006", "es");
 	 			for(int i=0;i<datos.length;i++){
 	 				TaxonVO[] tax=datos[i].getDatos();
 	 				for(int j=0;j<tax.length;j++){
 	 					System.out.println(tax[j].getId());
 	 				}
 	 			
 	 			}
 	 			
 	 		}
 	 		public String[] testobtenerVocabNames(){
 	 			SrvTaxonomiaService taxonomiaServ = this.servicio;
 	 			String[] vocabs=new String[2];
 	 			vocabs[0]="Arbol_Curricular_Agrega";
 	 			vocabs[1]="Accesibilidad_LOM-ES";
 	 			
 	 			String[] vocabName=taxonomiaServ.obtenerVocabNames(vocabs, "es");
 	 			for(int i=0;i<vocabName.length;i++){
 	 				System.out.println(vocabName[i]);
 	 			}
				return vocabName;
				
 	 		}
 	 			
}