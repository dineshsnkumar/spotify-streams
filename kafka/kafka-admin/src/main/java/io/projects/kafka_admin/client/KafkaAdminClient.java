package io.projects.kafka_admin.client;

import io.projects.config_data.config.KafkaConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaAdminClient {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminClient.class);
    private KafkaAdminClient adminClient;
    private KafkaConfigData kafkaConfigData;

    public KafkaAdminClient(KafkaAdminClient adminClient, KafkaConfigData kafkaConfigData) {
        this.adminClient = adminClient;
        this.kafkaConfigData = kafkaConfigData;
    }
}
