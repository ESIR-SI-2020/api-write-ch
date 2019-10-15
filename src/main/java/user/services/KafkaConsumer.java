package user.services;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import user.models.ModifiedPasswordResponse;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER =
                LoggerFactory.getLogger(KafkaConsumer.class);

        private CountDownLatch latch = new CountDownLatch(1);

        public CountDownLatch getLatch() {
            return latch;
        }

        @KafkaListener(topics = "ModifiedPasswordResponse")
        public void receive(ModifiedPasswordResponse payload) {
            LOGGER.info("received payload='{}'", payload.getEventName() + " ; " + "email : "+ payload.getEmail() + "new Password : " + payload.getNewPassword());
            latch.countDown();
        }
}
