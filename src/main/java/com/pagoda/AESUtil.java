package com.pagoda;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @author dell
 */
public class AESUtil {
    public static void main(String[] args)
            throws Exception {
    }

    public static String encrypt(String keyStr, String toEncryptString) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        byte[] input = toEncryptString.getBytes("UTF-8");
        byte[] keyBytes = getKeyBytes(keyStr);

        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, key);

        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);

        String c = byte2HexStr(cipherText);

        return c;
    }

    public static byte[] encrypt(String keyStr, byte[] data) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        byte[] keyBytes = getKeyBytes(keyStr);

        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, key);

        byte[] cipherText = new byte[cipher.getOutputSize(data.length)];
        int ctLength = cipher.update(data, 0, data.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return cipherText;
    }

    public static String decrypt(String keyStr, String toDecryptString) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        byte[] toDecrypt = hexStr2Bytes(toDecryptString);
        byte[] keyBytes = getKeyBytes(keyStr);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(2, key);

        byte[] cipherText = new byte[cipher.getOutputSize(toDecrypt.length)];
        int ctLength = cipher.update(toDecrypt, 0, toDecrypt.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);

        String c = new String(cipherText, "UTF-8");

        return c;
    }

    public static byte[] decrypt(String keyStr, byte[] data) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        byte[] keyBytes = getKeyBytes(keyStr);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(2, key);

        byte[] cipherText = new byte[cipher.getOutputSize(data.length)];
        int ctLength = cipher.update(data, 0, data.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return cipherText;
    }

    public static String byte2HexStr(byte[] b) {
        String hs = "";
        String stmp = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1) {
                stringBuilder.append("0" + stmp);
            } else {
                stringBuilder.append(stmp);
            }
        }
        hs = stringBuilder.toString();
        return hs.toUpperCase();
    }

    private static byte[] getKeyBytes(String keyStr)
            throws Exception {
        byte[] tmp = keyStr.getBytes("utf-8");

        byte[] arrB = new byte[16];

        for (int i = 0; (i < tmp.length) && (i < arrB.length); i++) {
            arrB[i] = tmp[i];
        }
        return arrB;
    }

    private static byte uniteBytes(String src0, String src1) {
        byte b0 = Byte.decode("0x" + src0).byteValue();
        b0 = (byte) (b0 << 4);
        byte b1 = Byte.decode("0x" + src1).byteValue();
        byte ret = (byte) (b0 | b1);
        return ret;
    }

    public static byte[] hexStr2Bytes(String src) {
        int m = 0;
        int n = 0;
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
        }
        return ret;
    }
}

