package com.lhx.test;

import java.io.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description
 */
public class HttpTest {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        //先建立一个客户端实例，将模拟一个浏览器
        HttpClient client = new HttpClient();

        //这个是URL地址，我经过分析51job网站登录后的跳转到的地址，并分析得它在JavaScript里提交的URL的参数，不同网站就自已分析了，这个就是登录后刷新简历的URL地址
        String url = "http://my.51job.com/my/Pop_RefreshResume.php?en=0&ReSumeID=88888888&Read=0&ID=88888888";

        //之后再建立一个Post方法请求，提交刷新简历的表单，因为提交的参数较多，所以用Post请求好了
        PostMethod method = new PostMethod(url);

        //下面的就是将要提交的表单的数据填入PostMethod对象里面，以name , value 对加入！
        method.addParameter("HPNation", "086");
        method.addParameter("HPCity","020");
        method.addParameter("HPNumber","88888888");
        method.addParameter("FPNation","086");
        method.addParameter("FPCity","020");
        method.addParameter("FPNumber","88888888");
        method.addParameter("FPExtension","000");
        method.addParameter("MPNation","086");
        method.addParameter("Mobile","13888888888");
        method.addParameter("EmailAdd","888@888.com");
        method.addParameter("ReSumeID","88888888");

        //这里是建立请求时服务器需要用到的Cookie。
        Cookie cookie = new Cookie(".51job.com","51job","ccry%3D.0%252FZKBaMTmj82%26%7C%26cconfirmkey%3DcpwWgp7FC9FZM%26%7C%26cresumeid%3D88888888%26%7C%26cresumeids88888888d888826%7C8408ilstatus%3D2%26%7C%26cnickname826cenglis8cautologin%3D","/",null,false);

        //将设置好的Cookie加入模拟的客户端里。当请求发生时，就会将Cookie写进请求头里了
        client.getState().addCookie(cookie);
        int i=0;
        //开始死循环
        while(true){
            try{
                //这里是要求客户端发送一个请求。直接将PostMethod请求出去。
                client.executeMethod(method);

                //下面是获取返回的结果
                InputStream in = method.getResponseBodyAsStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len = -1;
                while((len=in.read(buff))!=-1){
                    baos.write(buff, 0, len);
                }
                String result = new String(baos.toByteArray());

                //释放资源
                in.close();
                baos.close();

                //在51job里，刷新简历成功的话，会返回一些JavaScript代码，里面有个alert()输出“简历已刷新”的信息的，你分析结果，如果有这句话，则成功刷新了。之后就让线程睡眠1分钟后循环刷新！
                if(result.indexOf("简历已刷新")!=-1){
                    System.out.println("简历已刷新！ " + ++i);
                }else{
                    System.out.println("刷新失败！");
                }
                Thread.sleep(60000);
            }catch(Exception ex){
                System.out.println("******** Error! ********");
                try{
                    //出现错误时，再等待20秒后再重新进行刷新。
                    Thread.sleep(20000);
                }catch(Exception e){
                    System.out.println("******** Thread Error! ********");
                }
            }
        }
    }

}
