package activemq.backend.producer;

import activemq.backend.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TopicsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Topic topic;

    public void sendMessage(Product product) {
        try{
            System.out.println("TOPIC "+topic);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(product);
            System.out.println(json);
            jmsTemplate.convertAndSend("library", json);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
