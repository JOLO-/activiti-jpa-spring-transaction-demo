package name.krestjaninoff.activiti.hello.process;

import name.krestjaninoff.activiti.hello.core.Engine;
import name.krestjaninoff.activiti.hello.db.Client;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Session;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;

@Service
public class CreateClientService implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
        Client client = new Client();
        client.setFirstName("Rodrigo");

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Engine engine = (Engine) applicationContext.getBean("engine");
        JpaTransactionManager transactionManager = engine.getTransactionManager();
        EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();
        em.persist(client);
        execution.setVariable("client", client);
        execution.setVariable("clientName", client.getFirstName());
        em.getTransaction().rollback();
	}
}