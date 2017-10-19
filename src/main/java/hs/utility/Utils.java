package hs.utility;

     /*
     자바 주석문 다는 방법
     @see class_name : “See also”라는 항목을 만들어 해당 클래스와 연결해준다.
     @see class_name#method_name : “See also”라는 항목을 만들어 특정 메소드와 연결해준다.
     @version text : HTML 파일의 버전을 표시하는 항목을 만들어 준다.
     @author text : HTML 파일의 저자를 표시하는 항목을 만들어 준다.
     @param name description : 특정 메소드가 취하는 파라메터를 기술할 때 사용된다.
     @return description : 특정 메소드의 리턴값을 기술할 때 사용된다.
     @exception class_name : 특정 메소드가 발생시킬 수 있는 에외상황을 기술할 때 사용된다.
     */

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ParkHongSic on 2016-09-06.
 * @author 박홍식 (ParkHongSic, 조장찡, gpo04174, HSKernel)
 */
public class Utils
{
    public static class NumricUtility
    {
        public enum ByteUnit{Byte, KByte, MByte, GByte, TByte, PByte, OutByte}
        public static String getByteString(long Byte, boolean Dec, boolean Comma)
        {
            if (Dec)
            {
                if (Byte <= 1000) return getByteString(Byte, Dec, false, ByteUnit.Byte, Comma);
                else if (Byte <= 1000000) return getByteString(Byte, Dec, false, ByteUnit.KByte, Comma);
                else if (Byte <= 1000000000) return getByteString(Byte, Dec, false, ByteUnit.MByte, Comma);
                else if (Byte <= 1000000000000L) return getByteString(Byte, Dec, false, ByteUnit.GByte, Comma);
                else if (Byte <= 1000000000000000L) return getByteString(Byte, Dec, false, ByteUnit.TByte, Comma);
                else if (Byte <= 1000000000000000000L) return getByteString(Byte, Dec, false, ByteUnit.PByte, Comma);
                else return getByteString(Byte, Dec, false, ByteUnit.OutByte, Comma);
            }
            else
            {
                if (Byte <= 1024) return getByteString(Byte, Dec, false, ByteUnit.Byte, Comma);
                else if (Byte <= 1048576) return getByteString(Byte, Dec, false, ByteUnit.KByte, Comma);
                else if (Byte <= 1073741824) return getByteString(Byte, Dec, false, ByteUnit.MByte, Comma);
                else if (Byte <= 1099511627776L) return getByteString(Byte, Dec, false, ByteUnit.GByte, Comma);
                else if (Byte <= 1125899906842624L) return getByteString(Byte, Dec, false, ByteUnit.TByte, Comma);
                else if (Byte <= 1152921504606846976L) return getByteString(Byte, Dec, false, ByteUnit.PByte, Comma);
                else return getByteString(Byte, Dec, false, ByteUnit.OutByte, Comma);
            }
        }

        public static String getByteString(long Byte, boolean Dec, boolean isBit, boolean Comma)
        {
            if (Dec)
            {
                if (Byte <= 1000) return getByteString(Byte, Dec, isBit, ByteUnit.Byte, Comma);
                else if (Byte <= 1000000) return getByteString(Byte, Dec, isBit, ByteUnit.KByte, Comma);
                else if (Byte <= 1000000000) return getByteString(Byte, Dec, isBit, ByteUnit.MByte, Comma);
                else if (Byte <= 1000000000000L) return getByteString(Byte, Dec, isBit, ByteUnit.GByte, Comma);
                else if (Byte <= 1000000000000000L) return getByteString(Byte, Dec, isBit, ByteUnit.TByte, Comma);
                else if (Byte <= 1000000000000000000L) return getByteString(Byte, Dec, isBit, ByteUnit.PByte, Comma);
                else return getByteString(Byte, Dec, isBit, ByteUnit.OutByte, Comma);
            }
            else
            {
                if (Byte <= 1024) return getByteString(Byte, Dec, isBit, ByteUnit.Byte, Comma);
                else if (Byte <= 1048576) return getByteString(Byte, Dec, isBit, ByteUnit.KByte, Comma);
                else if (Byte <= 1073741824) return getByteString(Byte, Dec, isBit, ByteUnit.MByte, Comma);
                else if (Byte <= 1099511627776L) return getByteString(Byte, Dec, isBit, ByteUnit.GByte, Comma);
                else if (Byte <= 1125899906842624L) return getByteString(Byte, Dec, isBit, ByteUnit.TByte, Comma);
                else if (Byte <= 1152921504606846976L) return getByteString(Byte, Dec, isBit, ByteUnit.PByte, Comma);
                else return getByteString(Byte, Dec, isBit, ByteUnit.OutByte, Comma);
            }
        }
        public static String getByteString(long Byte, boolean Dec, boolean isBit, ByteUnit unit, boolean Comma)
        {
            double a = -1;
            String format_float = Comma ? "%,.2f" : "%.2f";
            String format_int = Comma ? "%,d" : "%d";
            if (Dec)
            {
                if (unit == ByteUnit.Byte) return isBit ? String.format(format_int + " b", Byte) : String.format(format_int + " B", Byte);
                else if (unit == ByteUnit.KByte) {a = Byte / 1000d; return isBit ? String.format(format_float + " Kb", a * 8) : String.format(format_float + " KB", a);}
                else if (unit == ByteUnit.MByte) {a = Byte / 1000000d;return isBit ? String.format(format_float + " Mb", a * 8) : String.format(format_float + " MB", a);}
                else if (unit == ByteUnit.GByte) {a = Byte / 1000000000d; return isBit ? String.format(format_float + " Gb", a * 8) : String.format(format_float + " GB", a);}
                else if (unit == ByteUnit.TByte) {a = Byte / 1000000000000d; return isBit ? String.format(format_float + " Tb", a * 8) : String.format(format_float + " TB", a);}
                else if (unit == ByteUnit.PByte) {a = Byte / 1000000000000000d; return isBit ? String.format(format_float + " Pb", a * 8) : String.format(format_float + " PB", a);}
                else return "Out of Byte";
            }
            else
            {
                if (unit == ByteUnit.Byte) return isBit ? String.format(format_int + " b", Byte) : String.format(format_int + " B", Byte);
                else if (unit == ByteUnit.KByte) {a = Byte / 1024d; return isBit ? String.format(format_float + " Kb", a * 8) : String.format(format_float + " KB", a);}
                else if (unit == ByteUnit.MByte) {a = Byte / 1048576d; return isBit ? String.format(format_float + " Mb", a * 8) : String.format(format_float + " MB", a);}
                else if (unit == ByteUnit.GByte) {a = Byte / 1073741824d; return isBit ? String.format(format_float + " Gb", a * 8) : String.format(format_float + " GB", a);}
                else if (unit == ByteUnit.TByte) {a = Byte / 1099511627776d; return isBit ? String.format(format_float + " Tb", a * 8) : String.format(format_float + " TB", a);}
                else if (unit == ByteUnit.PByte) {a = Byte / 1152921504606846976d; return isBit ? String.format(format_float + " Pb", a * 8) : String.format(format_float + " PB", a);}
                else return "Out of Byte";
            }
        }

