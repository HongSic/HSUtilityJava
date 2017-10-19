package hs.utility;

import java.io.InputStream;

/**
 * Created by ParkHongSic on 2017-09-09.
 * @author 박홍식 (ParkHongSic, 조장찡, gpo04174, HSKernel)
 */

public class MD5Manager
{
    private String MD5Hash;

    public MD5Manager(String str) { this.MD5Hash = getMD5Hash(str.getBytes());}
    public MD5Manager(byte[] data){ this.MD5Hash = getMD5Hash(data);}

    public String getMD5Hash(){return MD5Hash;}

    public static String getMD5Hash(byte[] data)
    {
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i)
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {  }
        return null;
    }

    public static String getMD5Hash(InputStream stream)
    {
        byte[] array = null;
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");

            byte[] buffer = new byte[8192];
            int numOfBytesRead;
            while((numOfBytesRead = stream.read(buffer)) > 0)
                md.update(buffer, 0, numOfBytesRead);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i)
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            return sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e) {  }
        catch (Exception ex) {ex.printStackTrace();  }
        return null;
    }

    public static boolean isBlank(String str)
    {
        boolean a = str == null;
        if(!a)a = str.trim().equals("");
        return a;
    }
}
