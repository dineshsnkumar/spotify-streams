package io.projects.spotify_to_kafka_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyToKafkaServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Initialization working");
	}
}
