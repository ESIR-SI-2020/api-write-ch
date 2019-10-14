package user.models;

import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.kafka.core.KafkaTemplate;

public class KafkaProducer {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, ModifiedPasswordResponse> kafkaTemplate;

    public void send(ModifiedPasswordResponse payload) {
        LOGGER.info("sending payload='{}'", payload);
        kafkaTemplate.send(payload.eventName, payload);
    }
}