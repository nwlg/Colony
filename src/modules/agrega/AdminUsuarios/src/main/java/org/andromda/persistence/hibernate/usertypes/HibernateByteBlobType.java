// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateByteBlobType.vsl in andromda-hibernate-cartridge.
//
package org.andromda.persistence.hibernate.usertypes;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.usertype.UserType;

/**
 * <p>
 * A hibernate user type which converts a Blob into a byte[] and back again.
 * </p>
 */
public class HibernateByteBlobType
    implements UserType
{
    /**
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    public int[] sqlTypes()
    {
        return new int[]
        {
            Types.BLOB
        };
    }

    /**
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    public Class returnedClass()
    {
        return byte[].class;
    }

    /**
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
     */
    public boolean equals(Object x, Object y)
    {
        return (x == y)
            || (x != null && y != null && java.util.Arrays.equals(
                (byte[])x,
                (byte[])y));
    }

    /**
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
     */
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
        throws SQLException
    {
        final Blob blob = resultSet.getBlob(names[0]);
        return (blob == null) ? null : blob.getBytes(1, (int)blob.length());
    }

    /**
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
     */
    public void nullSafeSet(PreparedStatement statement, Object value, int index)
        throws SQLException
    {
        if (value == null)
        {
            statement.setNull(index, java.sql.Types.BLOB);
        }
        else
        {
            final byte[] bytes = (byte[])value;
            statement.setBinaryStream(index, new ByteArrayInputStream(bytes), bytes.length);
        }
    }

    /**
     * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
     */
    public Object deepCopy(Object value)
    {
        if (value == null)
            return null;

        byte[] bytes = (byte[])value;
        byte[] result = new byte[bytes.length];
        System.arraycopy(bytes, 0, result, 0, bytes.length);

        return result;
    }

    /**
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    public boolean isMutable()
    {
        return true;
    }

    /**
     * @see org.hibernate.usertype.UserType#replace(Object original, Object target, Object owner)
     */
    public Object replace(Object original, Object target, Object owner)
    {
        return original;
    }

    /**
     * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable cached, Object owner)
     */
    public Object assemble(java.io.Serializable cached, Object owner)
    {
        return cached;
    }

    /**
     * @see org.hibernate.usertype.UserType#assemble(Object value)
     */
     public java.io.Serializable disassemble(Object value)
     {
        return (java.io.Serializable)value;
     }

     /**
     * @see org.hibernate.usertype.UserType#assemble(Object value)
     */
     public int hashCode(Object x)
     {
        return x.hashCode();
     }
}