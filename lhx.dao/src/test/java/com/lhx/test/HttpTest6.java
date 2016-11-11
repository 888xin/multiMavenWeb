package com.lhx.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description 获取聊天室列表
 */
public class HttpTest6 {

    public static String httpPostWithJSON(String url) throws Exception {

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        httpGet.addHeader("Authorization","Bearer YWMtccbgCIVOEeaXEk_gqkMNAQAAAVikt-LigME2q8yO8iOuT5diPoyAeOl6HwE");
        System.out.println();




        HttpResponse resp = client.execute(httpGet);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }


    public static void main(String[] args) throws Exception {
        String result = httpPostWithJSON("http://a1.easemob.com/easemob-demo/chatdemoui/chatrooms");
        System.out.println(result);
    }

}
