package user.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;
import user.config.KafkaProducerConfig;
import user.config.KafkaTopicConfig;
import user.models.Event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Service
public class KafkaProducer {

   /* private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate = kafkaProducerConfig.kafkaTemplate();

    public void send(ModifiedPasswordResponse payload) throws IOException {
        File fichier =  new File("tmp/response.ser") ;
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fichier));
        obj.writeObject(payload);
        LOGGER.info("sending payload='{}'", payload);
        kafkaTemplate.send(payload.eventName, payload);
    }*/

    private final KafkaTopicConfig kafkaTopicConfig;
    private final KafkaTemplate<String, Event> kafkaTemplate;

    public KafkaProducer(
            @Autowired KafkaTemplate<String, Event> kafkaTemplate,
            @Autowired KafkaTopicConfig kafkaTopicConfig
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopicConfig = kafkaTopicConfig;
    }

    public ListenableFuture<SendResult<String, Event>> produce(Event event) {
        return this.kafkaTemplate.send(this.kafkaTopicConfig.TOPIC, event);
    }

    public ListenableFuture<SendResult<String, Event>> produceObject(Object event) {
        return Event.of(event)
                .map(this::produce)
                .orElseGet(() -> {
                    SettableListenableFuture<SendResult<String, Event>> error = new SettableListenableFuture<>();
                    error.setException(new RuntimeException());
                    error.cancel(true);
                    return error;
                });
    }
}