        public static float getValuetoPercent(int Value,  float Percent) {return (Value / 100f) * Percent;}

        public static int getPeak(int[] Value, Boolean HighValue)
        {
            int tmp = 0;
            for(int i = 0; i < Value.length; i++)
                if(HighValue&&tmp < Value[i])tmp = Value[i];
                else if(!HighValue&&tmp > Value[i])tmp = Value[i];
            return tmp;
        }
    }

    public static class ImageUtility {

        public static Bitmap.CompressFormat getExtCompress(String mimeType)
        {
            if( "image/jpg".equals(mimeType) ||
                "image/jpeg".equals(mimeType) ||
                "image/pjpeg".equals(mimeType) ||
                "image/jpeg".equals(mimeType) ||
                "image/bmp".equals(mimeType) ||
                "image/x-windows-bmp".equals(mimeType))
                return Bitmap.CompressFormat.JPEG;
            else if("image/webp".equals(mimeType)) return Bitmap.CompressFormat.WEBP;
            else return Bitmap.CompressFormat.PNG;
        }
        public static String getExt(String mimeType)
        {
            if( "image/jpg".equals(mimeType) ||
                    "image/jpeg".equals(mimeType) ||
                    "image/pjpeg".equals(mimeType) ||
                    "image/jpeg".equals(mimeType) ||
                    "image/bmp".equals(mimeType) ||
                    "image/x-windows-bmp".equals(mimeType))
                return "jpg";
            else if("image/webp".equals(mimeType)) return "webp";
            else return "png";
        }
    }

    public static class StringUtility
    {
        //C# 에서쓰던 remove 가 너무편해서 제가 직접 구현
        public static String remove(String Value, int index) {return Value.substring(0, index);}

        //C# 은 String.Equals 가 있는데 JAVA 는 왜 없는거죠?
        public static boolean equals(String Compare1, String Compare2)
        {
            if(Compare1 == null && Compare2 == null)return true;
            try{return Compare1.equals(Compare2);}catch (Exception ex){return false;}
        }

        public static String AppendLineBreak(int Count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Count; i++) sb.append("\n");
            return sb.toString();
        }

        public static String AppendString(String[] AnyArray) {
            StringBuilder sb = new StringBuilder();
            if (AnyArray != null && AnyArray.length > 0) sb.append(AnyArray[0]);
            for (int i = 1; i < AnyArray.length; i++) sb.append("\n" + AnyArray[i]);
            return sb.toString();
        }

        public static String AppendString(String[] AnyArray, String Appender) {
            StringBuilder sb = new StringBuilder();
            if (AnyArray != null && AnyArray.length > 0) sb.append(AnyArray[0]);
            for (int i = 1; i < AnyArray.length; i++) {sb.append(Appender); sb.append(AnyArray[i]);}
            return sb.toString();
        }

