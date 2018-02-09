package cn.zhuhongchao.message;

import cn.zhuhongchao.love.Care;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhuhongchao
 * @date 2018/2/8 16:34
 */
@Component
public class ShotMessage {

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    @Value("${sms.accessKeyId}")
    private String accessKeyId;

    @Value("${sms.accessKeySecret}")
    private String accessKeySecret;

    @Value("${sms.templateCode}")
    private String templateCode;

    @Value("${sms.phone}")
    private String phone;

    private static final Logger logger = LoggerFactory.getLogger(ShotMessage.class);

   public void sendMessage(String name,String date,String weather,String wind,String rain) throws ClientException {
       //可自助调整超时时间
       System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
       System.setProperty("sun.net.client.defaultReadTimeout", "10000");

       //初始化acsClient,暂不支持region化
       IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
       DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
       IAcsClient acsClient = new DefaultAcsClient(profile);

       //组装请求对象-具体描述见控制台-文档部分内容
       SendSmsRequest request = new SendSmsRequest();
       //必填:待发送手机号
       request.setPhoneNumbers(phone);
       //必填:短信签名-可在短信控制台中找到
       request.setSignName("猪大肠");
       //必填:短信模板-可在短信控制台中找到
       request.setTemplateCode(templateCode);
       //我的${name}，早上好呀，今天是${date}，天气情况是：${weather}，刮${wind}， 降水概率：${rain}，汇报完毕，哈哈，心情美美哒昂~
       request.setTemplateParam("{\"name\": \""+name+"\",\"date\": \""+date+"\",\"weather\": \""+weather+"\",\"wind\": \""+wind+"\",\"rain\": \""+rain+"\"}");
       SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
       if (sendSmsResponse.getCode() != null && !sendSmsResponse.getCode().equals("OK")) {
           logger.error("发送短信失败，错误码=" + sendSmsResponse.getCode() + ";错误信息=" + sendSmsResponse.getMessage());
       }
   }
}
