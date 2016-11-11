package com.lhx.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description 创建群组
 */
public class HttpTest5 {

    public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

//        json方式
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("groupname", "testbyxinlifeix");
        jsonParam.put("desc", "server create group");
        jsonParam.put("public", false);
        jsonParam.put("maxusers", 20);
        jsonParam.put("approval", true);
        jsonParam.put("owner", "888xin2");
        System.out.println(jsonParam.toString());
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");


        httpPost.setEntity(entity);
        httpPost.addHeader("Authorization","Bearer YWMtWjVx9oYcEead2PeJmc3jWgAAAVip_VMTjVp-eYNczLRG8SOA4TFUJFwy34w");


//        表单方式
//        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
//        pairList.add(new BasicNameValuePair("name", "admin"));
//        pairList.add(new BasicNameValuePair("pass", "123456"));
//        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));


        HttpResponse resp = client.execute(httpPost);
        System.out.println(resp.getStatusLine().getStatusCode());
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }


    public static void main(String[] args) throws Exception {
        String result = httpPostWithJSON("http://a1.easemob.com/1164160929178145/888xin/chatgroups");
        System.out.println(result);
    }

}
