package hs.utility.Web;

import org.json.*;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class WebClient
{
    public enum Method
    {
        GET,
        POST
    }

    public static HttpURLConnection getHttpConnection(URL url, Method Method, HashMap<String,String> Param, HashMap<String,String> Header, WebClientSetting Setting) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        if(Setting == null) Setting = new WebClientSetting();
        Setting.ApplyConnection(conn);

        conn.setRequestMethod(Method.toString());
        conn.setDoInput(true);
        conn.setDoOutput(true);
        if(Header != null)
        {
            for(Map.Entry<String, String> entry : Header.entrySet())
                conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if(Param != null)
        {
            //Charset charset = Charset.forName(Setting.Charset);

            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for(Map.Entry<String, String> entry : Param.entrySet())
            {
                if (first) first = false;
                else sb.append("&");

                sb.append(URLEncoder.encode(entry.getKey(), Setting.Charset));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), Setting.Charset));
            }

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Setting.Charset));
            writer.write(sb.toString());
            writer.flush();
            writer.close();
            os.close();
        }
        return conn;
    }

    public static String GetString(HttpURLConnection Connection) throws IOException
    {
        try
        {
            Connection.connect();
            if(Connection.getResponseCode() == 200)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = br.readLine()) != null) sb.append(line);
                return sb.toString();
            }
        }
        finally { if(Connection != null) Connection.disconnect(); }

        return null;
    }
}
