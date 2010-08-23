/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvBuscarFederadaServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.buscar.negocio.federada.servicios;

import java.rmi.Remote;

public class SrvBuscarFederadaServiceServiceLocator extends org.apache.axis.client.Service implements es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceService {

/**

 */

    public SrvBuscarFederadaServiceServiceLocator() {
    }


    public SrvBuscarFederadaServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SrvBuscarFederadaServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SrvBuscarFederadaService
    private java.lang.String SrvBuscarFederadaService_address = "";

    public java.lang.String getSrvBuscarFederadaServiceAddress() {
        return SrvBuscarFederadaService_address;
    }

    public void setSrvBuscarFederadaServiceAddress(String srvBuscarFederadaService_address) {
        this.SrvBuscarFederadaService_address = srvBuscarFederadaService_address;
    }
    
    // The WSDD service name defaults to the port name.
    private java.lang.String SrvBuscarFederadaServiceWSDDServiceName = "SrvBuscarFederadaService";

    public java.lang.String getSrvBuscarFederadaServiceWSDDServiceName() {
        return SrvBuscarFederadaServiceWSDDServiceName;
    }

    public void setSrvBuscarFederadaServiceWSDDServiceName(java.lang.String name) {
        SrvBuscarFederadaServiceWSDDServiceName = name;
    }

    public es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaImportService getSrvBuscarFederadaService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SrvBuscarFederadaService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSrvBuscarFederadaService(endpoint);
    }

    public es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaImportService getSrvBuscarFederadaService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceSoapBindingStub _stub = new es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSrvBuscarFederadaServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSrvBuscarFederadaServiceEndpointAddress(java.lang.String address) {
        SrvBuscarFederadaService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {   
            if (es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService.class.isAssignableFrom(serviceEndpointInterface)) {
                es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceSoapBindingStub _stub = new es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceSoapBindingStub(new java.net.URL(SrvBuscarFederadaService_address), this);
                _stub.setPortName(getSrvBuscarFederadaServiceWSDDServiceName());
                return (Remote) _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SrvBuscarFederadaService".equals(inputPortName)) {
            return (Remote) getSrvBuscarFederadaService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "SrvBuscarFederadaServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios.federada.negocio.buscar.pode.es", "SrvBuscarFederadaService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SrvBuscarFederadaService".equals(portName)) {
            setSrvBuscarFederadaServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
