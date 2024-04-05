package activemq.backend.controller;

import activemq.backend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class TipesController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/multicast")
    public String sendMultiCastMessage(@RequestParam("message") String message) {
        jmsTemplate.convertAndSend("products", message);
        return "Multicast message sent successfully";
    }

    @GetMapping("/anycast")
    private String sendAnyCastMessage(@RequestParam("message") String message){
        jmsTemplate.convertAndSend("clients", message);
        return "Anycast message sent successfully";
    }

    @PostMapping("/user")
    public String sendUser(@RequestBody User user) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(user);
            jmsTemplate.convertAndSend("users", json);
            return "User sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send user";
        }

    }

    @GetMapping("/payment")
    public String sendPayment(@RequestParam("price") String price) {
        try {
            jmsTemplate.convertAndSend("payments", price);
            return "Payment sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send payment";
        }

    }



}
