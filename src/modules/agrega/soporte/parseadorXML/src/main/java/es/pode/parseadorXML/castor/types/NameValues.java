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
 * Class NameValues.
 * 
 * @version $Revision$ $Date$
 */
public class NameValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The pc-dos type
     */
    public static final int PC_DOS_TYPE = 0;

    /**
     * The instance of the pc-dos type
     */
    public static final NameValues PC_DOS = new NameValues(PC_DOS_TYPE, "pc-dos");

    /**
     * The ms-windows type
     */
    public static final int MS_WINDOWS_TYPE = 1;

    /**
     * The instance of the ms-windows type
     */
    public static final NameValues MS_WINDOWS = new NameValues(MS_WINDOWS_TYPE, "ms-windows");

    /**
     * The macos type
     */
    public static final int MACOS_TYPE = 2;

    /**
     * The instance of the macos type
     */
    public static final NameValues MACOS = new NameValues(MACOS_TYPE, "macos");

    /**
     * The unix type
     */
    public static final int UNIX_TYPE = 3;

    /**
     * The instance of the unix type
     */
    public static final NameValues UNIX = new NameValues(UNIX_TYPE, "unix");

    /**
     * The multi-os type
     */
    public static final int MULTI_OS_TYPE = 4;

    /**
     * The instance of the multi-os type
     */
    public static final NameValues MULTI_OS = new NameValues(MULTI_OS_TYPE, "multi-os");

    /**
     * The none type
     */
    public static final int NONE_TYPE = 5;

    /**
     * The instance of the none type
     */
    public static final NameValues NONE = new NameValues(NONE_TYPE, "none");

    /**
     * The any type
     */
    public static final int ANY_TYPE = 6;

    /**
     * The instance of the any type
     */
    public static final NameValues ANY = new NameValues(ANY_TYPE, "any");

    /**
     * The netscape communicator type
     */
    public static final int NETSCAPE_COMMUNICATOR_TYPE = 7;

    /**
     * The instance of the netscape communicator type
     */
    public static final NameValues NETSCAPE_COMMUNICATOR = new NameValues(NETSCAPE_COMMUNICATOR_TYPE, "netscape communicator");

    /**
     * The ms-internet explorer type
     */
    public static final int MS_INTERNET_EXPLORER_TYPE = 8;

    /**
     * The instance of the ms-internet explorer type
     */
    public static final NameValues MS_INTERNET_EXPLORER = new NameValues(MS_INTERNET_EXPLORER_TYPE, "ms-internet explorer");

    /**
     * The opera type
     */
    public static final int OPERA_TYPE = 9;

    /**
     * The instance of the opera type
     */
    public static final NameValues OPERA = new NameValues(OPERA_TYPE, "opera");

    /**
     * The amaya type
     */
    public static final int AMAYA_TYPE = 10;

    /**
     * The instance of the amaya type
     */
    public static final NameValues AMAYA = new NameValues(AMAYA_TYPE, "amaya");

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

    private NameValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of NameValues
     * 
     * @return an Enumeration over all possible instances of
     * NameValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this NameValues
     * 
     * @return the type of this NameValues
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
        members.put("pc-dos", PC_DOS);
        members.put("ms-windows", MS_WINDOWS);
        members.put("macos", MACOS);
        members.put("unix", UNIX);
        members.put("multi-os", MULTI_OS);
        members.put("none", NONE);
        members.put("any", ANY);
        members.put("netscape communicator", NETSCAPE_COMMUNICATOR);
        members.put("ms-internet explorer", MS_INTERNET_EXPLORER);
        members.put("opera", OPERA);
        members.put("amaya", AMAYA);
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
     * NameValues
     * 
     * @return the String representation of this NameValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new NameValues based on the given
     * String value.
     * 
     * @param string
     * @return the NameValues value of parameter 'string'
     */
    public static es.pode.parseadorXML.castor.types.NameValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid NameValues";
            throw new IllegalArgumentException(err);
        }
        return (NameValues) obj;
    }

}
