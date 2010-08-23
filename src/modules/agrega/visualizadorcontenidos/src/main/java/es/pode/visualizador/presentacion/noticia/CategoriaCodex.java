/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.visualizador.presentacion.noticia;

import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaTraducidaVO;




public class CategoriaCodex {	
	
	 /* Nombre de la categoria. */
    private java.lang.String nombreCategoria;

    /* ID de la categoria. */
    private java.lang.Long idCategoriaNoticia;

    /* ID de la categoria en el idioma correspondiente. */
    private java.lang.Long idCategoriaIdiomaNoticia;
    
    /* Idioma de la categoria. */
    private java.lang.String idioma;
    
    /*
     * Para poder tener disponible el t�tulo codificado al estilo URL bonito
     */
    private String nombreCodex;

	public java.lang.Long getIdCategoriaNoticia() {
		return idCategoriaNoticia;
	}

	public void setIdCategoriaNoticia(java.lang.Long idCategoriaNoticia) {
		this.idCategoriaNoticia = idCategoriaNoticia;
	}
	
	public java.lang.Long getIdCategoriaIdiomaNoticia() {
		return idCategoriaIdiomaNoticia;
	}

	public void setIdCategoriaIdiomaNoticia(java.lang.Long idCategoriaIdiomaNoticia) {
		this.idCategoriaIdiomaNoticia = idCategoriaIdiomaNoticia;
	}

	public java.lang.String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(java.lang.String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	public java.lang.String getIdioma() 
	{
		return idioma;
	}
	public void setIdioma(java.lang.String idioma) {
		this.idioma = idioma;
	}
	

	public String getNombreCodex() {
		return nombreCodex;
	}

	public void setNombreCodex(String nombreCodex) {
		this.nombreCodex = nombreCodex;
	}
	
	
	public static CategoriaCodex mapToCodex(CategoriaNoticiaTraducidaVO tr) {
		if(tr==null){
			return null;
		}
		CategoriaCodex tr_codex = new CategoriaCodex();

		tr_codex.setIdCategoriaNoticia(tr.getIdCategoriaNoticia());
		tr_codex.setIdCategoriaIdiomaNoticia(tr.getIdCategoriaIdiomaNoticia());
		tr_codex.setIdioma(tr.getIdioma());
		tr_codex.setNombreCategoria(tr.getNombreCategoria());			
		String nombreCodex="";
		nombreCodex=tr.getNombreCategoria().replaceAll(" ", "/");
		nombreCodex=nombreCodex.replaceAll("�", "a");//Para que no haya t�ldes
		nombreCodex=nombreCodex.replaceAll("�", "e");
		nombreCodex=nombreCodex.replaceAll("�", "i");
		nombreCodex=nombreCodex.replaceAll("�", "o");
		nombreCodex=nombreCodex.replaceAll("�", "u");
		nombreCodex=nombreCodex.replaceAll("�", "A");
		nombreCodex=nombreCodex.replaceAll("�", "E");
		nombreCodex=nombreCodex.replaceAll("�", "I");
		nombreCodex=nombreCodex.replaceAll("�", "O");
		nombreCodex=nombreCodex.replaceAll("�", "U");
		tr_codex.setNombreCodex(nombreCodex);
		return tr_codex;

	}
}
