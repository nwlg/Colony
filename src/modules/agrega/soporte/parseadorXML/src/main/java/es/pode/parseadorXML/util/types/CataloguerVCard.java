package es.pode.parseadorXML.util.types;

import java.util.regex.*;

import org.apache.log4j.Logger;


/**
 * VCard object for managing VCard fields within the cataloguer
 * @author Mark Cave-Ayland, Sirius Corporation plc.
 *
 */

public class CataloguerVCard {

	protected static Logger logger = Logger.getLogger(CataloguerVCard.class); 
	
	// Fields currently handled by this VCard object
	private String fullName; 
	private String emailAddress;
	private String organisation;

	/**
	 * Create a new object from a string representation
	 * @param vcardString
	 * @throws IllegalArgumentException if the vCardString is invalid
	 */
	public CataloguerVCard(String vCardString)
	{
		// Parse the input vCard string into a set of
		// internal property names, property parameters
		// and types
		
		if (vCardString == null)
			return;
		
		// HACK ALERT: The legacy Agrega code does not correctly implement
		// the vCard specification, since it does not separate parameters
		// with a CR/LF! Hence if we detect < 2 CRLFs then we use substring
		// matching rather than the proper state-based Lexer below.
		//
		// Note that the String output of this class will always emit CRLFs
		// in the correct fashion, so in effect modifying an entry will fix
		// its vCard.
		
		char[] charArrayVCardString = vCardString.toCharArray();
		int crlfTotal = 0;
		
		for (int i = 0; i < charArrayVCardString.length; i++)
		{
			if (charArrayVCardString[i] == '\n')
				crlfTotal++;
		}

		if (crlfTotal < 2)
		{
			// Looks like we have a broken legacy Agrega vCard, so we'll
			// try our best to parse it based upon substring matching :O
			logger.debug("vCard has < 2 CRLFs, so attempting to find fields " +
					"via parseLegacyVCard.");

			parseLegacyVCard(vCardString);
			
			logger.debug("finished parsing vCard via string-matching");
			
		}
		else
		{
			// Use the VCardLexer class to nicely grab the individual
			// elements			
			logger.debug("Parsing vCard using purpose-built lexer");
			
			VCardLexer vcl = new VCardLexer(vCardString);
			
			// First, look for the BEGIN:VCARD and VERSION:3.0 properties
			VCardLexerToken vclt;
			
			vclt = vcl.getToken();
			if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPNAME &&
					vclt.tokenValue.equals("BEGIN"))
			{
				vclt = vcl.getToken();
				if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPVALUE &&
						vclt.tokenValue.equals("VCARD"))
				{
					vclt = vcl.getToken();
					if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPNAME &&
							vclt.tokenValue.equals("VERSION"))
					{					
						vclt = vcl.getToken();
						if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPVALUE &&
								vclt.tokenValue.equals("3.0"))
						{
							logger.debug("vCard has correct header");
							
							// We've established the vCard has the correct header, so now
							// collect all of the other parameter names, properties and
							// values and set the values within this object accordingly...
							
							String curProperty;
							String curParam;
							String curValue;
							
							vclt = vcl.getToken();
							
							while (vclt.tokenType != VCardLexerToken.TOKENTYPE_ENDOFSTREAM)
							{
								// Collect the property name, followed optionally by the
								// parameters and finally the property value
								if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPNAME)
								{
									curProperty = vclt.tokenValue;
									
									vclt = vcl.getToken();
									
									if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPPARAM)
									{
										curParam = vclt.tokenValue;
										
										// Move on to next token
										vclt = vcl.getToken();
									}
									
									if (vclt.tokenType == VCardLexerToken.TOKENTYPE_PROPVALUE)
									{
										curValue = vclt.tokenValue;
										
										// So now we have the complete item, set the fields
										// accordingly...
										
										if (curProperty.equals("FN"))
											this.fullName = curValue;										
										else if (curProperty.equals("ORG"))
											this.organisation = curValue;
										else if (curProperty.equals("EMAIL"))
											this.emailAddress = curValue;
										
									}

									// Move on to next token
									vclt = vcl.getToken();

								}
								else
								{
									logger.error("Next item in vCard was NOT a property name");
									
									// Move on to next token (consume token so that we can
									// eventually reach the end of the input stream)
									vclt = vcl.getToken();
								}
							}
							
						}
						else
						{
							logger.error("vCard is not version 3.0 according to vCard header");
						}
					}
					else
					{
						logger.error("Could not find VERSION after BEGIN in vCard header");
					}
				}
				else
				{
					logger.error("Could not find VCARD after BEGIN in vCard header");
					return;
				}
			}
			else
			{
				logger.error("Could not find BEGIN at start of vCard header");
				return;
			}
			
			// TODO: add this in when we can actually get to it!
			
			logger.debug("Finish parsing vCard using purpose-built lexer");
		}
			
	}


	/*
	 * Return a correct vCard string containing all of the set values
	 */
	public String toString()
	{
		StringBuilder vCard = new StringBuilder();
		
		// Add the BEGIN:VCARD header
		vCard.append("BEGIN:VCARD\r\n");
		
		// Add the VERSION:3.0 header
		vCard.append("VERSION:3.0\r\n");
		
		// If FullName has been set, add it to the vCard
		if (this.fullName != null) {
			vCard.append("FN:" + escape(this.fullName) + "\r\n");
		}
		
		// If EmailAddress has been set, add it to the vCard
		if (this.emailAddress != null) {
			vCard.append("EMAIL;TYPE=INTERNET:" + escape(this.emailAddress) +
					"\r\n");
		}
		
		// If Organisation has been set, add it to the vCard
		if (this.organisation != null) {
			vCard.append("ORG:" + escape(this.organisation) + "\r\n");
		}
		
		// Add the END:VCARD footer
		vCard.append("END:VCARD\r\n");
		
		
		return vCard.toString();
	}
	
	/*
	 * Accessor methods
	 */
	
	public String getEmailAddress()
	{
		return this.emailAddress;
	}
	
	public void setEmailAddress(String s)
	{
		this.emailAddress = s;
	}
	
	public String getFullName()
	{
		return this.fullName;
	}
	
	public void setFullName(String s)
	{
		this.fullName = s;
	}
	
	public String getOrganisation()
	{
		return this.organisation;
	}
	
	public void setOrganisation(String s)
	{
		this.organisation = s;
	}
	
	/**
	 * Mini-Lexer class to handle reading items from the VCard
	 *
	 */

	class VCardLexerToken {
		public int tokenType;
		public String tokenValue;
		
		public static final int TOKENTYPE_PROPNAME = 0;
		public static final int TOKENTYPE_PROPVALUE = 1;
		public static final int TOKENTYPE_PROPPARAM = 2;
		public static final int TOKENTYPE_ENDOFSTREAM = 255;
	}
	
	class VCardLexer {
		
		private char[] inputCharArray; 
		private int curPos;
		private int curType;
		private String curToken;
		
		
		/**
		 * Constructor
		 * @param inputString
		 */
		VCardLexer(String inputString)
		{
			this.inputCharArray = inputString.toCharArray();
			this.curPos = 0;
			this.curToken = "";
			
			// Initial state should be scanning for
			// a property name
			this.curType = VCardLexerToken.TOKENTYPE_PROPNAME;
		}
		
		/**
		 * Grab the next token from the input String
		 * @return
		 */
		VCardLexerToken getToken()
		{
			// Depending upon the currentType we are scanning for,
			// collect the characters in the token differently
			char nextChar;
			curToken = new String();
			
			while (curPos < this.inputCharArray.length)
			{
				
				switch(curType)
				{
				
				case VCardLexerToken.TOKENTYPE_PROPNAME:
					
					// If we are the end of the string, indicate we are
					// finished and return what we have
					if (curPos >= this.inputCharArray.length - 1)
					{
						// Next time we indicate we are done
						curType = VCardLexerToken.TOKENTYPE_ENDOFSTREAM;
						
						// Return the current property name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPNAME;
						vclt.tokenValue = curToken;
						
						return vclt;
					}
					
					// Look ahead to the next character
					nextChar = this.inputCharArray[curPos];
					
					// If we reach a colon then return the property name and
					// then next time scan for a property value
					if (nextChar == ':')
					{
						// Next time we scan for the property value
						curType = VCardLexerToken.TOKENTYPE_PROPVALUE;
						
						// Skip the colon
						curPos++;
						
						// Return the current property name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPNAME;
						vclt.tokenValue = curToken;
						
						return vclt;
					}
					
					
					// If we reach a semicolon then return the property name
					// and then next time scan for a property parameter name
					if (nextChar == ';')
					{
						// Next time we scan for the property parameter name
						curType = VCardLexerToken.TOKENTYPE_PROPPARAM;
						
						// Skip the semicolon
						curPos++;
						
						// Return the current property name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPNAME;
						vclt.tokenValue = curToken.trim();
						
						return vclt;
					}
					
					// Otherwise add the character to the current token and repeat
					curToken = curToken + nextChar;
					curPos++;
					break;
					
				case VCardLexerToken.TOKENTYPE_PROPVALUE:
					
					// If we are the end of the string, indicate we are
					// finished and return what we have
					if (curPos >= this.inputCharArray.length - 1)
					{
						// Next time we indicate we are done
						curType = VCardLexerToken.TOKENTYPE_ENDOFSTREAM;
						
						// Return the current property name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPVALUE;
						vclt.tokenValue = curToken.trim();
						
						return vclt;
					}
					
					// Look ahead to the next character
					nextChar = this.inputCharArray[curPos];
					
					// If we reach CR then just ignore it (we'll trigger on
					// the LF just in case we accidently have UNIX type line
					// endings which is not per the vCard spec)
					if (nextChar == '\r')
						nextChar = this.inputCharArray[++curPos];
					
					// If we reach a LF then we've reached the end
					// of this property value so return it
					if (nextChar == '\n')
					{
						// Next time we scan for the property name
						curType = VCardLexerToken.TOKENTYPE_PROPNAME;
						
						// Skip the LF character
						curPos++;
						
						// Return the current property name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPVALUE;
						vclt.tokenValue = curToken.trim();
						
						return vclt;
					}
					
					// Otherwise add the character to the current token and repeat
					curToken = curToken + nextChar;
					curPos++;
					break;
	
				case VCardLexerToken.TOKENTYPE_PROPPARAM:
					
					// If we are the end of the string, indicate we are
					// finished and return what we have
					if (curPos >= this.inputCharArray.length - 1)
					{
						// Next time we indicate we are done
						curType = VCardLexerToken.TOKENTYPE_ENDOFSTREAM;
						
						// Return the current property name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPPARAM;
						vclt.tokenValue = curToken;
						
						return vclt;
					}
					
					// Look ahead to the next character
					nextChar = this.inputCharArray[curPos];
					
					// If we reach a colon then return the property parameter name and
					// then next time scan for a property value
					if (nextChar == ':')
					{
						// Next time we scan for the property value
						curType = VCardLexerToken.TOKENTYPE_PROPVALUE;
						
						// Skip the colon
						curPos++;
						
						// Return the current property parameter name
						VCardLexerToken vclt = new VCardLexerToken();
						vclt.tokenType = VCardLexerToken.TOKENTYPE_PROPPARAM;
						vclt.tokenValue = curToken;
						
						return vclt;
					}
					
					// TODO: escaping for semicolons
					
					// Otherwise add the character to the current token and repeat
					curToken = curToken + nextChar;
					curPos++;
					break;
					
				case VCardLexerToken.TOKENTYPE_ENDOFSTREAM:
					// In this state, we have reached the end of our
					// input, so we always return an end of stream token
					
					VCardLexerToken vclt = new VCardLexerToken();
					vclt.tokenType = VCardLexerToken.TOKENTYPE_ENDOFSTREAM;
					vclt.tokenValue = null;
					
					return vclt;
				}

			}
			
			// If we get here then we have gone past the end of the string
			VCardLexerToken vclt = new VCardLexerToken();
			vclt.tokenType = VCardLexerToken.TOKENTYPE_ENDOFSTREAM;
			vclt.tokenValue = null;
			
			return vclt;
		}
	}

	/*
	 * Helper methods
	 */

	private void parseLegacyVCard(String vCardString) {
		// A slightly more correct version of the legacy code borrowed from the
		// Advanced Cataloguer.  It works with missing fields which the legacy
		// code could not handle.  Parts of agrega do not perform escaping so
		// unescaping here is not worth spending time on.  NWLG understand this
		// and the associated limitations.

		// Split on colon which separates a key from a value for a property.
		String[] vCardItems = vCardString.split(":");

		//
		// A legacy agrega VCARD looks like:
		//
		//   BEGIN:VCARD VERSION:3.0 FN:foo ORG:bar EMAIL;TYPE=INTERNET:baz@fubard.net END:VCARD
		//
		// with FN, ORG and EMAIL;TYPE being optional property types and EMAIL
		// TYPE set to INTERNET.
		//
		if (vCardItems.length < 4) {
			throw new IllegalArgumentException(
					"Not enough items in the VCARD: \"" + vCardString +
					"\"" +	" -- The RFC2426 requires at least the " +
					"BEGIN, END, and VERSION property types in the " +
					"content entity."
					);
		}

		// To parse out a property value, the last space before the next
		// property name or the END is the separator to use.  This will match
		// all the vCardItems elements except for the first and last and we only
		// intend to apply it for FN, EMAIL, and ORG property types.
		Pattern spaceSepValPattern =
				Pattern.compile("^(.*)[ ]([A-Za-z0-9_=;]+)$");

		//
		// Parse the values for all the property types present in the VCARD
		// string.
		//
		// For the properties between the BEGIN:VCARD and END:VCARD, we could
		// consider reducing the loop iterations by half but that's too small a
		// number to justify complicating this code.  Likewise, we do not want
		// to do anything about the properties we could skip namely BEGIN,
		// VERSION, and END.
		//
		for (int k = 1; k < vCardItems.length; k++) {
			String prev = vCardItems[k - 1];
			Matcher thisMatcher = spaceSepValPattern.matcher(vCardItems[k]);

			if (prev.endsWith("FN")) {
				this.fullName =
						getFirstGrpValFromSpaceSepMatcher(thisMatcher);
			} else if (prev.endsWith("EMAIL;TYPE=INTERNET")) {
				this.emailAddress =
						getFirstGrpValFromSpaceSepMatcher(thisMatcher);
			} else if (prev.endsWith("ORG")) {
				this.organisation = 
						getFirstGrpValFromSpaceSepMatcher(thisMatcher);
			}
		}
	}

	// Helper for parseLegacyVCard
	private String getFirstGrpValFromSpaceSepMatcher(Matcher spSepValMatcher) {
		// See the definition of spaceSepValPattern above for details
		if (spSepValMatcher.find() && spSepValMatcher.groupCount() == 2) {
			return spSepValMatcher.group(1);
		} else {
			return null;
		}
	}

	private String escape(String s) {
		//
		// We only handle colon escaping for now, as that is the "minimal fix"
		// change in the intersection of the RFC 2425/2426 escaping requirements
		// and the legacy VCARD parsing requirements.
		//
		return (s != null) ? s.replaceAll(":", "\\\\:") : null;
	}

	/**
	 * Simple email validation regex borrowed from Advanced Cataloguer
	 */
	
    private boolean validateEmail(String email)
    {
        boolean result = true;

        Pattern pattern = Pattern.compile("^[A-Za-z0-9]([A-Za-z0-9.-_])*@[A-Za-z0-9]([A-Za-z0-9.-_])*.([A-Za-z0-9])+$");

        Matcher matcher = pattern.matcher(email.trim());

        if (!matcher.find()) {
              result = false;
        }

        return result;
    }
	
}
