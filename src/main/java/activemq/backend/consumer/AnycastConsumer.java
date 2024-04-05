package activemq.backend.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.stereotype.Component;

@Component
public class AnycastConsumer {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @JmsListener(destination = "clients")
    public void receiveMessage(String message) {
        System.out.println("ANYCAST [clients]=> Received message del topic: " + message);
    }

    @JmsListener(destination = "payments")
    public void receivePay(String price) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            System.out.println("EXAMPLEeee => Received message payment: " + price);
            int result = 1 / 0;
            System.out.println("Resultado: "+result);

            transactionManager.commit(status);

        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
    }

}
