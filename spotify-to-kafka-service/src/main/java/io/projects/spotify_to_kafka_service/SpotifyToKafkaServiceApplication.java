package io.projects.spotify_to_kafka_service;

import io.projects.spotify_to_kafka_service.config.SpotifyToKafkaConfigData;
import io.projects.spotify_to_kafka_service.listener.MockSpotifyRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpotifyToKafkaServiceApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(SpotifyToKafkaServiceApplication.class);

	private final SpotifyToKafkaConfigData spotifyToKafkaConfigData;

	private final MockSpotifyRunner mockSpotifyRunner;

	public SpotifyToKafkaServiceApplication(SpotifyToKafkaConfigData spotifyToKafkaConfigData, MockSpotifyRunner mockSpotifyRunner) {
		this.spotifyToKafkaConfigData = spotifyToKafkaConfigData;
        this.mockSpotifyRunner = mockSpotifyRunner;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpotifyToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Application starting ....");
		LOG.info(Arrays.toString(spotifyToKafkaConfigData.getSpotifyKeywords().toArray()));
		LOG.info(mockSpotifyRunner.convertToJson());
	}
}
