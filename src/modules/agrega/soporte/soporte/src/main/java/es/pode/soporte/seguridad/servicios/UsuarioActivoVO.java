/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * UsuarioActivoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.seguridad.servicios;

public class UsuarioActivoVO  implements java.io.Serializable {
    private java.lang.String nombre;

    private java.lang.String apellido1;

    private java.lang.String apellido2;

    private java.lang.String login;

    private java.lang.String email;

    private java.lang.String idiomaAplicacion;

    private java.lang.String idiomaBusqueda;

    private java.lang.String tipoEmpaquetador;

    private java.lang.String grupos;

    private java.lang.String permisos;

    private java.lang.String NIF;

    public UsuarioActivoVO() {
    }

    public UsuarioActivoVO(
           java.lang.String nombre,
           java.lang.String apellido1,
           java.lang.String apellido2,
           java.lang.String login,
           java.lang.String email,
           java.lang.String idiomaAplicacion,
           java.lang.String idiomaBusqueda,
           java.lang.String tipoEmpaquetador,
           java.lang.String grupos,
           java.lang.String permisos,
           java.lang.String NIF) {
           this.nombre = nombre;
           this.apellido1 = apellido1;
           this.apellido2 = apellido2;
           this.login = login;
           this.email = email;
           this.idiomaAplicacion = idiomaAplicacion;
           this.idiomaBusqueda = idiomaBusqueda;
           this.tipoEmpaquetador = tipoEmpaquetador;
           this.grupos = grupos;
           this.permisos = permisos;
           this.NIF = NIF;
    }


    /**
     * Gets the nombre value for this UsuarioActivoVO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this UsuarioActivoVO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the apellido1 value for this UsuarioActivoVO.
     * 
     * @return apellido1
     */
    public java.lang.String getApellido1() {
        return apellido1;
    }


    /**
     * Sets the apellido1 value for this UsuarioActivoVO.
     * 
     * @param apellido1
     */
    public void setApellido1(java.lang.String apellido1) {
        this.apellido1 = apellido1;
    }


    /**
     * Gets the apellido2 value for this UsuarioActivoVO.
     * 
     * @return apellido2
     */
    public java.lang.String getApellido2() {
        return apellido2;
    }


    /**
     * Sets the apellido2 value for this UsuarioActivoVO.
     * 
     * @param apellido2
     */
    public void setApellido2(java.lang.String apellido2) {
        this.apellido2 = apellido2;
    }


    /**
     * Gets the login value for this UsuarioActivoVO.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this UsuarioActivoVO.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the email value for this UsuarioActivoVO.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this UsuarioActivoVO.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the idiomaAplicacion value for this UsuarioActivoVO.
     * 
     * @return idiomaAplicacion
     */
    public java.lang.String getIdiomaAplicacion() {
        return idiomaAplicacion;
    }


    /**
     * Sets the idiomaAplicacion value for this UsuarioActivoVO.
     * 
     * @param idiomaAplicacion
     */
    public void setIdiomaAplicacion(java.lang.String idiomaAplicacion) {
        this.idiomaAplicacion = idiomaAplicacion;
    }


    /**
     * Gets the idiomaBusqueda value for this UsuarioActivoVO.
     * 
     * @return idiomaBusqueda
     */
    public java.lang.String getIdiomaBusqueda() {
        return idiomaBusqueda;
    }


    /**
     * Sets the idiomaBusqueda value for this UsuarioActivoVO.
     * 
     * @param idiomaBusqueda
     */
    public void setIdiomaBusqueda(java.lang.String idiomaBusqueda) {
        this.idiomaBusqueda = idiomaBusqueda;
    }


    /**
     * Gets the tipoEmpaquetador value for this UsuarioActivoVO.
     * 
     * @return tipoEmpaquetador
     */
    public java.lang.String getTipoEmpaquetador() {
        return tipoEmpaquetador;
    }


