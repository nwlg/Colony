/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * ParametrosInformeVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;


/**
 * VO con todos los posibles parÃ¡metros que se van a pasar a los
 *                         servicios para obtener los informes
 */
public class ParametrosInformeVO  implements java.io.Serializable {
    /* Fecha de inicio del informe */
    private java.util.Calendar fechaDesde;

    private java.util.Calendar fechaHasta;

    /* NÃºmero de datos que serÃ¡n devueltos en los informes Mas */
    private java.lang.Integer rango;

    /* Idioma de visualizaciÃ³n del informe */
    private java.lang.String idioma;

    /* Array con los identificadores del arbol curricular */
    private java.lang.String[] idNodo;

    /* Array con las licencias existentes en el sistema */
    private java.lang.String[] idLicencia;

    /* Identificador del usuario */
    private java.lang.String idUsuario;

    public ParametrosInformeVO() {
    }

    public ParametrosInformeVO(
           java.util.Calendar fechaDesde,
           java.util.Calendar fechaHasta,
           java.lang.Integer rango,
           java.lang.String idioma,
           java.lang.String[] idNodo,
           java.lang.String[] idLicencia,
           java.lang.String idUsuario) {
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
           this.rango = rango;
           this.idioma = idioma;
           this.idNodo = idNodo;
           this.idLicencia = idLicencia;
           this.idUsuario = idUsuario;
    }


    /**
     * Gets the fechaDesde value for this ParametrosInformeVO.
     * 
     * @return fechaDesde   * Fecha de inicio del informe
     */
    public java.util.Calendar getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this ParametrosInformeVO.
     * 
     * @param fechaDesde   * Fecha de inicio del informe
     */
    public void setFechaDesde(java.util.Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this ParametrosInformeVO.
     * 
     * @return fechaHasta
     */
    public java.util.Calendar getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this ParametrosInformeVO.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Calendar fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the rango value for this ParametrosInformeVO.
     * 
     * @return rango   * NÃºmero de datos que serÃ¡n devueltos en los informes Mas
     */
    public java.lang.Integer getRango() {
        return rango;
    }


    /**
     * Sets the rango value for this ParametrosInformeVO.
     * 
     * @param rango   * NÃºmero de datos que serÃ¡n devueltos en los informes Mas
     */
    public void setRango(java.lang.Integer rango) {
        this.rango = rango;
    }


    /**
     * Gets the idioma value for this ParametrosInformeVO.
     * 
     * @return idioma   * Idioma de visualizaciÃ³n del informe
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this ParametrosInformeVO.
     * 
     * @param idioma   * Idioma de visualizaciÃ³n del informe
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the idNodo value for this ParametrosInformeVO.
     * 
     * @return idNodo   * Array con los identificadores del arbol curricular
     */
    public java.lang.String[] getIdNodo() {
        return idNodo;
    }


    /**
     * Sets the idNodo value for this ParametrosInformeVO.
     * 
     * @param idNodo   * Array con los identificadores del arbol curricular
     */
    public void setIdNodo(java.lang.String[] idNodo) {
        this.idNodo = idNodo;
    }


    /**
     * Gets the idLicencia value for this ParametrosInformeVO.
     * 
     * @return idLicencia   * Array con las licencias existentes en el sistema
     */
    public java.lang.String[] getIdLicencia() {
        return idLicencia;
    }


    /**
     * Sets the idLicencia value for this ParametrosInformeVO.
     * 
     * @param idLicencia   * Array con las licencias existentes en el sistema
     */
    public void setIdLicencia(java.lang.String[] idLicencia) {
        this.idLicencia = idLicencia;
    }


    /**
     * Gets the idUsuario value for this ParametrosInformeVO.
     * 
     * @return idUsuario   * Identificador del usuario
     */
    public java.lang.String getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this ParametrosInformeVO.
     * 
     * @param idUsuario   * Identificador del usuario
     */
    public void setIdUsuario(java.lang.String idUsuario) {
        this.idUsuario = idUsuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParametrosInformeVO)) return false;
        ParametrosInformeVO other = (ParametrosInformeVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaDesde==null && other.getFechaDesde()==null) || 
             (this.fechaDesde!=null &&
              this.fechaDesde.equals(other.getFechaDesde()))) &&
            ((this.fechaHasta==null && other.getFechaHasta()==null) || 
             (this.fechaHasta!=null &&
              this.fechaHasta.equals(other.getFechaHasta()))) &&
            ((this.rango==null && other.getRango()==null) || 
             (this.rango!=null &&
              this.rango.equals(other.getRango()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.idNodo==null && other.getIdNodo()==null) || 
             (this.idNodo!=null &&
              java.util.Arrays.equals(this.idNodo, other.getIdNodo()))) &&
            ((this.idLicencia==null && other.getIdLicencia()==null) || 
             (this.idLicencia!=null &&
              java.util.Arrays.equals(this.idLicencia, other.getIdLicencia()))) &&
            ((this.idUsuario==null && other.getIdUsuario()==null) || 
             (this.idUsuario!=null &&
              this.idUsuario.equals(other.getIdUsuario())));
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
        if (getFechaDesde() != null) {
            _hashCode += getFechaDesde().hashCode();
        }
        if (getFechaHasta() != null) {
            _hashCode += getFechaHasta().hashCode();
        }
        if (getRango() != null) {
            _hashCode += getRango().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getIdNodo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdNodo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdNodo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdLicencia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdLicencia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdLicencia(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdUsuario() != null) {
            _hashCode += getIdUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParametrosInformeVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "ParametrosInformeVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "fechaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "fechaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rango");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "rango"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idioma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idioma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idNodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idLicencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idLicencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idUsuario"));
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
