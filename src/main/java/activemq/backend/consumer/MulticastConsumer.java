package activemq.backend.consumer;

import activemq.backend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MulticastConsumer {

    @JmsListener(destination = "products", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("MULTICAST [products]=> Received message del topic: " + message);
    }

    @JmsListener(destination = "users", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessageUsers(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(json, User.class);
            System.out.println("Received user: " + user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
