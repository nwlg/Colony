/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*******************************************************************************
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
*******************************************************************************/

package es.pode.adl.sequencer;

/**
 * <strong>Filename:</strong> SeqActivityTrackingAccess.java<br><br>
 * 
 * <strong>Description:</strong><br>
 * This interface provides common accessor methods to the nodes of an
 * activity tree.  During the internal sequencing processes, the sequencer may
 * request information from activities in the current context (the currently
 * active branch of the activity tree) to perform sequencing behaviors.<br><br>
 * 
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the 
 * SCORM 2004 3rd Edition Sample RTE. <br>
 * <br>
 * 
 * <strong>Implementation Issues:</strong><br>
 * It is the responsibility of the requester to utilize any information
 * provided to establish sequencing behaviors as described in the IMS SS
 * Specification.<br><br>
 * 
 * <strong>Known Problems:</strong><br>
 * 
 * <strong>Side Effects:</strong><br>
 * 
 * <strong>References:</strong><br>
 * <ul>
 *     <li>IMS SS 1.0</li>
 *     <li>SCORM 2004 3rd Edition</li>
 * </ul>
 * 
 * @author ADL Technical Team
 */
abstract class SeqActivityTrackingAccess
{

   /**
    * Retrieves the attempt status of this activity.
    * 
    * @return <code>true</code> if the activity has been attempted, otherwise,
    *         <code>false</code>.
    */
   abstract boolean getActivityAttempted();


   /**
    * Retrieves the current attempt's progress status.
    *
    * @param iRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return <code>true</code> if the current attempt on the activity is
    *         completed, otherwise <code>false</code>.
    */
   abstract boolean getAttemptCompleted(boolean iRetry);


   /**
    * Set the current attempt's progress status to the desired value.<br><br>
    * Valid values are: <code>unknown</code>, <code>completed</code>, and
    * <code>incomplete</code>.
    * 
    * @param iProgress New value for the attempt's progress status.
    *
    * @return <code>true</code> if the progress status of the activty changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean setProgress(String iProgress);

   /**
    * Determines if the current attempt's progress status is valid.
    * 
    * @param iRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return <code>true</code> if the progress status of the current attempt
    *         is valid, otherwise <code>false</code>.
    */
   abstract boolean getProgressStatus(boolean iRetry);

   /**
    * Retreives the designated objective's minimum measure value.<br><br>
    * 
    * @param iObjID ID of the objective whose minimum measure is desired.
    * 
    * @return The measure of the designated objective, or <code>-1.0</code>
    *         if no minimum measure is defined.
    */
   abstract double getObjMinMeasure(String iObjID);

   /**
    * Retreives the primary objective's minimum measure value.<br><br>
    * 
    * @return The measure of the designated objective, or <code>-1.0</code>
    *         if no minimum measure is defined.
    
    */
   abstract double getObjMinMeasure();

   /**
    * Indicates if the designated objective's measure value is valid.
    * 
    * @param iObjID   ID of the objective whose measure is desired.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return <code>true</code> if the designated objective's measure is valid,
    *         otherwise <code>false</code>.
    */
   abstract boolean getObjMeasureStatus(String iObjID, boolean iIsRetry);

   /**
    * Indicates if the primary objective's measure value is valid.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    *
    * @return <code>true</code> if the designated objective's measure is valid,
    *         otherwise <code>false</code>.
    */
   abstract boolean getObjMeasureStatus(boolean iIsRetry);

