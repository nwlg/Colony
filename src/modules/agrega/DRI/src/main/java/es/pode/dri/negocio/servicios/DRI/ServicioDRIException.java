// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!!
// Generated by: ApplicationException.vsl in andromda-java-cartridge.
//
package es.pode.dri.negocio.servicios.DRI;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p>
 * Excepciones del servicio de DRI.
 * </p>
 */
public class ServicioDRIException
    extends java.lang.Exception
{
    /**
     * The default constructor.
     */
    public ServicioDRIException()
    {}

    /**
     * Constructs a new instance of ServicioDRIException
     *
     * @param throwable the parent Throwable
     */
    public ServicioDRIException(Throwable throwable)
    {
        super(findRootCause(throwable));
    }

    /**
     * Constructs a new instance of ServicioDRIException
     *
     * @param message the throwable message.
     */
    public ServicioDRIException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new instance of ServicioDRIException
     *
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public ServicioDRIException(String message, Throwable throwable)
    {
        super(message, findRootCause(throwable));
    }

    /**
     * Finds the root cause of the parent exception
     * by traveling up the exception tree
     */
    private static Throwable findRootCause(Throwable th)
    {
        if (th != null)
        {
            // Lets reflectively get any JMX or EJB exception causes.
            try
            {
                Throwable targetException = null;
                // java.lang.reflect.InvocationTargetException
                // or javax.management.ReflectionException
                String exceptionProperty = "targetException";
                if (PropertyUtils.isReadable(th, exceptionProperty))
                {
                    targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                }
                else
                {
                    exceptionProperty = "causedByException";
                    //javax.ejb.EJBException
                    if (PropertyUtils.isReadable(th, exceptionProperty))
                    {
                        targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                    }
                }
                if (targetException != null)
                {
                    th = targetException;
                }
            }
            catch (Exception ex)
            {
                // just print the exception and continue
                ex.printStackTrace();
            }

            if (th.getCause() != null)
            {
                th = th.getCause();
                th = findRootCause(th);
            }
        }
        return th;
    }
}
