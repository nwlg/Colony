/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * InformeMasPesadosVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;

public class InformeMasPesadosVO  implements java.io.Serializable {
    private java.lang.String tituloOde;

    private long tamanio;

    public InformeMasPesadosVO() {
    }

    public InformeMasPesadosVO(
           java.lang.String tituloOde,
           long tamanio) {
           this.tituloOde = tituloOde;
           this.tamanio = tamanio;
    }


    /**
     * Gets the tituloOde value for this InformeMasPesadosVO.
     * 
     * @return tituloOde
     */
    public java.lang.String getTituloOde() {
        return tituloOde;
    }


    /**
     * Sets the tituloOde value for this InformeMasPesadosVO.
     * 
     * @param tituloOde
     */
    public void setTituloOde(java.lang.String tituloOde) {
        this.tituloOde = tituloOde;
    }


    /**
     * Gets the tamanio value for this InformeMasPesadosVO.
     * 
     * @return tamanio
     */
    public long getTamanio() {
        return tamanio;
    }


    /**
     * Sets the tamanio value for this InformeMasPesadosVO.
     * 
     * @param tamanio
     */
    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformeMasPesadosVO)) return false;
        InformeMasPesadosVO other = (InformeMasPesadosVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tituloOde==null && other.getTituloOde()==null) || 
             (this.tituloOde!=null &&
              this.tituloOde.equals(other.getTituloOde()))) &&
            this.tamanio == other.getTamanio();
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
        if (getTituloOde() != null) {
            _hashCode += getTituloOde().hashCode();
        }
        _hashCode += new Long(getTamanio()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformeMasPesadosVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "InformeMasPesadosVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tituloOde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "tituloOde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamanio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "tamanio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
