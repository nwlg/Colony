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
 * Class PurposeValues.
 * 
 * @version $Revision$ $Date$
 */
public class PurposeValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The discipline type
     */
    public static final int DISCIPLINE_TYPE = 0;

    /**
     * The instance of the discipline type
     */
    public static final PurposeValues DISCIPLINE = new PurposeValues(DISCIPLINE_TYPE, "discipline");

    /**
     * The idea type
     */
    public static final int IDEA_TYPE = 1;

    /**
     * The instance of the idea type
     */
    public static final PurposeValues IDEA = new PurposeValues(IDEA_TYPE, "idea");

    /**
     * The prerequisite type
     */
    public static final int PREREQUISITE_TYPE = 2;

    /**
     * The instance of the prerequisite type
     */
    public static final PurposeValues PREREQUISITE = new PurposeValues(PREREQUISITE_TYPE, "prerequisite");

    /**
     * The educational objective type
     */
    public static final int EDUCATIONAL_OBJECTIVE_TYPE = 3;

    /**
     * The instance of the educational objective type
     */
    public static final PurposeValues EDUCATIONAL_OBJECTIVE = new PurposeValues(EDUCATIONAL_OBJECTIVE_TYPE, "educational objective");

    /**
     * The accessibility restrictions type
     */
    public static final int ACCESSIBILITY_RESTRICTIONS_TYPE = 4;

    /**
     * The instance of the accessibility restrictions type
     */
    public static final PurposeValues ACCESSIBILITY_RESTRICTIONS = new PurposeValues(ACCESSIBILITY_RESTRICTIONS_TYPE, "accessibility restrictions");

    /**
     * The educational level type
     */
    public static final int EDUCATIONAL_LEVEL_TYPE = 5;

    /**
     * The instance of the educational level type
     */
    public static final PurposeValues EDUCATIONAL_LEVEL = new PurposeValues(EDUCATIONAL_LEVEL_TYPE, "educational level");

    /**
     * The skill level type
     */
    public static final int SKILL_LEVEL_TYPE = 6;

    /**
     * The instance of the skill level type
     */
    public static final PurposeValues SKILL_LEVEL = new PurposeValues(SKILL_LEVEL_TYPE, "skill level");

    /**
     * The security level type
     */
    public static final int SECURITY_LEVEL_TYPE = 7;

    /**
     * The instance of the security level type
     */
    public static final PurposeValues SECURITY_LEVEL = new PurposeValues(SECURITY_LEVEL_TYPE, "security level");

    /**
     * The competency type
     */
    public static final int COMPETENCY_TYPE = 8;

    /**
     * The instance of the competency type
     */
    public static final PurposeValues COMPETENCY = new PurposeValues(COMPETENCY_TYPE, "competency");

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

    private PurposeValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of PurposeValues
     * 
     * @return an Enumeration over all possible instances of
     * PurposeValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this PurposeValues
     * 
     * @return the type of this PurposeValues
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
        members.put("discipline", DISCIPLINE);
        members.put("idea", IDEA);
        members.put("prerequisite", PREREQUISITE);
        members.put("educational objective", EDUCATIONAL_OBJECTIVE);
        members.put("accessibility restrictions", ACCESSIBILITY_RESTRICTIONS);
        members.put("educational level", EDUCATIONAL_LEVEL);
        members.put("skill level", SKILL_LEVEL);
        members.put("security level", SECURITY_LEVEL);
        members.put("competency", COMPETENCY);
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
     * PurposeValues
     * 
     * @return the String representation of this PurposeValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new PurposeValues based on the
     * given String value.
     * 
     * @param string
     * @return the PurposeValues value of parameter 'string'
     */
    public static es.pode.parseadorXML.castor.types.PurposeValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid PurposeValues";
            throw new IllegalArgumentException(err);
        }
        return (PurposeValues) obj;
    }

}
