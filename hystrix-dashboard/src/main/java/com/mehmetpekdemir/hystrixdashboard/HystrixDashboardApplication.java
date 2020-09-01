package com.mehmetpekdemir.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);

	}

}
