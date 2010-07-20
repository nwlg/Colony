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
 * Class RollupRuleConditionType.
 * 
 * @version $Revision$ $Date$
 */
public class RollupRuleConditionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The satisfied type
     */
    public static final int SATISFIED_TYPE = 0;

    /**
     * The instance of the satisfied type
     */
    public static final RollupRuleConditionType SATISFIED = new RollupRuleConditionType(SATISFIED_TYPE, "satisfied");

    /**
     * The objectiveStatusKnown type
     */
    public static final int OBJECTIVESTATUSKNOWN_TYPE = 1;

    /**
     * The instance of the objectiveStatusKnown type
     */
    public static final RollupRuleConditionType OBJECTIVESTATUSKNOWN = new RollupRuleConditionType(OBJECTIVESTATUSKNOWN_TYPE, "objectiveStatusKnown");

    /**
     * The objectiveMeasureKnown type
     */
    public static final int OBJECTIVEMEASUREKNOWN_TYPE = 2;

    /**
     * The instance of the objectiveMeasureKnown type
     */
    public static final RollupRuleConditionType OBJECTIVEMEASUREKNOWN = new RollupRuleConditionType(OBJECTIVEMEASUREKNOWN_TYPE, "objectiveMeasureKnown");

    /**
     * The completed type
     */
    public static final int COMPLETED_TYPE = 3;

    /**
     * The instance of the completed type
     */
    public static final RollupRuleConditionType COMPLETED = new RollupRuleConditionType(COMPLETED_TYPE, "completed");

    /**
     * The activityProgressKnown type
     */
    public static final int ACTIVITYPROGRESSKNOWN_TYPE = 4;

    /**
     * The instance of the activityProgressKnown type
     */
    public static final RollupRuleConditionType ACTIVITYPROGRESSKNOWN = new RollupRuleConditionType(ACTIVITYPROGRESSKNOWN_TYPE, "activityProgressKnown");

    /**
     * The attempted type
     */
    public static final int ATTEMPTED_TYPE = 5;

    /**
     * The instance of the attempted type
     */
    public static final RollupRuleConditionType ATTEMPTED = new RollupRuleConditionType(ATTEMPTED_TYPE, "attempted");

    /**
     * The attemptLimitExceeded type
     */
    public static final int ATTEMPTLIMITEXCEEDED_TYPE = 6;

    /**
     * The instance of the attemptLimitExceeded type
     */
    public static final RollupRuleConditionType ATTEMPTLIMITEXCEEDED = new RollupRuleConditionType(ATTEMPTLIMITEXCEEDED_TYPE, "attemptLimitExceeded");

    /**
     * The timeLimitExceeded type
     */
    public static final int TIMELIMITEXCEEDED_TYPE = 7;

    /**
     * The instance of the timeLimitExceeded type
     */
    public static final RollupRuleConditionType TIMELIMITEXCEEDED = new RollupRuleConditionType(TIMELIMITEXCEEDED_TYPE, "timeLimitExceeded");

    /**
     * The outsideAvailableTimeRange type
     */
    public static final int OUTSIDEAVAILABLETIMERANGE_TYPE = 8;

    /**
     * The instance of the outsideAvailableTimeRange type
     */
    public static final RollupRuleConditionType OUTSIDEAVAILABLETIMERANGE = new RollupRuleConditionType(OUTSIDEAVAILABLETIMERANGE_TYPE, "outsideAvailableTimeRange");

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

    private RollupRuleConditionType(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of RollupRuleConditionType
     * 
     * @return an Enumeration over all possible instances of
     * RollupRuleConditionType
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this
     * RollupRuleConditionType
     * 
     * @return the type of this RollupRuleConditionType
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
        members.put("satisfied", SATISFIED);
        members.put("objectiveStatusKnown", OBJECTIVESTATUSKNOWN);
        members.put("objectiveMeasureKnown", OBJECTIVEMEASUREKNOWN);
        members.put("completed", COMPLETED);
        members.put("activityProgressKnown", ACTIVITYPROGRESSKNOWN);
        members.put("attempted", ATTEMPTED);
        members.put("attemptLimitExceeded", ATTEMPTLIMITEXCEEDED);
        members.put("timeLimitExceeded", TIMELIMITEXCEEDED);
        members.put("outsideAvailableTimeRange", OUTSIDEAVAILABLETIMERANGE);
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
     * RollupRuleConditionType
     * 
     * @return the String representation of this
     * RollupRuleConditionType
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new RollupRuleConditionType based
     * on the given String value.
     * 
     * @param string
     * @return the RollupRuleConditionType value of parameter
     * 'string'
     */
    public static RollupRuleConditionType valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid RollupRuleConditionType";
            throw new IllegalArgumentException(err);
        }
        return (RollupRuleConditionType) obj;
    }

}
