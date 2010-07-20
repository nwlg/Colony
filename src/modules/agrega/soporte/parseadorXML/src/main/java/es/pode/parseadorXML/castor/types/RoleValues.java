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
 * Class RoleValues.
 * 
 * @version $Revision$ $Date$
 */
public class RoleValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The author type
     */
    public static final int AUTHOR_TYPE = 0;

    /**
     * The instance of the author type
     */
    public static final RoleValues AUTHOR = new RoleValues(AUTHOR_TYPE, "author");

    /**
     * The publisher type
     */
    public static final int PUBLISHER_TYPE = 1;

    /**
     * The instance of the publisher type
     */
    public static final RoleValues PUBLISHER = new RoleValues(PUBLISHER_TYPE, "publisher");

    /**
     * The unknown type
     */
    public static final int UNKNOWN_TYPE = 2;

    /**
     * The instance of the unknown type
     */
    public static final RoleValues UNKNOWN = new RoleValues(UNKNOWN_TYPE, "unknown");

    /**
     * The initiator type
     */
    public static final int INITIATOR_TYPE = 3;

    /**
     * The instance of the initiator type
     */
    public static final RoleValues INITIATOR = new RoleValues(INITIATOR_TYPE, "initiator");

    /**
     * The terminator type
     */
    public static final int TERMINATOR_TYPE = 4;

    /**
     * The instance of the terminator type
     */
    public static final RoleValues TERMINATOR = new RoleValues(TERMINATOR_TYPE, "terminator");

    /**
     * The validator type
     */
    public static final int VALIDATOR_TYPE = 5;

    /**
     * The instance of the validator type
     */
    public static final RoleValues VALIDATOR = new RoleValues(VALIDATOR_TYPE, "validator");

    /**
     * The editor type
     */
    public static final int EDITOR_TYPE = 6;

    /**
     * The instance of the editor type
     */
    public static final RoleValues EDITOR = new RoleValues(EDITOR_TYPE, "editor");

    /**
     * The graphical designer type
     */
    public static final int GRAPHICAL_DESIGNER_TYPE = 7;

    /**
     * The instance of the graphical designer type
     */
    public static final RoleValues GRAPHICAL_DESIGNER = new RoleValues(GRAPHICAL_DESIGNER_TYPE, "graphical designer");

    /**
     * The technical implementer type
     */
    public static final int TECHNICAL_IMPLEMENTER_TYPE = 8;

    /**
     * The instance of the technical implementer type
     */
    public static final RoleValues TECHNICAL_IMPLEMENTER = new RoleValues(TECHNICAL_IMPLEMENTER_TYPE, "technical implementer");

    /**
     * The content provider type
     */
    public static final int CONTENT_PROVIDER_TYPE = 9;

    /**
     * The instance of the content provider type
     */
    public static final RoleValues CONTENT_PROVIDER = new RoleValues(CONTENT_PROVIDER_TYPE, "content provider");

    /**
     * The technical validator type
     */
    public static final int TECHNICAL_VALIDATOR_TYPE = 10;

    /**
     * The instance of the technical validator type
     */
    public static final RoleValues TECHNICAL_VALIDATOR = new RoleValues(TECHNICAL_VALIDATOR_TYPE, "technical validator");

    /**
     * The educational validator type
     */
    public static final int EDUCATIONAL_VALIDATOR_TYPE = 11;

    /**
     * The instance of the educational validator type
     */
    public static final RoleValues EDUCATIONAL_VALIDATOR = new RoleValues(EDUCATIONAL_VALIDATOR_TYPE, "educational validator");

    /**
     * The script writer type
     */
    public static final int SCRIPT_WRITER_TYPE = 12;

    /**
     * The instance of the script writer type
     */
    public static final RoleValues SCRIPT_WRITER = new RoleValues(SCRIPT_WRITER_TYPE, "script writer");

    /**
     * The instructional designer type
     */
    public static final int INSTRUCTIONAL_DESIGNER_TYPE = 13;

    /**
     * The instance of the instructional designer type
     */
    public static final RoleValues INSTRUCTIONAL_DESIGNER = new RoleValues(INSTRUCTIONAL_DESIGNER_TYPE, "instructional designer");

    /**
     * The subject matter expert type
     */
    public static final int SUBJECT_MATTER_EXPERT_TYPE = 14;

    /**
     * The instance of the subject matter expert type
     */
    public static final RoleValues SUBJECT_MATTER_EXPERT = new RoleValues(SUBJECT_MATTER_EXPERT_TYPE, "subject matter expert");

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

    private RoleValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of RoleValues
     * 
     * @return an Enumeration over all possible instances of
     * RoleValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this RoleValues
     * 
     * @return the type of this RoleValues
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
        members.put("author", AUTHOR);
        members.put("publisher", PUBLISHER);
        members.put("unknown", UNKNOWN);
        members.put("initiator", INITIATOR);
        members.put("terminator", TERMINATOR);
        members.put("validator", VALIDATOR);
        members.put("editor", EDITOR);
        members.put("graphical designer", GRAPHICAL_DESIGNER);
        members.put("technical implementer", TECHNICAL_IMPLEMENTER);
        members.put("content provider", CONTENT_PROVIDER);
        members.put("technical validator", TECHNICAL_VALIDATOR);
        members.put("educational validator", EDUCATIONAL_VALIDATOR);
        members.put("script writer", SCRIPT_WRITER);
        members.put("instructional designer", INSTRUCTIONAL_DESIGNER);
        members.put("subject matter expert", SUBJECT_MATTER_EXPERT);
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
     * RoleValues
     * 
     * @return the String representation of this RoleValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new RoleValues based on the given
     * String value.
     * 
     * @param string
     * @return the RoleValues value of parameter 'string'
     */
    public static es.pode.parseadorXML.castor.types.RoleValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid RoleValues";
            throw new IllegalArgumentException(err);
        }
        return (RoleValues) obj;
    }

}
