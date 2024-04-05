package activemq.backend.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AnycastConsumer {

    @JmsListener(destination = "clients")
    public void receiveMessage(String message) {
        System.out.println("ANYCAST [clients]=> Received message del topic: " + message);
    }

}
