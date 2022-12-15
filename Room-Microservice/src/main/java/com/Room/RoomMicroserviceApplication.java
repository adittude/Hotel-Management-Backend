package com.Room;

import com.Room.Models.Room;
import com.Room.Repository.RoomMongodbRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class RoomMicroserviceApplication implements CommandLineRunner {
	private final RoomMongodbRepos roomMongodbRepos;
	@Autowired
	public RoomMicroserviceApplication(RoomMongodbRepos roomMongodbRepos){
		this.roomMongodbRepos = roomMongodbRepos;
	}
	public static void main(String[] args) {
		SpringApplication.run(RoomMicroserviceApplication.class, args);
	}

//	@Bean
//	public RestTemplate template() {
//		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		httpRequestFactory.setConnectionRequestTimeout(4000);
//		httpRequestFactory.setConnectTimeout(4000);
//		httpRequestFactory.setReadTimeout(4000);
//		return new RestTemplate(httpRequestFactory);
//	}

	@Override
	public void run(String... args) throws Exception {
		if (roomMongodbRepos.findAll().isEmpty()){
			roomMongodbRepos.save(new Room(100L, 500, "3BHK", "Big and Spacious", true));
		}
		for(Room room: roomMongodbRepos.findAll()){
			System.out.println(room);
		}
	}
}
