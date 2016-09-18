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
public class UploadDem6 {

    private static String ACCESS_KEY = "-vqhfR2K9C1GhyBoMHlheiVsKzJ1xV6dOAGa3xYk";
    private static String SECRET_KEY = "XD55KRxhw03g7WxtT49yaT8jwHUdmUBVZVgeMiPn";
    private static String BUCKET_NAME = "xin8";
    private static String PIPELINE = "hengxin";
    public static String DOMAIN = "http://qn.video.l99.com/";

    public static String TRANS_TO_MP4 = "avthumb/mp4/r/24/vcodec/libx264";
    public static String CUT_ICON = "vframe/jpg/offset/2/w/250/h/200";


    private static String PFOPS = TRANS_TO_MP4  ;



    //上传策略中设置persistentOps字段和persistentPipeline字段
    public static String getToken(String key){
        String urlvideo = UrlSafeBase64.encodeToString(BUCKET_NAME + ":" +key +".mp4");
        String urljpg = UrlSafeBase64.encodeToString(BUCKET_NAME + ":" +key +".jpg");
        String pfops = TRANS_TO_MP4 + "|saveas/"+ urlvideo + ";" + CUT_ICON + "|saveas/"+ urljpg;
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        return auth.uploadToken(BUCKET_NAME,null,3600,new StringMap()
                .putNotEmpty("persistentOps", pfops)
                .putNotEmpty("persistentPipeline", PIPELINE), true);
    }

    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    public void upload() throws IOException{
        //上传文件的路径
        String FilePath = "C:\\Users\\Lifeix\\Desktop\\aa\\bb.flv";
        try {
            //调用put方法上传
            String str = getToken("a6");
            System.out.println(str);
            Response res = uploadManager.put(FilePath, null, str);
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
        new UploadDem6().upload();
    }

}


