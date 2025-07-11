package io.projects.spotify_to_kafka_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "spotify-to-kafka-service")
public class SpotifyToKafkaConfigData {
    private List<String> spotifyKeywords;
}
