/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.castor.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class KindValues.
 * 
 * @version $Revision$ $Date$
 */
public class KindValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The ispartof type
     */
    public static final int ISPARTOF_TYPE = 0;

    /**
     * The instance of the ispartof type
     */
    public static final KindValues ISPARTOF = new KindValues(ISPARTOF_TYPE, "ispartof");

    /**
     * The haspart type
     */
    public static final int HASPART_TYPE = 1;

    /**
     * The instance of the haspart type
     */
    public static final KindValues HASPART = new KindValues(HASPART_TYPE, "haspart");

    /**
     * The isversionof type
     */
    public static final int ISVERSIONOF_TYPE = 2;

    /**
     * The instance of the isversionof type
     */
    public static final KindValues ISVERSIONOF = new KindValues(ISVERSIONOF_TYPE, "isversionof");

    /**
     * The hasversion type
     */
    public static final int HASVERSION_TYPE = 3;

    /**
     * The instance of the hasversion type
     */
    public static final KindValues HASVERSION = new KindValues(HASVERSION_TYPE, "hasversion");

    /**
     * The isformatof type
     */
    public static final int ISFORMATOF_TYPE = 4;

    /**
     * The instance of the isformatof type
     */
    public static final KindValues ISFORMATOF = new KindValues(ISFORMATOF_TYPE, "isformatof");

    /**
     * The hasformat type
     */
    public static final int HASFORMAT_TYPE = 5;

    /**
     * The instance of the hasformat type
     */
    public static final KindValues HASFORMAT = new KindValues(HASFORMAT_TYPE, "hasformat");

    /**
     * The references type
     */
    public static final int REFERENCES_TYPE = 6;

    /**
     * The instance of the references type
     */
    public static final KindValues REFERENCES = new KindValues(REFERENCES_TYPE, "references");

    /**
     * The isreferencedby type
     */
    public static final int ISREFERENCEDBY_TYPE = 7;

    /**
     * The instance of the isreferencedby type
     */
    public static final KindValues ISREFERENCEDBY = new KindValues(ISREFERENCEDBY_TYPE, "isreferencedby");

    /**
     * The isbasedon type
     */
    public static final int ISBASEDON_TYPE = 8;

    /**
     * The instance of the isbasedon type
     */
    public static final KindValues ISBASEDON = new KindValues(ISBASEDON_TYPE, "isbasedon");

    /**
     * The isbasisfor type
     */
    public static final int ISBASISFOR_TYPE = 9;

    /**
     * The instance of the isbasisfor type
     */
    public static final KindValues ISBASISFOR = new KindValues(ISBASISFOR_TYPE, "isbasisfor");

    /**
     * The requires type
     */
    public static final int REQUIRES_TYPE = 10;

    /**
     * The instance of the requires type
     */
    public static final KindValues REQUIRES = new KindValues(REQUIRES_TYPE, "requires");

    /**
     * The isrequiredby type
     */
    public static final int ISREQUIREDBY_TYPE = 11;

    /**
     * The instance of the isrequiredby type
     */
    public static final KindValues ISREQUIREDBY = new KindValues(ISREQUIREDBY_TYPE, "isrequiredby");

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

    private KindValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of KindValues
     * 
     * @return an Enumeration over all possible instances of
     * KindValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this KindValues
     * 
     * @return the type of this KindValues
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
        members.put("ispartof", ISPARTOF);
        members.put("haspart", HASPART);
        members.put("isversionof", ISVERSIONOF);
        members.put("hasversion", HASVERSION);
        members.put("isformatof", ISFORMATOF);
        members.put("hasformat", HASFORMAT);
        members.put("references", REFERENCES);
        members.put("isreferencedby", ISREFERENCEDBY);
        members.put("isbasedon", ISBASEDON);
        members.put("isbasisfor", ISBASISFOR);
        members.put("requires", REQUIRES);
        members.put("isrequiredby", ISREQUIREDBY);
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
     * KindValues
     * 
     * @return the String representation of this KindValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new KindValues based on the given
     * String value.
     * 
     * @param string
     * @return the KindValues value of parameter 'string'
     */
    public static es.pode.parseadorXML.castor.types.KindValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid KindValues";
            throw new IllegalArgumentException(err);
        }
        return (KindValues) obj;
    }

}
