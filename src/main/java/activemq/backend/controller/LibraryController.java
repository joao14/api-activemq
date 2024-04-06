package activemq.backend.controller;

import activemq.backend.models.Product;
import activemq.backend.producer.TopicsProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class LibraryController {


    @Autowired
    private TopicsProducer topicsProducer;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/products")
    public String sendProduct(@RequestBody Product product) {
        topicsProducer.sendMessage(product);
        return "Product sent successfully to library";
    }

}
