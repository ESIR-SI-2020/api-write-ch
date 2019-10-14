package user.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;
import user.models.KafkaConsumer;
import user.models.KafkaProducer;
import user.models.ModifiedPasswordResponse;
import user.models.User;
import user.services.UserService;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private KafkaConsumer receiver;

    @Autowired
    private KafkaProducer sender;

    public void sendModifiedPasswordEvent(String email, String newPassword) throws InterruptedException {
        ModifiedPasswordResponse response = new ModifiedPasswordResponse(email, newPassword);
        sender.send(response);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        System.out.println("Si reçu, le consommateur renverra le nombre 0 : " + receiver.getLatch());
    }
}
