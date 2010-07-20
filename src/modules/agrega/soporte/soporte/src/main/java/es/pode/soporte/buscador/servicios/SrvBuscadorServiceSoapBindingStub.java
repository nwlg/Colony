/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvBuscadorServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;

public class SrvBuscadorServiceSoapBindingStub extends org.apache.axis.client.Stub implements es.pode.soporte.buscador.servicios.SrvBuscadorService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[12];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaAvanzada");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamAvanzadoVO"), es.pode.soporte.buscador.servicios.ParamAvanzadoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.DocumentosVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaAvanzadaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaDocsNodoArbolCurricular");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamNodoArbolCurricularVO"), es.pode.soporte.buscador.servicios.ParamNodoArbolCurricularVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.DocumentosVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaDocsNodoArbolCurricularReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaHeadersRepositorio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamPeriodoRepositorioVO"), es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfResultadoHeaderVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.ResultadoHeaderVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaHeadersRepositorioReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaLOM_ES");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "QuerySimpleVO"), es.pode.soporte.buscador.servicios.QuerySimpleVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosLOM_ESVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaLOM_ESReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaMEC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "identificadorMEC"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idiomaBusqueda"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.DocVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaMECReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaMECRepositorio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idMEC"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadoRecordVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.ResultadoRecordVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaMECRepositorioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaRepositorio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamPeriodoRepositorioVO"), es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfResultadoRecordVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.ResultadoRecordVO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaRepositorioReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("busquedaSimple");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamSimpleVO"), es.pode.soporte.buscador.servicios.ParamSimpleVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.DocumentosVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaSimpleReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("fechaInicioRepositorio");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        oper.setReturnClass(java.util.Calendar.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "fechaInicioRepositorioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerODERandom");
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.DocVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "obtenerODERandomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerPalabrasClave");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamPalabrasClave"), es.pode.soporte.buscador.servicios.ParamPalabrasClave.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "PrioridadPalabrasClaveVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "obtenerPalabrasClaveReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("solicitudDocsCount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "paramBusq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamDocsCountVO"), es.pode.soporte.buscador.servicios.ParamDocsCountVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadosCountVO"));
        oper.setReturnClass(es.pode.soporte.buscador.servicios.ResultadosCountVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "solicitudDocsCountReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

    }

    public SrvBuscadorServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SrvBuscadorServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SrvBuscadorServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfDocLOM_ESVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.DocLOM_ESVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocLOM_ESVO");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfDocVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.DocVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocVO");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfPalabraClaveVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.PalabraClaveVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "PalabraClaveVO");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfResultadoHeaderVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ResultadoHeaderVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadoHeaderVO");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfResultadoRecordVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ResultadoRecordVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadoRecordVO");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfsoapenc_int");
            cachedSerQNames.add(qName);
            cls = java.lang.Integer[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfTaxonVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.TaxonVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "TaxonVO");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ArrayOfxsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocLOM_ESVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.DocLOM_ESVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosLOM_ESVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocumentosVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.DocumentosVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "DocVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.DocVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "PalabraClaveVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.PalabraClaveVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamAvanzadoVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ParamAvanzadoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamDocsCountVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ParamDocsCountVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamNodoArbolCurricularVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ParamNodoArbolCurricularVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamPalabrasClave");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ParamPalabrasClave.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamPeriodoRepositorioVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ParamSimpleVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ParamSimpleVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "PrioridadPalabrasClaveVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "QuerySimpleVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.QuerySimpleVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadoHeaderVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ResultadoHeaderVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadoRecordVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ResultadoRecordVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadosCountVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.ResultadosCountVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "TaxonVO");
            cachedSerQNames.add(qName);
            cls = es.pode.soporte.buscador.servicios.TaxonVO.class;
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

    public es.pode.soporte.buscador.servicios.DocumentosVO busquedaAvanzada(es.pode.soporte.buscador.servicios.ParamAvanzadoVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaAvanzada");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaAvanzada"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.DocumentosVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.DocumentosVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.DocumentosVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.DocumentosVO busquedaDocsNodoArbolCurricular(es.pode.soporte.buscador.servicios.ParamNodoArbolCurricularVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaDocsNodoArbolCurricular");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaDocsNodoArbolCurricular"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.DocumentosVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.DocumentosVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.DocumentosVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.ResultadoHeaderVO[] busquedaHeadersRepositorio(es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaHeadersRepositorio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaHeadersRepositorio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.ResultadoHeaderVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.ResultadoHeaderVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.ResultadoHeaderVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO busquedaLOM_ES(es.pode.soporte.buscador.servicios.QuerySimpleVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaLOM_ES");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaLOM_ES"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.DocVO busquedaMEC(java.lang.String identificadorMEC, java.lang.String idiomaBusqueda) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaMEC");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaMEC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identificadorMEC, idiomaBusqueda});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.DocVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.DocVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.DocVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.ResultadoRecordVO busquedaMECRepositorio(java.lang.String idMEC) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaMECRepositorio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaMECRepositorio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {idMEC});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.ResultadoRecordVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.ResultadoRecordVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.ResultadoRecordVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.ResultadoRecordVO[] busquedaRepositorio(es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaRepositorio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaRepositorio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.ResultadoRecordVO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.ResultadoRecordVO[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.ResultadoRecordVO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.DocumentosVO busquedaSimple(es.pode.soporte.buscador.servicios.ParamSimpleVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("busquedaSimple");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "busquedaSimple"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.DocumentosVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.DocumentosVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.DocumentosVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.util.Calendar fechaInicioRepositorio() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("fechaInicioRepositorio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "fechaInicioRepositorio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.util.Calendar) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.util.Calendar) org.apache.axis.utils.JavaUtils.convert(_resp, java.util.Calendar.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.DocVO obtenerODERandom() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerODERandom");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "obtenerODERandom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.DocVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.DocVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.DocVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO obtenerPalabrasClave(es.pode.soporte.buscador.servicios.ParamPalabrasClave paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("obtenerPalabrasClave");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "obtenerPalabrasClave"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.pode.soporte.buscador.servicios.ResultadosCountVO solicitudDocsCount(es.pode.soporte.buscador.servicios.ParamDocsCountVO paramBusq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("solicitudDocsCount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "solicitudDocsCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paramBusq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.pode.soporte.buscador.servicios.ResultadosCountVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.pode.soporte.buscador.servicios.ResultadosCountVO) org.apache.axis.utils.JavaUtils.convert(_resp, es.pode.soporte.buscador.servicios.ResultadosCountVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
