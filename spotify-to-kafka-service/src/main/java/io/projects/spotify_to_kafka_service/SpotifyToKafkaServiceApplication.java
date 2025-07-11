package io.projects.spotify_to_kafka_service;

import io.projects.spotify_to_kafka_service.config.SpotifyToKafkaConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpotifyToKafkaServiceApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(SpotifyToKafkaServiceApplication.class);

	private SpotifyToKafkaConfigData spotifyToKafkaConfigData;

	public SpotifyToKafkaServiceApplication(SpotifyToKafkaConfigData spotifyToKafkaConfigData) {
		this.spotifyToKafkaConfigData = spotifyToKafkaConfigData;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Application starting ....");
		LOG.info(Arrays.toString(spotifyToKafkaConfigData.getSpotifyKeywords().toArray()));
	}
}
