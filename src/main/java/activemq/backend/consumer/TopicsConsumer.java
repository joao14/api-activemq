package activemq.backend.consumer;

import activemq.backend.models.Product;
import activemq.backend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicsConsumer {

    @JmsListener(destination = "library", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.readValue(json, Product.class);
            System.out.println("Received product to library => " + product.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
