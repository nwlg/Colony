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

package es.pode.adl.datamodels;

import es.pode.adl.datamodels.ieee.SCORM_2004_DM;
import es.pode.adl.datamodels.nav.SCORM_2004_NAV_DM;


/**
 *
 * <strong>Filename:</strong> DMFactory.java<br><br>
 *
 * <strong>Description:</strong><br><br> Factory pattern used to create datamodel
 *                                        objects based on a value passed in 
 *                                        during runtime
 *
 * <strong>Design Issues:</strong><br><br>
 *
 * <strong>Implementation Issues:</strong><br><br>
 *
 * <strong>Known Problems:</strong><br><br>
 *
 * <strong>Side Effects:</strong><br><br>
 *
 * <strong>References:</strong><br>
 * <ul>
 *     <li>SCORM 1.2
 *     <li>SCORM 2004
 * </ul>
 *
 * @author ADL Technical Team
 */
public class DMFactory
{

   /**
    * Enumeration of the run-time data model's supported by the SCORM<br>
    * <br>Unknown
    * <br><b>-1</b>
    * <br><br>[DATA MODEL IMPLEMENTATION CONSTANT]
    */
   public static final int DM_UNKNOWN                =   -1;

   /**
    * Enumeration of the run-time data model's supported by the SCORM<br>
    * <br>SCORM 2004 Data Model
    * <br><b>1</b>
    * <br><br>[DATA MODEL IMPLEMENTATION CONSTANT]
    */
   public static final int DM_SCORM_2004             =    1;


   /**
    * Enumeration of the run-time data model's supported by the SCORM<br>
    * <br>SCORM 2004 Navigation Data Model
    * <br><b>2</b>
    * <br><br>[DATA MODEL IMPLEMENTATION CONSTANT]
    */
   public static final int DM_SCORM_NAV              =    2;

   /**
    * Enumeration of the run-time data model's supported by the SCORM<br>
    * <br>IMS SSP Data Model
    * <br><b>3</b>
    * <br><br>[DATA MODEL IMPLEMENTATION CONSTANT]
    */
   public static final int DM_SSP                    =    3;

   /**
    * Builds the appropriate datamodel based on the type requested.
    * 
    * @param iType enumerated type of datamodel element
    * <br>
    * <ul>
    *    <li>SCORM 2004 DM = 1</li>
    *    <li>SCORM NAV = 2</li>
    *    <li>IMS SSP = 3</li>
    * </ul>
    * 
    * @return The appropriate datamodel.
    */
   public static DataModel createDM(int iType)
   {
      DataModel dm = null;

      switch ( iType )
      {
         case DM_SCORM_2004:
         {
            dm = new SCORM_2004_DM();
            break;
         }
         case DM_SCORM_NAV:
         {
            dm = new SCORM_2004_NAV_DM();
            break;
         }
//         case DM_SSP:
//         {
//            dm = new SSP_DataModel();
//            break;
//         }
         default:
         {
            // Do nothing -- this is an error
         }
      }
      return dm;
   }

} // end DMFactory
