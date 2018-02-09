package cn.zhuhongchao.mengbi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhuhongchao
 * @date 2018/2/9 9:08
 */
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Weather {


  private List<HeWeather6> HeWeather6;

  @NoArgsConstructor
  @Getter
  @AllArgsConstructor
  @Builder
  public static class HeWeather6 {
    /**
     * basic : {"cid":"CN101031300","location":"河西","parent_city":"河西","admin_area":"天津","cnty":"中国","lat":"39.10189819","lon":"117.21753693","tz":"+8.0"}
     * update : {"loc":"2018-02-09 08:52","utc":"2018-02-09 00:52"}
     * status : ok
     * daily_forecast : [{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-02-09","hum":"17","mr":"01:53","ms":"12:21","pcpn":"0.0","pop":"0","pres":"1022","sr":"07:09","ss":"17:40","tmp_max":"5","tmp_min":"-6","uv_index":"2","vis":"20","wind_deg":"313","wind_dir":"西北风","wind_sc":"4-5","wind_spd":"23"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2018-02-10","hum":"11","mr":"02:48","ms":"13:01","pcpn":"0.0","pop":"0","pres":"1030","sr":"07:08","ss":"17:42","tmp_max":"1","tmp_min":"-6","uv_index":"2","vis":"20","wind_deg":"342","wind_dir":"西北风","wind_sc":"4-5","wind_spd":"24"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2018-02-11","hum":"16","mr":"03:41","ms":"13:44","pcpn":"0.0","pop":"0","pres":"1026","sr":"07:07","ss":"17:43","tmp_max":"0","tmp_min":"-7","uv_index":"2","vis":"20","wind_deg":"327","wind_dir":"西北风","wind_sc":"5-6","wind_spd":"34"}]
     * sunrise_sunset : [{"$ref":"$[0].daily_forecast[0]"},{"$ref":"$[0].daily_forecast[1]"},{"$ref":"$[0].daily_forecast[2]"}]
     */
    private Basic basic;
    private Update update;
    private String status;
    private List<DailyForecast> daily_forecast;
    private List<SunriseSunset> sunrise_sunset;
    private List<Lifestyle> lifestyle;

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class Basic {
      /**
       * cid : CN101031300
       * location : 河西
       * parent_city : 河西
       * admin_area : 天津
       * cnty : 中国
       * lat : 39.10189819
       * lon : 117.21753693
       * tz : +8.0
       */
      private String cid;
      private String location;
      private String parent_city;
      private String admin_area;
      private String cnty;
      private String lat;
      private String lon;
      private String tz;
    }

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class Update {
      /**
       * loc : 2018-02-09 08:52
       * utc : 2018-02-09 00:52
       */
      private String loc;
      private String utc;
    }

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class DailyForecast {
      /**
       * cond_code_d : 101
       * cond_code_n : 101
       * cond_txt_d : 多云
       * cond_txt_n : 多云
       * date : 2018-02-09
       * hum : 17
       * mr : 01:53
       * ms : 12:21
       * pcpn : 0.0
       * pop : 0
       * pres : 1022
       * sr : 07:09
       * ss : 17:40
       * tmp_max : 5
       * tmp_min : -6
       * uv_index : 2
       * vis : 20
       * wind_deg : 313
       * wind_dir : 西北风
       * wind_sc : 4-5
       * wind_spd : 23
       */
      private String cond_code_d;
      private String cond_code_n;
      private String cond_txt_d;
      private String cond_txt_n;
      private String date;
      private String hum;
      private String mr;
      private String ms;
      private String pcpn;
      private String pop;
      private String pres;
      private String sr;
      private String ss;
      private String tmp_max;
      private String tmp_min;
      private String uv_index;
      private String vis;
      private String wind_deg;
      private String wind_dir;
      private String wind_sc;
      private String wind_spd;
    }

    @NoArgsConstructor
    @Getter
    @Builder
    public static class SunriseSunset {
      /**
       * $ref : $[0].daily_forecast[0]
       */
      private String $ref;
    }

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class Lifestyle {
      /**
       * brf : 较不舒适
       * txt : 白天天气较凉，且风力较强，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。
       * type : comf
       */
      private String brf;
      private String txt;
      private String type;
    }
  }
}