        //이 함수 알고리즘 역시 내가 구현
        public static String makeStringSeparator(String str, String separator, int... Digit)
        {
            if (str.length() == 0)return "";
            StringBuilder sb = new StringBuilder();
            try
            {
                for (int i = 0,  offset = 0; i < Digit.length; i++, offset+=Digit[i-1])
                {
                    for (int j = 0; j < Digit[i]; j++)
                        sb.append(str.substring(offset+j, (offset+j)+1));
                    if(i < Digit.length-1)sb.append(separator);
                }
                return sb.toString();
            }catch (Exception ex){return sb.toString().equals("")?str:sb.toString();}
        }

        @Deprecated
        public static boolean isEmpty(String str)
        {
            boolean a = str == null;
            if(str != null)
                a = str.isEmpty();
            return a;
        }
        public static boolean isBlank(String str)
        {
            boolean a = str == null;
            if(!a)a = str.trim().equals("");
            return a;
        }
    }

    public static class WebUtility
    {
        /**
        * 앞에 프로토콜이 붙지않은 URL 주소 (예: www.google.com)를 검사하여 붙지 않았을 경우에는 프로토콜을 붙여서 반환합니다.
        *
        * @param URL URL주소 입니다.
        * @param Protocol 주소 앞에 프로토콜이 붙지않았을때 붙일 프로토콜 입니다. (중요!! 프로토콜 뒤에 "://" 불이지 마세요!!)
        * @return
        */
        public static String InvalidURL(String URL, String Protocol)
        {
            if(URL.indexOf("://")==-1)return Protocol+"://"+URL;
            else return URL;
        }
    }

    public static class StreamUtility
    {
        public static byte[] getByteArrayforInputStream(final InputStream Stream, final boolean Close){return getByteArrayforInputStream(Stream, 1024, Close);}
        public static byte[] getByteArrayforInputStream(final InputStream Stream, final int BufferLength, final boolean Close)
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] b =null;
            try
            {
                byte[] buffer = new byte[BufferLength];
                int len;
                while ((len = Stream.read(buffer)) > 0)
                    out.write(buffer, 0, len);

                b = out.toByteArray();
            }catch (Exception ex){ex.printStackTrace();}
            finally { try{out.close();}catch (Exception ex){} if(Close)try{Stream.close();}catch (Exception ex){}}
            return b;
        }
        public static String getStringtoInputStream(InputStream stream, int BufferSize)
        {
            byte[] bt = new byte[BufferSize];
            try
            {
                StringBuilder sb = new StringBuilder();
                while (stream.read(bt) != -1)
                    sb.append(new String(bt));
                return sb.toString();
            }
            catch (Exception ex){}
            return null;
        }
        public static String getStringtoInputStream(InputStream stream, int BufferSize, String Encoding)
        {
            byte[] bt = new byte[BufferSize];
            try
            {
                StringBuilder sb = new StringBuilder();
                while (stream.read(bt) != -1)
                    sb.append(new String(bt, Encoding));
                return sb.toString();
            }
            catch (Exception ex){}
            return null;
        }

        public static long copyStream(InputStream source, OutputStream dest, int bufferSize, boolean flush) throws  IOException
        {
            int DEFAULT_COPY_BUFFER_SIZE = 1024;

            int numBytes;
            long total = 0;

            try
            {
                byte[] buffer = new byte[bufferSize > 0 ? bufferSize : DEFAULT_COPY_BUFFER_SIZE];
                while ((numBytes = source.read(buffer)) != -1)
                {
                    // Technically, some read(byte[]) methods may return 0 and we cannot
                    // accept that as an indication of EOF.

                    if (numBytes == 0)
                    {
                        int singleByte = source.read();
                        if (singleByte < 0) {
                            break;
                        }
                        dest.write(singleByte);
                        if(flush) {
                            dest.flush();
                        }
                        ++total;
                        //if (listener != null) listener.bytesTransferred(total, 1, streamSize);
                        continue;
                    }

                    dest.write(buffer, 0, numBytes);
                    if(flush) dest.flush();
                    total += numBytes;
                    /*
                    if (listener != null) {
                        listener.bytesTransferred(total, numBytes, streamSize);
                    }*/
                }
            }
            catch (IOException e)
            {
                //throw new CopyStreamException("IOException caught while copying.", total, e);
                throw new IOException("IOException caught while copying.");
            }
            return total;
        }
    }
    public static class UnsignedUtil {
        public static int byte2uchar(byte b) {
            return (int) (b & 0xff);
        }

        public static byte uchar2byte(int c) {
            return (byte) (c & 0xff);
        }

        public static int short2ushort(short s) {
            return (int) (s & 0xffff);
        }

        public static short ushort2short(int s) {
            return (short) (s & 0xffff);
        }

        public static long int2uint(int i) {
            return (long) (i & 0xffffffffL);
        }

        public static int uint2int(long i) {
            return (int) (i & 0xffffffffL);
        }
    }

    public static class IOUtility
    {
        public static String getSafePath(String Path)
        {
            if(Path == null)return null;
            char[] banchar = new char[]{'\\', '/', '*', '?', '\"', '<', '>', '|'};
            Path = Path.replace(':', '꞉');
            for(int i = 0; i < banchar.length; i++)
                Path = Path.replace(banchar[i], '_');
            return Path;
        }
    }
}
