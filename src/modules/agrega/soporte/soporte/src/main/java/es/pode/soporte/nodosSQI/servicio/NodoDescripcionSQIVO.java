/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * NodoDescripcionSQIVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.nodosSQI.servicio;


/**
 * Describe un nodo de tipo SQI
 */
public class NodoDescripcionSQIVO  implements java.io.Serializable {
    /* La descripcion o "nombre" del nodo */
    private java.lang.String descripcionNodo;

    /* El identificador del nodo */
    private java.lang.Long id;

    /* El nombre del nodo de tipo SQI */
    private java.lang.String nombreNodo;

    public NodoDescripcionSQIVO() {
    }

    public NodoDescripcionSQIVO(
           java.lang.String descripcionNodo,
           java.lang.Long id,
           java.lang.String nombreNodo) {
           this.descripcionNodo = descripcionNodo;
           this.id = id;
           this.nombreNodo = nombreNodo;
    }


    /**
     * Gets the descripcionNodo value for this NodoDescripcionSQIVO.
     * 
     * @return descripcionNodo   * La descripcion o "nombre" del nodo
     */
    public java.lang.String getDescripcionNodo() {
        return descripcionNodo;
    }


    /**
     * Sets the descripcionNodo value for this NodoDescripcionSQIVO.
     * 
     * @param descripcionNodo   * La descripcion o "nombre" del nodo
     */
    public void setDescripcionNodo(java.lang.String descripcionNodo) {
        this.descripcionNodo = descripcionNodo;
    }


    /**
     * Gets the id value for this NodoDescripcionSQIVO.
     * 
     * @return id   * El identificador del nodo
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this NodoDescripcionSQIVO.
     * 
     * @param id   * El identificador del nodo
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the nombreNodo value for this NodoDescripcionSQIVO.
     * 
     * @return nombreNodo   * El nombre del nodo de tipo SQI
     */
    public java.lang.String getNombreNodo() {
        return nombreNodo;
    }


    /**
     * Sets the nombreNodo value for this NodoDescripcionSQIVO.
     * 
     * @param nombreNodo   * El nombre del nodo de tipo SQI
     */
    public void setNombreNodo(java.lang.String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NodoDescripcionSQIVO)) return false;
        NodoDescripcionSQIVO other = (NodoDescripcionSQIVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcionNodo==null && other.getDescripcionNodo()==null) || 
             (this.descripcionNodo!=null &&
              this.descripcionNodo.equals(other.getDescripcionNodo()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nombreNodo==null && other.getNombreNodo()==null) || 
             (this.nombreNodo!=null &&
              this.nombreNodo.equals(other.getNombreNodo())));
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
        if (getDescripcionNodo() != null) {
            _hashCode += getDescripcionNodo().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNombreNodo() != null) {
            _hashCode += getNombreNodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NodoDescripcionSQIVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "NodoDescripcionSQIVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionNodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "descripcionNodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreNodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "nombreNodo"));
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
