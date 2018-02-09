package cn.zhuhongchao.love;

import cn.zhuhongchao.mengbi.Weather;
import cn.zhuhongchao.message.ShotMessage;
import cn.zhuhongchao.weather.Forecast;
import com.aliyuncs.exceptions.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author zhuhongchao
 * @date 2018/2/8 17:11
 */
@Component
public class Care {

    @Autowired
    private ShotMessage shotMessage;

    @Autowired
    private Forecast forecast;

    private List<String> nicknames;

    private static final Logger logger = LoggerFactory.getLogger(Care.class);

    /**
     *
     */
    @Scheduled(cron = "0 45 6 ? * *")
    public void care(){
        nicknames =  Arrays.asList("小可爱","小笨蛋","小宝贝儿","二丫","小媳妇儿","大屁蛋子","小二货");
        Weather.HeWeather6 heWeather6 = forecast.forecast().getHeWeather6().get(0);
        if ("ok".equals(heWeather6.getStatus())){
            Weather.HeWeather6.DailyForecast dailyForecast = heWeather6.getDaily_forecast().get(0);
            //预报日期
            String date = dailyForecast.getDate();
            //最低温度
            String tmp_min = dailyForecast.getTmp_min();
            //最高温度
            String tmp_max = dailyForecast.getTmp_max();
            //白天天气状况描述
            String cond_txt_d = dailyForecast.getCond_txt_d();
            //风向
            String wind_dir = dailyForecast.getWind_dir();
            //风力
            String wind_sc = dailyForecast.getWind_sc();
            //风速，公里/小时
            String wind_spd = dailyForecast.getWind_spd();
            //降水量
            String pop = dailyForecast.getPop();
            //降水概率
            String pcpn = dailyForecast.getPcpn();
            String weather = cond_txt_d + ","+"气温：" + tmp_min + "~" + tmp_max + "℃";
            String wind = wind_dir+"，"+"风力："+wind_sc+"级";
            String rain = pcpn+"%，"+"降水量："+pop+"mm";
            //我的${name}，早上好呀，今天是${date}，天气情况是：${weather}，刮${wind}， 降水概率：${rain}，汇报完毕，哈哈，心情美美哒昂~
            int index = new Random().ints(0, 7).findAny().getAsInt();
            try {
                shotMessage.sendMessage(nicknames.get(index),date,weather,wind,rain);
                logger.info("发送短信:我的{}，早上好呀，今天是{}，天气情况是：{}，刮{}， 降水概率：{}，汇报完毕，哈哈，心情美美哒昂~",nicknames.get(index),date,weather,wind,rain);
            } catch (ClientException e) {
                logger.error("发送短信失败:{}",e);
            }
        }else {
            care();
        }
    }
}
