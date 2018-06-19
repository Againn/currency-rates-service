import javassist.ClassPath;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        ((AbstractApplicationContext)context).registerShutdownHook();
        ShutdownLatch latch = new ShutdownLatch("your_domain_for_mbeans");
        latch.await();
    }
}