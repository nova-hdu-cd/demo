package com.chendong.demo.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * @author tim.liu  2020/3/2 11:08
 */
public class AESUtils {

    private final static String ALGO = "AES";

    /**
     * 用来进行加密的操作
     *
     * @param data
     * @param secretKey
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String secretKey) throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), ALGO);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] encVal = c.doFinal(data.getBytes("UTF-8"));
        return byte2hex(encVal);
    }

    /**
     * 用来进行解密的操作
     *
     * @param encryptedData
     * @param secretKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedData, String secretKey) throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), ALGO);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] decordedValue = hex2byte(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    private static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        String data = "{\"devId\":\"klsdjflkasdjflkjdsalfkjd\",\"dps\":{\"1\":true},\"t\":1431078303}";
        String passwordEnc = encrypt(data, "qwertu87tyredser");
        String passwordDec = decrypt(passwordEnc, "qwertu87tyredser");
        System.out.println("原来的密码 : " + data);
        System.out.println("加密后的密码 : " + passwordEnc);
        System.out.println("解密后的密码 : " + passwordDec);

    }
}
