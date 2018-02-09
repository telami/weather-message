package cn.zhuhongchao.mengbi;

import java.util.List;

/**
 * @author zhuhongchao
 * @date 2018/2/9 9:08
 */
public class Weather {


    private List<HeWeather6> HeWeather6;

    public List<HeWeather6> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

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

        public Basic getBasic() {
            return basic;
        }

        public void setBasic(Basic basic) {
            this.basic = basic;
        }

        public Update getUpdate() {
            return update;
        }

        public void setUpdate(Update update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<DailyForecast> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecast> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<SunriseSunset> getSunrise_sunset() {
            return sunrise_sunset;
        }

        public void setSunrise_sunset(List<SunriseSunset> sunrise_sunset) {
            this.sunrise_sunset = sunrise_sunset;
        }

        public List<Lifestyle> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<Lifestyle> lifestyle) {
            this.lifestyle = lifestyle;
        }

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

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class Update {
            /**
             * loc : 2018-02-09 08:52
             * utc : 2018-02-09 00:52
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

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

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class SunriseSunset {
            /**
             * $ref : $[0].daily_forecast[0]
             */

            private String $ref;

            public String get$ref() {
                return $ref;
            }

            public void set$ref(String $ref) {
                this.$ref = $ref;
            }
        }
        public static class Lifestyle {
            /**
             * brf : 较不舒适
             * txt : 白天天气较凉，且风力较强，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。
             * type : comf
             */

            private String brf;
            private String txt;
            private String type;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
