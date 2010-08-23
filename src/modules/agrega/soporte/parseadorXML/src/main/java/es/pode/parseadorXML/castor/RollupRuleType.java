/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class RollupRuleType.
 * 
 * @version $Revision$ $Date$
 */
public class RollupRuleType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _childActivitySet.
     */
    private es.pode.parseadorXML.castor.types.ChildActivityType _childActivitySet = es.pode.parseadorXML.castor.types.ChildActivityType.valueOf("all");

    /**
     * Field _minimumCount.
     */
    private long _minimumCount = 0;

    /**
     * keeps track of state for field: _minimumCount
     */
    private boolean _has_minimumCount;

    /**
     * Field _minimumPercent.
     */
    private java.math.BigDecimal _minimumPercent = new java.math.BigDecimal("0");

    /**
     * Field _rollupConditions.
     */
    private es.pode.parseadorXML.castor.RollupConditions _rollupConditions;

    /**
     * Field _rollupAction.
     */
    private es.pode.parseadorXML.castor.RollupAction _rollupAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public RollupRuleType() {
        super();
        setChildActivitySet(es.pode.parseadorXML.castor.types.ChildActivityType.valueOf("all"));
        setMinimumPercent(new java.math.BigDecimal("0"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /*
	 * Metodos get y set de los atributos _has_XXXX usados por Dozer para los
	 * mapeos
	 * 
	 * fjespino
	 */
    
    public boolean getHasMinimunCount() {
    	return this._has_minimumCount;
    }
    public void setHasMinimunCount(boolean value) {
    	this._has_minimumCount=value;
    }
    
    
    /**
     */
    public void deleteMinimumCount(
    ) {
        this._has_minimumCount= false;
    }

    /**
     * Returns the value of field 'childActivitySet'.
     * 
     * @return the value of field 'ChildActivitySet'.
     */
    public es.pode.parseadorXML.castor.types.ChildActivityType getChildActivitySet(
    ) {
        return this._childActivitySet;
    }

    /**
     * Returns the value of field 'minimumCount'.
     * 
     * @return the value of field 'MinimumCount'.
     */
    public long getMinimumCount(
    ) {
        return this._minimumCount;
    }

    /**
     * Returns the value of field 'minimumPercent'.
     * 
     * @return the value of field 'MinimumPercent'.
     */
    public java.math.BigDecimal getMinimumPercent(
    ) {
        return this._minimumPercent;
    }

    /**
     * Returns the value of field 'rollupAction'.
     * 
     * @return the value of field 'RollupAction'.
     */
    public es.pode.parseadorXML.castor.RollupAction getRollupAction(
    ) {
        return this._rollupAction;
    }

    /**
     * Returns the value of field 'rollupConditions'.
     * 
     * @return the value of field 'RollupConditions'.
     */
    public es.pode.parseadorXML.castor.RollupConditions getRollupConditions(
    ) {
        return this._rollupConditions;
    }

    /**
     * Method hasMinimumCount.
     * 
     * @return true if at least one MinimumCount has been added
     */
    public boolean hasMinimumCount(
    ) {
        return this._has_minimumCount;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'childActivitySet'.
     * 
     * @param childActivitySet the value of field 'childActivitySet'
     */
    public void setChildActivitySet(
            final es.pode.parseadorXML.castor.types.ChildActivityType childActivitySet) {
        this._childActivitySet = childActivitySet;
    }

    /**
     * Sets the value of field 'minimumCount'.
     * 
     * @param minimumCount the value of field 'minimumCount'.
     */
    public void setMinimumCount(
            final long minimumCount) {
        this._minimumCount = minimumCount;
        this._has_minimumCount = true;
    }
    
    public void setMinimumCountMapped(
            final long minimumCount) {
        this._minimumCount = minimumCount;
    }

    /**
     * Sets the value of field 'minimumPercent'.
     * 
     * @param minimumPercent the value of field 'minimumPercent'.
     */
    public void setMinimumPercent(
            final java.math.BigDecimal minimumPercent) {
        this._minimumPercent = minimumPercent;
    }

    /**
     * Sets the value of field 'rollupAction'.
     * 
     * @param rollupAction the value of field 'rollupAction'.
     */
    public void setRollupAction(
            final es.pode.parseadorXML.castor.RollupAction rollupAction) {
        this._rollupAction = rollupAction;
    }

    /**
     * Sets the value of field 'rollupConditions'.
     * 
     * @param rollupConditions the value of field 'rollupConditions'
     */
    public void setRollupConditions(
            final es.pode.parseadorXML.castor.RollupConditions rollupConditions) {
        this._rollupConditions = rollupConditions;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * es.pode.parseadorXML.castorRollupRuleType
     */
    public static es.pode.parseadorXML.castor.RollupRuleType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (es.pode.parseadorXML.castor.RollupRuleType) Unmarshaller.unmarshal(es.pode.parseadorXML.castor.RollupRuleType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
