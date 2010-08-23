/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvBuscadorServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;

import org.apache.log4j.Logger;

import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class SrvBuscadorServiceServiceLocator extends org.apache.axis.client.Service implements es.pode.soporte.buscador.servicios.SrvBuscadorServiceService {

/**
 * Este servicio implementa la funcionalidad de busqueda de odes
 *             sobre los odes indexados.
 */

    public SrvBuscadorServiceServiceLocator() {
    }


    public SrvBuscadorServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SrvBuscadorServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SrvBuscadorService
    private java.lang.String SrvBuscadorService_address = "http://localhost:"+LdapUserDetailsUtils.getPortServices()+LdapUserDetailsUtils.getSubdominioServices()+"/indexador/services/SrvBuscadorService";
   // private java.lang.String SrvBuscadorService_address = "http://localhost:8080/indexador-0.1/services/SrvBuscadorService";

    public java.lang.String getSrvBuscadorServiceAddress() {
        return SrvBuscadorService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SrvBuscadorServiceWSDDServiceName = "SrvBuscadorService";

    public java.lang.String getSrvBuscadorServiceWSDDServiceName() {
        return SrvBuscadorServiceWSDDServiceName;
    }

    public void setSrvBuscadorServiceWSDDServiceName(java.lang.String name) {
        SrvBuscadorServiceWSDDServiceName = name;
    }

    public es.pode.soporte.buscador.servicios.SrvBuscadorService getSrvBuscadorService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
        	if(Logger.getLogger(SrvBuscadorServiceServiceLocator.class).isDebugEnabled())Logger.getLogger(SrvBuscadorServiceServiceLocator.class).debug("SrvBuscadorService_address=["+SrvBuscadorService_address+"]");
            endpoint = new java.net.URL(SrvBuscadorService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        if(Logger.getLogger(SrvBuscadorServiceServiceLocator.class).isDebugEnabled())Logger.getLogger(SrvBuscadorServiceServiceLocator.class).debug("2SrvBuscadorService_address=["+SrvBuscadorService_address+"] endpoint="+endpoint);
        
        return getSrvBuscadorService(endpoint);
    }

    public es.pode.soporte.buscador.servicios.SrvBuscadorService getSrvBuscadorService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.pode.soporte.buscador.servicios.SrvBuscadorServiceSoapBindingStub _stub = new es.pode.soporte.buscador.servicios.SrvBuscadorServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSrvBuscadorServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSrvBuscadorServiceEndpointAddress(java.lang.String address) {
        SrvBuscadorService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.pode.soporte.buscador.servicios.SrvBuscadorService.class.isAssignableFrom(serviceEndpointInterface)) {
                es.pode.soporte.buscador.servicios.SrvBuscadorServiceSoapBindingStub _stub = new es.pode.soporte.buscador.servicios.SrvBuscadorServiceSoapBindingStub(new java.net.URL(SrvBuscadorService_address), this);
                _stub.setPortName(getSrvBuscadorServiceWSDDServiceName());
                return _stub;
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
        if ("SrvBuscadorService".equals(inputPortName)) {
            return getSrvBuscadorService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "SrvBuscadorServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "SrvBuscadorService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SrvBuscadorService".equals(portName)) {
            setSrvBuscadorServiceEndpointAddress(address);
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
