package com.lmg.rss.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequest {
    private static CloseableHttpClient httpClient = null;
    private final static Object        syncLock   = new Object();
    
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    private static Logger              log        = Logger.getLogger(HttpRequest.class);
    
    
    public static String sendGet(String url, Charset charset, String ip) {
        return get(url, charset);
    }
    
    
    public static String sendGet(String url, Charset charset) {
        return get(url, charset);
    }
    
    
    private static void config(HttpRequestBase httpRequestBase) {
        // 设置Header等
        // httpRequestBase.setHeader("User-Agent", "Mozilla/5.0");
        // httpRequestBase
        // .setHeader("Accept",
        // "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        // httpRequestBase.setHeader("Accept-Language",
        // "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");// "en-US,en;q=0.5");
        // httpRequestBase.setHeader("Accept-Charset",
        // "ISO-8859-1,utf-8,gbk,gb2312;q=0.7,*;q=0.7");
        
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(Integer.parseInt(System.getProperty("ConnectTimeout", "5000"))).setConnectionRequestTimeout(Integer.parseInt(System.getProperty("connectionRequestTimeout", "2000"))).setSocketTimeout(Integer.parseInt(System.getProperty("socketTimeout", "5000"))).build();
        httpRequestBase.setConfig(requestConfig);
    }
    
    
    /**
     * 
     * @Title: getHttpClient
     * @Description: 获取HttpClient对象
     * @param url
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2016年10月24日下午5:25:18
     */
    public static CloseableHttpClient getHttpClient(String url) {
        String hostname = url.split("/")[2];
        int port = 80;
        if (hostname.contains(":")){
            String[] arr = hostname.split(":");
            hostname = arr[0];
            port = Integer.parseInt(arr[1]);
        }
        if (httpClient == null){
            synchronized (syncLock){
                if (httpClient == null){
                    httpClient = createHttpClient(200, 40, 100, hostname, port);
                }
            }
        }
        return httpClient;
    }
    
    
    /**
     * 
     * @Title: createHttpClient
     * @Description: TODO
     * @param maxTotal
     * @param maxPerRoute
     * @param maxRoute
     * @param hostname
     * @param port
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2016年10月24日下午5:24:09
     */
    public static CloseableHttpClient createHttpClient(int maxTotal, int maxPerRoute, int maxRoute, String hostname,
            int port) {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", plainsf).register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        // 将最大连接数增加
        cm.setMaxTotal(maxTotal);
        // 将每个路由基础的连接增加
        cm.setDefaultMaxPerRoute(maxPerRoute);
        HttpHost httpHost = new HttpHost(hostname, port);
        // 将目标主机的最大连接数增加
        cm.setMaxPerRoute(new HttpRoute(httpHost), maxRoute);
        
        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= 2){// 如果已经重试了5次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException){// 如果服务器丢掉了连接，那么就重试
                    return true;
                }
                if (exception instanceof SSLHandshakeException){// 不要重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException){// 超时
                    return false;
                }
                if (exception instanceof UnknownHostException){// 目标服务器不可达
                    return false;
                }
                if (exception instanceof ConnectTimeoutException){// 连接被拒绝
                    return false;
                }
                if (exception instanceof SSLException){// SSL握手异常
                    return false;
                }
                
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                org.apache.http.HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)){
                    return true;
                }
                return false;
            }
        };
        
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setRetryHandler(httpRequestRetryHandler).build();
        
        return httpClient;
    }
    
    
    /**
     * 
     * @Title: get
     * @Description: 发送get请求
     * @param url
     * @param charset
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2016年10月24日下午5:25:36
     */
    public static String get(String url, Charset charset) {
        HttpGet httpget = new HttpGet(url);
        config(httpget);
        CloseableHttpResponse response = null;
        try{
            response = getHttpClient(url).execute(httpget, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, charset);
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e){
            log.error("get执行错误,url:" + url + ",error:" + e.getMessage(), e);
        } finally{
            try{
                if (response != null)
                    response.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    public static String post(String url, Charset charset) {
        HttpPost httpget = new HttpPost(url);
        config(httpget);
        CloseableHttpResponse response = null;
        try{
            response = getHttpClient(url).execute(httpget, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, charset);
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e){
            log.error("get执行错误,url:" + url + ",error:" + e.getMessage());
        } finally{
            try{
                if (response != null)
                    response.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        HttpURLConnection conn = null;
        try{
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }
        } catch (Exception e){
            System.out.println("发送 POST 请求出现异常！url:" + url + e);
        }
        // 使用finally块来关闭输出流、输入流
        finally{
            try{
                if (out != null){
                    out.close();
                }
                if (in != null){
                    in.close();
                }
                
                if (conn != null){
                    conn.disconnect();
                    conn = null;
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) throws JSONException {
        // String result =
        // sendGet("https://api.weixin.qq.com/sns/jscode2session?appid=wxf1ad00155fc2762b&secret=8885ef2f20bbc5ba6590628458ce7a41&js_code=013E1fju1LlpQc0oa2hu1g2hju1E1fj4&grant_type=authorization_code",
        // Charset.forName("UTF-8"));
        String url = "http://www.123gps.com.cn/rest/interface/getTmpByVehicleNo?vehicleNo=沪A11111&password=JY001&startTime=2017-11-15%2014:25:29&endTime=2017-11-17%2010:25:29&hasLocation=1&userName=JY001";
        
        String result = sendGet(url, Charset.forName("UTF-8"));
        JSONObject jsonObject = new JSONObject(result);
        System.out.println(jsonObject);
    }
}
