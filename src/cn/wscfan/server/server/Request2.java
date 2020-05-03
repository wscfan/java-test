package cn.wscfan.server.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @Author 王松
 * @Date 2020/4/26 23:46
 */
public class Request2 {
    // 协议信息
    private String requestInfo;
    // 请求方式
    private String method;
    // 请求url
    private String url;
    // 请求的参数
    private String queryStr;
    // 存储参数
    private Map<String, List<String>> parameterMap;
    private final String CRLF = "\r\n";
    public Request2(Socket client) throws IOException {
        this(client.getInputStream());
    }
    public Request2(InputStream is) {
        parameterMap = new HashMap<String, List<String>>();
        byte[] datas = new byte[1024 * 1024];
        int len;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        parseRequestInfo();
    }
    private void parseRequestInfo() {
        System.out.println("----分解开始------");
        System.out.println("----1、获取请求方式-----");
        this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
        this.method = this.method.trim();
        System.out.println(this.method);
        System.out.println("----2、获取url----");
        int startIdx = this.requestInfo.indexOf("/") + 1;
        int endIdx = this.requestInfo.indexOf("HTTP/");
        this.url = this.requestInfo.substring(startIdx, endIdx);
        this.url = this.url.trim();
        int queryIdx = this.url.indexOf("?");
        if (queryIdx >= 0) {
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            this.queryStr = urlArray[1];
        }
        System.out.println(this.url);
        if (method.equals("post")) {
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (null == queryStr) {
                queryStr = qStr;
            } else {
                queryStr += "&" + qStr;
            }
        }
        queryStr = null == queryStr ? "" : queryStr;
        System.out.println(method + "----->" + url + "------->" + queryStr);
        // 转成 Map
        convertMap();
    }
    // 处理请求参数为 Map
    private void convertMap() {
        // 分割字符串
        String[] keyValues = this.queryStr.split("&");
        for (String queryStr: keyValues) {
            // 再次分割字符串
            String[] kv = queryStr.split("=");
            kv = Arrays.copyOf(kv, 2);
            // 获取key 和 value
            String key = kv[0];
            String value = kv[1] == null ? null : decode(kv[1], "utf-8");
            // 存储到 map 中
            if (!parameterMap.containsKey(key)) {
                parameterMap.put(key, new ArrayList<String>());
            }
            parameterMap.get(key).add(value);
        }
    }

    /**
     * 处理中文
     * @return
     */
    private String decode(String value, String enc) {
        try {
            return java.net.URLDecoder.decode(value, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getParameterValues(String key) {
        List<String> values = this.parameterMap.get(key);
        if (null == values || values.size() < 1) {
            return null;
        }
        return values.toArray(new String[0]);
    }
    public String getParameters(String key) {
        String[] values = getParameterValues(key);
        return values == null ? null : values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryStr() {
        return queryStr;
    }
}
