package org.andromda.presentation.bpm4struts;

/**
 * This servlet is designed to avoid Struts copying zeroes into those form
 * fields that take numerical values.
 *
 * It also takes care of properly setting the content type for the returned reponse.
 */
public final class ActionServlet
    extends org.apache.struts.action.ActionServlet
{
    /**
     * Call the parent initializer and configure the converter not to
     * convert <code>null</code> numbers to the corresponding zero value.
     */
    public void init(final javax.servlet.ServletConfig config)
        throws javax.servlet.ServletException
    {
        super.init(config);

        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.LongConverter(null), java.lang.Long.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.IntegerConverter(null), java.lang.Integer.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.ShortConverter(null), java.lang.Short.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.DoubleConverter(null), java.lang.Double.class);
        org.apache.commons.beanutils.ConvertUtils.register(
            new org.apache.commons.beanutils.converters.FloatConverter(null), java.lang.Float.class);
    }

    public void doGet(
        final javax.servlet.http.HttpServletRequest request,
        final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        super.doGet(request, response);
    }

    public void doPost(
        final javax.servlet.http.HttpServletRequest request,
        final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        super.doPost(request, response);
    }
}