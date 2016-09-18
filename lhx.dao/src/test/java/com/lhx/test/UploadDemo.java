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
//public class UploadDemo {
//    //设置好账号的ACCESS_KEY和SECRET_KEY
//    String ACCESS_KEY = "-vqhfR2K9C1GhyBoMHlheiVsKzJ1xV6dOAGa3xYk";
//    String SECRET_KEY = "XD55KRxhw03g7WxtT49yaT8jwHUdmUBVZVgeMiPn";
//    //要上传的空间
//    String bucketname = "xin8";
//    //上传到七牛后保存的文件名
//    String key = "my-java.mp4";
//    //上传文件的路径
//    String FilePath = "C:\\Users\\Lifeix\\Desktop\\aa\\aa.mp4";
//
//    //密钥配置
//    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
//    //创建上传对象
//    UploadManager uploadManager = new UploadManager();
//
//    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
//    public String getUpToken(){
//        return auth.uploadToken(bucketname);
//    }
//
//    public void upload() throws IOException {
//        try {
//            //调用put方法上传
//            Response res = uploadManager.put(FilePath, key, getUpToken());
//            //打印返回的信息
//            System.out.println(res.bodyString());
//        } catch (QiniuException e) {
//            Response r = e.response;
//            // 请求失败时打印的异常的信息
//            System.out.println(r.toString());
//            try {
//                //响应的文本信息
//                System.out.println(r.bodyString());
//            } catch (QiniuException e1) {
//                //ignore
//            }
//        }
//    }
//
//    public static void main(String args[]) throws IOException{
//        new UploadDemo().upload();
//    }
//
//}


public class UploadDemo {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "-vqhfR2K9C1GhyBoMHlheiVsKzJ1xV6dOAGa3xYk";
    String SECRET_KEY = "XD55KRxhw03g7WxtT49yaT8jwHUdmUBVZVgeMiPn";
    //要上传的空间
    String bucketname = "xin8";


    //上传到七牛后保存的文件名
    String key = "myjava";
    //上传文件的路径
    String FilePath = "C:\\Users\\Lifeix\\Desktop\\aa\\aa.mp4";

    //设置转码操作参数
//    String fops = "avthumb/mp4/s/640x360/vb/1.25m";
//    String fops = "vframe/jpg/offset/1/w/480/h/360/rotate/90";
    String fops = "vframe/jpg/offset/1/w/480/h/360";
//    String fops = "avinfo";
//    String fops = "avinfo|vframe/jpg/offset/1/w/480/h/360/rotate/90";
    //设置转码的队列
//    String pipeline = "hengxin";
    String pipeline = "video_pipeline";


    //可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
//    String urlbase64 = UrlSafeBase64.encodeToString("目标Bucket_Name:自定义文件key");
    String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" +key +".jpg");
    String pfops = fops + "|saveas/"+ urlbase64;

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //上传策略中设置persistentOps字段和persistentPipeline字段
    public String getUpToken(){
        return auth.uploadToken(bucketname,null,3600,new StringMap()
                .putNotEmpty("persistentOps", pfops)
                .putNotEmpty("persistentPipeline", pipeline), true);
    }

    public void upload() throws IOException{
        try {
            //调用put方法上传
            String str = getUpToken();
            System.out.println(str);
            Response res = uploadManager.put(FilePath, key+".mp4", str);
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
    }

    public static void main(String args[]) throws IOException, JSONException {
        String url = "http://7xo8gu.com1.z0.glb.clouddn.com/";
        String url1 = "http://7xo8gu.com1.z0.glb.clouddn.com/ltDBGzx8Eyb82IfeGrzg8aSlqpxA?avinfo";
        new UploadDemo().upload();


//        Client client = new Client();
//        WebResource resource = client.resource("http://7xo8gu.com1.z0.glb.clouddn.com/ltDBGzx8Eyb82IfeGrzg8aSlqpxA?avinfo");
//        String str = resource.type(MediaType.WILDCARD).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
//        JSONObject jsonObject = new JSONObject(str);
//        JSONArray jsonArray = jsonObject.getJSONArray("streams");
//        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
//        System.out.println(jsonObject1.getInt("width"));
//        System.out.println(jsonObject1.getInt("height"));
//        System.out.println(jsonObject1.getString("duration"));
    }

}


