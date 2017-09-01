package com.arronlong.httpclientutil.test;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.joda.time.DateTime;

/**
 * Created by DONGSHILEI on 2017/9/1
 */
public class TaskTest {
    private static final String FORMATE_DATE = "yyyy-MM-dd";

    public static void main(String[] args) throws HttpProcessException, InterruptedException {
        String saUrl = "http://172.16.5.2:11000/task/sa?date=%s";
        String taUrl = "http://172.16.5.2:11000/task/ta?date=%s";
        for (int i = 81;i>62;i--) {
            String date = DateTime.now().minusDays(i).toString(FORMATE_DATE);
            System.out.println(i+"天前的日期:" + date);
            String surl = String.format(saUrl,date);
            System.out.println(surl);
            String s = HttpClientUtil.get(HttpConfig.custom().url(surl));
            System.out.println(s);
            Thread.sleep(40*1000);
            String turl = String.format(taUrl,date);
            System.out.println(turl);
            String s2 = HttpClientUtil.get(HttpConfig.custom().url(turl));
            System.out.println(s2);
            Thread.sleep(40*1000);
        }

    }
}
