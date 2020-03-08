/**CMSC203 Project 3
 * The CryptoManager class will encrypt and decrypt a string
 * based on provided key and bellaso string
 * @author Yared Fikremariam
 *
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		boolean flag=true;
		//determines if a string is within the allowable bounds of ASCII
		//codes according to the LOWER_BOUND and UPPER_BOUND characters.
		for(int i=0;i<plainText.length();i++)
		{
		if(!((int)plainText.charAt(i)>=LOWER_BOUND && (int)plainText.charAt(i)<=UPPER_BOUND))
		{ //false if any character is outside the bounds
		flag=false;
		break;
		}
		}
		//returns true if all characters are within the allowable bounds
		return flag;
		
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText="";
		
		//encryption
		for(int i=0;i<plainText.length();i++)
		{
			
			char c=(char)Wrapper(((int)plainText.charAt(i)+key));
			encryptedText+=Character.toString(c);
			
			
					
		}
		//return encrypted text
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText="";
		
		//adjusts the bellaso string according the plain text
		while(bellasoStr.length()<plainText.length())
		{
			
			
			bellasoStr+=bellasoStr.substring(0, bellasoStr.length());
		}
		
		//encryption
		for(int i=0;i<plainText.length();i++)
		{
			char c=(char)(Wrapper((int)plainText.charAt(i)+(int)bellasoStr.charAt(i)));
			encryptedText+=Character.toString(c);
			
		}
		
		//return encrypted  text
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText="";
		//decryption
		for(int i=0;i<encryptedText.length();i++)
		{
			char c=(char)Wrapper(((int)encryptedText.charAt(i)-key));
			decryptedText+=Character.toString(c);
			
		}
		
		//return decrypted text
		return decryptedText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) 
	{
		String decryptedText= "";
		//adjust the bellaso strings length according to the encrypted text
		while(bellasoStr.length()< encryptedText.length())
		{
			
			
			bellasoStr+=bellasoStr.substring(0, bellasoStr.length());
		}
		
		//decryption
		for(int i=0;i< encryptedText.length();i++)
		{
			
			char c=(char)(Wrapper((int)encryptedText.charAt(i)-((int)(bellasoStr.charAt(i)))));
			decryptedText+=Character.toString(c);
		}
		//return the decrypted text
		return decryptedText;
		
	}
	
	/**
	 * This method checks if key is in bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters.
	 * And wraps it around so that it stays within the specified range
	 * @param key key to be checked and wrapped
	 * @return The wrapped around key
	 */
	public static int Wrapper(int key)
	{
		while (key>UPPER_BOUND) 
		{
			key-= RANGE;
			
		}
		
		while(key<LOWER_BOUND)
		{
			key+=RANGE;
		}
		return key;
	}
	
}
