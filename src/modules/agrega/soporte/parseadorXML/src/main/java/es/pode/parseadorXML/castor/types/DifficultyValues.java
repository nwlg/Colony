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
 * Class DifficultyValues.
 * 
 * @version $Revision$ $Date$
 */
public class DifficultyValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The very easy type
     */
    public static final int VERY_EASY_TYPE = 0;

    /**
     * The instance of the very easy type
     */
    public static final DifficultyValues VERY_EASY = new DifficultyValues(VERY_EASY_TYPE, "very easy");

    /**
     * The easy type
     */
    public static final int EASY_TYPE = 1;

    /**
     * The instance of the easy type
     */
    public static final DifficultyValues EASY = new DifficultyValues(EASY_TYPE, "easy");

    /**
     * The medium type
     */
    public static final int MEDIUM_TYPE = 2;

    /**
     * The instance of the medium type
     */
    public static final DifficultyValues MEDIUM = new DifficultyValues(MEDIUM_TYPE, "medium");

    /**
     * The difficult type
     */
    public static final int DIFFICULT_TYPE = 3;

    /**
     * The instance of the difficult type
     */
    public static final DifficultyValues DIFFICULT = new DifficultyValues(DIFFICULT_TYPE, "difficult");

    /**
     * The very difficult type
     */
    public static final int VERY_DIFFICULT_TYPE = 4;

    /**
     * The instance of the very difficult type
     */
    public static final DifficultyValues VERY_DIFFICULT = new DifficultyValues(VERY_DIFFICULT_TYPE, "very difficult");

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

    private DifficultyValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of DifficultyValues
     * 
     * @return an Enumeration over all possible instances of
     * DifficultyValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this DifficultyValues
     * 
     * @return the type of this DifficultyValues
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
        members.put("very easy", VERY_EASY);
        members.put("easy", EASY);
        members.put("medium", MEDIUM);
        members.put("difficult", DIFFICULT);
        members.put("very difficult", VERY_DIFFICULT);
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
     * DifficultyValues
     * 
     * @return the String representation of this DifficultyValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new DifficultyValues based on the
     * given String value.
     * 
     * @param string
     * @return the DifficultyValues value of parameter 'string'
     */
    public static es.pode.parseadorXML.castor.types.DifficultyValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid DifficultyValues";
            throw new IllegalArgumentException(err);
        }
        return (DifficultyValues) obj;
    }

}
