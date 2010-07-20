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
 * Class CognitiveProcessValues.
 * 
 * @version $Revision$ $Date$
 */
public class CognitiveProcessValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The analyse type
     */
    public static final int ANALYSE_TYPE = 0;

    /**
     * The instance of the analyse type
     */
    public static final CognitiveProcessValues ANALYSE = new CognitiveProcessValues(ANALYSE_TYPE, "analyse");

    /**
     * The implement type
     */
    public static final int IMPLEMENT_TYPE = 1;

    /**
     * The instance of the implement type
     */
    public static final CognitiveProcessValues IMPLEMENT = new CognitiveProcessValues(IMPLEMENT_TYPE, "implement");

    /**
     * The collaborate type
     */
    public static final int COLLABORATE_TYPE = 2;

    /**
     * The instance of the collaborate type
     */
    public static final CognitiveProcessValues COLLABORATE = new CognitiveProcessValues(COLLABORATE_TYPE, "collaborate");

    /**
     * The compare type
     */
    public static final int COMPARE_TYPE = 3;

    /**
     * The instance of the compare type
     */
    public static final CognitiveProcessValues COMPARE = new CognitiveProcessValues(COMPARE_TYPE, "compare");

    /**
     * The share type
     */
    public static final int SHARE_TYPE = 4;

    /**
     * The instance of the share type
     */
    public static final CognitiveProcessValues SHARE = new CognitiveProcessValues(SHARE_TYPE, "share");

    /**
     * The compete type
     */
    public static final int COMPETE_TYPE = 5;

    /**
     * The instance of the compete type
     */
    public static final CognitiveProcessValues COMPETE = new CognitiveProcessValues(COMPETE_TYPE, "compete");

    /**
     * The understand type
     */
    public static final int UNDERSTAND_TYPE = 6;

    /**
     * The instance of the understand type
     */
    public static final CognitiveProcessValues UNDERSTAND = new CognitiveProcessValues(UNDERSTAND_TYPE, "understand");

    /**
     * The prove type
     */
    public static final int PROVE_TYPE = 7;

    /**
     * The instance of the prove type
     */
    public static final CognitiveProcessValues PROVE = new CognitiveProcessValues(PROVE_TYPE, "prove");

    /**
     * The communicate type
     */
    public static final int COMMUNICATE_TYPE = 8;

    /**
     * The instance of the communicate type
     */
    public static final CognitiveProcessValues COMMUNICATE = new CognitiveProcessValues(COMMUNICATE_TYPE, "communicate");

    /**
     * The contextualize type
     */
    public static final int CONTEXTUALIZE_TYPE = 9;

    /**
     * The instance of the contextualize type
     */
    public static final CognitiveProcessValues CONTEXTUALIZE = new CognitiveProcessValues(CONTEXTUALIZE_TYPE, "contextualize");

    /**
     * The control type
     */
    public static final int CONTROL_TYPE = 10;

    /**
     * The instance of the control type
     */
    public static final CognitiveProcessValues CONTROL = new CognitiveProcessValues(CONTROL_TYPE, "control");

    /**
     * The cooperate type
     */
    public static final int COOPERATE_TYPE = 11;

    /**
     * The instance of the cooperate type
     */
    public static final CognitiveProcessValues COOPERATE = new CognitiveProcessValues(COOPERATE_TYPE, "cooperate");

    /**
     * The create type
     */
    public static final int CREATE_TYPE = 12;

    /**
     * The instance of the create type
     */
    public static final CognitiveProcessValues CREATE = new CognitiveProcessValues(CREATE_TYPE, "create");

    /**
     * The decide type
     */
    public static final int DECIDE_TYPE = 13;

    /**
     * The instance of the decide type
     */
    public static final CognitiveProcessValues DECIDE = new CognitiveProcessValues(DECIDE_TYPE, "decide");

    /**
     * The define type
     */
    public static final int DEFINE_TYPE = 14;

    /**
     * The instance of the define type
     */
    public static final CognitiveProcessValues DEFINE = new CognitiveProcessValues(DEFINE_TYPE, "define");

    /**
     * The describe type
     */
    public static final int DESCRIBE_TYPE = 15;

    /**
     * The instance of the describe type
     */
    public static final CognitiveProcessValues DESCRIBE = new CognitiveProcessValues(DESCRIBE_TYPE, "describe");

    /**
     * The discuss type
     */
    public static final int DISCUSS_TYPE = 16;

    /**
     * The instance of the discuss type
     */
    public static final CognitiveProcessValues DISCUSS = new CognitiveProcessValues(DISCUSS_TYPE, "discuss");

    /**
     * The design type
     */
    public static final int DESIGN_TYPE = 17;

    /**
     * The instance of the design type
     */
    public static final CognitiveProcessValues DESIGN = new CognitiveProcessValues(DESIGN_TYPE, "design");

    /**
     * The self assessment type
     */
    public static final int SELF_ASSESSMENT_TYPE = 18;

    /**
     * The instance of the self assessment type
     */
    public static final CognitiveProcessValues SELF_ASSESSMENT = new CognitiveProcessValues(SELF_ASSESSMENT_TYPE, "self assessment");

    /**
     * The explain type
     */
    public static final int EXPLAIN_TYPE = 19;

    /**
     * The instance of the explain type
     */
    public static final CognitiveProcessValues EXPLAIN = new CognitiveProcessValues(EXPLAIN_TYPE, "explain");

    /**
     * The extrapolate type
     */
    public static final int EXTRAPOLATE_TYPE = 20;

    /**
     * The instance of the extrapolate type
     */
    public static final CognitiveProcessValues EXTRAPOLATE = new CognitiveProcessValues(EXTRAPOLATE_TYPE, "extrapolate");

    /**
     * The innovate type
     */
    public static final int INNOVATE_TYPE = 21;

    /**
     * The instance of the innovate type
     */
    public static final CognitiveProcessValues INNOVATE = new CognitiveProcessValues(INNOVATE_TYPE, "innovate");

    /**
     * The investigate type
     */
    public static final int INVESTIGATE_TYPE = 22;

    /**
     * The instance of the investigate type
     */
    public static final CognitiveProcessValues INVESTIGATE = new CognitiveProcessValues(INVESTIGATE_TYPE, "investigate");

    /**
     * The judge type
     */
    public static final int JUDGE_TYPE = 23;

    /**
     * The instance of the judge type
     */
    public static final CognitiveProcessValues JUDGE = new CognitiveProcessValues(JUDGE_TYPE, "judge");

    /**
     * The motivate type
     */
    public static final int MOTIVATE_TYPE = 24;

    /**
     * The instance of the motivate type
     */
    public static final CognitiveProcessValues MOTIVATE = new CognitiveProcessValues(MOTIVATE_TYPE, "motivate");

    /**
     * The observe type
     */
    public static final int OBSERVE_TYPE = 25;

    /**
     * The instance of the observe type
     */
    public static final CognitiveProcessValues OBSERVE = new CognitiveProcessValues(OBSERVE_TYPE, "observe");

    /**
     * The organize type
     */
    public static final int ORGANIZE_TYPE = 26;

    /**
     * The instance of the organize type
     */
    public static final CognitiveProcessValues ORGANIZE = new CognitiveProcessValues(ORGANIZE_TYPE, "organize");

    /**
     * The organize oneself type
     */
    public static final int ORGANIZE_ONESELF_TYPE = 27;

    /**
     * The instance of the organize oneself type
     */
    public static final CognitiveProcessValues ORGANIZE_ONESELF = new CognitiveProcessValues(ORGANIZE_ONESELF_TYPE, "organize oneself");

    /**
     * The plan type
     */
    public static final int PLAN_TYPE = 28;

    /**
     * The instance of the plan type
     */
    public static final CognitiveProcessValues PLAN = new CognitiveProcessValues(PLAN_TYPE, "plan");

    /**
     * The practise type
     */
    public static final int PRACTISE_TYPE = 29;

    /**
     * The instance of the practise type
     */
    public static final CognitiveProcessValues PRACTISE = new CognitiveProcessValues(PRACTISE_TYPE, "practise");

    /**
     * The produce type
     */
    public static final int PRODUCE_TYPE = 30;

    /**
     * The instance of the produce type
     */
    public static final CognitiveProcessValues PRODUCE = new CognitiveProcessValues(PRODUCE_TYPE, "produce");

    /**
     * The recognize type
     */
    public static final int RECOGNIZE_TYPE = 31;

    /**
     * The instance of the recognize type
     */
    public static final CognitiveProcessValues RECOGNIZE = new CognitiveProcessValues(RECOGNIZE_TYPE, "recognize");

    /**
     * The remember type
     */
    public static final int REMEMBER_TYPE = 32;

    /**
     * The instance of the remember type
     */
    public static final CognitiveProcessValues REMEMBER = new CognitiveProcessValues(REMEMBER_TYPE, "remember");

    /**
     * The write up type
     */
    public static final int WRITE_UP_TYPE = 33;

    /**
     * The instance of the write up type
     */
    public static final CognitiveProcessValues WRITE_UP = new CognitiveProcessValues(WRITE_UP_TYPE, "write up");

    /**
     * The consider type
     */
    public static final int CONSIDER_TYPE = 34;

    /**
     * The instance of the consider type
     */
    public static final CognitiveProcessValues CONSIDER = new CognitiveProcessValues(CONSIDER_TYPE, "consider");

    /**
     * The connect type
     */
    public static final int CONNECT_TYPE = 35;

    /**
     * The instance of the connect type
     */
    public static final CognitiveProcessValues CONNECT = new CognitiveProcessValues(CONNECT_TYPE, "connect");

    /**
     * The represent type
     */
    public static final int REPRESENT_TYPE = 36;

    /**
     * The instance of the represent type
     */
    public static final CognitiveProcessValues REPRESENT = new CognitiveProcessValues(REPRESENT_TYPE, "represent");

    /**
     * The solve type
     */
    public static final int SOLVE_TYPE = 37;

    /**
     * The instance of the solve type
     */
    public static final CognitiveProcessValues SOLVE = new CognitiveProcessValues(SOLVE_TYPE, "solve");

    /**
     * The simulate type
     */
    public static final int SIMULATE_TYPE = 38;

    /**
     * The instance of the simulate type
     */
    public static final CognitiveProcessValues SIMULATE = new CognitiveProcessValues(SIMULATE_TYPE, "simulate");

    /**
     * The summarize type
     */
    public static final int SUMMARIZE_TYPE = 39;

    /**
     * The instance of the summarize type
     */
    public static final CognitiveProcessValues SUMMARIZE = new CognitiveProcessValues(SUMMARIZE_TYPE, "summarize");

    /**
     * The value type
     */
    public static final int VALUE_TYPE = 40;

    /**
     * The instance of the value type
     */
    public static final CognitiveProcessValues VALUE = new CognitiveProcessValues(VALUE_TYPE, "value");

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

    private CognitiveProcessValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of CognitiveProcessValues
     * 
     * @return an Enumeration over all possible instances of
     * CognitiveProcessValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this
     * CognitiveProcessValues
     * 
     * @return the type of this CognitiveProcessValues
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
        members.put("analyse", ANALYSE);
        members.put("implement", IMPLEMENT);
        members.put("collaborate", COLLABORATE);
        members.put("compare", COMPARE);
        members.put("share", SHARE);
        members.put("compete", COMPETE);
        members.put("understand", UNDERSTAND);
        members.put("prove", PROVE);
        members.put("communicate", COMMUNICATE);
        members.put("contextualize", CONTEXTUALIZE);
        members.put("control", CONTROL);
        members.put("cooperate", COOPERATE);
        members.put("create", CREATE);
        members.put("decide", DECIDE);
        members.put("define", DEFINE);
        members.put("describe", DESCRIBE);
        members.put("discuss", DISCUSS);
        members.put("design", DESIGN);
        members.put("self assessment", SELF_ASSESSMENT);
        members.put("explain", EXPLAIN);
        members.put("extrapolate", EXTRAPOLATE);
        members.put("innovate", INNOVATE);
        members.put("investigate", INVESTIGATE);
        members.put("judge", JUDGE);
        members.put("motivate", MOTIVATE);
        members.put("observe", OBSERVE);
        members.put("organize", ORGANIZE);
        members.put("organize oneself", ORGANIZE_ONESELF);
        members.put("plan", PLAN);
        members.put("practise", PRACTISE);
        members.put("produce", PRODUCE);
        members.put("recognize", RECOGNIZE);
        members.put("remember", REMEMBER);
        members.put("write up", WRITE_UP);
        members.put("consider", CONSIDER);
        members.put("connect", CONNECT);
        members.put("represent", REPRESENT);
        members.put("solve", SOLVE);
        members.put("simulate", SIMULATE);
        members.put("summarize", SUMMARIZE);
        members.put("value", VALUE);
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
     * CognitiveProcessValues
     * 
     * @return the String representation of this
     * CognitiveProcessValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new CognitiveProcessValues based on
     * the given String value.
     * 
     * @param string
     * @return the CognitiveProcessValues value of parameter 'string
     */
    public static es.pode.parseadorXML.castor.types.CognitiveProcessValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid CognitiveProcessValues";
            throw new IllegalArgumentException(err);
        }
        return (CognitiveProcessValues) obj;
    }

}
