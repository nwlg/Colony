/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

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
     * Para poder tener disponible el título codificado al estilo URL bonito
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
		nombreCodex=nombreCodex.replaceAll("á", "a");//Para que no haya tíldes
		nombreCodex=nombreCodex.replaceAll("é", "e");
		nombreCodex=nombreCodex.replaceAll("í", "i");
		nombreCodex=nombreCodex.replaceAll("ó", "o");
		nombreCodex=nombreCodex.replaceAll("ú", "u");
		nombreCodex=nombreCodex.replaceAll("Á", "A");
		nombreCodex=nombreCodex.replaceAll("É", "E");
		nombreCodex=nombreCodex.replaceAll("Í", "I");
		nombreCodex=nombreCodex.replaceAll("Ó", "O");
		nombreCodex=nombreCodex.replaceAll("Ú", "U");
		tr_codex.setNombreCodex(nombreCodex);
		return tr_codex;

	}
}
