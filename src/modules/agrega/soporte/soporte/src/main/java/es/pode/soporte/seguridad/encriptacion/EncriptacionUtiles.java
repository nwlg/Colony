/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.encriptacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncriptacionUtiles 
{
	public static Log log = LogFactory.getLog("EncriptacionUtiles");
	
    private static final byte[] _3desData = {
        (byte)0x23, (byte)0xFF, (byte)0xAA, (byte)0x30, (byte)0x31, (byte)0x2F,
        (byte)0xAD, (byte)0x2A, (byte)0xA1, (byte)0x10, (byte)0x55, (byte)0xFE,
        (byte)0x35, (byte)0x15, (byte)0x63, (byte)0x31, (byte)0x34, (byte)0x82,
        (byte)0x22, (byte)0x77, (byte)0xA1, (byte)0x78, (byte)0x39, (byte)0x09 };

    private static final String claveXOR = "Agr3gAp0dEaGReGAP0DeAGR3GAP0D3";
    private static final String algoritmo = "DESede";
    private static SecretKeySpec key = new SecretKeySpec(_3desData, algoritmo);

	/**
	 * Encripta una cadena de texto
	 * 
	 * @param text Texto a encriptar
	 * @return Texto encriptado
	 */
    public static String encriptar(String text) throws Exception
    {   
    	try
    	{
	    	// Realizamos un XOR inicial
	        String xorTexto = xor(text, claveXOR);
	
	        byte[] plaintext = xorTexto.getBytes();
	
	        Cipher cipher = Cipher.getInstance(algoritmo);  
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        byte[] cipherText = cipher.doFinal(plaintext);
	        BASE64Encoder b64 = new BASE64Encoder();
	        
	        return b64.encode(cipherText);
    	}
    	catch (Exception e)
    	{
    		log.error("Error al encriptar " + e.getMessage());
    		throw e;
    	}
    }

	/**
	 * Desencripta una cadena de texto
	 * 
	 * @param text Texto a encriptar
	 * @return Texto desencriptado
	 */
    public static String desencriptar(String text) throws Exception
    {
    	try 
    	{
	        BASE64Decoder b64 = new BASE64Decoder();
	        byte[] cipherText = b64.decodeBuffer(text);
	
	        Cipher cipher = Cipher.getInstance(algoritmo); 
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        String plainText = new String(cipher.doFinal(cipherText));
	
	        // Deshacemos el xor
	        plainText = xor(plainText, claveXOR);
	
	        return plainText;
    	}
    	catch (Exception e)
    	{
    		log.error("Error al desencriptar " + e.getMessage());
    		throw e;
    	}
    }
    
	/**
	 * Realiza un XOR 
	 * 
	 * @param texto Texto sobre el que se realiza el XOR
	 * @param clave Clave que se usa para realizar el XOR
	 * @return Resultado de la realización del XOR
	 */
    public static String xor (String texto, String clave)
    {
        char[] preEncryptChars = texto.toCharArray();
        char[] resultChars = new char[preEncryptChars.length];
        char[] passwordChars = clave.toCharArray();
        int passwordLongitud = clave.length();
        int k = 0;
        
        for (int i = 0; i < preEncryptChars.length; i++)
        {
            // Realizamos el XOR
            resultChars[i] = ((char)((int)preEncryptChars[i]^(int)passwordChars[k]));
            
            // En cada iteración se usa el siguiente caracter 
            // como semilla a menos que la longitud de la cadena sea menor 
            // enonces se empieza por el principio de nuevo
            k = ++k % passwordLongitud;
        }

        return String.copyValueOf(resultChars);
    }
    
    /**
	 * Genera una clave MD5 a partir de un String
	 * 
	 * @param input Texto a utilizar para calcular el MD5.
	 * @return Codigo MD5 asociado al texto suministrado.
	 */
    public static String md5String(String input){
            String res = "";
            try {
                MessageDigest algorithm = MessageDigest.getInstance("MD5");
                algorithm.reset();
                algorithm.update(input.getBytes());
                byte[] md5 = algorithm.digest();
                String tmp = "";
                for (int i = 0; i < md5.length; i++) {
                    tmp = (Integer.toHexString(0xFF & md5[i]));
                    if (tmp.length() == 1) {
                        res += "0" + tmp;
                    } else {
                        res += tmp;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {}
            return res;
        }

}
