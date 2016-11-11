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
 * @Description 添加好友
 */
public class HttpTest7 {

    public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

//        json方式
        JSONObject jsonParam = new JSONObject();
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");


        httpPost.setEntity(entity);
        httpPost.addHeader("Authorization","Bearer YWMtccbgCIVOEeaXEk_gqkMNAQAAAVikt-LigME2q8yO8iOuT5diPoyAeOl6HwE");
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
        String result = httpPostWithJSON("https://a1.easemob.com/easemob-demo/chatdemoui/users/888xin/contacts/users/888xin1");
        System.out.println(result);
    }

}
