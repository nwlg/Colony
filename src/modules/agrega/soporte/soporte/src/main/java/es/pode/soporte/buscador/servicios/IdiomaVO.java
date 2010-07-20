/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * IdiomaVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;

public class IdiomaVO  implements java.io.Serializable {
    private java.lang.String nombre;

    private java.lang.String idIdioma;

    private es.pode.soporte.buscador.servicios.LocalizacionIdiomaVO[] idiomasBuscables;

    public IdiomaVO() {
    }

    public IdiomaVO(
           java.lang.String nombre,
           java.lang.String idIdioma,
           es.pode.soporte.buscador.servicios.LocalizacionIdiomaVO[] idiomasBuscables) {
           this.nombre = nombre;
           this.idIdioma = idIdioma;
           this.idiomasBuscables = idiomasBuscables;
    }


    /**
     * Gets the nombre value for this IdiomaVO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this IdiomaVO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the idIdioma value for this IdiomaVO.
     * 
     * @return idIdioma
     */
    public java.lang.String getIdIdioma() {
        return idIdioma;
    }


    /**
     * Sets the idIdioma value for this IdiomaVO.
     * 
     * @param idIdioma
     */
    public void setIdIdioma(java.lang.String idIdioma) {
        this.idIdioma = idIdioma;
    }


    /**
     * Gets the idiomasBuscables value for this IdiomaVO.
     * 
     * @return idiomasBuscables
     */
    public es.pode.soporte.buscador.servicios.LocalizacionIdiomaVO[] getIdiomasBuscables() {
        return idiomasBuscables;
    }


    /**
     * Sets the idiomasBuscables value for this IdiomaVO.
     * 
     * @param idiomasBuscables
     */
    public void setIdiomasBuscables(es.pode.soporte.buscador.servicios.LocalizacionIdiomaVO[] idiomasBuscables) {
        this.idiomasBuscables = idiomasBuscables;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdiomaVO)) return false;
        IdiomaVO other = (IdiomaVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.idIdioma==null && other.getIdIdioma()==null) || 
             (this.idIdioma!=null &&
              this.idIdioma.equals(other.getIdIdioma()))) &&
            ((this.idiomasBuscables==null && other.getIdiomasBuscables()==null) || 
             (this.idiomasBuscables!=null &&
              java.util.Arrays.equals(this.idiomasBuscables, other.getIdiomasBuscables())));
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
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getIdIdioma() != null) {
            _hashCode += getIdIdioma().hashCode();
        }
        if (getIdiomasBuscables() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdiomasBuscables());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdiomasBuscables(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdiomaVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "IdiomaVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIdioma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idIdioma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomasBuscables");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idiomasBuscables"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "LocalizacionIdiomaVO"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
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
