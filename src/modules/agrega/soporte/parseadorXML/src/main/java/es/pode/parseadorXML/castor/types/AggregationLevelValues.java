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
 * Class AggregationLevelValues.
 * 
 * @version $Revision$ $Date$
 */
public class AggregationLevelValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The 1 type
     */
    public static final int VALUE_1_TYPE = 0;

    /**
     * The instance of the 1 type
     */
    public static final AggregationLevelValues VALUE_1 = new AggregationLevelValues(VALUE_1_TYPE, "1");

    /**
     * The 2 type
     */
    public static final int VALUE_2_TYPE = 1;

    /**
     * The instance of the 2 type
     */
    public static final AggregationLevelValues VALUE_2 = new AggregationLevelValues(VALUE_2_TYPE, "2");

    /**
     * The 3 type
     */
    public static final int VALUE_3_TYPE = 2;

    /**
     * The instance of the 3 type
     */
    public static final AggregationLevelValues VALUE_3 = new AggregationLevelValues(VALUE_3_TYPE, "3");

    /**
     * The 4 type
     */
    public static final int VALUE_4_TYPE = 3;

    /**
     * The instance of the 4 type
     */
    public static final AggregationLevelValues VALUE_4 = new AggregationLevelValues(VALUE_4_TYPE, "4");

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

    private AggregationLevelValues(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of AggregationLevelValues
     * 
     * @return an Enumeration over all possible instances of
     * AggregationLevelValues
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this
     * AggregationLevelValues
     * 
     * @return the type of this AggregationLevelValues
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
        members.put("1", VALUE_1);
        members.put("2", VALUE_2);
        members.put("3", VALUE_3);
        members.put("4", VALUE_4);
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
     * AggregationLevelValues
     * 
     * @return the String representation of this
     * AggregationLevelValues
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new AggregationLevelValues based on
     * the given String value.
     * 
     * @param string
     * @return the AggregationLevelValues value of parameter 'string
     */
    public static es.pode.parseadorXML.castor.types.AggregationLevelValues valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid AggregationLevelValues";
            throw new IllegalArgumentException(err);
        }
        return (AggregationLevelValues) obj;
    }

}
