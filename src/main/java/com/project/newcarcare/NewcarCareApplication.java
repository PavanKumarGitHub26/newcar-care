package com.project.newcarcare;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.project.newcarcare.Service.EmailService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NewcarCareApplication {
	
	@Autowired
	EmailService service;

	public static void main(String[] args) {
		SpringApplication.run(NewcarCareApplication.class, args);
	}
	
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("car-care service", "www.testyantra.com", "info@gmail.com");

		List<VendorExtension> extensions = new ArrayList<VendorExtension>();

		ApiInfo apiInfo = new ApiInfo("CarCare API services", "service to manage car service", "snapshot 1.0",
				"www.testyantraglobal.com", contact, "licence 123", "www.testyantra.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project.newcarcare"))
				.build()
				.apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
	String email="nadageripramod03@gmail.com";
	String msg="hi";
	public void getMail(String Vemail,String message) {
		email=Vemail;
		msg=message;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendSimpleEmail(email, msg,"welcome to car services!!!!!!!");
	}
}
