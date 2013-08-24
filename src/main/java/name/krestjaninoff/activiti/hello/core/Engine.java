package name.krestjaninoff.activiti.hello.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    @Autowired
    @Qualifier("transactionManager")
    private JpaTransactionManager transactionManager;

    public JpaTransactionManager getTransactionManager() {
        return transactionManager;
    }
}