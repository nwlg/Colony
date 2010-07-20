/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvSQIService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.buscar.negocio.sqi.interfaz;

public interface SrvSQIService extends java.rmi.Remote {

    /**
     * Este metodo permite realizar ejecuciones de queries en modo
     * asincrono, de manera que el API devuelve los resultados de la
     *                 query cuando termine de ejecutar la busqueda.
     *                 Este metodo esta en sintonia con setSourceLocation,
     * el cual se
     *                 tiene que ejecutar antes para suministar la localizacion
     * donde
     *                 se van a devolver los resutlados de la query.
     */
    public void asynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.String queryID) throws java.rmi.RemoteException;

    /**

     */
    public java.lang.Boolean estasActivo() throws java.rmi.RemoteException;

    /**
     * Este metodo devuelve el numero total de resultados disponibles
     * para una query.
     *                 Recibe como parametro el identificador de la sesion
     * sobre la que
     *                 se realiza la operacion y la query de la que se quiere
     * saber
     *                 cuantos resultados dispobibles hay.
     *                 Si la query ya se ha ejecutado, intentamos averiguar
     * dicha
     *                 informacion sin necesidad de ejecutarla.
     */
    public java.lang.Integer getTotalResultsCount(java.lang.String targetSessionID, java.lang.String queryStatement) throws java.rmi.RemoteException;

    /**
     * Este metodo permite establecer un timeout para las consultas
     * asincronas.
     */
    public void setMaxDuration(java.lang.String targetSessionID, java.lang.Integer maxDuration) throws java.rmi.RemoteException;

    /**
     * Este metodo define el maximo numero de resultados que una query
     * puede producir.
     */
    public void setMaxQueryResults(java.lang.String targetSessionID, java.lang.Integer maxQueryResults) throws java.rmi.RemoteException;

    /**
     * Este metodo permite al invocador controlar la sintaxis a
     *                 utilizar en la sentencia de consulta mediante la identificacion
     * del lenguaje de consulta.
     *                 En nuestro caso, estaremos limitados a una coleccion
     * de
     *                 lenguajes.
     */
    public void setQueryLanguage(java.lang.String targetSessionID, java.lang.String queryLanguageID) throws java.rmi.RemoteException;

    /**
     * Este metodo permite especificar el formato del result set que
     * se
     *                 devuelve como resulado de la ejecucion de una query.
     * Este
     *                 parametro se define como una URI al esquema de como
     * se quieren
     *                 los resulados o como un valor predefinido.
     */
    public void setResultsFormat(java.lang.String targetSessionID, java.lang.String resultsFormat) throws java.rmi.RemoteException;

    /**
     * Este metodo define el numero maximo de resultados que se van
     * a
     *                 devolver en un result set.
     */
    public void setResultsSetSize(java.lang.String targetSessionID, java.lang.Integer resultsSetSize) throws java.rmi.RemoteException;

    /**
     * Este metodo recoge la localizacion del usuario del API al que
     * debemos devolver los resultados de una query ejecutada
     *                 asincronamente.
     *                 Este metodo se tiene que ejecutar por parte del cliente
     * del api
     *                 antes de la ejecucion del la query de forma asincrona.
     */
    public void setSourceLocation(java.lang.String targetSessionID, java.lang.String sourceLocation) throws java.rmi.RemoteException;

    /**
     * Este metodo realiza la query que se le pasa sobre la sesion
     * que
     *                 indica. Recoge los resulados que genera y los devuelve
     * teniendo
     *                 en cuenta el numero maximo de resultados para una
     * query, el
     *                 numero de resultados de un result set y el indice
     * del resultado
     *                 a partir del cual se esta interesado.
     *                 Se devuelve el resultado de la consulta.
     */
    public java.lang.String synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult) throws java.rmi.RemoteException;
}
