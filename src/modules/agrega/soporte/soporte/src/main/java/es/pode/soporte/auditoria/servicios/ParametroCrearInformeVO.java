/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * ParametroCrearInformeVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;

public class ParametroCrearInformeVO  implements java.io.Serializable {
    private java.lang.String diaDesde;

    private java.lang.String diaHasta;

    private java.lang.Integer rango;

    private java.lang.String formato;

    private java.lang.String usuario;

    private java.lang.String nombreInforme;

    private java.lang.String mesDesde;

    private java.lang.String anioDesde;

    private java.lang.String mesHasta;

    private java.lang.String anioHasta;

    /* Identificador de la tarea que ha lanzado la ejecuciÃ³n del
     *                                 informe, se usuarÃ¡ para actualizar
     * la fecha de finalizaciÃ³n de
     *                                 la tarea una vez haya acabado la generaciÃ³n
     * del informe */
    private java.lang.Long idTarea;

    public ParametroCrearInformeVO() {
    }

    public ParametroCrearInformeVO(
           java.lang.String diaDesde,
           java.lang.String diaHasta,
           java.lang.Integer rango,
           java.lang.String formato,
           java.lang.String usuario,
           java.lang.String nombreInforme,
           java.lang.String mesDesde,
           java.lang.String anioDesde,
           java.lang.String mesHasta,
           java.lang.String anioHasta,
           java.lang.Long idTarea) {
           this.diaDesde = diaDesde;
           this.diaHasta = diaHasta;
           this.rango = rango;
           this.formato = formato;
           this.usuario = usuario;
           this.nombreInforme = nombreInforme;
           this.mesDesde = mesDesde;
           this.anioDesde = anioDesde;
           this.mesHasta = mesHasta;
           this.anioHasta = anioHasta;
           this.idTarea = idTarea;
    }


    /**
     * Gets the diaDesde value for this ParametroCrearInformeVO.
     * 
     * @return diaDesde
     */
    public java.lang.String getDiaDesde() {
        return diaDesde;
    }


    /**
     * Sets the diaDesde value for this ParametroCrearInformeVO.
     * 
     * @param diaDesde
     */
    public void setDiaDesde(java.lang.String diaDesde) {
        this.diaDesde = diaDesde;
    }


    /**
     * Gets the diaHasta value for this ParametroCrearInformeVO.
     * 
     * @return diaHasta
     */
    public java.lang.String getDiaHasta() {
        return diaHasta;
    }


    /**
     * Sets the diaHasta value for this ParametroCrearInformeVO.
     * 
     * @param diaHasta
     */
    public void setDiaHasta(java.lang.String diaHasta) {
        this.diaHasta = diaHasta;
    }


    /**
     * Gets the rango value for this ParametroCrearInformeVO.
     * 
     * @return rango
     */
    public java.lang.Integer getRango() {
        return rango;
    }


    /**
     * Sets the rango value for this ParametroCrearInformeVO.
     * 
     * @param rango
     */
    public void setRango(java.lang.Integer rango) {
        this.rango = rango;
    }


    /**
     * Gets the formato value for this ParametroCrearInformeVO.
     * 
     * @return formato
     */
    public java.lang.String getFormato() {
        return formato;
    }


    /**
     * Sets the formato value for this ParametroCrearInformeVO.
     * 
     * @param formato
     */
    public void setFormato(java.lang.String formato) {
        this.formato = formato;
    }


    /**
     * Gets the usuario value for this ParametroCrearInformeVO.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this ParametroCrearInformeVO.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the nombreInforme value for this ParametroCrearInformeVO.
     * 
     * @return nombreInforme
     */
    public java.lang.String getNombreInforme() {
        return nombreInforme;
    }


    /**
     * Sets the nombreInforme value for this ParametroCrearInformeVO.
     * 
     * @param nombreInforme
     */
    public void setNombreInforme(java.lang.String nombreInforme) {
        this.nombreInforme = nombreInforme;
    }


    /**
     * Gets the mesDesde value for this ParametroCrearInformeVO.
     * 
     * @return mesDesde
     */
    public java.lang.String getMesDesde() {
        return mesDesde;
    }


    /**
     * Sets the mesDesde value for this ParametroCrearInformeVO.
     * 
     * @param mesDesde
     */
    public void setMesDesde(java.lang.String mesDesde) {
        this.mesDesde = mesDesde;
    }


    /**
     * Gets the anioDesde value for this ParametroCrearInformeVO.
     * 
     * @return anioDesde
     */
    public java.lang.String getAnioDesde() {
        return anioDesde;
    }


    /**
     * Sets the anioDesde value for this ParametroCrearInformeVO.
     * 
     * @param anioDesde
     */
    public void setAnioDesde(java.lang.String anioDesde) {
        this.anioDesde = anioDesde;
    }


