/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * SrvBuscadorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;

public interface SrvBuscadorService extends java.rmi.Remote {

    /**

     */
    public es.pode.soporte.buscador.servicios.DocumentosVO busquedaAvanzada(es.pode.soporte.buscador.servicios.ParamAvanzadoVO paramBusq) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.buscador.servicios.DocumentosVO busquedaDocsNodoArbolCurricular(es.pode.soporte.buscador.servicios.ParamNodoArbolCurricularVO paramBusq) throws java.rmi.RemoteException;

    /**
     * Este metodo busca los ODEs indexados en todos los indices que
     * cumplan las condiciones de busqueda que le pasan como parametro.
     *                 Las fechas desde y hasta se interpretan inclusives
     * y en el caso
     *                 de no estar presentes, sin limite superior o inferior.
     */
    public es.pode.soporte.buscador.servicios.ResultadoHeaderVO[] busquedaHeadersRepositorio(es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO paramBusq) throws java.rmi.RemoteException;

    /**
     * Este metodo tiene que buscar los resultados que ajusten a los
     * parametros de busqueda. Ordena los resultados y los devuelve
     *                 convertidos en un texto LOM-ES.
     */
    public es.pode.soporte.buscador.servicios.DocumentosLOM_ESVO busquedaLOM_ES(es.pode.soporte.buscador.servicios.QuerySimpleVO paramBusq) throws java.rmi.RemoteException;

    /**
     * Este metodo realiza una busqueda utilizando el identificador
     * MEC
     *                 de un ODE como parametro de busqueda.
     *                 En el caso de encontrar un resultado, devuelve un
     * VO con la
     *                 coleccion de caracteristicas que describen el ODE.
     * En el caso de
     *                 no encontrar ningun resultado, no devuelve nada.
     */
    public es.pode.soporte.buscador.servicios.DocVO busquedaMEC(java.lang.String identificadorMEC, java.lang.String idiomaBusqueda) throws java.rmi.RemoteException;

    /**
     * Este metodo busca el identificador en todo el repositorio del
     * indexador.
     */
    public es.pode.soporte.buscador.servicios.ResultadoRecordVO busquedaMECRepositorio(java.lang.String idMEC) throws java.rmi.RemoteException;

    /**
     * Metodo que ejecuta una busqueda en todo el repositorio con
     * los
     *                 parametros de busqueda que le pasan.
     */
    public es.pode.soporte.buscador.servicios.ResultadoRecordVO[] busquedaRepositorio(es.pode.soporte.buscador.servicios.ParamPeriodoRepositorioVO paramBusq) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.buscador.servicios.DocumentosVO busquedaSimple(es.pode.soporte.buscador.servicios.ParamSimpleVO paramBusq) throws java.rmi.RemoteException;

    /**
     * Este metodo devuelve la fecha del ODE mas viejo indexado en
     * el
     *                 repositorio.
     */
    public java.util.Calendar fechaInicioRepositorio() throws java.rmi.RemoteException;

    /**
     * Este metodo busca un ODE al azar de dentro del repositorio.
     */
    public es.pode.soporte.buscador.servicios.DocVO obtenerODERandom() throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO obtenerPalabrasClave(es.pode.soporte.buscador.servicios.ParamPalabrasClave paramBusq) throws java.rmi.RemoteException;

    /**

     */
    public es.pode.soporte.buscador.servicios.ResultadosCountVO solicitudDocsCount(es.pode.soporte.buscador.servicios.ParamDocsCountVO paramBusq) throws java.rmi.RemoteException;
}
