package user.services.Impl;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;
import user.models.User;
import user.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    public void sendModifiedPasswordEvent(String eventName, Long userId, String newPassword) {

    }
}
