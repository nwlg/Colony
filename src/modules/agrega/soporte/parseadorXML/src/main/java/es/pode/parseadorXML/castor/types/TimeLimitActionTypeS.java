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
 * Class TimeLimitActionTypeS.
 * 
 * @version $Revision$ $Date$
 */
public class TimeLimitActionTypeS implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The exit,message type
     */
    public static final int EXIT_MESSAGE_TYPE = 0;

    /**
     * The instance of the exit,message type
     */
    public static final TimeLimitActionTypeS EXIT_MESSAGE = new TimeLimitActionTypeS(EXIT_MESSAGE_TYPE, "exit,message");

    /**
     * The exit,no message type
     */
    public static final int EXIT_NO_MESSAGE_TYPE = 1;

    /**
     * The instance of the exit,no message type
     */
    public static final TimeLimitActionTypeS EXIT_NO_MESSAGE = new TimeLimitActionTypeS(EXIT_NO_MESSAGE_TYPE, "exit,no message");

    /**
     * The continue,message type
     */
    public static final int CONTINUE_MESSAGE_TYPE = 2;

    /**
     * The instance of the continue,message type
     */
    public static final TimeLimitActionTypeS CONTINUE_MESSAGE = new TimeLimitActionTypeS(CONTINUE_MESSAGE_TYPE, "continue,message");

    /**
     * The continue,no message type
     */
    public static final int CONTINUE_NO_MESSAGE_TYPE = 3;

    /**
     * The instance of the continue,no message type
     */
    public static final TimeLimitActionTypeS CONTINUE_NO_MESSAGE = new TimeLimitActionTypeS(CONTINUE_NO_MESSAGE_TYPE, "continue,no message");

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

    private TimeLimitActionTypeS(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of TimeLimitActionTypeS
     * 
     * @return an Enumeration over all possible instances of
     * TimeLimitActionTypeS
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this TimeLimitActionTypeS
     * 
     * @return the type of this TimeLimitActionTypeS
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
        members.put("exit,message", EXIT_MESSAGE);
        members.put("exit,no message", EXIT_NO_MESSAGE);
        members.put("continue,message", CONTINUE_MESSAGE);
        members.put("continue,no message", CONTINUE_NO_MESSAGE);
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
     * TimeLimitActionTypeS
     * 
     * @return the String representation of this TimeLimitActionType
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new TimeLimitActionTypeS based on
     * the given String value.
     * 
     * @param string
     * @return the TimeLimitActionTypeS value of parameter 'string'
     */
    public static es.pode.parseadorXML.castor.types.TimeLimitActionTypeS valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid TimeLimitActionTypeS";
            throw new IllegalArgumentException(err);
        }
        return (TimeLimitActionTypeS) obj;
    }

}
