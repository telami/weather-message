package cn.zhuhongchao.telami;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelamiApplicationTests {

	@Test
	public void contextLoads() {
		String httpUrl = "https://free-api.heweather.com/s6/weather/lifestyle?location=CN101031300&key=813bd324d6e34eeb8a1c801e961561c1&t="+System.currentTimeMillis();
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
		System.out.println(result);
	}

}
