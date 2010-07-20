/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvAuditoriaFederadaServicioSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.auditoria.negocio.servicios;

public class SrvAuditoriaFederadaServicioSoapBindingStub extends org.apache.axis.client.Stub implements es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaImportService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("coberturaFederadoLocal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeCoberturaFederadoVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "coberturaFederadoLocalReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeCoberturaFederado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeCoberturaFederadoVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeCoberturaFederadoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeNivelAgregacionFederado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeAgregacionFederadaVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeNivelAgregacionFederadoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOdesIdiomaFederado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdesIdiomaFederadoVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdesIdiomaFederadoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOdesIdiomaLocal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdesIdiomaFederadoVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdesIdiomaLocalReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informeOdesPublicadosFederado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdesPublicadosFederadaVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdesPublicadosFederadoReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nivelAgregacionFederadoLocal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeAgregacionFederadaVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "nivelAgregacionFederadoLocalReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("odesPublicadosFederadoLocal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "parametros"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO"), es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdesPublicadosFederadaVO"));
        oper.setReturnClass(es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "odesPublicadosFederadoLocalReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

    }

    public SrvAuditoriaFederadaServicioSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SrvAuditoriaFederadaServicioSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
         this.cachedEndpoint = endpointURL;
    }

    public SrvAuditoriaFederadaServicioSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfCoberturaCurricularContenido");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.CoberturaCurricularContenido[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "CoberturaCurricularContenido");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeAgregacionFederadaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeAgregacionFederadaVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeCoberturaFederadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeCoberturaFederadoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdesIdiomaFederadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdesIdiomaFederadoVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfInformeOdesPublicadosFederadaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdesPublicadosFederadaVO");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfNivelAgregacionContenido");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.NivelAgregacionContenido[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "NivelAgregacionContenido");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ArrayOfOdesPorIdioma");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.OdesPorIdioma[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "OdesPorIdioma");
            qName2 = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "CoberturaCurricularContenido");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.CoberturaCurricularContenido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeAgregacionFederadaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeCoberturaFederadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdesIdiomaFederadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "InformeOdesPublicadosFederadaVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "NivelAgregacionContenido");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.NivelAgregacionContenido.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "OdesPorIdioma");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.OdesPorIdioma.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "ParametrosInformeFederadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO.class;
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

    public es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO coberturaFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("coberturaFederadoLocal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "coberturaFederadoLocal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[] informeCoberturaFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeCoberturaFederado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeCoberturaFederado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[] informeNivelAgregacionFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeNivelAgregacionFederado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeNivelAgregacionFederado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[] informeOdesIdiomaFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOdesIdiomaFederado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdesIdiomaFederado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO informeOdesIdiomaLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOdesIdiomaLocal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdesIdiomaLocal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[] informeOdesPublicadosFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("informeOdesPublicadosFederado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "informeOdesPublicadosFederado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO nivelAgregacionFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("nivelAgregacionFederadoLocal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "nivelAgregacionFederadoLocal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO odesPublicadosFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("odesPublicadosFederadoLocal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://servicios.negocio.auditoria.pode.es", "odesPublicadosFederadoLocal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parametros});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