    /**
     * Sets the tipoEmpaquetador value for this UsuarioActivoVO.
     * 
     * @param tipoEmpaquetador
     */
    public void setTipoEmpaquetador(java.lang.String tipoEmpaquetador) {
        this.tipoEmpaquetador = tipoEmpaquetador;
    }


    /**
     * Gets the grupos value for this UsuarioActivoVO.
     * 
     * @return grupos
     */
    public java.lang.String getGrupos() {
        return grupos;
    }


    /**
     * Sets the grupos value for this UsuarioActivoVO.
     * 
     * @param grupos
     */
    public void setGrupos(java.lang.String grupos) {
        this.grupos = grupos;
    }


    /**
     * Gets the permisos value for this UsuarioActivoVO.
     * 
     * @return permisos
     */
    public java.lang.String getPermisos() {
        return permisos;
    }


    /**
     * Sets the permisos value for this UsuarioActivoVO.
     * 
     * @param permisos
     */
    public void setPermisos(java.lang.String permisos) {
        this.permisos = permisos;
    }


    /**
     * Gets the NIF value for this UsuarioActivoVO.
     * 
     * @return NIF
     */
    public java.lang.String getNIF() {
        return NIF;
    }


    /**
     * Sets the NIF value for this UsuarioActivoVO.
     * 
     * @param NIF
     */
    public void setNIF(java.lang.String NIF) {
        this.NIF = NIF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioActivoVO)) return false;
        UsuarioActivoVO other = (UsuarioActivoVO) obj;
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
            ((this.apellido1==null && other.getApellido1()==null) || 
             (this.apellido1!=null &&
              this.apellido1.equals(other.getApellido1()))) &&
            ((this.apellido2==null && other.getApellido2()==null) || 
             (this.apellido2!=null &&
              this.apellido2.equals(other.getApellido2()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.idiomaAplicacion==null && other.getIdiomaAplicacion()==null) || 
             (this.idiomaAplicacion!=null &&
              this.idiomaAplicacion.equals(other.getIdiomaAplicacion()))) &&
            ((this.idiomaBusqueda==null && other.getIdiomaBusqueda()==null) || 
             (this.idiomaBusqueda!=null &&
              this.idiomaBusqueda.equals(other.getIdiomaBusqueda()))) &&
            ((this.tipoEmpaquetador==null && other.getTipoEmpaquetador()==null) || 
             (this.tipoEmpaquetador!=null &&
              this.tipoEmpaquetador.equals(other.getTipoEmpaquetador()))) &&
            ((this.grupos==null && other.getGrupos()==null) || 
             (this.grupos!=null &&
              this.grupos.equals(other.getGrupos()))) &&
            ((this.permisos==null && other.getPermisos()==null) || 
             (this.permisos!=null &&
              this.permisos.equals(other.getPermisos()))) &&
            ((this.NIF==null && other.getNIF()==null) || 
             (this.NIF!=null &&
              this.NIF.equals(other.getNIF())));
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
        if (getApellido1() != null) {
            _hashCode += getApellido1().hashCode();
        }
        if (getApellido2() != null) {
            _hashCode += getApellido2().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getIdiomaAplicacion() != null) {
            _hashCode += getIdiomaAplicacion().hashCode();
        }
        if (getIdiomaBusqueda() != null) {
            _hashCode += getIdiomaBusqueda().hashCode();
        }
        if (getTipoEmpaquetador() != null) {
            _hashCode += getTipoEmpaquetador().hashCode();
        }
        if (getGrupos() != null) {
            _hashCode += getGrupos().hashCode();
        }
        if (getPermisos() != null) {
            _hashCode += getPermisos().hashCode();
        }
        if (getNIF() != null) {
            _hashCode += getNIF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsuarioActivoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioActivoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "apellido1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "apellido2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomaAplicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "idiomaAplicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomaBusqueda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "idiomaBusqueda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEmpaquetador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "tipoEmpaquetador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grupos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "grupos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permisos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "permisos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NIF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "NIF"));
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
