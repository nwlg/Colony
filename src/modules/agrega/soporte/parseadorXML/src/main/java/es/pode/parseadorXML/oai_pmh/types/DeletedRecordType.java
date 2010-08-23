/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.oai_pmh.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class DeletedRecordType.
 * 
 * @version $Revision$ $Date$
 */
public class DeletedRecordType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The no type
     */
    public static final int NO_TYPE = 0;

    /**
     * The instance of the no type
     */
    public static final DeletedRecordType NO = new DeletedRecordType(NO_TYPE, "no");

    /**
     * The persistent type
     */
    public static final int PERSISTENT_TYPE = 1;

    /**
     * The instance of the persistent type
     */
    public static final DeletedRecordType PERSISTENT = new DeletedRecordType(PERSISTENT_TYPE, "persistent");

    /**
     * The transient type
     */
    public static final int TRANSIENT_TYPE = 2;

    /**
     * The instance of the transient type
     */
    public static final DeletedRecordType TRANSIENT = new DeletedRecordType(TRANSIENT_TYPE, "transient");

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

    private DeletedRecordType(final int type, final java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate.Returns an enumeration of all possible
     * instances of DeletedRecordType
     * 
     * @return an Enumeration over all possible instances of
     * DeletedRecordType
     */
    public static java.util.Enumeration enumerate(
    ) {
        return _memberTable.elements();
    }

    /**
     * Method getType.Returns the type of this DeletedRecordType
     * 
     * @return the type of this DeletedRecordType
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
        members.put("no", NO);
        members.put("persistent", PERSISTENT);
        members.put("transient", TRANSIENT);
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
     * DeletedRecordType
     * 
     * @return the String representation of this DeletedRecordType
     */
    public java.lang.String toString(
    ) {
        return this.stringValue;
    }

    /**
     * Method valueOf.Returns a new DeletedRecordType based on the
     * given String value.
     * 
     * @param string
     * @return the DeletedRecordType value of parameter 'string'
     */
    public static es.pode.parseadorXML.oai_pmh.types.DeletedRecordType valueOf(
            final java.lang.String string) {
        java.lang.Object obj = null;
        if (string != null) {
            obj = _memberTable.get(string);
        }
        if (obj == null) {
            String err = "" + string + " is not a valid DeletedRecordType";
            throw new IllegalArgumentException(err);
        }
        return (DeletedRecordType) obj;
    }

}
