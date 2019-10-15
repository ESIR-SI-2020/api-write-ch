package user.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;


@Configuration
public class KafkaTopicConfig {
/*
    @Value(value = "localhost")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public ModifiedPasswordResponse responseTopic() {
        return new ModifiedPasswordResponse();
    }
*/
    @Value(value = "${kafka.bootstrapAddress}")
    public String BOOTSTRAP_ADDRESS;

    @Value(value = "${kafka.topic}")
    public String TOPIC;

    @Value(value = "${kafka.groupId}")
    public String GROUP_ID;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDRESS);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic mainTopic() {
        return new NewTopic(TOPIC, 1, (short) 1);
    }
}
