import javassist.ClassPath;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        ((AbstractApplicationContext)context).registerShutdownHook();
        System.in.read();
    }
}
