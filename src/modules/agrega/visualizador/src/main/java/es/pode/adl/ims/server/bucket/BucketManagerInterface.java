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

/**
 * Describes an interface for managing buckets.
 * 
 * @author ADL Technical Team
 */
public interface BucketManagerInterface
{
   /**
    *
    * Updates the bucket to put a block of data in the bucket, starting at the
    * end of the current data.
    *
    * @param ibucketID - The identifier of the bucket.
    * @param iData - The data to be stored in this bucket.
    * @param iBucketAllocation - The bucket allocation information.
    *
    * @return - Status or result information about the outcome of this call.
    */
   StatusInfo appendData( String ibucketID, byte[] iData, BucketAllocation iBucketAllocation );

   /**
    *
    * Retrieves all data currently stored in the bucket
    *
    * @param iBucketID - The identifier of the bucket.
    * @param oData - The data stored in this bucket.
    * @param iBucketAllocation - The bucket allocation information.
    *
    * @return - Status or result information about the outcome of this call.
    */
   StatusInfo getData( String iBucketID, byte[] oData, BucketAllocation iBucketAllocation );

   /**
    *
    * Retrieves the specified amount of data starting at the specified offset
    * position.
    *
    * @param iBucketID - The identifier of the bucket.
    * @param iOffset - The position in the bucket to start reading.
    * @param iSize - The amount of data requested.
    * @param oData - The specified data stored in this bucket starting at the
    *                specified offset position.
    * @param iBucketAllocation - The bucket allocation information.
    *
    * @return - Status or result information about the outcome of this call.
    */
   StatusInfo getData( String iBucketID, int iOffset, int iSize,
                              byte[] oData, BucketAllocation iBucketAllocation );

   /**
    *
    * Retrieves the current state of the bucket.
    *
    * @param iBucketID - The identifier of the bucket.
    * @param oState - The current state of the bucket.
    * @param iBucketAllocation - The bucket allocation information.
    *
    * @return - Status or result information about the outcome of this call.
    */
   StatusInfo getState( String iBucketID, BucketState oState, BucketAllocation iBucketAllocation );

   /**
    *
    * Updates the bucket to put a block of data in the bucket, replacing all
    * data currently stored in the bucket
    *
    * @param iBucketID - The identifier of the bucket.
    * @param iData - The data to be stored in this bucket.
    * @param iBucketAllocation - The bucket allocation information.
    *
    * @return - Status or result information about the outcome of this call.
    */
   StatusInfo setData( String iBucketID, byte[] iData, BucketAllocation iBucketAllocation );

   /**
    *
    * Updates the bucket to put a block of data in the bucket, replacing any
    * data currently stored in the bucket starting at the specified offset
    * position.
    *
    * @param iBucketID - The identifier of the bucket.
    * @param iOffset - The position in the bucket to start reading.
    * @param iData - The data to be stored in this bucket.
    * @param iBucketAllocation - The bucket allocation information.
    *
    * @return - Status or result information about the outcome of this call.
    */
   StatusInfo setData( String iBucketID, int iOffset, byte[] iData, BucketAllocation iBucketAllocation );
}
