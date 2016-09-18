package com.lhx.test;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by lhx on 2016/8/8 14:34
 *
 * @Description
 */
public class UploadDemo5 {

    public static void main(String args[]) throws IOException, JSONException {
        //前缀
        String preUrl =  "http://qn.video.l99.com/";

        Client client = new Client();
        WebResource resource = client.resource("http://192.168.2.156:8080/tiyu/rest/content/video/token");
        String str = resource.type(MediaType.WILDCARD).accept(MediaType.APPLICATION_JSON_TYPE).header("authorization", "Basic MzA4MDE1Mjo2Wkp5dExkL3haNnlhQ3c4QnNveS8wNnJmR0ZZQTZRUUsrWmp3amFRNStOTitvSndmVU52bUhtWnNDQ215S2FJ")
                .get(String.class);
        JSONObject jsonObject1 = new JSONObject(str);
        JSONObject jsonObject2 = jsonObject1.getJSONObject("data");
        JSONArray jsonArray1 = jsonObject2.getJSONArray("keys");
        String token = jsonObject2.getString("token");
        String key = jsonArray1.getString(0);
        System.out.println(key);

        //创建上传对象
        UploadManager uploadManager = new UploadManager();
        try {
            //上传文件的路径
            String FilePath = "C:\\Users\\Lifeix\\Desktop\\aa\\aa.mp4";
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, token);
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }

        Client client2 = new Client();
        WebResource resource2 = client2.resource(preUrl + key +"?avinfo");
        String str2 = resource2.type(MediaType.WILDCARD).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        JSONObject jsonObject3 = new JSONObject(str2);
        JSONArray jsonArray = jsonObject3.getJSONArray("streams");
        JSONObject jsonObject4 = jsonArray.getJSONObject(0);
        System.out.println(jsonObject4.getInt("width"));
        System.out.println(jsonObject4.getInt("height"));
        System.out.println(jsonObject4.getString("duration"));
    }

}


