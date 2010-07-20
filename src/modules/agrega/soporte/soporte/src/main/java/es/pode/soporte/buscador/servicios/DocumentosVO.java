/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * DocumentosVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;


/**
 * Esta clase representa los resultados de una busqueda.
 */
public class DocumentosVO  implements java.io.Serializable {
    private es.pode.soporte.buscador.servicios.DocVO[] resultados;

    /* Se trata de las sugerencias de busqueda en el caso de que no
     * haya resultados de busqueda para la busqueda invocada. Puede
     *                                 haber varias sugerencias. */
    private java.lang.String[] sugerencias;

    private java.lang.Integer numeroResultados;

    private java.lang.Integer totalResultados;

    private java.lang.Integer numDocumentosIndice;

    private es.pode.soporte.buscador.servicios.TaxonVO[] tesauros;

    public DocumentosVO() {
    }

    public DocumentosVO(
           es.pode.soporte.buscador.servicios.DocVO[] resultados,
           java.lang.String[] sugerencias,
           java.lang.Integer numeroResultados,
           java.lang.Integer totalResultados,
           java.lang.Integer numDocumentosIndice,
           es.pode.soporte.buscador.servicios.TaxonVO[] tesauros) {
           this.resultados = resultados;
           this.sugerencias = sugerencias;
           this.numeroResultados = numeroResultados;
           this.totalResultados = totalResultados;
           this.numDocumentosIndice = numDocumentosIndice;
           this.tesauros = tesauros;
    }


    /**
     * Gets the resultados value for this DocumentosVO.
     * 
     * @return resultados
     */
    public es.pode.soporte.buscador.servicios.DocVO[] getResultados() {
        return resultados;
    }


    /**
     * Sets the resultados value for this DocumentosVO.
     * 
     * @param resultados
     */
    public void setResultados(es.pode.soporte.buscador.servicios.DocVO[] resultados) {
        this.resultados = resultados;
    }


    /**
     * Gets the sugerencias value for this DocumentosVO.
     * 
     * @return sugerencias   * Se trata de las sugerencias de busqueda en el caso de que no
     * haya resultados de busqueda para la busqueda invocada. Puede
     *                                 haber varias sugerencias.
     */
    public java.lang.String[] getSugerencias() {
        return sugerencias;
    }


    /**
     * Sets the sugerencias value for this DocumentosVO.
     * 
     * @param sugerencias   * Se trata de las sugerencias de busqueda en el caso de que no
     * haya resultados de busqueda para la busqueda invocada. Puede
     *                                 haber varias sugerencias.
     */
    public void setSugerencias(java.lang.String[] sugerencias) {
        this.sugerencias = sugerencias;
    }


    /**
     * Gets the numeroResultados value for this DocumentosVO.
     * 
     * @return numeroResultados
     */
    public java.lang.Integer getNumeroResultados() {
        return numeroResultados;
    }


    /**
     * Sets the numeroResultados value for this DocumentosVO.
     * 
     * @param numeroResultados
     */
    public void setNumeroResultados(java.lang.Integer numeroResultados) {
        this.numeroResultados = numeroResultados;
    }


    /**
     * Gets the totalResultados value for this DocumentosVO.
     * 
     * @return totalResultados
     */
    public java.lang.Integer getTotalResultados() {
        return totalResultados;
    }


    /**
     * Sets the totalResultados value for this DocumentosVO.
     * 
     * @param totalResultados
     */
    public void setTotalResultados(java.lang.Integer totalResultados) {
        this.totalResultados = totalResultados;
    }


    /**
     * Gets the numDocumentosIndice value for this DocumentosVO.
     * 
     * @return numDocumentosIndice
     */
    public java.lang.Integer getNumDocumentosIndice() {
        return numDocumentosIndice;
    }


    /**
     * Sets the numDocumentosIndice value for this DocumentosVO.
     * 
     * @param numDocumentosIndice
     */
    public void setNumDocumentosIndice(java.lang.Integer numDocumentosIndice) {
        this.numDocumentosIndice = numDocumentosIndice;
    }


    /**
     * Gets the tesauros value for this DocumentosVO.
     * 
     * @return tesauros
     */
    public es.pode.soporte.buscador.servicios.TaxonVO[] getTesauros() {
        return tesauros;
    }


    /**
     * Sets the tesauros value for this DocumentosVO.
     * 
     * @param tesauros
     */
    public void setTesauros(es.pode.soporte.buscador.servicios.TaxonVO[] tesauros) {
        this.tesauros = tesauros;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentosVO)) return false;
        DocumentosVO other = (DocumentosVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultados==null && other.getResultados()==null) || 
             (this.resultados!=null &&
              java.util.Arrays.equals(this.resultados, other.getResultados()))) &&
            ((this.sugerencias==null && other.getSugerencias()==null) || 
             (this.sugerencias!=null &&
              java.util.Arrays.equals(this.sugerencias, other.getSugerencias()))) &&
            ((this.numeroResultados==null && other.getNumeroResultados()==null) || 
             (this.numeroResultados!=null &&
              this.numeroResultados.equals(other.getNumeroResultados()))) &&
            ((this.totalResultados==null && other.getTotalResultados()==null) || 
             (this.totalResultados!=null &&
              this.totalResultados.equals(other.getTotalResultados()))) &&
            ((this.numDocumentosIndice==null && other.getNumDocumentosIndice()==null) || 
             (this.numDocumentosIndice!=null &&
              this.numDocumentosIndice.equals(other.getNumDocumentosIndice()))) &&
            ((this.tesauros==null && other.getTesauros()==null) || 
             (this.tesauros!=null &&
              java.util.Arrays.equals(this.tesauros, other.getTesauros())));
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
        if (getResultados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResultados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResultados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSugerencias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSugerencias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSugerencias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumeroResultados() != null) {
            _hashCode += getNumeroResultados().hashCode();
        }
        if (getTotalResultados() != null) {
            _hashCode += getTotalResultados().hashCode();
        }
        if (getNumDocumentosIndice() != null) {
            _hashCode += getNumDocumentosIndice().hashCode();
        }
        if (getTesauros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTesauros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTesauros(), i);
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
        new org.apache.axis.description.TypeDesc(DocumentosVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "resultados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocVO"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sugerencias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "sugerencias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroResultados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "numeroResultados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalResultados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "totalResultados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numDocumentosIndice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "numDocumentosIndice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tesauros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "tesauros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "TaxonVO"));
        elemField.setNillable(true);
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
