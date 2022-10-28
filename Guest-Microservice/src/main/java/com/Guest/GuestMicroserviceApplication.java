package com.Guest;

import com.Guest.Models.Guest;
//import com.Guest.Models.Product;
import com.Guest.config.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class GuestMicroserviceApplication implements CommandLineRunner {
//	@Autowired
//	private Guest guest;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {

		SpringApplication.run(GuestMicroserviceApplication.class, args);
	}
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	public void run(String... args) throws Exception
	{
		Guest room = new Guest();
		room.setGuestId(100);
		room.setGuestName("Laptop");
		room.setGuestContact(Long.parseLong("12345678"));
		room.setGuestEmail("asdf@gmail.com");
		room.setGuestGender("Male");
		room.setGuestAddress("Mumbai");
//		product.setQuantity(10);

		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
				"message_routing_key", room);
		System.out.println("Message sent successfully...");
	}
}
