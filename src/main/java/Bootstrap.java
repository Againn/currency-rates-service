import javassist.ClassPath;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class Bootstrap {
    public static void main(String[] args) throws Exception {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        ((AbstractApplicationContext)context).registerShutdownHook();
        ShutdownLatch latch = new ShutdownLatch("your_domain_for_mbeans");
        latch.await();*/
        Integer a=new Integer(1);
        Integer b=new Integer(1);
        System.out.println(a==b);
        Integer a1=new Integer(11111);
        Integer b1=new Integer(11111);
        System.out.println(a1==b1);


        Object object=new Object();
        String str1="hello";
        String str2=new String("world");
        int i1=0;
        WeakReference<Object> weakReference = new WeakReference<Object>(object);
        WeakReference<Object> weakReferenceStr1 = new WeakReference<Object>(str1);
        WeakReference<Object> weakReferenceStr2 = new WeakReference<Object>(str2);
        WeakReference<Object> weakReferenceInt1 = new WeakReference<Object>(i1);
        object = null;
        str1 = null;
        str2=null;
        System.gc();
        System.out.println("after system.gc---weakReference = " + weakReference.get());
        System.out.println("after system.gc---weakReferenceStr1 = " + weakReferenceStr1.get());
        System.out.println("after system.gc---weakReferenceStr2 = " + weakReferenceStr2.get());
        System.out.println("after system.gc---weakReferenceInt1 = " + weakReferenceInt1.get());
    }
}