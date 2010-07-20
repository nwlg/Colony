/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/

/******************************************************************************
**
** Advanced Distributed Learning Co-Laboratory (ADL Co-Lab) Hub grants you 
** ("Licensee") a non-exclusive, royalty free, license to use, modify and 
** redistribute this software in source and binary code form, provided that 
** i) this copyright notice and license appear on all copies of the software; 
** and ii) Licensee does not utilize the software in a manner which is 
** disparaging to ADL Co-Lab Hub.
**
** This software is provided "AS IS," without a warranty of any kind.  ALL 
** EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING 
** ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE 
** OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED.  ADL Co-Lab Hub AND ITS LICENSORS 
** SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF 
** USING, MODIFYING OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES.  IN NO 
** EVENT WILL ADL Co-Lab Hub OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, 
** PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
** INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE 
** THEORY OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE 
** SOFTWARE, EVEN IF ADL Co-Lab Hub HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH 
** DAMAGES.
**
******************************************************************************/

package es.pode.adl.server;

import java.io.Serializable;

/**
 * Enumeration of abstract servlet request types.<br><br>
 * 
 * <strong>Filename:</strong> ServletRequestTypes.java<br><br>
 * 
 * <strong>References:</strong><br>
 * <ul>
 *     <li>SCORM 2004 3rd Edition
 * </ul>
 * 
 * @author ADL Technical Team
 */
public class ServletRequestTypes implements Serializable
{

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>GET_COURSES
    * <br><b>1</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int GET_COURSES       =  1;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>GET_SCOS
    * <br><b>2</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int GET_SCOS          =  2;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>GET_COMMENTS
    * <br><b>3</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int GET_COMMENTS      =  3;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>UPDATE_SCO
    * <br><b>4</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int UPDATE_SCO        =  4;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>GET_USERS
    * <br><b>5</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int GET_USERS         =  5;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>GET_PREF
    * <br><b>6</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int GET_PREF          =  6;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>UPDATE_PREF
    * <br><b>7</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int UPDATE_PREF       =  7;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>ADD_USERS
    * <br><b>8</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int ADD_USERS         =  8;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>DELETE_USERS
    * <br><b>9</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int DELETE_USERS      =  9;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>DELETE_COURSE
    * <br><b>10</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int DELETE_COURSE     =  10;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>REG_COURSE
    * <br><b>11</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int REG_COURSE        =  11;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>PROC_REG_COURSE
    * <br><b>12</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int PROC_REG_COURSE   =  12;
   
   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>VIEW_REG_COURSE
    * <br><b>13</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int VIEW_REG_COURSE   =  13;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>SELECT_MY_COURSE
    * <br><b>14</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int SELECT_MY_COURSE  =  14;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>VIEW_MY_STATUS
    * <br><b>15</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int VIEW_MY_STATUS    =  15;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>CLEAR_DB
    * <br><b>16</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int CLEAR_DB          =  16;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>NEW_OBJ
    * <br><b>17</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int NEW_OBJ           =  17;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>SELECT_OBJ_USER
    * <br><b>18</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int SELECT_OBJ_USER          =  18;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>ADD_OBJ
    * <br><b>19</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int ADD_OBJ           =  19;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>COURSE_OBJ
    * <br><b>20</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int COURSE_OBJ        =  20;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>OBJ_ADMIN
    * <br><b>21</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int OBJ_ADMIN         =  21;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>EDIT_OBJ
    * <br><b>22</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int EDIT_OBJ          =  22;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>IMPORT_COURSE
    * <br><b>23</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int IMPORT_COURSE     =  23;

    /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>NEW_USER
    * <br><b>24</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int NEW_USER          =  24;
   
   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>LIST_BUCKETS
    * <br><b>25</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int LIST_BUCKETS          =  25;
   
   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>ADD_BUCKET_REQ
    * <br><b>26</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int ADD_BUCKET_REQ          =  26;
   
   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>ADD_BUCKET
    * <br><b>27</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int ADD_BUCKET          =  27;
   
   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>DEL_BUCKET
    * <br><b>28</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int DELETE_BUCKET          =  28;

   /**
    * Enumeration of possible Servlet Request Types.<br>
    * <br>IMPORT_MULTIPLE_COURSES
    * <br><b>29</b>
    * <br><br>[SERVLET REQUEST TYPE CONSTANT]
    */
   public static final int IMPORT_MULTIPLE_COURSES     =  29;

} // end ServletRequestTypes