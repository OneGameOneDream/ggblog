package com.ggblog.modules.sys.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.util.UriUtils;

public class HttpHelper {
	
	
//	public static void main(String[] args) {
//		byte[] img=doGetRequestForFile("http://i0.hdslb.com/bfs/archive/0a0c3cc4c87b5785d4882afffe143995dde8e01b.jpg");
//		if(img!=null) {
//			File file = new File("D:/1234.jpg");
//			FileOutputStream fos;
//			try {
//				fos = new FileOutputStream(file);
//				fos.write(img,0,img.length);   
//			      fos.flush();   
//			      fos.close();  
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}   
//		      
//		}
//	}
	
	public static byte[] doGetRequestForFile(String urlStr) {

	    InputStream is = null;
	    ByteArrayOutputStream os = null;
	    byte[] buff = new byte[1024];
	    int len = 0;
	    try {
	      URL url = new URL(urlStr);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setDoOutput(true);
	      conn.setRequestMethod("GET");
	      conn.connect();
	      is = conn.getInputStream();
	      os = new ByteArrayOutputStream();
	      while ((len = is.read(buff)) != -1) {
	        os.write(buff, 0, len);
	      }
	      return os.toByteArray();
	    } catch (IOException e) {
	       return null;
	    } finally {
	      if (is != null) {
	        try {
	          is.close();
	        } catch (IOException e) {
	        }
	      }
	      if (os != null) {
	        try {
	          os.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	  }
	
	
	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            //Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}
