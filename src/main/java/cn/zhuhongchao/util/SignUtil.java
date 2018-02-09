package cn.zhuhongchao.util;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author zhuhongchao
 * @date 2018/2/8 11:26
 */
public class SignUtil {
  /**
   * 和风天气签名生成算法
   *
   * @param params 请求参数集，所有参数必须已转换为字符串类型
   * @return 签名
   * @throws IOException
   */
  public static String getSignature(HashMap<String, String> params, String secret) {
    // 先将参数以其参数名的字典序升序进行排序
    Map<String, String> sortedParams = new TreeMap<>(params);
    Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
    // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
    StringBuilder baseString = new StringBuilder();
    for (Map.Entry<String, String> param : entrys) {
      //sign参数 和 空值参数 不加入算法
      if (param.getValue() != null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim()) && !"key".equals(param.getKey().trim()) && !"".equals(param.getValue().trim())) {
        baseString.append(param.getKey().trim()).append("=").append(param.getValue().trim()).append("&");
      }
    }
    if (baseString.length() > 0) {
      baseString.deleteCharAt(baseString.length() - 1).append(secret);
    }

    // 使用MD5对待签名串求签
    byte[] bytes = new byte[0];
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      bytes = md5.digest(baseString.toString().getBytes("UTF-8"));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return new BASE64Encoder().encode(bytes);
  }

}
