package cn.zhuhongchao.telami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages={"cn.zhuhongchao"})
public class TelamiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelamiApplication.class, args);
	}
}
