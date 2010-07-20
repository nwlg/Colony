/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvAuditoriaServicioSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.auditoria.servicios;

public class SrvAuditoriaServicioSoapBindingStub extends org.apache.axis.client.Stub implements es.pode.soporte.auditoria.servicios.SrvAuditoriaServicio {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[30];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("crearGuardarInforme");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametroCrearInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametroCrearInformeVO"), es.pode.soporte.auditoria.servicios.ParametroCrearInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("crearInforme");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosCrearInforme"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametroCrearInformeVO"), es.pode.soporte.auditoria.servicios.ParametroCrearInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "DataHandler"));
        oper.setReturnClass(javax.activation.DataHandler.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "crearInformeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("crearInformeRepositorio");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("crearInformesPortada");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeCoberturaCurricular");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeCoberturaCurricularVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeCoberturaCurricularReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeEstadoOdes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeEstadoOdesVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeEstadoOdesReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeEstadoOdesTransicciones");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeEstadoOdesVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeEstadoOdesTransiccionesReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeLicenciasOdes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeLicenciasOdesVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeLicenciasOdesReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeMasDescargados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasDescargadosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeMasMostrado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasMostradoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeMasPesados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasPesadosVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeMasPesadosVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasPesadosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeMasPrevisualizados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasPrevisualizadosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeMasValorado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasValoradoVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeMasValoradoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasValoradoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeMasVisualizados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasVisualizadosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeNivelAgregacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeNivelAgregacionVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeNivelAgregacionReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOdeUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametroInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdeUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdeUsuarioReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOdeUsuarioOperacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdeUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdeUsuarioOperacionReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOperacionesRealizadas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametroInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOperacionVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeOperacionVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOperacionesRealizadasReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOperacionUsuario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOperacionUsuarioVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOperacionUsuarioReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeProcesosPlanificados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeProcesoPlanificadoVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeProcesosPlanificadosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeTerminosBusqueda");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametrosInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeTerminoBusquedaVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeTerminosBusquedaReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeUsuarios");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametroInformeVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO"), es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeUsuariosVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.InformeUsuariosVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeUsuariosReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerInformes");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfxsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "obtenerInformesReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrarBusqueda");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "busqueda"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "BusquedaVO"), es.pode.soporte.auditoria.servicios.BusquedaVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrarOperacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "operacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "OperacionVO"), es.pode.soporte.auditoria.servicios.OperacionVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrarTrabajoFechaFinPlan");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "trabajo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "TareaEjecutadaPlanVO"), es.pode.soporte.auditoria.servicios.TareaEjecutadaPlanVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoFechaFinPlanReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrarTrabajoHijoPlan");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "trabajoHijo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "RegistroTareaEjecPlanVO"), es.pode.soporte.auditoria.servicios.RegistroTareaEjecPlanVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoHijoPlanReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrarTrabajoInterrPlan");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoInterrPlanReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrarTrabajoPlan");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "trabajo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "TareaEjecutadaPlanVO"), es.pode.soporte.auditoria.servicios.TareaEjecutadaPlanVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoPlanReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("repositorio");
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfRepositorioVO"));
        oper.setReturnClass(es.pode.soporte.auditoria.servicios.RepositorioVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "repositorioReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    public SrvAuditoriaServicioSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SrvAuditoriaServicioSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SrvAuditoriaServicioSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeCoberturaCurricularVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeCoberturaCurricularVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeEstadoOdesVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeEstadoOdesVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeLicenciasOdesVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeLicenciasOdesVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasPesadosVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeMasPesadosVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeMasPesadosVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasValoradoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeMasValoradoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeMasValoradoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeMasVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeMasVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeMasVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeNivelAgregacionVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeNivelAgregacionVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdeUsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdeUsuarioVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOperacionUsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOperacionUsuarioVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOperacionVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeOperacionVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOperacionVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeProcesoPlanificadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeProcesoPlanificadoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeTerminoBusquedaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeTerminoBusquedaVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeUsuariosVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeUsuariosVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeUsuariosVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfRepositorioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.RepositorioVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "RepositorioVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfxsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "BusquedaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.BusquedaVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeCoberturaCurricularVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeEstadoOdesVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeLicenciasOdesVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeMasPesadosVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeMasPesadosVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeMasValoradoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeMasValoradoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeMasVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeMasVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeNivelAgregacionVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdeUsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOperacionUsuarioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOperacionVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeOperacionVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeProcesoPlanificadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeTerminoBusquedaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeUsuariosVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.InformeUsuariosVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "OperacionVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.OperacionVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametroCrearInformeVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.ParametroCrearInformeVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.ParametrosInformeVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "RegistroTareaEjecPlanVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.RegistroTareaEjecPlanVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "RepositorioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.RepositorioVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "TareaEjecutadaPlanVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.auditoria.servicios.TareaEjecutadaPlanVO.class;
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

    public void crearGuardarInforme(es.pode.soporte.auditoria.servicios.ParametroCrearInformeVO parametroCrearInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("crearGuardarInforme");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "crearGuardarInforme"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametroCrearInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public javax.activation.DataHandler crearInforme(es.pode.soporte.auditoria.servicios.ParametroCrearInformeVO parametrosCrearInforme) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("crearInforme");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "crearInforme"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosCrearInforme});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (javax.activation.DataHandler) _resp;
            } catch (java.lang.Exception _exception) {
                return (javax.activation.DataHandler) org.apache.axis.utils.JavaUtils.convert(_resp, javax.activation.DataHandler.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void crearInformeRepositorio() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("crearInformeRepositorio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "crearInformeRepositorio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void crearInformesPortada() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("crearInformesPortada");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "crearInformesPortada"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO[] informeCoberturaCurricular(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeCoberturaCurricular");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeCoberturaCurricular"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeCoberturaCurricularVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[] informeEstadoOdes(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeEstadoOdes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeEstadoOdes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[] informeEstadoOdesTransicciones(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeEstadoOdesTransicciones");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeEstadoOdesTransicciones"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeEstadoOdesVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO[] informeLicenciasOdes(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeLicenciasOdes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeLicenciasOdes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeLicenciasOdesVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeMasVO[] informeMasDescargados(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeMasDescargados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasDescargados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeMasVO[] informeMasMostrado(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeMasMostrado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasMostrado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeMasPesadosVO[] informeMasPesados(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeMasPesados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasPesados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeMasPesadosVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeMasPesadosVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeMasPesadosVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeMasVO[] informeMasPrevisualizados(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeMasPrevisualizados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasPrevisualizados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeMasValoradoVO[] informeMasValorado(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeMasValorado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasValorado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeMasValoradoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeMasValoradoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeMasValoradoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeMasVO[] informeMasVisualizados(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeMasVisualizados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeMasVisualizados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeMasVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeMasVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO[] informeNivelAgregacion(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeNivelAgregacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeNivelAgregacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeNivelAgregacionVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[] informeOdeUsuario(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametroInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOdeUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdeUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametroInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[] informeOdeUsuarioOperacion(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOdeUsuarioOperacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdeUsuarioOperacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeOdeUsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeOperacionVO[] informeOperacionesRealizadas(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametroInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOperacionesRealizadas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOperacionesRealizadas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametroInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeOperacionVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeOperacionVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeOperacionVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO[] informeOperacionUsuario(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOperacionUsuario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOperacionUsuario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeOperacionUsuarioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO[] informeProcesosPlanificados(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeProcesosPlanificados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeProcesosPlanificados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeProcesoPlanificadoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO[] informeTerminosBusqueda(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametrosInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeTerminosBusqueda");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeTerminosBusqueda"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametrosInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeTerminoBusquedaVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.auditoria.servicios.InformeUsuariosVO[] informeUsuarios(es.pode.soporte.auditoria.servicios.ParametrosInformeVO parametroInformeVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeUsuarios");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeUsuarios"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametroInformeVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.InformeUsuariosVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.InformeUsuariosVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.InformeUsuariosVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] obtenerInformes() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerInformes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "obtenerInformes"));

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

    public void registrarBusqueda(es.pode.soporte.auditoria.servicios.BusquedaVO busqueda) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("registrarBusqueda");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarBusqueda"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {busqueda});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void registrarOperacion(es.pode.soporte.auditoria.servicios.OperacionVO operacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("registrarOperacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarOperacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {operacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Long registrarTrabajoFechaFinPlan(es.pode.soporte.auditoria.servicios.TareaEjecutadaPlanVO trabajo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("registrarTrabajoFechaFinPlan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoFechaFinPlan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {trabajo});

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

    public java.lang.Long registrarTrabajoHijoPlan(es.pode.soporte.auditoria.servicios.RegistroTareaEjecPlanVO trabajoHijo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("registrarTrabajoHijoPlan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoHijoPlan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {trabajoHijo});

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

    public java.lang.Long registrarTrabajoInterrPlan() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("registrarTrabajoInterrPlan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoInterrPlan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

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

    public java.lang.Long registrarTrabajoPlan(es.pode.soporte.auditoria.servicios.TareaEjecutadaPlanVO trabajo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("registrarTrabajoPlan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "registrarTrabajoPlan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {trabajo});

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

    public es.pode.soporte.auditoria.servicios.RepositorioVO[] repositorio() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("repositorio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "repositorio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.auditoria.servicios.RepositorioVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.auditoria.servicios.RepositorioVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.auditoria.servicios.RepositorioVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
