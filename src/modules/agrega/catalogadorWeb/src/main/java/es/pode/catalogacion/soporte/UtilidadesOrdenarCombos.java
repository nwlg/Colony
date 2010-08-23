/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.catalogacion.soporte;

import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;

public class UtilidadesOrdenarCombos {

		//Metodo que ordena los combos con terminosvo
		public TerminoVO[] ordenarTerminosVO(TerminoVO[] terminos, String idioma)
		{
			
			///////////////////////////////////////
			TerminoVO[] terminosSinTildes = new TerminoVO[terminos.length];
	    	
	    	//eliminamos las tildes para poder hacer la comparación correctamente
	    	for (int k=0;k<terminos.length;k++){
	    		TerminoVO terminoSinTildes = new TerminoVO();
	    		String valorTer = terminos[k].getNomTermino();
	    		valorTer = valorTer.replace('á', 'a');
	    		valorTer = valorTer.replace('é', 'e');
	    		valorTer = valorTer.replace('í', 'i');
	    		valorTer = valorTer.replace('ó', 'o');
	    		valorTer = valorTer.replace('ú', 'u');
	    		valorTer = valorTer.replace('Á', 'A');
	    		valorTer = valorTer.replace('É', 'E');
	    		valorTer = valorTer.replace('Í', 'I');
	    		valorTer = valorTer.replace('Ó', 'O');
	    		valorTer = valorTer.replace('Ú', 'U');
	    		terminoSinTildes.setNomTermino(valorTer);
	    		terminoSinTildes.setIdTermino(terminos[k].getIdTermino());
	    		terminoSinTildes.setIdiomaTermino(terminos[k].getIdiomaTermino());
	    		terminosSinTildes[k]= terminoSinTildes;
	    	}
	    	
	    	for( int i=0;i<terminos.length-1;i++){                 
	    		for (int j=i+1;j<terminos.length;j++){
	    			String aux=null;
	    			String auxId=null;
	    			String aux2=null;
	    			String auxId2=null;
	    			
	    			String auxIdioma=null;
	    			String auxIdioma2=null;
	    			String valorTaxI = terminosSinTildes[i].getNomTermino();
	    			String valorTaxJ = terminosSinTildes[j].getNomTermino();
	    			
	    			//comparamos los texto sin tildes y ordenamos a la vez tanto el array con los taxones sin tildes
	    			//como el array con los taxones originales que sera el que vamos devolver
	    			if(valorTaxI.compareToIgnoreCase(valorTaxJ)>0){
	    				aux=terminosSinTildes[j].getNomTermino();
	    				terminosSinTildes[j].setNomTermino(terminosSinTildes[i].getNomTermino());
	    				terminosSinTildes[i].setNomTermino(aux);
	    				auxId=terminosSinTildes[j].getIdTermino();
	    				terminosSinTildes[j].setIdTermino(terminosSinTildes[i].getIdTermino());
	    				terminosSinTildes[i].setIdTermino(auxId);
	    				
	    				
	    				auxIdioma=terminosSinTildes[j].getIdiomaTermino();
	    				terminosSinTildes[j].setIdiomaTermino(terminosSinTildes[i].getIdiomaTermino());
	    				terminosSinTildes[i].setIdiomaTermino(auxIdioma);
	    				
	    				aux2=terminos[j].getNomTermino();
	    				terminos[j].setNomTermino(terminos[i].getNomTermino());
	    				terminos[i].setNomTermino(aux2);
	    				auxId2=terminos[j].getIdTermino();
	    				terminos[j].setIdTermino(terminos[i].getIdTermino());
	    				terminos[i].setIdTermino(auxId2);
	    				
	    				auxIdioma2=terminos[j].getIdiomaTermino();
	    				terminos[j].setIdiomaTermino(terminos[i].getIdiomaTermino());
	    				terminos[i].setIdiomaTermino(auxIdioma2);
	    			}	
	    		}
	    	}
	    	return terminos;
			
		}
		
		//Metodo que ordena los combos con vocabulariosvo
		public VocabularioVO[]  ordenarVocabulariosVO(VocabularioVO[]vocabulario) 
		{
			
			String idioma="";
			if(vocabulario.length>0)
				idioma=vocabulario[0].getIdioma();
	            
			for(int i=0; i < vocabulario.length; i++)
			{   
				for (int j= 0; j<vocabulario[i].getTerminos().length -1; j++){

			        for (int k= j+1; k<vocabulario[i].getTerminos().length; k++){
			        	
			             if (vocabulario[i].getTerminos()[j].getNomTermino().compareTo(vocabulario[i].getTerminos()[k].getNomTermino())>0 ){

			           		   TerminoVO auxTerm=new TerminoVO();

			                   String aux= vocabulario[i].getTerminos()[k].getNomTermino();
			                   String auxId=vocabulario[i].getTerminos()[k].getIdTermino();
			                   auxTerm.setIdiomaTermino(idioma);
			                   auxTerm.setIdTermino(auxId);
			                   auxTerm.setNomTermino(aux);
			                               
			                   vocabulario[i].getTerminos()[k]=vocabulario[i].getTerminos()[j];
			                   vocabulario[i].getTerminos()[j]=auxTerm;          
			             }
			        }
			    }
			}
			return vocabulario;
		}
	
	

}


