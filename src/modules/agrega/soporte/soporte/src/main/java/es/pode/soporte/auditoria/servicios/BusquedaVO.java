/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * BusquedaVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;


/**
 * InformaciÃ³n de los tÃ©rminos buscados, se almacena el tÃ©rmino, el
 * usuario, el Ã¡mbito (local, red o dri) y la fecha en la que ha
 *                         sido buscado
 */
public class BusquedaVO  implements java.io.Serializable {
    private java.lang.String terminoBuscado;

    private java.lang.String usuario;

    /* avanzada o normal */
    private java.lang.String tipo_busqueda;

    private java.util.Calendar fecha;

    private java.lang.Long id;

    /* local o federada */
    private java.lang.String ambito_busqueda;

    /* normal, tesauro y areaCurricular */
    private java.lang.String tipo;

    public BusquedaVO() {
    }

    public BusquedaVO(
           java.lang.String terminoBuscado,
           java.lang.String usuario,
           java.lang.String tipo_busqueda,
           java.util.Calendar fecha,
           java.lang.Long id,
           java.lang.String ambito_busqueda,
           java.lang.String tipo) {
           this.terminoBuscado = terminoBuscado;
           this.usuario = usuario;
           this.tipo_busqueda = tipo_busqueda;
           this.fecha = fecha;
           this.id = id;
           this.ambito_busqueda = ambito_busqueda;
           this.tipo = tipo;
    }


    /**
     * Gets the terminoBuscado value for this BusquedaVO.
     * 
     * @return terminoBuscado
     */
    public java.lang.String getTerminoBuscado() {
        return terminoBuscado;
    }


    /**
     * Sets the terminoBuscado value for this BusquedaVO.
     * 
     * @param terminoBuscado
     */
    public void setTerminoBuscado(java.lang.String terminoBuscado) {
        this.terminoBuscado = terminoBuscado;
    }


    /**
     * Gets the usuario value for this BusquedaVO.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this BusquedaVO.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the tipo_busqueda value for this BusquedaVO.
     * 
     * @return tipo_busqueda   * avanzada o normal
     */
    public java.lang.String getTipo_busqueda() {
        return tipo_busqueda;
    }


    /**
     * Sets the tipo_busqueda value for this BusquedaVO.
     * 
     * @param tipo_busqueda   * avanzada o normal
     */
    public void setTipo_busqueda(java.lang.String tipo_busqueda) {
        this.tipo_busqueda = tipo_busqueda;
    }


    /**
     * Gets the fecha value for this BusquedaVO.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this BusquedaVO.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the id value for this BusquedaVO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this BusquedaVO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the ambito_busqueda value for this BusquedaVO.
     * 
     * @return ambito_busqueda   * local o federada
     */
    public java.lang.String getAmbito_busqueda() {
        return ambito_busqueda;
    }


    /**
     * Sets the ambito_busqueda value for this BusquedaVO.
     * 
     * @param ambito_busqueda   * local o federada
     */
    public void setAmbito_busqueda(java.lang.String ambito_busqueda) {
        this.ambito_busqueda = ambito_busqueda;
    }


    /**
     * Gets the tipo value for this BusquedaVO.
     * 
     * @return tipo   * normal, tesauro y areaCurricular
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this BusquedaVO.
     * 
     * @param tipo   * normal, tesauro y areaCurricular
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusquedaVO)) return false;
        BusquedaVO other = (BusquedaVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.terminoBuscado==null && other.getTerminoBuscado()==null) || 
             (this.terminoBuscado!=null &&
              this.terminoBuscado.equals(other.getTerminoBuscado()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.tipo_busqueda==null && other.getTipo_busqueda()==null) || 
             (this.tipo_busqueda!=null &&
              this.tipo_busqueda.equals(other.getTipo_busqueda()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ambito_busqueda==null && other.getAmbito_busqueda()==null) || 
             (this.ambito_busqueda!=null &&
              this.ambito_busqueda.equals(other.getAmbito_busqueda()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo())));
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
        if (getTerminoBuscado() != null) {
            _hashCode += getTerminoBuscado().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getTipo_busqueda() != null) {
            _hashCode += getTipo_busqueda().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getAmbito_busqueda() != null) {
            _hashCode += getAmbito_busqueda().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusquedaVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "BusquedaVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminoBuscado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "terminoBuscado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_busqueda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "tipo_busqueda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ambito_busqueda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "ambito_busqueda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
