/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvSesionesServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.buscar.negocio.sqi.sesion;

public interface SrvSesionesServiceService extends javax.xml.rpc.Service {

/**
 * Este servicio implementa la administracion de las sesiones que
 *             hay que mantener en el DRI para dar soporte a la funcionalidad
 * de SQI.
 *             Se trata de un servicio local.
 */
    public java.lang.String getSrvSesionesServiceAddress();

    public es.pode.buscar.negocio.sqi.sesion.SrvSesionesService getSrvSesionesService() throws javax.xml.rpc.ServiceException;

    public es.pode.buscar.negocio.sqi.sesion.SrvSesionesService getSrvSesionesService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
