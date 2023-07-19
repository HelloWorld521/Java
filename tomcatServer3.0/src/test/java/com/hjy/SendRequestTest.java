package com.hjy;


import com.hjy.utils.HttpUtil;
import org.junit.Test;

public class SendRequestTest {
    @Test
    public void sendPostRquest01(){
        //发送post请求
        String s1 = HttpUtil.sendPost("http://localhost:8888/login.html", "name=123&age=223");
        System.out.println(s1);
    }

    @Test
    public void sendGetRquest01(){
        //发送get请求
        String s = HttpUtil.sendGet("http://localhost:8888/login.html", null);
        System.out.println(s);
    }
}
