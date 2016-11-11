package com.lhx.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description 给群组发消息
 */
public class HttpTest14 {

    //环信AppKey
    private final static String APP_KEY = "1164160929178145#888xin";
    //环信企业用户的token
    private final static String TOKEN = "Bearer YWMtWjVx9oYcEead2PeJmc3jWgAAAVip_VMTjVp-eYNczLRG8SOA4TFUJFwy34w";


    public static String httpPostWithJSON(String url, String userId) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        //批量被添加的用户名
        JSONObject jsonParam = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonArray.put("247268343671685544");
        jsonParam.put("target_type", "chatgroups");
        jsonParam.put("from", userId);
        jsonParam.put("target", jsonArray);
        JSONObject jsonParam1 = new JSONObject();
        jsonParam1.put("type", "txt");
        jsonParam1.put("msg", "我来也……");
        jsonParam.put("msg", jsonParam1);
        System.out.println(jsonParam.toString());
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");


        httpPost.setEntity(entity);
        httpPost.addHeader("Authorization", TOKEN);

        HttpResponse resp = client.execute(httpPost);

        System.out.println(resp.getStatusLine().getStatusCode());
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        } else if(resp.getStatusLine().getStatusCode() == 404) {
            System.out.println("此群组id不存在");
        } else if(resp.getStatusLine().getStatusCode() == 401) {
            System.out.println("未授权[无token、token错误、token过期]");
        }
        return respContent;
    }


    public static void main(String[] args) throws Exception {
        String appKey = APP_KEY.replace("#","/") ;
        //群组ID
        String groupId = "247624089924010420";

        String result = httpPostWithJSON("https://a1.easemob.com/"+ appKey +"/messages", "888xin27");
        System.out.println(result);
    }

}
