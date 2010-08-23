/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.validador.negocio.dominio;

import org.xml.sax.InputSource;

public interface ManifestEntityDao {

	public final static int TRANSFORM_VALIDAVO = 1;
	public final static int TRANSFORM_NONE = 0;
	
	public void setBaseDirectory(String dirBase);
	
	public java.lang.Boolean buscarManifest(java.lang.String rutaManifest);

    /**
     * @throws Exception 
     * @see es.pode.validador.negocio.dominio.ManifestEntity#obtenerParseoSimple(java.lang.String, String tipoOde)
     */
    public java.lang.Boolean obtenerParseoSimple(java.lang.String rutaManifest, String tipoOde) throws Exception;

    /**
     * @throws Exception 
     * @see es.pode.validador.negocio.dominio.ManifestEntity#obtenerParseoConEsquemasSinLomes(java.lang.String, String tipoOde)
     */
    public java.lang.Boolean obtenerParseoConEsquemasSinLomes(String manifestAux, String tipoOde) throws Exception;
    
    /**
     * @throws Exception 
     * @see es.pode.validador.negocio.dominio.ManifestEntity#obtenerParseoConEsquemas(java.lang.String, String tipoOde)
     */
    public java.lang.Boolean obtenerParseoConEsquemas(String manifestAux, String tipoOde) throws Exception;
    /**
     * @see es.pode.validador.negocio.dominio.ManifestEntity#crearListaFicherosManifest(java.lang.String)
     */
    public void crearListaFicherosManifest(java.lang.String rutaManifest);

    /**
     * @see es.pode.validador.negocio.dominio.ManifestEntity#chequearContenido(org.w3c.dom.Document, java.lang.String)
     */
    public java.lang.Boolean chequearContenido(org.w3c.dom.Node arbolDoc, java.lang.String rutaManifest);
    

    /**
     * @see es.pode.validador.negocio.dominio.ManifestEntity#chequearHref(java.lang.String)
     */
    public java.lang.Boolean chequearHref(java.lang.String nomContenidos);

    /**
     * @throws Exception 
     * @see es.pode.validador.negocio.dominio.ManifestEntity#chequearLocalURL(java.lang.String)
     */
    public java.lang.Boolean chequearLocalURL(java.lang.String nomContenidos) throws Exception;

    /**
     * @see es.pode.validador.negocio.dominio.ManifestEntity#chequearExcesoEquipaje()
     */
    public String chequearExcesoEquipaje();
    
	////////////////////////////////////
	public es.pode.validador.negocio.servicio.ValidaVO toValidaVO(es.pode.validador.negocio.dominio.ManifestEntityDaoImpl entity);

    public void toValidaVOCollection(java.util.Collection entities);

    public es.pode.validador.negocio.dominio.ManifestEntityDaoImpl fromValidaVO(es.pode.validador.negocio.servicio.ValidaVO vo);
    
    public void fromValidaVO(es.pode.validador.negocio.servicio.ValidaVO vo, es.pode.validador.negocio.dominio.ManifestEntityDaoImpl entity);    
    
    //nuevos
    public boolean parsearLomes (InputSource lomes,String nombreFichero) throws Exception;
    
    public Boolean tieneLomes(org.w3c.dom.Node arbolDoc) throws Exception;
    
    public Boolean validarTodosLomes();
    
    public boolean buscarLomes (org.w3c.dom.Node iTestSubjectNode,boolean soloLocation) throws Exception;

    
    
}
