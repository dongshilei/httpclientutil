package com.arronlong.httpclientutil.test;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.http.Header;

/**
 * Created by DONGSHILEI on 2017/8/29
 */
public class MyTest {

    public static void main(String[] args) throws HttpProcessException {
        //获取响应页面
        //String s = HttpClientUtil.get(HttpConfig.custom().url("https://www.baidu.com"));
        //System.out.println(s);
        //上传图片到图片服务器
        Header[] headers = HttpHeader.custom().other("Content-type", "jpg").build();
        String upload = HttpClientUtil.upload(HttpConfig.custom().headers(headers)
                .url("http://114.113.121.231:4869/upload").files(new String[]{"D:\\1.png","D:\\2.jpg","D:\\3.jpg"}));
        System.out.println(upload);
    }
}
