package com.lhx.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description 获取群组
 */
public class HttpTest11 {

    //环信AppKey
    private final static String APP_KEY = "lifangwangl99#lifeixappbed";
    //环信企业用户的token
    private final static String TOKEN = "Bearer YWMtG7KlBobbEeaLvQHfOUGoUgAAAViu33Y7vqtU6sVMAQyZYRzHkQEbV8EJucA";


    public static String httpPostWithJSON(String url) throws Exception {

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        httpGet.addHeader("Authorization", TOKEN);

        HttpResponse resp = client.execute(httpGet);

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

        //页数
        int page = 20 ;

        //String result = httpPostWithJSON("https://a1.easemob.com/1164160929178145/888xin/chatgroups/247268343671685544/users/888xin2");
        String result = httpPostWithJSON("https://a1.easemob.com/"+ appKey +"/chatgroups?limit=" + page);
        System.out.println(result);
    }

}
