/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * NodoSQIVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.nodosSQI.servicio;


/**
 * Objeto de valor que contiene toda la informacion que describe un
 * nodo de tipo SQI
 */
public class NodoSQIVO  implements java.io.Serializable {
    /* La URL del servicio SQI */
    private java.lang.String urlServicio;

    /* Es la URL del gestor de sesiones */
    private java.lang.String gestorSesion;

    /* Sera el lenguaje de consulta que se vaya a utilizar en el
     *                                 interfaz SQI */
    private java.lang.String lenguajeConsulta;

    /* Es el lenguaje de respuesta que devuelve una consulta SQI */
    private java.lang.String lenguajeRespuesta;

    /* Es la descripcion del nodo */
    private java.lang.String descripcionNodo;

    /* El nombre del usuario */
    private java.lang.String usuario;

    /* La clave del usuario */
    private java.lang.String clave;

    /* El identificador del nodo */
    private java.lang.Long id;

    /* El identificador de la sesion */
    private java.lang.String identificadorSesion;

    /* El nombre del nodo de tipo SQI */
    private java.lang.String nombreNodo;

    public NodoSQIVO() {
    }

    public NodoSQIVO(
           java.lang.String urlServicio,
           java.lang.String gestorSesion,
           java.lang.String lenguajeConsulta,
           java.lang.String lenguajeRespuesta,
           java.lang.String descripcionNodo,
           java.lang.String usuario,
           java.lang.String clave,
           java.lang.Long id,
           java.lang.String identificadorSesion,
           java.lang.String nombreNodo) {
           this.urlServicio = urlServicio;
           this.gestorSesion = gestorSesion;
           this.lenguajeConsulta = lenguajeConsulta;
           this.lenguajeRespuesta = lenguajeRespuesta;
           this.descripcionNodo = descripcionNodo;
           this.usuario = usuario;
           this.clave = clave;
           this.id = id;
           this.identificadorSesion = identificadorSesion;
           this.nombreNodo = nombreNodo;
    }


    /**
     * Gets the urlServicio value for this NodoSQIVO.
     * 
     * @return urlServicio   * La URL del servicio SQI
     */
    public java.lang.String getUrlServicio() {
        return urlServicio;
    }


    /**
     * Sets the urlServicio value for this NodoSQIVO.
     * 
     * @param urlServicio   * La URL del servicio SQI
     */
    public void setUrlServicio(java.lang.String urlServicio) {
        this.urlServicio = urlServicio;
    }


    /**
     * Gets the gestorSesion value for this NodoSQIVO.
     * 
     * @return gestorSesion   * Es la URL del gestor de sesiones
     */
    public java.lang.String getGestorSesion() {
        return gestorSesion;
    }


    /**
     * Sets the gestorSesion value for this NodoSQIVO.
     * 
     * @param gestorSesion   * Es la URL del gestor de sesiones
     */
    public void setGestorSesion(java.lang.String gestorSesion) {
        this.gestorSesion = gestorSesion;
    }


    /**
     * Gets the lenguajeConsulta value for this NodoSQIVO.
     * 
     * @return lenguajeConsulta   * Sera el lenguaje de consulta que se vaya a utilizar en el
     *                                 interfaz SQI
     */
    public java.lang.String getLenguajeConsulta() {
        return lenguajeConsulta;
    }


    /**
     * Sets the lenguajeConsulta value for this NodoSQIVO.
     * 
     * @param lenguajeConsulta   * Sera el lenguaje de consulta que se vaya a utilizar en el
     *                                 interfaz SQI
     */
    public void setLenguajeConsulta(java.lang.String lenguajeConsulta) {
        this.lenguajeConsulta = lenguajeConsulta;
    }


    /**
     * Gets the lenguajeRespuesta value for this NodoSQIVO.
     * 
     * @return lenguajeRespuesta   * Es el lenguaje de respuesta que devuelve una consulta SQI
     */
    public java.lang.String getLenguajeRespuesta() {
        return lenguajeRespuesta;
    }


    /**
     * Sets the lenguajeRespuesta value for this NodoSQIVO.
     * 
     * @param lenguajeRespuesta   * Es el lenguaje de respuesta que devuelve una consulta SQI
     */
    public void setLenguajeRespuesta(java.lang.String lenguajeRespuesta) {
        this.lenguajeRespuesta = lenguajeRespuesta;
    }


    /**
     * Gets the descripcionNodo value for this NodoSQIVO.
     * 
     * @return descripcionNodo   * Es la descripcion del nodo
     */
    public java.lang.String getDescripcionNodo() {
        return descripcionNodo;
    }


