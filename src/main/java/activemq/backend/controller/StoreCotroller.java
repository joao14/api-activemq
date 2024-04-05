package activemq.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StoreCotroller {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/publish")
    private String getSaludo(@RequestParam("message") String message){
        jmsTemplate.convertAndSend("store", message);
        return "Message sent successfully";
    }

    @GetMapping("/receive")
    public String receiveMessage() {
        return (String) jmsTemplate.receiveAndConvert("store");
    }



}
