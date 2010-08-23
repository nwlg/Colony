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
package es.pode.adl.util.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipException;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import es.pode.adl.debug.DebugIndicator;

/**
 *
 * <strong>Filename:</strong><br>UnZipHandler.java<br><br>
 *
 * <strong>Description:</strong><br>
 * A <code>UnZipHandler</code> provides the ability to extract the contents
 * of a zipped file to a given directory.<br><br>
 * 
 * <strong>Side Effects:</strong><br> The files will be extracted to the given
 * directory
 * 
 * @author ADL Technical Team
 */
public class UnZipHandler
{
   /**
    * Buffer size for use in extracting Zip File
    */
   public static final int BUFFER_SIZE = 16384;
   
   /**
    * A reference to the Zip File to be extracted
    */
   private File mZipFile;

   /**
    * The directory to which the Zip File will be extracted to
    */
   private String mExtractToDir;
   
   /**
    * Constructor for the <code>UnZipHandler</code> class.
    *
    * @param iZipFileName Name and path of the <code>.zip</code> file.
    * @param iTargetDirName Name and path of the directory to extract the 
    *                       contents of the Zip File to.
    */
   public UnZipHandler(String iZipFileName, String iTargetDirName )
   {
      setFile( iZipFileName );
      setTargetDirectory( iTargetDirName );
   }

   /**
    * Set the name and location of the Zip File to be extracted.
    *
    * @param iFileName Name and location of the Zip File to be extracted.
    */
   private void setFile(String iFileName)
   {
      try
      {
         mZipFile = new File( iFileName ); 
      }
      catch ( NullPointerException npe )
      {
         npe.printStackTrace();
      }
   }

   /**
    * Set the target directory of the extracted contents of the Zip File.
    *
    * @param iTargetDirPath The target directory of the extracted contents of 
    *                       the Zip File.
    *
    */
   private void setTargetDirectory( String iTargetDirPath )
   {
      try
      {
         mExtractToDir = iTargetDirPath;
      }
      catch ( NullPointerException npe )
      {
         npe.printStackTrace();
      }
   }

   /**
    * Returns the target directory of the extracted contents of the Zip 
    * File.
    *
    * @return target The target directory of the extracted contents of the Zip 
    *                File.
    */
   public String getTargetDirectory()
   {
      return mExtractToDir;
   }

   /**
    * Extracts the Zip File into the destination directory
    *
    */
   public boolean extract()
   {
      boolean result = true;
      String fileName = new String();
      String destFileName = new String();
      InputStream in = null;
      OutputStream out = null;      

      // Create a byte buffer
      byte[] buffer = new byte[BUFFER_SIZE];

      try
      {  
    	 ZipFile archive;
    	 
       // protect against the case that the user only installs the JRE
       // with no language support
       try
    	 {
    	    archive = new ZipFile( mZipFile, "CP437");
    	 }
    	 catch ( ZipException ZE )
    	 {
    		 archive = new ZipFile( mZipFile );
    	 }
    	 
         for ( Enumeration e = archive.getEntries(); e.hasMoreElements(); )
         {
            // Get the next entry in the Zip File
            ZipEntry entry = (ZipEntry)e.nextElement();

            if ( !entry.isDirectory() )
            {
               fileName = entry.getName();
               fileName = fileName.replace('/', File.separatorChar);

               destFileName = mExtractToDir + fileName;

               File destFile = new File(destFileName);

               // Create the destination path, if needed
               String parent = destFile.getParent();
               if ( parent != null )
               {
                  File parentFile = new File(parent);
                  if ( !parentFile.exists() )
                  {
                     // Create the chain of sub-directories to the file
                     parentFile.mkdirs();
                  }
               }

               // Get a stream of the archive entry's bytes
               in = archive.getInputStream(entry);

               // Open a stream to the destination file
               out = new FileOutputStream(destFileName);

               // Repeat reading into buffer and writing buffer to file,
               // until done.  Count will always be # bytes read, until
               // EOF when it is -1.
               int count;
               while ( (count = in.read(buffer)) != -1 )
               {
                  out.write(buffer, 0, count );
               }
               
               // Close the input stream and output stream
               in.close();
               out.close();
            }
         }
         archive.close();
      }
      catch ( ZipException ze )
      {
          result = false;
          if ( DebugIndicator.ON )
          {
             ze.printStackTrace(); 
          }          
      }
      catch ( NullPointerException npe )
      {
         result = false;
         if ( DebugIndicator.ON )
         {
            npe.printStackTrace(); 
         }
      }
      catch ( IOException ioe )
      {
         result = false;
         if ( DebugIndicator.ON )
         {
            ioe.printStackTrace(); 
         }
      }
      catch ( SecurityException se )
      {
         result = false;
         if ( DebugIndicator.ON )
         {
            se.printStackTrace(); 
         }
      }
      catch ( Exception e )
      {
         result = false;
         if ( DebugIndicator.ON )
         {
            e.printStackTrace(); 
         }
      }
      finally
      {
         // In case an exception is thrown prior to closing the input stream
         // and output stream, close the streams
         
         // Check to make sure the input stream has not been closed
         if (in != null)
         {
            try
            { 
               in.close();
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
         }

         // Check to make sure the output stream has not been closed
         if (out != null)
         {
            try
            {
               out.close();
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
         }        
      } // end finally
      
      return result;
      
   }  // end extract()
}