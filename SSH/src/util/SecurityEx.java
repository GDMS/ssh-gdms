package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SecurityEx {
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(SecurityEx.class);

	public static final String MD5 = "MD5";
	public static final String SHA1 = "SHA-1";
	private static final String SALT = "whosyourdaddy";

	public static byte[] getHash(String message) {
		byte[] digesta = getHash(message, MD5);
		return digesta;
	}

	public static byte[] getHash(String message, String type) {

		if (!type.equals(MD5) && !type.equals(SHA1))
			type = MD5;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(type);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] code = (message + SALT).getBytes();
		md.update(code);
		byte[] digesta = md.digest();

		log.debug("SecurityEx:getHash: " + byte2hex(digesta));
		return digesta;
	}

	public static boolean checkHash(String message, byte[] digestb) {
		boolean good = checkHash(message, digestb, MD5);
		return good;
	}

	public static boolean checkHash(String message, byte[] digestb, String type) {
		if (!type.equals(MD5) && !type.equals(SHA1))
			type = MD5;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(type);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] code = (message + SALT).getBytes();
		md.update(code);
		byte[] digesta = md.digest();
		boolean good = MessageDigest.isEqual(digesta, digestb);

		log.debug("SecurityEx:checkHash: " + byte2hex(digesta));
		return good;
	}

	public static String byte2hex(byte[] b) // 二行制转字符串
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}
}
