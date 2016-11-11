package com.lhx.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description 给群组添加用户（单个）
 */
public class HttpTest8 {

    //环信AppKey
    private final static String APP_KEY = "1164160929178145#888xin";
    //环信企业用户的token
    private final static String TOKEN = "Bearer YWMtWjVx9oYcEead2PeJmc3jWgAAAVip_VMTjVp-eYNczLRG8SOA4TFUJFwy34w";


    public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        httpPost.addHeader("Authorization", TOKEN);

        HttpResponse resp = client.execute(httpPost);
        System.out.println(resp.getStatusLine().getStatusCode());
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }


    public static void main(String[] args) throws Exception {
        String appKey = APP_KEY.replace("#","/") ;
        //群组ID
        String groupId = "247269659970109876";
        //被添加的用户名
        String userName = "888xin3";

        //String result = httpPostWithJSON("https://a1.easemob.com/1164160929178145/888xin/chatgroups/247268343671685544/users/888xin2");
        String result = httpPostWithJSON("https://a1.easemob.com/"+ appKey +"/chatgroups/"+groupId+"/users/"+ userName);
        System.out.println(result);
    }

}
