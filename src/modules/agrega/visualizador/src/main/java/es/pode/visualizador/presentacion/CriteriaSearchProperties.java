// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateSearchEmbeddedValueList.vsl in andromda-spring-cartridge.
//
package es.pode.visualizador.presentacion;

/**
 * Stores the embedded values and asssociations of all entities in the system by type.  
 * Is used to determine the appropriate parameter name when an embedded value's property 
 * is referenced as the attribute to search by (as opposed to an association).
 * 
 * @author Chad Brandon
 */
public class CriteriaSearchProperties
{
    private static final java.util.Map embeddedValuesByType = new java.util.HashMap();
    private static final java.util.Map navigableAssociationEndsByType = new java.util.HashMap();
    
    static
    {
    }
    
    /**
     * Attempts to get the embedded value list for the given type (or returns null
     * if one doesn't exist).
     * 
     * @param type the type of which to retrieve the value.
     * @return the collection of embedded value names.
     */
    public static java.util.Collection getEmbeddedValues(final Class type)
    {
        return (java.util.Collection)embeddedValuesByType.get(type);
    }
    
    /**
     * Gets the type of the navigable association end given the <code>ownerType</code>
     * and <code>name</code>
     *
     * @param ownerType the owner of the association.
     * @param name the name of the association end to find.
     * @return the type of the association end.
     */
    public static Class getNavigableAssociationEndType(final Class ownerType, final String name)
    {
        final java.util.Collection ends = (java.util.Collection)navigableAssociationEndsByType.get(ownerType);
        final AssociationType type = (AssociationType)org.apache.commons.collections.CollectionUtils.find(
            ends,
            new org.apache.commons.collections.Predicate()
            {
                public boolean evaluate(final Object object)
                {
                    return ((AssociationType)object).name.equals(name);
                }
            });
        return type != null ? type.type : null;
    }

    /**
     * A private class storing the association name and type.
     */    
    protected static final class AssociationType
    {
        protected AssociationType(final String name, final Class type)
        {
            this.name = name;
            this.type = type;
        }
        protected String name;
        protected Class type;
    }
}