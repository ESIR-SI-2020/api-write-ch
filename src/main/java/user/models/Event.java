package user.models;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import user.common.Json;

@Value
public class Event {

    String eventName;
    String body;

    public Event(String simpleName, String writeValueAsString) {
    }

    public static Optional<Event> of(Object event) {
        try {
            return Optional.of(new Event(event.getClass().getSimpleName(), Json.MAPPER.writeValueAsString(event)));
        } catch (JsonProcessingException e) {
            // TODO handle the error precisely, maybe retry
            e.printStackTrace();
            return Optional.empty();
        }
    }

}