/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*******************************************************************************
** The Advanced Distributed Learning Co-Laboratory (ADL Co-Lab) Hub grants you
** ("Licensee") a non- exclusive, royalty free, license to use and redistribute
** this software in source and binary code form, provided that i) this copyright
** notice and license appear on all copies of the software; and ii) Licensee does
** not utilize the software in a manner which is disparaging to ADL Co-Lab Hub. 
**
** This software is provided "AS IS," without a warranty of any kind. ALL EXPRESS
** OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY IMPLIED
** WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NON-
** INFRINGEMENT, ARE HEREBY EXCLUDED. ADL Co-Lab Hub AND ITS LICENSORS SHALL NOT
** BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
** OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL ADL Co-Lab Hub
** OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
** INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED
** AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF OR
** INABILITY TO USE SOFTWARE, EVEN IF ADL Co-Lab Hub HAS BEEN ADVISED OF THE
** POSSIBILITY OF SUCH DAMAGES. 
******************************************************************************/
package es.pode.adl.validator.contentpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.pode.adl.validator.contentpackage.decode.decodeHandler;

/**
 * This class is responsible for holding any information that may be needed to 
 * launch scos
 *  
 * @author ADL Technical Team
 */
public class LaunchInfo
{   
   /**
    * Instance of the CheckerStateData.
    */
   private static LaunchInfo instance;
   
   /**
    * A List of SCOs to be possibly launched
    */
   private final List mSCOList = new ArrayList();
   
    /**
    * Constructor
    */
   private LaunchInfo()
   {
      //default Constructor
   }
   
   /**
    * Returns a protected instance of this class.
    * 
    * @return An instance of LaunchInfo.
    */
   public static LaunchInfo getInstance()
   {
      if(instance == null)
      {
         instance = new LaunchInfo();
      }
      return instance;
   }
   
   /**
    * Returns the SCO List
    * 
    * @return A List of the SCOs to be launched
    */
   public final List getSCOList()
   {
      return mSCOList;
   }
   
   /**
    * This method will add a new SCO to the SCO List
    * 
    * @param iResourceID - The identifier of the resource containing the SCO
    * @param iLaunchLine - The launch line of the SCO
    * @return - A boolean indicating the sucess of the insertion operation
    */
   public final boolean addSCO(String iResourceID, String iLaunchLine )
   {
      return mSCOList.add( new LaunchItem(iResourceID, iLaunchLine.split("[.]")[0]) );
   }
   
   /**
    * This method will attempt to find a resource identifier given its matching launch line
    * 
    * @param iLaunchLine - A String representing the launch line of the SCO
    * @return - A String containing the launch line's corresponding identifier
    */
   public final String getResourceID( String iLaunchLine )
   {
      Iterator listIter = mSCOList.iterator();
      
      while ( listIter.hasNext() )
      {
         LaunchItem tempItem = (LaunchItem)listIter.next();
         decodeHandler handler = new decodeHandler(tempItem.getLaunchLine(), "UTF-16");
         handler.decodeName();
         if ( handler.getDecodedFileName().equals(iLaunchLine) )
         {
            return tempItem.getResourceIdentifier();
         }
      }
      return "";
   }
   
   /**
    * This method will get a launch line given a resource identifier
    * 
    * @param iResourceID - A String representing the resource identifier
    * @return - A String containing the identifier's matching launch line
    */
   public final String getLaunchLine( String iResourceID )
   {
      Iterator listIter = mSCOList.iterator();
      while ( listIter.hasNext() )
      {
         LaunchItem tempLine = (LaunchItem)listIter.next();
         if ( tempLine.getResourceIdentifier().equals(iResourceID) )
         {
            return tempLine.getLaunchLine();
         }
      }
      return "";
   }
   
   /**
    * Clears the LaunchInfo object
    */
   public final void clearCollection()
   {
      instance = null;
   }
   
}