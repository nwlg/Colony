/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * ParamSimpleVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;


/**
 * Este VO alberga los parametros aceptados en la busqueda simple.
 */
public class ParamSimpleVO  implements java.io.Serializable {
    /* Lista de palabras clave por las que buscar */
    private java.lang.String palabrasClave;

    /* Numero maximo de resultados que se quieren devolver */
    private java.lang.Integer numeroResultados;

    private java.lang.String idiomaNavegacion;

    /* Parametro de idioma de busqueda traducido al idioma de
     *                                 navegacion. */
    private java.lang.String idiomaBusqueda;

    public ParamSimpleVO() {
    }

    public ParamSimpleVO(
           java.lang.String palabrasClave,
           java.lang.Integer numeroResultados,
           java.lang.String idiomaNavegacion,
           java.lang.String idiomaBusqueda) {
           this.palabrasClave = palabrasClave;
           this.numeroResultados = numeroResultados;
           this.idiomaNavegacion = idiomaNavegacion;
           this.idiomaBusqueda = idiomaBusqueda;
    }


    /**
     * Gets the palabrasClave value for this ParamSimpleVO.
     * 
     * @return palabrasClave   * Lista de palabras clave por las que buscar
     */
    public java.lang.String getPalabrasClave() {
        return palabrasClave;
    }


    /**
     * Sets the palabrasClave value for this ParamSimpleVO.
     * 
     * @param palabrasClave   * Lista de palabras clave por las que buscar
     */
    public void setPalabrasClave(java.lang.String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }


    /**
     * Gets the numeroResultados value for this ParamSimpleVO.
     * 
     * @return numeroResultados   * Numero maximo de resultados que se quieren devolver
     */
    public java.lang.Integer getNumeroResultados() {
        return numeroResultados;
    }


    /**
     * Sets the numeroResultados value for this ParamSimpleVO.
     * 
     * @param numeroResultados   * Numero maximo de resultados que se quieren devolver
     */
    public void setNumeroResultados(java.lang.Integer numeroResultados) {
        this.numeroResultados = numeroResultados;
    }


    /**
     * Gets the idiomaNavegacion value for this ParamSimpleVO.
     * 
     * @return idiomaNavegacion
     */
    public java.lang.String getIdiomaNavegacion() {
        return idiomaNavegacion;
    }


    /**
     * Sets the idiomaNavegacion value for this ParamSimpleVO.
     * 
     * @param idiomaNavegacion
     */
    public void setIdiomaNavegacion(java.lang.String idiomaNavegacion) {
        this.idiomaNavegacion = idiomaNavegacion;
    }


    /**
     * Gets the idiomaBusqueda value for this ParamSimpleVO.
     * 
     * @return idiomaBusqueda   * Parametro de idioma de busqueda traducido al idioma de
     *                                 navegacion.
     */
    public java.lang.String getIdiomaBusqueda() {
        return idiomaBusqueda;
    }


    /**
     * Sets the idiomaBusqueda value for this ParamSimpleVO.
     * 
     * @param idiomaBusqueda   * Parametro de idioma de busqueda traducido al idioma de
     *                                 navegacion.
     */
    public void setIdiomaBusqueda(java.lang.String idiomaBusqueda) {
        this.idiomaBusqueda = idiomaBusqueda;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParamSimpleVO)) return false;
        ParamSimpleVO other = (ParamSimpleVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.palabrasClave==null && other.getPalabrasClave()==null) || 
             (this.palabrasClave!=null &&
              this.palabrasClave.equals(other.getPalabrasClave()))) &&
            ((this.numeroResultados==null && other.getNumeroResultados()==null) || 
             (this.numeroResultados!=null &&
              this.numeroResultados.equals(other.getNumeroResultados()))) &&
            ((this.idiomaNavegacion==null && other.getIdiomaNavegacion()==null) || 
             (this.idiomaNavegacion!=null &&
              this.idiomaNavegacion.equals(other.getIdiomaNavegacion()))) &&
            ((this.idiomaBusqueda==null && other.getIdiomaBusqueda()==null) || 
             (this.idiomaBusqueda!=null &&
              this.idiomaBusqueda.equals(other.getIdiomaBusqueda())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPalabrasClave() != null) {
            _hashCode += getPalabrasClave().hashCode();
        }
        if (getNumeroResultados() != null) {
            _hashCode += getNumeroResultados().hashCode();
        }
        if (getIdiomaNavegacion() != null) {
            _hashCode += getIdiomaNavegacion().hashCode();
        }
        if (getIdiomaBusqueda() != null) {
            _hashCode += getIdiomaBusqueda().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParamSimpleVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamSimpleVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("palabrasClave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "palabrasClave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroResultados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "numeroResultados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomaNavegacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idiomaNavegacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomaBusqueda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idiomaBusqueda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
