package com.lhx.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by lhx on 2016/9/28 10:55
 *
 * @Description
 */
public class HttpTest4 {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        //先建立一个客户端实例，将模拟一个浏览器
        HttpClient client = new HttpClient();

        //这个是URL地址
//        String url = "http://a1.easemob.com/easemob-demo/chatdemoui/chatrooms";
        String url = "http://a1.easemob.com/easemob-demo/chatdemoui/users/888xin/status";
        //添加群组成员[单个]
//        String url = "http://a1.easemob.com/easemob-demo/chatdemoui/chatgroups/{group_id}/users/{username}";

        //之后再建立一个Post方法请求
        GetMethod method = new GetMethod(url);

        //下面的就是将要提交的表单的数据填入PostMethod对象里面，以name , value 对加入！
        method.setRequestHeader("Authorization","Bearer YWMtccbgCIVOEeaXEk_gqkMNAQAAAVikt-LigME2q8yO8iOuT5diPoyAeOl6HwE");

        //这里是建立请求时服务器需要用到的Cookie。
        //Cookie cookie = new Cookie(".51job.com","51job","ccry%3D.0%252FZKBaMTmj82%26%7C%26cconfirmkey%3DcpwWgp7FC9FZM%26%7C%26cresumeid%3D88888888%26%7C%26cresumeids88888888d888826%7C8408ilstatus%3D2%26%7C%26cnickname826cenglis8cautologin%3D","/",null,false);

        //将设置好的Cookie加入模拟的客户端里。当请求发生时，就会将Cookie写进请求头里了
        //client.getState().addCookie(cookie);
        client.getState();
        int i=0;
        //开始死循环
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
                System.out.println(result);

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
