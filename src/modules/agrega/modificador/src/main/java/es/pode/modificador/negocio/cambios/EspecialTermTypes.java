// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: Enumeration.vsl in andromda-java-cartridge.
//
package es.pode.modificador.negocio.cambios;

/**
 * 
 */
public class EspecialTermTypes
    implements java.io.Serializable
{
    /**
     * 
     */
    public static final EspecialTermTypes ARBOL_CURRICULAR = new EspecialTermTypes("arbol-curricular");

    /**
     * 
     */
    public static final EspecialTermTypes ETB = new EspecialTermTypes("etb");

    /**
     * 
     */
    public static final EspecialTermTypes OTRO = new EspecialTermTypes("otro");

    private java.lang.String value;

    private EspecialTermTypes(java.lang.String value)
    {
        this.value = value;
    }

    /**
     * The default constructor allowing
     * super classes to access it.
     */
    protected EspecialTermTypes()
    {
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "" + value;
    }

    /**
     * Creates an instance of EspecialTermTypes from <code>value</code>.
     *
     * @param value the value to create the EspecialTermTypes from.
     */
    public static EspecialTermTypes fromString(java.lang.String value)
    {
        EspecialTermTypes typeValue = (EspecialTermTypes)values.get(value);
        if (typeValue == null)
        {
            throw new IllegalArgumentException(
                "invalid value '" + value + "', possible values are: " + literals);
        }
        return typeValue;
    }

    /**
     * Gets the underlying value of this type safe enumeration.
     *
     * @return the underlying value.
     */
    public java.lang.String getValue()
    {
        return this.value;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object that)
    {
        return (this == that) ? 0 : this.getValue().compareTo(
            ((EspecialTermTypes)that).getValue());
    }

    /**
     * Returns an unmodifiable list containing the literals that are known by this enumeration.
     *
     * @return A List containing the actual literals defined by this enumeration, this list
     *         can not be modified.
     */
    public static java.util.List literals()
    {
        return literals;
    }

    /**
     * Returns an unmodifiable list containing the names of the literals that are known
     * by this enumeration.
     *
     * @return A List containing the actual names of the literals defined by this
     *         enumeration, this list can not be modified.
     */
    public static java.util.List names()
    {
        return names;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object object)
    {
        return (this == object)
            || (object instanceof EspecialTermTypes && ((EspecialTermTypes)object).getValue().equals(
                this.getValue()));
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return this.getValue().hashCode();
    }

    private static final java.util.Map values = new java.util.HashMap(3, 1);
    private static java.util.List literals = new java.util.ArrayList(3);
    private static java.util.List names = new java.util.ArrayList(3);

    /**
     * Initializes the values.
     */
    static
    {
        values.put(ARBOL_CURRICULAR.value, ARBOL_CURRICULAR);
        literals.add(ARBOL_CURRICULAR.value);
        names.add("ARBOL_CURRICULAR");
        values.put(ETB.value, ETB);
        literals.add(ETB.value);
        names.add("ETB");
        values.put(OTRO.value, OTRO);
        literals.add(OTRO.value);
        names.add("OTRO");
        literals = java.util.Collections.unmodifiableList(literals);
        names = java.util.Collections.unmodifiableList(names);
    }
}