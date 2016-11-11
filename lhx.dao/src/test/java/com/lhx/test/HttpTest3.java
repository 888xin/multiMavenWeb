package com.lhx.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description
 */
public class HttpTest3 {

    public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

//        json方式
//        JSONObject jsonParam = new JSONObject();
//        jsonParam.put("name", "admin");
//        jsonParam.put("pass", "123456");
//        StringEntity entity = new StringEntity("{\"grant_type\":\"password\",\"username\":\"888xin\",\"password\":\"465864000\"}","utf-8");//解决中文乱码问题
        StringEntity entity = new StringEntity("{\"grant_type\":\"password\",\"username\":\"888xin1\",\"password\":\"465864\"}","utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");

        httpPost.setEntity(entity);
        System.out.println();


//        表单方式
//        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
//        pairList.add(new BasicNameValuePair("name", "admin"));
//        pairList.add(new BasicNameValuePair("pass", "123456"));
//        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));


        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }


    public static void main(String[] args) throws Exception {
//        String result = httpPostWithJSON("http://a1.easemob.com/easemob-demo/chatdemoui/token");
        String result = httpPostWithJSON("http://a1.easemob.com/1164160929178145/888xin/token");
        System.out.println(result);
    }

}
