// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: Enumeration.vsl in andromda-java-cartridge.
//
package es.pode.modificador.negocio.utilidades;

/**
 * 
 */
public class EstadosTarea
    implements java.io.Serializable
{
    /**
     * 
     */
    public static final EstadosTarea FINALIZADA = new EstadosTarea("FINALIZADA");

    /**
     * 
     */
    public static final EstadosTarea ERROR = new EstadosTarea("ERROR");

    /**
     * 
     */
    public static final EstadosTarea RESTAURADA = new EstadosTarea("RESTAURADA");

    /**
     * 
     */
    public static final EstadosTarea CONFIGURADA = new EstadosTarea("CONFIGURADA");

    /**
     * <p>
     * Estado en que los cambios sobre un ODE se han dado por validos,
     * pero alguno de los cambios no se aplicaron con exito. Se
     * recomienda revisar el informe de traza por si fuera necesario
     * restaurar el backup.
     * </p>
     */
    public static final EstadosTarea WARNING = new EstadosTarea("WARNING");

    /**
     * <p>
     * Tarea en ejecución
     * </p>
     */
    public static final EstadosTarea RUNNING = new EstadosTarea("RUNNING");

    private java.lang.String value;

    private EstadosTarea(java.lang.String value)
    {
        this.value = value;
    }

    /**
     * The default constructor allowing
     * super classes to access it.
     */
    protected EstadosTarea()
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
     * Creates an instance of EstadosTarea from <code>value</code>.
     *
     * @param value the value to create the EstadosTarea from.
     */
    public static EstadosTarea fromString(java.lang.String value)
    {
        EstadosTarea typeValue = (EstadosTarea)values.get(value);
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
            ((EstadosTarea)that).getValue());
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
            || (object instanceof EstadosTarea && ((EstadosTarea)object).getValue().equals(
                this.getValue()));
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return this.getValue().hashCode();
    }

    private static final java.util.Map values = new java.util.HashMap(6, 1);
    private static java.util.List literals = new java.util.ArrayList(6);
    private static java.util.List names = new java.util.ArrayList(6);

    /**
     * Initializes the values.
     */
    static
    {
        values.put(FINALIZADA.value, FINALIZADA);
        literals.add(FINALIZADA.value);
        names.add("FINALIZADA");
        values.put(ERROR.value, ERROR);
        literals.add(ERROR.value);
        names.add("ERROR");
        values.put(RESTAURADA.value, RESTAURADA);
        literals.add(RESTAURADA.value);
        names.add("RESTAURADA");
        values.put(CONFIGURADA.value, CONFIGURADA);
        literals.add(CONFIGURADA.value);
        names.add("CONFIGURADA");
        values.put(WARNING.value, WARNING);
        literals.add(WARNING.value);
        names.add("WARNING");
        values.put(RUNNING.value, RUNNING);
        literals.add(RUNNING.value);
        names.add("RUNNING");
        literals = java.util.Collections.unmodifiableList(literals);
        names = java.util.Collections.unmodifiableList(names);
    }
}