package org.andromda.presentation.bpm4struts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

/**
 * Contains common validation routines for use
 * with commons-validator, used by BPM4Struts.
 */
public class StrutsValidator
    implements Serializable
{
    /**
     * <p>
     * Validates whether the URL string passed in is a valid URL or not. Does
     * this by attempting to construct a java.net.URL instance and checking
     * whether or not, it's valid.
     * </p>
     * 
     * @param bean the bean validation is being performed on.
     * @param validatorAction the <code>ValidatorAction</code> that is
     *        currently being performed.
     * @param field the <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors the <code>ActionMessages</code> instance to which errors
     *        are added, if any validation errors occur.
     * @param request Current request object.
     * @return True if valid, false otherwise.
     */
    public static boolean validateUrl(
        Object bean,
        ValidatorAction validatorAction,
        Field field,
        ActionMessages errors,
        Validator validator,
        HttpServletRequest request)
    {
        boolean valid = true;
        String urlString = ValidatorUtils.getValueAsString(bean, field
            .getProperty());
        try
        {
            URL url = new URL(urlString);
            // first check to see if it can be used as a File
            File file = new File(url.getFile());
            valid = file.exists();
            // if the file doesn't exist, check to see if we can get the
            // contents
            // as a URL
            try
            {
                url.openStream();
                valid = true;
            }
            catch (FileNotFoundException ex)
            {
                // if the flag isn't valid it means it
                // failed the existence
                if (!valid)
                {
                    valid = false;
                }
            }
        }
        catch (Exception exception)
        {
            valid = false;
        }
        if (!valid)
        {
            errors.add(field.getKey(), Resources.getActionMessage(
                request,
                validatorAction,
                field));
        }
        return valid;
    }
    
    /**
     * Checks if a fields value is within a range (min &amp; max specified in the
     * vars attribute).
     *
     * @param bean the bean validation is being performed on.
     * @param validatorAction the <code>ValidatorAction</code> that is
     *        currently being performed.
     * @param field the <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors the <code>ActionMessages</code> instance to which errors
     *        are added, if any validation errors occur.
     * @param request Current request object.
     * @return True if valid, false otherwise.
     */
    public static boolean validateRange(
        Object bean,
        ValidatorAction validatorAction,
        Field field,
        ActionMessages errors,
        Validator validator,
        HttpServletRequest request)
    {
        boolean valid = true;
        String value = null;
        if (bean instanceof String) 
        {
            value = (String) bean;
        } 
        else 
        {
            value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        }
        if (!GenericValidator.isBlankOrNull(value)) 
        {
            try 
            {
                long intValue = Long.parseLong(value);
                long min = Long.parseLong(field.getVarValue("min"));
                long max = Long.parseLong(field.getVarValue("max"));
                if (!GenericValidator.isInRange(intValue, min, max)) 
                {
                    errors.add(field.getKey(), Resources.getActionMessage(request, validatorAction, field));
                    valid = false;
                }
            } 
            catch (Exception exception) 
            {
                errors.add(field.getKey(), Resources.getActionMessage(request, validatorAction, field));
                valid = false;
            }
        }
        return valid;
    }
    
    /**
     *  Checks if the field is a valid time. If the field has a timePattern variable,
     *  that will be used to format <code>java.text.SimpleDateFormat</code>.
     *
     * @param bean the bean validation is being performed on.
     * @param validatorAction the <code>ValidatorAction</code> that is
     *        currently being performed.
     * @param field the <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors the <code>ActionMessages</code> instance to which errors
     *        are added, if any validation errors occur.
     * @param request Current request object.
     * @return True if valid, false otherwise.
     */
    public static boolean validateTime(
        Object bean,
        ValidatorAction validatorAction,
        Field field,
        ActionMessages errors,
        Validator validator,
        HttpServletRequest request)
    {
        boolean valid = true;
        String value = null;
        if (bean instanceof String)
        {
            value = (String)bean;
        }
        else
        {
            value = ValidatorUtils.getValueAsString(
                    bean,
                    field.getProperty());
        }
        final String timePattern = field.getVarValue("timePattern");

        if (GenericValidator.isBlankOrNull(value))
        {
            return true;
        }

        try
        {
            if (timePattern != null && timePattern.length() > 0)
            {
                final java.text.DateFormat timeFormatter = new java.text.SimpleDateFormat(timePattern);
                timeFormatter.parse(value);
            }
            else
            {
                DateFormat.getTimeInstance().parse(value);
            }
        }
        catch (Exception exception)
        {
            errors.add(
                field.getKey(),
                Resources.getActionMessage(request, validatorAction, field));
            valid = false;
        }

        return valid;
    }
}