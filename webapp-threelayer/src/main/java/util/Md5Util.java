package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public static String getMd5Str(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("md5");
        md.update(data.getBytes());
        byte[] digest = md.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : digest) {
            stringBuffer.append(String.format("%02x", b));
        }
        String passMd5 = stringBuffer.toString();
        return passMd5;
    }
}
