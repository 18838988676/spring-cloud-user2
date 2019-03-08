package cn.com.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class SpringCloudUser2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUser2Application.class, args);
	}

}
