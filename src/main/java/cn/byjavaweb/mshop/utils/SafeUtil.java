package cn.byjavaweb.mshop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SafeUtil {
    /**
     * md5加密字符串
     */
    public final static String md5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return Base64.getEncoder().encodeToString(messageDigest.digest());
    }

    /**
     * sha1加密字符串
     */
    public final static String sha1(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(str.getBytes());
        return Base64.getEncoder().encodeToString(messageDigest.digest());
    }

    /**
     * 使用特定加密范式加密
     */
    public final static String encode(String str) throws NoSuchAlgorithmException {
        return md5(sha1(md5(str)));
    }
}