    /**
     * Sets the descripcionNodo value for this NodoSQIVO.
     * 
     * @param descripcionNodo   * Es la descripcion del nodo
     */
    public void setDescripcionNodo(java.lang.String descripcionNodo) {
        this.descripcionNodo = descripcionNodo;
    }


    /**
     * Gets the usuario value for this NodoSQIVO.
     * 
     * @return usuario   * El nombre del usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this NodoSQIVO.
     * 
     * @param usuario   * El nombre del usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the clave value for this NodoSQIVO.
     * 
     * @return clave   * La clave del usuario
     */
    public java.lang.String getClave() {
        return clave;
    }


    /**
     * Sets the clave value for this NodoSQIVO.
     * 
     * @param clave   * La clave del usuario
     */
    public void setClave(java.lang.String clave) {
        this.clave = clave;
    }


    /**
     * Gets the id value for this NodoSQIVO.
     * 
     * @return id   * El identificador del nodo
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this NodoSQIVO.
     * 
     * @param id   * El identificador del nodo
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the identificadorSesion value for this NodoSQIVO.
     * 
     * @return identificadorSesion   * El identificador de la sesion
     */
    public java.lang.String getIdentificadorSesion() {
        return identificadorSesion;
    }


    /**
     * Sets the identificadorSesion value for this NodoSQIVO.
     * 
     * @param identificadorSesion   * El identificador de la sesion
     */
    public void setIdentificadorSesion(java.lang.String identificadorSesion) {
        this.identificadorSesion = identificadorSesion;
    }


    /**
     * Gets the nombreNodo value for this NodoSQIVO.
     * 
     * @return nombreNodo   * El nombre del nodo de tipo SQI
     */
    public java.lang.String getNombreNodo() {
        return nombreNodo;
    }


    /**
     * Sets the nombreNodo value for this NodoSQIVO.
     * 
     * @param nombreNodo   * El nombre del nodo de tipo SQI
     */
    public void setNombreNodo(java.lang.String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NodoSQIVO)) return false;
        NodoSQIVO other = (NodoSQIVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.urlServicio==null && other.getUrlServicio()==null) || 
             (this.urlServicio!=null &&
              this.urlServicio.equals(other.getUrlServicio()))) &&
            ((this.gestorSesion==null && other.getGestorSesion()==null) || 
             (this.gestorSesion!=null &&
              this.gestorSesion.equals(other.getGestorSesion()))) &&
            ((this.lenguajeConsulta==null && other.getLenguajeConsulta()==null) || 
             (this.lenguajeConsulta!=null &&
              this.lenguajeConsulta.equals(other.getLenguajeConsulta()))) &&
            ((this.lenguajeRespuesta==null && other.getLenguajeRespuesta()==null) || 
             (this.lenguajeRespuesta!=null &&
              this.lenguajeRespuesta.equals(other.getLenguajeRespuesta()))) &&
            ((this.descripcionNodo==null && other.getDescripcionNodo()==null) || 
             (this.descripcionNodo!=null &&
              this.descripcionNodo.equals(other.getDescripcionNodo()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.clave==null && other.getClave()==null) || 
             (this.clave!=null &&
              this.clave.equals(other.getClave()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.identificadorSesion==null && other.getIdentificadorSesion()==null) || 
             (this.identificadorSesion!=null &&
              this.identificadorSesion.equals(other.getIdentificadorSesion()))) &&
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
        if (getUrlServicio() != null) {
            _hashCode += getUrlServicio().hashCode();
        }
        if (getGestorSesion() != null) {
            _hashCode += getGestorSesion().hashCode();
        }
        if (getLenguajeConsulta() != null) {
            _hashCode += getLenguajeConsulta().hashCode();
        }
        if (getLenguajeRespuesta() != null) {
            _hashCode += getLenguajeRespuesta().hashCode();
        }
        if (getDescripcionNodo() != null) {
            _hashCode += getDescripcionNodo().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getClave() != null) {
            _hashCode += getClave().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdentificadorSesion() != null) {
            _hashCode += getIdentificadorSesion().hashCode();
        }
        if (getNombreNodo() != null) {
            _hashCode += getNombreNodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NodoSQIVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "NodoSQIVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "urlServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gestorSesion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "gestorSesion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lenguajeConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "lenguajeConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lenguajeRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "lenguajeRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionNodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "descripcionNodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "clave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificadorSesion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicio.nodosSQI.negocio.buscar.pode.es", "identificadorSesion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
