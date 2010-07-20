package es.pode.catalogacion.soporte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CataloguerDuration class for manipulating time/date stamps used within the LOM
 * @author Mark Cave-Ayland, Sirius Corporation plc.
 *
 */

public class CataloguerDuration {

	private String years;
	private String months;
	private String days;
	private String hours;
	private String minutes;
	private String seconds;
	
	
	public CataloguerDuration()
	{
		// Invoke the main constructor with an empty string
		this("");
	}
	
	public CataloguerDuration(String input)
	{
		// Use regexs to handle the date and time matching. Note we have to handle these
		// separately since the 'M' field identifier is rather non-cleverly used in both
		//
		// From the Advanced cataloguer:
		//  expresion regular duracion = P[yY][mM][dD][T[hH][nM][s[.s]S]]
		//
		// Note we currently don't go to any resolution < 1s, although this could
		// be changed if required...
		
		Pattern dateMask = Pattern.compile(
				"([0-9]+Y){0,1}([0-9]+M){0,1}([0-9]+D){0,1}(.*)"
				);
		
		Pattern timeMask = Pattern.compile(
				"([0-9]+H){0,1}([0-9]+M){0,1}([0-9]+\\.*[0-9]*S){0,1}"
				);

		// Work out whether we've matching a date/time, a date or a time
		Matcher dateMatcher;
		Matcher timeMatcher;
		String dateString;
		String timeString;
		
		// If the input is a blank string, simply return with an empty
		// object
		if (input == null || input.length() == 0)
			return;		
		
		// Strip off the leading P if it exists, then attempt to match the date
		// against up until the optional T
		int dateEnd = input.length();
		if (input.indexOf('T') != -1)
			dateEnd = input.indexOf('T');
		
		if (input.charAt(0) == 'P')
			dateString = input.substring(1, dateEnd);
		else
			dateString = input.substring(0, dateEnd);
		
		dateMatcher = dateMask.matcher(dateString);	
		if (dateMatcher.matches())
		{
			// We matched the date regex, so parse the regex groups
			for (int i = 1; i <= dateMatcher.groupCount(); i++)
			{
				// Each group first matches the complete number plus
				// field identifier, followed by just the number. We
				// use the identifier to determine which field to
				// populate.
				if (dateMatcher.group(i) != null && dateMatcher.group(i).length() > 1)
				{
					char fieldId = dateMatcher.group(i).charAt(
							dateMatcher.group(i).length() - 1
							);
					
					switch (fieldId)
					{
					case 'Y':
						// Years
						this.years = dateMatcher.group(i).substring(0, dateMatcher.group(i).length() - 1);
						break;
						
					case 'M':
						// Months
						this.months = dateMatcher.group(i).substring(0, dateMatcher.group(i).length() - 1);
						break;
						
					case 'D':
						// Days
						this.days = dateMatcher.group(i).substring(0, dateMatcher.group(i).length() - 1);
						break;
					}
				}
			}
		}
		
		// If we get here, then we may or may not have successfully
		// parsed the date fields. So now to see if we can parse a 
		// time field.
		
		// The time field is delimited by a capital T, so let's search
		// for this first...
		int tmpPos = input.indexOf('T');
		
		// If T exists then we'll attempt to parse from that position
		// onwards as a time
		if (tmpPos >= 1)
			timeString = input.substring(tmpPos + 1, input.length());
		else
			timeString = input;
		
		timeMatcher = timeMask.matcher(timeString);
		if (timeMatcher.matches())
		{
			// We matched the time regex, so parse the regex groups
			for (int i = 1; i <= timeMatcher.groupCount(); i++)
			{
				// Each group first matches the complete number plus
				// field identifier, followed by just the number. We
				// use the identifier to determine which field to
				// populate.
				if (timeMatcher.group(i) != null)
				{
					char fieldId = timeMatcher.group(i).charAt(
							timeMatcher.group(i).length() - 1
							);
					
					switch (fieldId)
					{
					case 'H':
						// Hours
						this.hours = timeMatcher.group(i).substring(0, timeMatcher.group(i).length() - 1);
						break;
						
					case 'M':
						// Minutes
						this.minutes = timeMatcher.group(i).substring(0, timeMatcher.group(i).length() - 1);
						break;
						
					case 'S':
						// Seconds
						this.seconds = timeMatcher.group(i).substring(0, timeMatcher.group(i).length() - 1);
						break;
					}
				}
			}
			
		}
	}
	
	
	public String toString()
	{
		// Return the duration as a LOM format duration string
		StringBuilder lomDuration = new StringBuilder();
		
		// Handle Years, Months and Days
		if ((this.years != null && !this.years.equals("")) ||
			(this.months != null && !this.months.equals("")) ||
			(this.days != null && !this.days.equals("")) ||
			(this.hours != null && !this.hours.equals("")) ||
			(this.minutes != null && !this.minutes.equals("")) ||
			(this.seconds != null && !this.seconds.equals("")))
				lomDuration.append('P');
		
		if (this.years != null && !this.years.equals(""))
			lomDuration.append(this.years + 'Y');
		
		if (this.months != null && !this.months.equals(""))
			lomDuration.append(this.months + 'M');
		
		if (this.days != null && !this.days.equals(""))
			lomDuration.append(this.days + 'D');
		
		// Handle Hours, Minutes and Seconds
		if ((this.hours != null && !this.hours.equals("")) ||
				(this.minutes != null && !this.minutes.equals("")) ||
				(this.seconds != null && !this.seconds.equals("")))
			lomDuration.append('T');
		
		if (this.hours != null && !this.hours.equals(""))
			lomDuration.append(this.hours + 'H');
		
		if (this.minutes != null && !this.minutes.equals(""))
			lomDuration.append(this.minutes + 'M');
		
		if (this.seconds != null && !this.seconds.equals(""))
			lomDuration.append(this.seconds + 'S');
		
		// Convert to String and return
		return lomDuration.toString();
	}
	
	
	public boolean isEmpty()
	{
		// Return true if all of the fields are either null or empty strings
		// Useful for LOM code to detect whether the Duration element needs
		// to be set or not
		
		if (this.years != null && !this.years.equals(""))
			return false;

		if (this.months != null && !this.months.equals(""))
			return false;
		
		if (this.days != null && !this.days.equals(""))
			return false;
		
		if (this.hours != null && !this.hours.equals(""))
			return false;

		if (this.minutes != null && !this.minutes.equals(""))
			return false;
		
		if (this.seconds != null && !this.seconds.equals(""))
			return false;		
		
		// Otherwise we must be empty so return true
		return true;
	}
	
	
	/*
	 * Accessor methods
	 */
	
	public String getYears()
	{
		return this.years;
	}
	
	public void setYears(String years)
	{
		this.years = years;
	}
	
	public String getMonths()
	{
		return this.months;	
	}
	
	public void setMonths(String months)
	{
		this.months = months;
	}
	
	public String getDays()
	{
		return this.days;
	}
	
	public void setDays(String days)
	{
		this.days = days;
	}
	
	public String getHours()
	{
		return this.hours;
	}
	
	public void setHours(String hours)
	{
		this.hours = hours;
	}
	
	public String getMinutes()
	{
		return this.minutes;
	}
	
	public void setMinutes(String minutes)
	{
		this.minutes = minutes;
	}
	
	public String getSeconds()
	{
		return this.seconds;
	}
	
	public void setSeconds(String seconds)
	{
		this.seconds = seconds;
	}
}
