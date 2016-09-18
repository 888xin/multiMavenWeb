package com.lhx.test;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by lhx on 2016/8/8 14:34
 *
 * @Description
 */
public class UploadDemo3 {

    String bucketname ;
    String ACCESS_KEY ;
    String SECRET_KEY ;
    String pfops ;

    public UploadDemo3(String photoKey) {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        ACCESS_KEY = "-vqhfR2K9C1GhyBoMHlheiVsKzJ1xV6dOAGa3xYk";
        SECRET_KEY = "XD55KRxhw03g7WxtT49yaT8jwHUdmUBVZVgeMiPn";
        //要上传的空间
        String bucketname = "xin8";

        //设置转码操作参数
        String fops = "vframe/jpg/offset/1/w/480/h/360";

        //上传视频截图的保存路径
        String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + photoKey + ".jpg");
        pfops = fops + "|saveas/" + urlbase64;

    }


    public void upload(String videoKey) throws IOException {
        try {
            //上传文件的路径
            String FilePath = "C:\\Users\\Lifeix\\Desktop\\aa\\aa.mp4";
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建上传对象
            UploadManager uploadManager = new UploadManager();
            String token = auth.uploadToken(bucketname, null, 3600, new StringMap().putNotEmpty("persistentOps", pfops), true);
            Response res = uploadManager.put(FilePath, videoKey + ".mp4", token);
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
        String preUrl = "http://qn.video.l99.com/";
        String url1 = "http://7xo8gu.com1.z0.glb.clouddn.com/ltDBGzx8Eyb82IfeGrzg8aSlqpxA?avinfo";
        new UploadDemo3("myjpg").upload("myjpg");



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


