/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvAdminUsuariosServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.seguridad.servicios;

public class SrvAdminUsuariosServiceSoapBindingStub extends org.apache.axis.client.Stub implements es.pode.soporte.seguridad.servicios.SrvAdminUsuariosService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[41];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("activarUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "admin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("altaGrupo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "grupoVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoVO"), es.pode.soporte.seguridad.servicios.GrupoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "altaGrupoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("altaGrupoTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "grupoTrabajo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoTrabajoVO"), es.pode.soporte.seguridad.servicios.GrupoTrabajoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "altaGrupoTrabajoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("altaUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "adminVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "altaUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bajaGrupo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long"), java.lang.Long[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaGrupoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaGrupoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bajaGrupoTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long"), java.lang.Long[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaGrupoTrabajoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaGrupoTrabajoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bajaUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long"), java.lang.Long[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "emailAdmin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bajaUsuarioPendiente");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long"), java.lang.Long[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "emailAdmin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaUsuarioPendienteReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("desactivarUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "admin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("descripcionGrupo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.GrupoVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcionGrupoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("descripcionGrupoTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "identificador"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoTrabajoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.GrupoTrabajoVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcionGrupoTrabajoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("descripcionUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcionUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarCorreoBaja");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "enviarCorreoBajaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("existeDescripcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "existeDescripcionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("existeNombreTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "nombre"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "existeNombreTrabajoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("existeUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "existeUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEmailAdmin");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfxsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "getEmailAdminReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEmailPublicadores");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfxsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "getEmailPublicadoresReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRol");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "RolVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.RolVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "getRolReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarGrupos");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfGrupoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.GrupoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarGruposReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarGruposTrabajo");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfGrupoTrabajoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarGruposTrabajoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarRoles");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfRolVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.RolVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarRolesReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarRolesUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfxsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarRolesUsuarioReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarTodosUsuarios");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarTodosUsuariosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarUsuarios");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarUsuariosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarUsuariosInactivos");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarUsuariosInactivosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listarUsuariosPendientes");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarUsuariosPendientesReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modificarGrupo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "grupo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoVO"), es.pode.soporte.seguridad.servicios.GrupoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modificarGrupoTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "grupoTrabajo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoTrabajoVO"), es.pode.soporte.seguridad.servicios.GrupoTrabajoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "modificarGrupoTrabajoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modificarUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "modificarUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nuevaClave");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "emailNIF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "nuevaClaveReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerDatosUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerDatosUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerGrupoAdministrador");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long"));
        oper.setReturnClass(java.lang.Long[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerGrupoAdministradorReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerListaUsuariosGrupoTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuarioGrupoTrabajo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfxsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerListaUsuariosGrupoTrabajoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "nif"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerUsuarioConOpenId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "openIdUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuarioConOpenIdReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerUsuariosAdministrador");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long"));
        oper.setReturnClass(java.lang.Long[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuariosAdministradorReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerUsuariosGrupo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuariosGrupoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerUsuariosGrupoTrabajo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), java.lang.Long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuariosGrupoTrabajoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("solicitarAltaUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO"), es.pode.soporte.seguridad.servicios.UsuarioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "solicitarAltaUsuarioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("usuariosActivos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "parametroAuditoriaVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ParametroAuditoriaUsuariosVO"), es.pode.soporte.seguridad.servicios.ParametroAuditoriaUsuariosVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioActivoVO"));
        oper.setReturnClass(es.pode.soporte.seguridad.servicios.UsuarioActivoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuariosActivosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

    }

    public SrvAdminUsuariosServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SrvAdminUsuariosServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SrvAdminUsuariosServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfGrupoTrabajoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoTrabajoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfGrupoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.GrupoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfRolVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.RolVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "RolVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfsoapenc_long");
            cachedSerQNames.add(qName);
            cls = java.lang.Long[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioActivoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.UsuarioActivoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioActivoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfUsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.UsuarioVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ArrayOfxsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoTrabajoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.GrupoTrabajoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "GrupoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.GrupoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ParametroAuditoriaUsuariosVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.ParametroAuditoriaUsuariosVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "RolVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.RolVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioActivoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.UsuarioActivoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "UsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.UsuarioVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaGrupoTrabajoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaGrupoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "ValidaBajaUsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void activarUsuario(java.lang.Long id, java.lang.String admin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("activarUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "activarUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id, admin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long altaGrupo(es.pode.soporte.seguridad.servicios.GrupoVO grupoVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("altaGrupo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "altaGrupo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {grupoVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long altaGrupoTrabajo(es.pode.soporte.seguridad.servicios.GrupoTrabajoVO grupoTrabajo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("altaGrupoTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "altaGrupoTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {grupoTrabajo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long altaUsuario(es.pode.soporte.seguridad.servicios.UsuarioVO usuario, es.pode.soporte.seguridad.servicios.UsuarioVO adminVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("altaUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "altaUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, adminVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO bajaGrupo(java.lang.Long[] ids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("bajaGrupo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaGrupo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.ValidaBajaGrupoVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO bajaGrupoTrabajo(java.lang.Long[] ids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("bajaGrupoTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaGrupoTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.ValidaBajaGrupoTrabajoVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO bajaUsuario(java.lang.Long[] ids, es.pode.soporte.seguridad.servicios.UsuarioVO emailAdmin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("bajaUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ids, emailAdmin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO bajaUsuarioPendiente(java.lang.Long[] ids, es.pode.soporte.seguridad.servicios.UsuarioVO emailAdmin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("bajaUsuarioPendiente");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "bajaUsuarioPendiente"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ids, emailAdmin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.ValidaBajaUsuarioVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void desactivarUsuario(java.lang.Long id, java.lang.String admin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("desactivarUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "desactivarUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id, admin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.GrupoVO descripcionGrupo(java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("descripcionGrupo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcionGrupo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.GrupoVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.GrupoVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.GrupoVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.GrupoTrabajoVO descripcionGrupoTrabajo(java.lang.Long identificador) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("descripcionGrupoTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcionGrupoTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identificador});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.GrupoTrabajoVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.GrupoTrabajoVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.GrupoTrabajoVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO descripcionUsuario(java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("descripcionUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "descripcionUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String enviarCorreoBaja(es.pode.soporte.seguridad.servicios.UsuarioVO usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("enviarCorreoBaja");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "enviarCorreoBaja"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean existeDescripcion(java.lang.String descripcion, java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("existeDescripcion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "existeDescripcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {descripcion, id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean existeNombreTrabajo(java.lang.String nombre, java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("existeNombreTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "existeNombreTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {nombre, id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean existeUsuario(java.lang.String usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("existeUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "existeUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getEmailAdmin() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getEmailAdmin");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "getEmailAdmin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getEmailPublicadores() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getEmailPublicadores");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "getEmailPublicadores"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.RolVO getRol(java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getRol");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "getRol"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.RolVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.RolVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.RolVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.GrupoVO[] listarGrupos() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarGrupos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarGrupos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.GrupoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.GrupoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.GrupoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[] listarGruposTrabajo() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarGruposTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarGruposTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.GrupoTrabajoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.RolVO[] listarRoles() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarRoles");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.RolVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.RolVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.RolVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] listarRolesUsuario(java.lang.String usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarRolesUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarRolesUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarTodosUsuarios() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarTodosUsuarios");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarTodosUsuarios"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarUsuarios() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarUsuarios");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarUsuarios"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarUsuariosInactivos() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarUsuariosInactivos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarUsuariosInactivos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO[] listarUsuariosPendientes() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("listarUsuariosPendientes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "listarUsuariosPendientes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void modificarGrupo(es.pode.soporte.seguridad.servicios.GrupoVO grupo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("modificarGrupo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "modificarGrupo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {grupo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long modificarGrupoTrabajo(es.pode.soporte.seguridad.servicios.GrupoTrabajoVO grupoTrabajo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("modificarGrupoTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "modificarGrupoTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {grupoTrabajo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String modificarUsuario(es.pode.soporte.seguridad.servicios.UsuarioVO usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("modificarUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "modificarUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean nuevaClave(es.pode.soporte.seguridad.servicios.UsuarioVO emailNIF) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("nuevaClave");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "nuevaClave"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {emailNIF});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO obtenerDatosUsuario(java.lang.String usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerDatosUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerDatosUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long[] obtenerGrupoAdministrador() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerGrupoAdministrador");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerGrupoAdministrador"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] obtenerListaUsuariosGrupoTrabajo(java.lang.String usuarioGrupoTrabajo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerListaUsuariosGrupoTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerListaUsuariosGrupoTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuarioGrupoTrabajo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO obtenerUsuario(java.lang.String nif) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {nif});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioVO obtenerUsuarioConOpenId(java.lang.String openIdUrl) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerUsuarioConOpenId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuarioConOpenId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {openIdUrl});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long[] obtenerUsuariosAdministrador() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerUsuariosAdministrador");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuariosAdministrador"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean obtenerUsuariosGrupo(java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerUsuariosGrupo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuariosGrupo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean obtenerUsuariosGrupoTrabajo(java.lang.Long id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerUsuariosGrupoTrabajo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "obtenerUsuariosGrupoTrabajo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String solicitarAltaUsuario(es.pode.soporte.seguridad.servicios.UsuarioVO usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("solicitarAltaUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "solicitarAltaUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.seguridad.servicios.UsuarioActivoVO[] usuariosActivos(es.pode.soporte.seguridad.servicios.ParametroAuditoriaUsuariosVO parametroAuditoriaVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("usuariosActivos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.adminusuarios.pode.es", "usuariosActivos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametroAuditoriaVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.seguridad.servicios.UsuarioActivoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.seguridad.servicios.UsuarioActivoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.seguridad.servicios.UsuarioActivoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
