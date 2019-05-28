package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月07日上午11:49
 * @Function : todo
 */
public class HttpClientUtil {


    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";

    public static String send(String url, String method) {
        return send(url, method, null);
    }

    public static String send(String url, String method, String rawBody) {
        HttpURLConnection conn = null;
        BufferedReader rd = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        String response = null;
        DataOutputStream dos = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            if (null != rawBody && !"".equals(rawBody)) {
                dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(rawBody);
                dos.flush();
            }

            conn.connect();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            closeAll(conn, rd);
        }
        return response;
    }


    public static String send(String url, String method, String rawBody, int connectTimeout, int readTimeout) {
        HttpURLConnection conn = null;
        BufferedReader rd = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        String response = null;
        DataOutputStream dos = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            conn.setReadTimeout(readTimeout);
            conn.setConnectTimeout(connectTimeout);
            conn.setUseCaches(false);
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            if (null != rawBody && !"".equals(rawBody)) {
                dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(rawBody);
                dos.flush();

            }

            conn.connect();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            closeAll(conn, rd);
        }
        return response;
    }

    private static void closeAll(HttpURLConnection conn, BufferedReader rd) {
        try {
            if (rd != null) {
                rd.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
