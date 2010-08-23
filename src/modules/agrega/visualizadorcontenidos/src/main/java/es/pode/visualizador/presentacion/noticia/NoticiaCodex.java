/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.visualizador.presentacion.noticia;

import es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO;

public class NoticiaCodex {
	 private java.lang.String titulo;

	    /* Contenido de la noticia. */
	    private java.lang.String resumen;

	    /* ID de la noticia. */
	    private java.lang.Long id;

	    /* Fecha de publicacion de la noticia. */
	    private java.util.Calendar fechaPublicacion;

	    /* URL de la imagen de la noticia. */
	    private java.lang.String URLImagen;

	    /* Alineamiento de la imagen. */
	    private java.lang.Integer alineamientoImg;

	    /* Contenido de la noticia. */
	    private java.lang.String cuerpo;

	    private java.lang.String categoria;

	    /* Para poder acceder la categoria codificado en la forma de URL bonito*/
	    private java.lang.String categoriaCodex;

	    /* Para poder acceder al titulo codificado en la forma de URL bonito*/
	    private String  tituloCodex;
	    
	    private Long idCategoria;
	    
	    

		public Long getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(Long idCategoria) {
			this.idCategoria = idCategoria;
		}

		public String getTituloCodex() {
			return tituloCodex;
		}

		public void setTituloCodex(String tituloCodex) {
			this.tituloCodex = tituloCodex;
		}

		public java.lang.Integer getAlineamientoImg() {
			return alineamientoImg;
		}

		public void setAlineamientoImg(java.lang.Integer alineamientoImg) {
			this.alineamientoImg = alineamientoImg;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public java.lang.String getCuerpo() {
			return cuerpo;
		}

		public void setCuerpo(java.lang.String cuerpo) {
			this.cuerpo = cuerpo;
		}

		public java.util.Calendar getFechaPublicacion() {
			return fechaPublicacion;
		}

		public void setFechaPublicacion(java.util.Calendar fechaPublicacion) {
			this.fechaPublicacion = fechaPublicacion;
		}

		public java.lang.Long getId() {
			return id;
		}

		public void setId(java.lang.Long id) {
			this.id = id;
		}

		public java.lang.String getResumen() {
			return resumen;
		}

		public void setResumen(java.lang.String resumen) {
			this.resumen = resumen;
		}

		public java.lang.String getTitulo() {
			return titulo;
		}

		public void setTitulo(java.lang.String titulo) {
			this.titulo = titulo;
		}

		public java.lang.String getURLImagen() {
			return URLImagen;
		}

		public void setURLImagen(java.lang.String imagen) {
			URLImagen = imagen;
		}
		
		public java.lang.String getCategoriaCodex() {
			return categoriaCodex;
		}

		public void setCategoriaCodex(java.lang.String categoriaCodex) {
			this.categoriaCodex = categoriaCodex;
		}


		public static NoticiaCodex mapToCodex(NoticiaTraducidaVO tr) {
			if (tr==null){
				return null;
			}
			NoticiaCodex tr_codex = new NoticiaCodex();
				tr_codex.setId(tr.getIdNoticia());
				//tr_codex.setActiva(tr.getActiva());
				tr_codex.setAlineamientoImg(tr.getAlineamientoImg());
				tr_codex.setIdCategoria(tr.getIdCategoria());
				String categoriaCodex="";
				categoriaCodex=tr.getCategoria().replaceAll(" ", "/");
				categoriaCodex=categoriaCodex.replaceAll("�", "a");//Para que no haya t�ldes
				categoriaCodex=categoriaCodex.replaceAll("�", "e");
				categoriaCodex=categoriaCodex.replaceAll("�", "i");
				categoriaCodex=categoriaCodex.replaceAll("�", "o");
				categoriaCodex=categoriaCodex.replaceAll("�", "u");
				categoriaCodex=categoriaCodex.replaceAll("�", "A");
				categoriaCodex=categoriaCodex.replaceAll("�", "E");
				categoriaCodex=categoriaCodex.replaceAll("�", "I");
				categoriaCodex=categoriaCodex.replaceAll("�", "O");
				categoriaCodex=categoriaCodex.replaceAll("�", "U");
				tr_codex.setCategoriaCodex(categoriaCodex);
				tr_codex.setCategoria(tr.getCategoria());
				
				String tituloCodex="";
				tituloCodex=tr.getTitulo().replaceAll(" ", "/");
				tituloCodex=tituloCodex.replaceAll("�", "a");//Para que no haya t�ldes
				tituloCodex=tituloCodex.replaceAll("�", "e");
				tituloCodex=tituloCodex.replaceAll("�", "i");
				tituloCodex=tituloCodex.replaceAll("�", "o");
				tituloCodex=tituloCodex.replaceAll("�", "u");
				tituloCodex=tituloCodex.replaceAll("�", "A");
				tituloCodex=tituloCodex.replaceAll("�", "E");
				tituloCodex=tituloCodex.replaceAll("�", "I");
				tituloCodex=tituloCodex.replaceAll("�", "O");
				tituloCodex=tituloCodex.replaceAll("�", "U");
				tr_codex.setTituloCodex(tituloCodex);
				tr_codex.setCuerpo(tr.getCuerpo());
				tr_codex.setFechaPublicacion(tr.getFechaPublicacion());
				tr_codex.setResumen(tr.getResumen());
				tr_codex.setTitulo(tr.getTitulo());
				tr_codex.setURLImagen(tr.getURLImagen());
				return tr_codex;

		}
		
		public static NoticiaCodex[] mapToCodexArray(NoticiaTraducidaVO[] trArray){
			if(trArray!=null && trArray.length>0){
				NoticiaCodex[] tr_codexArray=new NoticiaCodex[trArray.length];
				for(int i=0;i<trArray.length;i++){
					NoticiaCodex tr_codex=mapToCodex(trArray[i]);
					tr_codexArray[i]=tr_codex;		
				}
				return tr_codexArray;
			}
			return new NoticiaCodex[0];
		}
}
