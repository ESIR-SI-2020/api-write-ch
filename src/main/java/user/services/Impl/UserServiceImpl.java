package user.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.models.ModifiedPasswordResponse;
import user.services.KafkaConsumer;
import user.services.KafkaProducer;
import user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private KafkaConsumer receiver;

    @Autowired
    private KafkaProducer sender;

    public void sendModifiedPasswordEvent(String email, String newPassword){
        ModifiedPasswordResponse response = new ModifiedPasswordResponse(email, newPassword);
        sender.send(response);
        receiver.getLatch();//.await(10000, TimeUnit.MILLISECONDS);
        System.out.println("Si reçu, le consommateur renverra le nombre 0 : " + receiver.getLatch().getCount());
    }
}
