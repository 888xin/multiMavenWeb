package com.lhx.test;

import com.lhx.model.BunchOptionsResponse;
import com.lhx.model.BunchPrize;
import com.lhx.model.User;
import com.lhx.util.CosineSimilarAlgorithm;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by lhx on 16-5-17 上午9:43
 *
 * @Description
 */
public class JsonTest {

    private static final Logger LOG = LoggerFactory.getLogger(JsonTest.class);

    @org.junit.Test
    public void test1() throws IOException {
        User user = new User();
        user.setId(1);
        user.setNickname("a");
        user.setState(12);

        User user1 = new User();
        user1.setId(2);
        user1.setNickname("b");
        user1.setState(13);

        User user2 = new User();
        user2.setId(2);
        user2.setNickname("c");
        user2.setState(14);


        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = mapper.writeValueAsString(list);
        System.out.println(jsonfromList);

        System.out.println("************************************");

        //List stuList2 = mapper.readValue(jsonfromList, List.class);
//        List userList2 = mapper.readValue(jsonfromList, List.class);
//        for (Object o : userList2) {
//
//            System.out.println(o.toString());
//        }
//        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, User.class);
//        List<User> lst =  mapper.readValue(jsonfromList, javaType);
//        for (User user3 : lst) {
//            System.out.println(user3.getNickname());
//        }

        List<User> beanList = mapper.readValue(jsonfromList, new TypeReference<List<User>>(){});
        for (User user3 : beanList) {
            System.out.println(user3.getNickname());
        }

    }

    @org.junit.Test
    public void test2() throws IOException, JSONException {
        User user = new User();
        user.setId(1);
        user.setNickname("a");
        user.setState(12);

        User user1 = new User();
        user1.setId(2);
        user1.setNickname("b");
        user1.setState(13);

        User user2 = new User();
        user2.setId(2);
        user2.setNickname("c");
        user2.setState(14);


        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        JSONArray array = new JSONArray();
        array.put(list);
        System.out.println(array.toString());

        System.out.println("************************************");

        Object object = array.get(0);
        System.out.println(object);
        List<User> list2 = (List<User>) object;

    }


