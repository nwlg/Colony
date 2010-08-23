/* Agrega es una federaciÛn de repositorios de objetos digitales educativos formada por todas las Comunidades AutÛnomas propiedad de Red.es. Este cÛdigo ha sido desarrollado por la Entidad P˙blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a travÈs de la SecretarÌa de Estado de Telecomunicaciones y para la Sociedad de la InformaciÛn, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la InformaciÛn y de Convergencia con Europa y entre Comunidades AutÛnomas y Ciudades AutÛnomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 ìSociedad de la InformaciÛnî

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * InformeMasVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;


/**
 * VO gen√©rico que almacena informaci√≥n de los odes que han sido
 *                         m√°s veces: mostrados, previsualizados, descargados
 * ....
 */
public class InformeMasVO  implements java.io.Serializable {
    /* T√≠tulo del ode. Normalmente este campo no se podr√° almacenar
     * en
     *                                 la BD porque no se recoge en los par√°metros
     * que se interceptan */
    private java.lang.String tituloOde;

    /* N√∫mero de veces que ha sido el ode: mostrado, previsualizado
     * o
     *                                 descargado */
    private int numVeces;

    /* Identificador del ode */
    private java.lang.String idOde;

    /* Idioma de b√∫squeda. Se utilizar√° para obtener la ficha del
     * ode */
    private java.lang.String idioma;

    public InformeMasVO() {
    }

    public InformeMasVO(
           java.lang.String tituloOde,
           int numVeces,
           java.lang.String idOde,
           java.lang.String idioma) {
           this.tituloOde = tituloOde;
           this.numVeces = numVeces;
           this.idOde = idOde;
           this.idioma = idioma;
    }


    /**
     * Gets the tituloOde value for this InformeMasVO.
     * 
     * @return tituloOde   * T√≠tulo del ode. Normalmente este campo no se podr√° almacenar
     * en
     *                                 la BD porque no se recoge en los par√°metros
     * que se interceptan
     */
    public java.lang.String getTituloOde() {
        return tituloOde;
    }


    /**
     * Sets the tituloOde value for this InformeMasVO.
     * 
     * @param tituloOde   * T√≠tulo del ode. Normalmente este campo no se podr√° almacenar
     * en
     *                                 la BD porque no se recoge en los par√°metros
     * que se interceptan
     */
    public void setTituloOde(java.lang.String tituloOde) {
        this.tituloOde = tituloOde;
    }


    /**
     * Gets the numVeces value for this InformeMasVO.
     * 
     * @return numVeces   * N√∫mero de veces que ha sido el ode: mostrado, previsualizado
     * o
     *                                 descargado
     */
    public int getNumVeces() {
        return numVeces;
    }


    /**
     * Sets the numVeces value for this InformeMasVO.
     * 
     * @param numVeces   * N√∫mero de veces que ha sido el ode: mostrado, previsualizado
     * o
     *                                 descargado
     */
    public void setNumVeces(int numVeces) {
        this.numVeces = numVeces;
    }


    /**
     * Gets the idOde value for this InformeMasVO.
     * 
     * @return idOde   * Identificador del ode
     */
    public java.lang.String getIdOde() {
        return idOde;
    }


    /**
     * Sets the idOde value for this InformeMasVO.
     * 
     * @param idOde   * Identificador del ode
     */
    public void setIdOde(java.lang.String idOde) {
        this.idOde = idOde;
    }


    /**
     * Gets the idioma value for this InformeMasVO.
     * 
     * @return idioma   * Idioma de b√∫squeda. Se utilizar√° para obtener la ficha del
     * ode
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this InformeMasVO.
     * 
     * @param idioma   * Idioma de b√∫squeda. Se utilizar√° para obtener la ficha del
     * ode
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformeMasVO)) return false;
        InformeMasVO other = (InformeMasVO) obj;
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
            this.numVeces == other.getNumVeces() &&
            ((this.idOde==null && other.getIdOde()==null) || 
             (this.idOde!=null &&
              this.idOde.equals(other.getIdOde()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma())));
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
        _hashCode += getNumVeces();
        if (getIdOde() != null) {
            _hashCode += getIdOde().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformeMasVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "InformeMasVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tituloOde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "tituloOde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numVeces");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "numVeces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idOde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idioma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.auditoria.soporte.pode.es", "idioma"));
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
