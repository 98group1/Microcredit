package com.aaa.microcredit.util;

import com.aaa.microcredit.util.PhoneUtils;
import com.aaa.microcredit.util.RandomStringUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName:PhoneCodeUtil
 * description:
 * author:雷建林
 * ceeateTime:2019/8/2 21:48
 */

public class PhoneCodeUtil {

    public static String phoneCode(String tel ){
        String host = "http://toushitz.market.alicloudapi.com";
        String path = "/ts/notifySms";
        String method = "POST";
        String appcode = "7fa0222a7a144e8a92fd5277660403ab";
        Map<String, String> headers = new HashMap<String, String>();
        //获取6位随机数字当作验证码
        String randomNumber = RandomStringUtil.getRandomNumber(6);
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", tel);
        querys.put("param", "more:"+"【验证码】"+randomNumber);
        querys.put("tpl_id", "TP18040317");
        Map<String, String> bodys = new HashMap<String, String>();

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = PhoneUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(randomNumber);
        return randomNumber;
    }
}
