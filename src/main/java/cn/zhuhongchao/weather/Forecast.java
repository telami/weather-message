package cn.zhuhongchao.weather;

import cn.zhuhongchao.mengbi.Weather;
import cn.zhuhongchao.util.SignUtil;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.HashMap;

/**
 * @author zhuhongchao
 * @date 2018/2/8 11:15
 */
@Component
public class Forecast {

    @Value("${hefeng.location}")
    private String location;

    @Value("${hefeng.username}")
    private String username;

    @Value("${hefeng.secret}")
    private String secret;

    private static final Logger logger = LoggerFactory.getLogger(Forecast.class);

    /**
     * 生活指数
     * @return
     */
    public Weather lifestyle() {
        String httpUrl = "https://free-api.heweather.com/s6/weather/lifestyle?location="+location+"&username="+username+"&t="+System.currentTimeMillis()+"&sign="+getSign();
        logger.info("url{}",httpUrl);
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        try {
            URL url = new URL(httpUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead); sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader !=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return JSON.parseObject(result,Weather.class);
    }

    /**
     * 3-10天天气预报
     * @return
     */
    public Weather forecast() {
        String httpUrl = "https://free-api.heweather.com/s6/weather/forecast?location="+location+"&username="+username+"&t="+System.currentTimeMillis()+"&sign="+getSign();
        logger.info("url{}",httpUrl);
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        try {
            URL url = new URL(httpUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead); sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader !=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Gson gson = new Gson();
        return gson.fromJson(result,Weather.class);
    }
    public String getSign(){
        HashMap<String, String> param = new HashMap<>();
        param.put("location", location);
        param.put("username", username);
        param.put("t", String.valueOf(System.currentTimeMillis()));
        return SignUtil.getSignature(param, secret);
    }
}
