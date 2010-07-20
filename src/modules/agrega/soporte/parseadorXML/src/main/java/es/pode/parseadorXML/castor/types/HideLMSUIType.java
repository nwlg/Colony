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
 * Class HideLMSUIType.
 * 
 * @version $Revision$ $Date$
 */
public class HideLMSUIType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The abandon type
     */
    public static final int ABANDON_TYPE = 0;

    /**
     * The instance of the abandon type
     */
    public static final HideLMSUIType ABANDON = new HideLMSUIType(ABANDON_TYPE, "abandon");

    /**
     * The continue type
     */
    public static final int CONTINUE_TYPE = 1;

    /**
     * The instance of the continue type
     */
    public static final HideLMSUIType CONTINUE = new HideLMSUIType(CONTINUE_TYPE, "continue");

    /**
     * The exit type
     */
    public static final int EXIT_TYPE = 2;

    /**
     * The instance of the exit type
     */
    public static final HideLMSUIType EXIT = new HideLMSUIType(EXIT_TYPE, "exit");

    /**
     * The previous type
     */
    public static final int PREVIOUS_TYPE = 3;

    /**
     * The instance of the previous type
     */
    public static final HideLMSUIType PREVIOUS = new HideLMSUIType(PREVIOUS_TYPE, "previous");

    /**
     * The suspendAll type
     */
    public static final int SUSPENDALL_TYPE = 4;

    /**
     * The instance of the suspendAll type
     */
    public static final HideLMSUIType SUSPENDALL = new HideLMSUIType(SUSPENDALL_TYPE, "suspendAll");

    /**
     * The exitAll type
     */
    public static final int EXITALL_TYPE = 5;

    /**
     * The instance of the exitAll type
     */
    public static final HideLMSUIType EXITALL = new HideLMSUIType(EXITALL_TYPE, "exitAll");

    /**
     * The abandonAll type
     */
    public static final int ABANDONALL_TYPE = 6;

    /**
     * The instance of the abandonAll type
     */
    public static final HideLMSUIType ABANDONALL = new HideLMSUIType(ABANDONALL_TYPE, "abandonAll");

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

    private HideLMSUIType(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of HideLMSUIType
     * 
     * @return an Enumeration over all possible instances of
     * HideLMSUIType
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this HideLMSUIType
     * 
     * @return the type of this HideLMSUIType
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
        members.put("abandon", ABANDON);
        members.put("continue", CONTINUE);
        members.put("exit", EXIT);
        members.put("previous", PREVIOUS);
        members.put("suspendAll", SUSPENDALL);
        members.put("exitAll", EXITALL);
        members.put("abandonAll", ABANDONALL);
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
     * HideLMSUIType
     * 
     * @return the String representation of this HideLMSUIType
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new HideLMSUIType based on the
     * given String value.
     * 
     * @param string
     * @return the HideLMSUIType value of parameter 'string'
     */
    public static HideLMSUIType valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid HideLMSUIType";
            throw new IllegalArgumentException(err);
        }
        return (HideLMSUIType) obj;
    }

}
