/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * ParamPeriodoRepositorioVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;


/**
 * Este value object contiene los parametros de consulta de un
 *                         periodo de tiempo sobre el repositorio.
 */
public class ParamPeriodoRepositorioVO  implements java.io.Serializable {
    /* Fecha desde del periodo de tiempo en el que se esta interesado. */
    private java.util.Calendar desde;

    /* Fecha hasta del periodo de tiempo en el que estamos interesados. */
    private java.util.Calendar hasta;

    public ParamPeriodoRepositorioVO() {
    }

    public ParamPeriodoRepositorioVO(
           java.util.Calendar desde,
           java.util.Calendar hasta) {
           this.desde = desde;
           this.hasta = hasta;
    }


    /**
     * Gets the desde value for this ParamPeriodoRepositorioVO.
     * 
     * @return desde   * Fecha desde del periodo de tiempo en el que se esta interesado.
     */
    public java.util.Calendar getDesde() {
        return desde;
    }


    /**
     * Sets the desde value for this ParamPeriodoRepositorioVO.
     * 
     * @param desde   * Fecha desde del periodo de tiempo en el que se esta interesado.
     */
    public void setDesde(java.util.Calendar desde) {
        this.desde = desde;
    }


    /**
     * Gets the hasta value for this ParamPeriodoRepositorioVO.
     * 
     * @return hasta   * Fecha hasta del periodo de tiempo en el que estamos interesados.
     */
    public java.util.Calendar getHasta() {
        return hasta;
    }


    /**
     * Sets the hasta value for this ParamPeriodoRepositorioVO.
     * 
     * @param hasta   * Fecha hasta del periodo de tiempo en el que estamos interesados.
     */
    public void setHasta(java.util.Calendar hasta) {
        this.hasta = hasta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParamPeriodoRepositorioVO)) return false;
        ParamPeriodoRepositorioVO other = (ParamPeriodoRepositorioVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.desde==null && other.getDesde()==null) || 
             (this.desde!=null &&
              this.desde.equals(other.getDesde()))) &&
            ((this.hasta==null && other.getHasta()==null) || 
             (this.hasta!=null &&
              this.hasta.equals(other.getHasta())));
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
        if (getDesde() != null) {
            _hashCode += getDesde().hashCode();
        }
        if (getHasta() != null) {
            _hashCode += getHasta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParamPeriodoRepositorioVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamPeriodoRepositorioVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "desde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "hasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
