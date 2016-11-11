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
 * @Description 给群组添加用户（批量）
 */
public class HttpTest12 {

    //环信AppKey
    private final static String APP_KEY = "lifangwangl99#lifeixappbed";
    //环信企业用户的token
    private final static String TOKEN = "Bearer YWMtG7KlBobbEeaLvQHfOUGoUgAAAViu33Y7vqtU6sVMAQyZYRzHkQEbV8EJucA";


    public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        //批量被添加的用户名
        JSONObject jsonParam = new JSONObject();
        JSONArray jsonArray = new JSONArray();
//        jsonArray.put("10000237");
//        jsonArray.put("2014");
//        jsonArray.put("960747");
//        jsonArray.put("960749");
//        jsonArray.put("960753");
//        jsonArray.put("1409");
//        jsonArray.put("4");
        jsonArray.put("960752");
        jsonArray.put("809490");
        jsonArray.put("10000239");
//        jsonArray.put("20");
//        jsonArray.put("240");
//        jsonArray.put("1776");
        jsonParam.put("usernames", jsonArray);
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

        String result = httpPostWithJSON("https://a1.easemob.com/"+ appKey +"/chatgroups/"+groupId+"/users");
        System.out.println(result);
    }

}