   /**
    * Clears the value of the primary objective's measure.
    *
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean clearObjMeasure();

   /**
    * Clears the value of the desintated objective's measure.
    * 
    * @param iObjID      ID of the objective whose measure has changed.
    *
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean clearObjMeasure(String iObjID);

   /**
    * Sets the primary objective's measure to the desired value.
    * 
    * @param iMeasure    The value of the objective's measure.
    *
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean setObjMeasure(double iMeasure);

   /**
    * Sets the designated objective's measure to the desired value.
    * 
    * @param iObjID      ID of the objective whose measure has changed.
    * 
    * @param iMeasure    The value of the objective's measure.
    * 
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean setObjMeasure(String iObjID, double iMeasure);


   /**
    * Retreives the designated objective's measure value.<br><br>
    * <b>NOTE:</b> the value returned has no signifigance unless the
    * objective's measure status is <code>true</code>.
    * 
    * @param iObjID   ID of the objective whose measure is desired.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return The measure of the designated objective.
    */
   abstract double getObjMeasure(String iObjID, boolean iIsRetry);

   /**
    * Retreives the primary objective's measure value.<br><br>
    * <b>NOTE:</b> the value returned has no signifigance unless the
    * objective's measure status is <code>true</code>.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return The measure of the primary objective.
    */
   abstract double getObjMeasure(boolean iIsRetry);

   /**
    * Determines if the designated objective's progress status is valid.
    * 
    * @param iObjID   ID of the objective.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return <code>true</code> if the designated objective's progress status is
    *         valid, otherwise <code>false</code>.
    */
   abstract boolean getObjStatus(String iObjID, boolean iIsRetry);

   /**
    * Determines if the primary objective's progress status is valid.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return <code>true</code> if the primary objective's progress status is
    *         valid, otherwise <code>false</code>.
    */
   abstract boolean getObjStatus(boolean iIsRetry);

   /**
    * Set the designated objective's status to the desired value.
    * 
    * @param iObjID  ID of the objective whose satisfaction has changed.
    * 
    * @param iStatus New value for the objective's satisfaction status.<br><br>
    *                Valid values are: <code>unknown</code>,
    *                <code>satisfied</code>, or <code>notsatisfied</code>.
    *
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean setObjSatisfied(String iObjID, String iStatus);

   /**
    * Set the primary objective's status to the desired value.
    * 
    * @param iStatus New value for the objective's satisfaction status.<br><br>
    *                Valid values are: <code>unknown</code>,
    *                <code>satisfied</code>, or <code>notsatisfied</code>.
    * 
    * @return <code>true</code> if the satisfaction of the objective changed,
    *         otherwise <code>false</code>.
    */
   abstract boolean setObjSatisfied(String iStatus);

   /**
    * Retrieves the designated objective's status.
    * 
    * @param iObjID   ID of the objective.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    * 
    * @return <code>true</code> if the designated objective is satisfied
    *         otherwise <code>false</code>.
    */
   abstract boolean getObjSatisfied(String iObjID, boolean iIsRetry);

   /**
    * Retrieves the primary objective's status.
    * 
    * @param iIsRetry Indicates if this evaluation is occuring during the
    *                 processing of a 'retry' sequencing request.
    *
    * @return <code>true</code> if the primary objective is satisfied
    *         otherwise <code>false</code>.
    */
   abstract boolean getObjSatisfied(boolean iIsRetry);

   /**
    * Determines if the activity's primary objective is satisfied by measure.
    * 
    * @return <code>true</code> if the primary objective is satisfied by
    *         measure, otherwise <code>false</code>
    */
   abstract boolean getObjSatisfiedByMeasure();

   /**
    * Sets the designated objective's experienced duration for the current
    * attempt.
    * 
    * @param iDur   The experienced duration of the current attempt on the
    *               activity.
    */
   abstract void setCurAttemptExDur(ADLDuration iDur);

   /**
    * Increment the attempt count for this activity by one.
    */
   abstract void incrementAttempt();

   /**
    * Reset this activity's attempt count.
    */ 
   abstract void resetNumAttempt();

   /**
    * Retrieve this activity's attempt count.
    * 
    * @return A <code>long</code> value indicating the number attempts on this
    *         activity.
    */
   abstract long getNumAttempt();


}  // end SeqActivityTrackingAcces
