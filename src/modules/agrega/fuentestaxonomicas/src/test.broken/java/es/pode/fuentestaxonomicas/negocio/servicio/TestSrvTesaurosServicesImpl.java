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

/**
 * @see SrvTesaurosServicesImpl
 */
public class TestSrvTesaurosServicesImpl
    extends SrvTesaurosServicesImplBase
{


    /**
     * Constructor
     */
     public TestSrvTesaurosServicesImpl(){
		super();
	}

    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
		super.onSetUpInTransaction();
	}

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
	 	
    	 super.onTearDownInTransaction();
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
     *   TEST obtenerTerminosRelacionadosPorId
     *   TODO: Implementar el test para el metodo obtenerTerminosRelacionadosPorId del servicio SrvTesaurosServices.
     */
     public void testobtenerTerminosRelacionadosPorId() {
     	String id = "391";
     	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
     	String idioma = "es";     
     	TaxonVO taxon = new TaxonVO();
      	TaxonVO taxon1 = new TaxonVO();
    	TaxonVO taxon2 = new TaxonVO();
    	TaxonVO taxon3 = new TaxonVO();
    	TaxonVO taxon4 = new TaxonVO();
    	TaxonVO taxon5 = new TaxonVO();
    	taxon.setId("569");
//    	taxon.setValorTax("(TG) orientaci�n");
    	taxon.setValorTax("orientaci�n");
    	taxon1.setId("4432");
//    	taxon1.setValorTax("(TE) orientador escolar");
    	taxon1.setValorTax("orientador escolar");
    	taxon3.setId("276");
//    	taxon3.setValorTax("(TR) consejo orientador");
    	taxon3.setValorTax("consejo orientador");
    	taxon4.setId("386");
//    	taxon4.setValorTax("(TR) educaci�n");
    	taxon4.setValorTax("educaci�n");
    	taxon5.setId("156");
//    	taxon5.setValorTax("(TR) rama de estudio");
    	taxon5.setValorTax("rama de estudio");

     	TaxonVO[] taxones = new TaxonVO[5];
     	taxones[0] = taxon;
     	taxones[1] = taxon1;
       	taxones[2] = taxon3;
     	taxones[3] = taxon4; 
     	taxones[4] = taxon5;  
      	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
      	for (int i = 0; i<relaciones.length;i++){
      		assertEquals(relaciones[i].getId(),taxones[i].getId());
     		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
      		System.out.print(relaciones[i].getId());
      		System.out.println(" " + relaciones[i].getValorTax() );
      	}
     }
     
     public void testobtenerTerminosRelacionadosPorId2() {
      	String id = "53";
       	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "es";      	
       	TaxonVO taxon1 = new TaxonVO();
     	TaxonVO taxon2 = new TaxonVO();
   
     	taxon1.setId("790");
//     	taxon1.setValorTax("(TR) matem�ticas");
     	taxon1.setValorTax("matem�ticas");
     	taxon2.setId("1034");
//     	taxon2.setValorTax("(TR) programaci�n (inform�tica)");
     	taxon2.setValorTax("programaci�n (inform�tica)");

      	TaxonVO[] taxones = new TaxonVO[5];
      	taxones[0] = taxon1;
      	taxones[1] = taxon2;
    	
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
       	for (int i = 0; i<relaciones.length;i++){
       		assertEquals(relaciones[i].getId(),taxones[i].getId());
      		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
       	}
      }
     
     public void testobtenerTerminosRelacionadosPorId3() {
      	String id = "790";
      	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "es";  
      	TaxonVO taxon = new TaxonVO();
       	TaxonVO taxon1 = new TaxonVO();
     	TaxonVO taxon2 = new TaxonVO();
     	TaxonVO taxon3 = new TaxonVO();
     	TaxonVO taxon4 = new TaxonVO();
     	TaxonVO taxon5 = new TaxonVO();
     	TaxonVO taxon6 = new TaxonVO();
     	TaxonVO taxon7 = new TaxonVO();
     	TaxonVO taxon8 = new TaxonVO();
     	TaxonVO taxon9 = new TaxonVO();
     	TaxonVO taxon10 = new TaxonVO();
     	TaxonVO taxon11= new TaxonVO();
     	TaxonVO taxon12= new TaxonVO();
     	TaxonVO taxon13= new TaxonVO();
     	TaxonVO taxon14= new TaxonVO();
     	TaxonVO taxon15= new TaxonVO();
     	TaxonVO taxon16= new TaxonVO();
     	TaxonVO taxon17= new TaxonVO();
     	TaxonVO taxon18= new TaxonVO();
     	taxon.setId("1143");
     	taxon.setValorTax("ciencias");
     	taxon1.setId("52");
     	taxon1.setValorTax("�lgebra");
     	taxon2.setId("789");
     	taxon2.setValorTax("an�lisis matem�tico");
     	taxon3.setId("3787");
     	taxon3.setValorTax("an�lisis num�rico");
     	taxon4.setId("88");
     	taxon4.setValorTax("aritm�tica");
     	taxon5.setId("170");
     	taxon5.setValorTax("c�lculo");
     	taxon6.setId("2028");
     	taxon6.setValorTax("combinatoria");
     	taxon7.setId("1242");
     	taxon7.setValorTax("estad�stica");
     	taxon8.setId("2767");
     	taxon8.setValorTax("fundamentos de las matem�ticas");
     	taxon9.setId("544");
     	taxon9.setValorTax("geometr�a");
     	taxon10.setId("4266");
     	taxon10.setValorTax("matem�tica recreativa");
     	taxon11.setId("77");
     	taxon11.setValorTax("matem�ticas aplicadas");
     	taxon12.setId("3450");
     	taxon12.setValorTax("pensamiento matem�tico");
     	taxon13.setId("1029");
     	taxon13.setValorTax("probabilidad");
     	taxon14.setId("4905");
     	taxon14.setValorTax("topolog�a");
     	taxon15.setId("53");
     	taxon15.setValorTax("algoritmo");
     	taxon16.setId("793");
     	taxon16.setValorTax("medida");
     	taxon17.setId("905");
     	taxon17.setValorTax("n�mero");
     	taxon18.setId("1029");
     	taxon18.setValorTax("probabilidad");
      	TaxonVO[] taxones = new TaxonVO[19];
      	taxones[0] = taxon;
      	taxones[1] = taxon1;
      	taxones[2] = taxon2;
      	taxones[3] = taxon3;
      	taxones[4] = taxon4; 
      	taxones[5] = taxon5;
      	taxones[6] = taxon6;
      	taxones[7] = taxon7;
      	taxones[8] = taxon8;
      	taxones[9] = taxon9;
      	taxones[10] = taxon10;
      	taxones[11] = taxon11;
      	taxones[12] = taxon12;
      	taxones[13] = taxon13;
      	taxones[14] = taxon14;
      	taxones[15] = taxon15;
      	taxones[16] = taxon16;
      	taxones[17] = taxon17;
      	taxones[18] = taxon18;
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
       	for (int i = 0; i<relaciones.length;i++){
       		assertEquals(relaciones[i].getId(),taxones[i].getId());
      		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
       		System.out.print(relaciones[i].getId());
       		System.out.println(" " + relaciones[i].getValorTax() );
       	}
      }

     public void testobtenerTerminosRelacionadosPorId4() {
       	String id = "1370";
       	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
       	String idioma = "es";  
       	TaxonVO taxon = new TaxonVO();
        TaxonVO taxon1 = new TaxonVO();
      	TaxonVO taxon2 = new TaxonVO();
      	TaxonVO taxon3 = new TaxonVO();
      	TaxonVO taxon4 = new TaxonVO();
      	TaxonVO taxon5 = new TaxonVO();
      	TaxonVO taxon6 = new TaxonVO();
      	TaxonVO taxon7 = new TaxonVO();
      	TaxonVO taxon8 = new TaxonVO();
      	TaxonVO taxon9 = new TaxonVO();
      	TaxonVO taxon10= new TaxonVO();
      	TaxonVO taxon11= new TaxonVO();
      	TaxonVO taxon12= new TaxonVO();

      	taxon.setId("569");
      	taxon.setValorTax("orientaci�n");
      	taxon12.setId("4161");
      	taxon12.setValorTax("movilidad profesional");
      	taxon1.setId("3806");
      	taxon1.setValorTax("orientaci�n ocupacional");
      	taxon2.setId("3200");
      	taxon2.setValorTax("orientaci�n para el empleo");
      	taxon3.setId("4153");
      	taxon3.setValorTax("orientador profesional");
      	taxon4.setId("5079");
      	taxon4.setValorTax("orientador vocacional");
      	taxon5.setId("4164");
      	taxon5.setValorTax("perfil profesional");
      	taxon6.setId("2753");
      	taxon6.setValorTax("pleno empleo");
      	taxon7.setId("4294");
      	taxon7.setValorTax("relaci�n empleo-formaci�n");
      	taxon8.setId("3845");
      	taxon8.setValorTax("servicio de orientaci�n");
      	taxon9.setId("245");
      	taxon9.setValorTax("evaluaci�n de competencias");
      	taxon10.setId("913");
      	taxon10.setValorTax("ocupaci�n");
      	taxon11.setId("1327");
      	taxon11.setValorTax("transici�n a la vida profesional");
      	
       	TaxonVO[] taxones = new TaxonVO[13];
       	taxones[0] = taxon;
       	taxones[1] = taxon12;
       	taxones[2] = taxon1;
       	taxones[3] = taxon2;
       	taxones[4] = taxon3;
       	taxones[5] = taxon4; 
       	taxones[6] = taxon5;
       	taxones[7] = taxon6;
       	taxones[8] = taxon7;
       	taxones[9] = taxon8;
       	taxones[10] = taxon9;
       	taxones[11] = taxon10;
       	taxones[12] = taxon11;
       	
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
        for (int i = 0; i<relaciones.length;i++){
       		assertEquals(relaciones[i].getId(),taxones[i].getId());
       		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
        	System.out.print(relaciones[i].getId());
        	System.out.println(" " + relaciones[i].getValorTax() );
        }
     }
     
     public void testobtenerTerminosRelacionadosPorId5() {
       	String id = "985";//planta (t�rmino general)
      	
       	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
       	String idioma = "es";  
       	TaxonVO taxon = new TaxonVO();
        TaxonVO taxon1 = new TaxonVO();
      	TaxonVO taxon2 = new TaxonVO();
      	TaxonVO taxon3 = new TaxonVO();
      	TaxonVO taxon4 = new TaxonVO();
      	TaxonVO taxon5 = new TaxonVO();
      	TaxonVO taxon6 = new TaxonVO();
      	TaxonVO taxon7 = new TaxonVO();
      	TaxonVO taxon8 = new TaxonVO();
      	TaxonVO taxon9 = new TaxonVO();
      	TaxonVO taxon10 = new TaxonVO();
      	
      	taxon.setId("1333");
      	taxon.setValorTax("�rbol");
      	taxon1.setId("4526");
      	taxon1.setValorTax("arbusto");
      	taxon4.setId("2929");
      	taxon4.setValorTax("herb�cea");
      	taxon2.setId("498");
      	taxon2.setValorTax("flor");
      	taxon3.setId("522");
      	taxon3.setValorTax("fruto");
      	taxon5.setId("717");
      	taxon5.setValorTax("hoja");
      	taxon6.setId("944");
      	taxon6.setValorTax("par�sito");
      	taxon7.setId("4383");
      	taxon7.setValorTax("ra�z");
      	taxon8.setId("4474");
      	taxon8.setValorTax("semilla");
      	taxon9.setId("4701");
      	taxon9.setValorTax("tallo");
      	taxon10.setId("153");
      	taxon10.setValorTax("bot�nica");
      	
       	TaxonVO[] taxones = new TaxonVO[11];
       	taxones[0] = taxon;
       	taxones[1] = taxon1;
       	taxones[2] = taxon2;
       	taxones[3] = taxon3;
       	taxones[4] = taxon4; 
       	taxones[5] = taxon5;
       	taxones[6] = taxon6;
       	taxones[7] = taxon7;
       	taxones[8] = taxon8;
       	taxones[9] = taxon9;
       	taxones[10] = taxon10;
       	
        	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
        	for (int i = 0; i<relaciones.length;i++){
        		assertEquals(relaciones[i].getId(),taxones[i].getId());
        		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
        		System.out.print(relaciones[i].getId());
        		System.out.println(" " + relaciones[i].getValorTax() );
        	}
       }
     
     public void testobtenerTerminosRelacionadosPorId6() {
      	String id = "4445";

      	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "es";     
      	TaxonVO taxon = new TaxonVO();
       	TaxonVO taxon1 = new TaxonVO();
     	TaxonVO taxon2 = new TaxonVO();
     	TaxonVO taxon3 = new TaxonVO();
     	TaxonVO taxon4 = new TaxonVO();

     	taxon.setId("4446");
     	taxon.setValorTax("conocimiento cient�fico");
     	taxon1.setId("2601");
     	taxon1.setValorTax("experimentaci�n");
     	taxon2.setId("4221");
     	taxon2.setValorTax("cuantificaci�n y matematizaci�n");
     	taxon3.setId("3526");
     	taxon3.setValorTax("m�todos");
     	taxon4.setId("1093");
     	taxon4.setValorTax("investigaci�n");

      	TaxonVO[] taxones = new TaxonVO[5];
      	taxones[0] = taxon;
      	taxones[1] = taxon2;
      	taxones[2] = taxon1;
      	taxones[3] = taxon3;
      	taxones[4] = taxon4; 
    
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
       	for (int i = 0; i<relaciones.length;i++){
       		assertEquals(relaciones[i].getId(),taxones[i].getId());
      		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
       		System.out.print(relaciones[i].getId());
       		System.out.println(" " + relaciones[i].getValorTax() );
       	}
      }
    
     
     public void testobtenerTerminosRelacionadosPorId7() {
       	String id = "4716";

       	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
       	String idioma = "es";     
       	TaxonVO taxon = new TaxonVO();
        TaxonVO taxon1 = new TaxonVO();
      	TaxonVO taxon2 = new TaxonVO();
      	TaxonVO taxon3 = new TaxonVO();
      	TaxonVO taxon4 = new TaxonVO();
      	      	
      	taxon.setId("4446");
      	taxon.setValorTax("conocimiento cient�fico");
      	taxon1.setId("4444");
      	taxon1.setValorTax("hechos cient�ficos");
      	taxon2.setId("3023");
      	taxon2.setValorTax("hip�tesis");
      	taxon3.setId("4447");
      	taxon3.setValorTax("leyes cient�ficas");
      	taxon4.setId("4452");
      	taxon4.setValorTax("teor�as cient�ficas");

       	TaxonVO[] taxones = new TaxonVO[5];
       	taxones[0] = taxon;
       	taxones[1] = taxon1;
       	taxones[2] = taxon2;
       	taxones[3] = taxon3;
       	taxones[4] = taxon4; 
     
        TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
        for (int i = 0; i<relaciones.length;i++){
        	assertEquals(relaciones[i].getId(),taxones[i].getId());
        	assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
        	System.out.print(relaciones[i].getId());
        	System.out.println(" " + relaciones[i].getValorTax() );
       	}
     }
     
     public void testobtenerTerminosRelacionadosPorId8() {
    	String id = "2578";

    	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
    	String idioma = "es";     
    	TaxonVO taxon = new TaxonVO();
        TaxonVO taxon1 = new TaxonVO();
       	TaxonVO taxon2 = new TaxonVO();
       	TaxonVO taxon3 = new TaxonVO();
       	       	
       	taxon.setId("1753");
       	taxon.setValorTax("dimensi�n biol�gica");
       	taxon1.setId("4366");
       	taxon1.setValorTax("papel de la t�cnica");
       	taxon2.setId("2993");
       	taxon2.setValorTax("evoluci�n humana");
       	taxon3.setId("3977");
       	taxon3.setValorTax("filog�nesis del ser humano");
	       	
    	TaxonVO[] taxones = new TaxonVO[4];
    	taxones[0] = taxon;
    	taxones[1] = taxon1;
    	taxones[2] = taxon2;
    	taxones[3] = taxon3;
	         
	      
     	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
     	for (int i = 0; i<relaciones.length;i++){
     		assertEquals(relaciones[i].getId(),taxones[i].getId());
    		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
     		System.out.print(relaciones[i].getId());
     		System.out.println(" " + relaciones[i].getValorTax() );
     	}
     } 
     
     public void testobtenerTerminosRelacionadosPorId9() {
        String id = "4442";
        String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
        String idioma = "es";  
        TaxonVO taxon = new TaxonVO();
        TaxonVO taxon1 = new TaxonVO();
       	TaxonVO taxon2 = new TaxonVO();
       	TaxonVO taxon3 = new TaxonVO();
       	TaxonVO taxon4 = new TaxonVO();
       	TaxonVO taxon5 = new TaxonVO();
       	TaxonVO taxon6 = new TaxonVO();
       	
       	taxon.setId("4112");
       	taxon.setValorTax("sociedad actual");
       	taxon1.setId("256");
       	taxon1.setValorTax("inform�tica");
       	taxon2.setId("673");
       	taxon2.setValorTax("internet");
       	taxon3.setId("1021");
       	taxon3.setValorTax("prensa");
       	taxon4.setId("1069");
       	taxon4.setValorTax("radio");
       	taxon5.setId("1296");
       	taxon5.setValorTax("televisi�n");
       	taxon6.setId("1361");
       	taxon6.setValorTax("(TR) video");
       	
        	TaxonVO[] taxones = new TaxonVO[7];
        	taxones[0] = taxon;
        	taxones[1] = taxon1;
        	taxones[2] = taxon2;
        	taxones[3] = taxon3;
        	taxones[4] = taxon4; 
        	taxones[5] = taxon5;
        	taxones[6] = taxon6;
        	
         	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
         	for (int i = 0; i<relaciones.length;i++){
         		assertEquals(relaciones[i].getId(),taxones[i].getId());
        		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
         		System.out.print(relaciones[i].getId());
         		System.out.println(" " + relaciones[i].getValorTax() );
         	}
        }
     
     public void testobtenerTerminosRelacionadosPorId10() {
     	String id = "303";

     	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
     	String idioma = "es";  

      	TaxonVO taxon = new TaxonVO();
       	TaxonVO taxon1 = new TaxonVO();
     	TaxonVO taxon2 = new TaxonVO();
     	TaxonVO taxon3 = new TaxonVO();
     	TaxonVO taxon4 = new TaxonVO();
     	TaxonVO taxon5 = new TaxonVO();
     	TaxonVO taxon6 = new TaxonVO();
     	TaxonVO taxon7 = new TaxonVO();
     	TaxonVO taxon8 = new TaxonVO();
     	TaxonVO taxon9 = new TaxonVO();
     	TaxonVO taxon10 = new TaxonVO();
     	TaxonVO taxon11= new TaxonVO();
     	TaxonVO taxon12= new TaxonVO();
     	TaxonVO taxon13= new TaxonVO();
     	TaxonVO taxon14= new TaxonVO();
     	TaxonVO taxon15= new TaxonVO();
     	TaxonVO taxon16= new TaxonVO();
     	TaxonVO taxon17= new TaxonVO();
     	TaxonVO taxon18= new TaxonVO();
     	
     	taxon.setId("M100");
     	taxon.setValorTax("100 CULTURA");
     	taxon1.setId("2207");
     	taxon1.setValorTax("dimensi�n cultural");
     	taxon2.setId("3962");
     	taxon2.setValorTax("filosof�a de la sociedad");
     	taxon3.setId("1976");
     	taxon3.setValorTax("cultura cl�sica");
     	taxon4.setId("1415");
     	taxon4.setValorTax("cultura juvenil");
     	taxon5.setId("499");
     	taxon5.setValorTax("cultura popular");
     	taxon6.setId("3711");
     	taxon6.setValorTax("naturaleza y cultura");
     	taxon7.setId("1210");
     	taxon7.setValorTax("actividades socio-culturales");
     	taxon8.setId("848");
     	taxon8.setValorTax("apoyo intercultural");
     	taxon9.setId("296");
     	taxon9.setValorTax("cambio cultural");
     	taxon10.setId("744");
     	taxon10.setValorTax("estilo de vida");
     	taxon11.setId("183");
     	taxon11.setValorTax("fiesta");
     	taxon12.setId("299");
     	taxon12.setValorTax("identidad cultural");
     	taxon13.setId("300");
     	taxon13.setValorTax("integraci�n cultural");
     	taxon14.setId("297");
     	taxon14.setValorTax("intercambio cultural");
     	taxon15.setId("301");
     	taxon15.setValorTax("modelo cultural");
     	taxon16.setId("298");
     	taxon16.setValorTax("patrimonio cultural");
     	taxon17.setId("302");
     	taxon17.setValorTax("pluralismo cultural");
     	taxon18.setId("1101");
     	taxon18.setValorTax("rito");
     	
      	TaxonVO[] taxones = new TaxonVO[19];
      	taxones[0] = taxon;
      	taxones[1] = taxon1;
      	taxones[2] = taxon2;
      	taxones[3] = taxon3;
      	taxones[4] = taxon4; 
      	taxones[5] = taxon5;
      	taxones[6] = taxon6;
      	taxones[7] = taxon7;
      	taxones[8] = taxon8;
      	taxones[9] = taxon9;
      	taxones[10] = taxon10;
      	taxones[11] = taxon11;
      	taxones[12] = taxon12;
      	taxones[13] = taxon13;
      	taxones[14] = taxon14;
      	taxones[15] = taxon15;
      	taxones[16] = taxon16;
      	taxones[17] = taxon17;
      	taxones[18] = taxon18;
    	
      	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
      	for (int i = 0; i<relaciones.length;i++){
      		assertEquals(relaciones[i].getId(),taxones[i].getId());
     		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
      		System.out.print(relaciones[i].getId());
      		System.out.println(" " + relaciones[i].getValorTax() );
      	}
     }
     
     public void testobtenerTerminosRelacionadosPorId11() {
      	String id = "1937";//reacciones qu�micas

      	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "es";  

       	TaxonVO taxon = new TaxonVO();
        TaxonVO taxon1 = new TaxonVO();
      	TaxonVO taxon2 = new TaxonVO();
      	TaxonVO taxon3 = new TaxonVO();
      	TaxonVO taxon4 = new TaxonVO();
      	TaxonVO taxon5 = new TaxonVO();
      	TaxonVO taxon6 = new TaxonVO();
      	TaxonVO taxon7 = new TaxonVO();
      	TaxonVO taxon8 = new TaxonVO();
         
      	taxon.setId("195");
      	taxon.setValorTax("qu�mica");
      	taxon1.setId("1653");
      	taxon1.setValorTax("intercambio de �tomos");
      	taxon2.setId("4270");
      	taxon2.setValorTax("oxidaci�n-reducci�n");
      	taxon3.setId("2370");
      	taxon3.setValorTax("qu�mica din�mica");
      	taxon4.setId("1936");
      	taxon4.setValorTax("reacci�n qu�mica");
      	taxon5.setId("1459");
      	taxon5.setValorTax("reacciones �cido-base");
      	taxon6.setId("3838");
      	taxon6.setValorTax("reacciones de los compuestos org�nicos");
      	taxon7.setId("4223");
      	taxon7.setValorTax("relaciones cuantitativas");
      	taxon8.setId("2540");
      	taxon8.setValorTax("sistemas en equilibrio");

       	TaxonVO[] taxones = new TaxonVO[19];
       	taxones[0] = taxon;
       	taxones[1] = taxon1;
       	taxones[2] = taxon2;
       	taxones[3] = taxon3;
       	taxones[4] = taxon4; 
       	taxones[5] = taxon5;
       	taxones[6] = taxon6;
       	taxones[7] = taxon7;
       	taxones[8] = taxon8;
       	
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
       	for (int i = 0; i<relaciones.length;i++){
       		assertEquals(relaciones[i].getId(),taxones[i].getId());
      		assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
       		System.out.print(relaciones[i].getId());
       		System.out.println(" " + relaciones[i].getValorTax() );
       	}
      }
     
     public void testobtenerTerminosRelacionadosPorId12() {
         String id = "629";
         String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
         String idioma = "es";  
             	
          	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
          	for (int i = 0; i<relaciones.length;i++){

          		System.out.print(relaciones[i].getId());
          		System.out.println(" " + relaciones[i].getValorTax() );
          	}
         }
     
    /**
     *   TEST obtenerJerarquia
     *   TODO: Implementar el test para el metodo obtenerJerarquia del servicio SrvTesaurosServices.
     */
     public void testobtenerJerarquia() {
     	String id = "790";//matem�ticas
     	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
     	String idioma = "es";
    	 
    	TaxonVO taxon1 = new TaxonVO();
    	TaxonVO taxon2 = new TaxonVO();
    	TaxonVO taxon3 = new TaxonVO();
    	TaxonVO taxon4 = new TaxonVO();
    	taxon1.setId("790");
    	taxon1.setValorTax("matem�ticas");
    	taxon2.setId("1143");
    	taxon2.setValorTax("ciencias");
    	taxon3.setId("M70.40");
    	taxon3.setValorTax("70.40 MATEM�TICAS Y CIENCIAS DE LA NATURALEZA");
    	taxon4.setId("M70");
    	taxon4.setValorTax("70 CONTENIDO DE LA EDUCACI�N");

     	TaxonVO[] taxones = new TaxonVO[4];
     	taxones[0] = taxon4;
     	taxones[1] = taxon3;
     	taxones[2] = taxon2;
     	taxones[3] = taxon1;
     	JerarquiaVO[] jerarquias =this.servicio.obtenerJerarquia(id, nomTesauro, idioma);
     	for(int j=0;j<jerarquias.length;j++){
//     	Iterator j = jerarquias.iterator();
//     	while (j.hasNext()){
	     	JerarquiaVO jerarquia2 = jerarquias[j];// j.next();
	     	TaxonVO[] jerarquia = jerarquia2.getJerarquia();
	     	System.out.println("");
	     	
	     	for (int i = 0; i<jerarquia.length;i++){
	     		System.out.print(" - ");
	     		assertEquals(jerarquia[i].getId(),taxones[i].getId());
	     		assertEquals(jerarquia[i].getValorTax(),taxones[i].getValorTax());
	     		System.out.print(jerarquia[i].getId());
	     		System.out.print(" " + jerarquia[i].getValorTax());
	     	}
	     	
	     	System.out.println("");
     	}
     	
    	
    }

     public void testobtenerJerarquia2() {
      	String id = "M100";
      	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "es";
     	 
     	TaxonVO taxon1 = new TaxonVO();
     
     	taxon1.setId("M100");
     	taxon1.setValorTax("100 CULTURA");
   
      	TaxonVO[] taxones = new TaxonVO[1];
      	taxones[0] = taxon1;
   
     	JerarquiaVO[] jerarquias =this.servicio.obtenerJerarquia(id, nomTesauro, idioma);
     	for(int j=0;j<jerarquias.length;j++){
	     	JerarquiaVO jerarquia =  jerarquias[j];
	     	TaxonVO[] jTaxones=jerarquia.getJerarquia();
	     	for(int i=0;i<jTaxones.length;i++){
		   		assertEquals(jTaxones[i].getId(),taxones[0].getId());
		   		assertEquals(jTaxones[i].getValorTax(),taxones[0].getValorTax());
	     	}
     	}
     }
     
     public void testobtenerJerarquia3() {
      	String id = "303";//cultura
      	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "es";
     	
      	ArrayList lJerarquia=new ArrayList();
      	
      	JerarquiaVO jerarquiaT0=new JerarquiaVO();
      	JerarquiaVO jerarquiaT1=new JerarquiaVO();
      	JerarquiaVO jerarquiaT2=new JerarquiaVO();
      	TaxonVO taxon = new TaxonVO();
     	TaxonVO taxon1 = new TaxonVO();
     	TaxonVO taxon2 = new TaxonVO();
     	TaxonVO taxon3 = new TaxonVO();
     	TaxonVO taxon4 = new TaxonVO();
     	TaxonVO taxon5 = new TaxonVO();
     	
     	taxon.setId("M70");
     	taxon.setValorTax("70 CONTENIDO DE LA EDUCACI�N");
     	taxon1.setId("M70.20");
     	taxon1.setValorTax("70.20 HUMANIDADES");
     	taxon2.setId("968");
     	taxon2.setValorTax("filosof�a");
     	taxon3.setId("3963");
     	taxon3.setValorTax("filosof�a del ser humano");
     	taxon4.setId("2207");
     	taxon4.setValorTax("dimensi�n cultural");
     	taxon5.setId("303");
     	taxon5.setValorTax("cultura");

      	TaxonVO[] taxones = new TaxonVO[6];
      	taxones[0] = taxon;
      	taxones[1] = taxon1;
      	taxones[2] = taxon2;
      	taxones[3] = taxon3;
      	taxones[4] = taxon4;
      	taxones[5] = taxon5;
      	jerarquiaT0.setJerarquia(taxones);
      	lJerarquia.add(jerarquiaT0);
   
      	
      	TaxonVO taxon01 = new TaxonVO();
     	TaxonVO taxon11 = new TaxonVO();
     	TaxonVO taxon21 = new TaxonVO();
     	TaxonVO taxon31 = new TaxonVO();
     	TaxonVO taxon41 = new TaxonVO();
     	
     	taxon01.setId("M70");
     	taxon01.setValorTax("70 CONTENIDO DE LA EDUCACI�N");
     	taxon11.setId("M70.20");
     	taxon11.setValorTax("70.20 HUMANIDADES");
     	taxon21.setId("968");
     	taxon21.setValorTax("filosof�a");
     	taxon31.setId("3962");
     	taxon31.setValorTax("filosof�a de la sociedad");
     	taxon41.setId("303");
     	taxon41.setValorTax("cultura");
     	
     	TaxonVO[] taxones1 = new TaxonVO[5];
      	taxones1[0] = taxon01;
      	taxones1[1] = taxon11;
      	taxones1[2] = taxon21;
      	taxones1[3] = taxon31;
      	taxones1[4] = taxon41;
      	jerarquiaT1.setJerarquia(taxones1);
      	lJerarquia.add(jerarquiaT1);
      	
      	TaxonVO taxon02 = new TaxonVO();
     	TaxonVO taxon12 = new TaxonVO();
     	
     	taxon02.setId("M100");
     	taxon02.setValorTax("100 CULTURA");
     	taxon12.setId("303");
     	taxon12.setValorTax("cultura");
     	TaxonVO[] taxones2=new TaxonVO[2];
     	taxones2[0]=taxon02;
     	taxones2[1]=taxon12;
     	jerarquiaT2.setJerarquia(taxones2);
     	lJerarquia.add(jerarquiaT2);
     	JerarquiaVO[] jerarquiaVO=(JerarquiaVO[])lJerarquia.toArray(new JerarquiaVO[lJerarquia.size()]);
     	
     	JerarquiaVO[] jerarquias =this.servicio.obtenerJerarquia(id, nomTesauro, idioma);
     	for(int j=0;j<jerarquias.length;j++){
     		TaxonVO[] jerarquia = jerarquias[j].getJerarquia();
	     	
	     	System.out.println("");
	       	
	      	for (int i = 0; i<jerarquia.length;i++){
	      		System.out.print(" - ");
	      		System.out.print(jerarquia[i].getId());
	      		System.out.print(" " + jerarquia[i].getValorTax());
	      		assertEquals(jerarquia[i].getId(),(jerarquiaVO[j].getJerarquia())[i].getId());
	      		assertEquals(jerarquia[i].getValorTax(),(jerarquiaVO[j].getJerarquia())[i].getValorTax());
	      	} 
     	}
      	System.out.println("El n�mero de jerarquias:"+jerarquias.length);
     	
     }
     
     public void testobtenerJerarquia4() {
       	String id = "652";//tecnolog�as de la informaci�n y la comunicaci�n
       	id = "2899";//h�bitat
       	//id = "944";//par�sito
       	id = "968";//filosof�a
     	//id = "";
        String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
       	String idioma = "es";
        for (int j=1;j<5164;j++){//5163
       		System.out.println("Estamos generando las ruta de: "+j);
       		JerarquiaVO[] jerarquias = this.servicio.obtenerJerarquia(Integer.toString(j), nomTesauro, idioma);
       		for(int l=0;l<jerarquias.length;l++){
       			TaxonVO[] jerarquia =jerarquias[l].getJerarquia();
	    		   	for (int i = 0; i<jerarquia.length;i++){
	    		   		System.out.print(" - ");
	    		   		System.out.print(jerarquia[i].getId());
	    		   		System.out.print(" " + jerarquia[i].getValorTax());
	    		   	} 
	    		   	System.out.println("");
	    	   }
           }	
      }
     
     public void testobtenerJerarquia5() {
		String id = "652";//tecnolog�as de la informaci�n y la comunicaci�n
		id = "2899";//h�bitat
		id = "968";//filosof�a
//		id = "944";//par�sito
//		id="5161";
//		id="2111";
//		id = "303";
  
		String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
		String idioma = "es";
    	
     	JerarquiaVO[] jerarquias =this.servicio.obtenerJerarquia(id, nomTesauro, idioma);
     	for(int j=0;j<jerarquias.length;j++){
		     	TaxonVO[] jerarquia = jerarquias[j].getJerarquia();
		     	System.out.println("");
			   	for (int i = 0; i<jerarquia.length;i++){
			   		System.out.print(" - ");
			   		System.out.print(jerarquia[i].getId());
			   		System.out.print(" " + jerarquia[i].getValorTax());
			   	} 
			   	System.out.println("");
     	}
}	
   
     
    /**
     *   TEST obtenerPrimerNivelTesauro
     *   TODO: Implementar el test para el metodo obtenerPrimerNivelTesauro del servicio SrvTesaurosServices.
     */
     public void testobtenerPrimerNivelTesauro() {
    	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
     	String idioma = "es";
     	
     	TaxonVO taxon1 = new TaxonVO();
    	TaxonVO taxon2 = new TaxonVO();
    	TaxonVO taxon3 = new TaxonVO();
    	TaxonVO taxon4 = new TaxonVO();
    	TaxonVO taxon5 = new TaxonVO();
    	taxon1.setId("M10");
    	taxon1.setValorTax("10 DESARROLLO INDIVIDUAL");
    	taxon2.setId("4898");
    	taxon2.setValorTax("documento base del t�tulo"); 
    	taxon3.setId("4735");
    	taxon3.setValorTax("mezcla sustractiva"); 
    	taxon4.setId("1194");
    	taxon4.setValorTax("tabaquismo");
    	taxon5.setId("562");
    	taxon5.setValorTax("zonas verdes");
    	
     	TaxonVO[] taxones = new TaxonVO[5];
     	taxones[0] = taxon1;
     	taxones[1] = taxon2;
     	taxones[2] = taxon3;
     	taxones[3] = taxon4;
     	taxones[4] = taxon5;
     	
    	TaxonVO[] primerNivel = this.servicio.obtenerPrimerNivelTesauro(nomTesauro, idioma);
    	assertEquals(primerNivel[0].getId(),taxones[0].getId());
     	assertEquals(primerNivel[0].getValorTax(),taxones[0].getValorTax());
     	assertEquals(primerNivel[99].getId(),taxones[1].getId());
     	assertEquals(primerNivel[99].getValorTax(),taxones[1].getValorTax());
     	assertEquals(primerNivel[199].getId(),taxones[2].getId());
     	assertEquals(primerNivel[199].getValorTax(),taxones[2].getValorTax());
    	assertEquals(primerNivel[299].getId(),taxones[3].getId());
     	assertEquals(primerNivel[299].getValorTax(),taxones[3].getValorTax());
     	assertEquals(primerNivel[330].getId(),taxones[4].getId());
     	assertEquals(primerNivel[330].getValorTax(),taxones[4].getValorTax());	
// todos    	
     	for (int i = 0; i<primerNivel.length;i++){
    		System.out.print(primerNivel[i].getId());
    		System.out.println(" " + primerNivel[i].getValorTax());
    	}
     	
     	System.out.println(primerNivel.length);
    }

    /**
     *   TEST obtenerTerminosRelacionadosPorTexto
     *   TODO: Implementar el test para el metodo obtenerTerminosRelacionadosPorTexto del servicio SrvTesaurosServices.
     */
     public void testobtenerTerminosRelacionadosPorTexto() {
     	String texto = "attitude";
      	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
      	String idioma = "en";
           	
      	TaxonVO taxon1 = new TaxonVO();
    	TaxonVO taxon2 = new TaxonVO();
    	TaxonVO taxon3 = new TaxonVO();
    	TaxonVO taxon4 = new TaxonVO();
    	TaxonVO taxon5 = new TaxonVO();
    	TaxonVO taxon6 = new TaxonVO();
    	TaxonVO taxon7 = new TaxonVO();
    	TaxonVO taxon8 = new TaxonVO();
    	
    	taxon6.setId("2208");
    	taxon6.setValorTax("cultural diversity");
    	taxon7.setId("2463");
    	taxon7.setValorTax("elements of the action");
    	taxon8.setId("4578");
    	taxon8.setValorTax("social psychology");
    	taxon1.setId("2209");
    	taxon1.setValorTax("Cultural relativism");
    	taxon2.setId("2562");
    	taxon2.setValorTax("ethnocentrism");
    	taxon3.setId("3137");
    	taxon3.setValorTax("interculturalism");
    	taxon4.setId("1654");
    	taxon4.setValorTax("attitude");
    	taxon5.setId("118");
    	taxon5.setValorTax("attitude");

     	TaxonVO[] taxones = new TaxonVO[8];
     	taxones[0] = taxon6;
     	taxones[1] = taxon7;
     	taxones[2] = taxon8;
     	taxones[3] = taxon1;
     	taxones[4] = taxon2;
     	taxones[5] = taxon3;
     	taxones[6] = taxon4;
     	taxones[7] = taxon5; 
      	
      	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorTexto(texto, nomTesauro, idioma);
      	for (int i = 0; i<relaciones.length;i++){
         	assertEquals(relaciones[i].getId(),taxones[i].getId());
         	assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
      		System.out.print(relaciones[i].getId());
      		System.out.println(" " + relaciones[i].getValorTax() );
      	}

    }
     
    public void testobtenerTerminosRelacionadosPorTexto2() {
      	String texto = "comprensi�n oral";
       	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
       	String idioma = "es";
            	
       	TaxonVO taxon1 = new TaxonVO();
     	TaxonVO taxon2 = new TaxonVO();
     	TaxonVO taxon3 = new TaxonVO();
       	
     	taxon1.setId("248");
     	taxon1.setValorTax("comprensi�n");
     	taxon2.setId("3863");
     	taxon2.setValorTax("aprendizaje de otras lenguas");
     	taxon3.setId("248");
     	taxon3.setValorTax("comprensi�n");

      	TaxonVO[] taxones = new TaxonVO[3];
      	taxones[0] = taxon1;
      	taxones[1] = taxon2;
      	taxones[2] = taxon3;

       	
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorTexto(texto, nomTesauro, idioma);
       	for (int i = 0; i<relaciones.length;i++){
         	assertEquals(relaciones[i].getId(),taxones[i].getId());
         	assertEquals(relaciones[i].getValorTax(),taxones[i].getValorTax());
       		System.out.print(relaciones[i].getId());
       		System.out.println(" " + relaciones[i].getValorTax() );
       	}
     }
    
    public void testobtenerTerminosRelacionadosPorTexto3() {
      	String texto = "lab";
       	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
       	String idioma = "es";
               	
       	TaxonVO[] relaciones = this.servicio.obtenerTerminosRelacionadosPorTexto(texto, nomTesauro, idioma);
       	for (int i = 0; i<relaciones.length;i++){
      		System.out.print(relaciones[i].getId());
       		System.out.println(" " + relaciones[i].getValorTax() );
       	}
     }

    /**
     *   TEST obtenerTerminosRelacionAsociativa
     *   TODO: Implementar el test para el metodo obtenerTerminosRelacionAsociativa del servicio SrvTesaurosServices.
     */
     public void testobtenerTerminosRelacionAsociativa() {
      	String id = "391";
    	
     	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
     	String idioma = "es";      	
      	
    	TaxonVO taxon2 = new TaxonVO();
    	TaxonVO taxon3 = new TaxonVO();
    	TaxonVO taxon4 = new TaxonVO();
    
    	taxon2.setId("276");
    	taxon2.setValorTax("consejo orientador");
    	taxon3.setId("386");
    	taxon3.setValorTax("educaci�n");
    	taxon4.setId("156");
    	taxon4.setValorTax("rama de estudio");

     	TaxonVO[] taxones = new TaxonVO[5];

     	taxones[0] = taxon2;
     	taxones[1] = taxon3;
     	taxones[2] = taxon4;    
     	
     	TaxonVO[] aociativas = this.servicio.obtenerTerminosRelacionAsociativa(id, nomTesauro, idioma);
     	for (int i = 0; i<aociativas.length;i++){
        	assertEquals(aociativas[i].getId(),taxones[i].getId());
         	assertEquals(aociativas[i].getValorTax(),taxones[i].getValorTax());
     		System.out.print(aociativas[i].getId());
     		System.out.println(" " + aociativas[i].getValorTax() );
     	}
    }

    /**
     *   TEST obtenerTerminosRelacionJerarquica
     *   TODO: Implementar el test para el metodo obtenerTerminosRelacionJerarquica del servicio SrvTesaurosServices.
     */
     public void testobtenerTerminosRelacionJerarquica() {
      	String id = "1029";//probabilidad
     	String nomTesauro = "ETB-LRE_MEC-CCAA_V.1.0";
     	String idioma = "es";
     	
     	TaxonVO taxon1 = new TaxonVO();
    	TaxonVO taxon2 = new TaxonVO();
    	TaxonVO taxon3 = new TaxonVO();
    	TaxonVO taxon4 = new TaxonVO();
    	TaxonVO taxon5 = new TaxonVO();
    	taxon1.setId("4237");
    	taxon1.setValorTax("aleatoriedad");
    	taxon2.setId("4131");
    	taxon2.setValorTax("c�lculo de probabilidades");
    	taxon3.setId("2574");
    	taxon3.setValorTax("frecuencia de un suceso");
    	taxon4.setId("2575");
    	taxon4.setValorTax("probabilidad de un suceso");
    	taxon5.setId("4239");
    	taxon5.setValorTax("variables aleatorias");
     	
     	TaxonVO[] taxones = new TaxonVO[5];
     	taxones[0] = taxon1;
     	taxones[1] = taxon2;
     	taxones[2] = taxon3;
     	taxones[3] = taxon4;
     	taxones[4] = taxon5;
    	
     	TaxonVO[] jerarquias = this.servicio.obtenerTerminosRelacionJerarquica(id, nomTesauro, idioma);
     	for (int i = 0; i<jerarquias.length;i++){
         	assertEquals(jerarquias[i].getId(),taxones[i].getId());
         	assertEquals(jerarquias[i].getValorTax(),taxones[i].getValorTax());
     		System.out.print(jerarquias[i].getId());
     		System.out.println(" " + jerarquias[i].getValorTax());
     	}
    }	
     
     public String testobtenerVocabName(){
    	SrvTesaurosServices tesauroServ = this.servicio;
		String vocabName=tesauroServ.obtenerVocabName("Competencia_LOM-ES", "es");
		System.out.println(vocabName);
		return vocabName;
     }
     public String testobtenerVocabName1(){
     	SrvTesaurosServices tesauroServ = this.servicio;
 		String vocabName=tesauroServ.obtenerVocabName("ETB-LRE_MEC-CCAA_V.1.0", "es");
 		System.out.println(vocabName);
 		return vocabName;
      }
     
     public String[] testobtenerVocabNames(){
    	 SrvTesaurosServices tesauroServ = this.servicio;
			String[] vocabs=new String[2];
			vocabs[0]="ETB-LRE_MEC-CCAA_V.1.0";
			vocabs[1]="Accesibilidad_LOM-ES";
			
			String[] vocabName=tesauroServ.obtenerVocabNames(vocabs, "es");
			for(int i=0;i<vocabName.length;i++){
				System.out.println(vocabName[i]);
			}
			return vocabName;
			
		}
}