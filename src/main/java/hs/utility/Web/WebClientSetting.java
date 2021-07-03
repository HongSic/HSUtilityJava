package hs.utility.Web;

import java.net.HttpURLConnection;

public class WebClientSetting
{
    public boolean UseCache = false;
    public int ConnectTimeout = 1000;
    public int ReadTimeout = 1000;
    public String Charset = "UTF-8";

    void ApplyConnection(HttpURLConnection conn)
    {
        conn.setUseCaches(UseCache);
        conn.setConnectTimeout(ConnectTimeout);
        conn.setReadTimeout(ReadTimeout);
    }
}
