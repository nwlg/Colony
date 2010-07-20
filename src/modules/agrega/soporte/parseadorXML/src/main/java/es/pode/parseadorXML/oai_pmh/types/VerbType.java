/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_pmh.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class VerbType.
 * 
 * @version $Revision$ $Date$
 */
public class VerbType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Identify type
     */
    public static final int IDENTIFY_TYPE = 0;

    /**
     * The instance of the Identify type
     */
    public static final VerbType IDENTIFY = new VerbType(IDENTIFY_TYPE, "Identify");

    /**
     * The ListMetadataFormats type
     */
    public static final int LISTMETADATAFORMATS_TYPE = 1;

    /**
     * The instance of the ListMetadataFormats type
     */
    public static final VerbType LISTMETADATAFORMATS = new VerbType(LISTMETADATAFORMATS_TYPE, "ListMetadataFormats");

    /**
     * The ListSets type
     */
    public static final int LISTSETS_TYPE = 2;

    /**
     * The instance of the ListSets type
     */
    public static final VerbType LISTSETS = new VerbType(LISTSETS_TYPE, "ListSets");

    /**
     * The GetRecord type
     */
    public static final int GETRECORD_TYPE = 3;

    /**
     * The instance of the GetRecord type
     */
    public static final VerbType GETRECORD = new VerbType(GETRECORD_TYPE, "GetRecord");

    /**
     * The ListIdentifiers type
     */
    public static final int LISTIDENTIFIERS_TYPE = 4;

    /**
     * The instance of the ListIdentifiers type
     */
    public static final VerbType LISTIDENTIFIERS = new VerbType(LISTIDENTIFIERS_TYPE, "ListIdentifiers");

    /**
     * The ListRecords type
     */
    public static final int LISTRECORDS_TYPE = 5;

    /**
     * The instance of the ListRecords type
     */
    public static final VerbType LISTRECORDS = new VerbType(LISTRECORDS_TYPE, "ListRecords");

    /**
     * Field _memberTable.
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type.
     */
    private int type = -1;

    /**
     * Field stringValue.
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private VerbType(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of VerbType
     * 
     * @return an Enumeration over all possible instances of VerbTyp
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this VerbType
     * 
     * @return the type of this VerbType
     */
    public int getType(
    ) {
        return this.type;
    }

    /**
     * Method init.
     * 
     * @return the initialized Hashtable for the member table
     */
    private static java.util.Hashtable init(
    ) {
        Hashtable members = new Hashtable();
        members.put("Identify", IDENTIFY);
        members.put("ListMetadataFormats", LISTMETADATAFORMATS);
        members.put("ListSets", LISTSETS);
        members.put("GetRecord", GETRECORD);
        members.put("ListIdentifiers", LISTIDENTIFIERS);
        members.put("ListRecords", LISTRECORDS);
        return members;
    }

    /**
     * Method readResolve. will be called during deserialization to
     * replace the deserialized object with the correct constant
     * instance.
     * 
     * @return this deserialized object
     */
    private java.lang.Object readResolve(
    ) {
        return valueOf(this.stringValue);
    }

    /**
     * Method toString.Returns the String representation of this
     * VerbType
     * 
     * @return the String representation of this VerbType
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new VerbType based on the given
     * String value.
     * 
     * @param string
     * @return the VerbType value of parameter 'string'
     */
    public static es.pode.parseadorXML.oai_pmh.types.VerbType valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid VerbType";
            throw new IllegalArgumentException(err);
        }
        return (VerbType) obj;
    }

}
