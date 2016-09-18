package com.lhx.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lhx on 2016/8/3 14:20
 *
 * @Description
 * 参考 http://my.oschina.net/BreathL/blog/42477
 */
public class CosineSimilarAlgorithm {
    public static double getSimilarity(String doc1, String doc2) {
        if (doc1 != null && doc1.trim().length() > 0 && doc2 != null
                && doc2.trim().length() > 0) {

            Map<Integer, int[]> AlgorithmMap = new HashMap<Integer, int[]>();

            //将两个字符串中的中文字符以及出现的总数封装到，AlgorithmMap中
            for (int i = 0; i < doc1.length(); i++) {
                char d1 = doc1.charAt(i);
                if(isHanZi(d1)){
                    int charIndex = getGB2312Id(d1);
                    if(charIndex != -1){
                        int[] fq = AlgorithmMap.get(charIndex);
                        if(fq != null && fq.length == 2){
                            fq[0]++;
                        }else {
                            fq = new int[2];
                            fq[0] = 1;
                            fq[1] = 0;
                            AlgorithmMap.put(charIndex, fq);
                        }
                    }
                }
            }

            for (int i = 0; i < doc2.length(); i++) {
                char d2 = doc2.charAt(i);
                if(isHanZi(d2)){
                    int charIndex = getGB2312Id(d2);
                    if(charIndex != -1){
                        int[] fq = AlgorithmMap.get(charIndex);
                        if(fq != null && fq.length == 2){
                            fq[1]++;
                        }else {
                            fq = new int[2];
                            fq[0] = 0;
                            fq[1] = 1;
                            AlgorithmMap.put(charIndex, fq);
                        }
                    }
                }
            }

            Iterator<Integer> iterator = AlgorithmMap.keySet().iterator();
            double sqdoc1 = 0;
            double sqdoc2 = 0;
            double denominator = 0;
            while(iterator.hasNext()){
                int[] c = AlgorithmMap.get(iterator.next());
                denominator += c[0]*c[1];
                sqdoc1 += c[0]*c[0];
                sqdoc2 += c[1]*c[1];
            }

            return denominator / Math.sqrt(sqdoc1*sqdoc2);
        } else {
            throw new NullPointerException("the Document is null or have not cahrs!!");
        }
    }

    public static boolean isHanZi(char ch) {
        // 判断是否汉字
        return (ch >= 0x4E00 && ch <= 0x9FA5);

    }

    /**
     * 根据输入的Unicode字符，获取它的GB2312编码或者ascii编码，
     *
     * @param ch
     *            输入的GB2312中文字符或者ASCII字符(128个)
     * @return ch在GB2312中的位置，-1表示该字符不认识
     */
    public static short getGB2312Id(char ch) {
        try {
            byte[] buffer = Character.toString(ch).getBytes("GB2312");
            if (buffer.length != 2) {
                // 正常情况下buffer应该是两个字节，否则说明ch不属于GB2312编码，故返回'?'，此时说明不认识该字符
                return -1;
            }
            int b0 = (buffer[0] & 0x0FF) - 161; // 编码从A1开始，因此减去0xA1=161
            int b1 = (buffer[1] & 0x0FF) - 161; // 第一个字符和最后一个字符没有汉字，因此每个区只收16*6-2=94个汉字
            return (short) (b0 * 94 + b1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
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
}