    /**
     * Gets the mesHasta value for this ParametroCrearInformeVO.
     * 
     * @return mesHasta
     */
    public java.lang.String getMesHasta() {
        return mesHasta;
    }


    /**
     * Sets the mesHasta value for this ParametroCrearInformeVO.
     * 
     * @param mesHasta
     */
    public void setMesHasta(java.lang.String mesHasta) {
        this.mesHasta = mesHasta;
    }


    /**
     * Gets the anioHasta value for this ParametroCrearInformeVO.
     * 
     * @return anioHasta
     */
    public java.lang.String getAnioHasta() {
        return anioHasta;
    }


    /**
     * Sets the anioHasta value for this ParametroCrearInformeVO.
     * 
     * @param anioHasta
     */
    public void setAnioHasta(java.lang.String anioHasta) {
        this.anioHasta = anioHasta;
    }


    /**
     * Gets the idTarea value for this ParametroCrearInformeVO.
     * 
     * @return idTarea   * Identificador de la tarea que ha lanzado la ejecuciÃ³n del
     *                                 informe, se usuarÃ¡ para actualizar
     * la fecha de finalizaciÃ³n de
     *                                 la tarea una vez haya acabado la generaciÃ³n
     * del informe
     */
    public java.lang.Long getIdTarea() {
        return idTarea;
    }


    /**
     * Sets the idTarea value for this ParametroCrearInformeVO.
     * 
     * @param idTarea   * Identificador de la tarea que ha lanzado la ejecuciÃ³n del
     *                                 informe, se usuarÃ¡ para actualizar
     * la fecha de finalizaciÃ³n de
     *                                 la tarea una vez haya acabado la generaciÃ³n
     * del informe
     */
    public void setIdTarea(java.lang.Long idTarea) {
        this.idTarea = idTarea;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParametroCrearInformeVO)) return false;
        ParametroCrearInformeVO other = (ParametroCrearInformeVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diaDesde==null && other.getDiaDesde()==null) || 
             (this.diaDesde!=null &&
              this.diaDesde.equals(other.getDiaDesde()))) &&
            ((this.diaHasta==null && other.getDiaHasta()==null) || 
             (this.diaHasta!=null &&
              this.diaHasta.equals(other.getDiaHasta()))) &&
            ((this.rango==null && other.getRango()==null) || 
             (this.rango!=null &&
              this.rango.equals(other.getRango()))) &&
            ((this.formato==null && other.getFormato()==null) || 
             (this.formato!=null &&
              this.formato.equals(other.getFormato()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.nombreInforme==null && other.getNombreInforme()==null) || 
             (this.nombreInforme!=null &&
              this.nombreInforme.equals(other.getNombreInforme()))) &&
            ((this.mesDesde==null && other.getMesDesde()==null) || 
             (this.mesDesde!=null &&
              this.mesDesde.equals(other.getMesDesde()))) &&
            ((this.anioDesde==null && other.getAnioDesde()==null) || 
             (this.anioDesde!=null &&
              this.anioDesde.equals(other.getAnioDesde()))) &&
            ((this.mesHasta==null && other.getMesHasta()==null) || 
             (this.mesHasta!=null &&
              this.mesHasta.equals(other.getMesHasta()))) &&
            ((this.anioHasta==null && other.getAnioHasta()==null) || 
             (this.anioHasta!=null &&
              this.anioHasta.equals(other.getAnioHasta()))) &&
            ((this.idTarea==null && other.getIdTarea()==null) || 
             (this.idTarea!=null &&
              this.idTarea.equals(other.getIdTarea())));
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
        if (getDiaDesde() != null) {
            _hashCode += getDiaDesde().hashCode();
        }
        if (getDiaHasta() != null) {
            _hashCode += getDiaHasta().hashCode();
        }
        if (getRango() != null) {
            _hashCode += getRango().hashCode();
        }
        if (getFormato() != null) {
            _hashCode += getFormato().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getNombreInforme() != null) {
            _hashCode += getNombreInforme().hashCode();
        }
        if (getMesDesde() != null) {
            _hashCode += getMesDesde().hashCode();
        }
        if (getAnioDesde() != null) {
            _hashCode += getAnioDesde().hashCode();
        }
        if (getMesHasta() != null) {
            _hashCode += getMesHasta().hashCode();
        }
        if (getAnioHasta() != null) {
            _hashCode += getAnioHasta().hashCode();
        }
        if (getIdTarea() != null) {
            _hashCode += getIdTarea().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParametroCrearInformeVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "ParametroCrearInformeVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "diaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "diaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rango");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "rango"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "formato"));
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
        elemField.setFieldName("nombreInforme");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "nombreInforme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "mesDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anioDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "anioDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "mesHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anioHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "anioHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTarea");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idTarea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
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
