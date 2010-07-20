/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * ValoresBusquedaVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.buscar.negocio.federada.servicios;

public class ValoresBusquedaVO  implements java.io.Serializable {
    /* Valoracion del ODE dentro de la plataforma. */
    private java.lang.Float valoracion;

    /* Titulo del ODE. */
    private java.lang.String titulo;

    /* Tipo de recurso. Hay un tipo de recurso por cada entrada del
     * array. */
    private java.lang.String[] tipoRecurso;

    /* Valor del ranking dentro de la busqueda realizada. */
    private java.lang.Integer ranking;

    /* El area curricular del ODE. */
    private java.lang.String[] areaCurricular;

    /* Curso al que pertenece el ODE. */
    private java.lang.String curso;

    /* Identificador alfanumerico del ODE. */
    private java.lang.String id;

    public ValoresBusquedaVO() {
    }

    public ValoresBusquedaVO(
           java.lang.Float valoracion,
           java.lang.String titulo,
           java.lang.String[] tipoRecurso,
           java.lang.Integer ranking,
           java.lang.String[] areaCurricular,
           java.lang.String curso,
           java.lang.String id) {
           this.valoracion = valoracion;
           this.titulo = titulo;
           this.tipoRecurso = tipoRecurso;
           this.ranking = ranking;
           this.areaCurricular = areaCurricular;
           this.curso = curso;
           this.id = id;
    }


    /**
     * Gets the valoracion value for this ValoresBusquedaVO.
     * 
     * @return valoracion   * Valoracion del ODE dentro de la plataforma.
     */
    public java.lang.Float getValoracion() {
        return valoracion;
    }


    /**
     * Sets the valoracion value for this ValoresBusquedaVO.
     * 
     * @param valoracion   * Valoracion del ODE dentro de la plataforma.
     */
    public void setValoracion(java.lang.Float valoracion) {
        this.valoracion = valoracion;
    }


    /**
     * Gets the titulo value for this ValoresBusquedaVO.
     * 
     * @return titulo   * Titulo del ODE.
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this ValoresBusquedaVO.
     * 
     * @param titulo   * Titulo del ODE.
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }


    /**
     * Gets the tipoRecurso value for this ValoresBusquedaVO.
     * 
     * @return tipoRecurso   * Tipo de recurso. Hay un tipo de recurso por cada entrada del
     * array.
     */
    public java.lang.String[] getTipoRecurso() {
        return tipoRecurso;
    }


    /**
     * Sets the tipoRecurso value for this ValoresBusquedaVO.
     * 
     * @param tipoRecurso   * Tipo de recurso. Hay un tipo de recurso por cada entrada del
     * array.
     */
    public void setTipoRecurso(java.lang.String[] tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }


    /**
     * Gets the ranking value for this ValoresBusquedaVO.
     * 
     * @return ranking   * Valor del ranking dentro de la busqueda realizada.
     */
    public java.lang.Integer getRanking() {
        return ranking;
    }


    /**
     * Sets the ranking value for this ValoresBusquedaVO.
     * 
     * @param ranking   * Valor del ranking dentro de la busqueda realizada.
     */
    public void setRanking(java.lang.Integer ranking) {
        this.ranking = ranking;
    }


    /**
     * Gets the areaCurricular value for this ValoresBusquedaVO.
     * 
     * @return areaCurricular   * El area curricular del ODE.
     */
    public java.lang.String[] getAreaCurricular() {
        return areaCurricular;
    }


    /**
     * Sets the areaCurricular value for this ValoresBusquedaVO.
     * 
     * @param areaCurricular   * El area curricular del ODE.
     */
    public void setAreaCurricular(java.lang.String[] areaCurricular) {
        this.areaCurricular = areaCurricular;
    }


    /**
     * Gets the curso value for this ValoresBusquedaVO.
     * 
     * @return curso   * Curso al que pertenece el ODE.
     */
    public java.lang.String getCurso() {
        return curso;
    }


    /**
     * Sets the curso value for this ValoresBusquedaVO.
     * 
     * @param curso   * Curso al que pertenece el ODE.
     */
    public void setCurso(java.lang.String curso) {
        this.curso = curso;
    }


    /**
     * Gets the id value for this ValoresBusquedaVO.
     * 
     * @return id   * Identificador alfanumerico del ODE.
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ValoresBusquedaVO.
     * 
     * @param id   * Identificador alfanumerico del ODE.
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValoresBusquedaVO)) return false;
        ValoresBusquedaVO other = (ValoresBusquedaVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.valoracion==null && other.getValoracion()==null) || 
             (this.valoracion!=null &&
              this.valoracion.equals(other.getValoracion()))) &&
            ((this.titulo==null && other.getTitulo()==null) || 
             (this.titulo!=null &&
              this.titulo.equals(other.getTitulo()))) &&
            ((this.tipoRecurso==null && other.getTipoRecurso()==null) || 
             (this.tipoRecurso!=null &&
              java.util.Arrays.equals(this.tipoRecurso, other.getTipoRecurso()))) &&
            ((this.ranking==null && other.getRanking()==null) || 
             (this.ranking!=null &&
              this.ranking.equals(other.getRanking()))) &&
            ((this.areaCurricular==null && other.getAreaCurricular()==null) || 
             (this.areaCurricular!=null &&
              java.util.Arrays.equals(this.areaCurricular, other.getAreaCurricular()))) &&
            ((this.curso==null && other.getCurso()==null) || 
             (this.curso!=null &&
              this.curso.equals(other.getCurso()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId())));
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
        if (getValoracion() != null) {
            _hashCode += getValoracion().hashCode();
        }
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        if (getTipoRecurso() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTipoRecurso());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTipoRecurso(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRanking() != null) {
            _hashCode += getRanking().hashCode();
        }
        if (getAreaCurricular() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAreaCurricular());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAreaCurricular(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCurso() != null) {
            _hashCode += getCurso().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValoresBusquedaVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "ValoresBusquedaVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valoracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "valoracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titulo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "titulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "tipoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ranking");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "ranking"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("areaCurricular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "areaCurricular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "curso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "id"));
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
