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
 * Class PostConditionRuleActionType.
 * 
 * @version $Revision$ $Date$
 */
public class PostConditionRuleActionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The exitParent type
     */
    public static final int EXITPARENT_TYPE = 0;

    /**
     * The instance of the exitParent type
     */
    public static final PostConditionRuleActionType EXITPARENT = new PostConditionRuleActionType(EXITPARENT_TYPE, "exitParent");

    /**
     * The exitAll type
     */
    public static final int EXITALL_TYPE = 1;

    /**
     * The instance of the exitAll type
     */
    public static final PostConditionRuleActionType EXITALL = new PostConditionRuleActionType(EXITALL_TYPE, "exitAll");

    /**
     * The retry type
     */
    public static final int RETRY_TYPE = 2;

    /**
     * The instance of the retry type
     */
    public static final PostConditionRuleActionType RETRY = new PostConditionRuleActionType(RETRY_TYPE, "retry");

    /**
     * The retryAll type
     */
    public static final int RETRYALL_TYPE = 3;

    /**
     * The instance of the retryAll type
     */
    public static final PostConditionRuleActionType RETRYALL = new PostConditionRuleActionType(RETRYALL_TYPE, "retryAll");

    /**
     * The continue type
     */
    public static final int CONTINUE_TYPE = 4;

    /**
     * The instance of the continue type
     */
    public static final PostConditionRuleActionType CONTINUE = new PostConditionRuleActionType(CONTINUE_TYPE, "continue");

    /**
     * The previous type
     */
    public static final int PREVIOUS_TYPE = 5;

    /**
     * The instance of the previous type
     */
    public static final PostConditionRuleActionType PREVIOUS = new PostConditionRuleActionType(PREVIOUS_TYPE, "previous");

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

    private PostConditionRuleActionType(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of PostConditionRuleActionType
     * 
     * @return an Enumeration over all possible instances of
     * PostConditionRuleActionType
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this
     * PostConditionRuleActionType
     * 
     * @return the type of this PostConditionRuleActionType
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
        members.put("exitParent", EXITPARENT);
        members.put("exitAll", EXITALL);
        members.put("retry", RETRY);
        members.put("retryAll", RETRYALL);
        members.put("continue", CONTINUE);
        members.put("previous", PREVIOUS);
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
     * PostConditionRuleActionType
     * 
     * @return the String representation of this
     * PostConditionRuleActionType
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new PostConditionRuleActionType
     * based on the given String value.
     * 
     * @param string
     * @return the PostConditionRuleActionType value of parameter
     * 'string'
     */
    public static PostConditionRuleActionType valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid PostConditionRuleActionType";
            throw new IllegalArgumentException(err);
        }
        return (PostConditionRuleActionType) obj;
    }

}
