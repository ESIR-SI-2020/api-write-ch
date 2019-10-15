
import java.util.concurrent.TimeUnit;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import user.UserApplication;
import user.services.KafkaConsumer;
import user.services.KafkaProducer;
import user.models.ModifiedPasswordResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@DirtiesContext
@EmbeddedKafka(partitions = 1,
        topics = {SpringKafkaApplicationTest.HELLOWORLD_TOPIC})
public class SpringKafkaApplicationTest {

    static final String HELLOWORLD_TOPIC = "ModifiedPasswordResponse";

    private KafkaConsumer receiver = new KafkaConsumer();

    private KafkaProducer sender = new KafkaProducer();

    @Test
    public void testReceive() throws Exception {
        ModifiedPasswordResponse response = new ModifiedPasswordResponse("test","test");
        sender.send(response);

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
       Assertions.assertTrue(receiver.getLatch().getCount() == 0);
    }
}