    @org.junit.Test
    public void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = "[{\"id\":1,\"state\":12,\"nickname\":\"a\"},{\"id\":2,\"state\":13,\"nickname\":\"b\"},{\"id\":2,\"state\":14,\"nickname\":\"c\"}]";
        List<User> beanList = mapper.readValue(jsonfromList, new TypeReference<List<User>>(){});
        for (User user : beanList) {
            System.out.println(user.getNickname());
        }
    }

    @org.junit.Test
    public void test4() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = "[{\"state\":12},{\"id\":2,\"state\":13,\"nickname\":\"b\"},{\"id\":2,\"state\":14,\"nickname\":\"c\"}]";
        List<User> beanList = mapper.readValue(jsonfromList, new TypeReference<List<User>>() {
        });
        for (User user : beanList) {
            System.out.println(user.getNickname());
        }
        String str = mapper.writeValueAsString(beanList);
        //String str = JSONUtils.toJSONString(beanList);
        System.out.println(str);
    }


    @org.junit.Test
    public void test5() throws IOException {
        BunchOptionsResponse bunchOptionsResponse = new BunchOptionsResponse();
        bunchOptionsResponse.setContest_id(152016L);
        bunchOptionsResponse.setContest_type(0);
        bunchOptionsResponse.setPlay_type(1);
        bunchOptionsResponse.setIndex(0);

        BunchOptionsResponse bunchOptionsResponse2 = new BunchOptionsResponse();
        bunchOptionsResponse2.setContest_id(152016L);
        bunchOptionsResponse2.setContest_type(0);
        bunchOptionsResponse2.setPlay_type(2);
        bunchOptionsResponse2.setIndex(1);

        BunchOptionsResponse bunchOptionsResponse3 = new BunchOptionsResponse();
        bunchOptionsResponse3.setContest_id(17144L);
        bunchOptionsResponse3.setContest_type(1);
        bunchOptionsResponse3.setPlay_type(6);
        bunchOptionsResponse3.setIndex(2);

        BunchOptionsResponse bunchOptionsResponse4 = new BunchOptionsResponse();
        bunchOptionsResponse4.setContest_id(17144L);
        bunchOptionsResponse4.setContest_type(1);
        bunchOptionsResponse4.setPlay_type(7);
        bunchOptionsResponse4.setIndex(3);

        BunchOptionsResponse bunchOptionsResponse5 = new BunchOptionsResponse();
        bunchOptionsResponse5.setContest_id(17144L);
        bunchOptionsResponse5.setContest_type(1);
        bunchOptionsResponse5.setPlay_type(9);
        bunchOptionsResponse5.setIndex(4);

        List<BunchOptionsResponse> list = new ArrayList<BunchOptionsResponse>();
        list.add(bunchOptionsResponse);
        list.add(bunchOptionsResponse2);
        list.add(bunchOptionsResponse3);
        list.add(bunchOptionsResponse4);
        list.add(bunchOptionsResponse5);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        String jsonfromList = mapper.writeValueAsString(list);
        System.out.println(jsonfromList);

    }

    @org.junit.Test
    public void test6() throws IOException {
        BunchOptionsResponse bunchOptionsResponse = new BunchOptionsResponse();
        bunchOptionsResponse.setIndex(1);
        bunchOptionsResponse.setSupport(0);

        BunchOptionsResponse bunchOptionsResponse2 = new BunchOptionsResponse();
        bunchOptionsResponse2.setIndex(3);
        bunchOptionsResponse2.setSupport(1);

        BunchOptionsResponse bunchOptionsResponse3 = new BunchOptionsResponse();
        bunchOptionsResponse3.setIndex(5);
        bunchOptionsResponse3.setSupport(2);

        List<BunchOptionsResponse> list = new ArrayList<BunchOptionsResponse>();
        list.add(bunchOptionsResponse);
        list.add(bunchOptionsResponse2);
        list.add(bunchOptionsResponse3);
//        JSONObject jsonObject = new JSONObject(list);
//        System.out.println(jsonObject.toString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        String jsonfromList = mapper.writeValueAsString(list);
        System.out.println(jsonfromList);

    }

    @org.junit.Test
    public void test7() throws IOException {
        String[] strs = {"23","234","453534","342"};
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = mapper.writeValueAsString(strs);
        System.out.println(jsonfromList);


    }

    @org.junit.Test
    public void test8() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = "[\"23\",\"234\",\"453534\",\"342\"]";
        String[] strs = mapper.readValue(jsonfromList, new TypeReference<String[]>() {
        });
        for (String str : strs) {
            System.out.println(str);
        }
    }

    @org.junit.Test
    public void test9() throws IOException {
        Integer[] strs = new Integer[3];
        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = mapper.writeValueAsString(strs);
        System.out.println(jsonfromList);

    }

    @org.junit.Test
    public void test10() throws IOException {
        Map<String,String> map = new HashMap<String, String>();
        for (String s : map.keySet()) {
            System.out.println(s);
        }
        System.out.println("sss");



    }


    @org.junit.Test
    public void test11() throws IOException {
        BunchPrize bunchPrize = new BunchPrize();
        bunchPrize.setName("5龙筹");
        bunchPrize.setNum(30);
        bunchPrize.setWinNum(2);
        bunchPrize.setType(0);
        bunchPrize.setPrice(5);

        BunchPrize bunchPrize2 = new BunchPrize();
        bunchPrize2.setName("10龙币");
        bunchPrize2.setNum(10);
        bunchPrize2.setWinNum(4);
        bunchPrize2.setType(1);
        bunchPrize2.setPrice(10);

        BunchPrize bunchPrize3 = new BunchPrize();
        bunchPrize3.setName("娃娃");
        bunchPrize3.setNum(1);
        bunchPrize3.setWinNum(5);
        bunchPrize3.setType(2);
        bunchPrize3.setPrice(0);

        List<BunchPrize> list = new ArrayList<BunchPrize>();
        list.add(bunchPrize);
        list.add(bunchPrize2);
        list.add(bunchPrize3);
//        JSONObject jsonObject = new JSONObject(list);
//        System.out.println(jsonObject.toString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        String jsonfromList = mapper.writeValueAsString(list);
        System.out.println(jsonfromList);

    }

    @org.junit.Test
    public void test12() throws IOException {
        System.out.println(new Date().getTime());

    }

    @org.junit.Test
    public void test13() throws IOException {
        String s = "sdfsdfsgfd";
        byte[] bytes = s.getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new String(bytes));
        System.out.println(stringBuilder.toString());

    }

    @org.junit.Test
    public void test14() throws IOException {
        double back = 5 ;
        Map<Long, Integer> ret = new HashMap<Long, Integer>();
        int[] price = new int[]{5, 10, 20, 50, 100};
        for (int i = 1; i < price.length; i++) {
            if (back > price[i-1] && back <= price[i]){
                System.out.println(price[i]);
            }
        }
        System.out.println(5);

    }

    @org.junit.Test
    public void test15() throws IOException {
        Calendar calendar = Calendar.getInstance();
        int minute = calendar.get(Calendar.MINUTE);
        int status = minute % 4 ;
        System.out.println(minute);
        System.out.println(status);

    }

    @org.junit.Test
    public void test16() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setId(23);
        user.setNickname("nick");
        user.setState(3);
        String str = mapper.writeValueAsString(user);
        System.out.println(str);

    }

    @org.junit.Test
    public void test17() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue("{\"id\":23,\"state\":3,\"nickname\":\"nick\"}", User.class);
        System.out.println(user.getNickname());

    }


    @org.junit.Test
    public void test18() throws IOException, ExecutionException, InterruptedException {

        //        ExecutorService exec = Executors.newCachedThreadPool();
        ThreadPoolExecutor execute = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        List<Long> longs = Arrays.asList(5560914L,5530161L,5505166L,5523232L);
        for (Long aLong : longs) {
            results.add(execute.submit(new ThreadCall(aLong)));
        }
        for (Future<String> fs : results) {
            while (fs.isDone()) {
                System.out.println(fs.get());
            }
//            else {
//                System.out.println("Future result is not yet complete");
//            }
        }
        while (execute.getCompletedTaskCount() == 4){
            execute.shutdown();
        }


    }



    private class ThreadCall implements Callable<String> {

        private Long id ;

        public ThreadCall(Long id){
            this.id = id ;
        }

        @Override
        public String call() throws Exception {

            //List<User> users = accountPhotoDao.findPhotosByAccountId(id, 3);
            List<User> users = new ArrayList<User>();
            JSONArray jsonArray = new JSONArray();
            if (users.size() > 0){
                for (int i = 0; i < users.size(); i++) {
                    JSONObject jsonObject = new JSONObject();
                    User user = users.get(i);
                    jsonObject.put("id", user.getId());
                    jsonObject.put("nickname", user.getNickname());
                    jsonArray.put(jsonObject);
                }
                return jsonArray.toString();
            } else {
                return "";
            }

        }
    }


    @org.junit.Test
    public void test19() throws IOException, ExecutionException, InterruptedException {

        ThreadPoolExecutor execute = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        ArrayList<Future<Long>> results = new ArrayList<Future<Long>>();
        List<Long> longs = Arrays.asList(1L,2L,3L,4L);
        for (Long aLong : longs) {
            results.add(execute.submit(new ThreadCall2(aLong)));
        }
        for (Future<Long> fs : results) {
            while (fs.isDone()) {
                System.out.println(fs.get());
            }
        }
        while (execute.getCompletedTaskCount() == 4){
            execute.shutdown();
        }


    }

    private class ThreadCall2 implements Callable<Long> {

        private Long id ;

        public ThreadCall2(Long id){
            this.id = id ;
        }

        @Override
        public Long call() throws Exception {

            return id + 10 ;

        }
    }

    @org.junit.Test
    public void test20() {

        String s = toString();
        List<String> list = Arrays.asList("zxcf","Zxc");


    }

    @org.junit.Test
    public void test21() {

        BigDecimal bigDecimal = new BigDecimal(3.333333);
        System.out.println(bigDecimal);

        DecimalFormat df = new DecimalFormat("0.00"); // 保留几位小数


        String str = df.format(bigDecimal);

        BigDecimal bigDecimal1 = new BigDecimal(100).subtract(bigDecimal);
        System.out.println(bigDecimal1.toString());
        System.out.println(str);
    }

    @org.junit.Test
    public void test22() {

        double a = 4 ;
        double b = 7 ;
        System.out.println(a / (a+b));
    }

    @org.junit.Test
    public void test23() {

        List<String> list = Arrays.asList("234",null,"werwerw","werwerqqq",null);
        for (String s : list) {
            System.out.println(s);
        }
    }

    @org.junit.Test
    public void test24() {

        List<Long> list = Arrays.asList(234L,23L,2323L,1L,2L);
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2){
                    return -1;
                }
                return 1;
            }
        });
        for (Long aLong : list) {
            System.out.println(aLong);
        }
    }

    @org.junit.Test
    public void test25() {
        double d1 = CosineSimilarAlgorithm.getSimilarity("中华人民共和国","中华人民共和国");
        double d2 = CosineSimilarAlgorithm.getSimilarity("中华人民共和国","人中共和国民华");
        double d3 = CosineSimilarAlgorithm.getSimilarity("中华人民共和国","共和国人民万岁");
        double d4 = CosineSimilarAlgorithm.getSimilarity("中华人民共和国","美利坚合众国");
        double d5 = CosineSimilarAlgorithm.getSimilarity("中华人民共和国","美国和中国的对决");
        double d6 = CosineSimilarAlgorithm.getSimilarity("中华人民共和国","今天天气还是不错的");
        double d7 = CosineSimilarAlgorithm.getSimilarity("完全不同的两个文本","今天天气还是不错的");
        double d8 = CosineSimilarAlgorithm.getSimilarity("天气不是很好啦","今天天气还是不错的");
        double d9 = CosineSimilarAlgorithm.getSimilarity("英文good day for me","好hello world you see");

        System.out.println("d1:"+d1);
        System.out.println("d2:"+d2);
        System.out.println("d3:"+d3);
        System.out.println("d4:"+d4);
        System.out.println("d5:"+d5);
        System.out.println("d6:"+d6);
        System.out.println("d7:"+d7);
        System.out.println("d8:"+d8);
        System.out.println("d9:"+d9);
    }


    @org.junit.Test
    public void test26() {
        //List<String> list = Arrays.asList("sdf","ewrwer","fghgfh","cvbcvb");
        List<String> list = new ArrayList<String>();
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.remove("sdf");
        for (String o : list) {
            System.out.println(o);
        }

    }

    @org.junit.Test
    public void test27() {

        List<String> list = new LinkedList<String>();
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.add("sdfsdf");
        list.remove(0);
        for (String o : list) {
            System.out.println(o);
        }

    }


    @org.junit.Test
    public void test28() throws IOException {

//        InputStream in = new FileInputStream("C:\\Users\\Lifeix\\Documents\\IdeaProjects\\multiMavenWeb\\lhx.dao\\src\\main\\resources\\conf\\jdbc.properties");

        //以’/'开头则是从ClassPath根下获取
        //InputStream in = getClass().getResourceAsStream("/conf/jdbc.properties");
        //不以’/'开头时默认是从此类所在的包下取资源，从当前包下获取
        //InputStream in = getClass().getResourceAsStream("jdbc.properties");
        //默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源
        InputStream in = getClass().getClassLoader().getResourceAsStream("conf/jdbc.properties");
        Properties p=new Properties();
        p.load(in);
        in.close();
        String str = p.getProperty("jdbc_password");
        System.out.println(str);

    }

    @org.junit.Test
    public void test29() throws IOException {

        String path = "127.0.0.1";
        LOG.info("{}该服务器调用dubbo登陆", path);
        String pathStr = String.format("服务器[%s]调用dubbo登陆", path);
        System.out.println(pathStr);

    }

    @org.junit.Test
    public void test30() throws IOException {

        String str = "{\"id\":\"z1.lifeix-live.00004\",\"createdAt\":\"2016-08-26T17:58:16.741+08:00\",\"updatedAt\":\"2016-08-26T17:58:16.741+08:00\",\"title\":\"00004\",\"hub\":\"lifeix-live\",\"disabledTill\":0,\"disabled\":false,\"publishKey\":\"8ce9268323a3947e\",\"publishSecurity\":\"static\",\"hosts\":{\"publish\":{\"rtmp\":\"pili-publish.live.l99.com\"},\"live\":{\"hdl\":\"pili-live-hdl.live.l99.com\",\"hls\":\"pili-live-hls.live.l99.com\",\"http\":\"pili-live-hls.live.l99.com\",\"rtmp\":\"pili-live-rtmp.live.l99.com\",\"snapshot\":\"pili-live-snapshot.live.l99.com\"},\"playback\":{\"hls\":\"10003g3.playback1.z1.pili.qiniucdn.com\",\"http\":\"10003g3.playback1.z1.pili.qiniucdn.com\"},\"play\":{\"http\":\"pili-live-hls.live.l99.com\",\"rtmp\":\"pili-live-rtmp.live.l99.com\"}}}";
        System.out.println(str.replaceAll("\\\\",""));

    }
}
