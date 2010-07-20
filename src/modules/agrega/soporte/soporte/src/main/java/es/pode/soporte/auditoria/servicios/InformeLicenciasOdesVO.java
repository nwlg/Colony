/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * InformeLicenciasOdesVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;


/**
 * Almacena informaciÃ³n de los odes,  publicados en un rango de
 *                         fechas, que hay por cada una de las licencias
 */
public class InformeLicenciasOdesVO  implements java.io.Serializable {
    private java.lang.String licencia;

    private int numOdes;

    public InformeLicenciasOdesVO() {
    }

    public InformeLicenciasOdesVO(
           java.lang.String licencia,
           int numOdes) {
           this.licencia = licencia;
           this.numOdes = numOdes;
    }


    /**
     * Gets the licencia value for this InformeLicenciasOdesVO.
     * 
     * @return licencia
     */
    public java.lang.String getLicencia() {
        return licencia;
    }


    /**
     * Sets the licencia value for this InformeLicenciasOdesVO.
     * 
     * @param licencia
     */
    public void setLicencia(java.lang.String licencia) {
        this.licencia = licencia;
    }


    /**
     * Gets the numOdes value for this InformeLicenciasOdesVO.
     * 
     * @return numOdes
     */
    public int getNumOdes() {
        return numOdes;
    }


    /**
     * Sets the numOdes value for this InformeLicenciasOdesVO.
     * 
     * @param numOdes
     */
    public void setNumOdes(int numOdes) {
        this.numOdes = numOdes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformeLicenciasOdesVO)) return false;
        InformeLicenciasOdesVO other = (InformeLicenciasOdesVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.licencia==null && other.getLicencia()==null) || 
             (this.licencia!=null &&
              this.licencia.equals(other.getLicencia()))) &&
            this.numOdes == other.getNumOdes();
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
        if (getLicencia() != null) {
            _hashCode += getLicencia().hashCode();
        }
        _hashCode += getNumOdes();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformeLicenciasOdesVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "InformeLicenciasOdesVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "licencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numOdes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "numOdes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
