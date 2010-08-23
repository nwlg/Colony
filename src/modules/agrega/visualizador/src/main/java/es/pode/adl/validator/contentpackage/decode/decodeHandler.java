/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

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
package es.pode.adl.validator.contentpackage.decode;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 *
 * <strong>Filename:</strong><br>decodeHandler.java<br><br>
 *
 * <strong>Description:</strong><br>
 * A <code>decodeHandler</code> provides the ability to decode Unicode encoded
 * characters from the form %xy into their ASCII equivalents.<br><br>
 * 
 * @author ADL Technical Team
 */
public class decodeHandler
{
	/**
	* Logger object used for debug logging.
	*/
   private Logger mLogger;
   
   /**
   * The filename to be decoded.
   */
   private String mEncodedFileName;
   
   /**
    * The decoded filename.
    */
    private String mDecodedFileName;

   /**
   * The encoding in which the filename should be decoded.
   */
   private String mEncoding;
   
   /**
    * Constructor for the <code>decodeHandler</code> class.
    *
    * @param iEncodedFileName FileName to be decoded.
    * @param iEncoding The encoding in which the filename should be decoded.
    */
   public decodeHandler(String iEncodedFileName, String iEncoding)
   {
      setFileName( iEncodedFileName );
      setEncoding( iEncoding );
   }

   /**
    * Set the filename of the file to be decoded.
    *
    * @param iEncodedFileName FileName to be decoded.
    */
   private void setFileName(String iEncodedFileName)
   {
	   try
	   {
		   mEncodedFileName = iEncodedFileName;
	   }
	   catch ( NullPointerException npe )
	   {
	      npe.printStackTrace();
	   }     
   }

   /**
    * Set the encoding in which the filename should be decoded.
    *
    * @param iFileNameEncoding The encoding of the filename.
    *
    */
   private void setEncoding( String iFileNameEncoding )
   {
      try
      {
    	  mEncoding = iFileNameEncoding;
      }
      catch ( NullPointerException npe )
      {
         npe.printStackTrace();
      }
   }

   /**
    * Returns the decoded filename
    *
    * @return String The decoded filename containing decoded ASCII characters.
    */
   public String getDecodedFileName()
   {
      return mDecodedFileName;
   }
   
    /**
     *     
     * Decodes the filename to its ASCII equivalent
     */
	public void decodeName()
  	{	   
	   int index = -1;	   
	   String charCode = "";
	   int intCode;
	   char decodedCharacter;
	   String sectionOne = "";
	   String sectionTwo = "";
	   String decodedString = "";	
	   
	   String encodedFileName = new String ( mEncodedFileName );
	   String encoding = new String ( mEncoding );
	   
	   // Determine if an encoded character exists
	   index = mEncodedFileName.indexOf("%");	   
	   
	   int nameLength = encodedFileName.length();
	   
	   if ( index > -1)
	   {		   
		   // An encoded character is containing within the filename
		   for (int i = 0; i < nameLength; i++)
		   {
			   if ( encodedFileName.charAt(i) == '%')
			   {
				   // String section before encoded character
				   sectionOne = encodedFileName.substring(0, i);
				   // String section after encoded character 
				   sectionTwo = encodedFileName.substring(i+3, encodedFileName.length());
				   
				   // Obtain character code from string
				   charCode = encodedFileName.substring(i + 1, i + 3);
				   charCode = charCode.toLowerCase();			   
				  
				   // Decode the character to its ASCII string equivalent
				   intCode = Integer.parseInt(charCode, 16);		   
				   decodedCharacter = (char)intCode;
				   decodedString = new Character( decodedCharacter ).toString();
				   
				   // Reassemble the filename with the decoded character
				   encodedFileName = sectionOne + decodedString + sectionTwo;		   
				   		 
				   // Check for further encoded characters
				   nameLength = nameLength - 2;				   
			   }
		   }
	   }
	   try
	   {
		  // Encode the newly decoded string in its given encoding 
	      byte[] byteString = (new String(encodedFileName)).getBytes(encoding);
	      encodedFileName = new String(byteString, encoding);
	      mDecodedFileName = new String( encodedFileName );
	      
	   }
	   catch(UnsupportedEncodingException uee)
	   {
		   mLogger.severe("UnsupportedEncodingException thrown while " + "decoding the file path.");
	          uee.printStackTrace();
	   }
	} 		
}