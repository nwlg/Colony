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
*******************************************************************************/
package es.pode.adl.ims.server.bucket;

import java.io.Serializable;

/**
 * Defines the success of a bucket allocation and provides a reference to the
 * underlying bucket object through the mBucketID atribute.
 * <br><br>
 *
 * <strong>Filename:</strong> ManagedBucket.java<br><br>
 *
 * <strong>Description:</strong><br>
 * 
 * Defines the success of a bucket allocation and provides a reference to the
 * underlying bucket object through the mBucketID atribute.
 * <br><br>
 *
 * <strong>Design Issues:</strong><br>
 * This implementation is intended to be used by the SCORM 2004 3rd Edition
 * Sample RTE. <br>
 * <br>
 *
 * <strong>Implementation Issues:</strong><br><br>
 *
 * <strong>Known Problems:</strong><br><br>
 *
 * <strong>Side Effects:</strong><br><br>
 *
 * <strong>References:</strong><br>
 * <ul>
 *     <li>IMS SSP Specification
 *     <li>SCORM 2004 3rd Edition
 * </ul>
 *
 * @author ADL Technical Team
 */
public class ManagedBucket implements Serializable
{
   /**
    *
    * The ID of the bucket associated with this request.
    *
    */
   private String mBucketID = null;

   /**
    *
    * The allocation success status of the bucket.
    *
    */
   private int mSuccessStatus = SuccessStatus.NONE_REQUESTED;

   /**
    *
    * Default Constructor.
    *
    */
   public ManagedBucket()
   {
   }

   /**
    *
    * Constructor method.
    *
    * @param iBucketID - The data stored in this bucket.
    */
   public ManagedBucket( String iBucketID )
   {
      mBucketID = iBucketID;
   }

   /**
    *
    * Constructor method.
    *
    * @param iBucketID - The data stored in this bucket.
    * @param iSuccessStatus - The allocation success of the bucket.
    * 
    * @throws IllegalArgumentException Thrown if success status 
    *                                  value is not one of the
    *                                  enumerated values (0-3).
    */
   public ManagedBucket( String iBucketID, int iSuccessStatus )
      throws IllegalArgumentException
   {
      mBucketID = iBucketID;

      // The range for this enumerated value is 0 - 3 based on the
      // SuccessStatus enumeration class.  If the value is not in this range
      // throw an IllegalArgumentException.
      if( iSuccessStatus >= 4 )
      {
         throw new IllegalArgumentException(
            "The value provided for parameter (iSuccessStatus) is not in the " +
            "range of valid values provided in the SuccessStatus enumeration " +
            "class." );
      }
      mSuccessStatus = iSuccessStatus;
   }

   /**
    *
    * Stores the identifier of the bucket.
    *
    * @param iBucketID - The identifier of the bucket.
    */
   public void setBucketID( String iBucketID )
   {
      mBucketID = iBucketID;
   }

   /**
    *
    * Retrieves the identifier of the bucket.
    *
    * @return - The identifier of the bucket.
    */
   public String getBucketID()
   {
      return mBucketID;
   }

   /**
    *
    * Sets the allocation success of the bucket.
    *
    * @param iSuccessStatus - The allocation success of the bucket.  This value
    *                         shall be one of the enumerated values described in
    *                         the <code>SuccessStatus</code> class.
    * 
    * @throws IllegalArgumentException Thrown if success status 
    *                                  value is not one of the
    *                                  enumerated values (0-3).
    */
   public void setSuccessStatus( int iSuccessStatus )
      throws IllegalArgumentException
   {
      // The range for this enumerated value is 0 - 3 based on the
      // SuccessStatus enumeration class.  If the value is not in this range
      // throw an IllegalArgumentException.
      if( iSuccessStatus >= 4 )
      {
         throw new IllegalArgumentException(
            "The value provided for parameter (iSuccessStatus) is not in the " +
            "range of valid values provided in the SuccessStatus enumeration " +
            "class." );
      }

      mSuccessStatus = iSuccessStatus;
   }

   /**
    *
    * Retrieves the allocation success of the bucket.
    *
    * @return - The allocation success of the bucket based on the enumerated
    *           values described in the <code>SuccessStatus</code> class..
    */
   public int getSuccessStatus()
   {
      return mSuccessStatus;
   }
}
