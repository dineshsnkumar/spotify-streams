package io.projects.kafka_producer.config;

import io.projects.config_data.config.KafkaConfigData;
import io.projects.spotify.kafka.avro.model.SpotifyAvroModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    private final KafkaConfigData kafkaConfigData;

    public KafkaProducerConfig(KafkaConfigData kafkaConfigData) {
        this.kafkaConfigData = kafkaConfigData;
    }

    @Bean
    public ProducerFactory<Long, SpotifyAvroModel> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    private Map<String, Object> producerConfig() {
        Map<Long, Object> props = new HashMap<>();
    }

    @Bean
    public KafkaTemplate<Long, SpotifyAvroModel> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
