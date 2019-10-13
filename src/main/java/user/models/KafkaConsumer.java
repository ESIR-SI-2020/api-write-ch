package user.models;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {

    private static final Logger LOGGER =
                LoggerFactory.getLogger(KafkaConsumer.class);

        private CountDownLatch latch = new CountDownLatch(1);

        public CountDownLatch getLatch() {
            return latch;
        }

        @KafkaListener(topics = "User")
        public void receive(String payload) {
            LOGGER.info("received payload='{}'", payload);
            latch.countDown();
        }
}
