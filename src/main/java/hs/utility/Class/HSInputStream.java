package hs.utility.Class;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ParkHongSic on 2017-10-15.
 * @author 박홍식 (ParkHongSic, 조장찡, gpo04174, HSKernel)
 */

public class HSInputStream extends InputStream
{
    long TotalRead;
    InputStream inputstream;
    public HSInputStream(InputStream inputstream){this.inputstream = inputstream; TotalRead = 0;}

    public long getTotalRead(){return TotalRead;}
    public InputStream getStream(){return inputstream;}

    byte buffer[] = new byte[1];
    @Override
    public int read() throws IOException
    {
        buffer[0] = 0;
        int a = inputstream.read(buffer, 0, 1);
        if(a > 0)TotalRead += a;
        return a;
    }

    @Override
    public int read(byte buffer[]) throws IOException
    {
        int a = inputstream.read(buffer, 0, buffer.length);
        if(a > 0)TotalRead += a;
        return a;
    }

    @Override
    public int read(byte buffer[], int off, int len) throws IOException
    {
        int a = inputstream.read(buffer, off, len);
        if(a > 0)TotalRead += a;
        return a;
    }

    @Override
    public void close() throws IOException{inputstream.close();}
}
